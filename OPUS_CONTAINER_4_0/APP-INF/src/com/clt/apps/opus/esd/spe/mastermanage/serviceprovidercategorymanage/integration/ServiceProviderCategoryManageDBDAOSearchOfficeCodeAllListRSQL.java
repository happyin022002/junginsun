/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ServiceProviderCategoryManageDBDAOSearchOfficeCodeAllListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
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

public class ServiceProviderCategoryManageDBDAOSearchOfficeCodeAllListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfficeCodeAllList
	  * </pre>
	  */
	public ServiceProviderCategoryManageDBDAOSearchOfficeCodeAllListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.integration").append("\n"); 
		query.append("FileName : ServiceProviderCategoryManageDBDAOSearchOfficeCodeAllListRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_CD," ).append("\n"); 
		query.append("DECODE(B.CONTI_CD, 'F', 'HAM','E','HAM','M','NYC','A',DECODE(SUBSTR(A.AR_HD_QTR_OFC_CD,1,3),'SIN','SIN','SHA')) REG_GROUP" ).append("\n"); 
		query.append("FROM  MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND  A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("ORDER BY REG_GROUP,OFC_CD" ).append("\n"); 

	}
}