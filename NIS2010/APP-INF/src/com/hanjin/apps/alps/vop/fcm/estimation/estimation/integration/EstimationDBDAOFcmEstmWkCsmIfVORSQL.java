/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EstimationDBDAOFcmEstmWkCsmIfVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.14 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationDBDAOFcmEstmWkCsmIfVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주간 추정 대상 항차를 조회한다.
	  * </pre>
	  */
	public EstimationDBDAOFcmEstmWkCsmIfVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration").append("\n"); 
		query.append("FileName : EstimationDBDAOFcmEstmWkCsmIfVORSQL").append("\n"); 
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
		query.append("/**" ).append("\n"); 
		query.append("--FcmEstmWkCsmIfVO" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' VSL_SLAN_CD," ).append("\n"); 
		query.append("'' TRD_CD," ).append("\n"); 
		query.append("'' SUB_TRD_CD," ).append("\n"); 
		query.append("'' BSE_YRMON," ).append("\n"); 
		query.append("'' BSE_WK," ).append("\n"); 
		query.append("'' VSL_CD," ).append("\n"); 
		query.append("'' SKD_VOY_NO," ).append("\n"); 
		query.append("'' SKD_DIR_CD," ).append("\n"); 
		query.append("'' FCM_ESTM_WRK_DT," ).append("\n"); 
		query.append("'' FCM_ESTM_WRK_SEQ," ).append("\n"); 
		query.append("'' FOIL_ESTM_CSM_WGT," ).append("\n"); 
		query.append("'' DOIL_ESTM_CSM_WGT," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' CRE_DT," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("'' UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("**/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("T1.*," ).append("\n"); 
		query.append("(SELECT VSL_SLAN_CD FROM VSK_VSL_SKD" ).append("\n"); 
		query.append(" WHERE T1.VSL_CD=VSL_CD" ).append("\n"); 
		query.append(" AND T1.SKD_VOY_NO=SKD_VOY_NO" ).append("\n"); 
		query.append(" AND T1.SKD_DIR_CD=SKD_DIR_CD) VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM FCM_ESTM_WK_CSM_IF T1" ).append("\n"); 
		query.append("WHERE (BSE_YRMON, BSE_WK, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, FCM_ESTM_WRK_DT||LPAD(FCM_ESTM_WRK_SEQ, 3, '0')) IN (" ).append("\n"); 
		query.append("    SELECT BSE_YRMON, BSE_WK, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, MAX(FCM_ESTM_WRK_DT||LPAD(FCM_ESTM_WRK_SEQ, 3, '0')) WRK_SEQ" ).append("\n"); 
		query.append("    FROM FCM_ESTM_WK_CSM_IF T1" ).append("\n"); 
		query.append("    WHERE SUBSTR(BSE_YRMON, 1, 4)=@[bse_yrmon]" ).append("\n"); 
		query.append("    AND BSE_WK=@[bse_wk]" ).append("\n"); 
		query.append("    GROUP BY BSE_YRMON, BSE_WK, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}