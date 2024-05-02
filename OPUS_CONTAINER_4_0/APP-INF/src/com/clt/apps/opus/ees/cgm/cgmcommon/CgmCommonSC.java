/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmCommonSC.java
*@FileTitle : CgmCodeMgt
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBC;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBCImpl;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.event.CgmComEvent;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.event.EesCgm3001Event;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration.CgmCodeMgtDBDAO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.basic.CgmValidationBC;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.basic.CgmValidationBCImpl;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event.CgmAgreementEvent;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event.CgmCheckLocationEvent;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event.CgmChsMasterEvent;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event.CgmChssPoolEvent;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event.CgmCurrencyEvent;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event.CgmMdmVendorEvent;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event.CgmMstContainerEvent;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event.CgmTpszEvent;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event.CgmValidationEvent;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event.CgmYardEvent;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.ChsMasterMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.LocationMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.MdmCurrencyMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.MdmVendorMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.YardMGTVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CgmCommon Business Logic ServiceCommand - OPUS-CgmCommon handling business transaction
 * 
 * @author 
 * @see CgmCodeMgtDBDAO
 * @since J2EE 1.4
 */

public class CgmCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CgmCommon system handling business transaction<br>
	 * CgmCodeMgtrelated objects creation<br>
	 */
	public void doStart() {
		try {
			
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CgmCommon system biz scenario closing<br>
	 * CgmCodeMgt clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("CgmCommonSC end");
	}

	/**
	 * <br>
	 * opus-CgmCommon system <br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		try {
			
			if (e.getEventName().equalsIgnoreCase("CgmComEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					// Common Code retrieve
					eventResponse = searchCommonCodeListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					// IBCombo Agreement No Pool List retrieve
					eventResponse = searchAgreementByPoolService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					// IBCombo Pool List retrieve
					eventResponse = searchPoolListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					// IBCOMBO - Spec No
					eventResponse = searchSpecListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
					// IBCOMBO - Chassis Type/Size
					eventResponse = searchEqTpszListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
					// IBCOMBO - Manufacturer Type/Size
					eventResponse = searchManuListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
					// M.G Set No retrieve(EES_CGM_2001)
					eventResponse = searchMgsetNoFindService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
					// Vendor Code retrieve
					eventResponse = searchVendorCodeListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
					// Chassis No retrieve(EES_CGM_1006)
					eventResponse = searchStateCodeListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
					// M.G Set No retrieve(EES_CGM_1006)
					eventResponse = searchOrganizationService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
					// Cert Chassis Noretrieve(EES_CGM_1005)
					eventResponse = searchCertChassisListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
					// Financing Coretrieve(EES_CGM_1005)
					eventResponse = searchFinancingCoService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
					eventResponse = searchAgreementMainService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
					eventResponse = searchMovementStatusListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
					eventResponse = searchNuPoolListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
					// DATE로 WEEK, FMDAY-TODAY retrieve
					eventResponse = searchWeekFmToDateService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
					// YEAR-WEEKL로 WEEK, FMDAY-TODAY retrieve
					eventResponse = searchWeekFmToDateByWeekService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
					// RCC, LCC, SCC check
					eventResponse = searchEqOrzChtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
					// Cost Office Code retrieve
					eventResponse = searchCostOfficeService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
					// Invoice Service Provider retrieve
					eventResponse = searchInvSerProviderService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
					// Invoice Service Provider retrieve
					eventResponse = searchLocalTimeByOfficeService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
					// TPSZ Head Retrieve
					eventResponse = searchEqTpszSequenceListService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmValidationEvent")) {
				// Office Code Validation check
				if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = checkOfficeService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmYardEvent")) {
				// ya_cd Code Validation check
				if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = checkYardService(e); // noraml
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmAgreementEvent")) {
				// ya_cd Code Validation check
				if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = checkAgreementService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmChsMasterEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCGMMasterService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmMdmVendorEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchVendorListService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmTpszEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchEqTpSzDupChkService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmMstContainerEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCNTRMasterService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmCheckLocationEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = checkLocationService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchOfficeYardControlOfficeMatchService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmChssPoolEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchChssPoolListService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmCurrencyEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMDMCurrencyService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("CgmFileUploadEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = manageFileUploadService(e);
				}

			} else if (e.getEventName().equalsIgnoreCase("EesCgm3001Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchChssPoolCoListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageChssPoolCoListService(e);
				} 
//				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
//				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [Retrieve] <br>
	 * Retrieve Agreement information retrieve in case of no Pool Code data . Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementByPoolService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchAgreementByPoolBasic(event.getComboINVO());

			StringBuffer comboList = new StringBuffer("");

			for (int i = 0; i < list.size(); i++) {
				ComboMGTVO comboMGTVO = (ComboMGTVO) list.get(i);

				String agmtOfcCtyCd = comboMGTVO.getCode1();
				String agmtSeq = "000000" + comboMGTVO.getCode2();
				String agmtNo = agmtOfcCtyCd + agmtSeq.substring(agmtSeq.length() - 6);
				String agmtRefNo = comboMGTVO.getCode3();
				String vndrSeq = comboMGTVO.getCode4();
				String vndrNm = comboMGTVO.getDesc4();
				String chssPoolCd = comboMGTVO.getCode5();
				String currCd = comboMGTVO.getCode6();

				comboList.append(agmtNo + "|" + vndrSeq + "|" + vndrNm + "|" + currCd + "|" + chssPoolCd + "|" + agmtRefNo);
				if (i < list.size() - 1)
					comboList.append("@");
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Chassis Pool list retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchPoolListBasic(event.getComboINVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * CGM_EQ_SPEC table Spec No list retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchSpecListBasic(event.getComboINVO());

			StringBuffer comboList = new StringBuffer("");
			StringBuffer comboList1002 = new StringBuffer("");
			for (int i = 0; i < list.size(); i++) {
				ComboMGTVO comboMGTVO = (ComboMGTVO) list.get(i);

				String eqSpecCd = comboMGTVO.getCode1();
				String eqSpecNm = comboMGTVO.getDesc1();
				String eqTpsz = comboMGTVO.getDesc2();
				comboList.append(eqSpecCd + "|" + eqSpecNm);
				comboList1002.append(eqSpecCd + "|" + eqTpsz);
				if (i < list.size() - 1) {
					comboList.append("@");
					comboList1002.append("@");
				}
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());
			eventResponse.setETCData("comboList1002", comboList1002.toString());
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Chassis ,M.G.Set Type Size list retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqTpszListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchEqTpszListBasic(event.getComboINVO());

			StringBuffer comboList = new StringBuffer("");

			for (int i = 0; i < list.size(); i++) {
				ComboMGTVO comboMGTVO = (ComboMGTVO) list.get(i);

				String eqTpszCd = comboMGTVO.getCode1();
				String eqTpszNm = comboMGTVO.getDesc1();

				comboList.append(eqTpszCd + "|" + eqTpszNm);
				if (i < list.size() - 1)
					comboList.append("@");
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * MDM table Manufacture List retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManuListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchManuListBasic(event.getComboINVO());

			StringBuffer comboList = new StringBuffer("");

			for (int i = 0; i < list.size(); i++) {
				ComboMGTVO comboMGTVO = (ComboMGTVO) list.get(i);

				String eqManuCd = comboMGTVO.getCode1();
				String eqManuNm = comboMGTVO.getDesc1();

				comboList.append(eqManuCd + "|" + eqManuNm);
				if (i < list.size() - 1)
					comboList.append("@");
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Retrieve M.G.Set Spec No Lot No list. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMgsetNoFindService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchMgsetNoFindBasic(event.getComboINVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// ETCDATA ->> MGTVO
			eventResponse.setRsVoList(list);
			// eventResponse.setETCData("comboList", comboList.toString());

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Location Code check. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocationService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmCheckLocationEvent event = (CgmCheckLocationEvent) e;
			CgmValidationBC command = new CgmValidationBCImpl();

			List<LocationMGTVO> list = command.checkLocationBasic(event.getLocationMGTVO());
			log.debug("======================================================" + list.size());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// ETCDATA ->> MGTVO
			// eventResponse.setRsVoList(list);
			@SuppressWarnings("unused")
			String checkResult = "FALSE";
			if (list != null) {
				if (list.size() > 0) {
					checkResult = "TRUE";
				}
				eventResponse.setRsVoList(list);
			}
			
			// eventResponse.setETCData("checkResult", checkResult);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Common code list retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonCodeListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchCommonCodeListBasic(event.getComboINVO());

			StringBuffer comboList = new StringBuffer("");

			for (int i = 0; i < list.size(); i++) {
				ComboMGTVO comboMGTVO = (ComboMGTVO) list.get(i);

				String code = comboMGTVO.getCode1();
				String name = comboMGTVO.getDesc1();

				comboList.append(code + "|" + name);
				if (i < list.size() - 1)
					comboList.append("@");
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * MDM_VENDOR table Vendor Code and Name retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorCodeListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchVendorCodeListBasic(event.getComboINVO());

			StringBuffer code = new StringBuffer("");
			StringBuffer text = new StringBuffer("");
			StringBuffer code2 = new StringBuffer("");
			StringBuffer code3 = new StringBuffer("");

			for (int i = 0; i < list.size(); i++) {
				ComboMGTVO comboMGTVO = (ComboMGTVO) list.get(i);

				code.append(comboMGTVO.getCode1());
				text.append(comboMGTVO.getDesc1());
				code2.append(comboMGTVO.getCode2());
				code3.append(comboMGTVO.getCode3());

				if (i < list.size() - 1) {
					code.append("|");
					text.append("|");
					code2.append("|");
					code3.append("|");
				}
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("code", code.toString());
			eventResponse.setETCData("text", text.toString());
			eventResponse.setETCData("gen_pay_term_cd", code2.toString());
			eventResponse.setETCData("pay_curr_cd", code3.toString());

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Office Code check. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOfficeService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmValidationEvent event = (CgmValidationEvent) e;
			CgmValidationBC command = new CgmValidationBCImpl();
			List<OfficeMGTVO> list = command.checkOfficeBasic(event.getOfficeINVO());

			String checkResult = "FALSE";
			if (list != null) {
				if (list.size() > 0) {
					checkResult = "TRUE";
				}
			}

			eventResponse.setETCData("checkResult", checkResult);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Yard Code check. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkYardService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmYardEvent event = (CgmYardEvent) e;
			CgmValidationBC command = new CgmValidationBCImpl();

			List<YardMGTVO> list = null;

			if (event.getCgmYardINVO().getChkVer().equals("ver2")) {
				list = command.checkYardAvailableYardBasic(event.getCgmYardINVO());
			} else {
				list = command.checkYardBasic(event.getCgmYardINVO()); // noraml
			}

			String checkResult = "FALSE";
			if (list != null) {
				if (list.size() > 0) {
					checkResult = "TRUE";
				}
			}
			eventResponse.setETCData("checkResult", checkResult);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * MDM_STATE table State information retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStateCodeListService(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchStateCodeListBasic(event.getComboINVO());

			// ETCDATA ->> MGTVO
			eventResponse.setRsVoList(list);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * MDM_ORGANIZATION table information retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOrganizationService(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			MdmOrganizationMGTVO mdmOrganizationMGTVO = command.searchOrganizationBasic(event.getMdmOranizationINVO());

			// ETC DATA setting
			eventResponse.setETCData((Map<String, String>) mdmOrganizationMGTVO.getColumnValues());

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Agreement information existing check. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkAgreementService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmAgreementEvent event = (CgmAgreementEvent) e;
			CgmValidationBC command = new CgmValidationBCImpl();
			log.debug("checkAgreementService====================222222222222222222222222222======");
			List<AgrementMGTVO> list = command.checkAgreementBasic(event.getAgrementINVO());
			log.debug("checkAgreementService");
			String checkResult = "FALSE";
			if (list != null) {
				if (list.size() > 0) {
					checkResult = "TRUE";
					AgrementMGTVO tmp = new AgrementMGTVO();
					tmp = list.get(0);
					checkResult = tmp.getAgmtOfcCtyCd() + tmp.getAgmtSeq();
				}
			}

			eventResponse.setETCData("checkResult", checkResult);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * EQ_LOT_NO table lot No retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCertChassisListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchCertChassisListBasic(event.getComboINVO());

			StringBuffer comboList = new StringBuffer("");

			for (int i = 0; i < list.size(); i++) {
				ComboMGTVO comboMGTVO = (ComboMGTVO) list.get(i);

				String eqCertCd = comboMGTVO.getCode1();
				String eqCertNm = comboMGTVO.getDesc1();

				comboList.append(eqCertCd + "|" + eqCertNm);
				if (i < list.size() - 1)
					comboList.append("@");
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * MDM table Financing Company list retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFinancingCoService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchFinancingCoBasic(event.getComboINVO());

			StringBuffer comboList = new StringBuffer("");

			for (int i = 0; i < list.size(); i++) {
				ComboMGTVO comboMGTVO = (ComboMGTVO) list.get(i);

				String eqFinaCd = comboMGTVO.getCode1();
				String eqFinaNm = comboMGTVO.getDesc1();

				comboList.append(eqFinaCd + "|" + eqFinaNm);
				if (i < list.size() - 1)
					comboList.append("@");
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Agreement No check. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementMainService(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<AgreementMGTVO> responseData = command.searchAgreementMainBasic(event.getAgreementINVO());

			eventResponse.setRsVoList(responseData);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * CGM EQUIPMENT table Chassis master information retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCGMMasterService(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// PDTO(Data Transfer Object including Parameters)
			CgmChsMasterEvent event = (CgmChsMasterEvent) e;
			CgmValidationBC command = new CgmValidationBCImpl();

			List<ChsMasterMGTVO> responseData = command.searchCGMMasterBasic(event.getChsMasterMGTVO());

			// VO Data setting ==> data existing
			eventResponse.setRsVoList(responseData);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Retrieve DM_VENDOR table Vendor information. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorListService(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// PDTO(Data Transfer Object including Parameters)
			CgmMdmVendorEvent event = (CgmMdmVendorEvent) e;
			CgmValidationBC command = new CgmValidationBCImpl();

			List<MdmVendorMGTVO> responseData = command.searchVendorListBasic(event.getMdmVendorMGTVO());

			eventResponse.setRsVoList(responseData);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * CGM_EQ_TP_SZ table information retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqTpSzDupChkService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmTpszEvent event = (CgmTpszEvent) e;
			CgmValidationBC command = new CgmValidationBCImpl();
			List<TpSzDupChkMGTVO> list = command.searchEqTpSzDupChkBasic(event.getTpSzDupChkINVO());
			log.debug("####### checkTpszService #######");
			String checkResult = "FALSE";
			if (list != null) {
				if (list.size() > 0) {
					checkResult = "TRUE";
				}
			}

			eventResponse.setETCData("checkResult", checkResult);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * MST_CONTAINER information retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCNTRMasterService(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// PDTO(Data Transfer Object including Parameters)
			CgmMstContainerEvent event = (CgmMstContainerEvent) e;
			CgmValidationBC command = new CgmValidationBCImpl();

			List<ChsMasterMGTVO> tmpMGTVO = command.searchCNTRMasterBasic(event.getChsMasterMGTVO());

			// VO Data setting ==> data existing check
			eventResponse.setRsVoList(tmpMGTVO);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * mdm_mvmt_sts table information retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMovementStatusListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchMovementStatusListBasic(event.getComboINVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * CGM_CHSS_POOL table information retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChssPoolListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmChssPoolEvent event = (CgmChssPoolEvent) e;
			CgmValidationBC command = new CgmValidationBCImpl();
			List<CgmChssPoolMGTVO> list = command.seachChssPoolListBasic(event.getCgmChssPoolINVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Chassis Nutural Pool list retrieve.. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNuPoolListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchNuPoolListBasic(event.getComboINVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * WEEK and FROM DATE, TO DATE  retrieve.. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeekFmToDateService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchWeekFmToDateBasic(event.getComboINVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * WEEK and FROM DATE, TO DATE  retrieve.. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeekFmToDateByWeekService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchWeekFmToDateByWeekBasic(event.getComboINVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * RCC,LCC,SCC retrieve and Validation check.. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqOrzChtService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			EqOrzChtINVO eqOrzChtINVO = event.getEqOrzChtINVO();
			List<EqOrzChtMGTVO> list = command.searchEqOrzChtBasic(eqOrzChtINVO);

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			
			String eqOrzChtChktype = eqOrzChtINVO.getEqOrzChtChktype();
			if ("RCC".equals(eqOrzChtChktype) || "RCCLCC".equals(eqOrzChtChktype) || "LCCSCC".equals(eqOrzChtChktype)) {
				StringBuffer comboList = new StringBuffer("");
				for (int i = 0; i < list.size(); i++) {
					String currCode = "";
					if ("RCC".equals(eqOrzChtChktype)) {
						currCode = list.get(i).getEqOrzChtRccCd();
					} else if ("RCCLCC".equals(eqOrzChtChktype)) {
						currCode = list.get(i).getEqOrzChtLccCd();
					} else if ("LCCSCC".equals(eqOrzChtChktype)) {
						currCode = list.get(i).getEqOrzChtSccCd();
					}
					if (i > 0)
						comboList.append("@");
					comboList.append(currCode + "|" + currCode);
				}
				eventResponse.setETCData("comboList", comboList.toString());
			}

			return eventResponse;

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * MDM_CURRENCY table information retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMDMCurrencyService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmCurrencyEvent event = (CgmCurrencyEvent) e;
			CgmValidationBC command = new CgmValidationBCImpl();
			List<MdmCurrencyMGTVO> list = command.searchMDMCurrencyBasic(event.getMdmCurrencyMGTVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Cost Office Code  retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostOfficeService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchCostOfficeBasic(event.getComboINVO());

			String costOfficeCode = "";
			if (list != null) {
				ComboMGTVO comboMGTVO = (ComboMGTVO) list.get(0);
				costOfficeCode = comboMGTVO.getCode1();
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("ofc_cd", costOfficeCode);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Invoice Service Provider  retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvSerProviderService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchInvSerProviderBasic(event.getComboINVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Invoice Service Provider  retrieve. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalTimeByOfficeService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmComEvent event = (CgmComEvent) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchLocalTimeByOfficeBasic(event.getComboINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			String localDate = "";
			if (list != null) {
				ComboMGTVO comboMGTVO = (ComboMGTVO) list.get(0);
				localDate = comboMGTVO.getCode1();
				eventResponse.setRsVoList(list);
			}
			eventResponse.setETCData("local_date", localDate);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * EES_LSE_0008 : file upload event handling<br>
	 * file upload event handling<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageFileUploadService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			String strFileName = "";

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			List<String> keys = (List<String>) e.getAttribute("KEYS");
			// log.debug("=============>>>>>>>>>>>>>>>> [LseCommonSC] keys.size() : "
			// + keys.size());
			strFileName = keys.get(0);
			/*
			 * for ( int i = 0 ; i < keys.size(); i++ ) { if (
			 * strFileName.equals("") ) { strFileName = keys.get(i); } else {
			 * strFileName = strFileName + "|" + keys.get(i); } }
			 */
			// log.debug("=============>>>>>>>>>>>>>>>> [LseCommonSC] strFileName : "
			// + strFileName);
			eventResponse.setETCData("filename", strFileName);

			return eventResponse;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [Retrieve] <br>
	 * Location Code check. Retrieve <br>
	 * )
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeYardControlOfficeMatchService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			CgmCheckLocationEvent event = (CgmCheckLocationEvent) e;
			CgmValidationBC command = new CgmValidationBCImpl();

			List<LocationMGTVO> list = command.searchOfficeYardControlOfficeMatchBasic(event.getLocationMGTVO());
			log.debug("======================================================" + list.size());
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			eventResponse.setRsVoList(list);
			// eventResponse.setETCData("checkResult", checkResult);

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchChssPoolCoListService(Event e) throws EventException {
		try {
			EesCgm3001Event event = (EesCgm3001Event) e;
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			List<ComboMGTVO> list = command.searchChssPoolCoListBasic(event.getComboINVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse manageChssPoolCoListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm3001Event event = (EesCgm3001Event) e;
		CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
		try {
			begin();
			command.manageChssPoolCoListBasic(event.getComboMGTVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * TPSZSequence : OPEN<br>
	 * Retrieving container type code name information <br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqTpszSequenceListService(Event e) throws EventException {
		try {

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			CgmComEvent event = (CgmComEvent) e;
			List<ComboMGTVO> list = command.searchEqTpszListBasic(event.getComboINVO());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			StringBuilder sb = new StringBuilder();
			if (list.size() > 0) {
				for (int i = 0; i < list.size() - 1; i++) {
					sb.append(list.get(i).getCode1());
					sb.append("|");
				}
				sb.append(list.get(list.size() - 1).getCode1());
			}

			Map<String, String> etcData = new HashMap<String, String>();

			etcData.put("cntrTypeSize", sb.toString());

			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}		
}
