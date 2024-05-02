/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FMSCommonSC.java
*@FileTitle : Vessel Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.basic.ExternalFinderBC;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.basic.ExternalFinderBCImpl;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event.EsmFms0022Event;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event.EsmFms0036Event;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event.EsmFms0077Event;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event.EsmFms0080Event;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event.EsmFms0100Event;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event.FmsComEvent;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration.ExternalFinderDBDAO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCodeInfoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCodeParamVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCommonVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.OtherCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchCarrierCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchCenterCodeVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractInfoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractNoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchDefaultDateVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchLaneCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchMdmAccountCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchPaymenetOfficeCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchVesselVO;
import com.clt.apps.opus.esm.fms.fmscommonutil.BizComFmsUtil;
import com.clt.apps.opus.esm.fms.fmscommonutil.FmsConstants;
import com.clt.bizcommon.util.BizComUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.StringUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-FMSCommon Business Logic ServiceCommand - Handling business transaction of OPUS-FMSCommon
 * 
 * @author 
 * @see ExternalFinderDBDAO
 * @since J2EE 1.5
 */

public class FMSCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Pre-work for FMSCommon system business scenario<br>
	 * Generating inner-object when calling ESM_FMS-0022 business scenario<br>
	 */
	public void doStart() {
		try {
			// Checking log-in
			account = getSignOnUserAccount();
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
		}
	}

	/**
	 * Closing work for FMSCommon system business scenario<br>
	 * Terminating related inner-object when finishing ESM_FMS-0022 business scenario<br>
	 */
	public void doEnd() {
		log.debug("FMSCommonSC 종료");
	}

	/**
	 * Branch processing of all events generated in OPUS-FMSCommon system business<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// using in case SC handles several events
		if (e.getEventName().equalsIgnoreCase("EsmFms0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselCodeList(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVesselCodeName(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFlag(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLocCdName(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkLocCode(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkLaneCode(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkMdmVvdCode(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkRevenueLaneCode(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchCheckCarrierCode(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkEffectiveDate(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCenterCode(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchPaymenetOfficeCodeList();
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = checkAcctCdVvdLevel(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0080Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMdmAccountCodeList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0077Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCarrierCodeList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0036Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneCodeList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0100Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOtherCodeList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOtherCode(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("FmsComEvent")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDefaultDateInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContractNoInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContractInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) { //Tax Type
				eventResponse = searchTaxTypeList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) { //TI/TO VVD Search.
				eventResponse = searchFmsVvdByFletCtrtNo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) { //Service Lane Direction Search.
				eventResponse = searchServiceLaneDirection(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) { //fin Direction Search.
				eventResponse = searchFinDirection(e);
			}
		}
		return eventResponse;
	}


	/**
	 * Handling retrieving a specific list event about Externalfinder event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		ExternalFinderBC command = new ExternalFinderBCImpl();
		
		try{
			List<SearchVesselVO> searchVesselVO = command.searchVesselCodeList(event.getSearchVesselVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchVesselVO);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Performing business scenario relevant to each event<br>
	 * Retrieving Name information relevant to Vessel Code<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselCodeName(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		ExternalFinderBC command = new ExternalFinderBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			List<SearchVesselVO> searchVesselVO = command.searchVesselCodeName(event.getVslCd());
			
			String vslEngNm = "";
			
			if(searchVesselVO.size() > 0) {
				vslEngNm = searchVesselVO.get(0).getVslEngNm();
			}
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("vslEngNm",vslEngNm);
			
			eventResponse.setETCData(etcData);
			
			if(vslEngNm == null || vslEngNm.equals("")) {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01054",new String[]{}).getUserMessage());
			}

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieving Location Name information relevant to Location Code<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocCdName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		ExternalFinderBC command = new ExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String locNm = command.searchLocCdName(event.getLocCd());
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("locNm", locNm);
			eventResponse.setETCData(etcData);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieving Name information relevant to Flag Code<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFlag(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		ExternalFinderBC command = new ExternalFinderBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			String vslCntNm = command.searchFlag(event.getCntCd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("vslCntNm",vslCntNm);
			
			eventResponse.setETCData(etcData);

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
   /**
	* Retrieving data at Item Detail Management<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchMdmAccountCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0080Event event = (EsmFms0080Event)e;
	    
		ExternalFinderBC command = new ExternalFinderBCImpl();
	    
		try {
			List<SearchMdmAccountCodeListVO> searchMdmAccountCodeListVO = command.searchMdmAccountCodeList(event.getAcctCd(),event.getAcctGb());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchMdmAccountCodeListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
    }

	/**
	 * Retrieving Location code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ExternalFinderBC command = new ExternalFinderBCImpl();

		try{
			String dckLocCd = command.checkLocCode(event.getLocCd());
			if(!dckLocCd.equals("")) {
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("cdName", dckLocCd);
				eventResponse.setETCData(etcData);
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01019",new String[]{}).getUserMessage());
			}

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * Retrieving Lane code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLaneCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ExternalFinderBC command = new ExternalFinderBCImpl();
	
		try{
			String laneCd = command.checkLaneCode(event.getLaneCd());
			
			if(!laneCd.equals("")) {
				Map<String,String> etcData = new HashMap<String,String>();
				
				etcData.put("cdName",laneCd);
				
				eventResponse.setETCData(etcData);
				
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01562",new String[]{}).getUserMessage());
			}
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Checking vvd code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMdmVvdCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExternalFinderBC command = new ExternalFinderBCImpl();

		try{
			String tmpChkVvd = command.checkMdmVvdCode(event.getVvdCd());
			
			String[] arrChkVvd = StringUtils.split(tmpChkVvd,"|");			
			
			if(arrChkVvd != null && arrChkVvd.length > 0 && StringUtils.isNotEmpty(arrChkVvd[0]) && StringUtils.isNotEmpty(arrChkVvd[1])){
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("chk_vvd",tmpChkVvd);
				eventResponse.setETCData(etcData);
			}else{
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01558",new String[]{}).getUserMessage());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	* Carrier Code Selection - Window 화면에서 데이타 조회<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchCarrierCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0077Event event = (EsmFms0077Event)e;
	    
		ExternalFinderBC command = new ExternalFinderBCImpl();
	    
		try {
			List<SearchCarrierCodeListVO> searchCarrierCodeListVO = command.searchCarrierCodeList(event.getCarrNm());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchCarrierCodeListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	* Lane Code Search - Window 화면에서 데이타 조회<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchLaneCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0036Event event = (EsmFms0036Event)e;
		ExternalFinderBC command = new ExternalFinderBCImpl();
	    
		try {
			List<SearchLaneCodeListVO> searchLaneCodeListVO = command.searchLaneCodeList(event.getSearchLaneCodeListVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchLaneCodeListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * Retrieving Lane code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRevenueLaneCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ExternalFinderBC command = new ExternalFinderBCImpl();
	
		try{
			String laneCd = command.checkRevenueLaneCode(event.getLaneCd());
			
			FmsCommonVO fmsCommonVO = new FmsCommonVO();
			fmsCommonVO.setRlaneCd(event.getLaneCd());
			
			String sArUsedYn = command.searchArFincDirConvUsedFlag(fmsCommonVO);
			
			if(!laneCd.equals("")) {
				Map<String,String> etcData = new HashMap<String,String>();
				
				etcData.put("cdName",laneCd);
				etcData.put("arUsedYn", sArUsedYn);
				
				eventResponse.setETCData(etcData);
				
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01563",new String[]{}).getUserMessage());
			}
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Retrieving Carrier code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckCarrierCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ExternalFinderBC command = new ExternalFinderBCImpl();
	
		try{
			String crrCd = command.searchCheckCarrierCode(event.getCrrCd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("crrCd",crrCd);
			
			eventResponse.setETCData(etcData);
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * Retrieving Effective Date<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkEffectiveDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ExternalFinderBC command = new ExternalFinderBCImpl();
	
		try{
			SearchDefaultDateVO searchDefaultDateVO = command.checkEffectiveDate(event.getSlpOfcCd(), event.getEffDt(), event.getCsrType());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			String strEffDt = "";
			String strVvdCxlFlg = "";
			if(null != searchDefaultDateVO){
				strVvdCxlFlg = searchDefaultDateVO.getVvdCxlFlg();
				strEffDt = searchDefaultDateVO.getEffDt();
			}else{
				strVvdCxlFlg = "E";
			}
			

			etcData.put("clos_yn",strVvdCxlFlg);
			etcData.put("eff_dt" ,strEffDt);
			
			eventResponse = (GeneralEventResponse)searchExchangeRate(e);
			
			eventResponse.setETCData(etcData);
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Retrieving Center Code / City Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCenterCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ExternalFinderBC command = new ExternalFinderBCImpl();
	
		try{
			List<SearchCenterCodeVO> searchCenterCodeVO = command.searchCenterCode(event.getSlpOfcCd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("apCtrCd",searchCenterCodeVO.get(0).getApCtrCd());
			etcData.put("locCd",searchCenterCodeVO.get(0).getLocCd());
			
			eventResponse.setETCData(etcData);
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	* Carrier Code Selection - Window 화면에서 데이타 조회<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchPaymenetOfficeCodeList() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    
		ExternalFinderBC command = new ExternalFinderBCImpl();
	    
		try {
			List<SearchPaymenetOfficeCodeListVO> searchPaymenetOfficeCodeListVO = command.searchPaymenetOfficeCodeList();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			
			if(searchPaymenetOfficeCodeListVO.size() > 0) {
				for(int i=0; i<searchPaymenetOfficeCodeListVO.size(); i++) {
					sb1.append(searchPaymenetOfficeCodeListVO.get(i).getOfcCd()+"|");
					sb2.append(searchPaymenetOfficeCodeListVO.get(i).getOfcNm()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("ofc_cd",sb1.toString());
			etcData.put("ofc_nm",sb2.toString());
			
			eventResponse.setETCData(etcData);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01408",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Retrieving currency rate<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExchangeRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ExternalFinderBC command = new ExternalFinderBCImpl();
	
		try{
			String usdLoclXchRt = command.searchExchangeRate(event.getEffDt());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("usdLoclXchRt",usdLoclXchRt);
			
			eventResponse.setETCData(etcData);
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VVD Level Check for each account
	 * Checking account voyage level <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkAcctCdVvdLevel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExternalFinderBC command = new ExternalFinderBCImpl();

		try{
			String vslCd = command.checkAcctCdVvdLevel(event.getAcctCd(), event.getVvdCd());
			
			if(vslCd.equals("")) {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01558",new String[]{}).getUserMessage());
			} else {
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("vslCd",vslCd);
				eventResponse.setETCData(etcData);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	* Retrieve Other Code List <br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchOtherCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExternalFinderBC command = new ExternalFinderBCImpl();
		EsmFms0100Event event = (EsmFms0100Event)e;
		
		try {
			List<OtherCodeListVO> otherCodeListVO = command.searchOtherCodeList(event.getCodeTp());
			eventResponse.setRsVoList(otherCodeListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	
	 /**
	 * Save Other Code List (insert / modify / remove)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOtherCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0100Event event = (EsmFms0100Event)e;
		ExternalFinderBC command = new ExternalFinderBCImpl();
	
		try {
			OtherCodeListVO[] otherCodeListVOs = event.getOtherCodeListVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			command.manageOtherCode(otherCodeListVOs, usrId);
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage()); //error msg
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }
	
	/**
	* Retrieve Other Code List <br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchDefaultDateInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExternalFinderBC command = new ExternalFinderBCImpl();
		FmsComEvent event = (FmsComEvent)e;
		
		try {
			List<SearchDefaultDateVO> vo = command.searchDefaultDateInfo(event.getSearchDefaultDateVO());
			
			String requestDt = "";
			String effectiveDt = "";
			if(vo != null && vo.size() > 0) {
				requestDt = vo.get(0).getRqstDt();
				effectiveDt = vo.get(0).getEffDt();
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("rqst_dt",requestDt);
			etcData.put("eff_dt",effectiveDt);
			
			eventResponse.setETCData(etcData);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	
	/**
	* Retrieve ContractNo <br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchContractNoInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExternalFinderBC command = new ExternalFinderBCImpl();
		FmsComEvent event = (FmsComEvent)e;
		
		try {
			List<SearchContractNoVO> vo = command.searchContractNoInfo(event.getSearchContractNoVO());
			
			String fletCtrtNo = "";
			if(vo != null && vo.size() > 0) {
				fletCtrtNo = vo.get(0).getFletCtrtNo();
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("flet_ctrt_no",fletCtrtNo);
			
			eventResponse.setETCData(etcData);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	
	/**
	* Retrieve ContractInfo <br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchContractInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExternalFinderBC command = new ExternalFinderBCImpl();
		FmsComEvent event = (FmsComEvent)e;
		
		try {
			String strCallSlipTpCd = event.getSearchContractInfoVO().getCallSlipTpCd();
			List<SearchContractInfoVO> voList = command.searchContractInfo(event.getSearchContractInfoVO());
			
			String tmpFletCtrtTpCd = "";
			String tmpFletCtrtTpNm = "";
			String tmpVndrSeq = "";
			String tmpVndrNm = "";
			String tmpCustCntCd = "";
			String tmpCustSeq = "";
			String tmpCustCntNm = "";
			String tmpDataRows = "1";
			
			
			if(voList.size() > 0) {	
				//비용전표일때 Contract 조회.
				if("P".equals(strCallSlipTpCd)){
					if (voList.get(0).getFletCtrtTpCd().equals("TO")) {
						List<SearchContractInfoVO> vendorList = command.searchVendorByContractNo(event.getSearchContractInfoVO());
						if(vendorList != null && vendorList.size() > 0 && vendorList.get(0).getVndrSeq() != ""){
							tmpFletCtrtTpCd = voList.get(0).getFletCtrtTpCd();
							tmpFletCtrtTpNm = voList.get(0).getFletCtrtTpNm();
							tmpVndrSeq 		= vendorList.get(0).getVndrSeq();
							tmpVndrNm 		= vendorList.get(0).getVndrLglEngNm();
							tmpCustCntCd 	= voList.get(0).getCustCntCd();
							tmpCustSeq 		= voList.get(0).getCustSeq();
							tmpCustCntNm 	= voList.get(0).getCustLglEngNm();
						}else{
							tmpFletCtrtTpCd = voList.get(0).getFletCtrtTpCd();
							tmpFletCtrtTpNm = voList.get(0).getFletCtrtTpNm();
							tmpVndrSeq 		= voList.get(0).getVndrSeq();
							tmpVndrNm 		= voList.get(0).getVndrLglEngNm();
							tmpCustCntCd 	= voList.get(0).getCustCntCd();
							tmpCustSeq 		= voList.get(0).getCustSeq();
							tmpCustCntNm 	= voList.get(0).getCustLglEngNm();
						}						
					}else{
						tmpFletCtrtTpCd = voList.get(0).getFletCtrtTpCd();
						tmpFletCtrtTpNm = voList.get(0).getFletCtrtTpNm();
						tmpVndrSeq 		= voList.get(0).getVndrSeq();
						tmpVndrNm 		= voList.get(0).getVndrLglEngNm();
						tmpCustCntCd 	= voList.get(0).getCustCntCd();
						tmpCustSeq 		= voList.get(0).getCustSeq();
						tmpCustCntNm 	= voList.get(0).getCustLglEngNm();
					}
				}else if("R".equals(strCallSlipTpCd)){//수입전표일때 Contract 조회.
					if (voList.get(0).getFletCtrtTpCd().equals("TI")) {
						List<SearchContractInfoVO> customerList = command.searchCustomerListByVendor(event.getSearchContractInfoVO());
						if(customerList != null && customerList.size() > 0 && customerList.get(0).getVndrSeq() != ""){
							tmpFletCtrtTpCd = voList.get(0).getFletCtrtTpCd();
							tmpFletCtrtTpNm = voList.get(0).getFletCtrtTpNm();
							tmpVndrSeq 		= voList.get(0).getVndrSeq();
							tmpVndrNm 		= voList.get(0).getVndrLglEngNm();
							tmpCustCntCd 	= customerList.get(0).getCustCntCd();
							tmpCustSeq 		= customerList.get(0).getCustSeq();
							tmpCustCntNm 	= customerList.get(0).getCustLglEngNm();
							tmpDataRows 	= customerList.size()+"";
						}
					}else{
						tmpFletCtrtTpCd = voList.get(0).getFletCtrtTpCd();
						tmpFletCtrtTpNm = voList.get(0).getFletCtrtTpNm();
						tmpVndrSeq 		= voList.get(0).getVndrSeq();
						tmpVndrNm 		= voList.get(0).getVndrLglEngNm();
						tmpCustCntCd 	= voList.get(0).getCustCntCd();
						tmpCustSeq 		= voList.get(0).getCustSeq();
						tmpCustCntNm 	= voList.get(0).getCustLglEngNm();
					}
				}
				
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("fletCtrtTpCd"	,tmpFletCtrtTpCd);
				etcData.put("fletCtrtTpNm"	,tmpFletCtrtTpNm);
				etcData.put("vndrSeq"		,tmpVndrSeq);
				etcData.put("vndrNm"		,tmpVndrNm);
				etcData.put("CustCntCd"		,tmpCustCntCd);
				etcData.put("CustSeq"		,tmpCustSeq);
				etcData.put("CustLglEngNm"	,tmpCustCntNm);
				etcData.put("dataRows"		,tmpDataRows);
				eventResponse.setETCData(etcData);
				
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01505",new String[]{}).getUserMessage());
			}
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	
	/**
	 * Tax Type Search.
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchTaxTypeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FmsComEvent event = (FmsComEvent)e;
		ExternalFinderBC command = new ExternalFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FmsCodeParamVO vo = event.getFmsCodeParamVO();
		if(vo.getCode() == null || vo.getCode().equals("")){
			vo.setCode(FmsConstants.KEY_TAX_TYPE_CODE);//AP TAX CODE
		}		
		List<FmsCodeInfoVO> taxList = command.searchTaxTypeList(vo);		
		
		//N사 2014.11.07 기준으로 AP Tax Free 만 사용함.
		List<FmsCodeInfoVO> tmpTaxList = new ArrayList<FmsCodeInfoVO>();
		for(FmsCodeInfoVO codeVo : taxList){
			if(FmsConstants.KEY_EVIDENCE_CLASS_F0.equals(codeVo.getCode())){
				tmpTaxList.add(codeVo);
			}
		}		
		String evidTp[] = StringUtil.split(BizComFmsUtil.getCodeSelectString(tmpTaxList), BizComUtil.CODE_DELIMITTER);	
		
		
		eventResponse.setETCData(vo.getComCode() ,evidTp[0]);
		eventResponse.setETCData(vo.getComText() ,evidTp[1]);
		return eventResponse;
	}
	
	/**
	* TI/TO VVD Search <br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchFmsVvdByFletCtrtNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExternalFinderBC command = new ExternalFinderBCImpl();
		FmsComEvent event = (FmsComEvent)e;
		
		try {
			String vvds = command.searchFmsVvdByFletCtrtNo(event.getFmsCommonVO());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("vvds",StringUtils.isEmpty(vvds) ? "" : vvds);
			
			eventResponse.setETCData(etcData);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	
	/**
	 * Service Lane direction 에 조회.<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchServiceLaneDirection(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExternalFinderBC command = new ExternalFinderBCImpl();
		FmsComEvent event = (FmsComEvent)e;
		
		try {
			FmsCommonVO fmsCommonVo = event.getFmsCommonVO();
			String slanDirCd = command.searchServiceLaneDirection(fmsCommonVo);
			
			String rlaneDirCd = command.searchFinDirection(fmsCommonVo);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("slanDirCd",StringUtils.isEmpty(slanDirCd) ? "" : slanDirCd);
			etcData.put("rlaneDirCd",StringUtils.isEmpty(rlaneDirCd) ? "" : rlaneDirCd);
			
			eventResponse.setETCData(etcData);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	
	/**
	 * Service Lane direction 에 조회.<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchFinDirection(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExternalFinderBC command = new ExternalFinderBCImpl();
		FmsComEvent event = (FmsComEvent)e;
		
		try {
			String rlaneDirCd = command.searchFinDirection(event.getFmsCommonVO());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("rlaneDirCd",StringUtils.isEmpty(rlaneDirCd) ? "" : rlaneDirCd);
			
			eventResponse.setETCData(etcData);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
}