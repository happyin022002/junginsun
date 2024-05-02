/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffCodeDBDAO.java
*@FileTitle : Tariff Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.14
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.14 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffcode.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.InPriTariffVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.RsltSvcScpCdVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffCodeALLVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffCodeUsedVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffScopeDupVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.basic.TariffRuleBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriTariffVO;


/**
 * TariffRuleDBDAO <br>
 * - Tariff system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO MIJIN
 * @see TariffRuleBCImpl 참조
 * @since J2EE 1.6
 */
public class TariffCodeDBDAO extends DBDAOSupport {

	/**
	 * ESM_PRI_3502 : Retrieve <br>
	 * 입력한 Tariff Code에 해당하는 Tariff Scope 조회
	 * @param RsltSvcScpCdVO rsltSvcScpCdVO
	 * @return List<RsltSvcScpCdVO>
	 * @exception DAOException
	 */
	public List<RsltSvcScpCdVO> searchTariffCode(RsltSvcScpCdVO rsltSvcScpCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSvcScpCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(rsltSvcScpCdVO != null){
				Map<String, String> mapVO = rsltSvcScpCdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffCodeDBDAOSearchTariffCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSvcScpCdVO.class);
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
	 * ESM_PRI_3502 : SAVE <br>
	 * Tariff Name 변경, Tariff Scope 추가 및 삭제
	 * 
	 * @param InPriTariffVO inPriTariffVO
	 * @exception DAOException
	 */
	public void modifyTariffCode(InPriTariffVO inPriTariffVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(inPriTariffVO != null){
				Map<String, String> mapVO = inPriTariffVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TariffCodeDBDAOModifyTariffCodeNameUSQL(), param, velParam);			
			if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");		
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * ESM_PRI_3502 : DELETE <br>
	 * (ONLY) Tariff 삭제
	 * 
	 * @param PriTariffVO priTariffVO
	 * @exception DAOException
	 */
	public void removeTariffCode(PriTariffVO priTariffVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(priTariffVO != null){
				Map<String, String> mapVO = priTariffVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			SQLExecuter sqlExe = new SQLExecuter("");			
			result = sqlExe.executeUpdate((ISQLTemplate)new TariffCodeDBDAORemoveTariffCodeDSQL(), param, velParam);	
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to delete SQL");		
			}							
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_3502 : DELETE <br>
	 * Tariff Scope Delete
	 * 
	 * @param PriTariffVO priTariffVO
	 * @exception DAOException
	 */
	public void removeTariffScope(PriTariffVO priTariffVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(priTariffVO != null){
				Map<String, String> mapVO = priTariffVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			SQLExecuter sqlExe = new SQLExecuter("");			
			result = sqlExe.executeUpdate((ISQLTemplate)new TariffCodeDBDAORemoveTariffScopeDSQL(), param, velParam);			
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to delete SQL");		
			}				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_3502 : SAVE <br>
	 * Tariff 생성
	 * 
	 * @param InPriTariffVO inPriTariffVO
	 * @exception DAOException
	 */
	public void addTariffCode(InPriTariffVO inPriTariffVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(inPriTariffVO != null){
				Map<String, String> mapVO = inPriTariffVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TariffCodeDBDAOAddTariffCodeCSQL(), param, velParam);			
			if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");		
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_3502 <br>
	 * Tariff에 TariffScope Code를 추가
	 * 
	 * @param List<RsltSvcScpCdVO> insertSheetVoList 
	 * @exception DAOException
	 */
	public void addTariffScope(List<RsltSvcScpCdVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insertSheetVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TariffCodeDBDAOAddTariffScopeCSQL(), insertSheetVoList,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	} 
	
	/**
	 * ESM_PRI_3502 : SAVE <br>
	 * Tariff Scope 삭제
	 * 
	 * @param List<RsltSvcScpCdVO> deleteSheetVoList 
	 * @exception DAOException
	 */
	public void removeSelTariffScope(List<RsltSvcScpCdVO> deleteSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(deleteSheetVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TariffCodeDBDAORemoveSelTariffScopeDSQL(), deleteSheetVoList,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_3502 : SAVE <br>
	 * Tariff Scope duplicate check
	 * 
	 * @param RsltSvcScpCdVO rsltSvcScpCdVO
	 * @param List<String> checkVoList
	 * @return List<SearchTariffScopeDupVO>
	 * @exception DAOException
	 */
	public List<SearchTariffScopeDupVO> searchTariffScopeDuplicate(RsltSvcScpCdVO rsltSvcScpCdVO,List<String> checkVoList) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<SearchTariffScopeDupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(rsltSvcScpCdVO != null){
				Map<String, String> mapVO = rsltSvcScpCdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("svc_scp_list", checkVoList);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffCodeDBDAOSearchTariffScopeDupRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTariffScopeDupVO.class);
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
	 * ESM_PRI_3502 : DELETE <br>
	 * Tariff General Information 존재 여부 확인
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return SearchTariffCodeUsedVO
	 * @exception DAOException
	 */
	public SearchTariffCodeUsedVO searchTariffCodeUsed(PriTariffVO priTariffVO) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<SearchTariffCodeUsedVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(priTariffVO != null){
				Map<String, String> mapVO = priTariffVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffCodeDBDAOSearchTariffCodeUsedRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTariffCodeUsedVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list.get(0);
	}
	
	/**
	 * ESM_PRI_3503 : Retrieve <br>
	 * Tariff Code Inquiry
	 * 
	 * @param SearchTariffCodeALLVO searchTariffCodeALLVO
	 * @return List<SearchTariffCodeALLVO>
	 * @exception DAOException
	 */
	public List<SearchTariffCodeALLVO> searchTariffCodeALL(SearchTariffCodeALLVO searchTariffCodeALLVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTariffCodeALLVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchTariffCodeALLVO != null){
				Map<String, String> mapVO = searchTariffCodeALLVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffCodeDBDAOSearchTariffCodeALLRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTariffCodeALLVO.class);
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
	 * ESM_PRI_3502 : Tariff Code Focus out <br>
	 * 입력한 Tariff Code에 해당하는 Inland Rates 조회
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return List<PriTariffVO>
	 * @exception EventException
	 */
	public List<PriTariffVO> searchInlandRates(PriTariffVO priTariffVO) throws DAOException {
		DBRowSet dbRowset = null;		
		List<PriTariffVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (priTariffVO != null) {
				Map<String, String> mapVO = priTariffVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TariffCodeDBDAOSearchInlandRatesRSQL(),param, velParam); 
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriTariffVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		
}