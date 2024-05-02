/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOSearchCOfcVerifyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.10 
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

public class MonthlyQuotaCreationDBDAOSearchCOfcVerifyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 버전의 Contract Office중 유효하지 않은 Office를 조회한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOSearchCOfcVerifyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : MonthlyQuotaCreationDBDAOSearchCOfcVerifyRSQL").append("\n"); 
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
		query.append("SELECT MQTA_MDL_VER_NO     " ).append("\n"); 
		query.append("     , CTRT_RHQ_CD " ).append("\n"); 
		query.append("     , CTRT_OFC_CD " ).append("\n"); 
		query.append("     , SLS_RHQ_CD " ).append("\n"); 
		query.append("     , SLS_OFC_CD " ).append("\n"); 
		query.append("     , MAX(CTRT_FLG) AS CTRT_FLG " ).append("\n"); 
		query.append("     , MAX(SLS_FLG) AS SLS_FLG " ).append("\n"); 
		query.append("	 , DECODE(MAX(CTRT_FLG), 'Y', '', CTRT_OFC_CD) AS CHNG_CTRT_OFC_CD " ).append("\n"); 
		query.append("	 , DECODE(MAX(SLS_FLG), 'Y', '', SLS_OFC_CD) AS CHNG_SLS_OFC_CD" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT T1.MQTA_MDL_VER_NO           " ).append("\n"); 
		query.append("            , T1.CTRT_RHQ_CD " ).append("\n"); 
		query.append("            , T1.CTRT_OFC_CD " ).append("\n"); 
		query.append("            , T1.SLS_RHQ_CD " ).append("\n"); 
		query.append("            , T1.SLS_OFC_CD " ).append("\n"); 
		query.append("            , 'Y' AS CTRT_FLG " ).append("\n"); 
		query.append("            , '' AS SLS_FLG " ).append("\n"); 
		query.append("         FROM SAQ_MON_FCAST_TRNS T1 " ).append("\n"); 
		query.append("            , SAQ_ORGANIZATION_V T2 " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND T1.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no] " ).append("\n"); 
		query.append("              AND T1.CTRT_OFC_CD = T2.OFC_CD (+) " ).append("\n"); 
		query.append("              AND 'N' = T2.DELT_FLG (+) " ).append("\n"); 
		query.append("              AND T2.OFC_CD IS NULL " ).append("\n"); 
		query.append("              AND " ).append("\n"); 
		query.append("              ( " ).append("\n"); 
		query.append("                  T1.FCAST_TRNS_STS_CD = '0' " ).append("\n"); 
		query.append("                  OR T1.FCAST_TRNS_STS_CD IS NULL " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("              #if(${trd_cd} != '') " ).append("\n"); 
		query.append("              AND T1.TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("              #if(${bound} != '') " ).append("\n"); 
		query.append("              AND T1.DIR_CD = @[bound] " ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("           UNION ALL " ).append("\n"); 
		query.append("       SELECT T1.MQTA_MDL_VER_NO            " ).append("\n"); 
		query.append("            , T1.CTRT_RHQ_CD " ).append("\n"); 
		query.append("            , T1.CTRT_OFC_CD " ).append("\n"); 
		query.append("            , T1.SLS_RHQ_CD " ).append("\n"); 
		query.append("            , T1.SLS_OFC_CD " ).append("\n"); 
		query.append("            , '' AS CTRT_FLG " ).append("\n"); 
		query.append("            , 'Y' AS SLS_FLG " ).append("\n"); 
		query.append("         FROM SAQ_MON_FCAST_TRNS T1 " ).append("\n"); 
		query.append("            , SAQ_ORGANIZATION_V T2 " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND T1.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no] " ).append("\n"); 
		query.append("              AND T1.SLS_OFC_CD = T2.OFC_CD (+) " ).append("\n"); 
		query.append("              AND 'N' = T2.DELT_FLG (+) " ).append("\n"); 
		query.append("              AND T2.OFC_CD IS NULL " ).append("\n"); 
		query.append("              AND " ).append("\n"); 
		query.append("              ( " ).append("\n"); 
		query.append("                  T1.FCAST_TRNS_STS_CD = '0' " ).append("\n"); 
		query.append("                  OR T1.FCAST_TRNS_STS_CD IS NULL " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("              #if(${trd_cd} != '') " ).append("\n"); 
		query.append("              AND T1.TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("              #if(${bound} != '') " ).append("\n"); 
		query.append("              AND T1.DIR_CD = @[bound] " ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append(" GROUP BY MQTA_MDL_VER_NO      " ).append("\n"); 
		query.append("     , CTRT_RHQ_CD " ).append("\n"); 
		query.append("     , CTRT_OFC_CD " ).append("\n"); 
		query.append("     , SLS_RHQ_CD " ).append("\n"); 
		query.append("     , SLS_OFC_CD" ).append("\n"); 

	}
}