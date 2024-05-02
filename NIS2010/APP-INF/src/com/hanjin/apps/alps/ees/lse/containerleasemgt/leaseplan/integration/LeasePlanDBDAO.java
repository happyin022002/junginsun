/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeasePlanDAO.java
*@FileTitle : Long Term Lease CNTR Delivery Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.basic.LeasePlanBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanPerformanceDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanPerformanceVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePerformanceVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanRccVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanSearchVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.PlanSearchVO;
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.LseOffhPlnVO;


/**
 * ALPS LeasePlanDAO <br>
 * - ALPS-ContainerLeaseMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Nho Jung Yong
 * @see LeasePlanBCImpl 참조
 * @since J2EE 1.4
 */
public class LeasePlanDBDAO extends DBDAOSupport {

	/**
	 * Long Term Lease Delivery Plan을 조회합니다.<br>
	 *
	 * @param PlanSearchVO planSearchVO
	 * @return List<LeasePlanVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LeasePlanVO> searchLongTermCNTRDeliveryPlanListData(PlanSearchVO planSearchVO) throws DAOException {
		int currentPage = planSearchVO.getIPage();
		int startNo     = Constants.PAGE_SIZE_100 * (currentPage - 1) + 1;
		int endNo       = Constants.PAGE_SIZE_100 * currentPage;

		DBRowSet dbRowset = null;
		List<LeasePlanVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(planSearchVO != null){
				Map<String, String> mapVO = planSearchVO.getColumnValues();

				param.putAll(mapVO);
				param.put("startno", startNo);
				param.put("endno", endNo);

				velParam.putAll(mapVO);
				velParam.put("startno", startNo);
				velParam.put("endno", endNo);
			}
			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAOLongTermCNTRDeliveryPlanListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LeasePlanVO.class);
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
	 * 입력 조건에 대한 Long Term Lease Delivery Plan 데이타 건수를 조회합니다.<br>
	 *
	 * @param PlanSearchVO planSearchVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchLongTermCNTRDeliveryPlanListCountData(PlanSearchVO planSearchVO) throws DAOException {
		int cnt  =0;
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	    	if(planSearchVO != null){
	    		Map<String, String> mapVO = planSearchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAOLongTermCNTRDeliveryPlanListCountRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		cnt = dbRowset.getInt("CNT");
	    	}
	    } catch (SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return cnt;
	}

	/**
	 * Long Term Lease Delivery Plan 단건을 조회합니다.<br>
	 *
	 * @param  LeasePlanVO leasePlanVO
	 * @return List<LeasePlanVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LeasePlanVO> searchLongTermCNTRDeliveryPlanData(LeasePlanVO leasePlanVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LeasePlanVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(leasePlanVO != null){
				Map<String, String> mapVO = leasePlanVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAOLongTermCNTRDeliveryPlanRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LeasePlanVO.class);
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
	 * Long Term Lease Delivery Plan 다건의 데이터를 일괄적으로 생성합니다.<br>
	 *
	 * @param  List<LeasePlanVO> leasePlanVOs
	 * @throws DAOException
	 */
	public void addLongTermCNTRDeliveryPlansData(List<LeasePlanVO> leasePlanVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(leasePlanVOs.size() > 0){
				insCnt = sqlExe.executeBatch(new LeasePlanDBDAOLongTermCNTRDeliveryPlanCSQL(), leasePlanVOs, null);
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
	 * Long Term Lease Delivery Plan 다건의 데이터를 일괄적으로 갱신합니다.<br>
	 *
	 * @param  List<LeasePlanVO> leasePlanVOs
	 * @throws DAOException
	 */
	public void modifyLongTermCNTRDeliveryPlansData(List<LeasePlanVO> leasePlanVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(leasePlanVOs.size() > 0){
				updCnt = sqlExe.executeBatch(new LeasePlanDBDAOLongTermCNTRDeliveryPlanUSQL(), leasePlanVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * Long Term Lease Delivery Plan 다건의 데이터를 일괄적으로 삭제합니다.<br>
	 *
	 * @param  List<LeasePlanVO> leasePlanVOs
	 * @throws DAOException
	 */
	public void removeLongTermCNTRDeliveryPlansData(List<LeasePlanVO> leasePlanVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(leasePlanVOs.size() > 0){
				delCnt = sqlExe.executeBatch(new LeasePlanDBDAOLongTermCNTRDeliveryPlanDSQL(), leasePlanVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * Long Term Lease Delivery Plan 데이터를 일괄적으로 삭제합니다.<br>
	 *
	 * @param  List<LeasePlanVO> leasePlanVOs
	 * @throws DAOException
	 */
	public void removeAllLongTermCNTRDeliveryPlansData(List<LeasePlanVO> leasePlanVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(leasePlanVOs.size() > 0){
				delCnt = sqlExe.executeBatch(new LeasePlanDBDAOLongTermCNTRDeliveryPlanAllDSQL(), leasePlanVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * Long Term Lease Delivery Performance 를 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LeasePlanPerformanceVO> searchLongTermCNTRDeliveryPerformanceListData(PlanSearchVO planSearchVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<LeasePlanPerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(planSearchVO != null){

				Map<String, String> mapVO = planSearchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> arrDcMon      = null;
				List<String> arrCntrTpszCd = null;

				if ( !JSPUtil.getNull(planSearchVO.getDeMon()).equals("") ) {
					arrDcMon = JSPUtil.convertStringToArrayList(JSPUtil.replace(planSearchVO.getDeMon(),",","|"));
					param.put("de_mon_seq", arrDcMon);
					velParam.put("de_mon_seq", arrDcMon);
				}

				if ( !JSPUtil.getNull(planSearchVO.getCntrTpszCd()).equals("") ) {
					arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(planSearchVO.getCntrTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAOLongTermCNTRDeliveryPerformanceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LeasePlanPerformanceVO.class);
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
	 * Long Term Lease Delivery Performance 의 Detail 를 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LeasePlanPerformanceDetailVO> searchLongTermCNTRDeliveryPerformanceDetailData(PlanSearchVO planSearchVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<LeasePlanPerformanceDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(planSearchVO != null){

				Map<String, String> mapVO = planSearchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAOLongTermCNTRDeliveryPerformanceDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LeasePlanPerformanceDetailVO.class);
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
	 * 입력받은 AGMT No.에 대한 중복여부를 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchNewVanCNTRDeliveryPlanAvailData(PlanSearchVO planSearchVO) throws DAOException {
		String dupYrmon = "";
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	    	if(planSearchVO != null) {
	    		Map<String, String> mapVO = planSearchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter().executeQuery(new LeasePlanDBDAONewVanCNTRDeliveryPlanAvailRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		dupYrmon = dbRowset.getString("DUP_YRMON");
	    	}
	    } catch(SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

		return dupYrmon;
	}

	/**
	 * 신조장비(OW/LP/OL) 계획목록을 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<LeasePlanVO> searchNewVanCNTRDeliveryPlanListData(PlanSearchVO planSearchVO) throws DAOException {
		int currentPage = planSearchVO.getIPage();
		int startNo = Constants.PAGE_SIZE_100 * (currentPage -1) +1;
		int endNo   = Constants.PAGE_SIZE_100 *  currentPage;

		DBRowSet dbRowset = null;
		List<LeasePlanVO> resultVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(planSearchVO != null) {
				Map<String, String> mapVO = planSearchVO.getColumnValues();

				param.putAll(mapVO);
				param.put("startno", startNo);
				param.put("endno", endNo);

				velParam.putAll(mapVO);
				velParam.put("startno", startNo);
				velParam.put("endno", endNo);
			}

			dbRowset  = new SQLExecuter().executeQuery(new LeasePlanDBDAONewVanCNTRDeliveryPlanListRSQL(), param, velParam);
			resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, LeasePlanVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return resultVOs;
	}

	/**
	 * 신조장비(OW/LP/OL) 계획목록 전체건수를 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int searchNewVanCNTRDeliveryPlanListCountData(PlanSearchVO planSearchVO) throws DAOException {
		int totalCnt = 0;
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	    	if(planSearchVO != null) {
	    		Map<String, String> mapVO = planSearchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter().executeQuery(new LeasePlanDBDAONewVanCNTRDeliveryPlanCountRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		totalCnt = dbRowset.getInt("TOTAL_CNT");
	    	}
	    } catch(SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

		return totalCnt;
	}

	/**
	 * 신조장비(OW/LP/OL) 계획내용의 존재여부를 조회합니다.<br>
	 *
	 * @param  LeasePlanVO leasePlanVO
	 * @return boolean
	 * @throws DAOException
	 * @throws Exception
	 */
	public boolean isExistNewVanCNTRDeliveryPlanData(LeasePlanVO leasePlanVO) throws DAOException {
		boolean existFlag = false;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(leasePlanVO != null) {
				Map<String, String> mapVO = leasePlanVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter().executeQuery(new LeasePlanDBDAONewVanCNTRDeliveryPlanRSQL(), param, velParam);
			existFlag = dbRowset.next();
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return existFlag;
	}

	/**
	 * 신조장비(OW/LP/OL) 계획자료를 일괄 생성합니다.<br>
	 *
	 * @param  List<LeasePlanVO> leasePlanVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addNewVanCNTRDeliveryPlanListData(List<LeasePlanVO> leasePlanVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int insCnt[] = null;
			if(leasePlanVOs.size() > 0) {
				insCnt = sqlExe.executeBatch(new LeasePlanDBDAONewVanCNTRDeliveryPlanCSQL(), leasePlanVOs, null);
				for(int i = 0; i < insCnt.length; i++) {
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 신조장비(OW/LP/OL) 계획자료를 일괄 갱신합니다.<br>
	 *
	 * @param  List<LeasePlanVO> leasePlanVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyNewVanCNTRDeliveryPlanListData(List<LeasePlanVO> leasePlanVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int updCnt[] = null;
			if(leasePlanVOs.size() > 0) {
				updCnt = sqlExe.executeBatch(new LeasePlanDBDAONewVanCNTRDeliveryPlanUSQL(), leasePlanVOs, null);
				for(int i = 0; i < updCnt.length; i++) {
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 신조장비(OW/LP/OL) 계획자료를 일괄 삭제합니다.<br>
	 *
	 * @param  List<LeasePlanVO> leasePlanVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeNewVanCNTRDeliveryPlanListData(List<LeasePlanVO> leasePlanVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int delCnt[] = null;
			if(leasePlanVOs.size() > 0) {
				delCnt = sqlExe.executeBatch(new LeasePlanDBDAONewVanCNTRDeliveryPlanDSQL(), leasePlanVOs, null);
				for(int i = 0; i < delCnt.length; i++) {
					if(delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 신조(자가/장기)장비 인수계획 대비 실적목록을 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LeasePlanPerformanceVO> searchNewVanCNTRDeliveryPlanPerformanceListData(PlanSearchVO planSearchVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<LeasePlanPerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(planSearchVO != null){
				Map<String, String> mapVO = planSearchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> arrPlnMonCd  = null;
				List<String> arrMftVndrCd  = null;
				List<String> arrCntrTpszCd = null;

				if ( !JSPUtil.getNull(planSearchVO.getPlnMonCd()).equals("") ) {
					arrPlnMonCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(planSearchVO.getPlnMonCd(),",","|"));
					param.put("pln_mon_cd_seq", arrPlnMonCd);
					velParam.put("pln_mon_cd_seq", arrPlnMonCd);
				}

				if ( !JSPUtil.getNull(planSearchVO.getMftVndrSeq()).equals("") ) {
					arrMftVndrCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(planSearchVO.getMftVndrSeq(),",","|"));
					param.put("mft_vndr_cd_seq", arrMftVndrCd);
					velParam.put("mft_vndr_cd_seq", arrMftVndrCd);
				}

				if ( !JSPUtil.getNull(planSearchVO.getCntrTpszCd()).equals("") ) {
					arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(planSearchVO.getCntrTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAONewVanCNTRDeliveryPlanPerformanceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LeasePlanPerformanceVO.class);
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
	 * 신조(자가/장기)장비 인수계획 대비 실적별 상세내역을 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LeasePlanPerformanceDetailVO> searchNewVanCNTRDeliveryPlanPerformanceDetailData(PlanSearchVO planSearchVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<LeasePlanPerformanceDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(planSearchVO != null){
				Map<String, String> mapVO = planSearchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> arrDeMonCd  = null;
				List<String> arrMftVndrCd  = null;
				List<String> arrCntrTpszCd = null;

				if ( !JSPUtil.getNull(planSearchVO.getDeMon()).equals("") ) {
					arrDeMonCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(planSearchVO.getDeMon(),",","|"));
					param.put("de_mon_seq", arrDeMonCd);
					velParam.put("de_mon_seq", arrDeMonCd);
				}

				if ( !JSPUtil.getNull(planSearchVO.getMftVndrSeq()).equals("") ) {
					arrMftVndrCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(planSearchVO.getMftVndrSeq(),",","|"));
					param.put("mft_vndr_cd_seq", arrMftVndrCd);
					velParam.put("mft_vndr_cd_seq", arrMftVndrCd);
				}

				if ( !JSPUtil.getNull(planSearchVO.getCntrTpszCd()).equals("") ) {
					arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(planSearchVO.getCntrTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAONewVanCNTRDeliveryPlanPerformanceDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LeasePlanPerformanceDetailVO.class);
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
	 * Off-Hire Plan Input &amp; Update by H/Q 를 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @return List<OffHirePlanVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OffHirePlanVO> searchOffHirePlanData(OffHirePlanSearchVO offHirePlanSearchVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<OffHirePlanVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(offHirePlanSearchVO != null){

				Map<String, String> mapVO = offHirePlanSearchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if ( !JSPUtil.getNull(offHirePlanSearchVO.getCntrTpszCd()).equals("") ) {
					List<String> arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(offHirePlanSearchVO.getCntrTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}

				if ( !JSPUtil.getNull(offHirePlanSearchVO.getOffhRgnLocCd()).equals("") ) {
					List<String> arrOffhRgnLocCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(offHirePlanSearchVO.getOffhRgnLocCd(),",","|"));
					param.put("offh_rgn_loc_cd_seq", arrOffhRgnLocCd);
					velParam.put("offh_rgn_loc_cd_seq", arrOffhRgnLocCd);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAOOffHirePlanRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OffHirePlanVO.class);
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
	 * Off-Hire Plan Input &amp; Update by H/Q 의 Max Version Sequence 를 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchOffHirePlanMaxVersionData(OffHirePlanSearchVO offHirePlanSearchVO) throws DAOException {
		int offhVerMaxSeq =0;
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	    	if(offHirePlanSearchVO != null){
	    		//Map<String, String> mapVO = searchOffHirePlanVO.getColumnValues();

				//param.putAll(mapVO);
				//velParam.putAll(mapVO);
	    		param.put("pln_yr", offHirePlanSearchVO.getPlnYr());
	    		param.put("offh_pln_tp_cd", offHirePlanSearchVO.getOffhPlnTpCd());
	    		param.put("offh_loc_tp_cd", offHirePlanSearchVO.getOffhLocTpCd());
			}
			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAOOffHirePlanMaxVersionRSQL(), param, param);
	    	if(dbRowset.next()) {
	    		offhVerMaxSeq = dbRowset.getInt("OFFH_VER_MAX_SEQ");
	    	}
	    } catch (SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return offhVerMaxSeq;
	}

	/**
	 * Off Hire Plan Input &amp; Update by H/Q 단건의 데이터를 생성합니다.<br>
	 *
	 * @param  LseOffhPlnVO lseOffhPlnVO
	 * @throws DAOException
	 */
	public void addOffHirePlanData(LseOffhPlnVO lseOffhPlnVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = lseOffhPlnVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new LeasePlanDBDAOOffHirePlanCSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to indert SQL");
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
	 * Off Hire Plan Input &amp; Update by H/Q 단건의 데이터를 삭제합니다.<br>
	 *
	 * @param  LseOffhPlnVO lseOffhPlnVO
	 * @throws DAOException
	 */
	public void removeOffHirePlanData(LseOffhPlnVO lseOffhPlnVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = lseOffhPlnVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new LeasePlanDBDAOOffHirePlanDSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
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
	 * Off Hire Plan Input &amp; Update by H/Q Version Up 데이터를 일괄적으로 생성합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @throws DAOException
	 */
	public void addOffHirePlanNewVerData(OffHirePlanSearchVO offHirePlanSearchVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = offHirePlanSearchVO.getColumnValues();

			param.putAll(mapVO);
			param.put("cre_usr_id", offHirePlanSearchVO.getUsrId());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new LeasePlanDBDAOOffHirePlanVersionUpCSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to indert SQL");
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
	 * Off-Hire Plan Input &amp; Update by RCC 를 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @return List<OffHirePlanRccVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OffHirePlanRccVO> searchOffHirePlanByRCCData(OffHirePlanSearchVO offHirePlanSearchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OffHirePlanRccVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(offHirePlanSearchVO != null){

				Map<String, String> mapVO = offHirePlanSearchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("pln_yr", offHirePlanSearchVO.getOffhYrmon().substring(0,4));
				velParam.put("pln_yr", offHirePlanSearchVO.getOffhYrmon().substring(0,4));

				if ( !JSPUtil.getNull(offHirePlanSearchVO.getCntrTpszCd()).equals("") ) {
					List<String> arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(offHirePlanSearchVO.getCntrTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAOOffHirePlanByRCCRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OffHirePlanRccVO.class);
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
	 * Off Hire Plan Input &amp; Update by RCC 단건의 데이터를 생성합니다.<br>
	 *
	 * @param  LseOffhPlnVO lseOffhPlnVO
	 * @throws DAOException
	 */
	public void addOffHirePlanByRCCData(LseOffhPlnVO lseOffhPlnVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = lseOffhPlnVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new LeasePlanDBDAOOffHirePlanByRCCCSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to indert SQL");
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
	 * Off Hire Plan Input &amp; Update by RCC 단건의 데이터를 삭제합니다.<br>
	 *
	 * @param  LseOffhPlnVO lseOffhPlnVO
	 * @throws DAOException
	 */
	public void removeOffHirePlanByRCCData(LseOffhPlnVO lseOffhPlnVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = lseOffhPlnVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new LeasePlanDBDAOOffHirePlanByRCCDSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
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
	 * Off-Hire Plan Performance 를 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @return List<OffHirePerformanceVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OffHirePerformanceVO> searchOffHirePerformanceData(OffHirePlanSearchVO offHirePlanSearchVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<OffHirePerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(offHirePlanSearchVO != null){

				Map<String, String> mapVO = offHirePlanSearchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if ( !JSPUtil.getNull(offHirePlanSearchVO.getOffhYrmon()).equals("") ) {
					List<String> arrOffhYrmon = JSPUtil.convertStringToArrayList(offHirePlanSearchVO.getOffhYrmon());
					param.put("offh_yrmon_seq", arrOffhYrmon);
					velParam.put("offh_yrmon_seq", arrOffhYrmon);
				}

				if ( !JSPUtil.getNull(offHirePlanSearchVO.getCntrTpszCd()).equals("") ) {
					List<String> arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(offHirePlanSearchVO.getCntrTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAOOffHirePlanPerformanceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OffHirePerformanceVO.class);
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
	 * Off-Hire Plan by RCC DOL 를 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @return List<OffHirePlanRccVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OffHirePlanRccVO> searchOffHirePlanByRCCDOLData(OffHirePlanSearchVO offHirePlanSearchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OffHirePlanRccVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if ( offHirePlanSearchVO != null ) {
				param.put("lstm_cd", offHirePlanSearchVO.getLstmCd());
				param.put("loc_tp",  offHirePlanSearchVO.getLocTp());
				param.put("loc_cd",  offHirePlanSearchVO.getLocCd());

				if ( !JSPUtil.getNull(offHirePlanSearchVO.getCntrTpszCd()).equals("") ) {
					List<String> arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(offHirePlanSearchVO.getCntrTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new LeasePlanDBDAOOffHirePlanByRCCDOLRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OffHirePlanRccVO.class);
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