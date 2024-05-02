/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterCustInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.11.02 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterCustInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 customer 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterCustInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterCustInterfaceRSQL").append("\n"); 
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
		query.append("SELECT  SH.CNT_CD SH_CUST_CNT_CD" ).append("\n"); 
		query.append("        , SH.CUST_SEQ SH_CUST_SEQ" ).append("\n"); 
		query.append("        , TRIM(REPLACE(REPLACE(REPLACE(REPLACE(SH.CUST_NM, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10)),'@@',CHR(13)||CHR(10))) SH_CUST_NM" ).append("\n"); 
		query.append("		, MDM_SH.CUST_LGL_ENG_NM SH_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(REPLACE(REPLACE(REPLACE(SH.CUST_ADDR, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))" ).append("\n"); 
		query.append("				 ||decode(trim(SH.CNTC_NM)         , null, '', ' Attn:'||SH.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(SH.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||SH.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("				 ||decode(trim(SH.CNTC_FAX_NO)     , null, '', ' FAX:' ||SH.CNTC_FAX_NO)" ).append("\n"); 
		query.append("				 ||decode(trim(SH.CNTC_EML)        , null, '', ' Mail:'||SH.CNTC_EML),'@@',CHR(13)||CHR(10))) SH_CUST_ADDR" ).append("\n"); 
		query.append("        , SH.LOC_NM SH_CUST_CTY_NM" ).append("\n"); 
		query.append("        , SH.STE_CD SH_CUST_STE_CD" ).append("\n"); 
		query.append("		, NVL(SH.LOC_CTNT,SH.CNT_CD) SH_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("        , SH.PST_CTNT SH_CUST_ZIP_ID" ).append("\n"); 
		query.append("		, NVL(SH.EORI_NO, '') SH_EORI_NO" ).append("\n"); 
		query.append("		, NVL(SH.EUR_CSTMS_ST_NM, '') SH_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("        , MDM_SH.RVIS_CNTR_CUST_TP_CD  SH_CUST_TP" ).append("\n"); 
		query.append("        , 'Y' SH_ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , NVL(CN.CNT_CD, SUBSTR(MST.DEL_CD,1,2)) CN_CUST_CNT_CD" ).append("\n"); 
		query.append("        , CN.CUST_SEQ CN_CUST_SEQ" ).append("\n"); 
		query.append("        , CN.CNT_CD||cn.CUST_SEQ CN_CNT_SEQ" ).append("\n"); 
		query.append("        , TRIM(REPLACE(REPLACE(REPLACE(REPLACE(CN.CUST_NM, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10)),'@@',CHR(13)||CHR(10))) CN_CUST_NM" ).append("\n"); 
		query.append("		, MDM_CN.CUST_LGL_ENG_NM CN_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(REPLACE(REPLACE(REPLACE(CN.CUST_ADDR, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))" ).append("\n"); 
		query.append("				 ||decode(trim(CN.CNTC_NM)         , null, '', ' Attn:'||CN.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(CN.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||CN.CNTC_PHN_NO_CTNT),'@@',CHR(13)||CHR(10))) CN_CUST_ADDR" ).append("\n"); 
		query.append("        , CN.LOC_NM  CN_CUST_CTY_NM, CN.STE_CD  CN_CUST_STE_CD" ).append("\n"); 
		query.append("        , CN.CNTC_FAX_NO CN_CUST_FAX_NO" ).append("\n"); 
		query.append("        , CN.CNTC_EML CN_CUST_EML" ).append("\n"); 
		query.append("        , CN.LOC_CTNT  CN_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("        , CN.PST_CTNT  CN_CUST_ZIP_ID" ).append("\n"); 
		query.append("		, NVL(CN.EORI_NO, '') CN_EORI_NO" ).append("\n"); 
		query.append("		, NVL(CN.EUR_CSTMS_ST_NM, '') CN_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("        , MDM_CN.RVIS_CNTR_CUST_TP_CD CN_CUST_TP" ).append("\n"); 
		query.append("        , 'Y' CN_ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , NVL(NF.CNT_CD, SUBSTR(MST.DEL_CD,1,2)) NF_CUST_CNT_CD" ).append("\n"); 
		query.append("        , NF.CUST_SEQ NF_CUST_SEQ" ).append("\n"); 
		query.append("        , TRIM(REPLACE(REPLACE(REPLACE(REPLACE(NF.CUST_NM, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10)),'@@',CHR(13)||CHR(10))) NF_CUST_NM" ).append("\n"); 
		query.append("		, MDM_NF.CUST_LGL_ENG_NM NF_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(REPLACE(REPLACE(REPLACE(NF.CUST_ADDR, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))" ).append("\n"); 
		query.append("				 ||decode(trim(NF.CNTC_NM)         , null, '', ' Attn:'||NF.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(NF.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||NF.CNTC_PHN_NO_CTNT),'@@',CHR(13)||CHR(10))) NF_CUST_ADDR" ).append("\n"); 
		query.append("        , NF.loc_nm  NF_CUST_CTY_NM" ).append("\n"); 
		query.append("        , NF.STE_CD  NF_CUST_STE_CD" ).append("\n"); 
		query.append("        , NF.loc_ctnt  NF_CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("        , NF.PST_CTNT  NF_CUST_ZIP_ID" ).append("\n"); 
		query.append("        , NF.CNTC_FAX_NO NF_CUST_FAX_NO" ).append("\n"); 
		query.append("        , NF.CNTC_EML NF_CUST_EML" ).append("\n"); 
		query.append("		, NVL(NF.EORI_NO, '') NF_EORI_NO" ).append("\n"); 
		query.append("		, NVL(NF.EUR_CSTMS_ST_NM, '') NF_EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("        , MDM_NF.RVIS_CNTR_CUST_TP_CD NF_CUST_TP" ).append("\n"); 
		query.append("        , 'Y' NF_ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , FF.CNT_CD FF_CUST_CNT_CD" ).append("\n"); 
		query.append("        , FF.CUST_SEQ FF_CUST_SEQ" ).append("\n"); 
		query.append("        , DECODE(MST.DOC_TP_CD,'S',REPLACE(REPLACE(REPLACE(FF.CUST_NM, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))," ).append("\n"); 
		query.append("                TRIM(REPLACE(REPLACE(REPLACE(REPLACE(FF.CUST_NM, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))||CHR(13)||CHR(10)			 " ).append("\n"); 
		query.append("				 ||REPLACE(REPLACE(REPLACE(FF.CUST_ADDR, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))" ).append("\n"); 
		query.append("				 ||decode(trim(FF.CNTC_NM)         , null, '', ' Attn:'||FF.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(FF.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||FF.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("				 ||decode(trim(FF.CNTC_FAX_NO)     , null, '', ' FAX:' ||FF.CNTC_FAX_NO)" ).append("\n"); 
		query.append("				 ||decode(trim(FF.CNTC_EML)        , null, '', ' Mail:'||FF.CNTC_EML),'@@',CHR(13)||CHR(10)))) FF_CUST_NM" ).append("\n"); 
		query.append("		, MDM_FF.CUST_LGL_ENG_NM FF_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(FF.CUST_ADDR,'@@',CHR(13)||CHR(10))) FF_CUST_ADDR" ).append("\n"); 
		query.append("        , MDM_FF.RVIS_CNTR_CUST_TP_CD  FF_CUST_TP" ).append("\n"); 
		query.append("        , 'Y' FF_ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , AN.CNT_CD AN_CUST_CNT_CD" ).append("\n"); 
		query.append("        , AN.CUST_SEQ AN_CUST_SEQ" ).append("\n"); 
		query.append("        , DECODE(MST.DOC_TP_CD,'S',REPLACE(REPLACE(REPLACE(AN.CUST_NM, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))," ).append("\n"); 
		query.append("                TRIM(REPLACE(REPLACE(REPLACE(REPLACE(AN.CUST_NM, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))||CHR(13)||CHR(10)" ).append("\n"); 
		query.append("				 ||REPLACE(REPLACE(REPLACE(AN.CUST_ADDR, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))" ).append("\n"); 
		query.append("				 ||decode(trim(AN.CNTC_NM)         , null, '', ' Attn:'||AN.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(AN.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||AN.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("				 ||decode(trim(AN.CNTC_FAX_NO)     , null, '', ' FAX:' ||AN.CNTC_FAX_NO)" ).append("\n"); 
		query.append("				 ||decode(trim(AN.CNTC_EML)        , null, '', ' Mail:'||AN.CNTC_EML),'@@',CHR(13)||CHR(10)))) AN_CUST_NM" ).append("\n"); 
		query.append("		, MDM_AN.CUST_LGL_ENG_NM AN_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(AN.CUST_ADDR,'@@',CHR(13)||CHR(10))) AN_CUST_ADDR" ).append("\n"); 
		query.append("        , MDM_AN.RVIS_CNTR_CUST_TP_CD  AN_CUST_TP" ).append("\n"); 
		query.append("        , 'Y' AN_ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , EX.CNT_CD EX_CUST_CNT_CD" ).append("\n"); 
		query.append("        , EX.CUST_SEQ EX_CUST_SEQ" ).append("\n"); 
		query.append("        , REPLACE(REPLACE(REPLACE(EX.CUST_NM, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))||(SELECT CHR(13)||CHR(10)||REPLACE(REPLACE(REPLACE(EX.CUST_ADDR, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))||CHR(13)||CHR(10)||EX.LOC_NM||CHR(13)||CHR(10)||EX.PST_CTNT " ).append("\n"); 
		query.append("                         FROM BKG_HRD_CDG_CTNT BHC " ).append("\n"); 
		query.append("                        WHERE BHC.HRD_CDG_ID = 'EBKG_HND_OFC' " ).append("\n"); 
		query.append("                          AND BHC.ATTR_CTNT1 = EX.CNT_CD " ).append("\n"); 
		query.append("                          AND BHC.ATTR_CTNT2 = EX.CUST_SEQ" ).append("\n"); 
		query.append("                          AND ROWNUM = 1) EX_CUST_NM" ).append("\n"); 
		query.append("        , MDM_EX.CUST_LGL_ENG_NM EX_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        , 'Y' EX_ADDR_PRN_FLG" ).append("\n"); 
		query.append("        , BR.BRO_NO BR_CUST_CNT_CD" ).append("\n"); 
		query.append("        , TRIM(REPLACE(REPLACE(REPLACE(REPLACE(BR.CUST_NM, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10)),'@@',CHR(13)||CHR(10))) BR_CUST_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(REPLACE(REPLACE(REPLACE(BR.CUST_ADDR, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10))" ).append("\n"); 
		query.append("				 ||decode(trim(BR.CNTC_NM)         , null, '', ' Attn:'||BR.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(BR.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||BR.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("				 ||decode(trim(BR.CNTC_FAX_NO)     , null, '', ' FAX:' ||BR.CNTC_FAX_NO)" ).append("\n"); 
		query.append("				 ||decode(trim(BR.CNTC_EML)        , null, '', ' Mail:'||BR.CNTC_EML),'@@',CHR(13)||CHR(10))) BR_CUST_ADDR" ).append("\n"); 
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
		query.append("  AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 

	}
}