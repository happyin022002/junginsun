/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbOfficeManageDBDAO.java
*@FileTitle : CodeManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.02 황건하
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.basic.OfficeManageBCImpl;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListForInquiryVO;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  TpbOfficeManageDBDAO <br>
 * - -TpbMasterDataManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author GUN-HA HWANG
 * @see OfficeManageBCImpl 참조
 * @since J2EE 1.6
 */
public class OfficeManageDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchOfficeListVO searchOfficeListVO
	 * @return List<SearchOfficeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchOfficeListVO> searchOfficeList(SearchOfficeListVO searchOfficeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchOfficeListVO != null){
				Map<String, String> mapVO = searchOfficeListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(searchOfficeListVO!=null && "G".equals(searchOfficeListVO.getSN3ptyOfcTpCd())){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeManageDBDAOSearchGeneralOfficeListRSQL(), param, velParam);
			}else{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeManageDBDAOSearchOfficeListRSQL(), param, velParam);
			}
			
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeListVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 	/** searchOfficeList2
	 	 * 
	 	 * @param searchOfficeListVO
	 	 * @return List<SearchOfficeListVO> 
	 	 * @throws DAOException
	 	 */
		public List<SearchOfficeListVO> searchOfficeList2(SearchOfficeListVO searchOfficeListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchOfficeListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchOfficeListVO != null){
					Map<String, String> mapVO = searchOfficeListVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeManageDBDAOSearchOfficeListRSQL(), param, velParam);
				
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeListVO .class);
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	 
		
		/** searchMdmOfficeCheck
		 * 
		 * @param searchOfficeListVO
		 * @return int
		 * @throws DAOException
		 */
		public int searchMdmOfficeCheck(SearchOfficeListVO searchOfficeListVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int cnt =0; 
			try{
				if(searchOfficeListVO != null){
					Map<String, String> mapVO = searchOfficeListVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeManageDBDAOSearchMdmOfficeCheckRSQL(), param, velParam);
				
				if(dbRowset!= null && dbRowset.next()){
					cnt = dbRowset.getInt("cnt");
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return cnt;
		}			
		
		/** searchHoRhqOfficeCheck
		 * 
		 * @param searchOfficeListVO
		 * @return int
		 * @throws DAOException
		 */
		public int searchHoRhqOfficeCheck(SearchOfficeListVO searchOfficeListVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int cnt =0; 
			try{
				if(searchOfficeListVO != null){
					Map<String, String> mapVO = searchOfficeListVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeManageDBDAOSearchHoRhqOfficeCheckRSQL(), param, velParam);
				
				if(dbRowset!= null && dbRowset.next()){
					cnt = dbRowset.getInt("cnt");
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return cnt;
		}					

		/**
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 * 
		 * @param SearchOfficeListVO searchOfficeListVO
		 * @return List<SearchOfficeListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchOfficeListVO> searchGeneralOfficeList(SearchOfficeListVO searchOfficeListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchOfficeListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchOfficeListVO != null){
					Map<String, String> mapVO = searchOfficeListVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeManageDBDAOSearchGeneralOfficeListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeListVO .class);
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	 

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchOfficeListVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addSearchOfficeList(List<SearchOfficeListVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeManageDBDAOMultiTPBOfficeCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchOfficeListVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifySearchOfficeList(List<SearchOfficeListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeManageDBDAOMultiTPBOfficeUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/** modifySearchOfficeList
	 * 
	 * @param updModel
	 * @throws DAOException
	 */
	public void modifySearchOfficeList(SearchOfficeListVO updModel) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========    modifySearchOfficeList() ============");

		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(updModel != null){
				Map<String, String> mapVO = updModel.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OfficeManageDBDAOMultiTPBOfficeUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchOfficeListForInquiryVO searchOfficeListForInqiuryVO
	 * @return List<SearchOfficeListForInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchOfficeListForInquiryVO> searchOfficeListForInqiuryValue(SearchOfficeListForInquiryVO searchOfficeListForInqiuryVO) throws DAOException {
		//2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
		DBRowSet dbRowset = null;
		List<SearchOfficeListForInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchOfficeListForInqiuryVO != null){
				Map<String, String> mapVO = searchOfficeListForInqiuryVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeManageDBDAOSearchOfficeListForInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeListForInquiryVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
}