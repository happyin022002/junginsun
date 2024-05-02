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
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairOceanRouteInformationVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteDetailVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteMstVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS PortPairRouteDBDAO <br>
 * - ALPS-ExceptionManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Shin Han Sung
 * @see ExceptionSearchBCImpl 참조
 * @since J2EE 1.6
 */
public class PortPairRouteDBDAO extends DBDAOSupport {

	
	/**
	 * 파트너 이름을 조회한다.<br>
	 * 
	 * @param String partnerId
	 * @return String
	 * @throws DAOException
	 */
	public String searchPartnerName(String partnerId) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
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
	public DBRowSet searchPortPairMaster(PortPairRouteMstVO model)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (model != null) {
				Map<String, String> mapVO = model.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			log.debug(param);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairRouteDBDAOSearchPortPairMasterRSQL(),
					param, velParam);

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
	public DBRowSet searchPortPairMaster(PortPairRouteDetailVO model)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (model != null) {
				Map<String, String> mapVO = model.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			log.debug(param);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairRouteDBDAOSearchPortPairMasterRSQL(),
					param, velParam);

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
	public List<PortPairRouteMstVO> searchPortPairMasters(PortPairRouteConditionVO portPairRouteConditionVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<PortPairRouteMstVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
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
	public List<PortPairRouteDetailVO> searchPortPairDetails(PortPairRouteConditionVO condition)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<PortPairRouteDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
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
	public List<PortPairRouteDetailVO> searchPortPairDetails(PortPairRouteMstVO mstVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<PortPairRouteDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
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
	
//	/**
//	 * EAI 로 전달할 정보 조회
//	 * 
//	 * @param PortPairRouteDetailVO models
//	 * @return List<PortPairRouteDetailVO>
//	 * @throws DAOException
//	 */
//	public List<PortPairRouteDetailVO> searchPortPairDetailForEAI(PortPairRouteDetailVO model)
//			throws DAOException {
//		DBRowSet dbRowset = null;
//		List<PortPairRouteDetailVO> list = null;
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try {
//			if (model != null) {
//				Map<String, String> mapVO = model.getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//				
//				// rout_rcv_dt MULTI 처리
//				if (velParam.get("rout_rcv_dt") != null
//						& !((String) velParam.get("rout_rcv_dt")).trim().equals("")) {
//					velParam.put("rout_rcv_dt", ((String) velParam.get("rout_rcv_dt")).split(","));
//				}
//				
//				// rout_seq MULTI 처리
//				if (velParam.get("rout_seq") != null
//						& !((String) velParam.get("rout_seq")).trim().equals("")) {
//					velParam.put("rout_seq", ((String) velParam.get("rout_seq")).split(","));
//				}
//			}
//
//			dbRowset = new SQLExecuter("").executeQuery(
//					(ISQLTemplate) new PortPairRouteDBDAOSearchPortPairDetailForEAIRSQL(),//<--아직 삭제 안함.
//					param, velParam);
//
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
//					PortPairRouteDetailVO.class);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}
	
	/**
	 * Add 버튼을 이용해 추가 하려는 Route와 동일한 Route가 존재 하는지 Port pair master table 조회한다.
	 * 
	 * @param PortPairRouteDetailVO model
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean hasSameRoute(PortPairRouteDetailVO model)
			throws DAOException {
		boolean hasSame = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (model != null) {
				Map<String, String> mapVO = model.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			log.debug(param);
			log.debug("n1st_pod_cd : "+model.getN1stPodCd());
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairRouteDBDAOHasSameRouteRSQL(),
					param, velParam);

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
					(ISQLTemplate) new PortPairRouteDBDAOSearchNextRouteSeqRSQL(),
					null, null);

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

			Map param= condition.getColumnValues();
			
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
//			int[] delCnt = null;

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
//			if(delModels.size()>0){
////				delCnt = sqlExe.executeBatch(new RoleDAOComUsrRoleDSQL(), delModels,null);
////				for(int i=0;i<delCnt.length;i++){
////					if(delCnt[i]== Statement.EXECUTE_FAILED)
////						throw new DAOException("Fail to delete No"+ i + " SQL");
////				}
//			}
			
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
//			int[] delCnt = null;

			Map velParam= condition.getColumnValues();
			
//			log.debug(velParam);
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
//			if(delModels.size()>0){
////				delCnt = sqlExe.executeBatch(new RoleDAOComUsrRoleDSQL(), delModels,null);
////				for(int i=0;i<delCnt.length;i++){
////					if(delCnt[i]== Statement.EXECUTE_FAILED)
////						throw new DAOException("Fail to delete No"+ i + " SQL");
////				}
//			}
			
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
//			int[] updCnt = null;
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

//			if(updModels.size()>0){
//				updCnt = sqlExe.executeBatch(new PortPairRouteDBDAOModifyPortPairDetailUSQL(), updModels, velParam);
//				for(int i=0;i<updCnt.length;i++){
//					if(updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to update No"+ i + " SQL");
//				}
//			}
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
//	/**
//	 * PortPair I/F 전송.<br>
//	 * 
//	 * @param models 여러 데이타 모델
//	 * @see ComSys007Event
//	 * @throws DAOException
//	 */
//	public void addPortPairRouteIF(PortPairRouteConditionVO condition, Collection<PortPairRouteDetailVO> models) 
//	throws DAOException {
//		
//		log.debug("PortPairRouteDBDAO - addPortPairRouteIF");
//		
//		try {
//			int[] insCnt = null;
//
//			Map velParam= condition.getColumnValues();
//			
////			log.debug(velParam);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			
//			if(models.size()>0){
//				insCnt = sqlExe.executeBatch(new PortPairRouteDBDAOAddPortPairRouteIFCSQL(), //<--삭제 안했음.
//						models, velParam);
//				for(int i=0;i<insCnt.length;i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}

	/**
	 * @param PortPairRouteDetailVO portPairRouteDetailVO
	 * @return List<PortPairOceanRouteInformationVO>
	 * @throws DAOException
	 */
	public List<PortPairOceanRouteInformationVO> searchPortPairOceanRouteInformation(PortPairRouteDetailVO portPairRouteDetailVO) 	throws DAOException {
				DBRowSet dbRowset = null;
				List<PortPairOceanRouteInformationVO> list = null;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try {
					if (portPairRouteDetailVO != null) {
						Map<String, String> mapVO = portPairRouteDetailVO.getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}

					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new PortPairRouteDBDAOSearchPortPairOceanRouteInformationRSQL(),
							param, velParam);

					list = (List) RowSetUtil.rowSetToVOs(dbRowset,
							PortPairOceanRouteInformationVO.class);

				} catch (SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch (Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
	}

//	public List<SceComboVO> searchPartnerCombo() throws DAOException {
//		DBRowSet dbRowset = null;
//		List<SceComboVO> list = null;
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			PortPairRouteDBDAOSearchPartnerComboRSQL template = new PortPairRouteDBDAOSearchPartnerComboRSQL();
//			dbRowset = sqlExe.executeQuery(template, param, velParam);
//
//			list = new ArrayList<SceComboVO>();
//			while (dbRowset.next()) {
//				SceComboVO vo = new SceComboVO();
//				vo.setComboCd(dbRowset.getString("CUST_TRD_PRNR_ID"));
//				vo.setVal(dbRowset.getString("CUST_TRD_PRNR_ID"));
//				vo.setName(dbRowset.getString("CUST_TRD_PRNR_NM"));
//				vo.setDesc(dbRowset.getString("CUST_TRD_PRNR_NM"));
//				list.add(vo);
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//		return list;
//	}
}