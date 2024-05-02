/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineDBDAO.java
*@FileTitle : CMPB Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.30 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.basic.CMPBGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltCmpbGuidelineReportVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltCmpbGuidelineVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltOriDestLocationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineAmtVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineBaseListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineCmdtVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineRoutPntVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineRoutViaVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineServiceLaneVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineSvcLaneVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltRepCmdtAndCmdtVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriCmpbGlineAmtVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineBseVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineCmdtVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineCustVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineRoutPntVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineRoutViaVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineSvcLaneVO;


/**
 * NIS2010 CMPBGuidelineDBDAO <br>
 * - NIS2010-ProfitabilitySimulation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung-Jun,Lee
 * @see CMPBGuidelineBCImpl 참조
 * @since J2EE 1.6
 */
public class CMPBGuidelineDBDAO extends DBDAOSupport {
	
	/**
	 * SVC SCOPE 별 SERVICE LANE 조회(POPUP)<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return List<RsltPriCmpbGlineServiceLaneVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriCmpbGlineServiceLaneVO> searchServiceLaneList(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCmpbGlineServiceLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAORsltPriCmpbGlineServiceLaneVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCmpbGlineServiceLaneVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * CMPB GLINE INQUIRY(ESM_PRI_6003)<br>
	 * 
	 * @param RsltCmpbGuidelineVO rsltCmpbGuidelineVO 
	 * @return List<RsltCmpbGuidelineReportVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCmpbGuidelineReportVO> searchCmpbGuidelineReportList(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCmpbGuidelineReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltCmpbGuidelineVO != null){
				Map<String, String> mapVO = rsltCmpbGuidelineVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOCmpbGuidelineReportRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCmpbGuidelineReportVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 
	
	/**
	 * GLINE SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriCmpbGlineMnVO priCmpbGlineMnVO  
	 * @return int
	 * @throws DAOException
	 */
	public int searchCmpbGuidelineMaxGlineSeq(PriCmpbGlineMnVO priCmpbGlineMnVO) throws DAOException {
		int gline_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineMnVO != null){
				Map<String, String> mapVO = priCmpbGlineMnVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMaxGlineSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				gline_seq = dbRowset.getInt("MAX_GLINE_SEQ");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return gline_seq;
	}
	
	
	/**
	 * BASE SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return int
	 * @throws DAOException
	 */
	public int searchCmpbGuidelineMaxBaseSeq(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		int gline_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMaxBaseSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				gline_seq = dbRowset.getInt("MAX_BSE_SEQ");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return gline_seq;
	}
	
	
	/**
	 * CMPB SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return int
	 * @throws DAOException
	 */
	public int searchCmpbGuidelineMaxCmpbSeq(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		int cmpb_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMaxCmpbSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				cmpb_seq = dbRowset.getInt("MAX_CMPB_SEQ");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cmpb_seq;
	}
	
	
	/**
	 * 듀레이션이 겹치는지를 조회한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO 
	 * @return int
	 * @throws DAOException
	 */
	public int searchCheckDuration(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO) throws DAOException {
		int chk = 0;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltDurationCreationOfficeVO != null){
				Map<String, String> mapVO = rsltDurationCreationOfficeVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCheckDurationRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				chk = dbRowset.getInt("CHK");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return chk;
	}
	
	
	/**
	 * COPY 시 듀레이션이 겹치는지를 조회한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO 
	 * @return int
	 * @throws DAOException
	 */
	public int searchCheckDurationAddCopy(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO) throws DAOException {
		int gline_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltDurationCreationOfficeVO != null){
				Map<String, String> mapVO = rsltDurationCreationOfficeVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCheckDurationAddCopyRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				gline_seq = dbRowset.getInt("GLINE_SEQ");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return gline_seq;
	}
	
	
	
	/**
	 * CMPBGuideline office combo List 를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return List<RsltDurationCreationOfficeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltDurationCreationOfficeVO> searchDurationCreationOfficeList(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltDurationCreationOfficeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAODurationCreationOfficeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltDurationCreationOfficeVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 
	/**
	 * CMPBGuideline Inquiry Main 정보를 조회한다.<br>
	 * 
	 * @param RsltCmpbGuidelineVO priCmpbGlineMnVO 
	 * @return List<PriCmpbGlineMnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriCmpbGlineMnVO> searchReportCreationOfficeList(RsltCmpbGuidelineVO priCmpbGlineMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriCmpbGlineMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineMnVO != null){
				Map<String, String> mapVO = priCmpbGlineMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOCmpbGuidelineReportOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriCmpbGlineMnVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * CMPBGuideline header search<br>
	 * 
	 * @param RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO 
	 * @return List<RsltDurationCreationOfficeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltDurationCreationOfficeVO> searchCmpbGuidelineHdr(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltDurationCreationOfficeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltDurationCreationOfficeVO != null){
				Map<String, String> mapVO = rsltDurationCreationOfficeVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltDurationCreationOfficeVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	
	/**
	 * CMPBGuideline base List search<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return List<RsltPriCmpbGlineBaseListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriCmpbGlineBaseListVO> searchCmpbGuidelineBaseList(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCmpbGlineBaseListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineBaseListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCmpbGlineBaseListVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 
	
	

	/**
	 * CMPBGuidelineDBDAO의 CMDT 관련 정보를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return List<RsltPriCmpbGlineCmdtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriCmpbGlineCmdtVO> searchCmpbGuidelineCommodity(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCmpbGlineCmdtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCmpbGlineCmdtVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * CMPBGuidelineDBDAO의 ORIGIN ROUTE VIA 정보를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return List<RsltPriCmpbGlineRoutViaVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriCmpbGlineRoutViaVO> searchCmpbGuidelineOrgRouteVia(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCmpbGlineRoutViaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriOrgCmpbGlineRoutViaVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCmpbGlineRoutViaVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 /**
	 * CMPBGuidelineDBDAO의 DESTINATION ROUTE VIA 정보를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return List<RsltPriCmpbGlineRoutViaVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriCmpbGlineRoutViaVO> searchCmpbGuidelineDestRouteVia(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCmpbGlineRoutViaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriDestCmpbGlineRoutViaVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCmpbGlineRoutViaVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 
	
	/**
	 * CMPBGuidelineDBDAO의 CMPB AMT 정보를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return List<RsltPriCmpbGlineAmtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriCmpbGlineAmtVO> searchCmpbGuidelineAmount(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCmpbGlineAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineAmtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCmpbGlineAmtVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * CMPBGuidelineDBDAO의 ORIGIN ROUTE POINT 정보를 조회한다.<br>
	 * 
	 * @param priCmpbGlineBseVO PriCmpbGlineBseVO
	 * @return List<RsltPriCmpbGlineRoutPntVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriCmpbGlineRoutPntVO> searchCmpbGuidelineOrgRoutePoint(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCmpbGlineRoutPntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriOrgCmpbGlineRoutPntVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCmpbGlineRoutPntVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * CMPBGuidelineDBDAO의 DESTINATION ROUTE PORINT 정보를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return List<RsltPriCmpbGlineRoutPntVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriCmpbGlineRoutPntVO> searchCmpbGuidelineDestRoutePoint(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCmpbGlineRoutPntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriDestCmpbGlineRoutPntVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCmpbGlineRoutPntVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		 
	/**
	 * CMPBGuidelineDBDAO의 SVC LANE 정보를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return List<RsltPriCmpbGlineSvcLaneVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriCmpbGlineSvcLaneVO> searchCmpbGuidelineServiceLane(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCmpbGlineSvcLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineSvcLaneVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCmpbGlineSvcLaneVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * CMPBGuidelineDBDAO의 PRI_CMPB_GLINE_BSE 정보를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return List<PriCmpbGlineBseVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriCmpbGlineBseVO> searchCmpbGuidelineBase(PriCmpbGlineBseVO priCmpbGlineBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriCmpbGlineBseVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineBseVO != null){
				Map<String, String> mapVO = priCmpbGlineBseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineBseVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriCmpbGlineBseVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	
	/**
	 * PRI_CMPB_GLINE_ROUT_VIA 데이터를 생성한다.<br>
	 * 
	 * @param PriCmpbGlineRoutViaVO vo 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineRouteVia(PriCmpbGlineRoutViaVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutViaVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_ROUT_VIA 데이터를 copy 생성한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO vo 
	 * @throws DAOException
	 */
	public void addCopyCmpbGuidelineRouteVia(RsltDurationCreationOfficeVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutViaVOAddCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_ROUT_VIA 데이터를 갱신한다.<br>
	 * 
	 * @param PriCmpbGlineRoutViaVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCmpbGuidelineRouteVia(PriCmpbGlineRoutViaVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutViaVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_CMPB_GLINE_ROUT_VIA 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineRoutViaVO vo 
	 * @return int 
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineRouteVia(PriCmpbGlineRoutViaVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutViaVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * BSE_SEQ별 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int 
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineRouteVia(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutViaVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * base SEQ별 origin별 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int 
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineOrgRouteVia(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriOrgCmpbGlineRoutViaVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * base SEQ별 dest별 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineDestRouteVia(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriDestCmpbGlineRoutViaVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	

	/**
	 * PRI_CMPB_GLINE_ROUT_VIA 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriCmpbGlineRoutViaVO> insModels 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineRouteViaS(List<PriCmpbGlineRoutViaVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutViaVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * PRI_CMPB_GLINE_ROUT_VIA 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriCmpbGlineRoutViaVO> updModels 
	 * @throws DAOException
	 */
	public void modifyCmpbGuidelineRouteViaS(List<PriCmpbGlineRoutViaVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutViaVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_ROUT_VIA 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriCmpbGlineRoutViaVO> delModels 
	 * @throws DAOException
	 */
	public void removeCmpbGuidelineRouteViaS(List<PriCmpbGlineRoutViaVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutViaVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
/**
	 * PRI_CMPB_GLINE_MN 데이터를 생성한다.<br>
	 * 
	 * @param PriCmpbGlineMnVO vo 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineMain(PriCmpbGlineMnVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMnVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_MN 데이터를 생성한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO vo 
	 * @throws DAOException
	 */
	public void addCopyCmpbGuidelineMain(RsltDurationCreationOfficeVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMnVOAddCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_MN 데이터를 갱신한다.<br>
	 * 
	 * @param PriCmpbGlineMnVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCmpbGuidelineMain(PriCmpbGlineMnVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMnVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * Gline Confirm or Confirm Cancel.<br>
	 * 
	 * @param PriCmpbGlineMnVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int modifyConfirmCmpbGuideline(PriCmpbGlineMnVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMnVOConfirmUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_CMPB_GLINE_MN 데이터를 삭제한다.()<br>
	 * 
	 * @param PriCmpbGlineMnVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineMain(PriCmpbGlineMnVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMnVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_CMPB_GLINE_MN 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriCmpbGlineMnVO> insModels 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineMainS(List<PriCmpbGlineMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMnVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * PRI_CMPB_GLINE_MN 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriCmpbGlineMnVO> updModels 
	 * @throws DAOException
	 */
	public void modifyCmpbGuidelineMainS(List<PriCmpbGlineMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMnVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_MN 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriCmpbGlineMnVO> delModels 
	 * @throws DAOException
	 */
	public void removeCmpbGuidelineMainS(List<PriCmpbGlineMnVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMnVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_BSE 데이터를 생성한다.<br>
	 * 
	 * @param vo PriCmpbGlineBseVO
	 * @throws DAOException
	 */
	public void addCmpbGuidelineBase(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineBseVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_BSE 데이터를 카피 생성한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO vo 
	 * @throws DAOException
	 */
	public void addCopyCmpbGuidelineBase(RsltDurationCreationOfficeVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineBseVOAddCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_BSE 데이터를 갱신한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCmpbGuidelineBase(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineBseVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_CMPB_GLINE_BSE 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineBase(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineBseVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_CMPB_GLINE_BSE 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineMnVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineBase(PriCmpbGlineMnVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineBseVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	

	/**
	 * PRI_CMPB_GLINE_BSE 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriCmpbGlineBseVO> insModels 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineBaseS(List<PriCmpbGlineBseVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineBseVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * PRI_CMPB_GLINE_BSE 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriCmpbGlineBseVO> updModels 
	 * @throws DAOException
	 */
	public void modifyCmpbGuidelineBaseS(List<PriCmpbGlineBseVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineBseVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_BSE 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriCmpbGlineBseVO> delModels 
	 * @throws DAOException
	 */
	public void removeCmpbGuidelineBaseS(List<PriCmpbGlineBseVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineBseVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_CUST 데이터를 생성한다.<br>
	 * 
	 * @param PriCmpbGlineCustVO vo 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineCustomer(PriCmpbGlineCustVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCustVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_CUST 데이터를 카피 생성한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO vo 
	 * @throws DAOException
	 */
	public void addCopyCmpbGuidelineCustomer(RsltDurationCreationOfficeVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCustVOAddCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_CUST 데이터를 갱신한다.<br>
	 * 
	 * @param PriCmpbGlineCustVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCmpbGuidelineCustomer(PriCmpbGlineCustVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCustVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_CMPB_GLINE_CUST 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineCustVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineCustomer(PriCmpbGlineCustVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCustVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_CMPB_GLINE_CUST 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineCustomer(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCustVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_CMPB_GLINE_CUST 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriCmpbGlineCustVO> insModels 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineCustomerS(List<PriCmpbGlineCustVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCustVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * PRI_CMPB_GLINE_CUST 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriCmpbGlineCustVO> updModels 
	 * @throws DAOException
	 */
	public void modifyCmpbGuidelineCustomerS(List<PriCmpbGlineCustVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCustVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_CUST 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriCmpbGlineCustVO> delModels 
	 * @throws DAOException
	 */
	public void removeCmpbGuidelineCustomerS(List<PriCmpbGlineCustVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCustVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_CMDT 데이터를 생성한다.<br>
	 * 
	 * @param PriCmpbGlineCmdtVO vo 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineCommodity(PriCmpbGlineCmdtVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCmdtVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_CMDT 데이터를 copy 생성한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO vo 
	 * @throws DAOException
	 */
	public void addCopyCmpbGuidelineCommodity(RsltDurationCreationOfficeVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCmdtVOAddCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_CMDT 데이터를 갱신한다.<br>
	 * 
	 * @param PriCmpbGlineCmdtVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCmpbGuidelineCommodity(PriCmpbGlineCmdtVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCmdtVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_CMPB_GLINE_CMDT 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineCmdtVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineCommodity(PriCmpbGlineCmdtVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCmdtVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_CMPB_GLINE_CMDT bse_seq별 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineCommodity(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCmdtVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_CMPB_GLINE_CMDT 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriCmpbGlineCmdtVO> insModels 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineCommodityS(List<PriCmpbGlineCmdtVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCmdtVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * PRI_CMPB_GLINE_CMDT 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriCmpbGlineCmdtVO> updModels 
	 * @throws DAOException
	 */
	public void modifyCmpbGuidelineCommodityS(List<PriCmpbGlineCmdtVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCmdtVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_CMDT 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriCmpbGlineCmdtVO> delModels 
	 * @throws DAOException
	 */
	public void removeCmpbGuidelineCommodityS(List<PriCmpbGlineCmdtVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineCmdtVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_ROUT_PNT 데이터를 생성한다.<br>
	 * 
	 * @param PriCmpbGlineRoutPntVO vo 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineRouetPoint(PriCmpbGlineRoutPntVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutPntVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_ROUT_PNT 데이터를 copy 생성한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO vo 
	 * @throws DAOException
	 */
	public void addCopyCmpbGuidelineRoutePoint(RsltDurationCreationOfficeVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutPntVOAddCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_ROUT_PNT 데이터를 갱신한다.<br>
	 * 
	 * @param PriCmpbGlineRoutPntVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCmpbGuidelineRoutePoint(PriCmpbGlineRoutPntVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutPntVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_CMPB_GLINE_ROUT_PNT 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineRoutPntVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineRoutePoint(PriCmpbGlineRoutPntVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutPntVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_CMPB_GLINE_ROUT_PNT 헤더별 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineRoutePoint(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutPntVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_CMPB_GLINE_ROUT_PNT base별 origin별 삭제.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineOrgRoutePoint(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriOrgCmpbGlineRoutPntVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_CMPB_GLINE_ROUT_PNT base별 dest별 삭제.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineDestRoutePoint(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriDestCmpbGlineRoutPntVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	

	/**
	 * PRI_CMPB_GLINE_ROUT_PNT 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriCmpbGlineRoutPntVO> insModels 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineRouetPointS(List<PriCmpbGlineRoutPntVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutPntVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * PRI_CMPB_GLINE_ROUT_PNT 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriCmpbGlineRoutPntVO> updModels 
	 * @throws DAOException
	 */
	public void modifyCmpbGuidelineRoutePointS(List<PriCmpbGlineRoutPntVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutPntVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_ROUT_PNT 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriCmpbGlineRoutPntVO> delModels 
	 * @throws DAOException
	 */
	public void removeCmpbGuidelineRouetPointS(List<PriCmpbGlineRoutPntVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineRoutPntVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_AMT 데이터를 생성한다.<br>
	 * 
	 * @param PriCmpbGlineAmtVO vo 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineAmount(PriCmpbGlineAmtVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineAmtVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_AMT 데이터를 copy 생성한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO vo 
	 * @throws DAOException
	 */
	public void addCopyCmpbGuidelineAmount(RsltDurationCreationOfficeVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineAmtVOAddCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_AMT 데이터를 갱신한다.<br>
	 * 
	 * @param PriCmpbGlineAmtVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCmpbGuidelineAmount(PriCmpbGlineAmtVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineAmtVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_CMPB_GLINE_AMT 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineAmtVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineAmount(PriCmpbGlineAmtVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineAmtVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_CMPB_GLINE_AMT 헤더별 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineAmount(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineAmtVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_CMPB_GLINE_AMT 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriCmpbGlineAmtVO> insModels 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineAmountS(List<PriCmpbGlineAmtVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineAmtVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * PRI_CMPB_GLINE_AMT 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriCmpbGlineAmtVO> updModels 
	 * @throws DAOException
	 */
	public void modifyCmpbGuidelineAmountS(List<PriCmpbGlineAmtVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineAmtVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_AMT 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriCmpbGlineAmtVO> delModels 
	 * @throws DAOException
	 */
	public void removeCmpbGuidelineAmountS(List<PriCmpbGlineAmtVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineAmtVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * PRI_CMPB_GLINE_SVC_LANE 데이터를 생성한다.<br>
	 * 
	 * @param PriCmpbGlineSvcLaneVO vo 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineServiceLane(PriCmpbGlineSvcLaneVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineSvcLaneVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_SVC_LANE 데이터를 copy 생성한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO vo 
	 * @throws DAOException
	 */
	public void addCopyCmpbGuidelineServiceLane(RsltDurationCreationOfficeVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineSvcLaneVOAddCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_SVC_LANE 데이터를 갱신한다.<br>
	 * 
	 * @param PriCmpbGlineSvcLaneVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCmpbGuidelineServiceLane(PriCmpbGlineSvcLaneVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineSvcLaneVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_CMPB_GLINE_SVC_LANE 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineSvcLaneVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineServiceLane(PriCmpbGlineSvcLaneVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineSvcLaneVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_CMPB_GLINE_SVC_LANE 헤더별 데이터를 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineServiceLane(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineSvcLaneVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_CMPB_GLINE_SVC_LANE 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriCmpbGlineSvcLaneVO> insModels 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineServiceLaneS(List<PriCmpbGlineSvcLaneVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineSvcLaneVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * PRI_CMPB_GLINE_SVC_LANE 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriCmpbGlineSvcLaneVO> updModels 
	 * @throws DAOException
	 */
	public void modifyCmpbGuidelineServiceLaneS(List<PriCmpbGlineSvcLaneVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineSvcLaneVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_SVC_LANE 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriCmpbGlineSvcLaneVO> delModels 
	 * @throws DAOException
	 */
	public void removeCmpbGuidelineServiceLaneS(List<PriCmpbGlineSvcLaneVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineSvcLaneVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_MAPG INSERT.<br>
	 * 
	 * @param PriCmpbGlineMnVO vo 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineMapg(PriCmpbGlineMnVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMapgCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_CMPB_GLINE_MAPG DELETE.<br>
	 * 
	 * @param PriCmpbGlineMnVO vo 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGuidelineMapg(PriCmpbGlineMnVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineMapgDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * Rate Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO  
	 * @return List<RsltRtListVerticalExcelVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListVerticalExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltDurationCreationOfficeVO != null) {
				Map<String, String> mapVO = rsltDurationCreationOfficeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CMPBGuidelineDBDAORsltRtListVerticalExcelVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListVerticalExcelVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * svc scp에 따른 모든 svc lane을 일괄 등록한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO vo 
	 * @throws DAOException
	 */
	public void addCmpbGuidelineServiceLaneAll(PriCmpbGlineBseVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CMPBGuidelineDBDAOPriCmpbGlineSvcLaneVOAllCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * LOAD EXCEL 시 SVC LANE CHECK.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO  
	 * @return RsltCdListVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public RsltCdListVO searchCheckSvcLaneExists(RsltCdListVO rsltCdListVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltCdListVO.getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CMPBGuidelineDBDAOLoadExcelCheckSvcLaneRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	/**
	 * LOAD EXCEL 시 cmdt cd CHECK.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO  
	 * @return RsltCdListVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public RsltCdListVO searchCheckCommodityCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltCdListVO.getColumnValues();
			param.putAll(mapVO);
			
			if (rsltCdListVO.getCd().length() == 4) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CMPBGuidelineDBDAOLoadExcelCheckRepCmdtRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 5) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CMPBGuidelineDBDAOLoadExcelCheckGrpCmdtRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 6) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CMPBGuidelineDBDAOLoadExcelCheckCmdtRSQL(), param, null);
			} else {
				return null;
			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	/**
	 * LOAD EXCEL 시 loc cd CHECK.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO  
	 * @return RsltCdListVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public RsltCdListVO searchCheckLocationCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltCdListVO.getColumnValues();
			param.putAll(mapVO);
			
			if (rsltCdListVO.getCd().length() == 4) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CMPBGuidelineDBDAOLoadExcelCheckGrpLocRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 5) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CMPBGuidelineDBDAOLoadExcelCheckLocRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 3) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CMPBGuidelineDBDAOLoadExcelCheckRegionRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 2) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CMPBGuidelineDBDAOLoadExcelCheckCountryRSQL(), param, null);
			} else {
				return null;
			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	

	
	/**
	 * CMPBGuidelineDBDAO의 SVC LANE 정보를 조회한다.<br>
	 * 
	 * @param RsltCmpbGuidelineVO rsltCmpbGuidelineVO
	 * @return List<RsltRepCmdtAndCmdtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltRepCmdtAndCmdtVO> searchCommodityList(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRepCmdtAndCmdtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(rsltCmpbGuidelineVO != null){
				Map<String, String> mapVO = rsltCmpbGuidelineVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAORsltRepCmdtAndCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRepCmdtAndCmdtVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	
	/**
	 * CMPBGuidelineDBDAO의 SVC LANE 정보를 조회한다.<br>
	 * 
	 * @param RsltCmpbGuidelineVO rsltCmpbGuidelineVO
	 * @return List<RsltOriDestLocationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltOriDestLocationVO> searchLocationList(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltOriDestLocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltCmpbGuidelineVO != null){
				Map<String, String> mapVO = rsltCmpbGuidelineVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMPBGuidelineDBDAORsltOriDestLocationVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltOriDestLocationVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
}