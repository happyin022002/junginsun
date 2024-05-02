/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KpiTargetDBDAOSearchKPIPerformanceTargetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.03 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KpiTargetDBDAOSearchKPIPerformanceTargetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public KpiTargetDBDAOSearchKPIPerformanceTargetRSQL(){
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
		params.put("s_eg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.integration").append("\n"); 
		query.append("FileName : KpiTargetDBDAOSearchKPIPerformanceTargetRSQL").append("\n"); 
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
		query.append("SELECT NVL(BB.EV_YR,@[s_ev_yr]) AS EV_YR" ).append("\n"); 
		query.append("     , AA.EG_ID" ).append("\n"); 
		query.append("     , AA.EG_NM" ).append("\n"); 
		query.append("     , AA.SP_KPI_ID" ).append("\n"); 
		query.append("     , AA.SP_KPI_NM" ).append("\n"); 
		query.append("     , AA.SP_KPI_TP_CD" ).append("\n"); 
		query.append("     , AA.SP_KPI_TP_NM" ).append("\n"); 
		query.append("     , BB.KPI_TGT_RTO " ).append("\n"); 
		query.append("     , BB.KPI_WGT_RTO     " ).append("\n"); 
		query.append("     , DD.KPI_WGT_RTO AS PRE_WGT_RTO" ).append("\n"); 
		query.append("     , CASE WHEN AA.SP_KPI_TP_CD != 'P' THEN DD.KPI_TGT_RTO" ).append("\n"); 
		query.append("                 ELSE (SELECT ROUND(SUM(KPI_TGT_RTO)/COUNT(1),2) FROM SPE_EV_GRP_TML_PROD_TGT WHERE EG_ID = AA.EG_ID AND EV_YR = TO_NUMBER(@[s_ev_yr])-1)" ).append("\n"); 
		query.append("       END AS PRE_TGT_RTO" ).append("\n"); 
		query.append("     , ROUND(CC.MON_AVG_RTO,2) AS PRE_PER_AVG" ).append("\n"); 
		query.append("     , ROUND(CC.RSLT_SCRE_RTO,2) AS PRE_RSLT_SCRE" ).append("\n"); 
		query.append("     , (SELECT DECODE(COUNT(1),0,'N','Y') USEIS FROM SPE_EV_GRP_KPI_PERF  WHERE EG_ID = AA.EG_ID AND SP_KPI_ID = AA.SP_KPI_ID AND EV_YR = BB.EV_YR) AS USEFLAG" ).append("\n"); 
		query.append("  FROM (SELECT A.EG_ID" ).append("\n"); 
		query.append("             , A.EG_NM" ).append("\n"); 
		query.append("             , B.SP_KPI_ID" ).append("\n"); 
		query.append("             , B.SP_KPI_NM" ).append("\n"); 
		query.append("             , B.SP_KPI_TP_CD" ).append("\n"); 
		query.append("	         , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03370' AND INTG_CD_VAL_CTNT = B.SP_KPI_TP_CD" ).append("\n"); 
		query.append("               ) AS SP_KPI_TP_NM " ).append("\n"); 
		query.append("          FROM SPE_EV_GRP A" ).append("\n"); 
		query.append("             , SPE_SP_SVC_CATE_KPI B" ).append("\n"); 
		query.append("         WHERE A.EV_SVC_CATE_CD = B.EV_SVC_CATE_CD" ).append("\n"); 
		query.append("           AND A.EG_RHQ_CD =  @[s_eg_rhq_cd]" ).append("\n"); 
		query.append("           AND A.EG_OFC_CD =  @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("           AND A.EV_SVC_CATE_CD =  @[s_ev_svc_cate_cd]" ).append("\n"); 
		query.append("           ) AA" ).append("\n"); 
		query.append("         , (SELECT EG_ID, SP_KPI_ID, EV_YR, KPI_TGT_RTO, KPI_WGT_RTO " ).append("\n"); 
		query.append("              FROM SPE_EV_GRP_KPI_PERF_TGT " ).append("\n"); 
		query.append("             WHERE EV_YR = @[s_ev_yr]) BB" ).append("\n"); 
		query.append("         , ( SELECT EG_ID, SP_KPI_ID, EV_YR,SUM(RSLT_SCRE_RTO)/COUNT(1) AS RSLT_SCRE_RTO  " ).append("\n"); 
		query.append("                  , SUM(MON_AVG_RTO)/COUNT(1) AS MON_AVG_RTO" ).append("\n"); 
		query.append("               FROM (SELECT EG_ID, SP_KPI_ID, EV_YR                           " ).append("\n"); 
		query.append("                           , (JAN_RTO+FEB_RTO+MAR_RTO+APR_RTO+MAY_RTO+JUN_RTO+JUL_RTO+AUG_RTO+SEP_RTO+OCT_RTO+NOV_RTO+DEC_RTO)" ).append("\n"); 
		query.append("                             /(DECODE(JAN_RTO,0,0,1)+" ).append("\n"); 
		query.append("                               DECODE(FEB_RTO,0,0,1)+" ).append("\n"); 
		query.append("                               DECODE(MAR_RTO,0,0,1)+" ).append("\n"); 
		query.append("                               DECODE(APR_RTO,0,0,1)+" ).append("\n"); 
		query.append("                               DECODE(MAY_RTO,0,0,1)+" ).append("\n"); 
		query.append("                               DECODE(JUN_RTO,0,0,1)+" ).append("\n"); 
		query.append("                               DECODE(JUL_RTO,0,0,1)+" ).append("\n"); 
		query.append("                               DECODE(AUG_RTO,0,0,1)+" ).append("\n"); 
		query.append("                               DECODE(SEP_RTO,0,0,1)+" ).append("\n"); 
		query.append("                               DECODE(OCT_RTO,0,0,1)+" ).append("\n"); 
		query.append("                               DECODE(NOV_RTO,0,0,1)+" ).append("\n"); 
		query.append("                               DECODE(DEC_RTO,0,0,1))" ).append("\n"); 
		query.append("                               AS MON_AVG_RTO " ).append("\n"); 
		query.append("                            , RSLT_SCRE_RTO,SP_SEQ" ).append("\n"); 
		query.append("                       FROM SPE_EV_GRP_KPI_PERF  A" ).append("\n"); 
		query.append("                      WHERE EV_YR = TO_NUMBER(@[s_ev_yr])-1" ).append("\n"); 
		query.append("                        AND (JAN_RTO+FEB_RTO+MAR_RTO+APR_RTO+MAY_RTO+JUN_RTO+JUL_RTO+AUG_RTO+SEP_RTO+OCT_RTO+NOV_RTO+DEC_RTO)>0" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("               GROUP BY EG_ID, SP_KPI_ID, EV_YR " ).append("\n"); 
		query.append("           ) CC" ).append("\n"); 
		query.append("         , (SELECT EG_ID, SP_KPI_ID, EV_YR, KPI_TGT_RTO, KPI_WGT_RTO " ).append("\n"); 
		query.append("              FROM SPE_EV_GRP_KPI_PERF_TGT " ).append("\n"); 
		query.append("             WHERE EV_YR = TO_NUMBER(@[s_ev_yr])-1) DD  " ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${s_chk_all} != '')" ).append("\n"); 
		query.append("   AND AA.EG_ID = BB.EG_ID(+)" ).append("\n"); 
		query.append("   AND AA.SP_KPI_ID = BB.SP_KPI_ID(+)" ).append("\n"); 
		query.append("#elseif (${s_chk_map} != '')" ).append("\n"); 
		query.append("   AND AA.EG_ID = BB.EG_ID" ).append("\n"); 
		query.append("   AND AA.SP_KPI_ID = BB.SP_KPI_ID" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   AND AA.EG_ID = CC.EG_ID(+)" ).append("\n"); 
		query.append("   AND AA.SP_KPI_ID = CC.SP_KPI_ID(+) " ).append("\n"); 
		query.append("   AND AA.EG_ID = DD.EG_ID(+)" ).append("\n"); 
		query.append("   AND AA.SP_KPI_ID = DD.SP_KPI_ID(+)" ).append("\n"); 
		query.append("ORDER BY  AA.SP_KPI_NM" ).append("\n"); 

	}
}