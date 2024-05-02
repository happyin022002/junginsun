/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration.ChassisMgsetAttachDetachHistoryDBDAO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSMovementHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CNTRMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSCNTRMvmtMGTVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-MovementMnrHistory Business Logic Basic Command implementation<br>
 * - OPUS-MovementMnrHistory biz logic handling.<br>
 *
 * @author CHOI MIN HOI
 * @see sfdsEventResponse,ChassisMgsetAttachDetachHistoryBC each DAO class reference
 * @since J2EE 1.6
 */
public class ChassisMgsetAttachDetachHistoryBCImpl extends BasicCommandSupport implements ChassisMgsetAttachDetachHistoryBC {

	// Database Access Object
	private transient ChassisMgsetAttachDetachHistoryDBDAO dbDao = null;

	/**
	 * ChassisMgsetAttachDetachHistoryBCImpl objects creation<br>
	 * ChassisMgsetAttachDetachHistoryDBDAO creation.<br>
	 */
	public ChassisMgsetAttachDetachHistoryBCImpl() {
		dbDao = new ChassisMgsetAttachDetachHistoryDBDAO();
	}

	/**
	 *  Called in case of CHS Bare mvmt creation, Detach SAVE Chassis that attach status <br>
	 *
	 * @param cHSMovementHistoryMGTVOs List<CHSMovementHistoryMGTVO>
	 * @exception EventException
	 */
	public void detachCHSByBareMvmtBasic(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs)  throws EventException{
		try {
			dbDao.modifyCHSAtdtHistoryInBetweenData(cHSMovementHistoryMGTVOs);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * Retrieve Eq attach/detach Status  [EES_CGM_1015]<br>
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @return List<CHSAtdtHistoryMGTVO>
	 * @exception EventException
	 */
	public List<CHSAtdtHistoryMGTVO> searchCHSAtdtStsBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException{
		try {
			return dbDao.searchCHSAtdtStsData(cHSAtdtHistoryMGTVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * Chassis Attatch/Detach information save(History save)  [EES_CGM_1015]<br>
	 *
	 * @param cHSAtdtHistoryMGTVOs CHSAtdtHistoryMGTVO[]
     * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSAtdtManualBasic(CHSAtdtHistoryMGTVO[] cHSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException{
		// Map object for Response object
		@SuppressWarnings("unused")
		boolean chkPoolMatch = true;
		try {
			// Map object for ETC Data
			CHSAtdtHistoryMGTVO          tmp  = new CHSAtdtHistoryMGTVO();
			CHSMovementHistoryMGTVO  sTmp = new CHSMovementHistoryMGTVO();
			List<CHSMovementHistoryMGTVO> insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			List<CHSMovementHistoryMGTVO> updateVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			for ( int i=0; i<cHSAtdtHistoryMGTVOs.length; i++ ) {
				tmp = cHSAtdtHistoryMGTVOs[i];
				tmp.setUpdUsrId(account.getUsr_id());
				tmp.setCreUsrId(account.getUsr_id());
				if(tmp.getAt().equals("AT")){
					insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
					sTmp = new CHSMovementHistoryMGTVO();
					sTmp.setEqNo(tmp.getEqNo());
					sTmp.setAtchDt(tmp.getAtchDt());
					sTmp.setCntrNo(tmp.getCntrNo1());
					sTmp.setAtchYdCd(tmp.getAtchYdCd());
					sTmp.setUpdUsrId(account.getUsr_id());
					sTmp.setCreUsrId(account.getUsr_id());
					log.debug("tmp.getCntrNo1()======"+tmp.getCntrNo1());
					log.debug("getCntrNo.getCntrNo()======"+sTmp.getCntrNo());
					insertVoList.add(sTmp);
					chkPoolMatch = dbDao.addCHSAtdtHistoryData(insertVoList);
					if(tmp.getCntrNo2()!=null && !tmp.getCntrNo2().equals("")){
						insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
						sTmp.setEqNo(tmp.getEqNo());
						sTmp.setAtchDt(tmp.getAtchDt());
						sTmp.setCntrNo(tmp.getCntrNo2());
						sTmp.setAtchYdCd(tmp.getAtchYdCd());
						sTmp.setUpdUsrId(account.getUsr_id());
						sTmp.setCreUsrId(account.getUsr_id());

						log.debug("tmp.getCntrNo2()======"+tmp.getCntrNo2());
						log.debug("getCntrNo.getCntrNo()======"+sTmp.getCntrNo());
						insertVoList.add(sTmp);
						chkPoolMatch = dbDao.addCHSAtdtHistoryData(insertVoList);
					}

				} else {
					updateVoList  =  new ArrayList<CHSMovementHistoryMGTVO>();
					sTmp = new CHSMovementHistoryMGTVO();
					sTmp.setEqNo(tmp.getEqNo());
					sTmp.setDtchDt(tmp.getDtchDt()); // modification
					sTmp.setDtchYdCd(tmp.getAtchYdCd());
					sTmp.setUpdUsrId(account.getUsr_id());
					updateVoList.add(sTmp);
					dbDao.modifyCHSAtdtHistoryInBetweenData(updateVoList);
				}
			}

//			etcData = CHSMvmtBareMGTVO.getColumnValues();

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * Retrieve Eq attach/detach Status. Retrieve.  [EES_CGM_2016]<br>
	 *
	 * @param mGSAtdtHistoryMGTVO MGSAtdtHistoryMGTVO
	 * @return List<MGSAtdtHistoryMGTVO>
	 * @exception EventException
	 */
	public List<MGSAtdtHistoryMGTVO> searchMGSAtdtStsBasic(MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO) throws EventException{
		try {
			return dbDao.searchMGSAtdtStsData(mGSAtdtHistoryMGTVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * Save Eq bare movement modificaton/deleting.  [EES_CGM_2016]<br>
	 *
	 * @param  mGSAtdtHistoryMGTVOs MGSAtdtHistoryMGTVO[]
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMGSAtdtManualBasic(MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException{
		@SuppressWarnings("unused")
		boolean chkPoolMatch = true;
		try {
			MGSAtdtHistoryMGTVO          tmp  = new MGSAtdtHistoryMGTVO();
			CHSMovementHistoryMGTVO  sTmp = new CHSMovementHistoryMGTVO();
			List<CHSMovementHistoryMGTVO> insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			List<CHSMovementHistoryMGTVO> updateVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			for ( int i=0; i<mGSAtdtHistoryMGTVOs.length; i++ ) {
				tmp = mGSAtdtHistoryMGTVOs[i];
				tmp.setUpdUsrId(account.getUsr_id());
				tmp.setCreUsrId(account.getUsr_id());
				if(tmp.getAt().equals("AT")){
					insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
					sTmp = new CHSMovementHistoryMGTVO();
					sTmp.setEqNo(tmp.getEqNo());
					sTmp.setAtchDt(tmp.getAtchDt());
					if(tmp.getEqTpszCd().equals("UMG")){
						sTmp.setChssNo(tmp.getCntrNo1());
					} else {
						sTmp.setCntrNo(tmp.getCntrNo1());
					}

					sTmp.setAtchYdCd(tmp.getAtchYdCd());
					sTmp.setUpdUsrId(account.getUsr_id());
					sTmp.setCreUsrId(account.getUsr_id());
					insertVoList.add(sTmp);
					chkPoolMatch = dbDao.addMGSAtdtHistoryData(insertVoList);
				} else {
					updateVoList  =  new ArrayList<CHSMovementHistoryMGTVO>();
					sTmp = new CHSMovementHistoryMGTVO();
					sTmp.setEqNo(tmp.getEqNo());
					sTmp.setDtchDt(tmp.getDtchDt()); // modification
					sTmp.setDtchYdCd(tmp.getAtchYdCd());
					sTmp.setUpdUsrId(account.getUsr_id());
					updateVoList.add(sTmp);
					dbDao.modifyMGSAtdtHistoryData(updateVoList);
				}
			}

//			etcData = CHSMvmtBareMGTVO.getColumnValues();

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * INVENTORY apply for MGS Current Location apply in case of MGS AT/DT History event.  [EES_CGM_2016]<br>
	 *
	 * @param  mGSAtdtHistoryMGTVOs MGSAtdtHistoryMGTVO[]
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyMGSCurrentLocationBasic(MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException {
		try {
			MGSAtdtHistoryMGTVO          tmp  = new MGSAtdtHistoryMGTVO();
			CHSMovementHistoryMGTVO  sTmp = new CHSMovementHistoryMGTVO();
			//List<CHSMovementHistoryMGTVO> insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			List<CHSMovementHistoryMGTVO> updateVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			for ( int i=0; i<mGSAtdtHistoryMGTVOs.length; i++ ) {
				tmp = mGSAtdtHistoryMGTVOs[i];
				tmp.setUpdUsrId(account.getUsr_id());

				updateVoList  =  new ArrayList<CHSMovementHistoryMGTVO>();
				sTmp = new CHSMovementHistoryMGTVO();
				sTmp.setEqNo(tmp.getEqNo());
				sTmp.setUpdUsrId(account.getUsr_id());
				updateVoList.add(sTmp);
				dbDao.modifyMGSCurrentLocationData(updateVoList);

			}

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * INVENTORY apply for MGS Current History apply in case of MGS AT/DT History event.  [EES_CGM_2016]<br>
	 *
	 * @param  mGSAtdtHistoryMGTVOs MGSAtdtHistoryMGTVO[]
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyMGSCurrentChassisBasic(MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException {
		try {
			MGSAtdtHistoryMGTVO          tmp  = new MGSAtdtHistoryMGTVO();
			CHSMovementHistoryMGTVO  sTmp = new CHSMovementHistoryMGTVO();
			//List<CHSMovementHistoryMGTVO> insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			List<CHSMovementHistoryMGTVO> updateVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			for ( int i=0; i<mGSAtdtHistoryMGTVOs.length; i++ ) {
				tmp = mGSAtdtHistoryMGTVOs[i];
				tmp.setUpdUsrId(account.getUsr_id());

				if(tmp.getEqTpszCd().equals("UMG")){
					updateVoList  =  new ArrayList<CHSMovementHistoryMGTVO>();
					sTmp = new CHSMovementHistoryMGTVO();
					sTmp.setEqNo(tmp.getEqNo());
					sTmp.setUpdUsrId(account.getUsr_id());
					updateVoList.add(sTmp);
					dbDao.modifyMGSCurrentChassisData(updateVoList);
				}
			}

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}


	/**
	 * Action DT by CHS in case of MVMT create   [EES_CGM_1109]<br>
	 *
	 * @param cNTRMvmtMGTVO CNTRMvmtMGTVO
	 * @exception EventException
	 */
	public void manageCHSDetachByChssBasic(CNTRMvmtMGTVO  cNTRMvmtMGTVO) throws EventException
	{
		// Map object for Response object
		try {
			dbDao.modifyCHSDetachByChssData(cNTRMvmtMGTVO);
			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}



	/**
	 * EQ Attatch/Detach information save(History save)  [EES_CGM_1109]<br>
	 *
	 * @param cHSAtdtHistoryMGTVOs List<CHSAtdtHistoryMGTVO>
	 * @exception EventException
	 */
	public void manageCHSAtdtByMvmtBasic(List<CHSAtdtHistoryMGTVO>  cHSAtdtHistoryMGTVOs) throws EventException{
		// Map object for Response object
		try {
			// Map object for ETC Data
			CHSAtdtHistoryMGTVO          tmp  = new CHSAtdtHistoryMGTVO();
			CHSMovementHistoryMGTVO  sTmp = new CHSMovementHistoryMGTVO();
			List<CHSMovementHistoryMGTVO> insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			List<CHSMovementHistoryMGTVO> deldateVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			for ( int i=0; i<cHSAtdtHistoryMGTVOs.size(); i++ ) {
				tmp = cHSAtdtHistoryMGTVOs.get(i);
				if(tmp.getIbflag().equals("I")){
					sTmp = new CHSMovementHistoryMGTVO();
					sTmp.setEqNo(tmp.getEqNo());
					sTmp.setAtchDt(tmp.getAtchDt());
					sTmp.setCntrNo(tmp.getCntrNo());
					sTmp.setChssNo(tmp.getChssNo());
					sTmp.setEqKndCd(tmp.getEqKndCd());
					sTmp.setAtchYdCd(tmp.getAtchYdCd());
					sTmp.setAtchCnmvIdNo(tmp.getAtchCnmvIdNo());
					sTmp.setAtchCnmvYr(tmp.getAtchCnmvYr());
					sTmp.setUpdUsrId(tmp.getUpdUsrId());
					sTmp.setCreUsrId(tmp.getCreUsrId());
					insertVoList.add(sTmp);
				} else {
					sTmp = new CHSMovementHistoryMGTVO();
					sTmp.setEqNo(tmp.getEqNo());
					sTmp.setAtchDt(tmp.getAtchDt());
					sTmp.setDtchDt(tmp.getDtchDt()); // modification
					sTmp.setDtchYdCd(tmp.getYdCd());
					sTmp.setEqKndCd(tmp.getEqKndCd());
					deldateVoList.add(sTmp);
				}
			}

			if(deldateVoList.size()>0){
				dbDao.removeCHSAtdtByMvmtData(deldateVoList);
			}

			if(insertVoList.size()>0){
				dbDao.addCHSAtdtByMvmtData(insertVoList);
			}

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}


	/**
	 * Handling Chassis, M.G.Set Attach/Detach list by recieve  322 Movement data from CTM  [ChassisMovementHistoryBCImpl call]<br>
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @exception EventException
	 */
	public void manageCHSAtdtByCtmBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException{
		// Map object for Response object
		try {
			// Map object for ETC Data
			CHSMovementHistoryMGTVO  sTmp = new CHSMovementHistoryMGTVO();
			List<CHSMovementHistoryMGTVO> insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			List<CHSMovementHistoryMGTVO> updateVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			if(cHSAtdtHistoryMGTVO.getAt().equals("AT")){
				insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
				sTmp = new CHSMovementHistoryMGTVO();
				sTmp.setEqNo(cHSAtdtHistoryMGTVO.getEqNo());
				sTmp.setAtchDt(cHSAtdtHistoryMGTVO.getAtchDt());
				sTmp.setCntrNo(cHSAtdtHistoryMGTVO.getCntrNo());
				sTmp.setAtchYdCd(cHSAtdtHistoryMGTVO.getAtchYdCd());
				sTmp.setUpdUsrId(cHSAtdtHistoryMGTVO.getUpdUsrId());
				sTmp.setCreUsrId(cHSAtdtHistoryMGTVO.getCreUsrId());
				log.debug("tmp.getCntrNo1()======"+sTmp.getCntrNo());
				log.debug("getCntrNo.getCntrNo()======"+sTmp.getCntrNo());
				insertVoList.add(sTmp);
				dbDao.addCHSAtdtHistoryData(insertVoList);

			} else {
				updateVoList  =  new ArrayList<CHSMovementHistoryMGTVO>();
				sTmp = new CHSMovementHistoryMGTVO();
				sTmp.setEqNo(cHSAtdtHistoryMGTVO.getEqNo());
				sTmp.setDtchDt(cHSAtdtHistoryMGTVO.getDtchDt()); // modification
				sTmp.setDtchYdCd(cHSAtdtHistoryMGTVO.getDtchYdCd());
				sTmp.setUpdUsrId(cHSAtdtHistoryMGTVO.getUpdUsrId());
				//sTmp.setDtchInpTpCd("A");
				updateVoList.add(sTmp);
				dbDao.modifyCHSAtdtHistoryInBetweenData(updateVoList);
			}

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * atdt update from ctm
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageCHSAtdtHistoryBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException{
		// Map object for Response object
		try {
			// Map object for ETC Data

				dbDao.modifyCHSAtdtHistoryData(cHSAtdtHistoryMGTVO);

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}


	/**
	 * Modify before/after attach information in case of date/yard modification/deleting from CTM
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageCHSAtdtPrePostHistoryBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException{
		// Map object for Response object
		try {
			// Modify before detach information in case of date/yard modification
			if(cHSAtdtHistoryMGTVO.getIbflag().equals("R")){

				dbDao.modifyCHSAtdtPreHistoryByCtmUpdData(cHSAtdtHistoryMGTVO);
			} else {
				dbDao.modifyCHSAtdtPreHistoryByCtmDelData(cHSAtdtHistoryMGTVO);
			}

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * Modify after attach information in case of 1108 deleting
	 *
	 * @param List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs
	 * @throws EventException
	 */
	public void modifyCHSAtdtByRemoveBareMvmtBasic(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws EventException{
		// Map object for Response object
		try {
				dbDao.modifyCHSAtdtByRemoveBareMvmtData(cHSMovementHistoryMGTVOs);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * M.G.Set Eq Master AT/DT information modification. Manage [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @param mGSAtdtHistoryINVOs MGSAtdtHistoryINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSAtdtHistoryBasic(MGSEquipmentINVO mGSEquipmentINVO,MGSAtdtHistoryINVO[] mGSAtdtHistoryINVOs, SignOnUserAccount account)throws EventException
	{
		try {
			List<MGSAtdtHistoryINVO> removeVoList = new ArrayList<MGSAtdtHistoryINVO>();
			List<MGSAtdtHistoryINVO> updateVoList = new ArrayList<MGSAtdtHistoryINVO>();

			for ( int i=0; i<mGSAtdtHistoryINVOs.length; i++ ) {
				mGSAtdtHistoryINVOs[i].setEqNo(mGSEquipmentINVO.getEqNo());
				mGSAtdtHistoryINVOs[i].setUpdUsrId(account.getUsr_id());
				mGSAtdtHistoryINVOs[i].setOrgAtchDt(mGSEquipmentINVO.getOrgAtchDt());
				if ( mGSAtdtHistoryINVOs[i].getIbflag().equals("D")){
					removeVoList.add(mGSAtdtHistoryINVOs[i]);
				} else if ( mGSAtdtHistoryINVOs[i].getIbflag().equals("U")){
					updateVoList.add(mGSAtdtHistoryINVOs[i]);
				}
			}
			if ( removeVoList.size() > 0 ) {
				dbDao.removeMGSAtdtHistoryData(removeVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMGSAtdtLastHistoryData(updateVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Action DT by CHS in case of MVMT create   [EES_CGM_1109]<br>
	 *
	 * @param MGSCNTRMvmtMGTVO  cNTRMvmtMGTVO
	 * @exception EventException
	 */
	public void manageMGSDetachByMgstBasic(MGSCNTRMvmtMGTVO  cNTRMvmtMGTVO) throws EventException
	{
		// Map object for Response object
		try {
			dbDao.modifyMGSDetachByMgstData(cNTRMvmtMGTVO);
			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}
	
	/**
	 * Handling Chassis, M.G.Set Attach/Detach list by recieve  322 Movement data from CTM  [ChassisMovementHistoryBCImpl call]<br>
	 *
	 * @param MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO
	 * @exception EventException
	 */
	public void manageMGSAtdtByCtmBasic(MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO) throws EventException{
		// Map object for Response object
		try {
			// Map object for ETC Data
			CHSMovementHistoryMGTVO  sTmp = new CHSMovementHistoryMGTVO();
			List<CHSMovementHistoryMGTVO> insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			List<CHSMovementHistoryMGTVO> updateVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			if(mGSAtdtHistoryMGTVO.getAt().equals("AT")){
				insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
				sTmp = new CHSMovementHistoryMGTVO();
				sTmp.setEqNo(mGSAtdtHistoryMGTVO.getEqNo());
				sTmp.setAtchDt(mGSAtdtHistoryMGTVO.getAtchDt());
				sTmp.setCntrNo(mGSAtdtHistoryMGTVO.getCntrNo());
				sTmp.setChssNo(mGSAtdtHistoryMGTVO.getChssNo());
				sTmp.setAtchYdCd(mGSAtdtHistoryMGTVO.getAtchYdCd());
				sTmp.setUpdUsrId(mGSAtdtHistoryMGTVO.getUpdUsrId());
				sTmp.setCreUsrId(mGSAtdtHistoryMGTVO.getCreUsrId());
				log.debug("tmp.getCntrNo1()======"+sTmp.getCntrNo());
				log.debug("getCntrNo.getCntrNo()======"+sTmp.getCntrNo());
				insertVoList.add(sTmp);
				dbDao.addMGSAtdtHistoryData(insertVoList);

			} else {
				updateVoList  =  new ArrayList<CHSMovementHistoryMGTVO>();
				sTmp = new CHSMovementHistoryMGTVO();
				sTmp.setEqNo(mGSAtdtHistoryMGTVO.getEqNo());
				sTmp.setDtchDt(mGSAtdtHistoryMGTVO.getDtchDt()); // modification
				sTmp.setDtchYdCd(mGSAtdtHistoryMGTVO.getDtchYdCd());
				sTmp.setUpdUsrId(mGSAtdtHistoryMGTVO.getUpdUsrId());
				//sTmp.setDtchInpTpCd("A");
				updateVoList.add(sTmp);
				dbDao.modifyCHSAtdtHistoryInBetweenData(updateVoList);
			}

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}
	
	/**
	 * EQ Attatch/Detach information save(History save)  [EES_CGM_1109]<br>
	 *
	 * @param List<MGSAtdtHistoryMGTVO>  mGSAtdtHistoryMGTVOs
	 * @exception EventException
	 */
	public void manageMGSAtdtByMvmtBasic(List<MGSAtdtHistoryMGTVO>  mGSAtdtHistoryMGTVOs) throws EventException{
		// Map object for Response object
		try {
			// Map object for ETC Data
			MGSAtdtHistoryMGTVO          tmp  = new MGSAtdtHistoryMGTVO();
			CHSMovementHistoryMGTVO  sTmp = new CHSMovementHistoryMGTVO();
			List<CHSMovementHistoryMGTVO> insertVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			List<CHSMovementHistoryMGTVO> deldateVoList = new ArrayList<CHSMovementHistoryMGTVO>();
			for ( int i=0; i<mGSAtdtHistoryMGTVOs.size(); i++ ) {
				tmp = mGSAtdtHistoryMGTVOs.get(i);
				if(tmp.getIbflag().equals("I")){
					sTmp = new CHSMovementHistoryMGTVO();
					sTmp.setEqNo(tmp.getEqNo());
					sTmp.setAtchDt(tmp.getAtchDt());
					sTmp.setCntrNo(tmp.getCntrNo());
					sTmp.setChssNo(tmp.getChssNo());
					sTmp.setEqKndCd(tmp.getEqKndCd());
					sTmp.setAtchYdCd(tmp.getAtchYdCd());
					sTmp.setUpdUsrId(tmp.getUpdUsrId());
					sTmp.setCreUsrId(tmp.getCreUsrId());
					insertVoList.add(sTmp);
				} else {
					sTmp = new CHSMovementHistoryMGTVO();
					sTmp.setEqNo(tmp.getEqNo());
					sTmp.setAtchDt(tmp.getAtchDt());
					sTmp.setDtchDt(tmp.getDtchDt()); // modification
					sTmp.setDtchYdCd(tmp.getYdCd());
					sTmp.setEqKndCd(tmp.getEqKndCd());
					deldateVoList.add(sTmp);
				}
			}

			if(deldateVoList.size()>0){
				dbDao.removeCHSAtdtByMvmtData(deldateVoList);
			}

			if(insertVoList.size()>0){
				dbDao.addMGSAtdtByMvmtData(insertVoList);
			}

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}
	
	/**
	 * atdt update from ctm
	 *
	 * @param MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageMGSAtdtHistoryBasic(MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO) throws EventException{
		// Map object for Response object
		try {
			// Map object for ETC Data

				dbDao.modifyMGSAtdtHistoryData(mGSAtdtHistoryMGTVO);

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}
	
	/**
	 * Modify before/after attach information in case of date/yard modification/deleting from CTM
	 *
	 * @param MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageMGSAtdtPrePostHistoryBasic(MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO) throws EventException{
		// Map object for Response object
		try {
			// Modify before detach information in case of date/yard modification
			if(mGSAtdtHistoryMGTVO.getIbflag().equals("R")){

				dbDao.modifyMGSAtdtPreHistoryByCtmUpdData(mGSAtdtHistoryMGTVO);
			} else {
				dbDao.modifyMGSAtdtPreHistoryByCtmDelData(mGSAtdtHistoryMGTVO);
			}

			// Response Data setting
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}
}