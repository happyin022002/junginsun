/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ApplicationDateRuleDBDAO.java
*@FileTitle : Application Date Rule
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2011.07.07 김민아
* 1.0 Creation
=========================================================
* History
2011.07.07 김민아 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청 (Pricing)
                                                                      추가요건 - 조회 조건으로 access date 추가. Duration 중복 조건에 포함하여 그 날짜가 포함관계에 있으면 중복으로 처리.
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.basic.ApplicationDateRuleBC;
import com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.vo.RsltPriScgAplyDtRuleVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriScgAplyDtRuleVO;


/**
 * NIS2010 ApplicationDateRuleDBDAO <br>
 * - NIS2010-ApplicationDateRule system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Min Ah
 * @see ApplicationDateRuleBC 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ApplicationDateRuleDBDAO extends DBDAOSupport {

	/**
	 * Surcharge Preferences 리스트를 조회합니다. <br>
	 * 
	 * @param PriScgAplyDtRuleVO priScgAplyDtRuleVO
	 * @return List<RsltPriScgAplyDtRuleVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriScgAplyDtRuleVO> searchApplicatoinDateRule(PriScgAplyDtRuleVO priScgAplyDtRuleVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriScgAplyDtRuleVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScgAplyDtRuleVO != null){
				Map<String, String> mapVO = priScgAplyDtRuleVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApplicationDateRuleDBDAOPriScgAplyDtRuleVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriScgAplyDtRuleVO .class);
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
	 *  Application Date Rule 을 생성합니다.<br>
	 * 
	 * @param List<PriScgAplyDtRuleVO> insModels
	 * @exception DAOException
	 */
	public void addApplicatoinDateRule(List<PriScgAplyDtRuleVO> insModels) throws DAOException,Exception {
	    try {
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int insCnt[] = null;
	        if(insModels.size() > 0){
	            insCnt = sqlExe.executeBatch((ISQLTemplate)new ApplicationDateRuleDBDAOPriScgAplyDtRuleVOCSQL(), insModels,null);
	            for(int i = 0; i < insCnt.length; i++){
	                if(insCnt[i]== Statement.EXECUTE_FAILED)
	                    throw new DAOException("Fail to insert No"+ i + " SQL");
	            }
	        }
	    }catch(SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(),se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	    }
	}
	
	/**
	 * Application Date Rule 을 수정합니다. <br>
	 * 
	 * @param List<PriScgAplyDtRuleVO> updModels
	 * @exception DAOException
	 */
	public void modifyApplicatoinDateRule(List<PriScgAplyDtRuleVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ApplicationDateRuleDBDAOPriScgAplyDtRuleVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Location 체크 및 Location Type 을 조회합니다. <br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchLocationTypeAndName(RsltCdListVO rsltCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO.getColumnValues();
				
				param.putAll(mapVO);
				//code length
				velParam.put("cd_length", rsltCdListVO.getCd().length());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApplicationDateRuleDBDAOSearchLocationTypeAndNameRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
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
	 * Surcharge Preferences 리스트를 조회합니다. <br>
	 * 
	 * @param List<PriScgAplyDtRuleVO> chkModels
	 * @param List<PriScgAplyDtRuleVO> expModels
	 * @return List<RsltPriScgAplyDtRuleVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriScgAplyDtRuleVO> searchApplicationDateRuleDupCheck(List<PriScgAplyDtRuleVO> chkModels, List<PriScgAplyDtRuleVO> expModels) throws DAOException {
		DBRowSet dbRowset = null;
		List colNmList = new ArrayList();
		List<RsltPriScgAplyDtRuleVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(expModels!=null && expModels.size()>0){
				for(int j=0 ; j<expModels.size() ; j++){
					colNmList.add(expModels.get(j).getScgAplyDtRuleSeq());
				}
			}
			velParam.put("expVal", colNmList);
			velParam.put("chk_obj", chkModels);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApplicationDateRuleDBDAOPriScgAplyDtRuleDupCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriScgAplyDtRuleVO .class);
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