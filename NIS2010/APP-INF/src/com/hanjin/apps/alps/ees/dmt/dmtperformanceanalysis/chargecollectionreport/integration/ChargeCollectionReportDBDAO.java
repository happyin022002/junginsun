/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCollectionReportDBDAO.java
*@FileTitle : Current Collection Status by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.10
*@LastModifier : 정운
*@LastVersion : 1.0
* 2013.12.10 정운
* 1.0 Creation
* 2011.05.12. 김태균 [] 소스원복요청으로 인하여 원복 - [CHM-201110406-01][DMT] Monthly invoiced & collection by office 의 생성결과물 Local 통화 통일 요청
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.basic.ChargeCollectionReportBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionDetailReportByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionReportParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionSummaryReportByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.MonthlyCollectionByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.TmnlContainerExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.TmnlVvdLfdVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.UnissuedInvoiceByAgingParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.UnissuedInvoiceDetailByAgingVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.YearlyCollectionByRHQVO;


/**
 * ALPS ChargeCollectionReportDBDAO <br>
 * - ALPS-DMTPerformanceAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang HyoKeun
 * @see ChargeCollectionReportBCImpl 참조
 * @since J2EE 1.6
 */
public class ChargeCollectionReportDBDAO extends DBDAOSupport {

	/**
	 * Collection Status Report by Office의 상세 내역을 조회한다.
	 * 
	 * @param CollectionReportParmVO collectionReportParmVO
	 * @return List<CollectionSummaryReportByOfficeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CollectionSummaryReportByOfficeVO> searchCollectionSummaryReportByOffice(CollectionReportParmVO collectionReportParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CollectionSummaryReportByOfficeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(collectionReportParmVO != null){
				Map<String, String> mapVO = collectionReportParmVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// DEM/DET Office가 'Office'일 경우, 다중건 선택되어서 온다.
				if(collectionReportParmVO.getOfcFlg().equals("O")) {
					String ofcCd = collectionReportParmVO.getOfcCd();
					List<String> ofcCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(ofcCd, ",");
				    while (st.hasMoreTokens()) {
				    	ofcCdList.add(st.nextToken());
				    }
					velParam.put("ofc_cd_list", ofcCdList);
				}
				
				// Tariff Type Velocity 파라미터 구성 
				String trfCd = collectionReportParmVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				StringTokenizer st2 = new StringTokenizer(trfCd, ",");
			    while (st2.hasMoreTokens()) {
			    	trfCdList.add(st2.nextToken());
			    }
				velParam.put("trf_cd_list", trfCdList);
				
				
				// CNTR Type Velocity 파라미터 구성 
				String cntrTp = collectionReportParmVO.getDmdtCntrTpCd();
				List<String> cntrTpList = new ArrayList<String>();
				StringTokenizer st3 = new StringTokenizer(cntrTp, ",");
			    while (st3.hasMoreTokens()) {
			    	cntrTpList.add(st3.nextToken());
			    }
				velParam.put("cntr_tp_list", cntrTpList);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCollectionReportDBDAOCollectionSummaryReportByOfficeVORSQL(), param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CollectionSummaryReportByOfficeVO .class);
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
	 * 해당기간에 발생한 Charge를 기준으로 하여 조회시점까지 관련 Charge Detail 정보를 조회한다.<br>
	 * 
	 * @param CollectionReportParmVO collectionReportParmVO
	 * @return List<CollectionDetailReportByOfficeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CollectionDetailReportByOfficeVO> searchCollectionDetailReportByOffice(CollectionReportParmVO collectionReportParmVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CollectionDetailReportByOfficeVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(collectionReportParmVO != null){
					Map<String, String> mapVO = collectionReportParmVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					// Tariff Type Velocity 파라미터 구성 
					String trfCd = collectionReportParmVO.getDmdtTrfCd();
					List<String> trfCdList = new ArrayList<String>();
					StringTokenizer st2 = new StringTokenizer(trfCd, ",");
				    while (st2.hasMoreTokens()) {
				    	trfCdList.add(st2.nextToken());
				    }
					velParam.put("trf_cd_list", trfCdList);
					
					
					// CNTR Type Velocity 파라미터 구성 
					String cntrTp = collectionReportParmVO.getDmdtCntrTpCd();
					List<String> cntrTpList = new ArrayList<String>();
					StringTokenizer st3 = new StringTokenizer(cntrTp, ",");
				    while (st3.hasMoreTokens()) {
				    	cntrTpList.add(st3.nextToken());
				    }
					velParam.put("cntr_tp_list", cntrTpList);
				}
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCollectionReportDBDAOCollectionDetailReportByOfficeVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CollectionDetailReportByOfficeVO .class);
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
	 * 월별 Billable/Invoiced/Collection 된 금액 정보를 조회한다.<br>
	 * 
	 * @param CollectionReportParmVO collectionReportParmVO
	 * @return List<MonthlyCollectionByOfficeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MonthlyCollectionByOfficeVO> searchMonthlyCollectionByOffice(CollectionReportParmVO collectionReportParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyCollectionByOfficeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(collectionReportParmVO != null){
				Map<String, String> mapVO = collectionReportParmVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// DEM/DET Office가 'Office'일 경우, 다중건 선택되어서 온다.
				if(collectionReportParmVO.getOfcFlg().equals("O")) {
					String ofcCd = collectionReportParmVO.getOfcCd();
					List<String> ofcCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(ofcCd, ",");
				    while (st.hasMoreTokens()) {
				    	ofcCdList.add(st.nextToken());
				    }
					velParam.put("ofc_cd_list", ofcCdList);
				}
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCollectionReportDBDAOMonthlyCollectionByOfficeVORSQL(), param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyCollectionByOfficeVO .class);
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
	 * 년도별, RHQ OFFICE CODE 별, AGING 정보를 조회한다.<br>
	 * 
	 * @param YearlyCollectionByRHQVO yearlyCollectionByRHQVO
	 * @return List<YearlyCollectionByRHQVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<YearlyCollectionByRHQVO> searchYearlyCollectionByRHQOffice(YearlyCollectionByRHQVO yearlyCollectionByRHQVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YearlyCollectionByRHQVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(yearlyCollectionByRHQVO != null){
				Map<String, String> mapVO = yearlyCollectionByRHQVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// DEM/DET Office가 'Office'일 경우, 다중건 선택되어서 온다.
				if(yearlyCollectionByRHQVO.getOfcFlg().equals("O")) {
					String ofcCd = yearlyCollectionByRHQVO.getOfcCd();
					List<String> ofcCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(ofcCd, ",");
				    while (st.hasMoreTokens()) {
				    	ofcCdList.add(st.nextToken());
				    }
					velParam.put("ofc_cd_list", ofcCdList);
				}
				
				// Tariff Type Velocity 파라미터 구성 
				String trfCd = yearlyCollectionByRHQVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				StringTokenizer st2 = new StringTokenizer(trfCd, ",");
			    while (st2.hasMoreTokens()) {
			    	trfCdList.add(st2.nextToken());
			    }
				velParam.put("trf_cd_list", trfCdList);
				
				
				// CNTR Type Velocity 파라미터 구성 
				String cntrTp = yearlyCollectionByRHQVO.getDmdtCntrTpCd();
				List<String> cntrTpList = new ArrayList<String>();
				StringTokenizer st3 = new StringTokenizer(cntrTp, ",");
			    while (st3.hasMoreTokens()) {
			    	cntrTpList.add(st3.nextToken());
			    }
				velParam.put("cntr_tp_list", cntrTpList);
				
				String status = yearlyCollectionByRHQVO.getStatus();
				List<String> statusList = new ArrayList<String>();
				StringTokenizer st4 = new StringTokenizer(status, ",");
			    while (st4.hasMoreTokens()) {
			    	statusList.add(st4.nextToken());
			    }
				velParam.put("status_list", statusList);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCollectionReportDBDAOSearchYearlyCollectionByRHQRSQL(), param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YearlyCollectionByRHQVO .class);
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
		 * [Terminal LFD Report]을 [SEARCH]합니다.<br>
		 * 
		 * @param TmnlVvdLfdVO tmnlVvdLfdVO
		 * @return List<TmnlVvdLfdVO>
		 * @exception EventException
		 */
	 
		@SuppressWarnings("unchecked")
		public List<TmnlVvdLfdVO> searchTmnlVvdLfd(TmnlVvdLfdVO tmnlVvdLfdVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TmnlVvdLfdVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(tmnlVvdLfdVO != null){
					Map<String, String> mapVO = tmnlVvdLfdVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);							
				}				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCollectionReportDBDAOSearchTmnlVvdLfdRSQL(), param, velParam, true);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlVvdLfdVO .class);
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
		 * [Terminal LFD Report]을 [SEARCH]합니다.<br>
		 * 
		 * @param TmnlVvdLfdVO tmnlVvdLfdVO
		 * @return List<TmnlContainerExceptionVO>
		 * @exception EventException
		 */
	 
		@SuppressWarnings("unchecked")
		public List<TmnlContainerExceptionVO> searchTmnlContainerException(TmnlVvdLfdVO tmnlVvdLfdVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TmnlContainerExceptionVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(tmnlVvdLfdVO != null){
					Map<String, String> mapVO = tmnlVvdLfdVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);							
				}				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCollectionReportDBDAOSearchTmnlContainerExceptionRSQL(), param, velParam, true);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlContainerExceptionVO .class);
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
		 * [UnissuedInvoiceDetailByAging]을 [SEARCH]합니다.<br>
		 * 
		 * @param UnissuedInvoiceByAgingParmVO unissuedInvoiceByAgingParmVO
		 * @return List<UnissuedInvoiceDetailByAgingVO>
		 * @exception EventException
		 */
		
		@SuppressWarnings("unchecked")
		public List<UnissuedInvoiceDetailByAgingVO> searchUnissuedInvoiceDetailByAging(UnissuedInvoiceByAgingParmVO unissuedInvoiceByAgingParmVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<UnissuedInvoiceDetailByAgingVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(unissuedInvoiceByAgingParmVO != null){
					Map<String, String> mapVO = unissuedInvoiceByAgingParmVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					// Tariff Type Velocity 파라미터 구성 
					String trfCd = unissuedInvoiceByAgingParmVO.getDmdtTrfCd();
					if(trfCd != null && !trfCd.equals("")) {
						List<String> trfCdList = new ArrayList<String>();
						StringTokenizer st2 = new StringTokenizer(trfCd, ",");
					    while (st2.hasMoreTokens()) {
					    	trfCdList.add(st2.nextToken());
					    }
						velParam.put("trf_cd_list", trfCdList);	
					}					
					
					// CNTR Type Velocity 파라미터 구성
					String cntrTp = unissuedInvoiceByAgingParmVO.getDmdtCntrTpCd();
					if(cntrTp != null && !cntrTp.equals("")) {
						List<String> cntrTpList = new ArrayList<String>();
						StringTokenizer st3 = new StringTokenizer(cntrTp, ",");
					    while (st3.hasMoreTokens()) {
					    	cntrTpList.add(st3.nextToken());
					    }
						velParam.put("cntr_tp_list", cntrTpList);	
					}
					
					
					// STS CD 파라미터 구성 
					String dmdtChgStsCd = unissuedInvoiceByAgingParmVO.getDmdtChgStsCd();
					if(dmdtChgStsCd != null && !dmdtChgStsCd.equals("")) {
						List<String> stsCdList = new ArrayList<String>();
						StringTokenizer st4 = new StringTokenizer(dmdtChgStsCd, ",");
						while (st4.hasMoreTokens()) {
							stsCdList.add(st4.nextToken());
						}
						velParam.put("sts_cd_list", stsCdList);	
					}
				}
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCollectionReportDBDAOUnissuedInvoiceDetailByAgingVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnissuedInvoiceDetailByAgingVO .class);
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