/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0045HTMLAction.java
*@FileTitle : (Korea) Samsung Invoice EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.13
*@LastModifier : 김상현
*@LastVersion : 1.1
* 2009.10.05 박정진 1.0 Creation
* 2012.07.13 김상현 1.1 [CHM-201218835] (Korea) Samsung Invoice EDI > Invoice No. Numbering 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDIBLChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDISendVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIHeaderVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIVO;
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
 * @author Jung Jin Park
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0045HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0045HTMLAction 객체를 생성
	 */
	public FNS_INV_0045HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0045Event event = new FnsInv0045Event();
		SamsungInPutVO samsungInPutVO = new SamsungInPutVO();
		SamsungInvoiceEDIVO samsungInvoiceEDIVO = new SamsungInvoiceEDIVO();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			String actCustCntCd = request.getParameter("act_cust_cnt_cd");
			String actCustSeq = request.getParameter("act_cust_seq");
			String vvd = request.getParameter("vvd");
			String revisedAmount = "";
			if (isNull(request.getParameter("revised_amount"))) {
				revisedAmount = "";
			}
			else {
				revisedAmount = request.getParameter("revised_amount");
			}
			String rcvrId = request.getParameter("rcvr_id");
			
			String vslCd = "";
			String skdVoyNo = "";
			String skdDirCd = "";
			
			samsungInPutVO.setActCustCntCd(actCustCntCd);
			samsungInPutVO.setActCustSeq(actCustSeq);
			
			if (vvd.length() == 9) {
				vslCd = vvd.substring(0, 4);
				skdVoyNo = vvd.substring(4, 8);
				skdDirCd = vvd.substring(8, 9);
			}
			samsungInPutVO.setVslCd(vslCd);
			samsungInPutVO.setSkdVoyNo(skdVoyNo);
			samsungInPutVO.setSkdDirCd(skdDirCd);
			samsungInPutVO.setRevisedAmount(revisedAmount);
			samsungInPutVO.setRcvrId(rcvrId);
			
			event.setSamsungInPutVO(samsungInPutVO);
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			String msgId = request.getParameter("msg_id");
			String msgNo = request.getParameter("msg_no");
			
			event.setMsgId(msgId);
			event.setMsgNo(msgNo);
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			//Header
			SamsungInvoiceEDIHeaderVO samsungInvoiceEDIHeaderVO = (SamsungInvoiceEDIHeaderVO)getVO(request, SamsungInvoiceEDIHeaderVO.class);
			
			String actCustCntCd = request.getParameter("act_cust_cnt_cd");
			String actCustSeq = request.getParameter("act_cust_seq");
			String vvd = request.getParameter("vvd");
			
			String vslCd = "";
			String skdVoyNo = "";
			String skdDirCd = "";
			
			samsungInvoiceEDIHeaderVO.setCustCntCd(actCustCntCd);
			samsungInvoiceEDIHeaderVO.setCustSeq(actCustSeq);
			
			if (vvd.length() == 9) {
				vslCd = vvd.substring(0, 4);
				skdVoyNo = vvd.substring(4, 8);
				skdDirCd = vvd.substring(8, 9);
			}
			samsungInvoiceEDIHeaderVO.setVslCd(vslCd);
			samsungInvoiceEDIHeaderVO.setSkdVoyNo(skdVoyNo);
			samsungInvoiceEDIHeaderVO.setSkdDirCd(skdDirCd);
			String forceToSave = request.getParameter("force_to_save");
			if (forceToSave == null || forceToSave.equals("")) {
				samsungInvoiceEDIHeaderVO.setForceToSave("N");
			} else {
				samsungInvoiceEDIHeaderVO.setForceToSave(forceToSave);
			}
			
			samsungInvoiceEDIVO.setSamsungInvoiceEDIHeader(samsungInvoiceEDIHeaderVO);
			
			//B/L & CHARGE LIST
			SamsungEDIBLChargeVO[] arrSamsungEDIBLCharge = (SamsungEDIBLChargeVO[]) getVOs(request, SamsungEDIBLChargeVO.class , "sheet1_");
			if(arrSamsungEDIBLCharge != null) {
				List<SamsungEDIBLChargeVO> samsungEDIBLChargeList = Arrays.asList(arrSamsungEDIBLCharge);
				samsungInvoiceEDIVO.setSamsungEDIBLChargeList(samsungEDIBLChargeList);
			}
			
			event.setSamsungInvoiceEDIVO(samsungInvoiceEDIVO);
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			String msgId = request.getParameter("msg_id");
			String msgNo = request.getParameter("msg_no");
			
			event.setMsgId(msgId);
			event.setMsgNo(msgNo);
		}
		else if(command.isCommand(FormCommand.MULTI03)) {
			List<SamsungEDISendVO> samsungEDISendList = new ArrayList<SamsungEDISendVO>();
			
			String msgId = request.getParameter("msg_id");
			String msgNo = request.getParameter("msg_no");
			String updUsrId = request.getParameter("upd_usr_id");
			event.setSendStartIdx(request.getParameter("send_start_idx"));
			
			//B/L & CHARGE LIST
			SamsungEDIBLChargeVO[] arrSamsungEDIBLCharge = (SamsungEDIBLChargeVO[]) getVOs(request, SamsungEDIBLChargeVO.class , "sheet1_");
			if(arrSamsungEDIBLCharge != null) {
				List<SamsungEDIBLChargeVO> samsungEDIBLChargeList = Arrays.asList(arrSamsungEDIBLCharge);
				
				for (int i=0; i<samsungEDIBLChargeList.size(); i++) {
					SamsungEDIBLChargeVO samsungEDIBLChargeVO = samsungEDIBLChargeList.get(i);
					
					SamsungEDISendVO samsungEDISendVO = new SamsungEDISendVO();
					samsungEDISendVO.setMsgId(msgId);
					samsungEDISendVO.setMsgNo(msgNo);
					samsungEDISendVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
					samsungEDISendVO.setUpdUsrId(updUsrId);
					
					samsungEDISendList.add(samsungEDISendVO);
				}
			}
			
			event.setSamsungEDISendVOs((SamsungEDISendVO[])samsungEDISendList.toArray(new SamsungEDISendVO[samsungEDISendList.size()]));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			String actCustCntCd = request.getParameter("act_cust_cnt_cd");
			String actCustSeq = request.getParameter("act_cust_seq");
			String vvd = request.getParameter("vvd");
			String blSrcNo = request.getParameter("grid_bl_src_no");
			
			String vslCd = "";
			String skdVoyNo = "";
			String skdDirCd = "";
			
			samsungInPutVO.setActCustCntCd(actCustCntCd);
			samsungInPutVO.setActCustSeq(actCustSeq);
			
			if (vvd.length() == 9) {
				vslCd = vvd.substring(0, 4);
				skdVoyNo = vvd.substring(4, 8);
				skdDirCd = vvd.substring(8, 9);
			}
			samsungInPutVO.setVslCd(vslCd);
			samsungInPutVO.setSkdVoyNo(skdVoyNo);
			samsungInPutVO.setSkdDirCd(skdDirCd);
			
			event.setSamsungInPutVO(samsungInPutVO);
			event.setBlSrcNo(blSrcNo);
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