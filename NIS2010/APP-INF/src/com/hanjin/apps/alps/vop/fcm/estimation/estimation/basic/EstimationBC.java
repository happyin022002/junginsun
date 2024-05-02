/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrendLineBC.java
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

import java.util.List;

import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.FcmEstmWkCsmIfVO;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.FcmRmnOilMonEndRptVO;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.MonEstmCsmVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Estimation Business Logic Command Interface<br>
 * - ALPS-Estimation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ryu Hyuk
 * @see BudgetPlanEventResponse 참조
 * @since J2EE 1.6
 */
public interface EstimationBC {
	
	/**
	 * Search target VVD list for a monthly estimation consumption.
	 * 
	 * @param String bseYrmon
	 * @return List<MonEstmCsmVO>
	 * @exception EventException
	 *  */
	public List<MonEstmCsmVO> searchMonEstmTgtVvdList(String bseYrmon) throws EventException;
	
//	/**
//	 * Search trend line by VVD.
//	 * 
//	 * @param List<FcmEstmMonCsmIfVO> fcmEstmMonCsmIfVOs
//	 * @exception EventException
//	 */
//	public void searchTrendLineByVvd(List<FcmEstmMonCsmIfVO> fcmEstmMonCsmIfVOs) throws EventException;
//	
//	/**
//	 * Search actual start, end info by VVD.
//	 * 
//	 * @param List<FcmEstmMonCsmIfVO> fcmEstmMonCsmIfVOs
//	 * @exception EventException
//	 */
//	public void searchActStEndByVvd(List<FcmEstmMonCsmIfVO> fcmEstmMonCsmIfVOs) throws EventException;
//	
//	/**
//	 * Search voyage end remain oil weight by VVD.
//	 * 
//	 * @param List<FcmEstmMonCsmIfVO> fcmEstmMonCsmIfVOs
//	 * @exception EventException
//	 */
//	public void searchVoyEndRmnOilWgtByVvd(List<FcmEstmMonCsmIfVO> fcmEstmMonCsmIfVOs) throws EventException;
	
	/**
	 * Search a monthly estimation consumption.
	 * 
	 * @param MonEstmCsmVO[] monEstmCsmVOs
	 * @return List<MonEstmCsmVO>
	 * @exception EventException
	 */
	public List<MonEstmCsmVO> searchMonthlyEstmationConsumption(MonEstmCsmVO[] monEstmCsmVOs) throws EventException;
	
	/**
	 * 주간 추정 대상 항차를 조회한다.
	 * 
	 * @param FcmEstmWkCsmIfVO fcmEstmWkCsmIfVO
	 * @return List<FcmEstmWkCsmIfVO>
	 * @exception EventException
	 *  */
	public List<FcmEstmWkCsmIfVO> searchWeekTgtVvdInfo(FcmEstmWkCsmIfVO fcmEstmWkCsmIfVO) throws EventException;
	
	/**
	 * Execute a weekly fuel consumption estimation.
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String executeWeeklyEstimation() throws EventException;

	/**
	 * Revenue Month별 Vessel 월말 잔량 내역을 조회한다.
	 * 
	 * @param FcmRmnOilMonEndRptVO fcmRmnOilMonEndRptVO
	 * @return List<FcmRmnOilMonEndRptVO>
	 * @exception EventException
	 */
	public List<FcmRmnOilMonEndRptVO> searchRemainOilMonthEndReport(FcmRmnOilMonEndRptVO fcmRmnOilMonEndRptVO) throws EventException;
	
	/**
	 * Revenue Month별 Vessel 월말 잔량 내역을 변경한다.
	 * 
	 * @param FcmRmnOilMonEndRptVO[] fcmRmnOilMonEndRptVOs
	 * @param String updUsrId
	 * @return int
	 * @exception EventException
	 */
	public int manageRemainOilMonthEndReport(FcmRmnOilMonEndRptVO[] fcmRmnOilMonEndRptVOs, String updUsrId) throws EventException;
	
	/**
	 * Search auto I/F status.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String searchAutoIFStatus() throws EventException;

}
