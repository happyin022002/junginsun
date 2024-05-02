/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchThirdPartyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchThirdPartyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchThirdPartyInfo
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchThirdPartyInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trd_party_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sheet_set_count",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchThirdPartyInfoRSQL").append("\n"); 
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
		query.append("#if (${s_h_vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("SELECT   B.ENG_ADDR||'\n'||' Tel: '||'' ENG_ADDR" ).append("\n"); 
		query.append("	   , B.ZIP_CD" ).append("\n"); 
		query.append("       , '' AS CTY_NM" ).append("\n"); 
		query.append("	   , A.VNDR_CNT_CD" ).append("\n"); 
		query.append("	   , A.VNDR_SEQ" ).append("\n"); 
		query.append("	   , '' AS CUST_CNT_CD" ).append("\n"); 
		query.append("	   , '' AS CUST_SEQ" ).append("\n"); 
		query.append("	   , LPAD(TO_CHAR(A.VNDR_SEQ),6,'0')	TRD_PARTY_CODE" ).append("\n"); 
		query.append("    #if (${s_curr_cd} != '')" ).append("\n"); 
		query.append("	   , @[s_curr_cd] AS CURR_CD" ).append("\n"); 
		query.append("	   , ( SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[s_curr_cd] ) AS PRCS_CNT" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("	   , A.CFM_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("	   , ( SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = A.CFM_CURR_CD ) AS PRCS_CNT" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	   , NULL AS FAX_NO" ).append("\n"); 
		query.append("	   , NULL AS PHN_NO" ).append("\n"); 
		query.append("	   , B.ENG_ADDR AS VNDR_CUST_ADDR" ).append("\n"); 
		query.append("	   , B.VNDR_LGL_ENG_NM AS VNDR_CUST_NM" ).append("\n"); 
		query.append("	   , TPB_GET_HNDL_OFC_FNC('R',@[user_ofc_cd]) AS RHQ_CD" ).append("\n"); 
		query.append("	   , NULL AS VNDR_CUST_EML" ).append("\n"); 
		query.append("	   , @[bil_to_loc_div_cd] AS BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append("	   , @[s_sheet_set_count] AS SHEET_SET_COUNT" ).append("\n"); 
		query.append("	   , @[vat_xch_rt] AS VAT_XCH_RT" ).append("\n"); 
		query.append("	   , '' AS VNDR_CUST_ADDR2" ).append("\n"); 
		query.append("	   , ( SELECT TAX_ID FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ ) AS RGST_NO" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   CASE WHEN L.CNT_CD = 'IN' THEN '999' ELSE '0' END" ).append("\n"); 
		query.append("           FROM     MDM_LOCATION L" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("           AND      ROWNUM = 1" ).append("\n"); 
		query.append("         ) AS IDA_TAX_SEQ" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   NVL(S.IDA_STE_CD, S.STE_CD)" ).append("\n"); 
		query.append("           FROM     MDM_STATE S" ).append("\n"); 
		query.append("                  , MDM_LOCATION L" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      S.CNT_CD = L.CNT_CD" ).append("\n"); 
		query.append("           AND      S.STE_CD = L.STE_CD" ).append("\n"); 
		query.append("           AND      L.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("         ) AS STE_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   S.STE_NM" ).append("\n"); 
		query.append("           FROM     MDM_STATE S" ).append("\n"); 
		query.append("                  , MDM_LOCATION L" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      S.CNT_CD = L.CNT_CD" ).append("\n"); 
		query.append("           AND      S.STE_CD = L.STE_CD" ).append("\n"); 
		query.append("           AND      L.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("         ) AS IDA_STE_NM" ).append("\n"); 
		query.append("       , I.IDA_CGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_SGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_IGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_UGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_CGST_RTO + I.IDA_SGST_RTO + I.IDA_IGST_RTO + I.IDA_UGST_RTO AS IDA_TOT_GST_RTO" ).append("\n"); 
		query.append("       , CASE WHEN B.IDA_GST_RGST_NO IS NULL THEN 'N' ELSE 'Y' END AS IDA_GST_RGST_NO_FLG" ).append("\n"); 
		query.append("       , B.IDA_SPCL_ECN_ZN_UT_FLG" ).append("\n"); 
		query.append("       , B.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("       , SC.IDA_GST_RGST_NO AS IDA_OFC_GST_RGST_NO" ).append("\n"); 
		query.append("       , SC.IDA_PAN_NO" ).append("\n"); 
		query.append("       , ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'IDA_TAX_INFO' ) AS IDA_BANK_ACCT_NO" ).append("\n"); 
		query.append("       , ( SELECT ATTR_CTNT2 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'IDA_TAX_INFO' ) AS IDA_IFSC_CD" ).append("\n"); 
		query.append("FROM     TPB_OTS_DTL A" ).append("\n"); 
		query.append("       , MDM_VENDOR B" ).append("\n"); 
		query.append("       , MDM_ORGANIZATION O" ).append("\n"); 
		query.append("       , MDM_CUSTOMER SC" ).append("\n"); 
		query.append("       , TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( A.OFC_CD, A.VNDR_CUST_DIV_CD, A.CUST_CNT_CD, A.CUST_SEQ, A.VNDR_SEQ, NULL ) )" ).append("\n"); 
		query.append("                                       , (" ).append("\n"); 
		query.append("                                           SELECT   NVL(TT.IDA_SAC_CD, MC.IDA_SAC_CD)" ).append("\n"); 
		query.append("                                           FROM     TPB_N3RD_PTY_BIL_TP TT" ).append("\n"); 
		query.append("                                                  , MDM_CHARGE MC" ).append("\n"); 
		query.append("                                           WHERE    1 = 1" ).append("\n"); 
		query.append("                                           AND      TT.CHG_CD = MC.CHG_CD(+)" ).append("\n"); 
		query.append("                                           AND      TT.N3PTY_BIL_TP_CD = A.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         ) I" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND      A.OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("AND      O.REP_CUST_CNT_CD = SC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND      O.REP_CUST_SEQ = SC.CUST_SEQ" ).append("\n"); 
		query.append("AND      A.N3PTY_NO IN" ).append("\n"); 
		query.append("         ( NULL" ).append("\n"); 
		query.append("    #if (${s_dao_n3pty_no} != '')" ).append("\n"); 
		query.append("	  , $s_dao_n3pty_no" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("AND      A.VNDR_SEQ = @[s_trd_party_code]" ).append("\n"); 
		query.append("AND      ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${s_h_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   B.BZET_ADDR||'\n'||' Tel: '||C.PHN_NO ENG_ADDR" ).append("\n"); 
		query.append("	   , B.ZIP_CD" ).append("\n"); 
		query.append("       , B.CTY_NM" ).append("\n"); 
		query.append("	   , '' AS VNDR_CNT_CD" ).append("\n"); 
		query.append("	   , '' AS VNDR_SEQ" ).append("\n"); 
		query.append("	   , A.CUST_CNT_CD" ).append("\n"); 
		query.append("	   , A.CUST_SEQ" ).append("\n"); 
		query.append("	   , A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0') AS TRD_PARTY_CODE" ).append("\n"); 
		query.append("    #if (${s_curr_cd} != '')" ).append("\n"); 
		query.append("	   , @[s_curr_cd] AS CURR_CD" ).append("\n"); 
		query.append("	   , ( SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[s_curr_cd] ) AS PRCS_CNT" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("	   , A.CFM_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("	   , ( SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = A.CFM_CURR_CD ) AS PRCS_CNT" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	   , C.FAX_NO												" ).append("\n"); 
		query.append("	   , C.PHN_NO" ).append("\n"); 
		query.append("	   , B.BZET_ADDR AS VNDR_CUST_ADDR" ).append("\n"); 
		query.append("	   , D.CUST_LGL_ENG_NM AS VNDR_CUST_NM" ).append("\n"); 
		query.append("	   , TPB_GET_HNDL_OFC_FNC('R',@[user_ofc_cd]) AS RHQ_CD" ).append("\n"); 
		query.append("	   , C.CUST_EML	VNDR_CUST_EML" ).append("\n"); 
		query.append("	   , @[bil_to_loc_div_cd] AS BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append("	   , @[s_sheet_set_count] AS SHEET_SET_COUNT" ).append("\n"); 
		query.append("	   , @[vat_xch_rt] AS VAT_XCH_RT" ).append("\n"); 
		query.append("	   , (" ).append("\n"); 
		query.append("           SELECT   RTRIM(LOCL_ADDR1)||' '||RTRIM(LOCL_ADDR2)||' '||RTRIM(LOCL_ADDR3)||' '||RTRIM(LOCL_ADDR4) VNDR_CUST_ADDR2" ).append("\n"); 
		query.append("  	       FROM     MDM_CR_CUST" ).append("\n"); 
		query.append("	       WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      CUST_CNT_CD||CUST_SEQ = @[s_trd_party_code]" ).append("\n"); 
		query.append("         ) AS VNDR_CUST_ADDR2" ).append("\n"); 
		query.append("	   , ( SELECT CUST_RGST_NO FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.CUST_CNT_CD AND CUST_SEQ = A.CUST_SEQ ) RGST_NO" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   CASE WHEN L.CNT_CD = 'IN' THEN '999' ELSE '0' END" ).append("\n"); 
		query.append("           FROM     MDM_LOCATION L" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("           AND      ROWNUM = 1" ).append("\n"); 
		query.append("         ) AS IDA_TAX_SEQ" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   NVL(S.IDA_STE_CD, S.STE_CD)" ).append("\n"); 
		query.append("           FROM     MDM_STATE S" ).append("\n"); 
		query.append("                  , MDM_LOCATION L" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      S.CNT_CD = L.CNT_CD" ).append("\n"); 
		query.append("           AND      S.STE_CD = L.STE_CD" ).append("\n"); 
		query.append("           AND      L.LOC_CD = D.LOC_CD" ).append("\n"); 
		query.append("         ) AS STE_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   S.STE_NM" ).append("\n"); 
		query.append("           FROM     MDM_STATE S" ).append("\n"); 
		query.append("                  , MDM_LOCATION L" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      S.CNT_CD = L.CNT_CD" ).append("\n"); 
		query.append("           AND      S.STE_CD = L.STE_CD" ).append("\n"); 
		query.append("           AND      L.LOC_CD = D.LOC_CD" ).append("\n"); 
		query.append("         ) AS IDA_STE_NM" ).append("\n"); 
		query.append("       , I.IDA_CGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_SGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_IGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_UGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_CGST_RTO + I.IDA_SGST_RTO + I.IDA_IGST_RTO + I.IDA_UGST_RTO AS IDA_TOT_GST_RTO" ).append("\n"); 
		query.append("       , CASE WHEN D.IDA_GST_RGST_NO IS NULL THEN 'N' ELSE 'Y' END AS IDA_GST_RGST_NO_FLG" ).append("\n"); 
		query.append("       , D.IDA_SPCL_ECN_ZN_UT_FLG" ).append("\n"); 
		query.append("       , D.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("       , SC.IDA_GST_RGST_NO AS IDA_OFC_GST_RGST_NO" ).append("\n"); 
		query.append("       , SC.IDA_PAN_NO" ).append("\n"); 
		query.append("       , ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'IDA_TAX_INFO' ) AS IDA_BANK_ACCT_NO" ).append("\n"); 
		query.append("       , ( SELECT ATTR_CTNT2 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'IDA_TAX_INFO' ) AS IDA_IFSC_CD" ).append("\n"); 
		query.append("FROM     TPB_OTS_DTL A" ).append("\n"); 
		query.append("	   , MDM_CUST_ADDR B" ).append("\n"); 
		query.append("	   , MDM_CUST_CNTC_PNT C" ).append("\n"); 
		query.append("	   , MDM_CUSTOMER D" ).append("\n"); 
		query.append("       , MDM_ORGANIZATION O" ).append("\n"); 
		query.append("       , MDM_CUSTOMER SC" ).append("\n"); 
		query.append("       , TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( A.OFC_CD, A.VNDR_CUST_DIV_CD, A.CUST_CNT_CD, A.CUST_SEQ, A.VNDR_SEQ, NULL ) )" ).append("\n"); 
		query.append("                                       , (" ).append("\n"); 
		query.append("                                           SELECT   NVL(TT.IDA_SAC_CD, MC.IDA_SAC_CD)" ).append("\n"); 
		query.append("                                           FROM     TPB_N3RD_PTY_BIL_TP TT" ).append("\n"); 
		query.append("                                                  , MDM_CHARGE MC" ).append("\n"); 
		query.append("                                           WHERE    1 = 1" ).append("\n"); 
		query.append("                                           AND      TT.CHG_CD = MC.CHG_CD(+)" ).append("\n"); 
		query.append("                                           AND      TT.N3PTY_BIL_TP_CD = A.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         ) I" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.N3PTY_NO IN" ).append("\n"); 
		query.append("         ( NULL" ).append("\n"); 
		query.append("    #if (${s_dao_n3pty_no} != '')" ).append("\n"); 
		query.append("	  , $s_dao_n3pty_no" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("AND      A.CUST_CNT_CD||A.CUST_SEQ = @[s_trd_party_code]" ).append("\n"); 
		query.append("AND      A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND      A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND      A.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND      A.CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND      A.CUST_CNT_CD = D.CUST_CNT_CD" ).append("\n"); 
		query.append("AND      A.CUST_SEQ = D.CUST_SEQ" ).append("\n"); 
		query.append("AND      A.OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("AND      O.REP_CUST_CNT_CD = SC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND      O.REP_CUST_SEQ = SC.CUST_SEQ" ).append("\n"); 
		query.append("AND      ( B.PRMRY_CHK_FLG = 'Y' OR B.PRMRY_CHK_FLG IS NULL )" ).append("\n"); 
		query.append("AND      ( D.NMD_CUST_FLG IS NULL OR D.NMD_CUST_FLG != 'Y' )" ).append("\n"); 
		query.append("AND      ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}