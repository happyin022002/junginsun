/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0218HTMLAction.java
*@FileTitle : M&R AGREEMENT DETAIL Pop_Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : HyungSeok Ham
*@LastVersion : 1.0
* 2009.07.03 HyungSeok Ham
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementComboListINVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementINVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtHdrVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtRtVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.CustomMnrPartnerVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.RepairPartnerGRPVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AgreementManageSC로 실행요청<br>
 * - AgreementManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HyungSeok Ham
 * @see AgreementManageEvent 참조
 * @since J2EE 1.6           
 */

public class EES_MNR_S218HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0218HTMLAction 객체를 생성
	 */
	public EES_MNR_S218HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AgreementManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnrS218Event event = new EesMnrS218Event();
		
		AgreementGRPVO agreementGRPVO = new AgreementGRPVO();
		RepairPartnerGRPVO repairPartnerGRPVO = new RepairPartnerGRPVO();
		  
		//조회 
		if(command.isCommand(FormCommand.SEARCH)) {  
			agreementGRPVO.setAgreementINVO((AgreementINVO)getVO(request, AgreementINVO .class)); 
		}     
		//콤보 데이타 조회용  
		if(command.isCommand(FormCommand.SEARCH02)) {    
			agreementGRPVO.setAgreementComboListINVO((AgreementComboListINVO)getVO(request, AgreementComboListINVO .class)); 
		} 	  	  
		//CUD
		else if(command.isCommand(FormCommand.MULTI)) {
			//1 HRD 세팅                 
			agreementGRPVO.setCustomMnrAgmtHdrVO((CustomMnrAgmtHdrVO)getVO(request, CustomMnrAgmtHdrVO .class)); 
			//1 PARTNER 세팅                    
			repairPartnerGRPVO.setCustomMnrPartnerVO((CustomMnrPartnerVO)getVO(request, CustomMnrPartnerVO .class)); 
			repairPartnerGRPVO.getCustomMnrPartnerVO().setMnrPrnrSeq(agreementGRPVO.getCustomMnrAgmtHdrVO().getVndrSeq());
			repairPartnerGRPVO.getCustomMnrPartnerVO().setMnrPrnrTpCd("S");
			repairPartnerGRPVO.getCustomMnrPartnerVO().setMnrPrnrKndCd("C");   
			repairPartnerGRPVO.getCustomMnrPartnerVO().setMnrGrpTpCd("RPR");     
			repairPartnerGRPVO.getCustomMnrPartnerVO().setMnrPrnrStsCd("C");    
			repairPartnerGRPVO.getCustomMnrPartnerVO().setPayTermDys("0");        
			repairPartnerGRPVO.getCustomMnrPartnerVO().setMnrShopFlg("N");            
			repairPartnerGRPVO.getCustomMnrPartnerVO().setFileSeq("0");                                          
			
			//기초 데이타 세팅        
			//String dispayType =  agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtDisplayType();
			//String[] dispayTypes = dispayType.split("\\|");
			String agmtPrifix =  agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtPrifix();
			String[] agmtPrifixs = agmtPrifix.split("\\|");
	
			 
			//totalCustomMnrAgmtRtVOS 하나에 다 밀어 넣는다.      
			List<CustomMnrAgmtRtVO> totalCustomMnrAgmtRtVOS = new ArrayList<CustomMnrAgmtRtVO>();       
			     
			for(int i = 0 ; i < agmtPrifixs.length ; i++){  
				//if(dispayTypes[i].equals("sheet2")){	   
					//CustomMnrAgmtAplyOfcVO[] customMnrAgmtAplyOfcVOS = (CustomMnrAgmtAplyOfcVO[])getVOs(request, CustomMnrAgmtAplyOfcVO .class,"sheet2");
					//2 sheet2 세팅	  	   
					//agreementGRPVO.setCustomMnrAgmtAplyOfcVOS(customMnrAgmtAplyOfcVOS);    
				//} else { 		
					CustomMnrAgmtRtVO[] customMnrAgmtRtVOS = (CustomMnrAgmtRtVO[])getVOs(request, CustomMnrAgmtRtVO .class,agmtPrifixs[i]);
						
					for (int j = 0; j < customMnrAgmtRtVOS.length; j++) {
						//MNR_RT_TP_CD 가없는 LB형은 COST_DTL_CD 삽입 
						if(customMnrAgmtRtVOS[j].getMnrRtTpCd().equals("") || customMnrAgmtRtVOS[j].getMnrRtTpCd() == null){
							customMnrAgmtRtVOS[j].setMnrRtTpCd(customMnrAgmtRtVOS[j].getCostDtlCd());
						}
						//RPR_QTY 가없는 LB형은 0 삽입 
						if(customMnrAgmtRtVOS[j].getRprQty().equals("") || customMnrAgmtRtVOS[j].getRprQty() == null){
							customMnrAgmtRtVOS[j].setRprQty("0");
						}	
						totalCustomMnrAgmtRtVOS.add(customMnrAgmtRtVOS[j]);  	   			
					}	
				//} 				        
			}
			//데이타 분리 끝  		 
			//3 rt 세팅   
			agreementGRPVO.setCustomMnrAgmtRtVOS(totalCustomMnrAgmtRtVOS);    
		}   	        
		else if(command.isCommand(FormCommand.REMOVE)) { 
			agreementGRPVO.setAgreementINVO((AgreementINVO)getVO(request, AgreementINVO .class)); 
		}   	           
		//파트너용   	
		event.setRepairPartnerGRPVO(repairPartnerGRPVO);        
		//어그리먼트용   
		event.setAgreementGRPVO(agreementGRPVO);            
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