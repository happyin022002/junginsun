/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselInformationMgtDBDAO.java
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.22 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration.SalesActivityManageDBDAOAddSalesReportInfoCSQL;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.basic.VesselInformationMgtBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DockPlanListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DraftWeightListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.MdmVslCntrExcelVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 VesselInformationMgtDBDAO <br>
 * - NIS2010-VesselOperationSupportMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong Ock
 * @see VesselInformationMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class VesselInformationMgtDBDAO extends DBDAOSupport {
	/**
	 * Particular I, Particular II 을 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return VSLPartIVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public VSLPartIVO searchVSLPartI(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VSLPartIVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vesselInformationMgtConditionVO != null){
				Map<String, String> mapVO = vesselInformationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAOVSLPartIVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VSLPartIVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list.size()==0?new VSLPartIVO():list.get(0);		
	}
	/**
	 * Particular I, Particular II 을 엑셀파일로 출력하기 위해 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return List<MdmVslCntrExcelVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVslCntrExcelVO> searchVSLPartIList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslCntrExcelVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vesselInformationMgtConditionVO != null){
				Map<String, String> mapVO = vesselInformationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAOMdmVslCntrExcelVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrExcelVO .class);
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
	 * Dock Plan 을 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return List<DockPlanListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DockPlanListVO> searchDockPlanList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DockPlanListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vesselInformationMgtConditionVO != null){
				Map<String, String> mapVO = vesselInformationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAODockPlanListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DockPlanListVO .class);
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
	* Retrieve Draft & Weight<br>
	* 
	* @return List<DraftWeightListVO>
	* @throws DAOException
    */
	 @SuppressWarnings("unchecked")
	 public List<DraftWeightListVO> searchDraftWeightList() throws DAOException {
		DBRowSet dbRowset = null;
		List<DraftWeightListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAOSearchDraftWeightListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DraftWeightListVO .class);
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
	* Save Draft & Weight<br>
    * 
	* @param List<DraftWeightListVO> subDraftWeightVOs
	* @throws DAOException
	*/
	@SuppressWarnings("unchecked") 
	public void addDraftWeightList(List<DraftWeightListVO> subDraftWeightVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(subDraftWeightVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselInformationMgtDBDAOAddDraftWeightListVOCSQL(), subDraftWeightVOs,null);
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
	* Retrieve Draft & Weight<br>
	* 
    * @param String vslCd
	* @return String
	* @throws DAOException
    */
	 @SuppressWarnings("unchecked")
	 public String searchVslCode(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVslCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vslCd != null){
					param.put("vsl_cd", vslCd);
					velParam.put("vsl_cd", vslCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAOSearchVslCodeRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnVslCd = dbRowset.getString("VSL_CD");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnVslCd;
	}
	
	
	/**
	* Delete Draft & Weight.<br>
	* 
	* @param List<DraftWeightListVO> subDraftWeightVOs
	* @throws DAOException
	*/
	@SuppressWarnings("unchecked") 
	public void removeDraftWeightList(List<DraftWeightListVO> subDraftWeightVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			for(int i = 0; i < subDraftWeightVOs.size(); i++){
				String vslCd = subDraftWeightVOs.get(i).getVslCd();
				String mtxSeq = subDraftWeightVOs.get(i).getMtxSeq();
				if(vslCd != null && mtxSeq != null) {
					param.put("vsl_cd", vslCd);
					velParam.put("vsl_cd", vslCd);
					param.put("mtx_seq", mtxSeq);
					velParam.put("mtx_seq", mtxSeq);
					sqlExe.executeUpdate((ISQLTemplate)new VesselInformationMgtDBDAORemoveDraftWeightListDSQL(), param, velParam);
				}
				
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		

	 
}