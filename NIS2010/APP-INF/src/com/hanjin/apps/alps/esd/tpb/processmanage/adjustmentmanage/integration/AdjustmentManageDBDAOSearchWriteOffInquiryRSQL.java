/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AdjustmentManageDBDAOSearchWriteOffInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentManageDBDAOSearchWriteOffInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchWriteOffInquiry
	  * 
	  * s_date_flag_i
	  * 'OL': W/O All
	  * 'OA': W/O Approved
	  * 'OR' :W/O Rejected
	  * 'OREQ' :W/O Requested
	  * 'IN' :W/O-In
	  * 'IA' :W/O-in Accepted
	  * 'IR' :W/O-in Rejected
	  * 'IL': W/O-in All
	  * </pre>
	  */
	public AdjustmentManageDBDAOSearchWriteOffInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_calendar_date1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_stl_to_clt_cng_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOSearchWriteOffInquiryRSQL").append("\n"); 
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
		query.append("SELECT   'N' AS APPROVAL" ).append("\n"); 
		query.append("       , 0 AS CHK_REQ" ).append("\n"); 
		query.append("       , 0 AS CHK_APP" ).append("\n"); 
		query.append("       , 0 AS CHK_REJ" ).append("\n"); 
		query.append("       , A.STL_TO_CLT_CNG_OFC_CD" ).append("\n"); 
		query.append("       , A.N3PTY_NO" ).append("\n"); 
		query.append("       , TO_CHAR(TPB_GET_LCL_DATE_FNC(A.STL_RQST_DT,@[s_user_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS STL_RQST_DT" ).append("\n"); 
		query.append("       , A.STL_RQST_OFC_CD" ).append("\n"); 
		query.append("       , A.STL_RQST_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(TPB_GET_LCL_DATE_FNC(A.STL_APRO_DT,@[s_user_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS STL_APRO_DT" ).append("\n"); 
		query.append("       , A.STL_APRO_OFC_CD" ).append("\n"); 
		query.append("       , A.STL_APRO_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(TPB_GET_LCL_DATE_FNC(A.STL_RJCT_DT,@[s_user_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS STL_RJCT_DT" ).append("\n"); 
		query.append("       , A.STL_RJCT_OFC_CD" ).append("\n"); 
		query.append("       , A.STL_RJCT_USR_ID" ).append("\n"); 
		query.append("       , D.N3PTY_SRC_SUB_SYS_CD" ).append("\n"); 
		query.append("       , G.N3PTY_INV_NO" ).append("\n"); 
		query.append("       , S.OTS_STS_CD" ).append("\n"); 
		query.append("       , DECODE(A.STL_APRO_OFC_CD,NULL,DECODE(A.STL_RJCT_OFC_CD,NULL,'Requested','Rejected'),'Approved') AS OTS_STS_CD_VAL" ).append("\n"); 
		query.append("       , D.BKG_NO" ).append("\n"); 
		query.append("       , D.BL_NO" ).append("\n"); 
		query.append("       , D.EQ_NO" ).append("\n"); 
		query.append("       , TPB_GET_HNDL_OFC_FNC('R',NVL(D.N3PTY_OFC_CD,D.OFC_CD)) AS IF_RHQ_CD" ).append("\n"); 
		query.append("       , G.OFC_CD AS IF_OFC_CD" ).append("\n"); 
		query.append("       , CASE WHEN D.VNDR_CUST_DIV_CD = 'V' THEN LPAD(TO_CHAR(D.VNDR_SEQ),6,'0')" ).append("\n"); 
		query.append("              WHEN D.VNDR_CUST_DIV_CD = 'C' THEN D.CUST_CNT_CD || LPAD(TO_CHAR(D.CUST_SEQ),6,'0')" ).append("\n"); 
		query.append("              WHEN D.VNDR_CUST_DIV_CD = 'S' THEN D.N3PTY_OFC_CD" ).append("\n"); 
		query.append("              ELSE NULL" ).append("\n"); 
		query.append("         END AS N3PTY" ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("       , 'USD' AS CURR_CD" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(G.OTS_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS OTS_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       , D.CFM_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("       , G.OTS_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       , TO_CHAR(TPB_GET_LCL_DATE_FNC(G.CFM_DT, @[s_user_ofc_cd]), 'YYYY-MM-DD HH24:MI') AS CFM_DT" ).append("\n"); 
		query.append("#if (${s_curr_cd_tp} == 'U')" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(G.INV_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS INV_AMT" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(G.CLT_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS CLT_AMT" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(G.ADJ_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS ADJ_AMT" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(G.BAL_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS BAL_AMT" ).append("\n"); 
		query.append("       , TPB_GET_USD_AMT_FNC(A.STL_CLT_OFC_CNG_AMT,G.CURR_CD,TPB_GET_LCL_DATE_FNC(G.CFM_DT,G.OFC_CD)) AS STL_CLT_OFC_CNG_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       , G.INV_AMT" ).append("\n"); 
		query.append("       , G.CLT_AMT" ).append("\n"); 
		query.append("       , G.ADJ_AMT" ).append("\n"); 
		query.append("       , G.BAL_AMT" ).append("\n"); 
		query.append("       , A.STL_CLT_OFC_CNG_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       , ( SELECT COUNT(1) FROM TPB_OTS_GRP_RCVR_ACT WHERE N3PTY_NO = G.N3PTY_NO AND N3PTY_CLT_RMK_TP_CD = 'M' AND ROWNUM = 1 ) AS CLT_ACT_YN" ).append("\n"); 
		query.append("       , TO_CHAR(TPB_GET_LCL_DATE_FNC(A.UPD_DT,@[s_user_ofc_cd]),'YYYY-MM-DD HH24:MI') AS LAST_WO_DT" ).append("\n"); 
		query.append("       , DECODE(A.STL_FWRD_OFC_CD, NULL, A.STL_TO_CLT_CNG_OFC_CD, A.STL_FWRD_OFC_CD) AS STL_FWRD_OFC_CD" ).append("\n"); 
		query.append("       , A.WRTF_RSN_CD" ).append("\n"); 
		query.append("FROM     TPB_ADJ_STS A" ).append("\n"); 
		query.append("       , TPB_OTS_DTL D" ).append("\n"); 
		query.append("       , TPB_OTS_GRP G" ).append("\n"); 
		query.append("       , TPB_OTS_GRP_STS S" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND      A.N3PTY_NO = D.N3PTY_NO" ).append("\n"); 
		query.append("AND      A.N3PTY_NO = G.N3PTY_NO" ).append("\n"); 
		query.append("AND      D.N3PTY_NO_DP_SEQ = 1" ).append("\n"); 
		query.append("AND      G.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("AND      A.N3PTY_NO = S.N3PTY_NO" ).append("\n"); 
		query.append("AND      S.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND      S.OTS_STS_CD != 'D'" ).append("\n"); 
		query.append("AND      A.N3PTY_STL_TP_CD = 'W'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_date_flag_i} == 'OA' || ${s_date_flag_i} == 'IA')" ).append("\n"); 
		query.append("AND      A.STL_APRO_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${s_date_flag_i} == 'OR' || ${s_date_flag_i} == 'IR')" ).append("\n"); 
		query.append("AND      A.STL_RJCT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_date_flag_i} == 'OL' || ${s_date_flag_i} == 'OA' || ${s_date_flag_i} == 'OR' || ${s_date_flag_i} == 'OREQ')" ).append("\n"); 
		query.append("AND      (    A.STL_RQST_OFC_CD IN" ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                SELECT   OFC_CD" ).append("\n"); 
		query.append("                FROM     TPB_HNDL_OFC" ).append("\n"); 
		query.append("                WHERE    1 = 1" ).append("\n"); 
		query.append("    #if(${s_user_ofc_cd} == 'SELCON'  || ${s_user_ofc_cd} == 'SELOPA')" ).append("\n"); 
		query.append("                AND      ( RHQ_CD = @[s_if_rhq_cd] OR OFC_CD = @[s_if_ofc_cd] OR N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd] )" ).append("\n"); 
		query.append("                OR       RHQ_CD = ( SELECT RHQ_CD FROM TPB_HNDL_OFC WHERE N3PTY_OFC_TP_CD = 'S' AND OFC_CD = @[s_user_ofc_cd] )" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("           OR A.STL_RQST_OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("         ) -- ROC Out All" ).append("\n"); 
		query.append("#elseif (${s_date_flag_i} == 'IL' || ${s_date_flag_i} == 'IA' || ${s_date_flag_i} == 'IR'))" ).append("\n"); 
		query.append("AND      G.OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("                       FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("                      WHERE 1=1" ).append("\n"); 
		query.append("                     #if(${s_user_ofc_cd} == 'SELCON' || ${s_user_ofc_cd} == 'SELOPA')" ).append("\n"); 
		query.append("                        AND (RHQ_CD = @[s_if_rhq_cd] OR OFC_CD = @[s_if_ofc_cd] OR N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd])" ).append("\n"); 
		query.append("                         OR RHQ_CD = (SELECT RHQ_CD FROM TPB_HNDL_OFC WHERE N3PTY_OFC_TP_CD = 'S' AND OFC_CD = @[s_user_ofc_cd])" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("AND      A.STL_TO_CLT_CNG_OFC_CD IS NULL" ).append("\n"); 
		query.append("AND      A.STL_CLT_OFC_CNG_AMT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("AND      A.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND      A.STL_RQST_DT >= TPB_GET_SRCH_DATE_FNC(@[s_calendar_date1],'YYYY-MM-DD',@[s_user_ofc_cd])" ).append("\n"); 
		query.append("AND      A.STL_RQST_DT <  TPB_GET_SRCH_DATE_FNC(@[s_calendar_date2],'YYYY-MM-DD',@[s_user_ofc_cd]) + 1" ).append("\n"); 
		query.append("	#if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("		#if (${s_date_flag_i} == 'OL' || ${s_date_flag_i} == 'OA' || ${s_date_flag_i} == 'OR'|| ${s_date_flag_i} == 'OREQ')" ).append("\n"); 
		query.append("AND      A.STL_RQST_OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("			#if (${s_date_flag_i} == 'OA')" ).append("\n"); 
		query.append("AND      A.STL_APRO_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("			#elseif (${s_date_flag_i} == 'OR')" ).append("\n"); 
		query.append("AND      A.STL_RJCT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("    	#elseif (${s_date_flag_i} == 'IL' || ${s_date_flag_i} == 'IA' || ${s_date_flag_i} == 'IR')" ).append("\n"); 
		query.append("AND      A.STL_TO_CLT_CNG_OFC_CD = @[s_stl_to_clt_cng_ofc_cd]" ).append("\n"); 
		query.append("			#if (${s_date_flag_i} == 'IA')" ).append("\n"); 
		query.append("AND      A.STL_APRO_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("			#elseif (${s_date_flag_i} == 'IR')" ).append("\n"); 
		query.append("AND      A.STL_RJCT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("		#if (${s_date_flag_i} == 'OL' || ${s_date_flag_i} == 'OA' || ${s_date_flag_i} == 'OR' || ${s_date_flag_i} == 'OREQ')" ).append("\n"); 
		query.append("AND      A.STL_RQST_OFC_CD IN (SELECT OFC_CD FROM TPB_HNDL_OFC WHERE N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd])" ).append("\n"); 
		query.append("		#elseif (${s_date_flag_i} == 'IL' || ${s_date_flag_i} == 'IA' || ${s_date_flag_i} == 'IR')" ).append("\n"); 
		query.append("AND      A.STL_TO_CLT_CNG_OFC_CD IN (SELECT OFC_CD FROM TPB_HNDL_OFC WHERE N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd])" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("		#if (${s_date_flag_i} == 'OL' || ${s_date_flag_i} == 'OA' || ${s_date_flag_i} == 'OR'|| ${s_date_flag_i} == 'OREQ')" ).append("\n"); 
		query.append("AND      A.STL_RQST_OFC_CD IN (SELECT OFC_CD FROM TPB_HNDL_OFC WHERE RHQ_CD = @[s_if_rhq_cd])" ).append("\n"); 
		query.append("		#elseif (${s_date_flag_i} == 'IL' || ${s_date_flag_i} == 'IA' || ${s_date_flag_i} == 'IR')" ).append("\n"); 
		query.append("AND      A.STL_TO_CLT_CNG_OFC_CD IN (SELECT OFC_CD FROM TPB_HNDL_OFC WHERE RHQ_CD = @[s_if_rhq_cd])" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${s_date_flag_i} == 'OREQ')" ).append("\n"); 
		query.append("AND      A.STL_APRO_OFC_CD IS NULL" ).append("\n"); 
		query.append("AND	     A.STL_RJCT_OFC_CD IS NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    	#if (${s_vndr_cust_div_cd} != '')" ).append("\n"); 
		query.append("AND      G.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append("			#if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("          	    #if (${s_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("AND      G.VNDR_SEQ = TO_NUMBER(@[s_trd_party_val])" ).append("\n"); 
		query.append("                #elseif (${s_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("AND      G.CUST_CNT_CD = SUBSTRB(TRIM(@[s_trd_party_val]),1,2)" ).append("\n"); 
		query.append("                    #if (${s_trd_party_val} != '')" ).append("\n"); 
		query.append("AND      G.CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[s_trd_party_val]),3))" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #elseif (${s_vndr_cust_div_cd} == 'S')" ).append("\n"); 
		query.append("AND      G.N3PTY_OFC_CD = @[s_trd_party_val]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.N3PTY_NO" ).append("\n"); 

	}
}