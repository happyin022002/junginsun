/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PoolChassisDBDAO.java
*@FileTitle : Pool Chassis reposition cost 처리
*Open Issues :
*Change history :
*@LastModifyDate : 2008-12-04
*@LastModifier : ah young Han
*@LastVersion : 1.0
* 2008-12-04 ah young Han
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0040Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.basic.PoolChassisBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.event.EsdTrs0041Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.vo.SearchInvoicePoolChassisVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspPoolChssInvVO;

/**
 * ENIS-PoolChassis에 대한 DB 처리를 담당<br>
 * - ENIS-PoolChassis Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author ah young Han
 * @see PoolChassisBCImpl 참조
 * @since J2EE 1.4
 */
public class PoolChassisDBDAO extends DBDAOSupport {

		
	
	 /**
	  * 샤시 Pool을 조회한다.  <br>
	  * @param sortKey 
	  * @return
	  * @throws DAOException
	  */
	 public DBRowSet getPoolList() throws DAOException {
//			Collection poolList = new ArrayList();
			DBRowSet dbRowSet = null;
			
			try {
				dbRowSet = new SQLExecuter("DEFAULT").executeQuery(new PoolChassisDBDAOGetPoolListRSQL(), null, null);
				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ee) {
				log.error(ee.getMessage(), ee);
				throw new DAOException(ee.getMessage());
			} 
			return dbRowSet;
			
		}

		    
	 /**
	  * 샤시 Pool 코드에 대한 Pool Name을 가져온다. <p>
	  * @param sortKey 
	  * @return
	  * @throws DAOException
	  */
	public String getPoolName(String code) throws DAOException {
		DBRowSet dRs = null;	
		Map<String, Object> param = new HashMap<String, Object>();
		String chss_pool_nm = null;
		try {
			param.put("chss_pool_cd", code);
			dRs = new SQLExecuter("DEFAULT").executeQuery(new PoolChassisDBDAOGetPoolNameRSQL(), param,param);
			if(dRs.next()){
				chss_pool_nm = dRs.getString("CHSS_POOL_NM");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return chss_pool_nm;
	 }	    
	 

	
	/**
	 * Payment VNDR Info을 가져온다.<br>
	 * @param event 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet getPaymentSPList(EsdTrs0041Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoicePoolChassisVO sipc = event.getSearchInvoicePoolChassisVo();
		
		try {
			param.put("chss_pool_cd", sipc.getHiddenChssPoolCd());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new PoolChassisDBDAOGetPaymentSPListRSQL(), param,param);
			

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
		
	}
	

	/**
	 * Invoice No에 대한 중복 체크를 한다.<br>
	 * 
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet dupChkPoolChassisInvoiceNo(EsdTrs0041Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoicePoolChassisVO sipc = event.getSearchInvoicePoolChassisVo();
		
		try {
			param.put("inv_no", sipc.getInvNo());
			param.put("paymt_sp_cd", sipc.getPaymtSpCd());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new PoolChassisDBDAODupChkPoolChassisInvoiceNoRSQL(), param,param);
			

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
	}
	
	/**
	 * Inovice Pool chassis 의 Invoice Work  정보르 조회한다.<br>
	 * 
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchInvociePoolChassisHead(EsdTrs0041Event event) throws DAOException {
		
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoicePoolChassisVO sipc = event.getSearchInvoicePoolChassisVo();
		
		try {
			param.put("inv_no", sipc.getInvNo());
			param.put("paymt_sp_cd", sipc.getPaymtSpCd());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new PoolChassisDBDAOSearchInvociePoolChassisHeadRSQL(), param,param);
						
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
		
		
	}
	/**
	 * Inovice Pool chassis 리스트를 조회한다.<br>
	 * 
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchInvoicePoolChassisList(EsdTrs0041Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoicePoolChassisVO sipc = event.getSearchInvoicePoolChassisVo();
		
		try {
			param.put("inv_no", sipc.getInvNo());
			param.put("paymt_sp_cd", sipc.getPaymtSpCd());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new PoolChassisDBDAOSearchInvoicePoolChassisListRSQL(), param,param);
			

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;

	}
	/**
	 * INvoice Pool Chassis의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void insertInvoicePoolChassis(EsdTrs0041Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Collection<TrsTrspPoolChssInvVO> insModels =new ArrayList<TrsTrspPoolChssInvVO>();
		TrsTrspPoolChssInvVO[] trsTrspPoolChssInvVOs = event.getTrsTrspPoolChssInvVOs();
		SearchInvoicePoolChassisVO searchInvoicePoolChassisVo = event.getSearchInvoicePoolChassisVo();
				
		try {

			if("true".equals(searchInvoicePoolChassisVo.getInsflag())){
				Map<String, String> param_Vo = searchInvoicePoolChassisVo.getColumnValues();
				param.putAll(param_Vo);
				
				new SQLExecuter("DEFAULT").executeUpdate(new PoolChassisDBDAOInsertInvoicePoolChassisCSQL(), param,param);			
				
			}			
			
			int[] insCnt = null;
			
			for(int i=0;i<trsTrspPoolChssInvVOs.length;i++){

				if (trsTrspPoolChssInvVOs[i].getIbflag().equals("I")) {
					insModels.add(trsTrspPoolChssInvVOs[i]);
				}
			}
			Map<String,Object> param_wrk = new HashMap<String,Object>();
			if(insModels.size()>0){					
				param_wrk.put("inv_no", searchInvoicePoolChassisVo.getInvNo());
				param_wrk.put("paymt_sp_cd", searchInvoicePoolChassisVo.getPaymtSpCd());
				param_wrk.put("usr_id", searchInvoicePoolChassisVo.getUsrId());
				param_wrk.put("ofc_cd", searchInvoicePoolChassisVo.getOfcCd());
				param_wrk.put("inv_curr_cd", searchInvoicePoolChassisVo.getInvCurrCd());
				param_wrk.put("pool_chss_cost_yrmon", searchInvoicePoolChassisVo.getPoolChssCostYrmon());
				param_wrk.put("chss_pool_cd", searchInvoicePoolChassisVo.getChssPoolCd());
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new PoolChassisDBDAOInsertInvoicePoolChassisChssCSQL(), insModels, param_wrk, param_wrk);
				
			}
			
			if(insCnt != null){
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
						
					}
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		
	}

	
	
	/**
	 * Invoice Pool Chassis 의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @see EsdTrs0040Event
	 * @throws DAOException
	 */
	public void updateInvoicePoolChassis(EsdTrs0041Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Collection<TrsTrspPoolChssInvVO> insModels =new ArrayList<TrsTrspPoolChssInvVO>();
		Collection<TrsTrspPoolChssInvVO> updModels =new ArrayList<TrsTrspPoolChssInvVO>();
		TrsTrspPoolChssInvVO[] trsTrspPoolChssInvVOs = event.getTrsTrspPoolChssInvVOs();
		SearchInvoicePoolChassisVO searchInvoicePoolChassisVo = event.getSearchInvoicePoolChassisVo();
				
		try {
			
			Map<String, String> param_Vo = searchInvoicePoolChassisVo.getColumnValues();
			param.putAll(param_Vo);
			
			new SQLExecuter("DEFAULT").executeUpdate(new PoolChassisDBDAOUpdateInvoicePoolChassisUSQL(), param,param);			
						

			int[] insCnt = null;
			for(int i=0;i<trsTrspPoolChssInvVOs.length;i++){
				if (trsTrspPoolChssInvVOs[i].getIbflag().equals("I")) {
					insModels.add(trsTrspPoolChssInvVOs[i]);
				}
				if (trsTrspPoolChssInvVOs[i].getIbflag().equals("U")) {
					updModels.add(trsTrspPoolChssInvVOs[i]);
				}
			}
			
			Map<String,Object> param_wrk = new HashMap<String,Object>();
			if(insModels.size()>0){					
				param_wrk.put("inv_no", searchInvoicePoolChassisVo.getInvNo());
				param_wrk.put("paymt_sp_cd", searchInvoicePoolChassisVo.getPaymtSpCd());
				param_wrk.put("usr_id", searchInvoicePoolChassisVo.getUsrId());
				param_wrk.put("ofc_cd", searchInvoicePoolChassisVo.getOfcCd());
				param_wrk.put("inv_curr_cd", searchInvoicePoolChassisVo.getInvCurrCd());
				param_wrk.put("pool_chss_cost_yrmon", searchInvoicePoolChassisVo.getPoolChssCostYrmon());
				param_wrk.put("chss_pool_cd", searchInvoicePoolChassisVo.getChssPoolCd());
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new PoolChassisDBDAOInsertInvoicePoolChassisChssCSQL(), insModels, param_wrk, param_wrk);
				
			}

			if(insCnt != null){
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
						
					}
				}
			}

			int[] updCnt = null;
			Map<String,Object> param_upd = new HashMap<String,Object>();
			if(updModels.size()>0){					
				param_upd.put("inv_no", searchInvoicePoolChassisVo.getInvNo());
				param_upd.put("paymt_sp_cd", searchInvoicePoolChassisVo.getPaymtSpCd());
				param_upd.put("usr_id", searchInvoicePoolChassisVo.getUsrId());
				param_upd.put("ofc_cd", searchInvoicePoolChassisVo.getOfcCd());
				
				updCnt = new SQLExecuter("DEFAULT").executeBatch(new PoolChassisDBDAOUpdateInvoicePoolChassisChssUSQL(), updModels, param_upd, param_upd);
				
			}
			
			if(updCnt != null){
				for(int i=0;i<updCnt.length;i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No"+ i + " SQL");
						
					}
				}
			}
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		
	}
	

	/**
	 * Pool 샤시 Invoice 정보를 Confirm상태로 추가 저장한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void confirmInsertInvoicePoolChassis(EsdTrs0041Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Collection<TrsTrspPoolChssInvVO> insModels =new ArrayList<TrsTrspPoolChssInvVO>();
		TrsTrspPoolChssInvVO[] trsTrspPoolChssInvVOs = event.getTrsTrspPoolChssInvVOs();
		SearchInvoicePoolChassisVO searchInvoicePoolChassisVo = event.getSearchInvoicePoolChassisVo();
				
		try {

			if("true".equals(searchInvoicePoolChassisVo.getInsflag())){
				Map<String, String> param_Vo = searchInvoicePoolChassisVo.getColumnValues();
				param.putAll(param_Vo);
				
				new SQLExecuter("DEFAULT").executeUpdate(new PoolChassisDBDAOConfirmInsertInvoicePoolChassisCSQL(), param,param);			
				
			}			
			
			int[] insCnt = null;
			
			for(int i=0;i<trsTrspPoolChssInvVOs.length;i++){

				if (trsTrspPoolChssInvVOs[i].getIbflag().equals("I")) {
					insModels.add(trsTrspPoolChssInvVOs[i]);
				}
			}
			Map<String,Object> param_wrk = new HashMap<String,Object>();
			if(insModels.size()>0){					
				param_wrk.put("inv_no", searchInvoicePoolChassisVo.getInvNo());
				param_wrk.put("paymt_sp_cd", searchInvoicePoolChassisVo.getPaymtSpCd());
				param_wrk.put("usr_id", searchInvoicePoolChassisVo.getUsrId());
				param_wrk.put("ofc_cd", searchInvoicePoolChassisVo.getOfcCd());
				param_wrk.put("inv_curr_cd", searchInvoicePoolChassisVo.getInvCurrCd());
				param_wrk.put("pool_chss_cost_yrmon", searchInvoicePoolChassisVo.getPoolChssCostYrmon());
				param_wrk.put("chss_pool_cd", searchInvoicePoolChassisVo.getChssPoolCd());
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new PoolChassisDBDAOInsertInvoicePoolChassisChssCSQL(), insModels, param_wrk, param_wrk);
				
			}
			
			if(insCnt != null){
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
						
					}
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		
	}

	/**
	 * Pool 샤시 Invoice 정보를 Confirm상태로 저장한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void confirmUpdateInvoicePoolChassis(EsdTrs0041Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Collection<TrsTrspPoolChssInvVO> insModels =new ArrayList<TrsTrspPoolChssInvVO>();
		Collection<TrsTrspPoolChssInvVO> updModels =new ArrayList<TrsTrspPoolChssInvVO>();
		TrsTrspPoolChssInvVO[] trsTrspPoolChssInvVOs = event.getTrsTrspPoolChssInvVOs();
		SearchInvoicePoolChassisVO searchInvoicePoolChassisVo = event.getSearchInvoicePoolChassisVo();
				
		try {

			Map<String, String> param_Vo = searchInvoicePoolChassisVo.getColumnValues();
			param.putAll(param_Vo);

			new SQLExecuter("DEFAULT").executeUpdate(new PoolChassisDBDAOConfirmUpdateInvoicePoolChassisUSQL(), param,param);			
						

			int[] insCnt = null;
			for(int i=0;i<trsTrspPoolChssInvVOs.length;i++){
				if (trsTrspPoolChssInvVOs[i].getIbflag().equals("I")) {
					insModels.add(trsTrspPoolChssInvVOs[i]);
				}
				if (trsTrspPoolChssInvVOs[i].getIbflag().equals("U")) {
					updModels.add(trsTrspPoolChssInvVOs[i]);
				}
			}
			
			Map<String,Object> param_wrk = new HashMap<String,Object>();
			if(insModels.size()>0){					
				param_wrk.put("inv_no", searchInvoicePoolChassisVo.getInvNo());
				param_wrk.put("paymt_sp_cd", searchInvoicePoolChassisVo.getPaymtSpCd());
				param_wrk.put("usr_id", searchInvoicePoolChassisVo.getUsrId());
				param_wrk.put("ofc_cd", searchInvoicePoolChassisVo.getOfcCd());
				param_wrk.put("inv_curr_cd", searchInvoicePoolChassisVo.getInvCurrCd());
				param_wrk.put("pool_chss_cost_yrmon", searchInvoicePoolChassisVo.getPoolChssCostYrmon());
				param_wrk.put("chss_pool_cd", searchInvoicePoolChassisVo.getChssPoolCd());
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new PoolChassisDBDAOInsertInvoicePoolChassisChssCSQL(), insModels, param_wrk, param_wrk);
				
			}

			
			if(insCnt != null){
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
						
					}
				}
			}
			
			int[] updCnt = null;
			Map<String,Object> param_upd = new HashMap<String,Object>();
			if(updModels.size()>0){					
				param_upd.put("inv_no", searchInvoicePoolChassisVo.getInvNo());
				param_upd.put("paymt_sp_cd", searchInvoicePoolChassisVo.getPaymtSpCd());
				param_upd.put("usr_id", searchInvoicePoolChassisVo.getUsrId());
				param_upd.put("ofc_cd", searchInvoicePoolChassisVo.getOfcCd());
				
				updCnt = new SQLExecuter("DEFAULT").executeBatch(new PoolChassisDBDAOUpdateInvoicePoolChassisChssUSQL(), updModels, param_upd, param_upd);
				
			}

			
			if(updCnt != null){
				for(int i=0;i<updCnt.length;i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No"+ i + " SQL");
						
					}
				}
			}
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		
	}


	/**
	 * Pool 샤시 Invoice에 대해 confirm된 것을 취소한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void confirmCancelInvoicePoolChassis(EsdTrs0041Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		SearchInvoicePoolChassisVO searchInvoicePoolChassisVo = event.getSearchInvoicePoolChassisVo();
		
		try {
			
			Map<String, String> param_Vo = searchInvoicePoolChassisVo.getColumnValues();
			param.putAll(param_Vo);

			new SQLExecuter("DEFAULT").executeUpdate(new PoolChassisDBDAOConfirmCancelInvoicePoolChassisUSQL(), param,param);			
						
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}
	
	/**
	 * invoice 를 Confirm상태로 저장한다<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void confirmInvoicePoolChassis(EsdTrs0041Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		SearchInvoicePoolChassisVO searchInvoicePoolChassisVo = event.getSearchInvoicePoolChassisVo();
		
		try {
			
			Map<String, String> param_Vo = searchInvoicePoolChassisVo.getColumnValues();
			param.putAll(param_Vo);

			new SQLExecuter("DEFAULT").executeUpdate(new PoolChassisDBDAOConfirmInvoicePoolChassisUSQL(), param,param);			
									
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}

	
	/**
	 * Invoice Pool Chassis의 데이타 모델을 DB에서 삭제한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void deleteInvoicePoolChassis(EsdTrs0041Event event) throws DAOException {
		Map<String, Object> param_wrk = new HashMap<String, Object>();
		Map<String, Object> param_chss = new HashMap<String, Object>();

		SearchInvoicePoolChassisVO searchInvoicePoolChassisVo = event.getSearchInvoicePoolChassisVo();
		
		try {
			
			Map<String, String> paramWrk_Vo = searchInvoicePoolChassisVo.getColumnValues();
			param_wrk.putAll(paramWrk_Vo);

			new SQLExecuter("DEFAULT").executeUpdate(new PoolChassisDBDAODeleteInvoicePoolChassisDSQL(), param_wrk,param_wrk);			
						
			Map<String, String> paramChss_Vo = searchInvoicePoolChassisVo.getColumnValues();
			param_chss.putAll(paramChss_Vo);

			new SQLExecuter("DEFAULT").executeUpdate(new PoolChassisDBDAODeleteInvoicePoolChassisChssDSQL(), param_chss,param_chss);			
			
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}
		

	
}