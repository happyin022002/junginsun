/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderRelationshipAttractivenessResultDBDAO.java
*@FileTitle : RA Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 권정화
*@LastVersion : 1.0
* 2009.08.03 권정화
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.basic.ServiceProviderRelationshipAttractivenessResultBCImpl;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SearchInputListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SearchServiceProviderRelationshipAttractivenessResultListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SpeRltAtrcRsltAddVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ServiceProviderRelationshipAttractivenessResultDBDAO <br>
 * - ALPS-ServiceProviderResultManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kown Jeong hwa
 * @see ServiceProviderRelationshipAttractivenessResultBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ServiceProviderRelationshipAttractivenessResultDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchInputListVO searchInputListVO
	 * @return List<SearchServiceProviderRelationshipAttractivenessResultListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchServiceProviderRelationshipAttractivenessResultListVO> searchServiceProviderRelationshipAttractivenessResultListRSQL(SearchInputListVO searchInputListVO) throws DAOException {
		DBRowSet dbRowset = null;                                             
		List<SearchServiceProviderRelationshipAttractivenessResultListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchInputListVO != null){
				Map<String, String> mapVO = searchInputListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceProviderRelationshipAttractivenessResultDBDAOSearchAttractivenessResultRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchServiceProviderRelationshipAttractivenessResultListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpeRltAtrcRsltAddVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpeRltAtrcRslt(List<SpeRltAtrcRsltAddVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ServiceProviderRelationshipAttractivenessResultDBDAOMultiSpeRltAtrcRsltCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpeRltAtrcRsltAddVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpeRltAtrcRslt(List<SpeRltAtrcRsltAddVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ServiceProviderRelationshipAttractivenessResultDBDAOMultiSpeRltAtrcRsltUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpeRltAtrcRsltAddVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpeRltAtrcRslt(List<SpeRltAtrcRsltAddVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ServiceProviderRelationshipAttractivenessResultDBDAOMultiSpeRltAtrcRsltDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpeRltAtrcRsltAddVO> models
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifySpeRltSegmRslt(List<SpeRltAtrcRsltAddVO> models) throws DAOException,Exception {
		int updCnt[] = null; 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ServiceProviderRelationshipAttractivenessResultDBDAOModifySpeRltSegmRsltCSQL(), models,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	 
	
}