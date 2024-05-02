/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOModifyAuditResultUpdateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOModifyAuditResultUpdateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 데이터를 CGM_LSE_CHG_DTL에 update
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOModifyAuditResultUpdateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_pay_chg_cmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_pay_chg_cr_due_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_pay_chg_cr_sty_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lse_chg_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("updt_key",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lse_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_pay_chg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOModifyAuditResultUpdateUSQL").append("\n"); 
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
		query.append("UPDATE CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	PAY_LSE_CHG_STS_CD = 'C'," ).append("\n"); 
		query.append("	INV_LSE_CHG_AMT             = @[inv_lse_chg_amt]," ).append("\n"); 
		query.append("	INV_TAX_AMT                 = @[inv_tax_amt]," ).append("\n"); 
		query.append("	INV_CR_AMT                  = @[inv_cr_amt]," ).append("\n"); 
		query.append("	INV_LSE_CHG_TTL_AMT         = @[inv_lse_chg_ttl_amt]," ).append("\n"); 
		query.append("	PAY_LSE_CHG_AMT             = @[inv_lse_chg_amt]," ).append("\n"); 
		query.append("	PAY_TAX_AMT                 = @[inv_tax_amt]," ).append("\n"); 
		query.append("	PAY_CR_AMT                  = @[inv_cr_amt]," ).append("\n"); 
		query.append("	PAY_LSE_CHG_TTL_AMT         = @[inv_lse_chg_ttl_amt]," ).append("\n"); 
		query.append("	VNDR_PAY_CHG_RMK            = @[vndr_pay_chg_rmk]," ).append("\n"); 
		query.append("	VNDR_PAY_CHG_CMT_CTNT       = @[vndr_pay_chg_cmt_ctnt]," ).append("\n"); 
		query.append("	VNDR_PAY_CHG_CR_STY_CTNT    = @[vndr_pay_chg_cr_sty_ctnt]," ).append("\n"); 
		query.append("	VNDR_PAY_CHG_CR_DUE_CTNT    = @[vndr_pay_chg_cr_due_ctnt]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	ROWID = @[updt_key]" ).append("\n"); 

	}
}