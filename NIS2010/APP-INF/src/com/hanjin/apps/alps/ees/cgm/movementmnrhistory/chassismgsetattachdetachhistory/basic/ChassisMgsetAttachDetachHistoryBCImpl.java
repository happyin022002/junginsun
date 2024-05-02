/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryBCImpl.java
*@FileTitle : sdfds
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.06 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration.ChassisMgsetAttachDetachHistoryDBDAO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSAtdtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSMovementHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CNTRMvmtMGTVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-MovementMnrHistory Business Logic Basic Command implementation<br>
 * - ALPS-MovementMnrHistory에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI MIN HOI
 * @see sfdsEventResponse,ChassisMgsetAttachDetachHistoryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ChassisMgsetAttachDetachHistoryBCImpl extends BasicCommandSupport implements ChassisMgsetAttachDetachHistoryBC {

	// Database Access Object
	private transient ChassisMgsetAttachDetachHistoryDBDAO dbDao = null;

	/**
	 * ChassisMgsetAttachDetachHistoryBCImpl 객체 생성<br>
	 * ChassisMgsetAttachDetachHistoryDBDAO를 생성한다.<br>
	 */
	public ChassisMgsetAttachDetachHistoryBCImpl() {
		dbDao = new ChassisMgsetAttachDetachHistoryDBDAO();
	}

	/**
	 *  CHS Bare mvmt 발생시 호출되며,Attach 상태의 Chassis 를 Detach SAVE. <br>
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
	 * Eq attach/detach Status 를 Retrieve 한다.  [EES_CGM_1015]<br>
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
	 * Chassis Attatch/Detach 정보 저장(History 저장) 를 Save 한다.  [EES_CGM_1015]<br>
	 *
	 * @param cHSAtdtHistoryMGTVOs CHSAtdtHistoryMGTVO[]
     * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSAtdtManualBasic(CHSAtdtHistoryMGTVO[] cHSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException{
		// Response 객체를 담기위한 Map 객체
		@SuppressWarnings("unused")
		boolean chkPoolMatch = true;
		try {
			// ETC Data 를  담기위한 Map 객체
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
					sTmp.setDtchDt(tmp.getDtchDt()); // 수정
					sTmp.setDtchYdCd(tmp.getAtchYdCd());
					sTmp.setUpdUsrId(account.getUsr_id());
					updateVoList.add(sTmp);
					dbDao.modifyCHSAtdtHistoryInBetweenData(updateVoList);
				}
			}

//			etcData = CHSMvmtBareMGTVO.getColumnValues();

			// Response Data 설정
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * Eq attach/detach Status 를 조회한다. Retrieve 한다.  [EES_CGM_2016]<br>
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
	 * Eq bare movement 를 수정/삭제한다 를 Save 한다.  [EES_CGM_2016]<br>
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
					sTmp.setDtchDt(tmp.getDtchDt()); // 수정
					sTmp.setDtchYdCd(tmp.getAtchYdCd());
					sTmp.setUpdUsrId(account.getUsr_id());
					updateVoList.add(sTmp);
					dbDao.modifyMGSAtdtHistoryData(updateVoList);
				}
			}

//			etcData = CHSMvmtBareMGTVO.getColumnValues();

			// Response Data 설정
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * MGS Current Location반영을 위해 MGS AT/DT History 이벤트시 INVENTORY 반영.  [EES_CGM_2016]<br>
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

			// Response Data 설정
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * MGS Current Chassis반영을 위해 MGS AT/DT History 이벤트시 INVENTORY 반영.  [EES_CGM_2016]<br>
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

			// Response Data 설정
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}


	/**
	 * MVMT생성시 관련 CHS로 DT를 수행   [EES_CGM_1109]<br>
	 *
	 * @param cNTRMvmtMGTVO CNTRMvmtMGTVO
	 * @exception EventException
	 */
	public void manageCHSDetachByChssBasic(CNTRMvmtMGTVO  cNTRMvmtMGTVO) throws EventException
	{
		// Response 객체를 담기위한 Map 객체
		try {
			dbDao.modifyCHSDetachByChssData(cNTRMvmtMGTVO);
			// Response Data 설정
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}



	/**
	 * EQ Attatch/Detach 정보 저장(History 저장)  [EES_CGM_1109]<br>
	 *
	 * @param cHSAtdtHistoryMGTVOs List<CHSAtdtHistoryMGTVO>
	 * @exception EventException
	 */
	public void manageCHSAtdtByMvmtBasic(List<CHSAtdtHistoryMGTVO>  cHSAtdtHistoryMGTVOs) throws EventException{
		// Response 객체를 담기위한 Map 객체
		try {
			// ETC Data 를  담기위한 Map 객체
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
					sTmp.setDtchDt(tmp.getDtchDt()); // 수정
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

			// Response Data 설정
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}


	/**
	 * CTM 으로부터 322 Movement 데이터를 받아 Chassis, M.G.Set Attach/Detach 내역을 처리 한다.  [ChassisMovementHistoryBCImpl 호출]<br>
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @exception EventException
	 */
	public void manageCHSAtdtByCtmBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException{
		// Response 객체를 담기위한 Map 객체
		try {
			// ETC Data 를  담기위한 Map 객체
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
				sTmp.setDtchDt(cHSAtdtHistoryMGTVO.getDtchDt()); // 수정
				sTmp.setDtchYdCd(cHSAtdtHistoryMGTVO.getDtchYdCd());
				sTmp.setUpdUsrId(cHSAtdtHistoryMGTVO.getUpdUsrId());
				//sTmp.setDtchInpTpCd("A");
				updateVoList.add(sTmp);
				dbDao.modifyCHSAtdtHistoryInBetweenData(updateVoList);
			}

			// Response Data 설정
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * ctm 으로 부터  atdt 업데이트
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageCHSAtdtHistoryBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException{
		// Response 객체를 담기위한 Map 객체
		try {
			// ETC Data 를  담기위한 Map 객체

				dbDao.modifyCHSAtdtHistoryData(cHSAtdtHistoryMGTVO);

			// Response Data 설정
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}


	/**
	 * ctm 으로 부터  date,yard 변경시 또는 삭제시 바로 전 detach 정보, 후의 attach 정보를 수정한다
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageCHSAtdtPrePostHistoryBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException{
		// Response 객체를 담기위한 Map 객체
		try {
			// date,yard 변경시   바로 전 detach 정보  수정한다
			if(cHSAtdtHistoryMGTVO.getIbflag().equals("R")){

				dbDao.modifyCHSAtdtPreHistoryByCtmUpdData(cHSAtdtHistoryMGTVO);
			} else {
				dbDao.modifyCHSAtdtPreHistoryByCtmDelData(cHSAtdtHistoryMGTVO);
			}

			// Response Data 설정
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 * 1108 삭제시 정보, 후의 attach 정보를 수정한다
	 *
	 * @param List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs
	 * @throws EventException
	 */
	public void modifyCHSAtdtByRemoveBareMvmtBasic(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws EventException{
		// Response 객체를 담기위한 Map 객체
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
	 * M.G.Set Eq Master AT/DT 정보를 수정한다. Manage [EES_CGM_2006]<br>
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

}