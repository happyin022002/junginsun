/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRqstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.06 
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

public class EBookingReceiptDBDAOsearchXterRqstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterRqstList
	  * 2010.11.04 김영철 [CHM-201005975-01] SEANACCS ACL 변경 요청 (E-BKG&SI & DPCS 관련) - EDI로 들어온 Data가 처리되었는지 Validation 추가 요청
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chn_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("origin",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("po_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
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
		query.append("SELECT MST.DOC_TP_CD DOC_TP_CD" ).append("\n"); 
		query.append("        , TO_CHAR(MST.RQST_DT, 'YYYY-MM-DD HH24:MI') RQST_DT" ).append("\n"); 
		query.append("        , MST.XTER_RQST_NO XTER_RQST_NO" ).append("\n"); 
		query.append("		, NVL(XTER_RQST_NO2,XTER_RQST_NO) XTER_RQST_NO2" ).append("\n"); 
		query.append("        , MST.XTER_RQST_SEQ XTER_RQST_SEQ" ).append("\n"); 
		query.append("        , MST.XTER_BKG_RQST_STS_CD XTER_BKG_RQST_STS_CD" ).append("\n"); 
		query.append("        , MST.XTER_RQST_VIA_CD XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("        , MST.BKG_NO BKG_NO" ).append("\n"); 
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
		query.append("		, (" ).append("\n"); 
		query.append("    		SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("   			  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("   			 WHERE INTG_CD_ID = 'CD02193'" ).append("\n"); 
		query.append("    		   AND INTG_CD_VAL_CTNT = MST.XTER_RJCT_RSN_CD ) XTER_RJCT_RSN_NM" ).append("\n"); 
		query.append("		, MST.CUST_REF_NO CUST_REF_NO" ).append("\n"); 
		query.append("		, DECODE(MST.XTER_SNDR_ID,'SEANACCS',MST.EDI_RCV_RVIS_NO,MST.XTER_RQST_SEQ) XTER_RQST_RVIS_SEQ" ).append("\n"); 
		query.append("		, (SELECT BBI.BL_PRF_SHPR_FLG FROM BKG_BL_ISS BBI WHERE BBI.BKG_NO = MST.BKG_NO) AS BL_PRF_SHPR_FLG" ).append("\n"); 
		query.append("		, (SELECT BBI.BL_ISS_TP_CD FROM BKG_BL_ISS BBI WHERE BBI.BKG_NO = MST.BKG_NO) AS BL_ISS_TP_CD" ).append("\n"); 
		query.append("		, MST.BL_NO_CTNT" ).append("\n"); 
		query.append("		, PRE_HNDL_OFC_CD" ).append("\n"); 
		query.append("		, CNG_HNDL_OFC_USR_ID" ).append("\n"); 
		query.append("		, CNG_HNDL_OFC_UPD_DT " ).append("\n"); 
		query.append("		, MST.SLAN_CD " ).append("\n"); 
		query.append("    	, BKG_JOIN_FNC(CURSOR(SELECT BQ.CNTR_TPSZ_CD||'-'||BQ.OP_CNTR_QTY FROM BKG_QUANTITY BQ WHERE MST.BKG_NO = BQ.BKG_NO),',') AS BKG_CNTR_TP_SZ" ).append("\n"); 
		query.append("    	, BKG_JOIN_FNC(CURSOR(SELECT BXQ.CNTR_TPSZ_CD||'-'||BXQ.CNTR_QTY FROM BKG_XTER_QTY BXQ WHERE MST.XTER_SNDR_ID=BXQ.XTER_SNDR_ID AND MST.XTER_RQST_NO=BXQ.XTER_RQST_NO AND MST.XTER_RQST_SEQ=BXQ.XTER_RQST_SEQ),',') AS RQST_CNTR_TP_SZ" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (SELECT XBK.DOC_TP_CD" ).append("\n"); 
		query.append("            , XBK.RQST_DT" ).append("\n"); 
		query.append("            , XBK.XTER_RQST_NO" ).append("\n"); 
		query.append("			, DECODE(XBK.XTER_SNDR_ID,'PEGASUS',DECODE(XBK.PGSS_EDI_ID,'PG','',XBK.ACT_CUST_REF_NO)) XTER_RQST_NO2" ).append("\n"); 
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
		query.append("            , REPLACE(REPLACE(NVL(NVL(MSH.CUST_LGL_ENG_NM, SH.CUST_NM), XSH.CUST_NM), CHR(10),' '),CHR(9),' ') SH_NM" ).append("\n"); 
		query.append("            , REPLACE(REPLACE(NVL(NVL(MCN.CUST_LGL_ENG_NM, CN.CUST_NM), XCN.CUST_NM), CHR(10),' '),CHR(9),' ') CN_NM" ).append("\n"); 
		query.append("            , REPLACE(REPLACE(NVL(NVL(MFF.CUST_LGL_ENG_NM, FF.CUST_NM), XFF.CUST_NM), CHR(10),' '),CHR(9),' ') FF_NM" ).append("\n"); 
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
		query.append("            , CASE WHEN XBK.DOC_TP_CD = 'S' THEN XBK.SI_CNTC_EML " ).append("\n"); 
		query.append("              ELSE XBK.CNTC_EML" ).append("\n"); 
		query.append("      		  END AS CNTC_EML" ).append("\n"); 
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
		query.append("			, NVL(XBK.SNACCS_SPLIT_NO,DECODE(XBK.BL_SPLIT_NO,NULL,NULL,XBK.SPLIT_STS_CD||XBK.BL_SPLIT_NO)) SNACCS_SPLIT_NO" ).append("\n"); 
		query.append("			, (SELECT CONTI_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("			    WHERE CNT_CD LIKE SUBSTR(NVL(NVL(BK.DEL_CD, XBK.DEL_CD), NVL(BK.POD_CD, XBK.POD_CD)), 1, 2)||'%'" ).append("\n"); 
		query.append("			      AND ROWNUM = 1 ) DEL_CN" ).append("\n"); 
		query.append("			, DECODE(NVL(XBK.XTER_RQST_ACPT_CD, 'X'), 'R', 'Rejected', 'C', 'Confirmed', '') RQST_ACPT_DESC" ).append("\n"); 
		query.append("			, XBK.XTER_RQST_ACPT_USR_ID" ).append("\n"); 
		query.append("			, (SELECT USR_NM FROM COM_USER WHERE UPPER(USR_ID) = UPPER(XBK.XTER_RQST_ACPT_USR_ID)) XTER_RQST_ACPT_USR_NM" ).append("\n"); 
		query.append("			, XBK.XTER_RJCT_RSN_CD XTER_RJCT_RSN_CD" ).append("\n"); 
		query.append("			, XBK.CUST_REF_NO CUST_REF_NO" ).append("\n"); 
		query.append("			, BK.SLAN_CD" ).append("\n"); 
		query.append("			, XBK.EDI_RCV_RVIS_NO" ).append("\n"); 
		query.append("			, XBK.BL_NO_CTNT" ).append("\n"); 
		query.append("			, PRE_HNDL_OFC_CD" ).append("\n"); 
		query.append("			, CNG_HNDL_OFC_USR_ID" ).append("\n"); 
		query.append("			, CNG_HNDL_OFC_UPD_DT " ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK, BKG_CUSTOMER SH, BKG_CUSTOMER CN, BKG_CUSTOMER FF" ).append("\n"); 
		query.append("            , BKG_XTER_RQST_MST XBK, BKG_XTER_CUST XSH, BKG_XTER_CUST XCN, BKG_XTER_CUST XFF" ).append("\n"); 
		query.append("            , MDM_CUSTOMER MSH, MDM_CUSTOMER MCN, MDM_CUSTOMER MFF" ).append("\n"); 
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
		query.append("	   AND DECODE(XBK.XTER_SNDR_ID, 'SEANACCS', XBK.SNACCS_MSG_TP_CD, ' ') NOT IN ( 'SAT050', 'SAT054' )" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("--       -------조건절 시작-------" ).append("\n"); 
		query.append("#if (${rqst_from_dt} != '') " ).append("\n"); 
		query.append("       AND XBK.RQST_DT > TO_DATE(@[rqst_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rqst_to_dt} != '') " ).append("\n"); 
		query.append("       AND XBK.RQST_DT < TO_DATE(@[rqst_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${xter_bkg_rqst_sts_cd} != 'All' && ${xter_bkg_rqst_sts_cd} != '') " ).append("\n"); 
		query.append("       AND XBK.XTER_BKG_RQST_STS_CD in ( ${xter_bkg_rqst_sts_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_upld_sts_cd} != 'All' && ${bkg_upld_sts_cd} != '') " ).append("\n"); 
		query.append("       AND XBK.BKG_UPLD_STS_CD in ( ${bkg_upld_sts_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${xter_rqst_no} != '') " ).append("\n"); 
		query.append("	   AND (XBK.XTER_RQST_NO = @[xter_rqst_no] OR XBK.ACT_CUST_REF_NO = @[xter_rqst_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${xter_rqst_seq} != '') " ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_SEQ= @[xter_rqst_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("      #if (${split} != '') " ).append("\n"); 
		query.append("         AND XBK.BKG_NO LIKE SUBSTR(@[bkg_no],1,10)||'%'" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("         AND XBK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${po_no} != '') " ).append("\n"); 
		query.append("       AND XBK.PO_NO = @[po_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${xter_rqst_via_cd} != 'All' && ${xter_rqst_via_cd} != '') " ).append("\n"); 
		query.append("       AND XBK.XTER_RQST_VIA_CD in ( ${xter_rqst_via_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${doc_tp_cd} != 'All' && ${doc_tp_cd} != '')" ).append("\n"); 
		query.append("       AND XBK.DOC_TP_CD in ( ${doc_tp_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hndl_ofc_cd} != '') " ).append("\n"); 
		query.append("       AND NVL(XBK.HNDL_OFC_CD, @[hndl_ofc_cd]) = @[hndl_ofc_cd]" ).append("\n"); 
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
		query.append("#if (${lane} != '') " ).append("\n"); 
		query.append("       AND BK.SLAN_CD = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) MST" ).append("\n"); 
		query.append("       , MDM_LOCATION POR, MDM_LOCATION POL, MDM_LOCATION POD, MDM_LOCATION DEL" ).append("\n"); 
		query.append(" WHERE MST.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("   AND MST.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("   AND MST.POD_CD = POD.LOC_CD(+)" ).append("\n"); 
		query.append("   AND MST.DEL_CD = DEL.LOC_CD(+)" ).append("\n"); 
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
		query.append("   AND MST.DEL_CN in ( ${delivery} ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("   AND POR_CD like @[por_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_nm} != '') " ).append("\n"); 
		query.append("   AND NVL(POR.LOC_NM, XTER_POR_NM) LIKE @[por_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND POL_CD like @[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND POD_CD like @[pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("   AND DEL_CD like @[del_cd]||'%'" ).append("\n"); 
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
		query.append("#if (${set_qry_where} != '') " ).append("\n"); 
		query.append("	${set_qry_where} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("order by MST.HNDL_OFC_CD, ROW_NUM, XTER_RQST_NO" ).append("\n"); 

	}
}