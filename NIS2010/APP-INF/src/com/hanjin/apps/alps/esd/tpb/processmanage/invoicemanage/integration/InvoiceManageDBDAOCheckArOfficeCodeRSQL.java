/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceManageDBDAOCheckArOfficeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.01.14 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOCheckArOfficeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckArOfficeCode
	  * </pre>
	  */
	public InvoiceManageDBDAOCheckArOfficeCodeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOCheckArOfficeCodeRSQL").append("\n"); 
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
		query.append("SELECT DECODE(( SELECT ar_ofc_cd" ).append("\n"); 
		query.append("FROM mdm_organization" ).append("\n"); 
		query.append("WHERE ofc_cd = (  SELECT ofc_cd" ).append("\n"); 
		query.append("FROM tpb_inv_rvis r, tpb_invoice v" ).append("\n"); 
		query.append("WHERE r.n3pty_inv_no=v.n3pty_inv_no" ).append("\n"); 
		query.append("AND r.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND r.n3pty_inv_rvis_seq = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ROWNUM = 1 ),NULL,'N','Y') ar_ofc_cd_validyn," ).append("\n"); 
		query.append("( SELECT DECODE(MAX(EFF_YRMON),NULL,'N','Y') FROM ap_period WHERE sys_div_cd='14' AND ar_ap_div_cd='R' AND clz_sts_cd = 'O' ) eff_yrmon_validyn" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}