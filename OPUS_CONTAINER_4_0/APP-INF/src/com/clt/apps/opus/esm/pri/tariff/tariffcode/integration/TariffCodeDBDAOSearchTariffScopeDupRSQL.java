/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffCodeDBDAOSearchTariffScopeDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.22 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffcode.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffCodeDBDAOSearchTariffScopeDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTariffScopeDup
	  * </pre>
	  */
	public TariffCodeDBDAOSearchTariffScopeDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffcode.integration").append("\n"); 
		query.append("FileName : TariffCodeDBDAOSearchTariffScopeDupRSQL").append("\n"); 
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
		query.append("SELECT TRF_NO,SVC_SCP_CD,TRF_PFX_CD" ).append("\n"); 
		query.append("FROM PRI_SVC_SCP_TRF" ).append("\n"); 
		query.append("WHERE 	#if( $svc_scp_list.size() != 0 ) " ).append("\n"); 
		query.append("			(SVC_SCP_CD) IN (" ).append("\n"); 
		query.append("		#foreach( ${key} in ${svc_scp_list}) " ).append("\n"); 
		query.append("			#if($velocityCount != 1 ) " ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("					'$key'" ).append("\n"); 
		query.append("			FROM DUAL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end " ).append("\n"); 

	}
}