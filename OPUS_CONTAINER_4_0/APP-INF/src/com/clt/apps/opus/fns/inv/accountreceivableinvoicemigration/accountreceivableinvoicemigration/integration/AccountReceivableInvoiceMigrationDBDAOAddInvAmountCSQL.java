/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOAddInvAmountCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOAddInvAmountCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Inv Amount
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOAddInvAmountCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tj_src_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_inv_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("erp_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_coa_rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("erp_if_gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOAddInvAmountCSQL").append("\n"); 
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
		query.append("INSERT INTO OPUSADM_TMP.INV_AR_AMT(" ).append("\n"); 
		query.append("		AR_IF_NO" ).append("\n"); 
		query.append("	   ,AR_IF_SER_NO" ).append("\n"); 
		query.append("	   ,TJ_SRC_NM" ).append("\n"); 
		query.append("	   ,CURR_CD" ).append("\n"); 
		query.append("	   ,INV_AMT" ).append("\n"); 
		query.append("	   ,INV_ERP_IF_STS_CD" ).append("\n"); 
		query.append("	   ,ERP_IF_DT" ).append("\n"); 
		query.append("	   ,CRE_USR_ID" ).append("\n"); 
		query.append("	   ,CRE_DT" ).append("\n"); 
		query.append("	   ,UPD_USR_ID" ).append("\n"); 
		query.append("	   ,UPD_DT" ).append("\n"); 
		query.append("	   ,ERR_DESC" ).append("\n"); 
		query.append("	   ,AR_INV_SRC_CD" ).append("\n"); 
		query.append("	   ,INV_COA_CO_CD" ).append("\n"); 
		query.append("	   ,INV_COA_RGN_CD" ).append("\n"); 
		query.append("	   ,INV_COA_CTR_CD" ).append("\n"); 
		query.append("	   ,INV_COA_ACCT_CD" ).append("\n"); 
		query.append("	   ,INV_COA_INTER_CO_CD" ).append("\n"); 
		query.append("	   ,INV_COA_VSL_CD" ).append("\n"); 
		query.append("	   ,INV_COA_VOY_NO" ).append("\n"); 
		query.append("	   ,INV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append("	   ,INV_COA_REV_DIR_CD" ).append("\n"); 
		query.append("	   ,ERP_IF_GL_DT" ).append("\n"); 
		query.append("	   ,ERP_IF_OFC_CD" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("@[ar_if_no]" ).append("\n"); 
		query.append(",@[ar_if_ser_no]" ).append("\n"); 
		query.append(",@[tj_src_nm]" ).append("\n"); 
		query.append(",SUBSTR(@[curr_cd], 1, 3)" ).append("\n"); 
		query.append(",NVL(@[inv_amt], 0)" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[err_desc]" ).append("\n"); 
		query.append(",@[ar_inv_src_cd]" ).append("\n"); 
		query.append(",@[inv_coa_co_cd]" ).append("\n"); 
		query.append(",@[inv_coa_rgn_cd]" ).append("\n"); 
		query.append(",@[inv_coa_ctr_cd]" ).append("\n"); 
		query.append(",@[inv_coa_acct_cd]" ).append("\n"); 
		query.append(",@[inv_coa_inter_co_cd]" ).append("\n"); 
		query.append(",@[inv_coa_vsl_cd]" ).append("\n"); 
		query.append(",@[inv_coa_voy_no]" ).append("\n"); 
		query.append(",@[inv_coa_skd_dir_cd]" ).append("\n"); 
		query.append(",@[inv_coa_rev_dir_cd]" ).append("\n"); 
		query.append(",@[erp_if_gl_dt]" ).append("\n"); 
		query.append(",@[erp_if_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}