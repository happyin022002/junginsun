/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtDBDAO.java
*@FileTitle : Expense Plan Creation by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.21 정영훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.planmanage.planmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.planmanage.planmgt.basic.PlanMgtBCImpl;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.vo.CustomMnrGuidelineVO;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.vo.GuidelineINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * COM PlanMgtDBDAO <br>
 * - COM-PlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author chung young hun
 * @see PlanMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class PlanMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * [EES_MNR_0216]M&R Guideline & Information의 정보를 조회 합니다. <br>
	 *
	 * @param GuidelineINVO guidelineINVO
	 * @return List<CustomMnrGuidelineVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGuidelineVO> searchGuidelineInfoListData(GuidelineINVO guidelineINVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrGuidelineVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{        
			if(guidelineINVO != null){
				Map<String, String> mapVO = guidelineINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOsearchGuidelineInfoListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGuidelineVO .class);      
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
	 * [EES_MNR_0216]M&R Guideline & Information의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrGuidelineVO> customMnrGuidelineVOS
	 * @exception DAOException
	 */ 
	public void addGuidelineInfoData(List<CustomMnrGuidelineVO> customMnrGuidelineVOS) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrGuidelineVOS.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOaddGuidelineInfoDataCSQL(), customMnrGuidelineVOS,null);
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
	} 	 
	
	/**
	 * [EES_MNR_0216]M&R Guideline & Information의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrGuidelineVO> customMnrGuidelineVOS
	 * @exception DAOException
	 */   
	public void modifyGuidelineInfoData(List<CustomMnrGuidelineVO> customMnrGuidelineVOS) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");  
			int updCnt[] = null;  
			if(customMnrGuidelineVOS.size() > 0){        
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOmodifyGuidelineInfoDataUSQL(), customMnrGuidelineVOS,null);
				    
				for(int i = 0; i < updCnt.length; i++){  
					if(updCnt[i]== Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to Update No"+ i + " SQL"); 
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
	 * [EES_MNR_0216]M&R Guideline & Information의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrGuidelineVO> customMnrGuidelineVOS
	 * @exception DAOException
	 */
	public void removeGuidelineInfoData(List<CustomMnrGuidelineVO> customMnrGuidelineVOS) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");  
			int delCnt[] = null;  
			if(customMnrGuidelineVOS.size() > 0){        
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOremoveGuidelineInfoDataDSQL(), customMnrGuidelineVOS,null);
				    
				for(int i = 0; i < delCnt.length; i++){  
					if(delCnt[i]== Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to Delete No"+ i + " SQL"); 
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
}
