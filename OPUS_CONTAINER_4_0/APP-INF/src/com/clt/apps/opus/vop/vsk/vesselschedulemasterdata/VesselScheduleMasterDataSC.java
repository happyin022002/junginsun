/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VesselScheduleMasterDataSC.java
 *@FileTitle : Port Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesselschedulemasterdata;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBC;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBCImpl;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk0033Event;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk0228Event;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk0240Event;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration.VesselScheduleMasterDataDBDAO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanalAgencyLaneVO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanelRegistGRPVO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * VesselScheduleMasterData Business Logic ServiceCommand -
 * Handling Business Transaction about VesselScheduleMasterData
 * 
 * @author 
 * @see VesselScheduleMasterDataDBDAO
 * @since J2EE 1.4
 */

public class VesselScheduleMasterDataSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * VesselScheduleMasterData system preceding process for biz scenario<br>
	 * VOP_VSK-0033 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * VesselScheduleMasterData system biz scenario closing<br>
	 * VOP_VSK-0033 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("VesselScheduleMasterDataSC END");
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("VopVsk0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyPortList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0240Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneListByCanalAgency(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVendorList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLaneListByCanalAgency(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0228Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUserLaneGroup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUserLaneGroup(e);
			}
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0033 : Retrieving Port
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortList(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();
			VSKCodeFinderBC command2 = new VSKCodeFinderBCImpl();
			LocationVO paramVO = null;

			if (e instanceof VopVsk0033Event) {
				VopVsk0033Event event = (VopVsk0033Event) e;
				paramVO = event.getLocationVO();
			} else {
				paramVO = new LocationVO();
			}

			List<LocationVO> portList = command.searchPortList(paramVO);
			List<OfficeVO> officeVOs = command2.searchRhqList();
			StringBuilder sb = new StringBuilder();
			for (OfficeVO officeVO : officeVOs) {
				sb.append("|").append(officeVO.getOfcCd());
			}
			eventResponse.setETCData("vskdPortRhqCd", sb.toString());
			eventResponse.setRsVoList(portList);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(),	ex);
		}
	}

	/**
	 * VOP_VSK_0033 : Modifying Port
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPortList(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();
			LocationVO[] paramVOs = null;

			if (e instanceof VopVsk0033Event) {
				VopVsk0033Event event = (VopVsk0033Event) e;
				paramVOs = event.getLocationVOs();
			}

			begin();
			if(paramVOs != null) {
				command.modifyPortList(paramVOs, account);
			}
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();

			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * VOP_VSK_0240<br>
	 * Retrieving Lane Code List of Canal Agency
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneListByCanalAgency(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();

			CanelRegistGRPVO grpVO = command.searchLaneListByCanalAgency();

			List<VendorVO> vendorVOs = grpVO.getVendorVOs();
			List<CanalAgencyLaneVO> canalAgencyLaneVOs = grpVO.getCanalAgencyLaneVOs();
			List<CanalAgencyLaneVO> returnLeftVOs = new ArrayList<CanalAgencyLaneVO>();
			List<CanalAgencyLaneVO> returnRightVOs = new ArrayList<CanalAgencyLaneVO>();

			for (CanalAgencyLaneVO canalAgencyLaneVO : canalAgencyLaneVOs) {
				String vndrFlg = canalAgencyLaneVO.getCnlAgnVndrSeq();
				if (VSKGeneralUtil.isNotNull(vndrFlg)) {
					returnRightVOs.add(canalAgencyLaneVO);
				} else {
					returnLeftVOs.add(canalAgencyLaneVO);
				}
			}

			eventResponse.setRsVoList(vendorVOs);
			eventResponse.setRsVoList(returnLeftVOs);
			eventResponse.setRsVoList(returnRightVOs);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * [UI_VSK-0240]Vender Group Register (Pop-up)<br>
	 * Adding Lane Code List of Canal Agency
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLaneListByCanalAgency(Event e) throws EventException {
		try {

			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VopVsk0240Event event = (VopVsk0240Event) e;
			VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();

			begin();
			command.manageLaneListByCanalAgency(event.getCanelRegistGRPVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();

			return eventResponse;

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * [UI_VSK-0240]Vender Group Register (Pop-up)<br>
	 * Checking Service Provider Code and Retrieving name
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VendorVO vendorVO = null;

			if (e instanceof VopVsk0240Event) {
				VopVsk0240Event event = (VopVsk0240Event) e;
				vendorVO = event.getVendorVO();
			}
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			if(vendorVO != null) {
				List<VendorVO> vendorVOs = command.searchVendorList(vendorVO);
	
				if (vendorVOs != null && vendorVOs.size() > 0) {
					eventResponse.setRsVoList(vendorVOs);
	
					if (vendorVOs.size() == 1) {
						VendorVO rtnVO = vendorVOs.get(0);
						eventResponse.setETCData("vndr_seq", rtnVO.getVndrSeq());
						eventResponse.setETCData("vndr_nm", rtnVO.getVndrLglEngNm());
					}
				}
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * VOP_VSK_0228 : Window Open
	 * Retrieving Lane Group per User
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserLaneGroup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();
			List<UserLaneGroupVO> list = command.searchUserLaneGroup(account.getUsr_id());

			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * VOP_VSK_0228 : Save
	 * Adding Lane Group per User
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUserLaneGroup(Event e) throws EventException {

		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VopVsk0228Event event = (VopVsk0228Event) e;
			VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();

			begin();
			UserLaneGroupVO[] userLaneGroupVOs = event.getUserLaneGroupVOs();
			if (userLaneGroupVOs != null && userLaneGroupVOs.length != 0) {
				command.manageUserLaneGroup(userLaneGroupVOs, account);
			}
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();

			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

	}
}