/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOSearchNotifyCheckRSQL.java
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

public class MonthlyQuotaCreationDBDAOSearchNotifyCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Notify 대상중 confirm 되지 않은 건수가 있는지 조회 한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOSearchNotifyCheckRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOSearchNotifyCheckRSQL").append("\n"); 
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
		query.append("SELECT NVL(LISTAGG(TXT, ',') WITHIN GROUP(ORDER BY MQTA_MDL_VER_NO), 'F') AS CHK_TXT " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT '['||T1.TRD_CD||' '||T1.RLANE_CD||' '||T1.DIR_CD||' '||T1.IOC_CD||']' AS TXT " ).append("\n"); 
		query.append("            , MAX(T1.MQTA_MDL_VER_NO) AS MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("         FROM SAQ_MON_FCAST_TRNS T1 " ).append("\n"); 
		query.append("            , SAQ_TGT_GRP_TRD T2 " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND T1.TRD_CD = T2.TRD_CD " ).append("\n"); 
		query.append("              AND T1.SUB_TRD_CD = T2.SUB_TRD_CD " ).append("\n"); 
		query.append("              AND T1.DIR_CD = T2.DIR_CD " ).append("\n"); 
		query.append("              AND T1.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no] " ).append("\n"); 
		query.append("              AND T1.FCAST_TRNS_STS_CD = '0' " ).append("\n"); 
		query.append("        GROUP BY T1.TRD_CD " ).append("\n"); 
		query.append("            , T1.RLANE_CD " ).append("\n"); 
		query.append("            , T1.DIR_CD " ).append("\n"); 
		query.append("            , T1.IOC_CD " ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}