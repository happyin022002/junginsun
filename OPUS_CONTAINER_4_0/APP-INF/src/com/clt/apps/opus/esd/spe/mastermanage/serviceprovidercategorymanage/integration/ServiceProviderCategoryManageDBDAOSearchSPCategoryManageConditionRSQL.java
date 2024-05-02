/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderCategoryManageDBDAOSearchSPCategoryManageConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.30 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceProviderCategoryManageDBDAOSearchSPCategoryManageConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSPCategoryManageCondition
	  * </pre>
	  */
	public ServiceProviderCategoryManageDBDAOSearchSPCategoryManageConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.integration").append("\n"); 
		query.append("FileName : ServiceProviderCategoryManageDBDAOSearchSPCategoryManageConditionRSQL").append("\n"); 
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
		query.append("''EG_CTY_CD," ).append("\n"); 
		query.append("''VNDR_SEQ," ).append("\n"); 
		query.append("''EG_RHQ_CD," ).append("\n"); 
		query.append("''VNDR_ABBR_NM," ).append("\n"); 
		query.append("''MAPPED," ).append("\n"); 
		query.append("''CHK_UNIQUE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}