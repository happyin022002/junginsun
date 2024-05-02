/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchSpSelectListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.19
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.10.19 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsearchSpSelectListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSpSelectList
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsearchSpSelectListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SP_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VNDR_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsearchSpSelectListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(WO_RJCT_FLG, 'Y', '1', '0') REJECTED_CHECK" ).append("\n"); 
		query.append("     , TRIM(REGEXP_SUBSTR(TRS_GET_COM_SO_RAIL_WGT_FNC('S', A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, NULL, A.BKG_NO, A.EQ_NO, A.EQ_TPSZ_CD, 'KGS', A.COP_NO, 'Y'), '[^|]+', 1, 1)) KGS_NET_WGT" ).append("\n"); 
		query.append("     , TRIM(REGEXP_SUBSTR(TRS_GET_COM_SO_RAIL_WGT_FNC('S', A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, NULL, A.BKG_NO, A.EQ_NO, A.EQ_TPSZ_CD, 'LBS', A.COP_NO, 'Y'), '[^|]+', 1, 1)) LBS_NET_WGT" ).append("\n"); 
		query.append("     , A.EQ_NO" ).append("\n"); 
		query.append("     , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , A.EQ_KND_CD" ).append("\n"); 
		query.append("     , A.CGO_TP_CD" ).append("\n"); 
		query.append("     , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00748', A.CGO_TP_CD) AS CGO_TP_NM" ).append("\n"); 
		query.append("     , A.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("     , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00744', A.TRSP_COST_DTL_MOD_CD) AS TRSP_COST_DTL_MOD_NM" ).append("\n"); 
		query.append("     , A.TRSP_SO_CMB_SEQ" ).append("\n"); 
		query.append("     , A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("     , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00283', A.TRSP_CRR_MOD_CD) AS TRSP_CRR_MOD_NM" ).append("\n"); 
		query.append("     , SUBSTR(A.FM_NOD_CD, 1, 5) FM_LOC_VALUE" ).append("\n"); 
		query.append("     , SUBSTR(A.FM_NOD_CD, 6, 2) FM_YARD_VALUE" ).append("\n"); 
		query.append("     , SUBSTR(A.VIA_NOD_CD, 1, 5) VIA_LOC_VALUE" ).append("\n"); 
		query.append("     , SUBSTR(A.VIA_NOD_CD, 6, 2) VIA_YARD_VALUE" ).append("\n"); 
		query.append("     , SUBSTR(A.TO_NOD_CD, 1, 5) TO_LOC_VALUE" ).append("\n"); 
		query.append("     , SUBSTR(A.TO_NOD_CD, 6, 2) TO_YARD_VALUE" ).append("\n"); 
		query.append("     , SUBSTR(A.DOR_NOD_CD, 1, 5) DOR_LOC_VALUE" ).append("\n"); 
		query.append("     , SUBSTR(A.DOR_NOD_CD, 6, 2) DOR_YARD_VALUE" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD||A.CUST_SEQ CUST_CNT_CD_SEQ" ).append("\n"); 
		query.append("     , DECODE(@[SP_TP_CD], 'CNT', 'Y', 'N') AS CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD" ).append("\n"); 
		query.append("     , A.CUST_SEQ" ).append("\n"); 
		query.append("     , A.DOR_DE_ADDR" ).append("\n"); 
		query.append("     , A.MLT_STOP_DE_FLG" ).append("\n"); 
		query.append("     , A.CNTR_WGT" ).append("\n"); 
		query.append("     , A.WGT_MEAS_UT_CD WGT_UT_CD" ).append("\n"); 
		query.append("     , A.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("     , CASE" ).append("\n"); 
		query.append("         WHEN D.DCGO_FLG ='Y' THEN 'DG'" ).append("\n"); 
		query.append("         WHEN D.BB_CGO_FLG ='Y' THEN 'BB'" ).append("\n"); 
		query.append("         WHEN D.AWK_CGO_FLG='Y' THEN 'AK'" ).append("\n"); 
		query.append("         WHEN D.RC_FLG ='Y' THEN 'RF'" ).append("\n"); 
		query.append("         WHEN D.RD_CGO_FLG ='Y' THEN 'RD'" ).append("\n"); 
		query.append("         ELSE ''" ).append("\n"); 
		query.append("       END BKGSPE" ).append("\n"); 
		query.append("     , ' ' MORE_CANDIDATES" ).append("\n"); 
		query.append("     , A.TRSP_RQST_ORD_REV_AMT REVENUE" ).append("\n"); 
		query.append("     , A.REV_CURR_CD" ).append("\n"); 
		query.append("     , A.N3PTY_BIL_FLG" ).append("\n"); 
		query.append("     , A.BKG_NO BKG_NO" ).append("\n"); 
		query.append("     , A.BL_NO BL_NO" ).append("\n"); 
		query.append("     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append("     , A.SLAN_CD LANE" ).append("\n"); 
		query.append("     , FDR_VSL_CD||FDR_SKD_VOY_NO||FDR_SKD_DIR_CD FDR_VVD" ).append("\n"); 
		query.append("     , NVL(A.DTN_USE_FLG, 'N') DTN_USE_FLG" ).append("\n"); 
		query.append("     , NVL(A.WO_BL_NO_ISS_FLG, 'N') WO_BL_NO_ISS_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDD') SO_CRE_DT" ).append("\n"); 
		query.append("     , TO_CHAR(WRK.LOCL_CRE_DT, 'YYYYMMDD') WO_ISSUE_DT" ).append("\n"); 
		query.append("     , '' WO_RJCT_DT" ).append("\n"); 
		query.append("     , A.INTER_RMK" ).append("\n"); 
		query.append("     , A.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("     , WRK.WO_RMK" ).append("\n"); 
		query.append("     , A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ AS TRSP_SO_OFC_CTY_CD_SEQ" ).append("\n"); 
		query.append("     , A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("     , A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("     , A.TRSP_SO_SEQ AS surcharge_key" ).append("\n"); 
		query.append("     , A.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("     , A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS TRSP_WO_OFC_CTY_CD_SEQ" ).append("\n"); 
		query.append("     , A.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("     , A.TRSP_WO_SEQ" ).append("\n"); 
		query.append("     , A.CRE_OFC_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("     , DECODE(VNDR.DELT_FLG, 'Y', '', @[VNDR_CD]) AS VNDR_SEQ" ).append("\n"); 
		query.append("     , DECODE(VNDR.DELT_FLG, 'Y', '', A.VNDR_SEQ) AS PRESET_VNDR_SEQ" ).append("\n"); 
		query.append("     , DECODE(VNDR.DELT_FLG, 'Y', '', VNDR.VNDR_LGL_ENG_NM) AS VNDR_NM" ).append("\n"); 
		query.append("     , NVL(VNDR.WO_EDI_USE_FLG, 'N') WO_EDI_USE_FLG" ).append("\n"); 
		query.append("     , A.TRSP_DFLT_VNDR_FLG AS DEFAULT_SP_FLG" ).append("\n"); 
		query.append("     , NVL(A.TRSP_FRST_FLG , 'N') TRSP_FRST_FLG" ).append("\n"); 
		query.append("     , A.TRSP_RJCT_RSN_CD" ).append("\n"); 
		query.append("     , A.TRSP_RQST_BKG_FLG" ).append("\n"); 
		query.append("     , A.TRSP_SO_CMB_TP_CD" ).append("\n"); 
		query.append("     , A.TRSP_BND_CD" ).append("\n"); 
		query.append("     , A.CMDT_CD" ).append("\n"); 
		query.append("     , A.FM_NOD_CD" ).append("\n"); 
		query.append("     , A.VIA_NOD_CD" ).append("\n"); 
		query.append("     , A.DOR_NOD_CD" ).append("\n"); 
		query.append("     , A.TO_NOD_CD" ).append("\n"); 
		query.append("     , CASE WHEN TRSP_SO_CMB_TP_CD = 'BD' THEN COUNT(A.TRSP_SO_SEQ) OVER (PARTITION BY TRSP_SO_CMB_TP_CD, TRSP_SO_CMB_SEQ)" ).append("\n"); 
		query.append("            ELSE 1" ).append("\n"); 
		query.append("       END BUNDLING_NO" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("     , A.ETC_ADD_AMT" ).append("\n"); 
		query.append("     , A.BZC_AMT" ).append("\n"); 
		query.append("     , A.FUEL_SCG_AMT" ).append("\n"); 
		query.append("     , A.NEGO_AMT" ).append("\n"); 
		query.append("     , ( NVL(A.BZC_AMT, 0) + NVL(A.NEGO_AMT, 0) + NVL(A.FUEL_SCG_AMT, 0) + NVL(A.ETC_ADD_AMT, 0) ) AS WO_TOT_AMT" ).append("\n"); 
		query.append("	 , TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD, TO_NUMBER(NVL(A.BZC_AMT, 0) + NVL(A.NEGO_AMT, 0) + NVL(A.FUEL_SCG_AMT, 0) + NVL(A.ETC_ADD_AMT, 0)), TO_CHAR(SYSDATE, 'YYYYMM')) AS WO_TOT_AMT_USD" ).append("\n"); 
		query.append("     , TRS_COMMON_PKG.GET_VNDR_WO_RJCT_HIS_FNC(A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ,A.VNDR_SEQ) AS WO_RJCT_INDCT" ).append("\n"); 
		query.append("     , @[SP_TP_CD] SP_TYPE" ).append("\n"); 
		query.append("     , A.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("     , '' AS TRSP_AGMT_RT_TP_NM" ).append("\n"); 
		query.append("     , A.TRO_SEQ" ).append("\n"); 
		query.append("     , TRSP_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("     , DECODE(B.BKG_CGO_TP_CD,'R','Y','N') RVN_MPT_CNTR" ).append("\n"); 
		query.append("     , A.TRS_SUB_STS_CD" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("     , BKG_BOOKING B" ).append("\n"); 
		query.append("     , BKG_CONTAINER D" ).append("\n"); 
		query.append("     , MDM_VENDOR VNDR" ).append("\n"); 
		query.append("     , TRS_TRSP_WRK_ORD WRK" ).append("\n"); 
		query.append(" WHERE A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO =D.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.EQ_NO =D.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND ${VNDR_CD} =VNDR.VNDR_SEQ (+)" ).append("\n"); 
		query.append("   AND A.TRSP_WO_OFC_CTY_CD =WRK.TRSP_WO_OFC_CTY_CD (+)" ).append("\n"); 
		query.append("   AND A.TRSP_WO_SEQ =WRK.TRSP_WO_SEQ (+)" ).append("\n"); 
		query.append("   AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#if($SO_NO.size() > 0)" ).append("\n"); 
		query.append("    #foreach($code IN ${SO_NO})" ).append("\n"); 
		query.append("        #if($velocityCount == 1)" ).append("\n"); 
		query.append("   AND ((A.TRSP_SO_OFC_CTY_CD = SUBSTR('$code', 1, 3)" ).append("\n"); 
		query.append("            AND A.TRSP_SO_SEQ = SUBSTR('$code', 4, 8))" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            OR (A.TRSP_SO_OFC_CTY_CD = SUBSTR('$code', 1, 3)" ).append("\n"); 
		query.append("                   AND A.TRSP_SO_SEQ = SUBSTR('$code', 4, 8))" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}