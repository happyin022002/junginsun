/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOAddInvoiceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalConsultationDBDAOAddInvoiceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert Invoice
	  * </pre>
	  */
	public RenewalConsultationDBDAOAddInvoiceCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvs_cmb_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rjct_cmb_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOAddInvoiceCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO JOO_INVOICE ( " ).append("\n"); 
		query.append("      ACCT_YRMON " ).append("\n"); 
		query.append("    , JO_CRR_CD " ).append("\n"); 
		query.append("    , INV_NO " ).append("\n"); 
		query.append("    , RE_DIVR_CD " ).append("\n"); 
		query.append("    , SLP_FUNC_CD" ).append("\n"); 
		query.append("    , SLP_OFC_CD  " ).append("\n"); 
		query.append("    , SLP_ISS_DT " ).append("\n"); 
		query.append("    , SLP_TP_CD " ).append("\n"); 
		query.append("    , SLP_SER_NO " ).append("\n"); 
		query.append("    , ACCTG_CRR_CD " ).append("\n"); 
		query.append("    , PRNR_REF_NO " ).append("\n"); 
		query.append("    , LOCL_CURR_CD" ).append("\n"); 
		query.append("    , ACT_AMT " ).append("\n"); 
		query.append("    , RVS_CMB_FLG " ).append("\n"); 
		query.append("    , RJCT_CMB_FLG " ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    ) VALUES ( " ).append("\n"); 
		query.append("      @[acct_yrmon]" ).append("\n"); 
		query.append("    , @[jo_crr_cd]" ).append("\n"); 
		query.append("    , @[inv_no]" ).append("\n"); 
		query.append("    , @[re_divr_cd]" ).append("\n"); 
		query.append("    , @[slp_func_cd]" ).append("\n"); 
		query.append("    , @[slp_ofc_cd]" ).append("\n"); 
		query.append("    , @[slp_iss_dt]" ).append("\n"); 
		query.append("    , @[slp_tp_cd]" ).append("\n"); 
		query.append("    , @[slp_ser_no]" ).append("\n"); 
		query.append("    , @[acctg_crr_cd]" ).append("\n"); 
		query.append("    , @[prnr_ref_no]" ).append("\n"); 
		query.append("    , @[locl_curr_cd]" ).append("\n"); 
		query.append("    , @[act_amt]" ).append("\n"); 
		query.append("    , @[rvs_cmb_flg]" ).append("\n"); 
		query.append("    , @[rjct_cmb_flg]" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}