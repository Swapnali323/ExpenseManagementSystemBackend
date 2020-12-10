package com.cg.ClaimQueryService;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
 
@CrossOrigin(origins = "*")
@RestController
@Api(value="ClaimQueryService demo using logger and swagger")
public class ClaimQueryServiceController {

	@Autowired
	private ClaimQueryServiceProxy claimProxy;
	
	@Autowired
    SpringTemplateEngine templateEngine;

    @Autowired
    private JavaMailSender sender;

	
	
	@Autowired
	private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimQueryServiceController.class);
	
	
	/***************************************retrieve all claims *///////////////////////
	@HystrixCommand(fallbackMethod = "alternateclaimList")
	@ApiOperation(value = "getClaims", nickname = "getClaims") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ExpenseClaim.class), 
	@ApiResponse(code = 500, message = "Failure", response = ExpenseClaim.class)})
	@GetMapping(path="/getclaims")
	public List<ExpenseClaim> getClaims()
	{
		List<ExpenseClaim> claimslist=claimProxy.getclaims();
		if (claimslist.size()<1)
		{
			throw new RuntimeException("no claims available");
		}
		return claimslist;
	}
	
	
	/***************************************fall back method for retrieve all claims *///////////////////////
	
	public List<ExpenseClaim> alternateclaimList()
	{ 
		logger.info("\"Due to Exception, the fallbackmethod for get all claims has been invoked by Hystrix");
		System.out.println("inside alternateMethod"); 
		Date date = new Date();
		List<ExpenseClaim> tempList=new ArrayList<ExpenseClaim>();
		ExpenseClaim claim1=new ExpenseClaim(121,222,333,444,25000);
		ExpenseClaim claim2=new ExpenseClaim(122,111,897,635,6000);
		tempList.add(claim1);
		tempList.add(claim2);
		return tempList;
	}
	
	
	
	
	/*************************************** search an claim ********************************/
	@ApiOperation(value = "searchClaim", nickname = "searchClaim") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ExpenseClaim.class), 
	@ApiResponse(code = 500, message = "Failure", response = ExpenseClaim.class)})
	@GetMapping("/searchclaim")
	public List<ExpenseClaim> searchClaim(@RequestParam("claimId") int claimId)
	{
		List<ExpenseClaim> claim=claimProxy.searchcClaim(claimId);
		return claim;
	}
	
	
	/*************************************** get employee wise claims ********************************/
	@ApiOperation(value = "getEmployeeWiseClaims", nickname = "getEmployeeWiseClaims") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ExpenseClaim.class), 
	@ApiResponse(code = 500, message = "Failure", response = ExpenseClaim.class)})
	@GetMapping("/employeewiseclaims")
	public List<ExpenseClaim> getEmployeeWiseClaims(@RequestParam("employeeId") int employeeId)
	{
		List<ExpenseClaim> claim=claimProxy.getEmployeeWiseClaims(employeeId);
		return claim;
	}
	
	
	/***************************************retrieve all approvals *///////////////////////
	@HystrixCommand(fallbackMethod = "alternateclaimList")
	@ApiOperation(value = "getApprovals", nickname = "getApprovals") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Approval.class), 
	@ApiResponse(code = 500, message = "Failure", response = Approval.class)})
	@GetMapping(path="/getapprovals")
	public List<Approval> getApprovals()
	{
		List<Approval> approvals=claimProxy.getapprovals();
		if (approvals.size()<1)
		{
			throw new RuntimeException("no approvals available");
		}
		return approvals;
	}
	
	/*************************************** search an approval ********************************/
	@ApiOperation(value = "searchApproval", nickname = "searchApproval") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Approval.class), 
	@ApiResponse(code = 500, message = "Failure", response = Approval.class)})
	@GetMapping("/searchapproval")
	public List<Approval> searchApproval(@RequestParam("claimId") int claimId)
	{
		List<Approval> approval=claimProxy.searchApproval(claimId);
		return approval;
	}
	/*************************************** get employee wise approvals ********************************/
	@ApiOperation(value = "getEmployeeWiseApprovals", nickname = "getEmployeeWiseApprovals") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Approval.class), 
	@ApiResponse(code = 500, message = "Failure", response = Approval.class)})
	@GetMapping("/employeewiseapprovals")
	public List<Approval> getEmployeeWiseApprovals(@RequestParam("employeeId") int employeeId)
	{
		List<Approval> approval=claimProxy.getEmployeeWiseApprovals(employeeId);
		return approval;
	}
	
	/*************************************** send email on approval ********************************/
	@ApiOperation(value = "sendEmail", nickname = "sendEmail") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Approval.class), 
	@ApiResponse(code = 500, message = "Failure", response = Approval.class)})
	@GetMapping("/sendmail")
	public @ResponseBody void sendEmail(@RequestParam("mail") String mail,@RequestParam("claimid") int claimid)throws Exception
	{
		List<Approval> approval=claimProxy.searchApproval(claimid);
		Map<String, Object> model = new HashMap<String, Object>();
		for (Approval app : approval) {
			model.put("EmployeeId",app.getEmployeeId());
	        model.put("ClaimId",app.getExpenseClaimId());
	        model.put("ExpenseCode",app.getExpenseCode());
	        model.put("ProjectCode",app.getProjectCode());
	        model.put("ClaimStatus",app.getStatus());
		}
		 
		Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);
	        
	        
	        
		 MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message,
	                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
	                StandardCharsets.UTF_8.name());

	        try {
	            helper.setTo(mail);
	            helper.setText(html,true);
	            helper.setSubject("Expense Claim Status");
	          /*  File file=new File("D:\\temptest.txt");
	            helper.addAttachment("temptest.txt", file);*/
	        } catch (javax.mail.MessagingException e) {
	            e.printStackTrace();
	        }
	        sender.send(message);

	        
	}
	
}
