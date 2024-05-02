/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtDAO.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.27
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.30 서창열
* 1.0 Creation
* 
* History
* 2011.06.27 진마리아 CHM-201111838-01 소스품질 결함수정 - 객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.integration.CommonDBDAOGetCodeSelectRSQL;
//import com.hanjin.apps.alps.esm.mas.lanesimulation.integration.LaneSimulationDBDAOCreateCoaSimRqst1CSQL;
import com.hanjin.apps.alps.esm.mas.lanesimulation.integration.LaneSimulationDBDAOMultiSimPortListCSQL;
import com.hanjin.apps.alps.esm.mas.lanesimulation.integration.LaneSimulationDBDAOMultiSimPortListDSQL;
import com.hanjin.apps.alps.esm.mas.lanesimulation.integration.LaneSimulationDBDAOSearchSimProCountRSQL;
import com.hanjin.apps.alps.esm.mas.lanesimulation.integration.LaneSimulationDBDAOSelSimulationNoRSQL;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.basic.ProformaScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.BunkerCostVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.CoaSimRsltVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.HireBaseVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdBerthWdoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpSumVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdRequestVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PortExpenseVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.SlotPriceGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.SlotPriceVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdHisVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MasSimTmlInfoVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskPfCallPortVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;
import com.hanjin.syscommon.common.table.VskSltPrcDtlVO;
import com.hanjin.syscommon.common.table.VskSltPrcPortDtlVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

 
/**
 * NIS2010 ProformaScheduleMgtDAO <br>
 * - NIS2010-SchedulePlanningOperation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO CHANG YUL
 * @see ProformaScheduleMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ProformaScheduleMgtDBDAO extends DBDAOSupport {

	/**
	 * 등록된 Proforma SKD의 PF_TYPE_CD 정보를 조회한다..<br>
	 * 
	 * @param PfSkdTypeHelpVO pfSkdTypeHelpVO
	 * @return List<PfSkdTypeHelpVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PfSkdTypeHelpVO> searchPfTpHelp(PfSkdTypeHelpVO pfSkdTypeHelpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PfSkdTypeHelpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pfSkdTypeHelpVO != null){
				Map<String, String> mapVO = pfSkdTypeHelpVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOPfSkdTypeHelpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PfSkdTypeHelpVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		
	 /**
	 * 등록된 Proforma SKD 정보를 조회한다.
	 * 
	 * @param PfSkdVO pfSkdVO
	 * @return List<PfSkdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PfSkdVO> searchPfSkd(PfSkdVO pfSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PfSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pfSkdVO != null){
				Map<String, String> mapVO = pfSkdVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOPfSkdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PfSkdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * 등록된 Proforma SKD 정보를 조회한다.
	 * 
	 * @param VskPfSkdHisVO vskPfSkdHisVO
	 * @return List<VskPfSkdHisVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPfSkdHisVO> searchPfSkdHis(VskPfSkdHisVO vskPfSkdHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPfSkdHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskPfSkdHisVO != null){
				Map<String, String> mapVO = vskPfSkdHisVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOsearchPfSkdHisRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPfSkdHisVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * BERTH WINDOW 정보를 조회한다.
	 * 
	 * @param VskPfSkdDtlVO vskPfSkdDtlVO
	 * @return List<PfSkdBerthWdoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PfSkdBerthWdoVO> searchPfSkdBerthWdo(VskPfSkdDtlVO vskPfSkdDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PfSkdBerthWdoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskPfSkdDtlVO != null){
				Map<String, String> mapVO = vskPfSkdDtlVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchPfSkdBerthWdoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PfSkdBerthWdoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * P/F SKD Settlement 정보를 조회한다.
	 * 
	 * @param PfSkdRequestVO pfSkdRequestVO
	 * @return List<PfSkdRequestVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PfSkdRequestVO> searchRqstSimScnr(PfSkdRequestVO pfSkdRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PfSkdRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pfSkdRequestVO != null){
				Map<String, String> mapVO = pfSkdRequestVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchRqstSimScnrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PfSkdRequestVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * checkLaneDirection Lane의 Direction을 체크한다 
	 * 
	 * @param String vslSlanCd
	 * @param String dirCd
	 * @param int dirSeq
	 * @return String
	 * @exception DAOException
	 */
	public String checkLaneDirection(String vslSlanCd, String dirCd, int dirSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnFlag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(VSKGeneralUtil.isNotNull(vslSlanCd) && VSKGeneralUtil.isNotNull(dirCd)){
				param.put("vsl_slan_cd", vslSlanCd);
				param.put("vsl_slan_dir_cd", dirCd);
				param.put("vsl_slan_dir_seq", dirSeq);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOCheckLaneDirectionRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnFlag = dbRowset.getString("FLAG");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnFlag;
	}

	 /**
	 * VSK_PF_SKD_DTL 삭제한다  
	 * 
	 * @param String vslLaneCd
	 * @param String pfTypeCd
	 * @exception DAOException
	 */
	 public void removeVskPfSkdDtl(String vslLaneCd,String pfTypeCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			if(VSKGeneralUtil.isNotNull(vslLaneCd) && VSKGeneralUtil.isNotNull(pfTypeCd)){
				param.put("vsl_slan_cd", vslLaneCd);
				param.put("pf_svc_tp_cd", pfTypeCd);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAORemoveVskPfSkdDtlDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10037").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	 
	 /**
	 * VSK_PF_SKD 단건의 데이터를 생성한다.<br>
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @exception DAOException
	 */
	public void addVskPfSkd(VskPfSkdVO vskPfSkdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(vskPfSkdVO != null){
				Map<String, String> mapVO = vskPfSkdVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOAddVskPfSkdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}
		
	/**
	 * VSK_PF_SKD_DTL 다건의 데이터를 생성한다.<br>
	 * 
	 * @param VskPfSkdDtlVO vskPfSkdDtlVO
	 * @exception DAOException
	 */
	public void addVskPfSkdDtl(VskPfSkdDtlVO vskPfSkdDtlVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(vskPfSkdDtlVO != null){
				Map<String, String> mapVO = vskPfSkdDtlVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOAddVskPfSkdDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}	
	}
	
	/**
	 * VSK_PF_SKD_HIS 단건의 데이터를 생성한다.<br>
	 * 
	 * @param VskPfSkdHisVO vskPfSkdHisVO
	 * @exception DAOException
	 */
	public void addVskPfSkdHis(VskPfSkdHisVO vskPfSkdHisVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(vskPfSkdHisVO != null){
				Map<String, String> mapVO = vskPfSkdHisVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOAddVskPfSkdHisCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * VSK_PF_CALL_PORT 삭제한다  
	 * 
	 * @param VskPfCallPortVO vskPfCallPortVO
	 * @exception DAOException
	 */
	 public void removeVskPfCallPort(VskPfCallPortVO vskPfCallPortVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			if(vskPfCallPortVO != null){
				Map<String, String> mapVO = vskPfCallPortVO .getColumnValues();

				param.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAORemoveVskPfCallPortDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10037").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	 
	 /**
	 * VSK_PF_CALL_PORT 등록한다  
	 * 
	 * @param VskPfCallPortVO vskPfCallPortVO
	 * @exception DAOException
	 */
	 public void addVskPfCallPort(VskPfCallPortVO vskPfCallPortVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			if(vskPfCallPortVO != null){
				Map<String, String> mapVO = vskPfCallPortVO .getColumnValues();

				param.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOAddVskPfCallPortCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	 
	 /**
	 * P/F SKD Creation의 Auto Simulation의 정보를 조회한다.
	 * 
	 * @param PfSkdVO pfSkdVO
	 * @return List<VskPfSkdDtlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPfSkdDtlVO> searchPortPairInfo(PfSkdVO pfSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPfSkdDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pfSkdVO != null){
				Map<String, String> mapVO = pfSkdVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchPortPairInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPfSkdDtlVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 /**
		 * VSK_PF_SKD 단건의 데이터를 수정한다.<br>
		 * 
		 * @param VskPfSkdVO vskPfSkdVO
		 * @exception DAOException
		 */
	 public void modifyVskPfSkd(VskPfSkdVO vskPfSkdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			Map<String, String> mapVO = vskPfSkdVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOModifyVskPfSkdUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10038").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	 
	 /**
	 * 입력 받은 Service Lane Code로 생성된 Standard Proforma Schedule이 몇 개가 있는지 확인한다.
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchPfStandardCount(VskPfSkdVO vskPfSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int resultCnt = 0; 
		
		try{
			if(vskPfSkdVO != null){
				Map<String, String> mapVO = vskPfSkdVO .getColumnValues();

				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchPfStandardCountRSQL(), param, null);
			if(dbRowset != null){				
				if(dbRowset.next()){
					resultCnt = dbRowset.getInt("CNT");
				}
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}
	
	/**
	 * VSK_PF_SKD 테이블에 변경된 P/F Schedule 정보를 변경한다.<br>
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @param int pfCount
	 * @exception DAOException
	 */
	 public void modifyVskPfSkd(VskPfSkdVO vskPfSkdVO, int pfCount) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vskPfSkdVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.put("pfCount", pfCount);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOModifyPfSkdStandardInfoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10038").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	 
	 /**
	 * 입력받은 Service Lane, Proforma Type Code로 기생성되여 있는지 확인한다.
	 * 
	 * @param String vslSlanCd
	 * @param String pfSvcTpCd
	 * @return int
	 * @exception DAOException
	 */
	public int checkPfSkd(String vslSlanCd, String pfSvcTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int resultCnt = 0; 
		
		try{
			if(VSKGeneralUtil.isNotNull(vslSlanCd) && VSKGeneralUtil.isNotNull(pfSvcTpCd)){
				param.put("vsl_slan_cd", vslSlanCd);
				param.put("pf_svc_tp_cd", pfSvcTpCd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOCheckPfSkdRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					resultCnt = dbRowset.getInt("CNT");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}
	
	/**
	 * Slot Price의 기존 등록된 정보를 조회한다.
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return List<SlotPriceVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public int searchOldBunkerPrice(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		int resultCnt = 0; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchOldBunkerPriceRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					resultCnt = dbRowset.getInt("BNK_PRC");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}	
	 
	 /**
	 * VSK_SLT_PRC_PORT_DTL 테이블에서 Port Expense 정보를 조회한다.
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return List<PortExpenseVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PortExpenseVO> searchOldPortExpence(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortExpenseVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchOldPortExpenceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortExpenseVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * VSK_SLT_PRC_PORT_DTL 테이블에서 Port Expense 정보를 조회한다.
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return List<PortExpenseVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BunkerCostVO> searchOldBunkerCost(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BunkerCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchOldBunkerCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BunkerCostVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * VSK_SLT_PRC_PORT_DTL 테이블에서 Hire Base 정보를 조회한다.
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return List<HireBaseVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<HireBaseVO> searchOldHireBase(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HireBaseVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchOldHireBaseRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HireBaseVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
	 /**
	 * VSK_SLT_PRC_PORT_DTL 테이블에서 Hire Base 정보를 조회한다.
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return List<SlotPriceVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SlotPriceVO> searchOldSlotPrice(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SlotPriceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchOldSlotPriceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SlotPriceVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
	 /**
	 * 입력받은 분기[기간] 동안에 운항했던 선박에 투입 척수을 조회하고, Vessel Class를 최대 3개를 조회한다.
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return List<String>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<String> searchVslClssByVskd(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchVslClssByVskdRSQL(), param, velParam);
			while (dbRowset.next()) {
				list.add(dbRowset.getString("VSL_CLASS"));
			}
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, String .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
	 /**
	 * Slot Price의 신규 정보를 조회한다.
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return List<PortExpenseVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PortExpenseVO> searchNewPortExpence(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortExpenseVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchNewPortExpenceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortExpenseVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * VSK_BNK_PRC,VSK_PORT_BNK_RFUEL_RTO 테이블에서 각 Port에 3주치 평균 톤당 단가 정보를 조회한다. 
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return String
	 * @exception DAOException
	 */
	public int searchBunkerPriceDaliy(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		int bnkPrc = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchBunkerPriceDaliyRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					bnkPrc = Integer.parseInt(dbRowset.getString("BNK_PRC"));
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bnkPrc;
	} 
	 
	 /**
	 * 사선일 경우, VSK_DLY_HIR, 용선일 경우에는 FMS 모쥴에서 Class별 Hire Base 정보를 조회한다.
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return List<HireBaseVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<HireBaseVO> searchNewHireBase(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HireBaseVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchNewHireBaseRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HireBaseVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * VSK_SLT_PRC_PORT_DTL 삭제한다  
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @exception DAOException
	 */
	 public void removeVskSltPrcPortDtl(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
				}
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAORemoveVskSltPrcPortDtlDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10037").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	 
	 /**
	 * VSK_SLT_PRC_DTL 삭제한다  
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @exception DAOException
	 */
	 public void removeVskSltPrcDtl(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
				}
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAORemoveVskSltPrcDtlDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10037").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}	 
	 
	 /**
	 * VSK_SLT_PRC 삭제한다  
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @exception DAOException
	 */
	 public void removeVskSltPrc(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
				}
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAORemoveVskSltPrcDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10037").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}	 
	 
	 /**
	 * VSK_SLT_PRC 테이블에 신규 입력한다.<br>
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @exception DAOException
	 */
	 public void addVskSltPrc(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				if(slotPriceVO != null){
					Map<String, String> mapVO = slotPriceVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOAddVskSltPrcCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}	
	 
	 /**
	 * VSK_SLT_PRC_DTL 테이블에 신규 입력한다.<br>
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @exception DAOException
	 */
	 public void addVskSltPrcDtl(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(slotPriceGRPVO != null){
				VskSltPrcDtlVO vskSltPrcDtlParamVO = slotPriceGRPVO.getVskSltPrcDtlVO();
				
				if(vskSltPrcDtlParamVO != null){
					Map<String, String> mapVO = vskSltPrcDtlParamVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOAddVskSltPrcDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	 
	 /**
	 * VSK_SLT_PRC_PORT_DTL 테이블에 신규 입력한다.<br>
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @exception DAOException
	 */
	 public void addVskSltPrcPortDtl(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(slotPriceGRPVO != null){
				VskSltPrcPortDtlVO vskSltPrcPortDtlVO = slotPriceGRPVO.getVskSltPrcPortDtlVO();
				
				if(vskSltPrcPortDtlVO != null){
					Map<String, String> mapVO = vskSltPrcPortDtlVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOAddVskSltPrcPortDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	 
	 /**
	 * EOTP Creation의 Summary와 첫번째 port와 두번째 port사이의 EOTP 상세 정보를 조회한다
	 * 
	 * @param PfSkdEotpSumVO pfSkdEotpSummaryVO
	 * @return List<PfSkdEotpSumVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PfSkdEotpSumVO> searchPfSkdEotpSum(PfSkdEotpSumVO pfSkdEotpSummaryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PfSkdEotpSumVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pfSkdEotpSummaryVO != null){
				Map<String, String> mapVO = pfSkdEotpSummaryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchPfSkdEotpSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PfSkdEotpSumVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
	 /**
	 * EOTP Creation의 Summary와 첫번째 port와 두번째 port사이의 EOTP 상세 정보를 조회한다
	 * 
	 * @param PfSkdEotpSumVO pfSkdEotpSummaryVO
	 * @return List<PfSkdEotpDtlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PfSkdEotpDtlVO> searchPfSkdEotpDtl(PfSkdEotpSumVO pfSkdEotpSummaryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PfSkdEotpDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pfSkdEotpSummaryVO != null){
				Map<String, String> mapVO = pfSkdEotpSummaryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchPfSkdEotpDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PfSkdEotpDtlVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
	 /**
	 * FROM, TO PORT간에 DISTANCE, ZD(ZONE DESCRIPTION), CRANE 수, 터미널 생산성 정보를 조회한다.
	 * 
	 * @param PfSkdVO pfSkdVO
	 * @return List<PfSkdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PfSkdVO> searchPortInfo(PfSkdVO pfSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PfSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(pfSkdVO != null){				
				param.put("fm_port_cd", pfSkdVO.getPortCd());
				param.put("to_port_cd", pfSkdVO.getPodLocCd());
				param.put("chg_port_cd", pfSkdVO.getChgLocCd());
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchPortInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PfSkdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * 입력받은 Service Lane, Proforma Type Code을 사용하고 있는 Vessel Schedule이 있는지 확인
	 * 
	 * @param String vslSlanCd
	 * @param String pfSkdTpCd
	 * @return int
	 * @exception DAOException
	 */
	public int checkVslSkdByPfSkd(String vslSlanCd, String pfSkdTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int resultCnt = 0; 
		
		try{
			if(VSKGeneralUtil.isNotNull(vslSlanCd) && VSKGeneralUtil.isNotNull(pfSkdTpCd)){
				param.put("vsl_slan_cd", vslSlanCd);
				param.put("pf_skd_tp_cd", pfSkdTpCd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOCheckVslSkdByPfSkdRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					resultCnt = Integer.parseInt(dbRowset.getString("CNT"));	
				}
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}

	 /**
	 * VSK_PF_SKD 테이블 중에 Vessel Class 1 ~ 3 정보를 제외한 내용을 변경한다.<br>
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @exception DAOException
	 */
	 public void modifyVskPfSkdMstInfo(VskPfSkdVO vskPfSkdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			if(vskPfSkdVO != null){
				Map<String, String> mapVO = vskPfSkdVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOModifyVskPfSkdMstInfoUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to UPDATE SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10038").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}	
	 
	 /**
	 * VSK_PF_SKD 테이블을 삭제한다.<br>
	 * 
	 * @param String vslSlanCd
	 * @param String pfSvcTpCd
	 * @exception DAOException
	 */
	 public void removeVskPfSkd(String vslSlanCd, String pfSvcTpCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			if(VSKGeneralUtil.isNotNull(vslSlanCd) && VSKGeneralUtil.isNotNull(pfSvcTpCd)){
				param.put("vsl_slan_cd", vslSlanCd);
				param.put("pf_svc_tp_cd", pfSvcTpCd);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAORemoveVskPfSkdDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to DELETE SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10037").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	 
	 /**
	 * 등록된 Proforma SKD 정보를 조회한다.
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @return List<VskPfSkdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPfSkdVO> searchPfSkdNewest(VskPfSkdVO vskPfSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPfSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(vskPfSkdVO != null){
				Map<String, String> mapVO = vskPfSkdVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchPfSkdNewestRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPfSkdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
	/**
	 * 입력된 MDM Yard Code가 MDM_YARD 테이블에 등록되여 있는지 확인한다.
	 * 
	 * @param String ydCd
	 * @return int
	 * @exception DAOException
	 */
	public int checkYard(String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{		
			param.put("yd_cd", ydCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOCheckYardRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					cnt = Integer.parseInt(dbRowset.getString("CNT"));
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	 
	/**
	 * 등록된 Proforma SKD 정보를 조회한다.
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneVO> searchSvcLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(mdmVslSvcLaneVO != null){
				Map<String, String> mapVO = mdmVslSvcLaneVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchSvcLaneListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
	 /**
	 * 입력 받은 PORT에 GANG WORK START TIME를 비교하여 작업 가능시간을 확인해 주고, 작업 시간을 표시해 준다.
	 * 
	 * @param VskPfSkdDtlVO VskPfSkdDtlVO
	 * @return List<VskPfSkdDtlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPfSkdDtlVO> searchVosiGangInfo(VskPfSkdDtlVO vskPfSkdDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPfSkdDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(vskPfSkdDtlVO != null){
				Map<String, String> mapVO = vskPfSkdDtlVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchVosiGangInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPfSkdDtlVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * Service Lane, Proforma Type을 사용하고 Vessel Schedule 정보를 조회 한다.
	 * 
	 * @param VskPfSkdHisVO vskPfSkdHisVO
	 * @return List<VskVslSkdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskVslSkdVO> searchVslSkdByPfSkd(VskPfSkdHisVO vskPfSkdHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskPfSkdHisVO != null){
				Map<String, String> mapVO = vskPfSkdHisVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchVslSkdByPfSkdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslSkdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * P/F Type Cd가 존재하는지 여부를 조회한다.
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkPfType(VskPfSkdVO vskPfSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		String pfTypeCdData = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(vskPfSkdVO != null){
				Map<String, String> mapVO = vskPfSkdVO .getColumnValues();

				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOCheckPfTypeRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					pfTypeCdData = dbRowset.getString("FLAG");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return pfTypeCdData;
	}
	
	/**
	 * COA쪽에서 수지분석 결과 내역을 조회한다.
	 * 
	 * @param PfSkdRequestVO pfSkdRequestVO
	 * @return List<CoaSimRsltVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoaSimRsltVO> searchCoaSimRslt(PfSkdRequestVO pfSkdRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoaSimRsltVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pfSkdRequestVO != null){
				Map<String, String> mapVO = pfSkdRequestVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchCoaSimRsltRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaSimRsltVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
	 /**
	 * PSO_VSL_CLSS_TRF 테이블에서 Port별 Port Expense 정보를 조회한다.
	 * 
	 * @param PortExpenseVO portExpenseVO
	 * @return List<PortExpenseVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PortExpenseVO> searchPortExpenceByClass(PortExpenseVO portExpenseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortExpenseVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(portExpenseVO != null){
				Map<String, String> mapVO = portExpenseVO .getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchPortExpenceByClassRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortExpenseVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 
	 /**
	 * VSK_SLT_PRC_DTL 테이블에서 Hire Base 정보를 조회한다..
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return List<HireBaseVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<HireBaseVO> searchHireBaseByDznCapa(SlotPriceGRPVO slotPriceGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HireBaseVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(slotPriceGRPVO != null){
				SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
				
				List<HireBaseVO> hireBaseVOs = slotPriceGRPVO.getHireBaseVOs();
				HireBaseVO hireBaseVO = hireBaseVOs.get(0);
				
				if(hireBaseVO != null){
					Map<String, String> mapVO = hireBaseVO .getColumnValues();
					param.putAll(mapVO);
					param.put("slt_prc_wrk_yr", slotPriceVO.getSltPrcWrkYr());
					param.put("bse_qtr_cd", slotPriceVO.getBseQtrCd());
					param.put("vsl_ownr_flg_y", hireBaseVOs.get(1).getVslOwnrFlg());
					param.put("vsl_ownr_flg_n", hireBaseVOs.get(2).getVslOwnrFlg());
					
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSearchHireBaseByDznCapaRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HireBaseVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
    /**
     * VSK에서 넘겨준 이 후 데이터가 생성된것이 있는지 체크
     * - 기준을 COA_SIM_VOL_PRJ 테이블에 정보가 생성되었는지 확인
     * 
     * @param vo SearchSimLaneListConditionVO
	 * @return int
	 * @throws DAOException
     */
    public int searchSimProCount(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("sim_no", vo.getFSimNo());
			param.put("sim_dt", vo.getFSimDt());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimProCountRSQL(), param,null);
			if(dbRowset != null && dbRowset.next()) {
				rtnCnt = dbRowset.getInt("cnt");
			}
			return rtnCnt;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    	
    }
    
    /**
     * VSK에서 넘어오 데이터를 가지고 정보를 생성한다.
     * 
     * @param Map<String, Object> param
	   * @param List<CoaSimTmlInfoVO> list
	   * @param String ind
	   * @throws DAOException
     */
    public void createCoaSimRqst(Map<String, Object> param, List<MasSimTmlInfoVO> list, String ind) throws DAOException{
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		//int cnt4[] = null;
		Map<String, Object> valParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(ind.equals("U")){
				//COA_SIM_TML_INFO
				valParam.put("skd_dir_cd", "");
				valParam.put("tml_cd", "");
				valParam.put("vsl_dbl_call_seq", "");
				
				// 삭제 
				sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOMultiSimPortListDSQL(), param,valParam);
				// 입력
//				cnt4 = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListCSQL(), list,null);
//				for(int i = 0; i < cnt4.length; i++){
//					if(cnt4[i]== Statement.EXECUTE_FAILED){
//						throw new DAOException("Fail to insert COA_SIM_TML_INFO No"+ i + " SQL");
//					}
//				}
				Map<String, Object> paramTemp = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParamTemp = new HashMap<String, Object>();
				int result = 0;
				//COA_SIM_TML_INFO
				for(int j=0; j<list.size(); j++){
					Map<String, String> mapVO = list.get(j).getColumnValues();//vvdVO .getColumnValues();
//					log.debug("-----1-----ddddddddddd-------["+ list.get(j).getColumnValues()+"]-------");

					paramTemp.putAll(mapVO);
					velParamTemp.putAll(mapVO);
					//cnt4 = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListCSQL(), list,null);
					paramTemp.put("cre_usr_id", list.get(j).getCreUsrId());
					paramTemp.put("upd_usr_id", list.get(j).getUpdUsrId());
					result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOMultiSimPortListCSQL(), paramTemp,velParamTemp);
					
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert SQL");
//					for(int i = 0; i < cnt4.length; i++){
//						if(cnt4[i]== Statement.EXECUTE_FAILED){
//							throw new DAOException("Fail to insert COA_SIM_TML_INFO No"+ i + " SQL");
//						}
//					}
				}
				
			}else {
				if(list.size() > 0){
					// COA_SIM_INFO
					valParam.put("param", "VSK_SIM_INFO");
					for(int j=0; j<list.size(); j++){
						param.put("svc_dur_dys", list.get(j).getSvcDurDys());
						param.put("pf_skd_rmk", list.get(j).getPfSkdRmk());
						param.put("brth_itval_dys", list.get(j).getBrthItvalDys());
					}
					cnt1 = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOCreateCoaSimRqst1CSQL(), param,valParam);
					if(cnt1== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert COA_SIM_INFO SQL");
					}
//					// COA_SIM_SVC_LANE
//					valParam.put("param", "COA_SIM_SVC_LANE");
//					cnt2 = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateCoaSimRqst1CSQL(), param,valParam);
//					if(cnt2== Statement.EXECUTE_FAILED){
//						throw new DAOException("Fail to insert COA_SIM_SVC_LANE SQL");
//					}
//					// COA_SIM_VSL_SET_INFO
//					valParam.put("param", "COA_SIM_VSL_SET_INFO");
//					cnt3 = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateCoaSimRqst1CSQL(), param,valParam);
//					if(cnt3== Statement.EXECUTE_FAILED){
//						throw new DAOException("Fail to insert COA_SIM_VSL_SET_INFO SQL");
//					}

					Map<String, Object> paramTemp = new HashMap<String, Object>();
					//velocity parameter
					Map<String, Object> velParamTemp = new HashMap<String, Object>();
					int result = 0;
					
					//COA_SIM_TML_INFO
					for(int j=0; j<list.size(); j++){
						Map<String, String> mapVO = list.get(j).getColumnValues();//vvdVO .getColumnValues();
//						log.debug("-----2-----ddddddddddd-------["+ list.get(j).getColumnValues()+"]-------");

						paramTemp.putAll(mapVO);
						velParamTemp.putAll(mapVO);
						//cnt4 = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListCSQL(), list,null);
						paramTemp.put("cre_usr_id", list.get(j).getCreUsrId());
						paramTemp.put("upd_usr_id", list.get(j).getUpdUsrId());
						paramTemp.put("port_cd", list.get(j).getPortCd());
						result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOMultiSimPortListCSQL(), paramTemp,velParamTemp);
						
						if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to Insert SQL");
//						for(int i = 0; i < cnt4.length; i++){
//							if(cnt4[i]== Statement.EXECUTE_FAILED){
//								throw new DAOException("Fail to insert COA_SIM_TML_INFO No"+ i + " SQL");
//							}
//						}
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /**
     * VSK_SIM_INFO의 목록을 가져온다.<br>
     * 
     * @param  ori_sim_dt
     * @param  sim_no 
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchSimulationNo(String ori_sim_dt,String sim_no) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("sim_dt",ori_sim_dt);
			param.put("sim_no",sim_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSelSimulationNoRSQL(), param, null);
			return dbRowset;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
	/**
	 * 날짜의 Max Simulation No를 조회한다. <br>
	 * VSK_SIM_INFO
	 * 
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchMaxSimNo() throws DAOException {
		String rtnResult = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchMaxSimNo");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOSelMaxSimNoRSQL(), null, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					rtnResult = dbRowSet.getString("sim_no");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return rtnResult;		
	}
	 
}

