/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ServiceProviderRelationshipAttractivenessResultDBDAOSearchInputListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceProviderRelationshipAttractivenessResultDBDAOSearchInputListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회조건용 VO 생성
	  * </pre>
	  */
	public ServiceProviderRelationshipAttractivenessResultDBDAOSearchInputListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration").append("\n"); 
		query.append("FileName : ServiceProviderRelationshipAttractivenessResultDBDAOSearchInputListRSQL").append("\n"); 
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
		query.append("SELECT  '' AS F_EV_YR ," ).append("\n"); 
		query.append("'' AS F_EG_ID," ).append("\n"); 
		query.append("'' AS F_EG_RHQ_CD," ).append("\n"); 
		query.append("'' AS F_EG_CTY_CD," ).append("\n"); 
		query.append("'' AS F_SVC_CATE_CD," ).append("\n"); 
		query.append("'' AS F_MAPPING_DIV," ).append("\n"); 
		query.append("'' AS F_VNDR_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}