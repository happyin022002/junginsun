/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceInquiryDBDAOsearchPayableInvoiceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2010.03.23 안준상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jsahn
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryDBDAOsearchPayableInvoiceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPayableInvoiceData
	  * </pre>
	  */
	public InvoiceInquiryDBDAOsearchPayableInvoiceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryDBDAOsearchPayableInvoiceDataRSQL").append("\n"); 
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
		query.append("SELECT T1.VNDR_SEQ" ).append("\n"); 
		query.append(",(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = T1.VNDR_SEQ) AS VNDR_NM" ).append("\n"); 
		query.append(",T2.LSTM_CD" ).append("\n"); 
		query.append(",T2.INV_NO" ).append("\n"); 
		query.append(",T2.CURR_CD" ).append("\n"); 
		query.append(",SUM(T2.TTL_COST_AMT) TTL_COST_AMT" ).append("\n"); 
		query.append(",CASE WHEN ( T1.INV_STS_CD = 'P' OR T1.INV_STS_CD = 'E')  AND T3.IF_FLG = 'E' AND T3.IF_ERR_RSN IS NOT NULL THEN 'Sending Error'" ).append("\n"); 
		query.append("WHEN ( T1.INV_STS_CD = 'P' OR T1.INV_STS_CD = 'E')  AND T3.IF_FLG = 'Y' AND T3.IF_ERR_RSN IS NOT NULL THEN 'Sending'" ).append("\n"); 
		query.append("WHEN ( T1.INV_STS_CD = 'P' OR T1.INV_STS_CD = 'E')  AND T3.IF_FLG = 'Y' AND T3.IF_ERR_RSN IS NULL THEN (SELECT C.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("WHERE C.INTG_CD_ID = 'CD02355'" ).append("\n"); 
		query.append("AND C.INTG_CD_VAL_CTNT = T1.INV_STS_CD )" ).append("\n"); 
		query.append("WHEN T1.INV_STS_CD <> 'P' AND T1.INV_STS_CD <> 'E' THEN (SELECT C.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("WHERE C.INTG_CD_ID = 'CD02355'" ).append("\n"); 
		query.append("AND C.INTG_CD_VAL_CTNT = T1.INV_STS_CD ) END LSE_INV_APSTS_CD" ).append("\n"); 
		query.append(",TO_CHAR(T1.AP_PAY_DT,'YYYYMMDD') AP_PAY_DT" ).append("\n"); 
		query.append(",SUM(T2.PAY_RNTL_COST_AMT) PAY_RNTL_COST_AMT" ).append("\n"); 
		query.append(",@[str_dt] STR_DT  --'20090101'" ).append("\n"); 
		query.append(",@[end_dt] END_DT  --'20090131'" ).append("\n"); 
		query.append("FROM AP_PAY_INV T1," ).append("\n"); 
		query.append("LSE_PAY_RNTL_CHG T2," ).append("\n"); 
		query.append("AP_INV_HDR T3" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.INV_NO = T2.INV_NO" ).append("\n"); 
		query.append("AND T1.CSR_NO = T3.CSR_NO(+)" ).append("\n"); 
		query.append("AND T2.IF_RGST_NO = DECODE(T2.IF_RGST_NO, NULL, NULL, T1.INV_RGST_NO)" ).append("\n"); 
		query.append("AND T1.VNDR_SEQ = T2.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND T1.VNDR_SEQ = @[vndr_seq]  --'105028'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND T1.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("AND T1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if( ${inv_no}!='' )" ).append("\n"); 
		query.append("AND T2.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if( ${str_dt}!='' && ${end_dt}!='' )" ).append("\n"); 
		query.append("AND T1.INV_EFF_DT >= TO_DATE(REPLACE(@[str_dt],'-',''),'YYYYMMDD') AND T1.INV_EFF_DT < TO_DATE(REPLACE(@[end_dt],'-',''),'YYYYMMDD')+1  -- '20090101'  '20090131'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_key} != \"\" )" ).append("\n"); 
		query.append("AND T2.LSTM_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("group by T1.VNDR_SEQ,T2.LSTM_CD,T2.INV_NO,T2.CURR_CD,T1.INV_STS_CD,T3.IF_FLG, T3.IF_ERR_RSN,TO_CHAR(T1.AP_PAY_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	A.VNDR_SEQ" ).append("\n"); 
		query.append(",(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) AS VNDR_NM" ).append("\n"); 
		query.append(",D.LSTM_CD" ).append("\n"); 
		query.append(",A.INV_NO" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",SUM(A.PAY_AMT ) TTL_COST_AMT" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("WHEN ( B.INV_STS_CD = 'P'" ).append("\n"); 
		query.append("OR B.INV_STS_CD = 'E')" ).append("\n"); 
		query.append("AND C.IF_FLG = 'E'" ).append("\n"); 
		query.append("AND C.IF_ERR_RSN IS NOT NULL THEN 'Sending Error'" ).append("\n"); 
		query.append("WHEN ( B.INV_STS_CD = 'P'" ).append("\n"); 
		query.append("OR B.INV_STS_CD = 'E')" ).append("\n"); 
		query.append("AND C.IF_FLG = 'Y'" ).append("\n"); 
		query.append("AND C.IF_ERR_RSN IS NOT NULL THEN 'Sending'" ).append("\n"); 
		query.append("WHEN ( B.INV_STS_CD = 'P'" ).append("\n"); 
		query.append("OR B.INV_STS_CD = 'E')" ).append("\n"); 
		query.append("AND C.IF_FLG = 'Y'" ).append("\n"); 
		query.append("AND C.IF_ERR_RSN IS NULL THEN (" ).append("\n"); 
		query.append("SELECT C.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("WHERE C.INTG_CD_ID = 'CD02355'" ).append("\n"); 
		query.append("AND C.INTG_CD_VAL_CTNT = B.INV_STS_CD )" ).append("\n"); 
		query.append("WHEN B.INV_STS_CD <> 'P'" ).append("\n"); 
		query.append("AND B.INV_STS_CD <> 'E' THEN (" ).append("\n"); 
		query.append("SELECT C.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("WHERE C.INTG_CD_ID = 'CD02355'" ).append("\n"); 
		query.append("AND C.INTG_CD_VAL_CTNT = B.INV_STS_CD )" ).append("\n"); 
		query.append("END LSE_INV_APSTS_CD" ).append("\n"); 
		query.append(",TO_CHAR(B.AP_PAY_DT,'YYYYMMDD') AP_PAY_DT" ).append("\n"); 
		query.append(",SUM(A.PAY_AMT ) PAY_RNTL_COST_AMT" ).append("\n"); 
		query.append(",@[str_dt] STR_DT" ).append("\n"); 
		query.append(",@[end_dt] END_DT" ).append("\n"); 
		query.append("FROM LSE_OP_LSE A ," ).append("\n"); 
		query.append("AP_PAY_INV B ," ).append("\n"); 
		query.append("AP_INV_HDR C ," ).append("\n"); 
		query.append("LSE_AGREEMENT D" ).append("\n"); 
		query.append("WHERE A.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = D.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("AND B.CSR_NO = C.CSR_NO(+)" ).append("\n"); 
		query.append("AND A.IF_RGST_NO = DECODE(A.IF_RGST_NO, NULL, NULL, B.INV_RGST_NO)" ).append("\n"); 
		query.append("AND B.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${inv_no}!='' )" ).append("\n"); 
		query.append("AND  A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if( ${str_dt}!='' && ${end_dt}!='' )" ).append("\n"); 
		query.append("AND B.INV_EFF_DT >= TO_DATE(REPLACE(@[str_dt],'-',''),'YYYYMMDD') AND B.INV_EFF_DT < TO_DATE(REPLACE(@[end_dt],'-',''),'YYYYMMDD')+1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_key} != \"\" )" ).append("\n"); 
		query.append("AND D.LSTM_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.VNDR_SEQ," ).append("\n"); 
		query.append("D.LSTM_CD," ).append("\n"); 
		query.append("A.INV_NO," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("B.INV_STS_CD," ).append("\n"); 
		query.append("C.IF_FLG," ).append("\n"); 
		query.append("C.IF_ERR_RSN," ).append("\n"); 
		query.append("TO_CHAR(B.AP_PAY_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("ORDER BY INV_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}