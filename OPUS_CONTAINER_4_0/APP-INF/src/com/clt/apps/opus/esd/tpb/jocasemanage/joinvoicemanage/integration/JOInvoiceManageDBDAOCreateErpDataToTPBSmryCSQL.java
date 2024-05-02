/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOCreateErpDataToTPBSmryCSQL.java
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

public class JOInvoiceManageDBDAOCreateErpDataToTPBSmryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateErpDataToTPBSmry
	  * </pre>
	  */
	public JOInvoiceManageDBDAOCreateErpDataToTPBSmryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_if_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mon_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_if_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_if_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_if_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOCreateErpDataToTPBSmryCSQL").append("\n"); 
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
		query.append("INSERT INTO TPB_INV_IF_SMRY (" ).append("\n"); 
		query.append("AR_IF_NO" ).append("\n"); 
		query.append(",N3PTY_INV_NO" ).append("\n"); 
		query.append(",IF_BL_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",IF_RHQ_CD" ).append("\n"); 
		query.append(",IF_OFC_CD" ).append("\n"); 
		query.append(",INV_CUST_CNT_CD" ).append("\n"); 
		query.append(",INV_CUST_SEQ" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",FINC_DIR_CD" ).append("\n"); 
		query.append(",SAIL_ARR_DT" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",LANE_CD" ).append("\n"); 
		query.append(",RCV_DUE_DT" ).append("\n"); 
		query.append(",INV_IF_USD_AMT" ).append("\n"); 
		query.append(",INV_IF_LOCL_AMT" ).append("\n"); 
		query.append(",INV_IF_DESC" ).append("\n"); 
		query.append(",INV_IF_CTY_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",INV_IF_FLG" ).append("\n"); 
		query.append(",INV_IF_NO" ).append("\n"); 
		query.append(",INV_IF_DT" ).append("\n"); 
		query.append(",INV_IF_OFC_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",MON_XCH_RT" ).append("\n"); 
		query.append(",CSR_NO" ).append("\n"); 
		query.append(",GL_DT" ).append("\n"); 
		query.append(",VVD_CD  /* CSR NO., GL DATE, ACTUAL VVD ADDED BY KIM JIN-SEUNG IN 2007-08-14 */" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[ar_if_no]" ).append("\n"); 
		query.append(",@[n3pty_inv_no]" ).append("\n"); 
		query.append(",@[bl_no]" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",@[if_rhq_cd]" ).append("\n"); 
		query.append(",@[if_ofc_cd]" ).append("\n"); 
		query.append(",@[inv_cust_cnt_cd]" ).append("\n"); 
		query.append(",@[inv_cust_seq]" ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[finc_dir_cd]" ).append("\n"); 
		query.append(",@[sail_arr_dt]" ).append("\n"); 
		query.append(",@[por_cd]" ).append("\n"); 
		query.append(",@[pol_cd]" ).append("\n"); 
		query.append(",@[pod_cd]" ).append("\n"); 
		query.append(",@[del_cd]" ).append("\n"); 
		query.append(",@[lane_cd]" ).append("\n"); 
		query.append(",TO_DATE(@[rcv_due_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(",@[inv_if_usd_amt]" ).append("\n"); 
		query.append(",@[inv_if_locl_amt]" ).append("\n"); 
		query.append(",@[inv_if_desc]" ).append("\n"); 
		query.append(",@[inv_if_cty_cd]" ).append("\n"); 
		query.append(",@[curr_cd]" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",@[inv_if_no]" ).append("\n"); 
		query.append(",TO_DATE(@[inv_if_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[user_ofc_cd] /* model1.getInv_if_ofc_cd,  user_ofc_cd */" ).append("\n"); 
		query.append(",@[user_id] /* model1.getCre_usr_id() */" ).append("\n"); 
		query.append(",SYSDATE /* inv_if_flg : 'Y' (in sysnc way ) */" ).append("\n"); 
		query.append(",'TPB AR I/F' /* model1.getUpd_usr_id(), user_id */" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[mon_xch_rt] /* add mon_xch_rt */" ).append("\n"); 
		query.append("/* upd_usr_id : 'TPB AR I/F' (in sysnc way ) */" ).append("\n"); 
		query.append(",@[csr_no] /* CSR No., GL Date, Actual VVD added By Kim Jin-seung In 2007-08-14 */" ).append("\n"); 
		query.append(",@[gl_dt] /* CSR No., GL Date, Actual VVD added By Kim Jin-seung In 2007-08-14 */" ).append("\n"); 
		query.append("/* CSR No., GL Date, Actual VVD added By Kim Jin-seung In 2007-08-14 */" ).append("\n"); 
		query.append(",@[vvd_cd] /* CSR No., GL Date, Actual VVD added By Kim Jin-seung In 2007-08-14 */" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}