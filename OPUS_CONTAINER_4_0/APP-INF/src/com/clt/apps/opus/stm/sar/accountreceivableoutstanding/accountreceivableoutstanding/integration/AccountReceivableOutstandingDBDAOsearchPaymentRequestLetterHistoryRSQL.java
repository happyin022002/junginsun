/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPaymentRequestLetterHistory
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("send_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("send_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterHistoryRSQL").append("\n"); 
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
		query.append("SELECT B.STMT_RQST_SEQ" ).append("\n"); 
		query.append("     , DECODE(B.STMT_RQST_TP_CD,'CUST','Ad Hoc','Standard') AS STMT_RQST_TP_CD" ).append("\n"); 
		query.append("     , B.CTRL_OFC_CD" ).append("\n"); 
		query.append("     , TO_CHAR(B.STMT_ST_DT,'YYYY-MM-DD HH24:MI:SS') STMT_ST_DT" ).append("\n"); 
		query.append("     , B.STMT_USR_ID" ).append("\n"); 
		query.append("     , B.CUST_CNT_CD||LPAD(B.CUST_SEQ,6, '0') AS CS_CUST_CD" ).append("\n"); 
		query.append("     , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE B.CUST_CNT_CD = A.CUST_CNT_CD AND B.CUST_SEQ = A.CUST_SEQ) CUST_NM" ).append("\n"); 
		query.append("     , B.STMT_STS_CD   " ).append("\n"); 
		query.append("FROM SAR_PAY_RQST_LTR_HIS B" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if ( ${r_type} != '')" ).append("\n"); 
		query.append(" AND B.STMT_RQST_TP_CD = DECODE(@[r_type],'C','CUST','OFC')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if ( ${cust_cnt_cd} != '' && ${cust_seq} )" ).append("\n"); 
		query.append(" AND (B.CUST_CNT_CD = @[cust_cnt_cd] AND B.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if ( ${ar_ofc_cd} != '')" ).append("\n"); 
		query.append(" AND B.CTRL_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if ( ${send_dt_fm} != '' && ${send_dt_to} )" ).append("\n"); 
		query.append(" AND (B.STMT_ST_DT BETWEEN TO_DATE(REPLACE(@[send_dt_fm],'-',''), 'YYYYMMDD') " ).append("\n"); 
		query.append("     AND (TO_DATE(REPLACE(@[send_dt_to],'-',''), 'YYYYMMDD') + 0.99999))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.STMT_ST_DT DESC" ).append("\n"); 

	}
}