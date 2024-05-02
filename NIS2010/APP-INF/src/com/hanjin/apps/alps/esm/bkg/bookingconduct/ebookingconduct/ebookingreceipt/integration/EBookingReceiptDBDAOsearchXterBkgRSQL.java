/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterBkg
	  * 2011.02.09 김영철 [CHM-201108366-01] E-SVC 화면 PICKUP DATE 항목 추가요청
	  * 2013.05.13 임재관 [CHM-201324602] e-Booking & SI Process 상 Special 정보 column 추가
	  * 2018.05.28 이인영 소문자로 들어온 입력값을 화면에서 대문자로 표시함.
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterBkgRSQL").append("\n"); 
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
		query.append("select mst.bkg_no" ).append("\n"); 
		query.append("        , mst.xter_rqst_no" ).append("\n"); 
		query.append("        , mst.XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("        , (select INTG_CD_VAL_DESC from com_intg_cd_dtl where INTG_CD_ID = 'CD01622' and INTG_CD_VAL_CTNT = mst.XTER_RQST_VIA_CD) XTER_RQST_VIA_NM" ).append("\n"); 
		query.append("        , MST.BKG_UPLD_STS_CD " ).append("\n"); 
		query.append("        , (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01630' AND INTG_CD_VAL_CTNT = MST.BKG_UPLD_STS_CD) BKG_UPLD_STS_NM" ).append("\n"); 
		query.append("        , MST.DOC_TP_CD" ).append("\n"); 
		query.append("        , mst.bl_no_ctnt" ).append("\n"); 
		query.append("        , decode(nvl((select count(1) from bkg_booking where bkg_no = mst.bkg_no), 0), 0, 'No', 'Yes') ALPS" ).append("\n"); 
		query.append("        , mst.hbl_knt" ).append("\n"); 
		query.append("        , UPPER(sh.cnt_cd)   sh_cnt_cd" ).append("\n"); 
		query.append("        , UPPER(sh.cust_seq) sh_cust_seq" ).append("\n"); 
		query.append("        , UPPER(sh.cust_nm)  sh_cust_nm" ).append("\n"); 
		query.append("        , UPPER(ff.cnt_cd)   ff_cnt_cd" ).append("\n"); 
		query.append("        , UPPER(ff.cust_seq) ff_cust_seq" ).append("\n"); 
		query.append("        , UPPER(ff.cust_nm)  ff_cust_nm" ).append("\n"); 
		query.append("        , UPPER(mst.VSL_CD||SKD_VOY_NO||SKD_DIR_CD) vvd" ).append("\n"); 
		query.append("        , UPPER(mst.VSL_NM) VSL_NM" ).append("\n"); 
		query.append("        , UPPER(mst.SREP_CD) SREP_CD" ).append("\n"); 
		query.append("        , UPPER(mst.por_Cd) POR_CD" ).append("\n"); 
		query.append("        , UPPER(mst.por_nm) POR_NM" ).append("\n"); 
		query.append("        , UPPER(mst.pol_Cd) POL_CD" ).append("\n"); 
		query.append("        , UPPER(mst.pol_nm) POL_NM" ).append("\n"); 
		query.append("        , UPPER(mst.pod_Cd) POD_CD" ).append("\n"); 
		query.append("        , UPPER(mst.pod_nm) POD_NM" ).append("\n"); 
		query.append("        , UPPER(mst.del_Cd) DEL_CD" ).append("\n"); 
		query.append("        , UPPER(mst.del_nm) DEL_NM" ).append("\n"); 
		query.append("        , UPPER(SUBSTR(MST.POR_NOD_CD,6,2)) POR_YD_CD" ).append("\n"); 
		query.append("        , UPPER(SUBSTR(MST.POL_NOD_CD,6,2)) POL_YD_CD" ).append("\n"); 
		query.append("        , UPPER(SUBSTR(MST.POD_NOD_CD,6,2)) POD_YD_CD" ).append("\n"); 
		query.append("        , UPPER(SUBSTR(MST.DEL_NOD_CD,6,2)) DEL_YD_CD" ).append("\n"); 
		query.append("        , UPPER(mst.fnl_dest_nm) FNL_DEST_NM" ).append("\n"); 
		query.append("        , mst.FRT_TERM_CD" ).append("\n"); 
		query.append("        , (select INTG_CD_VAL_DESC from com_intg_cd_dtl where INTG_CD_ID = 'CD00764' and INTG_CD_VAL_CTNT = mst.RCV_TERM_CD) rcv_term" ).append("\n"); 
		query.append("        , (select INTG_CD_VAL_DESC from com_intg_cd_dtl where INTG_CD_ID = 'CD00765' and INTG_CD_VAL_CTNT = mst.DE_TERM_CD) dlv_term" ).append("\n"); 
		query.append("        , UPPER(mst.TWN_SO_NO) TWN_SO_NO" ).append("\n"); 
		query.append("        , UPPER(decode(length(trim(mst.ctrt_no)), 8, 'SC', 9, 'SC', 'RFA')) SC_RFA" ).append("\n"); 
		query.append("        , UPPER(mst.ctrt_no) CTRT_NO" ).append("\n"); 
		query.append("        , UPPER(mst.cmdt_Cd) CMDT_CD" ).append("\n"); 
		query.append("        , UPPER(mst.cmdt_desc) CMDT_DESC" ).append("\n"); 
		query.append("        , mst.USA_CSTMS_FILE_ctnt" ).append("\n"); 
		query.append("        , mst.CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("        , mst.ESTM_WGT" ).append("\n"); 
		query.append("		, DECODE(SUBSTR(mst.ESTM_WGT_UT_CD,1,1),'K','KGS',mst.ESTM_WGT_UT_CD) ESTM_WGT_UT_CD" ).append("\n"); 
		query.append("        , mst.DCGO_FLG" ).append("\n"); 
		query.append("        , mst.RC_FLG" ).append("\n"); 
		query.append("        , mst.AWK_CGO_FLG" ).append("\n"); 
		query.append("        , mst.BB_CGO_FLG" ).append("\n"); 
		query.append("        , mst.SOC_FLG" ).append("\n"); 
		query.append("        , to_char(mst.RQST_RTN_DT, 'yyyy-mm-dd') return_dt" ).append("\n"); 
		query.append("        , to_char(mst.RQST_DEP_DT, 'yyyy-mm-dd') departure_Dt" ).append("\n"); 
		query.append("        , to_char(mst.RQST_ARR_DT, 'yyyy-mm-dd') arrival_dt       " ).append("\n"); 
		query.append("        , mst.XTER_BKG_RMK1||mst.XTER_BKG_RMK2 " ).append("\n"); 
		query.append("        || CHR(13)" ).append("\n"); 
		query.append("        || REPLACE(BKG_JOIN_FNC( CURSOR(" ).append("\n"); 
		query.append("                                SELECT WFG_MF_NO" ).append("\n"); 
		query.append("                                  FROM BKG_XTER_WFG WFG" ).append("\n"); 
		query.append("                                 WHERE WFG.XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                   AND WFG.XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                                   AND WFG.XTER_RQST_SEQ = MST.XTER_RQST_SEQ)), ',', CHR(13))" ).append("\n"); 
		query.append("        || CASE WHEN XTER_RQST_VIA_CD = 'SIM' AND DOC_TP_CD ='B' THEN CHR(13) || ex.cust_nm END rmk " ).append("\n"); 
		query.append("        , decode(mst.AUTO_EML_FLG, 'Y', 'Yes', 'No') auto_notification" ).append("\n"); 
		query.append("        , mst.CNTC_EML" ).append("\n"); 
		query.append("        , mst.CNTC_NM" ).append("\n"); 
		query.append("        , mst.CNTC_PHN_AREA_NO||mst.CNTC_PHN_NO||mst.CNTC_XTN_PHN_NO tel" ).append("\n"); 
		query.append("        , mst.CNTC_MPHN_NO mobile" ).append("\n"); 
		query.append("        , mst.CNTC_FAX_AREA_NO||mst.CNTC_FAX_NO fax" ).append("\n"); 
		query.append("        , MST.SI_CNTC_EML" ).append("\n"); 
		query.append("        , MST.SI_CNTC_NM" ).append("\n"); 
		query.append("        , MST.SI_CNTC_PHN_AREA_NO || MST.SI_CNTC_PHN_NO || MST.SI_CNTC_XTN_PHN_NO AS SI_TEL" ).append("\n"); 
		query.append("        , MST.SI_CNTC_MPHN_NO AS SI_MOBILE" ).append("\n"); 
		query.append("        , MST.SI_CNTC_FAX_AREA_NO || MST.SI_CNTC_FAX_NO AS SI_FAX" ).append("\n"); 
		query.append("		, mst.XTER_BKG_RQST_STS_CD" ).append("\n"); 
		query.append("		, MST.SNACCS_SPLIT_NO" ).append("\n"); 
		query.append("		, mst.XTER_CHG_ARR_FLG" ).append("\n"); 
		query.append("		, MST.XTER_AGN_DP_FLG" ).append("\n"); 
		query.append("		, MST.XTER_LIST_DP_FLG" ).append("\n"); 
		query.append("		, MST.XTER_BL_TP_CD AS WY_BL_FLG" ).append("\n"); 
		query.append("		, NVL(MST.BL_ISS_LOC_CD, MST.BL_ISS_LOC_NM) AS BL_ISS_LOC_CD" ).append("\n"); 
		query.append("		, MST.BL_ISS_DT" ).append("\n"); 
		query.append("		, MST.INCL_RT_BL_KNT" ).append("\n"); 
		query.append("		, MST.XCLD_RT_BL_KNT" ).append("\n"); 
		query.append("		, NVL(mst.XTER_RQST_ACPT_CD, 'X') XTER_RQST_ACPT_CD" ).append("\n"); 
		query.append("		, mst.XTER_RQST_ACPT_USR_ID" ).append("\n"); 
		query.append("		, (SELECT USR_NM FROM COM_USER WHERE UPPER(USR_ID) = UPPER(mst.XTER_RQST_ACPT_USR_ID)) XTER_RQST_ACPT_USR_NM" ).append("\n"); 
		query.append("		, MST.SCAC_CD" ).append("\n"); 
		query.append("		, MST.CUST_REF_NO CUST_REF_NO" ).append("\n"); 
		query.append("		, NVL((SELECT TO_CHAR(DTL.DOR_RQST_DT,'yyyy-mm-dd')" ).append("\n"); 
		query.append("				 	FROM BKG_XTER_TRO TRO, BKG_XTER_TRO_DTL DTL" ).append("\n"); 
		query.append("					WHERE TRO.XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("					  AND TRO.XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("					  AND TRO.XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("					  AND TRO.XTER_SNDR_ID = DTL.XTER_SNDR_ID" ).append("\n"); 
		query.append("					  AND TRO.XTER_RQST_NO = DTL.XTER_RQST_NO" ).append("\n"); 
		query.append("					  AND TRO.XTER_RQST_SEQ = DTL.XTER_RQST_SEQ" ).append("\n"); 
		query.append("					  AND ROWNUM = 1),TO_CHAR(MST.MTY_PKUP_DT,'yyyy-mm-dd')) MTY_PKUP_DT" ).append("\n"); 
		query.append("		, ( SELECT TO_CHAR(DTL.DOR_RQST_DT,'yyyy-mm-dd')" ).append("\n"); 
		query.append("		 	FROM BKG_XTER_TRO TRO, BKG_XTER_TRO_DTL DTL" ).append("\n"); 
		query.append("			WHERE TRO.XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("			  AND TRO.XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("			  AND TRO.XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("			  AND TRO.XTER_SNDR_ID = DTL.XTER_SNDR_ID" ).append("\n"); 
		query.append("			  AND TRO.XTER_RQST_NO = DTL.XTER_RQST_NO" ).append("\n"); 
		query.append("			  AND TRO.XTER_RQST_SEQ = DTL.XTER_RQST_SEQ" ).append("\n"); 
		query.append("			  AND ROWNUM = 1) TRO_PKUP_DT" ).append("\n"); 
		query.append("        , MST.SPLIT_STS_CD " ).append("\n"); 
		query.append("		, nvl(NON_NEGO_RT_INCL_KNT,0) NON_NEGO_RT_INCL_KNT" ).append("\n"); 
		query.append("        , nvl(NON_NEGO_RT_XCLD_KNT,0) NON_NEGO_RT_XCLD_KNT" ).append("\n"); 
		query.append("		, DECODE(DOC_TP_CD,'B',MST.XTER_RQST_NO) BKG_REF_NO -- BKG_REF_NO" ).append("\n"); 
		query.append("	    , DECODE(DOC_TP_CD,'B',DECODE(MST.XTER_SNDR_ID,'SEANACCS',CUST_REF_NO, SHPR_REF_NO)) BKG_SH_REF_NO -- BKG_SH_REF_NO" ).append("\n"); 
		query.append("	    , DECODE(DOC_TP_CD,'B',FWRD_REF_NO) BKG_FF_REF_NO -- BKG_FF_REF_NO" ).append("\n"); 
		query.append("       	, DECODE(DOC_TP_CD,'S',MST.XTER_RQST_NO) SI_REF_NO -- SI_REF_NO" ).append("\n"); 
		query.append("       	, DECODE(DOC_TP_CD,'S',DECODE(MST.XTER_SNDR_ID,'SEANACCS',CUST_REF_NO, SHPR_REF_NO)) SI_SH_REF_NO -- SI_SH_REF_NO" ).append("\n"); 
		query.append("       	, DECODE(DOC_TP_CD,'S',FWRD_REF_NO) SI_FF_REF_NO -- SI_FF_REF_NO" ).append("\n"); 
		query.append("        , INV_REF_NO -- FINV" ).append("\n"); 
		query.append("        , XPT_MRN_NO AS EXT_MRN_NO-- XMRN" ).append("\n"); 
		query.append("		, MST.CUST_ID" ).append("\n"); 
		query.append("		, NVL(MST.FLEX_HGT_FLG, 'N') FLEX_HGT_FLG" ).append("\n"); 
		query.append("		, MST.SYS_UPLD_FLG" ).append("\n"); 
		query.append("		, MST.SI_AUD_FLG" ).append("\n"); 
		query.append("		, MST.CMPB_RT_FLG" ).append("\n"); 
		query.append("		, MST.HNDL_OFC_CD" ).append("\n"); 
		query.append("		, mst.spc_ctrlr_rmk" ).append("\n"); 
		query.append("  from bkg_xter_rqst_mst mst, bkg_xter_cust sh, bkg_xter_cust ff, bkg_xter_cust ex" ).append("\n"); 
		query.append(" where mst.xter_sndr_id  = sh.xter_sndr_id(+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_no  = sh.xter_rqst_no(+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq = sh.xter_rqst_seq(+)" ).append("\n"); 
		query.append("   and 'S'               = sh.xter_cust_tp_cd(+)" ).append("\n"); 
		query.append("   and mst.xter_sndr_id  = ff.xter_sndr_id(+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_no  = ff.xter_rqst_no(+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq = ff.xter_rqst_seq(+)" ).append("\n"); 
		query.append("   and 'F'               = ff.xter_cust_tp_cd(+)" ).append("\n"); 
		query.append("   and mst.xter_sndr_id  = ex.xter_sndr_id(+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_no  = ex.xter_rqst_no(+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq = ex.xter_rqst_seq(+)" ).append("\n"); 
		query.append("   and 'E'               = ex.xter_cust_tp_cd(+)" ).append("\n"); 
		query.append("   and mst.xter_sndr_id      = @[sender_id]" ).append("\n"); 
		query.append("   and mst.xter_rqst_no      = @[rqst_no]" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq     = @[rqst_seq]" ).append("\n"); 

	}
}