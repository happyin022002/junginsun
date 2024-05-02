/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastBCImpl.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.23 김종준
* 1.0 Creation
* 2013.02.21 신용찬 [CHM-201323022]    OP/MG FCST HISTORY 화면생성
=========================================================*/ 
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration.MTYEquipmentForecastDBDAO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceCommonListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceReferenceListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-MTYEquipmentForecast Business Logic Basic Command implementation<br>
 * - ALPS-MTYEquipmentForecast에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author kim jong jun
 * @see EES_CIM_5001EventResponse,MTYEquipmentForecastBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MTYEquipmentForecastBCImpl extends BasicCommandSupport implements MTYEquipmentForecastBC {

	// Database Access Object
	private transient MTYEquipmentForecastDBDAO dbDao = null;

	/**
	 * MTYEquipmentForecastBCImpl 객체 생성<br>
	 * MTYEquipmentForecastDBDAO를 생성한다.<br>
	 */
	public MTYEquipmentForecastBCImpl() {
		dbDao = new MTYEquipmentForecastDBDAO();
	}
	/**
	 *  지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceListVO> searchMtyBalanceList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			mtyBalanceOptionVO.setRepoPlnYrwk(mtyBalanceOptionVO.getFcastYrwk());
			String repoPlnId= dbDao.searchRepoPlnId(mtyBalanceOptionVO);
			mtyBalanceOptionVO.setRepoPlnId(repoPlnId);
			
			// Balance REPO ID 의 주차가 현재주차인지 확인 
			String currFlag= dbDao.checkCurrWeek(mtyBalanceOptionVO);
			mtyBalanceOptionVO.setCurrFlag(currFlag);
			
			return dbDao.searchMtyBalanceList(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Retrieve"}).getMessage(),ex);
		}
	}

	/**
	 * OP Forecast, MG Forecast 의 Log를 조회<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceListVO> searchMtyBalanceListLog(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			mtyBalanceOptionVO.setRepoPlnYrwk(mtyBalanceOptionVO.getFcastYrwk());
//			String repoPlnId= dbDao.searchRepoPlnId(mtyBalanceOptionVO);
//			mtyBalanceOptionVO.setRepoPlnId(repoPlnId);			
			
			return dbDao.searchMtyBalanceListLog(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Log Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 *  지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceReferenceListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceReferenceListVO> searchMtyBalanceReferenceList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			return dbDao.searchMtyBalanceReferenceList(mtyBalanceOptionVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Detail Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Detail Retrieve"}).getMessage(),ex);
		}			
	}	
	
	/**
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성,수정<br>
       CASE 1
       	MG FCST
       	OP FCST
		off-hire

		1. SELCTY 는 어떤 제약도 없음. (SELCDO-->SELCTY, 2013-06-17, 신용찬)
		2. 그외 OFFICE
   			1) Balance Report ID = 이번주(Location의 LOCAL TIME) 이면서 수정후 SAVE 버튼 클릭
     			--> 저장 불가(FCAST cannot be updated this time.Plz contact CDO-EQ for FCST Revision.)
   			2) Balance Report ID = 미래주차(Location의 LOCAL TIME) 이면서 수정후 SAVE 버튼 클릭
     			--> 금요일17:00 이전이면 저장
     			--> 금요일17:00 이후이면 저장 불가 (FCST revision for accuracy evaluation only available by 17:00, Friday.) 
   			3) Balance Report ID = 과거주(Location의 LOCAL TIME) 이면서 수정후 SAVE 버튼 클릭  
     			--> 저장 불가(Impossible to update past week's data.)
     
	   CASE 2
		OW&Oh-hire 팝업
		+Others 팝업
		Repo Out 팝업
		-Other 팝업

		1. SELCTY 는 어떤 제약도 없음. (SELCDO-->SELCTY, 2013-06-17, 신용찬)
		2. 그외 OFFICE
   			1) Balance Report ID = 과거주(Location의 LOCAL TIME) 이면서 수정후 SAVE 버튼 클릭  
     			--> 저장 불가(Impossible to update past week's data.)	 
	 * 
	 * @param MtyBalanceListVO[] mtyBalanceListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMtyBalance(MtyBalanceListVO[] mtyBalanceListVOs, SignOnUserAccount account) throws EventException {
		try {
			List<MtyBalanceListVO> insertVoList = new ArrayList<MtyBalanceListVO>();
			List<MtyBalanceListVO> updateVoList = new ArrayList<MtyBalanceListVO>();
			
			List<MtyBalanceListVO> logVoList    = new ArrayList<MtyBalanceListVO>();
			int logSeq = 0;  //EQR_MTY_BAL_RPT_HIS 의 RPT_SEQ 컬럼값
			
			String locCd  = mtyBalanceListVOs[0].getLocCd();
			String inputYearWeek = mtyBalanceListVOs[0].getInpYrwk();
			if ( account.getOfc_cd().length() < 6) {
				String updateAval= validationUpdateAval(locCd,inputYearWeek,"1");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
				if ( updateAval.equals("1")) {
					throw new EventException(new ErrorHandler("EQR70004").getMessage());
				} else if ( updateAval.equals("2")) {
					throw new EventException(new ErrorHandler("EQR70005").getMessage());
				} else if ( updateAval.equals("3")) {
					throw new EventException(new ErrorHandler("EQR70006").getMessage());
				}
			} else {
				//if ( !account.getOfc_cd().substring(0, 6).equals("SELCDO")) {
				if ( !(account.getOfc_cd().substring(0, 6).equals("SELCTY") || account.getOfc_cd().substring(0, 6).equals("SELCDO"))) { //SELCTY 는 어떤 제약도 없음. (SELCDO-->SELCTY, 2013-06-17, 신용찬)
					String updateAval= validationUpdateAval(locCd,inputYearWeek,"1");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
					if ( updateAval.equals("1")) {
						throw new EventException(new ErrorHandler("EQR70004").getMessage());
					} else if ( updateAval.equals("2")) {
						throw new EventException(new ErrorHandler("EQR70005").getMessage());
					} else if ( updateAval.equals("3")) {
						throw new EventException(new ErrorHandler("EQR70006").getMessage());
					}
				}
			}

			for ( int i=0; i<mtyBalanceListVOs.length; i++ ) {

				int checkAddModifyMtyCnt = dbDao.checkAddModifyMtyBalance(mtyBalanceListVOs[i]);
				logSeq = dbDao.checkMtyBalanceLogSeq(mtyBalanceListVOs[i]);  // EQR_MTY_BAL_RPT_HIS 의 RPT_SEQ 컬럼값 결정
								
				mtyBalanceListVOs[i].setLogSeq(Integer.toString(logSeq));  // seq 셋업
				mtyBalanceListVOs[i].setOfcCd(account.getOfc_cd());		   // office code 셋업
								
				mtyBalanceListVOs[i].setCreUsrId(account.getUsr_id());
				mtyBalanceListVOs[i].setUpdUsrId(account.getUsr_id());
				mtyBalanceListVOs[i].unDataFormat();
				if ( checkAddModifyMtyCnt == 0) {
					insertVoList.add(mtyBalanceListVOs[i]);
				} else {
					updateVoList.add(mtyBalanceListVOs[i]);
				}
				
				logVoList.add(mtyBalanceListVOs[i]); // log 남기기 vo 준비
				
			}
			
			if ( logVoList.size() > 0 ) {
				dbDao.addMtyBalanceLog(logVoList); // log 기록
			}			
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMtyBalance(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMtyBalance(updateVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Create"}).getMessage(),ex);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Create"}).getMessage(),ex);
		}
	}
	
	/**
	 *  해당 Yard 의 장비인수 및 임차계획 수량,장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 입력한 내용을 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalRptOtrVO>
	 * @exception EventException
	 */
	public List<MtyBalRptOtrVO> searchMtyBalanceOtherList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			return dbDao.searchMtyBalanceOtherList(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"OW/ On-hire Receiving Plan Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * ECC내 소속 야드 를 조회한다<br>
	 * 
	 * @param String locGrpCd
	 * @param String locCd
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchYardList(String locGrpCd, String locCd) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<MtyBalanceCommonListVO> list = null;
		try {
			list = dbDao.searchYardList(locGrpCd, locCd);
			return list;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"ECC Yard  Retrieve"}).getMessage(),ex);
		}
	}	
	
	/**
	 * 특정 주차내의 일자 목록을 조회한다.<br>
	 * 
	 * @param yearWeek
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchDateListByWeek(String yearWeek) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<MtyBalanceCommonListVO> list = null;
		try {
			list = dbDao.searchDateListByWeek(yearWeek);
			return list;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
			//throw new EventException(new ErrorHandler("EQR10028", new String[]{"Check Week List   Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * 장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 생성,수정,삭제한다.(팝업)<br>
	 * 
	 * @param MtyBalRptOtrVO[] mtyBalRptOtrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyBalanceOther(MtyBalRptOtrVO[] mtyBalRptOtrVOs, SignOnUserAccount account) throws EventException
	{
		try {
			List<MtyBalRptOtrVO> insertVoList = new ArrayList<MtyBalRptOtrVO>();
			List<MtyBalRptOtrVO> updateVoList = new ArrayList<MtyBalRptOtrVO>();
			List<MtyBalRptOtrVO> deleteVoList = new ArrayList<MtyBalRptOtrVO>();

			if(mtyBalRptOtrVOs != null) {
				String locCd  = mtyBalRptOtrVOs[0].getLocCd();
				String inputYearWeek = mtyBalRptOtrVOs[0].getInpYrwk();
				if ( account.getOfc_cd().length() < 6) {
					String updateAval= validationUpdateAval(locCd,inputYearWeek,"2");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
					if ( updateAval.equals("1")) {
						throw new EventException(new ErrorHandler("EQR70004").getMessage());
					} 
				} else {
					//if ( !account.getOfc_cd().substring(0, 6).equals("SELCDO")) { 
					if ( !(account.getOfc_cd().substring(0, 6).equals("SELCTY") || account.getOfc_cd().substring(0, 6).equals("SELCDO"))) { //SELCTY 는 어떤 제약도 없음. (SELCDO-->SELCTY, 2013-06-17, 신용찬)
						String updateAval= validationUpdateAval(locCd,inputYearWeek,"2");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
						if ( updateAval.equals("1")) {
							throw new EventException(new ErrorHandler("EQR70004").getMessage());
						} 
					}
				}				
				for ( int i=0; i<mtyBalRptOtrVOs.length; i++ ) {
					if ( mtyBalRptOtrVOs[i].getIbflag().equals("I")){
						mtyBalRptOtrVOs[i].setCreUsrId(account.getUsr_id());
						mtyBalRptOtrVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(mtyBalRptOtrVOs[i]);
					} else if ( mtyBalRptOtrVOs[i].getIbflag().equals("U")){
						mtyBalRptOtrVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(mtyBalRptOtrVOs[i]);
					} else if ( mtyBalRptOtrVOs[i].getIbflag().equals("D")){
						deleteVoList.add(mtyBalRptOtrVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMtyBalanceOther(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEqStatusCodeData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMtyBalanceOther(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			//throw new EventException(de.getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			//throw new EventException(de.getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		}
	}
	
	/**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			String[] weekStEndDt = dbDao.searchWeekStEndDt(mtyBalanceOptionVO);
			mtyBalanceOptionVO.setWkStDt(weekStEndDt[0]);
			mtyBalanceOptionVO.setWkEndDt(weekStEndDt[1]);

			String currFlag    = "";
			String repoPlnYrwk = mtyBalanceOptionVO.getRepoPlnYrwk(); // Balance Report ID 의  week
			String fcastYrwk   = mtyBalanceOptionVO.getFcastYrwk();   // 왼쪽 돋보기 week
			
			log.debug(">>>>>>>>>>>>>>>> searchMtyBalanceRepoList, mtyBalanceOptionVO.getFcastYrwk()   : " + fcastYrwk);
			log.debug(">>>>>>>>>>>>>>>> searchMtyBalanceRepoList, mtyBalanceOptionVO.getInpYrwk()     : " + mtyBalanceOptionVO.getInpYrwk());
			log.debug(">>>>>>>>>>>>>>>> searchMtyBalanceRepoList, mtyBalanceOptionVO.getRepoPlnYrwk() : " + repoPlnYrwk);			
			
			// Balance Report ID와 왼쪽 week 가 같으면 왼쪽 week 가 현재주차인지 확인
			if( repoPlnYrwk.equals(fcastYrwk) ) {
				currFlag = dbDao.checkCurrWeek(mtyBalanceOptionVO);
							
			}else { // Balance Report ID와 왼쪽week 가 다를때는 'F' 처리	
				currFlag = "F";

			}
			
			log.debug(">>>>>>>>>>>>>>>> currFlag : " + currFlag);	
			
			mtyBalanceOptionVO.setCurrFlag(currFlag);						
			
			return dbDao.searchMtyBalanceRepoList(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition In / Out Plan Retrieve"}).getMessage(),ex);
		}
	}	


	/**
	 *  MTY Balance Report의 In&Out Bound FCST Data의 정확도를 WEEK별로 조회<br>
	 * 
	 * @param ForecastAccuracyOptionVO forecastAccuracyOptionVO
	 * @param SignOnUserAccount userAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchForecastAccuracyList(ForecastAccuracyOptionVO forecastAccuracyOptionVO, SignOnUserAccount userAccount) throws EventException {
		MTYEquipmentForecastBackEndJob backEndJob = new MTYEquipmentForecastBackEndJob();
		backEndJob.setJobType("MTYEquipmentForecast");
		backEndJob.setForecastAccuracyOptionVO(forecastAccuracyOptionVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "MTYEquipmentForecast BackEndJob");
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Forecast Accuracy Review (By Week) Retrieve"}).getMessage(),ex);
		}
	}	
	
	/**
	 * 주차와 입력 시간에 따라 업데이트 불가 여부를 체크한다.<br>
	 * 
	 * @param String locCd
	 * @param String inputYearWeek
	 * @param String chkTypeCd
	 * @return String Y,N
	 * @exception EventException
	 */
	public String validationUpdateAval(String locCd,String inputYearWeek,String chkTypeCd) throws EventException {
		try {
			return dbDao.validationUpdateAval(locCd, inputYearWeek,chkTypeCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Check Update Week, Time Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoOut(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws EventException {
		try {
			return dbDao.searchMtyBalanceRepoOut(mtyBalanceRepoListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition Out Plan Retrieve"}).getMessage(),ex);
		}
	}	
	
	/**
	 *  VVD를 이용해 slan cd를 조회한다.<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchMtyBalanceRepoOutSlanCd(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws EventException {
		try {
			return dbDao.searchMtyBalanceRepoOutSlanCd(mtyBalanceRepoListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition Out VVD Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 *  VVD를 이용해 from yard list 및 etd dt를 조회한다.<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoOutFrYdList(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws EventException {
		try {
			return dbDao.searchMtyBalanceRepoOutFrYdList(mtyBalanceRepoListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition Out from yard list Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 *  VVD를 이용해 to yard list 및 etb dt를 조회한다.<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoOutToYdList(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws EventException {
		try {
			return dbDao.searchMtyBalanceRepoOutToYdList(mtyBalanceRepoListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition Out to yard list Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 *  T/D VVD가 아닌 경우 입력된 yard cd가 해당 ecc/lcc/scc에 속하는지 체크<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return String
	 * @exception EventException
	 */
	public String checkMtyBalanceRepoOutYard(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws EventException {
		try {
			return dbDao.checkMtyBalanceRepoOutYard(mtyBalanceRepoListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition Out VVD Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 수정한다.<br>
	 * 
	 * @param MtyBalanceRepoListVO[] mtyBalanceRepoListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyBalanceRepoOut(MtyBalanceRepoListVO[] mtyBalanceRepoListVOs, SignOnUserAccount account) throws EventException
	{
		try {
			List<MtyBalanceRepoListVO> insertVoList = new ArrayList<MtyBalanceRepoListVO>();
			List<MtyBalanceRepoListVO> updateVoList = new ArrayList<MtyBalanceRepoListVO>();
			List<MtyBalanceRepoListVO> deleteVoList = new ArrayList<MtyBalanceRepoListVO>();

			String locCd  = mtyBalanceRepoListVOs[0].getLocCd();
			String inputYearWeek = mtyBalanceRepoListVOs[0].getInpYrwk();
			if ( account.getOfc_cd().length() < 6) {
				String updateAval= validationUpdateAval(locCd,inputYearWeek,"2");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
				if ( updateAval.equals("1")) {
					throw new EventException(new ErrorHandler("EQR70004").getMessage());
				} 
			} else {
				//if ( !account.getOfc_cd().substring(0, 6).equals("SELCDO")) {
				if ( ! (account.getOfc_cd().substring(0, 6).equals("SELCTY") || account.getOfc_cd().substring(0, 6).equals("SELCDO"))) { //SELCTY 는 어떤 제약도 없음. (SELCDO-->SELCTY, 2013-06-17, 신용찬)
					String updateAval= validationUpdateAval(locCd,inputYearWeek,"2");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
					if ( updateAval.equals("1")) {
						throw new EventException(new ErrorHandler("EQR70004").getMessage());
					} 
				}
			}	
			
			if(mtyBalanceRepoListVOs != null) {
				for ( int i=0; i<mtyBalanceRepoListVOs.length; i++ ) {
					if ( mtyBalanceRepoListVOs[i].getIbflag().equals("I")){
						mtyBalanceRepoListVOs[i].setCreUsrId(account.getUsr_id());
						mtyBalanceRepoListVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(mtyBalanceRepoListVOs[i]);
					} else if ( mtyBalanceRepoListVOs[i].getIbflag().equals("U")){
						mtyBalanceRepoListVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(mtyBalanceRepoListVOs[i]);
					} else if ( mtyBalanceRepoListVOs[i].getIbflag().equals("D")){
						deleteVoList.add(mtyBalanceRepoListVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMtyBalanceRepoOut(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMtyBalanceRepoOut(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMtyBalanceRepoOut(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			//throw new EventException(de.getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			//throw new EventException(de.getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		}
	}
	
	/**
	 * ECC 조회 시점, 해당 REPO ID 포함 4주치에 대한 O/B FCST D.TTL(Dry TTL)이 0 이상인지 체크<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String checkMtyBalanceLCCSave(MtyBalanceOptionVO mtyBalanceOptionVO)  throws EventException{
		 try {
			 String saveFlag = "T";
			 
			 if(!mtyBalanceOptionVO.getLocGrpCd().equals("L")){
				 saveFlag = dbDao.checkMtyBalanceLCCSave(mtyBalanceOptionVO);
			 }
			 
			 return saveFlag;
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				//throw new EventException(new ErrorHandler(ex).getMessage());
				throw new EventException(new ErrorHandler("EQR10028", new String[]{"OW/ On-hire Receiving Plan Retrieve"}).getMessage(),ex);
			}
	 }
	 
	/**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceDischargedList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			return dbDao.searchMtyBalanceDischargedList(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition In / Out Plan Retrieve"}).getMessage(),ex);
		}
	}	
	
	
	/**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyRepoInDetailList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			String[] weekStEndDt = dbDao.searchWeekStEndDt(mtyBalanceOptionVO);
			mtyBalanceOptionVO.setWkStDt(weekStEndDt[0]);
			mtyBalanceOptionVO.setWkEndDt(weekStEndDt[1]);

			String currFlag    = "";
			String repoPlnYrwk = mtyBalanceOptionVO.getRepoPlnYrwk(); // Balance Report ID 의  week
			String fcastYrwk   = mtyBalanceOptionVO.getFcastYrwk();   // 왼쪽 돋보기 week
			
			// Balance Report ID와 왼쪽 week 가 같으면 왼쪽 week 가 현재주차인지 확인
			if( repoPlnYrwk.equals(fcastYrwk) ) {
				currFlag = dbDao.checkCurrWeek(mtyBalanceOptionVO);						
			}else { // Balance Report ID와 왼쪽week 가 다를때는 'F' 처리	
				currFlag = "F";
			}
			
			mtyBalanceOptionVO.setCurrFlag(currFlag);						
			
			//return dbDao.searchMtyBalanceRepoList(mtyBalanceOptionVO);
			return dbDao.searchMtyRepoInDeatilList(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition In Detail Retrieve"}).getMessage(),ex);
		}
	}	
	
	/**
	 * REPO IN 데이터를 수기로 관리하는 기능 처리<br>
	 * 
	 * @param MtyBalanceRepoListVO[] mtyBalanceRepoListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyRepoInDetailList(MtyBalanceRepoListVO[] mtyBalanceRepoListVOs, SignOnUserAccount account) throws EventException
	{
		try {
			List<MtyBalanceRepoListVO> insertVoList = new ArrayList<MtyBalanceRepoListVO>();
			List<MtyBalanceRepoListVO> updateVoList = new ArrayList<MtyBalanceRepoListVO>();
			List<MtyBalanceRepoListVO> updateCodRmkVoList = new ArrayList<MtyBalanceRepoListVO>();
			List<MtyBalanceRepoListVO> deleteVoList = new ArrayList<MtyBalanceRepoListVO>();
			
			if(mtyBalanceRepoListVOs != null) { 
				for ( int i=0; i<mtyBalanceRepoListVOs.length; i++ ) {					
					if ( mtyBalanceRepoListVOs[i].getIbflag().equals("I")){
						mtyBalanceRepoListVOs[i].setCreUsrId(account.getUsr_id());
						mtyBalanceRepoListVOs[i].setUpdUsrId(account.getUsr_id());
						
						insertVoList.add(mtyBalanceRepoListVOs[i]);
						
					} else if ( mtyBalanceRepoListVOs[i].getIbflag().equals("U")){
						mtyBalanceRepoListVOs[i].setUpdUsrId(account.getUsr_id());
						log.debug(">>>>>>>>>>>> UPDATE "+i+" : "+mtyBalanceRepoListVOs[i].getLvl()+", "+mtyBalanceRepoListVOs[i].getVvd()+", "+mtyBalanceRepoListVOs[i].getDiv());

						if(mtyBalanceRepoListVOs[i].getCreSeq().equals("1")) { // lvl =1 은 manual 입력을 의미함.(EQR_MTY_BAL_RPT_DCHG_MNL 수정)
							updateVoList.add(mtyBalanceRepoListVOs[i]);
						}else {  // lvl=0 은 EQR_MTY_COD_RMK 의 remark 만 수정
							mtyBalanceRepoListVOs[i].setOfcCd(account.getOfc_cd());
							mtyBalanceRepoListVOs[i].setCreUsrId(account.getUsr_id());
							updateCodRmkVoList.add(mtyBalanceRepoListVOs[i]);
						}
						
					} else if ( mtyBalanceRepoListVOs[i].getIbflag().equals("D")){
						deleteVoList.add(mtyBalanceRepoListVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMtyRepoInDetailList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMtyRepoInDetailList(updateVoList);
			}
			
			if ( updateCodRmkVoList.size() > 0 ) {  // EQR_MTY_COD_RMK 의 remark 만 수정
				dbDao.modifyMtyCodRemark(updateCodRmkVoList);
			}			
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMtyRepoInDetailList(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			//throw new EventException(de.getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		}
	}	
	
	/**
	 * LCC/ECC/SCC 에 속한 LOCATION<br>
	 * 
	 * @param String locGrpCd
	 * @param String locCd
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchLocationList(String locGrpCd, String locCd) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<MtyBalanceCommonListVO> list = null;
		try {
			list = dbDao.searchLocationList(locGrpCd, locCd);
			return list;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"ECC Yard  Retrieve"}).getMessage(),ex);
		}
	}		
	
	/**
	 * 특정 주차내의 일자 목록을 조회한다.<br>
	 * 
	 * @param String wk_st_dt
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchLocationDateList(String wk_st_dt) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<MtyBalanceCommonListVO> list = null;
		try {
			list = dbDao.searchLocationDateList(wk_st_dt);
			return list;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
}