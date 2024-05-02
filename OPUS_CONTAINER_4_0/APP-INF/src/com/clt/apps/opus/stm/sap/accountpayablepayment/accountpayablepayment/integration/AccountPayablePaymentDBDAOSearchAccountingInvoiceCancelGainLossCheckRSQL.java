/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountingInvoiceCancelGainLossCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchAccountingInvoiceCancelGainLossCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Accounting 처리시 Line단위 Ex. Rate 적용한 내역중 Cancel 처리할 때 Gain & Loss가 발생한 내역에 대해서 존재 여부 파악
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountingInvoiceCancelGainLossCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountingInvoiceCancelGainLossCheckRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(SIGN(SUM(NVL(SID.DTRB_FUNC_GAIN_AMT, 0) - NVL(SID.DTRB_FUNC_LSS_AMT, 0))), -1, 'DR', 1, 'CR', 'NO') AS JOURNAL_TYPE" ).append("\n"); 
		query.append("FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("WHERE   SID.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("AND     SID.LINE_TP_LU_CD <> 'PREPAY'" ).append("\n"); 
		query.append("AND     NVL(SID.ACCTG_PST_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND     NVL(SID.RVS_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("AND     SID.PRNT_RVS_DTRB_SEQ IS NOT NULL" ).append("\n"); 

	}
}