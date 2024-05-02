/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ServiceDBDAOAddScpRqstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOAddScpRqstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request scp code 생성
	  * </pre>
	  */
	public ServiceDBDAOAddScpRqstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmc_file_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_svc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_cost_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmnt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOAddScpRqstCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_SVC_SCP_RQST" ).append("\n"); 
		query.append("           (RQST_NO" ).append("\n"); 
		query.append("		   ,SVC_SCP_CD" ).append("\n"); 
		query.append("           ,SVC_SCP_NM" ).append("\n"); 
		query.append("           ,SVC_SCP_BND_CD" ).append("\n"); 
		query.append("           ,CONF_FLG" ).append("\n"); 
		query.append("           ,FMC_FILE_FLG" ).append("\n"); 
		query.append("           ,TRF_PFX_CD" ).append("\n"); 
		query.append("           ,TRF_NO" ).append("\n"); 
		query.append("           ,DELT_FLG" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT" ).append("\n"); 
		query.append("           ,MODI_COST_CTR_CD" ).append("\n"); 
		query.append("           ,MODI_SVC_GRP_CD" ).append("\n"); 
		query.append("           ,DMNT_FLG" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("VALUES(@[rqst_no]" ).append("\n"); 
		query.append("	  ,@[svc_scp_cd]" ).append("\n"); 
		query.append("	  ,@[svc_scp_nm]" ).append("\n"); 
		query.append("      ,@[svc_scp_bnd_cd]" ).append("\n"); 
		query.append("      ,@[conf_flg]" ).append("\n"); 
		query.append("      ,@[fmc_file_flg]" ).append("\n"); 
		query.append("      ,@[trf_pfx_cd]" ).append("\n"); 
		query.append("      ,@[trf_no]" ).append("\n"); 
		query.append("      ,@[delt_flg]" ).append("\n"); 
		query.append("      ,@[user_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[user_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[modi_cost_ctr_cd]" ).append("\n"); 
		query.append("      ,@[modi_svc_grp_cd]" ).append("\n"); 
		query.append("      ,@[dmnt_flg]" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}