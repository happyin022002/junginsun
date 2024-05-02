/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.15 
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

public class EBookingReceiptDBDAOsearchXterCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterCust
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterCustRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterCustRSQL").append("\n"); 
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
		query.append("SELECT MST.XTER_RQST_NO" ).append("\n"); 
		query.append("		, MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("        , MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("        , UPPER(SH.CNT_CD) SH_CUST_CNT_CD" ).append("\n"); 
		query.append("        , UPPER(SH.CUST_SEQ) SH_CUST_SEQ" ).append("\n"); 
		query.append("        , UPPER(SH.CNT_CD||SH.CUST_SEQ) SH_CNT_SEQ" ).append("\n"); 
		query.append("        , UPPER(TRIM(REPLACE(SH.CUST_NM,'@@',CHR(13)||CHR(10)))) SH_CUST_NM" ).append("\n"); 
		query.append("		, UPPER(mdm_sh.CUST_LGL_ENG_NM) SH_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        --, UPPER(TRIM(REPLACE(SH.CUST_ADDR" ).append("\n"); 
		query.append("		--		 ||decode(trim(SH.CNTC_NM)         , null, '', ' Attn:'||SH.CNTC_NM)" ).append("\n"); 
		query.append("		--		 ||decode(trim(SH.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||SH.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("		--		 ||decode(trim(SH.CNTC_FAX_NO)     , null, '', ' FAX:' ||SH.CNTC_FAX_NO)" ).append("\n"); 
		query.append("		--		 ||decode(trim(SH.CNTC_EML)        , null, '', ' Mail:'||SH.CNTC_EML),'@@',CHR(13)||CHR(10)))) SH_CUST_ADDR" ).append("\n"); 
		query.append("    	, CASE" ).append("\n"); 
		query.append("        	WHEN  (SELECT SUBSTR(POL_CD, 1, 2) FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) != 'KR'" ).append("\n"); 
		query.append("          		THEN	UPPER(TRIM(REPLACE(SH.CUST_ADDR" ).append("\n"); 
		query.append("                		||decode(trim(SH.CNTC_NM)         , null, '', ' Attn:'||SH.CNTC_NM)" ).append("\n"); 
		query.append("                		||decode(trim(SH.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||SH.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("                		||decode(trim(SH.CNTC_FAX_NO)     , null, '', ' FAX:' ||SH.CNTC_FAX_NO)" ).append("\n"); 
		query.append("                		||decode(trim(SH.CNTC_EML)        , null, '', ' Mail:'||SH.CNTC_EML),'@@',CHR(13)||CHR(10)))) " ).append("\n"); 
		query.append("        	ELSE" ).append("\n"); 
		query.append("          		UPPER(TRIM(REPLACE(SH.CUST_ADDR,'@@',CHR(13)||CHR(10))))" ).append("\n"); 
		query.append("    	END AS SH_CUST_ADDR" ).append("\n"); 
		query.append("        , UPPER(SH.LOC_NM) SH_CUST_CTY_NM" ).append("\n"); 
		query.append("		, UPPER(SH.STE_CD) SH_CUST_STE_CD" ).append("\n"); 
		query.append("		, UPPER(SH.CNTC_FAX_NO) SH_CUST_FAX_NO" ).append("\n"); 
		query.append("		, UPPER(CASE" ).append("\n"); 
		query.append("            WHEN MST.XTER_SNDR_ID = 'WEB' THEN SH.CUST_EML" ).append("\n"); 
		query.append("            ELSE SH.CNTC_EML" ).append("\n"); 
		query.append("          END) SH_CUST_EML" ).append("\n"); 
		query.append("		, UPPER(SH.PHN_PFX_NO||SH.PHN_NO) SH_CUST_PHN_NO" ).append("\n"); 
		query.append("        , UPPER(SH.LOC_CTNT) SH_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("		, UPPER(SH.PST_CTNT) SH_CUST_ZIP_ID" ).append("\n"); 
		query.append("		, UPPER(NVL(SH.EORI_NO, '')) SH_EORI_NO" ).append("\n"); 
		query.append("		, UPPER(NVL(SH.EUR_CSTMS_PST_ID, '')) SH_EUR_CSTMS_PST_ID" ).append("\n"); 
		query.append("		, UPPER(NVL(SH.EUR_CSTMS_ST_NM, '')) SH_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("        , UPPER(CN.CNT_CD) CN_CUST_CNT_CD" ).append("\n"); 
		query.append("        , UPPER(CN.CUST_SEQ) CN_CUST_SEQ" ).append("\n"); 
		query.append("        , UPPER(CN.CNT_CD||cn.CUST_SEQ) CN_CNT_SEQ" ).append("\n"); 
		query.append("        , UPPER(TRIM(REPLACE(CN.CUST_NM,'@@',CHR(13)||CHR(10)))) CN_CUST_NM" ).append("\n"); 
		query.append("		, UPPER(mdm_cn.CUST_LGL_ENG_NM) CN_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        --, UPPER(TRIM(REPLACE(CN.CUST_ADDR" ).append("\n"); 
		query.append("		--		 ||decode(trim(CN.CNTC_NM)         , null, '', ' Attn:'||CN.CNTC_NM)" ).append("\n"); 
		query.append("		--		 ||decode(trim(CN.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||CN.CNTC_PHN_NO_CTNT),'@@',CHR(13)||CHR(10)))) CN_CUST_ADDR" ).append("\n"); 
		query.append("		, CASE" ).append("\n"); 
		query.append("			WHEN  (SELECT SUBSTR(POL_CD, 1, 2) FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) != 'KR'" ).append("\n"); 
		query.append("				THEN	UPPER(TRIM(REPLACE(CN.CUST_ADDR" ).append("\n"); 
		query.append("						||decode(trim(CN.CNTC_NM)         , null, '', ' Attn:'||CN.CNTC_NM)" ).append("\n"); 
		query.append("						||decode(trim(CN.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||CN.CNTC_PHN_NO_CTNT),'@@',CHR(13)||CHR(10))))" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				UPPER(TRIM(REPLACE(CN.CUST_ADDR,'@@',CHR(13)||CHR(10))))" ).append("\n"); 
		query.append("		END AS CN_CUST_ADDR" ).append("\n"); 
		query.append("        , UPPER(CN.LOC_NM)  CN_CUST_CTY_NM" ).append("\n"); 
		query.append("		, UPPER(CN.STE_CD)  CN_CUST_STE_CD" ).append("\n"); 
		query.append("        , UPPER(CN.CNTC_FAX_NO) CN_CUST_FAX_NO" ).append("\n"); 
		query.append("		-- 변경 사유 : ESVC와 EDI에서 사용하는 E-mail 컬럼이 상이하여 CN_CUST_EML 변경 (ESVC : CUST_EML, EDI : CNTC_EML)" ).append("\n"); 
		query.append("        --, CN.CNTC_EML CN_CUST_EML" ).append("\n"); 
		query.append("		, UPPER(CASE" ).append("\n"); 
		query.append("			WHEN MST.XTER_SNDR_ID = 'WEB' THEN CN.CUST_EML" ).append("\n"); 
		query.append("			ELSE CN.CNTC_EML" ).append("\n"); 
		query.append("		  END) CN_CUST_EML" ).append("\n"); 
		query.append("		, UPPER(CN.PHN_PFX_NO||CN.PHN_NO) CN_CUST_PHN_NO" ).append("\n"); 
		query.append("        , UPPER(CN.LOC_CTNT)  CN_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("		, UPPER(CN.PST_CTNT)  CN_CUST_ZIP_ID" ).append("\n"); 
		query.append("		, UPPER(CN.CO_CHN_TP_CD) CN_CO_CHN_TP_CD" ).append("\n"); 
		query.append("		, UPPER(NVL(CN.EORI_NO, '')) CN_EORI_NO" ).append("\n"); 
		query.append("		, UPPER(NVL(CN.EUR_CSTMS_PST_ID, '')) CN_EUR_CSTMS_PST_ID" ).append("\n"); 
		query.append("		, UPPER(NVL(CN.EUR_CSTMS_ST_NM, '')) CN_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("		, UPPER(CN.FAX_NO1) CN_IEC_FAX" ).append("\n"); 
		query.append("        , UPPER(NF.CNT_CD) NF_CUST_CNT_CD" ).append("\n"); 
		query.append("        , UPPER(NF.CUST_SEQ) NF_CUST_SEQ" ).append("\n"); 
		query.append("        , UPPER(NF.CNT_CD||NF.CUST_SEQ) NF_CNT_SEQ" ).append("\n"); 
		query.append("        , UPPER(TRIM(REPLACE(NF.CUST_NM,'@@',CHR(13)||CHR(10)))) NF_CUST_NM" ).append("\n"); 
		query.append("		, UPPER(mdm_nf.CUST_LGL_ENG_NM) NF_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        --, UPPER(TRIM(REPLACE(NF.CUST_ADDR" ).append("\n"); 
		query.append("		--		 ||decode(trim(NF.CNTC_NM)         , null, '', ' Attn:'||NF.CNTC_NM)" ).append("\n"); 
		query.append("		--		 ||decode(trim(NF.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||NF.CNTC_PHN_NO_CTNT),'@@',CHR(13)||CHR(10)))) NF_CUST_ADDR" ).append("\n"); 
		query.append("		, CASE" ).append("\n"); 
		query.append("			WHEN  (SELECT SUBSTR(POL_CD, 1, 2) FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) != 'KR'" ).append("\n"); 
		query.append("				THEN	UPPER(TRIM(REPLACE(NF.CUST_ADDR" ).append("\n"); 
		query.append("						||decode(trim(NF.CNTC_NM)         , null, '', ' Attn:'||NF.CNTC_NM)" ).append("\n"); 
		query.append("						||decode(trim(NF.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||NF.CNTC_PHN_NO_CTNT),'@@',CHR(13)||CHR(10))))" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				UPPER(TRIM(REPLACE(NF.CUST_ADDR,'@@',CHR(13)||CHR(10))))" ).append("\n"); 
		query.append("		END AS NF_CUST_ADDR" ).append("\n"); 
		query.append("        , UPPER(NF.loc_nm)  NF_CUST_CTY_NM" ).append("\n"); 
		query.append("		, UPPER(NF.STE_CD)  NF_CUST_STE_CD" ).append("\n"); 
		query.append("        , UPPER(NF.loc_ctnt)  NF_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("		, UPPER(NF.PST_CTNT)  NF_CUST_ZIP_ID" ).append("\n"); 
		query.append("        , UPPER(NF.CNTC_FAX_NO) NF_CUST_FAX_NO" ).append("\n"); 
		query.append("        -- 변경 사유 : ESVC와 EDI에서 사용하는 E-mail 컬럼이 상이하여 NF_CUST_EML 변경 (ESVC : CUST_EML, EDI : CNTC_EML)" ).append("\n"); 
		query.append("        --, NF.CNTC_EML NF_CUST_EML" ).append("\n"); 
		query.append("		, UPPER(CASE" ).append("\n"); 
		query.append("            WHEN MST.XTER_SNDR_ID = 'WEB' THEN NF.CUST_EML" ).append("\n"); 
		query.append("            ELSE NF.CNTC_EML" ).append("\n"); 
		query.append("          END) NF_CUST_EML" ).append("\n"); 
		query.append("        , UPPER(NF.PHN_PFX_NO||NF.PHN_NO) NF_CUST_PHN_NO" ).append("\n"); 
		query.append("		, UPPER(NF.CO_CHN_TP_CD) NF_CO_CHN_TP_CD" ).append("\n"); 
		query.append("		, UPPER(NVL(NF.EORI_NO, ' ')) NF_EORI_NO" ).append("\n"); 
		query.append("		, UPPER(NVL(NF.EUR_CSTMS_PST_ID, ' ')) NF_EUR_CSTMS_PST_ID" ).append("\n"); 
		query.append("		, UPPER(NVL(NF.EUR_CSTMS_ST_NM, ' ')) NF_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("        , UPPER(FF.CNT_CD) FF_CUST_CNT_CD" ).append("\n"); 
		query.append("        , UPPER(FF.CUST_SEQ) FF_CUST_SEQ" ).append("\n"); 
		query.append("        , UPPER(FF.CNT_CD||ff.CUST_SEQ) FF_CNT_SEQ" ).append("\n"); 
		query.append("        --, UPPER(TRIM(REPLACE(FF.CUST_NM||CHR(13)||CHR(10)			 " ).append("\n"); 
		query.append("		--		 ||FF.CUST_ADDR" ).append("\n"); 
		query.append("		--		 ||decode(trim(FF.CNTC_NM)         , null, '', ' Attn:'||FF.CNTC_NM)" ).append("\n"); 
		query.append("		--		 ||decode(trim(FF.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||FF.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("		--		 ||decode(trim(FF.CNTC_FAX_NO)     , null, '', ' FAX:' ||FF.CNTC_FAX_NO)" ).append("\n"); 
		query.append("		--		 ||decode(trim(FF.CNTC_EML)        , null, '', ' Mail:'||FF.CNTC_EML),'@@',CHR(13)||CHR(10)))) FF_CUST_NM" ).append("\n"); 
		query.append("		, CASE" ).append("\n"); 
		query.append("			WHEN  (SELECT SUBSTR(POL_CD, 1, 2) FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) != 'KR'" ).append("\n"); 
		query.append("				THEN	UPPER(TRIM(REPLACE(FF.CUST_NM||CHR(13)||CHR(10)" ).append("\n"); 
		query.append("						||FF.CUST_ADDR" ).append("\n"); 
		query.append("						||decode(trim(FF.CNTC_NM)         , null, '', ' Attn:'||FF.CNTC_NM)" ).append("\n"); 
		query.append("						||decode(trim(FF.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||FF.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("						||decode(trim(FF.CNTC_FAX_NO)     , null, '', ' FAX:' ||FF.CNTC_FAX_NO)" ).append("\n"); 
		query.append("						||decode(trim(FF.CNTC_EML)        , null, '', ' Mail:'||FF.CNTC_EML),'@@',CHR(13)||CHR(10))))" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				UPPER(TRIM(REPLACE(FF.CUST_NM||CHR(13)||CHR(10)||FF.CUST_ADDR,'@@',CHR(13)||CHR(10))))" ).append("\n"); 
		query.append("		END AS FF_CUST_NM" ).append("\n"); 
		query.append("		, UPPER(mdm_ff.CUST_LGL_ENG_NM) FF_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , UPPER(TRIM(REPLACE(FF.CUST_ADDR,'@@',CHR(13)||CHR(10)))) FF_CUST_ADDR" ).append("\n"); 
		query.append("        , UPPER(AN.CNT_CD) AN_CUST_CNT_CD" ).append("\n"); 
		query.append("        , UPPER(AN.CUST_SEQ) AN_CUST_SEQ" ).append("\n"); 
		query.append("        , UPPER(AN.CNT_CD||an.CUST_SEQ) AN_CNT_SEQ" ).append("\n"); 
		query.append("        --, UPPER(TRIM(REPLACE(AN.CUST_NM||CHR(13)||CHR(10)" ).append("\n"); 
		query.append("		--		 ||AN.CUST_ADDR" ).append("\n"); 
		query.append("		--		 ||decode(trim(AN.CNTC_NM)         , null, '', ' Attn:'||AN.CNTC_NM)" ).append("\n"); 
		query.append("		--		 ||decode(trim(AN.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||AN.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("		--		 ||decode(trim(AN.CNTC_FAX_NO)     , null, '', ' FAX:' ||AN.CNTC_FAX_NO)" ).append("\n"); 
		query.append("		--		 ||decode(trim(AN.CNTC_EML)        , null, '', ' Mail:'||AN.CNTC_EML),'@@',CHR(13)||CHR(10)))) AN_CUST_NM" ).append("\n"); 
		query.append("		, CASE" ).append("\n"); 
		query.append("			WHEN  (SELECT SUBSTR(POL_CD, 1, 2) FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) != 'KR'" ).append("\n"); 
		query.append("				THEN	UPPER(TRIM(REPLACE(AN.CUST_NM||CHR(13)||CHR(10)" ).append("\n"); 
		query.append("						||AN.CUST_ADDR" ).append("\n"); 
		query.append("						||decode(trim(AN.CNTC_NM)         , null, '', ' Attn:'||AN.CNTC_NM)" ).append("\n"); 
		query.append("						||decode(trim(AN.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||AN.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("						||decode(trim(AN.CNTC_FAX_NO)     , null, '', ' FAX:' ||AN.CNTC_FAX_NO)" ).append("\n"); 
		query.append("						||decode(trim(AN.CNTC_EML)        , null, '', ' Mail:'||AN.CNTC_EML),'@@',CHR(13)||CHR(10))))" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				UPPER(TRIM(REPLACE(AN.CUST_NM||CHR(13)||CHR(10)||AN.CUST_ADDR,'@@',CHR(13)||CHR(10))))" ).append("\n"); 
		query.append("		END AS AN_CUST_NM" ).append("\n"); 
		query.append("		, UPPER(MDM_AN.CUST_LGL_ENG_NM) AN_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , UPPER(TRIM(REPLACE(AN.CUST_ADDR,'@@',CHR(13)||CHR(10)))) AN_CUST_ADDR" ).append("\n"); 
		query.append("        , UPPER(ex.CNT_CD) EX_CUST_CNT_CD" ).append("\n"); 
		query.append("        , UPPER(ex.CUST_SEQ) EX_CUST_SEQ" ).append("\n"); 
		query.append("        , UPPER(ex.CUST_NM||(select CHR(13)||CHR(10)||ex.cust_addr||CHR(13)||CHR(10)||ex.loc_nm||CHR(13)||CHR(10)||ex.pst_ctnt " ).append("\n"); 
		query.append("                         from BKG_HRD_CDG_CTNT bhc " ).append("\n"); 
		query.append("                        where BHC.HRD_CDG_ID = 'EBKG_HND_OFC' " ).append("\n"); 
		query.append("                          and bhc.attr_ctnt1 = ex.cnt_cd " ).append("\n"); 
		query.append("                          and bhc.attr_ctnt2 = ex.cust_seq" ).append("\n"); 
		query.append("                          and rownum = 1)) EX_CUST_NM" ).append("\n"); 
		query.append("        , UPPER(MDM_EX.CUST_LGL_ENG_NM) EX_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , UPPER(BR.BRO_NO) BR_CUST_CNT_CD" ).append("\n"); 
		query.append("        , UPPER(TRIM(REPLACE(BR.CUST_NM,'@@',CHR(13)||CHR(10)))) BR_CUST_NM" ).append("\n"); 
		query.append("        , UPPER(TRIM(REPLACE(BR.CUST_ADDR" ).append("\n"); 
		query.append("				 ||decode(trim(BR.CNTC_NM)         , null, '', ' Attn:'||BR.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(BR.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||BR.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("				 ||decode(trim(BR.CNTC_FAX_NO)     , null, '', ' FAX:' ||BR.CNTC_FAX_NO)" ).append("\n"); 
		query.append("				 ||decode(trim(BR.CNTC_EML)        , null, '', ' Mail:'||BR.CNTC_EML),'@@',CHR(13)||CHR(10)))) BR_CUST_ADDR" ).append("\n"); 
		query.append("        , UPPER(DECODE(MST.XTER_RQST_VIA_CD, 'WEB', MST.KR_CSTMS_CUST_TP_CD," ).append("\n"); 
		query.append("                (SELECT DECODE(RVIS_CNTR_CUST_TP_CD, 'B', 'S', 'N', 'C', DECODE(INDIV_CORP_DIV_CD, 'P', 'S', 'C'))" ).append("\n"); 
		query.append("                 FROM MDM_CUSTOMER CUST " ).append("\n"); 
		query.append("                 WHERE CUST.CUST_CNT_CD = SH.CNT_CD " ).append("\n"); 
		query.append("                 AND CUST.CUST_SEQ = SH.CUST_SEQ )" ).append("\n"); 
		query.append("          )) SH_KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append("        , CASE WHEN INSTR(UPPER(CN.CUST_NM), 'ORDER') > 0 THEN 'Y' ELSE (SELECT NVL(CUST_TO_ORD_FLG,'N') FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) END CN_CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("        , (SELECT DECODE(RVIS_CNTR_CUST_TP_CD, 'B', 'S', 'C') FROM MDM_CUSTOMER WHERE CUST_CNT_CD = SH.CNT_CD AND CUST_SEQ = SH.CUST_SEQ) RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("		, UPPER(CBR.CUST_NM) CBR_CUST_NM" ).append("\n"); 
		query.append("		, UPPER(CBR.FAX_NO1) CBR_FAX_NO1" ).append("\n"); 
		query.append("		, UPPER(CBR.FAX_NO2) CBR_FAX_NO2" ).append("\n"); 
		query.append("		, UPPER(CBR.FAX_NO3) CBR_FAX_NO3" ).append("\n"); 
		query.append("		, UPPER(MST.ORG_CNT_NM) ORG_CNT_NM" ).append("\n"); 
		query.append("		, UPPER(MST.AGMT_ACT_CNT_CD) AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("		, UPPER(MST.AGMT_ACT_CUST_SEQ) AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("        , BKG_XTER_CUST SH" ).append("\n"); 
		query.append("        , BKG_XTER_CUST CN" ).append("\n"); 
		query.append("        , BKG_XTER_CUST NF" ).append("\n"); 
		query.append("        , BKG_XTER_CUST FF" ).append("\n"); 
		query.append("        , BKG_XTER_CUST AN" ).append("\n"); 
		query.append("        , BKG_XTER_CUST EX" ).append("\n"); 
		query.append("        , BKG_XTER_CUST BR" ).append("\n"); 
		query.append("        , BKG_XTER_CUST CBR" ).append("\n"); 
		query.append("        , MDM_CUSTOMER MDM_SH" ).append("\n"); 
		query.append("        , MDM_CUSTOMER MDM_CN" ).append("\n"); 
		query.append("        , MDM_CUSTOMER MDM_NF" ).append("\n"); 
		query.append("        , MDM_CUSTOMER MDM_FF" ).append("\n"); 
		query.append("        , MDM_CUSTOMER MDM_AN" ).append("\n"); 
		query.append("		, MDM_CUSTOMER MDM_EX" ).append("\n"); 
		query.append("WHERE MST.XTER_RQST_NO  = SH.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = SH.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = SH.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("  AND 'S'               = SH.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO  = CN.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = CN.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = CN.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("  AND 'C'               = CN.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO  = NF.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = NF.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = NF.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("  AND 'N'               = NF.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO  = FF.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = FF.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = FF.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("  AND 'F'               = FF.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO  = AN.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = AN.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = AN.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("  AND 'A'               = AN.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO  = EX.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = EX.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = EX.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("  AND 'E'               = EX.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO  = CBR.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = CBR.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = CBR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("  AND 'J'               = CBR.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO  = BR.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = BR.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = BR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("  AND 'B'               = BR.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("  AND SH.CNT_CD       = MDM_SH.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND SH.CUST_SEQ     = MDM_SH.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND CN.CNT_CD       = MDM_CN.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND CN.CUST_SEQ     = MDM_CN.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND NF.CNT_CD       = MDM_NF.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND NF.CUST_SEQ     = MDM_NF.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND FF.CNT_CD       = MDM_FF.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND FF.CUST_SEQ     = MDM_FF.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND AN.CNT_CD       = MDM_AN.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND AN.CUST_SEQ     = MDM_AN.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND EX.CNT_CD       = MDM_EX.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND EX.CUST_SEQ     = MDM_EX.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 

	}
}