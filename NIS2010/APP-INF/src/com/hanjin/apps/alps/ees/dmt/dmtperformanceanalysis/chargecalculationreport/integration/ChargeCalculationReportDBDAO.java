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
* 2011.08.11 김경섭[CHM-201112592-01][DMT]Deleted Charge Report by Office 화면 보완 3010 > 3011조회시 Office 다중조회 가능토록함.
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DeleteReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.basic.ChargeCalculationReportBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.UsLfdEdiAudidtListVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.UsLfdEdiAudidtParmVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ChargeCalculationReportDBDAO <br>
 * - ALPS-DMTPerformanceAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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

		try {
			if (deleteInquiryParmVO != null) {
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

				// Period : From Date 선택한 경우
				if ("F".equals(deleteInquiryParmVO.getDtFlg())) {
					dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAODeleteInquiryByOfficeVORSQL(), param, velParam, true);
				}
				// Period : Deleted Date 선택한 경우				
				else {
					dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAODeleteInquiryByDeleteDateRSQL(), param, velParam, true);
				}
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DeleteInquiryByOfficeVO .class);
		} 
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} 
		catch(Exception ex) {
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
			if (deleteInquiryParmVO != null) {
				Map<String, String> mapVO = deleteInquiryParmVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// Delete Type
				/*String delCd = deleteInquiryParmVO.getDelCd();
				List<String> delCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(delCd, ",");
			    while (st.hasMoreTokens()) {
			    	delCdList.add(st.nextToken());
			    }
				velParam.put("del_cd_list", delCdList);*/
			
				// Period : From Date 선택한 경우
				if ("F".equals(deleteInquiryParmVO.getDtFlg())) {
					dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAODeleteInquiryByOfficeDetailVORSQL(), param, velParam);	
				}
				// Period : Deleted Date 선택한 경우		
				else {
					dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAODeleteInquiryByDeleteDateDetailRSQL(), param, velParam);
				}
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DeleteInquiryByOfficeDetailVO .class);			
			}
		} 
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} 
		catch(Exception ex) {
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
				
				// Customer List
				if(summaryReportByCustomerParmVO.getCustType().length() > 0) {
					String custType = summaryReportByCustomerParmVO.getCustType();
					StringTokenizer st4 = new StringTokenizer(custType, ",");
					String cust = "";
				    while (st4.hasMoreTokens()) {
				    	cust = st4.nextToken();
				    	velParam.put("cust_type_"+cust, cust);
				    	param.put("cust_type_"+cust, cust);
				    }
				}
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAOSummaryReportByCustomerVORSQL(), param, velParam);
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
	 

		/**
		 * US LFD EDI Audidt 정보를 조회한다.<br>
		 * 
		 * @param UsLfdEdiAudidtParmVO usLfdEdiAudidtParmVO
		 * @return List<UsLfdEdiAudidtListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<UsLfdEdiAudidtListVO> searchUsLfdEdiAudidtList(UsLfdEdiAudidtParmVO usLfdEdiAudidtParmVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<UsLfdEdiAudidtListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(usLfdEdiAudidtParmVO != null){
					Map<String, String> mapVO = usLfdEdiAudidtParmVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);

					// bkg_no
					String bkgNo = usLfdEdiAudidtParmVO.getBkgNo();
					List<String> bkgNoList = new ArrayList<String>();
					StringTokenizer st1 = new StringTokenizer(bkgNo, ",");
				    while (st1.hasMoreTokens()) {
				    	bkgNoList.add(st1.nextToken());
				    }
					velParam.put("bkg_no_list", bkgNoList);
					
					// cntr_no
					String cntrNo = usLfdEdiAudidtParmVO.getCntrNo();
					List<String> cntrNoList = new ArrayList<String>();
					StringTokenizer st2 = new StringTokenizer(cntrNo, ",");
				    while (st2.hasMoreTokens()) {
				    	cntrNoList.add(st2.nextToken());
				    }
					velParam.put("cntr_no_list", cntrNoList);
					
					// result
					String tpsz = usLfdEdiAudidtParmVO.getCntrTpszCd();
					List<String> tpszList = new ArrayList<String>();
					StringTokenizer st3 = new StringTokenizer(tpsz, ",");
				    while (st3.hasMoreTokens()) {
				    	tpszList.add(st3.nextToken());
				    }
					velParam.put("cntr_tpsz_cd_list", tpszList);
					
					// result
					String result = usLfdEdiAudidtParmVO.getResult();
					List<String> resultList = new ArrayList<String>();
					StringTokenizer st4 = new StringTokenizer(result, ",");
				    while (st4.hasMoreTokens()) {
				    	resultList.add(st4.nextToken());
				    }
					velParam.put("result_list", resultList);
					
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAOUsLfdEdiAudidtListRSQL(), param, velParam, true);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsLfdEdiAudidtListVO.class);
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
		public List<SummaryReportByCustomerVO> searchSummaryReportByCustomerBkg(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO) throws DAOException {
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
					
					// Customer List
					if(summaryReportByCustomerParmVO.getCustType().length() > 0) {
						String custType = summaryReportByCustomerParmVO.getCustType();
						StringTokenizer st4 = new StringTokenizer(custType, ",");
						String cust = "";
					    while (st4.hasMoreTokens()) {
					    	cust = st4.nextToken();
					    	velParam.put("cust_type_"+cust, cust);
					    	param.put("cust_type_"+cust, cust);
					    }
					}
				}
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAOSummaryReportByCustomerBkgVORSQL(), param, velParam);
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
		 * Charge Delete Reason을 조회한다.<br>
		 * 
		 * @return List<DeleteReasonListVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<DeleteReasonListVO> searchDeleteReasonList() throws DAOException {
		
			List<DeleteReasonListVO> list = null;
			//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
			DBRowSet dbRowset = null;
			//query parameter
			//Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			//Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAODeleteReasonListVORSQL(), null, null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DeleteReasonListVO.class);
				return list;
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		

		/**
		 * Charge Delete Reason을 조회한다.<br>
		 * 
		 * @param String delCd
		 * @return List<DeleteReasonListVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<DeleteReasonListVO> searchDeleteSpecificReasonList(String delCd) throws DAOException {
		
			List<DeleteReasonListVO> list = null;
			//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			//Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{			

				param.put("del_cd",     delCd);
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationReportDBDAODeleteSpecificReasonListVORSQL(), param, null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DeleteReasonListVO.class);
				return list;
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
}