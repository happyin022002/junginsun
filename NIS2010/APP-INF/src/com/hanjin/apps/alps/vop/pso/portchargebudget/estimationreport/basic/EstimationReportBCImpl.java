/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EstimationReportBCImpl.java
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
 * 2013.09.03 SKY    CHM-201326398 Monthly Estimation Comparision 검색 조건(Scenario CD) 추가
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.integration.EstimationReportDBDAO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.BudgetSmryByVvdVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.EstimationByVvdVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmCompVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmRawDataForBudVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmRawDataVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-PortChargeBudget Business Logic Basic Command implementation<br>
 * - ALPS-PortChargeBudget에 대한 비지니스 로직을 처리한다.<br>
 * @author S.K.Y
 * @see VOP_PSO_0100EventResponse,EstimationReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EstimationReportBCImpl extends BasicCommandSupport implements EstimationReportBC {

	// Database Access Object
	private transient EstimationReportDBDAO dbDao = null;

	/**
	 * BudgetPortChargeMgtBCImpl 객체 생성<br>
	 * BudgetPortChargeMgtDBDAO를 생성한다.<br>
	 */
	public EstimationReportBCImpl() {
		dbDao = new EstimationReportDBDAO();
	}
	
	/**
	 * parameterized constructor
	 * @param dataSource
	 */
	public EstimationReportBCImpl(String dataSource) {
		dbDao = new EstimationReportDBDAO(dataSource);
	}

   /**
	 * VOP_PSO_0100 Monthly Estimation by VVD
	 * @category VOP_PSO_0100_Retrieve (sky)
	 * @param EstimationByVvdVO estimationByVvdVO
	 * @return List<EstimationByVvdVO>
	 * @throws EventException
	 */
	public List<EstimationByVvdVO> searchMonthlyByVvd(EstimationByVvdVO estimationByVvdVO) throws EventException {
		try {
			return dbDao.searchMonthlyByVvd(estimationByVvdVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
	  
	}
	
	
	
	/**
	 * revYrmon 의 Budget Summary by VVD Retrieve
	 * @param BudgetSmryByVvdVO budgetSmryByVvdVO
	 * @return List<BudgetSmryByVvdVO>
	 * @throws EventException
	 */
	
	
	
	public List<BudgetSmryByVvdVO> searchBudgetSmryByVvd(BudgetSmryByVvdVO budgetSmryByVvdVO) throws EventException {
		try {
			return dbDao.searchBudgetSmryByVvd(budgetSmryByVvdVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Budget Summary By VVD"}).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
	  
	}
	
	
	/**
	 * revYrmon 의 Budget Summary by Month Retrieve
	 * @param BudgetSmryByVvdVO budgetSmryByVvdVO
	 * @return  List<BudgetSmryByVvdVO>
	 * @throws EventException
	 */
	
	
	
	public List<BudgetSmryByVvdVO> searchBudgetSmryByMon(BudgetSmryByVvdVO budgetSmryByVvdVO) throws EventException {
		try {
			return dbDao.budgetSmryByMonth(budgetSmryByVvdVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Budget Summary By Month"}).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
	  
	}
	
	
	/**
	 * revYrmon 의 Monthly Estimation Retrieve
	 * @param String revYrmon
	 * @param String chkRdo
	 * @param String scnCd
	 * @return List<MonEstmComp2VO>
	 * @throws EventException
	 */
	public List<MonEstmCompVO> searchMonEstmCompList(String revYrmon, String chkRdo, String scnCd) throws EventException{
		try {
			if("B".equals(chkRdo)){
				
//				String budStr = "";
//				String budYrmon = revYrmon.substring(5,7);
//				if(Integer.parseInt(budYrmon)<7){
//					budStr = "BP";
//				}else if(Integer.parseInt(budYrmon)<10){
//					budStr = "BP";
//				}else {
//					budStr = "Q4";
//				}
//				
							
				return dbDao.searchMonEstmCompListForBudget(revYrmon,scnCd);
			}else{
				return dbDao.searchMonEstmCompList(revYrmon,chkRdo);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Comparison"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Monthly Estimation간의 차이를 Retrieve
	 * @param String revYrmon
	 * @param String chkRdo
	 * @param String scnCd
	 * @return List<MonEstmComp2VO>
	 * @throws EventException
	 */
	public List<MonEstmCompVO> searchMonEstmCompDiffList(String revYrmon, String chkRdo,  String scnCd) throws EventException{
		try {
			
			if("B".equals(chkRdo)){
				
//				String budStr = "";
//				String budYrmon = revYrmon.substring(5,7);
//				if(Integer.parseInt(budYrmon)<7){
//					budStr = "BP";
//				}else if(Integer.parseInt(budYrmon)<10){
//					budStr = "BP";
//				}else {
//					budStr = "Q4";
//				}
				
				return dbDao.searchMonEstmCompDiffListWithBudget(revYrmon, scnCd);
			}else{
				return dbDao.searchMonEstmCompDiffList(revYrmon,chkRdo);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Comparison"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}

	
	/**
	 * Raw data : 추정결산 VVD별 집계 
	 * @param String revYrmon
	 * @param String rawFlg
	 * @return List<MonEstmRawDataVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataVO> searchMonEstmRawDataListByVvd(String revYrmon, String rawFlg) throws EventException{
		try {
			return dbDao.searchMonEstmRawDataListByVvd(revYrmon,rawFlg);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Comparison"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * Raw data : 추정결산 YD별 집계 
	 * @param String revYrmon
	 * @param String rawFlg
	 * @return List<MonEstmRawDataVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataVO> searchMonEstmRawDataListByYd(String revYrmon, String rawFlg) throws EventException{
		try {
			return dbDao.searchMonEstmRawDataListByYd(revYrmon,rawFlg);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Comparison"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * Raw data : 추정결산 ACCT별 집계 
	 * @param String revYrmon
	 * @param String rawFlg
	 * @return List<MonEstmRawDataVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataVO> searchMonEstmRawDataListByAcct(String revYrmon, String rawFlg) throws EventException{
		try {
			return dbDao.searchMonEstmRawDataListByAcct(revYrmon,rawFlg);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Comparison"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * Raw data for budget : 추정결산 VBP별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataForBudVO> searchRawDataByVBPForBudget(String revYrmon, String scnCd) throws EventException{
		try {
			return dbDao.searchRawDataByVBPForBudget(revYrmon,scnCd);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Comparison"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * Raw data for budget : 추정결산 VVD별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataForBudVO> searchRawDataByVvdForBudget(String revYrmon, String scnCd) throws EventException{
		try {
			return dbDao.searchRawDataByVvdForBudget(revYrmon,scnCd);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Comparison"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * Raw data for budget : 추정결산 YD별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataForBudVO> searchRawDataByYdForBudget(String revYrmon, String scnCd) throws EventException{
		try {
			return dbDao.searchRawDataByYdForBudget(revYrmon,scnCd);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Comparison"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * Raw data for budget : 추정결산 ACCT별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws EventException
	 */
	public List<MonEstmRawDataForBudVO> searchRawDataByAcctForBudget(String revYrmon, String scnCd) throws EventException{
		try {
			return dbDao.searchRawDataByAcctForBudget(revYrmon,scnCd);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Comparison"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}
	
	
}