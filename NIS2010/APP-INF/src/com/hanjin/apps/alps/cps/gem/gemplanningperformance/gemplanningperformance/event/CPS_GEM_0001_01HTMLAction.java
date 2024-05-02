/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_GEM_0001_01HTMLAction.java
*@FileTitle : Expense Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.21 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemApprovalStepVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemItemVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemRequestVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.ItemVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * [CPS_GEM_0001_01] Expense Request
 * HTTP Parser<br>
 * @author choijungmi
 * @see GEMCommonEvent 참조
 * @since J2EE 1.4
 */

public class CPS_GEM_0001_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0001_01HTMLAction 객체를 생성
	 */
	public CPS_GEM_0001_01HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GEMCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		//[Retrieve / Default]
		
		FormCommand command = FormCommand.fromRequest(request);
		CpsGem000101Event event = new CpsGem000101Event();		
		// RequestNo 
		String genExpnRqstNo = JSPUtil.getParameter(request, "gen_expn_rqst_no" , "");
		event.setGenExpnRqstNo(genExpnRqstNo);

		// Request Seq 
		String genExpnRqstSeq = JSPUtil.getParameter(request, "gen_expn_rqst_seq" , "");
		event.setGenExpnRqstSeq(genExpnRqstSeq);
		
		// 오피스 정보 
		String ofcCd = JSPUtil.getParameter(request, "ofc_cd" , "");
		event.setOfcCd(ofcCd);
		//비용코드 
		String genExpnCd = JSPUtil.getParameter(request, "gen_expn_cd" , "");
		event.setGenExpnCd(genExpnCd);
		//예산 년도
		String plnYrmon = JSPUtil.getParameter(request, "pln_yrmon" , "");
		event.setPlnYrmon(plnYrmon);
		//비용주관팀		
		String ticCd = JSPUtil.getParameter(request, "tic_cd" , "");
		event.setTicCd(ticCd);		
		//비용그룹
		String genExpnGroupCd = JSPUtil.getParameter(request, "gen_expn_group_cd" , "");
		event.setGenExpnGroupCd(genExpnGroupCd);
		
		// [Save]
		if(command.isCommand(FormCommand.MULTI)) {   		   	
			String genExpnRqstTpCd = JSPUtil.getParameter(request, "gen_expn_rqst_tp_cd" , "");			
			String authFlg = JSPUtil.getParameter(request, "auth_flg" , "");
			
			PlanningVO planningVO = new PlanningVO();
			
			GemRequestVO gemRequestVO = new GemRequestVO();
			gemRequestVO.setGenExpnRqstNo(genExpnRqstNo);			
			gemRequestVO.setPlnYrmon(plnYrmon);
			gemRequestVO.setGenExpnRqstTpCd(genExpnRqstTpCd);
			gemRequestVO.setAuthFlg(authFlg);
			
			planningVO.setGemRequestVO(gemRequestVO);
			
			
			ItemVO[] itemVOs = (ItemVO[]) getVOs(request,
					ItemVO.class );			
			
			GemItemVO[] gemItemVOs = new GemItemVO[itemVOs.length];
			GemApprovalStepVO[] gemApproVOs = new GemApprovalStepVO[itemVOs.length];
			
			for (int i = 0; i < itemVOs.length; i++) {
				ItemVO vo = itemVOs[i];
				
				GemItemVO gemItemVo = new GemItemVO();
				gemItemVo.setIbflag(vo.getIbflag());
				gemItemVo.setGenExpnRqstNo(vo.getGenExpnRqstNo());
				gemItemVo.setOfcCd(vo.getOfcCd());
				gemItemVo.setGenExpnCd(vo.getGenExpnCd());
				gemItemVo.setGenExpnItmNo(vo.getGenExpnItmNo());
				gemItemVo.setGenExpnTrnsDivCd(vo.getGenExpnTrnsDivCd());
				gemItemVo.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
				gemItemVo.setCrntGenExpnAproStepCd(vo.getCrntGenExpnAproStepCd());
				gemItemVo.setCrntGenExpnApstsCd(vo.getCrntGenExpnApstsCd());
				gemItemVo.setGenExpnItmDesc(vo.getGenExpnItmDesc());
				gemItemVo.setGenExpnCalcBssDesc(vo.getGenExpnCalcBssDesc());
				gemItemVo.setRqstOpinRmk(vo.getRqstOpinRmk());
				gemItemVo.setJanAmt(vo.getJanAmt());
				gemItemVo.setFebAmt(vo.getFebAmt());
				gemItemVo.setMarAmt(vo.getMarAmt());
				gemItemVo.setAprAmt(vo.getAprAmt());
				gemItemVo.setMayAmt(vo.getMayAmt());
				gemItemVo.setJunAmt(vo.getJunAmt());
				gemItemVo.setJulAmt(vo.getJulAmt());
				gemItemVo.setAugAmt(vo.getAugAmt());
				gemItemVo.setSepAmt(vo.getSepAmt());
				gemItemVo.setOctAmt(vo.getOctAmt());
				gemItemVo.setNovAmt(vo.getNovAmt());
				gemItemVo.setDecAmt(vo.getDecAmt());
				gemItemVo.setTicCd(vo.getTicCd());
				
				gemItemVOs[i] = gemItemVo;
				
				GemApprovalStepVO gemAproVo = new GemApprovalStepVO();
				gemAproVo.setIbflag(vo.getIbflag());
				gemAproVo.setGenExpnRqstNo(vo.getGenExpnRqstNo());
				gemAproVo.setOfcCd(vo.getOfcCd());
				gemAproVo.setGenExpnCd(vo.getGenExpnCd());
				gemAproVo.setGenExpnItmNo(vo.getGenExpnItmNo());
				gemAproVo.setGenExpnTrnsDivCd(vo.getGenExpnTrnsDivCd());
				gemAproVo.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
				gemAproVo.setJanAmt(vo.getRqstJanAmt());
				gemAproVo.setFebAmt(vo.getRqstFebAmt());
				gemAproVo.setMarAmt(vo.getRqstMarAmt());
				gemAproVo.setAprAmt(vo.getRqstAprAmt());
				gemAproVo.setMayAmt(vo.getRqstMayAmt());
				gemAproVo.setJunAmt(vo.getRqstJunAmt());
				gemAproVo.setJulAmt(vo.getRqstJulAmt());
				gemAproVo.setAugAmt(vo.getRqstAugAmt());
				gemAproVo.setSepAmt(vo.getRqstSepAmt());
				gemAproVo.setOctAmt(vo.getRqstOctAmt());
				gemAproVo.setNovAmt(vo.getRqstNovAmt());
				gemAproVo.setDecAmt(vo.getRqstDecAmt());	
				gemAproVo.setTicCd(vo.getTicCd());
				gemApproVOs[i] = gemAproVo;
			}
			
			planningVO.setGemApprovalStepVOs(gemApproVOs);
			planningVO.setGemItemVOs(gemItemVOs);
			
			event.setPlanningVO(planningVO);
			
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