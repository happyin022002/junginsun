/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaInlandCostManageDBDAOSearchInlandCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaInlandCostManageDBDAOSearchInlandCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInlandCost
	  * </pre>
	  */
	public AsiaInlandCostManageDBDAOSearchInlandCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_from_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration").append("\n"); 
		query.append("FileName : AsiaInlandCostManageDBDAOSearchInlandCostRSQL").append("\n"); 
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
		query.append("      , D.CURR_CD" ).append("\n"); 
		query.append("      , D.INLND_20FT_TTL_AMT" ).append("\n"); 
		query.append("      , D.INLND_40FT_TTL_AMT      " ).append("\n"); 
		query.append("      , D.LOC_GRP_NO" ).append("\n"); 
		query.append("      , D.SCC_CD" ).append("\n"); 
		query.append("      , NVL(D.MB_20FT_RTO,0)||'%' MB_20FT_RTO" ).append("\n"); 
		query.append("      , NVL(D.MB_40FT_RTO,0)||'%' MB_40FT_RTO" ).append("\n"); 
		query.append("      , D.TRSP_20FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , D.TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_AGMT_20FT_MTY_YD_CD" ).append("\n"); 
		query.append("      , CASE WHEN NVL(D.MTY_PKUP_RTN_YD_CD, 1) = NVL(D.TRSP_AGMT_20FT_MTY_YD_CD, 1) THEN 'N' ELSE 'Y' END AS TRSP_DIFF_20FT" ).append("\n"); 
		query.append("      , CASE WHEN TRSP_20FT_COST_SYS_SRC_CD <> 'A' AND DECODE(D.INLND_ROUT_CMB_FLG,'N',D.N1ST_VNDR_20FT_AGMT_WGT,GREATEST(D.N1ST_VNDR_20FT_AGMT_WGT, D.N2ND_VNDR_20FT_AGMT_WGT)) IS NULL THEN 'MAX'" ).append("\n"); 
		query.append("             WHEN DECODE(D.INLND_ROUT_CMB_FLG,'N',D.N1ST_VNDR_20FT_AGMT_WGT,GREATEST(D.N1ST_VNDR_20FT_AGMT_WGT, D.N2ND_VNDR_20FT_AGMT_WGT)) = 999999.99 THEN 'MAX'" ).append("\n"); 
		query.append("             ELSE TO_CHAR(DECODE(D.INLND_ROUT_CMB_FLG,'N',D.N1ST_VNDR_20FT_AGMT_WGT,GREATEST(D.N1ST_VNDR_20FT_AGMT_WGT, D.N2ND_VNDR_20FT_AGMT_WGT)))" ).append("\n"); 
		query.append("        END AGMT_WGT_20FT" ).append("\n"); 
		query.append("      , SUBSTR(D.N1ST_VNDR_20FT_AGMT_WY_TP_CD, 1, 1)||SUBSTR(D.N2ND_VNDR_20FT_AGMT_WY_TP_CD, 1, 1) AS TRSP_RATE_TYPE_20FT     " ).append("\n"); 
		query.append("      , D.TRSP_40FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , D.TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_AGMT_40FT_MTY_YD_CD" ).append("\n"); 
		query.append("      , CASE WHEN NVL(D.MTY_PKUP_RTN_YD_CD, 1) = NVL(D.TRSP_AGMT_40FT_MTY_YD_CD, 1) THEN 'N' ELSE 'Y' END AS TRSP_DIFF_40FT" ).append("\n"); 
		query.append("      , CASE WHEN TRSP_40FT_COST_SYS_SRC_CD <> 'A' AND DECODE(D.INLND_ROUT_CMB_FLG,'N',D.N1ST_VNDR_40FT_AGMT_WGT,GREATEST(D.N1ST_VNDR_40FT_AGMT_WGT, D.N2ND_VNDR_40FT_AGMT_WGT)) IS NULL THEN 'MAX'" ).append("\n"); 
		query.append("             WHEN DECODE(D.INLND_ROUT_CMB_FLG,'N',D.N1ST_VNDR_40FT_AGMT_WGT,GREATEST(D.N1ST_VNDR_40FT_AGMT_WGT, D.N2ND_VNDR_40FT_AGMT_WGT)) = 999999.99 THEN 'MAX'" ).append("\n"); 
		query.append("             ELSE TO_CHAR(DECODE(D.INLND_ROUT_CMB_FLG,'N',D.N1ST_VNDR_40FT_AGMT_WGT,GREATEST(D.N1ST_VNDR_40FT_AGMT_WGT, D.N2ND_VNDR_40FT_AGMT_WGT)))" ).append("\n"); 
		query.append("        END AGMT_WGT_40FT" ).append("\n"); 
		query.append("      , SUBSTR(D.N1ST_VNDR_40FT_AGMT_WY_TP_CD, 1, 1)||SUBSTR(D.N2ND_VNDR_40FT_AGMT_WY_TP_CD, 1, 1) AS TRSP_RATE_TYPE_40FT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_20FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , D.TML_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_40FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , D.TML_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , D.N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("      , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = D.N1ST_VNDR_SEQ) N1ST_VNDR_NM" ).append("\n"); 
		query.append("      , D.INLND_ROUT_CMB_FLG" ).append("\n"); 
		query.append("      , D.N2ND_VNDR_SEQ" ).append("\n"); 
		query.append("      , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = D.N2ND_VNDR_SEQ) N2ND_VNDR_NM" ).append("\n"); 
		query.append("      , DECODE(" ).append("\n"); 
		query.append("                GREATEST(NVL(D.N1ST_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(D.N1ST_VNDR_40FT_AGMT_OLD_FLG,'0'), NVL(D.N2ND_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(D.N2ND_VNDR_40FT_AGMT_OLD_FLG,'0')),'0',NULL," ).append("\n"); 
		query.append("                GREATEST(NVL(D.N1ST_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(D.N1ST_VNDR_40FT_AGMT_OLD_FLG,'0'), NVL(D.N2ND_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(D.N2ND_VNDR_40FT_AGMT_OLD_FLG,'0'))" ).append("\n"); 
		query.append("        ) AS AGMT_OLD_FLG" ).append("\n"); 
		query.append("      , D.COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("      , D.COST_ROUT_GRP_NO" ).append("\n"); 
		query.append("      , H.CNT_CD" ).append("\n"); 
		query.append("      , H.COST_TRF_NO" ).append("\n"); 
		query.append("      , D.UPD_USR_ID" ).append("\n"); 
		query.append("FROM    AOC_CHN_INLND_TRF_HDR H" ).append("\n"); 
		query.append("      , AOC_CHN_INLND_TRF_DTL D  " ).append("\n"); 
		query.append("WHERE   H.COST_TRF_NO = D.COST_TRF_NO" ).append("\n"); 
		query.append("AND     D.COST_SEL_ROUT_FLG = 'Y'" ).append("\n"); 
		query.append("AND     H.COST_TRF_STS_CD IN ('B','U','C')" ).append("\n"); 
		query.append("AND     D.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND     H.CNT_CD      = @[in_cnt_cd]" ).append("\n"); 
		query.append("AND     D.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_from_nod_cd} != '') " ).append("\n"); 
		query.append("AND     D.PORT_NOD_CD LIKE @[in_from_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_to_nod_cd} != '') " ).append("\n"); 
		query.append("AND     D.LOC_NOD_CD LIKE @[in_to_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}