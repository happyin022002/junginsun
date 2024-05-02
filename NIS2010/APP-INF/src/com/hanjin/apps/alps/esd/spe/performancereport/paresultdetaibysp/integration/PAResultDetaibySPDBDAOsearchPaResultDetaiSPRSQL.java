/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PAResultDetaibySPDBDAOsearchPaResultDetaiSPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.19 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PAResultDetaibySPDBDAOsearchPaResultDetaiSPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Quantitative Analysis : PA Result Detail by S/P 데이터를 조회한다
	  * </pre>
	  */
	public PAResultDetaibySPDBDAOsearchPaResultDetaiSPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.integration").append("\n"); 
		query.append("FileName : PAResultDetaibySPDBDAOsearchPaResultDetaiSPRSQL").append("\n"); 
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
		query.append("SELECT EG_ID" ).append("\n"); 
		query.append("     , SP_KPI_ID" ).append("\n"); 
		query.append("     , SP_KPI_NM" ).append("\n"); 
		query.append("     , RSLT_SCRE_RTO" ).append("\n"); 
		query.append("     , KPI_TGT_RTO" ).append("\n"); 
		query.append("     , ROUND(((JAN_RTO + FEB_RTO + MAR_RTO + APR_RTO + " ).append("\n"); 
		query.append("                    MAY_RTO + JUN_RTO + JUL_RTO + AUG_RTO + " ).append("\n"); 
		query.append("                    SEP_RTO + OCT_RTO + NOV_RTO + DEC_RTO)/(KPI_TGT_RTO*INCNT)" ).append("\n"); 
		query.append("        )*100,2)||'%' AS TGT_AVG" ).append("\n"); 
		query.append("     , JAN_RTO  " ).append("\n"); 
		query.append("     , FEB_RTO  " ).append("\n"); 
		query.append("     , MAR_RTO" ).append("\n"); 
		query.append("     , APR_RTO " ).append("\n"); 
		query.append("     , MAY_RTO" ).append("\n"); 
		query.append("     , JUN_RTO " ).append("\n"); 
		query.append("     , JUL_RTO  " ).append("\n"); 
		query.append("     , AUG_RTO" ).append("\n"); 
		query.append("     , SEP_RTO " ).append("\n"); 
		query.append("     , OCT_RTO" ).append("\n"); 
		query.append("     , NOV_RTO" ).append("\n"); 
		query.append("     , DEC_RTO" ).append("\n"); 
		query.append("  FROM (SELECT A.EG_ID" ).append("\n"); 
		query.append("             , A.SP_KPI_ID" ).append("\n"); 
		query.append("             , (SELECT SP_KPI_NM FROM SPE_SP_SVC_CATE_KPI WHERE SP_KPI_ID = A.SP_KPI_ID" ).append("\n"); 
		query.append("               ) AS SP_KPI_NM" ).append("\n"); 
		query.append("             , A.RSLT_SCRE_RTO" ).append("\n"); 
		query.append("             , CASE  WHEN C.SP_KPI_TP_CD != 'P' THEN B.KPI_TGT_RTO " ).append("\n"); 
		query.append("                          ELSE (SELECT ROUND(SUM(KPI_TGT_RTO)/COUNT(1),2) FROM SPE_EV_GRP_TML_PROD_TGT WHERE EG_ID = A.EG_ID AND SP_SEQ = A.SP_SEQ)" ).append("\n"); 
		query.append("               END AS KPI_TGT_RTO" ).append("\n"); 
		query.append("             , A.JAN_RTO  " ).append("\n"); 
		query.append("             , A.FEB_RTO  " ).append("\n"); 
		query.append("             , A.MAR_RTO" ).append("\n"); 
		query.append("             , A.APR_RTO " ).append("\n"); 
		query.append("             , A.MAY_RTO" ).append("\n"); 
		query.append("             , A.JUN_RTO " ).append("\n"); 
		query.append("             , A.JUL_RTO  " ).append("\n"); 
		query.append("             , A.AUG_RTO" ).append("\n"); 
		query.append("             , A.SEP_RTO " ).append("\n"); 
		query.append("             , A.OCT_RTO" ).append("\n"); 
		query.append("             , A.NOV_RTO" ).append("\n"); 
		query.append("             , A.DEC_RTO" ).append("\n"); 
		query.append("             , (SELECT CASE WHEN JAN_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                     + CASE WHEN FEB_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                     + CASE WHEN MAR_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                     + CASE WHEN APR_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                     + CASE WHEN MAY_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                     + CASE WHEN JUN_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                     + CASE WHEN JUL_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                     + CASE WHEN AUG_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                     + CASE WHEN SEP_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                     + CASE WHEN OCT_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                     + CASE WHEN NOV_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                     + CASE WHEN DEC_RTO > 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("                  FROM SPE_EV_GRP_KPI_PERF " ).append("\n"); 
		query.append("                 WHERE EG_ID = A.EG_ID " ).append("\n"); 
		query.append("                   AND SP_KPI_ID = A.SP_KPI_ID " ).append("\n"); 
		query.append("                   AND EV_YR = A.EV_YR " ).append("\n"); 
		query.append("                   AND SP_SEQ = A.SP_SEQ) INCNT" ).append("\n"); 
		query.append("          FROM SPE_EV_GRP_KPI_PERF A" ).append("\n"); 
		query.append("             , SPE_EV_GRP_KPI_PERF_TGT B" ).append("\n"); 
		query.append("             , SPE_SP_SVC_CATE_KPI C" ).append("\n"); 
		query.append("         WHERE A.EG_ID = B.EG_ID " ).append("\n"); 
		query.append("           AND A.SP_KPI_ID = B.SP_KPI_ID" ).append("\n"); 
		query.append("           AND A.SP_KPI_ID = C.SP_KPI_ID" ).append("\n"); 
		query.append("           AND A.EV_YR = B.EV_YR" ).append("\n"); 
		query.append("           AND C.SP_KPI_TP_CD <> 'S'" ).append("\n"); 
		query.append("           AND A.SP_SEQ = @[s_sp_seq]" ).append("\n"); 
		query.append("           AND A.EV_YR = @[s_ev_yr]" ).append("\n"); 
		query.append("           AND A.EG_ID= @[eg_id]" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}