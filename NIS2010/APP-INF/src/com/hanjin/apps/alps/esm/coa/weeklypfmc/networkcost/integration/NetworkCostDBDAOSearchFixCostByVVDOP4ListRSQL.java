/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOSearchFixCostByVVDOP4ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchFixCostByVVDOP4ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NetworkCost의 데이타 모델에 해당되는 값을 불러온다
	  * History ----------------------------
	  * 2011.02.21 김상수 [CHM-201108827-01] 1. R.month/Week 및 OPR/OPR2 정보 보여주는 컬럼 추가
	  *                                      2. Re-Assignment by bound, Re-Assignment by bound(OP4)
	  *                                         화면상에서 틀고정 기능 추가
	  *                                      3. js상의 validation함수 정리 및  coCoa.js로 소스이동
	  * </pre>
	  */
	public NetworkCostDBDAOSearchFixCostByVVDOP4ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_op_lane_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchFixCostByVVDOP4ListRSQL").append("\n"); 
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
		query.append("SELECT SLS_YRMON," ).append("\n"); 
		query.append("       COST_YRMON," ).append("\n"); 
		query.append("       COST_WK," ).append("\n"); 
		query.append("       TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       OP_LANE_TP_CD AS LANE_TP_CD," ).append("\n"); 
		query.append("       VSL_CD||SKD_VOY_NO||DIR_CD AS VVD," ).append("\n"); 
		query.append("	   (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = HUL_BND_CD) HUL_BND_CD," ).append("\n"); 
		query.append("       FNL_HJS_BSA_CAPA BSA," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '54100000', N4TH_NTWK_COST_AMT, 0)) AS AMT_01," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '54250000', N4TH_NTWK_COST_AMT, 0)) AS AMT_02," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '54200000', N4TH_NTWK_COST_AMT, 0)) AS AMT_03," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '54300000', N4TH_NTWK_COST_AMT, 0)) AS AMT_04," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '54150000', N4TH_NTWK_COST_AMT, 0)) AS AMT_05," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '54450000', N4TH_NTWK_COST_AMT, 0)) AS AMT_06," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '54180000', N4TH_NTWK_COST_AMT, 0)) AS AMT_07," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '54550000', N4TH_NTWK_COST_AMT, 0)) AS AMT_08," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '54350000', N4TH_NTWK_COST_AMT, 0)) AS AMT_09," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '54400000', N4TH_NTWK_COST_AMT, 0)) AS AMT_10," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '43102011', N4TH_NTWK_COST_AMT, 0)) AS AMT_11," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '53101000', N4TH_NTWK_COST_AMT, 0)) AS AMT_12," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '53102000', N4TH_NTWK_COST_AMT, 0)) AS AMT_13," ).append("\n"); 
		query.append("       SUM (DECODE (STND_COST_CD, '53200000', N4TH_NTWK_COST_AMT, 0)) AS AMT_14" ).append("\n"); 
		query.append("  FROM (SELECT A1.SLS_YRMON," ).append("\n"); 
		query.append("               A1.COST_YRMON," ).append("\n"); 
		query.append("               A1.COST_WK," ).append("\n"); 
		query.append("               A1.TRD_CD," ).append("\n"); 
		query.append("               A1.RLANE_CD," ).append("\n"); 
		query.append("               A1.IOC_CD," ).append("\n"); 
		query.append("               A1.VSL_CD," ).append("\n"); 
		query.append("               A1.SKD_VOY_NO," ).append("\n"); 
		query.append("               A1.DIR_CD," ).append("\n"); 
		query.append("			   A4.HUL_BND_CD," ).append("\n"); 
		query.append("               A2.STND_COST_CD," ).append("\n"); 
		query.append("               A3.FNL_HJS_BSA_CAPA," ).append("\n"); 
		query.append("               NVL (A4.OP_LANE_TP_CD, 'OT') AS OP_LANE_TP_CD," ).append("\n"); 
		query.append("               NVL (A2.N4TH_NTWK_COST_AMT, 0) AS N4TH_NTWK_COST_AMT," ).append("\n"); 
		query.append("               @[user_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("               SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("               @[user_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("               SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("          FROM COA_MON_VVD A1," ).append("\n"); 
		query.append("               COA_VVD_HIR A2," ).append("\n"); 
		query.append("               BSA_VVD_MST A3," ).append("\n"); 
		query.append("               COA_LANE_RGST A4" ).append("\n"); 
		query.append("         WHERE A1.TRD_CD = A2.TRD_CD" ).append("\n"); 
		query.append("           AND A1.RLANE_CD = A2.RLANE_CD" ).append("\n"); 
		query.append("           AND A1.IOC_CD = A2.IOC_CD" ).append("\n"); 
		query.append("           AND A1.VSL_CD = A2.VSL_CD" ).append("\n"); 
		query.append("           AND A1.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A1.DIR_CD = A2.DIR_CD" ).append("\n"); 
		query.append("           AND A1.TRD_CD = A3.TRD_CD" ).append("\n"); 
		query.append("           AND A1.RLANE_CD = A3.RLANE_CD" ).append("\n"); 
		query.append("           AND A1.IOC_CD = A3.IOC_CD" ).append("\n"); 
		query.append("           AND A1.VSL_CD = A3.VSL_CD" ).append("\n"); 
		query.append("           AND A1.SKD_VOY_NO = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A1.DIR_CD = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND A1.RLANE_CD = A4.RLANE_CD" ).append("\n"); 
		query.append("           AND A1.DIR_CD = A4.DIR_CD" ).append("\n"); 
		query.append("           AND A1.TRD_CD = A4.TRD_CD" ).append("\n"); 
		query.append("           AND A1.IOC_CD = A4.IOC_CD" ).append("\n"); 
		query.append("           AND A4.VSL_LANE_TP_CD IN ('JO', 'SC')" ).append("\n"); 
		query.append("		   AND NVL(A4.OP_LANE_TP_CD, 'OT') <> 'OT'" ).append("\n"); 
		query.append("           AND NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("           AND NVL(A4.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("           AND A1.SUB_TRD_CD NOT IN ('IP')" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("           AND A1.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("           AND A1.SLS_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("           AND A1.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '')" ).append("\n"); 
		query.append("           AND A1.TRD_CD = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '')" ).append("\n"); 
		query.append("           AND A1.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("           AND A1.VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("           AND A1.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("           AND A1.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_op_lane_tp_cd} != '')" ).append("\n"); 
		query.append("           AND NVL (A4.OP_LANE_TP_CD, 'OT') = @[f_op_lane_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("GROUP BY SLS_YRMON," ).append("\n"); 
		query.append("         COST_YRMON," ).append("\n"); 
		query.append("         COST_WK," ).append("\n"); 
		query.append("         TRD_CD," ).append("\n"); 
		query.append("         RLANE_CD," ).append("\n"); 
		query.append("         OP_LANE_TP_CD," ).append("\n"); 
		query.append("         VSL_CD||SKD_VOY_NO||DIR_CD," ).append("\n"); 
		query.append(" 		 HUL_BND_CD," ).append("\n"); 
		query.append("         FNL_HJS_BSA_CAPA" ).append("\n"); 

	}
}