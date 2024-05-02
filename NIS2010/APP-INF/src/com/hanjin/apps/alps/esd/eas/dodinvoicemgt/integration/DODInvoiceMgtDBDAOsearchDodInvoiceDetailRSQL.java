/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOsearchDodInvoiceDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOsearchDodInvoiceDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDodInvoiceDetail
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOsearchDodInvoiceDetailRSQL(){
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
		query.append("FileName : DODInvoiceMgtDBDAOsearchDodInvoiceDetailRSQL").append("\n"); 
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
		query.append("        ,cntr_no" ).append("\n"); 
		query.append("        ,cntr_tpsz_cd" ).append("\n"); 
		query.append("        ,dod_loc_cd" ).append("\n"); 
		query.append("        ,bil_curr_cd" ).append("\n"); 
		query.append("        ,(bil_amt + nvl(add_amt,0)) as bil_amt" ).append("\n"); 
		query.append("        ,tax_amt" ).append("\n"); 
		query.append("        ,inv_amt" ).append("\n"); 
		query.append("        ,cre_usr_id" ).append("\n"); 
		query.append("        ,cre_dt" ).append("\n"); 
		query.append("        ,upd_usr_id" ).append("\n"); 
		query.append("        ,upd_dt" ).append("\n"); 
		query.append("FROM EAS_DOD_INV_DTL" ).append("\n"); 
		query.append("WHERE dod_inv_no = @[dod_inv_no]" ).append("\n"); 

	}
}