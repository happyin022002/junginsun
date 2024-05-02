/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchInvoiceSettingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchInvoiceSettingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB -> TPB Process -> TPB Invoice Setting
	  * Retrieve 기능
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchInvoiceSettingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchInvoiceSettingRSQL").append("\n"); 
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
		query.append("SELECT inv_iss_ofc_cd" ).append("\n"); 
		query.append("      ,co_nm" ).append("\n"); 
		query.append("      ,ofc_addr" ).append("\n"); 
		query.append("      ,ofc_phn_no" ).append("\n"); 
		query.append("      ,ofc_fax_no" ).append("\n"); 
		query.append("      ,bil_to_loc_div_cd" ).append("\n"); 
		query.append("      ,inv_rmk1" ).append("\n"); 
		query.append("      ,inv_rmk2" ).append("\n"); 
		query.append("      ,vat_xch_rt" ).append("\n"); 
		query.append("      ,vat_xch_rt / 100 vat_xch_rt_div" ).append("\n"); 
		query.append("  FROM TPB_INV_SH_SET" ).append("\n"); 
		query.append(" WHERE inv_iss_ofc_cd = @[s_inv_iss_ofc_cd]  " ).append("\n"); 

	}
}