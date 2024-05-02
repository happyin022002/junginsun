/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOSearchFixCostByVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchFixCostByVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * archFixCostByVVDList SELECT
	  * History ----------------------------
	  * 2011.02.21 김상수 [CHM-201108827-01] 1. R.month/Week 및 OPR/OPR2 정보 보여주는 컬럼 추가
	  *                                      2. Re-Assignment by bound, Re-Assignment by bound(OP4)
	  *                                         화면상에서 틀고정 기능 추가
	  *                                      3. js상의 validation함수 정리 및  coMas.js로 소스이동
	  * 2015.03.05 김시몬 [CHM-201533657] '72100000' Interest 계정 추가
	  * </pre>
	  */
	public NetworkCostDBDAOSearchFixCostByVVDListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchFixCostByVVDListRSQL").append("\n"); 
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
		query.append("#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("       A1.COST_YRMON||A1.COST_WK||A1.TRD_CD||A1.RLANE_CD||A1.IOC_CD||A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD AS SUBSUM_CODE," ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("       A1.SLS_YRMON||A1.COST_WK||A1.TRD_CD||A1.RLANE_CD||A1.IOC_CD||A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD AS SUBSUM_CODE," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       A1.SLS_YRMON," ).append("\n"); 
		query.append("       A1.COST_YRMON," ).append("\n"); 
		query.append("       A1.COST_WK," ).append("\n"); 
		query.append("       CV.VOP_CD," ).append("\n"); 
		query.append("       CV.VSL_OSHP_CD," ).append("\n"); 
		query.append("       A1.TRD_CD," ).append("\n"); 
		query.append("       A1.RLANE_CD," ).append("\n"); 
		query.append("       A1.IOC_CD," ).append("\n"); 
		query.append("       A1.VSL_CD," ).append("\n"); 
		query.append("       A1.SKD_VOY_NO," ).append("\n"); 
		query.append("	   CV.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("       A1.DIR_CD," ).append("\n"); 
		query.append("	  (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = D.HUL_BND_CD) HUL_BND_CD," ).append("\n"); 
		query.append("       NVL ( (SELECT Y.CONTI_NM" ).append("\n"); 
		query.append("                FROM MDM_LOCATION X," ).append("\n"); 
		query.append("                     MDM_CONTINENT Y" ).append("\n"); 
		query.append("               WHERE X.CONTI_CD = Y.CONTI_CD" ).append("\n"); 
		query.append("                 AND X.LOC_CD = A2.LOC_CD)," ).append("\n"); 
		query.append("            '') AS CONTI_NM," ).append("\n"); 
		query.append("       A2.LOC_CD,    /* Port */" ).append("\n"); 
		query.append("       A2.VSL_DBL_CALL_SEQ,    /* Call IND */" ).append("\n"); 
		query.append("       A2.CLPT_SEQ,    /* Call SEQ */" ).append("\n"); 
		query.append("       A2.APLY_VOY_RTO,    /* Apply(%) */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '53101000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_01,                /* Port Expense */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '53102000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_02,                /* Canal Transit Fee */" ).append("\n"); 
		query.append("       A2.PORT_DYS,    /* Port Days */" ).append("\n"); 
		query.append("       A2.SEA_DYS,    /* Sea Days */" ).append("\n"); 
		query.append("       A2.TTL_TZ_DYS,    /* Total Days */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '53200000') THEN A2.FOIL_CSM * A2.TTL_TZ_DYS ELSE 0 END) AS AMT_13,    /* FO Cons.*/" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '53200000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_03,                /* Bunker */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '54100000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_04,                /* Crew Expense */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '54250000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_05,                /* Insurance */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '54300000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_06,                /* Lubricant Expense */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '54200000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_07,                /* Store Supply Expense */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '54150000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_08,                /* Vessel MnR */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '54450000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_09,                /* Deprecations */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '54180000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_10,                /* Telecom Expense */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '54550000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_11,                /* Other Operation Fixed Exp */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '54350000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_12,                /* Time Charterage */" ).append("\n"); 
		query.append("       SUM (CASE WHEN (A2.STND_COST_CD = '72100000') THEN A2.VSL_COST_AMT ELSE 0 END) AS AMT_14                 /* Interest */" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD A1," ).append("\n"); 
		query.append("       MAS_MON_VVD_PORT_COST A2," ).append("\n"); 
		query.append("       MAS_VSL_RGST CV," ).append("\n"); 
		query.append("	   (SELECT TRD_CD, RLANE_CD, IOC_CD, DIR_CD, HUL_BND_CD FROM MAS_LANE_RGST) D" ).append("\n"); 
		query.append(" WHERE A1.TRD_CD = A2.TRD_CD    /* A2 */" ).append("\n"); 
		query.append("   AND A1.RLANE_CD = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.IOC_CD = A2.IOC_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD = A2.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.DIR_CD = A2.DIR_CD" ).append("\n"); 
		query.append("   AND NVL (A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("	AND A1.TRD_CD          = D.TRD_CD" ).append("\n"); 
		query.append("	AND A1.RLANE_CD        = D.RLANE_CD" ).append("\n"); 
		query.append("    AND A1.IOC_CD          = D.IOC_CD" ).append("\n"); 
		query.append("    AND A1.DIR_CD          = D.DIR_CD" ).append("\n"); 
		query.append("#if (${f_seltrade} != '')" ).append("\n"); 
		query.append("   AND A1.TRD_CD = @[f_seltrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selrlane} != '')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD = @[f_selrlane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selioc} != '')" ).append("\n"); 
		query.append("   AND A1.IOC_CD = @[f_selioc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("   AND A1.VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("   AND A1.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("   #if (${f_year} != '')" ).append("\n"); 
		query.append("        AND A1.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("        AND A1.COST_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("   AND A1.SLS_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("   #if (${f_fm_wk} != '')" ).append("\n"); 
		query.append("        AND A1.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND CV.VSL_CD = A1.VSL_CD" ).append("\n"); 
		query.append("   AND A1.N1ST_LODG_PORT_ETD_DT BETWEEN TO_DATE (TO_CHAR (CV.VSL_APLY_FM_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') AND TO_DATE (TO_CHAR (CV.VSL_APLY_TO_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("GROUP BY A1.SLS_YRMON," ).append("\n"); 
		query.append("         A1.COST_YRMON," ).append("\n"); 
		query.append("         A1.COST_WK," ).append("\n"); 
		query.append("         CV.VOP_CD," ).append("\n"); 
		query.append("         CV.VSL_OSHP_CD," ).append("\n"); 
		query.append("         A1.TRD_CD," ).append("\n"); 
		query.append("         A1.RLANE_CD," ).append("\n"); 
		query.append("         A1.IOC_CD," ).append("\n"); 
		query.append("         A1.VSL_CD," ).append("\n"); 
		query.append("         A1.SKD_VOY_NO," ).append("\n"); 
		query.append("         A1.DIR_CD," ).append("\n"); 
		query.append("		 d.HUL_BND_CD," ).append("\n"); 
		query.append("		 CV.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("         A2.LOC_CD," ).append("\n"); 
		query.append("         A2.VSL_DBL_CALL_SEQ," ).append("\n"); 
		query.append("         A2.CLPT_SEQ," ).append("\n"); 
		query.append("         A2.APLY_VOY_RTO," ).append("\n"); 
		query.append("         A2.SEA_DYS," ).append("\n"); 
		query.append("         A2.PORT_DYS," ).append("\n"); 
		query.append("         A2.TTL_TZ_DYS" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("         A1.COST_YRMON," ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("         A1.SLS_YRMON," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         A1.COST_WK," ).append("\n"); 
		query.append("         A1.TRD_CD," ).append("\n"); 
		query.append("         A1.RLANE_CD," ).append("\n"); 
		query.append("         A1.IOC_CD," ).append("\n"); 
		query.append("         A1.VSL_CD," ).append("\n"); 
		query.append("         A1.SKD_VOY_NO," ).append("\n"); 
		query.append("         A1.DIR_CD," ).append("\n"); 
		query.append("         A2.CLPT_SEQ" ).append("\n"); 

	}
}