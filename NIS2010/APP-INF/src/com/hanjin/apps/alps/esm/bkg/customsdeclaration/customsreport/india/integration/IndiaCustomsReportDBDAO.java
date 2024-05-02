/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EurCustomsReportDBDAO.java
 *@FileTitle : EurCustomsReportDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.07.20 경종윤
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.basic.EurCustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndDecCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndExpAavanceListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndExpVesselPlanListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndReexportListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 CndCustomsReportDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyoung Jong Yun
 * @see EurCustomsReportBCImpl 참조
 * @since J2EE 1.6
 */
public class IndiaCustomsReportDBDAO extends DBDAOSupport {

	/**
	 * 인도 Export Vessel Plan List 조회(ESM_BKG_1223)<br>
	 * 
	 * @param  IndDecCondVO indDecCondVO
	 * @return List<IndExpVesselPlanListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IndExpVesselPlanListVO> searchExpVesselList( IndDecCondVO indDecCondVO ) throws DAOException {

		List<IndExpVesselPlanListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (indDecCondVO != null) {
				Map<String, String> mapVO = indDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaCustomsReportDBDAOSearchExportVesselInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IndExpVesselPlanListVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * 인도 Re export List 조회(ESM_BKG_1221)<br>
	 * 
	 * @param  IndDecCondVO indDecCondVO
	 * @return List<IndReexportListVO>
	 * @throws DAOException
	 */
	public List<IndReexportListVO> searchReexportList(IndDecCondVO indDecCondVO) throws DAOException {
		List<IndReexportListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (indDecCondVO != null) {
				Map<String, String> mapVO = indDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaCustomsReportDBDAOSearchReexportInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IndReexportListVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
		
		
	}
	
	/**
	 * 인도 Export Advanced List 조회(ESM_BKG_1222)<br>
	 * 
	 * @param  IndDecCondVO indDecCondVO
	 * @return List<IndExpAavanceListVO>
	 * @throws DAOException
	 */
	public List<IndExpAavanceListVO> searchExpAdvanceList(IndDecCondVO indDecCondVO) throws DAOException {
		List<IndExpAavanceListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (indDecCondVO != null) {
				Map<String, String> mapVO = indDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaCustomsReportDBDAOSearchExportAdvanceInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IndExpAavanceListVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
		
		
	}
	
	
	
}