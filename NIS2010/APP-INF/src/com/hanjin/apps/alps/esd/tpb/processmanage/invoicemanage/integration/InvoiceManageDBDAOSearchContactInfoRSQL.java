/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchContactInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.10.01 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchContactInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchContactInfo
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchContactInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_info",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchContactInfoRSQL").append("\n"); 
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
		query.append("SELECT ----- vendor base -----" ).append("\n"); 
		query.append("@[s_info] inforowcount," ).append("\n"); 
		query.append("ROWNUM rn," ).append("\n"); 
		query.append("DECODE(@[s_info], 'E', m.vndr_eml, 'F', m.fax_no) As cntc_info," ).append("\n"); 
		query.append("DECODE(@[s_info], 'E', TPB_CHK_EMAIL_ADDR_FNC(m.vndr_eml), 'F', TPB_CHK_FAX_NO_FNC(m.fax_no) ) As cntc_info_validYN" ).append("\n"); 
		query.append("FROM TPB_INVOICE V, TPB_INV_RVIS R, mdm_vndr_cntc_pnt M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND R.n3pty_inv_no = V.n3pty_inv_no" ).append("\n"); 
		query.append("AND R.n3pty_inv_rvis_seq = V.lst_n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("AND R.vndr_seq = M.vndr_seq" ).append("\n"); 
		query.append("AND R.vndr_cust_div_cd = 'V'" ).append("\n"); 
		query.append("AND R.vndr_seq IS NOT NULL" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(@[s_info]='E' AND M.vndr_eml IS NOT NULL )" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(@[s_info]='F' AND M.fax_no IS NOT NULL )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND R.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND M.delt_flg = 'N'" ).append("\n"); 
		query.append("------" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("------" ).append("\n"); 
		query.append("SELECT ----- customer base -----" ).append("\n"); 
		query.append("@[s_info] inforowcount," ).append("\n"); 
		query.append("ROWNUM rn," ).append("\n"); 
		query.append("DECODE(@[s_info], 'E', m.cust_eml, 'F', m.fax_no) As cntc_info," ).append("\n"); 
		query.append("DECODE(@[s_info], 'E', TPB_CHK_EMAIL_ADDR_FNC(m.cust_eml), 'F', TPB_CHK_FAX_NO_FNC(m.fax_no) ) As cntc_info_validYN" ).append("\n"); 
		query.append("FROM TPB_INVOICE V, TPB_INV_RVIS R, mdm_cust_cntc_pnt M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND R.n3pty_inv_no = V.n3pty_inv_no" ).append("\n"); 
		query.append("AND R.n3pty_inv_rvis_seq = V.lst_n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("AND R.cust_cnt_cd = m.cust_cnt_cd" ).append("\n"); 
		query.append("AND R.cust_seq = m.cust_seq" ).append("\n"); 
		query.append("AND R.vndr_cust_div_cd = 'C'" ).append("\n"); 
		query.append("AND R.cust_seq IS NOT NULL" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(@[s_info]='E' AND m.cust_eml IS NOT NULL )" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(@[s_info]='F' AND m.fax_no IS NOT NULL )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND R.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 

	}
}