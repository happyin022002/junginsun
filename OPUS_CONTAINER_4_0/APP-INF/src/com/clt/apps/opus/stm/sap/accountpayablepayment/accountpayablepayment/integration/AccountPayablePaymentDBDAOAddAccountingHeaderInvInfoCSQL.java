/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddAccountingHeaderInvInfoCSQL.java
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

public class AccountPayablePaymentDBDAOAddAccountingHeaderInvInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAccountingHeaderInvInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddAccountingHeaderInvInfoCSQL(){
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
		params.put("accounting_header_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accounting_event_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddAccountingHeaderInvInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_ACCTG_EVNT_HDR" ).append("\n"); 
		query.append("      ( ACCTG_HDR_SEQ" ).append("\n"); 
		query.append("      , ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("      , ACCTG_EVNT_CATE_CD" ).append("\n"); 
		query.append("      , ACCTG_PRD_NM" ).append("\n"); 
		query.append("      , ACCTG_DT" ).append("\n"); 
		query.append("      , GL_TRNS_CD" ).append("\n"); 
		query.append("      , GL_TRNS_RUN_SEQ" ).append("\n"); 
		query.append("      , ACCTG_DESC" ).append("\n"); 
		query.append("      , ACCTG_RQST_SEQ" ).append("\n"); 
		query.append("      , ACCTG_SRC_SEQ" ).append("\n"); 
		query.append("      , ACCTG_ERR_CD" ).append("\n"); 
		query.append("      , GL_TRNS_ERR_CD" ).append("\n"); 
		query.append("      , GL_RVS_FLG" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      SELECT  @[accounting_header_id]  AS ACCTG_HDR_SEQ" ).append("\n"); 
		query.append("            , @[accounting_event_id]   AS ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("            , 'Purchase Invoices'      AS ACCTG_EVNT_CATE_CD" ).append("\n"); 
		query.append("            , TO_CHAR((SELECT  SID.ACCTG_DT FROM SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD <> 'PREPAY' AND NVL(SID.ACCTG_PST_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("                       AND     NVL(SID.RVS_FLG, 'N') <> 'Y' AND SID.PRNT_RVS_DTRB_SEQ IS NULL AND ROWNUM = 1), 'YYYY/MM') AS ACCTG_PRD_NM" ).append("\n"); 
		query.append("            , (SELECT  SID.ACCTG_DT FROM SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD <> 'PREPAY' AND NVL(SID.ACCTG_PST_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("               AND     NVL(SID.RVS_FLG, 'N') <> 'Y' AND SID.PRNT_RVS_DTRB_SEQ IS NULL AND ROWNUM = 1) AS ACCTG_DT" ).append("\n"); 
		query.append("            , 'N'                      AS GL_TRNS_CD" ).append("\n"); 
		query.append("            , ''                       AS GL_TRNS_RUN_SEQ" ).append("\n"); 
		query.append("            , SIH.INV_DESC             AS ACCTG_DESC" ).append("\n"); 
		query.append("            , @[accounting_request_id] AS ACCTG_RQST_SEQ" ).append("\n"); 
		query.append("            , SIH.INV_SEQ              AS ACCTG_SRC_SEQ" ).append("\n"); 
		query.append("            , ''                       AS ACCTG_ERR_CD" ).append("\n"); 
		query.append("            , ''                       AS GL_TRNS_ERR_CD" ).append("\n"); 
		query.append("            , 'N'                      AS GL_RVS_FLG" ).append("\n"); 
		query.append("            , @[usr_id]                AS CRE_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                  AS CRE_DT" ).append("\n"); 
		query.append("            , @[usr_id]                AS UPD_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                  AS UPD_DT" ).append("\n"); 
		query.append("      FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      WHERE   SIH.INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}