/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ServiceProviderRelationshipAttractivenessResultDBDAOSpeRltAtrcRsltAddRSQL.java
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

public class ServiceProviderRelationshipAttractivenessResultDBDAOSpeRltAtrcRsltAddRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpeRltAtrcRsltVO에 eg_id 추가
	  * </pre>
	  */
	public ServiceProviderRelationshipAttractivenessResultDBDAOSpeRltAtrcRsltAddRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration").append("\n"); 
		query.append("FileName : ServiceProviderRelationshipAttractivenessResultDBDAOSpeRltAtrcRsltAddRSQL").append("\n"); 
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
		query.append("'' AS VNDR_SEQ," ).append("\n"); 
		query.append("'' AS EV_YR," ).append("\n"); 
		query.append("'' AS ATRC_TO_HJS_SCRE," ).append("\n"); 
		query.append("'' AS ATRC_TO_SP_SCRE," ).append("\n"); 
		query.append("'' AS RA_SCRE," ).append("\n"); 
		query.append("'' AS RA_GRP_CD," ).append("\n"); 
		query.append("'' AS RA_GRP_NM," ).append("\n"); 
		query.append("'' AS CRE_USR_ID," ).append("\n"); 
		query.append("'' AS CRE_DT," ).append("\n"); 
		query.append("'' AS UPD_USR_ID," ).append("\n"); 
		query.append("'' AS UPD_DT," ).append("\n"); 
		query.append("'' AS EG_ID," ).append("\n"); 
		query.append("'' AS EG_ID_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}