/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WriteOffMgtDBDAOaddWriteOffRequestHeaderDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WriteOffMgtDBDAOaddWriteOffRequestHeaderDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public WriteOffMgtDBDAOaddWriteOffRequestHeaderDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_file_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrtf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpc_clt_fald_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcvr_act_his_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_dtl_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : WriteOffMgtDBDAOaddWriteOffRequestHeaderDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_WRTF_RQST_HDR(" ).append("\n"); 
		query.append("WRTF_NO," ).append("\n"); 
		query.append("WRTF_STS_CD," ).append("\n"); 
		query.append("TTL_LSS_NO," ).append("\n"); 
		query.append("WRTF_RQST_DT," ).append("\n"); 
		query.append("WRTF_RQST_OFC_CD," ).append("\n"); 
		query.append("WRTF_RQST_USR_ID," ).append("\n"); 
		query.append("WRTF_APRO_DT," ).append("\n"); 
		query.append("WRTF_APRO_OFC_CD," ).append("\n"); 
		query.append("WRTF_APRO_USR_ID," ).append("\n"); 
		query.append("WRTF_CFM_DT," ).append("\n"); 
		query.append("WRTF_CFM_OFC_CD," ).append("\n"); 
		query.append("WRTF_CFM_USR_ID," ).append("\n"); 
		query.append("TTL_LSS_DTL_RSN_RMK," ).append("\n"); 
		query.append("DPC_CLT_FALD_RSN_RMK," ).append("\n"); 
		query.append("RCVR_ACT_HIS_RMK," ).append("\n"); 
		query.append("FILE_SEQ," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[wrtf_no]," ).append("\n"); 
		query.append("'RS'," ).append("\n"); 
		query.append("@[ttl_lss_no]," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("@[ttl_lss_dtl_rsn_rmk]," ).append("\n"); 
		query.append("@[dpc_clt_fald_rsn_rmk]," ).append("\n"); 
		query.append("@[rcvr_act_his_rmk]," ).append("\n"); 
		query.append("@[sub_file_seq]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}