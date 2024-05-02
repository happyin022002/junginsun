/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtDAO.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.27
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
* 2011.06.27 진마리아 CHM-201111838-01 소스품질 결함수정 - 객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.basic.ProformaScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;


/**
 * NIS2010 ProformaScheduleMgtDAO <br>
 * - NIS2010-SchedulePlanningOperation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Maria Chin
 * @see ProformaScheduleMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ProformaScheduleMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

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
	 * 입력된 MDM Svc Lane Code가 테이블에 등록되여 있는지 확인한다.
	 * 
	 * @param String  
	 * @return Boolean
	 * @exception DAOException
	 */
	public boolean checkExistSvcLane(String vslSlanCd) throws DAOException {
		DBRowSet dbRowset = null;
		Boolean rtnSvcLane = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{		
			param.put("vsl_slan_cd", vslSlanCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOCheckExistSvcLaneRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnSvcLane = true;
				}
			}
			if(dbRowset == null)
				rtnSvcLane = false;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnSvcLane;
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

//	/**
//	 * VSK_PF_SKD_HIS 단건의 데이터를 생성한다.<br>
//	 * 
//	 * @param VskPfSkdHisVO vskPfSkdHisVO
//	 * @exception DAOException
//	 */
//	public void addVskPfSkdHis(VskPfSkdHisVO vskPfSkdHisVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		int result = 0;
//		try {
//			if(vskPfSkdHisVO != null){
//				Map<String, String> mapVO = vskPfSkdHisVO.getColumnValues();
//				
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOAddVskPfSkdHisCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
//		}		
//	}

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

//	/**
//	 * VSK_PF_CALL_PORT 삭제한다  
//	 * 
//	 * @param VskPfCallPortVO vskPfCallPortVO
//	 * @exception DAOException
//	 */
//	 public void removeVskPfCallPort(VskPfCallPortVO vskPfCallPortVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = null;
//		
//		int result = 0;
//		try {
//			if(vskPfCallPortVO != null){
//				Map<String, String> mapVO = vskPfCallPortVO .getColumnValues();
//				param.putAll(mapVO);
//			}
//				
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAORemoveVskPfCallPortDSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to remove SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler("VSK10037").getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
//		}
//	}

//	 /**
//	 * VSK_PF_CALL_PORT 등록한다  
//	 * 
//	 * @param VskPfCallPortVO vskPfCallPortVO
//	 * @exception DAOException
//	 */
//	 public void addVskPfCallPort(VskPfCallPortVO vskPfCallPortVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = null;
//		
//		int result = 0;
//		try {
//			if(vskPfCallPortVO != null){
//				Map<String, String> mapVO = vskPfCallPortVO .getColumnValues();
//					param.putAll(mapVO);
//			}
//		
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new ProformaScheduleMgtDBDAOAddVskPfCallPortCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
//		}
//	}

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
	  * Estimate VVD 정보를 조회합니다.
	  * 
	  * @param String vslCd
	  * @return List<VvdPortLaneOtherVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VvdPortLaneOtherVO> searchEstVvdList(String vslCd) throws DAOException{
		 DBRowSet dbRowset = null;
		 List<VvdPortLaneOtherVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 if(vslCd != null){
				 param.put("vsl_cd", vslCd);
				 velParam.put("vsl_cd", vslCd);
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOEstVvdRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdPortLaneOtherVO.class);
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

