/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCARIssueTransferSlipManageCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.06
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.09.06 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOCARIssueTransferSlipManageCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CARIssueTransferSlipManageCommon
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCARIssueTransferSlipManageCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCARIssueTransferSlipManageCommonRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' fm_eff_dt," ).append("\n"); 
		query.append("'' to_eff_dt," ).append("\n"); 
		query.append("'' if_status," ).append("\n"); 
		query.append("'' dt_status," ).append("\n"); 
		query.append("'' search_csr_no," ).append("\n"); 
		query.append("'' ap_ofc_cd," ).append("\n"); 
		query.append("'' cnt_cd," ).append("\n"); 
		query.append("'' asa_no," ).append("\n"); 
		query.append("'' evi_gb," ).append("\n"); 
		query.append("'' chks," ).append("\n"); 
		query.append("'' asanogb," ).append("\n"); 
		query.append("'' gen_pay_term_cd," ).append("\n"); 
		query.append("'' asa_no," ).append("\n"); 
		query.append("'' max_iss_dt," ).append("\n"); 
		query.append("'' max_rcv_dt," ).append("\n"); 
		query.append("'' payment_due_dt," ).append("\n"); 
		query.append("'' evi_inv_dt," ).append("\n"); 
		query.append("'' s_evi_inv_dt," ).append("\n"); 
		query.append("'' evi_comp_no," ).append("\n"); 
		query.append("'' evi_total_net_amt," ).append("\n"); 
		query.append("'' evi_tax_no2," ).append("\n"); 
		query.append("'' evi_total_tax_amt," ).append("\n"); 
		query.append("'' evi_tax_no," ).append("\n"); 
		query.append("'' pay_group_cd," ).append("\n"); 
		query.append("'' gap," ).append("\n"); 
		query.append("'' inv_no2," ).append("\n"); 
		query.append("'' cost_cd," ).append("\n"); 
		query.append("'' total_amt," ).append("\n"); 
		query.append("'' apro_step," ).append("\n"); 
		query.append("'' inv_knt," ).append("\n"); 
		query.append("'' loc_cd," ).append("\n"); 
		query.append("'' acct_cd," ).append("\n"); 
		query.append("'' cntr_tpsz_cd," ).append("\n"); 
		query.append("'' comp_no," ).append("\n"); 
		query.append("'' tax_no1," ).append("\n"); 
		query.append("'' tax_no2," ).append("\n"); 
		query.append("'' cre_usr_id," ).append("\n"); 
		query.append("'' tax_type," ).append("\n"); 
		query.append("'' evi_tax_code," ).append("\n"); 
		query.append("'' evi_ctnt1," ).append("\n"); 
		query.append("'' evi_ctnt2," ).append("\n"); 
		query.append("'' evi_ctnt3," ).append("\n"); 
		query.append("'' evi_ctnt4," ).append("\n"); 
		query.append("'' evi_ctnt5," ).append("\n"); 
		query.append("'' evi_ctnt6," ).append("\n"); 
		query.append("'' evi_ctnt7," ).append("\n"); 
		query.append("'' evi_ctnt8," ).append("\n"); 
		query.append("'' evi_ctnt9," ).append("\n"); 
		query.append("'' evi_ctnt10," ).append("\n"); 
		query.append("'' evi_ctnt11," ).append("\n"); 
		query.append("'' evi_ctnt12," ).append("\n"); 
		query.append("'' evi_tax_no," ).append("\n"); 
		query.append("'' attr_ctnt8," ).append("\n"); 
		query.append("'' vndr_seq" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}