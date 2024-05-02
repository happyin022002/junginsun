/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LaneServiceDBDAO.java
 *@FileTitle : LaneServiceDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.07.15
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2010.07.15 함대성
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.vo.SearchLaneServiceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * LaneServiceDBDAO<br>
 * - CustomerScheduleEdi에 대한 Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HAM DAE SUNG
 * @see
 * @since J2EE 1.4
 */
public class LaneServiceDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/** 
	 * 화주 ID에 해당하는 이름을 조회한다.
	 * 
	 * @param String partnerId
	 * @return List<SearchGetPartnerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchGetPartnerVO> searchCustomerInfo(String partnerId) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchGetPartnerVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("cust_trd_prnr_id", partnerId);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new LaneServiceDBDAOSearchGetPartnerRSQL(),	param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchGetPartnerVO.class);
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
	 * Lane Type 화주에게 제공할 Lane을 조회한다.
	 * 
	 * @param String partnerId
	 * @return List<SearchLaneServiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchLaneServiceVO> searchLaneServiceList(String partnerId) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLaneServiceVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("partnerId", partnerId);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneServiceDBDAOSearchLaneServiceRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLaneServiceVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * 화주별 Lane 정보를 등록한다.<br>
	 * 
	 * @param SearchLaneServiceVO laneServiceVO
	 * @return int
	 * @exception DAOException
	 */
	public int addLaneService(SearchLaneServiceVO laneServiceVO) throws DAOException {
		int insCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (laneServiceVO != null) {
				Map<String, String> mapVO = laneServiceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			//if(LaneServiceDetailVO .size() > 0){
				insCnt = sqlExe.executeUpdate((ISQLTemplate)new LaneServiceDBDAOAddPortPairCCSQL(), param, velParam);
				//for(int i = 0; i < insCnt.length; i++){
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No SQL");
				//}
			//}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * 화주에게 등록된 Lane 정보를 수정한다.<br>
	 * 
	 * @param List<SearchLaneServiceVO> laneServiceVOs
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] modifyLaneService(List<SearchLaneServiceVO> laneServiceVOs) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(laneServiceVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new LaneServiceDBDAOModifyPortPairUUSQL(), laneServiceVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * 화주에게 등록된 Lane 정보를 삭제한다.<br>
	 * 
	 * @param List<SearchLaneServiceVO> laneServiceVOs
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] removeLaneService(List<SearchLaneServiceVO> laneServiceVOs) throws DAOException {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(laneServiceVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new LaneServiceDBDAORemovePortPairDDSQL(), laneServiceVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
}
