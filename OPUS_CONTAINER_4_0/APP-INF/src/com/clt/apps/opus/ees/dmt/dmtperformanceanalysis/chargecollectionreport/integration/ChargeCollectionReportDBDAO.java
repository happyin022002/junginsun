/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCollectionReportDBDAO.java
*@FileTitle : Current Collection Status by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.18 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.basic.ChargeCollectionReportBCImpl;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionDetailReportByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionReportParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionSummaryReportByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.MonthlyCollectionByOfficeVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ChargeCollectionReportDBDAO <br>
 * - DMTPerformanceAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
}