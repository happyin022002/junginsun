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
* 
* 2014.03.17 박다은 [CHM-201428939-01] vessel particular - performance 
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.basic.VesselInformationMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DockPlanListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LoadFactorListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LoadableListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LowestListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.MdmVslCntrExcelVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.PerformanceInfoVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPerformanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselLoadableInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

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
		 * Operation 을 조회 합니다.<br>
		 * 
		 * @param vesselInformationMgtConditionVO
		 * @return
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public VSLPerformanceVO searchVSLPerformance(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<VSLPerformanceVO> list = null;
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAOVSLPerformanceVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, VSLPerformanceVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return list.size()==0?new VSLPerformanceVO():list.get(0);		
		}
		 
		 /**
		  * RPM& Slow Steaming 을 조회 합니다.<br>
		  * 
		 * @param vesselInformationMgtConditionVO
		 * @return
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		 public VSLPerformanceVO searchVSLPerformanceDetail(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<VSLPerformanceVO> list = null;
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
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAOVSLPerformanceDetailVORSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VSLPerformanceVO .class);
			 }catch(SQLException se){
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage());
			 }catch(Exception ex){
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage());
			 }
			 
			 return list.size()==0?new VSLPerformanceVO():list.get(0);		
		 }
		
		 /**
		  * Lowest Plan 을 조회 합니다.<br>
		  * 
		 * @param vesselInformationMgtConditionVO
		 * @return
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		 public List<LowestListVO> searchLowestList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<LowestListVO> list = null;
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
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAOLowestListVORSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, LowestListVO .class);
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
		  * Load Factor List 을 조회 합니다.<br>
		  * 
		 * @param vesselInformationMgtConditionVO
		 * @return
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		 public List<LoadFactorListVO> searchLoadFactorList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<LoadFactorListVO> list = null;
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
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAOLoadFactorListVORSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, LoadFactorListVO .class);
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
		  * Loadable List 을 조회 합니다.<br>
		  * 
		 * @param vesselInformationMgtConditionVO
		 * @return
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		 public List<LoadableListVO> searchLoadableList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<LoadableListVO> list = null;
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
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAOLoadableListVORSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, LoadableListVO .class);
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
		  * Loadble Info 를 조회한다.
		  * 
		 * @param vesselLoadableInfoVO
		 * @return
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		 public List<VesselLoadableInfoVO> searchLoadableInfoList(VesselLoadableInfoVO vesselLoadableInfoVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<VesselLoadableInfoVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 if(vesselLoadableInfoVO != null){
					 Map<String, String> mapVO = vesselLoadableInfoVO .getColumnValues();
					 
					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				 }
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAOLoadableInfoListVORSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselLoadableInfoVO .class);
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
			 * Performance 정보를 저장한다.
			 * 
			 * @param performanceInfoVO
			 * @throws DAOException
			 */
			public void addPerformanceInfo(PerformanceInfoVO performanceInfoVO) throws DAOException {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					if (performanceInfoVO != null) {
						Map<String, String> mapVO = performanceInfoVO .getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					SQLExecuter sqlExe = new SQLExecuter("");
						int result = sqlExe.executeUpdate((ISQLTemplate)new  VesselInformationMgtDBDAOPerformanceInfoVOCSQL(), param, velParam);
						
						if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert SQL");
				} catch(SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch(Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				} 
			}
			
			/**
			 * Vessel Particular2의 Tier 정보를 저장한다.
			 * 
			 * @param performanceInfoVO
			 * @throws DAOException
			 */
			public void modifyMdmVesselParticularInfo(PerformanceInfoVO performanceInfoVO) throws DAOException {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					if (performanceInfoVO != null) {
						Map<String, String> mapVO = performanceInfoVO .getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					SQLExecuter sqlExe = new SQLExecuter("");
						int result = sqlExe.executeUpdate((ISQLTemplate)new  VesselInformationMgtDBDAOmodifyMdmVslCntrUSQL(), param, velParam);
						
						if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert SQL");
				} catch(SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch(Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				} 
			}
			
		 
			/**
			 * Loadable Info 를 저장한다.
			 * 
			 * @param vesselLoadableInfoVO
			 * @throws DAOException
			 * @throws Exception
			 */
			public void addVesselLoadableInfo(List<VesselLoadableInfoVO> vesselLoadableInfoVO) throws DAOException, Exception {

				try {
					SQLExecuter sqlExe = new SQLExecuter("");
					if (vesselLoadableInfoVO.size() > 0) {
						for(int i = 0; i<vesselLoadableInfoVO.size(); i++){
							Map<String, Object> param = new HashMap<String, Object>();
							Map<String, String> mapVO = vesselLoadableInfoVO.get(i).getColumnValues();
							param.putAll(mapVO);
							sqlExe.executeUpdate((ISQLTemplate)new VesselInformationMgtDBDAOVesselLoadableInfoVOCSQL(), param, null);
						}
					}
					
				} catch(SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch(Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
			}
			
			
			/**
			 * Loadable Info 를 삭제한다.
			 * 
			 * @param vesselLoadableInfoVO
			 * @return
			 * @throws DAOException
			 * @throws Exception
			 */
			public int deleteVesselLoadableInfo(VesselLoadableInfoVO vesselLoadableInfoVO) throws DAOException,Exception {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				int result = 0;
				try {
					if(vesselLoadableInfoVO != null){
						Map<String, String> mapVO = vesselLoadableInfoVO.getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}

					SQLExecuter sqlExe = new SQLExecuter("");
					result = sqlExe.executeUpdate((ISQLTemplate)new VesselInformationMgtDBDAOVesselLoadableInfoVODSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete SQL");
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
			 * Vessel Summary 정보를 조회한다.<br>
			 * 
			 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
			 * @return List<VSLPartIVO>
			 * @throws DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<VSLPartIVO> searchVesselSummary(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws DAOException {
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
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselInformationMgtDBDAOVesselSummaryInfoListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, VSLPartIVO .class);
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