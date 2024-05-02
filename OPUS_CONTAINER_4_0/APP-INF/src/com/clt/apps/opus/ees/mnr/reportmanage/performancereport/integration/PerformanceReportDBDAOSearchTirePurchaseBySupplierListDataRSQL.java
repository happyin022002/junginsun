/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchTirePurchaseBySupplierListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.01 
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

public class PerformanceReportDBDAOSearchTirePurchaseBySupplierListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchTirePurchaseBySupplierListDataRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchTirePurchaseBySupplierListDataRSQL(){
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
		params.put("sup_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchTirePurchaseBySupplierListDataRSQL").append("\n"); 
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
		query.append("WITH PARAM " ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("    SELECT P_CD," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 1, CD)) CD01," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 2, CD)) CD02," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 3, CD)) CD03," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 4, CD)) CD04," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 5, CD)) CD05," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 6, CD)) CD06," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 7, CD)) CD07," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 8, CD)) CD08," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 9, CD)) CD09," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 10, CD)) CD10," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 11, CD)) CD11," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 12, CD)) CD12," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 13, CD)) CD13," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 14, CD)) CD14," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 15, CD)) CD15," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 16, CD)) CD16," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 17, CD)) CD17," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 18, CD)) CD18," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 19, CD)) CD19," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 20, CD)) CD20," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 1, CD_DESC)) CD_DESC01," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 2, CD_DESC)) CD_DESC02," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 3, CD_DESC)) CD_DESC03," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 4, CD_DESC)) CD_DESC04," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 5, CD_DESC)) CD_DESC05," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 6, CD_DESC)) CD_DESC06," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 7, CD_DESC)) CD_DESC07," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 8, CD_DESC)) CD_DESC08," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 9, CD_DESC)) CD_DESC09," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 10, CD_DESC)) CD_DESC10," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 11, CD_DESC)) CD_DESC11," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 12, CD_DESC)) CD_DESC12," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 13, CD_DESC)) CD_DESC13," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 14, CD_DESC)) CD_DESC14," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 15, CD_DESC)) CD_DESC15," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 16, CD_DESC)) CD_DESC16," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 17, CD_DESC)) CD_DESC17," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 18, CD_DESC)) CD_DESC18," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 19, CD_DESC)) CD_DESC19," ).append("\n"); 
		query.append("           MAX(DECODE(RNK, 20, CD_DESC)) CD_DESC20" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("             SELECT  P_CD, CD, CD_DESC,  ROW_NUMBER() OVER(ORDER BY DP_SEQ) RNK" ).append("\n"); 
		query.append("             FROM" ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                    SELECT MR.PRNT_CD_ID P_CD, MR.MNR_CD_ID CD, MR.MNR_CD_DP_DESC CD_DESC, MNR_CD_DP_SEQ DP_SEQ" ).append("\n"); 
		query.append("                    FROM MNR_GEN_CD MR" ).append("\n"); 
		query.append("                    WHERE PRNT_CD_ID = 'MRZSTP'                    " ).append("\n"); 
		query.append("                    )                                           " ).append("\n"); 
		query.append("         )       " ).append("\n"); 
		query.append("    GROUP BY P_CD     " ).append("\n"); 
		query.append("    ), DUMMY_COL AS (" ).append("\n"); 
		query.append("       SELECT 'Q' DCOL FROM DUAL  --QTY" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT 'S' DCOL FROM DUAL  --AMOUNT" ).append("\n"); 
		query.append("       UNION ALL " ).append("\n"); 
		query.append("       SELECT 'Z' DCOL FROM DUAL  --AVG" ).append("\n"); 
		query.append("    ), RPC_DATA AS (" ).append("\n"); 
		query.append("        SELECT OH.COST_OFC_CD OFC_CD, " ).append("\n"); 
		query.append("               OH.VNDR_SEQ V_SEQ, " ).append("\n"); 
		query.append("               MAX(MV.VNDR_LGL_ENG_NM) VNDR_NM," ).append("\n"); 
		query.append("               MAX(OD.MNR_EXPN_DTL_NM)  BRAND_NM," ).append("\n"); 
		query.append("               MAX(OH.CURR_CD) CURR," ).append("\n"); 
		query.append("               C.DCOL TYPE," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD01, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD01, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD01, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD01, OD.RPR_QTY)), 2) END CD01," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD02, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD02, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD02, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD02, OD.RPR_QTY)), 2) END CD02," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD03, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD03, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD03, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD03, OD.RPR_QTY)), 2) END CD03," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD04, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD04, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD04, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD04, OD.RPR_QTY)), 2) END CD04," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD05, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD05, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD05, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD05, OD.RPR_QTY)), 2) END CD05," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD06, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD06, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD06, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD06, OD.RPR_QTY)), 2) END CD06," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD07, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD07, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD07, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD07, OD.RPR_QTY)), 2) END CD07," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD08, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD08, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD08, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD08, OD.RPR_QTY)), 2) END CD08," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD09, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD09, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD09, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD09, OD.RPR_QTY)), 2) END CD09," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD10, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD10, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD10, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD10, OD.RPR_QTY)), 2) END CD10," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD01, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD11, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD11, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD11, OD.RPR_QTY)), 2) END CD11," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD02, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD12, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD12, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD12, OD.RPR_QTY)), 2) END CD12," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD03, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD13, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD13, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD13, OD.RPR_QTY)), 2) END CD13," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD04, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD14, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD14, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD14, OD.RPR_QTY)), 2) END CD14," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD05, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD15, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD15, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD15, OD.RPR_QTY)), 2) END CD15," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD06, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD16, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD16, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD16, OD.RPR_QTY)), 2) END CD16," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD07, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD17, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD17, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD17, OD.RPR_QTY)), 2) END CD17," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD08, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD18, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD18, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD18, OD.RPR_QTY)), 2) END CD18," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD09, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD19, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD19, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD19, OD.RPR_QTY)), 2) END CD19," ).append("\n"); 
		query.append("               CASE WHEN C.DCOL = 'Q' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD10, OD.RPR_QTY)) WHEN C.DCOL = 'S' THEN SUM(DECODE(OD.COST_DTL_CD, P.CD20, OD.COST_AMT)) WHEN C.DCOL = 'Z' THEN ROUND(SUM(DECODE(OD.COST_DTL_CD, P.CD20, OD.COST_AMT))/ SUM(DECODE(OD.COST_DTL_CD, P.CD20, OD.RPR_QTY)), 2) END CD20                    " ).append("\n"); 
		query.append("        FROM  PARAM P, DUMMY_COL C, MNR_ORD_HDR OH, MNR_ORD_DTL OD, MDM_VENDOR MV" ).append("\n"); 
		query.append("        WHERE OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND   OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("        AND   OH.VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("		#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("        AND   RTRIM(OH.COST_OFC_CD) = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${sup_cd} != '')" ).append("\n"); 
		query.append("		AND   OH.VNDR_SEQ = @[sup_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND   OH.CRE_DT BETWEEN  GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[from_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())  " ).append("\n"); 
		query.append("		AND   RTRIM(OH.EQ_KND_CD) = 'Z'" ).append("\n"); 
		query.append("		AND   RTRIM(OH.MNR_WO_TP_CD) = 'EXT'" ).append("\n"); 
		query.append("		AND   RTRIM(OD.COST_CD) = 'MRZSTP'" ).append("\n"); 
		query.append("        GROUP BY OH.COST_OFC_CD, OH.VNDR_SEQ, C.DCOL" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT  RHQ, OFC, SUP_CD, SUP_NM, BRAND_NM, CUR, DECODE(TYPE, 'Q', 'QTY', 'S', 'AMT', 'Z', 'AVG') TYPE," ).append("\n"); 
		query.append("                                       DECODE(TYPE, 'Q', '1', 'S', '2', 'Z', '3') TYPE2," ).append("\n"); 
		query.append("        DECODE(RHQ, 'RHQ', CD01||'|'||CD02||'|'||CD03||'|'||CD04||'|'||CD05||'|'||CD06||'|'||CD07||'|'||CD08||'|'||CD09||'|'||CD10||'|'||CD11||'|'||CD12||'|'||CD13||'|'||CD14||'|'||CD15||'|'||CD16||'|'||CD17||'|'||CD18||'|'||CD19||'|'||CD20, '') AS TITLE," ).append("\n"); 
		query.append("        CD01, CD02, CD03, CD04, CD05, CD06, CD07, CD08, CD09, CD10, CD11, CD12, CD13, CD14, CD15, CD16, CD17, CD18, CD19, CD20" ).append("\n"); 
		query.append("FROM        " ).append("\n"); 
		query.append("    (    " ).append("\n"); 
		query.append("        SELECT 'A' PRI, 'RHQ' RHQ,  'Office' OFC, 'Supplier Code' SUP_CD, 'Supplier' SUP_NM, 'Brand Name' BRAND_NM, 'Curr' CUR, 'Type' TYPE," ).append("\n"); 
		query.append("                NVL(CD_DESC01, 'N') CD01," ).append("\n"); 
		query.append("                NVL(CD_DESC02, 'N') CD02," ).append("\n"); 
		query.append("                NVL(CD_DESC03, 'N') CD03," ).append("\n"); 
		query.append("                NVL(CD_DESC04, 'N') CD04," ).append("\n"); 
		query.append("                NVL(CD_DESC05, 'N') CD05," ).append("\n"); 
		query.append("                NVL(CD_DESC06, 'N') CD06," ).append("\n"); 
		query.append("                NVL(CD_DESC07, 'N') CD07," ).append("\n"); 
		query.append("                NVL(CD_DESC08, 'N') CD08," ).append("\n"); 
		query.append("                NVL(CD_DESC09, 'N') CD09," ).append("\n"); 
		query.append("                NVL(CD_DESC10, 'N') CD10," ).append("\n"); 
		query.append("                NVL(CD_DESC11, 'N') CD11," ).append("\n"); 
		query.append("                NVL(CD_DESC12, 'N') CD12," ).append("\n"); 
		query.append("                NVL(CD_DESC13, 'N') CD13," ).append("\n"); 
		query.append("                NVL(CD_DESC14, 'N') CD14," ).append("\n"); 
		query.append("                NVL(CD_DESC15, 'N') CD15," ).append("\n"); 
		query.append("                NVL(CD_DESC16, 'N') CD16," ).append("\n"); 
		query.append("                NVL(CD_DESC17, 'N') CD17," ).append("\n"); 
		query.append("                NVL(CD_DESC18, 'N') CD18," ).append("\n"); 
		query.append("                NVL(CD_DESC19, 'N') CD19," ).append("\n"); 
		query.append("                NVL(CD_DESC20, 'N') CD20                   " ).append("\n"); 
		query.append("        FROM PARAM P" ).append("\n"); 
		query.append("        UNION ALL        " ).append("\n"); 
		query.append("        SELECT 'B' PRI, MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RD.OFC_CD) RHQ, OFC_CD OFC, TO_CHAR(V_SEQ) SUP_SEQ, VNDR_NM SUP_NM, " ).append("\n"); 
		query.append("               BRAND_NM, CURR CUR, TYPE TYPE," ).append("\n"); 
		query.append("               TO_CHAR(CD01) CD01," ).append("\n"); 
		query.append("               TO_CHAR(CD02) CD02," ).append("\n"); 
		query.append("               TO_CHAR(CD03) CD03," ).append("\n"); 
		query.append("               TO_CHAR(CD04) CD04," ).append("\n"); 
		query.append("               TO_CHAR(CD05) CD05," ).append("\n"); 
		query.append("               TO_CHAR(CD06) CD06," ).append("\n"); 
		query.append("               TO_CHAR(CD07) CD07," ).append("\n"); 
		query.append("               TO_CHAR(CD08) CD08," ).append("\n"); 
		query.append("               TO_CHAR(CD09) CD09," ).append("\n"); 
		query.append("               TO_CHAR(CD10) CD10," ).append("\n"); 
		query.append("               TO_CHAR(CD11) CD11," ).append("\n"); 
		query.append("               TO_CHAR(CD12) CD12," ).append("\n"); 
		query.append("               TO_CHAR(CD13) CD13," ).append("\n"); 
		query.append("               TO_CHAR(CD14) CD14," ).append("\n"); 
		query.append("               TO_CHAR(CD15) CD15," ).append("\n"); 
		query.append("               TO_CHAR(CD16) CD16," ).append("\n"); 
		query.append("               TO_CHAR(CD17) CD17," ).append("\n"); 
		query.append("               TO_CHAR(CD18) CD18," ).append("\n"); 
		query.append("               TO_CHAR(CD19) CD19," ).append("\n"); 
		query.append("               TO_CHAR(CD20) CD20" ).append("\n"); 
		query.append("        FROM  RPC_DATA RD" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("ORDER BY PRI, RHQ, OFC, SUP_CD, SUP_NM, CUR, TYPE2" ).append("\n"); 

	}
}