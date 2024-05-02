/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAO.java
*@FileTitle : test
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.03 최민회
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.01.13 김상수 [CHM-201215565-01] ALPS MNR-Disposal-SLD Management-> SLD Cancellation 보완 요청
*                                      - Disposal Sold Cancelation 화면에서 M.G.Set과 Chassis도 SLD Cancel 가능하도록 CGM연계로직 추가
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSAtdtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.basic.ChassisMovementHistoryBCImpl;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSAtchDtchHisMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMovementMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtBareMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSmgstChkINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CNTRMvmtMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.ShipCHSMvmtMGTVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS ChassisMovementHistoryDBDAO <br>
 * - ALPS-MovementMnrHistory system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author CHOI MIN HOI
 * @see ChassisMovementHistoryBCImpl 참조
 * @since J2EE 1.6
 */
public class ChassisMovementHistoryDBDAO extends DBDAOSupport {
	/**
	 * Page Size(50)<br>
	 */
	private static final int PAGE_SIZE_1000  =  1000;

	/**
	 * CGM_CHSS_MVMT_HIS 입력.  [EES_CGM_1017,EES_CGM_1009] .<br>
	 *
	 * @param chassisMovementMGTVOs List<chassisMovementMGTVO>
	 * @exception DAOException
	 */
	public void addCHSXXMvmtData(List<CHSMovementMGTVO> chassisMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chassisMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMovementHistoryDBDAOAddCHSXXMvmtDataCSQL(), chassisMovementMGTVOs,null);
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
	 * CGM_CHSS_MVMT_HIS 입력.  [EES_CGM_1017,EES_CGM_1018] .<br>
	 *
	 * @param cHSMovementMGTVOs List<chassisMovementMGTVO>
	 * @exception DAOException
	 */
	public void addCHSFoundMvmtData(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMovementHistoryDBDAOAddCHSFoundMvmtDataCSQL(), cHSMovementMGTVOs,null);
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
	 * Chassis movement 를 UPDATE  [EES_CGM_1016] .<br>
	 *
	 * @param cHSMovementMGTVOs List<chassisMovementMGTVO>
	 * @exception DAOException
	 */
	public void modifyChsMoveByStatusDate(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMovementHistoryDBDAOmodifyChsMoveByStatusDataUSQL(), cHSMovementMGTVOs,null);
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
	 * Chassis movement 를 삭제  [EES_CGM_1016] .<br>
	 *
	 * @param cHSMovementMGTVOs List<chassisMovementMGTVO>
	 * @exception DAOException
	 */
	public void removeChsMoveByStatusDate(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMovementHistoryDBDAOremoveChsMoveByStatusDataDSQL(), cHSMovementMGTVOs,null);
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
	 * Found Chassis Auto Creation 화면에서 EDI 오류 데이터등, 삭제처리할 Data를 Movement Data를 삭제처리한다.  [EES_CGM_1018] .<br>
	 *
	 * @param cHSMovementMGTVOs List<chassisMovementMGTVO>
	 * @exception DAOException
	 */
	public void removeChsMvmtFoundAutoData(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMovementHistoryDBDAOremoveChsMvmtFoundAutoDataDSQL(), cHSMovementMGTVOs,null);
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
	 * 조건별 Chassis Movement List 조회  [EES_CGM_1104] .<br>
	 *
	 * @param chsMvmtINVO CHSMvmtINVO
	 * @return List<CHSMvmtMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CHSMvmtMGTVO> searchChsMovementListData(CHSMvmtINVO chsMvmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSMvmtMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (chsMvmtINVO != null) {
				Map<String, String> mapVO = chsMvmtINVO. getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMovementHistoryDBDAOsearchChsMovemenDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSMvmtMGTVO.class);
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
	 * @param cHSMvmtINVO CHSMvmtINVO
	 * @return List<CHSMvmtHistoryMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CHSMvmtHistoryMGTVO> searchCHSMstInfoData(CHSMvmtINVO cHSMvmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSMvmtHistoryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSMvmtINVO != null) {
				Map<String, String> mapVO = cHSMvmtINVO. getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMovementHistoryDBDAOsearchCHSMstInfoDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSMvmtHistoryMGTVO.class);
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
	 * @param cHSMvmtINVO CHSMvmtINVO
	 * @return List<CHSMvmtHistoryMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CHSMvmtHistoryMGTVO> searchCHSMovementHistoryData(CHSMvmtINVO cHSMvmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSMvmtHistoryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSMvmtINVO != null) {
				Map<String, String> mapVO = cHSMvmtINVO. getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMovementHistoryDBDAOsearchCHSMovementHistoryDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSMvmtHistoryMGTVO.class);
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
	 * @param cHSMvmtINVO CHSMvmtINVO
	 * @return List<CHSMvmtHistoryMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CHSMvmtHistoryMGTVO> searchCHSAtdtHistoryData(CHSMvmtINVO cHSMvmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSMvmtHistoryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSMvmtINVO != null) {
				Map<String, String> mapVO = cHSMvmtINVO. getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMovementHistoryDBDAOsearchCHSAtdtHistoryDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSMvmtHistoryMGTVO.class);
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
	 *  Chassis Bare Movement History 를 조회한다.     [EES_CGM_1108] .<br>
	 *
	 * @param cHSMvmtINVO CHSMvmtINVO
	 * @return List<CHSMvmtHistoryMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CHSMvmtBareMGTVO> searchCHSBareMvmtData(CHSMvmtINVO cHSMvmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSMvmtBareMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSMvmtINVO != null) {
				Map<String, String> mapVO = cHSMvmtINVO. getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMovementHistoryDBDAOsearchCHSBareMvmtDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSMvmtBareMGTVO.class);
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
	 * @param cHSMvmtBareMGTVOs List<CHSMvmtBareMGTVO>
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean modifyCHSMovementData(List<CHSMvmtBareMGTVO> cHSMvmtBareMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSMvmtBareMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMovementHistoryDBDAOmodifyCHSMovementDataUSQL(), cHSMvmtBareMGTVOs, null);
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
	 *  hassis movement 를 UPDATE 수행     [EES_CGM_1108] .<br>
	 *
	 * @param cHSMvmtBareMGTVOs List<CHSMvmtBareMGTVO>
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean removeCHSMovementData(List<CHSMvmtBareMGTVO> cHSMvmtBareMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSMvmtBareMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMovementHistoryDBDAOremoveCHSMovementDataDSQL(), cHSMvmtBareMGTVOs, null);
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
	 *   Chassis Bare Movement History 를 verify  [EES_CGM_1108] .<br>
	 *
	 * @param chsMvmtBareMGTVO CHSMvmtBareMGTVO
	 * @return CHSMvmtBareMGTVO
	 * @exception DAOException
	 */
	public CHSMvmtBareMGTVO searchCHSBareMvmtVerifyData(CHSMvmtBareMGTVO chsMvmtBareMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		CHSMvmtBareMGTVO cHSMvmtBareMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("checkCHSVerifyOffhireStatusData==================================");
		try{
			if(chsMvmtBareMGTVO != null){
				Map<String, String> mapVO = chsMvmtBareMGTVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOsearchCHSBareMvmtVerifyDataRSQL(), param, velParam);
				if(dbRowset.next()){
					cHSMvmtBareMGTVO = new CHSMvmtBareMGTVO();
					cHSMvmtBareMGTVO.setVerify(dbRowset.getString("verify"));
				}

			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cHSMvmtBareMGTVO;
	}

	/**
	 *  Chassis Movement 를 INSER 한다  [EES_CGM_1108] .<br>
	 *
	 * @param cHSMvmtBareMGTVOs List<CHSMvmtBareMGTVO>
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean addCHSBareMvmtData(List<CHSMvmtBareMGTVO> cHSMvmtBareMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSMvmtBareMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMovementHistoryDBDAOaddCHSBareMvmtDataCSQL(), cHSMvmtBareMGTVOs, null);
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
	 *  Chassis Movement 를 INSER 한다.  [EES_CGM_1109] .<br>
	 *
	 * @param cNTRMvmtMGTVOs List<CNTRMvmtMGTVO>
	 * @exception DAOException
	 */
	public void addCHSMovementData(List<CNTRMvmtMGTVO> cNTRMvmtMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cNTRMvmtMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMovementHistoryDBDAOaddCHSMovementDataCSQL(), cNTRMvmtMGTVOs,null);
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
	 * mnr 에서 호출 CGM_CHSS_MVMT_HIS 입력  [MNR 호출 ] .<br>
	 *
	 * @param cHSMovementMGTVOs List<chassisMovementMGTVO>
	 * @exception DAOException
	 */
	public void addMnrRetirementData(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSMovementMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMovementHistoryDBDAOAddMnrRetirementDataCSQL(), cHSMovementMGTVOs,null);
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
	 * @return CHSAtdtHistoryMGTVO
	 * @exception DAOException
	 */
    public CHSAtdtHistoryMGTVO checkCHSAtdtData(CNTRMvmtMGTVO cNTRMvmtMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO = null;
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOcheckCHSAtdtDataRSQL(), param, velParam);
				if(dbRowset.next()){
					cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
					log.debug("checkCHSVerifyOffhireStatusData=================================="+dbRowset.getString("atch_dt"));
					log.debug("checkCHSVerifyOffhireStatusData=================================="+dbRowset.getString("dtch_yd_cd"));
					log.debug("checkCHSVerifyOffhireStatusData=================================="+dbRowset.getString("eq_no"));
					cHSAtdtHistoryMGTVO.setAtchDt(dbRowset.getString("atch_dt"));
					cHSAtdtHistoryMGTVO.setDtchYdCd(dbRowset.getString("dtch_yd_cd"));
					cHSAtdtHistoryMGTVO.setEqNo(dbRowset.getString("eq_no"));
				}

			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cHSAtdtHistoryMGTVO;
	}

	/**
	 * BR 인지 체크 한다 .<br>
	 *
	 * @param cusCtmMovementVO CusCtmMovementVO
	 * @return CNTRMvmtMGTVO
	 * @exception DAOException
	 */
    public CNTRMvmtMGTVO checkChsBareMvmtByCtmData(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		CNTRMvmtMGTVO cNTRMvmtMGTVO = null;
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOcheckChsBareMvmtByCtmDataRSQL(), param, velParam);
				if(dbRowset.next()){
					cNTRMvmtMGTVO = new CNTRMvmtMGTVO();
					cNTRMvmtMGTVO.setChssNo(dbRowset.getString("chss_no"));
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
    public CNTRMvmtMGTVO checkChsBareMvmtByopocData(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		CNTRMvmtMGTVO cNTRMvmtMGTVO = null;
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOcheckChsBareMvmtByopocDataRSQL(), param, velParam);
				if(dbRowset.next()){
					cNTRMvmtMGTVO = new CNTRMvmtMGTVO();
					cNTRMvmtMGTVO.setChssNo(dbRowset.getString("chss_no"));
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
     * 입력 ctm mvmt PK 로 Chassis Mvmt 테이블 조회
     *
     * @param cusCtmMovementVO CusCtmMovementVO
     * @return CNTRMvmtMGTVO
     * @exception DAOException
     */
    public CNTRMvmtMGTVO searchCgmChssMvmtHisData(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		CNTRMvmtMGTVO cNTRMvmtMGTVO = null;
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOsearchCgmChssMvmtHisDataRSQL(), param, velParam);
				if(dbRowset.next()){
					cNTRMvmtMGTVO = new CNTRMvmtMGTVO();
					log.debug("searchCgmChssMvmtHisData=================================="+dbRowset.getString("chss_no"));
					cNTRMvmtMGTVO.setChssNo(dbRowset.getString("chss_no"));
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
     * M_CHSS_MVMT_HIS data 삭제
     *
     * @param cusCtmMovementVO CusCtmMovementVO
     * @exception DAOException
     */
    public void removeCgmChssMvmtHisData(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
    	SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		log.debug("removeCgmChssMvmtHisData==================================");
		try{
			if(cusCtmMovementVO != null){
				Map<String, String> param = cusCtmMovementVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new ChassisMovementHistoryDBDAOremoveCgmChssMvmtHisDataDSQL(), param, null);
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
    public void modifyCgmChssMvmtHisData(CNTRMvmtMGTVO cNTRMvmtMGTVO) throws DAOException {
    	SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		log.debug("manageCgmChssMvmtHisData.getChssNo()=================================="+cNTRMvmtMGTVO.getChssNo());
		log.debug("manageCgmChssMvmtHisData.getMvmtDt()=================================="+cNTRMvmtMGTVO.getMvmtDt());
		try{
			if(cNTRMvmtMGTVO != null){
				Map<String, String> param = cNTRMvmtMGTVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new ChassisMovementHistoryDBDAOmodifyCgmChssMvmtHisDataUSQL(), param, null);
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
     * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
     * @return CgmEqAtchDtchHisMGTVO
     * @exception DAOException
     * @exception Exception
     */
	public CHSAtchDtchHisMGTVO searchCgmEqAtchDtchHisData(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		CHSAtchDtchHisMGTVO cgmEqAtchDtchHisMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchCgmEqAtchDtchHisData==================================");
		try{
			if(cHSAtdtHistoryMGTVO != null){
				Map<String, String> mapVO = cHSAtdtHistoryMGTVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOsearchCgmEqAtchDtchHisDataRSQL(), param, velParam);
				if(dbRowset.next()){
					cgmEqAtchDtchHisMGTVO = new CHSAtchDtchHisMGTVO();
					cgmEqAtchDtchHisMGTVO.setEqNo(dbRowset.getString("eq_no")); //
					cgmEqAtchDtchHisMGTVO.setCntrNo(dbRowset.getString("cntr_no")); //
					cgmEqAtchDtchHisMGTVO.setAtchDt(dbRowset.getString("atch_dt")); //
					cgmEqAtchDtchHisMGTVO.setAtchYdCd(dbRowset.getString("atch_yd_cd"));  //
					if(dbRowset.getString("dtch_dt")!=null){   //
						cgmEqAtchDtchHisMGTVO.setDtchDt(dbRowset.getString("dtch_dt"));
					}
					if(dbRowset.getString("dtch_yd_cd")!=null){
						cgmEqAtchDtchHisMGTVO.setDtchYdCd(dbRowset.getString("dtch_yd_cd")); //
					}
					if(dbRowset.getString("lag_dt")!=null){ //
						cgmEqAtchDtchHisMGTVO.setLagDt(dbRowset.getString("lag_dt"));
					}
					if(dbRowset.getString("lag_dt_yd")!=null){
						cgmEqAtchDtchHisMGTVO.setLagDtYd(dbRowset.getString("lag_dt_yd"));
					}
					if(dbRowset.getString("lead_dt")!=null){
						cgmEqAtchDtchHisMGTVO.setLeadDt(dbRowset.getString("lead_dt"));
					}
					if(dbRowset.getString("lead_dt_yd")!=null){
						cgmEqAtchDtchHisMGTVO.setLeadDt(dbRowset.getString("lead_dt_yd"));
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
		return cgmEqAtchDtchHisMGTVO;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMovementHistoryDBDAOSearchCtmMvmtSourceDataRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOMVMTBookingInfoVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOMVMTHistoryListVORSQL(), param, velParam);
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
	 * @param CHSmgstChkINVO cHSmgstChkINVO
	 * @return List<CHSmgstChkINVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSmgstChkINVO> searchchssAtdtVerifyList(CHSmgstChkINVO cHSmgstChkINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSmgstChkINVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cHSmgstChkINVO != null){
				Map<String, String> mapVO = cHSmgstChkINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOsearchchssAtdtVerifyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSmgstChkINVO.class);
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
	 * @param CHSmgstChkINVO cHSmgstChkINVO
	 * @return List<CHSmgstChkINVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSmgstChkINVO> searchchssTpszOnCntrCHkList(CHSmgstChkINVO cHSmgstChkINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSmgstChkINVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cHSmgstChkINVO != null){
				Map<String, String> mapVO = cHSmgstChkINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOsearchchssTpszOnCntrCHkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSmgstChkINVO.class);
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
	 * Shipper's Chassis의 Movement 관리현황을 조회합니다.<br>
	 *
	 * @param ShipCHSMvmtMGTVO shipCHSMvmtMGTVO
	 * @return List<ShipCHSMvmtMGTVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ShipCHSMvmtMGTVO> searchShipChsMovementListData(ShipCHSMvmtMGTVO shipCHSMvmtMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ShipCHSMvmtMGTVO> list = null;

		int currentPage = shipCHSMvmtMGTVO.getIPage();
		int startNo = PAGE_SIZE_1000 * (currentPage -1) +1;
		int endNo   = PAGE_SIZE_1000 *  currentPage;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startno", startNo);
		param.put("endno", endNo);
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("startno", startNo);
        velParam.put("endno", endNo);

		try{
			if(shipCHSMvmtMGTVO != null){
				Map<String, String> mapVO = shipCHSMvmtMGTVO.getColumnValues();
				param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOsearchShipChsMovementListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ShipCHSMvmtMGTVO.class);
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
	 * Shipper's Chassis의 Movement 전체건수를 조회합니다.<br>
	 *
	 * @param ShipCHSMvmtMGTVO shipCHSMvmtMGTVO
	 * @return int
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public int searchShipChsMovementCountData(ShipCHSMvmtMGTVO shipCHSMvmtMGTVO) throws DAOException {
		int totalCnt = 0;
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(shipCHSMvmtMGTVO != null){
				Map<String, String> mapVO = shipCHSMvmtMGTVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMovementHistoryDBDAOsearchShipChsMovementCountRSQL(), param, velParam);
			if(dbRowset.next()) {
				totalCnt = dbRowset.getInt("TOTAL_CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return totalCnt;
	}

}