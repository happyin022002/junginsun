/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchOpusBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchOpusBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOpusBkg
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchOpusBkgRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchOpusBkgRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append(", BK.PCTL_NO" ).append("\n"); 
		query.append(", MST.BKG_NO MST_BKG_NO" ).append("\n"); 
		query.append(", BK.MNL_BKG_NO_FLG" ).append("\n"); 
		query.append(", MST.BKG_UPLD_STS_CD" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01630' AND INTG_CD_VAL_CTNT = MST.BKG_UPLD_STS_CD) BKG_UPLD_STS_NM" ).append("\n"); 
		query.append(", BK.BL_NO" ).append("\n"); 
		query.append(", MST.DOC_TP_CDd" ).append("\n"); 
		query.append(", SH.CUST_CNT_CD SH_CNT" ).append("\n"); 
		query.append(", SH.CUST_SEQ    SH_SEQ" ).append("\n"); 
		query.append(", SH.CUST_NM     SH_NM" ).append("\n"); 
		query.append(", '' 			 S_CUST_SUBST_FLG" ).append("\n"); 
		query.append(", CASE WHEN SH.CUST_NM IS NULL AND SH.CUST_ADDR IS NULL THEN 'N' ELSE 'Y' END AS S_CUST_EXIST_FLG" ).append("\n"); 
		query.append(", FF.CUST_CNT_CD FF_CNT" ).append("\n"); 
		query.append(", FF.CUST_SEQ    FF_SEQ" ).append("\n"); 
		query.append(", FF.CUST_NM     FF_NM" ).append("\n"); 
		query.append(", '' 			 F_CUST_SUBST_FLG" ).append("\n"); 
		query.append(", CASE WHEN FF.CUST_NM IS NULL AND FF.CUST_ADDR IS NULL THEN 'N' ELSE 'Y' END AS F_CUST_EXIST_FLG" ).append("\n"); 
		query.append(", BK.OB_SREP_CD" ).append("\n"); 
		query.append(", BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append(", BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(", (SELECT VSL.VSL_ENG_NM FROM MDM_VSL_CNTR VSL WHERE BK.VSL_CD  = VSL.VSL_CD) VSL_ENG_NM" ).append("\n"); 
		query.append(", BK.POR_CD" ).append("\n"); 
		query.append(", SUBSTR(BK.POR_NOD_CD, 6, 2) POR_YD_CD" ).append("\n"); 
		query.append(", BL.POR_NM" ).append("\n"); 
		query.append(", BK.POL_CD" ).append("\n"); 
		query.append(", SUBSTR(BK.POL_NOD_CD, 6, 2) POL_YD_CD" ).append("\n"); 
		query.append(", BL.POL_NM" ).append("\n"); 
		query.append(", BK.POD_CD" ).append("\n"); 
		query.append(", SUBSTR(BK.POD_NOD_CD, 6, 2) POD_YD_CD" ).append("\n"); 
		query.append(", BL.POD_NM" ).append("\n"); 
		query.append(", BK.DEL_CD" ).append("\n"); 
		query.append(", SUBSTR(BK.DEL_NOD_CD, 6, 2) DEL_YD_CD" ).append("\n"); 
		query.append(", BL.DEL_NM" ).append("\n"); 
		query.append(", BK.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(", BK.PST_RLY_PORT_CD" ).append("\n"); 
		query.append(", BK.FNL_DEST_CD" ).append("\n"); 
		query.append(", BL.FNL_DEST_NM" ).append("\n"); 
		query.append(", BK.RCV_TERM_CD RCV_TERM" ).append("\n"); 
		query.append(", BK.DE_TERM_CD  DLV_TERM" ).append("\n"); 
		query.append(", BK.ORG_SCONTI_CD" ).append("\n"); 
		query.append(", BK.DEST_SCONTI_CD" ).append("\n"); 
		query.append(", BK.ORG_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append(", BK.DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append(", BK.ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append(", BK.DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append(", RT.FRT_TERM_CD" ).append("\n"); 
		query.append(", DECODE(NVL(TAA_NO, 'X'), 'X', DECODE(NVL(RFA_NO, 'X'), 'X', NULL, 'RFA'),'TAA') CTRT_TYPE" ).append("\n"); 
		query.append(", BK.SC_NO SC_NO" ).append("\n"); 
		query.append(", BK.RFA_NO RFA_NO" ).append("\n"); 
		query.append(", BK.TAA_NO" ).append("\n"); 
		query.append(", BK.TWN_SO_NO" ).append("\n"); 
		query.append(", BK.CMDT_CD" ).append("\n"); 
		query.append(", (SELECT CMDT.CMDT_NM FROM MDM_COMMODITY CMDT WHERE CMDT.CMDT_CD = BK.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append(", BK.REP_CMDT_CD" ).append("\n"); 
		query.append(", (SELECT REP.REP_CMDT_NM FROM MDM_REP_CMDT REP WHERE REP.REP_CMDT_CD = BK.REP_CMDT_CD) REP_CMDT_NM" ).append("\n"); 
		query.append(", BK.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(", BK.CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append(", BL.ACT_WGT" ).append("\n"); 
		query.append(", BL.WGT_UT_CD" ).append("\n"); 
		query.append(", BK.DCGO_FLG" ).append("\n"); 
		query.append(", BK.RC_FLG" ).append("\n"); 
		query.append(", BK.AWK_CGO_FLG" ).append("\n"); 
		query.append(", BK.BB_CGO_FLG" ).append("\n"); 
		query.append(", BK.RD_CGO_FLG" ).append("\n"); 
		query.append(", BK.SOC_FLG" ).append("\n"); 
		query.append(", BK.FLEX_HGT_FLG" ).append("\n"); 
		query.append(", TO_CHAR(BK.MTY_DOR_ARR_DT, 'YYYY-MM-DD') DOOR_DATE" ).append("\n"); 
		query.append(", TO_CHAR(BK.LODG_DUE_DT,    'YYYY-MM-DD') LOADING_DATE" ).append("\n"); 
		query.append(", TO_CHAR(BK.DE_DUE_DT,      'YYYY-MM-DD') DELIVERY_DATE" ).append("\n"); 
		query.append(", BK.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append(", TO_CHAR(BK.MTY_PKUP_DT,    'YYYY-MM-DD') PKUP_DATE" ).append("\n"); 
		query.append(", BK.FULL_RTN_YD_CD" ).append("\n"); 
		query.append(", BK.MTY_RTN_YD_CD" ).append("\n"); 
		query.append(", BK.FULL_PKUP_YD_CD" ).append("\n"); 
		query.append(", BK.XTER_RMK" ).append("\n"); 
		query.append(", BK.INTER_RMK" ).append("\n"); 
		query.append(", BL.BDR_FLG 		BDR_FLG" ).append("\n"); 
		query.append(", BL.BDR_FLG 		CA_FLG" ).append("\n"); 
		query.append(", BK.EDI_HLD_FLG	EDI_HLD_FLG" ).append("\n"); 
		query.append(", BK.XTER_RQST_AUTO_NTC_FLG AUTO_NOTIFICATION" ).append("\n"); 
		query.append(", BK_CNTC.CNTC_PSON_NM      BK_CNTC_PSON_NM" ).append("\n"); 
		query.append(", BK_CNTC.CNTC_PSON_PHN_NO  BK_CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(", BK_CNTC.CNTC_PSON_MPHN_NO BK_CNTC_PSON_MPHN_NO" ).append("\n"); 
		query.append(", BK_CNTC.CNTC_PSON_FAX_NO  BK_CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(", BK_CNTC.CNTC_PSON_EML     BK_CNTC_PSON_EML" ).append("\n"); 
		query.append(", SI_CNTC.CNTC_PSON_NM      SI_CNTC_PSON_NM" ).append("\n"); 
		query.append(", SI_CNTC.CNTC_PSON_PHN_NO  SI_CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(", SI_CNTC.CNTC_PSON_MPHN_NO SI_CNTC_PSON_MPHN_NO" ).append("\n"); 
		query.append(", SI_CNTC.CNTC_PSON_FAX_NO  SI_CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(", SI_CNTC.CNTC_PSON_EML     SI_CNTC_PSON_EML" ).append("\n"); 
		query.append(", BK.BKG_STS_CD" ).append("\n"); 
		query.append(", BK.XTER_BKG_RQST_CD" ).append("\n"); 
		query.append(", BK.XTER_BKG_RQST_REF_NO" ).append("\n"); 
		query.append(", BK.SI_FLG" ).append("\n"); 
		query.append(", BK.XTER_SI_CD" ).append("\n"); 
		query.append(", BK.XTER_SI_REF_NO" ).append("\n"); 
		query.append(", (SELECT COUNT(1) FROM BKG_ROLL_OVR WHERE BKG_NO = BK.BKG_NO) ROLL_OVR_CNT" ).append("\n"); 
		query.append(", NVL((SELECT 'Y'" ).append("\n"); 
		query.append("FROM bkg_customer cust, mdm_customer mdm_cust" ).append("\n"); 
		query.append("WHERE cust.cust_cnt_cd = mdm_cust.cust_cnt_cd" ).append("\n"); 
		query.append("AND cust.cust_seq    = mdm_cust.cust_seq" ).append("\n"); 
		query.append("AND cust.bkg_no      = bk.bkg_no" ).append("\n"); 
		query.append("AND cust.bkg_cust_tp_cd in ('S', 'F')" ).append("\n"); 
		query.append("AND mdm_cust.VBS_CLSS_CD = '01'" ).append("\n"); 
		query.append("AND ROWNUM = 1), 'N') premium_available_flg" ).append("\n"); 
		query.append(", NVL((SELECT 'Y'" ).append("\n"); 
		query.append("FROM bkg_booking bk1, bkg_container cntr1" ).append("\n"); 
		query.append(", bkg_booking bk2, bkg_container cntr2" ).append("\n"); 
		query.append("WHERE bk1.bkg_no        = cntr1.bkg_no" ).append("\n"); 
		query.append("AND bk2.bkg_no        = cntr2.bkg_no" ).append("\n"); 
		query.append("AND bk1.bkg_no        <> bk2.bkg_no   --다른 bkg" ).append("\n"); 
		query.append("AND cntr1.cntr_no     = cntr2.cntr_no --같은 cntr" ).append("\n"); 
		query.append("AND bk1.bkg_cgo_tp_cd = bk2.bkg_cgo_tp_Cd" ).append("\n"); 
		query.append("AND bk1.pol_cd        = bk2.pol_cd" ).append("\n"); 
		query.append("AND bk1.pod_cd        = bk2.pod_cd" ).append("\n"); 
		query.append("AND bk1.vsl_cd        = bk2.vsl_cd" ).append("\n"); 
		query.append("AND bk1.skd_voy_no    = bk2.skd_voy_no" ).append("\n"); 
		query.append("AND bk1.skd_dir_cd    = bk2.skd_dir_cd" ).append("\n"); 
		query.append("AND cntr1.cntr_prt_flg= 'Y'" ).append("\n"); 
		query.append("AND cntr2.cntr_prt_flg= 'Y'" ).append("\n"); 
		query.append("AND bk1.bkg_sts_cd    <> 'X'" ).append("\n"); 
		query.append("AND bk2.bkg_sts_cd    <> 'X'" ).append("\n"); 
		query.append("AND bk1.bkg_no        = bk.bkg_no" ).append("\n"); 
		query.append("AND ROWNUM = 1), 'N') partial_vvd_assign_flg" ).append("\n"); 
		query.append(", (SELECT CASE WHEN vvd_count != skd_count then 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("FROM (SELECT COUNT(1) vvd_count" ).append("\n"); 
		query.append("FROM bkg_vvd" ).append("\n"); 
		query.append("WHERE bkg_no           = @[bkg_no]" ).append("\n"); 
		query.append("AND vsl_cd IS NOT NULL) vvd," ).append("\n"); 
		query.append("(SELECT COUNT(1) skd_count" ).append("\n"); 
		query.append("FROM vsk_vsl_port_skd pol, vsk_vsl_port_skd pod, bkg_vvd vvd" ).append("\n"); 
		query.append("WHERE bkg_no           = @[bkg_no]" ).append("\n"); 
		query.append("AND vvd.vsl_cd       = pol.vsl_cd" ).append("\n"); 
		query.append("AND vvd.skd_voy_no   = pol.skd_voy_no" ).append("\n"); 
		query.append("AND vvd.skd_dir_cd   = pol.skd_dir_cd" ).append("\n"); 
		query.append("AND vvd.pol_cd       = pol.vps_port_cd" ).append("\n"); 
		query.append("AND NVL(vvd.POl_CLPT_IND_SEQ, 1) = pol.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND NVL(pol.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("AND vvd.vsl_cd       = pod.vsl_cd" ).append("\n"); 
		query.append("AND vvd.skd_voy_no   = pod.skd_voy_no" ).append("\n"); 
		query.append("AND vvd.skd_dir_cd   = pod.skd_dir_cd" ).append("\n"); 
		query.append("AND vvd.pod_cd       = pod.vps_port_cd" ).append("\n"); 
		query.append("AND NVL(vvd.POd_CLPT_IND_SEQ, 1) = pod.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND NVL(pod.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append(") skd) VVD_FLG" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append(", BKG_CUSTOMER SH" ).append("\n"); 
		query.append(", BKG_CUSTOMER FF" ).append("\n"); 
		query.append(", BKG_BL_DOC BL" ).append("\n"); 
		query.append(", BKG_RATE RT" ).append("\n"); 
		query.append(", BKG_CNTC_PSON BK_CNTC" ).append("\n"); 
		query.append(", BKG_CNTC_PSON SI_CNTC" ).append("\n"); 
		query.append(", BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("WHERE NVL(@[bkg_no], MST.BKG_NO) = SH.BKG_NO		 (+)" ).append("\n"); 
		query.append("AND 'S'        = SH.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND NVL(@[bkg_no], MST.BKG_NO) = FF.BKG_NO        (+)" ).append("\n"); 
		query.append("AND 'F'        = FF.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND NVL(@[bkg_no], MST.BKG_NO) = RT.BKG_NO	 	 (+)" ).append("\n"); 
		query.append("AND NVL(@[bkg_no], MST.BKG_NO) = BL.BKG_NO		 (+)" ).append("\n"); 
		query.append("AND NVL(@[bkg_no], MST.BKG_NO) = BK_CNTC.BKG_NO   (+)" ).append("\n"); 
		query.append("AND 'BK'       = BK_CNTC.BKG_CNTC_PSON_TP_CD(+)" ).append("\n"); 
		query.append("AND BK.BKG_NO  = SI_CNTC.BKG_NO   (+)" ).append("\n"); 
		query.append("AND 'SI'       = SI_CNTC.BKG_CNTC_PSON_TP_CD(+)" ).append("\n"); 
		query.append("AND NVL(@[bkg_no], MST.BKG_NO)       = BK.BKG_NO  (+)" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 

	}
}