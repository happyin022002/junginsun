/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaInlandCostManageDBDAOSearchInlandCostDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.04
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.03.04 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInlandCostManageDBDAOSearchInlandCostDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInlandCostDetail
	  * </pre>
	  */
	public UsaInlandCostManageDBDAOSearchInlandCostDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration").append("\n"); 
		query.append("FileName : UsaInlandCostManageDBDAOSearchInlandCostDetailRSQL").append("\n"); 
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
		query.append("SELECT  ROWNUM ROW_NUM" ).append("\n"); 
		query.append("      , SUBSTR(PORT_NOD_CD, 1,5) || '-' || SUBSTR(LOC_NOD_CD, 1,5) PORT_LOC" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01725',RCV_DE_TERM_CD) RCV_DE_TERM_NM" ).append("\n"); 
		query.append("      , NVL(B.COST_SEL_ROUT_FLG, 'N') COST_SEL_ROUT_FLG" ).append("\n"); 
		query.append("      , PORT_NOD_CD" ).append("\n"); 
		query.append("      , HUB_NOD_CD" ).append("\n"); 
		query.append("      , LOC_NOD_CD" ).append("\n"); 
		query.append("      , TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      , B.MTY_PKUP_RTN_YD_CD" ).append("\n"); 
		query.append("      , B.CURR_CD" ).append("\n"); 
		query.append("      , INLND_20FT_TTL_AMT" ).append("\n"); 
		query.append("      , INLND_40FT_TTL_AMT" ).append("\n"); 
		query.append("      , SCC_CD" ).append("\n"); 
		query.append("      , NVL(MB_20FT_RTO,0)||'%' MB_20FT_RTO" ).append("\n"); 
		query.append("      , NVL(MB_40FT_RTO,0)||'%' MB_40FT_RTO" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', RAIL_20FT_BZC_COST_SRC_CD) RAIL_20FT_BZC_COST_SRC_NM" ).append("\n"); 
		query.append("      , RAIL_20FT_BZC_COST_AMT" ).append("\n"); 
		query.append("      , RAIL_20FT_BZC_COST_ADJ_AMT" ).append("\n"); 
		query.append("      , RAIL_20FT_BZC_COST_TTL_AMT" ).append("\n"); 
		query.append("      , RAIL_20FT_BZC_AGMT_WGT" ).append("\n"); 
		query.append("      , RAIL_20FT_BZC_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', RAIL_20FT_FUEL_SCG_SRC_CD) RAIL_20FT_FUEL_SCG_SRC_NM" ).append("\n"); 
		query.append("      , RAIL_20FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      , RAIL_20FT_FUEL_SCG_ADJ_AMT" ).append("\n"); 
		query.append("      , RAIL_20FT_FUEL_SCG_TTL_AMT" ).append("\n"); 
		query.append("      , RAIL_20FT_FUEL_SCG_AGMT_WGT" ).append("\n"); 
		query.append("      , RAIL_20FT_FUEL_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', RAIL_40FT_BZC_COST_SRC_CD) RAIL_40FT_BZC_COST_SRC_NM" ).append("\n"); 
		query.append("      , RAIL_40FT_BZC_COST_AMT" ).append("\n"); 
		query.append("      , RAIL_40FT_BZC_COST_ADJ_AMT" ).append("\n"); 
		query.append("      , RAIL_40FT_BZC_COST_TTL_AMT" ).append("\n"); 
		query.append("      , RAIL_40FT_BZC_AGMT_WGT" ).append("\n"); 
		query.append("      , RAIL_40FT_BZC_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', RAIL_40FT_FUEL_SCG_SRC_CD) RAIL_40FT_FUEL_SCG_SRC_NM" ).append("\n"); 
		query.append("      , RAIL_40FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      , RAIL_40FT_FUEL_SCG_ADJ_AMT" ).append("\n"); 
		query.append("      , RAIL_40FT_FUEL_SCG_TTL_AMT" ).append("\n"); 
		query.append("      , RAIL_40FT_FUEL_SCG_AGMT_WGT" ).append("\n"); 
		query.append("      , RAIL_40FT_FUEL_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', TRK_20FT_BZC_COST_SRC_CD) TRK_20FT_BZC_COST_SRC_NM" ).append("\n"); 
		query.append("      , TRK_20FT_BZC_COST_AMT" ).append("\n"); 
		query.append("      , TRK_20FT_BZC_COST_ADJ_AMT" ).append("\n"); 
		query.append("      , TRK_20FT_BZC_COST_TTL_AMT" ).append("\n"); 
		query.append("      , B.TRSP_AGMT_20FT_MTY_YD_CD" ).append("\n"); 
		query.append("      , CASE WHEN NVL(B.MTY_PKUP_RTN_YD_CD, 1) = NVL(B.TRSP_AGMT_20FT_MTY_YD_CD, 1) THEN 'N' ELSE 'Y' END AS TRSP_DIFF_20FT" ).append("\n"); 
		query.append("      , TRK_20FT_BZC_AGMT_WGT" ).append("\n"); 
		query.append("      , TRK_20FT_BZC_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', TRK_20FT_FUEL_SCG_SRC_CD) TRK_20FT_FUEL_SCG_SRC_NM" ).append("\n"); 
		query.append("      , TRK_20FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      , TRK_20FT_FUEL_SCG_ADJ_AMT" ).append("\n"); 
		query.append("      , TRK_20FT_FUEL_SCG_TTL_AMT" ).append("\n"); 
		query.append("      , TRK_20FT_FUEL_SCG_AGMT_WGT" ).append("\n"); 
		query.append("      , TRK_20FT_FUEL_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', TRK_40FT_BZC_COST_SRC_CD) TRK_40FT_BZC_COST_SRC_NM" ).append("\n"); 
		query.append("      , TRK_40FT_BZC_COST_AMT" ).append("\n"); 
		query.append("      , TRK_40FT_BZC_COST_ADJ_AMT" ).append("\n"); 
		query.append("      , TRK_40FT_BZC_COST_TTL_AMT" ).append("\n"); 
		query.append("      , B.TRSP_AGMT_40FT_MTY_YD_CD" ).append("\n"); 
		query.append("      , CASE WHEN NVL(B.MTY_PKUP_RTN_YD_CD, 1) = NVL(B.TRSP_AGMT_40FT_MTY_YD_CD, 1) THEN 'N' ELSE 'Y' END AS TRSP_DIFF_40FT" ).append("\n"); 
		query.append("      , TRK_40FT_BZC_AGMT_WGT" ).append("\n"); 
		query.append("      , TRK_40FT_BZC_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', TRK_40FT_FUEL_SCG_SRC_CD) TRK_40FT_FUEL_SCG_SRC_NM" ).append("\n"); 
		query.append("      , TRK_40FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      , TRK_40FT_FUEL_SCG_ADJ_AMT" ).append("\n"); 
		query.append("      , TRK_40FT_FUEL_SCG_TTL_AMT" ).append("\n"); 
		query.append("      , TRK_40FT_FUEL_SCG_AGMT_WGT" ).append("\n"); 
		query.append("      , TRK_40FT_FUEL_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      , MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("      , MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("      , DMST_20FT_COST_AMT" ).append("\n"); 
		query.append("      , DMST_40FT_COST_AMT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', TML_20FT_COST_SRC_CD) TML_20FT_COST_SRC_NM" ).append("\n"); 
		query.append("      , TML_20FT_COST_AMT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', TML_40FT_COST_SRC_CD) TML_40FT_COST_SRC_NM" ).append("\n"); 
		query.append("      , TML_40FT_COST_AMT" ).append("\n"); 
		query.append("      , N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("      , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = N1ST_VNDR_SEQ) N1ST_VNDR_NM" ).append("\n"); 
		query.append("      , N1ST_INLND_ROUT_CMB_FLG" ).append("\n"); 
		query.append("      , N2ND_VNDR_SEQ" ).append("\n"); 
		query.append("      , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = N2ND_VNDR_SEQ) N2ND_VNDR_NM" ).append("\n"); 
		query.append("      , N2ND_INLND_ROUT_CMB_FLG" ).append("\n"); 
		query.append("      , N3RD_VNDR_SEQ" ).append("\n"); 
		query.append("      , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = N3RD_VNDR_SEQ) N3RD_VNDR_NM" ).append("\n"); 
		query.append("      , DECODE(" ).append("\n"); 
		query.append("                GREATEST(NVL(N1ST_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(N1ST_VNDR_40FT_AGMT_OLD_FLG,0), NVL(N2ND_VNDR_20FT_AGMT_OLD_FLG,0), NVL(N2ND_VNDR_40FT_AGMT_OLD_FLG,0), NVL(N3RD_VNDR_20FT_AGMT_OLD_FLG,0), NVL(N3RD_VNDR_40FT_AGMT_OLD_FLG,0)),'0',NULL," ).append("\n"); 
		query.append("                GREATEST(NVL(N1ST_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(N1ST_VNDR_40FT_AGMT_OLD_FLG,0), NVL(N2ND_VNDR_20FT_AGMT_OLD_FLG,0), NVL(N2ND_VNDR_40FT_AGMT_OLD_FLG,0), NVL(N3RD_VNDR_20FT_AGMT_OLD_FLG,0), NVL(N3RD_VNDR_40FT_AGMT_OLD_FLG,0))" ).append("\n"); 
		query.append("        ) AS AGMT_OLD_FLG" ).append("\n"); 
		query.append("      , A.COST_TRF_NO" ).append("\n"); 
		query.append("      , COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("      , COST_ROUT_GRP_NO" ).append("\n"); 
		query.append("      , RANK() OVER (PARTITION BY COST_ROUT_GRP_NO ORDER BY " ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TT4')" ).append("\n"); 
		query.append("                                                            INLND_40FT_TTL_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TT2')" ).append("\n"); 
		query.append("                                                            INLND_20FT_TTL_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'RB4')" ).append("\n"); 
		query.append("                                                            DECODE(RAIL_40FT_BZC_COST_SRC_CD, 'A', 'A', 'X') ASC, RAIL_40FT_BZC_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'RF4')" ).append("\n"); 
		query.append("                                                            DECODE(RAIL_40FT_FUEL_SCG_SRC_CD, 'A', 'A', 'X') ASC, RAIL_40FT_FUEL_SCG_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'RB2')" ).append("\n"); 
		query.append("                                                            DECODE(RAIL_20FT_BZC_COST_SRC_CD, 'A', 'A', 'X') ASC, RAIL_20FT_BZC_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'RF2')" ).append("\n"); 
		query.append("                                                            DECODE(RAIL_20FT_FUEL_SCG_SRC_CD, 'A', 'A', 'X') ASC, RAIL_20FT_FUEL_SCG_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TB4')" ).append("\n"); 
		query.append("                                                            DECODE(TRK_40FT_BZC_COST_SRC_CD, 'A', 'A', 'X') ASC, TRK_40FT_BZC_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TF4')" ).append("\n"); 
		query.append("                                                            DECODE(TRK_40FT_FUEL_SCG_SRC_CD, 'A', 'A', 'X') ASC, TRK_40FT_FUEL_SCG_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TB2')" ).append("\n"); 
		query.append("                                                            DECODE(TRK_20FT_BZC_COST_SRC_CD, 'A', 'A', 'X') ASC, TRK_20FT_BZC_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TF2')" ).append("\n"); 
		query.append("                                                            DECODE(TRK_20FT_FUEL_SCG_SRC_CD, 'A', 'A', 'X') ASC, TRK_20FT_FUEL_SCG_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'MT4')" ).append("\n"); 
		query.append("                                                            MTY_TRSP_40FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'MT2')" ).append("\n"); 
		query.append("                                                            MTY_TRSP_20FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'DT4')" ).append("\n"); 
		query.append("                                                            DMST_40FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'DT2')" ).append("\n"); 
		query.append("                                                            DMST_20FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TM4')" ).append("\n"); 
		query.append("                                                            DECODE(TML_40FT_COST_SRC_CD, 'A', 'A', 'X') ASC, TML_40FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TM2')" ).append("\n"); 
		query.append("                                                            DECODE(TML_20FT_COST_SRC_CD, 'A', 'A', 'X') ASC, TML_20FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_asc_desc} == 'asc')" ).append("\n"); 
		query.append("                                                            ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_asc_desc} == 'desc')" ).append("\n"); 
		query.append("                                                            DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                          , COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("        ) COST_ROUT_GRP_NO_RNK" ).append("\n"); 
		query.append("      , B.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("      , '' UPD_USR_ID" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("          SELECT  COUNT(1)" ).append("\n"); 
		query.append("          FROM    AOC_USA_INLND_RF_TRF_DTL" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     COST_TRF_NO = B.COST_TRF_NO" ).append("\n"); 
		query.append("          AND     COST_TRF_ROUT_SEQ = B.COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("          AND     DELT_FLG = 'N'" ).append("\n"); 
		query.append("        ) RF_CNT" ).append("\n"); 
		query.append("      , B.TOLL_FEE_AMT AS TOLL_FEE_AMT_20" ).append("\n"); 
		query.append("      , B.TOLL_FEE_AMT AS TOLL_FEE_AMT_40" ).append("\n"); 
		query.append("FROM    AOC_USA_INLND_TRF_HDR A" ).append("\n"); 
		query.append("      , AOC_USA_INLND_TRF_DTL B      " ).append("\n"); 
		query.append("WHERE   A.COST_TRF_NO = B.COST_TRF_NO" ).append("\n"); 
		query.append("AND     B.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("AND     B.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_cost_rout_grp_no} != '')" ).append("\n"); 
		query.append("AND     B.COST_ROUT_GRP_NO IN (${s_cost_rout_grp_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${svc_mod_cd} != '')" ).append("\n"); 
		query.append("AND     ( SUBSTR(B.PORT_NOD_CD, 1,5), B.TRSP_CRR_MOD_CD ) IN (" ).append("\n"); 
		query.append("                                                               SELECT  PORT_CD" ).append("\n"); 
		query.append("                                                                     , TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("                                                               FROM    AOC_USA_IPI_PORT" ).append("\n"); 
		query.append("                                                               WHERE   USA_COST_TRF_SVC_MOD_CD = @[svc_mod_cd]" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY COST_ROUT_GRP_NO" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TT4')" ).append("\n"); 
		query.append("      , INLND_40FT_TTL_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TT2')" ).append("\n"); 
		query.append("      , INLND_20FT_TTL_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'RB4')" ).append("\n"); 
		query.append("      , DECODE(RAIL_40FT_BZC_COST_SRC_CD, 'A', 'A', 'X') ASC, RAIL_40FT_BZC_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'RF4')" ).append("\n"); 
		query.append("      , DECODE(RAIL_40FT_FUEL_SCG_SRC_CD, 'A', 'A', 'X') ASC, RAIL_40FT_FUEL_SCG_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'RB2')" ).append("\n"); 
		query.append("      , DECODE(RAIL_20FT_BZC_COST_SRC_CD, 'A', 'A', 'X') ASC, RAIL_20FT_BZC_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'RF2')" ).append("\n"); 
		query.append("      , DECODE(RAIL_20FT_FUEL_SCG_SRC_CD, 'A', 'A', 'X') ASC, RAIL_20FT_FUEL_SCG_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TB4')" ).append("\n"); 
		query.append("      , DECODE(TRK_40FT_BZC_COST_SRC_CD, 'A', 'A', 'X') ASC, TRK_40FT_BZC_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TF4')" ).append("\n"); 
		query.append("      , DECODE(TRK_40FT_FUEL_SCG_SRC_CD, 'A', 'A', 'X') ASC, TRK_40FT_FUEL_SCG_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TB2')" ).append("\n"); 
		query.append("      , DECODE(TRK_20FT_BZC_COST_SRC_CD, 'A', 'A', 'X') ASC, TRK_20FT_BZC_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TF2')" ).append("\n"); 
		query.append("      , DECODE(TRK_20FT_FUEL_SCG_SRC_CD, 'A', 'A', 'X') ASC, TRK_20FT_FUEL_SCG_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'MT4')" ).append("\n"); 
		query.append("      , MTY_TRSP_40FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'MT2')" ).append("\n"); 
		query.append("      , MTY_TRSP_20FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'DT4')" ).append("\n"); 
		query.append("      , DMST_40FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'DT2')" ).append("\n"); 
		query.append("      , DMST_20FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TM4')" ).append("\n"); 
		query.append("      , DECODE(TML_40FT_COST_SRC_CD, 'A', 'A', 'X') ASC" ).append("\n"); 
		query.append("      , TML_40FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_by} == 'TM2')" ).append("\n"); 
		query.append("      , DECODE(TML_20FT_COST_SRC_CD, 'A', 'A', 'X') ASC" ).append("\n"); 
		query.append("      , TML_20FT_COST_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_asc_desc} == 'asc')" ).append("\n"); 
		query.append("        ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_asc_desc} == 'desc')" ).append("\n"); 
		query.append("        DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      , COST_TRF_ROUT_SEQ" ).append("\n"); 

	}
}