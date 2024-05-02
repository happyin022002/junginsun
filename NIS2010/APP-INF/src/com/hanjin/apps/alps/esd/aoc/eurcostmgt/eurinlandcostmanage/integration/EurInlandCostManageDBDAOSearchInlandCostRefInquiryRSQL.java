/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EurInlandCostManageDBDAOSearchInlandCostRefInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.03.11 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurInlandCostManageDBDAOSearchInlandCostRefInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInlandCostRefInquiry
	  * </pre>
	  */
	public EurInlandCostManageDBDAOSearchInlandCostRefInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.integration").append("\n"); 
		query.append("FileName : EurInlandCostManageDBDAOSearchInlandCostRefInquiryRSQL").append("\n"); 
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
		query.append("SELECT  H.CNT_CD" ).append("\n"); 
		query.append("      , H.IO_BND_CD" ).append("\n"); 
		query.append("      , H.COST_TRF_NO" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03051',H.COST_TRF_STS_CD) COST_TRF_STS_NM" ).append("\n"); 
		query.append("	  , TO_CHAR(H.EFF_FM_DT, 'YYYY-MM-DD') EFF_FM_DT" ).append("\n"); 
		query.append("      , SUBSTR(D.PORT_NOD_CD, 1,5) || '-' || SUBSTR(D.LOC_NOD_CD, 1,5) PORT_LOC" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01725',D.RCV_DE_TERM_CD) RCV_DE_TERM_NM" ).append("\n"); 
		query.append("      , D.COST_SEL_ROUT_FLG" ).append("\n"); 
		query.append("      , D.PORT_NOD_CD" ).append("\n"); 
		query.append("      , D.HUB_NOD_CD" ).append("\n"); 
		query.append("      , D.LOC_NOD_CD" ).append("\n"); 
		query.append("      , R.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      , D.CURR_CD" ).append("\n"); 
		query.append("      , R.RF_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , R.RF_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("FROM    AOC_EUR_INLND_TRF_HDR H" ).append("\n"); 
		query.append("      , AOC_EUR_INLND_TRF_DTL D" ).append("\n"); 
		query.append("      , AOC_EUR_INLND_RF_TRF_DTL R" ).append("\n"); 
		query.append("WHERE   H.COST_TRF_NO = D.COST_TRF_NO" ).append("\n"); 
		query.append("AND     D.COST_TRF_NO = R.COST_TRF_NO" ).append("\n"); 
		query.append("AND     D.COST_TRF_ROUT_SEQ = R.COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("AND     D.COST_SEL_ROUT_FLG = 'Y'" ).append("\n"); 
		query.append("AND     H.COST_TRF_STS_CD = 'C'" ).append("\n"); 
		query.append("-- Effective as of" ).append("\n"); 
		query.append("#if(${eff_to_dt} != '')" ).append("\n"); 
		query.append("AND     TO_DATE(REPLACE(@[eff_to_dt],'-',''), 'YYYYMMDD') BETWEEN EFF_FM_DT AND EFF_TO_DT + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Location" ).append("\n"); 
		query.append("#if (${loc_nod_cd} != '')" ).append("\n"); 
		query.append("AND   " ).append("\n"); 
		query.append("H.CNT_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_locNodCds IN ${locNodCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $locNodCds.size())" ).append("\n"); 
		query.append("    '$user_locNodCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_locNodCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- Trans Mode" ).append("\n"); 
		query.append("#if (${trsp_crr_mod_cd} != 'ALL')" ).append("\n"); 
		query.append("AND D.TRSP_CRR_MOD_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_trspCrrModCds IN ${trspCrrModCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $trspCrrModCds.size())" ).append("\n"); 
		query.append("    '$user_trspCrrModCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_trspCrrModCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- Bound" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != 'ALL')" ).append("\n"); 
		query.append("AND H.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- Cost Tariff No" ).append("\n"); 
		query.append("#if (${cost_trf_no} != '')" ).append("\n"); 
		query.append("AND H.COST_TRF_NO IN (" ).append("\n"); 
		query.append("#foreach ($user_costTrfNos IN ${costTrfNos})" ).append("\n"); 
		query.append("  #if($velocityCount < $costTrfNos.size())" ).append("\n"); 
		query.append("    '$user_costTrfNos'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_costTrfNos'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bnt_flg} == 'N')" ).append("\n"); 
		query.append("AND ROWNUM < 3001" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY H.CNT_CD" ).append("\n"); 
		query.append("      , H.IO_BND_CD" ).append("\n"); 
		query.append("      , H.COST_TRF_NO" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03051',H.COST_TRF_STS_CD)" ).append("\n"); 
		query.append("      , H.EFF_FM_DT" ).append("\n"); 
		query.append("      , D.TRSP_CRR_MOD_CD" ).append("\n"); 

	}
}