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
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.basic.PlanMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrGuidelineVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnDtlVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnHdrVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnTransVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.DisposalPlanGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.DisposalPlanINVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.GuidelineINVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.RepairExpensePlanGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.RepairExpensePlanINVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.OfficeCodeINVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.OfficeInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.OfficeInfoListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS PlanMgtDBDAO <br>
 * - ALPS-PlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author chung young hun
 * @see PlanMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class PlanMgtDBDAO extends DBDAOSupport {
	/**
	 *  Sequence를 찾아 List구조로 반환한다.
	 *
	 * @param RepairExpensePlanINVO repairExpensePlanINVO
	 * @return List<CustomMnrPlnHdrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomMnrPlnHdrVO> createPlanSequenceData(RepairExpensePlanINVO repairExpensePlanINVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CustomMnrPlnHdrVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(repairExpensePlanINVO != null){
					Map<String, String> mapVO = repairExpensePlanINVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOcreatePlanSequenceDataRSQL() , param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrPlnHdrVO .class);
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
	 * [EES_MNR_0112]Expense Plan Creation by HO의 Header 정보를 조회 합니다. <br>
	 *
	 * @param RepairExpensePlanINVO repairExpensePlanINVO
	 * @return List<CustomMnrPlnHdrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrPlnHdrVO> searchRepairExpensePlanHeaderData(RepairExpensePlanINVO repairExpensePlanINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrPlnHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(repairExpensePlanINVO != null){
				Map<String, String> mapVO = repairExpensePlanINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOsearchRepairExpensePlanHeaderDataRSQL() , param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrPlnHdrVO .class);
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
	 * [EES_MNR_0112]Expense Plan Creation by HO의 Detail 정보를 조회 합니다. <br>
	 *
	 * @param RepairExpensePlanINVO repairExpensePlanINVO
	 * @return List<CustomMnrPlnHdrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrPlnDtlVO> searchRepairExpensePlanDetailData(RepairExpensePlanINVO repairExpensePlanINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrPlnDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(repairExpensePlanINVO != null){
				Map<String, String> mapVO = repairExpensePlanINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOsearchRepairExpensePlanDetailDataRSQL(), param, velParam);
			if(dbRowset != null)
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrPlnDtlVO .class);
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
	 * [EES_MNR_0112]Expense Plan Creation by HO의 마스터 정보가 존재하는지 조회 합니다. <br>
	 * 
	 * @param CustomMnrPlnHdrVO customMnrPlnHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchSameRepairExpensePlanHeaderData(CustomMnrPlnHdrVO customMnrPlnHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(customMnrPlnHdrVO != null){
				Map<String, String> mapVO = customMnrPlnHdrVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOsearchSameRepairExpensePlanHeaderDataRSQL() , param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset.getRowCount();
	}
	
	/**
	 * [EES_MNR_0112]<br>
	 * 
	 * @param CustomMnrPlnDtlVO customMnrPlnDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchRepairExpensePlanMaxSequence(CustomMnrPlnDtlVO customMnrPlnDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(customMnrPlnDtlVO != null){
				Map<String, String> mapVO = customMnrPlnDtlVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOsearchRepairExpensePlanMaxSequenceRSQL() , param, velParam);
			
			if(dbRowset.next()){
				 cnt = dbRowset.getInt(1); 
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
	 * [EES_MNR_0112]<br>
	 * 
	 * @param CustomMnrPlnDtlVO customMnrPlnDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchRepairExpensePlanMinSequence(CustomMnrPlnDtlVO customMnrPlnDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(customMnrPlnDtlVO != null){
				Map<String, String> mapVO = customMnrPlnDtlVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOsearchRepairExpensePlanMinSequenceRSQL() , param, velParam);
			
			if(dbRowset.next()){
				 cnt = dbRowset.getInt(1); 
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
	 * [EES_MNR_0112]Expense Plan Creation by HO의 Header 정보를 저장 합니다. <br>
	 * 
	 * @param List<CustomMnrPlnHdrVO> customMnrPlnHdrVOS
	 * @exception DAOException
	 */
	public void addRepairExpensePlanHeaderData(List<CustomMnrPlnHdrVO> customMnrPlnHdrVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrPlnHdrVOS.size() > 0){	
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOaddRepairExpensePlanHeaderDataCSQL(), customMnrPlnHdrVOS,null);
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
	 * [EES_MNR_0112]Expense Plan Creation by HO의 Detail 정보를 저장 합니다. <br>
	 * 
	 * @param List<CustomMnrPlnDtlVO> customMnrPlnDtlVOS
	 * @exception DAOException
	 */
	public void addRepairExpensePlanDetailData(List<CustomMnrPlnDtlVO> customMnrPlnDtlVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrPlnDtlVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOaddRepairExpensePlanDetailDataCSQL(), customMnrPlnDtlVOS,null);
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
	 * [EES_MNR_0112]Expense Plan Creation by HO의 최초 Data일때 Detail 정보를 저장 합니다. <br>
	 * 
	 * @param List<CustomMnrPlnDtlVO> customMnrPlnDtlVOS
	 * @exception DAOException
	 */
	public void addRepairExpensePlanDetailNewData(List<CustomMnrPlnDtlVO> customMnrPlnDtlVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrPlnDtlVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOaddRepairExpensePlanDetailNewDataCSQL(), customMnrPlnDtlVOS,null);
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
	 * [EES_MNR_0112]Expense Plan Creation by HO의 Header 정보를 수정 합니다. <br>
	 * 
	 * @param List<CustomMnrPlnHdrVO> customMnrPlnHdrVOS
	 * @exception DAOException
	 */
	public void modifyRepairExpensePlanHeaderDataList(List<CustomMnrPlnHdrVO> customMnrPlnHdrVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrPlnHdrVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOmodifyRepairExpensePlanHeaderDataListUSQL(), customMnrPlnHdrVOS,null);
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
	 * [EES_MNR_0112]Expense Plan Creation by HO의 Detail 정보를 수정 합니다. <br>
	 * 
	 * @param List<CustomMnrPlnDtlVO> customMnrPlnDtlVOS
	 * @exception DAOException
	 */
	public void modifyRepairExpensePlanDetailDataList(List<CustomMnrPlnDtlVO> customMnrPlnDtlVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrPlnDtlVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOmodifyRepairExpensePlanDetailDataUSQL(), customMnrPlnDtlVOS,null);
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
	 * [EES_MNR_0112]Expense Plan Creation by HO의 Header 정보를 삭제 합니다. <br>
	 * 
	 * @param List<CustomMnrPlnHdrVO> customMnrPlnHdrVOS
	 * @exception DAOException
	 */
	public void removeRepairExpensePlanHeaderData(List<CustomMnrPlnHdrVO> customMnrPlnHdrVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrPlnHdrVOS.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOremoveRepairExpensePlanHeaderDataDSQL(), customMnrPlnHdrVOS,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No"+ i + " SQL");
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
	 * [EES_MNR_0112]Expense Plan Creation by HO의 Detail 정보를 삭제 합니다. <br>
	 * 
	 * @param List<CustomMnrPlnDtlVO> customMnrPlnDtlVOS
	 * @exception DAOException
	 */
	public void removeRepairExpensePlanDetailData(List<CustomMnrPlnDtlVO> customMnrPlnDtlVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(customMnrPlnDtlVOS.size() > 0){
				for(int i=0; i < customMnrPlnDtlVOS.size(); i++){
					Map<String, String> mapVO = customMnrPlnDtlVOS.get(i).getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					sqlExe.executeUpdate((ISQLTemplate)new PlanMgtDBDAOremoveRepairExpensePlanDetailDataDSQL(), param, velParam);
				}
//				delCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOremoveRepairExpensePlanDetailDataDSQL(), customMnrPlnDtlVOS,null);
//				for(int i = 0; i < delCnt.length; i++){
//					if(delCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to remove No"+ i + " SQL");
//				}
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
	 * [EES_MNR_0112 ] Expense Plan Creation의 Hearder Plan 플래그 정보를 수정 합니다. <br>
	 *
	 * @param RepairExpensePlanGRPVO repairExpensePlanGRPVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception DAOException
	 */
	public int modifyRepairExpensePlanHeaderData(RepairExpensePlanGRPVO repairExpensePlanGRPVO, 
			SignOnUserAccount account)throws DAOException,Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			CustomMnrPlnHdrVO[] volst = repairExpensePlanGRPVO.getCustomMnrPlnHdrVOS();
			CustomMnrPlnHdrVO   vo    = volst[0];
			vo.setMnrPlnFlg(repairExpensePlanGRPVO.getRepairExpensePlanINVO().getMnrPlnFlg());
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PlanMgtDBDAOmodifyRepairExpensePlanHeaderDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to UPDATE SQL");
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}

	
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

	/**
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalPlanGRPVO disposalPlanGRPVO
	 * @return List<CustomMnrPlnTransVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomMnrPlnTransVO> searchDisposalPlanHeaderData(DisposalPlanGRPVO disposalPlanGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrPlnTransVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 DisposalPlanINVO disposalPlanINVO = disposalPlanGRPVO.getDisposalPlanINVO();
			 Map<String, String> mapVO = disposalPlanINVO.getColumnValues();

			 param.putAll(mapVO);  
			 velParam.putAll(mapVO);  
			 
			 List<String> cntr_tpsz_cd_seqs = new ArrayList();
			 String[] arrayCntrTpszCdSeqs =  disposalPlanINVO.getCntrTpszCdSeq().split(",");
			 for(int i = 0; i < arrayCntrTpszCdSeqs.length; i ++){      
				 cntr_tpsz_cd_seqs.add(arrayCntrTpszCdSeqs[i]);     
			 } 
			 param.put("cntr_tpsz_cd_seqs", cntr_tpsz_cd_seqs);    
			 velParam.put("cntr_tpsz_cd_seqs", cntr_tpsz_cd_seqs); 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOsearchDisposalPlanHeaderDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrPlnTransVO .class);
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
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalPlanGRPVO disposalPlanGRPVO
	 * @return List<CustomMnrPlnTransVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrPlnTransVO> searchDisposalPlanDetailData(DisposalPlanGRPVO disposalPlanGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrPlnTransVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 DisposalPlanINVO disposalPlanINVO = disposalPlanGRPVO.getDisposalPlanINVO();
			 Map<String, String> mapVO = disposalPlanINVO.getColumnValues();
			 
			 param.putAll(mapVO);  
			 velParam.putAll(mapVO);   

			 List<String> cntr_tpsz_cd_seqs = new ArrayList();
			 String[] arrayCntrTpszCdSeqs =  disposalPlanINVO.getCntrTpszCdSeq().split(",");
			 for(int i = 0; i < arrayCntrTpszCdSeqs.length; i ++){      
				 cntr_tpsz_cd_seqs.add(arrayCntrTpszCdSeqs[i]);     
			 } 
			 param.put("cntr_tpsz_cd_seqs", cntr_tpsz_cd_seqs);    
			 velParam.put("cntr_tpsz_cd_seqs", cntr_tpsz_cd_seqs); 
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOsearchDisposalPlanDetailDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrPlnTransVO .class);
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
	  * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 삭제 합니다. <br>
	  *
	  * @param List<CustomMnrPlnHdrVO> customMnrPlnHdrVOS
	  * @exception DAOException
	  */   
	public void removeDisposalPlanHeaderData(List<CustomMnrPlnHdrVO> customMnrPlnHdrVOS) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");  
			int delCnt[] = null;  
			if(customMnrPlnHdrVOS.size() > 0){        
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOremoveDisposalPlanHeaderDataDSQL(), customMnrPlnHdrVOS,null);
				    
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
	
	/**
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrPlnDtlVO> customMnrPlnDtlVOS
	 * @exception DAOException
	 */
	public void removeDisposalPlanDetailData(List<CustomMnrPlnDtlVO> customMnrPlnDtlVOS) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");  
			int delCnt[] = null;  
			if(customMnrPlnDtlVOS.size() > 0){        
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOremoveDisposalPlanDetailDataDSQL(), customMnrPlnDtlVOS,null);
				
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

	/**
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrPlnHdrVO> customMnrPlnHdrVOS
	 * @exception DAOException
	 */ 
	public void addDisposalPlanHeaderData(List<CustomMnrPlnHdrVO> customMnrPlnHdrVOS) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrPlnHdrVOS.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOaddDisposalPlanHeaderDataCSQL(), customMnrPlnHdrVOS,null);
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
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrPlnDtlVO> customMnrPlnDtlVOs
	 * @exception DAOException
	 */
	public void addDisposalPlanDetailData(List<CustomMnrPlnDtlVO> customMnrPlnDtlVOs) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrPlnDtlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanMgtDBDAOaddDisposalPlanDetailDataCSQL(), customMnrPlnDtlVOs,null);
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
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 작업 합니다. <br>
	 *
	 * @param String mnrPlnSeq
	 * @return int
	 * @exception DAOException
	 */
	 public int getDisposalPlanDetailSeqData(String mnrPlnSeq) throws DAOException {
		 DBRowSet dbRowset = null;
		 int cnt = 0;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(mnrPlnSeq != null ){
				 param.put("mnr_pln_seq", mnrPlnSeq);
				 velParam.put("mnr_pln_seq", mnrPlnSeq); 
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOgetDisposalPlanDetailSeqDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 cnt = dbRowset.getInt(1); 
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
	  * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 작업 합니다. <br>
	  *
	  * @return String
	  * @exception DAOException
	  */
	 public String getDisposalPlanHeaderSeqData() throws DAOException {
		 DBRowSet dbRowset = null;
		 String sSeq = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOgetDisposalPlanHeaderSeqDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 sSeq = dbRowset.getString(1); 
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return sSeq;
	 }

	 /**
	  * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 체크 합니다. <br>
	  *
	  * @param DisposalPlanGRPVO disposalPlanGRPVO
	  * @return String
	  * @exception DAOException
	  */
	 public String checkDisposalPlanHeaderData(DisposalPlanGRPVO disposalPlanGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String cnt = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 DisposalPlanINVO disposalPlanINVO = disposalPlanGRPVO.getDisposalPlanINVO();
			 Map<String, String> mapVO = disposalPlanINVO.getColumnValues();
			 
			 param.putAll(mapVO);  
			 velParam.putAll(mapVO);   

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanMgtDBDAOcheckDisposalPlanHeaderDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 cnt = dbRowset.getString(1); 
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
	  * [EES_MNR_0224]Total Loss Performance의 정보를 조회 합니다. <br>
	  * popup에서 Office조회용 메소드
	  * 
	  * @param OfficeInfoGRPVO officeInfoGRPVO
	  * @return List<OfficeInfoListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<OfficeInfoListVO> searchOfficeCodeListData(OfficeInfoGRPVO officeInfoGRPVO) throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<OfficeInfoListVO> rtn = null;

	 	// query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	// velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();
	 	OfficeCodeINVO officeCodeINVO = officeInfoGRPVO.getOfficeCodeINVO();
	 	try {
	 		if (officeCodeINVO != null) {
	 			Map<String, String> mapVO = officeCodeINVO.getColumnValues();
	 			if (mapVO.get("ofc_cd").equals("ALL")) {
	 				mapVO.put("ofc_cd", "%");
	 			}
	 			param.putAll(mapVO);
	 			velParam.putAll(mapVO);
	 		}
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PlanMgtDBDAOsearchOfficeCodeListRSQL(), param, velParam);
	 		rtn = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeInfoListVO.class);

	 	} catch (SQLException se) {
	 		log.error(se.getMessage(), se);
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	} catch (Exception ex) {
	 		log.error(ex.getMessage(), ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}
	 	return rtn;

	 }
}
