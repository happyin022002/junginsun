/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRISimulationDBDAO.java
*@FileTitle : PRI Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.basic.PRISimulationBCImpl;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtOutVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriCntrInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriCntrSrhCondVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriSimRoutInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.TrfChgVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriSimChgRtVO;
import com.clt.syscommon.common.table.PriSimRtVO;

/**
 * PRISimulationDBDAO <br>
 * - PRI system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SHKIM
 * @see PRISimulationBCImpl 참조
 * @since J2EE 1.6
 */
public class PRISimulationDBDAO extends DBDAOSupport {
	
	//[ESM_PRI_6101] START########################################
	
	/**
	 * ESM_PRI_6101 : Retrieve <br>
	 * get the result for Contract Info of SC
	 * @param PriCntrSrhCondVO priCntrSrhCondVO
	 * @return List<PriCntrInfoVO>
	 * @exception DAOException
	 */
	public List<PriCntrInfoVO> searchContractInfoListForSC(PriCntrSrhCondVO priCntrSrhCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriCntrInfoVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priCntrSrhCondVO != null){
				Map<String, String> mapVO = priCntrSrhCondVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAORsltSCContractInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriCntrInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_6101 : Retrieve <br>
	 * get the result for Contract Info of RFA
	 * @param PriCntrSrhCondVO priCntrSrhCondVO
	 * @return List<PriCntrInfoVO>
	 * @exception DAOException
	 */
	public List<PriCntrInfoVO> searchContractInfoListForRFA(PriCntrSrhCondVO priCntrSrhCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriCntrInfoVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priCntrSrhCondVO != null){
				Map<String, String> mapVO = priCntrSrhCondVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAORsltRFAContractInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriCntrInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_6101 : Retrieve <br>
	 * get the result for Contract Info of TAA
	 * @param PriCntrSrhCondVO priCntrSrhCondVO
	 * @return List<PriCntrInfoVO>
	 * @exception DAOException
	 */
	public List<PriCntrInfoVO> searchContractInfoListForTAA(PriCntrSrhCondVO priCntrSrhCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriCntrInfoVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priCntrSrhCondVO != null){
				Map<String, String> mapVO = priCntrSrhCondVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAORsltTAAContractInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriCntrInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	//[ESM_PRI_6101] END########################################


	/**
	 * ESM_PRI_6001 : Retrieve <br>
	 * retrieving created product catalog list
	 * @param AplyRtInVO paramVO
	 * @return List<PriSimRoutInfoVO>
	 * @exception DAOException
	 */
	public List<PriSimRoutInfoVO> searchProductCatalog(AplyRtInVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSimRoutInfoVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(paramVO != null){
				Map<String, String> mapVO = paramVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOSearchProductCatalogRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSimRoutInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * retrieving summarized rate
	 * @param AplyRtInVO aplyRtInVO
	 * @return List<AplyRtOutVO>
	 * @exception DAOException
	 */
	public List<AplyRtOutVO> searchRateByPctlNo(AplyRtInVO aplyRtInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AplyRtOutVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(aplyRtInVO != null){
				Map<String, String> mapVO = aplyRtInVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOSearchRateByPctlNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AplyRtOutVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Checking Contract Type. (SC,RFA,TAA)
	 * @param String ctrtNo
	 * @return String
	 * @exception DAOException
	 */
	public String checkCtrtType(String ctrtNo) throws DAOException {
		DBRowSet dbRowset = null;
		String output_text = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(ctrtNo != null){
				param.put("ctrt_no", ctrtNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOCheckCtrtTypeRSQL(), param, null);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("CTRT_TP");
			} else {
				output_text = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}
	
	/**
	 * get the result for Revenue Detail Info of Selected Container Size,Commodity
	 * @param AplyRtInVO aplyRtInVO
	 * @return List<AplyRtOutVO>
	 * @exception DAOException
	 */
	public List<AplyRtOutVO> searchRevenueDetailInfo(AplyRtInVO aplyRtInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AplyRtOutVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(aplyRtInVO != null){
				Map<String, String> mapVO = aplyRtInVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOSearchRevenueDetailInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AplyRtOutVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * EsmBkg6001 Apply Rate<br>
	 * SC Apply Rate - Call Autorating Package<br>
	 * 
	 * @author 
	 * @param AplyRtInVO aplyRtInVO
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchScSimOftAutoratingList(AplyRtInVO aplyRtInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScOftAutoratingListVO> list = null;
		List<SearchScOftAutoratingListVO> listUnmatch = null;

		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;		
		
		String msg1 = "";
		String msg2 = "";
		try {
			conn = getConnection();
			
			cstmt = conn.prepareCall("begin BKG_SC_SIM_RT_01_PKG.BKG_SC_SIM_RT_PRC(?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, aplyRtInVO.getCtrtNo());
			cstmt.setString(2, aplyRtInVO.getLdDt());
			cstmt.setString(3, aplyRtInVO.getSvcScpCd());
			cstmt.setString(4, aplyRtInVO.getCmdtCd());
			cstmt.setString(5, aplyRtInVO.getPctlNo());
			cstmt.registerOutParameter(6, OracleTypes.CURSOR);
			cstmt.registerOutParameter(7, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(8, OracleTypes.VARCHAR); 
			log.debug("execute 전");
			boolean flg = cstmt.execute();
			
			dbRowset = new DBRowSet();
			log.debug("flg="+flg);
			
			
			 
			rs = (ResultSet) cstmt.getObject(6);
	        dbRowset.populate(rs);	
			msg1 = (String) cstmt.getObject(7);
			msg2 = (String) cstmt.getObject(8);

			if(msg2!=null){
				log.error("BKG_SC_SIM_RT_PRC ERROR > "+msg1+" : "+msg2);
			}
        
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
			log.debug("execute 후");
			
			for (int i = 0; i<list.size(); i++)
			{
				list.get(i).setAutoRatFlg("Y");
			}
			
			// Unmatch
			if ("Y".equals(aplyRtInVO.getUnmatchChk()))
			{
				cstmt = conn.prepareCall("begin BKG_SC_SIM_UMCH_RT_01_PKG.BKG_SC_SIM_UMCH_RT_PRC (?,?,?,?,?,?,?,?); end;");

				cstmt.setString(1, aplyRtInVO.getCtrtNo());
				cstmt.setString(2, aplyRtInVO.getLdDt());
				cstmt.setString(3, aplyRtInVO.getSvcScpCd());
				cstmt.setString(4, aplyRtInVO.getCmdtCd());
				cstmt.setString(5, aplyRtInVO.getPctlNo());
				cstmt.registerOutParameter(6, OracleTypes.CURSOR);
				cstmt.registerOutParameter(7, OracleTypes.VARCHAR);
				cstmt.registerOutParameter(8, OracleTypes.VARCHAR); 
				log.debug("execute Unmatch 전");
				flg = cstmt.execute();
				
				dbRowset = new DBRowSet();
				log.debug("unmatch flg="+flg);
				
				rs = (ResultSet) cstmt.getObject(6);
		        dbRowset.populate(rs);	
				msg1 = (String) cstmt.getObject(7);
				msg2 = (String) cstmt.getObject(8);

				if(msg2!=null){
					log.error("BKG_SC_SIM_UMCH_RT_PRC ERROR > "+msg1+" : "+msg2);
				}
				listUnmatch = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
				log.debug("execute Unmatch 후");
				
				for (int i = 0; i<listUnmatch.size(); i++)
				{
					listUnmatch.get(i).setAutoRatFlg("N");
				}
				list.addAll(listUnmatch);
			}
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			if (rs != null) try {closeResultSet(rs);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}
			if (cstmt != null) try {closeStatement(cstmt);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}
			if (conn != null) try {closeConnection(conn);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}

		}
		return list;
	}

	/**
	 * save temporarily for calling surcharge auto-rating<br>
	 *
	 * @param SearchScOftAutoratingListVO vo
	 * @param String pctlNo
	 * @param String usrId
	 * @throws DAOException
	 */
	public void addAutoRtOcnFrtTempBySc(SearchScOftAutoratingListVO vo, String pctlNo, String usrId) throws DAOException{
		int result = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap<String, String>();
			SQLExecuter sqlExe = new SQLExecuter("");
			
			mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			param.put("pctl_no", pctlNo);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			velParam.put("pctl_no", pctlNo);
			result = sqlExe.executeUpdate((ISQLTemplate) new PRISimulationDBDAOAddAutoRtOcnFrtTempCSQL(), param, velParam);
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
	 * delete temporarily for calling surcharge of another OFT auto-rating<br>
	 *
	 * @throws DAOException
	 */
	public void deleteAutoRtOcnFrtTemp() throws DAOException{
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate) new PRISimulationDBDAODeleteAutoRtOcnFrtTempDSQL(), null, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * save temporarily for calling surcharge auto-rating<br>
	 *
	 * @param SearchRfaOftAutoratingListVO vo
	 * @param String pctlNo
	 * @param String usrId
	 * @throws DAOException
	 */
	public void addAutoRtOcnFrtTempByRfa(SearchRfaOftAutoratingListVO vo, String pctlNo, String usrId) throws DAOException{
		int result = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap<String, String>();
			SQLExecuter sqlExe = new SQLExecuter("");
			
			mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			param.put("pctl_no", pctlNo);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			velParam.put("pctl_no", pctlNo);
			result = sqlExe.executeUpdate((ISQLTemplate) new PRISimulationDBDAOAddAutoRtOcnFrtTempCSQL(), param, velParam);
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
	 * save temporarily for calling surcharge auto-rating<br>
	 *
	 * @param SearchTaaOftAutoratingListVO vo
	 * @param String pctlNo
	 * @param String usrId
	 * @throws DAOException
	 */
	public void addAutoRtOcnFrtTempByTaa(SearchTaaOftAutoratingListVO vo, String pctlNo, String usrId) throws DAOException{
		int result = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap<String, String>();
			SQLExecuter sqlExe = new SQLExecuter("");
			
			mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			param.put("pctl_no", pctlNo);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			velParam.put("pctl_no", pctlNo);
			result = sqlExe.executeUpdate((ISQLTemplate) new PRISimulationDBDAOAddAutoRtOcnFrtTempCSQL(), param, velParam);
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
	 * save pri_sim_rt<br>
	 *
	 * @param List<PriSimRtVO> list
	 * @throws DAOException
	 */
	public void addPriSimRt(List<PriSimRtVO> list) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();
		int result=0;
		String strCmdtCd = "";
		
		try {
			if (list.size() > 0)
			{
				for(PriSimRtVO vo : list){
					mapVO = vo.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					strCmdtCd = vo.getCmdtCd();
					result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PRISimulationDBDAOAddPriSimRtCSQL(), param, velParam);
					if (result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException se) {
			log.error("============"+strCmdtCd+" is something wrong. Please check again.");
			String msg = strCmdtCd+" Commodity is something wrong. Please check again.";
			throw new DAOException(msg);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
			
		}
	}
	
	/**
	 * save pri_sim_chg_rt<br>
	 *
	 * @param List<PriSimChgRtVO> list
	 * @throws DAOException
	 */
	public void addPriSimChgRt(List<PriSimChgRtVO> list) throws DAOException{
		Map<String, String> mapVO = new HashMap<String, String>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			for(PriSimChgRtVO vo : list){
				mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				result = sqlExe.executeUpdate((ISQLTemplate) new PRISimulationDBDAOAddPriSimChgRtCSQL(), param, velParam);
				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * EsmBkg6001 Apply Rate<br>
	 * Apply Rate - Call Surcharge Autorating Package
	 * 
	 * @param ScOftAutoratingListVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSimSurchargeAutoratingList(ScOftAutoratingListVO vo ) throws DAOException {
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		CallableStatement cstmt= null;
		Connection conn = null;
		ResultSet rs = null;	
		String msg1 = "";
		String msg2 = "";
		
		try {
			if(vo != null){
				conn = getConnection();
				Map<String, String> mapVo = vo .getColumnValues();
				
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				
				String sql = "begin BKG_SUR_SIM_AUTO_RT_PKG.BKG_SUR_SIM_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?,?); end;";
				if ("N".equals(vo.getAutoRatFlg()))
				{
					sql = "begin BKG_SUR_SIM_UMCH_RT_PKG.BKG_SUR_SIM_UMCH_RT_PRC(?,?,?,?,?,?,?,?,?,?); end;";
				}
				if(conn != null){
					cstmt = conn.prepareCall(sql);
					
					cstmt.setString(1, vo.getCtrtNo());
					cstmt.setString(2, vo.getRtAplyDt());
					cstmt.setString(3, vo.getsvcScpCd());
//					cstmt.setString(4, vo.getCmdtCd());
					cstmt.setString(4, "");
					cstmt.setString(5, vo.getCtrtTpCd());
					cstmt.setString(6, vo.getPctlNo());
					cstmt.setString(7, vo.getCntrTpsz());
					
					cstmt.registerOutParameter(8, OracleTypes.CURSOR);
					cstmt.registerOutParameter(9, OracleTypes.VARCHAR);
					cstmt.registerOutParameter(10, OracleTypes.VARCHAR);
					
					log.debug("execute 전");
					boolean flg = cstmt.execute();
					
					dbRowset = new DBRowSet();
					log.debug("flg="+flg);
		 
					rs = (ResultSet) cstmt.getObject(8);
			        dbRowset.populate(rs);
					msg1 = (String) cstmt.getObject(9);
					msg2 = (String) cstmt.getObject(10);
					
					if(msg2!=null){
						log.error("BKG_SUR_SIM_AUTO_RT_PRC ERROR > "+msg1+" : "+msg2);
					}
					
					log.debug("execute 후");
				}
				
			}
			
			
			
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			if (rs != null) try {closeResultSet(rs);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}
			if (cstmt != null) try {closeStatement(cstmt);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}
			if (conn != null) try {closeConnection(conn);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}
		}
		return dbRowset;
	}	
	
	
	/**
	 * ESM_PRI_6002 : Retrieve <br>
	 * retrieving created product catalog list
	 * @param AplyRtInVO paramVO
	 * @return List<PriSimRoutInfoVO>
	 * @exception DAOException
	 */
	public List<PriSimRoutInfoVO> searchCMCost(AplyRtInVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSimRoutInfoVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(paramVO != null){
				Map<String, String> mapVO = paramVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOSearchCMCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSimRoutInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * deleting pri_sim_rt
	 * 
	 * @param String pctlNo
	 * @return int
	 * @exception EventException
	 */
	public int deletePriSimRt(String pctlNo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int delCnt = 0;

		try {
			if(pctlNo!=null && !"".equals(pctlNo)){
				param.put("pctl_no", pctlNo);
				velParam.put("pctl_no", pctlNo);
			
				SQLExecuter sqlExe = new SQLExecuter("");
				delCnt = sqlExe.executeUpdate((ISQLTemplate) new PRISimulationDBDAODeletePriSimRtDSQL(), param, velParam);
				if (delCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
			}else{
				throw new DAOException(new ErrorHandler("COM12240").getMessage());
			}
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}	

	/**
	 * deleting pri_sim_chg_rt
	 * 
	 * @param String pctlNo
	 * @return int
	 * @exception EventException
	 */
	public int deletePriSimChgRt(String pctlNo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int delCnt = 0;

		try {
			if(pctlNo!=null && !"".equals(pctlNo)){
				param.put("pctl_no", pctlNo);
				velParam.put("pctl_no", pctlNo);
			
				SQLExecuter sqlExe = new SQLExecuter("");
				delCnt = sqlExe.executeUpdate((ISQLTemplate) new PRISimulationDBDAODeletePriSimChgRtDSQL(), param, velParam);
				if (delCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
			}else{
				throw new DAOException(new ErrorHandler("COM12240").getMessage());
			}
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	

	
	/**
	 * EsmBkg6001 Apply Rate<br>
	 * SC Apply Rate - Call Autorating Package<br>
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRfaOftAutoratingListVO> searchRfaSimOftAutoratingList(AplyRtInVO aplyRtInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRfaOftAutoratingListVO> list = null;
		List<SearchRfaOftAutoratingListVO> listUnmatch = null;

		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;		
		
		String msg1 = "";
		String msg2 = "";
		try {
			conn = getConnection();
			
			cstmt = conn.prepareCall("begin BKG_RFA_SIM_RT_01_PKG.BKG_RFA_SIM_RT_PRC(?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, aplyRtInVO.getCtrtNo());
			cstmt.setString(2, aplyRtInVO.getLdDt());
			cstmt.setString(3, aplyRtInVO.getSvcScpCd());
			cstmt.setString(4, aplyRtInVO.getCmdtCd());
			cstmt.setString(5, aplyRtInVO.getPctlNo());
			cstmt.registerOutParameter(6, OracleTypes.CURSOR);
			cstmt.registerOutParameter(7, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(8, OracleTypes.VARCHAR); 
			log.debug("execute 전");
			boolean flg = cstmt.execute();
			
			dbRowset = new DBRowSet();
			log.debug("flg="+flg);
			
			
			 
			rs = (ResultSet) cstmt.getObject(6);
	        dbRowset.populate(rs);	
			msg1 = (String) cstmt.getObject(7);
			msg2 = (String) cstmt.getObject(8);

			if(msg2!=null){
				log.error("BKG_RFA_SIM_RT_PRC ERROR > "+msg1+" : "+msg2);
			}
        
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRfaOftAutoratingListVO.class);
			log.debug("execute 후");
			
			for (int i = 0; i<list.size(); i++)
			{
				list.get(i).setAutoRatFlg("Y");
			}
			
			// Unmatch
			if ("Y".equals(aplyRtInVO.getUnmatchChk()))
			{                                   
				cstmt = conn.prepareCall("begin BKG_RFA_SIM_UMCH_RT_01_PKG.BKG_RFA_SIM_UMCH_RT_PRC (?,?,?,?,?,?,?,?); end;");
				cstmt.setString(1, aplyRtInVO.getCtrtNo());
				cstmt.setString(2, aplyRtInVO.getLdDt());
				cstmt.setString(3, aplyRtInVO.getSvcScpCd());
				cstmt.setString(4, aplyRtInVO.getCmdtCd());
				cstmt.setString(5, aplyRtInVO.getPctlNo());
				cstmt.registerOutParameter(6, OracleTypes.CURSOR);
				cstmt.registerOutParameter(7, OracleTypes.VARCHAR);
				cstmt.registerOutParameter(8, OracleTypes.VARCHAR); 
				log.debug("execute Unmatch 전");
				flg = cstmt.execute();
				
				dbRowset = new DBRowSet();
				log.debug("unmatch flg="+flg);

				rs = (ResultSet) cstmt.getObject(6);
		        dbRowset.populate(rs);	
				msg1 = (String) cstmt.getObject(7);
				msg2 = (String) cstmt.getObject(8);

				if(msg2!=null){
					log.error("BKG_RFA_SIM_UMCH_RT_PRC ERROR > "+msg1+" : "+msg2);
				}
				listUnmatch = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRfaOftAutoratingListVO.class);
				log.debug("execute Unmatch 후");
				for (int i = 0; i<listUnmatch.size(); i++)
				{
					listUnmatch.get(i).setAutoRatFlg("N");
				}
				list.addAll(listUnmatch);
			}
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			if (rs != null) try {closeResultSet(rs);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}
			if (cstmt != null) try {closeStatement(cstmt);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}
			if (conn != null) try {closeConnection(conn);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}
		}
		return list;
	}
	

	
	/**
	 * EsmBkg6001 Apply Rate<br>
	 * SC Apply Rate - Call Autorating Package<br>
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @return List<SearchTaaOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTaaOftAutoratingListVO> searchTaaSimOftAutoratingList(AplyRtInVO aplyRtInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTaaOftAutoratingListVO> list = null;


		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;		
		
		String msg1 = "";
		String msg2 = "";
		try {
			conn = getConnection();
			
			cstmt = conn.prepareCall("begin BKG_TAA_SIM_RT_01_PKG.BKG_TAA_SIM_RT_PRC(?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, aplyRtInVO.getCtrtNo());
			cstmt.setString(2, aplyRtInVO.getLdDt());
			cstmt.setString(3, aplyRtInVO.getSvcScpCd());
			cstmt.setString(4, aplyRtInVO.getCmdtCd());
			cstmt.setString(5, aplyRtInVO.getPctlNo());
			cstmt.registerOutParameter(6, OracleTypes.CURSOR);
			cstmt.registerOutParameter(7, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(8, OracleTypes.VARCHAR); 
			log.debug("execute 전");
			boolean flg = cstmt.execute();
			
			dbRowset = new DBRowSet();
			log.debug("flg="+flg);
			
			
			 
			rs = (ResultSet) cstmt.getObject(6);
	        dbRowset.populate(rs);	
			msg1 = (String) cstmt.getObject(7);
			msg2 = (String) cstmt.getObject(8);

			if(msg2!=null){
				log.error("BKG_TAA_SIM_RT_PRC ERROR > "+msg1+" : "+msg2);
			}
        
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchTaaOftAutoratingListVO.class);
			log.debug("execute 후");
			
			for (int i = 0; i<list.size(); i++)
			{
				list.get(i).setAutoRatFlg("Y");
			}
			
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			if (rs != null) try {closeResultSet(rs);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}
			if (cstmt != null) try {closeStatement(cstmt);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}
			if (conn != null) try {closeConnection(conn);} catch (Exception e) {
			    log.error(e.getMessage(), e);
			    throw new DAOException(new ErrorHandler(e).getMessage());
			}

		}
		return list;
	}

	/**
	 * ESM_PRI_6002 : 
	 * @param AplyRtInVO paramVO
	 * @return List<PriSimRoutInfoVO>
	 * @exception DAOException
	 */
	public List<PriSimRtVO> searchPriSimRtList(AplyRtInVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSimRtVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(paramVO != null){
				Map<String, String> mapVO = paramVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOSearchPriSimRtListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSimRtVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_6002 : 
	 * @param AplyRtInVO paramVO
	 * @return List<TrfChgVO>
	 * @exception DAOException
	 */
	public List<TrfChgVO> searchTariffSurcharge(AplyRtInVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrfChgVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(paramVO != null){
				Map<String, String> mapVO = paramVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOSearchTariffSurchargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrfChgVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_6002 : 
	 * @param String pctlNo
	 * @return List<TrfChgVO>
	 * @exception DAOException
	 */
	public List<TrfChgVO> searchChgCd(String pctlNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrfChgVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("f_pctl_no", pctlNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOSearchChgCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrfChgVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_6002 : 
	 * @param String por
	 * @return List<AplyRtInVO>
	 * @exception DAOException
	 */
	public List<AplyRtInVO> searchSlsOfcCd(String por) throws DAOException {
		DBRowSet dbRowset = null;
		List<AplyRtInVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("por", por);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOSearchSlsOfcCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AplyRtInVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * retrieving summarized rate
	 * @param AplyRtInVO aplyRtInVO
	 * @return List<AplyRtOutVO>
	 * @exception DAOException
	 */
	public List<AplyRtOutVO> searchUnmatchRateByPctlNo(AplyRtInVO aplyRtInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AplyRtOutVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(aplyRtInVO != null){
				Map<String, String> mapVO = aplyRtInVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOSearchUnmatchRateByPctlNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AplyRtOutVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * retrieving svc scp
	 * @param String pctlNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSvcScp(String pctlNo) throws DAOException {
		DBRowSet dbRowset = null;
		String output_text = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(pctlNo != null){
				param.put("pctl_no", pctlNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOSearchSvcScpRSQL(), param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("SVC_SCP_CD");
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}

	/**
	 * retrieving trans mode
	 * @param String pctlNo
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchTrnsMod(String pctlNo) throws DAOException {
		DBRowSet dbRowset = null;
		String[] output_text = new String[2]; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(pctlNo != null){
				param.put("pctl_no", pctlNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRISimulationDBDAOSearchTrnsModRSQL(), param, velParam);
			if (dbRowset.next()) {
				output_text[0] = dbRowset.getString("ORG_TRNS_MOD_CD");
				output_text[1] = dbRowset.getString("DEST_TRNS_MOD_CD");
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}

	/**
	 * deleting pri_sim_rt
	 * 
	 * @param String pctlNo
	 * @return int
	 * @exception EventException
	 */
	public int deletePriSimPara(String pctlNo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int delCnt = 0;

		try {
			if(pctlNo!=null && !"".equals(pctlNo)){
				param.put("pctl_no", pctlNo);
				velParam.put("pctl_no", pctlNo);
			
				SQLExecuter sqlExe = new SQLExecuter("");
				delCnt = sqlExe.executeUpdate((ISQLTemplate) new PRISimulationDBDAODeletePriSimParaDSQL(), param, velParam);
				if (delCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
			}else{
				throw new DAOException(new ErrorHandler("COM12240").getMessage());
			}
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}	

	/**
	 * save pri_sim_para<br>
	 *
	 * @param AplyRtInVO vo
	 * @param String usrId
	 * @throws DAOException
	 */
	public void addPriSimPara(AplyRtInVO vo, String usrId) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();
		int result=0;
		
		try {
			if (vo != null){
				mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cre_usr_id", usrId);
				velParam.put("cre_usr_id", usrId);
				
				result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PRISimulationDBDAOAddPriSimParaCSQL(), param, velParam);
				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			throw new DAOException(se.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}
	}
}