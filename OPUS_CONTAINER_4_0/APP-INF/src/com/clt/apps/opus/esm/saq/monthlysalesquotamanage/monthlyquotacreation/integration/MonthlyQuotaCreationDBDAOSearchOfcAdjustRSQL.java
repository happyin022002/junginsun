/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOSearchOfcAdjustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.15 
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

public class MonthlyQuotaCreationDBDAOSearchOfcAdjustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 버전의 Office Adjust 를 수행한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOSearchOfcAdjustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOSearchOfcAdjustRSQL").append("\n"); 
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
		query.append("     , IOC_CD " ).append("\n"); 
		query.append("     , RLANE_CD " ).append("\n"); 
		query.append("     , DIR_CD " ).append("\n"); 
		query.append("     , MAX(ST_DT) AS ST_DT" ).append("\n"); 
		query.append("     , MAX(CTRT_RHQ_CD) AS CTRT_RHQ_CD " ).append("\n"); 
		query.append("     , MAX(CTRT_AQ_CD) AS CTRT_AQ_CD " ).append("\n"); 
		query.append("     , CTRT_OFC_CD " ).append("\n"); 
		query.append("     , MAX(SLS_RHQ_CD) AS SLS_RHQ_CD " ).append("\n"); 
		query.append("     , MAX(SLS_AQ_CD) AS SLS_AQ_CD " ).append("\n"); 
		query.append("     , SLS_OFC_CD " ).append("\n"); 
		query.append("     , MAX(LOD_QTY) AS LOD_QTY " ).append("\n"); 
		query.append("     , MAX(CM_UC_AMT) AS CM_UC_AMT " ).append("\n"); 
		query.append("     , MAX(GRS_RPB_REV) AS GRS_RPB_REV " ).append("\n"); 
		query.append("     , MAX(CMPB) AS CMPB " ).append("\n"); 
		query.append("     , MIN(FCAST_TRNS_STS_CD) AS FCAST_TRNS_STS_CD " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT T1.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("            , T1.TRD_CD " ).append("\n"); 
		query.append("            , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("            , T1.IOC_CD " ).append("\n"); 
		query.append("            , T1.RLANE_CD " ).append("\n"); 
		query.append("            , T1.DIR_CD " ).append("\n"); 
		query.append("            , T1.ST_DT" ).append("\n"); 
		query.append("            , MAX(T1.CTRT_RHQ_CD) AS CTRT_RHQ_CD " ).append("\n"); 
		query.append("            , MAX(T1.CTRT_AQ_CD) AS CTRT_AQ_CD " ).append("\n"); 
		query.append("            , T1.CTRT_OFC_CD " ).append("\n"); 
		query.append("            , MAX(T1.SLS_RHQ_CD) AS SLS_RHQ_CD " ).append("\n"); 
		query.append("            , MAX(T1.SLS_AQ_CD) AS SLS_AQ_CD " ).append("\n"); 
		query.append("            , T1.SLS_OFC_CD " ).append("\n"); 
		query.append("            , ROUND(SUM(T1.LOD_QTY)) AS LOD_QTY " ).append("\n"); 
		query.append("            , ROUND(MAX(T1.CM_UC_AMT)) AS CM_UC_AMT " ).append("\n"); 
		query.append("            , ROUND(MAX(T1.GRS_RPB_REV)) AS GRS_RPB_REV " ).append("\n"); 
		query.append("            , ROUND(MAX(T1.GRS_RPB_REV) - MAX(T1.CM_UC_AMT)) AS CMPB " ).append("\n"); 
		query.append("            , MIN(T1.FCAST_TRNS_STS_CD) AS FCAST_TRNS_STS_CD " ).append("\n"); 
		query.append("         FROM SAQ_MON_FCAST_TRNS T1 " ).append("\n"); 
		query.append("             , SAQ_TGT_GRP_TRD T2  " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND T1.TRD_CD = T2.TRD_CD " ).append("\n"); 
		query.append("              AND T1.SUB_TRD_CD = T2.SUB_TRD_CD " ).append("\n"); 
		query.append("              AND T1.DIR_CD = T2.DIR_CD" ).append("\n"); 
		query.append("			  AND T1.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no] " ).append("\n"); 
		query.append(" 		      AND (T1.FCAST_TRNS_STS_CD = '0' OR T1.FCAST_TRNS_STS_CD IS NULL)" ).append("\n"); 
		query.append("      		#if(${trade} != '' && ${trade} != 'ALL')" ).append("\n"); 
		query.append("        	  AND T1.TRD_CD     = @[trade] " ).append("\n"); 
		query.append("      		#end " ).append("\n"); 
		query.append("      		#if(${bound} != '' && ${bound} != 'ALL')                                                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("        	  AND T1.DIR_CD     = @[bound]  " ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      		#if(${search_lane} != '' && ${search_lane} != 'ALL')                                                                                                                         " ).append("\n"); 
		query.append("        	  AND T1.RLANE_CD   = @[search_lane]   " ).append("\n"); 
		query.append("      		#end " ).append("\n"); 
		query.append("      		#if(${ioc} != '' && ${ioc} != 'ALL')                                                                                                                              " ).append("\n"); 
		query.append("        	  AND T1.IOC_CD     = @[ioc]" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("        GROUP BY T1.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("            , T1.TRD_CD " ).append("\n"); 
		query.append("            , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("            , T1.IOC_CD " ).append("\n"); 
		query.append("            , T1.RLANE_CD " ).append("\n"); 
		query.append("            , T1.DIR_CD " ).append("\n"); 
		query.append("            , T1.CTRT_OFC_CD " ).append("\n"); 
		query.append("            , T1.SLS_OFC_CD " ).append("\n"); 
		query.append("            , T1.ST_DT " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append(" GROUP BY MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("     , TRD_CD " ).append("\n"); 
		query.append("     , SUB_TRD_CD " ).append("\n"); 
		query.append("     , IOC_CD " ).append("\n"); 
		query.append("     , RLANE_CD " ).append("\n"); 
		query.append("     , DIR_CD " ).append("\n"); 
		query.append("     , CTRT_OFC_CD " ).append("\n"); 
		query.append("     , SLS_OFC_CD  " ).append("\n"); 
		query.append("ORDER BY TRD_CD " ).append("\n"); 
		query.append("     , SUB_TRD_CD " ).append("\n"); 
		query.append("     , IOC_CD " ).append("\n"); 
		query.append("     , RLANE_CD " ).append("\n"); 
		query.append("     , DIR_CD " ).append("\n"); 
		query.append("     , CTRT_OFC_CD " ).append("\n"); 
		query.append("     , SLS_OFC_CD" ).append("\n"); 

	}
}