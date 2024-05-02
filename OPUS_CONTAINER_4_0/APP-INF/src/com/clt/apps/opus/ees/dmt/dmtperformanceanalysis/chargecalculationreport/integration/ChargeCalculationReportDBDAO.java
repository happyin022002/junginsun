/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationReportDBDAO.java
*@FileTitle : Deleted Charge Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.15 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.basic.ChargeCalculationReportBCImpl;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ChargeCalculationReportDBDAO <br>
 * - DMTPerformanceAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang HyoKeun
 * @see ChargeCalculationReportBCImpl 참조
 * @since J2EE 1.6
 */
public class ChargeCalculationReportDBDAO extends DBDAOSupport {

	/**
	 * Delete된 Charge의 Summary정보를 조회한다..<br>
	 * 
	 * @param DeleteInquiryParmVO deleteInquiryParmVO
	 * @return List<DeleteInquiryByOfficeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DeleteInquiryByOfficeVO> searchDeletedChargeListByOffice(DeleteInquiryParmVO deleteInquiryParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DeleteInquiryByOfficeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(deleteInquiryParmVO != null){
				Map<String, String> mapVO = deleteInquiryParmVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// DEM/DET Office --> 'Office'
				if(deleteInquiryParmVO.getOfcFlg().equals("O")) {
					
					String ofcCd = deleteInquiryParmVO.getOfcCd();
					List<String> ofcCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(ofcCd, ",");
				    while (st.hasMoreTokens()) {
				    	ofcCdList.add(st.nextToken());
				    }
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAODeleteInquiryByOfficeVORSQL(), param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DeleteInquiryByOfficeVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 
	/**
	 * Delete Charge의 상세정보를 조회한다.<br>
	 * 
	 * @param DeleteInquiryParmVO deleteInquiryParmVO
	 * @return List<DeleteInquiryByOfficeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DeleteInquiryByOfficeDetailVO> searchDeletedChargeDetailListByOffice(DeleteInquiryParmVO deleteInquiryParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DeleteInquiryByOfficeDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(deleteInquiryParmVO != null) {
				Map<String, String> mapVO = deleteInquiryParmVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// Delete Type
				String delCd = deleteInquiryParmVO.getDelCd();
				List<String> delCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(delCd, ",");
			    while (st.hasMoreTokens()) {
			    	delCdList.add(st.nextToken());
			    }
				velParam.put("del_cd_list", delCdList);
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAODeleteInquiryByOfficeDetailVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DeleteInquiryByOfficeDetailVO .class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 
	 /**
	 * Delete된 Charge의 Summary정보를 조회한다..<br>
	 * 
	 * @param SummaryReportByCustomerParmVO summaryReportByCustomerParmVO
	 * @return List<SummaryReportByCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SummaryReportByCustomerVO> searchSummaryReportByCustomer(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SummaryReportByCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(summaryReportByCustomerParmVO != null){
				Map<String, String> mapVO = summaryReportByCustomerParmVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				
				// Tariff type 
				String trfCd = summaryReportByCustomerParmVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(trfCd, ",");
			    while (st.hasMoreTokens()) {
			    	trfCdList.add(st.nextToken());
			    }
				velParam.put("trf_cd_list", trfCdList);
				
				
				// S/C No. or RFA No.
				if(summaryReportByCustomerParmVO.getSchFlg().equals("SC") || summaryReportByCustomerParmVO.getSchFlg().equals("RFA")) {
					String scRfaCd = summaryReportByCustomerParmVO.getScRfaNo();
					List<String> scRfaCdList = new ArrayList<String>();
					StringTokenizer st2 = new StringTokenizer(scRfaCd, ",");
				    while (st2.hasMoreTokens()) {
				    	scRfaCdList.add(st2.nextToken());
				    }
					velParam.put("sc_rfa_cd_list", scRfaCdList);
				}
				
				
				// DEM/DET Office --> 'Office'
				if(summaryReportByCustomerParmVO.getOfcFlg().equals("O")) {
					String ofcCd = summaryReportByCustomerParmVO.getOfcCd();
					List<String> ofcCdList = new ArrayList<String>();
					StringTokenizer st3 = new StringTokenizer(ofcCd, ",");
				    while (st3.hasMoreTokens()) {
				    	ofcCdList.add(st3.nextToken());
				    }
					velParam.put("ofc_cd_list", ofcCdList);
				}
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAOSummaryReportByCustomerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SummaryReportByCustomerVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 
	/**
	 * Customer별 발생 Charge의 Detail 정보를 조회한다.<br>
	 * 
	 * @param SummaryReportByCustomerParmVO summaryReportByCustomerParmVO
	 * @return List<SummaryReportByCustomerDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SummaryReportByCustomerDetailVO> searchSummaryReportDetailByCustomer(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SummaryReportByCustomerDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(summaryReportByCustomerParmVO != null){
				Map<String, String> mapVO = summaryReportByCustomerParmVO .getColumnValues();
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
				
				velParam.put("sc_no", summaryReportByCustomerParmVO.getScNo());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAOSummaryReportByCustomerDetailVORSQL(), param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SummaryReportByCustomerDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}