/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ServiceDBDAOAddScpLimitCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.12 
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

public class ServiceDBDAOAddScpLimitCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * scp code limit 생성
	  * </pre>
	  */
	public ServiceDBDAOAddScpLimitCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_ind_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_sconti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOAddScpLimitCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_SVC_SCP_LMT" ).append("\n"); 
		query.append("           (SVC_SCP_CD" ).append("\n"); 
		query.append("		   ,SVC_SCP_SCNT" ).append("\n"); 
		query.append("           ,RGN_CD" ).append("\n"); 
		query.append("           ,ORG_DEST_CD" ).append("\n"); 
		query.append("           ,SVC_SCP_IND_FLG" ).append("\n"); 
		query.append("           ,DELT_FLG" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT" ).append("\n"); 
		query.append("           ,SVC_SCP_LMT_SEQ" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("VALUES(@[svc_scp_cd]" ).append("\n"); 
		query.append("	  ,@[svc_scp_sconti]" ).append("\n"); 
		query.append("      ,@[rgn_cd]" ).append("\n"); 
		query.append("      ,@[org_dest_cd]" ).append("\n"); 
		query.append("      ,@[svc_scp_ind_flg]" ).append("\n"); 
		query.append("      ,@[delt_flg]" ).append("\n"); 
		query.append("      ,@[user_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[user_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,(SELECT NVL(MAX(SVC_SCP_LMT_SEQ)+1 , 1)" ).append("\n"); 
		query.append("          FROM MDM_SVC_SCP_LMT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}