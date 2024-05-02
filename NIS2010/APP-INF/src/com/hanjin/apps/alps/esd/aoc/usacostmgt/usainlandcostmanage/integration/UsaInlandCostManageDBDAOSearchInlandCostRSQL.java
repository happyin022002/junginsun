/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaInlandCostManageDBDAOSearchInlandCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.30
*@LastModifier : Chloe Mijin SEO
*@LastVersion : 1.0
* 2014.04.30 Chloe Mijin SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInlandCostManageDBDAOSearchInlandCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaInlandCostVO
	  * </pre>
	  */
	public UsaInlandCostManageDBDAOSearchInlandCostRSQL(){
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
		params.put("in_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration").append("\n"); 
		query.append("FileName : UsaInlandCostManageDBDAOSearchInlandCostRSQL").append("\n"); 
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
		query.append("SELECT  SUBSTR(D.PORT_NOD_CD, 1,5) || '-' || SUBSTR(D.LOC_NOD_CD, 1,5) PORT_LOC" ).append("\n"); 
		query.append("      , D.PORT_NOD_CD" ).append("\n"); 
		query.append("      , D.HUB_NOD_CD" ).append("\n"); 
		query.append("      , D.LOC_NOD_CD" ).append("\n"); 
		query.append("      , D.MTY_PKUP_RTN_YD_CD" ).append("\n"); 
		query.append("      , D.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01725',D.RCV_DE_TERM_CD) RCV_DE_TERM_NM" ).append("\n"); 
		query.append("      , D.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("          SELECT  USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("          FROM    AOC_USA_IPI_PORT" ).append("\n"); 
		query.append("          WHERE   PORT_CD = SUBSTR(D.PORT_NOD_CD,1,5)" ).append("\n"); 
		query.append("          AND     TRSP_CRR_MOD_CD = D.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("        ) LOCL_IPI_SVC_MOD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03118', (" ).append("\n"); 
		query.append("                                                      SELECT  USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("                                                      FROM    AOC_USA_IPI_PORT" ).append("\n"); 
		query.append("                                                      WHERE   PORT_CD = SUBSTR(D.PORT_NOD_CD,1,5)" ).append("\n"); 
		query.append("                                                      AND     TRSP_CRR_MOD_CD = D.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("        ) LOCL_IPI_SVC_MOD_NM" ).append("\n"); 
		query.append("      , D.CURR_CD" ).append("\n"); 
		query.append("      , '' RF_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , '' RF_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , D.INLND_20FT_TTL_AMT" ).append("\n"); 
		query.append("      , D.INLND_40FT_TTL_AMT" ).append("\n"); 
		query.append("      , D.RAIL_20FT_BZC_COST_TTL_AMT + D.RAIL_20FT_FUEL_SCG_TTL_AMT AS RAIL_20FT_TTL_AMT" ).append("\n"); 
		query.append("      , D.RAIL_40FT_BZC_COST_TTL_AMT + D.RAIL_40FT_FUEL_SCG_TTL_AMT AS RAIL_40FT_TTL_AMT" ).append("\n"); 
		query.append("      , D.TRK_20FT_BZC_COST_TTL_AMT + D.TRK_20FT_FUEL_SCG_TTL_AMT + D.TOLL_FEE_AMT AS TRK_20FT_TTL_AMT" ).append("\n"); 
		query.append("      , D.TRK_40FT_BZC_COST_TTL_AMT + D.TRK_40FT_FUEL_SCG_TTL_AMT + D.TOLL_FEE_AMT AS TRK_40FT_TTL_AMT" ).append("\n"); 
		query.append("      , D.SCC_CD" ).append("\n"); 
		query.append("      , NVL(D.MB_20FT_RTO,0)||'%' MB_20FT_RTO" ).append("\n"); 
		query.append("      , NVL(D.MB_40FT_RTO,0)||'%' MB_40FT_RTO" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.RAIL_20FT_BZC_COST_SRC_CD" ).append("\n"); 
		query.append("      , D.RAIL_20FT_BZC_COST_AMT" ).append("\n"); 
		query.append("      , D.RAIL_20FT_BZC_COST_ADJ_AMT" ).append("\n"); 
		query.append("      , D.RAIL_20FT_BZC_COST_TTL_AMT" ).append("\n"); 
		query.append("      , CASE WHEN D.RAIL_20FT_BZC_COST_SRC_CD <> 'A' AND D.RAIL_20FT_BZC_AGMT_WGT IS NULL THEN 'MAX'" ).append("\n"); 
		query.append("             WHEN D.RAIL_20FT_BZC_AGMT_WGT = 999999.99 THEN 'MAX'" ).append("\n"); 
		query.append("             ELSE TO_CHAR(D.RAIL_20FT_BZC_AGMT_WGT)" ).append("\n"); 
		query.append("        END RAIL_20FT_BZC_AGMT_WGT" ).append("\n"); 
		query.append("      , D.RAIL_20FT_BZC_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.RAIL_20FT_FUEL_SCG_SRC_CD" ).append("\n"); 
		query.append("      , D.RAIL_20FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      , D.RAIL_20FT_FUEL_SCG_ADJ_AMT" ).append("\n"); 
		query.append("      , D.RAIL_20FT_FUEL_SCG_TTL_AMT" ).append("\n"); 
		query.append("      , CASE WHEN D.RAIL_20FT_FUEL_SCG_SRC_CD <> 'A' AND D.RAIL_20FT_FUEL_SCG_AGMT_WGT IS NULL THEN 'MAX'" ).append("\n"); 
		query.append("             WHEN D.RAIL_20FT_FUEL_SCG_AGMT_WGT = 999999.99 THEN 'MAX'" ).append("\n"); 
		query.append("             ELSE TO_CHAR(D.RAIL_20FT_FUEL_SCG_AGMT_WGT)" ).append("\n"); 
		query.append("        END RAIL_20FT_FUEL_SCG_AGMT_WGT" ).append("\n"); 
		query.append("      , D.RAIL_20FT_FUEL_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.RAIL_40FT_BZC_COST_SRC_CD" ).append("\n"); 
		query.append("      , D.RAIL_40FT_BZC_COST_AMT" ).append("\n"); 
		query.append("      , D.RAIL_40FT_BZC_COST_ADJ_AMT" ).append("\n"); 
		query.append("      , D.RAIL_40FT_BZC_COST_TTL_AMT" ).append("\n"); 
		query.append("      , CASE WHEN D.RAIL_40FT_BZC_COST_SRC_CD <> 'A' AND D.RAIL_40FT_BZC_AGMT_WGT IS NULL THEN 'MAX'" ).append("\n"); 
		query.append("             WHEN D.RAIL_40FT_BZC_AGMT_WGT = 999999.99 THEN 'MAX'" ).append("\n"); 
		query.append("             ELSE TO_CHAR(D.RAIL_40FT_BZC_AGMT_WGT)" ).append("\n"); 
		query.append("        END RAIL_40FT_BZC_AGMT_WGT" ).append("\n"); 
		query.append("      , D.RAIL_40FT_BZC_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.RAIL_40FT_FUEL_SCG_SRC_CD" ).append("\n"); 
		query.append("      , D.RAIL_40FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      , D.RAIL_40FT_FUEL_SCG_ADJ_AMT" ).append("\n"); 
		query.append("      , D.RAIL_40FT_FUEL_SCG_TTL_AMT" ).append("\n"); 
		query.append("      , CASE WHEN D.RAIL_40FT_FUEL_SCG_SRC_CD <> 'A' AND D.RAIL_40FT_FUEL_SCG_AGMT_WGT IS NULL THEN 'MAX'" ).append("\n"); 
		query.append("             WHEN D.RAIL_40FT_FUEL_SCG_AGMT_WGT = 999999.99 THEN 'MAX'" ).append("\n"); 
		query.append("             ELSE TO_CHAR(D.RAIL_40FT_FUEL_SCG_AGMT_WGT)" ).append("\n"); 
		query.append("        END RAIL_40FT_FUEL_SCG_AGMT_WGT" ).append("\n"); 
		query.append("      , D.RAIL_40FT_FUEL_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.TRK_20FT_BZC_COST_SRC_CD" ).append("\n"); 
		query.append("      , D.TRK_20FT_BZC_COST_AMT" ).append("\n"); 
		query.append("      , D.TRK_20FT_BZC_COST_ADJ_AMT" ).append("\n"); 
		query.append("      , D.TRK_20FT_BZC_COST_TTL_AMT" ).append("\n"); 
		query.append("      , D.TRSP_AGMT_20FT_MTY_YD_CD" ).append("\n"); 
		query.append("      , CASE WHEN NVL(D.MTY_PKUP_RTN_YD_CD, 1) = NVL(D.TRSP_AGMT_20FT_MTY_YD_CD, 1) THEN 'N' ELSE 'Y' END AS TRSP_DIFF_20FT" ).append("\n"); 
		query.append("      , CASE WHEN D.TRK_20FT_BZC_COST_SRC_CD <> 'A' AND D.TRK_20FT_BZC_AGMT_WGT IS NULL THEN 'MAX'" ).append("\n"); 
		query.append("             WHEN D.TRK_20FT_BZC_AGMT_WGT = 999999.99 THEN 'MAX'" ).append("\n"); 
		query.append("             ELSE TO_CHAR(D.TRK_20FT_BZC_AGMT_WGT)" ).append("\n"); 
		query.append("        END TRK_20FT_BZC_AGMT_WGT" ).append("\n"); 
		query.append("      , D.TRK_20FT_BZC_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.TRK_20FT_FUEL_SCG_SRC_CD" ).append("\n"); 
		query.append("      , D.TRK_20FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      , D.TRK_20FT_FUEL_SCG_ADJ_AMT" ).append("\n"); 
		query.append("      , D.TRK_20FT_FUEL_SCG_TTL_AMT" ).append("\n"); 
		query.append("      , CASE WHEN D.TRK_20FT_FUEL_SCG_SRC_CD <> 'A' AND D.TRK_20FT_FUEL_SCG_AGMT_WGT IS NULL THEN 'MAX'" ).append("\n"); 
		query.append("             WHEN D.TRK_20FT_FUEL_SCG_AGMT_WGT = 999999.99 THEN 'MAX'" ).append("\n"); 
		query.append("             ELSE TO_CHAR(D.TRK_20FT_FUEL_SCG_AGMT_WGT)" ).append("\n"); 
		query.append("        END TRK_20FT_FUEL_SCG_AGMT_WGT" ).append("\n"); 
		query.append("      , D.TRK_20FT_FUEL_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.TRK_40FT_BZC_COST_SRC_CD" ).append("\n"); 
		query.append("      , D.TRK_40FT_BZC_COST_AMT" ).append("\n"); 
		query.append("      , D.TRK_40FT_BZC_COST_ADJ_AMT" ).append("\n"); 
		query.append("      , D.TRK_40FT_BZC_COST_TTL_AMT" ).append("\n"); 
		query.append("      , D.TRSP_AGMT_40FT_MTY_YD_CD" ).append("\n"); 
		query.append("      , CASE WHEN NVL(D.MTY_PKUP_RTN_YD_CD, 1) = NVL(D.TRSP_AGMT_40FT_MTY_YD_CD, 1) THEN 'N' ELSE 'Y' END AS TRSP_DIFF_40FT" ).append("\n"); 
		query.append("      , CASE WHEN D.TRK_40FT_BZC_COST_SRC_CD <> 'A' AND D.TRK_40FT_BZC_AGMT_WGT IS NULL THEN 'MAX'" ).append("\n"); 
		query.append("             WHEN D.TRK_40FT_BZC_AGMT_WGT = 999999.99 THEN 'MAX'" ).append("\n"); 
		query.append("             ELSE TO_CHAR(D.TRK_40FT_BZC_AGMT_WGT)" ).append("\n"); 
		query.append("        END TRK_40FT_BZC_AGMT_WGT" ).append("\n"); 
		query.append("      , D.TRK_40FT_BZC_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.TRK_40FT_FUEL_SCG_SRC_CD" ).append("\n"); 
		query.append("      , D.TRK_40FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("      , D.TRK_40FT_FUEL_SCG_ADJ_AMT" ).append("\n"); 
		query.append("      , D.TRK_40FT_FUEL_SCG_TTL_AMT" ).append("\n"); 
		query.append("      , CASE WHEN D.TRK_40FT_FUEL_SCG_SRC_CD <> 'A' AND D.TRK_40FT_FUEL_SCG_AGMT_WGT IS NULL THEN 'MAX'" ).append("\n"); 
		query.append("             WHEN D.TRK_40FT_FUEL_SCG_AGMT_WGT = 999999.99 THEN 'MAX'" ).append("\n"); 
		query.append("             ELSE TO_CHAR(D.TRK_40FT_FUEL_SCG_AGMT_WGT)" ).append("\n"); 
		query.append("        END TRK_40FT_FUEL_SCG_AGMT_WGT" ).append("\n"); 
		query.append("      , D.TRK_40FT_FUEL_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_COST_SRC_CD" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_COST_SRC_CD" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.DMST_20FT_COST_SRC_CD" ).append("\n"); 
		query.append("      , D.DMST_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.DMST_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.DMST_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.DMST_40FT_COST_SRC_CD" ).append("\n"); 
		query.append("      , D.DMST_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.DMST_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.DMST_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.TML_20FT_COST_SRC_CD" ).append("\n"); 
		query.append("      , D.TML_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.TML_40FT_COST_SRC_CD" ).append("\n"); 
		query.append("      , D.TML_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , D.N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("      , ( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = D.N1ST_VNDR_SEQ ) N1ST_VNDR_NM" ).append("\n"); 
		query.append("      , D.N1ST_INLND_ROUT_CMB_FLG" ).append("\n"); 
		query.append("      , D.N2ND_VNDR_SEQ" ).append("\n"); 
		query.append("      , ( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = D.N2ND_VNDR_SEQ ) N2ND_VNDR_NM" ).append("\n"); 
		query.append("      , D.N2ND_INLND_ROUT_CMB_FLG" ).append("\n"); 
		query.append("      , D.N3RD_VNDR_SEQ" ).append("\n"); 
		query.append("      , ( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = D.N3RD_VNDR_SEQ ) N3RD_VNDR_NM" ).append("\n"); 
		query.append("      , DECODE(" ).append("\n"); 
		query.append("                GREATEST(NVL(D.N1ST_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(D.N1ST_VNDR_40FT_AGMT_OLD_FLG,'0'), NVL(D.N2ND_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(D.N2ND_VNDR_40FT_AGMT_OLD_FLG,'0'), NVL(D.N3RD_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(D.N3RD_VNDR_40FT_AGMT_OLD_FLG,'0')),'0',NULL," ).append("\n"); 
		query.append("                GREATEST(NVL(D.N1ST_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(D.N1ST_VNDR_40FT_AGMT_OLD_FLG,'0'), NVL(D.N2ND_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(D.N2ND_VNDR_40FT_AGMT_OLD_FLG,'0'), NVL(D.N3RD_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(D.N3RD_VNDR_40FT_AGMT_OLD_FLG,'0'))" ).append("\n"); 
		query.append("        ) AS AGMT_OLD_FLG" ).append("\n"); 
		query.append("      , D.COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("      , D.COST_ROUT_GRP_NO" ).append("\n"); 
		query.append("      , H.CNT_CD" ).append("\n"); 
		query.append("      , H.COST_TRF_NO" ).append("\n"); 
		query.append("      , D.UPD_USR_ID" ).append("\n"); 
		query.append("      , '' COST_TRF_RF_SEQ" ).append("\n"); 
		query.append("	  , D.TOLL_FEE_AMT AS TOLL_FEE_AMT_20" ).append("\n"); 
		query.append("      , D.TOLL_FEE_AMT AS TOLL_FEE_AMT_40" ).append("\n"); 
		query.append("FROM    AOC_USA_INLND_TRF_HDR H" ).append("\n"); 
		query.append("      , AOC_USA_INLND_TRF_DTL D  " ).append("\n"); 
		query.append("WHERE   H.COST_TRF_NO = D.COST_TRF_NO" ).append("\n"); 
		query.append("AND     D.COST_SEL_ROUT_FLG = 'Y'" ).append("\n"); 
		query.append("AND     H.COST_TRF_STS_CD IN ('B','U','C')" ).append("\n"); 
		query.append("AND     D.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND     H.CNT_CD      = @[in_cnt_cd]" ).append("\n"); 
		query.append("AND     D.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("AND     ( SUBSTR(D.PORT_NOD_CD, 1,5), D.TRSP_CRR_MOD_CD ) IN (" ).append("\n"); 
		query.append("                                                               SELECT  PORT_CD" ).append("\n"); 
		query.append("                                                                     , TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("                                                               FROM    AOC_USA_IPI_PORT" ).append("\n"); 
		query.append("                                                               WHERE   USA_COST_TRF_SVC_MOD_CD = @[svc_mod_cd]" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 

	}
}