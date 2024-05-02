/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpPerformanceComparisonDBDAOsearchComparisonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.17
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.06.17 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpPerformanceComparisonDBDAOsearchComparisonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/P Performace Comparison Report
	  * </pre>
	  */
	public SpPerformanceComparisonDBDAOsearchComparisonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_transmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_to_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_sotype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_via_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_door_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_costmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_from_node",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.integration").append("\n"); 
		query.append("FileName : SpPerformanceComparisonDBDAOsearchComparisonRSQL").append("\n"); 
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
		query.append("SELECT RHQ_CD" ).append("\n"); 
		query.append("      ,WO_OFC_CD" ).append("\n"); 
		query.append("      ,WO_NO" ).append("\n"); 
		query.append("      ,SO_NO" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,TRSP_SP_CNG_RSN_NM" ).append("\n"); 
		query.append("      ,TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("      ,TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      ,SC_NO" ).append("\n"); 
		query.append("      ,RFA_NO" ).append("\n"); 
		query.append("      ,(SELECT X.CUST_LGL_ENG_NM FROM MDM_CUSTOMER X WHERE X.CUST_CNT_CD = AA.CUST_CNT_CD AND X.CUST_SEQ = AA.CUST_SEQ) CUST_NM" ).append("\n"); 
		query.append("      ,FM_NOD_CD" ).append("\n"); 
		query.append("      ,VIA_NOD_CD" ).append("\n"); 
		query.append("      ,TO_NOD_CD" ).append("\n"); 
		query.append("      ,DOR_NOD_CD" ).append("\n"); 
		query.append("      ,DFLT_VNDR_SEQ" ).append("\n"); 
		query.append("      ,DFLT_VNDR_NM" ).append("\n"); 
		query.append("      ,DFLT_CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("      ,DFLT_AGMT_NO" ).append("\n"); 
		query.append("      ,DFLT_USD_VNDR_WO_QTY" ).append("\n"); 
		query.append("      ,DFLT_TRSP_AGMT_UPD_DT" ).append("\n"); 
		query.append("      ,DECODE(DFLT_TO_WGT, 999999.99, 'MAX', DFLT_WGT_MEAS_UT_CD || ' ' || DFLT_TO_WGT) DFLT_TO_WGT" ).append("\n"); 
		query.append("      ,DFLT_CMDT_GRP_CD" ).append("\n"); 
		query.append("      ,DFLT_CURR_CD" ).append("\n"); 
		query.append("      ,DFLT_BZC_AMT" ).append("\n"); 
		query.append("      ,DFLT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      ,DFLT_SCG_VAT_AMT" ).append("\n"); 
		query.append("      ,DFLT_TOLL_FEE_AMT" ).append("\n"); 
		query.append("      ,DFLT_TTL_AMT" ).append("\n"); 
		query.append("      ,DFLT_TTL_USD_AMT" ).append("\n"); 
		query.append("      ,LOW_VNDR_SEQ" ).append("\n"); 
		query.append("      ,LOW_VNDR_NM" ).append("\n"); 
		query.append("      ,LOW_CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("      ,LOW_AGMT_NO" ).append("\n"); 
		query.append("      ,LOW_USD_VNDR_WO_QTY" ).append("\n"); 
		query.append("      ,LOW_TRSP_AGMT_UPD_DT" ).append("\n"); 
		query.append("      ,DECODE(LOW_TO_WGT, 999999.99, 'MAX', LOW_WGT_MEAS_UT_CD || ' ' || LOW_TO_WGT) LOW_TO_WGT" ).append("\n"); 
		query.append("      ,LOW_CMDT_GRP_CD" ).append("\n"); 
		query.append("      ,LOW_CURR_CD" ).append("\n"); 
		query.append("      ,LOW_BZC_AMT" ).append("\n"); 
		query.append("      ,LOW_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      ,LOW_SCG_VAT_AMT" ).append("\n"); 
		query.append("      ,LOW_TOLL_FEE_AMT" ).append("\n"); 
		query.append("      ,LOW_TTL_AMT" ).append("\n"); 
		query.append("      ,LOW_TTL_USD_AMT" ).append("\n"); 
		query.append("      ,LOW_AGMT_MOR_CNDDT_QTY" ).append("\n"); 
		query.append("      ,USD_LOW_VNDR_SEQ" ).append("\n"); 
		query.append("      ,USD_LOW_VNDR_NM" ).append("\n"); 
		query.append("      ,USD_LOW_CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("      ,USD_LOW_AGMT_NO" ).append("\n"); 
		query.append("      ,USD_LOW_VNDR_WO_QTY" ).append("\n"); 
		query.append("      ,USD_LOW_TRSP_AGMT_UPD_DT" ).append("\n"); 
		query.append("      ,DECODE(USD_LOW_TO_WGT, 999999.99, 'MAX', USD_LOW_WGT_MEAS_UT_CD || ' ' || USD_LOW_TO_WGT) USD_LOW_TO_WGT" ).append("\n"); 
		query.append("      ,USD_LOW_CMDT_GRP_CD" ).append("\n"); 
		query.append("      ,USD_LOW_CURR_CD" ).append("\n"); 
		query.append("      ,USD_LOW_BZC_AMT" ).append("\n"); 
		query.append("      ,USD_LOW_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      ,USD_LOW_SCG_VAT_AMT" ).append("\n"); 
		query.append("      ,USD_LOW_TOLL_FEE_AMT" ).append("\n"); 
		query.append("      ,USD_LOW_TTL_AMT" ).append("\n"); 
		query.append("      ,USD_LOW_TTL_USD_AMT" ).append("\n"); 
		query.append("      ,WO_VNDR_SEQ" ).append("\n"); 
		query.append("      ,WO_VNDR_NM" ).append("\n"); 
		query.append("      ,WO_CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("      ,WO_AGMT_NO" ).append("\n"); 
		query.append("      ,WO_CURR_CD" ).append("\n"); 
		query.append("      ,WO_BZC_AMT" ).append("\n"); 
		query.append("      ,WO_NEGO_AMT" ).append("\n"); 
		query.append("      ,WO_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      ,WO_SCG_VAT_AMT" ).append("\n"); 
		query.append("      ,WO_TOLL_FEE_AMT" ).append("\n"); 
		query.append("      ,WO_ETC_ADD_AMT" ).append("\n"); 
		query.append("      ,WO_TTL_AMT" ).append("\n"); 
		query.append("      ,WO_TTL_USD_AMT" ).append("\n"); 
		query.append("      ,WO_BZC_AMT - DFLT_BZC_AMT              AS DFLT_BZC_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_NEGO_AMT                            AS DFLT_NEGO_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_FUEL_SCG_AMT - DFLT_FUEL_SCG_AMT    AS DFLT_FUEL_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_SCG_VAT_AMT - DFLT_SCG_VAT_AMT      AS DFLT_VAT_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_TOLL_FEE_AMT - DFLT_TOLL_FEE_AMT    AS DFLT_TOLL_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_ETC_ADD_AMT                         AS DFLT_ETC_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_TTL_AMT - DFLT_TTL_AMT              AS DFLT_TTL_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_TTL_USD_AMT - DFLT_TTL_USD_AMT      AS DFLT_TTL_USD_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_BZC_AMT - LOW_BZC_AMT               AS LOW_BZC_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_NEGO_AMT                            AS LOW_NEGO_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_FUEL_SCG_AMT - LOW_FUEL_SCG_AMT     AS LOW_FUEL_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_SCG_VAT_AMT - LOW_SCG_VAT_AMT       AS LOW_VAT_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_TOLL_FEE_AMT - LOW_TOLL_FEE_AMT     AS LOW_TOLL_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_ETC_ADD_AMT                         AS LOW_ETC_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_TTL_AMT - LOW_TTL_AMT               AS LOW_TTL_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_TTL_USD_AMT - LOW_TTL_USD_AMT       AS LOW_TTL_USD_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_BZC_AMT - USD_LOW_BZC_AMT           AS USD_LOW_BZC_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_NEGO_AMT                            AS USD_LOW_NEGO_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_FUEL_SCG_AMT - USD_LOW_FUEL_SCG_AMT AS USD_LOW_FUEL_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_SCG_VAT_AMT - USD_LOW_SCG_VAT_AMT   AS USD_LOW_VAT_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_TOLL_FEE_AMT - USD_LOW_TOLL_FEE_AMT AS USD_LOW_TOLL_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_ETC_ADD_AMT                         AS USD_LOW_ETC_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_TTL_AMT - USD_LOW_TTL_AMT           AS USD_LOW_TTL_COMP_AMT" ).append("\n"); 
		query.append("      ,WO_TTL_USD_AMT - USD_LOW_TTL_USD_AMT   AS USD_LOW_TTL_USD_COMP_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("     SELECT (SELECT TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(B.CRE_OFC_CD) FROM DUAL) AS RHQ_CD" ).append("\n"); 
		query.append("           ,B.CRE_OFC_CD AS WO_OFC_CD" ).append("\n"); 
		query.append("           ,B.TRSP_WO_OFC_CTY_CD||B.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("           ,A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("           ,A.EQ_NO" ).append("\n"); 
		query.append("           ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD03520' AND X.INTG_CD_VAL_CTNT = A.TRSP_SP_CNG_RSN_CD) || ' ' || TRSP_SP_CNG_RSN_RMK AS TRSP_SP_CNG_RSN_NM" ).append("\n"); 
		query.append("           ,A.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("           ,A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("           ,D.SC_NO" ).append("\n"); 
		query.append("           ,D.RFA_NO" ).append("\n"); 
		query.append("           ,C.CUST_CNT_CD" ).append("\n"); 
		query.append("           ,C.CUST_SEQ" ).append("\n"); 
		query.append("           ,A.FM_NOD_CD" ).append("\n"); 
		query.append("           ,A.VIA_NOD_CD" ).append("\n"); 
		query.append("           ,A.TO_NOD_CD" ).append("\n"); 
		query.append("           ,A.DOR_NOD_CD" ).append("\n"); 
		query.append("           ,DFLT_VNDR_SEQ" ).append("\n"); 
		query.append("           ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = C.DFLT_VNDR_SEQ) AS DFLT_VNDR_NM" ).append("\n"); 
		query.append("           ,C.DFLT_CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("           ,C.DFLT_TRSP_AGMT_OFC_CTY_CD||DFLT_TRSP_AGMT_SEQ AS DFLT_AGMT_NO" ).append("\n"); 
		query.append("           ,C.DFLT_VNDR_WO_QTY AS DFLT_USD_VNDR_WO_QTY" ).append("\n"); 
		query.append("           ,TO_CHAR(C.DFLT_TRSP_AGMT_UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS DFLT_TRSP_AGMT_UPD_DT" ).append("\n"); 
		query.append("           ,C.DFLT_WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("           ,C.DFLT_TO_WGT" ).append("\n"); 
		query.append("           ,C.DFLT_CMDT_GRP_CD" ).append("\n"); 
		query.append("           ,C.DFLT_CURR_CD" ).append("\n"); 
		query.append("           ,C.DFLT_BZC_AMT" ).append("\n"); 
		query.append("           ,C.DFLT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("           ,C.DFLT_SCG_VAT_AMT" ).append("\n"); 
		query.append("           ,C.DFLT_TOLL_FEE_AMT" ).append("\n"); 
		query.append("           ,C.DFLT_TTL_AMT" ).append("\n"); 
		query.append("           ,C.DFLT_TTL_USD_AMT" ).append("\n"); 
		query.append("           ,C.LOW_VNDR_SEQ" ).append("\n"); 
		query.append("           ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = C.LOW_VNDR_SEQ) AS LOW_VNDR_NM" ).append("\n"); 
		query.append("           ,C.LOW_CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("           ,C.LOW_TRSP_AGMT_OFC_CTY_CD||LOW_TRSP_AGMT_SEQ AS LOW_AGMT_NO" ).append("\n"); 
		query.append("           ,C.LOW_USD_VNDR_WO_QTY" ).append("\n"); 
		query.append("           ,TO_CHAR(C.LOW_TRSP_AGMT_UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS LOW_TRSP_AGMT_UPD_DT" ).append("\n"); 
		query.append("           ,C.LOW_WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("           ,C.LOW_TO_WGT" ).append("\n"); 
		query.append("           ,C.LOW_CMDT_GRP_CD" ).append("\n"); 
		query.append("           ,C.LOW_CURR_CD" ).append("\n"); 
		query.append("           ,C.LOW_BZC_AMT" ).append("\n"); 
		query.append("           ,C.LOW_FUEL_SCG_AMT" ).append("\n"); 
		query.append("           ,C.LOW_SCG_VAT_AMT" ).append("\n"); 
		query.append("           ,C.LOW_TOLL_FEE_AMT" ).append("\n"); 
		query.append("           ,C.LOW_TTL_AMT" ).append("\n"); 
		query.append("           ,C.LOW_TTL_USD_AMT" ).append("\n"); 
		query.append("           ,C.LOW_AGMT_MOR_CNDDT_QTY" ).append("\n"); 
		query.append("           ,C.USD_LOW_VNDR_SEQ" ).append("\n"); 
		query.append("           ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = C.USD_LOW_VNDR_SEQ) AS USD_LOW_VNDR_NM" ).append("\n"); 
		query.append("           ,C.USD_LOW_CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("           ,C.USD_LOW_TRSP_AGMT_OFC_CTY_CD||USD_LOW_TRSP_AGMT_SEQ AS USD_LOW_AGMT_NO" ).append("\n"); 
		query.append("           ,C.USD_LOW_VNDR_WO_QTY" ).append("\n"); 
		query.append("           ,TO_CHAR(C.USD_LOW_TRSP_AGMT_UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS USD_LOW_TRSP_AGMT_UPD_DT" ).append("\n"); 
		query.append("           ,C.USD_LOW_WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("           ,C.USD_LOW_TO_WGT" ).append("\n"); 
		query.append("           ,C.USD_LOW_CMDT_GRP_CD" ).append("\n"); 
		query.append("           ,C.USD_LOW_CURR_CD" ).append("\n"); 
		query.append("           ,C.USD_LOW_BZC_AMT" ).append("\n"); 
		query.append("           ,C.USD_LOW_FUEL_SCG_AMT" ).append("\n"); 
		query.append("           ,C.USD_LOW_SCG_VAT_AMT" ).append("\n"); 
		query.append("           ,C.USD_LOW_TOLL_FEE_AMT" ).append("\n"); 
		query.append("           ,C.USD_LOW_TTL_AMT" ).append("\n"); 
		query.append("           ,C.USD_LOW_TTL_USD_AMT" ).append("\n"); 
		query.append("           ,A.VNDR_SEQ AS WO_VNDR_SEQ" ).append("\n"); 
		query.append("           ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = A.VNDR_SEQ) AS WO_VNDR_NM" ).append("\n"); 
		query.append("           ,CASE WHEN A.CUST_NOMI_TRKR_IND_CD IS NOT NULL THEN CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("                 WHEN A.CUST_NOMI_TRKR_FLG = 'Y' THEN 'CNT'" ).append("\n"); 
		query.append("                 WHEN A.CUST_NOMI_TRKR_FLG = 'N' THEN 'HJS'" ).append("\n"); 
		query.append("            END WO_CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("           ,A.TRSP_AGMT_OFC_CTY_CD||A.TRSP_AGMT_SEQ AS WO_AGMT_NO" ).append("\n"); 
		query.append("           ,A.CURR_CD AS WO_CURR_CD" ).append("\n"); 
		query.append("           ,A.BZC_AMT AS WO_BZC_AMT" ).append("\n"); 
		query.append("           ,A.NEGO_AMT AS WO_NEGO_AMT" ).append("\n"); 
		query.append("           ,A.FUEL_SCG_AMT AS WO_FUEL_SCG_AMT" ).append("\n"); 
		query.append("           ,A.SCG_VAT_AMT AS WO_SCG_VAT_AMT" ).append("\n"); 
		query.append("           ,A.TOLL_FEE_AMT AS WO_TOLL_FEE_AMT" ).append("\n"); 
		query.append("           ,A.ETC_ADD_AMT AS WO_ETC_ADD_AMT" ).append("\n"); 
		query.append("           ,A.BZC_AMT + NVL(A.NEGO_AMT,0) + NVL(A.FUEL_SCG_AMT,0) + NVL(A.SCG_VAT_AMT,0) + NVL(A.TOLL_FEE_AMT,0) + NVL(A.ETC_ADD_AMT,0) AS WO_TTL_AMT" ).append("\n"); 
		query.append("           ,(SELECT TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD, BZC_AMT + NVL(NEGO_AMT,0) + NVL(FUEL_SCG_AMT,0) + NVL(SCG_VAT_AMT,0) + NVL(TOLL_FEE_AMT,0) + NVL(ETC_ADD_AMT,0), TO_CHAR(B.LOCL_CRE_DT, 'YYYYMMDD')) FROM DUAL) AS WO_TTL_USD_AMT" ).append("\n"); 
		query.append("      FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("          ,TRS_TRSP_WRK_ORD B" ).append("\n"); 
		query.append("          ,TRS_TRSP_WRK_ORD_RT_COMP C" ).append("\n"); 
		query.append("          ,BKG_BOOKING D" ).append("\n"); 
		query.append("     WHERE A.TRSP_WO_OFC_CTY_CD = B.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("       AND A.TRSP_WO_SEQ        = B.TRSP_WO_SEQ" ).append("\n"); 
		query.append("       AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("       AND A.TRSP_SO_SEQ        = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("       AND A.BKG_NO             = D.BKG_NO" ).append("\n"); 
		query.append("       #if (${hid_from_date} != ''|| ${hid_to_date} != '') " ).append("\n"); 
		query.append("         AND B.LOCL_CRE_DT BETWEEN TO_DATE (@[hid_from_date], 'rrrrmmdd') AND TO_DATE (@[hid_to_date], 'rrrrmmdd') + 0.999999" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       -- 조회 결과와는 상관없고 INDEX 사용을 위하여 추가" ).append("\n"); 
		query.append("       #if($arr_ofc_cd.size() > 0) " ).append("\n"); 
		query.append("         AND B.TRSP_WO_OFC_CTY_CD IN (" ).append("\n"); 
		query.append("         #foreach( ${key} IN ${arr_ofc_cd}) " ).append("\n"); 
		query.append("           #if($velocityCount < $arr_ofc_cd.size()) " ).append("\n"); 
		query.append("             SUBSTR(UPPER('${key}'),1,3)," ).append("\n"); 
		query.append("           #else " ).append("\n"); 
		query.append("             SUBSTR(UPPER('${key}'),1,3)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if($arr_ofc_cd.size() > 0) " ).append("\n"); 
		query.append("         AND B.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("         #foreach( ${key} IN ${arr_ofc_cd}) " ).append("\n"); 
		query.append("           #if($velocityCount < $arr_ofc_cd.size()) " ).append("\n"); 
		query.append("             UPPER('${key}')," ).append("\n"); 
		query.append("           #else " ).append("\n"); 
		query.append("             UPPER('${key}')" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${sel_sotype} != '')" ).append("\n"); 
		query.append("         AND A.TRSP_SO_TP_CD = @[sel_sotype]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${sel_costmode} != '')" ).append("\n"); 
		query.append("         AND A.TRSP_COST_DTL_MOD_CD = @[sel_costmode]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${sel_transmode} != '')" ).append("\n"); 
		query.append("         AND A.TRSP_CRR_MOD_CD = @[sel_transmode]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${sel_bound} != '')" ).append("\n"); 
		query.append("         AND A.TRSP_BND_CD = @[sel_bound]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if($arr_bkg_no.size() > 0) " ).append("\n"); 
		query.append("         AND A.BKG_NO IN (" ).append("\n"); 
		query.append("         #foreach( ${key} IN ${arr_bkg_no}) " ).append("\n"); 
		query.append("           #if($velocityCount < $arr_bkg_no.size()) " ).append("\n"); 
		query.append("             UPPER('${key}')," ).append("\n"); 
		query.append("           #else " ).append("\n"); 
		query.append("             UPPER('${key}')" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if($arr_eq_no.size() > 0) " ).append("\n"); 
		query.append("         AND A.EQ_NO IN (" ).append("\n"); 
		query.append("         #foreach( ${key} IN ${arr_eq_no}) " ).append("\n"); 
		query.append("           #if($velocityCount < $arr_bkg_no.size()) " ).append("\n"); 
		query.append("             UPPER('${key}')," ).append("\n"); 
		query.append("           #else " ).append("\n"); 
		query.append("             UPPER('${key}')" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if($arr_so_no.size() > 0) " ).append("\n"); 
		query.append("         AND ((A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("           #foreach( ${key} IN ${arr_so_no}) " ).append("\n"); 
		query.append("             #if($velocityCount == 1) " ).append("\n"); 
		query.append("                ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("               ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if($arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("         AND ((A.TRSP_WO_OFC_CTY_CD, A.TRSP_WO_SEQ) IN (" ).append("\n"); 
		query.append("           #foreach( ${key} IN ${arr_wo_no}) " ).append("\n"); 
		query.append("             #if($velocityCount == 1) " ).append("\n"); 
		query.append("                ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("               ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if (${hid_from_node} != '') " ).append("\n"); 
		query.append("         AND A.FM_NOD_CD LIKE @[hid_from_node]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${hid_via_node} != '') " ).append("\n"); 
		query.append("         AND A.VIA_NOD_CD LIKE @[hid_via_node]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${hid_to_node} != '') " ).append("\n"); 
		query.append("         AND A.TO_NOD_CD LIKE @[hid_to_node]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${hid_door_node} != '') " ).append("\n"); 
		query.append("         AND A.DOR_NOD_CD LIKE @[hid_door_node]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${sel_spoption} == '00')" ).append("\n"); 
		query.append("  AND WO_VNDR_SEQ = DFLT_VNDR_SEQ" ).append("\n"); 
		query.append("#elseif (${sel_spoption} == '01')" ).append("\n"); 
		query.append("  AND WO_VNDR_SEQ = DFLT_VNDR_SEQ" ).append("\n"); 
		query.append("  AND WO_CUST_NOMI_TRKR_IND_CD = DFLT_CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("#elseif (${sel_spoption} == '02')" ).append("\n"); 
		query.append("  AND WO_VNDR_SEQ = DFLT_VNDR_SEQ" ).append("\n"); 
		query.append("  AND WO_CUST_NOMI_TRKR_IND_CD <> DFLT_CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("#elseif (${sel_spoption} == '10')" ).append("\n"); 
		query.append("  AND WO_VNDR_SEQ <> DFLT_VNDR_SEQ" ).append("\n"); 
		query.append("#elseif (${sel_spoption} == '20')" ).append("\n"); 
		query.append("  AND WO_VNDR_SEQ = LOW_VNDR_SEQ" ).append("\n"); 
		query.append("#elseif (${sel_spoption} == '30')" ).append("\n"); 
		query.append("  AND WO_VNDR_SEQ <> LOW_VNDR_SEQ" ).append("\n"); 
		query.append("#elseif (${sel_spoption} == '40')" ).append("\n"); 
		query.append("  AND WO_VNDR_SEQ = USD_LOW_VNDR_SEQ" ).append("\n"); 
		query.append("#elseif (${sel_spoption} == '50')" ).append("\n"); 
		query.append("  AND WO_VNDR_SEQ <> USD_LOW_VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}