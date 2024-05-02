/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FMSCommonSC.java
*@FileTitle : Vessel Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.24
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.24 정윤태
* 1.0 Creation
* 2010.08.16 윤진영 CHM-201005318 searchMdmAccountCodeList 에서 account_code와 account_name으로 조회가능하도록 수정
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.basic.ExternalFinderBC;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.basic.ExternalFinderBCImpl;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.event.EsmFms0022Event;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.event.EsmFms0036Event;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.event.EsmFms0077Event;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.event.EsmFms0080Event;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.event.FmsComEvent;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration.ExternalFinderDBDAO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchCarrierCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchCenterCodeVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchLaneCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchMdmAccountCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchPaymenetOfficeCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchSplRgstNoVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchVesselVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchContractNoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.basic.FMSFileUploadBC;
import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.basic.FMSFileUploadBCImpl;
import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.event.EsmFms0092Event;
import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBC;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBCImpl;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AsaNoVO;

/**
 * ALPS-FMSCommon Business Logic ServiceCommand - ALPS-FMSCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Yoon-Tae, Jung
 * @see ExternalFinderDBDAO
 * @since J2EE 1.5 
 */

public class FMSCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * FMSCommon system 업무 시나리오 선행작업<br>
	 * ESM_FMS-0022업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
		}
	}

	/**
	 * FMSCommon system 업무 시나리오 마감작업<br>
	 * ESM_FMS-0022 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("FMSCommonSC 종료");
	}

	/**
	 * ALPS-FMSCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchSplRgstNo(e);
				
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
		}else if (e.getEventName().equalsIgnoreCase("EsmFms0092Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
                eventResponse = searchCsrFileUploadList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCsrFileUpload(e);
            }			
		} else if(e.getEventName().equalsIgnoreCase("FmsComEvent")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContractNoInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPayTermByVndrSeq(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRgstNoByVndrSeq(e);
			}
		}
		
		return eventResponse;
	}
	/**
	 * Externalfinder의 event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Vessel 코드에 해당하는 Name 정보 조회<br>
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
	 * Location Code에 해당하는 Location Name 정보 조회<br>
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
	 * Flag 코드에 해당하는 Name 정보 조회<br>
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
	* Item Detail Management 화면에서 데이타 조회<br>
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
	 * Location code 조회<br>
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
	 * Lane code 조회<br>
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
	 * vvd code 체크<br>
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
			String vslCd = command.checkMdmVvdCode(event.getVvdCd());
			
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
	 * Lane code 조회<br>
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
			
			if(!laneCd.equals("")) {
				Map<String,String> etcData = new HashMap<String,String>();
				
				etcData.put("cdName",laneCd);
				
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
	 * Carrier code 조회<br>
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
	 * Effective Date 조회<br>
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
			String effDt = command.checkEffectiveDate(event.getSlpOfcCd(), event.getEffDt());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("effDt",effDt);
			
			String usdLoclXchRt = command.searchExchangeRate(event.getEffDt());
			etcData.put("usdLoclXchRt",usdLoclXchRt);
								
//			eventResponse = (GeneralEventResponse)searchExchangeRate(e);
			eventResponse = (GeneralEventResponse)searchAsaList(e);
						
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
	 * Center Code / City Code 조회<br>
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
	 * 사업자 등록번호 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSplRgstNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ExternalFinderBC command = new ExternalFinderBCImpl();
	
		try{
			List<SearchSplRgstNoVO> searchSplRgstNoVO = command.searchSplRgstNo(event.getSlpRgstNo());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("coNm",searchSplRgstNoVO.get(0).getVndrLoclLangNm());
			etcData.put("ownrNm",searchSplRgstNoVO.get(0).getCeoNm());
			etcData.put("bzctNm",searchSplRgstNoVO.get(0).getBzctNm());
			etcData.put("bztpNm",searchSplRgstNoVO.get(0).getBztpNm());
			etcData.put("splAddr",searchSplRgstNoVO.get(0).getLoclLangAddr());
			etcData.put("vndrSeq",searchSplRgstNoVO.get(0).getVndrSeq());
			
			eventResponse.setETCData(etcData);
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01409",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
//	/**
//	 * 환율 조회<br>
//	 * 
//	 * @param e Event
//	 * @return response EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchExchangeRate(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		EsmFms0022Event event = (EsmFms0022Event)e;
//		
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		
//		ExternalFinderBC command = new ExternalFinderBCImpl();
//	
//		try{
//			String usdLoclXchRt = command.searchExchangeRate(event.getEffDt());
//			
//			Map<String,String> etcData = new HashMap<String,String>();
//			
//			etcData.put("usdLoclXchRt",usdLoclXchRt);
//			
//			eventResponse.setETCData(etcData);
//	
//		} catch(EventException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		} catch(Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		
//		return eventResponse;
//	}
	
	/**
	 * Account 별 VVD Level Check
	 * 계정 항차 레벨 검사<br>
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

	//#################	
	/**
	 * File Upload 조회<br>
	 * @author 민정호
	 * @category ESM_FMS_0092
	 * @category searchCsrFileUploadList
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCsrFileUploadList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			FMSFileUploadBC command = new FMSFileUploadBCImpl();

			EsmFms0092Event event = (EsmFms0092Event)e;

			String vslCd = event.getVslCd();
			String vnorSeq = event.getVnorSeq();
			String vnorItmSeq = event.getVnorItmSeq();

			// Owner's Account Attach
			String csrNo = event.getCsrNo();
			
			List<FileUploadListVO> list = null;
			
			if("".equals(csrNo)) {
				list = command.searchCsrFileUploadList(vslCd, vnorSeq, vnorItmSeq);
				
			}else{
				list = command.searchCsrFileUploadListOA(csrNo);
				
			}

			eventResponse.setRsVoList(list);

		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	// ---------------------------------------------------------------------------
	// [FNS_JOO_0098] File Upload
	// ---------------------------------------------------------------------------
	/**
	 * File Upload 수정 ,입력<br>
	 * @author 민정호
	 * @category FNS_JOO_0098
	 * @category manageCsrFileUpload
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCsrFileUpload(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			begin();

			// BC 객체 생성
			FMSFileUploadBC command = new FMSFileUploadBCImpl();

			EsmFms0092Event event = (EsmFms0092Event)e;

			FileUploadListVO[] fileUploadListVOs = event.getFileUploadListVOs();
			FileUploadListVO vo = fileUploadListVOs[0];

			vo.setUpdUsrId(account.getUsr_id());

			String vslCd = event.getVslCd();
			String vnorSeq = event.getVnorSeq();
			String vnorItmSeq = event.getVnorItmSeq();			
			
			// Owner's Account Attach
			String csrNo = event.getCsrNo();
			
			if("".equals(csrNo)) {
				command.manageCsrFileUpload(fileUploadListVOs, vslCd, vnorSeq, vnorItmSeq);
				
			}else{
				command.manageCsrFileUploadOA(fileUploadListVOs, csrNo);
			}

			// 성공 메세지설정
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			eventResponse.setETCData("ERROR_YN", "N");

			commit();

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}


		return eventResponse;
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
			String fletCtrtTpCd = "";
			if(vo != null && vo.size() > 0) {
				fletCtrtNo = vo.get(0).getFletCtrtNo();
				fletCtrtTpCd = vo.get(0).getFletCtrtTpCd();
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("flet_ctrt_no",fletCtrtNo);
			etcData.put("flet_ctrt_tp_cd",fletCtrtTpCd);	//2017.05.15 contract type 콤보로 변경
			
			eventResponse.setETCData(etcData);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	//*****************************	
	
	/**
	* Retrieve Pay Term by Supplier <br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchPayTermByVndrSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExternalFinderBC command = new ExternalFinderBCImpl();
		FmsComEvent event = (FmsComEvent)e;
		
		try {
			String rsStr = command.searchPayTermByVndrSeq(event.getsValue());
						
			Map<String, String> etcData = new HashMap<String,String>();

			etcData.put("pay_term", rsStr);
			
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
	* Retrieve Rgst No m by Supplier <br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchRgstNoByVndrSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExternalFinderBC command = new ExternalFinderBCImpl();
		FmsComEvent event = (FmsComEvent)e;
		
		try {
			String rsStr = command.searchRgstNoByVndrSeq(event.getsValue());
						
			Map<String, String> etcData = new HashMap<String,String>();

			etcData.put("rgst_no", rsStr);
			
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
	 * ASA 목록 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAsaList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0022Event event = (EsmFms0022Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();			
	
		try{
			String invOfcCd  =  account.getOfc_cd(); 
			String apOfcCd 	 =  account.getOfc_cd();	
			String issDt 	 =  event.getEffDt();
														
			List<AsaNoVO> list2 = command.searchAsaNoList(invOfcCd, apOfcCd, issDt);						
			String comboList = makeComboString(list2, 0);			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("asa_no",comboList);
			
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
	 * 공통 : combo용 String
	 * List를 combo용 String으로 만들어준다. 
	 * @param List<AsaNoVO> list
	 * @param int flg
	 * @return String
	 * @throws EventException
	 */
	private String makeComboString(List<AsaNoVO> list, int flg) throws Exception{
        try{
			String rtnVal = null;
			StringBuilder sb = new StringBuilder();
			
			Iterator iterator = (Iterator) list.iterator();
	
			while(iterator.hasNext()){
				AsaNoVO vo = (AsaNoVO)iterator.next();
				//일반적인 IBCombo용(name, code|)
				if (flg==0){
					sb.append(vo.getName()+","+vo.getCode()+"|");
				//IBCombo (code, code|)
				}else if (flg==1){
					sb.append(vo.getName()+","+vo.getName()+"|");
				//IBSheet의 코드부분(code|)
				}else if (flg==2){ 
					sb.append(vo.getCode()+"|");
				//IBSheet의 코드명부분(name|)
				}else if (flg==3){
					sb.append(vo.getName()+"|"); 
				}
			}
			rtnVal = sb.toString();
	
			if (rtnVal.length() > 0){
				rtnVal = rtnVal.substring(0,rtnVal.length()-1);
			}
			
			return rtnVal;
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}	
	
}