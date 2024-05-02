/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AudPerfDAO.java
*@FileTitle : Performance For Logistics Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : YOON, Yong-Sang
*@LastVersion : 1.0
* 2014-12-05 YOON, Yong-Sang
* 1.0 최초 생성
*  
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.audperf.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchLgsCostCdVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfCostDtlListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfOfcListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfSpDtlListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * PsoAdvanceAuditDBDAO ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author YOON, Yong-Sang
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class AudPerfDAO extends DBDAOSupport {
	 /**
	  * Performance For Logistics Expense 조회한다.<br>
	  * 
	  * @param SearchPerfOfcListVO searchPerfOfcListVO
	  * @return List<SearchPerfOfcListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchPerfOfcListVO> searchPerfOfcList(SearchPerfOfcListVO searchPerfOfcListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchPerfOfcListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchPerfOfcListVO != null){
				 searchPerfOfcListVO.setSFmYm(searchPerfOfcListVO.getSFmYm().replaceAll("-", ""));
				 searchPerfOfcListVO.setSToYm(searchPerfOfcListVO.getSToYm().replaceAll("-", ""));
				 Map<String, String> mapVO = searchPerfOfcListVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AudPerfDAOSearchPerfOfcListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPerfOfcListVO .class);
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
	  * Performance For Logistics Expense - Cost Code 조회한다.<br>
	  * 
	  * @param SearchPerfOfcListVO searchPerfOfcListVO
	  * @return List<SearchPerfOfcListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchLgsCostCdVO> searchLgsCostCd(SearchLgsCostCdVO searchPerfOfcListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchLgsCostCdVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchPerfOfcListVO != null){
				 Map<String, String> mapVO = searchPerfOfcListVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AudPerfDAOSearchLgsCostCdRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLgsCostCdVO .class);
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
	  * Performance For Logistics Expense - S/P Detail 조회한다.<br>
	  * 
	  * @param SearchPerfSpDtlListVO searchPerfSpDtlListVO
	  * @return List<SearchPerfSpDtlListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchPerfSpDtlListVO> searchPerfSpDtlList(SearchPerfSpDtlListVO searchPerfSpDtlListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchPerfSpDtlListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchPerfSpDtlListVO != null){
				 searchPerfSpDtlListVO.setSYm((searchPerfSpDtlListVO.getSYm().replaceAll("-", "")));
				 Map<String, String> mapVO = searchPerfSpDtlListVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AudPerfDAOSearchPerfSpDtlListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPerfSpDtlListVO .class);
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
	  * Performance For Logistics Expense - Cost Detail 조회한다.<br>
	  * 
	  * @param SearchPerfCostDtlListVO searchPerfCostDtlListVO
	  * @return List<SearchPerfCostDtlListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchPerfCostDtlListVO> searchPerfCostDtlList(SearchPerfCostDtlListVO searchPerfCostDtlListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchPerfCostDtlListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchPerfCostDtlListVO != null){
				 searchPerfCostDtlListVO.setSYm((searchPerfCostDtlListVO.getSYm().replaceAll("-", "")));
				 Map<String, String> mapVO = searchPerfCostDtlListVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AudPerfDAOSearchPerfCostDtlListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPerfCostDtlListVO .class);
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
