/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EstimationReportBC.java
*@FileTitle : Estimation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.18
*@LastModifier : S.K.Y
*@LastVersion : 1.0
* 2013.03.18 S.K.Y
* 1.0 Creation
* 
* History
 * 2013.03.18 S.K.Y  CHM-201323211 월 추정 Report 개발 (진행항차)
 * 2013.03.18 S.K.Y  CHM-201323212 월 추정 Report 개발 (대상항차)
 * 2013.04.26 조정민    CHM-201323376 Monthly Estimation Comparison (raw date 다운 포함)
 * 2013.06.10 S.K.Y  CHM-201323634 Budget Summary 조회 기능
 * 2013.09.03 SKY   CHM-201326398 Monthly Estimation Comparision 검색 조건(Scenario CD) 추가 
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.BudgetSmryByVvdVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.EstimationByVvdVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmCompVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmRawDataForBudVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmRawDataVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Portchargebudget Business Logic Command Interface<br>
 * - ALPS-Portchargebudget에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author S.K.Y
 * @see Vop_pso_0025EventResponse 참조
 * @since J2EE 1.6
 */

public interface EstimationReportBC {
	
	/**
	 * VOP_PSO_0100 Monthly Estimation by VVD
	 * @category VOP_PSO_0100_Retrieve (sky)
	 * @param EstimationByVvdVO estimationByVvdVO
	 * @return List<EstimationByVvdVO>
	 * @throws EventException
	 */
	public List<EstimationByVvdVO> searchMonthlyByVvd(EstimationByVvdVO estimationByVvdVO) throws EventException;
	
   
	/**
	 * VOP_PSO_0102 Budget Summary by VVD
	 * @category VOP_PSO_0102_Retrieve (sky)
	 * @param BudgetSmryByVvdVO budgetSmryByVvdVO
	 * @return List<EstimationByVvdVO>
	 * @throws EventException
	 */
	public List<BudgetSmryByVvdVO> searchBudgetSmryByVvd(BudgetSmryByVvdVO budgetSmryByVvdVO) throws EventException;
	
	
	/**
	 * revYrmon 의 Monthly Estimation Retrieve
	 * @param String revYrmon
	 * @param String chkRdo
	 * @param String scnCd
	 * @return List<MonEstmComp2VO>
	 * @throws EventException
	 */
	public List<MonEstmCompVO> searchMonEstmCompList(String revYrmon, String chkRdo, String scnCd) throws EventException;
	
	/**
	 * Monthly Estimation간의 차이를 Retrieve
	 * @param String revYrmon
	 * @param String chkRdo
	 * @param String scnCd 
	 * @return List<MonEstmComp2VO>
	 * @throws EventException
	 */
	public List<MonEstmCompVO> searchMonEstmCompDiffList(String revYrmon, String chkRdo, String scnCd) throws EventException;
	
	/**
	 * @param String revYrmon
	 * @param String rawFlg
	 * @return List<MonEstmRawDataVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataVO> searchMonEstmRawDataListByVvd(String revYrmon, String rawFlg) throws EventException;
	
	/**
	 * @param String revYrmon
	 * @param String rawFlg
	 * @return List<MonEstmRawDataVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataVO> searchMonEstmRawDataListByYd(String revYrmon, String rawFlg) throws EventException;
	
	/**
	 * @param String revYrmon
	 * @param String rawFlg
	 * @return List<MonEstmRawDataVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataVO> searchMonEstmRawDataListByAcct(String revYrmon, String rawFlg) throws EventException;
	
	/**
	 * Raw data for budget : 추정결산 VBP별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataForBudVO> searchRawDataByVBPForBudget(String revYrmon, String scnCd) throws EventException;
	
	/**
	 * Raw data for budget : 추정결산 VVD별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataForBudVO> searchRawDataByVvdForBudget(String revYrmon, String scnCd) throws EventException;
	
	/**
	 * Raw data for budget : 추정결산 YD별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataForBudVO> searchRawDataByYdForBudget(String revYrmon, String scnCd) throws EventException;
	
	/**
	 * Raw data for budget : 추정결산 ACCT별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataForBudVO> searchRawDataByAcctForBudget(String revYrmon, String scnCd) throws EventException;
	
	
	/**
	 * VOP_PSO_0102 Budget Summary by Month
	 * @category VOP_PSO_0102_Retrieve (sky)
	 * @param BudgetSmryByVvdVO budgetSmryByVvdVO
	 * @return List<BudgetSmryByVvdVO>
	 * @throws EventException
	 */
	public List<BudgetSmryByVvdVO> searchBudgetSmryByMon(BudgetSmryByVvdVO budgetSmryByVvdVO) throws EventException;
	


}