/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetMgtSC.java
*@FileTitle : Chassis Specification Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBC;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBCImpl;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.basic.ChassisMgsetInventoryBC;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.basic.ChassisMgsetInventoryBCImpl;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1089Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1091Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1092Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1094Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1098Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1100Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1102Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1103Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2076Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2077Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2078Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2079Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2080Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2084Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByStaydaysMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryDtlMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryGeneralMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorAgmtMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorTermMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLocationLessorMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDtlMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1001Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1002Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1003Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1005Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1006Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1007Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1008Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1009Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1010Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1016Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1017Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1018Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1019Event;
//import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1146Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2001Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2004Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2006Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2007Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2011Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2012Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2018Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2019Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2020Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2083Event;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration.ChassisMgsetOnOffhireDBDAO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqPoolInfoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqTpSzMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEquipmentMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundAutoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundLostMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSLostResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterInfoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOffHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnOffhireSummaryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqTpSzMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSFoundLostMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSLostResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOffHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnOffhireSummaryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.basic.ChassisMovementHistoryBC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.basic.ChassisMovementHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMovementMGTVO;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComBakEndJbVO;

/**
 * OPUS-ChassisMgsetMgt Business Logic ServiceCommand - OPUS-ChassisMgsetMgt handling business transaction
 *
 * @author Eui-su Park
 * @see ChassisMgsetOnOffhireDBDAO
 * @since J2EE 1.4
 */
public class ChassisMgsetMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ChassisMgsetMgt system handling business transaction<br>
	 * EES_CGM_1002related objects creation<br>
	 */
	public void doStart() {
		try {
			
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ChassisMgsetMgt system biz scenario closing<br>
	 * EES_CGM_1002 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("ChassisMgsetMgtSC end");
	}

	/**
	 * <br>
	 * opus-ChassisMgsetMgt system <br>
	 *
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		try
		{
			// RDTO(Data Transfer Object including Parameters)
			EventResponse eventResponse = null;

			
			if (e.getEventName().equalsIgnoreCase("EesCgm1001Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSEqTypeSizeListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSEqTypeSizeInEqChkService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
						eventResponse = manageCHSEqTypeSizeService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1001DefaultService(e);
				}
			}  else if (e.getEventName().equalsIgnoreCase("EesCgm2083Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSEqTypeSizeListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSEqTypeSizeInEqChkService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageMGSEqTypeSizeService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2083DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1002Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					//log.debug("☆★☆ ChassisMgsetMgtSC SEARCH -----------------");
					eventResponse = searchCHSEqSpecService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					//log.debug("☆★☆ ChassisMgsetMgtSC SEARCH01 -----------------");
					eventResponse = searchCHSEqInEqSpecService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					//log.debug("☆★☆ ChassisMgsetMgtSC MULTI -----------------");
					eventResponse = modifyCHSEqSpecService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					//log.debug("☆★☆ ChassisMgsetMgtSC REMOVE -----------------");
					eventResponse = removeCHSEqSpecService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1002DefaultService(e);
				}
			}else if (e.getEventName().equalsIgnoreCase("EesCgm1009Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSOffhireInfroService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
					eventResponse = verifyCHSOffhireService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSOffhireEquipmentService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1009DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2011Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSOffhireInfoService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
					eventResponse = verifyMGSOffhireService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageMGSOffhireEquipmentService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2011DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2001Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSEqSpecDupService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSEqSpecService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = modifyMGSEqSpecService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = removeMGSEqSpecService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2001DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1006Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					//log.debug("☆★☆ ChassisMgsetMgtSC SEARCH -----------------");
					eventResponse = searchCHSEqRegistrationService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					log.debug("☆★☆ ChassisMgsetMgtSC SEARCH ****************");
					eventResponse = searchCHSAliasNoService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					log.debug("☆★☆ ChassisMgsetMgtSC MULTI -----------------");
					eventResponse = modifyCHSEqRegistrationService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1006DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1010Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSOnOffhireService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1010DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2012Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("☆★☆  SC    SEARCH    -----------------");
					eventResponse = searchMGSOnOffhireService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2012DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1007Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("*************** SC : "+FormCommand.SEARCH);
					eventResponse = searchCHSEqiPoolListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					log.debug("☆★☆  SC    MULTI    -----------------");
					eventResponse = modifyCHSEqPoolListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1007DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1017Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSInfoService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					log.debug("☆★☆  SC   EesCgm1017Event  MULTI01    -----------------");
					eventResponse = manageCHSLostService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					log.debug("☆★☆  SC   EesCgm1017Event  MULTI02    -----------------");
					eventResponse = manageCHSFoundService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1017DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1003Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					//log.debug("☆★☆ ChassisMgsetMgtSC SEARCH -----------------");
					eventResponse = searchCHSMasterInfoService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1003DefaultService(e);
				}
			}else if (e.getEventName().equalsIgnoreCase("EesCgm2019Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSInfoService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					log.debug("☆★☆  SC   EesCgm2019Event  MULTI01    -----------------");
					eventResponse = manageMGSLostService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					log.debug("☆★☆  SC   EesCgm2019Event  MULTI02    -----------------");
					eventResponse = manageMGSFoundService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2019DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1019Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSLostResultService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1019DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2006Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSEquipmentService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSEquipmentAtChssService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = modifyMGSEquipmentService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2006DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2020Event")) {
				log.debug("☆★☆  SC   EesCgm2020Event  SEARCH    -FormCommand.SEARCH--------------"+FormCommand.SEARCH);
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSLostResultService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2020DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1016Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSStatusService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = modifyCHSStatusService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = removeCHSStatusService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1016DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1005Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					log.debug("FormCommand.SEARCH01 : " + FormCommand.SEARCH01);
					eventResponse = searchCHSSpecService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					log.debug("FormCommand.SEARCH02 : " + FormCommand.SEARCH02);
					eventResponse = searchCHSOwnMasterListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
					log.debug("FormCommand.SEARCH05 : " + FormCommand.SEARCH05);
					eventResponse = searchEqSpecChkService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
					log.debug("FormCommand.SEARCH06 : " + FormCommand.SEARCH06);
					eventResponse = searchEqSpecChkFmToService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSOwnMasterService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1005DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2018Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSStatusService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = modifyMGSStatusService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = removeMGSStatusService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2018DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2004Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSOwnMasterListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchMGSSpecService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
					eventResponse = searchMGSSpecChkService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageMGSOwnMasterService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2004DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1008Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSOnHireStatusChkService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					eventResponse = searchCHSOnHireDupChkService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
					eventResponse = searchCHSOwnLeaseChkService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
					eventResponse = verifyCHSOnhireService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSOnhireService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1008DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1091Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSInventoryGeneralListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1091DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2084Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSInventoryGeneralListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2084DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1089Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSInventoryGeneralService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1089DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2007Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSOnHireStatusChkService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSOnHireEqSpecNoChkService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
					eventResponse = verifyMGSOnhireService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageMGSOnhireService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2007DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1146Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1146Event==========");
					eventResponse = searchErpFACadidateListService(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
					log.debug("EesCgm1146Event==========");
					eventResponse = sendToFAService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1146DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1092Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1092Event==========");
					eventResponse = searchCHSInventoryStaydaysService (e);
				}
				else if( e.getFormCommand().isCommand(FormCommand.SEARCH01)){
					log.debug("EesCgm1092Event==========");
					eventResponse = searchCHSLongstayEnvService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1092DefaultService(e);
				}

			} else if (e.getEventName().equalsIgnoreCase("EesCgm1094Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					log.debug("EesCgm1094Event==========");
					eventResponse = searchCHSLongstayEnvService(e);
				}
				else if( e.getFormCommand().isCommand(FormCommand.MULTI)){
					log.debug("EesCgm1094Event==========");
					eventResponse = manageCHSLongstayEnvService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1094DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1098Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1098Event==========");
					eventResponse = searchCHSInventoryByAgmtService (e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1098DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1100Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1100Event==========");
					eventResponse = searchCHSInventoryByOnhireYearService (e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1100DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1102Event")) {
				if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1102Event==========");
					eventResponse = searchCHSInventoryVariationService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					log.debug("EesCgm1102Event==========");
					eventResponse = searchCHSInventoryVariationServiceKey(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					log.debug("EesCgm1102Event==========");
					eventResponse = searchCHSInventoryVariationServiceChk(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					log.debug("EesCgm1102Event==========");
					eventResponse = searchCHSInventoryVariationServiceFile(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1102DefaultService(e);
				}

			} else if (e.getEventName().equalsIgnoreCase("EesCgm1103Event")) {
				if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1103Event==========");
					eventResponse = searchCHSInventoryVariationDtlListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					log.debug("EesCgm1102Event==========");
					eventResponse = searchCHSInventoryVariationDtlServiceKey(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					log.debug("EesCgm1102Event==========");
					eventResponse = searchCHSInventoryVariationDtlServiceChk(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					log.debug("EesCgm1102Event==========");
					eventResponse = searchCHSInventoryVariationDtlServiceFile(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1103DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1111Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1111Event==========");
					eventResponse = searchCHSUtilFactorService(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
					log.debug("EesCgm1111Event==========");
					eventResponse = searchCHSUtilFactorDtlService(e);
				}
				else if( e.getFormCommand().isCommand(FormCommand.MULTI)){
					log.debug("EesCgm1111Event==========");
					eventResponse = manageChsUtilFactorService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1111DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1112Event")){
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1112Event==========");
					eventResponse = searchCHSUtilizationRptService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1112DefaultService(e);
				}
		    } else if (e.getEventName().equalsIgnoreCase("EesCgm1113Event")){
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1113Event==========");
					eventResponse = searchCHSHistoricalReportService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1113DefaultService(e);
				}
		    } else if (e.getEventName().equalsIgnoreCase("EesCgm1114Event")){
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1114Event==========");
					eventResponse = searchCHSEspFactorService(e);
				}
				else if( e.getFormCommand().isCommand(FormCommand.MULTI)) {
					log.debug("EesCgm1114Event==========");
					eventResponse = manageCHSEspFactorService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1114DefaultService(e);
				}
		    } else if (e.getEventName().equalsIgnoreCase("EesCgm1115Event")){
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1115Event==========");
					eventResponse = searchCHSEspReportServiceKey(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					log.debug("EesCgm1115Event==========");
					eventResponse = searchCHSEspReportServiceChk(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					log.debug("EesCgm1115Event==========");
					eventResponse = searchCHSEspReportServiceFile(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1115DefaultService(e);
				}
		    }else if (e.getEventName().equalsIgnoreCase("EesCgm1018Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					log.debug("EesCgm1018Event==========");
					eventResponse = searchCHSFoundAutoService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)){
					log.debug("EesCgm1018Event=========MODIFY01");
					eventResponse = manageCHSFoundAutoService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)){
					log.debug("EesCgm1018Event=========MODIFY02");
					eventResponse = removCHSFoundAutoService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1018DefaultService(e);
				}
			}else if (e.getEventName().equalsIgnoreCase("EesCgm2076Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
					log.debug("EesCgm2076Event==========");
					eventResponse = searchMGSInventoryGeneralService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2076DefaultService(e);
				}
			}else if (e.getEventName().equalsIgnoreCase("EesCgm2077Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
					log.debug("EesCgm2077Event==========");
					eventResponse = searchMGSInventoryByLessorAgmtService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2077DefaultService(e);
				}
			}else if (e.getEventName().equalsIgnoreCase("EesCgm2078Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
					log.debug("EesCgm2078Event==========");
					eventResponse = searchMGSInventoryByLessorTermService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2078DefaultService(e);
				}
			}else if (e.getEventName().equalsIgnoreCase("EesCgm2079Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
					log.debug("EesCgm2079Event==========");
					eventResponse = searchMGSInventoryByOfficeService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2079DefaultService(e);
				}
			}else if (e.getEventName().equalsIgnoreCase("EesCgm2080Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
					log.debug("EesCgm2080Event==========");
					eventResponse = searchMGSInventoryByLocationLessorService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2080DefaultService(e);
				}
			}

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1001] : [Retrieve] <br>
	 * Retrieve Type Size List of chassis and M.G.Set. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSEqTypeSizeListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1001Event event = (EesCgm1001Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSEqTpSzMGTVO> list = command.searchCHSEqTypeSizeListBasic(event.getCHSEqTpSzINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1001] : [Manage] <br>
	 * Eq Type size information creation/modification/deleting. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSEqTypeSizeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1001Event event = (EesCgm1001Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();
			command.manageCHSEqTypeSizeBasic(event.getCHSEqTpSzINVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2083] : [Retrieve] <br>
	 * Retrieve Type Size List of chassis and M.G.Set. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSEqTypeSizeListService(Event e) throws EventException {
		try
		{
			//log.debug("☆★☆ ChassisMgsetMgtSC SEARCH Check");
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2083Event event = (EesCgm2083Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<MGSEqTpSzMGTVO> list = command.searchMGSEqTypeSizeListBasic(event.getMGSEqTpSzINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1001] : [Retrieve] <br>
	 * Retrieve existing equipment that same Type Size of chassis and M.G.Set (CGM_EQUIPMENT). Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSEqTypeSizeInEqChkService(Event e) throws EventException {
		try
		{
			//log.debug("☆★☆ ChassisMgsetMgtSC SEARCH Check");
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1001Event event = (EesCgm1001Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSEqTpSzMGTVO> list = command.searchCHSEqTypeSizeInEqChkBasic(event.getCHSEqTpSzINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2083] : [Retrieve] <br>
	 * Retrieve existing equipment that same Type Size of chassis and M.G.Set (CGM_EQUIPMENT). Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSEqTypeSizeInEqChkService(Event e) throws EventException {
		try
		{
			//log.debug("☆★☆ ChassisMgsetMgtSC SEARCH Check");
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2083Event event = (EesCgm2083Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<MGSEqTpSzMGTVO> list = command.searchMGSEqTypeSizeInEqChkBasic(event.getMGSEqTpSzINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2083] : [Manage] <br>
	 * Eq Type size information creation/modification/deleting. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSEqTypeSizeService(Event e) throws EventException {
		//log.debug("☆★☆ ChassisMgsetMgtSC MULTI Check");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2083Event event = (EesCgm2083Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();
			command.manageMGSEqTypeSizeBasic(event.getMGSEqTpSzINVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1002] : [Retrieve] <br>
	 * Retrieve Eq spec information of chassis. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSEqSpecService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1002Event event = (EesCgm1002Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSEqSpecMGTVO> list = command.searchCHSEqSpecBasic(event.getCHSEqSpecINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1002] : [Retrieve] <br>
	 * Retrieve existing equipment that match to Eq sper of chassis. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSEqInEqSpecService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1002Event event = (EesCgm1002Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSEqSpecMGTVO> list = command.searchCHSEqInEqSpecBasic(event.getCHSEqSpecINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}


	/**
	 * [EES_CGM_1002] : [Manage] <br>
	 * Eq spec information of chassis creation/modification. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCHSEqSpecService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1002Event event = (EesCgm1002Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();
			command.modifyCHSEqSpecBasic(event.getCHSEqSpecINVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1002] : [Remove] <br>
	 * Eq spec information of chassis deleting. Remove <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSEqSpecService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1002Event event = (EesCgm1002Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();
			command.removeCHSEqSpecBasic(event.getCHSEqSpecINVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1009] : EQ No(change) <br>
	 * Retrieve Information of Eq Master. EQ No(change) <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSOffhireInfroService(Event e) throws EventException {
		log.debug("☆★☆ searchCHSEqinfoService  Check");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1009Event event = (EesCgm1009Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try {
			log.debug("☆★☆ searchCHSEqinfoService  Check==========================");
			List<CHSOffHireMGTVO> list = command.searchCHSOffhireInfoBasic(event.getChsOffHireINVO());
//			CHSEqOffHireMGTVO chsEquipmentMGTVO = command.searchCHSOffhireInfoBasic(event.getChsEquipmentINVO());
			eventResponse.setRsVoList(list);

		} catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		 }catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_1009] : [Verify] <br>
	 *  Verify for Eq Off-hire action <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCHSOffhireService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆ verifyCHSEqOffhireService SEARCH Check");
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1009Event event = (EesCgm1009Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSOffHireMGTVO> list =  command.verifyCHSOffhireBasic(event.getChsOffHireMGTVOs());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}


	/**
	 * [EES_CGM_1009] : [Off-Hire Confim] <br>
	 *  Eq Offhire action. Off-Hire Confim <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSOffhireEquipmentService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1009Event event = (EesCgm1009Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		ChassisMovementHistoryBC bc     = new ChassisMovementHistoryBCImpl();
		List<CHSMovementMGTVO>  chassisMovementMGTVOs = new ArrayList<CHSMovementMGTVO>();
		CHSMovementMGTVO chassisMovementMGTVO = new CHSMovementMGTVO();
		CHSOffHireMGTVO[] cHSOffHireMGTVO = null;

		try{
			begin();
//			command.manageEspFactorService(event.getChsEquipmentMGTVOs(),account);
//			log.debug("event.getChsEquipmentMGTVOs().length============"+event.getChsEquipmentMGTVOs().length);
			command.manageCHSOffhireEquipmentBasic(event.getChsOffHireMGTVOs(),account);

			cHSOffHireMGTVO = event.getChsOffHireMGTVOs();
			for ( int i=0; i<cHSOffHireMGTVO.length; i++ ) {
				chassisMovementMGTVO = new CHSMovementMGTVO();
				//sts_evnt_dt
				chassisMovementMGTVO.setChssNo(cHSOffHireMGTVO[i].getEqNo());
				chassisMovementMGTVO.setMvmtDt(cHSOffHireMGTVO[i].getStsEvntDt()+" 23:59");
				chassisMovementMGTVO.setChssOwnrCoCd("H");
				chassisMovementMGTVO.setYdCd(cHSOffHireMGTVO[i].getStsEvntYdCd());
				chassisMovementMGTVO.setGateIoCd("O");
				chassisMovementMGTVO.setVndrSeq(cHSOffHireMGTVO[i].getVndrSeq());
				chassisMovementMGTVO.setMvmtStsCd("XX");
				chassisMovementMGTVO.setMvmtRsnCd("CHOF");
				chassisMovementMGTVO.setMvmtCoCd("H");
				chassisMovementMGTVO.setUpdUsrId(account.getUsr_id());
				chassisMovementMGTVO.setCreUsrId(account.getUsr_id());

				chassisMovementMGTVOs.add(chassisMovementMGTVO);
			}
			log.debug("tmpVo.size()=================================="+chassisMovementMGTVOs.size());
			bc.createCHSXXMvmtBasic(chassisMovementMGTVOs);


			//manageOffhireEquipmentService

//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2011] : [Retrieve] <br>
	 *  Retrieve Information of Eq Master. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSOffhireInfoService(Event e) throws EventException {
		log.debug("☆★☆ searchMGSEqinfoService  Check");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2011Event event = (EesCgm2011Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();


		try {
			log.debug("☆★☆ searchMGSEqinfoService  Check==========================");
			List<MGSOffHireMGTVO> list = command.searchMGSOffhireInfoBasic(event.getMGSOffHireINVO());
			eventResponse.setRsVoList(list);

		} catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_2011] : [Verify] <br>
	 *  Verify for Eq Off-hire action handling. <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyMGSOffhireService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆ verifyCHSEqOffhireService SEARCH Check");
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2011Event event = (EesCgm2011Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<MGSOffHireMGTVO> list =  command.verifyMGSOffhireBasic(event.getMGSOffHireMGTVOS());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2011] : [Off-Hire Confirm] <br>
	 *  Eq Offhire action. Off-Hire Confirm <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSOffhireEquipmentService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2011Event event = (EesCgm2011Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();


		try{
			begin();
//			command.manageEspFactorService(event.getChsEquipmentMGTVOs(),account);
//			log.debug("event.getChsEquipmentMGTVOs().length============"+event.getChsEquipmentMGTVOs().length);
			command.manageMGSOffhireEquipmentBasic(event.getMGSOffHireMGTVOS(),account);

//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2001] : [Retrieve] <br>
	 * Retrieve Eq spec informatio of M.G.Set. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchMGSEqSpecService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2001Event event = (EesCgm2001Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<MGSEqSpecMGTVO> list = command.searchMGSEqSpecBasic(event.getMGSEqSpecINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2001] : [Retrieve] <br>
	 * Retrieve duplication of M.G.Set Eq spec information. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchMGSEqSpecDupService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2001Event event = (EesCgm2001Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<MGSEqSpecMGTVO> list = command.searchMGSEqSpecDupBasic(event.getMGSEqSpecINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2001] : [Manage] <br>
	 * M.G.Set Eq spec information creation/modification. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMGSEqSpecService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2001Event event = (EesCgm2001Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();
			command.modifyMGSEqSpecBasic(event.getMGSEqSpecINVOS(),account);
			log.debug("☆★☆ event.getMGSEqSpecINVOS() : " + event.getMGSEqSpecINVOS());
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2001] : [Remove] <br>
	 * M.G.Set Eq spec information deleting. Remove <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse removeMGSEqSpecService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2001Event event = (EesCgm2001Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();
			command.removeMGSEqSpecBasic(event.getMGSEqSpecINVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1010] : [Retrieve] <br>
	 *  Retrieve Eq On-hire, Off-hire list Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSOnOffhireService (Event e) throws EventException {
		try
		{
			log.debug("☆★☆ searchCHSEqOnOffhireService  Check");
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EesCgm1010Event event = (EesCgm1010Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();


			log.debug("☆★☆ searchCHSEqOnOffhireService  Check==========================");
			List<CHSOnOffhireSummaryMGTVO> list = command.searchCHSOnOffhireBasic(event.getCHSOnOffhireSummaryINVO());
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2012] : [Retrieve] <br>
	 *  Retrieve Eq On-hire, Off-hire list Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSOnOffhireService (Event e) throws EventException {
		try
		{
			log.debug("☆★☆ searchMGSEqOnOffhireService  Check");
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EesCgm2012Event event = (EesCgm2012Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();


			log.debug("☆★☆ searchMGSEqOnOffhireService  Check==========================");
			List<MGSOnOffhireSummaryMGTVO> list = command.searchMGSOnOffhireBasic(event.getMGSOnOffhireSummaryINVO());
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1006] : [Retrieve] <br>
	 * Retrieve Chassis Registration information. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSEqRegistrationService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆ 1006 --------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1006Event event = (EesCgm1006Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSEquipmentMGTVO> list = command.searchCHSEqRegistrationBasic(event.getCHSEquipmentINVO());

			// Map<String, String> etcData = new HashMap<String, String>();

			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1006] : [Retrieve] <br>
	 * Retrieve duplication of Alias No. Retrieve <br>)
	 *
	 * @param e Event
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSAliasNoService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆ 1006 ************************");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1006Event event = (EesCgm1006Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSEquipmentMGTVO> list = command.searchCHSAliasNoBasic(event.getCHSEquipmentINVO());

			// Map<String, String> etcData = new HashMap<String, String>();

			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1006] : [Manage] <br>
	 * Chassis Registration information creation/modification. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCHSEqRegistrationService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1006Event event = (EesCgm1006Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();
			command.modifyCHSEqRegistrationBasic(event.getCHSEquipmentINVOS(),account);
			log.debug("☆★☆ event.getCHSEquipmentINVOS() : " + event.getCHSEquipmentINVOS());
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1007] : [Retrieve] <br>
	 * Retrieve chassis Pool. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSEqiPoolListService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆ 1007 --------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1007Event event = (EesCgm1007Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSEqPoolInfoMGTVO> list = command.searchCHSEqiPoolListBasic(event.getCHSEqPoolInfoINVO());
			log.debug("☆★☆ event.getCHSEqPoolInfoINVO : " + event.getCHSEqPoolInfoINVO());

			// Map<String, String> etcData = new HashMap<String, String>();

			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1007] : [Manage] <br>
	 * chassis Pool Manage. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCHSEqPoolListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1007Event event = (EesCgm1007Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try
		{
			begin();
			command.modifyCHSEqPoolListBasic(event.getCHSEqPoolInfoINVOS(),account);
			log.debug("☆★☆ event.getCHSEqPoolInfoINVOS() : " + event.getCHSEqPoolInfoINVOS());
			commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1017] : [Retrieve] <br>
	 *  Retrieve Information of Eq Master. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInfoService(Event e) throws EventException {
		log.debug("☆★☆ searchCHSinfoService  Check");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1017Event event = (EesCgm1017Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try {
			log.debug("☆★☆ searchCHSEqinfoService  Check==========================");
			List<CHSFoundLostMGTVO > list  = command.searchCHSInfoBasic(event.getChsFoundLostINVO());
//			log.debug("☆★☆ searchCHSEqinfoService  Check=========================="+chsEquipmentMGTVO);
			eventResponse.setRsVoList(list);

		} catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}


	/**
	 * [EES_CGM_1017] : [Save] <br>
	 *   Lost handling in case of Eq lose.. Save <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSLostService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1017Event event = (EesCgm1017Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		ChassisMovementHistoryBC bc     = new ChassisMovementHistoryBCImpl();
		List<CHSMovementMGTVO>  chassisMovementMGTVOs = new ArrayList<CHSMovementMGTVO>();
		CHSMovementMGTVO mp = new CHSMovementMGTVO();
		CHSFoundLostMGTVO cHSFoundLostMGTVO = null;

		try{
			begin();
//			command.manageEspFactorService(event.getChsEquipmentMGTVOs(),account);
//			log.debug("event.getChsEquipmentMGTVOs().length============"+event.getChsEquipmentMGTVOs().length);
			command.manageCHSLostBasic(event.getChsFoundLostMGTVO(),account);
			cHSFoundLostMGTVO = event.getChsFoundLostMGTVO();

			log.debug("getEqNo============"+cHSFoundLostMGTVO.getEqNo());
//
			for ( int i=0; i<1; i++ ) {
				mp = new CHSMovementMGTVO();
				//sts_evnt_dt
				mp.setChssNo(cHSFoundLostMGTVO.getEqNo());
				mp.setMvmtDt(cHSFoundLostMGTVO.getLEvntDt());
				mp.setChssOwnrCoCd("H");
				mp.setYdCd(cHSFoundLostMGTVO.getLEvntYdCd());
				mp.setGateIoCd("O");
				mp.setVndrSeq(cHSFoundLostMGTVO.getVndrSeq());
				mp.setMvmtStsCd("XX");
				mp.setMvmtRsnCd("LOST");
				mp.setMvmtCoCd("H");
				mp.setUpdUsrId(account.getUsr_id());
				mp.setCreUsrId(account.getUsr_id());

				chassisMovementMGTVOs.add(mp);
			}
			log.debug("tmpVo.size()=================================="+chassisMovementMGTVOs.size());
			bc.createCHSXXMvmtBasic(chassisMovementMGTVOs);


			//manageOffhireEquipmentService
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * [EES_CGM_1017] : [Save] <br>
	 * Found handling lose Eq . Save <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSFoundService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1017Event event = (EesCgm1017Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		ChassisMovementHistoryBC bc     = new ChassisMovementHistoryBCImpl();
		List<CHSMovementMGTVO>  chassisMovementMGTVOs = new ArrayList<CHSMovementMGTVO>();
		CHSMovementMGTVO mp = new CHSMovementMGTVO();
		CHSFoundLostMGTVO tmp = null;

		try{
			begin();
			command.manageCHSFoundBasic(event.getChsFoundLostMGTVO(),account);
			tmp = event.getChsFoundLostMGTVO();

			log.debug("getFEvntDt============"+tmp.getFEvntDt());
//
			for ( int i=0; i<1; i++ ) {
				mp = new CHSMovementMGTVO();
				//sts_evnt_dt

				mp.setChssNo(tmp.getEqNo());
				mp.setMvmtDt(tmp.getFEvntDt());
				mp.setChssOwnrCoCd("H");
				mp.setYdCd(tmp.getFEvntYdCd());
				mp.setGateIoCd("I");
				mp.setVndrSeq(tmp.getVndrSeq());
				mp.setMvmtStsCd("BI");
				mp.setMvmtRsnCd("FOND");
				mp.setMvmtCoCd("H");
				mp.setUpdUsrId(account.getUsr_id());
				mp.setCreUsrId(account.getUsr_id());

				chassisMovementMGTVOs.add(mp);
			}
			bc.createCHSFoundMvmtBasic(chassisMovementMGTVOs);

			
			//manageOffhireEquipmentService
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2019] : [Retrieve] <br>
	 *  Retrieve Information of Eq Master. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInfoService(Event e) throws EventException {
		log.debug("☆★☆ searchCHSinfoService  Check");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2019Event event = (EesCgm2019Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try {
			log.debug("☆★☆ searchCHSEqinfoService  Check==========================");
			List<MGSFoundLostMGTVO > list  = command.searchMGSInfoBasic(event.getMgsFoundLostINVO());
//			log.debug("☆★☆ searchCHSEqinfoService  Check=========================="+chsEquipmentMGTVO);
			eventResponse.setRsVoList(list);

		} catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_2019] : [Save] <br>
	 * Lost handling in case of Eq lose.. Save <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSLostService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2019Event event = (EesCgm2019Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try{
			begin();
//			command.manageEspFactorService(event.getChsEquipmentMGTVOs(),account);
//			log.debug("event.getChsEquipmentMGTVOs().length============"+event.getChsEquipmentMGTVOs().length);
			command.manageMGSLostBasic(event.getMgsFoundLostMGTVO(),account);
			//manageOffhireEquipmentService
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2019] : [Save] <br>
	 *  Found handling lose Eq. Save <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSFoundService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2019Event event = (EesCgm2019Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try{
			begin();
			command.manageMGSFoundBasic(event.getMgsFoundLostMGTVO(),account);


			
			//manageOffhireEquipmentService
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1003] : [Retrieve] <br>
	 * Chassis Retrieve Information of Eq Master. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSMasterInfoService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1003Event event = (EesCgm1003Event)e;
			//log.debug("EesCgm1003Event SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSMasterInfoMGTVO> list = command.searchCHSMasterInfoBasic(event.getCHSMasterInfoINVO());
			// Map<String, String> etcData = new HashMap<String, String>();

			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1019] : [Retrieve] <br>
	 *  Retrieve summary of Eq lost list.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSLostResultService(Event e) throws EventException {
		log.debug("☆★☆ searchCHSLostResultService  Check");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1019Event event = (EesCgm1019Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try {
			log.debug("☆★☆ searchCHSLostResultService  Check==========================");
			List<CHSLostResultMGTVO > list  = command.searchCHSLostResultBasic(event.getChsLostResultINVO());
//			log.debug("☆★☆ searchCHSEqinfoService  Check=========================="+chsEquipmentMGTVO);
			eventResponse.setRsVoList(list);

		} catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_2006] : [Retrieve] <br>
	 * M.G.Set Retrieve Information of Eq Master. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */

	private EventResponse searchMGSEquipmentService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2006Event event = (EesCgm2006Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			//main data
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<MGSEquipmentMGTVO> mainList = command.searchMGSEquipmentBasic(event.getMGSEquipmentINVO());
			eventResponse.setRsVoList(mainList);

			
			List<MGSAtdtHistoryMGTVO> atDtList = command.searchMGSAtdtHistoryBasic(event.getMGSEquipmentINVO());
			eventResponse.setRsVoList(atDtList);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2006] : [Retrieve] <br>
	 * Retrieve chassis that ATTACHED to MGSET in ChassisMgsetOnOffhire. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchMGSEquipmentAtChssService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2006Event event = (EesCgm2006Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<MGSEquipmentMGTVO> list = command.searchMGSEquipmentAtChssBasic(event.getMGSEquipmentINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if(list.size()>0)
			{
				eventResponse.setETCData("CHSS_NO", list.get(0).getEqNo());
			}
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2006] : [Manage] <br>
	 * M.G.Set Eq Master information modification. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMGSEquipmentService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2006Event event = (EesCgm2006Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		ChassisMgsetAttachDetachHistoryBC command2 = new ChassisMgsetAttachDetachHistoryBCImpl();

		try{
			begin();


			MGSEquipmentINVO mGSEquipmentINVO = event.getMGSEquipmentINVO();
			if(mGSEquipmentINVO.getMasterSaveFlag().equals("ATDTONLY"))
			{
				command2.manageMGSAtdtHistoryBasic(mGSEquipmentINVO, event.getMGSAtdtHistoryINVOs(),account);

				//chungpa 20100626 AT/DT시 current location update problem start
				com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs = new com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO[1];
				mGSAtdtHistoryMGTVOs[0] = new com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO();
				//for ( int i=0; i<event.getMGSAtdtHistoryINVOs().length; i++ ) {
				mGSAtdtHistoryMGTVOs[0].setEqNo(mGSEquipmentINVO.getEqNo());
				mGSAtdtHistoryMGTVOs[0].setEqTpszCd(mGSEquipmentINVO.getEqTpszCd());
				//}
				command2.modifyMGSCurrentLocationBasic(mGSAtdtHistoryMGTVOs, account);
				command2.modifyMGSCurrentChassisBasic(mGSAtdtHistoryMGTVOs, account);
				//chungpa 20100626 AT/DT시 current location update problem end

			}else if(mGSEquipmentINVO.getMasterSaveFlag().equals("MASTERONLY"))
			{
				command.modifyMGSEquipmentBasic(event.getMGSEquipmentINVOs(),account);
			}else if(mGSEquipmentINVO.getMasterSaveFlag().equals("ALL"))
			{
				command.modifyMGSEquipmentBasic(event.getMGSEquipmentINVOs(),account);
				command2.manageMGSAtdtHistoryBasic(mGSEquipmentINVO, event.getMGSAtdtHistoryINVOs(),account);

				//chungpa 20100626 AT/DT시 current location update problem start
				com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs = new com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO[1];
				mGSAtdtHistoryMGTVOs[0] = new com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO();
				//for ( int i=0; i<event.getMGSAtdtHistoryINVOs().length; i++ ) {
				mGSAtdtHistoryMGTVOs[0].setEqNo(mGSEquipmentINVO.getEqNo());
				mGSAtdtHistoryMGTVOs[0].setEqTpszCd(mGSEquipmentINVO.getEqTpszCd());
				//}
				command2.modifyMGSCurrentLocationBasic(mGSAtdtHistoryMGTVOs, account);
				command2.modifyMGSCurrentChassisBasic(mGSAtdtHistoryMGTVOs, account);
				//chungpa 20100626 AT/DT시 current location update problem end
			}
			commit();
			String checkResult = "TRUE";
			eventResponse.setETCData("checkResult", checkResult);
		}catch(EventException ex){
			rollback();
			String checkResult = "FALSE";
			eventResponse.setETCData("checkResult", checkResult);
			throw ex;
		}catch(Exception ex) {
			rollback();
			String checkResult = "FALSE";
			eventResponse.setETCData("checkResult", checkResult);
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2020] : [Retrieve] <br>
	 *  Retrieve summary of Eq lost list.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSLostResultService(Event e) throws EventException {
		log.debug("☆★☆ searchMGSLostResultService  Check");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2020Event event = (EesCgm2020Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try {
			log.debug("☆★☆ searchMGSLostResultService  Check==========================");
			List<MGSLostResultMGTVO > list  = command.searchMGSLostResultBasic(event.getMgsLostResultINVO());
//			log.debug("☆★☆ searchCHSEqinfoService  Check=========================="+chsEquipmentMGTVO);
			eventResponse.setRsVoList(list);

		} catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_1016] : [Retrieve] <br>
	 * Retrieve Eq status History. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSStatusService(Event e) throws EventException {
		log.debug("☆★☆ searchCHSStatusService  Check");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1016Event event = (EesCgm1016Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try {
			log.debug("☆★☆ searchCHSStatusService  Check==========================");
			List<CHSStatusInfoMGTVO > list  = command.searchCHSStatusBasic(event.getChsStatusInfoINVO());
//			log.debug("☆★☆ searchCHSEqinfoService  Check=========================="+chsEquipmentMGTVO);
			eventResponse.setRsVoList(list);

		} catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		 }catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_1005] : [Retrieve] <br>
	 * chassis and M.G.Set SerialNo duplication checking. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEqSpecChkService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1005Event event = (EesCgm1005Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSSpecMGTVO> list = command.searchEqSpecChkBasic(event.getCHSSpecINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1005] : [Retrieve] <br>
	 * chassis and M.G.Set  SerialNo FM-TO duplication checking. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEqSpecChkFmToService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1005Event event = (EesCgm1005Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSSpecMGTVO> list = command.searchEqSpecChkFmToBasic(event.getCHSSpecINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1005] : [Retrieve] <br>
	 * Retrieve chassis Eq spec information. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSSpecService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1005Event event = (EesCgm1005Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSSpecMGTVO> list = command.searchCHSSpecBasic(event.getCHSSpecINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1005] : [Retrieve] <br>
	 * Retrieve Eq Own Master(LOT) list. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSOwnMasterListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1005Event event = (EesCgm1005Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSSpecMGTVO> list = command.searchCHSOwnMasterListBasic(event.getCHSSpecINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1005] : [Manage] <br>
	 * Save/Master Update handling in case of Own Master(Lot information) create. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSOwnMasterService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1005Event event = (EesCgm1005Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();

//			Map<String, Object> responseData = command.manageCHSOwnMasterBasic(event.getCHSSpecINVOS(),account);

			command.manageCHSOwnMasterBasic(event.getCHSSpecINVOS(),account);

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1016] : [Save] <br>
	 *  Eq Status modification/deleting. Save <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCHSStatusService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1016Event event = (EesCgm1016Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		ChassisMovementHistoryBC bc     = new ChassisMovementHistoryBCImpl();
		List<CHSMovementMGTVO>  chassisMovementMGTVOs = new ArrayList<CHSMovementMGTVO>();
		CHSMovementMGTVO mp = new CHSMovementMGTVO();
		CHSStatusInfoMGTVO[] tmp = null;

		try{
			begin();
			//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());
//			Map<String, Object> responseData = command.modifyCHSStatusBasic ( event.getChsStatusInfoMGTVOs() ,account);
			command.modifyCHSStatusBasic ( event.getChsStatusInfoMGTVOs() ,account);

			tmp = event.getChsStatusInfoMGTVOs();
			String mvmtDt  = "";
			String mvmtDt2 = "";



			for ( int i=0; i<tmp.length; i++ ) {
				mp = new CHSMovementMGTVO();
				//sts_evnt_dt
				mvmtDt   = tmp[i].getStsEvntDt();
				mvmtDt2  = tmp[i].getStsEvntDt2();
				log.debug("mvmtDt============="+mvmtDt);
				log.debug("mvmtDt============="+mvmtDt);
				mp.setChssNo(tmp[i].getEqNo());
				mp.setMvmtDt(mvmtDt);
				mp.setMvmtDt2(mvmtDt2);
				mp.setYdCd(tmp[i].getStsEvntYdCd());
				mp.setUpdUsrId(account.getUsr_id());
				chassisMovementMGTVOs.add(mp);
			}
			bc.modifyChsMoveByStatusBasic(chassisMovementMGTVOs);
//			 ETC DATA setting
//			eventResponse.setETCData((Map<String,String>)responseData.get(WebKeys.ER_ETCDATA));
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2018] : [Retrieve] <br>
	 *  Retrieve Eq status History Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSStatusService(Event e) throws EventException {
		log.debug("☆★☆ searchCHSStatusService  Check");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2018Event event = (EesCgm2018Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try {
			log.debug("☆★☆ searchCHSStatusService  Check==========================");
			List<MGSStatusInfoMGTVO > list  = command.searchMGSStatusBasic(event.getMgsStatusInfoINVO());
//			log.debug("☆★☆ searchCHSEqinfoService  Check=========================="+chsEquipmentMGTVO);
			eventResponse.setRsVoList(list);

		} catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_2018] : [Save] <br>
	 * Eq Status modification/deleting.. Save <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMGSStatusService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2018Event event = (EesCgm2018Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();
			//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());
//			Map<String, Object> responseData = command.modifyMGSStatusBasic ( event.getMgsStatusInfoMGTVOs() ,account);
			command.modifyMGSStatusBasic ( event.getMgsStatusInfoMGTVOs() ,account);

//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());

			// ETC DATA setting
//			eventResponse.setETCData((Map<String,String>)responseData.get(WebKeys.ER_ETCDATA));
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1016] : [Delete] <br>
	 *  Eq Status deleting. Delete <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSStatusService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1016Event event = (EesCgm1016Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		ChassisMovementHistoryBC bc     = new ChassisMovementHistoryBCImpl();
		List<CHSMovementMGTVO>  chassisMovementMGTVOs = new ArrayList<CHSMovementMGTVO>();
		CHSMovementMGTVO mp = new CHSMovementMGTVO();
		CHSStatusInfoMGTVO   sTmp = new CHSStatusInfoMGTVO();
		CHSMasterMGTVO      cHSMasterMGTVO     = new CHSMasterMGTVO();
		CHSStatusInfoMGTVO[] tmp = null;

		try{
			begin();
			//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());
			tmp = event.getChsStatusInfoMGTVOs();
			String mvmtDt  = "";
			sTmp = command.removeCHSStatusBasic ( event.getChsStatusInfoMGTVOs() ,account);
			mvmtDt  = sTmp.getStsEvntDt();
			for ( int i=0; i<tmp.length; i++ ) {
				mp = new CHSMovementMGTVO();
				//sts_evnt_dt
				mp.setChssNo(tmp[i].getEqNo());
				mp.setMvmtDt(mvmtDt);
				chassisMovementMGTVOs.add(mp);
			}
			log.debug("tmpVo.size()=================================="+chassisMovementMGTVOs.size());
			bc.removeChsMoveByStatusBasic(chassisMovementMGTVOs);
			log.debug("tmpVo.getNo()=================================="+sTmp.getNo());
			for ( int i=0; i<tmp.length; i++ ) {
				cHSMasterMGTVO = new CHSMasterMGTVO();
				//sts_evnt_dt
				cHSMasterMGTVO.setEqNo(tmp[i].getEqNo());
				cHSMasterMGTVO.setUpdUsrId(account.getUsr_id());
				command.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
			}


//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());

			// ETC DATA setting
//			eventResponse.setETCData((Map<String,String>)responseData.get(WebKeys.ER_ETCDATA));
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2018] : [Delete] <br>
	 *  Eq Status deleting. Delete <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse removeMGSStatusService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2018Event event = (EesCgm2018Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();


		try{
			begin();
			//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());
//			Map<String, Object> responseData = command.removeMGSStatusBasic( event.getMgsStatusInfoMGTVOs() ,account);

			command.removeMGSStatusBasic( event.getMgsStatusInfoMGTVOs() ,account);

//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());


			// ETC DATA setting
//			eventResponse.setETCData((Map<String,String>)responseData.get(WebKeys.ER_ETCDATA));
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2004] : [Retrieve] <br>
	 * Retrieve duplication of M.G.Set Eq spec. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchMGSSpecChkService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2004Event event = (EesCgm2004Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<MGSSpecMGTVO> list = command.searchMGSSpecChkBasic(event.getMGSSpecINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2004] : [Retrieve] <br>
	 * M.G.Set Retrieve Eq Own Master(LOT) list. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchMGSOwnMasterListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2004Event event = (EesCgm2004Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<MGSSpecMGTVO> list = command.searchMGSOwnMasterListBasic(event.getMGSSpecINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2004] : [Retrieve] <br>
	 * Retrieve Eq spec informatio of M.G.Set. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchMGSSpecService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2004Event event = (EesCgm2004Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<MGSSpecMGTVO> list = command.searchMGSSpecBasic(event.getMGSSpecINVO());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2004] : [Manage] <br>
	 * M.G.Set Eq spec information creation/modification. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSOwnMasterService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2004Event event = (EesCgm2004Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();
			command.manageMGSOwnMasterBasic(event.getMGSSpecINVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1008] : Change(Chassis No) <br>
	 *  Chassis No check in case of On-Hire Change(Chassis No) <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSOnHireStatusChkService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆ 1008 --------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1008Event event = (EesCgm1008Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSOnHireMGTVO> list = command.searchCHSOnHireStatusChkBasic(event.getCHSOnHireINVO());

			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1008] : Change(Vehicle ID No/Title No/Alias No1/Alias No2)<br>
	 *  Check chss_veh_id_no, chss_tit_no, chss_als_no of chassis in case of On-Hire.  Change(Vehicle ID No/Title No/Alias No1/Alias No2) <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSOnHireDupChkService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆ 1008 --------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1008Event event = (EesCgm1008Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSOnHireMGTVO> list = command.searchCHSOnHireDupChkBasic(event.getCHSOnHireINVO());

			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1008] : [Retrieve] <br>
	 *  Check chss_veh_id_no, chss_tit_no, chss_als_no of chassis in case of On-Hire. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSOwnLeaseChkService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆ 1008 --------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1008Event event = (EesCgm1008Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSOnHireMGTVO> list = command.searchCHSOwnLeaseChkBasic(event.getCHSOnHireINVO());

			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1008] : [Verify] <br>
	 *  Verify handling for Eq On-hire action. Verify <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCHSOnhireService(Event e) throws EventException {
		try
		{
			log.debug("########## verifyCHSOnhireService ##########");
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1008Event event = (EesCgm1008Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			CHSOnHireMGTVO[] ss = null;
			ss = event.getCHSOnHireMGTVOs();
			log.debug("########## getOwnLse ##########"+ss[0].getOnhDt());
	 		List<CHSOnHireMGTVO> list = command.verifyCHSOnhireBasic(event.getCHSOnHireMGTVOs());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1008] : [On-Hire Confirm] <br>
	 *   Eq Onhire action  On-Hire Confirm.<br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSOnhireService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1008Event event = (EesCgm1008Event)e;
		ChassisMgsetOnOffhireBC command  = new ChassisMgsetOnOffhireBCImpl();
		ChassisMovementHistoryBC bc      = new ChassisMovementHistoryBCImpl();
		List<CHSMovementMGTVO> chassisMovementMGTVOs = new ArrayList<CHSMovementMGTVO>();
		CHSMovementMGTVO mp          = new CHSMovementMGTVO();
		CHSOnHireMGTVO[] cHSOnHireMGTVO             = null;

		try{
			begin();
			//command.manageCHSOnhireBasic(event.getCHSOnHireINVOS(),account);
			log.debug("####### event.getCHSOnHireMGTVOs() : " + event.getCHSOnHireMGTVOs());

			cHSOnHireMGTVO = event.getCHSOnHireMGTVOs();
			//command.manageCHSOnhireBasic(tmp, account);
			command.manageCHSOnhireBasic(cHSOnHireMGTVO,account);
			for(int i=0; i<cHSOnHireMGTVO.length; i++){
				mp = new CHSMovementMGTVO();
				// YD_CD 입력  GATE_IO_CD ='I', VNDR_SEQ = NULL, MVMT_STS_CD = 'MT', MVMT_RSN_CD ='CHON' 로 셋
				log.debug("####### event.tmp[i].getOnhDt()() : " + cHSOnHireMGTVO[i].getOnhDt());
				mp.setChssNo(cHSOnHireMGTVO[i].getEqNo());
				mp.setMvmtDt(cHSOnHireMGTVO[i].getOnhDt());

				mp.setYdCd(cHSOnHireMGTVO[i].getOnhYdCd());
				mp.setChssOwnrCoCd("H");
				mp.setGateIoCd("I");
//				mp.setVndrSeq(tmp[i].getVndrSeq());
				mp.setMvmtStsCd("BI");
				mp.setMvmtRsnCd("CHON");
				mp.setMvmtCoCd("H");

				mp.setUpdUsrId(account.getUsr_id());
				mp.setCreUsrId(account.getUsr_id());

				chassisMovementMGTVOs.add(mp);
			}
			// MOVEMENT HISTORY CALL
			log.debug("####### tmpVo.size() #######" + chassisMovementMGTVOs.size());
			bc.createCHSOnhireMvmtBasic(chassisMovementMGTVOs);

//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
//			rollback();
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1091] : [Retrieve] <br>
	 * Retrieve detail list counted on Chassis Inventory by Eq. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSInventoryGeneralListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1091Event event = (EesCgm1091Event)e;
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSInventoryDtlMGTVO> list = command.searchCHSInventoryGeneralListBasic(event.getChsInventoryDtlINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2084] : [Retrieve] <br>
	 * Retrieve detail list counted on M.G.Set Inventory by Eq. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchMGSInventoryGeneralListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2084Event event = (EesCgm2084Event)e;
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<MGSInventoryDtlMGTVO> list = command.searchMGSInventoryGeneralListBasic(event.getMgsInventoryDtlINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1089] : [Retrieve] <br>
	 * Retrieve General Inventory.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSInventoryGeneralService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1089Event event = (EesCgm1089Event)e;
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSInventoryGeneralMGTVO> list = command.searchCHSInventoryGeneralBasic(event.getChsInventoryGeneralINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2007] : [Retrieve] <br>
	 *  Check M.G.Set No in case of On-Hire. . Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSOnHireStatusChkService(Event e) throws EventException {
		log.debug("☆★☆ searchMGSOnHireStatusChkService  Check");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2007Event event = (EesCgm2007Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try {
			log.debug("☆★☆ searchMGSEqinfoService  Check==========================");
			List<MGSOnHireMGTVO> list = command.searchMGSOnHireStatusChkBasic(event.getMGSOnHireINVO());
			eventResponse.setRsVoList(list);

		} catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2007] : [Retrieve] <br>
	 *  Retrieve  Model No. voltage, fuel capacity in case of On-Hire  . Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSOnHireEqSpecNoChkService(Event e) throws EventException {
		log.debug("☆★☆ searchMGSOnHireStatusChkService  Check");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2007Event event = (EesCgm2007Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try {
			log.debug("☆★☆ searchMGSOnHireEqSpecNoChkService  Check==========================");
			List<MGSOnHireMGTVO> list = command.searchMGSOnHireEqSpecNoChkBasic(event.getMGSOnHireINVO());
			eventResponse.setRsVoList(list);

		} catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2007] : [Verify] <br>
	 *  Verify handling for Eq On-hire action.. Verify <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyMGSOnhireService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆ verifyMGSEqOnhireService SEARCH Check");
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2007Event event = (EesCgm2007Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<MGSOnHireMGTVO> list =  command.verifyMGSOnhireBasic(event.getMGSOnHireMGTVOS());

			// Map<String, String> etcData = new HashMap<String, String>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2007] : [On-Hire Confirm] <br>
	 *   Eq Onhire action. On-Hire Confirm <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSOnhireService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2007Event event = (EesCgm2007Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();

		try{
			begin();
			command.manageMGSOnhireBasic(event.getMGSOnHireMGTVOS(),account);

//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
//			rollback();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1146] : [Retrieve] <br>
	 *  ERP FA I/F Eq list  Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErpFACadidateListService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆ 1146 --------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			//EesCgm1146Event event = (EesCgm1146Event)e;
//			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			//List<ErpFaInterfaceMGTVO> list = command.searchErpFACandidateListBasic(event.getErpFaInterfaceMGTVO());

			//eventResponse.setRsVoList(list);
			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1146] : [manage] <br>
	 *  ERP FA I/F Eq list  Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse sendToFAService(Event e) throws EventException {
		log.debug("☆★☆ 1146 --------------------------->>");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//EesCgm1146Event event = (EesCgm1146Event)e;
//		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
//		try{
////			begin();
//			//command.sendToFABasic(event.getErpFaInterfaceINVOs(),account);
//			//commit();
//		}catch(EventException ex){
//			rollback();
//			throw ex;
//		}catch(Exception ex) {
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
//		}
		return eventResponse;
	}


	/**
	 * [EES_CGM_1092] : [Retrieve] <br>
	 * Inventory By staying days calculating.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse GeneralEventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInventoryStaydaysService (Event e) throws EventException {
		try
		{
			log.debug("☆★☆1092--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1092Event event = (EesCgm1092Event)e;
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSInventoryByStaydaysMGTVO> list = command.searchCHSInventoryByStaydaysBasic(event.getCHSInventoryByStaydaysINVO());
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1094] : [Retrieve] <br>
	 * Chassis Long Staying Environment  retrieve.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse GeneralEventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSLongstayEnvService (Event e) throws EventException {
		try
		{
			log.debug("☆★☆1094--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSLongStaydaysEnvINVO cHSLongStaydaysEnvINVO = new CHSLongStaydaysEnvINVO();
			if (e.getEventName().equalsIgnoreCase("EesCgm1094Event")) {
				EesCgm1094Event event = (EesCgm1094Event)e;
				cHSLongStaydaysEnvINVO = event.getCHSLongStaydaysEnvINVO();
			}else if(e.getEventName().equalsIgnoreCase("EesCgm1092Event")) {
				EesCgm1092Event event = (EesCgm1092Event)e;
				cHSLongStaydaysEnvINVO = event.getCHSLongStaydaysEnvINVO();
			}

			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSLongStaydaysEnvMGTVO> list = command.searchCHSLongstayEnvBasic(cHSLongStaydaysEnvINVO, account);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1094] : [Manage] <br>
	 * Chassis Long Staying Environment  modification.. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse GeneralEventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSLongstayEnvService(Event e) throws EventException {
		log.debug("☆★☆1094--------------------------->>");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EesCgm1094Event event = (EesCgm1094Event)e;
		ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
		try{
			begin();
			//Map<String, Object> responseData =
			command.manageCHSLongstayEnvBasic( event.getCHSLongStaydaysEnvINVOs() ,account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			//rollback();
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1098] : [Retrieve] <br>
	 * Inventory By Agreement calculating.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse GeneralEventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInventoryByAgmtService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆1098--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSInventoryByAgmtINVO cHSInventoryByAgmtINVO = null;
			EesCgm1098Event event = (EesCgm1098Event)e;
			cHSInventoryByAgmtINVO = event.getCHSInventoryByAgmtINVO();

			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSInventoryByAgmtMGTVO> list = command.searchCHSInventoryByAgmtBasic(cHSInventoryByAgmtINVO);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1100] : [Retrieve] <br>
	 * Inventory By On-hire year  calculating.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse GeneralEventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInventoryByOnhireYearService (Event e) throws EventException {
		try
		{
			log.debug("☆★☆1100--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSInventoryByOnhireYearINVO cHSInventoryByOnhireYearINVO = null;
			EesCgm1100Event event = (EesCgm1100Event)e;
			cHSInventoryByOnhireYearINVO = event.getCHSInventoryByOnhireYearINVO();

			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSInventoryByOnhireYearMGTVO> list = command.searchCHSInventoryByOnhireYearBasic(cHSInventoryByOnhireYearINVO);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1102] : [Retrieve] <br>
	 * Chassis Variation Status Inquiry  retrieve.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInventoryVariationService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆1102--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSInventoryByVariationINVO cHSInventoryByVariationINVO = null;
			EesCgm1102Event event = (EesCgm1102Event)e;
			cHSInventoryByVariationINVO = event.getCHSInventoryByVariationINVO();

			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSInventoryByVariationMGTVO> list = command.searchCHSInventoryByVariationBasic(cHSInventoryByVariationINVO);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1103] : [Retrieve] <br>
	 * Chassis Variation Status Detail Inquiry  retrieve.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInventoryVariationDtlListService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆1103--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO = null;
			EesCgm1103Event event = (EesCgm1103Event)e;
			cHSInventoryByVariationDtlINVO = event.getCHSInventoryByVariationDtlINVO();

			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSInventoryByVariationDtlMGTVO> list = command.searchCHSInventoryByVariationDtlListBasic(cHSInventoryByVariationDtlINVO);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}


	/**
	 * [EES_CGM_1111] : [Retrieve] <br>
	 * Retrieve factor that numberised Chassis using Practice by SCC/Yard.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSUtilFactorService  (Event e) throws EventException {
		try
		{
			log.debug("☆★☆1111--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSUtilFactorINVO cHSUtilFactorINVO = new CHSUtilFactorINVO();
//			EesCgm1111Event event = (EesCgm1111Event)e;
//			cHSUtilFactorINVO = event.getCHSUtilFactorINVO();

			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSUtilFactorMGTVO> list = command.searchCHSUtilFactorBasic(cHSUtilFactorINVO);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1111] : [Retrieve] <br>
	 * Retrieve detail factor that numberised Chassis using Practice by SCC/Yard.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSUtilFactorDtlService  (Event e) throws EventException {
		try
		{
			log.debug("☆★☆1111--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSUtilFactorINVO cHSUtilFactorINVO = new CHSUtilFactorINVO();
			///EesCgm1111Event event = (EesCgm1111Event)e;
			//cHSUtilFactorINVO = event.getCHSUtilFactorINVO();

			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSUtilFactorMGTVO> list = command.searchCHSUtilFactorDtlBasic(cHSUtilFactorINVO);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1111] : [Manage] <br>
	 * Setting Retrieve factor that numberised Chassis using Practice by SCC/Yard.. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageChsUtilFactorService (Event e) throws EventException {
		log.debug("☆★☆1111--------------------------->>");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		//EesCgm1111Event event = (EesCgm1111Event)e;
//		ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
		try{
			begin();
			//command.manageCHSUtilFactorBasic (event.getCHSUtilFactorINVO(), event.getCHSUtilFactorINVOs1(), event.getCHSUtilFactorINVOs2(), account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
//			rollback();
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1112] : [Retrieve] <br>
	 * Chassis Utilization report calculating.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSUtilizationRptService  (Event e) throws EventException {
		try
		{
			log.debug("☆★☆1112--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSUtilizationINVO cHSUtilizationINVO = new CHSUtilizationINVO();
			//EesCgm1112Event event = (EesCgm1112Event)e;
			//cHSUtilizationINVO = event.getCHSUtilizationINVO();

			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			//List[] responseData = command.searchCHSUtilizationRptBasic(cHSUtilizationINVO);
			CHSUtilizationMGTVO cHSUtilizationMGTVO =  command.searchCHSUtilizationRptBasic(cHSUtilizationINVO);
			//eventResponse.setRsVoList(responseData[0]);
			//eventResponse.setRsVoList(responseData[1]);
			//eventResponse.setRsVoList(responseData[2]);
			//eventResponse.setRsVoList(responseData[3]);
			eventResponse.setRsVoList(cHSUtilizationMGTVO.getList0());
			eventResponse.setRsVoList(cHSUtilizationMGTVO.getList1());
			eventResponse.setRsVoList(cHSUtilizationMGTVO.getList2());
			eventResponse.setRsVoList(cHSUtilizationMGTVO.getList3());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1113] : [Retrieve] <br>
	 * Historical Report calculating by condition.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSHistoricalReportService (Event e) throws EventException {
		try
		{
			log.debug("☆★☆1113--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSHistoricalRptINVO cHSHistoricalRptINVO = new CHSHistoricalRptINVO();

			//EesCgm1113Event event = (EesCgm1113Event)e;
			//cHSHistoricalRptINVO = event.getCHSHistoricalRptINVO();

			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSHistoricalRptMGTVO> list = command.searchCHSHistoricalReportBasic(cHSHistoricalRptINVO);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1114] : [Retrieve] <br>
	 * ESP(Equipment Standard Pool)  Report calculating var retrieve.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSEspFactorService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆1114--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSEspFactorINVO cHSEspFactorINVO = new CHSEspFactorINVO();

			//EesCgm1114Event event = (EesCgm1114Event)e;
			///cHSEspFactorINVO = event.getCHSEspFactorINVO();

			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<CHSEspFactorMGTVO> list = command.searchCHSEspFactorBasic(cHSEspFactorINVO);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1114] : [Manage] <br>
	 * ESP(Equipment Standard Pool) Report calculating var setting.. Manage <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSEspFactorService(Event e) throws EventException {
		log.debug("☆★☆1111--------------------------->>");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		//EesCgm1114Event event = (EesCgm1114Event)e;
//		ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
		try{
			begin();
			//CHSEspFactorINVO[] cHSEspFactorINVOs = event.getCHSEspFactorINVOs();
			//for(int i=0; i<cHSEspFactorINVOs.length; i++){
			//	cHSEspFactorINVOs[i].setCreUsrId(account.getUsr_id());
			//	cHSEspFactorINVOs[i].setUpdUsrId(account.getUsr_id());
			//}
			//command.manageCHSEspFactorBasic (cHSEspFactorINVOs);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
			String checkResult = "TRUE";
			eventResponse.setETCData("checkResult", checkResult);
		}catch(EventException ex){
			rollback();
			String checkResult = "FALSE";
			eventResponse.setETCData("checkResult", checkResult);
			throw ex;
		}catch(Exception ex) {
			rollback();
			String checkResult = "FALSE";
			eventResponse.setETCData("checkResult", checkResult);
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1115] : [Retrieve] <br>
	 * ESP(Equipment Standard Pool)  Report BackEndJob Key creation.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSEspReportServiceKey  (Event e) throws EventException {
		try
		{
			log.debug("☆★☆1115--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSEspReportINVO cHSEspReportINVO = new CHSEspReportINVO();

			//EesCgm1115Event event = (EesCgm1115Event)e;
			//cHSEspReportINVO = event.getCHSEspReportINVO();
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();

			// 기존 non-backendjob List<CHSEspReportMGTVO> list = command.searchCHSEspReportBasic(cHSEspReportINVO);
			//eventResponse.setRsVoList(list);
			//return eventResponse;

			cHSEspReportINVO.setUserId(account.getUsr_id());
			String backEndJobKey = command.searchCHSEspReportBasicBackEndJobStart(cHSEspReportINVO);
			log.info(":::::>>> backEndJobKey : "+backEndJobKey);
	        eventResponse.setETCData("BackEndJobKey", backEndJobKey);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1115] : [Retrieve] <br>
	 * ESP(Equipment Standard Pool)  Report BackEndJob Status Check .. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception BackEndJobException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCHSEspReportServiceChk  (Event e) throws EventException {
		log.debug("☆★☆1115--------------------------->>");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)

		CHSEspReportINVO cHSEspReportINVO = null;

		//EesCgm1115Event event = (EesCgm1115Event)e;
		//cHSEspReportINVO = event.getCHSEspReportINVO();
		try
		{
			if(cHSEspReportINVO != null) {
	    		String backEndJobKey = cHSEspReportINVO.getBackEndJobKey();

				// check Backend job complete
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(backEndJobKey);

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	log.info("chungpa:>>> dbRowSetlist : "+dbRowSetlist);

		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		// for Background job framework error
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
		    	log.info("chungpa:>>> jb_sts_flg : "+jobVo.getJbStsFlg());
			}
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031",new String[]{}).getMessage());
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032",new String[]{}).getMessage());
		}
		//ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
		//List<CHSEspReportMGTVO> list = command.searchCHSEspReportBasic(cHSEspReportINVO);
		//eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * [EES_CGM_1115] : [Retrieve] <br>
	 * ESP(Equipment Standard Pool)  Report BackEndJob result calculating .. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSEspReportServiceFile(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			//EesCgm1115Event event = (EesCgm1115Event)e;

			// BC objects creation
//			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();

			//CHSEspReportINVO cHSEspReportINVO = event.getCHSEspReportINVO();
	    	List<CHSEspReportMGTVO> list = new ArrayList<CHSEspReportMGTVO>();

			// EAIDAO call
			//list = command.searchCHSEspReportBasic(cHSEspReportINVO.getBackEndJobKey());
			log.info("::::::>>> list : "+list);
			eventResponse.setRsVoList(list);

			// return object setting
	        //if(list.size() <= 0) {
		        // GEM00013(There is no related data!)
			//	eventResponse.setUserMessage(new ErrorHandler("GEM00013").getUserMessage());
	        //}

	        return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1018] : [Retrieve] <br>
	 * Retrieve Found.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSFoundAutoService (Event e) throws EventException {
		try
		{
			log.debug("☆★☆ searchCHSFoundAutoService 1018 --------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1018Event event = (EesCgm1018Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			List<CHSFoundAutoMGTVO> list = command.searchCHSFoundAutoBasic(event.getCHSFoundAutoMGTVO());

			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1018] : [Delete] <br>
	 * Update/Delete handling Data/MovementData. Delete <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse removCHSFoundAutoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChassisMovementHistoryBC bc      = new ChassisMovementHistoryBCImpl();
		List<CHSMovementMGTVO> chassisMovementMGTVOs = new ArrayList<CHSMovementMGTVO>();
		CHSMovementMGTVO mp          = new CHSMovementMGTVO();
		CHSFoundAutoMGTVO[] cHSFoundAutoMGTVO             = null;
		EesCgm1018Event event = (EesCgm1018Event)e;

		try{
			begin();
			//command.manageCHSOnhireBasic(event.getCHSOnHireINVOS(),account);
			cHSFoundAutoMGTVO = event.getCHSFoundAutoMGTVOS();

			//command.manageCHSOnhireBasic(tmp, account);
			for(int i=0; i<cHSFoundAutoMGTVO.length; i++){
				mp = new CHSMovementMGTVO();
				log.debug("####### event.tmp[i].getOnhDt()() : " + cHSFoundAutoMGTVO[i].getMvmtDt());
				mp.setChssNo(cHSFoundAutoMGTVO[i].getEqNo());
				mp.setMvmtDt(cHSFoundAutoMGTVO[i].getMvmtDt());
				mp.setSysSeq(cHSFoundAutoMGTVO[i].getSysSeq());
				chassisMovementMGTVOs.add(mp);
			}
			// MOVEMENT HISTORY CALL
			log.debug("####### tmpVo.size() #######" + chassisMovementMGTVOs.size());
			bc.removeChsMvmtFoundAutoBasic(chassisMovementMGTVOs);

//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
//			rollback();
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1018] : [Found Creation] <br>
	 *  Lost handling in case of Eq lose. Found Creation <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSFoundAutoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		ChassisMovementHistoryBC bc      = new ChassisMovementHistoryBCImpl();
		List<CHSMovementMGTVO> chassisMovementMGTVOs = new ArrayList<CHSMovementMGTVO>();
//		CHSMovementMGTVO mp          = new CHSMovementMGTVO();
		CHSFoundAutoMGTVO[] tmp          = null;
		ChassisMgsetOnOffhireBC command  = new ChassisMgsetOnOffhireBCImpl();
		EesCgm1018Event event = (EesCgm1018Event)e;

		try{
			begin();
			tmp = event.getCHSFoundAutoMGTVOS();

			command.manageCHSFoundAutoBasic(tmp, account);
//			for(int i=0; i<tmp.length; i++){
//				mp = new CHSMovementMGTVO();
//				log.debug("####### event.tmp[i].getOnhDt()() : " + tmp[i].getMvmtDt());
//				mp.setMvmtDt(tmp[i].getMvmtDt());
//				mp.setSysSeq(tmp[i].getSysSeq());
//
//				mp = new CHSMovementMGTVO();
//				//sts_evnt_dt
//
//				mp.setChssNo(tmp[i].getEqNo());
//				mp.setMvmtDt(tmp[i].getMvmtsDt());
//				mp.setChssOwnrCoCd("H");
//				mp.setYdCd(tmp[i].getStsEvntYdCd());
//				mp.setGateIoCd("I");
//				mp.setMvmtStsCd("BI");
//				mp.setMvmtRsnCd("FOND");
//				mp.setMvmtCoCd("H");
//
//				mp.setUpdUsrId(account.getUsr_id());
//				mp.setCreUsrId(account.getUsr_id());
//				chassisMovementMGTVOs.add(mp);
//			}
			// MOVEMENT HISTORY CALL
			log.debug("####### tmpVo.size() #######" + chassisMovementMGTVOs.size());
//			bc.createCHSFoundMvmtBasic(chassisMovementMGTVOs);

//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
//			rollback();
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2076] : [Retrieve] <br>
	 * General Inventory calculating.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse GeneralEventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInventoryGeneralService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆2076--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2076Event event = (EesCgm2076Event)e;
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<MGSInventoryGeneralMGTVO> list = command.searchMGSInventoryGeneralBasic(event.getMGSInventoryGeneralINVO());
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2077] : [Retrieve] <br>
	 * Inventory By Lessor, Agreement calculating.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse GeneralEventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInventoryByLessorAgmtService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆2077--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2077Event event = (EesCgm2077Event)e;
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<MGSInventoryByLessorAgmtMGTVO> list = command.searchMGSInventoryByLessorAgmtBasic(event.getMGSInventoryByLessorAgmtINVO());
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2078] : [Retrieve] <br>
	 * Inventory By Lessor, Term calculating(Lessor, Lease Term 별 장비 Inventory).. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse GeneralEventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInventoryByLessorTermService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆2078--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2078Event event = (EesCgm2078Event)e;
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<MGSInventoryByLessorTermMGTVO> list = command.searchMGSInventoryByLessorTermBasic (event.getMGSInventoryByLessorTermINVO());
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2079] : [Retrieve] <br>
	 * Inventory By Office calculating( Office Eq Inventory).. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse GeneralEventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInventoryByOfficeService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆2079--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2079Event event = (EesCgm2079Event)e;
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<MGSInventoryByOfficeMGTVO> list = command.searchMGSInventoryByOfficeBasic (event.getMGSInventoryByOfficeINVO());
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2080] : [Retrieve] <br>
	 * Inventory calculating by Location & Lessor.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse GeneralEventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInventoryByLocationLessorService(Event e) throws EventException {
		try
		{
			log.debug("☆★☆2080--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2080Event event = (EesCgm2080Event)e;
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
			List<MGSInventoryByLocationLessorMGTVO> list = command.searchMGSInventoryByLocationLessorBasic (event.getMGSInventoryByLocationLessorINVO());
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1102] : [Retrieve] <br>
	 * Chassis Variation Status Inquiry BackEndJob Key creation.. Retrieve <br>)
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInventoryVariationServiceKey  (Event e) throws EventException {
		try
		{
			log.debug("☆★☆1102--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSInventoryByVariationINVO cHSInventoryByVariationINVO = null;

			EesCgm1102Event event = (EesCgm1102Event)e;
			cHSInventoryByVariationINVO = event.getCHSInventoryByVariationINVO();
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();

			cHSInventoryByVariationINVO.setUserId(account.getUsr_id());
			String backEndJobKey = command.searchCHSInventoryByVariationBasicBackEndJobStart(cHSInventoryByVariationINVO);
			log.info(":::::>>> backEndJobKey : "+backEndJobKey);
	        eventResponse.setETCData("BackEndJobKey", backEndJobKey);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1102] : [Retrieve] <br>
	 * Chassis Variation Status Inquiry BackEndJob Status Check .. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception BackEndJobException
	 * @exception Exception

	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCHSInventoryVariationServiceChk(Event e) throws EventException {
		log.debug("☆★☆1102--------------------------->>");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)

		CHSInventoryByVariationINVO cHSInventoryByVariationINVO = null;

		EesCgm1102Event event = (EesCgm1102Event)e;
		cHSInventoryByVariationINVO = event.getCHSInventoryByVariationINVO();
		try
		{
			if(cHSInventoryByVariationINVO != null) {
	    		String backEndJobKey = cHSInventoryByVariationINVO.getBackEndJobKey();

				// check Backend job complete
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(backEndJobKey);

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	log.info("chungpa:>>> dbRowSetlist : "+dbRowSetlist);

		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		// for Background job framework error
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
		    	log.info("chungpa:>>> jb_sts_flg : "+jobVo.getJbStsFlg());
			}
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031",new String[]{}).getMessage());
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032",new String[]{}).getMessage());
		}
		//ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();
		//List<CHSEspReportMGTVO> list = command.searchCHSEspReportBasic(cHSEspReportINVO);
		//eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * [EES_CGM_1102] : [Retrieve] <br>
	 * Chassis Variation Status Inquiry BackEndJob result calculating .. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSInventoryVariationServiceFile(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			EesCgm1102Event event = (EesCgm1102Event)e;

			// BC objects creation
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();

			CHSInventoryByVariationINVO cHSInventoryByVariationINVO = event.getCHSInventoryByVariationINVO();
	    	List<CHSInventoryByVariationMGTVO> list = new ArrayList<CHSInventoryByVariationMGTVO>();

			// EAIDAO call
			list = command.searchCHSInventoryByVariationBasicFile(cHSInventoryByVariationINVO.getBackEndJobKey());
			log.info("::::::>>> list : "+list);
			eventResponse.setRsVoList(list);

			// return object setting
	        //if(list.size() <= 0) {
		        // GEM00013(There is no related data!)
			//	eventResponse.setUserMessage(new ErrorHandler("GEM00013").getUserMessage());
	        //}

	        return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1103] : [Retrieve] <br>
	 * Chassis Variation Status Detail Inquiry BackEndJob Key creation.. Retrieve <br>)
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSInventoryVariationDtlServiceKey  (Event e) throws EventException {
		try
		{
			log.debug("☆★☆1103--------------------------->>");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)

			CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO = null;

			EesCgm1103Event event = (EesCgm1103Event)e;
			cHSInventoryByVariationDtlINVO = event.getCHSInventoryByVariationDtlINVO();
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();

			cHSInventoryByVariationDtlINVO.setUserId(account.getUsr_id());
			String backEndJobKey = command.searchCHSInventoryByVariationDtlBasicBackEndJobStart(cHSInventoryByVariationDtlINVO);
			log.info(":::::>>> backEndJobKey : "+backEndJobKey);
	        eventResponse.setETCData("BackEndJobKey", backEndJobKey);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1103] : [Retrieve] <br>
	 * Chassis Variation Status Detail Inquiry BackEndJob Status Check .. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 * @exception BackEndJobException
	 * @exception Exception

	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCHSInventoryVariationDtlServiceChk  (Event e) throws EventException {
		log.debug("☆★☆1103--------------------------->>");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)

		CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO = null;

		EesCgm1103Event event = (EesCgm1103Event)e;
		cHSInventoryByVariationDtlINVO = event.getCHSInventoryByVariationDtlINVO();
		try
		{
			if(cHSInventoryByVariationDtlINVO != null) {
	    		String backEndJobKey = cHSInventoryByVariationDtlINVO.getBackEndJobKey();

				// check Backend job complete
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(backEndJobKey);

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	log.info("chungpa:>>> dbRowSetlist : "+dbRowSetlist);

		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		// for Background job framework error
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
		    	log.info("chungpa:>>> jb_sts_flg : "+jobVo.getJbStsFlg());
			}
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031",new String[]{}).getMessage());
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032",new String[]{}).getMessage());
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1103] : [Retrieve] <br>
	 * Chassis Variation Status Detail Inquiry BackEndJob result calculating .. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchCHSInventoryVariationDtlServiceFile(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			EesCgm1103Event event = (EesCgm1103Event)e;

			// BC objects creation
			ChassisMgsetInventoryBC command = new ChassisMgsetInventoryBCImpl();

			CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO = event.getCHSInventoryByVariationDtlINVO();
	    	List<CHSInventoryByVariationDtlMGTVO> list = new ArrayList<CHSInventoryByVariationDtlMGTVO>();

			// EAIDAO call
			list = command.searchCHSInventoryByVariationDtlBasicFile(cHSInventoryByVariationDtlINVO.getBackEndJobKey());
			log.info("::::::>>> list : "+list);
			eventResponse.setRsVoList(list);

	        return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	// chungpa 20091229 Default Service Start

	/**
	 * [EES_CGM_1001] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1001DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2083] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2083DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1002] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1002DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Spec
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setEqKndCd("Z");
			List<ComboMGTVO> list1 = command.searchSpecListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// Type/Size
			ComboINVO cParam3 = new ComboINVO();
			cParam3.setEqKndCd("Z");
			List<ComboMGTVO> list3 = command.searchEqTpszListBasic(cParam3);
			eventResponse.setRsVoList(list3);


			// Manufacture
			ComboINVO cParam7 = new ComboINVO();
			List<ComboMGTVO> list7 = command.searchManuListBasic(cParam7);
			eventResponse.setRsVoList(list7);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1009] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1009DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2011] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2011DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2001] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2001DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Spec
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setEqKndCd("G");
			List<ComboMGTVO> list1 = command.searchSpecListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// Type/Size
			ComboINVO cParam3 = new ComboINVO();
			cParam3.setEqKndCd("G");
			List<ComboMGTVO> list3 = command.searchEqTpszListBasic(cParam3);
			eventResponse.setRsVoList(list3);


			// Manufacture
			ComboINVO cParam7 = new ComboINVO();
			List<ComboMGTVO> list7 = command.searchManuListBasic(cParam7);
			eventResponse.setRsVoList(list7);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1006] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1006DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// multi combo in grid
			ComboINVO cParam1 = new ComboINVO();
			List<ComboMGTVO> list1 = command.searchStateCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1010] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1010DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// location
			cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list2 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list2);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2012] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2012DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// agmt_lstm_cd
			cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list2 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list2);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1007] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1007DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Location
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// Pool
			ComboINVO cParam2 = new ComboINVO();
			List<ComboMGTVO> list2 = command.searchPoolListBasic(cParam2);
			eventResponse.setRsVoList(list2);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1017] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1017DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1003] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1003DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2019] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2019DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1019] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1019DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2006] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2006DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2020] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2020DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1016] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1016DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1005] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1005DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// CERT & CHASSIS LIST
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setEqKndCd("Z");
			List<ComboMGTVO> list1 = command.searchCertChassisListBasic(cParam1);
			eventResponse.setRsVoList(list1);


			// SPEC NO
			ComboINVO cParam8 = new ComboINVO();
			cParam8.setEqKndCd("Z");
			List<ComboMGTVO> list2 = command.searchSpecListBasic(cParam8);
			eventResponse.setRsVoList(list2);

			// FINANCING CO
			ComboINVO cParam9 = new ComboINVO();
			List<ComboMGTVO> list3 = command.searchFinancingCoBasic(cParam9);
			eventResponse.setRsVoList(list3);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2018] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2018DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2004] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2004DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// MGSET SERIAL RANGE
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setEqKndCd("G");
			List<ComboMGTVO> list1 = command.searchCertChassisListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// model
			ComboINVO cParam3 = new ComboINVO();
			cParam3.setEqKndCd("G");
			List<ComboMGTVO> list3 = command.searchSpecListBasic(cParam3);
			eventResponse.setRsVoList(list3);


			// Manufacture
			ComboINVO cParam7 = new ComboINVO();
			List<ComboMGTVO> list7 = command.searchFinancingCoBasic(cParam7);
			eventResponse.setRsVoList(list7);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1008] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1008DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1091] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1091DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2084] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2084DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1089] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1089DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Location
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// Co-Op Pool
			ComboINVO cParam2 = new ComboINVO();
			List<ComboMGTVO> list2 = command.searchPoolListBasic(cParam2);
			eventResponse.setRsVoList(list2);

			// Type/Size
			ComboINVO cParam3 = new ComboINVO();
			cParam3.setEqKndCd("Z");
			List<ComboMGTVO> list3 = command.searchEqTpszListBasic(cParam3);
			eventResponse.setRsVoList(list3);

			// Lessor Term
			ComboINVO cParam4 = new ComboINVO();
			cParam4.setIntgCdId("CD01948");
			List<ComboMGTVO> list4 = command.searchCommonCodeListBasic(cParam4);
			eventResponse.setRsVoList(list4);

			// MVMT Status
			ComboINVO cParam5 = new ComboINVO();
			List<ComboMGTVO> list5 = command.searchMovementStatusListBasic(cParam5);
			eventResponse.setRsVoList(list5);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2007] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2007DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1146] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1146DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Option
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01863");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1092] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1092DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			ChassisMgsetInventoryBC command2 = new ChassisMgsetInventoryBCImpl();

			// Location
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// Co-Op Pool
			ComboINVO cParam2 = new ComboINVO();
			List<ComboMGTVO> list2 = command.searchPoolListBasic(cParam2);
			eventResponse.setRsVoList(list2);

			// Type/Size
			ComboINVO cParam3 = new ComboINVO();
			cParam3.setEqKndCd("Z");
			List<ComboMGTVO> list3 = command.searchEqTpszListBasic(cParam3);
			eventResponse.setRsVoList(list3);

			// Lessor Term
			ComboINVO cParam4 = new ComboINVO();
			cParam4.setIntgCdId("CD01948");
			List<ComboMGTVO> list4 = command.searchCommonCodeListBasic(cParam4);
			eventResponse.setRsVoList(list4);

			// MVMT Status
			ComboINVO cParam5 = new ComboINVO();
			List<ComboMGTVO> list5 = command.searchMovementStatusListBasic(cParam5);
			eventResponse.setRsVoList(list5);

			// Env Header Setting
			CHSLongStaydaysEnvINVO cHSLongStaydaysEnvINVO = new CHSLongStaydaysEnvINVO();
			List<CHSLongStaydaysEnvMGTVO> list = command2.searchCHSLongstayEnvBasic(cHSLongStaydaysEnvINVO, account);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1094] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1094DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1098] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1098DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Location
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1100] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1100DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Location
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// Type/Size
			ComboINVO cParam3 = new ComboINVO();
			cParam3.setEqKndCd("Z");
			List<ComboMGTVO> list3 = command.searchEqTpszListBasic(cParam3);
			eventResponse.setRsVoList(list3);

			// Lessor Term
			ComboINVO cParam4 = new ComboINVO();
			cParam4.setIntgCdId("CD01948");
			List<ComboMGTVO> list4 = command.searchCommonCodeListBasic(cParam4);
			eventResponse.setRsVoList(list4);

			// MVMT Status
			ComboINVO cParam5 = new ComboINVO();
			List<ComboMGTVO> list5 = command.searchMovementStatusListBasic(cParam5);
			eventResponse.setRsVoList(list5);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1102] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1102DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Location
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1103] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1103DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1111] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1111DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1112] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1112DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1113] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1113DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1114] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1114DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1115] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1115DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//}catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1018] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1018DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2076] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2076DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Location
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// Type/Size
			ComboINVO cParam3 = new ComboINVO();
			cParam3.setEqKndCd("G");
			List<ComboMGTVO> list3 = command.searchEqTpszListBasic(cParam3);
			eventResponse.setRsVoList(list3);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2077] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2077DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Lessor Term
			ComboINVO cParam4 = new ComboINVO();
			cParam4.setIntgCdId("CD01948");
			List<ComboMGTVO> list4 = command.searchCommonCodeListBasic(cParam4);
			eventResponse.setRsVoList(list4);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2078] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2078DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Location
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// Lessor Term
			ComboINVO cParam4 = new ComboINVO();
			cParam4.setIntgCdId("CD01948");
			List<ComboMGTVO> list4 = command.searchCommonCodeListBasic(cParam4);
			eventResponse.setRsVoList(list4);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2079] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2079DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();


			return eventResponse;
		//catch(EventException ex){
		//	throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2080] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2080DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Location
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02117");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	// chungpa 20091229 Default Service End
}



