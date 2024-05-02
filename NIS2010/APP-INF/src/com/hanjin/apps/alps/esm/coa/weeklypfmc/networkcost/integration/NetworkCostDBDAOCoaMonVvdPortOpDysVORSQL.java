/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOCoaMonVvdPortOpDysVORSQL.java
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

public class NetworkCostDBDAOCoaMonVvdPortOpDysVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane Transit Time 2 조회   
	  * </pre>
	  */
	public NetworkCostDBDAOCoaMonVvdPortOpDysVORSQL(){
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
		params.put("f_seldir",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCoaMonVvdPortOpDysVORSQL").append("\n"); 
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
		query.append("SELECT SUBSTR (A1.COST_YRMON, 0, 4)||'-'||A1.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("       A5.VOP_CD," ).append("\n"); 
		query.append("       A2.VSL_CD," ).append("\n"); 
		query.append("       A2.SKD_VOY_NO," ).append("\n"); 
		query.append("       A2.DIR_CD," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = D.HUL_BND_CD) HUL_BND_CD," ).append("\n"); 
		query.append("       A4.CONTI_NM," ).append("\n"); 
		query.append("       A2.SLAN_CD," ).append("\n"); 
		query.append("       A2.TRD_CD," ).append("\n"); 
		query.append("       A2.RLANE_CD," ).append("\n"); 
		query.append("       A2.LOC_CD," ).append("\n"); 
		query.append("       A2.VSL_DBL_CALL_SEQ," ).append("\n"); 
		query.append("       A2.CLPT_SEQ," ).append("\n"); 
		query.append("       A2.PORT_DYS," ).append("\n"); 
		query.append("       A2.SEA_DYS," ).append("\n"); 
		query.append("       A2.TTL_TZ_DYS," ).append("\n"); 
		query.append("       A2.VVD_RMK," ).append("\n"); 
		query.append("       A2.IOC_CD" ).append("\n"); 
		query.append("  FROM COA_MON_VVD A1," ).append("\n"); 
		query.append("       COA_VSL_RGST A5," ).append("\n"); 
		query.append("       COA_MON_VVD_PORT_OP_DYS A2," ).append("\n"); 
		query.append("       MDM_LOCATION A3," ).append("\n"); 
		query.append("       MDM_CONTINENT A4," ).append("\n"); 
		query.append("	   COA_LANE_RGST D" ).append("\n"); 
		query.append(" WHERE A1.TRD_CD = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.IOC_CD = A2.IOC_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD = A2.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.DIR_CD = A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("   AND A2.LOC_CD = A3.LOC_CD" ).append("\n"); 
		query.append("   AND A3.CONTI_CD = A4.CONTI_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD = A5.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A2.NEW_OP_DYS_FLG = 'Y' " ).append("\n"); 
		query.append("   AND A2.TRD_CD          = D.TRD_CD" ).append("\n"); 
		query.append("   AND A2.RLANE_CD        = D.RLANE_CD" ).append("\n"); 
		query.append("   AND A2.IOC_CD          = D.IOC_CD" ).append("\n"); 
		query.append("   AND A2.DIR_CD          = D.DIR_CD" ).append("\n"); 
		query.append("   AND A1.N1ST_LODG_PORT_ETD_DT BETWEEN A5.VSL_APLY_FM_DT(+) AND A5.VSL_APLY_TO_DT(+)" ).append("\n"); 
		query.append("#if (${f_seltrade} != '')" ).append("\n"); 
		query.append("   AND A1.TRD_CD = @[f_seltrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selrlane} != '')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD = @[f_selrlane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_seldir} != '')" ).append("\n"); 
		query.append("   AND A1.DIR_CD = @[f_seldir]" ).append("\n"); 
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
		query.append("   AND A1.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("   AND A1.SLS_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("   AND A1.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY COST_YRWK," ).append("\n"); 
		query.append("         A2.TRD_CD," ).append("\n"); 
		query.append("         A2.RLANE_CD," ).append("\n"); 
		query.append("         A2.VSL_CD," ).append("\n"); 
		query.append("         A2.SKD_VOY_NO," ).append("\n"); 
		query.append("         A2.DIR_CD," ).append("\n"); 
		query.append("         A2.CLPT_SEQ" ).append("\n"); 

	}
}