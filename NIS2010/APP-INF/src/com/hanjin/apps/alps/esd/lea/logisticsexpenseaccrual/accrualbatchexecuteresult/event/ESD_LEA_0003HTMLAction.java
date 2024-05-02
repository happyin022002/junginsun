/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_LEA_003HTMLAction.java
*@FileTitle : Accrual Batch Result by Account Code (Tab1)
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-13
*@LastModifier : Park Yeon Jin
*@LastVersion : 1.0
* 2007-02-13 Park Yeon Jin
* =======================================================
* 2009-08-03 ALPS New Framework 적용
* 
* 
* 
* -------------------------------------------------------
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultAccountListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultManualInputListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LogisticsExpenseAccrualSC로 실행요청<br>
 * - LogisticsExpenseAccrualSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Park Yeon Jin
 * @see EsdLea0003Event , ESD_LEA_003EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_LEA_0003HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_LEA_003HTMLAction 객체를 생성
	 */
	public ESD_LEA_0003HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_LEA_003Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		/** 
         ibSheet 사용시 fromRequestGrid를 사용하는데 
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 ) 
         String prefix = "" ;  
         LEA_ACCT_COST_AMT lea_acct_cost_amt = LEA_ACCT_COST_AMT.fromRequestGrid(request, prefix);
        */
		
		
		
		FormCommand 	command = FormCommand.fromRequest(request);
		EsdLea0003Event	event	= new EsdLea0003Event();
		
		SearchAccrualBatchResultAccountListVO	searchAccrualBatchResultAccountListVO	= new SearchAccrualBatchResultAccountListVO();
		SearchAccrualBatchResultAccountListVO[] searchAccrualBatchResultAccountListVOs	= null;
		
		SearchAccrualBatchResultManualInputListVO	searchAccrualBatchResultManualInputListVO	= new SearchAccrualBatchResultManualInputListVO();
		SearchAccrualBatchResultManualInputListVO[]	searchAccrualBatchResultManualInputListVOs	= null;
		
		//ESD_LEA_0003.SEARCH (Retrieve:"TAB1") | SEARCH01 (Retrieve:"TAB2") ;; SHEARCH02 :sheet#2번 Loading TAB."Manual Input"
		if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02)){	
			
			String frmExeYrmon		= request.getParameter("frm_exe_yrmon"		);
			String frmRevYrmonFrom	= request.getParameter("frm_rev_yrmon_from"	);
			String frmRevYrmonTo	= request.getParameter("frm_rev_yrmon_to"	);
			String fAcctTypeA		= request.getParameter("f_acct_type_a"		);
			String fAcctTypeM		= request.getParameter("f_acct_type_m"		);
			String fAcctTypeT		= request.getParameter("f_acct_type_t"		);
			
			event.setFrmExeYrmon	(frmExeYrmon	);
			event.setFrmRevYrmonFrom(frmRevYrmonFrom);
			event.setFrmRevYrmonTo	(frmRevYrmonTo	);
			event.setFAcctTypeA		(fAcctTypeA		);
			event.setFAcctTypeM		(fAcctTypeM		);
			event.setFAcctTypeT		(fAcctTypeT		);
			
		//ESD_LEA_0003.MODIFY "TAB.Result_By_Account_Code" (Button.Confirm)
		}else if(command.isCommand(FormCommand.MODIFY)){	
			
			String frmExeYrmon		= request.getParameter("frm_exe_yrmon"		);
			String frmRevYrmonFrom	= request.getParameter("frm_rev_yrmon_from"	);
			String frmRevYrmonTo	= request.getParameter("frm_rev_yrmon_to"	);
			String fAcctTypeA		= request.getParameter("f_acct_type_a"		);
			String fAcctTypeM		= request.getParameter("f_acct_type_m"		);
			String fAcctTypeT		= request.getParameter("f_acct_type_t"		);
			String frmConfirmDiv	= request.getParameter("frm_confirm_div"	);
			
			event.setFrmExeYrmon	(frmExeYrmon	);
			event.setFrmRevYrmonFrom(frmRevYrmonFrom);
			event.setFrmRevYrmonTo	(frmRevYrmonTo	);
			event.setFAcctTypeA		(fAcctTypeA		);
			event.setFAcctTypeM		(fAcctTypeM		);
			event.setFAcctTypeT		(fAcctTypeT		);
			event.setFrmConfirmDiv	(frmConfirmDiv	);
			
			searchAccrualBatchResultAccountListVOs			= searchAccrualBatchResultAccountListVO.fromRequestGrid(request);
			event.setSearchAccrualBatchResultAccountListVOs(searchAccrualBatchResultAccountListVOs);
			
		//ESD_LEA_0003.COMMAND01 "TAB.Result_By_Account_Code" (Button.Send Mail)
		}else if(command.isCommand(FormCommand.COMMAND01)){	
			
			String frmExeYrmon		= request.getParameter("frm_exe_yrmon"		);
			String frmRevYrmonFrom	= request.getParameter("frm_rev_yrmon_from"	);
			String frmRevYrmonTo	= request.getParameter("frm_rev_yrmon_to"	);
			String fAcctTypeA		= request.getParameter("f_acct_type_a"		);
			String fAcctTypeM		= request.getParameter("f_acct_type_m"		);
			String fAcctTypeT		= request.getParameter("f_acct_type_t"		);
			
			event.setFrmExeYrmon	(frmExeYrmon	);
			event.setFrmRevYrmonFrom(frmRevYrmonFrom);
			event.setFrmRevYrmonTo	(frmRevYrmonTo	);
			event.setFAcctTypeA		(fAcctTypeA		);
			event.setFAcctTypeM		(fAcctTypeM		);
			event.setFAcctTypeT		(fAcctTypeT		);
			
		//ESD_LEA_0003.MULTI "TAB.Manual_Input"(Button.Save)
		}else if(command.isCommand(FormCommand.MULTI)){	
			
			String frmExeYrmon		= request.getParameter("frm_exe_yrmon"		);
			String frmRevYrmonFrom	= request.getParameter("frm_rev_yrmon_from"	);
			String frmRevYrmonTo	= request.getParameter("frm_rev_yrmon_to"	);
			String fAcctTypeA		= request.getParameter("f_acct_type_a"		);
			String fAcctTypeM		= request.getParameter("f_acct_type_m"		);
			String fAcctTypeT		= request.getParameter("f_acct_type_t"		);
			String frmConfirmDiv	= request.getParameter("frm_confirm_div"	);
			
			
			event.setFrmExeYrmon	(frmExeYrmon	);
			event.setFrmRevYrmonFrom(frmRevYrmonFrom);
			event.setFrmRevYrmonTo	(frmRevYrmonTo	);
			event.setFAcctTypeA		(fAcctTypeA		);
			event.setFAcctTypeM		(fAcctTypeM		);
			event.setFAcctTypeT		(fAcctTypeT		);
			event.setFrmConfirmDiv	(frmConfirmDiv	);
			
			searchAccrualBatchResultManualInputListVOs			= searchAccrualBatchResultManualInputListVO.fromRequestGrid(request);
			event.setSearchAccrualBatchResultManualInputListVOs(searchAccrualBatchResultManualInputListVOs);
			
		}

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}