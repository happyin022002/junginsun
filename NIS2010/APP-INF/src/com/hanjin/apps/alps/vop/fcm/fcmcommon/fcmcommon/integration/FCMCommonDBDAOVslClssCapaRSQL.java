/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : FCMCommonDBDAOVslClssCapaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.fcmcommon.fcmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FCMCommonDBDAOVslClssCapaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM Vessel Class Capacity List를 조회한다.
	  * </pre>
	  */
	public FCMCommonDBDAOVslClssCapaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.fcmcommon.fcmcommon.integration").append("\n"); 
		query.append("FileName : FCMCommonDBDAOVslClssCapaRSQL").append("\n"); 
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
		query.append("WITH TMP AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    T1.CNTR_DZN_CAPA" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR T1" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND NVL(T1.VSL_CLSS_FLG, ' ')='N'" ).append("\n"); 
		query.append("    AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("    AND T1.FDR_DIV_CD='T'" ).append("\n"); 
		query.append("    AND T1.CRR_CD='SML'" ).append("\n"); 
		query.append("    AND T1.CNTR_DZN_CAPA IS NOT NULL" ).append("\n"); 
		query.append("    AND T1.VSL_CD IN (SELECT R.VSL_CD FROM FCM_VSL_CNTR_RGST R WHERE T1.VSL_CD = R.VSL_CD AND NVL(R.TRND_LINE_USE_FLG,' ')<>'N')" ).append("\n"); 
		query.append("    GROUP BY T1.CNTR_DZN_CAPA" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT MAX(CNTR_DZN_CAPA) CNTR_DZN_CAPA FROM (" ).append("\n"); 
		query.append("    SELECT SYS_CONNECT_BY_PATH(CNTR_DZN_CAPA, '|') CNTR_DZN_CAPA" ).append("\n"); 
		query.append("    FROM (SELECT CNTR_DZN_CAPA," ).append("\n"); 
		query.append("                 ROW_NUMBER() OVER(ORDER BY CNTR_DZN_CAPA) RNUM FROM TMP)" ).append("\n"); 
		query.append("    WHERE LEVEL = RNUM" ).append("\n"); 
		query.append("    START WITH RNUM=1" ).append("\n"); 
		query.append("    CONNECT BY PRIOR RNUM=RNUM-1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}