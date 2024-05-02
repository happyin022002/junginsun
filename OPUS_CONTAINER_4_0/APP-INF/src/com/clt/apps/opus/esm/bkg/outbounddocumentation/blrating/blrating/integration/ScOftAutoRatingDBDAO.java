/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingDBDAO.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.18 김영출
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargeOftFrightListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargePercentBaseChargeListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS ScOftAutoRatingDBDAO <br>
 * - OPUS-ScOftAutoRating system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LEE JINSEO
 * @see RfaOftAutoRatingBCImpl 참조
 * @since J2EE 1.6
 */
public class ScOftAutoRatingDBDAO extends DBDAOSupport {

	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScTAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchScETCOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScOftAutoratingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;		
		
		String msg1 = "";
		String msg2 = "";
		try {
			conn = getConnection();
			
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlag);
			param.put("sc_no", scNo);
			param.put("scpCd", scpCd);
			param.put("cmdt_cd", cmdtCd);
			param.put("rt_aply_dt",rtAplyDt);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlag);
			velParam.put("sc_no", scNo);
			velParam.put("scpCd", scpCd);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("rt_aply_dt",rtAplyDt);
			
//			Map rslt = new SQLExecuter("").executeSP((ISQLTemplate) new ScOftAutoRatingDBDAOSearchScETCOftAutoratingSPListRSQL(), param, velParam);
//			log.debug("==============================rslt===================>"+rslt);
//			log.debug("==============================rslt===================>"+rslt.isEmpty());
//			//dbRowset = (DBRowSet)rslt.get("v_out");
			
			cstmt = conn.prepareCall("begin BKG_SC_ETC_AUTO_RT_01_PKG.BKG_SC_ETC_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, scNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, scpCd);
			cstmt.setString(6, cmdtCd);
			cstmt.registerOutParameter(7, OracleTypes.CURSOR);
			cstmt.registerOutParameter(8, OracleTypes.VARCHAR); 
			cstmt.registerOutParameter(9, OracleTypes.VARCHAR); 
			log.debug("execute 전");
			boolean flg = cstmt.execute();
			
			dbRowset = new DBRowSet();
			log.debug("flg="+flg);
			 
			rs = (ResultSet) cstmt.getObject(7);
	        dbRowset.populate(rs);	
			msg1 = (String) cstmt.getObject(8);
			msg2 = (String) cstmt.getObject(9);
		 

        
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
			log.debug("execute 후");
			 

		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
		   closeResultSet(rs);
	       closeStatement(cstmt);
	       closeConnection(conn);
		}
		return list;
	}

	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScTAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
 	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchScTAEOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScOftAutoratingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;	

		String msg1 = "";
		String msg2 = "";
			
		try {
			conn = getConnection();
			
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlag);
			param.put("sc_no", scNo);
			param.put("scpCd", scpCd);
			param.put("cmdt_cd", cmdtCd);
			param.put("rt_aply_dt",rtAplyDt);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlag);
			velParam.put("sc_no", scNo);
			velParam.put("scpCd", scpCd);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("rt_aply_dt",rtAplyDt);
			  
//			Map rslt = new SQLExecuter("").executeSP((ISQLTemplate) new ScOftAutoRatingDBDAOSearchScTAEOftAutoratingSPListRSQL(), param, velParam);
//			log.debug("==============================rslt===================>"+rslt);
//			log.debug("==============================rslt===================>"+rslt.isEmpty());
//			dbRowset = (DBRowSet)rslt.get("v_out");
			cstmt = conn.prepareCall("begin BKG_SC_TAE_AUTO_RT_01_PKG.BKG_SC_TAE_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, scNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, scpCd);
			cstmt.setString(6, cmdtCd);
			cstmt.registerOutParameter(7, OracleTypes.CURSOR);
			cstmt.registerOutParameter(8, OracleTypes.VARCHAR); 
			cstmt.registerOutParameter(9, OracleTypes.VARCHAR); 
			log.debug("execute 전");
			boolean flg = cstmt.execute();
			
			dbRowset = new DBRowSet();
			log.debug("flg="+flg);
			 
			rs = (ResultSet) cstmt.getObject(7);
            dbRowset.populate(rs);	
			msg1 = (String) cstmt.getObject(8);
			msg2 = (String) cstmt.getObject(9);
			
        
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
			//log.debug("=============>>>"+list.get(0).getDaRapBkgConvTpCd());
			log.debug("execute 후");

		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			   closeResultSet(rs);
		       closeStatement(cstmt);
		       closeConnection(conn);
		}
		return list;
	}
	
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScTAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchScTAWOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScOftAutoratingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;	
		
		String msg1 = "";
		String msg2 = "";
		try {
			conn = getConnection();
			
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlag);
			param.put("sc_no", scNo);
			param.put("scpCd", scpCd);
			param.put("cmdt_cd", cmdtCd);
			param.put("rt_aply_dt",rtAplyDt);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlag);
			velParam.put("sc_no", scNo);
			velParam.put("scpCd", scpCd);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("rt_aply_dt",rtAplyDt);
			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScOftAutoRatingDBDAOSearchScTAWOftAutoratingListRSQL(), param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);

			
			cstmt = conn.prepareCall("begin BKG_SC_TAW_AUTO_RT_01_PKG.BKG_SC_TAW_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?); end;");
			
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, scNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, scpCd);
			cstmt.setString(6, cmdtCd);
			cstmt.registerOutParameter(7, OracleTypes.CURSOR);
			cstmt.registerOutParameter(8, OracleTypes.VARCHAR); 
			cstmt.registerOutParameter(9, OracleTypes.VARCHAR); 
			log.debug("execute 전");
			boolean flg = cstmt.execute();
			
 
			dbRowset = new DBRowSet();
			log.debug("flg="+flg);
		 
			rs = (ResultSet) cstmt.getObject(7);
	        dbRowset.populate(rs);
			msg1 = (String) cstmt.getObject(8);
			msg2 = (String) cstmt.getObject(9);
 
        
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
			log.debug("execute 후");
			
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			   closeResultSet(rs);
		       closeStatement(cstmt);
		       closeConnection(conn);
		}
		return list;
	}
	
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScTAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchScTPSOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScOftAutoratingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Connection conn = null;
		CallableStatement cstmt = null;
//		PreparedStatement ps = null;
		ResultSet rs = null;		
		
		String msg1 = "";
		String msg2 = "";
		try {
			conn = getConnection();
//			ps = conn.prepareStatement("alter session set events '10046 trace name context forever, level 12'");
//			ps.execute();
//			ps.close();
			
//			ps = conn.prepareStatement("alter session set tracefile_identifier='TEST_WAS'");
//			ps.execute();
//			ps.close();
			
			
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlag);
			param.put("sc_no", scNo);
			param.put("scpCd", scpCd);
			param.put("cmdt_cd", cmdtCd);
			param.put("rt_aply_dt",rtAplyDt);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlag);
			velParam.put("sc_no", scNo);
			velParam.put("scpCd", scpCd);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("rt_aply_dt",rtAplyDt);
			
			log.debug("##################"+bkgNo);
			log.debug("##################"+caFlag);
			log.debug("##################"+scNo);
			log.debug("##################"+rtAplyDt);
			log.debug("##################"+scpCd);
			log.debug("##################"+cmdtCd);
//
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScOftAutoRatingDBDAOSearchScTPSOftAutoratingListRSQL(), param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
			cstmt = conn.prepareCall("begin BKG_SC_TPS_AUTO_RT_01_PKG.BKG_SC_TPS_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, scNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, scpCd);
			cstmt.setString(6, cmdtCd);
			cstmt.registerOutParameter(7, OracleTypes.CURSOR);
			cstmt.registerOutParameter(8, OracleTypes.VARCHAR); 
			cstmt.registerOutParameter(9, OracleTypes.VARCHAR); 
			log.debug("execute 전");
			boolean flg = cstmt.execute();
			
//			ps = conn.prepareStatement("alter session set events '10046 trace name context off'");
//			ps.execute();
//			ps.close();
			 
			dbRowset = new DBRowSet();
			log.debug("flg="+flg);
 
			rs = (ResultSet) cstmt.getObject(7);
	        dbRowset.populate(rs);
			msg1 = (String) cstmt.getObject(8);
			msg2 = (String) cstmt.getObject(9);
			
	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
 
			
			log.debug("execute 후");
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			   closeResultSet(rs);
		       closeStatement(cstmt);
		       closeConnection(conn);
		}
		return list;
	}	

	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScTAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String rtAplyDt
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchScTPWOftAutoratingList(String bkgNo, String caFlag, String scpCd, String cmdtCd, String rtAplyDt ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScOftAutoratingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlag);
			param.put("scp_cd", scpCd);
			param.put("cmdt_cd", cmdtCd);
			param.put("rt_aply_dt",rtAplyDt);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlag);
			velParam.put("scp_cd", scpCd);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("rt_aply_dt",rtAplyDt);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScOftAutoRatingDBDAOSearchScTPWOftAutoratingListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);

		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScTAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @param String rtaplydt
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd, String cmdtCd, String ctrtTpCd, String rtaplydt ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScOftAutoratingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlag);
			param.put("svc_scp_cd", scpCd);
			param.put("cmdt_cd", cmdtCd);
			param.put("ctrt_tp_cd",ctrtTpCd);
			param.put("rt_aply_dt", rtaplydt);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlag);
			velParam.put("svc_scp_cd", scpCd);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("ctrt_tp_cd",ctrtTpCd);
			velParam.put("rt_aply_dt", rtaplydt);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeAutoRatingDBDAOSearchSurchargeAutoratingListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);

		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
//	/**
//	 * EsmBkg0269 조회 이벤트 처리<br>
//	 * Booking ScTAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
//	 * 
//	 * @author LEE JIN SEO
//	 * @param ScOftAutoratingListVO vo
//	 * @return List<SearchScOftAutoratingListVO>
//	 * @throws DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingList(ScOftAutoratingListVO vo ) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<SearchScOftAutoratingListVO> list = null;
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			if(vo != null){
//				
//				Map<String, String> mapVo = vo .getColumnValues();
//				
//				param.putAll(mapVo);
//				velParam.putAll(mapVo);
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeAutoRatingDBDAOSearchSurchargeAutoratingListRSQL(), param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
//		} catch (SQLException ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return list;
//	}
	
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScTAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param ScOftAutoratingListVO vo
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingList(ScOftAutoratingListVO vo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScOftAutoratingListVO> list = null;
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		CallableStatement cstmt= null;
		Connection conn = null;
		ResultSet rs = null;	
		String msg1 = "";
		String msg2 = "";
		
		try {
//			if(vo != null){
				conn = getConnection();
//				Map<String, String> mapVo = vo .getColumnValues();
//				
//				param.putAll(mapVo);
//				velParam.putAll(mapVo);
//			}
			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeAutoRatingDBDAOSearchSurchargeAutoratingListRSQL(), param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);

			cstmt = conn.prepareCall("begin BKG_SUR_AUTO_RT_PKG.BKG_SUR_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, vo.getBkgNo());
			cstmt.setString(2, vo.getCaFlg());
			cstmt.setString(3, vo.getCtrtNo());
			cstmt.setString(4, vo.getRtAplyDt());
			cstmt.setString(5, vo.getsvcScpCd());
			cstmt.setString(6, vo.getCmdtCd());
			cstmt.setString(7, vo.getFrtTermCd());
			cstmt.setString(8, vo.getCtrtTpCd());
			cstmt.setString(9, vo.getRtAudTpCd());
			
			cstmt.registerOutParameter(10, OracleTypes.CURSOR);
			cstmt.registerOutParameter(11, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(12, OracleTypes.VARCHAR);
			cstmt.setString(1, vo.getBkgNo());
			cstmt.setString(1, vo.getBkgNo());
			log.debug("execute 전");
			boolean flg = cstmt.execute();
			
			dbRowset = new DBRowSet();
			log.debug("flg="+flg);
 
			rs = (ResultSet) cstmt.getObject(10);
	        dbRowset.populate(rs);
			msg1 = (String) cstmt.getObject(11);
			msg2 = (String) cstmt.getObject(12);
			
	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
 
			
			log.debug("execute 후");
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			   closeResultSet(rs);
		       closeStatement(cstmt);
		       closeConnection(conn);
		}
		return list;
	}	
	
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScTAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @return List<SearchSurchargePercentBaseChargeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSurchargePercentBaseChargeListVO> searchSurchargePercentBaseChargeList() throws DAOException {

		DBRowSet dbRowset = null;
		List<SearchSurchargePercentBaseChargeListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScOftAutoRatingDBDAOSearchSurchargePercentBaseChargeListRSQL(),  param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSurchargePercentBaseChargeListVO.class);
		} catch(SQLException ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScTAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @return List<SearchSurchargeOftFrightListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSurchargeOftFrightListVO> searchSurchargeOftFrightList() throws DAOException {

		DBRowSet dbRowset = null;
		List<SearchSurchargeOftFrightListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScOftAutoRatingDAOSearchSurchargeOftFrightListRSQL(),  param, velParam);
		
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSurchargeOftFrightListVO.class);
		} catch(SQLException ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	
	
	
	/**
	 * EsmBkg0269 등록 이벤트 처리<br>
	 * Surcharge  AutoRating 등록
	 * 
	 * @author LEE JIN SEO
	 * @param SearchScOftAutoratingListVO vo
	 * @param String usrID
	 * @throws DAOException
	 */

	public void addSurchargreAutoratingList(SearchScOftAutoratingListVO vo , String usrID ) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				 vo.setUsrId(usrID);
				 Map<String, String> mapVO = vo .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int inCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAOAddSurchargreAutoratingListCSQL(), param, velParam);
			if(inCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author 
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchScOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScOftAutoratingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;		
		
		String msg1 = "";
		String msg2 = "";
		try {
			conn = getConnection();
			
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlag);
			param.put("sc_no", scNo);
			param.put("scpCd", scpCd);
			param.put("cmdt_cd", cmdtCd);
			param.put("rt_aply_dt",rtAplyDt);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlag);
			velParam.put("sc_no", scNo);
			velParam.put("scpCd", scpCd);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("rt_aply_dt",rtAplyDt);
			
//			Map rslt = new SQLExecuter("").executeSP((ISQLTemplate) new ScOftAutoRatingDBDAOSearchScETCOftAutoratingSPListRSQL(), param, velParam);
//			log.debug("==============================rslt===================>"+rslt);
//			log.debug("==============================rslt===================>"+rslt.isEmpty());
//			//dbRowset = (DBRowSet)rslt.get("v_out");
			
			cstmt = conn.prepareCall("begin BKG_SC_AUTO_RT_01_PKG.BKG_SC_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, scNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, scpCd);
			cstmt.setString(6, cmdtCd);
			cstmt.registerOutParameter(7, OracleTypes.CURSOR);
			cstmt.registerOutParameter(8, OracleTypes.VARCHAR); 
			cstmt.registerOutParameter(9, OracleTypes.VARCHAR); 
			log.debug("execute 전");
			boolean flg = cstmt.execute();
			
			dbRowset = new DBRowSet();
			log.debug("flg="+flg);
			 
			rs = (ResultSet) cstmt.getObject(7);
	        dbRowset.populate(rs);	
			msg1 = (String) cstmt.getObject(8);
			msg2 = (String) cstmt.getObject(9);
		 

        
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
			log.debug("execute 후");
			 

		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
		   closeResultSet(rs);
	       closeStatement(cstmt);
	       closeConnection(conn);
		}
		return list;
	}
	
	/**
	 * EsmBkg0256 Re-Audit<br>
	 * Backend로 수행하기 위해 Global Temp 테이블을 삭제시켜줌.
	 * 
	 * @author KIM TAE KYOUNG
	 * @throws DAOException
	 */
	public void manageAutoratingTempTables() throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempAuditChargeDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempOceanFreightDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");


			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempConversionDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");


			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempOriginIHCDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");


			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempOriginARBDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");


			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempRatingSeqDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");


			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempGroupLocationDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");


			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempGroupCommodityDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");


			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempDestIHCDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");


			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempDestARBDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");


			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempThruRateDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");


			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScOftAutoRatingDBDAORemoveAutoratingTempConvPriorityDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

			

		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}