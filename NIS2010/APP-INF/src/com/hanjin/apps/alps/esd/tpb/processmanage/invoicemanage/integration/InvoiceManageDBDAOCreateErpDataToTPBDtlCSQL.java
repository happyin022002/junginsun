/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageDBDAOCreateErpDataToTPBDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.11.20 박성진
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

public class InvoiceManageDBDAOCreateErpDataToTPBDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateErpDataToTPBDtl
	  * </pre>
	  */
	public InvoiceManageDBDAOCreateErpDataToTPBDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_full_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_inv_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOCreateErpDataToTPBDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO tpb_inv_if_dtl (" ).append("\n"); 
		query.append("ar_if_no, chg_seq, n3pty_inv_chg_tp_cd, chg_amt, chg_full_nm," ).append("\n"); 
		query.append("chg_curr_cd, rev_acct_cd, acct_cd, inv_if_flg, inv_if_no," ).append("\n"); 
		query.append("inv_if_dt, inv_if_ofc_cd, cre_usr_id, cre_dt, upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[ar_if_no]" ).append("\n"); 
		query.append(", @[chg_seq]" ).append("\n"); 
		query.append(", @[n3pty_inv_chg_tp_cd]" ).append("\n"); 
		query.append(", @[chg_amt]" ).append("\n"); 
		query.append(", @[chg_full_nm]" ).append("\n"); 
		query.append(", @[chg_curr_cd]" ).append("\n"); 
		query.append(", @[rev_acct_cd]" ).append("\n"); 
		query.append(", @[acct_cd]" ).append("\n"); 
		query.append(", 'Y'" ).append("\n"); 
		query.append(", @[inv_if_no] /* inv_if_flg : 'Y' (in sysnc way ) */" ).append("\n"); 
		query.append(", TO_DATE(@[inv_if_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(", @[user_ofc_cd] /* model2.getInv_if_ofc_cd, user_ofc_cd */" ).append("\n"); 
		query.append(", @[user_id] /* model1.getCre_usr_id() */" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", 'TPB AR I/F'  /* upd_usr_id : 'TPB AR I/F' (in sysnc way ) */" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}