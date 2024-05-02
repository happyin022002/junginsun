/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOModifyAccountingDetailPaymentLineRestoreUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : ORKIM
*@LastVersion : 1.0
* 2014.05.22 ORKIM
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

public class AccountPayablePaymentDBDAOModifyAccountingDetailPaymentLineRestoreUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAccountingDetailPaymentLineRestore
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOModifyAccountingDetailPaymentLineRestoreUSQL(){
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
		params.put("acctg_evnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOModifyAccountingDetailPaymentLineRestoreUSQL").append("\n"); 
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
		query.append("   UPDATE  SAP_PAY_DTL SPD" ).append("\n"); 
		query.append("   SET     SPD.ACCTG_PST_FLG = 'N'" ).append("\n"); 
		query.append("         , SPD.ACCTG_EVNT_SEQ = NULL" ).append("\n"); 
		query.append("         , SPD.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("         , SPD.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   WHERE   SPD.ACCTG_EVNT_SEQ = @[acctg_evnt_seq]" ).append("\n"); 
		query.append("   AND     SPD.PAY_SEQ IN (SELECT SAE.ACCTG_SRC_SEQ FROM SAP_ACCTG_EVNT SAE, SAP_ACCTG_EVNT_HDR SAEH " ).append("\n"); 
		query.append("                           WHERE  SAE.ACCTG_EVNT_SEQ = SAEH.ACCTG_EVNT_SEQ AND SAE.ACCTG_EVNT_SEQ = @[acctg_evnt_seq] AND SAEH.ACCTG_ERR_CD IS NOT NULL )" ).append("\n"); 

	}
}