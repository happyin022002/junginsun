/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0016HTMLAction.java
*@FileTitle : Insurance Recovery by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.05 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.axis.utils.BeanUtils;

import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.CniCgoClmInsurVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.InsuranceRecoveryByVvdVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * CPS_CNI_0016  Insurance Recovery by VVD
 * HTTP Parser<br>
 * @author 진윤오
 * @see CpsCni0016Event 참조
 * @since J2EE 1.4
 */

public class CPS_CNI_0016HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GNI_0016HTMLAction 객체를 생성
	 */
	public CPS_CNI_0016HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0016Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsCni0016Event event = new CpsCni0016Event();
		
		// ----------------------------------------------------
		// 공통화면 정보 설정 
		// ----------------------------------------------------
		
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [open , retrive] vvd가 존재하는경우 open시 retrive
		if(command.isCommand(FormCommand.SEARCHLIST01) || command.isCommand(FormCommand.PRINT)) {
			// VVD 취득
			String trnkRefVvdNo = JSPUtil.getParameter(request, "trnk_ref_vvd_no","");
			event.setTrnkRefVvdNo(trnkRefVvdNo);			
		// [save]  Insurance Recovery by VVD 저장 수정
		} else if(command.isCommand(FormCommand.MULTI)) {
			
			InsuranceRecoveryByVvdVO[] paramVOs = 
				(InsuranceRecoveryByVvdVO[]) getVOs(request, InsuranceRecoveryByVvdVO.class ,"sheet1_");
						
			String insurPlcyYr = JSPUtil.getParameter(request, "insur_plcy_yr","");			
			String insurClmPtyNo = JSPUtil.getParameter(request, "insur_clm_pty_no","");			
				
			CniCgoClmInsurVO[] cniCgoClmInsurVOs = 
				new CniCgoClmInsurVO[paramVOs.length];
			
			for (int i = 0; i < paramVOs.length; i++) {
				InsuranceRecoveryByVvdVO paramVO = paramVOs[i];				
								
				CniCgoClmInsurVO  vo = new CniCgoClmInsurVO();
				
				vo.setCgoClmNo(paramVO.getCgoClmNo());
				
				vo.setInsurDmndCurrCd(paramVO.getCgoClmStlLoclCurrCd());
				vo.setInsurDmndUsdAmt(paramVO.getInsurDmndUsdAmt());
				vo.setInsurXchRt(paramVO.getCgoClmStlXchRt());
				vo.setInsurFmalClmDt(paramVO.getInsurFmalClmDt());
				vo.setRcvrUsdAmt(paramVO.getRcvrUsdAmt());

				//화면 항목으로 설정
				vo.setInsurPlcyYr(insurPlcyYr);
				vo.setInsurClmPtyNo(insurClmPtyNo);
				
				cniCgoClmInsurVOs[i] = vo;
			}			
			
			event.setCniCgoClmInsurVOs(cniCgoClmInsurVOs);
			
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