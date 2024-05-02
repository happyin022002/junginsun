/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USADeliveryOrderManageDBDAO.java
*@FileTitle : USA Delivery Order Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2008-10-20
*@LastModifier : poong yeon cho
*@LastVersion : 1.0
* 2008-10-20 poong yeon cho
* 1.0 최초 생성
* -------------------------------------------------------
* history
* 2011.07.20 김영철 [CHM-201111871] [TRS] R4J 소스 품질 조치 내역 수정
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.basic.USADeliveryOrderManageBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.event.EsdTrs0083Event;
import com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.vo.UsaDeliveryOrderManageVO;
import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspUsaDoDtlVO;
import com.hanjin.syscommon.common.table.TrsTrspUsaDoHdrVO;


/**
 * ENIS-USADeliveryOrderManage에 대한 DB 처리를 담당<br>
 * - ENIS-USADeliveryOrderManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong yeon cho
 * @see USADeliveryOrderManageBCImpl 참조
 * @since J2EE 1.4
 */
public class USADeliveryOrderManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * USADeliveryOrderManage의 Consignee정보searchUSDeliveryOrderConsigneeManage를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSDeliveryOrderConsigneeManage(EsdTrs0083Event event) throws DAOException {
		
		log.debug("\n\n searchUSDeliveryOrderConsigneeManage start \n\n");
		
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		UsaDeliveryOrderManageVO usDoVO = event.getUsaDeliveryOrderManageVO();
		
		try {
			param.put("bkgNoArr", CommonUtil.seperationParameter(usDoVO.getBookingNo(), ","));
			param.put("blNoArr", CommonUtil.seperationParameter(usDoVO.getBillNo(), ","));
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new USADeliveryOrderManageDBDAOSearchUSDeliveryOrderConsigneeRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
	}
	
	/**
	 * USADeliveryOrderManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSADeliveryOrderManageList(EsdTrs0083Event event) throws DAOException {
		
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		UsaDeliveryOrderManageVO usDoVO = event.getUsaDeliveryOrderManageVO();
		
		try {
			param.put("bkgNoArr", CommonUtil.seperationParameter(usDoVO.getBookingNo(), ","));
			param.put("blNoArr", CommonUtil.seperationParameter(usDoVO.getBillNo(), ","));
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new USADeliveryOrderManageDBDAOSearchUSDeliveryOrderListRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
	}

/////////////////////////////////////////
	/**
	 * USADeliveryOrderManage의 저정여부를 알기위해 SO를 조회한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSADeliveryOrderCheck(EsdTrs0083Event event) throws DAOException {
		
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		UsaDeliveryOrderManageVO usDoVO = event.getUsaDeliveryOrderManageVO();
		
		try {
			param.put("bkgNoArr", CommonUtil.seperationParameter(usDoVO.getBookingNo(), ","));
			param.put("blNoArr", CommonUtil.seperationParameter(usDoVO.getBillNo(), ","));
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new USADeliveryOrderManageDBDAOSearchUSADeliveryOrderCheckRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
	}
////////////////////////////////////////
	
	
//	/**
//	 * USADeliveryOrderManage의 데이타 모델에 해당되는 값을 불러온다.<br>
//	 * 
//	 * @param event
//	 * @return
//	 * @throws DAOException
//	 */
//	public DBRowSet searchUSADeliveryOrderManage(EsdTrs0083Event event) throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet rs = null;
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		int cnt = 0;
//		
//		HashMap hashParam = event.getHashParam();
//		
//		String formBlNo     = String.valueOf(hashParam.get("form_bl_no"));
//		ArrayList arrayBlNo = null; 
//		StringBuffer whereQuery = new StringBuffer();
//		StringBuffer whBilno    = new StringBuffer();
//		StringTokenizer st      = null;
//		
//		if( !formBlNo.equals("") ) {
//			cnt = 0;
//			arrayBlNo = new ArrayList();
//			st = new StringTokenizer(formBlNo, ",");
//			while( st.hasMoreTokens() ) {
//				arrayBlNo.add(cnt++, st.nextToken());
//			}		
//			for( int m = 0; m < arrayBlNo.size(); m++ ) {
//				if(m!=0){
//					whereQuery.append(", ");
//				}
//				whereQuery.append("( SUBSTR(?,1,10), SUBSTR(?,11,1), SUBSTR(?,12,1) )");
//			}
//			whBilno.append("	AND ((A.BL_NO, A.BL_NO_TP, A.BL_NO_CHK) IN ( ");
//			whBilno.append(whereQuery);
//			whBilno.append(" ))\n");
//		}
//
//		StringBuffer queryStr = new StringBuffer() ;
//		queryStr.append(" SELECT CRE_DT FROM TRS_TRSP_USA_DO_DTL                                         \n");
//		
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//			
//			i=1;
//			if(arrayBlNo != null ){
//				for(int abc=0; abc<arrayBlNo.size(); abc++ ){
//					ps.setString(i++, String.valueOf(arrayBlNo.get(abc)));
//					ps.setString(i++, String.valueOf(arrayBlNo.get(abc)));
//					ps.setString(i++, String.valueOf(arrayBlNo.get(abc)));
////					ps.clearWarnings();
////					ps.clearParameters();
//				}
//			}
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			rs = ps.executeQuery();
//
//			// 결과를 DBRowset에 담는다.
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return dRs;
//	}

//	/**
//	 * USADeliveryOrderManage의 데이타 모델을 DB에 저장한다.<br>
//	 * 
//	 * @param event
//	 * @throws DAOException
//	 */
//	public void addUSADeliveryOrderManage(EsdTrs0083Event event) throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement headerPs = null;
//		PreparedStatement dtlInsPs = null;
//		PreparedStatement dtlUpdPs = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		
//		HashMap hashParam = event.getHashParam();
//		
//		ArrayList headerList = (ArrayList) event.getTRS_TRSP_USA_DO_HDRS();
//		ArrayList dtlInsList = (ArrayList) event.getTRS_TRSP_USA_DO_DTLS();
//		
//		TrsTrspUsaDoHdrVO trs_trsp_usa_do_hdr_vo = null;
//		TrsTrspUsaDoDtlVO trs_trsp_usa_do_dtl_vo = null;
//		
//		int hdrCnt = 0;
//		int dtlInsCnt = 0;
//		int dtlUpdCnt = 0;
//		
//		StringBuffer headerQueryStr = new StringBuffer();
//		StringBuffer dtlInsQueryStr = new StringBuffer();
//		StringBuffer dtlUpdQueryStr = new StringBuffer();
//		
//		headerQueryStr.append(" INSERT INTO TRS_TRSP_USA_DO_HDR (               \n");
//		headerQueryStr.append("     BL_NO                                       \n");
//		headerQueryStr.append(" ,   BL_NO_TP                                    \n");
//		headerQueryStr.append(" ,   BL_NO_CHK                                   \n");
//		headerQueryStr.append(" ,   IF_SYS_KND_CD                               \n");
//		headerQueryStr.append(" ,   FCTRY_NM                                    \n");
//		headerQueryStr.append(" ,   ACT_CUST_N1ST_ADDR                          \n");
//		headerQueryStr.append(" ,   ACT_CUST_N2ND_ADDR                          \n");
//		headerQueryStr.append(" ,   ACT_CUST_CTY_NM                             \n");
//		headerQueryStr.append(" ,   ACT_CUST_STE_NM                             \n");
//		headerQueryStr.append(" ,   ACT_CUST_ZIP_CD                             \n");
//		headerQueryStr.append(" ,   CNTC_PSON_NM                                \n");
//		headerQueryStr.append(" ,   CNTC_PSON_PHN_NO                            \n");
//		headerQueryStr.append(" ,   CNTC_PSON_FAX_NO                            \n");
//		headerQueryStr.append(" ,   CRE_OFC_CD                                  \n");
//		headerQueryStr.append(" ,   CRE_USR_ID                                  \n");
//		headerQueryStr.append(" ,   CRE_DT                                      \n");
//		headerQueryStr.append(" ,   UPD_USR_ID                                  \n");
//		headerQueryStr.append(" ,   UPD_DT                                      \n");
//		headerQueryStr.append(" ,   USR_EML                                     \n");
//		headerQueryStr.append(" ,   USR_PHN_NO                                  \n");
//		headerQueryStr.append("  ) VALUES (                                     \n");
//		headerQueryStr.append("     ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   NVL(?, 'E')                                 \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(?)        \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(?)        \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" ,   ?                                           \n");
//		headerQueryStr.append(" )                                               \n");
//
//		dtlInsQueryStr.append(" INSERT INTO TRS_TRSP_USA_DO_DTL (               \n");
//		dtlInsQueryStr.append("     BL_NO                                       \n");
//		dtlInsQueryStr.append(" ,   BL_NO_TP                                    \n");
//		dtlInsQueryStr.append(" ,   BL_NO_CHK                                   \n");
//		dtlInsQueryStr.append(" ,   EQ_NO                                       \n");
//		dtlInsQueryStr.append(" ,   DO_RMK                                      \n");
//		dtlInsQueryStr.append(" ,   CRE_OFC_CD                                  \n");
//		dtlInsQueryStr.append(" ,   CRE_USR_ID                                  \n");
//		dtlInsQueryStr.append(" ,   CRE_DT                                      \n");
//		dtlInsQueryStr.append(" ,   UPD_USR_ID                                  \n");
//		dtlInsQueryStr.append(" ,   UPD_DT                                      \n");
//		dtlInsQueryStr.append("  ) VALUES (                                     \n");
//		dtlInsQueryStr.append("     ?                                           \n");
//		dtlInsQueryStr.append(" ,   ?                                           \n");
//		dtlInsQueryStr.append(" ,   ?                                           \n");
//		dtlInsQueryStr.append(" ,   ?                                           \n");
//		dtlInsQueryStr.append(" ,   ?                                           \n");
//		dtlInsQueryStr.append(" ,   ?                                           \n");
//		dtlInsQueryStr.append(" ,   ?                                           \n");
//		dtlInsQueryStr.append(" ,   GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(?)        \n");
//		dtlInsQueryStr.append(" ,   ?                                           \n");
//		dtlInsQueryStr.append(" ,   GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(?)        \n");
//		dtlInsQueryStr.append(" )                                               \n");
//		
//		dtlUpdQueryStr.append(" UPDATE TRS_TRSP_USA_DO_DTL SET                  \n");
//		dtlUpdQueryStr.append("     DO_RMK              = ?                     \n");
//		dtlUpdQueryStr.append(" ,   UPD_USR_ID          = ?                     \n");
//		dtlUpdQueryStr.append(" ,   UPD_DT =GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(?)\n");
//		dtlUpdQueryStr.append(" WHERE                                           \n");
//		dtlUpdQueryStr.append("     BL_NO               = ?                     \n");
//		dtlUpdQueryStr.append(" AND BL_NO_TP            = ?                     \n");
//		dtlUpdQueryStr.append(" AND BL_NO_CHK           = ?                     \n");
//		dtlUpdQueryStr.append(" AND EQ_NO               = ?                     \n");
//		
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				headerPs = new LoggableStatement(con, headerQueryStr.toString());
//				dtlInsPs = new LoggableStatement(con, dtlInsQueryStr.toString());
//				dtlUpdPs = new LoggableStatement(con, dtlUpdQueryStr.toString());
//			} else {
//				headerPs = con.prepareStatement(headerQueryStr.toString());
//				dtlInsPs = con.prepareStatement(dtlInsQueryStr.toString());
//				dtlUpdPs = con.prepareStatement(dtlUpdQueryStr.toString());
//			}
//			
//			for(int k=0;headerList!=null && k<headerList.size(); k++){
//				
//				trs_trsp_usa_do_hdr_vo = (TrsTrspUsaDoHdrVO) headerList.get(k);
//				
//				i = 1;
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getBlNo());
//				/* KYS 소스 정리
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getBlNoTp());
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getBlNoChk());
//				*/
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getIfSysKndCd());
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getFctryNm());
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getActCustN1stAddr());
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getActCustN2ndAddr());
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getActCustCtyNm());
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getActCustSteNm());
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getActCustZipCd());
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getCntcPsonNm());
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getCntcPsonPhnNo());
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getCntcPsonFaxNo());
//				headerPs.setString(i++, (String) hashParam.get("FORM_USR_OFC_CD"));
//				headerPs.setString(i++, (String) hashParam.get("FORM_CRE_USR_ID"));
//				headerPs.setString(i++, (String) hashParam.get("FORM_USR_OFC_CD"));		//cre_dt
//				headerPs.setString(i++, (String) hashParam.get("FORM_CRE_USR_ID"));
//				headerPs.setString(i++, (String) hashParam.get("FORM_USR_OFC_CD"));		//upd_dt
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getUsrEml());			//생성자의 email
//				headerPs.setString(i++, trs_trsp_usa_do_hdr_vo.getUsrPhnNo());		//생성자의 전화번호
//				
////				 Loggable Statement 사용에 의해 추가 
//				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//					log.info("\n SQL :" + ((LoggableStatement)headerPs).getQueryString());
//				} else {
//					log.info("\n SQL :" + headerQueryStr );
//				}
//
//				hdrCnt = headerPs.executeUpdate();
//				headerPs.clearWarnings();
//				headerPs.clearParameters();
//				
//			}
//			
//			for(int k=0;dtlInsList!=null && k<dtlInsList.size(); k++){
//				
//				trs_trsp_usa_do_dtl_vo = (TrsTrspUsaDoDtlVO) dtlInsList.get(k);
//			
//				i = 1;
//				dtlUpdPs.setString(i++, trs_trsp_usa_do_dtl_vo.getDoRmk());
//				dtlUpdPs.setString(i++, (String) hashParam.get("FORM_CRE_USR_ID"));
//				dtlUpdPs.setString(i++, (String) hashParam.get("FORM_USR_OFC_CD"));
//				dtlUpdPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNo());
//				/* kys 소스 정리
//				dtlUpdPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNoTp());
//				dtlUpdPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNoChk());
//				*/
//				dtlUpdPs.setString(i++, trs_trsp_usa_do_dtl_vo.getEqNo());
//				
////				 Loggable Statement 사용에 의해 추가 
//				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//					log.info("\n SQL :" + ((LoggableStatement)dtlUpdPs).getQueryString());
//				} else {
//					log.info("\n SQL :" + dtlUpdQueryStr );
//				}
//
//				dtlUpdCnt = 0;
//				dtlUpdCnt = dtlUpdPs.executeUpdate();
//				dtlUpdPs.clearWarnings();
//				dtlUpdPs.clearParameters();
//				
//				if(dtlUpdCnt == 0){
//					i = 1;
//					dtlInsPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNo());
//					/* kys 소스 정리
//					dtlInsPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNoTp());
//					dtlInsPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNoChk());
//					*/
//					dtlInsPs.setString(i++, trs_trsp_usa_do_dtl_vo.getEqNo());
//					dtlInsPs.setString(i++, trs_trsp_usa_do_dtl_vo.getDoRmk());
//					dtlInsPs.setString(i++, (String) hashParam.get("FORM_USR_OFC_CD"));
//					dtlInsPs.setString(i++, (String) hashParam.get("FORM_CRE_USR_ID"));
//					dtlInsPs.setString(i++, (String) hashParam.get("FORM_USR_OFC_CD"));
//					dtlInsPs.setString(i++, (String) hashParam.get("FORM_CRE_USR_ID"));
//					dtlInsPs.setString(i++, (String) hashParam.get("FORM_USR_OFC_CD"));
//
////					 Loggable Statement 사용에 의해 추가 
//					if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//						log.info("\n SQL :" + ((LoggableStatement)dtlInsPs).getQueryString());
//					} else {
//						log.info("\n SQL :" + dtlInsQueryStr );
//					}
//
//					dtlInsCnt = 0;
//					dtlInsCnt = dtlInsPs.executeUpdate();
//					dtlInsPs.clearWarnings();
//					dtlInsPs.clearParameters();
//				}
//			}		
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(dtlUpdPs);
//			closeStatement(dtlInsPs);
//			closeStatement(headerPs);
//			closeConnection(con);
//		}
//	}

//	/**
//	 * USADeliveryOrderManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
//	 * 
//	 * @param event
//	 * @throws DAOException
//	 */
//	public void modifyUSADeliveryOrderManage(EsdTrs0083Event event) throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement hdrUpdPs = null;
//		PreparedStatement dtlUpdPs = null;
//
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		int hdrUpdCnt = 0;
//		int dtlUpdCnt = 0;
//
//		HashMap hashParam = event.getHashParam();
//		
//		ArrayList headerList = (ArrayList) event.getTRS_TRSP_USA_DO_HDRS();
//		ArrayList detailList = (ArrayList) event.getTRS_TRSP_USA_DO_DTLS();
//		
//		TrsTrspUsaDoHdrVO trs_trsp_usa_do_hdr_vo = null;
//		TrsTrspUsaDoDtlVO trs_trsp_usa_do_dtl_vo = null;
//		
//		StringBuffer hdrUpdQueryStr = new StringBuffer();
//		StringBuffer dtlUpdQueryStr = new StringBuffer();
//		
//		hdrUpdQueryStr.append(" UPDATE TRS_TRSP_USA_DO_HDR SET                  \n");
//		hdrUpdQueryStr.append("     FCTRY_NM            = ?                     \n");
//		hdrUpdQueryStr.append(" ,   ACT_CUST_N1ST_ADDR  = ?                     \n");
//		hdrUpdQueryStr.append(" ,   ACT_CUST_N2ND_ADDR  = ?                     \n");
//		hdrUpdQueryStr.append(" ,   ACT_CUST_CTY_NM     = ?                     \n");
//		hdrUpdQueryStr.append(" ,   ACT_CUST_STE_NM     = ?                     \n");
//		hdrUpdQueryStr.append(" ,   ACT_CUST_ZIP_CD     = ?                     \n");
//		hdrUpdQueryStr.append(" ,   CNTC_PSON_NM        = ?                     \n");
//		hdrUpdQueryStr.append(" ,   CNTC_PSON_PHN_NO    = ?                     \n");
//		hdrUpdQueryStr.append(" ,   CNTC_PSON_FAX_NO    = ?                     \n");
//		hdrUpdQueryStr.append(" ,   UPD_USR_ID          = ?                     \n");
//		hdrUpdQueryStr.append(" ,   UPD_DT =GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(?)\n");
//		hdrUpdQueryStr.append(" ,   USR_EML			    = ?                     \n");
//		hdrUpdQueryStr.append(" ,   USR_PHN_NO          = ?                     \n");
//		hdrUpdQueryStr.append(" WHERE                                           \n");
//		hdrUpdQueryStr.append("     BL_NO               = ?                     \n");
//		hdrUpdQueryStr.append(" AND BL_NO_TP            = ?                     \n");
//		hdrUpdQueryStr.append(" AND BL_NO_CHK           = ?                     \n");
//		
//		dtlUpdQueryStr.append(" UPDATE TRS_TRSP_USA_DO_DTL SET                  \n");
//		dtlUpdQueryStr.append("     DO_RMK              = ?                     \n");
//		dtlUpdQueryStr.append(" ,   UPD_USR_ID          = ?                     \n");
//		dtlUpdQueryStr.append(" ,   UPD_DT =GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(?)\n");
//		dtlUpdQueryStr.append(" WHERE                                           \n");
//		dtlUpdQueryStr.append("     BL_NO               = ?                     \n");
//		dtlUpdQueryStr.append(" AND BL_NO_TP            = ?                     \n");
//		dtlUpdQueryStr.append(" AND BL_NO_CHK           = ?                     \n");
//		dtlUpdQueryStr.append(" AND EQ_NO               = ?                     \n");
//		
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				hdrUpdPs = new LoggableStatement(con, hdrUpdQueryStr.toString());
//				dtlUpdPs = new LoggableStatement(con, dtlUpdQueryStr.toString());
//			} else {
//				hdrUpdPs = con.prepareStatement(hdrUpdQueryStr.toString());
//				dtlUpdPs = con.prepareStatement(dtlUpdQueryStr.toString());
//			}
//			
//			for(int k=0;headerList!=null && k<headerList.size(); k++){
//				
//				trs_trsp_usa_do_hdr_vo = (TrsTrspUsaDoHdrVO) headerList.get(k);
//				
//				i = 1;
//				
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getFctryNm());
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getActCustN1stAddr());
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getActCustN2ndAddr());
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getActCustCtyNm());
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getActCustSteNm());
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getActCustZipCd());
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getCntcPsonNm());
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getCntcPsonPhnNo());
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getCntcPsonFaxNo());
//				hdrUpdPs.setString(i++, (String) hashParam.get("FORM_CRE_USR_ID"));
//				hdrUpdPs.setString(i++, (String) hashParam.get("FORM_USR_OFC_CD"));
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getUsrEml());
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getUsrPhnNo());
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getBlNo());
//				/* kys 소스 정리
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getBlNoTp());
//				hdrUpdPs.setString(i++, trs_trsp_usa_do_hdr_vo.getBlNoChk());
//				*/
//				
////				 Loggable Statement 사용에 의해 추가 
//				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//					log.info("\n SQL :" + ((LoggableStatement)hdrUpdPs).getQueryString());
//				} else {
//					log.info("\n SQL :" + hdrUpdQueryStr );
//				}
//
//				hdrUpdCnt += hdrUpdPs.executeUpdate();
//				hdrUpdPs.clearWarnings();
//				hdrUpdPs.clearParameters();
//			}
//			
//			for(int k=0;detailList!=null && k<detailList.size(); k++){
//				
//				trs_trsp_usa_do_dtl_vo = (TrsTrspUsaDoDtlVO) detailList.get(k);
//			
//				i = 1;
//				dtlUpdPs.setString(i++, trs_trsp_usa_do_dtl_vo.getDoRmk());
//				dtlUpdPs.setString(i++, (String) hashParam.get("FORM_CRE_USR_ID"));
//				dtlUpdPs.setString(i++, (String) hashParam.get("FORM_USR_OFC_CD"));
//				dtlUpdPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNo());
//				/* kys 소스 정리 
//				dtlUpdPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNoTp());
//				dtlUpdPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNoChk());
//				*/
//				dtlUpdPs.setString(i++, trs_trsp_usa_do_dtl_vo.getEqNo());
//				
////				 Loggable Statement 사용에 의해 추가 
//				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//					log.info("\n SQL :" + ((LoggableStatement)dtlUpdPs).getQueryString());
//				} else {
//					log.info("\n SQL :" + dtlUpdQueryStr );
//				}
//
//				dtlUpdCnt += dtlUpdPs.executeUpdate();
//				dtlUpdPs.clearWarnings();
//				dtlUpdPs.clearParameters();
//			}
//			
//			if (hdrUpdCnt + dtlUpdCnt < 1) {
//				// 데이터 반영에 실패하였습니다.
//				throw new DAOException(new ErrorHandler("COM11001").getMessage());
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(dtlUpdPs);
//			closeStatement(hdrUpdPs);
//			closeConnection(con);
//		}
//	}

//	/**
//	 * USADeliveryOrderManage의 데이타 모델을 DB에서 삭제한다.<br>
//	 * 
//	 * @param event
//	 * @throws DAOException
//	 */
//	public void removeUSADeliveryOrderManage(EsdTrs0083Event event) throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement hdrDelPs = null;
//		PreparedStatement dtlDelPs = null;
//		PreparedStatement dtlAllDelPs = null;
// 
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		int hdrDelCnt = 0;
//		int dtlDelCnt = 0;
//		int dtlDelAllCnt = 0;
//		
////		HashMap hashParam = event.getHashParam();
//		
//		ArrayList headerList = (ArrayList) event.getTRS_TRSP_USA_DO_HDRS();
//		ArrayList detailList = (ArrayList) event.getTRS_TRSP_USA_DO_DTLS();
//		
//		TrsTrspUsaDoHdrVO trs_trsp_usa_do_hdr_vo = null;
//		TrsTrspUsaDoDtlVO trs_trsp_usa_do_dtl_vo = null;
//		
//		StringBuffer hdrDelQueryStr = new StringBuffer();
//		StringBuffer dtlAllDelQuery = new StringBuffer();
//		StringBuffer dtlDelQueryStr = new StringBuffer();
//		
//		hdrDelQueryStr.append(" DELETE FROM TRS_TRSP_USA_DO_HDR                  \n");
//		hdrDelQueryStr.append(" WHERE                                           \n");
//		hdrDelQueryStr.append("     BL_NO               = ?                     \n");
//		hdrDelQueryStr.append(" AND BL_NO_TP            = ?                     \n");
//		hdrDelQueryStr.append(" AND BL_NO_CHK           = ?                     \n");
//		
//		dtlAllDelQuery.append(" DELETE FROM TRS_TRSP_USA_DO_DTL                  \n");
//		dtlAllDelQuery.append(" WHERE                                           \n");
//		dtlAllDelQuery.append("     BL_NO               = ?                     \n");
//		dtlAllDelQuery.append(" AND BL_NO_TP            = ?                     \n");
//		dtlAllDelQuery.append(" AND BL_NO_CHK           = ?                     \n");
//		
//		dtlDelQueryStr.append(" DELETE FROM TRS_TRSP_USA_DO_DTL                  \n");
//		dtlDelQueryStr.append(" WHERE                                           \n");
//		dtlDelQueryStr.append("     BL_NO               = ?                     \n");
//		dtlDelQueryStr.append(" AND BL_NO_TP            = ?                     \n");
//		dtlDelQueryStr.append(" AND BL_NO_CHK           = ?                     \n");
//		dtlDelQueryStr.append(" AND EQ_NO               = ?                     \n");
//		
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				hdrDelPs = new LoggableStatement(con, hdrDelQueryStr.toString());
//				dtlDelPs = new LoggableStatement(con, dtlDelQueryStr.toString());
//				dtlAllDelPs = new LoggableStatement(con, dtlAllDelQuery.toString());
//			} else {
//				hdrDelPs = con.prepareStatement(hdrDelQueryStr.toString());
//				dtlDelPs = con.prepareStatement(dtlDelQueryStr.toString());
//				dtlAllDelPs = con.prepareStatement(dtlAllDelQuery.toString());
//			}
//			
//			for(int k=0;detailList!=null && k<detailList.size(); k++){
//
//				trs_trsp_usa_do_dtl_vo = (TrsTrspUsaDoDtlVO) detailList.get(k);
//				
//				i = 1;
//				dtlDelPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNo());
//				/* kys 소스 정리 
//				dtlDelPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNoTp());
//				dtlDelPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNoChk());
//				*/
//				dtlDelPs.setString(i++, trs_trsp_usa_do_dtl_vo.getEqNo());
//				
////				 Loggable Statement 사용에 의해 추가 
//				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//					log.info("\n SQL :" + ((LoggableStatement)dtlDelPs).getQueryString());
//				} else {
//					log.info("\n SQL :" + dtlDelQueryStr.toString() );
//				}
//				
//				dtlDelCnt += dtlDelPs.executeUpdate();
//				dtlDelPs.clearWarnings();
//				dtlDelPs.clearParameters();
//			}
//			
//			for(int k=0;headerList!=null && k<headerList.size(); k++){
//				
//				trs_trsp_usa_do_hdr_vo = (TrsTrspUsaDoHdrVO) headerList.get(k);
//				
//				i = 1;
//				dtlAllDelPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNo());
//				/* kys 소스 정리
//				dtlAllDelPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNoTp());
//				dtlAllDelPs.setString(i++, trs_trsp_usa_do_dtl_vo.getBlNoChk());
//				*/
//				
//				// Loggable Statement 사용에 의해 추가 
//				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//					log.info("\n SQL :" + ((LoggableStatement)dtlAllDelPs).getQueryString());
//				} else {
//					log.info("\n SQL :" + dtlAllDelQuery.toString() );
//				}
//				
//				dtlDelAllCnt = dtlAllDelPs.executeUpdate();
//				dtlAllDelPs.clearWarnings();
//				dtlAllDelPs.clearParameters();
//				
//				i = 1;
//				hdrDelPs.setString(i++, trs_trsp_usa_do_hdr_vo.getBlNo());
//				/* kys 소스 정리
//				hdrDelPs.setString(i++, trs_trsp_usa_do_hdr_vo.getBlNoTp());
//				hdrDelPs.setString(i++, trs_trsp_usa_do_hdr_vo.getBlNoChk());
//				*/
//				
////				 Loggable Statement 사용에 의해 추가 
//				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//					log.info("\n SQL :" + ((LoggableStatement)hdrDelPs).getQueryString());
//				} else {
//					log.info("\n SQL :" + hdrDelQueryStr.toString() );
//				}
//				
//				hdrDelCnt += hdrDelPs.executeUpdate();
//				hdrDelPs.clearWarnings();
//				hdrDelPs.clearParameters();
//			}
//			
//			if (dtlDelCnt + dtlDelAllCnt + hdrDelCnt < 1) {
//				// 데이터 삭제에 실패하였습니다.
//				throw new DAOException(new ErrorHandler("COM11001").getMessage());
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(dtlAllDelPs);
//			closeStatement(dtlDelPs);
//			closeStatement(hdrDelPs);
//			closeConnection(con);
//		}
//	}

	/**
	 * USADeliveryOrderManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param models 여러 데이타 모델
	 * @see ESD_TRS_083Event
	 * @throws DAOException
	 */
	/**
	 * @param event
	 * @throws DAOException
	 */
	public void multiUSADeliveryOrderManage(EsdTrs0083Event event) throws DAOException {
		
		log.debug("\n\n:::::::::: [multiUSADeliveryOrderManage] :::::::::::: \n\n");

		Map<String, Object> param 	= new HashMap<String, Object>();
		
		TrsTrspUsaDoHdrVO[] hdrModels = event.getTrsTrspUsaDoHdrVOs();
		TrsTrspUsaDoDtlVO[] dtlModels = event.getTrsTrspUsaDoDtlVOs();
//		UsaDeliveryOrderManageVO usDoVO = event.getUsaDeliveryOrderManageVO();
		
		int updCnt = 0;
		
		try {
			//TRS_TRSP_USA_DO_HDR 테이블에 자료 입력
			
			TrsTrspUsaDoHdrVO hdrModel = null;
			
			for(int i=0; hdrModels!=null && i<hdrModels.length; i++) {
				
				hdrModel = (TrsTrspUsaDoHdrVO)hdrModels[i];

				if (hdrModel.getIbflag().length() > 0) {
					
					param.put("bl_no"				, hdrModel.getBlNo());
					param.put("fctry_nm"			, hdrModel.getFctryNm());
					param.put("act_cust_n1st_addr"	, hdrModel.getActCustN1stAddr());
					param.put("act_cust_zip_cd"		, hdrModel.getActCustZipCd());
					param.put("cntc_pson_nm"		, hdrModel.getCntcPsonNm());
					param.put("cntc_pson_phn_no"	, hdrModel.getCntcPsonPhnNo());
					param.put("cntc_pson_fax_no"	, hdrModel.getCntcPsonFaxNo());
					param.put("cre_usr_id"			, event.getForm_cre_usr_id()); //usDoVO.getFormCreUsrId());
					param.put("upd_usr_id"			, event.getForm_cre_usr_id()); //usDoVO.getFormCreUsrId());
					param.put("usr_ofc_cd"			, event.getForm_usr_ofc_cd()); //usDoVO.getFormUsrOfcCd());
					
					/* TRS_TRSP_USA_DO_HDR */
					updCnt = new SQLExecuter("DEFAULT").executeUpdate(new USADeliveryOrderManageDBDAOMultiUSADeliveryOrderHdrUSQL(), param, param);
					if(updCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert/update SQL");
					}			
				}
			}
			
			/* TRS_TRSP_USA_DO_DTL */
			
			TrsTrspUsaDoDtlVO dtlModel = null;
			
			for(int i=0; dtlModels!=null && i<dtlModels.length; i++) {
				
				dtlModel = (TrsTrspUsaDoDtlVO)dtlModels[i];

				if (dtlModel.getIbflag().length() > 0) {
					
					param.put("bl_no"				, dtlModel.getBlNo());
					param.put("eq_no"				, dtlModel.getEqNo());
					param.put("do_rmk"				, dtlModel.getDoRmk());
					param.put("cre_usr_id"			, event.getForm_cre_usr_id()); //usDoVO.getFormCreUsrId());
					param.put("upd_usr_id"			, event.getForm_cre_usr_id()); //usDoVO.getFormCreUsrId());
					param.put("usr_ofc_cd"			, event.getForm_usr_ofc_cd()); //usDoVO.getFormUsrOfcCd());
					
					/* TRS_TRSP_USA_DO_HDR */
					updCnt = new SQLExecuter("DEFAULT").executeUpdate(new USADeliveryOrderManageDBDAOMultiUSADeliveryOrderDtlUSQL(), param, param);
					if(updCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert/update SQL");
					}			
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}		
}