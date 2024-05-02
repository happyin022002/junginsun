/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkDistributionDBDAOApplyToPL3CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.25 
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

public class NetworkDistributionDBDAOApplyToPL3CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApplyToPL3 INSERT
	  * </pre>
	  */
	public NetworkDistributionDBDAOApplyToPL3CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOApplyToPL3CSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_PFIT_LSS_SMRY A" ).append("\n"); 
		query.append("    USING (" ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("               B.VSL_CD                                                                     AS VSL_CD" ).append("\n"); 
		query.append("              ,B.SKD_VOY_NO                                                                 AS SKD_VOY_NO" ).append("\n"); 
		query.append("              ,B.SKD_DIR_CD                                                                 AS SKD_DIR_CD" ).append("\n"); 
		query.append("              ,B.RLANE_CD                                                                   AS RLANE_CD" ).append("\n"); 
		query.append("              ,B.TRD_CD                                                                     AS TRD_CD" ).append("\n"); 
		query.append("              ,B.IOC_CD                                                                     AS IOC_CD" ).append("\n"); 
		query.append("              ,'BSA00000'                                                                   AS STND_COST_CD" ).append("\n"); 
		query.append("              ,'XXXX'                                                                       AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,SUM(DECODE(SUBSTR(B.CNTR_TPSZ_CD, -1), '2', B.ESTM_PL_AMT, '3', B.ESTM_PL_AMT, B.ESTM_PL_AMT*2)) AS ESTM_PL_AMT /*TEU Base*/" ).append("\n"); 
		query.append("              ,0                                                                            AS RA_PL_AMT" ).append("\n"); 
		query.append("              ,0                                                                            AS ACT_PL_AMT" ).append("\n"); 
		query.append("              ,0                                                                            AS ACCL_RT_AMT" ).append("\n"); 
		query.append("              ,'LOAD to BSA'                                                                AS PL_DESC" ).append("\n"); 
		query.append("              ,'SELHO'                                                                      AS AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("              ,'SELHO'                                                                      AS SLS_OFC_CD" ).append("\n"); 
		query.append("             FROM MAS_MON_VVD        A" ).append("\n"); 
		query.append("                 ,MAS_PFIT_LSS_SMRY  B" ).append("\n"); 
		query.append("                 ,MAS_LANE_RGST      C" ).append("\n"); 
		query.append("            WHERE A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("              AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("              AND A.IOC_CD       = B.IOC_CD" ).append("\n"); 
		query.append("              AND A.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("              AND A.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND A.DIR_CD       = B.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND A.RLANE_CD     = C.RLANE_CD" ).append("\n"); 
		query.append("              AND A.DIR_CD       = C.DIR_CD" ).append("\n"); 
		query.append("              AND A.TRD_CD       = C.TRD_CD" ).append("\n"); 
		query.append("              AND A.IOC_CD       = C.IOC_CD" ).append("\n"); 
		query.append("              AND B.STND_COST_CD = 'LOAD0000'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              #if (${trd_cd} != '')" ).append("\n"); 
		query.append("                 AND A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                 AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${ioc_cd} != '')" ).append("\n"); 
		query.append("                 AND A.IOC_CD = @[ioc_cd]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                 AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("                 AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${dir_cd} != '')" ).append("\n"); 
		query.append("                 AND A.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              #if (${priod} == 'M')" ).append("\n"); 
		query.append("                  #if (${fmMonth} != '')" ).append("\n"); 
		query.append("                      AND A.COST_YRMON BETWEEN @[cost_yrmon_s] AND @[cost_yrmon_e]" ).append("\n"); 
		query.append("                  #else" ).append("\n"); 
		query.append("                      AND A.COST_YRMON LIKE @[cost_yrmon] || '%'" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("              #elseif (${priod} == 'W')" ).append("\n"); 
		query.append("                  AND A.SLS_YRMON LIKE @[sls_yrmon]" ).append("\n"); 
		query.append("                  #if (${fmWeek} != '')" ).append("\n"); 
		query.append("                      AND A.COST_WK BETWEEN @[cost_wk_s] AND @[cost_wk_e]" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              AND NVL(A.DELT_FLG       , 'N') = 'N'" ).append("\n"); 
		query.append("              AND NVL(C.LOD_SPL_CNG_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("           GROUP BY      B.VSL_CD" ).append("\n"); 
		query.append("                        ,B.SKD_VOY_NO" ).append("\n"); 
		query.append("                        ,B.SKD_DIR_CD" ).append("\n"); 
		query.append("                        ,B.RLANE_CD" ).append("\n"); 
		query.append("                        ,B.TRD_CD" ).append("\n"); 
		query.append("                        ,B.IOC_CD" ).append("\n"); 
		query.append("          ) B" ).append("\n"); 
		query.append("    ON (    A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("        AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("        AND A.IOC_CD       = B.IOC_CD" ).append("\n"); 
		query.append("        AND A.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD   = B.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("        AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    WHEN MATCHED THEN" ).append("\n"); 
		query.append("       UPDATE SET" ).append("\n"); 
		query.append("            A.ESTM_PL_AMT = B.ESTM_PL_AMT" ).append("\n"); 
		query.append("           ,A.RA_PL_AMT   = B.ESTM_PL_AMT" ).append("\n"); 
		query.append("           ,A.PL_DESC     = B.PL_DESC" ).append("\n"); 
		query.append("           ,A.UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("           ,A.UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("    WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("       INSERT(" ).append("\n"); 
		query.append("             A.VSL_CD" ).append("\n"); 
		query.append("           , A.SKD_VOY_NO" ).append("\n"); 
		query.append("           , A.SKD_DIR_CD" ).append("\n"); 
		query.append("           , A.IOC_CD" ).append("\n"); 
		query.append("           , A.RLANE_CD" ).append("\n"); 
		query.append("           , A.TRD_CD" ).append("\n"); 
		query.append("           , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           , A.STND_COST_CD" ).append("\n"); 
		query.append("           , A.ESTM_PL_AMT" ).append("\n"); 
		query.append("           , A.RA_PL_AMT" ).append("\n"); 
		query.append("           , A.ACT_PL_AMT" ).append("\n"); 
		query.append("           , A.ACCL_RT_AMT" ).append("\n"); 
		query.append("           , A.PL_DESC" ).append("\n"); 
		query.append("           , A.UPD_USR_ID" ).append("\n"); 
		query.append("           , A.UPD_DT" ).append("\n"); 
		query.append("           , A.AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("           , A.SLS_OFC_CD" ).append("\n"); 
		query.append("       )VALUES(" ).append("\n"); 
		query.append("             B.VSL_CD" ).append("\n"); 
		query.append("           , B.SKD_VOY_NO" ).append("\n"); 
		query.append("           , B.SKD_DIR_CD" ).append("\n"); 
		query.append("           , B.IOC_CD" ).append("\n"); 
		query.append("           , B.RLANE_CD" ).append("\n"); 
		query.append("           , B.TRD_CD" ).append("\n"); 
		query.append("           , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           , B.STND_COST_CD" ).append("\n"); 
		query.append("           , B.ESTM_PL_AMT" ).append("\n"); 
		query.append("           , B.ESTM_PL_AMT" ).append("\n"); 
		query.append("           , B.ACT_PL_AMT" ).append("\n"); 
		query.append("           , B.ACCL_RT_AMT" ).append("\n"); 
		query.append("           , B.PL_DESC" ).append("\n"); 
		query.append("           , @[upd_usr_id]" ).append("\n"); 
		query.append("           , SYSDATE" ).append("\n"); 
		query.append("           , B.AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("           , B.SLS_OFC_CD" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}