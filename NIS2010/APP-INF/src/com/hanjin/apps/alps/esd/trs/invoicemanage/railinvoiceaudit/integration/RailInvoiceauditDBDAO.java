/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : railInvoiceauditDBDAO.java
*@FileTitle : USA Rail Invoice Agree and Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-08
*@LastModifier : chkong
*@LastVersion : 1.0
* 2006-12-08 chkong
* 1.0 최초 생성
* 
* 2011.12.09 민정호 [CLT-111121293] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import weblogic.GetMessage;

import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0038Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0923Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0925Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0929Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspRailInvDtlVO;


/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author chkong
 * @see railInvoiceauditBCImpl 참조
 * @since J2EE 1.4
 */
public class RailInvoiceauditDBDAO extends DBDAOSupport {

	/**
	 * Payment VNDR Info을 가져온다.<br>
	 * @param event 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPaymentVndrList(EsdTrs0038Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOSearchPaymentVndrListRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
	
    	/**
		 * Railinvoiceaudit의 모든 목록을 가져온다.<br>
    	 * @param event 
    	 * @param rail_inv_aud_cd 
		 * 
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet searchRailinvoiceauditList(EsdTrs0038Event event , String rail_inv_aud_cd) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				
				Map<String, String> mapVO = event.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("railInvAudCd", rail_inv_aud_cd);
				velParam.put("railInvAudCd", rail_inv_aud_cd);
				
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOSearchRailinvoiceauditDtlRSQL(), param, velParam);
				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return dbRowset;
		}

    	/**
		 * Railinvoiceaudit의 모든 목록을 가져온다.<br>
    	 * @param event 
		 * 
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet searchRailinvoiceaudit(EsdTrs0038Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				
				Map<String, String> mapVO = event.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOSearchRailinvoiceauditRSQL(), param, velParam);
				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return dbRowset;
		}
		
    	/**
		 * Payment History 모든 목록을 가져온다.<br>
    	 * @param event 
		 * 
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet searchPaymentHistoryList(EsdTrs0929Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			try{
				Map<String, String> condiParams = event.getColumnValues();
				param.put("eq_no", condiParams.get("cntr_no"));
				
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOSearchPaymentHistoryListRSQL(), param, param);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return dbRowset;
		}
		
    	/**
		 * Railinvoiceaudit의 저장전에 체크한다.<br>
    	 * @param event 
		 * 
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet[]  searchReAuditVerify(EsdTrs0038Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();
			
			try {
				
				Map<String, String> mapVO = event.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				for(int i = 0; i < model.length; i++){
					if ( !"D".equals(model[i].getIbflag()) && !"0".equals(model[i].getPayFlg()) ){
						param.put("eq_no", model[i].getEqNo());
						velParam.put("eq_no", model[i].getEqNo());
						
						param.put("wbl_dt", model[i].getWblDt());
						velParam.put("wbl_dt", model[i].getWblDt());
						
						dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOSearchReAuditVerifyRSQL(), param, velParam);
						
						if(dbRowset.next()) throw new DAOException(new ErrorHandler("TRS00101", new String[]{dbRowset.getString("EQ_NO"), dbRowset.getString("INV_NO")}).getMessage());
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return null;			
		}
		
		/**
		 * Railinvoiceaudit의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
		 * 
		 * @param event 
		 * @throws DAOException
		 */
		public void modifyTRS_TRSP_RAIL_INV_DTL(EsdTrs0038Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			List<TrsTrspRailInvDtlVO> voListSubInvSeq = new ArrayList<TrsTrspRailInvDtlVO>();
			List<TrsTrspRailInvDtlVO> voListNoSubInvSeq = new ArrayList<TrsTrspRailInvDtlVO>();
			List<TrsTrspRailInvDtlVO> voListCfHjs = new ArrayList<TrsTrspRailInvDtlVO>();
			List<TrsTrspRailInvDtlVO> voListCfOther = new ArrayList<TrsTrspRailInvDtlVO>();
			
			TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();
			
			int insCntArr[] = null;
			int insCnt = 0;
			
			try{
				Map<String, String> mapVO = event.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// RailInvoiceauditDBDAOModifyTrsRailInvCntRSQL 함수 호출
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOModifyTrsRailInvCntRSQL(), param, velParam);
				
				dbRowset.next();
				int resultValue = dbRowset.getInt("cnt");
				
				if(resultValue == 0){
					// RailInvoiceauditDBDAOModifyTrsRailInvDtlCSQL 함수 호출
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailInvoiceauditDBDAOModifyTrsRailInvDtlCSQL(), param, velParam);
					if(insCnt== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No 0 SQL");					
				}else{
					// RailInvoiceauditDBDAOModifyTrsRailInvDtlUSQL 함수 호출
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailInvoiceauditDBDAOModifyTrsRailInvDtlUSQL(), param, velParam);
					if(insCnt== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No 0 SQL");
				}
				
				for(int i = 0; i < model.length; i++){
					if ( model[i].getIbflag().length() > 0 ){
						if( !"".equals(model[i].getSubInvSeq().trim()) ){
							voListSubInvSeq.add(model[i]);
						}else if( "".equals(model[i].getSubInvSeq().trim()) ){
							voListNoSubInvSeq.add(model[i]);
						}
						
						if( "CF".equals(event.getSStsCd()) ){
							if( "1".equals(model[i].getPayFlg()) ){
								if( "SML".equals(model[i].getTrspInvCoIndCd()) ){
									voListCfHjs.add(model[i]);
								}else{
									voListCfOther.add(model[i]);
								}
							}
						}
					}					
				}

				if( voListSubInvSeq.size() > 0 ){
					// RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlUSQL 함수 호출
					insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlUSQL(), voListSubInvSeq, param, velParam);
					for(int j = 0; j < insCntArr.length; j++){
						if(insCntArr[j]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ j + " SQL");
					}
				}
				
				if( voListNoSubInvSeq.size() > 0 ){
					// RailInvoiceauditDBDAOModifyTrsRailInvDtlDSQL 함수 호출
					insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailInvoiceauditDBDAOModifyTrsRailInvDtlDSQL(), voListNoSubInvSeq, param, velParam);
					for(int j = 0; j < insCntArr.length; j++){
						if(insCntArr[j]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ j + " SQL");
					}
					
					// RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlCSQL 함수 호출
					insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlCSQL(), voListNoSubInvSeq, param, velParam);
					for(int j = 0; j < insCntArr.length; j++){
						if(insCntArr[j]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ j + " SQL");
					}
				}
				
				if( voListCfHjs.size() > 0 ){
					// RailInvoiceauditDBDAOModifyTrsRailInvDtlConvAmtUSQL 함수 호출
					insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailInvoiceauditDBDAOModifyTrsRailInvDtlConvAmtUSQL(), voListCfHjs, param, velParam);
					for(int j = 0; j < insCntArr.length; j++){
						if(insCntArr[j]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ j + " SQL");
					}
					
					// RailInvoiceauditDBDAOModifyTrsRailInvDtlVndrSetUSQL 함수 호출
					insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailInvoiceauditDBDAOModifyTrsRailInvDtlVndrSetUSQL(), voListCfHjs, param, velParam);
					for(int j = 0; j < insCntArr.length; j++){
						if(insCntArr[j]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ j + " SQL");
					}
				}
				if( voListCfOther.size() > 0 ){					
					// RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL 함수 호출
					insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL(), voListCfOther, param, velParam);
					for(int j = 0; j < insCntArr.length; j++){
						if(insCntArr[j]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ j + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
		}


    	/**
		 * CLM History 모든 목록을 가져온다.<br>
    	 * @param event 
		 * 
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet searchCLMHistory(EsdTrs0925Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			try{
				Map<String, String> condiParams = event.getColumnValues();
				param.putAll(condiParams);
				
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOSearchCLMHistoryRSQL(), param, param);
				log.debug("searchCLMHistory count >>>>>>>>>>>>>>>>:"+dbRowset.getRowCount());
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return dbRowset;
		}

	   	/**
		 * Invoice 목록을 가져온다.<br>
	   	 * @param event 
		 * 
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet searchInvoiceList(EsdTrs0925Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			try{
				Map<String, String> condiParams = event.getColumnValues();
				param.putAll(condiParams);
				
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOSearchInvoiceListRSQL(), param, param);
				log.debug("searchInvoiceList count >>>>>>>>>>>>>>>>:"+dbRowset.getRowCount());
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return dbRowset;
		}
		
	   	/**
		 * Billing History 모든 목록을 가져온다.<br>
	   	 * @param event 
		 * 
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet searchBillingList(EsdTrs0925Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			try{
				Map<String, String> condiParams = event.getColumnValues();
				param.putAll(condiParams);
				
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOSearchBillingListRSQL(), param, param);
				log.debug("searchBillingList count >>>>>>>>>>>>>>>>:"+dbRowset.getRowCount());
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return dbRowset;
		}

	   	/**
		 * Billing History 모든 목록을 가져온다.<br>
	   	 * @param event 
		 * 
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet searchContainerInfo(EsdTrs0038Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				
				Map<String, String> mapVO = event.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOSearchContainerInfoRSQL(), param, velParam);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return dbRowset;
		}
		
		/**
		 * Invoice File Verify List<br>
		 * 
		 * @param event
		 * @return 
		 * @throws DAOException
		 */
		public ArrayList verifyInvoiceFileImportEqNo(EsdTrs0923Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();

			ArrayList returnList = null;
			
			try{				
				for(int i = 0; i < model.length; i++){
					if(returnList == null) returnList = new ArrayList();
					if(event != null && !"".equals(model[i].getCntrNo())){
						param.put("cntrNo", model[i].getCntrNo());
						velParam.put("cntrNo", model[i].getCntrNo());						
					}else{
						param.put("cntrNo", "");
						velParam.put("cntrNo", "");
					}					
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOSearchVerifyInvoiceFileImportEqNoRSQL(), param, velParam);
					
					returnList.add(dbRowset);
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return returnList;
		}
		
		/**
		 * Invoice File Verify List<br>
		 * 
		 * @param event
		 * @return 
		 * @throws DAOException
		 */
		public ArrayList verifyInvoiceFileImportInvNo(EsdTrs0923Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();

			ArrayList returnList = null;
			
			try{
				for(int i = 0; i < model.length; i++){
					if(returnList == null) returnList = new ArrayList();
					if(event != null && !"".equals(model[i].getCntrNo())){
						param.put("cntrNo", model[i].getCntrNo());
						velParam.put("cntrNo", model[i].getCntrNo());						
					}else{
						param.put("cntrNo", "");
						velParam.put("cntrNo", "");
					}
					
					if(event != null && !"".equals(model[i].getWblDt())){
						param.put("wblDt", model[i].getWblDt());
						velParam.put("wblDt", model[i].getWblDt());						
					}else{
						param.put("wblDt", "");
						velParam.put("wblDt", "");
					}

					param.put("railRoadCode", event.getRailRoadCode());
					velParam.put("railRoadCode", event.getRailRoadCode());
					
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOVerifyInvoiceFileImportInvNoRSQL(), param, velParam);
					
					returnList.add(dbRowset);
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return returnList;
		}
		
		/**
		 * Invoice File Verify List<br>
		 * 
		 * @param event
		 * @return 
		 * @throws DAOException
		 */
		public ArrayList verifyInvoiceFileImportVndrSetList(EsdTrs0923Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();

			ArrayList returnList = null;
			
			try{
				for(int i = 0; i < model.length; i++){
					if(returnList == null) returnList = new ArrayList();
					if(event != null && !"".equals(model[i].getCntrNo())){
						param.put("cntrNo", model[i].getCntrNo());
						velParam.put("cntrNo", model[i].getCntrNo());						
					}else{
						param.put("cntrNo", "");
						velParam.put("cntrNo", "");
					}
					
					if(event != null && !"".equals(model[i].getWblDt())){
						param.put("wblDt", model[i].getWblDt());
						velParam.put("wblDt", model[i].getWblDt());						
					}else{
						param.put("wblDt", "");
						velParam.put("wblDt", "");
					}
					
					if(event != null && !"".equals(model[i].getInvBilAmt())){
						param.put("invBilAmt", model[i].getInvBilAmt());
						velParam.put("invBilAmt", model[i].getInvBilAmt());						
					}else{
						param.put("invBilAmt", "");
						velParam.put("invBilAmt", "");
					}

					param.put("railRoadCode", event.getRailRoadCode());
					velParam.put("railRoadCode", event.getRailRoadCode());
					
					param.put("currency", event.getCurrency());
					velParam.put("currency", event.getCurrency());
					
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOVerifyInvoiceFileImportVndrSetListRSQL(), param, velParam);
					
					returnList.add(dbRowset);
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return returnList;
		}
		
		/**
		 * Invoice File Verify List<br>
		 * 
		 * @param event
		 * @return
		 * @throws DAOException
		 */
		public ArrayList verifyInvoiceFileImportSoIFList(EsdTrs0923Event event) throws DAOException {
			// PDTO(Data Transfer Object including Parameters)
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();

			ArrayList returnList = null;
			
			try{
				for(int i = 0; i < model.length; i++){
					if(returnList == null) returnList = new ArrayList();
					if(event != null && !"".equals(model[i].getCntrNo())){
						param.put("cntrNo", model[i].getCntrNo());
						velParam.put("cntrNo", model[i].getCntrNo());						
					}else{
						param.put("cntrNo", "");
						velParam.put("cntrNo", "");
					}
					
					if(event != null && !"".equals(model[i].getWblDt())){
						param.put("wblDt", model[i].getWblDt());
						velParam.put("wblDt", model[i].getWblDt());						
					}else{
						param.put("wblDt", "");
						velParam.put("wblDt", "");
					}
					
					if(event != null && !"".equals(model[i].getInvBilAmt())){
						param.put("invBilAmt", model[i].getInvBilAmt());
						velParam.put("invBilAmt", model[i].getInvBilAmt());						
					}else{
						param.put("invBilAmt", "");
						velParam.put("invBilAmt", "");
					}

					param.put("railRoadCode", event.getRailRoadCode());
					velParam.put("railRoadCode", event.getRailRoadCode());
					
					param.put("currency", event.getCurrency());
					velParam.put("currency", event.getCurrency());
					
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailInvoiceauditDBDAOVerifyInvoiceFileImportSoIFListRSQL(), param, velParam);

					returnList.add(dbRowset);
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return returnList;
		}
}