/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AdjustmentManageDBDAOSearchResponsibleOfficeChangeInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentManageDBDAOSearchResponsibleOfficeChangeInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchResponsibleOfficeChangeInquiry
	  * </pre>
	  */
	public AdjustmentManageDBDAOSearchResponsibleOfficeChangeInquiryRSQL(){
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
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_calendar_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_calendar_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.integration").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOSearchResponsibleOfficeChangeInquiryRSQL").append("\n"); 
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
		query.append("SELECT DECODE(S.OTS_STS_CD,'R',DECODE(@[s_user_ofc_cd],A.STL_TO_CLT_CNG_OFC_CD,'Y','N'),'N') AS APPROVAL," ).append("\n"); 
		query.append("       0 AS CHK_REQ," ).append("\n"); 
		query.append("       0 AS CHK_APP," ).append("\n"); 
		query.append("       0 AS CHK_REJ," ).append("\n"); 
		query.append("       A.STL_TO_CLT_CNG_OFC_CD," ).append("\n"); 
		query.append("       A.N3PTY_NO," ).append("\n"); 
		query.append("       ------------- request -------------" ).append("\n"); 
		query.append("       TO_CHAR(TPB_GET_LCL_DATE_FNC(A.STL_RQST_DT,@[s_user_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS STL_RQST_DT," ).append("\n"); 
		query.append("       A.STL_RQST_OFC_CD," ).append("\n"); 
		query.append("       A.STL_RQST_USR_ID," ).append("\n"); 
		query.append("       ------------- approve -------------" ).append("\n"); 
		query.append("       TO_CHAR(TPB_GET_LCL_DATE_FNC(A.STL_APRO_DT,@[s_user_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS STL_APRO_DT," ).append("\n"); 
		query.append("       A.STL_APRO_OFC_CD," ).append("\n"); 
		query.append("       A.STL_APRO_USR_ID," ).append("\n"); 
		query.append("       ------------- reject --------------" ).append("\n"); 
		query.append("       TO_CHAR(TPB_GET_LCL_DATE_FNC(A.STL_RJCT_DT,@[s_user_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS STL_RJCT_DT," ).append("\n"); 
		query.append("       A.STL_RJCT_OFC_CD," ).append("\n"); 
		query.append("       A.STL_RJCT_USR_ID," ).append("\n"); 
		query.append("       -----------------------------------" ).append("\n"); 
		query.append("       D.N3PTY_SRC_SUB_SYS_CD," ).append("\n"); 
		query.append("       G.N3PTY_INV_NO," ).append("\n"); 
		query.append("       S.OTS_STS_CD," ).append("\n"); 
		query.append("       DECODE(A.STL_APRO_OFC_CD,NULL,DECODE(A.STL_RJCT_OFC_CD,NULL,DECODE(S.OTS_STS_CD,'R','Requested','Canceled'),'Rejected'),'Accepted') AS OTS_STS_CD_VAL," ).append("\n"); 
		query.append("       D.BKG_NO, -- || D.BKG_NO_SPLIT BKG_NO" ).append("\n"); 
		query.append("       D.BL_NO, -- || D.BL_NO_TP || D.BL_NO_CHK BL_NO" ).append("\n"); 
		query.append("       D.EQ_NO," ).append("\n"); 
		query.append("       --TPB_GET_RHQ_CD_FNC(G.OFC_CD) AS IF_RHQ_CD," ).append("\n"); 
		query.append("       TPB_GET_HNDL_OFC_FNC('R',NVL(D.N3PTY_OFC_CD,D.OFC_CD)) AS IF_RHQ_CD," ).append("\n"); 
		query.append("       G.OFC_CD AS IF_OFC_CD," ).append("\n"); 
		query.append("       DECODE(D.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("            'V',LPAD(TO_CHAR(D.VNDR_SEQ),6,'0')," ).append("\n"); 
		query.append("            'C',D.CUST_CNT_CD || LPAD(TO_CHAR(D.CUST_SEQ),6,'0')," ).append("\n"); 
		query.append("            'S',D.N3PTY_OFC_CD, NULL) AS N3PTY," ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("       'USD' AS CURR_CD," ).append("\n"); 
		query.append("       TPB_GET_USD_AMT_FNC(G.OTS_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS OTS_AMT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       D.CFM_CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("       G.OTS_AMT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       TO_CHAR(TPB_GET_LCL_DATE_FNC(G.CFM_DT,@[s_user_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS CFM_DT," ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("       TPB_GET_USD_AMT_FNC(G.INV_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS INV_AMT," ).append("\n"); 
		query.append("       TPB_GET_USD_AMT_FNC(G.CLT_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS CLT_AMT," ).append("\n"); 
		query.append("       TPB_GET_USD_AMT_FNC(G.ADJ_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS ADJ_AMT," ).append("\n"); 
		query.append("       TPB_GET_USD_AMT_FNC(G.BAL_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS BAL_AMT," ).append("\n"); 
		query.append("       TPB_GET_USD_AMT_FNC(A.STL_CLT_OFC_CNG_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS STL_CLT_OFC_CNG_AMT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       G.INV_AMT, " ).append("\n"); 
		query.append("       G.CLT_AMT, " ).append("\n"); 
		query.append("       G.ADJ_AMT, " ).append("\n"); 
		query.append("       G.BAL_AMT, " ).append("\n"); 
		query.append("       A.STL_CLT_OFC_CNG_AMT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       --TPB_GET_CLT_ACT_YN_FNC(G.N3PTY_NO, G.N3PTY_INV_NO) AS CLT_ACT_YN," ).append("\n"); 
		query.append("       (SELECT COUNT(1) FROM TPB_OTS_GRP_RCVR_ACT WHERE N3PTY_NO = A.N3PTY_NO AND N3PTY_CLT_RMK_TP_CD = 'M' AND ROWNUM = 1 ) AS CLT_ACT_YN," ).append("\n"); 
		query.append("       TO_CHAR(TPB_GET_LCL_DATE_FNC((SELECT MAX(STL_RQST_DT) FROM TPB_ADJ_STS WHERE N3PTY_NO = A.N3PTY_NO AND N3PTY_STL_TP_CD = 'O'), @[s_user_ofc_cd]),'YYYY-MM-DD HH24:MI') AS STL_RQST_DT," ).append("\n"); 
		query.append("       DECODE(A.STL_FWRD_OFC_CD, NULL, A.STL_TO_CLT_CNG_OFC_CD, A.STL_FWRD_OFC_CD) AS REVIEW_STEP" ).append("\n"); 
		query.append("  FROM TPB_ADJ_STS A," ).append("\n"); 
		query.append("       TPB_OTS_DTL D," ).append("\n"); 
		query.append("       TPB_OTS_GRP G," ).append("\n"); 
		query.append("       TPB_OTS_GRP_STS S" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.N3PTY_NO = D.N3PTY_NO" ).append("\n"); 
		query.append("   AND D.N3PTY_NO_DP_SEQ = '1'" ).append("\n"); 
		query.append("   AND A.N3PTY_NO = G.N3PTY_NO" ).append("\n"); 
		query.append("   AND G.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("   AND A.N3PTY_NO = S.N3PTY_NO" ).append("\n"); 
		query.append("   AND S.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("   AND S.OTS_STS_CD != 'D'" ).append("\n"); 
		query.append("   AND D.N3PTY_NO_DP_SEQ = 1" ).append("\n"); 
		query.append("   AND A.N3PTY_STL_TP_CD = 'O'" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("   AND A.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A.STL_RQST_DT >= TPB_GET_SRCH_DATE_FNC(@[s_calendar_date1],'YYYY-MM-DD',@[s_user_ofc_cd])" ).append("\n"); 
		query.append("   AND A.STL_RQST_DT <  TPB_GET_SRCH_DATE_FNC(@[s_calendar_date2],'YYYY-MM-DD',@[s_user_ofc_cd]) + 1" ).append("\n"); 
		query.append("   #if (${s_vndr_cust_div_cd} != '')" ).append("\n"); 
		query.append("        AND G.vndr_cust_div_cd = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("            #if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("                #if (${s_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("                    AND G.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("                #elseif (${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("                    AND G.CUST_CNT_CD = SUBSTRB(TRIM(@[s_trd_party_val]),1,2)" ).append("\n"); 
		query.append("                    #if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("                        AND G.CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[s_trd_party_val]),3))" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #elseif (${s_vndr_cust_div_cd} == 'S')" ).append("\n"); 
		query.append("                    AND G.N3PTY_OFC_CD = @[s_trd_party_val]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_date_flag_i} == 'OL' || ${s_date_flag_i} == 'OA' || ${s_date_flag_i} == 'OR')" ).append("\n"); 
		query.append("    AND A.STL_RQST_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("								 FROM ( SELECT DISTINCT T.RHQ_CD, T.N3PTY_CTRL_OFC_CD, T.OFC_CD" ).append("\n"); 
		query.append("										  FROM TPB_HNDL_OFC T," ).append("\n"); 
		query.append("											   ( SELECT N3PTY_OFC_TP_CD, OFC_CD, N3PTY_CTRL_OFC_CD, RHQ_CD" ).append("\n"); 
		query.append("												   FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("												  WHERE OFC_CD = @[s_user_ofc_cd]" ).append("\n"); 
		query.append("													AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("												) L" ).append("\n"); 
		query.append("										 WHERE 1=1" ).append("\n"); 
		query.append("										   AND T.OFC_CD = L.OFC_CD" ).append("\n"); 
		query.append("											OR T.N3PTY_CTRL_OFC_CD = L.N3PTY_CTRL_OFC_CD" ).append("\n"); 
		query.append("											OR T.RHQ_CD = L.OFC_CD" ).append("\n"); 
		query.append("										   AND T.DELT_FLG = 'N'	" ).append("\n"); 
		query.append("										   AND L.N3PTY_OFC_TP_CD = 'R'" ).append("\n"); 
		query.append("										UNION" ).append("\n"); 
		query.append("										SELECT DISTINCT RHQ_CD, N3PTY_CTRL_OFC_CD, OFC_CD FROM TPB_HNDL_OFC WHERE DELT_FLG = 'N' " ).append("\n"); 
		query.append("							   ) WHERE 1=1" ).append("\n"); 
		query.append("								#if(${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("									AND RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("									#if(${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("										AND N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("										#if(${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("											AND OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("    #if (${s_date_flag_i} == 'OA')" ).append("\n"); 
		query.append("        AND A.STL_APRO_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("    #elseif (${s_date_flag_i} == 'OR')" ).append("\n"); 
		query.append("        AND A.STL_RJCT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("#elseif (${s_date_flag_i} == 'IL' || ${s_date_flag_i} == 'IA' || ${s_date_flag_i} == 'IR')" ).append("\n"); 
		query.append("    AND A.STL_TO_CLT_CNG_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("									   FROM ( SELECT DISTINCT T.RHQ_CD, T.N3PTY_CTRL_OFC_CD, T.OFC_CD" ).append("\n"); 
		query.append("												FROM TPB_HNDL_OFC T," ).append("\n"); 
		query.append("												     ( SELECT N3PTY_OFC_TP_CD, OFC_CD, N3PTY_CTRL_OFC_CD, RHQ_CD" ).append("\n"); 
		query.append("													     FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("													    WHERE OFC_CD = @[s_user_ofc_cd] " ).append("\n"); 
		query.append("														AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("														) L" ).append("\n"); 
		query.append("											   WHERE 1=1" ).append("\n"); 
		query.append("												 AND T.OFC_CD = L.OFC_CD" ).append("\n"); 
		query.append("												  OR T.N3PTY_CTRL_OFC_CD = L.N3PTY_CTRL_OFC_CD" ).append("\n"); 
		query.append("												  OR T.RHQ_CD = L.OFC_CD" ).append("\n"); 
		query.append("												 AND L.N3PTY_OFC_TP_CD = 'R'" ).append("\n"); 
		query.append("											  UNION" ).append("\n"); 
		query.append("											  SELECT DISTINCT RHQ_CD, N3PTY_CTRL_OFC_CD, OFC_CD FROM TPB_HNDL_OFC WHERE 1=1 AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("									 ) WHERE 1=1" ).append("\n"); 
		query.append("									 #if(${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("									     AND RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("											#if(${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("												AND N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("												#if(${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("													AND OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("											#end" ).append("\n"); 
		query.append("									 #end" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("    #if (${s_date_flag_i} == 'IA')" ).append("\n"); 
		query.append("        AND A.STL_APRO_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("    #elseif (${s_date_flag_i} == 'IR')" ).append("\n"); 
		query.append("        AND A.STL_RJCT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY N3PTY_NO" ).append("\n"); 

	}
}