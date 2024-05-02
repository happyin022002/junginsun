/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PortPairRouteDBDAO.java
 *@FileTitle : Exception Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.02
 *@LastModifier : 신한성
 *@LastVersion : 1.0
 * 2009.07.02 신한성
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteDetailVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteMstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * PortPairRouteDBDAO <br>
 * - ExceptionManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Shin Han Sung
 * @see ExceptionSearchBCImpl 참조
 * @since J2EE 1.6
 */
public class PortPairRouteDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 파트너 이름을 조회한다.<br>
	 * 
	 * @param String partnerId
	 * @return String
	 * @throws DAOException
	 */
	public String searchPartnerName(String partnerId) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("partner_id", partnerId);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairRouteDBDAOSearchPartnerNameRSQL(),
					param, null);
			if(dbRowset.getRowCount()>0) {
				dbRowset.next();
				return dbRowset.getString("cust_trd_prnr_nm");
			}else return "";

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Port pair master table 조회한다.
	 * 
	 * @param PortPairRouteMstVO model
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchPortPairMaster(PortPairRouteMstVO model) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (model != null) {
				Map<String, String> mapVO = model.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			log.debug(param);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairRouteDBDAOSearchPortPairMasterRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Port pair master table 조회한다.
	 * 
	 * @param PortPairRouteDetailVO model
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchPortPairMaster(PortPairRouteDetailVO model) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (model != null) {
				Map<String, String> mapVO = model.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			log.debug(param);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairRouteDBDAOSearchPortPairMasterRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Port pair master table 조회한다.
	 * 
	 * @param PortPairRouteConditionVO portPairRouteConditionVO
	 * @return List<PortPairRouteMstVO> 
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<PortPairRouteMstVO> searchPortPairMasters(PortPairRouteConditionVO portPairRouteConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortPairRouteMstVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (portPairRouteConditionVO != null) {
				Map<String, String> mapVO = portPairRouteConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairRouteDBDAOSearchPortPairMastersRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					PortPairRouteMstVO.class);

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
	 * OceanRouteManage의 데이타 모델에 해당되는 값을 불러온다.
	 * 
	 * @param PortPairRouteConditionVO condition
	 * @return List<PortPairRouteDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<PortPairRouteDetailVO> searchPortPairDetails(PortPairRouteConditionVO condition) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortPairRouteDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condition != null) {
				Map<String, String> mapVO = condition.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairRouteDBDAOSearchPortPairDetailsRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					PortPairRouteDetailVO.class);

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
	 * SCE_PORT_PAIR_DTL 테이블을 조회 한다. 
	 * 
	 * @param PortPairRouteMstVO mstVO
	 * @return List<PortPairRouteDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<PortPairRouteDetailVO> searchPortPairDetails(PortPairRouteMstVO mstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortPairRouteDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mstVO != null) {
				Map<String, String> mapVO = mstVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairRouteDBDAOSearchPortPairDetailRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					PortPairRouteDetailVO.class);

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
	 * Add 버튼을 이용해 추가 하려는 Route와 동일한 Route가 존재 하는지 Port pair master table 조회한다.
	 * 
	 * @param PortPairRouteDetailVO model
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean hasSameRoute(PortPairRouteDetailVO model) throws DAOException {
		boolean hasSame = false;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (model != null) {
				Map<String, String> mapVO = model.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				log.debug(param);
				log.debug("n1st_pod_cd : "+model.getN1stPodCd());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PortPairRouteDBDAOHasSameRouteRSQL(), param, velParam);
			dbRowset.next();
			if(dbRowset.getInt("cnt") > 0) hasSame = true;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return hasSame;
	}
	
	/**
	 * Port Pair Route Sequence 반환한다.
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String getNextRouteSeq() throws DAOException {
		DBRowSet dbRowset = null;
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairRouteDBDAOSearchNextRouteSeqRSQL(), null, null);
			dbRowset.next();
			
			return String.valueOf(dbRowset.getInt(1));
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 현재 일자를 반환한다.
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String getCurrentDate() throws DAOException {
		DBRowSet dbRowset = null;
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairRouteDBDAOGetCurrentDateRSQL(),
					null, null);
			dbRowset.next();
			
			return dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 파트너 등록한다.  <br>
	 * 
	 * @param PortPairRouteConditionVO condition
	 * @throws DAOException
	 */
	public void insertPartnerCode(PortPairRouteConditionVO condition) throws DAOException {
		log.debug("PortPairRouteDBDAO - insertPartnerCode");
		
		try {
			int insCnt = -1;
			Map<String, String> param= condition.getColumnValues();
			
			SQLExecuter sqlExe = new SQLExecuter("");
			insCnt = sqlExe.executeUpdate(new PortPairRouteDBDAOInsertPartnerCodeCSQL(), param, null);
				if(insCnt== Statement.EXECUTE_FAILED)
					throw new DAOException("Failed execute to PortPairRouteDBDAO - insertPartnerCode .");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PortPairMaster 정보 관리.<br>
	 * 
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteMstVO[] models
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void modifyPortPairMaster(PortPairRouteConditionVO condition, PortPairRouteMstVO[] models) throws DAOException {
		log.debug("PortPairRouteDBDAO - modifyPortPairMaster");
		
		Collection<PortPairRouteMstVO> insModels =new ArrayList<PortPairRouteMstVO>();
		Collection<PortPairRouteMstVO> updModels =new ArrayList<PortPairRouteMstVO>();
		Collection<PortPairRouteMstVO> delModels =new ArrayList<PortPairRouteMstVO>();

		try {
			PortPairRouteMstVO model = null;
			int cnt = models.length;
			for(int i=0;i<cnt;i++){
				model = (PortPairRouteMstVO)models[i];
				if (model.getIbflag().length() > 0) {
					if (model.getIbflag().equals("U")) {
						updModels.add(model);
					} else if (model.getIbflag().equals("D")) {
						delModels.add(model);
					} else if (model.getIbflag().equals("I")) {
						insModels.add(model);
					}
				}
			}
			int[] insCnt = null;
			int[] updCnt = null;

			Map velParam= condition.getColumnValues();
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(insModels.size()>0){
				insCnt = sqlExe.executeBatch(new PortPairRouteDBDAOAddPortPairMasterCSQL(), insModels, velParam);
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}

			if(updModels.size()>0){
				updCnt = sqlExe.executeBatch(new PortPairRouteDBDAOModifyPortPairMasterUSQL(), updModels, velParam);
				for(int i=0;i<updCnt.length;i++){
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
	 * PortPairMaster 정보 관리.<br>
	 * 
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteMstVO[] models
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void modifyPortPairDetail(PortPairRouteConditionVO condition, PortPairRouteMstVO[] models) throws DAOException {
		log.debug("PortPairRouteDBDAO - modifyPortPairDetail");
		
		Collection<PortPairRouteMstVO> insModels =new ArrayList<PortPairRouteMstVO>();
		Collection<PortPairRouteMstVO> updModels =new ArrayList<PortPairRouteMstVO>();
		Collection<PortPairRouteMstVO> delModels =new ArrayList<PortPairRouteMstVO>();

		try {
			PortPairRouteMstVO model = null;
			int cnt = models.length;
			for(int i=0;i<cnt;i++){
				model = (PortPairRouteMstVO)models[i];
				if (model.getIbflag().length() > 0) {
					if (model.getIbflag().equals("U")) {
						updModels.add(model);
					} else if (model.getIbflag().equals("D")) {
						delModels.add(model);
					} else if (model.getIbflag().equals("I")) {
						insModels.add(model);
					}
				}
			}
			int[] insCnt = null;
			int[] updCnt = null;

			Map velParam= condition.getColumnValues();
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(insModels.size()>0){
				insCnt = sqlExe.executeBatch(new PortPairRouteDBDAOAddPortPairDetailCSQL(), insModels, velParam);
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}

			if(updModels.size()>0){
				updCnt = sqlExe.executeBatch(new PortPairRouteDBDAOModifyPortPairDetailByMasterUSQL(), updModels, velParam);
				for(int i=0;i<updCnt.length;i++){
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
	 * PortPairDetail 정보 관리.<br>
	 * 
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteDetailVO[] models
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void modifyPortPairDetail(PortPairRouteConditionVO condition, PortPairRouteDetailVO[] models) throws DAOException {
		log.debug("PortPairRouteDBDAO - modifyPortPairDetail");
		
		Collection<PortPairRouteDetailVO> insModels =new ArrayList<PortPairRouteDetailVO>();
		Collection<PortPairRouteDetailVO> updModels =new ArrayList<PortPairRouteDetailVO>();
		Collection<PortPairRouteDetailVO> delModels =new ArrayList<PortPairRouteDetailVO>();

		try {
			PortPairRouteDetailVO model = null;
			int cnt = models.length;
			for(int i=0;i<cnt;i++){
				model = (PortPairRouteDetailVO)models[i];
				if (model.getIbflag().length() > 0) {
					if (model.getIbflag().equals("U")) {
						updModels.add(model);
					} else if (model.getIbflag().equals("D")) {
						delModels.add(model);
					} else if (model.getIbflag().equals("I")) {
						insModels.add(model);
					}
				}
			}
			int[] insCnt = null;
			int[] delCnt = null;

			Map velParam= condition.getColumnValues();
			
			log.debug(velParam);
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(insModels.size()>0){
				insCnt = sqlExe.executeBatch(new PortPairRouteDBDAOAddPortPairDetailCSQL(), insModels, velParam);
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}

			if(delModels.size()>0){
				delCnt = sqlExe.executeBatch(new PortPairRouteDBDAOModifyPortPairDetailUSQL(), delModels, velParam);
				for(int i=0;i<delCnt.length;i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * EDI Port Pair Route Modify처리한다.  <br>
	 * 
	 * @throws DAOException
	 */
	public void modifyPortPairRoute() throws DAOException {
		log.debug("PortPairRouteDBDAO - modifyPortPairRoute");
		
		try {
			int updCnt = -1;

			SQLExecuter sqlExe = new SQLExecuter("");
			
			updCnt = sqlExe.executeUpdate(new PortPairRouteDBDAOModifyPortPairRouteUSQL(), null, null);
				if(updCnt== Statement.EXECUTE_FAILED)
					throw new DAOException("Failed execute to PortPairRouteDBDAO - modifyPortPairRoute .");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EDI Port Pair Route Modify처리한다.  <br>
	 * 
	 * @throws DAOException
	 */
	public void updatePortPairRouteDtlIndUpd() throws DAOException {
		log.debug("PortPairRouteDBDAO - updatePortPairRoute");
		
		try {
			int updCnt = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			updCnt = sqlExe.executeUpdate(new PortPairRouteDBDAOUpdatePortPairRouteUSQL(), null, null);
				if(updCnt== Statement.EXECUTE_FAILED)
					throw new DAOException("Failed execute to PortPairRouteDBDAO - updatePortPairRoute .");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * EDI Port Pair Route Modify처리한다.  <br>
	 * 
	 * @throws DAOException
	 */
	public void updatePortPairRouteDtlNotExist() throws DAOException {
		log.debug("PortPairRouteDBDAO - deletePortPairRoute");
		
		try {
			int updCnt = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			updCnt = sqlExe.executeUpdate(new PortPairRouteDBDAODeletePortPairRouteUSQL(), null, null);
				if(updCnt== Statement.EXECUTE_FAILED)
					throw new DAOException("Failed execute to PortPairRouteDBDAO - updatePortPairRoute .");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

}