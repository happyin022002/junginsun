/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SDAnalysisReportDBDAO.java
*@FileTitle : SD Analysis Report
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.integration.EGandEvaluatorDBDAOSearchEGEVBasicRSQL;
import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.vo.SpeEGEVMappingVO;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.basic.SDAnalysisReportBC;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.basic.SDAnalysisReportBCImpl;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.vo.SpeSDAnalysisVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS SDAnalysisReportDBDAO <br>
 * - ALPS-PerformanceReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see SDAnalysisReportBCImpl 참조
 * @since J2EE 1.6
 */
public class SDAnalysisReportDBDAO extends DBDAOSupport {


	/**
	 * SD Analysis Report 데이터를 조회한다.<br>
	 * 
	 * @param SpeSDAnalysisVO speSDAnalysisVO
	 * @return List<SpeSDAnalysisVO>
	 * @exception EventException
	 */
	public List<SpeSDAnalysisVO> searchSDAnalysis(SpeSDAnalysisVO speSDAnalysisVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SpeSDAnalysisVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(speSDAnalysisVO != null){
				 Map<String, String> mapVO = speSDAnalysisVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SDAnalysisReportDBDAOSearchSDAnalysisRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpeSDAnalysisVO .class);
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