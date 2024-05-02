/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOSearchCPBAdjustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
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

public class MonthlyQuotaCreationDBDAOSearchCPBAdjustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 버전의 CPB Adjust Data를 조회한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOSearchCPBAdjustRSQL(){
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
		params.put("mqta_mdl_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOSearchCPBAdjustRSQL").append("\n"); 
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
		query.append("SELECT T1.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("     , T1.TRD_CD " ).append("\n"); 
		query.append("     , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("     , T1.IOC_CD " ).append("\n"); 
		query.append("     , T1.RLANE_CD " ).append("\n"); 
		query.append("     , T1.DIR_CD " ).append("\n"); 
		query.append("     , MAX(T1.CTRT_RHQ_CD) AS CTRT_RHQ_CD " ).append("\n"); 
		query.append("     , MAX(T1.CTRT_AQ_CD) AS CTRT_AQ_CD " ).append("\n"); 
		query.append("     , T1.CTRT_OFC_CD  " ).append("\n"); 
		query.append("     , MAX(T1.SLS_RHQ_CD) AS SLS_RHQ_CD " ).append("\n"); 
		query.append("     , MAX(T1.SLS_AQ_CD) AS SLS_AQ_CD " ).append("\n"); 
		query.append("     , T1.SLS_OFC_CD        " ).append("\n"); 
		query.append("     , MAX(T1.ORG_CM_UC_AMT) AS CM_UC_AMT " ).append("\n"); 
		query.append("     , MAX(T1.CM_UC_AMT) AS CHNG_CM_UC_AMT " ).append("\n"); 
		query.append("  FROM SAQ_MON_FCAST_TRNS T1 " ).append("\n"); 
		query.append("     , SAQ_TGT_GRP_TRD T2  " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND T1.TRD_CD = T2.TRD_CD " ).append("\n"); 
		query.append("       AND T1.SUB_TRD_CD = T2.SUB_TRD_CD " ).append("\n"); 
		query.append("       AND T1.DIR_CD = T2.DIR_CD " ).append("\n"); 
		query.append("       AND T1.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no] " ).append("\n"); 
		query.append("       AND (T1.FCAST_TRNS_STS_CD = '0' OR T1.FCAST_TRNS_STS_CD IS NULL)" ).append("\n"); 
		query.append("      #if(${trade} != '' && ${trade} != 'ALL')" ).append("\n"); 
		query.append("        AND T1.TRD_CD     = @[trade] " ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      #if(${bound} != '' && ${bound} != 'ALL')                                                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("        AND T1.DIR_CD     = @[bound]  " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(" GROUP BY T1.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("     , T1.TRD_CD " ).append("\n"); 
		query.append("     , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("     , T1.IOC_CD " ).append("\n"); 
		query.append("     , T1.RLANE_CD " ).append("\n"); 
		query.append("     , T1.DIR_CD " ).append("\n"); 
		query.append("     , T1.CTRT_OFC_CD" ).append("\n"); 
		query.append("     , T1.SLS_OFC_CD" ).append("\n"); 
		query.append(" ORDER BY T1.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("     , T1.TRD_CD " ).append("\n"); 
		query.append("     , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("     , T1.IOC_CD " ).append("\n"); 
		query.append("     , T1.RLANE_CD " ).append("\n"); 
		query.append("     , T1.DIR_CD " ).append("\n"); 
		query.append("     , T1.CTRT_OFC_CD" ).append("\n"); 
		query.append("     , T1.SLS_OFC_CD" ).append("\n"); 

	}
}