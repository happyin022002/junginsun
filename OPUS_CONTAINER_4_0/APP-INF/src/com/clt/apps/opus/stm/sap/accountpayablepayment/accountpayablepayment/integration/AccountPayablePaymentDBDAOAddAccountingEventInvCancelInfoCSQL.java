/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddAccountingEventInvCancelInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.13
*@LastModifier : ORKIM
*@LastVersion : 1.0
* 2014.05.13 ORKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ORKIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOAddAccountingEventInvCancelInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAccountingEventInvCancelInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddAccountingEventInvCancelInfoCSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accounting_event_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddAccountingEventInvCancelInfoCSQL").append("\n"); 
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
		query.append("            , 'INVOICE CANCELLATION'   AS ACCTG_EVNT_TP_CD" ).append("\n"); 
		query.append("            , (SELECT  SID.ACCTG_DT FROM SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD <> 'PREPAY' AND NVL(SID.ACCTG_PST_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("               AND     NVL(SID.RVS_FLG, 'N') = 'Y' AND SID.PRNT_RVS_DTRB_SEQ IS NOT NULL AND ROWNUM = 1) AS ACCTG_DT" ).append("\n"); 
		query.append("            , 2                        AS ACCTG_EVNT_NO" ).append("\n"); 
		query.append("            , 'ACCOUNTED'              AS ACCTG_EVNT_STS_CD" ).append("\n"); 
		query.append("            , 'SAP_INVOICES'           AS ACCTG_SRC_TBL_NM" ).append("\n"); 
		query.append("            , SIH.INV_SEQ              AS ACCTG_SRC_SEQ" ).append("\n"); 
		query.append("            , @[accounting_request_id] AS ACCTG_RQST_SEQ" ).append("\n"); 
		query.append("            , @[usr_id]                AS CRE_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                  AS CRE_DT" ).append("\n"); 
		query.append("            , @[usr_id]                AS UPD_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                  AS UPD_DT" ).append("\n"); 
		query.append("      FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      WHERE   SIH.INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}