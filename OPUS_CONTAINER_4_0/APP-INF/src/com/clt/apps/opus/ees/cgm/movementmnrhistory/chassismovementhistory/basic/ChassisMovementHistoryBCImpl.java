/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration.ChassisMovementHistoryDBDAO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSAtchDtchHisMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMovementMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtBareMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtGroupVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSmgstChkINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CNTRMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.ShipCHSMvmtMGTVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-MovementMnrHistory Business Logic Basic Command implementation<br>
 * - OPUS-MovementMnrHistory biz logic handling.<br>
 *
 * @author 
 * @see testEventResponse,ChassisMovementHistoryBC each DAO class reference
 * @since J2EE 1.6
 */
public class ChassisMovementHistoryBCImpl extends BasicCommandSupport implements ChassisMovementHistoryBC {

	// Database Access Object
	private transient ChassisMovementHistoryDBDAO dbDao = null;
	/**
	 * ChassisMovementHistoryBCImpl objects creation<br>
	 * ChassisMovementHistoryDBDAO creation.<br>
	 */
	public ChassisMovementHistoryBCImpl() {
		dbDao = new ChassisMovementHistoryDBDAO();
	}

	/**
	 *  Eq Lost  'XX' movement inserting   [EES_CGM_1017,EES_CGM_1009] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void createCHSXXMvmtBasic(List<CHSMovementMGTVO>  cHSMovementMGTVOs ) throws EventException{
		try {

			if ( cHSMovementMGTVOs.size() > 0 ) {
				dbDao.addCHSXXMvmtData(cHSMovementMGTVOs);
			}

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			//CGM000013 
//			throw new EventException(new ErrorHandler("CGM000013", new String[]{"createCHSXXMvmt"}).getUserMessage(),ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  Eq Found 'BI' movement inserting   [EES_CGM_1017,EES_CGM_1018] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void createCHSFoundMvmtBasic(List<CHSMovementMGTVO>  cHSMovementMGTVOs ) throws EventException{
		try {
			List<CHSMovementMGTVO> insertVoList = new ArrayList<CHSMovementMGTVO>();
			for ( int i=0; i<cHSMovementMGTVOs.size(); i++ ) {
				insertVoList.add(cHSMovementMGTVOs.get(i));
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addCHSFoundMvmtData(insertVoList);
			}

//			dbDao.addCHSXXMvmtData(chassisMovementMGTVOs);

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  Eq movement information deleting   [EES_CGM_1016] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void modifyChsMoveByStatusBasic(List<CHSMovementMGTVO>  cHSMovementMGTVOs ) throws EventException{
		try {
			List<CHSMovementMGTVO> updateVoList = new ArrayList<CHSMovementMGTVO>();
			for ( int i=0; i<cHSMovementMGTVOs.size(); i++ ) {
				updateVoList.add(cHSMovementMGTVOs.get(i));
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyChsMoveByStatusDate(updateVoList);
			}

//			dbDao.addCHSXXMvmtData(chassisMovementMGTVOs);

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}


	/**
	 *  Eq movement information deleting   [EES_CGM_1016] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void removeChsMoveByStatusBasic(List<CHSMovementMGTVO>  cHSMovementMGTVOs ) throws EventException{
		try {
			List<CHSMovementMGTVO> delteVoList = new ArrayList<CHSMovementMGTVO>();
			for ( int i=0; i<cHSMovementMGTVOs.size(); i++ ) {
				delteVoList.add(cHSMovementMGTVOs.get(i));
			}

			if ( delteVoList.size() > 0 ) {
				dbDao.removeChsMoveByStatusDate(delteVoList);
			}

//			dbDao.addCHSXXMvmtData(chassisMovementMGTVOs);

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  Eq movement information deleting   [EES_CGM_1018] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void removeChsMvmtFoundAutoBasic(List<CHSMovementMGTVO>  cHSMovementMGTVOs ) throws EventException{
		try {
			List<CHSMovementMGTVO> delteVoList = new ArrayList<CHSMovementMGTVO>();
			for ( int i=0; i<cHSMovementMGTVOs.size(); i++ ) {
				delteVoList.add(cHSMovementMGTVOs.get(i));
			}

			if ( delteVoList.size() > 0 ) {
				dbDao.removeChsMvmtFoundAutoData(delteVoList);
			}

//			dbDao.addCHSXXMvmtData(chassisMovementMGTVOs);

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  (each Chassis) Movement History information retrieve   [EES_CGM_1104] <br>
	 *
	 * @param chsMvmtINVO CHSMvmtINVO
	 * @return  List<CHSMvmtMGTVO>
	 * @exception EventException
	 */
	public List<CHSMvmtMGTVO> searchCHSMovementListBasic(CHSMvmtINVO chsMvmtINVO) throws EventException {
		try {
			String chssMvmtStsCd = chsMvmtINVO.getChssMvmtStsCd();
			if(chssMvmtStsCd != null && !chssMvmtStsCd.equals("")){
				chssMvmtStsCd = "'" + chssMvmtStsCd.replaceAll(",", "','") + "'";
				chsMvmtINVO.setChssMvmtStsCd(chssMvmtStsCd);
			}

			return dbDao.searchChsMovementListData(chsMvmtINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}

	/**
	 *  chassismovementhistory retrieve event handling [EES_CGM_1105] <br>
	 *
	 * @param cHSMvmtINVO CHSMvmtINVO
	 * @return  CHSMvmtGroupVO
	 * @exception EventException
	 */
	public  CHSMvmtGroupVO searchCHSMovementHistoryBasic(CHSMvmtINVO cHSMvmtINVO) throws EventException {
		CHSMvmtGroupVO list = new CHSMvmtGroupVO();
		try {


			//----------------------------
			// Chassis Main data retrieve
			//----------------------------
			List<CHSMvmtHistoryMGTVO> agreementList = dbDao.searchCHSMstInfoData(cHSMvmtINVO);


			list.setChsmvmthistorymgtvo(agreementList);
			agreementList = null;
			//----------------------------
			// Chassis Movement History data retrieve
			//----------------------------
			agreementList = dbDao.searchCHSMovementHistoryData(cHSMvmtINVO);

			list.setChsmvmthistorymgtvo2(agreementList);

			agreementList = null;
			//----------------------------
			// Chassis Attach data retrieve
			//----------------------------
			agreementList = dbDao.searchCHSAtdtHistoryData(cHSMvmtINVO);

			list.setChsmvmthistorymgtvo3(agreementList);

			// ETCDATA setting

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
		return list;
	}

	/**
	 *  chassismovementhistory retrieve event handling [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtINVO CHSMvmtINVO
	 * @return  List<CHSMvmtBareMGTVO>
	 * @exception EventException
	 */
	public List<CHSMvmtBareMGTVO> searchCHSBareMvmtBasic(CHSMvmtINVO cHSMvmtINVO) throws EventException {
		try {
			return dbDao.searchCHSBareMvmtData(cHSMvmtINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}

	/**
	 *  chassismovementhistory verify  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtBareMGTVOs CHSMvmtBareMGTVO[]
	 * @return  List<CHSMvmtBareMGTVO>
	 * @exception EventException
	 */
	public List<CHSMvmtBareMGTVO> verifyCHSBareMvmtBasic(CHSMvmtBareMGTVO[] cHSMvmtBareMGTVOs) throws EventException {
		try {
		    List<CHSMvmtBareMGTVO> tmpVo = new  ArrayList<CHSMvmtBareMGTVO>();
		    CHSMvmtBareMGTVO  mp   = new CHSMvmtBareMGTVO();
		    CHSMvmtBareMGTVO tmp   = new CHSMvmtBareMGTVO();
		    CHSMvmtBareMGTVO tmp2  = new CHSMvmtBareMGTVO();

			for ( int i=0; i<cHSMvmtBareMGTVOs.length; i++ ) {
				tmp = new CHSMvmtBareMGTVO();
				mp = new CHSMvmtBareMGTVO();
				tmp = cHSMvmtBareMGTVOs[i];
				mp.setEqNo(tmp.getEqNo());
				mp.setMvmtDtDay(tmp.getMvmtDtDay());
				mp.setMvmtDtHd(tmp.getMvmtDtHd());
//				dest_yd_cd
				mp.setDestYdCd(tmp.getDestYdCd());
				mp.setMgstNo(tmp.getMgstNo());
				log.debug(".getIbflag()==============================="+tmp.getIbflag());
				log.debug(" mp.getEqNo : " + mp.getEqNo());
				if(tmp.getIbflag().equals("I") && tmp.getDelChk().equals("1")){
					tmp2 = dbDao.searchCHSBareMvmtVerifyData(mp);
					if(tmp2 == null)
					{
						tmp.setVerify("Failed");
					}
					else
					{
						tmp.setVerify(tmp2.getVerify());
					}
				}else{
					tmp.setVerify("");
				}


				tmpVo.add(tmp);
			}
			return tmpVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}

	/**
	 *  Eq bare movement editing/deleting.  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtBareMGTVOs CHSMvmtBareMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSBareMvmtBasic(CHSMvmtBareMGTVO[] cHSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException{
		// Map object for Response object
		@SuppressWarnings("unused")
		boolean chkPoolMatch = true;
		try {
			// Map object for ETC Data
//			Map<String, String> etcData = new HashMap<String, String>();
			List<CHSMvmtBareMGTVO> updateVoList  = new ArrayList<CHSMvmtBareMGTVO>();
			List<CHSMvmtBareMGTVO> deldateVoList = new ArrayList<CHSMvmtBareMGTVO>();

			for ( int i=0; i<cHSMvmtBareMGTVOs.length; i++ ) {
				cHSMvmtBareMGTVOs[i].setUpdUsrId(account.getUsr_id());
				log.debug("getIbflag===="+cHSMvmtBareMGTVOs[i].getIbflag());
				if(cHSMvmtBareMGTVOs[i].getIbflag().equals("U")){
					updateVoList.add(cHSMvmtBareMGTVOs[i]);
				} else if(cHSMvmtBareMGTVOs[i].getIbflag().equals("D")){
					deldateVoList.add(cHSMvmtBareMGTVOs[i]);
				}
			}

			log.debug("deldateVoList===="+deldateVoList.size());
			// Chassis movement UPDATE
			if ( updateVoList.size() > 0 ) {
				chkPoolMatch = dbDao.modifyCHSMovementData(updateVoList);
			}
			// Chassis movement DELETE
			if ( deldateVoList.size() > 0 ) {
				chkPoolMatch = dbDao.removeCHSMovementData(deldateVoList);
			}

//			etcData = CHSMvmtBareMGTVO.getColumnValues();

			// Response Data setting
//			responseData.put(WebKeys.ER_ETCDATA, etcData);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 *  EEq bare movement inserting.  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtBareMGTVOs CHSMvmtBareMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSBareMvmtBasic(CHSMvmtBareMGTVO[] cHSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException{
		// Map object for Response object
		@SuppressWarnings("unused")
		boolean chkPoolMatch = true;
		try {
			// Map object for ETC Data
//			Map<String, String> etcData = new HashMap<String, String>();
			List<CHSMvmtBareMGTVO> indateVoList  = new ArrayList<CHSMvmtBareMGTVO>();

			for ( int i=0; i<cHSMvmtBareMGTVOs.length; i++ ) {
				cHSMvmtBareMGTVOs[i].setUpdUsrId(account.getUsr_id());
				cHSMvmtBareMGTVOs[i].setCreUsrId(account.getUsr_id());
				cHSMvmtBareMGTVOs[i].setMnlInpFlg("Y");
				log.debug("getIbflag===="+cHSMvmtBareMGTVOs[i].getIbflag());
				if(cHSMvmtBareMGTVOs[i].getIbflag().equals("I") ){
					indateVoList.add(cHSMvmtBareMGTVOs[i]);
				}
			}

			// Chassis movement UPDATE 
			if ( indateVoList.size() > 0 ) {
				chkPoolMatch = dbDao.addCHSBareMvmtData(indateVoList);
			}

//			etcData = CHSMvmtBareMGTVO.getColumnValues();

			// Response Data setting
//			responseData.put(WebKeys.ER_ETCDATA, etcData);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}


	/**
	 *  Eq ON-hire 'MT' movement  <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void createCHSOnhireMvmtBasic(List<CHSMovementMGTVO> cHSMovementMGTVOs ) throws EventException {
		try {


			if ( cHSMovementMGTVOs.size() > 0 ) {
				dbDao.addCHSXXMvmtData(cHSMovementMGTVOs);
			}

//			dbDao.addCHSXXMvmtData(chassisMovementMGTVOs);

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}


	/**
	 *  Eq Retirement handling. SAVE  [MNR call]<br>
	 *
	 * @param IFMnrFlagVO iFMnrFlagVO
	 * @exception EventException
	 */
	public void createMNRStatusBasic(IFMnrFlagVO iFMnrFlagVO) throws EventException{
		try {

			CHSMovementMGTVO mp = new CHSMovementMGTVO();
			IFMnrFlagVO          iFMnrVo = new IFMnrFlagVO();
			List<CHSMovementMGTVO>  chassisMovementMGTVOs = new ArrayList<CHSMovementMGTVO>();
			
			mp = new CHSMovementMGTVO();
			iFMnrVo = iFMnrFlagVO;
			//sts_evnt_dt

			mp.setChssNo(iFMnrVo.getEqNo());
			mp.setMvmtDt(iFMnrVo.getFlagDt());
			mp.setYdCd(iFMnrVo.getFlagYdCd());
			mp.setChssOwnrCoCd("H");
			mp.setMvmtCoCd("H");
			//mp.setVndrSeq(cHSFoundLostMGTVO.getVndrSeq());
			if(iFMnrVo.getStsFlag().equals("Y")){
				mp.setMvmtStsCd("XX");
				mp.setMvmtRsnCd(iFMnrVo.getFlagType());
				mp.setGateIoCd("O");
			} else {
				mp.setMvmtStsCd("BI");
				mp.setMvmtRsnCd("CHON");
				mp.setGateIoCd("I");
			}

			mp.setUpdUsrId(iFMnrVo.getFlagUserId());
			mp.setCreUsrId(iFMnrVo.getFlagUserId());
			chassisMovementMGTVOs.add(mp);
			
			dbDao.addMnrRetirementData(chassisMovementMGTVOs);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),de);
		}
	}

	/**
	 *  Chassis Movement editing operation SAVE  [CTM call]<br>
	 *
	 * @param cusCtmMovementVOs List<CusCtmMovementVO>
	 * @return String
	 */
	public String  manageCHSMovementByCtmBasic(List<CusCtmMovementVO> cusCtmMovementVOs){
		ChassisMovementHistoryCHSMovementByCtmBackEndJob backEndResult = new ChassisMovementHistoryCHSMovementByCtmBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setSearchEDIErrorVO(cusCtmMovementVOs);
		CusCtmMovementVO cus = cusCtmMovementVOs.get(0);
		return backEndJobManager.execute(backEndResult,cus.getUpdUsrId(), "CTM to FROM.");
	}


	/**
	 *  Chassis Movement editing operation SAVE  [CTM call]<br>
	 *
	 * @param cusCtmMovementVOs List<CusCtmMovementVO>
	 */
	public void  manageCHSMovementByCtmBatchBasic(List<CusCtmMovementVO> cusCtmMovementVOs) {
		try {
			log.debug("manageCHSMovementByCtmBatchBasic==  start "+cusCtmMovementVOs.size());
			ChassisMgsetOnOffhireBC chs = new ChassisMgsetOnOffhireBCImpl();

			ChassisMgsetAttachDetachHistoryBC atdt = new ChassisMgsetAttachDetachHistoryBCImpl();

			CHSMasterMGTVO          cHSMasterMGTVO    = null;
			CusCtmMovementVO        cusCtmMovementVO  = null;
			List<CHSMvmtBareMGTVO>  cHSMvmtBareMGTVOs = null;
			CHSMvmtBareMGTVO        cHSMvmtBareMGTVO  = null;
			CHSAtdtHistoryMGTVO     cHSAtdtHistoryMGTVO = null;
			CHSAtdtHistoryMGTVO     chkAtdtHistoryMGTVO = null;
			CHSAtchDtchHisMGTVO     cgmEqAtchDtchHisMGTVO = null;

			List<CNTRMvmtMGTVO>     cNTRMvmtMGTVOs    = new ArrayList<CNTRMvmtMGTVO>();
			CNTRMvmtMGTVO           cNTRMvmtMGTVO     = null;
			CNTRMvmtMGTVO           cNTRMvmtMGTVO2    = null;
			CNTRMvmtMGTVO           cNTRMvmtINVO      = null;


			String                  sGmtDt            = "";

			String                  mvmtStsCd         = "";
			String                  chssNo            = "";
			String                  chkFlag           = "";

			String                  sLagDt            = "";
			String                  sLeadDt           = "";
			String                  sLagDtYd          = "";
			String                  sLeadDtYd         = "";
			String                  sAtchdt           = "";
			for(int i=0;i<cusCtmMovementVOs.size();i++){

				cusCtmMovementVO  = new CusCtmMovementVO();

				cusCtmMovementVO = cusCtmMovementVOs.get(i);
				chkFlag          = cusCtmMovementVO.getIbflag();
				log.debug("chssNo ===========|cusCtmMovementVO|getCnmvYr|================="+cusCtmMovementVO.getCnmvYr());
				log.debug("chssNo ===========|cusCtmMovementVO|getMgstNo|================="+cusCtmMovementVO.getMgstNo());

				if(chkFlag == null){
					chkFlag      = "";
				}

				log.debug("cusCtmMovementVO.chkFlag()==="+chkFlag);
				log.debug("cusCtmMovementVO.chkFlag()=i="+i);
				log.debug("cusCtmMovementVO.getUpdUsrId()========="+cusCtmMovementVO.getUpdUsrId());


				if(chkFlag.equals("C") || chkFlag.equals("I")|| chkFlag.equals("")){
					cNTRMvmtMGTVOs    = new ArrayList<CNTRMvmtMGTVO>();

					mvmtStsCd = cusCtmMovementVO.getMvmtStsCd().trim();
					chssNo    = cusCtmMovementVO.getChssNo();
					if(chssNo == null){
						chssNo ="";
					}

					log.debug("cusCtmMovementVO.getMvmtStsCd()==="+cusCtmMovementVO.getMvmtStsCd());
					log.debug("cusCtmMovementVO.getCnmvEvntDt()==="+cusCtmMovementVO.getCnmvEvntDt());

					// CGM Chassis Movement History update
					cNTRMvmtMGTVO = new CNTRMvmtMGTVO();
					cNTRMvmtMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
					cNTRMvmtMGTVO.setMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setCnmvEvntDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setOrgYdCd(cusCtmMovementVO.getOrgYdCd());
					cNTRMvmtMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());
					cNTRMvmtMGTVO.setMvmtRsnCd(cusCtmMovementVO.getMvmtStsCd());
					cNTRMvmtMGTVO.setMvmtStsCd(cusCtmMovementVO.getMvmtStsCd().trim());
//					cNTRMvmtMGTVO.setIoBndCd(cusCtmMovementVO.getObCntrFlg()); // 
					cNTRMvmtMGTVO.setVndrSeq(cusCtmMovementVO.getVndrSeq());
					cNTRMvmtMGTVO.setMgstNo(cusCtmMovementVO.getMgstNo());
					cNTRMvmtMGTVO.setCnmvRmk(""); // 
					cNTRMvmtMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
					cNTRMvmtMGTVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
					cNTRMvmtMGTVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());
					cNTRMvmtMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setBkgNo(cusCtmMovementVO.getBkgNo());
					cNTRMvmtMGTVO.setCntrTpszCd(cusCtmMovementVO.getCntrTpszCd());


					if(chssNo.equals("")&& (mvmtStsCd.equals("VL") || mvmtStsCd.equals("EN")|| mvmtStsCd.equals("CE")) ){
						// sql 
						cNTRMvmtMGTVO2 = dbDao.checkChsBareMvmtByCtmData(cusCtmMovementVO);

						if(cNTRMvmtMGTVO2 != null){
							if(cNTRMvmtMGTVO2.getMvmtDt1().equals(cNTRMvmtMGTVO2.getMvmtDt2())){
								// data exist -> a.mvmtdt = b.mbmtdt
								cNTRMvmtMGTVO.setMvmtRsnCd("CT"+mvmtStsCd);
								cNTRMvmtMGTVO.setMvmtStsCd("BR");
								cNTRMvmtMGTVO.setChssNo(cNTRMvmtMGTVO2.getChssNo());
							} else {
								cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
							}
						} else {
							cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
						}

					} else { 
						cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
					}


					//--

					log.debug("cusCtmMovementVO.getUpdUsrId()========="+cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVOs.add(cNTRMvmtMGTVO);

					if(cNTRMvmtMGTVO.getChssNo() !=null && !cNTRMvmtMGTVO.getChssNo().equals("")){
						dbDao.addCHSMovementData(cNTRMvmtMGTVOs);

						//chungpa 20100330 add
						atdt.manageCHSDetachByChssBasic(cNTRMvmtMGTVO);
					}


					cNTRMvmtINVO = new CNTRMvmtMGTVO();
					cNTRMvmtINVO.setCntrNo(cusCtmMovementVO.getCntrNo());
					chkAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();

					chkAtdtHistoryMGTVO = dbDao.checkCHSAtdtData(cNTRMvmtINVO);

					String sChssNo = null;

					sChssNo = cusCtmMovementVO.getChssNo();
					if(sChssNo == null){
						sChssNo = "";
					}


				
					if(chkAtdtHistoryMGTVO != null){
						if((chkAtdtHistoryMGTVO.getDtchYdCd() == null || chkAtdtHistoryMGTVO.getDtchYdCd().equals("")) )
								{
									cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();

									cHSAtdtHistoryMGTVO.setAt("DT");
									cHSAtdtHistoryMGTVO.setEqNo(chkAtdtHistoryMGTVO.getEqNo());
									cHSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt() ); // modification
									cHSAtdtHistoryMGTVO.setDtchYdCd(cusCtmMovementVO.getOrgYdCd());
									cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());

									if(cHSAtdtHistoryMGTVO.getEqNo()!= null && !cHSAtdtHistoryMGTVO.getEqNo().equals("")){
										atdt.manageCHSAtdtByCtmBasic(cHSAtdtHistoryMGTVO);
									}

								}
					}


					if(!cNTRMvmtMGTVO.getMvmtStsCd().equals("BR")
							&& !sChssNo.equals("")) // chungpa 20130315 add
					{
						// at condition
						log.debug("br 아닌 경우 타고 있니 ");
						cNTRMvmtINVO = new CNTRMvmtMGTVO();
						cNTRMvmtINVO.setCntrNo(cusCtmMovementVO.getCntrNo());

						// no condition
						cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();

						cHSAtdtHistoryMGTVO.setAt("AT");
						cHSAtdtHistoryMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
						cHSAtdtHistoryMGTVO.setAtchDt(cusCtmMovementVO.getCnmvEvntDt()); // modification
						cHSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
						cHSAtdtHistoryMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
						cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
						cHSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());

						//if(cHSAtdtHistoryMGTVO.getEqNo()!= null && !cHSAtdtHistoryMGTVO.getEqNo().equals("")){
							atdt.manageCHSAtdtByCtmBasic(cHSAtdtHistoryMGTVO);
						//}

					}

					// * Damage Unflaggin 
			        // 
					//
					// CGM Equipment update
			        //  :crnt_yd, crnt_loc,dst_yd_cd, mvmt_dat information update
					// Master data update
					cHSMasterMGTVO    = new CHSMasterMGTVO();
					cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
//					cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getDestYdCd());

//					cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//					cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////					cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  
//					cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); // 
//					cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); // 
//					cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  // 
					cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
					log.debug("cHSMasterMGTVO.getEqNo()================");
					if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
						log.debug("cHSMasterMGTVO.getEqNo()==========333====="+cHSMasterMGTVO.getEqNo());
						chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
					}

					// sql 
					log.debug("cNTRMvmtMGTVO.getMvmtStsCd()================"+cNTRMvmtMGTVO.getMvmtStsCd());
					if(cNTRMvmtMGTVO.getMvmtStsCd().equals("OP") || cNTRMvmtMGTVO.getMvmtStsCd().equals("CP")){
						cNTRMvmtMGTVO2 = null;
						cNTRMvmtMGTVO2 = dbDao.checkChsBareMvmtByopocData(cusCtmMovementVO);

						//String                  sGmtDt              = "";
						if(cNTRMvmtMGTVO2!= null && (cNTRMvmtMGTVO2.getMvmtDt1().equals(cNTRMvmtMGTVO2.getMvmtDt2()) && !cNTRMvmtMGTVO2.getChssNo().equals(cusCtmMovementVO.getChssNo())  ))
						{
							cHSMvmtBareMGTVOs = new ArrayList<CHSMvmtBareMGTVO>();

							cHSMvmtBareMGTVO = new CHSMvmtBareMGTVO();
							cusCtmMovementVO = cusCtmMovementVOs.get(i);

							cHSMvmtBareMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());

							sGmtDt = cusCtmMovementVO.getCnmvEvntDt().replaceAll("-", "");
							sGmtDt = sGmtDt.replaceAll(":", "");
							sGmtDt = sGmtDt.replaceAll(" ", "");

							cHSMvmtBareMGTVO.setMvmtDtDay(sGmtDt.substring(0,8));
							cHSMvmtBareMGTVO.setMvmtDtHd(sGmtDt.substring(8,sGmtDt.length()));
							cHSMvmtBareMGTVO.setMvmtStsCd("BR");
							cHSMvmtBareMGTVO.setYdCd(cusCtmMovementVO.getOrgYdCd());   // 
							cHSMvmtBareMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());

							cHSMvmtBareMGTVO.setVndrAbbrNm(cusCtmMovementVO.getVndrSeq());
							cHSMvmtBareMGTVO.setMvmtRsnCd("CT"+cNTRMvmtMGTVO.getMvmtStsCd());
							cHSMvmtBareMGTVO.setMgstNo(cusCtmMovementVO.getMgstNo());
							//cHSMvmtBareMGTVO.setMvmtCoCd(cusCtmMovementVO.getmvmtc)   // 
							cHSMvmtBareMGTVO.setDiffRmk("");
							cHSMvmtBareMGTVO.setMnlInpFlg("N");
							cHSMvmtBareMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
							cHSMvmtBareMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							cHSMvmtBareMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
							cHSMvmtBareMGTVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
							cHSMvmtBareMGTVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());

							cHSMvmtBareMGTVOs.add(cHSMvmtBareMGTVO);
							// Bare Movement 
							if(cHSMvmtBareMGTVO.getEqNo() != null && !cHSMvmtBareMGTVO.getEqNo().equals("")){
								dbDao.addCHSBareMvmtData(cHSMvmtBareMGTVOs);
							}
							cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();

							cHSAtdtHistoryMGTVO.setAt("DT");
							cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo()); //
							cHSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt()); // modification
							cHSAtdtHistoryMGTVO.setDtchYdCd(cusCtmMovementVO.getOrgYdCd());
							cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());

							if(cHSMvmtBareMGTVO.getEqNo() != null && !cHSMvmtBareMGTVO.getEqNo().equals("")){
								atdt.manageCHSAtdtByCtmBasic(cHSAtdtHistoryMGTVO);
							}

							// movement editiong -> master update
							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							log.debug("cHSMasterMGTVO.getEqNo()================");
							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								log.debug("cHSMasterMGTVO.getEqNo()==========333====="+cHSMasterMGTVO.getEqNo());
								chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
							}
						}
					}
				// END Row  data
				// start Row  data  update , delete
				} else {
					cNTRMvmtMGTVOs    = new ArrayList<CNTRMvmtMGTVO>();
					//
					// CGM Chassis Movement History update
					cNTRMvmtMGTVO = new CNTRMvmtMGTVO();
					cNTRMvmtMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
					cNTRMvmtMGTVO.setCnmvEvntDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setOrgYdCd(cusCtmMovementVO.getOrgYdCd());
					cNTRMvmtMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());
					cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
					cNTRMvmtMGTVO.setMvmtStsCd(cusCtmMovementVO.getMvmtStsCd().trim());
//					cNTRMvmtMGTVO.setIoBndCd(cusCtmMovementVO.getObCntrFlg()); //
					cNTRMvmtMGTVO.setVndrSeq(cusCtmMovementVO.getVndrSeq());
					cNTRMvmtMGTVO.setMgstNo(cusCtmMovementVO.getMgstNo());
					cNTRMvmtMGTVO.setCnmvRmk(""); //
					cNTRMvmtMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
					cNTRMvmtMGTVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
					cNTRMvmtMGTVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());
					cNTRMvmtMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setBkgNo(cusCtmMovementVO.getBkgNo());

					mvmtStsCd = cusCtmMovementVO.getMvmtStsCd().trim();
					chssNo    = cusCtmMovementVO.getChssNo();


					log.debug("chssNo ===========||getCnmvYr|================="+cusCtmMovementVO.getCnmvYr());
					log.debug("chssNo ===========||getCnmvIdNo|================="+cusCtmMovementVO.getCnmvIdNo());
					//insert ctm mvmt PK, Chassis Mvmt table retrieve
					cNTRMvmtMGTVO2 = dbDao.searchCgmChssMvmtHisData(cusCtmMovementVO);

					// start Row  data가  update
					if(chkFlag.equals("U") ){
						if(chssNo == null){
							chssNo ="";
						}

						// Start Chss_no null -> Mvmt existing -> data deleting
						if(chssNo.equals("")){
							// sql 

							if(cNTRMvmtMGTVO2 != null){
								// Movement data deleting
								dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);

								// Attach detach data  deleting

								cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
								List<CHSAtdtHistoryMGTVO> deldateVoList = new ArrayList<CHSAtdtHistoryMGTVO>();
								cHSAtdtHistoryMGTVO.setIbflag("D");
								cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
								cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt() ); // modification
								cHSAtdtHistoryMGTVO.setEqKndCd("Z");
								cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());

								deldateVoList.add(cHSAtdtHistoryMGTVO);

								cgmEqAtchDtchHisMGTVO = dbDao.searchCgmEqAtchDtchHisData(cHSAtdtHistoryMGTVO);
								if(cgmEqAtchDtchHisMGTVO != null){
									sLagDt     = cgmEqAtchDtchHisMGTVO.getLagDt();
									sLeadDt    = cgmEqAtchDtchHisMGTVO.getLeadDt();
									sLagDtYd   = cgmEqAtchDtchHisMGTVO.getLagDtYd();
									sLeadDtYd  = cgmEqAtchDtchHisMGTVO.getLeadDtYd();
									sAtchdt    = cgmEqAtchDtchHisMGTVO.getAtchDt();
								}

								if(sLagDt == null) sLagDt ="";
								if(sLeadDt == null) sLeadDt ="";
								if(sLagDtYd == null) sLagDtYd ="";
								if(sLeadDtYd == null) sLeadDtYd ="";
								if(sAtchdt == null) sAtchdt = "";

							    //  AtDt deleting
								atdt.manageCHSAtdtByMvmtBasic(deldateVoList);
								// AtDt update
								if(sAtchdt.equals(sLagDt) && sAtchdt.equals(sLeadDt)){
									cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
									cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
									cHSAtdtHistoryMGTVO.setAtchDt(sLagDt); // modification
									cHSAtdtHistoryMGTVO.setDtchYdCd(sLeadDtYd);
									cHSAtdtHistoryMGTVO.setDtchDt(sLeadDt);
									//cHSAtdtHistoryMGTVO.setDtchInpTpCd("A");
									cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
									atdt.manageCHSAtdtHistoryBasic(cHSAtdtHistoryMGTVO);
								}

								// Master data update
								cHSMasterMGTVO    = new CHSMasterMGTVO();
								cHSMasterMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
//								cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//								cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//								cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////								cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     // 
//								cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); //
//								cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); //
//								cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  //
								cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());

								if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
									chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
								}
							}
						// End Chss_no null -> Mvmt existing -> data delete
						// Start Chss_no is not null
						} else {
							cNTRMvmtMGTVOs.add(cNTRMvmtMGTVO);
							log.debug("chssNo ===========|||||||||||||================="+chssNo);
							log.debug("chssNo ===========||||cusCtmMovementVO.getVndrSeq()================="+cusCtmMovementVO.getVndrSeq());
							log.debug("chssNo ===========|||||||||||||================="+cNTRMvmtMGTVO2);
							if(cNTRMvmtMGTVO2 != null){


								log.debug("ccNTRMvmtMGTVO2.getMvmtDt()=================="+cNTRMvmtMGTVO2.getMvmtDt());

							 // Attach detach data  deleting

								cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
								List<CHSAtdtHistoryMGTVO> deldateVoList = new ArrayList<CHSAtdtHistoryMGTVO>();
								cHSAtdtHistoryMGTVO.setIbflag("D");
								cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
								cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt() ); // modification
								cHSAtdtHistoryMGTVO.setEqKndCd("Z");

								deldateVoList.add(cHSAtdtHistoryMGTVO);

								cgmEqAtchDtchHisMGTVO = dbDao.searchCgmEqAtchDtchHisData(cHSAtdtHistoryMGTVO);
								if(cgmEqAtchDtchHisMGTVO != null){
									sLagDt     = cgmEqAtchDtchHisMGTVO.getLagDt();
									sLeadDt    = cgmEqAtchDtchHisMGTVO.getLeadDt();
									sLagDtYd   = cgmEqAtchDtchHisMGTVO.getLagDtYd();
									sLeadDtYd  = cgmEqAtchDtchHisMGTVO.getLeadDtYd();
									sAtchdt    = cgmEqAtchDtchHisMGTVO.getAtchDt();
								}


								if(!chssNo.equals(cNTRMvmtMGTVO2.getChssNo()) || !cNTRMvmtMGTVO2.getMvmtDt().substring(0,12).equals(cusCtmMovementVO.getCnmvEvntDt().substring(0,12))){
							    	// Movement data deleting
									dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);
									// new insert
									dbDao.addCHSMovementData(cNTRMvmtMGTVOs);



									cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
									List<CHSAtdtHistoryMGTVO> insdateVoList = new ArrayList<CHSAtdtHistoryMGTVO>();
									cHSAtdtHistoryMGTVO.setIbflag("I");
									cHSAtdtHistoryMGTVO.setEqNo(cusCtmMovementVO.getChssNo());


									cHSAtdtHistoryMGTVO.setEqKndCd("Z");
									cHSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO2.getChssNo());
									cHSAtdtHistoryMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
									cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
									cHSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
									cHSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());



									cHSAtdtHistoryMGTVO.setIbflag("R");
									log.debug("ccNTRMvmtMGTVO2.getMvmtDt()=================="+cNTRMvmtMGTVO2.getMvmtDt());
									cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt());
									cHSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt() );
									log.debug("cHSAtdtHistoryMGTVO.getAtchDt()======================="+cHSAtdtHistoryMGTVO.getAtchDt());
									atdt.manageCHSAtdtPrePostHistoryBasic(cHSAtdtHistoryMGTVO);

									 //  AtDt delete

									atdt.manageCHSAtdtByMvmtBasic(deldateVoList);

									cHSAtdtHistoryMGTVO.setIbflag("I");
									cHSAtdtHistoryMGTVO.setAtchDt(cusCtmMovementVO.getCnmvEvntDt() ); // modification
									insdateVoList.add(cHSAtdtHistoryMGTVO);
									// EQ Attatch/Detach information save(History save)
									atdt.manageCHSAtdtByMvmtBasic(insdateVoList);



							    } else {
							    	//  Movement data update
							    	dbDao.modifyCgmChssMvmtHisData(cNTRMvmtMGTVO);
							    	if(sLagDt == null) sLagDt ="";
									if(sLeadDt == null) sLeadDt ="";
									if(sLagDtYd == null) sLagDtYd ="";
									if(sLeadDtYd == null) sLeadDtYd ="";
									if(sAtchdt == null) sAtchdt = "";

									// AtDt update
									if(cgmEqAtchDtchHisMGTVO != null && sAtchdt.equals(sLagDt) && sAtchdt.equals(sLeadDt)){

										cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
										cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
										cHSAtdtHistoryMGTVO.setAtchDt(sLagDt); // modification
//										cHSAtdtHistoryMGTVO.setDtchYdCd(sLeadDtYd);
//									    cHSAtdtHistoryMGTVO.setDtchDt(sLeadDt);
										cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
										atdt.manageCHSAtdtHistoryBasic(cHSAtdtHistoryMGTVO);
									}
							    }
							} else {
								log.debug("cNTRMvmtMGTVO==getMvmtRsnCd=====U========="+cNTRMvmtMGTVO.getMvmtRsnCd());
								cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
								List<CHSAtdtHistoryMGTVO> insdateVoList = new ArrayList<CHSAtdtHistoryMGTVO>();
								cHSAtdtHistoryMGTVO.setIbflag("I");
								cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO.getChssNo());
								cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO.getMvmtDt() ); // modification
								cHSAtdtHistoryMGTVO.setEqKndCd("Z");
								cHSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO.getChssNo());
								cHSAtdtHistoryMGTVO.setCntrNo(cNTRMvmtMGTVO.getCntrNo());
								cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								cHSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
								cHSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());



								insdateVoList.add(cHSAtdtHistoryMGTVO);
								atdt.manageCHSAtdtByMvmtBasic(insdateVoList);

								dbDao.addCHSMovementData(cNTRMvmtMGTVOs);
							}



							// Master data update
							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
//							cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//							cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//							cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////							cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  
//							cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); //
//							cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); //
//							cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  //
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());

							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
							}
						}
						// end Chss_no is not null
				    // ENd Row  data가  update
					// start Row  data가    delete
					} else {  // 
						if(!chssNo.equals("")){
							// Movement data delete
							dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);

							// Attach detach data  deleting

							cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
							List<CHSAtdtHistoryMGTVO> deldateVoList = new ArrayList<CHSAtdtHistoryMGTVO>();
							cHSAtdtHistoryMGTVO.setIbflag("D");
							cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO.getChssNo());
							cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO.getCnmvEvntDt() ); // modification
							cHSAtdtHistoryMGTVO.setEqKndCd("Z");

							deldateVoList.add(cHSAtdtHistoryMGTVO);
							if(cNTRMvmtMGTVO2 !=null){
								// 
//								cgmEqAtchDtchHisMGTVO = dbDao.searchCgmEqAtchDtchHisData(cHSAtdtHistoryMGTVO);
//								if(cgmEqAtchDtchHisMGTVO !=null){
//									sLagDt     = cgmEqAtchDtchHisMGTVO.getLagDt();
//									sLeadDt    = cgmEqAtchDtchHisMGTVO.getLeadDt();
//									sLagDtYd   = cgmEqAtchDtchHisMGTVO.getLagDtYd();
//									sLeadDtYd  = cgmEqAtchDtchHisMGTVO.getLeadDtYd();
//									sAtchdt    = cgmEqAtchDtchHisMGTVO.getAtchDt();
//								}
//
//								if(sLagDt == null) sLagDt ="";
//								if(sLeadDt == null) sLeadDt ="";
//								if(sLagDtYd == null) sLagDtYd ="";
//								if(sLeadDtYd == null) sLeadDtYd ="";
//								if(sAtchdt == null) sAtchdt = "";

							//  

								cHSAtdtHistoryMGTVO.setIbflag("N");
								cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO.getChssNo());
								cHSAtdtHistoryMGTVO.setCntrNo(cNTRMvmtMGTVO.getCntrNo());
								cHSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
								cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								atdt.manageCHSAtdtPrePostHistoryBasic(cHSAtdtHistoryMGTVO);


							    //  AtDt deleting
								atdt.manageCHSAtdtByMvmtBasic(deldateVoList);
//								//  atdt update
//								if(sAtchdt.equals(sLagDt) && sAtchdt.equals(sLeadDt)){
//									cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
//									cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
//									cHSAtdtHistoryMGTVO.setAtchDt(sLagDt); // modification
//									cHSAtdtHistoryMGTVO.setDtchYdCd(sLeadDtYd);
//								    cHSAtdtHistoryMGTVO.setDtchDt(sLeadDt);
//									cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
//									atdt.manageCHSAtdtHistoryBasic(cHSAtdtHistoryMGTVO);
//								}
							}


							// Master data update
							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cNTRMvmtMGTVO.getChssNo());
//							cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//							cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//							cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
//
////							cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  
//							cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); //
//							cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); //
//							cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  //
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							// Eq Master information edit
							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
							}

						} else {


							// Movement data deleting
							dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);

							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							// Eq Master information edit
							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
							}
						}
					}
				}
				// END Row  data  update , delete
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			log.debug("manageCHSMovementByCtmBasic===           end ");
//			throw new EventException(de.getMessage());
//			return cusCtmMovementVOs;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			log.debug("manageCHSMovementByCtmBasic===           end ");
//			throw new EventException(de.getMessage());
//			return cusCtmMovementVOs;
		}
		log.debug("manageCHSMovementByCtmBasic===           end ");

	}


	/**
	 *  Bare Movement handling operation SAVE  [CTM call]<br>
	 *
	 * @param flatFileForGateNewVO FlatFileForGateNewVO
	 * @return String[]
	 */
	public String[]  manageCHSMovementBareByGatenewBasic(FlatFileForGateNewVO flatFileForGateNewVO) throws EventException{
		String[]                sErr                = new String[2];
		try {

			ChassisMgsetAttachDetachHistoryBC atdt = new ChassisMgsetAttachDetachHistoryBCImpl();
			ChassisMgsetOnOffhireBC chs = new ChassisMgsetOnOffhireBCImpl();

			List<CHSMvmtBareMGTVO>  cHSMvmtBareMGTVOs   = null;
			CHSMvmtBareMGTVO        cHSMvmtBareMGTVO    = null;
			CHSAtdtHistoryMGTVO     cHSAtdtHistoryMGTVO = null;
			String                  sGmtDt              = "";
			String                  sContr_no           = "";
			String                  sChss_code          = "";
			boolean                 chk                 = true;
			cHSMvmtBareMGTVOs = new ArrayList<CHSMvmtBareMGTVO>();

			cHSMvmtBareMGTVO = new CHSMvmtBareMGTVO();
			sContr_no        = flatFileForGateNewVO.getCntrNumber();
			sChss_code       = flatFileForGateNewVO.getChssCode();


			if(sChss_code != null && !sChss_code.equals("")){
				sContr_no  = flatFileForGateNewVO.getChssCode();
				chk        = false;
				sChss_code = flatFileForGateNewVO.getCntrNumber();
			}


			log.debug("sContr_no==="+sContr_no);
			log.debug("sChss_code==="+sChss_code);



			cHSMvmtBareMGTVO.setEqNo(sContr_no);
			sGmtDt = flatFileForGateNewVO.getEventDate().trim();

			cHSMvmtBareMGTVO.setMvmtDtDay(sGmtDt.substring(0,8));
			cHSMvmtBareMGTVO.setMvmtDtHd(sGmtDt.substring(8,sGmtDt.length()));

			cHSMvmtBareMGTVO.setYdCd(flatFileForGateNewVO.getEventYard());   //
//				cHSMvmtBareMGTVO.setDestYdCd(flatFileVOForGateNew.getDestYdCd());
			if(chk == true){
				if(flatFileForGateNewVO.getMvmtStatus().trim().equals("BI")){
					cHSMvmtBareMGTVO.setGateIoCd("I");
				} else {
					cHSMvmtBareMGTVO.setGateIoCd("O");
				}

				cHSMvmtBareMGTVO.setMvmtStsCd(flatFileForGateNewVO.getMvmtStatus());
			} else {
				if(flatFileForGateNewVO.getGateIo().trim().equals("A") || flatFileForGateNewVO.getGateIo().trim().equals("I")|| flatFileForGateNewVO.getGateIo().trim().equals("N")
				|| flatFileForGateNewVO.getGateIo().trim().equals("AR")|| flatFileForGateNewVO.getGateIo().trim().equals("UR")
				 ){
					cHSMvmtBareMGTVO.setGateIoCd("I");
					cHSMvmtBareMGTVO.setMvmtStsCd("BI");
				}
				if(flatFileForGateNewVO.getGateIo().trim().equals("AL") || flatFileForGateNewVO.getGateIo().trim().equals("AO")|| flatFileForGateNewVO.getGateIo().trim().equals("D")
			    || flatFileForGateNewVO.getGateIo().trim().equals("OA")|| flatFileForGateNewVO.getGateIo().trim().equals("P")|| flatFileForGateNewVO.getGateIo().trim().equals("RL")|| flatFileForGateNewVO.getGateIo().trim().equals("O")
				){

					cHSMvmtBareMGTVO.setGateIoCd("O");
					cHSMvmtBareMGTVO.setMvmtStsCd("BO");
				}
				cHSMvmtBareMGTVO.setCntrNo(sChss_code);
//				cHSMvmtBareMGTVO.setMvmtStsCd(flatFileForGateNewVO.getMvmtStatus());
			}

			log.debug("getMvmtStatus==="+flatFileForGateNewVO.getMvmtStatus());
			log.debug("getGateIo==="+flatFileForGateNewVO.getGateIo());
			log.debug("getGateIoCd==="+cHSMvmtBareMGTVO.getGateIoCd());
			cHSMvmtBareMGTVO.setVndrAbbrNm(flatFileForGateNewVO.getVndrSeq());
			cHSMvmtBareMGTVO.setMvmtRsnCd("CHPO");
			cHSMvmtBareMGTVO.setMgstNo(flatFileForGateNewVO.getMgSet());
			//cHSMvmtBareMGTVO.setMvmtCoCd(cusCtmMovementVO.getmvmtc)   //
			cHSMvmtBareMGTVO.setDiffRmk("");
			cHSMvmtBareMGTVO.setMnlInpFlg("N");
			
			cHSMvmtBareMGTVO.setCreUsrId(flatFileForGateNewVO.getUserId());
			cHSMvmtBareMGTVO.setUpdUsrId(flatFileForGateNewVO.getUserId());

			cHSMvmtBareMGTVOs.add(cHSMvmtBareMGTVO);
			// Bare Movement handling
		 	dbDao.addCHSBareMvmtData(cHSMvmtBareMGTVOs);
		 	if(chk == true){
				cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();

				cHSAtdtHistoryMGTVO.setAt("DT");
				cHSAtdtHistoryMGTVO.setEqNo(sContr_no);
				cHSAtdtHistoryMGTVO.setDtchDt(sGmtDt); // modification
				cHSAtdtHistoryMGTVO.setDtchYdCd(flatFileForGateNewVO.getEventYard());
				//cHSAtdtHistoryMGTVO.setDtchInpTpCd("A");
				cHSAtdtHistoryMGTVO.setUpdUsrId(flatFileForGateNewVO.getUserId());


			 	atdt.manageCHSAtdtByCtmBasic(cHSAtdtHistoryMGTVO);
		 	}

		 // Master data update
		 	CHSMasterMGTVO cHSMasterMGTVO    = new CHSMasterMGTVO();
			cHSMasterMGTVO.setEqNo(sContr_no);
//			cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//			cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//			cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////			cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  
//			cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); //
//			cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); //
//			cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  //
			cHSMasterMGTVO.setUpdUsrId(flatFileForGateNewVO.getUserId());

			if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
				chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
			}


		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
//			sErr[0] = de.getMessage();
//			sErr[1] = "N";
//			log.debug("err+msg====================="+sErr[1]);
//			return sErr;
		} catch (Exception de) {
//			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
//			sErr[0] = de.getMessage();
//			sErr[1] = "N";
//			log.debug("err+msg====================="+sErr[1]);
//			return sErr;
		}
		sErr[0] = "";
		sErr[1] = "Y";
		log.debug("err+msg====================="+sErr[1]);
		return sErr;
	}

	/**
	 *  get call data
	 *
	 * @return List<CusCtmMovementVO>
	 */
	public List<CusCtmMovementVO> searchCtmMvmtSourceBasic() throws EventException {
		try {
			return dbDao.searchCtmMvmtSourceData();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}

	/**
	 * Container Movement Histoy Retrive Button Event. [1109]<br>
	 * Container movement infoBooking information retrieve
	 *
	 * @param MVMTHistoryListVO mvmtHistoryListVO
	 * @param SignOnUserAccount account
	 * @return List<MVMTBookingInfoVO>
	 * @throws EventException
	 */
	public List<MVMTBookingInfoVO> searchBookingInfoList(MVMTBookingInfoVO mVMTHistoryListVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchBookingInfoList(mVMTHistoryListVO, account);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Container Movement Histoy Retrive Button Event.[1109]<br>
	 * cntr mvnt info retrieve
	 *
	 * @param MVMTHistoryListVO mvmtHistoryListVO
	 * @return List<MVMTHistoryListVO>
	 * @throws EventException
	 */
	public List<MVMTHistoryListVO> searchMVMTHistoryList(MVMTHistoryListVO mvmtHistoryListVO) throws EventException {
		try {
			return dbDao.searchMVMTHistoryList(mvmtHistoryListVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}


	/**
	 * Movement History retrieve [EES_CGM_1109] <br>
	 * @param cHSmgstChkINVO CHSmgstChkINVO
	 * @return List<CHSmgstChkINVO>
	 * @throws EventException
	 */
	public List<CHSmgstChkINVO>  searchchssAtdtVerifyBasic(CHSmgstChkINVO cHSmgstChkINVO) throws EventException{
		try {

			return dbDao.searchchssAtdtVerifyList(cHSmgstChkINVO);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			//CGM000013 
//			throw new EventException(new ErrorHandler("CGM000013", new String[]{"createCHSXXMvmt"}).getUserMessage(),ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Movement History retrieve [EES_CGM_1109] <br>
	 * @param cHSmgstChkINVO CHSmgstChkINVO
	 * @return List<CHSmgstChkINVO>
	 * @throws EventException
	 */
	public List<CHSmgstChkINVO>  searchchssTpszOnCntrCHkBasic(CHSmgstChkINVO cHSmgstChkINVO) throws EventException{
		try {

			return dbDao.searchchssTpszOnCntrCHkList(cHSmgstChkINVO);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			//CGM000013 메세지로
//			throw new EventException(new ErrorHandler("CGM000013", new String[]{"createCHSXXMvmt"}).getUserMessage(),ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Shipper's Chassis의 Movement manage status retrieve. [EES_CGM_1150] <br>
	 *
	 * @param ShipCHSMvmtMGTVO shipCHSMvmtMGTVO
	 * @return  List<ShipCHSMvmtMGTVO>
	 * @exception EventException
	 */
	public List<ShipCHSMvmtMGTVO> searchShipChsMovementListBasic(ShipCHSMvmtMGTVO shipCHSMvmtMGTVO) throws EventException {
		List<ShipCHSMvmtMGTVO> resultVOs = null; // 

		try {
			resultVOs = dbDao.searchShipChsMovementListData(shipCHSMvmtMGTVO);

			if(resultVOs.size() < 1) {
				new EventException(new ErrorHandler("CGM20003",new String[]{"User Information"}).getMessage());
			} else {
				resultVOs.get(0).setMaxRows(dbDao.searchShipChsMovementCountData(shipCHSMvmtMGTVO));
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031", new String[]{"ShipChsMovementListBasic Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032", new String[]{"ShipChsMovementListBasic Search"}).getMessage(),ex);
	 	}

		return resultVOs;
	}

}