/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : TrendLineDBDAO.java
 *@FileTitle : TrendLineDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.15
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.11.15 진마리아
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.FcmEstmWkCsmIfVO;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.FcmRmnOilMonEndRptVO;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.MonEstmCsmVO;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.basic.TrendLineBCImpl;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS TrendLineDBDAO<br>
 * ALPS TEMP1 Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Maria Chin
 * @see TrendLineBCImpl 참조
 * @since J2EE 1.6
 */

public class EstimationDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Search target VVD for a monthly estimation consumption.<br>
	 * 
	 * @param String exeYrmon
	 * @return List<MonEstmCsmVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MonEstmCsmVO> searchMonEstmTgtVvdList(String exeYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmCsmVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("exe_yrmon", exeYrmon);
			velParam.put("exe_yrmon", exeYrmon);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EstimationDBDAOSearchMonEstmCsmTgtVvdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MonEstmCsmVO.class);
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
	 * Search a monthly estimation consumption.<br>
	 * 
	 * @param String exeYrmon
	 * @return List<MonEstmCsmVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MonEstmCsmVO> searchMonEstmCsm(String exeYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmCsmVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("exe_yrmon", exeYrmon);
			velParam.put("exe_yrmon", exeYrmon);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EstimationDBDAOMonEstmCsmVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MonEstmCsmVO.class);
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
	 * Search trend line by VVD.
	 * 
	 * @param MonEstmCsmVO monEstmCsmVO
	 * @return FcmTrndLineVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public FcmTrndLineVO searchTrendLineByVvd(MonEstmCsmVO monEstmCsmVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			FcmTrndLineVO fcmTrndLineVO = new FcmTrndLineVO();
			if(monEstmCsmVO!=null){
				Map<String, String> mapVO = monEstmCsmVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EstimationDBDAOSearchTrendLineByVvdRSQL(), param, velParam);
				List<FcmTrndLineVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmTrndLineVO.class);
				if(list.size()>0){
					fcmTrndLineVO = list.get(0);
				}
			}
			return fcmTrndLineVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Search actual start, end info by VVD.
	 * 
	 * @param MonEstmCsmVO monEstmCsmVO
	 * @exception DAOException
	 */
	public void searchActStEndByVvd(MonEstmCsmVO monEstmCsmVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(monEstmCsmVO!=null){
				Map<String, String> mapVO = monEstmCsmVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EstimationDBDAOSearchActStEndByVvdRSQL(), param, velParam);
				if(dbRowset.next()){
					monEstmCsmVO.setActStPortCd(dbRowset.getString("ST_PORT_CD"));
					monEstmCsmVO.setActStDt(dbRowset.getString("ST_ETB_DT"));
					monEstmCsmVO.setEndSkdVoyNo(dbRowset.getString("END_SKD_VOY_NO"));
					monEstmCsmVO.setEndSkdDirCd(dbRowset.getString("END_SKD_DIR_CD"));
					monEstmCsmVO.setEndClptIndSeq(dbRowset.getString("END_CLPT_IND_SEQ"));
					monEstmCsmVO.setActEndPortCd(dbRowset.getString("END_PORT_CD"));
					monEstmCsmVO.setActEndDt(dbRowset.getString("END_ETB_DT"));
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
	 * Search voyage end remain oil weight by VVD.
	 * 
	 * @param MonEstmCsmVO monEstmCsmVO
	 * @exception DAOException
	 */
	public void searchVoyEndRmnOilWgtByVvd(MonEstmCsmVO monEstmCsmVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(monEstmCsmVO!=null){
				Map<String, String> mapVO = monEstmCsmVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EstimationDBDAOSearchVoyEndRmnOilWgtByVvdRSQL(), param, velParam);
				if(dbRowset.next()){
					monEstmCsmVO.setVoyEndRmnWgt(dbRowset.getString("VOY_END_RMN_WGT"));
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
	 * Search a arrival oil weight at the last calling port.
	 * 
	 * @param MonEstmCsmVO monEstmCsmVO
	 * @exception DAOException
	 */
	public void searchArrOilWgtLastPort(MonEstmCsmVO monEstmCsmVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(monEstmCsmVO!=null){
				Map<String, String> mapVO = monEstmCsmVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EstimationDBDAOSearchArrOilWgtLastPortRSQL(), param, velParam);
				if(dbRowset.next()){
//					fcmEstmMonCsmIfVO.setFoilVvdEndCsmWgt(dbRowset.getString(1));
//					fcmEstmMonCsmIfVO.setDoilVvdEndCsmWgt(dbRowset.getString(2));
					
					monEstmCsmVO.setVoyEndRmnWgt(dbRowset.getString(1));
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
	 * Search a some VVD's remain oil weight at the month-end report
	 * 
	 * @param MonEstmCsmVO monEstmCsmVO
	 * @exception DAOException
	 */
	public void searchVvdRmnOilWgtAtMonEndRpt(MonEstmCsmVO monEstmCsmVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(monEstmCsmVO!=null){
				Map<String, String> mapVO = monEstmCsmVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EstimationDBDAOSearchVvdRmnOilWgtAtMonEndRptRSQL(), param, velParam);
				if(dbRowset.next()){
					monEstmCsmVO.setMonEndRmnWgt(dbRowset.getString(1));
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
	 * Search item error check No.2
	 * 
	 * @param MonEstmCsmVO monEstmCsmVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchItemErrorCheck2(MonEstmCsmVO monEstmCsmVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int errChk = 0;

		try {
			if(monEstmCsmVO!=null){
				Map<String, String> mapVO = monEstmCsmVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EstimationDBDAOSearchItemErrorCheck2RSQL(), param, velParam);
				if(dbRowset.next()){
					errChk = dbRowset.getInt(1);
				}
			}
			return errChk;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Remove the monthly estimation consumption of a specific month.
	 * 
	 * @param String exeYrmon
	 * @return int
	 * @throws DAOException
	 */
	public int removeMonEstmCsm(String exeYrmon) throws DAOException {
		int count = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(exeYrmon!=null && exeYrmon.length()==6){
				param.put("exe_yrmon", exeYrmon);
				velParam.put("exe_yrmon", exeYrmon);
				count = new SQLExecuter("").executeUpdate((ISQLTemplate) new EstimationDBDAOMonEstmCsmVODSQL(), param, velParam);
			}
			return count;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Add the monthly estimation consumption of a specific month.
	 * 
	 * @param List<MonEstmCsmVO> monEstmCsmVOs
	 * @param String usrId
	 * @return int
	 * @throws DAOException
	 */
	public int[] addMonEstmCsm(List<MonEstmCsmVO> monEstmCsmVOs, String usrId) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(monEstmCsmVOs!=null && monEstmCsmVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EstimationDBDAOMonEstmCsmVOCSQL(), monEstmCsmVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			return insCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 주간 추정 대상 항차를 조회한다.
	 * 
	 * @param FcmEstmWkCsmIfVO fcmEstmWkCsmIfVO
	 * @return List<FcmEstmWkCsmIfVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmEstmWkCsmIfVO> searchWeekTgtVvdInfo(FcmEstmWkCsmIfVO fcmEstmWkCsmIfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmEstmWkCsmIfVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(fcmEstmWkCsmIfVO != null){
				Map<String, String> mapVO = fcmEstmWkCsmIfVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EstimationDBDAOFcmEstmWkCsmIfVORSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmEstmWkCsmIfVO.class);
			}
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
	 * Revenue Month별 Vessel 월말 잔량 내역을 조회한다.
	 * 
	 * @param FcmRmnOilMonEndRptVO fcmRmnOilMonEndRptVO
	 * @return List<FcmRmnOilMonEndRptVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmRmnOilMonEndRptVO> searchRemainOilMonthEndReport(FcmRmnOilMonEndRptVO fcmRmnOilMonEndRptVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmRmnOilMonEndRptVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(fcmRmnOilMonEndRptVO != null){
				Map<String, String> mapVO = fcmRmnOilMonEndRptVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EstimationDBDAOSearchRemainOilMonthEndReportRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmRmnOilMonEndRptVO.class);
			}
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
	 * Revenue Month별 Vessel 월말 잔량 내역을 변경한다.
	 * 
	 * @param FcmRmnOilMonEndRptVO[] fcmRmnOilMonEndRptVOs
	 * @param String updUsrId
	 * @return int
	 * @exception DAOException
	 */
	public int modifyRemainOilMonthEndReport(FcmRmnOilMonEndRptVO[] fcmRmnOilMonEndRptVOs, String updUsrId) throws DAOException {
		int count = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			for(FcmRmnOilMonEndRptVO fcmRmnOilMonEndRptVO : fcmRmnOilMonEndRptVOs){
				fcmRmnOilMonEndRptVO.setUpdUsrId(updUsrId);
				Map<String, String> mapVO = fcmRmnOilMonEndRptVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				count = count + new SQLExecuter("").executeUpdate((ISQLTemplate) new EstimationDBDAOModifyRemainOilMonthEndReportUSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}
	
	/**
	 * Search auto I/F status.
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchAutoIFStatus() throws DAOException {
		DBRowSet dbRowset = null;
		String status = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EstimationDBDAOSearchAutoIFStatusRSQL(), param, velParam);
			if(dbRowset.next()){
				status = dbRowset.getString("AUTO_STATUS");
			}
			
			return status;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

}
