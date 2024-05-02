/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseCommonSC.java
*@FileTitle : Lease Module Common Service
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.vo.GroupOfficeListVO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.clt.apps.opus.ees.lse.lsecommon.agreement.basic.AgreementBC;
import com.clt.apps.opus.ees.lse.lsecommon.agreement.basic.AgreementBCImpl;
import com.clt.apps.opus.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBC;
import com.clt.apps.opus.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBCImpl;
import com.clt.apps.opus.ees.lse.lsecommon.currency.basic.CurrencyBC;
import com.clt.apps.opus.ees.lse.lsecommon.currency.basic.CurrencyBCImpl;
import com.clt.apps.opus.ees.lse.lsecommon.dlvrloc.basic.DeliveryLocationBC;
import com.clt.apps.opus.ees.lse.lsecommon.dlvrloc.basic.DeliveryLocationBCImpl;
import com.clt.apps.opus.ees.lse.lsecommon.leaseterm.basic.LeaseTermBC;
import com.clt.apps.opus.ees.lse.lsecommon.leaseterm.basic.LeaseTermBCImpl;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.basic.LseCommonBC;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.basic.LseCommonBCImpl;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.event.EesLse1001Event;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.event.EesLseComEvent;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.LseRntlCostAcctOrdVO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.SearchInvoiceNoVO;
import com.clt.apps.opus.ees.lse.lsecommon.movement.basic.MovementBC;
import com.clt.apps.opus.ees.lse.lsecommon.movement.basic.MovementBCImpl;
import com.clt.apps.opus.ees.lse.lsecommon.vendor.basic.VendorBC;
import com.clt.apps.opus.ees.lse.lsecommon.vendor.basic.VendorBCImpl;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.syscommon.common.table.MdmEqOrzChtVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmMvmtStsVO;
import com.clt.syscommon.common.table.MdmOfcGrpVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.MdmVendorVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.MdmYardVO;
import com.clt.syscommon.common.table.MstContainerVO;
import com.clt.syscommon.common.table.MstLseTermVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;

/**
 * LseCommon Business Logic ServiceCommand - handling business transaction LseCommon
 *
 * @author 
 * @see ...
 * @since J2EE 1.4
 */

public class LseCommonSC extends ServiceCommandSupport {
	
	// Login User Information
	//private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario LseCommon system <br>
	 * related objects creation<br>
	 */
	@Override
	public void doStart() {
		/*
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		*/
		log.debug("LseCommonSC start");
	}

	/**
	 * biz scenario closing LseCommon system<br>
	 * clearing related objects<br>
	 */
	@Override
	public void doEnd() {
		log.debug("LseCommonSC end");
	}

	/**
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;

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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				// Container Type Size Dynamic Header Search
				eventResponse = searchContainerTypeSizeDynamicHeaderService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				// Location - Port List Search
				eventResponse = searchLocationPortService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				// Vessel SKD List Search
				eventResponse = searchVesselSkdService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				// Lease Agreement List Search by Vendor
				eventResponse = searchAgreementByVendorBrieflyService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				// Office Code List Search
				eventResponse = searchOfficeCodeService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				// Container Search
				eventResponse = searchContainerInfoBrieflyService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				// DeliveryLocation - Off-Hire Yard List Search
				eventResponse = searchOffHireYardListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				// Vessel SVC Lane Code List Search
				eventResponse = searchServiceLaneService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				// Vessel SVC Lane Code List Search
				eventResponse = searchComIntgCdService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				// Delivery Location Briefly Search
				eventResponse = searchDeliveryLocationSearchService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				// Delivery Location Briefly Search
				eventResponse = searchInvoiceNoService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
				// Delivery Location Briefly Search
				eventResponse = searchBldUpDateCheckService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("LseFileUploadEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = manageFileUploadService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse1001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRentalCostAccountOrdService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchChargeTpCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLeaseTerm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRentalCostAccountOrdService(e);
			}
		}
		return eventResponse;
	}

	/**
	 * retrieving for Lease Term combo item<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchLeaseTermListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// Lease Term Combo Object Item
			LeaseTermBC command = new LeaseTermBCImpl();
			List<MstLseTermVO> leaseTermList = command.searchLeaseTermComboItemBasic();

			StringBuffer sLeaseTermNm = new StringBuffer();
			StringBuffer sLeaseTermCd = new StringBuffer();
			StringBuffer sLeaseTermCd2 = new StringBuffer();

			for (int i = 0; i < leaseTermList.size(); i++) {
				if (sLeaseTermNm.toString().equals("")) {
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
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * retrieving for Container Type/Size combo item<br>
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

			for (int i = 0; i < cntrTpSzlist.size(); i++) {
				if (sCntrTpSzNm.toString().equals("")) {
					sCntrTpSzNm.append(cntrTpSzlist.get(i).getCntrTpszCd());
					sCntrTpSzCd.append(cntrTpSzlist.get(i).getCntrTpszCd());
				} else {
					sCntrTpSzNm.append("|").append(cntrTpSzlist.get(i).getCntrTpszCd());
					sCntrTpSzCd.append("|").append(cntrTpSzlist.get(i).getCntrTpszCd());
				}
			}

			eventResponse.setETCData("cntr_tpsz_nm", sCntrTpSzNm.toString());
			eventResponse.setETCData("cntr_tpsz_cd", sCntrTpSzCd.toString());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * retrieving for Agreement on Long Term Lease CNTR Delivery Plan screen<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAgreementBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLseComEvent event = (EesLseComEvent) e;
			String agmtCtyCd = event.getAgreementVO().getAgmtCtyCd();
			String agmtSeq = event.getAgreementVO().getAgmtSeq();

			AgreementBC command = new AgreementBCImpl();
			List<AgreementVO> list = command.searchAgreementListBrieflyBasic(agmtCtyCd, agmtSeq);
			eventResponse.setETCData(list.get(0).getColumnValues());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * retrieving for Lessor on Long Term Lease CNTR Delivery Plan screen<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAgreementLessorBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLseComEvent event = (EesLseComEvent) e;
			String vndrSeq = event.getAgreementVO().getVndrSeq();
			String lstmCd = event.getAgreementVO().getLstmCd();

			AgreementBC command = new AgreementBCImpl();
			List<AgreementVO> list = command.searchAgreementLessorListBrieflyBasic(vndrSeq, lstmCd);

			if("LPOL".equals(lstmCd.toString())) {
				StringBuffer nvndrSeq = new StringBuffer();
				StringBuffer nvndrLglEngNm = new StringBuffer();		
				
				for ( int i = 0 ; i < list.size() ; i++ ) {					
					if (nvndrSeq.toString().equals("")) {
						nvndrSeq.append(list.get(i).getVndrSeq());
						nvndrLglEngNm.append(list.get(i).getVndrLglEngNm());
					} else {
						nvndrSeq.append("|").append(list.get(i).getVndrSeq());
						nvndrLglEngNm.append("|").append(list.get(i).getVndrLglEngNm());
					}
				}			
				eventResponse.setETCData("vndr_seq", nvndrSeq.toString());
				eventResponse.setETCData("vndr_nm", nvndrLglEngNm.toString());				
			} else {
				eventResponse.setETCData("vndr_seq", list.get(0).getVndrSeq());
				eventResponse.setETCData("vndr_nm", list.get(0).getVndrLglEngNm());
				eventResponse.setETCData("lstm_cd", list.get(0).getLstmCd());				
			}

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * retrieving for Delivery Location<br>
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
	 * retrieving for Delivery Location<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchDeliveryLocationSearchService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			DeliveryLocationBC command = new DeliveryLocationBCImpl();
			EesLseComEvent event = (EesLseComEvent)e;
			List<MdmEqOrzChtVO> list = command.searchLocationBasic(event.getLocCd(), event.getEqLocTpCd(), event.getSheetIdx());
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
	 * Invoice No : Open<br>
	 * search Invoice No<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchInvoiceNoService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			LseCommonBC command = new LseCommonBCImpl();
			EesLseComEvent event = (EesLseComEvent)e;
			List<SearchInvoiceNoVO> list = command.searchInvoiceNo(event.getSearchInvoiceNoVO());
			if ( list.size() > 0 ) {
			    eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CSR10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * UI_LSE_COMM : Open<br>
	 * retrieving for Currency <br>
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
	 * retrieving for Delivery Location - RCC <br>
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
	 * retrieving for Vendor<br>
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
	 * retrieving for Delivery Location - Country <br>
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
	 * retrieving for Container Movement Status code list<br>
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
	 * retrieving for dynamic Header for Container Type Size<br>
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
	 * retrieving for Location - Port <br>
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
	 * retrieving for Vessel SKD <br>
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
	 * retrieving for Agreement on Long Term Lease CNTR Delivery Plan screen<br>
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
					agmtNoList = list.get(i).getVndrSeq() + "|" + list.get(i).getAgmtCtyCd() + "|" + list.get(i).getAgmtSeq() + "|" + list.get(i).getLseCtrtNo()
							+ "|" +list.get(i).getLstmCd() + "|" + list.get(i).getEffDt() + "|" + list.get(i).getExpDt();
				} else {
					agmtNoList = agmtNoList + "^" + list.get(i).getVndrSeq() + "|" + list.get(i).getAgmtCtyCd() + "|" + list.get(i).getAgmtSeq() + "|"
							+ list.get(i).getLseCtrtNo() + "|" +list.get(i).getLstmCd() + "|" + list.get(i).getEffDt() + "|" + list.get(i).getExpDt();
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
	 * retrieving for CNTR info<br>
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
	 * retrieving for Office code <br>
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
	 * retrieving for Delivery Location - Off-Hire Yard <br>
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
	 * retrieving for Vessel SVC Lane <br>
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
	 * EES_LSE_0008 <br>
	 * managing file upload<br>
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

	private EventResponse searchRentalCostAccountOrdService(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			LseCommonBC command = new LseCommonBCImpl();
			List<LseRntlCostAcctOrdVO> list = command.searchRentalCostAccountOrdBasic();
			eventResponse.setRsVoList(list);
			return eventResponse;

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[] {}).getMessage(), ex);
		}

	}

	private EventResponse manageRentalCostAccountOrdService(Event e) throws EventException {
		try {
			SignOnUserAccount account = getSignOnUserAccount();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			LseCommonBC command = new LseCommonBCImpl();
			EesLse1001Event event = (EesLse1001Event) e;
			LseRntlCostAcctOrdVO[] lseRntlCostAcctOrdVOs = event.getLseRntlCostAcctOrdVOs();
			for (LseRntlCostAcctOrdVO lseRntlCostAcctOrdVO : lseRntlCostAcctOrdVOs) {
				lseRntlCostAcctOrdVO.setCreUsrId(account.getUsr_id());
				lseRntlCostAcctOrdVO.setUpdUsrId(account.getUsr_id());
			}
			begin();
			command.manageRentalCostAccountOrdBasic(lseRntlCostAcctOrdVOs);
			commit();
			return eventResponse;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  Office Group Code에 해당하는 Office Code List를 Javascript의 JSon 형태로 return한다.. <br>
	 * 
	 * @param String ofcGrpCd Office Group Code
	 * @param String subSysCd Sub-system Code
	 * @return String
	 * 
	 */	
	public static String getTpSz() throws Exception{
		StringBuffer script = new StringBuffer();
		
		List<String> list = geTpSzList();			
		int size = list.size();
		
		script.append("var arrTpSz = new Array(");
		for(int i = 0 ; i < size ; i++){
			if( i != 0 ){
				script.append(",");
			}
			script.append("\"").append(list.get(i).toLowerCase()).append("\"");
		}
		script.append(")");
		
		
		
		return script.toString();
	}	
	
	
	/**
	 * Office Group Code에 해당하는 Office Code List를 return한다.. <br>
	 * 
	 * 
	 * @return List<String>
	 * 
	 */	
	public static List<String> geTpSzList() throws Exception {
		// Container Type/Size
		List<String> list = new ArrayList<String>();
		ContainerTypeSizeBC command = new ContainerTypeSizeBCImpl();		
		//try{
			List<MdmCntrTpSzVO> cntrTpSzlist = command.searchCntrTpSzListBasic();
			int size = cntrTpSzlist.size();
			for(int i = 0 ; i < size ; i++ ){
				list.add(cntrTpSzlist.get(i).getCntrTpszCd());
			}
			
		//}catch(Exception e){
		//	
		//}
		
		return list;
	}
	
	
	/**
	 * Retrieving  Charge Type Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeTpCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		LseCommonBC command = new LseCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<LseRntlCostAcctOrdVO> list = command.searchChargeTpCd();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("LSE10005", new String[]{""}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Retrieving  Lease Term Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLeaseTerm(Event e) throws EventException {
		// PDTO(Data Transfer ObjecRt including Parameters)
		LseCommonBC command = new LseCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<LseRntlCostAcctOrdVO> list = command.searchLeaseTerm();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){ 
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("LSE10005", new String[]{""}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_MST_0016 : retrieve<br>
	 * retrieving for Humidity Control Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	 
	private EventResponse searchComIntgCdService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLseComEvent event = (EesLseComEvent) e;
			String intgCdId = event.getIntgCdId();

			LseCommonBC command = new LseCommonBCImpl();
			List<CommonListVO> list = command.searchComIntgCdBasic(intgCdId);
			
				StringBuffer code = new StringBuffer();
				StringBuffer codeNm = new StringBuffer();		
				
				for ( int i = 0 ; i < list.size() ; i++ ) {					
					if (code.toString().equals("")) {
						code.append(list.get(i).getCode());
						codeNm.append(list.get(i).getCodeNm());
					} else {
						code.append("|").append(list.get(i).getCode());
						codeNm.append("|").append(list.get(i).getCodeNm());
					}
				}			
				eventResponse.setETCData("tp_cd", code.toString());
				eventResponse.setETCData("tp_cd_nm", codeNm.toString());			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * UI_LSE_COMM : Open<br>
	 * retrieving for Delivery Location - Country <br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBldUpDateCheckService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			EesLseComEvent event = (EesLseComEvent) e;
			String schDate = event.getSchDate();
			String agmtSeq = event.getAgmtSeq();

			LseCommonBC command = new LseCommonBCImpl();
			String chkDate = "";
			chkDate = command.searchBldUpDateCheckBasic(schDate,agmtSeq);
				
			eventResponse.setETCData("check_date_yn", chkDate);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	
}