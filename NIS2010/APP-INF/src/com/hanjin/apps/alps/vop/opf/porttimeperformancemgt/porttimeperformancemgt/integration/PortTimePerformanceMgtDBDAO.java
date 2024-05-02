/*=======================================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAO.java
*@FileTitle : Port Time Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* ------------------------------------------------------------------------
* 2012.01.16 김민아 [CHM-201215697-01] Port Time Reduction관리 시스템 개발(1차)
* 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
* 2012.06.08 허철용 [CHM-201217512-01] PTRP 화면에 Dashboard 기능 추가
* 2012.07.11 문동선 [CHM-201218855-01] Base line 입력화면 추가 / Dashboard에 반영
==========================================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration.ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVOUSQL;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfCommonVariableVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.basic.PortTimePerformanceMgtBCImpl;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.GraphPerformanceListVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.GraphYtdListVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PerformanceSummaryVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortDoubleCallVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeActivityReportVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeActivityVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeKPIDetailVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimePerformanceConditionVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeVVDRemarkVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.OpfCodDvsFeeVO;


/**
 * NIS2010 PortTimePerformanceMgtDBDAO <br>
 * - NIS2010-PortTimePerformanceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see PortTimePerformanceMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class PortTimePerformanceMgtDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Port Time Performance Summary ALL을 조회합니다.<br>
	 * 
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<PerformanceSummaryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PerformanceSummaryVO> searchPortTimePerformanceSummaryList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PerformanceSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portTimePerformanceConditionVO != null){
				Map<String, String> mapVO = portTimePerformanceConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOPerformanceSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PerformanceSummaryVO .class);
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
	 * 해당 KPI에 속해 있는 최종 년도와 Version 정보를 표시한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PortTimeKPIDetailVO> searchKPILastYearVersion(PortTimeKPIDetailVO portTimeKPIDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTimeKPIDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portTimeKPIDetailVO != null){
				Map<String, String> mapVO = portTimeKPIDetailVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchKPILastYearVersionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTimeKPIDetailVO .class);
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
	 * 해당 KPI에 속해 있는 Version Sequence를 조회 한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PortTimeKPIDetailVO> searchKPIYearVersionList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTimeKPIDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portTimeKPIDetailVO != null){
				Map<String, String> mapVO = portTimeKPIDetailVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchKPIYearVersionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTimeKPIDetailVO .class);
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
	 * 해당 KPI에 속해 있는 Service Lane Code를 조회 한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PortTimeKPIDetailVO> searchKPISvcLaneCodeList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTimeKPIDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portTimeKPIDetailVO != null){
				Map<String, String> mapVO = portTimeKPIDetailVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchKPISvcLaneCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTimeKPIDetailVO .class);
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
	 * 해당 KPI에 속해 있는 RHQ Code를 조회 한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PortTimeKPIDetailVO> searchKPIRHQCodeList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTimeKPIDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portTimeKPIDetailVO != null){
				Map<String, String> mapVO = portTimeKPIDetailVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchKPIRHQCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTimeKPIDetailVO .class);
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
	 * 해당 KPI에 속해 있는 RHQ Code를 조회 한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PortTimeKPIDetailVO> searchKPIPortCodeList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTimeKPIDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portTimeKPIDetailVO != null){
				Map<String, String> mapVO = portTimeKPIDetailVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchKPIPortCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTimeKPIDetailVO .class);
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
	 * Port Time KPI List를 조회합니다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PortTimeKPIDetailVO> searchPortTimeKPIList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTimeKPIDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portTimeKPIDetailVO != null){
				Map<String, String> mapVO = portTimeKPIDetailVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchPortTimeKPIListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTimeKPIDetailVO .class);
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
	 * 입력한 년도별 KPI 중 Max Version Sequence를 채번한다.<br>
	 * 
	 * @param String kPIYear
	 * @param String tabChk
	 * @return int
	 * @exception DAOException
	 */
	public int searchPortTimeKPIMaxVersion(String kPIYear, String tabChk) throws DAOException {
		DBRowSet dbRowset = null;
		int kpiVerSeq = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("kpi_tgt_yr", kPIYear);
			velParam.put("tab_chk", tabChk);
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchPortTimeKPIMaxVersionRSQL(), param, velParam);
			if(dbRowset.next()){
				kpiVerSeq = Integer.parseInt(dbRowset.getString("KPI_VER_SEQ"));
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return kpiVerSeq;
	}
	
	/**
	 * Lane, Port Validation <br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PortTimeKPIDetailVO> checkLanePort(PortTimeKPIDetailVO portTimeKPIDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTimeKPIDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portTimeKPIDetailVO != null){
				Map<String, String> mapVO = portTimeKPIDetailVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOCheckLanePortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTimeKPIDetailVO .class);
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
	 * 해당 KPI 정보를 생성한다.<br>
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @exception DAOException
	 */
	public void addPortTimeKPIVersionList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws DAOException {
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(portTimeKPIDetailVO != null){
				Map<String, String> mapVO = portTimeKPIDetailVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				result = new SQLExecuter("OPF_HJSBAT").executeUpdate((ISQLTemplate)new PortTimePerformanceMgtDBDAOAddPortTimeKPIVersionListCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 해당 KPI 정보를 삭제한다.<br>
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @exception DAOException
	 */
	public void removePortTimeKPIList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws DAOException {
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(portTimeKPIDetailVO != null){
				Map<String, String> mapVO = portTimeKPIDetailVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				result = new SQLExecuter("OPF_HJSBAT").executeUpdate((ISQLTemplate)new PortTimePerformanceMgtDBDAORemovePortTimeKPIListDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
			}
		} catch (SQLException ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 해당 KPI 정보를 변경한다.<br>
	 * @param List<PortTimeKPIDetailVO> list
	 * @exception DAOException
	 */
	public void modifyPortTimeKPIList(List<PortTimeKPIDetailVO> list) throws DAOException {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
	
			int insCnt[] = null;
			if(list.size() > 0){
				velParam.put("tab_chk", list.get(0).getTabChk());

				insCnt = new SQLExecuter("OPF_HJSBAT").executeBatch((ISQLTemplate)new PortTimePerformanceMgtDBDAOModifyPortTimeKPIListUSQL(), list, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Operation Stoppage Code 정보를 조회한다.<br>
	 * @return List<OpfCommonVariableVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpfCommonVariableVO> searchOprStopCodeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfCommonVariableVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchOprStopCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfCommonVariableVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Port Time Activity 탭페이지의 Grid에 표시할 정보를 조회 한다.<br>
	 * @return List<PortTimeActivityVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PortTimeActivityVO> searchAcitivityByPortTimeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTimeActivityVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchAcitivityByPortTimeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTimeActivityVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * VVD Port별 Activity Time 정보을 조회한다.<br>
	 * @param PortTimeActivityVO portTimeActivityVO
	 * @return List<PortTimeActivityVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PortTimeActivityVO> searchPortTimeAcitvityList(PortTimeActivityVO portTimeActivityVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTimeActivityVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(portTimeActivityVO != null){
				Map<String, String> mapVO = portTimeActivityVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchPortTimeAcitvityListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTimeActivityVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * VVD Port별 Activity Time 정보을 생성 및 변경한다.<br>
	 * @param PortTimeActivityVO portTimeActivityVO
	 * @exception DAOException
	 */
	public void managePortTimeAcitvityList(PortTimeActivityVO portTimeActivityVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try{
			if(portTimeActivityVO != null){
				Map<String, String> mapVO = portTimeActivityVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				result = new SQLExecuter("OPF_HJSBAT").executeUpdate((ISQLTemplate)new PortTimePerforManceMgtDBDAOManagePortTimeAcitvityListCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to merge SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VVD별 Port Time Activity의 입력 현황 정보를 조회 한다.<br>
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<PortTimeActivityReportVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PortTimeActivityReportVO> searchVVDPortTimeActivitySummaryList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTimeActivityReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTimePerformanceConditionVO != null){
				Map<String, String> mapVO = portTimePerformanceConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerforManceMgtDBDAOSearchVVDPortTimeActivitySummaryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTimeActivityReportVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * VVD별 Port/D.Call 정보를 조회 한다.<br>
	 * @param OpfUtilSearchOptVO opfUtilSearchOptVO
	 * @return List<PortDoubleCallVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PortDoubleCallVO> searchPortDoubleCallList(OpfUtilSearchOptVO opfUtilSearchOptVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortDoubleCallVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(opfUtilSearchOptVO != null){
				Map<String, String> mapVO = opfUtilSearchOptVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchPortDoubleCallRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortDoubleCallVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * VVD별 Dashboard Chart Report - Performance Data<br>
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<GraphPerformanceListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GraphPerformanceListVO> searchGraphPerformanceList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GraphPerformanceListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTimePerformanceConditionVO != null){
				Map<String, String> mapVO = portTimePerformanceConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchGraphPerformanceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GraphPerformanceListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * VVD별 Dashboard Chart Report - Ydt Data<br>
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<PerformanceSummaryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GraphYtdListVO> searchGraphYtdList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GraphYtdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTimePerformanceConditionVO != null){
				Map<String, String> mapVO = portTimePerformanceConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchGraphYtdListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GraphYtdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * VVD별 Dashboard Chart Report - Baseline Data<br>
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<GraphPerformanceListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GraphPerformanceListVO> searchGraphBaselineList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GraphPerformanceListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTimePerformanceConditionVO != null){
				Map<String, String> mapVO = portTimePerformanceConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchGraphBaselineListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GraphPerformanceListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * VVD별 Remark List 정보를 조회 한다.<br>
	 * @param PortTimeVVDRemarkVO portTimeVVDRemarkVO
	 * @return List<PortTimeVVDRemarkVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PortTimeVVDRemarkVO> searchPortTimeVVDRemarkList(PortTimeVVDRemarkVO portTimeVVDRemarkVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTimeVVDRemarkVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portTimeVVDRemarkVO != null){
				Map<String, String> mapVO = portTimeVVDRemarkVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new PortTimePerformanceMgtDBDAOSearchVVDRemarkListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTimeVVDRemarkVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * VVD Remark 정보를 생성 및 변경한다.<br>
	 * @param PortTimeVVDRemarkVO portTimeVVDRemarkVO
	 * @exception DAOException
	 */
	public void addPortTimeVVDRemarkList(PortTimeVVDRemarkVO portTimeVVDRemarkVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try{
			if(portTimeVVDRemarkVO != null){
				Map<String, String> mapVO = null;
				
				mapVO = portTimeVVDRemarkVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				result = new SQLExecuter("OPF_HJSBAT").executeUpdate((ISQLTemplate)new PortTimePerformanceMgtDBDAOAddVVDRemarkListCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to merge SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VVD Remark 정보를 생성 및 변경한다.<br>
	 * @param PortTimeVVDRemarkVO portTimeVVDRemarkVO
	 * @exception DAOException
	 */
	public void modifyPortTimeVVDRemarkList(PortTimeVVDRemarkVO portTimeVVDRemarkVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try{
			if(portTimeVVDRemarkVO != null){
				Map<String, String> mapVO = null;
				
				mapVO = portTimeVVDRemarkVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				result = new SQLExecuter("OPF_HJSBAT").executeUpdate((ISQLTemplate)new PortTimePerformanceMgtDBDAOModifyVVDRemarkListUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to merge SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Exp 정보를 변경한다.<br>
	 * 
	 * @param List<PerformanceSummaryVO> updModels
	 * @throws DAOException
	 */
	public void modifyPortTimePerformanceVVDExceptList(List<PerformanceSummaryVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTimePerformanceMgtDBDAOPerformanceSummaryUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}