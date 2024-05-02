/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLInformationMgtDBDAOsearchBkgListForGrpBlPrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLInformationMgtDBDAOsearchBkgListForGrpBlPrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0280 Sheet Result
	  * </pre>
	  */
	public BLInformationMgtDBDAOsearchBkgListForGrpBlPrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("twn_so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("booking_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("booking_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pre_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("booking_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("booking_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_post_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_post_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pre_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration").append("\n"); 
		query.append("FileName : BLInformationMgtDBDAOsearchBkgListForGrpBlPrRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_NL(T1 T2 T3 T7) */" ).append("\n"); 
		query.append("       T1.BKG_NO," ).append("\n"); 
		query.append("       T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD AS POL_POD," ).append("\n"); 
		query.append("       T1.BL_NO||T1.BL_TP AS BL_NO," ).append("\n"); 
		query.append("       T1.POR_CD AS POR," ).append("\n"); 
		query.append("       T1.POL_CD AS POL," ).append("\n"); 
		query.append("       T1.POD_CD AS POD," ).append("\n"); 
		query.append("       T1.DEL_CD AS DEL," ).append("\n"); 
		query.append("       T1.BKG_RCV_TERM AS R_TERM," ).append("\n"); 
		query.append("       T1.BKG_DLV_TERM AS D_TERM," ).append("\n"); 
		query.append("       T1.PRE_RLY_PORT_CD AS POL_CD," ).append("\n"); 
		query.append("       T1.PST_RLY_PORT_CD AS POD_CD," ).append("\n"); 
		query.append("       T1.CMDT_REP AS REP," ).append("\n"); 
		query.append("       T1.CMDT_CD AS COMMODITY," ).append("\n"); 
		query.append("       T1.BKG_SPE_DG AS D_SC," ).append("\n"); 
		query.append("       T1.BKG_SPE_RF AS R_SC," ).append("\n"); 
		query.append("       T1.BKG_SPE_AK AS A_SC," ).append("\n"); 
		query.append("       T1.BKG_SPE_BB AS B_SC," ).append("\n"); 
		query.append("       T1.BKG_ADV_SHT AS A_S," ).append("\n"); 
		query.append("       T1.BKG_STS AS ST," ).append("\n"); 
		query.append("       T1.BKG_BDR_IND AS BDR," ).append("\n"); 
		query.append("       T1.BKG_BDR_CHG AS CA," ).append("\n"); 
		query.append("       T1.BKG_SO_NO AS TWN_SO_NO," ).append("\n"); 
		query.append("       (SELECT FINC_CTRL_OFC_CD FROM MDM_LOCATION X1 WHERE X1.LOC_CD = T1.POR_CD) AS POR_EQ," ).append("\n"); 
		query.append("       (SELECT FINC_CTRL_OFC_CD FROM MDM_LOCATION X1 WHERE X1.LOC_CD = T1.DEL_CD) AS DEL_EQ," ).append("\n"); 
		query.append("       #if (${sc_rfa_no} != '')" ).append("\n"); 
		query.append("           #if ('sc'==${sc_rfa_chk})" ).append("\n"); 
		query.append("               T1.SC_NO" ).append("\n"); 
		query.append("           #elseif ('rfa'==${sc_rfa_chk})" ).append("\n"); 
		query.append("               T1.RFA_NO" ).append("\n"); 
		query.append("           #elseif ('taa'==${sc_rfa_chk})" ).append("\n"); 
		query.append("               T1.TAA_NO" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("           NVL(NVL(T1.RFA_NO,T1.SC_NO),T1.TAA_NO)" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       AS SC_RFA_NO," ).append("\n"); 
		query.append("       (SELECT DECODE(COUNT(1), 0, 'N','Y')" ).append("\n"); 
		query.append("          FROM BIS_XPT_IMP_LIC X1" ).append("\n"); 
		query.append("         WHERE X1.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("           AND X1.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND X1.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("           AND X1.AES_TP_CD IS NOT NULL) AS AES," ).append("\n"); 
		query.append("       (SELECT DECODE(COUNT(1), 0, 'N','Y')" ).append("\n"); 
		query.append("          FROM BIS_XPT_IMP_LIC X1" ).append("\n"); 
		query.append("         WHERE X1.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("           AND X1.CNT_CD = 'CA'" ).append("\n"); 
		query.append("           AND X1.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("       AND X1.CAED_TP_CD IS NOT NULL) AS CAED," ).append("\n"); 
		query.append("       DECODE(" ).append("\n"); 
		query.append("       CASE WHEN NVL(T1.CUST_TO_ORD_FLG, 'N') = 'Y' AND T1.NTFY_NAME IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("            WHEN NVL(T1.CUST_TO_ORD_FLG, 'Y') = 'N' AND T1.CONSIGNEE_NAME IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N' END" ).append("\n"); 
		query.append("       ||" ).append("\n"); 
		query.append("       DECODE(T7.MK_SEQ, NULL, 'N', 'Y')||DECODE( NVL( ( SELECT CNTR_NO FROM BIS_CONTAINER WHERE BKG_NO = T1.BKG_NO AND ROWNUM = 1 ) , 'N'), 'N' ,'N', 'Y'), 'YYY', 'Y', 'N') AS MANIFEST," ).append("\n"); 
		query.append("       DECODE(NVL( ( SELECT BKG_NO FROM BIS_CHG_RT WHERE BKG_NO = T1.BKG_NO AND ROWNUM = 1 ) , 'N'), 'N', 'N', 'Y') AS RATE," ).append("\n"); 
		query.append("       REGEXP_REPLACE(T1.SHIPPER_NAME, '\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\s', ' ') AS SHIPPER," ).append("\n"); 
		query.append("       REGEXP_REPLACE(T1.CONSIGNEE_NAME, '\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\s', ' ') AS CONSIGNEE," ).append("\n"); 
		query.append("       'POL : '||T1.POL_CD||'    '||'POD : '||T1.POD_CD AS ORDER_COL," ).append("\n"); 
		query.append("       T1.BL_BKG_NO," ).append("\n"); 
		query.append("       T1.BL_ACT_WGT," ).append("\n"); 
		query.append("       T1.BL_MEAS_QTY," ).append("\n"); 
		query.append("       NVL(T1.OBL_ISS_FLG,'N') OBL_ISS_FLG," ).append("\n"); 
		query.append("       NVL(T1.OBL_PRN_FLG,'N') OBL_PRN_FLG," ).append("\n"); 
		query.append("       NVL(T1.OBL_RLSE_FLG,'N') OBL_RLSE_FLG," ).append("\n"); 
		query.append("      (SELECT TRIM(TO_CHAR(SUM(DECODE(GREATEST('2', SUBSTR(CNTR_TPSZ_CD, 2, 1)), '2', NVL(OP_CNTR_QTY, 0), 0)) , '999999990.99')) FROM BIS_QUANTITY WHERE BKG_NO = T1.BKG_NO ) TEU," ).append("\n"); 
		query.append("      (SELECT TRIM(TO_CHAR(SUM(DECODE(GREATEST('2', SUBSTR(CNTR_TPSZ_CD, 2, 1)), '2', 0, NVL(OP_CNTR_QTY, 0))) , '999999990.99')) FROM BIS_QUANTITY WHERE BKG_NO = T1.BKG_NO ) FEU" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT /*+ USE_NL(B REF) INDEX(B B(BKG_NO, BKG_OFC_CD)) */" ).append("\n"); 
		query.append("       b.bkg_no" ).append("\n"); 
		query.append("      ,MAX(b.sc_no)                 AS SC_NO" ).append("\n"); 
		query.append("      ,MAX(b.bkg_cgo_tp_cd)         AS bkg_cgo_tp" ).append("\n"); 
		query.append("      ,MAX(b.rep_cmdt_cd)           AS cmdt_rep" ).append("\n"); 
		query.append("      ,MAX(b.cmdt_cd)               AS CMDT_CD" ).append("\n"); 
		query.append("      ,MAX(b.bkg_ofc_cd)            AS bkg_ofc" ).append("\n"); 
		query.append("      ,MAX(bl.bkg_clz_flg)          AS bkg_cbf_ind" ).append("\n"); 
		query.append("      ,MAX(b.rc_flg)                AS bkg_spe_rf" ).append("\n"); 
		query.append("      ,MAX(b.dcgo_flg)              AS bkg_spe_dg" ).append("\n"); 
		query.append("      ,MAX(b.bl_no)                 AS BL_NO" ).append("\n"); 
		query.append("      ,MAX(b.rail_blk_cd)           AS RAIL_BLK_CD" ).append("\n"); 
		query.append("      ,MAX(b.stwg_cd)               AS STWG_CD" ).append("\n"); 
		query.append("      ,MAX(b.hot_de_flg)            AS HOT_DE_FLG" ).append("\n"); 
		query.append("      ,MAX(b.prct_flg)              AS PRCT_FLG" ).append("\n"); 
		query.append("      ,MAX(b.fd_grd_flg)            AS FD_GRD_FLG" ).append("\n"); 
		query.append("      ,MAX(b.spcl_hide_flg)         AS SPCL_HIDE_FLG" ).append("\n"); 
		query.append("      ,MAX(b.wt_rsn_spcl_cgo_flg)   AS WT_RSN_SPCL_CGO_FLG" ).append("\n"); 
		query.append("      ,MAX(b.wt_rsn_hld_flg)        AS WT_RSN_HLD_FLG" ).append("\n"); 
		query.append("      ,MAX(b.stop_off_loc_cd)       AS STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("      ,MAX(b.cust_to_ord_flg)       AS CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("      ,MAX(bl.bkg_no)               AS bl_bkg_no" ).append("\n"); 
		query.append("      ,DECODE(MAX(bl.wgt_ut_cd),'KGS',MAX(bl.act_wgt) / 1000,'LBS',(MAX(bl.act_wgt) * 0.45359) / 1000,0) AS bl_act_wgt" ).append("\n"); 
		query.append("      ,DECODE(MAX(bl.meas_ut_cd),'CBF',MAX(bl.meas_qty) * 0.02,'CBM',MAX(bl.meas_qty),0) AS bl_meas_qty" ).append("\n"); 
		query.append("      ,MAX(b.pre_rly_port_cd)       AS PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("      ,MAX(b.pst_rly_port_cd)       AS PST_RLY_PORT_CD" ).append("\n"); 
		query.append("      ,MAX(b.bl_tp_cd)              AS bl_tp" ).append("\n"); 
		query.append("      ,MAX(b.awk_cgo_flg)           AS bkg_spe_ak" ).append("\n"); 
		query.append("      ,MAX(b.rd_cgo_flg)            AS bkg_spe_rd" ).append("\n"); 
		query.append("      ,MAX(b.bb_cgo_flg)            AS bkg_spe_bb" ).append("\n"); 
		query.append("      ,MAX(b.hngr_flg)              AS bkg_hang_ind" ).append("\n"); 
		query.append("      ,MAX(b.soc_flg)               AS bkg_soc_ind" ).append("\n"); 
		query.append("      ,MAX(b.eq_subst_flg)          AS bkg_esub" ).append("\n"); 
		query.append("      ,MAX(b.doc_usr_id)            AS bkg_stf" ).append("\n"); 
		query.append("      ,MAX(b.ob_sls_ofc_cd)         AS sal_ofc" ).append("\n"); 
		query.append("      ,MAX(b.ob_srep_cd)            AS OB_SREP_CD" ).append("\n"); 
		query.append("      ,MAX(b.rcv_term_cd)           AS bkg_rcv_term" ).append("\n"); 
		query.append("      ,MAX(b.de_term_cd)            AS bkg_dlv_term" ).append("\n"); 
		query.append("      ,MAX(b.org_trns_svc_mod_cd)   AS org_svc" ).append("\n"); 
		query.append("      ,MAX(b.dest_trns_svc_mod_cd)  AS dst_svc" ).append("\n"); 
		query.append("      ,MAX(b.org_sconti_cd)         AS bkg_org_route" ).append("\n"); 
		query.append("      ,MAX(b.dest_sconti_cd)        AS bkg_dst_route" ).append("\n"); 
		query.append("      ,MAX(b.bkg_sts_cd)            AS bkg_sts" ).append("\n"); 
		query.append("      ,MAX(b.slan_cd)               AS bkg_lane" ).append("\n"); 
		query.append("      ,MAX(b.hot_de_flg)            AS bkg_hot" ).append("\n"); 
		query.append("      ,MAX(b.bkg_cre_dt)            AS bkg_dt" ).append("\n"); 
		query.append("      ,MAX(b.adv_shtg_cd)           AS bkg_adv_sht" ).append("\n"); 
		query.append("      ,MAX(b.twn_so_no)             AS bkg_so_no" ).append("\n"); 
		query.append("      ,REF.CUST_REF_NO_CTNT         AS bkg_psa_no" ).append("\n"); 
		query.append("      ,MAX(b.vsl_cd||b.skd_voy_no||b.skd_dir_cd) AS trunk_vvd" ).append("\n"); 
		query.append("      ,MAX(b.vsl_cd)                AS VSL_CD" ).append("\n"); 
		query.append("      ,MAX(b.skd_voy_no)            AS SKD_VOY_NO" ).append("\n"); 
		query.append("      ,MAX(b.skd_dir_cd)            AS SKD_DIR_CD" ).append("\n"); 
		query.append("      ,MAX(b.por_cd)                AS POR_CD" ).append("\n"); 
		query.append("      ,MAX(b.pol_cd)                AS POL_CD" ).append("\n"); 
		query.append("      ,MAX(b.pod_cd)                AS POD_CD" ).append("\n"); 
		query.append("      ,MAX(b.del_cd)                AS DEL_CD" ).append("\n"); 
		query.append("      ,MAX(bl.bdr_flg)              AS bkg_bdr_ind" ).append("\n"); 
		query.append("      ,MAX(bl.bdr_cng_flg)          AS bkg_bdr_chg" ).append("\n"); 
		query.append("      ,MAX(b.eq_ctrl_ofc_cd)        AS bkg_eq_ofc" ).append("\n"); 
		query.append("      ,MAX(iss.obl_iss_dt)          AS OBL_ISS_DT" ).append("\n"); 
		query.append("      ,MAX(iss.obl_iss_ofc_cd)      AS OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("      ,MAX(iss.obl_iss_usr_id)      AS OBL_ISS_USR_ID" ).append("\n"); 
		query.append("      ,MAX(iss.obl_iss_flg)         AS OBL_ISS_FLG" ).append("\n"); 
		query.append("      ,MAX(iss.obl_prn_flg)         AS OBL_PRN_FLG" ).append("\n"); 
		query.append("      ,MAX(iss.obl_rlse_flg)        AS OBL_RLSE_FLG" ).append("\n"); 
		query.append("      ,MAX(b.rfa_no)                AS RFA_NO" ).append("\n"); 
		query.append("      ,MAX(b.taa_no)                AS TAA_NO" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'S', c.cust_cnt_cd||c.cust_seq)) AS shipper" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'S', c.cust_nm))                 AS shipper_name" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'C', c.cust_cnt_cd||c.cust_seq)) AS consignee" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'C', c.cust_nm))                 AS consignee_name" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'F', c.cust_cnt_cd||c.cust_seq)) AS ffdr" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'F', c.cust_nm))                 AS ffdr_name" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'N', c.cust_cnt_cd||c.cust_seq)) AS ntfy" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'N', c.cust_nm))                 AS ntfy_name" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'A', c.cust_cnt_cd||c.cust_seq)) AS anty" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'A', c.cust_nm))                 AS anty_name" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'E', c.cust_cnt_cd||c.cust_seq)) AS expt" ).append("\n"); 
		query.append("      ,MAX(DECODE(c.bkg_cust_tp_cd, 'E', c.cust_nm))                 AS expt_name" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '1' THEN v1.vsl_cd||v1.skd_voy_no||v1.skd_dir_cd END) AS pre_1_vvd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '1' THEN v1.pol_cd END)                               AS pre_1_pol_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '1' THEN v1.pod_cd END)                               AS pre_1_pod_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '2' THEN v1.vsl_cd||v1.skd_voy_no||v1.skd_dir_cd END) AS pre_2_vvd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '2' THEN v1.pol_cd END)                               AS pre_2_pol_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '2' THEN v1.pod_cd END)                               AS pre_2_pod_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '3' THEN v1.vsl_cd||v1.skd_voy_no||v1.skd_dir_cd END) AS pre_3_vvd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '3' THEN v1.pol_cd END)                               AS pre_3_pol_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '3' THEN v1.pod_cd END)                               AS pre_3_pod_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '4' THEN v1.vsl_cd||v1.skd_voy_no||v1.skd_dir_cd END) AS pre_4_vvd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '4' THEN v1.pol_cd END)                               AS pre_4_pol_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'S' AND vsl_seq = '4' THEN v1.pod_cd END)                               AS pre_4_pod_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '1' THEN v1.vsl_cd||v1.skd_voy_no||v1.skd_dir_cd END) AS post_1_vvd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '1' THEN v1.pol_cd END)                               AS post_1_pol_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '1' THEN v1.pod_cd END)                               AS post_1_pod_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '2' THEN v1.vsl_cd||v1.skd_voy_no||v1.skd_dir_cd END) AS post_2_vvd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '2' THEN v1.pol_cd END)                               AS post_2_pol_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '2' THEN v1.pod_cd END)                               AS post_2_pod_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '3' THEN v1.vsl_cd||v1.skd_voy_no||v1.skd_dir_cd END) AS post_3_vvd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '3' THEN v1.pol_cd END)                               AS post_3_pol_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '3' THEN v1.pod_cd END)                               AS post_3_pod_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '4' THEN v1.vsl_cd||v1.skd_voy_no||v1.skd_dir_cd END) AS post_4_vvd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '4' THEN v1.pol_cd END)                               AS post_4_pol_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'U' AND vsl_seq = '4' THEN v1.pod_cd END)                               AS post_4_pod_cd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'T' THEN v1.vsl_cd||v1.skd_voy_no||v1.skd_dir_cd END) AS post_4_vvd" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'T' THEN v1.pol_cd END) AS trunk_pol" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN v1.vsl_pre_pst_cd = 'T' THEN v1.pod_cd END) AS trunk_pod" ).append("\n"); 
		query.append("  FROM bIS_booking b" ).append("\n"); 
		query.append("      ,bIS_bl_doc bl" ).append("\n"); 
		query.append("      ,bIS_customer c" ).append("\n"); 
		query.append("      ,bIS_vvd v1" ).append("\n"); 
		query.append("      ,bIS_bl_iss iss" ).append("\n"); 
		query.append("      ,bIS_reference REF" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("   AND V1.VSL_CD = SUBSTR(@[vvd], 1, 4) -- 4" ).append("\n"); 
		query.append("   AND V1.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4) -- 4" ).append("\n"); 
		query.append("   AND V1.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1) -- 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_pre_pst_cd} != '')" ).append("\n"); 
		query.append("   AND b.vsl_cd||b.skd_voy_no||b.skd_dir_cd = @[vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_pol_cd} != '')" ).append("\n"); 
		query.append("   AND V1.POL_CD LIKE @[vvd_pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_pol_local} != '' && ${vvd_pol_ts} == '')" ).append("\n"); 
		query.append("   AND B.POL_CD = V1.POL_CD" ).append("\n"); 
		query.append("#elseif (${vvd_pol_ts} != '' && ${vvd_pol_local} == '')" ).append("\n"); 
		query.append("   AND B.POL_CD <> V1.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_pod_cd} != '')" ).append("\n"); 
		query.append("   AND V1.POD_CD LIKE @[vvd_pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_pod_local} != '')" ).append("\n"); 
		query.append("   AND B.POD_CD = V1.POD_CD" ).append("\n"); 
		query.append("#elseif (${vvd_pod_ts} != '')" ).append("\n"); 
		query.append("   AND B.POD_CD <> V1.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND b.bkg_sts_cd IN ('F','W','A','S') -- ?????" ).append("\n"); 
		query.append("   AND b.bkg_sts_cd <> 'X'" ).append("\n"); 
		query.append("   AND b.bkg_no = c.bkg_no (+)" ).append("\n"); 
		query.append("   AND b.bkg_no = v1.bkg_no (+)" ).append("\n"); 
		query.append("   AND b.bkg_no = bl.bkg_no (+)" ).append("\n"); 
		query.append("   AND b.bkg_no = iss.bkg_no (+)" ).append("\n"); 
		query.append("   AND b.bkg_no = REF.bkg_no (+)" ).append("\n"); 
		query.append("   AND REF.bkg_ref_tp_cd (+)  = 'RGBK'" ).append("\n"); 
		query.append("#if ( ${adv_shtg_cd_a} != '' && ${adv_shtg_cd_s} != '' )" ).append("\n"); 
		query.append("   AND B.SPLIT_RSN_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ('I'==${obl_iss_date})" ).append("\n"); 
		query.append("    #if (${obl_iss_from_dt} != '')" ).append("\n"); 
		query.append("       AND ( ISS.OBL_ISS_DT >= TO_DATE(REPLACE(@[obl_iss_from_dt],'-',''),'YYYYMMDD') )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${obl_iss_to_dt} != '')" ).append("\n"); 
		query.append("       AND ( ISS.OBL_ISS_DT < TO_DATE(REPLACE(@[obl_iss_to_dt],'-',''),'YYYYMMDD') + 1 )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ('R'==${obl_iss_date} && ''!=${obl_iss_from_dt} && ''!=${obl_iss_to_dt})" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                 FROM BIS_DOC_PROC_SKD" ).append("\n"); 
		query.append("                WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                  AND BKG_DOC_PROC_TP_CD = 'OBLREL'" ).append("\n"); 
		query.append("                  AND DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                  AND EVNT_DT BETWEEN TO_DATE(REPLACE(@[obl_iss_from_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("                                  AND TO_DATE(REPLACE(@[obl_iss_to_dt],'-',''),'YYYYMMDD')+1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${booking_por_cd} != '')" ).append("\n"); 
		query.append("   AND B.POR_CD LIKE @[booking_por_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${booking_pol_cd} != '')" ).append("\n"); 
		query.append("   AND B.POL_CD LIKE @[booking_pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${booking_pod_cd} != '')" ).append("\n"); 
		query.append("   AND B.POD_CD LIKE @[booking_pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${booking_del_cd} != '')" ).append("\n"); 
		query.append("   AND B.DEL_CD LIKE @[booking_del_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkgRcvTermCds} != '')" ).append("\n"); 
		query.append("   AND B.RCV_TERM_CD IN (" ).append("\n"); 
		query.append("    #foreach($bkgRcvTermCds_OfcCd IN ${bkgRcvTermCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $bkgRcvTermCds.size()) '$bkgRcvTermCds_OfcCd', #else '$bkgRcvTermCds_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkgDeTermCds} != '')" ).append("\n"); 
		query.append("   AND B.DE_TERM_CD IN (" ).append("\n"); 
		query.append("    #foreach($bkgDeTermCds_OfcCd IN ${bkgDeTermCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $bkgDeTermCds.size()) '$bkgDeTermCds_OfcCd', #else '$bkgDeTermCds_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_por_cd} != '' && ${eq_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND B.EQ_CTRL_OFC_CD LIKE @[eq_ctrl_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${masterBlnos} != '')" ).append("\n"); 
		query.append("   AND B.BL_NO IN (" ).append("\n"); 
		query.append("    #foreach($masterBlnos_OfcCd IN ${masterBlnos})" ).append("\n"); 
		query.append("        #if($velocityCount < $masterBlnos.size()) '$masterBlnos_OfcCd', #else '$masterBlnos_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${masterBkgnos} != '')" ).append("\n"); 
		query.append("   AND B.BKG_NO IN (" ).append("\n"); 
		query.append("    #foreach($masterBkgnos_OfcCd IN ${masterBkgnos})" ).append("\n"); 
		query.append("        #if($velocityCount < $masterBkgnos.size()) '$masterBkgnos_OfcCd', #else '$masterBkgnos_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND B.BKG_OFC_CD LIKE @[bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${doc_usr_cd} != '')" ).append("\n"); 
		query.append("   AND B.DOC_USR_ID LIKE @[doc_usr_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND B.OB_SLS_OFC_CD LIKE @[ob_sls_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("   AND B.OB_SREP_CD LIKE @[ob_srep_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${obl_iss_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND ISS.OBL_ISS_OFC_CD LIKE @[obl_iss_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${obl_iss_usr_id} != '')" ).append("\n"); 
		query.append("   AND ISS.OBL_ISS_USR_ID LIKE @[obl_iss_usr_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rep_cmdt_cd} != '')" ).append("\n"); 
		query.append("   AND B.REP_CMDT_CD LIKE @[rep_cmdt_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   AND B.CMDT_CD LIKE @[cmdt_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${twn_so_no} != '')" ).append("\n"); 
		query.append("   AND B.TWN_SO_NO LIKE @[twn_so_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_ref_no} != '')" ).append("\n"); 
		query.append("   AND REF.CUST_REF_NO_CTNT LIKE @[cust_ref_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sc_rfa_no} != '')" ).append("\n"); 
		query.append("    #if (${sc_rfa_chk} == 'sc')" ).append("\n"); 
		query.append("       AND B.SC_NO Like @[sc_rfa_no]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sc_rfa_chk} == 'rfa')" ).append("\n"); 
		query.append("       AND B.RFA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sc_rfa_chk} == 'taa')" ).append("\n"); 
		query.append("       AND B.TAA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${orgScontiCds} != '')" ).append("\n"); 
		query.append("   AND B.ORG_SCONTI_CD IN (" ).append("\n"); 
		query.append("    #foreach($orgScontiCds_OfcCd IN ${orgScontiCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $orgScontiCds.size()) '$orgScontiCds_OfcCd', #else '$orgScontiCds_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${descScontiCds} != '')" ).append("\n"); 
		query.append("   AND B.DEST_SCONTI_CD IN (" ).append("\n"); 
		query.append("    #foreach($descScontiCds_OfcCd IN ${descScontiCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $descScontiCds.size()) '$descScontiCds_OfcCd', #else '$descScontiCds_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${orgSvcModCds} != '')" ).append("\n"); 
		query.append("   AND B.ORG_TRNS_SVC_MOD_CD IN (" ).append("\n"); 
		query.append("    #foreach($orgSvcModCds_OfcCd IN ${orgSvcModCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $orgSvcModCds.size()) '$orgSvcModCds_OfcCd', #else '$orgSvcModCds_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${descInlndSvcModCds} != '')" ).append("\n"); 
		query.append("   AND B.DEST_TRNS_SVC_MOD_CD IN (" ).append("\n"); 
		query.append("    #foreach($descInlndSvcModCds_OfcCd IN ${descInlndSvcModCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $descInlndSvcModCds.size()) '$descInlndSvcModCds_OfcCd', #else '$descInlndSvcModCds_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dcgo_flg} != '' || ${rc_flg} != '' || ${awk_cgo_flg} != '' || ${bb_cgo_flg} != '' || ${hngr_flg} != '' || ${shpr_ownr_cntr_flg} != '' || ${eq_subst_flg} != '' || ${rd_cgo_flg} != '' || ${rail_blk_cd} != '' || ${stwg_cd} != '' || ${hog_de_flg} != '' || ${prct_flg} != '' || ${fd_grd_flg} != '' || ${spcl_hide_flg} != '' )" ).append("\n"); 
		query.append("   AND (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dcgo_flg} != '')" ).append("\n"); 
		query.append("        B.DCGO_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rc_flg} != '')" ).append("\n"); 
		query.append("        B.RC_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${awk_cgo_flg} != '')" ).append("\n"); 
		query.append("        B.AWK_CGO_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bb_cgo_flg} != '')" ).append("\n"); 
		query.append("        B.BB_CGO_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hngr_flg} != '')" ).append("\n"); 
		query.append("        B.HNGR_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${shpr_ownr_cntr_flg} != '')" ).append("\n"); 
		query.append("        B.SOC_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_subst_flg} != '')" ).append("\n"); 
		query.append("        B.EQ_SUBST_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rd_cgo_flg} != '')" ).append("\n"); 
		query.append("        B.RD_CGO_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rail_blk_cd} != '')" ).append("\n"); 
		query.append("        B.RAIL_BLK_CD IS NOT NULL OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stwg_cd} != '')" ).append("\n"); 
		query.append("        B.STWG_CD IS NOT NULL OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hog_de_flg} != '')" ).append("\n"); 
		query.append("        B.HOT_DE_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prct_flg} != '')" ).append("\n"); 
		query.append("        B.PRCT_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fd_grd_flg} != '')" ).append("\n"); 
		query.append("        B.FD_GRD_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spcl_hide_flg} != '')" ).append("\n"); 
		query.append("        B.SPCL_HIDE_FLG = 'Y' OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dcgo_flg} != '' || ${rc_flg} != '' || ${awk_cgo_flg} != '' || ${bb_cgo_flg} != '' || ${hngr_flg} != '' || ${shpr_ownr_cntr_flg} != '' || ${eq_subst_flg} != '' || ${rd_cgo_flg} != '' || ${rail_blk_cd} != '' || ${stwg_cd} != '' || ${hog_de_flg} != '' || ${prct_flg} != '' || ${fd_grd_flg} != '' || ${spcl_hide_flg} != '' )" ).append("\n"); 
		query.append("       1=2)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkgCgoTpCds} != '')" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD IN (" ).append("\n"); 
		query.append("    #foreach($bkgCgoTpCds_OfcCd IN ${bkgCgoTpCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $bkgCgoTpCds.size()) '$bkgCgoTpCds_OfcCd', #else '$bkgCgoTpCds_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkgStsCds} != '')" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD IN (" ).append("\n"); 
		query.append("    #foreach($bkgStsCds_OfcCd IN ${bkgStsCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $bkgStsCds.size()) '$bkgStsCds_OfcCd', #else '$bkgStsCds_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_rsn_spcl_cgo_flg} != '')" ).append("\n"); 
		query.append("   AND B.WT_RSN_SPCL_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${wt_rsn_hld_flg} != '')" ).append("\n"); 
		query.append("   AND B.WT_RSN_HLD_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${advShtgCds} != '')" ).append("\n"); 
		query.append("   AND B.ADV_SHTG_CD IN (" ).append("\n"); 
		query.append("    #foreach($advShtgCds_OfcCd IN ${advShtgCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $advShtgCds.size()) '$advShtgCds_OfcCd', #else '$advShtgCds_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${revenueCds} != '')" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD IN (" ).append("\n"); 
		query.append("    #foreach($revenue_OfcCd IN ${revenueCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $revenueCds.size()) '$revenue_OfcCd', #else '$revenue_OfcCd' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${stop_cargo} != '')" ).append("\n"); 
		query.append("   AND B.STOP_OFF_LOC_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${cust_tp_cd_s} != '' || ${cust_tp_cd_c} != '' || ${cust_tp_cd_n} != '' || ${cust_tp_cd_f} != '' || ${cust_tp_cd_a} != '' )" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD IN (''" ).append("\n"); 
		query.append("    #if (${cust_tp_cd_s} != '')" ).append("\n"); 
		query.append("        ,'S'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_tp_cd_c} != '')" ).append("\n"); 
		query.append("        ,'C'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_tp_cd_n} != '')" ).append("\n"); 
		query.append("        ,'N'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_tp_cd_f} != '')" ).append("\n"); 
		query.append("        ,'F'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_tp_cd_a} != '')" ).append("\n"); 
		query.append("        ,'A'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("   AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("   AND C.CUST_SEQ = LTRIM(@[cust_seq],'0')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("   AND C.CUST_NM LIKE '%'||@[cust_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_pre_vvd} != '')" ).append("\n"); 
		query.append("   AND DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '1' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '1' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("           DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '2' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                  CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '2' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("               DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '3' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                      CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '3' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("                   DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '4' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                          CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '4' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("                       DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'T' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                              B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD," ).append("\n"); 
		query.append("                           DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '1' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                                  CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '1' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("                               DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '2' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                                      CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '2' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("                                      CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '3' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END))))))) LIKE @[vvd_pre_vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_pre_pol} != '')" ).append("\n"); 
		query.append("   AND DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '1' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '1' THEN V1.POL_CD END," ).append("\n"); 
		query.append("           DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '2' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                  CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '2' THEN V1.POL_CD END," ).append("\n"); 
		query.append("               DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '3' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                      CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '3' THEN V1.POL_CD END," ).append("\n"); 
		query.append("                   DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '4' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                          CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '4' THEN V1.POL_CD END," ).append("\n"); 
		query.append("                       DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'T' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                              CASE WHEN V1.VSL_PRE_PST_CD = 'T' THEN V1.POL_CD END," ).append("\n"); 
		query.append("                           DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '1' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                                  CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '1' THEN V1.POL_CD END," ).append("\n"); 
		query.append("                               DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '2' THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("                                      CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '2' THEN V1.POL_CD END," ).append("\n"); 
		query.append("                                      CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '3' THEN V1.POL_CD END))))))) LIKE @[vvd_pre_pol]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_post_vvd} != '')" ).append("\n"); 
		query.append("   AND DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '4' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '4' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("           DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '3' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                  CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '3' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("               DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '2' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                      CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '2' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("                   DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '1' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                          CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '1' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("                       DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'T' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                              B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD," ).append("\n"); 
		query.append("                           DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '4' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                                  CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '4' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("                               DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '3' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                                      CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '3' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("                                      CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '2' THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END))))))) LIKE @[vvd_post_vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_post_pod} != '')" ).append("\n"); 
		query.append("   AND DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '4' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '4' THEN V1.POD_CD END," ).append("\n"); 
		query.append("           DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '3' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                  CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '3' THEN V1.POD_CD END," ).append("\n"); 
		query.append("               DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '2' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                      CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '2' THEN V1.POD_CD END," ).append("\n"); 
		query.append("                   DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '1' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                          CASE WHEN V1.VSL_PRE_PST_CD = 'U' AND VSL_SEQ = '1' THEN V1.POD_CD END," ).append("\n"); 
		query.append("                       DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'T' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                              CASE WHEN V1.VSL_PRE_PST_CD = 'T' THEN V1.POD_CD END," ).append("\n"); 
		query.append("                           DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '4' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                                  CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '4' THEN V1.POD_CD END," ).append("\n"); 
		query.append("                               DECODE(CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '3' THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("                                      CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '3' THEN V1.POD_CD END," ).append("\n"); 
		query.append("                                      CASE WHEN V1.VSL_PRE_PST_CD = 'S' AND VSL_SEQ = '2' THEN V1.POD_CD END))))))) LIKE @[vvd_post_pod]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${aes_itn_y} != '' && ${aes_itn_n} == '')" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                 FROM BIS_XPT_IMP_LIC XI" ).append("\n"); 
		query.append("                WHERE B.BKG_NO = XI.BKG_NO" ).append("\n"); 
		query.append("                  AND XI.AES_TP_CD IS NOT NULL)" ).append("\n"); 
		query.append("#elseif (${aes_itn_n} != '' && ${aes_itn_y} == '')" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                     FROM BIS_XPT_IMP_LIC XI" ).append("\n"); 
		query.append("                    WHERE B.BKG_NO = XI.BKG_NO" ).append("\n"); 
		query.append("                      AND XI.AES_TP_CD IS NOT NULL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY b.bkg_no,REF.CUST_REF_NO_CTNT) T1," ).append("\n"); 
		query.append("       MDM_LOCATION T2," ).append("\n"); 
		query.append("       BIS_RATE T3," ).append("\n"); 
		query.append("       BIS_BL_MK_DESC T7" ).append("\n"); 
		query.append(" WHERE T1.DEL_CD = T2.LOC_CD" ).append("\n"); 
		query.append("   AND T1.BKG_NO = T3.BKG_NO(+)" ).append("\n"); 
		query.append("   AND T1.BKG_NO = T7.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_del_cd} != '' && ${eq_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND T2.FINC_CTRL_OFC_CD LIKE @[eq_ctrl_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${querySortCds} != '')" ).append("\n"); 
		query.append("    ORDER BY" ).append("\n"); 
		query.append("    #foreach($querySortCds_OfcCd IN ${querySortCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $querySortCds.size()) $querySortCds_OfcCd, #else $querySortCds_OfcCd #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}