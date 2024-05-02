/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOsearchDodInvoiceMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : Jeong-Seon, AN
*@LastVersion : 1.0
* 2014.05.22 Jeong-Seon, AN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong-Seon, AN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOsearchDodInvoiceMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDodInvoiceMain
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOsearchDodInvoiceMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dod_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOsearchDodInvoiceMainRSQL").append("\n"); 
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
		query.append("SELECT dod_inv_no" ).append("\n"); 
		query.append(",bkg_no" ).append("\n"); 
		query.append(",bl_no" ).append("\n"); 
		query.append(",cust_cnt_cd" ).append("\n"); 
		query.append(",cust_seq" ).append("\n"); 
		query.append(",cntc_pnt_nm" ).append("\n"); 
		query.append(",cntc_pnt_phn_no" ).append("\n"); 
		query.append(",cntc_pnt_fax_no" ).append("\n"); 
		query.append(",cntc_pnt_eml" ).append("\n"); 
		query.append(",cust_cntc_pnt_seq" ).append("\n"); 
		query.append(",pod_cd" ).append("\n"); 
		query.append(",del_cd" ).append("\n"); 
		query.append(",bkg_de_term_cd" ).append("\n"); 
		query.append(",inv_curr_cd" ).append("\n"); 
		query.append(",ttl_inv_amt" ).append("\n"); 
		query.append(",cre_ofc_cd" ).append("\n"); 
		query.append(",dod_inv_sts_cd" ).append("\n"); 
		query.append(",cxl_dt" ).append("\n"); 
		query.append(",cxl_usr_id" ).append("\n"); 
		query.append(",ar_if_flg" ).append("\n"); 
		query.append(",TO_CHAR(ar_if_dt,'YYYYMMDDHH24MM') ar_if_dt" ).append("\n"); 
		query.append(",ar_if_usr_id" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",TO_CHAR(cre_dt,'YYYYMMDDHH24MM') cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append(",ar_if_no" ).append("\n"); 
		query.append(",cn_ref_inv_no" ).append("\n"); 
		query.append("FROM EAS_DOD_INV_MN" ).append("\n"); 
		query.append("WHERE dod_inv_no = @[dod_inv_no]" ).append("\n"); 

	}
}