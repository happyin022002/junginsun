/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DropOffInquiry.java
*@FileTitle : Drop Off Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-11-04 Jeong-Min Park
* 1.0 최초 생성
*  
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.validation.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.hanjin.apps.alps.ees.dod.dodcommon.validation.vo.DodValidationINVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * DropOffInquiryDBDAO <br>
 * 
 * @author Jeong-Min Park
 * @see EventSupport
 * @since J2EE 1.4
 */
public class DodValidationDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 7296549438223955377L;

	/**
	 * Office Code 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws DAOException
	 */
	public int checkOfficeCode(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckOfficeCodeRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CUST_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws DaoException
	 */
	public int checkCustomer(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckCustomerRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws DAOException
	 */
	public int checkBkgNo(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckBkgNoRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CNTR_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws DAOException
	 */
	public int checkCntrNo(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckCntrNoRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * RFA_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws DAOException
	 */
	public int checkRfaNo(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckRfaNoRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SC_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws DAOException
	 */
	public int checkScNo(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckScNoRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * TP/SZ 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws DAOException
	 */
	public int checkTpSz(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckTpSzCdRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * LOC_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws DAOException
	 */
	public int checkLocCd(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckLocCdRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * YD_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws DAOException
	 */
	public int checkYdCd(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckYdCdRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * RCC, ECC, SCC등 지역 코드 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws DAOException
	 */
	public int checkAreaCd(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckAreaCdRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * CNT_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws DAOException
	 */
	public int checkCntCd(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckCntCdRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Login한 사용자의 AR Invoice Issue화면 접근권한 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkIssueUser(DodValidationINVO dodValidationINVO) throws DAOException{
		DBRowSet dbRowset = null;
		int count = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dodValidationINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodValidationDBDAOcheckIssueUserRSQL(), param, velParam);
			
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			
			return count;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
