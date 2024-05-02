/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SPCManageDBDAODailyBatchConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.03.25 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAODailyBatchConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DailyBatch 조건
	  * </pre>
	  */
	public SPCManageDBDAODailyBatchConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAODailyBatchConditionRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	        '' AS P_YEAR," ).append("\n"); 
		query.append("			'' AS P_WEEK," ).append("\n"); 
		query.append("			'' AS P_DURATION," ).append("\n"); 
		query.append("			'' AS P_STEP," ).append("\n"); 
		query.append("			'' AS P_ONLY_STEP," ).append("\n"); 
		query.append("			'' AS P_BSA," ).append("\n"); 
		query.append("			'' AS P_TRD_CD," ).append("\n"); 
		query.append("			'' AS P_RLANE_CD," ).append("\n"); 
		query.append("			'' AS P_IOC_CD," ).append("\n"); 
		query.append("			'' AS P_VSL_CD," ).append("\n"); 
		query.append("			'' AS P_SKD_VOY_NO," ).append("\n"); 
		query.append("			'' AS P_DIR_CD," ).append("\n"); 
		query.append("			'' AS P_USER_ID," ).append("\n"); 
		query.append("			'' AS P_ERR_CD," ).append("\n"); 
		query.append("			'' AS P_ERR_MSG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}