/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CndCustomsReportDBDAO.java
 *@FileTitle : CndCustomsReportDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.basic.CndCustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.BaplieMonitorCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.CstmsReportVO;
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
 * @author Kim Min Jeong 
 * @see CndCustomsReportBCImpl 참조
 * @since J2EE 1.4
 */
public class CndCustomsReportDBDAO extends DBDAOSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 세관 신고와 관련된 각종 Report를 처리
	 * 
	 * @param cndCstmsReportCondVO 조회조건
	 * @return List<CstmsReportVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsReportVO> searchCndAdviceNotes(CndCstmsReportCondVO cndCstmsReportCondVO) throws DAOException {
		List<CstmsReportVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsReportCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsReportCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsReportDBDAOsearchCndAdviceNotesRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsReportVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * CANADA ACI : ACI Monitoring 조회<br>
	 * 
	 * @param ACIMonitorCondVO aCIMonitorCondVO
	 * @return List<ACIMonitorListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ACIMonitorListVO> searchACIMonitor(ACIMonitorCondVO aCIMonitorCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ACIMonitorListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (aCIMonitorCondVO != null){
				Map<String, String> mapVO = aCIMonitorCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndCustomsReportDBDAOsearchACIMonitorRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ACIMonitorListVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * 
	 * @param BaplieMonitorCondVO baplieMonitorCondVO
	 * @return List<BaplieMonitorCondVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BaplieMonitorCondVO> searchBaplieMonitor(BaplieMonitorCondVO baplieMonitorCondVO) throws DAOException {
		List<BaplieMonitorCondVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try	{

			Map<String, String> mapVO = baplieMonitorCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new CndCustomsReportDBDAOsearchBaplieMonitorRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaplieMonitorCondVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * 
	 * @param String vvd
	 * @return String crrCd
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BaplieMonitorCondVO> searchUsLastForeignPort(String vvd) throws DAOException {
		List<BaplieMonitorCondVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try	{

			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new CndCustomsReportDBDAOsearchUsLastForeignPortRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaplieMonitorCondVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}