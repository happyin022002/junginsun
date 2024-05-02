/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PRICommonDataDBDAORsltServiceScopePropertyMappingVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 김성훈
*@LastVersion : 1.0
* 2012.04.24 김성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung Hun Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDataDBDAORsltServiceScopePropertyMappingVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.04.17
	  * </pre>
	  */
	public PRICommonDataDBDAORsltServiceScopePropertyMappingVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_ppt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration").append("\n"); 
		query.append("FileName : PRICommonDataDBDAORsltServiceScopePropertyMappingVORSQL").append("\n"); 
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
		query.append("SELECT    MAPG.SVC_SCP_CD" ).append("\n"); 
		query.append("		, MAPG.SVC_SCP_PPT_CD" ).append("\n"); 
		query.append("		, PPT.SVC_SCP_PPT_DESC" ).append("\n"); 
		query.append("  FROM 	 PRI_SVC_SCP_PPT_MAPG MAPG" ).append("\n"); 
		query.append("		,PRI_SVC_SCP_PPT PPT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND MAPG.SVC_SCP_PPT_CD = PPT.SVC_SCP_PPT_CD(+)" ).append("\n"); 
		query.append("#if(${svc_scp_cd} != '') " ).append("\n"); 
		query.append("   AND MAPG.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${svc_scp_ppt_cd} != '') " ).append("\n"); 
		query.append("   AND MAPG.SVC_SCP_PPT_CD = @[svc_scp_ppt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}