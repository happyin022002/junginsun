/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeClockStopMgtDBDAO.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.04.30 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic.TimeClockStopMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockChargeListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockStopParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.YardByOfficeVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;



/**
 * APLS TimeClockStopMgtDBDAO <br>
 * - APLS-DMTExceptionMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Sung Hwan
 * @see TimeClockStopMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class TimeClockStopMgtDBDAO extends DBDAOSupport {

	/**
	 * Clock Stop Number의 대한 TimeClockStop 데이터를 조회한다.<br>
	 * @param TimeClockStopParmVO timeClockStopParmVO
	 * @return List<DmtTimeClockStopVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DmtTimeClockStopVO> searchTimeClockStop(TimeClockStopParmVO timeClockStopParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DmtTimeClockStopVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(timeClockStopParmVO != null){
				Map<String, String> mapVO = timeClockStopParmVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtTimeClockStopVO .class);
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
	 * Clock Stop Number의 대한 TimeClockStop 데이터를 조회한다.<br>
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @return DmtTimeClockStopVO
	 * @throws DAOException
	 */
	public DmtTimeClockStopVO searchNewTimeClockStop(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException {
		DBRowSet dbRowset = null;
		DmtTimeClockStopVO  dmtTimeClockStop = new DmtTimeClockStopVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (dmtTimeClockStopVO != null) {
				Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TimeClockStopMgtDBDAODmtTimeClockStopVORSQL(),	param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset,	DmtTimeClockStopVO.class);
			
			if(dbRowset.next()){
				dmtTimeClockStop.setClkStopNo(dbRowset.getString("clk_stop_no"));
				dmtTimeClockStop.setCxlFlg(dbRowset.getString("cxl_flg"));
				dmtTimeClockStop.setDmdtTrfCd(dbRowset.getString("dmdt_trf_cd"));
				dmtTimeClockStop.setDmdtTrfNm(dbRowset.getString("dmdt_trf_nm"));
				dmtTimeClockStop.setClkStopOfcCd(dbRowset.getString("clk_stop_ofc_cd"));
				dmtTimeClockStop.setClkStopOfcNm(dbRowset.getString("clk_stop_ofc_nm"));
				dmtTimeClockStop.setClkStopFmDt(dbRowset.getString("clk_stop_fm_dt"));
				dmtTimeClockStop.setClkStopToDt(dbRowset.getString("clk_stop_to_dt"));
				dmtTimeClockStop.setStopDays(dbRowset.getString("stop_days"));
				dmtTimeClockStop.setClkStopRmk(dbRowset.getString("clk_stop_rmk"));
				dmtTimeClockStop.setCreUsrId(dbRowset.getString("cre_usr_id"));
				dmtTimeClockStop.setCreDt(dbRowset.getString("cre_dt"));
				dmtTimeClockStop.setCreOfcCd(dbRowset.getString("cre_ofc_cd"));
				dmtTimeClockStop.setUpdUsrId(dbRowset.getString("upd_usr_id"));
				dmtTimeClockStop.setUpdDt(dbRowset.getString("upd_dt"));
				dmtTimeClockStop.setUpdOfcCd(dbRowset.getString("upd_ofc_cd"));
				dmtTimeClockStop.setAllYdFlg(dbRowset.getString("all_yd_flg"));
			} else {
				log.debug("============================================================================");
				log.debug(" searchNewTimeClockStop::: No Data");
				log.debug("============================================================================");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dmtTimeClockStop;
	}
	 /**
	 * 삭제처리 요청으로 Clock Stop no에 대한 주키를 가지고 해당 데이타의 상태를 변경한다.<br>
	 * 
	 * @param DmtTimeClockStopVO updModel
	 * @throws DAOException
	 */
	public void removeTimeClockStop(DmtTimeClockStopVO updModel) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = updModel.getColumnValues();
			param.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopVOUSQL(), param, null);
			log.debug("[DBDAO]" + result);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 
	 /**
	 * TimeClock Stop no의 대한 List 데이터(다건의 데이터)를 조회한다.<br>
	 * @param TimeClockStopParmVO timeClockStopParmVO
	 * @return List<DmtTimeClockStopVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DmtTimeClockStopVO> searchTimeClockStopList(TimeClockStopParmVO timeClockStopParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DmtTimeClockStopVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(timeClockStopParmVO != null){
				Map<String, String> mapVO = timeClockStopParmVO .getColumnValues();
				String refOfcCd = timeClockStopParmVO.getClkStopOfcCd();
				String refTrfCd = timeClockStopParmVO.getDmdtTrfCd();
				if(!refOfcCd.equals("")) {
					
					Vector<String> ofcCdList = new Vector();
					StringTokenizer st = new StringTokenizer(refOfcCd, ",");
					
				    while (st.hasMoreTokens()) {
				    	ofcCdList.add(st.nextToken());
				    }
				    
				    Iterator itrOfcCd = ofcCdList.iterator();
					velParam.put("vel_ofc_cd", refOfcCd);
					velParam.put("sch_ofc_cd", itrOfcCd);
				}
				if(!refTrfCd.equals("")) {
					
					Vector<String> refTrfCdList = new Vector();
					StringTokenizer st2 = new StringTokenizer(refTrfCd, ",");
					
				    while (st2.hasMoreTokens()) {
				    	refTrfCdList.add(st2.nextToken());
				    }
				    
				    Iterator itrTrfCd = refTrfCdList.iterator();
					velParam.put("vel_trf_cd", refTrfCd);
					velParam.put("sch_trf_cd", itrTrfCd);
				}

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtTimeClockStopVO .class);
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
	 * 데이터를 저장시 해당조건의 값이 있는지 확인 처리를 위한 조회.<br>
	 * 2010.11.23. DMT_TM_CLK_STOP_YD 조건 추가
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchDmtTimeClockStopExist(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result = "";
		try {
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			
			//YARD CD LIST
			String ydCdList = (String)dmtTimeClockStopVO.getClkStopYdCd();
			
			List<String> aryYdCd = new ArrayList();
			StringTokenizer st = new StringTokenizer(ydCdList, ",");
			String tempS = "";
			while (st.hasMoreTokens()) {
		    	tempS = st.nextToken(); 
		    	aryYdCd.add(tempS);
		    	
		    	if(tempS.equals("All")) {
		    		continue;
		    	}
		    }
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("yd_cd_list", aryYdCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopExistRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getString("exist");
			}

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
	 * 데이터를 저장시 해당조건의 값이 있는지 확인 처리를 위한 조회.<br>
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDmtTimeClockStopNoExist(
			DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result = null;
		try {
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopNoExistRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getString("exist");
			}

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
	 * TimeClockStop NO 테이블에 데이터를 저장한다.<br>
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @throws DAOException
	 */
	public void addDmtTimeClockStopNo(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			param.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopNoCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * TimeClockStop 테이블에 데이터를 저장한다.<br>
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @throws DAOException
	 */
	public void addDmtTimeClockStop(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			param.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * TimeClockStop No테이블의 주키값인 seq+1의 데이터를 조회.<br>
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchDmtTimeClockStopNoSeq(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopNoSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getInt("seq");
			}

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
	 * TimeClockStop No 테이블에 데이터를 업데이트 한다.<br>
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @throws DAOException
	 */
	public void addDmtTimeClockStopNoSeq(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			param.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopNoSeqUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * TimeClockStop 테이블에 데이터를 저장 한다.<br>
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @throws DAOException
	 */
	public void addDmtTimeClockStopSeq(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			param.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopSeqCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * TimeClockStop의 주키를 생성 후 조회한다.<br>
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchTimeClockStopPK(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result = "";
		try {
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopPKRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getString("clk_stop_no");
			}
			
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
	 * TimeClockStop의 주키를 생성 후 조회한다.<br>
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchTimeClockStopSeqPK(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result = "";
		try {
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopSeqPKRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getString("clk_stop_no");
			}

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
	 * 사용자의 권한을 체크한다.<br>
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchAuthExist(String ofcCd)throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result = "";
		try {
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TimeClockStopMgtDBDAOGetAuthExistRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getString("AUTH_YN");
			}

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
	 * Time Clock 저장 후 계산 로직을 처리 할 대상 조회한다.<br>
	 * 
	 * @param String clkStopPk
	 * @return List<TimeClockChargeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TimeClockChargeListVO> searchTimeClockChargeList(String clkStopPk) throws DAOException {
		DBRowSet dbRowset = null;
		List<TimeClockChargeListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("clk_stop_no", clkStopPk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TimeClockStopMgtDBDAOSearchTimeClockChargeListRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,	TimeClockChargeListVO.class);
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
	 * Time Clock 취소 후 계산 로직을 처리 할 대상 조회한다.<br>
	 * 
	 * @param String clkStopPk
	 * @return List<TimeClockChargeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TimeClockChargeListVO> searchTimeClockCancelChargeList(String clkStopPk) throws DAOException {
		DBRowSet dbRowset = null;
		List<TimeClockChargeListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("clk_stop_no", clkStopPk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TimeClockStopMgtDBDAOSearchTimeClockCancelChargeListRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,	TimeClockChargeListVO.class);
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
	 * 구주지역 T/S Charge의 경우 - I/O BND를 CNTR_MOVE에서 정보 조회한다.<br>
	 * 
	 * @param String cntrNo
	 * @param String cntrCycNo
	 * @param String fmMvmtYdCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchInOutBoundByMovement(String cntrNo, String cntrCycNo, String fmMvmtYdCd) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			//Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.put("cntr_no", cntrNo);
			param.put("cntr_cyc_no", cntrCycNo);
			param.put("fm_mvmt_yd_cd", fmMvmtYdCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TimeClockStopMgtDBDAOSearchInOutBoundByMovementRSQL(), param, null);
			
			String result = "";
			if(dbRowset.next()){
				result = dbRowset.getString(1);
			}				
			
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Office에 대한 Yard Code를 조회한다.<br>
	 * 
	 * @param TimeClockStopParmVO timeClockStopParmVO
	 * @return List<YardByOfficeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<YardByOfficeVO> searchDMTYardByOffice(TimeClockStopParmVO timeClockStopParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardByOfficeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("ofc_cd", timeClockStopParmVO.getClkStopOfcCd());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TimeClockStopMgtDBDAOSearchDMTYardByOfficeRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,	YardByOfficeVO.class);
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
	 * TimeClockStopYard 테이블에 데이터를 저장한다.<br>
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @throws DAOException
	 */
	public void addDmtTimeClockStopYard(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			param.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopYardCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * Time Clock Stop Yard에 대한 Yard Code를 조회한다.<br>
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @return List<YardByOfficeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<YardByOfficeVO> searchDmtTimeClockStopYard(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardByOfficeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TimeClockStopMgtDBDAODmtTimeClockStopYardRSQL(),	param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,	YardByOfficeVO.class);
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
	 * TimeClockStopYard 테이블에 데이터를 저장한다.<br>
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @throws DAOException
	 */
	public void addDmtTimeClockStopYardSeq(DmtTimeClockStopVO dmtTimeClockStopVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = dmtTimeClockStopVO.getColumnValues();
			param.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new TimeClockStopMgtDBDAODmtTimeClockStopYardSeqCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	
}
