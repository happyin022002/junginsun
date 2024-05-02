/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportDBDAO.java
*@FileTitle : VesselReportDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.12
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
* History
* 2012.09.12 이혜민 CHM-201220162-01 [FCM] DSL Report 제거
* 2014.04.07 박다은 CHM-201429498-01 [FCM] Vessel Report Status-Departure Report VMS I/F rule 변경 관련 조치
* 2014.05.19 박다은 [CHM-201429883] [FCM] Departure Report Tap내 mail Function 신설
=========================================================*/
package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.basic.VesselReportBCImpl;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptLogVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptLogVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.SearchMailingListVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslDepRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslDepRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslDepRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

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
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				
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
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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
	 * 주어진 조건에 대한 Lane별 Departure Report Mismatched 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptMssMtchVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<VslDepRptMssMtchVO> searchVslDepRptMssMtch(VslRptInqVO vslRptInqVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslDepRptMssMtchVO> vslDepRptMssMtchVO = null;
		
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOVslDepRptMssMtchVORSQL(), param, velParam);
			vslDepRptMssMtchVO = (List) RowSetUtil.rowSetToVOs(dbRowset, VslDepRptMssMtchVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslDepRptMssMtchVO;
	}
	
	/**
	 * 주어진 조건에 대한 Lane별 ABLog Report 현황을 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslABLogRptVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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
	@SuppressWarnings("unchecked")
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
				
				List<String> vslSlanCdList = new ArrayList();
				List<String> vslCdList = new ArrayList();
				List<String> vpsPortCdList = new ArrayList();
				
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
				
				List<String> vslCdList = new ArrayList();
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
	
//	/**
//	 * VMS0004(Departure Report) EAI로 수신시 특수문자를 찾아서 replace한다.
//	 * 
//	 * @param String depRmk
//	 * @return String
//	 * @exception DAOException
//	 */
//	public String searchSpcCharacterReplace(String depRmk) throws DAOException {
//		DBRowSet dbRowset = null;
//		String depRmkRp = "";
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			param.put("dep_rmk", depRmk);
//			velParam.put("dep_rmk", depRmk);
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchSpcCharacterReplaceRSQL(), param, null);
//			if(dbRowset != null){
//				if(dbRowset.next()){
//					depRmkRp = dbRowset.getString("dep_rmk_rp");
//				}
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return depRmkRp;
//	}
}
