/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationBackEndDBDAO.java
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.29 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ARInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS BookingARCreationDBDAO <br>
 * - ALPS-AccountReceivableInvoiceCreation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Do Soon
 * @see BookingARCreationBackEndBCImpl 참조
 * @since J2EE 1.6
 */ 
public class BookingARCreationBackEndDBDAO extends DBDAOSupport {	
	
	/**
	 * 환율등록,수정시  INV_AR_CHG에서  해당 환율이 반영되어야 할 대상중  환율이 미등록된 (환율이 null or 0) data를 조회해 온다.<br>
 	 * if no, if ser no, chg sequence<br>
	 * 
	 * @param ExchangeRateVO exRateVo
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchARInvoiceExchangeRateList(ExchangeRateVO exRateVo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(exRateVo != null){
				Map<String, String> mapVO = exRateVo.getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingARCreationBackEndDBDAOARInvoiceExRateRSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return dbRowset;
	}	
	
	/**
	 * 해당 조건에 해당하는  USD_LCL 환율 이  0 인 대상을 INV_AR_MN 에서 select 해옴.<br>
	 * 
	 * @param ExchangeRateVO exRateVo
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchUSDExchangeRateList(ExchangeRateVO exRateVo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(exRateVo != null){
				Map<String, String> mapVO = exRateVo.getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingARCreationBackEndDBDAOSearchUSDExchangeRateListRSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return dbRowset;
	}	
	
	/**
	 *  INV_AR_CHG 테이블에 Update<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyARInvoiceExRate(ARInvoiceVO invoiceVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = invoiceVo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOARInvoiceExRateUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	
	/**
	 * INV_AR_MN 테이블에 Local amount  Update<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyARInvoiceExRateMain(ARInvoiceVO invoiceVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = invoiceVo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOARInvoiceExRateMainUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	
	/**
	 * INV_AR_MN 테이블에 USD_XCH_RT Update<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyUSDExrateMain(ARInvoiceVO invoiceVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = invoiceVo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyUSDExrateMainUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	
	/**
	 * 환율등록,수정시 ACM 의 BKG No 를 조회한다.<br>
	 * 
	 * @param ExchangeRateVO exRateVo
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchACMBkgNo(ExchangeRateVO exRateVo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(exRateVo != null){
				Map<String, String> mapVO = exRateVo.getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingARCreationBackEndDBDAOSearchACMBkgNoRSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return dbRowset;
	}	
}