/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MNR_COM_HTMLAction.java
*@FileTitle : ghost
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박명신
*@LastVersion : 1.0 
* 2009.05.12 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.PartnerMgtINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.BkgTrdCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ComboInitDataINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CommonInitDataINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCurrXchRtVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomUnitPriceVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomerInfoVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.DefaultUnitOfMeasureVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EQGeneralInfoINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.OfficeInfoListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.UnitPriceGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.VesselInfoVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
 
/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.mnr.mnrcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
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
		  
		//공통코드 콤보용 조회
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setComboInitDataINVOS((ComboInitDataINVO[])getVOs(request, ComboInitDataINVO .class,""));
		//공통코드 그리드용 조회
		} else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setCommonInitDataINVO((CommonInitDataINVO)getVO(request, CommonInitDataINVO.class ));
		//EQ General Info 
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setEQGeneralInfoINVO((EQGeneralInfoINVO)getVO(request, EQGeneralInfoINVO.class ));
		//Default Unit Of Measure
		} else if (command.isCommand(FormCommand.SEARCH04)) {       
			event.setDefaultUnitOfMeasureVO((DefaultUnitOfMeasureVO)getVO(request, DefaultUnitOfMeasureVO.class ));	
		//Service Provider Detail Information
		} else if (command.isCommand(FormCommand.SEARCH06)) {    
			event.setPartnerMgtINVO((PartnerMgtINVO)getVO(request, PartnerMgtINVO.class ));    
		//Agreement RATE search	     
		} else if (command.isCommand(FormCommand.SEARCH09)) {       
			AGMTRtINVO agmtRtINVO = (AGMTRtINVO)getVO(request, AGMTRtINVO.class);
			AGMTRtGRPVO agmtRtGRPVO = new AGMTRtGRPVO();
			agmtRtGRPVO.setAGMTRtINVO(agmtRtINVO);
	    	event.setAGMTRtGRPVO(agmtRtGRPVO);
	    //Cost Code 구하기 
		} else if (command.isCommand(FormCommand.SEARCH10)) {       
			CostCodeINVO costCodeINVO = (CostCodeINVO)getVO(request, CostCodeINVO.class);
			CostCodeGRPVO costCodeGRPVO = new CostCodeGRPVO();
			costCodeGRPVO.setCostCodeINVO(costCodeINVO); 
			event.setCostCodeGRPVO(costCodeGRPVO);   
		// Vessel Code과 관련되 Vessel Name,Lane 가져오기	
		} else if (command.isCommand(FormCommand.SEARCH12)) {  
			event.setVesselInfoVO((VesselInfoVO)getVO(request, VesselInfoVO.class ));
		//Status History	
		} else if(command.isCommand(FormCommand.SEARCH13)) {
			StatusHistoryGRPVO statusHistoryGRPVO = new StatusHistoryGRPVO();
			statusHistoryGRPVO.setStatusHistoryINVO((StatusHistoryINVO)getVO(request, StatusHistoryINVO.class));
			event.setStatusHistoryGRPVO(statusHistoryGRPVO);
		//Unit Price 가져오기 
		} else if(command.isCommand(FormCommand.SEARCH14)) {  
			UnitPriceGRPVO unitPriceGRPVO = new UnitPriceGRPVO();
			unitPriceGRPVO.setInCustomUnitPriceVO((CustomUnitPriceVO)getVO(request, CustomUnitPriceVO.class));
			event.setUnitPriceGRPVO(unitPriceGRPVO);	
		// Customer정보 가져오기
		} else if (command.isCommand(FormCommand.SEARCH15)) {  
			event.setCustomerInfoVO((CustomerInfoVO)getVO(request,CustomerInfoVO.class ));
			//Curr Xch Rtw 정보 가져오기
		} else if (command.isCommand(FormCommand.SEARCH16)) {  
			//event.setCustomMdmCurrencyVO((CustomMdmCurrencyVO)getVO(request,CustomMdmCurrencyVO.class ));	
			UnitPriceGRPVO unitPriceGRPVO = new UnitPriceGRPVO();
			unitPriceGRPVO.setCustomCurrXchRtVO((CustomCurrXchRtVO)getVO(request, CustomCurrXchRtVO.class));
			event.setUnitPriceGRPVO(unitPriceGRPVO);				
		//Tariff Flag Check
		} else if (command.isCommand(FormCommand.SEARCH20)) {  
			event.setGeneralCodeINVO((GeneralCodeINVO)getVO(request, GeneralCodeINVO.class ));
		//공통 벨리데이션 체크용 yard,office     	 
		}else if (command.isCommand(FormCommand.COMMAND01)) {  
			event.setGeneralCodeINVO((GeneralCodeINVO)getVO(request, GeneralCodeINVO.class ));
		//EDI SEND	 	 
		} else if (command.isCommand(FormCommand.COMMAND40)) { 	 
			event.setGeneralCodeINVO((GeneralCodeINVO)getVO(request, GeneralCodeINVO.class ));
		} else if (command.isCommand(FormCommand.SEARCH21)) {  
			event.setCommonInitDataINVO((CommonInitDataINVO)getVO(request, CommonInitDataINVO.class ));
		} else if (command.isCommand(FormCommand.SEARCH22)) {  
			event.setBkgTrdCodeVO((BkgTrdCodeVO)getVO(request, BkgTrdCodeVO.class ));
		} else if (command.isCommand(FormCommand.SEARCH23)) {  
			event.setCustomerInfoVO((CustomerInfoVO)getVO(request, CustomerInfoVO.class));
		} else if (command.isCommand(FormCommand.SEARCH24)) {  
			event.setOfficeInfoListVO((OfficeInfoListVO)getVO(request, OfficeInfoListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH25)) {  
			event.setEQGeneralInfoINVO((EQGeneralInfoINVO)getVO(request, EQGeneralInfoINVO.class ));
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