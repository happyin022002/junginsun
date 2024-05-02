/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ArApprovalDBDAOSaveGWInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.12.26 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArApprovalDBDAOSaveGWInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GW Info History table insert
	  * </pre>
	  */
	public ArApprovalDBDAOSaveGWInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gw_apro_url_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gw_csr_rqst_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_jb_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_his_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gw_apro_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration").append("\n"); 
		query.append("FileName : ArApprovalDBDAOSaveGWInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO COM_AR_CSR_HIS(" ).append("\n"); 
		query.append("		COM_AR_CSR_APRO_HIS_SEQ, " ).append("\n"); 
		query.append("		CSR_NO, " ).append("\n"); 
		query.append("		CSR_APRO_TP_CD, " ).append("\n"); 
		query.append("		AUTO_MNL_FLG, " ).append("\n"); 
		query.append("		INV_STS_CD, " ).append("\n"); 
		query.append("		IO_BND_CD, " ).append("\n"); 
		query.append("		IF_DT, " ).append("\n"); 
		query.append("		GW_CSR_RQST_ID, " ).append("\n"); 
		query.append("		GW_APRO_URL_CTNT, " ).append("\n"); 
		query.append("		GW_APRO_RSLT_CD, " ).append("\n"); 
		query.append("		CORR_HIS_RMK, " ).append("\n"); 
		query.append("		CRE_USR_ID, " ).append("\n"); 
		query.append("		CRE_DT, " ).append("\n"); 
		query.append("		UPD_USR_ID, " ).append("\n"); 
		query.append("		UPD_DT," ).append("\n"); 
		query.append("		APRO_USR_ID, " ).append("\n"); 
		query.append("		APRO_USR_NM," ).append("\n"); 
		query.append("		APRO_USR_JB_TIT_NM," ).append("\n"); 
		query.append("		APRO_RMK )" ).append("\n"); 
		query.append("VALUES (COM_AP_CSR_APRO_HIS_SEQ.NEXTVAL," ).append("\n"); 
		query.append("        @[csr_no]," ).append("\n"); 
		query.append("        @[csr_apro_tp_cd]," ).append("\n"); 
		query.append("		@[auto_mnl_flg]," ).append("\n"); 
		query.append("		@[inv_sts_cd]," ).append("\n"); 
		query.append("		@[io_bnd_cd]," ).append("\n"); 
		query.append("		@[if_dt]," ).append("\n"); 
		query.append("		@[gw_csr_rqst_id]," ).append("\n"); 
		query.append("		@[gw_apro_url_ctnt]," ).append("\n"); 
		query.append("		@[gw_apro_rslt_cd]," ).append("\n"); 
		query.append("		@[corr_his_rmk]," ).append("\n"); 
		query.append("		@[cre_usr_id]," ).append("\n"); 
		query.append("		SYSDATE," ).append("\n"); 
		query.append("		@[upd_usr_id]," ).append("\n"); 
		query.append("		SYSDATE," ).append("\n"); 
		query.append("		@[apro_usr_id]," ).append("\n"); 
		query.append("		@[apro_usr_nm]," ).append("\n"); 
		query.append("		@[apro_usr_jb_tit_nm]," ).append("\n"); 
		query.append("		@[apro_rmk])" ).append("\n"); 

	}
}