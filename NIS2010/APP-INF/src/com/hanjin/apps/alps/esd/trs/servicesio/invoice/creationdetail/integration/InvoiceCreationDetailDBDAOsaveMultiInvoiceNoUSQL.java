/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOsaveMultiInvoiceNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDetailDBDAOsaveMultiInvoiceNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi InvoiceNo Update
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOsaveMultiInvoiceNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_sys_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vat_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOsaveMultiInvoiceNoUSQL").append("\n"); 
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
		query.append("UPDATE trs_trsp_inv_wrk" ).append("\n"); 
		query.append("SET  trsp_inv_aud_sts_cd = @[trsp_inv_aud_sts_cd]" ).append("\n"); 
		query.append(",inv_curr_cd = @[inv_curr_cd]" ).append("\n"); 
		query.append(",inv_bzc_amt = @[inv_bzc_amt]" ).append("\n"); 
		query.append(",inv_vat_amt = to_number(nvl(@[inv_vat_amt],'0'))" ).append("\n"); 
		query.append(",inv_ttl_amt = @[inv_ttl_amt]" ).append("\n"); 
		query.append(",inv_rcv_dt = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((select ofc_cd from mdm_vendor where vndr_seq = @[vndr_seq]))" ).append("\n"); 
		query.append(",inv_iss_dt = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((select ofc_cd from mdm_vendor where vndr_seq = @[vndr_seq]))" ).append("\n"); 
		query.append(",if_sys_knd_cd = @[if_sys_knd_cd]" ).append("\n"); 
		query.append(",upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append(",prov_usr_id = @[prov_usr_id]" ).append("\n"); 
		query.append(",prov_phn_no = @[prov_phn_no]" ).append("\n"); 
		query.append(",upd_dt = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((select ofc_cd from mdm_vendor where vndr_seq = @[vndr_seq]))" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND inv_no = @[inv_no]" ).append("\n"); 
		query.append("AND inv_vndr_seq = @[inv_vndr_seq]" ).append("\n"); 

	}
}