/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkDistributionDBDAOApplyToPLOP62CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.01.20 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOApplyToPLOP62CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApplyTo PL OP6_2
	  * </pre>
	  */
	public NetworkDistributionDBDAOApplyToPLOP62CSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOApplyToPLOP62CSQL").append("\n"); 
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
		query.append("MERGE INTO COA_PFIT_LSS_SMRY A USING" ).append("\n"); 
		query.append("(SELECT VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , IOC_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , OP_LANE_TP_CD" ).append("\n"); 
		query.append("      , DECODE(NO, 1, STND_COST_CD, 2, 'TSCTRB00', 3, 'CMMT0000', 4, 'HJSAMT00', 5, 'CHTOUT00', 'INTTRDTS') STND_COST_CD" ).append("\n"); 
		query.append("      , SUM(DECODE(NO, 1, ESTM_PL_AMT, 2, TS_CTRB_BSE_COST_AMT, 3, EXTERNAL_TS, 4, HJS_SLS_AMT, 5, CO_AMT, INTERNAL_TS)) ESTM_PL_AMT" ).append("\n"); 
		query.append("      , 'SELHO' AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("      , 'SELHO' SLS_OFC_CD" ).append("\n"); 
		query.append("      , SUM(DECODE(NO, 1, HJS_SLS_AMT2, 0)) HJS_SLS_AMT2" ).append("\n"); 
		query.append("        /* HJS비율 금액 */" ).append("\n"); 
		query.append("      , SUM(DECODE(NO, 1, CO_AMT, 0)) CO_AMT" ).append("\n"); 
		query.append("      , SUM(DECODE(NO,1,N6TH_ASGN_AMT,0))          AS N6TH_ASGN_AMT" ).append("\n"); 
		query.append("      , SUM(DECODE(NO,1,N6TH_ADJ_OTR_FNL_AMT,0))   AS N6TH_ADJ_OTR_FNL_AMT" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (SELECT VSL_CD" ).append("\n"); 
		query.append("              , SKD_VOY_NO" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , IOC_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , STND_COST_CD" ).append("\n"); 
		query.append("              , OP_LANE_TP_CD" ).append("\n"); 
		query.append("              , SUM(ESTM_PL_AMT) ESTM_PL_AMT" ).append("\n"); 
		query.append("              , SUM(TS_CTRB_BSE_COST_AMT) TS_CTRB_BSE_COST_AMT" ).append("\n"); 
		query.append("              , SUM(CMMT_BSE_COST_AMT) CMMT_BSE_COST_AMT" ).append("\n"); 
		query.append("              , SUM(HJS_SLS_AMT) HJS_SLS_AMT" ).append("\n"); 
		query.append("              , SUM(HJS_SLS_AMT2) HJS_SLS_AMT2" ).append("\n"); 
		query.append("                /* HJS비율 금액    */" ).append("\n"); 
		query.append("              , SUM(CO_AMT) CO_AMT" ).append("\n"); 
		query.append("                /* CHT OUT비율 금액     */" ).append("\n"); 
		query.append("              , SUM(INTERNAL_TS) INTERNAL_TS" ).append("\n"); 
		query.append("              , SUM(EXTERNAL_TS) EXTERNAL_TS" ).append("\n"); 
		query.append("              , SUM(N6TH_ASGN_AMT)             N6TH_ASGN_AMT" ).append("\n"); 
		query.append("              , SUM(N6TH_ADJ_OTR_FNL_AMT)      N6TH_ADJ_OTR_FNL_AMT" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("                (SELECT A.VSL_CD" ).append("\n"); 
		query.append("                      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A.DIR_CD" ).append("\n"); 
		query.append("                      , A.IOC_CD" ).append("\n"); 
		query.append("                      , A.RLANE_CD" ).append("\n"); 
		query.append("                      , A.TRD_CD" ).append("\n"); 
		query.append("                      , 'XXXX' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      , B.STND_COST_CD" ).append("\n"); 
		query.append("                      , CASE WHEN A.TRD_CD IN ('IAS','IES','IMS') AND B.STND_COST_CD <> '43102011' THEN NVL(B.N6TH_ASGN_AMT, 0) + NVL(B.IPT_ASGN_AMT, 0)+NVL(B.N4TH_CO_AMT, 0)" ).append("\n"); 
		query.append("							 ELSE NVL(B.N4TH_HJS_SLS_AMT, 0) + NVL(B.N6TH_ASGN_AMT, 0) + NVL(B.IPT_ASGN_AMT, 0)+NVL(B.N4TH_CO_AMT, 0) END AS ESTM_PL_AMT" ).append("\n"); 
		query.append("                      , NVL(B.TS_CTRB_BSE_COST_AMT, 0) TS_CTRB_BSE_COST_AMT" ).append("\n"); 
		query.append("                      , NVL(B.CMMT_BSE_COST_AMT, 0) CMMT_BSE_COST_AMT" ).append("\n"); 
		query.append("                      , NVL(B.N4TH_HJS_SLS_AMT, 0) + NVL(B.IPT_ASGN_AMT, 0) HJS_SLS_AMT" ).append("\n"); 
		query.append("                      , CASE WHEN A.TRD_CD IN ('IAS','IES','IMS') AND B.STND_COST_CD <> '43102011' THEN NVL(B.N6TH_ASGN_AMT, 0) + NVL(B.IPT_ASGN_AMT, 0)" ).append("\n"); 
		query.append("							 ELSE NVL(B.N4TH_HJS_SLS_AMT, 0) + NVL(B.N6TH_ASGN_AMT, 0) + NVL(B.IPT_ASGN_AMT, 0) END AS HJS_SLS_AMT2" ).append("\n"); 
		query.append("                        /* HJS비율 금액  */" ).append("\n"); 
		query.append("                      , NVL(B.N4TH_CO_AMT, 0) CO_AMT" ).append("\n"); 
		query.append("                      , CASE WHEN (A.TRD_CD = 'IAS') THEN B.N5TH_ASGN_AMT ELSE 0 END INTERNAL_TS" ).append("\n"); 
		query.append("                      , CASE WHEN (A.TRD_CD <> 'IAS') THEN B.N5TH_ASGN_AMT ELSE 0 END EXTERNAL_TS" ).append("\n"); 
		query.append("                      , NVL(C.OP_LANE_TP_CD, 'OT') OP_LANE_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					  /* Allocation Results (Commitment Base)에서의 1st TS Alloc.의 계산로직은  (N6TH_ASGN_AMT-N4TH_HJS_SLS_AMT) 임 */" ).append("\n"); 
		query.append("                      , CASE WHEN A.TRD_CD IN ('IAS','IES','IMS') AND B.STND_COST_CD <> '43102011' THEN NVL(B.N6TH_ASGN_AMT, 0) - NVL(B.N4TH_HJS_SLS_AMT, 0) " ).append("\n"); 
		query.append("							 ELSE NVL(B.N6TH_ASGN_AMT, 0) END AS N6TH_ASGN_AMT " ).append("\n"); 
		query.append("                      , NVL(B.N6TH_ADJ_OTR_FNL_AMT, 0)  AS N6TH_ADJ_OTR_FNL_AMT" ).append("\n"); 
		query.append("                   FROM COA_MON_VVD A" ).append("\n"); 
		query.append("                      , COA_VVD_HIR B" ).append("\n"); 
		query.append("                      , COA_LANE_RGST C" ).append("\n"); 
		query.append("                  WHERE A.VSL_CD                                         = B.VSL_CD" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO                                     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND A.DIR_CD                                         = B.DIR_CD" ).append("\n"); 
		query.append("                    AND A.TRD_CD                                         = B.TRD_CD" ).append("\n"); 
		query.append("                    AND A.RLANE_CD                                       = B.RLANE_CD" ).append("\n"); 
		query.append("                    AND A.IOC_CD                                         = B.IOC_CD" ).append("\n"); 
		query.append("                    AND A.RLANE_CD                                       = C.RLANE_CD" ).append("\n"); 
		query.append("                    AND A.DIR_CD                                         = C.DIR_CD" ).append("\n"); 
		query.append("                    AND A.TRD_CD                                         = C.TRD_CD" ).append("\n"); 
		query.append("                    AND A.IOC_CD                                         = C.IOC_CD" ).append("\n"); 
		query.append("                    AND (B.STND_COST_CD||NVL(C.OP_LANE_TP_CD, 'OT') NOT IN('43102011OT')) --단독운항인 노선의  SPACE CHARTER REVENUE계정 제외" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("                    AND A.TRD_CD                                         = @[trd_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                    AND A.RLANE_CD                                       = @[rlane_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${ioc_cd} != '')" ).append("\n"); 
		query.append("                    AND A.IOC_CD                                         = @[ioc_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                    AND A.VSL_CD                                         = @[vsl_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO                                     = @[skd_voy_no] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("                    AND A.DIR_CD                                         = @[dir_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${priod} == 'M') " ).append("\n"); 
		query.append("    #if (${fmMonth} != '')" ).append("\n"); 
		query.append("                    AND A.COST_YRMON BETWEEN @[cost_yrmon_s] AND @[cost_yrmon_e] " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                    AND A.COST_YRMON LIKE @[cost_yrmon] || '%' " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#elseif (${priod} == 'W')" ).append("\n"); 
		query.append("                    AND A.SLS_YRMON LIKE @[sls_yrmon] " ).append("\n"); 
		query.append("    #if (${fmWeek} != '')" ).append("\n"); 
		query.append("                    AND A.COST_WK BETWEEN @[cost_wk_s] AND @[cost_wk_e] " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("       GROUP BY VSL_CD" ).append("\n"); 
		query.append("              , SKD_VOY_NO" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , IOC_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , STND_COST_CD" ).append("\n"); 
		query.append("              , OP_LANE_TP_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("      , (SELECT CPY_NO NO" ).append("\n"); 
		query.append("           FROM COM_CPY_NO" ).append("\n"); 
		query.append("          WHERE CPY_NO IN(1, 4, 5)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , IOC_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , OP_LANE_TP_CD" ).append("\n"); 
		query.append("      , DECODE(NO, 1, STND_COST_CD, 2, 'TSCTRB00', 3, 'CMMT0000', 4, 'HJSAMT00', 5, 'CHTOUT00', 'INTTRDTS')" ).append("\n"); 
		query.append(") B ON ( A.TRD_CD = B.TRD_CD " ).append("\n"); 
		query.append("   AND A.RLANE_CD = B.RLANE_CD " ).append("\n"); 
		query.append("   AND A.IOC_CD = B.IOC_CD " ).append("\n"); 
		query.append("   AND A.VSL_CD = B.VSL_CD " ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = B.SKD_VOY_NO " ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = B.DIR_CD " ).append("\n"); 
		query.append("   AND A.STND_COST_CD = B.STND_COST_CD " ).append("\n"); 
		query.append("   AND A.AGMT_SGN_OFC_CD = 'SELHO'" ).append("\n"); 
		query.append("   AND A.SLS_OFC_CD = 'SELHO'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("         UPDATE" ).append("\n"); 
		query.append("        SET A.N6TH_ESTM_PL_AMT     = B.ESTM_PL_AMT" ).append("\n"); 
		query.append("              , A.N6TH_HJS_SLS_AMT = B.HJS_SLS_AMT2" ).append("\n"); 
		query.append("              , A.N6TH_CO_AMT      = B.CO_AMT" ).append("\n"); 
		query.append("              , A.N6TH_ADJ_OTR_FNL_AMT = B.N6TH_ADJ_OTR_FNL_AMT" ).append("\n"); 
		query.append("              , A.UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append("              , A.UPD_DT           = SYSDATE " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("         INSERT" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        A.VSL_CD" ).append("\n"); 
		query.append("                      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                      , A.IOC_CD" ).append("\n"); 
		query.append("                      , A.RLANE_CD" ).append("\n"); 
		query.append("                      , A.TRD_CD" ).append("\n"); 
		query.append("                      , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      , A.STND_COST_CD" ).append("\n"); 
		query.append("                      , A.N6TH_ESTM_PL_AMT" ).append("\n"); 
		query.append("                      , A.UPD_USR_ID" ).append("\n"); 
		query.append("                      , A.UPD_DT" ).append("\n"); 
		query.append("                      , A.AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("                      , A.SLS_OFC_CD" ).append("\n"); 
		query.append("                      , A.N6TH_HJS_SLS_AMT" ).append("\n"); 
		query.append("                      , A.N6TH_CO_AMT" ).append("\n"); 
		query.append("                      , A.OP_LANE_TP_CD" ).append("\n"); 
		query.append("                      , A.CRE_USR_ID" ).append("\n"); 
		query.append("                      , A.CRE_DT" ).append("\n"); 
		query.append("                      , A.N6TH_ADJ_OTR_FNL_AMT" ).append("\n"); 
		query.append("                      , A.N6TH_ASGN_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                VALUES" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        B.VSL_CD" ).append("\n"); 
		query.append("                      , B.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , B.DIR_CD" ).append("\n"); 
		query.append("                      , B.IOC_CD" ).append("\n"); 
		query.append("                      , B.RLANE_CD" ).append("\n"); 
		query.append("                      , B.TRD_CD" ).append("\n"); 
		query.append("                      , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      , B.STND_COST_CD" ).append("\n"); 
		query.append("                      , B.ESTM_PL_AMT" ).append("\n"); 
		query.append("                      , @[upd_usr_id]" ).append("\n"); 
		query.append("                      , SYSDATE" ).append("\n"); 
		query.append("                      , B.AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("                      , B.SLS_OFC_CD" ).append("\n"); 
		query.append("                      , B.HJS_SLS_AMT2" ).append("\n"); 
		query.append("                      , B.CO_AMT" ).append("\n"); 
		query.append("                      , B.OP_LANE_TP_CD" ).append("\n"); 
		query.append("                      , @[upd_usr_id]" ).append("\n"); 
		query.append("                      , SYSDATE" ).append("\n"); 
		query.append("                      , B.N6TH_ADJ_OTR_FNL_AMT" ).append("\n"); 
		query.append("                      , B.N6TH_ASGN_AMT" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}