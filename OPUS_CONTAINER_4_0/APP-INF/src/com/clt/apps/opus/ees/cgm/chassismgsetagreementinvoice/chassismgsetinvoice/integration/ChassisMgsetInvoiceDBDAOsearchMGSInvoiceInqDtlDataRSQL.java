/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchMGSInvoiceInqDtlDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.08
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2014.05.08 한종희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jonghee HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOsearchMGSInvoiceInqDtlDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091228 2036 start.
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchMGSInvoiceInqDtlDataRSQL(){
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
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchMGSInvoiceInqDtlDataRSQL").append("\n"); 
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
		query.append("    ,T1.AGMT_OFC_CTY_CD || T1.AGMT_SEQ  AS AGMT_NO" ).append("\n"); 
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

	}
}