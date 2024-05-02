/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaGuidelineDBDAOSaqMonQtaOfcModMix0076CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaGuidelineDBDAOSaqMonQtaOfcModMix0076CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MON_QTA_OFC_MOD_MIX  Insert
	  * </pre>
	  */
	public MonthlyQuotaGuidelineDBDAOSaqMonQtaOfcModMix0076CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_mdl_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("target_grp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaGuidelineDBDAOSaqMonQtaOfcModMix0076CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_OFC_MOD_MIX(  " ).append("\n"); 
		query.append("            MQTA_STEP_CD        ,  " ).append("\n"); 
		query.append("            BSE_YR              ,  " ).append("\n"); 
		query.append("            BSE_QTR_CD          ,  " ).append("\n"); 
		query.append("            TRD_CD              ,  " ).append("\n"); 
		query.append("            DIR_CD              ,  " ).append("\n"); 
		query.append("            MQTA_VER_NO         ,  " ).append("\n"); 
		query.append("            RLANE_CD            ,  " ).append("\n"); 
		query.append("            SPRT_GRP_CD         ,  " ).append("\n"); 
		query.append("            BSA_GRP_CD          ,  " ).append("\n"); 
		query.append("            CTRT_RHQ_CD         ,  " ).append("\n"); 
		query.append("            BSE_MON             ,  " ).append("\n"); 
		query.append("            SAQ_SVC_MOD_CD      ,  " ).append("\n"); 
		query.append("            MOD_MIX_RTO         ,  " ).append("\n"); 
		query.append("            SUB_TRD_CD          ,  " ).append("\n"); 
		query.append("            SVC_MOD_ADJ_AVAL_FLG,  " ).append("\n"); 
		query.append("            CRE_USR_ID          ,  " ).append("\n"); 
		query.append("            CRE_DT              ,  " ).append("\n"); 
		query.append("            UPD_USR_ID          ,  " ).append("\n"); 
		query.append("            UPD_DT  )  " ).append("\n"); 
		query.append("     SELECT '01'                                                            ,  " ).append("\n"); 
		query.append("            A.BSE_YR                                                        ,  " ).append("\n"); 
		query.append("            A.BSE_QTR_CD                                                    ,  " ).append("\n"); 
		query.append("            A.TRD_CD                                                        ,  " ).append("\n"); 
		query.append("            A.DIR_CD                                                        ,  " ).append("\n"); 
		query.append("            C.MQTA_VER_NO                                                   ,  " ).append("\n"); 
		query.append("            A.RLANE_CD                                                      ,  " ).append("\n"); 
		query.append("            A.SPRT_GRP_CD                                                   ,  " ).append("\n"); 
		query.append("            A.BSA_GRP_CD                                                    ,  " ).append("\n"); 
		query.append("            A.CTRT_RHQ_CD                                                   ,  " ).append("\n"); 
		query.append("            A.BSE_MON                                                       ,  " ).append("\n"); 
		query.append("            A.SAQ_SVC_MOD_CD                                                ,  " ).append("\n"); 
		query.append("            DECODE(A.SAQ_SVC_MOD_CD,'0000',100, LOD_QTY / RHQ_LVL_LOD * 100 ), " ).append("\n"); 
		query.append("            A.SUB_TRD_CD                                                    ,  " ).append("\n"); 
		query.append("            A.SVC_MOD_ADJ_AVAL_FLG                                          ,  " ).append("\n"); 
		query.append("            @[user_id]                                                      ,  " ).append("\n"); 
		query.append("            SYSDATE                                                         ,  " ).append("\n"); 
		query.append("            @[user_id]                                                      ,  " ).append("\n"); 
		query.append("            SYSDATE  " ).append("\n"); 
		query.append("       FROM (  " ).append("\n"); 
		query.append("            SELECT  " ).append("\n"); 
		query.append("                    A.BSE_YR                ," ).append("\n"); 
		query.append("                    ADJ.BSE_QTR_CD          ," ).append("\n"); 
		query.append("                    A.TRD_CD                ," ).append("\n"); 
		query.append("                    A.DIR_CD                ," ).append("\n"); 
		query.append("                    A.RLANE_CD              ," ).append("\n"); 
		query.append("                    ADJ.SPRT_GRP_CD         ," ).append("\n"); 
		query.append("                    ADJ.BSA_GRP_CD          ," ).append("\n"); 
		query.append("                    A.CTRT_RHQ_CD           ," ).append("\n"); 
		query.append("                    A.BSE_MON               ," ).append("\n"); 
		query.append("                    A.SAQ_SVC_MOD_CD        ," ).append("\n"); 
		query.append("                    A.SUB_TRD_CD            ," ).append("\n"); 
		query.append("                    A.SVC_MOD_ADJ_AVAL_FLG  ," ).append("\n"); 
		query.append("                    SUM(A.LOD_QTY)              AS  LOD_QTY ,  " ).append("\n"); 
		query.append("                    SUM(SUM(DECODE(A.SAQ_SVC_MOD_CD,'0000',0,A.LOD_QTY)))  " ).append("\n"); 
		query.append("                    			OVER ( PARTITION BY 	  " ).append("\n"); 
		query.append("                                    				  A.BSE_YR        ," ).append("\n"); 
		query.append("                                    				  A.BSE_MON       ," ).append("\n"); 
		query.append("                                    				  A.TRD_CD        ," ).append("\n"); 
		query.append("                                    				  A.DIR_CD        ," ).append("\n"); 
		query.append("                                    				  A.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                                    				  A.RLANE_CD      ," ).append("\n"); 
		query.append("                                    				  A.CTRT_RHQ_CD   ," ).append("\n"); 
		query.append("                                    				  ADJ.SPRT_GRP_CD	," ).append("\n"); 
		query.append("                                    				  ADJ.BSA_GRP_CD   " ).append("\n"); 
		query.append("                    				   )        AS  RHQ_LVL_LOD  " ).append("\n"); 
		query.append("            FROM    SAQ_MON_INIT_MDL_SMRY   A   " ).append("\n"); 
		query.append("                   ,SAQ_TGT_GRP_TRD         B   " ).append("\n"); 
		query.append("                   ,SAQ_MON_TGT_VVD_ADJ     ADJ " ).append("\n"); 
		query.append("            WHERE    " ).append("\n"); 
		query.append("                    ADJ.BSE_YR          = @[year]  " ).append("\n"); 
		query.append("            AND     ADJ.BSE_QTR_CD      = @[bse_qtr_cd] " ).append("\n"); 
		query.append("            AND     ADJ.GLINE_VER_NO    = @[version] " ).append("\n"); 
		query.append("            AND     ADJ.TRD_CD          IN ( SELECT TRD_CD " ).append("\n"); 
		query.append("                                               FROM SAQ_TGT_GRP_TRD_V " ).append("\n"); 
		query.append("                                              WHERE SAQ_TGT_GRP_CD = @[target_grp] )  " ).append("\n"); 
		query.append("            AND     A.MQTA_MDL_VER_NO   = @[mqta_mdl_ver_no]" ).append("\n"); 
		query.append("            AND     A.TRD_CD            = B.TRD_CD          " ).append("\n"); 
		query.append("            AND     A.SUB_TRD_CD        = B.SUB_TRD_CD      " ).append("\n"); 
		query.append("            AND     A.SKD_DIR_CD        = B.DIR_CD          " ).append("\n"); 
		query.append("            AND     A.BSE_YR            = ADJ.BSE_YR        " ).append("\n"); 
		query.append("            AND     A.BSE_MON           = ADJ.BSE_MON       " ).append("\n"); 
		query.append("            AND     A.TRD_CD            = ADJ.TRD_CD        " ).append("\n"); 
		query.append("            AND     A.RLANE_CD          = ADJ.RLANE_CD      " ).append("\n"); 
		query.append("            AND     A.DIR_CD            = ADJ.DIR_CD        " ).append("\n"); 
		query.append("            AND     A.VSL_CD            = ADJ.VSL_CD        " ).append("\n"); 
		query.append("            AND     A.SKD_VOY_NO        = ADJ.SKD_VOY_NO    " ).append("\n"); 
		query.append("            AND     A.SKD_DIR_CD        = ADJ.SKD_DIR_CD    " ).append("\n"); 
		query.append("            GROUP BY  " ).append("\n"); 
		query.append("                    A.BSE_YR               ," ).append("\n"); 
		query.append("                    ADJ.BSE_QTR_CD         ," ).append("\n"); 
		query.append("                    A.TRD_CD               ," ).append("\n"); 
		query.append("                    A.SUB_TRD_CD           ," ).append("\n"); 
		query.append("                    A.DIR_CD               ," ).append("\n"); 
		query.append("                    A.RLANE_CD             ," ).append("\n"); 
		query.append("                    A.CTRT_RHQ_CD          ," ).append("\n"); 
		query.append("                    A.SVC_MOD_ADJ_AVAL_FLG ," ).append("\n"); 
		query.append("                    A.BSE_MON              ," ).append("\n"); 
		query.append("                    A.SAQ_SVC_MOD_CD       ," ).append("\n"); 
		query.append("                    ADJ.SPRT_GRP_CD        ," ).append("\n"); 
		query.append("                    ADJ.BSA_GRP_CD" ).append("\n"); 
		query.append("            ) A  " ).append("\n"); 
		query.append("            ,(  " ).append("\n"); 
		query.append("            SELECT  -- YQTA_VER_NO" ).append("\n"); 
		query.append("                    TRD_CD      ," ).append("\n"); 
		query.append("                    DIR_CD      ," ).append("\n"); 
		query.append("                    BSE_QTR_CD  ," ).append("\n"); 
		query.append("                    MAX(MQTA_VER_NO) AS MQTA_VER_NO" ).append("\n"); 
		query.append("            FROM    SAQ_MON_QTA_STEP_VER           " ).append("\n"); 
		query.append("            WHERE   MQTA_STEP_CD    = '01'         " ).append("\n"); 
		query.append("            AND     GLINE_VER_NO    = @[version]   " ).append("\n"); 
		query.append("            AND     TRD_CD          IN ( SELECT TRD_CD " ).append("\n"); 
		query.append("                                           FROM SAQ_TGT_GRP_TRD_V " ).append("\n"); 
		query.append("                                          WHERE SAQ_TGT_GRP_CD = @[target_grp] )  " ).append("\n"); 
		query.append("            AND     BSE_QTR_CD      = @[bse_qtr_cd]" ).append("\n"); 
		query.append("            GROUP BY TRD_CD, DIR_CD ,BSE_QTR_CD    " ).append("\n"); 
		query.append("            ) C  " ).append("\n"); 
		query.append("      WHERE A.TRD_CD     = C.TRD_CD " ).append("\n"); 
		query.append("        AND A.DIR_CD     = C.DIR_CD " ).append("\n"); 
		query.append("        AND A.BSE_QTR_CD = C.BSE_QTR_CD" ).append("\n"); 

	}
}