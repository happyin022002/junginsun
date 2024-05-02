/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkDistributionDBDAOApplyToPLOP52CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.12
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.01.12 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOApplyToPLOP52CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApplyTo PL OP5_2
	  * </pre>
	  */
	public NetworkDistributionDBDAOApplyToPLOP52CSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : NetworkDistributionDBDAOApplyToPLOP52CSQL").append("\n"); 
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
		query.append("               VSL_CD                                           AS VSL_CD" ).append("\n"); 
		query.append("              ,SKD_VOY_NO                                       AS SKD_VOY_NO" ).append("\n"); 
		query.append("              ,DIR_CD                                           AS DIR_CD" ).append("\n"); 
		query.append("              ,RLANE_CD                                         AS RLANE_CD" ).append("\n"); 
		query.append("              ,TRD_CD                                           AS TRD_CD" ).append("\n"); 
		query.append("              ,IOC_CD                                           AS IOC_CD" ).append("\n"); 
		query.append("              ,DECODE(NO,1,'BSA00000','43102011')               AS STND_COST_CD" ).append("\n"); 
		query.append("              ,'XXXX'                                           AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,SUM(DECODE(NO,1,FNL_HJS_BSA_CAPA,SPC_INCOME))    AS ESTM_PL_AMT" ).append("\n"); 
		query.append("              ,0                                                AS RA_PL_AMT" ).append("\n"); 
		query.append("              ,0                                                AS ACT_PL_AMT" ).append("\n"); 
		query.append("              ,0                                                AS ACCL_RT_AMT" ).append("\n"); 
		query.append("              ,'X'                                              AS PL_DESC" ).append("\n"); 
		query.append("              ,'SELHO'                                          AS AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("              ,'SELHO'                                          AS SLS_OFC_CD" ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("                   SELECT" ).append("\n"); 
		query.append("                       A.VSL_CD                                                                         AS VSL_CD" ).append("\n"); 
		query.append("                      ,A.SKD_VOY_NO                                                                     AS SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,A.DIR_CD                                                                         AS DIR_CD" ).append("\n"); 
		query.append("                      ,A.RLANE_CD                                                                       AS RLANE_CD" ).append("\n"); 
		query.append("                      ,A.TRD_CD                                                                         AS TRD_CD" ).append("\n"); 
		query.append("                      ,A.IOC_CD                                                                         AS IOC_CD" ).append("\n"); 
		query.append("                      ,B.FNL_HJS_BSA_CAPA                                                               AS FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("                      ,nvl(B.INCM_BZC_CHTR_AMT,0)+nvl(B.INCM_SUB_CHTR_AMT,0)+nvl(B.INCM_CRS_CHTR_AMT,0) AS SPC_INCOME" ).append("\n"); 
		query.append("                     FROM MAS_MON_VVD A" ).append("\n"); 
		query.append("                         ,BSA_VVD_MST B" ).append("\n"); 
		query.append("                    WHERE A.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("                      AND A.SKD_VOY_NO  = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND A.DIR_CD      = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND A.TRD_CD      = B.TRD_CD" ).append("\n"); 
		query.append("                      AND A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("                      AND A.IOC_CD      = B.IOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      #if (${trd_cd} != '')" ).append("\n"); 
		query.append("                         AND A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                         AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${ioc_cd} != '')" ).append("\n"); 
		query.append("                         AND A.IOC_CD = @[ioc_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                         AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("                         AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${dir_cd} != '')" ).append("\n"); 
		query.append("                         AND A.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      #if (${priod} == 'M')" ).append("\n"); 
		query.append("                          #if (${fmMonth} != '')" ).append("\n"); 
		query.append("                              AND A.COST_YRMON BETWEEN @[cost_yrmon_s] AND @[cost_yrmon_e]" ).append("\n"); 
		query.append("                          #else" ).append("\n"); 
		query.append("                              AND A.COST_YRMON LIKE @[cost_yrmon] || '%'" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                      #elseif (${priod} == 'W')" ).append("\n"); 
		query.append("                          AND A.SLS_YRMON LIKE @[sls_yrmon]" ).append("\n"); 
		query.append("                          #if (${fmWeek} != '')" ).append("\n"); 
		query.append("                              AND A.COST_WK BETWEEN @[cost_wk_s] AND @[cost_wk_e]" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                 ,(SELECT CPY_NO NO" ).append("\n"); 
		query.append("                     FROM COM_CPY_NO" ).append("\n"); 
		query.append("                    WHERE CPY_NO BETWEEN 1 AND 2)" ).append("\n"); 
		query.append("           GROUP BY" ).append("\n"); 
		query.append("                 VSL_CD" ).append("\n"); 
		query.append("                ,SKD_VOY_NO" ).append("\n"); 
		query.append("                ,DIR_CD" ).append("\n"); 
		query.append("                ,RLANE_CD" ).append("\n"); 
		query.append("                ,TRD_CD" ).append("\n"); 
		query.append("                ,IOC_CD" ).append("\n"); 
		query.append("                ,DECODE(NO,1,'BSA00000','43102011')" ).append("\n"); 
		query.append("          ) B" ).append("\n"); 
		query.append("    ON (    A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("        AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("        AND A.IOC_CD       = B.IOC_CD" ).append("\n"); 
		query.append("        AND A.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("        AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("        AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    WHEN MATCHED THEN" ).append("\n"); 
		query.append("       UPDATE" ).append("\n"); 
		query.append("          SET A.N5TH_ESTM_PL_AMT = B.ESTM_PL_AMT" ).append("\n"); 
		query.append("           --  ,A.RA_PL_AMT   = DECODE(B.STND_COST_CD,'43102011',0,B.ESTM_PL_AMT)" ).append("\n"); 
		query.append("             ,A.UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("             ,A.N5TH_HJS_SLS_AMT = 0" ).append("\n"); 
		query.append("             ,A.N5TH_CO_AMT  = B.ESTM_PL_AMT" ).append("\n"); 
		query.append("             ,A.UPD_DT      = SYSDATE" ).append("\n"); 
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
		query.append("           , A.N5TH_ESTM_PL_AMT" ).append("\n"); 
		query.append("           , A.RA_PL_AMT" ).append("\n"); 
		query.append("           , A.ACT_PL_AMT" ).append("\n"); 
		query.append("           , A.ACCL_RT_AMT" ).append("\n"); 
		query.append("           , A.PL_DESC" ).append("\n"); 
		query.append("           , A.AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("           , A.SLS_OFC_CD" ).append("\n"); 
		query.append("           , A.N5TH_HJS_SLS_AMT" ).append("\n"); 
		query.append("           , A.N5TH_CO_AMT" ).append("\n"); 
		query.append("           , A.CRE_USR_ID" ).append("\n"); 
		query.append("           , A.CRE_DT" ).append("\n"); 
		query.append("           , A.UPD_USR_ID" ).append("\n"); 
		query.append("           , A.UPD_DT" ).append("\n"); 
		query.append("       )VALUES(" ).append("\n"); 
		query.append("             B.VSL_CD" ).append("\n"); 
		query.append("           , B.SKD_VOY_NO" ).append("\n"); 
		query.append("           , B.DIR_CD" ).append("\n"); 
		query.append("           , B.IOC_CD" ).append("\n"); 
		query.append("           , B.RLANE_CD" ).append("\n"); 
		query.append("           , B.TRD_CD" ).append("\n"); 
		query.append("           , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           , B.STND_COST_CD" ).append("\n"); 
		query.append("           , B.ESTM_PL_AMT" ).append("\n"); 
		query.append("           , DECODE(B.STND_COST_CD,'43102011',0,B.ESTM_PL_AMT)" ).append("\n"); 
		query.append("           , B.ACT_PL_AMT" ).append("\n"); 
		query.append("           , B.ACCL_RT_AMT" ).append("\n"); 
		query.append("           , B.PL_DESC" ).append("\n"); 
		query.append("           , B.AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("           , B.SLS_OFC_CD" ).append("\n"); 
		query.append("           , 0" ).append("\n"); 
		query.append("           , B.ESTM_PL_AMT" ).append("\n"); 
		query.append("           , @[cre_usr_id]" ).append("\n"); 
		query.append("           , SYSDATE" ).append("\n"); 
		query.append("           , @[upd_usr_id]" ).append("\n"); 
		query.append("           , SYSDATE" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}