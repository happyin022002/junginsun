/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0027HTMLAction.java
*@FileTitle : Ex Rate Update by Date or VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.26 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Dosoon Choi
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0027HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0027HTMLAction 객체를 생성
	 */
	public FNS_INV_0027HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0027Event event = new FnsInv0027Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			List<ExrateInputVO> exrateInputVOs = new ArrayList<ExrateInputVO>();
			String[] vvdArr = request.getParameterValues("sheet1_vvd");
			String[] blNoArr = request.getParameterValues("sheet2_bl_src_no");
			log.debug("vvd="+vvdArr);
			log.debug("bl_src_no="+blNoArr);
			
			event.setRunOpt(request.getParameter("run_opt"));
			event.setOfcCd(request.getParameter("ofc_cd"));
			
			if(request.getParameter("run_opt").equals("N")){
				ExrateInputVO exrateInputVO = new ExrateInputVO();
				
				exrateInputVO.setOfcCd(request.getParameter("ofc_cd"));
				exrateInputVO.setFmIfDt(request.getParameter("fm_if_dt"));
				exrateInputVO.setToIfDt(request.getParameter("to_if_dt"));
				exrateInputVO.setRunOpt(request.getParameter("run_opt"));
				//exrateInputVO.setBlSrcNo(request.getParameter("bl_src_no"));		
				
				event.setExrateInputVO(exrateInputVO);
				
			}else if(request.getParameter("run_opt").equals("V")){				
				for (int i = 0; i <vvdArr.length; i++) {
					ExrateInputVO exrateInputVO = new ExrateInputVO();
					
					exrateInputVO.setOfcCd(request.getParameter("ofc_cd"));
					exrateInputVO.setIoBndCd(request.getParameter("io_bnd_cd"));
					exrateInputVO.setRunOpt(request.getParameter("run_opt"));
					//exrateInputVO.setBlSrcNo(request.getParameter("bl_src_no"));	
					exrateInputVO.setVvd(vvdArr[i]);
					
					exrateInputVOs.add(exrateInputVO);
				}
				
				event.setExrateInputVOs(exrateInputVOs);
			}else if(request.getParameter("run_opt").equals("C")){
				ExrateInputVO exrateInputVO = new ExrateInputVO();
				
				exrateInputVO.setOfcCd(request.getParameter("ofc_cd"));
				exrateInputVO.setFmIfDt(request.getParameter("fm_if_dt"));
				exrateInputVO.setToIfDt(request.getParameter("to_if_dt"));
				exrateInputVO.setRunOpt(request.getParameter("run_opt"));
				//exrateInputVO.setBlSrcNo(request.getParameter("bl_src_no"));
				exrateInputVO.setInvCustCntCd(request.getParameter("inv_cust_cnt_cd"));
				exrateInputVO.setInvCustSeq(request.getParameter("inv_cust_seq"));
				
				event.setExrateInputVO(exrateInputVO);
			}else{
				for (int i = 0; i <blNoArr.length; i++) {
					ExrateInputVO exrateInputVO = new ExrateInputVO();
					
					exrateInputVO.setOfcCd(request.getParameter("ofc_cd"));
					exrateInputVO.setRunOpt(request.getParameter("run_opt"));
					exrateInputVO.setBlSrcNo(blNoArr[i]);
					
					exrateInputVOs.add(exrateInputVO);
				}
				event.setExrateInputVOs(exrateInputVOs);
			}
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setBackEndJobKey(request.getParameter("backendjob_key"));

		} else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setBackEndJobKey(request.getParameter("backendjob_key"));
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