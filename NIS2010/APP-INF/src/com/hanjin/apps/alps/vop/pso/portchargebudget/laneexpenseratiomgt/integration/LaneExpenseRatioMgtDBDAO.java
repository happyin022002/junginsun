/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LaneExpenseRatioMgtDAO.java
 *@FileTitle : Lane/Port Expense Ratio Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.27
 *@LastModifier : 박명종
 *@LastVersion : 1.0
 * 2009.05.27 박명종
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.basic.LaneExpenseRatioMgtBCImpl;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.vo.ServiceLaneListVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.vo.SvcLaneVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS LaneExpenseRatioMgtDAO <br>
 * - ALPS-PortChargeBudget system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author myoungjong park
 * @see LaneExpenseRatioMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class LaneExpenseRatioMgtDBDAO extends DBDAOSupport {

	/**
	 * PSO_PORT_EXPN_DIV 테이블 기준으로 등록된 Service Lane List를 표시한다.<br>
	 * 
	 * @return List<SvcLaneVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SvcLaneVO> searchLaneExpenseRatioKeyValue() throws DAOException {
		DBRowSet dbRowset = null;
		List<SvcLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneExpenseRatioMgtDAOsearchLaneExpenseRatioKeyValueRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SvcLaneVO .class);
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
	 * 입력받은 Service Lane Code에 Standard P/F Type Code와 펜드럼 서비스 구분자를 조회한다.<br>
	 * 
	 * @param String vslSlanCd
	 * @return List<SvcLaneVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SvcLaneVO> searchPfLaneTypeList(String vslSlanCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SvcLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslSlanCd != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("vsl_slan_cd", vslSlanCd);
				Map<String, String> mapVO = hMap;

				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneExpenseRatioMgtDAOsearchPfLaneTypeListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SvcLaneVO.class);
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
	 * PSO PORT EXPENSE DIVISION 테이블 Select<br>
	 * 
	 * @param String vslSlanCd
	 * @return List<ServiceLaneListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ServiceLaneListVO> searchPsoPortExpenseDivision(String vslSlanCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ServiceLaneListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslSlanCd != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("vsl_slan_cd", vslSlanCd);
				Map<String, String> mapVO = hMap;

				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneExpenseRatioMgtDAOsearchPsoPortExpenseDivisionRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ServiceLaneListVO.class);
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
	 * 입력 받은 Lane Code로 생성된 Standard P/F SKD Detail 정보를 조회한다.<br>
	 * 
	 * @param String vslSlanCd
	 * @return List<ServiceLaneListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ServiceLaneListVO> searchPfSkdDetail(String vslSlanCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ServiceLaneListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslSlanCd != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("vsl_slan_cd", vslSlanCd);
				Map<String, String> mapVO = hMap;

				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneExpenseRatioMgtDAOsearchPfSkdDetailRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ServiceLaneListVO.class);
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
	 * pso_port_expn_div 데이터를 저장한다.<br>
	 * @param List<ServiceLaneListVO> serviceLaneListVO
	 * @throws DAOException
	 */
	public void addPsoPortExpenseDivision(List<ServiceLaneListVO> serviceLaneListVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(serviceLaneListVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneExpenseRatioMgtDAOaddPsoPortExpenseDivisionCSQL(), serviceLaneListVO,null);
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
	 * pso_port_expn_div 데이터를 수정한다.<br>
	 * 
	 * @param List<ServiceLaneListVO> serviceLaneListVO
	 * @throws DAOException
	 */
	public void modifyPsoPrortExpenseDivision(List<ServiceLaneListVO> serviceLaneListVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(serviceLaneListVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneExpenseRatioMgtDAOmodifyPsoPrortExpenseDivisionUSQL(), serviceLaneListVO,null);
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
	 * pso_port_expn_div 데이터를 삭제한다.<br>
	 * @param List<ServiceLaneListVO> serviceLaneListVO
	 * @throws DAOException
	 */
	public void removePsoPortExpenseDivision(List<ServiceLaneListVO> serviceLaneListVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(serviceLaneListVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneExpenseRatioMgtDAOremovePsoPortExpenseDivisionDSQL(), serviceLaneListVO,null);
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
	 * mdm_vsl_svc_lane 데이터를 수정한다.<br>
	 * @param List<SvcLaneVO> svcLaneVO
	 * @throws DAOException
	 */
	public void modifyMdmVslSvcLane(List<SvcLaneVO> svcLaneVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(svcLaneVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneExpenseRatioMgtDAOmodifyMdmVslSvcLaneUSQL(), svcLaneVO,null);
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
	 * PSO_PORT_EXPN_DIV 데이터를 삭제한다.<br>
	 * @param List<SvcLaneVO> svcLaneVO
	 * @throws DAOException
	 */
	public void removeMdmVslSvcLane(List<SvcLaneVO> svcLaneVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(svcLaneVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneExpenseRatioMgtDAOremoveMdmVslSvcLaneDSQL(), svcLaneVO,null);
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



