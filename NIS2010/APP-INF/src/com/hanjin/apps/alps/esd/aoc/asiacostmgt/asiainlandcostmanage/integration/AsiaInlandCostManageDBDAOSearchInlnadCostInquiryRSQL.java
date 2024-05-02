/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AsiaInlandCostManageDBDAOSearchInlnadCostInquiryRSQL.java
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

public class AsiaInlandCostManageDBDAOSearchInlnadCostInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInlnadCostInquiry
	  * </pre>
	  */
	public AsiaInlandCostManageDBDAOSearchInlnadCostInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AsiaInlandCostManageDBDAOSearchInlnadCostInquiryRSQL").append("\n"); 
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
		query.append("      , SUBSTR(B.PORT_NOD_CD, 1,5) || '-' || SUBSTR(B.LOC_NOD_CD, 1,5) PORT_LOC" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01725',B.RCV_DE_TERM_CD) RCV_DE_TERM_NM" ).append("\n"); 
		query.append("      , B.COST_SEL_ROUT_FLG" ).append("\n"); 
		query.append("      , B.PORT_NOD_CD" ).append("\n"); 
		query.append("      , B.HUB_NOD_CD" ).append("\n"); 
		query.append("      , B.LOC_NOD_CD" ).append("\n"); 
		query.append("      , B.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      , B.CURR_CD" ).append("\n"); 
		query.append("      , B.INLND_20FT_TTL_AMT" ).append("\n"); 
		query.append("      , B.INLND_40FT_TTL_AMT" ).append("\n"); 
		query.append("      , B.LOC_GRP_NO" ).append("\n"); 
		query.append("      , B.SCC_CD" ).append("\n"); 
		query.append("      , NVL(B.MB_20FT_RTO,0)||'%' MB_20FT_RTO" ).append("\n"); 
		query.append("      , NVL(B.MB_40FT_RTO,0)||'%' MB_40FT_RTO" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', B.TRSP_20FT_COST_SYS_SRC_CD) TRSP_20FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , B.TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("      , B.TRSP_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , B.TRSP_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , B.TRSP_AGMT_20FT_MTY_YD_CD" ).append("\n"); 
		query.append("      , CASE WHEN NVL(B.MTY_PKUP_RTN_YD_CD, 1) = NVL(B.TRSP_AGMT_20FT_MTY_YD_CD, 1) THEN 'N' ELSE 'Y' END AS TRSP_DIFF_20FT" ).append("\n"); 
		query.append("      , DECODE(B.INLND_ROUT_CMB_FLG,'N',B.N1ST_VNDR_20FT_AGMT_WGT,GREATEST(B.N1ST_VNDR_20FT_AGMT_WGT, B.N2ND_VNDR_20FT_AGMT_WGT)) AGMT_WGT_20FT" ).append("\n"); 
		query.append("      , SUBSTR(B.N1ST_VNDR_20FT_AGMT_WY_TP_CD, 1, 1)||SUBSTR(B.N2ND_VNDR_20FT_AGMT_WY_TP_CD, 1, 1) AS TRSP_RATE_TYPE_20FT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', B.TRSP_40FT_COST_SYS_SRC_CD) TRSP_40FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , B.TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("      , B.TRSP_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , B.TRSP_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , B.TRSP_AGMT_40FT_MTY_YD_CD" ).append("\n"); 
		query.append("      , CASE WHEN NVL(B.MTY_PKUP_RTN_YD_CD, 1) = NVL(B.TRSP_AGMT_40FT_MTY_YD_CD, 1) THEN 'N' ELSE 'Y' END AS TRSP_DIFF_40FT" ).append("\n"); 
		query.append("      , DECODE(B.INLND_ROUT_CMB_FLG,'N',B.N1ST_VNDR_40FT_AGMT_WGT,GREATEST(B.N1ST_VNDR_40FT_AGMT_WGT, B.N2ND_VNDR_40FT_AGMT_WGT)) AGMT_WGT_40FT" ).append("\n"); 
		query.append("      , SUBSTR(B.N1ST_VNDR_40FT_AGMT_WY_TP_CD, 1, 1)||SUBSTR(B.N2ND_VNDR_40FT_AGMT_WY_TP_CD, 1, 1) AS TRSP_RATE_TYPE_40FT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', B.MTY_TRSP_20FT_COST_SYS_SRC_CD) MTY_TRSP_20FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , B.MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("      , B.MTY_TRSP_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , B.MTY_TRSP_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', B.MTY_TRSP_40FT_COST_SYS_SRC_CD) MTY_TRSP_40FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , B.MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("      , B.MTY_TRSP_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , B.MTY_TRSP_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', B.TML_20FT_COST_SYS_SRC_CD) TML_20FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , B.TML_20FT_COST_AMT" ).append("\n"); 
		query.append("      , B.TML_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , B.TML_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', B.TML_40FT_COST_SYS_SRC_CD) TML_40FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , B.TML_40FT_COST_AMT" ).append("\n"); 
		query.append("      , B.TML_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , B.TML_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , B.N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("      , ( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = B.N1ST_VNDR_SEQ ) N1ST_VNDR_NM" ).append("\n"); 
		query.append("      , B.INLND_ROUT_CMB_FLG" ).append("\n"); 
		query.append("      , B.N2ND_VNDR_SEQ" ).append("\n"); 
		query.append("      , ( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = B.N2ND_VNDR_SEQ ) N2ND_VNDR_NM" ).append("\n"); 
		query.append("      , DECODE(" ).append("\n"); 
		query.append("                GREATEST(NVL(B.N1ST_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(B.N1ST_VNDR_40FT_AGMT_OLD_FLG,'0'), NVL(B.N2ND_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(B.N2ND_VNDR_40FT_AGMT_OLD_FLG,'0')),'0',NULL," ).append("\n"); 
		query.append("                GREATEST(NVL(B.N1ST_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(B.N1ST_VNDR_40FT_AGMT_OLD_FLG,'0'), NVL(B.N2ND_VNDR_20FT_AGMT_OLD_FLG,'0'), NVL(B.N2ND_VNDR_40FT_AGMT_OLD_FLG,'0'))" ).append("\n"); 
		query.append("        ) AS AGMT_OLD_FLG" ).append("\n"); 
		query.append("      , TO_CHAR(A.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_CRE_DT" ).append("\n"); 
		query.append("      , ( SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID ) CRE_USR_ID" ).append("\n"); 
		query.append("      , A.CRE_OFC_CD" ).append("\n"); 
		query.append("      , TO_CHAR(A.LOCL_UPD_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_UPD_DT" ).append("\n"); 
		query.append("      , ( SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append("      , A.UPD_OFC_CD" ).append("\n"); 
		query.append("#if (${bnt_flg} == 'N')" ).append("\n"); 
		query.append("      , B.CURR_CD" ).append("\n"); 
		query.append("      , B.COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM    AOC_CHN_INLND_TRF_HDR A" ).append("\n"); 
		query.append("      , AOC_CHN_INLND_TRF_DTL B      " ).append("\n"); 
		query.append("WHERE   A.COST_TRF_NO = B.COST_TRF_NO" ).append("\n"); 
		query.append("AND     A.COST_TRF_STS_CD = 'C'" ).append("\n"); 
		query.append("AND     B.COST_SEL_ROUT_FLG = 'Y'" ).append("\n"); 
		query.append("-- Effective as of" ).append("\n"); 
		query.append("#if(${eff_to_dt} != '')" ).append("\n"); 
		query.append("AND     TO_DATE(REPLACE(@[eff_to_dt],'-',''), 'YYYYMMDD') BETWEEN EFF_FM_DT AND EFF_TO_DT + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Location" ).append("\n"); 
		query.append("#if (${loc_nod_cd} != '')" ).append("\n"); 
		query.append("AND     (  " ).append("\n"); 
		query.append("            SUBSTR(B.LOC_NOD_CD, 1,2) IN (" ).append("\n"); 
		query.append("#foreach ($user_locNodCds IN ${locNodCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $locNodCds.size())" ).append("\n"); 
		query.append("    '$user_locNodCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_locNodCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("         OR SUBSTR(B.LOC_NOD_CD, 1,5) IN (" ).append("\n"); 
		query.append("#foreach ($user_locNodCds IN ${locNodCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $locNodCds.size())" ).append("\n"); 
		query.append("    '$user_locNodCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_locNodCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("         OR B.LOC_NOD_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_locNodCds IN ${locNodCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $locNodCds.size())" ).append("\n"); 
		query.append("    '$user_locNodCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_locNodCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Hub" ).append("\n"); 
		query.append("#if (${hub_nod_cd} != '')" ).append("\n"); 
		query.append("AND     (" ).append("\n"); 
		query.append("SUBSTR(B.HUB_NOD_CD, 1,2) IN (" ).append("\n"); 
		query.append("#foreach ($user_hubNodCds IN ${hubNodCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $hubNodCds.size())" ).append("\n"); 
		query.append("    '$user_hubNodCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_hubNodCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR SUBSTR(B.HUB_NOD_CD, 1,5) IN (" ).append("\n"); 
		query.append("#foreach ($user_hubNodCds IN ${hubNodCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $hubNodCds.size())" ).append("\n"); 
		query.append("    '$user_hubNodCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_hubNodCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR B.HUB_NOD_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_hubNodCds IN ${hubNodCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $hubNodCds.size())" ).append("\n"); 
		query.append("    '$user_hubNodCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_hubNodCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Port" ).append("\n"); 
		query.append("#if (${port_nod_cd} != '')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("SUBSTR(B.PORT_NOD_CD, 1,2) IN (" ).append("\n"); 
		query.append("#foreach ($user_portNodCds IN ${portNodCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $portNodCds.size())" ).append("\n"); 
		query.append("    '$user_portNodCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_portNodCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR SUBSTR(B.PORT_NOD_CD, 1,5) IN (" ).append("\n"); 
		query.append("#foreach ($user_portNodCds IN ${portNodCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $portNodCds.size())" ).append("\n"); 
		query.append("    '$user_portNodCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_portNodCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR B.PORT_NOD_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_portNodCds IN ${portNodCds})" ).append("\n"); 
		query.append("  #if($velocityCount < $portNodCds.size())" ).append("\n"); 
		query.append("    '$user_portNodCds'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    '$user_portNodCds'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("    )" ).append("\n"); 
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
		query.append("-- R/D Term" ).append("\n"); 
		query.append("#if (${rcv_de_term_cd} != 'ALL')" ).append("\n"); 
		query.append("AND B.RCV_DE_TERM_CD = @[rcv_de_term_cd]" ).append("\n"); 
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
		query.append("-- Cost Factor / System Source (CD03050)" ).append("\n"); 
		query.append("#if (${sys_src_cd} != 'ALL')" ).append("\n"); 
		query.append("AND (1=2" ).append("\n"); 
		query.append("     --Full Trans 20'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${fullTrans20} == 'Y')" ).append("\n"); 
		query.append("     OR B.TRSP_20FT_COST_SYS_SRC_CD IN (" ).append("\n"); 
		query.append("      #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("          '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --Full Trans 40' " ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${fullTrans40} == 'Y')" ).append("\n"); 
		query.append("     OR B.TRSP_40FT_COST_SYS_SRC_CD IN (" ).append("\n"); 
		query.append("      #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("          '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --TMNL 20'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${tmnl20} == 'Y')" ).append("\n"); 
		query.append("     OR B.TML_20FT_COST_SYS_SRC_CD IN (" ).append("\n"); 
		query.append("      #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("          '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --TMNL 40'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${tmnl40} == 'Y')" ).append("\n"); 
		query.append("     OR B.TML_40FT_COST_SYS_SRC_CD IN (" ).append("\n"); 
		query.append("      #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("          '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("     --Empty 20'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${empty20} == 'Y')" ).append("\n"); 
		query.append("     OR 'X' IN (" ).append("\n"); 
		query.append("      #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("          '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --Empty 40'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${empty40} == 'Y')" ).append("\n"); 
		query.append("     OR 'X' IN (" ).append("\n"); 
		query.append("      #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("          '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Cost Factor / Adjustment" ).append("\n"); 
		query.append("#if (${adjustment_cd} != 'ALL')" ).append("\n"); 
		query.append("AND (1=2" ).append("\n"); 
		query.append("     --Full Trans 20' " ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${fullTrans20} == 'Y')" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("     OR NVL(B.TRSP_20FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("     OR NVL(B.TRSP_20FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     --Full Trans 40'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${fullTrans40} == 'Y')" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("     OR NVL(B.TRSP_40FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("     OR NVL(B.TRSP_40FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     --TMNL 20' " ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${tmnl20} == 'Y')" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("     OR NVL(B.TML_20FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("     OR NVL(B.TML_20FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     --TMNL 40' " ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${tmnl40} == 'Y')" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("     OR NVL(B.TML_40FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("     OR NVL(B.TML_40FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     --Empty 20'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${empty20} == 'Y')" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("     OR NVL(B.MTY_TRSP_20FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("     OR NVL(B.MTY_TRSP_20FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     --Empty 40'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${empty40} == 'Y')" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("     OR NVL(B.MTY_TRSP_40FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("     OR NVL(B.MTY_TRSP_40FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   )" ).append("\n"); 
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
		query.append("      , SUBSTR(B.PORT_NOD_CD, 1,5) || '-' || SUBSTR(B.LOC_NOD_CD, 1,5)" ).append("\n"); 
		query.append("      , B.RCV_DE_TERM_CD" ).append("\n"); 

	}
}