/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MovementMnrHistorySC.java
*@FileTitle : test
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBC;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBCImpl;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.event.EesCgm1015Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.event.EesCgm2016Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSMovementHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.basic.ChassisMovementHistoryBC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.basic.ChassisMovementHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.event.EesCgm1104Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.event.EesCgm1105Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.event.EesCgm1108Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.event.EesCgm1109Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.event.EesCgm1150Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.event.UbizownOPUSCgmMvmtEvent;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration.ChassisMovementHistoryDBDAO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtBareMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtGroupVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSmgstChkINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.ShipCHSMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.basic.MgsetMovementHistoryBC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.basic.MgsetMovementHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event.EesCgm2104Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event.EesCgm2105Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event.EesCgm2108Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event.EesCgm2109Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtBareMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtGroupVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSmgstChkINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.basic.PoolChassisHistoryBC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.basic.PoolChassisHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1141Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1142Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1143Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1144Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1145Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1149Event;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolExpenseTrendMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMaintRprHisMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMnrHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtCompareSmryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtGroupVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysMGTVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-MovementMnrHistory Business Logic ServiceCommand - OPUS-MovementMnrHistory handling business transaction
 *
 * @author 
 * @see ChassisMovementHistoryDBDAO
 * @since J2EE 1.6
 */

public class MovementMnrHistorySC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * MovementMnrHistory system handling business transaction<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("MovementMnrHistorySC start");
		try {
			
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * MovementMnrHistory system biz scenario closing<br>
	 * test clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("MovementMnrHistorySC end");
	}

	/**
	 * <br>
	 * opus-MovementMnrHistory system <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		try
		{
			// RDTO(Data Transfer Object including Parameters)
			EventResponse eventResponse = null;
			log.debug("MovementMnrHistory");
			if (e.getEventName().equalsIgnoreCase("EesCgm1104Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchChsMovementListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1104DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1105Event")) {
				log.debug("EesCgm1105Event");
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSMovementHistoryService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1108Event")) {
				log.debug("EesCgm1108Event");
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSBareMvmtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
					eventResponse = verifyCHSBareMvmtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
					eventResponse = manageCHSBareMvmtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
					eventResponse = createCHSBareMvmtService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1109Event")) {
				log.debug("EesCgm1109Event");
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMVMTHistoryListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = modifyMVMTHistoryService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchchssAtdtVerifyService(e);
				}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchchssTpszOnCntrCHkService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1015Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSAtdtStsService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
					eventResponse = manageCHSAtdtManualService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2016Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSAtdtStsService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
					eventResponse = manageMGSAtdtManualService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2016DefaultService(e);
				}
			}  else if (e.getEventName().equalsIgnoreCase("EesCgm1141Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchPoolMvmtComparisonService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1141DefaultService(e);
				}
			}  else if (e.getEventName().equalsIgnoreCase("EesCgm1142Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchPoolMvmtComparisonDtlService(e);
				}
			}  else if (e.getEventName().equalsIgnoreCase("EesCgm1143Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchPoolExpenseTrendService(e);
				}  else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1143DefaultService(e);
				}
			}  else if (e.getEventName().equalsIgnoreCase("EesCgm1144Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchPoolMnrHistoryService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1144DefaultService(e);
				}
			}  else if (e.getEventName().equalsIgnoreCase("UbizownOPUSCgmMvmtEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = managePoolMovementService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = managePoolMnrInvoiceImport(e);
				}
			}  else if (e.getEventName().equalsIgnoreCase("EesCgm1145Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchPoolChsUseddaysFileStatusService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = importPoolChsUseddaysFileService(e);
				}
			}  else if (e.getEventName().equalsIgnoreCase("EesCgm1149Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchPoolChsFileImportErrorListService(e);
				}
			}  else if (e.getEventName().equalsIgnoreCase("EesCgm1150Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//retrieve
					eventResponse = searchShipChsMovementListService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2104Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMgsMovementListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2104DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2105Event")) {
				log.debug("EesCgm2105Event");
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSMovementHistoryService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2108Event")) {
				log.debug("EesCgm2108Event");
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSBareMvmtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
					eventResponse = verifyMGSBareMvmtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
					eventResponse = manageMGSBareMvmtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
					eventResponse = createMGSBareMvmtService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2109Event")) {
				log.debug("EesCgm2109Event");
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSTMVMTHistoryListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = modifyMGSTMVMTHistoryService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchmgstAtdtVerifyService(e);
				}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchmgstTpszOnCntrCHkService(e);
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
	 * [EES_CGM_1104] : [Retrieve] <br>
	 * Chassis Movement List Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChsMovementListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1104Event event = (EesCgm1104Event)e;
			ChassisMovementHistoryBC command = new ChassisMovementHistoryBCImpl();


			int iPage = event.getChsMvmtINVO().getIPage().equals("") ? 1 : Integer.parseInt(event.getChsMvmtINVO().getIPage());
			log.debug("event.getChsMvmtINVO().getPagerows()========="+event.getChsMvmtINVO().getPagerows());
			int pageRows = event.getChsMvmtINVO().getPagerows().equals("") ? 1000 : Integer.parseInt(event.getChsMvmtINVO().getPagerows());
			int startRowNo = pageRows * (iPage - 1) + 1;
			int endRowNo = pageRows * iPage;
			event.getChsMvmtINVO().setStrPage(String.valueOf(startRowNo));
			event.getChsMvmtINVO().setEndPage(String.valueOf(endRowNo));

			List<CHSMvmtMGTVO> list = command.searchCHSMovementListBasic(event.getChsMvmtINVO());
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
	 * [EES_CGM_1105] : [Retrieve] <br>
	 * Chassis Movement History information Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSMovementHistoryService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1105Event event = (EesCgm1105Event)e;
			ChassisMovementHistoryBC command = new ChassisMovementHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// Response
			CHSMvmtGroupVO list   = command.searchCHSMovementHistoryBasic(event.getCHSMvmtINVO());

			// ETC DATA setting

			eventResponse.setRsVoList((List<CHSMvmtHistoryMGTVO>)list.getChsmvmthistorymgtvo());
			eventResponse.setRsVoList((List<CHSMvmtHistoryMGTVO>)list.getChsmvmthistorymgtvo2());
			eventResponse.setRsVoList((List<CHSMvmtHistoryMGTVO>)list.getChsmvmthistorymgtvo3());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1108] : [Retrieve] <br>
	 * Retrieve Movement History information each condition <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSBareMvmtService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1108Event event = (EesCgm1108Event)e;
			ChassisMovementHistoryBC command = new ChassisMovementHistoryBCImpl();
			List<CHSMvmtBareMGTVO> list = command.searchCHSBareMvmtBasic(event.getCHSMvmtINVO());
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
	 * [EES_CGM_1108] : [Verify] <br>
	 * Verify for Bare movement creation  <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCHSBareMvmtService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1108Event event = (EesCgm1108Event)e;
			ChassisMovementHistoryBC command = new ChassisMovementHistoryBCImpl();
			List<CHSMvmtBareMGTVO> list = command.verifyCHSBareMvmtBasic(event.getChsMvmtBareMGTVOs());
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
	 * [EES_CGM_1108] : [SAVE] <br>
	 * Eq bare movement Inserting (movement inserting, at/dt handling eq master modification <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSBareMvmtService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1108Event event = (EesCgm1108Event)e;
		ChassisMovementHistoryBC command = new ChassisMovementHistoryBCImpl();
		ChassisMgsetOnOffhireBC            bc      = new ChassisMgsetOnOffhireBCImpl();
		ChassisMgsetAttachDetachHistoryBC  de      = new ChassisMgsetAttachDetachHistoryBCImpl();

		List<CHSMasterMGTVO>               cHSMasterMGTVOs   = new ArrayList<CHSMasterMGTVO>();
		CHSMasterMGTVO                     mp      = new CHSMasterMGTVO();
		List<CHSMovementHistoryMGTVO>      chassisMovementHistoryMGTVOs   = new ArrayList<CHSMovementHistoryMGTVO>();
		CHSMovementHistoryMGTVO            his     = null;

		CHSMvmtBareMGTVO[]       tmp     = null;


		try{
			begin();
			//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());
			command.manageCHSBareMvmtBasic( event.getChsMvmtBareMGTVOs() ,account);

			tmp = event.getChsMvmtBareMGTVOs();

			for(int i=0; i<tmp.length; i++){
				mp = new CHSMasterMGTVO();
				String locCd = "";
				// Insert modification value to Eq Master Movement information in case of called from different BC in CGM
				mp.setEqNo(tmp[i].getEqNo());
				mp.setChssMvmtDestYdCd(tmp[i].getDestYdCd());
				mp.setChssMvmtStsCd(tmp[i].getMvmtStsCd());
				mp.setChssMvmtDt(tmp[i].getMvmtDtDay()+" " + tmp[i].getMvmtDtHd());
				mp.setGateIoCd(tmp[i].getGateIoCd());
				mp.setAtchMgstNo(tmp[i].getMgstNo());
				mp.setCrntYdCd(tmp[i].getYdCd());
				if(tmp[i].getYdCd()  != null && !tmp[i].getYdCd().equals("")){
					locCd = tmp[i].getYdCd().substring(0,5);
				}
				mp.setCrntLocCd(locCd);
				mp.setUpdUsrId(account.getUsr_id());
				cHSMasterMGTVOs.add(mp);
				if(tmp[i].getIbflag().equals("D")){
					his = new CHSMovementHistoryMGTVO();
					his.setEqNo(tmp[i].getEqNo());
					his.setAtchYdCd(tmp[i].getYdCd());
					his.setAtchDt(tmp[i].getMvmtDtDay().trim()+ tmp[i].getMvmtDtHd().trim());
					his.setUpdUsrId(account.getUsr_id());
					his.setDtchInpTpCd("M");
					chassisMovementHistoryMGTVOs.add(his);
				}

			}

			// Insert modification value to Eq Master Movement information in case of called from different BC in CGM
			// Insert modification value to Eq Master Movement information in case of called from different BC in CGM
			for(int i=0; i<cHSMasterMGTVOs.size(); i++){
				bc.modifyCHSCgmEquipmentBasic(cHSMasterMGTVOs.get(i));
			}
			//bc.modifyCHSMasterByMvmtBasic(cHSMasterMGTVOs);

            if(chassisMovementHistoryMGTVOs.size()>0){
            	de.modifyCHSAtdtByRemoveBareMvmtBasic(chassisMovementHistoryMGTVOs);

            }
			commit();
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
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
	 * [EES_CGM_1108] : [SAVE] <br>
	 * Eq bare movement Inserting (movement inserting, at/dt handling eq master modification <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createCHSBareMvmtService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1108Event event = (EesCgm1108Event)e;

		ChassisMovementHistoryBC           command = new ChassisMovementHistoryBCImpl();
		ChassisMgsetOnOffhireBC            bc      = new ChassisMgsetOnOffhireBCImpl();
		ChassisMgsetAttachDetachHistoryBC  de      = new ChassisMgsetAttachDetachHistoryBCImpl();

		List<CHSMasterMGTVO>               cHSMasterMGTVOs   = new ArrayList<CHSMasterMGTVO>();
		CHSMasterMGTVO                     mp      = new CHSMasterMGTVO();

		List<CHSMovementHistoryMGTVO>  chassisMovementHistoryMGTVOs   = new ArrayList<CHSMovementHistoryMGTVO>();
		CHSMovementHistoryMGTVO        his     = null;
		CHSMvmtBareMGTVO[]       tmp     = null;


		try{
			begin();
			//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());

			// *Eq bare movement inserting
			command.createCHSBareMvmtBasic( event.getChsMvmtBareMGTVOs() ,account);

			tmp = event.getChsMvmtBareMGTVOs();

			for(int i=0; i<tmp.length; i++){
				mp = new CHSMasterMGTVO();
				String locCd = "";
				// Insert modification value to Eq Master Movement information in case of called from different BC in CGM
				mp.setEqNo(tmp[i].getEqNo());
				mp.setChssMvmtDestYdCd(tmp[i].getDestYdCd());
				mp.setChssMvmtStsCd(tmp[i].getMvmtStsCd());
				mp.setChssMvmtDt(tmp[i].getMvmtDtDay()+" " + tmp[i].getMvmtDtHd());
				mp.setGateIoCd(tmp[i].getGateIoCd());
				mp.setAtchMgstNo(tmp[i].getMgstNo());
				mp.setCrntYdCd(tmp[i].getYdCd());
				if(tmp[i].getYdCd()  != null && !tmp[i].getYdCd().equals("")){
					locCd = tmp[i].getYdCd().substring(0,5);
				}
				mp.setCrntLocCd(locCd);
				mp.setUpdUsrId(account.getUsr_id());
				cHSMasterMGTVOs.add(mp);

				//  Called in case of CHS Bare mvmt creation
				//  Detach handling Chassis that attach status
				his = new CHSMovementHistoryMGTVO();
				his.setEqNo(tmp[i].getEqNo());
				his.setDtchDt(tmp[i].getMvmtDtDay()+" " + tmp[i].getMvmtDtHd());
				his.setDtchYdCd(tmp[i].getYdCd());
				his.setUpdUsrId(account.getUsr_id());
				his.setDtchInpTpCd("M");
				chassisMovementHistoryMGTVOs.add(his);

			}

			// Insert modification value to Eq Master Movement information in case of called from different BC in CGM
			for(int i=0; i<cHSMasterMGTVOs.size(); i++){
				bc.modifyCHSCgmEquipmentBasic(cHSMasterMGTVOs.get(i));
			}
			//bc.modifyCHSMasterByMvmtBasic(cHSMasterMGTVOs);

      //  Called in case of CHS Bare mvmt creation
			//  Detach handling Chassis that attach statusmodifyCHSCgmEquipmentBasic
			de.detachCHSByBareMvmtBasic(chassisMovementHistoryMGTVOs);

//			bc.manageMnrFlagBasic ( mNRFlagMGTVO );

//			eventResponse.setETCData((Map<String,String>)responseData.get(WebKeys.ER_ETCDATA));
//			rollback();
			commit();

//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
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
	 * [EES_CGM_1015] : [Retrieve] <br>
	 * Retrieve Eq attach/detach History <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSAtdtStsService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1015Event event = (EesCgm1015Event)e;
			ChassisMgsetAttachDetachHistoryBC command = new ChassisMgsetAttachDetachHistoryBCImpl();
			List<CHSAtdtHistoryMGTVO> list = command.searchCHSAtdtStsBasic(event.getChsMgsAtdtHistroyMGTvo());
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
	 * [EES_CGM_1015] : [Save] <br>
	 * Chassis ,M.G.Set attach/detach Manual creation <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSAtdtManualService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1015Event event = (EesCgm1015Event)e;
		ChassisMgsetAttachDetachHistoryBC command = new ChassisMgsetAttachDetachHistoryBCImpl();


		try{
			begin();
			//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());
			command.manageCHSAtdtManualBasic( event.getChsMgsAtdtHistroyMGTvos() ,account);
//			rollback();
			commit();

//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
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
	 * [EES_CGM_2016] : [Retrieve] <br>
	 * Retrieve Eq attach/detach Status <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSAtdtStsService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2016Event event = (EesCgm2016Event)e;
			ChassisMgsetAttachDetachHistoryBC command = new ChassisMgsetAttachDetachHistoryBCImpl();
			List<MGSAtdtHistoryMGTVO> list = command.searchMGSAtdtStsBasic(event.getMGSAtdtHistoryMGTVO());
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
	 * [EES_CGM_2016] : [Save] <br>
	 * Chassis ,M.G.Set attach/detach Manual creation <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSAtdtManualService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2016Event event = (EesCgm2016Event)e;
		ChassisMgsetAttachDetachHistoryBC command = new ChassisMgsetAttachDetachHistoryBCImpl();


		try{
			begin();
			//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());
			command.manageMGSAtdtManualBasic( event.getMGSAtdtHistoryMGTVOs() ,account);

			command.modifyMGSCurrentLocationBasic(event.getMGSAtdtHistoryMGTVOs(), account);
			command.modifyMGSCurrentChassisBasic(event.getMGSAtdtHistoryMGTVOs(), account);
			// ETC DATA setting
//			eventResponse.setETCData((Map<String,String>)responseData.get(WebKeys.ER_ETCDATA));
//			rollback();
			commit();

//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
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
	 * [EES_CGM_1142] : [Retrieve] <br>
	 * Pool movement & Movement comparison, match/unmatch detail list Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolMvmtComparisonDtlService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1142Event event = (EesCgm1142Event)e;
			PoolChassisHistoryBC command = new PoolChassisHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<PoolMvmtCompareSmryMGTVO> list  = command.searchPoolMvmtCompareDtlBasic(event.getPoolMvmtINVO());

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
	 * [EES_CGM_1141] : [Retrieve] <br>
	 * Pool movement & Movement comparison, match/unmatch summary Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolMvmtComparisonService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1141Event event = (EesCgm1141Event)e;
			PoolChassisHistoryBC command = new PoolChassisHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			PoolMvmtGroupVO list   = command.searchPoolMvmtComparisonBasic(event.getPoolMvmtINVO());




			eventResponse.setRsVoList((List<PoolMvmtCompareSmryMGTVO>)list.getPoolmvmtcomparesmrymgtvo());
			eventResponse.setRsVoList((List<PoolMvmtCompareSmryMGTVO>)list.getPoolmvmtcomparesmrymgtvo2());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1143] : [Retrieve] <br>
	 * Retrieve Pool Expense by month. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolExpenseTrendService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1143Event event = (EesCgm1143Event)e;
			PoolChassisHistoryBC command = new PoolChassisHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<PoolExpenseTrendMGTVO> list  = command.searchPoolMvmtExpenseListBasic(event.getPoolMvmtINVO());

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
	 * [EES_CGM_1144] : [Retrieve] <br>
	 *  Retrieve Pool Chassis Mnr data. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolMnrHistoryService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1144Event event = (EesCgm1144Event)e;
			PoolChassisHistoryBC command = new PoolChassisHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			PoolMvmtGroupVO list  = command.searchPoolMnrHistoryBasic(event.getPoolMnrHistoryINVO());

			eventResponse.setRsVoList((List<PoolMnrHistoryMGTVO>)list.getPoolmnrhistorymgtvo());
			eventResponse.setRsVoList((List<PoolMnrHistoryMGTVO>)list.getPoolmnrhistorymgtvo2());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * EDI MQ : Data reception from CGM_CHSS_MVMT
	 *
	 * @param e
	 * @exception EventException
	 */
	private EventResponse managePoolMovementService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			UbizownOPUSCgmMvmtEvent mqEvent = null;
			mqEvent = (UbizownOPUSCgmMvmtEvent)e;
			PoolChassisHistoryBC command = new PoolChassisHistoryBCImpl();
			PoolMvmtHistoryMGTVO  poolMvmtHistoryMGTVO = new PoolMvmtHistoryMGTVO();
			String eaiRecMsg          = mqEvent.getFlatFile();
			log.debug("eaiRecMsg=="+ eaiRecMsg);
			
			String outstr = "";
			List<String> dtlVec = new ArrayList<String>();
	//		int lineDelimeterLen = 2;
			
			int headerEnd = eaiRecMsg.indexOf("{EQ_INFO",0);
			//String header = outstr.substring(0, headerEnd - lineDelimeterLen);
			
			int findIndex = headerEnd;
			int detailFirst = 0;

			while((detailFirst = eaiRecMsg.indexOf("CHSS_NO:",findIndex)) != -1){
				findIndex = eaiRecMsg.indexOf("}EQ_INFO",detailFirst);
				dtlVec.add(eaiRecMsg.substring(detailFirst,findIndex));
			}
			
			String poolChssCoCd   	= "";
			String chssNo          	= "";
			String mvmtDt          	= "";
			String chssTpszCd      	= "";
			String ydCd            	= "";
			String locNm           	= "";
			String cntrNo          	= "";
			String poolCoGateIoCd  	= "";
			String cntrTpszCd      	= "";
//			String orgCoCd         	= "";
			String chssPoolCd      	= "";
			String chssUseCoNm     	= "";
			String trKrNm     		= "";
			String mvmtStsNm     	= "";
			String actCd     		= "";
			String vndrNm			= "";

			// EQ_INFO List
			for(int i = 0;i < dtlVec.size();i++){
				outstr = (String)dtlVec.get(i);

				// column mapping str
				chssNo          = outstr.substring(outstr.indexOf("CHSS_NO:") + 8, outstr.indexOf("\n", outstr.indexOf("CHSS_NO:")));
				if(outstr.indexOf("CHSS_NO:")==-1){
					chssNo = "";
				}
	
				mvmtDt          = outstr.substring(outstr.indexOf("CHSS_MVMT_DT:") + 13, outstr.indexOf("\n", outstr.indexOf("CHSS_MVMT_DT:")));
				if(outstr.indexOf("CHSS_MVMT_DT:")==-1){
					mvmtDt = "";
				}
				chssTpszCd      = outstr.substring(outstr.indexOf("CHSS_TP_SZ:") + 11, outstr.indexOf("\n", outstr.indexOf("CHSS_TP_SZ:")));
				if(outstr.indexOf("CHSS_TP_SZ:")==-1){
					chssTpszCd = "";
				}
				ydCd            = outstr.substring(outstr.indexOf("YD_CD:") + 6, outstr.indexOf("\n", outstr.indexOf("YD_CD:")));
				if(outstr.indexOf("YD_CD:")==-1){
					ydCd = "";
				}
				locNm           = outstr.substring(outstr.indexOf("LOC_NM:") + 7, outstr.indexOf("\n", outstr.indexOf("LOC_NM:")));
				if(outstr.indexOf("LOC_NM:")==-1){
					locNm = "";
				}
				cntrNo          = outstr.substring(outstr.indexOf("CNTR_NO:") + 8, outstr.indexOf("\n", outstr.indexOf("CNTR_NO:")));
				if(outstr.indexOf("CNTR_NO:")==-1){
					cntrNo = "";
				}
				poolCoGateIoCd  = outstr.substring(outstr.indexOf("GATE_IO_CD:") + 11, outstr.indexOf("\n", outstr.indexOf("GATE_IO_CD:")));
				if(outstr.indexOf("GATE_IO_CD:")==-1){
					poolCoGateIoCd = "";
				}
				cntrTpszCd      = outstr.substring(outstr.indexOf("CNTR_TP_SZ:") + 11, outstr.indexOf("\n", outstr.indexOf("CNTR_TP_SZ:")));
				if(outstr.indexOf("CNTR_TP_SZ:")==-1){
					cntrTpszCd = "";
				}
				vndrNm         = outstr.substring(outstr.indexOf("VNDR_NM:") + 8, outstr.indexOf("\n", outstr.indexOf("VNDR_NM:")));
				if(outstr.indexOf("VNDR_NM:")==-1){
					vndrNm = "";
				}
				chssPoolCd      = outstr.substring(outstr.indexOf("POOL_CD:") + 8, outstr.indexOf("\n", outstr.indexOf("POOL_CD:")));
				if(outstr.indexOf("POOL_CD:")==-1){
					chssPoolCd = "";
				}
				chssUseCoNm     = outstr.substring(outstr.indexOf("USR_CO:") + 7, outstr.indexOf("\n", outstr.indexOf("USR_CO:")));
				if(outstr.indexOf("USR_CO:")==-1){
					chssUseCoNm = "";
				}
				if(outstr.indexOf("CHSS_OWNED_CO:") != -1){
					poolChssCoCd     = outstr.substring(outstr.indexOf("CHSS_OWNED_CO:") + 14, outstr.indexOf("\n", outstr.indexOf("CHSS_OWNED_CO:")));
				}
				log.debug("outstr.indexOf( )              =="+ outstr.indexOf("CHSS_OWNED_CO:"));
	
				if(poolChssCoCd == null){
					poolChssCoCd = "";
				}
	
				//==================2014.11.14  CGM_POOL_MVMT_HIS 	TRKR_NM TRUCKER:,MVMT_STS_NM STATUS:,ACT_CD ACTION: 추가됨 =======================//
				
				trKrNm     = outstr.substring(outstr.indexOf("TRUCKER:") + 8, outstr.indexOf("\n", outstr.indexOf("TRUCKER:")));
				
				if(outstr.indexOf("TRUCKER:")==-1){
					trKrNm = "";
				}
				
				mvmtStsNm     = outstr.substring(outstr.indexOf("STATUS:") + 7, outstr.indexOf("\n", outstr.indexOf("STATUS:")));
				
				if(outstr.indexOf("STATUS:")==-1){
					mvmtStsNm = "";
				}
	
				actCd     = outstr.substring(outstr.indexOf("ACTION:") + 7, outstr.indexOf("\n", outstr.indexOf("ACTION:")));
				
				if(outstr.indexOf("ACTION:")==-1){
					actCd = "";
				}
	

				//====================================================================================================================================//

				
				if(chssNo.equals("") ){
					if(!cntrNo.equals("") && (cntrNo.substring(3,4).equals("Z")||cntrNo.substring(3,4).equals("C")||cntrNo.substring(3,4).equals("P")||cntrNo.substring(3,4).equals("H")||cntrNo.substring(3,4).equals("R"))){
						chssNo = cntrNo;
						//log.debug("cntrNo=="+cntrNo.substring(3,4));
					}
	
				}
	
				// column mapping end
		//		log.debug("poolUsrCoCd=="+ poolChssCoCd.trim());
		//		log.debug("chssNo=="+ chssNo.trim());
				poolMvmtHistoryMGTVO.setChssNo(chssNo.trim());
				poolMvmtHistoryMGTVO.setMvmtDt(mvmtDt.trim());
				poolMvmtHistoryMGTVO.setChssTpszCd(chssTpszCd.trim());
				poolMvmtHistoryMGTVO.setYdCd(ydCd.trim());
				poolMvmtHistoryMGTVO.setLocNm(locNm.trim());
				poolMvmtHistoryMGTVO.setCntrNo(cntrNo.trim());
				poolMvmtHistoryMGTVO.setPoolCoGateIoCd(poolCoGateIoCd.trim());
				poolMvmtHistoryMGTVO.setCntrTpszCd(cntrTpszCd.trim());
			//	poolMvmtHistoryMGTVO.setOrgCoCd(orgCoCd.trim());
				poolMvmtHistoryMGTVO.setVndrNm(vndrNm.trim());
				
//				poolMvmtHistoryMGTVO.setPoolLocCd(poolLocCd.trim());
				poolMvmtHistoryMGTVO.setChssPoolCd(chssPoolCd.trim());
				
				poolMvmtHistoryMGTVO.setChssUseCoNm(chssUseCoNm.trim());
				poolMvmtHistoryMGTVO.setPoolChssCoCd(poolChssCoCd.trim());
				
				// 2014.11.14  CGM_POOL_MVMT_HIS 추가 컬럼.
				poolMvmtHistoryMGTVO.setTrkrNm(trKrNm.trim());
				poolMvmtHistoryMGTVO.setMvmtStsNm(mvmtStsNm.trim());
				poolMvmtHistoryMGTVO.setActCd(actCd.trim());
				
				
				
				// No action in case of no chassis or no mvmt 
				if(!chssNo.equals("") && !mvmtDt.equals("")){
					//log.debug("chssNo--------------------------------=="+ chssNo.trim());
					//log.debug("mvmtDt=="+ mvmtDt.trim());
					command.managePoolMovementBasic(poolMvmtHistoryMGTVO);
				}
			}

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Save detail by CGM POOL MNR REPAIR HISTORY entity 
	 *
	 * @param e
	 * @throws EventException
	 */
	private EventResponse managePoolMnrInvoiceImport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			UbizownOPUSCgmMvmtEvent mqEvent = null;
			mqEvent = (UbizownOPUSCgmMvmtEvent)e;
			PoolChassisHistoryBC command = new PoolChassisHistoryBCImpl();
			PoolMaintRprHisMGTVO  poolMaintRprHisMGTVO = new PoolMaintRprHisMGTVO();
			String outstr          = mqEvent.getFlatFile();
			String sHeader         = null;
			String sTmp            = null;
			String[] sHeaTmp       = null;
			String[] sPoolMaint    = null;
			sPoolMaint = outstr.split("\n");

			sTmp     = sPoolMaint[0].toString();
			sHeader = sPoolMaint[1].toString();
			sHeader = sHeader.replaceAll("\"", "");
			sHeaTmp = sHeader.split(",");
//			param.putAll(sHeaTmp);

			String sTmp2 ="";
//			log.debug("sHeader============="+sHeader);
			log.debug("sPoolMaint.length============="+sPoolMaint.length);
			StringBuffer tmp = new StringBuffer(sTmp2);
			for(int i=0;i<sHeaTmp.length;i++){
				tmp.append(sHeaTmp[i].toString().trim());
				tmp.append(":");
				tmp.append(i);
				tmp.append(",");
//				sTmp2 = sTmp2 + sHeaTmp[i].toString().trim() +":"+i +",";
			}
			
			sTmp2 = tmp.toString();
			
			String sChssNo           = "";
			String sChssPoolCd       = "";
			String sVndrNm           = "";
			String sInvNo            = "";
			String sChssCmpoNm       = "";

			String sChssLocNm        = "";
			String sDmgDesc          = "";
			String sRprDesc          = "";
			String sRprCmpoQty       = "";
			String sRprHrs           = "";

			String sRprInspTpDesc    = "";
			String sLbrCostAmt       = "";
			String sMtrlCostAmt      = "";
			String sCostTtlAmt       = "";
			String sInvCreDt         = "";

			String sRprRqstDt        = "";
			String sChssUseCoNm      = "";
			String sIssOfcNm         = "";
			String sChssOwnrCoNm     = "";
			String sRespbPtyNm       = "";

			String sSplCmpoTpCd      = "";
			String sSplCmpoQty       = "";
			String sVndrLocNm        = "";
			String sInvRefNo         = "";
			String sChssAsptNm       = "";

			String sTaxAmt           = "";
			String sRprCmplDt        = "";
			String sCntrNo           = "";


			String   sPoolMaintTmp   =  "";
			String   sPoolMaintChk   =  "";
			String   sPoolMaintSChk  =  "";
			String   sPoolMaintEChk  =  "";



			if(sTmp.indexOf("FLEXIVAN")>-1){
				sChssNo           = sTmp2.substring(sTmp2.indexOf("Equipment:")+10,sTmp2.indexOf(",", sTmp2.indexOf("Equipment:")));
				sChssPoolCd	      = sTmp2.substring(sTmp2.indexOf("Pool:")+5,sTmp2.indexOf(",", sTmp2.indexOf("Pool:")));
				sVndrNm  	      = sTmp2.substring(sTmp2.indexOf("Vendor:")+7,sTmp2.indexOf(",", sTmp2.indexOf("Vendor:")));
				sInvNo            = sTmp2.substring(sTmp2.indexOf("Invoice:")+8,sTmp2.indexOf(",", sTmp2.indexOf("Invoice:")));
				sChssCmpoNm       = sTmp2.substring(sTmp2.indexOf("Component:")+10,sTmp2.indexOf(",", sTmp2.indexOf("Component:")));

				sChssLocNm        = sTmp2.substring(sTmp2.indexOf("Location:")+9,sTmp2.indexOf(",", sTmp2.indexOf("Location:")));
				sDmgDesc          = sTmp2.substring(sTmp2.indexOf("Damage:")+7,sTmp2.indexOf(",", sTmp2.indexOf("Damage:")));
				sRprDesc          = sTmp2.substring(sTmp2.indexOf("Repair:")+7,sTmp2.indexOf(",", sTmp2.indexOf("Repair:")));
				sRprCmpoQty       = sTmp2.substring(sTmp2.indexOf("Quantity:")+9,sTmp2.indexOf(",", sTmp2.indexOf("Quantity:")));
				sRprHrs           = sTmp2.substring(sTmp2.indexOf("Hours:")+6,sTmp2.indexOf(",", sTmp2.indexOf("Hours:")));

				sRprInspTpDesc    = sTmp2.substring(sTmp2.indexOf("Repair Type:")+12,sTmp2.indexOf(",", sTmp2.indexOf("Repair Type:")));
				sLbrCostAmt       = sTmp2.substring(sTmp2.indexOf("Labor:")+6,sTmp2.indexOf(",", sTmp2.indexOf("Labor:")));
				sMtrlCostAmt      = sTmp2.substring(sTmp2.indexOf("Material:")+9,sTmp2.indexOf(",", sTmp2.indexOf("Material:")));
				sCostTtlAmt       = sTmp2.substring(sTmp2.indexOf("Total:")+6,sTmp2.indexOf(",", sTmp2.indexOf("Total:")));
				sInvCreDt         = sTmp2.substring(sTmp2.indexOf("Invoice Date:")+13,sTmp2.indexOf(",", sTmp2.indexOf("Invoice Date:")));

				sRprRqstDt        = sTmp2.substring(sTmp2.indexOf("Repair Req Dt:")+14,sTmp2.indexOf(",", sTmp2.indexOf("Repair Req Dt:")));
				sChssUseCoNm      = sTmp2.substring(sTmp2.indexOf("User:")+5,sTmp2.indexOf(",", sTmp2.indexOf("User:")));
				sIssOfcNm         = sTmp2.substring(sTmp2.indexOf("FV-Office:")+10,sTmp2.indexOf(",", sTmp2.indexOf("FV-Office:")));
				sChssOwnrCoNm     = sTmp2.substring(sTmp2.indexOf("Owner:")+6,sTmp2.indexOf(",", sTmp2.indexOf("Owner:")));
				sRespbPtyNm       = sTmp2.substring(sTmp2.indexOf("Responsible Party:")+18,sTmp2.indexOf(",", sTmp2.indexOf("Responsible Party:")));

				sSplCmpoTpCd      = sTmp2.substring(sTmp2.indexOf("Supplied CompType:")+18,sTmp2.indexOf(",", sTmp2.indexOf("Supplied CompType:")));
				sSplCmpoQty       = sTmp2.substring(sTmp2.indexOf("Supplied Component:")+19,sTmp2.indexOf(",", sTmp2.indexOf("Supplied Component:")));
			}

			if(sTmp.indexOf("SEACASTLE")>-1){
				sChssNo           = sTmp2.substring(sTmp2.indexOf("Chassis Id:")+11,sTmp2.indexOf(",", sTmp2.indexOf("Chassis Id:")));
				sVndrNm  	      = sTmp2.substring(sTmp2.indexOf("Vendor Name:")+12,sTmp2.indexOf(",", sTmp2.indexOf("Vendor Name:")));
				sVndrLocNm        = sTmp2.substring(sTmp2.indexOf("Vendor Location:")+16,sTmp2.indexOf(",", sTmp2.indexOf("Vendor Location:")));
				sInvRefNo         = sTmp2.substring(sTmp2.indexOf("Reference #:")+12,sTmp2.indexOf(",", sTmp2.indexOf("Reference #:")));
				sInvNo            = sTmp2.substring(sTmp2.indexOf("Voucher #:")+10,sTmp2.indexOf(",", sTmp2.indexOf("Voucher #:")));

				sChssAsptNm       = sTmp2.substring(sTmp2.indexOf("Aspect:")+7,sTmp2.indexOf(",", sTmp2.indexOf("Aspect:")));
				sChssCmpoNm       = sTmp2.substring(sTmp2.indexOf("Component:")+10,sTmp2.indexOf(",", sTmp2.indexOf("Component:")));
				sChssLocNm        = sTmp2.substring(sTmp2.indexOf("Location on Chassis:")+20,sTmp2.indexOf(",", sTmp2.indexOf("Location on Chassis:")));
				sDmgDesc          = sTmp2.substring(sTmp2.indexOf("Damage:")+7,sTmp2.indexOf(",", sTmp2.indexOf("Damage:")));
				sRprDesc          = sTmp2.substring(sTmp2.indexOf("Repair:")+7,sTmp2.indexOf(",", sTmp2.indexOf("Repair:")));

				sLbrCostAmt       = sTmp2.substring(sTmp2.indexOf("Labor Cost:")+11,sTmp2.indexOf(",", sTmp2.indexOf("Labor Cost")));
				sMtrlCostAmt      = sTmp2.substring(sTmp2.indexOf("Material Cost:")+14,sTmp2.indexOf(",", sTmp2.indexOf("Material Cost:")));
				sTaxAmt           = sTmp2.substring(sTmp2.indexOf("Tax Amount:")+11,sTmp2.indexOf(",", sTmp2.indexOf("Tax Amount:")));
				sCostTtlAmt       = sTmp2.substring(sTmp2.indexOf("Detail Total:")+13,sTmp2.indexOf(",", sTmp2.indexOf("Detail Total")));
				sInvCreDt         = sTmp2.substring(sTmp2.indexOf("Voucher Date:")+13,sTmp2.indexOf(",", sTmp2.indexOf("Voucher Date:")));

				sRprRqstDt        = sTmp2.substring(sTmp2.indexOf("Reference Date:")+15,sTmp2.indexOf(",", sTmp2.indexOf("Reference Date:")));
				sRprCmplDt        = sTmp2.substring(sTmp2.indexOf("Repair Completion Date:")+23,sTmp2.indexOf(",", sTmp2.indexOf("Repair Completion Date:")));
				sCntrNo           = sTmp2.substring(sTmp2.indexOf("Container Id:")+13,sTmp2.indexOf(",", sTmp2.indexOf("Container Id:")));
				sChssOwnrCoNm     = sTmp2.substring(sTmp2.indexOf("Contributor:")+12,sTmp2.indexOf(",", sTmp2.indexOf("Contributor:")));


			}
			log.debug("sPoolMaintTmp1111111111=========="+sPoolMaint.length);
			for(int j=2;j<sPoolMaint.length;j++){
				sPoolMaintTmp  = sPoolMaint[j].toString().trim();

				// \" logic for switching comma
				while(sPoolMaintTmp.indexOf("\"")!=-1){
					sPoolMaintChk  = sPoolMaintTmp.substring(0,sPoolMaintTmp.indexOf("\"") );
					sPoolMaintTmp  = sPoolMaintTmp.substring(sPoolMaintTmp.indexOf("\"")+1  ,sPoolMaintTmp.length());
					sPoolMaintSChk = sPoolMaintTmp.substring(0 ,sPoolMaintTmp.indexOf("\""));

					sPoolMaintSChk = sPoolMaintSChk.replaceAll(",", "@");
					sPoolMaintSChk = sPoolMaintSChk.replaceAll("\"", "");
					sPoolMaintTmp  = sPoolMaintTmp.substring(sPoolMaintTmp.indexOf("\"")  ,sPoolMaintTmp.length());
					sPoolMaintEChk = sPoolMaintTmp.substring(sPoolMaintTmp.indexOf("\"") +1 ,sPoolMaintTmp.length());
					sPoolMaintTmp  = "";
					sPoolMaintTmp  = sPoolMaintChk + sPoolMaintSChk + sPoolMaintEChk;
				}


				log.debug("sPoolMaintTmp11end====="+j+"===="+ sPoolMaintTmp);
				String[] sPoolMaintTmps = sPoolMaintTmp.split(",");
				log.debug("sPoolMaintTmp11end============="+sPoolMaintTmps.length+"|");

				poolMaintRprHisMGTVO    = new PoolMaintRprHisMGTVO();
				if(sTmp.indexOf("FLEXIVAN")>-1){
					poolMaintRprHisMGTVO.setChssNo(sPoolMaintTmps[Integer.parseInt(sChssNo)].toString().replaceAll("@", ",").trim());
					poolMaintRprHisMGTVO.setChssPoolCd(sPoolMaintTmps[Integer.parseInt(sChssPoolCd)].toString().replaceAll("@", ",").trim()  );
					poolMaintRprHisMGTVO.setVndrNm(sPoolMaintTmps[Integer.parseInt(sVndrNm)].toString().replaceAll("@", ",").trim() );
					poolMaintRprHisMGTVO.setInvNo(sPoolMaintTmps[Integer.parseInt(sInvNo)].toString().replaceAll("@", ",").trim() );
					poolMaintRprHisMGTVO.setChssCmpoNm(sPoolMaintTmps[Integer.parseInt(sChssCmpoNm)].toString().replaceAll("@", ",").trim() );

					poolMaintRprHisMGTVO.setChssLocNm(sPoolMaintTmps[Integer.parseInt(sChssLocNm)].toString().replaceAll("@", ",").trim() );
					poolMaintRprHisMGTVO.setDmgDesc(sPoolMaintTmps[Integer.parseInt(sDmgDesc)].toString().replaceAll("@", ",").trim());
					poolMaintRprHisMGTVO.setRprDesc(sPoolMaintTmps[Integer.parseInt(sRprDesc)].toString().replaceAll("@", ",").trim());
					poolMaintRprHisMGTVO.setRprCmpoQty(sPoolMaintTmps[Integer.parseInt(sRprCmpoQty)].toString().replaceAll("@", ",").trim());
					poolMaintRprHisMGTVO.setRprHrs(sPoolMaintTmps[Integer.parseInt(sRprHrs)].toString().replaceAll("@", ",").trim());

					poolMaintRprHisMGTVO.setRprInspTpDesc(sPoolMaintTmps[Integer.parseInt(sRprInspTpDesc)].toString().replaceAll("@", ",").trim());
					poolMaintRprHisMGTVO.setLbrCostAmt(sPoolMaintTmps[Integer.parseInt(sLbrCostAmt)].toString().replaceAll("@", ",").trim());
					poolMaintRprHisMGTVO.setMtrlCostAmt(sPoolMaintTmps[Integer.parseInt(sMtrlCostAmt)].toString().replaceAll("@", ",").trim() );
					poolMaintRprHisMGTVO.setCostTtlAmt(sPoolMaintTmps[Integer.parseInt(sCostTtlAmt)].toString().replaceAll("@", ",").trim() );
					poolMaintRprHisMGTVO.setInvCreDt(sPoolMaintTmps[Integer.parseInt(sInvCreDt)].toString().replaceAll("@", ",").trim() );

					poolMaintRprHisMGTVO.setRprRqstDt(sPoolMaintTmps[Integer.parseInt(sRprRqstDt)].toString().replaceAll("@", ",").trim() );
					poolMaintRprHisMGTVO.setChssUseCoNm(sPoolMaintTmps[Integer.parseInt(sChssUseCoNm)].toString().replaceAll("@", ",").trim());
					poolMaintRprHisMGTVO.setIssOfcNm(sPoolMaintTmps[Integer.parseInt(sIssOfcNm)].toString().replaceAll("@", ",").trim());
					poolMaintRprHisMGTVO.setChssOwnrCoNm(sPoolMaintTmps[Integer.parseInt(sChssOwnrCoNm)].toString().replaceAll("@", ",").trim());
					poolMaintRprHisMGTVO.setRespbPtyNm(sPoolMaintTmps[Integer.parseInt(sRespbPtyNm)].toString().replaceAll("@", ",").trim());

					poolMaintRprHisMGTVO.setSplCmpoTpCd(sPoolMaintTmps[Integer.parseInt(sSplCmpoTpCd)].toString().replaceAll("@", ",").trim());
					poolMaintRprHisMGTVO.setSplCmpoQty(sPoolMaintTmps[Integer.parseInt(sSplCmpoQty)].toString().replaceAll("@", ",").trim());

					poolMaintRprHisMGTVO.setCreUsrId("FLEXIVAN");
					poolMaintRprHisMGTVO.setUpdUsrId("FLEXIVAN");
					log.debug("sPoolMaint.j============="+j);
					command.managePoolMnrInvoiceImportBasic(poolMaintRprHisMGTVO);
//					commit();
				}
				if( sPoolMaintTmps.length>0){
					if(sTmp.indexOf("SEACASTLE")>-1){
						poolMaintRprHisMGTVO.setChssNo(sPoolMaintTmps[Integer.parseInt(sChssNo)].toString().replaceAll("@", ",").trim());
						poolMaintRprHisMGTVO.setVndrNm(sPoolMaintTmps[Integer.parseInt(sVndrNm)].toString().replaceAll("@", ",").trim()  );
						poolMaintRprHisMGTVO.setVndrLocNm(sPoolMaintTmps[Integer.parseInt(sVndrLocNm)].toString().replaceAll("@", ",").trim() );
						poolMaintRprHisMGTVO.setInvRefNo(sPoolMaintTmps[Integer.parseInt(sInvRefNo)].toString().replaceAll("@", ",").trim() );
						poolMaintRprHisMGTVO.setInvNo(sPoolMaintTmps[Integer.parseInt(sInvNo)].toString().replaceAll("@", ",").trim() );

						poolMaintRprHisMGTVO.setChssAsptNm(sPoolMaintTmps[Integer.parseInt(sChssAsptNm)].toString().replaceAll("@", ",").trim() );
						poolMaintRprHisMGTVO.setChssCmpoNm(sPoolMaintTmps[Integer.parseInt(sChssCmpoNm)].toString().replaceAll("@", ",").trim());
						poolMaintRprHisMGTVO.setChssLocNm(sPoolMaintTmps[Integer.parseInt(sChssLocNm)].toString().replaceAll("@", ",").trim());
						poolMaintRprHisMGTVO.setDmgDesc(sPoolMaintTmps[Integer.parseInt(sDmgDesc)].toString().replaceAll("@", ",").trim());
						poolMaintRprHisMGTVO.setRprDesc(sPoolMaintTmps[Integer.parseInt(sRprDesc)].toString().replaceAll("@", ",").trim());

						poolMaintRprHisMGTVO.setLbrCostAmt(sPoolMaintTmps[Integer.parseInt(sLbrCostAmt)].toString().replaceAll("@", ",").trim());
						poolMaintRprHisMGTVO.setMtrlCostAmt(sPoolMaintTmps[Integer.parseInt(sMtrlCostAmt)].toString().replaceAll("@", ",").trim());
						poolMaintRprHisMGTVO.setTaxAmt(sPoolMaintTmps[Integer.parseInt(sTaxAmt)].toString().replaceAll("@", ",").trim() );
						poolMaintRprHisMGTVO.setCostTtlAmt(sPoolMaintTmps[Integer.parseInt(sCostTtlAmt)].toString().replaceAll("@", ",").trim() );
						poolMaintRprHisMGTVO.setInvCreDt(sPoolMaintTmps[Integer.parseInt(sInvCreDt)].toString().replaceAll("@", ",").trim() );

						poolMaintRprHisMGTVO.setRprRqstDt(sPoolMaintTmps[Integer.parseInt(sRprRqstDt)].toString().replaceAll("@", ",").trim() );
						poolMaintRprHisMGTVO.setRprCmplDt(sPoolMaintTmps[Integer.parseInt(sRprCmplDt)].toString().replaceAll("@", ",").trim());
						poolMaintRprHisMGTVO.setCntrNo(sPoolMaintTmps[Integer.parseInt(sCntrNo)].toString().replaceAll("@", ",").trim());
						poolMaintRprHisMGTVO.setChssOwnrCoNm(sPoolMaintTmps[Integer.parseInt(sChssOwnrCoNm)].toString().replaceAll("@", ",").trim());


						poolMaintRprHisMGTVO.setCreUsrId("SEACASTLE");
						poolMaintRprHisMGTVO.setUpdUsrId("SEACASTLE");
						log.debug("sPoolMaint.SEACASTLE.j============="+j);
						if(poolMaintRprHisMGTVO.getChssNo() != null && !poolMaintRprHisMGTVO.getChssNo().trim().equals("")){
							command.managePoolMnrInvoiceImportBasic(poolMaintRprHisMGTVO);
//							commit();
						}

					}
				}


			}
			//command.managePoolMnrInvoiceImportBasic(poolMaintRprHisMGTVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_1104] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1104DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// eq_tpsz_cd
			cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01940");
			List<ComboMGTVO> list2 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list2);

			// chss_pool_cd
			cParam1 = new ComboINVO();
			cParam1.setEqKndCd("Z");
			List<ComboMGTVO> list3 = command.searchPoolListBasic(cParam1);
			eventResponse.setRsVoList(list3);

			// MVMT Status
			ComboINVO cParam4 = new ComboINVO();
			List<ComboMGTVO> list4 = command.searchMovementStatusListBasic(cParam4);
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
	 * [EES_CGM_1141] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1141DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// chss_pool_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setEqKndCd("Z");
			List<ComboMGTVO> list3 = command.searchPoolListBasic(cParam1);
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
	 * [EES_CGM_1143] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1143DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// chss_pool_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setEqKndCd("Z");
			List<ComboMGTVO> list3 = command.searchPoolListBasic(cParam1);
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
	 * [EES_CGM_1144] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1144DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// chss_pool_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setEqKndCd("Z");
			List<ComboMGTVO> list3 = command.searchPoolListBasic(cParam1);
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
	 * [EES_CGM_1109] : [Retrieve] <br>
	 * Retrieve Movement History information each condition <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse  searchMVMTHistoryListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1109Event event = (EesCgm1109Event)e;
			ChassisMovementHistoryBC command = new ChassisMovementHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			List<MVMTBookingInfoVO> list1 = command.searchBookingInfoList(event.getCtmMovementVO(), account);
			List<MVMTHistoryListVO> list2 = command.searchMVMTHistoryList(event.getMVMTHistoryListVO());

			eventResponse.setRsVoList(list2);
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
	 * [EES_CGM_1109] : [Retrieve] <br>
	 * Retrieve Movement History information each condition <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse  searchchssAtdtVerifyService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1109Event event = (EesCgm1109Event)e;
			ChassisMovementHistoryBC command = new ChassisMovementHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<CHSmgstChkINVO> list =  command.searchchssAtdtVerifyBasic(event.getCHSmgstChkINVO());

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
	 * [EES_CGM_1109] : [Retrieve] <br>
	 * Retrieve Movement History information each condition <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse  searchchssTpszOnCntrCHkService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1109Event event = (EesCgm1109Event)e;
			ChassisMovementHistoryBC command = new ChassisMovementHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<CHSmgstChkINVO> list =  command.searchchssTpszOnCntrCHkBasic(event.getCHSmgstChkINVO());

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
	 * [EES_CGM_1109] : [SAVE] <br>
	 * Movement History information SAVE each condition<br>)
	 *
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 * @throws Exception
	 * @throws DAOException
	 */
	private EventResponse modifyMVMTHistoryService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EesCgm1109Event event = (EesCgm1109Event)e;
			ChassisMovementHistoryBC command = new ChassisMovementHistoryBCImpl();
			ContainerMovementMgtBC   ctm     = new ContainerMovementMgtBCImpl();


			CusCtmMovementVO[]       tmp     = null;
			List<CusCtmMovementVO>   cusCtmMovementVOs   = new ArrayList<CusCtmMovementVO>();


				begin();
				//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());

				tmp = event.getCusCtmMovementVOS();

				for(int i=0;i<tmp.length;i++){
					tmp[i].setUpdUsrId(account.getUsr_id());

					cusCtmMovementVOs.add(tmp[i]);
				}
				command.manageCHSMovementByCtmBatchBasic( cusCtmMovementVOs  );


				for(int i=0;i<cusCtmMovementVOs.size();i++){
					ctm.modifyMovementFromCgmForCreXX(cusCtmMovementVOs.get(i));
				}



				commit();
	//			rollback();
	//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());

			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}


	/**
	 * [EES_CGM_1145] : [Retrieve] <br>
	 * Retrieve Pool Chassis USED DAYS File Import status. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolChsUseddaysFileStatusService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1145Event event = (EesCgm1145Event)e;
			PoolChassisHistoryBC command = new PoolChassisHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<PoolUseddysMGTVO> list  = command.searchPoolChsUseddaysFileStatusBasic(event.getPoolUseddysINVO());

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
	 * [EES_CGM_1145] : [SAVE] <br>
	 * Save Pool Chassis Used days information to DB <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse importPoolChsUseddaysFileService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		log.debug("importPoolChsUseddaysFileService============");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1145Event event = (EesCgm1145Event)e;
		PoolChassisHistoryBC command = new PoolChassisHistoryBCImpl();
		boolean chkRunning = false;
		PoolUseddysMGTVO[] pool = null;
		try{
			begin();
			//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());
			command.addPoolChsFileImportBasic(event.getPoolUseddysINVO(),event.getPoolUseddysMGTVOs(),account);
			commit();
			pool = event.getPoolUseddysMGTVOs();
			for ( int i=0; i<pool.length; i++ ) {

				log.debug("poolUseddysMGTVOs ===getIbflag======= " + pool[i].getIbflag());
				if ( pool[i].getIbflag().equals("I")){
					chkRunning = true;
				}
			}
			log.debug("poolUseddysMGTVOs ===getIbflag======= " + chkRunning);
			if(chkRunning == true){
				String strStatus = command.getPoolChsUseHistoryImport(event.getPoolUseddysINVO(),event.getPoolUseddysMGTVOs(),account );

				//Direct action Batch module
				eventResponse.setETCData("BatchStatus", strStatus);
			}

//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
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
	 * [EES_CGM_1149] : [Retrieve] <br>
	 * Retrieve Pool Chassis USED DAYS File Import error. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolChsFileImportErrorListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1149Event event = (EesCgm1149Event)e;
			PoolChassisHistoryBC command = new PoolChassisHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<PoolUseddysMGTVO> list  = command.searchPoolChsFileImportErrorListBasic(event.getPoolUseddysMGTVO());

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
	 * EES_CGM_1150 : Retrieve <br>
	 * Retrieve Shipper's Chassis의 Movement management condition <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchShipChsMovementListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1150Event event = (EesCgm1150Event)e;
		ChassisMovementHistoryBC command = new ChassisMovementHistoryBCImpl();

		try {
			List<ShipCHSMvmtMGTVO> list  = command.searchShipChsMovementListBasic(event.getShipCHSMvmtMGTVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * [EES_CGM_2104] : [Retrieve] <br>
	 * Mgset Movement List Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMgsMovementListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2104Event event = (EesCgm2104Event)e;
			MgsetMovementHistoryBC command = new MgsetMovementHistoryBCImpl();


			int iPage = event.getMgsMvmtINVO().getIPage().equals("") ? 1 : Integer.parseInt(event.getMgsMvmtINVO().getIPage());
			log.debug("event.getChsMvmtINVO().getPagerows()========="+event.getMgsMvmtINVO().getPagerows());
			int pageRows = event.getMgsMvmtINVO().getPagerows().equals("") ? 1000 : Integer.parseInt(event.getMgsMvmtINVO().getPagerows());
			int startRowNo = pageRows * (iPage - 1) + 1;
			int endRowNo = pageRows * iPage;
			event.getMgsMvmtINVO().setStrPage(String.valueOf(startRowNo));
			event.getMgsMvmtINVO().setEndPage(String.valueOf(endRowNo));

			List<MGSMvmtMGTVO> list = command.searchMGSMovementListBasic(event.getMgsMvmtINVO());
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
	 * [EES_CGM_2104] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2104DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			// eq_tpsz_cd
			cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01940");
			List<ComboMGTVO> list2 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list2);

			// MVMT Status
			ComboINVO cParam4 = new ComboINVO();
			List<ComboMGTVO> list4 = command.searchMovementStatusListBasic(cParam4);
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
	 * [EES_CGM_2105] : [Retrieve] <br>
	 * Mgset Movement History information Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSMovementHistoryService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2105Event event = (EesCgm2105Event)e;
			MgsetMovementHistoryBC command = new MgsetMovementHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// Response
			MGSMvmtGroupVO list   = command.searchMGSMovementHistoryBasic(event.getMGSMvmtINVO());

			// ETC DATA setting

			eventResponse.setRsVoList((List<MGSMvmtHistoryMGTVO>)list.getMgsmvmthistorymgtvo());
			eventResponse.setRsVoList((List<MGSMvmtHistoryMGTVO>)list.getMgsmvmthistorymgtvo2());
			eventResponse.setRsVoList((List<MGSMvmtHistoryMGTVO>)list.getMgsmvmthistorymgtvo3());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_2108] : [Retrieve] <br>
	 * Retrieve Movement History information each condition <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSBareMvmtService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2108Event event = (EesCgm2108Event)e;
			MgsetMovementHistoryBC command = new MgsetMovementHistoryBCImpl();
			List<MGSMvmtBareMGTVO> list = command.searchMGSBareMvmtBasic(event.getMGSMvmtINVO());
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
	 * [EES_CGM_2108] : [Verify] <br>
	 * Verify for Bare movement creation  <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyMGSBareMvmtService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2108Event event = (EesCgm2108Event)e;
			MgsetMovementHistoryBC command = new MgsetMovementHistoryBCImpl();
			List<MGSMvmtBareMGTVO> list = command.verifyMGSBareMvmtBasic(event.getMgsMvmtBareMGTVOs());
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
	 * [EES_CGM_2108] : [SAVE] <br>
	 * Eq bare movement Inserting (movement inserting, at/dt handling eq master modification <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSBareMvmtService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2108Event event = (EesCgm2108Event)e;
		MgsetMovementHistoryBC command = new MgsetMovementHistoryBCImpl();
		ChassisMgsetOnOffhireBC            bc      = new ChassisMgsetOnOffhireBCImpl();
		ChassisMgsetAttachDetachHistoryBC  de      = new ChassisMgsetAttachDetachHistoryBCImpl();

		List<CHSMasterMGTVO>               cHSMasterMGTVOs   = new ArrayList<CHSMasterMGTVO>();
		CHSMasterMGTVO                     mp      = new CHSMasterMGTVO();
		List<CHSMovementHistoryMGTVO>      chassisMovementHistoryMGTVOs   = new ArrayList<CHSMovementHistoryMGTVO>();
		CHSMovementHistoryMGTVO            his     = null;

		MGSMvmtBareMGTVO[]       tmp     = null;


		try{
			begin();
			//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());
			command.manageMGSBareMvmtBasic( event.getMgsMvmtBareMGTVOs() ,account);

			tmp = event.getMgsMvmtBareMGTVOs();

			for(int i=0; i<tmp.length; i++){
				mp = new CHSMasterMGTVO();
				String locCd = "";
				// Insert modification value to Eq Master Movement information in case of called from different BC in CGM
				mp.setEqNo(tmp[i].getEqNo());
				mp.setChssMvmtDestYdCd(tmp[i].getDestYdCd());
				mp.setChssMvmtStsCd(tmp[i].getMvmtStsCd());
				mp.setChssMvmtDt(tmp[i].getMvmtDtDay()+" " + tmp[i].getMvmtDtHd());
				mp.setGateIoCd(tmp[i].getGateIoCd());
				mp.setAtchMgstNo(tmp[i].getMgstNo());
				mp.setCrntYdCd(tmp[i].getYdCd());
				if(tmp[i].getYdCd()  != null && !tmp[i].getYdCd().equals("")){
					locCd = tmp[i].getYdCd().substring(0,5);
				}
				mp.setCrntLocCd(locCd);
				mp.setUpdUsrId(account.getUsr_id());
				cHSMasterMGTVOs.add(mp);
				if(tmp[i].getIbflag().equals("D")){
					his = new CHSMovementHistoryMGTVO();
					his.setEqNo(tmp[i].getEqNo());
					his.setAtchYdCd(tmp[i].getYdCd());
					his.setAtchDt(tmp[i].getMvmtDtDay().trim()+ tmp[i].getMvmtDtHd().trim());
					his.setUpdUsrId(account.getUsr_id());
					his.setDtchInpTpCd("M");
					chassisMovementHistoryMGTVOs.add(his);
				}

			}

			// Insert modification value to Eq Master Movement information in case of called from different BC in CGM
			// Insert modification value to Eq Master Movement information in case of called from different BC in CGM
			for(int i=0; i<cHSMasterMGTVOs.size(); i++){
				bc.modifyMGSCgmEquipmentBasic(cHSMasterMGTVOs.get(i));
			}
			//bc.modifyCHSMasterByMvmtBasic(cHSMasterMGTVOs);

            if(chassisMovementHistoryMGTVOs.size()>0){
            	de.modifyCHSAtdtByRemoveBareMvmtBasic(chassisMovementHistoryMGTVOs);

            }
			commit();
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
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
	 * [EES_CGM_1108] : [SAVE] <br>
	 * Eq bare movement Inserting (movement inserting, at/dt handling eq master modification <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createMGSBareMvmtService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2108Event event = (EesCgm2108Event)e;

		MgsetMovementHistoryBC           command = new MgsetMovementHistoryBCImpl();
		ChassisMgsetOnOffhireBC            bc      = new ChassisMgsetOnOffhireBCImpl();
		ChassisMgsetAttachDetachHistoryBC  de      = new ChassisMgsetAttachDetachHistoryBCImpl();

		List<CHSMasterMGTVO>               cHSMasterMGTVOs   = new ArrayList<CHSMasterMGTVO>();
		CHSMasterMGTVO                     mp      = new CHSMasterMGTVO();

		List<MGSAtdtHistoryMGTVO>  mgsAtdtHistoryMGTVOs   = new ArrayList<MGSAtdtHistoryMGTVO>();
		MGSAtdtHistoryMGTVO        his     = null;
		MGSMvmtBareMGTVO[]       tmp     = null;


		try{
			begin();
			//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());

			// *Eq bare movement inserting
			command.createMGSBareMvmtBasic( event.getMgsMvmtBareMGTVOs() ,account);

			tmp = event.getMgsMvmtBareMGTVOs();

			for(int i=0; i<tmp.length; i++){
				mp = new CHSMasterMGTVO();
				String locCd = "";
				// Insert modification value to Eq Master Movement information in case of called from different BC in CGM
				mp.setEqNo(tmp[i].getEqNo());
				mp.setChssMvmtDestYdCd(tmp[i].getDestYdCd());
				mp.setChssMvmtStsCd(tmp[i].getMvmtStsCd());
				mp.setChssMvmtDt(tmp[i].getMvmtDtDay()+" " + tmp[i].getMvmtDtHd());
				mp.setGateIoCd(tmp[i].getGateIoCd());
				mp.setCrntYdCd(tmp[i].getYdCd());
				if(tmp[i].getYdCd()  != null && !tmp[i].getYdCd().equals("")){
					locCd = tmp[i].getYdCd().substring(0,5);
				}
				mp.setCrntLocCd(locCd);
				mp.setUpdUsrId(account.getUsr_id());
				cHSMasterMGTVOs.add(mp);

				//  Called in case of CHS Bare mvmt creation
				//  Detach handling Chassis that attach status
//				his = new CHSMovementHistoryMGTVO();
//				his.setEqNo(tmp[i].getEqNo());
//				his.setDtchDt(tmp[i].getMvmtDtDay()+" " + tmp[i].getMvmtDtHd());
//				his.setDtchYdCd(tmp[i].getYdCd());
//				his.setUpdUsrId(account.getUsr_id());
//				his.setDtchInpTpCd("M");
//				chassisMovementHistoryMGTVOs.add(his);
				
				his = new MGSAtdtHistoryMGTVO();
				his.setEqNo(tmp[i].getEqNo());
				his.setAt("AT");
				his.setAtchDt(tmp[i].getMvmtDtDay()+" " + tmp[i].getMvmtDtHd());
				his.setCntrNo(tmp[i].getCntrNo());
				his.setChssNo(tmp[i].getChssNo());
				his.setAtchYdCd(tmp[i].getYdCd());
				his.setUpdUsrId(account.getUsr_id());
				his.setCreUsrId(account.getUsr_id());
				mgsAtdtHistoryMGTVOs.add(his);
			}

			// Insert modification value to Eq Master Movement information in case of called from different BC in CGM
			for(int i=0; i<cHSMasterMGTVOs.size(); i++){
				bc.modifyMGSCgmEquipmentBasic(cHSMasterMGTVOs.get(i));
			}
			//bc.modifyCHSMasterByMvmtBasic(cHSMasterMGTVOs);
			for(int i=0;i < mgsAtdtHistoryMGTVOs.size(); i++){
				de.manageMGSAtdtByCtmBasic(mgsAtdtHistoryMGTVOs.get(i));
			}
			
      //  Called in case of CHS Bare mvmt creation
			//  Detach handling Chassis that attach statusmodifyCHSCgmEquipmentBasic
//			de.detachCHSByBareMvmtBasic(chassisMovementHistoryMGTVOs);

//			bc.manageMnrFlagBasic ( mNRFlagMGTVO );

//			eventResponse.setETCData((Map<String,String>)responseData.get(WebKeys.ER_ETCDATA));
//			rollback();
			commit();

//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
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
	 * [EES_CGM_2109] : [Retrieve] <br>
	 * Retrieve Movement History information each condition <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse  searchMGSTMVMTHistoryListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2109Event event = (EesCgm2109Event)e;
			MgsetMovementHistoryBC command = new MgsetMovementHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			List<MVMTBookingInfoVO> list1 = command.searchBookingInfoList(event.getCtmMovementVO(), account);
			List<MVMTHistoryListVO> list2 = command.searchMVMTHistoryList(event.getMVMTHistoryListVO());

			eventResponse.setRsVoList(list2);
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
	 * [EES_CGM_1109] : [SAVE] <br>
	 * Movement History information SAVE each condition<br>)
	 *
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 * @throws Exception
	 * @throws DAOException
	 */
	private EventResponse modifyMGSTMVMTHistoryService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EesCgm2109Event event = (EesCgm2109Event)e;
			MgsetMovementHistoryBC command = new MgsetMovementHistoryBCImpl();
			ContainerMovementMgtBC   ctm     = new ContainerMovementMgtBCImpl();


			CusCtmMovementVO[]       tmp     = null;
			List<CusCtmMovementVO>   cusCtmMovementVOs   = new ArrayList<CusCtmMovementVO>();


				begin();
				//log.debug("☆★☆ event.getMGSEquipmentINVOS() : " + event.getMGSEquipmentINVOS());

				tmp = event.getCusCtmMovementVOS();

				for(int i=0;i<tmp.length;i++){
					tmp[i].setUpdUsrId(account.getUsr_id());

					cusCtmMovementVOs.add(tmp[i]);
				}
				command.manageMGSMovementByCtmBatchBasic( cusCtmMovementVOs  );


				for(int i=0;i<cusCtmMovementVOs.size();i++){
					ctm.modifyMovementFromCgmForCreXX(cusCtmMovementVOs.get(i));
				}



				commit();
	//			rollback();
	//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());

			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_2109] : [Retrieve] <br>
	 * Retrieve Movement History information each condition <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse  searchmgstAtdtVerifyService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2109Event event = (EesCgm2109Event)e;
			MgsetMovementHistoryBC command = new MgsetMovementHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<MGSmgstChkINVO> list =  command.searchmgstAtdtVerifyBasic(event.getMGSmgstChkINVO());

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
	 * [EES_CGM_2109] : [Retrieve] <br>
	 * Retrieve Movement History information each condition <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse  searchmgstTpszOnCntrCHkService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2109Event event = (EesCgm2109Event)e;
			MgsetMovementHistoryBC command = new MgsetMovementHistoryBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<MGSmgstChkINVO> list =  command.searchmgstTpszOnCntrCHkBasic(event.getMGSmgstChkINVO());

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
	 * [EES_CGM_2016] : [Default] <br>
	 * Default Searvice.. Retrieve <br>)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2016DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Local Time
			String localTime = command.searchLocalTimeBasic(account.getOfc_cd());
			eventResponse.setETCData("Local_Time", localTime);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
}