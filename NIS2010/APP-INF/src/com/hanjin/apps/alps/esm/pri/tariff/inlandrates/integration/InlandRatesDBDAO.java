/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAO.java
*@FileTitle : Inland Rates Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.21 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.basic.InlandRatesBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndHistoryVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndRtVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriTrfInlndProgVO;
import com.hanjin.syscommon.common.table.PriTrfInlndRtVO;
import com.hanjin.syscommon.common.table.PriTrfInlndVO;


/**
 * ALPS InlandRatesDBDAO <br>
 * - ALPS-Tariff system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUNGMIN
 * @see InlandRatesBCImpl 참조
 * @since J2EE 1.6
 */
public class InlandRatesDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * [Inland Rate] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return List<PriTrfInlndVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PriTrfInlndVO> searchInlandRatesName(PriTrfInlndVO priTrfInlndVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriTrfInlndVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndVO != null){
				Map<String, String> mapVO = priTrfInlndVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriTrfInlndVO .class);
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
	 * [Inland Rate] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfInlndVO> searchInlandRates(PriTrfInlndParamVO priTrfInlndParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfInlndVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndParamVO != null){
				Map<String, String> mapVO = priTrfInlndParamVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfInlndVO .class);
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
	 * [Inland Rate] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchInlandRatesMaxSeq(PriTrfInlndVO priTrfInlndVO) throws DAOException {
		DBRowSet dbRowset = null;
		String maxSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndVO != null){
				Map<String, String> mapVO = priTrfInlndVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndMaxSeqRSQL(), param, velParam);

			if (dbRowset.next()) {
				maxSeq = dbRowset.getString(1);
			}			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
	
	/**
	 * [Inland Rate Location의 max seq] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchInlandRatesLocationMaxSeq(PriTrfInlndParamVO priTrfInlndParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		String maxSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndParamVO != null){
				Map<String, String> mapVO = priTrfInlndParamVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndLocMaxSeqRSQL(), param, velParam);

			if (dbRowset.next()) {
				maxSeq = dbRowset.getString(1);
			}			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
		 		
	/**
	 * [Inland Rate] 정보를 [수정] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyInlandRates(PriTrfInlndVO priTrfInlndVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priTrfInlndVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [Inland Rate] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<PriTrfInlndVO> priTrfInlndVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyInlandRatesS(List<PriTrfInlndVO> priTrfInlndVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priTrfInlndVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndVOUSQL(), priTrfInlndVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
			
	/**
	 * [Inland Rate 상태] 정보를 [수정] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyInlandRatesStatus(PriTrfInlndVO priTrfInlndVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priTrfInlndVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndStatusUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [Inland Rate] 정보를 [추가] 합니다.<br>
	 * 
	 * @param List<PriTrfInlndVO> priTrfInlndVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addInlandRatesS(List<PriTrfInlndVO> priTrfInlndVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priTrfInlndVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndVOCSQL(), priTrfInlndVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
		
	/**
	 * [Inland Rate] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removeInlandRates(PriTrfInlndVO priTrfInlndVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priTrfInlndVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * [Inland Rate 상태진행] 정보를 [추가] 합니다.<br>
	 * 
	 * @param PriTrfInlndProgVO priTrfInlndProgVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addInlandRatesProgress(PriTrfInlndProgVO priTrfInlndProgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfInlndProgVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndProgVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [Inland Rate 상태진행] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param PriTrfInlndProgVO priTrfInlndProgVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeInlandRatesProgress(PriTrfInlndProgVO priTrfInlndProgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfInlndProgVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndProgVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * [Inland Rate] 정보를 [수정] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyInlandRatesPublish(PriTrfInlndVO priTrfInlndVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfInlndVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndPublishUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [Inland Rate Location Excel] 정보를 [추가] 합니다.<br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addInlandRatesExcel(PriTrfInlndRtVO priTrfInlndRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfInlndRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtExcelVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [Inland Rate Location Excel] 정보를 [수정] 합니다.<br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyInlandRatesExcel1(PriTrfInlndRtVO priTrfInlndRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfInlndRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtExcel1VOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [Inland Rate Location Excel] 정보를 [수정] 합니다.<br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyInlandRatesExcel2(PriTrfInlndRtVO priTrfInlndRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfInlndRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtExcel2VOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * [Inland Rate Location Excel] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeInlandRatesExcel(PriTrfInlndRtVO priTrfInlndRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfInlndRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtExcelVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * [Inland Rate] 정보를 [추가] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addInlandRatesAmend(PriTrfInlndVO priTrfInlndVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfInlndVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndAmendVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * [Inland Rate Location] 정보를 [추가] 합니다.<br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addInlandRatesLocationAmend(PriTrfInlndRtVO priTrfInlndRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfInlndRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtAmendVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * [Inland Rate Attach] 정보를 [수정] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyInlandRatesAttach(PriTrfInlndVO priTrfInlndVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfInlndVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndAttachUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [Inland Rate Location] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfInlndRtVO> searchInlandRatesLocation(PriTrfInlndParamVO priTrfInlndParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfInlndRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndParamVO != null){
				Map<String, String> mapVO = priTrfInlndParamVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfInlndRtVO .class);
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
	 * [Inland Rate Location] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfInlndRtVO> searchInlandRatesExcel(PriTrfInlndRtVO priTrfInlndRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfInlndRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndRtVO != null){
				Map<String, String> mapVO = priTrfInlndRtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtDownVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfInlndRtVO .class);
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
	 * [Inland Rate Location] 정보를 [추가] 합니다.<br>
	 * 
	 * @param List<PriTrfInlndRtVO> priTrfInlndRtVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addInlandRatesLocationS(List<PriTrfInlndRtVO> priTrfInlndRtVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priTrfInlndRtVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtVOCSQL(), priTrfInlndRtVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	
	/**
	 * [Inland Rate Location] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<PriTrfInlndRtVO> priTrfInlndRtVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyInlandRatesLocationS(List<PriTrfInlndRtVO> priTrfInlndRtVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priTrfInlndRtVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtVOUSQL(), priTrfInlndRtVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	
	/**
	 * [Inland Rate Location] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<PriTrfInlndRtVO> priTrfInlndRtVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeInlandRatesLocationS(List<PriTrfInlndRtVO> priTrfInlndRtVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priTrfInlndRtVO .size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("main_del_yn", "N"); // 메인에서 삭제할경우 에는 'Y'
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtVODSQL(), priTrfInlndRtVO, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * [Inland Rate Location] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removeInlandRatesLocation(PriTrfInlndRtVO priTrfInlndRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priTrfInlndRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.put("main_del_yn", "Y"); // 메인에서 삭제할경우 에는 'Y'
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [Inland Rate] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfInlndVO> searchInlandRatesInquiryList(PriTrfInlndVO priTrfInlndVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfInlndVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndVO != null){
				Map<String, String> mapVO = priTrfInlndVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndInquiryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfInlndVO .class);
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
	 * [Inland Rate Location] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfInlndRtVO> searchInlandRatesInquiry(PriTrfInlndRtVO priTrfInlndRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfInlndRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndRtVO != null){
				Map<String, String> mapVO = priTrfInlndRtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndInquiryRtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfInlndRtVO .class);
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
	 * [Inland Rates Name] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfInlndVO> searchInlandRatesHistoryList(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfInlndVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndHistoryVO != null){
				Map<String, String> mapVO = priTrfInlndHistoryVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndHistoryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfInlndVO .class);
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
	 * [Inland Rates Name] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfInlndVO> searchInlandRatesAmendHistoryList(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfInlndVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndHistoryVO != null){
				Map<String, String> mapVO = priTrfInlndHistoryVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndHistoryAmendVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfInlndVO .class);
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
	 * [Inland Rates Location 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfInlndRtVO> searchInlandRatesHistory(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfInlndRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndHistoryVO != null){
				Map<String, String> mapVO = priTrfInlndHistoryVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndHistoryRtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfInlndRtVO .class);
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
	 * [Tariff Code List] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOTariffCdListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * [Location] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public RsltCdListVO searchLocationCodeExist(RsltCdListVO rsltCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOMdmLocationVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	 
	 
	/**
	 * [Currency] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public RsltCdListVO searchCurrencyCodeExist(RsltCdListVO rsltCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOMdmCurrencyVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	 
	 
	/**
	 * [공통코드] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public RsltCdListVO searchComCodeExist(RsltCdListVO rsltCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOComCodeDescVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}	
	
	/**
	 * [Inland Rate Location 의 최근 업데이트 날짜] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchInlandRatesMaxUpdate(PriTrfInlndParamVO priTrfInlndParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		String maxSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndParamVO != null){
				Map<String, String> mapVO = priTrfInlndParamVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndRtMaxUpdateRSQL(), param, velParam);

			if (dbRowset.next()) {
				maxSeq = dbRowset.getString(1);
			}			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
	
	
	/**
	 * [Inland Rate] 존재유무를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchInlandRatesExistCheck(PriTrfInlndVO priTrfInlndVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfInlndVO != null){
				Map<String, String> mapVO = priTrfInlndVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandRatesDBDAOPriTrfInlndExistCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				sValue = dbRowset.getString(1);
			}			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sValue;
	}
}