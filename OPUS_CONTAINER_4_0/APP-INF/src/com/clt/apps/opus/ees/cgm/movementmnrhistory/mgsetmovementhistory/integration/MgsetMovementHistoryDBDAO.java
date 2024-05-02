/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MgsetMovementHistoryDBDAO.java
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.03
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2016.12.03 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.basic.MgsetMovementHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSAtchDtchHisMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSCNTRMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMovementMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtBareMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSmgstChkINVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS MgsetMovementHistoryDBDAO <br>
 * - OPUS-MovementMnrHistory system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author CHOI MIN HOI
 * @see MgsetMovementHistoryBCImpl 참조
 * @since J2EE 1.6
 */
public class MgsetMovementHistoryDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Page Size(50)<br>
	 */
//	private static final int PAGE_SIZE_1000  =  1000;

	/**
	 * CGM_MGST_MVMT_HIS 입력.  [EES_CGM_2019,EES_CGM_2011] .<br>
	 *
	 * @param List<MGSMovementMGTVO> mgsetMovementMGTVOs
	 * @exception DAOException
	 */
	public void addMGSXXMvmtData(List<MGSMovementMGTVO> mgsetMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsetMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MgsetMovementHistoryDBDAOAddMGSXXMvmtDataCSQL(), mgsetMovementMGTVOs,null);
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
	 * CGM_MGST_MVMT_HIS 입력.  [EES_CGM_2019,EES_CGM_2011] .<br>
	 *
	 * @param List<MGSMovementMGTVO> mGSMovementMGTVOs
	 * @exception DAOException
	 */
	public void addMGSFoundMvmtData(List<MGSMovementMGTVO> mGSMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mGSMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MgsetMovementHistoryDBDAOAddMGSFoundMvmtDataCSQL(), mGSMovementMGTVOs,null);
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
	 * Mgset movement 를 UPDATE  [EES_CGM_1016] .<br>
	 *
	 * @param List<MGSMovementMGTVO> mGSMovementMGTVOs
	 * @exception DAOException
	 */
	public void modifyMgsMoveByStatusDate(List<MGSMovementMGTVO> mGSMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mGSMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MgsetMovementHistoryDBDAOmodifyMgsMoveByStatusDataUSQL(), mGSMovementMGTVOs,null);
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
	 * Mgset movement 를 삭제  [EES_CGM_1016] .<br>
	 *
	 * @param List<MGSMovementMGTVO> mGSMovementMGTVOs
	 * @exception DAOException
	 */
	public void removeMgsMoveByStatusDate(List<MGSMovementMGTVO> mGSMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mGSMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MgsetMovementHistoryDBDAOremoveMgsMoveByStatusDataDSQL(), mGSMovementMGTVOs,null);
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
	 * Found Mgset Auto Creation 화면에서 EDI 오류 데이터등, 삭제처리할 Data를 Movement Data를 삭제처리한다.  [EES_CGM_1018] .<br>
	 *
	 * @param List<MGSMovementMGTVO> mGSMovementMGTVOs
	 * @exception DAOException
	 */
	public void removeMgsMvmtFoundAutoData(List<MGSMovementMGTVO> mGSMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mGSMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MgsetMovementHistoryDBDAOremoveMgsMvmtFoundAutoDataDSQL(), mGSMovementMGTVOs,null);
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
	 * 조건별 Mgset Movement List 조회  [EES_CGM_1104] .<br>
	 *
	 * @param MGSMvmtINVO mgsMvmtINVO
	 * @return List<MGSMvmtMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MGSMvmtMGTVO> searchMgsMovementListData(MGSMvmtINVO mgsMvmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSMvmtMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mgsMvmtINVO != null) {
				Map<String, String> mapVO = mgsMvmtINVO. getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MgsetMovementHistoryDBDAOsearchMgsMovementDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSMvmtMGTVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * CGM EQUIPMENT 엔티티로부터 필요한 마스터 속성을 조회한다.  [EES_CGM_1105] .<br>
	 *
	 * @param MGSMvmtINVO mGSMvmtINVO
	 * @return List<MGSMvmtHistoryMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MGSMvmtHistoryMGTVO> searchMGSMstInfoData(MGSMvmtINVO mGSMvmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSMvmtHistoryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSMvmtINVO != null) {
				Map<String, String> mapVO = mGSMvmtINVO. getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MgsetMovementHistoryDBDAOsearchMGSMstInfoDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSMvmtHistoryMGTVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 *  장비별 Chassis Movement History 를 조회한다.   [EES_CGM_1105] .<br>
	 *
	 * @param MGSMvmtINVO mGSMvmtINVO
	 * @return List<MGSMvmtHistoryMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MGSMvmtHistoryMGTVO> searchMGSMovementHistoryData(MGSMvmtINVO mGSMvmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSMvmtHistoryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSMvmtINVO != null) {
				Map<String, String> mapVO = mGSMvmtINVO. getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MgsetMovementHistoryDBDAOsearchMGSMovementHistoryDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSMvmtHistoryMGTVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Attach/Detach History 를 조회한다.     [EES_CGM_1105] .<br>
	 *
	 * @param MGSMvmtINVO mGSMvmtINVO
	 * @return List<MGSMvmtHistoryMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MGSMvmtHistoryMGTVO> searchMGSAtdtHistoryData(MGSMvmtINVO mGSMvmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSMvmtHistoryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSMvmtINVO != null) {
				Map<String, String> mapVO = mGSMvmtINVO. getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MgsetMovementHistoryDBDAOsearchMGSAtdtHistoryDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSMvmtHistoryMGTVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 *  Mgset Bare Movement History 를 조회한다.     [EES_CGM_1108] .<br>
	 *
	 * @param MGSMvmtINVO mGSMvmtINVO
	 * @return List<MGSMvmtBareMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MGSMvmtBareMGTVO> searchMGSBareMvmtData(MGSMvmtINVO mGSMvmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSMvmtBareMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSMvmtINVO != null) {
				Map<String, String> mapVO = mGSMvmtINVO. getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MgsetMovementHistoryDBDAOsearchMGSBareMvmtDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSMvmtBareMGTVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 *  Chassis movement 를 UPDATE 수행.     [EES_CGM_1108] .<br>
	 *
	 * @param List<MGSMvmtBareMGTVO> mGSMvmtBareMGTVOs
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean modifyMGSMovementData(List<MGSMvmtBareMGTVO> mGSMvmtBareMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSMvmtBareMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new MgsetMovementHistoryDBDAOmodifyMGSMovementDataUSQL(), mGSMvmtBareMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

	/**
	 *  Mgset movement 를 UPDATE 수행     [EES_CGM_1108] .<br>
	 *
	 * @param List<MGSMvmtBareMGTVO> mGSMvmtBareMGTVOs
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean removeMGSMovementData(List<MGSMvmtBareMGTVO> mGSMvmtBareMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSMvmtBareMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new MgsetMovementHistoryDBDAOremoveMGSMovementDataDSQL(), mGSMvmtBareMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

	/**
	 *   Mgset Bare Movement History 를 verify  [EES_CGM_1108] .<br>
	 *
	 * @param MGSMvmtBareMGTVO mgsMvmtBareMGTVO
	 * @return MGSMvmtBareMGTVO
	 * @exception DAOException
	 */
	public MGSMvmtBareMGTVO searchMGSBareMvmtVerifyData(MGSMvmtBareMGTVO mgsMvmtBareMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSMvmtBareMGTVO mGSMvmtBareMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("checkCHSVerifyOffhireStatusData==================================");
		try{
			if(mgsMvmtBareMGTVO != null){
				Map<String, String> mapVO = mgsMvmtBareMGTVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MgsetMovementHistoryDBDAOsearchMGSBareMvmtVerifyDataRSQL(), param, velParam);
				if(dbRowset.next()){
					mGSMvmtBareMGTVO = new MGSMvmtBareMGTVO();
					mGSMvmtBareMGTVO.setVerify(dbRowset.getString("verify"));
				}

			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mGSMvmtBareMGTVO;
	}

	/**
	 *  Chassis Movement 를 INSER 한다  [EES_CGM_1108] .<br>
	 *
	 * @param List<MGSMvmtBareMGTVO> mGSMvmtBareMGTVOs
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean addMGSBareMvmtData(List<MGSMvmtBareMGTVO> mGSMvmtBareMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSMvmtBareMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new MgsetMovementHistoryDBDAOaddMGSBareMvmtDataCSQL(), mGSMvmtBareMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}



	/**
	 *  Mgset Movement 를 INSER 한다.  [EES_CGM_1109] .<br>
	 *
	 * @param cNTRMvmtMGTVOs List<CNTRMvmtMGTVO>
	 * @exception DAOException
	 */
	public void addMGSMovementData(List<MGSCNTRMvmtMGTVO> cNTRMvmtMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cNTRMvmtMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MgsetMovementHistoryDBDAOAddMGSMovementDataCSQL(), cNTRMvmtMGTVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * mnr 에서 호출 CGM_MGST_MVMT_HIS 입력  [MNR 호출 ] .<br>
	 *
	 * @param List<MGSMovementMGTVO> mGSMovementMGTVOs
	 * @exception DAOException
	 */
	public void addMnrRetirementData(List<MGSMovementMGTVO> mGSMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mGSMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MgsetMovementHistoryDBDAOAddMnrRetirementDataCSQL(), mGSMovementMGTVOs,null);
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
	 * at dt 인지 체크 한다 .<br>
	 *
	 * @param cNTRMvmtMGTVO CNTRMvmtMGTVO
	 * @return MGSAtdtHistoryMGTVO
	 * @exception DAOException
	 */
    public MGSAtdtHistoryMGTVO checkMGSAtdtData(MGSCNTRMvmtMGTVO cNTRMvmtMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("checkCHSVerifyOffhireStatusData==================================");
		try{
			if(cNTRMvmtMGTVO != null){
				Map<String, String> mapVO = cNTRMvmtMGTVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MgsetMovementHistoryDBDAOcheckMGSAtdtDataRSQL(), param, velParam);
				if(dbRowset.next()){
					mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();
					log.debug("checkCHSVerifyOffhireStatusData=================================="+dbRowset.getString("atch_dt"));
					log.debug("checkCHSVerifyOffhireStatusData=================================="+dbRowset.getString("dtch_yd_cd"));
					log.debug("checkCHSVerifyOffhireStatusData=================================="+dbRowset.getString("eq_no"));
					mGSAtdtHistoryMGTVO.setAtchDt(dbRowset.getString("atch_dt"));
					mGSAtdtHistoryMGTVO.setDtchYdCd(dbRowset.getString("dtch_yd_cd"));
					mGSAtdtHistoryMGTVO.setEqNo(dbRowset.getString("eq_no"));
				}

			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mGSAtdtHistoryMGTVO;
	}

	/**
	 * BR 인지 체크 한다 .<br>
	 *
	 * @param cusCtmMovementVO CusCtmMovementVO
	 * @return CNTRMvmtMGTVO
	 * @exception DAOException
	 */
    public MGSCNTRMvmtMGTVO checkMgsBareMvmtByCtmData(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSCNTRMvmtMGTVO cNTRMvmtMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("checkCHSVerifyOffhireStatusData==================================");
		try{
			if(cusCtmMovementVO != null){
				Map<String, String> mapVO = cusCtmMovementVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MgsetMovementHistoryDBDAOcheckMGSBareMvmtByCtmDataRSQL(), param, velParam);
				if(dbRowset.next()){
					cNTRMvmtMGTVO = new MGSCNTRMvmtMGTVO();
					cNTRMvmtMGTVO.setMgstNo(dbRowset.getString("mgst_no"));
					cNTRMvmtMGTVO.setMvmtDt1(dbRowset.getString("mvmt_dt_1"));
					cNTRMvmtMGTVO.setMvmtDt2(dbRowset.getString("mvmt_dt_2"));
				}

			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cNTRMvmtMGTVO;
	}

	/**
	 * BR 인지 체크 한다 .<br>
	 *
	 * @param cusCtmMovementVO CusCtmMovementVO
	 * @return CNTRMvmtMGTVO
	 * @exception DAOException
	 */
    public MGSCNTRMvmtMGTVO checkMgsBareMvmtByopocData(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSCNTRMvmtMGTVO cNTRMvmtMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("checkCHSVerifyOffhireStatusData==================================");
		try{
			if(cusCtmMovementVO != null){
				Map<String, String> mapVO = cusCtmMovementVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MgsetMovementHistoryDBDAOcheckMGSBareMvmtByopocDataRSQL(), param, velParam);
				if(dbRowset.next()){
					cNTRMvmtMGTVO = new MGSCNTRMvmtMGTVO();
					cNTRMvmtMGTVO.setMgstNo(dbRowset.getString("mgst_no"));
					cNTRMvmtMGTVO.setMvmtDt1(dbRowset.getString("mvmt_dt_1"));
					cNTRMvmtMGTVO.setMvmtDt2(dbRowset.getString("mvmt_dt_2"));
				}

			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cNTRMvmtMGTVO;
	}

    /**
     * 입력 ctm mvmt PK 로 Mgset Mvmt 테이블 조회
     *
     * @param cusCtmMovementVO CusCtmMovementVO
     * @return CNTRMvmtMGTVO
     * @exception DAOException
     */
    public MGSCNTRMvmtMGTVO searchMgsChssMvmtHisData(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSCNTRMvmtMGTVO cNTRMvmtMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchCgmChssMvmtHisData==================================");
		try{
			if(cusCtmMovementVO != null){
				Map<String, String> mapVO = cusCtmMovementVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MgsetMovementHistoryDBDAOsearchCgmMgstMvmtHisDataRSQL(), param, velParam);
				if(dbRowset.next()){
					cNTRMvmtMGTVO = new MGSCNTRMvmtMGTVO();
					log.debug("searchCgmChssMvmtHisData=================================="+dbRowset.getString("mgst_no"));
					cNTRMvmtMGTVO.setMgstNo(dbRowset.getString("mgst_no"));
					cNTRMvmtMGTVO.setMvmtDt(dbRowset.getString("mvmt_dt"));
					log.debug("searchCgmChssMvmtHisData=================================="+dbRowset.getString("mvmt_dt"));
				}

			}
			return cNTRMvmtMGTVO;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

    /**
     * CGM_MGST_MVMT_HIS data 삭제
     *
     * @param cusCtmMovementVO CusCtmMovementVO
     * @exception DAOException
     */
    public void removeCgmMgstMvmtHisData(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
    	SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		log.debug("removeCgmChssMvmtHisData==================================");
		try{
			if(cusCtmMovementVO != null){
				Map<String, String> param = cusCtmMovementVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new MgsetMovementHistoryDBDAOremoveCgmMgstMvmtHisDataDSQL(), param, null);
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
     * Movement data 수정
     *
     * @param cNTRMvmtMGTVO
     * @exception DAOException
     */
    public void modifyCgmMgstMvmtHisData(MGSCNTRMvmtMGTVO cNTRMvmtMGTVO) throws DAOException {
    	SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		log.debug("manageCgmChssMvmtHisData.getMgstNo()=================================="+cNTRMvmtMGTVO.getMgstNo());
		log.debug("manageCgmChssMvmtHisData.getMvmtDt()=================================="+cNTRMvmtMGTVO.getMvmtDt());
		try{
			if(cNTRMvmtMGTVO != null){
				Map<String, String> param = cNTRMvmtMGTVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new MgsetMovementHistoryDBDAOmodifyCgmMgstMvmtHisDataUSQL(), param, null);
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
     * Attach detach data  업데이트 정보 체크
     *
     * @param MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO
     * @return MGSAtchDtchHisMGTVO
     * @exception DAOException
     * @exception Exception
     */
	public MGSAtchDtchHisMGTVO searchCgmEqAtchDtchHisData(MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		MGSAtchDtchHisMGTVO mgsEqAtchDtchHisMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchCgmEqAtchDtchHisData==================================");
		try{
			if(mGSAtdtHistoryMGTVO != null){
				Map<String, String> mapVO = mGSAtdtHistoryMGTVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MgsetMovementHistoryDBDAOsearchCgmEqAtchDtchHisDataRSQL(), param, velParam);
				if(dbRowset.next()){
					mgsEqAtchDtchHisMGTVO = new MGSAtchDtchHisMGTVO();
					mgsEqAtchDtchHisMGTVO.setEqNo(dbRowset.getString("eq_no")); //
					mgsEqAtchDtchHisMGTVO.setCntrNo(dbRowset.getString("cntr_no")); //
					mgsEqAtchDtchHisMGTVO.setAtchDt(dbRowset.getString("atch_dt")); //
					mgsEqAtchDtchHisMGTVO.setAtchYdCd(dbRowset.getString("atch_yd_cd"));  //
					if(dbRowset.getString("dtch_dt")!=null){   //
						mgsEqAtchDtchHisMGTVO.setDtchDt(dbRowset.getString("dtch_dt"));
					}
					if(dbRowset.getString("dtch_yd_cd")!=null){
						mgsEqAtchDtchHisMGTVO.setDtchYdCd(dbRowset.getString("dtch_yd_cd")); //
					}
					if(dbRowset.getString("lag_dt")!=null){ //
						mgsEqAtchDtchHisMGTVO.setLagDt(dbRowset.getString("lag_dt"));
					}
					if(dbRowset.getString("lag_dt_yd")!=null){
						mgsEqAtchDtchHisMGTVO.setLagDtYd(dbRowset.getString("lag_dt_yd"));
					}
					if(dbRowset.getString("lead_dt")!=null){
						mgsEqAtchDtchHisMGTVO.setLeadDt(dbRowset.getString("lead_dt"));
					}
					if(dbRowset.getString("lead_dt_yd")!=null){
						mgsEqAtchDtchHisMGTVO.setLeadDt(dbRowset.getString("lead_dt_yd"));
					}
				}
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mgsEqAtchDtchHisMGTVO;
	}

	/**
	 * 배치에서 ctm 모둘내 호출 데이터 가져오기
	 *
	 * @return List<CusCtmMovementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CusCtmMovementVO>  searchCtmMvmtSourceData() throws DAOException {
		DBRowSet dbRowset = null;
		List<CusCtmMovementVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MgsetMovementHistoryDBDAOsearchCtmMvmtSourceDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CusCtmMovementVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * GETTING MGSET TYPE 
	 *
	 * @param String mgstNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchMgsetTypeData(String mgstNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("mgst_no", mgstNo);
			velParam.put("mgst_no", mgstNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MgsetMovementHistoryDBDAOcheckMgsetTypeDataRSQL(), param, velParam);
			
			if(dbRowset.next()){
				rtnVal = dbRowset.getString("EQ_TPSZ_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}

	/**
	 * Container Movement Histoy Retrive Button Event. <br>
	 * Container 이동정보의 Booking 정보 조회
	 *
	 * @param MVMTBookingInfoVO mVMTHistoryListVO
	 * @param SignOnUserAccount account
	 * @return List<MVMTBookingInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MVMTBookingInfoVO> searchBookingInfoList(MVMTBookingInfoVO mVMTHistoryListVO, SignOnUserAccount account) throws DAOException {
		 DBRowSet dbRowset = null;
		List<MVMTBookingInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(mVMTHistoryListVO != null){
				if (mVMTHistoryListVO.getPDate1() == null || mVMTHistoryListVO.getPDate1().equals("")) mVMTHistoryListVO.setPDate1("");

				param.put("nls_cnt", account.getCnt_cd());
				param.put("p_date1", mVMTHistoryListVO.getPDate1());
				param.put("p_date2", mVMTHistoryListVO.getPDate2());
				param.put("p_cntrno", mVMTHistoryListVO.getPCntrno());
				param.put("check_digit", mVMTHistoryListVO.getCheckDigit());
				velParam.putAll(param);
//				velParam.put("nls_cnt", account.getCnt_cd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MgsetMovementHistoryDBDAOMVMTBookingInforVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MVMTBookingInfoVO.class);
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
	 * ContainerMovement History List를 조회한다.<br>
	 *
	 * @param MVMTHistoryListVO mvmtHistoryListVO
	 * @return List<MVMTHistoryListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MVMTHistoryListVO> searchMVMTHistoryList(MVMTHistoryListVO mvmtHistoryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MVMTHistoryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mvmtHistoryListVO != null){
				Map<String, String> mapVO = mvmtHistoryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MgsetMovementHistoryDBDAOMVMTHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MVMTHistoryListVO.class);
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
	 * ContainerMovement History List를 조회한다.<br>
	 *
	 * @param MGSmgstChkINVO mGSmgstChkINVO
	 * @return List<MGSmgstChkINVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSmgstChkINVO> searchmgstAtdtVerifyList(MGSmgstChkINVO mGSmgstChkINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSmgstChkINVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSmgstChkINVO != null){
				Map<String, String> mapVO = mGSmgstChkINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MgsetMovementHistoryDBDAOsearchMgstAtdtVerifyDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSmgstChkINVO.class);
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
	 * ContainerMovement History List를 조회한다.<br>
	 *
	 * @param MGSmgstChkINVO mGSmgstChkINVO
	 * @return List<MGSmgstChkINVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSmgstChkINVO> searchmgstTpszOnCntrCHkList(MGSmgstChkINVO mGSmgstChkINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSmgstChkINVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSmgstChkINVO != null){
				Map<String, String> mapVO = mGSmgstChkINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MgsetMovementHistoryDBDAOsearchMgstTpszOnEqChkDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSmgstChkINVO.class);
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
	 * at dt 인지 체크 한다 .<br>
	 *
	 * @param cNTRMvmtMGTVO CNTRMvmtMGTVO
	 * @return MGSAtdtHistoryMGTVO
	 * @exception DAOException
	 */
	public MGSAtdtHistoryMGTVO checkMGSAtchEqData(MGSCNTRMvmtMGTVO cNTRMvmtMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("checkCHSVerifyOffhireStatusData==================================");
		try {
			if (cNTRMvmtMGTVO != null) {
				Map<String, String> mapVO = cNTRMvmtMGTVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MgsetMovementHistoryDBDAOsearchMgsetAtchEqDataRSQL(), param, velParam);
				if (dbRowset.next()) {
					mGSAtdtHistoryMGTVO = new MGSAtdtHistoryMGTVO();
					log.debug("checkCHSVerifyOffhireStatusData=================================="+ dbRowset.getString("ATCH_DT"));
					log.debug("checkCHSVerifyOffhireStatusData=================================="+ dbRowset.getString("DTCH_YD_CD"));
					mGSAtdtHistoryMGTVO.setAtchDt(dbRowset.getString("ATCH_DT"));
					mGSAtdtHistoryMGTVO.setDtchYdCd(dbRowset.getString("DTCH_YD_CD"));
					if("CLG".equals(cNTRMvmtMGTVO.getEqTpszCd())){
						mGSAtdtHistoryMGTVO.setCntrNo(dbRowset.getString("CNTR_NO"));
					}else if("UMG".equals(cNTRMvmtMGTVO.getEqTpszCd())){
						mGSAtdtHistoryMGTVO.setChssNo(dbRowset.getString("CHSS_NO"));
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
		return mGSAtdtHistoryMGTVO;
	}
}