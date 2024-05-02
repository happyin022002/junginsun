/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOSearchLaneAdjustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOSearchLaneAdjustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 버전의 Lane Adjust Data를 조회한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOSearchLaneAdjustRSQL(){
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOSearchLaneAdjustRSQL").append("\n"); 
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
		query.append("SELECT MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("     , TRD_CD " ).append("\n"); 
		query.append("     , SUB_TRD_CD " ).append("\n"); 
		query.append("     , ORG_RLANE_CD " ).append("\n"); 
		query.append("     , '' AS RLANE_CD " ).append("\n"); 
		query.append("     , ROW_CLR " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT NVL(T1.MQTA_MDL_VER_NO, SUBSTR(T2.BSE_YR, 3,2)||BSE_QTR_CD||'01') AS MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("            , NVL(T1.TRD_CD, T2.TRD_CD) AS TRD_CD " ).append("\n"); 
		query.append("            , NVL(T1.SUB_TRD_CD, T2.SUB_TRD_CD) AS SUB_TRD_CD " ).append("\n"); 
		query.append("            , NVL(T1.RLANE_CD, T2.RLANE_CD) AS ORG_RLANE_CD " ).append("\n"); 
		query.append("            , NVL(T1.RLANE_CD, T2.RLANE_CD) AS RLANE_CD " ).append("\n"); 
		query.append("            , DECODE(T1.RLANE_CD, NULL, 'BLUE', DECODE(T2.RLANE_CD, NULL, 'RED', 'ALL')) AS ROW_CLR " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                   , TRD_CD " ).append("\n"); 
		query.append("                   , SUB_TRD_CD " ).append("\n"); 
		query.append("                   , IOC_CD " ).append("\n"); 
		query.append("                   , RLANE_CD " ).append("\n"); 
		query.append("                   , RLANE_CD AS ORG_RLANE_CD " ).append("\n"); 
		query.append("                FROM SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append("               WHERE 1=1 " ).append("\n"); 
		query.append("                     AND MQTA_MDL_VER_NO = @[mqta_mdl_ver_no]  " ).append("\n"); 
		query.append("					 #if(${trd_cd} != '')                     " ).append("\n"); 
		query.append("					 AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("					 #end" ).append("\n"); 
		query.append("	   				 #if(${bound} != '')" ).append("\n"); 
		query.append("       				 AND DIR_CD = @[bound] " ).append("\n"); 
		query.append("       				 #end" ).append("\n"); 
		query.append("                     AND (FCAST_TRNS_STS_CD = '0' OR FCAST_TRNS_STS_CD IS NULL) " ).append("\n"); 
		query.append("               GROUP BY MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                   , TRD_CD " ).append("\n"); 
		query.append("                   , SUB_TRD_CD " ).append("\n"); 
		query.append("                   , IOC_CD " ).append("\n"); 
		query.append("                   , RLANE_CD " ).append("\n"); 
		query.append("              ) T1 " ).append("\n"); 
		query.append("          FULL OUTER JOIN " ).append("\n"); 
		query.append("              (SELECT BSE_YR " ).append("\n"); 
		query.append("                   , BSE_QTR_CD " ).append("\n"); 
		query.append("                   , TRD_CD " ).append("\n"); 
		query.append("                   , SUB_TRD_CD " ).append("\n"); 
		query.append("                   , RLANE_CD " ).append("\n"); 
		query.append("                FROM SAQ_MON_TGT_VVD " ).append("\n"); 
		query.append("               WHERE 1=1 " ).append("\n"); 
		query.append("                     AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("                     AND TGT_VVD_STS_CD = 'N'" ).append("\n"); 
		query.append("                     AND BSE_YR = @[year]" ).append("\n"); 
		query.append("                     AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("				     #if(${trd_cd} != '')                     " ).append("\n"); 
		query.append("					 AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("					 #end" ).append("\n"); 
		query.append("	   				 #if(${bound} != '')" ).append("\n"); 
		query.append("       				 AND DIR_CD = @[bound] " ).append("\n"); 
		query.append("       				 #end" ).append("\n"); 
		query.append("               GROUP BY BSE_YR " ).append("\n"); 
		query.append("                   , BSE_QTR_CD " ).append("\n"); 
		query.append("                   , TRD_CD " ).append("\n"); 
		query.append("                   , SUB_TRD_CD " ).append("\n"); 
		query.append("                   , RLANE_CD " ).append("\n"); 
		query.append("              ) T2 " ).append("\n"); 
		query.append("              ON ( " ).append("\n"); 
		query.append("                  T1.MQTA_MDL_VER_NO = SUBSTR(T2.BSE_YR, 3,2)||BSE_QTR_CD||'01' " ).append("\n"); 
		query.append("                  AND T1.TRD_CD = T2.TRD_CD " ).append("\n"); 
		query.append("                  AND T1.SUB_TRD_CD = T2.SUB_TRD_CD " ).append("\n"); 
		query.append("                  AND T1.RLANE_CD = T2.RLANE_CD " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND ROW_CLR IN ('BLUE', 'RED') " ).append("\n"); 
		query.append("ORDER BY ROW_CLR " ).append("\n"); 
		query.append("     , TRD_CD " ).append("\n"); 
		query.append("     , SUB_TRD_CD  " ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 

	}
}