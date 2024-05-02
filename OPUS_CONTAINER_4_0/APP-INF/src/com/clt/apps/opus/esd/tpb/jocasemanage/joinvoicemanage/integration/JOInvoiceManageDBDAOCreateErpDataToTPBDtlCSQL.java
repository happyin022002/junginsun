/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOCreateErpDataToTPBDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOCreateErpDataToTPBDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateErpDataToTPBDtl
	  * </pre>
	  */
	public JOInvoiceManageDBDAOCreateErpDataToTPBDtlCSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOCreateErpDataToTPBDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO TPB_INV_IF_DTL (" ).append("\n"); 
		query.append("AR_IF_NO" ).append("\n"); 
		query.append(",CHG_SEQ" ).append("\n"); 
		query.append(",N3PTY_INV_CHG_TP_CD" ).append("\n"); 
		query.append(",CHG_AMT" ).append("\n"); 
		query.append(",CHG_FULL_NM" ).append("\n"); 
		query.append(",CHG_CURR_CD" ).append("\n"); 
		query.append(",REV_ACCT_CD" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",INV_IF_FLG" ).append("\n"); 
		query.append(",INV_IF_NO" ).append("\n"); 
		query.append(",INV_IF_DT" ).append("\n"); 
		query.append(",INV_IF_OFC_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[ar_if_no]" ).append("\n"); 
		query.append(",@[chg_seq]" ).append("\n"); 
		query.append(",@[n3pty_inv_chg_tp_cd]" ).append("\n"); 
		query.append(",@[chg_amt]" ).append("\n"); 
		query.append(",@[chg_full_nm]" ).append("\n"); 
		query.append(",@[chg_curr_cd]" ).append("\n"); 
		query.append(",@[rev_acct_cd]" ).append("\n"); 
		query.append(",@[acct_cd]" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",@[inv_if_no] /* inv_if_flg : 'Y' (in sysnc way ) */" ).append("\n"); 
		query.append(",TO_DATE(@[inv_if_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[user_ofc_cd] /* model2.getInv_if_ofc_cd, user_ofc_cd */" ).append("\n"); 
		query.append(",@[user_id] /* model1.getCre_usr_id() */" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",'TPB AR I/F'  /* upd_usr_id : 'TPB AR I/F' (in sysnc way ) */" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}