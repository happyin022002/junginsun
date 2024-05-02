/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PortPairExceptionDBDAO.java
 *@FileTitle : PortPairExceptionDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.07.15
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2010.07.15 함대성
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.AdjustmentVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.BlockLaneVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.CustomerVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.ExceptionalRouteVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.RouteForBLVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * PortPairExceptionDBDAO<br>
 * - CustomerScheduleEdi에 대한 Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HAM DAE SUNG
 * @see
 * @since J2EE 1.4
 */
public class PortPairExceptionDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
     * 
     * TP ID을 조회 합니다.<br>
     * @param   SearchGetPartnerVO searchGetPartnerVO
     * @throws  DAOException
     * @return  List<SearchGetPartnerVO>
     */ 
	@SuppressWarnings({ "rawtypes", "unchecked" })
   public List<SearchGetPartnerVO> searchTpId(SearchGetPartnerVO searchGetPartnerVO) throws DAOException {
           DBRowSet dbRowset = null;
           List<SearchGetPartnerVO> list = null;
           Map<String, Object> param = new HashMap<String, Object>();
           Map<String, Object> velParam = new HashMap<String, Object>();
           try{ 
               Map<String, String> mapVO = searchGetPartnerVO.getColumnValues();
               param.putAll(mapVO);
               velParam.putAll(mapVO);
               
               dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortPairExceptionDBDAOSearchTpIdRSQL(), param, velParam);
               list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchGetPartnerVO .class);
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
	 * ESD_SCE_0123 : 입력<br>
	 * @param AdjustmentVO adjustmentVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int addAdjustment(AdjustmentVO adjustmentVO) throws DAOException,Exception {
		int insCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (adjustmentVO != null) {
				Map<String, String> mapVO = adjustmentVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			//if(AdjustmentVO .size() > 0){
				insCnt = sqlExe.executeUpdate((ISQLTemplate)new PortPairExceptionDBDAOAddLaneDetailCSQL(), param, velParam);
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
	 * ESD_SCE_0123 : 수정<br>
	 * @param List<AdjustmentVO> AdjustmentVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyAdjustment(List<AdjustmentVO> AdjustmentVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(AdjustmentVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortPairExceptionDBDAOModifyLaneDetailUSQL(), AdjustmentVO,null);
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
	 * ESD_SCE_0123 : 삭제<br>
	 * @param List<AdjustmentVO> AdjustmentVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeAdjustment(List<AdjustmentVO> AdjustmentVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(AdjustmentVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortPairExceptionDBDAORemoveLaneDetailDSQL(), AdjustmentVO,null);
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
	
	/**
	 * ESD_SCE_0125 : 조회를 위한 토크나이져 스트링가져오기 
	 * @param ExceptionalRouteVO exceptionalRouteVO
	 * @return List<ExceptionalRouteVO>
	 * @throws DAOException
	 */
	private String setParams(StringBuffer sbuf, StringTokenizer token, int max) throws SQLException { 
	    for ( int i = 0; i < max; i++ ) { 
    	  if(i==0) {
    		 sbuf.append ( "" ).append ( token.nextToken ( ) ).append ( "" );
    		 if(max > 1) {
    			 sbuf.append("',");
    		 }
    	  } else {
		      if ( i != max - 1 ) {
		    	 sbuf.append ( "'" ).append ( token.nextToken ( ) ).append ( "'," );
		      } else {
		         sbuf.append ( "'" ).append ( token.nextToken ( ) ).append ( "" );
		      }
    	  }
	    }
		return sbuf.toString();
	}
	
	/**
	 * ESD_SCE_0125 : 조회
	 * @param ExceptionalRouteVO exceptionalRouteVO
	 * @return List<ExceptionalRouteVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ExceptionalRouteVO> searchExceptionalRouteList(ExceptionalRouteVO exceptionalRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExceptionalRouteVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (exceptionalRouteVO != null) {
				Map<String, String> mapVO = exceptionalRouteVO.getColumnValues();
				
			    StringBuffer sbuf = new StringBuffer ( );
			    sbuf.setLength ( 0 ); 

			    StringTokenizer por_port_cd_token = new StringTokenizer ( (String)mapVO.get("por_port_cd"), "," );
				StringTokenizer pol_port_cd_token = new StringTokenizer ( (String)mapVO.get("pol_port_cd"), "," );
				StringTokenizer pod_port_cd_token = new StringTokenizer ( (String)mapVO.get("pod_port_cd"), "," );
				StringTokenizer del_port_cd_token = new StringTokenizer ( (String)mapVO.get("del_port_cd"), "," );
				sbuf = new StringBuffer ();
			    String sbuf1 = setParams(sbuf, por_port_cd_token, por_port_cd_token.countTokens ( ));
			    sbuf = new StringBuffer ();
			    String sbuf2 = setParams(sbuf, pol_port_cd_token, pol_port_cd_token.countTokens ( ));
			    sbuf = new StringBuffer ();
			    String sbuf3 = setParams(sbuf, pod_port_cd_token, pod_port_cd_token.countTokens ( ));
			    sbuf = new StringBuffer ();
			    String sbuf4 = setParams(sbuf, del_port_cd_token, del_port_cd_token.countTokens ( ));
			    
				param.putAll(mapVO);
				List<String> vec = new ArrayList<String>();
				if(!sbuf1.equals("")){
					vec.add(sbuf1);
					velParam.put("por_port_cd", 	vec);
				}
				if(!sbuf2.equals("")){
					vec = new ArrayList<String>();
					vec.add(sbuf2);
					velParam.put("pol_port_cd", 	vec);
				} 
				if(!sbuf3.equals("")){
					vec = new ArrayList<String>();
					vec.add(sbuf3);
					velParam.put("pod_port_cd", 	vec);
				}
				if(!sbuf4.equals("")){
					vec = new ArrayList<String>();
					vec.add(sbuf4);
					velParam.put("del_port_cd", 	vec);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairExceptionDBDAOExceptionalRouteRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExceptionalRouteVO.class);

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
	 * ESD_SCE_0125 : 입력<br>
	 * @param ExceptionalRouteVO exceptionalRouteVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int addExceptionRoute(ExceptionalRouteVO exceptionalRouteVO) throws DAOException,Exception {
		int insCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (exceptionalRouteVO != null) {
				Map<String, String> mapVO = exceptionalRouteVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			//if(AdjustmentVO .size() > 0){
				insCnt = sqlExe.executeUpdate((ISQLTemplate)new PortPairExceptionDBDAOExceptionRouteCSQL(), param, velParam);
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
	 * Port pair master table 조회한다.
	 * 
	 * @param ExceptionalRouteVO exceptionalRouteVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean exceptSameRoute(ExceptionalRouteVO exceptionalRouteVO)
			throws DAOException {
		boolean exceptSame = false;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (exceptionalRouteVO != null) {
				Map<String, String> mapVO = exceptionalRouteVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PortPairExceptionDBDAOExceptSameRouteRSQLRSQL(),
					param, velParam);

			dbRowset.next();
			
			if(dbRowset.getInt("cnt") > 0) exceptSame = true;
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return exceptSame;
	}
	
	/**
	 * ESD_SCE_0123 : 수정<br>
	 * @param List<ExceptionalRouteVO> exceptionalRouteVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyExceptionRoute(List<ExceptionalRouteVO> exceptionalRouteVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(exceptionalRouteVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortPairExceptionDBDAOExceptionRouteUSQL(), exceptionalRouteVO,null);
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
	 * ESD_SCE_0125 : 삭제<br>
	 * @param List<ExceptionalRouteVO> exceptionalRouteVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeExceptionRoute(List<ExceptionalRouteVO> exceptionalRouteVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(exceptionalRouteVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortPairExceptionDBDAOExceptionRouteDSQL(), exceptionalRouteVO,null);
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
	
	/**
	 * Port Pair Detail 조회<br>
	 * 
	 * @param AdjustmentVO adjustmentVO
	 * @return List<AdjustmentVO> 
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<AdjustmentVO> searchRouteListForAdjustment(AdjustmentVO adjustmentVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustmentVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("cust_trd_prnr_id", adjustmentVO.getCustTrdPrnrId());
			param.put("pol", adjustmentVO.getPolCd());
			param.put("pod", adjustmentVO.getPodCd());
			param.put("pol_cnt", adjustmentVO.getPolCnt());
			param.put("pod_cnt", adjustmentVO.getPodCnt());
			param.put("pol_conti", adjustmentVO.getPolConti());
			param.put("pod_conti", adjustmentVO.getPodConti());
			param.put("slan_cd", adjustmentVO.getSlanCd());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortPairExceptionDBDAOAdjustmentRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustmentVO.class);
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
	 * BlockLane List 조회<br>
	 * 
	 * @param RouteForBLVO routeForBLVO
	 * @return List<RouteForBLVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<RouteForBLVO> searchRouteListForBlockLane(RouteForBLVO routeForBLVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RouteForBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("cust_trd_prnr_id", routeForBLVO.getCustTrdPrnrId());
			param.put("pol_cd", routeForBLVO.getPolCd());
			param.put("pod_cd", routeForBLVO.getPodCd());
			param.put("pol_cnt", routeForBLVO.getPolCnt());
			param.put("pod_cnt", routeForBLVO.getPodCnt());
			param.put("pol_conti", routeForBLVO.getPolConti());
			param.put("pod_conti", routeForBLVO.getPodConti());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortPairExceptionDBDAORouteForBLRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RouteForBLVO.class);
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
	  * ESD_SCE_124 : list조회<br>
	  * 
	  * @param BlockLaneVO blockLaneVO
	  * @return List<BlockLaneVO>
	  * @throws DAOException
	  */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<BlockLaneVO> searchBlockLaneList(BlockLaneVO blockLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlockLaneVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (blockLaneVO != null) {
				Map<String, String> mapVO = blockLaneVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//gubun이 A인 경우 C1T0W 가 아닌경우 gubun이 B인 경우 C1T0W 인 경우
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortPairExceptionDBDAOBlockLaneRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlockLaneVO.class);
			}
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
	 * ESD_SCE_124 : 화면 open
	 * @param CustomerVO customerVO
	 * @return List<CustomerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<CustomerVO> searchLaneCombo(CustomerVO customerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (customerVO != null) {
				 Map<String, String> mapVO = customerVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PortPairExceptionDBDAOSearchEdiLaneRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomerVO.class);
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
	 * TP_ID 가 C1T0W가 아닌 경우 입력 <br>
	 * 
	 * @param BlockLaneVO blockLaneVO
	 * @exception DAOException
	 */
	public void addBlockLane(BlockLaneVO blockLaneVO) throws DAOException {
		try {
			 // BlockLaneVO 의 VO가 수정될때 ROUT_RCV_DT 와 ROUT_SEQ의 변수가 없어지지 않도록 주의한다 => PortPairExceptionDBDAOSearchBlockLaneListRSQL
			SQLExecuter sqlExe = new SQLExecuter("");
			if (blockLaneVO  != null) {
				Map<String, String> param = blockLaneVO .getColumnValues();
				int result = 0;
				result = sqlExe.executeUpdate(
						(ISQLTemplate) new PortPairExceptionDBDAOAddMultiBlockLane2CSQL(),
						param, null);
				
				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * TP_ID 가 C1T0W인 경우 입력 <br>
	 * 
	 * @param BlockLaneVO blockLaneVO
	 * @exception DAOException
	 */
	public void addAdjBlockLane(BlockLaneVO blockLaneVO) throws DAOException {
		try {
			 // BlockLaneVO 의 VO가 수정될때 ROUT_RCV_DT 와 ROUT_SEQ의 변수가 없어지지 않도록 주의한다 
			SQLExecuter sqlExe = new SQLExecuter("");
			if (blockLaneVO  != null) {
				Map<String, String> param = blockLaneVO .getColumnValues();
				int result = 0;
				result = sqlExe.executeUpdate(
						(ISQLTemplate) new PortPairExceptionDBDAOAddMultiBlockLaneCSQL(),
						param, null);
				
				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * TP_ID 가 C1T0W이거나 아닌 경우 수정 <br>
	 * 
	 * @param List<BlockLaneVO> blockLaneVO
	 * @return int[]
	 * @exception DAOException
	 * @exception EventException
	 */
	public int[] modifyBlockLane(List<BlockLaneVO> blockLaneVO) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(blockLaneVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortPairExceptionDBDAOModifyMultiBlockLaneUSQL(), blockLaneVO,null);
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
	 * TP_ID 가 C1T0W인 경우 삭제 <br>
	 * 
	 * @param List<BlockLaneVO> blockLaneVO
	 * @return int[]
	 * @exception DAOException
	 * @exception EventException
	 */
	public int[] removeAdjBlockLane(List<BlockLaneVO> blockLaneVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(blockLaneVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortPairExceptionDBDAORemoveMultiBlockLaneDSQL(), blockLaneVO,null);
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
	
	 /**
	  * TP_ID 가 C1T0W가 아닌 경우 삭제<br>
	  * 
	  * @param BlockLaneVO blockLaneVO
	  * @exception DAOException
	  * @exception Exception
	  */
	public void removeBlockLane(BlockLaneVO blockLaneVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (blockLaneVO  != null) {
				Map<String, String> param = blockLaneVO .getColumnValues();
				int result = sqlExe.executeUpdate(
							(ISQLTemplate) new PortPairExceptionDBDAORemoveMultiBlockLane2DSQL(),
							param, null);
				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

}
