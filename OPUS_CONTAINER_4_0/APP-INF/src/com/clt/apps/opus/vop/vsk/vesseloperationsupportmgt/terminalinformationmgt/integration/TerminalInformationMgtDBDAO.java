/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInformationMgtDBDAO.java
*@FileTitle : Terminal Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.25 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.basic.TerminalInformationMgtBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalInfoConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortBrthWdoVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortGntrCrnVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.VskPortFltgCrnVO;
import com.clt.syscommon.common.table.VskPortGngStrcVO;

/**
 * NIS2010 TerminalInformationMgtDBDAO <br>
 * - NIS2010-VesselOperationSupportMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jang Suk Hyun
 * @see TerminalInformationMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class TerminalInformationMgtDBDAO extends DBDAOSupport {
	/**
	 * [Port Combo] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskComboVO> searchPortComboList(TerminalInfoConditionVO terminalInfoConditionVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<VskComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalInfoConditionVO != null){
				Map<String, String> mapVO = terminalInfoConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalInformationPortComboDAOOptComvoRSQL(), param, velParam);
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
	 * [F/Crane Max Crane] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskComboVO> searchMaxFCraneSeqList(TerminalInfoConditionVO terminalInfoConditionVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<VskComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalInfoConditionVO != null){
				Map<String, String> mapVO = terminalInfoConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalInformationMaxCraneSeqDAOOptComvoRSQL(), param, velParam);
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
		 * [Gang Structure Max Gang Structure] 정보를 [조회] 합니다.<br>
		 * 
		 * @param TerminalInfoConditionVO terminalInfoConditionVO
		 * @return List<VskComboVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<VskComboVO> searchMaxGngSeqList(TerminalInfoConditionVO terminalInfoConditionVO) throws DAOException { 
			DBRowSet dbRowset = null;
			List<VskComboVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(terminalInfoConditionVO != null){
					Map<String, String> mapVO = terminalInfoConditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalInformationMaxGngSeqDAOOptComvoRSQL(), param, velParam);
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
	 * [Port Information] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskComboVO> searchPortInfoList(TerminalInfoConditionVO terminalInfoConditionVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<VskComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalInfoConditionVO != null){
				Map<String, String> mapVO = terminalInfoConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalInformationPortInfoDAOOptComvoRSQL(), param, velParam);
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
	 * [Terminal G/Crane] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortGntrCrnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortGntrCrnVO> searchGCraneList(TerminalInfoConditionVO terminalInfoConditionVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<VskPortGntrCrnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalInfoConditionVO != null){
				Map<String, String> mapVO = terminalInfoConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortGntrCrnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortGntrCrnVO .class);
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
	 * [Port Combo] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskComboVO> searchTermialComboList(TerminalInfoConditionVO terminalInfoConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalInfoConditionVO != null){
				Map<String, String> mapVO = terminalInfoConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalInformationComboDAOOptComvoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskComboVO .class);
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
	 * [Terminal F/Crane] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortFltgCrnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortFltgCrnVO> searchFCraneList(TerminalInfoConditionVO terminalInfoConditionVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<VskPortFltgCrnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalInfoConditionVO != null){
				Map<String, String> mapVO = terminalInfoConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortFltgCrnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortFltgCrnVO.class);
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
	 * [Terminal Gang Structure] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortGngStrcVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortGngStrcVO> searchGangStructureList(TerminalInfoConditionVO terminalInfoConditionVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<VskPortGngStrcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalInfoConditionVO != null){
				Map<String, String> mapVO = terminalInfoConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortGngStrcVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortGngStrcVO.class);
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
	 * [Terminal Birth Window] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortBrthWdoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortBrthWdoVO> searchBerthWindowList(TerminalInfoConditionVO terminalInfoConditionVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<VskPortBrthWdoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalInfoConditionVO != null){
				Map<String, String> mapVO = terminalInfoConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortBrthWdoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortBrthWdoVO.class);
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
	 * [G/Crane] 정보를 [추가] 합니다.<br>
	 * 
	 * @param List<VskPortGntrCrnVO> vskPortGntrCrnVOs
	 * @throws DAOException
	 */
	public void addGCraneS(List<VskPortGntrCrnVO> vskPortGntrCrnVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskPortGntrCrnVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortGntrCrnVOCSQL(), vskPortGntrCrnVOs,null);
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
	 * [G/Crane] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<VskPortGntrCrnVO> vskPortGntrCrnVOs
	 * @throws DAOException
	 */
	public void modifyGCraneS(List<VskPortGntrCrnVO> vskPortGntrCrnVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(vskPortGntrCrnVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortGntrCrnVOUSQL(), vskPortGntrCrnVOs,null);
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
	}
	
	/**
	 * [G/Crane] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<VskPortGntrCrnVO> vskPortGntrCrnVOs
	 * @throws DAOException
	 */
	public void removeGCraneS(List<VskPortGntrCrnVO> vskPortGntrCrnVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(vskPortGntrCrnVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortGntrCrnVODSQL(), vskPortGntrCrnVOs,null);
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
	 * [F/Crane] 정보를 [추가] 합니다.<br>
	 * 
	 * @param VskPortFltgCrnVO vskPortFltgCrnVO
	 * @throws DAOException
	 */
	public void addFCraneS(VskPortFltgCrnVO vskPortFltgCrnVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vskPortFltgCrnVO != null){
				Map<String, String> mapVO = vskPortFltgCrnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortFltgCrnVOCSQL(), param, null);
				
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
	 * [F/Crane] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<VskPortFltgCrnVO> vskPortFltgCrnVOs
	 * @throws DAOException
	 */
	public void modifyFCraneS(List<VskPortFltgCrnVO> vskPortFltgCrnVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(vskPortFltgCrnVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortFltgCrnVOUSQL(), vskPortFltgCrnVOs,null);
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
	}

	/**
	 * [F/Crane] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<VskPortFltgCrnVO> vskPortFltgCrnVOs
	 * @throws DAOException
	 */
	public void removeFCraneS(List<VskPortFltgCrnVO> vskPortFltgCrnVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(vskPortFltgCrnVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortFltgCrnVODSQL(), vskPortFltgCrnVOs,null);
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
	 * [Gang Structure] 정보를 [추가] 합니다.<br>
	 * 
	 * @param VskPortGngStrcVO vskPortGngStrcVO
	 * @throws DAOException
	 */
	public void addGangStructureS(VskPortGngStrcVO vskPortGngStrcVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vskPortGngStrcVO != null){
				Map<String, String> mapVO = vskPortGngStrcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortGngStrcVOCSQL(), param, null);
				
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
	 * [Gang Structure] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<VskPortGngStrcVO> vskPortGngStrcVOs
	 * @throws DAOException
	 */
	public void modifyGangStructureS(List<VskPortGngStrcVO> vskPortGngStrcVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(vskPortGngStrcVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortGngStrVOUSQL(), vskPortGngStrcVOs,null);
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
	}		
	
	/**
	 * [Gang Structure] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<VskPortGngStrcVO> vskPortGngStrcVOs
	 * @throws DAOException
	 */
	public void removeGangStructureS(List<VskPortGngStrcVO> vskPortGngStrcVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(vskPortGngStrcVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortGngStrVODSQL(), vskPortGngStrcVOs,null);
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
	 * [Birth Window] 정보를 [추가] 합니다.<br>
	 * 
	 * @param VskPortBrthWdoVO vskPortBrthWdoVOs
	 * @throws DAOException
	 */
	
	public void addBerthWindowS(VskPortBrthWdoVO vskPortBrthWdoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vskPortBrthWdoVOs != null){
				Map<String, String> mapVO = vskPortBrthWdoVOs .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortBrthWdoVOCSQL(), param, null);
				
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
	 * [Birth Window] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<VskPortBrthWdoVO> vskPortBrthWdoVOs
	 * @throws DAOException
	 */
	public void modifyBerthWindowS(List<VskPortBrthWdoVO> vskPortBrthWdoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskPortBrthWdoVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortBrthWdoVOUSQL(), vskPortBrthWdoVOs, null);
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
	 * [Birth Window] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<VskPortBrthWdoVO> vskPortBrthWdoVOs
	 * @throws DAOException 
	 */
	public void removeBerthWindowS(List<VskPortBrthWdoVO> vskPortBrthWdoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskPortBrthWdoVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalInformationMgtDBDAOVskPortBrthWdoVODSQL(), vskPortBrthWdoVOs,null);
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
	 
}
