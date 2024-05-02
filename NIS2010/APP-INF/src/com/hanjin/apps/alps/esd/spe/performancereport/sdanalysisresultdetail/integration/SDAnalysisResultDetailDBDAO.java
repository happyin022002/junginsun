/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SDAnalysisResultDetailDBDAO.java
*@FileTitle : SD Analysis Result Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.integration.SDAnalysisReportDBDAOSearchSDAnalysisRSQL;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.vo.SpeSDAnalysisVO;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.basic.SDAnalysisResultDetailBCImpl;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.vo.SpeSDAnalysisDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS SDAnalysisResultDetailDBDAO <br>
 * - ALPS-PerformanceReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see SDAnalysisResultDetailBCImpl 참조
 * @since J2EE 1.6
 */
public class SDAnalysisResultDetailDBDAO extends DBDAOSupport {

	/**
	 * SD Analysis Result Detail 데이터를 조회한다.<br>
	 * 
	 * @param SpeSDAnalysisDtlVO speSDAnalysisDtlVO
	 * @return List<SpeSDAnalysisDtlVO>
	 * @exception EventException
	 */
	public List<SpeSDAnalysisDtlVO> searchSDAnalysisDtl(SpeSDAnalysisDtlVO speSDAnalysisDtlVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SpeSDAnalysisDtlVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(speSDAnalysisDtlVO != null){
				 Map<String, String> mapVO = speSDAnalysisDtlVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SDAnalysisResultDetailDBDAOSearchSDAnalysisDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpeSDAnalysisDtlVO .class);
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