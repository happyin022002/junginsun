/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddAccountingEventPayInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.16
*@LastModifier : ORKIM
*@LastVersion : 1.0
* 2014.05.16 ORKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ORKIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOAddAccountingEventPayInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAccountingEventPayInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddAccountingEventPayInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accounting_request_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accounting_event_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddAccountingEventPayInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_ACCTG_EVNT" ).append("\n"); 
		query.append("      ( ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("      , ACCTG_EVNT_TP_CD" ).append("\n"); 
		query.append("      , ACCTG_DT" ).append("\n"); 
		query.append("      , ACCTG_EVNT_NO" ).append("\n"); 
		query.append("      , ACCTG_EVNT_STS_CD" ).append("\n"); 
		query.append("      , ACCTG_SRC_TBL_NM" ).append("\n"); 
		query.append("      , ACCTG_SRC_SEQ" ).append("\n"); 
		query.append("      , ACCTG_RQST_SEQ" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      SELECT  @[accounting_event_id]   AS ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("            , 'PAYMENT'                AS ACCTG_EVNT_TP_CD" ).append("\n"); 
		query.append("            , (SELECT  SPD.ACCTG_DT FROM SAP_PAY_DTL SPD WHERE SPD.PAY_SEQ = SPH.PAY_SEQ AND NVL(SPD.ACCTG_PST_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("               AND     SPD.PRNT_RVS_INV_PAY_SEQ IS NULL AND ROWNUM = 1) AS ACCTG_DT" ).append("\n"); 
		query.append("            , 1                        AS ACCTG_EVNT_NO" ).append("\n"); 
		query.append("            , 'ACCOUNTED'              AS ACCTG_EVNT_STS_CD" ).append("\n"); 
		query.append("            , 'SAP_PAYMENTS'           AS ACCTG_SRC_TBL_NM" ).append("\n"); 
		query.append("            , SPH.PAY_SEQ              AS ACCTG_SRC_SEQ" ).append("\n"); 
		query.append("            , @[accounting_request_id] AS ACCTG_RQST_SEQ" ).append("\n"); 
		query.append("            , @[usr_id]                AS CRE_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                  AS CRE_DT" ).append("\n"); 
		query.append("            , @[usr_id]                AS UPD_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                  AS UPD_DT" ).append("\n"); 
		query.append("      FROM    SAP_PAY_HDR SPH" ).append("\n"); 
		query.append("      WHERE   SPH.PAY_SEQ = @[pay_seq]" ).append("\n"); 

	}
}