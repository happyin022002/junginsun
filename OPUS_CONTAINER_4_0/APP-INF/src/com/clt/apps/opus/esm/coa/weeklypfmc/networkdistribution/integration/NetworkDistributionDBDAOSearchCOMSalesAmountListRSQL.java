/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchCOMSalesAmountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchCOMSalesAmountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOMSalesAmountList search
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchCOMSalesAmountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_seltrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selrlane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchCOMSalesAmountListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("     A.TRD_CD                                  AS TRD_CD" ).append("\n"); 
		query.append("    ,A.RLANE_CD                                AS RLANE_CD" ).append("\n"); 
		query.append("    ,A.VSL_CD                                  AS VSL_CD" ).append("\n"); 
		query.append("    ,A.SKD_VOY_NO                              AS SKD_VOY_NO" ).append("\n"); 
		query.append("    ,A.DIR_CD                                  AS DIR_CD" ).append("\n"); 
		query.append("    ,B.VOP_CD                                  AS VOP_CD" ).append("\n"); 
		query.append("    ,B.VSL_CAPA                                AS VSL_CAPA" ).append("\n"); 
		query.append("    ,B.BSA_CAPA                                AS BSA_CAPA" ).append("\n"); 
		query.append("    ,B.BSA_OP_CD                               AS BSA_OP_CD" ).append("\n"); 
		query.append("    ,DECODE(B.BSA_OP_CD, 'J','J/O', 'S','S/C') AS BSA_OP_NM" ).append("\n"); 
		query.append("    ,B.FNL_CO_BSA_CAPA                         AS FNL_CO_BSA_CAPA" ).append("\n"); 
		query.append("    ,B.CO_BSA_CAPA                             AS CO_BSA_CAPA" ).append("\n"); 
		query.append("    ,B.CO_BSA_RTO*100                          AS CO_BSA_RTO" ).append("\n"); 
		query.append("    ,B.CHTR_BSA_RTO*100                        AS CHTR_BSA_RTO" ).append("\n"); 
		query.append("    ,C.TS_UC_AMT                               AS TS_UC_AMT" ).append("\n"); 
		query.append("    ,C.AMT_1_01                                AS AMT_1_01 " ).append("\n"); 
		query.append("    ,C.AMT_1_02                                AS AMT_1_02 " ).append("\n"); 
		query.append("    ,C.AMT_1_03                                AS AMT_1_03 " ).append("\n"); 
		query.append("    ,C.AMT_1_04                                AS AMT_1_04 " ).append("\n"); 
		query.append("    ,C.AMT_1_05                                AS AMT_1_05 " ).append("\n"); 
		query.append("    ,C.AMT_1_06                                AS AMT_1_06 " ).append("\n"); 
		query.append("    ,C.AMT_1_07                                AS AMT_1_07 " ).append("\n"); 
		query.append("    ,C.AMT_1_08                                AS AMT_1_08 " ).append("\n"); 
		query.append("    ,C.AMT_1_09                                AS AMT_1_09 " ).append("\n"); 
		query.append("    ,C.AMT_1_10                                AS AMT_1_10 " ).append("\n"); 
		query.append("    ,C.AMT_1_11                                AS AMT_1_11 " ).append("\n"); 
		query.append("    ,C.AMT_1_12                                AS AMT_1_12 " ).append("\n"); 
		query.append("    ,C.AMT_1_13                                AS AMT_1_13 " ).append("\n"); 
		query.append("    ,C.AMT_1_14                                AS AMT_1_14 " ).append("\n"); 
		query.append("    ,C.AMT_1_15                                AS AMT_1_15 " ).append("\n"); 
		query.append("    ,C.AMT_2_01                                AS AMT_2_01 " ).append("\n"); 
		query.append("    ,C.AMT_2_02                                AS AMT_2_02 " ).append("\n"); 
		query.append("    ,C.AMT_2_03                                AS AMT_2_03 " ).append("\n"); 
		query.append("    ,C.AMT_2_04                                AS AMT_2_04 " ).append("\n"); 
		query.append("    ,C.AMT_2_05                                AS AMT_2_05 " ).append("\n"); 
		query.append("    ,C.AMT_2_06                                AS AMT_2_06 " ).append("\n"); 
		query.append("    ,C.AMT_2_07                                AS AMT_2_07 " ).append("\n"); 
		query.append("    ,C.AMT_2_08                                AS AMT_2_08 " ).append("\n"); 
		query.append("    ,C.AMT_2_09                                AS AMT_2_09 " ).append("\n"); 
		query.append("    ,C.AMT_2_10                                AS AMT_2_10 " ).append("\n"); 
		query.append("    ,C.AMT_2_11                                AS AMT_2_11 " ).append("\n"); 
		query.append("    ,C.AMT_2_12                                AS AMT_2_12 " ).append("\n"); 
		query.append("    ,C.AMT_2_13                                AS AMT_2_13 " ).append("\n"); 
		query.append("    ,C.AMT_2_14                                AS AMT_2_14 " ).append("\n"); 
		query.append("    ,C.AMT_2_15                                AS AMT_2_15 " ).append("\n"); 
		query.append("    ,C.AMT_3_01                                AS AMT_3_01 " ).append("\n"); 
		query.append("    ,C.AMT_3_02                                AS AMT_3_02 " ).append("\n"); 
		query.append("    ,C.AMT_3_03                                AS AMT_3_03 " ).append("\n"); 
		query.append("    ,C.AMT_3_04                                AS AMT_3_04 " ).append("\n"); 
		query.append("    ,C.AMT_3_05                                AS AMT_3_05 " ).append("\n"); 
		query.append("    ,C.AMT_3_06                                AS AMT_3_06 " ).append("\n"); 
		query.append("    ,C.AMT_3_07                                AS AMT_3_07 " ).append("\n"); 
		query.append("    ,C.AMT_3_08                                AS AMT_3_08 " ).append("\n"); 
		query.append("    ,C.AMT_3_09                                AS AMT_3_09 " ).append("\n"); 
		query.append("    ,C.AMT_3_10                                AS AMT_3_10 " ).append("\n"); 
		query.append("    ,C.AMT_3_11                                AS AMT_3_11 " ).append("\n"); 
		query.append("    ,C.AMT_3_12                                AS AMT_3_12 " ).append("\n"); 
		query.append("    ,C.AMT_3_13                                AS AMT_3_13 " ).append("\n"); 
		query.append("    ,C.AMT_3_14                                AS AMT_3_14 " ).append("\n"); 
		query.append("    ,C.AMT_3_15                                AS AMT_3_15 " ).append("\n"); 
		query.append("   FROM  COA_MON_VVD A" ).append("\n"); 
		query.append("        ,BSA_VVD_MST B" ).append("\n"); 
		query.append("        ,(SELECT" ).append("\n"); 
		query.append("              TRD_CD                                                    AS TRD_CD" ).append("\n"); 
		query.append("             ,RLANE_CD                                                  AS RLANE_CD" ).append("\n"); 
		query.append("             ,IOC_CD                                                    AS IOC_CD" ).append("\n"); 
		query.append("             ,VSL_CD                                                    AS VSL_CD" ).append("\n"); 
		query.append("             ,SKD_VOY_NO                                                AS SKD_VOY_NO" ).append("\n"); 
		query.append("             ,DIR_CD                                                    AS DIR_CD" ).append("\n"); 
		query.append("             ,SUM(TS_UC_AMT)                                            AS TS_UC_AMT" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'53101000',NTWK_HIR_COST_AMT,0))  AS AMT_1_01" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'53102000',NTWK_HIR_COST_AMT,0))  AS AMT_1_02" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'53200000',NTWK_HIR_COST_AMT,0))  AS AMT_1_03" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54100000',NTWK_HIR_COST_AMT,0))  AS AMT_1_04" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54250000',NTWK_HIR_COST_AMT,0))  AS AMT_1_05" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54300000',NTWK_HIR_COST_AMT,0))  AS AMT_1_06" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54200000',NTWK_HIR_COST_AMT,0))  AS AMT_1_07" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54150000',NTWK_HIR_COST_AMT,0))  AS AMT_1_08" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54450000',NTWK_HIR_COST_AMT,0))  AS AMT_1_09" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54180000',NTWK_HIR_COST_AMT,0))  AS AMT_1_10" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54550000',NTWK_HIR_COST_AMT,0))  AS AMT_1_11" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54350000',NTWK_HIR_COST_AMT,0))  AS AMT_1_12" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54400000',NTWK_HIR_COST_AMT,0))  AS AMT_1_13" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54400010',NTWK_HIR_COST_AMT,0))  AS AMT_1_14" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'75000000',NTWK_HIR_COST_AMT,0))  AS AMT_1_15		--20150622.ADD" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'53101000',CO_SLS_AMT,0))         AS AMT_2_01" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'53102000',CO_SLS_AMT,0))         AS AMT_2_02" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'53200000',CO_SLS_AMT,0))         AS AMT_2_03" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54100000',CO_SLS_AMT,0))         AS AMT_2_04" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54250000',CO_SLS_AMT,0))         AS AMT_2_05" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54300000',CO_SLS_AMT,0))         AS AMT_2_06" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54200000',CO_SLS_AMT,0))         AS AMT_2_07" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54150000',CO_SLS_AMT,0))         AS AMT_2_08" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54450000',CO_SLS_AMT,0))         AS AMT_2_09" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54180000',CO_SLS_AMT,0))         AS AMT_2_10" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54550000',CO_SLS_AMT,0))         AS AMT_2_11" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54350000',CO_SLS_AMT,0))         AS AMT_2_12" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54400000',CO_SLS_AMT,0))         AS AMT_2_13" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54400010',CO_SLS_AMT,0))         AS AMT_2_14" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'75000000',CO_SLS_AMT,0))         AS AMT_2_15		--20150622.ADD" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'53101000',CO_AMT,0))             AS AMT_3_01" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'53102000',CO_AMT,0))             AS AMT_3_02" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'53200000',CO_AMT,0))             AS AMT_3_03" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54100000',CO_AMT,0))             AS AMT_3_04" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54250000',CO_AMT,0))             AS AMT_3_05" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54300000',CO_AMT,0))             AS AMT_3_06" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54200000',CO_AMT,0))             AS AMT_3_07" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54150000',CO_AMT,0))             AS AMT_3_08" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54450000',CO_AMT,0))             AS AMT_3_09" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54180000',CO_AMT,0))             AS AMT_3_10" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54550000',CO_AMT,0))             AS AMT_3_11" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54350000',CO_AMT,0))             AS AMT_3_12" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54400000',CO_AMT,0))             AS AMT_3_13" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'54400010',CO_AMT,0))             AS AMT_3_14" ).append("\n"); 
		query.append("             ,SUM(DECODE(STND_COST_CD,'75000000',CO_AMT,0))             AS AMT_3_15		--20150622.ADD" ).append("\n"); 
		query.append("            FROM COA_VVD_HIR" ).append("\n"); 
		query.append("           GROUP BY TRD_CD" ).append("\n"); 
		query.append("                   ,RLANE_CD" ).append("\n"); 
		query.append("                   ,IOC_CD" ).append("\n"); 
		query.append("                   ,VSL_CD" ).append("\n"); 
		query.append("                   ,SKD_VOY_NO" ).append("\n"); 
		query.append("                   ,DIR_CD" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("  WHERE  A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("    AND  A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("    AND  A.IOC_CD     = B.IOC_CD" ).append("\n"); 
		query.append("    AND  A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("    AND  A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND  A.DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND  A.TRD_CD     = C.TRD_CD" ).append("\n"); 
		query.append("    AND  A.RLANE_CD   = C.RLANE_CD" ).append("\n"); 
		query.append("    AND  A.IOC_CD     = C.IOC_CD" ).append("\n"); 
		query.append("    AND  A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("    AND  A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND  A.DIR_CD     = C.DIR_CD" ).append("\n"); 
		query.append("    AND  NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${f_seltrade} != '')" ).append("\n"); 
		query.append("       AND A.TRD_CD = @[f_seltrade]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_selrlane} != '')" ).append("\n"); 
		query.append("       AND A.RLANE_CD = @[f_selrlane]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_selioc} != '')" ).append("\n"); 
		query.append("       AND A.IOC_CD = @[f_selioc]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("       AND A.VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("       AND A.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("       #if (${f_year} != '')" ).append("\n"); 
		query.append("           AND A.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("           AND A.COST_YRMON LIKE @[f_cost_yr] || '%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("	#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("       AND A.SLS_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("       #if (${f_fm_wk} != '')" ).append("\n"); 
		query.append("           AND A.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 

	}
}