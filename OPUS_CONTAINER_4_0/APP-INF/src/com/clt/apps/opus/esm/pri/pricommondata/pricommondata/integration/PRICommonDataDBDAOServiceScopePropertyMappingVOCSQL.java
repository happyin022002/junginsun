/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PRICommonDataDBDAOServiceScopePropertyMappingVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.17
*@LastModifier : 김성훈
*@LastVersion : 1.0
* 2012.04.17 김성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung Hun Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDataDBDAOServiceScopePropertyMappingVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.04.17 SHKIM
	  * </pre>
	  */
	public PRICommonDataDBDAOServiceScopePropertyMappingVOCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration ").append("\n"); 
		query.append("FileName : PRICommonDataDBDAOServiceScopePropertyMappingVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SVC_SCP_PPT_MAPG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	  SVC_SCP_CD" ).append("\n"); 
		query.append("	, SVC_SCP_PPT_CD" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	 @[svc_scp_cd]" ).append("\n"); 
		query.append("    , @[svc_scp_ppt_cd]" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[upd_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}