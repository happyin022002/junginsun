/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchStatusByNonTPBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.16 
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

public class StatusInquiryDBDAOSearchStatusByNonTPBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Non-TPB 내용 조회
	  * </pre>
	  */
	public StatusInquiryDBDAOSearchStatusByNonTPBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_ots_amt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trd_party_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_n3pty_src_sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_eq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_csr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_n3pty_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
		query.append("FileName : StatusInquiryDBDAOSearchStatusByNonTPBRSQL").append("\n"); 
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
		query.append("SELECT T.OTS_DTL_SEQ," ).append("\n"); 
		query.append("       T.OFC_CD," ).append("\n"); 
		query.append("       T.N3PTY_SRC_SUB_SYS_CD," ).append("\n"); 
		query.append("       T.N3PTY_SRC_NO," ).append("\n"); 
		query.append("       T.BKG_NO_ALL," ).append("\n"); 
		query.append("       T.BL_NO_ALL," ).append("\n"); 
		query.append("       T.VVD," ).append("\n"); 
		query.append("       T.EQ_NO, " ).append("\n"); 
		query.append("       T.N3PTY_BIL_TP_NM," ).append("\n"); 
		query.append("       T.N3PTY_BIL_TP_CD, " ).append("\n"); 
		query.append("       T.TRD_PARTY_TYPE, " ).append("\n"); 
		query.append("       T.TRD_PARTY_CODE, " ).append("\n"); 
		query.append("       T.TRD_PARTY_NAME," ).append("\n"); 
		query.append("       T.CLT_ACT_YN," ).append("\n"); 
		query.append("       T.OTS_STS_NM," ).append("\n"); 
		query.append("       T.OVERDUE," ).append("\n"); 
		query.append("       DECODE(@[s_curr_cd_tp],'U','USD',DECODE(T.CURR_CD,'USD',T.BIL_CURR_CD, T.CURR_CD)) AS CURR_CD," ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("	   TPB_GET_USD_AMT_FNC(T.OTS_AMT,T.CURR_CD, T.RATE_DT + T.GMT_GAP) AS OTS_AMT," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	   NVL(DECODE(T.CURR_CD,'USD',ROUND(T.OTS_AMT * TPB_GET_USD_XCH_RT_FNC(T.BIL_CURR_CD,TPB_GET_LCL_DATE_FNC(T.RATE_DT,T.OFC_CD)) ,2),T.OTS_AMT),0.0) AS OTS_AMT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       T.IF_USR_ID, " ).append("\n"); 
		query.append("       T.IF_USR_NM," ).append("\n"); 
		query.append("       T.IF_OFC_CD," ).append("\n"); 
		query.append("       T.IF_DT," ).append("\n"); 
		query.append("       T.N3PTY_STL_TP_CD," ).append("\n"); 
		query.append("       T.STL_RQST_OFC_CD," ).append("\n"); 
		query.append("       T.STL_TO_CLT_CNG_OFC_CD," ).append("\n"); 
		query.append("       T.FM_CLT_CNG_OFC_N3PTY_NO, " ).append("\n"); 
		query.append("       T.EDN_TP_NM," ).append("\n"); 
		query.append("       T.CSR_NO, " ).append("\n"); 
		query.append("       T.OTS_STS_CD, " ).append("\n"); 
		query.append("       T.VNDR_CUST_DIV_CD, " ).append("\n"); 
		query.append("       TO_CHAR(T.CFM_DT + T.GMT_GAP,'YYYY-MM-DD') AS CFM_DT," ).append("\n"); 
		query.append("       T.SO_IF_SEQ, " ).append("\n"); 
		query.append("       T.CRE_DT," ).append("\n"); 
		query.append("       T.CONTRACT_NO, T.CONTRACT_OFC," ).append("\n"); 
		query.append("       T.POR_CD, T.POL_CD, T.POD_CD, T.DEL_CD, T.RCV_TERM_CD, T.DE_TERM_CD" ).append("\n"); 
		query.append("       , T.N3PTY_NON_CFM_RSN_CD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("FROM(       " ).append("\n"); 
		query.append("SELECT A.OTS_DTL_SEQ," ).append("\n"); 
		query.append("       A.OFC_CD," ).append("\n"); 
		query.append("       A.N3PTY_SRC_SUB_SYS_CD," ).append("\n"); 
		query.append("       A.N3PTY_SRC_NO," ).append("\n"); 
		query.append("       A.BKG_NO AS BKG_NO_ALL," ).append("\n"); 
		query.append("       A.BL_NO AS BL_NO_ALL," ).append("\n"); 
		query.append("       DECODE(A.N3PTY_BIL_TP_CD, 'JO', A.VVD_CD, A.VSL_CD || A.SKD_VOY_NO || A.FINC_DIR_CD) AS VVD," ).append("\n"); 
		query.append("       A.EQ_NO, " ).append("\n"); 
		query.append("       TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM, " ).append("\n"); 
		query.append("       CASE A.VNDR_CUST_DIV_CD " ).append("\n"); 
		query.append("            WHEN 'V' THEN LPAD(TO_CHAR(A.VNDR_SEQ),6,'0')" ).append("\n"); 
		query.append("            WHEN 'C' THEN A.CUST_CNT_CD || LPAD(A.CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("            WHEN 'S' THEN A.N3PTY_OFC_CD " ).append("\n"); 
		query.append("       END AS TRD_PARTY_CODE, " ).append("\n"); 
		query.append("       CASE A.VNDR_CUST_DIV_CD " ).append("\n"); 
		query.append("            WHEN 'V' THEN A.VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("            WHEN 'C' THEN A.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("            WHEN 'S' THEN A.N3PTY_OFC_CD " ).append("\n"); 
		query.append("       END AS TRD_PARTY_NAME," ).append("\n"); 
		query.append("       CASE A.VNDR_CUST_DIV_CD " ).append("\n"); 
		query.append("            WHEN 'V' THEN 'Vendor'" ).append("\n"); 
		query.append("            WHEN 'C' THEN 'Customer'" ).append("\n"); 
		query.append("            WHEN 'S' THEN 'Staff' " ).append("\n"); 
		query.append("       END AS TRD_PARTY_TYPE, " ).append("\n"); 
		query.append("       '' AS CLT_ACT_YN," ).append("\n"); 
		query.append("       CASE WHEN C.OTS_STS_CD IN ('D') THEN COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588',C.OTS_STS_CD)" ).append("\n"); 
		query.append("            ELSE COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01476',A.N3PTY_CFM_CD)" ).append("\n"); 
		query.append("       END AS OTS_STS_NM," ).append("\n"); 
		query.append("       '' AS OVERDUE," ).append("\n"); 
		query.append("       A.IF_AMT AS OTS_AMT, " ).append("\n"); 
		query.append("       S.GMT_GAP, " ).append("\n"); 
		query.append("        A.IF_CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("       (SELECT O.BIL_CURR_CD FROM MDM_ORGANIZATION O WHERE O.OFC_CD = A.OFC_CD) AS BIL_CURR_CD," ).append("\n"); 
		query.append("       A.IF_DT AS RATE_DT, " ).append("\n"); 
		query.append("       A.CRE_USR_ID AS IF_USR_ID, " ).append("\n"); 
		query.append("       (SELECT U.USR_NM FROM COM_USER U WHERE USR_ID=A.CRE_USR_ID AND USE_FLG='Y' AND ROWNUM=1 )  IF_USR_NM," ).append("\n"); 
		query.append("       A.IF_OFC_CD AS IF_OFC_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.IF_DT,'YYYY-MM-DD HH24:MI') AS IF_DT," ).append("\n"); 
		query.append("       ( SELECT COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00589',N3PTY_STL_TP_CD) FROM TPB_ADJ_STS E WHERE E.N3PTY_NO=A.N3PTY_NO AND E.STL_STS_LST_FLG='Y' ) AS N3PTY_STL_TP_CD," ).append("\n"); 
		query.append("       ( SELECT STL_RQST_OFC_CD FROM TPB_ADJ_STS E WHERE E.N3PTY_NO=A.N3PTY_NO AND E.STL_STS_LST_FLG='Y' AND E.N3PTY_STL_TP_CD = 'O' ) AS STL_RQST_OFC_CD," ).append("\n"); 
		query.append("       ( SELECT STL_TO_CLT_CNG_OFC_CD FROM TPB_ADJ_STS E WHERE E.N3PTY_NO=A.N3PTY_NO AND E.STL_STS_LST_FLG='Y' AND E.N3PTY_STL_TP_CD = 'O' ) AS STL_TO_CLT_CNG_OFC_CD," ).append("\n"); 
		query.append("       A.FM_CLT_CNG_OFC_N3PTY_NO, " ).append("\n"); 
		query.append("       COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00587', A.EAC_TP_CD) AS EDN_TP_NM," ).append("\n"); 
		query.append("       DECODE(A.N3PTY_BIL_TP_CD,'JO',A.CSR_NO,NULL) AS CSR_NO, " ).append("\n"); 
		query.append("       C.OTS_STS_CD, " ).append("\n"); 
		query.append("       A.VNDR_CUST_DIV_CD, " ).append("\n"); 
		query.append("       A.N3PTY_BIL_TP_CD, " ).append("\n"); 
		query.append("       '' CFM_DT," ).append("\n"); 
		query.append("       0 AS SO_IF_SEQ, " ).append("\n"); 
		query.append("       TO_CHAR(A.CRE_DT,'YYYY-MM-DD HH24:MI') AS CRE_DT," ).append("\n"); 
		query.append("      (SELECT NVL(BB.SC_NO,NVL(BB.RFA_NO,'')) FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS CONTRACT_NO," ).append("\n"); 
		query.append("      (SELECT BB.CTRT_OFC_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS CONTRACT_OFC," ).append("\n"); 
		query.append("      (SELECT BB.POR_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS POR_CD," ).append("\n"); 
		query.append("      (SELECT BB.POL_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS POL_CD," ).append("\n"); 
		query.append("      (SELECT BB.POD_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS POD_CD," ).append("\n"); 
		query.append("      (SELECT BB.DEL_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS DEL_CD," ).append("\n"); 
		query.append("      (SELECT BB.RCV_TERM_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS RCV_TERM_CD," ).append("\n"); 
		query.append("      (SELECT BB.DE_TERM_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = A.BKG_NO) AS DE_TERM_CD" ).append("\n"); 
		query.append("      , A.N3PTY_NON_CFM_RSN_CD" ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL A, " ).append("\n"); 
		query.append("       TPB_OTS_DTL_STS C, " ).append("\n"); 
		query.append("	   (SELECT OFC_CD, MDM_LOCATION.LOC_CD, SYSDATE, GLOBALDATE_PKG.TIME_CONV_FNC( " ).append("\n"); 
		query.append("                'GMT', " ).append("\n"); 
		query.append("                SYSDATE - ( 9 / 24 ),  --CM DATE" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                MDM_LOCATION.LOC_CD  --2932" ).append("\n"); 
		query.append("           ) AS GMT_DT" ).append("\n"); 
		query.append("           ,   GLOBALDATE_PKG.TIME_CONV_FNC( " ).append("\n"); 
		query.append("                'GMT', " ).append("\n"); 
		query.append("                SYSDATE - ( 9 / 24 ),  --CM DATE" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                MDM_LOCATION.LOC_CD  --2932" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("           ) - SYSDATE AS GMT_GAP" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("    FROM MDM_LOCATION, MDM_ORGANIZATION" ).append("\n"); 
		query.append("    WHERE MDM_LOCATION.DELT_FLG='N'" ).append("\n"); 
		query.append("    AND MDM_LOCATION.LOC_CD = MDM_ORGANIZATION.LOC_CD " ).append("\n"); 
		query.append("    AND MDM_ORGANIZATION.OFC_CD = @[s_user_ofc_cd])  S" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("   AND A.OTS_DTL_SEQ = C.OTS_DTL_SEQ" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND A.OFC_CD IN ( SELECT OFC_CD " ).append("\n"); 
		query.append("                       FROM TPB_HNDL_OFC " ).append("\n"); 
		query.append("                      WHERE N3PTY_OFC_TP_CD = 'T'" ).append("\n"); 
		query.append("                        AND DELT_FLG = 'N'  " ).append("\n"); 
		query.append("                        AND RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("                     #if (${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("                        AND OFC_CD IN ( SELECT OFC_CD FROM TPB_HNDL_OFC WHERE N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd] )" ).append("\n"); 
		query.append("                     #end " ).append("\n"); 
		query.append("                     #if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("                        AND OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                   ) " ).append("\n"); 
		query.append("#end                   " ).append("\n"); 
		query.append("AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("AND A.N3PTY_BIL_TP_CD IN ( SELECT N3PTY_BIL_TP_CD " ).append("\n"); 
		query.append("                              FROM TPB_N3RD_PTY_BIL_TP " ).append("\n"); 
		query.append("                              WHERE N3PTY_BIL_TP_CD != 'JO' " ).append("\n"); 
		query.append("#if (${s_if_type} != '')" ).append("\n"); 
		query.append("                              AND N3PTY_IF_TP_CD = @[s_if_type]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("#if (${s_n3pty_src_sub_sys_cd} != '')" ).append("\n"); 
		query.append("   AND A.N3PTY_SRC_SUB_SYS_CD = @[s_n3pty_src_sub_sys_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_bil_tp_cd} != '')" ).append("\n"); 
		query.append("   AND A.N3PTY_BIL_TP_CD = @[s_n3pty_bil_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bkg_no_all} != '')" ).append("\n"); 
		query.append(" AND A.BKG_NO = @[s_bkg_no_all] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bl_no_all} != '')" ).append("\n"); 
		query.append(" AND A.BL_NO = @[s_bl_no_all] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_vvd} != '')" ).append("\n"); 
		query.append("   AND A.VSL_CD || A.SKD_VOY_NO || SUBSTR(A.FINC_DIR_CD,1,1) = @[s_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_src_no} != '')" ).append("\n"); 
		query.append("   AND A.N3PTY_SRC_NO = @[s_n3pty_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_edn_tp_cd} == 'A')" ).append("\n"); 
		query.append("   AND A.EAC_TP_CD != 'N'" ).append("\n"); 
		query.append("#elseif (${s_edn_tp_cd} != '')" ).append("\n"); 
		query.append("   AND A.EAC_TP_CD = @[s_edn_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("	 #if (${s_ots_amt_from} != '')" ).append("\n"); 
		query.append("   	    AND TPB_GET_USD_AMT_FNC(A.IF_AMT,A.IF_CURR_CD,TPB_GET_LCL_DATE_FNC(A.IF_DT,A.OFC_CD)) >= @[s_ots_amt_from]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 #if (${s_ots_amt_to} != '')" ).append("\n"); 
		query.append("   	    AND TPB_GET_USD_AMT_FNC(A.IF_AMT,A.IF_CURR_CD,TPB_GET_LCL_DATE_FNC(A.IF_DT,A.OFC_CD)) <= @[s_ots_amt_to]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	 #if (${s_ots_amt_from} != '')" ).append("\n"); 
		query.append("   	    AND NVL(TPB_GET_LOCL_AMT_FNC(A.IF_AMT,A.IF_CURR_CD,TPB_GET_LCL_DATE_FNC(A.IF_DT,A.OFC_CD)),0.0) >= @[s_ots_amt_from]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 #if (${s_ots_amt_to} != '')" ).append("\n"); 
		query.append("   	    AND NVL(TPB_GET_LOCL_AMT_FNC(A.IF_AMT,A.IF_CURR_CD,TPB_GET_LCL_DATE_FNC(A.IF_DT,A.OFC_CD)),0.0) <= @[s_ots_amt_to]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_csr_no} != '')" ).append("\n"); 
		query.append("   AND A.CSR_NO = @[s_csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_eq_no} != '')" ).append("\n"); 
		query.append(" AND A.EQ_NO = @[s_eq_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_vndr_cust_div_cd} != '')" ).append("\n"); 
		query.append("	 AND A.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("		#if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("			#if (${s_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("				AND A.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("			#elseif (${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("				AND A.CUST_CNT_CD = SUBSTRB(TRIM(@[s_trd_party_val]),1,2)" ).append("\n"); 
		query.append("				#if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("					AND A.CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[s_trd_party_val]),3))" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#elseif (${s_vndr_cust_div_cd} == 'S')" ).append("\n"); 
		query.append("				AND A.N3PTY_OFC_CD = @[s_trd_party_val]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.CRE_DT >= TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[s_user_ofc_cd]) " ).append("\n"); 
		query.append("AND A.CRE_DT < TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[s_user_ofc_cd])+1" ).append("\n"); 
		query.append("#if (${s_ots_sts_cd_detail_non} == 'D')" ).append("\n"); 
		query.append("AND A.N3PTY_CFM_CD ='N'" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD IN ('D' ,'S')" ).append("\n"); 
		query.append("#elseif (${s_ots_sts_cd_detail_non} == 'R')" ).append("\n"); 
		query.append("AND A.N3PTY_CFM_CD ='R' " ).append("\n"); 
		query.append("#elseif (${s_ots_sts_cd_detail_non} == 'ALL')" ).append("\n"); 
		query.append("AND A.N3PTY_CFM_CD IN ('R' ,'N')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.N3PTY_CFM_CD ='N'" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD NOT IN ('D' ,'S')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(" ORDER BY T.OTS_DTL_SEQ" ).append("\n"); 

	}
}