/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.05.03 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
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
		query.append("        , SH.CNT_CD SH_CUST_CNT_CD" ).append("\n"); 
		query.append("        , SH.CUST_SEQ SH_CUST_SEQ" ).append("\n"); 
		query.append("        , SH.CNT_CD||SH.CUST_SEQ SH_CNT_SEQ" ).append("\n"); 
		query.append("        , TRIM(REPLACE(SH.CUST_NM,'@@',CHR(10))) SH_CUST_NM" ).append("\n"); 
		query.append("		, mdm_sh.CUST_LGL_ENG_NM SH_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(SH.CUST_ADDR,'@@',CHR(10))) SH_CUST_ADDR" ).append("\n"); 
		query.append("        , SH.LOC_NM SH_CUST_CTY_NM, SH.STE_CD SH_CUST_STE_CD" ).append("\n"); 
		query.append("        , SH.LOC_CTNT SH_CSTMS_DECL_CNT_CD, SH.PST_CTNT SH_CUST_ZIP_ID" ).append("\n"); 
		query.append("		, NVL(SH.EORI_NO, '') SH_EORI_NO" ).append("\n"); 
		query.append("		, NVL(SH.EUR_CSTMS_PST_ID, '') SH_EUR_CSTMS_PST_ID" ).append("\n"); 
		query.append("		, NVL(SH.EUR_CSTMS_ST_NM, '') SH_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("        , CN.CNT_CD CN_CUST_CNT_CD" ).append("\n"); 
		query.append("        , CN.CUST_SEQ CN_CUST_SEQ" ).append("\n"); 
		query.append("        , CN.CNT_CD||cn.CUST_SEQ CN_CNT_SEQ" ).append("\n"); 
		query.append("        , TRIM(REPLACE(CN.CUST_NM,'@@',CHR(10))) CN_CUST_NM" ).append("\n"); 
		query.append("		, mdm_cn.CUST_LGL_ENG_NM CN_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(CN.CUST_ADDR,'@@',CHR(10))) CN_CUST_ADDR" ).append("\n"); 
		query.append("        , CN.LOC_NM  CN_CUST_CTY_NM, CN.STE_CD  CN_CUST_STE_CD" ).append("\n"); 
		query.append("        , CN.CNTC_FAX_NO CN_CUST_FAX_NO" ).append("\n"); 
		query.append("        , CN.CNTC_EML CN_CUST_EML" ).append("\n"); 
		query.append("        , CN.LOC_CTNT  CN_CSTMS_DECL_CNT_CD, CN.PST_CTNT  CN_CUST_ZIP_ID" ).append("\n"); 
		query.append("		, NVL(CN.EORI_NO, '') CN_EORI_NO" ).append("\n"); 
		query.append("		, NVL(CN.EUR_CSTMS_PST_ID, '') CN_EUR_CSTMS_PST_ID" ).append("\n"); 
		query.append("		, NVL(CN.EUR_CSTMS_ST_NM, '') CN_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("        , NF.CNT_CD NF_CUST_CNT_CD" ).append("\n"); 
		query.append("        , NF.CUST_SEQ NF_CUST_SEQ" ).append("\n"); 
		query.append("        , NF.CNT_CD||NF.CUST_SEQ NF_CNT_SEQ" ).append("\n"); 
		query.append("        , TRIM(REPLACE(NF.CUST_NM,'@@',CHR(10))) NF_CUST_NM" ).append("\n"); 
		query.append("		, mdm_nf.CUST_LGL_ENG_NM NF_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(NF.CUST_ADDR,'@@',CHR(10))) NF_CUST_ADDR" ).append("\n"); 
		query.append("        , NF.loc_nm  NF_CUST_CTY_NM, NF.STE_CD  NF_CUST_STE_CD" ).append("\n"); 
		query.append("        , NF.loc_ctnt  NF_CSTMS_DECL_CNT_CD, NF.PST_CTNT  NF_CUST_ZIP_ID" ).append("\n"); 
		query.append("        , NF.CNTC_FAX_NO NF_CUST_FAX_NO" ).append("\n"); 
		query.append("        , NF.CNTC_EML NF_CUST_EML" ).append("\n"); 
		query.append("		, NVL(NF.EORI_NO, ' ') NF_EORI_NO" ).append("\n"); 
		query.append("		, NVL(NF.EUR_CSTMS_PST_ID, ' ') NF_EUR_CSTMS_PST_ID" ).append("\n"); 
		query.append("		, NVL(NF.EUR_CSTMS_ST_NM, ' ') NF_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("        , FF.CNT_CD FF_CUST_CNT_CD" ).append("\n"); 
		query.append("        , FF.CUST_SEQ FF_CUST_SEQ" ).append("\n"); 
		query.append("        , FF.CNT_CD||ff.CUST_SEQ FF_CNT_SEQ" ).append("\n"); 
		query.append("        , TRIM(REPLACE(" ).append("\n"); 
		query.append("       			CASE WHEN LENGTH(FF.CUST_NM) = 0 AND LENGTH(FF.CUST_ADDR||FF.CNTC_NM||FF.CNTC_PHN_NO_CTNT||FF.CNTC_FAX_NO||FF.CNTC_EML) = 0 THEN ''" ).append("\n"); 
		query.append("            		 WHEN LENGTH(FF.CUST_NM) = 0 AND LENGTH(FF.CUST_ADDR||FF.CNTC_NM||FF.CNTC_PHN_NO_CTNT||FF.CNTC_FAX_NO||FF.CNTC_EML) > 0 THEN CHR(10)||CHR(10)||FF.CUST_ADDR" ).append("\n"); 
		query.append("            		 WHEN LENGTH(FF.CUST_NM) < 36 AND INSTR(FF.CUST_NM,CHR(10)) = 0 THEN FF.CUST_NM||CHR(10)||CHR(10)||FF.CUST_ADDR" ).append("\n"); 
		query.append("       			ELSE FF.CUST_NM||CHR(10)||FF.CUST_ADDR" ).append("\n"); 
		query.append("       			 END,'@@',CHR(10))) FF_CUST_NM" ).append("\n"); 
		query.append("		, mdm_ff.CUST_LGL_ENG_NM FF_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(FF.CUST_ADDR,'@@',CHR(10))) FF_CUST_ADDR" ).append("\n"); 
		query.append("        , AN.CNT_CD AN_CUST_CNT_CD" ).append("\n"); 
		query.append("        , AN.CUST_SEQ AN_CUST_SEQ" ).append("\n"); 
		query.append("        , AN.CNT_CD||an.CUST_SEQ AN_CNT_SEQ" ).append("\n"); 
		query.append("        , TRIM(REPLACE(" ).append("\n"); 
		query.append("       			CASE WHEN LENGTH(AN.CUST_NM) = 0 AND LENGTH(AN.CUST_ADDR||AN.CNTC_NM||AN.CNTC_PHN_NO_CTNT||AN.CNTC_FAX_NO||AN.CNTC_EML) = 0 THEN ''" ).append("\n"); 
		query.append("            		 WHEN LENGTH(AN.CUST_NM) = 0 AND LENGTH(AN.CUST_ADDR||AN.CNTC_NM||AN.CNTC_PHN_NO_CTNT||AN.CNTC_FAX_NO||AN.CNTC_EML) > 0 THEN CHR(10)||CHR(10)||AN.CUST_ADDR" ).append("\n"); 
		query.append("            		 WHEN LENGTH(AN.CUST_NM) < 36 AND INSTR(AN.CUST_NM,CHR(10)) = 0 THEN AN.CUST_NM||CHR(10)||CHR(10)||AN.CUST_ADDR" ).append("\n"); 
		query.append("       			ELSE AN.CUST_NM||CHR(10)||AN.CUST_ADDR" ).append("\n"); 
		query.append("       			 END,'@@',CHR(10))) AN_CUST_NM" ).append("\n"); 
		query.append("		, MDM_AN.CUST_LGL_ENG_NM AN_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(AN.CUST_ADDR,'@@',CHR(10))) AN_CUST_ADDR" ).append("\n"); 
		query.append("        , ex.CNT_CD EX_CUST_CNT_CD" ).append("\n"); 
		query.append("        , ex.CUST_SEQ EX_CUST_SEQ" ).append("\n"); 
		query.append("        , ex.CUST_NM EX_CUST_NM" ).append("\n"); 
		query.append("        , BR.BRO_NO BR_CUST_CNT_CD" ).append("\n"); 
		query.append("        , TRIM(REPLACE(BR.CUST_NM,'@@',CHR(10))) BR_CUST_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(BR.CUST_ADDR,'@@',CHR(10))) BR_CUST_ADDR" ).append("\n"); 
		query.append("        , (SELECT DECODE(INDIV_CORP_DIV_CD, 'I', 'S', 'C') FROM MDM_CUSTOMER CUST WHERE CUST.CUST_CNT_CD = SH.CNT_CD AND CUST.CUST_SEQ = SH.CUST_SEQ) SH_KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append("	    , MST.KR_CSTMS_CUST_TP_CD AS SH_KR_CSTMS_CUST_TP_CD2" ).append("\n"); 
		query.append("        , CASE WHEN INSTR(UPPER(CN.CUST_NM), 'ORDER') > 0 THEN 'Y' ELSE (SELECT NVL(CUST_TO_ORD_FLG,'N') FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) END CN_CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("        , (SELECT DECODE(CNTR_CUST_TP_CD, 'B', 'S', 'C') FROM MDM_CUSTOMER WHERE CUST_CNT_CD = SH.CNT_CD AND CUST_SEQ = SH.CUST_SEQ) RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("		, CBR.CUST_NM CBR_CUST_NM" ).append("\n"); 
		query.append("		, CBR.FAX_NO1 CBR_FAX_NO1" ).append("\n"); 
		query.append("		, CBR.FAX_NO2 CBR_FAX_NO2" ).append("\n"); 
		query.append("		, CBR.FAX_NO3 CBR_FAX_NO3" ).append("\n"); 
		query.append("		, MST.ORG_CNT_NM" ).append("\n"); 
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
		query.append("  AND MST.XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 

	}
}