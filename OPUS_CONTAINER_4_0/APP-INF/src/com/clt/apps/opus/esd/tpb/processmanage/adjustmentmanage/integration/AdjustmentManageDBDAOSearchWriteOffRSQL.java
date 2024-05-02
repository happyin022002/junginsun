/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AdjustmentManageDBDAOSearchWriteOffRSQL.java
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

public class AdjustmentManageDBDAOSearchWriteOffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchWriteOff
	  * </pre>
	  */
	public AdjustmentManageDBDAOSearchWriteOffRSQL(){
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
		query.append("FileName : AdjustmentManageDBDAOSearchWriteOffRSQL").append("\n"); 
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
		query.append("#if (${s_date_flag_r} == 'IN')" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("    SELECT 'Y' AS APPROVAL," ).append("\n"); 
		query.append("           '0' AS CHK_REQ," ).append("\n"); 
		query.append("           '0' AS CHK_APP," ).append("\n"); 
		query.append("           '0' AS CHK_REJ," ).append("\n"); 
		query.append("           A.STL_TO_CLT_CNG_OFC_CD," ).append("\n"); 
		query.append("           C.N3PTY_NO," ).append("\n"); 
		query.append("           ------------- request -------------" ).append("\n"); 
		query.append("           TO_CHAR(TPB_GET_LCL_DATE_FNC(A.STL_RQST_DT,(SELECT DISTINCT OFC_CD FROM (SELECT N3PTY_OFC_TP_CD, OFC_CD, N3PTY_CTRL_OFC_CD, RHQ_CD FROM TPB_HNDL_OFC WHERE OFC_CD = @[s_user_ofc_cd] AND DELT_FLG = 'N'))), 'YYYY-MM-DD HH24:MI') AS STL_RQST_DT," ).append("\n"); 
		query.append("           A.STL_RQST_OFC_CD," ).append("\n"); 
		query.append("           A.STL_RQST_USR_ID," ).append("\n"); 
		query.append("           ------------- approve -------------" ).append("\n"); 
		query.append("           TO_CHAR(TPB_GET_LCL_DATE_FNC(A.STL_APRO_DT,(SELECT DISTINCT OFC_CD FROM (SELECT N3PTY_OFC_TP_CD, OFC_CD, N3PTY_CTRL_OFC_CD, RHQ_CD FROM TPB_HNDL_OFC WHERE OFC_CD = @[s_user_ofc_cd] AND DELT_FLG = 'N'))), 'YYYY-MM-DD HH24:MI') AS STL_APRO_DT," ).append("\n"); 
		query.append("           A.STL_APRO_OFC_CD," ).append("\n"); 
		query.append("           A.STL_APRO_USR_ID," ).append("\n"); 
		query.append("           ------------- reject --------------" ).append("\n"); 
		query.append("           TO_CHAR(TPB_GET_LCL_DATE_FNC(A.STL_RJCT_DT,(SELECT DISTINCT OFC_CD FROM (SELECT N3PTY_OFC_TP_CD, OFC_CD, N3PTY_CTRL_OFC_CD, RHQ_CD FROM TPB_HNDL_OFC WHERE OFC_CD = @[s_user_ofc_cd] AND DELT_FLG = 'N'))), 'YYYY-MM-DD HH24:MI') AS STL_RJCT_DT," ).append("\n"); 
		query.append("           A.STL_RJCT_OFC_CD," ).append("\n"); 
		query.append("           A.STL_RJCT_USR_ID," ).append("\n"); 
		query.append("           -----------------------------------" ).append("\n"); 
		query.append("           B.N3PTY_SRC_SUB_SYS_CD," ).append("\n"); 
		query.append("           C.N3PTY_INV_NO," ).append("\n"); 
		query.append("           D.OTS_STS_CD," ).append("\n"); 
		query.append("           COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588', D.OTS_STS_CD) AS OTS_STS_CD_VAL," ).append("\n"); 
		query.append("           B.BKG_NO, -- || B.BKG_NO_SPLIT AS BKG_NO," ).append("\n"); 
		query.append("           B.BL_NO, -- || B.BL_NO_TP || B.BL_NO_CHK AS BL_NO," ).append("\n"); 
		query.append("           B.EQ_NO," ).append("\n"); 
		query.append("           --TPB_GET_RHQ_CD_FNC(C.OFC_CD) AS IF_RHQ_CD," ).append("\n"); 
		query.append("           TPB_GET_HNDL_OFC_FNC('R',NVL(B.N3PTY_OFC_CD,B.OFC_CD)) AS IF_RHQ_CD," ).append("\n"); 
		query.append("           C.OFC_CD AS IF_OFC_CD," ).append("\n"); 
		query.append("           DECODE(B.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("                'V', LPAD(TO_CHAR(B.VNDR_SEQ),6,'0')," ).append("\n"); 
		query.append("                'C', B.CUST_CNT_CD || LPAD(TO_CHAR(B.CUST_SEQ),6,'0')," ).append("\n"); 
		query.append("                'S', B.OFC_CD, NULL) AS N3PTY," ).append("\n"); 
		query.append("    #if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("           'USD' AS CURR_CD, " ).append("\n"); 
		query.append("           TPB_GET_USD_AMT_FNC(C.OTS_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD)) AS OTS_AMT," ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("           C.CURR_CD, " ).append("\n"); 
		query.append("           C.OTS_AMT," ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("           TO_CHAR(TPB_GET_LCL_DATE_FNC(C.CFM_DT, (SELECT DISTINCT OFC_CD FROM (SELECT N3PTY_OFC_TP_CD, OFC_CD, N3PTY_CTRL_OFC_CD, RHQ_CD FROM TPB_HNDL_OFC WHERE OFC_CD = @[s_user_ofc_cd] AND DELT_FLG = 'N'))), 'YYYY-MM-DD HH24:MI') AS CFM_DT," ).append("\n"); 
		query.append("    #if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("           TPB_GET_USD_AMT_FNC(C.INV_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD)) AS INV_AMT," ).append("\n"); 
		query.append("           TPB_GET_USD_AMT_FNC(C.CLT_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD)) AS CLT_AMT," ).append("\n"); 
		query.append("           TPB_GET_USD_AMT_FNC(C.ADJ_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD)) AS ADJ_AMT," ).append("\n"); 
		query.append("           TPB_GET_USD_AMT_FNC(C.BAL_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD)) AS BAL_AMT," ).append("\n"); 
		query.append("           TPB_GET_USD_AMT_FNC(A.STL_CLT_OFC_CNG_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD)) AS STL_CLT_OFC_CNG_AMT," ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("           C.INV_AMT, " ).append("\n"); 
		query.append("           C.CLT_AMT, " ).append("\n"); 
		query.append("           C.ADJ_AMT, " ).append("\n"); 
		query.append("           C.BAL_AMT, " ).append("\n"); 
		query.append("           A.STL_CLT_OFC_CNG_AMT," ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("           --TPB_GET_CLT_ACT_YN_FNC(C.N3PTY_NO, C.N3PTY_INV_NO) AS CLT_ACT_YN," ).append("\n"); 
		query.append("           (SELECT COUNT(1) FROM TPB_OTS_GRP_RCVR_ACT WHERE N3PTY_NO = C.N3PTY_NO AND N3PTY_CLT_RMK_TP_CD = 'M' AND ROWNUM = 1 ) AS CLT_ACT_YN," ).append("\n"); 
		query.append("           TO_CHAR( TPB_GET_LCL_DATE_FNC( (SELECT MAX(STL_RQST_DT) FROM TPB_ADJ_STS WHERE N3PTY_NO = C.N3PTY_NO AND N3PTY_STL_TP_CD = 'W')" ).append("\n"); 
		query.append("                                         ,(SELECT DISTINCT OFC_CD FROM (SELECT N3PTY_OFC_TP_CD, OFC_CD, N3PTY_CTRL_OFC_CD, RHQ_CD FROM TPB_HNDL_OFC WHERE OFC_CD = @[s_user_ofc_cd] AND DELT_FLG = 'N')))" ).append("\n"); 
		query.append("                                         ,'YYYY-MM-DD HH24:MI') AS FST_RQST_DT," ).append("\n"); 
		query.append("           DECODE(A.STL_FWRD_OFC_CD, NULL, A.STL_TO_CLT_CNG_OFC_CD, A.STL_FWRD_OFC_CD) AS STL_FWRD_OFC_CD" ).append("\n"); 
		query.append("      FROM TPB_ADJ_STS A," ).append("\n"); 
		query.append("           TPB_OTS_DTL B," ).append("\n"); 
		query.append("           TPB_OTS_GRP C," ).append("\n"); 
		query.append("           TPB_OTS_GRP_STS D" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("       AND B.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("       AND C.N3PTY_NO = D.N3PTY_NO" ).append("\n"); 
		query.append("       AND C.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("       AND D.OTS_STS_CD = 'R'" ).append("\n"); 
		query.append("       AND A.STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("       AND D.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("       AND B.N3PTY_NO_DP_SEQ = 1" ).append("\n"); 
		query.append("       AND A.N3PTY_STL_TP_CD = 'W'" ).append("\n"); 
		query.append("    #if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("       AND C.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("       AND C.CFM_DT >= TPB_GET_SRCH_DATE_FNC(@[s_calendar_date1], 'YYYY-MM-DD', (SELECT DISTINCT OFC_CD FROM (SELECT N3PTY_OFC_TP_CD, OFC_CD, N3PTY_CTRL_OFC_CD, RHQ_CD FROM TPB_HNDL_OFC WHERE OFC_CD = @[s_user_ofc_cd] AND DELT_FLG = 'N')))" ).append("\n"); 
		query.append("       AND C.CFM_DT <  TPB_GET_SRCH_DATE_FNC(@[s_calendar_date2], 'YYYY-MM-DD', (SELECT DISTINCT OFC_CD FROM (SELECT N3PTY_OFC_TP_CD, OFC_CD, N3PTY_CTRL_OFC_CD, RHQ_CD FROM TPB_HNDL_OFC WHERE OFC_CD = @[s_user_ofc_cd] AND DELT_FLG = 'N'))) + 1" ).append("\n"); 
		query.append("        #if (${s_vndr_cust_div_cd} != '')" ).append("\n"); 
		query.append("            AND C.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("                #if (${s_trd_party_val} != '' )" ).append("\n"); 
		query.append("                    #if (${s_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("                        AND C.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("                    #elseif (${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("                        AND C.CUST_CNT_CD = SUBSTRB(TRIM(@[s_trd_party_val]),1,2)" ).append("\n"); 
		query.append("                        #if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("                            AND C.CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[s_trd_party_val]),3))" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    #elseif (${s_vndr_cust_div_cd} == 'S')" ).append("\n"); 
		query.append("                        AND C.N3PTY_OFC_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        AND C.OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                           FROM ( SELECT DISTINCT T.RHQ_CD, T.N3PTY_CTRL_OFC_CD, T.OFC_CD" ).append("\n"); 
		query.append("                                    FROM TPB_HNDL_OFC T, " ).append("\n"); 
		query.append("                                         (SELECT N3PTY_OFC_TP_CD, OFC_CD, N3PTY_CTRL_OFC_CD, RHQ_CD FROM TPB_HNDL_OFC WHERE OFC_CD = @[s_user_ofc_cd] AND DELT_FLG = 'N') L" ).append("\n"); 
		query.append("                                   WHERE 1=1" ).append("\n"); 
		query.append("                                     AND T.OFC_CD = L.OFC_CD" ).append("\n"); 
		query.append("                                      OR T.N3PTY_CTRL_OFC_CD = L.N3PTY_CTRL_OFC_CD" ).append("\n"); 
		query.append("                                      OR T.RHQ_CD = L.OFC_CD" ).append("\n"); 
		query.append("                                     AND T.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                     AND L.N3PTY_OFC_TP_CD = 'R'" ).append("\n"); 
		query.append("                                 ) " ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                         #if(${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("                             AND N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         #if(${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("                             AND OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ORDER BY A.N3PTY_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#elseif (${s_date_flag_r} == 'OT')" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("    SELECT 'N' AS APPROVAL, " ).append("\n"); 
		query.append("           '0' AS CHK_REQ," ).append("\n"); 
		query.append("           '0' AS CHK_APP," ).append("\n"); 
		query.append("           '0' AS CHK_REJ," ).append("\n"); 
		query.append("           NULL AS STL_TO_CLT_CNG_OFC_CD," ).append("\n"); 
		query.append("           A.N3PTY_NO," ).append("\n"); 
		query.append("           ------------ request -------------" ).append("\n"); 
		query.append("           '' AS STL_RQST_DT," ).append("\n"); 
		query.append("           '' AS STL_RQST_OFC_CD," ).append("\n"); 
		query.append("           '' AS STL_RQST_USR_ID," ).append("\n"); 
		query.append("           ------------ approve -------------" ).append("\n"); 
		query.append("           '' AS STL_APRO_DT," ).append("\n"); 
		query.append("           '' AS STL_APRO_OFC_CD," ).append("\n"); 
		query.append("           '' AS STL_APRO_USR_ID," ).append("\n"); 
		query.append("           ------------ reject --------------" ).append("\n"); 
		query.append("           '' AS STL_RJCT_DT," ).append("\n"); 
		query.append("           '' AS STL_RJCT_OFC_CD," ).append("\n"); 
		query.append("           '' AS STL_RJCT_USR_ID," ).append("\n"); 
		query.append("           ---------------------------------" ).append("\n"); 
		query.append("           A.N3PTY_SRC_SUB_SYS_CD," ).append("\n"); 
		query.append("           C.N3PTY_INV_NO," ).append("\n"); 
		query.append("           B.OTS_STS_CD," ).append("\n"); 
		query.append("           COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588',B.OTS_STS_CD) AS OTS_STS_CD_VAL," ).append("\n"); 
		query.append("           A.BKG_NO, -- || A.BKG_NO_SPLIT AS BKG_NO," ).append("\n"); 
		query.append("           A.BL_NO, -- || A.BL_NO_TP || A.BL_NO_CHK AS BL_NO," ).append("\n"); 
		query.append("           A.EQ_NO," ).append("\n"); 
		query.append("           --TPB_GET_RHQ_CD_FNC(C.OFC_CD) AS IF_RHQ_CD," ).append("\n"); 
		query.append("           TPB_GET_HNDL_OFC_FNC('R',NVL(A.N3PTY_OFC_CD,A.OFC_CD)) AS IF_RHQ_CD," ).append("\n"); 
		query.append("           C.OFC_CD AS IF_OFC_CD," ).append("\n"); 
		query.append("           DECODE(A.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("                'V',LPAD(TO_CHAR(A.VNDR_SEQ),6,'0')," ).append("\n"); 
		query.append("                'C',A.CUST_CNT_CD || LPAD(TO_CHAR(A.CUST_SEQ),6,'0')," ).append("\n"); 
		query.append("                'S',A.N3PTY_OFC_CD, NULL) AS N3PTY," ).append("\n"); 
		query.append("    #if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("           'USD' AS CURR_CD, " ).append("\n"); 
		query.append("           TPB_GET_USD_AMT_FNC(C.OTS_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD)) AS OTS_AMT," ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("           A.CFM_CURR_CD AS CURR_CD, " ).append("\n"); 
		query.append("           C.OTS_AMT," ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("           TO_CHAR(TPB_GET_LCL_DATE_FNC(A.CFM_DT,@[s_user_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS CFM_DT," ).append("\n"); 
		query.append("    #if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("           TPB_GET_USD_AMT_FNC(C.INV_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD)) AS INV_AMT," ).append("\n"); 
		query.append("           TPB_GET_USD_AMT_FNC(C.CLT_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD)) AS CLT_AMT," ).append("\n"); 
		query.append("           TPB_GET_USD_AMT_FNC(C.ADJ_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD)) AS ADJ_AMT," ).append("\n"); 
		query.append("           TPB_GET_USD_AMT_FNC(C.BAL_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD)) AS BAL_AMT," ).append("\n"); 
		query.append("           NULL AS STL_CLT_OFC_CNG_AMT," ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("           C.INV_AMT, " ).append("\n"); 
		query.append("           C.CLT_AMT, " ).append("\n"); 
		query.append("           C.ADJ_AMT, " ).append("\n"); 
		query.append("           C.BAL_AMT, " ).append("\n"); 
		query.append("           NULL AS STL_CLT_OFC_CNG_AMT," ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("           --TPB_GET_CLT_ACT_YN_FNC(A.N3PTY_NO, C.N3PTY_INV_NO) AS CLT_ACT_YN," ).append("\n"); 
		query.append("           (SELECT COUNT(1) FROM TPB_OTS_GRP_RCVR_ACT WHERE N3PTY_NO = C.N3PTY_NO AND N3PTY_CLT_RMK_TP_CD = 'M' AND ROWNUM = 1 ) AS CLT_ACT_YN," ).append("\n"); 
		query.append("           TO_CHAR(TPB_GET_LCL_DATE_FNC((SELECT MAX(UPD_DT) FROM TPB_ADJ_STS WHERE N3PTY_NO = A.N3PTY_NO AND N3PTY_STL_TP_CD = 'W'),@[s_user_ofc_cd]),'YYYY-MM-DD HH24:MI') AS LAST_WO_DT," ).append("\n"); 
		query.append("           NULL AS STL_FWRD_OFC_CD" ).append("\n"); 
		query.append("      FROM TPB_OTS_GRP_STS B," ).append("\n"); 
		query.append("           TPB_OTS_DTL A," ).append("\n"); 
		query.append("           TPB_OTS_GRP C" ).append("\n"); 
		query.append("     WHERE A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("       AND A.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("       AND A.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("       AND C.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("       AND B.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("       AND B.OTS_STS_CD IN ('O','J','M')" ).append("\n"); 
		query.append("       AND A.N3PTY_BIL_TP_CD != 'JO'" ).append("\n"); 
		query.append("       AND A.N3PTY_NO_DP_SEQ = 1" ).append("\n"); 
		query.append("	#if (${s_n3pty_no_strs_link} != '' && $s_n3pty_no_strs_link.size() > 0)" ).append("\n"); 
		query.append("	   AND C.N3PTY_NO IN ( NULL" ).append("\n"); 
		query.append("	   #foreach($s_n3pty_no_strs_link IN ${s_n3pty_no_strs_link})" ).append("\n"); 
		query.append("	   		#if($velocityCount < $s_n3pty_no_strs_link.size())" ).append("\n"); 
		query.append("	 		,'$s_n3pty_no_strs_link'," ).append("\n"); 
		query.append("	 		#else" ).append("\n"); 
		query.append("	 		,'$s_n3pty_no_strs_link'" ).append("\n"); 
		query.append("	 		#end" ).append("\n"); 
		query.append("	   #end" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("       #if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("            AND C.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            AND A.CFM_DT >= TPB_GET_SRCH_DATE_FNC(@[s_calendar_date1], 'YYYY-MM-DD', @[s_user_ofc_cd])" ).append("\n"); 
		query.append("            AND A.CFM_DT <  TPB_GET_SRCH_DATE_FNC(@[s_calendar_date2], 'YYYY-MM-DD', @[s_user_ofc_cd]) + 1" ).append("\n"); 
		query.append("            #if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("                AND A.OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                AND A.OFC_CD = @[s_user_ofc_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${s_vndr_cust_div_cd} != '')" ).append("\n"); 
		query.append("                AND C.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("                    #if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("                        #if (${s_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("                            AND C.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("                        #elseif (${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("                            AND C.CUST_CNT_CD = SUBSTRB(TRIM(@[s_trd_party_val]),1,2)" ).append("\n"); 
		query.append("                            #if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("                                AND C.CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[s_trd_party_val]),3))" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        #elseif (${s_vndr_cust_div_cd} == 'S')" ).append("\n"); 
		query.append("                            AND C.N3PTY_OFC_CD = @[s_trd_party_val]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     ORDER BY A.N3PTY_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}