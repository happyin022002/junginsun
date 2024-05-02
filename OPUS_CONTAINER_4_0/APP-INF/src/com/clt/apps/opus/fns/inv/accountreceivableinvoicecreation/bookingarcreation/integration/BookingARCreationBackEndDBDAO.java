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
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ARInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEDIHdrVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgInvTaxIfVO;


/**
 * BookingARCreationDBDAO <br>
 * - AccountReceivableInvoiceCreation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * 환율등록,수정시  INV_AR_CHG에서  USD 환율이 반영되어야 할 대상중  환율이 미등록된 (환율이 null or 0) data를 조회해 온다.<br>
 	 * if no, if ser no, chg sequence<br>
	 * 
	 * @param ExchangeRateVO exRateVo
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchARInvoiceUSDExchangeRateList(ExchangeRateVO exRateVo) throws DAOException {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingARCreationBackEndDBDAOSearchARInvoiceUSDExRateRSQL(), param, velParam);
			
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
	 * 환율등록,수정시 Booking에 Tax Exchange Rate 재계산을 위한 대상 List 검색<br>
 	 * if no, if ser no, chg sequence<br>
	 * 
	 * @param ExchangeRateVO exRateVo
	 * @param String usrId
	 * @return List<BkgInvTaxIfVO> 
	 * @exception DAOException
	 */
	public List<BkgInvTaxIfVO> searchARInvExRtForBkgTaxRt(ExchangeRateVO exRateVo, String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgInvTaxIfVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(exRateVo != null){
				Map<String, String> mapVO = exRateVo.getColumnValues();		
				mapVO.put("usr_id", usrId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingARCreationBackEndDBDAOSearchARInvExRtForBkgTaxRtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgInvTaxIfVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
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
	 *  INV_AR_CHG 테이블에 USD exrate Update<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyARInvoiceUSDExRate(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyARInvoiceUSDExRateUSQL(), param, velParam);
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
	 * SAR_OTS_DTL 테이블에 LOCL_XCH_RT Update (2014.08.12)<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSLocalExrate(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSLocalExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HIS 테이블에 LOCL_XCH_RT Update (2015.02.16)<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHisLocalExrate(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHisLocalExrateUSQL(), param, velParam);
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
	 * SAR_OTS_DTL 테이블에 USD_XCH_RT Update (2014.08.12)<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSUSDExrate(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSUSDExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HIS 테이블에 USD_XCH_RT Update (2015.03.12)<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHisUSDExrate(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHisUSDExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HDR 테이블에 RT_FLG Update (2014.08.12)<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSRateFlgByIfNo(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSRateFlgByIfNoUSQL(), param, velParam);
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
	 * SAR_OTS_HDR INV exrate Update<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHdrINVExrate(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHdrINVExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HIS INV exrate Update<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHisINVExrate(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHisINVExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HDR 테이블에 RT_FLG Update (2014.08.12)<br>
	 * 
	 * @param ExchangeRateVO exRateVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSRateFlgByExrateType(ExchangeRateVO exRateVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exRateVo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSRateFlgByExrateTypeUSQL(), param, velParam);
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
	 * SAR_OTS_DTL LOCAL EXRATE Update <br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSDetailLoclExrate(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSDetailLoclExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HIS LOCAL EXRATE Update <br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHistoryLoclExrate(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHistoryLoclExrateUSQL(), param, velParam);
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
	 * SAR_OTS_DTL USD EXRATE Update <br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSDetailUSDExrate(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSDetailUSDExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HIS USD EXRATE Update <br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHistoryUSDExrate(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHistoryUSDExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HDR INV EXRATE Update <br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHeaderINVExrate(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHeaderINVExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HIS INV EXRATE Update <br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHistoryINVExrate(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHistoryINVExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HDR RATE FLAG Update<br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHeaderRateFlg(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHeaderRateFlgUSQL(), param, velParam);
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
	 *  INV_AR_CHG 테이블에 USD exrate Update<br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyInvoiceUSDExrateChg(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyInvoiceUSDExrateChgUSQL(), param, velParam);
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
	 * Search Max Interface No<br>
	 * 
	 * @param String arIfNo
	 * @param String arOfcCd
	 * @param String blNo
	 * @param String xchRtUsdTpCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxInterfaceNo(String arIfNo, String arOfcCd, String blNo, String xchRtUsdTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String maxIfNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("bl_no", blNo);
			mapVO.put("xch_rt_usd_tp_cd", xchRtUsdTpCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingARCreationBackEndDBDAOSearchMaxInterfaceNoRSQL(), param, velParam);
			while(dbRowset.next()){
				maxIfNo = dbRowset.getString("ar_if_no");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return maxIfNo;
	}
	
	/**
  	* Search USD Exrate<br>
  	* 
	* @param ExchangeRateVO exRateVo
	* @return String
	* @exception DAOException
	*/
	public String searchUSDExchangeRate ( ExchangeRateVO exRateVo )throws DAOException {
		DBRowSet dbRowset = null;
		String usdXchRt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = exRateVo.getColumnValues();
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingARCreationBackEndDBDAOSearchUSDExchangeRateRSQL(), param, velParam);
			if(dbRowset.next()) {						
				usdXchRt = dbRowset.getString("usd_xch_rt");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return usdXchRt;
	}
	
	/**
  	* Search ALTN Currency Code<br>
  	* 
	* @param  String ofcCd
	* @return String
	* @exception DAOException
	*/
	public String searchALTNCurrCd ( String ofcCd )throws DAOException {
		DBRowSet dbRowset = null;
		String altnCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingARCreationBackEndDBDAOSearchALTNCurrCdRSQL(), param, velParam);
			if(dbRowset.next()) {						
				altnCd = dbRowset.getString("altn_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return altnCd;
	}
	
	/**
	 * SAR_OTS_HDR INV USD exrate Update<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHdrINVUSDExrate(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHdrINVUSDExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HIS INV USD exrate Update<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHisINVUSDExrate(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHisINVUSDExrateUSQL(), param, velParam);
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
	 * INV_AR_MN INV USD exrate Update<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyINVUSDExrateMain(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyINVUSDExrateMainUSQL(), param, velParam);
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
	 * INV_AR_MN INV LCL exrate Update<br>
	 * 
	 * @param ARInvoiceVO invoiceVo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyINVLCLExrateMain(ARInvoiceVO invoiceVo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyINVLCLExrateMainUSQL(), param, velParam);
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
	 * SAR_OTS_HDR INV EXRATE Update <br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHeaderINVUSDExrate(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHeaderINVUSDExrateUSQL(), param, velParam);
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
	 * SAR_OTS_HIS INV EXRATE Update <br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOTSHistoryINVUSDExrate(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyOTSHistoryINVUSDExrateUSQL(), param, velParam);
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
	 * INV_AR_MN INV EXRATE Update <br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyINVMainINVLCLExrate(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyINVMainINVLCLExrateUSQL(), param, velParam);
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
	 * INV_AR_MN INV EXRATE Update <br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyINVMainINVUSDExrate(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOModifyINVMainINVUSDExrateUSQL(), param, velParam);
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
}