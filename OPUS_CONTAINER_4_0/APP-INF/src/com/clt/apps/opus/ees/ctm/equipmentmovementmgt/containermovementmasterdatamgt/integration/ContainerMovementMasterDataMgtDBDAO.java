/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMasterDataMgtDBDAO.java
*@FileTitle : Restuffing Reason
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.04.30 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllVVDByBKGVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchDeletedMVMTListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.basic.ContainerMovementMasterDataMgtBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.CntrMvmtSeqVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.RCtmMvmtStsVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.UsAmsLocationListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CtmMvmtStsDcsnVO;
import com.clt.syscommon.common.table.CtmMvmtXchRsnVO;

/**
 * ContainerMovementMasterDataMgtDBDAO <br>
 * - EquipmentMovementMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 우경민
 * @see ContainerMovementMasterDataMgtBCImpl 참조
 * @since J2EE 1.5
 * 2009.4.24
 */

public class ContainerMovementMasterDataMgtDBDAO extends DBDAOSupport {

	/**
	 * Container Movement Status 리스트를 조회한다.<br>
	 *
	 * @param RCtmMvmtStsVO rCtmMvmtStsVO
	 * @return List<RCtmMvmtStsVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RCtmMvmtStsVO> searchMVMTStatusList(RCtmMvmtStsVO rCtmMvmtStsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RCtmMvmtStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rCtmMvmtStsVO != null){
				Map<String, String> mapVO = rCtmMvmtStsVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMasterDataMgtDBDAOCtmMvmtStsVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RCtmMvmtStsVO.class);

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
	 * CTM_MVMT_XCH_RSN에서 Reson리스트를 조회한다.<br>
	 *
	 * @param CtmMvmtXchRsnVO ctmMvmtXchRsnVO
	 * @return List<CtmMvmtXchRsnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CtmMvmtXchRsnVO> searchReasonList(CtmMvmtXchRsnVO ctmMvmtXchRsnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CtmMvmtXchRsnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ctmMvmtXchRsnVO != null){
				Map<String, String> mapVO = ctmMvmtXchRsnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMasterDataMgtDBDAOCtmMvmtXchRsnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CtmMvmtXchRsnVO.class);

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
	 * US AMS Location List를 조회한다.<br>
	 * 
	 * @param UsAmsLocationListVO usLmsLocationListVO
	 * @return List<UsAmsLocationListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UsAmsLocationListVO> searchAmsLocation(UsAmsLocationListVO usLmsLocationListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsAmsLocationListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			try{
			if(usLmsLocationListVO != null){
				Map<String, String> mapVO = usLmsLocationListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMasterDataMgtDBDAOUsLmsLocationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsAmsLocationListVO .class);
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
	 * US AMS Location List를 일괄 등록한다 .<br>
	 * 
	 * @param List<UsAmsLocationListVO> usAmsLocationListVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addmanageAmsLocationS(List<UsAmsLocationListVO> usAmsLocationListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(usAmsLocationListVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMasterDataMgtDBDAOUsLmsLocationListCSQL(), usAmsLocationListVOs,null);
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
	 * US AMS Location List를 일괄 수정한다 .<br>
	 * 
	 * @param List<UsAmsLocationListVO> usAmsLocationListVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifymanageAmsLocationS(List<UsAmsLocationListVO> usAmsLocationListVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(usAmsLocationListVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMasterDataMgtDBDAOUsLmsLocationListUSQL(), usAmsLocationListVOs,null);
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
	 * US AMS Location List를 일괄 삭제한다 .<br>
	 * 
	 * @param List<UsAmsLocationListVO> usAmsLocationListVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removemanageAmsLocationS(List<UsAmsLocationListVO> usAmsLocationListVOs) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(usAmsLocationListVOs .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMasterDataMgtDBDAOUsLmsLocationListDSQL(), usAmsLocationListVOs,null);
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
	 * Restuffing Reason List를 일괄 등록한다 .<br>
	 * 
	 * @param List<CtmMvmtXchRsnVO> ctmMvmtXchRsnVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addmanageReasonS(List<CtmMvmtXchRsnVO> ctmMvmtXchRsnVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(ctmMvmtXchRsnVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMasterDataMgtDBDAOCtmMvmtXchRsnVOCSQL(), ctmMvmtXchRsnVOs,null);
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
	 * Restuffing Reason List를 일괄 수정한다 .<br>
	 * 
	 * @param List<CtmMvmtXchRsnVO> ctmMvmtXchRsnVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifymanageReasonS(List<CtmMvmtXchRsnVO> ctmMvmtXchRsnVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(ctmMvmtXchRsnVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMasterDataMgtDBDAOCtmMvmtXchRsnVOUSQL(), ctmMvmtXchRsnVOs,null);
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
	
	/** manageOSCARCtmCycNoList
	 * 
	 * @param searchDeletedMVMTListVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] manageOSCARCtmCycNoList(List<SearchDeletedMVMTListVO> searchDeletedMVMTListVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchDeletedMVMTListVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementFinderDBDAOManageOSCARCtmCycNoListUSQL(), searchDeletedMVMTListVOs,null);
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
	
	/** addmanageOSCARCtmCycNoList
	 * 
	 * @param searchDeletedMVMTListVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmanageOSCARCtmCycNoList(List<SearchDeletedMVMTListVO> searchDeletedMVMTListVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchDeletedMVMTListVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementFinderDBDAOAddManageOSCARCtmCycNoListCSQL(), searchDeletedMVMTListVOs,null);
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
	
	/** removemanageOSCARCtmCycNoList
	 * 
	 * @param searchDeletedMVMTListVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemanageOSCARCtmCycNoList(List<SearchDeletedMVMTListVO> searchDeletedMVMTListVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchDeletedMVMTListVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementFinderDBDAORemoveManageOSCARCtmCycNoListDSQL(), searchDeletedMVMTListVOs,null);
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
	
	/** addmanageVVDList
	 * 
	 * @param searchAllVVDByBKGVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmanageVVDList(List<SearchAllVVDByBKGVO> searchAllVVDByBKGVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchAllVVDByBKGVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementFinderDBDAOAddManageVVDListCSQL(), searchAllVVDByBKGVOs,null);
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
	
	/** modifymanageVVDList
	 * 
	 * @param searchAllVVDByBKGVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymanageVVDList(List<SearchAllVVDByBKGVO> searchAllVVDByBKGVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchAllVVDByBKGVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementFinderDBDAOModifymanageVVDListUSQL(), searchAllVVDByBKGVOs,null);
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
	
	/** removemanageVVDList
	 * 
	 * @param searchAllVVDByBKGVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemanageVVDList(List<SearchAllVVDByBKGVO> searchAllVVDByBKGVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchAllVVDByBKGVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementFinderDBDAORemoveManageVVDListDSQL(), searchAllVVDByBKGVOs,null);
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
	
	/** modifymanageBKGList
	 * 
	 * @param searchAllVVDByBKGVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymanageBKGList(List<SearchAllVVDByBKGVO> searchAllVVDByBKGVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchAllVVDByBKGVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementFinderDBDAOModifymanageBKGListUSQL(), searchAllVVDByBKGVOs,null);
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
	 * Restuffing Reason List를 일괄 수정한다 .<br>
	 * 
	 * @param List<CtmMvmtXchRsnVO> ctmMvmtXchRsnVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removemanageReasonS(List<CtmMvmtXchRsnVO> ctmMvmtXchRsnVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(ctmMvmtXchRsnVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMasterDataMgtDBDAOCtmMvmtXchRsnVODSQL(), ctmMvmtXchRsnVOs,null);
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
	 * CTM_MVMT_SEQ에서 Sequence 리스트를 조회한다.<br>
	 *
	 * @param CntrMvmtSeqVO cntrMvmtSeqVO
	 * @return List<CntrMvmtSeqVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CntrMvmtSeqVO> searchCntrMvmtSeqList(CntrMvmtSeqVO cntrMvmtSeqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrMvmtSeqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntrMvmtSeqVO != null){
				Map<String, String> mapVO = cntrMvmtSeqVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMasterDataMgtDBDAOCntrMvmtSeqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrMvmtSeqVO .class);

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
	 * CNTR MVMT Sequence List를 일괄 등록한다 .<br>
	 * 
	 * @param List<CntrMvmtSeqVO> cntrMvmtSeqVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addmanageCntrMvmtSeqs(List<CntrMvmtSeqVO> cntrMvmtSeqVOs) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (cntrMvmtSeqVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ContainerMovementMasterDataMgtDBDAOCntrMvmtSeqVOCSQL(), cntrMvmtSeqVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * CNTR MVMT Sequence List를 일괄 수정한다 .<br>
	 * 
	 * @param List<CntrMvmtSeqVO> cntrMvmtSeqVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifymanageCntrMvmtSeq(List<CntrMvmtSeqVO> cntrMvmtSeqVOs) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (cntrMvmtSeqVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ContainerMovementMasterDataMgtDBDAOCntrMvmtSeqVOUSQL(), cntrMvmtSeqVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * CNTR MVMT Sequence List를 일괄 삭제한다 .<br>
	 * 
	 * @param List<CntrMvmtSeqVO> cntrMvmtSeqVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removemanageCntrMvmtSeq(List<CntrMvmtSeqVO> cntrMvmtSeqVOs) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (cntrMvmtSeqVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ContainerMovementMasterDataMgtDBDAOCntrMvmtSeqVODSQL(), cntrMvmtSeqVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * CTM_MVMT_STS_DCSN 에서 Cntr MVMT Status 리스트를 조회한다.<br>
	 *
	 * @param CtmMvmtStsDcsnVO ctmMvmtStsDcsnVO
	 * @return List<CtmMvmtStsDcsnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CtmMvmtStsDcsnVO> searchCtmMvmtStsDcsnList(CtmMvmtStsDcsnVO ctmMvmtStsDcsnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CtmMvmtStsDcsnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ctmMvmtStsDcsnVO != null){
				Map<String, String> mapVO = ctmMvmtStsDcsnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CtmMvmtStsDcsnVO .class);

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
	 * Cntr MVMT Status List를 일괄 등록한다 .<br>
	 * 
	 * @param List<CtmMvmtStsDcsnVO> ctmMvmtStsDcsnVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addmanageCtmMvmtStsDcsnS(List<CtmMvmtStsDcsnVO> ctmMvmtStsDcsnVOs) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (ctmMvmtStsDcsnVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVOCSQL(), ctmMvmtStsDcsnVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * Cntr MVMT Status List를 일괄 수정한다 .<br>
	 * 
	 * @param List<CtmMvmtStsDcsnVO> ctmMvmtStsDcsnVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifymanageCtmMvmtStsDcsnS(List<CtmMvmtStsDcsnVO> ctmMvmtStsDcsnVOs) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (ctmMvmtStsDcsnVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVOUSQL(), ctmMvmtStsDcsnVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * Cntr MVMT Status List를 일괄 삭제한다 .<br>
	 * 
	 * @param List<CtmMvmtStsDcsnVO> ctmMvmtStsDcsnVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removemanageCtmMvmtStsDcsnS(List<CtmMvmtStsDcsnVO> ctmMvmtStsDcsnVOs) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (ctmMvmtStsDcsnVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVODSQL(), ctmMvmtStsDcsnVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}	 
	
}
