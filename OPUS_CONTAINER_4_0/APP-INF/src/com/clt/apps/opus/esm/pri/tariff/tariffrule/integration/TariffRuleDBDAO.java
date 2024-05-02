/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffRuleDBDAO.java
*@FileTitle : Tariff Rule Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.06 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffrule.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.basic.TariffRuleBCImpl;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.InPriTrfRuleDiffVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.PriTrfRuleDiffInquiryVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.PriTrfRuleHistoryVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.RsltPriTrfRuleVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriTrfRuleProgVO;
import com.clt.syscommon.common.table.PriTrfRuleVO;

/**
 * TariffRuleDBDAO <br>
 * - Tariff system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUNGMIN
 * @see TariffRuleBCImpl 참조
 * @since J2EE 1.6
 */
public class TariffRuleDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * [Tariff Rule] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfRuleVO> searchTariffRuleList(PriTrfRuleVO priTrfRuleVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfRuleVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfRuleVO != null){
				Map<String, String> mapVO = priTrfRuleVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfRuleVO .class);
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
	 * [Tariff Rule] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchTariffRuleDuplicate(PriTrfRuleVO priTrfRuleVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dupLen = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfRuleVO != null){
				Map<String, String> mapVO = priTrfRuleVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleDuplicateVORSQL(), param, velParam);
			
			if (dbRowset.next()) {
				dupLen = dbRowset.getString(1);
			}
	            
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dupLen;
	}
	 

	/**
	 * [Tariff Rule] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfRuleVO> searchTariffRuleInquiryList(PriTrfRuleVO priTrfRuleVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfRuleVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfRuleVO != null){
				Map<String, String> mapVO = priTrfRuleVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleInquiryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfRuleVO .class);
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
	 * [Tariff Rule] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleHistoryVO priTrfRuleHistoryVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfRuleVO> searchTariffRuleHistoryList(PriTrfRuleHistoryVO priTrfRuleHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfRuleVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfRuleHistoryVO != null){
				Map<String, String> mapVO = priTrfRuleHistoryVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleHistoryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfRuleVO .class);
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
	 * [Tariff Rule] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleHistoryVO priTrfRuleHistoryVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriTrfRuleVO> searchTariffRuleAmendHistoryList(PriTrfRuleHistoryVO priTrfRuleHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfRuleVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfRuleHistoryVO != null){
				Map<String, String> mapVO = priTrfRuleHistoryVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleAmendHistoryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfRuleVO .class);
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
	 * [Tariff Rule] 정보를 [추가] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addTariffRule(PriTrfRuleVO priTrfRuleVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfRuleVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleVOCSQL(), param, velParam);
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
	 * [Tariff Rule] 정보를 [수정] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyTariffRule(PriTrfRuleVO priTrfRuleVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priTrfRuleVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleVOUSQL(), param, velParam);
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
	 * [Tariff Rule] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removeTariffRule(PriTrfRuleVO priTrfRuleVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priTrfRuleVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleVODSQL(), param, velParam);
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
	 * [Tariff Rule] 정보를 [추가] 합니다.<br>
	 * 
	 * @param List<PriTrfRuleVO> priTrfRuleVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addTariffRuleS(List<PriTrfRuleVO> priTrfRuleVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priTrfRuleVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleVOCSQL(), priTrfRuleVO,null);
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
	 * [Tariff Rule] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<PriTrfRuleVO> priTrfRuleVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyTariffRuleS(List<PriTrfRuleVO> priTrfRuleVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priTrfRuleVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleVOUSQL(), priTrfRuleVO,null);
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
	 * [Tariff Rule] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<PriTrfRuleVO> priTrfRuleVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeTariffRuleS(List<PriTrfRuleVO> priTrfRuleVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priTrfRuleVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleVODSQL(), priTrfRuleVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}
	
	/**
	 * [Tariff Rule 상태진행] 정보를 [추가] 합니다.<br>
	 * 
	 * @param PriTrfRuleProgVO priTrfRuleProgVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addTariffRuleProgress(PriTrfRuleProgVO priTrfRuleProgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfRuleProgVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleProgVOCSQL(), param, velParam);
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
	 * [Tariff Rule 상태진행] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param PriTrfRuleProgVO priTrfRuleProgVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removeTariffRuleProgress(PriTrfRuleProgVO priTrfRuleProgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priTrfRuleProgVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleProgVODSQL(), param, velParam);
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
	 * [Tariff Rule 상태진행] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<PriTrfRuleProgVO> priTrfRuleProgVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeTariffRuleProgressS(List<PriTrfRuleProgVO> priTrfRuleProgVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priTrfRuleProgVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleProgVODSQL(), priTrfRuleProgVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}
		
	/**
	 * [Tariff Rule 상태진행] 정보를 [수정] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyTariffRulesStatus(PriTrfRuleVO priTrfRuleVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priTrfRuleVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleStatusUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
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
	 * [Tariff Rule] Publish된 현재 Exp_dt를 이전 Exp_dt로 수정.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int cancelPublishedTariffRules(PriTrfRuleVO priTrfRuleVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priTrfRuleVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleStatusPublishCancelUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
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
	 * [Tariff Rule] 정보를 [수정] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyTariffRulesPublish(PriTrfRuleVO priTrfRuleVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priTrfRuleVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TariffRuleDBDAOPriTrfRulePublishUSQL(), param, velParam);
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
	 * [Tariff Rule] 정보를 [추가] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addTariffRuleAmend(PriTrfRuleVO priTrfRuleVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfRuleVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleAmendVOCSQL(), param, velParam);
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
	 * [Tariff Rule] 정보를 [조회] 합니다.<br>
	 * 
	 * @param InPriTrfRuleDiffVO inPriTrfRuleDiffVO
	 * @return List<PriTrfRuleDiffInquiryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PriTrfRuleDiffInquiryVO> searchTariffRuleDiff(InPriTrfRuleDiffVO inPriTrfRuleDiffVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriTrfRuleDiffInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inPriTrfRuleDiffVO != null){
				Map<String, String> mapVO = inPriTrfRuleDiffVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffRuleDBDAOPriTrfRuleDiffInquiryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriTrfRuleDiffInquiryVO .class);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffRuleDBDAOTariffCdListVORSQL(), param, velParam);
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
}