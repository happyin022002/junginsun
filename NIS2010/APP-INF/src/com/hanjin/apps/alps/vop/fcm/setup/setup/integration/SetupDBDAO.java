/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : TrendLineDBDAO.java
 *@FileTitle : TrendLineDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.23
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.11.15 진마리아
 * 1.0 Creation
 * 
 * History
 * 2012.04.23 진마리아 CHM-201217192-01 Vessel Registration 선박 추가 로직 변경 요청건
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.setup.setup.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmSavItmRgstVO;
import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmVslCntrRgstVO;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.basic.TrendLineBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmDepRptErrRtVO;

/**
 * ALPS SetupDBDAO<br>
 * ALPS SETUP Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Maria Chin
 * @see TrendLineBCImpl 참조
 * @since J2EE 1.6
 */

public class SetupDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Vessel Registration 정보를 조회한다.
	 * 
	 * @param FcmVslCntrRgstVO fcmVslCntrRgstVO
	 * @return List<FcmVslCntrRgstVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmVslCntrRgstVO> searchFcmVslCntrRgst(FcmVslCntrRgstVO fcmVslCntrRgstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmVslCntrRgstVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (fcmVslCntrRgstVO != null) {
				Map<String, String> mapVO = fcmVslCntrRgstVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SetupDBDAOFcmVslCntrRgstVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmVslCntrRgstVO.class);
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
	 * Vessel Registration 정보를 등록한다.
	 * 
	 * @param FcmVslCntrRgstVO fcmVslCntrRgstVO
	 * @exception DAOException
	 */
	public void addFcmVslCntrRgst(FcmVslCntrRgstVO fcmVslCntrRgstVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = fcmVslCntrRgstVO.getColumnValues();
			param.putAll(paramMap);
			velParam.putAll(paramMap);
			sqlExe.executeUpdate((ISQLTemplate) new SetupDBDAOFcmVslCntrRgstVOCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * Vessel Registration 정보를 변경한다.
	 * 
	 * @param FcmVslCntrRgstVO fcmVslCntrRgstVO
	 * @exception DAOException
	 */
	public void modifyFcmVslCntrRgst(FcmVslCntrRgstVO fcmVslCntrRgstVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = fcmVslCntrRgstVO.getColumnValues();
			param.putAll(paramMap);
			velParam.putAll(paramMap);
			sqlExe.executeUpdate((ISQLTemplate) new SetupDBDAOFcmVslCntrRgstVOUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * Vessel Registration 정보를 삭제한다.
	 * 
	 * @param List<FcmVslCntrRgstVO> fcmVslCntrRgstVOs
	 * @exception DAOException
	 */
	public void deleteFcmVslCntrRgst(List<FcmVslCntrRgstVO> fcmVslCntrRgstVOs) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			int updCnt[] = null;
			
			if(fcmVslCntrRgstVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SetupDBDAOFcmVslCntrRgstVODSQL(), fcmVslCntrRgstVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No"+ i + " SQL");
				}
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
	 * Item Registration 정보를 조회한다.
	 * 
	 * @param FcmSavItmRgstVO fcmSavItmRgstVO
	 * @return List<FcmSavItmRgstVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmSavItmRgstVO> searchFcmItmRgst(FcmSavItmRgstVO fcmSavItmRgstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmSavItmRgstVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (fcmSavItmRgstVO != null) {
				Map<String, String> mapVO = fcmSavItmRgstVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SetupDBDAOFcmSavItmRgstVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmSavItmRgstVO.class);
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
	 * Item Registration 정보를 등록한다.
	 * 
	 * @param FcmSavItmRgstVO fcmSavItmRgstVO
	 * @exception DAOException
	 */
	public void addFcmSavItmRgstVO(FcmSavItmRgstVO fcmSavItmRgstVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = fcmSavItmRgstVO.getColumnValues();
			param.putAll(paramMap);
			velParam.putAll(paramMap);
			sqlExe.executeUpdate((ISQLTemplate) new SetupDBDAOFcmSavItmRgstVOUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * Item Registration 정보를 변경한다.
	 * 
	 * @param FcmSavItmRgstVO fcmSavItmRgstVO
	 * @exception DAOException
	 */
	public void modifyFcmSavItmRgstVO(FcmSavItmRgstVO fcmSavItmRgstVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = fcmSavItmRgstVO.getColumnValues();
			param.putAll(paramMap);
			velParam.putAll(paramMap);
			sqlExe.executeUpdate((ISQLTemplate) new SetupDBDAOFcmSavItmRgstVOUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * Item Registration 정보를 삭제한다.
	 * 
	 * @param FcmSavItmRgstVO fcmSavItmRgstVO
	 * @return int
	 * @exception DAOException
	 */
	public int deleteFcmItmRgst(FcmSavItmRgstVO fcmSavItmRgstVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = fcmSavItmRgstVO.getColumnValues();
			param.putAll(paramMap);
			velParam.putAll(paramMap);
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new SetupDBDAOFcmSavItmRgstVODSQL(), param, velParam);
			return delCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Item Registration의 각 Design Capa에 대한 Vessel Sub Class Code를 구한다.
	 * 
	 * @param FcmSavItmRgstVO fcmSavItmRgstVO
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchVslClassSubCode(FcmSavItmRgstVO fcmSavItmRgstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = fcmSavItmRgstVO.getColumnValues();
			param.putAll(paramMap);
			velParam.putAll(paramMap);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SetupDBDAOVslClassSubCodeRSQL(), param, velParam);
			while(dbRowset.next()){
				list.add(dbRowset.getString(1));
			}
			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Vessel Registration에 기등록된 Vsl인지 check합니다.
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchVslCntrRgstExist(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String isExist = null;
		try{
			param.put("vsl_cd", vslCd);
			velParam.put("vsl_cd", vslCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SetupDBDAOSearchVslCntrRgstExistRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					isExist = dbRowset.getString("IS_EXIST");
				}
			}
			return isExist;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Vessel Registration에 기등록된 Vsl인지 check합니다.
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception DAOException
	 */
	public List<FcmDepRptErrRtVO> searchFcmDepRptErrRt(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<FcmDepRptErrRtVO> list = null;
	
		try{
			param.put("vsl_cd", vslCd);
			velParam.put("vsl_cd", vslCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SetupDBDAOFcmDepRptErrRtRSQL(), param, velParam);
		
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmDepRptErrRtVO.class);

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
	 * MDM의 Vessel 정보를 조회합니다.
	 * 
	 * @param String vslCd
	 * @return FcmVslCntrRgstVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public FcmVslCntrRgstVO searchMdmVslCntrRgstList(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmVslCntrRgstVO> list = null;
		FcmVslCntrRgstVO returnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("vsl_cd", vslCd);
			velParam.put("vsl_cd", vslCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SetupDBDAOSearchMdmVslCntrRgstListRSQL(), param, velParam);
			if(dbRowset != null){
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, FcmVslCntrRgstVO .class);
				
				if(list != null && list.size()>0){
					returnVO = list.get(0);
				}
			}
			return returnVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Search FMS vessel info.
	 * 
	 * @param String vslCd
	 * @return FcmVslCntrRgstVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public FcmVslCntrRgstVO searchFmsVslCntr(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmVslCntrRgstVO> list = null;
		FcmVslCntrRgstVO returnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("vsl_cd", vslCd);
			velParam.put("vsl_cd", vslCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SetupDBDAOSearchFmsVslCntrRSQL(), param, velParam);
			if(dbRowset != null){
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, FcmVslCntrRgstVO .class);
				
				if(list != null && list.size()>0){
					returnVO = list.get(0);
				}
			}
			return returnVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DEP.REPORT ERROR RATE를 저장합니다. <br>
	 * 
	 * @param List<FcmDepRptErrRtVO> fcmDepRptErrRtVOs
	 * @throws DAOException
	 */
	public void addFcmDepRptErrRt(List<FcmDepRptErrRtVO> fcmDepRptErrRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(fcmDepRptErrRtVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SetupDBDAOmodifyFcmDepRptErrRtSetupCSQL(), fcmDepRptErrRtVOs ,null);
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
	 * DEP.REPORT ERROR RATE를 삭제합니다. <br>
	 * 
	 * @param List<FcmDepRptErrRtVO> fcmDepRptErrRtVOs
	 * @throws DAOException
	 */
	public void removeFcmDepRptErrRt(List<FcmDepRptErrRtVO> fcmDepRptErrRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(fcmDepRptErrRtVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SetupDBDAOdeleteFcmDepRptErrRtDSQL(), fcmDepRptErrRtVOs ,null);
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
