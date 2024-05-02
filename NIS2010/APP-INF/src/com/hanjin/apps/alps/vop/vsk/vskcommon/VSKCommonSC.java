/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCommonSC.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.29 서창열
* 1.0 Creation
*
* History
* 2011.03.25 진마리아 CHM-201109579-01 Lane Code의 Direction 조회 칼럼 추가 요청
* 2011.10.11 진마리아 CHM-201112822-01 Lane Code inquiry내 trade 및 Sub trade, SKD 로 lane Code 정보를 조회 가능하도록 로직 수정
* 2011.10.11 진마리아 CHM-201112898-01 Port Code Inquiry 조회 조건 추가 - Conti, Sconti, lat, long, period 등
* 2012.04.12 진마리아 CHM-201217105-01 MDM Vessel Delete 여부를 조회조건 및 결과에 추가 및 paging처리
* 2013.09.10 정상기 [CHM-201325067]   [VOP-VSK] 스케줄 변경 시 개인별 설정 시간에 따라 개별 메일 통지 기능
* 2015.07.24 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0044Event;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0046Event;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0064Event;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0221Event;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0252Event;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VopVskVosiEvent;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VskComEvent;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VskGloEvent;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration.VSKCodeFinderDBDAO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoGRPVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LaneDirVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PhaseInOutReasonVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.RqstSimNoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VslSvcLaneforBudgetVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * NIS2010-VSKCommon Business Logic ServiceCommand - NIS2010-VSKCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SEO CHANG YUL
 * @see VSKCodeFinderDBDAO
 * @since J2EE 1.4
 */

public class VSKCommonSC extends ServiceCommandSupport {
	// Login User Information
//	private SignOnUserAccount account = null;

	/**
	 * VSKCommon system 업무 시나리오 선행작업<br>
	 * UI_VSK-0202업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try { 
			// 일단 comment --> 로그인 체크 부분
			//account = getSignOnUserAccount();
		} catch (Exception e) {log.error(e.getMessage());}
	}

	/**
	 * VSKCommon system 업무 시나리오 마감작업<br>
	 * UI_VSK-0202 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("VSKCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-VSKCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VskGloEvent")) {		
			//0202
			if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				eventResponse = searchSvcLaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND12)){
				eventResponse = checkSvcLane(e);
				
			//::Lane Code Popup-New(for BUDGET):://
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND23)) {
				eventResponse = searchSvcLaneforBudgetList(e);
			//0043
			}else	if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {			
				eventResponse = searchPortList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND14)) {
				eventResponse = searchCountryList(e);
			}
			//0244
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND15)) {
				eventResponse = searchCountryList(e);
			}
			//0219
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND16)) {
				eventResponse = searchVslList(e);
			}
			//0230
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND17)) {
				eventResponse = searchRsltVvdList(e);
			}
			//0212
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND18)) {
				eventResponse = searchPfLaneTypeList(e);
			}
			//0205
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND19)) {
				eventResponse = searchPhsInOutRsnList(e);
			}
			//0201
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND20)) {
				eventResponse = searchSimNoList(e);
			}
			//0044
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND21)) {
				eventResponse = searchVslList(e);
			}
			//0252	
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND22)) {
				eventResponse = searchCodeInfoList(e);
			}
			
		//향후 Com Event는 SEARCH,SEARCH01,... 으로 	
		} else if (e.getEventName().equalsIgnoreCase("VskComEvent")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneServiceType();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchVslClsList();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchVslClsDznCapaList();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = checkSvcLane(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = searchYardListByCountry(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND12)){
				eventResponse = checkPort(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)){
				eventResponse = searchSkdDirPortCdforProformaList(e);				
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0221Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPortBasic(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCountryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchScontiList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselListByCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCarrierList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneDirList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLaneBasic(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0064Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCodeInfoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0252Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCodeInfoList(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("VopVskVosiEvent")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommonCode(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLane(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkLane(e);
			}
		}
		return eventResponse;
	}

	/**
	 * Port 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPortList(Event e) throws EventException {
		try{
			LocationVO locationVO = null;
			if (e instanceof VskGloEvent) {
				VskGloEvent event = (VskGloEvent) e;
				locationVO = event.getLocationVO();
			}

			List<LocationVO> list = searchPortList(locationVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			/*
			 * 1건 조회시, 해당 Port명을 etc데이터(Key : port_name)로 등록
			 */
			if (list != null && list.size() == 1) {
				LocationVO vo = list.get(0);
				eventResponse.setETCData("port_name", vo.getLocNm());
				eventResponse.setETCData("zd", vo.getZd());
			}
			return eventResponse;	
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
	}

//	/**
//	 * 지역본부 리스트를 조회합니다.<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse response
//	 * @exception EventException
//	 */
//	private EventResponse searchRhqList(Event e) throws EventException {
//		try {
//			// PDTO(Data Transfer Object including Parameters)
//			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
//			List<OfficeVO> list = command.searchRhqList();
//			GeneralEventResponse eventResponse = new GeneralEventResponse();
//			eventResponse.setRsVoList(list);
//			return eventResponse;			
//		} catch(EventException ex) {
//			throw ex;
//		} catch(Exception ex) {
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		}
//	}

	/**
	 * Port 리스트를 조회합니다.<br>
	 * 
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	private List<LocationVO> searchPortList(LocationVO locationVO) throws EventException {
		try {
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			List<LocationVO> list = command.searchPortList(locationVO);
			return list;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * 국가 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCountryList(Event e) throws EventException {
		try {
			MdmCountryVO vo = null;
			if(e instanceof VskGloEvent){
				VskGloEvent event = (VskGloEvent) e;
				vo = event.getMdmCountryVO();
			}else if(e instanceof VopVsk0221Event){
				VopVsk0221Event event = (VopVsk0221Event)e;
				vo = event.getMdmCountryVO();
			}
			
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			List<MdmCountryVO> list = new ArrayList<MdmCountryVO>();
			if (vo != null) {
				list = command.searchCountryList(vo.getCntCd());
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if(list!=null && list.size()==1){
				eventResponse.setETCData("cnt_nm", list.get(0).getCntNm());
			}
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * Service Lane 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSvcLaneList(Event e) throws EventException {
		try {
			MdmVslSvcLaneVO vo = null;
			if(e instanceof VskGloEvent){
				VskGloEvent event = (VskGloEvent) e;
				vo = event.getMdmVslSvcLaneVO();
			}else if(e instanceof VopVsk0046Event){
				VopVsk0046Event event = (VopVsk0046Event)e;
				vo = event.getMdmVslSvcLaneVO();
			}
			
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			List<MdmVslSvcLaneVO> list = command.searchSvcLaneList(vo);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if(list!=null && list.size()==1){
				eventResponse.setETCData("vsl_slan_nm", list.get(0).getVslSlanNm());
			}
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Service Lane (for BUDGET) 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSvcLaneforBudgetList(Event e) throws EventException {
		try {
			VslSvcLaneforBudgetVO 	vo 		= null;
			if(e instanceof VskGloEvent){
				VskGloEvent 	event 	= (VskGloEvent) e;
				vo = event.getVslSvcLaneforBudgetVO();
			}
			
			VSKCodeFinderBC 			command 		= new VSKCodeFinderBCImpl();
			List<VslSvcLaneforBudgetVO> list 			= command.searchSvcLaneforBudgetList(vo);
			GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			if(list != null && list.size() == 1){
				eventResponse.setETCData("vsl_slan_nm", list.get(0).getVslSlanNm());
			}
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}	

	/**
	 * Lane의 Service Type 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchLaneServiceType() throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			String tempCd = "CD00717";
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> cdList = (ArrayList<CodeInfo>) cdUtil
					.getCodeSelect(tempCd, 1);
			StringBuffer data = new StringBuffer();
	
			if (cdList != null && cdList.size() > 0) {
				for (int i = 0; i < cdList.size(); i++) {
	
					data.append(cdList.get(i).getCode());
					data.append(",");
					data.append(cdList.get(i).getName());
					if (i < cdList.size() - 1)
						data.append("|");
				}
			}
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("lane", data.toString());
			return eventResponse;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * VOP_VSK_0219 : Retrieve
	 * Vessel 리스트를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchVslList(Event e) throws EventException {
		try {
			VesselVO vesselVO = null;
			if (e instanceof VskGloEvent) {
				VskGloEvent event = (VskGloEvent) e;
				vesselVO = event.getVesselVO();
			}
	
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			List<VesselVO> list = command.searchVslList(vesselVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if (list.size() == 0) {
				 eventResponse.setUserMessage(new ErrorHandler("VSK10027").getUserMessage());
			}else if(list.size()==1){
				eventResponse.setETCData("vsl_eng_nm", list.get(0).getVslEngNm());
				eventResponse.setETCData("fdr_div_cd", list.get(0).getFdrDivCd());
			}
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * VOP_VSK_0027 : Port Change
	 * 국가에 대한 Yard 목록을 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchYardListByCountry(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			YardVO paramVO = null;
			
			if (e instanceof VskComEvent) {
				VskComEvent event = (VskComEvent) e;
				paramVO = event.getYardVO();
			}
			
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			List<YardVO> list = command.searchYardListByCountry(paramVO);
			
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
	
			if(list != null && list.size() > 0){
				sb.append(list.get(0).getYdKind());
				sb1.append(list.get(0).getYdCd());
				sb2.append(list.get(0).getYdNm());
				for (int i = 1; i < list.size(); i++) {
					sb.append("|");
					sb1.append("|");
					sb2.append("|");
					sb.append(list.get(i).getYdKind());
					sb1.append(list.get(i).getYdCd());
					sb2.append(list.get(i).getYdNm());
				}
			}
			
			eventResponse.setETCData("yd_kind", sb.toString());
			eventResponse.setETCData("yd_cd", sb1.toString());
			eventResponse.setETCData("yd_nm", sb2.toString());
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * 정시 VVD 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRsltVvdList(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			VskGloEvent event = (VskGloEvent) e;
	
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			List<VvdPortLaneOtherVO> list = null;
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if ("RSLT".equals(event.getVvdPortLaneOtherVO().getCtrlCd())) {
				list = command.searchRsltVvdList(event.getVvdPortLaneOtherVO().getVslCd());
				if(list!=null && list.size()>0){
					// 화면에서 VVD를 입력했을시 해당 VVD가 존재하는지 체크한다.
					eventResponse.setETCData("vvd", list.get(0).getVslCd() + list.get(0).getSkdVoyNo() + list.get(0).getSkdDirCd());
				}
			} else if ("NORL".equals(event.getVvdPortLaneOtherVO().getCtrlCd())) {
				list = command.searchEstVvdList(event.getVvdPortLaneOtherVO()
						.getVslCd());
			}
			eventResponse.setRsVoList(list);
	
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * P/F Lane Type 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPfLaneTypeList(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			VskGloEvent event = (VskGloEvent)e;
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl(); 
			List<PfLaneTypeVO> list = command.searchPfLaneTypeList(event.getPfLaneTypeVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Lane Code가 유효한지 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkSvcLane(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
			
			if (e instanceof VskGloEvent) {
				VskGloEvent event = (VskGloEvent) e;
				mdmVslSvcLaneVO = event.getMdmVslSvcLaneVO();
			}
			else if (e instanceof VskComEvent) {
				VskComEvent event = (VskComEvent) e;
				mdmVslSvcLaneVO = event.getMdmVslSvcLaneVO();
			}
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			List<MdmVslSvcLaneVO> list = null;
			if(mdmVslSvcLaneVO != null){
				list = command.checkSvcLane(mdmVslSvcLaneVO);
			}
			StringBuffer data = new StringBuffer();
			String vslSvcTpCd = "";
	
			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i).getVslSlanNm());
					vslSvcTpCd = list.get(i).getVslSvcTpCd();
					if (i < list.size()-1)
						data.append("|");
				}
				eventResponse.setETCData("checkLane", data.toString());
				eventResponse.setETCData("checkLaneTpCd", vslSvcTpCd);
			}else{	 
				eventResponse.setETCData("checkLane", "");
				eventResponse.setUserMessage(new ErrorHandler("VSK10019").getUserMessage());
	//			throw new EventException(new ErrorHandler("VSK10019").getUserMessage());
			}
	
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Port Code가 유효한지 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkPort(Event e) throws EventException {
		
		GeneralEventResponse 	eventResponse = new GeneralEventResponse();
		MdmLocationVO 			mdmLocationVO = null;
		
		try {

			if(e instanceof VskComEvent){
				VskComEvent event		= (VskComEvent) e;
				mdmLocationVO			= event.getMdmLocationVO();			
			}
			
			if(mdmLocationVO != null){
				VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
				String 			chkPort = command.checkPort(mdmLocationVO.getLocCd());
				eventResponse.setETCData("check_port", chkPort);				
			}
			return eventResponse;
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	

	/**
	 * 특정 Vessel Service Lane의 Proforma 데이터중 direction+port 조합으로 데이터 추출한다.<br>
	 * 
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSkdDirPortCdforProformaList(Event e) throws EventException {
		
		try {
			VSKCodeFinderBC 		command 	= new VSKCodeFinderBCImpl();
			VskComEvent				event		= (VskComEvent)e;
			String					sVslSlanCd	= event.getVskVslPortSkdVO().getSlanCd();
			List<VskVslPortSkdVO> 	list 		= command.searchSkdDirPortCdforProformaList(sVslSlanCd);
			
			StringBuffer 			sbDataDirCd	= new StringBuffer();
			StringBuffer			sbDataPortCd= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				
				for (int i = 0; i < list.size(); i++) {
	
					sbDataDirCd.append(list.get(i).getSkdDirCd());
					sbDataPortCd.append(list.get(i).getVpsPortCd());
					
					if (i < list.size() - 1)
						sbDataDirCd.append("|");
						sbDataPortCd.append("|");
				}
			}
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("SkdDirList"	, sbDataDirCd.toString());
			eventResponse.setETCData("PortList"		, sbDataPortCd.toString());
			
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Phase In/Out 사유 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response 
	 * @exception EventException
	 */
	private EventResponse searchPhsInOutRsnList(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
	//		VskGloEvent event = (VskGloEvent)e;
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl(); 
			
	//		List<PfLaneTypeVO> list = command.searchPhsInOutRsnList();
			List<PhaseInOutReasonVO> list = command.searchPhsInOutRsnList();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
	
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Carrier Code 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCarrierList(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			VopVsk0044Event event = (VopVsk0044Event)e;
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl(); 
			
			List<CarrierVO> list = command.searchCarrierList(event.getCarrierVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			/*
			 * 1건 조회시, 해당 Port명을 etc데이터(Key : port_name)로 등록
			 */
			if (list != null && list.size() == 1) {
				CarrierVO vo = list.get(0);
				eventResponse.setETCData("crr_full_nm", vo.getCrrFullNm());
			}
	
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Simulation No 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSimNoList(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			RqstSimNoVO vo = null;
			if(e instanceof VskGloEvent){
				VskGloEvent event = (VskGloEvent) e;
				vo = event.getRqstSimNoVO();
			}
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl(); 
			List<RqstSimNoVO> list = command.searchSimNoList(vo);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			/*
			 * 1건 조회시, 해당 Port명을 etc데이터(Key : port_name)로 등록
			 */
			if (list != null && list.size() == 1) {
				RqstSimNoVO rqstSimNoVO = list.get(0);
				eventResponse.setETCData("sim_no", rqstSimNoVO.getSimulNo());
			}
	
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}	
	
	/**
	 * VOP_VSK_0064 : Retrieve
	 * VOP_VSK_0252 : Retrieve
	 * 
	 * 코드 타입, 코드명에 따른 코드 정보 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCodeInfoList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0064Event event1 = null;
		VopVsk0252Event event2 = null;
//		VskGloEvent event3 = null;
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();

		try{
			List<CodeInfoVO> list = null;
			
			if(e instanceof VopVsk0064Event){			
				event1 = (VopVsk0064Event)e;
				list = command.searchCodeInfoList(event1.getCodeInfoVO());
				
				eventResponse.setRsVoList(list);
			} else if(e instanceof VopVsk0252Event){
				event2 = (VopVsk0252Event)e;
				list = command.searchCodeInfoList(event2.getCodeInfoVO());
				
				if (list != null){
					if(list.size() == 1){
						CodeInfoVO codeInfoVO = list.get(0);
						eventResponse.setETCData("crr_cd", codeInfoVO.getCode());
					}
					eventResponse.setRsVoList(list);
				}
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}		
		return eventResponse;
	}		

	/**
	 * 공통코드 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private  EventResponse searchCommonCode(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			VopVskVosiEvent event = (VopVskVosiEvent)e;
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			VskComboVO vskComboVO = event.getVskComboVO();
	
			String[] arrCdVal = vskComboVO.getComboCd().split(",");
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			for(int cnt = 0; cnt < arrCdVal.length; cnt++){
				List<VskComboVO> list = command.searchCombo(arrCdVal[cnt]);
				eventResponse.setRsVoList(list);
			}
			
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * Lane 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private  EventResponse searchLane(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
	
			MdmVslSvcLaneVO condi = new MdmVslSvcLaneVO();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<MdmVslSvcLaneVO> list = command.searchLane(condi);
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Lane 정보를 검증합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkLane(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			VopVskVosiEvent event = (VopVskVosiEvent)e;
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<MdmVslSvcLaneVO> list = command.checkLane(event.getMdmVslSvcLaneVO());
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Vsl Class 정보를 조회한다.<br>
	 * 
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchVslClsList() throws EventException {
		try {
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			List<MdmVslCntrVO> list = command.searchVslClsList();
			
			StringBuffer data = new StringBuffer();
			
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
	
					data.append(list.get(i).getCntrVslClssCapa());
					if (i < list.size() - 1)
						data.append("|");
				}
			}
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("vslCls", data.toString());
			
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Vsl Class 정보와 VSL_DZND_CAPA를 조회한다.<br>
	 * 
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchVslClsDznCapaList() throws EventException {
		try {
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			CodeInfoGRPVO grpVO = command.searchVslClsDznCapaList();
			
			List<MdmVslCntrVO> vslClsList =  grpVO.getVslClsCapaVOss();
			List<MdmVslCntrVO> vslDznList =  grpVO.getVslDzndCapaVOs();
			
			StringBuffer data = new StringBuffer();
			StringBuffer data02 = new StringBuffer();
			
			if (vslClsList != null && vslClsList.size() > 0) {
				for (int i = 0; i < vslClsList.size(); i++) {
	
					data.append(vslClsList.get(i).getCntrVslClssCapa());
					if (i < vslClsList.size() - 1)
						data.append("|");
				}
			}
			
			if (vslDznList != null && vslDznList.size() > 0) {
				for (int i = 0; i < vslDznList.size(); i++) {
					
					data02.append(vslDznList.get(i).getCntrDznCapa());
					if (i < vslDznList.size() - 1)
						data02.append("|");
				}
			}
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("vslCls", data.toString());
			eventResponse.setETCData("dznCls", data02.toString());
			
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Service Lane Direction 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchLaneDirList(Event e) throws EventException {
		try {
			LaneDirVO vo = null;
			VopVsk0046Event event = (VopVsk0046Event)e;
			vo = event.getLaneDirVO();
			
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			List<LaneDirVO> list = command.searchLaneDirList(vo);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if(list!=null && list.size()==1){
				eventResponse.setETCData("vsl_slan_nm", list.get(0).getVslSlanNm());
			}
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Lane Code Inquiry 화면의 기본정보인 Trade, Sub Trade, Service Type 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchLaneBasic(Event e) throws EventException {
		try {
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl(); 
			List<String[]> list = command.searchLaneBasic();
			String[] arrTrd = list.get(0);
			String[] arrSubTrd = list.get(1);
			
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();
			StringBuilder sb4 = new StringBuilder();
			StringBuilder sb5 = new StringBuilder();
			
			if(arrTrd != null && arrTrd.length > 0){
				String[] a = arrTrd[0].split(":");
				sb.append(a[0]);
				sb1.append(a[1]);
				for (int i = 1; i < arrTrd.length; i++) {
					sb.append("|");
					sb1.append("|");
					String[] b = arrTrd[i].split(":");
					sb.append(b[0]);
					sb1.append(b[1]);
				}
			}
			
			if(arrSubTrd != null && arrSubTrd.length > 0){
				String[] a = arrSubTrd[0].split(":");
				sb2.append(a[0]);
				sb3.append(a[1]);
				for (int i = 1; i < arrSubTrd.length; i++) {
					sb2.append("|");
					sb3.append("|");
					String[] b = arrSubTrd[i].split(":");
					sb2.append(b[0]);
					sb3.append(b[1]);
				}
			}
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("trd_cd", sb.toString());
			eventResponse.setETCData("trd_nm", sb1.toString());
			eventResponse.setETCData("sub_trd_cd", sb2.toString());
			eventResponse.setETCData("sub_trd_nm", sb3.toString());
			
			//Service Type Code 조회
			List<VskComboVO> svcTpCdList = command.searchCombo("CD00717");
			
			if(svcTpCdList != null && svcTpCdList.size() > 0){
				sb4.append(svcTpCdList.get(0).getVal());
				sb5.append(svcTpCdList.get(0).getDesc());
				for (int i = 1; i < svcTpCdList.size(); i++) {
					sb4.append("|");
					sb5.append("|");
					sb4.append(svcTpCdList.get(i).getVal());
					sb5.append(svcTpCdList.get(i).getDesc());
				}
			}
			
			eventResponse.setETCData("vsl_svc_tp_cd", sb4.toString());
			eventResponse.setETCData("vsl_svc_tp_nm", sb5.toString());
		
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Port Code Inquiry 화면의 기본정보인 RHQ Code, Conti Code, Sconti Code 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPortBasic(Event e) throws EventException {
		try {
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			List<OfficeVO> list = command.searchRhqList();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
						 
			List<String[]> list2 = command.searchPortBasic();
			String[] arrConti = list2.get(0);
			String[] arrSubConti = list2.get(1);
			
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			
			if(arrConti != null && arrConti.length > 0){
				sb.append(arrConti[0]);
				for (int i = 1; i < arrConti.length; i++) {
					sb.append("|");
					sb.append(arrConti[i]);
				}
			}
			
			if(arrSubConti != null && arrSubConti.length > 0){
				sb1.append(arrSubConti[0]);
				for (int i = 1; i < arrSubConti.length; i++) {
					sb1.append("|");
					sb1.append(arrSubConti[i]);
				}
			}
			
			eventResponse.setETCData("conti_cd", sb.toString());
			eventResponse.setETCData("sconti_cd", sb1.toString());
			
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Port Code Inquiry 에서의 Port 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPortInfoList(Event e) throws EventException {
		try{
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			VopVsk0221Event event = (VopVsk0221Event) e;

			List<LocationVO> list = command.searchPortInfoList(event.getLocationVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			/*
			 * 1건 조회시, 해당 Port명을 etc데이터(Key : port_name)로 등록
			 */
			if (list != null && list.size() == 1) {
				LocationVO vo = list.get(0);
				eventResponse.setETCData("port_name", vo.getLocNm());
				eventResponse.setETCData("zd", vo.getZd());
			}
			return eventResponse;	
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
	}
	
	/**
	 * Port Code Inquiry 화면의 기본정보인 RHQ Code, Conti Code, Sconti Code 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchScontiList(Event e) throws EventException {
		try {
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VopVsk0221Event event = (VopVsk0221Event) e;
			String[] arrSubConti = command.searchScontiList(event.getLocationVO().getContiCd());
			
			StringBuilder sb = new StringBuilder();
			
			if(arrSubConti != null && arrSubConti.length > 0){
				sb.append(arrSubConti[0]);
				for (int i = 1; i < arrSubConti.length; i++) {
					sb.append("|");
					sb.append(arrSubConti[i]);
				}
			}
			
			eventResponse.setETCData("sconti_cd", sb.toString());
			
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * VOP_VSK_0044 : Retrieve
	 * Vessel 리스트를 조회합니다. paging 처리를 위해 searchVslList를 사용하지 않음
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchVesselListByCode(Event e) throws EventException {
		try {
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			VopVsk0044Event event = (VopVsk0044Event) e;
			List<VesselVO> list = command.searchVesselListByCode(event.getVesselVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if (list.size() == 0) {
				 eventResponse.setUserMessage(new ErrorHandler("VSK10027").getUserMessage());
			}
			// 페이징에 관계없이 전체 건수 표현
			if(list!=null && list.size()>0){
				list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			}
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
}