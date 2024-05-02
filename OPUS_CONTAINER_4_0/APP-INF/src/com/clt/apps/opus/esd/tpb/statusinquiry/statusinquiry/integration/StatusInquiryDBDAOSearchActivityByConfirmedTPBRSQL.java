/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchActivityByConfirmedTPBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusInquiryDBDAOSearchActivityByConfirmedTPBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당점소의 조회기간내에 Confirm된 TPB를 조회한다
	  * </pre>
	  */
	public StatusInquiryDBDAOSearchActivityByConfirmedTPBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_curr_cd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
		query.append("FileName : StatusInquiryDBDAOSearchActivityByConfirmedTPBRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("B.N3PTY_NO," ).append("\n"); 
		query.append("  rownum  N3PTY_NO_DP_SEQ," ).append("\n"); 
		query.append("  ( SELECT RHQ_CD FROM TPB_HNDL_OFC WHERE OFC_CD = A.CFM_OFC_CD AND DELT_FLG='N' AND N3PTY_OFC_TP_CD = 'T') RHQ," ).append("\n"); 
		query.append("  A.CFM_OFC_CD," ).append("\n"); 
		query.append("  A.N3PTY_SRC_SUB_SYS_CD," ).append("\n"); 
		query.append("  B.N3PTY_INV_NO," ).append("\n"); 
		query.append("--1.RHQ/C.OFFICE/OFFICE  " ).append("\n"); 
		query.append("    NVL2( B.N3PTY_INV_NO, (" ).append("\n"); 
		query.append("        SELECT TO_CHAR(TPB_GET_LCL_DATE_FNC(R.INV_UPD_GDT, @[s_user_ofc_cd]), 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("        FROM TPB_INVOICE V," ).append("\n"); 
		query.append("          TPB_INV_RVIS R" ).append("\n"); 
		query.append("        WHERE V.N3PTY_INV_NO = R.N3PTY_INV_NO" ).append("\n"); 
		query.append("          AND V.LST_N3PTY_INV_RVIS_SEQ = R.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("          AND V.N3PTY_INV_NO=B.N3PTY_INV_NO" ).append("\n"); 
		query.append("          AND ROWNUM=1), NULL ) AS INV_ISS_DT," ).append("\n"); 
		query.append("  A.N3PTY_SRC_NO," ).append("\n"); 
		query.append("  A.BKG_NO AS BKG_NO_ALL," ).append("\n"); 
		query.append("  A.BL_NO AS BL_NO_ALL," ).append("\n"); 
		query.append("  DECODE(B.N3PTY_BIL_TP_CD, 'JO', A.VVD_CD, B.VSL_CD || B.SKD_VOY_NO || SUBSTR(A.FINC_DIR_CD, 1, 1)) AS VVD," ).append("\n"); 
		query.append("  A.EQ_NO," ).append("\n"); 
		query.append("  TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM," ).append("\n"); 
		query.append("  CASE B.VNDR_CUST_DIV_CD WHEN 'V' THEN LPAD(TO_CHAR(B.VNDR_SEQ), 6, '0') WHEN 'C' THEN B.CUST_CNT_CD || LPAD(B.CUST_SEQ, 6, '0') WHEN 'S' THEN B.N3PTY_OFC_CD END AS TRD_PARTY_CODE," ).append("\n"); 
		query.append("  CASE B.VNDR_CUST_DIV_CD WHEN 'V' THEN A.VNDR_LGL_ENG_NM WHEN 'C' THEN A.CUST_LGL_ENG_NM WHEN 'S' THEN B.N3PTY_OFC_CD END AS TRD_PARTY_NAME," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT COUNT(1)" ).append("\n"); 
		query.append("    FROM TPB_OTS_GRP_RCVR_ACT" ).append("\n"); 
		query.append("    WHERE N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("      AND N3PTY_CLT_RMK_TP_CD = 'M'" ).append("\n"); 
		query.append("      AND ROWNUM = 1 ) AS CLT_ACT_YN," ).append("\n"); 
		query.append("  COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588', C.OTS_STS_CD) AS OTS_STS_NM," ).append("\n"); 
		query.append("  DECODE( (" ).append("\n"); 
		query.append("        SELECT COUNT(1)" ).append("\n"); 
		query.append("        FROM TPB_OTS_GRP_STS" ).append("\n"); 
		query.append("        WHERE OTS_STS_CD = 'T'" ).append("\n"); 
		query.append("          AND N3PTY_NO = B.N3PTY_NO) , 0 , TRUNC(SYSDATE - B.CFM_DT) , TRUNC(SYSDATE - (" ).append("\n"); 
		query.append("            SELECT MAX(CRE_DT)" ).append("\n"); 
		query.append("            FROM TPB_OTS_GRP_STS" ).append("\n"); 
		query.append("            WHERE OTS_STS_CD = 'T'" ).append("\n"); 
		query.append("              AND N3PTY_NO = B.N3PTY_NO) ) ) AS OVERDUE," ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("    TPB_GET_USD_AMT_FNC(B.OTS_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS OTS_AMT," ).append("\n"); 
		query.append("    TPB_GET_USD_AMT_FNC(B.INV_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS INV_AMT," ).append("\n"); 
		query.append("    TPB_GET_USD_AMT_FNC(B.CLT_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS CLT_AMT," ).append("\n"); 
		query.append("    TPB_GET_USD_AMT_FNC(B.ADJ_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS STL_AMT," ).append("\n"); 
		query.append("    TPB_GET_USD_AMT_FNC(B.BAL_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS BAL_AMT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    NVL(DECODE(B.CURR_CD,'USD',ROUND(B.OTS_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_CNY_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.OTS_AMT),0.0) AS OTS_AMT," ).append("\n"); 
		query.append("    NVL(DECODE(B.CURR_CD,'USD',ROUND(B.INV_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_CNY_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.INV_AMT),0.0) AS INV_AMT," ).append("\n"); 
		query.append("    NVL(DECODE(B.CURR_CD,'USD',ROUND(B.CLT_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_CNY_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.CLT_AMT),0.0) AS CLT_AMT," ).append("\n"); 
		query.append("    NVL(DECODE(B.CURR_CD,'USD',ROUND(B.ADJ_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_CNY_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.ADJ_AMT),0.0) AS STL_AMT," ).append("\n"); 
		query.append("    NVL(DECODE(B.CURR_CD,'USD',ROUND(B.BAL_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_CNY_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.BAL_AMT),0.0) AS BAL_AMT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  B.CRE_USR_ID AS IF_USR_ID," ).append("\n"); 
		query.append("  A.IF_OFC_CD AS IF_OFC_CD," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00589', N3PTY_STL_TP_CD)" ).append("\n"); 
		query.append("    FROM TPB_ADJ_STS E" ).append("\n"); 
		query.append("    WHERE E.N3PTY_NO=A.N3PTY_NO" ).append("\n"); 
		query.append("      AND E.STL_STS_LST_FLG='Y' ) AS N3PTY_STL_TP_CD," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT STL_RQST_OFC_CD" ).append("\n"); 
		query.append("    FROM TPB_ADJ_STS E" ).append("\n"); 
		query.append("    WHERE E.N3PTY_NO=A.N3PTY_NO" ).append("\n"); 
		query.append("      AND E.STL_STS_LST_FLG='Y'" ).append("\n"); 
		query.append("      AND E.N3PTY_STL_TP_CD = 'O' ) AS STL_RQST_OFC_CD," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT STL_TO_CLT_CNG_OFC_CD" ).append("\n"); 
		query.append("    FROM TPB_ADJ_STS E" ).append("\n"); 
		query.append("    WHERE E.N3PTY_NO=A.N3PTY_NO" ).append("\n"); 
		query.append("      AND E.STL_STS_LST_FLG='Y'" ).append("\n"); 
		query.append("      AND E.N3PTY_STL_TP_CD = 'O' ) AS STL_TO_CLT_CNG_OFC_CD," ).append("\n"); 
		query.append("  A.FM_CLT_CNG_OFC_N3PTY_NO," ).append("\n"); 
		query.append("  COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00587', A.EAC_TP_CD) AS EDN_TP_NM," ).append("\n"); 
		query.append("  DECODE(A.N3PTY_BIL_TP_CD, 'JO', A.CSR_NO, NULL) AS CSR_NO," ).append("\n"); 
		query.append("  C.OTS_STS_CD," ).append("\n"); 
		query.append("  B.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("--3.Currency------------------------------------------------------------------" ).append("\n"); 
		query.append("----조회 기준 통화 : 조회office의 Local통화 와 USD  " ).append("\n"); 
		query.append("  DECODE(@[s_curr_cd_tp], 'U', 'USD', DECODE(B.CURR_CD, 'USD', (" ).append("\n"); 
		query.append("            SELECT O.BIL_CURR_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("            WHERE O.OFC_CD = B.OFC_CD), B.CURR_CD)) AS CURR_CD," ).append("\n"); 
		query.append("------------------------------------------------------------------------------            " ).append("\n"); 
		query.append("  A.N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("  --1.RHQ/C.OFFICE/OFFICE" ).append("\n"); 
		query.append("  TO_CHAR(TPB_GET_LCL_DATE_FNC(B.CFM_DT, @[s_user_ofc_cd]), 'YYYY-MM-DD') AS CFM_DT," ).append("\n"); 
		query.append("  0 AS SO_IF_SEQ," ).append("\n"); 
		query.append("  TO_CHAR(B.CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP B," ).append("\n"); 
		query.append("  TPB_OTS_DTL A," ).append("\n"); 
		query.append("  TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("--[Inquiry Option Start]----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("--1.RHQ/C.OFFICE/OFFICE: <Default:로그인 Office> " ).append("\n"); 
		query.append("----RHQ --- All(회사전체)/HAMUR/NYCNA/SHAAS/SINWA" ).append("\n"); 
		query.append("----Control Office --- TPB에서 구성한 Hierarchy 기준의 산하 office(All포함)" ).append("\n"); 
		query.append("----Office --- Candidate를 confirm한 office (주의-responsible office가 아님)" ).append("\n"); 
		query.append("  AND A.CFM_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                        FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("                        WHERE N3PTY_OFC_TP_CD = 'T' " ).append("\n"); 
		query.append("                          AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                #if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("                          AND RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("				#if (${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("                          AND OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                            FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("                            WHERE N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("                            AND DELT_FLG='N')" ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("				#if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("                          AND OFC_CD = @[s_if_ofc_cd] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("--2.Confirmed Date <Default: 1달, 최장 1년>" ).append("\n"); 
		query.append("    AND A.CFM_DT BETWEEN  TPB_GET_LCL_DATE_FNC(TO_DATE(@[s_sdate],'YYYY/MM/DD HH24:MI:SS'), @[s_user_ofc_cd]) AND TPB_GET_LCL_DATE_FNC(TO_DATE(@[s_edate],'YYYY/MM/DD HH24:MI:SS'), @[s_user_ofc_cd])  " ).append("\n"); 
		query.append("--  AND TO_CHAR(TPB_GET_LCL_DATE_FNC(A.CFM_DT, 'HAMBB'), 'YYYY-MM-DD') BETWEEN  '2010-01-01' AND '2010-12-31'  " ).append("\n"); 
		query.append("--[Inquiry Option End]------------------------------------------------------------------------------------------------------------------  " ).append("\n"); 
		query.append("  AND A.N3PTY_BIL_TP_CD IN (SELECT N3PTY_BIL_TP_CD FROM (SELECT N3PTY_BIL_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE ACT_FLG = 'Y' AND N3PTY_BIL_TP_CD != 'JO') )" ).append("\n"); 
		query.append("  AND A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("  AND A.N3PTY_NO_DP_SEQ = 1" ).append("\n"); 
		query.append("  AND B.N3PTY_NO = A.N3PTY_NO" ).append("\n"); 
		query.append("  AND B.N3PTY_DELT_TP_CD IN ('N','C','S')" ).append("\n"); 
		query.append("  AND C.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("  AND C.OTS_STS_LST_FLG = 'Y'            " ).append("\n"); 
		query.append("--  AND C.OTS_STS_CD NOT IN ('D','E','L','A')" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("ORDER BY D.N3PTY_NO_DP_SEQ, D.N3PTY_NO" ).append("\n"); 

	}
}