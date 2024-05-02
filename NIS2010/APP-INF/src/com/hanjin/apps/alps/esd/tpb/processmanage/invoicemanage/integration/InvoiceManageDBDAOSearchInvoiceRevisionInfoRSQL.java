/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchInvoiceRevisionInfoRSQL.java
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

public class InvoiceManageDBDAOSearchInvoiceRevisionInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceRevisionInfo
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchInvoiceRevisionInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_xch_rt_original",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_detail_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("is_france",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_rmd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_detail_ots_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchInvoiceRevisionInfoRSQL").append("\n"); 
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
		query.append("SELECT   A.VNDR_CUST_ADDR||'\n'||' Tel: '||A.PHN_NO	AS ENG_ADDR" ).append("\n"); 
		query.append("       , A.VNDR_CNT_CD" ).append("\n"); 
		query.append("       , A.VNDR_SEQ" ).append("\n"); 
		query.append("       , '' AS CUST_CNT_CD" ).append("\n"); 
		query.append("       , '' AS CUST_SEQ" ).append("\n"); 
		query.append("       , LPAD(TO_CHAR(A.VNDR_SEQ),6,'0') AS TRD_PARTY_CODE" ).append("\n"); 
		query.append("#elseif (${s_h_vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("SELECT   A.VNDR_CUST_ADDR||'\n'||' Tel: '||A.PHN_NO AS ENG_ADDR" ).append("\n"); 
		query.append("       , '' AS VNDR_CNT_CD" ).append("\n"); 
		query.append("       , '' AS VNDR_SEQ" ).append("\n"); 
		query.append("       , A.CUST_CNT_CD" ).append("\n"); 
		query.append("       , A.CUST_SEQ" ).append("\n"); 
		query.append("       , A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0') AS TRD_PARTY_CODE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_curr_cd} == '')" ).append("\n"); 
		query.append("       , A.CURR_CD" ).append("\n"); 
		query.append("       , ( SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = A.CURR_CD ) AS PRCS_CNT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       , @[s_curr_cd] CURR_CD" ).append("\n"); 
		query.append("       , (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[s_curr_cd]) AS PRCS_CNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       , A.FAX_NO" ).append("\n"); 
		query.append("       , A.PHN_NO" ).append("\n"); 
		query.append("       , A.VNDR_CUST_ADDR" ).append("\n"); 
		query.append("       , A.VNDR_CUST_NM" ).append("\n"); 
		query.append("       , A.RGST_NO" ).append("\n"); 
		query.append("       , A.VNDR_CUST_REF_RMK" ).append("\n"); 
		query.append("       , A.BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append("       , A.CLT_AGN_RMK" ).append("\n"); 
		query.append("       , A.CLT_AGN_FLG" ).append("\n"); 
		query.append("       , A.N3PTY_INV_STS_CD" ).append("\n"); 
		query.append("       , A.INV_DESC" ).append("\n"); 
		query.append("       , A.VNDR_CUST_EML" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   DECODE(SUBSTR(LOC_CD,1,2),'US',TO_CHAR(SYSDATE+7,'YYYY-MM-DD'),'CA',TO_CHAR(SYSDATE+7,'YYYY-MM-DD'),'MX',TO_CHAR(SYSDATE+7,'YYYY-MM-DD'),TO_CHAR(A.RCV_DUE_DT,'YYYY-MM-DD'))" ).append("\n"); 
		query.append("           FROM     MDM_ORGANIZATION" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("         ) AS RCV_DUE_DT" ).append("\n"); 
		query.append("       , DECODE(SUBSTR(A.N3PTY_INV_RVIS_CD,1,1),'4','Y','N') AS N3PTY_INV_RMD_YN" ).append("\n"); 
		query.append("       , A.N3PTY_INV_RVIS_CD AS N3PTY_INV_RMD_NM" ).append("\n"); 
		query.append("       , A.N3PTY_INV_RVIS_SEQ AS HIS_SEQ /*Correction에서 호출시는 null로 처리함.*/ " ).append("\n"); 
		query.append("       , 'Y' AS FINAL_FLG" ).append("\n"); 
		query.append("       , @[s_detail_n3pty_no] AS DETAIL_N3PTY_NO" ).append("\n"); 
		query.append("       , @[s_detail_ots_sts_cd] AS DETAIL_OTS_STS_CD" ).append("\n"); 
		query.append("       , A.MON_XCH_RT" ).append("\n"); 
		query.append("       , NVL(A.NET_AMT,0) AS NET_AMT" ).append("\n"); 
		query.append("       , NVL(A.VAT_AMT,0) AS VAT_AMT" ).append("\n"); 
		query.append("       , NVL(A.ADD_AMT,0) AS ADD_AMT" ).append("\n"); 
		query.append("       , NVL(A.DDCT_AMT,0) AS DDCT_AMT" ).append("\n"); 
		query.append("       , A.INV_AMT AS TOTAL_AMT" ).append("\n"); 
		query.append("       , @[vat_xch_rt_original] AS VAT_XCH_RT_ORIGINAL" ).append("\n"); 
		query.append("       , @[is_france] AS FRANCE" ).append("\n"); 
		query.append("       , B.LNK_N3PTY_INV_NO" ).append("\n"); 
		query.append("       , A.CTY_NM" ).append("\n"); 
		query.append("       , CASE WHEN A.IDA_TAX_SEQ > 0 THEN (" ).append("\n"); 
		query.append("                                            SELECT   S.IDA_STE_CD" ).append("\n"); 
		query.append("                                            FROM     MDM_STATE S" ).append("\n"); 
		query.append("                                                   , MDM_LOCATION L" ).append("\n"); 
		query.append("                                            WHERE    1 = 1" ).append("\n"); 
		query.append("                                            AND      S.CNT_CD = L.CNT_CD" ).append("\n"); 
		query.append("                                            AND      S.STE_CD = L.STE_CD" ).append("\n"); 
		query.append("                                            AND      L.LOC_CD = CASE WHEN A.VNDR_CUST_DIV_CD = 'C' THEN CC.LOC_CD ELSE V.LOC_CD END" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("              ELSE A.STE_CD" ).append("\n"); 
		query.append("         END AS STE_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   S.STE_NM" ).append("\n"); 
		query.append("           FROM     MDM_STATE S" ).append("\n"); 
		query.append("                  , MDM_LOCATION L" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      S.CNT_CD = L.CNT_CD" ).append("\n"); 
		query.append("           AND      S.STE_CD = L.STE_CD" ).append("\n"); 
		query.append("           AND      L.LOC_CD = CASE WHEN A.VNDR_CUST_DIV_CD = 'C' THEN CC.LOC_CD ELSE V.LOC_CD END" ).append("\n"); 
		query.append("         ) AS STE_NM" ).append("\n"); 
		query.append("       , O.LOC_CD" ).append("\n"); 
		query.append("       , ( SELECT LOC_NM FROM MDM_LOCATION L WHERE L.LOC_CD = O.LOC_CD AND ROWNUM = 1 ) AS LOC_NM" ).append("\n"); 
		query.append("       , CASE WHEN A.VNDR_CUST_DIV_CD = 'C' THEN CC.IDA_GST_RGST_NO ELSE V.IDA_GST_RGST_NO END AS IDA_GST_RGST_NO" ).append("\n"); 
		query.append("       , CASE WHEN CC.IDA_GST_RGST_NO IS NULL AND V.IDA_GST_RGST_NO IS NULL THEN 'N' ELSE 'Y' END AS IDA_GST_RGST_NO_FLG" ).append("\n"); 
		query.append("       , CASE WHEN A.VNDR_CUST_DIV_CD = 'C' THEN NVL(CC.IDA_SPCL_ECN_ZN_UT_FLG,'N') ELSE NVL(V.IDA_SPCL_ECN_ZN_UT_FLG,'N') END AS IDA_SPCL_ECN_ZN_UT_FLG" ).append("\n"); 
		query.append("       , A.ZIP_CD" ).append("\n"); 
		query.append("       , A.USR_INP_CTNT1" ).append("\n"); 
		query.append("       , A.USR_INP_CTNT2" ).append("\n"); 
		query.append("       , B.OFC_CD AS INV_ISS_OFC_CD" ).append("\n"); 
		query.append("       , DECODE(A.N3PTY_INV_RVIS_CD,A.N3PTY_INV_RVIS_CD, DECODE(SUBSTRB(A.N3PTY_INV_RVIS_CD,1,1),'O','Y','R','Y','N'),'N') AS SAME_VERSION_YN" ).append("\n"); 
		query.append("       , TPB_GET_HNDL_OFC_FNC('R',B.OFC_CD) AS INV_ISS_RHQ_CD" ).append("\n"); 
		query.append("       , CASE WHEN A.CLT_AGN_FLG IS NULL OR A.CLT_AGN_FLG != 'N' THEN 'N'" ).append("\n"); 
		query.append("              WHEN A.N3PTY_INV_STS_CD!='N' THEN 'N'" ).append("\n"); 
		query.append("              WHEN A.N3PTY_DELT_TP_CD!='N' THEN 'N'" ).append("\n"); 
		query.append("              WHEN SUBSTRB(A.N3PTY_INV_RVIS_CD,1,1)!='O' AND SUBSTRB(A.N3PTY_INV_RVIS_CD,1,1)!='R'THEN 'N'" ).append("\n"); 
		query.append("              WHEN (" ).append("\n"); 
		query.append("                     SELECT   SIGN(NVL(MAX(IT.N3PTY_INV_RVIS_SEQ),0) - A.N3PTY_INV_RVIS_SEQ)" ).append("\n"); 
		query.append("                     FROM     TPB_INV_RVIS IT" ).append("\n"); 
		query.append("                     WHERE    1 = 1" ).append("\n"); 
		query.append("                     AND      IT.N3PTY_INV_NO = A.N3PTY_INV_NO" ).append("\n"); 
		query.append("                     AND      IT.N3PTY_INV_RVIS_SEQ >= A.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("                   ) = 0 THEN 'Y'" ).append("\n"); 
		query.append("              ELSE 'N'" ).append("\n"); 
		query.append("         END AS ERPIF_YN" ).append("\n"); 
		query.append("       , TO_CHAR(A.IDA_TAX_SEQ) AS IDA_TAX_SEQ" ).append("\n"); 
		query.append("       , T.EXPN_TAX" ).append("\n"); 
		query.append("       , T.EDU_TAX" ).append("\n"); 
		query.append("       , T.HIGH_EDU_TAX" ).append("\n"); 
		query.append("       , T.TAX_RGST_NO" ).append("\n"); 
		query.append("       , T.SVC_CATE_RMK" ).append("\n"); 
		query.append("       , T.PMNT_ACCT_NO" ).append("\n"); 
		query.append("       , T.LOCL_TAX_RT" ).append("\n"); 
		query.append("       , NVL(T.N2ND_LOCL_TAX_RT,0) AS N2ND_LOCL_TAX_RT" ).append("\n"); 
		query.append("       , TO_CHAR(A.NET_AMT + A.ADD_AMT - A.DDCT_AMT, '9999999999999990.99' ) AS EXPN_TOTAL_AMT" ).append("\n"); 
		query.append("       , TO_CHAR( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * T.EXPN_TAX / 100, 2 ), '9999999999999990.99' ) AS TOT_EXPN_TAX" ).append("\n"); 
		query.append("       , TO_CHAR( ROUND( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * T.EXPN_TAX / 100, 2 ) * T.EDU_TAX / 100, 2 ), '9999999999999990.99' ) AS TOT_EDU_TAX" ).append("\n"); 
		query.append("       , TO_CHAR( ROUND( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * T.EXPN_TAX / 100, 2 ) * T.HIGH_EDU_TAX / 100, 2 ), '9999999999999990.99' ) AS TOT_HIGH_EDU_TAX" ).append("\n"); 
		query.append("       , TO_CHAR( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * T.EXPN_TAX / 100, 2 )" ).append("\n"); 
		query.append("         + ROUND( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * T.EXPN_TAX / 100, 2 ) * T.EDU_TAX / 100, 2 )" ).append("\n"); 
		query.append("         + ROUND( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * T.EXPN_TAX / 100, 2 ) * T.HIGH_EDU_TAX / 100, 2 ), '9999999999999990.99' ) AS TOT_SVC_TAX" ).append("\n"); 
		query.append("       , TO_CHAR( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * NVL(T.LOCL_TAX_RT,0) / 100, 2 ), '9999999999999990.99' ) AS TOT_LOCL_TAX" ).append("\n"); 
		query.append("       , TO_CHAR( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * NVL(T.N2ND_LOCL_TAX_RT,0) / 100, 2 ), '9999999999999990.99' ) AS N2ND_LOCL_TAX" ).append("\n"); 
		query.append("       , NVL(A.LOCL_TAX_AMT,0) AS LOCL_TAX_AMT" ).append("\n"); 
		query.append("       , NVL(A.N2ND_LOCL_TAX_AMT,0) AS N2ND_LOCL_TAX_AMT" ).append("\n"); 
		query.append("       , INV_GET_GST_DIV_CD_FNC( B.OFC_CD, A.VNDR_CUST_DIV_CD, A.CUST_CNT_CD, A.CUST_SEQ, A.VNDR_SEQ, NULL ) AS IDA_TAX_FLG" ).append("\n"); 
		query.append("       , I.IDA_CGST_RTO AS IDA_CGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_SGST_RTO AS IDA_SGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_IGST_RTO AS IDA_IGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_UGST_RTO AS IDA_UGST_RTO" ).append("\n"); 
		query.append("       , I.IDA_CGST_RTO + I.IDA_SGST_RTO + I.IDA_IGST_RTO + I.IDA_UGST_RTO AS IDA_TOT_GST_RTO" ).append("\n"); 
		query.append("       , TO_CHAR( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * I.IDA_CGST_RTO / 100, 2 ), '9999999999999990.99' ) AS IDA_CGST_AMT" ).append("\n"); 
		query.append("       , TO_CHAR( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * I.IDA_SGST_RTO / 100, 2 ), '9999999999999990.99' ) AS IDA_SGST_AMT" ).append("\n"); 
		query.append("       , TO_CHAR( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * I.IDA_IGST_RTO / 100, 2 ), '9999999999999990.99' ) AS IDA_IGST_AMT" ).append("\n"); 
		query.append("       , TO_CHAR( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * I.IDA_UGST_RTO / 100, 2 ), '9999999999999990.99' ) AS IDA_UGST_AMT" ).append("\n"); 
		query.append("       , TO_CHAR( ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * I.IDA_CGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("                + ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * I.IDA_SGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("                + ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * I.IDA_IGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("                + ROUND( ( A.NET_AMT + A.ADD_AMT - A.DDCT_AMT ) * I.IDA_UGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("                , '9999999999999990.99'" ).append("\n"); 
		query.append("         ) AS IDA_TOT_GST_AMT" ).append("\n"); 
		query.append("       , SC.IDA_GST_RGST_NO AS IDA_OFC_GST_RGST_NO" ).append("\n"); 
		query.append("       , SC.IDA_PAN_NO" ).append("\n"); 
		query.append("       , ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'IDA_TAX_INFO' ) AS IDA_BANK_ACCT_NO" ).append("\n"); 
		query.append("       , ( SELECT ATTR_CTNT2 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'IDA_TAX_INFO' ) AS IDA_IFSC_CD" ).append("\n"); 
		query.append("FROM     TPB_INV_RVIS A" ).append("\n"); 
		query.append("       , TPB_INVOICE B" ).append("\n"); 
		query.append("       , TPB_IDA_TAX T" ).append("\n"); 
		query.append("       , MDM_CUSTOMER CC" ).append("\n"); 
		query.append("       , MDM_VENDOR V" ).append("\n"); 
		query.append("       , MDM_ORGANIZATION O" ).append("\n"); 
		query.append("       , MDM_CUSTOMER SC" ).append("\n"); 
		query.append("       , TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.OFC_CD, A.VNDR_CUST_DIV_CD, A.CUST_CNT_CD, A.CUST_SEQ, A.VNDR_SEQ, NULL ) )" ).append("\n"); 
		query.append("                                       , (" ).append("\n"); 
		query.append("                                           SELECT   NVL(TT.IDA_SAC_CD, MC.IDA_SAC_CD)" ).append("\n"); 
		query.append("                                           FROM     TPB_N3RD_PTY_BIL_TP TT" ).append("\n"); 
		query.append("                                                  , TPB_OTS_GRP OG" ).append("\n"); 
		query.append("                                                  , MDM_CHARGE MC" ).append("\n"); 
		query.append("                                           WHERE    1 = 1" ).append("\n"); 
		query.append("                                           AND      TT.N3PTY_BIL_TP_CD = OG.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("                                           AND      TT.CHG_CD = MC.CHG_CD(+)" ).append("\n"); 
		query.append("                                           AND      A.N3PTY_INV_NO = OG.N3PTY_INV_NO" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         ) I" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.N3PTY_INV_NO = B.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND      A.IDA_TAX_SEQ = T.IDA_TAX_SEQ(+)" ).append("\n"); 
		query.append("AND      A.CUST_CNT_CD = CC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND      A.CUST_SEQ = CC.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND      A.VNDR_SEQ = V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND      B.OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("AND      O.REP_CUST_CNT_CD = SC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND      O.REP_CUST_SEQ = SC.CUST_SEQ" ).append("\n"); 
		query.append("AND      A.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND      A.N3PTY_INV_RVIS_SEQ = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("AND      A.N3PTY_INV_RVIS_CD = @[s_n3pty_inv_rmd_cd]" ).append("\n"); 

	}
}