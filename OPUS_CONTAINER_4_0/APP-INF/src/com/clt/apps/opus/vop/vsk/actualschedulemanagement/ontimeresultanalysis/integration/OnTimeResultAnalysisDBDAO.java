/*=========================================================
*Copyright(c) 2009 CyberLogitec  
*@FileName : OnTimeResultAnalysisDBDAO.java
*@FileTitle : SKD for Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.07.13 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.basic.OnTimeResultAnalysisBCImpl;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultChangeStatusVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultDelayStatusVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultOnTimeRatioVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultRemarkVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultSkipStatusVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.SkdResultVO;
import com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdRsltVO;


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
		//velocity parameter
		//Map<String, Object> velParam = null;

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
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(onTimeRsltAnalVO != null){
				Map<String, String> mapVO = onTimeRsltAnalVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OnTimeResultAnalysisDBDAORemoveRsltByVvdDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
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
	
}