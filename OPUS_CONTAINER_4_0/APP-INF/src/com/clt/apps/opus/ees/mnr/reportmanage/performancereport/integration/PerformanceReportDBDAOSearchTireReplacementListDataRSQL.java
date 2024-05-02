/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchTireReplacementListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchTireReplacementListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTireReplacementListData
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchTireReplacementListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchTireReplacementListDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(OFC) RHQ,  " ).append("\n"); 
		query.append("       OFC OFC_CD, " ).append("\n"); 
		query.append("       MAX(MV.VNDR_LGL_ENG_NM) VNDR_NM," ).append("\n"); 
		query.append("       SUM(P_QTY) P_QTY," ).append("\n"); 
		query.append("       SUM(U_QTY) U_QTY," ).append("\n"); 
		query.append("       SUM(P_QTY - U_QTY) DF_QTY," ).append("\n"); 
		query.append("       SUM(P_AMT) P_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT OH.COST_OFC_CD OFC,  OH.VNDR_SEQ V_SEQ," ).append("\n"); 
		query.append("               DECODE(OD.COST_CD, 'MRZSTP', OD.RPR_QTY, 0) P_QTY," ).append("\n"); 
		query.append("               DECODE(OD.COST_CD, 'MRZSTR', OD.RPR_QTY, 0) U_QTY," ).append("\n"); 
		query.append("               DECODE(OD.COST_CD, 'MRZSTP'," ).append("\n"); 
		query.append("                         MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT), 0) P_AMT," ).append("\n"); 
		query.append("               DECODE(OD.COST_CD, 'MRZSTR'," ).append("\n"); 
		query.append("                         MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT), 0) U_AMT                  " ).append("\n"); 
		query.append("        FROM MNR_ORD_HDR OH, MNR_ORD_DTL OD" ).append("\n"); 
		query.append("        WHERE OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND   OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("		#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("        AND   OH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        AND   OH.CRE_DT BETWEEN  TO_DATE(@[from_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("        AND   OH.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("        AND   OH.MNR_WO_TP_CD = 'EXT'" ).append("\n"); 
		query.append("        AND   OD.COST_CD IN ( 'MRZSTP', 'MRZSTR')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT RH.COST_OFC_CD OFC, RH.VNDR_SEQ V_SEQ," ).append("\n"); 
		query.append("               0 P_QTY," ).append("\n"); 
		query.append("               RD.RPR_QTY U_QTY," ).append("\n"); 
		query.append("               0 P_AMT," ).append("\n"); 
		query.append("               MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), RH.CURR_CD, 'USD', RD.MNR_WRK_AMT) U_AMT                  " ).append("\n"); 
		query.append("        FROM MNR_RPR_RQST_HDR RH, MNR_RPR_RQST_DTL RD" ).append("\n"); 
		query.append("        WHERE RH.RQST_EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("        AND   RH.RPR_RQST_SEQ = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("        AND   RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("        AND   RH.RPR_RQST_LST_VER_FLG = RD.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("        AND   RH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("        AND   RH.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("        AND    RH.RPR_STS_CD = 'HA'" ).append("\n"); 
		query.append("        AND   RD.EQ_CMPO_CD = 'KTA'" ).append("\n"); 
		query.append("        AND   RD.EQ_RPR_CD = 'RP'       " ).append("\n"); 
		query.append("		#if (${ofc_cd} != '')  " ).append("\n"); 
		query.append("        AND   RH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        AND   RH.APRO_DT BETWEEN  GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[from_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) + 0.99999 " ).append("\n"); 
		query.append("       ), MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE V_SEQ = MV.VNDR_SEQ       " ).append("\n"); 
		query.append("GROUP BY OFC, V_SEQ" ).append("\n"); 

	}
}