/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneInformationMgtDBDAO.java
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.16 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration.OpfUtilDBDAOVskVslPortVORSQL;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.basic.LaneInformationMgtBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.LaneInfoConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusDeployedVesselVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusVesselVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusServiceVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.VskPortBnkRfuelRtoSheetVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskLanePicVO;
import com.clt.syscommon.common.table.VskPortBnkRfuelRtoVO;


/**
 * NIS2010 LaneInformationMgtDBDAO <br>
 * - NIS2010-VesselOperationSupportMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jang Suk Hyun
 * @see LaneInformationMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class LaneInformationMgtDBDAO extends DBDAOSupport {

	/**
	 * [Lane Group] 정보를 [조회] 합니다.<br>

	 * @param mdmVslSvcLaneVO MdmVslSvcLaneVO
	 * @return List<VskComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneVO> searchLaneGroupList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmVslSvcLaneVO != null){
				Map<String, String> mapVO = mdmVslSvcLaneVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOMdmVslSvcLaneVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO.class);
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
	 * [Lane Group] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<MdmVslSvcLaneVO> mdmVslSvcLaneVOs
	 * @throws DAOException
	 */
	public void modifyLaneGroupS(List<MdmVslSvcLaneVO> mdmVslSvcLaneVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mdmVslSvcLaneVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneInformationMgtDBDAOMdmVslSvcLaneVOUSQL(), mdmVslSvcLaneVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [Lane PIC] 정보를 [조회] 합니다.<br>
	 * 
	 * @param VskLanePicVO vskLanePicVO
	 * @return List<VskLanePicVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskLanePicVO> searchPicList(VskLanePicVO vskLanePicVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskLanePicVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskLanePicVO != null){
				Map<String, String> mapVO = vskLanePicVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOVskLanePicVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskLanePicVO.class);
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
	 * [Lane PIC Max No] 정보를 [조회] 합니다.<br>
	 * 
	 * @param VskLanePicVO vskLanePicVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchMaxPicNo(VskLanePicVO vskLanePicVO) throws DAOException {
		DBRowSet dbRowset = null;
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskLanePicVO != null){
				Map<String, String> mapVO = vskLanePicVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOMaxPicSeqRSQL(), param, velParam);
			if(dbRowset.next())
				result = dbRowset.getInt(1);
			
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
	 * [Exists Bnk RFuel] 정보를 [조회] 합니다.<br>
	 * 
	 * @param vskPortBnkRfuelRtoVO VskPortBnkRfuelRtoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchExistsBnkRFuel(VskPortBnkRfuelRtoVO vskPortBnkRfuelRtoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = vskPortBnkRfuelRtoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOExistsBnkRFuelRSQL(), param, velParam);
			if(dbRowset.next()){
				String sFleuRate = dbRowset.getString(1);

				if(sFleuRate.equals(vskPortBnkRfuelRtoVO.getBnkRfuelRto())){	//기존의 값과 비교해을시 변동이 없을때...
					result = "N";
				}else if(		//기존값은 있고. 들어온 놈이 없어 졌을때...
							!sFleuRate.equals("") && 
							(
								vskPortBnkRfuelRtoVO.getBnkRfuelRto() == null || 
								vskPortBnkRfuelRtoVO.getBnkRfuelRto().equals(""))
							){
					result = "D";
				}else{
					result = "U";
				}
			}else{
				if(vskPortBnkRfuelRtoVO.getBnkRfuelRto() != null && !vskPortBnkRfuelRtoVO.getBnkRfuelRto().equals("")){
					result = "I";
				}
			}
		}catch(SQLException se){
			result = "F";
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			result = "F";
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	 
	/**
	 * [Bunkering Port Header] 정보를 [조회] 합니다.<br>
	 * 
	 * @return List<VskComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskComboVO> searchBunkeringPortHeader() throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VskComboVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOBunkeringPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskComboVO.class);
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
	 * [Bunkering Port] 정보를 [조회] 합니다.<br>
	 * 
	 * @param VskLanePicVO vskLanePicVO
	 * @return List<VskComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortBnkRfuelRtoSheetVO> searchBunkeringPortList(VskLanePicVO vskLanePicVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortBnkRfuelRtoSheetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> aryLocCd = new ArrayList();
		try{
			if(vskLanePicVO != null){
				Map<String, String> mapVO = vskLanePicVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			//Velocity ForEach구문 생성.
			List<VskComboVO> list2 = searchBunkeringPortHeader();
			if(list2 != null){
				for(int cnt = 0; cnt < list2.size(); cnt++){
					aryLocCd.add(list2.get(cnt).getVal());
				}
			}
			
			velParam.put("loc_cd", aryLocCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOVskPortBnkRfuelRtoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortBnkRfuelRtoSheetVO.class);
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
	 * [Lane Status Searvice] 정보를 [조회] 합니다.<br>
	 * 
	 * @param VskLanePicVO vskLanePicVO
	 * @return List<VskComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<StatusServiceVO> searchLaneStatusSearviceList(LaneInfoConditionVO vskLanePicVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StatusServiceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vskLanePicVO != null){
				Map<String, String> mapVO = vskLanePicVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOStatusServiceVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StatusServiceVO.class);
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
	 * [Lane Status Deployed Vessel] 정보를 [조회] 합니다.<br>
	 * 
	 * @param VskLanePicVO vskLanePicVO
	 * @return List<StatusDeployedVesselVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<StatusDeployedVesselVO> searchLaneStatusDeployedVesselList(LaneInfoConditionVO vskLanePicVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StatusDeployedVesselVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vskLanePicVO != null){
				Map<String, String> mapVO = vskLanePicVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOStatusDeployedVesselVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StatusDeployedVesselVO.class);
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
	 * Search lane status vessel info.
	 * 
	 * @param VskLanePicVO vskLanePicVO
	 * @return List<StatusVesselVO>
	 * @throws DAOException
	 */
	public List<StatusVesselVO> searchLaneStatusVesselList(LaneInfoConditionVO vskLanePicVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StatusVesselVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vskLanePicVO != null){
				Map<String, String> mapVO = vskLanePicVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOStatusVesselMainVORSQL(), param, velParam);
			
			list = new ArrayList<StatusVesselVO>();
			while(dbRowset.next()){
				DBRowSet dbRowsetSub = null;
				StatusVesselVO voList = new StatusVesselVO();
				
				voList.setGrp(dbRowset.getString("GRP"));
				voList.setSvcLane(dbRowset.getString("SVC_LANE"));
				voList.setVslClass(dbRowset.getString("VSL_CLASS"));
				voList.setOpt(dbRowset.getString("OPT"));
				voList.setOwn(dbRowset.getString("OWN"));
				voList.setCht(dbRowset.getString("CHT"));
				voList.setOth(dbRowset.getString("OTH"));
				voList.setTtl(dbRowset.getString("TTL"));
				
				param.clear();
				velParam.clear();
				Map<String, String> mapVO = voList.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowsetSub = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOStatusVesselVSLNameVORSQL(), param, velParam);
				
				if(dbRowsetSub.next()){
					voList.setVslNm(dbRowsetSub.getString("VSL_NM"));
				}

				dbRowsetSub = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOStatusVesselOpeningDtVORSQL(), param, velParam);

				if(dbRowsetSub.next()){
					voList.setSvcOpenDt(dbRowsetSub.getString("SVC_OPEN_DT"));
					voList.setPortRot(dbRowsetSub.getString("PORT_ROT"));
					voList.setFre(dbRowsetSub.getString("FRE"));
					voList.setRemark(dbRowsetSub.getString("REMARK"));
				}
				
				list.add(voList);
			}
			
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
	 * [Bunkering Port Header] 정보를 [조회] 합니다.<br>
	 * 
	 * @return List<VskComboVO>
	 * @throws DAOException
	 */
	public List<VskComboVO> searchPicRsoList() throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VskComboVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOScgRgnShpOprCdRSQL(), param, velParam);
			
			list = new ArrayList<VskComboVO>();
			while(dbRowset.next()){
				VskComboVO tempCom = new VskComboVO(); 
				
				tempCom.setName(dbRowset.getString("VAL") + "\t" + dbRowset.getString("NAME"));
				tempCom.setVal(dbRowset.getString("VAL"));
				
				list.add(tempCom);
			}
			
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
	 * [Lane Pic] 정보를 [추가] 합니다.<br>
	 * 
	 * @param VskLanePicVO vskLanePicVO
	 * @throws DAOException
	 */
	public void addLanePic(VskLanePicVO vskLanePicVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			/*
			  int insCnt = 0;
			  if(insModels.size() > 0){
				//insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneInformationMgtDBDAOVskLanePicVOCSQL(), insModels,null);
				insCnt = sqlExe.executeUpdate((ISQLTemplate)new LaneInformationMgtDBDAOVskLanePicVOCSQL(), insModels, insModels);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}*/
			Map<String, String> mapVO = vskLanePicVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneInformationMgtDBDAOVskLanePicVOCSQL(), mapVO, velParam);
				
			if(result == Statement.EXECUTE_FAILED) {
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
	 
	/**
	 * [Lane Pic] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<VskLanePicVO> vskLanePicVOs
	 * @throws DAOException
	 */
	public void modifyLanePicS(List<VskLanePicVO> vskLanePicVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskLanePicVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneInformationMgtDBDAOVskLanePicVOUSQL(), vskLanePicVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [Lane Pic] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<VskLanePicVO> vskLanePicVOs
	 * @throws DAOException
	 */
	public void removeLanePicS(List<VskLanePicVO> vskLanePicVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskLanePicVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneInformationMgtDBDAOVskLanePicVODSQL(), vskLanePicVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [Lane Bukering Port] 정보를 [추가] 합니다.<br>
	 * 
	 * @param List<VskPortBnkRfuelRtoVO> vskPortBnkRfuelRtoVOs
	 * @throws DAOException
	 */
	public void addBunkeringPortS(List<VskPortBnkRfuelRtoVO> vskPortBnkRfuelRtoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskPortBnkRfuelRtoVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneInformationMgtDBDAOVskPortBnkRfuelRtoVOCSQL(), vskPortBnkRfuelRtoVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [Lane Bukering Port] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<VskPortBnkRfuelRtoVO> vskPortBnkRfuelRtoVOs
	 * @throws DAOException
	 */
	public void modifyBunkeringPortS(List<VskPortBnkRfuelRtoVO> vskPortBnkRfuelRtoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskPortBnkRfuelRtoVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneInformationMgtDBDAOVskPortBnkRfuelRtoVOUSQL(), vskPortBnkRfuelRtoVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [Lane Bukering Port] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<VskPortBnkRfuelRtoVO> vskPortBnkRfuelRtoVOs
	 * @throws DAOException
	 */
	public void removeBunkeringPortS(List<VskPortBnkRfuelRtoVO> vskPortBnkRfuelRtoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskPortBnkRfuelRtoVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneInformationMgtDBDAOVskPortBnkRfuelRtoVODSQL(), vskPortBnkRfuelRtoVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [Lane Bukering Port] 정보를 [추가] 합니다.<br>
	 * 
	 * @param List<VskPortBnkRfuelRtoSheetVO> vskPortBnkRfuelRtoSheetVOs
	 * @throws DAOException
	 */
	public void removeBunkeringPortLaneS(List<VskPortBnkRfuelRtoSheetVO> vskPortBnkRfuelRtoSheetVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskPortBnkRfuelRtoSheetVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneInformationMgtDBDAOVskPortBnkRfuelRtoVOLaneDSQL(), vskPortBnkRfuelRtoSheetVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [Lane PIC] 정보를 [조회] 합니다.<br>
	 * 
	 * @param VskLanePicVO vskLanePicVO
	 * @return List<VskLanePicVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskLanePicVO> checkPicList(VskLanePicVO vskLanePicVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskLanePicVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskLanePicVO != null){
				Map<String, String> mapVO = vskLanePicVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneInformationMgtDBDAOCheckVskLanePicVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskLanePicVO.class);
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