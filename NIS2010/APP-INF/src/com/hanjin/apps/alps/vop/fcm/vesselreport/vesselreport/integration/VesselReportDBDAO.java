/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportDBDAO.java
*@FileTitle : VesselReportDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.07
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 1.0 Creation
* 
* [CHM-201640787] 연료 소모 분석관련  Departure Report 신규 화면 개발 - 2016.04.07 이병훈
* 
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.basic.VesselReportBCImpl;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptErrClsVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptLogVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptLogVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.SearchMailingListVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.SearchVslPortSkdVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VskSkdInfoForDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptErrVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptOverlapVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslFcmDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.FcmDepRptClsHisVO;
import com.hanjin.syscommon.common.table.FcmDepRptErrRtSetVO;
import com.hanjin.syscommon.common.table.FcmDepRptErrVO;

/**
 * ALPS VesselReportDBDAO<br>
 * ALPS TEMP1 Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hyuk Ryu
 * @see VesselReportBCImpl 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAO extends DBDAOSupport {

	
	private static final long serialVersionUID = 1L;

	
	/**
	 * Vessel Report에 대한 주어진 구간의 LANE 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslRptInqVO>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VslRptInqVO> searchVslRptSkdInfo(VslRptInqVO vslRptInqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslRptInqVO> vslRptInqVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();
				
				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslRptInqVORSQL(), param, velParam);
			vslRptInqVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, VslRptInqVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslRptInqVOs;
	}

	/**
	 * 주어진 조건에 대한 Lane별 Noon Report Mismatched 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslNoonRptMssMtchVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslNoonRptMssMtchVO> searchVslNoonRptMssMtch(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslNoonRptMssMtchVO> vslNoonRptMssMtchVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();
				
				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
		    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslNoonRptMssMtchVORSQL(), param, velParam);
			vslNoonRptMssMtchVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, VslNoonRptMssMtchVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslNoonRptMssMtchVOs;
	}
	
	/**
	 * 주어진 조건에 대한 Lane별 Noon Report Not Receive 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslNoonRptNotRcvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslNoonRptNotRcvVO> searchVslNoonRptNotRcv(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslNoonRptNotRcvVO> vslNoonRptNotRcvVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();
				
				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
		    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslNoonRptNotRcvVORSQL(), param, velParam);
			vslNoonRptNotRcvVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, VslNoonRptNotRcvVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslNoonRptNotRcvVOs;
	}
	
	/**
	 * 주어진 조건에 대한 Lane별 Noon Report 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslNoonRptVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslNoonRptVO> searchVslNoonRpt(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslNoonRptVO> vslNoonRptVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();
				
				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
		    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslNoonRptVORSQL(), param, velParam);
			vslNoonRptVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, VslNoonRptVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslNoonRptVOs;
	}

	/**
	 * 주어진 조건에 대한 Lane별 Departure Report 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslDepRptVO> searchVslDepRpt(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslDepRptVO> vslDepRptVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();
				
				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslDepRptVORSQL(), param, velParam);
			vslDepRptVO = (List) RowSetUtil.rowSetToVOs(dbRowset, VslDepRptVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslDepRptVO;
	}
	
	/**
	 * 주어진 조건에 대한 Lane별 Departure Report Not Receive 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptNotRcvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslDepRptNotRcvVO> searchVslDepRptNotRcv(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslDepRptNotRcvVO> vslDepRptNotRcvVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();
			
				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslDepRptNotRcvVORSQL(), param, velParam);
			vslDepRptNotRcvVO = (List) RowSetUtil.rowSetToVOs(dbRowset, VslDepRptNotRcvVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslDepRptNotRcvVO;
	}
	
	/**
	 * 주어진 조건에 대한 Lane별 Departure Report Error 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptErrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslDepRptErrVO> searchVslDepRptErr(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslDepRptErrVO> vslDepRptErrVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();

				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslDepRptErrRSQL(), param, velParam);

			vslDepRptErrVO = (List) RowSetUtil.rowSetToVOs(dbRowset, VslDepRptErrVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslDepRptErrVO;
	}
	
	/**
	 * Departure Report의 Error 항목을 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<VslDepRptErrVO> delModels
	 * @throws DAOException
	 */
	public void removeVslDepRptErrList(List<VslDepRptErrVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;	
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new VesselReportDBDAORemoveFcmDepRptErrDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	
	/**
	 * Departure Report의 Overlap 항목을 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<VslDepRptOverlapVO> delModels
	 * @throws DAOException
	 */
	public void removeVslDepRptOverlapList(List<VslDepRptOverlapVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new VesselReportDBDAORemoveFcmDepRptErrDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	
	/**
	 * 주어진 조건에 대한 Lane별 Departure Report Overlap 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptOverlapVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslDepRptOverlapVO> searchVslDepRptOverlap(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslDepRptOverlapVO> vslDepRptOverlapVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();

				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslDepRptOverlapRSQL(), param, velParam);

			vslDepRptOverlapVO = (List) RowSetUtil.rowSetToVOs(dbRowset, VslDepRptOverlapVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslDepRptOverlapVO;
	}
	
	/**
	 * 주어진 조건에 대한 Lane별 ABLog Report 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslABLogRptVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslABLogRptVO> searchVslABLogRpt(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslABLogRptVO> vslABLogRptVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();
				
				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
		    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslABLogRptVORSQL(), param, velParam);
			vslABLogRptVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, VslABLogRptVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslABLogRptVOs;
	}

	
	/**
	 * 주어진 조건에 대한 Lane별 ABLog Report Not Receive 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslABLogRptNotRcvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslABLogRptNotRcvVO> searchVslABLogRptNotRcv(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslABLogRptNotRcvVO> vslABLogRptNotRcvVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();
				
				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
		    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslABLogRptNotRcvVORSQL(), param, velParam);
			vslABLogRptNotRcvVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, VslABLogRptNotRcvVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslABLogRptNotRcvVOs;
	}
	
	/**
	 * 주어진 조건에 대한 Lane별 ABLog Report Mismatched 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslABLogRptMssMtchVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslABLogRptMssMtchVO> searchVslABLogRptMssMtch(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslABLogRptMssMtchVO> vslABLogRptMssMtchVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();
				
				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
		    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslABLogRptMssMtchVORSQL(), param, velParam);
			vslABLogRptMssMtchVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, VslABLogRptMssMtchVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslABLogRptMssMtchVOs;
	}
	
	/**
	 * 주어진 조건에 대한 Lane별 ROB Month End Report 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslRobMthEndRptVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslRobMthEndRptVO> searchVslRobMthEndRpt(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslRobMthEndRptVO> vslRobMthEndRptVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();

				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslRobMthEndRptVORSQL(), param, velParam);
			vslRobMthEndRptVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, VslRobMthEndRptVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslRobMthEndRptVOs;
	}
	
	
	/**
	 * 주어진 조건에 대한 Lane별 ROB Month End Report Not Receive 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslRobMthEndRptNotRcvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslRobMthEndRptNotRcvVO> searchVslRobMthEndRptNotRcv(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslRobMthEndRptNotRcvVO> vslRobMthEndRptNotRcvVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();

				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslRobMthEndRptNotRcvVORSQL(), param, velParam);
			vslRobMthEndRptNotRcvVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, VslRobMthEndRptNotRcvVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslRobMthEndRptNotRcvVOs;
	}
	
	
	/**
	 * 주어진 조건에 대한 Lane별 ROB Month End Report Mismatched 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslRobMthEndRptMssMtchVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<VslRobMthEndRptMssMtchVO> searchVslRobMthEndRptMssMtch(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslRobMthEndRptMssMtchVO> vslRobMthEndRptMssMtchVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();

				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				String sVpsPortCd = vslRptInqVO.getVpsPortCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> vpsPortCdList = new ArrayList<String>();
				
				StringTokenizer st = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stt = new StringTokenizer(sVslCd, ",");
				StringTokenizer sttt = new StringTokenizer(sVpsPortCd, ",");

				while (st.hasMoreTokens()) {
					vslSlanCdList.add(st.nextToken());
				}

				while (stt.hasMoreTokens()) {
					vslCdList.add(stt.nextToken());
				}
				
				while (sttt.hasMoreTokens()) {
					vpsPortCdList.add(sttt.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", vpsPortCdList);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslRobMthEndRptMssMtchVORSQL(), param, velParam);
			vslRobMthEndRptMssMtchVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, VslRobMthEndRptMssMtchVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslRobMthEndRptMssMtchVOs;
	}
	
	///////////////// DEPARTURE REPORT ////////////////
	/**
	 * Create departure report log. Create Initial data.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception DAOException
	 */
	public void addDepRptLogInit(FcmDepRptLogVO fcmDepRptLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(fcmDepRptLogVO != null){
				Map<String, String> mapVO = fcmDepRptLogVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAOAddFcmDepRptLogInitCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Create departure report log. Create general data.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception DAOException
	 */
	public void modifyDepRptLog(FcmDepRptLogVO fcmDepRptLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(fcmDepRptLogVO != null){
				Map<String, String> mapVO = fcmDepRptLogVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAOModifyFcmDepRptLogUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Create departure report log. Update result of creation.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception DAOException
	 */
	public void modifyDepRptLogPost(FcmDepRptLogVO fcmDepRptLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(fcmDepRptLogVO != null){
				Map<String, String> mapVO = fcmDepRptLogVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAOModifyFcmDepRptLogPostUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Create departure report.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception DAOException
	 */
	public void addDepRpt(FcmDepRptLogVO fcmDepRptLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(fcmDepRptLogVO != null){
				Map<String, String> mapVO = fcmDepRptLogVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAOAddFcmDepRptCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Remove departure report.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception DAOException
	 */
	public void removeDepRpt(FcmDepRptLogVO fcmDepRptLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(fcmDepRptLogVO != null){
				Map<String, String> mapVO = fcmDepRptLogVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAORemoveFcmDepRptDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Remove old data from departure report.<br>
	 * 
	 * @param fcmDepRptLogVO
	 * @throws DAOException
	 */
	public void removeDepRptOld(FcmDepRptLogVO fcmDepRptLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(fcmDepRptLogVO != null){
				Map<String, String> mapVO = fcmDepRptLogVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAORemoveFcmDepRptOldDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Search max sequence of departure report log for update.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception DAOException
	 */
	public void searchDepRptLogMaxRcvSeq(FcmDepRptLogVO fcmDepRptLogVO) throws DAOException {
        DBRowSet dbRowset = null;
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchDepRptLogMaxRcvSeqRSQL(), null, null);
			if(dbRowset.next()){
				fcmDepRptLogVO.setRcvDt(dbRowset.getString("RCV_DT"));
				fcmDepRptLogVO.setRcvSeq(dbRowset.getString("RCV_Seq"));
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	///////////////// NOON REPORT ////////////////	
	/**
	 * Create noon report log. Create Initial data.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception DAOException
	 */
	public void addNoonRptLogInit(FcmNoonRptLogVO fcmNoonRptLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(fcmNoonRptLogVO != null){
				Map<String, String> mapVO = fcmNoonRptLogVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAOAddFcmNoonRptLogInitCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Create noon report log. Create general data.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception DAOException
	 */
	public void modifyNoonRptLog(FcmNoonRptLogVO fcmNoonRptLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(fcmNoonRptLogVO != null){
				Map<String, String> mapVO = fcmNoonRptLogVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAOModifyFcmNoonRptLogUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Create noon report log. Update result of creation.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception DAOException
	 */
	public void modifyNoonRptLogPost(FcmNoonRptLogVO fcmNoonRptLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(fcmNoonRptLogVO != null){
				Map<String, String> mapVO = fcmNoonRptLogVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAOModifyFcmNoonRptLogPostUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Create noon report.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception DAOException
	 */
	public void addNoonRpt(FcmNoonRptLogVO fcmNoonRptLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(fcmNoonRptLogVO != null){
				Map<String, String> mapVO = fcmNoonRptLogVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAOAddFcmNoonRptCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Remove noon report.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception DAOException
	 */
	public void removeNoonRpt(FcmNoonRptLogVO fcmNoonRptLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(fcmNoonRptLogVO != null){
				Map<String, String> mapVO = fcmNoonRptLogVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAORemoveFcmNoonRptDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Search max sequence of noon report log for update.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception DAOException
	 */
	public void searchNoonRptLogMaxRcvSeq(FcmNoonRptLogVO fcmNoonRptLogVO) throws DAOException {
        DBRowSet dbRowset = null;
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchNoonRptLogMaxRcvSeqRSQL(), null, null);
			if(dbRowset.next()){
				fcmNoonRptLogVO.setRcvDt(dbRowset.getString("RCV_DT"));
				fcmNoonRptLogVO.setRcvSeq(dbRowset.getString("RCV_Seq"));
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
	 *  Mail Preview 를 단건 조회 합니다. <br>
	 * 
	 * @param searchMailingListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchMailingListVO> searchMailingList(SearchMailingListVO searchMailingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMailingListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMailingListVO != null){
				Map<String, String> mapVO = searchMailingListVO .getColumnValues();
				
				String sVslCd = searchMailingListVO.getVslCdArr();
				
				List<String> vslCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(sVslCd, ",");
				
				while (st.hasMoreTokens()) {
					vslCdList.add(st.nextToken());
				}
				
				velParam.put("vel_vsl_cd", vslCdList);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchMailingListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMailingListVO .class);
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
	 * Departure Report Inquiry 조회
	 * 
	 * @param vslRptInqVO VslRptInqVO
	 * @return List<VslFcmDepRptVO>
	 * @throws DAOException
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VslFcmDepRptVO> searchVslFcmDepRptList(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslFcmDepRptVO> vslFcmDepRptVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslRptInqVO != null){
				Map<String, String> mapVO = vslRptInqVO.getColumnValues();
				
				String sVslSlanCd = vslRptInqVO.getVslSlanCd();
				String sVslCd = vslRptInqVO.getVslCd();
				
				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				
				StringTokenizer stVslSlanCd = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stVslCd = new StringTokenizer(sVslCd, ",");

				while (stVslSlanCd.hasMoreTokens()) {
					vslSlanCdList.add(stVslSlanCd.nextToken());
				}

				while (stVslCd.hasMoreTokens()) {
					vslCdList.add(stVslCd.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchVslFcmDepRptListRSQL(), param, velParam);
			vslFcmDepRptVO = (List) RowSetUtil.rowSetToVOs(dbRowset, VslFcmDepRptVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslFcmDepRptVO;
	}
    
    /**
     * Departure Report Inquiry 업데이트
     * 
     * @param vslFcmDepRptVOList List<VslFcmDepRptVO>
     * @throws DAOException
     */
	public void updateVslFcmDepRptList(List<VslFcmDepRptVO> vslFcmDepRptVOList) throws DAOException {
		try{
			int updCnt[] = null;
			
			if (vslFcmDepRptVOList.size() > 0) {
				updCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new VesselReportDBDAOUpdateVslFcmDepRptListUSQL(), vslFcmDepRptVOList, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to Update No"+ i + " SQL");
					}
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
	 * Departure Report Cleansing History 테이블에 Cleansing 이력이 존재하는지 확인한다.
	 * 
	 * @param fcmDepRptLogVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkDepRptClsHis(FcmDepRptLogVO fcmDepRptLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean 	isResult = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (fcmDepRptLogVO != null) {
				Map<String, String> mapVO = fcmDepRptLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchFcmDepRptClsHisRSQL(), param, null);
			
			if (dbRowset != null) {
				if (dbRowset.next()) {
					isResult	= true;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isResult;
	}
	
	/**
	 * Departure Report Error 테이블 등록
	 * 
	 * @param fcmDepRptLogVO
	 * @param errAddParam
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addDepRptErr(FcmDepRptLogVO fcmDepRptLogVO, @SuppressWarnings("rawtypes") Map errAddParam) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if (fcmDepRptLogVO != null && errAddParam != null) {
				Map<String, String> mapVO = fcmDepRptLogVO.getColumnValues();
				param.putAll(mapVO);
				param.putAll(errAddParam);
			}
				
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new VesselReportDBDAOAddFcmDepRptErrCSQL(), param, null);
			
			if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Departure Report PK Validation Check 를 위한 Vessel Schedule 정보 조회
	 * 
	 * @param fcmDepRptLogVO
	 * @param clptIndSeq
	 * @return List<VskSkdInfoForDepRptVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<VskSkdInfoForDepRptVO> searchVskSkdInfoForDepRpt(FcmDepRptLogVO fcmDepRptLogVO, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskSkdInfoForDepRptVO> vskSkdInfoForDepRptVOList = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmDepRptLogVO != null){
				Map<String, String> mapVO = fcmDepRptLogVO.getColumnValues();
				param.putAll(mapVO);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.putAll(mapVO);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchVskSkdInfoForDepRptRSQL(), param, velParam);
			vskSkdInfoForDepRptVOList = (List) RowSetUtil.rowSetToVOs(dbRowset, VskSkdInfoForDepRptVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vskSkdInfoForDepRptVOList;
	}
	
	/**
	 * Vessel Schedule 기준 이전 Port 의 Departure Report 정보 조회
	 * 
	 * @param vskSkdInfoForDepRptVO
	 * @return FcmDepRptVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FcmDepRptVO searchLastPortDepRpt(VskSkdInfoForDepRptVO vskSkdInfoForDepRptVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmDepRptVO> fcmDepRptVOList = null;
		FcmDepRptVO fcmDepRptVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(vskSkdInfoForDepRptVO != null){
				Map<String, String> mapVO = vskSkdInfoForDepRptVO.getColumnValues();
				param.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchLastPortDepRptRSQL(), param, null);
			fcmDepRptVOList = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmDepRptVO.class);
			
			if (fcmDepRptVOList != null && fcmDepRptVOList.size()>0) {
				fcmDepRptVO = fcmDepRptVOList.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmDepRptVO;
	}
	
	/**
	 * Departure Report Error Rate 조회한다.
	 * 
	 * @param fcmDepRptLogVO
	 * @return FcmDepRptErrRtSetVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FcmDepRptErrRtSetVO searchDepRptErrRt(FcmDepRptLogVO fcmDepRptLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmDepRptErrRtSetVO> fcmDepRptErrRtSetVOList = null;
		FcmDepRptErrRtSetVO fcmDepRptErrRtSetVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(fcmDepRptLogVO != null){
				Map<String, String> mapVO = fcmDepRptLogVO.getColumnValues();
				param.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchDepRptErrRtRSQL(), param, null);
			fcmDepRptErrRtSetVOList = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmDepRptErrRtSetVO.class);
			
			if (fcmDepRptErrRtSetVOList != null && fcmDepRptErrRtSetVOList.size()>0) {
				fcmDepRptErrRtSetVO = fcmDepRptErrRtSetVOList.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmDepRptErrRtSetVO;
	}
	
	/**
	 * Departure Report Item Standard Data 조회
	 * 
	 * @param fcmDepRptLogVO
	 * @param lastPortDepRptVO
	 * @return FcmDepRptErrClsVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FcmDepRptErrClsVO searchDepRptStandardData(FcmDepRptLogVO fcmDepRptLogVO, FcmDepRptVO lastPortDepRptVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmDepRptErrClsVO> fcmDepRptErrClsVOList = null;
		FcmDepRptErrClsVO fcmDepRptErrClsVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(fcmDepRptLogVO != null && lastPortDepRptVO != null){
				Map<String, String> mapVO = fcmDepRptLogVO.getColumnValues();
				param.putAll(mapVO);
				param.put("lst_vsl_cd", lastPortDepRptVO.getVslCd());
				param.put("lst_skd_voy_no", lastPortDepRptVO.getSkdVoyNo());
				param.put("lst_skd_dir_cd", lastPortDepRptVO.getSkdDirCd());
				param.put("lst_port_cd", lastPortDepRptVO.getDepPortCd());
				param.put("lst_clpt_ind_seq", lastPortDepRptVO.getClptIndSeq());
				param.put("lst_port_rup_dt", lastPortDepRptVO.getRupDt());
				param.put("lst_foil_wgt", lastPortDepRptVO.getDepFoilWgt());
				param.put("lst_low_sulp_foil_wgt", lastPortDepRptVO.getDepLowSulpFoilWgt());
				param.put("lst_doil_wgt", lastPortDepRptVO.getDepDoilWgt());
				param.put("lst_low_sulp_doil_wgt", lastPortDepRptVO.getDepLowSulpDoilWgt());
				param.put("lst_rf_cntr_obrd_knt", lastPortDepRptVO.getRfCntrObrdKnt());
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchDepRptStandardDataRSQL(), param, null);
			fcmDepRptErrClsVOList = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmDepRptErrClsVO.class);
			
			if (fcmDepRptErrClsVOList != null && fcmDepRptErrClsVOList.size()>0) {
				fcmDepRptErrClsVO = fcmDepRptErrClsVOList.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmDepRptErrClsVO;
	}
	
	/**
	 * Departure Report Log 정보를 조회한다.
	 * 
	 * @param fcmDepRptErrVO
	 * @return FcmDepRptLogVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FcmDepRptLogVO searchDepRptLog(FcmDepRptErrVO fcmDepRptErrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmDepRptLogVO> fcmDepRptLogVOList = null;
		FcmDepRptLogVO fcmDepRptLogVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(fcmDepRptErrVO != null){
				Map<String, String> mapVO = fcmDepRptErrVO.getColumnValues();
				param.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchDepRptLogRSQL(), param, null);
			fcmDepRptLogVOList = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmDepRptLogVO.class);
			
			if (fcmDepRptLogVOList != null && fcmDepRptLogVOList.size()>0) {
				fcmDepRptLogVO = fcmDepRptLogVOList.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmDepRptLogVO;
	}
	
	/**
	 * Departure Report PK Error Cleansing sheet2(SKD) 조회
	 * 
	 * @param SearchVslPortSkdVO vslPortSkdVO
	 * @return List<VslPortSkdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchVslPortSkdVO> searchVslPortSkdList(SearchVslPortSkdVO vslPortSkdVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<SearchVslPortSkdVO> vslPortSkdVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslPortSkdVO != null){
				Map<String, String> mapVO = vslPortSkdVO.getColumnValues();
				
				String sVslSlanCd = vslPortSkdVO.getVslSlanCd();
				String sVslCd = vslPortSkdVO.getVslCd();
				String sVpsPortCd = vslPortSkdVO.getVpsPortCd();

				List<String> vslSlanCdList = new ArrayList<String>();
				List<String> vslCdList = new ArrayList<String>();
				List<String> portCdList = new ArrayList<String>();
				
				StringTokenizer stVslSlanCd = new StringTokenizer(sVslSlanCd, ",");
				StringTokenizer stVslCd = new StringTokenizer(sVslCd, ",");
				StringTokenizer stVpsPortCd = new StringTokenizer(sVpsPortCd, ",");

				while (stVslSlanCd.hasMoreTokens()) {
					vslSlanCdList.add(stVslSlanCd.nextToken());
				}

				while (stVslCd.hasMoreTokens()) {
					vslCdList.add(stVslCd.nextToken());
				}
				
				while (stVpsPortCd.hasMoreTokens()) {
					portCdList.add(stVpsPortCd.nextToken());
				}
				
				velParam.put("vel_vsl_slan_cd", vslSlanCdList);
				velParam.put("vel_vsl_cd", vslCdList);
				velParam.put("vel_vps_port_cd", portCdList);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchVslPortSkdRSQL(), param, velParam);
			vslPortSkdVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchVslPortSkdVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslPortSkdVOs;
	}
	
    /**
     * Departure Report PK Error Cleansing 업데이트
     * 
	 * @param FcmDepRptErrVO vslFcmDepRptVO
     * @throws DAOException
     */
	public void deleteFcmDepRptErr(FcmDepRptErrVO vslFcmDepRptVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = vslFcmDepRptVO.getColumnValues();
			param.putAll(mapVO);

			int dCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new VesselReportDBDAORemoveFcmDepRptErrDSQL(), param, null);
			if(dCnt == Statement.EXECUTE_FAILED ) throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * Departure Report PK Error Cleansing 업데이트
     * 
	 * @param FcmDepRptClsHisVO fcmDepRptClsHisVO
     * @throws DAOException
     */
	public void insertFcmDepRptClsHis(FcmDepRptClsHisVO fcmDepRptClsHisVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = fcmDepRptClsHisVO.getColumnValues();
				
			param.putAll(mapVO);

			int iCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new VesselReportDBDAOAddFcmDepRptClsHisCSQL(), param, null);
			if(iCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Departure Report Error Cleansing Data 조회
	 * 
	 * @param sDepRptErrTpCd
	 * @param fcmDepRptErrClsVO
	 * @return List<FcmDepRptErrClsVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FcmDepRptErrClsVO searchFcmDepRptErrCls(String sDepRptErrTpCd, FcmDepRptErrClsVO fcmDepRptErrClsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmDepRptErrClsVO> list	= null;
		List<String> depRptErrTpCd		= new ArrayList<String>();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			StringTokenizer st = new StringTokenizer(sDepRptErrTpCd, ",");
			while (st.hasMoreTokens()) {
				depRptErrTpCd.add(st.nextToken());
			}
			
			Map<String, String> mapVO = fcmDepRptErrClsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("dep_rpt_err_tp_cd", depRptErrTpCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchFcmDepRptErrClsRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FcmDepRptErrClsVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0? null:list.get(0);
	}
	
	/**
	 * Departure Report Error Setting 조회
	 * 
	 * @param fcmDepRptErrClsVO
	 * @return FcmDepRptErrClsVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FcmDepRptErrClsVO SearchFcmDepRptErrRtSetCls(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmDepRptErrClsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmDepRptErrClsVO != null){
				Map<String, String> mapVO = fcmDepRptErrClsVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchFcmDepRptErrRtSetClsRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FcmDepRptErrClsVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0? null:list.get(0);
	}
	
	/**
	 * Departure Report Past Cleansing History 조회
	 * 
	 * @param fcmDepRptErrClsVO
	 * @return List<FcmDepRptErrClsVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<FcmDepRptErrClsVO> searchFcmDepRptPastClsHis(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmDepRptErrClsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(fcmDepRptErrClsVO != null){
				Map<String, String> mapVO = fcmDepRptErrClsVO.getColumnValues();
				
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchFcmDepRptPastClsHisRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FcmDepRptErrClsVO .class);
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
	 * Departure Report Same Section Data 조회
	 * 
	 * @param fcmDepRptErrClsVO
	 * @return List<FcmDepRptErrClsVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<FcmDepRptErrClsVO> searchFcmDepRptSamSectDat(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmDepRptErrClsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(fcmDepRptErrClsVO != null){
				Map<String, String> mapVO = fcmDepRptErrClsVO.getColumnValues();
				
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchFcmDepRptSamSectDatRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FcmDepRptErrClsVO .class);
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
	 * Departure Report Past Cleansing History 생성
	 * 
	 * @param fcmDepRptErrClsVO
	 * @throws DAOException
	 */
	public void addFcmDepRptPastClsHis(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = fcmDepRptErrClsVO.getColumnValues();
				
			param.putAll(mapVO);

			int iCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new VesselReportDBDAOAddFcmDepRptPastClsHisCSQL(), param, null);
			if(iCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Departure Report Error Cleansing Data 삭제
	 * 
	 * @param fcmDepRptErrClsVO
	 * @throws DAOException
	 */
	public void removeFcmDepRptErr(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = fcmDepRptErrClsVO.getColumnValues();
			param.putAll(mapVO);

			int dCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new VesselReportDBDAORemoveFcmDepRptErrDSQL(), param, null);
			if(dCnt == Statement.EXECUTE_FAILED ) throw new DAOException("Fail to Delete SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Departure Report Error Cleansing Data 조회
	 * 
	 * @param fcmDepRptVO
	 * @return List<FcmDepRptVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FcmDepRptVO searchFcmDepRptCls(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmDepRptVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = fcmDepRptErrClsVO.getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchFcmDepRptClsRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FcmDepRptVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0? null:list.get(0);
	}
	
	/**
	 * Departure report Update
	 * 
	 * @param FcmDepRptVO fcmDepRptVO
	 * @exception DAOException
	 */
	public void modifyDepRpt(FcmDepRptVO fcmDepRptVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(fcmDepRptVO != null){
				Map<String, String> mapVO = fcmDepRptVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselReportDBDAOModifyFcmDepRptUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}
