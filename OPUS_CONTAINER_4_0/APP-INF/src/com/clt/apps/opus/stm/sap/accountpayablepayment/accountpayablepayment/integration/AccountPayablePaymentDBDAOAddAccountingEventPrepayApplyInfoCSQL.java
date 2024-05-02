/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddAccountingEventPrepayApplyInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : ORKIM
*@LastVersion : 1.0
* 2014.05.20 ORKIM
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

public class AccountPayablePaymentDBDAOAddAccountingEventPrepayApplyInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAccountingEventPrepayApplyInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddAccountingEventPrepayApplyInfoCSQL(){
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
		params.put("accounting_event_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dtrb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddAccountingEventPrepayApplyInfoCSQL").append("\n"); 
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
		query.append("      INSERT INTO SAP_ACCTG_EVNT" ).append("\n"); 
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
		query.append("            , 'PREPAYMENT APPLICATION' AS ACCTG_EVNT_TP_CD" ).append("\n"); 
		query.append("            , SID.ACCTG_DT             AS ACCTG_DT" ).append("\n"); 
		query.append("            , (SELECT COUNT(DISTINCT SID.ACCTG_EVNT_SEQ) + 1 FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SID.INV_SEQ) AS ACCTG_EVNT_NO" ).append("\n"); 
		query.append("            , 'ACCOUNTED'              AS ACCTG_EVNT_STS_CD" ).append("\n"); 
		query.append("            , 'SAP_INVOICES'           AS ACCTG_SRC_TBL_NM" ).append("\n"); 
		query.append("            , SID.INV_SEQ              AS ACCTG_SRC_SEQ" ).append("\n"); 
		query.append("            , @[accounting_request_id] AS ACCTG_RQST_SEQ" ).append("\n"); 
		query.append("            , @[usr_id]                AS CRE_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                  AS CRE_DT" ).append("\n"); 
		query.append("            , @[usr_id]                AS UPD_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                  AS UPD_DT" ).append("\n"); 
		query.append("      FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("      WHERE   SID.INV_DTRB_SEQ = @[inv_dtrb_seq]" ).append("\n"); 

	}
}