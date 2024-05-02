/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ExpenseMgtDBDAOsearchInvoiceDetailListByINVDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.18 
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

public class ExpenseMgtDBDAOsearchInvoiceDetailListByINVDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExpenseMgtDBDAOsearchInvoiceDetailListByINVDataRSQL
	  * </pre>
	  */
	public ExpenseMgtDBDAOsearchInvoiceDetailListByINVDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOsearchInvoiceDetailListByINVDataRSQL").append("\n"); 
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
		query.append("SELECT   B.MNR_WO_TP_CD " ).append("\n"); 
		query.append("       , B.EQ_KND_CD" ).append("\n"); 
		query.append("       , B.COST_OFC_CD" ).append("\n"); 
		query.append("       , B.CURR_CD" ).append("\n"); 
		query.append("       , C.MNR_CD_DESC AS MNR_WO_TP" ).append("\n"); 
		query.append("       , A.IDA_SAC_CD" ).append("\n"); 
		query.append("       , A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , ( A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ ) AS WO_NO" ).append("\n"); 
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
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[user_ofc_cd]), 'YYYY-MM-DD') AS WO_DT" ).append("\n"); 
		query.append("       , TO_CHAR(A.RPR_RSLT_DT, 'YYYY-MM-DD') AS RPR_RSLT_DT" ).append("\n"); 
		query.append("       , A.RPR_QTY" ).append("\n"); 
		query.append("       , A.SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("       , A.BZC_AMT" ).append("\n"); 
		query.append("       , A.COST_AMT" ).append("\n"); 
		query.append("       , A.SLS_TAX_AMT" ).append("\n"); 
		query.append("       , A.N3PTY_FLG" ).append("\n"); 
		query.append("       , A.N3PTY_BIL_TTL_AMT" ).append("\n"); 
		query.append("       , A.INV_AMT INV_AMT" ).append("\n"); 
		query.append("       , A.MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("       , A.ORD_DTL_RMK" ).append("\n"); 
		query.append("       , A.INV_NO" ).append("\n"); 
		query.append("       , A.FILE_SEQ" ).append("\n"); 
		query.append("       , A.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , A.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("       , A.PAY_INV_SEQ" ).append("\n"); 
		query.append("       , 'SS' AS MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("       , F.RQST_REF_NO" ).append("\n"); 
		query.append("       , A.CRE_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[user_ofc_cd]), 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("       , A.UPD_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.UPD_DT, @[user_ofc_cd]), 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("       , NVL(A.IDA_CGST_RTO,0) AS IDA_CGST_RTO" ).append("\n"); 
		query.append("       , NVL(A.IDA_SGST_RTO,0) AS IDA_SGST_RTO" ).append("\n"); 
		query.append("       , NVL(A.IDA_IGST_RTO,0) AS IDA_IGST_RTO" ).append("\n"); 
		query.append("       , NVL(A.IDA_UGST_RTO,0) AS IDA_UGST_RTO" ).append("\n"); 
		query.append("       , NVL(A.IDA_CGST_AMT,0) AS IDA_CGST_AMT" ).append("\n"); 
		query.append("       , NVL(A.IDA_SGST_AMT,0) AS IDA_SGST_AMT" ).append("\n"); 
		query.append("       , NVL(A.IDA_IGST_AMT,0) AS IDA_IGST_AMT" ).append("\n"); 
		query.append("       , NVL(A.IDA_UGST_AMT,0) AS IDA_UGST_AMT" ).append("\n"); 
		query.append("FROM     MNR_ORD_DTL A" ).append("\n"); 
		query.append("       , MNR_ORD_HDR B" ).append("\n"); 
		query.append("       , MNR_GEN_CD C" ).append("\n"); 
		query.append("       , MNR_GEN_CD E" ).append("\n"); 
		query.append("       , MNR_RPR_RQST_HDR F" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND      A.MNR_ORD_SEQ = B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND      A.MNR_ORD_OFC_CTY_CD = F.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND      A.MNR_ORD_SEQ = F.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("AND      C.PRNT_CD_ID(+) = 'CD00020'" ).append("\n"); 
		query.append("AND      B.MNR_WO_TP_CD = C.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND      E.PRNT_CD_ID(+) = A.COST_CD" ).append("\n"); 
		query.append("AND      A.COST_DTL_CD = E.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND      A.ACCT_CD <> '511591' " ).append("\n"); 
		query.append("#if (${payInvSeqs} != '')" ).append("\n"); 
		query.append("AND	     A.PAY_INV_SEQ IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${payInvSeqs})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $payInvSeqs.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}