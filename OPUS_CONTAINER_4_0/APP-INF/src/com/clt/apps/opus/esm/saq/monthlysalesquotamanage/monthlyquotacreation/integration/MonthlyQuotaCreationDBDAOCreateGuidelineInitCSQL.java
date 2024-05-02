/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOCreateGuidelineInitCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.04 
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

public class MonthlyQuotaCreationDBDAOCreateGuidelineInitCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 버전의 Notify 된 Base Data로 Initial Data를 생성한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOCreateGuidelineInitCSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOCreateGuidelineInitCSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_INIT_GLINE " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("           MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("         , BSE_YR " ).append("\n"); 
		query.append("         , BSE_MON " ).append("\n"); 
		query.append("         , TRD_CD " ).append("\n"); 
		query.append("         , SUB_TRD_CD " ).append("\n"); 
		query.append("         , DIR_CD " ).append("\n"); 
		query.append("         , LOD_QTY " ).append("\n"); 
		query.append("         , SPL_AMT " ).append("\n"); 
		query.append("         , LDF_RTO " ).append("\n"); 
		query.append("         , INIT_CM_AMT " ).append("\n"); 
		query.append("         , GLINE_CM_AMT " ).append("\n"); 
		query.append("         , GLINE_STS_FLG" ).append("\n"); 
		query.append("         , ORG_LOD_QTY" ).append("\n"); 
		query.append("         , ORG_LDF_RTO" ).append("\n"); 
		query.append("         , CRE_USR_ID " ).append("\n"); 
		query.append("         , CRE_DT " ).append("\n"); 
		query.append("         , UPD_USR_ID " ).append("\n"); 
		query.append("         , UPD_DT " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("SELECT MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("     , BSE_YR " ).append("\n"); 
		query.append("     , BSE_MON " ).append("\n"); 
		query.append("     , TRD_CD " ).append("\n"); 
		query.append("     , SUB_TRD_CD " ).append("\n"); 
		query.append("     , DIR_CD " ).append("\n"); 
		query.append("     , LOD_QTY " ).append("\n"); 
		query.append("     , FNL_BSA_CAPA AS SPL_AMT " ).append("\n"); 
		query.append("     , DECODE(FNL_BSA_CAPA, 0, 0, ROUND(LOD_QTY / FNL_BSA_CAPA * 100)) AS LDF_RTO" ).append("\n"); 
		query.append("     , CM AS INIT_CM_AMT " ).append("\n"); 
		query.append("     , CM AS GLINE_CM_AMT " ).append("\n"); 
		query.append("     , '0' AS GLINE_STS_FLG" ).append("\n"); 
		query.append("     , LOD_QTY AS ORG_LOD_QTY" ).append("\n"); 
		query.append("     , DECODE(FNL_BSA_CAPA, 0, 0, ROUND(LOD_QTY / FNL_BSA_CAPA * 100)) AS ORG_LDF_RTO" ).append("\n"); 
		query.append("     , @[user_id] " ).append("\n"); 
		query.append("     , SYSDATE " ).append("\n"); 
		query.append("     , @[user_id] " ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT T1.BSE_YR " ).append("\n"); 
		query.append("            , T1.BSE_QTR_CD " ).append("\n"); 
		query.append("            , T1.BSE_MON " ).append("\n"); 
		query.append("            , T1.TRD_CD " ).append("\n"); 
		query.append("            , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("            , T1.DIR_CD " ).append("\n"); 
		query.append("            , NVL(MAX(T1.FNL_BSA_CAPA),0) AS FNL_BSA_CAPA " ).append("\n"); 
		query.append("            , T2.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("            , ROUND(SUM(T2.LOD_QTY)) AS LOD_QTY " ).append("\n"); 
		query.append("            , ROUND(SUM(T2.CM)) AS CM /* CMPB * TEU = CM */ " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT BSE_YR " ).append("\n"); 
		query.append("                   , BSE_QTR_CD " ).append("\n"); 
		query.append("                   , BSE_MON " ).append("\n"); 
		query.append("                   , TRD_CD " ).append("\n"); 
		query.append("                   , SUB_TRD_CD " ).append("\n"); 
		query.append("                   , RLANE_CD " ).append("\n"); 
		query.append("                   , DIR_CD " ).append("\n"); 
		query.append("                   , SUM(FNL_BSA_CAPA) OVER (PARTITION BY BSE_YR, BSE_QTR_CD, BSE_MON, TRD_CD, SUB_TRD_CD, DIR_CD) AS FNL_BSA_CAPA " ).append("\n"); 
		query.append("                FROM SAQ_MON_TGT_VVD " ).append("\n"); 
		query.append("               WHERE 1=1 " ).append("\n"); 
		query.append("                     AND BSE_YR = @[year] " ).append("\n"); 
		query.append("              		 AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("                     AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("                     AND TGT_VVD_STS_CD = 'N' " ).append("\n"); 
		query.append("              ) T1 " ).append("\n"); 
		query.append("            , " ).append("\n"); 
		query.append("              (SELECT MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                   , TRD_CD " ).append("\n"); 
		query.append("                   , SUB_TRD_CD " ).append("\n"); 
		query.append("                   , RLANE_CD " ).append("\n"); 
		query.append("                   , DIR_CD " ).append("\n"); 
		query.append("                   , LOD_QTY " ).append("\n"); 
		query.append("                   , ST_DT " ).append("\n"); 
		query.append("                   , CM_UC_AMT /* CPB */ " ).append("\n"); 
		query.append("                   , GRS_RPB_REV /* RPB */ " ).append("\n"); 
		query.append("                   , (GRS_RPB_REV - CM_UC_AMT) * LOD_QTY AS CM /* (RPB - CPB) * TEU = CM */" ).append("\n"); 
		query.append("                   , FCAST_TRNS_STS_CD  " ).append("\n"); 
		query.append("                FROM SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append("              ) T2 " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND T2.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no]" ).append("\n"); 
		query.append("              AND T2.FCAST_TRNS_STS_CD = 'N' " ).append("\n"); 
		query.append("              AND T1.BSE_YR = SUBSTR(TO_CHAR(T2.ST_DT, 'YYYYMMDD'), 1, 4) " ).append("\n"); 
		query.append("              AND T1.BSE_MON = TO_CHAR(T2.ST_DT, 'MM') " ).append("\n"); 
		query.append("              AND T1.TRD_CD = T2.TRD_CD " ).append("\n"); 
		query.append("              AND T1.SUB_TRD_CD = T2.SUB_TRD_CD " ).append("\n"); 
		query.append("              AND T1.RLANE_CD = T2.RLANE_CD " ).append("\n"); 
		query.append("              AND T1.DIR_CD = T2.DIR_CD " ).append("\n"); 
		query.append("        GROUP BY T2.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("            , T1.BSE_YR " ).append("\n"); 
		query.append("            , T1.BSE_QTR_CD " ).append("\n"); 
		query.append("            , T1.BSE_MON " ).append("\n"); 
		query.append("            , T1.TRD_CD " ).append("\n"); 
		query.append("            , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("            , T1.DIR_CD " ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}