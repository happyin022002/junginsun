/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BRKGCalcDBDAO.java
*@FileTitle : Brokerage Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-12-22 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtcalculation.brkgcalc.integration;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * eNIS-AGT Batch에 대한 DB 처리를 담당<br>
 * - eNIS-AGT Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang GyeongNam
 * @see AGTCalcBCImpl 참조
 * @since J2EE 1.4
 */
public class BRKGCalcDBDAO extends DBDAOSupport {


	
	/**
	 * Booking 정보를 조회한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchBookingInfoforComm(HashMap<String, Serializable> bkgMap) throws DAOException {

		log.debug("\n\n searchBookingInfoforComm 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		
		// DB ResultSet
		ResultSet rs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		String bkg_no				= "";
		String bl_no				= "";
		String covered_check		= "";
		String bkg_sts_cd			= "";
		ResultSetMetaData mataData	= null;
		String columnName			= "";
		int columnCount				= 0;

		StringBuffer queryBkg = new StringBuffer();
		
		// Booking 정보 조회 쿼리
		queryBkg.append("    SELECT \n");
		queryBkg.append("  DISTINCT BKG.POR_CD, \n");
		queryBkg.append("           POR.RGN_CD                                      AS POR_RGN_CD, \n");
		queryBkg.append("           POR.CNT_CD                                      AS POR_CNT_CD, \n");
		queryBkg.append("           POR.STE_CD                                      AS POR_STE_CD, \n");
		queryBkg.append("           POR.SCONTI_CD                                   AS POR_SCONTI_CD, \n");
		queryBkg.append("           POR.CONTI_CD                                    AS POR_CONTI_CD, \n");
		queryBkg.append("      CASE \n");
		queryBkg.append("      WHEN BKG.BKG_OFC_CD = 'BSLBA' \n");
		queryBkg.append("      THEN 'BSLBA' \n");
		queryBkg.append("      WHEN POL.FINC_CTRL_OFC_CD = 'GLWBA' \n");
		queryBkg.append("      THEN 'GLWBA' \n");
		queryBkg.append("      ELSE POR.FINC_CTRL_OFC_CD \n");
		queryBkg.append("       END                                                 AS POR_FINC_CTRL_OFC_CD, \n");
		queryBkg.append("      CASE \n");
		queryBkg.append("      WHEN BKG.BKG_OFC_CD = 'BSLBA' \n");
		queryBkg.append("      THEN OBK.AR_OFC_CD \n");
		queryBkg.append("      WHEN POL.FINC_CTRL_OFC_CD = 'GLWBA' \n");
		queryBkg.append("      THEN OOL.AR_OFC_CD \n");
		queryBkg.append("      ELSE OOR.AR_OFC_CD \n");
		queryBkg.append("       END                                                 AS POR_AR_OFC_CD, \n");
		queryBkg.append("      CASE \n");
		queryBkg.append("      WHEN BKG.BKG_OFC_CD = 'BSLBA' \n");
		queryBkg.append("      THEN OBK.AP_OFC_CD \n");
		queryBkg.append("      WHEN POL.FINC_CTRL_OFC_CD = 'GLWBA' \n");
		queryBkg.append("      THEN OOL.AP_OFC_CD \n");
		queryBkg.append("      ELSE OOR.AP_OFC_CD \n");
		queryBkg.append("       END                                                 AS POR_AP_OFC_CD, \n");
		queryBkg.append("           BKG.POL_CD, \n");
		queryBkg.append("           POL.RGN_CD                                      AS POL_RGN_CD, \n");
		queryBkg.append("           POL.CNT_CD                                      AS POL_CNT_CD, \n");
		queryBkg.append("           POL.STE_CD                                      AS POL_STE_CD, \n");
		queryBkg.append("           POL.SCONTI_CD                                   AS POL_SCONTI_CD, \n");
		queryBkg.append("           POL.CONTI_CD                                    AS POL_CONTI_CD, \n");
		queryBkg.append("           POL.FINC_CTRL_OFC_CD                            AS POL_FINC_CTRL_OFC_CD, \n");
		queryBkg.append("           OOL.AR_OFC_CD                                   AS POL_AR_OFC_CD, \n");
		queryBkg.append("           OOL.AP_OFC_CD                                   AS POL_AP_OFC_CD, \n");
		queryBkg.append("           BKG.POD_CD, \n");
		queryBkg.append("           POD.RGN_CD                                      AS POD_RGN_CD, \n");
		queryBkg.append("           POD.CNT_CD                                      AS POD_CNT_CD, \n");
		queryBkg.append("           POD.STE_CD                                      AS POD_STE_CD, \n");
		queryBkg.append("           POD.SCONTI_CD                                   AS POD_SCONTI_CD, \n");
		queryBkg.append("           POD.CONTI_CD                                    AS POD_CONTI_CD, \n");
		queryBkg.append("           POD.FINC_CTRL_OFC_CD                            AS POD_FINC_CTRL_OFC_CD, \n");
		queryBkg.append("           OOD.AR_OFC_CD                                   AS POD_AR_OFC_CD, \n");
		queryBkg.append("           OOD.AP_OFC_CD                                   AS POD_AP_OFC_CD, \n");
		queryBkg.append("           BKG.DEL_CD, \n");
		queryBkg.append("           DEL.RGN_CD                                      AS DEL_RGN_CD, \n");
		queryBkg.append("           DEL.CNT_CD                                      AS DEL_CNT_CD, \n");
		queryBkg.append("           DEL.STE_CD                                      AS DEL_STE_CD, \n");
		queryBkg.append("           DEL.SCONTI_CD                                   AS DEL_SCONTI_CD, \n");
		queryBkg.append("           DEL.CONTI_CD                                    AS DEL_CONTI_CD, \n");
		queryBkg.append("      CASE \n");
		queryBkg.append("      WHEN BRT.CLT_OFC_CD = 'BUDBB' \n");
		queryBkg.append("       AND POD.LOC_CD \n");
		queryBkg.append("        IN \n");
		queryBkg.append("         ( \n");
		queryBkg.append("           'DEHAM', 'NLRTM', 'SIKOP' \n");
		queryBkg.append("         ) \n");
		queryBkg.append("      THEN 'BUDBB' \n");
		queryBkg.append("      WHEN POD.FINC_CTRL_OFC_CD = 'GLWBA' \n");
		queryBkg.append("      THEN 'GLWBA' \n");
		queryBkg.append("      WHEN POD.FINC_CTRL_OFC_CD = 'BUDBB' \n");
		queryBkg.append("      THEN 'BUDBB' \n");
		queryBkg.append("      ELSE DEL.FINC_CTRL_OFC_CD \n");
		queryBkg.append("       END                                                 AS DEL_FINC_CTRL_OFC_CD, \n");
		queryBkg.append("      CASE \n");
		queryBkg.append("      WHEN ORT.OFC_CD = 'BUDBB' \n");
		queryBkg.append("       AND POD.LOC_CD \n");
		queryBkg.append("        IN \n");
		queryBkg.append("         ( \n");
		queryBkg.append("           'DEHAM', 'NLRTM', 'SIKOP' \n");
		queryBkg.append("         ) \n");
		queryBkg.append("      THEN ORT.AR_OFC_CD \n");
		queryBkg.append("      WHEN POD.FINC_CTRL_OFC_CD = 'GLWBA' \n");
		queryBkg.append("      THEN OOD.AR_OFC_CD \n");
		queryBkg.append("      WHEN POD.FINC_CTRL_OFC_CD = 'BUDBB' \n");
		queryBkg.append("      THEN OOD.AR_OFC_CD \n");
		queryBkg.append("      ELSE OEL.AR_OFC_CD \n");
		queryBkg.append("       END                                                 AS DEL_AR_OFC_CD, \n");
		queryBkg.append("      CASE \n");
		queryBkg.append("      WHEN ORT.OFC_CD = 'BUDBB' \n");
		queryBkg.append("       AND POD.LOC_CD \n");
		queryBkg.append("        IN \n");
		queryBkg.append("         ( \n");
		queryBkg.append("           'DEHAM', 'NLRTM', 'SIKOP' \n");
		queryBkg.append("         ) \n");
		queryBkg.append("      THEN ORT.AP_OFC_CD \n");
		queryBkg.append("      WHEN POD.FINC_CTRL_OFC_CD = 'GLWBA' \n");
		queryBkg.append("      THEN OOD.AP_OFC_CD \n");
		queryBkg.append("      WHEN POD.FINC_CTRL_OFC_CD = 'BUDBB' \n");
		queryBkg.append("      THEN OOD.AP_OFC_CD \n");
		queryBkg.append("      ELSE OEL.AP_OFC_CD \n");
		queryBkg.append("       END                                                 AS DEL_AP_OFC_CD, \n");
		queryBkg.append("           BKG.RCV_TERM_CD, \n");
		queryBkg.append("           BKG.DE_TERM_CD, \n");
		queryBkg.append("           BKG.BKG_OFC_CD, \n");
		queryBkg.append("           BKG.BKG_OFC_CD                                  AS BKG_FINC_CTRL_OFC_CD, \n");
		queryBkg.append("           OBK.AR_OFC_CD                                   AS BKG_AR_OFC_CD, \n");
		queryBkg.append("           OBK.LOC_CD                                      AS BKG_OFC_LOC_CD, \n");
		queryBkg.append("           BKG.OB_SLS_OFC_CD                               AS BKG_SLS_OFC_CD, \n");
		queryBkg.append("           BKG.BKG_STS_CD, \n");
		queryBkg.append("      CASE \n");
		queryBkg.append("      WHEN BKG.BKG_CGO_TP_CD = 'B' \n");
		queryBkg.append("        OR BKG.BKG_CGO_TP_CD = 'R' \n");
		queryBkg.append("        OR BKG.BKG_CGO_TP_CD = 'F' \n");
		queryBkg.append("      THEN 'F' \n");
		queryBkg.append("      ELSE 'M' \n");
		queryBkg.append("       END                                                 AS BKG_CGO_TP_CD, \n");
		queryBkg.append("           BKG.CMDT_CD, \n");
		queryBkg.append("           BKG.REP_CMDT_CD, \n");
		queryBkg.append("           NVL (BKG.BL_NO, ' ')                            AS BL_NO, \n");
		queryBkg.append("           NVL (BKG.DBL_BKG_FLG, 'N')                      AS DBL_BKG_FLG, \n");
		queryBkg.append("           NVL (BKG.SOC_FLG, 'N')                          AS BKG_SHPR_OWNR_FLG, \n");
		queryBkg.append("           NVL (TO_CHAR (BKG.BKG_CRE_DT, 'YYYYMMDD'), ' ') AS BKG_CRE_DT, \n");
		queryBkg.append("      CASE \n");
		queryBkg.append("      WHEN NVL (BKG.CHN_AGN_CD, ' ') = ' ' \n");
		queryBkg.append("      THEN ' ' \n");
		queryBkg.append("      ELSE SUBSTR (BKG.BKG_OFC_CD, 1, 3) || BKG.CHN_AGN_CD \n");
		queryBkg.append("       END                                                 AS BKG_OFC_AGN_CD, \n");
		queryBkg.append("           NVL (BKG.DCGO_FLG, 'N')                         AS SPCL_DG_CGO_FLG, \n");
		queryBkg.append("           NVL (BKG.RC_FLG, 'N')                           AS SPCL_RC_FLG, \n");
		queryBkg.append("           NVL (BKG.AWK_CGO_FLG, 'N')                      AS SPCL_AWK_CGO_FLG, \n");
		queryBkg.append("           NVL (BKG.BB_CGO_FLG, 'N')                       AS SPCL_BB_CGO_FLG, \n");
		queryBkg.append("           NVL (BKG.PRE_RLY_PORT_CD, '*')                  AS PRE_RLY_PORT_CD, \n");
		queryBkg.append("           NVL (BKG.PST_RLY_PORT_CD, '*')                  AS PST_RLY_PORT_CD, \n");
		queryBkg.append("           NVL (BRT.CLT_OFC_CD, '*')                       AS BSL_DEL_OFC_CD, \n");
		queryBkg.append("      CASE \n");
		queryBkg.append("      WHEN BRT.CLT_OFC_CD = 'BSLBA' \n");
		queryBkg.append("      THEN ORT.AR_OFC_CD \n");
		queryBkg.append("      ELSE BRT.CLT_OFC_CD \n");
		queryBkg.append("       END                                                 AS BSL_DEL_AR_OFC_CD, \n");
		queryBkg.append("      CASE \n");
		queryBkg.append("      WHEN BRT.CLT_OFC_CD = 'BSLBA' \n");
		queryBkg.append("      THEN ORT.AP_OFC_CD \n");
		queryBkg.append("      ELSE BRT.CLT_OFC_CD \n");
		queryBkg.append("       END                                                 AS BSL_DEL_AP_OFC_CD, \n");
		queryBkg.append("           BKG.CTRT_OFC_CD, \n");
		queryBkg.append("           BKG.SC_NO, \n");
		queryBkg.append("           BKG.RFA_NO, \n");
		queryBkg.append("           BKG.SVC_SCP_CD                                  AS BKG_SVC_SCP_CD, \n");
		queryBkg.append("      CASE \n");
		queryBkg.append("      WHEN BKG.SVC_SCP_CD IS NULL \n");
		queryBkg.append("      THEN '1' \n");
		queryBkg.append("      ELSE '0' \n");
		queryBkg.append("       END                                                 AS SVC_SCP_CHECK, \n");
		queryBkg.append("         ( \n");
		queryBkg.append("               SELECT \n");
		queryBkg.append("                      NVL (BBL.BL_CVRD_TP_CD, 'N') \n");
		queryBkg.append("                 FROM BKG_BL_DOC BBL \n");
		queryBkg.append("                WHERE BBL.BKG_NO = BKG.BKG_NO \n");
		queryBkg.append("                  AND ROWNUM     = 1 \n");
		queryBkg.append("         )  AS COVERED_CHECK \n");
		queryBkg.append("      FROM BKG_BOOKING      BKG, \n");
		queryBkg.append("           BKG_RATE         BRT, \n");
		queryBkg.append("           MDM_LOCATION     POR, \n");
		queryBkg.append("           MDM_LOCATION     POL, \n");
		queryBkg.append("           MDM_LOCATION     POD, \n");
		queryBkg.append("           MDM_LOCATION     DEL, \n");
		queryBkg.append("           MDM_ORGANIZATION OBK, \n");
		queryBkg.append("           MDM_ORGANIZATION OOR, \n");
		queryBkg.append("           MDM_ORGANIZATION OOL, \n");
		queryBkg.append("           MDM_ORGANIZATION OOD, \n");
		queryBkg.append("           MDM_ORGANIZATION OEL, \n");
		queryBkg.append("           MDM_ORGANIZATION ORT \n");
		queryBkg.append("     WHERE BKG.POR_CD           = POR.LOC_CD \n");
		queryBkg.append("       AND BKG.POL_CD           = POL.LOC_CD \n");
		queryBkg.append("       AND BKG.POD_CD           = POD.LOC_CD \n");
		queryBkg.append("       AND BKG.DEL_CD           = DEL.LOC_CD \n");
		queryBkg.append("       AND BKG.BKG_OFC_CD       = OBK.OFC_CD (+) \n");
		queryBkg.append("       AND POR.FINC_CTRL_OFC_CD = OOR.OFC_CD (+) \n");
		queryBkg.append("       AND POL.FINC_CTRL_OFC_CD = OOL.OFC_CD (+) \n");
		queryBkg.append("       AND POD.FINC_CTRL_OFC_CD = OOD.OFC_CD (+) \n");
		queryBkg.append("       AND DEL.FINC_CTRL_OFC_CD = OEL.OFC_CD (+) \n");
		queryBkg.append("       AND BKG.BKG_NO           = BRT.BKG_NO (+) \n");
		queryBkg.append("       AND BRT.CLT_OFC_CD       = ORT.OFC_CD (+) \n");
		queryBkg.append("       AND BKG.BKG_NO           = ? \n");


		
		try {
			
			bkg_no = (String)bkgMap.get("BKG_NO");
			
			con = getConnection();
			
			// Booking 정보를 구한다.----------start----------
			ps = new LoggableStatement(con, queryBkg.toString());
			ps.setString(i++, bkg_no);
			log.debug("\n BOOKING : \n" + ((LoggableStatement)ps).getQueryString()); 
			rs = ps.executeQuery();

			if (rs.next())
			{
				mataData = rs.getMetaData();
				columnCount = mataData.getColumnCount(); 
				
				for (int j = 1; j <= columnCount; j++)
				{
					columnName = mataData.getColumnName(j);
					bkgMap.put(columnName, rs.getString(columnName)); // 결과를 HashMap에 담는다.
				}
			}
			else
			{
				// Booking 정보가 존재하지 않을 경우 Error를 agt_comm_bkg_info에 저장하고 다음 Booking으로 넘어간다.
				bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00054").getUserMessage()); //Booking Master Information does not exist!
				createBKGMSTErrorMSG( con, bkgMap );
				return bkgMap;
			}
			// Booking 정보를 구한다.----------end----------
			bl_no			= (String)bkgMap.get("BL_NO");			//Bill of Landing Number 를 읽어온다.
			covered_check	= (String)bkgMap.get("COVERED_CHECK");	// BL Covered Type Code를 읽어온다.
			bkg_sts_cd		= (String)bkgMap.get("BKG_STS_CD");

			if ("X".equals(bkg_sts_cd))
			{	// Canceled BKG인 경우
				bkgMap.put("COMM_PROC_RSLT_RSN", "Cancelled Booking, C/Aed Booking Info! or Changed Agent Agreements!");
				createBKGMaster( con, bkgMap );
				createZeroSumComm( con, bkgMap );
			}
			else  if ("B".equals(covered_check))
			{	// Co-Biz BL인 경우
				bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00082", new String[]{bl_no}).getUserMessage());	// BL No[$s] is CO-BIZ BL!
				createBKGMaster( con, bkgMap );
				createZeroSumComm( con, bkgMap );
			}
			else if ("C".equals(covered_check))
			{	// Covered BL인 경우
				bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00083", new String[]{bl_no}).getUserMessage());	// BL No[$s] is Covered BL!
				createBKGMaster( con, bkgMap );
				createZeroSumComm( con, bkgMap );
			}
			else
			{
				// CUSTOMER 정보를 구해온다.
				bkgMap = getCustomer( con, bkgMap);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (DAOException de)
		{
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		}
		catch (Exception e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		
		return bkgMap;
	}
	
	/**
	 * S/A Date를 구한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchAGTSADate(HashMap bkgMap) throws DAOException
	{

		log.debug("\n\n searchAGTSADate 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		PreparedStatement ps02 = null;
		PreparedStatement ps03 = null;
		// DB ResultSet
		ResultSet rs = null;
		ResultSet rs02 = null;
		ResultSet rs03 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		/*
		 * SADate를 담고 있는 ArrayList size를 9로 한다.
		 * Index 0~3 : Outbound T/S Date (SEQ 순서대로)
		 * Index 4 : Trunk S/A Date
		 * Index 5~8 : Inbound T/S Date (SEQ 순서대로)
		 */
		ArrayList saDateList = new ArrayList();
		for(int k=0; k<9; k++) {
			HashMap newMap = new HashMap();
			saDateList.add(k, newMap);
		}
		
		ResultSetMetaData mataData = null;
		String columnName = "";
		int columnCount = 0;

		String bkg_no = "";
		
		String vps_etd_dt = "";
		String vps_eta_dt = "";
		
		StringBuffer suQueryStr01 = new StringBuffer();
		StringBuffer suQueryStr02 = new StringBuffer();
		StringBuffer tQueryStr = new StringBuffer();

		// SU 의 Outbound T/S를 구한다.
		suQueryStr01.append("SELECT DECODE(a.vsl_seq, 0, (SELECT nvl(max(c.vsl_seq),0) + 1 FROM  bkg_vvd c WHERE bkg_no = a.bkg_no AND vsl_pre_pst_cd = 'S'), a.vsl_seq) vsl_seq,    \n");
		suQueryStr01.append("       a.vsl_pre_pst_cd vsl_pre_pst_cd, NVL (a.vsl_cd, '*') vsl_cd,    \n");
		suQueryStr01.append("       NVL (a.skd_voy_no, '*') skd_voy_no, NVL (a.skd_dir_cd, '*') skd_dir_cd,   \n");
		suQueryStr01.append("       NVL (e.rlane_dir_cd, a.skd_dir_cd) rlane_dir_cd,   \n");
		suQueryStr01.append("       NVL (a.slan_cd, '*') slan_cd, NVL (a.pol_cd, '*') vsl_pol_cd,   \n");
		suQueryStr01.append("       NVL (a.pod_cd, '*') vsl_pod_cd, NVL(b.conti_cd, '*') os_conti_cd,    \n");
		suQueryStr01.append("       DECODE(a.vsl_pre_pst_cd, 'U', agt_ofc_new_old_fnc(bb.finc_ctrl_ofc_cd), agt_ofc_new_old_fnc(b.finc_ctrl_ofc_cd)) finc_ctrl_ofc_cd,    \n");
		suQueryStr01.append("       DECODE(a.vsl_pre_pst_cd, 'U', gg.ar_ofc_cd, g.ar_ofc_cd) ar_ofc_cd,   \n");
		suQueryStr01.append("       DECODE (c.vsl_svc_tp_cd, 'O', 1, 0) pre_feeder_check,   \n");
		suQueryStr01.append("       DECODE (d.vsl_svc_tp_cd, 'O', 1, 0) post_feeder_check   \n");
		suQueryStr01.append("  FROM bkg_vvd a,   \n");
		suQueryStr01.append("       mdm_location b,   \n");
		suQueryStr01.append("       mdm_location bb,  \n"); 
		suQueryStr01.append("       mdm_vsl_svc_lane c,  \n"); 
		suQueryStr01.append("       mdm_vsl_svc_lane d,  \n"); 
		suQueryStr01.append("       ar_finc_dir_conv e,  \n");
		suQueryStr01.append("       mdm_organization g,  \n");
		suQueryStr01.append("       mdm_organization gg  \n");
		suQueryStr01.append(" WHERE a.bkg_no = ?   \n");
		suQueryStr01.append("   AND a.pod_cd = b.loc_cd \n"); 
		suQueryStr01.append("   AND a.pol_cd = bb.loc_cd  \n");
		suQueryStr01.append("   AND a.slan_cd = c.vsl_slan_cd(+) \n");  
		suQueryStr01.append("   AND a.slan_cd = d.vsl_slan_cd(+) \n"); 
		suQueryStr01.append("   AND a.slan_cd = e.slan_cd(+)  \n");
		suQueryStr01.append("   AND a.skd_dir_cd = e.slan_dir_cd(+)  \n");
		suQueryStr01.append("   AND a.vsl_pre_pst_cd in ('S') \n");
		suQueryStr01.append("   AND b.sconti_cd = NVL (e.sconti_cd, b.sconti_cd)  \n");
		suQueryStr01.append("   AND e.dir_cng_cd(+) = 'Y'   \n");
		suQueryStr01.append("   AND agt_ofc_new_old_fnc(b.finc_ctrl_ofc_cd) = g.modi_ofc_cd(+)  \n");
		suQueryStr01.append("   AND NVL(g.delt_flg, 'N') = 'N'  \n");
		suQueryStr01.append("   AND agt_ofc_new_old_fnc(bb.finc_ctrl_ofc_cd) = gg.modi_ofc_cd(+)  \n");
		suQueryStr01.append("   AND NVL(gg.delt_flg, 'N') = 'N'  \n");
		suQueryStr01.append("order by 2, 1 \n");
		
		// SU 의 Inbound T/S글 구한다.
		suQueryStr02.append("SELECT a.vsl_seq, a.vsl_pre_pst_cd, NVL (a.vsl_cd, '*') vsl_cd,  \n");
		suQueryStr02.append("       NVL (a.skd_voy_no, '*') skd_voy_no, NVL (a.skd_dir_cd, '*') skd_dir_cd,  \n");
		suQueryStr02.append("       NVL (e.rlane_dir_cd, a.skd_dir_cd) rlane_dir_cd,  \n");
		suQueryStr02.append("       NVL (a.slan_cd, '*') slan_cd, NVL (a.pol_cd, '*') vsl_pol_cd, NVL(b.conti_cd, '*') is_conti_cd, \n");
		suQueryStr02.append("       NVL (a.pod_cd, '*') vsl_pod_cd,   \n");
		suQueryStr02.append("       DECODE(a.vsl_pre_pst_cd, 'U', agt_ofc_new_old_fnc(b.finc_ctrl_ofc_cd), agt_ofc_new_old_fnc(bb.finc_ctrl_ofc_cd)) finc_ctrl_ofc_cd,   \n");
		suQueryStr02.append("       DECODE(a.vsl_pre_pst_cd, 'U', g.ar_ofc_cd, gg.ar_ofc_cd) ar_ofc_cd,  \n");
		suQueryStr02.append("       DECODE (c.vsl_svc_tp_cd, 'O', 1, 0) pre_feeder_check,  \n");
		suQueryStr02.append("       DECODE (d.vsl_svc_tp_cd, 'O', 1, 0) post_feeder_check  \n");
		suQueryStr02.append("  FROM bkg_vvd a,  \n");
		suQueryStr02.append("       mdm_location b,  \n");
		suQueryStr02.append("       mdm_location bb,  \n");
		suQueryStr02.append("       mdm_vsl_svc_lane c,  \n");
		suQueryStr02.append("       mdm_vsl_svc_lane d,  \n");
		suQueryStr02.append("       ar_finc_dir_conv e, \n");
		suQueryStr02.append("       mdm_organization g, \n");
		suQueryStr02.append("       mdm_organization gg \n");
		suQueryStr02.append(" WHERE a.bkg_no = ?  \n");
		suQueryStr02.append("   AND a.pol_cd = b.loc_cd \n");
		suQueryStr02.append("   AND a.pod_cd = bb.loc_cd \n");
		suQueryStr02.append("   AND a.slan_cd = c.vsl_slan_cd(+)  \n");
		suQueryStr02.append("   AND a.slan_cd = d.vsl_slan_cd(+) \n");
		suQueryStr02.append("   AND a.vsl_pre_pst_cd IN ('U', 'T')  \n");
		suQueryStr02.append("   AND a.slan_cd = e.slan_cd(+) \n");
		suQueryStr02.append("   AND a.skd_dir_cd = e.slan_dir_cd(+) \n");
		suQueryStr02.append("   AND b.sconti_cd = NVL (e.sconti_cd, b.sconti_cd) \n");
		suQueryStr02.append("   AND e.dir_cng_cd(+) = 'Y'  \n");
		suQueryStr02.append("   AND agt_ofc_new_old_fnc(b.finc_ctrl_ofc_cd) = g.modi_ofc_cd(+) \n");
		suQueryStr02.append("   AND NVL(g.delt_flg, 'N') = 'N' \n");
		suQueryStr02.append("   AND agt_ofc_new_old_fnc(bb.finc_ctrl_ofc_cd) = gg.modi_ofc_cd(+) \n");
		suQueryStr02.append("   AND NVL(gg.delt_flg, 'N') = 'N' \n");
		suQueryStr02.append("   AND a.vsl_seq != 0 \n");
		suQueryStr02.append(" order by 2, 1 \n");
		
		// Trunk S/A Date를 구한다.
		tQueryStr.append("SELECT a.vsl_seq, NVL (a.vsl_cd, '*') vsl_cd, \n");
		tQueryStr.append("       NVL (a.skd_voy_no, '*') skd_voy_no, NVL (a.skd_dir_cd, '*') skd_dir_cd, \n");
		tQueryStr.append("       NVL (a.slan_cd, '*') slan_cd, NVL (a.pol_cd, '*') vsl_pol_cd, \n");
		tQueryStr.append("       NVL (a.pod_cd, '*') vsl_pod_cd, \n");
		tQueryStr.append("       NVL (e.rlane_dir_cd, a.skd_dir_cd) rlane_dir_cd, \n");
		tQueryStr.append("       agt_get_trnk_rlane_fnc(a.bkg_no) rlane_cd \n");
		tQueryStr.append("  FROM bkg_vvd a, mdm_location b, ar_finc_dir_conv e \n");
		tQueryStr.append(" WHERE a.bkg_no = ? \n");
		tQueryStr.append("   AND a.vsl_pre_pst_cd = 'T' \n");
		tQueryStr.append("   AND a.pol_cd = b.loc_cd \n");
		tQueryStr.append("   AND a.slan_cd = e.slan_cd(+) \n");
		tQueryStr.append("   AND a.skd_dir_cd = e.slan_dir_cd(+) \n");
		tQueryStr.append("   AND b.sconti_cd = NVL (e.sconti_cd, b.sconti_cd) \n");
		tQueryStr.append("   AND e.dir_cng_cd(+) = 'Y' \n");

		try {
			
			bkg_no = (String)bkgMap.get("BKG_NO");
			
			con = getConnection();
			// S/U가 존재할 경우 Outbound T/S Date를 구한다. ------start------
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, suQueryStr01.toString());
			} else {
				ps = con.prepareStatement(suQueryStr01.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			int vsl_seq = 1;

			// Roop를 돌면서 Outbound T/S Date를 구한 후 ArrayList에 담는다.
			while(rs.next()) {
				
				vsl_seq = rs.getInt("vsl_seq");
				
				HashMap map = new HashMap();
				
				mataData = rs.getMetaData();
				columnCount = mataData.getColumnCount(); 

				for(int j = 1; j <= columnCount; j++) {
					columnName = mataData.getColumnName(j);
					map.put(columnName, rs.getString(columnName)); // 결과를 HashMap에 담는다.
				}

				// S/U의 Outbound T/S Date를 구한다.
				map = getSADateOfSU( con, map );
				
				// 각각의 SADate를 ArrayList에 담는다.
				saDateList.set(vsl_seq-1, map);
			}
			// S/U가 존재할 경우 Outbound T/S Date를 구한다. ------end------
			
			// S/U가 존재할 경우 Inbound T/S Date를 구한다. ------start------
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps02 = new LoggableStatement(con, suQueryStr02.toString());
			} else {
				ps02 = con.prepareStatement(suQueryStr02.toString());
			}

            // 쿼리에 변수 세팅.
			i = 1;
			ps02.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
			rs02 = ps02.executeQuery();

			// Roop를 돌면서 Inbound T/S Date를 구한 후 ArrayList에 담는다.
			while(rs02.next()) {
				
				vsl_seq = rs02.getInt("vsl_seq");
				
				HashMap map02 = new HashMap();
				
				mataData = rs02.getMetaData();
				columnCount = mataData.getColumnCount(); 

				for(int j = 1; j <= columnCount; j++) {
					columnName = mataData.getColumnName(j);
					map02.put(columnName, rs02.getString(columnName)); // 결과를 HashMap에 담는다.
				}

				// S/U의 Inbound T/S Date를 구한다.
				map02 = getSADateOfSU( con, map02 );
				
				// 각각의 SADate를 ArrayList에 담는다.
				saDateList.set(vsl_seq+4, map02);
			}
			// S/U가 존재할 경우 Inbound T/S Date를 구한다. ------end------

			// Trunk의 S/A Date를 구한다. -----start-----
			i = 1; // 초기화한다. 
			HashMap map = new HashMap();// Trunk의 S/A Date를 담을 HashMap
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps03 = new LoggableStatement(con, tQueryStr.toString());
			} else {
				ps03 = con.prepareStatement(tQueryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps03.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps03).getQueryString());
			rs03 = ps03.executeQuery();

			if( rs03.next() ) {

				mataData = rs03.getMetaData();
				columnCount = mataData.getColumnCount(); 

				for(int j = 1; j <= columnCount; j++) {
					columnName = mataData.getColumnName(j);
					map.put(columnName, rs03.getString(columnName)); // 결과를 HashMap에 담는다.
				}

				// Trunk의 출항일자를 구한다.
				map = getSADateOfTrunkEtdDt( con, map );
				vps_etd_dt = checkNull((String)map.get("VPS_ETD_DT"));
				if (vps_etd_dt.equals("")) {
				    log.debug("Trunk의 출항일자(vps_etd_dt) = " + vps_etd_dt + "     <-- null 이면 Calculation을 종료한다.");
				}
				// Trunk의 출항일자가 존재하지 않을 경우 에러처리한다. 
				// (kevin) 2009-03-23 수정 :  NULL에 대한 처리시 1보다 적으면 오류처리함
				//if(vps_etd_dt.length() <= 0) {
				if(vps_etd_dt.length() < 1) {
					// Trunk의 출항일자가 존재하지 않을 경우 Error를 agt_comm_bkg_info에 저장한다.
					bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00056").getUserMessage());
					createBKGMSTErrorMSG( con, bkgMap );
					return bkgMap;
				}

				// Trunk의 도착일자를 구한다.
				map = getSADateOfTrunkEtaDt( con, map );
				vps_eta_dt = checkNull((String)map.get("VPS_ETA_DT"));

				// Trunk의 도착일자가 존재하지 않을 겨우 에러처리한다.
				if(vps_eta_dt.length() <= 0) {
					// Trunk의 도착일자가 존재하지 않을 경우 Error를 agt_comm_bkg_info에 저장한다.
					bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00057").getUserMessage());
					createBKGMSTErrorMSG( con, bkgMap );
					return bkgMap;
				}
			} else {
				bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00058", new String[]{bkg_no}).getUserMessage());
				createBKGMSTErrorMSG( con, bkgMap );
				return bkgMap;
			}
			
			// 위에서 구한 Trunk의 S/A Date를 ArrayList의 4번 인덱스에 넣는다.
			saDateList.set(4, map);
			// Trunk의 S/A Date를 구한다. -----end-----

			// 해당 Booking의 S/A Date를 담고 있는 ArrayList를 bkgMap에 넣는다.
			bkgMap.put("SADate", saDateList);
			
			// Trunk의 출항일자를 Booking Map의 trunk_etd_dt로 셋팅한다. (요율 정보 조회 및 Error Message Insert/Update 시 사용 )
			// Brokerage/FAC에서만 사용함.
			bkgMap.put("TRUNK_ETD_DT", vps_etd_dt);
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeResultSet(rs02);
			closeResultSet(rs03);
			closeStatement(ps);
			closeStatement(ps02);
			closeStatement(ps03);
			closeConnection(con);
		}
		return bkgMap;
	}
	
	/**
	 * SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchAGTContractInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchAGTContractInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;

		// DB ResultSet
		ResultSet rs = null;

		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		ResultSetMetaData mataData = null;
		int columnCount = 0;
		String columnName = "";

		String bkg_no = "";
		String rfa_no = "";
		String sc_no = "";
		
		StringBuffer queryStr = new StringBuffer();

		
		// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, 3rd Party Office 조회 쿼리
		queryStr.append(" \n");
		queryStr.append("    SELECT \n");
		queryStr.append("           NVL (PPD_RCV_OFC_CD, ' ')                                             AS PPD_OFC_CD, \n");
		queryStr.append("           NVL (CLT_OFC_CD, ' ')                                                 AS CLT_OFC_CD, \n");
		queryStr.append("           NVL (PPD_PAYR_CNT_CD || TO_CHAR (PPD_PAYR_CUST_SEQ, 'FM000000'), ' ') AS PPAYR_CNT_CD, \n");
		queryStr.append("      CASE \n");
		queryStr.append("      WHEN RAT.CGO_RCV_DT IS NOT NULL \n");
		queryStr.append("        OR RAT.CGO_RCV_DT = '' \n");
		queryStr.append("        OR RAT.CGO_RCV_DT = ' ' \n");
		queryStr.append("      THEN TO_CHAR (RAT.CGO_RCV_DT, 'YYYYMMDDHH24MISS') \n");
		queryStr.append("      WHEN SUBSTR (BKG.POR_CD, 1, 2) = 'US' \n");
		queryStr.append("        OR SUBSTR (BKG.POL_CD, 1, 2) = 'US' \n");
		queryStr.append("        OR SUBSTR (BKG.POD_CD, 1, 2) = 'US' \n");
		queryStr.append("        OR SUBSTR (BKG.DEL_CD, 1, 2) = 'US' \n");
		queryStr.append("      THEN \n");
		queryStr.append("         ( \n");
		queryStr.append("               SELECT \n");
		queryStr.append("                      TO_CHAR (NVL (RAT.RT_APLY_DT, SKD.VPS_ETD_DT), 'YYYYMMDDHH24MISS') \n");
		queryStr.append("                 FROM BKG_VVD          VVD, \n");
		queryStr.append("                      VSK_VSL_PORT_SKD SKD \n");
		queryStr.append("                WHERE VVD.BKG_NO     = BKG.BKG_NO \n");
		queryStr.append("                  AND VVD.POL_CD     = BKG.POL_CD \n");
		queryStr.append("                  AND VVD.VSL_CD     = SKD.VSL_CD \n");
		queryStr.append("                  AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO \n");
		queryStr.append("                  AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD \n");
		queryStr.append("                  AND VVD.POL_CD     = SKD.VPS_PORT_CD \n");
		queryStr.append("                  AND 'S'          <>  NVL (SKD.SKD_CNG_STS_CD, '*') \n");
		queryStr.append("                  AND ROWNUM         = 1 \n");
		queryStr.append("         ) \n");
		queryStr.append("      ELSE \n");
		queryStr.append("         ( \n");
		queryStr.append("               SELECT \n");
		queryStr.append("                      TO_CHAR (NVL (SKD.VPS_ETD_DT, RAT.RT_APLY_DT), 'YYYYMMDDHH24MISS') \n");
		queryStr.append("                 FROM BKG_VVD          VVD, \n");
		queryStr.append("                      VSK_VSL_PORT_SKD SKD \n");
		queryStr.append("                WHERE VVD.BKG_NO     = BKG.BKG_NO \n");
		queryStr.append("                  AND VVD.POL_CD     = BKG.POL_CD \n");
		queryStr.append("                  AND VVD.VSL_CD     = SKD.VSL_CD \n");
		queryStr.append("                  AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO \n");
		queryStr.append("                  AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD \n");
		queryStr.append("                  AND VVD.POL_CD     = SKD.VPS_PORT_CD \n");
		queryStr.append("                  AND 'S'          <>  NVL (SKD.SKD_CNG_STS_CD, '*') \n");
		queryStr.append("                  AND ROWNUM         = 1 \n");
		queryStr.append("         ) \n");
		queryStr.append("       END                                                                       AS CGO_RCV_DT, \n");
		queryStr.append("         ( \n");
		queryStr.append("               SELECT \n");
		queryStr.append("             DISTINCT BCR.N3PTY_RCV_OFC_CD \n");
		queryStr.append("                 FROM BKG_CHG_RT BCR \n");
		queryStr.append("                WHERE BCR.BKG_NO                = BKG.BKG_NO \n");
		queryStr.append("                  AND BCR.N3PTY_RCV_OFC_CD IS NOT NULL \n");
		queryStr.append("                  AND ROWNUM                    = 1 \n");
		queryStr.append("         )                                                                       AS N3PTY_RCV_OFC_CD \n");
		queryStr.append("             FROM BKG_BOOKING  BKG, \n");
		queryStr.append("                  BKG_RATE     RAT \n");
		queryStr.append("            WHERE BKG.BKG_NO = RAT.BKG_NO \n");
		queryStr.append("              AND BKG.BKG_NO = ? \n");


		
		try {
			
			bkg_no = (String)bkgMap.get("BKG_NO");
			
			con = getConnection();
			
			//SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER 조회-----start-----
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, bkg_no);
			log.debug("\n [searchAGTCommTobeApproved]SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if( rs.next() ) {

				mataData = rs.getMetaData();
				columnCount = mataData.getColumnCount(); 

				for(int j = 1; j <= columnCount; j++) {
					columnName = mataData.getColumnName(j);
					bkgMap.put(columnName, rs.getString(columnName)); // 결과를 HashMap에 담는다.
				}
			} else {
				// 데이타가 존재하지 않을 경우 Error를 agt_comm_bkg_info에 저장한다.
				bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00038").getUserMessage());
				createBKGMSTErrorMSG( con, bkgMap );
				return bkgMap;
			}

			// RFA NO, SC NO에 대한 계약 office 구하여 Booking Map에 넣는다. -----start-----
			rfa_no	= checkNull((String)bkgMap.get("RFA_NO"));
			sc_no	= checkNull((String)bkgMap.get("SC_NO"));
			if ((rfa_no.length() > 0 && sc_no.length() > 0) || (rfa_no.length() > 0 && sc_no.length() == 0))
			{
				bkgMap.put("SLS_OFC_CD", checkNull((String)bkgMap.get("CTRT_OFC_CD")));
				bkgMap.put("SC_CTRT_OFC_CD", "");	
			}
			else if (rfa_no.length() == 0 && sc_no.length() > 0)
			{
				bkgMap.put("SLS_OFC_CD", "");
				bkgMap.put("SC_CTRT_OFC_CD",checkNull((String)bkgMap.get("CTRT_OFC_CD")));
			}
			else
			{
				bkgMap.put("SLS_OFC_CD", "");
				bkgMap.put("SC_CTRT_OFC_CD", "");
			}
			// RFA NO, SC NO에 대한 계약 office 구하여 Booking Map에 넣는다. -----end-----
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return bkgMap;
	}
	
	/**
	 * Booking QTY(물량)를 구한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchBKGQTYInfo(HashMap bkgMap) throws DAOException
	{

		log.debug("\n\n searchBKGQTYInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		ResultSetMetaData mataData = null;
		String columnName = "";
		int columnCount = 0;
		
		String bkg_no = "";

		StringBuffer queryStr = new StringBuffer();

		// Booking QTY 조회 쿼리
		queryStr.append("    SELECT \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', 0, QTY.OP_CNTR_QTY), 0)), 0) AS TEU, \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', 0, DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', 0, QTY.OP_CNTR_QTY))), 0) AS FEU, \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', QTY.OP_CNTR_QTY, 0)), 0)                                             AS REU, \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', QTY.OP_CNTR_QTY, 0), 0)), 0) AS RTEU, \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', 0, QTY.OP_CNTR_QTY), 0)), 0) AS RFEU, \n");
		queryStr.append("           NVL(SUM(QTY.OP_CNTR_QTY), 0) AS BOX \n");
		queryStr.append("      FROM BKG_QUANTITY QTY \n");
		queryStr.append("     WHERE QTY.BKG_NO \n");
		queryStr.append("        IN \n");
		queryStr.append("         ( \n");
		queryStr.append("               SELECT \n");
		queryStr.append("                      DOC.BKG_NO \n");
		queryStr.append("                 FROM BKG_BL_DOC  DOC, \n");
		queryStr.append("                      BKG_BOOKING BKG, \n");
		queryStr.append("                      BKG_BOOKING BK2 \n");
		queryStr.append("                WHERE \n");
		queryStr.append("                    ( \n");
		queryStr.append("                      BKG.BKG_NO                  = DOC.BKG_NO \n");
		queryStr.append("                   OR \n");
		queryStr.append("                      BKG.BL_NO                   = DOC.MST_CVRD_BL_NO \n");
		queryStr.append("                    ) \n");
		queryStr.append("                  AND BK2.BKG_NO                  = DOC.BKG_NO \n");
		queryStr.append("                  AND BK2.BL_NO_TP              <>  '9' \n");
		queryStr.append("                  AND BK2.BKG_STS_CD            <>  'X' \n");
		queryStr.append("                  AND BKG.BKG_NO                  = ? \n");
		queryStr.append("         ) \n");
		queryStr.append("       AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");

		bkg_no = (String)bkgMap.get("BKG_NO");

		try
		{
			
			
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, bkg_no);

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if( rs.next() ) {

				mataData = rs.getMetaData();
				columnCount = mataData.getColumnCount(); 

				for(int j = 1; j <= columnCount; j++) {
					columnName = mataData.getColumnName(j);
					bkgMap.put(columnName, rs.getString(columnName)); // 결과를 HashMap에 담는다.
				}
			} else {
				// 데이타가 존재하지 않을 경우 Error를 agt_comm_bkg_info에 저장한다.
				bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00039").getUserMessage());
				createBKGMSTErrorMSG( con, bkgMap );
				return bkgMap;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return bkgMap;
	}
	
	/**
	 * Revenue Lane과 Revenue VVD를 구한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchRevLanebndInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchRevLanebndInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		ResultSetMetaData mataData = null;
		String columnName = "";
		int columnCount = 0;
		
		String bkg_no = "";
		
		StringBuffer queryStr = new StringBuffer();

		// Revenue Lane과 Revenue VVD 조회 쿼리
		
		queryStr.append("\n------------------------------------------------------------------------------------ "); 
		queryStr.append("\n-- BKG_NO로 REV VVD 정보 조회 "); 
		queryStr.append("\n------------------------------------------------------------------------------------ "); 
		queryStr.append("\n "); 
		queryStr.append("\n    SELECT "); 
		queryStr.append("\n           BKG_NO, "); 
		queryStr.append("\n      CASE RNK  "); 
		queryStr.append("\n      WHEN 1  "); 
		queryStr.append("\n      THEN N1ST_CONTI  "); 
		queryStr.append("\n      WHEN 2  "); 
		queryStr.append("\n      THEN N2ND_CONTI  "); 
		queryStr.append("\n      WHEN 3  "); 
		queryStr.append("\n      THEN N3RD_CONTI  "); 
		queryStr.append("\n      WHEN 4  "); 
		queryStr.append("\n      THEN N4TH_CONTI  "); 
		queryStr.append("\n      ELSE ''  "); 
		queryStr.append("\n      END                 AS ESTM_IOC_DIV_CD,  "); 
		queryStr.append("\n      CASE RNK  "); 
		queryStr.append("\n      WHEN 1  "); 
		queryStr.append("\n      THEN N1ST_RLANE_CD  "); 
		queryStr.append("\n      WHEN 2  "); 
		queryStr.append("\n      THEN N2ND_RLANE_CD  "); 
		queryStr.append("\n      WHEN 3  "); 
		queryStr.append("\n      THEN N3RD_RLANE_CD  "); 
		queryStr.append("\n      ELSE N4TH_RLANE_CD  "); 
		queryStr.append("\n       END                 AS RLANE_CD,  "); 
		queryStr.append("\n      CASE  "); 
		queryStr.append("\n      WHEN 'RBCCO' = CASE RNK WHEN 1 THEN N1ST_RLANE_CD WHEN 2 THEN N2ND_RLANE_CD WHEN 3 THEN N3RD_RLANE_CD ELSE N4TH_RLANE_CD END "); 
		queryStr.append("\n      THEN 'CFDR'||TO_CHAR (SYSDATE, 'YYMM')||'EE'  "); 
		queryStr.append("\n      ELSE  "); 
		queryStr.append("\n         (  "); 
		queryStr.append("\n      CASE RNK  "); 
		queryStr.append("\n      WHEN 1  "); 
		queryStr.append("\n      THEN N1ST_VVD_CD  "); 
		queryStr.append("\n      WHEN 2  "); 
		queryStr.append("\n      THEN N2ND_VVD_CD  "); 
		queryStr.append("\n      WHEN 3  "); 
		queryStr.append("\n      THEN N3RD_VVD_CD  "); 
		queryStr.append("\n      ELSE N4TH_VVD_CD  "); 
		queryStr.append("\n       END  "); 
		queryStr.append("\n         )  "); 
		queryStr.append("\n       END                 AS REV_VVD_CD, "); 
		queryStr.append("\n      CASE RNK  "); 
		queryStr.append("\n      WHEN 1  "); 
		queryStr.append("\n      THEN N1ST_RLANE_CD  "); 
		queryStr.append("\n      WHEN 2  "); 
		queryStr.append("\n      THEN N2ND_RLANE_CD  "); 
		queryStr.append("\n      WHEN 3  "); 
		queryStr.append("\n      THEN N3RD_RLANE_CD  "); 
		queryStr.append("\n      ELSE N4TH_RLANE_CD  "); 
		queryStr.append("\n       END                 AS COMM_RLANE_CD "); 
		queryStr.append("\n      FROM "); 
		queryStr.append("\n         ( "); 
		queryStr.append("\n               SELECT "); 
		queryStr.append("\n                      C.BKG_NO       AS BKG_NO, "); 
		queryStr.append("\n                      COA_RANK_INFO_FNC "); 
		queryStr.append("\n                    ( "); 
		queryStr.append("\n                      NVL (AGT_GET_RLANE_FNC (C.SLAN_CD,C.POL_CD,C.POD_CD), 'RBCCO'),                               -- N1ST_RLANE_CD "); 
		queryStr.append("\n                      CASE WHEN D.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (D.SLAN_CD,D.POL_CD,D.POD_CD) END, -- N2ND_RLANE_CD "); 
		queryStr.append("\n                      CASE WHEN E.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (E.SLAN_CD,E.POL_CD,E.POD_CD) END, -- N3RD_RLANE_CD "); 
		queryStr.append("\n                      CASE WHEN F.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (F.SLAN_CD,F.POL_CD,F.POD_CD) END, -- N4TH_RLANE_CD "); 
		queryStr.append("\n                      CASE WHEN POL2.CONTI_CD = POD2.CONTI_CD THEN 'I'||POD2.CONTI_CD ELSE 'OO' END,                -- N1ST_CONTI "); 
		queryStr.append("\n                      CASE WHEN POD2.CONTI_CD = POD3.CONTI_CD THEN 'I'||POD3.CONTI_CD ELSE 'OO' END,                -- N2ND_CONTI "); 
		queryStr.append("\n                      CASE WHEN POD3.CONTI_CD = POD4.CONTI_CD THEN 'I'||POD4.CONTI_CD ELSE 'OO' END,                -- N3RD_CONTI "); 
		queryStr.append("\n                      CASE WHEN POL2.CONTI_CD = POD2.CONTI_CD THEN 'I'||POD2.CONTI_CD ELSE 'OO' END                 -- N4TH_CONTI "); 
		queryStr.append("\n                    ) AS RNK, "); 
		queryStr.append("\n                      CASE WHEN POL2.CONTI_CD = POD2.CONTI_CD THEN 'I'||POD2.CONTI_CD ELSE 'OO' END AS N1ST_CONTI,  "); 
		queryStr.append("\n                      CASE WHEN POD2.CONTI_CD = POD3.CONTI_CD THEN 'I'||POD3.CONTI_CD ELSE 'OO' END AS N2ND_CONTI,  "); 
		queryStr.append("\n                      CASE WHEN POD3.CONTI_CD = POD4.CONTI_CD THEN 'I'||POD4.CONTI_CD ELSE 'OO' END AS N3RD_CONTI,  "); 
		queryStr.append("\n                      CASE WHEN POD4.CONTI_CD = POD5.CONTI_CD THEN 'I'||POD5.CONTI_CD ELSE 'OO' END AS N4TH_CONTI, "); 
		queryStr.append("\n                      NVL (AGT_GET_RLANE_FNC (C.SLAN_CD,C.POL_CD,C.POD_CD), 'RBCCO') AS N1ST_RLANE_CD,  "); 
		queryStr.append("\n                      CASE WHEN D.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (D.SLAN_CD,D.POL_CD,D.POD_CD) END AS N2ND_RLANE_CD,  "); 
		queryStr.append("\n                      CASE WHEN E.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (E.SLAN_CD,E.POL_CD,E.POD_CD) END AS N3RD_RLANE_CD,  "); 
		queryStr.append("\n                      CASE WHEN F.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (F.SLAN_CD,F.POL_CD,F.POD_CD) END AS N4TH_RLANE_CD, "); 
		queryStr.append("\n                      C.VSL_CD "); 
		queryStr.append("\n                   || C.SKD_VOY_NO "); 
		queryStr.append("\n                   || C.SKD_DIR_CD "); 
		queryStr.append("\n                   || NVL "); 
		queryStr.append("\n                    ( "); 
		queryStr.append("\n                    ( "); 
		queryStr.append("\n                          SELECT -- COA_REV_DIR_CONV_FNC (C.SLAN_CD, C.POL_CD, C.SKD_DIR_CD) "); 
		queryStr.append("\n                                 RLANE_DIR_CD "); 
		queryStr.append("\n                            FROM AR_FINC_DIR_CONV "); 
		queryStr.append("\n                           WHERE SLAN_CD = C.SLAN_CD "); 
		queryStr.append("\n                             AND SCONTI_CD = POL2.SCONTI_CD "); 
		queryStr.append("\n                             AND SLAN_DIR_CD = C.SKD_DIR_CD "); 
		queryStr.append("\n                             AND DELT_FLG ='N' "); 
		queryStr.append("\n                    ) "); 
		queryStr.append("\n                    , C.SKD_DIR_CD "); 
		queryStr.append("\n                    )                                             AS N1ST_VVD_CD,  "); 
		queryStr.append("\n                      D.VSL_CD "); 
		queryStr.append("\n                   || D.SKD_VOY_NO "); 
		queryStr.append("\n                   || D.SKD_DIR_CD  "); 
		queryStr.append("\n                   ||  "); 
		queryStr.append("\n                 CASE D.SLAN_CD  "); 
		queryStr.append("\n                 WHEN NULL  "); 
		queryStr.append("\n                 THEN D.SKD_DIR_CD  "); 
		queryStr.append("\n                 ELSE NVL "); 
		queryStr.append("\n                    ( "); 
		queryStr.append("\n                    ( "); 
		queryStr.append("\n                          SELECT -- COA_REV_DIR_CONV_FNC (D.SLAN_CD, D.POL_CD, D.SKD_DIR_CD) "); 
		queryStr.append("\n                                 RLANE_DIR_CD "); 
		queryStr.append("\n                            FROM AR_FINC_DIR_CONV "); 
		queryStr.append("\n                           WHERE SLAN_CD = D.SLAN_CD "); 
		queryStr.append("\n                             AND SCONTI_CD = POL3.SCONTI_CD "); 
		queryStr.append("\n                             AND SLAN_DIR_CD = D.SKD_DIR_CD "); 
		queryStr.append("\n                             AND DELT_FLG ='N' "); 
		queryStr.append("\n                    ) "); 
		queryStr.append("\n                    , D.SKD_DIR_CD "); 
		queryStr.append("\n                    ) "); 
		queryStr.append("\n                  END                                                                           AS N2ND_VVD_CD,  "); 
		queryStr.append("\n                      E.VSL_CD||E.SKD_VOY_NO||E.SKD_DIR_CD  "); 
		queryStr.append("\n                   ||  "); 
		queryStr.append("\n                 CASE E.SLAN_CD  "); 
		queryStr.append("\n                 WHEN NULL  "); 
		queryStr.append("\n                 THEN E.SKD_DIR_CD "); 
		queryStr.append("\n                 ELSE NVL "); 
		queryStr.append("\n                    ( "); 
		queryStr.append("\n                    ( "); 
		queryStr.append("\n                          SELECT -- COA_REV_DIR_CONV_FNC (E.SLAN_CD, E.POL_CD, E.SKD_DIR_CD) "); 
		queryStr.append("\n                                 RLANE_DIR_CD "); 
		queryStr.append("\n                            FROM AR_FINC_DIR_CONV "); 
		queryStr.append("\n                           WHERE SLAN_CD     = E.SLAN_CD "); 
		queryStr.append("\n                             AND SCONTI_CD   = POL4.SCONTI_CD "); 
		queryStr.append("\n                             AND SLAN_DIR_CD = E.SKD_DIR_CD "); 
		queryStr.append("\n                             AND DELT_FLG    ='N' "); 
		queryStr.append("\n                    ) "); 
		queryStr.append("\n                    , E.SKD_DIR_CD "); 
		queryStr.append("\n                    )  "); 
		queryStr.append("\n                  END                                                                           AS N3RD_VVD_CD,  "); 
		queryStr.append("\n                      F.VSL_CD||F.SKD_VOY_NO||F.SKD_DIR_CD  "); 
		queryStr.append("\n                   ||  "); 
		queryStr.append("\n                 CASE F.SLAN_CD  "); 
		queryStr.append("\n                 WHEN NULL  "); 
		queryStr.append("\n                 THEN F.SKD_DIR_CD "); 
		queryStr.append("\n                 ELSE NVL "); 
		queryStr.append("\n                    ( "); 
		queryStr.append("\n                    ( "); 
		queryStr.append("\n                          SELECT -- COA_REV_DIR_CONV_FNC (F.SLAN_CD, F.POL_CD, F.SKD_DIR_CD) "); 
		queryStr.append("\n                                 RLANE_DIR_CD "); 
		queryStr.append("\n                            FROM AR_FINC_DIR_CONV "); 
		queryStr.append("\n                           WHERE SLAN_CD     = F.SLAN_CD "); 
		queryStr.append("\n                             AND SCONTI_CD   = POL5.SCONTI_CD "); 
		queryStr.append("\n                             AND SLAN_DIR_CD = F.SKD_DIR_CD "); 
		queryStr.append("\n                             AND DELT_FLG    ='N' "); 
		queryStr.append("\n                    ) "); 
		queryStr.append("\n                    , F.SKD_DIR_CD "); 
		queryStr.append("\n                    )  "); 
		queryStr.append("\n                  END                                                                           AS N4TH_VVD_CD "); 
		queryStr.append("\n                 FROM    "); 
		queryStr.append("\n                      BKG_VVD D, "); 
		queryStr.append("\n                      BKG_VVD E, "); 
		queryStr.append("\n                      BKG_VVD F, "); 
		queryStr.append("\n                      MDM_LOCATION POL2,                           "); 
		queryStr.append("\n                      MDM_LOCATION POD2, "); 
		queryStr.append("\n                      MDM_LOCATION POL3, "); 
		queryStr.append("\n                      MDM_LOCATION POD3, "); 
		queryStr.append("\n                      MDM_LOCATION POL4, "); 
		queryStr.append("\n                      MDM_LOCATION POD4, "); 
		queryStr.append("\n                      MDM_LOCATION POL5, "); 
		queryStr.append("\n                      MDM_LOCATION POD5, "); 
		queryStr.append("\n                    ( "); 
		queryStr.append("\n                          SELECT "); 
		queryStr.append("\n                                 VVD.BKG_NO, "); 
		queryStr.append("\n                                 VVD.VSL_CD, "); 
		queryStr.append("\n                                 VVD.SKD_VOY_NO, "); 
		queryStr.append("\n                                 VVD.SKD_DIR_CD, "); 
		queryStr.append("\n                                 VVD.SLAN_CD, "); 
		queryStr.append("\n                                 VVD.POL_CD, "); 
		queryStr.append("\n                                 VVD.POD_CD "); 
		queryStr.append("\n                            FROM BKG_VVD     VVD, "); 
		queryStr.append("\n                                 BKG_BOOKING BKG "); 
		queryStr.append("\n                           WHERE BKG.BKG_NO   = ? "); 
		queryStr.append("\n                             AND VVD.BKG_NO   = BKG.BKG_NO "); 
		queryStr.append("\n                             AND VVD.POL_CD   = BKG.POL_CD "); 
		queryStr.append("\n                    ) C "); 
		queryStr.append("\n                WHERE D.BKG_NO(+)   = C.BKG_NO "); 
		queryStr.append("\n                  AND D.POL_CD(+)   = C.POD_CD "); 
		queryStr.append("\n                  AND E.BKG_NO(+)   = D.BKG_NO "); 
		queryStr.append("\n                  AND E.POL_CD(+)   = D.POD_CD "); 
		queryStr.append("\n                  AND F.BKG_NO(+)   = E.BKG_NO "); 
		queryStr.append("\n                  AND F.POL_CD(+)   = E.POD_CD "); 
		queryStr.append("\n                  AND C.POL_CD      = POL2.LOC_CD (+) "); 
		queryStr.append("\n                  AND C.POD_CD      = POD2.LOC_CD (+) "); 
		queryStr.append("\n                  AND D.POL_CD      = POL3.LOC_CD (+) "); 
		queryStr.append("\n                  AND D.POD_CD      = POD3.LOC_CD (+) "); 
		queryStr.append("\n                  AND E.POL_CD      = POL4.LOC_CD (+) "); 
		queryStr.append("\n                  AND E.POD_CD      = POD4.LOC_CD (+) "); 
		queryStr.append("\n                  AND F.POL_CD      = POL5.LOC_CD (+) "); 
		queryStr.append("\n                  AND F.POD_CD      = POD5.LOC_CD (+) "); 
		queryStr.append("\n         ) "); 

		
		bkg_no = (String)bkgMap.get("BKG_NO");

		try {
			
			
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, bkg_no);
			
			log.debug("\n VVD : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if( rs.next() ) {

				mataData = rs.getMetaData();
				columnCount = mataData.getColumnCount(); 

				for(int j = 1; j <= columnCount; j++) {
					columnName = mataData.getColumnName(j);
					bkgMap.put(columnName, rs.getString(columnName)); // 결과를 HashMap에 담는다.
				}
			} else {
				// 데이타가 존재하지 않을 경우 Error를 agt_comm_bkg_info에 저장한다.
//				bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00040", new String[]{bkg_no+bkg_no_split}).getUserMessage());
//				createBKGMSTErrorMSG( con, bkgMap );
//				return bkgMap;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return bkgMap;
	}
	
	/**
	 * Booking Commission 정보를 저장한다.<br>
	 * CHM-201111599 - THC 공제로직 변경사항
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @throws DAOException
	 */
	public void createBKGMasterInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n createBKGMasterInfo 메소드 시작 ========================================\n");
		
		// Connection Interface   
		Connection con = null;
		// INSERT를 수행하기 위한 SQL Statement
		PreparedStatement mergePs01  = null;
		PreparedStatement mergePs02  = null;
		PreparedStatement mergePs03  = null;
		PreparedStatement deletePs01  = null;

		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		// S/A Date를 담고 있는 ArrayList
		ArrayList saDateList = null;
		// Trunk 정보를 담고있는 HashMap
		HashMap trnkMap = null; //반드시 존재한다.
		
		String bkg_no = "";
		String shpr_seq = "";
		String frt_fwrd_seq = "";
		String rlane_cd = "";
		//String trd_cd = "";
		
		
		//double bkg_ppd_frt_amt = 0;
		//double bkg_ppd_otr_amt = 0;
		//double bkg_clt_frt_amt = 0;
		//double bkg_clt_otr_amt = 0;
		
		int iShpr_seq = 0;
		int iFrt_fwrd_seq = 0;
		
		//StringBuffer queryStr = new StringBuffer();
		//StringBuffer queryStr02 = new StringBuffer();
		StringBuffer mergeQuery01 = new StringBuffer();
		StringBuffer mergeQuery02 = new StringBuffer();
		StringBuffer mergeQuery03 = new StringBuffer();
		StringBuffer deleteQuery01 = new StringBuffer();

		deleteQuery01.append("\n    DELETE \n");
		deleteQuery01.append("        FROM AGT_CHG_ROUT_REF \n");
		deleteQuery01.append("       WHERE CRE_DT > TO_DATE ('20100405', 'YYYYMMDD') \n");
		deleteQuery01.append("         AND BKG_NO = ? " + "\n");

		//Insert/Update
		mergeQuery01.append(" \n");
		mergeQuery01.append("     MERGE \n");
		mergeQuery01.append("      INTO AGT_COMM_BKG_INFO TBL \n");
		mergeQuery01.append("     USING \n");
		mergeQuery01.append("         ( \n");
		mergeQuery01.append("               SELECT \n");
		mergeQuery01.append("                      FRT.BKG_NO, \n");
		mergeQuery01.append("                      NULL                                 AS COMM_PROC_RSLT_RSN, \n");
		mergeQuery01.append("                      BKG.BL_NO, \n");
		mergeQuery01.append("                      BKG.BKG_CGO_TP_CD, \n");
		mergeQuery01.append("                      BKG.BKG_STS_CD, \n");
		mergeQuery01.append("                      FRT.SHPR_CNT_CD, \n");
		mergeQuery01.append("                      FRT.SHPR_SEQ, \n");
		mergeQuery01.append("                      FRT.FRT_FWRD_CNT_CD, \n");
		mergeQuery01.append("                      FRT.FRT_FWRD_SEQ, \n");
		mergeQuery01.append("                      FRT.RLANE_CD, \n");
		mergeQuery01.append("                      FRT.REV_VVD_CD, \n");
		mergeQuery01.append("                      FRT.TRNK_SLAN_CD, \n");
		mergeQuery01.append("                      FRT.TRNK_RLANE_CD, \n");
		mergeQuery01.append("                      FRT.TRNK_VSL_CD, \n");
		mergeQuery01.append("                      FRT.TRNK_SKD_VOY_NO, \n");
		mergeQuery01.append("                      FRT.TRNK_SKD_DIR_CD, \n");
		mergeQuery01.append("                      FRT.TRNK_REV_DIR_CD, \n");
		mergeQuery01.append("                      BKG.SVC_SCP_CD, \n");
		mergeQuery01.append("                      NULL                                 AS BKG_CA_NO, \n");
		mergeQuery01.append("                      NULL                                 AS BKG_CA_DT, \n");
		mergeQuery01.append("                    ( \n");
		mergeQuery01.append("                          SELECT \n");
		mergeQuery01.append("                                 REP_TRD_CD \n");
		mergeQuery01.append("                            FROM MDM_REV_LANE \n");
		mergeQuery01.append("                           WHERE RLANE_CD = FRT.RLANE_CD \n");
		mergeQuery01.append("                    )                                      AS TRD_CD, \n");
		mergeQuery01.append("                      BKG.POR_CD                           AS BKG_POR_CD, \n");
		mergeQuery01.append("                      BKG.POL_CD                           AS BKG_POL_CD, \n");
		mergeQuery01.append("                      BKG.POD_CD                           AS BKG_POD_CD, \n");
		mergeQuery01.append("                      BKG.DEL_CD                           AS BKG_DEL_CD, \n");
		mergeQuery01.append("                      BKG.RCV_TERM_CD                      AS BKG_RCV_TERM_CD, \n");
		mergeQuery01.append("                      BKG.DE_TERM_CD                       AS BKG_DE_TERM_CD, \n");
		mergeQuery01.append("                      NVL (BKG.PRE_RLY_PORT_CD, '*')       AS PRE_PORT_CD, \n");
		mergeQuery01.append("                      NVL (BKG.PST_RLY_PORT_CD, '*')       AS PST_PORT_CD, \n");
		mergeQuery01.append("                      FRT.FMC_NO, \n");
		mergeQuery01.append("                      BKG.REP_CMDT_CD, \n");
		mergeQuery01.append("                      BKG.CMDT_CD, \n");
		mergeQuery01.append("                      BKG.SC_NO, \n");
		mergeQuery01.append("                      BKG.RFA_NO, \n");
		mergeQuery01.append("                      NVL (BKG.DCGO_FLG, 'N')              AS SPCL_DG_CGO_FLG, \n");
		mergeQuery01.append("                      NVL (BKG.RC_FLG, 'N')                AS SPCL_RC_FLG, \n");
		mergeQuery01.append("                      NVL (BKG.AWK_CGO_FLG, 'N')           AS SPCL_AWK_CGO_FLG, \n");
		mergeQuery01.append("                      NVL (BKG.BB_CGO_FLG, 'N')            AS SPCL_BB_CGO_FLG, \n");
		mergeQuery01.append("                      'N'                                  AS SPCL_RD_CGO_FLG, \n");
		mergeQuery01.append("                      BKG.BKG_OFC_CD, \n");
		mergeQuery01.append("                      FRT.SLS_OFC_CD, \n");
		mergeQuery01.append("                      NULL                                 AS RHQ_CD, \n");
		mergeQuery01.append("                      NVL (BKG.SOC_FLG, 'N')               AS BKG_SOC_FLG, \n");
		mergeQuery01.append("                      NVL (BKG.DBL_BKG_FLG, 'N')           AS BKG_DBL_FLG, \n");
		mergeQuery01.append("                      BKG.BKG_CRE_DT, \n");
		mergeQuery01.append("                      FRT.ESTM_IOC_DIV_CD, \n");
		mergeQuery01.append("                      FRT.BKG_PPD_FRT_AMT, \n");
		mergeQuery01.append("                      FRT.BKG_PPD_OTR_AMT, \n");
		mergeQuery01.append("                      FRT.BKG_CLT_FRT_AMT, \n");
		mergeQuery01.append("                      FRT.BKG_CLT_OTR_AMT, \n");
		mergeQuery01.append("                      'AGT SYSTEM'                         AS UPD_USR_ID, \n");
		mergeQuery01.append("                      SYSDATE                              AS UPD_DT, \n");
		mergeQuery01.append("                      'AGT SYSTEM'                         AS CRE_USR_ID, \n");
		mergeQuery01.append("                      SYSDATE                              AS CRE_DT \n");
		mergeQuery01.append("                 FROM BKG_BOOKING   BKG, \n");
		mergeQuery01.append("                    ( \n");
		mergeQuery01.append("                          SELECT \n");
		mergeQuery01.append("                                 INP.BKG_NO, \n");
		mergeQuery01.append("                                 INP.SHPR_CNT_CD, \n");
		mergeQuery01.append("                                 INP.SHPR_SEQ, \n");
		mergeQuery01.append("                                 INP.FRT_FWRD_CNT_CD, \n");
		mergeQuery01.append("                                 INP.FRT_FWRD_SEQ, \n");
		mergeQuery01.append("                                 INP.RLANE_CD, \n");
		mergeQuery01.append("                                 INP.REV_VVD_CD, \n");
		mergeQuery01.append("                                 INP.TRNK_SLAN_CD, \n");
		mergeQuery01.append("                                 INP.TRNK_RLANE_CD, \n");
		mergeQuery01.append("                                 INP.TRNK_VSL_CD, \n");
		mergeQuery01.append("                                 INP.TRNK_SKD_VOY_NO, \n");
		mergeQuery01.append("                                 INP.TRNK_SKD_DIR_CD, \n");
		mergeQuery01.append("                                 INP.TRNK_REV_DIR_CD, \n");
		mergeQuery01.append("                                 INP.FMC_NO, \n");
		mergeQuery01.append("                                 INP.SLS_OFC_CD, \n");
		mergeQuery01.append("                                 INP.ESTM_IOC_DIV_CD, \n");
		mergeQuery01.append("                                 SUM \n");
		mergeQuery01.append("                               ( \n");
		mergeQuery01.append("                            CASE \n");
		mergeQuery01.append("                            WHEN BCR.FRT_TERM_CD = 'P' \n");
		mergeQuery01.append("                             AND BCR.CHG_CD      = 'OFT' \n");
		mergeQuery01.append("                             AND BCR.CURR_CD     = 'USD' \n");
		mergeQuery01.append("                            THEN BCR.CHG_AMT \n");
		mergeQuery01.append("                            WHEN BCR.FRT_TERM_CD = 'P' \n");
		mergeQuery01.append("                             AND BCR.CHG_CD      = 'OFT' \n");
		mergeQuery01.append("                             AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0 \n");
		mergeQuery01.append("                            THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT \n");
		mergeQuery01.append("                            ELSE 0 \n");
		mergeQuery01.append("                             END \n");
		mergeQuery01.append("                               )                                      AS BKG_PPD_FRT_AMT, \n");
		mergeQuery01.append("                                 SUM \n");
		mergeQuery01.append("                               ( \n");
		mergeQuery01.append("                            CASE \n");
		mergeQuery01.append("                            WHEN BCR.FRT_TERM_CD = 'P' \n");
		mergeQuery01.append("                             AND BCR.CHG_CD      = 'OFT' \n");
		mergeQuery01.append("                            THEN 0 \n");
		mergeQuery01.append("                            WHEN BCR.FRT_TERM_CD = 'P' \n");
		mergeQuery01.append("                             AND BCR.CURR_CD     = 'USD' \n");
		mergeQuery01.append("                            THEN BCR.CHG_AMT \n");
		mergeQuery01.append("                            WHEN BCR.FRT_TERM_CD = 'P' \n");
		mergeQuery01.append("                             AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0 \n");
		mergeQuery01.append("                            THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT \n");
		mergeQuery01.append("                            ELSE 0 \n");
		mergeQuery01.append("                             END \n");
		mergeQuery01.append("                               )                                      AS BKG_PPD_OTR_AMT, \n");
		mergeQuery01.append("                                 SUM \n");
		mergeQuery01.append("                               ( \n");
		mergeQuery01.append("                            CASE \n");
		mergeQuery01.append("                            WHEN BCR.FRT_TERM_CD = 'C' \n");
		mergeQuery01.append("                             AND BCR.CHG_CD      = 'OFT' \n");
		mergeQuery01.append("                             AND BCR.CURR_CD     = 'USD' \n");
		mergeQuery01.append("                            THEN BCR.CHG_AMT \n");
		mergeQuery01.append("                            WHEN BCR.FRT_TERM_CD = 'C' \n");
		mergeQuery01.append("                             AND BCR.CHG_CD      = 'OFT' \n");
		mergeQuery01.append("                             AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0 \n");
		mergeQuery01.append("                            THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT \n");
		mergeQuery01.append("                            ELSE 0 \n");
		mergeQuery01.append("                             END \n");
		mergeQuery01.append("                               )                                      AS BKG_CLT_FRT_AMT, \n");
		mergeQuery01.append("                                 SUM \n");
		mergeQuery01.append("                               ( \n");
		mergeQuery01.append("                            CASE \n");
		mergeQuery01.append("                            WHEN BCR.FRT_TERM_CD = 'C' \n");
		mergeQuery01.append("                             AND BCR.CHG_CD      = 'OFT' \n");
		mergeQuery01.append("                            THEN 0 \n");
		mergeQuery01.append("                            WHEN BCR.FRT_TERM_CD = 'C' \n");
		mergeQuery01.append("                             AND BCR.CURR_CD     = 'USD' \n");
		mergeQuery01.append("                            THEN BCR.CHG_AMT \n");
		mergeQuery01.append("                            WHEN BCR.FRT_TERM_CD = 'C' \n");
		mergeQuery01.append("                             AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0 \n");
		mergeQuery01.append("                            THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT \n");
		mergeQuery01.append("                            ELSE 0 \n");
		mergeQuery01.append("                             END \n");
		mergeQuery01.append("                               )                                      AS BKG_CLT_OTR_AMT \n");
		mergeQuery01.append("                            FROM BKG_CHG_RT    BCR, \n");
		mergeQuery01.append("                                 GL_MON_XCH_RT MXR, \n");
		mergeQuery01.append("                               ( \n");
		mergeQuery01.append("                                     SELECT \n");
		mergeQuery01.append("                                            ? AS BKG_NO, \n");
		mergeQuery01.append("                                            ?           AS SHPR_CNT_CD, \n");
		mergeQuery01.append("                                            ?          AS SHPR_SEQ, \n");
		mergeQuery01.append("                                            ?           AS FRT_FWRD_CNT_CD, \n");
		mergeQuery01.append("                                            ?          AS FRT_FWRD_SEQ, \n");
		mergeQuery01.append("                                            ?        AS RLANE_CD, \n");
		mergeQuery01.append("                                            ?   AS REV_VVD_CD, \n");
		mergeQuery01.append("                                            ?          AS TRNK_SLAN_CD, \n");
		mergeQuery01.append("                                            ?        AS TRNK_RLANE_CD, \n");
		mergeQuery01.append("                                            ?         AS TRNK_VSL_CD, \n");
		mergeQuery01.append("                                            ?         AS TRNK_SKD_VOY_NO, \n");
		mergeQuery01.append("                                            ?            AS TRNK_SKD_DIR_CD, \n");
		mergeQuery01.append("                                            ?            AS TRNK_REV_DIR_CD, \n");
		mergeQuery01.append("                                            ?         AS FMC_NO, \n");
		mergeQuery01.append("                                            ?        AS SLS_OFC_CD, \n");
		mergeQuery01.append("                                            ?           AS ESTM_IOC_DIV_CD \n");
		mergeQuery01.append("                                       FROM DUAL \n");
		mergeQuery01.append("                               ) INP \n");
		mergeQuery01.append("                           WHERE BCR.FRT_INCL_XCLD_DIV_CD = 'N' \n");
		mergeQuery01.append("                             AND BCR.CURR_CD              = MXR.CURR_CD \n");
		mergeQuery01.append("                             AND BCR.BKG_NO               = INP.BKG_NO \n");
		mergeQuery01.append("                             AND MXR.ACCT_XCH_RT_LVL      = '1' \n");
		mergeQuery01.append("                             AND MXR.ACCT_XCH_RT_YRMON \n");
		mergeQuery01.append("                              IN \n");
		mergeQuery01.append("                               ( \n");
		mergeQuery01.append("                                     SELECT \n");
		mergeQuery01.append("                                       CASE \n");
		mergeQuery01.append("                                       WHEN RAT.RT_APLY_DT IS NOT NULL \n");
		mergeQuery01.append("                                       THEN TO_CHAR (LEAST (RAT.RT_APLY_DT, SYSDATE), 'YYYYMM') \n");
		mergeQuery01.append("                                       WHEN RAT.RT_APLY_DT IS NULL \n");
		mergeQuery01.append("                                        AND \n");
		mergeQuery01.append("                                          ( \n");
		mergeQuery01.append("                                                SELECT \n");
		mergeQuery01.append("                                                       NVL (SUM (CNTR_VOL_QTY), 0) \n");
		mergeQuery01.append("                                                  FROM BKG_CONTAINER BCN \n");
		mergeQuery01.append("                                                 WHERE BCN.BKG_NO = BKG.BKG_NO \n");
		mergeQuery01.append("                                          ) \n");
		mergeQuery01.append("                                          = \n");
		mergeQuery01.append("                                          ( \n");
		mergeQuery01.append("                                                SELECT \n");
		mergeQuery01.append("                                                       NVL (SUM (QTY.OP_CNTR_QTY), 0) \n");
		mergeQuery01.append("                                                  FROM BKG_QUANTITY QTY \n");
		mergeQuery01.append("                                                 WHERE QTY.BKG_NO = BKG.BKG_NO \n");
		mergeQuery01.append("                                                   AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");
		mergeQuery01.append("                                          ) \n");
		mergeQuery01.append("                                        AND SUBSTR (BKG.POR_CD, 1, 2) = 'US' \n");
		mergeQuery01.append("                                         OR SUBSTR (BKG.POR_CD, 1, 2) = 'MX' \n");
		mergeQuery01.append("                                         OR SUBSTR (BKG.POR_CD, 1, 2) = 'CA' \n");
		mergeQuery01.append("                                         OR SUBSTR (BKG.POR_CD, 1, 2) = 'BR' \n");
		mergeQuery01.append("                                         OR SUBSTR (BKG.DEL_CD, 1, 2) = 'US' \n");
		mergeQuery01.append("                                         OR SUBSTR (BKG.DEL_CD, 1, 2) = 'MX' \n");
		mergeQuery01.append("                                         OR SUBSTR (BKG.DEL_CD, 1, 2) = 'CA' \n");
		mergeQuery01.append("                                         OR SUBSTR (BKG.DEL_CD, 1, 2) = 'BR' \n");
		mergeQuery01.append("                                       THEN \n");
		mergeQuery01.append("                                          ( \n");
		mergeQuery01.append("                                                SELECT \n");
		mergeQuery01.append("                                                  CASE \n");
		mergeQuery01.append("                                                  WHEN MAX (BCN.CGO_RCV_DT) IS NULL \n");
		mergeQuery01.append("                                                  THEN TO_CHAR (SYSDATE, 'YYYYMM') \n");
		mergeQuery01.append("                                                  ELSE TO_CHAR (LEAST (MAX (BCN.CGO_RCV_DT), SYSDATE), 'YYYYMM') \n");
		mergeQuery01.append("                                                   END RT_APLY_DT \n");
		mergeQuery01.append("                                                  FROM BKG_CONTAINER BCN \n");
		mergeQuery01.append("                                                 WHERE BCN.BKG_NO = BKG.BKG_NO \n");
		mergeQuery01.append("                                          ) \n");
		mergeQuery01.append("                                       ELSE \n");
		mergeQuery01.append("                                          ( \n");
		mergeQuery01.append("                                                SELECT \n");
		mergeQuery01.append("                                                        TO_CHAR (LEAST (MAX (VSK.INIT_ETD_DT), SYSDATE), 'YYYYMM') \n");
		mergeQuery01.append("                                                  FROM BKG_VVD          VVD, \n");
		mergeQuery01.append("                                                       VSK_VSL_PORT_SKD VSK \n");
		mergeQuery01.append("                                                 WHERE VVD.BKG_NO       = BKG.BKG_NO \n");
		mergeQuery01.append("                                                   AND VVD.POL_CD       = BKG.POL_CD \n");
		mergeQuery01.append("                                                   AND VVD.VSL_CD       = VSK.VSL_CD \n");
		mergeQuery01.append("                                                   AND VVD.SKD_VOY_NO   = VSK.SKD_VOY_NO \n");
		mergeQuery01.append("                                                   AND VVD.SKD_DIR_CD   = VSK.SKD_DIR_CD \n");
		mergeQuery01.append("                                                   AND VVD.POL_CD       = VSK.VPS_PORT_CD \n");
		mergeQuery01.append("                                          ) \n");
		mergeQuery01.append("                                        END AS RT_APLY_DT \n");
		mergeQuery01.append("                                       FROM BKG_BOOKING BKG, \n");
		mergeQuery01.append("                                            BKG_RATE    RAT \n");
		mergeQuery01.append("                                      WHERE BKG.BKG_NO = RAT.BKG_NO \n");
		mergeQuery01.append("                                        AND BKG.BKG_NO = INP.BKG_NO \n");
		mergeQuery01.append("                                        AND ROWNUM = 1 \n");
		mergeQuery01.append("                               ) \n");
		mergeQuery01.append("                    ) FRT \n");
		mergeQuery01.append("                WHERE FRT.BKG_NO               = BKG.BKG_NO \n");
		mergeQuery01.append("         ) PSD \n");
		mergeQuery01.append("        ON \n");
		mergeQuery01.append("         ( \n");
		mergeQuery01.append("           TBL.BKG_NO = PSD.BKG_NO \n");
		mergeQuery01.append("         ) \n");
		mergeQuery01.append("      WHEN MATCHED \n");
		mergeQuery01.append("      THEN \n");
		mergeQuery01.append("               UPDATE \n");
		mergeQuery01.append("                  SET TBL.COMM_PROC_RSLT_RSN = PSD.COMM_PROC_RSLT_RSN, \n");
		mergeQuery01.append("                      TBL.BL_NO              = PSD.BL_NO, \n");
		mergeQuery01.append("                      TBL.BKG_CGO_TP_CD      = PSD.BKG_CGO_TP_CD, \n");
		mergeQuery01.append("                      TBL.BKG_STS_CD         = PSD.BKG_STS_CD, \n");
		mergeQuery01.append("                      TBL.SHPR_CNT_CD        = PSD.SHPR_CNT_CD, \n");
		mergeQuery01.append("                      TBL.SHPR_SEQ           = PSD.SHPR_SEQ, \n");
		mergeQuery01.append("                      TBL.FRT_FWRD_CNT_CD    = PSD.FRT_FWRD_CNT_CD, \n");
		mergeQuery01.append("                      TBL.FRT_FWRD_SEQ       = PSD.FRT_FWRD_SEQ, \n");
		mergeQuery01.append("                      TBL.RLANE_CD           = PSD.RLANE_CD, \n");
		mergeQuery01.append("                      TBL.REV_VVD_CD         = PSD.REV_VVD_CD, \n");
		mergeQuery01.append("                      TBL.TRNK_SLAN_CD       = PSD.TRNK_SLAN_CD, \n");
		mergeQuery01.append("                      TBL.TRNK_RLANE_CD      = PSD.TRNK_RLANE_CD, \n");
		mergeQuery01.append("                      TBL.TRNK_VSL_CD        = PSD.TRNK_VSL_CD, \n");
		mergeQuery01.append("                      TBL.TRNK_SKD_VOY_NO    = PSD.TRNK_SKD_VOY_NO, \n");
		mergeQuery01.append("                      TBL.TRNK_SKD_DIR_CD    = PSD.TRNK_SKD_DIR_CD, \n");
		mergeQuery01.append("                      TBL.TRNK_REV_DIR_CD    = PSD.TRNK_REV_DIR_CD, \n");
		mergeQuery01.append("                      TBL.SVC_SCP_CD         = PSD.SVC_SCP_CD, \n");
		mergeQuery01.append("                      TBL.BKG_CA_NO          = PSD.BKG_CA_NO, \n");
		mergeQuery01.append("                      TBL.BKG_CA_DT          = PSD.BKG_CA_DT, \n");
		mergeQuery01.append("                      TBL.TRD_CD             = PSD.TRD_CD, \n");
		mergeQuery01.append("                      TBL.BKG_POR_CD         = PSD.BKG_POR_CD, \n");
		mergeQuery01.append("                      TBL.BKG_POL_CD         = PSD.BKG_POL_CD, \n");
		mergeQuery01.append("                      TBL.BKG_POD_CD         = PSD.BKG_POD_CD, \n");
		mergeQuery01.append("                      TBL.BKG_DEL_CD         = PSD.BKG_DEL_CD, \n");
		mergeQuery01.append("                      TBL.BKG_RCV_TERM_CD    = PSD.BKG_RCV_TERM_CD, \n");
		mergeQuery01.append("                      TBL.BKG_DE_TERM_CD     = PSD.BKG_DE_TERM_CD, \n");
		mergeQuery01.append("                      TBL.PRE_PORT_CD        = PSD.PRE_PORT_CD, \n");
		mergeQuery01.append("                      TBL.PST_PORT_CD        = PSD.PST_PORT_CD, \n");
		mergeQuery01.append("                      TBL.FMC_NO             = PSD.FMC_NO, \n");
		mergeQuery01.append("                      TBL.REP_CMDT_CD        = PSD.REP_CMDT_CD, \n");
		mergeQuery01.append("                      TBL.CMDT_CD            = PSD.CMDT_CD, \n");
		mergeQuery01.append("                      TBL.SC_NO              = PSD.SC_NO, \n");
		mergeQuery01.append("                      TBL.RFA_NO             = PSD.RFA_NO, \n");
		mergeQuery01.append("                      TBL.BKG_PPD_FRT_AMT    = PSD.BKG_PPD_FRT_AMT, \n");
		mergeQuery01.append("                      TBL.BKG_PPD_OTR_AMT    = PSD.BKG_PPD_OTR_AMT, \n");
		mergeQuery01.append("                      TBL.BKG_CLT_FRT_AMT    = PSD.BKG_CLT_FRT_AMT, \n");
		mergeQuery01.append("                      TBL.BKG_CLT_OTR_AMT    = PSD.BKG_CLT_OTR_AMT, \n");
		mergeQuery01.append("                      TBL.SPCL_DG_CGO_FLG    = PSD.SPCL_DG_CGO_FLG, \n");
		mergeQuery01.append("                      TBL.SPCL_RC_FLG        = PSD.SPCL_RC_FLG, \n");
		mergeQuery01.append("                      TBL.SPCL_AWK_CGO_FLG   = PSD.SPCL_AWK_CGO_FLG, \n");
		mergeQuery01.append("                      TBL.SPCL_BB_CGO_FLG    = PSD.SPCL_BB_CGO_FLG, \n");
		mergeQuery01.append("                      TBL.SPCL_RD_CGO_FLG    = PSD.SPCL_RD_CGO_FLG, \n");
		mergeQuery01.append("                      TBL.BKG_OFC_CD         = PSD.BKG_OFC_CD, \n");
		mergeQuery01.append("                      TBL.SLS_OFC_CD         = PSD.SLS_OFC_CD, \n");
		mergeQuery01.append("                      TBL.RHQ_CD             = PSD.RHQ_CD, \n");
		mergeQuery01.append("                      TBL.BKG_SOC_FLG        = PSD.BKG_SOC_FLG, \n");
		mergeQuery01.append("                      TBL.BKG_DBL_FLG        = PSD.BKG_DBL_FLG, \n");
		mergeQuery01.append("                      TBL.BKG_CRE_DT         = PSD.BKG_CRE_DT, \n");
		mergeQuery01.append("                      TBL.ESTM_IOC_DIV_CD    = PSD.ESTM_IOC_DIV_CD, \n");
		mergeQuery01.append("                      TBL.UPD_DT             = PSD.UPD_DT \n");
		mergeQuery01.append("      WHEN NOT MATCHED \n");
		mergeQuery01.append("      THEN \n");
		mergeQuery01.append("               INSERT \n");
		mergeQuery01.append("                    ( \n");
		mergeQuery01.append("                      TBL.BKG_NO, \n");
		mergeQuery01.append("                      TBL.COMM_PROC_RSLT_RSN, \n");
		mergeQuery01.append("                      TBL.BL_NO, \n");
		mergeQuery01.append("                      TBL.BKG_CGO_TP_CD, \n");
		mergeQuery01.append("                      TBL.BKG_STS_CD, \n");
		mergeQuery01.append("                      TBL.SHPR_CNT_CD, \n");
		mergeQuery01.append("                      TBL.SHPR_SEQ, \n");
		mergeQuery01.append("                      TBL.FRT_FWRD_CNT_CD, \n");
		mergeQuery01.append("                      TBL.FRT_FWRD_SEQ, \n");
		mergeQuery01.append("                      TBL.RLANE_CD, \n");
		mergeQuery01.append("                      TBL.REV_VVD_CD, \n");
		mergeQuery01.append("                      TBL.TRNK_SLAN_CD, \n");
		mergeQuery01.append("                      TBL.TRNK_RLANE_CD, \n");
		mergeQuery01.append("                      TBL.TRNK_VSL_CD, \n");
		mergeQuery01.append("                      TBL.TRNK_SKD_VOY_NO, \n");
		mergeQuery01.append("                      TBL.TRNK_SKD_DIR_CD, \n");
		mergeQuery01.append("                      TBL.TRNK_REV_DIR_CD, \n");
		mergeQuery01.append("                      TBL.SVC_SCP_CD, \n");
		mergeQuery01.append("                      TBL.BKG_CA_NO, \n");
		mergeQuery01.append("                      TBL.BKG_CA_DT, \n");
		mergeQuery01.append("                      TBL.TRD_CD, \n");
		mergeQuery01.append("                      TBL.BKG_POR_CD, \n");
		mergeQuery01.append("                      TBL.BKG_POL_CD, \n");
		mergeQuery01.append("                      TBL.BKG_POD_CD, \n");
		mergeQuery01.append("                      TBL.BKG_DEL_CD, \n");
		mergeQuery01.append("                      TBL.BKG_RCV_TERM_CD, \n");
		mergeQuery01.append("                      TBL.BKG_DE_TERM_CD, \n");
		mergeQuery01.append("                      TBL.PRE_PORT_CD, \n");
		mergeQuery01.append("                      TBL.PST_PORT_CD, \n");
		mergeQuery01.append("                      TBL.FMC_NO, \n");
		mergeQuery01.append("                      TBL.REP_CMDT_CD, \n");
		mergeQuery01.append("                      TBL.CMDT_CD, \n");
		mergeQuery01.append("                      TBL.SC_NO, \n");
		mergeQuery01.append("                      TBL.RFA_NO, \n");
		mergeQuery01.append("                      TBL.BKG_PPD_FRT_AMT, \n");
		mergeQuery01.append("                      TBL.BKG_PPD_OTR_AMT, \n");
		mergeQuery01.append("                      TBL.BKG_CLT_FRT_AMT, \n");
		mergeQuery01.append("                      TBL.BKG_CLT_OTR_AMT, \n");
		mergeQuery01.append("                      TBL.SPCL_DG_CGO_FLG, \n");
		mergeQuery01.append("                      TBL.SPCL_RC_FLG, \n");
		mergeQuery01.append("                      TBL.SPCL_AWK_CGO_FLG, \n");
		mergeQuery01.append("                      TBL.SPCL_BB_CGO_FLG, \n");
		mergeQuery01.append("                      TBL.SPCL_RD_CGO_FLG, \n");
		mergeQuery01.append("                      TBL.BKG_OFC_CD, \n");
		mergeQuery01.append("                      TBL.SLS_OFC_CD, \n");
		mergeQuery01.append("                      TBL.RHQ_CD, \n");
		mergeQuery01.append("                      TBL.BKG_SOC_FLG, \n");
		mergeQuery01.append("                      TBL.BKG_DBL_FLG, \n");
		mergeQuery01.append("                      TBL.BKG_CRE_DT, \n");
		mergeQuery01.append("                      TBL.ESTM_IOC_DIV_CD, \n");
		mergeQuery01.append("                      TBL.UPD_USR_ID, \n");
		mergeQuery01.append("                      TBL.UPD_DT, \n");
		mergeQuery01.append("                      TBL.CRE_USR_ID, \n");
		mergeQuery01.append("                      TBL.CRE_DT \n");
		mergeQuery01.append("                    ) \n");
		mergeQuery01.append("               VALUES \n");
		mergeQuery01.append("                    ( \n");
		mergeQuery01.append("                      PSD.BKG_NO, \n");
		mergeQuery01.append("                      PSD.COMM_PROC_RSLT_RSN, \n");
		mergeQuery01.append("                      PSD.BL_NO, \n");
		mergeQuery01.append("                      PSD.BKG_CGO_TP_CD, \n");
		mergeQuery01.append("                      PSD.BKG_STS_CD, \n");
		mergeQuery01.append("                      PSD.SHPR_CNT_CD, \n");
		mergeQuery01.append("                      PSD.SHPR_SEQ, \n");
		mergeQuery01.append("                      PSD.FRT_FWRD_CNT_CD, \n");
		mergeQuery01.append("                      PSD.FRT_FWRD_SEQ, \n");
		mergeQuery01.append("                      PSD.RLANE_CD, \n");
		mergeQuery01.append("                      PSD.REV_VVD_CD, \n");
		mergeQuery01.append("                      PSD.TRNK_SLAN_CD, \n");
		mergeQuery01.append("                      PSD.TRNK_RLANE_CD, \n");
		mergeQuery01.append("                      PSD.TRNK_VSL_CD, \n");
		mergeQuery01.append("                      PSD.TRNK_SKD_VOY_NO, \n");
		mergeQuery01.append("                      PSD.TRNK_SKD_DIR_CD, \n");
		mergeQuery01.append("                      PSD.TRNK_REV_DIR_CD, \n");
		mergeQuery01.append("                      PSD.SVC_SCP_CD, \n");
		mergeQuery01.append("                      PSD.BKG_CA_NO, \n");
		mergeQuery01.append("                      PSD.BKG_CA_DT, \n");
		mergeQuery01.append("                      PSD.TRD_CD, \n");
		mergeQuery01.append("                      PSD.BKG_POR_CD, \n");
		mergeQuery01.append("                      PSD.BKG_POL_CD, \n");
		mergeQuery01.append("                      PSD.BKG_POD_CD, \n");
		mergeQuery01.append("                      PSD.BKG_DEL_CD, \n");
		mergeQuery01.append("                      PSD.BKG_RCV_TERM_CD, \n");
		mergeQuery01.append("                      PSD.BKG_DE_TERM_CD, \n");
		mergeQuery01.append("                      PSD.PRE_PORT_CD, \n");
		mergeQuery01.append("                      PSD.PST_PORT_CD, \n");
		mergeQuery01.append("                      PSD.FMC_NO, \n");
		mergeQuery01.append("                      PSD.REP_CMDT_CD, \n");
		mergeQuery01.append("                      PSD.CMDT_CD, \n");
		mergeQuery01.append("                      PSD.SC_NO, \n");
		mergeQuery01.append("                      PSD.RFA_NO, \n");
		mergeQuery01.append("                      PSD.BKG_PPD_FRT_AMT, \n");
		mergeQuery01.append("                      PSD.BKG_PPD_OTR_AMT, \n");
		mergeQuery01.append("                      PSD.BKG_CLT_FRT_AMT, \n");
		mergeQuery01.append("                      PSD.BKG_CLT_OTR_AMT, \n");
		mergeQuery01.append("                      PSD.SPCL_DG_CGO_FLG, \n");
		mergeQuery01.append("                      PSD.SPCL_RC_FLG, \n");
		mergeQuery01.append("                      PSD.SPCL_AWK_CGO_FLG, \n");
		mergeQuery01.append("                      PSD.SPCL_BB_CGO_FLG, \n");
		mergeQuery01.append("                      PSD.SPCL_RD_CGO_FLG, \n");
		mergeQuery01.append("                      PSD.BKG_OFC_CD, \n");
		mergeQuery01.append("                      PSD.SLS_OFC_CD, \n");
		mergeQuery01.append("                      PSD.RHQ_CD, \n");
		mergeQuery01.append("                      PSD.BKG_SOC_FLG, \n");
		mergeQuery01.append("                      PSD.BKG_DBL_FLG, \n");
		mergeQuery01.append("                      PSD.BKG_CRE_DT, \n");
		mergeQuery01.append("                      PSD.ESTM_IOC_DIV_CD, \n");
		mergeQuery01.append("                      PSD.UPD_USR_ID, \n");
		mergeQuery01.append("                      PSD.UPD_DT, \n");
		mergeQuery01.append("                      PSD.CRE_USR_ID, \n");
		mergeQuery01.append("                      PSD.CRE_DT \n");
		mergeQuery01.append("                    ) \n");

		
		
		
		
		mergeQuery02.append("    MERGE  \n");
		mergeQuery02.append("     INTO AGT_BKG_REV_DTL TBL  \n");
		mergeQuery02.append("    USING  \n");
		mergeQuery02.append("        (  \n");
		mergeQuery02.append("               SELECT  \n");
		mergeQuery02.append("                 CASE  \n");
		mergeQuery02.append("                 WHEN CUR.BKG_NO IS NULL  \n");
		mergeQuery02.append("                 THEN PRE.BKG_NO  \n");
		mergeQuery02.append("                 ELSE CUR.BKG_NO  \n");
		mergeQuery02.append("                  END                                                            AS BKG_NO,  \n");
		mergeQuery02.append("                 CASE  \n");
		mergeQuery02.append("                 WHEN CUR.BKG_NO IS NULL  \n");
		mergeQuery02.append("                 THEN PRE.CNTR_TPSZ_CD  \n");
		mergeQuery02.append("                 ELSE CUR.CNTR_TPSZ_CD  \n");
		mergeQuery02.append("                  END                                                            AS CNTR_TPSZ_CD,  \n");
		mergeQuery02.append("                 CASE  \n");
		mergeQuery02.append("                 WHEN CUR.BKG_NO IS NULL  \n");
		mergeQuery02.append("                 THEN NULL  \n");
		mergeQuery02.append("                 ELSE CUR.BKG_VOL_QTY  \n");
		mergeQuery02.append("                  END                                                            AS BKG_VOL_QTY,  \n");
		mergeQuery02.append("                      0                                                          AS BKG_REV,  \n");
		mergeQuery02.append("                      0                                                          AS BKG_OFT_REV,  \n");
		mergeQuery02.append("                      'AGT SYSTEM'                                               AS CRE_USR_ID,  \n");
		mergeQuery02.append("                      SYSDATE                                                    AS CRE_DT,  \n");
		mergeQuery02.append("                      'AGT SYSTEM'                                               AS UPD_USR_ID,  \n");
		mergeQuery02.append("                      SYSDATE                                                    AS UPD_DT  \n");
		mergeQuery02.append("                 FROM  \n");
		mergeQuery02.append("                    (  \n");
		mergeQuery02.append("                          SELECT  \n");
		mergeQuery02.append("                                 BKG_NO,  \n");
		mergeQuery02.append("                                 CNTR_TPSZ_CD,  \n");
		mergeQuery02.append("                                 BKG_VOL_QTY \n");
		mergeQuery02.append("                            FROM AGT_BKG_REV_DTL  \n");
		mergeQuery02.append("                           WHERE BKG_NO = ? --'TPE038241700' \n");
		mergeQuery02.append("                    ) PRE  \n");
		mergeQuery02.append("           FULL OUTER  \n");
		mergeQuery02.append("                 JOIN  \n");
		mergeQuery02.append("                    (  \n");
		mergeQuery02.append("                          SELECT \n");
		mergeQuery02.append("                                 BKG.BKG_NO, \n");
		mergeQuery02.append("                                 QTY.CNTR_TPSZ_CD, \n");
		mergeQuery02.append("                                 SUM (QTY.OP_CNTR_QTY) AS BKG_VOL_QTY \n");
		mergeQuery02.append("                            FROM BKG_QUANTITY QTY, \n");
		mergeQuery02.append("                                 BKG_BL_DOC   DOC, \n");
		mergeQuery02.append("                                 BKG_BOOKING  BKG, \n");
		mergeQuery02.append("                                 BKG_BOOKING  BK2 \n");
		mergeQuery02.append("                           WHERE QTY.BKG_NO              = DOC.BKG_NO \n");
		mergeQuery02.append("                             AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");
		mergeQuery02.append("                             AND BK2.BKG_NO              = DOC.BKG_NO \n");
		mergeQuery02.append("                             AND BK2.BL_NO_TP          <>  '9' \n");
		mergeQuery02.append("                             AND BK2.BKG_STS_CD        <>  'X' \n");
		mergeQuery02.append("                             AND \n");
		mergeQuery02.append("                               ( \n");
		mergeQuery02.append("                                 BKG.BKG_NO              = DOC.BKG_NO \n");
		mergeQuery02.append("                              OR BKG.BL_NO               = DOC.MST_CVRD_BL_NO \n");
		mergeQuery02.append("                               ) \n");
		mergeQuery02.append("                             AND BKG.BKG_NO              = ? --'TPE038241700' \n");
		mergeQuery02.append("                        GROUP BY BKG.BKG_NO, \n");
		mergeQuery02.append("                                 QTY.CNTR_TPSZ_CD \n");
		mergeQuery02.append("                    ) CUR  \n");
		mergeQuery02.append("                   ON PRE.CNTR_TPSZ_CD = CUR.CNTR_TPSZ_CD  \n");
		mergeQuery02.append("         ) PCD  \n");
		mergeQuery02.append("        ON  \n");
		mergeQuery02.append("         ( TBL.BKG_NO       = PCD.BKG_NO  \n");
		mergeQuery02.append("       AND TBL.CNTR_TPSZ_CD = PCD.CNTR_TPSZ_CD  \n");
		mergeQuery02.append("         )  \n");
		mergeQuery02.append("      WHEN MATCHED  \n");
		mergeQuery02.append("      THEN  \n");
		mergeQuery02.append("               UPDATE  \n");
		mergeQuery02.append("                  SET TBL.BKG_VOL_QTY  = PCD.BKG_VOL_QTY,  \n");
		mergeQuery02.append("                      TBL.BKG_REV      = PCD.BKG_REV,  \n");
		mergeQuery02.append("                      TBL.BKG_OFT_REV  = PCD.BKG_OFT_REV,  \n");
		mergeQuery02.append("                      TBL.UPD_USR_ID   = PCD.UPD_USR_ID,  \n");
		mergeQuery02.append("                      TBL.UPD_DT       = PCD.UPD_DT  \n");
		mergeQuery02.append("               DELETE  \n");
		mergeQuery02.append("                WHERE PCD.BKG_VOL_QTY  IS NULL  \n");
		mergeQuery02.append("      WHEN NOT MATCHED  \n");
		mergeQuery02.append("      THEN  \n");
		mergeQuery02.append("               INSERT  \n");
		mergeQuery02.append("                    (  \n");
		mergeQuery02.append("                      BKG_NO,  \n");
		mergeQuery02.append("                      CNTR_TPSZ_CD,  \n");
		mergeQuery02.append("                      BKG_VOL_QTY,  \n");
		mergeQuery02.append("                      BKG_REV,  \n");
		mergeQuery02.append("                      BKG_OFT_REV,  \n");
		mergeQuery02.append("                      CRE_USR_ID,  \n");
		mergeQuery02.append("                      CRE_DT,  \n");
		mergeQuery02.append("                      UPD_USR_ID,  \n");
		mergeQuery02.append("                      UPD_DT  \n");
		mergeQuery02.append("                    )  \n");
		mergeQuery02.append("               VALUES  \n");
		mergeQuery02.append("                    (  \n");
		mergeQuery02.append("                      PCD.BKG_NO,  \n");
		mergeQuery02.append("                      PCD.CNTR_TPSZ_CD,  \n");
		mergeQuery02.append("                      PCD.BKG_VOL_QTY,  \n");
		mergeQuery02.append("                      PCD.BKG_REV,  \n");
		mergeQuery02.append("                      PCD.BKG_OFT_REV,  \n");
		mergeQuery02.append("                      PCD.CRE_USR_ID,  \n");
		mergeQuery02.append("                      PCD.CRE_DT,  \n");
		mergeQuery02.append("                      PCD.UPD_USR_ID,  \n");
		mergeQuery02.append("                      PCD.UPD_DT  \n");
		mergeQuery02.append("                    ) \n");

		
		
		/* 2011.10.20 [CSR선반영] Surcharge Deduct 시 Route 반영 한 금액 공제되도록 로직 변경 
		      참고 SR_NO : SRM-201120844 (CSR 전환 중)
		
		   -POR, POL, POD, DEL Route 적용 된 적용 되도록 변경.  (LOC_CD --> RGN_CD --> CNT_CD --> NULL 순)
			쿼리에 D_POR, D_POL, D_POD, D_DEL 항목 추가 하여 조건 적용.
			(기존엔 Route 상관 없이 Max AMT를 적용 했음.)
		
		   -MAT_LOC_CNT 추가 적용.
			Route 기반으로 하면 아래 두가지 케이스가 동시 적용 되는 경우엔 적용 되는 수가 더 많은 AMT 를 가져 오기로 협의 (by 임종한 과장님)
			
			e.g.. 추가 로직에 따르면 아래 케이스는 1번 AMT 적용 하게 됨. 
			BKG Info --> Scope : IAA , Charge : PSC , CNTR_TP : D5 , POL : CNXGG , POD : SAJED 인 경우 
			 - pri chg case 1. POL:CN, POD:SA AMT:200
			 - pri chg case 2. POD:SAJED AMT:600 
		 */		
		

		mergeQuery03.append("                                                                                                                                                                                                           \n");
		mergeQuery03.append("                        MERGE                                                                                                                                                                              \n");
		mergeQuery03.append("                         INTO AGT_CHG_ROUT_REF TBL                                                                                                                                                         \n");
		mergeQuery03.append("                        USING                                                                                                                                                                              \n");
		mergeQuery03.append("                            (                                                                                                                                                                              \n");
		mergeQuery03.append("                                SELECT                                                                                                                                                                     \n");
		mergeQuery03.append("                                       TMP.BKG_NO,                                                                                                                                                     	\n");
		mergeQuery03.append("                                       TMP.CHG_CD,                                                                                                                                                         \n");
		mergeQuery03.append("                                       TMP.BKG_AGMT_UT_CD,                                                                                                                                                 \n");
		mergeQuery03.append("                                       TMP.CURR_CD,                                                                                                                                                        \n");
		mergeQuery03.append("                                       TMP.SPCL_CGO_CTNT,                                                                                                                                                  \n");
		mergeQuery03.append("                                       TMP.ROUT_TRF_RT,                                                                                                                                                    \n");
		mergeQuery03.append("                                       TMP.ROUT_TRF_RTO,                                                                                                                                                   \n");
		mergeQuery03.append("                                       TMP.COMM_PROC_STS_RSN,                                                                                                                                              \n");
		mergeQuery03.append("                                       TMP.CRE_USR_ID,                                                                                                                                                     \n");
		mergeQuery03.append("                                       TMP.CRE_DT,                                                                                                                                                         \n");
		mergeQuery03.append("                                       TMP.UPD_USR_ID,                                                                                                                                                     \n");
		mergeQuery03.append("                                       TMP.UPD_DT                                                                                                                                                          \n");
		mergeQuery03.append("                                                                                                                                                                                                           \n");
		mergeQuery03.append("                                  FROM                                                                                                                                                                     \n");
		mergeQuery03.append("                                     (                                                                                                                                                                     \n");
		mergeQuery03.append("                                                                                                                                                                                                           \n");
		mergeQuery03.append("                                       SELECT                                                                                                                                                              \n");
		mergeQuery03.append("                                              ARR.BKG_NO,                                                                                                                                                  \n");
		mergeQuery03.append("                                              SRT.CHG_CD,                                                                                                                                                  \n");
		mergeQuery03.append("                                              SRT.RAT_UT_CD                                                         AS BKG_AGMT_UT_CD,                                                                     \n");
		mergeQuery03.append("                                              SRT.CURR_CD                                                           AS CURR_CD,                                                                            \n");
		mergeQuery03.append("                                              NVL (SRT.PRC_CGO_TP_CD, '  ')                                         AS SPCL_CGO_CTNT,                                                                      \n");
		mergeQuery03.append("--                                            MAX (DECODE (NVL (PRF.FLT_PCT_TP_CD, '0'), 'F', SRT.SCG_AMT, '0'))    AS ROUT_TRF_RT,                                                                        \n");
		mergeQuery03.append("--                                            MAX (DECODE (NVL (PRF.FLT_PCT_TP_CD, '0'), 'P', SRT.SCG_AMT, '0'))    AS ROUT_TRF_RTO,                                                                       \n");
		mergeQuery03.append("                                              DECODE (NVL (PRF.FLT_PCT_TP_CD, '0'), 'F', SRT.SCG_AMT, '0')          AS ROUT_TRF_RT,                                                                        \n");
		mergeQuery03.append("                                              DECODE (NVL (PRF.FLT_PCT_TP_CD, '0'), 'P', SRT.SCG_AMT, '0')          AS ROUT_TRF_RTO,                                                                       \n");
		mergeQuery03.append("                                              ''                                                                    AS COMM_PROC_STS_RSN,                                                                  \n");
		mergeQuery03.append("                                              'AGT SYSTEM'                                                          AS CRE_USR_ID,                                                                         \n");
		mergeQuery03.append("                                              SYSDATE                                                               AS CRE_DT,                                                                             \n");
		mergeQuery03.append("                                              'AGT SYSTEM'                                                          AS UPD_USR_ID,                                                                         \n");
		mergeQuery03.append("                                              SYSDATE                                                               AS UPD_DT,                                                                             \n");
		mergeQuery03.append("                                                                                                                                                                                                           \n");
		mergeQuery03.append("                                              ROW_NUMBER () OVER                                                                                                                                           \n");
		mergeQuery03.append("                                              (                                                                                                                                                            \n");
		mergeQuery03.append("                                                  PARTITION BY ARR.BKG_NO,SRT.CHG_CD,SRT.RAT_UT_CD,SRT.CURR_CD,SRT.PRC_CGO_TP_CD,POL_DEF_CD,POD_DEF_CD,DEL_DEF_CD                                          \n");
		mergeQuery03.append("                                                  ORDER BY LENGTH(NVL(POR_DEF_CD,'*')) DESC                                                                                                                \n");
		mergeQuery03.append("                                              ) D_POR,                                                                                                                                                     \n");
		mergeQuery03.append("                                              ROW_NUMBER () OVER                                                                                                                                           \n");
		mergeQuery03.append("                                              (                                                                                                                                                            \n");
		mergeQuery03.append("                                                  PARTITION BY ARR.BKG_NO,SRT.CHG_CD,SRT.RAT_UT_CD,SRT.CURR_CD,SRT.PRC_CGO_TP_CD,POR_DEF_CD,POD_DEF_CD,DEL_DEF_CD                                          \n");
		mergeQuery03.append("                                                  ORDER BY LENGTH(NVL(POL_DEF_CD,'*')) DESC                                                                                                                \n");
		mergeQuery03.append("                                              ) D_POL,                                                                                                                                                     \n");
		mergeQuery03.append("                                              ROW_NUMBER () OVER                                                                                                                                           \n");
		mergeQuery03.append("                                              (                                                                                                                                                            \n");
		mergeQuery03.append("                                                  PARTITION BY ARR.BKG_NO,SRT.CHG_CD,SRT.RAT_UT_CD,SRT.CURR_CD,SRT.PRC_CGO_TP_CD,POR_DEF_CD,POL_DEF_CD,DEL_DEF_CD                                          \n");
		mergeQuery03.append("                                                  ORDER BY LENGTH(NVL(POD_DEF_CD,'*')) DESC                                                                                                                \n");
		mergeQuery03.append("                                              ) D_POD,                                                                                                                                                     \n");
		mergeQuery03.append("                                              ROW_NUMBER () OVER                                                                                                                                           \n");
		mergeQuery03.append("                                              (                                                                                                                                                            \n");
		mergeQuery03.append("                                                  PARTITION BY ARR.BKG_NO,SRT.CHG_CD,SRT.RAT_UT_CD,SRT.CURR_CD,SRT.PRC_CGO_TP_CD,POR_DEF_CD,POL_DEF_CD,POD_DEF_CD                                          \n");
		mergeQuery03.append("                                                  ORDER BY LENGTH(NVL(DEL_DEF_CD,'*')) DESC                                                                                                                \n");
		mergeQuery03.append("                                              ) D_DEL,                                                                                                                                                     \n");
		mergeQuery03.append("                                              ROW_NUMBER () OVER                                                                                                                                           \n");
		mergeQuery03.append("                                              (                                                                                                                                                            \n");
		mergeQuery03.append("                                                  PARTITION BY ARR.BKG_NO,SRT.CHG_CD,SRT.RAT_UT_CD,SRT.CURR_CD,SRT.PRC_CGO_TP_CD                                          									\n");
		mergeQuery03.append("                                                  ORDER BY NVL(length(POR_TP_CD||POL_TP_CD||POD_TP_CD||DEL_TP_CD),0) DESC                                                     \n");
		mergeQuery03.append("                                              ) MAT_LOC_CNT                                                                                                                                                \n");
		mergeQuery03.append("                                                                                                                                                                                                           \n");
		mergeQuery03.append("                                                                                                                                                                                                           \n");
		mergeQuery03.append("                                         FROM PRI_SCG_RT  SRT,                                                                                                                                             \n");
		mergeQuery03.append("                                              PRI_SCG_PRF PRF,                                                                                                                                             \n");
		mergeQuery03.append("                                              MDM_LOCATION POR,                                                                                                                                            \n");
		mergeQuery03.append("                                              MDM_LOCATION POL,                                                                                                                                            \n");
		mergeQuery03.append("                                              MDM_LOCATION POD,                                                                                                                                            \n");
		mergeQuery03.append("                                              MDM_LOCATION DEL,                                                                                                                                            \n");
		mergeQuery03.append("                                              (                                                                                                                                                            \n");
		mergeQuery03.append("                                           ---------------------------------------------------------------------------------------------------------------------                                           \n");
		mergeQuery03.append("                                               SELECT                                                                                                                                                      \n");
		mergeQuery03.append("                                                      BKG.BKG_NO,                                                                                                                                          \n");
		mergeQuery03.append("                                                      BKG.SVC_SCP_CD,                                                                                                                                      \n");
		mergeQuery03.append("                                                      BKG.RCV_TERM_CD,                                                                                                                                     \n");
		mergeQuery03.append("                                                      BKG.DE_TERM_CD,                                                                                                                                      \n");
		mergeQuery03.append("                                                      BKG.CMDT_CD,                                                                                                                                         \n");
		mergeQuery03.append("                                                      BKG.SOC_FLG,                                                                                                                                         \n");
		mergeQuery03.append("                                                      BKG.POL_NOD_CD,                                                                                                                                      \n");
		mergeQuery03.append("                                                      BKG.POD_NOD_CD,                                                                                                                                      \n");
		mergeQuery03.append("                                                      BKG.ORG_TRNS_MOD_CD,                                                                                                                                 \n");
		mergeQuery03.append("                                                      BKG.DEST_TRNS_MOD_CD,                                                                                                                                \n");
		mergeQuery03.append("                                                      BKG.POR_CD,                                                                                                                                          \n");
		mergeQuery03.append("                                                      BKG.POL_CD,                                                                                                                                          \n");
		mergeQuery03.append("                                                      BKG.POD_CD,                                                                                                                                          \n");
		mergeQuery03.append("                                                      BKG.DEL_CD,                                                                                                                                          \n");
		mergeQuery03.append("                                           --;)-----------------------------------------------------------------------------------------------                                                             \n");
		mergeQuery03.append("                                           --;) <APPLICATION DATE>                                                                                                                                         \n");
		mergeQuery03.append("                                           --;) 1. RATE APPLICATION DATE를 구한다.                                                                                                                           \n");
		mergeQuery03.append("                                           --;) 2. CARGO RECEIVE DATE를 구한다.                                                                                                                              \n");
		mergeQuery03.append("                                           --;) 3. 첫 출항 일자를 구한다.                                                                                                                                       \n");
		mergeQuery03.append("                                           --;)-----------------------------------------------------------------------------------------------                                                             \n");
		mergeQuery03.append("                                                 CASE                                                                                                                                                      \n");
		mergeQuery03.append("                                                 WHEN RAT.RT_APLY_DT IS NOT NULL                                                                                                                           \n");
		mergeQuery03.append("                                                 THEN RAT.RT_APLY_DT                                                                                                                                       \n");
		mergeQuery03.append("                                                 WHEN RAT.RT_APLY_DT IS NULL                                                                                                                               \n");
		mergeQuery03.append("                                                  AND                                                                                                                                                      \n");
		mergeQuery03.append("                                                    (                                                                                                                                                      \n");
		mergeQuery03.append("                                                          SELECT                                                                                                                                           \n");
		mergeQuery03.append("                                                                 SUM (CNTR_VOL_QTY) Y1                                                                                                                     \n");
		mergeQuery03.append("                                                            FROM BKG_CONTAINER                                                                                                                             \n");
		mergeQuery03.append("                                                           WHERE BKG_NO = BKG.BKG_NO                                                                                                                       \n");
		mergeQuery03.append("                                                    )                                                                                                                                                      \n");
		mergeQuery03.append("                                                    =                                                                                                                                                      \n");
		mergeQuery03.append("                                                    (                                                                                                                                                      \n");
		mergeQuery03.append("                                                          SELECT                                                                                                                                           \n");
		mergeQuery03.append("                                                                 NVL (SUM (QTY.OP_CNTR_QTY), 0)                                                                                                            \n");
		mergeQuery03.append("                                                            FROM BKG_QUANTITY QTY                                                                                                                          \n");
		mergeQuery03.append("                                                           WHERE QTY.BKG_NO = BKG.BKG_NO                                                                                                                   \n");
		mergeQuery03.append("                                                             AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'                                                                                                            \n");
		mergeQuery03.append("                                                    )                                                                                                                                                      \n");
		mergeQuery03.append("                                                  AND SUBSTR (BKG.POR_CD, 1, 2) = 'US'                                                                                                                     \n");
		mergeQuery03.append("                                                   OR SUBSTR (BKG.POR_CD, 1, 2) = 'MX'                                                                                                                     \n");
		mergeQuery03.append("                                                   OR SUBSTR (BKG.POR_CD, 1, 2) = 'CA'                                                                                                                     \n");
		mergeQuery03.append("                                                   OR SUBSTR (BKG.POR_CD, 1, 2) = 'BR'                                                                                                                     \n");
		mergeQuery03.append("                                                   OR SUBSTR (BKG.DEL_CD, 1, 2) = 'US'                                                                                                                     \n");
		mergeQuery03.append("                                                   OR SUBSTR (BKG.DEL_CD, 1, 2) = 'MX'                                                                                                                     \n");
		mergeQuery03.append("                                                   OR SUBSTR (BKG.DEL_CD, 1, 2) = 'CA'                                                                                                                     \n");
		mergeQuery03.append("                                                   OR SUBSTR (BKG.DEL_CD, 1, 2) = 'BR'                                                                                                                     \n");
		mergeQuery03.append("                                                 THEN                                                                                                                                                      \n");
		mergeQuery03.append("                                                    (                                                                                                                                                      \n");
		mergeQuery03.append("                                                          SELECT                                                                                                                                           \n");
		mergeQuery03.append("                                                            CASE                                                                                                                                           \n");
		mergeQuery03.append("                                                            WHEN MAX (A.CGO_RCV_DT) IS NULL THEN NULL                                                                                                      \n");
		mergeQuery03.append("                                                            WHEN MAX (A.CGO_RCV_DT) + 180 > SYSDATE                                                                                                        \n");
		mergeQuery03.append("                                                            THEN MAX (A.CGO_RCV_DT)                                                                                                                        \n");
		mergeQuery03.append("                                                            ELSE NULL                                                                                                                                      \n");
		mergeQuery03.append("                                                             END RT_APLY_DT                                                                                                                                \n");
		mergeQuery03.append("                                                            FROM BKG_CONTAINER A,                                                                                                                          \n");
		mergeQuery03.append("                                                                 BKG_BOOKING B                                                                                                                             \n");
		mergeQuery03.append("                                                           WHERE A.BKG_NO = BKG.BKG_NO                                                                                                                     \n");
		mergeQuery03.append("                                                             AND B.BKG_NO = BKG.BKG_NO                                                                                                                     \n");
		mergeQuery03.append("                                                    )                                                                                                                                                      \n");
		mergeQuery03.append("                                                 ELSE                                                                                                                                                      \n");
		mergeQuery03.append("                                                    (                                                                                                                                                      \n");
		mergeQuery03.append("                                                          SELECT                                                                                                                                           \n");
		mergeQuery03.append("                                                                 MAX (INIT_ETD_DT)                                                                                                                         \n");
		mergeQuery03.append("                                                            FROM BKG_BOOKING      BK,                                                                                                                      \n");
		mergeQuery03.append("                                                                 BKG_VVD          VVD,                                                                                                                     \n");
		mergeQuery03.append("                                                                 VSK_VSL_PORT_SKD VSK                                                                                                                      \n");
		mergeQuery03.append("                                                           WHERE BK.BKG_NO        = BKG.BKG_NO                                                                                                             \n");
		mergeQuery03.append("                                                             AND BK.BKG_NO        = VVD.BKG_NO                                                                                                             \n");
		mergeQuery03.append("                                                             AND BK.POL_CD        = VVD.POL_CD                                                                                                             \n");
		mergeQuery03.append("                                                             AND VVD.VSL_CD       = VSK.VSL_CD                                                                                                             \n");
		mergeQuery03.append("                                                             AND VVD.SKD_VOY_NO   = VSK.SKD_VOY_NO                                                                                                         \n");
		mergeQuery03.append("                                                             AND VVD.SKD_DIR_CD   = VSK.SKD_DIR_CD                                                                                                         \n");
		mergeQuery03.append("                                                             AND VVD.POL_CD       = VSK.VPS_PORT_CD                                                                                                        \n");
		mergeQuery03.append("                                                    )                                                                                                                                                      \n");
		mergeQuery03.append("                                                  END AS RT_APLY_DT,                                                                                                                                       \n");
		mergeQuery03.append("                                                 CASE                                                                                                                                                      \n");
		mergeQuery03.append("                                                 WHEN DEL.CML_ZN_FLG = 'Y'                                                                                                                                 \n");
		mergeQuery03.append("                                                  AND POD.RGN_CD                                                                                                                                           \n");
		mergeQuery03.append("                                                   IN                                                                                                                                                      \n");
		mergeQuery03.append("                                                    (                                                                                                                                                      \n");
		mergeQuery03.append("                                                      'UAG',                                                                                                                                               \n");
		mergeQuery03.append("                                                      'UAN',                                                                                                                                               \n");
		mergeQuery03.append("                                                      'UAS'                                                                                                                                                \n");
		mergeQuery03.append("                                                    )                                                                                                                                                      \n");
		mergeQuery03.append("                                                 THEN 'CZ'                                                                                                                                                 \n");
		mergeQuery03.append("                                                 ELSE 'NN'                                                                                                                                                 \n");
		mergeQuery03.append("                                                  END                                AS CML_ZN_CD,                                                                                                         \n");
		mergeQuery03.append("                                           --;)-----------------------------------------------------------------------------------------------                                                             \n");
		mergeQuery03.append("                                           --;) <USA SERVICE MODE CODE, 미국내륙운송 형태>                                                                   													\n");
		mergeQuery03.append("                                           --;) 지정한 USA SERVICE MODE CODE에 해당하는 BOOKING인 경우 부과되는 SURCHARGE임을 의미함.                                                                                 \n");
		mergeQuery03.append("                                           --;) - PORT: 근처                                                                                                                                                       																		\n");
		mergeQuery03.append("                                           --;) - LOCAL: 근처                                                                                                                                              																		\n");
		mergeQuery03.append("                                           --;) - MLB(Mini Land Bridge): 내륙 깊숙이까지                                                                                                                   																\n");
		mergeQuery03.append("                                           --;) - IPI(Interior Point Intermodal): 복합내륙운송                                                                                                             															\n");
		mergeQuery03.append("                                           --;)-----------------------------------------------------------------------------------------------                                                             \n");
		mergeQuery03.append("                                                 CASE                                                                                                                                                      \n");
		mergeQuery03.append("                                                 WHEN POD.CNT_CD          IN ('US', 'CA')                                                                                                                  \n");
		mergeQuery03.append("                                                  AND BKG.DE_TERM_CD  NOT IN ('D', 'H')                                                                                                                    \n");
		mergeQuery03.append("                                                  AND BKG.POD_CD           = BKG.DEL_CD                                                                                                                    \n");
		mergeQuery03.append("                                                 THEN 'PO'                                                                                                                                                 \n");
		mergeQuery03.append("                                                 WHEN POD.CNT_CD          IN ('US', 'CA')                                                                                                                  \n");
		mergeQuery03.append("                                                 THEN                                                                                                                                                      \n");
		mergeQuery03.append("                                                    (                                                                                                                                                      \n");
		mergeQuery03.append("                                                          SELECT                                                                                                                                           \n");
		mergeQuery03.append("                                                                 SUBSTR (SVC_MOD_CD, 1, 2)                                                                                                                 \n");
		mergeQuery03.append("                                                            FROM COA_USA_SVC_MOD A                                                                                                                         \n");
		mergeQuery03.append("                                                           WHERE A.ORG_RGN_CD  = POD.RGN_CD                                                                                                                \n");
		mergeQuery03.append("                                                             AND A.DEST_RGN_CD = DEL.RGN_CD                                                                                                                \n");
		mergeQuery03.append("                                                    )                                                                                                                                                      \n");
		mergeQuery03.append("                                                 WHEN POL.CNT_CD          IN ('US', 'CA')                                                                                                                  \n");
		mergeQuery03.append("                                                  AND BKG.RCV_TERM_CD NOT IN ('D', 'H')                                                                                                                    \n");
		mergeQuery03.append("                                                  AND BKG.POL_CD           = BKG.POR_CD                                                                                                                    \n");
		mergeQuery03.append("                                                 THEN 'PO'                                                                                                                                                 \n");
		mergeQuery03.append("                                                 WHEN POL.CNT_CD          IN ('US', 'CA')                                                                                                                  \n");
		mergeQuery03.append("                                                 THEN                                                                                                                                                      \n");
		mergeQuery03.append("                                                    (                                                                                                                                                      \n");
		mergeQuery03.append("                                                          SELECT                                                                                                                                           \n");
		mergeQuery03.append("                                                                 SUBSTR (SVC_MOD_CD, 1, 2)                                                                                                                 \n");
		mergeQuery03.append("                                                            FROM COA_USA_SVC_MOD A                                                                                                                         \n");
		mergeQuery03.append("                                                           WHERE A.ORG_RGN_CD  = POL.RGN_CD                                                                                                                \n");
		mergeQuery03.append("                                                             AND A.DEST_RGN_CD = POR.RGN_CD                                                                                                                \n");
		mergeQuery03.append("                                                    )                                                                                                                                                      \n");
		mergeQuery03.append("                                                  END                                                                              AS USA_SVC_MOD_CD,                                                      \n");
		mergeQuery03.append("                                           --;)-----------------------------------------------------------------------------------------------                                                             \n");
		mergeQuery03.append("                                           --;) <DIRECT CALLING FLAG>                                                                                                                                      \n");
		mergeQuery03.append("                                           --;) TRANSHIPMENT 없는 경우에만 적용되는 SURCHARGE임을 의미함.                                                                                                  		\n");
		mergeQuery03.append("                                           --;)-----------------------------------------------------------------------------------------------                                                             \n");
		mergeQuery03.append("                                                      DECODE (BKG.PRE_RLY_PORT_CD||BKG.PST_RLY_PORT_CD, NULL, 'Y', 'N')            AS DIR_CALL_FLG                                                         \n");
		mergeQuery03.append("                                                 FROM BKG_BOOKING    BKG,                                                                                                                                  \n");
		mergeQuery03.append("                                                      BKG_RATE       RAT,                                                                                                                                  \n");
		mergeQuery03.append("                                                      MDM_LOCATION   POR,                                                                                                                                  \n");
		mergeQuery03.append("                                                      MDM_LOCATION   POL,                                                                                                                                  \n");
		mergeQuery03.append("                                                      MDM_LOCATION   POD,                                                                                                                                  \n");
		mergeQuery03.append("                                                      MDM_LOCATION   DEL                                                                                                                                   \n");
		mergeQuery03.append("                                                WHERE BKG.BKG_NO     = RAT.BKG_NO                                                                                                                          \n");
		mergeQuery03.append("                                                  AND POR.LOC_CD     = BKG.POR_CD                                                                                                                          \n");
		mergeQuery03.append("                                                  AND POL.LOC_CD     = BKG.POL_CD                                                                                                                          \n");
		mergeQuery03.append("                                                  AND POD.LOC_CD     = BKG.POD_CD                                                                                                                          \n");
		mergeQuery03.append("                                                  AND DEL.LOC_CD     = BKG.DEL_CD                                                                                                                          \n");
		mergeQuery03.append("                                                  AND POR.DELT_FLG   = 'N'                                                                                                                                 \n");
		mergeQuery03.append("                                                  AND POL.DELT_FLG   = 'N'                                                                                                                                 \n");
		mergeQuery03.append("                                                  AND POD.DELT_FLG   = 'N'                                                                                                                                 \n");
		mergeQuery03.append("                                                  AND DEL.DELT_FLG   = 'N'                                                                                                                                 \n");
		mergeQuery03.append("                                                  AND BKG.BKG_CRE_DT > TO_DATE ('20100405', 'YYYYMMDD')                                                                                                    \n");
		mergeQuery03.append("                                                  AND BKG.BKG_NO     =  ? --'CMB100645100'                                                                                                    				\n");
		mergeQuery03.append("                                           ---------------------------------------------------------------------------------------------------------------------                                           \n");
		mergeQuery03.append("                                                    ) ARR                                                                                                                                                  \n");
		mergeQuery03.append("                                   ---------------------------------------------------------------------------------------------------------------------                                                   \n");
		mergeQuery03.append("                                        WHERE SRT.SVC_SCP_CD           = ARR.SVC_SCP_CD                                                                                                                    \n");
		mergeQuery03.append("                                          AND PRF.SVC_SCP_CD           = ARR.SVC_SCP_CD                                                                                                                    \n");
		mergeQuery03.append("                                          AND PRF.SVC_SCP_CD           = SRT.SVC_SCP_CD                                                                                                                    \n");
		mergeQuery03.append("                                          AND PRF.CHG_CD               = SRT.CHG_CD                                                                                                                        \n");
		mergeQuery03.append("                                          AND SRT.DELT_FLG             = 'N'                                                                                                                               \n");
		mergeQuery03.append("                                          AND SRT.WDR_FLG              = 'N'                                                                                                                               \n");
		mergeQuery03.append("                                          AND ARR.POR_CD = POR.LOC_CD                                                                                                                                      \n");
		mergeQuery03.append("                                          AND ARR.POL_CD = POL.LOC_CD                                                                                                                                      \n");
		mergeQuery03.append("                                          AND ARR.POD_CD = POD.LOC_CD                                                                                                                                      \n");
		mergeQuery03.append("                                          AND ARR.DEL_CD = DEL.LOC_CD                                                                                                                                      \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.POR_USE_FLG, 'Y', SRT.POR_DEF_CD, '*'), '*') IN (POR.LOC_CD, POR.RGN_CD, POR.CNT_CD, '*' )                                                  \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.POL_USE_FLG, 'Y', SRT.POL_DEF_CD, '*'), '*') IN (POL.LOC_CD, POL.RGN_CD, POL.CNT_CD, '*' )                                                  \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.POD_USE_FLG, 'Y', SRT.POD_DEF_CD, '*'), '*') IN (POD.LOC_CD, POD.RGN_CD, POD.CNT_CD, '*' )                                                  \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.DEL_USE_FLG, 'Y', SRT.DEL_DEF_CD, '*'), '*') IN (DEL.LOC_CD, DEL.RGN_CD, DEL.CNT_CD, '*' )                                                  \n");
		mergeQuery03.append("                        --                  AND NVL (DECODE (PRF.POR_USE_FLG, 'Y', SRT.POR_DEF_CD, '*'), '*') = ARR.POR_DEF_CD                                                                             \n");
		mergeQuery03.append("                        --                  AND NVL (DECODE (PRF.POL_USE_FLG, 'Y', SRT.POL_DEF_CD, '*'), '*') = ARR.POL_DEF_CD                                                                             \n");
		mergeQuery03.append("                        --                  AND NVL (DECODE (PRF.POD_USE_FLG, 'Y', SRT.POD_DEF_CD, '*'), '*') = ARR.POD_DEF_CD                                                                             \n");
		mergeQuery03.append("                        --                  AND NVL (DECODE (PRF.DEL_USE_FLG, 'Y', SRT.DEL_DEF_CD, '*'), '*') = ARR.DEL_DEF_CD                                                                             \n");
		mergeQuery03.append("                                          AND PRF.CHG_CD                                                                                                                                                   \n");
		mergeQuery03.append("                                           IN                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                                 CASE                                                                                                                                                      \n");
		mergeQuery03.append("                                                         WHEN TO_CHAR (ARR.RT_APLY_DT, 'YYYYMMDD') > '20101231' AND PRF.CHG_CD = 'FRC' THEN '*'                                                            \n");
		mergeQuery03.append("                                   --> CFM Charge(CFM)                                                                                                                                                     \n");
		mergeQuery03.append("                                   --;)-----------------------------------------------------------------------------------------------                                                                     \n");
		mergeQuery03.append("                                   --;) <CFM Charge>                                                                                                                                                       \n");
		mergeQuery03.append("                                   --;) RCV_TERM_CD 혹은 DE_TERM_CD가 'S'(CFS)일 때 부과되는 CHARGE                                                                                                        		\n");
		mergeQuery03.append("                                   --;)-----------------------------------------------------------------------------------------------                                                                     \n");
		mergeQuery03.append("                                                         WHEN PRF.CHG_CD      = 'CFR' AND ARR.RCV_TERM_CD = 'S' THEN 'CFR'                                                                                 \n");
		mergeQuery03.append("                                                         WHEN PRF.CHG_CD      = 'CFD' AND ARR.DE_TERM_CD  = 'S' THEN 'CFD'                                                                                 \n");
		mergeQuery03.append("                                                         WHEN PRF.CHG_CD      = 'CFR' THEN '*'                                                                                                             \n");
		mergeQuery03.append("                                                         WHEN PRF.CHG_CD      = 'CFD' THEN '*'                                                                                                             \n");
		mergeQuery03.append("                                                         /* R/D Term 에 따라 THC 공제 여부 체크 로직 추가 - 임종한 과장 요청[CHM-201111599]*/                                                              			\n");
		mergeQuery03.append("                                                         /* [THC 공제로직 변경사항]   CHM-201111599               */                                                                                       	\n");
		mergeQuery03.append("                                                         /*   - BKG의 term 중에 I/O/T가 있는 경우 해당 지역의 THC 불공제 */                                                                                			\n");
		mergeQuery03.append("                                                         /*   - BKG R term에 I 혹은 T가 있는 경우 - OTH 불공제                */                                                                           				\n");
		mergeQuery03.append("                                                         /*   - BKG D term에 O 혹은 T가 있는 경우 - DTH 불공제                */                                                                           				\n");
		mergeQuery03.append("                                                         WHEN PRF.CHG_CD      = 'THC'  AND(ARR.RCV_TERM_CD IN ('T','I','O') or ARR.DE_TERM_CD IN ('T','I','O')) THEN '*'                                   \n");
		mergeQuery03.append("                                                         WHEN PRF.CHG_CD      = 'OTH'  AND ARR.RCV_TERM_CD IN ('T','I') THEN '*'                                                                           \n");
		mergeQuery03.append("                                                         WHEN PRF.CHG_CD      = 'DTH'  AND ARR.DE_TERM_CD  IN ('T','O') THEN '*'                                                                           \n");
		mergeQuery03.append("                                                         /* R/D Term 에 따라 THC 공제 여부 체크 로직 추가 - 임종한 과장 요청[CHM-201111599]*/                                                              			\n");
		mergeQuery03.append("                                                         ELSE PRF.CHG_CD                                                                                                                                   \n");
		mergeQuery03.append("                                                 END                                                                                                                                                       \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> RECEIVE TERM                                                                                                                                                        \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.RCV_DE_TERM_USE_FLG, 'Y', SRT.PRC_RCV_TERM_CD, '*'), '*')                                                                                   \n");
		mergeQuery03.append("                                           IN                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              ARR.RCV_TERM_CD,                                                                                                                                             \n");
		mergeQuery03.append("                                              '*'                                                                                                                                                          \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> DELIVERY TERM                                                                                                                                                       \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.RCV_DE_TERM_USE_FLG, 'Y', SRT.PRC_DE_TERM_CD, '*'), '*')                                                                                    \n");
		mergeQuery03.append("                                           IN                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              ARR.DE_TERM_CD,                                                                                                                                              \n");
		mergeQuery03.append("                                              '*'                                                                                                                                                          \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> USA SVC MODE                                                                                                                                                        \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.USA_SVC_MOD_USE_FLG, 'Y', SRT.USA_SVC_MOD_CD, '*'), '*')                                                                                    \n");
		mergeQuery03.append("                                           IN                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              DECODE (ARR.USA_SVC_MOD_CD, 'CZ', ARR.CML_ZN_CD, ARR.USA_SVC_MOD_CD),                                                                                        \n");
		mergeQuery03.append("                                              '*'                                                                                                                                                          \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> DIRECT CALLING                                                                                                                                                      \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.DIR_CALL_USE_FLG, 'Y', SRT.DIR_CALL_FLG, '*'), '*')                                                                                         \n");
		mergeQuery03.append("                                           IN                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              ARR.DIR_CALL_FLG,                                                                                                                                            \n");
		mergeQuery03.append("                                              '*'                                                                                                                                                          \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> ORIGIN TRANSPORTATION MODE                                                                                                                                          \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.TRNS_MOD_USE_FLG, 'Y', SRT.ORG_TRSP_MOD_CD, '*'), '*')                                                                                      \n");
		mergeQuery03.append("                                           IN                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              ARR.ORG_TRNS_MOD_CD,                                                                                                                                         \n");
		mergeQuery03.append("                                              '*'                                                                                                                                                          \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> DESTINATION TRANSPORTATION MODE                                                                                                                                     \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.TRNS_MOD_USE_FLG, 'Y', SRT.DEST_TRSP_MOD_CD, '*'), '*')                                                                                     \n");
		mergeQuery03.append("                                           IN                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              ARR.DEST_TRNS_MOD_CD,                                                                                                                                        \n");
		mergeQuery03.append("                                              '*'                                                                                                                                                          \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> TERMINAL                                                                                                                                                            \n");
		mergeQuery03.append("                                          AND                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              PRF.TML_USE_FLG = 'N'                                                                                                                                        \n");
		mergeQuery03.append("                                           OR SRT.TML_CD     IS NULL                                                                                                                                       \n");
		mergeQuery03.append("                                           OR SRT.TML_CD      = ARR.POL_NOD_CD                                                                                                                             \n");
		mergeQuery03.append("                                           OR SRT.TML_CD      = ARR.POD_NOD_CD                                                                                                                             \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> TRANSSHIPMENT PORT                                                                                                                                                  \n");
		mergeQuery03.append("                                          AND                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              PRF.TS_PORT_USE_FLG = 'N'                                                                                                                                    \n");
		mergeQuery03.append("                                           OR SRT.TS_PORT_CD     IS NULL                                                                                                                                   \n");
		mergeQuery03.append("                                           OR EXISTS                                                                                                                                                       \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                                  SELECT                                                                                                                                                   \n");
		mergeQuery03.append("                                                         'X'                                                                                                                                               \n");
		mergeQuery03.append("                                                    FROM BKG_VVD    BVD                                                                                                                                    \n");
		mergeQuery03.append("                                                   WHERE BVD.BKG_NO   = ARR.BKG_NO                                                                                                                         \n");
		mergeQuery03.append("                                                     AND                                                                                                                                                   \n");
		mergeQuery03.append("                                                       (                                                                                                                                                   \n");
		mergeQuery03.append("                                                         BVD.POL_CD   = SRT.TS_PORT_CD                                                                                                                     \n");
		mergeQuery03.append("                                                      OR BVD.POL_CD   = SRT.TS_PORT_CD                                                                                                                     \n");
		mergeQuery03.append("                                                       )                                                                                                                                                   \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> IN/OUT GAGE                                                                                                                                                         \n");
		mergeQuery03.append("                                          AND                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              SRT.IO_GA_CD  IS NULL                                                                                                                                        \n");
		mergeQuery03.append("                                           OR EXISTS                                                                                                                                                       \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                                  SELECT                                                                                                                                                   \n");
		mergeQuery03.append("                                                         'X'                                                                                                                                               \n");
		mergeQuery03.append("                                                    FROM BKG_AWK_CGO AWK                                                                                                                                   \n");
		mergeQuery03.append("                                                   WHERE AWK.IN_GA_FLG    = 'Y'                                                                                                                            \n");
		mergeQuery03.append("                                                     AND AWK.BKG_NO       = ARR.BKG_NO                                                                                                                     \n");
		mergeQuery03.append("                                                     AND AWK.CNTR_TPSZ_CD = SRT.RAT_UT_CD                                                                                                                  \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> VESSEL SERVICE LANE CODE                                                                                                                                            \n");
		mergeQuery03.append("                                          AND                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              PRF.SLAN_USE_FLG = 'N'                                                                                                                                       \n");
		mergeQuery03.append("                                           OR SRT.VSL_SLAN_CD IS NULL                                                                                                                                      \n");
		mergeQuery03.append("                                           OR EXISTS                                                                                                                                                       \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                                  SELECT                                                                                                                                                   \n");
		mergeQuery03.append("                                                         'X'                                                                                                                                               \n");
		mergeQuery03.append("                                                    FROM BKG_VVD BVD                                                                                                                                       \n");
		mergeQuery03.append("                                                   WHERE BVD.BKG_NO  = ARR.BKG_NO                                                                                                                          \n");
		mergeQuery03.append("                                                     AND BVD.SLAN_CD = SRT.VSL_SLAN_CD                                                                                                                     \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> COMMODITY                                                                                                                                                           \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.CMDT_USE_FLG, 'Y', SRT.CMDT_CD, '*'), '*')                                                                                                  \n");
		mergeQuery03.append("                                           IN                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              ARR.CMDT_CD,                                                                                                                                                 \n");
		mergeQuery03.append("                                              '*'                                                                                                                                                          \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> SHIPPER'S OWN CONTAINER(S.O.C)                                                                                                                                      \n");
		mergeQuery03.append("                                          AND NVL (DECODE (PRF.SOC_USE_FLG, 'Y', SRT.SOC_FLG, '*'), '*')                                                                                                   \n");
		mergeQuery03.append("                                           IN                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              ARR.SOC_FLG,                                                                                                                                                 \n");
		mergeQuery03.append("                                              '*'                                                                                                                                                          \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> IMDG CLASS                                                                                                                                                          \n");
		mergeQuery03.append("                                          AND                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              PRF.IMDG_CLSS_USE_FLG = 'N'                                                                                                                                  \n");
		mergeQuery03.append("                                           OR SRT.SCG_IMDG_CLSS_CD  IS NULL                                                                                                                                \n");
		mergeQuery03.append("                                           OR EXISTS                                                                                                                                                       \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                                  SELECT                                                                                                                                                   \n");
		mergeQuery03.append("                                                         'X'                                                                                                                                               \n");
		mergeQuery03.append("                                                    FROM BKG_DG_CGO BDG                                                                                                                                    \n");
		mergeQuery03.append("                                                   WHERE BDG.BKG_NO            = ARR.BKG_NO                                                                                                                \n");
		mergeQuery03.append("                                                     AND BDG.CNTR_TPSZ_CD      = SRT.RAT_UT_CD                                                                                                             \n");
		mergeQuery03.append("                                                     AND BDG.IMDG_CLSS_CD    LIKE SRT.SCG_IMDG_CLSS_CD||'%'                                                                                                \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> SUB TRADE                                                                                                                                                           \n");
		mergeQuery03.append("                                   --;)-----------------------------------------------------------------------------------------------                                                                     \n");
		mergeQuery03.append("                                   --;) <SUB TRADE CODE>                                                                                                                                                   \n");
		mergeQuery03.append("                                   --;) 운송 서비스 Trade 내의 상세 Area 세분화 하여 Code 화 함                                                                                                            																\n");
		mergeQuery03.append("                                   --;) 지정한 SUB TRADE에 해당하는 BOOKING인 경우 부과되는 SURCHARGE임을 의미함.                                                                                          			\n");
		mergeQuery03.append("                                   --;)-----------------------------------------------------------------------------------------------                                                                     \n");
		mergeQuery03.append("                                          AND                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              PRF.SUB_TRD_USE_FLG  = 'N'                                                                                                                                   \n");
		mergeQuery03.append("                                           OR SRT.SUB_TRD_CD      IS NULL                                                                                                                                  \n");
		mergeQuery03.append("                                           OR SRT.SUB_TRD_CD                                                                                                                                               \n");
		mergeQuery03.append("                                           IN                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                                  SELECT                                                                                                                                                   \n");
		mergeQuery03.append("                                                         MDL.SUB_TRD_CD                                                                                                                                    \n");
		mergeQuery03.append("                                                    FROM BKG_VVD             BVD,                                                                                                                          \n");
		mergeQuery03.append("                                                         MDM_REV_LANE        MRL,                                                                                                                          \n");
		mergeQuery03.append("                                                         MDM_DTL_REV_LANE    MDL                                                                                                                           \n");
		mergeQuery03.append("                                                   WHERE MDL.FM_CONTI_CD     = ( SELECT X.CONTI_CD FROM MDM_LOCATION X WHERE X.LOC_CD = BVD.POL_CD )                                                       \n");
		mergeQuery03.append("                                                     AND MDL.TO_CONTI_CD     = ( SELECT x.CONTI_CD FROM MDM_LOCATION X WHERE X.LOC_CD = BVD.POL_CD )                                                       \n");
		mergeQuery03.append("                                                     AND MRL.VSL_SLAN_CD     = BVD.SLAN_CD                                                                                                                 \n");
		mergeQuery03.append("                                                     AND MDL.RLANE_CD        = MRL.RLANE_CD                                                                                                                \n");
		mergeQuery03.append("                                                     AND MDL.VSL_SLAN_DIR_CD = BVD.SKD_DIR_CD                                                                                                              \n");
		mergeQuery03.append("                                                     AND MRL.DELT_FLG        = 'N'                                                                                                                         \n");
		mergeQuery03.append("                                                     AND MDL.DELT_FLG        = 'N'                                                                                                                         \n");
		mergeQuery03.append("                                                     AND BVD.BKG_NO          = ARR.BKG_NO                                                                                                                  \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> DATE FROM                                                                                                                                                           \n");
		mergeQuery03.append("                                          AND ARR.RT_APLY_DT                                                                                                                                               \n");
		mergeQuery03.append("                                      BETWEEN SRT.EFF_DT                                                                                                                                                   \n");
		mergeQuery03.append("                                          AND SRT.EXP_DT                                                                                                                                                   \n");
		mergeQuery03.append("                                   --> DATE TO                                                                                                                                                             \n");
		mergeQuery03.append("                                          AND ARR.RT_APLY_DT                                                                                                                                               \n");
		mergeQuery03.append("                                      BETWEEN SRT.EFF_DT                                                                                                                                                   \n");
		mergeQuery03.append("                                          AND SRT.EXP_DT                                                                                                                                                   \n");
		mergeQuery03.append("                                   --> CARGO TYPE                                                                                                                                                          \n");
		mergeQuery03.append("                                          AND NVL(SRT.PRC_CGO_TP_CD, '*')                                                                                                                                  \n");
		mergeQuery03.append("                                           IN                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              'DR',                                                                                                                                                        \n");
		mergeQuery03.append("                                              'RF',                                                                                                                                                        \n");
		mergeQuery03.append("                                              'DG',                                                                                                                                                        \n");
		mergeQuery03.append("                                              'AK',                                                                                                                                                        \n");
		mergeQuery03.append("                                              'BB',                                                                                                                                                        \n");
		mergeQuery03.append("                                              '*'                                                                                                                                                          \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> SURCARGE GROUP COMMODITY ( GRI )                                                                                                                                    \n");
		mergeQuery03.append("                                          AND                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              PRF.GRI_CMDT_USE_FLG = 'N'                                                                                                                                   \n");
		mergeQuery03.append("                                           OR SRT.SCG_GRP_CMDT_CD IS NULL                                                                                                                                  \n");
		mergeQuery03.append("                                           OR EXISTS                                                                                                                                                       \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                                  SELECT                                                                                                                                                   \n");
		mergeQuery03.append("                                                         'X'                                                                                                                                               \n");
		mergeQuery03.append("                                                    FROM PRI_SCG_GRP_CMDT     GC,                                                                                                                          \n");
		mergeQuery03.append("                                                         PRI_SCG_GRP_CMDT_DTL GD                                                                                                                           \n");
		mergeQuery03.append("                                                   WHERE GD.SVC_SCP_CD         = GC.SVC_SCP_CD                                                                                                             \n");
		mergeQuery03.append("                                                     AND GD.CHG_CD             = GC.CHG_CD                                                                                                                 \n");
		mergeQuery03.append("                                                     AND GD.SCG_GRP_CMDT_SEQ   = GC.SCG_GRP_CMDT_SEQ                                                                                                       \n");
		mergeQuery03.append("                                                     AND GC.SVC_SCP_CD         = ARR.SVC_SCP_CD                                                                                                            \n");
		mergeQuery03.append("                                                     AND GC.CHG_CD             = SRT.CHG_CD                                                                                                                \n");
		mergeQuery03.append("                                                     AND GC.SCG_GRP_CMDT_CD    = SRT.SCG_GRP_CMDT_CD                                                                                                       \n");
		mergeQuery03.append("                                                     AND GD.CMDT_CD            = ARR.CMDT_CD                                                                                                               \n");
		mergeQuery03.append("                                                 )                                                                                                                                                         \n");
		mergeQuery03.append("                                           )                                                                                                                                                               \n");
		mergeQuery03.append("                                   --> CANAL TRANSIT CODE                                                                                                                                                  \n");
		mergeQuery03.append("                                         AND                                                                                                                                                               \n");
		mergeQuery03.append("                                           (                                                                                                                                                               \n");
		mergeQuery03.append("                                              PRF.CNL_TZ_FLG  = 'N'                                                                                                                                        \n");
		mergeQuery03.append("                                           OR SRT.CNL_TZ_CD  IS NULL                                                                                                                                       \n");
		mergeQuery03.append("                                           OR EXISTS                                                                                                                                                       \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                                  SELECT                                                                                                                                                   \n");
		mergeQuery03.append("                                                         'X'                                                                                                                                               \n");
		mergeQuery03.append("                                                    FROM BKG_VVD          BV,                                                                                                                              \n");
		mergeQuery03.append("                                                         VSK_VSL_PORT_SKD S1,                                                                                                                              \n");
		mergeQuery03.append("                                                         VSK_VSL_PORT_SKD S2,                                                                                                                              \n");
		mergeQuery03.append("                                                         VSK_VSL_PORT_SKD S3                                                                                                                               \n");
		mergeQuery03.append("                                                   WHERE BV.BKG_NO        = ARR.BKG_NO                                                                                                                     \n");
		mergeQuery03.append("                                                     AND S1.VSL_CD        = BV.VSL_CD                                                                                                                      \n");
		mergeQuery03.append("                                                     AND S1.SKD_VOY_NO    = BV.SKD_VOY_NO                                                                                                                  \n");
		mergeQuery03.append("                                                     AND S1.SKD_DIR_CD    = BV.SKD_DIR_CD                                                                                                                  \n");
		mergeQuery03.append("                                                     AND S1.VPS_PORT_CD   = BV.POL_CD                                                                                                                      \n");
		mergeQuery03.append("                                                     AND S1.CLPT_IND_SEQ  = BV.POL_CLPT_IND_SEQ                                                                                                            \n");
		mergeQuery03.append("                                                     AND S2.VSL_CD        = BV.VSL_CD                                                                                                                      \n");
		mergeQuery03.append("                                                     AND S2.SKD_VOY_NO    = BV.SKD_VOY_NO                                                                                                                  \n");
		mergeQuery03.append("                                                     AND S2.SKD_DIR_CD    = BV.SKD_DIR_CD                                                                                                                  \n");
		mergeQuery03.append("                                                     AND S2.VPS_PORT_CD   = BV.POD_CD                                                                                                                      \n");
		mergeQuery03.append("                                                     AND S2.CLPT_IND_SEQ  = BV.POD_CLPT_IND_SEQ                                                                                                            \n");
		mergeQuery03.append("                                                     AND S3.VSL_CD        = BV.VSL_CD                                                                                                                      \n");
		mergeQuery03.append("                                                     AND S3.SKD_VOY_NO    = BV.SKD_VOY_NO                                                                                                                  \n");
		mergeQuery03.append("                                                     AND S3.SKD_DIR_CD    = BV.SKD_DIR_CD                                                                                                                  \n");
		mergeQuery03.append("                                                     AND S3.VPS_PORT_CD   = DECODE (SRT.CNL_TZ_CD, 'P', 'PAPAC', 'S', 'EGSUC')                                                                             \n");
		mergeQuery03.append("                                                     AND S3.CLPT_SEQ                                                                                                                                       \n");
		mergeQuery03.append("                                                 BETWEEN S1.CLPT_SEQ                                                                                                                                       \n");
		mergeQuery03.append("                                                     AND S2.CLPT_SEQ                                                                                                                                       \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                   --> CARGO WEIGHT                                                                                                                                                        \n");
		mergeQuery03.append("                                          AND                                                                                                                                                              \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                              PRF.CGO_WGT_USE_FLG = 'N'                                                                                                                                    \n");
		mergeQuery03.append("                                           OR EXISTS                                                                                                                                                       \n");
		mergeQuery03.append("                                            (                                                                                                                                                              \n");
		mergeQuery03.append("                                                  SELECT                                                                                                                                                   \n");
		mergeQuery03.append("                                                         'X'                                                                                                                                               \n");
		mergeQuery03.append("                                                    FROM BKG_CONTAINER BCT                                                                                                                                 \n");
		mergeQuery03.append("                                                   WHERE BCT.BKG_NO      = ARR.BKG_NO                                                                                                                      \n");
		mergeQuery03.append("                                                     AND CNTR_TPSZ_CD    = SRT.RAT_UT_CD                                                                                                                   \n");
		mergeQuery03.append("                                                  HAVING 'Y' =                                                                                                                                             \n");
		mergeQuery03.append("                                                    CASE                                                                                                                                                   \n");
		mergeQuery03.append("                                                    WHEN TO_NUMBER (SRT.MIN_CGO_WGT) >= NVL (MIN (DECODE (BCT.WGT_UT_CD, 'LBS', BCT.CNTR_WGT * 0.45359, BCT.CNTR_WGT)), 0)                                 \n");
		mergeQuery03.append("                                                     AND TO_NUMBER (SRT.MAX_CGO_WGT) <  NVL (MIN (DECODE (BCT.WGT_UT_CD, 'LBS', BCT.CNTR_WGT * 0.45359, BCT.CNTR_WGT)), 0)                                 \n");
		mergeQuery03.append("                                                    THEN 'Y'                                                                                                                                               \n");
		mergeQuery03.append("                                                    ELSE 'N'                                                                                                                                               \n");
		mergeQuery03.append("                                                     END                                                                                                                                                   \n");
		mergeQuery03.append("                                               UNION ALL                                                                                                                                                   \n");
		mergeQuery03.append("                                                  SELECT                                                                                                                                                   \n");
		mergeQuery03.append("                                                         'X'                                                                                                                                               \n");
		mergeQuery03.append("                                                    FROM BKG_BL_DOC  BBC,                                                                                                                                  \n");
		mergeQuery03.append("                                                         BKG_QTY_DTL BQD                                                                                                                                   \n");
		mergeQuery03.append("                                                   WHERE BBC.BKG_NO    = ARR.BKG_NO                                                                                                                        \n");
		mergeQuery03.append("                                                     AND BBC.BKG_NO    = BQD.BKG_NO                                                                                                                        \n");
		mergeQuery03.append("                                                  HAVING 'Y' =                                                                                                                                             \n");
		mergeQuery03.append("                                                    CASE                                                                                                                                                   \n");
		mergeQuery03.append("                                                    WHEN 1 = SUM (BQD.OP_CNTR_QTY)                                                                                                                         \n");
		mergeQuery03.append("                                                     AND TO_NUMBER (SRT.MIN_CGO_WGT) >= NVL (MIN (DECODE (BBC.WGT_UT_CD, 'LBS', BBC.ACT_WGT * 0.45359, BBC.ACT_WGT)), 0)                                   \n");
		mergeQuery03.append("                                                     AND TO_NUMBER (SRT.MAX_CGO_WGT) <  NVL (MIN (DECODE (BBC.WGT_UT_CD, 'LBS', BBC.ACT_WGT * 0.45359, BBC.ACT_WGT)), 0)                                   \n");
		mergeQuery03.append("                                                    THEN 'Y'                                                                                                                                               \n");
		mergeQuery03.append("                                                    ELSE 'N'                                                                                                                                               \n");
		mergeQuery03.append("                                                     END                                                                                                                                                   \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                            )                                                                                                                                                              \n");
		mergeQuery03.append("                                                                                                                                                                                                           \n");
		mergeQuery03.append("                                                                                                                                                                                                           \n");
		mergeQuery03.append("--                                     GROUP BY ARR.BKG_NO,                                                                                                                                                \n");
		mergeQuery03.append("--                                              SRT.CHG_CD,                                                                                                                                                \n");
		mergeQuery03.append("--                                              SRT.RAT_UT_CD,                                                                                                                                             \n");
		mergeQuery03.append("--                                              SRT.CURR_CD,                                                                                                                                               \n");
		mergeQuery03.append("--                                              SRT.PRC_CGO_TP_CD                                                                                                                                          \n");
		mergeQuery03.append("                                                                                                                                                                                                           \n");
		mergeQuery03.append("                                                                                                                                                                                                           \n");
		mergeQuery03.append("                                     ) TMP                                                                                                                                                                 \n");
		mergeQuery03.append("                               WHERE D_POR = 1 AND D_POL = 1 AND D_POD = 1 AND D_DEL = 1 AND MAT_LOC_CNT = 1                                                                                              	\n");
		mergeQuery03.append("                            ) PCD                                                                                                                                                                          \n");
		mergeQuery03.append("                          ON                                                                                                                                                                               \n");
		mergeQuery03.append("                           ( TBL.BKG_NO         = PCD.BKG_NO                                                                                                                                               \n");
		mergeQuery03.append("                         AND TBL.CHG_CD         = PCD.CHG_CD                                                                                                                                               \n");
		mergeQuery03.append("                         AND TBL.BKG_AGMT_UT_CD = PCD.BKG_AGMT_UT_CD                                                                                                                                       \n");
		mergeQuery03.append("                         AND TBL.CURR_CD        = PCD.CURR_CD                                                                                                                                              \n");
		mergeQuery03.append("                         AND TBL.SPCL_CGO_CTNT  = PCD.SPCL_CGO_CTNT                                                                                                                                        \n");
		mergeQuery03.append("                           )                                                                                                                                                                               \n");
		mergeQuery03.append("                        WHEN MATCHED                                                                                                                                                                       \n");
		mergeQuery03.append("                        THEN                                                                                                                                                                               \n");
		mergeQuery03.append("                                 UPDATE                                                                                                                                                                    \n");
		mergeQuery03.append("                                    SET TBL.ROUT_TRF_RT  = PCD.ROUT_TRF_RT,                                                                                                                                \n");
		mergeQuery03.append("                                        TBL.ROUT_TRF_RTO = PCD.ROUT_TRF_RTO,                                                                                                                               \n");
		mergeQuery03.append("                                        TBL.UPD_USR_ID   = PCD.UPD_USR_ID,                                                                                                                                 \n");
		mergeQuery03.append("                                        TBL.UPD_DT       = PCD.UPD_DT                                                                                                                                      \n");
		mergeQuery03.append("                                 DELETE                                                                                                                                                                    \n");
		mergeQuery03.append("                                  WHERE PCD.ROUT_TRF_RT  IS NULL                                                                                                                                           \n");
		mergeQuery03.append("                                    AND PCD.ROUT_TRF_RTO IS NULL                                                                                                                                           \n");
		mergeQuery03.append("                        WHEN NOT MATCHED                                                                                                                                                                   \n");
		mergeQuery03.append("                        THEN                                                                                                                                                                               \n");
		mergeQuery03.append("                                 INSERT                                                                                                                                                                    \n");
		mergeQuery03.append("                                      (                                                                                                                                                                    \n");
		mergeQuery03.append("                                        BKG_NO,                                                                                                                                                            \n");
		mergeQuery03.append("                                        CHG_CD,                                                                                                                                                            \n");
		mergeQuery03.append("                                        BKG_AGMT_UT_CD,                                                                                                                                                    \n");
		mergeQuery03.append("                                        CURR_CD,                                                                                                                                                           \n");
		mergeQuery03.append("                                        SPCL_CGO_CTNT,                                                                                                                                                     \n");
		mergeQuery03.append("                                        ROUT_TRF_RT,                                                                                                                                                       \n");
		mergeQuery03.append("                                        ROUT_TRF_RTO,                                                                                                                                                      \n");
		mergeQuery03.append("                                        COMM_PROC_STS_RSN,                                                                                                                                                 \n");
		mergeQuery03.append("                                        CRE_USR_ID,                                                                                                                                                        \n");
		mergeQuery03.append("                                        CRE_DT,                                                                                                                                                            \n");
		mergeQuery03.append("                                        UPD_USR_ID,                                                                                                                                                        \n");
		mergeQuery03.append("                                        UPD_DT                                                                                                                                                             \n");
		mergeQuery03.append("                                      )                                                                                                                                                                    \n");
		mergeQuery03.append("                                 VALUES                                                                                                                                                                    \n");
		mergeQuery03.append("                                      (                                                                                                                                                                    \n");
		mergeQuery03.append("                                        PCD.BKG_NO,                                                                                                                                                        \n");
		mergeQuery03.append("                                        PCD.CHG_CD,                                                                                                                                                        \n");
		mergeQuery03.append("                                        PCD.BKG_AGMT_UT_CD,                                                                                                                                                \n");
		mergeQuery03.append("                                        PCD.CURR_CD,                                                                                                                                                       \n");
		mergeQuery03.append("                                        PCD.SPCL_CGO_CTNT,                                                                                                                                                 \n");
		mergeQuery03.append("                                        PCD.ROUT_TRF_RT,                                                                                                                                                   \n");
		mergeQuery03.append("                                        PCD.ROUT_TRF_RTO,                                                                                                                                                  \n");
		mergeQuery03.append("                                        PCD.COMM_PROC_STS_RSN,                                                                                                                                             \n");
		mergeQuery03.append("                                        PCD.CRE_USR_ID,                                                                                                                                                    \n");
		mergeQuery03.append("                                        PCD.CRE_DT,                                                                                                                                                        \n");
		mergeQuery03.append("                                        PCD.UPD_USR_ID,                                                                                                                                                    \n");
		mergeQuery03.append("                                        PCD.UPD_DT                                                                                                                                                         \n");
		mergeQuery03.append("                                      )                                                                                                                                                                    \n");
		mergeQuery03.append("                                                                                                                                                                                                           \n");

//		mergeQuery03.append(" \n");
//		mergeQuery03.append("        MERGE \n");
//		mergeQuery03.append("         INTO AGT_CHG_ROUT_REF TBL \n"); 
//		mergeQuery03.append("        USING  \n");
//		mergeQuery03.append("            (  \n");
//		mergeQuery03.append(" \n");
//		mergeQuery03.append("               SELECT \n"); 
//		mergeQuery03.append("                      ARR.BKG_NO, \n"); 
//		mergeQuery03.append("                      SRT.CHG_CD,  \n");
//		mergeQuery03.append("                      SRT.RAT_UT_CD                                                         AS BKG_AGMT_UT_CD, \n"); 
//		mergeQuery03.append("                      SRT.CURR_CD                                                           AS CURR_CD,  \n");
//		mergeQuery03.append("                      NVL (SRT.PRC_CGO_TP_CD, '  ')                                         AS SPCL_CGO_CTNT,  \n");
//		mergeQuery03.append("                      MAX (DECODE (NVL (PRF.FLT_PCT_TP_CD, '0'), 'F', SRT.SCG_AMT, '0'))    AS ROUT_TRF_RT,  \n");
//		mergeQuery03.append("                      MAX (DECODE (NVL (PRF.FLT_PCT_TP_CD, '0'), 'P', SRT.SCG_AMT, '0'))    AS ROUT_TRF_RTO,  \n");
//		mergeQuery03.append("                      ''                                                                    AS COMM_PROC_STS_RSN,  \n");
//		mergeQuery03.append("                      'AGT SYSTEM'                                                          AS CRE_USR_ID,  \n");
//		mergeQuery03.append("                      SYSDATE                                                               AS CRE_DT,  \n");
//		mergeQuery03.append("                      'AGT SYSTEM'                                                          AS UPD_USR_ID,  \n");
//		mergeQuery03.append("                      SYSDATE                                                               AS UPD_DT  \n");
//		mergeQuery03.append("                 FROM PRI_SCG_RT  SRT,  \n");
//		mergeQuery03.append("                      PRI_SCG_PRF PRF,  \n");
//		mergeQuery03.append("                      MDM_LOCATION POR,  \n");
//		mergeQuery03.append("                      MDM_LOCATION POL,  \n");
//		mergeQuery03.append("                      MDM_LOCATION POD,  \n");
//		mergeQuery03.append("                      MDM_LOCATION DEL,  \n");
//		mergeQuery03.append("                      ( \n");
//		mergeQuery03.append("                   --------------------------------------------------------------------------------------------------------------------- \n"); 
//		mergeQuery03.append("                       SELECT  \n");
//		mergeQuery03.append("                              BKG.BKG_NO, \n"); 
//		mergeQuery03.append("                              BKG.SVC_SCP_CD,  \n");
//		mergeQuery03.append("                              BKG.RCV_TERM_CD,  \n");
//		mergeQuery03.append("                              BKG.DE_TERM_CD,  \n");
//		mergeQuery03.append("                              BKG.CMDT_CD,  \n");
//		mergeQuery03.append("                              BKG.SOC_FLG,  \n");
//		mergeQuery03.append("                              BKG.POL_NOD_CD,  \n");
//		mergeQuery03.append("                              BKG.POD_NOD_CD,  \n");
//		mergeQuery03.append("                              BKG.ORG_TRNS_MOD_CD,  \n");
//		mergeQuery03.append("                              BKG.DEST_TRNS_MOD_CD,  \n");
//		mergeQuery03.append("                              BKG.POR_CD,  \n");
//		mergeQuery03.append("                              BKG.POL_CD,  \n");
//		mergeQuery03.append("                              BKG.POD_CD,  \n");
//		mergeQuery03.append("                              BKG.DEL_CD,  \n");
//		mergeQuery03.append("                   --;)----------------------------------------------------------------------------------------------- \n"); 
//		mergeQuery03.append("                   --;) <APPLICATION DATE>  \n");
//		mergeQuery03.append("                   --;) 1. RATE APPLICATION DATE를 구한다. \n"); 
//		mergeQuery03.append("                   --;) 2. CARGO RECEIVE DATE를 구한다.  \n");
//		mergeQuery03.append("                   --;) 3. 첫 출항 일자를 구한다.  \n");
//		mergeQuery03.append("                   --;)----------------------------------------------------------------------------------------------- \n"); 
//		mergeQuery03.append("                         CASE  \n");
//		mergeQuery03.append("                         WHEN RAT.RT_APLY_DT IS NOT NULL \n"); 
//		mergeQuery03.append("                         THEN RAT.RT_APLY_DT  \n");
//		mergeQuery03.append("                         WHEN RAT.RT_APLY_DT IS NULL \n"); 
//		mergeQuery03.append("                          AND \n"); 
//		mergeQuery03.append("                            ( \n"); 
//		mergeQuery03.append("                                  SELECT \n"); 
//		mergeQuery03.append("                                         SUM (CNTR_VOL_QTY) Y1 \n"); 
//		mergeQuery03.append("                                    FROM BKG_CONTAINER  \n");
//		mergeQuery03.append("                                   WHERE BKG_NO = BKG.BKG_NO \n"); 
//		mergeQuery03.append("                            ) \n"); 
//		mergeQuery03.append("                            = \n"); 
//		mergeQuery03.append("                            ( \n"); 
//		mergeQuery03.append("                                  SELECT \n"); 
//		mergeQuery03.append("                                         NVL (SUM (QTY.OP_CNTR_QTY), 0) \n"); 
//		mergeQuery03.append("                                    FROM BKG_QUANTITY QTY  \n");
//		mergeQuery03.append("                                   WHERE QTY.BKG_NO = BKG.BKG_NO  \n");
//		mergeQuery03.append("                                     AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'  \n");
//		mergeQuery03.append("                            ) \n"); 
//		mergeQuery03.append("                          AND SUBSTR (BKG.POR_CD, 1, 2) = 'US' \n"); 
//		mergeQuery03.append("                           OR SUBSTR (BKG.POR_CD, 1, 2) = 'MX' \n"); 
//		mergeQuery03.append("                           OR SUBSTR (BKG.POR_CD, 1, 2) = 'CA' \n"); 
//		mergeQuery03.append("                           OR SUBSTR (BKG.POR_CD, 1, 2) = 'BR' \n"); 
//		mergeQuery03.append("                           OR SUBSTR (BKG.DEL_CD, 1, 2) = 'US' \n"); 
//		mergeQuery03.append("                           OR SUBSTR (BKG.DEL_CD, 1, 2) = 'MX' \n"); 
//		mergeQuery03.append("                           OR SUBSTR (BKG.DEL_CD, 1, 2) = 'CA' \n"); 
//		mergeQuery03.append("                           OR SUBSTR (BKG.DEL_CD, 1, 2) = 'BR' \n"); 
//		mergeQuery03.append("                         THEN \n"); 
//		mergeQuery03.append("                            ( \n"); 
//		mergeQuery03.append("                                  SELECT \n"); 
//		mergeQuery03.append("                                    CASE \n"); 
//		mergeQuery03.append("                                    WHEN MAX (A.CGO_RCV_DT) IS NULL THEN NULL \n"); 
//		mergeQuery03.append("                                    WHEN MAX (A.CGO_RCV_DT) + 180 > SYSDATE \n"); 
//		mergeQuery03.append("                                    THEN MAX (A.CGO_RCV_DT) \n"); 
//		mergeQuery03.append("                                    ELSE NULL \n"); 
//		mergeQuery03.append("                                     END RT_APLY_DT  \n");
//		mergeQuery03.append("                                    FROM BKG_CONTAINER A, \n"); 
//		mergeQuery03.append("                                         BKG_BOOKING B \n"); 
//		mergeQuery03.append("                                   WHERE A.BKG_NO = BKG.BKG_NO \n"); 
//		mergeQuery03.append("                                     AND B.BKG_NO = BKG.BKG_NO \n"); 
//		mergeQuery03.append("                            ) \n"); 
//		mergeQuery03.append("                         ELSE \n"); 
//		mergeQuery03.append("                            ( \n"); 
//		mergeQuery03.append("                                  SELECT \n"); 
//		mergeQuery03.append("                                         MAX (INIT_ETD_DT) \n"); 
//		mergeQuery03.append("                                    FROM BKG_BOOKING      BK, \n"); 
//		mergeQuery03.append("                                         BKG_VVD          VVD, \n"); 
//		mergeQuery03.append("                                         VSK_VSL_PORT_SKD VSK \n"); 
//		mergeQuery03.append("                                   WHERE BK.BKG_NO        = BKG.BKG_NO \n"); 
//		mergeQuery03.append("                                     AND BK.BKG_NO        = VVD.BKG_NO \n"); 
//		mergeQuery03.append("                                     AND BK.POL_CD        = VVD.POL_CD \n"); 
//		mergeQuery03.append("                                     AND VVD.VSL_CD       = VSK.VSL_CD \n"); 
//		mergeQuery03.append("                                     AND VVD.SKD_VOY_NO   = VSK.SKD_VOY_NO \n"); 
//		mergeQuery03.append("                                     AND VVD.SKD_DIR_CD   = VSK.SKD_DIR_CD \n"); 
//		mergeQuery03.append("                                     AND VVD.POL_CD       = VSK.VPS_PORT_CD \n"); 
//		mergeQuery03.append("                            ) \n"); 
//		mergeQuery03.append("                          END AS RT_APLY_DT, \n"); 
//		mergeQuery03.append("                         CASE \n"); 
//		mergeQuery03.append("                         WHEN DEL.CML_ZN_FLG = 'Y' \n"); 
//		mergeQuery03.append("                          AND POD.RGN_CD \n"); 
//		mergeQuery03.append("                           IN \n"); 
//		mergeQuery03.append("                            ( \n"); 
//		mergeQuery03.append("                              'UAG', \n"); 
//		mergeQuery03.append("                              'UAN', \n"); 
//		mergeQuery03.append("                              'UAS' \n"); 
//		mergeQuery03.append("                            ) \n"); 
//		mergeQuery03.append("                         THEN 'CZ' \n"); 
//		mergeQuery03.append("                         ELSE 'NN' \n"); 
//		mergeQuery03.append("                          END                                AS CML_ZN_CD, \n"); 
//		mergeQuery03.append("                   --;)----------------------------------------------------------------------------------------------- \n"); 
//		mergeQuery03.append("                   --;) <USA SERVICE MODE CODE, 미국내륙운송 형태> \n"); 
//		mergeQuery03.append("                   --;) 지정한 USA SERVICE MODE CODE에 해당하는 BOOKING인 경우 부과되는 SURCHARGE임을 의미함. \n"); 
//		mergeQuery03.append("                   --;) - PORT: 근처 \n"); 
//		mergeQuery03.append("                   --;) - LOCAL: 근처 \n"); 
//		mergeQuery03.append("                   --;) - MLB(Mini Land Bridge): 내륙 깊숙이까지 \n"); 
//		mergeQuery03.append("                   --;) - IPI(Interior Point Intermodal): 복합내륙운송 \n"); 
//		mergeQuery03.append("                   --;)----------------------------------------------------------------------------------------------- \n"); 
//		mergeQuery03.append("                         CASE \n"); 
//		mergeQuery03.append("                         WHEN POD.CNT_CD          IN ('US', 'CA') \n"); 
//		mergeQuery03.append("                          AND BKG.DE_TERM_CD  NOT IN ('D', 'H') \n"); 
//		mergeQuery03.append("                          AND BKG.POD_CD           = BKG.DEL_CD \n"); 
//		mergeQuery03.append("                         THEN 'PO' \n"); 
//		mergeQuery03.append("                         WHEN POD.CNT_CD          IN ('US', 'CA') \n"); 
//		mergeQuery03.append("                         THEN \n"); 
//		mergeQuery03.append("                            ( \n"); 
//		mergeQuery03.append("                                  SELECT \n"); 
//		mergeQuery03.append("                                         SUBSTR (SVC_MOD_CD, 1, 2) \n"); 
//		mergeQuery03.append("                                    FROM COA_USA_SVC_MOD A \n"); 
//		mergeQuery03.append("                                   WHERE A.ORG_RGN_CD  = POD.RGN_CD \n"); 
//		mergeQuery03.append("                                     AND A.DEST_RGN_CD = DEL.RGN_CD \n"); 
//		mergeQuery03.append("                            ) \n"); 
//		mergeQuery03.append("                         WHEN POL.CNT_CD          IN ('US', 'CA') \n"); 
//		mergeQuery03.append("                          AND BKG.RCV_TERM_CD NOT IN ('D', 'H') \n"); 
//		mergeQuery03.append("                          AND BKG.POL_CD           = BKG.POR_CD \n"); 
//		mergeQuery03.append("                         THEN 'PO' \n"); 
//		mergeQuery03.append("                         WHEN POL.CNT_CD          IN ('US', 'CA') \n"); 
//		mergeQuery03.append("                         THEN \n"); 
//		mergeQuery03.append("                            (  \n");
//		mergeQuery03.append("                                  SELECT \n"); 
//		mergeQuery03.append("                                         SUBSTR (SVC_MOD_CD, 1, 2) \n"); 
//		mergeQuery03.append("                                    FROM COA_USA_SVC_MOD A \n"); 
//		mergeQuery03.append("                                   WHERE A.ORG_RGN_CD  = POL.RGN_CD \n"); 
//		mergeQuery03.append("                                     AND A.DEST_RGN_CD = POR.RGN_CD \n"); 
//		mergeQuery03.append("                            ) \n"); 
//		mergeQuery03.append("                          END                                                                              AS USA_SVC_MOD_CD, \n"); 
//		mergeQuery03.append("                   --;)----------------------------------------------------------------------------------------------- \n"); 
//		mergeQuery03.append("                   --;) <DIRECT CALLING FLAG> \n"); 
//		mergeQuery03.append("                   --;) TRANSHIPMENT 없는 경우에만 적용되는 SURCHARGE임을 의미함. \n"); 
//		mergeQuery03.append("                   --;)----------------------------------------------------------------------------------------------- \n"); 
//		mergeQuery03.append("                              DECODE (BKG.PRE_RLY_PORT_CD||BKG.PST_RLY_PORT_CD, NULL, 'Y', 'N')            AS DIR_CALL_FLG \n"); 
//		mergeQuery03.append("                         FROM BKG_BOOKING    BKG, \n"); 
//		mergeQuery03.append("                              BKG_RATE       RAT, \n"); 
//		mergeQuery03.append("                              MDM_LOCATION   POR, \n"); 
//		mergeQuery03.append("                              MDM_LOCATION   POL, \n"); 
//		mergeQuery03.append("                              MDM_LOCATION   POD, \n"); 
//		mergeQuery03.append("                              MDM_LOCATION   DEL \n");
//		mergeQuery03.append("                        WHERE BKG.BKG_NO     = RAT.BKG_NO \n"); 
//		mergeQuery03.append("                          AND POR.LOC_CD     = BKG.POR_CD \n"); 
//		mergeQuery03.append("                          AND POL.LOC_CD     = BKG.POL_CD \n"); 
//		mergeQuery03.append("                          AND POD.LOC_CD     = BKG.POD_CD \n"); 
//		mergeQuery03.append("                          AND DEL.LOC_CD     = BKG.DEL_CD \n"); 
//		mergeQuery03.append("                          AND POR.DELT_FLG   = 'N' \n"); 
//		mergeQuery03.append("                          AND POL.DELT_FLG   = 'N' \n"); 
//		mergeQuery03.append("                          AND POD.DELT_FLG   = 'N' \n"); 
//		mergeQuery03.append("                          AND DEL.DELT_FLG   = 'N' \n"); 
//		mergeQuery03.append("                          AND BKG.BKG_CRE_DT > TO_DATE ('20100405', 'YYYYMMDD') \n"); 
//		mergeQuery03.append("                          AND BKG.BKG_NO     =  ? --'CMB100645100' \n"); 
//		mergeQuery03.append("                   --------------------------------------------------------------------------------------------------------------------- \n"); 
//		mergeQuery03.append("                            ) ARR \n"); 
//		mergeQuery03.append("           --------------------------------------------------------------------------------------------------------------------- \n"); 
//		mergeQuery03.append("                WHERE SRT.SVC_SCP_CD           = ARR.SVC_SCP_CD \n");
//		mergeQuery03.append("                  AND PRF.SVC_SCP_CD           = ARR.SVC_SCP_CD \n"); 
//		mergeQuery03.append("                  AND PRF.SVC_SCP_CD           = SRT.SVC_SCP_CD \n"); 
//		mergeQuery03.append("                  AND PRF.CHG_CD               = SRT.CHG_CD \n"); 
//		mergeQuery03.append("                  AND SRT.DELT_FLG             = 'N' \n"); 
//		mergeQuery03.append("                  AND SRT.WDR_FLG              = 'N' \n"); 
//		mergeQuery03.append("                  AND ARR.POR_CD = POR.LOC_CD \n");
//		mergeQuery03.append("                  AND ARR.POL_CD = POL.LOC_CD \n");
//		mergeQuery03.append("                  AND ARR.POD_CD = POD.LOC_CD \n");
//		mergeQuery03.append("                  AND ARR.DEL_CD = DEL.LOC_CD \n");
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.POR_USE_FLG, 'Y', SRT.POR_DEF_CD, '*'), '*') IN (POR.LOC_CD, POR.RGN_CD, POR.CNT_CD, '*' ) \n"); 
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.POL_USE_FLG, 'Y', SRT.POL_DEF_CD, '*'), '*') IN (POL.LOC_CD, POL.RGN_CD, POL.CNT_CD, '*' ) \n"); 
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.POD_USE_FLG, 'Y', SRT.POD_DEF_CD, '*'), '*') IN (POD.LOC_CD, POD.RGN_CD, POD.CNT_CD, '*' ) \n"); 
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.DEL_USE_FLG, 'Y', SRT.DEL_DEF_CD, '*'), '*') IN (DEL.LOC_CD, DEL.RGN_CD, DEL.CNT_CD, '*' ) \n"); 
//		mergeQuery03.append("--                  AND NVL (DECODE (PRF.POR_USE_FLG, 'Y', SRT.POR_DEF_CD, '*'), '*') = ARR.POR_DEF_CD \n"); 
//		mergeQuery03.append("--                  AND NVL (DECODE (PRF.POL_USE_FLG, 'Y', SRT.POL_DEF_CD, '*'), '*') = ARR.POL_DEF_CD \n"); 
//		mergeQuery03.append("--                  AND NVL (DECODE (PRF.POD_USE_FLG, 'Y', SRT.POD_DEF_CD, '*'), '*') = ARR.POD_DEF_CD \n"); 
//		mergeQuery03.append("--                  AND NVL (DECODE (PRF.DEL_USE_FLG, 'Y', SRT.DEL_DEF_CD, '*'), '*') = ARR.DEL_DEF_CD \n"); 
//		mergeQuery03.append("                  AND PRF.CHG_CD \n"); 
//		mergeQuery03.append("                   IN \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("	                 CASE \n"); 
//		//CHM-201111322 FRC 계산 로직 변경 요청 -- FRC는 OFT성 Charge로 분류하여 공제 하지 않고 부과된 내역은 OFT로 합산 한다.
//		mergeQuery03.append("		                 WHEN TO_CHAR (ARR.RT_APLY_DT, 'YYYYMMDD') > '20101231' AND PRF.CHG_CD = 'FRC' THEN '*' \n"); 
//		//CHM-201111322 FRC 계산 로직 변경 요청 -- FRC는 OFT성 Charge로 분류하여 공제 하지 않고 부과된 내역은 OFT로 합산 한다.
//		mergeQuery03.append("           --> CFM Charge(CFM) \n");  
//		mergeQuery03.append("           --;)----------------------------------------------------------------------------------------------- \n");  
//		mergeQuery03.append("           --;) <CFM Charge> \n");  
//		mergeQuery03.append("           --;) RCV_TERM_CD 혹은 DE_TERM_CD가 'S'(CFS)일 때 부과되는 CHARGE \n"); 
//		mergeQuery03.append("           --;)----------------------------------------------------------------------------------------------- \n");  
//		mergeQuery03.append("		                 WHEN PRF.CHG_CD      = 'CFR' AND ARR.RCV_TERM_CD = 'S' THEN 'CFR' \n"); 
//		mergeQuery03.append("		                 WHEN PRF.CHG_CD      = 'CFD' AND ARR.DE_TERM_CD  = 'S' THEN 'CFD' \n"); 
//		mergeQuery03.append("		                 WHEN PRF.CHG_CD      = 'CFR' THEN '*' \n"); 
//		mergeQuery03.append("		                 WHEN PRF.CHG_CD      = 'CFD' THEN '*' \n"); 
//		mergeQuery03.append("		                 /* R/D Term 에 따라 THC 공제 여부 체크 로직 추가 - 임종한 과장 요청[CHM-201111599]*/ \n"); 
//		mergeQuery03.append("		                 /* [THC 공제로직 변경사항]   CHM-201111599               */ \n"); 
//		mergeQuery03.append("		                 /*   - BKG의 term 중에 I/O/T가 있는 경우 해당 지역의 THC 불공제 */ \n"); 
//		mergeQuery03.append("		                 /*   - BKG R term에 I 혹은 T가 있는 경우 - OTH 불공제                */ \n"); 
//		mergeQuery03.append("		                 /*   - BKG D term에 O 혹은 T가 있는 경우 - DTH 불공제                */ \n"); 
//		mergeQuery03.append("		                 WHEN PRF.CHG_CD      = 'THC'  AND(ARR.RCV_TERM_CD IN ('T','I','O') or ARR.DE_TERM_CD IN ('T','I','O')) THEN '*' \n"); 
//		mergeQuery03.append("		                 WHEN PRF.CHG_CD      = 'OTH'  AND ARR.RCV_TERM_CD IN ('T','I') THEN '*' \n"); 
//		mergeQuery03.append("		                 WHEN PRF.CHG_CD      = 'DTH'  AND ARR.DE_TERM_CD  IN ('T','O') THEN '*' \n"); 
//		mergeQuery03.append("		                 /* R/D Term 에 따라 THC 공제 여부 체크 로직 추가 - 임종한 과장 요청[CHM-201111599]*/ \n"); 
//		mergeQuery03.append("		                 ELSE PRF.CHG_CD \n"); 
//		mergeQuery03.append("	                 END \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> RECEIVE TERM  \n");
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.RCV_DE_TERM_USE_FLG, 'Y', SRT.PRC_RCV_TERM_CD, '*'), '*') \n"); 
//		mergeQuery03.append("                   IN \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      ARR.RCV_TERM_CD, \n"); 
//		mergeQuery03.append("                      '*' \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> DELIVERY TERM \n"); 
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.RCV_DE_TERM_USE_FLG, 'Y', SRT.PRC_DE_TERM_CD, '*'), '*') \n"); 
//		mergeQuery03.append("                   IN \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      ARR.DE_TERM_CD, \n"); 
//		mergeQuery03.append("                      '*' \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> USA SVC MODE  \n");
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.USA_SVC_MOD_USE_FLG, 'Y', SRT.USA_SVC_MOD_CD, '*'), '*') \n"); 
//		mergeQuery03.append("                   IN \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      DECODE (ARR.USA_SVC_MOD_CD, 'CZ', ARR.CML_ZN_CD, ARR.USA_SVC_MOD_CD), \n"); 
//		mergeQuery03.append("                      '*' \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> DIRECT CALLING \n"); 
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.DIR_CALL_USE_FLG, 'Y', SRT.DIR_CALL_FLG, '*'), '*') \n"); 
//		mergeQuery03.append("                   IN \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      ARR.DIR_CALL_FLG, \n"); 
//		mergeQuery03.append("                      '*' \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> ORIGIN TRANSPORTATION MODE \n"); 
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.TRNS_MOD_USE_FLG, 'Y', SRT.ORG_TRSP_MOD_CD, '*'), '*') \n"); 
//		mergeQuery03.append("                   IN \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      ARR.ORG_TRNS_MOD_CD, \n"); 
//		mergeQuery03.append("                      '*' \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> DESTINATION TRANSPORTATION MODE \n"); 
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.TRNS_MOD_USE_FLG, 'Y', SRT.DEST_TRSP_MOD_CD, '*'), '*') \n"); 
//		mergeQuery03.append("                   IN \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      ARR.DEST_TRNS_MOD_CD, \n"); 
//		mergeQuery03.append("                      '*' \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> TERMINAL \n"); 
//		mergeQuery03.append("                  AND \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      PRF.TML_USE_FLG = 'N' \n"); 
//		mergeQuery03.append("                   OR SRT.TML_CD     IS NULL \n"); 
//		mergeQuery03.append("                   OR SRT.TML_CD      = ARR.POL_NOD_CD \n"); 
//		mergeQuery03.append("                   OR SRT.TML_CD      = ARR.POD_NOD_CD \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> TRANSSHIPMENT PORT \n"); 
//		mergeQuery03.append("                  AND \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      PRF.TS_PORT_USE_FLG = 'N'  \n");
//		mergeQuery03.append("                   OR SRT.TS_PORT_CD     IS NULL \n"); 
//		mergeQuery03.append("                   OR EXISTS \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                          SELECT \n"); 
//		mergeQuery03.append("                                 'X' \n"); 
//		mergeQuery03.append("                            FROM BKG_VVD    BVD \n"); 
//		mergeQuery03.append("                           WHERE BVD.BKG_NO   = ARR.BKG_NO \n"); 
//		mergeQuery03.append("                             AND \n"); 
//		mergeQuery03.append("                               ( \n"); 
//		mergeQuery03.append("                                 BVD.POL_CD   = SRT.TS_PORT_CD \n"); 
//		mergeQuery03.append("                              OR BVD.POL_CD   = SRT.TS_PORT_CD \n"); 
//		mergeQuery03.append("                               ) \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> IN/OUT GAGE \n"); 
//		mergeQuery03.append("                  AND \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      SRT.IO_GA_CD  IS NULL \n"); 
//		mergeQuery03.append("                   OR EXISTS \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                          SELECT \n"); 
//		mergeQuery03.append("                                 'X' \n"); 
//		mergeQuery03.append("                            FROM BKG_AWK_CGO AWK \n"); 
//		mergeQuery03.append("                           WHERE AWK.IN_GA_FLG    = 'Y' \n"); 
//		mergeQuery03.append("                             AND AWK.BKG_NO       = ARR.BKG_NO \n"); 
//		mergeQuery03.append("                             AND AWK.CNTR_TPSZ_CD = SRT.RAT_UT_CD \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> VESSEL SERVICE LANE CODE \n"); 
//		mergeQuery03.append("                  AND \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      PRF.SLAN_USE_FLG = 'N' \n"); 
//		mergeQuery03.append("                   OR SRT.VSL_SLAN_CD IS NULL \n"); 
//		mergeQuery03.append("                   OR EXISTS \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                          SELECT \n"); 
//		mergeQuery03.append("                                 'X' \n"); 
//		mergeQuery03.append("                            FROM BKG_VVD BVD \n"); 
//		mergeQuery03.append("                           WHERE BVD.BKG_NO  = ARR.BKG_NO \n"); 
//		mergeQuery03.append("                             AND BVD.SLAN_CD = SRT.VSL_SLAN_CD \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> COMMODITY \n"); 
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.CMDT_USE_FLG, 'Y', SRT.CMDT_CD, '*'), '*') \n"); 
//		mergeQuery03.append("                   IN \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      ARR.CMDT_CD, \n"); 
//		mergeQuery03.append("                      '*' \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> SHIPPER'S OWN CONTAINER(S.O.C) \n"); 
//		mergeQuery03.append("                  AND NVL (DECODE (PRF.SOC_USE_FLG, 'Y', SRT.SOC_FLG, '*'), '*') \n"); 
//		mergeQuery03.append("                   IN \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      ARR.SOC_FLG, \n"); 
//		mergeQuery03.append("                      '*' \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> IMDG CLASS \n");  
//		mergeQuery03.append("                  AND \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      PRF.IMDG_CLSS_USE_FLG = 'N' \n"); 
//		mergeQuery03.append("                   OR SRT.SCG_IMDG_CLSS_CD  IS NULL \n"); 
//		mergeQuery03.append("                   OR EXISTS \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                          SELECT \n"); 
//		mergeQuery03.append("                                 'X' \n"); 
//		mergeQuery03.append("                            FROM BKG_DG_CGO BDG \n"); 
//		mergeQuery03.append("                           WHERE BDG.BKG_NO            = ARR.BKG_NO \n"); 
//		mergeQuery03.append("                             AND BDG.CNTR_TPSZ_CD      = SRT.RAT_UT_CD \n"); 
//		mergeQuery03.append("                             AND BDG.IMDG_CLSS_CD    LIKE SRT.SCG_IMDG_CLSS_CD||'%' \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> SUB TRADE \n"); 
//		mergeQuery03.append("           --;)----------------------------------------------------------------------------------------------- \n"); 
//		mergeQuery03.append("           --;) <SUB TRADE CODE> \n"); 
//		mergeQuery03.append("           --;) 운송 서비스 Trade 내의 상세 Area 세분화 하여 Code 화 함 \n"); 
//		mergeQuery03.append("           --;) 지정한 SUB TRADE에 해당하는 BOOKING인 경우 부과되는 SURCHARGE임을 의미함. \n"); 
//		mergeQuery03.append("           --;)----------------------------------------------------------------------------------------------- \n"); 
//		mergeQuery03.append("                  AND \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      PRF.SUB_TRD_USE_FLG  = 'N' \n"); 
//		mergeQuery03.append("                   OR SRT.SUB_TRD_CD      IS NULL \n"); 
//		mergeQuery03.append("                   OR SRT.SUB_TRD_CD \n"); 
//		mergeQuery03.append("                   IN \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                          SELECT \n"); 
//		mergeQuery03.append("                                 MDL.SUB_TRD_CD \n"); 
//		mergeQuery03.append("                            FROM BKG_VVD             BVD, \n"); 
//		mergeQuery03.append("                                 MDM_REV_LANE        MRL, \n"); 
//		mergeQuery03.append("                                 MDM_DTL_REV_LANE    MDL \n"); 
//		mergeQuery03.append("                           WHERE MDL.FM_CONTI_CD     = ( SELECT X.CONTI_CD FROM MDM_LOCATION X WHERE X.LOC_CD = BVD.POL_CD ) \n"); 
//		mergeQuery03.append("                             AND MDL.TO_CONTI_CD     = ( SELECT x.CONTI_CD FROM MDM_LOCATION X WHERE X.LOC_CD = BVD.POL_CD ) \n"); 
//		mergeQuery03.append("                             AND MRL.VSL_SLAN_CD     = BVD.SLAN_CD \n"); 
//		mergeQuery03.append("                             AND MDL.RLANE_CD        = MRL.RLANE_CD \n"); 
//		mergeQuery03.append("                             AND MDL.VSL_SLAN_DIR_CD = BVD.SKD_DIR_CD \n"); 
//		mergeQuery03.append("                             AND MRL.DELT_FLG        = 'N' \n"); 
//		mergeQuery03.append("                             AND MDL.DELT_FLG        = 'N' \n"); 
//		mergeQuery03.append("                             AND BVD.BKG_NO          = ARR.BKG_NO \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> DATE FROM \n"); 
//		mergeQuery03.append("                  AND ARR.RT_APLY_DT \n"); 
//		mergeQuery03.append("              BETWEEN SRT.EFF_DT \n"); 
//		mergeQuery03.append("                  AND SRT.EXP_DT \n"); 
//		mergeQuery03.append("           --> DATE TO \n"); 
//		mergeQuery03.append("                  AND ARR.RT_APLY_DT \n"); 
//		mergeQuery03.append("              BETWEEN SRT.EFF_DT \n"); 
//		mergeQuery03.append("                  AND SRT.EXP_DT \n"); 
//		mergeQuery03.append("           --> CARGO TYPE \n"); 
//		mergeQuery03.append("                  AND NVL(SRT.PRC_CGO_TP_CD, '*') \n"); 
//		mergeQuery03.append("                   IN \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      'DR',  \n");
//		mergeQuery03.append("                      'RF', \n"); 
//		mergeQuery03.append("                      'DG', \n"); 
//		mergeQuery03.append("                      'AK', \n"); 
//		mergeQuery03.append("                      'BB', \n"); 
//		mergeQuery03.append("                      '*' \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> SURCARGE GROUP COMMODITY ( GRI ) \n"); 
//		mergeQuery03.append("                  AND \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                      PRF.GRI_CMDT_USE_FLG = 'N' \n"); 
//		mergeQuery03.append("                   OR SRT.SCG_GRP_CMDT_CD IS NULL \n"); 
//		mergeQuery03.append("                   OR EXISTS \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                          SELECT \n"); 
//		mergeQuery03.append("                                 'X' \n"); 
//		mergeQuery03.append("                            FROM PRI_SCG_GRP_CMDT     GC, \n"); 
//		mergeQuery03.append("                                 PRI_SCG_GRP_CMDT_DTL GD \n"); 
//		mergeQuery03.append("                           WHERE GD.SVC_SCP_CD         = GC.SVC_SCP_CD \n"); 
//		mergeQuery03.append("                             AND GD.CHG_CD             = GC.CHG_CD \n"); 
//		mergeQuery03.append("                             AND GD.SCG_GRP_CMDT_SEQ   = GC.SCG_GRP_CMDT_SEQ \n"); 
//		mergeQuery03.append("                             AND GC.SVC_SCP_CD         = ARR.SVC_SCP_CD \n"); 
//		mergeQuery03.append("                             AND GC.CHG_CD             = SRT.CHG_CD \n"); 
//		mergeQuery03.append("                             AND GC.SCG_GRP_CMDT_CD    = SRT.SCG_GRP_CMDT_CD \n"); 
//		mergeQuery03.append("                             AND GD.CMDT_CD            = ARR.CMDT_CD \n"); 
//		mergeQuery03.append("                         ) \n"); 
//		mergeQuery03.append("                   ) \n"); 
//		mergeQuery03.append("           --> CANAL TRANSIT CODE \n"); 
//		mergeQuery03.append("                 AND \n"); 
//		mergeQuery03.append("                   ( \n"); 
//		mergeQuery03.append("                      PRF.CNL_TZ_FLG  = 'N' \n"); 
//		mergeQuery03.append("                   OR SRT.CNL_TZ_CD  IS NULL \n"); 
//		mergeQuery03.append("                   OR EXISTS \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                          SELECT \n"); 
//		mergeQuery03.append("                                 'X' \n"); 
//		mergeQuery03.append("                            FROM BKG_VVD          BV, \n"); 
//		mergeQuery03.append("                                 VSK_VSL_PORT_SKD S1, \n"); 
//		mergeQuery03.append("                                 VSK_VSL_PORT_SKD S2, \n"); 
//		mergeQuery03.append("                                 VSK_VSL_PORT_SKD S3 \n"); 
//		mergeQuery03.append("                           WHERE BV.BKG_NO        = ARR.BKG_NO \n"); 
//		mergeQuery03.append("                             AND S1.VSL_CD        = BV.VSL_CD \n"); 
//		mergeQuery03.append("                             AND S1.SKD_VOY_NO    = BV.SKD_VOY_NO \n"); 
//		mergeQuery03.append("                             AND S1.SKD_DIR_CD    = BV.SKD_DIR_CD \n"); 
//		mergeQuery03.append("                             AND S1.VPS_PORT_CD   = BV.POL_CD \n"); 
//		mergeQuery03.append("                             AND S1.CLPT_IND_SEQ  = BV.POL_CLPT_IND_SEQ \n"); 
//		mergeQuery03.append("                             AND S2.VSL_CD        = BV.VSL_CD \n"); 
//		mergeQuery03.append("                             AND S2.SKD_VOY_NO    = BV.SKD_VOY_NO \n"); 
//		mergeQuery03.append("                             AND S2.SKD_DIR_CD    = BV.SKD_DIR_CD \n"); 
//		mergeQuery03.append("                             AND S2.VPS_PORT_CD   = BV.POD_CD \n"); 
//		mergeQuery03.append("                             AND S2.CLPT_IND_SEQ  = BV.POD_CLPT_IND_SEQ \n"); 
//		mergeQuery03.append("                             AND S3.VSL_CD        = BV.VSL_CD \n"); 
//		mergeQuery03.append("                             AND S3.SKD_VOY_NO    = BV.SKD_VOY_NO \n"); 
//		mergeQuery03.append("                             AND S3.SKD_DIR_CD    = BV.SKD_DIR_CD \n"); 
//		mergeQuery03.append("                             AND S3.VPS_PORT_CD   = DECODE (SRT.CNL_TZ_CD, 'P', 'PAPAC', 'S', 'EGSUC') \n"); 
//		mergeQuery03.append("                             AND S3.CLPT_SEQ \n"); 
//		mergeQuery03.append("                         BETWEEN S1.CLPT_SEQ \n"); 
//		mergeQuery03.append("                             AND S2.CLPT_SEQ \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("           --> CARGO WEIGHT  \n");
//		mergeQuery03.append("                  AND \n"); 
//		mergeQuery03.append("                    ( \n");
//		mergeQuery03.append("                      PRF.CGO_WGT_USE_FLG = 'N' \n"); 
//		mergeQuery03.append("                   OR EXISTS \n"); 
//		mergeQuery03.append("                    ( \n"); 
//		mergeQuery03.append("                          SELECT \n"); 
//		mergeQuery03.append("                                 'X' \n"); 
//		mergeQuery03.append("                            FROM BKG_CONTAINER BCT \n"); 
//		mergeQuery03.append("                           WHERE BCT.BKG_NO      = ARR.BKG_NO \n"); 
//		mergeQuery03.append("                             AND CNTR_TPSZ_CD    = SRT.RAT_UT_CD \n"); 
//		mergeQuery03.append("                          HAVING 'Y' = \n"); 
//		mergeQuery03.append("                            CASE \n"); 
//		mergeQuery03.append("                            WHEN TO_NUMBER (SRT.MIN_CGO_WGT) >= NVL (MIN (DECODE (BCT.WGT_UT_CD, 'LBS', BCT.CNTR_WGT * 0.45359, BCT.CNTR_WGT)), 0) \n"); 
//		mergeQuery03.append("                             AND TO_NUMBER (SRT.MAX_CGO_WGT) <  NVL (MIN (DECODE (BCT.WGT_UT_CD, 'LBS', BCT.CNTR_WGT * 0.45359, BCT.CNTR_WGT)), 0) \n"); 
//		mergeQuery03.append("                            THEN 'Y' \n"); 
//		mergeQuery03.append("                            ELSE 'N' \n"); 
//		mergeQuery03.append("                             END \n"); 
//		mergeQuery03.append("                       UNION ALL \n"); 
//		mergeQuery03.append("                          SELECT \n"); 
//		mergeQuery03.append("                                 'X' \n"); 
//		mergeQuery03.append("                            FROM BKG_BL_DOC  BBC, \n"); 
//		mergeQuery03.append("                                 BKG_QTY_DTL BQD \n"); 
//		mergeQuery03.append("                           WHERE BBC.BKG_NO    = ARR.BKG_NO \n"); 
//		mergeQuery03.append("                             AND BBC.BKG_NO    = BQD.BKG_NO \n"); 
//		mergeQuery03.append("                          HAVING 'Y' = \n"); 
//		mergeQuery03.append("                            CASE \n"); 
//		mergeQuery03.append("                            WHEN 1 = SUM (BQD.OP_CNTR_QTY) \n"); 
//		mergeQuery03.append("                             AND TO_NUMBER (SRT.MIN_CGO_WGT) >= NVL (MIN (DECODE (BBC.WGT_UT_CD, 'LBS', BBC.ACT_WGT * 0.45359, BBC.ACT_WGT)), 0) \n"); 
//		mergeQuery03.append("                             AND TO_NUMBER (SRT.MAX_CGO_WGT) <  NVL (MIN (DECODE (BBC.WGT_UT_CD, 'LBS', BBC.ACT_WGT * 0.45359, BBC.ACT_WGT)), 0) \n"); 
//		mergeQuery03.append("                            THEN 'Y' \n"); 
//		mergeQuery03.append("                            ELSE 'N'  \n");
//		mergeQuery03.append("                             END \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append("                    ) \n"); 
//		mergeQuery03.append(" \n");                    
//		mergeQuery03.append(" \n");
//		mergeQuery03.append("             GROUP BY ARR.BKG_NO, \n"); 
//		mergeQuery03.append("                      SRT.CHG_CD, \n"); 
//		mergeQuery03.append("                      SRT.RAT_UT_CD, \n"); 
//		mergeQuery03.append("                      SRT.CURR_CD, \n"); 
//		mergeQuery03.append("                      SRT.PRC_CGO_TP_CD \n"); 
//		mergeQuery03.append("           ) PCD \n"); 
//		mergeQuery03.append("          ON \n"); 
//		mergeQuery03.append("           ( TBL.BKG_NO         = PCD.BKG_NO \n"); 
//		mergeQuery03.append("         AND TBL.CHG_CD         = PCD.CHG_CD \n"); 
//		mergeQuery03.append("         AND TBL.BKG_AGMT_UT_CD = PCD.BKG_AGMT_UT_CD \n"); 
//		mergeQuery03.append("         AND TBL.CURR_CD        = PCD.CURR_CD \n"); 
//		mergeQuery03.append("         AND TBL.SPCL_CGO_CTNT  = PCD.SPCL_CGO_CTNT  \n");
//		mergeQuery03.append("           ) \n"); 
//		mergeQuery03.append("        WHEN MATCHED \n"); 
//		mergeQuery03.append("        THEN \n"); 
//		mergeQuery03.append("                 UPDATE \n"); 
//		mergeQuery03.append("                    SET TBL.ROUT_TRF_RT  = PCD.ROUT_TRF_RT, \n"); 
//		mergeQuery03.append("                        TBL.ROUT_TRF_RTO = PCD.ROUT_TRF_RTO, \n"); 
//		mergeQuery03.append("                        TBL.UPD_USR_ID   = PCD.UPD_USR_ID, \n"); 
//		mergeQuery03.append("                        TBL.UPD_DT       = PCD.UPD_DT \n"); 
//		mergeQuery03.append("                 DELETE \n"); 
//		mergeQuery03.append("                  WHERE PCD.ROUT_TRF_RT  IS NULL \n"); 
//		mergeQuery03.append("                    AND PCD.ROUT_TRF_RTO IS NULL \n"); 
//		mergeQuery03.append("        WHEN NOT MATCHED \n"); 
//		mergeQuery03.append("        THEN \n"); 
//		mergeQuery03.append("                 INSERT \n"); 
//		mergeQuery03.append("                      ( \n"); 
//		mergeQuery03.append("                        BKG_NO, \n"); 
//		mergeQuery03.append("                        CHG_CD, \n"); 
//		mergeQuery03.append("                        BKG_AGMT_UT_CD, \n"); 
//		mergeQuery03.append("                        CURR_CD, \n"); 
//		mergeQuery03.append("                        SPCL_CGO_CTNT,  \n");
//		mergeQuery03.append("                        ROUT_TRF_RT, \n"); 
//		mergeQuery03.append("                        ROUT_TRF_RTO, \n"); 
//		mergeQuery03.append("                        COMM_PROC_STS_RSN, \n"); 
//		mergeQuery03.append("                        CRE_USR_ID, \n"); 
//		mergeQuery03.append("                        CRE_DT, \n"); 
//		mergeQuery03.append("                        UPD_USR_ID, \n"); 
//		mergeQuery03.append("                        UPD_DT \n"); 
//		mergeQuery03.append("                      ) \n"); 
//		mergeQuery03.append("                 VALUES \n"); 
//		mergeQuery03.append("                      ( \n"); 
//		mergeQuery03.append("                        PCD.BKG_NO, \n"); 
//		mergeQuery03.append("                        PCD.CHG_CD, \n"); 
//		mergeQuery03.append("                        PCD.BKG_AGMT_UT_CD, \n"); 
//		mergeQuery03.append("                        PCD.CURR_CD, \n"); 
//		mergeQuery03.append("                        PCD.SPCL_CGO_CTNT,  \n");
//		mergeQuery03.append("                        PCD.ROUT_TRF_RT, \n"); 
//		mergeQuery03.append("                        PCD.ROUT_TRF_RTO, \n"); 
//		mergeQuery03.append("                        PCD.COMM_PROC_STS_RSN, \n"); 
//		mergeQuery03.append("                        PCD.CRE_USR_ID, \n"); 
//		mergeQuery03.append("                        PCD.CRE_DT, \n"); 
//		mergeQuery03.append("                        PCD.UPD_USR_ID, \n"); 
//		mergeQuery03.append("                        PCD.UPD_DT \n"); 
//		mergeQuery03.append("                      ) \n"); 


		bkg_no = (String)bkgMap.get("BKG_NO");
		shpr_seq = checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));			// shpr_seq
		frt_fwrd_seq = checkNull((String)bkgMap.get("FF_CUST_SEQ"));		// frt_fwrd_seq

		try {
			// S/A Date를 담고 있는 ArrayList
			saDateList = (ArrayList)bkgMap.get("SADate");
			
			// Trunk 정보를 담고있는 HashMap
			trnkMap = (HashMap)saDateList.get(4); //반드시 존재한다.
			
			
			if(shpr_seq.length() > 0 && !"*".equals(shpr_seq)) {
				iShpr_seq = Integer.parseInt(shpr_seq);
			}
			
			if(frt_fwrd_seq.length() > 0 && !"*".equals(frt_fwrd_seq)) {
				iFrt_fwrd_seq = Integer.parseInt(frt_fwrd_seq);
			}
		
			rlane_cd = checkNull((String)bkgMap.get("COMM_RLANE_CD"));


			// Connectiond을 얻어 온다.
			con = getConnection();

			// Booking Commission을 저장한다. -------start-------
			i = 1; //초기화

			mergePs01 = new LoggableStatement(con, mergeQuery01.toString());
			mergePs01.setString(i++, bkg_no);								// bkg_no
			mergePs01.setString(i++, (String)bkgMap.get("SHPR_CNT_CD"));		// shpr_cnt_cd
			mergePs01.setInt(i++, iShpr_seq);								// shpr_seq
			mergePs01.setString(i++, (String)bkgMap.get("FF_CNT_CD"));		// frt_fwrd_cnt_cd
			mergePs01.setInt(i++, iFrt_fwrd_seq);							// frt_fwrd_seq
			mergePs01.setString(i++, rlane_cd);								// rlane_cd 		-> coa에서 가지고 온 rlane_cd
			mergePs01.setString(i++, (String)bkgMap.get("REV_VVD_CD"));							// rev_vvd_cd		-> coa에서 가지고 온 vsl_cd + skd_voy_no + dir_cd + finc_dir_cd
			mergePs01.setString(i++, (String)trnkMap.get("SLAN_CD"));		// trnk_slan_cd		-> Trunk의 slan_cd
			mergePs01.setString(i++, (String)trnkMap.get("RLANE_CD"));		// trnk_rlane_cd	-> Trunk의 rlane_cd ( Trunk의 slan_cd(3자리) + pol의 conti(1자리) + pod의 conti(1자리) ) 
			mergePs01.setString(i++, (String)trnkMap.get("VSL_CD"));			// trnk_vsl_cd		-> Trunk의 vsl_cd
			mergePs01.setString(i++, (String)trnkMap.get("SKD_VOY_NO"));		// trnk_skd_voy_no	-> Trunk의 skd_voy_no
			mergePs01.setString(i++, (String)trnkMap.get("SKD_DIR_CD"));		// trnk_skd_dir_cd	-> Trunk의 skd_dir_cd
			mergePs01.setString(i++, (String)trnkMap.get("RLANE_DIR_CD"));	// trnk_rev_dir_cd	-> Trunk의 rlane_dir_cd
			mergePs01.setString(i++, (String)bkgMap.get("FMC_NO"));			// fmc_no
			mergePs01.setString(i++, (String)bkgMap.get("BKG_SLS_OFC_CD"));	// sls_ofc_cd
			mergePs01.setString(i++, (String)bkgMap.get("ESTM_IOC_DIV_CD"));		// ESTM_IOC_DIV_CD

			log.debug("\n SQL1 : \n" + ((LoggableStatement)mergePs01).getQueryString());
			mergePs01.executeUpdate();
			// Booking Commission을 저장한다. -------start-------

			i = 1; // 초기화 한다.
			mergePs02 = new LoggableStatement(con, mergeQuery02.toString());
			mergePs02.setString(i++, bkg_no);								// bkg_no
			mergePs02.setString(i++, bkg_no);								// bkg_no

			log.debug("\n SQL2 : \n" + ((LoggableStatement)mergePs02).getQueryString());
			mergePs02.executeUpdate();

			i = 1; // 초기화 한다.

			deletePs01 = new LoggableStatement(con, deleteQuery01.toString());
			deletePs01.setString(i++, bkg_no);								// bkg_no

			log.debug("\n SQL3 : \n" + ((LoggableStatement)deletePs01).getQueryString());
			deletePs01.executeUpdate();

			i = 1; // 초기화 한다.
			mergePs03 = new LoggableStatement(con, mergeQuery03.toString());
			mergePs03.setString(i++, bkg_no);								// bkg_no

			log.debug("\n SQL3 : \n" + ((LoggableStatement)mergePs03).getQueryString());
			mergePs03.executeUpdate();

		}
		catch (SQLException se)
		{
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (DAOException de)
		{
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,de);
			throw de;
		}
		catch (Exception e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw new DAOException(e.getMessage());
		}
		finally
		{
			closeStatement(mergePs01);
			closeStatement(mergePs02);
			closeStatement(mergePs03);
			closeStatement(deletePs01);
			closeConnection(con);
		}
	}

	
	/**
	 * Brokerage Calculation<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return boolean Brokerage 여부
	 * @throws DAOException
	 */
	
	public boolean createActualBRKGComm(HashMap bkgMap) throws DAOException {

		log.debug("\n\n createActualBRKGComm 메소드 시작 ========================================\n");


		String bkg_no			= checkNull((String)bkgMap.get("BKG_NO"));
		String por_cnt_cd		= checkNull((String)bkgMap.get("POR_CNT_CD"));
		String pol_cnt_cd		= checkNull((String)bkgMap.get("POL_CNT_CD"));
		String bkg_ofc_loc_cd	= checkNull((String)bkgMap.get("BKG_OFC_LOC_CD"));
		String bkg_ofc_cnt_cd	= "";
		try {
			
			if(bkg_ofc_loc_cd.length() > 4){
				bkg_ofc_cnt_cd = bkg_ofc_loc_cd.substring(0, 2);
			}
			
			// Brokerage가 아니면 Return 한다.
			// 20080428-sunganj : 정영한 대리 요청으로 POL_CD = 'MX'이고 BKG_OFC = 'US'이면 Brokerage로 추가
			if(!( "US".equals(por_cnt_cd) || "CA".equals(por_cnt_cd) ) && !( "US".equals(pol_cnt_cd) || "CA".equals(pol_cnt_cd) )) {
				if( !("MX".equals(pol_cnt_cd) && "US".equals(bkg_ofc_cnt_cd)) ){
					return false;
				}
			}
			
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		}
		
		return true;
	}
	
	

	/**
	 * Brokerage Sequence 구하기<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchBRKGRateSequenceInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchBRKGRateSequenceInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		PreparedStatement ps02 = null;
		// DB ResultSet
		ResultSet rs = null;
		ResultSet rs02 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// Brokerage 정보를 담고 있는 HashMap
		HashMap brogMap = null;
		
		String bkg_no = "";

		boolean brog_seq_flag = false; // Brokerage Sequence가 이미 존재하는지 유무
		int brog_seq = 0;
		
		StringBuffer queryStr = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();

		// agt_brog_comm 테이블에서 가장 최근에 Interface한 데이타의 Brokerage Sequence를 조회한다.
		// 데이타가 존재하지 않을 경우에는 0을 반환한다.
		queryStr.append("SELECT NVL(MAX(brog_seq),0) brog_seq \n");
		queryStr.append("  FROM agt_brog_comm \n");
		queryStr.append(" WHERE  bkg_no = ? \n");
		queryStr.append("	AND comm_proc_sts_cd = 'IF' \n");

		bkg_no = (String)bkgMap.get("BKG_NO");

		try {
			
			brogMap = (HashMap)bkgMap.get("brogMap");
			
			
			con = getConnection();
			
			// Interface가 된 Booking의 Max(seq)를 구한다.-------start-------
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, bkg_no);
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if(rs.next()) {
				brog_seq = rs.getInt("brog_seq");
			}
			// Interface가 된 Booking의 Max(seq)를 구한다.-------start-------
			
			brog_seq++; // 구해온 Sequence를 증가시킨다.
			if(brog_seq == 1){
				bkgMap.put("CANCEL_BRO", "C");
			}
			log.debug("\n\n 111 brog_seq ::"+brog_seq);
			// Brokerage Sequence를 Brokerage Map에 넣는다.
			brogMap.put("BROG_SEQ", String.valueOf(brog_seq));
			
			
			// 증가시킨 seq로 Interface가 안 된 데이타가 존재하는지 조회한다. -------start-------
			// 만약 Interface가 안 된 데이타가 존재한다면 삭제하고 새롭게 등록한다.
			i = 1; // 초기화한다.

			// agt_brog_comm 테이블에서 Interface가 안 된 데이타가 존재하는지 조회한다.
			queryStr02.append("SELECT '*' brog \n");
			queryStr02.append("  FROM agt_brog_comm \n");
			queryStr02.append(" WHERE bkg_no = ? \n");
			queryStr02.append("	AND brog_seq = ? \n");
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps02 = new LoggableStatement(con, queryStr02.toString());
			} else {
				ps02 = con.prepareStatement(queryStr02.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps02.setString(i++, bkg_no);
			ps02.setInt(i++, brog_seq);

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
			rs02 = ps02.executeQuery();
			
			if(rs02.next()) {
				brog_seq_flag = true; // Interface가 안 된 Brokerage Sequence 존재
			}
			// agt_brog_comm 테이블에서 Interface가 안 된 데이타가 존재하는지 조회한다. -------end-------
			
			// Interface가 안 된 Brokerage Sequence가 존재하면 AGT_BROG_COMM, AGT_BROG_COMM_DTL 테이블에서 삭제한다. -------start-------
			if(brog_seq_flag) {
				// agt_brog_comm 테이블에서 Interface가 안 된 데이타가 존재할 경우 AGT_BROG_CHG_DTL 테이블에서 삭제한다.
				removeBrogChgDtl( con, bkg_no, brog_seq );
				
				// agt_brog_comm 테이블에서 Interface가 안 된 데이타가 존재할 경우 AGT_BROG_COMM_DTL 테이블에서 삭제한다.
				removeBrogCommDtl( con,  bkg_no, brog_seq );
				
				// agt_brog_comm 테이블에서 Interface가 안 된 데이타가 존재할 경우 AGT_BROG_COMM 테이블에서 삭제한다.
				removeBrogComm( con,  bkg_no, brog_seq );
			}
			// Interface가 안 된 Brokerage Sequence가 존재하면 AGT_BROG_COMM, AGT_BROG_COMM_DTL 테이블에서 삭제한다. -------end-------

			// Brokerage Map에 Cancel 여부를 Default='N'으로 셋팅한다. 
			// Type Size 저장시 필요
			brogMap.put("CANCEL_YN", "N");
			
			// Booking HashMap에 담는다.
			bkgMap.put("brogMap", brogMap); // Booking Map에 Brokerage 정보를 담는다.

		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeResultSet(rs02);
			closeStatement(ps);
			closeStatement(ps02);
			closeConnection(con);
		}

		return bkgMap;
	}
	
	/**
	 * Interface 했는데 Status가 Cancel 경우 Cancel AMT를 구하여 Brokerage Commission 테이블에 저장한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchBRKGBKGCancelInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchBRKGBKGCancelInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		PreparedStatement insertPs = null;
		PreparedStatement ps03 = null;
		// DB ResultSet
		ResultSet rs = null;
		ResultSet rs03 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// Brokerage 정보를 담고 있는 HashMap
		HashMap brogMap = null;

		String bkg_no = "";
		String sBrog_seq = "";
		String brog_div_cd_1 = ""; // brog_div_cd의 첫번째 자리 값

		String procRsltRsn = "Booking No has cancelled!";
		String coveredCheck	= "";

		boolean cancel_flag = false; // Brokerage Sequence가 이미 존재하는지 유무
		int brog_seq = 0;
		double cancel_amt = 0;
		
		StringBuffer queryStr = new StringBuffer();
		StringBuffer queryStr03 = new StringBuffer();
		StringBuffer insertQuery = new StringBuffer();

		/*
		 * Brokarage Commission 테이블에서 해당 Booking의 상태가 'IF'인 SEQ의 Max 값이 해당 Booking의 SEQ의 Max값인지 체크한다.
		 * 해당 Booking의 상태가 'IF'인 SEQ의 Max 값과 해당 Booking의 전체 SEQ의 Max값이 동일하지 않을 경우 즉 Interface 된 후 재계산된 SEQ가 존재할 경우 재계산된 SEQ의 데이타를 삭제한다.
		 * Cancel AMT를 구하여 삭제된 SEQ에 (위에서 seq++ 로 증가 시킴) Insert 한다.
		 * 참고 : 위에서 Seq를 증가시켰으므로 brog_seq-1 로 조회한다.
		 */
		queryStr.append("SELECT '*' brog \n");
		queryStr.append("  FROM agt_brog_comm \n");
		queryStr.append(" WHERE bkg_no = ? \n");
		queryStr.append("	AND brog_seq = ? - 1 \n");
		queryStr.append("	AND comm_proc_sts_cd = 'IF' \n");

		// comm_proc_sts_cd = 'IF'인 데이타중 seq가 Max인 데이타를 조회하여 증가된 Seq로 Insert한다.
		insertQuery.append("    INSERT \n");
		insertQuery.append("      INTO AGT_BROG_COMM \n");
		insertQuery.append("         ( BKG_NO, \n");
		insertQuery.append("           BROG_SEQ, \n");
		insertQuery.append("           COMM_OCCR_INFO_CD, \n");
		insertQuery.append("           AR_OFC_CD, \n");
		insertQuery.append("           AP_OFC_CD, \n");
		insertQuery.append("           COMM_STND_COST_CD, \n");
		insertQuery.append("           COMM_PROC_STS_CD, \n");
		insertQuery.append("           COMM_PROC_RSLT_RSN, \n");
		insertQuery.append("           COMM_SLAN_CD, \n");
		insertQuery.append("           COMM_RLANE_CD, \n");
		insertQuery.append("           COMM_VSL_CD, \n");
		insertQuery.append("           COMM_SKD_VOY_NO, \n");
		insertQuery.append("           COMM_SKD_DIR_CD, \n");
		insertQuery.append("           COMM_REV_DIR_CD, \n");
		insertQuery.append("           BROG_REF_NO, \n");
		insertQuery.append("           CUST_HUS_BRO_NO, \n");
		insertQuery.append("           FRT_FWRD_CNT_CD, \n");
		insertQuery.append("           FRT_FWRD_SEQ, \n");
		insertQuery.append("           VNDR_CNT_CD, \n");
		insertQuery.append("           VNDR_SEQ, \n");
		insertQuery.append("           VSL_DEP_DT, \n");
		insertQuery.append("           BROG_DIV_CD, \n");
		insertQuery.append("           BROG_BKG_RT, \n");
		insertQuery.append("           BROG_CHG_CTNT, \n");
		insertQuery.append("           BROG_BX_RT, \n");
		insertQuery.append("           BKG_BX_QTY, \n");
		insertQuery.append("           BROG_TEU_RT, \n");
		insertQuery.append("           BKG_TEU_QTY, \n");
		insertQuery.append("           BROG_FEU_RT, \n");
		insertQuery.append("           BKG_FEU_QTY, \n");
		insertQuery.append("           BROG_RF_RT, \n");
		insertQuery.append("           BKG_RF_QTY, \n");
		insertQuery.append("           BROG_KND_CD, \n");
		insertQuery.append("           INTER_MDAL_FLG, \n");
		insertQuery.append("           ACT_PRE_COMM_AMT, \n");
		insertQuery.append("           ACT_COMM_AMT, \n");
		insertQuery.append("           ACT_IF_COMM_AMT, \n");
		insertQuery.append("           ACCL_FLG, \n");
		insertQuery.append("           AGMT_CNT_CD, \n");
		insertQuery.append("           AGMT_CUST_SEQ, \n");
		insertQuery.append("           AGMT_RT_SEQ, \n");
		insertQuery.append("           UPD_USR_ID, \n");
		insertQuery.append("           UPD_DT, \n");
		insertQuery.append("           CRE_USR_ID, \n");
		insertQuery.append("           CRE_DT \n");
		insertQuery.append("         ) \n");
		insertQuery.append("    SELECT \n");
		insertQuery.append("           BRO.BKG_NO, \n");
		insertQuery.append("           BRO.BROG_SEQ + 1               AS BROG_SEQ, \n");
		insertQuery.append("           BRO.COMM_OCCR_INFO_CD, \n");
		insertQuery.append("           BRO.AR_OFC_CD, \n");
		insertQuery.append("           BRO.AP_OFC_CD, \n");
		insertQuery.append("           BRO.COMM_STND_COST_CD, \n");
		insertQuery.append("           'CS'                           AS COMM_PROC_STS_CD, \n");
		insertQuery.append("           CCD.CANCELED_RSN               AS COMM_PROC_RSLT_RSN, \n");
		insertQuery.append("           BRO.COMM_SLAN_CD, \n");
		insertQuery.append("           BRO.COMM_RLANE_CD, \n");
		insertQuery.append("           BRO.COMM_VSL_CD, \n");
		insertQuery.append("           BRO.COMM_SKD_VOY_NO, \n");
		insertQuery.append("           BRO.COMM_SKD_DIR_CD, \n");
		insertQuery.append("           BRO.COMM_REV_DIR_CD, \n");
		insertQuery.append("           BRO.BROG_REF_NO, \n");
		insertQuery.append("           BRO.CUST_HUS_BRO_NO, \n");
		insertQuery.append("           BRO.FRT_FWRD_CNT_CD, \n");
		insertQuery.append("           BRO.FRT_FWRD_SEQ, \n");
		insertQuery.append("           BRO.VNDR_CNT_CD, \n");
		insertQuery.append("           BRO.VNDR_SEQ, \n");
		insertQuery.append("           BRO.VSL_DEP_DT, \n");
		insertQuery.append("           BRO.BROG_DIV_CD, \n");
		insertQuery.append("           BRO.BROG_BKG_RT, \n");
		insertQuery.append("           BRO.BROG_CHG_CTNT, \n");
		insertQuery.append("           BRO.BROG_BX_RT, \n");
		insertQuery.append("           BRO.BKG_BX_QTY, \n");
		insertQuery.append("           BRO.BROG_TEU_RT, \n");
		insertQuery.append("           BRO.BKG_TEU_QTY, \n");
		insertQuery.append("           BRO.BROG_FEU_RT, \n");
		insertQuery.append("           BRO.BKG_FEU_QTY, \n");
		insertQuery.append("           BRO.BROG_RF_RT, \n");
		insertQuery.append("           BRO.BKG_RF_QTY, \n");
		insertQuery.append("           BRO.BROG_KND_CD, \n");
		insertQuery.append("           BRO.INTER_MDAL_FLG, \n");
		insertQuery.append("           CCD.CANCELED_AMT               AS ACT_PRE_COMM_AMT, \n");
		insertQuery.append("           0                              AS ACT_COMM_AMT, \n");
		insertQuery.append("           0 - CCD.CANCELED_AMT           AS ACT_IF_COMM_AMT, \n");
		insertQuery.append("           BRO.ACCL_FLG, \n");
		insertQuery.append("           BRO.AGMT_CNT_CD, \n");
		insertQuery.append("           BRO.AGMT_CUST_SEQ, \n");
		insertQuery.append("           BRO.AGMT_RT_SEQ, \n");
		insertQuery.append("           CCD.CANCELED_USR_ID            AS UPD_USR_ID, \n");
		insertQuery.append("           SYSDATE                        AS UPD_DT, \n");
		insertQuery.append("           CCD.CANCELED_USR_ID            AS CRE_USR_ID, \n");
		insertQuery.append("           SYSDATE                        AS CRE_DT \n");
		insertQuery.append("      FROM AGT_BROG_COMM BRO, \n");
		insertQuery.append("         ( \n");
		insertQuery.append("               SELECT \n");
		insertQuery.append("                      MAX (BR2.BKG_NO)                             AS BKG_NO, \n");
		insertQuery.append("                      ROUND (NVL (SUM (BR2.ACT_IF_COMM_AMT),0), 2) AS CANCELED_AMT, \n");
		insertQuery.append("                      ?                                            AS CANCELED_RSN, \n");
		insertQuery.append("                      'COMMISSION'                                 AS CANCELED_USR_ID \n");
		insertQuery.append("			     FROM AGT_BROG_COMM BR2 \n");
		insertQuery.append("                WHERE BR2.BKG_NO           = ? \n");
		insertQuery.append("                  AND BR2.COMM_PROC_STS_CD = 'IF' \n");
		insertQuery.append("             GROUP BY BKG_NO \n");
		insertQuery.append("               HAVING 0 < ROUND (NVL (SUM (BR2.ACT_IF_COMM_AMT),0), 2) \n");
		insertQuery.append("         ) CCD \n");
		insertQuery.append("     WHERE BRO.BKG_NO           = CCD.BKG_NO \n");
		insertQuery.append("       AND BRO.BROG_SEQ         = ? - 1 \n");
		insertQuery.append("       AND BRO.COMM_PROC_STS_CD = 'IF' \n");

		bkg_no = (String)bkgMap.get("BKG_NO");

		
		try {		
			
			// Brokerage 정보를 담고 있는 HashMap
			brogMap = (HashMap)bkgMap.get("brogMap");
			coveredCheck	= (String)bkgMap.get("COVERED_CHECK");

			sBrog_seq = (String)brogMap.get("BROG_SEQ");
			brog_seq = Integer.parseInt(sBrog_seq);

			if("B".equals(coveredCheck))
			{
				procRsltRsn = "Co-Biz B/L! Interfaced commission amount will be duddcted.";
			}
			else if ("C".equals(coveredCheck))
			{
				procRsltRsn = "Covered B/L! Interfaced commission amount will be duddcted.";
			}

			
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, bkg_no);
			ps.setInt(i++, brog_seq);
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if(rs.next()) {
				cancel_flag = true; // Interface 된 Data 존재
			}
			
			// Interface 된 Data가 존재하면 cancel_amt를 구하여 저장하고 존재하지 않으면 해당 데이타를 삭제한다. -------start-------
			// cancel된 데이타가 존재하지 않으면 AGT_BROG_CHG_DTL, AGT_BROG_COMM_DTL, AGT_BROG_COMM를 삭제한다.
			if(cancel_flag) {

					// Brokerage 테이블에 해당 데이타를 저장한다. -------start-------
					i = 1; // 초기화한다.
					insertPs = new LoggableStatement(con, insertQuery.toString());

					insertPs.setString(i++, procRsltRsn);				//error Message
					insertPs.setString(i++, bkg_no);					//bkg_no
					insertPs.setString(i++, sBrog_seq);					//brog_seq
					
					log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs).getQueryString());
					insertPs.executeUpdate();
					//Brokerage 테이블에 해당 데이타를 저장한다. -------end-------

			} else {
				// cancel된 데이타가 존재하지 않으면 AGT_BROG_CHG_DTL에서 삭제한다.
				removeBrogChgDtl( con, bkg_no, brog_seq - 1);
				
				// cancel된 데이타가 존재하지 않으면 AGT_BROG_COMM_DTL에서 삭제한다.
				removeBrogCommDtl( con,  bkg_no, brog_seq - 1 );
				
				// cancel된 데이타가 존재하지 않으면 AGT_BROG_COMM에서 삭제한다.
				removeBrogComm( con,  bkg_no, brog_seq - 1 );
			}
			// Interface 된 Data가 존재하면 cancel_amt를 구하여 저장하고 존재하지 않으면 해당 데이타를 삭제한다.-------end-------

			// cancel_amt == 0 이면 다음 Booking으로 넘어간다.
			if(!(cancel_amt != 0)) {
				brogMap.put("COMM_PROC_RSLT_RSN", "CANCEL_AMT"); // cancel_amt is 0!
				bkgMap.put("brogMap", brogMap);
				return bkgMap;
			}
			
			// Brokerage div cd의 첫번째 자리값을 구한다. -------start-------
			i = 1; // 초기화한다.

			// Brokerage Div cd의 첫번째 자리의 값을 구한다.
			queryStr03.append("SELECT SUBSTR(brog_div_cd, 1, 1) brog_div_cd \n");
			queryStr03.append("  FROM agt_brog_comm \n");
			queryStr03.append(" WHERE bkg_no = ? \n");
			queryStr03.append("	AND brog_seq = ? - 1 \n");			
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps03 = new LoggableStatement(con, queryStr03.toString());
			} else {
				ps03 = con.prepareStatement(queryStr03.toString());
			}

            // 쿼리에 변수 세팅.
			ps03.setString(i++, bkg_no);
			ps03.setInt(i++, brog_seq);

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps03).getQueryString());
			rs03 = ps03.executeQuery();
			
			if(rs03.next()) {
				brog_div_cd_1 = checkNull(rs03.getString(1));
			}
			
			// Brokerage Map에 Brokerage div cd의 첫번째 자리값을 넣는다.
			brogMap.put("BROG_DIV_CD_1", brog_div_cd_1);
			// Brokerage div cd의 첫번째 자리값을 구한다. -------end-------
			
			// Brokerage Map에 Cancel 여부를 'Y'로 셋팅한다.
			brogMap.put("CANCEL_YN", "Y");
			
			// Booking HashMap에 담는다.
			bkgMap.put("brogMap", brogMap); // Booking Map에 Brokerage 정보를 담는다.

		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeResultSet(rs03);
			closeStatement(ps);
			closeStatement(insertPs);
			closeStatement(ps03);
			closeConnection(con);
		}

		return bkgMap;
	}
	
	/**
	 * Vendor에 matching 되는 Freight Forwarder Code를 구한 후 MDM Vendor에 존재하는지 체크한다.<br>
	 * Vendor에 matching 되는 Freight Forwarder Code 존재하지 않을 경우 메시지 처리한다.<br>
	 * Vendor가 MDM Vendor에 존재하지 않을 경우 메시지 처리한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchBRKGCustVndrMatchInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchBRKGCustVndrMatchInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		PreparedStatement ps01 = null;
		PreparedStatement ps02 = null;
		PreparedStatement ps03 = null;
		// DB ResultSet
		ResultSet rs = null;
		ResultSet rs01 = null;
		ResultSet rs02 = null;
		ResultSet rs03 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		// Freight Forwarder
		String sFf_cust_seq = "";	// frt_fwrd_seq
		int iFf_cust_seq = 0;		// frt_fwrd_seq
		
		// Vendor
		String vndr_cnt_cd = "";
		int vndr_seq = 0;
		String sh_ff_check_flag = "";
		String canada_chk = "";
		
		// Freight Forwarder 체크
		String ff_check = "";

		String bkg_no = "";
		String shpr_nm = "";
		String ff_nm = "";
		// Brokerage 정보를 담고 있는 HashMap
		HashMap brogMap = null;

		StringBuffer queryStr = new StringBuffer();
		StringBuffer queryStr01 = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();
		StringBuffer queryStr03 = new StringBuffer();
		
		// Shipper와 Freight Forwarder 관계 조회 쿼리
		queryStr01.append("SELECT decode(?, 'CA', 1, 0) + decode(?, 'CA', 1, 0) + decode(?, 'CA', 1, 0) canada_chk \n");
		queryStr01.append("  FROM DUAL \n");
		
		// Vendor에 matching 되는 Freight Forwarder Code를 조회한다.
		queryStr.append("SELECT vndr_cnt_cd, to_char(vndr_seq, 'FM000000') vndr_seq \n");
		queryStr.append("  FROM agt_brog_cust_mtch \n");
		queryStr.append(" WHERE cust_cnt_cd = ? \n"); 
		queryStr.append("	AND cust_seq = ? \n");
		
		// CUSTOMER 조회 쿼리
		queryStr03.append("SELECT a.cust_nm shpr_nm, \n");
		queryStr03.append("	      b.cust_nm ff_nm \n");
		queryStr03.append("  FROM BKG_CUSTOMER a, BKG_CUSTOMER b \n");
		queryStr03.append(" WHERE a.bkg_no = ? \n");
		queryStr03.append("	  AND a.bkg_cust_tp_cd = 'S' \n");
		queryStr03.append("	  AND a.bkg_no = b.bkg_no(+) \n");
		queryStr03.append("	  AND b.bkg_cust_tp_cd = 'F' \n");

		bkg_no = checkNull((String)bkgMap.get("BKG_NO"));

		try {
			
			ff_check = checkNull((String)bkgMap.get("FF_CHECK"));
			bkg_no = checkNull((String)bkgMap.get("BKG_NO"));
			// Brokerage 정보를 담고 있는 HashMap
			brogMap = (HashMap)bkgMap.get("brogMap");
			sFf_cust_seq = checkNull((String)bkgMap.get("FF_CUST_SEQ"));		// frt_fwrd_seq
			sh_ff_check_flag = checkNull((String)bkgMap.get("SH_FF_CHECK_FLAG"));
			
			if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
				iFf_cust_seq = Integer.parseInt(sFf_cust_seq);
			}
			
			con = getConnection();

			// FF Code가 없으면 Error처리하고 Return한다.
			if("1".equals(ff_check)) {
				// 데이타가 존재하지 않을 경우 Error를 agt_brog_comm에 저장한다.
				brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00033", new String[]{ (String)bkgMap.get("FF_CNT_CD")+(String)bkgMap.get("FF_CUST_SEQ") }).getUserMessage()); // Freight Forwarder Customer Code does not exist in Booking Customer Info. Freight Forwarder[$s]
				// 2007.08.28 Freight Forwarder Customer Code 가 없을 때 저장하지 않는다.(주석처리)
				//createBRKGCommErrorMSG( con, brogMap );
				bkgMap.put("brogMap", brogMap);
				return bkgMap;
			}
log.debug("111111111111111 sh_ff_check_flag : "+sh_ff_check_flag);

			// 2007.11.12 추가 AGT00060 에러 메시지가 AGT00001 보다 먼저 Display 
			// 미국인 경우 Shipper와 Freight Forwarder가 동일하면 주지 않는다. -------start-------
			if("1".equals(sh_ff_check_flag)) {
				
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps01 = new LoggableStatement(con, queryStr01.toString());
				} else {
					ps01 = con.prepareStatement(queryStr01.toString());
				}
				
	            // 쿼리에 변수 세팅.
				i = 1;
				ps01.setString(i++, checkNull((String)bkgMap.get("POR_CNT_CD")));
				ps01.setString(i++, checkNull((String)bkgMap.get("POL_CNT_CD")));
				ps01.setString(i++, checkNull((String)bkgMap.get("FF_CNT_CD")));
	
				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps01).getQueryString());
				rs01 = ps01.executeQuery();
				log.debug("\n SQL :" + ((LoggableStatement)ps01).getQueryString());
				
				if(rs01.next()) {
					canada_chk = rs01.getString(1);
				}
log.debug("2222222222222222 canada_chk : "+canada_chk);
				// canada_chk = 0 즉 US 이면 Commission 안 준다.
				if("0".equals(canada_chk)) {
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00060", new String[]{ (String)bkgMap.get("SHPR_CNT_CD")+(String)bkgMap.get("SHPR_CUST_SEQ"), (String)bkgMap.get("FF_CNT_CD")+(String)bkgMap.get("FF_CUST_SEQ") }).getUserMessage()); // Shipper & Freight Forwarder Code have the same!
					createBRKGCommErrorMSG( con, brogMap );
					bkgMap.put("brogMap", brogMap);
					return bkgMap;
				}
				
				//2007.11.15 추가 (Shipper 와 Freight Forwarder Name 이 같을경우 에러처리
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps03 = new LoggableStatement(con, queryStr03.toString());
				} else {
					ps03 = con.prepareStatement(queryStr03.toString());
				}
				
	            // 쿼리에 변수 세팅.
				i = 1;
				ps03.setString(i++, bkg_no);
	
				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps03).getQueryString());
				rs03 = ps03.executeQuery();
				log.debug("\n SQL :" + ((LoggableStatement)ps03).getQueryString());
				
				if(rs03.next()) {
					shpr_nm = checkNull(rs03.getString("shpr_nm")).trim();
					ff_nm = checkNull(rs03.getString("ff_nm")).trim();
				}
//				log.debug("SHPR_NM : "+shpr_nm);
//				log.debug("FF_NM : "+ff_nm);
				
				if(shpr_nm.equals(ff_nm)){
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00079", new String[]{ (String)bkgMap.get("SHPR_CNT_CD")+(String)bkgMap.get("SHPR_CUST_SEQ"), (String)bkgMap.get("FF_CNT_CD")+(String)bkgMap.get("FF_CUST_SEQ") }).getUserMessage()); // Shipper & Freight Forwarder Code have the same!
					createBRKGCommErrorMSG( con, brogMap );
					bkgMap.put("brogMap", brogMap);
					return bkgMap; 
				}				
				
			}
			// 미국인 경우 Shipper와 Freight Forwarder가 동일하면 주지 않는다. -------end-------			
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
			// Vendor에 matching 되는 Freight Forwarder Code를 구한다. -------start-------
            // 쿼리에 변수 세팅.
			i = 1;
			ps.setString(i++, checkNull((String)bkgMap.get("FF_CNT_CD")));
			ps.setInt(i++, iFf_cust_seq);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if(rs.next()) {	// Vendor에 matching 되는 Freight Forwarder Code 존재시
				vndr_cnt_cd = rs.getString("vndr_cnt_cd");
				vndr_seq = rs.getInt("vndr_seq");
				
				// Brokerage Map에 넣는다.
				brogMap.put("VNDR_CNT_CD", vndr_cnt_cd);
				brogMap.put("VNDR_SEQ", String.valueOf(vndr_seq));
				
			} else {	// Vendor에 matching 되는 Freight Forwarder Code가 존재하지 않을 경우 메시지 처리한다.
				brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00001", new String[]{ (String)bkgMap.get("FF_CNT_CD")+sFf_cust_seq, vndr_cnt_cd+vndr_seq } ).getUserMessage()); // Freight Forwarder vs service provider does not match. Freight Forwarder[$s] Service Provider[$s]
				createBRKGCommErrorMSG( con, brogMap );
				bkgMap.put("brogMap", brogMap);
				return bkgMap;
			}
			// Vendor에 matching 되는 Freight Forwarder Code를 구한다. -------end-------
			
			// MDM Vendor를 구한다. -------start-------
			i = 1; // 초기화한다.
			
			// Vendor의 MDM_VENDOR를 조회한다.
			queryStr02.append("SELECT '*' vendor \n");
			queryStr02.append("  FROM mdm_vendor \n");
			queryStr02.append(" WHERE vndr_seq = ? \n");
			queryStr02.append("	AND nvl(delt_flg, 'N') = 'N' \n");
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps02 = new LoggableStatement(con, queryStr02.toString());
			} else {
				ps02 = con.prepareStatement(queryStr02.toString());
			}

            // 쿼리에 변수 세팅.
			ps02.setInt(i++, vndr_seq);

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
			rs02 = ps02.executeQuery();

			// MDM Vendor가 존재하지 않을 경우 메시지 처리한다.
			if(!rs02.next()) {
				brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00003", new String[]{ vndr_cnt_cd+vndr_seq }).getUserMessage()); // Vendor does not exist in MDM Vendor.
				createBRKGCommErrorMSG( con, brogMap );
				bkgMap.put("brogMap", brogMap);
				return bkgMap;
			}
			// MDM Vendor를 구한다. -------end-------

			// Booking HashMap에 담는다.
			bkgMap.put("brogMap", brogMap); // Booking Map에 Brokerage 정보를 담는다.
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeResultSet(rs01);
			closeResultSet(rs02);
			closeResultSet(rs03);
			closeStatement(ps);
			closeStatement(ps01);
			closeStatement(ps02);
			closeStatement(ps03);
			closeConnection(con);
		}

		return bkgMap;
	}
	
	/**
	 * Brokerage Freight Forwarder 와 Shipper의 이해관계 여부를 체크한다.<br>
	 * Brokerage Freight Forwarder 와 Shipper가 이해관계가 있을 경우 메시지처리한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchBRKGCustShprInterestInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchBRKGCustShprInterestInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		String sFf_cust_seq = "";
		String sShpr_cust_seq = "";
		
		int iFf_cust_seq = 0;
		int iShpr_cust_seq = 0;
		
		// Brokerage 정보를 담고 있는 HashMap
		HashMap brogMap = null;
		
		StringBuffer queryStr = new StringBuffer();

		// Freight Forwarder 와 Shipper의 이해관계 여부 체크 쿼리
		queryStr.append("SELECT '*' brog \n");
		queryStr.append("  FROM agt_brog_cust_int \n");
		queryStr.append(" WHERE cust_cnt_cd = ? \n");
		queryStr.append("	AND cust_seq = TO_NUMBER(?) \n");
		queryStr.append("	AND shpr_cnt_cd = ? \n");
		queryStr.append("	AND shpr_seq = TO_NUMBER(?) \n");

		String bkg_no       = checkNull((String)bkgMap.get("BKG_NO"));

		
		try {
			
			// Brokerage 정보를 담고 있는 HashMap
			brogMap = (HashMap)bkgMap.get("brogMap");			
			sFf_cust_seq = checkNull((String)bkgMap.get("FF_CUST_SEQ"));		// ff_cust_seq
			sShpr_cust_seq = checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));	// shpr_cust_seq
			
			if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
				iFf_cust_seq = Integer.parseInt(sFf_cust_seq);
			}
			
			if(sShpr_cust_seq.length() > 0 && !"*".equals(sShpr_cust_seq)) {
				iShpr_cust_seq = Integer.parseInt(sShpr_cust_seq);
			}
			
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, checkNull((String)bkgMap.get("FF_CNT_CD")));
			ps.setInt(i++, iFf_cust_seq);
			ps.setString(i++, checkNull((String)bkgMap.get("SHPR_CNT_CD")));
			ps.setInt(i++, iShpr_cust_seq);

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			// Freight Forwarder 와 Shipper가 이해관계가 있을 경우 Commission을 지불하지 않는다.
			if(rs.next()) {
				brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00005", new String[]{ (String)bkgMap.get("FF_CNT_CD")+sFf_cust_seq, (String)bkgMap.get("SHPR_CNT_CD")+sShpr_cust_seq }).getUserMessage()); // Freight Forwarder Customer has interests with Shipper. Freight Forwarder[$s] Shipper[$s] 
				createBRKGCommErrorMSG( con, brogMap );
				bkgMap.put("brogMap", brogMap);
				return bkgMap;
			}			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return bkgMap;
	}

	/**
	 * 미국인 경우 Shipper와 Freight Forwarder가 동일하면 주지 않는다.<br>
	 * BL no가 있으면 MEMO BL를 check한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap checkBRKGOtherInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n checkBRKGOtherInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		PreparedStatement ps02 = null;
		// DB ResultSet
		ResultSet rs = null;
		ResultSet rs02 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// Brokerage 정보를 담고 있는 HashMap
		HashMap brogMap = null;
		
		String sh_ff_check_flag = "";
		String canada_chk = "";
		String memo_check = "";
		String ff_cnt_cd = "";
		String fmc_no = "";
		String bkg_no = "";
		String bl_no = "";
		
		StringBuffer queryStr = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();

		// Shipper와 Freight Forwarder 관계 조회 쿼리
		queryStr.append("    SELECT \n");
		queryStr.append("           DECODE(?, 'CA', 1, 0) \n");
		queryStr.append("         + DECODE(?, 'CA', 1, 0) \n");
		queryStr.append("         + DECODE(?, 'CA', 1, 0) AS CANADA_CHK \n");
		queryStr.append("      FROM DUAL \n");

		ff_cnt_cd = checkNull((String)bkgMap.get("FF_CNT_CD"));
		fmc_no = checkNull((String)bkgMap.get("FMC_NO"));
		bl_no = checkNull((String)bkgMap.get("BL_NO"));
		bkg_no = checkNull((String)bkgMap.get("BKG_NO"));
		
		try {

			// Brokerage 정보를 담고 있는 HashMap
			brogMap = (HashMap)bkgMap.get("brogMap");
			sh_ff_check_flag = checkNull((String)bkgMap.get("SH_FF_CHECK_FLAG"));

			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
			// 미국인 경우 Shipper와 Freight Forwarder가 동일하면 주지 않는다. -------start-------
			if("1".equals(sh_ff_check_flag)) {
				
	            // 쿼리에 변수 세팅.
				ps.setString(i++, checkNull((String)bkgMap.get("POR_CNT_CD")));
				ps.setString(i++, checkNull((String)bkgMap.get("POL_CNT_CD")));
				ps.setString(i++, checkNull((String)bkgMap.get("FF_CNT_CD")));
	
				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
				rs = ps.executeQuery();
	
				// Loggable Statement 사용에 의해 추가 
//				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//					log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//				} else {
//					log.debug("\n SQL :" + queryStr.toString() );
//				}
				
				if(rs.next()) {
					canada_chk = rs.getString(1);
				}

				// canada_chk = 0 즉 US 이면 Commission 안 준다.
				if("0".equals(canada_chk)) {
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00060", new String[]{ (String)bkgMap.get("SHPR_CNT_CD")+(String)bkgMap.get("SHPR_CUST_SEQ"), (String)bkgMap.get("FF_CNT_CD")+(String)bkgMap.get("FF_CUST_SEQ") }).getUserMessage()); // Shipper & Freight Forwarder Code have the same!
					createBRKGCommErrorMSG( con, brogMap );
					bkgMap.put("brogMap", brogMap);
					return bkgMap;
				}
			}
			// 미국인 경우 Shipper와 Freight Forwarder가 동일하면 주지 않는다. -------end-------
			
			// BL no가 존재하면 MEMO BL check -------start-------
			if(bl_no.length() > 0) {
				i = 1; // 초기화한다.
				
				queryStr02.append("    SELECT \n");
				queryStr02.append("      CASE \n");
				queryStr02.append("      WHEN BKG.BL_NO_TP = '9' \n");
				queryStr02.append("      THEN 1 \n");
				queryStr02.append("      ELSE 0 \n");
				queryStr02.append("       END AS MEMO_CHECK \n");
				queryStr02.append("      FROM BKG_BOOKING BKG \n");
				queryStr02.append("     WHERE BKG.BKG_NO = ? \n");

				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps02 = new LoggableStatement(con, queryStr02.toString());
				} else {
					ps02 = con.prepareStatement(queryStr02.toString());
				}
				
	            // 쿼리에 변수 세팅.
				ps02.setString(i++, bkg_no);
	
				// Loggable Statement 사용에 의해 추가 
//				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//					log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//				} else {
//					log.debug("\n SQL :" + queryStr.toString() );
//				}
//				log.debug("\n\n BL_NO :: "+(String)bkgMap.get("BL_NO"));
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
				rs02 = ps02.executeQuery();
				
				if(rs02.next()) {
					memo_check = rs02.getString(1);
				}
	
				// memo_check = 1이면 Commission 안 준다.
				if("1".equals(memo_check)) {
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00013", new String[]{bl_no}).getUserMessage()); // BL No[$s] is Memo BL!
					createBRKGCommErrorMSG( con, brogMap );
					bkgMap.put("brogMap", brogMap);
					return bkgMap;
				}
			}
			// BL no가 존재하면 MEMO BL check -------end-------

			// FF Code가 "US"이고 fmcno가 없으면 Error처리하고 Return한다.
			log.debug("FF_CNT_CD :"+ff_cnt_cd);
			log.debug("FMCNO :"+fmc_no);
			if ("US".equals(ff_cnt_cd) && ("*".equals(fmc_no) || "".equals(fmc_no)))
			{
				//데이타가 존재하지 않을 경우 Error를 agt_brog_comm에 저장한다.
				brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00061", new String[]{ (String)bkgMap.get("FF_CNT_CD")+(String)bkgMap.get("FF_CUST_SEQ") }).getUserMessage()); // Freight Forwarder does not have FMC No! Freight Forwarder[$s]
				createBRKGCommErrorMSG( con, brogMap );
				bkgMap.put("brogMap", brogMap);
				return bkgMap;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeResultSet(rs02);
			closeStatement(ps);
			closeStatement(ps02);
			closeConnection(con);
		}
		return bkgMap;
	}

	/**
	 * Brokerage Agreement 요율 정보를 조회한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @param String brog_cnt_cd
	 * @param int brog_cust_seq
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchBRKGAGMTRateInfo( HashMap bkgMap, String brog_cnt_cd, int brog_cust_seq ) throws DAOException {

		log.debug("\n\n searchBRKGAGMTRateInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		// Brokerage 요율 정보 체크위한 Count 변수
		int cnt = 0;
		// Error 처리 위한 Flag
		boolean error_flag = false;
		
		// Brokerage 정보를 담고 있는 HashMap
		HashMap brogMap = null;
		
		// Brokerage Agreement 요출 정보를 담는 ArrayList
		ArrayList brogRtList = new ArrayList();
		
		// 조회 쿼리
		StringBuffer queryStr = new StringBuffer();
		StringBuffer queryStr2 = new StringBuffer();

		String shpr_cnt_cd = "";
		String sShpr_cust_seq = "";
		String etd_dt = "";
		String sc_no =  "";
		String rfa_no = "";
		String rep_cmdt_cd = "";
		String cmdt_cd = "";
		String por_cd = "";
		String por_rgn_cd = "";
		String por_cnt_cd = "";
		String por_sconti_cd = "";
		String por_conti_cd = "";
		String pol_cd = "";
		String pol_rgn_cd = "";
		String pol_cnt_cd = "";
		String pol_sconti_cd = "";
		String pol_conti_cd = "";
		String pod_cd = "";
		String pod_rgn_cd = "";
		String pod_cnt_cd = "";
		String pod_sconti_cd = "";
		String pod_conti_cd = "";

		double bkg_brog_rt = 0;
		double brog_bx_rt = 0;
		double brog_teu_rt = 0;
		double brog_feu_rt = 0;
		double brog_rf_rt = 0;
		double rt_total = 0;
		
		int shpr_cust_seq = 0;

		String bkg_no       = checkNull((String)bkgMap.get("BKG_NO"));

		
		try {

			// Brokerage 정보를 담고 있는 HashMap
			brogMap = (HashMap)bkgMap.get("brogMap");
			sShpr_cust_seq = checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));
			
			if(!"".equals(sShpr_cust_seq) && !"*".equals(sShpr_cust_seq)) {
				shpr_cust_seq = Integer.parseInt(sShpr_cust_seq);
			}

			shpr_cnt_cd = (String)bkgMap.get("SHPR_CNT_CD");
			etd_dt = (String)bkgMap.get("TRUNK_ETD_DT");
			sc_no = (String)bkgMap.get("SC_NO");
			rfa_no = (String)bkgMap.get("RFA_NO");
			rep_cmdt_cd = (String)bkgMap.get("REP_CMDT_CD");
			cmdt_cd = (String)bkgMap.get("CMDT_CD");
			por_cd = (String)bkgMap.get("POR_CD");
			por_rgn_cd = (String)bkgMap.get("POR_RGN_CD");
			por_cnt_cd = (String)bkgMap.get("POR_CNT_CD");
			por_sconti_cd = (String)bkgMap.get("POR_SCONTI_CD");
			por_conti_cd = (String)bkgMap.get("POR_CONTI_CD");
			pol_cd = (String)bkgMap.get("POL_CD");
			pol_rgn_cd = (String)bkgMap.get("POL_RGN_CD");
			pol_cnt_cd = (String)bkgMap.get("POL_CNT_CD");
			pol_sconti_cd = (String)bkgMap.get("POL_SCONTI_CD");
			pol_conti_cd = (String)bkgMap.get("POL_CONTI_CD");
			pod_cd = (String)bkgMap.get("POD_CD");
			pod_rgn_cd = (String)bkgMap.get("POD_RGN_CD");
			pod_cnt_cd = (String)bkgMap.get("POD_CNT_CD");
			pod_sconti_cd = (String)bkgMap.get("POD_SCONTI_CD");
			pod_conti_cd = (String)bkgMap.get("POD_CONTI_CD");
			
			queryStr2.append("					AND NVL(por_rout_cd, '*') = DECODE(NVL(por_grp_tp_cd, '*'), '5', '"+por_cd+"', '4', '"+por_rgn_cd+"', '3', '"+por_cnt_cd+"', '2', '"+por_sconti_cd+"', '1', '"+por_conti_cd+"', '*', '*') \n");
			queryStr2.append("					AND NVL(pol_rout_cd, '*') = DECODE(NVL(pol_grp_tp_cd, '*'), '5', '"+pol_cd+"', '4', '"+pol_rgn_cd+"', '3', '"+pol_cnt_cd+"', '2', '"+pol_sconti_cd+"', '1', '"+pol_conti_cd+"', '*', '*') \n");
			queryStr2.append("					AND NVL(pod_rout_cd, '*') = DECODE(NVL(pod_grp_tp_cd, '*'), '5', '"+pod_cd+"', '4', '"+pod_rgn_cd+"', '3', '"+pod_cnt_cd+"', '2', '"+pod_sconti_cd+"', '1', '"+pod_conti_cd+"', '*', '*') \n");

			queryStr.append("SELECT a.brog_cnt_cd, TO_CHAR(a.brog_cust_seq,'FM000000') brog_cust_seq, \n");
			queryStr.append("	a.shpr_cnt_cd, TO_CHAR(a.shpr_seq, 'FM000000') shpr_seq, \n");
			queryStr.append("	a.brog_div_cd, a.brog_tp_cd, a.bkg_brog_rt, NVL(RTRIM(a.brog_chg_ctnt), ' ') brog_chg_ctnt, \n");
			queryStr.append("	NVL(a.brog_bx_rt, 0) brog_bx_rt, NVL(a.brog_teu_rt, 0) brog_teu_rt, NVL(a.brog_feu_rt, 0) brog_feu_rt, \n");
			queryStr.append("	NVL(a.brog_rf_rt, 0) brog_rf_rt, a.fm_eff_dt, a.to_eff_dt, NVL(a.brog_knd_cd, 'F') brog_knd_cd, brog_rt_seq \n");
			queryStr.append("FROM agt_brog_agmt_rt a \n");
			queryStr.append("WHERE a.brog_cnt_cd = ? \n");
			queryStr.append("	AND a.brog_cust_seq = ? \n");
			queryStr.append("	AND NVL(a.shpr_cnt_cd, '*')||NVL(a.shpr_seq, 0 ) = ( /* shipper가 존재하는지 */ \n");
			queryStr.append("		SELECT MAX(x) \n");
			queryStr.append("		FROM ( \n");
			queryStr.append("				SELECT	NVL(shpr_cnt_cd, '*')||NVL(shpr_seq, 0 ) x \n");
			queryStr.append("				FROM agt_brog_agmt_rt \n");
			queryStr.append("				WHERE brog_cnt_cd = ? \n");
			queryStr.append("					AND brog_cust_seq = ? \n");
			queryStr.append("					AND NVL(shpr_cnt_cd, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(shpr_seq, 0 ) IN (?, 0) \n");
			queryStr.append("					AND fm_eff_dt <= SUBSTR(?, 1, 8) \n");
			queryStr.append("					AND to_eff_dt >= SUBSTR(?, 1, 8) \n");
			queryStr.append("					AND NVL(sc_no, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(rfa_no, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(cmdt_cd, '*') IN ('*',DECODE(cmdt_tp_cd, '2', ?, '3', ?)) \n");
			
			queryStr.append(queryStr2.toString());
			
			queryStr.append("			) \n");
			queryStr.append("		) \n");
			queryStr.append("	AND a.fm_eff_dt <= SUBSTR(?, 1, 8) \n");
			queryStr.append("	AND a.to_eff_dt >= SUBSTR(?, 1, 8) \n");
			queryStr.append("	AND NVL(a.sc_no, '*') = ( /* sc no가 존재하는지 */ \n");
			queryStr.append("		SELECT MAX(x) \n");
			queryStr.append("		FROM ( \n");
			queryStr.append("				SELECT NVL(sc_no, '*') x \n");
			queryStr.append("				FROM agt_brog_agmt_rt \n");
			queryStr.append("				WHERE brog_cnt_cd = ? \n");
			queryStr.append("					AND brog_cust_seq = ? \n");
			queryStr.append("					AND NVL(shpr_cnt_cd, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(shpr_seq, 0 ) IN (?, 0) \n");
			queryStr.append("					AND fm_eff_dt <= SUBSTR(?, 1, 8) \n");
			queryStr.append("					AND to_eff_dt >= SUBSTR(?, 1, 8) \n");
			queryStr.append("					AND NVL(sc_no, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(rfa_no, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(cmdt_cd, '*') IN ('*',DECODE(cmdt_tp_cd, '2', ?, '3', ?)) \n");
			
			queryStr.append(queryStr2.toString());
			
			queryStr.append("			) \n");
			queryStr.append("		) \n");
			queryStr.append("	AND NVL(a.rfa_no, '*') = ( /* RFA가 존재하는지 */ \n");
			queryStr.append("		SELECT MAX(x) \n");
			queryStr.append("		FROM ( \n");
			queryStr.append("				SELECT NVL(rfa_no, '*') x \n");
			queryStr.append("				FROM agt_brog_agmt_rt \n");
			queryStr.append("				WHERE brog_cnt_cd = ? \n");
			queryStr.append("					AND brog_cust_seq = ? \n");
			queryStr.append("					AND NVL(shpr_cnt_cd, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(shpr_seq, 0 ) IN (?, 0) \n");
			queryStr.append("					AND fm_eff_dt <= SUBSTR(?, 1, 8) \n");
			queryStr.append("					AND to_eff_dt >= SUBSTR(?, 1, 8) \n");
			queryStr.append("					AND NVL(sc_no, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(rfa_no, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(cmdt_cd, '*') IN ('*',DECODE(cmdt_tp_cd, '2', ?, '3', ?)) \n");
			
			queryStr.append(queryStr2.toString());
			
			queryStr.append("			) \n");
			queryStr.append("		) \n");
			queryStr.append("	AND NVL(a.cmdt_cd, '*') = ( /* ReP Commodity가  존재하는지 */ \n");
			queryStr.append("		SELECT MAX(x) \n");
			queryStr.append("		FROM ( \n");
			queryStr.append("				SELECT NVL(cmdt_cd, '*') x \n");
			queryStr.append("				FROM agt_brog_agmt_rt \n");
			queryStr.append("				WHERE brog_cnt_cd = ? \n");
			queryStr.append("					AND brog_cust_seq = ? \n");
			queryStr.append("					AND NVL(shpr_cnt_cd, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(shpr_seq, 0 ) IN (?, 0) \n");
			queryStr.append("					AND fm_eff_dt <= SUBSTR(?, 1, 8) \n");
			queryStr.append("					AND to_eff_dt >= SUBSTR(?, 1, 8) \n");
			queryStr.append("					AND NVL(sc_no, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(rfa_no, '*') IN (?, '*') \n");
			queryStr.append("					AND NVL(cmdt_cd, '*') IN ('*',DECODE(cmdt_tp_cd, '2', ?, '3', ?)) \n");
			
			queryStr.append(queryStr2.toString());
			
			queryStr.append("			) \n");
			queryStr.append("		) \n");
			queryStr.append("	AND NVL(a.cmdt_tp_cd, '*') IN ( \n");
			queryStr.append("		SELECT MAX(NVL(cmdt_tp_cd, '*')) \n");
			queryStr.append("		FROM agt_brog_agmt_rt \n");
			queryStr.append("		WHERE brog_cnt_cd = ? \n");
			queryStr.append("			AND brog_cust_seq = ? \n");
			queryStr.append("			AND NVL(shpr_cnt_cd, '*') IN (?, '*') \n");
			queryStr.append("			AND NVL(shpr_seq, 0 ) IN (?, 0) \n");
			queryStr.append("			AND fm_eff_dt <= SUBSTR(?, 1, 8) \n");
			queryStr.append("			AND to_eff_dt >= SUBSTR(?, 1, 8) \n");
			queryStr.append("			AND NVL(sc_no, '*') IN (?, '*') \n");
			queryStr.append("			AND NVL(rfa_no, '*') IN (?, '*') \n");
			queryStr.append("			AND NVL(cmdt_cd, '*') IN ('*',DECODE(cmdt_tp_cd, '2', ?, '3', ?)) \n");
			
			queryStr.append(queryStr2.toString());
			
			queryStr.append("		) \n");
			queryStr.append("	/* 해당 Route별로 존재하는지 */ \n");
			
			queryStr.append(queryStr2.toString());
			
			queryStr.append("	AND NVL(a.por_grp_tp_cd, '*')||NVL(a.pol_grp_tp_cd, '*')||NVL(a.pod_grp_tp_cd, '*') IN ( \n");
			queryStr.append("		SELECT MAX(NVL(por_grp_tp_cd, '*'))||MAX(NVL(pol_grp_tp_cd, '*'))||MAX(NVL(pod_grp_tp_cd, '*')) \n");
			queryStr.append("		FROM agt_brog_agmt_rt \n");
			queryStr.append("		WHERE brog_cnt_cd = ? \n");
			queryStr.append("			AND brog_cust_seq = ? \n");
			queryStr.append("			AND NVL(shpr_cnt_cd, '*') IN (?, '*') \n");
			queryStr.append("			AND NVL(shpr_seq, 0 ) IN (?, 0) \n");
			queryStr.append("			AND fm_eff_dt <= SUBSTR(?, 1, 8) \n");
			queryStr.append("			AND to_eff_dt >= SUBSTR(?, 1, 8) \n");
			queryStr.append("			AND NVL(sc_no, '*') IN (?, '*') \n");
			queryStr.append("			AND NVL(rfa_no, '*') IN (?, '*') \n");
			queryStr.append("			AND NVL(cmdt_cd, '*') IN ('*',DECODE(cmdt_tp_cd, '2', ?, '3', ?)) \n");
			
			queryStr.append(queryStr2.toString());
			
			queryStr.append("		) \n");
			
			// Connectiond을 얻어 온다.
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, brog_cnt_cd);		// brog_cnt_cd
			ps.setInt(i++, brog_cust_seq);		// brog_cust_seq
			ps.setString(i++, brog_cnt_cd);		// brog_cnt_cd
			ps.setInt(i++, brog_cust_seq);		// brog_cust_seq
			ps.setString(i++, shpr_cnt_cd);		// shpr_cnt_cd
			ps.setInt(i++, shpr_cust_seq);		// shpr_cust_seq
			ps.setString(i++, etd_dt);			// etd_dt
			ps.setString(i++, etd_dt);			// etd_dt
			ps.setString(i++, sc_no);			// sc_no
			ps.setString(i++, rfa_no);			// rfa_no
			ps.setString(i++, rep_cmdt_cd);		// rep_cmdt_cd
			ps.setString(i++, cmdt_cd);			// cmdt_cd
			ps.setString(i++, etd_dt);			// etd_dt
			ps.setString(i++, etd_dt);			// etd_dt
			ps.setString(i++, brog_cnt_cd);		// brog_cnt_cd
			ps.setInt(i++, brog_cust_seq);		// brog_cust_seq
			ps.setString(i++, shpr_cnt_cd);		// shpr_cnt_cd
			ps.setInt(i++, shpr_cust_seq);		// shpr_cust_seq
			ps.setString(i++, etd_dt);			// etd_dt
			ps.setString(i++, etd_dt);			// etd_dt		
			ps.setString(i++, sc_no);			// sc_no
			ps.setString(i++, rfa_no);			// rfa_no
			ps.setString(i++, rep_cmdt_cd);		// rep_cmdt_cd
			ps.setString(i++, cmdt_cd);			// cmdt_cd
			ps.setString(i++, brog_cnt_cd);		// brog_cnt_cd
			ps.setInt(i++, brog_cust_seq);		// brog_cust_seq
			ps.setString(i++, shpr_cnt_cd);		// shpr_cnt_cd
			ps.setInt(i++, shpr_cust_seq);		// shpr_cust_seq
			ps.setString(i++, etd_dt);			// etd_dt
			ps.setString(i++, etd_dt);			// etd_dt		
			ps.setString(i++, sc_no);			// sc_no
			ps.setString(i++, rfa_no);			// rfa_no
			ps.setString(i++, rep_cmdt_cd);		// rep_cmdt_cd
			ps.setString(i++, cmdt_cd);			// cmdt_cd
			ps.setString(i++, brog_cnt_cd);		// brog_cnt_cd
			ps.setInt(i++, brog_cust_seq);		// brog_cust_seq
			ps.setString(i++, shpr_cnt_cd);		// shpr_cnt_cd
			ps.setInt(i++, shpr_cust_seq);		// shpr_cust_seq
			ps.setString(i++, etd_dt);			// etd_dt
			ps.setString(i++, etd_dt);			// etd_dt		
			ps.setString(i++, sc_no);			// sc_no
			ps.setString(i++, rfa_no);			// rfa_no
			ps.setString(i++, rep_cmdt_cd);		// rep_cmdt_cd
			ps.setString(i++, cmdt_cd);			// cmdt_cd
			ps.setString(i++, brog_cnt_cd);		// brog_cnt_cd
			ps.setInt(i++, brog_cust_seq);		// brog_cust_seq
			ps.setString(i++, shpr_cnt_cd);		// shpr_cnt_cd
			ps.setInt(i++, shpr_cust_seq);		// shpr_cust_seq
			ps.setString(i++, etd_dt);			// etd_dt
			ps.setString(i++, etd_dt);			// etd_dt		
			ps.setString(i++, sc_no);			// sc_no
			ps.setString(i++, rfa_no);			// rfa_no
			ps.setString(i++, rep_cmdt_cd);		// rep_cmdt_cd
			ps.setString(i++, cmdt_cd);			// cmdt_cd
			ps.setString(i++, brog_cnt_cd);		// brog_cnt_cd
			ps.setInt(i++, brog_cust_seq);		// brog_cust_seq
			ps.setString(i++, shpr_cnt_cd);		// shpr_cnt_cd
			ps.setInt(i++, shpr_cust_seq);		// shpr_cust_seq
			ps.setString(i++, etd_dt);			// etd_dt
			ps.setString(i++, etd_dt);			// etd_dt		
			ps.setString(i++, sc_no);			// sc_no
			ps.setString(i++, rfa_no);			// rfa_no
			ps.setString(i++, rep_cmdt_cd);		// rep_cmdt_cd
			ps.setString(i++, cmdt_cd);			// cmdt_cd

			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.debug("\n Brokerage요율 : \n" + ((LoggableStatement)ps).getQueryString());
			} else {
				log.debug("\n Brokerage요율 : \n" + queryStr.toString() );
			}
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			while(rs.next()) {
				
				// 결과를 HashMap에 담는다.
				HashMap map = new HashMap();
				
				map.put("BROG_CNT_CD", rs.getString("brog_cnt_cd"));
				map.put("BROG_CUST_SEQ", rs.getString("brog_cust_seq"));
				map.put("SHPR_CNT_CD", rs.getString("shpr_cnt_cd"));
				map.put("SHPR_SEQ", rs.getString("shpr_seq"));
				map.put("BROG_DIV_CD", rs.getString("brog_div_cd"));
				map.put("BROG_TP_CD", rs.getString("brog_tp_cd"));
				map.put("BKG_BROG_RT", rs.getString("bkg_brog_rt"));
				map.put("BROG_CHG_CTNT", rs.getString("brog_chg_ctnt"));
				map.put("BROG_BX_RT", rs.getString("brog_bx_rt")); 
				map.put("BROG_TEU_RT", rs.getString("brog_teu_rt"));
				map.put("BROG_FEU_RT", rs.getString("brog_feu_rt"));
				map.put("BROG_RF_RT", rs.getString("brog_rf_rt"));
				map.put("FM_EFF_DT", rs.getString("fm_eff_dt"));
				map.put("TO_EFF_DT", rs.getString("to_eff_dt"));
				map.put("BROG_KND_CD", rs.getString("brog_knd_cd"));
				map.put("BROG_RT_SEQ", rs.getString("brog_rt_seq"));
				
				// 요율 정보를 brogRtList에 추가한다.
				brogRtList.add(map);
				
				bkg_brog_rt = rs.getDouble("bkg_brog_rt");
				brog_bx_rt = rs.getDouble("brog_bx_rt");
				brog_teu_rt = rs.getDouble("brog_teu_rt");
				brog_feu_rt = rs.getDouble("brog_feu_rt");
				brog_rf_rt = rs.getDouble("brog_rf_rt");
				
				cnt++; // 요율 정보 체크 위한 변수를 증가 시킨다.
			}

			rt_total = bkg_brog_rt + brog_bx_rt + brog_teu_rt + brog_feu_rt + brog_rf_rt;

			// brog_cust_seq가 999999 이면서 요율 정보가 존재하지 않거나 2개 이상 존재하면 Error 처리한다.
			// brog_cust_seq가 999999 가 아니면서 요율 정보가 2개 이상 존재하면 Error 처리한다.
			if( brog_cust_seq == 999999 ) {
				if( cnt != 1 ) {
					error_flag = true;
				} else {
					// 요율값이 0일경우 Error 메시지 처리한 후 다음 부킹으으로..
					if(!(rt_total != 0)) { // 부동소수점의 == 사용은 지양한다.
						error_flag = true;
					}
				}
			} else {
				if( cnt > 1 ) {
					error_flag = true;
				} else {
					// 요율값이 0일경우 Error 메시지 처리한 후 다음 부킹으로..
					if(!(rt_total != 0)) { // 부동소수점의 == 사용은 지양한다.
//						error_flag = true;
						brogRtList.clear(); // Brokerage Rate List를 clear 한다.
					}
				}
			}

			if( error_flag ) {
				if(cnt > 1) {
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00062", new String[]{"["+(String)bkgMap.get("BKG_OFC_CD")+"] [" + (String)bkgMap.get("FF_CNT_CD") + "] [" + (String)bkgMap.get("FF_CUST_SEQ") + "]"}).getUserMessage());
					createBRKGCommErrorMSG( con, brogMap );
				} else {
					// 2007.08.28 Brokerage Agreement Rate Info does not exist 가 없을 때 저장하지 않는다.(주석처리)
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00021", new String[]{(String)bkgMap.get("BKG_OFC_CD"), (String)bkgMap.get("FF_CNT_CD") + (String)bkgMap.get("FF_CUST_SEQ") }).getUserMessage());
					//createBRKGCommErrorMSG( con, brogMap );
				}
				
				bkgMap.put("brogMap", brogMap);
				return bkgMap;
			}

			// Booking HashMap에 담는다.
			bkgMap.put("brogRtList", brogRtList);
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		
		return bkgMap;
	}
	
	/**
	 * Contaner type/size에 따라서 Brokerage Commission을 계산한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap calcBRKGCommInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n calcBRKGCommInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// Brokerage Commission 정보를 담고 있는 HashMap
		HashMap brogMap = null;
		// Brokerage 요율 정보를 담고 있는 ArrayList
		ArrayList brogRtList = null;
		// Brokerage 요율 정보를 담고 있는 HashMap 
		HashMap brogRtMap = null; //반드시 데이타가 존재해야한다.
		
		String bkg_no = "";
		String brog_div_cd = "";	// brog_div_cd
		String brog_div_cd_1 = "";	// brog_div_cd 의 첫째 자리
		String sBrog_box_qty = "";	// box qty
		String sBrog_feu_qty = "";	// feu qty
		String sBrog_reu_qty = "";	// reu qty
		String sBrog_teu_qty = "";	// teu qty
		String sBkg_brog_rt = "";	// rate
		String sBrog_teu_rt = "";	// teu rate
		String sBrog_feu_rt = "";	// feu rate
		String sBrog_rf_rt = "";	// rf rate
		String sBrog_box_rt = "";	// box rate
		String brog_chg_ctnt = "";	// Charge CD
		
		double brog_box_qty = 0;	// box qty
		double brog_feu_qty = 0;	// feu qty
		double brog_reu_qty = 0;	// reu qty
		double brog_teu_qty = 0;	// teu qty
		double bkg_brog_rt = 0;		// brog rate
		double brog_teu_rt =0;		// teu rate
		double brog_feu_rt = 0;		// feu rate
		double brog_rf_rt = 0;		// rf rate
		double brog_box_rt = 0;		// box rate
		double brog_calc_amt = 0;	// amt
		double act_comm_amt = 0;	// 계산값
		
		StringBuffer queryStr = new StringBuffer();

		try {

			//Brokerage Commission 정보를 담고 있는 HashMap
			brogMap = (HashMap)bkgMap.get("brogMap");
			// Brokerage 요율 정보를 담고 있는 ArrayList
			brogRtList = (ArrayList)bkgMap.get("brogRtList");
			// Brokerage 요율 정보를 담고 있는 HashMap 
			brogRtMap = (HashMap)brogRtList.get(0); //반드시 데이타가 존재해야한다.

			bkg_no = (String)bkgMap.get("BKG_NO");
			brog_chg_ctnt = checkNull((String)brogRtMap.get("BROG_CHG_CTNT"));	// brog_chg_ctnt
			brog_div_cd = checkNull((String)brogRtMap.get("BROG_DIV_CD"));	// brog_div_cd
			sBrog_box_qty = checkNull((String)bkgMap.get("BOX"));			// box qty
			sBrog_feu_qty = checkNull((String)bkgMap.get("FEU"));			// feu qty
			sBrog_reu_qty = checkNull((String)bkgMap.get("REU"));			// reu qty
			sBrog_teu_qty = checkNull((String)bkgMap.get("TEU"));			// teu qty
			sBkg_brog_rt = checkNull((String)brogRtMap.get("BKG_BROG_RT"));	// rate
			sBrog_teu_rt = checkNull((String)brogRtMap.get("BROG_TEU_RT"));	// teu rate
			sBrog_feu_rt = checkNull((String)brogRtMap.get("BROG_FEU_RT"));	// feu rate
			sBrog_rf_rt = checkNull((String)brogRtMap.get("BROG_RF_RT"));	// rf rate			
			sBrog_box_rt = checkNull((String)brogRtMap.get("BROG_BX_RT"));	// box rate
			
			if(!"".equals(sBrog_box_qty)) {
				brog_box_qty = Double.parseDouble(sBrog_box_qty);	// box qty
			}
			if(!"".equals(sBrog_feu_qty)) {
				brog_feu_qty = Double.parseDouble(sBrog_feu_qty);	// feu qty
			}
			if(!"".equals(sBrog_reu_qty)) {
				brog_reu_qty = Double.parseDouble(sBrog_reu_qty);	// reu qty
			}
			if(!"".equals(sBrog_teu_qty)) {
				brog_teu_qty = Double.parseDouble(sBrog_teu_qty);	// teu qty
			}
			if(!"".equals(sBkg_brog_rt)) {
				bkg_brog_rt = Double.parseDouble(sBkg_brog_rt);		// rate
			}
			if(!"".equals(sBrog_teu_rt)) {
				brog_teu_rt = Double.parseDouble(sBrog_teu_rt);		// teu rate
			}
			if(!"".equals(sBrog_feu_rt)) {
				brog_feu_rt = Double.parseDouble(sBrog_feu_rt);		// feu rate
			}
			if(!"".equals(sBrog_rf_rt)) {
				brog_rf_rt = Double.parseDouble(sBrog_rf_rt);		// rf rate
			}
			if(!"".equals(sBrog_box_rt)) {
				brog_box_rt = Double.parseDouble(sBrog_box_rt);		// box rate
			}

			if(brog_div_cd.length() >= 1) {
				brog_div_cd_1 = brog_div_cd.substring(0, 1);
			}
			
			// Connection을 얻어 온다.
			con = getConnection();
			
			if("BA".equals(brog_div_cd)) {
				
				queryStr.append("SELECT ROUND (NVL( SUM(CHG_AMT), 0), 2) brog_calc_amt \n");
				queryStr.append("  FROM bkg_chg_rt \n");
				queryStr.append(" WHERE bkg_no = ? \n");
				queryStr.append("	AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
				queryStr.append("	AND curr_cd = 'USD' \n");
				
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps = new LoggableStatement(con, queryStr.toString());
				} else {
					ps = con.prepareStatement(queryStr.toString());
				}
				
	            // 쿼리에 변수 세팅.
				ps.setString(i++, bkg_no);

				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
				rs = ps.executeQuery();
				
				if(rs.next()) {
					brog_calc_amt = rs.getDouble(1);
				}
				
				// brog_calc_amt가 '0'일 경우 Error Message 처리한다.
				if(!(brog_calc_amt != 0)) { // 부동소수점의 == 사용은 지양한다.
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00035").getUserMessage()); // 'BA' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
					// 2007.08.28 'BA' BL Menifested Rate Amount in Brokerage/FAC is '0' error! 때 저장하지 않는다.(주석처리)
					//createBRKGCommErrorMSG( con, brogMap );
					bkgMap.put("brogMap", brogMap);
					return bkgMap;
				}
				
				act_comm_amt = brog_calc_amt*(bkg_brog_rt/100);
				
			} else if("BF".equals(brog_div_cd)) {
				
				queryStr.append("SELECT ROUND (NVL( SUM(CHG_AMT), 0), 2) brog_calc_amt \n");
				queryStr.append("  FROM bkg_chg_rt \n");
				queryStr.append(" WHERE bkg_no = ? \n");
				queryStr.append("	AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
				queryStr.append("	AND curr_cd = 'USD' \n");
				queryStr.append("	AND chg_cd IN ('OFT', 'GRI') \n");
				
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps = new LoggableStatement(con, queryStr.toString());
				} else {
					ps = con.prepareStatement(queryStr.toString());
				}
				
	            // 쿼리에 변수 세팅.
				ps.setString(i++, bkg_no);

				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
				rs = ps.executeQuery();
				
				if(rs.next()) {
					brog_calc_amt = rs.getDouble(1);
				}
				
				// brog_calc_amt가 '0'일 경우 Error Message 처리한다.
				if(!(brog_calc_amt != 0)) { // 부동소수점의 == 사용은 지양한다.
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00037").getUserMessage()); // 'BF' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
					// 2007.08.28 'BF' BL Menifested Rate Amount in Brokerage/FAC is '0' error! 때 저장하지 않는다.(주석처리)
					//createBRKGCommErrorMSG( con, brogMap );
					bkgMap.put("brogMap", brogMap);
					return bkgMap;
				}
				
				act_comm_amt = brog_calc_amt*(bkg_brog_rt/100);
				
			} else if("BS".equals(brog_div_cd)) {

				brog_chg_ctnt = "'" + brog_chg_ctnt.replaceAll(",", "','") + "'"; 
				
				queryStr.append("SELECT ROUND (NVL( SUM(CHG_AMT), 0), 2) brog_calc_amt \n");
				queryStr.append("  FROM bkg_chg_rt \n");
				queryStr.append(" WHERE bkg_no = ? \n");
				queryStr.append("	AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
				queryStr.append("	AND curr_cd = 'USD' \n");
				queryStr.append("	AND chg_cd IN ("+brog_chg_ctnt+") \n");
				
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps = new LoggableStatement(con, queryStr.toString());
				} else {
					ps = con.prepareStatement(queryStr.toString());
				}
				
	            // 쿼리에 변수 세팅.
				ps.setString(i++, bkg_no);

				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
				rs = ps.executeQuery();
				
				if(rs.next()) {
					brog_calc_amt = rs.getDouble(1);
				}
				
				// brog_calc_amt가 '0'일 경우 Error Message 처리한다.
				if(!(brog_calc_amt != 0)) { // 부동소수점의 == 사용은 지양한다.
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00036").getUserMessage()); // 'BS' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
					// 2007.08.28 'BS' BL Menifested Rate Amount in Brokerage/FAC is '0' error! 때 저장하지 않는다.(주석처리)
					//createBRKGCommErrorMSG( con, brogMap );
					bkgMap.put("brogMap", brogMap);
					return bkgMap;
				}
				
				act_comm_amt = brog_calc_amt * ( bkg_brog_rt / 100 );
				
			} else if("CA".equals(brog_div_cd)) {
				
				act_comm_amt = brog_box_qty * brog_box_rt;
				
			} else if("CS".equals(brog_div_cd)) {

				brog_teu_qty = 0; // 20자
				brog_feu_qty = 0; // 40자 이상
				
				/*
				 * CS인 이면서 contaner type/size가 Refer(R2, R4 등) 인 경우
				 * 1. reu rate가 존재하지 않을 경우 teu/feu 가 존재하면 해당 요율로 계산한다.
				 * 2. reu rate가 존재하고 teu rate, feu rate 가 존재하면 reu rate 요율로만 계산한다.
				 * 이때 teu/feu 의 물량을 0으로 처리해서 계산해도 0값이 나오도록 한다.
				 */

				if( brog_rf_rt != 0 ) { // reu rate가 존재할 경우

					queryStr.append("SELECT \n");
					queryStr.append("       NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', 0, QTY.OP_CNTR_QTY), 0)), 0) BROG_TEU_QTY, \n");
					queryStr.append("       NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', 0, DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', 0, QTY.OP_CNTR_QTY))), 0) BROG_FEU_QTY \n");
					queryStr.append("  FROM BKG_QUANTITY QTY\n");
					queryStr.append(" WHERE QTY.BKG_NO \n");
					queryStr.append("        IN \n");
					queryStr.append("         ( \n");
					queryStr.append("               SELECT \n");
					queryStr.append("                      DOC.BKG_NO \n");
					queryStr.append("                 FROM BKG_BL_DOC  DOC, \n");
					queryStr.append("                      BKG_BOOKING BKG, \n");
					queryStr.append("                      BKG_BOOKING BK2 \n");
					queryStr.append("                WHERE \n");
					queryStr.append("                    ( \n");
					queryStr.append("                      BKG.BKG_NO                  = DOC.BKG_NO \n");
					queryStr.append("                   OR \n");
					queryStr.append("                      BKG.BL_NO                   = DOC.MST_CVRD_BL_NO \n");
					queryStr.append("                    ) \n");
					queryStr.append("                  AND BK2.BKG_NO                  = DOC.BKG_NO \n");
					queryStr.append("                  AND BK2.BL_NO_TP              <>  '9' \n");
					queryStr.append("                  AND BK2.BKG_STS_CD            <>  'X' \n");
					queryStr.append("                  AND BKG.BKG_NO                  = ? \n");
					queryStr.append("         ) \n");
					queryStr.append("       AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");

					
					// Loggable Statement 사용에 의해 추가 
						ps = new LoggableStatement(con, queryStr.toString());
					
		            // 쿼리에 변수 세팅.
					ps.setString(i++, bkg_no);

					log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
					rs = ps.executeQuery();
					
					if(rs.next()) {
						brog_teu_qty = rs.getDouble(1);
						brog_feu_qty = rs.getDouble(2);
					}
					
				} else if (!(brog_calc_amt != 0) && (brog_teu_rt != 0 || brog_feu_rt != 0 ) ) { // 부동소수점의 == 사용은 지양한다.

					queryStr.append("SELECT \n");
					queryStr.append("       NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', QTY.OP_CNTR_QTY, 0)), 0) BROG_TEU_QTY, \n");
					queryStr.append("       NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', 0, QTY.OP_CNTR_QTY)), 0) BROG_FEU_QTY \n");
					queryStr.append("  FROM BKG_QUANTITY QTY\n");
					queryStr.append(" WHERE QTY.BKG_NO \n");
					queryStr.append("        IN \n");
					queryStr.append("         ( \n");
					queryStr.append("               SELECT \n");
					queryStr.append("                      DOC.BKG_NO \n");
					queryStr.append("                 FROM BKG_BL_DOC  DOC, \n");
					queryStr.append("                      BKG_BOOKING BKG, \n");
					queryStr.append("                      BKG_BOOKING BK2 \n");
					queryStr.append("                WHERE \n");
					queryStr.append("                    ( \n");
					queryStr.append("                      BKG.BKG_NO                  = DOC.BKG_NO \n");
					queryStr.append("                   OR \n");
					queryStr.append("                      BKG.BL_NO                   = DOC.MST_CVRD_BL_NO \n");
					queryStr.append("                    ) \n");
					queryStr.append("                  AND BK2.BKG_NO                  = DOC.BKG_NO \n");
					queryStr.append("                  AND BK2.BL_NO_TP              <>  '9' \n");
					queryStr.append("                  AND BK2.BKG_STS_CD            <>  'X' \n");
					queryStr.append("                  AND BKG.BKG_NO                  = ? \n");
					queryStr.append("         ) \n");
					queryStr.append("       AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");
					
					ps = new LoggableStatement(con, queryStr.toString());
					
		            // 쿼리에 변수 세팅.
					ps.setString(i++, bkg_no);

					log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
					rs = ps.executeQuery();
					
					if(rs.next()) {
						brog_teu_qty = rs.getDouble(1);
						brog_feu_qty = rs.getDouble(2);
					}
				}
 
				bkgMap.put("TEU", String.valueOf(brog_teu_qty));	// teu qty
				bkgMap.put("FEU", String.valueOf(brog_feu_qty));	// feu qty

				act_comm_amt = brog_box_rt*brog_box_qty + brog_teu_rt*brog_teu_qty + brog_feu_rt*brog_feu_qty + brog_rf_rt*brog_reu_qty;
			}

			// 계산된 값을 넣는다.
			brogMap.put("ACT_COMM_AMT", String.valueOf(roundValue(act_comm_amt, 2)));

			// Type/Size 계산 위해서 필요
			brogMap.put("BROG_DIV_CD_1", brog_div_cd_1);
			
			// Booking HashMap에 담는다.
			bkgMap.put("brogMap", brogMap);

		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}

		return bkgMap;
	}
	
	/**
	 * Brokerage Commission을 저장한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap Booking 정보를 담고 있는 HashMap
	 * @throws DAOException
	 */
	public HashMap createBRKGCommInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n createBRKGCommInfo 메소드 시작 ========================================\n");
		
		// Connection Interface   
		Connection con = null;
		// 조회를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		PreparedStatement ps02  = null;
		PreparedStatement ps03  = null;
		PreparedStatement ps04  = null;
		// INSERT를 수행하기 위한 SQL Statement
		PreparedStatement insertPs  = null;
		// ResultSet
		ResultSet rs = null;
		ResultSet rs02 = null;
		ResultSet rs03 = null;
		ResultSet rs04 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		String bkg_no = "";
		String bkg_pol_cd = "";
		String ar_ofc_cd = null;
		String ap_ofc_cd = null;
		String frt_fwrd_seq = "";
		String vndr_seq = "";
		String brog_bkg_rt = "";
		String brog_bx_rt = "";
		String brog_teu_rt = "";
		String brog_rf_rt = "";
		String brog_feu_rt = "";
		String brog_bx_qty = "";
		String brog_teu_qty = "";
		String brog_rf_qty = "";
		String brog_feu_qty = "";
		String act_comm_amt = "";
		String accl_flg = null;
		
		int iBrog_seq = 0;
		int iBrog_max_seq = 0;
		
		double dBrog_bkg_rt = 0;
		double dBrog_bx_rt = 0;
		double dBrog_teu_rt = 0;
		double dBrog_rf_rt = 0;
		double dBrog_feu_rt = 0;
		double dBrog_bx_qty = 0;
		double dBrog_teu_qty = 0;
		double dBrog_rf_qty = 0;
		double dBrog_feu_qty = 0;
		double dAct_pre_comm_amt = 0;
		double dAct_comm_amt = 0;
		double dAct_if_comm_amt = 0;
		
		int iFrt_fwrd_seq = 0;
		int iVndr_seq= 0;

		// S/A Date를 담고 있는 ArrayList
		ArrayList saDateList = null;
		// Brokerage 요율 정보를 담고 있는 ArrayList
		ArrayList brogRtList = null;
		
		// Brokerage Commission 정보를 담고 있는 HashMap
		HashMap brogMap = null;
		// Brokerage 요율 정보를 담고있는 HashMap
		HashMap brogRtMap = null; //반드시 존재한다.
		// Trunk 정보를 담고있는 HashMap
		HashMap trnkMap = null; //반드시 존재한다.

		StringBuffer queryStr = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();
		StringBuffer queryStr03 = new StringBuffer();
		StringBuffer queryStr04 = new StringBuffer();
		StringBuffer insertQuery = new StringBuffer();

		//입력
		insertQuery.append("INSERT INTO agt_brog_comm \n");
		insertQuery.append("            (bkg_no, brog_seq, comm_occr_info_cd, \n");
		insertQuery.append("             comm_stnd_cost_cd, comm_proc_sts_cd, comm_proc_rslt_rsn, \n");
		insertQuery.append("             comm_slan_cd, comm_rlane_cd, comm_vsl_cd, comm_skd_voy_no, \n");
		insertQuery.append("             comm_skd_dir_cd, comm_rev_dir_cd, brog_ref_no, cust_hus_bro_no, \n");
		insertQuery.append("             frt_fwrd_cnt_cd, frt_fwrd_seq, vndr_cnt_cd, vndr_seq, \n");
		insertQuery.append("             vsl_dep_dt, brog_div_cd, brog_bkg_rt, brog_chg_ctnt, brog_bx_rt, \n");
		insertQuery.append("             brog_teu_rt, brog_rf_rt, brog_feu_rt, bkg_bx_qty, bkg_teu_qty, \n");
		insertQuery.append("             bkg_rf_qty, bkg_feu_qty, brog_knd_cd, inter_mdal_flg, \n");
		insertQuery.append("             act_pre_comm_amt, act_comm_amt, act_if_comm_amt, cre_usr_id, \n");
		insertQuery.append("             cre_dt, ar_ofc_cd, ap_ofc_cd, \n");
		insertQuery.append("             agmt_cnt_cd, agmt_cust_seq, agmt_rt_seq, accl_flg,UPD_USR_ID,UPD_DT \n");
		insertQuery.append("            ) \n");
		insertQuery.append("     VALUES (?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, ?, \n");
		insertQuery.append("             TO_DATE (?, 'yyyyMMddHH24miss'), ?, ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, ?, ?, \n");
		insertQuery.append("             ?, ?, 'COMMISSION', \n");
		insertQuery.append("             SYSDATE, ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, 'COMMISSION',SYSDATE \n");
		insertQuery.append("            ) \n");


		queryStr04.append("	select max(BROG_SEQ)+1 new_ff_brog_seq 	\n");
		queryStr04.append("	From agt_brog_comm 						\n");
		queryStr04.append("	where bkg_no= ? 						\n");
		
		bkg_no = (String)bkgMap.get("BKG_NO");

		try {
			
			// Brokerage 요율 정보를 담고 있는 HashMap
			brogRtList = (ArrayList)bkgMap.get("brogRtList");
			// Brokerage Commission 정보를 담고 있는 HashMap
			brogMap = (HashMap)bkgMap.get("brogMap");
			// Brokerage 요율 정보를 담고있는 HashMap
			brogRtMap = (HashMap)brogRtList.get(0); //반드시 존재한다.
			// S/A Date를 담고 있는 ArrayList
			saDateList = (ArrayList)bkgMap.get("SADate");
			// Trunk 정보를 담고있는 HashMap
			trnkMap = (HashMap)saDateList.get(4); //반드시 존재한다.

			//iBrog_seq = Integer.parseInt((String)brogMap.get("BROG_SEQ"));
			
			// Connection을 얻어 온다.
			con = getConnection();
			
			
			
			
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps04 = new LoggableStatement(con, queryStr04.toString());
			} else {
				ps04 = con.prepareStatement(queryStr04.toString());
			}
			i = 1;
			ps04.setString(i++, bkg_no);

			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps04).getQueryString());
			rs04 = ps04.executeQuery();
			if(rs04.next()) {
				iBrog_max_seq = rs04.getInt(1);
			}			
			iBrog_seq = Integer.parseInt((String)brogMap.get("BROG_SEQ"));


			if(iBrog_seq < iBrog_max_seq){
				iBrog_seq = iBrog_max_seq ;
				brogMap.put("BROG_SEQ", String.valueOf(iBrog_seq));
				
			}

			
			
			bkg_pol_cd = checkNull((String)bkgMap.get("POL_CD"));
			frt_fwrd_seq = checkNull((String)bkgMap.get("FF_CUST_SEQ"));
			vndr_seq = checkNull((String)brogMap.get("VNDR_SEQ"));
			brog_bkg_rt = checkNull((String)brogRtMap.get("BKG_BROG_RT"));
			brog_bx_rt = checkNull((String)brogRtMap.get("BROG_BX_RT"));
			brog_teu_rt = checkNull((String)brogRtMap.get("BROG_TEU_RT"));
			brog_rf_rt = checkNull((String)brogRtMap.get("BROG_RF_RT"));
			brog_feu_rt = checkNull((String)brogRtMap.get("BROG_FEU_RT"));
			brog_bx_qty = checkNull((String)bkgMap.get("BOX"));
			brog_teu_qty = checkNull((String)bkgMap.get("TEU"));
			brog_rf_qty = checkNull((String)bkgMap.get("REU"));
			brog_feu_qty = checkNull((String)bkgMap.get("FEU"));
			act_comm_amt = checkNull((String)brogMap.get("ACT_COMM_AMT"));

			if(frt_fwrd_seq.length() > 0 && !"*".equals(frt_fwrd_seq)) {
				iFrt_fwrd_seq = Integer.parseInt(frt_fwrd_seq);
			}
			if(vndr_seq.length() > 0 && !"*".equals(vndr_seq)) {
				iVndr_seq = Integer.parseInt(vndr_seq);
			}
			
			if(brog_bkg_rt.length() > 0) {
				dBrog_bkg_rt = Double.parseDouble(brog_bkg_rt);
			}
			if(brog_bx_rt.length() > 0) {
				dBrog_bx_rt = Double.parseDouble(brog_bx_rt);
			}
			if(brog_teu_rt.length() > 0) {
				dBrog_teu_rt = Double.parseDouble(brog_teu_rt);
			}
			if(brog_rf_rt.length() > 0) {
				dBrog_rf_rt = Double.parseDouble(brog_rf_rt);
			}
			if(brog_feu_rt.length() > 0) {
				dBrog_feu_rt = Double.parseDouble(brog_feu_rt);
			}

			if(brog_bx_qty.length() > 0) {
				dBrog_bx_qty = Double.parseDouble(brog_bx_qty);
			}
			if(brog_teu_qty.length() > 0) {
				dBrog_teu_qty = Double.parseDouble(brog_teu_qty);
			}
			if(brog_rf_qty.length() > 0) {
				dBrog_rf_qty = Double.parseDouble(brog_rf_qty);
			}
			if(brog_feu_qty.length() > 0) {
				dBrog_feu_qty = Double.parseDouble(brog_feu_qty);
			}
			if(act_comm_amt.length() > 0) {
				dAct_comm_amt = Double.parseDouble(act_comm_amt);
			}

			// act_pre_comm_amt를 구한다. -------start-------
//			queryStr.append("SELECT ROUND (NVL (act_comm_amt, 0), 2) act_comm_amt \n");
//			queryStr.append("  FROM agt_brog_comm \n");
//			queryStr.append(" WHERE bkg_no = ?  \n");
//			queryStr.append("	AND brog_seq = (\n");
//			queryStr.append("			SELECT brog_seq FROM (\n");
//			queryStr.append("				SELECT brog_seq \n");
//			queryStr.append("				FROM agt_brog_comm \n");
//			queryStr.append("				WHERE bkg_no = ? \n");
//			queryStr.append("				  AND FRT_FWRD_CNT_CD||FRT_FWRD_SEQ = ?||to_number(?) \n");
//			queryStr.append("				  AND COMM_PROC_STS_CD = 'IF' \n");
//			queryStr.append("				ORDER BY BROG_SEQ DESC \n");
//			queryStr.append("			)\n");
//			queryStr.append("			WHERE ROWNUM = 1\n");
//			queryStr.append("		)\n");
			
			// act_pre_comm_amt 구하는 로직 아래 방식으로 변경 함.
			// 로직 상 현재 F/F 의 IF 금액 만이 act_pre_comm_amt 로 구해 진다. ( 과거 F/F 는 앞 단에서 상계 완료 한다. )
			// 2011.12.29 이윤정 [CHM-201114163] brokerage 시스템 로직 보완. 참고 CSR:CHM-201114871
			queryStr.append("SELECT nvl(SUM (ACT_IF_COMM_AMT),0) act_comm_amt		\n");
			queryStr.append("  FROM agt_brog_comm							\n");
			queryStr.append(" WHERE bkg_no = ?								\n");			

				 
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			i = 1;
//			ps.setString(i++, bkg_no);
////			ps.setInt(i++, iBrog_seq);
//			ps.setString(i++, bkg_no);
//			ps.setString(i++, (String)bkgMap.get("FF_CNT_CD"));
//			ps.setString(i++, (String)bkgMap.get("FF_CUST_SEQ"));
			ps.setString(i++, bkg_no);
			log.info("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dAct_pre_comm_amt = rs.getDouble(1);
			}			
			// act_pre_comm_amt를 구한다. -------end-------
			
			// Interface 할 Brokerage비
			dAct_if_comm_amt = dAct_comm_amt - dAct_pre_comm_amt;

			log.debug("\n\n dAct_pre_comm_amt ::"+dAct_pre_comm_amt);
			log.debug("\n\n dAct_if_comm_amt ::"+dAct_if_comm_amt);
			
			// dAct_if_comm_amt == 0이면 return한다.
			if(!(dAct_if_comm_amt != 0)) { // 부동소수점의 == 사용은 지양한다.
				brogMap.put("COMM_PROC_RSLT_RSN", "ACT_IF_COMM_AMT"); // act_if_comm_amt is 0
				bkgMap.put("brogMap", brogMap);
				return bkgMap;
			}			
			
			// Interface Commission을 Brokerage Map에 넣는다.
			brogMap.put("ACT_IF_COMM_AMT", String.valueOf(dAct_if_comm_amt));
			
			// accl_flg='Y'가 존재하면 무조건 accl_flg='Y'로 저장한다. -------start-------
			i = 1; //초기화
			
			queryStr02.append("SELECT accl_flg \n");
			queryStr02.append("  FROM agt_brog_comm \n");
			queryStr02.append(" WHERE bkg_no = ? \n");
			queryStr02.append("	and brog_seq = 1 \n");
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps02 = new LoggableStatement(con, queryStr02.toString());
			} else {
				ps02 = con.prepareStatement(queryStr02.toString());
			}

			ps02.setString(i++, bkg_no);
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
			rs02 = ps02.executeQuery();
			
			if(rs02.next()) {
				accl_flg = rs02.getString(1);
			}
			// accl_flg='Y'가 존재하면 무조건 accl_flg='Y'로 저장한다. -------end-------
			
			// ar_ofc_cd, ap_ofc_cd를 구한다. -------start-------
			i = 1; //초기화
			
			queryStr03.append("SELECT a.ar_ofc_cd, a.ap_ofc_cd \n");
			queryStr03.append("  FROM mdm_organization a, mdm_location b \n");
			queryStr03.append(" WHERE b.loc_cd = ?  \n"); //:bkg_pol
			queryStr03.append("	AND b.finc_ctrl_ofc_cd = a.ofc_cd \n");
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps03 = new LoggableStatement(con, queryStr03.toString());
			} else {
				ps03 = con.prepareStatement(queryStr03.toString());
			}

			ps03.setString(i++, bkg_pol_cd);
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps03).getQueryString());
			rs03 = ps03.executeQuery();
			
			if(rs03.next()) {
				ar_ofc_cd = rs03.getString(1);
				ap_ofc_cd = rs03.getString(2);
			}
			
			ap_ofc_cd = "NYCNA"; // 임의로 넣는다.
			// ar_ofc_cd, ap_ofc_cd를 구한다. -------end-------

			// Brokerage비 저장 -------start-------
			i = 1; //초기화

			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				insertPs = new LoggableStatement(con, insertQuery.toString());
			} else {
				insertPs = con.prepareStatement(insertQuery.toString());
			}

			//setting
			insertPs.setString(i++, bkg_no);								// bkg_no
			insertPs.setInt(i++, iBrog_seq);								// brog_seq
			insertPs.setString(i++, (String)bkgMap.get("POR_CD"));			// comm_occr_info_cd	-> Booking의 por_cd
			insertPs.setString(i++, "512641");								// comm_stnd_cost_cd
			insertPs.setString(i++, "CS");									// comm_proc_sts_cd
			insertPs.setString(i++, new ErrorHandler("AGT00069").getUserMessage()); // comm_proc_rslt_rsn
			insertPs.setString(i++, (String)trnkMap.get("SLAN_CD"));		// comm_slan_cd			-> Trunk의 slan_cd
			insertPs.setString(i++, (String)trnkMap.get("RLANE_CD"));		// comm_rlane_cd		-> Trunk의 rlane_cd ( Trunk의 slan_cd(3자리) + pol의 conti(1자리) + pod의 conti(1자리) ) 
			insertPs.setString(i++, (String)trnkMap.get("VSL_CD"));			// comm_vsl_cd			-> Trunk의 vsl_cd
			insertPs.setString(i++, (String)trnkMap.get("SKD_VOY_NO"));		// comm_skd_voy_no		-> Trunk의 skd_voy_no
			insertPs.setString(i++, (String)trnkMap.get("SKD_DIR_CD"));		// comm_skd_dir_cd		-> Trunk의 skd_dir_cd
			insertPs.setString(i++, (String)trnkMap.get("RLANE_DIR_CD"));	// comm_rev_dir_cd		-> Trunk의 rlane_dir_cd
			insertPs.setString(i++, (String)bkgMap.get("REFERENCE_NO"));	// brog_ref_no			-> Customer의 reference_no
			insertPs.setString(i++, "");									// cust_hus_bro_no
			insertPs.setString(i++, (String)bkgMap.get("FF_CNT_CD"));		// frt_fwrd_cnt_cd		-> Customer의 ff_cnt_cd
			insertPs.setInt(i++, iFrt_fwrd_seq);							// frt_fwrd_seq			-> Customer의 ff_cust_seq
			insertPs.setString(i++, (String)brogMap.get("VNDR_CNT_CD"));	// vndr_cnt_cd			-> Brokerage vndr_cnt_cd
			insertPs.setInt(i++, iVndr_seq);								// vndr_seq				-> Brokerage vndr_seq
			insertPs.setString(i++, (String)trnkMap.get("VPS_ETD_DT"));		// vsl_dep_dt			-> Trunk의 S/A Date
			insertPs.setString(i++, (String)brogRtMap.get("BROG_DIV_CD"));	// brog_div_cd			-> Brokerage 요율에서 조회한 brog_div_cd
			insertPs.setDouble(i++, dBrog_bkg_rt);							// brog_bkg_rt			-> Brokerage 요율에서 조회한 bkg_brog_rt
			insertPs.setString(i++, (String)brogRtMap.get("BROG_CHG_CTNT"));// brog_chg_ctnt		-> Brokerage 요율에서 조회한 brog_chg_ctnt
			insertPs.setDouble(i++, dBrog_bx_rt);							// brog_bx_rt			-> Brokerage 요율에서 조회한 brog_bx_rt
			insertPs.setDouble(i++, dBrog_teu_rt);							// brog_teu_rt			-> Brokerage 요율에서 조회한 brog_teu_rt
			insertPs.setDouble(i++, dBrog_rf_rt);							// brog_rf_rt			-> Brokerage 요율에서 조회한 brog_rf_rt
			insertPs.setDouble(i++, dBrog_feu_rt);							// brog_feu_rt			-> Brokerage 요율에서 조회한 brog_feu_rt
			insertPs.setDouble(i++, dBrog_bx_qty);							// brog_bx_qty			-> Booking QTY 조회한  box
			insertPs.setDouble(i++, dBrog_teu_qty);							// brog_teu_qty			-> Booking QTY 조회한  teu
			insertPs.setDouble(i++, dBrog_rf_qty);							// brog_rf_qty			-> Booking QTY 조회한  reu
			insertPs.setDouble(i++, dBrog_feu_qty);							// brog_feu_qty			-> Booking QTY 조회한  feu
			insertPs.setString(i++, (String)brogRtMap.get("BROG_KND_CD"));	// brog_knd_cd			-> Brokerage 요율에서 조회한 brog_knd_cd
			insertPs.setString(i++, "N");									// inter_mdal_flg
			insertPs.setDouble(i++, dAct_pre_comm_amt);						// act_pre_comm_amt		-> 전 Brokerage비
			insertPs.setDouble(i++, dAct_comm_amt);							// act_comm_amt			-> Brokerage비 계산 값 act_comm_amt
			insertPs.setDouble(i++, dAct_if_comm_amt);						// act_if_comm_amt		-> act_comm_amt - act_pre_comm_amt
			insertPs.setString(i++, ar_ofc_cd);								// ar_ofc_cd			-> Booking의 ar_ofc_cd
			insertPs.setString(i++, ap_ofc_cd);								// ap_ofc_cd			-> Booking의 ap_ofc_cd
			insertPs.setString(i++, (String)brogRtMap.get("BROG_CNT_CD"));	// agmt_cnt_cd			-> Brokerage 요율에서 조회한 brog_cnt_cd
			insertPs.setString(i++, (String)brogRtMap.get("BROG_CUST_SEQ"));// agmt_cust_seq		-> Brokerage 요율에서 조회한 brog_cust_seq
			insertPs.setInt(i++, Integer.parseInt((String)brogRtMap.get("BROG_RT_SEQ")));	// agmt_rt_seq			-> Brokerage 요율에서 조회한 brog_rt_seq
			insertPs.setString(i++, accl_flg);								// accl_flg				-> accl_flg
            log.debug("\n SQL :::::::::\n" + ((LoggableStatement)insertPs).getQueryString());

			log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs).getQueryString());
			insertPs.executeUpdate();
			// Brokerage비 저장 -------end-------

		}
		catch (SQLException se)
		{
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (DAOException de)
		{
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,de);
			throw de;
		}
		catch (Exception e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw new DAOException(e.getMessage());
		}
		finally
		{
			closeResultSet(rs);
			closeResultSet(rs02);
			closeResultSet(rs03);
			closeResultSet(rs04);
			closeStatement(insertPs);
			closeStatement(ps);
			closeStatement(ps02);
			closeStatement(ps03);
			closeStatement(ps04);
			closeConnection(con);
		}
		
		return bkgMap;
	}


	/**
	 * Brokerage Commission Detail을 저장한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @throws DAOException
	 */
	public HashMap createBRKGTPSZCommInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n createBRKGTPSZCommInfo 메소드 시작 ========================================\n");
		
		// Connection Interface   
		Connection con = null;
		// INSERT를 수행하기 위한 SQL Statement
		PreparedStatement insertPs  = null;
		PreparedStatement insertPs02  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// Brokerage 요율 정보를 담고 있는 ArrayList
		ArrayList brogRtList = null;
		// Brokerage 정보를 담고있는 HashMap
		HashMap brogMap = null;
		// Brokerage 요율 정보를 담고있는 HashMap
		HashMap brogRtMap = null;

		String brog_div_cd = "";
		String brog_div_cd_1 = ""; // brog_div_cd의 첫번째 자리값
		String brog_chg_ctnt = "";
		String cancelYn = "N"; // IF 되고 Cancel된 Booking 여부 ('Y' = IF 되고 Cancel된 Booking)
		int iCount = 0; // Insert 된 Row 수
		
		StringBuffer insertQuery = new StringBuffer();
		StringBuffer insertQuery02 = new StringBuffer();

		String bkg_no       = checkNull((String)bkgMap.get("BKG_NO"));

		try {
			
			// Brokerage Commission 정보를 담고 있는 HashMap
			brogMap = (HashMap)bkgMap.get("brogMap");

			// Cancel 여부를 가지고 온다.
			cancelYn = checkNull((String)brogMap.get("CANCEL_YN"));
			
			if(!"Y".equals(cancelYn)) { // Cancel 된 Booking이 아닌 경우
				// Brokerage 요율 정보를 담고 있는 ArrayList
				brogRtList = (ArrayList)bkgMap.get("brogRtList");
				// Brokerage 요율 정보를 담고있는 HashMap
				brogRtMap = (HashMap)brogRtList.get(0); //반드시 존재한다.
				
				brog_div_cd = checkNull((String)brogRtMap.get("BROG_DIV_CD"));
				brog_chg_ctnt = checkNull((String)brogRtMap.get("BROG_CHG_CTNT"));	// brog_chg_ctnt
			}

			brog_div_cd_1 = checkNull((String)brogMap.get("BROG_DIV_CD_1"));

			con = getConnection();

			if("B".equals(brog_div_cd_1)) { // BL인 경우 
			
				//입력
				insertQuery.append("    INSERT \n");
				insertQuery.append("      INTO AGT_BROG_COMM_DTL \n");
				insertQuery.append("         ( \n");
				insertQuery.append("           BKG_NO, \n");
				insertQuery.append("           BROG_SEQ, \n");
				insertQuery.append("           CNTR_TPSZ_CD, \n");
				insertQuery.append("           BKG_VOL_QTY, \n");
				insertQuery.append("           LOCL_CURR_CD, \n");
				insertQuery.append("           ACT_USD_COMM_AMT, \n");
				insertQuery.append("           UPD_USR_ID, \n");
				insertQuery.append("           UPD_DT, \n");
				insertQuery.append("           CRE_USR_ID, \n");
				insertQuery.append("           CRE_DT \n");
				insertQuery.append("         ) \n");
				insertQuery.append("    SELECT \n");
				insertQuery.append("           INS.BKG_NO                                           AS BKG_NO, \n");
				insertQuery.append("           INS.BROG_SEQ                                         AS BROG_SEQ, \n");
				insertQuery.append("           INS.CNTR_TPSZ_CD                                     AS CNTR_TPSZ_CD, \n");
				insertQuery.append("           INS.BKG_VOL_QTY                                      AS BKG_VOL_QTY, \n");
				insertQuery.append("           'USD'                                                AS LOCL_CURR_CD, \n");
				insertQuery.append("      CASE \n");
				insertQuery.append("      WHEN INS.MNUM = INS.RNUM \n");
				insertQuery.append("      THEN  \n");
				insertQuery.append("           ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2) \n");
				insertQuery.append("         + \n");
				insertQuery.append("         ( \n");
				insertQuery.append("           INS.ACT_IF_COMM_AMT \n");
				insertQuery.append("         - SUM (ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2)) \n");
				insertQuery.append("           OVER (ORDER BY INS.CNTR_TPSZ_CD) \n");
				insertQuery.append("         ) \n");
				insertQuery.append("      ELSE \n");
				insertQuery.append("           ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2) \n");
				insertQuery.append("       END                                                      AS ACT_USD_COMM_AMT, \n");
				insertQuery.append("           'BROKERAGE System'                                   AS UPD_USR_ID, \n");
				insertQuery.append("           SYSDATE                                              AS UPD_DT, \n");
				insertQuery.append("           'BROKERAGE System'                                   AS CRE_USR_ID, \n");
				insertQuery.append("           SYSDATE                                              AS CRE_DT \n");
				insertQuery.append("      FROM \n");
				insertQuery.append("         ( \n");
				insertQuery.append("               SELECT \n");
				insertQuery.append("                      ROWNUM                                    AS RNUM, \n");
				insertQuery.append("                    ( \n");
				insertQuery.append("                          SELECT \n");
				insertQuery.append("                                 COUNT (1) \n");
				insertQuery.append("                            FROM AGT_BKG_REV_DTL RE2 \n");
				insertQuery.append("                           WHERE RE2.BKG_NO = REV.BKG_NO \n");
				insertQuery.append("                    )                                           AS MNUM, \n");
				insertQuery.append("                      REV.BKG_NO                                AS BKG_NO, \n");
				insertQuery.append("                      QTY.BROG_SEQ                              AS BROG_SEQ, \n");
				insertQuery.append("                      QTY.ACT_IF_COMM_AMT                       AS ACT_IF_COMM_AMT, \n");
				insertQuery.append("                      REV.CNTR_TPSZ_CD                          AS CNTR_TPSZ_CD, \n");
				insertQuery.append("                      REV.BKG_VOL_QTY                           AS BKG_VOL_QTY, \n");
				insertQuery.append("                 CASE \n");
				insertQuery.append("                 WHEN QTY.TOT_QTY = 0 \n");
				insertQuery.append("                   OR QTY.TOT_QTY IS NULL \n");
				insertQuery.append("                 THEN 0 \n");
				insertQuery.append("                 ELSE \n");
				insertQuery.append("                      CASE \n");
				insertQuery.append("                      WHEN SUBSTR (REV.CNTR_TPSZ_CD, 2, 1) = '2' \n"); // 오타수정 2011.07.21 REV.BKG_VOL_QTY-->REV.CNTR_TPSZ_CD 
				insertQuery.append("                      THEN REV.BKG_VOL_QTY \n");
				insertQuery.append("                      ELSE REV.BKG_VOL_QTY * 2 \n");
				insertQuery.append("                       END / QTY.TOT_QTY \n");
				insertQuery.append("                  END                                           AS OFT_RATIO \n");
				insertQuery.append("                 FROM AGT_BKG_REV_DTL REV, \n");
				insertQuery.append("                    ( \n");
				insertQuery.append("                          SELECT \n");
				insertQuery.append("                                 MAX (REV.BKG_NO)               AS BKG_NO, \n");
				insertQuery.append("                                 MAX (AMT.BROG_SEQ)             AS BROG_SEQ, \n");
				insertQuery.append("                                 MAX (AMT.ACT_IF_COMM_AMT)      AS ACT_IF_COMM_AMT, \n");
				insertQuery.append("                                 SUM \n");
				insertQuery.append("                               ( \n");
				insertQuery.append("                             CASE \n");
				insertQuery.append("                             WHEN SUBSTR (REV.CNTR_TPSZ_CD, 2, 1) = '2' \n");// 오타수정 2011.07.21 REV.BKG_VOL_QTY-->REV.CNTR_TPSZ_CD
				insertQuery.append("                             THEN REV.BKG_VOL_QTY \n");
				insertQuery.append("                             ELSE REV.BKG_VOL_QTY * 2 \n");
				insertQuery.append("                              END \n");
				insertQuery.append("                                )                               AS TOT_QTY \n");
				insertQuery.append("                             FROM AGT_BKG_REV_DTL REV, \n");
				insertQuery.append("                                ( \n");
				insertQuery.append("                                      SELECT \n");
				insertQuery.append("                                             BRO.BKG_NO, \n");
				insertQuery.append("                                             BRO.BROG_SEQ, \n");
				insertQuery.append("                                             BRO.ACT_IF_COMM_AMT \n");
				insertQuery.append("                                        FROM AGT_BROG_COMM BRO \n");
				insertQuery.append("                                       WHERE BRO.BKG_NO    = ? \n");
				insertQuery.append("                                         AND BRO.BROG_SEQ  = ? \n");
				insertQuery.append("                                ) AMT \n");
				insertQuery.append("                            WHERE REV.BKG_NO = AMT.BKG_NO \n");
				insertQuery.append("                    ) QTY \n");
				insertQuery.append("                WHERE REV.BKG_NO = QTY.BKG_NO \n");
				insertQuery.append("         ) INS \n");


				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs = new LoggableStatement(con, insertQuery.toString());
				} else {
					insertPs = con.prepareStatement(insertQuery.toString());
				}
	
				//setting
				insertPs.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs.setInt(i++, Integer.parseInt((String)brogMap.get("BROG_SEQ")));

				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs).getQueryString());
				iCount = insertPs.executeUpdate();
				
				// 입력된 데이타가 한 건도 없을 경우 Error 처리한다.
				if(iCount == 0) {
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00050").getUserMessage()); // Brokerage Type Size Distribution from B/L Commission Error!
					createBRKGCommErrorMSG( con, brogMap );
					bkgMap.put("brogMap", brogMap);
					return bkgMap;
				}
				
			} else { // Container인 경우
				
				//입력
				insertQuery.append("    INSERT \n");
				insertQuery.append("      INTO AGT_BROG_COMM_DTL \n");
				insertQuery.append("         ( \n");
				insertQuery.append("           BKG_NO, \n");
				insertQuery.append("           BROG_SEQ, \n");
				insertQuery.append("           CNTR_TPSZ_CD, \n");
				insertQuery.append("           BKG_VOL_QTY, \n");
				insertQuery.append("           LOCL_CURR_CD, \n");
				insertQuery.append("           ACT_USD_COMM_AMT, \n");
				insertQuery.append("           UPD_USR_ID, \n");
				insertQuery.append("           UPD_DT, \n");
				insertQuery.append("           CRE_USR_ID, \n");
				insertQuery.append("           CRE_DT \n");
				insertQuery.append("         ) \n");
				insertQuery.append("    SELECT \n");
				insertQuery.append("           INS.BKG_NO                                           AS BKG_NO, \n");
				insertQuery.append("           INS.BROG_SEQ                                         AS BROG_SEQ, \n");
				insertQuery.append("           INS.CNTR_TPSZ_CD                                     AS CNTR_TPSZ_CD, \n");
				insertQuery.append("           INS.BKG_VOL_QTY                                      AS BKG_VOL_QTY, \n");
				insertQuery.append("           'USD'                                                AS LOCL_CURR_CD, \n");
				insertQuery.append("      CASE \n");
				insertQuery.append("      WHEN INS.MNUM = INS.RNUM \n");
				insertQuery.append("      THEN \n");
				insertQuery.append("           ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2) \n");
				insertQuery.append("         + \n");
				insertQuery.append("         ( \n");
				insertQuery.append("           INS.ACT_IF_COMM_AMT \n");
				insertQuery.append("         - SUM (ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2)) \n");
				insertQuery.append("           OVER (ORDER BY INS.CNTR_TPSZ_CD) \n");
				insertQuery.append("         ) \n");
				insertQuery.append("      ELSE \n");
				insertQuery.append("           ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2) \n");
				insertQuery.append("       END                                                      AS ACT_USD_COMM_AMT, \n");
				insertQuery.append("           'BROKERAGE System'                                   AS UPD_USR_ID, \n");
				insertQuery.append("           SYSDATE                                              AS UPD_DT, \n");
				insertQuery.append("           'BROKERAGE System'                                   AS CRE_USR_ID, \n");
				insertQuery.append("           SYSDATE                                              AS CRE_DT \n");
				insertQuery.append("      FROM \n");
				insertQuery.append("         ( \n");
				insertQuery.append("               SELECT \n");
				insertQuery.append("                      ROWNUM                                    AS RNUM, \n");
				insertQuery.append("                    ( \n");
				insertQuery.append("                          SELECT \n");
				insertQuery.append("                                 COUNT (1) \n");
				insertQuery.append("                            FROM AGT_BKG_REV_DTL RE2 \n");
				insertQuery.append("                           WHERE RE2.BKG_NO = REV.BKG_NO \n");
				insertQuery.append("                    )                                           AS MNUM, \n");
				insertQuery.append("                      REV.BKG_NO                                AS BKG_NO, \n");
				insertQuery.append("                      QTY.BROG_SEQ                              AS BROG_SEQ, \n");
				insertQuery.append("                      QTY.ACT_IF_COMM_AMT                       AS ACT_IF_COMM_AMT, \n");
				insertQuery.append("                      REV.CNTR_TPSZ_CD                          AS CNTR_TPSZ_CD, \n");
				insertQuery.append("                      REV.BKG_VOL_QTY                           AS BKG_VOL_QTY, \n");

				insertQuery.append("                 CASE \n");
				insertQuery.append("                 WHEN QTY.TOT_QTY = 0 \n");
				insertQuery.append("                   OR QTY.TOT_QTY IS NULL \n");
				insertQuery.append("                 THEN 0 \n");
				insertQuery.append("                 ELSE \n");
				insertQuery.append("                      CASE \n");
				insertQuery.append("                      WHEN SUBSTR (REV.CNTR_TPSZ_CD, 2, 1) = '2' \n");
				insertQuery.append("                      THEN REV.BKG_VOL_QTY \n");
				insertQuery.append("                      ELSE REV.BKG_VOL_QTY * 2 \n");
				insertQuery.append("                       END / QTY.TOT_QTY \n");
				insertQuery.append("                  END                                           AS OFT_RATIO \n");

//				insertQuery.append("                      RATIO_TO_REPORT (REV.BKG_OFT_REV) \n");
//				insertQuery.append("                      OVER (PARTITION BY REV.BKG_NO)            AS OFT_RATIO \n");
				insertQuery.append("                 FROM AGT_BKG_REV_DTL REV, \n");
//				insertQuery.append("                    ( \n");
//				insertQuery.append("                          SELECT \n");
//				insertQuery.append("                                 BRO.BKG_NO, \n");
//				insertQuery.append("                                 BRO.BROG_SEQ, \n");
//				insertQuery.append("                                 BRO.ACT_IF_COMM_AMT \n");
//				insertQuery.append("                            FROM AGT_BROG_COMM BRO \n");
//				insertQuery.append("                           WHERE BRO.BKG_NO    = ? \n");
//				insertQuery.append("                             AND BRO.BROG_SEQ  = ? \n");
//				insertQuery.append("                    ) AMT \n");
				insertQuery.append("                    ( \n");
				insertQuery.append("                          SELECT \n");
				insertQuery.append("                                 MAX (REV.BKG_NO)               AS BKG_NO, \n");
				insertQuery.append("                                 MAX (AMT.BROG_SEQ)             AS BROG_SEQ, \n");
				insertQuery.append("                                 MAX (AMT.ACT_IF_COMM_AMT)      AS ACT_IF_COMM_AMT, \n");
				insertQuery.append("                                 SUM \n");
				insertQuery.append("                               ( \n");
				insertQuery.append("                             CASE \n");
				insertQuery.append("                             WHEN SUBSTR (REV.CNTR_TPSZ_CD, 2, 1) = '2' \n");
				insertQuery.append("                             THEN REV.BKG_VOL_QTY \n");
				insertQuery.append("                             ELSE REV.BKG_VOL_QTY * 2 \n");
				insertQuery.append("                              END \n");
				insertQuery.append("                                )                               AS TOT_QTY \n");
				insertQuery.append("                             FROM AGT_BKG_REV_DTL REV, \n");
				insertQuery.append("                                ( \n");
				insertQuery.append("                                      SELECT \n");
				insertQuery.append("                                             BRO.BKG_NO, \n");
				insertQuery.append("                                             BRO.BROG_SEQ, \n");
				insertQuery.append("                                             BRO.ACT_IF_COMM_AMT \n");
				insertQuery.append("                                        FROM AGT_BROG_COMM BRO \n");
				insertQuery.append("                                       WHERE BRO.BKG_NO    = ? \n");
				insertQuery.append("                                         AND BRO.BROG_SEQ  = ? \n");
				insertQuery.append("                                ) AMT \n");
				insertQuery.append("                            WHERE REV.BKG_NO = AMT.BKG_NO \n");
				insertQuery.append("                    ) QTY \n");
				insertQuery.append("                WHERE REV.BKG_NO = QTY.BKG_NO \n");
				insertQuery.append("         ) INS \n");
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs = new LoggableStatement(con, insertQuery.toString());
				} else {
					insertPs = con.prepareStatement(insertQuery.toString());
				}
	
				//setting
				insertPs.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs.setInt(i++, Integer.parseInt((String)brogMap.get("BROG_SEQ")));
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs).getQueryString());
				iCount = insertPs.executeUpdate();
				
				// 입력된 데이타가 한 건도 없을 경우 Error 처리한다.
				if(iCount == 0) {
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00051").getUserMessage()); // Brokerage Type Size Distribution from Container Commission Error!
					createBRKGCommErrorMSG( con, brogMap );
					bkgMap.put("brogMap", brogMap);
					return bkgMap;
				}
			}

			i = 1; // 초기화한다.
			
			// CHG DTL에 데이타 등록한다. -------start------- 
			if("BA".equals(brog_div_cd)) {
				
				// 입력
				insertQuery02.append("INSERT INTO agt_brog_chg_dtl \n");
				insertQuery02.append("            (bkg_no, brog_seq, chg_cd, bkg_chg_amt, UPD_USR_ID, UPD_DT,cre_usr_id, \n");
				insertQuery02.append("             cre_dt) \n");
				insertQuery02.append("   SELECT   ?, ?, chg_cd, SUM (CHG_AMT), \n");
				insertQuery02.append("            'Brokerage System', SYSDATE,'Brokerage System', SYSDATE \n");
				insertQuery02.append("       FROM bkg_chg_rt \n");
				insertQuery02.append("      WHERE bkg_no = ? \n");
				insertQuery02.append("        AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
				insertQuery02.append("        AND curr_cd = 'USD' \n");
				insertQuery02.append("   GROUP BY chg_cd \n");
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs02 = new LoggableStatement(con, insertQuery02.toString());
				} else {
					insertPs02 = con.prepareStatement(insertQuery02.toString());
				}
	
				//setting
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setInt(i++, Integer.parseInt((String)brogMap.get("BROG_SEQ")));
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs02).getQueryString());
				insertPs02.executeUpdate();

			} else if("BF".equals(brog_div_cd)) {
				
				// 입력
				insertQuery02.append("INSERT INTO agt_brog_chg_dtl \n");
				insertQuery02.append("            (bkg_no, brog_seq, chg_cd, bkg_chg_amt, UPD_USR_ID, UPD_DT, cre_usr_id, \n");
				insertQuery02.append("             cre_dt) \n");
				insertQuery02.append("   SELECT   ?, ?, chg_cd, SUM (CHG_AMT), \n");
				insertQuery02.append("            'Brokerage System', SYSDATE, 'Brokerage System', SYSDATE \n");
				insertQuery02.append("       FROM bkg_chg_rt \n");
				insertQuery02.append("      WHERE bkg_no = ? \n");
				insertQuery02.append("        AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
				insertQuery02.append("        AND curr_cd = 'USD' \n");
				insertQuery02.append("        AND chg_cd IN ('OFT', 'GRI') \n");
				insertQuery02.append("   GROUP BY chg_cd \n");
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs02 = new LoggableStatement(con, insertQuery02.toString());
				} else {
					insertPs02 = con.prepareStatement(insertQuery02.toString());
				}
	
				//setting
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setInt(i++, Integer.parseInt((String)brogMap.get("BROG_SEQ")));
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs02).getQueryString());
				insertPs02.executeUpdate();

			} else if("BS".equals(brog_div_cd)) {
				
				brog_chg_ctnt = "'" + brog_chg_ctnt.replaceAll(",", "','") + "'"; 
				
				// 입력
				insertQuery02.append("INSERT INTO agt_brog_chg_dtl \n");
				insertQuery02.append("            (bkg_no, brog_seq, chg_cd, bkg_chg_amt,UPD_USR_ID, UPD_DT, cre_usr_id, \n");
				insertQuery02.append("             cre_dt) \n");
				insertQuery02.append("   SELECT   ?, ?, chg_cd, SUM (CHG_AMT), \n");
				insertQuery02.append("            'Brokerage System', SYSDATE, 'Brokerage System', SYSDATE \n");
				insertQuery02.append("       FROM bkg_chg_rt \n");
				insertQuery02.append("      WHERE bkg_no = ? \n");
				insertQuery02.append("        AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
				insertQuery02.append("        AND curr_cd = 'USD' \n");
				insertQuery02.append("        AND chg_cd IN ("+brog_chg_ctnt+") \n");
				insertQuery02.append("   GROUP BY chg_cd \n");
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs02 = new LoggableStatement(con, insertQuery02.toString());
				} else {
					insertPs02 = con.prepareStatement(insertQuery02.toString());
				}
	
				//setting
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setInt(i++, Integer.parseInt((String)brogMap.get("BROG_SEQ")));
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs02).getQueryString());
				insertPs02.executeUpdate();
			} 
			// CHG DTL에 데이타 등록한다. -------end-------
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(insertPs);
			closeStatement(insertPs02);
			closeConnection(con);
		}
		
		return bkgMap;
	}
	


	/**
	 * 상계용 Brokerage Commission Detail을 저장한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @throws DAOException
	 */
	public HashMap createBRKGTPSZCommInfoFFCode(HashMap bkgMap) throws DAOException {

		log.debug("\n\n createBRKGTPSZCommInfoFFCode 메소드 시작 ========================================\n");
		
		// Connection Interface   
		Connection con = null;
		// INSERT를 수행하기 위한 SQL Statement
		PreparedStatement insertPs  = null;
		PreparedStatement insertPs02  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// Brokerage 요율 정보를 담고 있는 ArrayList
		ArrayList brogRtList = null;
		// Brokerage 정보를 담고있는 HashMap
		HashMap brogMap = null;
		// Brokerage 요율 정보를 담고있는 HashMap
		HashMap brogRtMap = null;

		String brog_div_cd = "";
		String brog_div_cd_1 = ""; // brog_div_cd의 첫번째 자리값
		String brog_chg_ctnt = "";
		String cancelYn = "N"; // IF 되고 Cancel된 Booking 여부 ('Y' = IF 되고 Cancel된 Booking)
		int iCount = 0; // Insert 된 Row 수
		
		StringBuffer insertQuery = new StringBuffer();
		StringBuffer insertQuery02 = new StringBuffer();

		String bkg_no       = checkNull((String)bkgMap.get("BKG_NO"));

		try {
			log.debug(" createBRKGTPSZCommInfoFFCode 1 메소드 시작 ========================================\n");
	
			// Brokerage Commission 정보를 담고 있는 HashMap
			brogMap = (HashMap)bkgMap.get("brogMap");

			// Cancel 여부를 가지고 온다.
			cancelYn = checkNull((String)brogMap.get("CANCEL_YN"));
			
			if(!"Y".equals(cancelYn)) { // Cancel 된 Booking이 아닌 경우
				// Brokerage 요율 정보를 담고 있는 ArrayList
				brogRtList = (ArrayList)bkgMap.get("brogRtList");
				// Brokerage 요율 정보를 담고있는 HashMap
				brogRtMap = (HashMap)brogRtList.get(0); //반드시 존재한다.
				
				brog_div_cd = checkNull((String)brogRtMap.get("BROG_DIV_CD"));
				brog_chg_ctnt = checkNull((String)brogRtMap.get("BROG_CHG_CTNT"));	// brog_chg_ctnt
			}
			log.debug(" createBRKGTPSZCommInfoFFCode 2 메소드 시작 ========================================\n");

			brog_div_cd_1 = checkNull((String)brogMap.get("BROG_DIV_CD_1"));

			con = getConnection();

			if("B".equals(brog_div_cd_1)) { // BL인 경우 
				log.debug(" createBRKGTPSZCommInfoFFCode 3 메소드 시작 ========================================\n");
			
				//입력
				insertQuery.append("    INSERT \n");
				insertQuery.append("      INTO AGT_BROG_COMM_DTL \n");
				insertQuery.append("         ( \n");
				insertQuery.append("           BKG_NO, \n");
				insertQuery.append("           BROG_SEQ, \n");
				insertQuery.append("           CNTR_TPSZ_CD, \n");
				insertQuery.append("           BKG_VOL_QTY, \n");
				insertQuery.append("           LOCL_CURR_CD, \n");
				insertQuery.append("           ACT_USD_COMM_AMT, \n");
				insertQuery.append("           UPD_USR_ID, \n");
				insertQuery.append("           UPD_DT, \n");
				insertQuery.append("           CRE_USR_ID, \n");
				insertQuery.append("           CRE_DT \n");
				insertQuery.append("         ) \n");
				insertQuery.append("    SELECT \n");
				insertQuery.append("           INS.BKG_NO                                           AS BKG_NO, \n");
				insertQuery.append("           INS.BROG_SEQ                                         AS BROG_SEQ, \n");
				insertQuery.append("           INS.CNTR_TPSZ_CD                                     AS CNTR_TPSZ_CD, \n");
				insertQuery.append("           INS.BKG_VOL_QTY                                      AS BKG_VOL_QTY, \n");
				insertQuery.append("           'USD'                                                AS LOCL_CURR_CD, \n");
				insertQuery.append("      CASE \n");
				insertQuery.append("      WHEN INS.MNUM = INS.RNUM \n");
				insertQuery.append("      THEN  \n");
				insertQuery.append("           ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2) \n");
				insertQuery.append("         + \n");
				insertQuery.append("         ( \n");
				insertQuery.append("           INS.ACT_IF_COMM_AMT \n");
				insertQuery.append("         - SUM (ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2)) \n");
				insertQuery.append("           OVER (ORDER BY INS.CNTR_TPSZ_CD) \n");
				insertQuery.append("         ) \n");
				insertQuery.append("      ELSE \n");
				insertQuery.append("           ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2) \n");
				insertQuery.append("       END                                                      AS ACT_USD_COMM_AMT, \n");
				insertQuery.append("           'BROKERAGE System'                                   AS UPD_USR_ID, \n");
				insertQuery.append("           SYSDATE                                              AS UPD_DT, \n");
				insertQuery.append("           'BROKERAGE System'                                   AS CRE_USR_ID, \n");
				insertQuery.append("           SYSDATE                                              AS CRE_DT \n");
				insertQuery.append("      FROM \n");
				insertQuery.append("         ( \n");
				insertQuery.append("               SELECT \n");
				insertQuery.append("                      ROWNUM                                    AS RNUM, \n");
				insertQuery.append("                    ( \n");
				insertQuery.append("                          SELECT \n");
				insertQuery.append("                                 COUNT (1) \n");
				insertQuery.append("                            FROM AGT_BKG_REV_DTL RE2 \n");
				insertQuery.append("                           WHERE RE2.BKG_NO = REV.BKG_NO \n");
				insertQuery.append("                    )                                           AS MNUM, \n");
				insertQuery.append("                      REV.BKG_NO                                AS BKG_NO, \n");
				insertQuery.append("                      QTY.BROG_SEQ                              AS BROG_SEQ, \n");
				insertQuery.append("                      QTY.ACT_IF_COMM_AMT                       AS ACT_IF_COMM_AMT, \n");
				insertQuery.append("                      REV.CNTR_TPSZ_CD                          AS CNTR_TPSZ_CD, \n");
				insertQuery.append("                      REV.BKG_VOL_QTY                           AS BKG_VOL_QTY, \n");
				insertQuery.append("                 CASE \n");
				insertQuery.append("                 WHEN QTY.TOT_QTY = 0 \n");
				insertQuery.append("                   OR QTY.TOT_QTY IS NULL \n");
				insertQuery.append("                 THEN 0 \n");
				insertQuery.append("                 ELSE \n");
				insertQuery.append("                      CASE \n");
				insertQuery.append("                      WHEN SUBSTR (REV.CNTR_TPSZ_CD, 2, 1) = '2' \n"); // 오타수정 2011.07.21 REV.BKG_VOL_QTY-->REV.CNTR_TPSZ_CD 
				insertQuery.append("                      THEN REV.BKG_VOL_QTY \n");
				insertQuery.append("                      ELSE REV.BKG_VOL_QTY * 2 \n");
				insertQuery.append("                       END / QTY.TOT_QTY \n");
				insertQuery.append("                  END                                           AS OFT_RATIO \n");
				insertQuery.append("                 FROM AGT_BKG_REV_DTL REV, \n");
				insertQuery.append("                    ( \n");
				insertQuery.append("                          SELECT \n");
				insertQuery.append("                                 MAX (REV.BKG_NO)               AS BKG_NO, \n");
				insertQuery.append("                                 MAX (AMT.BROG_SEQ)             AS BROG_SEQ, \n");
				insertQuery.append("                                 MAX (AMT.ACT_IF_COMM_AMT)      AS ACT_IF_COMM_AMT, \n");
				insertQuery.append("                                 SUM \n");
				insertQuery.append("                               ( \n");
				insertQuery.append("                             CASE \n");
				insertQuery.append("                             WHEN SUBSTR (REV.CNTR_TPSZ_CD, 2, 1) = '2' \n");// 오타수정 2011.07.21 REV.BKG_VOL_QTY-->REV.CNTR_TPSZ_CD
				insertQuery.append("                             THEN REV.BKG_VOL_QTY \n");
				insertQuery.append("                             ELSE REV.BKG_VOL_QTY * 2 \n");
				insertQuery.append("                              END \n");
				insertQuery.append("                                )                               AS TOT_QTY \n");
				insertQuery.append("                             FROM AGT_BKG_REV_DTL REV, \n");
				insertQuery.append("                                ( \n");
				insertQuery.append("                                      SELECT \n");
				insertQuery.append("                                             BRO.BKG_NO, \n");
				insertQuery.append("                                             BRO.BROG_SEQ, \n");
				insertQuery.append("                                             BRO.ACT_IF_COMM_AMT \n");
				insertQuery.append("                                        FROM AGT_BROG_COMM BRO \n");
				insertQuery.append("                                       WHERE BRO.BKG_NO    = ? \n");
				insertQuery.append("                                         AND BRO.BROG_SEQ  = ? \n");
				insertQuery.append("                                ) AMT \n");
				insertQuery.append("                            WHERE REV.BKG_NO = AMT.BKG_NO \n");
				insertQuery.append("                    ) QTY \n");
				insertQuery.append("                WHERE REV.BKG_NO = QTY.BKG_NO \n");
				insertQuery.append("         ) INS \n");


				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs = new LoggableStatement(con, insertQuery.toString());
				} else {
					insertPs = con.prepareStatement(insertQuery.toString());
				}
	
				//setting
				insertPs.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs.setInt(i++, Integer.parseInt((String)bkgMap.get("NEW_FF_BROG_SEQ")));

				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs).getQueryString());
				iCount = insertPs.executeUpdate();
				
				// 입력된 데이타가 한 건도 없을 경우 Error 처리한다.
				if(iCount == 0) {
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00050").getUserMessage()); // Brokerage Type Size Distribution from B/L Commission Error!
					createBRKGCommErrorMSG( con, brogMap );
					bkgMap.put("brogMap", brogMap);
					return bkgMap;
				}
				
			} else { // Container인 경우
				
				//입력
				insertQuery.append("    INSERT \n");
				insertQuery.append("      INTO AGT_BROG_COMM_DTL \n");
				insertQuery.append("         ( \n");
				insertQuery.append("           BKG_NO, \n");
				insertQuery.append("           BROG_SEQ, \n");
				insertQuery.append("           CNTR_TPSZ_CD, \n");
				insertQuery.append("           BKG_VOL_QTY, \n");
				insertQuery.append("           LOCL_CURR_CD, \n");
				insertQuery.append("           ACT_USD_COMM_AMT, \n");
				insertQuery.append("           UPD_USR_ID, \n");
				insertQuery.append("           UPD_DT, \n");
				insertQuery.append("           CRE_USR_ID, \n");
				insertQuery.append("           CRE_DT \n");
				insertQuery.append("         ) \n");
				insertQuery.append("    SELECT \n");
				insertQuery.append("           INS.BKG_NO                                           AS BKG_NO, \n");
				insertQuery.append("           INS.BROG_SEQ                                         AS BROG_SEQ, \n");
				insertQuery.append("           INS.CNTR_TPSZ_CD                                     AS CNTR_TPSZ_CD, \n");
				insertQuery.append("           INS.BKG_VOL_QTY                                      AS BKG_VOL_QTY, \n");
				insertQuery.append("           'USD'                                                AS LOCL_CURR_CD, \n");
				insertQuery.append("      CASE \n");
				insertQuery.append("      WHEN INS.MNUM = INS.RNUM \n");
				insertQuery.append("      THEN \n");
				insertQuery.append("           ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2) \n");
				insertQuery.append("         + \n");
				insertQuery.append("         ( \n");
				insertQuery.append("           INS.ACT_IF_COMM_AMT \n");
				insertQuery.append("         - SUM (ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2)) \n");
				insertQuery.append("           OVER (ORDER BY INS.CNTR_TPSZ_CD) \n");
				insertQuery.append("         ) \n");
				insertQuery.append("      ELSE \n");
				insertQuery.append("           ROUND (INS.ACT_IF_COMM_AMT * INS.OFT_RATIO, 2) \n");
				insertQuery.append("       END                                                      AS ACT_USD_COMM_AMT, \n");
				insertQuery.append("           'BROKERAGE System'                                   AS UPD_USR_ID, \n");
				insertQuery.append("           SYSDATE                                              AS UPD_DT, \n");
				insertQuery.append("           'BROKERAGE System'                                   AS CRE_USR_ID, \n");
				insertQuery.append("           SYSDATE                                              AS CRE_DT \n");
				insertQuery.append("      FROM \n");
				insertQuery.append("         ( \n");
				insertQuery.append("               SELECT \n");
				insertQuery.append("                      ROWNUM                                    AS RNUM, \n");
				insertQuery.append("                    ( \n");
				insertQuery.append("                          SELECT \n");
				insertQuery.append("                                 COUNT (1) \n");
				insertQuery.append("                            FROM AGT_BKG_REV_DTL RE2 \n");
				insertQuery.append("                           WHERE RE2.BKG_NO = REV.BKG_NO \n");
				insertQuery.append("                    )                                           AS MNUM, \n");
				insertQuery.append("                      REV.BKG_NO                                AS BKG_NO, \n");
				insertQuery.append("                      QTY.BROG_SEQ                              AS BROG_SEQ, \n");
				insertQuery.append("                      QTY.ACT_IF_COMM_AMT                       AS ACT_IF_COMM_AMT, \n");
				insertQuery.append("                      REV.CNTR_TPSZ_CD                          AS CNTR_TPSZ_CD, \n");
				insertQuery.append("                      REV.BKG_VOL_QTY                           AS BKG_VOL_QTY, \n");

				insertQuery.append("                 CASE \n");
				insertQuery.append("                 WHEN QTY.TOT_QTY = 0 \n");
				insertQuery.append("                   OR QTY.TOT_QTY IS NULL \n");
				insertQuery.append("                 THEN 0 \n");
				insertQuery.append("                 ELSE \n");
				insertQuery.append("                      CASE \n");
				insertQuery.append("                      WHEN SUBSTR (REV.CNTR_TPSZ_CD, 2, 1) = '2' \n");
				insertQuery.append("                      THEN REV.BKG_VOL_QTY \n");
				insertQuery.append("                      ELSE REV.BKG_VOL_QTY * 2 \n");
				insertQuery.append("                       END / QTY.TOT_QTY \n");
				insertQuery.append("                  END                                           AS OFT_RATIO \n");

//				insertQuery.append("                      RATIO_TO_REPORT (REV.BKG_OFT_REV) \n");
//				insertQuery.append("                      OVER (PARTITION BY REV.BKG_NO)            AS OFT_RATIO \n");
				insertQuery.append("                 FROM AGT_BKG_REV_DTL REV, \n");
//				insertQuery.append("                    ( \n");
//				insertQuery.append("                          SELECT \n");
//				insertQuery.append("                                 BRO.BKG_NO, \n");
//				insertQuery.append("                                 BRO.BROG_SEQ, \n");
//				insertQuery.append("                                 BRO.ACT_IF_COMM_AMT \n");
//				insertQuery.append("                            FROM AGT_BROG_COMM BRO \n");
//				insertQuery.append("                           WHERE BRO.BKG_NO    = ? \n");
//				insertQuery.append("                             AND BRO.BROG_SEQ  = ? \n");
//				insertQuery.append("                    ) AMT \n");
				insertQuery.append("                    ( \n");
				insertQuery.append("                          SELECT \n");
				insertQuery.append("                                 MAX (REV.BKG_NO)               AS BKG_NO, \n");
				insertQuery.append("                                 MAX (AMT.BROG_SEQ)             AS BROG_SEQ, \n");
				insertQuery.append("                                 MAX (AMT.ACT_IF_COMM_AMT)      AS ACT_IF_COMM_AMT, \n");
				insertQuery.append("                                 SUM \n");
				insertQuery.append("                               ( \n");
				insertQuery.append("                             CASE \n");
				insertQuery.append("                             WHEN SUBSTR (REV.CNTR_TPSZ_CD, 2, 1) = '2' \n");
				insertQuery.append("                             THEN REV.BKG_VOL_QTY \n");
				insertQuery.append("                             ELSE REV.BKG_VOL_QTY * 2 \n");
				insertQuery.append("                              END \n");
				insertQuery.append("                                )                               AS TOT_QTY \n");
				insertQuery.append("                             FROM AGT_BKG_REV_DTL REV, \n");
				insertQuery.append("                                ( \n");
				insertQuery.append("                                      SELECT \n");
				insertQuery.append("                                             BRO.BKG_NO, \n");
				insertQuery.append("                                             BRO.BROG_SEQ, \n");
				insertQuery.append("                                             BRO.ACT_IF_COMM_AMT \n");
				insertQuery.append("                                        FROM AGT_BROG_COMM BRO \n");
				insertQuery.append("                                       WHERE BRO.BKG_NO    = ? \n");
				insertQuery.append("                                         AND BRO.BROG_SEQ  = ? \n");
				insertQuery.append("                                ) AMT \n");
				insertQuery.append("                            WHERE REV.BKG_NO = AMT.BKG_NO \n");
				insertQuery.append("                    ) QTY \n");
				insertQuery.append("                WHERE REV.BKG_NO = QTY.BKG_NO \n");
				insertQuery.append("         ) INS \n");
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs = new LoggableStatement(con, insertQuery.toString());
				} else {
					insertPs = con.prepareStatement(insertQuery.toString());
				}
	
				//setting
				insertPs.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs.setInt(i++, Integer.parseInt((String)bkgMap.get("NEW_FF_BROG_SEQ")));
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs).getQueryString());
				iCount = insertPs.executeUpdate();
				
				// 입력된 데이타가 한 건도 없을 경우 Error 처리한다.
				if(iCount == 0) {
					brogMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00051").getUserMessage()); // Brokerage Type Size Distribution from Container Commission Error!
					createBRKGCommErrorMSG( con, brogMap );
					bkgMap.put("brogMap", brogMap);
					return bkgMap;
				}
			}

			i = 1; // 초기화한다.
			
			// CHG DTL에 데이타 등록한다. -------start------- 
			if("BA".equals(brog_div_cd)) {
				
				// 입력
				insertQuery02.append("INSERT INTO agt_brog_chg_dtl \n");
				insertQuery02.append("            (bkg_no, brog_seq, chg_cd, bkg_chg_amt, UPD_USR_ID, UPD_DT,cre_usr_id, \n");
				insertQuery02.append("             cre_dt) \n");
				insertQuery02.append("   SELECT   ?, ?, chg_cd, SUM (CHG_AMT), \n");
				insertQuery02.append("            'Brokerage System', SYSDATE,'Brokerage System', SYSDATE \n");
				insertQuery02.append("       FROM bkg_chg_rt \n");
				insertQuery02.append("      WHERE bkg_no = ? \n");
				insertQuery02.append("        AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
				insertQuery02.append("        AND curr_cd = 'USD' \n");
				insertQuery02.append("   GROUP BY chg_cd \n");
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs02 = new LoggableStatement(con, insertQuery02.toString());
				} else {
					insertPs02 = con.prepareStatement(insertQuery02.toString());
				}
	
				//setting
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setInt(i++, Integer.parseInt((String)bkgMap.get("NEW_FF_BROG_SEQ")));
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs02).getQueryString());
				insertPs02.executeUpdate();

			} else if("BF".equals(brog_div_cd)) {
				
				// 입력
				insertQuery02.append("INSERT INTO agt_brog_chg_dtl \n");
				insertQuery02.append("            (bkg_no, brog_seq, chg_cd, bkg_chg_amt, UPD_USR_ID, UPD_DT, cre_usr_id, \n");
				insertQuery02.append("             cre_dt) \n");
				insertQuery02.append("   SELECT   ?, ?, chg_cd, SUM (CHG_AMT), \n");
				insertQuery02.append("            'Brokerage System', SYSDATE, 'Brokerage System', SYSDATE \n");
				insertQuery02.append("       FROM bkg_chg_rt \n");
				insertQuery02.append("      WHERE bkg_no = ? \n");
				insertQuery02.append("        AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
				insertQuery02.append("        AND curr_cd = 'USD' \n");
				insertQuery02.append("        AND chg_cd IN ('OFT', 'GRI') \n");
				insertQuery02.append("   GROUP BY chg_cd \n");
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs02 = new LoggableStatement(con, insertQuery02.toString());
				} else {
					insertPs02 = con.prepareStatement(insertQuery02.toString());
				}
	
				//setting
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setInt(i++, Integer.parseInt((String)bkgMap.get("NEW_FF_BROG_SEQ")));
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs02).getQueryString());
				insertPs02.executeUpdate();

			} else if("BS".equals(brog_div_cd)) {
				
				brog_chg_ctnt = "'" + brog_chg_ctnt.replaceAll(",", "','") + "'"; 
				
				// 입력
				insertQuery02.append("INSERT INTO agt_brog_chg_dtl \n");
				insertQuery02.append("            (bkg_no, brog_seq, chg_cd, bkg_chg_amt,UPD_USR_ID, UPD_DT, cre_usr_id, \n");
				insertQuery02.append("             cre_dt) \n");
				insertQuery02.append("   SELECT   ?, ?, chg_cd, SUM (CHG_AMT), \n");
				insertQuery02.append("            'Brokerage System', SYSDATE, 'Brokerage System', SYSDATE \n");
				insertQuery02.append("       FROM bkg_chg_rt \n");
				insertQuery02.append("      WHERE bkg_no = ? \n");
				insertQuery02.append("        AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
				insertQuery02.append("        AND curr_cd = 'USD' \n");
				insertQuery02.append("        AND chg_cd IN ("+brog_chg_ctnt+") \n");
				insertQuery02.append("   GROUP BY chg_cd \n");
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs02 = new LoggableStatement(con, insertQuery02.toString());
				} else {
					insertPs02 = con.prepareStatement(insertQuery02.toString());
				}
	
				//setting
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setInt(i++, Integer.parseInt((String)bkgMap.get("NEW_FF_BROG_SEQ")));
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs02).getQueryString());
				insertPs02.executeUpdate();
			} 
			// CHG DTL에 데이타 등록한다. -------end-------
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(insertPs);
			closeStatement(insertPs02);
			closeConnection(con);
		}
		
		return bkgMap;
	}
	
	/**
	 * Brokerage Commission의 Customer Name이 Booking의 Customer name과 비교하여 같지 않을 경우 comm_proc_sts_cd를 'CE'로 변경한다.
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @throws DAOException
	 */
	public void checkBRKGCustName(HashMap bkgMap) throws DAOException {

		log.debug("\n\n checkBRKGCustName 메소드 시작 ========================================\n");
		
		// Connection Interface   
		Connection con = null;
		// 조회를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		PreparedStatement ps02  = null;
		// INSERT를 수행하기 위한 SQL Statement
		PreparedStatement updatePs  = null;
		// ResultSet
		ResultSet rs = null;
		ResultSet rs02 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		String bkg_no = "";
		String ff_cust_seq = "";
		String cust_nm = "";
		
		int iFf_cust_seq = 0;
		int iBrog_seq = 0;
		
		boolean isMatchCust = false;
		
		// Brokerage Commission 정보를 담고 있는 HashMap
		HashMap brogMap = null;

		StringBuffer queryStr = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();
		StringBuffer updateQuery = new StringBuffer();

		// 조회
		queryStr.append("SELECT NVL(REPLACE(REPLACE(cust_lgl_eng_nm, CHR(13)||CHR(10), ' '), CHR(9),' '), ' ') cust_lgl_eng_nm \n");
		queryStr.append("  FROM mdm_customer \n");
		queryStr.append(" WHERE cust_cnt_cd = ? \n");
		queryStr.append("   AND cust_seq = ? \n");
		queryStr.append("   AND NVL (delt_flg, 'N') = 'N' \n");
        
		//수정
		updateQuery.append("UPDATE agt_brog_comm \n");
		updateQuery.append("   SET comm_proc_sts_cd = 'CE' \n");
		updateQuery.append(" WHERE bkg_no = ? \n");
		updateQuery.append("       AND brog_seq = ? \n");

		try {

			// Brokerage Commission 정보를 담고 있는 HashMap
			brogMap = (HashMap)bkgMap.get("brogMap");

			bkg_no = (String)bkgMap.get("BKG_NO");
			ff_cust_seq = checkNull((String)bkgMap.get("FF_CUST_SEQ"));
			iBrog_seq = Integer.parseInt((String)brogMap.get("BROG_SEQ"));
			
			if(ff_cust_seq.length() > 0 && !"*".equals(ff_cust_seq)) {
				iFf_cust_seq = Integer.parseInt((String)bkgMap.get("FF_CUST_SEQ"));
			}
			
			// Connection을 얻어 온다.
			con = getConnection();

			// Brokerage cust_nm을 구한다. -------start-------
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}

			ps.setString(i++, (String)bkgMap.get("FF_CNT_CD"));		// cust_cnt_cd
			ps.setInt(i++, iFf_cust_seq);							// cust_seq
			
            // Loggable Statement 사용에 의해 추가 
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                log.debug("\n SQL :::::::::\n" + ((LoggableStatement)ps).getQueryString());
            } else {
                log.debug("\n SQL :::::::::\n" + queryStr.toString() );
            }
            
			rs = ps.executeQuery();
			
			if(rs.next()) {
				cust_nm = checkNull(rs.getString(1));
			}
			// cust_nm을 구한다. -------end-------

			// Brokerage Commission FF Customer name이 BKG_CUSTOMER의 cust_nm과 동일한지 체크한다.-------start-------
			i = 1; //초기화

	        queryStr02.append("SELECT bkg_no, NVL(REPLACE(REPLACE(cust_nm, CHR(13)||CHR(10), ' '), CHR(9),' '), ' ') cust_nm \n");
	        queryStr02.append("  FROM BKG_CUSTOMER \n");
	        queryStr02.append(" WHERE bkg_no = ? \n");
	        queryStr02.append("   AND bkg_cust_tp_cd = 'F' \n");
	        
	        if(cust_nm.length() > 10) {
	        	queryStr02.append("   AND cust_nm LIKE ? || '%' \n");
	        } else {
	        	queryStr02.append("   AND cust_nm = ? \n");
	        }

			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps02 = new LoggableStatement(con, queryStr02.toString());
			} else {
				ps02 = con.prepareStatement(queryStr02.toString());
			}

			if(cust_nm.length() > 10) {
				cust_nm = cust_nm.substring(0, 10);
			}
			
			ps02.setString(i++, bkg_no);			// bkg_no
			ps02.setString(i++, cust_nm);
			
            // Loggable Statement 사용에 의해 추가 
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                log.debug("\n SQL1 :::::::::\n" + ((LoggableStatement)ps02).getQueryString());
            } else {
                log.debug("\n SQL1 :::::::::\n" + queryStr02.toString() );
            }
            
			rs02 = ps02.executeQuery();
			
			if(rs02.next()) {
				isMatchCust = true;
			}
			// Brokerage Commission FF Customer name이 BKG_CUSTOMER의 cust_nm과 동일한지 체크한다. -------end-------
	        
			// Brokerage Commission FF Customer name가 일치하지 않으면 comm_proc_sts_cd를 'CE'로 Update한다.
			if(!isMatchCust) {
				// Brokerage Commission Status Update -------start-------
				i = 1; //초기화
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					updatePs = new LoggableStatement(con, updateQuery.toString());
				} else {
					updatePs = con.prepareStatement(updateQuery.toString());
				}
	
				//setting
				updatePs.setString(i++, bkg_no);			// bkg_no
				updatePs.setInt(i++, iBrog_seq);			// brog_seq
	
				log.debug("\n SQL1 : \n" + ((LoggableStatement)updatePs).getQueryString());
				updatePs.executeUpdate();
				// Brokerage Commission Status Update -------end-------
			}
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeResultSet(rs02);
			closeStatement(updatePs);
			closeStatement(ps);
			closeStatement(ps02);
			closeConnection(con);
		}
	}
	
	/**
	 * CUSTOMER 정보 가져오기<br>
	 * 
	 * @param con Connection
	 * @param bkgMap HashMap 조회 조건 및 Booking 데이타
	 * @return HashMap CUSTOMER 정보 및 Booking 데이타
	 * @throws SQLException, Exception
	 */
	private HashMap<String, Serializable> getCustomer( Connection con, HashMap bkgMap) throws SQLException, Exception {
		
		log.debug("\n\n getCustomer 메소드 시작 ========================================\n");
		
		PreparedStatement	ps			= null;	// 정적파싱을 지원하는 SQL Statement
		ResultSet			rs			= null;	// DB ResultSet
		ResultSetMetaData	mataData	= null;

		String bkg_no		= (String)bkgMap.get("BKG_NO");
		String columnName	= "";

		int i				= 1;				// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int columnCount		= 0;
		
		// 조회쿼리
		StringBuffer query = new StringBuffer();
		
		// CUSTOMER 조회 쿼리
		query.append("    SELECT \n");
		query.append("           CST.SHPR_CNT_CD, \n");
		query.append("           CST.SHPR_CUST_SEQ, \n");
		query.append("           CST.FF_CNT_CD, \n");
		query.append("           CST.FF_CUST_SEQ, \n");
		query.append("      CASE \n");
		query.append("      WHEN CST.FMC_NO IS NOT NULL \n");
		query.append("      THEN CST.FMC_NO \n");
		query.append("      WHEN CST.FMC_NO_MDM IS NOT NULL \n");
		query.append("      THEN CST.FMC_NO_MDM \n");
		query.append("      ELSE CST.FMC_NO_PREV \n");
		query.append("       END                                                           AS FMC_NO, \n");
		query.append("      CASE \n");
		query.append("      WHEN TRIM (CST.FMC_NO)      IS NOT NULL \n");
		query.append("        OR TRIM (CST.FMC_NO_MDM)  IS NOT NULL \n");
		query.append("        OR TRIM (CST.FMC_NO_PREV) IS NOT NULL \n");
		query.append("      THEN '0' \n");
		query.append("      ELSE '1' \n");
		query.append("       END                                                           AS FF_FMC_CHECK_FLAG, \n");
		query.append("           CST.REFERENCE_NO, \n");
		query.append("           CST.SH_FF_CHECK_FLAG, \n");
		query.append("           CST.FF_CHECK \n");
		query.append("      FROM \n");
		query.append("         ( \n");
		query.append("               SELECT \n");
		query.append("                      NVL (BCS.CUST_CNT_CD, '*')                     AS SHPR_CNT_CD, \n");
		query.append("                      NVL (TO_CHAR (BCS.CUST_SEQ, 'FM000000'), '*')  AS SHPR_CUST_SEQ, \n");
		query.append("                      NVL (BC2.CUST_CNT_CD, '*')                     AS FF_CNT_CD, \n");
		query.append("                      NVL (TO_CHAR (BC2.CUST_SEQ, 'FM000000'), '*')  AS FF_CUST_SEQ, \n");
		query.append("                    ( \n");
		query.append("                          SELECT \n");
		query.append("                                 SUBSTR(MAX (CUST_REF_NO_CTNT),1,19) \n");
		query.append("                            FROM BKG_REFERENCE FMC \n");
		query.append("                           WHERE FMC.BKG_NO        = BCS.BKG_NO \n");
		query.append("                             AND FMC.BKG_REF_TP_CD = 'FMCN' \n");
		query.append("                             AND ROWNUM            = 1 \n");
		query.append("                    )                                                AS FMC_NO, \n");
		query.append("                    ( \n");
		query.append("                          SELECT \n");
		query.append("                                 MCS.FRT_FWRD_FMC_NO \n");
		query.append("                            FROM MDM_CUSTOMER MCS \n");
		query.append("                           WHERE MCS.CUST_CNT_CD          = BC2.CUST_CNT_CD \n");
		query.append("                             AND MCS.CUST_SEQ             = BC2.CUST_SEQ \n");
		query.append("                             AND MCS.RVIS_CNTR_CUST_TP_CD = 'N' \n");
		query.append("                             AND ROWNUM                   = 1 \n");
		query.append("                    )                                                AS FMC_NO_MDM, \n");
		query.append("                    ( \n");
		query.append("                          SELECT \n");
		query.append("                                 INF.FMC_NO \n");
		query.append("                            FROM AGT_COMM_BKG_INFO INF \n");
		query.append("                           WHERE INF.BKG_NO = BCS.BKG_NO \n");
		query.append("                    )                                                AS FMC_NO_PREV, \n");
		query.append("                      NVL(BC2.REF_NO, '*')                           AS REFERENCE_NO, \n");
		query.append("                 CASE BCS.CUST_CNT_CD||BCS.CUST_SEQ \n");
		query.append("                 WHEN BC2.CUST_CNT_CD||BC2.CUST_SEQ \n");
		query.append("                 THEN 1 \n");
		query.append("                 ELSE 0 \n");
		query.append("                  END                                                AS SH_FF_CHECK_FLAG, \n");
		query.append("                 CASE \n");
		query.append("                 WHEN LTRIM (BC2.CUST_CNT_CD) IS NULL \n");
		query.append("                 THEN 1 \n");
		query.append("                 ELSE 0 \n");
		query.append("                  END                                                AS FF_CHECK \n");
		query.append("                 FROM BKG_CUSTOMER BCS, \n");
		query.append("                      BKG_CUSTOMER BC2 \n");
		query.append("                WHERE BCS.BKG_NO         = BC2.BKG_NO(+) \n");
		query.append("                  AND BCS.BKG_CUST_TP_CD = 'S' \n");
		query.append("                  AND BC2.BKG_CUST_TP_CD = 'F' \n");
		query.append("                  AND BCS.BKG_NO         = ? \n");
		query.append("         ) CST \n");

		try
		{
			ps = new LoggableStatement(con, query.toString());
			ps.setString(i++, bkg_no);
			log.debug("\n SQL :::::::::\n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if (rs.next())
			{
				mataData	= rs.getMetaData();
				columnCount	= mataData.getColumnCount();

				for (int j = 1; j <= columnCount; j++)
				{
					columnName = mataData.getColumnName(j);
					bkgMap.put(columnName, rs.getString(columnName));
				}
			}
			
		}
		catch (SQLException e)
		{
			log.error(e.getMessage()
				+ "\n------------------------------------------------------------------------------------ "
				+ "\nBKG_NO: " + bkg_no
				+ "\n------------------------------------------------------------------------------------ "
				, e);
			throw e;
		}
		catch (Exception e)
		{
			log.error(e.getMessage()
				+ "\n------------------------------------------------------------------------------------ "
				+ "\nBKG_NO: " + bkg_no
				+ "\n------------------------------------------------------------------------------------ "
				, e);
			throw e;
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(ps);
		}
		return bkgMap;
	}

	/**
	 * S/U S/A Date를 구한다.<br>
	 * 
	 * @param con Connection
	 * @param map HashMap S/U 정보를 담고있는 HashMap
	 * @return HashMap
	 * @throws SQLException, Exception
	 */
	private HashMap getSADateOfSU( Connection con, HashMap map ) throws SQLException, Exception {
		
		log.debug("\n\n getSADateOfSU 메소드 시작 ========================================\n");
		
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps  = null;
		PreparedStatement ps02  = null;
		// DB ResultSet
		ResultSet rs = null;
		ResultSet rs02 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		String vsl_pre_pst_cd = "";
		String sa_dt = "";
		String sinwa_ts_sa_dt = "";

		// 조회쿼리
		StringBuffer query = new StringBuffer();
		StringBuffer query02 = new StringBuffer();
		
		query.append("SELECT ? vsl_pre_pst_cd, \n");
		query.append("	DECODE(?, 'S', TO_CHAR(t1.vps_etd_dt,'yyyymmddhh24miss'), TO_CHAR(t1.vps_eta_dt,'yyyymmddhh24miss') ) sa_dt \n");
		query.append("FROM vsk_vsl_port_skd t1, \n");
		query.append("	(SELECT MIN(clpt_ind_seq) CAL_IND \n");
		query.append("      FROM vsk_vsl_port_skd \n");
		query.append("     WHERE vsl_cd = ? \n");
		query.append("	     AND skd_voy_no = ? \n");
		query.append("	     AND skd_dir_cd = ? \n");
		query.append("	     AND vps_port_cd = DECODE(?, 'S', ?, ?) \n");
		query.append("	     AND NVL(skd_cng_sts_cd,'*') <> 'S' \n");
		query.append("    ) t3 \n");
		query.append("WHERE t1.vsl_cd = ? \n");
		query.append("	AND t1.skd_voy_no = ? \n");
		query.append("	AND t1.skd_dir_cd = ? \n");
		query.append("	AND t1.vps_port_cd = DECODE(?, 'S', ?, ?) \n"); //DECODE(:fvsl_pre_pst_cd[i], 'U', :fpol_loc[i], :fpod_loc[i])
		query.append("	AND t1.clpt_ind_seq = t3.cal_ind \n");
		query.append("	AND NVL(t1.skd_cng_sts_cd,' ') <> 'S' \n");
		
		// 2007.09.17 T/S Commission 용 SINWA 산하 Inbound ETD DATE 구하기
		query02.append("SELECT ? vsl_pre_pst_cd, \n");
		query02.append("	TO_CHAR(t1.vps_etd_dt,'yyyymmddhh24miss') sinwa_ts_sa_dt \n");
		query02.append("FROM vsk_vsl_port_skd t1, \n");
		query02.append("	(SELECT MIN(clpt_ind_seq) CAL_IND \n");
		query02.append("      FROM vsk_vsl_port_skd \n");
		query02.append("     WHERE vsl_cd = ? \n");
		query02.append("	     AND skd_voy_no = ? \n");
		query02.append("	     AND skd_dir_cd = ? \n");
		query02.append("	     AND vps_port_cd = ? \n");
		query02.append("	     AND NVL(skd_cng_sts_cd,'*') <> 'S' \n");
		query02.append("    ) t3 \n");
		query02.append("WHERE t1.vsl_cd = ? \n");
		query02.append("	AND t1.skd_voy_no = ? \n");
		query02.append("	AND t1.skd_dir_cd = ? \n");
		query02.append("	AND t1.vps_port_cd = ? \n"); 
		query02.append("	AND t1.clpt_ind_seq = t3.cal_ind \n");
		query02.append("	AND NVL(t1.skd_cng_sts_cd,' ') <> 'S' \n");

		try {
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, query.toString());
			} else {
				ps = con.prepareStatement(query.toString());
			}
			
			i = 1;
			ps.setString(i++, (String)map.get("VSL_PRE_PST_CD"));
			ps.setString(i++, (String)map.get("VSL_PRE_PST_CD"));
			ps.setString(i++, (String)map.get("VSL_CD"));
			ps.setString(i++, (String)map.get("SKD_VOY_NO"));
			ps.setString(i++, (String)map.get("SKD_DIR_CD"));
			ps.setString(i++, (String)map.get("VSL_PRE_PST_CD"));
			ps.setString(i++, (String)map.get("VSL_POL_CD"));
			ps.setString(i++, (String)map.get("VSL_POD_CD"));
			ps.setString(i++, (String)map.get("VSL_CD"));
			ps.setString(i++, (String)map.get("SKD_VOY_NO"));
			ps.setString(i++, (String)map.get("SKD_DIR_CD"));
			ps.setString(i++, (String)map.get("VSL_PRE_PST_CD"));
			ps.setString(i++, (String)map.get("VSL_POL_CD"));
			ps.setString(i++, (String)map.get("VSL_POD_CD"));
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				
				vsl_pre_pst_cd = rs.getString("vsl_pre_pst_cd");
				sa_dt = rs.getString("sa_dt");
				
				// Pre_pst_cd = 'S' 이면은 POD기준 ETA Date
				// Pre_pst_cd = 'U' 이면은 POL기준 ETD Date
				if("S".equals(vsl_pre_pst_cd)) {
					map.put("VPS_ETA_DT", "");
					map.put("VPS_ETD_DT", sa_dt);
				} else {
					map.put("VPS_ETA_DT", sa_dt);
					map.put("VPS_ETD_DT", "");
				}
			}
			
			// 2007.09.17 T/S Commission 용 SINWA 산하 Inbound ETD DATE 구하기
			//Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps02 = new LoggableStatement(con, query02.toString());
			} else {
				ps02 = con.prepareStatement(query02.toString());
			}
			
			i = 1;
			ps02.setString(i++, (String)map.get("VSL_PRE_PST_CD"));
			ps02.setString(i++, (String)map.get("VSL_CD"));
			ps02.setString(i++, (String)map.get("SKD_VOY_NO"));
			ps02.setString(i++, (String)map.get("SKD_DIR_CD"));
			ps02.setString(i++, (String)map.get("VSL_POL_CD"));
			ps02.setString(i++, (String)map.get("VSL_CD"));
			ps02.setString(i++, (String)map.get("SKD_VOY_NO"));
			ps02.setString(i++, (String)map.get("SKD_DIR_CD"));
			ps02.setString(i++, (String)map.get("VSL_POL_CD"));
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
			
			rs02 = ps02.executeQuery();
			
			if( rs02.next() ) {
				
				vsl_pre_pst_cd = rs02.getString("vsl_pre_pst_cd");
				sinwa_ts_sa_dt = rs02.getString("sinwa_ts_sa_dt");
				
				map.put("SINWA_TS_SA_DT", sinwa_ts_sa_dt);

			}
			
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw e;
		} finally {
			closeResultSet(rs);
			closeResultSet(rs02);
			closeStatement(ps);
			closeStatement(ps02);
		}
		
		return map;
	}
	
	/**
	 * Trunk Etd Date를 구한다.<br>
	 * 
	 * @param con Connection
	 * @param map HashMap Trunk 정보를 담고있는 HashMap
	 * @return HashMap
	 * @throws SQLException, Exception
	 */
	private HashMap getSADateOfTrunkEtdDt( Connection con, HashMap map ) throws SQLException, Exception {
		
		log.debug("\n\n getSADateOfTrunkEtdDt 메소드 시작 ========================================\n");
		
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps  = null;
		// DB ResultSet
		ResultSet rs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		// 조회쿼리
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT TO_CHAR(t1.vps_etd_dt,'yyyymmddhh24miss') vps_etd_dt \n");
		query.append("FROM vsk_vsl_port_skd t1, \n");
		query.append("     ( SELECT MIN(TO_NUMBER(clpt_ind_seq)) cal_ind \n");
		query.append("        FROM vsk_vsl_port_skd \n");
		query.append("       WHERE vsl_cd = ? \n");
		query.append("          AND skd_voy_no = ? \n");
		query.append("          AND skd_dir_cd = ? \n");
		query.append("          AND vps_port_cd = ? \n"); //pol_loc
		query.append("          AND NVL(skd_cng_sts_cd,'*') <> 'S' \n");
		query.append("     ) t3 \n");
		query.append("WHERE t1.vsl_cd = ? \n");
		query.append("	AND t1.skd_voy_no = ? \n");
		query.append("	AND t1.skd_dir_cd = ? \n");
		query.append("	AND t1.vps_port_cd = ? \n"); //pol_loc
		query.append("	AND t1.clpt_ind_seq = t3.cal_ind \n");
		query.append("	AND NVL(t1.skd_cng_sts_cd,' ') <> 'S' \n");

		try {
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, query.toString());
			} else {
				ps = con.prepareStatement(query.toString());
			}

			ps.setString(i++, (String)map.get("VSL_CD"));
			ps.setString(i++, (String)map.get("SKD_VOY_NO"));
			ps.setString(i++, (String)map.get("SKD_DIR_CD"));
			ps.setString(i++, (String)map.get("VSL_POL_CD"));
			ps.setString(i++, (String)map.get("VSL_CD"));
			ps.setString(i++, (String)map.get("SKD_VOY_NO"));
			ps.setString(i++, (String)map.get("SKD_DIR_CD"));
			ps.setString(i++, (String)map.get("VSL_POL_CD"));
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				map.put("VPS_ETD_DT", rs.getString("vps_etd_dt"));
			}
			
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw e;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		
		return map;
	}
	
	/**
	 * Trunk Eta Date를 구한다.<br>
	 * 
	 * @param con Connection
	 * @param map HashMap Trunk 정보를 담고있는 HashMap
	 * @return HashMap
	 * @throws SQLException, Exception
	 */
	private HashMap getSADateOfTrunkEtaDt( Connection con, HashMap map ) throws SQLException, Exception {
		
		log.debug("\n\n getSADateOfTrunkEtaDt 메소드 시작 ========================================\n");
		
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps  = null;
		// DB ResultSet
		ResultSet rs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// 조회쿼리
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT TO_CHAR(t1.vps_eta_dt,'yyyymmddhh24miss') vps_eta_dt \n");
		query.append("FROM vsk_vsl_port_skd t1, \n");
		query.append("     ( SELECT MIN(TO_NUMBER(clpt_ind_seq)) cal_ind \n");
		query.append("        FROM vsk_vsl_port_skd \n");
		query.append("       WHERE vsl_cd = ? \n");
		query.append("          AND skd_voy_no = ? \n");
		query.append("          AND skd_dir_cd = ? \n");
		query.append("          AND vps_port_cd = ? \n"); //pod_loc
		query.append("          AND NVL(skd_cng_sts_cd,'*') <> 'S' \n");
		query.append("     ) t3 \n");
		query.append("WHERE t1.vsl_cd = ? \n");
		query.append("	AND t1.skd_voy_no = ? \n");
		query.append("	AND t1.skd_dir_cd = ? \n");
		query.append("	AND t1.vps_port_cd = ? \n"); //pod_loc
		query.append("	AND t1.clpt_ind_seq = t3.cal_ind \n");
		query.append("	AND NVL(t1.skd_cng_sts_cd,' ') <> 'S' \n");

		try {
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, query.toString());
			} else {
				ps = con.prepareStatement(query.toString());
			}
			
			ps.setString(i++, (String)map.get("VSL_CD"));
			ps.setString(i++, (String)map.get("SKD_VOY_NO"));
			ps.setString(i++, (String)map.get("SKD_DIR_CD"));
			ps.setString(i++, (String)map.get("VSL_POD_CD"));
			ps.setString(i++, (String)map.get("VSL_CD"));
			ps.setString(i++, (String)map.get("SKD_VOY_NO"));
			ps.setString(i++, (String)map.get("SKD_DIR_CD"));
			ps.setString(i++, (String)map.get("VSL_POD_CD"));
			
			log.debug("\n SQL : Trunk Eta Date를 구한다 \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if( rs.next() ) {
				map.put("VPS_ETA_DT", rs.getString("vps_eta_dt"));
			}
			
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw e;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		
		return map;
	}

	/**
	 * Old F/F Code 가 I/F 된 금액이 있는지 확인<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchOldIfCommFFCode(HashMap bkgMap) throws DAOException {

		log.debug("\n\n Old F/F Code 가 I/F 된 금액이 있는지 확인 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;

		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

//		ResultSetMetaData mataData = null;
//		int columnCount = 0;
//		String columnName = "";

		String bkg_no = "";
//		String rfa_no = "";
//		String sc_no = "";
		
		StringBuffer queryStr = new StringBuffer();

		queryStr.append("select OLD_FRT_FWRD_CNT_CD, OLD_FRT_FWRD_SEQ,OLD_SUM_ACT_IF_COMM_AMT \n");
		queryStr.append("from ( \n");
		queryStr.append("	select FRT_FWRD_CNT_CD OLD_FRT_FWRD_CNT_CD, \n");
		queryStr.append("	       TO_CHAR(FRT_FWRD_SEQ) OLD_FRT_FWRD_SEQ, \n");
		queryStr.append("	       COMM_PROC_STS_CD, \n");
		queryStr.append("	       SUBSTR(TO_CHAR(SUM (ACT_IF_COMM_AMT)),1,15) OLD_SUM_ACT_IF_COMM_AMT \n");
		queryStr.append("	From agt_brog_comm \n");
		queryStr.append("	where bkg_no= ? \n");
		queryStr.append("	AND FRT_FWRD_CNT_CD||FRT_FWRD_SEQ <> ?||to_number(?) \n");
		queryStr.append("	GROUP BY FRT_FWRD_CNT_CD,FRT_FWRD_SEQ,COMM_PROC_STS_CD \n");
		queryStr.append(") \n");
		queryStr.append("where OLD_SUM_ACT_IF_COMM_AMT <> 0 \n");
		queryStr.append("AND COMM_PROC_STS_CD = 'IF' \n");


		
		try {
			
			bkg_no = (String)bkgMap.get("BKG_NO");
			
			con = getConnection();
			
			//SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER 조회-----start-----
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, bkg_no);
			ps.setString(i++, (String)bkgMap.get("FF_CNT_CD"));
			ps.setString(i++, (String)bkgMap.get("FF_CUST_SEQ"));
			log.debug("\n [searchOldIfCommFFCode]SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if( rs.next() ) {
				bkgMap.put("OLD_FRT_FWRD_CNT_CD"	, rs.getString("OLD_FRT_FWRD_CNT_CD"));
				bkgMap.put("OLD_FRT_FWRD_SEQ"		, rs.getString("OLD_FRT_FWRD_SEQ"));
				bkgMap.put("OLD_SUM_ACT_IF_COMM_AMT", rs.getString("OLD_SUM_ACT_IF_COMM_AMT"));
			} 
			
			
			log.debug("old_::::"+(String)bkgMap.get("OLD_FRT_FWRD_CNT_CD"));
			log.debug("old_::::"+(String)bkgMap.get("OLD_FRT_FWRD_SEQ"));
			log.debug("old_::::"+(String)bkgMap.get("OLD_SUM_ACT_IF_COMM_AMT"));
//				else {
//				// 데이타가 존재하지 않을 경우 Error를 agt_comm_bkg_info에 저장한다.
//				bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00038").getUserMessage());
//				createBKGMSTErrorMSG( con, bkgMap );
//				return bkgMap;
//			}

			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return bkgMap;
	}
	
	/**
	 * Old F/F Code를 상계 하기 위한 seq 구하기<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchNewFFSeq(HashMap bkgMap) throws DAOException {

		log.debug("\n\n Old F/F Code를 상계 하기 위한 seq 구하기  ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;

		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
//		ResultSetMetaData mataData = null;
//		int columnCount = 0;
//		String columnName = "";

		String bkg_no = "";
//		String rfa_no = "";
//		String sc_no = "";
		
		StringBuffer queryStr = new StringBuffer();


		queryStr.append("	select to_char(max(BROG_SEQ)+1) new_ff_brog_seq \n");
		queryStr.append("	From agt_brog_comm \n");
		queryStr.append("	where bkg_no= ? \n");



		
		try {
			
			bkg_no = (String)bkgMap.get("BKG_NO");
			
			con = getConnection();
			
			//SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER 조회-----start-----
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, bkg_no);

			log.debug("\n [searchNewFFSeq]SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if( rs.next() ) {
				bkgMap.put("NEW_FF_BROG_SEQ"	, rs.getString("NEW_FF_BROG_SEQ"));
			} 

			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return bkgMap;
	}	

	/**
	 * 현재 F/F Code 가 CS로 생성 된 금액이 있는지 확인<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchIfCommFFCode(HashMap bkgMap) throws DAOException {

		log.debug("\n\n Old F/F Code 가 I/F 된 금액이 있는지 확인 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;

		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
//		ResultSetMetaData mataData = null;
//		int columnCount = 0;
//		String columnName = "";

		String bkg_no = "";
//		String rfa_no = "";
//		String sc_no = "";
		
		StringBuffer queryStr = new StringBuffer();

		queryStr.append("select P_SUM_ACT_IF_COMM_AMT \n");
		queryStr.append("from ( \n");
		queryStr.append("	select FRT_FWRD_CNT_CD OLD_FRT_FWRD_CNT_CD, \n");
		queryStr.append("	       TO_CHAR(FRT_FWRD_SEQ) OLD_FRT_FWRD_SEQ, \n");
		queryStr.append("	       COMM_PROC_STS_CD, \n");
		queryStr.append("	       SUBSTR(TO_CHAR(SUM (ACT_IF_COMM_AMT)),1,15) P_SUM_ACT_IF_COMM_AMT \n");
		queryStr.append("	From agt_brog_comm \n");
		queryStr.append("	where bkg_no = ? \n");
		queryStr.append("	AND FRT_FWRD_CNT_CD||FRT_FWRD_SEQ = ?||? \n");
		queryStr.append("	GROUP BY FRT_FWRD_CNT_CD,FRT_FWRD_SEQ,COMM_PROC_STS_CD \n");
		queryStr.append(") \n");
		queryStr.append("where P_SUM_ACT_IF_COMM_AMT <> 0 \n");
		queryStr.append("AND COMM_PROC_STS_CD = 'CS' \n");


		
		try {
			
			bkg_no = (String)bkgMap.get("BKG_NO");
			
			con = getConnection();
			
			//SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER 조회-----start-----
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, bkg_no);
			ps.setString(i++, (String)bkgMap.get("FF_CNT_CD"));
			ps.setString(i++, (String)bkgMap.get("FF_CUST_SEQ"));
			log.debug("\n [searchIfCommFFCode]SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			
			rs = ps.executeQuery();

			if( rs.next() ) {
				bkgMap.put("P_SSUM_ACT_IF_COMM_AMT", rs.getString("P_SUM_ACT_IF_COMM_AMT"));
			} 
//				else {
//				// 데이타가 존재하지 않을 경우 Error를 agt_comm_bkg_info에 저장한다.
//				bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00038").getUserMessage());
//				createBKGMSTErrorMSG( con, bkgMap );
//				return bkgMap;
//			}

			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return bkgMap;
	}
	
	
	/**
	 * FF 상계 로직 <br>
	 * @param bkgMap HashMap Booking 정보를 담고있는 HashMap
	 * @throws DAOException
	 */
	public void deleteBRKGComm( HashMap bkgMap) throws DAOException
	{
		
		String bkg_no = (String)bkgMap.get("BKG_NO");

		// Connection Interface
		Connection con = null;		
		// Error INSERT/UPDATE를 수행하기 위한 SQL Statement
		PreparedStatement ps01  = null;
		PreparedStatement ps02  = null;
		PreparedStatement ps03  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		

	// 저장쿼리
		StringBuffer query01 = new StringBuffer();
		StringBuffer query02 = new StringBuffer();
		StringBuffer query03 = new StringBuffer();
		
		query01.append("DELETE FROM agt_brog_chg_dtl \n");
		query01.append("WHERE ( bkg_no, brog_seq ) in  ( \n");
		query01.append("		SELECT BKG_NO,BROG_SEQ \n");
		query01.append("		FROM AGT_BROG_COMM\n");
		query01.append("		WHERE BKG_NO = ? \n");
		query01.append("		AND COMM_PROC_STS_CD != 'IF'\n");
		query01.append("		)\n");
		
		query02.append("DELETE FROM agt_brog_comm_dtl \n");
		query02.append("WHERE ( bkg_no, brog_seq ) in  ( \n");
		query02.append("		SELECT BKG_NO,BROG_SEQ \n");
		query02.append("		FROM AGT_BROG_COMM\n");
		query02.append("		WHERE BKG_NO = ? \n");
		query02.append("		AND COMM_PROC_STS_CD != 'IF'\n");
		query02.append("		)\n");
		
		query03.append("DELETE FROM agt_brog_comm \n");
		query03.append("WHERE bkg_no = ? \n");
		query03.append("	AND comm_proc_sts_cd != 'IF' \n");





		try
		{
			
			
			con = getConnection();
			int i = 1;
			ps01 = new LoggableStatement(con, query01.toString());
			ps01.setString(i++, bkg_no);				//bkg_no
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps01).getQueryString());
			ps01.executeUpdate();
			
			i = 1;
			ps02 = new LoggableStatement(con, query02.toString());
			ps02.setString(i++, bkg_no);				//bkg_no
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
			ps02.executeUpdate();
			
			i = 1;
			ps03 = new LoggableStatement(con, query03.toString());
			ps03.setString(i++, bkg_no);				//bkg_no
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps03).getQueryString());
			ps03.executeUpdate();
			
			
		}
		catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(ps01);
			closeStatement(ps02);
			closeStatement(ps03);
			closeConnection(con);
		}
	}
		

	/**
	 * FF 상계 로직 <br>
	 * @param bkgMap HashMap Booking 정보를 담고있는 HashMap
	 * @throws DAOException
	 */
	public void createBRKGComm( HashMap bkgMap) throws DAOException
	{
		
		String bkg_no = (String)bkgMap.get("BKG_NO");

		// Connection Interface
		Connection con = null;		
		// Error INSERT/UPDATE를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

	// 저장쿼리
		StringBuffer query = new StringBuffer();
		
		query.append("     INSERT INTO AGT_BROG_COMM                                    \n");
		query.append("     SELECT                                                       \n");
		query.append("          BKG_NO                                                  \n");
		query.append("         ,? BROG_SEQ                                 \n");
		query.append("         ,COMM_OCCR_INFO_CD                                       \n");
		query.append("         ,AR_OFC_CD                                               \n");
		query.append("         ,AP_OFC_CD                                               \n");
		query.append("         ,COMM_STND_COST_CD                                       \n");
		query.append("         ,'CS' COMM_PROC_STS_CD                                   \n");
		query.append("         ,'Commission Calculation Success!' COMM_PROC_RSLT_RSN	\n");
		query.append("         ,COMM_SLAN_CD                                            \n");
		query.append("         ,COMM_RLANE_CD                                           \n");
		query.append("         ,COMM_VSL_CD                                             \n");
		query.append("         ,COMM_SKD_VOY_NO                                         \n");
		query.append("         ,COMM_SKD_DIR_CD                                         \n");
		query.append("         ,COMM_REV_DIR_CD                                         \n");
		query.append("         ,BROG_REF_NO                                             \n");
		query.append("         ,CUST_HUS_BRO_NO                                         \n");
		query.append("         ,FRT_FWRD_CNT_CD                                         \n");
		query.append("         ,FRT_FWRD_SEQ                                            \n");
		query.append("         ,VNDR_CNT_CD                                             \n");
		query.append("         ,VNDR_SEQ                                                \n");
		query.append("         ,VSL_DEP_DT                                              \n");
		query.append("         ,BROG_DIV_CD                                             \n");
		query.append("         ,BROG_BKG_RT                                             \n");
		query.append("         ,BROG_CHG_CTNT                                           \n");
		query.append("         ,BROG_BX_RT                                              \n");
		query.append("         ,BKG_BX_QTY                                              \n");
		query.append("         ,BROG_TEU_RT                                             \n");
		query.append("         ,BKG_TEU_QTY                                             \n");
		query.append("         ,BROG_FEU_RT                                             \n");
		query.append("         ,BKG_FEU_QTY                                             \n");
		query.append("         ,BROG_RF_RT                                              \n");
		query.append("         ,BKG_RF_QTY                                              \n");
		query.append("         ,BROG_KND_CD                                             \n");
		query.append("         ,INTER_MDAL_FLG                                          \n");
		query.append("         ,ACT_IF_COMM_AMT ACT_PRE_COMM_AMT                        \n");
		query.append("         ,0 ACT_COMM_AMT                                          \n");
		query.append("         ,-ACT_IF_COMM_AMT ACT_IF_COMM_AMT                        \n");
		query.append("         ,BROG_IF_USR_ID                                          \n");
		query.append("         ,NULL BROG_IF_DT                                         \n");
		query.append("         ,'Y' ACCL_FLG                                           \n");
		query.append("         ,NULL CSR_NO                                             \n");
		query.append("         ,NULL GL_DT                                              \n");
		query.append("         ,AGMT_CNT_CD                                             \n");
		query.append("         ,AGMT_CUST_SEQ                                           \n");
		query.append("         ,AGMT_RT_SEQ                                             \n");
		query.append("         ,CRE_USR_ID                                              \n");
		query.append("         ,SYSDATE                                                 \n");
		query.append("         ,UPD_USR_ID                                              \n");
		query.append("         ,SYSDATE                                                 \n");
		query.append("     FROM AGT_BROG_COMM                                           \n");
		query.append("     WHERE 1=1                                                    \n");
		query.append("     AND BKG_NO = ?                                 				\n");
		query.append("     AND COMM_PROC_STS_CD = 'IF'                     				\n");
		query.append("     AND FRT_FWRD_CNT_CD||FRT_FWRD_SEQ <> ?||to_number(?)			\n");






		try
		{
			con = getConnection();
			
			ps = new LoggableStatement(con, query.toString());


			ps.setString(i++, (String)bkgMap.get("NEW_FF_BROG_SEQ"));
			ps.setString(i++, bkg_no);				//bkg_no
			ps.setString(i++, (String)bkgMap.get("FF_CNT_CD"));
			ps.setString(i++, (String)bkgMap.get("FF_CUST_SEQ"));
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();
			
			
		}
		catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(ps);
			closeConnection(con);
		}
	}
	
		
	/**
	 * Brokerage Charge Detail 삭제<br>
	 * 
	 * @param con Connection
	 * @param bkg_no String Booking No
	 * @param bkg_no_split String Booking No Split
	 * @param brog_seq int Brokerage seq
	 * @throws SQLException, Exception
	 */
	private void removeBrogChgDtl( Connection con, String bkg_no, int brog_seq ) throws SQLException, Exception {
		
		log.debug("\n\n removeBrogChgDtl 메소드 시작 ========================================\n");
		
		// Detail 삭제를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// 삭제쿼리
		StringBuffer query = new StringBuffer();
		
		query.append("DELETE FROM agt_brog_chg_dtl \n");
		query.append("WHERE bkg_no = ? \n");
		query.append("	AND brog_seq = ? \n");
		
		try {
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, query.toString());
			} else {
				ps = con.prepareStatement(query.toString());
			}
			
			ps.setString(i++, bkg_no);			//bkg_no
			ps.setInt(i++, brog_seq);			//brog_seq

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} finally {
			closeStatement(ps);
		}
	}
	
	/**
	 * Brokerage Commission Detail 삭제<br>
	 * 
	 * @param con Connection
	 * @param bkg_no String Booking No
	 * @param bkg_no_split String Booking No Split
	 * @param brog_seq int Brokerage seq
	 * @throws SQLException, Exception
	 */
	private void removeBrogCommDtl( Connection con, String bkg_no, int brog_seq ) throws SQLException, Exception {
		
		log.debug("\n\n removeBrogCommDtl 메소드 시작 ========================================\n");
		
		// Detail 삭제를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// 삭제쿼리
		StringBuffer query = new StringBuffer();
		
		query.append("DELETE FROM agt_brog_comm_dtl \n");
		query.append("WHERE bkg_no = ? \n");
		query.append("	AND brog_seq = ? \n");
		
		try {
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, query.toString());
			} else {
				ps = con.prepareStatement(query.toString());
			}
			
			ps.setString(i++, bkg_no);			//bkg_no
			ps.setInt(i++, brog_seq);			//brog_seq

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} finally {
			closeStatement(ps);
		}
	}
	
	/**
	 * Brokerage Commission 삭제<br>
	 * 
	 * @param con Connection
	 * @param bkg_no String Booking No
	 * @param bkg_no_split String Booking No Split
	 * @param brog_seq int Brokerage seq
	 * @throws SQLException, Exception
	 */
	private void removeBrogComm( Connection con, String bkg_no, int brog_seq ) throws SQLException, Exception {
		
		log.debug("\n\n removeBrogComm 메소드 시작 ========================================\n");
		
		// Detail 삭제를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		PreparedStatement ps01  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// 삭제쿼리
		StringBuffer query = new StringBuffer();
		StringBuffer query01 = new StringBuffer();
		
		query.append("DELETE FROM agt_brog_comm \n");
		query.append("WHERE bkg_no = ? \n");
		query.append("	AND brog_seq = ? \n");
		query.append("	AND comm_proc_sts_cd != 'IF' \n");
		
		query01.append("DELETE FROM agt_brog_comm_dtl  " + "\n");
		query01.append(" WHERE (bkg_no, brog_seq)  " + "\n");
		query01.append("   IN  (SELECT bkg_no, brog_seq   " + "\n");
		query01.append("        FROM agt_brog_comm WHERE bkg_no = ? AND brog_seq = ? AND comm_proc_sts_cd != 'IF')  " + "\n");
		
		try {
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps01 = new LoggableStatement(con, query01.toString());
			} else {
				ps01 = con.prepareStatement(query01.toString());
			}
			i = 1;
			ps01.setString(i++, bkg_no);			//bkg_no
			ps01.setInt(i++, brog_seq);				//brog_seq

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps01).getQueryString());
			ps01.executeUpdate();
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, query.toString());
			} else {
				ps = con.prepareStatement(query.toString());
			}
			i = 1;
			ps.setString(i++, bkg_no);			//bkg_no
			ps.setInt(i++, brog_seq);			//brog_seq

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} finally {
			closeStatement(ps);
			closeStatement(ps01);
		}
	}

	/**
	 * searchBookingInfoforComm(HashMap bkgMap)에서 Error 발생시 Booking Commission 테이블에 Error 정보를 저장한다.<br>
	 * BKG / RATE / LOCATION / ORGANIZATION의 정보 중 하나라도 조회되지 않는 것이 있는 경우
	 * CANCELED BKG인 경우
	 * VVD 정보가 없는 경우에 실행한다.
	 * 에러 메시지와 날짜 정보만 저장 한다.
	 * @param con Connection
	 * @param bkgMap HashMap Booking 정보를 담고있는 HashMap
	 * @throws SQLException, Exception
	 */
	private void createBKGMSTErrorMSG( Connection con, HashMap bkgMap) throws SQLException, Exception
	{
		
		String bkg_no = (String)bkgMap.get("BKG_NO");
		String comm_proc_rslt_rsn = (String)bkgMap.get("COMM_PROC_RSLT_RSN");
		
		// Error INSERT/UPDATE를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// 저장쿼리
		StringBuffer query = new StringBuffer();
		
		query.append("     MERGE \n");
		query.append("      INTO AGT_COMM_BKG_INFO INF \n");
		query.append("     USING \n");
		query.append("         ( \n");
		query.append("               SELECT \n");
		query.append("                      ?            AS BKG_NO, \n");
		query.append("                      ?            AS COMM_PROC_RSLT_RSN, \n");
		query.append("                      'AGT System' AS CRE_USR_ID, \n");
		query.append("                      SYSDATE      AS DT \n");
		query.append("                 FROM DUAL \n");
		query.append("          ) MSG \n");
		query.append("         ON \n");
		query.append("          ( \n");
		query.append("            INF.BKG_NO = MSG.BKG_NO \n");
		query.append("          ) \n");
		query.append("      WHEN MATCHED \n");
		query.append("      THEN \n");
		query.append("               UPDATE \n");
		query.append("                  SET INF.COMM_PROC_RSLT_RSN = MSG.COMM_PROC_RSLT_RSN, \n");
		query.append("                      INF.UPD_DT             = MSG.DT \n");
		query.append("      WHEN NOT MATCHED \n");
		query.append("      THEN \n");
		query.append("               INSERT \n");
		query.append("                    ( \n");
		query.append("                      INF.BKG_NO, \n");
		query.append("                      INF.COMM_PROC_RSLT_RSN, \n");
		query.append("                      INF.UPD_USR_ID, \n");
		query.append("                      INF.UPD_DT, \n");
		query.append("                      INF.CRE_USR_ID, \n");
		query.append("                      INF.CRE_DT \n");
		query.append("                    ) \n");
		query.append("	             VALUES \n");
		query.append("                    ( \n");
		query.append("                      MSG.BKG_NO, \n");
		query.append("                      MSG.COMM_PROC_RSLT_RSN, \n");
		query.append("                      MSG.CRE_USR_ID, \n");
		query.append("                      MSG.DT, \n");
		query.append("                      MSG.CRE_USR_ID, \n");
		query.append("                      MSG.DT \n");
		query.append("                    ) \n");
		
		try
		{
			ps = new LoggableStatement(con, query.toString());
			ps.setString(i++, bkg_no);				//bkg_no
			ps.setString(i++, comm_proc_rslt_rsn);	//comm_proc_rslt_rsn

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();
			
			// DB 로그 테이블에 저장한다.
//			this.createLog("===== ERROR AGT Actual - BKG_NO : "+ bkg_no +", BKG_NO_SPLIT : "+ bkg_no_split +", COMM_PROC_RSLT_RSN : "+ comm_proc_rslt_rsn);
			
		}
		catch (SQLException e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		}
		catch (Exception e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		}
		finally
		{
			closeStatement(ps);
		}
	}

	
	/**
	 * Error 발생시 Brokerage Commission 테이블에 Error 정보를 저장한다.<br>
	 * 
	 * @param con Connection
	 * @param bkgMap HashMap Booking 정보를 담고있는 HashMap
	 * @throws SQLException, Exception
	 */
	private void createZeroSumComm ( Connection con, HashMap bkgMap) throws SQLException, Exception
	{
		// Error INSERT/UPDATE를 수행하기 위한 SQL Statement
		PreparedStatement ps			= null;
		PreparedStatement deletePs01	= null;
		PreparedStatement deletePs02	= null;
		PreparedStatement deletePs03	= null;
		PreparedStatement deletePs04	= null;
		PreparedStatement deletePs05	= null;
		PreparedStatement deletePs06	= null;
		PreparedStatement deletePs07	= null;
		PreparedStatement insertPs01	= null;
		PreparedStatement insertPs02	= null;
//		PreparedStatement mergePs01		= null;
//		PreparedStatement mergePs02		= null;
		
		// DB ResultSet
		ResultSet rs = null;

		StringBuffer query				= new StringBuffer();
		StringBuffer deleteQuery01		= new StringBuffer();
		StringBuffer deleteQuery02		= new StringBuffer();
		StringBuffer deleteQuery03		= new StringBuffer();
		StringBuffer deleteQuery04		= new StringBuffer();
		StringBuffer deleteQuery05		= new StringBuffer();
		StringBuffer deleteQuery06		= new StringBuffer();
		StringBuffer deleteQuery07		= new StringBuffer();
		StringBuffer insertQuery01		= new StringBuffer();
		StringBuffer insertQuery02		= new StringBuffer();
//		StringBuffer mergeQuery01		= new StringBuffer();
//		StringBuffer mergeQuery02		= new StringBuffer();

		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		query.append("    SELECT \n");
		query.append("      CASE \n");
		query.append("      WHEN EXISTS \n");
		query.append("         ( \n");
		query.append("               SELECT \n");
		query.append("                      1 \n");
		query.append("                 FROM AGT_BROG_COMM BRG \n");
		query.append("                WHERE BRG.BKG_NO      = BKG.BKG_NO \n");
		query.append("                  AND COMM_PROC_STS_CD \n");
		query.append("                   IN \n");
		query.append("                    ( \n");
		query.append("                      'CS', 'CM', 'CE', 'CA', 'IC' \n");
		query.append("                    ) \n");
		query.append("         ) \n");
		query.append("      THEN 1 \n");
		query.append("      ELSE 0 \n");
		query.append("       END                                            AS BROG_STEP_ROW, \n");
		query.append("           NVL \n");
		query.append("         ( \n");
		query.append("         ( \n");
		query.append("               SELECT \n");
		query.append("                      SUM (BRG.ACT_IF_COMM_AMT) \n");
		query.append("                 FROM AGT_BROG_COMM BRG \n");
		query.append("                WHERE BRG.BKG_NO       = BKG.BKG_NO \n");
		query.append("                  AND COMM_PROC_STS_CD = 'IF' \n");
		query.append("         ) \n");
		query.append("         , 0 \n");
		query.append("         )                                            AS BROG_ZERO_SUM, \n");
		query.append("      CASE \n");
		query.append("      WHEN EXISTS \n");
		query.append("         ( \n");
		query.append("               SELECT \n");
		query.append("                      1 \n");
		query.append("                 FROM AGT_AGN_COMM AGN \n");
		query.append("                WHERE AGN.BKG_NO     = BKG.BKG_NO \n");
		query.append("                  AND COMM_PROC_STS_CD \n");
		query.append("                   IN \n");
		query.append("                    ( \n");
		query.append("                      'CS', 'CM', 'CE', 'CA', 'IC' \n");
		query.append("                    ) \n");
		query.append("         ) \n");
		query.append("      THEN 1 \n");
		query.append("      ELSE 0 \n");
		query.append("       END                                            AS AGN_STEP_ROW, \n");
		query.append("           NVL \n");
		query.append("         ( \n");
		query.append("         ( \n");
		query.append("               SELECT \n");
		query.append("                      SUM (AGN.ACT_IF_COMM_AMT) \n");
		query.append("                 FROM AGT_AGN_COMM AGN \n");
		query.append("                WHERE AGN.BKG_NO     = BKG.BKG_NO \n");
		query.append("                  AND AGN.COMM_PROC_STS_CD \n");
		query.append("                   IN \n");
		query.append("                    ( \n");
		query.append("                      'RS', 'RM', 'AS', 'IF' \n");
		query.append("                    ) \n");
		query.append("         ) \n");
		query.append("         , 0 \n");
		query.append("         )                                            AS AGN_ZERO_SUM \n");
		query.append("      FROM BKG_BOOKING BKG \n");
		query.append("     WHERE BKG.BKG_NO = ? --:BKG_NO \n");


		deleteQuery01.append("    DELETE \n");
		deleteQuery01.append("      FROM AGT_CHG_DDCT_REF \n");
		deleteQuery01.append("     WHERE \n");
		deleteQuery01.append("         ( \n");
		deleteQuery01.append("           BKG_NO, \n");
		deleteQuery01.append("           AGN_CD, \n");
		deleteQuery01.append("           AC_TP_CD, \n");
		deleteQuery01.append("           IO_BND_CD, \n");
		deleteQuery01.append("           AC_SEQ \n");
		deleteQuery01.append("         ) \n");
		deleteQuery01.append("        IN \n");
		deleteQuery01.append("         ( \n");
		deleteQuery01.append("               SELECT \n");
		deleteQuery01.append("                      BKG_NO, \n");
		deleteQuery01.append("                      AGN_CD, \n");
		deleteQuery01.append("                      AC_TP_CD, \n");
		deleteQuery01.append("                      IO_BND_CD, \n");
		deleteQuery01.append("                      AC_SEQ  \n");
		deleteQuery01.append("                 FROM AGT_AGN_COMM \n");
		deleteQuery01.append("                WHERE COMM_PROC_STS_CD \n");
		deleteQuery01.append("                   IN \n");
		deleteQuery01.append("                    ( \n");
		deleteQuery01.append("                      'CE', 'CS', 'CM', 'CA', 'IC' \n");
		deleteQuery01.append("                    ) \n");
		deleteQuery01.append("                  AND BKG_NO = ? --:BKG_NO\n");
		deleteQuery01.append("         ) \n");


		deleteQuery02.append("    DELETE \n");
		deleteQuery02.append("      FROM AGT_TRSP_DDCT_REF \n");
		deleteQuery02.append("     WHERE \n");
		deleteQuery02.append("         ( \n");
		deleteQuery02.append("           BKG_NO, \n");
		deleteQuery02.append("           AGN_CD, \n");
		deleteQuery02.append("           AC_TP_CD, \n");
		deleteQuery02.append("           IO_BND_CD, \n");
		deleteQuery02.append("           AC_SEQ \n");
		deleteQuery02.append("         ) \n");
		deleteQuery02.append("        IN \n");
		deleteQuery02.append("         ( \n");
		deleteQuery02.append("               SELECT \n");
		deleteQuery02.append("                      BKG_NO, \n");
		deleteQuery02.append("                      AGN_CD, \n");
		deleteQuery02.append("                      AC_TP_CD, \n");
		deleteQuery02.append("                      IO_BND_CD, \n");
		deleteQuery02.append("                      AC_SEQ  \n");
		deleteQuery02.append("                 FROM AGT_AGN_COMM \n");
		deleteQuery02.append("                WHERE COMM_PROC_STS_CD \n");
		deleteQuery02.append("                   IN \n");
		deleteQuery02.append("                    ( \n");
		deleteQuery02.append("                      'CE', 'CS', 'CM', 'CA', 'IC' \n");
		deleteQuery02.append("                    ) \n");
		deleteQuery02.append("                  AND BKG_NO = ? \n");
		deleteQuery02.append("         ) \n");


		deleteQuery03.append("    DELETE \n");
		deleteQuery03.append("      FROM AGT_AGN_COMM_DTL \n");
		deleteQuery03.append("     WHERE \n");
		deleteQuery03.append("         ( \n");
		deleteQuery03.append("           BKG_NO, \n");
		deleteQuery03.append("           AGN_CD, \n");
		deleteQuery03.append("           AC_TP_CD, \n");
		deleteQuery03.append("           IO_BND_CD, \n");
		deleteQuery03.append("           AC_SEQ \n");
		deleteQuery03.append("         ) \n");
		deleteQuery03.append("        IN \n");
		deleteQuery03.append("         ( \n");
		deleteQuery03.append("               SELECT \n");
		deleteQuery03.append("                      BKG_NO, \n");
		deleteQuery03.append("                      AGN_CD, \n");
		deleteQuery03.append("                      AC_TP_CD, \n");
		deleteQuery03.append("                      IO_BND_CD, \n");
		deleteQuery03.append("                      AC_SEQ  \n");
		deleteQuery03.append("                 FROM AGT_AGN_COMM \n");
		deleteQuery03.append("                WHERE COMM_PROC_STS_CD \n");
		deleteQuery03.append("                   IN \n");
		deleteQuery03.append("                    ( \n");
		deleteQuery03.append("                      'CE', 'CS', 'CM', 'CA', 'IC' \n");
		deleteQuery03.append("                    ) \n");
		deleteQuery03.append("                  AND BKG_NO = ? \n");
		deleteQuery03.append("         ) \n");


		deleteQuery04.append("    DELETE \n");
		deleteQuery04.append("      FROM AGT_AGN_COMM \n");
		deleteQuery04.append("     WHERE COMM_PROC_STS_CD \n");
		deleteQuery04.append("        IN \n");
		deleteQuery04.append("         ( \n");
		deleteQuery04.append("           'CE', 'CS', 'CM', 'CA', 'IC' \n");
		deleteQuery04.append("         ) \n");
		deleteQuery04.append("       AND BKG_NO = ? \n");


		deleteQuery05.append("    DELETE \n");
		deleteQuery05.append("      FROM AGT_BROG_CHG_DTL \n");
		deleteQuery05.append("     WHERE \n");
		deleteQuery05.append("         ( \n");
		deleteQuery05.append("           BKG_NO, \n");
		deleteQuery05.append("           BROG_SEQ \n");
		deleteQuery05.append("         ) \n");
		deleteQuery05.append("        IN \n");
		deleteQuery05.append("         ( \n");
		deleteQuery05.append("               SELECT \n");
		deleteQuery05.append("                      BKG_NO, \n");
		deleteQuery05.append("                      BROG_SEQ \n");
		deleteQuery05.append("                 FROM AGT_BROG_COMM \n");
		deleteQuery05.append("                WHERE COMM_PROC_STS_CD \n");
		deleteQuery05.append("                   IN \n");
		deleteQuery05.append("                    ( \n");
		deleteQuery05.append("                      'CE', 'CS', 'CM', 'CA', 'IC' \n");
		deleteQuery05.append("                    ) \n");
		deleteQuery05.append("                  AND BKG_NO = ? \n");
		deleteQuery05.append("         ) \n");


		deleteQuery06.append("    DELETE \n");
		deleteQuery06.append("      FROM AGT_BROG_COMM_DTL \n");
		deleteQuery06.append("     WHERE \n");
		deleteQuery06.append("         ( \n");
		deleteQuery06.append("           BKG_NO, \n");
		deleteQuery06.append("           BROG_SEQ \n");
		deleteQuery06.append("         ) \n");
		deleteQuery06.append("        IN \n");
		deleteQuery06.append("         ( \n");
		deleteQuery06.append("               SELECT \n");
		deleteQuery06.append("                      BKG_NO, \n");
		deleteQuery06.append("                      BROG_SEQ \n");
		deleteQuery06.append("                 FROM AGT_BROG_COMM \n");
		deleteQuery06.append("                WHERE COMM_PROC_STS_CD \n");
		deleteQuery06.append("                   IN \n");
		deleteQuery06.append("                    ( \n");
		deleteQuery06.append("                      'CE', 'CS', 'CM', 'CA', 'IC' \n");
		deleteQuery06.append("                    ) \n");
		deleteQuery06.append("                  AND BKG_NO = ? \n");
		deleteQuery06.append("         ) \n");


		deleteQuery07.append("    DELETE \n");
		deleteQuery07.append("      FROM AGT_BROG_COMM \n");
		deleteQuery07.append("     WHERE COMM_PROC_STS_CD \n");
		deleteQuery07.append("        IN \n");
		deleteQuery07.append("         ( \n");
		deleteQuery07.append("           'CE', 'CS', 'CM', 'CA', 'IC' \n");
		deleteQuery07.append("         ) \n");
		deleteQuery07.append("       AND BKG_NO = ? \n");


		insertQuery01.append("    INSERT \n");
		insertQuery01.append("      INTO AGT_AGN_COMM \n");
		insertQuery01.append("         ( \n");
		insertQuery01.append("           BKG_NO, \n");
		insertQuery01.append("           AGN_CD, \n");
		insertQuery01.append("           IO_BND_CD, \n");
		insertQuery01.append("           AC_TP_CD, \n");
		insertQuery01.append("           AC_SEQ, \n");
		insertQuery01.append("           AR_OFC_CD, \n");
		insertQuery01.append("           AP_OFC_CD, \n");
		insertQuery01.append("           AP_CTR_CD, \n");
		insertQuery01.append("           COMM_OCCR_INFO_CD, \n");
		insertQuery01.append("           COMM_STND_COST_CD, \n");
		insertQuery01.append("           OFC_CHR_LVL, \n");
		insertQuery01.append("           COMM_SLAN_CD, \n");
		insertQuery01.append("           COMM_RLANE_CD, \n");
		insertQuery01.append("           COMM_VSL_CD, \n");
		insertQuery01.append("           COMM_SKD_VOY_NO, \n");
		insertQuery01.append("           COMM_SKD_DIR_CD, \n");
		insertQuery01.append("           COMM_REV_DIR_CD, \n");
		insertQuery01.append("           COMM_PROC_STS_CD, \n");
		insertQuery01.append("           COMM_PROC_STS_RSN, \n");
		insertQuery01.append("           COMM_APRO_NO, \n");
		insertQuery01.append("           VNDR_CNT_CD, \n");
		insertQuery01.append("           VNDR_SEQ, \n");
		insertQuery01.append("           SAIL_ARR_DT, \n");
		insertQuery01.append("           CHG_DDCT_AMT, \n");
		insertQuery01.append("           FDRG_DDCT_AMT, \n");
		insertQuery01.append("           HLG_DDCT_AMT, \n");
		insertQuery01.append("           AGN_AGMT_RT, \n");
		insertQuery01.append("           ACT_PRE_COMM_AMT, \n");
		insertQuery01.append("           ACT_COMM_AMT, \n");
		insertQuery01.append("           ACT_IF_COMM_AMT, \n");
		insertQuery01.append("           ACT_PRE_LOCL_COMM_AMT, \n");
		insertQuery01.append("           ACT_LOCL_COMM_AMT, \n");
		insertQuery01.append("           ACT_IF_LOCL_COMM_AMT, \n");
		insertQuery01.append("           CURR_CD, \n");
		insertQuery01.append("           XCH_RT_APLY_LVL, \n");
		insertQuery01.append("           VVD_XCH_RT, \n");
		insertQuery01.append("           MON_XCH_RT, \n");
		insertQuery01.append("           DLY_XCH_RT, \n");
		insertQuery01.append("           OFFST_AGN_FLG, \n");
		insertQuery01.append("           ACCL_FLG, \n");
		insertQuery01.append("           CRE_USR_ID, \n");
		insertQuery01.append("           CRE_DT, \n");
		insertQuery01.append("           UPD_USR_ID, \n");
		insertQuery01.append("           UPD_DT \n");
		insertQuery01.append("         ) \n");
		insertQuery01.append("    SELECT \n");
		insertQuery01.append("           AGN.BKG_NO, \n");
		insertQuery01.append("           AGN.AGN_CD, \n");
		insertQuery01.append("           AGN.IO_BND_CD, \n");
		insertQuery01.append("           AGN.AC_TP_CD, \n");
		insertQuery01.append("           CCD.NEXT_AC_SEQ, \n");
		insertQuery01.append("           AGN.AR_OFC_CD, \n");
		insertQuery01.append("           AGN.AP_OFC_CD, \n");
		insertQuery01.append("           AGN.AP_CTR_CD, \n");
		insertQuery01.append("           AGN.COMM_OCCR_INFO_CD, \n");
		insertQuery01.append("           AGN.COMM_STND_COST_CD, \n");
		insertQuery01.append("           AGN.OFC_CHR_LVL, \n");
		insertQuery01.append("           AGN.COMM_SLAN_CD, \n");
		insertQuery01.append("           AGN.COMM_RLANE_CD, \n");
		insertQuery01.append("           AGN.COMM_VSL_CD, \n");
		insertQuery01.append("           AGN.COMM_SKD_VOY_NO, \n");
		insertQuery01.append("           AGN.COMM_SKD_DIR_CD, \n");
		insertQuery01.append("           AGN.COMM_REV_DIR_CD, \n");
		insertQuery01.append("           'CS'                     AS COMM_PROC_STS_CD, \n");
		insertQuery01.append("         ( \n");
		insertQuery01.append("               SELECT \n");
		insertQuery01.append("                 CASE NVL (BLD.BL_CVRD_TP_CD, 'N') \n");
		insertQuery01.append("                 WHEN 'B' \n");
		insertQuery01.append("                 THEN 'Co-Biz B/L! Interfaced commission amount will be duddcted.' \n");
		insertQuery01.append("                 WHEN 'C' \n");
		insertQuery01.append("                 THEN 'Covered B/L! Interfaced commission amount will be duddcted.' \n");
		insertQuery01.append("                 ELSE 'Cancelled Booking, C/Aed Booking Info! or Changed Agent Agreements!' \n");
		insertQuery01.append("                  END \n");
		insertQuery01.append("                 FROM BKG_BL_DOC BLD \n");
		insertQuery01.append("                WHERE BLD.BKG_NO = AGN.BKG_NO \n");
		insertQuery01.append("         )                          AS COMM_PROC_STS_RSN, \n");
		insertQuery01.append("           ''                       AS COMM_APRO_NO, \n");
		insertQuery01.append("           AGN.VNDR_CNT_CD, \n");
		insertQuery01.append("           AGN.VNDR_SEQ, \n");
		insertQuery01.append("           AGN.SAIL_ARR_DT, \n");
		insertQuery01.append("           AGN.CHG_DDCT_AMT, \n");
		insertQuery01.append("           AGN.FDRG_DDCT_AMT, \n");
		insertQuery01.append("           AGN.HLG_DDCT_AMT, \n");
		insertQuery01.append("           AGN.AGN_AGMT_RT, \n");
		insertQuery01.append("           CCD.CANCEL_AMT           AS ACT_PRE_COMM_AMT, \n");
		insertQuery01.append("           0                        AS ACT_COMM_AMT, \n");
		insertQuery01.append("           0 - CCD.CANCEL_AMT       AS ACT_IF_COMM_AMT, \n");
		insertQuery01.append("           CCD.CANCEL_LOCAL_AMT     AS ACT_PRE_LOCL_COMM_AMT, \n");
		insertQuery01.append("           0                        AS ACT_LOCL_COMM_AMT, \n");
		insertQuery01.append("           0 - CCD.CANCEL_LOCAL_AMT AS ACT_IF_LOCL_COMM_AMT, \n");
		insertQuery01.append("           AGN.CURR_CD, \n");
		insertQuery01.append("           AGN.XCH_RT_APLY_LVL, \n");
		insertQuery01.append("           AGN.VVD_XCH_RT, \n");
		insertQuery01.append("           AGN.MON_XCH_RT, \n");
		insertQuery01.append("           AGN.DLY_XCH_RT, \n");
		insertQuery01.append("           AGN.OFFST_AGN_FLG, \n");
		insertQuery01.append("           AGN.ACCL_FLG, \n");
		insertQuery01.append("           'COMMISSION'             AS CRE_USR_ID, \n");
		insertQuery01.append("           SYSDATE                  AS CRE_DT, \n");
		insertQuery01.append("           'COMMISSION'             AS UPD_USR_ID, \n");
		insertQuery01.append("           SYSDATE                  AS UPD_DT \n");
		insertQuery01.append("     FROM AGT_AGN_COMM AGN, \n");
		insertQuery01.append("        ( \n");
		insertQuery01.append("              SELECT \n");
		insertQuery01.append("                     AGN.BKG_NO, \n");
		insertQuery01.append("                     AGN.AGN_CD, \n");
		insertQuery01.append("                     AGN.IO_BND_CD, \n");
		insertQuery01.append("                     AGN.AC_TP_CD, \n");
		insertQuery01.append("                     SUM (AGN.ACT_IF_COMM_AMT)      AS CANCEL_AMT, \n");
		insertQuery01.append("                     SUM (AGN.ACT_IF_LOCL_COMM_AMT) AS CANCEL_LOCAL_AMT, \n");
		insertQuery01.append("                     NVL (MAX (AGN.AC_SEQ), 0) + 1  AS NEXT_AC_SEQ \n");
		insertQuery01.append("                FROM AGT_AGN_COMM AGN \n");
		insertQuery01.append("               WHERE BKG_NO         = ? --:BKG_NO \n");
		insertQuery01.append("                 AND COMM_PROC_STS_CD \n");
		insertQuery01.append("                  IN \n");
		insertQuery01.append("                   ( \n");
		insertQuery01.append("                     'RS', 'RM', 'AS', 'IF' \n");
		insertQuery01.append("                   ) \n");
		insertQuery01.append("            GROUP BY AGN.BKG_NO, \n");
		insertQuery01.append("                     AGN.AGN_CD, \n");
		insertQuery01.append("                     AGN.IO_BND_CD, \n");
		insertQuery01.append("                     AGN.AC_TP_CD \n");
		insertQuery01.append("              HAVING 0 <> SUM (AGN.ACT_IF_COMM_AMT) \n");
		insertQuery01.append("        ) CCD \n");
		insertQuery01.append("    WHERE AGN.BKG_NO    = CCD.BKG_NO \n");
		insertQuery01.append("      AND AGN.AGN_CD    = CCD.AGN_CD \n");
		insertQuery01.append("      AND AGN.IO_BND_CD = CCD.IO_BND_CD \n");
		insertQuery01.append("      AND AGN.AC_TP_CD  = CCD.AC_TP_CD \n");
		insertQuery01.append("      AND AGN.AC_SEQ    = CCD.NEXT_AC_SEQ - 1 \n");
		insertQuery01.append("      AND AGN.COMM_PROC_STS_CD \n");
		insertQuery01.append("       IN \n");
		insertQuery01.append("        ( \n");
		insertQuery01.append("          'RS', 'RM', 'AS', 'IF' \n");
		insertQuery01.append("        ) \n");
		
		
		insertQuery02.append("    INSERT \n");
		insertQuery02.append("      INTO AGT_BROG_COMM \n");
		insertQuery02.append("         ( BKG_NO, \n");
		insertQuery02.append("           BROG_SEQ, \n");
		insertQuery02.append("           COMM_OCCR_INFO_CD, \n");
		insertQuery02.append("           AR_OFC_CD, \n");
		insertQuery02.append("           AP_OFC_CD, \n");
		insertQuery02.append("           COMM_STND_COST_CD, \n");
		insertQuery02.append("           COMM_PROC_STS_CD, \n");
		insertQuery02.append("           COMM_PROC_RSLT_RSN, \n");
		insertQuery02.append("           COMM_SLAN_CD, \n");
		insertQuery02.append("           COMM_RLANE_CD, \n");
		insertQuery02.append("           COMM_VSL_CD, \n");
		insertQuery02.append("           COMM_SKD_VOY_NO, \n");
		insertQuery02.append("           COMM_SKD_DIR_CD, \n");
		insertQuery02.append("           COMM_REV_DIR_CD, \n");
		insertQuery02.append("           BROG_REF_NO, \n");
		insertQuery02.append("           CUST_HUS_BRO_NO, \n");
		insertQuery02.append("           FRT_FWRD_CNT_CD, \n");
		insertQuery02.append("           FRT_FWRD_SEQ, \n");
		insertQuery02.append("           VNDR_CNT_CD, \n");
		insertQuery02.append("           VNDR_SEQ, \n");
		insertQuery02.append("           VSL_DEP_DT, \n");
		insertQuery02.append("           BROG_DIV_CD, \n");
		insertQuery02.append("           BROG_BKG_RT, \n");
		insertQuery02.append("           BROG_CHG_CTNT, \n");
		insertQuery02.append("           BROG_BX_RT, \n");
		insertQuery02.append("           BKG_BX_QTY, \n");
		insertQuery02.append("           BROG_TEU_RT, \n");
		insertQuery02.append("           BKG_TEU_QTY, \n");
		insertQuery02.append("           BROG_FEU_RT, \n");
		insertQuery02.append("           BKG_FEU_QTY, \n");
		insertQuery02.append("           BROG_RF_RT, \n");
		insertQuery02.append("           BKG_RF_QTY, \n");
		insertQuery02.append("           BROG_KND_CD, \n");
		insertQuery02.append("           INTER_MDAL_FLG, \n");
		insertQuery02.append("           ACT_PRE_COMM_AMT, \n");
		insertQuery02.append("           ACT_COMM_AMT, \n");
		insertQuery02.append("           ACT_IF_COMM_AMT, \n");
		insertQuery02.append("           ACCL_FLG, \n");
		insertQuery02.append("           AGMT_CNT_CD, \n");
		insertQuery02.append("           AGMT_CUST_SEQ, \n");
		insertQuery02.append("           AGMT_RT_SEQ, \n");
		insertQuery02.append("           UPD_USR_ID, \n");
		insertQuery02.append("           UPD_DT, \n");
		insertQuery02.append("           CRE_USR_ID, \n");
		insertQuery02.append("           CRE_DT \n");
		insertQuery02.append("         ) \n");
		insertQuery02.append("    SELECT \n");
		insertQuery02.append("           BRO.BKG_NO, \n");
		insertQuery02.append("           BRO.BROG_SEQ + 1               AS BROG_SEQ, \n");
		insertQuery02.append("           BRO.COMM_OCCR_INFO_CD, \n");
		insertQuery02.append("           BRO.AR_OFC_CD, \n");
		insertQuery02.append("           BRO.AP_OFC_CD, \n");
		insertQuery02.append("           BRO.COMM_STND_COST_CD, \n");
		insertQuery02.append("           'CS'                           AS COMM_PROC_STS_CD, \n");
		insertQuery02.append("         ( \n");
		insertQuery02.append("               SELECT \n");
		insertQuery02.append("                 CASE NVL (BLD.BL_CVRD_TP_CD, 'N') \n");
		insertQuery02.append("                 WHEN 'B' \n");
		insertQuery02.append("                 THEN 'Co-Biz B/L! Interfaced commission amount will be duddcted.' \n");
		insertQuery02.append("                 WHEN 'C' \n");
		insertQuery02.append("                 THEN 'Covered B/L! Interfaced commission amount will be duddcted.' \n");
		insertQuery02.append("                 ELSE 'Cancelled Booking, C/Aed Booking Info! or Changed Agent Agreements!' \n");
		insertQuery02.append("                  END \n");
		insertQuery02.append("                 FROM BKG_BL_DOC BLD \n");
		insertQuery02.append("                WHERE BLD.BKG_NO = BRO.BKG_NO \n");
		insertQuery02.append("         )                                AS COMM_PROC_STS_RSN, \n");
		insertQuery02.append("           BRO.COMM_SLAN_CD, \n");
		insertQuery02.append("           BRO.COMM_RLANE_CD, \n");
		insertQuery02.append("           BRO.COMM_VSL_CD, \n");
		insertQuery02.append("           BRO.COMM_SKD_VOY_NO, \n");
		insertQuery02.append("           BRO.COMM_SKD_DIR_CD, \n");
		insertQuery02.append("           BRO.COMM_REV_DIR_CD, \n");
		insertQuery02.append("           BRO.BROG_REF_NO, \n");
		insertQuery02.append("           BRO.CUST_HUS_BRO_NO, \n");
		insertQuery02.append("           BRO.FRT_FWRD_CNT_CD, \n");
		insertQuery02.append("           BRO.FRT_FWRD_SEQ, \n");
		insertQuery02.append("           BRO.VNDR_CNT_CD, \n");
		insertQuery02.append("           BRO.VNDR_SEQ, \n");
		insertQuery02.append("           BRO.VSL_DEP_DT, \n");
		insertQuery02.append("           BRO.BROG_DIV_CD, \n");
		insertQuery02.append("           BRO.BROG_BKG_RT, \n");
		insertQuery02.append("           BRO.BROG_CHG_CTNT, \n");
		insertQuery02.append("           BRO.BROG_BX_RT, \n");
		insertQuery02.append("           BRO.BKG_BX_QTY, \n");
		insertQuery02.append("           BRO.BROG_TEU_RT, \n");
		insertQuery02.append("           BRO.BKG_TEU_QTY, \n");
		insertQuery02.append("           BRO.BROG_FEU_RT, \n");
		insertQuery02.append("           BRO.BKG_FEU_QTY, \n");
		insertQuery02.append("           BRO.BROG_RF_RT, \n");
		insertQuery02.append("           BRO.BKG_RF_QTY, \n");
		insertQuery02.append("           BRO.BROG_KND_CD, \n");
		insertQuery02.append("           BRO.INTER_MDAL_FLG, \n");
		insertQuery02.append("           CCD.CANCELED_AMT               AS ACT_PRE_COMM_AMT, \n");
		insertQuery02.append("           0                              AS ACT_COMM_AMT, \n");
		insertQuery02.append("           0 - CCD.CANCELED_AMT           AS ACT_IF_COMM_AMT, \n");
		insertQuery02.append("           BRO.ACCL_FLG, \n");
		insertQuery02.append("           BRO.AGMT_CNT_CD, \n");
		insertQuery02.append("           BRO.AGMT_CUST_SEQ, \n");
		insertQuery02.append("           BRO.AGMT_RT_SEQ, \n");
		insertQuery02.append("           'COMMISSION'                   AS UPD_USR_ID, \n");
		insertQuery02.append("           SYSDATE                        AS UPD_DT, \n");
		insertQuery02.append("           'COMMISSION'                   AS CRE_USR_ID, \n");
		insertQuery02.append("           SYSDATE                        AS CRE_DT \n");
		insertQuery02.append("      FROM AGT_BROG_COMM BRO, \n");
		insertQuery02.append("         ( \n");
		insertQuery02.append("               SELECT \n");
		insertQuery02.append("                      MAX (BR2.BKG_NO)                             AS BKG_NO, \n");
		insertQuery02.append("                      MAX (BR2.BROG_SEQ)                           AS BROG_SEQ, \n");
		insertQuery02.append("                      ROUND (NVL (SUM (BR2.ACT_IF_COMM_AMT),0), 2) AS CANCELED_AMT \n");
		insertQuery02.append("                 FROM AGT_BROG_COMM BR2 \n");
		insertQuery02.append("                WHERE BR2.BKG_NO           = ? \n");
		insertQuery02.append("                  AND BR2.COMM_PROC_STS_CD = 'IF' \n");
		insertQuery02.append("             GROUP BY BKG_NO \n");
		insertQuery02.append("               HAVING 0 < ROUND (NVL (SUM (BR2.ACT_IF_COMM_AMT),0), 2) \n");
		insertQuery02.append("         ) CCD \n");
		insertQuery02.append("     WHERE BRO.BKG_NO           = CCD.BKG_NO \n");
		insertQuery02.append("       AND BRO.BROG_SEQ         = CCD.BROG_SEQ \n");
		insertQuery02.append("       AND BRO.COMM_PROC_STS_CD = 'IF' \n");

//      CLT-111121272 소스품질 결함건 수정 반영
//		mergeQuery01.append("     MERGE \n");
//		mergeQuery01.append("      INTO AGT_AGN_COMM_DTL TBL \n");
//		mergeQuery01.append("     USING \n");
//		mergeQuery01.append("         ( \n");
//		mergeQuery01.append("               SELECT \n");
//		mergeQuery01.append("                 CASE \n");
//		mergeQuery01.append("                 WHEN TOB.BKG_NO IS NULL \n");
//		mergeQuery01.append("                 THEN AIS.BKG_NO \n");
//		mergeQuery01.append("                 ELSE TOB.BKG_NO \n");
//		mergeQuery01.append("                  END                                                            AS BKG_NO, \n");
//		mergeQuery01.append("                 CASE \n");
//		mergeQuery01.append("                 WHEN TOB.AGN_CD IS NULL \n");
//		mergeQuery01.append("                 THEN AIS.AGN_CD \n");
//		mergeQuery01.append("                 ELSE TOB.AGN_CD \n");
//		mergeQuery01.append("                  END                                                            AS AGN_CD, \n");
//		mergeQuery01.append("                 CASE \n");
//		mergeQuery01.append("                 WHEN TOB.IO_BND_CD IS NULL \n");
//		mergeQuery01.append("                 THEN AIS.IO_BND_CD \n");
//		mergeQuery01.append("                 ELSE TOB.IO_BND_CD \n");
//		mergeQuery01.append("                  END                                                            AS IO_BND_CD, \n");
//		mergeQuery01.append("                 CASE \n");
//		mergeQuery01.append("                 WHEN TOB.AC_TP_CD IS NULL \n");
//		mergeQuery01.append("                 THEN AIS.AC_TP_CD \n");
//		mergeQuery01.append("                 ELSE TOB.AC_TP_CD \n");
//		mergeQuery01.append("                  END                                                            AS AC_TP_CD, \n");
//		mergeQuery01.append("                 CASE \n");
//		mergeQuery01.append("                 WHEN TOB.CNTR_TPSZ_CD IS NULL \n");
//		mergeQuery01.append("                 THEN AIS.CNTR_TPSZ_CD \n");
//		mergeQuery01.append("                 ELSE TOB.CNTR_TPSZ_CD \n");
//		mergeQuery01.append("                  END                                                            AS CNTR_TPSZ_CD, \n");
//		mergeQuery01.append("                 CASE \n");
//		mergeQuery01.append("                 WHEN TOB.AC_SEQ IS NULL \n");
//		mergeQuery01.append("                 THEN AIS.AC_SEQ \n");
//		mergeQuery01.append("                 ELSE TOB.AC_SEQ \n");
//		mergeQuery01.append("                  END                                                            AS AC_SEQ, \n");
//		mergeQuery01.append("                      TOB.BKG_VOL_QTY                                            AS BKG_VOL_QTY, \n");
//		mergeQuery01.append("                      TOB.LOCL_CURR_CD                                           AS LOCL_CURR_CD, \n");
//		mergeQuery01.append("                CASE \n");
//		mergeQuery01.append("                WHEN TOB.QTY_RATIO = 1 \n");
//		mergeQuery01.append("                THEN TOB.ACT_USD_COMM_AMT \n");
//		mergeQuery01.append("                WHEN TOB.RNUM = TOB.MNUM \n");
//		mergeQuery01.append("                THEN TOB.ACT_USD_COMM_AMT \n");
//		mergeQuery01.append("                   + ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
//		mergeQuery01.append("                   - SUM (ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2)) \n");
//		mergeQuery01.append("                     OVER \n");
//		mergeQuery01.append("                   ( \n");
//		mergeQuery01.append("           PARTITION \n");
//		mergeQuery01.append("                  BY TOB.BKG_NO, \n");
//		mergeQuery01.append("                     TOB.AGN_CD, \n");
//		mergeQuery01.append("                     TOB.IO_BND_CD, \n");
//		mergeQuery01.append("                     TOB.AC_TP_CD \n");
//		mergeQuery01.append("            ORDER BY TOB.CNTR_TPSZ_CD DESC \n");
//		mergeQuery01.append("                   ) \n");
//		mergeQuery01.append("                ELSE ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
//		mergeQuery01.append("                 END                                                             AS ACT_USD_COMM_AMT, \n");
//		mergeQuery01.append("                CASE \n");
//		mergeQuery01.append("                WHEN TOB.RNUM = TOB.MNUM \n");
//		mergeQuery01.append("                THEN TOB.ACT_LOCL_COMM_AMT \n");
//		mergeQuery01.append("                   + ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2) \n");
//		mergeQuery01.append("                   - SUM (ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2)) \n");
//		mergeQuery01.append("                     OVER \n");
//		mergeQuery01.append("                   ( \n");
//		mergeQuery01.append("           PARTITION \n");
//		mergeQuery01.append("                  BY TOB.BKG_NO, \n");
//		mergeQuery01.append("                     TOB.AGN_CD, \n");
//		mergeQuery01.append("                     TOB.IO_BND_CD, \n");
//		mergeQuery01.append("                     TOB.AC_TP_CD \n");
//		mergeQuery01.append("            ORDER BY TOB.CNTR_TPSZ_CD DESC \n");
//		mergeQuery01.append("                   ) \n");
//		mergeQuery01.append("                ELSE ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2) \n");
//		mergeQuery01.append("                 END                                                             AS ACT_LOCL_COMM_AMT, \n");
//		mergeQuery01.append("                     'COMMISSION'                                                AS UPD_USR_ID, \n");
//		mergeQuery01.append("                     SYSDATE                                                     AS UPD_DT, \n");
//		mergeQuery01.append("                     'COMMISSION'                                                AS CRE_USR_ID, \n");
//		mergeQuery01.append("                     SYSDATE                                                     AS CRE_DT \n");
//		mergeQuery01.append("                FROM \n");
//		mergeQuery01.append("                   ( \n");
//		mergeQuery01.append("                         SELECT \n");
//		mergeQuery01.append("                                AGD.BKG_NO, \n");
//		mergeQuery01.append("                                AGD.AGN_CD, \n");
//		mergeQuery01.append("                                AGD.IO_BND_CD, \n");
//		mergeQuery01.append("                                AGD.AC_TP_CD, \n");
//		mergeQuery01.append("                                AGD.AC_SEQ, \n");
//		mergeQuery01.append("                                AGD.CNTR_TPSZ_CD, \n");
//		mergeQuery01.append("                                AGD.BKG_VOL_QTY, \n");
//		mergeQuery01.append("                                AGD.LOCL_CURR_CD, \n");
//		mergeQuery01.append("                                AGD.ACT_USD_COMM_AMT, \n");
//		mergeQuery01.append("                                AGD.ACT_LOCL_COMM_AMT, \n");
//		mergeQuery01.append("                                AGD.UPD_USR_ID, \n");
//		mergeQuery01.append("                                AGD.UPD_DT, \n");
//		mergeQuery01.append("                                AGD.CRE_USR_ID, \n");
//		mergeQuery01.append("                                AGD.CRE_DT \n");
//		mergeQuery01.append("                           FROM AGT_AGN_COMM_DTL AGD, \n");
//		mergeQuery01.append("                              ( \n");
//		mergeQuery01.append("                                    SELECT \n");
//		mergeQuery01.append("                                           AGN.BKG_NO, \n");
//		mergeQuery01.append("                                           AGN.AGN_CD, \n");
//		mergeQuery01.append("                                           AGN.IO_BND_CD, \n");
//		mergeQuery01.append("                                           AGN.AC_TP_CD, \n");
//		mergeQuery01.append("                                           MAX (AGN.AC_SEQ)      AS AC_SEQ \n");
//		mergeQuery01.append("                                      FROM AGT_AGN_COMM AGN \n");
//		mergeQuery01.append("                                     WHERE BKG_NO         = ? --:BKG_NO \n");
//		mergeQuery01.append("                                       AND COMM_PROC_STS_CD \n");
//		mergeQuery01.append("                                        IN \n");
//		mergeQuery01.append("                                         ( \n");
//		mergeQuery01.append("                                           'RS', 'RM', 'AS', 'IF', 'CS' \n");
//		mergeQuery01.append("                                         ) \n");
//		mergeQuery01.append("                                  GROUP BY AGN.BKG_NO, \n");
//		mergeQuery01.append("                                           AGN.AGN_CD, \n");
//		mergeQuery01.append("                                           AGN.IO_BND_CD, \n");
//		mergeQuery01.append("                                           AGN.AC_TP_CD \n");
//		mergeQuery01.append("                                    HAVING EXISTS \n");
//		mergeQuery01.append("                                         ( \n");
//		mergeQuery01.append("                                               SELECT \n");
//		mergeQuery01.append("                                                      1 \n");
//		mergeQuery01.append("                                                 FROM AGT_AGN_COMM AG2 \n");
//		mergeQuery01.append("                                                WHERE AG2.BKG_NO           = AGN.BKG_NO \n");
//		mergeQuery01.append("                                                  AND AG2.AGN_CD           = AGN.AGN_CD \n");
//		mergeQuery01.append("                                                  AND AG2.IO_BND_CD        = AGN.IO_BND_CD \n");
//		mergeQuery01.append("                                                  AND AG2.AC_TP_CD         = AGN.AC_TP_CD \n");
//		mergeQuery01.append("                                                  --AND AG2.COMM_PROC_STS_CD = 'CS' \n");
//		mergeQuery01.append("                                                  AND AG2.AC_SEQ           = MAX (AGN.AC_SEQ) \n");
//		mergeQuery01.append("                                         ) \n");
//		mergeQuery01.append("                              ) AGN \n");
//		mergeQuery01.append("                          WHERE AGD.BKG_NO    = AGN.BKG_NO \n");
//		mergeQuery01.append("                            AND AGD.AGN_CD    = AGN.AGN_CD \n");
//		mergeQuery01.append("                            AND AGD.IO_BND_CD = AGN.IO_BND_CD \n");
//		mergeQuery01.append("                            AND AGD.AC_TP_CD  = AGN.AC_TP_CD \n");
//		mergeQuery01.append("                            AND AGD.AC_SEQ    = AGN.AC_SEQ \n");
//		mergeQuery01.append("                   ) AIS \n");
//		mergeQuery01.append("          FULL OUTER \n");
//		mergeQuery01.append("                JOIN \n");
//		mergeQuery01.append("                   ( \n");
//		mergeQuery01.append("                         SELECT \n");
//		mergeQuery01.append("                                RANK() OVER(ORDER BY QTY.CNTR_TPSZ_CD DESC) AS RNUM, \n");
//		mergeQuery01.append("                              ( \n");
//		mergeQuery01.append("                                    SELECT \n");
//		mergeQuery01.append("                                           COUNT (DISTINCT QTY.CNTR_TPSZ_CD) \n");
//		mergeQuery01.append("                                     FROM BKG_BL_DOC     DOC, \n");
//		mergeQuery01.append("                                          BKG_BOOKING    BKG, \n");
//		mergeQuery01.append("                                          BKG_BOOKING    BK2, \n");
//		mergeQuery01.append("                                          BKG_QUANTITY   QTY \n");
//		mergeQuery01.append("                                    WHERE \n");
//		mergeQuery01.append("                                        ( \n");
//		mergeQuery01.append("                                          BKG.BKG_NO       = DOC.BKG_NO \n");
//		mergeQuery01.append("                                       OR \n");
//		mergeQuery01.append("                                          BKG.BL_NO        = DOC.MST_CVRD_BL_NO \n");
//		mergeQuery01.append("                                        ) \n");
//		mergeQuery01.append("                                      AND BK2.BKG_NO       = DOC.BKG_NO \n");
//		mergeQuery01.append("                                      AND BK2.BL_NO_TP \n");
//		mergeQuery01.append("                                       IN \n");
//		mergeQuery01.append("                                        ( \n");
//		mergeQuery01.append("                                     CASE \n");
//		mergeQuery01.append("                                     WHEN BKG.BL_NO_TP = '9' \n");
//		mergeQuery01.append("                                     THEN '0' \n");
//		mergeQuery01.append("                                     ELSE BK2.BL_NO_TP \n");
//		mergeQuery01.append("                                      END \n");
//		mergeQuery01.append("                                        ) \n");
//		mergeQuery01.append("                                      AND BK2.BKG_STS_CD \n");
//		mergeQuery01.append("                                   NOT IN \n");
//		mergeQuery01.append("                                        ( \n");
//		mergeQuery01.append("                                     CASE \n");
//		mergeQuery01.append("                                     WHEN BKG.BKG_STS_CD <> 'X' \n");
//		mergeQuery01.append("                                     THEN 'X' \n");
//		mergeQuery01.append("                                     ELSE ' ' \n");
//		mergeQuery01.append("                                      END \n");
//		mergeQuery01.append("                                        ) \n");
//		mergeQuery01.append("                                      AND BK2.BKG_NO       = QTY.BKG_NO \n");
//		mergeQuery01.append("                                      AND BKG.BKG_NO       = AGN.BKG_NO \n");
//		mergeQuery01.append("                                      AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");
//		mergeQuery01.append("                              )                                             AS MNUM, \n");
//		mergeQuery01.append("                                AGN.BKG_NO                                  AS BKG_NO, \n");
//		mergeQuery01.append("                                MAX (AGN.AGN_CD)                            AS AGN_CD, \n");
//		mergeQuery01.append("                                MAX (AGN.IO_BND_CD)                         AS IO_BND_CD, \n");
//		mergeQuery01.append("                                MAX (AGN.AC_TP_CD)                          AS AC_TP_CD, \n");
//		mergeQuery01.append("                                MAX (AGN.AC_SEQ)                            AS AC_SEQ, \n");
//		mergeQuery01.append("                                MAX (AGN.ACT_IF_COMM_AMT)                   AS ACT_USD_COMM_AMT, \n");
//		mergeQuery01.append("                                MAX (AGN.ACT_IF_LOCL_COMM_AMT)              AS ACT_LOCL_COMM_AMT, \n");
//		mergeQuery01.append("                                MAX (AGN.CURR_CD)                           AS LOCL_CURR_CD, \n");
//		mergeQuery01.append("                                QTY.CNTR_TPSZ_CD, \n");
//		mergeQuery01.append("                                SUM (QTY.OP_CNTR_QTY)                       AS BKG_VOL_QTY, \n");
//		mergeQuery01.append("                                RATIO_TO_REPORT (SUM (QTY.OP_CNTR_QTY)) \n");
//		mergeQuery01.append("                                OVER \n");
//		mergeQuery01.append("                              ( \n");
//		mergeQuery01.append("                   PARTITION BY AGN.BKG_NO, \n");
//		mergeQuery01.append("                                AGN.AGN_CD, \n");
//		mergeQuery01.append("                                AGN.IO_BND_CD, \n");
//		mergeQuery01.append("                                AGN.AC_TP_CD \n");
//		mergeQuery01.append("                              )                                             AS QTY_RATIO \n");
//		mergeQuery01.append("                           FROM BKG_QUANTITY QTY, \n");
//		mergeQuery01.append("                              ( \n");
//		mergeQuery01.append("                                    SELECT \n");
//		mergeQuery01.append("                                           AGN.BKG_NO, \n");
//		mergeQuery01.append("                                           AGN.AGN_CD, \n");
//		mergeQuery01.append("                                           AGN.IO_BND_CD, \n");
//		mergeQuery01.append("                                           AGN.AC_TP_CD, \n");
//		mergeQuery01.append("                                           AGN.AC_SEQ, \n");
//		mergeQuery01.append("                                           AGN.ACT_IF_COMM_AMT, \n");
//		mergeQuery01.append("                                           AGN.ACT_IF_LOCL_COMM_AMT, \n");
//		mergeQuery01.append("                                           AGN.CURR_CD \n");
//		mergeQuery01.append("                                      FROM AGT_AGN_COMM AGN \n");
//		mergeQuery01.append("                                     WHERE AGN.BKG_NO    = ? --:BKG_NO \n");
//		mergeQuery01.append("                                       --AND AGN.COMM_PROC_STS_CD = 'CS' \n");
//		mergeQuery01.append("                                       AND AGN.AC_SEQ \n");
//		mergeQuery01.append("                                         = \n");
//		mergeQuery01.append("                                         ( \n");
//		mergeQuery01.append("                                               SELECT \n");
//		mergeQuery01.append("                                                      MAX (AG2.AC_SEQ) \n");
//		mergeQuery01.append("                                                 FROM AGT_AGN_COMM AG2 \n");
//		mergeQuery01.append("                                                WHERE AG2.BKG_NO    = AGN.BKG_NO \n");
//		mergeQuery01.append("                                                  AND AG2.AGN_CD    = AGN.AGN_CD \n");
//		mergeQuery01.append("                                                  AND AG2.IO_BND_CD = AGN.IO_BND_CD \n");
//		mergeQuery01.append("                                                  AND AG2.AC_TP_CD  = AGN.AC_TP_CD \n");
//		mergeQuery01.append("                                                  AND COMM_PROC_STS_CD \n");
//		mergeQuery01.append("                                                   IN \n");
//		mergeQuery01.append("                                                    ( \n");
//		mergeQuery01.append("                                                      'RS', 'RM', 'AS', 'IF', 'CS' \n");
//		mergeQuery01.append("                                                    ) \n");
//		mergeQuery01.append("                                         ) \n");
//		mergeQuery01.append("                              ) AGN \n");
//		mergeQuery01.append("                          WHERE QTY.BKG_NO \n");
//		mergeQuery01.append("                             IN \n");
//		mergeQuery01.append("                              ( \n");
//		mergeQuery01.append("                                   SELECT \n");
//		mergeQuery01.append("                                          DOC.BKG_NO \n");
//		mergeQuery01.append("                                     FROM BKG_BL_DOC     DOC, \n");
//		mergeQuery01.append("                                          BKG_BOOKING    BKG, \n");
//		mergeQuery01.append("                                          BKG_BOOKING    BK2 \n");
//		mergeQuery01.append("                                    WHERE \n");
//		mergeQuery01.append("                                        ( \n");
//		mergeQuery01.append("                                          BKG.BKG_NO       = DOC.BKG_NO \n");
//		mergeQuery01.append("                                       OR \n");
//		mergeQuery01.append("                                          BKG.BL_NO        = DOC.MST_CVRD_BL_NO \n");
//		mergeQuery01.append("                                        ) \n");
//		mergeQuery01.append("                                      AND BK2.BKG_NO       = DOC.BKG_NO \n");
//		mergeQuery01.append("                                      AND BK2.BL_NO_TP \n");
//		mergeQuery01.append("                                       IN \n");
//		mergeQuery01.append("                                        ( \n");
//		mergeQuery01.append("                                     CASE \n");
//		mergeQuery01.append("                                     WHEN BKG.BL_NO_TP = '9' \n");
//		mergeQuery01.append("                                     THEN '0' \n");
//		mergeQuery01.append("                                     ELSE BK2.BL_NO_TP \n");
//		mergeQuery01.append("                                      END \n");
//		mergeQuery01.append("                                        ) \n");
//		mergeQuery01.append("                                      AND BK2.BKG_STS_CD \n");
//		mergeQuery01.append("                                   NOT IN \n");
//		mergeQuery01.append("                                        ( \n");
//		mergeQuery01.append("                                     CASE \n");
//		mergeQuery01.append("                                     WHEN BKG.BKG_STS_CD <> 'X' \n");
//		mergeQuery01.append("                                     THEN 'X' \n");
//		mergeQuery01.append("                                     ELSE ' ' \n");
//		mergeQuery01.append("                                      END \n");
//		mergeQuery01.append("                                        ) \n");
//		mergeQuery01.append("                                      AND BK2.BKG_NO       = QTY.BKG_NO \n");
//		mergeQuery01.append("                                      AND BKG.BKG_NO       = ? --:BKG_NO \n");
//		mergeQuery01.append("                              ) \n");
//		mergeQuery01.append("                            AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");
//		mergeQuery01.append("                       GROUP BY AGN.BKG_NO, \n");
//		mergeQuery01.append("                                AGN.AGN_CD, \n");
//		mergeQuery01.append("                                AGN.IO_BND_CD, \n");
//		mergeQuery01.append("                                AGN.AC_TP_CD, \n");
//		mergeQuery01.append("                                QTY.CNTR_TPSZ_CD \n");
//		mergeQuery01.append("                       ORDER BY QTY.CNTR_TPSZ_CD DESC \n");
//		mergeQuery01.append("                   ) TOB \n");
//		mergeQuery01.append("                  ON \n");
//		mergeQuery01.append("                   ( \n");
//		mergeQuery01.append("                     AIS.BKG_NO       = TOB.BKG_NO \n");
//		mergeQuery01.append("                 AND AIS.AGN_CD       = TOB.AGN_CD \n");
//		mergeQuery01.append("                 AND AIS.IO_BND_CD    = TOB.IO_BND_CD \n");
//		mergeQuery01.append("                 AND AIS.AC_TP_CD     = TOB.AC_TP_CD \n");
//		mergeQuery01.append("                 AND AIS.AC_SEQ       = TOB.AC_SEQ \n");
//		mergeQuery01.append("                 AND AIS.CNTR_TPSZ_CD = TOB.CNTR_TPSZ_CD \n");
//		mergeQuery01.append("                   ) \n");
//		mergeQuery01.append("        ) PCD \n");
//		mergeQuery01.append("        ON \n");
//		mergeQuery01.append("         ( TBL.BKG_NO         = PCD.BKG_NO \n");
//		mergeQuery01.append("       AND TBL.AGN_CD         = PCD.AGN_CD \n");
//		mergeQuery01.append("       AND TBL.IO_BND_CD      = PCD.IO_BND_CD \n");
//		mergeQuery01.append("       AND TBL.AC_TP_CD       = PCD.AC_TP_CD \n");
//		mergeQuery01.append("       AND TBL.AC_SEQ         = PCD.AC_SEQ \n");
//		mergeQuery01.append("       AND TBL.CNTR_TPSZ_CD   = PCD.CNTR_TPSZ_CD \n");
//		mergeQuery01.append("         ) \n");
//		mergeQuery01.append("      WHEN MATCHED \n");
//		mergeQuery01.append("      THEN \n");
//		mergeQuery01.append("               UPDATE \n");
//		mergeQuery01.append("                  SET TBL.BKG_VOL_QTY       = PCD.BKG_VOL_QTY, \n");
//		mergeQuery01.append("                      TBL.LOCL_CURR_CD      = PCD.LOCL_CURR_CD, \n");
//		mergeQuery01.append("                      TBL.ACT_USD_COMM_AMT  = PCD.ACT_USD_COMM_AMT, \n");
//		mergeQuery01.append("                      TBL.ACT_LOCL_COMM_AMT = PCD.ACT_LOCL_COMM_AMT, \n");
//		mergeQuery01.append("                      TBL.UPD_USR_ID        = PCD.UPD_USR_ID, \n");
//		mergeQuery01.append("                      TBL.UPD_DT            = PCD.UPD_DT \n");
//		mergeQuery01.append("               DELETE \n");
//		mergeQuery01.append("                WHERE PCD.BKG_VOL_QTY IS NULL \n");
//		mergeQuery01.append("      WHEN NOT MATCHED \n");
//		mergeQuery01.append("      THEN \n");
//		mergeQuery01.append("    INSERT \n");
//		mergeQuery01.append("         ( \n");
//		mergeQuery01.append("           BKG_NO, \n");
//		mergeQuery01.append("           AGN_CD, \n");
//		mergeQuery01.append("           IO_BND_CD, \n");
//		mergeQuery01.append("           AC_TP_CD, \n");
//		mergeQuery01.append("           AC_SEQ, \n");
//		mergeQuery01.append("           CNTR_TPSZ_CD, \n");
//		mergeQuery01.append("           BKG_VOL_QTY, \n");
//		mergeQuery01.append("           LOCL_CURR_CD, \n");
//		mergeQuery01.append("           ACT_USD_COMM_AMT, \n");
//		mergeQuery01.append("           ACT_LOCL_COMM_AMT, \n");
//		mergeQuery01.append("           UPD_USR_ID, \n");
//		mergeQuery01.append("           UPD_DT, \n");
//		mergeQuery01.append("           CRE_USR_ID, \n");
//		mergeQuery01.append("           CRE_DT \n");
//		mergeQuery01.append("         ) \n");
//		mergeQuery01.append("    VALUES \n");
//		mergeQuery01.append("         ( \n");
//		mergeQuery01.append("           PCD.BKG_NO, \n");
//		mergeQuery01.append("           PCD.AGN_CD, \n");
//		mergeQuery01.append("           PCD.IO_BND_CD, \n");
//		mergeQuery01.append("           PCD.AC_TP_CD, \n");
//		mergeQuery01.append("           PCD.AC_SEQ, \n");
//		mergeQuery01.append("           PCD.CNTR_TPSZ_CD, \n");
//		mergeQuery01.append("           PCD.BKG_VOL_QTY, \n");
//		mergeQuery01.append("           PCD.LOCL_CURR_CD, \n");
//		mergeQuery01.append("           PCD.ACT_USD_COMM_AMT, \n");
//		mergeQuery01.append("           PCD.ACT_LOCL_COMM_AMT, \n");
//		mergeQuery01.append("           PCD.UPD_USR_ID, \n");
//		mergeQuery01.append("           PCD.UPD_DT, \n");
//		mergeQuery01.append("           PCD.CRE_USR_ID, \n");
//		mergeQuery01.append("           PCD.CRE_DT \n");
//		mergeQuery01.append("         ) \n");
//
//      CLT-111121272 소스품질 결함건 수정 반영
//		mergeQuery02.append("     MERGE \n");
//		mergeQuery02.append("      INTO AGT_BROG_COMM_DTL TBL \n");
//		mergeQuery02.append("     USING \n");
//		mergeQuery02.append("         ( \n");
//		mergeQuery02.append("               SELECT \n");
//		mergeQuery02.append("                 CASE \n");
//		mergeQuery02.append("                 WHEN TOB.BKG_NO IS NULL \n");
//		mergeQuery02.append("                 THEN AIS.BKG_NO \n");
//		mergeQuery02.append("                 ELSE TOB.BKG_NO \n");
//		mergeQuery02.append("                  END                                                            AS BKG_NO, \n");
//		mergeQuery02.append("                 CASE \n");
//		mergeQuery02.append("                 WHEN TOB.CNTR_TPSZ_CD IS NULL \n");
//		mergeQuery02.append("                 THEN AIS.CNTR_TPSZ_CD \n");
//		mergeQuery02.append("                 ELSE TOB.CNTR_TPSZ_CD \n");
//		mergeQuery02.append("                  END                                                            AS CNTR_TPSZ_CD, \n");
//		mergeQuery02.append("                 CASE \n");
//		mergeQuery02.append("                 WHEN TOB.BROG_SEQ IS NULL \n");
//		mergeQuery02.append("                 THEN AIS.BROG_SEQ \n");
//		mergeQuery02.append("                 ELSE TOB.BROG_SEQ \n");
//		mergeQuery02.append("                  END                                                            AS BROG_SEQ, \n");
//		mergeQuery02.append("                      TOB.BKG_VOL_QTY                                            AS BKG_VOL_QTY, \n");
//		mergeQuery02.append("                CASE \n");
//		mergeQuery02.append("                WHEN TOB.QTY_RATIO = 1 \n");
//		mergeQuery02.append("                THEN TOB.ACT_USD_COMM_AMT \n");
//		mergeQuery02.append("                WHEN TOB.RNUM = TOB.MNUM \n");
//		mergeQuery02.append("                THEN TOB.ACT_USD_COMM_AMT \n");
//		mergeQuery02.append("                   + ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
//		mergeQuery02.append("                   - SUM (ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2)) \n");
//		mergeQuery02.append("                     OVER \n");
//		mergeQuery02.append("                   ( \n");
//		mergeQuery02.append("           PARTITION \n");
//		mergeQuery02.append("                  BY TOB.BKG_NO \n");
//		mergeQuery02.append("            ORDER BY TOB.CNTR_TPSZ_CD DESC \n");
//		mergeQuery02.append("                   ) \n");
//		mergeQuery02.append("                ELSE ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
//		mergeQuery02.append("                 END                                                             AS ACT_USD_COMM_AMT, \n");
//		mergeQuery02.append("                     'COMMISSION'                                                AS UPD_USR_ID, \n");
//		mergeQuery02.append("                     SYSDATE                                                     AS UPD_DT, \n");
//		mergeQuery02.append("                     'COMMISSION'                                                AS CRE_USR_ID, \n");
//		mergeQuery02.append("                     SYSDATE                                                     AS CRE_DT \n");
//		mergeQuery02.append("                FROM \n");
//		mergeQuery02.append("                   ( \n");
//		mergeQuery02.append("                         SELECT \n");
//		mergeQuery02.append("                                BRD.BKG_NO, \n");
//		mergeQuery02.append("                                BRD.BROG_SEQ, \n");
//		mergeQuery02.append("                                BRD.CNTR_TPSZ_CD, \n");
//		mergeQuery02.append("                                BRD.BKG_VOL_QTY, \n");
//		mergeQuery02.append("                                BRD.ACT_USD_COMM_AMT, \n");
//		mergeQuery02.append("                                BRD.UPD_USR_ID, \n");
//		mergeQuery02.append("                                BRD.UPD_DT, \n");
//		mergeQuery02.append("                                BRD.CRE_USR_ID, \n");
//		mergeQuery02.append("                                BRD.CRE_DT \n");
//		mergeQuery02.append("                           FROM AGT_BROG_COMM_DTL BRD, \n");
//		mergeQuery02.append("                              ( \n");
//		mergeQuery02.append("                                    SELECT \n");
//		mergeQuery02.append("                                           BRO.BKG_NO, \n");
//		mergeQuery02.append("                                           MAX (BRO.BROG_SEQ)      AS BROG_SEQ \n");
//		mergeQuery02.append("                                      FROM AGT_BROG_COMM BRO \n");
//		mergeQuery02.append("                                     WHERE BKG_NO         = ? --:BKG_NO \n");
//		mergeQuery02.append("                                       AND COMM_PROC_STS_CD \n");
//		mergeQuery02.append("                                        IN \n");
//		mergeQuery02.append("                                         ( \n");
//		mergeQuery02.append("                                           'RS', 'RM', 'AS', 'IF', 'CS' \n");
//		mergeQuery02.append("                                         ) \n");
//		mergeQuery02.append("                                  GROUP BY BRO.BKG_NO \n");
//		mergeQuery02.append("                                    HAVING EXISTS \n");
//		mergeQuery02.append("                                         ( \n");
//		mergeQuery02.append("                                               SELECT \n");
//		mergeQuery02.append("                                                      1 \n");
//		mergeQuery02.append("                                                 FROM AGT_BROG_COMM BR2 \n");
//		mergeQuery02.append("                                                WHERE BR2.BKG_NO           = BRO.BKG_NO \n");
//		mergeQuery02.append("                                                  AND BR2.COMM_PROC_STS_CD = 'CS' \n");
//		mergeQuery02.append("                                                  AND BR2.BROG_SEQ         = MAX (BRO.BROG_SEQ) \n");
//		mergeQuery02.append("                                         ) \n");
//		mergeQuery02.append("                              ) BRO \n");
//		mergeQuery02.append("                          WHERE BRD.BKG_NO    = BRO.BKG_NO \n");
//		mergeQuery02.append("                            AND BRD.BROG_SEQ    = BRO.BROG_SEQ \n");
//		mergeQuery02.append("                   ) AIS \n");
//		mergeQuery02.append("          FULL OUTER \n");
//		mergeQuery02.append("                JOIN \n");
//		mergeQuery02.append("                   ( \n");
//		mergeQuery02.append("                         SELECT \n");
//		mergeQuery02.append("                                RANK() OVER(ORDER BY QTY.CNTR_TPSZ_CD DESC) AS RNUM, \n");
//		mergeQuery02.append("                              ( \n");
//		mergeQuery02.append("                                    SELECT \n");
//		mergeQuery02.append("                                           COUNT (DISTINCT QTY.CNTR_TPSZ_CD) \n");
//		mergeQuery02.append("                                     FROM BKG_BL_DOC     DOC, \n");
//		mergeQuery02.append("                                          BKG_BOOKING    BKG, \n");
//		mergeQuery02.append("                                          BKG_BOOKING    BK2, \n");
//		mergeQuery02.append("                                          BKG_QUANTITY   QTY \n");
//		mergeQuery02.append("                                    WHERE \n");
//		mergeQuery02.append("                                        ( \n");
//		mergeQuery02.append("                                          BKG.BKG_NO       = DOC.BKG_NO \n");
//		mergeQuery02.append("                                       OR \n");
//		mergeQuery02.append("                                          BKG.BL_NO        = DOC.MST_CVRD_BL_NO \n");
//		mergeQuery02.append("                                        ) \n");
//		mergeQuery02.append("                                      AND BK2.BKG_NO       = DOC.BKG_NO \n");
//		mergeQuery02.append("                                      AND BK2.BL_NO_TP \n");
//		mergeQuery02.append("                                       IN \n");
//		mergeQuery02.append("                                        ( \n");
//		mergeQuery02.append("                                     CASE \n");
//		mergeQuery02.append("                                     WHEN BKG.BL_NO_TP = '9' \n");
//		mergeQuery02.append("                                     THEN '0' \n");
//		mergeQuery02.append("                                     ELSE BK2.BL_NO_TP \n");
//		mergeQuery02.append("                                      END \n");
//		mergeQuery02.append("                                        ) \n");
//		mergeQuery02.append("                                      AND BK2.BKG_STS_CD \n");
//		mergeQuery02.append("                                   NOT IN \n");
//		mergeQuery02.append("                                        ( \n");
//		mergeQuery02.append("                                     CASE \n");
//		mergeQuery02.append("                                     WHEN BKG.BKG_STS_CD <> 'X' \n");
//		mergeQuery02.append("                                     THEN 'X' \n");
//		mergeQuery02.append("                                     ELSE ' ' \n");
//		mergeQuery02.append("                                      END \n");
//		mergeQuery02.append("                                        ) \n");
//		mergeQuery02.append("                                      AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");
//		mergeQuery02.append("                                      AND BK2.BKG_NO       = QTY.BKG_NO \n");
//		mergeQuery02.append("                                      AND BKG.BKG_NO       = BRO.BKG_NO \n");
//		mergeQuery02.append("                              )                                             AS MNUM, \n");
//		mergeQuery02.append("                                BRO.BKG_NO                                  AS BKG_NO, \n");
//		mergeQuery02.append("                                MAX (BRO.BROG_SEQ)                            AS BROG_SEQ, \n");
//		mergeQuery02.append("                                MAX (BRO.ACT_IF_COMM_AMT)                   AS ACT_USD_COMM_AMT, \n");
//		mergeQuery02.append("                                QTY.CNTR_TPSZ_CD, \n");
//		mergeQuery02.append("                                SUM (QTY.OP_CNTR_QTY)                       AS BKG_VOL_QTY, \n");
//		mergeQuery02.append("                                RATIO_TO_REPORT (SUM (QTY.OP_CNTR_QTY)) \n");
//		mergeQuery02.append("                                OVER \n");
//		mergeQuery02.append("                              ( \n");
//		mergeQuery02.append("                   PARTITION BY BRO.BKG_NO \n");
//		mergeQuery02.append("                              )                                             AS QTY_RATIO \n");
//		mergeQuery02.append("                           FROM BKG_QUANTITY QTY, \n");
//		mergeQuery02.append("                              ( \n");
//		mergeQuery02.append("                                    SELECT \n");
//		mergeQuery02.append("                                           BRO.BKG_NO, \n");
//		mergeQuery02.append("                                           BRO.BROG_SEQ, \n");
//		mergeQuery02.append("                                           BRO.ACT_IF_COMM_AMT \n");
//		mergeQuery02.append("                                      FROM AGT_BROG_COMM BRO \n");
//		mergeQuery02.append("                                     WHERE BRO.BKG_NO    = ? --:BKG_NO \n");
//		mergeQuery02.append("                                       AND BRO.COMM_PROC_STS_CD = 'CS' \n");
//		mergeQuery02.append("                                       AND BRO.BROG_SEQ \n");
//		mergeQuery02.append("                                         = \n");
//		mergeQuery02.append("                                         ( \n");
//		mergeQuery02.append("                                               SELECT \n");
//		mergeQuery02.append("                                                      MAX (BR2.BROG_SEQ) \n");
//		mergeQuery02.append("                                                 FROM AGT_BROG_COMM BR2 \n");
//		mergeQuery02.append("                                                WHERE BR2.BKG_NO    = BRO.BKG_NO \n");
//		mergeQuery02.append("                                                  AND COMM_PROC_STS_CD \n");
//		mergeQuery02.append("                                                   IN \n");
//		mergeQuery02.append("                                                    ( \n");
//		mergeQuery02.append("                                                      'RS', 'RM', 'AS', 'IF', 'CS' \n");
//		mergeQuery02.append("                                                    ) \n");
//		mergeQuery02.append("                                         ) \n");
//		mergeQuery02.append("                              ) BRO \n");
//		mergeQuery02.append("                          WHERE QTY.BKG_NO \n");
//		mergeQuery02.append("                             IN \n");
//		mergeQuery02.append("                              ( \n");
//		mergeQuery02.append("                                   SELECT \n");
//		mergeQuery02.append("                                          DOC.BKG_NO \n");
//		mergeQuery02.append("                                     FROM BKG_BL_DOC     DOC, \n");
//		mergeQuery02.append("                                          BKG_BOOKING    BKG, \n");
//		mergeQuery02.append("                                          BKG_BOOKING    BK2 \n");
//		mergeQuery02.append("                                    WHERE \n");
//		mergeQuery02.append("                                        ( \n");
//		mergeQuery02.append("                                          BKG.BKG_NO       = DOC.BKG_NO \n");
//		mergeQuery02.append("                                       OR \n");
//		mergeQuery02.append("                                          BKG.BL_NO        = DOC.MST_CVRD_BL_NO \n");
//		mergeQuery02.append("                                        ) \n");
//		mergeQuery02.append("                                      AND BK2.BKG_NO       = DOC.BKG_NO \n");
//		mergeQuery02.append("                                      AND BK2.BL_NO_TP \n");
//		mergeQuery02.append("                                       IN \n");
//		mergeQuery02.append("                                        ( \n");
//		mergeQuery02.append("                                     CASE \n");
//		mergeQuery02.append("                                     WHEN BKG.BL_NO_TP = '9' \n");
//		mergeQuery02.append("                                     THEN '0' \n");
//		mergeQuery02.append("                                     ELSE BK2.BL_NO_TP \n");
//		mergeQuery02.append("                                      END \n");
//		mergeQuery02.append("                                        ) \n");
//		mergeQuery02.append("                                      AND BK2.BKG_STS_CD \n");
//		mergeQuery02.append("                                   NOT IN \n");
//		mergeQuery02.append("                                        ( \n");
//		mergeQuery02.append("                                     CASE \n");
//		mergeQuery02.append("                                     WHEN BKG.BKG_STS_CD <> 'X' \n");
//		mergeQuery02.append("                                     THEN 'X' \n");
//		mergeQuery02.append("                                     ELSE ' ' \n");
//		mergeQuery02.append("                                      END \n");
//		mergeQuery02.append("                                        ) \n");
//		mergeQuery02.append("                                      AND BK2.BKG_NO       = QTY.BKG_NO \n");
//		mergeQuery02.append("                                      AND BKG.BKG_NO       = ? --:BKG_NO \n");
//		mergeQuery02.append("                              ) \n");
//		mergeQuery02.append("                            AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");
//		mergeQuery02.append("                       GROUP BY BRO.BKG_NO, \n");
//		mergeQuery02.append("                                QTY.CNTR_TPSZ_CD \n");
//		mergeQuery02.append("                       ORDER BY QTY.CNTR_TPSZ_CD DESC \n");
//		mergeQuery02.append("                   ) TOB \n");
//		mergeQuery02.append("                  ON \n");
//		mergeQuery02.append("                   ( \n");
//		mergeQuery02.append("                     AIS.BKG_NO       = TOB.BKG_NO \n");
//		mergeQuery02.append("                 AND AIS.BROG_SEQ       = TOB.BROG_SEQ \n");
//		mergeQuery02.append("                 AND AIS.CNTR_TPSZ_CD = TOB.CNTR_TPSZ_CD \n");
//		mergeQuery02.append("                   ) \n");
//		mergeQuery02.append("        ) PCD \n");
//		mergeQuery02.append("        ON \n");
//		mergeQuery02.append("         ( TBL.BKG_NO         = PCD.BKG_NO \n");
//		mergeQuery02.append("       AND TBL.BROG_SEQ         = PCD.BROG_SEQ \n");
//		mergeQuery02.append("       AND TBL.CNTR_TPSZ_CD   = PCD.CNTR_TPSZ_CD \n");
//		mergeQuery02.append("         ) \n");
//		mergeQuery02.append("      WHEN MATCHED \n");
//		mergeQuery02.append("      THEN \n");
//		mergeQuery02.append("               UPDATE \n");
//		mergeQuery02.append("                  SET TBL.BKG_VOL_QTY       = PCD.BKG_VOL_QTY, \n");
//		mergeQuery02.append("                      TBL.ACT_USD_COMM_AMT  = PCD.ACT_USD_COMM_AMT, \n");
//		mergeQuery02.append("                      TBL.UPD_USR_ID        = PCD.UPD_USR_ID, \n");
//		mergeQuery02.append("                      TBL.UPD_DT            = PCD.UPD_DT \n");
//		mergeQuery02.append("               DELETE \n");
//		mergeQuery02.append("                WHERE PCD.BKG_VOL_QTY IS NULL \n");
//		mergeQuery02.append("      WHEN NOT MATCHED \n");
//		mergeQuery02.append("      THEN \n");
//		mergeQuery02.append("    INSERT \n");
//		mergeQuery02.append("         ( \n");
//		mergeQuery02.append("           BKG_NO, \n");
//		mergeQuery02.append("           BROG_SEQ, \n");
//		mergeQuery02.append("           CNTR_TPSZ_CD, \n");
//		mergeQuery02.append("           BKG_VOL_QTY, \n");
//		mergeQuery02.append("           ACT_USD_COMM_AMT, \n");
//		mergeQuery02.append("           UPD_USR_ID, \n");
//		mergeQuery02.append("           UPD_DT, \n");
//		mergeQuery02.append("           CRE_USR_ID, \n");
//		mergeQuery02.append("           CRE_DT \n");
//		mergeQuery02.append("         ) \n");
//		mergeQuery02.append("    VALUES \n");
//		mergeQuery02.append("         ( \n");
//		mergeQuery02.append("           PCD.BKG_NO, \n");
//		mergeQuery02.append("           PCD.BROG_SEQ, \n");
//		mergeQuery02.append("           PCD.CNTR_TPSZ_CD, \n");
//		mergeQuery02.append("           PCD.BKG_VOL_QTY, \n");
//		mergeQuery02.append("           PCD.ACT_USD_COMM_AMT, \n");
//		mergeQuery02.append("           PCD.UPD_USR_ID, \n");
//		mergeQuery02.append("           PCD.UPD_DT, \n");
//		mergeQuery02.append("           PCD.CRE_USR_ID, \n");
//		mergeQuery02.append("           PCD.CRE_DT \n");
//		mergeQuery02.append("         ) \n");		
		
		String bkg_no			= checkNull((String)bkgMap.get("BKG_NO"));
		String agn_zero_sum		= "1";
		String agn_step_row		= "1";
		String brog_zero_sum	= "1";
		String brog_step_row	= "1";

		
		try
		{
			// ZeroSum 대상을 조회한다.
			i = 1;
			ps = new LoggableStatement(con, query.toString());
			ps.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();
			
			if( rs.next() )
			{
				agn_zero_sum	= rs.getString("AGN_ZERO_SUM");
				agn_step_row	= rs.getString("AGN_STEP_ROW");
				brog_zero_sum	= rs.getString("BROG_ZERO_SUM");
				brog_step_row	= rs.getString("BROG_STEP_ROW");
			}	


			if (!"0".equals(agn_step_row))
			{
				// AGT_CHG_DDCT_REF의 Step Rows 삭제
				i = 1;
				deletePs01 = new LoggableStatement(con, deleteQuery01.toString());
				deletePs01.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs01).getQueryString());
				deletePs01.executeUpdate();
				
				// AGT_TRSP_DDCT_REF의 Step Rows 삭제
				i = 1;
				deletePs02 = new LoggableStatement(con, deleteQuery02.toString());
				deletePs02.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs02).getQueryString());
				deletePs02.executeUpdate();
	
				// AGT_AGN_COMM_DTL의 Step Rows 삭제
				i = 1;
				deletePs03 = new LoggableStatement(con, deleteQuery03.toString());
				deletePs03.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs03).getQueryString());
				deletePs03.executeUpdate();
	
				// AGT_AGN_COMM의 Step Rows 삭제
				i = 1;
				deletePs04 = new LoggableStatement(con, deleteQuery04.toString());
				deletePs04.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs04).getQueryString());
				deletePs04.executeUpdate();
			}

			if (!"0".equals(brog_step_row))
			{
				// AGT_BROG_CHG_DTL의 Step Rows 삭제
				i = 1;
				deletePs05 = new LoggableStatement(con, deleteQuery05.toString());
				deletePs05.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs05).getQueryString());
				deletePs05.executeUpdate();
				
				// AGT_BROG_COMM_DTL의 Step Rows 삭제
				i = 1;
				deletePs06 = new LoggableStatement(con, deleteQuery06.toString());
				deletePs06.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs06).getQueryString());
				deletePs06.executeUpdate();
	
				// AGT_BROG_COMM의 Step Rows 삭제
				i = 1;
				deletePs07 = new LoggableStatement(con, deleteQuery07.toString());
				deletePs07.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs07).getQueryString());
				deletePs07.executeUpdate();
			}

			if (!"0".equals(agn_zero_sum))
			{
				// AGT_AGN_COMM에 대한 ZEROSUM
				i = 1;
				insertPs01 = new LoggableStatement(con, insertQuery01.toString());
				insertPs01.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs01).getQueryString());
				insertPs01.executeUpdate();
				
//				// AGT_AGN_COMM_DTL에 대한 ZEROSUM
//				i = 1;
//				mergePs01 = new LoggableStatement(con, mergeQuery01.toString());
//				mergePs01.setString(i++, bkg_no);
//				mergePs01.setString(i++, bkg_no);
//				mergePs01.setString(i++, bkg_no);
//				log.debug("\n SQL1 : \n" + ((LoggableStatement)mergePs01).getQueryString());
//				mergePs01.executeUpdate();
			}

			if (!"0".equals(brog_zero_sum))
			{
				// AGT_AGN_COMM에 대한 ZEROSUM
				i = 1;
				insertPs02 = new LoggableStatement(con, insertQuery02.toString());
				insertPs02.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs02).getQueryString());
				insertPs02.executeUpdate();
				
//				// AGT_AGN_COMM_DTL에 대한 ZEROSUM
//				i = 1;
//				mergePs02 = new LoggableStatement(con, mergeQuery02.toString());
//				mergePs02.setString(i++, bkg_no);
//				mergePs02.setString(i++, bkg_no);
//				mergePs02.setString(i++, bkg_no);
//				log.debug("\n SQL1 : \n" + ((LoggableStatement)mergePs02).getQueryString());
//				mergePs02.executeUpdate();
			}
		}
		catch (SQLException e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		}
		catch (Exception e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		}
		finally
		{
			closeStatement(ps);
			closeStatement(deletePs01);
			closeStatement(deletePs02);
			closeStatement(deletePs03);
			closeStatement(deletePs04);
			closeStatement(deletePs05);
			closeStatement(deletePs06);
			closeStatement(deletePs07);
			closeStatement(insertPs01);
			closeStatement(insertPs02);
//			closeStatement(mergePs01);
//			closeStatement(mergePs02);
			closeResultSet(rs);
		}
	}
	

	/**
	 * Booking Commission 정보를 저장한다.<br>
	 * 정상 실행의 경우는 COMM_PROC_RSLT_RSN에 메시지가 NULL이 된다.<br>
	 * BKG정보에 해당하는 Error 발생시 Booking Commission 테이블에 Error 정보를 저장한다.<br>
	 * MASTER-COVERED BL / CONTRACT / SADATE / QUANTITY와 관련된 에러가 발생하는 경우 실행한다.
	 * @param con Connection
	 * @param bkgMap HashMap Booking 정보를 담고있는 HashMap
	 * @throws SQLException, Exception
	 */
	private void createBKGMaster( Connection con, HashMap bkgMap) throws SQLException, Exception
	{
		
		String bkg_no = (String)bkgMap.get("BKG_NO");
		String comm_proc_rslt_rsn = (String)bkgMap.get("COMM_PROC_RSLT_RSN");
		
		// Error INSERT/UPDATE를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// 저장쿼리
		StringBuffer query = new StringBuffer();
		
		query.append("     MERGE \n");
		query.append("      INTO AGT_COMM_BKG_INFO TBL \n");
		query.append("     USING \n");
		query.append("         ( \n");
		query.append("               SELECT \n");
		query.append("                      BKG.BKG_NO, \n");
		query.append("                    (     SELECT \n");
		query.append("                            CASE \n");
		query.append("                            WHEN BKG.BKG_STS_CD = 'X' \n");
		query.append("                            THEN 'BKG Canceled' \n");
		query.append("                            WHEN DOC.BL_CVRD_TP_CD = 'B' \n");
		query.append("                            THEN 'BL No['||BKG.BL_NO||'] is CO-BIZ BL!' \n");
		query.append("                            WHEN DOC.BL_CVRD_TP_CD = 'C' \n");
		query.append("                            THEN 'BL No['||BKG.BL_NO||'] is Covered BL!' \n");
		query.append("                            ELSE ? \n");
		query.append("                             END \n");
		query.append("                            FROM BKG_BL_DOC DOC \n");
		query.append("                           WHERE DOC.BKG_NO = BKG.BKG_NO \n");
		query.append("                    )                                                                                                               AS COMM_PROC_RSLT_RSN, \n");
		query.append("                    (     SELECT \n");
		query.append("                            CASE \n");
		query.append("                            WHEN BKG.BKG_STS_CD = 'X' \n");
		query.append("                            THEN 1 \n");
		query.append("                            WHEN DOC.BL_CVRD_TP_CD = 'B' \n");
		query.append("                            THEN 1 \n");
		query.append("                            WHEN DOC.BL_CVRD_TP_CD = 'C' \n");
		query.append("                            THEN 1 \n");
		query.append("                            ELSE 0 \n");
		query.append("                             END \n");
		query.append("                            FROM BKG_BL_DOC DOC \n");
		query.append("                           WHERE DOC.BKG_NO = BKG.BKG_NO \n");
		query.append("                    )                                                                                                               AS WDR_CHK, \n");
		query.append("                      BKG.BL_NO, \n");
		query.append("                      BKG.BKG_CGO_TP_CD, \n");
		query.append("                      BKG.BKG_STS_CD, \n");
		query.append("                      CST.SHPR_CNT_CD                                                                                               AS SHPR_CNT_CD, \n");
		query.append("                      CST.SHPR_SEQ                                                                                                  AS SHPR_SEQ, \n");
		query.append("                      CST.FRT_FWRD_CNT_CD                                                                                           AS FRT_FWRD_CNT_CD, \n");
		query.append("                      CST.FRT_FWRD_SEQ                                                                                              AS FRT_FWRD_SEQ, \n");
		query.append("                 CASE \n");
		query.append("                      COA_RANK_INFO_FNC \n");
		query.append("                    ( \n");
		query.append("                      NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'),                                            -- N1ST_RLANE_CD \n");
		query.append("                      CASE WHEN VV2.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD) END,            -- N2ND_RLANE_CD \n");
		query.append("                      CASE WHEN VV3.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD) END,            -- N3RD_RLANE_CD \n");
		query.append("                      CASE WHEN VV4.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD) END,            -- N4TH_RLANE_CD \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                      ELSE 'OO' \n");
		query.append("                       END,                                                                                                              -- N1ST_CONTI \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                      ELSE 'OO' \n");
		query.append("                       END,                                                                                                              -- N2ND_CONTI \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                      ELSE 'OO' \n");
		query.append("                       END,                                                                                                              -- N3RD_CONTI \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                      ELSE 'OO' \n");
		query.append("                       END                                                                                                               -- N4TH_CONTI \n");
		query.append("                    ) \n");
		query.append("                 WHEN 1 THEN NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO') \n");
		query.append("                 WHEN 2 THEN CASE WHEN VV2.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD) END \n");
		query.append("                 WHEN 3 THEN CASE WHEN VV3.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD) END \n");
		query.append("                 WHEN 4 THEN CASE WHEN VV4.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD) END \n");
		query.append("                  END                                                                                                               AS RLANE_CD, \n");
		query.append("                 CASE \n");
		query.append("                      COA_RANK_INFO_FNC \n");
		query.append("                    ( \n");
		query.append("                      NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'),                                            -- N1ST_RLANE_CD \n");
		query.append("                      CASE WHEN VV2.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD) END,            -- N2ND_RLANE_CD \n");
		query.append("                      CASE WHEN VV3.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD) END,            -- N3RD_RLANE_CD \n");
		query.append("                      CASE WHEN VV4.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD) END,            -- N4TH_RLANE_CD \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                      ELSE 'OO' \n");
		query.append("                       END,                                                                                                              -- N1ST_CONTI \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                      ELSE 'OO' \n");
		query.append("                       END,                                                                                                              -- N2ND_CONTI \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                      ELSE 'OO' \n");
		query.append("                       END,                                                                                                              -- N3RD_CONTI \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                      ELSE 'OO' \n");
		query.append("                       END                                                                                                               -- N4TH_CONTI \n");
		query.append(" \n");
		query.append("                    ) \n");
		query.append("                 WHEN 1 \n");
		query.append("                 THEN \n");
		query.append("                      NVL \n");
		query.append("                    ( \n");
		query.append("                 CASE 'RBCCO' \n");
		query.append("                 WHEN AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD) \n");
		query.append("                 THEN 'CFDR'||TO_CHAR (SYSDATE, 'YYMM')||'EE' \n");
		query.append("                  END \n");
		query.append("                    , \n");
		query.append("                      VV1.VSL_CD \n");
		query.append("                   || VV1.SKD_VOY_NO \n");
		query.append("                   || VV1.SKD_DIR_CD \n");
		query.append("                   || NVL \n");
		query.append("                    ( \n");
		query.append("                    ( \n");
		query.append("                          SELECT \n");
		query.append("                                 RLANE_DIR_CD \n");
		query.append("                            FROM AR_FINC_DIR_CONV \n");
		query.append("                           WHERE SLAN_CD     = VV1.SLAN_CD \n");
		query.append("                             AND SCONTI_CD   = POL1.SCONTI_CD \n");
		query.append("                             AND SLAN_DIR_CD = VV1.SKD_DIR_CD \n");
		query.append("                             AND DELT_FLG ='N' \n");
		query.append("                    ) \n");
		query.append("                    , VV1.SKD_DIR_CD \n");
		query.append("                    ) \n");
		query.append("                    ) \n");
		query.append("                 WHEN 2 \n");
		query.append("                 THEN \n");
		query.append("                      NVL \n");
		query.append("                    ( \n");
		query.append("                 CASE 'RBCCO' \n");
		query.append("                 WHEN AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD) \n");
		query.append("                 THEN 'CFDR'||TO_CHAR (SYSDATE, 'YYMM')||'EE' \n");
		query.append("                  END \n");
		query.append("                    , \n");
		query.append("                      VV2.VSL_CD \n");
		query.append("                   || VV2.SKD_VOY_NO \n");
		query.append("                   || VV2.SKD_DIR_CD \n");
		query.append("                   || NVL \n");
		query.append("                    ( \n");
		query.append("                    ( \n");
		query.append("                          SELECT \n");
		query.append("                                 RLANE_DIR_CD \n");
		query.append("                            FROM AR_FINC_DIR_CONV \n");
		query.append("                           WHERE SLAN_CD     = VV2.SLAN_CD \n");
		query.append("                             AND SCONTI_CD   = POL2.SCONTI_CD \n");
		query.append("                             AND SLAN_DIR_CD = VV2.SKD_DIR_CD \n");
		query.append("                             AND DELT_FLG ='N' \n");
		query.append("                    ) \n");
		query.append("                    , VV2.SKD_DIR_CD \n");
		query.append("                    ) \n");
		query.append("                    ) \n");
		query.append("                 WHEN 3 \n");
		query.append("                 THEN \n");
		query.append("                      NVL \n");
		query.append("                    ( \n");
		query.append("                 CASE 'RBCCO' \n");
		query.append("                 WHEN AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD) \n");
		query.append("                 THEN 'CFDR'||TO_CHAR (SYSDATE, 'YYMM')||'EE' \n");
		query.append("                  END \n");
		query.append("                    , \n");
		query.append("                      VV3.VSL_CD \n");
		query.append("                   || VV3.SKD_VOY_NO \n");
		query.append("                   || VV3.SKD_DIR_CD \n");
		query.append("                   || NVL \n");
		query.append("                    ( \n");
		query.append("                    ( \n");
		query.append("                          SELECT \n");
		query.append("                                 RLANE_DIR_CD \n");
		query.append("                            FROM AR_FINC_DIR_CONV \n");
		query.append("                           WHERE SLAN_CD     = VV3.SLAN_CD \n");
		query.append("                             AND SCONTI_CD   = POL3.SCONTI_CD \n");
		query.append("                             AND SLAN_DIR_CD = VV3.SKD_DIR_CD \n");
		query.append("                             AND DELT_FLG ='N' \n");
		query.append("                    ) \n");
		query.append("                    , VV3.SKD_DIR_CD \n");
		query.append("                    ) \n");
		query.append("                    ) \n");
		query.append("                 WHEN 4 \n");
		query.append("                 THEN \n");
		query.append("                      NVL \n");
		query.append("                    ( \n");
		query.append("                 CASE 'RBCCO' \n");
		query.append("                 WHEN AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD) \n");
		query.append("                 THEN 'CFDR'||TO_CHAR (SYSDATE, 'YYMM')||'EE' \n");
		query.append("                  END \n");
		query.append("                    , \n");
		query.append("                      VV4.VSL_CD \n");
		query.append("                   || VV4.SKD_VOY_NO \n");
		query.append("                   || VV4.SKD_DIR_CD \n");
		query.append("                   || NVL \n");
		query.append("                    ( \n");
		query.append("                    ( \n");
		query.append("                          SELECT \n");
		query.append("                                 RLANE_DIR_CD \n");
		query.append("                            FROM AR_FINC_DIR_CONV \n");
		query.append("                           WHERE SLAN_CD     = VV4.SLAN_CD \n");
		query.append("                             AND SCONTI_CD   = POL4.SCONTI_CD \n");
		query.append("                             AND SLAN_DIR_CD = VV4.SKD_DIR_CD \n");
		query.append("                             AND DELT_FLG ='N' \n");
		query.append("                    ) \n");
		query.append("                    , VV4.SKD_DIR_CD \n");
		query.append("                    ) \n");
		query.append("                    ) \n");
		query.append("                  END                                                                                                               AS REV_VVD_CD, \n");
		query.append("                      BKG.SLAN_CD                                                                                                   AS TRNK_SLAN_CD, \n");
		query.append("                      BKG.SLAN_CD                                                                                             -- TRUNK의 RLANE_CD ( TRUNK의 SLAN_CD(3자리) + POL의 CONTI(1자리) + POD의 CONTI(1자리) ) \n");
		query.append("                   || POL.CONTI_CD \n");
		query.append("                   || POD.CONTI_CD                                                                                                  AS TRNK_RLANE_CD, \n");
		query.append("                      BKG.VSL_CD                                                                                                    AS TRNK_VSL_CD, \n");
		query.append("                      BKG.SKD_VOY_NO                                                                                                AS TRNK_SKD_VOY_NO, \n");
		query.append("                      BKG.SKD_DIR_CD                                                                                                AS TRNK_SKD_DIR_CD, \n");
		query.append("                      BKG.REV_DIR_CD                                                                                                AS TRNK_REV_DIR_CD, \n");
		query.append("                      BKG.SVC_SCP_CD                                                                                                AS SVC_SCP_CD, \n");
		query.append("                      NULL                                                                                                          AS BKG_CA_NO, \n");
		query.append("                      NULL                                                                                                          AS BKG_CA_DT, \n");
		query.append("                    ( \n");
		query.append("                          SELECT \n");
		query.append("                                 LAN.REP_TRD_CD \n");
		query.append("                            FROM MDM_REV_LANE LAN \n");
		query.append("                           WHERE LAN.RLANE_CD \n");
		query.append("                               = \n");
		query.append("                            CASE \n");
		query.append("                                 COA_RANK_INFO_FNC \n");
		query.append("                               ( \n");
		query.append("                                 NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'),                                 -- N1ST_RLANE_CD \n");
		query.append("                                 CASE WHEN VV2.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD) END, -- N2ND_RLANE_CD \n");
		query.append("                                 CASE WHEN VV3.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD) END, -- N3RD_RLANE_CD \n");
		query.append("                                 CASE WHEN VV4.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD) END, -- N4TH_RLANE_CD \n");
		query.append("                                 CASE \n");
		query.append("                                 WHEN AGT_GET_CONTI_FNC (POL1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                                    = AGT_GET_CONTI_FNC (POD1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                                 THEN 'I' \n");
		query.append("                                   || AGT_GET_CONTI_FNC (POD1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                                 ELSE 'OO' \n");
		query.append("                                  END,                                                                                                   -- N1ST_CONTI \n");
		query.append("                                 CASE \n");
		query.append("                                 WHEN AGT_GET_CONTI_FNC (POL2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                                    = AGT_GET_CONTI_FNC (POD2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                                 THEN 'I' \n");
		query.append("                                   || AGT_GET_CONTI_FNC (POD2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                                 ELSE 'OO' \n");
		query.append("                                  END,                                                                                                   -- N2ND_CONTI \n");
		query.append("                                 CASE \n");
		query.append("                                 WHEN AGT_GET_CONTI_FNC (POL3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                                    = AGT_GET_CONTI_FNC (POD3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                                 THEN 'I' \n");
		query.append("                                   || AGT_GET_CONTI_FNC (POD3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                                 ELSE 'OO' \n");
		query.append("                                  END,                                                                                                   -- N3RD_CONTI \n");
		query.append("                                 CASE \n");
		query.append("                                 WHEN AGT_GET_CONTI_FNC (POL4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                                    = AGT_GET_CONTI_FNC (POD4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                                 THEN 'I' \n");
		query.append("                                   || AGT_GET_CONTI_FNC (POD4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                                 ELSE 'OO' \n");
		query.append("                                  END                                                                                                    -- N4TH_CONTI \n");
		query.append("                               ) \n");
		query.append("                            WHEN 1 THEN NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO') \n");
		query.append("                            WHEN 2 THEN CASE WHEN VV2.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD) END \n");
		query.append("                            WHEN 3 THEN CASE WHEN VV3.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD) END \n");
		query.append("                            WHEN 4 THEN CASE WHEN VV4.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD) END \n");
		query.append("                             END \n");
		query.append("                     )                                                                                                              AS TRD_CD, \n");
		query.append("                      BKG.POR_CD                                                                                                    AS BKG_POR_CD, \n");
		query.append("                      BKG.POL_CD                                                                                                    AS BKG_POL_CD, \n");
		query.append("                      BKG.POD_CD                                                                                                    AS BKG_POD_CD, \n");
		query.append("                      BKG.DEL_CD                                                                                                    AS BKG_DEL_CD, \n");
		query.append("                      BKG.RCV_TERM_CD                                                                                               AS BKG_RCV_TERM_CD, \n");
		query.append("                      BKG.DE_TERM_CD                                                                                                AS BKG_DE_TERM_CD, \n");
		query.append("                      NVL (BKG.PRE_RLY_PORT_CD, '*')                                                                                AS PRE_PORT_CD, \n");
		query.append("                      NVL (BKG.PST_RLY_PORT_CD, '*')                                                                                AS PST_PORT_CD, \n");
		query.append("                 CASE \n");
		query.append("                 WHEN CST.FMC_NO IS NOT NULL \n");
		query.append("                 THEN CST.FMC_NO \n");
		query.append("                 WHEN CST.FMC_NO_MDM IS NOT NULL \n");
		query.append("                 THEN CST.FMC_NO_MDM \n");
		query.append("                 ELSE CST.FMC_NO_PREV \n");
		query.append("                  END                                                                                                               AS FMC_NO, \n");
		query.append("                      BKG.REP_CMDT_CD                                                                                               AS REP_CMDT_CD, \n");
		query.append("                      BKG.CMDT_CD                                                                                                   AS CMDT_CD, \n");
		query.append("                      BKG.SC_NO                                                                                                     AS SC_NO, \n");
		query.append("                      BKG.RFA_NO                                                                                                    AS RFA_NO, \n");
		query.append("                      CST.BKG_PPD_FRT_AMT                                                                                           AS BKG_PPD_FRT_AMT, \n");
		query.append("                      CST.BKG_PPD_OTR_AMT                                                                                           AS BKG_PPD_OTR_AMT, \n");
		query.append("                      CST.BKG_CLT_FRT_AMT                                                                                           AS BKG_CLT_FRT_AMT, \n");
		query.append("                      CST.BKG_CLT_OTR_AMT                                                                                           AS BKG_CLT_OTR_AMT, \n");
		query.append("                      NVL (BKG.DCGO_FLG, 'N')                                                                                       AS SPCL_DG_CGO_FLG, \n");
		query.append("                      NVL (BKG.RC_FLG, 'N')                                                                                         AS SPCL_RC_FLG, \n");
		query.append("                      NVL (BKG.AWK_CGO_FLG, 'N')                                                                                    AS SPCL_AWK_CGO_FLG, \n");
		query.append("                      NVL (BKG.BB_CGO_FLG, 'N')                                                                                     AS SPCL_BB_CGO_FLG, \n");
		query.append("                      'N'                                                                                                           AS SPCL_RD_CGO_FLG, \n");
		query.append("                      BKG.BKG_OFC_CD                                                                                                AS BKG_OFC_CD, \n");
		query.append("                      BKG.CTRT_OFC_CD                                                                                               AS SLS_OFC_CD, \n");
		query.append("                      NULL                                                                                                          AS RHQ_CD, \n");
		query.append("                      NVL (BKG.SOC_FLG, 'N')                                                                                        AS BKG_SOC_FLG, \n");
		query.append("                      NVL (BKG.DBL_BKG_FLG, 'N')                                                                                    AS BKG_DBL_FLG, \n");
		query.append("                      BKG.BKG_CRE_DT                                                                                                AS BKG_CRE_DT, \n");
		query.append("                 CASE \n");
		query.append("                      COA_RANK_INFO_FNC \n");
		query.append("                    ( \n");
		query.append("                      NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'),                                            -- N1ST_RLANE_CD \n");
		query.append("                      CASE WHEN VV2.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD) END,            -- N2ND_RLANE_CD \n");
		query.append("                      CASE WHEN VV3.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD) END,            -- N3RD_RLANE_CD \n");
		query.append("                      CASE WHEN VV4.SLAN_CD IS NULL THEN '' ELSE AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD) END,            -- N4TH_RLANE_CD \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                      ELSE 'OO' \n");
		query.append("                       END,                                                                                                              -- N1ST_CONTI \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                      ELSE 'OO' END,                                                                                                     -- N2ND_CONTI \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                      ELSE 'OO' END,                                                                                                     -- N3RD_CONTI \n");
		query.append("                      CASE \n");
		query.append("                      WHEN AGT_GET_CONTI_FNC (POL4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                         = AGT_GET_CONTI_FNC (POD4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                      THEN 'I' \n");
		query.append("                        || AGT_GET_CONTI_FNC (POD4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                      ELSE 'OO' \n");
		query.append("                      END                                                                                                                -- N4TH_CONTI \n");
		query.append("                    ) \n");
		query.append("                 WHEN 1 \n");
		query.append("                 THEN \n");
		query.append("                 CASE \n");
		query.append("                 WHEN AGT_GET_CONTI_FNC (POL1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                    = AGT_GET_CONTI_FNC (POD1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                 THEN 'I' \n");
		query.append("                   || AGT_GET_CONTI_FNC (POD1.LOC_CD, NVL (AGT_GET_RLANE_FNC (VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')) \n");
		query.append("                 ELSE 'OO' \n");
		query.append("                  END \n");
		query.append("                 WHEN 2 \n");
		query.append("                 THEN \n");
		query.append("                 CASE \n");
		query.append("                 WHEN AGT_GET_CONTI_FNC (POL2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                    = AGT_GET_CONTI_FNC (POD2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                 THEN 'I' \n");
		query.append("                   || AGT_GET_CONTI_FNC (POD2.LOC_CD, AGT_GET_RLANE_FNC (VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)) \n");
		query.append("                 ELSE 'OO' \n");
		query.append("                  END \n");
		query.append("                 WHEN 3 \n");
		query.append("                 THEN \n");
		query.append("                 CASE \n");
		query.append("                 WHEN AGT_GET_CONTI_FNC (POL3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                    = AGT_GET_CONTI_FNC (POD3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                 THEN 'I' \n");
		query.append("                   || AGT_GET_CONTI_FNC (POD3.LOC_CD, AGT_GET_RLANE_FNC (VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)) \n");
		query.append("                 ELSE 'OO' \n");
		query.append("                  END \n");
		query.append("                 WHEN 4 \n");
		query.append("                 THEN \n");
		query.append("                 CASE \n");
		query.append("                 WHEN AGT_GET_CONTI_FNC (POL4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                    = AGT_GET_CONTI_FNC (POD4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                 THEN 'I' \n");
		query.append("                   || AGT_GET_CONTI_FNC (POD4.LOC_CD, AGT_GET_RLANE_FNC (VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)) \n");
		query.append("                 ELSE 'OO' \n");
		query.append("                  END \n");
		query.append("                  END                                                                                                               AS ESTM_IOC_DIV_CD, \n");
		query.append("                      'AGT SYSTEM'                                                                                                  AS UPD_USR_ID, \n");
		query.append("                      SYSDATE                                                                                                       AS UPD_DT, \n");
		query.append("                      'AGT SYSTEM'                                                                                                  AS CRE_USR_ID, \n");
		query.append("                      SYSDATE                                                                                                       AS CRE_DT \n");
		query.append("                 FROM BKG_BOOKING     BKG, \n");
		query.append("                      MDM_LOCATION    POL, \n");
		query.append("                      MDM_LOCATION    POD, \n");
		query.append("                      BKG_VVD         VV1, \n");
		query.append("                      BKG_VVD         VV2, \n");
		query.append("                      BKG_VVD         VV3, \n");
		query.append("                      BKG_VVD         VV4, \n");
		query.append("                      MDM_LOCATION    POL1, \n");
		query.append("                      MDM_LOCATION    POD1, \n");
		query.append("                      MDM_LOCATION    POL2, \n");
		query.append("                      MDM_LOCATION    POD2, \n");
		query.append("                      MDM_LOCATION    POL3, \n");
		query.append("                      MDM_LOCATION    POD3, \n");
		query.append("                      MDM_LOCATION    POL4, \n");
		query.append("                      MDM_LOCATION    POD4, \n");
		query.append("                    ( \n");
		query.append("                          SELECT \n");
		query.append("                                 FRT.BKG_NO, \n");
		query.append("                                 FRT.BKG_PPD_FRT_AMT, \n");
		query.append("                                 FRT.BKG_PPD_OTR_AMT, \n");
		query.append("                                 FRT.BKG_CLT_FRT_AMT, \n");
		query.append("                                 FRT.BKG_CLT_OTR_AMT, \n");
		query.append("                                 BCS.CUST_CNT_CD                                AS SHPR_CNT_CD, \n");
		query.append("                                 BCS.CUST_SEQ                                   AS SHPR_SEQ, \n");
		query.append("                                 BC2.CUST_CNT_CD                                AS FRT_FWRD_CNT_CD, \n");
		query.append("                                 BC2.CUST_SEQ                                   AS FRT_FWRD_SEQ, \n");
		query.append("                               ( \n");
		query.append("                                     SELECT \n");
		query.append("                                            MAX (CUST_REF_NO_CTNT) \n");
		query.append("                                       FROM BKG_REFERENCE FMC \n");
		query.append("                                      WHERE FMC.BKG_NO        = BCS.BKG_NO \n");
		query.append("                                        AND FMC.BKG_REF_TP_CD = 'FMCN' \n");
		query.append("                                        AND ROWNUM            = 1 \n");
		query.append("                               )                                                AS FMC_NO, \n");
		query.append("                               ( \n");
		query.append("                                     SELECT \n");
		query.append("                                            MCS.FRT_FWRD_FMC_NO \n");
		query.append("                                       FROM MDM_CUSTOMER MCS \n");
		query.append("                                      WHERE MCS.CUST_CNT_CD          = BC2.CUST_CNT_CD \n");
		query.append("                                        AND MCS.CUST_SEQ             = BC2.CUST_SEQ \n");
		query.append("                                        AND MCS.RVIS_CNTR_CUST_TP_CD = 'N' \n");
		query.append("                                        AND ROWNUM                   = 1 \n");
		query.append("                               )                                                AS FMC_NO_MDM, \n");
		query.append("                               ( \n");
		query.append("                                     SELECT \n");
		query.append("                                            INF.FMC_NO \n");
		query.append("                                       FROM AGT_COMM_BKG_INFO INF \n");
		query.append("                                      WHERE INF.BKG_NO = BCS.BKG_NO \n");
		query.append("                               )                                                AS FMC_NO_PREV, \n");
		query.append("                                 NVL(BC2.REF_NO, '*')                           AS REFERENCE_NO, \n");
		query.append("                            CASE BCS.CUST_CNT_CD||BCS.CUST_SEQ \n");
		query.append("                            WHEN BC2.CUST_CNT_CD||BC2.CUST_SEQ \n");
		query.append("                            THEN 1 \n");
		query.append("                            ELSE 0 \n");
		query.append("                             END                                                AS SH_FF_CHECK_FLAG, \n");
		query.append("                            CASE \n");
		query.append("                            WHEN LTRIM (BC2.CUST_CNT_CD) IS NULL \n");
		query.append("                            THEN 1 \n");
		query.append("                            ELSE 0 \n");
		query.append("                             END                                                AS FF_CHECK \n");
		query.append("                            FROM BKG_CUSTOMER BCS, \n");
		query.append("                                 BKG_CUSTOMER BC2, \n");
		query.append("                               ( \n");
		query.append("                                     SELECT \n");
		query.append("                                            INP.BKG_NO, \n");
		query.append("                                            SUM \n");
		query.append("                                          ( \n");
		query.append("                                       CASE \n");
		query.append("                                       WHEN BCR.FRT_TERM_CD = 'P' \n");
		query.append("                                        AND BCR.CHG_CD      = 'OFT' \n");
		query.append("                                        AND BCR.CURR_CD     = 'USD' \n");
		query.append("                                       THEN BCR.CHG_AMT \n");
		query.append("                                       WHEN BCR.FRT_TERM_CD = 'P' \n");
		query.append("                                        AND BCR.CHG_CD      = 'OFT' \n");
		query.append("                                        AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0 \n");
		query.append("                                       THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT \n");
		query.append("                                       ELSE 0 \n");
		query.append("                                        END \n");
		query.append("                                          )                                      AS BKG_PPD_FRT_AMT, \n");
		query.append("                                            SUM \n");
		query.append("                                          ( \n");
		query.append("                                       CASE \n");
		query.append("                                       WHEN BCR.FRT_TERM_CD = 'P' \n");
		query.append("                                        AND BCR.CHG_CD      = 'OFT' \n");
		query.append("                                       THEN 0 \n");
		query.append("                                       WHEN BCR.FRT_TERM_CD = 'P' \n");
		query.append("                                        AND BCR.CURR_CD     = 'USD' \n");
		query.append("                                       THEN BCR.CHG_AMT \n");
		query.append("                                       WHEN BCR.FRT_TERM_CD = 'P' \n");
		query.append("                                        AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0 \n");
		query.append("                                       THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT \n");
		query.append("                                       ELSE 0 \n");
		query.append("                                        END \n");
		query.append("                                          )                                      AS BKG_PPD_OTR_AMT, \n");
		query.append("                                            SUM \n");
		query.append("                                          ( \n");
		query.append("                                       CASE \n");
		query.append("                                       WHEN BCR.FRT_TERM_CD = 'C' \n");
		query.append("                                        AND BCR.CHG_CD      = 'OFT' \n");
		query.append("                                        AND BCR.CURR_CD     = 'USD' \n");
		query.append("                                       THEN BCR.CHG_AMT \n");
		query.append("                                       WHEN BCR.FRT_TERM_CD = 'C' \n");
		query.append("                                        AND BCR.CHG_CD      = 'OFT' \n");
		query.append("                                        AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0 \n");
		query.append("                                       THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT \n");
		query.append("                                       ELSE 0 \n");
		query.append("                                        END \n");
		query.append("                                          )                                      AS BKG_CLT_FRT_AMT, \n");
		query.append("                                            SUM \n");
		query.append("                                          ( \n");
		query.append("                                       CASE \n");
		query.append("                                       WHEN BCR.FRT_TERM_CD = 'C' \n");
		query.append("                                        AND BCR.CHG_CD      = 'OFT' \n");
		query.append("                                       THEN 0 \n");
		query.append("                                       WHEN BCR.FRT_TERM_CD = 'C' \n");
		query.append("                                        AND BCR.CURR_CD     = 'USD' \n");
		query.append("                                       THEN BCR.CHG_AMT \n");
		query.append("                                       WHEN BCR.FRT_TERM_CD = 'C' \n");
		query.append("                                        AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0 \n");
		query.append("                                       THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT \n");
		query.append("                                       ELSE 0 \n");
		query.append("                                        END \n");
		query.append("                                          )                                      AS BKG_CLT_OTR_AMT \n");
		query.append("                                       FROM BKG_BOOKING   BKG, \n");
		query.append("                                            BKG_CHG_RT    BCR, \n");
		query.append("                                            GL_MON_XCH_RT MXR, \n");
		query.append("                                          ( \n");
		query.append("                                                SELECT \n");
		query.append("                                                       ? --:BKG_NO \n");
		query.append("                                                       AS BKG_NO \n");
		query.append("                                                   FROM DUAL \n");
		query.append("                                          ) INP \n");
		query.append("                                      WHERE BKG.BKG_NO               = INP.BKG_NO \n");
		query.append("                                        AND BCR.BKG_NO               = INP.BKG_NO \n");
		query.append("                                        AND BCR.FRT_INCL_XCLD_DIV_CD = 'N' \n");
		query.append("                                        AND BCR.CURR_CD              = MXR.CURR_CD \n");
		query.append("                                        AND MXR.ACCT_XCH_RT_LVL      = '1' \n");
		query.append("                                        AND MXR.ACCT_XCH_RT_YRMON \n");
		query.append("                                         IN \n");
		query.append("                                          ( \n");
		query.append("                                                SELECT \n");
		query.append("                                                  CASE \n");
		query.append("                                                  WHEN RAT.RT_APLY_DT IS NOT NULL \n");
		query.append("                                                  THEN TO_CHAR (LEAST (RAT.RT_APLY_DT, SYSDATE), 'YYYYMM') \n");
		query.append("                                                  WHEN RAT.RT_APLY_DT IS NULL \n");
		query.append("                                                   AND \n");
		query.append("                                                     ( \n");
		query.append("                                                           SELECT \n");
		query.append("                                                                  NVL (SUM (CNTR_VOL_QTY), 0) \n");
		query.append("                                                             FROM BKG_CONTAINER BCN \n");
		query.append("                                                            WHERE BCN.BKG_NO = BKG.BKG_NO \n");
		query.append("                                                     ) \n");
		query.append("                                                     = \n");
		query.append("                                                     ( \n");
		query.append("                                                           SELECT \n");
		query.append("                                                                  NVL (SUM (QTY.OP_CNTR_QTY), 0) \n");
		query.append("                                                             FROM BKG_QUANTITY QTY \n");
		query.append("                                                            WHERE QTY.BKG_NO = BKG.BKG_NO \n");
		query.append("                                                              AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");
		query.append("                                                     ) \n");
		query.append("                                                   AND SUBSTR (BKG.POR_CD, 1, 2) = 'US' \n");
		query.append("                                                    OR SUBSTR (BKG.POR_CD, 1, 2) = 'MX' \n");
		query.append("                                                    OR SUBSTR (BKG.POR_CD, 1, 2) = 'CA' \n");
		query.append("                                                    OR SUBSTR (BKG.POR_CD, 1, 2) = 'BR' \n");
		query.append("                                                    OR SUBSTR (BKG.DEL_CD, 1, 2) = 'US' \n");
		query.append("                                                    OR SUBSTR (BKG.DEL_CD, 1, 2) = 'MX' \n");
		query.append("                                                    OR SUBSTR (BKG.DEL_CD, 1, 2) = 'CA' \n");
		query.append("                                                    OR SUBSTR (BKG.DEL_CD, 1, 2) = 'BR' \n");
		query.append("                                                  THEN \n");
		query.append("                                                     ( \n");
		query.append("                                                           SELECT \n");
		query.append("                                                             CASE \n");
		query.append("                                                             WHEN MAX (BCN.CGO_RCV_DT) IS NULL \n");
		query.append("                                                             THEN TO_CHAR (SYSDATE, 'YYYYMM') \n");
		query.append("                                                             ELSE TO_CHAR (LEAST (MAX (BCN.CGO_RCV_DT), SYSDATE), 'YYYYMM') \n");
		query.append("                                                              END RT_APLY_DT \n");
		query.append("                                                             FROM BKG_CONTAINER BCN \n");
		query.append("                                                            WHERE BCN.BKG_NO = BKG.BKG_NO \n");
		query.append("                                                     ) \n");
		query.append("                                                  ELSE \n");
		query.append("                                                     ( \n");
		query.append("                                                           SELECT \n");
		query.append("                                                                   TO_CHAR (LEAST (MAX (VSK.INIT_ETD_DT), SYSDATE), 'YYYYMM') \n");
		query.append("                                                             FROM BKG_VVD          VVD, \n");
		query.append("                                                                  VSK_VSL_PORT_SKD VSK \n");
		query.append("                                                            WHERE VVD.BKG_NO       = BKG.BKG_NO \n");
		query.append("                                                              AND VVD.POL_CD       = BKG.POL_CD \n");
		query.append("                                                              AND VVD.VSL_CD       = VSK.VSL_CD \n");
		query.append("                                                              AND VVD.SKD_VOY_NO   = VSK.SKD_VOY_NO \n");
		query.append("                                                              AND VVD.SKD_DIR_CD   = VSK.SKD_DIR_CD \n");
		query.append("                                                              AND VVD.POL_CD       = VSK.VPS_PORT_CD \n");
		query.append("                                                     ) \n");
		query.append("                                                   END AS RT_APLY_DT \n");
		query.append("                                                  FROM BKG_RATE    RAT \n");
		query.append("                                                 WHERE BKG.BKG_NO = RAT.BKG_NO \n");
		query.append("                                                   AND ROWNUM = 1 \n");
		query.append("                                          ) \n");
		query.append("                               ) FRT \n");
		query.append("                           WHERE BC2.BKG_CUST_TP_CD (+) = 'F' \n");
		query.append("                             AND BCS.BKG_CUST_TP_CD (+) = 'S' \n");
		query.append("                             AND BC2.BKG_NO         (+) = BCS.BKG_NO \n");
		query.append("                             AND BCS.BKG_NO         (+) = FRT.BKG_NO \n");
		query.append("                    ) CST \n");
		query.append("                WHERE BKG.BKG_NO      = CST.BKG_NO \n");
		query.append("                  AND BKG.POL_CD      = POL.LOC_CD  (+) \n");
		query.append("                  AND BKG.POD_CD      = POD.LOC_CD  (+) \n");
		query.append("                  AND VV1.BKG_NO      = BKG.BKG_NO \n");
		query.append("                  AND VV1.POL_CD      = BKG.POL_CD \n");
		query.append("                  AND VV1.BKG_NO      = VV2.BKG_NO  (+) \n");
		query.append("                  AND VV2.BKG_NO      = VV3.BKG_NO  (+) \n");
		query.append("                  AND VV3.BKG_NO      = VV4.BKG_NO  (+) \n");
		query.append("                  AND VV1.POL_CD      = VV2.POD_CD  (+) \n");
		query.append("                  AND VV2.POL_CD      = VV3.POD_CD  (+) \n");
		query.append("                  AND VV3.POL_CD      = VV4.POD_CD  (+) \n");
		query.append("                  AND VV1.POL_CD      = POL1.LOC_CD (+) \n");
		query.append("                  AND VV2.POL_CD      = POL2.LOC_CD (+) \n");
		query.append("                  AND VV3.POL_CD      = POL3.LOC_CD (+) \n");
		query.append("                  AND VV4.POL_CD      = POL4.LOC_CD (+) \n");
		query.append("                  AND VV1.POD_CD      = POD1.LOC_CD (+) \n");
		query.append("                  AND VV2.POD_CD      = POD2.LOC_CD (+) \n");
		query.append("                  AND VV3.POD_CD      = POD3.LOC_CD (+) \n");
		query.append("                  AND VV4.POD_CD      = POD4.LOC_CD (+) \n");
		query.append("                  AND VV1.VSL_SEQ    <= '1' \n");
		query.append("                  AND VV1.VSL_PRE_PST_CD \n");
		query.append("                   IN \n");
		query.append("                    ( \n");
		query.append("                 CASE \n");
		query.append("                 WHEN EXISTS \n");
		query.append("                    ( \n");
		query.append("                          SELECT \n");
		query.append("                                 1 \n");
		query.append("                            FROM BKG_VVD VV0 \n");
		query.append("                           WHERE VV0.VSL_PRE_PST_CD = 'S' \n");
		query.append("                             AND VV0.BKG_NO         = BKG.BKG_NO \n");
		query.append("                    ) \n");
		query.append("                 THEN 'S' \n");
		query.append("                 ELSE 'T' \n");
		query.append("                  END \n");
		query.append("                    ) \n");
		query.append("                  AND VV1.VSL_PRE_PST_CD \n");
		query.append("                    = \n");
		query.append("                    ( \n");
		query.append("                 CASE \n");
		query.append("                 WHEN VV2.VSL_PRE_PST_CD (+) = 'T' \n");
		query.append("                  AND VV1.VSL_SEQ < NVL \n");
		query.append("                    ( \n");
		query.append("                    ( \n");
		query.append("                          SELECT \n");
		query.append("                                 MAX (VV0.VSL_SEQ) \n");
		query.append("                            FROM BKG_VVD VV0 \n");
		query.append("                           WHERE VV0.VSL_PRE_PST_CD = 'S' \n");
		query.append("                             AND VV0.BKG_NO         = BKG.BKG_NO \n");
		query.append("                    ) \n");
		query.append("                    , 0 \n");
		query.append("                    ) \n");
		query.append("                 THEN 'X' \n");
		query.append("                 WHEN VV2.VSL_PRE_PST_CD (+) = 'T' \n");
		query.append("                 THEN 'S' \n");
		query.append("                 WHEN VV2.VSL_PRE_PST_CD (+) = 'S' \n");
		query.append("                 THEN 'S' \n");
		query.append("                 WHEN VV2.VSL_PRE_PST_CD (+) = 'U' \n");
		query.append("                  AND VV2.VSL_SEQ (+)        = '1' \n");
		query.append("                 THEN 'T' \n");
		query.append("                 WHEN VV2.VSL_PRE_PST_CD (+) = 'U' \n");
		query.append("                  AND VV2.VSL_SEQ (+)       <> '1' \n");
		query.append("                 THEN 'U' \n");
		query.append("                 ELSE VV1.VSL_PRE_PST_CD \n");
		query.append("                  END \n");
		query.append("                    ) \n");
		query.append("                  AND VV2.VSL_PRE_PST_CD \n");
		query.append("                    = \n");
		query.append("                    ( \n");
		query.append("                 CASE \n");
		query.append("                 WHEN VV3.VSL_PRE_PST_CD (+) = 'S' \n");
		query.append("                 THEN 'S' \n");
		query.append("                 WHEN VV3.VSL_PRE_PST_CD (+) = 'T' \n");
		query.append("                 THEN 'S' \n");
		query.append("                 WHEN VV3.VSL_PRE_PST_CD (+) = 'U' \n");
		query.append("                  AND VV3.VSL_SEQ (+)        = '1' \n");
		query.append("                 THEN 'T' \n");
		query.append("                 WHEN VV3.VSL_PRE_PST_CD (+) = 'U' \n");
		query.append("                  AND VV3.VSL_SEQ (+)       <> '1' \n");
		query.append("                 THEN 'U' \n");
		query.append("                 ELSE VV2.VSL_PRE_PST_CD \n");
		query.append("                  END \n");
		query.append("                    ) \n");
		query.append("                  AND VV3.VSL_PRE_PST_CD \n");
		query.append("                    = \n");
		query.append("                    ( \n");
		query.append("                 CASE \n");
		query.append("                 WHEN VV4.VSL_PRE_PST_CD (+) = 'T' \n");
		query.append("                 THEN 'S' \n");
		query.append("                 WHEN VV4.VSL_PRE_PST_CD (+) = 'U' \n");
		query.append("                  AND VV4.VSL_SEQ (+)        = '1' \n");
		query.append("                 THEN 'T' \n");
		query.append("                 WHEN VV4.VSL_PRE_PST_CD (+) = 'U' \n");
		query.append("                  AND VV4.VSL_SEQ (+)       <> '1' \n");
		query.append("                 THEN 'U' \n");
		query.append("                 ELSE VV3.VSL_PRE_PST_CD \n");
		query.append("                  END \n");
		query.append("                    ) \n");
		query.append("                  AND VV2.VSL_SEQ \n");
		query.append("                    = \n");
		query.append("                    ( \n");
		query.append("                 CASE \n");
		query.append("                 WHEN VV3.VSL_PRE_PST_CD (+) = 'S' \n");
		query.append("                 THEN VV3.VSL_SEQ (+) - 1 \n");
		query.append("                 WHEN VV3.VSL_PRE_PST_CD (+) = 'U' \n");
		query.append("                 THEN VV3.VSL_SEQ (+) - 1 \n");
		query.append("                 ELSE VV2.VSL_SEQ \n");
		query.append("                  END \n");
		query.append("                    ) \n");
		query.append("                  AND VV3.VSL_SEQ \n");
		query.append("                    = \n");
		query.append("                    ( \n");
		query.append("                 CASE \n");
		query.append("                 WHEN VV4.VSL_PRE_PST_CD (+) = 'S' \n");
		query.append("                 THEN VV4.VSL_SEQ (+) - 1 \n");
		query.append("                 WHEN VV4.VSL_PRE_PST_CD (+) = 'U' \n");
		query.append("                 THEN VV4.VSL_SEQ (+) - 1 \n");
		query.append("                 ELSE VV3.VSL_SEQ \n");
		query.append("                  END \n");
		query.append("                    ) \n");
		query.append("         ) PSD \n");
		query.append("        ON \n");
		query.append("         ( \n");
		query.append("           TBL.BKG_NO = PSD.BKG_NO \n");
		query.append("         ) \n");
		query.append("      WHEN MATCHED \n");
		query.append("      THEN \n");
		query.append("               UPDATE \n");
		query.append("                  SET TBL.COMM_PROC_RSLT_RSN = PSD.COMM_PROC_RSLT_RSN, \n");
		query.append("                      TBL.BL_NO              = PSD.BL_NO, \n");
		query.append("                      TBL.BKG_CGO_TP_CD      = PSD.BKG_CGO_TP_CD, \n");
		query.append("                      TBL.BKG_STS_CD         = PSD.BKG_STS_CD, \n");
		query.append("                      TBL.SHPR_CNT_CD        = PSD.SHPR_CNT_CD, \n");
		query.append("                      TBL.SHPR_SEQ           = PSD.SHPR_SEQ, \n");
		query.append("                      TBL.FRT_FWRD_CNT_CD    = PSD.FRT_FWRD_CNT_CD, \n");
		query.append("                      TBL.FRT_FWRD_SEQ       = PSD.FRT_FWRD_SEQ, \n");
		query.append("                      TBL.RLANE_CD           = PSD.RLANE_CD, \n");
		query.append("                      TBL.REV_VVD_CD         = CASE WHEN PSD.WDR_CHK = 1 AND PSD.TRNK_VSL_CD IN ('HJXX', 'HJYY', 'HJZZ') THEN 'CNTC'||TO_CHAR (SYSDATE, 'YYMM')||'MM'  ELSE PSD.REV_VVD_CD END, \n");
		query.append("                      TBL.TRNK_SLAN_CD       = PSD.TRNK_SLAN_CD, \n");
		query.append("                      TBL.TRNK_RLANE_CD      = PSD.TRNK_RLANE_CD, \n");
		query.append("                      TBL.TRNK_VSL_CD        = PSD.TRNK_VSL_CD, \n");
		query.append("                      TBL.TRNK_SKD_VOY_NO    = PSD.TRNK_SKD_VOY_NO, \n");
		query.append("                      TBL.TRNK_SKD_DIR_CD    = PSD.TRNK_SKD_DIR_CD, \n");
		query.append("                      TBL.TRNK_REV_DIR_CD    = PSD.TRNK_REV_DIR_CD, \n");
		query.append("                      TBL.SVC_SCP_CD         = PSD.SVC_SCP_CD, \n");
		query.append("                      TBL.BKG_CA_NO          = PSD.BKG_CA_NO, \n");
		query.append("                      TBL.BKG_CA_DT          = PSD.BKG_CA_DT, \n");
		query.append("                      TBL.TRD_CD             = PSD.TRD_CD, \n");
		query.append("                      TBL.BKG_POR_CD         = PSD.BKG_POR_CD, \n");
		query.append("                      TBL.BKG_POL_CD         = PSD.BKG_POL_CD, \n");
		query.append("                      TBL.BKG_POD_CD         = PSD.BKG_POD_CD, \n");
		query.append("                      TBL.BKG_DEL_CD         = PSD.BKG_DEL_CD, \n");
		query.append("                      TBL.BKG_RCV_TERM_CD    = PSD.BKG_RCV_TERM_CD, \n");
		query.append("                      TBL.BKG_DE_TERM_CD     = PSD.BKG_DE_TERM_CD, \n");
		query.append("                      TBL.PRE_PORT_CD        = PSD.PRE_PORT_CD, \n");
		query.append("                      TBL.PST_PORT_CD        = PSD.PST_PORT_CD, \n");
		query.append("                      TBL.FMC_NO             = PSD.FMC_NO, \n");
		query.append("                      TBL.REP_CMDT_CD        = PSD.REP_CMDT_CD, \n");
		query.append("                      TBL.CMDT_CD            = PSD.CMDT_CD, \n");
		query.append("                      TBL.SC_NO              = PSD.SC_NO, \n");
		query.append("                      TBL.RFA_NO             = PSD.RFA_NO, \n");
		query.append("                      TBL.BKG_PPD_FRT_AMT    = PSD.BKG_PPD_FRT_AMT, \n");
		query.append("                      TBL.BKG_PPD_OTR_AMT    = PSD.BKG_PPD_OTR_AMT, \n");
		query.append("                      TBL.BKG_CLT_FRT_AMT    = PSD.BKG_CLT_FRT_AMT, \n");
		query.append("                      TBL.BKG_CLT_OTR_AMT    = PSD.BKG_CLT_OTR_AMT, \n");
		query.append("                      TBL.SPCL_DG_CGO_FLG    = PSD.SPCL_DG_CGO_FLG, \n");
		query.append("                      TBL.SPCL_RC_FLG        = PSD.SPCL_RC_FLG, \n");
		query.append("                      TBL.SPCL_AWK_CGO_FLG   = PSD.SPCL_AWK_CGO_FLG, \n");
		query.append("                      TBL.SPCL_BB_CGO_FLG    = PSD.SPCL_BB_CGO_FLG, \n");
		query.append("                      TBL.SPCL_RD_CGO_FLG    = PSD.SPCL_RD_CGO_FLG, \n");
		query.append("                      TBL.BKG_OFC_CD         = PSD.BKG_OFC_CD, \n");
		query.append("                      TBL.SLS_OFC_CD         = PSD.SLS_OFC_CD, \n");
		query.append("                      TBL.RHQ_CD             = PSD.RHQ_CD, \n");
		query.append("                      TBL.BKG_SOC_FLG        = PSD.BKG_SOC_FLG, \n");
		query.append("                      TBL.BKG_DBL_FLG        = PSD.BKG_DBL_FLG, \n");
		query.append("                      TBL.BKG_CRE_DT         = PSD.BKG_CRE_DT, \n");
		query.append("                      TBL.ESTM_IOC_DIV_CD    = PSD.ESTM_IOC_DIV_CD, \n");
		query.append("                      TBL.UPD_DT             = PSD.UPD_DT \n");
		query.append("      WHEN NOT MATCHED \n");
		query.append("      THEN \n");
		query.append("               INSERT \n");
		query.append("                    ( \n");
		query.append("                      TBL.BKG_NO, \n");
		query.append("                      TBL.COMM_PROC_RSLT_RSN, \n");
		query.append("                      TBL.BL_NO, \n");
		query.append("                      TBL.BKG_CGO_TP_CD, \n");
		query.append("                      TBL.BKG_STS_CD, \n");
		query.append("                      TBL.SHPR_CNT_CD, \n");
		query.append("                      TBL.SHPR_SEQ, \n");
		query.append("                      TBL.FRT_FWRD_CNT_CD, \n");
		query.append("                      TBL.FRT_FWRD_SEQ, \n");
		query.append("                      TBL.RLANE_CD, \n");
		query.append("                      TBL.REV_VVD_CD, \n");
		query.append("                      TBL.TRNK_SLAN_CD, \n");
		query.append("                      TBL.TRNK_RLANE_CD, \n");
		query.append("                      TBL.TRNK_VSL_CD, \n");
		query.append("                      TBL.TRNK_SKD_VOY_NO, \n");
		query.append("                      TBL.TRNK_SKD_DIR_CD, \n");
		query.append("                      TBL.TRNK_REV_DIR_CD, \n");
		query.append("                      TBL.SVC_SCP_CD, \n");
		query.append("                      TBL.BKG_CA_NO, \n");
		query.append("                      TBL.BKG_CA_DT, \n");
		query.append("                      TBL.TRD_CD, \n");
		query.append("                      TBL.BKG_POR_CD, \n");
		query.append("                      TBL.BKG_POL_CD, \n");
		query.append("                      TBL.BKG_POD_CD, \n");
		query.append("                      TBL.BKG_DEL_CD, \n");
		query.append("                      TBL.BKG_RCV_TERM_CD, \n");
		query.append("                      TBL.BKG_DE_TERM_CD, \n");
		query.append("                      TBL.PRE_PORT_CD, \n");
		query.append("                      TBL.PST_PORT_CD, \n");
		query.append("                      TBL.FMC_NO, \n");
		query.append("                      TBL.REP_CMDT_CD, \n");
		query.append("                      TBL.CMDT_CD, \n");
		query.append("                      TBL.SC_NO, \n");
		query.append("                      TBL.RFA_NO, \n");
		query.append("                      TBL.BKG_PPD_FRT_AMT, \n");
		query.append("                      TBL.BKG_PPD_OTR_AMT, \n");
		query.append("                      TBL.BKG_CLT_FRT_AMT, \n");
		query.append("                      TBL.BKG_CLT_OTR_AMT, \n");
		query.append("                      TBL.SPCL_DG_CGO_FLG, \n");
		query.append("                      TBL.SPCL_RC_FLG, \n");
		query.append("                      TBL.SPCL_AWK_CGO_FLG, \n");
		query.append("                      TBL.SPCL_BB_CGO_FLG, \n");
		query.append("                      TBL.SPCL_RD_CGO_FLG, \n");
		query.append("                      TBL.BKG_OFC_CD, \n");
		query.append("                      TBL.SLS_OFC_CD, \n");
		query.append("                      TBL.RHQ_CD, \n");
		query.append("                      TBL.BKG_SOC_FLG, \n");
		query.append("                      TBL.BKG_DBL_FLG, \n");
		query.append("                      TBL.BKG_CRE_DT, \n");
		query.append("                      TBL.ESTM_IOC_DIV_CD, \n");
		query.append("                      TBL.UPD_USR_ID, \n");
		query.append("                      TBL.UPD_DT, \n");
		query.append("                      TBL.CRE_USR_ID, \n");
		query.append("                      TBL.CRE_DT \n");
		query.append("                    ) \n");
		query.append("               VALUES \n");
		query.append("                    ( \n");
		query.append("                      PSD.BKG_NO, \n");
		query.append("                      PSD.COMM_PROC_RSLT_RSN, \n");
		query.append("                      PSD.BL_NO, \n");
		query.append("                      PSD.BKG_CGO_TP_CD, \n");
		query.append("                      PSD.BKG_STS_CD, \n");
		query.append("                      PSD.SHPR_CNT_CD, \n");
		query.append("                      PSD.SHPR_SEQ, \n");
		query.append("                      PSD.FRT_FWRD_CNT_CD, \n");
		query.append("                      PSD.FRT_FWRD_SEQ, \n");
		query.append("                      PSD.RLANE_CD, \n");
		query.append("                      CASE WHEN PSD.WDR_CHK = 1 AND PSD.TRNK_VSL_CD IN ('HJXX', 'HJYY', 'HJZZ') THEN 'CNTC'||TO_CHAR (SYSDATE, 'YYMM')||'MM'  ELSE PSD.REV_VVD_CD END, \n");
		query.append("                      PSD.TRNK_SLAN_CD, \n");
		query.append("                      PSD.TRNK_RLANE_CD, \n");
		query.append("                      PSD.TRNK_VSL_CD, \n");
		query.append("                      PSD.TRNK_SKD_VOY_NO, \n");
		query.append("                      PSD.TRNK_SKD_DIR_CD, \n");
		query.append("                      PSD.TRNK_REV_DIR_CD, \n");
		query.append("                      PSD.SVC_SCP_CD, \n");
		query.append("                      PSD.BKG_CA_NO, \n");
		query.append("                      PSD.BKG_CA_DT, \n");
		query.append("                      PSD.TRD_CD, \n");
		query.append("                      PSD.BKG_POR_CD, \n");
		query.append("                      PSD.BKG_POL_CD, \n");
		query.append("                      PSD.BKG_POD_CD, \n");
		query.append("                      PSD.BKG_DEL_CD, \n");
		query.append("                      PSD.BKG_RCV_TERM_CD, \n");
		query.append("                      PSD.BKG_DE_TERM_CD, \n");
		query.append("                      PSD.PRE_PORT_CD, \n");
		query.append("                      PSD.PST_PORT_CD, \n");
		query.append("                      PSD.FMC_NO, \n");
		query.append("                      PSD.REP_CMDT_CD, \n");
		query.append("                      PSD.CMDT_CD, \n");
		query.append("                      PSD.SC_NO, \n");
		query.append("                      PSD.RFA_NO, \n");
		query.append("                      PSD.BKG_PPD_FRT_AMT, \n");
		query.append("                      PSD.BKG_PPD_OTR_AMT, \n");
		query.append("                      PSD.BKG_CLT_FRT_AMT, \n");
		query.append("                      PSD.BKG_CLT_OTR_AMT, \n");
		query.append("                      PSD.SPCL_DG_CGO_FLG, \n");
		query.append("                      PSD.SPCL_RC_FLG, \n");
		query.append("                      PSD.SPCL_AWK_CGO_FLG, \n");
		query.append("                      PSD.SPCL_BB_CGO_FLG, \n");
		query.append("                      PSD.SPCL_RD_CGO_FLG, \n");
		query.append("                      PSD.BKG_OFC_CD, \n");
		query.append("                      PSD.SLS_OFC_CD, \n");
		query.append("                      PSD.RHQ_CD, \n");
		query.append("                      PSD.BKG_SOC_FLG, \n");
		query.append("                      PSD.BKG_DBL_FLG, \n");
		query.append("                      PSD.BKG_CRE_DT, \n");
		query.append("                      PSD.ESTM_IOC_DIV_CD, \n");
		query.append("                      PSD.UPD_USR_ID, \n");
		query.append("                      PSD.UPD_DT, \n");
		query.append("                      PSD.CRE_USR_ID, \n");
		query.append("                      PSD.CRE_DT \n");
		query.append("                    ) \n");
		
		try
		{
			ps = new LoggableStatement(con, query.toString());
			ps.setString(i++, comm_proc_rslt_rsn);	//comm_proc_rslt_rsn
			ps.setString(i++, bkg_no);				//bkg_no

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();
			
			// DB 로그 테이블에 저장한다.
//			this.createLog("===== ERROR AGT Actual - BKG_NO : "+ bkg_no +", BKG_NO_SPLIT : "+ bkg_no_split +", COMM_PROC_RSLT_RSN : "+ comm_proc_rslt_rsn);
			
		}
		catch (SQLException e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		}
		catch (Exception e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		}
		finally
		{
			closeStatement(ps);
		}
	}
	
	/**
	 * Error 발생시 Brokerage Commission 테이블에 Error 정보를 저장한다.<br>
	 * 
	 * @param con Connection
	 * @param bkgMap HashMap Booking 정보를 담고있는 HashMap
	 * @throws SQLException, Exception
	 */
	private void createBRKGCommErrorMSG( Connection con, HashMap brogMap) throws SQLException, Exception {
		
		log.debug("\n\n createBRKGCommErrorMSG 메소드 시작 ========================================\n");
		
//		String bkg_no = (String)brogMap.get("BKG_NO");
//		String bkg_no_split = (String)brogMap.get("BKG_NO_SPLIT");
//		String comm_proc_sts_cd = (String)brogMap.get("COMM_PROC_STS_CD");
//		String comm_proc_rslt_rsn = (String)brogMap.get("COMM_PROC_RSLT_RSN");
//		String cre_usr_id = checkNull((String)brogMap.get("FLG0507"));
//		String unit_cost = "UNIT COST";
		// Error INSERT/UPDATE를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		PreparedStatement updatePs  = null;
		PreparedStatement insertPs  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// 저장쿼리
		StringBuffer query = new StringBuffer();
		StringBuffer updateQuery01 = new StringBuffer();
		StringBuffer insertQuery01 = new StringBuffer();
		
		query.append("MERGE INTO agt_brog_comm a \n");
		query.append("USING ( SELECT ? bkg_no, ? brog_seq, ? comm_proc_sts_cd, ? comm_proc_rslt_rsn, \n");
		query.append("				 TO_DATE (?, 'yyyyMMddHH24miss') vsl_dep_dt, \n");
		query.append("				 ? frt_fwrd_cnt_cd, ? frt_fwrd_seq, \n");
		query.append("				 0 act_pre_comm_amt, 0 act_comm_amt, 0 act_if_comm_amt, 'COMMISSION' upd_usr_id, SYSDATE upd_dt, 'COMMISSION' cre_usr_id, SYSDATE cre_dt \n");
		query.append("	  	  FROM dual \n");
		query.append("	    ) b \n");
		query.append("ON ( a.bkg_no = b.bkg_no AND a.brog_seq = b.brog_seq) \n");
		query.append("WHEN MATCHED THEN \n");
		query.append("	 UPDATE SET a.comm_proc_sts_cd = b.comm_proc_sts_cd, a.comm_proc_rslt_rsn = b.comm_proc_rslt_rsn, \n");
		query.append("	 			a.vsl_dep_dt = b.vsl_dep_dt, \n");
		query.append("	 			a.frt_fwrd_cnt_cd = b.frt_fwrd_cnt_cd, a.frt_fwrd_seq = b.frt_fwrd_seq, a.upd_dt = b.upd_dt \n");
		query.append("WHEN NOT MATCHED THEN \n");
		query.append("	 INSERT (a.bkg_no, a.brog_seq, a.comm_proc_sts_cd, a.comm_proc_rslt_rsn, \n");
		query.append("	 		 a.act_pre_comm_amt, a.act_comm_amt, a.act_if_comm_amt, \n");
		query.append("	 		 a.vsl_dep_dt, a.frt_fwrd_cnt_cd, a.frt_fwrd_seq, a.upd_usr_id, a.upd_dt, a.cre_usr_id, a.cre_dt) " + "\n");
		query.append("	 VALUES (b.bkg_no, b.brog_seq, b.comm_proc_sts_cd, b.comm_proc_rslt_rsn, \n");
		query.append("	 		 b.act_pre_comm_amt, b.act_comm_amt, b.act_if_comm_amt, \n");
		query.append("	 		 b.vsl_dep_dt, b.frt_fwrd_cnt_cd, b.frt_fwrd_seq, b.upd_usr_id, b.upd_dt, b.cre_usr_id, b.cre_dt) " + "\n");
		
		updateQuery01.append("UPDATE agt_brog_comm a " + "\n");
		updateQuery01.append("   SET (a.act_comm_amt, a.cre_usr_id, a.cre_dt) = " + "\n");
		updateQuery01.append("          (SELECT SUM (e.op_cntr_qty * d.comm_ut_amt) " + "\n");
//		updateQuery01.append("                , 'UNIT COST' " + "\n");
		updateQuery01.append("                , 'COMMISSION' " + "\n");
		updateQuery01.append("                , SYSDATE " + "\n");
		updateQuery01.append("             FROM agt_brog_comm b, agt_otr_ut_cost d, " + "\n");
		updateQuery01.append("                 ( \n");
		updateQuery01.append("                       SELECT \n");
		updateQuery01.append("                              BKG.BKG_NO, \n");
		updateQuery01.append("                              QTY.CNTR_TPSZ_CD, \n");
		updateQuery01.append("                              SUM (QTY.OP_CNTR_QTY) AS OP_CNTR_QTY \n");
		updateQuery01.append("                         FROM BKG_QUANTITY QTY, \n");
		updateQuery01.append("                              BKG_BL_DOC   DOC, \n");
		updateQuery01.append("                              BKG_BOOKING  BKG, \n");
		updateQuery01.append("                              BKG_BOOKING  BK2 \n");
		updateQuery01.append("                        WHERE QTY.BKG_NO                  = DOC.BKG_NO \n");
		updateQuery01.append("                          AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");
		updateQuery01.append("                          AND \n");
		updateQuery01.append("                            ( \n");
		updateQuery01.append("                              BKG.BKG_NO                  = DOC.BKG_NO \n");
		updateQuery01.append("                           OR \n");
		updateQuery01.append("                              BKG.BL_NO                   = DOC.MST_CVRD_BL_NO \n");
		updateQuery01.append("                            ) \n");
		updateQuery01.append("                          AND BK2.BKG_NO                  = DOC.BKG_NO \n");
		updateQuery01.append("                          AND BK2.BL_NO_TP              <>  '9' \n");
		updateQuery01.append("                          AND BK2.BKG_STS_CD            <>  'X' \n");
		updateQuery01.append("                          AND BKG.BKG_NO                  = ? \n");
		updateQuery01.append("                     GROUP BY BKG.BKG_NO, \n");
		updateQuery01.append("                              QTY.CNTR_TPSZ_CD \n");
		updateQuery01.append("                 ) e \n");
		updateQuery01.append("             WHERE b.bkg_no = e.bkg_no " + "\n");
		updateQuery01.append("              AND b.brog_seq = ? " + "\n");
		updateQuery01.append("              AND b.bkg_no = a.bkg_no " + "\n");
		updateQuery01.append("              AND b.ar_ofc_cd = d.ofc_cd " + "\n");
		updateQuery01.append("              AND d.ac_tp_cd = 'B' " + "\n");
		updateQuery01.append("              AND d.io_bnd_cd = 'O' " + "\n");
		updateQuery01.append("              AND d.comm_yrmon = (SELECT MAX (comm_yrmon) " + "\n");
		updateQuery01.append("                                    FROM agt_otr_ut_cost " + "\n");
		updateQuery01.append("                                   WHERE ROWNUM < 2) " + "\n");
		updateQuery01.append("              AND b.bkg_no = e.bkg_no " + "\n");
		updateQuery01.append("              AND d.cntr_tpsz_cd = e.cntr_tpsz_cd) " + "\n");
		updateQuery01.append(" WHERE a.bkg_no = ? " + "\n");
		updateQuery01.append("   AND a.brog_seq = ? " + "\n");

		insertQuery01.append("MERGE INTO agt_brog_comm_dtl a " + "\n");
		insertQuery01.append("   USING (SELECT   b.bkg_no bkg_no " + "\n");
		insertQuery01.append("                 , b.brog_seq brog_seq " + "\n");
		insertQuery01.append("                 , d.cntr_tpsz_cd cntr_tpsz_cd " + "\n");
		insertQuery01.append("                 , SUM (e.op_cntr_qty) bkg_vol_qty " + "\n");
		insertQuery01.append("                 , 'USD' locl_curr_cd " + "\n");
		insertQuery01.append("                 , SUM (e.op_cntr_qty * d.comm_ut_amt) act_usd_comm_amt " + "\n");
//		insertQuery01.append("                 , 'UNIT COST' cre_usr_id " + "\n");
		insertQuery01.append("                 , 'COMMISSION' upd_usr_id " + "\n");
		insertQuery01.append("                 , SYSDATE upd_dt " + "\n");
		insertQuery01.append("                 , 'COMMISSION' cre_usr_id " + "\n");
		insertQuery01.append("                 , SYSDATE cre_dt " + "\n");
		insertQuery01.append("              FROM agt_brog_comm b, agt_otr_ut_cost d, \n");
		insertQuery01.append("                 ( \n");
		insertQuery01.append("                       SELECT \n");
		insertQuery01.append("                              BKG.BKG_NO, \n");
		insertQuery01.append("                              QTY.CNTR_TPSZ_CD, \n");
		insertQuery01.append("                              SUM (QTY.OP_CNTR_QTY) AS OP_CNTR_QTY \n");
		insertQuery01.append("                         FROM BKG_QUANTITY QTY, \n");
		insertQuery01.append("                              BKG_BL_DOC   DOC, \n");
		insertQuery01.append("                              BKG_BOOKING  BKG, \n");
		insertQuery01.append("                              BKG_BOOKING  BK2 \n");
		insertQuery01.append("                        WHERE QTY.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery01.append("                          AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' \n");
		insertQuery01.append("                          AND \n");
		insertQuery01.append("                            ( \n");
		insertQuery01.append("                              BKG.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery01.append("                           OR \n");
		insertQuery01.append("                              BKG.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		insertQuery01.append("                            ) \n");
		insertQuery01.append("                          AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery01.append("                          AND BK2.BL_NO_TP               <>  '9' \n");
		insertQuery01.append("                          AND BK2.BKG_STS_CD             <>  'X' \n");
		insertQuery01.append("                          AND BKG.BKG_NO                   = ? \n");
		insertQuery01.append("                     GROUP BY BKG.BKG_NO, \n");
		insertQuery01.append("                              QTY.CNTR_TPSZ_CD \n");
		insertQuery01.append("                 ) e \n");
		insertQuery01.append("             WHERE b.bkg_no = e.bkg_no " + "\n");
		insertQuery01.append("               AND b.brog_seq = ? " + "\n");
		insertQuery01.append("               AND d.comm_yrmon = (SELECT MAX (comm_yrmon) " + "\n");
		insertQuery01.append("                                     FROM agt_otr_ut_cost " + "\n");
		insertQuery01.append("                                    WHERE ROWNUM < 2) " + "\n");
		insertQuery01.append("               AND b.ar_ofc_cd = d.ofc_cd " + "\n");
		insertQuery01.append("               AND d.io_bnd_cd = 'O' " + "\n");
		insertQuery01.append("               AND d.ac_tp_cd = 'B' " + "\n");
		insertQuery01.append("               AND b.bkg_no = e.bkg_no " + "\n");
		insertQuery01.append("               AND d.cntr_tpsz_cd = e.cntr_tpsz_cd " + "\n");
		insertQuery01.append("          GROUP BY b.bkg_no " + "\n");
		insertQuery01.append("                 , b.brog_seq " + "\n");
		insertQuery01.append("                 , d.cntr_tpsz_cd) b " + "\n");
		insertQuery01.append("   ON (    a.bkg_no = b.bkg_no " + "\n");
		insertQuery01.append("       AND a.brog_seq = b.brog_seq " + "\n");
		insertQuery01.append("       AND a.cntr_tpsz_cd = b.cntr_tpsz_cd) " + "\n");
		insertQuery01.append("   WHEN MATCHED THEN " + "\n");
		insertQuery01.append("      UPDATE " + "\n");
		insertQuery01.append("         SET a.bkg_vol_qty = b.bkg_vol_qty " + "\n");
		insertQuery01.append("           , a.locl_curr_cd = b.locl_curr_cd " + "\n");
		insertQuery01.append("           , a.act_usd_comm_amt = b.act_usd_comm_amt " + "\n");
		insertQuery01.append("   WHEN NOT MATCHED THEN " + "\n");
		insertQuery01.append("      INSERT (a.bkg_no, a.brog_seq " + "\n");
		insertQuery01.append("            , a.cntr_tpsz_cd, a.bkg_vol_qty, a.locl_curr_cd " + "\n");
		insertQuery01.append("            , a.act_usd_comm_amt, a.upd_usr_id, a.upd_dt, a.cre_usr_id, a.cre_dt) " + "\n");
		insertQuery01.append("      VALUES (b.bkg_no, b.brog_seq " + "\n");
		insertQuery01.append("            , b.cntr_tpsz_cd, b.bkg_vol_qty, b.locl_curr_cd " + "\n");
		insertQuery01.append("            , b.act_usd_comm_amt, b.upd_usr_id, b.upd_dt, b.cre_usr_id, b.cre_dt) " + "\n");

		String bkg_no       = checkNull((String)brogMap.get("BKG_NO"));

		
		try
		{
			i = 1;
			ps = new LoggableStatement(con, query.toString());
			ps.setString(i++, (String)brogMap.get("BKG_NO"));					//bkg_no
			ps.setInt(i++, Integer.parseInt((String)brogMap.get("BROG_SEQ")));	//brog_seq
			ps.setString(i++, (String)brogMap.get("COMM_PROC_STS_CD"));			//comm_proc_sts_cd
			ps.setString(i++, (String)brogMap.get("COMM_PROC_RSLT_RSN"));		//comm_proc_rslt_rsn
			ps.setString(i++, (String)brogMap.get("TRUNK_ETD_DT"));				//vsl_dep_dt
			ps.setString(i++, (String)brogMap.get("FRT_FWRD_CNT_CD"));			//frt_fwrd_cnt_cd
			ps.setInt(i++, Integer.parseInt((String)brogMap.get("FRT_FWRD_SEQ")));//frt_fwrd_seq
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();
			
			// agt_brog_comm 테이블에 Update
			updatePs = new LoggableStatement(con, updateQuery01.toString());
			i = 1;
			updatePs.setString(i++, (String)brogMap.get("BKG_NO"));						//bkg_no
			updatePs.setInt(i++, Integer.parseInt((String)brogMap.get("BROG_SEQ")));	//brog_seq
			updatePs.setString(i++, (String)brogMap.get("BKG_NO"));						//bkg_no
			updatePs.setInt(i++, Integer.parseInt((String)brogMap.get("BROG_SEQ")));	//brog_seq
			log.debug("\n SQL1 : \n" + ((LoggableStatement)updatePs).getQueryString());			
			updatePs.executeUpdate();
			
			// agt_brog_comm_dtl 테이블에 Insert
				insertPs = new LoggableStatement(con, insertQuery01.toString());
			i = 1;
			insertPs.setString(i++, (String)brogMap.get("BKG_NO"));						//bkg_no
			insertPs.setInt(i++, Integer.parseInt((String)brogMap.get("BROG_SEQ")));	//brog_seq
			log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs).getQueryString());			
			insertPs.executeUpdate();
			
			// DB 로그 테이블에 저장한다.
//			this.createLog("===== ERROR AGT Actual - BKG_NO : "+ bkg_no +" BKG_NO_SPLIT : "+ bkg_no_split +" COMM_PROC_STS_CD : "+ comm_proc_sts_cd +" COMM_PROC_RSLT_RSN : "+ comm_proc_rslt_rsn);
			
		} catch (SQLException e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} finally {
			closeStatement(ps);
			closeStatement(updatePs);
			closeStatement(insertPs);
		}
	}
	
	/**
	 * 해당 데이타가 null인 경우 공백을 리턴한다.<br>
	 * 
	 * @param str String
	 * @return String 결과값
	 * @throws SQLException, Exception
	 */
	public String checkNull( String str ) {

		if(str == null) {
			str = "";
		}

		return str.trim();
	}
	
	/**
	 * 해당 데이터를 원하는 소수점 짜리로 반올림해서 리턴한다.<br>
	 * 
	 * @param roundValue double
	 * @param c int 소수점 자리수
	 * @return String 결과값
	 * @throws Exception
	 */
	 public double roundValue(double roundValue, int c) {
		 double returnDouble = 0;

		 try{
			 BigDecimal bd = new BigDecimal(roundValue);
			 returnDouble = Double.parseDouble(""+bd.setScale(c, BigDecimal.ROUND_HALF_UP));
		 }catch (Exception e) {
				log.error(e.getMessage(), e);
		 }
         return returnDouble;
	 }
	 
		/**
		 * @param errMsg 
		 * @return String
		 * @throws DAOException
		 */
		public String createLog(String errMsg) throws DAOException {
			Connection con = null; // Connection Interface 
			CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
		
			StringBuffer strBuf = new StringBuffer();
			strBuf.append("CALL ENIS_LOG_PRC (SYSDATE, 'AGT_ACTUAL', ?, 'AGT_LOG') ");
		
			try {
				con = getConnection();
		
				cs = con.prepareCall(strBuf.toString());
				
				int i = 1;
				cs.setString(i++, errMsg);
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)cs).getQueryString());
				cs.executeUpdate();
		
			} catch (SQLException se) {
				log.error("SQLException " + se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (DAOException de) {
				log.error("DAOException " + de.getMessage(), de);
				throw de;
			} catch (Exception e) {
				log.error("Exception " + e.getMessage(), e);
				throw new DAOException(e.getMessage());
			} finally {
				closeStatement(cs);
				closeConnection(con);
			}
			return null;
		}
}

