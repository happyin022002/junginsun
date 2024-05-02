/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SDAnalysisReportDBDAOSearchSDAnalysisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.01
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.01 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SDAnalysisReportDBDAOSearchSDAnalysisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SD Analysis Report 데이터를 조회한다
	  * </pre>
	  */
	public SDAnalysisReportDBDAOSearchSDAnalysisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sd_gp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_to_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_from_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_from_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.integration").append("\n"); 
		query.append("FileName : SDAnalysisReportDBDAOSearchSDAnalysisRSQL").append("\n"); 
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
		query.append("SELECT B.EG_RHQ_CD" ).append("\n"); 
		query.append("     , B.EG_OFC_CD" ).append("\n"); 
		query.append("     , B.EV_SVC_CATE_CD" ).append("\n"); 
		query.append("     , B.EG_ID" ).append("\n"); 
		query.append("     , B.EG_NM" ).append("\n"); 
		query.append("     , A.EV_YR" ).append("\n"); 
		query.append("     , A.SP_SEQ" ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.SP_SEQ) AS SP_NAME" ).append("\n"); 
		query.append("     , PA_POINT" ).append("\n"); 
		query.append("     , CASE WHEN PA_POINT< 80 THEN 'Poor'" ).append("\n"); 
		query.append("            WHEN PA_POINT >= 80 AND PA_POINT<95   THEN 'Good' " ).append("\n"); 
		query.append("            WHEN PA_POINT >= 95 THEN 'Excellent' " ).append("\n"); 
		query.append("            ELSE '' END AS PA_GROUP" ).append("\n"); 
		query.append("      , C.BZC_EV_GRD_CD" ).append("\n"); 
		query.append("      , E.BZC_EV_GRD_NM AS BE_GROUP" ).append("\n"); 
		query.append("      , E.BZC_EV_GRD_VAL AS BE_POINT" ).append("\n"); 
		query.append("      , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID ='CD03397'" ).append("\n"); 
		query.append("            AND INTG_CD_VAL_CTNT=D.SP_DIFF_GRD_CD" ).append("\n"); 
		query.append("         ) AS SD_GROUP" ).append("\n"); 
		query.append("  FROM (SELECT EG_ID" ).append("\n"); 
		query.append("             , SP_SEQ" ).append("\n"); 
		query.append("             , EV_YR" ).append("\n"); 
		query.append("             , SUM(PA_POINT) AS PA_POINT" ).append("\n"); 
		query.append("         FROM (SELECT EG_ID" ).append("\n"); 
		query.append("                    , SP_SEQ" ).append("\n"); 
		query.append("                    , EV_YR" ).append("\n"); 
		query.append("                    , ROUND(SUM(PA_POINT)/COUNT(1),2) AS PA_POINT" ).append("\n"); 
		query.append("               FROM  (SELECT EG_ID" ).append("\n"); 
		query.append("                           , SP_SEQ" ).append("\n"); 
		query.append("                           , EV_YR" ).append("\n"); 
		query.append("                           , SP_KPI_ID" ).append("\n"); 
		query.append("                           , CASE WHEN KPI_WGT_RTO < ROUND((SUM(MON_SCORE)*KPI_WGT_RTO)/KPI_TGT_RTO,2) THEN KPI_WGT_RTO ELSE ROUND((SUM(MON_SCORE)*KPI_WGT_RTO)/KPI_TGT_RTO,2) END PA_POINT  " ).append("\n"); 
		query.append("                        FROM (WITH PERF AS(SELECT A.EG_ID, A.SP_SEQ, A.EV_YR, A.SP_KPI_ID" ).append("\n"); 
		query.append("                                                , CASE  WHEN C.SP_KPI_TP_CD != 'P' THEN B.KPI_TGT_RTO " ).append("\n"); 
		query.append("                                                        ELSE (SELECT ROUND(SUM(KPI_TGT_RTO)/COUNT(1),2) FROM SPE_EV_GRP_TML_PROD_TGT WHERE EG_ID = A.EG_ID AND SP_SEQ = A.SP_SEQ)" ).append("\n"); 
		query.append("                                                  END AS KPI_TGT_RTO                 " ).append("\n"); 
		query.append("                                                , B.KPI_WGT_RTO" ).append("\n"); 
		query.append("                                                , JAN_RTO  " ).append("\n"); 
		query.append("                                                , FEB_RTO  " ).append("\n"); 
		query.append("                                                , MAR_RTO" ).append("\n"); 
		query.append("                                                , APR_RTO " ).append("\n"); 
		query.append("                                                , MAY_RTO" ).append("\n"); 
		query.append("                                                , JUN_RTO " ).append("\n"); 
		query.append("                                                , JUL_RTO  " ).append("\n"); 
		query.append("                                                , AUG_RTO" ).append("\n"); 
		query.append("                                                , SEP_RTO " ).append("\n"); 
		query.append("                                                , OCT_RTO" ).append("\n"); 
		query.append("                                                , NOV_RTO" ).append("\n"); 
		query.append("                                                , DEC_RTO " ).append("\n"); 
		query.append("                                             FROM SPE_EV_GRP_KPI_PERF A" ).append("\n"); 
		query.append("                                                , SPE_EV_GRP_KPI_PERF_TGT B" ).append("\n"); 
		query.append("                                                , SPE_SP_SVC_CATE_KPI C" ).append("\n"); 
		query.append("                                            WHERE A.EG_ID = B.EG_ID" ).append("\n"); 
		query.append("                                              AND A.SP_KPI_ID = B.SP_KPI_ID" ).append("\n"); 
		query.append("                                              AND A.EV_YR = B.EV_YR" ).append("\n"); 
		query.append("                                              AND A.SP_KPI_ID = C.SP_KPI_ID   " ).append("\n"); 
		query.append("                                              AND C.DELT_FLG = 'N'   " ).append("\n"); 
		query.append("                                              AND A.EV_YR BETWEEN @[ev_from_yr] AND @[ev_to_yr]" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                              SELECT PERF.EG_ID" ).append("\n"); 
		query.append("                                                   , PERF.SP_SEQ" ).append("\n"); 
		query.append("                                                   , PERF.EV_YR" ).append("\n"); 
		query.append("                                                   , PERF.SP_KPI_ID" ).append("\n"); 
		query.append("                                                   , PERF.KPI_WGT_RTO" ).append("\n"); 
		query.append("                                                   , PERF.KPI_TGT_RTO" ).append("\n"); 
		query.append("                                                   , NUM AS MON" ).append("\n"); 
		query.append("                                                   , CASE WHEN NUM =1 THEN JAN_RTO" ).append("\n"); 
		query.append("                                                          WHEN NUM =2 THEN FEB_RTO" ).append("\n"); 
		query.append("                                                          WHEN NUM =3 THEN MAR_RTO" ).append("\n"); 
		query.append("                                                          WHEN NUM =4 THEN APR_RTO" ).append("\n"); 
		query.append("                                                          WHEN NUM =5 THEN MAY_RTO" ).append("\n"); 
		query.append("                                                          WHEN NUM =6 THEN JUN_RTO" ).append("\n"); 
		query.append("                                                          WHEN NUM =7 THEN JUL_RTO" ).append("\n"); 
		query.append("                                                          WHEN NUM =8 THEN AUG_RTO" ).append("\n"); 
		query.append("                                                          WHEN NUM =9 THEN SEP_RTO" ).append("\n"); 
		query.append("                                                          WHEN NUM =10 THEN OCT_RTO" ).append("\n"); 
		query.append("                                                          WHEN NUM =11 THEN NOV_RTO" ).append("\n"); 
		query.append("                                                          WHEN NUM =12 THEN DEC_RTO                 " ).append("\n"); 
		query.append("                                                      END MON_SCORE" ).append("\n"); 
		query.append("                                                FROM PERF" ).append("\n"); 
		query.append("                                                   , (SELECT LEVEL NUM FROM DUAL" ).append("\n"); 
		query.append("                                                      CONNECT BY LEVEL <= 12 " ).append("\n"); 
		query.append("                                                     )" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                        WHERE MON BETWEEN @[ev_from_mon] AND @[ev_to_mon]" ).append("\n"); 
		query.append("                          AND MON_SCORE <> 0" ).append("\n"); 
		query.append("                        GROUP BY KPI_WGT_RTO,KPI_TGT_RTO, EG_ID, SP_SEQ, EV_YR,SP_KPI_ID,MON" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                     GROUP BY EG_ID, SP_SEQ, EV_YR, SP_KPI_ID                 " ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("              GROUP BY EG_ID, SP_SEQ, EV_YR" ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("     , SPE_EV_GRP B" ).append("\n"); 
		query.append("     , SPE_SP_BZC_EV_GRP C" ).append("\n"); 
		query.append("     , SPE_SP_DIFF_GRD D" ).append("\n"); 
		query.append("     , SPE_BZC_EV_GRD E" ).append("\n"); 
		query.append(" WHERE A.EG_ID = B.EG_ID" ).append("\n"); 
		query.append("   AND A.EG_ID = C.EG_ID" ).append("\n"); 
		query.append("   AND A.SP_SEQ = C.SP_SEQ" ).append("\n"); 
		query.append("   AND A.EV_YR = C.EV_YR" ).append("\n"); 
		query.append("   AND C.BZC_EV_GRD_CD = D.BZC_EV_GRD_CD " ).append("\n"); 
		query.append("   AND A.PA_POINT BETWEEN D.FM_SCRE_RTO AND D.TO_SCRE_RTO   " ).append("\n"); 
		query.append("   AND C.BZC_EV_GRD_CD = E.BZC_EV_GRD_CD(+)" ).append("\n"); 
		query.append(" #if(${s_eg_rhq_cd}!='')" ).append("\n"); 
		query.append("   AND B.EG_RHQ_CD = @[s_eg_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_eg_ofc_cd}!='')" ).append("\n"); 
		query.append("   AND B.EG_OFC_CD = @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_ev_svc_cate_cd}!='')" ).append("\n"); 
		query.append("   AND B.EV_SVC_CATE_CD = @[s_ev_svc_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_sp_seq}!='')" ).append("\n"); 
		query.append("   AND A.SP_SEQ = @[s_sp_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_sd_gp}!='')" ).append("\n"); 
		query.append("   AND D.SP_DIFF_GRD_CD = @[s_sd_gp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("ORDER BY A.SP_SEQ, A.EV_YR, B.EG_ID, B.EG_RHQ_CD, B.EG_OFC_CD, B.EV_SVC_CATE_CD" ).append("\n"); 

	}
}