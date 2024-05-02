/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPIDetailReportbyKPIDBDAOSearchKPIDetailReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.26 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KPIDetailReportbyKPIDBDAOSearchKPIDetailReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KPI Detail Report by KPI 데이터를 조회한다
	  * </pre>
	  */
	public KPIDetailReportbyKPIDBDAOSearchKPIDetailReportRSQL(){
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
		params.put("s_ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.integration").append("\n"); 
		query.append("FileName : KPIDetailReportbyKPIDBDAOSearchKPIDetailReportRSQL").append("\n"); 
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
		query.append("SELECT A.EG_ID" ).append("\n"); 
		query.append("     , A.EG_NM" ).append("\n"); 
		query.append("     , B.SP_KPI_ID" ).append("\n"); 
		query.append("     , c.SP_KPI_NM" ).append("\n"); 
		query.append("     , B.EV_YR" ).append("\n"); 
		query.append("     , LPAD(B.SP_SEQ, 6, '0') AS SP_SEQ " ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE DELT_FLG = 'N' AND VNDR_SEQ = B.SP_SEQ)AS SP_NM     " ).append("\n"); 
		query.append("     , B.JAN_RTO" ).append("\n"); 
		query.append("     , B.FEB_RTO" ).append("\n"); 
		query.append("     , B.MAR_RTO" ).append("\n"); 
		query.append("     , B.APR_RTO" ).append("\n"); 
		query.append("     , B.MAY_RTO" ).append("\n"); 
		query.append("     , B.JUN_RTO" ).append("\n"); 
		query.append("     , B.JUL_RTO" ).append("\n"); 
		query.append("     , B.AUG_RTO" ).append("\n"); 
		query.append("     , B.SEP_RTO" ).append("\n"); 
		query.append("     , B.OCT_RTO" ).append("\n"); 
		query.append("     , B.NOV_RTO" ).append("\n"); 
		query.append("     , B.DEC_RTO" ).append("\n"); 
		query.append("     , B.RSLT_SCRE_RTO" ).append("\n"); 
		query.append("     , D.KPI_WGT_RTO" ).append("\n"); 
		query.append("     , C.SP_KPI_TP_CD" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03370' AND INTG_CD_VAL_CTNT = c.SP_KPI_TP_CD) AS SP_KPI_TP_NM     " ).append("\n"); 
		query.append("     , CASE  WHEN C.SP_KPI_TP_CD != 'P' THEN D.KPI_TGT_RTO " ).append("\n"); 
		query.append("                 ELSE (SELECT ROUND(SUM(KPI_TGT_RTO)/COUNT(1),2) FROM SPE_EV_GRP_TML_PROD_TGT WHERE EG_ID = A.EG_ID AND SP_SEQ = B.SP_SEQ)" ).append("\n"); 
		query.append("      END AS KPI_TGT_RTO     " ).append("\n"); 
		query.append("  FROM SPE_EV_GRP A" ).append("\n"); 
		query.append("     , SPE_EV_GRP_KPI_PERF B" ).append("\n"); 
		query.append("     , SPE_SP_SVC_CATE_KPI C" ).append("\n"); 
		query.append("     , SPE_EV_GRP_KPI_PERF_TGT D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.EG_ID = B.EG_ID" ).append("\n"); 
		query.append("   AND B.SP_KPI_ID = C.SP_KPI_ID" ).append("\n"); 
		query.append("   AND B.EG_ID = D.EG_ID" ).append("\n"); 
		query.append("   AND B.SP_KPI_ID = D.SP_KPI_ID   " ).append("\n"); 
		query.append("   AND B.EV_YR = D.EV_YR" ).append("\n"); 
		query.append("   AND B.EV_YR = @[s_ev_yr]" ).append("\n"); 
		query.append("   AND A.EG_RHQ_CD = @[s_eg_rhq_cd]" ).append("\n"); 
		query.append("   AND A.EG_OFC_CD = @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("   AND A.EV_SVC_CATE_CD = @[s_ev_svc_cate_cd]" ).append("\n"); 
		query.append("#if(${s_sp_kpi_id}!='')" ).append("\n"); 
		query.append("   AND B.SP_KPI_ID IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${list_sp_kpi_id})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $list_sp_kpi_id.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_sp_seq}!='')" ).append("\n"); 
		query.append("   AND B.SP_SEQ = @[s_sp_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}