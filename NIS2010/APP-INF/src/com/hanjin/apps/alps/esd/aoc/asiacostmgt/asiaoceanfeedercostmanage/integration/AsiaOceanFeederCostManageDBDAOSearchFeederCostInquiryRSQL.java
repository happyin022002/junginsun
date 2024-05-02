/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaOceanFeederCostManageDBDAOSearchFeederCostInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaOceanFeederCostManageDBDAOSearchFeederCostInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFeederCostInquiry
	  * </pre>
	  */
	public AsiaOceanFeederCostManageDBDAOSearchFeederCostInquiryRSQL(){
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
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pctl_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.integration").append("\n"); 
		query.append("FileName : AsiaOceanFeederCostManageDBDAOSearchFeederCostInquiryRSQL").append("\n"); 
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
		query.append("SELECT  M.COST_TRF_NO" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03051', M.COST_TRF_STS_CD) COST_TRF_STS_NM" ).append("\n"); 
		query.append("      , TO_CHAR(M.EFF_FM_DT, 'YYYY-MM-DD') EFF_FM_DT" ).append("\n"); 
		query.append("      , D.FM_NOD_CD" ).append("\n"); 
		query.append("      , D.TO_NOD_CD" ).append("\n"); 
		query.append("      , DECODE(D.PCTL_IO_BND_CD, 'O', 'Pre', 'I', 'Post') PCTL_IO_BND_NM" ).append("\n"); 
		query.append("      , D.DIR_CD" ).append("\n"); 
		query.append("      , D.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("      , D.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("	  , D.CURR_CD" ).append("\n"); 
		query.append("      , D.FDR_20FT_TTL_AMT" ).append("\n"); 
		query.append("      , D.FDR_40FT_TTL_AMT" ).append("\n"); 
		query.append("      , D.SCC_CD" ).append("\n"); 
		query.append("      , D.MB_20FT_RTO" ).append("\n"); 
		query.append("      , D.MB_40FT_RTO" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.TRSP_20FT_COST_SYS_SRC_CD) TRSP_20FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , TRSP_20FT_AGMT_WGT AGMT_WGT_20FT" ).append("\n"); 
		query.append("      , D.TRSP_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.TRSP_40FT_COST_SYS_SRC_CD) TRSP_40FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , TRSP_40FT_AGMT_WGT AGMT_WGT_40FT" ).append("\n"); 
		query.append("      , D.TRSP_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.MTY_TRSP_20FT_COST_SYS_SRC_CD) MTY_TRSP_20FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.MTY_TRSP_40FT_COST_SYS_SRC_CD) MTY_TRSP_40FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.TML_20FT_COST_SYS_SRC_CD) TML_20FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.TML_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.TML_40FT_COST_SYS_SRC_CD) TML_40FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.TML_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , D.VNDR_SEQ" ).append("\n"); 
		query.append("      , ( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = D.VNDR_SEQ ) VNDR_NM" ).append("\n"); 
		query.append("      , GREATEST( NVL(D.TRSP_20FT_AGMT_OLD_FLG,'N'), NVL(D.TRSP_40FT_AGMT_OLD_FLG,'N') ) AGMT_OLD_FLG" ).append("\n"); 
		query.append("      , TO_CHAR(M.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_CRE_DT" ).append("\n"); 
		query.append("      , ( SELECT C.USR_NM FROM COM_USER C WHERE  C.USR_ID = M.CRE_USR_ID ) CRE_USR_NM" ).append("\n"); 
		query.append("      , M.CRE_OFC_CD" ).append("\n"); 
		query.append("      , TO_CHAR(M.LOCL_UPD_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_UPD_DT" ).append("\n"); 
		query.append("      , ( SELECT C.USR_NM FROM COM_USER C WHERE  C.USR_ID = M.UPD_USR_ID ) UPD_USR_NM" ).append("\n"); 
		query.append("      , M.UPD_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bnt_flg} == 'N')" ).append("\n"); 
		query.append("      , D.COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    AOC_CHN_FDR_TRF_HDR M" ).append("\n"); 
		query.append("      , AOC_CHN_FDR_TRF_DTL D" ).append("\n"); 
		query.append("WHERE   M.COST_TRF_NO = D.COST_TRF_NO" ).append("\n"); 
		query.append("AND     M.COST_TRF_STS_CD IN ('B','U','C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${date_flg} == 'B')" ).append("\n"); 
		query.append("AND     M.LOCL_CRE_DT BETWEEN TO_DATE(REPLACE(@[from_dt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${date_flg} == 'U')" ).append("\n"); 
		query.append("AND     M.LOCL_UPD_DT BETWEEN TO_DATE(REPLACE(@[from_dt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${date_flg} == 'C')" ).append("\n"); 
		query.append("AND     M.EFF_FM_DT BETWEEN TO_DATE(REPLACE(@[from_dt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${eff_to_dt} != '')" ).append("\n"); 
		query.append("AND     TO_DATE(REPLACE(@[eff_to_dt],'-',''), 'YYYYMMDD') BETWEEN EFF_FM_DT AND EFF_TO_DT + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Cost Tariff No" ).append("\n"); 
		query.append("#if (${cost_trf_no} != '')" ).append("\n"); 
		query.append("AND     M.COST_TRF_NO IN (" ).append("\n"); 
		query.append("    #foreach ($user_costTrfNos IN ${costTrfNos})" ).append("\n"); 
		query.append("        #if($velocityCount < $costTrfNos.size())" ).append("\n"); 
		query.append("            '$user_costTrfNos'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_costTrfNos'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Pre/Post" ).append("\n"); 
		query.append("#if (${pctl_io_bnd_cd} != 'ALL')" ).append("\n"); 
		query.append("AND     D.PCTL_IO_BND_CD = @[pctl_io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- From" ).append("\n"); 
		query.append("#if (${from_nod_cd} != '')" ).append("\n"); 
		query.append("AND     (    SUBSTR(D.FM_NOD_CD, 1,2) IN (" ).append("\n"); 
		query.append("    #foreach ($user_fromNodCds IN ${fromNodCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $fromNodCds.size())" ).append("\n"); 
		query.append("            '$user_fromNodCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_fromNodCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("          OR SUBSTR(D.FM_NOD_CD, 1,5) IN (" ).append("\n"); 
		query.append("    #foreach ($user_fromNodCds IN ${fromNodCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $fromNodCds.size())" ).append("\n"); 
		query.append("            '$user_fromNodCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_fromNodCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("          OR D.FM_NOD_CD IN (" ).append("\n"); 
		query.append("    #foreach ($user_fromNodCds IN ${fromNodCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $fromNodCds.size())" ).append("\n"); 
		query.append("            '$user_fromNodCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_fromNodCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- To" ).append("\n"); 
		query.append("#if (${to_nod_cd} != '')" ).append("\n"); 
		query.append("AND     (    SUBSTR(D.TO_NOD_CD, 1,2) IN (" ).append("\n"); 
		query.append("    #foreach ($user_toNodCds IN ${toNodCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $toNodCds.size())" ).append("\n"); 
		query.append("            '$user_toNodCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_toNodCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("          OR SUBSTR(D.TO_NOD_CD, 1,5) IN (" ).append("\n"); 
		query.append("    #foreach ($user_toNodCds IN ${toNodCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $toNodCds.size())" ).append("\n"); 
		query.append("            '$user_toNodCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_toNodCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("          OR D.TO_NOD_CD IN (" ).append("\n"); 
		query.append("    #foreach ($user_toNodCds IN ${toNodCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $toNodCds.size())" ).append("\n"); 
		query.append("            '$user_toNodCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_toNodCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Cost Factor / System Source (CD03050)" ).append("\n"); 
		query.append("#if (${sys_src_cd} != 'ALL')" ).append("\n"); 
		query.append("AND     (    1 = 0" ).append("\n"); 
		query.append("     --Full Trans 20'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${fullTrans20} == 'Y')" ).append("\n"); 
		query.append("          OR D.TRSP_20FT_COST_SYS_SRC_CD IN (" ).append("\n"); 
		query.append("    #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("            '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --Full Trans 40' " ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${fullTrans40} == 'Y')" ).append("\n"); 
		query.append("          OR D.TRSP_40FT_COST_SYS_SRC_CD IN (" ).append("\n"); 
		query.append("    #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("            '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --TMNL 20'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${tmnl20} == 'Y')" ).append("\n"); 
		query.append("          OR D.TML_20FT_COST_SYS_SRC_CD IN (" ).append("\n"); 
		query.append("    #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("            '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --TMNL 40'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${tmnl40} == 'Y')" ).append("\n"); 
		query.append("          OR D.TML_40FT_COST_SYS_SRC_CD IN (" ).append("\n"); 
		query.append("    #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("            '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("     --Empty 20'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${empty20} == 'Y')" ).append("\n"); 
		query.append("          OR 'X' IN (" ).append("\n"); 
		query.append("    #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("            '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --Empty 40'" ).append("\n"); 
		query.append("#if (${cost_factor_cd} == 'ALL' || ${empty40} == 'Y')" ).append("\n"); 
		query.append("          OR 'X' IN (" ).append("\n"); 
		query.append("    #foreach ($user_sysSrcCds IN ${sysSrcCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $sysSrcCds.size())" ).append("\n"); 
		query.append("            '$user_sysSrcCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_sysSrcCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Cost Factor / Adjustment" ).append("\n"); 
		query.append("#if (${adjustment_cd} != 'ALL')" ).append("\n"); 
		query.append("AND     (    1 = 0" ).append("\n"); 
		query.append("     --Full Trans 20' " ).append("\n"); 
		query.append("    #if (${cost_factor_cd} == 'ALL' || ${fullTrans20} == 'Y')" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("          OR NVL(D.TRSP_20FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("          OR NVL(D.TRSP_20FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("     --Full Trans 40'" ).append("\n"); 
		query.append("    #if (${cost_factor_cd} == 'ALL' || ${fullTrans40} == 'Y')" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("          OR NVL(D.TRSP_40FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("          OR NVL(D.TRSP_40FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("     --TMNL 20' " ).append("\n"); 
		query.append("    #if (${cost_factor_cd} == 'ALL' || ${tmnl20} == 'Y')" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("          OR NVL(D.TML_20FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("          OR NVL(D.TML_20FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     --TMNL 40' " ).append("\n"); 
		query.append("    #if (${cost_factor_cd} == 'ALL' || ${tmnl40} == 'Y')" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("          OR NVL(D.TML_40FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("          OR NVL(D.TML_40FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     --Empty 20'" ).append("\n"); 
		query.append("    #if (${cost_factor_cd} == 'ALL' || ${empty20} == 'Y')" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("          OR NVL(D.MTY_TRSP_20FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("          OR NVL(D.MTY_TRSP_20FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     --Empty 40'" ).append("\n"); 
		query.append("    #if (${cost_factor_cd} == 'ALL' || ${empty40} == 'Y')" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'E')" ).append("\n"); 
		query.append("          OR NVL(D.MTY_TRSP_40FT_ADJ_COST_AMT, 0) = 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${adjustment_cd} == 'N')" ).append("\n"); 
		query.append("          OR NVL(D.MTY_TRSP_40FT_ADJ_COST_AMT, 0) <> 0" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bnt_flg} == 'N')" ).append("\n"); 
		query.append("AND     ROWNUM < 3001" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        M.COST_TRF_NO" ).append("\n"); 
		query.append("      , M.COST_TRF_STS_CD" ).append("\n"); 
		query.append("      , M.EFF_FM_DT" ).append("\n"); 
		query.append("      , D.FM_NOD_CD" ).append("\n"); 
		query.append("      , D.TO_NOD_CD" ).append("\n"); 
		query.append("      , D.PCTL_IO_BND_CD" ).append("\n"); 

	}
}