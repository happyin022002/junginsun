
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAO.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.basic.TonnageTaxOutputMasterDataMgtBCImpl;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.LaneVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.MissLaneChkVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.NrtBsaChgVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.PndlmPortVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TotVesselVO;
import com.hanjin.syscommon.common.table.TotBsaVO;
/**
 * ALPS TonnageTaxOutputMasterDataMgtDBDAO <br>
 * - ALPS-TonnageTaxOutput system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jang Chang Soo
 * @see TonnageTaxOutputMasterDataMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class TonnageTaxOutputMasterDataMgtDBDAO extends DBDAOSupport {

	/**
	 * VESSEL 정보를 조회한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @return List<VslVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VslVO> searchUseTonnageVesselList(VslVO vslVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslVO != null){
				Map<String, String> mapVO = vslVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");   
           // SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0001 DAQ > search 진입:::::::::");
            TonnageTaxOutputMasterDataMgtDBDAOVesselVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAOVesselVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslVO .class);
			log.debug("::CALL::> FNS_TOT_0001 DAQ > 끝:::::::::");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * 30일이상 사용하지 않은 VESSEL 정보를 조회한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @return List<VslVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
		public List<VslVO> searchUnusedVesselList(VslVO vslVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<VslVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vslVO != null){
					Map<String, String> mapVO = vslVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	            log.debug("::CALL::> FNS_TOT_0003 DAQ > search 진입:::::::::");
	            TonnageTaxOutputMasterDataMgtDBDAOUnusedTotVesselVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAOUnusedTotVesselVORSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslVO .class);
				log.debug("::CALL::> FNS_TOT_0003 DAQ > 끝:::::::::");
			}catch(SQLException ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
			return list;
		}

		 
		/**
		 * VESSEL 정보의 가장 최근 업데이트된 날짜조회한다. <br>
		 * 
		 * @param VslVO vslVO
		 * @return List<VslVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<VslVO> searchRecentUpdateDt(VslVO vslVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<VslVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vslVO != null){
					Map<String, String> mapVO = vslVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	            log.debug("::CALL::> FNS_TOT_0001 DAQ > search recent dt진입:::::::::");
	            TonnageTaxOutputMasterDataMgtDBDAORcUpVesselVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAORcUpVesselVORSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslVO .class);
			}catch(SQLException ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
			return list;
		}

	 
		/**
		 * VESSEL 정보를 추가한다. <br>
		 * 
		 * @param TotVesselVO totVesselVO
		 * @exception DAOException
		 */
		
	public void addUseTonnageVessel (TotVesselVO totVesselVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = totVesselVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            
			//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL();
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * VESSEL 정보를 수정한다. <br>
	 * 
	 * @param TotVesselVO totVesselVO
	 * @return int
	 * @exception DAOException
	 
	public int modifymanageUseTonnageVessel (TotVesselVO totVesselVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = totVesselVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL();
			
            result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return result;
	}
	*/
	/**
	 * VESSEL 정보를 삭제한다. <br>
	 * 
	 * @param TotVesselVO totVesselVO
	 * @return int
	 * @exception DAOException
	 
	public int removemanageUseTonnageVessel (TotVesselVO totVesselVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = totVesselVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL();
            log.debug("::CALL::> vsl_seq 단건> :::::::::" +totVesselVO.getVslSeq());
			result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return result;
	}
	*/
	/**
	 * VESSEL 정보를 수정한다. <br>
	 * 
	 * @param List<TotVesselVO> totVesselVOs
	 * @exception DAOException
	 */
	public void modifyUseTonnageVessel(List<TotVesselVO> totVesselVOs) throws DAOException,Exception {
		try {
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL();
			int updCnt[] = null;
			if(totVesselVOs.size() > 0){
				//updCnt = sqlExe.executeBatch(template, updModels, null);
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL(), totVesselVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * VESSEL 정보를 삭제한다. <br>
	 * 
	 * @param List<TotVesselVO> totVesselVOs
	 * @exception DAOException
	 */
	public void removeUseTonnageVessel(List<TotVesselVO> totVesselVOs) throws DAOException,Exception {
		try {
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL();
			
			int delCnt[] = null;
			if(totVesselVOs.size() > 0){
				//delCnt = sqlExe.executeBatch(template, delModels, null);
			
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL(), totVesselVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					log.debug("::CALL::> vsl_seq 다건> :::::::::" +totVesselVOs.get(i).getVslSeq());
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	/**
	 * 30일이상 사용하지 않은 VESSEL 정보를 추가한다. <br>
	 * 
	 * @param TotVesselVO totVesselVO
	 * @exception DAOException
	 */
	public void addUnusedVessel (TotVesselVO totVesselVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = totVesselVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            
			//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL();
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOUnusedTotVesselVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
	}
	

	/**
	 * 30일이상 사용하지 않은 VESSEL 정보를 수정한다. <br>
	 * 
	 * @param List<TotVesselVO> totVesselVOs
	 * @exception DAOException
	 */
	public void modifyUnusedVessel(List<TotVesselVO> totVesselVOs) throws DAOException,Exception {
		try {
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL();
			int updCnt[] = null;
			if(totVesselVOs.size() > 0){
				//updCnt = sqlExe.executeBatch(template, updModels, null);
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOUnusedTotVesselVOUSQL(), totVesselVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * 30일이상 사용하지 않은 VESSEL 정보를 삭제한다. <br>
	 * 
	 * @param List<TotVesselVO> totVesselVOs
	 * @exception DAOException
	 */
	public void removeUnusedVessel(List<TotVesselVO> totVesselVOs) throws DAOException,Exception {
		try {
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL();
			
			int delCnt[] = null;
			if(totVesselVOs.size() > 0){
				//delCnt = sqlExe.executeBatch(template, delModels, null);
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOUnusedTotVesselVODSQL(), totVesselVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	/**
	 * [VSL_PORT_SKD] 테이블 기준대상 Lane의 Trade정보를 조회한다. <br>
	 * 
	 * @param LaneVO laneVO
	 * @return List<LaneVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LaneVO> searchLaneTradeGroupList(LaneVO laneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(laneVO != null){
				Map<String, String> mapVO = laneVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0004 DAQ > search 진입:::::::::");
            TonnageTaxOutputMasterDataMgtDBDAOLaneGroupVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAOLaneGroupVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LaneVO .class);
			log.debug("::CALL::> FNS_TOT_0004 DAQ > 끝:::::::::");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * copy를 위한 [VSL_PORT_SKD] 테이블 기준대상 Lane의 Trade정보를 조회한다. <br>
	 * 
	 * @param LaneVO laneVO
	 * @return List<LaneVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LaneVO> searchLaneTradeGroupForCopyList(LaneVO laneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(laneVO != null){
				Map<String, String> mapVO = laneVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0004 DAQ > search 진입:::::::::");
            TonnageTaxOutputMasterDataMgtDBDAOLaneGroupForCopyVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAOLaneGroupForCopyVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LaneVO .class);
			log.debug("::CALL::> FNS_TOT_0004 DAQ > 끝:::::::::");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
	/**
	 * [VSL_PORT_SKD] 테이블 기준대상 Lane의 Trade정보의 최근업데이트일자를 조회한다. <br>
	 * 
	 * @param LaneVO laneVO
	 * @return List<LaneVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
		public List<LaneVO> searchRcLaneUpdateDt(LaneVO laneVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<LaneVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(laneVO != null){
					Map<String, String> mapVO = laneVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	            log.debug("::CALL::> FNS_TOT_0001 DAQ > search recent dt진입:::::::::");
	            TonnageTaxOutputMasterDataMgtDBDAORcUpLaneVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAORcUpLaneVORSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, LaneVO .class);
			}catch(SQLException ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
			return list;
		}

		/**
		 * Lane의 Trade정보를(TOT_LANE) 추가한다. <br>
		 * 
		 * @param List<LaneVO> laneVOs
		 * @exception DAOException
		 */
			public void addLaneTradeGroup(List<LaneVO> laneVOs) throws DAOException,Exception {
				try {
					log.debug("::CALL::> FNS_TOT_0001 DAQ > 진입-----:::::::::");
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
					//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL();
					int insCnt[] = null;

					log.debug("::CALL::> FNS_TOT_0001 DAQ >IB_FLAG : I 존재:::::::::");

					if(laneVOs.size() > 0){
						log.debug("::CALL::> FNS_TOT_0001 DAQ >IB_FLAG : I 존재:::::::::");
						insCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneGroupVOCSQL(), laneVOs,null);
						//insCnt = sqlExe.executeBatch(template, insModels, null);
						for(int i = 0; i < insCnt.length; i++){
							if(insCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}

					}
				} catch (SQLException ex) {
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
			}
			
			/**
			 * Lane의 Trade정보를(TOT_LANE) 수정한다. <br>
			 * 
			 * @param List<LaneVO> laneVOs
			 * @exception DAOException
			 */
			public void modifyLaneTradeGroup(List<LaneVO> laneVOs) throws DAOException,Exception {
				try {
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
					//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL();
					int updCnt[] = null;
					if(laneVOs.size() > 0){
						//updCnt = sqlExe.executeBatch(template, updModels, null);
						updCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneGroupVOUSQL(), laneVOs,null);
						for(int i = 0; i < updCnt.length; i++){
							if(updCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}
						
						
					}
				} catch (SQLException ex) {
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
			}
			
			/**
			 * Lane의 Trade정보를(TOT_LANE) 삭제한다. <br>
			 * 
			 * @param List<LaneVO> laneVOs
			 * @exception DAOException
			 */
			public void removeLane(List<LaneVO> laneVOs) throws DAOException,Exception {
				
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				try {
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
					
					int delCnt[] = null;

					velParam.put("sts_flg","R");
					
					if(laneVOs.size() > 0){
						delCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneGroupVODSQL(), laneVOs,velParam);
						for(int i = 0; i < delCnt.length; i++){
							if(delCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No"+ i + " SQL");
						}
					}
				} catch (SQLException ex) {
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
			}

			/**
			 * Lane의 Trade정보를(TOT_LANE_TRD) 삭제한다. <br>
			 * 
			 * @param List<LaneVO> laneVOs
			 * @exception DAOException
			 */
			public void removeLaneTrd(List<LaneVO> laneVOs) throws DAOException,Exception {
				
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				try {
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
					int delTrdCnt[] = null;

					velParam.put("sts_flg","R");
					
					if(laneVOs.size() > 0){
						delTrdCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdVODSQL(), laneVOs,velParam);
						for(int i = 0; i < delTrdCnt.length; i++){
							//log.debug("::CALL::> vsl_seq 다건> :::::::::" +delModels.get(i).getVslSeq());
							if(delTrdCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No"+ i + " SQL");
						}
						
						
					}
				} catch (SQLException ex) {
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
			}
			
			/**
			 * 전월의 Lane의 Trade정보 copy를 위해 해당년월 정보를 삭제한다. <br>
			 * 
			 * @param LaneVO laneVO
			 * @return int
			 * @exception DAOException
			 */
			public int removeLaneTradeGroupForCopy(LaneVO laneVO) throws DAOException,Exception {
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					//velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();
					
					int result = 0;
			
					try {
						laneVO.setStsFlg("D");
						Map<String, String> mapVO = laneVO.getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);

			            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
						//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL();
		            
						
						sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdVODSQL(), param, velParam);

						result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneGroupVODSQL(), param, velParam);

						if(result == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert SQL");
						}
						
					} catch (SQLException ex) {
						//log.error(ex.getMessage(),ex);
						throw new DAOException(ex.getMessage(), ex);
					}catch(Exception ex){
						//log.error(ex.getMessage(),ex);
						throw new DAOException(ex.getMessage(), ex);
					}
					return result;
				}
			
	/**
	 * Lane의 Trade정보를(TOT_LANE_TRD) 추가한다. <br>
	 * 
	 * @param List<LaneVO> laneVOs
	 * @exception DAOException
	 */
	public void addLaneTradeCd (List<LaneVO> laneVOs) throws DAOException,Exception {

		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			log.debug("::CALL::> addmanageLaneTradeCd> 진입-----:::::::::");
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL();
		//	int insCnt[] = null;
		//	int insTrdCnt[] = null;
			log.debug("::CALL::> addmanageLaneTradeCd >IB_FLAG : I 존재:::::::::"+laneVOs.size());
			LaneVO lnVO = new LaneVO();
			if(laneVOs.size() > 0){
				
				
				for(int i=0; i<laneVOs.size(); i++){
					
					lnVO =  laneVOs.get(i);
					
					Map<String, String> mapVO = lnVO.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					
		          //  SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
		            
					log.debug("::CALL::> addmanageLaneTradeCd vo.getTrdCd1()> :::::::::" +lnVO.getTrdCd1());
		           
					if(!(lnVO.getTrdCd1() == null || lnVO.getTrdCd1().equals(""))){
						log.debug("::CALL::> 1 들어옴");
						mapVO.put("trd_cd", lnVO.getTrdCd1());
						//mapVO.get("trd_cd1");
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						
						int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdVOCSQL(), param, velParam);
						if(trd_result == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert SQL");
						}						
					}
					
					log.debug("::CALL::> addmanageLaneTradeCd vo.getTrdCd2()> :::::::::" +lnVO.getTrdCd2());
				   
					if(!(lnVO.getTrdCd2() == null || lnVO.getTrdCd2().equals(""))){
						log.debug("::CALL::> 2 들어옴");
						mapVO.put("trd_cd", lnVO.getTrdCd2());
						
						//mapVO.get("trd_cd1");
						param.putAll(mapVO);
						velParam.putAll(mapVO);

						int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdVOCSQL(), param, velParam);
						if(trd_result == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert SQL");
						}						
					}
					log.debug("::CALL::> addmanageLaneTradeCd vo.getTrdCd3()> :::::::::" +lnVO.getTrdCd3());
					
					if(!(lnVO.getTrdCd3() == null || lnVO.getTrdCd3().equals(""))){
						log.debug("::CALL::> 3 들어옴");
						mapVO.put("trd_cd", lnVO.getTrdCd3());
						//mapVO.get("trd_cd1");
						param.putAll(mapVO);
						velParam.putAll(mapVO);

						int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdVOCSQL(), param, velParam);
						if(trd_result == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert SQL");
						}						
						
					}

				}

      
				
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		
		
	}

	
	/**
	 * Lane의 Trade정보를(TOT_LANE_TRD) 수정한다. <br>
	 * 
	 * @param List<LaneVO> laneVOs
	 * @exception DAOException
	 */
	public void modifyLaneTradeCd (List<LaneVO> laneVOs) throws DAOException,Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");

            LaneVO upVO = new LaneVO();		
			if(laneVOs.size() > 0){
				
				for(int i=0; i<laneVOs.size(); i++){
					
					upVO =  laneVOs.get(i);

					Map<String, String> mapVO = upVO.getColumnValues();
					
			
					if(!(upVO.getTrdCd1() == null || upVO.getTrdCd1().equals(""))){
						log.debug("::CALL 다건::> 1 들어옴");
						 
						 mapVO.put("trd_cd", upVO.getTrdCd1());

						if(upVO.getTrdCd1Seq() == null || upVO.getTrdCd1Seq().equals("")){
							// 해당 trd_cd가 없는경우  추가
							log.debug("::CALL 다건::> 1  해당 trd_cd가 새로 추가되는 경우");
							mapVO.put("cre_usr_id", upVO.getUpdUsrId());
							param.putAll(mapVO);
							velParam.putAll(mapVO);
	                        
							int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdVOCSQL(), param, velParam);
							if(trd_result == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to insert SQL");
							}	
						}else{
							// 해당 trd_cd가 있는경우  수정
							log.debug("::CALL 다건::> 1  해당 trd_cd가 수정되는 경우");
							
							mapVO.put("lane_seq", upVO.getTrdCd1Seq());
							param.putAll(mapVO);
							velParam.putAll(mapVO);
							
							int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdVOUSQL(), param, velParam);
							
							if(trd_result == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to insert SQL");
							}		
							
						}
						
				
					}else{
						if(!(upVO.getOldTrdCd1() == null || upVO.getOldTrdCd1().equals(""))){
							// 해당 trd_cd가 없는경우  추가
							log.debug("::CALL 다건::> 1  해당 trd_cd가 삭제되는 경우");
							mapVO.put("trd_cd", upVO.getOldTrdCd1());
							mapVO.put("lane_seq", upVO.getTrdCd1Seq());
							param.putAll(mapVO);
							velParam.putAll(mapVO);
							
							int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdOneVODSQL(), param, velParam);
							if(trd_result == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to delete SQL");
							}							
						}					
					}

					if(!(upVO.getTrdCd2() == null || upVO.getTrdCd2().equals(""))){
						log.debug("::CALL 다건::> 2 들어옴");
						
						 mapVO.put("trd_cd", upVO.getTrdCd2());
                      
						if(upVO.getTrdCd2Seq() == null || upVO.getTrdCd2Seq().equals("")){
							// 해당 trd_cd가 없는경우  추가
							log.debug("::CALL 다건::> 2  해당 trd_cd가 없는경우  추가");
							mapVO.put("cre_usr_id", upVO.getUpdUsrId());
 
							param.putAll(mapVO);
							velParam.putAll(mapVO);
							
							int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdVOCSQL(), param, velParam);
							if(trd_result == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to insert SQL");
							}	
						}else{
							// 해당 trd_cd가 있는경우  수정
							log.debug("::CALL 다건::> 2  해당 trd_cd가 있는경우  수정");
							
							mapVO.put("lane_seq", upVO.getTrdCd2Seq());
							param.putAll(mapVO);
							velParam.putAll(mapVO);
							
							int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdVOUSQL(), param, velParam);
							
							if(trd_result == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to insert SQL");
							}		
							
						}
						
				
					}else{
						if(!(upVO.getOldTrdCd2() == null || upVO.getOldTrdCd2().equals(""))){
							// 해당 trd_cd가 없는경우  추가
							log.debug("::CALL 다건::> 2  해당 trd_cd가 삭제되는 경우");
							mapVO.put("trd_cd", upVO.getOldTrdCd2());
							mapVO.put("lane_seq", upVO.getTrdCd2Seq());
							param.putAll(mapVO);
							velParam.putAll(mapVO);
							
							int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdOneVODSQL(), param, velParam);
							if(trd_result == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to delete SQL");
							}							
						}					
					}

					if(!(upVO.getTrdCd3() == null || upVO.getTrdCd3().equals(""))){
						log.debug("::CALL 다건::> 3 들어옴");
						 mapVO.put("trd_cd", upVO.getTrdCd3());
	                      
						if(upVO.getTrdCd3Seq() == null || upVO.getTrdCd3Seq().equals("")){
							// 해당 trd_cd가 없는경우  추가
							log.debug("::CALL 다건::> 3  해당 trd_cd가 없는경우  추가");
							mapVO.put("cre_usr_id", upVO.getUpdUsrId());
							
							param.putAll(mapVO);
							velParam.putAll(mapVO);

							int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdVOCSQL(), param, velParam);
							if(trd_result == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to insert SQL");
							}	
						}else{
							// 해당 trd_cd가 있는경우  수정
							log.debug("::CALL 다건::> 3  해당 trd_cd가 있는경우  수정");
							mapVO.put("lane_seq", upVO.getTrdCd3Seq());
							param.putAll(mapVO);
							velParam.putAll(mapVO);

							
							int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdVOUSQL(), param, velParam);
							
							if(trd_result == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to insert SQL");
							}		
							
						}
						
				
					}else{
						if(!(upVO.getOldTrdCd3() == null || upVO.getOldTrdCd3().equals(""))){
							// 해당 trd_cd가 없는경우  추가
							log.debug("::CALL 다건::> 3  해당 trd_cd가 삭제되는 경우");
							mapVO.put("trd_cd", upVO.getOldTrdCd3());
							mapVO.put("lane_seq", upVO.getTrdCd3Seq());
							param.putAll(mapVO);
							velParam.putAll(mapVO);
							
							int trd_result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOLaneTrdOneVODSQL(), param, velParam);
							if(trd_result == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to delete SQL");
							}							
						}					
					} 
				}   // end for
				
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		
	}

	/**
	 * Pendulm port Start Port List, End Port List 정보를 조회한다. <br>
	 * 
	 * @param PndlmPortVO pndlmPortVO
	 * @return List<PndlmPortVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PndlmPortVO> searchPendulumLanePortCodeList (PndlmPortVO pndlmPortVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PndlmPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pndlmPortVO != null){
				Map<String, String> mapVO = pndlmPortVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0008 DAQ > search 진입:::::::::");
            TonnageTaxOutputMasterDataMgtDBDAOPendulumServicePortVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAOPendulumServicePortVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PndlmPortVO .class);
			log.debug("::CALL::> FNS_TOT_0008 DAQ > 끝:::::::::");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	 
	/**
	 * Pendulm port Start Port List, End Port List 정보의 최근업데이트된 날짜를 조회한다. <br>
	 * 
	 * @param PndlmPortVO pndlmPortVO
	 * @return List<PndlmPortVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PndlmPortVO> searchPendulumRecentUpdateDt(PndlmPortVO pndlmPortVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PndlmPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pndlmPortVO != null){
				Map<String, String> mapVO = pndlmPortVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0008 DAQ > search recent dt진입:::::::::");
            TonnageTaxOutputMasterDataMgtDBDAORcUpPndlmVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAORcUpPndlmVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PndlmPortVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * Pendulm port Start Port List, End Port List 정보를 추가한다.<br>
	 * 
	 * @param PndlmPortVO pndlmPortVO
	 * @return int 
	 * @exception DAOException
	 */
		public int addStartEndPorts (PndlmPortVO pndlmPortVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result =0;
			try {
				Map<String, String> mapVO = pndlmPortVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	            
				//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL();
				
				result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOPendulumServicePortVOCSQL(), param, velParam);
				log.debug("result :::::::::::::::::::::::::::::::::::::"+result);
				if(result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			} catch (SQLException ex) {
				if(ex.getErrorCode()==1){
					log.debug("error code :::::::::::::::::::::::::::::::::::::"+ex.getErrorCode());
				    return -999;
				}else{
				//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
		    return result;
		}
		

		/**
		 * Pendulm port Start Port List, End Port List 정보를 추가한다.<br>
		 * 
		 * @param List<PndlmPortVO> pndlmPortVOs
		 * @exception DAOException
		 
		public void addStartEndPorts (List<PndlmPortVO> pndlmPortVOs) throws DAOException,Exception {
			try {

				log.debug("::CALL::> FNS_TOT_0008 DAQ >IB_FLAG : I 존재:::::::::");
				if(pndlmPortVOs.size() > 0){
					log.debug("::CALL::> FNS_TOT_0008 DAQ >IB_FLAG : I 존재:::::::::");
					
					for(int k=0; k<pndlmPortVOs.size(); k++){
						PndlmPortVO vo = pndlmPortVOs.get(k);
						addStartEndPorts (vo);
					}
				}
			} catch (SQLException ex) {
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
		}
*/
		/**
		 * Pendulm port Start Port List, End Port List 정보를 수정한다.<br>
		 * 
		 * @param List<PndlmPortVO> pndlmPortVOs
		 * @exception DAOException
		 */		
		public void modifyStartEndPort (List<PndlmPortVO> pndlmPortVOs) throws DAOException,Exception {
			try {
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
				//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL();
				int updCnt[] = null;
				if(pndlmPortVOs.size() > 0){
					//updCnt = sqlExe.executeBatch(template, updModels, null);
					updCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOPendulumServicePortVOUSQL(), pndlmPortVOs,null);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException ex) {
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
		}
		
		/**
		 * Pendulm port Start Port List, End Port List 정보를 삭제한다.<br>
		 * 
		 * @param List<PndlmPortVO> pndlmPortVOs
		 * @exception DAOException
		 */	
		public void removeStartEndPort (List<PndlmPortVO> pndlmPortVOs) throws DAOException,Exception {
			try {
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
				//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL();
				
				int delCnt[] = null;
				if(pndlmPortVOs.size() > 0){
					//delCnt = sqlExe.executeBatch(template, delModels, null);
				
					delCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOPendulumServicePortVODSQL(), pndlmPortVOs,null);
					for(int i = 0; i < delCnt.length; i++){
						
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException ex) {
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
		}

		/**
		 * BSA 정보를 조회한다.<br>
		 * 
		 * @param BsaVO bsaVO
		 * @return List<BsaVO>
		 * @exception DAOException
		 */	
		@SuppressWarnings("unchecked")
		public List<BsaVO> searchBSAListByVVD(BsaVO bsaVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BsaVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bsaVO != null){
					Map<String, String> mapVO = bsaVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	            log.debug("::CALL::> FNS_TOT_0006 DAQ > search 진입:::::::::");
	            TonnageTaxOutputMasterDataMgtDBDAOBSACreateByVesselVoyageVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAOBSACreateByVesselVoyageVORSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaVO .class);
				log.debug("::CALL::> FNS_TOT_0006 DAQ > 끝:::::::::");
			}catch(SQLException ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
			return list;
		}
		 
		/**
		 * BSA 정보의 최근업데이트 일자를 조회한다. <br>
		 * 
		 * @param BsaVO bsaVO
		 * @return List<BsaVO>
		 * @exception DAOException
		 */	
		@SuppressWarnings("unchecked")
		public List<BsaVO> searchBSARecentUpdateDt(BsaVO bsaVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BsaVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bsaVO != null){
					Map<String, String> mapVO = bsaVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	            log.debug("::CALL::> FNS_TOT_0001 DAQ > search recent dt진입:::::::::");
	            TonnageTaxOutputMasterDataMgtDBDAORcUpBsaVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAORcUpBsaVORSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaVO .class);
			}catch(SQLException ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
			return list;
		}

		/**
		 * BSA 정보를 수정한다. <br>
		 * 
		 * @param List<TotBsaVO> totBsaVOs
		 * @exception DAOException
		 */	
			public void modifyBSAByVVD(List<TotBsaVO> totBsaVOs) throws DAOException,Exception {
				try {
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
					//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL();
					int updCnt[] = null;
					if(totBsaVOs.size() > 0){
						//updCnt = sqlExe.executeBatch(template, updModels, null);
						updCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOBSACreateByVesselVoyageVOUSQL(), totBsaVOs,null);
						for(int i = 0; i < updCnt.length; i++){
							if(updCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}
					}
					log.debug("::CALL::> FNS_TOT_0006 DAO >IB_FLAG : U 끝:::::::::");
				} catch (SQLException ex) {
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
			}
			
			/**
			 * 해당년월의 정보를 모두 삭제한다. <br>
			 * 
			 * @param BsaVO bsaVO
			 * @return int
			 * @exception DAOException
			 */	
			public int removeBSAByVVD (BsaVO bsaVO) throws DAOException,Exception {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				int result = 0;
				try {
					Map<String, String> mapVO = bsaVO.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
					//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVODSQL();
					
					result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOBSACreateByVesselVoyageVODSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert SQL");
					}
				} catch (SQLException ex) {
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
				return result;
			}

			/**
			 * 해당년월의 생성하기 위한 정보를 조회한다. <br>
			 * 
			 * @param TotBsaVO totBsaVO
			 * @return List<TotBsaVO>
			 * @exception DAOException
			 */	
			@SuppressWarnings("unchecked")
			public List<TotBsaVO>  searchIFBSAByVVD(TotBsaVO totBsaVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<TotBsaVO> list = null;

				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				try{
					if(totBsaVO != null){
						Map<String, String> mapVO = totBsaVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
		            log.debug("::CALL::> FNS_TOT_0006 I/F DAQ > search 진입:::::::::");
		            TonnageTaxOutputMasterDataMgtDBDAOBsaIFVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAOBsaIFVORSQL();
					dbRowset = sqlExe.executeQuery(template, param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, TotBsaVO .class);



					log.debug("::CALL::> FNS_TOT_0006 I/F DAQ > 끝:::::::::");
				}catch(SQLException ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
				return list;
			}
            
			
			/**
			 * 해당년월의 조회한 정보를 생성한다. <br>
			 * 
			 * @param List<TotBsaVO> totBsaVOs
			 * @exception DAOException
			 */
			public void addBSAByVVDs(List<TotBsaVO> totBsaVOs) throws DAOException,Exception {
				try {
					log.debug("::CALL::> FNS_TOT_0006 DAQ addBSAByVVDs> 진입-----:::::::::");
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
					//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL();
					int insCnt[] = null;

					log.debug("::CALL::> FNS_TOT_0006 addBSAByVVDs DAQ >IB_FLAG : I 존재:::::::::");

					if(totBsaVOs.size() > 0){
						log.debug("::CALL::> FNS_TOT_0006 addBSAByVVDs DAQ >IB_FLAG : I 존재:::::::::");
						insCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOBsaIFVOCSQL(), totBsaVOs,null);
						//insCnt = sqlExe.executeBatch(template, insModels, null);
						for(int i = 0; i < insCnt.length; i++){
							if(insCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}
						
					}
				} catch (SQLException ex) {
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
			}
			
			
			/**
			 * BSA 정보의 tax 재계산전 변경된 데이터가 있는지 여부를 조회한다. <br>
			 * 
			 * @param TotBsaVO totBsaVO
			 * @return List<TotBsaVO>
			 * @exception DAOException
			 */
			@SuppressWarnings("unchecked")
			public List<TotBsaVO>  searchRecalculateBsaForModiFlg(TotBsaVO totBsaVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<TotBsaVO> list = null;

				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				try{
					if(totBsaVO != null){
						log.debug("getStlYrmon ::::::: "+totBsaVO.getStlYrmon());
						Map<String, String> mapVO = totBsaVO.getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
		            log.debug("::CALL::> FNS_TOT_0006 searchRecalculateBsaForModiFlg DAQ > search 진입:::::::::");
		            TonnageTaxOutputMasterDataMgtDBDAORecalculateBsaForModiFlgVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAORecalculateBsaForModiFlgVORSQL();
					dbRowset = sqlExe.executeQuery(template, param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, TotBsaVO .class);
                     
					log.debug("::CALL::> FNS_TOT_0006 searchRecalculateBsaForModiFlg DAQ > 끝:::::::::");
				}catch(SQLException ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
				return list;
			}	

			/**
			 *  BSA 정보의 배치처리된 데이터가 있는지를 조회한다. <br>
			 * 
			 * @param TotBsaVO totBsaVO
			 * @return List<TotBsaVO>
			 * @exception DAOException
			 */
			@SuppressWarnings("unchecked")
				public List<TotBsaVO>  searchBSABatchCnt(TotBsaVO totBsaVO) throws DAOException {
					DBRowSet dbRowset = null;
					List<TotBsaVO> list = null;

					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					//velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();
					
					try{
						if(totBsaVO != null){
							log.debug("getStlYrmon ::::::: "+totBsaVO.getStlYrmon());
							Map<String, String> mapVO = totBsaVO.getColumnValues();
						
							param.putAll(mapVO);
							velParam.putAll(mapVO);
						}
						
			            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			            log.debug("::CALL::> FNS_TOT_0006 TonnageTaxOutputMasterDataMgtDBDAORecalculateBsaForBatchCntVORSQL DAQ > search 진입:::::::::");
			            TonnageTaxOutputMasterDataMgtDBDAORecalculateBsaForBatchCntVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAORecalculateBsaForBatchCntVORSQL();
						dbRowset = sqlExe.executeQuery(template, param, velParam);
						list = (List)RowSetUtil.rowSetToVOs(dbRowset, TotBsaVO .class);
	                     
						log.debug("::CALL::> FNS_TOT_0006 TonnageTaxOutputMasterDataMgtDBDAORecalculateBsaForBatchCntVORSQL DAQ > 끝:::::::::");
					}catch(SQLException ex){
						//log.error(ex.getMessage(),ex);
						throw new DAOException(ex.getMessage(), ex);
					}catch(Exception ex){
						//log.error(ex.getMessage(),ex);
						throw new DAOException(ex.getMessage(), ex);
					}
					return list;
				}	
	

			/**
			 * tot_bsa의 해당 데이터 modi_flag를 'N'으로 수정한다.<br>
			 * @param TotBsaVO totBsaVO
			 * @return int
			 * @throws DAOException
			 */
			public int modifyRecalculateBsaForModiFlg (TotBsaVO totBsaVO) throws DAOException,Exception {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				int result = 0;
				try {
					Map<String, String> mapVO = totBsaVO.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
					//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL();
					
		            result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAORecalculateBsaForModiFlgVOUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert SQL");
					}
					
				} catch (SQLException ex) {
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
				return result;
			}			
			/**
			 *   NRT & BSA Change 정보를 조회한다. <br>
			 * 
			 * @param String stlYrmon
			 * @return List<NrtBsaChgVO>
			 * @exception DAOException
			 */
			@SuppressWarnings("unchecked")
				public List<NrtBsaChgVO>  searchNrtBsaChg(String stlYrmon) throws DAOException {
					DBRowSet dbRowset = null;
					List<NrtBsaChgVO> list = null;
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					//velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();
					
					try{
						param.put("stl_yrmon", stlYrmon);

						SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
						TonnageTaxOutputMasterDataMgtDBDAONrtBsaChgVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAONrtBsaChgVORSQL();
						dbRowset = sqlExe.executeQuery(template, param, velParam);
						list = (List)RowSetUtil.rowSetToVOs(dbRowset, NrtBsaChgVO .class);
	                     
					}catch(SQLException ex){
						//log.error(ex.getMessage(),ex);
						throw new DAOException(ex.getMessage(), ex);
					}catch(Exception ex){
						//log.error(ex.getMessage(),ex);
						throw new DAOException(ex.getMessage(), ex);
					}
					return list;
				}	
			
			/**
			 * Missing Lane Check 정보를 조회한다. <br>
			 * 
			 * @param String stlYrmon
			 * @return List<MissLaneChkVO>
			 * @exception DAOException
			 */
			@SuppressWarnings("unchecked")
				public List<MissLaneChkVO>  searchMissLaneChk(String stlYrmon) throws DAOException {
					DBRowSet dbRowset = null;
					List<MissLaneChkVO> list = null;
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					//velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();
					
					try{
						param.put("stl_yrmon", stlYrmon);

						SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
						TonnageTaxOutputMasterDataMgtDBDAOMissLaneChkVORSQL template = new TonnageTaxOutputMasterDataMgtDBDAOMissLaneChkVORSQL();
						dbRowset = sqlExe.executeQuery(template, param, velParam);
						list = (List)RowSetUtil.rowSetToVOs(dbRowset, MissLaneChkVO .class);
	                     
					}catch(SQLException ex){
						//log.error(ex.getMessage(),ex);
						throw new DAOException(ex.getMessage(), ex);
					}catch(Exception ex){
						//log.error(ex.getMessage(),ex);
						throw new DAOException(ex.getMessage(), ex);
					}
					return list;
				}
			
			/**
			 * NRT & BSA Change 화면에서 BSA Before 를 After로 업데이트 한다.<br>
			 * @param NrtBsaChgVO nrtBsaChgVO
			 * @throws DAOException
			 */
			public void modifyNrtBsaChgBsa (NrtBsaChgVO nrtBsaChgVO) throws DAOException,Exception {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				int result = 0;
				try {
					Map<String, String> mapVO = nrtBsaChgVO.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
					//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL();
					
		            result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAONrtBsaChgBsaModfiyVOUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update SQL");
					}
					
				} catch (SQLException ex) {
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
			}

			/**
			 * VESSEL 정보를 저장한다. <br>
			 * 
			 * @param VslVO vslVO
			 * @exception EventException
			 */
			public void createUseTonnageVessel(VslVO vslVO) throws DAOException {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				int result = 0;
				try{
					Map<String, String> mapVO = vslVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);

					SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");

					result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOVesselVOCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert SQL");
					}
				}catch(SQLException ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					//log.error(ex.getMessage(),ex);
					throw new DAOException(ex.getMessage(), ex);
				}
			}
			
			/**
			 * 해당월의 Lane정보 조회 <br>
			 * @param LaneVO laneVO
			 * @return List<LaneVO>
			 * @exception DAOException
			 */
			public List<LaneVO> searchLaneTradeGroupForCreateTOTLANE(LaneVO laneVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<LaneVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(laneVO != null){
						Map<String, String> mapVO = laneVO .getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
		            log.debug("::CALL::> FNS_TOT_0004 DAQ > search 진입:::::::::");
		            TonnageTaxOutputMasterDataMgtDBDAOSearchLaneTradeGroupForCreateTOTLANERSQL template = new TonnageTaxOutputMasterDataMgtDBDAOSearchLaneTradeGroupForCreateTOTLANERSQL();
					dbRowset = sqlExe.executeQuery(template, param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, LaneVO .class);
					log.debug("::CALL::> FNS_TOT_0004 DAQ > 끝:::::::::");
				}catch(SQLException ex){
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					throw new DAOException(ex.getMessage(), ex);
				}
				return list;
			}

			/**
			 * 해당월의 Lane, Trade 정보 조회 <br>
			 * @param LaneVO laneVO
			 * @return List<LaneVO>
			 * @exception DAOException
			 */
			public List<LaneVO> searchLaneTradeGroupForCreateTOTLANETRADE(LaneVO laneVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<LaneVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(laneVO != null){
						Map<String, String> mapVO = laneVO .getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
		            log.debug("::CALL::> FNS_TOT_0004 DAQ > search 진입:::::::::");
		            TonnageTaxOutputMasterDataMgtDBDAOSearchLaneTradeGroupForCreateTOTLANETRADERSQL template = new TonnageTaxOutputMasterDataMgtDBDAOSearchLaneTradeGroupForCreateTOTLANETRADERSQL();
					dbRowset = sqlExe.executeQuery(template, param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, LaneVO .class);
					log.debug("::CALL::> FNS_TOT_0004 DAQ > 끝:::::::::");
				}catch(SQLException ex){
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					throw new DAOException(ex.getMessage(), ex);
				}
				return list;
			}

			/**
			 * Lane정보를(TOT_LANE) 추가한다. <br>
			 * @param List<LaneVO> insertVoList
			 * @exception DAOException
			 */
			public void addTotLane(List<LaneVO> insertVoList) throws DAOException {
				//velocity parameter
				Map<String, String> velParam = new HashMap<String, String>();
				
				try {
					log.debug("::CALL::> addmanageLaneTradeCd> 진입-----:::::::::");
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
					log.debug("::CALL::> addmanageLaneTradeCd >IB_FLAG : I 존재:::::::::"+insertVoList.size());
					int insCnt[] = new int[insertVoList.size()];
					for(int k=0; k < insertVoList.size(); k++ ){
						velParam =  ((LaneVO)insertVoList.get(k)).getColumnValues();
						log.info("\nvelParam:"+velParam);
						log.info("\nISQLTemplate:"+(ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOAddTotLaneCSQL());
						insCnt[k] = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOAddTotLaneCSQL(), velParam, velParam);
					}
				} catch (SQLException ex) {
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					throw new DAOException(ex.getMessage(), ex);
				}
				
				
			}

			/**
			 * Lane정보를(TOT_LANE) 추가한다. <br>
			 * @param List<LaneVO> insertVoList
			 * @exception DAOException
			 */
			public void addTotLaneTrade(List<LaneVO> insertVoList) throws DAOException {
				//velocity parameter
				Map<String, String> velParam = new HashMap<String, String>();
				
				try {
					log.debug("::CALL::> addmanageLaneTradeCd> 진입-----:::::::::");
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
					log.debug("::CALL::> addmanageLaneTradeCd >IB_FLAG : I 존재:::::::::"+insertVoList.size());
					int insCnt[] = new int[insertVoList.size()];
					for(int k=0; k < insertVoList.size(); k++ ){
						velParam =  ((LaneVO)insertVoList.get(k)).getColumnValues();
						log.info("\nvelParam:"+velParam);
						log.info("\nISQLTemplate:"+(ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOAddTotLaneTradeCSQL());
						insCnt[k] = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxOutputMasterDataMgtDBDAOAddTotLaneTradeCSQL(), velParam, velParam);
					}
				} catch (SQLException ex) {
					throw new DAOException(ex.getMessage(), ex);
				}catch(Exception ex){
					throw new DAOException(ex.getMessage(), ex);
				}
				
				
			}
}
