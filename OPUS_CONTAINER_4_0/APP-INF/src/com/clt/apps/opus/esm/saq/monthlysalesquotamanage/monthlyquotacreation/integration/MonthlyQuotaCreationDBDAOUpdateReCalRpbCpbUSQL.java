/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOUpdateReCalRpbCpbUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.12 
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

public class MonthlyQuotaCreationDBDAOUpdateReCalRpbCpbUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ofiice 명 수정 후 RPB, CPB를 재 계산한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOUpdateReCalRpbCpbUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chng_ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chng_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOUpdateReCalRpbCpbUSQL").append("\n"); 
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
		query.append("MERGE INTO SAQ_MON_FCAST_TRNS A " ).append("\n"); 
		query.append("USING  " ).append("\n"); 
		query.append("    (SELECT MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("         , ST_DT " ).append("\n"); 
		query.append("         , TRD_CD " ).append("\n"); 
		query.append("         , SUB_TRD_CD " ).append("\n"); 
		query.append("         , RLANE_CD " ).append("\n"); 
		query.append("         , DIR_CD " ).append("\n"); 
		query.append("         , CTRT_OFC_CD " ).append("\n"); 
		query.append("         , SLS_OFC_CD " ).append("\n"); 
		query.append("         , DECODE(MAX(TOT_TEU), 0, MAX(CM_UC_AMT), ROUND(MAX(TOT_CPB)/MAX(TOT_TEU))) AS CM_UC_AMT " ).append("\n"); 
		query.append("         , DECODE(MAX(TOT_TEU), 0, MAX(GRS_RPB_REV), ROUND(MAX(TOT_RPB)/MAX(TOT_TEU))) AS GRS_RPB_REV " ).append("\n"); 
		query.append("      FROM " ).append("\n"); 
		query.append("           (SELECT MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                , ST_DT " ).append("\n"); 
		query.append("                , TRD_CD " ).append("\n"); 
		query.append("                , SUB_TRD_CD " ).append("\n"); 
		query.append("                , IOC_CD " ).append("\n"); 
		query.append("                , RLANE_CD " ).append("\n"); 
		query.append("                , DIR_CD " ).append("\n"); 
		query.append("                , CTRT_OFC_CD " ).append("\n"); 
		query.append("                , SLS_OFC_CD " ).append("\n"); 
		query.append("                , LOD_QTY " ).append("\n"); 
		query.append("                , CM_UC_AMT " ).append("\n"); 
		query.append("                , GRS_RPB_REV " ).append("\n"); 
		query.append("                , SUM(LOD_QTY) OVER (PARTITION BY MQTA_MDL_VER_NO, ST_DT, TRD_CD, SUB_TRD_CD, IOC_CD, RLANE_CD, DIR_CD ) AS TOT_TEU " ).append("\n"); 
		query.append("                , SUM(CM_UC_AMT * LOD_QTY) OVER (PARTITION BY MQTA_MDL_VER_NO, ST_DT, TRD_CD, SUB_TRD_CD, IOC_CD, RLANE_CD, DIR_CD ) AS TOT_CPB " ).append("\n"); 
		query.append("                , SUM(GRS_RPB_REV * LOD_QTY) OVER (PARTITION BY MQTA_MDL_VER_NO, ST_DT, TRD_CD, SUB_TRD_CD, IOC_CD, RLANE_CD, DIR_CD ) AS TOT_RPB " ).append("\n"); 
		query.append("             FROM SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append("            WHERE 1=1 " ).append("\n"); 
		query.append("                  AND MQTA_MDL_VER_NO = @[mqta_mdl_ver_no]" ).append("\n"); 
		query.append("                  AND CTRT_OFC_CD = @[chng_ctrt_ofc_cd] " ).append("\n"); 
		query.append("                  AND SLS_OFC_CD = @[chng_sls_ofc_cd] " ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("     GROUP BY MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("         , ST_DT " ).append("\n"); 
		query.append("         , TRD_CD " ).append("\n"); 
		query.append("         , SUB_TRD_CD " ).append("\n"); 
		query.append("         , IOC_CD" ).append("\n"); 
		query.append("         , RLANE_CD " ).append("\n"); 
		query.append("         , DIR_CD " ).append("\n"); 
		query.append("         , CTRT_OFC_CD " ).append("\n"); 
		query.append("         , SLS_OFC_CD " ).append("\n"); 
		query.append("    ) B " ).append("\n"); 
		query.append("ON (B.MQTA_MDL_VER_NO = A.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("    AND B.ST_DT = A.ST_DT " ).append("\n"); 
		query.append("    AND B.TRD_CD = A.TRD_CD " ).append("\n"); 
		query.append("    AND B.SUB_TRD_CD = A.SUB_TRD_CD " ).append("\n"); 
		query.append("    AND B.RLANE_CD = A.RLANE_CD " ).append("\n"); 
		query.append("    AND B.DIR_CD = A.DIR_CD " ).append("\n"); 
		query.append("    AND B.CTRT_OFC_CD = A.CTRT_OFC_CD " ).append("\n"); 
		query.append("    AND B.SLS_OFC_CD = A.SLS_OFC_CD) " ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("       UPDATE " ).append("\n"); 
		query.append("              SET A.CM_UC_AMT = B.CM_UC_AMT " ).append("\n"); 
		query.append("            , A.GRS_RPB_REV = B.GRS_RPB_REV " ).append("\n"); 
		query.append("            , UPD_USR_ID = @[user_id] " ).append("\n"); 
		query.append("            , UPD_DT = SYSDATE" ).append("\n"); 

	}
}