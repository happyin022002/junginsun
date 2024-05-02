/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseCommonSC.java
*@FileTitle : Lease Module Common Service
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.hanjin.apps.alps.ees.lse.lsecommon.agreement.basic.AgreementBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.agreement.basic.AgreementBCImpl;
import com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBCImpl;
import com.hanjin.apps.alps.ees.lse.lsecommon.currency.basic.CurrencyBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.currency.basic.CurrencyBCImpl;
import com.hanjin.apps.alps.ees.lse.lsecommon.dlvrloc.basic.DeliveryLocationBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.dlvrloc.basic.DeliveryLocationBCImpl;
import com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.basic.LeaseTermBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.basic.LeaseTermBCImpl;
import com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.basic.LseCommonBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.basic.LseCommonBCImpl;
import com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.event.EesLseComEvent;
import com.hanjin.apps.alps.ees.lse.lsecommon.movement.basic.MovementBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.movement.basic.MovementBCImpl;
import com.hanjin.apps.alps.ees.lse.lsecommon.vendor.basic.VendorBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.vendor.basic.VendorBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.syscommon.common.table.MdmEqOrzChtVO;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmMvmtStsVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.common.table.MstContainerVO;
import com.hanjin.syscommon.common.table.MstLseTermVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * ALPS-LseCommon Business Logic ServiceCommand - ALPS-LseCommon 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Nho Jung Yong
 * @see ...
 * @since J2EE 1.4
 */

public class LseCommonSC extends ServiceCommandSupport {
	// Login User Information
	//private SignOnUserAccount account = null;

	/**
	 * LseCommon system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	@Override
	public void doStart() {
		/*
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		*/
		log.debug("LseCommonSC 시작");
	}

	/**
	 * LseCommon system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	@Override
	public void doEnd() {
		log.debug("LseCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-LseCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesLseComEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// Lease Term List Search
				eventResponse = searchLeaseTermListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				// Container Type/Size List Search
				eventResponse = searchContainerTypSizeListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				// Lease Agreement Briefly Search
				eventResponse = searchAgreementBrieflyService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				// Lease Agreement Lessor Briefly Search
				eventResponse = searchAgreementLessorBrieflyService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				// Delivery Location Briefly Search
				eventResponse = searchDeliveryLocationBrieflyService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				// Vendor Briefly Search
				eventResponse = searchVendorBrieflyService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				// Currency Briefly Search
				eventResponse = searchCurrencyBrieflyService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				// RCC List Search
				eventResponse = searchDeliveryLocationRCCListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				// Manufacturer List Search
				eventResponse = searchManufacturerListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				// DeliveryLocation - Country List Search
				eventResponse = searchDeliveryLocationCountryService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				// Container Movement Status List Search
				eventResponse = searchContainerMovementStatusListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				// Container Type Size Dynamic Header Search
				eventResponse = searchContainerTypeSizeDynamicHeaderService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				// Location - Port List Search
				eventResponse = searchLocationPortService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				// Vessel SKD List Search
				eventResponse = searchVesselSkdService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				// Lease Agreement List Search by Vendor
				eventResponse = searchAgreementByVendorBrieflyService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				// Office Code List Search
				eventResponse = searchOfficeCodeService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				// Container Search
				eventResponse = searchContainerInfoBrieflyService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				// DeliveryLocation - Off-Hire Yard List Search
				eventResponse = searchOffHireYardListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				// Vessel SVC Lane Code List Search
				eventResponse = searchServiceLaneService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("LseFileUploadEvent")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = manageFileUploadService(e);
			}
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * 화면의 Lease Term 콤보아이템 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchLeaseTermListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			//Lease Term Combo Object Item
			LeaseTermBC command = new LeaseTermBCImpl();
			List<MstLseTermVO> leaseTermList = command.searchLeaseTermComboItemBasic();
	
			StringBuffer sLeaseTermNm = new StringBuffer();
			StringBuffer sLeaseTermCd = new StringBuffer();
			StringBuffer sLeaseTermCd2 = new StringBuffer();
	
			for ( int i = 0 ; i < leaseTermList.size() ; i++ ) {
				if ( sLeaseTermNm.toString().equals("") ) {
					sLeaseTermNm.append(leaseTermList.get(i).getLstmCd());
					sLeaseTermCd.append(leaseTermList.get(i).getLstmCd());
					sLeaseTermCd2.append(leaseTermList.get(i).getLstmNm());
				} else {
					sLeaseTermNm.append("|").append(leaseTermList.get(i).getLstmCd());
					sLeaseTermCd.append("|").append(leaseTermList.get(i).getLstmCd());
					sLeaseTermCd2.append("|").append(leaseTermList.get(i).getLstmNm());
				}
			}
	
			eventResponse.setETCData("lease_term_nm", sLeaseTermNm.toString());
			eventResponse.setETCData("lease_term_cd", sLeaseTermCd.toString());
			eventResponse.setETCData("lease_term_full_nm", sLeaseTermCd2.toString());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * 화면의 Container Type/Size 콤보아이템 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchContainerTypSizeListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// Container Type/Size
			ContainerTypeSizeBC command = new ContainerTypeSizeBCImpl();
			List<MdmCntrTpSzVO> cntrTpSzlist = command.searchCntrTpSzListBasic();
	
			StringBuffer sCntrTpSzNm = new StringBuffer();
			StringBuffer sCntrTpSzCd = new StringBuffer();
	
			for ( int i = 0 ; i < cntrTpSzlist.size() ; i++ ) {
				if ( sCntrTpSzNm.toString().equals("") ) {
					sCntrTpSzNm.append(cntrTpSzlist.get(i).getCntrTpszCd());
					sCntrTpSzCd.append(cntrTpSzlist.get(i).getCntrTpszCd());
				} else {
					sCntrTpSzNm.append("|").append(cntrTpSzlist.get(i).getCntrTpszCd());
					sCntrTpSzCd.append("|").append(cntrTpSzlist.get(i).getCntrTpszCd());
				}
			}
	
			eventResponse.setETCData("cntr_tpsz_nm", sCntrTpSzNm.toString());
			eventResponse.setETCData("cntr_tpsz_cd", sCntrTpSzCd.toString());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Long Term Lease CNTR Delivery Plan 화면의 Agreement 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAgreementBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLseComEvent event = (EesLseComEvent)e;
			String agmtCtyCd = event.getAgreementVO().getAgmtCtyCd();
			String agmtSeq   = event.getAgreementVO().getAgmtSeq();
	
			AgreementBC command = new AgreementBCImpl();
			List<AgreementVO> list = command.searchAgreementListBrieflyBasic(agmtCtyCd, agmtSeq);
			eventResponse.setETCData(list.get(0).getColumnValues());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Long Term Lease CNTR Delivery Plan 화면의 Lessor 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAgreementLessorBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLseComEvent event = (EesLseComEvent)e;
			String vndrSeq = event.getAgreementVO().getVndrSeq();
			String lstmCd  = event.getAgreementVO().getLstmCd();
	
			AgreementBC command = new AgreementBCImpl();
			List<AgreementVO> list = command.searchAgreementLessorListBrieflyBasic(vndrSeq, lstmCd);
	
			eventResponse.setETCData("vndr_seq", list.get(0).getVndrSeq());
			eventResponse.setETCData("vndr_nm", list.get(0).getVndrLglEngNm());
			eventResponse.setETCData("lstm_cd", list.get(0).getLstmCd());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Delivery Location 대한 데이타 모델목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchDeliveryLocationBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			DeliveryLocationBC command = new DeliveryLocationBCImpl();
			EesLseComEvent event = (EesLseComEvent)e;
			List<MdmEqOrzChtVO> list = command.searchLocationBrieflyBasic(event.getLocCd(), event.getLocTp());
			eventResponse.setETCData(list.get(0).getColumnValues());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Currency 대한 데이타 모델목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCurrencyBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			CurrencyBC command = new CurrencyBCImpl();
			EesLseComEvent event = (EesLseComEvent)e;
			List<MdmCurrencyVO> list = command.searchCurrencyListBasic(event.getCurrCd());
			eventResponse.setETCData(list.get(0).getColumnValues());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Delivery Location - RCC 대한 데이타 모델목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchDeliveryLocationRCCListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			DeliveryLocationBC command = new DeliveryLocationBCImpl();
			List<MdmEqOrzChtVO> list = command.searchDeliveryLocationRCCListBasic();
			StringBuffer sRccCd = new StringBuffer();
	
			for ( int i = 0 ; i < list.size() ; i++ ) {
				if ( sRccCd.toString().equals("") ) {
					sRccCd.append(list.get(i).getRccCd());
				} else {
					sRccCd.append("|").append(list.get(i).getRccCd());
				}
			}
	
			eventResponse.setETCData("rcc_cd", sRccCd.toString());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Vendor에 대한 데이타 모델목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchVendorBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			VendorBC command = new VendorBCImpl();
			EesLseComEvent event = (EesLseComEvent)e;
			List<MdmVendorVO> list = command.searchVendorBasic(event.getVndrSeq());
			eventResponse.setETCData(list.get(0).getColumnValues());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Manufacturer Vendor 코드목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchManufacturerListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			VendorBC command = new VendorBCImpl();
			List<MdmVendorVO> vendorlist = command.searchManufacturerVendorListBasic();
	
			StringBuffer sVndrAbbrNm = new StringBuffer();
			StringBuffer sVndrSeq    = new StringBuffer();
	
			for ( int i = 0 ; i < vendorlist.size() ; i++ ) {
				if ( sVndrAbbrNm.toString().equals("") ) {
					sVndrAbbrNm.append(vendorlist.get(i).getVndrAbbrNm());
					sVndrSeq.append(vendorlist.get(i).getVndrSeq());
				} else {
					sVndrAbbrNm.append("|").append(vendorlist.get(i).getVndrAbbrNm());
					sVndrSeq.append("|").append(vendorlist.get(i).getVndrSeq());
				}
			}
	
			eventResponse.setETCData("vndr_abbr_nm", sVndrAbbrNm.toString());
			eventResponse.setETCData("vndr_seq", sVndrSeq.toString());
			eventResponse.setRsVoList(vendorlist);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Delivery Location - Country 대한 데이타 모델목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchDeliveryLocationCountryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			DeliveryLocationBC command = new DeliveryLocationBCImpl();
			EesLseComEvent event = (EesLseComEvent)e;
			List<MdmLocationVO> list = command.searchDeliveryLocationCountryBasic(event.getLocCd());
			String locCd = list.get(0).getCntCd();
			eventResponse.setETCData("loc_cd", locCd);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Container Movement Status 코드목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchContainerMovementStatusListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			MovementBC command = new MovementBCImpl();
			List<MdmMvmtStsVO> codeList = command.searchContainerMovementStatusListBasic();
	
			StringBuffer sMvmtStsNm = new StringBuffer();
			StringBuffer sMvmtStsCd = new StringBuffer();
	
			for ( int i = 0 ; i < codeList.size() ; i++ ) {
				if ( sMvmtStsNm.toString().equals("") ) {
					sMvmtStsNm.append(codeList.get(i).getMvmtStsNm());
					sMvmtStsCd.append(codeList.get(i).getMvmtStsCd());
				} else {
					sMvmtStsNm.append("|").append(codeList.get(i).getMvmtStsNm());
					sMvmtStsCd.append("|").append(codeList.get(i).getMvmtStsCd());
				}
			}
	
			eventResponse.setETCData("mvmt_sts_nm", sMvmtStsNm.toString());
			eventResponse.setETCData("mvmt_sts_cd", sMvmtStsCd.toString());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Container Type Size의 가변적 Header를 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchContainerTypeSizeDynamicHeaderService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			ContainerTypeSizeBC command = new ContainerTypeSizeBCImpl();
			String cntrTpszHd = command.searchContainerTypeSizeDynamicHeaderBasic();
			eventResponse.setETCData("cntr_tpsz_hd", cntrTpszHd);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Location - Port 대한 데이타 모델목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchLocationPortService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			LseCommonBC command = new LseCommonBCImpl();
			EesLseComEvent event = (EesLseComEvent)e;
			List<MdmLocationVO> list = command.searchLocationPortBasic(event.getLocCd());
			String locCd = list.get(0).getLocCd();
			eventResponse.setETCData("loc_cd", locCd);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Vessel SKD 에 대한 데이타 모델목록을 조회합니다.<br>
	 *
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchVesselSkdService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			LseCommonBC command = new LseCommonBCImpl();
			EesLseComEvent event = (EesLseComEvent)e;
			List<VskVslPortSkdVO> list = command.searchVesselSkdBasic(event.getVvdCd());
	
			String vvdCd = list.get(0).getVslCd();
				   vvdCd = vvdCd + list.get(0).getSkdVoyNo();
				   vvdCd = vvdCd + list.get(0).getSkdDirCd();
			eventResponse.setETCData("vvd_cd", vvdCd);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Long Term Lease CNTR Delivery Plan 화면의 Agreement 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAgreementByVendorBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String vndrSeq = "";
	
			EesLseComEvent event = (EesLseComEvent)e;
			vndrSeq = event.getAgreementVO().getVndrSeq();
	
			AgreementBC command = new AgreementBCImpl();
			List<AgreementVO> list = command.searchAgreementByVendorListBrieflyBasic(vndrSeq);
	
			String agmtNoList = "";
			for ( int i = 0 ; i < list.size() ; i++ ) {
				if ( i == 0 ) {
					agmtNoList = list.get(i).getVndrSeq() + "|" + list.get(i).getAgmtCtyCd() + "|" + list.get(i).getAgmtSeq() + "|" + list.get(i).getLseCtrtNo();
				} else {
					agmtNoList = agmtNoList + "^" + list.get(i).getVndrSeq() + "|" + list.get(i).getAgmtCtyCd() + "|" + list.get(i).getAgmtSeq() + "|" + list.get(i).getLseCtrtNo();
				}
			}
	
			eventResponse.setETCData("agmt_no_list", agmtNoList);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : OnChange<br>
	 * 컨테이너 정보 조회.<br>
	 *
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchContainerInfoBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLseComEvent event = (EesLseComEvent)e;
			LseCommonBC command = new LseCommonBCImpl();
			MstContainerVO vo = command.searchContainerInfoBrieflyBasic(event.getCntrNo());
			eventResponse.setETCData(vo.getColumnValues());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Office 코드에 대한 데이타 모델목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOfficeCodeService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			LseCommonBC command = new LseCommonBCImpl();
			EesLseComEvent event = (EesLseComEvent)e;
			List<MdmOrganizationVO> list = command.searchOfficeCodeBasic(event.getOfcCd());
			String ofcCd = list.get(0).getOfcCd();
			eventResponse.setETCData("ofc_cd", ofcCd);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Delivery Location - Off-Hire Yard 대한 데이타 모델목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireYardListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			DeliveryLocationBC command = new DeliveryLocationBCImpl();
			EesLseComEvent event = (EesLseComEvent)e;
			List<MdmYardVO> list = command.searchOffHireYardListBasic(event.getYdCd());
			String ydCd = list.get(0).getYdCd();
			eventResponse.setETCData("offh_yd_cd", ydCd);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * Vessel SVC Lane 대한 데이타 모델목록을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchServiceLaneService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			LseCommonBC command = new LseCommonBCImpl();
			EesLseComEvent event = (EesLseComEvent)e;
			List<MdmVslSvcLaneVO> list = command.searchServiceLaneBasic(event.getSLanCd());
			String slanCd = list.get(0).getVslSlanCd();
			eventResponse.setETCData("slan_cd", slanCd);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0008 : 파일 업로드 이벤트 처리<br>
	 * 파일 업로드의 event에 대한 처리<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageFileUploadService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String strFileName = "";
			List<String> keys = (List<String>)e.getAttribute("KEYS");
			strFileName = keys.get(0);
			eventResponse.setETCData("filename", strFileName);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
}