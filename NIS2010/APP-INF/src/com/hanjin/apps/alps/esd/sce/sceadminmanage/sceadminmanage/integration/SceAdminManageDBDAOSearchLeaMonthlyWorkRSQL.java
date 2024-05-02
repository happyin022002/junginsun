/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SceAdminManageDBDAOSearchLeaMonthlyWorkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOSearchLeaMonthlyWorkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lea 월말 결산 작업
	  * </pre>
	  */
	public SceAdminManageDBDAOSearchLeaMonthlyWorkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOSearchLeaMonthlyWorkRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' as BKG_NO," ).append("\n"); 
		query.append("'' as CNTR_NO," ).append("\n"); 
		query.append("'' as COP_NO," ).append("\n"); 
		query.append("'' as COST_ACT_GRP_CD," ).append("\n"); 
		query.append("'' as COST_ACT_GRP_TP_CD," ).append("\n"); 
		query.append("'' as TRSP_SO_SEQ," ).append("\n"); 
		query.append("'' as COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("'' as CRE_USR_ID," ).append("\n"); 
		query.append("'' as CRE_DT," ).append("\n"); 
		query.append("'' as UPD_USR_ID," ).append("\n"); 
		query.append("'' as UPD_DT" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}