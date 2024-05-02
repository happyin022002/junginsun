/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyAccountingDetailInvLineFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOModifyAccountingDetailInvLineFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAccountingDetailInvLineFlag
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyAccountingDetailInvLineFlagUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyAccountingDetailInvLineFlagUSQL").append("\n"); 
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
		query.append("UPDATE  SAP_INV_DTL SID" ).append("\n"); 
		query.append("      SET     SID.ACCTG_PST_FLG = 'Y'" ).append("\n"); 
		query.append("            , SID.ACCTG_EVNT_SEQ = @[accounting_event_id]" ).append("\n"); 
		query.append("            , SID.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("            , SID.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("      WHERE   SID.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("      AND     SID.LINE_TP_LU_CD <> 'PREPAY'" ).append("\n"); 
		query.append("      AND     NVL(SID.ACCTG_PST_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND     NVL(SID.RVS_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND     SID.PRNT_RVS_DTRB_SEQ IS NULL" ).append("\n"); 
		query.append("      --AND     SID.DTRB_AMT <> 0" ).append("\n"); 

	}
}