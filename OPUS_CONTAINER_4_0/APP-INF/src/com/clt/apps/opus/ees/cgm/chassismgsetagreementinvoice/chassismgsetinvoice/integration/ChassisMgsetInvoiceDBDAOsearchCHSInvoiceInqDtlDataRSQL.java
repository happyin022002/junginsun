/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchCHSInvoiceInqDtlDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.01.28 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOsearchCHSInvoiceInqDtlDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ------------------------------------------------------------------------------------------------------------------
	  * chungpa 20091221 1035 start
	  * 2014-05-16 Justin HAN Added NP, CP Invoice Detail Inquiry SQL
	  * ------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchCHSInvoiceInqDtlDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchCHSInvoiceInqDtlDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    T1.PAY_INV_SEQ                      AS PAY_INV_SEQ" ).append("\n"); 
		query.append("    ,T1.AGMT_OFC_CTY_CD || LPAD(T1.AGMT_SEQ, 6,'0')  AS AGMT_NO" ).append("\n"); 
		query.append("    , T2.AGMT_LSTM_CD                   AS AGMT_LSTM_CD" ).append("\n"); 
		query.append("    , T1.ACCT_CD                        AS ACCT_CD" ).append("\n"); 
		query.append("    , T1.EQ_NO                          AS EQ_NO" ).append("\n"); 
		query.append("    , T2.EQ_TPSZ_CD                     AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("	, T2.AGMT_LSTM_CD					AS AGMT_LSTM_CD" ).append("\n"); 
		query.append("    , T3.CURR_CD                        AS CURR_CD" ).append("\n"); 
		query.append("    , T1.CHG_CD                         AS CHG_CD" ).append("\n"); 
		query.append("    , T1.PAY_TAX_AMT                    AS PAY_TAX_AMT" ).append("\n"); 
		query.append("    , T1.PAY_CR_AMT                     AS PAY_CR_AMT" ).append("\n"); 
		query.append("    , T1.PAY_LSE_CHG_AMT                AS PAY_LSE_CHG_AMT" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CGM_LSE_CHG_DTL T1" ).append("\n"); 
		query.append("    LEFT JOIN CGM_EQUIPMENT T2 ON (T1.EQ_NO = T2.EQ_NO AND T2.EQ_KND_CD = @[eq_knd_cd])" ).append("\n"); 
		query.append("    LEFT JOIN CGM_LSE_CHG_HDR T3 ON (T1.AGMT_OFC_CTY_CD = T3.AGMT_OFC_CTY_CD " ).append("\n"); 
		query.append("                                     AND T1.AGMT_SEQ = T3.AGMT_SEQ" ).append("\n"); 
		query.append("                                     AND T1.AGMT_VER_NO = T3.AGMT_VER_NO" ).append("\n"); 
		query.append("                                     AND T1.COST_YRMON = T3.COST_YRMON" ).append("\n"); 
		query.append("                                     AND T1.EQ_KND_CD = T3.EQ_KND_CD " ).append("\n"); 
		query.append("                                     AND ROWNUM =1 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 
		query.append("  AND T1.PAY_LSE_CHG_STS_CD = 'C'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.PAY_INV_SEQ AS PAY_INV_SEQ," ).append("\n"); 
		query.append("       A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6,'0') AS AGMT_NO," ).append("\n"); 
		query.append("       A.CHSS_MGST_INV_KND_CD AS AGMT_LSTM_CD," ).append("\n"); 
		query.append("       B.ACCT_CD," ).append("\n"); 
		query.append("	   '' AS EQ_NO," ).append("\n"); 
		query.append("	   '' AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("	   A.CHSS_MGST_INV_KND_CD AS AGMT_LSTM_CD," ).append("\n"); 
		query.append("	   A.CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("	   '' AS CHG_CD," ).append("\n"); 
		query.append("       0 AS PAY_TAX_AMT," ).append("\n"); 
		query.append("       CASE WHEN A.CHSS_MGST_INV_KND_CD = 'CP' AND B.DTL_POOL_COST_ITM_CD = 'CG' THEN ABS(B.COST_AMT)" ).append("\n"); 
		query.append("            WHEN A.CHSS_MGST_INV_KND_CD = 'NP' AND B.DTL_POOL_COST_ITM_CD = 'NE' THEN ABS(B.COST_AMT)" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END AS PAY_CR_AMT," ).append("\n"); 
		query.append("       CASE WHEN A.CHSS_MGST_INV_KND_CD = 'CP' AND B.DTL_POOL_COST_ITM_CD = 'CG' THEN B.COST_AMT       " ).append("\n"); 
		query.append("            WHEN A.CHSS_MGST_INV_KND_CD = 'NP' AND B.DTL_POOL_COST_ITM_CD = 'NE' THEN B.COST_AMT" ).append("\n"); 
		query.append("            ELSE B.COST_AMT" ).append("\n"); 
		query.append("       END AS PAY_LSE_CHG_AMT" ).append("\n"); 
		query.append("  FROM CGM_PAY_INV A, CGM_PAY_INV_POOL_DTL B" ).append("\n"); 
		query.append(" WHERE A.PAY_INV_SEQ = B.PAY_INV_SEQ" ).append("\n"); 
		query.append("   AND B.PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 
		query.append("   AND A.CHSS_MGST_INV_STS_CD != 'H'" ).append("\n"); 

	}
}