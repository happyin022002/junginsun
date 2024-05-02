/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPIDetailReportbyKPIDBDAO.java
*@FileTitle : KPI Detail Report by KPI
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.basic.KPIDetailReportbyKPIBCImpl;
import com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.vo.KPIDetailReportVO;
import com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.integration.PAResultDetaibySPDBDAOsearchPaResultDetaiSPRSQL;
import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS KPIDetailReportbyKPIDBDAO <br>
 * - ALPS-PerformanceReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see KPIDetailReportbyKPIBCImpl 참조
 * @since J2EE 1.6
 */
public class KPIDetailReportbyKPIDBDAO extends DBDAOSupport {


	/**
	 * KPI Detail Report by KPI 데이터를 조회한다.<br>
	 * 
	 * @param KPIDetailReportVO kPIDetailReportVO
	 * @return List<PAResultDetaibySPVO>
	 * @exception EventException
	 */
	public List<KPIDetailReportVO> searchKPIDetailReport(KPIDetailReportVO kPIDetailReportVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<KPIDetailReportVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(kPIDetailReportVO != null){
				 Map<String, String> mapVO = kPIDetailReportVO .getColumnValues();
				 

					List listSpKpiId	= Utils.replaceStringToList(kPIDetailReportVO.getSSpKpiId());
					velParam.put("list_sp_kpi_id", listSpKpiId);	
					
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KPIDetailReportbyKPIDBDAOSearchKPIDetailReportRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, KPIDetailReportVO .class);
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