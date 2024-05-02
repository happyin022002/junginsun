/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMasterDataDAO.java
*@FileTitle : Port Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.05.20 서창열
* 1.0 Creation
* 
* History
* 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanalAgencyLaneVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserDefinedLanePortGroupVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 VesselScheduleMasterDataDAO <br>
 * - NIS2010-VesselScheduleMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO CHANG YUL
 * @see VesselScheduleMasterDataBCImpl 참조
 * @since J2EE 1.4
 */
public class VesselScheduleMasterDataDBDAO extends DBDAOSupport {
	
	/**
	 * Port 정보를 조회합니다.
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LocationVO> searchPortList(LocationVO locationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(locationVO != null){
				Map<String, String> mapVO = locationVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMasterDataDBDAOSearchPortListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationVO .class);
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
	 * Port 정보를 수정합니다.
	 * 
	 * @param List<LocationVO> locationVOs
	 * @exception DAOException
	 */
	public void modifyPortList(List<LocationVO> locationVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(locationVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMasterDataDBDAOModifyLocationUSQL(), locationVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * MDM Service Lane에 운하 대리점 코드가 등록되여 있는 정보를 조회한다.<br>
	 * 
	 * @return List<VendorVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VendorVO> searchCanalAgencyList() throws DAOException {
		DBRowSet dbRowset = null;
		List<VendorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMasterDataDBDAOSearchCanalAgencyListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorVO .class);
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
	 * MDM Service Lane에 운하 대리점 코드가 등록되여 있는 정보를 조회한다..<br>
	 * 
	 * @return List<CanalAgencyLaneVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalAgencyLaneVO> searchLaneListByCanalAgency() throws DAOException {
		DBRowSet dbRowset = null;
		List<CanalAgencyLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMasterDataDBDAOSearchLaneListByCanalAgencyRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalAgencyLaneVO .class);
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
	 * 한진 해운이 운하대리점으로 부여한 Vendor Code를 관리한다..<br>
	 * 
	 * @param VendorVO vendorVO
	 * @exception DAOException
	 */
	public void modifyMdmVendor(VendorVO vendorVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			Map<String, String> mapVO = vendorVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAOModifyMdmVendorUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 한진 해운이 LANE CODE별로 운하대리점에 할당한 SERVICE LANE CODE를 등록한다.<br>
	 * 
	 * @param CanalAgencyLaneVO canalAgencyLaneVO
	 * @exception DAOException
	 */
	public void modifyMdmVslSvcLane(CanalAgencyLaneVO canalAgencyLaneVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			Map<String, String> mapVO = canalAgencyLaneVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAOModifyMdmVslSvcLaneUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SERVICE LANE에 대한 Vendor 정보를 등록한다.<
	 * 
	 * @param CanalAgencyLaneVO canalAgencyLaneVO
	 * @exception DAOException
	 */
	public void modifyVskCanalVendor(CanalAgencyLaneVO canalAgencyLaneVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			Map<String, String> mapVO = canalAgencyLaneVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAOModifyVskCanalVendorUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SERVICE LANE에 대한 Vendor 정보를 삭제한다.<br>
	 * 
	 * @param CanalAgencyLaneVO canalAgencyLaneVO
	 * @exception DAOException
	 */
	public void deleteVskCanalVendor(CanalAgencyLaneVO canalAgencyLaneVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			Map<String, String> mapVO = canalAgencyLaneVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAODeleteVskCanalVendorDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 한진 해운이 LANE CODE별로 운하대리점에 할당한 SERVICE LANE CODE에 대해서 운항 통항시 진행 방향을 표시하기 위해 등록한다.<br>
	 * 
	 * @param CanalAgencyLaneVO canalAgencyLaneVO
	 * @exception DAOException
	 */
	public void modifyMdmVslSvcLaneDir(CanalAgencyLaneVO canalAgencyLaneVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;
		
		int result = 0;
		try {
			Map<String, String> mapVO = canalAgencyLaneVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAOModifyMdmVslSvcLaneDirUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * MDM Lane에 대한 사용자별 Lane Group 정보를 조회합니다.
	 * 
	 * @param String usrId
	 * @return List<UserLaneGroupVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UserLaneGroupVO> searchUserLaneGroup(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<UserLaneGroupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(VSKGeneralUtil.isNotNull(usrId)){
				param.put("usr_id", usrId);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMasterDataDBDAOSearchUserLaneGroupRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UserLaneGroupVO.class);
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
	 * User별 Lane Group 정보를 등록합니다.
	 * 
	 * @param UserLaneGroupVO userLaneGroupVO
	 * @exception DAOException
	 */
	public void addVskUsrLaneGrp(UserLaneGroupVO userLaneGroupVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = userLaneGroupVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAOAddVskUsrLaneGrpCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * User별 Lane Group 정보를 수정합니다.
	 * 
	 * @param UserLaneGroupVO userLaneGroupVO
	 * @exception DAOException
	 */
	public void modifyVskUsrLaneGrp(UserLaneGroupVO userLaneGroupVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = userLaneGroupVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAOModifyVskUsrLaneGrpUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * User별 Lane Group 정보를 삭제합니다.
	 * 
	 * @param UserLaneGroupVO userLaneGroupVO
	 * @exception DAOException
	 */
	public void removeVskUsrLaneGrp(UserLaneGroupVO userLaneGroupVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = userLaneGroupVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAORemoveVskUsrLaneGrpDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * MDM Service Lane에 운하 대리점 코드가 등록되여 있는 정보를 조회한다.
	 * 
	 * @param String vndrSeq
	 * @return List<CanalAgencyLaneVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalAgencyLaneVO> searchLaneListByVendor(String vndrSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CanalAgencyLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(VSKGeneralUtil.isNotNull(vndrSeq)){
				param.put("vndr_seq", vndrSeq);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMasterDataDBDAOSearchLaneListByVendorRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalAgencyLaneVO.class);
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
	 * 사용자별 Lane Group 정보를 조회합니다.
	 * 
	 * @param String usrId
	 * @return List<UserLaneGroupVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UserLaneGroupVO> searchLaneGrpByUsrId(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<UserLaneGroupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(VSKGeneralUtil.isNotNull(usrId)){
				param.put("usr_id", usrId);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMasterDataDBDAOSearchLaneGrpByUsrIdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UserLaneGroupVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/** VOP_VSK_0021 OPEN
	 * user별 Group을 조회합니다.
	 * 
	 * @param String usr_id
	 * @return List<UserDefinedLanePortGroupVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UserDefinedLanePortGroupVO> searchLanePortGroupByUserId(String usr_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<UserDefinedLanePortGroupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(VSKGeneralUtil.isNotNull(usr_id)){
				param.put("usr_id", usr_id);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMasterDataDBDAOSearchLanePortGroupByUserIdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UserDefinedLanePortGroupVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/** VOP_VSK_9001 OPEN
	 * User별 Group을 조회합니다
	 * @param String usr_id
	 * @return List<UserDefinedLanePortGroupVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UserDefinedLanePortGroupVO> searchUserDefinedLanePortGroup(String usr_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<UserDefinedLanePortGroupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(VSKGeneralUtil.isNotNull(usr_id)){
				param.put("usr_id", usr_id);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMasterDataDBDAOSearchUserDefLanePortGroupRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UserDefinedLanePortGroupVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/** VOP_VSK_9001 SAVE
	 * User별 Lane Group 정보를 VSK_USR_DEF_COND_HDR테이블에 등록합니다.
	 * 
	 * @param UserDefinedLanePortGroupVO userDefinedLanePortGroupVO
	 * @exception DAOException
	 */
	public void addUserDefinedLanePortGroupHdr(UserDefinedLanePortGroupVO userDefinedLanePortGroupVO) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = userDefinedLanePortGroupVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result  = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAOCreateUserDefinedLanePortGroupHdrCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** VOP_VSK_9001 SAVE
	 * User별 Lane Group 정보를 VSK_USR_DEF_COND_DTL테이블에 등록합니다.
	 * 
	 * @param UserDefinedLanePortGroupVO userDefinedLanePortGroupVO
	 * @exception DAOException
	 */
	public void addUserDefinedLanePortGroupDtl(UserDefinedLanePortGroupVO userDefinedLanePortGroupVO) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = userDefinedLanePortGroupVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAOCreateUserDefinedLanePortGroupDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** VOP_VSK_9001 SAVE
	 * User별 Lane Group 정보를 VSK_USR_DEF_COND_DTL테이블에서 삭제합니다.
	 * 
	 * @param UserDefinedLanePortGroupVO userDefinedLanePortGroupVO
	 * @exception DAOException
	 */
	public void removeUserLanePortGroupDtl(UserDefinedLanePortGroupVO userDefinedLanePortGroupVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = userDefinedLanePortGroupVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAORemoveUserDefinedLanePortGroupDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED )
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** VOP_VSK_9001 SAVE
	 * User별 Lane Group 정보를 VSK_USR_DEF_COND_HDR테이블에서 삭제합니다.
	 * 
	 * @param UserDefinedLanePortGroupVO userDefinedLanePortGroupVO
	 * @exception DAOException
	 */
	public void removeUserLanePortGroupHdr(UserDefinedLanePortGroupVO userDefinedLanePortGroupVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = userDefinedLanePortGroupVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMasterDataDBDAORemoveUserDefinedLanePortGroupHdrDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED )
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}
