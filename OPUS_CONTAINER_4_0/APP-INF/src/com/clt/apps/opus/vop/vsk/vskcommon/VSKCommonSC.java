/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCommonSC.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0044Event;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0046Event;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0064Event;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0221Event;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0252Event;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VopVskVosiEvent;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VskComEvent;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VskGloEvent;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration.VSKCodeFinderDBDAO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoGRPVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.DateTimeConvVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.PhaseInOutReasonVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.RqstSimNoVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * VSKCommon Business Logic ServiceCommand - Handling Business Transaction about VSKCommon
 * 
 * @author SEO CHANG YUL
 * @see VSKCodeFinderDBDAO
 * @since J2EE 1.4
 */

public class VSKCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * VSKCommon system preceding process for biz scenario<br>
	 * UI_VSK-0202 related objects creation<br>
	 */
	public void doStart() {
		try { 
			account = getSignOnUserAccount();
		} catch (Exception e) {log.error(e.getMessage());}
	}

	/**
	 * VSKCommon system biz scenario closing<br>
	 * UI_VSK-0202 clearing related objects<br><br>
	 */
	public void doEnd() {
		log.debug("VSKCommonSC END");
	}

	/**
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("VskGloEvent")) {		
			//0202
			if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				eventResponse = searchSvcLaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND12)){
				eventResponse = checkSvcLane(e);
			}
			//0043
			else	if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {			
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
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND23)) {
				eventResponse = searchActPreDateEqual(e);
			}
			
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
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0221Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRhqList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCountryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCarrierList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSvcLaneList(e);
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
	 * Retrieving Port<br>
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
			} else if (e instanceof VopVsk0221Event) {
				VopVsk0221Event event = (VopVsk0221Event) e;
				locationVO = event.getLocationVO();
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(locationVO != null) {
				List<LocationVO> list = searchPortList(locationVO);
				eventResponse.setRsVoList(list);
				if (list != null && list.size() == 1) {
					LocationVO vo = list.get(0);
					eventResponse.setETCData("port_name", vo.getLocNm());
					eventResponse.setETCData("zd", vo.getZd());
				}
			}
			return eventResponse;	
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
	}

	/**
	 * Retrieving RHQ List<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRhqList(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			List<OfficeVO> list = command.searchRhqList();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			StringBuffer strVal = new StringBuffer();

			// combo 
			for(int i=0;i<list.size();i++){
				strVal.append(list.get(i).getOfcCd());
				if(i!=list.size()-1){
					strVal.append(":");
				}
			}
			eventResponse.setETCData("rhqlist", strVal.toString());
			
			return eventResponse;			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * Retrieving Port<br>
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
	 * Retrieving Country List<br>
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
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(vo != null) {
				VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
				List<MdmCountryVO> list = command.searchCountryList(vo.getCntCd());
				eventResponse.setRsVoList(list);
				if(list!=null && list.size()==1){
					eventResponse.setETCData("cnt_nm", list.get(0).getCntNm());
				}
			}
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * Retrieving Service Lane<br>
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
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(vo != null) {
				VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
				List<MdmVslSvcLaneVO> list = command.searchSvcLaneList(vo);
				eventResponse.setRsVoList(list);
				if(list!=null && list.size()==1){
					eventResponse.setETCData("vsl_slan_nm", list.get(0).getVslSlanNm());
				}
			}
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * Retrieving Service Type of Lane<br>
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
	 * VOP_VSK_0044 : Retrieve
	 * Retrieving Vessel List
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchVslList(Event e) throws EventException {
		try {
			VesselVO vesselVO = null;
			if (e instanceof VopVsk0044Event) {
				VopVsk0044Event event = (VopVsk0044Event) e;
				vesselVO = event.getVesselVO();
			} else if (e instanceof VskGloEvent) {
				VskGloEvent event = (VskGloEvent) e;
				vesselVO = event.getVesselVO();
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(vesselVO != null) {
				VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
				List<VesselVO> list = command.searchVslList(vesselVO);
				eventResponse.setRsVoList(list);
				if (list.size() == 0) {
					 eventResponse.setUserMessage(new ErrorHandler("VSK10027").getUserMessage());
				}else if(list.size()==1){
					eventResponse.setETCData("vsl_eng_nm", list.get(0).getVslEngNm());
					eventResponse.setETCData("fdr_div_cd", list.get(0).getFdrDivCd());
				}
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
	 * Retrieving Yard of Country
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
			if(paramVO != null) {
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
			}
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * Retrieving on time VVD List<br>
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
					// in case VVD input, Checking the VVD is exist
					eventResponse.setETCData("vvd", list.get(0).getVslCd() + list.get(0).getSkdVoyNo() + list.get(0).getSkdDirCd());
				}
			} else if ("NORL".equals(event.getVvdPortLaneOtherVO().getCtrlCd())) {
				list = command.searchEstVvdList(event.getVvdPortLaneOtherVO()
						.getVslCd());
			}
			if(list != null) {
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
	 * Retrieving P/F Lane Type<br>
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
	 * Retrieving Lane Code is invalid<br>
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
	 * Retrieving Phase In/Out Reason<br>
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
	 * Retrieving Carrier Code<br>
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
	 * Retrieving Simulation No<br>
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
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(vo != null) {
				VSKCodeFinderBC command = new VSKCodeFinderBCImpl(); 
				List<RqstSimNoVO> list = command.searchSimNoList(vo);
				eventResponse.setRsVoList(list);
				if (list != null && list.size() == 1) {
					RqstSimNoVO rqstSimNoVO = list.get(0);
					eventResponse.setETCData("sim_no", rqstSimNoVO.getSimulNo());
				}
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
	 * Retrieving Code Information List by Code Type or Code Name<br>
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
	 * Retrieving Common Code Info<br>
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
	 * Retrieving Lane<br>
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
	 * Checking Lane<br>
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
	 * Retrieving Vsl Class<br>
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
	 * Retrieving Vsl Class and VSL_DZND_CAPA<br>
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
	
	//::FOR.NYK.START::by dongsoo:2014-10-16:://
	/**
	 * ACTUAL SKD ?낅젰??GMT 湲곗??쇰줈 ?댁쟾?ы듃??ETD? ?낅젰?ы듃 ATA??쟾愿怨?泥댄겕 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActPreDateEqual(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		
		VskGloEvent event = (VskGloEvent) e;
		
		DateTimeConvVO  dateTimeConvVO = event.getDateTimeConvVO();
		VSKCodeFinderBC command        = new VSKCodeFinderBCImpl();
		
		String actStatus = command.searchActPreDateEqual(dateTimeConvVO);
		
		eventResponse.setETCData("actStatus"   , actStatus);
	
		return eventResponse;
	}
	
	//::FOR.NYK.START::by KJH:2014-11-24:://
	/**
	 * Send Revenue VVD I/F  
	 * 
	 * @param VVdVo
	 * @return String
	 * @exception EventException
	 */
	/*
	private String  setRevenueVVD(VvdVO vvdVo) throws EventException {
		
		VSKCodeFinderBC command  = new VSKCodeFinderBCImpl();
		
		String result = command.sendRevenueVVD(vvdVo);
	
		return result;
	}
	*/
	//::FOR.NYK.FINISH::by KJH:2014-11-24:://
}