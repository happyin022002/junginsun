/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRqstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.03 
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

public class EBookingReceiptDBDAOsearchXterRqstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterRqstList
	  * 2010.11.04 김영철 [CHM-201005975-01] SEANACCS ACL 변경 요청 (E-BKG&SI & DPCS 관련) - EDI로 들어온 Data가 처리되었는지 Validation 추가 요청
	  * 2011.05.20 김진승 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청 / e-Booking & SI Process(ESM_BKG_0228)에 조회 항목(Split Status) 추가 
	  * 2011.06.02 김진승 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청 / e-Booking & SI Process(ESM_BKG_0228)에 조회 조건 split bkg 추가
	  * 2013.05.13 임재관 [CHM-201324602] e-Booking & SI Process 상 Special 정보 column 추가
	  * 2013.06.20 최문환 [CHM-201325258] e-Booking & SI Process 화면 상 special 정보 drag & drop 기능 보완
	  * 2014.10.28 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차)
	  * 2017.07.25 이인영 No Rate Status 조건에 추가
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterRqstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_fnt_ofc_yn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("split_bkg_yn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("origin",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sys_upld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_rt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("si_aud_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterRqstListRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_HASH(MST POR POL POD DEL) */ " ).append("\n"); 
		query.append("        MST.DOC_TP_CD DOC_TP_CD" ).append("\n"); 
		query.append("		, MST.BAG_DG" ).append("\n"); 
		query.append("        , TO_CHAR(MST.RQST_DT, 'YYYY-MM-DD HH24:MI') RQST_DT" ).append("\n"); 
		query.append("        , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',MST.CRE_DT,'GMT'), 'YYYY-MM-DD HH24:MI') RQST_GMT_DT" ).append("\n"); 
		query.append("        , MST.XTER_RQST_NO XTER_RQST_NO" ).append("\n"); 
		query.append("        , MST.XTER_RQST_SEQ XTER_RQST_SEQ" ).append("\n"); 
		query.append("	,CASE WHEN EXISTS" ).append("\n"); 
		query.append("		(SELECT 1 " ).append("\n"); 
		query.append("       		   FROM BKG_XTER_RQST_MST XTER" ).append("\n"); 
		query.append("	          WHERE XTER.XTER_SNDR_ID = MST.XTER_SNDR_ID " ).append("\n"); 
		query.append("                    AND XTER.XTER_RQST_NO = MST.XTER_RQST_NO " ).append("\n"); 
		query.append("                    AND XTER.XTER_BKG_RQST_STS_CD = 'T') THEN MST.DISP_XTER_RQST_SEQ" ).append("\n"); 
		query.append("              ELSE MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("         END AS DISP_XTER_RQST_SEQ" ).append("\n"); 
		query.append("        , MST.XTER_BKG_RQST_STS_CD XTER_BKG_RQST_STS_CD" ).append("\n"); 
		query.append("        , MST.XTER_RQST_VIA_CD XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("        , MST.BKG_NO BKG_NO" ).append("\n"); 
		query.append("        , MST.BKG_NO BKG_NO_CHECK" ).append("\n"); 
		query.append("        , MST.BKG_UPLD_STS_CD BKG_UPLD_STS_CD" ).append("\n"); 
		query.append("        , MST.SH_NM SH_NM" ).append("\n"); 
		query.append("        , MST.CN_NM CN_NM" ).append("\n"); 
		query.append("        , MST.FF_NM FF_NM" ).append("\n"); 
		query.append("        , MST.HNDL_OFC_CD HNDL_OFC_CD" ).append("\n"); 
		query.append("        , NVL(POR.CNT_CD,   POL.CNT_CD)   ORIGIN" ).append("\n"); 
		query.append("        , MST.DEL_CN DELIVERY" ).append("\n"); 
		query.append("        , POR_CD XTER_POR_CD" ).append("\n"); 
		query.append("        , NVL(POR.LOC_NM, XTER_POR_NM) XTER_POR_NM" ).append("\n"); 
		query.append("        , POL_CD XTER_POL_CD" ).append("\n"); 
		query.append("        , NVL(POL.LOC_NM, XTER_POL_NM) XTER_POL_NM" ).append("\n"); 
		query.append("        , POD_CD XTER_POD_CD" ).append("\n"); 
		query.append("        , NVL(POD.LOC_NM, XTER_POD_NM) XTER_POD_NM" ).append("\n"); 
		query.append("        , DEL_CD XTER_DEL_CD" ).append("\n"); 
		query.append("        , NVL(DEL.loc_nm, XTER_DEL_NM) XTER_DEL_NM" ).append("\n"); 
		query.append("        , TO_CHAR(MST.RQST_DEP_DT, 'YYYY-MM-DD') RQST_DEP_DT" ).append("\n"); 
		query.append("        , MST.VVD" ).append("\n"); 
		query.append("        , MST.VSL_ENG_NM VSL_ENG_NM" ).append("\n"); 
		query.append("        , lpad(MST.SKD_VOY_NO,4,'0')||MST.SKD_DIR_CD SKD_VOY_NO" ).append("\n"); 
		query.append("        , MST.PO_NO PO_NO" ).append("\n"); 
		query.append("        , MST.CNTC_EML CNTC_EML" ).append("\n"); 
		query.append("        , MST.OFC_CD OFC_CD" ).append("\n"); 
		query.append("        , MST.UPLD_USR_ID UPLD_USR_ID" ).append("\n"); 
		query.append("        , MST.UPLD_USR_NM UPLD_USR_NM" ).append("\n"); 
		query.append("        , TO_CHAR(MST.UPLD_DT, 'YYYY-MM-DD HH24:MI') UPLD_DT" ).append("\n"); 
		query.append("        , MST.XTER_SNDR_ID XTER_SNDR_ID" ).append("\n"); 
		query.append("		, MST.VSL_CD VSL_CD" ).append("\n"); 
		query.append("		, MST.BKG_STS_CD BKG_STS_CD" ).append("\n"); 
		query.append("		, MST.SNACCS_SPLIT_NO SNACCS_SPLIT_NO" ).append("\n"); 
		query.append("	    , RQST_ACPT_DESC" ).append("\n"); 
		query.append("		, XTER_RQST_ACPT_USR_ID" ).append("\n"); 
		query.append("		, XTER_RQST_ACPT_USR_NM" ).append("\n"); 
		query.append("        , ROW_NUMBER() OVER (ORDER BY MST.RQST_DT) ROW_NUM" ).append("\n"); 
		query.append("        , COUNT(1) OVER () ROW_COUNT" ).append("\n"); 
		query.append("        , CASE WHEN MST.BKG_UPLD_STS_CD IN ('R','P') THEN (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("   			                                               FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("   			                                               WHERE INTG_CD_ID = 'CD02193'" ).append("\n"); 
		query.append("    		                                               AND INTG_CD_VAL_CTNT = MST.XTER_RJCT_RSN_CD)" ).append("\n"); 
		query.append("          ELSE '' END XTER_RJCT_RSN_NM" ).append("\n"); 
		query.append("        , MST.RJCT_RSN_RMK" ).append("\n"); 
		query.append("		, DECODE(MST.BKG_UPLD_STS_CD, 'P', (" ).append("\n"); 
		query.append("    		SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("   			  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("   			 WHERE INTG_CD_ID = 'CD02193'" ).append("\n"); 
		query.append("    		   AND INTG_CD_VAL_CTNT = MST.XTER_RJCT_RSN_CD ), '') XTER_PND_RSN_NM" ).append("\n"); 
		query.append("		, MST.CUST_REF_NO CUST_REF_NO" ).append("\n"); 
		query.append("		, DECODE(MST.XTER_SNDR_ID,'SEANACCS',MST.EDI_RCV_RVIS_NO,MST.XTER_RQST_SEQ) XTER_RQST_RVIS_SEQ" ).append("\n"); 
		query.append("        , SLAN_CD" ).append("\n"); 
		query.append("        , OB_SREP_CD" ).append("\n"); 
		query.append("        , DECODE(BL_FNT_OFC_FLG,'Y','Y',BL_DOC_INP_FLG) BL_DOC_INP_FLG" ).append("\n"); 
		query.append("        , BL_FNT_OFC_FLG" ).append("\n"); 
		query.append("		, MST.NON_RT_STS_CD" ).append("\n"); 
		query.append("        , MST.SPLIT_STS_CD " ).append("\n"); 
		query.append("        , MST.XPT_REF_NO" ).append("\n"); 
		query.append("        , MST.FAX_LOG_REF_NO" ).append("\n"); 
		query.append("        , SR_KND_CD" ).append("\n"); 
		query.append("		, TMPLT_PAR_RTO" ).append("\n"); 
		query.append("    	, MST.DCGO_FLG ||' / '|| MST.RC_FLG ||' / '|| MST.AWK_CGO_FLG ||' / '|| MST.BB_CGO_FLG SPCL_CGO_FLG" ).append("\n"); 
		query.append("        , NVL(XTER_TEU,BKG_TEU) XTER_TEU" ).append("\n"); 
		query.append("        ,XTER_RQST_STS_OFC_CD" ).append("\n"); 
		query.append("        ,XTER_RQST_STS_USR_ID" ).append("\n"); 
		query.append("        ,XTER_RQST_STS_USR_NM" ).append("\n"); 
		query.append("        ,XTER_RQST_STS_UPD_DT" ).append("\n"); 
		query.append("        ,XTER_RQST_STS_CD" ).append("\n"); 
		query.append("    	, MST.PCTL_EXPT_FLG" ).append("\n"); 
		query.append("    	, MST.BKG_BLCK_FLG" ).append("\n"); 
		query.append("    	, MST.OTHER_FLAG" ).append("\n"); 
		query.append("		, MST.BL_NO_CTNT" ).append("\n"); 
		query.append("		, MST.SI_AUD_FLG" ).append("\n"); 
		query.append("		, MST.SYS_UPLD_FLG" ).append("\n"); 
		query.append("	    , decode((" ).append("\n"); 
		query.append("                    select count(cntr_no) from bkg_xter_cntr xcntr" ).append("\n"); 
		query.append("                    where 1=1" ).append("\n"); 
		query.append("                    AND MST.XTER_SNDR_ID = XCNTR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("	                AND MST.XTER_RQST_NO = XCNTR.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("	                AND MST.XTER_RQST_SEQ = XCNTR.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                    and ((xcntr.vgm_wgt is not null and to_number(xcntr.vgm_wgt) > 0) or xcntr.vgm_wgt_ut_cd is not null or xcntr.VGM_VRFY_SIG_CTNT  is not null)" ).append("\n"); 
		query.append("                    ), '0', 'N', (" ).append("\n"); 
		query.append("                    (select count(cntr_no) from bkg_xter_cntr xcntr" ).append("\n"); 
		query.append("                    where 1=1" ).append("\n"); 
		query.append("                    AND MST.XTER_SNDR_ID = XCNTR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("	                AND MST.XTER_RQST_NO = XCNTR.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("	                AND MST.XTER_RQST_SEQ = XCNTR.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                    and ((xcntr.vgm_wgt is not null and to_number(xcntr.vgm_wgt) > 0) or xcntr.vgm_wgt_ut_cd is not null or xcntr.VGM_VRFY_SIG_CTNT  is not null))" ).append("\n"); 
		query.append("                    -" ).append("\n"); 
		query.append("                    (select count(cntr_no) from bkg_xter_cntr xcntr" ).append("\n"); 
		query.append("                    where 1=1" ).append("\n"); 
		query.append("                    AND MST.XTER_SNDR_ID = XCNTR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("	                AND MST.XTER_RQST_NO = XCNTR.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("	                AND MST.XTER_RQST_SEQ = XCNTR.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                    and (xcntr.vgm_wgt is null or to_number(xcntr.vgm_wgt) <= 0 or xcntr.vgm_wgt_ut_cd is null or xcntr.VGM_VRFY_SIG_CTNT  is null))" ).append("\n"); 
		query.append("                    ), 'Y', 'I') vgm_flg" ).append("\n"); 
		query.append("					, max(DECODE(EDI_RECEIVE_ID, 'INTTRA', 'Y', 'INTTRANG2', 'Y', 'N')) itr_flg" ).append("\n"); 
		query.append("                , max(DECODE(EDI_RECEIVE_ID, 'GTNEXUS', 'Y', 'N')) gtn_flg" ).append("\n"); 
		query.append("                , max(DECODE(EDI_RECEIVE_ID, 'CARGOSMART', 'Y', 'N')) csm_flg" ).append("\n"); 
		query.append("		, max(nvl(ULTI_NEW_ASIA_CUST_FLG, 'N')) as ULTI_NEW_ASIA_CUST_FLG, max(nvl(ULTI_TRNS_CUST_FLG, 'N')) as ULTI_TRNS_CUST_FLG" ).append("\n"); 
		query.append("      	, MST.CMDT_CD" ).append("\n"); 
		query.append("      	, MST.CMDT_NM" ).append("\n"); 
		query.append("		, MST.XTER_RMK" ).append("\n"); 
		query.append("		, MST.CTRT_NO" ).append("\n"); 
		query.append("		, MST.CTRT_NM" ).append("\n"); 
		query.append("		, MST.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (SELECT ROW_NUMBER() OVER(PARTITION BY XBK.XTER_SNDR_ID, XBK.XTER_RQST_NO ORDER BY XBK.XTER_SNDR_ID, XBK.XTER_RQST_NO, XBK.XTER_RQST_SEQ) DISP_XTER_RQST_SEQ" ).append("\n"); 
		query.append("			, XBK.DOC_TP_CD" ).append("\n"); 
		query.append("			, XBK.BAG_DG_FLG AS BAG_DG" ).append("\n"); 
		query.append("            , XBK.RQST_DT" ).append("\n"); 
		query.append("            , XBK.CRE_DT" ).append("\n"); 
		query.append("            , XBK.XTER_RQST_NO" ).append("\n"); 
		query.append("            , XBK.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            , XBK.XTER_BKG_RQST_STS_CD" ).append("\n"); 
		query.append("            , XBK.XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("            , XBK.BKG_NO" ).append("\n"); 
		query.append("            , XBK.BKG_UPLD_STS_CD" ).append("\n"); 
		query.append("            , NVL(SH.CUST_CNT_CD, XSH.CNT_CD)   SH_CNT" ).append("\n"); 
		query.append("            , NVL(SH.CUST_SEQ,    XSH.CUST_SEQ) SH_SEQ" ).append("\n"); 
		query.append("            , NVL(CN.CUST_CNT_CD, XCN.CNT_CD)   CN_CNT" ).append("\n"); 
		query.append("            , NVL(CN.CUST_SEQ,    XCN.CUST_SEQ) CN_SEQ" ).append("\n"); 
		query.append("            , NVL(FF.CUST_CNT_CD, XFF.CNT_CD)   FF_CNT" ).append("\n"); 
		query.append("            , NVL(FF.CUST_SEQ,    XFF.CUST_SEQ) FF_SEQ" ).append("\n"); 
		query.append("            , REPLACE(REPLACE(NVL(NVL(MSH.CUST_LGL_ENG_NM, SH.CUST_NM), XSH.CUST_NM), CHR(13)||CHR(10),' '),CHR(9),' ') SH_NM" ).append("\n"); 
		query.append("            , REPLACE(REPLACE(NVL(NVL(MCN.CUST_LGL_ENG_NM, CN.CUST_NM), XCN.CUST_NM), CHR(13)||CHR(10),' '),CHR(9),' ') CN_NM" ).append("\n"); 
		query.append("            , REPLACE(REPLACE(NVL(NVL(MFF.CUST_LGL_ENG_NM, FF.CUST_NM), XFF.CUST_NM), CHR(13)||CHR(10),' '),CHR(9),' ') FF_NM" ).append("\n"); 
		query.append("            , XBK.HNDL_OFC_CD" ).append("\n"); 
		query.append("            , NVL(BK.POR_CD, XBK.POR_CD) POR_CD" ).append("\n"); 
		query.append("            , NVL(BK.POL_CD, XBK.POL_CD) POL_CD" ).append("\n"); 
		query.append("            , NVL(BK.POD_CD, XBK.POD_CD) POD_CD" ).append("\n"); 
		query.append("            , NVL(BK.DEL_CD, XBK.DEL_CD) DEL_CD" ).append("\n"); 
		query.append("            , XBK.POR_NM XTER_POR_NM" ).append("\n"); 
		query.append("            , XBK.POL_NM XTER_POL_NM" ).append("\n"); 
		query.append("            , XBK.POD_NM XTER_POD_NM" ).append("\n"); 
		query.append("            , XBK.DEL_NM XTER_DEL_NM" ).append("\n"); 
		query.append("            , XBK.RQST_DEP_DT" ).append("\n"); 
		query.append("            , bk.vsl_cd||bk.skd_voy_no||bk.skd_dir_cd VVD" ).append("\n"); 
		query.append("            , NVL((SELECT VSL_ENG_NM FROM MDM_VSL_CNTR VSL WHERE XBK.VSL_CD = VSL.VSL_CD), XBK.VSL_NM) VSL_ENG_NM" ).append("\n"); 
		query.append("            , XBK.SKD_VOY_NO" ).append("\n"); 
		query.append("            , XBK.SKD_DIR_CD" ).append("\n"); 
		query.append("            , XBK.PO_NO" ).append("\n"); 
		query.append("            , XBK.CNTC_EML" ).append("\n"); 
		query.append("            , (SELECT OFC_CD FROM COM_USER USR WHERE XBK.UPLD_USR_ID = USR.USR_ID) OFC_CD" ).append("\n"); 
		query.append("            , XBK.UPLD_USR_ID" ).append("\n"); 
		query.append("            , (SELECT USR_NM FROM COM_USER USR WHERE XBK.UPLD_USR_ID = USR.USR_ID) UPLD_USR_NM" ).append("\n"); 
		query.append("            , XBK.UPLD_DT" ).append("\n"); 
		query.append("            , XBK.XTER_SNDR_ID" ).append("\n"); 
		query.append("            , XBK.RQST_DELT_FLG" ).append("\n"); 
		query.append("            , NVL(BK.OB_SREP_CD, XBK.SREP_CD) SREP_CD" ).append("\n"); 
		query.append("			, BK.CHN_AGN_CD" ).append("\n"); 
		query.append("			, BK.BKG_STS_CD" ).append("\n"); 
		query.append("			, XBK.VSL_CD VSL_CD" ).append("\n"); 
		query.append("			, XBK.SNACCS_SPLIT_NO SNACCS_SPLIT_NO" ).append("\n"); 
		query.append("			, (SELECT CONTI_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("			    WHERE LOC_CD LIKE SUBSTR(NVL(NVL(BK.DEL_CD, XBK.DEL_CD), NVL(BK.POD_CD, XBK.POD_CD)), 1, 2)||'%'" ).append("\n"); 
		query.append("			      AND ROWNUM = 1 ) DEL_CN" ).append("\n"); 
		query.append("			, DECODE(NVL(XBK.XTER_RQST_ACPT_CD, 'X'), 'R', 'Rejected', 'C', 'Confirmed', '') RQST_ACPT_DESC" ).append("\n"); 
		query.append("			, XBK.XTER_RQST_ACPT_USR_ID" ).append("\n"); 
		query.append("			, (SELECT USR_NM FROM COM_USER WHERE USR_ID = UPPER(XBK.XTER_RQST_ACPT_USR_ID)) XTER_RQST_ACPT_USR_NM" ).append("\n"); 
		query.append("			, XBK.XTER_RJCT_RSN_CD XTER_RJCT_RSN_CD" ).append("\n"); 
		query.append("            , XBK.RJCT_RSN_RMK" ).append("\n"); 
		query.append("			, XBK.CUST_REF_NO CUST_REF_NO" ).append("\n"); 
		query.append("			, BK.SLAN_CD" ).append("\n"); 
		query.append("			, BK.OB_SREP_CD" ).append("\n"); 
		query.append("			, XBK.EDI_RCV_RVIS_NO" ).append("\n"); 
		query.append("	        , ( CASE WHEN XBK.SPLIT_STS_CD = 'S' AND XBK.XTER_SNDR_ID = 'WEB'" ).append("\n"); 
		query.append("                             THEN 'S'||XBK.BL_SPLIT_NO" ).append("\n"); 
		query.append("                     WHEN XBK.SPLIT_STS_CD IS NULL THEN ''" ).append("\n"); 
		query.append("                     ELSE DECODE(XBK.SPLIT_STS_CD,'N',NULL,XBK.SPLIT_STS_CD)" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("               ) AS SPLIT_STS_CD" ).append("\n"); 
		query.append("			, XAE.AES_INLND_TRNS_NO||XCA.CAED_CTNT1||XCA.CAED_CTNT2||XCA.CAED_CTNT3||XAE.ENTR_CLSS_TP_CD XPT_REF_NO" ).append("\n"); 
		query.append("			, XBK.FAX_LOG_REF_NO" ).append("\n"); 
		query.append("            ,   EML.SR_KND_CD" ).append("\n"); 
		query.append("			,	EML.TMPLT_PAR_RTO" ).append("\n"); 
		query.append("            ,  NVL((SELECT BL_DOC_INP_FLG" ).append("\n"); 
		query.append("                     FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                    WHERE XTER_SNDR_ID = XBK.XTER_SNDR_ID" ).append("\n"); 
		query.append("                      AND XTER_RQST_NO = XBK.XTER_RQST_NO" ).append("\n"); 
		query.append("                      AND XTER_RQST_SEQ = XBK.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                      AND BKG_NO = XBK.BKG_NO" ).append("\n"); 
		query.append("                      AND ROWNUM = 1)," ).append("\n"); 
		query.append("                   'N') BL_DOC_INP_FLG" ).append("\n"); 
		query.append("            ,   (SELECT DECODE(COUNT(*), 0, 'N', 'Y')" ).append("\n"); 
		query.append("                  FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                 WHERE BKG_NO = XBK.BKG_NO" ).append("\n"); 
		query.append("                   AND BL_FNT_OFC_FLG = 'Y') BL_FNT_OFC_FLG	" ).append("\n"); 
		query.append("			, BK.NON_RT_STS_CD" ).append("\n"); 
		query.append("      		, NVL(BK.DCGO_FLG, XBK.DCGO_FLG) DCGO_FLG" ).append("\n"); 
		query.append("      		, NVL(BK.RC_FLG, XBK.RC_FLG) RC_FLG" ).append("\n"); 
		query.append("      		, NVL(BK.AWK_CGO_FLG, XBK.AWK_CGO_FLG) AWK_CGO_FLG" ).append("\n"); 
		query.append("      		, NVL(BK.BB_CGO_FLG, XBK.BB_CGO_FLG) BB_CGO_FLG	" ).append("\n"); 
		query.append("            , (SELECT SUM(DECODE(SUBSTR(BXQ.CNTR_TPSZ_CD,2,1),'2',BXQ.CNTR_QTY,BXQ.CNTR_QTY*2))" ).append("\n"); 
		query.append("               FROM BKG_XTER_QTY BXQ " ).append("\n"); 
		query.append("              WHERE BXQ.XTER_SNDR_ID = XBK.XTER_SNDR_ID" ).append("\n"); 
		query.append("                AND BXQ.XTER_RQST_NO = XBK.XTER_RQST_NO" ).append("\n"); 
		query.append("                AND BXQ.XTER_RQST_SEQ = XBK.XTER_RQST_SEQ) XTER_TEU" ).append("\n"); 
		query.append("            , (SELECT SUM(DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2))" ).append("\n"); 
		query.append("               FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("              WHERE BQ.BKG_NO = BK.BKG_NO) BKG_TEU" ).append("\n"); 
		query.append("            ,(SELECT OFC_CD FROM COM_USER USR WHERE XBK.XTER_RQST_STS_USR_ID = USR.USR_ID) XTER_RQST_STS_OFC_CD" ).append("\n"); 
		query.append("            ,XTER_RQST_STS_USR_ID XTER_RQST_STS_USR_ID" ).append("\n"); 
		query.append("            ,CASE WHEN XTER_RQST_STS_CD = 'H' THEN (SELECT USR_NM FROM COM_USER WHERE USR_ID = XTER_RQST_STS_USR_ID AND ROWNUM = 1)" ).append("\n"); 
		query.append("             ELSE XTER_RQST_STS_USR_ID END XTER_RQST_STS_USR_NM" ).append("\n"); 
		query.append("            ,TO_CHAR(XTER_RQST_STS_UPD_DT, 'YYYY-MM-DD HH24:MI') XTER_RQST_STS_UPD_DT" ).append("\n"); 
		query.append("            ,(SELECT CICD.INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL CICD WHERE CICD.INTG_CD_ID = 'CD01630' AND CICD.INTG_CD_VAL_CTNT = XTER_RQST_STS_CD AND ROWNUM = 1) XTER_RQST_STS_CD" ).append("\n"); 
		query.append("            , XBK.PCTL_EXPT_FLG" ).append("\n"); 
		query.append("            , XBK.BKG_BLCK_FLG" ).append("\n"); 
		query.append("            , CASE WHEN XBK.XTER_SNDR_ID = 'WEB' AND XBK.DOC_TP_CD = 'B' AND XBK.BKG_UPLD_STS_CD = 'F' THEN 'N'" ).append("\n"); 
		query.append("              WHEN XBK.XTER_SNDR_ID = 'WEB' AND XBK.DOC_TP_CD = 'B' AND XBK.BKG_UPLD_STS_CD != 'F' THEN " ).append("\n"); 
		query.append("                CASE WHEN XBK.PCTL_EXPT_FLG = 'N' AND XBK.BKG_BLCK_FLG = 'N' THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("              ELSE '' END AS OTHER_FLAG" ).append("\n"); 
		query.append("			, XBK.BL_NO_CTNT" ).append("\n"); 
		query.append("			, XBK.SI_AUD_FLG" ).append("\n"); 
		query.append("			, DECODE(XBK.BKG_UPLD_STS_CD,'F',XBK.SYS_UPLD_FLG,'') SYS_UPLD_FLG" ).append("\n"); 
		query.append("      		, XBK.CMDT_CD" ).append("\n"); 
		query.append("      		, XBK.CMDT_DESC AS CMDT_NM" ).append("\n"); 
		query.append("			, XBK.XTER_BKG_RMK1 || XBK.XTER_BKG_RMK2 AS XTER_RMK" ).append("\n"); 
		query.append("			, XBK.CTRT_NO" ).append("\n"); 
		query.append("			, XBK.CTRT_NM" ).append("\n"); 
		query.append("			, (SELECT WM_CONCAT(QTY.CNTR_TPSZ_CD || ':' || QTY.CNTR_QTY) AS CNTR_TPSZ_CD FROM BKG_XTER_QTY QTY WHERE QTY.XTER_RQST_NO = XBK.XTER_RQST_NO AND QTY.XTER_RQST_SEQ = XBK.XTER_RQST_SEQ) AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK, BKG_CUSTOMER SH, BKG_CUSTOMER CN, BKG_CUSTOMER FF" ).append("\n"); 
		query.append("            , BKG_XTER_RQST_MST XBK, BKG_XTER_CUST XSH, BKG_XTER_CUST XCN, BKG_XTER_CUST XFF" ).append("\n"); 
		query.append("            , MDM_CUSTOMER MSH, MDM_CUSTOMER MCN, MDM_CUSTOMER MFF" ).append("\n"); 
		query.append("            , BKG_XTER_AES XAE, BKG_XTER_CAED XCA" ).append("\n"); 
		query.append("            , BKG_SR_FAX EML" ).append("\n"); 
		query.append("     WHERE XBK.BKG_NO       = BK.BKG_NO(+)" ).append("\n"); 
		query.append("       AND XBK.BKG_NO       = SH.BKG_NO(+)" ).append("\n"); 
		query.append("       AND 'S'              = SH.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("       AND XBK.BKG_NO       = CN.BKG_NO(+)" ).append("\n"); 
		query.append("       AND 'C'              = CN.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("       AND XBK.BKG_NO       = FF.BKG_NO(+)" ).append("\n"); 
		query.append("       AND 'F'              = FF.BKG_CUST_TP_CD(+)   " ).append("\n"); 
		query.append("       AND XBK.XTER_SNDR_ID = XSH.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_NO = XSH.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_SEQ= XSH.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("       AND 'S'              = XSH.XTER_CUST_TP_CD(+)   " ).append("\n"); 
		query.append("       AND XBK.XTER_SNDR_ID = XCN.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_NO = XCN.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_SEQ= XCN.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("       AND 'C'              = XCN.XTER_CUST_TP_CD(+)   " ).append("\n"); 
		query.append("       AND XBK.XTER_SNDR_ID = XFF.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_NO = XFF.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_SEQ= XFF.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("       AND 'F'              = XFF.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("       AND NVL(XBK.XTER_BKG_RQST_STS_CD,' ') <> 'T'" ).append("\n"); 
		query.append("       AND NVL(XBK.XTER_BL_TP_CD, ' ') <> 'H'" ).append("\n"); 
		query.append("	   AND DECODE(XBK.XTER_SNDR_ID, 'SEANACCS', XBK.SNACCS_MSG_TP_CD, ' ') NOT IN ( 'SAT050', 'SAT054' ,'SAT141','SAT142','SAT146','SAT147' )" ).append("\n"); 
		query.append("	   AND XSH.CNT_CD       = MSH.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("	   AND XSH.CUST_SEQ     = MSH.CUST_SEQ(+)" ).append("\n"); 
		query.append("	   AND XCN.CNT_CD       = MCN.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("	   AND XCN.CUST_SEQ     = MCN.CUST_SEQ(+)" ).append("\n"); 
		query.append("	   AND XFF.CNT_CD       = MFF.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("	   AND XFF.CUST_SEQ     = MFF.CUST_SEQ(+)" ).append("\n"); 
		query.append("	   AND XSH.CNT_CD       = MSH.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("	   AND XSH.CUST_SEQ     = MSH.CUST_SEQ(+)" ).append("\n"); 
		query.append("	   AND XCN.CNT_CD       = MCN.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("	   AND XCN.CUST_SEQ     = MCN.CUST_SEQ(+)" ).append("\n"); 
		query.append("	   AND XFF.CNT_CD       = MFF.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("	   AND XFF.CUST_SEQ     = MFF.CUST_SEQ(+)" ).append("\n"); 
		query.append("	   AND XBK.XTER_SNDR_ID = XAE.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("	   AND XBK.XTER_RQST_NO = XAE.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("	   AND XBK.XTER_RQST_SEQ= XAE.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("	   AND XBK.XTER_SNDR_ID = XCA.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("	   AND XBK.XTER_RQST_NO = XCA.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("	   AND XBK.XTER_RQST_SEQ= XCA.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_NO = EML.SR_NO(+)" ).append("\n"); 
		query.append("	   AND XBK.FAX_LOG_REF_NO = EML.FAX_LOG_REF_NO(+) " ).append("\n"); 
		query.append("	   AND DECODE(XBK.XTER_RQST_VIA_CD,'EML',NVL(BKG_NO_MTCH_STS_CD,'F'),'N') <> 'F'" ).append("\n"); 
		query.append("#if (${vgm_flg} != '')" ).append("\n"); 
		query.append("	   and decode((" ).append("\n"); 
		query.append("                    select count(cntr_no) from bkg_xter_cntr xcntr" ).append("\n"); 
		query.append("                    where 1=1" ).append("\n"); 
		query.append("                    AND XBK.XTER_SNDR_ID = XCNTR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("	                AND XBK.XTER_RQST_NO = XCNTR.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("	                AND XBK.XTER_RQST_SEQ = XCNTR.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                    and ((xcntr.vgm_wgt is not null and to_number(xcntr.vgm_wgt) > 0) or xcntr.vgm_wgt_ut_cd is not null or xcntr.VGM_VRFY_SIG_CTNT  is not null)" ).append("\n"); 
		query.append("                    ), '0', 'N', (" ).append("\n"); 
		query.append("                    (select count(cntr_no) from bkg_xter_cntr xcntr" ).append("\n"); 
		query.append("                    where 1=1" ).append("\n"); 
		query.append("                    AND XBK.XTER_SNDR_ID = XCNTR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("	                AND XBK.XTER_RQST_NO = XCNTR.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("	                AND XBK.XTER_RQST_SEQ = XCNTR.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                    and ((xcntr.vgm_wgt is not null and to_number(xcntr.vgm_wgt) > 0) or xcntr.vgm_wgt_ut_cd is not null or xcntr.VGM_VRFY_SIG_CTNT  is not null))" ).append("\n"); 
		query.append("                    -" ).append("\n"); 
		query.append("                    (select count(cntr_no) from bkg_xter_cntr xcntr" ).append("\n"); 
		query.append("                    where 1=1" ).append("\n"); 
		query.append("                    AND XBK.XTER_SNDR_ID = XCNTR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("	                AND XBK.XTER_RQST_NO = XCNTR.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("	                AND XBK.XTER_RQST_SEQ = XCNTR.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                    and (xcntr.vgm_wgt is null or to_number(xcntr.vgm_wgt) <= 0 or xcntr.vgm_wgt_ut_cd is null or xcntr.VGM_VRFY_SIG_CTNT  is null))" ).append("\n"); 
		query.append("                    ), 'Y', 'I') = @[vgm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--       -------조건절 시작-------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rqst_from_dt} != '') " ).append("\n"); 
		query.append("       AND XBK.RQST_DT > TO_DATE(SUBSTR(REPLACE(@[rqst_from_dt],'-',''), 1, 8), 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rqst_to_dt} != '') " ).append("\n"); 
		query.append("       AND XBK.RQST_DT < TO_DATE(SUBSTR(REPLACE(@[rqst_to_dt],'-',''), 1, 8), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${xter_bkg_rqst_sts_cd} != 'All' && ${xter_bkg_rqst_sts_cd} != '') " ).append("\n"); 
		query.append("       AND XBK.XTER_BKG_RQST_STS_CD IN ( ${xter_bkg_rqst_sts_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_upld_sts_cd} != 'All' && ${bkg_upld_sts_cd} != '') " ).append("\n"); 
		query.append("       AND XBK.BKG_UPLD_STS_CD IN ( ${bkg_upld_sts_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sys_upld_flg} != '') " ).append("\n"); 
		query.append("       AND NVL(XBK.SYS_UPLD_FLG,'N') = @[sys_upld_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${si_aud_flg} != '') " ).append("\n"); 
		query.append("	   AND NVL(XBK.SI_AUD_FLG,'N') = @[si_aud_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${non_rt_sts_cd} != 'All' && ${non_rt_sts_cd} != '')" ).append("\n"); 
		query.append("	   AND BK.NON_RT_STS_CD = @[non_rt_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${xter_rqst_no} != '') " ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${xter_rqst_seq} != '') " ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_SEQ= @[xter_rqst_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("       AND XBK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${po_no} != '') " ).append("\n"); 
		query.append("       AND XBK.PO_NO = @[po_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${xter_rqst_via_cd} != 'All' && ${xter_rqst_via_cd} != '') " ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_VIA_CD IN ( ${xter_rqst_via_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${doc_tp_cd} != 'All' && ${doc_tp_cd} != '')" ).append("\n"); 
		query.append("       AND XBK.DOC_TP_CD IN ( ${doc_tp_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${xter_sndr_id} != '') " ).append("\n"); 
		query.append("       AND XBK.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("       AND XBK.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("       AND XBK.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("       AND XBK.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inttra_rtv} == 'Y')" ).append("\n"); 
		query.append("       AND TRIM(XBK.XTER_SNDR_ID) IN ('INTTRA','INTTRANG2')" ).append("\n"); 
		query.append("       AND NVL(XBK.BKG_UPLD_STS_CD,'N') <> 'F'" ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_VIA_CD <> 'WEB'" ).append("\n"); 
		query.append("       AND NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                       FROM BKG_EDI_GRP BEG" ).append("\n"); 
		query.append("                           ,BKG_EDI_GRP_CUST BEGC" ).append("\n"); 
		query.append("                       WHERE BEG.CUST_TRD_PRNR_ID IN ('INTTRA','INTTRANG2')" ).append("\n"); 
		query.append("                       AND BEG.ESVC_GRP_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND BEG.ESVC_GRP_CD = BEGC.ESVC_GRP_CD" ).append("\n"); 
		query.append("                       AND (BEGC.CNT_CD, BEGC.CUST_SEQ) IN ((XSH.CNT_CD, XSH.CUST_SEQ),(XFF.CNT_CD, XFF.CUST_SEQ),(XCN.CNT_CD, XCN.CUST_SEQ))" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  #if (${hndl_ofc_cd} != '') " ).append("\n"); 
		query.append("    AND NVL(XBK.HNDL_OFC_CD, @[hndl_ofc_cd]) = @[hndl_ofc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("    AND CASE WHEN XBK.XTER_SNDR_ID IN ('INTTRA','INTTRANG2') AND XBK.BKG_UPLD_STS_CD <> 'F' AND XBK.XTER_RQST_VIA_CD <> 'WEB' THEN " ).append("\n"); 
		query.append("                                                                  (SELECT DISTINCT XBK.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                                   FROM BKG_EDI_GRP BEG" ).append("\n"); 
		query.append("                                                                       ,BKG_EDI_GRP_CUST BEGC" ).append("\n"); 
		query.append("                                                                   WHERE BEG.CUST_TRD_PRNR_ID IN ('INTTRA','INTTRANG2')" ).append("\n"); 
		query.append("                                                                   AND BEG.ESVC_GRP_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                                   AND BEG.ESVC_GRP_CD = BEGC.ESVC_GRP_CD" ).append("\n"); 
		query.append("                                                                   AND (BEGC.CNT_CD, BEGC.CUST_SEQ) IN ((XSH.CNT_CD, XSH.CUST_SEQ),(XFF.CNT_CD, XFF.CUST_SEQ),(XCN.CNT_CD, XCN.CUST_SEQ))" ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("             ELSE XBK.XTER_SNDR_ID" ).append("\n"); 
		query.append("        END = XBK.XTER_SNDR_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '') " ).append("\n"); 
		query.append("       AND BK.SLAN_CD = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND ( ( ( @[split_bkg_yn] IS NULL OR @[split_bkg_yn] != 'Y' ) AND 1=1 ) OR ( @[split_bkg_yn] = 'Y' AND XBK.SPLIT_STS_CD IS NOT NULL ) )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ) MST" ).append("\n"); 
		query.append("       , MDM_LOCATION POR, MDM_LOCATION POL, MDM_LOCATION POD, MDM_LOCATION DEL, (select BK.XTER_SNDR_ID, BK.XTER_RQST_NO, BK.XTER_RQST_SEQ, EDI_RECEIVE_ID, ULTI_NEW_ASIA_CUST_FLG, ULTI_TRNS_CUST_FLG from BKG_XTER_CUST CUST, BKG_XTER_RQST_MST BK, (SELECT GRP.ESVC_GRP_CD           GROUP_EDI_ID" ).append("\n"); 
		query.append("                         , GRP.CUST_TRD_PRNR_ID     EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                         , GRP_CUST.CNT_CD   " ).append("\n"); 
		query.append("                         , GRP_CUST.CUST_SEQ" ).append("\n"); 
		query.append("                         , GRP_CUST.BKG_CUST_TP_DESC " ).append("\n"); 
		query.append("                         , GRP_CUST.ULTI_NEW_ASIA_CUST_FLG" ).append("\n"); 
		query.append("                         , GRP_CUST.ULTI_TRNS_CUST_FLG" ).append("\n"); 
		query.append("                   FROM BKG_EDI_GRP_CUST GRP_CUST, BKG_EDI_GRP GRP" ).append("\n"); 
		query.append("                  WHERE GRP.ESVC_GRP_CD         = GRP_CUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = GRP_CUST.CO_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = 'H'" ).append("\n"); 
		query.append("                    AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    AND GRP_CUST.CNT_CD         > ' '" ).append("\n"); 
		query.append("                    AND GRP_CUST.CUST_SEQ       > 0" ).append("\n"); 
		query.append("                    AND GRP_CUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                    AND GRP_CUST.BKG_CFM_FLG    = 'Y'" ).append("\n"); 
		query.append("                    ) EDI_BY_CUST where EDI_BY_CUST.CNT_CD   = CUST.CNT_CD  " ).append("\n"); 
		query.append("                                    AND EDI_BY_CUST.CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("                                    AND BK.XTER_RQST_NO            = CUST.XTER_RQST_NO" ).append("\n"); 
		query.append("                                    AND BK.XTER_SNDR_ID            = CUST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                    AND BK.XTER_RQST_SEQ           = CUST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("           ) EDI_CUST" ).append("\n"); 
		query.append(" WHERE MST.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("   AND MST.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("   AND MST.POD_CD = POD.LOC_CD(+)" ).append("\n"); 
		query.append("   AND MST.DEL_CD = DEL.LOC_CD(+)" ).append("\n"); 
		query.append("	   AND MST.XTER_SNDR_ID = EDI_CUST.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("       AND MST.XTER_RQST_NO = EDI_CUST.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("       AND MST.XTER_RQST_SEQ= EDI_CUST.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append(" -----조건절-----" ).append("\n"); 
		query.append("#if (${chn_agn_cd} != '') " ).append("\n"); 
		query.append("       AND ( SUBSTR(MST.BKG_NO,5,2) = @[chn_agn_cd] or SUBSTR(MST.BKG_NO,3,2) = @[chn_agn_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("## Customer Type에 따른 Customer Code 및 Customer Name이 조건으로 들어온 경우 <S>" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	#if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("		AND MST.SH_CNT = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("		AND MST.CN_CNT = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#elseif (${bkg_cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("		AND MST.FF_CNT = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("	#if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("		AND MST.SH_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("	#elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("		AND MST.CN_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("	#elseif (${bkg_cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("		AND MST.FF_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("	#if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("		AND UPPER(MST.SH_NM) LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("		AND UPPER(MST.CN_NM) LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#elseif (${bkg_cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("		AND UPPER(MST.FF_NM) LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("## Customer Type에 따른 Customer Code 및 Customer Name이 조건으로 들어온 경우 <E>" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntc_eml} != '') " ).append("\n"); 
		query.append("   AND MST.CNTC_EML = @[cntc_eml]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${origin} != '') " ).append("\n"); 
		query.append("   AND NVL(POR.CNT_CD, POL.CNT_CD) = @[origin]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${delivery} != 'All' && ${delivery} != '') " ).append("\n"); 
		query.append("   AND MST.DEL_CN IN ( ${delivery} ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("   AND POR_CD LIKE @[por_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_nm} != '') " ).append("\n"); 
		query.append("   AND NVL(POR.LOC_NM, XTER_POR_NM) LIKE @[por_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("   AND DEL_CD LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_nm} != '') " ).append("\n"); 
		query.append("   AND NVL(DEL.LOC_NM, XTER_DEL_NM) LIKE @[del_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("       AND MST.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_fnt_ofc_yn} != '') " ).append("\n"); 
		query.append("    AND BL_FNT_OFC_FLG = @[bl_fnt_ofc_yn]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${set_qry_where} != '') " ).append("\n"); 
		query.append("	${set_qry_where} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("group by MST.DOC_TP_CD" ).append("\n"); 
		query.append("        , MST.RQST_DT" ).append("\n"); 
		query.append("		, MST.BAG_DG" ).append("\n"); 
		query.append("        --, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',MST.CRE_DT,'GMT'), 'YYYY-MM-DD HH24:MI') RQST_GMT_DT" ).append("\n"); 
		query.append("        , MST.XTER_RQST_NO" ).append("\n"); 
		query.append("        , MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("        , MST.XTER_BKG_RQST_STS_CD" ).append("\n"); 
		query.append("        , MST.XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("        , MST.BKG_NO" ).append("\n"); 
		query.append("        , MST.BKG_UPLD_STS_CD" ).append("\n"); 
		query.append("        , MST.SH_NM" ).append("\n"); 
		query.append("        , MST.CN_NM" ).append("\n"); 
		query.append("        , MST.FF_NM" ).append("\n"); 
		query.append("        , MST.HNDL_OFC_CD" ).append("\n"); 
		query.append("        , MST.DEL_CN" ).append("\n"); 
		query.append("        , POR_CD" ).append("\n"); 
		query.append("        , POL_CD" ).append("\n"); 
		query.append("        , POD_CD" ).append("\n"); 
		query.append("        , DEL_CD" ).append("\n"); 
		query.append("        , MST.VVD" ).append("\n"); 
		query.append("        , MST.VSL_ENG_NM" ).append("\n"); 
		query.append("        , MST.PO_NO" ).append("\n"); 
		query.append("        , MST.CNTC_EML" ).append("\n"); 
		query.append("        , MST.OFC_CD" ).append("\n"); 
		query.append("        , MST.UPLD_USR_ID" ).append("\n"); 
		query.append("        , MST.UPLD_USR_NM" ).append("\n"); 
		query.append("        , MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("		, MST.VSL_CD" ).append("\n"); 
		query.append("		, MST.BKG_STS_CD" ).append("\n"); 
		query.append("		, MST.SNACCS_SPLIT_NO" ).append("\n"); 
		query.append("	    , RQST_ACPT_DESC" ).append("\n"); 
		query.append("		, XTER_RQST_ACPT_USR_ID" ).append("\n"); 
		query.append("		, XTER_RQST_ACPT_USR_NM" ).append("\n"); 
		query.append("        , MST.RJCT_RSN_RMK" ).append("\n"); 
		query.append("		, MST.CUST_REF_NO" ).append("\n"); 
		query.append("        , SLAN_CD" ).append("\n"); 
		query.append("        , OB_SREP_CD" ).append("\n"); 
		query.append("        , BL_FNT_OFC_FLG" ).append("\n"); 
		query.append("        , MST.SPLIT_STS_CD " ).append("\n"); 
		query.append("        , MST.XPT_REF_NO" ).append("\n"); 
		query.append("        , MST.FAX_LOG_REF_NO" ).append("\n"); 
		query.append("        , SR_KND_CD" ).append("\n"); 
		query.append("		, TMPLT_PAR_RTO" ).append("\n"); 
		query.append("        ,XTER_RQST_STS_OFC_CD" ).append("\n"); 
		query.append("        ,XTER_RQST_STS_USR_ID" ).append("\n"); 
		query.append("        ,XTER_RQST_STS_USR_NM" ).append("\n"); 
		query.append("        ,XTER_RQST_STS_UPD_DT" ).append("\n"); 
		query.append("        ,XTER_RQST_STS_CD" ).append("\n"); 
		query.append("    	, MST.PCTL_EXPT_FLG" ).append("\n"); 
		query.append("    	, MST.BKG_BLCK_FLG" ).append("\n"); 
		query.append("    	, MST.OTHER_FLAG" ).append("\n"); 
		query.append("		, MST.BL_NO_CTNT" ).append("\n"); 
		query.append("		, MST.SI_AUD_FLG" ).append("\n"); 
		query.append("		, MST.SYS_UPLD_FLG" ).append("\n"); 
		query.append("        , MST.CRE_DT" ).append("\n"); 
		query.append("        , MST.DISP_XTER_RQST_SEQ" ).append("\n"); 
		query.append("        , POR.CNT_CD" ).append("\n"); 
		query.append("        , POL.CNT_CD" ).append("\n"); 
		query.append("        , POR.LOC_NM" ).append("\n"); 
		query.append("        , XTER_POR_NM" ).append("\n"); 
		query.append("        , POL.LOC_NM" ).append("\n"); 
		query.append("        , XTER_POL_NM" ).append("\n"); 
		query.append("        , POD.LOC_NM" ).append("\n"); 
		query.append("        , XTER_POD_NM" ).append("\n"); 
		query.append("        , DEL.loc_nm" ).append("\n"); 
		query.append("        , XTER_DEL_NM" ).append("\n"); 
		query.append("        , MST.RQST_DEP_DT" ).append("\n"); 
		query.append("        , MST.SKD_VOY_NO" ).append("\n"); 
		query.append("        , MST.SKD_DIR_CD " ).append("\n"); 
		query.append("        , MST.UPLD_DT" ).append("\n"); 
		query.append("        , MST.XTER_RJCT_RSN_CD" ).append("\n"); 
		query.append("        , MST.EDI_RCV_RVIS_NO" ).append("\n"); 
		query.append("        , BL_DOC_INP_FLG" ).append("\n"); 
		query.append("		, MST.NON_RT_STS_CD" ).append("\n"); 
		query.append("        , MST.DCGO_FLG " ).append("\n"); 
		query.append("        , MST.RC_FLG " ).append("\n"); 
		query.append("        , MST.AWK_CGO_FLG " ).append("\n"); 
		query.append("        , MST.BB_CGO_FLG " ).append("\n"); 
		query.append("        , XTER_TEU" ).append("\n"); 
		query.append("        , BKG_TEU" ).append("\n"); 
		query.append("        , MST.CMDT_CD" ).append("\n"); 
		query.append("        , MST.CMDT_NM" ).append("\n"); 
		query.append("		, MST.XTER_RMK" ).append("\n"); 
		query.append("		, MST.CTRT_NO" ).append("\n"); 
		query.append("		, MST.CTRT_NM" ).append("\n"); 
		query.append("		, MST.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY MST.HNDL_OFC_CD, ROW_NUM, XTER_RQST_NO" ).append("\n"); 

	}
}