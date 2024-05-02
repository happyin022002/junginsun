/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchErpInterfaceDataStr2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchErpInterfaceDataStr2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchErpInterfaceDataStr2
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchErpInterfaceDataStr2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_n3pty_inv_his_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchErpInterfaceDataStr2RSQL").append("\n"); 
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
		query.append("SELECT  ----- GENERAL BILLING CASE" ).append("\n"); 
		query.append("    @[ar_if_no] As ar_if_no," ).append("\n"); 
		query.append("    dtl.n3pty_inv_rvis_dtl_seq As chg_seq," ).append("\n"); 
		query.append("    DECODE(dtl.n3pty_bil_tp_cd, 'JO','XXX', '3'||dtl.n3pty_bil_tp_cd) As n3pty_inv_chg_tp_cd,   /* Like 3CC (general), 'XXX' ('JO' case) */" ).append("\n"); 
		query.append("    NVL(dtl.inv_dtl_amt,0) - NVL(dtl.rev_amt,0) As chg_amt," ).append("\n"); 
		query.append("    COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01394',DECODE(dtl.n3pty_bil_tp_cd, 'JO','XXX', '3'||dtl.n3pty_bil_tp_cd)) As chg_full_nm,  /* ADDED CHARGE TYPE CODE NAME ... */" ).append("\n"); 
		query.append("    hdr.curr_cd As chg_curr_cd," ).append("\n"); 
		query.append("    DECODE(dtl.n3pty_bil_tp_cd, 'JO','954117',NULL) As rev_acct_cd," ).append("\n"); 
		query.append("    DECODE(ots.n3pty_expn_tp_cd, 'TES','512181', 'TRS','512381', 'MNR','511581',NULL) As acct_cd,   /* ACCT_CD DECISION */" ).append("\n"); 
		query.append("    null As inv_if_flg," ).append("\n"); 
		query.append("    null As inv_if_no," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') As inv_if_dt," ).append("\n"); 
		query.append("    inv.ofc_cd As inv_if_ofc_cd," ).append("\n"); 
		query.append("    null As cre_usr_id," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') As cre_dt," ).append("\n"); 
		query.append("    null As upd_usr_id," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') As upd_dt," ).append("\n"); 
		query.append("	@[user_ofc_cd] user_ofc_cd, @[user_id] user_id, DTL.EQ_NO AS TRF_NO" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP ots, TPB_INVOICE inv, TPB_INV_RVIS hdr, TPB_INV_RVIS_DTL dtl" ).append("\n"); 
		query.append("WHERE inv.n3pty_inv_no = hdr.n3pty_inv_no" ).append("\n"); 
		query.append("    AND inv.n3pty_inv_no = dtl.n3pty_inv_no" ).append("\n"); 
		query.append("    AND inv.n3pty_inv_no = ots.n3pty_inv_no" ).append("\n"); 
		query.append("    AND hdr.n3pty_inv_rvis_seq = dtl.n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("    AND dtl.n3pty_no = ots.n3pty_no" ).append("\n"); 
		query.append("    AND ots.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND inv.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND hdr.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND dtl.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND hdr.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("    AND hdr.n3pty_inv_rvis_seq = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("----- ----- -----" ).append("\n"); 
		query.append("UNION ALL -------" ).append("\n"); 
		query.append("----- ----- -----" ).append("\n"); 
		query.append("SELECT  ----- 'JO' BILLING CASE - REVENUE" ).append("\n"); 
		query.append("    @[ar_if_no] As ar_if_no," ).append("\n"); 
		query.append("    ( SELECT MAX(n3pty_inv_rvis_dtl_seq) FROM TPB_INV_RVIS_DTL aa WHERE aa.n3pty_inv_no = hdr.n3pty_inv_no AND aa.n3pty_inv_rvis_seq = hdr.n3pty_inv_rvis_seq ) + ROWNUM As chg_seq," ).append("\n"); 
		query.append("    'TPC' As n3pty_inv_chg_tp_cd,                              /* TPC (case 'JO' Revenue) */" ).append("\n"); 
		query.append("    NVL(dtl.rev_amt,0) As chg_amt," ).append("\n"); 
		query.append("    COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01394','TPC') As chg_full_nm,   /* ADDED CHARGE TYPE CODE NAME ... */" ).append("\n"); 
		query.append("    hdr.curr_cd As chg_curr_cd," ).append("\n"); 
		query.append("    DECODE(dtl.n3pty_bil_tp_cd, 'JO','954117',NULL) As rev_acct_cd," ).append("\n"); 
		query.append("    DECODE(ots.n3pty_expn_tp_cd, 'TES','512181', 'TRS','512381', 'MNR','511581',NULL) As acct_cd,   /* ACCT_CD DECISION */" ).append("\n"); 
		query.append("    null As inv_if_flg," ).append("\n"); 
		query.append("    null As inv_if_no," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') As inv_if_dt," ).append("\n"); 
		query.append("    inv.ofc_cd As inv_if_ofc_cd," ).append("\n"); 
		query.append("    null As cre_usr_id," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') As cre_dt," ).append("\n"); 
		query.append("    null As upd_usr_id," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') As upd_dt," ).append("\n"); 
		query.append("	@[user_ofc_cd] user_ofc_cd, @[user_id] user_id, DTL.EQ_NO AS TRF_NO" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP ots, TPB_INVOICE inv, TPB_INV_RVIS hdr, TPB_INV_RVIS_DTL dtl" ).append("\n"); 
		query.append("WHERE inv.n3pty_inv_no = hdr.n3pty_inv_no" ).append("\n"); 
		query.append("    AND inv.n3pty_inv_no = dtl.n3pty_inv_no" ).append("\n"); 
		query.append("    AND inv.n3pty_inv_no = ots.n3pty_inv_no" ).append("\n"); 
		query.append("    AND hdr.n3pty_inv_rvis_seq = dtl.n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("    AND dtl.n3pty_no = ots.n3pty_no" ).append("\n"); 
		query.append("    AND ots.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND inv.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND hdr.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND dtl.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND hdr.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("    AND hdr.n3pty_inv_rvis_seq = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("    AND dtl.n3pty_bil_tp_cd = 'JO'                          /* Only JO */" ).append("\n"); 
		query.append("    AND ( dtl.rev_amt IS NOT NULL AND dtl.rev_amt != 0.0 )   /* rev_amt is not null and not 0.0 ... */" ).append("\n"); 
		query.append("----- ----- -----" ).append("\n"); 
		query.append("UNION ALL -------" ).append("\n"); 
		query.append("----- ----- -----" ).append("\n"); 
		query.append("SELECT ----- TAX CASE" ).append("\n"); 
		query.append("    @[ar_if_no] As ar_if_no," ).append("\n"); 
		query.append("    ( SELECT MAX(n3pty_inv_rvis_dtl_seq) FROM TPB_INV_RVIS_DTL aa WHERE aa.n3pty_inv_no = hdr.n3pty_inv_no AND aa.n3pty_inv_rvis_seq = hdr.n3pty_inv_rvis_seq )    --- CHG_SEQ -- START " ).append("\n"); 
		query.append("    + ( SELECT COUNT(0) CNT" ).append("\n"); 
		query.append("        FROM TPB_OTS_GRP ots1, TPB_INVOICE inv1, TPB_INV_RVIS hdr1, TPB_INV_RVIS_DTL dtl1" ).append("\n"); 
		query.append("        WHERE inv1.n3pty_inv_no = hdr1.n3pty_inv_no" ).append("\n"); 
		query.append("            AND inv1.n3pty_inv_no = dtl1.n3pty_inv_no" ).append("\n"); 
		query.append("            AND inv1.n3pty_inv_no = ots1.n3pty_inv_no" ).append("\n"); 
		query.append("            AND hdr1.n3pty_inv_rvis_seq = dtl1.n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("            AND dtl1.n3pty_no = ots1.n3pty_no" ).append("\n"); 
		query.append("            AND ots1.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("            AND inv1.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("            AND hdr1.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("            AND dtl1.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("            AND hdr1.n3pty_inv_no = hdr.n3pty_inv_no" ).append("\n"); 
		query.append("            AND hdr1.n3pty_inv_rvis_seq = hdr.n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("            AND dtl1.n3pty_bil_tp_cd = 'JO'                             /* Only JO */" ).append("\n"); 
		query.append("            AND ( dtl1.rev_amt IS NOT NULL AND dtl1.rev_amt != 0.0 )   /* rev_amt is not null and not 01.0 1.1.1. */" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    + ROWNUM As chg_seq,                                               --- CHG_SEQ -- END" ).append("\n"); 
		query.append("    'TVA' As ar_inv_chg_tp_cd,                                         /* VAT Case ... TVA */" ).append("\n"); 
		query.append("    NVL(hdr.vat_amt,0) As chg_amt," ).append("\n"); 
		query.append("    COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01394','TVA') As chg_full_nm,   /* ADDED CHARGE TYPE CODE NAME */" ).append("\n"); 
		query.append("    hdr.curr_cd As chg_curr_cd," ).append("\n"); 
		query.append("    DECODE(dtl.n3pty_bil_tp_cd, 'JO','954117', NULL) As rev_acct_cd," ).append("\n"); 
		query.append("    '954117' As acct_cd,      /* TVA case, '954117' */" ).append("\n"); 
		query.append("    null As inv_if_flg," ).append("\n"); 
		query.append("    null As inv_if_no," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') As inv_if_dt," ).append("\n"); 
		query.append("    inv.ofc_cd As inv_if_ofc_cd," ).append("\n"); 
		query.append("    null As cre_usr_id," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') As cre_dt," ).append("\n"); 
		query.append("    null As upd_usr_id," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') As upd_dt," ).append("\n"); 
		query.append("	@[user_ofc_cd] user_ofc_cd, @[user_id] user_id, DTL.EQ_NO AS TRF_NO" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP ots, TPB_INVOICE inv, TPB_INV_RVIS hdr, TPB_INV_RVIS_DTL dtl" ).append("\n"); 
		query.append("WHERE inv.n3pty_inv_no = hdr.n3pty_inv_no" ).append("\n"); 
		query.append("    AND inv.n3pty_inv_no = dtl.n3pty_inv_no" ).append("\n"); 
		query.append("    AND inv.n3pty_inv_no = ots.n3pty_inv_no" ).append("\n"); 
		query.append("    AND hdr.n3pty_inv_rvis_seq = dtl.n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("    AND dtl.n3pty_no = ots.n3pty_no" ).append("\n"); 
		query.append("    AND ots.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND inv.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND hdr.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND dtl.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND hdr.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("    AND hdr.n3pty_inv_rvis_seq = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("    AND ( hdr.vat_amt IS NOT NULL AND hdr.vat_amt > 0.0 )     /* VAT_AMT IS VALID */" ).append("\n"); 
		query.append("    AND dtl.N3pty_inv_rvis_dtl_seq = 1                        /* 한 행만... */" ).append("\n"); 

	}
}