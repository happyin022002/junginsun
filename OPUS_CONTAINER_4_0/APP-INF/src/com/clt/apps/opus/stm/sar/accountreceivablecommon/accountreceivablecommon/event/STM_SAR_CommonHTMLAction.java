/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : STM_SAR_CommonHTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARExrateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AROfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.MiscLimitCondVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCommonSC로 실행요청<br>
 * - AccountReceivableCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSarCommonEvent 참조
 * @since J2EE 1.4
 */

public class STM_SAR_CommonHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * STM_SAR_CommonHTMLAction 객체를 생성
	 */
	public STM_SAR_CommonHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	StmSarCommonEvent event = new StmSarCommonEvent();
		

		if(command.isCommand(FormCommand.SEARCH01)) {								
			event.setARExrateVO((ARExrateVO)getVO(request, ARExrateVO .class));
			
		} else if(command.isCommand(FormCommand.SEARCH02)) {								
			event.setEffDt(request.getParameter("eff_dt"));
			event.setOfcCd(request.getParameter("ofc_cd"));
			event.setSysDivCd(request.getParameter("sys_div_cd"));
		} else if(command.isCommand(FormCommand.SEARCH03)) {	
			event.setOfcLvlTp(request.getParameter("ofc_lvl_tp"));		
			event.setOfcBrncAgnTpCd(request.getParameter("ofc_brnc_agn_tp_cd"));
		} else if(command.isCommand(FormCommand.SEARCH04)) {								
			event.setAROfficeListVO((AROfficeListVO)getVO(request, AROfficeListVO .class));	
		} else if(command.isCommand(FormCommand.SEARCH05)) {								
			event.setAcctCtnt(request.getParameter("acct_ctnt"));
			event.setAcctCtnt2(request.getParameter("acct_ctnt2"));
			event.setAcctCtnt3(request.getParameter("acct_ctnt3"));
			event.setAcctCtnt4(request.getParameter("acct_ctnt4"));
			event.setOfcCd(request.getParameter("ots_ofc_cd"));	// 2014.08.19 add ofc_cd
		} else if(command.isCommand(FormCommand.SEARCH06)) {								
			event.setCustCntCd(request.getParameter("cust_cnt_cd"));
			event.setCustSeq(request.getParameter("cust_seq"));
			event.setCustUseFlg(JSPUtil.getParameter(request, "cust_use_flg" , "")); 
	
		} else if(command.isCommand(FormCommand.SEARCH08)) {								
			event.setCurrCd(request.getParameter("curr_cd"));
		} else if(command.isCommand(FormCommand.SEARCH09)) {								
			event.setCurrCd(request.getParameter("rhq_cd"));
		} else if(command.isCommand(FormCommand.SEARCH10)) {								
			event.setCurrCd(request.getParameter("acct_cd"));
		} else if(command.isCommand(FormCommand.SEARCH11)) {								
			event.setArRhqCd(request.getParameter("ar_rhq_cd"));
		} else if(command.isCommand(FormCommand.SEARCH13)) {		//2014.08.25 add
			event.setMiscLimitCondVO((MiscLimitCondVO)getVO(request, MiscLimitCondVO .class));
		} else if(command.isCommand(FormCommand.SEARCH14)) {	
			event.setOfcLvlTp(request.getParameter("ofc_lvl_tp")); 		
			event.setOfcBrncAgnTpCd(request.getParameter("ofc_brnc_agn_tp_cd")); 
		} else if(command.isCommand(FormCommand.SEARCH15)) { 	
			event.setOfcCd(request.getParameter("ofc_cd")); 		
			event.setAcctCd(request.getParameter("acct_ctnt"));  
		} else if(command.isCommand(FormCommand.SEARCH16)) {	
			event.setOfcLvlTp(request.getParameter("ofc_lvl_tp")); 		
			event.setOfcBrncAgnTpCd(request.getParameter("ofc_brnc_agn_tp_cd")); 
		} else if(command.isCommand(FormCommand.SEARCH17)) { 	
			event.setOfcCd(request.getParameter("ofc_cd"));		
		}

		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}