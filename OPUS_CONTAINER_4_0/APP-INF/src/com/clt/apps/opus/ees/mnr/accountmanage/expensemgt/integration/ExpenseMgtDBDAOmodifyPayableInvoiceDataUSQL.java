/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExpenseMgtDBDAOmodifyPayableInvoiceDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.15
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.15 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOmodifyPayableInvoiceDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExpenseMgtDBDAOmodifyPayableInvoiceDataUSQL
	  * </pre>
	  */
	public ExpenseMgtDBDAOmodifyPayableInvoiceDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whld_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOmodifyPayableInvoiceDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_PAY_INV_WRK SET" ).append("\n"); 
		query.append("INV_NO = @[inv_no]" ).append("\n"); 
		query.append(",ISS_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append(",MNR_INV_STS_CD = @[mnr_inv_sts_cd]" ).append("\n"); 
		query.append(",MNR_PRNR_SEQ = TO_NUMBER(@[mnr_prnr_seq])" ).append("\n"); 
		query.append(",BZC_AMT = REPLACE (NVL(@[bzc_amt],'0'), ',', '')" ).append("\n"); 
		query.append(",VAT_AMT = REPLACE (NVL(@[vat_amt],'0'), ',', '')" ).append("\n"); 
		query.append(",SLS_TAX_AMT = REPLACE (NVL(@[sls_tax_amt],'0'), ',', '')" ).append("\n"); 
		query.append(",WHLD_TAX_AMT = REPLACE (NVL(@[whld_tax_amt],'0'), ',', '')" ).append("\n"); 
		query.append(",TTL_AMT = REPLACE (NVL(@[ttl_amt],'0'), ',', '')" ).append("\n"); 
		query.append("#if (${mnr_inv_sts_cd} == 'HC')" ).append("\n"); 
		query.append(",INV_CFM_DT = sysdate" ).append("\n"); 
		query.append(",CFM_DT = sysdate" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append(",ISS_DT = TO_DATE(@[iss_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",RCV_DT = TO_DATE(@[rcv_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",EFF_DT = TO_DATE(@[eff_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",TTL_LSS_DIV_CD = @[ttl_lss_div_cd]" ).append("\n"); 
		query.append(",INV_RGST_NO = @[inv_rgst_no]" ).append("\n"); 
		query.append(",MNR_INV_RMK = @[mnr_inv_rmk]" ).append("\n"); 
		query.append(",UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append(",UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 

	}
}