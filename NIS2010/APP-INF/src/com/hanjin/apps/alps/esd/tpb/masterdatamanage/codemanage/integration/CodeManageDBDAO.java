/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbCodeManageDBDAO.java
*@FileTitle : TPB Master Data Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 황건하
*@LastVersion : 1.1
* 2008.09.02 O Wan-Ki 1.0 최초 생성
* 2009.07.02 황건하         1.1 ALPS Migration
* -------------------------------------------------------
* History
* 2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.basic.CodeManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeInquiryListVO;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 TpbCodeManageDBDAO <br>
 * - NIS2010-TpbMasterDataManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author GUN-HA HWANG
 * @see CodeManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CodeManageDBDAO extends DBDAOSupport {

	/**
	 * TpbCodeManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param SearchCodeListVO searchTPBCodeListVO
	 * @return List<SearchCodeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCodeListVO> searchCodeListValue(SearchCodeListVO searchTPBCodeListVO) throws DAOException {
		//2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
		DBRowSet dbRowset = null;
		List<SearchCodeListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchTPBCodeListVO != null){
				Map<String, String> mapVO = searchTPBCodeListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOSearchCodeListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCodeListVO.class);

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
	 * @param List<SearchCodeListVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addSearchCodeList(List<SearchCodeListVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CodeManageDBDAOMultiCodeCSQL(), insModels,null);
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
	 * @param List<SearchCodeListVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifySearchCodeList(List<SearchCodeListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CodeManageDBDAOMultiCodeUSQL(), updModels,null);
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
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchCodeListVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeSearchCodeList(List<SearchCodeListVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CodeManageDBDAOMultiCodeDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}
	
	/**
	 * TpbCodeManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param SearchCodeInquiryListVO searchCodeInquiryListVO
	 * @return List<SearchCodeInquiryListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCodeInquiryListVO> searchCodeInquiryList(SearchCodeInquiryListVO searchCodeInquiryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCodeInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCodeInquiryListVO != null){
				Map<String, String> mapVO = searchCodeInquiryListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOSearchCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCodeInquiryListVO .class);
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