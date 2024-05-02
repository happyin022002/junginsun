/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0018HTMLAction.java
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.01
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.15 김진일
* 1.0 Creation
* 
* History
* 2012.02.01 진마리아 CHM-201215859-01 전도금 비용 수정 기능 추가 요청건(spp로부터 입력받는 전도금을 alps 화면을 통해 수정하여 저장 가능하도록)
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.event;
		
import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeHdVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EstimateInvoiceAuditSC로 실행요청<br>
 * - EstimateInvoiceAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jin Ihl
 * @see EstimateInvoiceAuditEvent 참조
 * @since J2EE 1.6
 */

public class VOP_PSO_0018HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0018HTMLAction 객체를 생성
	 */
	public VOP_PSO_0018HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EstimateInvoiceAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0018Event event = new VopPso0018Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {//windowsopen
//			event.setPayTo(request.getParameter("vndr_seq"));
//			event.setVvd(request.getParameter("vvd"));
//			event.setCallSeq(request.getParameter("call_seq"));
			
			event.setCanalTzFeeEstDtlByVvdCondVO((CanalTzFeeEstDtlByVvdCondVO)getVO(request, CanalTzFeeEstDtlByVvdCondVO .class));//InvoiceNo생성용
		}
		else if(command.isCommand(FormCommand.MULTI01)) {//confirm button click	//[2010.05.11:jmh] COMMAND01 -> MULTI01
			event.setCanalTzFeeHdVO((CanalTzFeeHdVO)getVO(request, CanalTzFeeHdVO .class));//InvoiceNo생성용
			event.setAuditDataValidVOs((AuditDataValidVO[])getVOs(request, AuditDataValidVO.class,"sheet1_"));//Invoice생성용
//			String strDueDt = request.getParameter("due_dt");
			//AuditDataValidVOs에 필요한 정보를 셋팅한다.
			AuditDataValidVO[] vos = event.getAuditDataValidVOs();
			CanalTzFeeHdVO vo = event.getCanalTzFeeHdVO();
			vo.setCnlTzBztpCd("E");//전도금 업무설정
			if(vos!=null){
				for(int i=0;i<vos.length;i++){
					vos[i].setVvd(vo.getVvd());
					vos[i].setVndrSeq(vo.getVndrSeq());
//					vos[i].setCallSeq(vo.getCallSeq());
					//Call_seq 는 ibsheet의 값으로 합니다.
					vos[i].setCalcAmtSum(vo.getCalcAmtSum());
					vos[i].setRqstAmtSum(vo.getRqstAmtSum());
					vos[i].setRevYrmon(request.getParameter("rev_yrmon"));
				}
			}
		}
		else if(command.isCommand(FormCommand.MODIFY)) {//reject button click	//[2010.05.11:jmh] COMMAND03 -> MODIFY
			event.setCanalTzFeeEstDtlByVvdCondVO((CanalTzFeeEstDtlByVvdCondVO)getVO(request, CanalTzFeeEstDtlByVvdCondVO .class));
			event.setAuditDataValidVOs((AuditDataValidVO[])getVOs(request, AuditDataValidVO.class,"sheet1_"));//rmk update 위해 추가 2010.01.17
			event.setInvNo(request.getParameter("inv_no"));
			event.setInvRgstNo(request.getParameter("inv_rgst_no"));
			AuditDataValidVO[] vos = event.getAuditDataValidVOs();
			if(vos!=null){
				for(AuditDataValidVO vo : vos){
					vo.setRevYrmon(request.getParameter("rev_yrmon"));
				}
			}
		}
		else if(command.isCommand(FormCommand.MULTI)) {//save
			event.setCanalTzFeeHdVO((CanalTzFeeHdVO)getVO(request, CanalTzFeeHdVO .class));//vvd setting을 위해
			event.setAuditDataValidVOs((AuditDataValidVO[])getVOs(request, AuditDataValidVO.class,"sheet1_"));
		}

		request.setAttribute("Event", event);

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