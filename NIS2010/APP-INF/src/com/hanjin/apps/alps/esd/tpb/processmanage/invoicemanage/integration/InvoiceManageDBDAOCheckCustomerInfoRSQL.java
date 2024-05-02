/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageDBDAOCheckCustomerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.10.09 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOCheckCustomerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckCustomerInfo
	  * </pre>
	  */
	public InvoiceManageDBDAOCheckCustomerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration ").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOCheckCustomerInfoRSQL").append("\n"); 
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
		query.append("DECODE( hdr.vndr_cust_div_cd," ).append("\n"); 
		query.append("'C', NVL2(hdr.cust_cnt_cd," ).append("\n"); 
		query.append("NVL2(hdr.cust_seq,1,0)" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'V', NVL2(hdr.vndr_seq," ).append("\n"); 
		query.append("( SELECT COUNT(0) cnt" ).append("\n"); 
		query.append("FROM mdm_vendor v" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND v.vndr_seq = hdr.vndr_seq" ).append("\n"); 
		query.append("AND v.delt_flg = 'N'" ).append("\n"); 
		query.append("AND v.rfnd_psdo_cust_cd IS NOT NULL" ).append("\n"); 
		query.append("AND rownum = 1 )" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("0" ).append("\n"); 
		query.append(") cnt" ).append("\n"); 
		query.append("FROM tpb_inv_rvis hdr, tpb_invoice inv" ).append("\n"); 
		query.append("WHERE hdr.n3pty_inv_no = inv.n3pty_inv_no" ).append("\n"); 
		query.append("AND hdr.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("AND hdr.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND hdr.n3pty_inv_rvis_seq = @[s_n3pty_inv_his_seq]" ).append("\n"); 

	}
}