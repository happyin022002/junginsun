/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOSearchGuidelineListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.06 
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

public class MonthlyQuotaCreationDBDAOSearchGuidelineListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 분기 기초 정보를 조회한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOSearchGuidelineListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOSearchGuidelineListRSQL").append("\n"); 
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
		query.append("SELECT MAX(A.MQTA_MDL_VER_NO) AS MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("     , MAX(A.BSE_YR) AS BSE_YR " ).append("\n"); 
		query.append("     , NVL(DECODE(MAX(B.NO),'1',MAX(A.BSE_MON)),'QTA Total') BSE_MON " ).append("\n"); 
		query.append("     , NVL(DECODE(MAX(B.NO),'1',MAX(A.BSE_YR) || MAX(A.BSE_MON)),'QTA Total') YEAR_MON " ).append("\n"); 
		query.append("     , MAX(A.TRD_CD) AS TRD_CD " ).append("\n"); 
		query.append("     , MAX(A.SUB_TRD_CD) AS SUB_TRD_CD " ).append("\n"); 
		query.append("     , MAX(A.DIR_CD) AS DIR_CD " ).append("\n"); 
		query.append("     , SUM(A.LOD_QTY) AS LOD_QTY " ).append("\n"); 
		query.append("     , SUM(A.SPL_AMT) AS SPL_AMT " ).append("\n"); 
		query.append("     , AVG(A.LDF_RTO) AS LDF_RTO " ).append("\n"); 
		query.append("     , SUM(A.INIT_CM_AMT)/1000 AS INIT_CM_AMT" ).append("\n"); 
		query.append("     , SUM(A.INIT_CM_AMT)/1000 AS CM_AMT " ).append("\n"); 
		query.append("     , SUM(A.GLINE_CM_AMT)/1000 AS GLINE_CM_AMT " ).append("\n"); 
		query.append("     , MIN(C.FCAST_TRNS_STS_CD) AS FCAST_TRNS_STS_CD" ).append("\n"); 
		query.append("     , MIN(A.GLINE_STS_FLG) AS GLINE_STS_FLG" ).append("\n"); 
		query.append("     , SUM(A.ORG_LOD_QTY) AS ORG_LOD_QTY" ).append("\n"); 
		query.append("     , AVG(A.ORG_LDF_RTO) AS ORG_LDF_RTO" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT T1.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("            , T1.BSE_YR " ).append("\n"); 
		query.append("            , T1.BSE_MON " ).append("\n"); 
		query.append("            , T1.TRD_CD " ).append("\n"); 
		query.append("            , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("            , T1.DIR_CD " ).append("\n"); 
		query.append("            , T1.LOD_QTY " ).append("\n"); 
		query.append("            , T1.SPL_AMT " ).append("\n"); 
		query.append("            , T1.LDF_RTO " ).append("\n"); 
		query.append("            , T1.INIT_CM_AMT " ).append("\n"); 
		query.append("            , T1.GLINE_CM_AMT " ).append("\n"); 
		query.append("            , MIN(T1.GLINE_STS_FLG) OVER (PARTITION BY T1.MQTA_MDL_VER_NO) AS GLINE_STS_FLG " ).append("\n"); 
		query.append("            , ORG_LOD_QTY" ).append("\n"); 
		query.append("            , ORG_LDF_RTO" ).append("\n"); 
		query.append("         FROM SAQ_MON_INIT_GLINE T1 " ).append("\n"); 
		query.append("            , SAQ_TGT_GRP_TRD T2 " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND T1.TRD_CD = T2.TRD_CD " ).append("\n"); 
		query.append("              AND T1.SUB_TRD_CD = T2.SUB_TRD_CD " ).append("\n"); 
		query.append("              AND T1.DIR_CD = T2.DIR_CD " ).append("\n"); 
		query.append("              AND T1.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no]         " ).append("\n"); 
		query.append("              #if (${trd_cd} != '') " ).append("\n"); 
		query.append("              AND T1.TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("              #if (${sub_trd_cd} != '')" ).append("\n"); 
		query.append("              AND T1.SUB_TRD_CD = @[sub_trd_cd]  " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${bound} != '')" ).append("\n"); 
		query.append("              AND T1.DIR_CD = @[bound]  " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("       ) A " ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT '1' NO " ).append("\n"); 
		query.append("         FROM DUAL " ).append("\n"); 
		query.append("           UNION ALL " ).append("\n"); 
		query.append("       SELECT '2' " ).append("\n"); 
		query.append("         FROM DUAL " ).append("\n"); 
		query.append("       ) B " ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT MIN(T3.FCAST_TRNS_STS_CD) OVER (PARTITION BY T3.MQTA_MDL_VER_NO) AS FCAST_TRNS_STS_CD " ).append("\n"); 
		query.append("         FROM SAQ_MON_FCAST_TRNS T3 " ).append("\n"); 
		query.append("            , SAQ_TGT_GRP_TRD T4 " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND T3.TRD_CD = T4.TRD_CD " ).append("\n"); 
		query.append("              AND T3.SUB_TRD_CD = T4.SUB_TRD_CD " ).append("\n"); 
		query.append("              AND T3.DIR_CD = T4.DIR_CD " ).append("\n"); 
		query.append("              AND T3.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no] " ).append("\n"); 
		query.append("              AND ROWNUM = 1 " ).append("\n"); 
		query.append("       ) C " ).append("\n"); 
		query.append(" GROUP BY DECODE(B.NO,'1',BSE_MON) " ).append("\n"); 
		query.append("     , TRD_CD " ).append("\n"); 
		query.append("     , SUB_TRD_CD " ).append("\n"); 
		query.append("     , DIR_CD " ).append("\n"); 
		query.append("ORDER BY MAX(B.NO)  " ).append("\n"); 
		query.append("     , MAX(A.BSE_MON)" ).append("\n"); 
		query.append("     , A.TRD_CD " ).append("\n"); 
		query.append("     , A.SUB_TRD_CD " ).append("\n"); 
		query.append("     , A.DIR_CD" ).append("\n"); 

	}
}