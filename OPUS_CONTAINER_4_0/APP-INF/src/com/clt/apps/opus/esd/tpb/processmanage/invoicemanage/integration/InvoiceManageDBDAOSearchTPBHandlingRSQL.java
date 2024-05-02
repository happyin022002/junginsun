/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchTPBHandlingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchTPBHandlingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB Handling
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchTPBHandlingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no_search",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_n3pty_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_eq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchTPBHandlingRSQL").append("\n"); 
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
		query.append("SELECT A.N3PTY_NO," ).append("\n"); 
		query.append("       B.N3PTY_INV_NO," ).append("\n"); 
		query.append("       0 AS LST_N3PTY_INV_RVIS_SEQ," ).append("\n"); 
		query.append("       'X' AS N3PTY_INV_RVIS_CD," ).append("\n"); 
		query.append("       B.N3PTY_EXPN_TP_CD," ).append("\n"); 
		query.append("       B.N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("       NVL(TPB_GET_N3PTY_BIL_TP_NM_FNC(B.N3PTY_BIL_TP_CD),TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD)) AS N3PTY_BIL_TP_NM," ).append("\n"); 
		query.append("       A.N3PTY_SRC_NO," ).append("\n"); 
		query.append("       A.EQ_NO," ).append("\n"); 
		query.append("       A.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("       DECODE(B.VNDR_CUST_DIV_CD,'V',LPAD(B.VNDR_SEQ,6,0),'C',B.CUST_CNT_CD||LPAD(B.CUST_SEQ,6,0),'S',B.N3PTY_OFC_CD,'') AS N3PTY_CD," ).append("\n"); 
		query.append("       DECODE(B.VNDR_CUST_DIV_CD,'V',VNDR_LGL_ENG_NM,'C',CUST_LGL_ENG_NM,'S',B.N3PTY_OFC_CD,'') AS N3PTY_NM," ).append("\n"); 
		query.append("       B.VSL_CD||B.SKD_VOY_NO||B.FINC_DIR_CD AS REV_VVD," ).append("\n"); 
		query.append("       A.IF_CURR_CD, IF_AMT, --(SELECT IF_AMT FROM TPB_OTS_DTL WHERE N3PTY_NO = B.N3PTY_NO AND N3PTY_BIL_TP_CD = A.N3PTY_BIL_TP_CD) AS IF_AMT," ).append("\n"); 
		query.append("       TPB_GET_USD_AMT_FNC(IF_AMT,A.IF_CURR_CD,TPB_GET_LCL_DATE_FNC(A.IF_DT,B.OFC_CD)) AS IF_AMT_USD," ).append("\n"); 
		query.append("       A.CFM_CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("       A.OTS_AMT," ).append("\n"); 
		query.append("       A.INV_AMT AS RVS_AMT," ).append("\n"); 
		query.append("       DECODE( (SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO)" ).append("\n"); 
		query.append("    	 ,0,A.CFM_USR_ID" ).append("\n"); 
		query.append("    	 ,(SELECT CRE_USR_ID FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO AND OTS_STS_SEQ = (SELECT MAX(OTS_STS_SEQ) FROM TPB_OTS_GRP_STS WHERE N3PTY_NO = B.N3PTY_NO AND OTS_STS_CD = 'T'))" ).append("\n"); 
		query.append("       	 ) AS CFM_USR_ID," ).append("\n"); 
		query.append("       DECODE( (SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO)" ).append("\n"); 
		query.append("    	 ,0,(SELECT USR_NM FROM COM_USER U WHERE U.USR_ID = A.CFM_USR_ID)" ).append("\n"); 
		query.append("    	 ,(SELECT USR_NM FROM COM_USER U WHERE U.USR_ID = (SELECT CRE_USR_ID FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO AND OTS_STS_SEQ = (SELECT MAX(OTS_STS_SEQ) FROM TPB_OTS_GRP_STS WHERE N3PTY_NO = B.N3PTY_NO AND OTS_STS_CD = 'T')))" ).append("\n"); 
		query.append("       	 ) AS CFM_USR_NM," ).append("\n"); 
		query.append("       DECODE( (SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO)" ).append("\n"); 
		query.append("    	 ,0,TO_CHAR(TPB_GET_LCL_DATE_FNC(B.CFM_DT,@[s_user_ofc_cd]),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("    	 ,TO_CHAR(TPB_GET_LCL_DATE_FNC((SELECT MAX(CRE_DT) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO),@[s_user_ofc_cd]),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("    	 ) AS CFM_DT," ).append("\n"); 
		query.append("       DECODE( (SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO)" ).append("\n"); 
		query.append("    	 ,0 ,TRUNC(SYSDATE - B.CFM_DT)" ).append("\n"); 
		query.append("    	 , TRUNC(SYSDATE - (SELECT MAX(CRE_DT) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO))" ).append("\n"); 
		query.append("    	 ) AS OVERDUE," ).append("\n"); 
		query.append("       '' AS ERPIF_USR_ID," ).append("\n"); 
		query.append("       '' AS ERPIF_USR_NM," ).append("\n"); 
		query.append("       '' AS ERPIF_DT," ).append("\n"); 
		query.append("       TO_CHAR(TPB_GET_RCVR_ACT_YN_FNC(B.N3PTY_NO)) AS RCVR_ACT_YN," ).append("\n"); 
		query.append("       DECODE(A.VNDR_CUST_DIV_CD,'V','Y','C','Y','N') AS INVOICE_ABLE, -- INVOICE IN S/P, CUSTOMER CASE" ).append("\n"); 
		query.append("       'N' AS REVISE_ABLE," ).append("\n"); 
		query.append("       'N' AS ERPIF_ABLE," ).append("\n"); 
		query.append("       ( SELECT COUNT(DISTINCT N3PTY_BIL_TP_CD) FROM TPB_OTS_DTL K WHERE K.N3PTY_NO = A.N3PTY_NO ) AS LENGTH_N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("       '' AS IDA_TAX_SEQ," ).append("\n"); 
		query.append("       DECODE(B.VNDR_CUST_DIV_CD,'V',TO_CHAR(B.VNDR_SEQ),'C',B.CUST_CNT_CD||TO_CHAR(B.CUST_SEQ),'S',B.N3PTY_OFC_CD,'') AS N3PTY_CD_O" ).append("\n"); 
		query.append("       ,A.N3PTY_NO  AS s_eq_no --2016.09.13 Radio grouping temp key  " ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL A," ).append("\n"); 
		query.append("       TPB_OTS_GRP B," ).append("\n"); 
		query.append("       TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("   AND B.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("   --AND A.N3PTY_NO_DP_SEQ = 1" ).append("\n"); 
		query.append("   AND A.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("   AND A.N3PTY_BIL_TP_CD IN ( SELECT N3PTY_BIL_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE ACT_FLG = 'Y' AND N3PTY_BIL_TP_CD != 'JO' )" ).append("\n"); 
		query.append("   AND B.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("   AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("   AND C.OTS_STS_CD IN ('O','M','J')" ).append("\n"); 
		query.append("#if (${s_n3pty_no} == '' && ${s_n3pty_inv_no_search} == '' && ${s_bkg_no_all} == '' && ${s_bl_no_all} == '')" ).append("\n"); 
		query.append("	#if (${s_status} == 'O')" ).append("\n"); 
		query.append("   		AND C.OTS_STS_CD IN ('O','M','J')" ).append("\n"); 
		query.append("	#elseif (${s_status} != 'O' && ${s_status} != '')" ).append("\n"); 
		query.append("   		AND 1 = 0" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.OFC_CD = @[s_user_ofc_cd]" ).append("\n"); 
		query.append("#if (${s_n3pty_no_strs_link} != '' && $s_n3pty_no_strs_link.size() > 0)" ).append("\n"); 
		query.append("	 AND A.N3PTY_NO IN ( NULL" ).append("\n"); 
		query.append("	 #foreach($s_n3pty_no_strs_link IN ${s_n3pty_no_strs_link})" ).append("\n"); 
		query.append("	 	#if($velocityCount < $s_n3pty_no_strs_link.size())" ).append("\n"); 
		query.append("	 	,'$s_n3pty_no_strs_link'," ).append("\n"); 
		query.append("	 	#else" ).append("\n"); 
		query.append("	 	,'$s_n3pty_no_strs_link'" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${s_n3pty_no} == '' && ${s_n3pty_inv_no_search} == '' && ${s_sdate} != '' && ${s_edate} != '')" ).append("\n"); 
		query.append("  		AND B.CFM_DT BETWEEN TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[s_user_ofc_cd]) AND TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[s_user_ofc_cd]) + 1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("   		AND A.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_n3pty_inv_no_search} != '')" ).append("\n"); 
		query.append("   		AND 1=0" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_n3pty_expn_tp_cd} != '')" ).append("\n"); 
		query.append("   		AND B.N3PTY_EXPN_TP_CD = @[s_n3pty_expn_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_n3pty_src_no} != '')" ).append("\n"); 
		query.append("   		AND A.N3PTY_SRC_NO = @[s_n3pty_src_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_vvd} != '')" ).append("\n"); 
		query.append("   		AND B.VSL_CD = SUBSTRB(@[s_vvd],1,4)" ).append("\n"); 
		query.append("   		AND B.SKD_VOY_NO = SUBSTRB(@[s_vvd],5,4)" ).append("\n"); 
		query.append("   		AND B.FINC_DIR_CD LIKE SUBSTRB(@[s_vvd],9)||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_bkg_no_all} != '')" ).append("\n"); 
		query.append("   		AND A.BKG_NO = @[s_bkg_no_all]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_bl_no_all} != '')" ).append("\n"); 
		query.append("   		AND A.BL_NO = @[s_bl_no_all]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_eq_knd_cd} != '')" ).append("\n"); 
		query.append("   		AND A.EQ_KND_CD = @[s_eq_knd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_eq_no} != '')" ).append("\n"); 
		query.append("   		AND A.EQ_NO = @[s_eq_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${s_vndr_cust_div_cd} != '') " ).append("\n"); 
		query.append("    	AND A.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("		#if ( ${s_trd_party_val} != '') " ).append("\n"); 
		query.append("			#if ( ${s_vndr_cust_div_cd} == 'V') " ).append("\n"); 
		query.append("    			AND A.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("			#elseif( ${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("				AND A.CUST_CNT_CD = SUBSTRB(TRIM(@[s_trd_party_val]),1,2)" ).append("\n"); 
		query.append("				#if ( $s_trd_party_val.length() > 2)" ).append("\n"); 
		query.append("    				AND A.CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[s_trd_party_val]),3))" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#elseif( ${s_vndr_cust_div_cd} == 'S') " ).append("\n"); 
		query.append("				AND A.N3PTY_OFC_CD = @[s_trd_party_val]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--//" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("--//" ).append("\n"); 
		query.append("SELECT A.N3PTY_NO," ).append("\n"); 
		query.append("       B.N3PTY_INV_NO," ).append("\n"); 
		query.append("       R.N3PTY_INV_RVIS_SEQ AS LST_N3PTY_INV_RVIS_SEQ," ).append("\n"); 
		query.append("       R.N3PTY_INV_RVIS_CD," ).append("\n"); 
		query.append("       B.N3PTY_EXPN_TP_CD," ).append("\n"); 
		query.append("       B.N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("       NVL(TPB_GET_N3PTY_BIL_TP_NM_FNC(B.N3PTY_BIL_TP_CD),TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD)) AS N3PTY_BIL_TP_NM, " ).append("\n"); 
		query.append("       A.N3PTY_SRC_NO," ).append("\n"); 
		query.append("       A.EQ_NO," ).append("\n"); 
		query.append("       A.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("       DECODE(B.VNDR_CUST_DIV_CD,'V',LPAD(B.VNDR_SEQ,6,0),'C',B.CUST_CNT_CD||LPAD(B.CUST_SEQ,6,0),'S',B.N3PTY_OFC_CD,'') AS N3PTY_CD," ).append("\n"); 
		query.append("       DECODE(B.VNDR_CUST_DIV_CD,'V',VNDR_LGL_ENG_NM,'C',CUST_LGL_ENG_NM,'S',B.N3PTY_OFC_CD,'') AS N3PTY_NM," ).append("\n"); 
		query.append("       B.VSL_CD||B.SKD_VOY_NO||B.FINC_DIR_CD AS REV_VVD," ).append("\n"); 
		query.append("       A.IF_CURR_CD, IF_AMT, --(SELECT IF_AMT FROM TPB_OTS_DTL WHERE N3PTY_NO = B.N3PTY_NO AND N3PTY_BIL_TP_CD = A.N3PTY_BIL_TP_CD) AS IF_AMT," ).append("\n"); 
		query.append("       TPB_GET_USD_AMT_FNC(IF_AMT,A.IF_CURR_CD,TPB_GET_LCL_DATE_FNC(A.IF_DT,B.OFC_CD)) AS IF_AMT_USD," ).append("\n"); 
		query.append("       A.CFM_CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("       A.OTS_AMT," ).append("\n"); 
		query.append("       A.INV_AMT AS RVS_AMT," ).append("\n"); 
		query.append("       DECODE( (SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO)" ).append("\n"); 
		query.append("    	 ,0,A.CFM_USR_ID" ).append("\n"); 
		query.append("    	 ,(SELECT CRE_USR_ID FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO AND OTS_STS_SEQ = (SELECT MAX(OTS_STS_SEQ) FROM TPB_OTS_GRP_STS WHERE N3PTY_NO = B.N3PTY_NO AND OTS_STS_CD = 'T'))" ).append("\n"); 
		query.append("    	 ) AS CFM_USR_ID," ).append("\n"); 
		query.append("       DECODE( (SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO)" ).append("\n"); 
		query.append("       	 ,0,(SELECT USR_NM FROM COM_USER U WHERE U.USR_ID = A.CFM_USR_ID)" ).append("\n"); 
		query.append("    	 ,(SELECT USR_NM FROM COM_USER U WHERE U.USR_ID = (SELECT CRE_USR_ID FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO AND OTS_STS_SEQ = (SELECT MAX(OTS_STS_SEQ) FROM TPB_OTS_GRP_STS WHERE N3PTY_NO = B.N3PTY_NO AND OTS_STS_CD = 'T')))" ).append("\n"); 
		query.append("    	 ) AS CFM_USR_NM," ).append("\n"); 
		query.append("       DECODE( (SELECT COUNT(1) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO)" ).append("\n"); 
		query.append("    	 ,0,TO_CHAR(TPB_GET_LCL_DATE_FNC(B.CFM_DT,@[s_user_ofc_cd]),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("    	 ,TO_CHAR(TPB_GET_LCL_DATE_FNC((SELECT MAX(CRE_DT) FROM TPB_OTS_GRP_STS WHERE OTS_STS_CD = 'T' AND N3PTY_NO = B.N3PTY_NO),@[s_user_ofc_cd]),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("    	 ) AS CFM_DT," ).append("\n"); 
		query.append("       TRUNC(SYSDATE - B.CFM_DT) AS OVERDUE," ).append("\n"); 
		query.append("       NVL2(R.CLT_DT, R.UPD_USR_ID, '') AS ERPIF_USR_ID," ).append("\n"); 
		query.append("       NVL2(R.CLT_DT, ( SELECT USR_NM FROM COM_USER U WHERE U.USR_ID = R.UPD_USR_ID ), '') AS ERPIF_USR_NM," ).append("\n"); 
		query.append("   	   TO_CHAR(TPB_GET_LCL_DATE_FNC(R.CLT_DT,@[s_user_ofc_cd]),'YYYY-MM-DD HH24:MI') AS ERPIF_DT," ).append("\n"); 
		query.append("       TO_CHAR(TPB_GET_RCVR_ACT_YN_FNC(B.N3PTY_NO)) AS RCVR_ACT_YN," ).append("\n"); 
		query.append("       'N' AS INVOICE_ABLE," ).append("\n"); 
		query.append("       'Y' AS REVISE_ABLE, -- REVISE" ).append("\n"); 
		query.append("       CASE WHEN R.CLT_AGN_FLG='Y' THEN 'N'" ).append("\n"); 
		query.append("       	    WHEN R.N3PTY_INV_STS_CD='N' THEN 'Y'" ).append("\n"); 
		query.append("    	    ELSE 'N'" ).append("\n"); 
		query.append("    	    END AS ERPIF_ABLE, --- ERP I/F" ).append("\n"); 
		query.append("       ( SELECT COUNT(DISTINCT N3PTY_BIL_TP_CD) FROM TPB_OTS_DTL K WHERE K.N3PTY_NO=A.N3PTY_NO ) AS LENGTH_N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("       TO_CHAR(R.IDA_TAX_SEQ) AS IDA_TAX_SEQ," ).append("\n"); 
		query.append("       DECODE(B.VNDR_CUST_DIV_CD,'V',TO_CHAR(B.VNDR_SEQ),'C',B.CUST_CNT_CD||TO_CHAR(B.CUST_SEQ),'S',B.N3PTY_OFC_CD,'') AS N3PTY_CD_O" ).append("\n"); 
		query.append("       ,A.N3PTY_NO  AS s_eq_no --2016.09.13 Radio grouping temp key " ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL A," ).append("\n"); 
		query.append("       TPB_OTS_GRP B," ).append("\n"); 
		query.append("       TPB_OTS_GRP_STS C," ).append("\n"); 
		query.append("       TPB_INVOICE V," ).append("\n"); 
		query.append("       TPB_INV_RVIS R" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("   AND B.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("   AND B.N3PTY_INV_NO = V.N3PTY_INV_NO" ).append("\n"); 
		query.append("   AND B.N3PTY_INV_NO = R.N3PTY_INV_NO" ).append("\n"); 
		query.append("   AND V.LST_N3PTY_INV_RVIS_SEQ = R.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("   --AND A.N3PTY_NO_DP_SEQ = 1" ).append("\n"); 
		query.append("   AND A.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("   AND A.N3PTY_BIL_TP_CD IN ( SELECT N3PTY_BIL_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE ACT_FLG = 'Y' AND N3PTY_BIL_TP_CD != 'JO' )" ).append("\n"); 
		query.append("   AND B.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("   AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("   AND C.OTS_STS_CD IN ('I','Y','A','L','N','E')" ).append("\n"); 
		query.append("#if (${s_n3pty_no} == '' && ${s_n3pty_inv_no_search} == '' && ${s_bkg_no_all} == '' && ${s_bl_no_all} == '')" ).append("\n"); 
		query.append("	#if (${s_status} == 'O')" ).append("\n"); 
		query.append("   		AND 1 = 0" ).append("\n"); 
		query.append("	#elseif (${s_status} == 'I')" ).append("\n"); 
		query.append("   		AND C.OTS_STS_CD IN ('I','Y','N')" ).append("\n"); 
		query.append("	#elseif (${s_status} == 'E')" ).append("\n"); 
		query.append("   		AND C.OTS_STS_CD IN ('A','L','E')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND V.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("   AND R.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("   AND B.OFC_CD = @[s_user_ofc_cd]" ).append("\n"); 
		query.append("#if (${s_n3pty_no_strs_link} != '' && $s_n3pty_no_strs_link.size() > 0)" ).append("\n"); 
		query.append("	 AND A.N3PTY_NO IN ( NULL" ).append("\n"); 
		query.append("	 #foreach($s_n3pty_no_strs_link IN ${s_n3pty_no_strs_link})" ).append("\n"); 
		query.append("	 	#if($velocityCount < $s_n3pty_no_strs_link.size())" ).append("\n"); 
		query.append("	 	,'$s_n3pty_no_strs_link'," ).append("\n"); 
		query.append("	 	#else" ).append("\n"); 
		query.append("	 	,'$s_n3pty_no_strs_link'" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${s_n3pty_no} == '' && ${s_n3pty_inv_no_search} == '' && ${s_sdate} != '' && ${s_edate} != '')" ).append("\n"); 
		query.append("   		AND B.CFM_DT BETWEEN TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[s_user_ofc_cd]) AND TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[s_user_ofc_cd]) + 1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("   		AND A.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_n3pty_inv_no_search} != '')" ).append("\n"); 
		query.append("   		AND B.N3PTY_INV_NO = @[s_n3pty_inv_no_search]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_n3pty_expn_tp_cd} != '')" ).append("\n"); 
		query.append("   		AND B.N3PTY_EXPN_TP_CD = @[s_n3pty_expn_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_n3pty_src_no} != '')" ).append("\n"); 
		query.append("   		AND A.N3PTY_SRC_NO = @[s_n3pty_src_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_vvd} != '')" ).append("\n"); 
		query.append("   		AND B.VSL_CD = SUBSTRB(@[s_vvd],1,4)" ).append("\n"); 
		query.append("   		AND B.SKD_VOY_NO = SUBSTRB(@[s_vvd],5,4)" ).append("\n"); 
		query.append("   		AND B.FINC_DIR_CD LIKE SUBSTRB(@[s_vvd],9)||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_bkg_no_all} != '')" ).append("\n"); 
		query.append("   		AND A.BKG_NO = @[s_bkg_no_all]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_bl_no_all} != '')" ).append("\n"); 
		query.append("   		AND A.BL_NO = @[s_bl_no_all]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_eq_knd_cd} != '')" ).append("\n"); 
		query.append("   		AND A.EQ_KND_CD = @[s_eq_knd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_eq_no} != '')" ).append("\n"); 
		query.append("   		AND A.EQ_NO = @[s_eq_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${s_vndr_cust_div_cd} != '') " ).append("\n"); 
		query.append("    	AND A.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("		#if ( ${s_trd_party_val} != '') " ).append("\n"); 
		query.append("			#if ( ${s_vndr_cust_div_cd} == 'V') " ).append("\n"); 
		query.append("    			AND A.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("			#elseif( ${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("				AND A.CUST_CNT_CD = SUBSTRB(TRIM(@[s_trd_party_val]),1,2)" ).append("\n"); 
		query.append("				#if ( $s_trd_party_val.length() > 2)" ).append("\n"); 
		query.append("    				AND A.CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[s_trd_party_val]),3))" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#elseif( ${s_vndr_cust_div_cd} == 'S') " ).append("\n"); 
		query.append("				AND A.N3PTY_OFC_CD = @[s_trd_party_val]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}