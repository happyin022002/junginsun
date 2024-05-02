/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAO.java
*@FileTitle : SKD for Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.14
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2009.07.13 정명훈
* 1.0 Creation
* 
* History
* 2011.06.27 진마리아 CHM-201111838-01 소스품질 결함수정 - 객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
* 2012.08.14 진마리아 CHM-201219281-01 타선사 SKD에 대해 PAPAC, EGSUZ 입력필수항목 제외처리
* 2013-04.22 정상기   [CHM-201324042] [VOP-VSK] 정시율 - Report data Creation VVD 첫포트 대상에 추가 
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.basic.OnTimeResultAnalysisBCImpl;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortInfoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortListVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwSkdSearchVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwTrdInfoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultChangeStatusVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultDelayStatusVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultOnTimeRatioVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultRemarkVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultSkipStatusVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.SkdResultVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdRsltVO;


/**
 * ALPS OnTimeResultAnalysisDBDAO <br>
 * - ALPS-ActualScheduleManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeong Myounghun
 * @see OnTimeResultAnalysisBCImpl 참조
 * @since J2EE 1.6
 */
public class OnTimeResultAnalysisDBDAO extends DBDAOSupport {

	/**
	 * Port Schedule에서 정시성 대상 VVD를 조회합니다.<br>
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalVO
	 * @return List<VskVslPortSkdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskVslPortSkdVO> searchRsltConvVslSkd(OnTimeRsltAnalGRPVO onTimeRsltAnalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(onTimeRsltAnalVO != null){
				Map<String, String> mapVO = onTimeRsltAnalVO.getColumnValues();
				
//				mapVO.put("vsl_cd", mapVO.get("vsl_cd"));
//				mapVO.put("skd_voy_no", mapVO.get("voy_no"));
//				mapVO.put("skd_dir_cd", mapVO.get("dir_cd"));
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAOSearchRsltConvVslSkdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO.class);
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
	 * SKD Status (Delay Status - Header List)를 조회합니다.<br>
	 * 
	 * @param String intgCdId
	 * @return String
	 * @exception DAOException
	 */
	public String searchDelayReason(String intgCdId) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(VSKGeneralUtil.isNotNull(intgCdId)){
				param.put("intg_cd_id", intgCdId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAOSearchDelayReasonRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnString = dbRowset.getString("HEADER");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnString;
	}
	 
	 /**
	 * SKD Status (Delay Status)를 조회합니다.<br>
	 * 
	 * @param ResultChangeStatusVO resultChangeStatusVO
	 * @return List<ResultDelayStatusVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ResultDelayStatusVO> searchRsltDlayStsList (ResultChangeStatusVO resultChangeStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ResultDelayStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(resultChangeStatusVO != null){
				Map<String, String> mapVO = resultChangeStatusVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAOSearchRsltDlayStsListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ResultDelayStatusVO.class);
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
	  * Target VVD & Remark(s)를 조회합니다.<br>
	  * 
	  * @param ResultRemarkVO resultRemarkVO
	  * @return List<ResultRemarkVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	public List<ResultRemarkVO> searchRsltRmkDtlList (ResultRemarkVO resultRemarkVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ResultRemarkVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(resultRemarkVO != null){
				Map<String, String> mapVO = resultRemarkVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String condition = resultRemarkVO.getCondition();
				if (VSKGeneralUtil.isNotNull(condition)) {
					List<String> conditionList = new ArrayList<String>();
					String[] conditionArr = condition.split("\\,");
					if(conditionArr != null && conditionArr.length > 0){
						for(int i=0; i<conditionArr.length; i++){
							conditionList.add(conditionArr[i]);
						}
						velParam.put("condition", conditionList);
					}
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAOSearchRsltRmkDtlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ResultRemarkVO.class);
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
	 * SKD Status (Skip Status)를 조회합니다.<br>
	 * 
	 * @param ResultSkipStatusVO resultSkipStatusVO
	 * @return List<ResultSkipStatusVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ResultSkipStatusVO> searchRsltSkipStsList(ResultSkipStatusVO resultSkipStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ResultSkipStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(resultSkipStatusVO != null){
				Map<String, String> mapVO = resultSkipStatusVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAOSearchRsltSkipStsListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ResultSkipStatusVO.class);
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
	 * SKD Status (Skip Change Status)를 조회합니다.<br>
	 * 
	 * @param ResultChangeStatusVO resultChangeStatusVO
	 * @return List<ResultChangeStatusVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ResultChangeStatusVO> searchRsltCngStsList(ResultChangeStatusVO resultChangeStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ResultChangeStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(resultChangeStatusVO != null){
				Map<String, String> mapVO = resultChangeStatusVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAOSearchRsltCngStsListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ResultChangeStatusVO.class);
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
	 * 스케쥴 지연 사유를 조회합니다.
	 * 
	 * @param ResultOnTimeRatioVO resultOnTimeRatioVO
	 * @return List<ResultOnTimeRatioVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ResultOnTimeRatioVO> searchRsltOnTimeRtoList (ResultOnTimeRatioVO resultOnTimeRatioVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ResultOnTimeRatioVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(resultOnTimeRatioVO != null){
				Map<String, String> mapVO = resultOnTimeRatioVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAOSearchRsltOnTimeRtoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ResultOnTimeRatioVO.class);
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
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 조회합니다.
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalVO
	 * @return OnTimeRsltAnalVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public OnTimeRsltAnalGRPVO searchRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalVO) throws DAOException {
		DBRowSet dbRowset = null;
		OnTimeRsltAnalGRPVO result = new OnTimeRsltAnalGRPVO();
		List<VskVslSkdRsltVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(onTimeRsltAnalVO != null){
				Map<String, String> mapVO = onTimeRsltAnalVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAOSearchRsltByVvdRSQL(), param, velParam);
			
			if(dbRowset.next()){
				result.setVslSlanCd(dbRowset.getString("vsl_slan_cd"));
				dbRowset.beforeFirst();
			}
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslSkdRsltVO.class);
			result.setVskVslSkdRsltVOs(list);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE을 이용하여 지연 정보를 조회합니다.
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalVO
	 * @return OnTimeRsltAnalVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public OnTimeRsltAnalGRPVO searchRsltCstSkdtTarget(OnTimeRsltAnalGRPVO onTimeRsltAnalVO) throws DAOException {
		DBRowSet dbRowset = null;
		OnTimeRsltAnalGRPVO result = new OnTimeRsltAnalGRPVO();
		List<SkdResultVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(onTimeRsltAnalVO != null){
				Map<String, String> mapVO = onTimeRsltAnalVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				List<String> argList = new ArrayList<String>();
				String[] array = onTimeRsltAnalVO.getClptSeq();
				
				if(array!=null && array.length>0){
					for(int i=0; i<array.length; i++){
						argList.add(array[i]);
					}
					//param.put("clpt_seq", argList);
					velParam.put("clpt_seq", argList);
				}
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAOSearchRsltCstSkdtTargetRSQL(), param, velParam);
			
			if(dbRowset.next()){
				result.setVslSlanCd(dbRowset.getString("vsl_slan_cd"));
				
				//log.info("\n\n ::jskjskjsk::       bfr_pf_etd_dt ["+dbRowset.getString("bfr_pf_etd_dt")+"]\n");
				//log.info("\n\n ::jskjskjsk::       bfr_act_dep_dt ["+dbRowset.getString("bfr_act_dep_dt")+"]\n");

				dbRowset.beforeFirst();
			}
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SkdResultVO.class);
			result.setSkdResultVOs(list);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 삭제합니다. 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalVO
	 * @throws EventException
	 */
	public void removeRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalVO) throws DAOException {
		//query parameter
		//Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			List<VskVslSkdRsltVO> vskVslSkdRsltVOs = onTimeRsltAnalVO.getVskVslSkdRsltVOs(); 
			
			for(int i=0; i<vskVslSkdRsltVOs.size(); i++){
				vskVslSkdRsltVOs.get(i).setCreUsrId(onTimeRsltAnalVO.getCreUsrId());
				vskVslSkdRsltVOs.get(i).setUpdUsrId(onTimeRsltAnalVO.getUpdUsrId());
			}
			
			if(vskVslSkdRsltVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OnTimeResultAnalysisDBDAORemoveRsltByVvdDSQL(), vskVslSkdRsltVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			/*
			if(onTimeRsltAnalVO != null){
				Map<String, String> mapVO = onTimeRsltAnalVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OnTimeResultAnalysisDBDAORemoveRsltByVvdDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
			*/
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 저장합니다. 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalVO
	 * @throws EventException
	 */
	public void manageRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			List<VskVslSkdRsltVO> vskVslSkdRsltVOs = onTimeRsltAnalVO.getVskVslSkdRsltVOs();
			
			for(int i=0; i<vskVslSkdRsltVOs.size(); i++){
				vskVslSkdRsltVOs.get(i).setCreUsrId(onTimeRsltAnalVO.getCreUsrId());
				vskVslSkdRsltVOs.get(i).setUpdUsrId(onTimeRsltAnalVO.getUpdUsrId());
			}
			
			if(vskVslSkdRsltVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OnTimeResultAnalysisDBDAOAddRsltVslSkdCSQL(), vskVslSkdRsltVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 저장합니다. 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalVO
	 * @throws EventException
	 */
	public void modifyRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			List<VskVslSkdRsltVO> vskVslSkdRsltVOs = onTimeRsltAnalVO.getVskVslSkdRsltVOs();
			
			for(int i=0; i<vskVslSkdRsltVOs.size(); i++){
				vskVslSkdRsltVOs.get(i).setCreUsrId(onTimeRsltAnalVO.getCreUsrId());
				vskVslSkdRsltVOs.get(i).setUpdUsrId(onTimeRsltAnalVO.getUpdUsrId());
			}
			
			if(vskVslSkdRsltVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OnTimeResultAnalysisDBDAOModifyRsltVslSkdUSQL(), vskVslSkdRsltVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VVD에 대해서 ACTUAL CARRIER 정보를 조회한다.
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchActualCarrierforVVD(OnTimeRsltAnalGRPVO onTimeRsltAnalVO) throws DAOException {
		DBRowSet dbRowset = null;
		String actCrrCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(onTimeRsltAnalVO != null){
				Map<String, String> mapVO = onTimeRsltAnalVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAOSearchActualCarrierforVVDRSQL(), param, velParam);

			if(dbRowset != null){
				if(dbRowset.next()){
					actCrrCd = dbRowset.getString("ACT_CRR_CD");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return actCrrCd;
	}
	
	/**
	 * 
	 * 입력된 VSL_CD, SKD_VOY_NO, SKD_DIR_CD의 PORT가 Drewry 관리 대상일 경우 조회해 온다<br>
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @return DrwSkdSearchVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public  List<DrwSkdSearchVO> searchDrwSkdInfo(DrwSkdSearchVO drwSkdSearchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DrwSkdSearchVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(drwSkdSearchVO != null){
				Map<String, String> mapVO = drwSkdSearchVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAODrwSkdSearchRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DrwSkdSearchVO.class);
			
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
	 * 
	 * 입력된 VSL_CD, SKD_VOY_NO, SKD_DIR_CD의 PORT가 Drewry 관리 대상일 경우 조회해 온다<br>
	 * 
	 * @return List<DrwPortListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public  List<DrwPortListVO> searchDrwPortList() throws DAOException {
		DBRowSet dbRowset = null;
		List<DrwPortListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAODrwPortListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DrwPortListVO.class);
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
	 * VVD에 대해서 VSK Drewry Report 정보를 저장합니다. 
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @throws DAOException
	 */
	public void manageDrwRptByVvd(DrwSkdSearchVO drwSkdSearchVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			List<DrwSkdSearchVO> drwSkdSaveVOs = drwSkdSearchVO.getdrwSkdSaveVOs();
			
			for(int i=0; i<drwSkdSaveVOs.size(); i++){
				drwSkdSaveVOs.get(i).setUpdUsrId(drwSkdSearchVO.getUpdUsrId());
			}
			
			if(drwSkdSaveVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OnTimeResultAnalysisDBDAOAddRsltVslSkdCSQL(), drwSkdSaveVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VVD에 대해서 VSK Drewry Report 정보를 저장합니다. 
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @throws DAOException
	 */
	public void modifyDrwRptByVvd(DrwSkdSearchVO drwSkdSearchVO) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			List<DrwSkdSearchVO> drwSkdSaveVOs = drwSkdSearchVO.getdrwSkdSaveVOs();
			
			for(int i=0; i<drwSkdSaveVOs.size(); i++){
				drwSkdSaveVOs.get(i).setUpdUsrId(drwSkdSearchVO.getUpdUsrId());
			}
			
			if(drwSkdSaveVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OnTimeResultAnalysisDBDAOModifyDrwRptVslSkdUSQL(), drwSkdSaveVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VVD에 대해서 VSK Drewry Report 정보를 삭제합니다. 
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @throws DAOException
	 */
	public void removeDrwRptByVvd(DrwSkdSearchVO drwSkdSearchVO) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			List<DrwSkdSearchVO> drwSkdSaveVOs = drwSkdSearchVO.getdrwSkdSaveVOs(); 
			
			for(int i=0; i<drwSkdSaveVOs.size(); i++){
				drwSkdSaveVOs.get(i).setUpdUsrId(drwSkdSearchVO.getUpdUsrId());
			}
			
			if(drwSkdSaveVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OnTimeResultAnalysisDBDAORemoveDrwRptByVvdDSQL(), drwSkdSaveVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 
	 * 입력된 VSL_CD, SKD_VOY_NO, SKD_DIR_CD의 PORT가 Drewry 관리 대상일 경우 조회해 온다<br>
	 * 
	 * @param DrwPortInfoVO drwPortInfoVO
	 * @return DrwPortInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public  List<DrwPortInfoVO> searchDrwPortInfo(DrwPortInfoVO drwPortInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DrwPortInfoVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(drwPortInfoVO != null){
				Map<String, String> mapVO = drwPortInfoVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAODrwPortInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DrwPortInfoVO.class);
			
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
	 * VSK Drewry Report의 Port Setup에서 Port를 추가하여  저장합니다.
	 * 
	 * @param DrwPortListVO drwPortListVO
	 * @throws DAOException
	 */
	public void manageDrwPortList(DrwPortListVO drwPortListVO) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(drwPortListVO != null){
				Map<String, String> mapVO = drwPortListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new OnTimeResultAnalysisDBDAOManageDrwPortListSetupCSQL(), param, velParam);
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Update SQL");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VSK Drewry Report의 Port Setup에서 Port를 삭제합니다.
	 * 
	 * @param DrwPortListVO drwPortListVO
	 * @throws DAOException
	 */
	public void removeDrwPortList(DrwPortListVO drwPortListVO) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(drwPortListVO != null){
				Map<String, String> mapVO = drwPortListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new OnTimeResultAnalysisDBDAORemoveDrwPortListDSQL(), param, velParam);
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Update SQL");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 
	 * Drewry Target Trade를 조회한다<br>
	 * 
	 * @return List<DrwTrdInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public  List<DrwTrdInfoVO> searchDrwTrdInfo() throws DAOException {
		DBRowSet dbRowset = null;
		List<DrwTrdInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnTimeResultAnalysisDBDAOSearchDrwTrdInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DrwTrdInfoVO.class);
			
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
	 * VSK Drewry Report의 Trade Setup에서 Trade를 추가하여  저장합니다.
	 * 
	 * @param DrwTrdInfoVO drwTrdInfoVO
	 * @throws DAOException
	 */
	public void manageDrwTrdInfo(DrwTrdInfoVO drwTrdInfoVO) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			List<DrwTrdInfoVO> drwTrdSaveVOs = drwTrdInfoVO.getdrwTrdSaveVOs();
			
			for(int i=0; i<drwTrdSaveVOs.size(); i++){
				drwTrdSaveVOs.get(i).setUpdUsrId(drwTrdInfoVO.getUpdUsrId());
			}
			
			if(drwTrdSaveVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OnTimeResultAnalysisDBDAOManageDrwTrdInfoSetupCSQL(), drwTrdSaveVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * VSK Drewry Report의 Trade Setup에서 Trade를 삭제합니다.
	 * 
	 * @param DrwTrdInfoVO drwTrdInfoVO
	 * @throws EventException
	 */
	public void removeDrwTrdInfo(DrwTrdInfoVO drwTrdInfoVO) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(drwTrdInfoVO != null){
				Map<String, String> mapVO = drwTrdInfoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new OnTimeResultAnalysisDBDAORemoveDrwTrdInfoSetupDSQL(), param, velParam);
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Update SQL");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}