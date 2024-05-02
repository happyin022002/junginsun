/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_GEM_0001_02HTMLAction.java
*@FileTitle : [UI_GEM-0001-02] Request Transfer
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
 * [UI_GEM-0001-02] Request Transfer
 * HTTP Parser<br> 
 * @author choijungmi
 * @see GEMCommonEvent 참조
 * @since J2EE 1.4
 */

public class CPS_GEM_0001_02HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0001_02HTMLAction 객체를 생성
	 */
	public CPS_GEM_0001_02HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GEMCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		//[Retrieve]
		
		FormCommand command = FormCommand.fromRequest(request);
		CpsGem000102Event event = new CpsGem000102Event();		
		// RequestNo 
		String genExpnRqstNo = JSPUtil.getParameter(request, "gen_expn_rqst_no" , "");
		event.setGenExpnRqstNo(genExpnRqstNo);
		// 오피스 정보 
		String ofcCd = JSPUtil.getParameter(request, "ofc_cd" , "");
		event.setOfcCd(ofcCd);
		//비용코드 
		String genExpnCd = JSPUtil.getParameter(request, "gen_expn_cd" , "");
		event.setGenExpnCd(genExpnCd);
		//예산 년도
		String plnYrmon = JSPUtil.getParameter(request, "pln_yrmon" , "");
		event.setPlnYrmon(plnYrmon);
		
		
		
		//[Save]
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
			
			
			ItemVO[] fmItemVOs = (ItemVO[]) getVOs(request,
					ItemVO.class ,"fm_");			

			ItemVO[] toItemVOs = (ItemVO[]) getVOs(request,
					ItemVO.class ,"to_");			
			
			
			GemItemVO[] gemItemVOs = 
				new GemItemVO[fmItemVOs.length + toItemVOs.length ];
			GemApprovalStepVO[] gemApproVOs = 
				new GemApprovalStepVO[fmItemVOs.length + toItemVOs.length];
			
			
			int cnt = 0;
			
			// FM =================================================
			for (int i = 0; i < fmItemVOs.length; i++) {
				ItemVO vo = fmItemVOs[i];
				
				GemItemVO gemItemVo = new GemItemVO();
				gemItemVo.setIbflag(vo.getIbflag());
				gemItemVo.setGenExpnRqstNo(vo.getGenExpnRqstNo());
				gemItemVo.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
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
				gemItemVOs[cnt] = gemItemVo;
				
				GemApprovalStepVO gemAproVo = new GemApprovalStepVO();
				gemAproVo.setIbflag(vo.getIbflag());
				gemAproVo.setGenExpnRqstNo(vo.getGenExpnRqstNo());
				gemAproVo.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
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
				gemApproVOs[cnt] = gemAproVo;
				cnt++;
			}
			
			// TO =================================================			
			for (int i = 0; i < toItemVOs.length; i++) {
				ItemVO vo = toItemVOs[i];
				
				GemItemVO gemItemVo = new GemItemVO();
				gemItemVo.setIbflag(vo.getIbflag());
				gemItemVo.setGenExpnRqstNo(vo.getGenExpnRqstNo());
				gemItemVo.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
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
				
				gemItemVOs[cnt] = gemItemVo;
				
				GemApprovalStepVO gemAproVo = new GemApprovalStepVO();
				gemAproVo.setIbflag(vo.getIbflag());
				gemAproVo.setGenExpnRqstNo(vo.getGenExpnRqstNo());
				gemAproVo.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
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
				gemApproVOs[cnt] = gemAproVo;
				cnt++;
			}			
			
			planningVO.setGemApprovalStepVOs(gemApproVOs);
			planningVO.setGemItemVOs(gemItemVOs);
			
			event.setPlanningVO(planningVO);
			
		}		
		// TO office L2 , L3
		else if(command.isCommand(FormCommand.SEARCHLIST01) || 
				command.isCommand(FormCommand.SEARCHLIST02)) {			
			// HO , HQ구분 
			String toSlsOfcDivCd = JSPUtil.getParameter(request, "to_sls_ofc_div_cd" , "");
			event.setToSlsOfcDivCd(toSlsOfcDivCd);
			// TO office lv1
			String toOfcLvl1 = JSPUtil.getParameter(request, "to_ofc_lvl1" , "");
			event.setToOfcLvl1(toOfcLvl1);
			// TO office lv2
			String toOfcLvl2 = JSPUtil.getParameter(request, "to_ofc_lvl2" , "");
			event.setToOfcLvl2(toOfcLvl2);
			// TO office lv2
			String fmOfcLvl2 = JSPUtil.getParameter(request, "fm_ofc_lvl2" , "");
			event.setFmOfcLvl2(fmOfcLvl2);
			// TO office lv3 
			String fmOfcLvl3 = JSPUtil.getParameter(request, "fm_ofc_lvl3" , "");
			event.setFmOfcLvl3(fmOfcLvl3);
			
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