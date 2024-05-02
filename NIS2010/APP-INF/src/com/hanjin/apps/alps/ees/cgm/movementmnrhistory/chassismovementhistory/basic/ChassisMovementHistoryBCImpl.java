/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryBCImpl.java
*@FileTitle : test
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.03 최민회
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.01.13 김상수 [CHM-201215565-01] ALPS MNR-Disposal-SLD Management-> SLD Cancellation 보완 요청
*                                      - Disposal Sold Cancelation 화면에서 M.G.Set과 Chassis도 SLD Cancel 가능하도록 CGM연계로직 추가
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBC;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBCImpl;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSAtdtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration.ChassisMovementHistoryDBDAO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSAtchDtchHisMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtBareMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtGroupVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMovementMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSmgstChkINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CNTRMvmtMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.ShipCHSMvmtMGTVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
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
 * @see testEventResponse,ChassisMovementHistoryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ChassisMovementHistoryBCImpl extends BasicCommandSupport implements ChassisMovementHistoryBC {

	// Database Access Object
	private transient ChassisMovementHistoryDBDAO dbDao = null;
	/**
	 * ChassisMovementHistoryBCImpl 객체 생성<br>
	 * ChassisMovementHistoryDBDAO를 생성한다.<br>
	 */
	public ChassisMovementHistoryBCImpl() {
		dbDao = new ChassisMovementHistoryDBDAO();
	}

	/**
	 *  장비 Lost 관련 'XX' movement 를 입력한다.   [EES_CGM_1017,EES_CGM_1009] <br>
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
			//CGM000013 메세지로
//			throw new EventException(new ErrorHandler("CGM000013", new String[]{"createCHSXXMvmt"}).getUserMessage(),ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  장비 Found 관련된 'BI' movement 를 입력한다   [EES_CGM_1017,EES_CGM_1018] <br>
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
	 *  장비 movement 정보를 삭제한다   [EES_CGM_1016] <br>
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
	 *  장비 movement 정보를 삭제한다   [EES_CGM_1016] <br>
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
	 *  장비 movement 정보를 삭제한다   [EES_CGM_1018] <br>
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
	 *  개별 Chassis 별 Movement History 정보 조회   [EES_CGM_1104] <br>
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
	 *  chassismovementhistory 대한 조회 이벤트 처리 [EES_CGM_1105] <br>
	 *
	 * @param cHSMvmtINVO CHSMvmtINVO
	 * @return  CHSMvmtGroupVO
	 * @exception EventException
	 */
	public  CHSMvmtGroupVO searchCHSMovementHistoryBasic(CHSMvmtINVO cHSMvmtINVO) throws EventException {
		CHSMvmtGroupVO list = new CHSMvmtGroupVO();
		try {


			//----------------------------
			// Chassis Main 데이터 조회
			//----------------------------
			List<CHSMvmtHistoryMGTVO> agreementList = dbDao.searchCHSMstInfoData(cHSMvmtINVO);


			list.setChsmvmthistorymgtvo(agreementList);
			agreementList = null;
			//----------------------------
			// Chassis Movement History 데이터 조회
			//----------------------------
			agreementList = dbDao.searchCHSMovementHistoryData(cHSMvmtINVO);

			list.setChsmvmthistorymgtvo2(agreementList);

			agreementList = null;
			//----------------------------
			// Chassis Attach 데이터 조회
			//----------------------------
			agreementList = dbDao.searchCHSAtdtHistoryData(cHSMvmtINVO);

			list.setChsmvmthistorymgtvo3(agreementList);

			// ETCDATA 설정

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
		return list;
	}

	/**
	 *  chassismovementhistory 대한 조회 이벤트 처리 [EES_CGM_1108] <br>
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
	 *  chassismovementhistory 대한 verify  [EES_CGM_1108] <br>
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
	 *  Eq bare movement 를 수정/삭제한다.  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtBareMGTVOs CHSMvmtBareMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSBareMvmtBasic(CHSMvmtBareMGTVO[] cHSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException{
		// Response 객체를 담기위한 Map 객체
		@SuppressWarnings("unused")
		boolean chkPoolMatch = true;
		try {
			// ETC Data 를  담기위한 Map 객체
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
			// Chassis movement 를 UPDATE 수행
			if ( updateVoList.size() > 0 ) {
				chkPoolMatch = dbDao.modifyCHSMovementData(updateVoList);
			}
			// Chassis movement 를 DELETE 수행
			if ( deldateVoList.size() > 0 ) {
				chkPoolMatch = dbDao.removeCHSMovementData(deldateVoList);
			}

//			etcData = CHSMvmtBareMGTVO.getColumnValues();

			// Response Data 설정
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
	 *  EEq bare movement 를 입력.  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtBareMGTVOs CHSMvmtBareMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSBareMvmtBasic(CHSMvmtBareMGTVO[] cHSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException{
		// Response 객체를 담기위한 Map 객체
		@SuppressWarnings("unused")
		boolean chkPoolMatch = true;
		try {
			// ETC Data 를  담기위한 Map 객체
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

			// Chassis movement 를 UPDATE 수행
			if ( indateVoList.size() > 0 ) {
				chkPoolMatch = dbDao.addCHSBareMvmtData(indateVoList);
			}

//			etcData = CHSMvmtBareMGTVO.getColumnValues();

			// Response Data 설정
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
	 *  장비 ON-hire 관련된 'MT' movement  <br>
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
	 *  MNR 으로부터 호출받아 장비의 Retirement 관련 처리. SAVE  [MNR 호출]<br>
	 *
	 * @param iFMnrFlagVOs List<IFMnrFlagVO>
	 * @exception EventException
	 */
	public void createMNRStatusBasic(List<IFMnrFlagVO> iFMnrFlagVOs) throws EventException{
		try {

			CHSMovementMGTVO mp = new CHSMovementMGTVO();
			IFMnrFlagVO          iFMnrVo = new IFMnrFlagVO();
			List<CHSMovementMGTVO>  chassisMovementMGTVOs = new ArrayList<CHSMovementMGTVO>();
			for ( int i=0; i<1; i++ ) {
				mp = new CHSMovementMGTVO();
				iFMnrVo = iFMnrFlagVOs.get(i);
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
			}
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
	 *  Chassis Movement 를 수정하는 오퍼레이션 SAVE  [CTM 호출]<br>
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
	 *  Chassis Movement 을  수정하는 오퍼레이션 SAVE  [CTM 호출]<br>
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

				// start Row  데이터가 추 가
				if(chkFlag.equals("C") || chkFlag.equals("I")|| chkFlag.equals("")){
					cNTRMvmtMGTVOs    = new ArrayList<CNTRMvmtMGTVO>();
					// 기존 로직
					mvmtStsCd = cusCtmMovementVO.getMvmtStsCd().trim();
					chssNo    = cusCtmMovementVO.getChssNo();
					if(chssNo == null){
						chssNo ="";
					}

					log.debug("cusCtmMovementVO.getMvmtStsCd()==="+cusCtmMovementVO.getMvmtStsCd());
					log.debug("cusCtmMovementVO.getCnmvEvntDt()==="+cusCtmMovementVO.getCnmvEvntDt());

					// CGM Chassis Movement History 업데이트
					cNTRMvmtMGTVO = new CNTRMvmtMGTVO();
					cNTRMvmtMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
					cNTRMvmtMGTVO.setMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setCnmvEvntDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setOrgYdCd(cusCtmMovementVO.getOrgYdCd());
					cNTRMvmtMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());
					cNTRMvmtMGTVO.setMvmtRsnCd(cusCtmMovementVO.getMvmtStsCd());
					cNTRMvmtMGTVO.setMvmtStsCd(cusCtmMovementVO.getMvmtStsCd().trim());
//					cNTRMvmtMGTVO.setIoBndCd(cusCtmMovementVO.getObCntrFlg()); // 확인
					cNTRMvmtMGTVO.setVndrSeq(cusCtmMovementVO.getVndrSeq());
					cNTRMvmtMGTVO.setMgstNo(cusCtmMovementVO.getMgstNo());
					cNTRMvmtMGTVO.setCnmvRmk(""); // 확인
					cNTRMvmtMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
					cNTRMvmtMGTVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
					cNTRMvmtMGTVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());
					cNTRMvmtMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setBkgNo(cusCtmMovementVO.getBkgNo());
					cNTRMvmtMGTVO.setCntrTpszCd(cusCtmMovementVO.getCntrTpszCd());

//					- VL,EN,CE & Chss_no=null
//			          & 입력 cntr, 입력 lcc의 최근 Chss_mvmt date == 그 발생내역 chss_no 의 최근 chss mvmt date,
					if(chssNo.equals("")&& (mvmtStsCd.equals("VL") || mvmtStsCd.equals("EN")|| mvmtStsCd.equals("CE")) ){
						// sql 실행
						cNTRMvmtMGTVO2 = dbDao.checkChsBareMvmtByCtmData(cusCtmMovementVO);

						if(cNTRMvmtMGTVO2 != null){
							if(cNTRMvmtMGTVO2.getMvmtDt1().equals(cNTRMvmtMGTVO2.getMvmtDt2())){
								// 데이터 있을떼ㅐ a.mvmtdt = b.mbmtdt
								cNTRMvmtMGTVO.setMvmtRsnCd("CT"+mvmtStsCd);
								cNTRMvmtMGTVO.setMvmtStsCd("BR");
								cNTRMvmtMGTVO.setChssNo(cNTRMvmtMGTVO2.getChssNo());
							} else {
								// 없을때  틀릴경우 같지 않을경우
								cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
							}
						} else {
							// 없을때
							cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
						}

					} else { // 나머지 mvmt_sts_cd = 입력된 cnms_cd 로 입력됨. (Cnms_reason:'CTMV')	(addChsMovement())
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


					// dt 조회  조건 추가
					cNTRMvmtINVO = new CNTRMvmtMGTVO();
					cNTRMvmtINVO.setCntrNo(cusCtmMovementVO.getCntrNo());
					chkAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
					// 콘데이터로  DtchYdCd 체크
					chkAtdtHistoryMGTVO = dbDao.checkCHSAtdtData(cNTRMvmtINVO);

					// chssNo null 경우 처리
					String sChssNo = null;

					sChssNo = cusCtmMovementVO.getChssNo();
					if(sChssNo == null){
						sChssNo = "";
					}


					// dt 조건  yd_cd null 이면서 입력된 eq_no dt 한다
					if(chkAtdtHistoryMGTVO != null){
						if((chkAtdtHistoryMGTVO.getDtchYdCd() == null || chkAtdtHistoryMGTVO.getDtchYdCd().equals("")) )
								{
									// 해당 date 이전의, 해당 Cntr OR Chss 로 attach되어 있는 AT/DT History 는 모두 Detach 처리
									cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();

									cHSAtdtHistoryMGTVO.setAt("DT");
									cHSAtdtHistoryMGTVO.setEqNo(chkAtdtHistoryMGTVO.getEqNo());
									cHSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt() ); // 수정
									cHSAtdtHistoryMGTVO.setDtchYdCd(cusCtmMovementVO.getOrgYdCd());
									cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
									// CTM 으로부터 322 Movement 데이터를 받아 Chassis, M.G.Set Attach/Detach 내역을 처리 한다.
									if(cHSAtdtHistoryMGTVO.getEqNo()!= null && !cHSAtdtHistoryMGTVO.getEqNo().equals("")){
										atdt.manageCHSAtdtByCtmBasic(cHSAtdtHistoryMGTVO);
									}

								}
					}


					// 해당 date 로 At/dt History 에 Insert or Update(Attach # 'BR' 제외)
					if(!cNTRMvmtMGTVO.getMvmtStsCd().equals("BR")
							&& !sChssNo.equals("")) // chungpa 20130315 add
					{
						// at 인지 조건
						log.debug("br 아닌 경우 타고 있니 ");
						cNTRMvmtINVO = new CNTRMvmtMGTVO();
						cNTRMvmtINVO.setCntrNo(cusCtmMovementVO.getCntrNo());

						// 무조건 입력
						cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();

						cHSAtdtHistoryMGTVO.setAt("AT");
						cHSAtdtHistoryMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
						cHSAtdtHistoryMGTVO.setAtchDt(cusCtmMovementVO.getCnmvEvntDt()); // 수정
						cHSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
						cHSAtdtHistoryMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
						cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
						cHSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());

						// CTM 으로부터 322 Movement 데이터를 받아 Chassis, M.G.Set Attach/Detach 내역을 처리 한다.
						//if(cHSAtdtHistoryMGTVO.getEqNo()!= null && !cHSAtdtHistoryMGTVO.getEqNo().equals("")){
							atdt.manageCHSAtdtByCtmBasic(cHSAtdtHistoryMGTVO);
						//}

					}

					// * Damage Unflaggin 처리
			        // : (CTM 에서 Mnr 함수 콜 하여 Cntr 및 Chss 에 대해 unflaging 처리됨)
					// 개발 할내용
					// CGM Equipment 업데이트
			        //  :crnt_yd, crnt_loc,dst_yd_cd, mvmt_dat 를 최근 정보로 업데이트 처리
					// Master 데이터 update
					cHSMasterMGTVO    = new CHSMasterMGTVO();
					cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
//					cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getDestYdCd());

//					cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//					cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////					cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  확인
//					cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); // 확인
//					cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); // 확인
//					cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  // 확인
					cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
					log.debug("cHSMasterMGTVO.getEqNo()================");
					if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
						log.debug("cHSMasterMGTVO.getEqNo()==========333====="+cHSMasterMGTVO.getEqNo());
						chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
					}

					// sql 실행
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
							cHSMvmtBareMGTVO.setYdCd(cusCtmMovementVO.getOrgYdCd());   // 확인
							cHSMvmtBareMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());

							cHSMvmtBareMGTVO.setVndrAbbrNm(cusCtmMovementVO.getVndrSeq());
							cHSMvmtBareMGTVO.setMvmtRsnCd("CT"+cNTRMvmtMGTVO.getMvmtStsCd());
							cHSMvmtBareMGTVO.setMgstNo(cusCtmMovementVO.getMgstNo());
							//cHSMvmtBareMGTVO.setMvmtCoCd(cusCtmMovementVO.getmvmtc)   // 확인
							cHSMvmtBareMGTVO.setDiffRmk("");
							cHSMvmtBareMGTVO.setMnlInpFlg("N");
							cHSMvmtBareMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
							cHSMvmtBareMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							cHSMvmtBareMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
							cHSMvmtBareMGTVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
							cHSMvmtBareMGTVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());

							cHSMvmtBareMGTVOs.add(cHSMvmtBareMGTVO);
							// Bare Movement 처리
							if(cHSMvmtBareMGTVO.getEqNo() != null && !cHSMvmtBareMGTVO.getEqNo().equals("")){
								dbDao.addCHSBareMvmtData(cHSMvmtBareMGTVOs);
							}
							cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();

							cHSAtdtHistoryMGTVO.setAt("DT");
							cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo()); //
							cHSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt()); // 수정
							cHSAtdtHistoryMGTVO.setDtchYdCd(cusCtmMovementVO.getOrgYdCd());
							cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							// CTM 으로부터 322 Movement 데이터를 받아 Chassis, M.G.Set Attach/Detach 내역을 처리 한다.
							if(cHSMvmtBareMGTVO.getEqNo() != null && !cHSMvmtBareMGTVO.getEqNo().equals("")){
								atdt.manageCHSAtdtByCtmBasic(cHSAtdtHistoryMGTVO);
							}

							// 뮤브먼트 수정시 마스타 업데이트
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
				// END Row  데이터가 추 가
				// start Row  데이터가  update , delete
				} else {
					cNTRMvmtMGTVOs    = new ArrayList<CNTRMvmtMGTVO>();
					//업데이트나 삭제시
					// CGM Chassis Movement History 업데이트
					cNTRMvmtMGTVO = new CNTRMvmtMGTVO();
					cNTRMvmtMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
					cNTRMvmtMGTVO.setCnmvEvntDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setOrgYdCd(cusCtmMovementVO.getOrgYdCd());
					cNTRMvmtMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());
					cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
					cNTRMvmtMGTVO.setMvmtStsCd(cusCtmMovementVO.getMvmtStsCd().trim());
//					cNTRMvmtMGTVO.setIoBndCd(cusCtmMovementVO.getObCntrFlg()); // 확인
					cNTRMvmtMGTVO.setVndrSeq(cusCtmMovementVO.getVndrSeq());
					cNTRMvmtMGTVO.setMgstNo(cusCtmMovementVO.getMgstNo());
					cNTRMvmtMGTVO.setCnmvRmk(""); // 확인
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
					//입력 ctm mvmt PK 로 Chassis Mvmt 테이블 조회
					cNTRMvmtMGTVO2 = dbDao.searchCgmChssMvmtHisData(cusCtmMovementVO);

					// start Row  데이터가  update
					if(chkFlag.equals("U") ){
						if(chssNo == null){
							chssNo ="";
						}

						// Start Chss_no null 이면  기존 Mvmt 존재시  데이터 삭제
						if(chssNo.equals("")){
							// sql 실행

							if(cNTRMvmtMGTVO2 != null){
								// Movement data 삭제
								dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);

								// Attach detach data  삭제
								// 해당 date 이전의, 해당 Cntr OR Chss 로 attach되어 있는 AT/DT History 는 모두 Detach 처리
								cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
								List<CHSAtdtHistoryMGTVO> deldateVoList = new ArrayList<CHSAtdtHistoryMGTVO>();
								cHSAtdtHistoryMGTVO.setIbflag("D");
								cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
								cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt() ); // 수정
								cHSAtdtHistoryMGTVO.setEqKndCd("Z");
								cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());

								deldateVoList.add(cHSAtdtHistoryMGTVO);
								// 조건 필요 업데이트
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

							    //  AtDt 삭제
								atdt.manageCHSAtdtByMvmtBasic(deldateVoList);
								// AtDt 업데이트
								if(sAtchdt.equals(sLagDt) && sAtchdt.equals(sLeadDt)){
									cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
									cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
									cHSAtdtHistoryMGTVO.setAtchDt(sLagDt); // 수정
									cHSAtdtHistoryMGTVO.setDtchYdCd(sLeadDtYd);
									cHSAtdtHistoryMGTVO.setDtchDt(sLeadDt);
									//cHSAtdtHistoryMGTVO.setDtchInpTpCd("A");
									cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
									atdt.manageCHSAtdtHistoryBasic(cHSAtdtHistoryMGTVO);
								}

								// Master 데이터 update
								cHSMasterMGTVO    = new CHSMasterMGTVO();
								cHSMasterMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
//								cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//								cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//								cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////								cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  확인
//								cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); // 확인
//								cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); // 확인
//								cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  // 확인
								cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());

								if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
									chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
								}
							}
						// End Chss_no null 이면  기존 Mvmt 존재시  데이터 삭제
						// Start Chss_no is not null
						} else {
							cNTRMvmtMGTVOs.add(cNTRMvmtMGTVO);
							log.debug("chssNo ===========|||||||||||||================="+chssNo);
							log.debug("chssNo ===========||||cusCtmMovementVO.getVndrSeq()================="+cusCtmMovementVO.getVndrSeq());
							log.debug("chssNo ===========|||||||||||||================="+cNTRMvmtMGTVO2);
							if(cNTRMvmtMGTVO2 != null){


								log.debug("ccNTRMvmtMGTVO2.getMvmtDt()=================="+cNTRMvmtMGTVO2.getMvmtDt());

							 // Attach detach data  삭제
								// 해당 date 이전의, 해당 Cntr OR Chss 로 attach되어 있는 AT/DT History 는 모두 Detach 처리
								cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
								List<CHSAtdtHistoryMGTVO> deldateVoList = new ArrayList<CHSAtdtHistoryMGTVO>();
								cHSAtdtHistoryMGTVO.setIbflag("D");
								cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
								cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt() ); // 수정
								cHSAtdtHistoryMGTVO.setEqKndCd("Z");

								deldateVoList.add(cHSAtdtHistoryMGTVO);
								// 조건 필요 업데이트
								cgmEqAtchDtchHisMGTVO = dbDao.searchCgmEqAtchDtchHisData(cHSAtdtHistoryMGTVO);
								if(cgmEqAtchDtchHisMGTVO != null){
									sLagDt     = cgmEqAtchDtchHisMGTVO.getLagDt();
									sLeadDt    = cgmEqAtchDtchHisMGTVO.getLeadDt();
									sLagDtYd   = cgmEqAtchDtchHisMGTVO.getLagDtYd();
									sLeadDtYd  = cgmEqAtchDtchHisMGTVO.getLeadDtYd();
									sAtchdt    = cgmEqAtchDtchHisMGTVO.getAtchDt();
								}

								// 기존 chss_no <> 입력된 chss_no  또는 이벤트 시간이 변경시에 사용
								if(!chssNo.equals(cNTRMvmtMGTVO2.getChssNo()) || !cNTRMvmtMGTVO2.getMvmtDt().substring(0,12).equals(cusCtmMovementVO.getCnmvEvntDt().substring(0,12))){
							    	// Movement data 삭제
									dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);
									// 신규 입력
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


									 //  date,yard 변경시   바로 전 detach 정보  수정한다
									cHSAtdtHistoryMGTVO.setIbflag("R");
									log.debug("ccNTRMvmtMGTVO2.getMvmtDt()=================="+cNTRMvmtMGTVO2.getMvmtDt());
									cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt());
									cHSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt() );
									log.debug("cHSAtdtHistoryMGTVO.getAtchDt()======================="+cHSAtdtHistoryMGTVO.getAtchDt());
									atdt.manageCHSAtdtPrePostHistoryBasic(cHSAtdtHistoryMGTVO);

									 //  AtDt 삭제

									atdt.manageCHSAtdtByMvmtBasic(deldateVoList);

									cHSAtdtHistoryMGTVO.setIbflag("I");
									cHSAtdtHistoryMGTVO.setAtchDt(cusCtmMovementVO.getCnmvEvntDt() ); // 수정
									insdateVoList.add(cHSAtdtHistoryMGTVO);
									// EQ Attatch/Detach 정보 저장(History 저장)
									atdt.manageCHSAtdtByMvmtBasic(insdateVoList);



							    } else {
							    	//  Movement data 업데이트
							    	dbDao.modifyCgmChssMvmtHisData(cNTRMvmtMGTVO);
							    	if(sLagDt == null) sLagDt ="";
									if(sLeadDt == null) sLeadDt ="";
									if(sLagDtYd == null) sLagDtYd ="";
									if(sLeadDtYd == null) sLeadDtYd ="";
									if(sAtchdt == null) sAtchdt = "";

									// AtDt 업데이트
									if(cgmEqAtchDtchHisMGTVO != null && sAtchdt.equals(sLagDt) && sAtchdt.equals(sLeadDt)){

										cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
										cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
										cHSAtdtHistoryMGTVO.setAtchDt(sLagDt); // 수정
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
								cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO.getMvmtDt() ); // 수정
								cHSAtdtHistoryMGTVO.setEqKndCd("Z");
								cHSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO.getChssNo());
								cHSAtdtHistoryMGTVO.setCntrNo(cNTRMvmtMGTVO.getCntrNo());
								cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								cHSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
								cHSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());



								insdateVoList.add(cHSAtdtHistoryMGTVO);
								atdt.manageCHSAtdtByMvmtBasic(insdateVoList);
								// 신규 Insert 처리 기존에 데이터가 없음
								dbDao.addCHSMovementData(cNTRMvmtMGTVOs);
							}



							// Master 데이터 update
							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
//							cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//							cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//							cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////							cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  확인
//							cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); // 확인
//							cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); // 확인
//							cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  // 확인
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());

							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
							}
						}
						// end Chss_no is not null
				    // ENd Row  데이터가  update
					// start Row  데이터가    delete
					} else {  // 삭제시
						if(!chssNo.equals("")){
							// Movement data 삭제
							dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);

							// Attach detach data  삭제
							// 해당 date 이전의, 해당 Cntr OR Chss 로 attach되어 있는 AT/DT History 는 모두 Detach 처리
							cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
							List<CHSAtdtHistoryMGTVO> deldateVoList = new ArrayList<CHSAtdtHistoryMGTVO>();
							cHSAtdtHistoryMGTVO.setIbflag("D");
							cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO.getChssNo());
							cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO.getCnmvEvntDt() ); // 수정
							cHSAtdtHistoryMGTVO.setEqKndCd("Z");

							deldateVoList.add(cHSAtdtHistoryMGTVO);
							if(cNTRMvmtMGTVO2 !=null){
								// 조건 필요 업데이트
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

							//  date,yard 변경시   바로 전 detach 정보  수정한다

								cHSAtdtHistoryMGTVO.setIbflag("N");
								cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO.getChssNo());
								cHSAtdtHistoryMGTVO.setCntrNo(cNTRMvmtMGTVO.getCntrNo());
								cHSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
								cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								atdt.manageCHSAtdtPrePostHistoryBasic(cHSAtdtHistoryMGTVO);


							    //  AtDt 삭제
								atdt.manageCHSAtdtByMvmtBasic(deldateVoList);
//								//  atdt 업데이트
//								if(sAtchdt.equals(sLagDt) && sAtchdt.equals(sLeadDt)){
//									cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
//									cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
//									cHSAtdtHistoryMGTVO.setAtchDt(sLagDt); // 수정
//									cHSAtdtHistoryMGTVO.setDtchYdCd(sLeadDtYd);
//								    cHSAtdtHistoryMGTVO.setDtchDt(sLeadDt);
//									cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
//									atdt.manageCHSAtdtHistoryBasic(cHSAtdtHistoryMGTVO);
//								}
							}


							// Master 데이터 update
							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cNTRMvmtMGTVO.getChssNo());
//							cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//							cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//							cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
//
////							cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  확인
//							cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); // 확인
//							cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); // 확인
//							cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  // 확인
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							// Eq Master 정보를 수정한다
							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
							}

						} else {
							//  Chss_no 가 없더라도  cntr_no, cnmv_yr, cnmv_id_no  로 cgm_chss_mvmt_his 테이블에 데이터가 있으면 삭제 해야합니다.
							// (기존 delete sql 그대로 사용하면됨)

							// Movement data 삭제
							dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);

							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							// Eq Master 정보를 수정한다
							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
							}
						}
					}
				}
				// END Row  데이터가  update , delete
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
	 *  Bare Movement 처리 오퍼레이션 SAVE  [CTM 호출]<br>
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

			// 샤시 코드 있는경우 샤시 번호와 코드를 바꾸어서 매핑 해준다
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

			cHSMvmtBareMGTVO.setYdCd(flatFileForGateNewVO.getEventYard());   // 확인
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
				}
				if(flatFileForGateNewVO.getGateIo().trim().equals("AL") || flatFileForGateNewVO.getGateIo().trim().equals("AO")|| flatFileForGateNewVO.getGateIo().trim().equals("D")
			    || flatFileForGateNewVO.getGateIo().trim().equals("OA")|| flatFileForGateNewVO.getGateIo().trim().equals("P")|| flatFileForGateNewVO.getGateIo().trim().equals("RL")|| flatFileForGateNewVO.getGateIo().trim().equals("O")
				){

					cHSMvmtBareMGTVO.setGateIoCd("O");
				}
				cHSMvmtBareMGTVO.setCntrNo(sChss_code);
				//cHSMvmtBareMGTVO.setMvmtStsCd(flatFileForGateNewVO.getMvmtStatus());
			}

//			log.debug("getMvmtStatus==="+flatFileForGateNewVO.getMvmtStatus());
			log.debug("getGateIo==="+flatFileForGateNewVO.getGateIo());
			log.debug("getGateIoCd==="+cHSMvmtBareMGTVO.getGateIoCd());
			cHSMvmtBareMGTVO.setVndrAbbrNm(flatFileForGateNewVO.getVndrSeq());
			cHSMvmtBareMGTVO.setMvmtRsnCd("CHPO");
			cHSMvmtBareMGTVO.setMgstNo(flatFileForGateNewVO.getMgSet());
			//cHSMvmtBareMGTVO.setMvmtCoCd(cusCtmMovementVO.getmvmtc)   // 확인
			cHSMvmtBareMGTVO.setDiffRmk("");
			cHSMvmtBareMGTVO.setMnlInpFlg("N");

			cHSMvmtBareMGTVO.setCreUsrId(flatFileForGateNewVO.getUserId());
			cHSMvmtBareMGTVO.setUpdUsrId(flatFileForGateNewVO.getUserId());

			cHSMvmtBareMGTVOs.add(cHSMvmtBareMGTVO);
			// Bare Movement 처리
		 	dbDao.addCHSBareMvmtData(cHSMvmtBareMGTVOs);
		 	if(chk == true){
				cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();

				cHSAtdtHistoryMGTVO.setAt("DT");
				cHSAtdtHistoryMGTVO.setEqNo(sContr_no);
				cHSAtdtHistoryMGTVO.setDtchDt(sGmtDt); // 수정
				cHSAtdtHistoryMGTVO.setDtchYdCd(flatFileForGateNewVO.getEventYard());
				//cHSAtdtHistoryMGTVO.setDtchInpTpCd("A");
				cHSAtdtHistoryMGTVO.setUpdUsrId(flatFileForGateNewVO.getUserId());

				// CTM 으로부터 322 Movement 데이터를 받아 Chassis, M.G.Set Attach/Detach 내역을 처리 한다.
			 	atdt.manageCHSAtdtByCtmBasic(cHSAtdtHistoryMGTVO);
		 	}

		 // Master 데이터 update
		 	CHSMasterMGTVO cHSMasterMGTVO    = new CHSMasterMGTVO();
			cHSMasterMGTVO.setEqNo(sContr_no);
//			cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//			cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//			cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////			cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  확인
//			cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); // 확인
//			cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); // 확인
//			cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  // 확인
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
	 *  배치에서 ctm 모둘내 호출 데이터 가져오기
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
	 * Container 이동정보의 Booking 정보 조회
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
	 * 컨테이너 이동정보 조회
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
	 * Movement History 조회 [EES_CGM_1109] <br>
	 * @param cHSmgstChkINVO CHSmgstChkINVO
	 * @return List<CHSmgstChkINVO>
	 * @throws EventException
	 */
	public List<CHSmgstChkINVO>  searchchssAtdtVerifyBasic(CHSmgstChkINVO cHSmgstChkINVO) throws EventException{
		try {

			return dbDao.searchchssAtdtVerifyList(cHSmgstChkINVO);
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
	 * Movement History 조회 [EES_CGM_1109] <br>
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
	 * Shipper's Chassis의 Movement 관리현황을 조회합니다. [EES_CGM_1150] <br>
	 *
	 * @param ShipCHSMvmtMGTVO shipCHSMvmtMGTVO
	 * @return  List<ShipCHSMvmtMGTVO>
	 * @exception EventException
	 */
	public List<ShipCHSMvmtMGTVO> searchShipChsMovementListBasic(ShipCHSMvmtMGTVO shipCHSMvmtMGTVO) throws EventException {
		List<ShipCHSMvmtMGTVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

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