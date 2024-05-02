/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0152HTMLAction.java
*@FileTitle : Disposal Planning
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.08.19 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnDtlVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnHdrVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnTransVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.DisposalPlanGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.DisposalPlanINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
	
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.planmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PlanManageSC로 실행요청<br>
 * - PlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author WanGyu Kim 
 * @see PlanManageEvent 참조
 * @since J2EE 1.6           
 */
 
public class EES_MNR_0152HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0152HTMLAction 객체를 생성
	 */
	public EES_MNR_0152HTMLAction() {}
				
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PlanManageEventt로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */	
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0152Event event = new EesMnr0152Event();
			
		DisposalPlanGRPVO disposalPlanGRPVO = new DisposalPlanGRPVO();
		
		//조회 리스트
		if(command.isCommand(FormCommand.SEARCH)) {		  
			disposalPlanGRPVO.setDisposalPlanINVO((DisposalPlanINVO)getVO(request, DisposalPlanINVO .class));
		}
		//저장시 이미 저장되어 있는지 체크 조회
		else if(command.isCommand(FormCommand.SEARCH01)) {		  
			disposalPlanGRPVO.setDisposalPlanINVO((DisposalPlanINVO)getVO(request, DisposalPlanINVO .class));
		}
		//저장		 
		else if(command.isCommand(FormCommand.MULTI)) { 
			CustomMnrPlnTransVO[] customMnrPlnTransVOs = (CustomMnrPlnTransVO[])getVOs(request, CustomMnrPlnTransVO .class, "");
			
			String cntr_tpsz_cd_seq =  request.getParameter("cntr_tpsz_cd_seq");
			String[] cntr_tpsz_cd_seqs = cntr_tpsz_cd_seq.split("\\,");   
			
			List<CustomMnrPlnHdrVO> totalCustomMnrPlnHdrVOs = new ArrayList<CustomMnrPlnHdrVO>();
			List<CustomMnrPlnDtlVO> totalCustomMnrPlnDtlVOs = new ArrayList<CustomMnrPlnDtlVO>();
			
			for(int i=0; i<customMnrPlnTransVOs.length; i++) {

				HashMap<String, String> planTrans = customMnrPlnTransVOs[i].getColumnValues();
				String targetfield = "";
				
				//HDR
				CustomMnrPlnHdrVO customMnrPlnHdrVO = new CustomMnrPlnHdrVO();
				if("sheet1".equals(customMnrPlnTransVOs[i].getSheetGubn())) {
					customMnrPlnHdrVO.setIbflag(customMnrPlnTransVOs[i].getIbflag());
					customMnrPlnHdrVO.setMnrPlnSeq(customMnrPlnTransVOs[i].getMnrPlnSeq());
					customMnrPlnHdrVO.setEqKndCd(customMnrPlnTransVOs[i].getEqKndCd());
					customMnrPlnHdrVO.setMnrPlnYr(customMnrPlnTransVOs[i].getMnrPlnYr());
					customMnrPlnHdrVO.setMnrGrpTpCd(customMnrPlnTransVOs[i].getMnrGrpTpCd());
					customMnrPlnHdrVO.setMnrPlnRmk(customMnrPlnTransVOs[i].getMnrPlnRmk());
					customMnrPlnHdrVO.setMnrPlnOfcCd(customMnrPlnTransVOs[i].getMnrPlnOfcCd());
					customMnrPlnHdrVO.setMnrPlnFlg(customMnrPlnTransVOs[i].getMnrPlnFlg());
					customMnrPlnHdrVO.setMnrPlnGrpNo(customMnrPlnTransVOs[i].getMnrPlnGrpNo());
					totalCustomMnrPlnHdrVOs.add(customMnrPlnHdrVO);
				}

				//DETAIL
				for(int j = 0; j < cntr_tpsz_cd_seqs.length ; j++ ){ 

					CustomMnrPlnDtlVO customMnrPlnDtlVO = new CustomMnrPlnDtlVO();
					targetfield =  "cntr"+(j+1)+"_chg_val";
					if(!planTrans.get(targetfield).equals("") && planTrans.get(targetfield) != null){
						
						customMnrPlnDtlVO.setIbflag(customMnrPlnTransVOs[i].getIbflag());
						customMnrPlnDtlVO.setMnrPlnSeq(customMnrPlnTransVOs[i].getMnrPlnSeq());
						customMnrPlnDtlVO.setCtrlOfcCd(customMnrPlnTransVOs[i].getCtrlOfcCd());
						customMnrPlnDtlVO.setEqTpszCd(cntr_tpsz_cd_seqs[j]);
						customMnrPlnDtlVO.setEqQty(planTrans.get(targetfield));
						
						totalCustomMnrPlnDtlVOs.add(customMnrPlnDtlVO);
					}
				}
			}
			disposalPlanGRPVO.setListCustomMnrPlnHdrVO(totalCustomMnrPlnHdrVOs);
			disposalPlanGRPVO.setListCustomMnrPlnDtlVO(totalCustomMnrPlnDtlVOs);
		}
		event.setDisposalPlanGRPVO(disposalPlanGRPVO);     	           
		 				
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