/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryDBDAO.java
*@FileTitle : sdfds
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.06 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBCImpl;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSAtdtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSMovementHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CNTRMvmtMGTVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ChassisMgsetAttachDetachHistoryDBDAO <br>
 * - ALPS-MovementMnrHistory system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author CHOI MIN HOI
 * @see ChassisMgsetAttachDetachHistoryBCImpl 참조
 * @since J2EE 1.6
 */
public class ChassisMgsetAttachDetachHistoryDBDAO extends DBDAOSupport {


	/**
	 * CGM CHASSIS ATTACH DETACH HISTORY 의 속성을 수정한다. [EES_CGM_1142].<br>
	 *
	 * @param cHSMovementHistoryMGTVOs List<CHSMovementHistoryMGTVO>
	 * @exception DAOException
	 */
	 public void modifyCHSAtdtHistoryInBetweenData(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSMovementHistoryMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtHistoryInBetweenDataUSQL(), cHSMovementHistoryMGTVOs,null);
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
	 *  CHS Bare mvmt 발생시 호출되며,GM EQ AT/DT HISTORY 엔티티에서 해당 장비의 AT/DT 상태를 조회. [EES_CGM_1015].<br>
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @return List<CHSAtdtHistoryMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CHSAtdtHistoryMGTVO> searchCHSAtdtStsData(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSAtdtHistoryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSAtdtHistoryMGTVO != null) {
				Map<String, String> mapVO = cHSAtdtHistoryMGTVO. getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetAttachDetachHistoryDBDAOsearchCHSAtdtStsDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSAtdtHistoryMGTVO.class);
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
	 *   CGM CHASSIS ATTACH DETACH HISTORY 정보를 삽입한다.[EES_CGM_1015].<br>
	 *
	 * @param cHSMovementHistoryMGTVOs List<chassisMovementHistoryMGTVO>
	 * @return  boolean
	 * @exception DAOException
	 */
	  public boolean addCHSAtdtHistoryData(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws DAOException, Exception {
		boolean rtn = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		CHSMovementHistoryMGTVO chass = new CHSMovementHistoryMGTVO();
		int result=0;
		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (cHSMovementHistoryMGTVOs.size() > 0) {
				for (int i = 0; i < cHSMovementHistoryMGTVOs.size(); i++) {
					chass = new CHSMovementHistoryMGTVO();
					chass = cHSMovementHistoryMGTVOs.get(i);
					log.debug("tmp.getCntrNo1()======"+i);
					log.debug("tmp.getCntrNo1()======"+chass.getCntrNo());

					Map<String, String> mapVO = chass.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					result = sqlExe.executeUpdate((ISQLTemplate)new ChassisMgsetAttachDetachHistoryDBDAOaddCHSAtdtHistoryDataCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert SQL");

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
	 *   CGM EQ AT/DT HISTORY 엔티티에서 해당 장비의 AT/DT 상태를 조회 .[EES_CGM_2016].<br>
	 *
	 * @param mGSAtdtHistoryMGTVO MGSAtdtHistoryMGTVO
	 * @return  List<MGSAtdtHistoryMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<MGSAtdtHistoryMGTVO> searchMGSAtdtStsData(MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<MGSAtdtHistoryMGTVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (mGSAtdtHistoryMGTVO != null) {
					Map<String, String> mapVO = mGSAtdtHistoryMGTVO. getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetAttachDetachHistoryDBDAOsearchMGSAtdtStsDataRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSAtdtHistoryMGTVO.class);
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
	 *    CGM CHASSIS ATTACH DETACH HISTORY 정보를 삽입한다. .[EES_CGM_2016].<br>
	 *
	 * @param cHSMovementHistoryMGTVOs List<chassisMovementHistoryMGTVO>
	 * @return  boolean
	 * @exception DAOException
	 */
	  public boolean addMGSAtdtHistoryData(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws DAOException, Exception {
			boolean rtn = false;

			//query parameter
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				if (cHSMovementHistoryMGTVOs.size() > 0) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetAttachDetachHistoryDBDAOaddMGSAtdtHistoryDataCSQL(), cHSMovementHistoryMGTVOs, null);
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
	 *    CGM CHASSIS ATTACH DETACH HISTORY 의 속성을 수정한다.. .[EES_CGM_2016].<br>
	 *
	 * @param cHSMovementHistoryMGTVOs List<chassisMovementHistoryMGTVO>
	 * @exception DAOException
	 */
	 public void modifyMGSAtdtHistoryData(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if(cHSMovementHistoryMGTVOs.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSAtdtHistoryDataUSQL(), cHSMovementHistoryMGTVOs,null);
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
	 * MGS Current Location반영을 위해 MGS AT/DT History 이벤트시 INVENTORY 수정.. [EES_CGM_2016].<br>
	 *
	 * @param cHSMovementHistoryMGTVOs List<chassisMovementHistoryMGTVO>
	 * @exception DAOException
	 */
	 public void modifyMGSCurrentLocationData(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSMovementHistoryMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSCurrentLocationDataUSQL(), cHSMovementHistoryMGTVOs,null);
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
	 * MGS Current Chassis반영을 위해 MGS AT/DT History 이벤트시 INVENTORY 수정.. [EES_CGM_2016].<br>
	 *
	 * @param cHSMovementHistoryMGTVOs List<chassisMovementHistoryMGTVO>
	 * @exception DAOException
	 */
	 public void modifyMGSCurrentChassisData(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSMovementHistoryMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSCurrentChassisDataUSQL(), cHSMovementHistoryMGTVOs,null);
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
	 *  MVMT생성시 관련 CHS로 DT를 수행.[EES_CGM_1109].<br>
	 *
	 * @param cNTRMvmtMGTVO CNTRMvmtMGTVO
	 * @exception DAOException
	 */
	 public void modifyCHSDetachByChssData(CNTRMvmtMGTVO cNTRMvmtMGTVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		try{
			if(cNTRMvmtMGTVO != null){
				Map<String, String> param = cNTRMvmtMGTVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSDetachByChssDataUSQL(), param, null);
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
	 *    CGM CHASSIS ATTACH DETACH HISTORY 의 속성을 입력 한다.. .[EES_CGM_1109].<br>
	 *
	 * @param cHSMovementHistoryMGTVOs List<chassisMovementHistoryMGTVO>
	 * @exception DAOException
	 */
	  public void addCHSAtdtByMvmtData(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		CHSMovementHistoryMGTVO chass = new CHSMovementHistoryMGTVO();
		int result=0;
		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (cHSMovementHistoryMGTVOs.size() > 0) {
				for (int i = 0; i < cHSMovementHistoryMGTVOs.size(); i++) {
					chass = new CHSMovementHistoryMGTVO();
					chass = cHSMovementHistoryMGTVOs.get(i);
					log.debug("tmp.getCntrNo1()======"+i);
					log.debug("tmp.getCntrNo1()======"+chass.getCntrNo());

					Map<String, String> mapVO = chass.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					result = sqlExe.executeUpdate((ISQLTemplate)new ChassisMgsetAttachDetachHistoryDBDAOaddCHSAtdtByMvmtDataCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert SQL");

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
	 *   CGM CHASSIS ATTACH DETACH History 데이를 삭제한다.[EES_CGM_1109].<br>
	 *
	 * @param cHSMovementHistoryMGTVOs List<chassisMovementHistoryMGTVO>
	 * @exception DAOException
	 */
	 public void removeCHSAtdtByMvmtData(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSMovementHistoryMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAttachDetachHistoryDBDAOremoveCHSAtdtByMvmtDataDSQL(), cHSMovementHistoryMGTVOs,null);
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
	  * ctm 으로 부터  atdt 업데이트
	  *
	  * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	  * @exception DAOException
	  * @exception Exception
	  */
	public void modifyCHSAtdtHistoryData(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws DAOException,Exception {
	    SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			log.debug("manageCgmChssMvmtHisData==================================");
		try{
			if(cHSAtdtHistoryMGTVO != null){
				Map<String, String> param = cHSAtdtHistoryMGTVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtHistoryDataUSQL(), param, null);
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
	  * date,yard 변경시   바로 전 detach 정보  수정한다
	  *
	  * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	  * @exception DAOException
	  * @exception Exception
	  */
	public void modifyCHSAtdtPreHistoryByCtmUpdData(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws DAOException,Exception {
	    SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			log.debug("modifyCHSAtdtPreHistoryByCtmUpdData==================================");
		try{
			if(cHSAtdtHistoryMGTVO != null){
				Map<String, String> param = cHSAtdtHistoryMGTVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtPreHistoryByCtmUpdDataUSQL(), param, null);
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
	  * date,yard 변경시   바로 이후 atach 정보  수정한다
	  *
	  * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	  * @exception DAOException
	  * @exception Exception
	  */
	public void modifyCHSAtdtPreHistoryByCtmDelData(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws DAOException,Exception {
	    SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			log.debug("modifyCHSAtdtPreHistoryByCtmUpdData==================================");
		try{
			if(cHSAtdtHistoryMGTVO != null){
				Map<String, String> param = cHSAtdtHistoryMGTVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtPreHistoryByCtmDelDataUSQL(), param, null);
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
	 * 삭제시 바로 이후 atach 정보  수정한다
	 *
	 * @param cHSMovementHistoryMGTVOs List<CHSMovementHistoryMGTVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyCHSAtdtByRemoveBareMvmtData(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws DAOException,Exception {
			//query parameter
			log.debug("modifyCHSAtdtPreHistoryByCtmUpdData==================================");
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSMovementHistoryMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtByRemoveBareMvmtDataUSQL(), cHSMovementHistoryMGTVOs,null);
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
	 *  M.G.Set Eq Master AT/DT 정보 다건의 데이터를 일괄적으로 삭제한다. [EES_CGM_2006].<br>
	 *
	 * @param mGSAtdtHistoryINVOs List<MGSAtdtHistoryINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void removeMGSAtdtHistoryData(List<MGSAtdtHistoryINVO> mGSAtdtHistoryINVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSAtdtHistoryINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetAttachDetachHistoryDBDAOremoveMGSAtdtHistoryDataDSQL(), mGSAtdtHistoryINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 *  M.G.Set Eq Master AT/DT 정보 다건의 데이터를 일괄적으로 갱신한다. [EES_CGM_2006].<br>
	 *
	 * @param mGSAtdtHistoryINVOs List<MGSAtdtHistoryINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyMGSAtdtLastHistoryData(List<MGSAtdtHistoryINVO> mGSAtdtHistoryINVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSAtdtHistoryINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSAtdtLastHistoryDataUSQL(), mGSAtdtHistoryINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
}