/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.04.15 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchErpInterfaceDataForCreditNote
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_creditnote_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteRSQL").append("\n"); 
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
		query.append("LPAD(TO_CHAR(TPB_INV_IF_SMRY_SEQ1.NEXTVAL), 10, '0') AS ar_if_no," ).append("\n"); 
		query.append("SUBSTRB(@[s_n3pty_inv_no], 1, 11)||DECODE(SUBSTRB(@[new_creditnote_cd],1,1),'C',@[new_creditnote_cd],'') AS n3pty_inv_no," ).append("\n"); 
		query.append("if_bl_no AS bl_no, bkg_no, if_rhq_cd, if_ofc_cd, inv_cust_cnt_cd," ).append("\n"); 
		query.append("inv_cust_seq, vsl_cd, skd_voy_no, finc_dir_cd, sail_arr_dt," ).append("\n"); 
		query.append("por_cd, pol_cd, pod_cd, del_cd, lane_cd," ).append("\n"); 
		query.append("TO_CHAR(rcv_due_dt, 'YYYYMMDD') AS rcv_due_dt, (-1)*inv_if_usd_amt AS inv_if_usd_amt," ).append("\n"); 
		query.append("(-1)*inv_if_locl_amt AS inv_if_locl_amt, inv_if_desc, inv_if_cty_cd," ).append("\n"); 
		query.append("curr_cd, NULL AS inv_if_flg, NULL AS inv_if_no, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS inv_if_dt, inv_if_ofc_cd," ).append("\n"); 
		query.append("NULL AS cre_usr_id,  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') As cre_dt," ).append("\n"); 
		query.append("NULL AS upd_usr_id,  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') As upd_dt," ).append("\n"); 
		query.append("mon_xch_rt," ).append("\n"); 
		query.append("@[user_ofc_cd] user_ofc_cd, @[user_id] user_id," ).append("\n"); 
		query.append("csr_no, vvd_cd," ).append("\n"); 
		query.append("NVL2( gl_dt," ).append("\n"); 
		query.append("DECODE( NVL((SELECT clz_sts_cd sts FROM ap_period WHERE sys_div_cd='14' AND eff_yrmon=SUBSTRB(gl_dt,1,6) AND ofc_cd=(SELECT ar_ofc_cd FROM mdm_organization WHERE ofc_cd=if_ofc_cd AND ROWNUM=1) AND ROWNUM=1),(SELECT clz_sts_cd sts FROM ap_period WHERE sys_div_cd='14' AND eff_yrmon=SUBSTRB(gl_dt,1,6) AND ofc_cd=TPB_GET_HNDL_OFC_FNC('R',if_ofc_cd) AND ROWNUM=1))," ).append("\n"); 
		query.append("'O', gl_dt," ).append("\n"); 
		query.append("'C', NVL((SELECT MIN(eff_yrmon) dt FROM ap_period WHERE sys_div_cd='14' AND clz_sts_cd='O' AND ofc_cd=(SELECT ar_ofc_cd FROM mdm_organization WHERE ofc_cd=if_ofc_cd AND ROWNUM=1)),(SELECT MIN(eff_yrmon) dt FROM ap_period WHERE sys_div_cd='14' AND clz_sts_cd='O' AND ofc_cd=TPB_GET_HNDL_OFC_FNC('R',if_ofc_cd)))||'01'," ).append("\n"); 
		query.append("NVL((SELECT MIN(eff_yrmon) dt FROM ap_period WHERE sys_div_cd='14' AND clz_sts_cd='O' AND ofc_cd=(SELECT ar_ofc_cd FROM mdm_organization WHERE ofc_cd=if_ofc_cd AND ROWNUM=1)),(SELECT MIN(eff_yrmon) dt FROM ap_period WHERE sys_div_cd='14' AND clz_sts_cd='O' AND ofc_cd=TPB_GET_HNDL_OFC_FNC('R',if_ofc_cd)))||'01'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("NVL((SELECT MIN(eff_yrmon) dt FROM ap_period WHERE sys_div_cd='14' AND clz_sts_cd='O' AND ofc_cd=(SELECT ar_ofc_cd FROM mdm_organization WHERE ofc_cd=if_ofc_cd AND ROWNUM=1)),(SELECT MIN(eff_yrmon) dt FROM ap_period WHERE sys_div_cd='14' AND clz_sts_cd='O' AND ofc_cd=TPB_GET_HNDL_OFC_FNC('R',if_ofc_cd)))||'01'" ).append("\n"); 
		query.append(") As gl_dt," ).append("\n"); 
		query.append("(SELECT vndr_cust_ref_rmk FROM tpb_inv_rvis WHERE n3pty_inv_no = @[s_n3pty_inv_no] AND n3pty_inv_rvis_cd = @[new_creditnote_cd]) AS vndr_cust_ref_rmk" ).append("\n"); 
		query.append("FROM tpb_inv_if_smry" ).append("\n"); 
		query.append("WHERE ar_if_no = ( SELECT MAX(ar_if_no) ar_if_no" ).append("\n"); 
		query.append("FROM tpb_inv_if_smry" ).append("\n"); 
		query.append("WHERE n3pty_inv_no LIKE SUBSTRB(@[s_n3pty_inv_no],1,11)||'%'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}