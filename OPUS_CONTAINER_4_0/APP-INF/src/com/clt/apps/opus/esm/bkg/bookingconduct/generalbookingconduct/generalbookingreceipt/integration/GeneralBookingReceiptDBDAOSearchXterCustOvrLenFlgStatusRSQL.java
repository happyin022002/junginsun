/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchXterCustOvrLenFlgStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : Moon Hwan Choi
*@LastVersion : 1.0
* 2015.04.27 Moon Hwan Choi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchXterCustOvrLenFlgStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check  Booking customer information length from xtaer booking customer table.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchXterCustOvrLenFlgStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchXterCustOvrLenFlgStatusRSQL").append("\n"); 
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
		query.append("      ,MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("    , TRIM(REPLACE(SH.CUST_NM,'@@',CHR(10))) SH_CUST_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(SH.CUST_ADDR" ).append("\n"); 
		query.append("				 ||decode(trim(SH.CNTC_NM)         , null, '', ' Attn:'||SH.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(SH.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||SH.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("				 ||decode(trim(SH.CNTC_FAX_NO)     , null, '', ' FAX:' ||SH.CNTC_FAX_NO)" ).append("\n"); 
		query.append("				 ||decode(trim(SH.CNTC_EML)        , null, '', ' Mail:'||SH.CNTC_EML),'@@',CHR(10))) SH_CUST_ADDR" ).append("\n"); 
		query.append("    , SH.NM_AND_ADDR_OVFLW_FLG SH_OVFLW_FLG" ).append("\n"); 
		query.append("    , TRIM(REPLACE(CN.CUST_NM,'@@',CHR(10))) CN_CUST_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(CN.CUST_ADDR" ).append("\n"); 
		query.append("				 ||decode(trim(CN.CNTC_NM)         , null, '', ' Attn:'||CN.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(CN.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||CN.CNTC_PHN_NO_CTNT),'@@',CHR(10))) CN_CUST_ADDR" ).append("\n"); 
		query.append("    , CN.NM_AND_ADDR_OVFLW_FLG CN_OVFLW_FLG         " ).append("\n"); 
		query.append("    , TRIM(REPLACE(NF.CUST_NM,'@@',CHR(10))) NF_CUST_NM" ).append("\n"); 
		query.append("        , TRIM(REPLACE(NF.CUST_ADDR" ).append("\n"); 
		query.append("				 ||decode(trim(NF.CNTC_NM)         , null, '', ' Attn:'||NF.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(NF.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||NF.CNTC_PHN_NO_CTNT),'@@',CHR(10))) NF_CUST_ADDR" ).append("\n"); 
		query.append("    , NF.NM_AND_ADDR_OVFLW_FLG NF_OVFLW_FLG         " ).append("\n"); 
		query.append("     , TRIM(REPLACE(FF.CUST_NM||CHR(10)			 " ).append("\n"); 
		query.append("				 ||FF.CUST_ADDR" ).append("\n"); 
		query.append("				 ||decode(trim(FF.CNTC_NM)         , null, '', ' Attn:'||FF.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(FF.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||FF.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("				 ||decode(trim(FF.CNTC_FAX_NO)     , null, '', ' FAX:' ||FF.CNTC_FAX_NO)" ).append("\n"); 
		query.append("				 ||decode(trim(FF.CNTC_EML)        , null, '', ' Mail:'||FF.CNTC_EML),'@@',CHR(10))) FF_CUST_NM" ).append("\n"); 
		query.append("    , FF.NM_AND_ADDR_OVFLW_FLG FF_OVFLW_FLG         " ).append("\n"); 
		query.append("     , TRIM(REPLACE(AN.CUST_NM||CHR(10)" ).append("\n"); 
		query.append("				 ||AN.CUST_ADDR" ).append("\n"); 
		query.append("				 ||decode(trim(AN.CNTC_NM)         , null, '', ' Attn:'||AN.CNTC_NM)" ).append("\n"); 
		query.append("				 ||decode(trim(AN.CNTC_PHN_NO_CTNT), null, '', ' TEL:' ||AN.CNTC_PHN_NO_CTNT)" ).append("\n"); 
		query.append("				 ||decode(trim(AN.CNTC_FAX_NO)     , null, '', ' FAX:' ||AN.CNTC_FAX_NO)" ).append("\n"); 
		query.append("				 ||decode(trim(AN.CNTC_EML)        , null, '', ' Mail:'||AN.CNTC_EML),'@@',CHR(10))) AN_CUST_NM" ).append("\n"); 
		query.append("    , AN.NM_AND_ADDR_OVFLW_FLG AN_OVFLW_FLG         " ).append("\n"); 
		query.append("        , ex.CUST_NM EX_CUST_NM" ).append("\n"); 
		query.append("    , EX.NM_AND_ADDR_OVFLW_FLG EX_OVFLW_FLG     " ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("        , BKG_XTER_CUST SH" ).append("\n"); 
		query.append("        , BKG_XTER_CUST CN" ).append("\n"); 
		query.append("        , BKG_XTER_CUST NF" ).append("\n"); 
		query.append("        , BKG_XTER_CUST FF" ).append("\n"); 
		query.append("        , BKG_XTER_CUST AN" ).append("\n"); 
		query.append("        , BKG_XTER_CUST EX" ).append("\n"); 
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
		query.append("  AND MST.BKG_NO        = @[bkg_no] " ).append("\n"); 
		query.append("  AND MST.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("  AND MST.UPLD_GDT = (SELECT MAX(BXRM.UPLD_GDT) " ).append("\n"); 
		query.append("                        FROM BKG_XTER_RQST_MST BXRM" ).append("\n"); 
		query.append("                       WHERE BXRM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                         AND BXRM.BKG_UPLD_STS_CD = 'F')" ).append("\n"); 

	}
}