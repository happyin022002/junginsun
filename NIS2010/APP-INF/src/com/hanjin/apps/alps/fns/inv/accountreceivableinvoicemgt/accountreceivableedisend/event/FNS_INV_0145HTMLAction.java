/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0144HTMLAction.java
*@FileTitle : EDI Submission
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.21
*@LastModifier : 백승일
*@LastVersion : 1.0
* 2015.12.21 백승일 MGB Invoice EDI 신규 개발 요청
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.MGBInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.MGBInvoiceEdiVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Do Soon
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0145HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0144HTMLAction 객체를 생성
	 */
	public FNS_INV_0145HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	FnsInv0145Event event = new FnsInv0145Event();
    	
    	if (command.isCommand(FormCommand.SEARCHLIST)) { // Searching EDI list.
			ADIDASInputVO inputVo = new ADIDASInputVO();
 
			String retrOpt = request.getParameter("retr_opt") != null ? request.getParameter("retr_opt") : "" ;
			String retrInput = request.getParameter("retr_input") != null ? request.getParameter("retr_input") : "";
			String blSrcNo = "";
			String invNo = "";
			String vvd = "";
			String fmDt = "";
			String toDt = "";
	
			if (retrOpt.equals("B")) { 
				blSrcNo = retrInput;
			} else if(retrOpt.equals("N")) { 
				invNo = retrInput;
			} else if(retrOpt.equals("V")){
				vvd = retrInput;
			} else {
				fmDt = request.getParameter("fm_dt");
				toDt = request.getParameter("to_dt");
			}
	
			String actCustCntCd = request.getParameter("cust_cnt_cd");
			String actCustSeq = request.getParameter("cust_seq");
			String ofcCd = request.getParameter("ofc_cd");
			String sentStat = request.getParameter("sent_stat");
	
			inputVo.setRetrOpt(retrOpt);
			inputVo.setActCustCntCd(actCustCntCd);
			inputVo.setActCustSeq(actCustSeq);
			inputVo.setBlSrcNo(blSrcNo);
			inputVo.setVvd(vvd);
			inputVo.setFmDt(fmDt);
			inputVo.setToDt(toDt);
			inputVo.setOfcCd(ofcCd);
			inputVo.setSentStat(sentStat);
			inputVo.setInvNo(invNo);
			
			event.setADIDASInputVO(inputVo);
			}else if(command.isCommand(FormCommand.MULTI)) {
					ADIDASInvoiceEdiVO[] adidasInvoiceEdiVOs = (ADIDASInvoiceEdiVO[])getVOs(request, ADIDASInvoiceEdiVO.class, "sheet1_");
					for (int i=0; i<adidasInvoiceEdiVOs.length; i++) {
						adidasInvoiceEdiVOs[i].setUpdUsrId(request.getParameter("upd_usr_id"));
						adidasInvoiceEdiVOs[i].setOfcCd(request.getParameter("ofc_cd"));
					}
					event.setADIDASInvoiceEdiVOs(adidasInvoiceEdiVOs);
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
	
	/**
	 * 입력된 값의 null 여부를 체크하여 boolean 으로 리턴한다.
	 * 
	 * @param String str
	 * @return boolean
	 */
	public boolean isNull(String str) {
        return (str==null || str.trim().length()==0 || "null".equals(str));
    }
}