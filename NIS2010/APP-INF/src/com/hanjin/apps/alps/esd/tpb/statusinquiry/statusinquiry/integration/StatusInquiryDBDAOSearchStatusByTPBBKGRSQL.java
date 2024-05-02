/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchStatusByTPBBKGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusInquiryDBDAOSearchStatusByTPBBKGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStatusByTPBBKG
	  * </pre>
	  */
	public StatusInquiryDBDAOSearchStatusByTPBBKGRSQL(){
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
		params.put("s_bl_no_all",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ots_amt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no_all",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ots_amt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
		query.append("FileName : StatusInquiryDBDAOSearchStatusByTPBBKGRSQL").append("\n"); 
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
		query.append("SELECT B.N3PTY_NO," ).append("\n"); 
		query.append("A.N3PTY_NO_DP_SEQ," ).append("\n"); 
		query.append("A.N3PTY_SRC_SUB_SYS_CD," ).append("\n"); 
		query.append("B.N3PTY_INV_NO," ).append("\n"); 
		query.append("NVL2( B.N3PTY_INV_NO, (SELECT TO_CHAR(TPB_GET_LCL_DATE_FNC(R.INV_UPD_GDT,@[s_user_ofc_cd]),'YYYY-MM-DD') UPD_DT FROM TPB_INVOICE V, TPB_INV_RVIS R WHERE V.N3PTY_INV_NO = R.N3PTY_INV_NO AND V.LST_N3PTY_INV_RVIS_SEQ = R.N3PTY_INV_RVIS_SEQ AND V.N3PTY_INV_NO=B.N3PTY_INV_NO AND ROWNUM=1), NULL ) AS INV_ISS_DT," ).append("\n"); 
		query.append("A.N3PTY_SRC_NO," ).append("\n"); 
		query.append("A.BKG_NO AS BKG_NO_ALL," ).append("\n"); 
		query.append("A.BL_NO AS BL_NO_ALL," ).append("\n"); 
		query.append("DECODE(B.N3PTY_BIL_TP_CD, 'JO', A.VVD_CD, B.VSL_CD || B.SKD_VOY_NO || SUBSTR(A.FINC_DIR_CD,1,1)) AS VVD," ).append("\n"); 
		query.append("A.EQ_NO," ).append("\n"); 
		query.append("TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM," ).append("\n"); 
		query.append("CASE B.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append("WHEN 'V' THEN TO_CHAR(B.VNDR_SEQ)" ).append("\n"); 
		query.append("WHEN 'C' THEN B.CUST_CNT_CD || B.CUST_SEQ" ).append("\n"); 
		query.append("WHEN 'S' THEN B.N3PTY_OFC_CD" ).append("\n"); 
		query.append("END AS TRD_PARTY_CODE," ).append("\n"); 
		query.append("CASE B.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append("WHEN 'V' THEN A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("WHEN 'C' THEN A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("WHEN 'S' THEN B.N3PTY_OFC_CD" ).append("\n"); 
		query.append("END AS TRD_PARTY_NAME," ).append("\n"); 
		query.append("--TPB_GET_CLT_ACT_YN_FNC(B.N3PTY_NO,B.N3PTY_INV_NO) AS CLT_ACT_YN," ).append("\n"); 
		query.append("(SELECT COUNT(1) FROM TPB_OTS_GRP_RCVR_ACT WHERE N3PTY_NO = B.N3PTY_NO AND N3PTY_CLT_RMK_TP_CD = 'M' AND ROWNUM = 1 ) AS CLT_ACT_YN," ).append("\n"); 
		query.append("CASE WHEN C.OTS_STS_CD IN ('R','T','J') THEN COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD02799',B.OTS_STS_DTL_CD)" ).append("\n"); 
		query.append("ELSE COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588',C.OTS_STS_CD)" ).append("\n"); 
		query.append("END AS OTS_STS_NM," ).append("\n"); 
		query.append("DECODE( (SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO)" ).append("\n"); 
		query.append(",0 ,TRUNC(SYSDATE - B.CFM_DT)" ).append("\n"); 
		query.append(", TRUNC(SYSDATE - (SELECT MAX(CRE_DT) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO) )" ).append("\n"); 
		query.append(") AS OVERDUE," ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("TPB_GET_USD_AMT_FNC(B.OTS_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS OTS_AMT," ).append("\n"); 
		query.append("TPB_GET_USD_AMT_FNC(B.INV_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS INV_AMT," ).append("\n"); 
		query.append("TPB_GET_USD_AMT_FNC(B.CLT_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS CLT_AMT," ).append("\n"); 
		query.append("TPB_GET_USD_AMT_FNC(B.ADJ_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS STL_AMT," ).append("\n"); 
		query.append("TPB_GET_USD_AMT_FNC(B.BAL_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) AS BAL_AMT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--	   NVL(B.OTS_AMT,0.0) AS OTS_AMT," ).append("\n"); 
		query.append("--	   NVL(B.CLT_AMT,0.0) AS CLT_AMT," ).append("\n"); 
		query.append("--	   NVL(B.ADJ_AMT,0.0) AS STL_AMT," ).append("\n"); 
		query.append("--	   NVL(B.BAL_AMT,0.0) AS BAL_AMT," ).append("\n"); 
		query.append("NVL(DECODE(B.CURR_CD,'USD',ROUND(B.OTS_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_KRW_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.OTS_AMT),0.0) AS OTS_AMT," ).append("\n"); 
		query.append("NVL(DECODE(B.CURR_CD,'USD',ROUND(B.INV_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_KRW_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.INV_AMT),0.0) AS INV_AMT," ).append("\n"); 
		query.append("NVL(DECODE(B.CURR_CD,'USD',ROUND(B.CLT_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_KRW_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.CLT_AMT),0.0) AS CLT_AMT," ).append("\n"); 
		query.append("NVL(DECODE(B.CURR_CD,'USD',ROUND(B.ADJ_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_KRW_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.ADJ_AMT),0.0) AS STL_AMT," ).append("\n"); 
		query.append("NVL(DECODE(B.CURR_CD,'USD',ROUND(B.BAL_AMT * TPB_GET_USD_XCH_RT_FNC('KRW',TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) / (SELECT LOCL_KRW_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM') AND CURR_CD = (SELECT BIL_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.OFC_CD) AND ACCT_XCH_RT_LVL = '1'),2),B.BAL_AMT),0.0) AS BAL_AMT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("B.CRE_USR_ID AS IF_USR_ID," ).append("\n"); 
		query.append("A.IF_OFC_CD AS IF_OFC_CD," ).append("\n"); 
		query.append("( SELECT COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00589',N3PTY_STL_TP_CD) FROM TPB_ADJ_STS E WHERE E.N3PTY_NO=A.N3PTY_NO AND E.STL_STS_LST_FLG='Y' ) AS N3PTY_STL_TP_CD," ).append("\n"); 
		query.append("( SELECT STL_RQST_OFC_CD FROM TPB_ADJ_STS E WHERE E.N3PTY_NO=A.N3PTY_NO AND E.STL_STS_LST_FLG='Y' AND E.N3PTY_STL_TP_CD = 'O' ) AS STL_RQST_OFC_CD," ).append("\n"); 
		query.append("( SELECT STL_TO_CLT_CNG_OFC_CD FROM TPB_ADJ_STS E WHERE E.N3PTY_NO=A.N3PTY_NO AND E.STL_STS_LST_FLG='Y' AND E.N3PTY_STL_TP_CD = 'O' ) AS STL_TO_CLT_CNG_OFC_CD," ).append("\n"); 
		query.append("A.FM_CLT_CNG_OFC_N3PTY_NO," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00587', A.EAC_TP_CD) AS EDN_TP_NM," ).append("\n"); 
		query.append("DECODE(A.N3PTY_BIL_TP_CD,'JO',A.CSR_NO,NULL) AS CSR_NO," ).append("\n"); 
		query.append("C.OTS_STS_CD," ).append("\n"); 
		query.append("B.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("B.CURR_CD," ).append("\n"); 
		query.append("A.N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("TO_CHAR(TPB_GET_LCL_DATE_FNC(B.CFM_DT,@[s_user_ofc_cd]),'YYYY-MM-DD') AS CFM_DT," ).append("\n"); 
		query.append("0 AS SO_IF_SEQ," ).append("\n"); 
		query.append("TO_CHAR(B.CRE_DT,'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP B," ).append("\n"); 
		query.append("TPB_OTS_DTL A," ).append("\n"); 
		query.append("TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("AND B.N3PTY_NO = A.N3PTY_NO" ).append("\n"); 
		query.append("AND A.N3PTY_NO_DP_SEQ = 1" ).append("\n"); 
		query.append("AND B.N3PTY_DELT_TP_CD IN ('N','C','S')" ).append("\n"); 
		query.append("AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND A.N3PTY_BIL_TP_CD IN ( SELECT N3PTY_BIL_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE ACT_FLG = 'Y' AND N3PTY_BIL_TP_CD != 'JO' )" ).append("\n"); 
		query.append("#if (${s_bkg_no_all} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO = @[s_bkg_no_all]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bl_no_all} != '')" ).append("\n"); 
		query.append("AND A.BL_NO = @[s_bl_no_all]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_edn_tp_cd} == 'A')" ).append("\n"); 
		query.append("AND A.EAC_TP_CD != 'N'" ).append("\n"); 
		query.append("#elseif (${s_edn_tp_cd} != '')" ).append("\n"); 
		query.append("AND A.EAC_TP_CD = @[s_edn_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("#if (${s_ots_amt_from} != '')" ).append("\n"); 
		query.append("AND TPB_GET_USD_AMT_FNC(B.OTS_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) >= @[s_ots_amt_from]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_ots_amt_to} != '')" ).append("\n"); 
		query.append("AND TPB_GET_USD_AMT_FNC(B.OTS_AMT,B.CURR_CD,TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)) <= @[s_ots_amt_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${s_ots_amt_from} != '')" ).append("\n"); 
		query.append("AND NVL(TPB_GET_LOCL_AMT_FNC(B.OTS_AMT, B.CURR_CD, TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)),0.0) >= @[s_ots_amt_from]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_ots_amt_to} != '')" ).append("\n"); 
		query.append("AND NVL(TPB_GET_LOCL_AMT_FNC(B.OTS_AMT, B.CURR_CD, TPB_GET_LCL_DATE_FNC(B.CFM_DT,B.OFC_CD)),0.0) <= @[s_ots_amt_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_ots_sts_cd} == 'P')" ).append("\n"); 
		query.append("AND ( ( C.OTS_STS_CD = 'D' AND A.N3PTY_DELT_TP_CD IN ('S','C') ) OR ( C.OTS_STS_CD IN ('E','L','A') AND A.N3PTY_DELT_TP_CD = 'N' ) )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND C.OTS_STS_CD NOT IN ('D','E','L','A')" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.N3PTY_NO, A.N3PTY_NO_DP_SEQ" ).append("\n"); 

	}
}