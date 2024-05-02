/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : AgreementManageSC.java
 *@FileTitle : Managing the Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementCorrectionBC;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementCorrectionBCImpl;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementHisBC;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementHisBCImpl;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementImportBC;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementImportBCImpl;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementRailScgBC;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementRailScgBCImpl;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementTrsAgmtEqTpRuleBC;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementTrsAgmtEqTpRuleBCImpl;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementTrsComScgMgmtBC;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.AgreementTrsComScgMgmtBCImpl;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.LocationBC;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic.LocationBCImpl;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0220Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0221Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0223Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0224Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0226Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0227Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0229Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0230Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0231Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0235Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0237Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0238Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0801Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0980Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.SearchAgmtHdrVO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.SearchLocationDetailVO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsAgmtEqTpRuleVO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsComScgMgmtTpSzVO;
import com.clt.apps.opus.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.clt.apps.opus.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsCommonComboVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * 
 * @author
 * @see AgreementFileImportDBDAO
 * @since J2EE 1.6
 */
public class AgreementManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Generating the implicit object when AgreementFileImport task is called.<br>
	 */
	public void doStart() {
		try {
			// Log-in checking part
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("Error in preceding process of AgreementManageSC " + e.toString(), e);
		}
	}

	/**
	 * End process of TRS task scenario<br>
	 * Releasing the related implicit object when AgreementFileImport task is end.<br>
	 */
	public void doEnd() {
		log.debug("Ending AgreementSC");
	}

	/**
	 * Performing the task scenario corresponding each event.<br>
	 * Branch processing of every event occurring at ESD-TRS task<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsdTrs0220Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // (ESD_TRS_0220) Agreement Header information inquiry
				eventResponse = searchAgmtHdr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // (ESD_TRS_0220) Agreement Child S/P information inquiry
				eventResponse = searchAgmtChdVndr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // (ESD_TRS_0220) Agreement Duplication check
				eventResponse = searchAgmtDupChk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // (ESD_TRS_0220) Agreement Header information save
				eventResponse = multiAgmtHdr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { // (ESD_TRS_0220) Contract Office existence check
				eventResponse = searchContractOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) { // (ESD_TRS_0220) Agreement S/P name inquiry
				eventResponse = searchVenderName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // (ESD_TRS_0220) Agreement Child S/P information save
				eventResponse = multiAgmtHdrVndr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) { // (ESD_TRS_0220) Agreement Remark Update
				eventResponse = multiAgmtHdrRmk(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0221Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComboList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchComboList2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // (ESD_TRS_0221) Agreement Verify
				eventResponse = verifyAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // (ESD_TRS_0221) Agreement rate information save (add/amend/delete)
				eventResponse = multiCorrRateAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // (ESD_TRS_0222) Agreement Surcharge Verify
				eventResponse = verifyAgmtSurcharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // (ESD_TRS_0222) Agreement Surcharge information save (add/amend/delete)
				eventResponse = multiCorrScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) { // (ESD_TRS_0224) Sub Office inquiry
				eventResponse = searchSubOfcCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) { // (ESD_TRS_0225) Agreement Rate delete
				eventResponse = deleteCorrRateAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { // (ESD_TRS_0228) Agreement Surcharge Rate delete
				eventResponse = deleteCorrScgAgmt(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0223Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // (ESD_TRS_0223) US RAIL Agreement Fuel Surcharge inquiry
				eventResponse = searchRailFuelScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // (ESD_TRS_0223) US RAIL Agreement Fuel Surcharge save
				eventResponse = multiRailFuelScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // (ESD_TRS_0223) US RAIL Agreement Fixed Surcharge inquiry
				eventResponse = searchRailFixScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // (ESD_TRS_0223) US RAIL Agreement Fixed Surcharge save
				eventResponse = multiRailFixScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { // (ESD_TRS_0223) US RAIL Agreement Fuel, Fixed Surcharge delete
				eventResponse = deleteRailFuelScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) { // (ESD_TRS_0223) US RAIL Agreement Fuel, Fixed Surcharge delete
				eventResponse = deleteRailFixScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // (ESD_TRS_0223) US RAIL Agreement Fuel Surcharge Verify
				eventResponse = searchRailFuelFixScgAgmtVerify(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // (ESD_TRS_0223) US RAIL Agreement Fuel Surcharge Verify
				eventResponse = searchRailFuelFixScgAgmtVerify(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0224Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // (ESD_TRS_0224) Agreement Rate inquiry
				eventResponse = searchCorrSumAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) { // (ESD_TRS_0224) Delete every rate of Agreement Rate Type
				eventResponse = deleteCorrSumAgmt(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0226Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // (ESD_TRS_0226) Agreement Rate inquiry
				eventResponse = searchCorrRateAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // (ESD_TRS_0228) Agreement Surcharge Rate inquiry
				eventResponse = searchCorrRateAgmtExcelDown(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0227Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // (ESD_TRS_0227) Equipment list inquiry with rate for Agreement Rate History
				eventResponse = searchRateHisAgmt(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0229Event")) { // ESD_TRS_0229 uses method of 0228.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // (ESD_TRS_0228) Agreement Surcharge Rate inquiry
				eventResponse = searchCorrScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // (ESD_TRS_0228) Agreement Surcharge Rate inquiry
				eventResponse = searchCorrScgAgmtExcelDown(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // (ESD_TRS_0921) More Candidate Surcharge Rate inquiry
				eventResponse = searchMoreCadidateScgAgmt(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0230Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // (ESD_TRS_0230) Equipment list inquiry with rate for Agreement Surcharge Rate History
				eventResponse = searchScgHisAgmt(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0231Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // (ESD_TRS_0231) Agreement Rate inquiry
				eventResponse = searchDtlAgmt(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0233Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // (ESD_TRS_0233) Agreement No inquiry
				eventResponse = searchAgmtNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0234Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // US RAIL Agreement Surcharge History inquiry
				eventResponse = searchRailScgAgmtHis(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // US RAIL Agreement Surcharge History Popup inquiry
				eventResponse = searchRailScgAgmtHisPop(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0235Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // (ESD_TRS_0235) Agreement Inquiry Surcharge inquiry
				eventResponse = searchScgDtlAgmt(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0237Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTrsComScgMgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiTrsComScgMgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = deleteTrsComScgMgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchRccCdComList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0238Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchAgmtAtchFileList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageAgmtAtchFile(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsdTrs0801Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTrsAgmtEqTpRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComIntgCdDtl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTrsAgmtEqTpRule(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0980Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLocationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocationDetail(e);
			}
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Location 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0980Event event = (EsdTrs0980Event) e;
		try {
			LocationBC command = new LocationBCImpl();
			eventResponse.setRsVoList(command.searchLocationList(event.getLocCd(), event.getLocNm(), event.getUnLocIndCd(), event.getCntCd(), event.getLocEqOfc(), event.getSelect(), event.getRccCd(), event.getLccCd(), event.getLocState(), event.getIPage(), event.getMdmYN(), event.getDeltFlg(),
					event.getSccFlg()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Location Detail <br>
	 * Location 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0980Event event = (EsdTrs0980Event) e;
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			LocationBC command = new LocationBCImpl();
			List<SearchLocationDetailVO> list = command.searchLocationDetail(event);

			if (list.size() > 0) {
				SearchLocationDetailVO vo = list.get(0);
				etcData.put("loc_cd", vo.getLocCd());
				etcData.put("loc_nm", vo.getLocNm());
				etcData.put("un_loc_cd", vo.getUnLocCd());
				etcData.put("rgn_cd", vo.getRgnCd());
				etcData.put("loc_state", vo.getLocState());
				etcData.put("scc_cd", vo.getSccCd());
				etcData.put("lcc_cd", vo.getLccCd());
				etcData.put("ecc_cd", vo.getEccCd());
				etcData.put("sls_ofc_cd", vo.getSlsOfcCd());
				etcData.put("finc_ctrl_ofc_cd", vo.getFincCtrlOfcCd());
				etcData.put("eq_ctrl_ofc_cd", vo.getEqCtrlOfcCd());
				etcData.put("zip_cd", vo.getZipCd());
				if (vo.getContiNm().trim().length() > 1) {
					etcData.put("conti_nm", vo.getContiNm());
				} else {
					etcData.put("conti_nm", "");
				}
				etcData.put("port_inlnd_flg", vo.getPortInlndFlg());
				etcData.put("call_port_flg", vo.getCallPortFlg());
				etcData.put("loc_locl_lang_nm", vo.getLocLoclLangNm());
				etcData.put("mty_pkup_yd_cd", vo.getMtyPkUpYdCd());
				etcData.put("rep_zn_cd", vo.getRepZnCd());

				etcData.put("hub_loc_cd", vo.getHubLocCd());
				etcData.put("loc_grd_no", vo.getLocGrdNo());
				etcData.put("cml_zn_flg", vo.getCmlZnFlg());
				etcData.put("loc_ams_port_cd", vo.getLocAmsPortCd());
				etcData.put("gmt_hrs", vo.getGmtHrs());
				etcData.put("cstms_cd", vo.getCstmsCd());
				etcData.put("sconti_cd", vo.getScontiCd());
				etcData.put("country", vo.getCountry());
				etcData.put("port_lat", vo.getPortLat());
				etcData.put("port_lon", vo.getPortLon());
			}
			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Combo Search
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboList(Event e) throws EventException {
		EsdTrs0221Event event = (EsdTrs0221Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setRsVoList(searchComboCustCode(event));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Combo Search 2
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboList2(Event e) throws EventException {
		EsdTrs0221Event event = (EsdTrs0221Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setRsVoList(searchComboVendor(event));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * dual Table 조회<br>
	 * 
	 * @param String comCode
	 * @return List<TrsCommonComboVO>
	 * @exception EventException
	 */
	private List<TrsCommonComboVO> searchComboCustCode(Event e) throws EventException {
		TrsCommonBC command = new TrsCommonBCImpl();
		List<TrsCommonComboVO> list = null;
		try {
			list = command.searchComboCustCode(e);
			for (int j = 0; j < list.size(); j++) {
				list.get(j).setDesc(list.get(j).getVal() + " " + list.get(j).getName());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage());
		}

		return list;
	}

	/**
	 * US RAIL VENDOR SEARCH
	 * 
	 * @param String comCode
	 * @return List<TrsCommonComboVO>
	 * @exception EventException
	 */
	private List<TrsCommonComboVO> searchComboVendor(Event e) throws EventException {
		TrsCommonBC command = new TrsCommonBCImpl();
		List<TrsCommonComboVO> list = null;
		try {
			list = command.searchComboVendor(e);
			for (int j = 0; j < list.size(); j++) {
				list.get(j).setDesc(list.get(j).getVal() + " " + list.get(j).getName());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage());
		}

		return list;
	}

	/**
	 * Inquiring Agreement Header information of Agreement Creation & Add page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtHdr(Event e) throws EventException {
		EsdTrs0220Event event = (EsdTrs0220Event) e;
		EventResponse eventResponse = null;

		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchAgmtHdr(event);
		} catch (EventException de) {
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring Agreement S/P information of Agreement Creation & Add page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtChdVndr(Event e) throws EventException {
		EsdTrs0220Event event = (EsdTrs0220Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchAgmtChdVndr(event);
		} catch (EventException de) {
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring Agreement S/P name of Agreement Creation & Add page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVenderName(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchVenderName(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the existence of Contract Office <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractOffice(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchContractOffice(e);
		} catch (EventException de) {
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Checking whether the Agreement of Creation & Add page is duplicated<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtDupChk(Event e) throws EventException {
		EsdTrs0220Event event = (EsdTrs0220Event) e;
		EventResponse eventResponse = null;
		SearchAgmtHdrVO[] searchAgmtHdrVOs = event.getSearchAgmtHdrVOs();
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			for (int i = 0; i < searchAgmtHdrVOs.length; i++) {
				eventResponse = command.searchAgmtDupChk(searchAgmtHdrVOs[i]);
			}
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Saving Agreement Header information of Agreement Creation & Add page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAgmtHdr(Event e) throws EventException {
		EsdTrs0220Event event = (EsdTrs0220Event) e;
		EventResponse eventResponse = null;
		SearchAgmtHdrVO[] searchAgmtHdrVOs = event.getSearchAgmtHdrVOs();
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.multiAgmtHdr(searchAgmtHdrVOs[0]);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Amending Agreement Header information<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAgmtHdrRmk(Event e) throws EventException {
		EsdTrs0220Event event = (EsdTrs0220Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.multiAgmtHdrRmk(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Saving Agreement S/P information of Agreement Creation & Add page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAgmtHdrVndr(Event e) throws EventException {
		EsdTrs0220Event event = (EsdTrs0220Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.multiAgmtHdrVndr(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Verifying Pair Type Agreement of Creation / Correction page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyAgmt(Event e) throws EventException {
		EsdTrs0221Event event = (EsdTrs0221Event) e;
		EventResponse eventResponse = new GeneralEventResponse();
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);
			
			// TODO recover 2016.02.25 KSW
			//begin();
			//command.deleteTrsAgmtTmp(event);
			//commit();

			begin();
			command.insertAgmtVerifyData(event);
			commit();

			eventResponse = command.verifyAgmtPair(event);

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee) {
			rollback();
			log.error("err " + e.toString(), ee);
			throw new EventException(ee.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Verifying Agreement Surcharge Rate of Agreement Surcharge page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyAgmtSurcharge(Event e) throws EventException {
		EsdTrs0221Event event = (EsdTrs0221Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);

			// TODO recover 2016.02.25 KSW
			//begin();
			//command.deleteTrsAgmtTmp(event);
			//commit();

			begin();
			command.insertAgmtVerifyData(event);
			commit();

			eventResponse = command.verifyAgmtSurcharge(event);

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring US RAIL Agreement Fuel Surcharge of US RAIL Surcharge page <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailFuelScgAgmt(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			eventResponse = command.searchRailFuelScgAgmt(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Saving US RAIL Agreement Fuel Surcharge of US RAIL Surcharge page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiRailFuelScgAgmt(Event e) throws EventException {
		EsdTrs0223Event event = (EsdTrs0223Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			command.multiRailFuelScgAgmt(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * US RAIL Surcharge - Inquiring US RAIL Agreement Fixed Surcharge<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailFixScgAgmt(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			eventResponse = command.searchRailFixScgAgmt(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Saving US RAIL Agreement Fixed Surcharge of US RAIL Surcharge page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiRailFixScgAgmt(Event e) throws EventException {
		EsdTrs0223Event event = (EsdTrs0223Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			command.multiRailFixScgAgmt(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Deleting US RAIL Agreement Fuel Surcharge of US RAIL Surcharge <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteRailFuelScgAgmt(Event e) throws EventException {
		EsdTrs0223Event event = (EsdTrs0223Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			command.deleteRailFuelScgAgmt(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Deleting US RAIL Agreement Fixed Surcharge of US RAIL Surcharge <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteRailFixScgAgmt(Event e) throws EventException {
		EsdTrs0223Event event = (EsdTrs0223Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			command.deleteRailFixScgAgmt(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Verifying US RAIL Agreement Fuel Surcharge of US RAIL Surcharge page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailFuelFixScgAgmtVerify(Event e) throws EventException {
		EsdTrs0223Event event = (EsdTrs0223Event) e;
		EventResponse eventResponse = new GeneralEventResponse();
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			begin();
			command.deleteRailFuelFixScgAgmtVerifyData(event);
			commit();

			String newRailScgSeq = command.searchRailFuelFixScgAgmtVerifySeq();
			event.setAgmtRailTmpSeq(newRailScgSeq);

			begin();
			command.insertRailFuelFixScgAgmtVerifyData(event);
			commit();

			if (event.getScgKnd().equals("FSG")) {
				eventResponse = command.verifyAgmtFuel(event);
			} else if (event.getScgKnd().equals("TTL")) {
				eventResponse = command.verifyAgmtFix(event);
			}
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring Agreement Rate of Agreement Summary page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrSumAgmt(Event e) throws EventException {
		EsdTrs0224Event event = (EsdTrs0224Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			eventResponse = command.searchCorrSumAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Deleting Agreement Rate of Agreement Summary page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteCorrSumAgmt(Event e) throws EventException {
		EsdTrs0224Event event = (EsdTrs0224Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			eventResponse = command.deleteCorrSumAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring Sub Office of Agreement Summary page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubOfcCd(Event e) throws EventException {
		EsdTrs0221Event event = (EsdTrs0221Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchSubOfcCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring Agreement Rate of Agreement Rate Correction <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrRateAgmt(Event e) throws EventException {
		EsdTrs0226Event event = (EsdTrs0226Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			eventResponse = command.searchCorrRateAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of searchCorrRateAgmtExcelDown event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrRateAgmtExcelDown(Event e) throws EventException {
		EsdTrs0226Event event = (EsdTrs0226Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			String fm_eq_knd_cd = event.getFm_eq_knd_cd();
			eventResponse.setCustomData("rowset", command.getRowSet2(event));
			eventResponse.setCustomData("title", command.getTitle2(fm_eq_knd_cd));
			eventResponse.setCustomData("columns", command.getColumns2(fm_eq_knd_cd));
			eventResponse.setCustomData("fileName", "TRS_0213_EXCEL.xls");
			eventResponse.setCustomData("isZip", true);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Delete Agreement Rate of Agreement Rate Correction page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteCorrRateAgmt(Event e) throws EventException {
		EsdTrs0221Event event = (EsdTrs0221Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);
			begin();
			command.deleteTrsAgmtTmp(event);
			commit();
			begin();
			command.insertAgmtVerifyData(event);
			commit();
			eventResponse = command.deleteCorrRateAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Modifying Agreement Rate of Agreement Rate Correction page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCorrRateAgmt(Event e) throws EventException {
		EsdTrs0221Event event = (EsdTrs0221Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			begin();
			eventResponse = command.multiCorrRateAgmt(event);
			
			// TODO recover 2016.02.25 KSW
			//command.deleteAgmtVerifyData(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring Rate History of Agreement Rate History page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateHisAgmt(Event e) throws EventException {
		EsdTrs0227Event event = (EsdTrs0227Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementHisBC command = new AgreementHisBCImpl();
			eventResponse = command.searchRateHisAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring Surcharge Rate of Agreement Surcharge Correction page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrScgAgmt(Event e) throws EventException {
		EsdTrs0229Event event = (EsdTrs0229Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			eventResponse = command.searchCorrScgAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring Surcharge Rate of WorkOrder Issue More Candidate popup<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMoreCadidateScgAgmt(Event e) throws EventException {
		EsdTrs0229Event event = (EsdTrs0229Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			eventResponse = command.searchMoreCadidateScgAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of searchCorrScgAgmtExcelDown event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrScgAgmtExcelDown(Event e) throws EventException {
		EsdTrs0229Event event = (EsdTrs0229Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			String fm_eq_knd_cd = event.getFm_eq_knd_cd();
			eventResponse.setCustomData("rowset", command.getRowSet1(event));
			eventResponse.setCustomData("title", command.getTitle1(fm_eq_knd_cd));
			eventResponse.setCustomData("columns", command.getColumns1(fm_eq_knd_cd));
			eventResponse.setCustomData("fileName", "TRS_0212_EXCEL.xls");
			eventResponse.setCustomData("isZip", true);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Deleting Surcharge Rate of Agreement Surcharge Correction page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteCorrScgAgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0221Event event = (EsdTrs0221Event) e;
		AgreementImportBC command = new AgreementImportBCImpl();
		try {
			command.deleteCorrScgAgmt(event.getDummyAgmtRateVOs(), account);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Modifying Surcharge Rate of Agreement Surcharge Correction page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCorrScgAgmt(Event e) throws EventException {
		EsdTrs0221Event event = (EsdTrs0221Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);

			// TODO recover 2016.02.25 KSW
			//begin();
			//command.deleteTrsAgmtTmp(event);
			//commit();

			begin();
			command.insertAgmtVerifyData(event);
			commit();

			begin();
			eventResponse = command.multiCorrScgAgmt(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring Rate History of Agreement Surcharge Rate History page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgHisAgmt(Event e) throws EventException {
		EsdTrs0230Event event = (EsdTrs0230Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementHisBC command = new AgreementHisBCImpl();
			eventResponse = command.searchScgHisAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the Rate of Agreement Rate page<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDtlAgmt(Event e) throws EventException {
		EsdTrs0231Event event = (EsdTrs0231Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementHisBC command = new AgreementHisBCImpl();
			eventResponse = command.searchDtlAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the Rate of Agreement Rate page<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgDtlAgmt(Event e) throws EventException {
		EsdTrs0235Event event = (EsdTrs0235Event) e;
		EventResponse eventResponse = null;
		try {
			AgreementHisBC command = new AgreementHisBCImpl();
			eventResponse = command.searchScgDtlAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring Agreement No <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtNo(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			eventResponse = command.searchAgmtNo(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring US RAIL Agreement Surcharge History of US RAIL Surcharge page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailScgAgmtHis(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			eventResponse = command.searchRailScgAgmtHis(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring US RAIL Agreement Surcharge History of US RAIL Surcharge Popup page <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailScgAgmtHisPop(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			eventResponse = command.searchRailScgAgmtHisPop(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve Trs Agmt Eq Type
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchTrsAgmtEqTpRule(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0801Event event = (EsdTrs0801Event) e;
		AgreementTrsAgmtEqTpRuleBC command = new AgreementTrsAgmtEqTpRuleBCImpl();
		try {
			List<TrsAgmtEqTpRuleVO> list = command.searchTrsAgmtEqTpRule(event);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve Com Intg Cd Dtl
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchComIntgCdDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0801Event event = (EsdTrs0801Event) e;
		AgreementTrsAgmtEqTpRuleBC command = new AgreementTrsAgmtEqTpRuleBCImpl();
		try {
			List<ComIntgCdDtlVO> list = command.searchComIntgCdDtl(event);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * manage Trs Agmt Eq Tp Rule
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse manageTrsAgmtEqTpRule(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0801Event event = (EsdTrs0801Event) e;
		AgreementTrsAgmtEqTpRuleBC command = new AgreementTrsAgmtEqTpRuleBCImpl();
		try {
			begin();
			command.manageTrsAgmtEqTpRule(event.getTrsAgmtEqTpRuleVOs(), account);
			commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Inquiring Common Surcharge of Common Surcharge Management ( ESD_TRS_0237 ) page
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrsComScgMgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0237Event event = (EsdTrs0237Event) e;
		AgreementTrsComScgMgmtBC command = new AgreementTrsComScgMgmtBCImpl();
		try {
			List<TrsComScgMgmtTpSzVO> list = command.searchTrsComScgMgmt(event.getTrsComScgMgmtTpSzVO(), account);
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Modifying Common Surcharge of Common Surcharge Management ( ESD_TRS_0237 ) page
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTrsComScgMgmt(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0237Event event = (EsdTrs0237Event) e;
		AgreementTrsComScgMgmtBC command = new AgreementTrsComScgMgmtBCImpl();
		try {
			begin();
			
			// 1. insert into temp table
			String trspTmpSeq = command.insertAgmtVerifyData(Arrays.asList(event.getTrsComScgMgmtTpSzVOs()), account.getUsr_id());
			// 2. check duplication of temp table data against master table
			DBRowSet rowSet = command.verifySurcharge(trspTmpSeq);
			//////////////////////
            if(rowSet.next()) {
                eventResponse.setETCData("ROW_NO", rowSet.getString("ROW_NO"));
                eventResponse.setETCData("DB_DUP", rowSet.getString("DB_DUP"));
                //eventResponse.setRsVo(rowSet);
    			// 3.A. delete temp table data
    			command.deleteTrsAgmtTmp(trspTmpSeq);
            } else {
    			// 3.B.1. insert into master table
    			command.multiTrsComScgMgmt(trspTmpSeq);
    			// 3.B.2. delete temp table data
    			command.deleteTrsAgmtTmp(trspTmpSeq);
            }
            /////////////////////
			
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex1) {
			rollback();
			log.error("err " + ex1.toString(), ex1);
			throw new EventException(ex1.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Searching ComboList of RCC Code
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchRccCdComList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0237Event event = (EsdTrs0237Event) e;
		AgreementTrsComScgMgmtBC command = new AgreementTrsComScgMgmtBCImpl();
		
		try{
			List<TrsComScgMgmtTpSzVO> list = command.searchRccCdComList(event);
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Deleting Common Surcharge of Common Surcharge Management ( ESD_TRS_0237 ) page
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteTrsComScgMgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0237Event event = (EsdTrs0237Event) e;
		AgreementTrsComScgMgmtBC command = new AgreementTrsComScgMgmtBCImpl();
		try {
			command.deleteTrsComScgMgmt(event.getTrsComScgMgmtTpSzVOs(), account);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESD_TRS_0238 조회 이벤트 처리<br>
	 * Agreement의 File 저장 정보를 가져온다.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtAtchFileList(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
		EsdTrs0238Event event = (EsdTrs0238Event)e;

		try{
			eventResponse = command.searchAgmtAtchFileList(event);
		}catch(EventException de){
			throw de;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESD_TRS_0238 저장 이벤트 처리<br>
	 * Agreement의 Attach File Image를 관리
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgmtAtchFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AgreementCorrectionBC command = new AgreementCorrectionBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsdTrs0238Event event = (EsdTrs0238Event)e;

		try{
			//2.로직 처리 실행
			begin();
			command.manageAgmtAtchFileList(event);
			commit();

			//3.로직 처리후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("TRS90417", "Data").getUserMessage());  //TRS90417 : 저장성공

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}
