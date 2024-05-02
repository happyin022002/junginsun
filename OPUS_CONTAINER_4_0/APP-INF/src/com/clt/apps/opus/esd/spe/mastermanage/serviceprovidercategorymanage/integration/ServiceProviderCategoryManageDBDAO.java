/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderCategoryManageDBDAO.java
*@FileTitle : S/P Category 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.27 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.basic.ServiceProviderCategoryManageBCImpl;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchOfficeCodeAllListVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchSPCategoryManageConditionVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchSPCategoryManageVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchVndrSeqVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SpeSvcProvSvcCateMtchVO;


/**
 * ALPS ServiceProviderCategoryManageDBDAO <br>
 * - ALPS-MasterManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author NAMKOONG Jin Ho
 * @see ServiceProviderCategoryManageBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ServiceProviderCategoryManageDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSPCategoryManageConditionVO searchSPCategoryManageConditionVO
	 * @return List<SearchSPCategoryManageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSPCategoryManageVO> searchSPCategoryManage(SearchSPCategoryManageConditionVO searchSPCategoryManageConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSPCategoryManageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSPCategoryManageConditionVO != null){
				Map<String, String> mapVO = searchSPCategoryManageConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceProviderCategoryManageDBDAOSearchSPCategoryManageRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSPCategoryManageVO .class);
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
		 * @return List<SearchOfficeCodeAllListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchOfficeCodeAllListVO> searchOfficeCodeAllList() throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchOfficeCodeAllListVO> list = null;
			//query parameter
//			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceProviderCategoryManageDBDAOSearchOfficeCodeAllListRSQL(), null, null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeCodeAllListVO .class);
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
			 * @param SearchVndrSeqVO searchVndrSeqVO
			 * @return List<SearchVndrSeqVO>
			 * @throws DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<SearchVndrSeqVO> searchVndrSeq(SearchVndrSeqVO searchVndrSeqVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<SearchVndrSeqVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
//				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(searchVndrSeqVO != null){
						Map<String, String> mapVO = searchVndrSeqVO .getColumnValues();
					
						param.putAll(mapVO);
//						velParam.putAll(mapVO);				
					}
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceProviderCategoryManageDBDAOSearchVndrSeqRSQL(), param, null);
					
				    list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVndrSeqVO .class);
					
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
	  * ALPS ServiceProviderCategoryManageDBDAO <br>
	  * - ALPS-MasterManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
	  * 
	  * @author NAMKOONG Jin Ho
	  * @see ServiceProviderCategoryManageBCImpl 참조
	  * @since J2EE 1.6
	  * @param String vndrSeq
	  * @return String
	  * @throws DAOException
	  */
	 public String cofirmUnique(String vndrSeq) throws DAOException{
		 DBRowSet dbRowset = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		 String chkUnique = "Y";
		 
		 try{
				param.put("vndr_seq", vndrSeq);
								
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceProviderCategoryManageDBDAOCofirmUniqueRSQL(), param, velParam);
				
				if(dbRowset.getRowCount() <= 0 )
					chkUnique = "N";	
						
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		
		 
		 return chkUnique;	
	 }
	 
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpeSvcProvSvcCateMtchVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addSpeSvcProvSvcCateMtch(List<SpeSvcProvSvcCateMtchVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ServiceProviderCategoryManageDBDAOMultiSpeSvcProvSvcCateMtchsCSQL(), insModels,null);
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
	 * @param List<SpeSvcProvSvcCateMtchVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifySpeSvcProvSvcCateMtch(List<SpeSvcProvSvcCateMtchVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ServiceProviderCategoryManageDBDAOMultiSpeSvcProvSvcCateMtchsUSQL(), updModels,null);
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
	 * @param List<SpeSvcProvSvcCateMtchVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeSpeSvcProvSvcCateMtch(List<SpeSvcProvSvcCateMtchVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ServiceProviderCategoryManageDBDAOMultiSpeSvcProvSvcCateMtchsDSQL(), delModels,null);
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
	
}