/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_GEM_0003HTMLAction.java
*@FileTitle : Approval of Requested expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.21 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemApprovalStepVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemItemVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemRequestVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ItemVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusCondVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * [CPS_GEM-0001-03] Approval of Requested expense
 * HTTP Parser<br> 
 * @author choijungmi
 * @see CpsGem0003Event 참조
 * @since J2EE 1.4
 */

public class CPS_GEM_0003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0003HTMLAction 객체를 생성
	 */
	public CPS_GEM_0003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>	
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		CpsGem0003Event event = new CpsGem0003Event();		
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

		//auth_flg
		String authFlg = JSPUtil.getParameter(request, "auth_flg" , "");
		event.setAuthFlg(authFlg);

		//[Retrieve]
		if(command.isCommand(FormCommand.SEARCHLIST)) {			
			PlanningStatusCondVO  planningStatusCondVO = 
				(PlanningStatusCondVO) getVO(request,
						PlanningStatusCondVO.class);			
			event.setPlanningStatusCondVO(planningStatusCondVO);
		}		
		//[grid select]
		else if(command.isCommand(FormCommand.SEARCHLIST01)) {			
			PlanningStatusVO  planningStatusVO = 
				(PlanningStatusVO) getVO(request,
						PlanningStatusVO.class);			
			event.setPlanningStatusVO(planningStatusVO);
		}	
		//[Save] ET인경우 
		else if(command.isCommand(FormCommand.MULTI)) {		
			
			// sheet1
			PlanningStatusVO[] planningStatusVOs = (PlanningStatusVO[]) getVOs(request,
					PlanningStatusVO.class ,"sheet1_");
			
			
			PlanningStatusVO  planningStatusVO =  planningStatusVOs[0];
			
			event.setPlanningStatusVO(planningStatusVO);
					

			PlanningVO planningVO = new PlanningVO();	
			// Request
			GemRequestVO gemRequestVO = new GemRequestVO();				
			gemRequestVO.setAuthFlg(authFlg);
			gemRequestVO.setGenExpnRqstTpCd(planningStatusVO.getGenExpnRqstTpCd());
			gemRequestVO.setPlnYrmon(plnYrmon);
			planningVO.setGemRequestVO(gemRequestVO);
			
			// sheet2
			GemApprovalStepVO[] fmAproSteps = (GemApprovalStepVO[]) getVOs(request,
					GemApprovalStepVO.class ,"sheet2_");
			// sheet3
			GemApprovalStepVO[] toAproSteps = (GemApprovalStepVO[]) getVOs(request,
					GemApprovalStepVO.class ,"sheet3_");
						
			// sheet4
			GemApprovalStepVO[] aproStepOpition = (GemApprovalStepVO[]) getVOs(request,
					GemApprovalStepVO.class ,"sheet4_");		
			
			//RJ , AJ 시트에서 취득한 genexpnaprostep 및 apstscd
			String genExpnApstsCd = 
				aproStepOpition[0].getGenExpnApstsCd();
			
			
			// FM , TO =================================================
			GemItemVO fmGemItemVO = new GemItemVO();
			fmGemItemVO.setGenExpnRqstNo(planningStatusVO.getGenExpnRqstNo());
			fmGemItemVO.setOfcCd(planningStatusVO.getFmOfcCd());
			fmGemItemVO.setGenExpnCd(planningStatusVO.getFmGenExpnCd());
			fmGemItemVO.setGenExpnItmNo(planningStatusVO.getFmGenExpnItmNo());
			fmGemItemVO.setGenExpnTrnsDivCd("F");					
			fmGemItemVO.setGenExpnRqstSeq(planningStatusVO.getGenExpnRqstSeq());
			fmGemItemVO.setCrntGenExpnApstsCd(genExpnApstsCd);
			
			
			GemItemVO toGemItemVO = new GemItemVO();
			toGemItemVO.setGenExpnRqstNo(planningStatusVO.getGenExpnRqstNo());
			toGemItemVO.setOfcCd(planningStatusVO.getToOfcCd());
			toGemItemVO.setGenExpnCd(planningStatusVO.getToGenExpnCd());
			toGemItemVO.setGenExpnItmNo(planningStatusVO.getToGenExpnItmNo());
			toGemItemVO.setGenExpnTrnsDivCd("T");					
			toGemItemVO.setGenExpnRqstSeq(planningStatusVO.getGenExpnRqstSeq());
			toGemItemVO.setRqstOpinRmk(planningStatusVO.getRqstOpinRmk());
			toGemItemVO.setCrntGenExpnApstsCd(genExpnApstsCd);
			
			GemItemVO[] gemItemVOs = 
				new GemItemVO[]{fmGemItemVO,toGemItemVO};				
			planningVO.setGemItemVOs(gemItemVOs);
			
			//ApproStep
			GemApprovalStepVO fmAproStep = fmAproSteps[0];			
			fmAproStep.setGenExpnRqstNo(planningStatusVO.getGenExpnRqstNo());
			fmAproStep.setOfcCd(planningStatusVO.getFmOfcCd());
			fmAproStep.setGenExpnCd(planningStatusVO.getFmGenExpnCd());
			fmAproStep.setGenExpnItmNo(planningStatusVO.getFmGenExpnItmNo());
			fmAproStep.setGenExpnTrnsDivCd("F");					
			fmAproStep.setGenExpnRqstSeq(planningStatusVO.getGenExpnRqstSeq());
			fmAproStep.setGenExpnApstsCd(genExpnApstsCd);			
			fmAproStep.setAproOpinRmk(aproStepOpition[0].getAproOpinRmk());
			
			GemApprovalStepVO toAproStep = toAproSteps[0];			
			toAproStep.setGenExpnRqstNo(planningStatusVO.getGenExpnRqstNo());
			toAproStep.setOfcCd(planningStatusVO.getToOfcCd());
			toAproStep.setGenExpnCd(planningStatusVO.getToGenExpnCd());
			toAproStep.setGenExpnItmNo(planningStatusVO.getToGenExpnItmNo());
			toAproStep.setGenExpnTrnsDivCd("T");					
			toAproStep.setGenExpnRqstSeq(planningStatusVO.getGenExpnRqstSeq());			
			toAproStep.setGenExpnApstsCd(genExpnApstsCd);			
			toAproStep.setAproOpinRmk(aproStepOpition[0].getAproOpinRmk());
			
			
			GemApprovalStepVO[] gaeApproVOs = 
				new GemApprovalStepVO[]{fmAproStep,toAproStep};
			
			planningVO.setGemApprovalStepVOs(gaeApproVOs);
			
			event.setPlanningVO(planningVO);
			
		
		}
		// [Save]  EA,EI인경우
		else if(command.isCommand(FormCommand.MULTI01)) {		
			// sheet1
			PlanningStatusVO[] planningStatusVOs = (PlanningStatusVO[]) getVOs(request,
					PlanningStatusVO.class ,"sheet1_");
			
			
			PlanningStatusVO  planningStatusVO =  planningStatusVOs[0];
			
			event.setPlanningStatusVO(planningStatusVO);


			
			PlanningVO planningVO = new PlanningVO();
			// Request
			GemRequestVO gemRequestVO = new GemRequestVO();
			gemRequestVO.setAuthFlg(authFlg);
			gemRequestVO.setGenExpnRqstTpCd(planningStatusVO.getGenExpnRqstTpCd());
			gemRequestVO.setPlnYrmon(plnYrmon);
			planningVO.setGemRequestVO(gemRequestVO);
			
			GemApprovalStepVO[] fmAproSteps = (GemApprovalStepVO[]) getVOs(request,
					GemApprovalStepVO.class ,"sheet5_");
			
			// sheet6
			GemApprovalStepVO[] aproStepOpition = (GemApprovalStepVO[]) getVOs(request,
					GemApprovalStepVO.class ,"sheet6_");		
			
			//RJ , AJ				
			String genExpnApstsCd = 
				aproStepOpition[0].getGenExpnApstsCd();	
						
			// FM , TO =================================================
			GemItemVO fmGemItemVO = new GemItemVO();
			fmGemItemVO.setGenExpnRqstNo(planningStatusVO.getGenExpnRqstNo());
			fmGemItemVO.setOfcCd(planningStatusVO.getFmOfcCd());
			fmGemItemVO.setGenExpnCd(planningStatusVO.getFmGenExpnCd());
			fmGemItemVO.setGenExpnItmNo(planningStatusVO.getFmGenExpnItmNo());
			fmGemItemVO.setGenExpnTrnsDivCd("F");					
			fmGemItemVO.setGenExpnRqstSeq(planningStatusVO.getGenExpnRqstSeq());
			fmGemItemVO.setCrntGenExpnApstsCd(genExpnApstsCd);
			fmGemItemVO.setRqstOpinRmk(planningStatusVO.getRqstOpinRmk());
			GemItemVO[] gemItemVOs = 
				new GemItemVO[]{fmGemItemVO};				
			planningVO.setGemItemVOs(gemItemVOs);

			// sheet5
	
			
			GemApprovalStepVO fmAproStep = fmAproSteps[0];			
			fmAproStep.setGenExpnRqstNo(planningStatusVO.getGenExpnRqstNo());
			fmAproStep.setOfcCd(planningStatusVO.getFmOfcCd());
			fmAproStep.setGenExpnCd(planningStatusVO.getFmGenExpnCd());
			fmAproStep.setGenExpnItmNo(planningStatusVO.getFmGenExpnItmNo());
			fmAproStep.setGenExpnTrnsDivCd("F");					
			fmAproStep.setGenExpnRqstSeq(planningStatusVO.getGenExpnRqstSeq());			
			fmAproStep.setGenExpnApstsCd(genExpnApstsCd);			
			fmAproStep.setAproOpinRmk(aproStepOpition[0].getAproOpinRmk());
			
			//ApproStep
			GemApprovalStepVO[] gaeApproVOs = 
				new GemApprovalStepVO[]{fmAproStep};
			planningVO.setGemApprovalStepVOs(gaeApproVOs);
			
			event.setPlanningVO(planningVO);
			
		}
		
		// [Grid Save] RJ , AJ
		else if(command.isCommand(FormCommand.MULTI02)) {		

			// sheet1
			PlanningStatusVO[] planningStatusVOs = (PlanningStatusVO[]) getVOs(request,
					PlanningStatusVO.class ,"sheet1_");
			
			List<PlanningVO> list = new ArrayList<PlanningVO>();
			
			for (int i = 0; i < planningStatusVOs.length; i++) {
				
				PlanningStatusVO planningStatusVO = planningStatusVOs[i];
				PlanningVO planningVO = new PlanningVO();
				
				
				//RJ , AJ
				String ap = planningStatusVO.getCrntGenExpnApstsCdAp();
				String rj = planningStatusVO.getCrntGenExpnApstsCdRj();
				String crntGenExpnApstsCd = "";
				
				if ("1".equals(ap)) {
					crntGenExpnApstsCd = "AP";
				}
				
			    if ("1".equals(rj)) {
			    	crntGenExpnApstsCd = "RJ";
				} 
			    
			    if (crntGenExpnApstsCd.equals("")) {
			    	continue;
			    }
				
				// --------------------------------
				// Request 
				// --------------------------------
				GemRequestVO gemRequestVO = new GemRequestVO();
				gemRequestVO.setGenExpnRqstNo(planningStatusVO.getGenExpnRqstNo());
				gemRequestVO.setGenExpnRqstTpCd(planningStatusVO.getGenExpnRqstTpCd());
				gemRequestVO.setPlnYrmon(plnYrmon);
				gemRequestVO.setAuthFlg(authFlg);
				gemRequestVO.setRqstOfcCd(planningStatusVO.getRqstOfcCd());
				planningVO.setGemRequestVO(gemRequestVO);				
				// --------------------------------
				// item 
				// --------------------------------
				GemItemVO fmGemItemVO = new GemItemVO();

				
				fmGemItemVO.setGenExpnRqstNo(planningStatusVO.getGenExpnRqstNo());
				fmGemItemVO.setOfcCd(planningStatusVO.getFmOfcCd());
				fmGemItemVO.setGenExpnCd(planningStatusVO.getFmGenExpnCd());
				fmGemItemVO.setGenExpnItmNo(planningStatusVO.getFmGenExpnItmNo());
				fmGemItemVO.setGenExpnTrnsDivCd("F");					
				fmGemItemVO.setGenExpnRqstSeq(planningStatusVO.getGenExpnRqstSeq());
				fmGemItemVO.setCrntGenExpnApstsCd(crntGenExpnApstsCd);
				
				if ("ET".equals(planningStatusVO.getGenExpnRqstTpCd())) {
					GemItemVO toGemItemVO = new GemItemVO();
					toGemItemVO.setGenExpnRqstNo(planningStatusVO.getGenExpnRqstNo());
					toGemItemVO.setOfcCd(planningStatusVO.getToOfcCd());
					toGemItemVO.setGenExpnCd(planningStatusVO.getToGenExpnCd());
					toGemItemVO.setGenExpnItmNo(planningStatusVO.getToGenExpnItmNo());
					toGemItemVO.setGenExpnTrnsDivCd("T");					
					toGemItemVO.setGenExpnRqstSeq(planningStatusVO.getGenExpnRqstSeq());
					toGemItemVO.setCrntGenExpnApstsCd(crntGenExpnApstsCd);
					GemItemVO[] gemItemVOs = 
						new GemItemVO[]{fmGemItemVO,toGemItemVO};				
					planningVO.setGemItemVOs(gemItemVOs);
				} else {
					GemItemVO[] gemItemVOs = 
						new GemItemVO[]{fmGemItemVO};				
					planningVO.setGemItemVOs(gemItemVOs);					
				}
				
				
				// --------------------------------
				// apro_step 
				// --------------------------------
				
				GemApprovalStepVO fmAproStep =  new GemApprovalStepVO();			
				fmAproStep.setGenExpnRqstNo(planningStatusVO.getGenExpnRqstNo());
				fmAproStep.setOfcCd(planningStatusVO.getFmOfcCd());
				fmAproStep.setGenExpnCd(planningStatusVO.getFmGenExpnCd());
				fmAproStep.setGenExpnItmNo(planningStatusVO.getFmGenExpnItmNo());
				fmAproStep.setGenExpnTrnsDivCd("F");					
				fmAproStep.setGenExpnRqstSeq(planningStatusVO.getGenExpnRqstSeq());
				fmAproStep.setGenExpnAproStepCd(planningStatusVO.getCrntGenExpnAproStepCd());
				fmAproStep.setGenExpnApstsCd(crntGenExpnApstsCd);
				if ("ET".equals(planningStatusVO.getGenExpnRqstTpCd())) {
					GemApprovalStepVO toAproStep = new GemApprovalStepVO();			
					toAproStep.setGenExpnRqstNo(planningStatusVO.getGenExpnRqstNo());
					toAproStep.setOfcCd(planningStatusVO.getToOfcCd());
					toAproStep.setGenExpnCd(planningStatusVO.getToGenExpnCd());
					toAproStep.setGenExpnItmNo(planningStatusVO.getToGenExpnItmNo());
					toAproStep.setGenExpnTrnsDivCd("T");					
					toAproStep.setGenExpnRqstSeq(planningStatusVO.getGenExpnRqstSeq());
					toAproStep.setGenExpnAproStepCd(planningStatusVO.getCrntGenExpnAproStepCd());	
					toAproStep.setGenExpnApstsCd(crntGenExpnApstsCd);
					GemApprovalStepVO[] gaeApproVOs = 
						new GemApprovalStepVO[]{fmAproStep,toAproStep};			
					planningVO.setGemApprovalStepVOs(gaeApproVOs);
				} else {
					GemApprovalStepVO[] gaeApproVOs = 
						new GemApprovalStepVO[]{fmAproStep};			
					planningVO.setGemApprovalStepVOs(gaeApproVOs);					
				}
				
				//리스트에 추가
				list.add(planningVO);
				
			}
			
			event.setPlanningVOs((PlanningVO[])list.toArray(new PlanningVO[list.size()]));
						
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