/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOBunkerTariffCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
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

public class NetworkCostDBDAOBunkerTariffCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BunkerTariffCost
	  * </pre>
	  */
	public NetworkCostDBDAOBunkerTariffCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOBunkerTariffCostRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       COST_YRMON," ).append("\n"); 
		query.append("       COST_WK," ).append("\n"); 
		query.append("       TRD_CD," ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       DIR_CD," ).append("\n"); 
		query.append("       HUL_BND_CD," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       TO_CHAR(VSL_CLSS_CAPA, 'FM99,999') AS VSL_CLSS_CAPA," ).append("\n"); 
		query.append("       NVL(DECODE(LVL,1,WK_AVG_UC_AMT,2,WK_ESTM_UC_AMT,OLD_FOIL_UC_AMT), 0) AS OLD_FOIL_UC_AMT," ).append("\n"); 
		query.append("       FOIL_UC_AMT," ).append("\n"); 
		query.append("       WK_AVG_UC_AMT," ).append("\n"); 
		query.append("       WK_ESTM_UC_AMT," ).append("\n"); 
		query.append("       COST_YRMON||TRD_CD||SUB_TRD_CD AS TRD_CD_GP," ).append("\n"); 
		query.append("       LVL," ).append("\n"); 
		query.append("       '' AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("          SELECT B1.COST_YRMON" ).append("\n"); 
		query.append("                ,B1.COST_WK" ).append("\n"); 
		query.append("                ,B1.TRD_CD" ).append("\n"); 
		query.append("                ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("                ,B1.RLANE_CD" ).append("\n"); 
		query.append("                ,B1.DIR_CD" ).append("\n"); 
		query.append("    			,B1.HUL_BND_CD" ).append("\n"); 
		query.append("    			,B1.VSL_CD" ).append("\n"); 
		query.append("                ,B1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                ,MAX(D1.OLD_FOIL_UC_AMT) AS OLD_FOIL_UC_AMT" ).append("\n"); 
		query.append("                ,MAX(D1.FOIL_UC_AMT)     AS FOIL_UC_AMT" ).append("\n"); 
		query.append("                ,MAX(D1.WK_AVG_UC_AMT)   AS WK_AVG_UC_AMT" ).append("\n"); 
		query.append("                ,MAX(D1.WK_ESTM_UC_AMT)  AS WK_ESTM_UC_AMT" ).append("\n"); 
		query.append("                ,B1.FLG1" ).append("\n"); 
		query.append("                ,B1.FLG2" ).append("\n"); 
		query.append("                ,B1.FLG3" ).append("\n"); 
		query.append("                ,GROUPING_ID(B1.RLANE_CD) + GROUPING_ID(B1.FLG1) + GROUPING_ID(B1.FLG2) + GROUPING_ID(B1.FLG3) AS LVL" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                  SELECT DISTINCT " ).append("\n"); 
		query.append("                         A1.SLS_YRMON COST_YRMON," ).append("\n"); 
		query.append("                         A1.COST_WK COST_WK," ).append("\n"); 
		query.append("                         A1.TRD_CD," ).append("\n"); 
		query.append("                         A1.SUB_TRD_CD," ).append("\n"); 
		query.append("                         A1.SLAN_CD," ).append("\n"); 
		query.append("                         A1.RLANE_CD," ).append("\n"); 
		query.append("                         A1.DIR_CD," ).append("\n"); 
		query.append("                         A1.VSL_CD," ).append("\n"); 
		query.append("    					 (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = A3.HUL_BND_CD) HUL_BND_CD," ).append("\n"); 
		query.append("                         NVL(A2.VSL_CLSS_CAPA,0) VSL_CLSS_CAPA," ).append("\n"); 
		query.append("                         ' ' AS FLG1," ).append("\n"); 
		query.append("                         '  ' AS FLG2," ).append("\n"); 
		query.append("                         '   ' AS FLG3" ).append("\n"); 
		query.append("                    FROM MAS_MON_VVD   A1," ).append("\n"); 
		query.append("                         MAS_VSL_RGST  A2," ).append("\n"); 
		query.append("                         MAS_LANE_RGST A3" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                     AND A1.TRD_CD                = A3.TRD_CD" ).append("\n"); 
		query.append("                     AND A1.RLANE_CD              = A3.RLANE_CD" ).append("\n"); 
		query.append("                     AND A1.IOC_CD                = A3.IOC_CD" ).append("\n"); 
		query.append("                     AND A1.DIR_CD                = A3.DIR_CD " ).append("\n"); 
		query.append("                     AND A3.TRD_CD               <> 'COM'" ).append("\n"); 
		query.append("                     AND A3.VSL_LANE_TP_CD       IN ('JO','SC')" ).append("\n"); 
		query.append("                     AND A1.VSL_CD                = A2.VSL_CD" ).append("\n"); 
		query.append("                     AND A1.N1ST_LODG_PORT_ETD_DT BETWEEN A2.VSL_APLY_FM_DT AND A2.VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                     AND A2.VOP_CD                = 'SML'" ).append("\n"); 
		query.append("#if(${f_yrtype} == 'yrmon')" ).append("\n"); 
		query.append("   AND A1.SLS_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_yrtype} == 'yrwk')" ).append("\n"); 
		query.append("   AND SUBSTR(A1.SLS_YRMON,1,4)||A1.COST_WK = @[f_cost_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_trd_cd} != '')" ).append("\n"); 
		query.append("   AND A1.TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_sub_trd_cd} != '')" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} != '')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_cd} != '')" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_hul_bnd_cd} != '')" ).append("\n"); 
		query.append("   AND A3.HUL_BND_CD = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     AND A1.DELT_FLG              = 'N'" ).append("\n"); 
		query.append("                     AND A2.DELT_FLG              = 'N'" ).append("\n"); 
		query.append("                     AND A3.DELT_FLG              = 'N'" ).append("\n"); 
		query.append("    				 AND A1.SUB_TRD_CD           <> 'IP' " ).append("\n"); 
		query.append("                  ) B1, MAS_BNK_TRF D1 " ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("               AND B1.COST_YRMON    = D1.COST_YRMON    (+)" ).append("\n"); 
		query.append("               AND B1.COST_WK       = D1.COST_WK       (+)" ).append("\n"); 
		query.append("               AND B1.SLAN_CD       = D1.SLAN_CD       (+)" ).append("\n"); 
		query.append("               AND B1.RLANE_CD      = D1.RLANE_CD      (+)" ).append("\n"); 
		query.append("               AND B1.DIR_CD        = D1.SLAN_DIR_CD   (+)" ).append("\n"); 
		query.append("               AND B1.VSL_CLSS_CAPA = D1.VSL_CLSS_CAPA (+)" ).append("\n"); 
		query.append("             GROUP BY GROUPING SETS(" ).append("\n"); 
		query.append("                                    (B1.COST_YRMON, B1.COST_WK, B1.TRD_CD, B1.SUB_TRD_CD, B1.RLANE_CD, B1.DIR_CD, B1.HUL_BND_CD, B1.VSL_CD, B1.VSL_CLSS_CAPA, B1.FLG1, B1.FLG2, B1.FLG3)," ).append("\n"); 
		query.append("                                    (B1.COST_YRMON, B1.TRD_CD, B1.SUB_TRD_CD, B1.FLG1, B1.FLG2, B1.FLG3)," ).append("\n"); 
		query.append("                                    (B1.COST_YRMON, B1.TRD_CD, B1.SUB_TRD_CD, B1.FLG1, B1.FLG2)," ).append("\n"); 
		query.append("                                    (B1.COST_YRMON, B1.TRD_CD, B1.SUB_TRD_CD, B1.FLG1)," ).append("\n"); 
		query.append("                                    (B1.COST_YRMON, B1.TRD_CD, B1.SUB_TRD_CD)" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY COST_YRMON," ).append("\n"); 
		query.append("       TRD_CD," ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       DIR_CD," ).append("\n"); 
		query.append("       HUL_BND_CD," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       VSL_CLSS_CAPA," ).append("\n"); 
		query.append("       COST_WK, " ).append("\n"); 
		query.append("       LVL" ).append("\n"); 

	}
}