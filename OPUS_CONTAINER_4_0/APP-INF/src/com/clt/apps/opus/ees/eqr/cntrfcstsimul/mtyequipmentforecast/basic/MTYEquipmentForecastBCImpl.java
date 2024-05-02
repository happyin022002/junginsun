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
* 2013.02.21  [CHM-201323022] OP/MG FCST HISTORY 화면생성
* 2014.02.05  [CHM-201428796] SELCTY --> SELCOE 로 변경 
=========================================================*/ 
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration.MTYEquipmentForecastDBDAO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcst3AvgVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcstInputVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.basic.CommonBCImpl;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-MTYEquipmentForecast Business Logic Basic Command implementation<br>
 * - OPUS-MTYEquipmentForecast에 대한 비지니스 로직을 처리한다.<br>
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
	 * 과거 3주 분 실적과 향후 3주 까지의 OPMG Forecast Input data 를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public List<OpmgFcstInputVO> searchOpmgFcstInputBasic(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			mtyBalanceOptionVO.setRepoPlnYrwk(mtyBalanceOptionVO.getFcastYrwk());

			// Balance REPO ID 의 주차가 현재주차인지 확인 
			String currFlag= dbDao.checkCurrWeek(mtyBalanceOptionVO);
			mtyBalanceOptionVO.setCurrFlag(currFlag);
			
			return dbDao.searchOpmgFcstInputData(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Retrieve"}).getMessage(),ex);
		}
	}	
	
	/**
	 * 과거 3주의 평균 OP, MG, Repo Out 을 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public List<OpmgFcst3AvgVO> searchOpmgFcst3AvgBasic(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			mtyBalanceOptionVO.setRepoPlnYrwk(mtyBalanceOptionVO.getFcastYrwk());
			
			return dbDao.searchOpmgFcst3AvgData(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * OPMG Forecast 화면의 Reference 2 데이터를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @param String kind
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public CommonRsVO searchOpmgFcstReference2Basic(MtyBalanceOptionVO mtyBalanceOptionVO, String kind) throws EventException {
		try{
			return dbDao.searchOpmgFcstReference2Data(mtyBalanceOptionVO, kind);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"how ever error"}).getMessage(),ex);
		}
	}
	
	/**
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성,수정<br>
       CASE 1
       	MG FCST
       	OP FCST
		off-hire

		1. SELCDO 는 어떤 제약도 없음.
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

		1. SELCDO 는 어떤 제약도 없음.
		2. 그외 OFFICE
   			1) Balance Report ID = 과거주(Location의 LOCAL TIME) 이면서 수정후 SAVE 버튼 클릭  
     			--> 저장 불가(Impossible to update past week's data.)	 
	 * 
	 * @param OpmgFcstInputVO[] opmgFcstInputVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOpmgFcstInputBasic(OpmgFcstInputVO[] opmgFcstInputVOs, SignOnUserAccount account) throws EventException {
		try {
			List<MtyBalanceListVO> mtyBalanceListVOs = new ArrayList<MtyBalanceListVO>();
			
			List<MtyBalanceListVO> insertVoList = new ArrayList<MtyBalanceListVO>();
			List<MtyBalanceListVO> updateVoList = new ArrayList<MtyBalanceListVO>();
			
			List<MtyBalanceListVO> logVoList    = new ArrayList<MtyBalanceListVO>();
			int logSeq = 0;  //EQR_MTY_BAL_RPT_HIS 의 RPT_SEQ 컬럼값
			
			
			// 저장가능로직은 checkMtyBalanceSaveAvailable 메소드로 이관, 2013-12-05, 
			/* 소스원본
			String locCd  = opmgFcstInputVOs[0].getLocCd();
			String inputYearWeek = opmgFcstInputVOs[0].getW3Wk(); //inputYearWeek 는 조회 주차의 한주 전 
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
				if ( !account.getOfc_cd().substring(0, 6).equals("SELCTY") && !account.getOfc_cd().substring(0, 6).equals("SELCDO")) { // SELCDO --> SELCTY 조직 개편으로 인해 변경 2013.06.18
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
			*/
			
			for( int i=0; i<opmgFcstInputVOs.length; i++ ){
				if("Y".equals(opmgFcstInputVOs[i].getW4Ef())){
					MtyBalanceListVO mtyBalanceListVO = new MtyBalanceListVO();
					
					mtyBalanceListVO.setD2FcastQty(opmgFcstInputVOs[i].getW4D2());
					mtyBalanceListVO.setD4FcastQty(opmgFcstInputVOs[i].getW4D4());
					mtyBalanceListVO.setD5FcastQty(opmgFcstInputVOs[i].getW4D5());
					mtyBalanceListVO.setD7FcastQty(opmgFcstInputVOs[i].getW4D7());
					mtyBalanceListVO.setR2FcastQty(opmgFcstInputVOs[i].getW4R2());
					mtyBalanceListVO.setR5FcastQty(opmgFcstInputVOs[i].getW4R5());
					mtyBalanceListVO.setR9FcastQty(opmgFcstInputVOs[i].getW4R9());
					mtyBalanceListVO.setO2FcastQty(opmgFcstInputVOs[i].getW4O2());
					mtyBalanceListVO.setS2FcastQty(opmgFcstInputVOs[i].getW4S2());
					mtyBalanceListVO.setO4FcastQty(opmgFcstInputVOs[i].getW4O4());
					mtyBalanceListVO.setS4FcastQty(opmgFcstInputVOs[i].getW4S4());
					mtyBalanceListVO.setF2FcastQty(opmgFcstInputVOs[i].getW4F2());
					mtyBalanceListVO.setA2FcastQty(opmgFcstInputVOs[i].getW4A2());
					mtyBalanceListVO.setF4FcastQty(opmgFcstInputVOs[i].getW4F4());
					mtyBalanceListVO.setA4FcastQty(opmgFcstInputVOs[i].getW4A4());
					mtyBalanceListVO.setF5FcastQty(opmgFcstInputVOs[i].getW4F5());
					mtyBalanceListVO.setO5FcastQty(opmgFcstInputVOs[i].getW4O5());

					mtyBalanceListVO.setFcastYrwk(opmgFcstInputVOs[i].getW4Wk()); // 입력 대상 주차
					mtyBalanceListVO.setFcastYrwk0(opmgFcstInputVOs[i].getW4Wk()); // 입력 대상 주차
					mtyBalanceListVO.setInpYrwk(opmgFcstInputVOs[i].getW3Wk()); // InpYrwk 는 조회 주차의 한주 전
					mtyBalanceListVO.setLocCd(opmgFcstInputVOs[i].getLocCd());
					mtyBalanceListVO.setLocGrpCd(opmgFcstInputVOs[i].getLocGrpCd());
					mtyBalanceListVO.setTpCd(opmgFcstInputVOs[i].getMtyBalTpCd());
					mtyBalanceListVO.setDpSeq(opmgFcstInputVOs[i].getDpSeq());
					
					mtyBalanceListVOs.add(mtyBalanceListVO);
				}
				if("Y".equals(opmgFcstInputVOs[i].getW5Ef())){
					MtyBalanceListVO mtyBalanceListVO = new MtyBalanceListVO();
					
					mtyBalanceListVO.setD2FcastQty(opmgFcstInputVOs[i].getW5D2());
					mtyBalanceListVO.setD4FcastQty(opmgFcstInputVOs[i].getW5D4());
					mtyBalanceListVO.setD5FcastQty(opmgFcstInputVOs[i].getW5D5());
					mtyBalanceListVO.setD7FcastQty(opmgFcstInputVOs[i].getW5D7());
					mtyBalanceListVO.setR2FcastQty(opmgFcstInputVOs[i].getW5R2());
					mtyBalanceListVO.setR5FcastQty(opmgFcstInputVOs[i].getW5R5());
					mtyBalanceListVO.setR9FcastQty(opmgFcstInputVOs[i].getW5R9());
					mtyBalanceListVO.setO2FcastQty(opmgFcstInputVOs[i].getW5O2());
					mtyBalanceListVO.setS2FcastQty(opmgFcstInputVOs[i].getW5S2());
					mtyBalanceListVO.setO4FcastQty(opmgFcstInputVOs[i].getW5O4());
					mtyBalanceListVO.setS4FcastQty(opmgFcstInputVOs[i].getW5S4());
					mtyBalanceListVO.setF2FcastQty(opmgFcstInputVOs[i].getW5F2());
					mtyBalanceListVO.setA2FcastQty(opmgFcstInputVOs[i].getW5A2());
					mtyBalanceListVO.setF4FcastQty(opmgFcstInputVOs[i].getW5F4());
					mtyBalanceListVO.setA4FcastQty(opmgFcstInputVOs[i].getW5A4());
					mtyBalanceListVO.setF5FcastQty(opmgFcstInputVOs[i].getW5F5());
					mtyBalanceListVO.setO5FcastQty(opmgFcstInputVOs[i].getW5O5());

					mtyBalanceListVO.setFcastYrwk(opmgFcstInputVOs[i].getW5Wk());
					mtyBalanceListVO.setFcastYrwk0(opmgFcstInputVOs[i].getW5Wk());
					mtyBalanceListVO.setInpYrwk(opmgFcstInputVOs[i].getW3Wk());
					mtyBalanceListVO.setLocCd(opmgFcstInputVOs[i].getLocCd());
					mtyBalanceListVO.setLocGrpCd(opmgFcstInputVOs[i].getLocGrpCd());
					mtyBalanceListVO.setTpCd(opmgFcstInputVOs[i].getMtyBalTpCd());
					mtyBalanceListVO.setDpSeq(opmgFcstInputVOs[i].getDpSeq());
					
					mtyBalanceListVOs.add(mtyBalanceListVO);
				}
				
				if("Y".equals(opmgFcstInputVOs[i].getW6Ef())){
					MtyBalanceListVO mtyBalanceListVO = new MtyBalanceListVO();
					
					mtyBalanceListVO.setD2FcastQty(opmgFcstInputVOs[i].getW6D2());
					mtyBalanceListVO.setD4FcastQty(opmgFcstInputVOs[i].getW6D4());
					mtyBalanceListVO.setD5FcastQty(opmgFcstInputVOs[i].getW6D5());
					mtyBalanceListVO.setD7FcastQty(opmgFcstInputVOs[i].getW6D7());
					mtyBalanceListVO.setR2FcastQty(opmgFcstInputVOs[i].getW6R2());
					mtyBalanceListVO.setR5FcastQty(opmgFcstInputVOs[i].getW6R5());
					mtyBalanceListVO.setR9FcastQty(opmgFcstInputVOs[i].getW6R9());
					mtyBalanceListVO.setO2FcastQty(opmgFcstInputVOs[i].getW6O2());
					mtyBalanceListVO.setS2FcastQty(opmgFcstInputVOs[i].getW6S2());
					mtyBalanceListVO.setO4FcastQty(opmgFcstInputVOs[i].getW6O4());
					mtyBalanceListVO.setS4FcastQty(opmgFcstInputVOs[i].getW6S4());
					mtyBalanceListVO.setF2FcastQty(opmgFcstInputVOs[i].getW6F2());
					mtyBalanceListVO.setA2FcastQty(opmgFcstInputVOs[i].getW6A2());
					mtyBalanceListVO.setF4FcastQty(opmgFcstInputVOs[i].getW6F4());
					mtyBalanceListVO.setA4FcastQty(opmgFcstInputVOs[i].getW6A4());
					mtyBalanceListVO.setF5FcastQty(opmgFcstInputVOs[i].getW6F5());
					mtyBalanceListVO.setO5FcastQty(opmgFcstInputVOs[i].getW6O5());

					mtyBalanceListVO.setFcastYrwk(opmgFcstInputVOs[i].getW6Wk());
					mtyBalanceListVO.setFcastYrwk0(opmgFcstInputVOs[i].getW6Wk());
					mtyBalanceListVO.setInpYrwk(opmgFcstInputVOs[i].getW3Wk());
					mtyBalanceListVO.setLocCd(opmgFcstInputVOs[i].getLocCd());
					mtyBalanceListVO.setLocGrpCd(opmgFcstInputVOs[i].getLocGrpCd());
					mtyBalanceListVO.setTpCd(opmgFcstInputVOs[i].getMtyBalTpCd());
					mtyBalanceListVO.setDpSeq(opmgFcstInputVOs[i].getDpSeq());
					
					mtyBalanceListVOs.add(mtyBalanceListVO);
				}
				
				if("Y".equals(opmgFcstInputVOs[i].getW7Ef())){
					MtyBalanceListVO mtyBalanceListVO = new MtyBalanceListVO();
					
					mtyBalanceListVO.setD2FcastQty(opmgFcstInputVOs[i].getW7D2());
					mtyBalanceListVO.setD4FcastQty(opmgFcstInputVOs[i].getW7D4());
					mtyBalanceListVO.setD5FcastQty(opmgFcstInputVOs[i].getW7D5());
					mtyBalanceListVO.setD7FcastQty(opmgFcstInputVOs[i].getW7D7());
					mtyBalanceListVO.setR2FcastQty(opmgFcstInputVOs[i].getW7R2());
					mtyBalanceListVO.setR5FcastQty(opmgFcstInputVOs[i].getW7R5());
					mtyBalanceListVO.setR9FcastQty(opmgFcstInputVOs[i].getW7R9());
					mtyBalanceListVO.setO2FcastQty(opmgFcstInputVOs[i].getW7O2());
					mtyBalanceListVO.setS2FcastQty(opmgFcstInputVOs[i].getW7S2());
					mtyBalanceListVO.setO4FcastQty(opmgFcstInputVOs[i].getW7O4());
					mtyBalanceListVO.setS4FcastQty(opmgFcstInputVOs[i].getW7S4());
					mtyBalanceListVO.setF2FcastQty(opmgFcstInputVOs[i].getW7F2());
					mtyBalanceListVO.setA2FcastQty(opmgFcstInputVOs[i].getW7A2());
					mtyBalanceListVO.setF4FcastQty(opmgFcstInputVOs[i].getW7F4());
					mtyBalanceListVO.setA4FcastQty(opmgFcstInputVOs[i].getW7A4());
					mtyBalanceListVO.setF5FcastQty(opmgFcstInputVOs[i].getW7F5());
					mtyBalanceListVO.setO5FcastQty(opmgFcstInputVOs[i].getW7O5());

					mtyBalanceListVO.setFcastYrwk(opmgFcstInputVOs[i].getW7Wk());
					mtyBalanceListVO.setFcastYrwk0(opmgFcstInputVOs[i].getW7Wk());
					mtyBalanceListVO.setInpYrwk(opmgFcstInputVOs[i].getW3Wk());
					mtyBalanceListVO.setLocCd(opmgFcstInputVOs[i].getLocCd());
					mtyBalanceListVO.setLocGrpCd(opmgFcstInputVOs[i].getLocGrpCd());
					mtyBalanceListVO.setTpCd(opmgFcstInputVOs[i].getMtyBalTpCd());
					mtyBalanceListVO.setDpSeq(opmgFcstInputVOs[i].getDpSeq());
					
					mtyBalanceListVOs.add(mtyBalanceListVO);
				}
			}
			

			for ( int i=0; i<mtyBalanceListVOs.size(); i++ ) {

				int checkAddModifyMtyCnt = dbDao.checkAddModifyMtyBalance(mtyBalanceListVOs.get(i));
				logSeq = dbDao.checkMtyBalanceLogSeq(mtyBalanceListVOs.get(i));  // EQR_MTY_BAL_RPT_HIS 의 RPT_SEQ 컬럼값 결정
								
				mtyBalanceListVOs.get(i).setLogSeq(Integer.toString(logSeq));  // seq 셋업
				mtyBalanceListVOs.get(i).setOfcCd(account.getOfc_cd());		   // office code 셋업
								
				mtyBalanceListVOs.get(i).setCreUsrId(account.getUsr_id());
				mtyBalanceListVOs.get(i).setUpdUsrId(account.getUsr_id());
				//mtyBalanceListVOs.get(i).unDataFormat(); // 특수 기호 제거
				if ( checkAddModifyMtyCnt == 0) {
					insertVoList.add(mtyBalanceListVOs.get(i));
				} else {
					updateVoList.add(mtyBalanceListVOs.get(i));
				}
				
				logVoList.add(mtyBalanceListVOs.get(i)); // log 남기기 vo 준비
				
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
	 * 직전 주차를 조회<br>
	 * 
	 * @param String week
	 * @return String
	 * @exception EventException
	 */
	public String searchBeforeWeekBasic(String week) throws EventException{
		try {
			return dbDao.searchBeforeWeekData(week);
		} catch (Exception ex) {
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
			
			return dbDao.searchMtyBalanceListLog(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Log Retrieve"}).getMessage(),ex);
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
				
				// 저장가능여부 로직은 오픈당시에 결정, 2013-12-05, 
//				String locCd  = mtyBalRptOtrVOs[0].getLocCd();
//				String inputYearWeek = mtyBalRptOtrVOs[0].getInpYrwk();
//				if ( account.getOfc_cd().length() < 6) {
//					String updateAval= validationUpdateAval(locCd,inputYearWeek,"2");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
//					if ( updateAval.equals("1")) {
//						throw new EventException(new ErrorHandler("EQR70004").getMessage());
//					} 
//				} else {
//					if ( !account.getOfc_cd().substring(0, 6).equals("SELCDO") && !account.getOfc_cd().substring(0, 6).equals("SELCTY")) { // SELCDO --> SELCTY 조직 개편으로 인해 변경 
//						String updateAval= validationUpdateAval(locCd,inputYearWeek,"2");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
//						if ( updateAval.equals("1")) {
//							throw new EventException(new ErrorHandler("EQR70004").getMessage());
//						} 
//					}
//				}		
				
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
	 * 1 : 입력주차 과거
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

			// 저장가능여부 로직은 오픈당시에 결정, 2013-12-05, 
//			String locCd  = mtyBalanceRepoListVOs[0].getLocCd();
//			String inputYearWeek = mtyBalanceRepoListVOs[0].getInpYrwk();
//			if ( account.getOfc_cd().length() < 6) {
//				String updateAval= validationUpdateAval(locCd,inputYearWeek,"2");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
//				if ( updateAval.equals("1")) {
//					throw new EventException(new ErrorHandler("EQR70004").getMessage());
//				} 
//			} else {
//				if ( !account.getOfc_cd().substring(0, 6).equals("SELCDO") && !account.getOfc_cd().substring(0, 6).equals("SELCTY")) { // SELCDO --> SELCTY 조직 개편으로 인해 변경 
//					String updateAval= validationUpdateAval(locCd,inputYearWeek,"2");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
//					if ( updateAval.equals("1")) {
//						throw new EventException(new ErrorHandler("EQR70004").getMessage());
//					} 
//				}
//			}	
			
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
	 * OP/MG FCST 화면의 OP/MG/RO/OTHER 수정 가능여부 확인<br>
	 * 
	 * << saveFlag 정의 >>
	 * 0 : 모든주차 수정 가능(SELCOE)
     * 1 : EQR70004  지난주차 수정 불가                                      Impossible to update past week's data.
     * 2 : EQR70005  주차와 입력 시간에 따라 업데이트 불가 여부를 체크한다.  FCST revision for accuracy evaluation only available by 17:00, Friday.
     * 3 : EQR70006  주차와 입력 시간에 따라 업데이트 불가 여부를 체크한다.  FCST revision for accuracy evaluation only available by 17:00, Friday.	 *
     *  
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception DAOException
	 */
	public String checkMtyBalanceSaveAvailable(MtyBalanceOptionVO mtyBalanceOptionVO, SignOnUserAccount account)  throws EventException{
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		try {

			String saveFlag = "0";
		
			String locCd  = mtyBalanceOptionVO.getLocCd();
			String fcastWeek     = mtyBalanceOptionVO.getFcastYrwk();  // 검색주차
			String inputYearWeek = commonImpl.getNextPrevWeek(fcastWeek, 1, "PREV").getResultString(); // 조회 주차의 한주 전(DB DATA) 
			
			if ( account.getOfc_cd().length() < 6) { // OFFICE 정보 부정확
				saveFlag= validationUpdateAval(locCd,inputYearWeek,"1");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
//				if ( updateAval.equals("1") || updateAval.equals("2") || updateAval.equals("3")) {
//					saveFlag = "F";
//										
//				}
			} else {  // OFFICE 정보 정확한 경우
				// SELCDO --> SELCTY 조직 개편으로 인해 변경 2013.06.18 (SELCTY 는 모든 기간 저장 가능)
				// SELCTY --> SELCOE 조직개편으로 변경, 2014-02-05, 
				if ( !account.getOfc_cd().substring(0, 6).equals("SELCOE") ) { 
						
					saveFlag= validationUpdateAval(locCd,inputYearWeek,"1");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
//					if ( updateAval.equals("1") || updateAval.equals("2") || updateAval.equals("3")) {
//						saveFlag = "F";
//					
//					}
				}
			}		
						 
			return saveFlag;
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"checkMtyBalanceSaveAvailable"}).getMessage(),ex);
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
	
}