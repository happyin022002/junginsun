/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BatchHistoryReportDBDAO.java
*@FileTitle : Daily Batch Job Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.12 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.basic.BatchHistoryReportBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.BatHistParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.DmtBatHisVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 BatchHistoryReportDBDAO <br>
 * - NIS2010-DMTPerformanceAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Sung Hwan
 * @see BatchHistoryReportBCImpl 참조
 * @since J2EE 1.4
 */
public class BatchHistoryReportDBDAO extends DBDAOSupport {

	/**
	 * 각 지역 서버별로 배치 이력을 조회 한다.<br>
	 * 
	 * @param BatHistParmVO batHistParmVO
	 * @return List<DmtBatHisVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DmtBatHisVO> searchBatchHistory(BatHistParmVO batHistParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DmtBatHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(batHistParmVO != null){
				Map<String, String> mapVO = batHistParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new BatchHistoryReportDBDAODmtBatHisVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtBatHisVO .class);
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
