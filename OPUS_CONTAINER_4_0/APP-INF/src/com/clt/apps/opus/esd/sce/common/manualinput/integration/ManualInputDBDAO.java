/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomsCommonMgtDBDAO.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3306Event;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActivityGroupMappingVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActivityGroupVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActualActivityMappingVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceCntrStsMsgMvmtMapgVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceCopCntrRepoRuleVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceRailSplcVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmRegionVO;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 * OPUS ManualInputDBDAO <br>
 * - OPUS-ManualInputDBDAO system Business Logic Handling.<br>
 * @author 2002701
 * @see ManualInputDBDAO
 * @since J2EE 1.6
 */
public class ManualInputDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
	
	/**
	 * searchActualActivityMappingList.<br>
	 * @param ActualActivityMappingVO actualActivityMappingVO
	 * @return List<ActualActivityMappingVO>
	 * @throws EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ActualActivityMappingVO> searchActualActivityMappingList(ActualActivityMappingVO actualActivityMappingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActualActivityMappingVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(actualActivityMappingVO != null){
				Map<String, String> mapVO = actualActivityMappingVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOSearchActualActivityMappingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActualActivityMappingVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * addActualActivityMapping
	 * @param insertVoList List<ActualActivityMappingVO>
	 * @throws DAOException
	 */
	public void addActualActivityMapping(List<ActualActivityMappingVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new ManualInputDBDAOAddActualActivityMappingCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * modifyActualActivityMapping
	 * @param updateVoList List<ActualActivityMappingVO> 
	 * @throws DAOException
	 */
	public void modifyActualActivityMapping(List<ActualActivityMappingVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new ManualInputDBDAOModifyActualActivityMappingUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * removeActualActivityMapping
	 * @param deleteVoList List<ActualActivityMappingVO>
	 * @throws DAOException
	 */
	public void removeActualActivityMapping(List<ActualActivityMappingVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new ManualInputDBDAORemoveActualActivityMappingDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * checkActualCode.<br>
	 * @param String actCd
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet checkActualCode(String actCd) throws DAOException {
		DBRowSet dbRowset = null; 
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(actCd != null){
					param.put("act_cd"    ,actCd);
					
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOCheckActualCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * checkActualActivityMappingCode
	 * @param actCd String
	 * @param actStsMapgCd String
	 * @param actRcvTpCd String
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkActualActivityMappingCode(String actCd, String actStsMapgCd, String actRcvTpCd) throws DAOException {
		DBRowSet dbRowset = null; 
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(actCd != null){
					param.put("act_cd"    ,actCd);
					param.put("act_sts_mapg_cd"    ,actStsMapgCd);
					param.put("act_rcv_tp_cd"    ,actRcvTpCd);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOCheckActualActivityMappingCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * searchActivityGroupList.<br>
	 * @param ActivityGroupVO activityGroupVO
	 * @return List<ActivityGroupVO>
	 * @throws EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ActivityGroupVO> searchActivityGroupList(ActivityGroupVO activityGroupVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<ActivityGroupVO> list = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(activityGroupVO != null){
					Map<String, String> mapVO = activityGroupVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOSearchActivityGroupRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActivityGroupVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	
	/**
	 * checkActivityGroupCode.<br>
	 * @param ActivityGroupVO activityGroupVO
	 * @return List<ActivityGroupVO>
	 * @throws EventException
	 */
	public DBRowSet checkActivityGroupCode(ActivityGroupVO activityGroupVO) throws DAOException {
		DBRowSet dbRowset = null; 
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
		Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				if(activityGroupVO != null){
					Map<String, String> mapVO = activityGroupVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOCheckActivityGroupCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * addActivityGroup
	 * @param insertVoList List<ActivityGroupVO>
	 * @throws DAOException
	 */
	public void addActivityGroup(List<ActivityGroupVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new ManualInputDBDAOAddActivityGroupCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * modifyActivityGroup
	 * @param updateVoList List<ActivityGroupVO>
	 * @throws DAOException
	 */
	public void modifyActivityGroup(List<ActivityGroupVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new ManualInputDBDAOModifyActivityGroupUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * removeActivityGroup
	 * @param deleteVoList List<ActivityGroupVO>
	 * @throws DAOException
	 */
	public void removeActivityGroup(List<ActivityGroupVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new ManualInputDBDAORemoveActivityGroupDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * searchActivityGroupMappingList.<br>
	 * @param ActivityGroupMappingVO activityGroupMappingVO
	 * @return List<ActivityGroupMappingVO>
	 * @throws EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ActivityGroupMappingVO> searchActivityGroupMappingList(ActivityGroupMappingVO activityGroupMappingVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<ActivityGroupMappingVO> list = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(activityGroupMappingVO != null){
					Map<String, String> mapVO = activityGroupMappingVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOSearchActivityGroupMappingListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActivityGroupMappingVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	
	/**
	 * checkCOPDetailGroupCode.<br>
	 * @param String copDtlGrpCd
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet checkCOPDetailGroupCode(String copDtlGrpCd) throws DAOException {
		DBRowSet dbRowset = null; 
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(copDtlGrpCd != null){
					param.put("cop_dtl_grp_cd"    ,copDtlGrpCd);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOCheckCOPDetailGroupCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * checkCOPDetailGroupCode
	 * @param actCd String
	 * @param copDtlGrpCd String
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkActivityGroupMappingCode(String actCd, String copDtlGrpCd) throws DAOException {
		DBRowSet dbRowset = null; 
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(copDtlGrpCd != null){
					param.put("cop_dtl_grp_cd"    ,copDtlGrpCd);
				}
				if(actCd != null){
					param.put("act_cd"    ,actCd);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOCheckActivityGroupMappingCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * addActivityGroupMapping
	 * @param insertVoList List<ActivityGroupMappingVO>
	 * @throws DAOException
	 */
	public void addActivityGroupMapping(List<ActivityGroupMappingVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new ManualInputDBDAOAddActivityGroupMappingCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * modifyActivityGroupMapping
	 * @param updateVoList List<ActivityGroupMappingVO>
	 * @throws DAOException
	 */
	public void modifyActivityGroupMapping(List<ActivityGroupMappingVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new ManualInputDBDAOModifyActivityGroupMappingUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * removeActivityGroupMapping
	 * @param deleteVoList List<ActivityGroupMappingVO>
	 * @throws DAOException
	 */
	public void removeActivityGroupMapping(List<ActivityGroupMappingVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new MaunalInputDBDAORemoveActivityGroupMappingDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * searchSceCntrStsMsgMvmtMappingList.<br>
	 * @param SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO
	 * @return List<SceCntrStsMsgMvmtMapgVO>
	 * @throws EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCntrStsMsgMvmtMapgVO> searchSceCntrStsMsgMvmtMappingList(SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCntrStsMsgMvmtMapgVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sceCntrStsMsgMvmtMapgVO != null){
				Map<String, String> mapVO = sceCntrStsMsgMvmtMapgVO. getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOSearchSceCntrStsMsgMvmtMapgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SceCntrStsMsgMvmtMapgVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * addmultiSceCntrStsMsgMvmt.<br>
	 * @param sceCntrStsMsgMvmtMapgVO SceCntrStsMsgMvmtMapgVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmultiSceCntrStsMsgMvmt(SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = sceCntrStsMsgMvmtMapgVO. getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ManualInputDBDAOAddSceCntrStsMsgMvmtMapgCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
			
	/**
	 * modifymultiSceCntrStsMsgMvmt.<br>
	 * @param SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO
	 * @return int
	 * @throws DAOException,Exception
	 */
	public int modifymultiSceCntrStsMsgMvmt(SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = sceCntrStsMsgMvmtMapgVO. getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ManualInputDBDAOModifySceCntrStsMsgMvmtMapgUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * removemultiSceCntrStsMsgMvmt.<br>
	 * @param SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO
	 * @return int
	 * @throws DAOException,Exception
	 */
	public int removemultiSceCntrStsMsgMvmt(SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = sceCntrStsMsgMvmtMapgVO. getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ManualInputDBDAORemoveSceCntrStsMsgMvmtMapgDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * addmultiSceCntrStsMsgMvmtS.<br>
	 * @param List<SceCntrStsMsgMvmtMapgVO> sceCntrStsMsgMvmtMapgVO
	 * @return int[]
	 * @throws DAOException,Exception
	 */
	public int[] addmultiSceCntrStsMsgMvmtS(List<SceCntrStsMsgMvmtMapgVO> sceCntrStsMsgMvmtMapgVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(sceCntrStsMsgMvmtMapgVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ManualInputDBDAOAddSceCntrStsMsgMvmtMapgCSQL(), sceCntrStsMsgMvmtMapgVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * modifymultiSceCntrStsMsgMvmtS.<br>
	 * @param List<SceCntrStsMsgMvmtMapgVO> sceCntrStsMsgMvmtMapgVO
	 * @return int[]
	 * @throws DAOException,Exception
	 */
	public int[] modifymultiSceCntrStsMsgMvmtS(List<SceCntrStsMsgMvmtMapgVO> sceCntrStsMsgMvmtMapgVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(sceCntrStsMsgMvmtMapgVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ManualInputDBDAOModifySceCntrStsMsgMvmtMapgUSQL(), sceCntrStsMsgMvmtMapgVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * removemultiSceCntrStsMsgMvmtS.<br>
	 * @param List<SceCntrStsMsgMvmtMapgVO> sceCntrStsMsgMvmtMapgVO
	 * @return int[]
	 * @throws DAOException,Exception
	 */
	public int[] removemultiSceCntrStsMsgMvmtS(List<SceCntrStsMsgMvmtMapgVO> sceCntrStsMsgMvmtMapgVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(sceCntrStsMsgMvmtMapgVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ManualInputDBDAORemoveSceCntrStsMsgMvmtMapgDSQL(), sceCntrStsMsgMvmtMapgVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * searchSceCopCntrRepoRuleList
	 * @param sceCopCntrRepoRuleVO SceCopCntrRepoRuleVO
	 * @return List<SceCopCntrRepoRuleVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopCntrRepoRuleVO> searchSceCopCntrRepoRuleList(SceCopCntrRepoRuleVO sceCopCntrRepoRuleVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopCntrRepoRuleVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sceCopCntrRepoRuleVO != null){
				Map<String, String> mapVO = sceCopCntrRepoRuleVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOSearchSceCopCntrRepoRuleRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SceCopCntrRepoRuleVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * addSceCopCntrRepoRule
	 * @param insertVoList List<SceCopCntrRepoRuleVO>
	 * @throws DAOException
	 */
	public void addSceCopCntrRepoRule(List<SceCopCntrRepoRuleVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insertVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new ManualInputDBDAOAddSceCopCntrRepoRuleCSQL(), insertVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * modifySceCopCntrRepoRule
	 * @param updateVoList List<SceCopCntrRepoRuleVO>
	 * @throws DAOException
	 */
	public void modifySceCopCntrRepoRule(List<SceCopCntrRepoRuleVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updateVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new ManualInputDBDAOModifySceCopCntrRepoRuleUSQL(),updateVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to modify No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * removeSceCopCntrRepoRule
	 * @param deleteVoList List<SceCopCntrRepoRuleVO>
	 * @throws DAOException
	 */
	public void removeSceCopCntrRepoRule(List<SceCopCntrRepoRuleVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (deleteVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new ManualInputDBDAORemoveSceCopCntrRepoRuleDSQL(), deleteVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to remove No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * searchSceRailSplcList
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceRailSplcVO> searchSceRailSplcList(EsdSce3306Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceRailSplcVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(event != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("frm_splc_cd", event.getFrmSplcCd());
				mapVO.put("frm_splc_vndr_nm", event.getFrmSplcVndrNm());
				mapVO.put("frm_yd_cd", event.getFrmYdCd());
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOSelectSceRailSplcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SceRailSplcVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * addSceRailSplc
	 * @param insertVoList
	 * @throws DAOException
	 */
	public void addSceRailSplc(List<SceRailSplcVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insertVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new ManualInputDBDAOAddSceRailSplcCSQL(), insertVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * modifySceRailSplc
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void modifySceRailSplc(List<SceRailSplcVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updateVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new ManualInputDBDAOModifySceRailSplcUSQL(),updateVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to modify No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * removeSceRailSplc
	 * @param deleteVoList
	 * @throws DAOException
	 */
	public void removeSceRailSplc(List<SceRailSplcVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (deleteVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new ManualInputDBDAORemoveSceRailSplcDSQL(), deleteVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to remove No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * searchMdmCntrTpszCd
	 * @param map
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MdmCntrTpSzVO> searchMdmCntrTpszCd(HashMap<String, String> map) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCntrTpSzVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(map != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("frm_cntr_tpsz_cd", (String) map.get("frm_cntr_tpsz_cd"));
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOSelectMdmCntrTpszCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCntrTpSzVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * searchMdmCountryCd
	 * @param map
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MdmCountryVO> searchMdmCountryCd(HashMap<String, String> map) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCountryVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(map != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("frm_cnt_cd", (String) map.get("frm_cnt_cd"));
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOSelectMdmCntCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCountryVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * searchMdmLocationCd
	 * @param map
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MdmLocationVO> searchMdmLocationCd(HashMap<String, String> map) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmLocationVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(map != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("frm_loc_cd", (String) map.get("frm_loc_cd"));
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOSelectMdmLocationCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmLocationVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * searchMdmRegionCd
	 * @param map
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MdmRegionVO> searchMdmRegionCd(HashMap<String, String> map) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmRegionVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(map != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("frm_rgn_cd", (String) map.get("frm_rgn_cd"));
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOSelectMdmRegionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmRegionVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * searchMdmYard
	 * @param map
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MdmYardVO> searchMdmYard(HashMap<String, String> map) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmYardVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(map != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("frm_yd_cd", (String) map.get("frm_yd_cd"));
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualInputDBDAOSelectMdmYardRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmYardVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}