/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AsiaInlandCostManageDBDAOSearchInlnadCostSpeInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.03.11 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaInlandCostManageDBDAOSearchInlnadCostSpeInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInlnadCostSpeInquiry
	  * </pre>
	  */
	public AsiaInlandCostManageDBDAOSearchInlnadCostSpeInquiryRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration").append("\n"); 
		query.append("FileName : AsiaInlandCostManageDBDAOSearchInlnadCostSpeInquiryRSQL").append("\n"); 
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
		query.append("SELECT  A.CNT_CD" ).append("\n"); 
		query.append("      , A.IO_BND_CD" ).append("\n"); 
		query.append("      , A.COST_TRF_NO" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03051',A.COST_TRF_STS_CD) COST_TRF_STS_NM" ).append("\n"); 
		query.append("      , TO_CHAR(A.EFF_FM_DT, 'YYYY-MM-DD') EFF_FM_DT" ).append("\n"); 
		query.append("      , B.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      , B.CNTR_SZ_CD||'''' CNTR_SZ_CD" ).append("\n"); 
		query.append("      , B.DCGO_SVC_FLG" ).append("\n"); 
		query.append("      , B.DG_FX_RT" ).append("\n"); 
		query.append("      , B.DG_FX_RTO" ).append("\n"); 
		query.append("      , B.OVWT_CGO_SVC_FLG" ).append("\n"); 
		query.append("      , B.MIN_CGO_WGT" ).append("\n"); 
		query.append("      , B.MAX_CGO_WGT" ).append("\n"); 
		query.append("      , B.OVR_WGT_FX_RT" ).append("\n"); 
		query.append("      , B.OVR_WGT_FX_RTO" ).append("\n"); 
		query.append("      , TO_CHAR(A.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_CRE_DT" ).append("\n"); 
		query.append("      , ( SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID ) CRE_USR_ID" ).append("\n"); 
		query.append("      , A.CRE_OFC_CD" ).append("\n"); 
		query.append("      , TO_CHAR(A.LOCL_UPD_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_UPD_DT" ).append("\n"); 
		query.append("      , ( SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID ) UPD_USR_ID" ).append("\n"); 
		query.append("      , A.UPD_OFC_CD" ).append("\n"); 
		query.append("FROM    AOC_CHN_INLND_TRF_HDR A" ).append("\n"); 
		query.append("      , AOC_CHN_INLND_SPCL_TRF_DTL B      " ).append("\n"); 
		query.append("WHERE   A.COST_TRF_NO = B.COST_TRF_NO" ).append("\n"); 
		query.append("AND     A.COST_TRF_STS_CD = 'C'" ).append("\n"); 
		query.append("-- Effective as of" ).append("\n"); 
		query.append("#if(${eff_to_dt} != '')" ).append("\n"); 
		query.append("AND     TO_DATE(REPLACE(@[eff_to_dt],'-',''), 'YYYYMMDD') BETWEEN EFF_FM_DT AND EFF_TO_DT + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Location" ).append("\n"); 
		query.append("#if (${loc_nod_cd} != '')" ).append("\n"); 
		query.append("AND   " ).append("\n"); 
		query.append("A.CNT_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_locNodCds IN ${locNodCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $locNodCds.size())" ).append("\n"); 
		query.append("    '$user_locNodCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_locNodCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Trans Mode" ).append("\n"); 
		query.append("#if (${trsp_crr_mod_cd} != 'ALL')" ).append("\n"); 
		query.append("AND B.TRSP_CRR_MOD_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_trspCrrModCds IN ${trspCrrModCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $trspCrrModCds.size())" ).append("\n"); 
		query.append("    '$user_trspCrrModCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_trspCrrModCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Bound" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != 'ALL')" ).append("\n"); 
		query.append("AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Cost Tariff No" ).append("\n"); 
		query.append("#if (${cost_trf_no} != '')" ).append("\n"); 
		query.append("AND A.COST_TRF_NO IN (" ).append("\n"); 
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
		query.append("ORDER BY A.CNT_CD" ).append("\n"); 
		query.append("      , A.IO_BND_CD" ).append("\n"); 
		query.append("      , A.COST_TRF_NO" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03051',A.COST_TRF_STS_CD)" ).append("\n"); 
		query.append("      , A.EFF_FM_DT" ).append("\n"); 
		query.append("      , B.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      , B.CNTR_SZ_CD" ).append("\n"); 

	}
}