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
* 2012.04.26 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
* 2013.04.24 김진주 [CHM-201323001] [BKG/DOC - Revenud Audit System] S/C 적용 B/L 자동심사기능 개발
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargeOftFrightListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargePercentBaseChargeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 ScOftAutoRatingDBDAO <br>
 * - NIS2010-ScOftAutoRating system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * @param String audTpCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchScETCOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd, String audTpCd ) throws DAOException {
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
			param.put("aud_tp_cd",audTpCd);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlag);
			velParam.put("sc_no", scNo);
			velParam.put("scpCd", scpCd);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("rt_aply_dt",rtAplyDt);
			velParam.put("aud_tp_cd",audTpCd);
			
//			Map rslt = new SQLExecuter("").executeSP((ISQLTemplate) new ScOftAutoRatingDBDAOSearchScETCOftAutoratingSPListRSQL(), param, velParam);
//			log.debug("==============================rslt===================>"+rslt);
//			log.debug("==============================rslt===================>"+rslt.isEmpty());
//			//dbRowset = (DBRowSet)rslt.get("v_out");
			
			cstmt = conn.prepareCall("begin BKG_SC_ETC_AUTO_RT_PKG.BKG_SC_ETC_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, scNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, scpCd);
			cstmt.setString(6, cmdtCd);
			cstmt.setString(7, audTpCd);
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
	 * @param String audTpCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchScTAEOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd, String cmdtCd, String audTpCd ) throws DAOException {
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
			param.put("aud_tp_cd",audTpCd);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlag);
			velParam.put("sc_no", scNo);
			velParam.put("scpCd", scpCd);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("rt_aply_dt",rtAplyDt);
			velParam.put("aud_tp_cd",audTpCd);
			  
//			Map rslt = new SQLExecuter("").executeSP((ISQLTemplate) new ScOftAutoRatingDBDAOSearchScTAEOftAutoratingSPListRSQL(), param, velParam);
//			log.debug("==============================rslt===================>"+rslt);
//			log.debug("==============================rslt===================>"+rslt.isEmpty());
//			dbRowset = (DBRowSet)rslt.get("v_out");
			cstmt = conn.prepareCall("begin BKG_SC_TAE_AUTO_RT_PKG.BKG_SC_TAE_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, scNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, scpCd);
			cstmt.setString(6, cmdtCd);
			cstmt.setString(7, audTpCd);
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
	 * @param String audTpCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchScTAWOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd, String audTpCd ) throws DAOException {
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
			param.put("aud_tp_cd",audTpCd);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlag);
			velParam.put("sc_no", scNo);
			velParam.put("scpCd", scpCd);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("rt_aply_dt",rtAplyDt);
			velParam.put("aud_tp_cd",audTpCd);
			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScOftAutoRatingDBDAOSearchScTAWOftAutoratingListRSQL(), param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);

			
			cstmt = conn.prepareCall("begin BKG_SC_TAW_AUTO_RT_PKG.BKG_SC_TAW_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?,?); end;");
			
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, scNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, scpCd);
			cstmt.setString(6, cmdtCd);
			cstmt.setString(7, audTpCd);
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
	 * @param String audTpCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchScTPSOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd, String audTpCd ) throws DAOException {
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
			param.put("aud_tp_cd",audTpCd);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlag);
			velParam.put("sc_no", scNo);
			velParam.put("scpCd", scpCd);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("rt_aply_dt",rtAplyDt);
			velParam.put("aud_tp_cd",audTpCd);
			
			log.debug("##################"+bkgNo);
			log.debug("##################"+caFlag);
			log.debug("##################"+scNo);
			log.debug("##################"+rtAplyDt);
			log.debug("##################"+scpCd);
			log.debug("##################"+cmdtCd);
			log.debug("##################"+audTpCd);
//
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScOftAutoRatingDBDAOSearchScTPSOftAutoratingListRSQL(), param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
			cstmt = conn.prepareCall("begin BKG_SC_TPS_AUTO_RT_PKG.BKG_SC_TPS_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, scNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, scpCd);
			cstmt.setString(6, cmdtCd);
			cstmt.setString(7, audTpCd);
			cstmt.registerOutParameter(8, OracleTypes.CURSOR);
			cstmt.registerOutParameter(9, OracleTypes.VARCHAR); 
			cstmt.registerOutParameter(10, OracleTypes.VARCHAR); 
			log.debug("execute 전");
			boolean flg = cstmt.execute();
			
//			ps = conn.prepareStatement("alter session set events '10046 trace name context off'");
//			ps.execute();
//			ps.close();
			 
			dbRowset = new DBRowSet();
			log.debug("flg="+flg);
 
			rs = (ResultSet) cstmt.getObject(8);
	        dbRowset.populate(rs);
			msg1 = (String) cstmt.getObject(9);
			msg2 = (String) cstmt.getObject(10);
			
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
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		CallableStatement cstmt= null;
		Connection conn = null;
		ResultSet rs = null;	
		String msg1 = "";
		String msg2 = "";
		
		String bkgNo = "";
		String caFlg = "";
		String ctrtNo = "";
		String rtAplyDt = "";
		String svcScpCd = "";
		String cmdtCd = "";
		String frtTermCd = "";
		String ctrtTpCd = "";
		String rtAudTpCd = "";
		
		
		try {
			if(vo != null){
				bkgNo = vo.getBkgNo();
				caFlg = vo.getCaFlg();
				ctrtNo = vo.getCtrtNo();
				rtAplyDt = vo.getRtAplyDt();
				svcScpCd = vo.getsvcScpCd();
				cmdtCd =  vo.getCmdtCd();
				frtTermCd = vo.getFrtTermCd();
				ctrtTpCd = vo.getCtrtTpCd();
				rtAudTpCd = vo.getRtAudTpCd();				
			}			
			
			conn = getConnection();
			
			cstmt = conn.prepareCall("begin BKG_SUR_AUTO_RT_PKG.BKG_SUR_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?,?,?,?); end;");
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlg);
			cstmt.setString(3, ctrtNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, svcScpCd);
			cstmt.setString(6, cmdtCd);
			cstmt.setString(7, frtTermCd);
			cstmt.setString(8, ctrtTpCd);
			cstmt.setString(9, rtAudTpCd);
			
			cstmt.registerOutParameter(10, OracleTypes.CURSOR);
			cstmt.registerOutParameter(11, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(12, OracleTypes.VARCHAR);
			
			//log.error("surcharge autorating execute start --- bkg_no[" +  bkgNo + "]");
			boolean flg = cstmt.execute();
			
			dbRowset = new DBRowSet();
			log.error("flg="+flg);
 
			rs = (ResultSet) cstmt.getObject(10);
	        dbRowset.populate(rs);
			msg1 = (String) cstmt.getObject(11);
			msg2 = (String) cstmt.getObject(12);
			
	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
 
			
	        //log.error("surcharge autorating execute end --- bkg_no[" +  bkgNo + "]");
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
	 * Tariff 만으로 계산된 Surcharge Rating 결과를 조회 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param ScOftAutoratingListVO vo
	 * @return List<SearchScOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScOftAutoratingListVO> searchTariffSurchargeAutoratingList(ScOftAutoratingListVO vo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScOftAutoratingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		CallableStatement cstmt= null;
		Connection conn = null;
		ResultSet rs = null;	
		String msg1 = "";
		String msg2 = "";

		String bkgNo = "";
		String caFlg = "";
		String ctrtNo = "";
		String rtAplyDt = "";
		String svcScpCd = "";
		String cmdtCd = "";
		String frtTermCd = "";
		String ctrtTpCd = "";
		String rtAudTpCd = "";
		
		try {
			if(vo != null){
				bkgNo = vo.getBkgNo();
				caFlg = vo.getCaFlg();
				ctrtNo = vo.getCtrtNo();
				rtAplyDt = vo.getRtAplyDt();
				svcScpCd = vo.getsvcScpCd();
				cmdtCd =  vo.getCmdtCd();
				frtTermCd = vo.getFrtTermCd();
				ctrtTpCd = vo.getCtrtTpCd();
				rtAudTpCd = vo.getRtAudTpCd();	
			}
			
			conn = getConnection();
			cstmt = conn.prepareCall("begin BKG_TRF_SUR_AUTO_RT_PKG.BKG_TRF_SUR_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?,?,?,?); end;");
			
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlg);
			cstmt.setString(3, ctrtNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, svcScpCd);
			cstmt.setString(6, cmdtCd);
			cstmt.setString(7, frtTermCd);
			cstmt.setString(8, ctrtTpCd);
			cstmt.setString(9, rtAudTpCd);
			
			cstmt.registerOutParameter(10, OracleTypes.CURSOR);
			cstmt.registerOutParameter(11, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(12, OracleTypes.VARCHAR);
			cstmt.setString(1, bkgNo);
			cstmt.setString(1, bkgNo);
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
	 * EsmBkg007901 searchPreCheckRtAplyDt 조회 이벤트 처리
	 * SC OFT계산 가능 여부를 확인하기를 위해 Rate Application Date를 YYYYMMDD 형식으로 조회
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @throws DAOException
	 */
	public String searchPreCheckRtAplyDt(String bkgNo ,String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery(new ScOftAutoRatingDBDAOSearchPreCheckRtAplyDtRSQL(), param,velParam);
			
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
			
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return result;
	}
	

	/**
	 * EsmBkg007901 checkOftRateMatch 조회 이벤트 처리
	 * SC OFT계산결과를 체크한다.
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @throws DAOException
	 */
	public String checkOftRateMatch(String bkgNo ,String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery(new ScOftAutoRatingDBDAOcheckOftRateMatchRSQL(), param,velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					result = dbRowset.getString("OFT_CMB_SEQ");
				}
			}

		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return result;
	}
	/**
	 * EsmBkg0256 Re-Audit<br>
	 * Backend로 수행하기 위해 Global Temp 테이블을 삭제시켜줌.
	 * 
	 * @author KIM JIN JOO
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