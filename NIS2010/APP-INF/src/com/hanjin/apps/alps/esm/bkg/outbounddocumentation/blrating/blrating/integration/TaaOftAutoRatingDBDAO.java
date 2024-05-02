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

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeRemarkVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 TaaOftAutoRatingDBDAO <br>
 * - NIS2010-TaaOftAutoRating system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LEE JINSEO
 * @see TaaOftAutoRatingBCImpl 참조
 * @since J2EE 1.6
 */
public class TaaOftAutoRatingDBDAO extends DBDAOSupport {

		/**
	 * EsmBkg1057 조회 이벤트 처리<br>
	 * Booking AsiaEurope AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String taaNo
 	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchTaaOftAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTaaOftAutoratingListVO> searchTaaOftAutoratingList(String bkgNo, String caFlag,String taaNo, String rtAplyDt, String scpCd, String cmdtCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTaaOftAutoratingListVO> list = null;
		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();


		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;	
		
		String msg1 = "";
		String msg2 = "";
		
		try {
			conn = getConnection();
//			param.put("bkg_no", bkgNo);
//			param.put("ca_flg", caFlag);
//			param.put("scp_cd", scpCd);
//			param.put("cmdt_cd", cmdtCd);
//			param.put("rt_aply_dt", rtAplyDt);
//			
//			velParam.put("bkg_no", bkgNo);
//			velParam.put("ca_flg", caFlag);
//			velParam.put("scp_cd", scpCd);
//			velParam.put("cmdt_cd", cmdtCd);
//			velParam.put("rt_aply_dt",rtAplyDt);
			
			cstmt = conn.prepareCall("begin BKG_TAA_AUTO_RT_01_PKG.BKG_TAA_AUTO_RT_PRC(?,?,?,?,?,?,?,?,?); end;");

			cstmt.setString(1, bkgNo);
			cstmt.setString(2, caFlag);
			cstmt.setString(3, taaNo);
			cstmt.setString(4, rtAplyDt);
			cstmt.setString(5, scpCd);
			cstmt.setString(6, cmdtCd  );
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
 
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchTaaOftAutoratingListVO.class);
 

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
	 * Booking TaaOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @return List<SearchTaaOftAutoratingListVO>
	 * @throws DAOException
	 */
	
	@SuppressWarnings("unchecked")
	public List<SearchTaaOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd, String cmdtCd, String ctrtTpCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTaaOftAutoratingListVO> list = null;
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
	 * EsmBkg007901 searchPreCheckRtAplyDt 조회 이벤트 처리
	 * Taa OFT계산 가능 여부를 확인하기를 위해 Rate Application Date를 YYYYMMDD 형식으로 조회
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
			dbRowset = new SQLExecuter("").executeQuery(new TaaOftAutoRatingDBDAOSearchPreCheckRtAplyDtRSQL(), param,velParam);
			
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
	 * Taa OFT계산결과를 체크한다.
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
			dbRowset = new SQLExecuter("").executeQuery(new TaaOftAutoRatingDBDAOcheckOftRateMatchRSQL(), param,velParam);
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