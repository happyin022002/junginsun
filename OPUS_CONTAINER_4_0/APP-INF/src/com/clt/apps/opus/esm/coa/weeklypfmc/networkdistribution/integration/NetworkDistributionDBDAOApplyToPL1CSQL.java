/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkDistributionDBDAOApplyToPL1CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.27
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2011.02.27 전윤주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun-ju Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOApplyToPL1CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApplyToPL1 INSERT
	  * </pre>
	  */
	public NetworkDistributionDBDAOApplyToPL1CSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOApplyToPL1CSQL").append("\n"); 
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
		query.append("MERGE INTO COA_PFIT_LSS_SMRY A" ).append("\n"); 
		query.append("     USING (SELECT" ).append("\n"); 
		query.append("                VSL_CD                                                                                                  AS VSL_CD" ).append("\n"); 
		query.append("               ,SKD_VOY_NO                                                                                              AS SKD_VOY_NO" ).append("\n"); 
		query.append("               ,DIR_CD                                                                                                  AS DIR_CD" ).append("\n"); 
		query.append("               ,IOC_CD                                                                                                  AS IOC_CD" ).append("\n"); 
		query.append("               ,RLANE_CD                                                                                                AS RLANE_CD" ).append("\n"); 
		query.append("               ,TRD_CD                                                                                                  AS TRD_CD" ).append("\n"); 
		query.append("               ,CNTR_TPSZ_CD                                                                                            AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               ,DECODE(NO,1,STND_COST_CD,2,'TSCTRB00', 3,'CMMT0000',4,'COMAMT00',5,'CHTOUT00','INTTRDTS')               AS STND_COST_CD" ).append("\n"); 
		query.append("               ,SUM(DECODE(NO,1,ESTM_PL_AMT,2,TS_CTRB_BSE_COST_AMT,3,EXTERNAL_TS,4,CO_SLS_AMT,5,CO_AMT,INTERNAL_TS))   AS ESTM_PL_AMT" ).append("\n"); 
		query.append("               ,0                                                                                                       AS RA_PL_AMT" ).append("\n"); 
		query.append("               ,0                                                                                                       AS ACT_PL_AMT" ).append("\n"); 
		query.append("               ,0                                                                                                       AS ACCL_RT_AMT" ).append("\n"); 
		query.append("               ,'X'                                                                                                     AS PL_DESC" ).append("\n"); 
		query.append("               ,COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()                                                         AS AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("               ,COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()                                                         AS SLS_OFC_CD" ).append("\n"); 
		query.append("               ,SUM(DECODE(NO,1,CO_SLS_AMT2,0))                                                                        AS CO_SLS_AMT2  /*COMPANY 비율 금액*/" ).append("\n"); 
		query.append("               ,SUM(DECODE(NO,1,CO_AMT,0))                                                                              AS CO_AMT" ).append("\n"); 
		query.append("              FROM (SELECT" ).append("\n"); 
		query.append("                         VSL_CD                        VSL_CD" ).append("\n"); 
		query.append("                        ,SKD_VOY_NO                    SKD_VOY_NO" ).append("\n"); 
		query.append("                        ,DIR_CD                        DIR_CD" ).append("\n"); 
		query.append("                        ,IOC_CD                        IOC_CD" ).append("\n"); 
		query.append("                        ,RLANE_CD                      RLANE_CD" ).append("\n"); 
		query.append("                        ,TRD_CD                        TRD_CD" ).append("\n"); 
		query.append("                        ,CNTR_TPSZ_CD                  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                        ,STND_COST_CD                  STND_COST_CD" ).append("\n"); 
		query.append("                        ,SUM(ESTM_PL_AMT)              ESTM_PL_AMT" ).append("\n"); 
		query.append("                        ,SUM(TS_CTRB_BSE_COST_AMT)     TS_CTRB_BSE_COST_AMT" ).append("\n"); 
		query.append("                        ,SUM(CMMT_BSE_COST_AMT)        CMMT_BSE_COST_AMT" ).append("\n"); 
		query.append("                        ,SUM(CO_SLS_AMT)              CO_SLS_AMT" ).append("\n"); 
		query.append("                        ,SUM(CO_SLS_AMT2)             CO_SLS_AMT2    /*COMPANY 비율 금액*/" ).append("\n"); 
		query.append("                        ,SUM(CO_AMT)                   CO_AMT          /*CHT OUT비율 금액*/" ).append("\n"); 
		query.append("                        ,SUM(INTERNAL_TS)              INTERNAL_TS" ).append("\n"); 
		query.append("                        ,SUM(EXTERNAL_TS)              EXTERNAL_TS" ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                            SELECT" ).append("\n"); 
		query.append("                                 A.VSL_CD                                                                                  AS VSL_CD" ).append("\n"); 
		query.append("                                ,A.SKD_VOY_NO                                                                              AS SKD_VOY_NO" ).append("\n"); 
		query.append("                                ,A.DIR_CD                                                                                  AS DIR_CD" ).append("\n"); 
		query.append("                                ,A.IOC_CD                                                                                  AS IOC_CD" ).append("\n"); 
		query.append("                                ,A.RLANE_CD                                                                                AS RLANE_CD" ).append("\n"); 
		query.append("                                ,A.TRD_CD                                                                                  AS TRD_CD" ).append("\n"); 
		query.append("                                ,'XXXX'                                                                                    AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                ,B.STND_COST_CD                                                                            AS STND_COST_CD" ).append("\n"); 
		query.append("                                ,NVL(B.CO_SLS_AMT, 0) + NVL(B.N1ST_ASGN_AMT, 0) + NVL(B.IPT_ASGN_AMT, 0)+NVL(B.CO_AMT,0)  AS ESTM_PL_AMT" ).append("\n"); 
		query.append("                                ,NVL(B.TS_CTRB_BSE_COST_AMT,0)                                                             AS TS_CTRB_BSE_COST_AMT" ).append("\n"); 
		query.append("                                ,NVL(B.CMMT_BSE_COST_AMT,0)                                                                AS CMMT_BSE_COST_AMT" ).append("\n"); 
		query.append("                                ,NVL(B.CO_SLS_AMT,0) + NVL(B.IPT_ASGN_AMT, 0)                                             AS CO_SLS_AMT" ).append("\n"); 
		query.append("                                ,NVL(B.CO_SLS_AMT, 0) + NVL(B.N1ST_ASGN_AMT, 0) + NVL(B.IPT_ASGN_AMT, 0)                  AS CO_SLS_AMT2     /*COMPANY 비율 금액*/" ).append("\n"); 
		query.append("                                ,NVL(B.CO_AMT,0)                                                                           AS CO_AMT" ).append("\n"); 
		query.append("                                ,CASE WHEN (A.TRD_CD = 'IAS') THEN B.TS_ASGN_AMT ELSE 0 END                                AS INTERNAL_TS" ).append("\n"); 
		query.append("                                ,CASE WHEN (A.TRD_CD <> 'IAS') THEN B.TS_ASGN_AMT ELSE 0 END                               AS EXTERNAL_TS" ).append("\n"); 
		query.append("                              FROM COA_MON_VVD A" ).append("\n"); 
		query.append("                                 , COA_VVD_HIR B" ).append("\n"); 
		query.append("                             WHERE A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                               AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND A.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("                               AND A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("                               AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("                               AND A.IOC_CD     = B.IOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                               #if (${trd_cd} != '')" ).append("\n"); 
		query.append("                                  AND A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                               #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                                  AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                               #if (${ioc_cd} != '')" ).append("\n"); 
		query.append("                                  AND A.IOC_CD = @[ioc_cd]" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                               #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                                  AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                               #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("                                  AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                               #if (${dir_cd} != '')" ).append("\n"); 
		query.append("                                  AND A.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                               #if (${priod} == 'M')" ).append("\n"); 
		query.append("                                   #if (${fmMonth} != '')" ).append("\n"); 
		query.append("                                       AND A.COST_YRMON BETWEEN @[cost_yrmon_s] AND @[cost_yrmon_e]" ).append("\n"); 
		query.append("                                   #else" ).append("\n"); 
		query.append("                                       AND A.COST_YRMON LIKE @[cost_yrmon] || '%'" ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                               #elseif (${priod} == 'W')" ).append("\n"); 
		query.append("                                   AND A.SLS_YRMON LIKE @[sls_yrmon]" ).append("\n"); 
		query.append("                                   #if (${fmWeek} != '')" ).append("\n"); 
		query.append("                                       AND A.COST_WK BETWEEN @[cost_wk_s] AND @[cost_wk_e]" ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                               AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                         GROUP BY VSL_CD" ).append("\n"); 
		query.append("                                 ,SKD_VOY_NO" ).append("\n"); 
		query.append("                                 ,DIR_CD" ).append("\n"); 
		query.append("                                 ,IOC_CD" ).append("\n"); 
		query.append("                                 ,RLANE_CD" ).append("\n"); 
		query.append("                                 ,TRD_CD" ).append("\n"); 
		query.append("                                 ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                 ,STND_COST_CD" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                 ,(SELECT CPY_NO NO" ).append("\n"); 
		query.append("                     FROM COM_CPY_NO" ).append("\n"); 
		query.append("                    WHERE CPY_NO BETWEEN 1 AND 6)" ).append("\n"); 
		query.append("           GROUP BY" ).append("\n"); 
		query.append("               VSL_CD" ).append("\n"); 
		query.append("              ,SKD_VOY_NO" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,IOC_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,TRD_CD" ).append("\n"); 
		query.append("              ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,DECODE(NO,1,STND_COST_CD,2,'TSCTRB00', 3,'CMMT0000',4,'COMAMT00',5,'CHTOUT00','INTTRDTS')" ).append("\n"); 
		query.append("          ) B" ).append("\n"); 
		query.append("     ON (    A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("         AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("         AND A.IOC_CD       = B.IOC_CD" ).append("\n"); 
		query.append("         AND A.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("         AND A.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND A.SKD_DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("         AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("         AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("     WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE" ).append("\n"); 
		query.append("           SET A.ESTM_PL_AMT  = B.ESTM_PL_AMT" ).append("\n"); 
		query.append("              ,A.UPD_USR_ID   = @[upd_usr_id]" ).append("\n"); 
		query.append("              ,A.UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("              ,A.CO_SLS_AMT  = B.CO_SLS_AMT2" ).append("\n"); 
		query.append("              ,A.CO_AMT       = B.CO_AMT" ).append("\n"); 
		query.append("     WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT(" ).append("\n"); 
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
		query.append("           , A.AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("           , A.SLS_OFC_CD" ).append("\n"); 
		query.append("           , A.CO_SLS_AMT" ).append("\n"); 
		query.append("           , A.CO_AMT" ).append("\n"); 
		query.append("           , A.CRE_USR_ID" ).append("\n"); 
		query.append("           , A.CRE_DT" ).append("\n"); 
		query.append("           , A.UPD_USR_ID" ).append("\n"); 
		query.append("           , A.UPD_DT" ).append("\n"); 
		query.append("        )VALUES(" ).append("\n"); 
		query.append("             B.VSL_CD" ).append("\n"); 
		query.append("           , B.SKD_VOY_NO" ).append("\n"); 
		query.append("           , B.DIR_CD" ).append("\n"); 
		query.append("           , B.IOC_CD" ).append("\n"); 
		query.append("           , B.RLANE_CD" ).append("\n"); 
		query.append("           , B.TRD_CD" ).append("\n"); 
		query.append("           , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           , B.STND_COST_CD" ).append("\n"); 
		query.append("           , B.ESTM_PL_AMT" ).append("\n"); 
		query.append("           , B.RA_PL_AMT" ).append("\n"); 
		query.append("           , B.ACT_PL_AMT" ).append("\n"); 
		query.append("           , B.ACCL_RT_AMT" ).append("\n"); 
		query.append("           , B.PL_DESC" ).append("\n"); 
		query.append("           , B.AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("           , B.SLS_OFC_CD" ).append("\n"); 
		query.append("           , B.CO_SLS_AMT2" ).append("\n"); 
		query.append("           , B.CO_AMT" ).append("\n"); 
		query.append("           , @[cre_usr_id]" ).append("\n"); 
		query.append("           , SYSDATE" ).append("\n"); 
		query.append("           , @[upd_usr_id]" ).append("\n"); 
		query.append("           , SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}