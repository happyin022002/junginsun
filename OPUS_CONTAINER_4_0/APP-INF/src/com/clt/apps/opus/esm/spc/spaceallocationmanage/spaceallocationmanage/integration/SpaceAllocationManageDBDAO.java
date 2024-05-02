/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SpaceAllocationManageDBDAO.java
*@FileTitle      : SpaceAllocationManage
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.07.29
*@LastModifier   : 최윤성
*@LastVersion    : 1.0
* 2009.07.29
* 1.0 Creation
* History
=========================================================
*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.spc.common.common.integration.CommonDBDAOSearchOfficeCondRSQL;
import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.basic.SpaceAllocationManageBCImpl;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowAdjustmentListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowDownloadDateListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchRemarkFlagOfficeVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044MasterListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047MasterListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0053ManageListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045QtyListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045VVDListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchVesselSKDListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SpcAlocCtrlOptVO;
import com.clt.syscommon.common.table.SpcAlocPolPodVO;
import com.clt.syscommon.common.table.SpcFcastDwnLodSkdVO;
import com.clt.syscommon.common.table.SpcNshwRsltVO;


/**
 * SpaceAllocationManageDBDAO <br>
 * - SpaceAllocationManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI Yun Sung
 * @see SpaceAllocationManageBCImpl 참조
 * @since J2EE 1.6
 */
public class SpaceAllocationManageDBDAO extends DBDAOSupport {

	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042DetailListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0042DetailListVO> searchSpaceAllocationDetailList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0042DetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0042DetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0042DetailListVO .class);
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
		 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
		 * 
		 * @param ConditionVO conditionVO
		 * @return List<SearchSpaceAllocation0042DetailListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchSpaceAllocation0042DetailListVO> searchSpaceAllocationDetailList2(ConditionVO conditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchSpaceAllocation0042DetailListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0042DetailList2RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0042DetailListVO .class);
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
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042MListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0042MListVO> searchSpaceAllocationMasterList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0042MListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0042MListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0042MListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiSpaceAllocation(SpcAlocPolPodVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("rmk_size", vo.getSpcCtrlAlocRmk().length());
			velParam.put("pol_rmk_size", vo.getSpcCtrlAlocPolRmk().length());
			velParam.put("pod_rmk_size", vo.getSpcCtrlAlocPodRmk().length());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(    (vo.getIocCd().equals("IPC") && !vo.getSubTrdCd().equals("IA"))
				|| (vo.getIocCd().equals("T/S") && !vo.getSubTrdCd().equals("IA")) ) {
				if(vo.getModeRmk().equals("UPD")){
					result = sqlExe.executeUpdate((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPodRmkUSQL(), param, velParam);
				} 
			} else {
				result = sqlExe.executeUpdate((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPodRmk2USQL(), param, velParam);
			}
			
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpaceAllocationS(List<SpcAlocPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod042CSQL(), insModels,null);
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
		return insCnt;
	}
	
	/**
	 * [ESM_SPC_0071] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchVesselSKDListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchVesselSKDListVO> searchVesselSKDList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVesselSKDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchVesselSKDListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVesselSKDListVO .class);
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
	 * [0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpaceAllocationS0044(List<SpcAlocPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod044CSQL(), insModels,null);
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
		return insCnt;
	}

	/**
	 * [0047] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpaceAllocationS0047(List<SpcAlocPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod047CSQL(), insModels,null);
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
		return insCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpaceAllocationS(List<SpcAlocPolPodVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod042USQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	
	/**
	 * [0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpaceAllocationS0044(List<SpcAlocPolPodVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod044USQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	
	/**
	 * [0047] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpaceAllocationS0047(List<SpcAlocPolPodVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod047USQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpaceAllocationS(List<SpcAlocPolPodVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod042DSQL(), delModels,null);
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
		return delCnt;
	}
	
	/**
	 * [0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpaceAllocationS0044(List<SpcAlocPolPodVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod044DSQL(), delModels,null);
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
		return delCnt;
	}
	
	/**
	 * [0047] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpaceAllocationS0047(List<SpcAlocPolPodVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod047DSQL(), delModels,null);
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
		return delCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocCtrlOptVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiControlOptionS(List<SpcAlocCtrlOptVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptCSQL(), insModels,null);
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
		return insCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocCtrlOptVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiControlOptionS(List<SpcAlocCtrlOptVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocCtrlOptVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiControlOptionS(List<SpcAlocCtrlOptVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptDSQL(), delModels,null);
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
		return delCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * Tab 1 (Trade Tab) 및 Tab 2(Sub Trade Tab) 메인 조회전 Key 체크
	 * @param ConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceAllocationControlFlagList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocationControlFlagListRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * [ESM_SPC_0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0044DetailListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0044DetailListVO> searchSpaceAllocation0044DetailList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0044DetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0044DetailListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0044DetailListVO .class);
			
			log.debug("list.size():"+list.size());
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
	 * [ESM_SPC_0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0044MasterListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0044MasterListVO> searchSpaceAllocation0044MasterList(ConditionVO conditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0044MasterListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0044MasterListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0044MasterListVO .class);
			
			
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
	 * [ESM_SPC_0045] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0044MasterListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocationManage045VVDListVO> searchSpaceAllocationManage045VVDList(ConditionVO conditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		List<SearchSpaceAllocationManage045VVDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocationManage045VVDListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationManage045VVDListVO .class);
			
			
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
		 * [ESM_SPC_0045] 정보를 [행위] 합니다.<br>
		 * 
		 * @param ConditionVO conditionVO
		 * @return List<SearchSpaceAllocationManage045QtyListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchSpaceAllocationManage045QtyListVO> searchSpaceAllocationManage045QtyList(ConditionVO conditionVO) throws DAOException {
			 DBRowSet dbRowset = null;
			List<SearchSpaceAllocationManage045QtyListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocationManage045QtyListVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationManage045QtyListVO .class);
				
				
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
	 * [ESM_SPC_0047] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0047DetailListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0047DetailListVO> searchSpaceAllocation0047DetailList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0047DetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0047DetailListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0047DetailListVO .class);
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
	 * [ESM_SPC_0047] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0047MasterListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0047MasterListVO> searchSpaceAllocation0047MasterList(ConditionVO conditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0047MasterListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0047MasterListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0047MasterListVO .class);
			
			
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
	 * [ESM_SPC_0053] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0053ManageListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocationManageList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0053ManageListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0053ManageListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0053ManageListVO .class);
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
	 * [ESM_SPC_0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return List<SearchRemarkFlagOfficeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRemarkFlagOfficeVO> searchRemarkFlagOffice(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRemarkFlagOfficeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				param.put("ofc_cd",ofcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchRemarkFlagOfficeRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRemarkFlagOfficeVO .class);
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
	 * [ESM_SPC_0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNoShowAdjustmentListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchNoShowAdjustmentListVO> searchNoShowAdjustmentList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchNoShowAdjustmentListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchNoShowAdjustmentListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNoShowAdjustmentListVO .class);
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
	 * [0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcNshwRsltVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiNoShowAdjustment(List<SpcNshwRsltVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcNshwRsltVOCSQL(), insModels,null);
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
		return insCnt;
	}

	/**
	 * [0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcFcastDwnLodSkdVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiForcastDownloadDate(List<SpcFcastDwnLodSkdVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcFcastDwnLodSkdVOCSQL(), insModels,null);
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
		return insCnt;
	}
	/**
	 * [ESM_SPC_0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNoShowDownloadDateListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchNoShowDownloadDateListVO> searchNoShowDownloadDateList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchNoShowDownloadDateListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchNoShowDownloadDateListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNoShowDownloadDateListVO .class);
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
		 * [0070] 정보를 [행위] 합니다.<br>
		 * 
		 * @param List<SpcNshwRsltVO> updModels
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 */
		public int[] modifymultiNoShowAdjustment(List<SpcNshwRsltVO> updModels) throws DAOException,Exception {
			int updCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(updModels.size() > 0){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcNshwRsltVOUSQL(), updModels,null);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
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
			return updCnt;
		}
		
		/**
		 * [0070] 정보를 [행위] 합니다.<br>
		 * 
		 * @param List<SpcFcastDwnLodSkdVO> updModels
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 */
		public int[] modifymultiForcastDownloadDate(List<SpcFcastDwnLodSkdVO> updModels) throws DAOException,Exception {
			int updCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(updModels.size() > 0){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcFcastDwnLodSkdVOUSQL(), updModels,null);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
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
			return updCnt;
		}
		/**
		 * [0070] 정보를 [행위] 합니다.<br>
		 * 
		 * @param List<SpcNshwRsltVO> delModels
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 */
		public int[] removemultiNoShowAdjustment(List<SpcNshwRsltVO> delModels) throws DAOException,Exception {
			int delCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(delModels.size() > 0){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcNshwRsltVODSQL(), delModels,null);
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
			return delCnt;
		}
		/**
		 * [0070] 정보를 [행위] 합니다.<br>
		 * 
		 * @param List<SpcFcastDwnLodSkdVO> delModels
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 */
		public int[] removemultiForcastDownloadDate(List<SpcFcastDwnLodSkdVO> delModels) throws DAOException,Exception {
			int delCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(delModels.size() > 0){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcFcastDwnLodSkdVODSQL(), delModels,null);
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
			return delCnt;
		}
		
		/**
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 * 
		 * @param String ofc_cd
		 * @param String ui_name
		 * @return List<SearchOfficeCondVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SearchOfficeCondVO> searchOfficeCond(String ofc_cd, String ui_name) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchOfficeCondVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				param.put("ofc_cd", ofc_cd);
				param.put("ui_name", ui_name);
				velParam.put("ui_name", ui_name); 
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchOfficeCondRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeCondVO .class);
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