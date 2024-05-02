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
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration.MgsetMovementHistoryDBDAO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSAtchDtchHisMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSCNTRMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMovementMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtBareMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtGroupVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSmgstChkINVO;
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
public class MgsetMovementHistoryBCImpl extends BasicCommandSupport implements MgsetMovementHistoryBC {

	// Database Access Object
	private transient MgsetMovementHistoryDBDAO dbDao = null;
	/**
	 * MgsetMovementHistoryBCImpl objects creation<br>
	 * MgsetMovementHistoryDBDAO creation.<br>
	 */
	public MgsetMovementHistoryBCImpl() {
		dbDao = new MgsetMovementHistoryDBDAO();
	}

	/**
	 *  Eq Lost  'XX' movement inserting   [EES_CGM_1017,EES_CGM_1009] <br>
	 *
	 * @param List<MGSMovementMGTVO>  mGSMovementMGTVOs
	 * @exception EventException
	 */
	public void createMGSXXMvmtBasic(List<MGSMovementMGTVO> mGSMovementMGTVOs) throws EventException{
		try {

			if ( mGSMovementMGTVOs.size() > 0 ) {
				dbDao.addMGSXXMvmtData(mGSMovementMGTVOs);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  Eq Found 'BI' movement inserting   [EES_CGM_1017,EES_CGM_1018] <br>
	 *
	 * @param List<MGSMovementMGTVO>  mGSMovementMGTVOs
	 * @exception EventException
	 */
	public void createMGSFoundMvmtBasic(List<MGSMovementMGTVO>  mGSMovementMGTVOs ) throws EventException{
		try {
			List<MGSMovementMGTVO> insertVoList = new ArrayList<MGSMovementMGTVO>();
			for ( int i=0; i<mGSMovementMGTVOs.size(); i++ ) {
				insertVoList.add(mGSMovementMGTVOs.get(i));
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addMGSFoundMvmtData(insertVoList);
			}
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
	 * @param List<MGSMovementMGTVO>  mGSMovementMGTVOs
	 * @exception EventException
	 */
	public void modifyMgsMoveByStatusBasic(List<MGSMovementMGTVO>  mGSMovementMGTVOs ) throws EventException{
		try {
			List<MGSMovementMGTVO> updateVoList = new ArrayList<MGSMovementMGTVO>();
			for ( int i=0; i<mGSMovementMGTVOs.size(); i++ ) {
				updateVoList.add(mGSMovementMGTVOs.get(i));
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMgsMoveByStatusDate(updateVoList);
			}

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
	 * @param List<MGSMovementMGTVO>  mGSMovementMGTVOs
	 * @exception EventException
	 */
	public void removeMgsMoveByStatusBasic(List<MGSMovementMGTVO>  mGSMovementMGTVOs ) throws EventException{
		try {
			List<MGSMovementMGTVO> delteVoList = new ArrayList<MGSMovementMGTVO>();
			for ( int i=0; i<mGSMovementMGTVOs.size(); i++ ) {
				delteVoList.add(mGSMovementMGTVOs.get(i));
			}

			if ( delteVoList.size() > 0 ) {
				dbDao.removeMgsMoveByStatusDate(delteVoList);
			}

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
	 * @param List<MGSMovementMGTVO>  mGSMovementMGTVOs
	 * @exception EventException
	 */
	public void removeMgsMvmtFoundAutoBasic(List<MGSMovementMGTVO>  mGSMovementMGTVOs ) throws EventException{
		try {
			List<MGSMovementMGTVO> delteVoList = new ArrayList<MGSMovementMGTVO>();
			for ( int i=0; i<mGSMovementMGTVOs.size(); i++ ) {
				delteVoList.add(mGSMovementMGTVOs.get(i));
			}

			if ( delteVoList.size() > 0 ) {
				dbDao.removeMgsMvmtFoundAutoData(delteVoList);
			}

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
	 * @param MGSMvmtINVO mgsMvmtINVO
	 * @return  List<MGSMvmtMGTVO>
	 * @exception EventException
	 */
	public List<MGSMvmtMGTVO> searchMGSMovementListBasic(MGSMvmtINVO mgsMvmtINVO) throws EventException {
		try {
			String chssMvmtStsCd = mgsMvmtINVO.getChssMvmtStsCd();
			if(chssMvmtStsCd != null && !chssMvmtStsCd.equals("")){
				chssMvmtStsCd = "'" + chssMvmtStsCd.replaceAll(",", "','") + "'";
				mgsMvmtINVO.setChssMvmtStsCd(chssMvmtStsCd);
			}

			return dbDao.searchMgsMovementListData(mgsMvmtINVO);
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
	 * @param MGSMvmtINVO mGSMvmtINVO
	 * @return  MGSMvmtGroupVO
	 * @exception EventException
	 */
	public  MGSMvmtGroupVO searchMGSMovementHistoryBasic(MGSMvmtINVO mGSMvmtINVO) throws EventException {
		MGSMvmtGroupVO list = new MGSMvmtGroupVO();
		try {


			//----------------------------
			// Chassis Main data retrieve
			//----------------------------
			List<MGSMvmtHistoryMGTVO> agreementList = dbDao.searchMGSMstInfoData(mGSMvmtINVO);


			list.setMgsmvmthistorymgtvo(agreementList);
			agreementList = null;
			//----------------------------
			// Chassis Movement History data retrieve
			//----------------------------
			agreementList = dbDao.searchMGSMovementHistoryData(mGSMvmtINVO);

			list.setMgsmvmthistorymgtvo2(agreementList);

			agreementList = null;
			//----------------------------
			// Chassis Attach data retrieve
			//----------------------------
			agreementList = dbDao.searchMGSAtdtHistoryData(mGSMvmtINVO);

			list.setMgsmvmthistorymgtvo3(agreementList);

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
	 * @param MGSMvmtINVO mGSMvmtINVO
	 * @return  List<MGSMvmtBareMGTVO>
	 * @exception EventException
	 */
	public List<MGSMvmtBareMGTVO> searchMGSBareMvmtBasic(MGSMvmtINVO mGSMvmtINVO) throws EventException {
		try {
			return dbDao.searchMGSBareMvmtData(mGSMvmtINVO);
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
	 * @param MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs
	 * @return  List<MGSMvmtBareMGTVO>
	 * @exception EventException
	 */
	public List<MGSMvmtBareMGTVO> verifyMGSBareMvmtBasic(MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs) throws EventException {
		try {
		    List<MGSMvmtBareMGTVO> tmpVo = new  ArrayList<MGSMvmtBareMGTVO>();
		    MGSMvmtBareMGTVO  mp   = new MGSMvmtBareMGTVO();
		    MGSMvmtBareMGTVO tmp   = new MGSMvmtBareMGTVO();
		    MGSMvmtBareMGTVO tmp2  = new MGSMvmtBareMGTVO();

			for ( int i=0; i<mGSMvmtBareMGTVOs.length; i++ ) {
				tmp = new MGSMvmtBareMGTVO();
				mp = new MGSMvmtBareMGTVO();
				tmp = mGSMvmtBareMGTVOs[i];
				mp.setEqNo(tmp.getEqNo());
				mp.setMvmtDtDay(tmp.getMvmtDtDay());
				mp.setMvmtDtHd(tmp.getMvmtDtHd());
//				dest_yd_cd
				mp.setDestYdCd(tmp.getDestYdCd());
				mp.setChssNo(tmp.getChssNo());
				log.debug(".getIbflag()==============================="+tmp.getIbflag());
				log.debug(" mp.getEqNo : " + mp.getEqNo());
				if(tmp.getIbflag().equals("I") && tmp.getDelChk().equals("1")){
					tmp2 = dbDao.searchMGSBareMvmtVerifyData(mp);
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
	 * @param MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMGSBareMvmtBasic(MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException{
		try {
			// Map object for ETC Data
//			Map<String, String> etcData = new HashMap<String, String>();
			List<MGSMvmtBareMGTVO> updateVoList  = new ArrayList<MGSMvmtBareMGTVO>();
			List<MGSMvmtBareMGTVO> deldateVoList = new ArrayList<MGSMvmtBareMGTVO>();

			for ( int i=0; i<mGSMvmtBareMGTVOs.length; i++ ) {
				mGSMvmtBareMGTVOs[i].setUpdUsrId(account.getUsr_id());
				log.debug("getIbflag===="+mGSMvmtBareMGTVOs[i].getIbflag());
				if(mGSMvmtBareMGTVOs[i].getIbflag().equals("U")){
					updateVoList.add(mGSMvmtBareMGTVOs[i]);
				} else if(mGSMvmtBareMGTVOs[i].getIbflag().equals("D")){
					deldateVoList.add(mGSMvmtBareMGTVOs[i]);
				}
			}

			log.debug("deldateVoList===="+deldateVoList.size());
			// Chassis movement UPDATE
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMGSMovementData(updateVoList);
			}
			// Chassis movement DELETE
			if ( deldateVoList.size() > 0 ) {
				dbDao.removeMGSMovementData(deldateVoList);
			}

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
	 * @param MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMGSBareMvmtBasic(MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException{
		try {
			// Map object for ETC Data
//			Map<String, String> etcData = new HashMap<String, String>();
			List<MGSMvmtBareMGTVO> indateVoList  = new ArrayList<MGSMvmtBareMGTVO>();

			for ( int i=0; i<mGSMvmtBareMGTVOs.length; i++ ) {
				mGSMvmtBareMGTVOs[i].setUpdUsrId(account.getUsr_id());
				mGSMvmtBareMGTVOs[i].setCreUsrId(account.getUsr_id());
				mGSMvmtBareMGTVOs[i].setMnlInpFlg("Y");
				log.debug("getIbflag===="+mGSMvmtBareMGTVOs[i].getIbflag());
				if(mGSMvmtBareMGTVOs[i].getIbflag().equals("I") ){
					indateVoList.add(mGSMvmtBareMGTVOs[i]);
				}
			}

			// Chassis movement UPDATE 
			if ( indateVoList.size() > 0 ) {
				 dbDao.addMGSBareMvmtData(indateVoList);
			}

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
	 * @param List<MGSMovementMGTVO> mGSMovementMGTVOs
	 * @exception EventException
	 */
	public void createMGSOnhireMvmtBasic(List<MGSMovementMGTVO> mGSMovementMGTVOs ) throws EventException {
		try {
			if ( mGSMovementMGTVOs.size() > 0 ) {
				dbDao.addMGSXXMvmtData(mGSMovementMGTVOs);
			}

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

			MGSMovementMGTVO mp = new MGSMovementMGTVO();
			IFMnrFlagVO          iFMnrVo = new IFMnrFlagVO();
			List<MGSMovementMGTVO>  mgsetMovementMGTVOs = new ArrayList<MGSMovementMGTVO>();
			
			mp = new MGSMovementMGTVO();
			iFMnrVo = iFMnrFlagVO;
			//sts_evnt_dt

			mp.setChssNo(iFMnrVo.getEqNo());
			mp.setMvmtDt(iFMnrVo.getFlagDt());
			mp.setYdCd(iFMnrVo.getFlagYdCd());
			mp.setMgstOwnrCoCd("H");
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
			mgsetMovementMGTVOs.add(mp);
			
			dbDao.addMnrRetirementData(mgsetMovementMGTVOs);

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
	public String  manageMGSMovementByCtmBasic(List<CusCtmMovementVO> cusCtmMovementVOs){
		MgsetMovementHistoryMGSMovementByCtmBackEndJob backEndResult = new MgsetMovementHistoryMGSMovementByCtmBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setSearchEDIErrorVO(cusCtmMovementVOs);
		CusCtmMovementVO cus = cusCtmMovementVOs.get(0);
		return backEndJobManager.execute(backEndResult,cus.getUpdUsrId(), "FROM CTM to MGS");
	}


	/**
	 *  Chassis Movement editing operation SAVE  [CTM call]<br>
	 *
	 * @param cusCtmMovementVOs List<CusCtmMovementVO>
	 */
	public void  manageMGSMovementByCtmBatchBasic(List<CusCtmMovementVO> cusCtmMovementVOs) {
		try {
			log.debug("manageCHSMovementByCtmBatchBasic==  start "+cusCtmMovementVOs.size());
			ChassisMgsetOnOffhireBC chs = new ChassisMgsetOnOffhireBCImpl();

			ChassisMgsetAttachDetachHistoryBC atdt = new ChassisMgsetAttachDetachHistoryBCImpl();

			CHSMasterMGTVO          cHSMasterMGTVO    = null;
			CusCtmMovementVO        cusCtmMovementVO  = null;
			List<MGSMvmtBareMGTVO>  mGSMvmtBareMGTVOs = null;
			MGSMvmtBareMGTVO        mGSMvmtBareMGTVO  = null;
			MGSAtdtHistoryMGTVO     mGSAtdtHistoryMGTVO = null;
			MGSAtdtHistoryMGTVO     chkAtdtHistoryMGTVO = null;
			MGSAtchDtchHisMGTVO     cgmEqAtchDtchHisMGTVO = null;

			List<MGSCNTRMvmtMGTVO>     cNTRMvmtMGTVOs    = new ArrayList<MGSCNTRMvmtMGTVO>();
			MGSCNTRMvmtMGTVO           cNTRMvmtMGTVO     = null;
			MGSCNTRMvmtMGTVO           cNTRMvmtMGTVO2    = null;
			MGSCNTRMvmtMGTVO           cNTRMvmtINVO      = null;


			String                  sGmtDt            = "";

			String                  mvmtStsCd         = "";
//			String                  chssNo            = "";
			String                  chkFlag           = "";

			String                  sLagDt            = "";
			String                  sLeadDt           = "";
			String                  sLagDtYd          = "";
			String                  sLeadDtYd         = "";
			String                  sAtchdt           = "";
			String                  mgstNo            = "";
			String                  mgstType          = "";
			
			log.debug("TOTAL================================================" + cusCtmMovementVOs.size());
			for(int i=0;i<cusCtmMovementVOs.size();i++){

				cusCtmMovementVO  = new CusCtmMovementVO();

				cusCtmMovementVO = cusCtmMovementVOs.get(i);
				chkFlag          = cusCtmMovementVO.getIbflag();
				log.debug("mgstNo ===========|cusCtmMovementVO|getCnmvYr|================="+cusCtmMovementVO.getCnmvYr());
				log.debug("mgstNo ===========|cusCtmMovementVO|getMgstNo|================="+cusCtmMovementVO.getMgstNo());
	
				if(chkFlag == null){
					chkFlag      = "";
				}

				log.debug("cusCtmMovementVO.chkFlag()==="+chkFlag);
				log.debug("cusCtmMovementVO.chkFlag()=i="+i);
				log.debug("cusCtmMovementVO.getUpdUsrId()========="+cusCtmMovementVO.getUpdUsrId());


				if(chkFlag.equals("C") || chkFlag.equals("I")|| chkFlag.equals("")){
					cNTRMvmtMGTVOs    = new ArrayList<MGSCNTRMvmtMGTVO>();

					mvmtStsCd = cusCtmMovementVO.getMvmtStsCd().trim();
//					chssNo    = cusCtmMovementVO.getChssNo();
					mgstNo    = cusCtmMovementVO.getMgstNo();
					if(mgstNo == null){
						mgstNo ="";
					}

					log.debug("cusCtmMovementVO.getMvmtStsCd()==="+cusCtmMovementVO.getMvmtStsCd());
					log.debug("cusCtmMovementVO.getCnmvEvntDt()==="+cusCtmMovementVO.getCnmvEvntDt());

					// CGM Chassis Movement History update
					cNTRMvmtMGTVO = new MGSCNTRMvmtMGTVO();
//					cNTRMvmtMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
					cNTRMvmtMGTVO.setMgstNo(cusCtmMovementVO.getMgstNo());
					cNTRMvmtMGTVO.setMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setCnmvEvntDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setOrgYdCd(cusCtmMovementVO.getOrgYdCd());
					cNTRMvmtMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());
					cNTRMvmtMGTVO.setMvmtRsnCd(cusCtmMovementVO.getMvmtStsCd());
					cNTRMvmtMGTVO.setMvmtStsCd(cusCtmMovementVO.getMvmtStsCd().trim());
//					cNTRMvmtMGTVO.setIoBndCd(cusCtmMovementVO.getObCntrFlg()); // 
					cNTRMvmtMGTVO.setVndrSeq(cusCtmMovementVO.getVndrSeq());
					cNTRMvmtMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
					cNTRMvmtMGTVO.setCnmvRmk(""); // 
					cNTRMvmtMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
					cNTRMvmtMGTVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
					cNTRMvmtMGTVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());
					cNTRMvmtMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setBkgNo(cusCtmMovementVO.getBkgNo());
					cNTRMvmtMGTVO.setCntrTpszCd(cusCtmMovementVO.getCntrTpszCd());


					if(mgstNo.equals("")&& (mvmtStsCd.equals("VL") || mvmtStsCd.equals("EN")|| mvmtStsCd.equals("CE")) ){
						// sql 
						cNTRMvmtMGTVO2 = dbDao.checkMgsBareMvmtByCtmData(cusCtmMovementVO);

						if(cNTRMvmtMGTVO2 != null){
							if(cNTRMvmtMGTVO2.getMvmtDt1().equals(cNTRMvmtMGTVO2.getMvmtDt2())){
								// data exist -> a.mvmtdt = b.mbmtdt
								cNTRMvmtMGTVO.setMvmtRsnCd("CT"+mvmtStsCd);
								cNTRMvmtMGTVO.setMvmtStsCd("BR");
								cNTRMvmtMGTVO.setMgstNo(cNTRMvmtMGTVO2.getMgstNo());
							} else {
								cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
							}
						} else {
							cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
						}

					} else { 
						cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
					}

					
					
					log.debug("cusCtmMovementVO.getUpdUsrId()========="+cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVOs.add(cNTRMvmtMGTVO);
					
					cNTRMvmtINVO = new MGSCNTRMvmtMGTVO();
					if(cNTRMvmtMGTVO.getMgstNo() !=null && !cNTRMvmtMGTVO.getMgstNo().equals("")){
						log.debug("=====================MGST_NO: "+cusCtmMovementVO.getMgstNo());
						log.debug("=====================SEQ: "+ i);
						dbDao.addMGSMovementData(cNTRMvmtMGTVOs);
						
						mgstType = dbDao.searchMgsetTypeData(cNTRMvmtMGTVO.getMgstNo());

						chkAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();
						
						
						cNTRMvmtINVO.setEqTpszCd(mgstType);
						cNTRMvmtINVO.setMgstNo(cNTRMvmtMGTVO.getMgstNo());
						cNTRMvmtINVO.setMvmtDt(cNTRMvmtMGTVO.getMvmtDt());
						
					}

					

//					String sChssNo = null;
//
//					sChssNo = cusCtmMovementVO.getChssNo();
//					if(sChssNo == null){
//						sChssNo = "";
//					}
					cNTRMvmtINVO.setCntrNo(cusCtmMovementVO.getCntrNo());
					cNTRMvmtINVO.setChssNo(cusCtmMovementVO.getChssNo());
					chkAtdtHistoryMGTVO = dbDao.checkMGSAtdtData(cNTRMvmtINVO);
					
					String sMgstNo = null;

					sMgstNo = cusCtmMovementVO.getMgstNo();
					if(sMgstNo == null){
						sMgstNo = "";
					}


				
					if(chkAtdtHistoryMGTVO != null){
						if((chkAtdtHistoryMGTVO.getDtchYdCd() == null || chkAtdtHistoryMGTVO.getDtchYdCd().equals("")) )
						{
							if(!chkAtdtHistoryMGTVO.getEqNo().equals(sMgstNo)){
								mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();

								mGSAtdtHistoryMGTVO.setAt("DT");
								mGSAtdtHistoryMGTVO.setEqNo(chkAtdtHistoryMGTVO.getEqNo());
								mGSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt() ); // modification
								mGSAtdtHistoryMGTVO.setDtchYdCd(cusCtmMovementVO.getOrgYdCd());
								mGSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								mGSAtdtHistoryMGTVO.setChssNo(cusCtmMovementVO.getChssNo());

								atdt.manageMGSAtdtByCtmBasic(mGSAtdtHistoryMGTVO);
							}
						}
					}


					if(!cNTRMvmtMGTVO.getMvmtStsCd().equals("BR")
							&& !sMgstNo.equals("")) // chungpa 20130315 add
					{
						chkAtdtHistoryMGTVO = dbDao.checkMGSAtchEqData(cNTRMvmtINVO);
						
						if(chkAtdtHistoryMGTVO != null){
							if("CLG".equals(mgstType)){
								if(!chkAtdtHistoryMGTVO.getCntrNo().equals(cNTRMvmtMGTVO.getCntrNo())){
									atdt.manageMGSDetachByMgstBasic(cNTRMvmtMGTVO);
									// no condition
									mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();

									mGSAtdtHistoryMGTVO.setAt("AT");
									mGSAtdtHistoryMGTVO.setEqNo(cusCtmMovementVO.getMgstNo());
									mGSAtdtHistoryMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
									mGSAtdtHistoryMGTVO.setAtchDt(cusCtmMovementVO.getCnmvEvntDt()); // modification
									mGSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
									mGSAtdtHistoryMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
									mGSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
									mGSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());

									atdt.manageMGSAtdtByCtmBasic(mGSAtdtHistoryMGTVO);
								}
							}else if("UMG".equals(mgstType)){
								
								if(!chkAtdtHistoryMGTVO.getChssNo().equals(cNTRMvmtMGTVO.getChssNo())){
									atdt.manageMGSDetachByMgstBasic(cNTRMvmtMGTVO);
									// no condition
									mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();

									mGSAtdtHistoryMGTVO.setAt("AT");
									mGSAtdtHistoryMGTVO.setEqNo(cusCtmMovementVO.getMgstNo());
									mGSAtdtHistoryMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
									mGSAtdtHistoryMGTVO.setAtchDt(cusCtmMovementVO.getCnmvEvntDt()); // modification
									mGSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
									mGSAtdtHistoryMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
									mGSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
									mGSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());

									atdt.manageMGSAtdtByCtmBasic(mGSAtdtHistoryMGTVO);
								}
							}
						}else{
							// no condition
							mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();

							mGSAtdtHistoryMGTVO.setAt("AT");
							mGSAtdtHistoryMGTVO.setEqNo(cusCtmMovementVO.getMgstNo());
							mGSAtdtHistoryMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
							mGSAtdtHistoryMGTVO.setAtchDt(cusCtmMovementVO.getCnmvEvntDt()); // modification
							mGSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
							mGSAtdtHistoryMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
							mGSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							mGSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());

							atdt.manageMGSAtdtByCtmBasic(mGSAtdtHistoryMGTVO);
							
						}
					}

					// * Damage Unflaggin 
			        // 
					//
					// CGM Equipment update
			        //  :crnt_yd, crnt_loc,dst_yd_cd, mvmt_dat information update
					// Master data update
					cHSMasterMGTVO    = new CHSMasterMGTVO();
					cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getMgstNo());
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
						chs.modifyMGSCgmEquipmentBasic(cHSMasterMGTVO);
					}

					// sql 
					log.debug("cNTRMvmtMGTVO.getMvmtStsCd()================"+cNTRMvmtMGTVO.getMvmtStsCd());
					if(cNTRMvmtMGTVO.getMvmtStsCd().equals("OP") || cNTRMvmtMGTVO.getMvmtStsCd().equals("CP")){
						cNTRMvmtMGTVO2 = null;
						cNTRMvmtMGTVO2 = dbDao.checkMgsBareMvmtByopocData(cusCtmMovementVO);

						//String                  sGmtDt              = "";
						if(cNTRMvmtMGTVO2!= null && (cNTRMvmtMGTVO2.getMvmtDt1().equals(cNTRMvmtMGTVO2.getMvmtDt2()) && !cNTRMvmtMGTVO2.getMgstNo().equals(cusCtmMovementVO.getMgstNo())  ))
						{
							mGSMvmtBareMGTVOs = new ArrayList<MGSMvmtBareMGTVO>();

							mGSMvmtBareMGTVO = new MGSMvmtBareMGTVO();
							cusCtmMovementVO = cusCtmMovementVOs.get(i);

							mGSMvmtBareMGTVO.setEqNo(cNTRMvmtMGTVO2.getMgstNo());

							sGmtDt = cusCtmMovementVO.getCnmvEvntDt().replaceAll("-", "");
							sGmtDt = sGmtDt.replaceAll(":", "");
							sGmtDt = sGmtDt.replaceAll(" ", "");

							mGSMvmtBareMGTVO.setMvmtDtDay(sGmtDt.substring(0,8));
							mGSMvmtBareMGTVO.setMvmtDtHd(sGmtDt.substring(8,sGmtDt.length()));
							mGSMvmtBareMGTVO.setMvmtStsCd("BR");
							mGSMvmtBareMGTVO.setYdCd(cusCtmMovementVO.getOrgYdCd());   // 
							mGSMvmtBareMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());

							mGSMvmtBareMGTVO.setVndrAbbrNm(cusCtmMovementVO.getVndrSeq());
							mGSMvmtBareMGTVO.setMvmtRsnCd("CT"+cNTRMvmtMGTVO.getMvmtStsCd());
							mGSMvmtBareMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
							//cHSMvmtBareMGTVO.setMvmtCoCd(cusCtmMovementVO.getmvmtc)   // 
							mGSMvmtBareMGTVO.setDiffRmk("");
							mGSMvmtBareMGTVO.setMnlInpFlg("N");
							mGSMvmtBareMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
							mGSMvmtBareMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							mGSMvmtBareMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
							mGSMvmtBareMGTVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
							mGSMvmtBareMGTVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());

							mGSMvmtBareMGTVOs.add(mGSMvmtBareMGTVO);
							// Bare Movement 
							if(mGSMvmtBareMGTVO.getEqNo() != null && !mGSMvmtBareMGTVO.getEqNo().equals("")){
								dbDao.addMGSBareMvmtData(mGSMvmtBareMGTVOs);
							}
							mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();

							mGSAtdtHistoryMGTVO.setAt("DT");
							mGSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getMgstNo()); //
							mGSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt()); // modification
							mGSAtdtHistoryMGTVO.setDtchYdCd(cusCtmMovementVO.getOrgYdCd());
							mGSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							mGSAtdtHistoryMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
							if(mGSMvmtBareMGTVO.getEqNo() != null && !mGSMvmtBareMGTVO.getEqNo().equals("")){
								atdt.manageMGSAtdtByCtmBasic(mGSAtdtHistoryMGTVO);
							}

							// movement editiong -> master update
							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getMgstNo());
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							log.debug("cHSMasterMGTVO.getEqNo()================");
							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								log.debug("cHSMasterMGTVO.getEqNo()==========333====="+cHSMasterMGTVO.getEqNo());
								chs.modifyMGSCgmEquipmentBasic(cHSMasterMGTVO);
							}
						}
					}
				// END Row  data
				// start Row  data  update , delete
				} else {
					cNTRMvmtMGTVOs    = new ArrayList<MGSCNTRMvmtMGTVO>();
					//
					// CGM Mgset Movement History update
					cNTRMvmtMGTVO = new MGSCNTRMvmtMGTVO();
					cNTRMvmtMGTVO.setMgstNo(cusCtmMovementVO.getMgstNo());
					cNTRMvmtMGTVO.setCnmvEvntDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setOrgYdCd(cusCtmMovementVO.getOrgYdCd());
					cNTRMvmtMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());
					cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
					cNTRMvmtMGTVO.setMvmtStsCd(cusCtmMovementVO.getMvmtStsCd().trim());
//					cNTRMvmtMGTVO.setIoBndCd(cusCtmMovementVO.getObCntrFlg()); //
					cNTRMvmtMGTVO.setVndrSeq(cusCtmMovementVO.getVndrSeq());
					cNTRMvmtMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
					cNTRMvmtMGTVO.setCnmvRmk(""); //
					cNTRMvmtMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
					cNTRMvmtMGTVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
					cNTRMvmtMGTVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());
					cNTRMvmtMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setBkgNo(cusCtmMovementVO.getBkgNo());

					mvmtStsCd = cusCtmMovementVO.getMvmtStsCd().trim();
//					chssNo    = cusCtmMovementVO.getChssNo();
					mgstNo    = cusCtmMovementVO.getMgstNo();


					log.debug("mgstNo ===========||getCnmvYr|================="+cusCtmMovementVO.getCnmvYr());
					log.debug("mgstNo ===========||getCnmvIdNo|================="+cusCtmMovementVO.getCnmvIdNo());
					//insert ctm mvmt PK, Chassis Mvmt table retrieve
					cNTRMvmtMGTVO2 = dbDao.searchMgsChssMvmtHisData(cusCtmMovementVO);

					// start Row  data가  update
					if(chkFlag.equals("U") ){
						if(mgstNo == null){
							mgstNo ="";
						}

						// Start Chss_no null -> Mvmt existing -> data deleting
						if(mgstNo.equals("")){
							// sql 

							if(cNTRMvmtMGTVO2 != null){
								// Movement data deleting
								dbDao.removeCgmMgstMvmtHisData(cusCtmMovementVO);

								// Attach detach data  deleting

								mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();
								List<MGSAtdtHistoryMGTVO> deldateVoList = new ArrayList<MGSAtdtHistoryMGTVO>();
								mGSAtdtHistoryMGTVO.setIbflag("D");
								mGSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getMgstNo());
								mGSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt() ); // modification
								mGSAtdtHistoryMGTVO.setEqKndCd("G");
								mGSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								mGSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO2.getChssNo());
								deldateVoList.add(mGSAtdtHistoryMGTVO);

								cgmEqAtchDtchHisMGTVO = dbDao.searchCgmEqAtchDtchHisData(mGSAtdtHistoryMGTVO);
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
								atdt.manageMGSAtdtByMvmtBasic(deldateVoList);
								// AtDt update
								if(sAtchdt.equals(sLagDt) && sAtchdt.equals(sLeadDt)){
									mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();
									mGSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getMgstNo());
									mGSAtdtHistoryMGTVO.setAtchDt(sLagDt); // modification
									mGSAtdtHistoryMGTVO.setDtchYdCd(sLeadDtYd);
									mGSAtdtHistoryMGTVO.setDtchDt(sLeadDt);
									//cHSAtdtHistoryMGTVO.setDtchInpTpCd("A");
									mGSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
									mGSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO2.getChssNo());
									atdt.manageMGSAtdtHistoryBasic(mGSAtdtHistoryMGTVO);
								}

								// Master data update
								cHSMasterMGTVO    = new CHSMasterMGTVO();
								cHSMasterMGTVO.setEqNo(cNTRMvmtMGTVO2.getMgstNo());
//								cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//								cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//								cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////								cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     // 
//								cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); //
//								cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); //
//								cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  //
								cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());

								if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
									chs.modifyMGSCgmEquipmentBasic(cHSMasterMGTVO);
								}
							}
						// End Chss_no null -> Mvmt existing -> data delete
						// Start Chss_no is not null
						} else {
							cNTRMvmtMGTVOs.add(cNTRMvmtMGTVO);
							log.debug("mgstNo ===========|||||||||||||================="+mgstNo);
							log.debug("mgstNo ===========||||cusCtmMovementVO.getVndrSeq()================="+cusCtmMovementVO.getVndrSeq());
							log.debug("mgstNo ===========|||||||||||||================="+cNTRMvmtMGTVO2);
							if(cNTRMvmtMGTVO2 != null){


								log.debug("ccNTRMvmtMGTVO2.getMvmtDt()=================="+cNTRMvmtMGTVO2.getMvmtDt());

							 // Attach detach data  deleting

								mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();
								List<MGSAtdtHistoryMGTVO> deldateVoList = new ArrayList<MGSAtdtHistoryMGTVO>();
								mGSAtdtHistoryMGTVO.setIbflag("D");
								mGSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getMgstNo());
								mGSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt() ); // modification
								mGSAtdtHistoryMGTVO.setEqKndCd("G");
								mGSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO2.getChssNo());
								deldateVoList.add(mGSAtdtHistoryMGTVO);

								cgmEqAtchDtchHisMGTVO = dbDao.searchCgmEqAtchDtchHisData(mGSAtdtHistoryMGTVO);
								if(cgmEqAtchDtchHisMGTVO != null){
									sLagDt     = cgmEqAtchDtchHisMGTVO.getLagDt();
									sLeadDt    = cgmEqAtchDtchHisMGTVO.getLeadDt();
									sLagDtYd   = cgmEqAtchDtchHisMGTVO.getLagDtYd();
									sLeadDtYd  = cgmEqAtchDtchHisMGTVO.getLeadDtYd();
									sAtchdt    = cgmEqAtchDtchHisMGTVO.getAtchDt();
								}


								if(!mgstNo.equals(cNTRMvmtMGTVO2.getMgstNo()) || !cNTRMvmtMGTVO2.getMvmtDt().substring(0,12).equals(cusCtmMovementVO.getCnmvEvntDt().substring(0,12))){
							    	// Movement data deleting
									dbDao.removeCgmMgstMvmtHisData(cusCtmMovementVO);
									// new insert
									dbDao.addMGSMovementData(cNTRMvmtMGTVOs);



									mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();
									List<MGSAtdtHistoryMGTVO> insdateVoList = new ArrayList<MGSAtdtHistoryMGTVO>();
									mGSAtdtHistoryMGTVO.setIbflag("I");
									mGSAtdtHistoryMGTVO.setEqNo(cusCtmMovementVO.getMgstNo());


									mGSAtdtHistoryMGTVO.setEqKndCd("G");
									mGSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO2.getChssNo());
									mGSAtdtHistoryMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
									mGSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
									mGSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
									mGSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());



									mGSAtdtHistoryMGTVO.setIbflag("R");
									log.debug("ccNTRMvmtMGTVO2.getMvmtDt()=================="+cNTRMvmtMGTVO2.getMvmtDt());
									mGSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt());
									mGSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt() );
									log.debug("cHSAtdtHistoryMGTVO.getAtchDt()======================="+mGSAtdtHistoryMGTVO.getAtchDt());
									atdt.manageMGSAtdtPrePostHistoryBasic(mGSAtdtHistoryMGTVO);

									 //  AtDt delete

									atdt.manageMGSAtdtByMvmtBasic(deldateVoList);

									mGSAtdtHistoryMGTVO.setIbflag("I");
									mGSAtdtHistoryMGTVO.setAtchDt(cusCtmMovementVO.getCnmvEvntDt() ); // modification
									insdateVoList.add(mGSAtdtHistoryMGTVO);
									// EQ Attatch/Detach information save(History save)
									atdt.manageMGSAtdtByMvmtBasic(insdateVoList);



							    } else {
							    	//  Movement data update
							    	dbDao.modifyCgmMgstMvmtHisData(cNTRMvmtMGTVO);
							    	if(sLagDt == null) sLagDt ="";
									if(sLeadDt == null) sLeadDt ="";
									if(sLagDtYd == null) sLagDtYd ="";
									if(sLeadDtYd == null) sLeadDtYd ="";
									if(sAtchdt == null) sAtchdt = "";

									// AtDt update
									if(cgmEqAtchDtchHisMGTVO != null && sAtchdt.equals(sLagDt) && sAtchdt.equals(sLeadDt)){

										mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();
										mGSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getMgstNo());
										mGSAtdtHistoryMGTVO.setAtchDt(sLagDt); // modification
//										cHSAtdtHistoryMGTVO.setDtchYdCd(sLeadDtYd);
//									    cHSAtdtHistoryMGTVO.setDtchDt(sLeadDt);
										mGSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
										mGSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO2.getChssNo());
										atdt.manageMGSAtdtHistoryBasic(mGSAtdtHistoryMGTVO);
									}
							    }
							} else {
								log.debug("cNTRMvmtMGTVO==getMvmtRsnCd=====U========="+cNTRMvmtMGTVO.getMvmtRsnCd());
								mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();
								List<MGSAtdtHistoryMGTVO> insdateVoList = new ArrayList<MGSAtdtHistoryMGTVO>();
								mGSAtdtHistoryMGTVO.setIbflag("I");
								mGSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO.getMgstNo());
								mGSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO.getMvmtDt() ); // modification
								mGSAtdtHistoryMGTVO.setEqKndCd("G");
								mGSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO.getChssNo());
								mGSAtdtHistoryMGTVO.setCntrNo(cNTRMvmtMGTVO.getCntrNo());
								mGSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								mGSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
								mGSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());



								insdateVoList.add(mGSAtdtHistoryMGTVO);
								atdt.manageMGSAtdtByMvmtBasic(insdateVoList);

								dbDao.addMGSMovementData(cNTRMvmtMGTVOs);
							}



							// Master data update
							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getMgstNo());
//							cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//							cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//							cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////							cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  
//							cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); //
//							cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); //
//							cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  //
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());

							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								chs.modifyMGSCgmEquipmentBasic(cHSMasterMGTVO);
							}
						}
						// end Chss_no is not null
				    // ENd Row  data가  update
					// start Row  data가    delete
					} else {  // 
						if(!mgstNo.equals("")){
							// Movement data delete
							dbDao.removeCgmMgstMvmtHisData(cusCtmMovementVO);

							// Attach detach data  deleting

							mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();
							List<MGSAtdtHistoryMGTVO> deldateVoList = new ArrayList<MGSAtdtHistoryMGTVO>();
							mGSAtdtHistoryMGTVO.setIbflag("D");
							mGSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO.getMgstNo());
							mGSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO.getCnmvEvntDt() ); // modification
							mGSAtdtHistoryMGTVO.setEqKndCd("G");
							mGSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO.getChssNo());
							deldateVoList.add(mGSAtdtHistoryMGTVO);
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

								mGSAtdtHistoryMGTVO.setIbflag("N");
								mGSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO.getMgstNo());
								mGSAtdtHistoryMGTVO.setCntrNo(cNTRMvmtMGTVO.getCntrNo());
								mGSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
								mGSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								mGSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO.getChssNo());
								atdt.manageMGSAtdtPrePostHistoryBasic(mGSAtdtHistoryMGTVO);


							    //  AtDt deleting
								atdt.manageMGSAtdtByMvmtBasic(deldateVoList);
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
							cHSMasterMGTVO.setEqNo(cNTRMvmtMGTVO.getMgstNo());
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
								chs.modifyMGSCgmEquipmentBasic(cHSMasterMGTVO);
							}

						} else {


							// Movement data deleting
							dbDao.removeCgmMgstMvmtHisData(cusCtmMovementVO);

							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getMgstNo());
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							// Eq Master information edit
							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								chs.modifyMGSCgmEquipmentBasic(cHSMasterMGTVO);
							}
						}
					}
				}
				// END Row  data  update , delete
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			log.debug("manageMGSMovementByCtmBasic===           end ");
//			throw new EventException(de.getMessage());
//			return cusCtmMovementVOs;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			log.debug("manageMGSMovementByCtmBasic===           end ");
//			throw new EventException(de.getMessage());
//			return cusCtmMovementVOs;
		}
		log.debug("manageMGSMovementByCtmBasic===           end ");

	}


	/**
	 *  Bare Movement handling operation SAVE  [CTM call]<br>
	 *
	 * @param flatFileForGateNewVO FlatFileForGateNewVO
	 * @return String[]
	 */
	public String[]  manageMGSMovementBareByGatenewBasic(FlatFileForGateNewVO flatFileForGateNewVO) throws EventException{
		String[]                sErr                = new String[2];
		try {

			ChassisMgsetAttachDetachHistoryBC atdt = new ChassisMgsetAttachDetachHistoryBCImpl();
			ChassisMgsetOnOffhireBC chs = new ChassisMgsetOnOffhireBCImpl();

			List<MGSMvmtBareMGTVO>  mGSMvmtBareMGTVOs   = null;
			MGSMvmtBareMGTVO        mGSMvmtBareMGTVO    = null;
			MGSAtdtHistoryMGTVO     mGSAtdtHistoryMGTVO = null;
			String                  sGmtDt              = "";
			String                  sContr_no           = "";
//			String                  sChss_code          = "";
			String                  sMg_set             = "";
			boolean                 chk                 = true;
			mGSMvmtBareMGTVOs = new ArrayList<MGSMvmtBareMGTVO>();

			mGSMvmtBareMGTVO = new MGSMvmtBareMGTVO();
			sContr_no        = flatFileForGateNewVO.getCntrNumber();
//			sChss_code       = flatFileForGateNewVO.getChssCode();
			sMg_set          = flatFileForGateNewVO.getMgSet();


			if(sMg_set != null && !sMg_set.equals("")){
				sContr_no  = flatFileForGateNewVO.getMgSet();
				chk        = false;
				sMg_set = flatFileForGateNewVO.getCntrNumber();
			}


			log.debug("sContr_no==="+sContr_no);
			log.debug("sMg_set==="+sMg_set);



			mGSMvmtBareMGTVO.setEqNo(sContr_no);
			sGmtDt = flatFileForGateNewVO.getEventDate().trim();

			mGSMvmtBareMGTVO.setMvmtDtDay(sGmtDt.substring(0,8));
			mGSMvmtBareMGTVO.setMvmtDtHd(sGmtDt.substring(8,sGmtDt.length()));

			mGSMvmtBareMGTVO.setYdCd(flatFileForGateNewVO.getEventYard());   //
//				cHSMvmtBareMGTVO.setDestYdCd(flatFileVOForGateNew.getDestYdCd());
			if(chk == true){
				if(flatFileForGateNewVO.getMvmtStatus().trim().equals("BI")){
					mGSMvmtBareMGTVO.setGateIoCd("I");
				} else {
					mGSMvmtBareMGTVO.setGateIoCd("O");
				}

				mGSMvmtBareMGTVO.setMvmtStsCd(flatFileForGateNewVO.getMvmtStatus());
			} else {
				if(flatFileForGateNewVO.getGateIo().trim().equals("A") || flatFileForGateNewVO.getGateIo().trim().equals("I")|| flatFileForGateNewVO.getGateIo().trim().equals("N")
				|| flatFileForGateNewVO.getGateIo().trim().equals("AR")|| flatFileForGateNewVO.getGateIo().trim().equals("UR")
				 ){
					mGSMvmtBareMGTVO.setGateIoCd("I");
					mGSMvmtBareMGTVO.setMvmtStsCd("BI");
				}
				if(flatFileForGateNewVO.getGateIo().trim().equals("AL") || flatFileForGateNewVO.getGateIo().trim().equals("AO")|| flatFileForGateNewVO.getGateIo().trim().equals("D")
			    || flatFileForGateNewVO.getGateIo().trim().equals("OA")|| flatFileForGateNewVO.getGateIo().trim().equals("P")|| flatFileForGateNewVO.getGateIo().trim().equals("RL")|| flatFileForGateNewVO.getGateIo().trim().equals("O")
				){

					mGSMvmtBareMGTVO.setGateIoCd("O");
					mGSMvmtBareMGTVO.setMvmtStsCd("BO");
				}
				mGSMvmtBareMGTVO.setCntrNo(sMg_set);
//				cHSMvmtBareMGTVO.setMvmtStsCd(flatFileForGateNewVO.getMvmtStatus());
			}

			log.debug("getMvmtStatus==="+flatFileForGateNewVO.getMvmtStatus());
			log.debug("getGateIo==="+flatFileForGateNewVO.getGateIo());
			log.debug("getGateIoCd==="+mGSMvmtBareMGTVO.getGateIoCd());
			mGSMvmtBareMGTVO.setVndrAbbrNm(flatFileForGateNewVO.getVndrSeq());
			mGSMvmtBareMGTVO.setMvmtRsnCd("CHPO");
			mGSMvmtBareMGTVO.setMgstNo(flatFileForGateNewVO.getMgSet());
			//cHSMvmtBareMGTVO.setMvmtCoCd(cusCtmMovementVO.getmvmtc)   //
			mGSMvmtBareMGTVO.setDiffRmk("");
			mGSMvmtBareMGTVO.setMnlInpFlg("N");
			
			mGSMvmtBareMGTVO.setCreUsrId(flatFileForGateNewVO.getUserId());
			mGSMvmtBareMGTVO.setUpdUsrId(flatFileForGateNewVO.getUserId());

			mGSMvmtBareMGTVOs.add(mGSMvmtBareMGTVO);
			// Bare Movement handling
		 	dbDao.addMGSBareMvmtData(mGSMvmtBareMGTVOs);
		 	if(chk == true){
				mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();

				mGSAtdtHistoryMGTVO.setAt("DT");
				mGSAtdtHistoryMGTVO.setEqNo(sContr_no);
				mGSAtdtHistoryMGTVO.setDtchDt(sGmtDt); // modification
				mGSAtdtHistoryMGTVO.setDtchYdCd(flatFileForGateNewVO.getEventYard());
				//cHSAtdtHistoryMGTVO.setDtchInpTpCd("A");
				mGSAtdtHistoryMGTVO.setUpdUsrId(flatFileForGateNewVO.getUserId());


			 	atdt.manageMGSAtdtByCtmBasic(mGSAtdtHistoryMGTVO);
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
				chs.modifyMGSCgmEquipmentBasic(cHSMasterMGTVO);
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
	 * @param MGSmgstChkINVO mGSmgstChkINVO
	 * @return List<MGSmgstChkINVO>
	 * @throws EventException
	 */
	public List<MGSmgstChkINVO>  searchmgstAtdtVerifyBasic(MGSmgstChkINVO mGSmgstChkINVO) throws EventException{
		try {

			return dbDao.searchmgstAtdtVerifyList(mGSmgstChkINVO);
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
	 * @param MGSmgstChkINVO mGSmgstChkINVO
	 * @return List<MGSmgstChkINVO>
	 * @throws EventException
	 */
	public List<MGSmgstChkINVO>  searchmgstTpszOnCntrCHkBasic(MGSmgstChkINVO mGSmgstChkINVO) throws EventException{
		try {

			return dbDao.searchmgstTpszOnCntrCHkList(mGSmgstChkINVO);
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

}