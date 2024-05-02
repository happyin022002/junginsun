/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ExpenseMgtDBDAOsearchInvoiceDetailListByWODataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOsearchInvoiceDetailListByWODataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExpenseMgtDBDAOsearchInvoiceDetailListByWODataRSQL
	  * </pre>
	  */
	public ExpenseMgtDBDAOsearchInvoiceDetailListByWODataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("target_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOsearchInvoiceDetailListByWODataRSQL").append("\n"); 
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
		query.append("SELECT   B.MNR_WO_TP_CD" ).append("\n"); 
		query.append("       , B.EQ_KND_CD" ).append("\n"); 
		query.append("       , B.COST_OFC_CD" ).append("\n"); 
		query.append("       , B.CURR_CD" ).append("\n"); 
		query.append("       , C.MNR_CD_DESC MNR_WO_TP" ).append("\n"); 
		query.append("       , T.ATTR_CTNT2 AS IDA_SAC_CD" ).append("\n"); 
		query.append("       , A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , (A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ) AS WO_NO" ).append("\n"); 
		query.append("       , A.ORD_DTL_SEQ" ).append("\n"); 
		query.append("       , ( SELECT MNR_CD_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = B.EQ_KND_CD||'G' AND MNR_CD_ID = B.COST_CD ) AS COST_CD" ).append("\n"); 
		query.append("       , E.MNR_CD_DESC AS COST_DTL_CD" ).append("\n"); 
		query.append("       , A.MNR_RT_TP_CD" ).append("\n"); 
		query.append("       , A.MNR_EXPN_DTL_NM" ).append("\n"); 
		query.append("       , A.EQ_NO" ).append("\n"); 
		query.append("       , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , A.RQST_REF_NO" ).append("\n"); 
		query.append("       , A.SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append("       , A.SPR_PRT_NO" ).append("\n"); 
		query.append("       , A.SPR_PRT_NM" ).append("\n"); 
		query.append("       , A.YD_CD" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[user_ofc_cd]), 'yyyy-mm-dd') AS WO_DT" ).append("\n"); 
		query.append("       , TO_CHAR(A.RPR_RSLT_DT, 'yyyy-mm-dd') AS RPR_RSLT_DT" ).append("\n"); 
		query.append("       , A.RPR_QTY" ).append("\n"); 
		query.append("       , A.SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("       , A.BZC_AMT" ).append("\n"); 
		query.append("       , A.COST_AMT" ).append("\n"); 
		query.append("       , A.SLS_TAX_AMT" ).append("\n"); 
		query.append("       , A.N3PTY_FLG" ).append("\n"); 
		query.append("       , A.N3PTY_BIL_TTL_AMT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   IDA_CGST_RTO" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_CGST_RTO" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   I.IDA_SGST_RTO" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_SGST_RTO" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   I.IDA_IGST_RTO" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_IGST_RTO" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   I.IDA_UGST_RTO" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_UGST_RTO" ).append("\n"); 
		query.append("#if (${curr_cd}==${target_curr_cd})" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), B.CURR_CD, NVL(@[target_curr_cd],B.CURR_CD), A.COST_AMT) AS INV_AMT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   ROUND( MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), B.CURR_CD, NVL(@[target_curr_cd],B.CURR_CD), A.COST_AMT) * I.IDA_SGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_CGST_AMT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   ROUND( MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), B.CURR_CD, NVL(@[target_curr_cd],B.CURR_CD), A.COST_AMT) * I.IDA_SGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_SGST_AMT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   ROUND( MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), B.CURR_CD, NVL(@[target_curr_cd],B.CURR_CD), A.COST_AMT) * I.IDA_IGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_IGST_AMT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   ROUND( MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), B.CURR_CD, NVL(@[target_curr_cd],B.CURR_CD), A.COST_AMT) * I.IDA_UGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_UGST_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), @[curr_cd], NVL(@[target_curr_cd],@[curr_cd]), A.COST_AMT) AS INV_AMT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   ROUND( MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), @[curr_cd], NVL(@[target_curr_cd],@[curr_cd]), A.COST_AMT) * I.IDA_SGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_CGST_AMT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   ROUND( MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), @[curr_cd], NVL(@[target_curr_cd],@[curr_cd]), A.COST_AMT) * I.IDA_SGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_SGST_AMT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   ROUND( MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), @[curr_cd], NVL(@[target_curr_cd],@[curr_cd]), A.COST_AMT) * I.IDA_IGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_IGST_AMT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   ROUND( MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), @[curr_cd], NVL(@[target_curr_cd],@[curr_cd]), A.COST_AMT) * I.IDA_UGST_RTO / 100, 2 )" ).append("\n"); 
		query.append("           FROM     TABLE( INV_GET_IDA_GST_RTO_FNC( ( INV_GET_GST_DIV_CD_FNC( B.COST_OFC_CD, 'V', NULL, NULL, B.VNDR_SEQ, NULL ) ), T.ATTR_CTNT2 ) ) I" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("         ) AS IDA_UGST_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       , ( SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = NVL(@[target_curr_cd],B.CURR_CD) ) AS DP_PRCS_KNT " ).append("\n"); 
		query.append("       , A.MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("       , A.ORD_DTL_RMK" ).append("\n"); 
		query.append("       , A.INV_NO" ).append("\n"); 
		query.append("       , A.FILE_SEQ" ).append("\n"); 
		query.append("       , A.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , A.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("       , A.PAY_INV_SEQ" ).append("\n"); 
		query.append("       , DECODE(A.PAY_INV_SEQ, '', 'SS','AI') AS MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("       , F.RQST_REF_NO" ).append("\n"); 
		query.append("       , L.CNT_CD" ).append("\n"); 
		query.append("       , A.CRE_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[user_ofc_cd]), 'yyyy-mm-dd') AS CRE_DT" ).append("\n"); 
		query.append("       , A.UPD_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.UPD_DT, @[user_ofc_cd]), 'yyyy-mm-dd') AS UPD_DT" ).append("\n"); 
		query.append("FROM     MNR_ORD_DTL A" ).append("\n"); 
		query.append("       , MNR_ORD_HDR B" ).append("\n"); 
		query.append("       , MNR_GEN_CD C" ).append("\n"); 
		query.append("       , MNR_GEN_CD E" ).append("\n"); 
		query.append("       , MNR_RPR_RQST_HDR F" ).append("\n"); 
		query.append("       , MDM_ORGANIZATION O" ).append("\n"); 
		query.append("       , MDM_LOCATION L" ).append("\n"); 
		query.append("       , MNR_HRD_CDG_CTNT T" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND      A.MNR_ORD_SEQ = B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND      A.MNR_ORD_OFC_CTY_CD = F.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND      A.MNR_ORD_SEQ = F.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("AND      C.PRNT_CD_ID(+) = 'CD00020'" ).append("\n"); 
		query.append("AND      B.MNR_WO_TP_CD = C.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND      E.PRNT_CD_ID(+) = A.COST_CD" ).append("\n"); 
		query.append("AND      A.ACCT_CD <> '511591'" ).append("\n"); 
		query.append("AND      A.COST_DTL_CD = E.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND      B.COST_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("AND      O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("AND      A.COST_CD = T.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("AND      'MNR_INV_IDA' = T.HRD_CDG_ID(+)" ).append("\n"); 
		query.append("AND	     A.MNR_ORD_OFC_CTY_CD IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("	#foreach ($user_mnrOrdOfcCtyCds IN ${mnrOrdOfcCtyCds})" ).append("\n"); 
		query.append("		#if($velocityCount < $mnrOrdOfcCtyCds.size())" ).append("\n"); 
		query.append("			'$user_mnrOrdOfcCtyCds'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$user_mnrOrdOfcCtyCds'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end			  " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("AND	     A.MNR_ORD_SEQ IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("	#foreach ($user_woNos IN ${woNos})" ).append("\n"); 
		query.append("		#if($velocityCount < $woNos.size())" ).append("\n"); 
		query.append("			$user_woNos," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			$user_woNos" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end			  " ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}