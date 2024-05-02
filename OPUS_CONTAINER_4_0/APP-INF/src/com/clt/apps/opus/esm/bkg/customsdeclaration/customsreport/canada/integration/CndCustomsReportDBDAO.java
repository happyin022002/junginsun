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
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.basic.CndCustomsReportBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.CstmsReportVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS CndCustomsReportDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
}