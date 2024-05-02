/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleMgtDBDAO.java
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.27
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2009.07.06 정진우
* 1.0 Creation
*
* History
* 2010.11.02 CHM-201006736-01 유혁 터미널에서 전송되는 Actual SKD 수신시 ERP 전송 누락되는 문제 수정
* 2011.01.25 CHM-201007580-01 진마리아 Sked EDI 수신후 Actual sked의 Voyage/Direction을 찿는 Logic 추가
* 2011.09.09 CHM-201113239-01 김민아 Sked EDI 수신후 Actual sked의 Voyage/Direction을 찿는 Logic 추가(2)
* 2011.10.17 진마리아 CHM-201113948 Vessel sked EDI의 VVD mapping을 위해 F/F 수정 (Segment추가) (UAX)
* 2011.11.30 CHM-201221263-01 [VSK] Actual sked 삭제시 Estimated sked의 원복 로직 적용 요청 modifyPortSkdEstmDtRestore
* 2013.02.28 CHM-201323017    정상기  IFTSAI  EDI setup 변경 (MYPKGTM)
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActEDISetupInfoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActPortSkdChangeVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActPortSkdHisVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdEdiMntrVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdRtoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdSumVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.VvdListByPortVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwSkdSearchVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskActPortSkdEdiLogVO;
import com.hanjin.syscommon.common.table.VskActPortSkdHisVO;
import com.hanjin.syscommon.common.table.VskActPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;


/**
 * NIS2010 ActualScheduleMgtDBDAO <br>
 * - NIS2010-ActualScheduleManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jung Jinwoo
 * @see ActualScheduleMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class ActualScheduleMgtDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;

	/**
	 * VesselScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 입력된 VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ 내용이 Virtual Port인지를 확인한다. <br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdMgtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public ActSkdMgtVO checkTurnPort(ActSkdMgtVO actSkdMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActSkdMgtVO> list = null;
		ActSkdMgtVO returnVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdMgtVO != null){
				Map<String, String> mapVO = actSkdMgtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOCheckTurnPortRSQL(), param, velParam);
			
			if(dbRowset != null){
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActSkdMgtVO .class);
				
				if(list != null && list.size()>0){
					returnVO = list.get(0);
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * VesselScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 입력된 VSL_CD, SKD_VOY_NO, SKD_DIR_CD가 Close 상태인지를 확인한다.<br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdMgtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public ActSkdMgtVO checkVslSkdStatus(ActSkdMgtVO actSkdMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActSkdMgtVO> list = null;
		ActSkdMgtVO returnVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdMgtVO != null){
				Map<String, String> mapVO = actSkdMgtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOCheckVslSkdStatusRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActSkdMgtVO .class);
			
			if(list != null && list.size()>0){
				returnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * VesselScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 입력된 VSL_CD, SKD_VOY_NO, SKD_DIR_CD가 Skip Port인지를 확인한다.
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdMgtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public ActSkdMgtVO checkSkipPort(ActSkdMgtVO actSkdMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActSkdMgtVO> list = null;
		ActSkdMgtVO returnVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdMgtVO != null){
				Map<String, String> mapVO = actSkdMgtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOCheckSkipPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActSkdMgtVO .class);
			
			if(list != null && list.size()>0){
				returnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * 해당 VVD/Port에 대해서 Booking 정보가 생성되여 있는 확인하여 Actual Port Schedule History 정보를 남겨야 하는지 여부를 판단한다. <br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActPortSkdChangeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public ActPortSkdChangeVO checkVskActPortSkdChange(ActSkdMgtVO actSkdMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActPortSkdChangeVO> list = null;
		ActPortSkdChangeVO returnVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdMgtVO != null){
				Map<String, String> mapVO = actSkdMgtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOCheckVskActPortSkdChangeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActPortSkdChangeVO .class);
			
			if(list != null && list.size()>0){
				returnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	

	
	/**
	 * Actual Schedule 이 입력된 시점에 Coastal Schedule 정보를 조회한다.
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdMgtVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public ActSkdMgtVO searchLastCstSkdStatus(ActSkdMgtVO actSkdMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActSkdMgtVO> list = null;
		ActSkdMgtVO returnVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdMgtVO != null){
				Map<String, String> mapVO = actSkdMgtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchLastCstSkdStatusRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActSkdMgtVO .class);
			
			if(list != null && list.size()>0){
				returnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * VesselScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 입력된 VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ에 Actual Schedule 이 입력되여 있는지 확인한다. <br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdMgtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActSkdMgtVO checkVskActPortSkd(ActSkdMgtVO actSkdMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActSkdMgtVO> list = null;
		ActSkdMgtVO returnVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdMgtVO != null){
				Map<String, String> mapVO = actSkdMgtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOCheckVskActPortSkdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActSkdMgtVO .class);
			
			if(list != null && list.size()>0){
				returnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * VesselScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Vessel Port Schedule, Actual Port Schedule 정보를 조회한다. <br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdMgtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActSkdMgtVO searchActPortSkd(ActSkdMgtVO actSkdMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActSkdMgtVO> list = null;
		ActSkdMgtVO returnVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdMgtVO != null){
				Map<String, String> mapVO = actSkdMgtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOActSkdMgtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActSkdMgtVO .class);
			
			if(list != null && list.size()>0){
				returnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * VSK_ACT_PORT_SKD 단건의 데이터를 생성한다.<br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @exception DAOException
	 */
	public void addVskActPortSkd(ActSkdMgtVO actSkdMgtVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(actSkdMgtVO != null){
				Map<String, String> mapVO = actSkdMgtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//::jsk:2014-01-03:://int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new ActualScheduleMgtDBDAOAddVskActPortSkdCSQL(), param, null);
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new ActualScheduleMgtDBDAOAddVskActPortSkdCheckingExistCSQL(), param, null);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VSK_ACT_PORT_SKD 단건의 데이터를 수정한다.<br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @exception DAOException
	 */
	public void modifyVskActPortSkd(ActSkdMgtVO actSkdMgtVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(actSkdMgtVO != null){
				Map<String, String> mapVO = actSkdMgtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new ActualScheduleMgtDBDAOModifyVskActPortSkdUSQL(), param, null);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VSK_ACT_PORT_SKD 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param VskActPortSkdVO vskActPortSkdVO
	 * @exception DAOException
	 */
	public void removeVskActPortSkd(VskActPortSkdVO vskActPortSkdVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vskActPortSkdVO != null){
				Map<String, String> mapVO = vskActPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new ActualScheduleMgtDBDAORemoveVskActPortSkdByPkDSQL(), param, null);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ACT_PORT_SKD_HIS 에 단건의 데이터를 저장한다.<br>
	 * 
	 * @param VskActPortSkdHisVO vskActPortSkdHisVO
	 * @exception DAOException
	 */
	public void addVskActPortSkdHis(VskActPortSkdHisVO vskActPortSkdHisVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vskActPortSkdHisVO != null){
				Map<String, String> mapVO = vskActPortSkdHisVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new ActualScheduleMgtDBDAOAddActPortSkdHisCSQL(), param, null);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Actual SKD History 를 조회한다.
	 * 
	 * @param VvdPortLaneOtherVO vvdPortLaneOtherVO
	 * @return List<ActPortSkdHisVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ActPortSkdHisVO> searchActPortSkdHis(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActPortSkdHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdPortLaneOtherVO != null){
				Map<String, String> mapVO = vvdPortLaneOtherVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOActPortSkdHisRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActPortSkdHisVO .class);
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
	 * R/Lane Register. Actual SKD 모니터링 대상 Revenue Lane을 등록하기위한 목록을 조회한다.
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneVO> searchActualTargetLaneList(ActSkdRtoVO actSkdRtoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdRtoVO != null){
				Map<String, String> mapVO = actSkdRtoVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchActualTargetLaneRSQL(), param, velParam);
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
	
//	/**
//	 * VesselScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
//	 * 
//	 * @param ServiceLaneVO serviceLaneVO
//	 * @return List<ServiceLaneVO>
//	 * @exception DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public List<ServiceLaneVO> searchActPortSkdTgtLane(ServiceLaneVO serviceLaneVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<ServiceLaneVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(serviceLaneVO != null){
//				Map<String, String> mapVO = serviceLaneVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOServiceLaneRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActivationVvdVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}
		
	/**
	 * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용자가 입력한 조건에 맞는 Port들에 Actual Report 입력 현황을 조회한다.
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ActSkdSumVO> searchActPortSkdInputSum(ActSkdRtoVO actSkdRtoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActSkdSumVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdRtoVO != null){
				Map<String, String> mapVO = actSkdRtoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOActSkdSumRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActSkdSumVO .class);
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
	 * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용자가 입력한 조건에 맞는 Port들의 Actual Report 현황을 상세 조회한다.
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<ActSkdDtlVO> searchActPortSkdInputDtl(ActSkdRtoVO actSkdRtoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActSkdDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdRtoVO != null){
				Map<String, String> mapVO = actSkdRtoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchActPortSkdInputDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActSkdDtlVO .class);
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
	 * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Actual Schedule이 작성되지 않는 Report를 조회한다.<br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<ActSkdDtlVO> searchActPortSkdUnCmplDtl(ActSkdRtoVO actSkdRtoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActSkdDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdRtoVO != null){
				Map<String, String> mapVO = actSkdRtoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchActPortSkdUnCmplDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActSkdDtlVO .class);
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
	 * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 입력 조건에 따라 VSK_ACT_PORT_SKD_EDI_LOG 테이블를 조회한다.<br>
	 * 
	 * @param ActSkdEdiMntrVO actSkdEdiMntrVO
	 * @return List<ActSkdEdiMntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<ActSkdEdiMntrVO> searchActPortSkdEdiMntr(ActSkdEdiMntrVO actSkdEdiMntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActSkdEdiMntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdEdiMntrVO != null){
				Map<String, String> mapVO = actSkdEdiMntrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ydCd = actSkdEdiMntrVO.getYdCd();
				if (VSKGeneralUtil.isNotNull(ydCd)) {
					List<String> ydCdList = new ArrayList<String>();
					String[] ydCdArr = ydCd.split("\\,");
					if(ydCdArr != null && ydCdArr.length > 0){
						for(int i=0; i<ydCdArr.length; i++){
							ydCdList.add(ydCdArr[i]);
						}
						velParam.put("yd_cd", ydCdList);
					}
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOActSkdEdiMntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActSkdEdiMntrVO .class);
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
	 * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 입력 조건에 따라 VSK_ACT_PORT_SKD_EDI_LOG 테이블를 조회한다.<br>
	 * 
	 * @return List<VskActPortSkdEdiLogVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public VskActPortSkdEdiLogVO searchVskActPortSkdEdiLogKeyValue() throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		VskActPortSkdEdiLogVO rtnVO = null;
		
//		Map<String, Object> param = null;
//		Map<String, Object> velParam = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchVskActPortSkdEdiLogKeyValueRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
			if(list != null && list.size() > 0){
				rtnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}
	
	/**
	 * VSK_ACT_PORT_SKD_EDI_LOG 에 단건의 데이터를 저장한다.<br>
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @exception DAOException
	 */
	public void addVskActPortSkdEdiLog(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new ActualScheduleMgtDBDAOAddVskActPortSkdEdiLogCSQL(), param, null);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * VSK_ACT_PORT_SKD_EDI_LOG 에 단건의 데이터를 변경한다.<br>
	 * 데이터에 대한 검증 결과에 대해서 EDI Log 테이블에 업데이트 한다.<br>
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @exception DAOException
	 */
	public void modifyVskActPortSkdEdiLog(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new ActualScheduleMgtDBDAOModifyVskActPortSkdEdiLogUSQL(), param, null);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 각 Terminal별 EDI 수신 셋업 정보를 조회한다.
	 * VESSEL_CODE_FLAG, MANEUVERING_IN_HOURS_FLAG 반환되는 값이 'X'이면 등록되지 않은 YARD 임.
	 * 
	 * @param ActEDISetupInfoVO actEDISetupInfoVO
	 * @return ActEDISetupInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActEDISetupInfoVO searchActEDISetUpInfo(ActEDISetupInfoVO actEDISetupInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActEDISetupInfoVO> list = null;
		ActEDISetupInfoVO rtnVO = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(actEDISetupInfoVO != null){
				Map<String, String> mapVO = actEDISetupInfoVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchActEDISetUpInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActEDISetupInfoVO .class);
			if(list != null && list.size() > 0){
				rtnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * 수신된 SML Voyage, SML Directon, Call Sign No, Port Code를 이용한 SML에 맵핑되는 모든 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedHjsVoyDirAll(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedHjsVoyDirAllRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * EDI로 수신된 VVD가 SML Vessel Schedule과 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedHjsVoyDirHjsVslCd(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedHjsVoyDirHjsVslCdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 SML Voyage, SML Directon, Call Sign No, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedHjsVoyDirCallSignNo(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedHjsVoyDirCallSignNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 SML Voyage, SML Directon, IMO No, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedHjsVoyDirImoNo(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedHjsVoyDirImoNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 Terminal Voyage No, SML Vessel Code, Port Code를 이용한 SML에 맵핑되는 모든 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedTmnlVoyNoAll(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedTmnlVoyNoAllRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 Terminal Using Code(F/F "REF_CD")를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedTmnlUsingCd(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet 					dbRowset 	= null;
		List<VskActPortSkdEdiLogVO> list 		= null;
		
		Map<String, Object> 		param 		= new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDAOSearchHjsVvdByReceviedTmnlUsingCdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO.class);
			
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
	 * 수신된 Terminal Using Code(F/F "REF_CD")를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchTerminalUsingCdforHjsVvd(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet 					dbRowset 	= null;
		List<VskActPortSkdEdiLogVO> list 		= null;
		
		Map<String, Object> 		param 		= new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchTerminalUsingCdCrnNoforHjsVvdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO.class);
			
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
	 * 수신된 Terminal Voyage No, SML Vessel Code, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedTmnlVoyNoHjsVslCd(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedTmnlVoyNoHjsVslCdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 Terminal Voyage No, Call Sign No, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedTmnlVoyNoCallSignNo(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedTmnlVoyNoCallSignNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 Terminal Voyage No, IMO No, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedTmnlVoyNoImoNo(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedTmnlVoyNoImoNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 CONVEYANCE REFERENCE NUMBER (SHIP CALL NO.) MYPKG에서 사용하는 NO , SML Vessel Code, Location Code를 이용한 SML에 맵핑되는 모든 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedShipCallNoAll(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoAllRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 CONVEYANCE REFERENCE NUMBER (SHIP CALL NO.) MYPKG에서 사용하는 NO , SML Vessel Code, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedShipCallNoHjsVslCd(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoHjsVslCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 CONVEYANCE REFERENCE NUMBER (SHIP CALL NO.) MYPKG에서 사용하는 NO , Call Sign No, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedShipCallNoCallSignNo(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoCallSignNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 CONVEYANCE REFERENCE NUMBER (SHIP CALL NO.) MYPKG에서 사용하는 NO , IMO No, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedShipCallNoImoNo(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoImoNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 PAS Voyage No, Call Sign No, Port Code를 이용한 SML에 맵핑되는 모든 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedPsaVoyNoAll(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedPsaVoyNoAllRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 PAS Voyage No, SML Vessel Code, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedPsaVoyNoHjsVslCd(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedPsaVoyNoHjsVslCdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 PAS Voyage No, Call Sign No, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedPsaVoyNoCallSignNo(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedPsaVoyNoCallSignNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * 수신된 PAS Voyage No, IMO No, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchHjsVvdByReceviedPsaVoyNoImoNo(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchHjsVvdByReceviedPsaVoyNoImoNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ETA, ETB, ETD를 이용하여 EDI 내용에 누락된 ETA, ETB, ETD 를 생성한다.<br>
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return String
	 * @exception DAOException
	 */
    public String searchActArrDtByMnvrInHrs(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		String actDt = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchActArrDtByMnvrInHrsRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					actDt = dbRowset.getString("ACT_DT");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return actDt;
	}
	
	/**
	 * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ETA, ETB, ETD를 이용하여 EDI 내용에 누락된 ETA, ETB, ETD 를 생성한다.<br>
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return String
	 * @exception DAOException
	 */
    public String searchActBrthDtByMnvrInHrs(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		String actDt = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchActBrthDtByMnvrInHrsRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					actDt = dbRowset.getString("ACT_DT");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return actDt;
	}
	
	/**
	 * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * "US" 지역에서는 Virtural Port에 Actual Port Skd 정보가 입력됨으로 Turning VVD를 찾는다.<br>
	 * 
	 * @param VskActPortSkdEdiLogVO VskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<VskActPortSkdEdiLogVO> searchVoyNoDirCdByTuringVvd(VskActPortSkdEdiLogVO VskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdEdiLogVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(VskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = VskActPortSkdEdiLogVO .getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchVoyNoDirCdByTuringVvdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO .class);
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
	 * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * CALL INDICATOR 를 조회한다.<br>
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return String
	 * @exception DAOException
	 */
    public String searchCallingIndicator(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		String  clptIndSeq = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchCallingIndicatorRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					clptIndSeq = dbRowset.getString("CLPT_IND_SEQ");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return clptIndSeq;
	}
	
	/**
	 * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 입력된 VVD, PORT가 VIRTURAL PORT일 것을 감안해서 TURNING VOY, DIR를 조회한다.<br>
	 * [참고] VIRTUAL PORT에서는 ACTUAL SKD를 입력할 수 없다.<br>
	 * 
	 * @param VskActPortSkdEdiLogVO VskActPortSkdEdiLogVO
	 * @return VskVslPortSkdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public VskVslPortSkdVO searchOriginalVoyDir(VskActPortSkdEdiLogVO VskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		VskVslPortSkdVO rtnVO = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(VskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = VskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchOrginalVoyDirRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
			if(list != null && list.size() > 0){
				rtnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}
	
	/**
	 * 입력된 Port에 ETA와 이전 Port ETD를 비교하기 위해서 이전 Port에 ETD를 Check 한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkPreCallingPortInfo(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		String chkFlg = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOCheckPreCallingPortInfoRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					chkFlg = dbRowset.getString("CHK_FLG");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chkFlg;
	}
	
	/**
	 * Actual Schedule 정보를 조회한다.
	 * 
	 * @param VskActPortSkdVO vskActPortSkdVO
	 * @return VskActPortSkdVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public VskActPortSkdVO searchVskActPortSkd(VskActPortSkdVO vskActPortSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskActPortSkdVO> list = null;
		VskActPortSkdVO rtnVO = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = null;

		try{
			if(vskActPortSkdVO != null){
				Map<String, String> mapVO = vskActPortSkdVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchVskActPortSkdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdVO .class);
			if(list != null && list.size() > 0){
				rtnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}
	
	/**
	 * SPP에서 받은 조건으로 Calling하는 Vvd를 조회.<br>
	 * 입력받은 Port Code를 ETA 기준 -7일 ~ +7일에 Calling하는 Vvd를 조회한다.<br>
	 * 
	 * @param String vpsPortCd
	 * @param String vslSvcTpCd
	 * @return List<VvdListByPortVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<VvdListByPortVO> searchSppVvdListByPort(String vpsPortCd, String vslSvcTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdListByPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(VSKGeneralUtil.isNotNull(vpsPortCd) && VSKGeneralUtil.isNotNull(vslSvcTpCd)){
				param.put("vps_port_cd", vpsPortCd);
				param.put("vsl_svc_tp_cd", vslSvcTpCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchSppVvdListByPortRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdListByPortVO .class);
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
	 * VSK_ACT_PORT_SKD 데이터를 삭제한다.<br>
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskActPortSkd(VvdVO vvdVO ) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ActualScheduleMgtDBDAORemoveVskActPortSkdDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * VSK_VSL_SKD 정보를 조회한다.
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return VskVslSkdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public VskVslSkdVO searchVskVslSkd(VskVslSkdVO vskVslSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslSkdVO> list = null;
		VskVslSkdVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskVslSkdVO != null){
				Map<String, String> mapVO = vskVslSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchVskVslSkdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslSkdVO.class);
			if(list != null && list.size() > 0){
				rtnVO = list.get(0);
			}
			
			return rtnVO;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Vessel이 Trunk인지 조회한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchVesselIsTrunk(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean b = false;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchVesselIsTrunkRSQL(), param, velParam);
				
				if(dbRowset.next()){
					b = true;
				}
			}
			
			return b;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 특정 Vessel Code, Yard Code인 VVD 목록중에
	 * ETA, ETB, ETD 가 주어진 시간과 그 차이가 24시간 이내인 VVD를 구한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchOneDayVvdByYard(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VskActPortSkdEdiLogVO> list = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchOneDayVvdByYardRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO.class);
			}
			
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EDI로 수신 받은 Call Sign No 또는 Vessel Code 또는 IMO No, Port Code 와 일치하고
	 * ETA, ETB, ETD 가 ATA, ATB, ATD 와 차이가 +-24시간 이내인 VVD를 구한다.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return List<VskActPortSkdEdiLogVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskActPortSkdEdiLogVO> searchVvdByEdiActual(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VskActPortSkdEdiLogVO> list = null;

		try{
			if(vskActPortSkdEdiLogVO != null){
				Map<String, String> mapVO = vskActPortSkdEdiLogVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOSearchVvdByEdiActualRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskActPortSkdEdiLogVO.class);
			}
			
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VSK_VSL_SKD_HIS' BEF ETA,ETB,ETD -> VSK_VSL_PORT_SKD ETA,ETB,ETD UPDATE <br>
	 * 
	 * @param VskActPortSkdVO vskActPortSkdVO
	 * @exception DAOException  
	 */

	public void modifyPortSkdEstmDtRestore(VskActPortSkdVO vskActPortSkdVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vskActPortSkdVO != null){
				Map<String, String> mapVO = vskActPortSkdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new ActualScheduleMgtDBDAOModifyPortSkdEstmDtRestoreUSQL(), param, null);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 시간차에 의한 중복입력발생방지를 위한 체크 (true:new record, false:exist record)
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean isNewRecordforActualSchedule(ActSkdMgtVO actSkdMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		//List<ActSkdMgtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		boolean	isReturnValue	= false;

		try{
			if(actSkdMgtVO != null){
				Map<String, String> mapVO = actSkdMgtVO .getColumnValues();
			
				param.putAll	(mapVO);
				velParam.putAll	(mapVO);
			}
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAOCheckNewRecordforActualScheduleRSQL(), param, velParam);
			dbRowset.next();

			if(Integer.parseInt(dbRowset.getString("KNT"))==0)		isReturnValue	= true;
			log.debug("\n\n ::jskjskjsk::isNewRecordforActualSchedule.Count.for.VSK_ACT_PORT_SKD ["+dbRowset.getString("KNT")+"]  \n");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isReturnValue;
	}	
	
	
	/**
	 * 
	 * 입력된 VSL_CD, SKD_VOY_NO, SKD_DIR_CD의 PORT가 Drewry 관리 대상일 경우 조회해 온다<br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdMgtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<DrwSkdSearchVO> searchDrwSkdInfo(ActSkdMgtVO actSkdMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DrwSkdSearchVO> list = null;
		//List<DrwSkdSearchVO> returnVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actSkdMgtVO != null){
				Map<String, String> mapVO = actSkdMgtVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualScheduleMgtDBDAODrwSkdPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DrwSkdSearchVO.class);
			
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * VSK_VSL_DRW_SKD 에 데이터를 저장한다.<br>
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @exception DAOException
	 */
	public void addDrwSkdInfo(DrwSkdSearchVO drwSkdSearchVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(drwSkdSearchVO != null){
				Map<String, String> mapVO = drwSkdSearchVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new ActualScheduleMgtDBDAODrwSkdPortInfoCSQL(), param, null);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Insert SQL");
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