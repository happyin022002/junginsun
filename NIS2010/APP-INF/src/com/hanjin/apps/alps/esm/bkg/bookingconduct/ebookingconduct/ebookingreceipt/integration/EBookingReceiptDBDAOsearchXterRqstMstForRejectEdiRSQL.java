/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRqstMstForRejectEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.10
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.01.10 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterRqstMstForRejectEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterRqstMstForRejectEdi
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterRqstMstForRejectEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reject_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterRqstMstForRejectEdiRSQL").append("\n"); 
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
		query.append("select DECODE(@[rcv_id], 'INTT', NVL(TRIM(mst.BKG_NO), 'REBK'||@[sender_id]),'TRAD', NVL(TRIM(mst.BKG_NO), 'DECLINE'), mst.BKG_NO) bkgnbr" ).append("\n"); 
		query.append("    , NULL	                             bkg_dt          " ).append("\n"); 
		query.append("    , decode(@[rcv_id],'PKEX','RE','R')	 brac            " ).append("\n"); 
		query.append("    , mst.BL_NO_ctnt||mst.xter_bl_tp_cd	 bl_no           " ).append("\n"); 
		query.append("    , NULL		                         bkg_lane        " ).append("\n"); 
		query.append("    , vsl_cd                             tovsl           " ).append("\n"); 
		query.append("    , NULL	                             loyd            " ).append("\n"); 
		query.append("    , vsl_nm	                         vslname         " ).append("\n"); 
		query.append("    , NULL	                             vsl_call_sign   " ).append("\n"); 
		query.append("    , skd_voy_no	                     tovoy           " ).append("\n"); 
		query.append("    , SKD_DIR_CD	                     todir           " ).append("\n"); 
		query.append("    , NULL	                             vslld           " ).append("\n"); 
		query.append("    , NULL	                             vsld            " ).append("\n"); 
		query.append("    , NULL	                             oldvsl          " ).append("\n"); 
		query.append("    , NULL	                             oldloyd         " ).append("\n"); 
		query.append("    , NULL	                             oldvslname      " ).append("\n"); 
		query.append("    , NULL	                             oldvsl_call_sign" ).append("\n"); 
		query.append("    , NULL	                             oldvoy          " ).append("\n"); 
		query.append("    , NULL	                             olddir          " ).append("\n"); 
		query.append("    , vsl_cd	                         tvsl            " ).append("\n"); 
		query.append("    , NULL	                             tloyd           " ).append("\n"); 
		query.append("    , vsl_nm	                         tvslname        " ).append("\n"); 
		query.append("    , NULL	                             tvsl_call_sign  " ).append("\n"); 
		query.append("    , skd_voy_no	                     tvoy            " ).append("\n"); 
		query.append("    , SKD_DIR_CD	                     tdir            " ).append("\n"); 
		query.append("    , POR_NM	                         name1           " ).append("\n"); 
		query.append("    , NULL	                             qual1           " ).append("\n"); 
		query.append("    , NULL                           	 port1           " ).append("\n"); 
		query.append("    , POR_CD	                         unlc1           " ).append("\n"); 
		query.append("    , POL_NM	                         name2           " ).append("\n"); 
		query.append("    , NULL	                             qual2           " ).append("\n"); 
		query.append("    , NULL	                             port2           " ).append("\n"); 
		query.append("    , POL_CD	                         unlc2           " ).append("\n"); 
		query.append("    , NULL		                         eta2            " ).append("\n"); 
		query.append("    , NULL		                         etd2            " ).append("\n"); 
		query.append("    , NULL		                         cct2            " ).append("\n"); 
		query.append("    , NULL		                         vps_cct_dt      " ).append("\n"); 
		query.append("    , POD_NM		                     name3           " ).append("\n"); 
		query.append("    , NULL		                         qual3           " ).append("\n"); 
		query.append("    , NULL		                         port3           " ).append("\n"); 
		query.append("    , POD_CD		                     unlc3           " ).append("\n"); 
		query.append("    , NULL		                         eta3            " ).append("\n"); 
		query.append("    , NULL		                         eta3_1          " ).append("\n"); 
		query.append("    , NULL		                         etd3            " ).append("\n"); 
		query.append("    , NULL		                         etd4            " ).append("\n"); 
		query.append("    , NULL		                         bed3            " ).append("\n"); 
		query.append("    , DEL_NM		                     name4           " ).append("\n"); 
		query.append("    , NULL		                         qual4           " ).append("\n"); 
		query.append("    , NULL		                         port4           " ).append("\n"); 
		query.append("    , DEL_CD		                     unlc4           " ).append("\n"); 
		query.append("    , NULL		                         eta4            " ).append("\n"); 
		query.append("    , NULL		                         name5           " ).append("\n"); 
		query.append("    , NULL		                         qual5           " ).append("\n"); 
		query.append("    , NULL		                         port5           " ).append("\n"); 
		query.append("    , NULL		                         unlc5           " ).append("\n"); 
		query.append("    , Pck_tp_cd		                     punit           " ).append("\n"); 
		query.append("    , NVL(Pck_QTY,0)                     pkg             " ).append("\n"); 
		query.append("    , DECODE(@[sender_id], 'INTT', substr(estm_wgt_ut_cd, 1, 1), estm_wgt_ut_cd)	wunit           " ).append("\n"); 
		query.append("    , estm_WGT		                     wgt             " ).append("\n"); 
		query.append("    , NULL		                         ewunit          " ).append("\n"); 
		query.append("    , NULL		                         ewgt            " ).append("\n"); 
		query.append("    , DECODE(@[sender_id], 'INTT', substr(MEAs_ut_cd, 3, 1), MEAs_ut_cd)	munit           " ).append("\n"); 
		query.append("    , MEAs_QTY		             		 meas            " ).append("\n"); 
		query.append("    , RCV_TERM_cd||de_TERM_cd	         rdtyp           " ).append("\n"); 
		query.append("    , NULL		                         smod            " ).append("\n"); 
		query.append("    , NULL		                         truck           " ).append("\n"); 
		query.append("    , replace(rjct_rsn_rmk, CHR(13)||CHR(10), ' ')	remark          " ).append("\n"); 
		query.append("    , CMDT_CD		                     cmd             " ).append("\n"); 
		query.append("    , CMDT_DESC	                         cmdd            " ).append("\n"); 
		query.append("    , NULL		                         eqrel           " ).append("\n"); 
		query.append("    , NULL		                         shn1            " ).append("\n"); 
		query.append("    , NULL		                         ffn1            " ).append("\n"); 
		query.append("    , NULL		                         cne1            " ).append("\n"); 
		query.append("    , sh.CNT_CD||DECODE(sh.CUST_seq, '0', null, sh.CUST_seq) sh_cd1          " ).append("\n"); 
		query.append("    , cn.CNT_CD||DECODE(cn.CUST_seq, '0', null, cn.CUST_seq) ff_cd1          " ).append("\n"); 
		query.append("    , ff.CNT_CD||DECODE(ff.CUST_seq, '0', null, ff.CUST_seq) cn_cd1          " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(sh.cust_nm,  ' '), CHR(13)||CHR(10), ' '),  1, 35)	shpr1           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(sh.cust_nm,  ' '), CHR(13)||CHR(10), ' '), 36, 35)	shpr2           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(sh.cust_addr,' '), CHR(13)||CHR(10), ' '),  1, 35)	shpr3           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(sh.cust_addr,' '), CHR(13)||CHR(10), ' '), 36, 35)	shpr4           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(sh.cust_addr,' '), CHR(13)||CHR(10), ' '), 71, 35)	shpr5           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(cn.cust_nm,  ' '), CHR(13)||CHR(10), ' '),  1, 35)	cnee1           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(cn.cust_nm,  ' '), CHR(13)||CHR(10), ' '), 36, 35)	cnee2           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(cn.cust_addr,' '), CHR(13)||CHR(10), ' '),  1, 35)	cnee3           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(cn.cust_addr,' '), CHR(13)||CHR(10), ' '), 36, 35)	cnee4           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(cn.cust_addr,' '), CHR(13)||CHR(10), ' '), 71, 35)	cnee5           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(ff.cust_nm,  ' '), CHR(13)||CHR(10), ' '),  1, 35)	ntfy1           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(ff.cust_nm,  ' '), CHR(13)||CHR(10), ' '), 36, 35)	ntfy2           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(ff.cust_addr,' '), CHR(13)||CHR(10), ' '),  1, 35)	ntfy3           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(ff.cust_addr,' '), CHR(13)||CHR(10), ' '), 36, 35)	ntfy4           " ).append("\n"); 
		query.append("    , SUBSTR(REPLACE(NVL(ff.cust_addr,' '), CHR(13)||CHR(10), ' '), 71, 35)	ntfy5           " ).append("\n"); 
		query.append("    , rqst_delt_flg	                     cancel_bit      " ).append("\n"); 
		query.append("    , NULL		                         cargotype       " ).append("\n"); 
		query.append("    , dcgo_flg		                     dr_ind          " ).append("\n"); 
		query.append("    , rc_flg		                     rf_ind          " ).append("\n"); 
		query.append("    , awk_cgo_flg		                 ak_ind          " ).append("\n"); 
		query.append("    , NULL		                         bb_ind          " ).append("\n"); 
		query.append("    , NULL		                         hd_ind          " ).append("\n"); 
		query.append("    , NULL		                         ud_ind          " ).append("\n"); 
		query.append("    , NULL		                         rd_und          " ).append("\n"); 
		query.append("    , NULL		                         rf_ca           " ).append("\n"); 
		query.append("    , NULL		                         rf_ma           " ).append("\n"); 
		query.append("    , NULL		                         soc_ind         " ).append("\n"); 
		query.append("    , sls_ofc_cd 	                     sales_office    " ).append("\n"); 
		query.append("    , NULL		                         sales_name      " ).append("\n"); 
		query.append("    , mst.cntc_nm		                 contact_name    " ).append("\n"); 
		query.append("    , mst.cntc_phn_no		             contact_tel     " ).append("\n"); 
		query.append("    , 'E'		                         bound_ind       " ).append("\n"); 
		query.append("    , NULL		                         regional_bkgnbr " ).append("\n"); 
		query.append("    , mst.xter_rqst_no	                 cust_ref_no     " ).append("\n"); 
		query.append("    , SKD_VOY_NO||SKD_DIR_CD	         ref_voyage      " ).append("\n"); 
		query.append("    , NULL		                         so_no           " ).append("\n"); 
		query.append("    , NULL		                         blkstwg         " ).append("\n"); 
		query.append("    , TO_CHAR(mty_pkup_dt, 'YYYYMMDDHH24MI') eqpickdt        " ).append("\n"); 
		query.append("    , NULL		                         eqrtn           " ).append("\n"); 
		query.append("    , NULL		                         pucy_cnt        " ).append("\n"); 
		query.append("    , NULL		                         pucy_cd" ).append("\n"); 
		query.append("    , NULL		                         pucy_nm          " ).append("\n"); 
		query.append("    , NULL		                         pucy_addr1      " ).append("\n"); 
		query.append("    , NULL		                         pucy_addr2      " ).append("\n"); 
		query.append("    , NULL		                         pucy_addr3      " ).append("\n"); 
		query.append("    , NULL		                         pucy_addr4      " ).append("\n"); 
		query.append("    , NULL		                         pucy_addr5      " ).append("\n"); 
		query.append("    , NULL		                         rtcy_cnt        " ).append("\n"); 
		query.append("    , NULL		                         rtcy_cd" ).append("\n"); 
		query.append("    , NULL		                         rtcy_nm         " ).append("\n"); 
		query.append("    , NULL		                         rtcy_addr1      " ).append("\n"); 
		query.append("    , NULL		                         rtcy_addr2      " ).append("\n"); 
		query.append("    , NULL		                         rtcy_addr3      " ).append("\n"); 
		query.append("    , NULL		                         rtcy_addr4      " ).append("\n"); 
		query.append("    , NULL		                         rtcy_addr5      " ).append("\n"); 
		query.append("    , PO_NO		                         bl_po_no        " ).append("\n"); 
		query.append("    , SI_NO		                         bl_si_no        " ).append("\n"); 
		query.append("    , NULL		                         frt_term        " ).append("\n"); 
		query.append("    , BKG_OFC_cd		                 bkg_ofc         " ).append("\n"); 
		query.append("    , NULL		                         onboard" ).append("\n"); 
		query.append("    , 'R'		                         cfm_ind         " ).append("\n"); 
		query.append("    , replace(@[reject_rmk], CHR(13)||CHR(10),' ')	rej_desc        " ).append("\n"); 
		query.append("    , mst.ctrt_NO		                 sc_no" ).append("\n"); 
		query.append("    , substr(mst.xter_rqst_via_cd,1,1)   ib_ie_ind" ).append("\n"); 
		query.append("    , NULL		                         BV_LANE" ).append("\n"); 
		query.append("    , NULL		                         VVD_REF_NO" ).append("\n"); 
		query.append("    , NULL		                         UD_CD" ).append("\n"); 
		query.append("    , NULL		                         BKG_STF" ).append("\n"); 
		query.append("    , NULL		                         BKG_STF_NAME" ).append("\n"); 
		query.append("    , NULL		                         BKG_STF_TEL" ).append("\n"); 
		query.append("    , NULL		                         BKG_STF_FAX" ).append("\n"); 
		query.append("    , (SELECT  decode(seq, 'A', id, id||lPAD(seq, 5, '0'))" ).append("\n"); 
		query.append("      FROM    (SELECT substr(esvc_grp_cd, 1, 3) id, min(trim(substr(nvl(esvc_grp_cd, 'A'), 4, 7))) seq" ).append("\n"); 
		query.append("                FROM    bkg_edi_grp eg" ).append("\n"); 
		query.append("                WHERE   eg.cust_trd_prnr_id = decode(substr(@[rcv_id], 1, 4), 'PKEX', 'PKEXM010', 'TRAD', 'TRADIANT', 'APLU', 'APLUPROD',@[rcv_id])" ).append("\n"); 
		query.append("                and     eg.esvc_grp_delt_flg = 'N'" ).append("\n"); 
		query.append("                GROUP BY substr(esvc_grp_cd, 1, 3)" ).append("\n"); 
		query.append("                ORDER BY substr(esvc_grp_cd, 1, 3))" ).append("\n"); 
		query.append("      WHERE   rownum  = 1) edi_group_id" ).append("\n"); 
		query.append("  FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("       , bkg_xter_cust sh" ).append("\n"); 
		query.append("       , bkg_xter_cust cn" ).append("\n"); 
		query.append("       , bkg_xter_cust ff" ).append("\n"); 
		query.append(" where mst.xter_sndr_id  = sh.xter_sndr_id    (+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_no  = sh.xter_rqst_no    (+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq = sh.xter_rqst_seq   (+)" ).append("\n"); 
		query.append("   and mst.xter_sndr_id  = cn.xter_sndr_id    (+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_no  = cn.xter_rqst_no    (+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq = cn.xter_rqst_seq   (+)" ).append("\n"); 
		query.append("   and mst.xter_sndr_id  = ff.xter_sndr_id    (+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_no  = ff.xter_rqst_no    (+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq = ff.xter_rqst_seq   (+)" ).append("\n"); 
		query.append("   AND 'S'               = sh.xter_cust_tp_cd (+)" ).append("\n"); 
		query.append("   AND 'C'               = cn.xter_cust_tp_cd (+)" ).append("\n"); 
		query.append("   AND 'N'               = ff.xter_cust_tp_cd (+)" ).append("\n"); 
		query.append("   AND mst.xter_sndr_id  = @[sender_id]" ).append("\n"); 
		query.append("   AND mst.xter_rqst_no  = @[rqst_no]" ).append("\n"); 
		query.append("   AND mst.xter_rqst_seq = @[rqst_seq]" ).append("\n"); 

	}
}