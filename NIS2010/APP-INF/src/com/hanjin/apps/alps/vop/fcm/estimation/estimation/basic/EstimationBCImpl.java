/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : TrendLineBCImpl.java
 *@FileTitle : TrendLine
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.15
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.11.15 진마리아
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.basic;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration.EstimationDBDAO;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.FcmEstmWkCsmIfVO;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.FcmRmnOilMonEndRptVO;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.FcmTgtVvdVO;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.MonEstmCsmVO;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-Estimation Business Logic Basic Command implementation<br>
 * - ALPS-Estimation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0041EventResponse,EstimationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EstimationBCImpl extends BasicCommandSupport implements
		EstimationBC {

	// Database Access Object
	private transient EstimationDBDAO dbDao = null;

	/**
	 * EstimationBCImpl 객체 생성<br>
	 * EstimationBCDBDAO 생성한다.<br>
	 */
	public EstimationBCImpl() {
		dbDao = new EstimationDBDAO();
	}

	/**
	 * Search target VVD list for a monthly estimation consumption.
	 * 
	 * @param String bseYrmon
	 * @return List<MonEstmCsmVO>
	 * @exception EventException
	 */
	public List<MonEstmCsmVO> searchMonEstmTgtVvdList(String bseYrmon) throws EventException{
		try {
//			return dbDao.searchMonEstmTgtVvdList(bseYrmon);
			List<MonEstmCsmVO> monEstmCsmVOs = dbDao.searchMonEstmTgtVvdList(bseYrmon);
			searchTrendLineByVvd(monEstmCsmVOs);
			searchActStEndByVvd(monEstmCsmVOs);
			searchVoyEndRmnOilWgtByVvd(monEstmCsmVOs);
			calCsmWgt(monEstmCsmVOs);
			searchItemError(monEstmCsmVOs);
			return monEstmCsmVOs;
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		} 
	}
	
	/**
	 * Search trend line by VVD.
	 * 
	 * @param List<MonEstmCsmVO> monEstmCsmVOs
	 * @exception EventException
	 */
	private void searchTrendLineByVvd(List<MonEstmCsmVO> monEstmCsmVOs) throws EventException {
		try {
			for(MonEstmCsmVO monEstmCsmVO : monEstmCsmVOs){
				if("HFO".equals(monEstmCsmVO.getCsmOilTpCd())){
					FcmTrndLineVO fcmTrndLineVO = dbDao.searchTrendLineByVvd(monEstmCsmVO);
					monEstmCsmVO.setTrndLineSeq(fcmTrndLineVO.getTrndLineSeq());
					monEstmCsmVO.setTrndLineNo(fcmTrndLineVO.getTrndLineNo());
				}
			}
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		} 
	}
	
	/**
	 * Search actual start, end info by VVD.
	 * 
	 * @param List<MonEstmCsmVO> monEstmCsmVOs
	 * @exception EventException
	 */
	private void searchActStEndByVvd(List<MonEstmCsmVO> monEstmCsmVOs) throws EventException {
		try {
			for(MonEstmCsmVO monEstmCsmVO : monEstmCsmVOs){
				dbDao.searchActStEndByVvd(monEstmCsmVO);
			}
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		}
	}
	
	/**
	 * Search voyage end remain oil weight by VVD.
	 * 
	 * @param List<MonEstmCsmVO> monEstmCsmVOs
	 * @exception EventException
	 */
	private void searchVoyEndRmnOilWgtByVvd(List<MonEstmCsmVO> monEstmCsmVOs) throws EventException {
		try {
			for(MonEstmCsmVO monEstmCsmVO : monEstmCsmVOs){
				if("RV".equals(monEstmCsmVO.getEstmVvdTpCd())){
					dbDao.searchVoyEndRmnOilWgtByVvd(monEstmCsmVO);
				}
			}
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		}
	}
	
	/**
	 * Search item error by VVD
	 * 
	 * @param List<MonEstmCsmVO> monEstmCsmVOs
	 * @exception EventException
	 */
	private void searchItemError(List<MonEstmCsmVO> monEstmCsmVOs) throws EventException {
		try {
			String[] itmErrs = null;
			
			for(MonEstmCsmVO monEstmCsmVO : monEstmCsmVOs){
				
				itmErrs = new String[5];
				
//				1. 항차기간의 중복이나 단절 여부. 하나의 Vessel이 가지고 있는 항차가 중복되거나 단절되는지 체크 
				itmErrs[0] = ""; 
				
//				2. BV항차에서 Voy End RMN 이 ROM 보다 큰경우
				if("BV".equals(monEstmCsmVO.getEstmVvdTpCd())){
					int errChk = dbDao.searchItemErrorCheck2(monEstmCsmVO);
					if(errChk > 0){
						itmErrs[1] = "2";		
					}
				}
				
//				3. RV항차의 End Date가 월말과 동일한 경우
				if("RV".equals(monEstmCsmVO.getEstmVvdTpCd())){
					String actEndDt = monEstmCsmVO.getActEndDt();
					if(actEndDt.length()==8){
						Calendar cal = Calendar.getInstance();
						cal.set(Calendar.MONTH, Integer.parseInt(actEndDt.substring(4, 6))-1);
						if(cal.getActualMaximum(Calendar.DAY_OF_MONTH)==Integer.parseInt(actEndDt.substring(7))){
							itmErrs[3] = "3";
						}
					}
				}
				
//				4. PV항차에 PO RCV가 있는지
				if("PV".equals(monEstmCsmVO.getEstmVvdTpCd())){
					if(getBigDecimal(monEstmCsmVO.getPoRcvWgt()).compareTo(new BigDecimal("0"))!=0){
						itmErrs[3] = "4";
					}
				}
				
//				5. Month End RMN 값에 PO RCV가 반영되었는지
//				fcmEstmMonCsmIfVO.getMonEndRmnWgt()

				// Make item error contents.
				StringBuilder sb = new StringBuilder();
				for(String str : itmErrs){
					if(str!=null && str.length()>0){
						sb.append(str).append(",");
					}
				}
				
				String itmErr = sb.toString();
				if(itmErr.length()>0){
					itmErr = itmErr.substring(0, itmErr.length()-1); // Remove last comma
				}
				monEstmCsmVO.setItmErr(itmErr);
				
			}
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		}	
	}
	
	/**
	 * Calculate oil consumption weight.
	 * 
	 * @param List<MonEstmCsmVO> monEstmCsmVOs
	 * @exception EventException
	 */
	private void calCsmWgt(List<MonEstmCsmVO> monEstmCsmVOs) throws EventException {
		try {
			BigDecimal monBgnInvtWgt = null;
			BigDecimal preVvdInvtWgt = null;
			BigDecimal poRcvWgt = null;
			BigDecimal monEndRmnWgt = null;
			BigDecimal monEndCsmWgt = null;
			BigDecimal voyEndRmnWgt = null;
			BigDecimal voyEndCsmWgt = null;
			
			for(MonEstmCsmVO monEstmCsmVO : monEstmCsmVOs){
				
				monBgnInvtWgt = getBigDecimal("0");
				preVvdInvtWgt = getBigDecimal("0");
				poRcvWgt = getBigDecimal("0");
				monEndRmnWgt = getBigDecimal("0");
				monEndCsmWgt = getBigDecimal("0");
				voyEndRmnWgt = getBigDecimal("0");
				voyEndCsmWgt = getBigDecimal("0");
				
				monEstmCsmVO.setMonEndCsmWgt(monEndCsmWgt.toString());
//				monEstmCsmVO.setVoyEndRmnWgt(voyEndRmnWgt.toString());
				monEstmCsmVO.setVoyEndCsmWgt(voyEndCsmWgt.toString());
				
				monBgnInvtWgt = getBigDecimal(monEstmCsmVO.getMonBgnInvtWgt());
				preVvdInvtWgt = getBigDecimal(monEstmCsmVO.getPreVvdInvtWgt());
				poRcvWgt = getBigDecimal(monEstmCsmVO.getPoRcvWgt());
				monEndRmnWgt = getBigDecimal(monEstmCsmVO.getMonEndRmnWgt());
				
				if(monEndRmnWgt.compareTo(getBigDecimal("0"))!=0){
					monEndCsmWgt = monBgnInvtWgt.add(preVvdInvtWgt).add(poRcvWgt).subtract(monEndRmnWgt);
				}else{
					monEstmCsmVO.setMonEndRmnWgt(monEndRmnWgt.toString());
				}
				
				monEstmCsmVO.setMonEndCsmWgt(monEndCsmWgt.toString());
				
				if("RV".equals(monEstmCsmVO.getEstmVvdTpCd())){
					voyEndRmnWgt = getBigDecimal(monEstmCsmVO.getVoyEndRmnWgt());
					if(voyEndRmnWgt.compareTo(getBigDecimal("0"))!=0){
						voyEndCsmWgt = monBgnInvtWgt.add(preVvdInvtWgt).add(poRcvWgt).subtract(voyEndRmnWgt);
					}else{
						monEstmCsmVO.setVoyEndRmnWgt(voyEndRmnWgt.toString());
					}
					monEstmCsmVO.setVoyEndCsmWgt(voyEndCsmWgt.toString());
				}else{
					monEstmCsmVO.setVoyEndRmnWgt(voyEndRmnWgt.toString());
					monEstmCsmVO.setVoyEndCsmWgt(voyEndCsmWgt.toString());
				}
				
			}
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		}
	}
	
	/**
	 * Get BigDecimal value of String value.
	 * 
	 * @param String val
	 * @return BigDecimal
	 */
	private BigDecimal getBigDecimal(String val){
		if(val==null || val.length()==0){
			return new BigDecimal("0");
		}else{
			return new BigDecimal(val);
		}
	}
	
	/**
	 * Search a monthly estimation consumption.
	 * 
	 * @param MonEstmCsmVO[] monEstmCsmVOs
	 * @return List<MonEstmCsmVO>
	 * @exception EventException
	 */
	public List<MonEstmCsmVO> searchMonthlyEstmationConsumption(MonEstmCsmVO[] monEstmCsmVOs) throws EventException {
		try {
			MonEstmCsmVO tgtVO = null;
			// VVD Type : RV
			for(int i=0; i<monEstmCsmVOs.length; i++){
				tgtVO = monEstmCsmVOs[i];
				if("RV".equals(tgtVO.getEstmVvdTpCd())){
					// Search a arrival oil weight of a last calling port.
					dbDao.searchArrOilWgtLastPort(monEstmCsmVOs[i]);
//					fcmTgtVvdVOs[i] = tgtVO;
				}else if("BV".equals(tgtVO.getEstmVvdTpCd())){
					//SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
					Date d = sf.parse(tgtVO.getActEndDt());
					Calendar endDate = Calendar.getInstance();
					endDate.setTime(d);
					
					// Search a remain oil weight of a month-end report
					dbDao.searchVvdRmnOilWgtAtMonEndRpt(monEstmCsmVOs[i]);					
					
					Calendar revDate = Calendar.getInstance();
					sf.applyPattern("yyyyMM");
					d = sf.parse(tgtVO.getRevYrmon());
					revDate.setTime(d);
					revDate.set(Calendar.DAY_OF_MONTH, revDate.getActualMaximum(Calendar.DAY_OF_MONTH)); // "End Date" of revenue year-month.
					revDate.set(Calendar.HOUR_OF_DAY, 23);
					revDate.set(Calendar.MINUTE, 59);
					
					if(endDate.after(revDate)){
						long millis = endDate.getTimeInMillis() - revDate.getTimeInMillis();
						double gapHours = millis / 3600000.0;
						gapHours = Math.round(gapHours * 10)/10.0;
					}
					
				}
			}
			return Arrays.asList(monEstmCsmVOs);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), ex);
		} 
	}
	
	/**
	 * 주간 추정 대상 항차를 조회한다.
	 * 
	 * @param FcmEstmWkCsmIfVO fcmEstmWkCsmIfVO
	 * @return List<FcmEstmWkCsmIfVO>
	 * @exception EventException
	 *  */
	public List<FcmEstmWkCsmIfVO> searchWeekTgtVvdInfo(FcmEstmWkCsmIfVO fcmEstmWkCsmIfVO) throws EventException {
		try {
			return dbDao.searchWeekTgtVvdInfo(fcmEstmWkCsmIfVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Weekly Estimation" }).getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Weekly Estimation" }).getMessage(), ex);
		}
	}
	
	/**
	 * Execute a weekly fuel consumption estimation.
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String executeWeeklyEstimation() throws EventException {
		try {
//			ScheduleUtil su = new ScheduleUtil();
			boolean isRunning = false;
			String batchRunningStatus = "";
			int count = 0;
			
//			isRunning = su.isRunning("VOP_FCM_B001");
			if(isRunning){
				batchRunningStatus = "6";//진행 중
			}else{
				//Check if the batch program is already running.
				FcmTgtVvdVO fcmTgtVvdVO = new FcmTgtVvdVO();
//				count = dbDao.searchVvdExpenseSimulationStatus(fcmTgtVvdVO); 
				if(count>0){
					fcmTgtVvdVO.setToFlg(batchRunningStatus); // <=== R4J 회피코드
					batchRunningStatus = "6"; // 진행중
				}
			}
			return batchRunningStatus;
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("COM12203", new String[] { "Execute Weekly Estimation" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Execute Weekly Estimation" }).getMessage(), ex);
		}
	}
	
	/**
	 * Revenue Month별 Vessel 월말 잔량 내역을 조회한다.
	 * 
	 * @param FcmRmnOilMonEndRptVO fcmRmnOilMonEndRptVO
	 * @return List<FcmRmnOilMonEndRptVO>
	 * @exception EventException
	 */
	public List<FcmRmnOilMonEndRptVO> searchRemainOilMonthEndReport(FcmRmnOilMonEndRptVO fcmRmnOilMonEndRptVO) throws EventException {
		try {
			return dbDao.searchRemainOilMonthEndReport(fcmRmnOilMonEndRptVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "ROB End Month Report List" }).getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "ROB End Month Report List" }).getMessage(), ex);
		}
	}
	
	/**
	 * Revenue Month별 Vessel 월말 잔량 내역을 변경한다.
	 * 
	 * @param FcmRmnOilMonEndRptVO[] fcmRmnOilMonEndRptVOs
	 * @param String updUsrId
	 * @return int
	 * @exception EventException
	 */
	public int manageRemainOilMonthEndReport(FcmRmnOilMonEndRptVO[] fcmRmnOilMonEndRptVOs, String updUsrId) throws EventException {
		try {
			return dbDao.modifyRemainOilMonthEndReport(fcmRmnOilMonEndRptVOs, updUsrId);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "ROB End Month Report List" }).getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "ROB End Month Report List" }).getMessage(), ex);
		}		
	}
	
	/**
	 * Search auto I/F status.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String searchAutoIFStatus() throws EventException {
		try {
			return dbDao.searchAutoIFStatus();
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Search auto I/F status" }).getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Search auto I/F status" }).getMessage(), ex);
		}
	}
	
}
