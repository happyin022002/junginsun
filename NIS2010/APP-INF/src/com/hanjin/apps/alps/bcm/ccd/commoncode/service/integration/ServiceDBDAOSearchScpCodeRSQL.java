/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ServiceDBDAOSearchScpCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOSearchScpCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * scp 코드 조회
	  * </pre>
	  */
	public ServiceDBDAOSearchScpCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOSearchScpCodeRSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("	  ,SVC_SCP_NM" ).append("\n"); 
		query.append("      ,SVC_SCP_BND_CD" ).append("\n"); 
		query.append("      ,CONF_FLG" ).append("\n"); 
		query.append("      ,FMC_FILE_FLG" ).append("\n"); 
		query.append("      ,TRF_PFX_CD" ).append("\n"); 
		query.append("      ,TRF_NO" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("	  --,MODI_COST_CTR_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      --,MODI_SVC_GRP_CD" ).append("\n"); 
		query.append("      --,DMNT_FLG" ).append("\n"); 
		query.append(" FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 

	}
}