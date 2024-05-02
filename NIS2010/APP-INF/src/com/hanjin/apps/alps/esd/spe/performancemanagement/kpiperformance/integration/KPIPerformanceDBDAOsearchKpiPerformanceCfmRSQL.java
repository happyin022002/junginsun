/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPIPerformanceDBDAOsearchKpiPerformanceCfmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.06 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KPIPerformanceDBDAOsearchKpiPerformanceCfmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public KPIPerformanceDBDAOsearchKpiPerformanceCfmRSQL(){
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
		params.put("s_sp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.integration").append("\n"); 
		query.append("FileName : KPIPerformanceDBDAOsearchKpiPerformanceCfmRSQL").append("\n"); 
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
		query.append("WITH PERF AS (" ).append("\n"); 
		query.append("SELECT KPT.EG_ID" ).append("\n"); 
		query.append("	, SEG.EV_SVC_CATE_CD" ).append("\n"); 
		query.append("    , KPT.SP_KPI_ID" ).append("\n"); 
		query.append("	, SCK.SP_KPI_TP_CD " ).append("\n"); 
		query.append("    , KPT.EV_YR" ).append("\n"); 
		query.append("    , CASE  WHEN SP_KPI_TP_CD != 'P' THEN KPT.KPI_TGT_RTO " ).append("\n"); 
		query.append("                 ELSE (SELECT ROUND(SUM(KPI_TGT_RTO)/COUNT(1),2) FROM SPE_EV_GRP_TML_PROD_TGT WHERE EG_ID = KPT.EG_ID AND SP_SEQ = BEG.SP_SEQ AND EV_YR=KPT.EV_YR)" ).append("\n"); 
		query.append("      END AS KPI_TGT_RTO" ).append("\n"); 
		query.append("    , KPT.KPI_WGT_RTO" ).append("\n"); 
		query.append("    , BEG.SP_SEQ" ).append("\n"); 
		query.append("FROM SPE_EV_GRP SEG" ).append("\n"); 
		query.append("    , SPE_SP_BZC_EV_GRP BEG" ).append("\n"); 
		query.append("    , SPE_SP_SVC_CATE_KPI SCK" ).append("\n"); 
		query.append("    , SPE_EV_GRP_KPI_PERF_TGT KPT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SEG.EG_ID = KPT.EG_ID" ).append("\n"); 
		query.append("AND SEG.EG_ID = BEG.EG_ID" ).append("\n"); 
		query.append("AND SEG.EV_SVC_CATE_CD = SCK.EV_SVC_CATE_CD" ).append("\n"); 
		query.append("AND SCK.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND KPT.SP_KPI_ID = SCK.SP_KPI_ID" ).append("\n"); 
		query.append("AND BEG.BZC_EV_GRD_CD  IS NOT NULL" ).append("\n"); 
		query.append("AND KPT.EV_YR = @[s_ev_yr]" ).append("\n"); 
		query.append("AND SEG.EG_RHQ_CD = @[s_eg_rhq_cd]" ).append("\n"); 
		query.append("AND SEG.EG_OFC_CD = @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("AND SEG.EV_SVC_CATE_CD = @[s_ev_svc_cate_cd]" ).append("\n"); 
		query.append("#if(${s_sp_seq} != '')" ).append("\n"); 
		query.append("AND BEG.SP_SEQ = @[s_sp_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BEG.EV_YR = @[s_ev_yr]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT PERF.EG_ID" ).append("\n"); 
		query.append("    , (SELECT EG_NM" ).append("\n"); 
		query.append("        FROM SPE_EV_GRP" ).append("\n"); 
		query.append("        WHERE EG_ID = PERF.EG_ID) AS EG_NM" ).append("\n"); 
		query.append("	, PERF.EV_SVC_CATE_CD" ).append("\n"); 
		query.append("    , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID ='CD03377'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = PERF.EV_SVC_CATE_CD" ).append("\n"); 
		query.append("      ) AS EV_SVC_CATE_NM" ).append("\n"); 
		query.append("    , PERF.SP_KPI_ID" ).append("\n"); 
		query.append("    , (SELECT SP_KPI_NM" ).append("\n"); 
		query.append("        FROM SPE_SP_SVC_CATE_KPI" ).append("\n"); 
		query.append("        WHERE SP_KPI_ID = PERF.SP_KPI_ID) AS SP_KPI_NM" ).append("\n"); 
		query.append("	, PERF.SP_KPI_TP_CD " ).append("\n"); 
		query.append("    , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD03370'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = PERF.SP_KPI_TP_CD" ).append("\n"); 
		query.append("      ) AS SP_KPI_TP_NM" ).append("\n"); 
		query.append("    , PERF.EV_YR, PERF.KPI_TGT_RTO, PERF.KPI_WGT_RTO" ).append("\n"); 
		query.append("    , LPAD(PERF.SP_SEQ,6,0) AS SP_SEQ" ).append("\n"); 
		query.append("    , (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("    -- select *" ).append("\n"); 
		query.append("             FROM MDM_VENDOR" ).append("\n"); 
		query.append("             WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("             AND VNDR_SEQ = PERF.SP_SEQ" ).append("\n"); 
		query.append("             AND ROWNUM = 1" ).append("\n"); 
		query.append("      )AS SP_NM" ).append("\n"); 
		query.append("    , KP.JAN_RTO    , KP.FEB_RTO    , KP.MAR_RTO" ).append("\n"); 
		query.append("    , KP.APR_RTO    , KP.MAY_RTO    , KP.JUN_RTO" ).append("\n"); 
		query.append("    , KP.JUL_RTO    , KP.AUG_RTO    , KP.SEP_RTO" ).append("\n"); 
		query.append("    , KP.OCT_RTO    , KP.NOV_RTO    , KP.DEC_RTO" ).append("\n"); 
		query.append("    , RSLT_SCRE_RTO" ).append("\n"); 
		query.append("	, CASE WHEN KP.SP_KPI_ID IS NULL THEN 'N' ELSE 'Y' END HAS_SAVED" ).append("\n"); 
		query.append("    , (SELECT CASE WHEN COUNT(1)=0 THEN 'N' ELSE 'Y' END FROM SPE_EV_GRP_EVR WHERE EV_KND_CD = 'P' AND EG_ID = PERF.EG_ID AND EVR_USR_ID = @[cre_usr_id]) MODIFIY_YN " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM PERF" ).append("\n"); 
		query.append("    , SPE_EV_GRP_KPI_PERF KP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND PERF.EG_ID = KP.EG_ID(+)" ).append("\n"); 
		query.append("AND PERF.SP_KPI_ID = KP.SP_KPI_ID(+)" ).append("\n"); 
		query.append("AND PERF.SP_SEQ = KP.SP_SEQ(+)" ).append("\n"); 
		query.append("AND PERF.EV_YR = KP.EV_YR(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY  PERF.EG_ID,PERF.SP_SEQ, PERF.EV_SVC_CATE_CD, PERF.SP_KPI_ID" ).append("\n"); 

	}
}