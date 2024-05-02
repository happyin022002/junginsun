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
 * 2012.06.20 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
 * 2012.12.18 김진주 [CHM-201220395-04] Add-on management T/F
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeRemarkVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 RfaOftAutoRatingDBDAO <br>
 * - NIS2010-RfaOftAutoRating system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LEE JINSEO
 * @see RfaOftAutoRatingBCImpl 참조
 * @since J2EE 1.6
 */
public class RfaOftAutoRatingDBDAO extends DBDAOSupport {

		/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking AsiaEurope AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String rfaNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRfaOftAutoratingListVO> searchRfaOftAutoratingList(String bkgNo, String caFlag, String rfaNo, String rtAplyDt, String scpCd, String cmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRfaOftAutoratingListVO> list = null;
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;		
		
		String msg1 = "";
		String msg2 = "";
		
		try {
			conn = getConnection();
	        
			cstmt = conn.prepareCall("begin BKG_RFA_AUTO_RT_01_PKG.BKG_RFA_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?); end;");
											
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, rfaNo);
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
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRfaOftAutoratingListVO.class);
			
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			try{
		        closeResultSet(rs);
		        closeStatement(cstmt);
		        closeConnection(conn);
			}catch(Exception e){
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage(), e);
			};
		}
		return list;
	}
	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking AsiaEurope AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 미주가 포함되지 않은 Scope에 대해 Add-On, IHC Tariff를 적용해 Autorating
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String rfaNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRfaOftAutoratingListVO> searchRfaFICOftAutoratingList(String bkgNo, String caFlag, String rfaNo, String rtAplyDt, String scpCd, String cmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRfaOftAutoratingListVO> list = null;
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;		
		
		String msg1 = "";
		String msg2 = "";
		
		try {
			conn = getConnection();
	        
			cstmt = conn.prepareCall("begin BKG_RFA_AUTO_RT_PKG.BKG_RFA_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?); end;");
											
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, rfaNo);
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
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRfaOftAutoratingListVO.class);
			
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			try{
		        closeResultSet(rs);
		        closeStatement(cstmt);
		        closeConnection(conn);
			}catch(Exception e){
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage(), e);
			};
		}
		return list;
	}
	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking AsiaEurope AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author JJ
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String rfaNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRfaOftAutoratingListVO> searchRfaAEEOftAutoratingList(String bkgNo, String caFlag, String rfaNo, String rtAplyDt, String scpCd, String cmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRfaOftAutoratingListVO> list = null;
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;		
		
		String msg1 = "";
		String msg2 = "";
		
		try {
			conn = getConnection();
	        
			cstmt = conn.prepareCall("begin BKG_RFA_AEE_AUTO_RT_PKG.BKG_RFA_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?); end;");
											
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, rfaNo);
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
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRfaOftAutoratingListVO.class);
			
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			try{
		        closeResultSet(rs);
		        closeStatement(cstmt);
		        closeConnection(conn);
			}catch(Exception e){
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage(), e);
			};
		}
		return list;
	}
	

	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking AsiaEurope AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author JJ
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String rfaNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRfaOftAutoratingListVO> searchRfaAEWOftAutoratingList(String bkgNo, String caFlag, String rfaNo, String rtAplyDt, String scpCd, String cmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRfaOftAutoratingListVO> list = null;
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;		
		
		String msg1 = "";
		String msg2 = "";
		
		try {
			conn = getConnection();
	        
			cstmt = conn.prepareCall("begin BKG_RFA_AEW_AUTO_RT_PKG.BKG_RFA_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?); end;");
											
			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, rfaNo);
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
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRfaOftAutoratingListVO.class);
			
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}finally{
			try{
		        closeResultSet(rs);
		        closeStatement(cstmt);
		        closeConnection(conn);
			}catch(Exception e){
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage(), e);
			};
		}
		return list;
	}
	/**
	 * 구주 Hinterland 업무 개선 T/F 
	 * AEE, AEW Scope에 대해 신규 적용되는 Autorating 로직 적용 기준일자를 확인하여 
	 * 신규 로직으로 Rating할지의 여부를 조회한다.
	 * 
	 * @author JJ
	 * @param String rtAplyDt
 	 * @param String bkgNo
 	 * @param String caFlg
	 * @return String
	 * @throws DAOException
	 */
	public String searchHinterlandApplyFlag(String rtAplyDt, String bkgNo, String caFlg) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rt_aply_dt", rtAplyDt);
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("ca_flg", caFlg);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SurchargeAutoRatingDBDAOSearchHinterlandApplyFlagRSQL template = new SurchargeAutoRatingDBDAOSearchHinterlandApplyFlagRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("HINTERLAND_APLY_FLG");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking AsiaEurope AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRfaOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd, String cmdtCd, String ctrtTpCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRfaOftAutoratingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkgNo", bkgNo);
			param.put("caFlag", caFlag);
			param.put("scpCd", scpCd);
			param.put("CMDTCd", cmdtCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeAutoRatingDBDAOSearchSurchargeAutoratingListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChargeRemarkVO.class);

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
	 * searchPreCheckRtAplyDt 조회 이벤트 처리
	 * RFA OFT계산 가능 여부를 확인하기를 위해 Rate Application Date를 YYYYMMDD 형식으로 조회
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
			dbRowset = new SQLExecuter("").executeQuery(new RfaOftAutoRatingDBDAOSearchPreCheckRtAplyDtRSQL(), param,velParam);
			
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
	 * checkOftRateMatch 조회 이벤트 처리
	 * RFA OFT계산결과를 체크한다.
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
			dbRowset = new SQLExecuter("").executeQuery(new RfaOftAutoRatingDBDAOcheckOftRateMatchRSQL(), param,velParam);
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
}