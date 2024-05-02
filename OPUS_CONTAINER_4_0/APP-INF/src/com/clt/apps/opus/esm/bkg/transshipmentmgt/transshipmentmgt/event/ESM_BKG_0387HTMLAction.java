/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0387HTMLAction.java
*@FileTitle : Next VVD Assign I (by VVD POD)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.15 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdAssignInputVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.transshipmentmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TransshipmentMgtSC로 실행요청<br>
 * - TransshipmentMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Yeoung Hee
 * @see TransshipmentMgtEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0387HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0387HTMLAction 객체를 생성
	 */
	public ESM_BKG_0387HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TransshipmentMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0387Event event = new EsmBkg0387Event();
		
		String[] ibflag=null;
		String[] ibflagNext=null;
		String[] chk = null;
		String[] chkNext = null;
		String[] formerVvd=null;
		String[] podYdCd = null;
		String[] nextPort = null;
		String[] etbTo=null;
		String[] formerClptIndSeq=null;
		String nextForVvd=null;

		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setNextVvdAssignInputVO((NextVvdAssignInputVO)getVO(request, NextVvdAssignInputVO.class));
		}else if(command.isCommand(FormCommand.COMMAND01)){ //former VVD의 ROW CLICK
			ibflag= request.getParameterValues("sheet1_ibflag");
			chk= request.getParameterValues("sheet1_chk");
			formerVvd= request.getParameterValues("sheet1_former_vvd");
			podYdCd= request.getParameterValues("sheet1_pod_yd_cd"); 
			event.setNextVvdAssignInputVO((NextVvdAssignInputVO)getVO(request, NextVvdAssignInputVO.class));
			
			for(int i=0;i<ibflag.length;i++){
				if (chk[i].equals("1")){
					event.getNextVvdAssignInputVO().setFormerVvd(formerVvd[i]); 
					if (podYdCd[i].length()==7)
						event.getNextVvdAssignInputVO().setRelayPortYardCd(podYdCd[i]);
				}
			}
			
		}else if(command.isCommand(FormCommand.COMMAND02)){ //Next VVD의 ROW CLICK
			nextForVvd=request.getParameter("nextVvdFor");
			ibflag= request.getParameterValues("sheet1_ibflag");
			ibflagNext= request.getParameterValues(nextForVvd+"ibflag");
			chk= request.getParameterValues("sheet1_chk");
			chkNext= request.getParameterValues(nextForVvd+"chk");
			formerVvd= request.getParameterValues("sheet1_former_vvd");
			podYdCd= request.getParameterValues("sheet1_pod_yd_cd");
			nextPort= request.getParameterValues(nextForVvd+"next_port");
			etbTo= request.getParameterValues("sheet1_etb");
			formerClptIndSeq= request.getParameterValues("sheet1_former_clpt_ind_seq");
			event.setNextVvdAssignInputVO((NextVvdAssignInputVO)getVO(request, NextVvdAssignInputVO.class));
			
			for(int i=0;i<ibflag.length;i++){
				if (chk[i].equals("1")){
					event.getNextVvdAssignInputVO().setFormerVvd(formerVvd[i]);
					event.getNextVvdAssignInputVO().setRelayPortYardCd(podYdCd[i]);
					event.getNextVvdAssignInputVO().setEtbTo(etbTo[i]);
					event.getNextVvdAssignInputVO().setFormerClptIndSeq(formerClptIndSeq[i]);
				}
			}
			for(int i=0;i<ibflagNext.length;i++){
				if (chkNext[i].equals("1")){
					if (nextForVvd.equals("t1sheet1_")){
						event.getNextVvdAssignInputVO().setNextPort(nextPort[i].substring(0,5));
					}else{
						event.getNextVvdAssignInputVO().setNextPort(nextPort[i]);  
					}
				}
			}
		}else if(command.isCommand(FormCommand.COMMAND03) || command.isCommand(FormCommand.COMMAND04)){  // Cancel VVD Assign 
			int length =request.getParameterValues("sheet3_ibflag").length;
			String[] sChk = JSPUtil.getParameter(request, "sheet3_chk", length);
			String[] bkgNo = JSPUtil.getParameter(request, "sheet3_bkg_no", length); 
			String[] strFormerVVD = JSPUtil.getParameter(request,"sheet3_former_vvd", length);
			String[] strNextVVD = JSPUtil.getParameter(request,"sheet3_next_vvd", length);
			String[] oopCd = JSPUtil.getParameter(request,"sheet3_op_cd", 1);
			String[] nextTmnl = JSPUtil.getParameter(request,"sheet3_next_tmnl", 1);
			String[] nextSeq = JSPUtil.getParameter(request,"sheet3_next_seq", 1);

			event.setRelay(JSPUtil.getParameter(request, "oldRelayPort"));
			BkgBlNoVO[] bkgBlNoVOs = new BkgBlNoVO[length]; 
			for(int i=0;i<length;i++){
				if (sChk[i].equals("1")){
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
					bkgBlNoVO.setBkgNo(bkgNo[i]);
					bkgBlNoVOs[i]=bkgBlNoVO;
					if(command.isCommand(FormCommand.COMMAND03)){
						event.setNextVvd("COXX0001E");
					}else{
						event.setNextVvd(strNextVVD[i]);
					}
					event.setFormerVvd(strFormerVVD[i]);
					event.setBkgBlNoVO(bkgBlNoVOs[i]);
					event.setOopCd(oopCd[0]);
					event.setNextTmnl(nextTmnl[0]);
					event.setNextSeq(nextSeq[0]);
					break;
				}
			}

		}else if(command.isCommand(FormCommand.COMMAND05)||command.isCommand(FormCommand.DEFAULT)){
			event.setRelay(JSPUtil.getParameter(request, "relay"));
			event.setEtbFrom(JSPUtil.getParameter(request, "etbFrom"));
			event.setEtbTo(JSPUtil.getParameter(request, "etbTo"));
			event.setNextVvd(JSPUtil.getParameter(request, "nextVvd"));
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