/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOUpdateNotifyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.01 
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

public class MonthlyQuotaCreationDBDAOUpdateNotifyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 버전을 Notify 한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOUpdateNotifyUSQL(){
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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOUpdateNotifyUSQL").append("\n"); 
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
		query.append("USING" ).append("\n"); 
		query.append("    (SELECT T1.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("         , T1.TRD_CD " ).append("\n"); 
		query.append("         , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("         , T1.DIR_CD " ).append("\n"); 
		query.append("      FROM SAQ_MON_FCAST_TRNS T1 " ).append("\n"); 
		query.append("         , SAQ_TGT_GRP_TRD T2 " ).append("\n"); 
		query.append("     WHERE 1=1 " ).append("\n"); 
		query.append("           AND T1.TRD_CD = T2.TRD_CD " ).append("\n"); 
		query.append("           AND T1.SUB_TRD_CD = T2.SUB_TRD_CD " ).append("\n"); 
		query.append("           AND T1.DIR_CD = T2.DIR_CD " ).append("\n"); 
		query.append("           AND T1.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no] " ).append("\n"); 
		query.append("     GROUP BY T1.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("         , T1.TRD_CD " ).append("\n"); 
		query.append("         , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("         , T1.DIR_CD " ).append("\n"); 
		query.append("    ) B " ).append("\n"); 
		query.append("ON (B.MQTA_MDL_VER_NO = A.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("      AND B.TRD_CD = A.TRD_CD " ).append("\n"); 
		query.append("      AND B.SUB_TRD_CD = A.SUB_TRD_CD " ).append("\n"); 
		query.append("      AND B.DIR_CD = A.DIR_CD ) " ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("       UPDATE " ).append("\n"); 
		query.append("              SET A.FCAST_TRNS_STS_CD = 'N' " ).append("\n"); 
		query.append("            , A.UPD_USR_ID = @[user_id] " ).append("\n"); 
		query.append("            , A.UPD_DT = SYSDATE " ).append("\n"); 
		query.append("     " ).append("\n"); 

	}
}