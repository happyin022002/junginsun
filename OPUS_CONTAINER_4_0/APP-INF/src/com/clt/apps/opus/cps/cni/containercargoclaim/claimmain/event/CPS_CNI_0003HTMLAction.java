/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0003HTMLAction.java
*@FileTitle : Claim Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.13 정행룡
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.HandlerHistoryVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ClaimMainCntVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmBlDtlVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCtrtVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmLablPtyVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmLtgtVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmStlVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmTrnsVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmInciVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmSveyVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.CniCgoClmInsurVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * CPS_CNI_0003 Claim Main
 * HTTP Parser<br>
 * @author 정행룡
 * @see CpsCni0003Event 참조
 * @since J2EE 1.4
 */

public class CPS_CNI_0003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_CNI_0003HTMLAction 객체를 생성
	 */
	public CPS_CNI_0003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0003Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsCni0003Event event = new CpsCni0003Event();
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [open , retrieve] Cargo Claim No가 존재하는경우 open시 retrive
		if(command.isCommand(FormCommand.SEARCH)) {
			// Cargo Claim No
			String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no","");
			
			event.setCgoClmNo(cgoClmNo);
			
		} else if(command.isCommand(FormCommand.SEARCH10)) {
			
			// Office Cd
			String ofcCd = JSPUtil.getParameter(request, "ofc_cd","");
			
			event.setOfcCd(ofcCd);
        } else if(command.isCommand(FormCommand.SEARCH11)) {
			
			// Class Misc Code
			String clssClmMiscCd = JSPUtil.getParameter(request, "clss_clm_misc_cd","");
			String clmMiscCd = JSPUtil.getParameter(request, "clm_misc_cd","");
			event.setClssClmMiscCd(clssClmMiscCd);
			event.setClmMiscCd(clmMiscCd);
        } else if(command.isCommand(FormCommand.SEARCH12)) {
			// Office Code
			String fmalClmRcvOfcCd = JSPUtil.getParameter(request, "fmal_clm_rcv_ofc_cd","");
			event.setFmalClmRcvOfcCd(fmalClmRcvOfcCd);  

			// [retrieve] Incident No 존재여부 조회
		} else if(command.isCommand(FormCommand.SEARCH15)) {
			String cgoClmInciNo = JSPUtil.getParameter(request, "cgo_clm_inci_no","");
			event.setCgoClmInciNo(cgoClmInciNo);
			// [retrieve] B/L 조회
		} else if(command.isCommand(FormCommand.SEARCH18) || command.isCommand(FormCommand.SEARCH19) || command.isCommand(FormCommand.SEARCH20)) {
			
			//B/L No 
			String cgoClmRefBlNo = JSPUtil.getParameter(request, "cgo_clm_ref_bl_no","");
			event.setCgoClmRefBlNo(cgoClmRefBlNo);
		
			// [retrieve]  Class Code 조회
		} else if(command.isCommand(FormCommand.SEARCHLIST10)) {
			
			// Class Code 
			String clssClmMiscCd = JSPUtil.getParameter(request, "clss_clm_misc_cd","");
			
			event.setClssClmMiscCd(clssClmMiscCd);

			// [save]  Claim 정보 저장
		} else if(command.isCommand(FormCommand.MULTI)) {
			
			// Claim Main Container VO
			ClaimMainCntVO  claimMainCntVO = new ClaimMainCntVO();
			
			// Claim Main
			CniCgoClmVO cniCgoClmVO = (CniCgoClmVO) getVO(request, CniCgoClmVO.class);
			
			String agnClmPtyNo = JSPUtil.getParameter(request, "clm_agn_clm_pty_no","");
			
			
			String clmTmBarDt     = JSPUtil.getParameter(request, "clm_tm_bar_dt","");  

			cniCgoClmVO.setAgnClmPtyNo(agnClmPtyNo);
			cniCgoClmVO.setTmBarDt(clmTmBarDt);
			
			claimMainCntVO.setCniCgoClmVO(cniCgoClmVO);
			
			CniCgoClmBlDtlVO cniCgoClmBlDtlVO = (CniCgoClmBlDtlVO) getVO(request, CniCgoClmBlDtlVO.class);
			claimMainCntVO.setCniCgoClmBlDtlVO(cniCgoClmBlDtlVO);
			
			CniCgoClmCtrtVO cniCgoClmCtrtVO = (CniCgoClmCtrtVO) getVO(request, CniCgoClmCtrtVO.class);
			claimMainCntVO.setCniCgoClmCtrtVO(cniCgoClmCtrtVO);
			
			CniCgoClmInciVO cniCgoClmInciVO = (CniCgoClmInciVO) getVO(request, CniCgoClmInciVO.class);
			claimMainCntVO.setCniCgoClmInciVO(cniCgoClmInciVO);
			
			CniCgoClmInsurVO cniCgoClmInsurVO = (CniCgoClmInsurVO) getVO(request, CniCgoClmInsurVO.class);
			
			String clmPtyNo = JSPUtil.getParameter(request, "insur_agn_clm_pty_no","");
			cniCgoClmInsurVO.setClmPtyNo(clmPtyNo);
			
			claimMainCntVO.setCniCgoClmInsurVO(cniCgoClmInsurVO);
			
			CniCgoClmLablPtyVO cniCgoClmLablPtyVO = (CniCgoClmLablPtyVO) getVO(request, CniCgoClmLablPtyVO.class);
			
			String lablTmBarDt = JSPUtil.getParameter(request, "labl_tm_bar_dt","");
			cniCgoClmLablPtyVO.setTmBarDt(lablTmBarDt);
			
			claimMainCntVO.setCniCgoClmLablPtyVO(cniCgoClmLablPtyVO);
			
			CniCgoClmLtgtVO cniCgoClmLtgtVO = (CniCgoClmLtgtVO) getVO(request, CniCgoClmLtgtVO.class);
			claimMainCntVO.setCniCgoClmLtgtVO(cniCgoClmLtgtVO);
			
			CniCgoClmStlVO cniCgoClmStlVO = (CniCgoClmStlVO) getVO(request, CniCgoClmStlVO.class);
			claimMainCntVO.setCniCgoClmStlVO(cniCgoClmStlVO);
			
			CniCgoClmSveyVO cniCgoClmSveyVO = (CniCgoClmSveyVO) getVO(request, CniCgoClmSveyVO.class);
			claimMainCntVO.setCniCgoClmSveyVO(cniCgoClmSveyVO);
			
			CniCgoClmTrnsVO cniCgoClmTrnsVO = (CniCgoClmTrnsVO) getVO(request, CniCgoClmTrnsVO.class);
			claimMainCntVO.setCniCgoClmTrnsVO(cniCgoClmTrnsVO);
			
			event.setClaimMainCntVO(claimMainCntVO);
			
			HandlerHistoryVO handlerHistoryVO = (HandlerHistoryVO) getVO(request, HandlerHistoryVO.class);
			event.setHandlerHistoryVO(handlerHistoryVO);
			
			
			// [Cancel]  Claim Cancel
		} else if(command.isCommand(FormCommand.MULTI01)) {
			// Claim Main Container VO
			ClaimMainCntVO  claimMainCntVO = new ClaimMainCntVO();
			
			// Claim Main
			CniCgoClmVO cniCgoClmVO = (CniCgoClmVO) getVO(request, CniCgoClmVO.class);
			claimMainCntVO.setCniCgoClmVO(cniCgoClmVO);
			
			CniCgoClmLtgtVO cniCgoClmLtgtVO = (CniCgoClmLtgtVO) getVO(request, CniCgoClmLtgtVO.class);
			claimMainCntVO.setCniCgoClmLtgtVO(cniCgoClmLtgtVO);
			
			event.setClaimMainCntVO(claimMainCntVO);
			
			HandlerHistoryVO handlerHistoryVO = (HandlerHistoryVO) getVO(request, HandlerHistoryVO.class);
			event.setHandlerHistoryVO(handlerHistoryVO);
			
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