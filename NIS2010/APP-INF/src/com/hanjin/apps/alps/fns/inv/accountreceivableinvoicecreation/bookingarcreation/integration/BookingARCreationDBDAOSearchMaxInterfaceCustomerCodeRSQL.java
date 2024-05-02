/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchMaxInterfaceCustomerCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.30
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.05.30 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchMaxInterfaceCustomerCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchMaxInterfaceCustomerCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchMaxInterfaceCustomerCodeRSQL").append("\n"); 
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
		query.append("select act_cust_cnt_cd," ).append("\n"); 
		query.append("       act_cust_seq," ).append("\n"); 
		query.append("       inv_cust_cnt_cd," ).append("\n"); 
		query.append("       inv_cust_seq," ).append("\n"); 
		query.append("	   cust_cr_flg," ).append("\n"); 
		query.append("	   due_dt," ).append("\n"); 
		query.append("       cr_term_dys" ).append("\n"); 
		query.append("  from inv_ar_mn" ).append("\n"); 
		query.append(" where ar_if_no = (select max(ar_if_no)" ).append("\n"); 
		query.append("  					 from inv_ar_mn" ).append("\n"); 
		query.append("                    WHERE ar_ofc_cd = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                      AND bl_src_no = @[bl_src_no]" ).append("\n"); 
		query.append("                      AND NVL(INV_DELT_DIV_CD,'N')<> 'Y'" ).append("\n"); 
		query.append("                      AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                      AND NVL(INV_SPLIT_CD,'N') NOT IN ('S','X')--20091207 이상희과장 " ).append("\n"); 
		query.append("                    GROUP by ar_ofc_cd, bl_src_no)" ).append("\n"); 

	}
}