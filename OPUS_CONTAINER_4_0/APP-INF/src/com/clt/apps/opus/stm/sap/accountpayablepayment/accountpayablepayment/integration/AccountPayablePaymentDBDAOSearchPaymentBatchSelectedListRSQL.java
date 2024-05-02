/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchPaymentBatchSelectedListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchPaymentBatchSelectedListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPaymentBatchSelectedList
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchPaymentBatchSelectedListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchPaymentBatchSelectedListRSQL").append("\n"); 
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
		query.append("SELECT  SSI.INV_NO            AS INV_NO" ).append("\n"); 
		query.append("      , SSI.INV_SEQ           AS INV_SEQ" ).append("\n"); 
		query.append("      , TO_CHAR(SSI.INV_DT, 'YYYYMMDD')            AS INV_DT" ).append("\n"); 
		query.append("      , SSI.VNDR_NO           AS VNDR_NO" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM    AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , SSI.PAY_CURR_CD       AS PAY_CURR_CD" ).append("\n"); 
		query.append("      , TRIM(SAP_GET_CUR_AMT_FNC(SSI.PAY_CURR_CD, SSI.INV_AMT))  INV_AMT" ).append("\n"); 
		query.append("      , TO_CHAR(SSI.DUE_DT, 'YYYYMMDD')            AS DUE_DT" ).append("\n"); 
		query.append("      , SSI.INV_DESC          AS INV_DESC" ).append("\n"); 
		query.append("      , TRIM(SAP_GET_CUR_AMT_FNC(SSI.PAY_CURR_CD, SSI.PAY_AMT))  PAY_AMT" ).append("\n"); 
		query.append("      , SSI.BANK_ACCT_NO      AS BANK_ACCT_NO" ).append("\n"); 
		query.append("      , SSI.PAY_BAT_SEQ       AS PAY_BAT_SEQ" ).append("\n"); 
		query.append("      , SSI.PAY_BAT_NM        AS PAY_BAT_NM" ).append("\n"); 
		query.append("      , SSI.PAY_SKD_NO        AS PAY_SKD_NO" ).append("\n"); 
		query.append("FROM    SAP_SEL_INV SSI" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE   TO_NUMBER(SSI.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_SEQ = @[pay_bat_seq]" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_NM = @[pay_bat_nm]" ).append("\n"); 
		query.append("ORDER BY SSI.INV_NO" ).append("\n"); 

	}
}