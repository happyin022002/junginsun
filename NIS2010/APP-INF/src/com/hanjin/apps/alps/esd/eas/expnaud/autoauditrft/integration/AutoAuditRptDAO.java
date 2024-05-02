/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAO.java
*@FileTitle : Performance For Logistics Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2016-02-11
*@LastModifier : CJH
*@LastVersion : 1.0
* 2014-12-05 CJH
* 1.0 최초 생성
*  
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo.SearchAutoAuditChangeHistoryVO;
import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo.SearchAutoAuditStatisticsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * AutoAuditRptDAO  PDTO(Data Transfer Object including Parameters)<br>
 * @author YOON, Yong-Sang
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class AutoAuditRptDAO extends DBDAOSupport {
	 /**
	  * Auto Audit Chagne History 조회<br>
	  * 
	  * @param SearchAutoAuditChangeHistoryVO searchAutoAuditChangeHistoryVO
	  * @return List<SearchAutoAuditChangeHistoryVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchAutoAuditChangeHistoryVO> searchAutoAuditChangeHistory(SearchAutoAuditChangeHistoryVO searchAutoAuditChangeHistoryVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchAutoAuditChangeHistoryVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchAutoAuditChangeHistoryVO != null){
				 searchAutoAuditChangeHistoryVO.setSInvCfmFmDt(searchAutoAuditChangeHistoryVO.getSInvCfmFmDt().replaceAll("-", ""));
				 searchAutoAuditChangeHistoryVO.setSInvCfmToDt(searchAutoAuditChangeHistoryVO.getSInvCfmToDt().replaceAll("-", ""));
				 Map<String, String> mapVO = searchAutoAuditChangeHistoryVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AutoAuditRptDAOsearchAutoAuditChangeHistoryRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAutoAuditChangeHistoryVO.class);
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
	  * Auto Audit Statistics 조회<br>
	  * 
	  * @param SearchAutoAuditStatisticsVO searchAutoAuditStatisticsVO
	  * @return List<SearchAutoAuditStatisticsVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchAutoAuditStatisticsVO> searchAutoAuditStatistics(SearchAutoAuditStatisticsVO searchAutoAuditStatisticsVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchAutoAuditStatisticsVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchAutoAuditStatisticsVO != null){
				 searchAutoAuditStatisticsVO.setSInvCfmFmDt(searchAutoAuditStatisticsVO.getSInvCfmFmDt().replaceAll("-", ""));
				 searchAutoAuditStatisticsVO.setSInvCfmToDt(searchAutoAuditStatisticsVO.getSInvCfmToDt().replaceAll("-", ""));
				 Map<String, String> mapVO = searchAutoAuditStatisticsVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AutoAuditRptDAOsearchAutoAuditStatisticsRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAutoAuditStatisticsVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	

}
