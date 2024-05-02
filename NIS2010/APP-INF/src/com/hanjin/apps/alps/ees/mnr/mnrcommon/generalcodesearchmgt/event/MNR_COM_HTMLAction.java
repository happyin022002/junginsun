/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MNR_COM_HTMLAction.java
*@FileTitle : ghost
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.04
*@LastModifier : 조경완
*@LastVersion : 1.0 
* 2009.05.12 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.12.16 신혜정 [CHM-201115121-01] 유저아이디 Office Change 로 로긴정보 중 RHQ 변경 안되는 로직 보완
* 2011.12.27 신혜정 [CHM-201115280] Estimate Creation 화면 Reefer Uint Maker 필드 추가 
* 2013.01.04 조경완 [CHM-201220942-01] ALPS MNR-Total Loss Module에서 Write Off 처리 건을 위하여 추가 메뉴 개발 요청                       
* 2013.01.04 조경완 [CHM-201220984-01] ALPS MNR-Total Loss-Write Off - Approval 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.PartnerMgtINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ComboInitDataINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CommonInitDataINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCurrXchRtVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomLocalDateVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomSPPOFCVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomUnitPriceVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomerInfoVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.DefaultUnitOfMeasureVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EQGeneralInfoINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EtcInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.MnrCommonVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.UnitPriceGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.VesselInfoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
 
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.mnrcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MNRCommonSC로 실행요청<br>
 * - MNRCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author park myoung sin
 * @see MnrComEvent 참조
 * @since J2EE 1.4
 */

public class MNR_COM_HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * MNR_COM_HTMLAction 객체를 생성
	 */  
	public MNR_COM_HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MNRCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */   
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		MnrComEvent event = new MnrComEvent(); 
		  
		if(command.isCommand(FormCommand.SEARCH)) {
			//공통코드 콤보용 조회
			event.setComboInitDataINVOS((ComboInitDataINVO[])getVOs(request, ComboInitDataINVO .class,""));
		} else if (command.isCommand(FormCommand.SEARCH01)) {
			//공통코드 그리드용 조회
			event.setCommonInitDataINVO((CommonInitDataINVO)getVO(request, CommonInitDataINVO.class ));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			//EQ General Info 
			event.setEQGeneralInfoINVO((EQGeneralInfoINVO)getVO(request, EQGeneralInfoINVO.class ));
		} else if (command.isCommand(FormCommand.SEARCH04)) {       
			//Default Unit Of Measure
			event.setDefaultUnitOfMeasureVO((DefaultUnitOfMeasureVO)getVO(request, DefaultUnitOfMeasureVO.class ));	
		} else if (command.isCommand(FormCommand.SEARCH06)) {  
			//Service Provider Detail Information
			event.setPartnerMgtINVO((PartnerMgtINVO)getVO(request, PartnerMgtINVO.class ));    
		} else if (command.isCommand(FormCommand.SEARCH09)) {    
			//Agreement RATE search	
			AGMTRtINVO agmtRtINVO = (AGMTRtINVO)getVO(request, AGMTRtINVO.class);
			AGMTRtGRPVO agmtRtGRPVO = new AGMTRtGRPVO();
			agmtRtGRPVO.setAGMTRtINVO(agmtRtINVO);
	    	event.setAGMTRtGRPVO(agmtRtGRPVO);
		} else if (command.isCommand(FormCommand.SEARCH10)) {   
			//Cost Code 구하기 
			CostCodeINVO costCodeINVO = (CostCodeINVO)getVO(request, CostCodeINVO.class);
			CostCodeGRPVO costCodeGRPVO = new CostCodeGRPVO();
			costCodeGRPVO.setCostCodeINVO(costCodeINVO); 
			event.setCostCodeGRPVO(costCodeGRPVO);   
		} else if (command.isCommand(FormCommand.SEARCH12)) {  
			// Vessel Code과 관련되 Vessel Name,Lane 가져오기	
			event.setVesselInfoVO((VesselInfoVO)getVO(request, VesselInfoVO.class ));
		} else if(command.isCommand(FormCommand.SEARCH13)) {
			//Status History	
			StatusHistoryGRPVO statusHistoryGRPVO = new StatusHistoryGRPVO();
			statusHistoryGRPVO.setStatusHistoryINVO((StatusHistoryINVO)getVO(request, StatusHistoryINVO.class));
			event.setStatusHistoryGRPVO(statusHistoryGRPVO);
		} else if(command.isCommand(FormCommand.SEARCH14)) {  
			//Unit Price 가져오기 
			UnitPriceGRPVO unitPriceGRPVO = new UnitPriceGRPVO();
			unitPriceGRPVO.setInCustomUnitPriceVO((CustomUnitPriceVO)getVO(request, CustomUnitPriceVO.class));
			event.setUnitPriceGRPVO(unitPriceGRPVO);	
		} else if (command.isCommand(FormCommand.SEARCH15)) {  
			// Customer정보 가져오기
			event.setCustomerInfoVO((CustomerInfoVO)getVO(request,CustomerInfoVO.class ));
		} else if (command.isCommand(FormCommand.SEARCH16)) {  
			//Curr Xch Rtw 정보 가져오기
			UnitPriceGRPVO unitPriceGRPVO = new UnitPriceGRPVO();
			unitPriceGRPVO.setCustomCurrXchRtVO((CustomCurrXchRtVO)getVO(request, CustomCurrXchRtVO.class));
			event.setUnitPriceGRPVO(unitPriceGRPVO);				
		} else if (command.isCommand(FormCommand.SEARCH17)) {  
			//로칼 데이트 정보 가져오기
			EtcInfoGRPVO etcInfoGRPVO = new EtcInfoGRPVO();
			etcInfoGRPVO.setInCustomLocalDateVO((CustomLocalDateVO)getVO(request, CustomLocalDateVO.class));
			event.setEtcInfoGRPVO(etcInfoGRPVO);					
		} else if (command.isCommand(FormCommand.SEARCH18)) {
			//SPP OFC 정보 가져오기
			EtcInfoGRPVO etcInfoGRPVO = new EtcInfoGRPVO();
			etcInfoGRPVO.setInCustomSPPOFCVO((CustomSPPOFCVO)getVO(request, CustomSPPOFCVO.class));
			event.setEtcInfoGRPVO(etcInfoGRPVO);					
		} else if (command.isCommand(FormCommand.SEARCH19)) {
			// Office 의 Rhq Office 정보 가져오기
			event.setCustomerInfoVO((CustomerInfoVO)getVO(request,CustomerInfoVO.class ));			
		} else if(command.isCommand(FormCommand.SEARCH20)){
			// eqNo 로 rfUnitMaker 조회
			event.setCommonInitDataINVO((CommonInitDataINVO)getVO(request, CommonInitDataINVO.class));
		} else if(command.isCommand(FormCommand.SEARCH21)) {
			//Approval Step 조회 	
			ApprovalStepGRPVO approvalStepGRPVO = new ApprovalStepGRPVO();
			approvalStepGRPVO.setApprovalStepINVO((ApprovalStepINVO)getVO(request, ApprovalStepINVO.class));
			event.setApprovalStepGRPVO(approvalStepGRPVO);
		} else if (command.isCommand(FormCommand.SEARCH22)) {
			// India SAC Code Validation Check : SAC_CD 유무 조회
			event.setMnrCommonVO((MnrCommonVO)getVO(request, MnrCommonVO .class));
		} else if (command.isCommand(FormCommand.SEARCH23)) {
			// India GST Rate 조회(CGST, SGST, IGST, UGST)
			event.setMnrCommonVO((MnrCommonVO)getVO(request, MnrCommonVO .class));
		} else if (command.isCommand(FormCommand.COMMAND01)) {  
			//공통 벨리데이션 체크용 yard,office 
			event.setGeneralCodeINVO((GeneralCodeINVO)getVO(request, GeneralCodeINVO.class ));
		} else if (command.isCommand(FormCommand.COMMAND40)) {
			//EDI SEND
			event.setGeneralCodeINVO((GeneralCodeINVO)getVO(request, GeneralCodeINVO.class ));
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