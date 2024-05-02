/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OutstandinggroupManageDBDAOSearchTPBGroupRemakingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.12
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.04.12 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OutstandinggroupManageDBDAOSearchTPBGroupRemakingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPBGroupRemaking
	  * </pre>
	  */
	public OutstandinggroupManageDBDAOSearchTPBGroupRemakingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_no_search",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.integration").append("\n"); 
		query.append("FileName : OutstandinggroupManageDBDAOSearchTPBGroupRemakingRSQL").append("\n"); 
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
		query.append("SELECT '' AS GRP_SRT_NO," ).append("\n"); 
		query.append("A.OTS_DTL_SEQ," ).append("\n"); 
		query.append("A.N3PTY_NO AS N3PTY_NO_ORG," ).append("\n"); 
		query.append("A.N3PTY_NO_DP_SEQ AS N3PTY_NO_DP_SEQ_ORG," ).append("\n"); 
		query.append("A.N3PTY_NO AS N3PTY_NO," ).append("\n"); 
		query.append("A.N3PTY_NO_DP_SEQ," ).append("\n"); 
		query.append("A.N3PTY_EXPN_TP_CD," ).append("\n"); 
		query.append("A.N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM," ).append("\n"); 
		query.append("A.N3PTY_SRC_NO," ).append("\n"); 
		query.append("A.BKG_NO AS BKG_NO_ALL," ).append("\n"); 
		query.append("A.BL_NO AS BL_NO_ALL," ).append("\n"); 
		query.append("A.VSL_CD || A.SKD_VOY_NO || SUBSTR(A.FINC_DIR_CD,1,1) AS REV_VVD," ).append("\n"); 
		query.append("A.VVD_CD AS ACT_VVD, A.CSR_NO, SUBSTRB(A.GL_DT,1,6) AS GL_MONTH," ).append("\n"); 
		query.append("A.EQ_NO," ).append("\n"); 
		query.append("CASE A.VNDR_CUST_DIV_CD WHEN 'V' THEN LPAD(TO_CHAR(A.VNDR_SEQ),6,'0')" ).append("\n"); 
		query.append("WHEN 'C' THEN A.CUST_CNT_CD || LPAD(A.CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("WHEN 'S' THEN A.N3PTY_OFC_CD" ).append("\n"); 
		query.append("END AS TRD_PARTY_CODE," ).append("\n"); 
		query.append("CASE A.VNDR_CUST_DIV_CD WHEN 'V' THEN A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("WHEN 'C' THEN A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("WHEN 'S' THEN A.N3PTY_OFC_CD" ).append("\n"); 
		query.append("END AS TRD_PARTY_NAME," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588','Z') AS OTS_STS_NM," ).append("\n"); 
		query.append("DECODE( (SELECT COUNT(1) FROM TPB_OTS_GRP G, TPB_ADJ_STS D, TPB_OTS_GRP_STS S" ).append("\n"); 
		query.append("WHERE G.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("--AND D.STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND S.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND D.STL_TO_CLT_CNG_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND D.STL_APRO_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND G.N3PTY_NO = D.N3PTY_NO" ).append("\n"); 
		query.append("AND D.N3PTY_NO = S.N3PTY_NO" ).append("\n"); 
		query.append("AND D.N3PTY_NO = A.N3PTY_NO),0,'Y','N') AS CANDIDATE_YN," ).append("\n"); 
		query.append("DECODE(A.FM_CLT_CNG_OFC_N3PTY_NO,NULL,'Y','N') AS ROC_CANDIDATE_YN," ).append("\n"); 
		query.append("A.IF_CURR_CD," ).append("\n"); 
		query.append("A.IF_AMT," ).append("\n"); 
		query.append("A.CFM_CURR_CD," ).append("\n"); 
		query.append("A.CFM_AMT" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.N3PTY_NO IS NULL" ).append("\n"); 
		query.append("AND A.OFC_CD IN ( SELECT OFC_CD FROM TPB_HNDL_OFC WHERE N3PTY_OFC_TP_CD = 'T' AND DELT_FLG = 'N' AND RHQ_CD = @[s_if_rhq_cd] AND OFC_CD = @[s_if_ofc_cd] )" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD IN ('N','C','S')" ).append("\n"); 
		query.append("AND A.N3PTY_BIL_TP_CD IN ( SELECT N3PTY_BIL_TP_CD FROM (SELECT N3PTY_BIL_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE ACT_FLG = 'Y' AND N3PTY_BIL_TP_CD != 'JO') )" ).append("\n"); 
		query.append("#if (${s_n3pty_no_search} == '' && ${s_bkg_no_all} == '' && ${s_bl_no_all} == '' && ${s_sdate} != '' && ${s_edate} != '' && ${s_user_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.IF_DT BETWEEN TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[s_user_ofc_cd]) AND TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[s_user_ofc_cd]) + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_src_sub_sys_cd} != '')" ).append("\n"); 
		query.append("AND A.N3PTY_EXPN_TP_CD = @[s_n3pty_src_sub_sys_cd]" ).append("\n"); 
		query.append("#if (${s_n3pty_bil_tp_cd} != '')" ).append("\n"); 
		query.append("AND A.N3PTY_BIL_TP_CD = @[s_n3pty_bil_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_vndr_cust_div_cd} != '')" ).append("\n"); 
		query.append("AND A.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("#if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("#if (${s_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("#elseif (${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = SUBSTRB(TRIM(@[s_vndr_cust_div_cd]),1,2)" ).append("\n"); 
		query.append("#elseif (${s_vndr_cust_div_cd} == 'S')" ).append("\n"); 
		query.append("AND A.N3PTY_OFC_CD = @[s_trd_party_val]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_vvd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD = SUBSTRB(@[s_vvd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTRB(@[s_vvd],5,4)" ).append("\n"); 
		query.append("AND A.FINC_DIR_CD LIKE SUBSTRB(@[s_vvd],9) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bkg_no_all} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO = @[s_bkg_no_all]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bl_no_all} != '')" ).append("\n"); 
		query.append("AND A.BL_NO = @[s_bl_no_all]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_eq_no} != '')" ).append("\n"); 
		query.append("AND A.EQ_NO = @[s_eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_no_search} != '')" ).append("\n"); 
		query.append("AND 0=1	-- n3pty_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_candidate_include_flag} == 'E')" ).append("\n"); 
		query.append("AND 0=1	-- candidate exclude" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--//" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("--//" ).append("\n"); 
		query.append("SELECT '' AS GRP_SRT_NO," ).append("\n"); 
		query.append("A.OTS_DTL_SEQ," ).append("\n"); 
		query.append("A.N3PTY_NO AS N3PTY_NO_ORG," ).append("\n"); 
		query.append("A.N3PTY_NO_DP_SEQ AS N3PTY_NO_DP_SEQ_ORG," ).append("\n"); 
		query.append("A.N3PTY_NO AS N3PTY_NO," ).append("\n"); 
		query.append("A.N3PTY_NO_DP_SEQ," ).append("\n"); 
		query.append("A.N3PTY_EXPN_TP_CD," ).append("\n"); 
		query.append("A.N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM," ).append("\n"); 
		query.append("A.N3PTY_SRC_NO," ).append("\n"); 
		query.append("A.BKG_NO AS BKG_NO_ALL," ).append("\n"); 
		query.append("A.BL_NO AS BL_NO_ALL," ).append("\n"); 
		query.append("A.VSL_CD || A.SKD_VOY_NO || SUBSTR(A.FINC_DIR_CD,1,1) AS REV_VVD," ).append("\n"); 
		query.append("A.VVD_CD AS ACT_VVD, A.CSR_NO, SUBSTRB(A.GL_DT,1,6) AS GL_MONTH, A.EQ_NO," ).append("\n"); 
		query.append("CASE A.VNDR_CUST_DIV_CD WHEN 'V' THEN LPAD(TO_CHAR(A.VNDR_SEQ),6,'0')" ).append("\n"); 
		query.append("WHEN 'C' THEN A.CUST_CNT_CD || LPAD(A.CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("WHEN 'S' THEN A.N3PTY_OFC_CD" ).append("\n"); 
		query.append("END AS TRD_PARTY_CODE," ).append("\n"); 
		query.append("CASE A.VNDR_CUST_DIV_CD WHEN 'V' THEN A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("WHEN 'C' THEN A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("WHEN 'S' THEN A.N3PTY_OFC_CD" ).append("\n"); 
		query.append("END AS TRD_PARTY_NAME," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588',C.OTS_STS_CD) AS OTS_STS_NM," ).append("\n"); 
		query.append("DECODE( (SELECT COUNT(1) FROM TPB_OTS_GRP G, TPB_ADJ_STS D, TPB_OTS_GRP_STS S" ).append("\n"); 
		query.append("WHERE G.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("--AND D.STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND S.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND D.STL_TO_CLT_CNG_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND D.STL_APRO_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND G.N3PTY_NO = D.N3PTY_NO" ).append("\n"); 
		query.append("AND D.N3PTY_NO = S.N3PTY_NO" ).append("\n"); 
		query.append("AND D.N3PTY_NO = B.N3PTY_NO),0,'Y','N') AS CANDIDATE_YN," ).append("\n"); 
		query.append("DECODE(A.FM_CLT_CNG_OFC_N3PTY_NO,NULL,'Y','N') AS ROC_CANDIDATE_YN," ).append("\n"); 
		query.append("A.IF_CURR_CD," ).append("\n"); 
		query.append("A.IF_AMT," ).append("\n"); 
		query.append("A.CFM_CURR_CD," ).append("\n"); 
		query.append("A.CFM_AMT" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP B," ).append("\n"); 
		query.append("TPB_OTS_DTL A," ).append("\n"); 
		query.append("TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("AND B.N3PTY_NO = A.N3PTY_NO" ).append("\n"); 
		query.append("AND B.OFC_CD IN ( SELECT OFC_CD FROM TPB_HNDL_OFC WHERE N3PTY_OFC_TP_CD = 'T' AND DELT_FLG = 'N' AND RHQ_CD = @[s_if_rhq_cd] AND OFC_CD = @[s_if_ofc_cd] )" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("AND B.N3PTY_DELT_TP_CD IN ('N')" ).append("\n"); 
		query.append("AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND C.OTS_STS_CD IN ('O','M','J')" ).append("\n"); 
		query.append("AND A.N3PTY_BIL_TP_CD IN ( SELECT N3PTY_BIL_TP_CD FROM (SELECT N3PTY_BIL_TP_CD FROM TPB_N3RD_PTY_BIL_TP WHERE ACT_FLG = 'Y' AND N3PTY_BIL_TP_CD != 'JO') )" ).append("\n"); 
		query.append("#if (${s_n3pty_no_search} == '' && ${s_bkg_no_all} == '' && ${s_bl_no_all} == '' && ${s_sdate} != '' && ${s_edate} != '' && ${s_user_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.CFM_DT BETWEEN TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[s_user_ofc_cd]) AND TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[s_user_ofc_cd]) + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_src_sub_sys_cd} != '')" ).append("\n"); 
		query.append("AND A.N3PTY_EXPN_TP_CD = @[s_n3pty_src_sub_sys_cd]" ).append("\n"); 
		query.append("#if (${s_n3pty_bil_tp_cd} != '')" ).append("\n"); 
		query.append("AND A.N3PTY_BIL_TP_CD = @[s_n3pty_bil_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_vndr_cust_div_cd} != '')" ).append("\n"); 
		query.append("AND A.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("#if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("#if (${s_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("#elseif (${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = SUBSTRB(TRIM(@[s_vndr_cust_div_cd]),1,2)" ).append("\n"); 
		query.append("#elseif (${s_vndr_cust_div_cd} == 'S')" ).append("\n"); 
		query.append("AND A.N3PTY_OFC_CD = @[s_trd_party_val]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_vvd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD = SUBSTRB(@[s_vvd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTRB(@[s_vvd],5,4)" ).append("\n"); 
		query.append("AND A.FINC_DIR_CD LIKE SUBSTRB(@[s_vvd],9) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bkg_no_all} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO = @[s_bkg_no_all]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bl_no_all} != '')" ).append("\n"); 
		query.append("AND A.BL_NO = @[s_bl_no_all]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_eq_no} != '')" ).append("\n"); 
		query.append("AND A.EQ_NO = @[s_eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_no_search} != '')" ).append("\n"); 
		query.append("AND A.N3PTY_NO = @[s_n3pty_no_search]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY N3PTY_NO, N3PTY_NO_DP_SEQ" ).append("\n"); 

	}
}