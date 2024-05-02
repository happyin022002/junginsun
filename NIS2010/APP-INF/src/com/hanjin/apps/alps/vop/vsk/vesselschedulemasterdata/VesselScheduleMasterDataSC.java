/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VesselScheduleMasterDataSC.java
 *@FileTitle : Port Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.08.16
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 * 2009.05.20 서창열
 * 1.0 Creation
 *
 * History
 * 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
 * 2015.08.10 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBC;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk0033Event;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk0228Event;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk0240Event;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk9001Event;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration.VesselScheduleMasterDataDBDAO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanalAgencyLaneVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanelRegistGRPVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserDefinedLanePortGroupVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-VesselScheduleMasterData Business Logic ServiceCommand -
 * NIS2010-VesselScheduleMasterData 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SEO CHANG YUL
 * @see VesselScheduleMasterDataDBDAO
 * @since J2EE 1.4
 */

public class VesselScheduleMasterDataSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * VesselScheduleMasterData system 업무 시나리오 선행작업<br>
	 * VOP_VSK-0033업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * VesselScheduleMasterData system 업무 시나리오 마감작업<br>
	 * VOP_VSK-0033 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("VesselScheduleMasterDataSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-VesselScheduleMasterData system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopVsk0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){ 
				eventResponse = searchOfficeCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
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
		} else if (e.getEventName().equalsIgnoreCase("VopVsk9001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUserDefinedLanePortGroup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUserDefinedLanePortGroup(e);
			}
		}
		
		return eventResponse;
	}

	/**
	 * VOP_VSK_0033 : Retrieve Port 정보를 조회합니다.
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
			}

			List<LocationVO> portList = command.searchPortList(paramVO);
			List<OfficeVO> officeVOs = command2.searchRhqList();
			
			List<LocationVO> locationVOs = command2.searchSlsOfficeList(portList.get(0).getVskdPortRhqCd());
			
			StringBuilder sb = new StringBuilder();
			for (OfficeVO officeVO : officeVOs) {
				sb.append("|").append(officeVO.getPrntOfcCd());
			}
			
			StringBuilder sb2 = new StringBuilder();
			for (LocationVO locationVO : locationVOs){
				sb2.append("|").append(locationVO.getVopPortCtrlOfcCd());
			}
			
			eventResponse.setETCData("vskdPortRhqCd", sb.toString());
			eventResponse.setETCData("vskOfcCd", sb2.toString()); // 2015.02.17 kjh추가
			eventResponse.setRsVoList(portList);
			return eventResponse; 
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(),	ex);
		}
	}

	/**
	 * VOP_VSK_0033 : Retrieve Port 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeCodeList(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VSKCodeFinderBC command2 = new VSKCodeFinderBCImpl();
			LocationVO paramVO = null;

			if (e instanceof VopVsk0033Event) {
				VopVsk0033Event event = (VopVsk0033Event) e;
				paramVO = event.getLocationVO();
			}

			String rhqCd = null;
			if (paramVO != null) {
				rhqCd  =  paramVO.getVopPortRhqCd();
			}
			
			List<LocationVO> locationVOs = command2.searchSlsOfficeList(rhqCd);
			
			StringBuilder sb2 = new StringBuilder();
			for (LocationVO locationVO : locationVOs){
				sb2.append("|").append(locationVO.getVopPortCtrlOfcCd());
			}
			
			eventResponse.setETCData("vskOfcCd", sb2.toString()); // 2015.02.17 kjh추가
			
			return eventResponse; 
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(),	ex);
		}
	}
	
	/**
	 * VOP_VSK_0033 : Save Port 정보를 수정합니다.
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
			command.modifyPortList(paramVOs, account);
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
	 * VOP_VSK_0240 조회 이벤트 처리<br>
	 * 운하대리점이 관리하고 있는 Lane Code 리스트 정보를 조회한다.<br>
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
	 * [UI_VSK-0240]Vender Group Register (Pop-up) 화면. Vender별로 관리 노선을 선택하는 화면<br>
	 * VesselScheduleMasterData의 event에 대한 멀티 이벤트 처리<br>
	 * 운하대리점이 관리하고 있는 Lane Code 리스트 정보를 등록한다.
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
	 * [UI_VSK-0240]Vender Group Register (Pop-up) 화면. Vender별로 관리 노선을 선택하는 화면<br>
	 * VesselScheduleMasterData의 event에 대한 멀티 이벤트 처리<br>
	 * Service Provider Code에 대한 체크과 name을 조회한다
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
			List<VendorVO> vendorVOs = command.searchVendorList(vendorVO);

			if (vendorVOs != null && vendorVOs.size() > 0) {
				eventResponse.setRsVoList(vendorVOs);

				if (vendorVOs.size() == 1) {
					VendorVO rtnVO = vendorVOs.get(0);
					eventResponse.setETCData("vndr_seq", rtnVO.getVndrSeq());
					eventResponse.setETCData("vndr_nm", rtnVO.getVndrLglEngNm());
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
	 * VOP_VSK_0228 : Window Open 사용자별 Lane Group 정보를 조회합니다.
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
	 * VOP_VSK_0228 : Save 사용자별 Lane Group 정보를 저장합니다.
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
	
	/**
	 * VOP_VSK_9001 : Window Open user별 Lane Group 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserDefinedLanePortGroup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();
			List<UserDefinedLanePortGroupVO> list = command.searchUserDefinedLanePortGroup(account.getUsr_id());

			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * VOP_VSK_9001 : Save user별 Lane Group 정보를 저장합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUserDefinedLanePortGroup(Event e) throws EventException {

		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VopVsk9001Event event = (VopVsk9001Event) e;
			VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();

			begin();
			UserDefinedLanePortGroupVO[] userDefinedLanePortGroupVOs = event.getUserDefinedLanePortGroupVOs();
			if (userDefinedLanePortGroupVOs != null && userDefinedLanePortGroupVOs.length != 0) {
				command.manageUserDefinedLanePortGroup(userDefinedLanePortGroupVOs, account);
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