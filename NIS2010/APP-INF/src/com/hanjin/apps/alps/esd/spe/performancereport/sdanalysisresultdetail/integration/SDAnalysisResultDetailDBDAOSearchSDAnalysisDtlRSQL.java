/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SDAnalysisResultDetailDBDAOSearchSDAnalysisDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.20
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.20 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SDAnalysisResultDetailDBDAOSearchSDAnalysisDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SD Analysis Result Detail 조회 쿼리
	  * </pre>
	  */
	public SDAnalysisResultDetailDBDAOSearchSDAnalysisDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.integration").append("\n"); 
		query.append("FileName : SDAnalysisResultDetailDBDAOSearchSDAnalysisDtlRSQL").append("\n"); 
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
		query.append("SELECT B.EG_ID " ).append("\n"); 
		query.append("     , B.EG_NM" ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.SP_SEQ) AS SP_NAME     " ).append("\n"); 
		query.append("     , C.SP_KPI_TP_CD" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID ='CD03370' AND INTG_CD_VAL_CTNT = C.SP_KPI_TP_CD ) AS SP_KPI_TP_NM" ).append("\n"); 
		query.append("     , C.SP_KPI_ID" ).append("\n"); 
		query.append("     , C.SP_KPI_NM   " ).append("\n"); 
		query.append("     , CASE  WHEN C.SP_KPI_TP_CD != 'P' THEN D.KPI_TGT_RTO " ).append("\n"); 
		query.append("                  ELSE (SELECT ROUND(SUM(KPI_TGT_RTO)/COUNT(1),2) FROM SPE_EV_GRP_TML_PROD_TGT WHERE EG_ID = A.EG_ID AND SP_SEQ = A.SP_SEQ)" ).append("\n"); 
		query.append("       END AS KPI_TGT_RTO     " ).append("\n"); 
		query.append("     , D.KPI_WGT_RTO" ).append("\n"); 
		query.append("     , B.EG_RHQ_CD" ).append("\n"); 
		query.append("     , B.EG_OFC_CD" ).append("\n"); 
		query.append("     , B.EV_SVC_CATE_CD" ).append("\n"); 
		query.append("     , A.SP_SEQ     " ).append("\n"); 
		query.append("     , A.EV_YR" ).append("\n"); 
		query.append("     , A.RSLT_SCRE_RTO" ).append("\n"); 
		query.append("     , (SELECT ROUND(SUM(MON_SCORE)/COUNT(1),2) FROM(" ).append("\n"); 
		query.append("        WITH PERF AS(SELECT EG_ID, SP_SEQ, EV_YR, SP_KPI_ID " ).append("\n"); 
		query.append("                          , JAN_RTO  " ).append("\n"); 
		query.append("                          , FEB_RTO  " ).append("\n"); 
		query.append("                          , MAR_RTO" ).append("\n"); 
		query.append("                          , APR_RTO " ).append("\n"); 
		query.append("                          , MAY_RTO" ).append("\n"); 
		query.append("                          , JUN_RTO " ).append("\n"); 
		query.append("                          , JUL_RTO  " ).append("\n"); 
		query.append("                          , AUG_RTO" ).append("\n"); 
		query.append("                          , SEP_RTO " ).append("\n"); 
		query.append("                          , OCT_RTO" ).append("\n"); 
		query.append("                          , NOV_RTO" ).append("\n"); 
		query.append("                          , DEC_RTO " ).append("\n"); 
		query.append("                       FROM SPE_EV_GRP_KPI_PERF                                   " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                       SELECT EG_ID, SP_SEQ, EV_YR, SP_KPI_ID " ).append("\n"); 
		query.append("                            , CASE WHEN NUM =1 THEN JAN_RTO" ).append("\n"); 
		query.append("                                   WHEN NUM =2 THEN FEB_RTO" ).append("\n"); 
		query.append("                                   WHEN NUM =3 THEN MAR_RTO" ).append("\n"); 
		query.append("                                   WHEN NUM =4 THEN APR_RTO" ).append("\n"); 
		query.append("                                   WHEN NUM =5 THEN MAY_RTO" ).append("\n"); 
		query.append("                                   WHEN NUM =6 THEN JUN_RTO                " ).append("\n"); 
		query.append("                                   WHEN NUM =7 THEN JUL_RTO" ).append("\n"); 
		query.append("                                   WHEN NUM =8 THEN AUG_RTO" ).append("\n"); 
		query.append("                                   WHEN NUM =9 THEN SEP_RTO" ).append("\n"); 
		query.append("                                   WHEN NUM =10 THEN OCT_RTO" ).append("\n"); 
		query.append("                                   WHEN NUM =11 THEN NOV_RTO" ).append("\n"); 
		query.append("                                   WHEN NUM =12 THEN DEC_RTO                 " ).append("\n"); 
		query.append("                               END MON_SCORE" ).append("\n"); 
		query.append("                         FROM PERF" ).append("\n"); 
		query.append("                            , (SELECT LEVEL NUM FROM DUAL" ).append("\n"); 
		query.append("                               CONNECT BY LEVEL <= 12 " ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                         WHERE EG_ID = A.EG_ID" ).append("\n"); 
		query.append("                           AND SP_KPI_ID = A.SP_KPI_ID" ).append("\n"); 
		query.append("                           AND EV_YR = A.EV_YR" ).append("\n"); 
		query.append("                           AND SP_sEQ = A.SP_SEQ" ).append("\n"); 
		query.append("                           AND MON_SCORE <> 0" ).append("\n"); 
		query.append("       ) AS PFMC" ).append("\n"); 
		query.append("  FROM SPE_EV_GRP_KPI_PERF A" ).append("\n"); 
		query.append("     , SPE_EV_GRP B" ).append("\n"); 
		query.append("     , SPE_SP_SVC_CATE_KPI C" ).append("\n"); 
		query.append("     , SPE_EV_GRP_KPI_PERF_TGT D" ).append("\n"); 
		query.append(" WHERE A.EG_ID = B.EG_ID" ).append("\n"); 
		query.append("   AND A.SP_KPI_ID = C.SP_KPI_ID" ).append("\n"); 
		query.append("   AND A.EG_ID = D.EG_ID" ).append("\n"); 
		query.append("   AND A.SP_KPI_ID = D.SP_KPI_ID" ).append("\n"); 
		query.append("   AND A.EV_YR = D.EV_YR" ).append("\n"); 
		query.append("   AND A.SP_SEQ = @[sp_seq]" ).append("\n"); 
		query.append("   AND A.EV_YR = @[ev_yr]" ).append("\n"); 
		query.append("   AND B.EG_ID = @[eg_id]" ).append("\n"); 

	}
}