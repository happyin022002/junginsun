/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkDistributionDBDAOHJSSalesUnitCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOHJSSalesUnitCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HJSSalesUnitCost
	  * 2015.06.04 김시몬 단가생성시 BSA 의 FINAL SML CAPA로 생성하도록 변경
	  * </pre>
	  */
	public NetworkDistributionDBDAOHJSSalesUnitCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_selioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOHJSSalesUnitCostRSQL").append("\n"); 
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
		query.append("       A.COST_YRMON                              AS COST_YRMON," ).append("\n"); 
		query.append("       A.COST_WK                                 AS COST_WK," ).append("\n"); 
		query.append("       A.TRD_CD                                  AS TRD_CD," ).append("\n"); 
		query.append("       A.RLANE_CD                                AS RLANE_CD," ).append("\n"); 
		query.append("       A.VSL_CD                                  AS VSL_CD," ).append("\n"); 
		query.append("       A.SKD_VOY_NO                              AS SKD_VOY_NO," ).append("\n"); 
		query.append("       A.DIR_CD                                  AS DIR_CD," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = D.HUL_BND_CD) HUL_BND_CD," ).append("\n"); 
		query.append("       B.VOP_CD                                  AS VOP_CD," ).append("\n"); 
		query.append("       NVL(V.VSL_OSHP_CD,'OTH')                  AS VSL_OSHP_CD," ).append("\n"); 
		query.append("       B.VSL_CAPA                                AS VSL_CAPA," ).append("\n"); 
		query.append("       B.BSA_CAPA                                AS BSA_CAPA," ).append("\n"); 
		query.append("       B.BSA_OP_CD                               AS BSA_OP_CD," ).append("\n"); 
		query.append("       DECODE(B.BSA_OP_CD,'J','J/O','S','S/C')   AS BSA_OP_NM," ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("       C.HJS_SLS_UC_QTY                          AS HJS_SLS_UC_QTY," ).append("\n"); 
		query.append("       C.FNL_HJS_BSA_CAPA                        AS FNL_HJS_BSA_CAPA," ).append("\n"); 
		query.append("       C.HJS_SLS_AMT                             AS HJS_SLS_AMT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       C.AMT_1_01                                AS AMT_1_01, --Port Expense" ).append("\n"); 
		query.append("       C.AMT_1_02                                AS AMT_1_02, --Canal Transit Fee" ).append("\n"); 
		query.append("       C.AMT_1_03                                AS AMT_1_03, --Bunker" ).append("\n"); 
		query.append("       C.AMT_1_04                                AS AMT_1_04, --Crew Expense" ).append("\n"); 
		query.append("       C.AMT_1_05                                AS AMT_1_05, --Insurance" ).append("\n"); 
		query.append("       C.AMT_1_06                                AS AMT_1_06, --Lubricant Expense" ).append("\n"); 
		query.append("       C.AMT_1_07                                AS AMT_1_07, --Store Supply Expense" ).append("\n"); 
		query.append("       C.AMT_1_08                                AS AMT_1_08, --Vessel M&R" ).append("\n"); 
		query.append("       C.AMT_1_09                                AS AMT_1_09, --Depreciations" ).append("\n"); 
		query.append("       C.AMT_1_10                                AS AMT_1_10, --Telecom Expense" ).append("\n"); 
		query.append("       C.AMT_1_11                                AS AMT_1_11, --Other Operation Fixed Exp" ).append("\n"); 
		query.append("       C.AMT_1_12                                AS AMT_1_12, --Time Charterage" ).append("\n"); 
		query.append("       C.AMT_1_13                                AS AMT_1_13, --Space Charterage" ).append("\n"); 
		query.append("       C.AMT_1_14                                AS AMT_1_14, --VSL Interest" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("       C.AMT_2_01                                AS AMT_2_01, " ).append("\n"); 
		query.append("       C.AMT_2_02                                AS AMT_2_02," ).append("\n"); 
		query.append("       C.AMT_2_03                                AS AMT_2_03," ).append("\n"); 
		query.append("       C.AMT_2_04                                AS AMT_2_04," ).append("\n"); 
		query.append("       C.AMT_2_05                                AS AMT_2_05," ).append("\n"); 
		query.append("       C.AMT_2_06                                AS AMT_2_06," ).append("\n"); 
		query.append("       C.AMT_2_07                                AS AMT_2_07," ).append("\n"); 
		query.append("       C.AMT_2_08                                AS AMT_2_08," ).append("\n"); 
		query.append("       C.AMT_2_09                                AS AMT_2_09," ).append("\n"); 
		query.append("       C.AMT_2_10                                AS AMT_2_10," ).append("\n"); 
		query.append("       C.AMT_2_11                                AS AMT_2_11," ).append("\n"); 
		query.append("       C.AMT_2_12                                AS AMT_2_12," ).append("\n"); 
		query.append("       C.AMT_2_13                                AS AMT_2_13," ).append("\n"); 
		query.append("       C.AMT_2_14                                AS AMT_2_14" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  FROM MAS_MON_VVD A," ).append("\n"); 
		query.append("       BSA_VVD_MST B," ).append("\n"); 
		query.append("       (SELECT" ).append("\n"); 
		query.append("               A1.TRD_CD     ," ).append("\n"); 
		query.append("               A1.RLANE_CD   ," ).append("\n"); 
		query.append("               A1.IOC_CD     ," ).append("\n"); 
		query.append("               A1.VSL_CD     ," ).append("\n"); 
		query.append("               A1.SKD_VOY_NO ," ).append("\n"); 
		query.append("               A1.DIR_CD     ," ).append("\n"); 
		query.append("			   NVL(MAX(HJS_SLS_UC_QTY),0)                                         AS HJS_SLS_UC_QTY," ).append("\n"); 
		query.append("			   NVL(MAX(FNL_HJS_BSA_CAPA),0)                                       AS FNL_HJS_BSA_CAPA," ).append("\n"); 
		query.append("			   NVL(SUM(HJS_SLS_AMT),0)                                            AS HJS_SLS_AMT," ).append("\n"); 
		query.append(" 			 " ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'53101000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_01, --Port Expense" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'53102000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_02, --Canal Transit Fee" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'53200000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_03, --Bunker" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54100000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_04, --Crew Expense" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54250000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_05, --Insurance" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54300000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_06, --Lubricant Expense" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54200000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_07, --Store Supply Expense" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54150000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_08, --Vessel M&R" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54450000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_09, --Depreciations" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54180000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_10, --Telecom Expense" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54550000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_11, --Other Operation Fixed Exp" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54350000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_12, --Time Charterage" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54400000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_13, --Space Charterage" ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'72100000',A1.HJS_SLS_AMT,0)),0)    AS AMT_1_14, --Interest" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'53101000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_01," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'53102000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_02," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'53200000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_03," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54100000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_04," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54250000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_05," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54300000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_06," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54200000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_07," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54150000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_08," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54450000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_09," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54180000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_10," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54550000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_11," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54350000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_12," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'54400000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_13," ).append("\n"); 
		query.append("               NVL(SUM(DECODE(A1.STND_COST_CD,'72100000',A1.HJS_SLS_UC_AMT,0)),0) AS AMT_2_14             " ).append("\n"); 
		query.append("          FROM MAS_VVD_HIR A1" ).append("\n"); 
		query.append("         GROUP BY A1.TRD_CD," ).append("\n"); 
		query.append("                  A1.RLANE_CD," ).append("\n"); 
		query.append("                  A1.IOC_CD," ).append("\n"); 
		query.append("                  A1.VSL_CD," ).append("\n"); 
		query.append("                  A1.SKD_VOY_NO," ).append("\n"); 
		query.append("                  A1.DIR_CD" ).append("\n"); 
		query.append("       ) C," ).append("\n"); 
		query.append("       MAS_VSL_RGST V," ).append("\n"); 
		query.append("	   (SELECT TRD_CD, RLANE_CD, IOC_CD, DIR_CD, HUL_BND_CD FROM MAS_LANE_RGST) D" ).append("\n"); 
		query.append(" WHERE A.TRD_CD          = B.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD        = B.RLANE_CD" ).append("\n"); 
		query.append("   AND A.IOC_CD          = B.IOC_CD" ).append("\n"); 
		query.append("   AND A.VSL_CD          = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO      = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.DIR_CD          = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.TRD_CD          = C.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD        = C.RLANE_CD" ).append("\n"); 
		query.append("   AND A.IOC_CD          = C.IOC_CD" ).append("\n"); 
		query.append("   AND A.VSL_CD          = C.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO      = C.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.DIR_CD          = C.DIR_CD" ).append("\n"); 
		query.append("   AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND A.VSL_CD          = V.VSL_CD(+)" ).append("\n"); 
		query.append("   AND V.LST_FLG(+)      = 'Y'" ).append("\n"); 
		query.append("   AND V.DELT_FLG(+)     = 'N'" ).append("\n"); 
		query.append("   AND A.TRD_CD          = D.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD        = D.RLANE_CD" ).append("\n"); 
		query.append("   AND A.IOC_CD          = D.IOC_CD" ).append("\n"); 
		query.append("   AND A.DIR_CD          = D.DIR_CD" ).append("\n"); 
		query.append("   AND A.SLS_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("   AND A.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#if (${f_seltrade} != '')" ).append("\n"); 
		query.append("   AND A.TRD_CD = @[f_seltrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selrlane} != '')" ).append("\n"); 
		query.append("   AND A.RLANE_CD = @[f_selrlane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selioc} != '')" ).append("\n"); 
		query.append("   AND A.IOC_CD = @[f_selioc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("   AND A.VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("   AND A.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}