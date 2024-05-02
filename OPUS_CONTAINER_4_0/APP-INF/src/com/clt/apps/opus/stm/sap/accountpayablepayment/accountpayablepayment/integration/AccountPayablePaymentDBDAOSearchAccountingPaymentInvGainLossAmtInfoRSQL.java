/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountingPaymentInvGainLossAmtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : ORKIM
*@LastVersion : 1.0
* 2014.05.14 ORKIM
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

public class AccountPayablePaymentDBDAOSearchAccountingPaymentInvGainLossAmtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAccountingPaymentInvGainLossAmtInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountingPaymentInvGainLossAmtInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("functional_currency",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_pay_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountingPaymentInvGainLossAmtInfoRSQL").append("\n"); 
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
		query.append("  SELECT  ABS(ROUND(SPD.PAY_AMT * NVL(SIH.INV_XCH_RT, 1), " ).append("\n"); 
		query.append("	 	  (SELECT DP_PRCS_KNT FROM MDM_CURRENCY MC WHERE MC.CURR_CD = @[functional_currency] AND DELT_FLG = 'N' AND ROWNUM=1)) - " ).append("\n"); 
		query.append("	      ROUND(SPD.PAY_AMT * NVL((SELECT SPH.PAY_XCH_RT FROM SAP_PAY_HDR SPH WHERE SPH.PAY_SEQ = SPD.PAY_SEQ AND ROWNUM = 1), 1), " ).append("\n"); 
		query.append("	    	(SELECT DP_PRCS_KNT FROM MDM_CURRENCY MC WHERE MC.CURR_CD = @[functional_currency] AND DELT_FLG = 'N' AND ROWNUM=1))) AS GAIN_LOSS_AMT" ).append("\n"); 
		query.append("  FROM    SAP_PAY_DTL SPD" ).append("\n"); 
		query.append("	    , SAP_INV_HDR SIH" ).append("\n"); 
		query.append("  WHERE   SPD.INV_SEQ = SIH.INV_SEQ " ).append("\n"); 
		query.append("  AND     SPD.INV_PAY_SEQ = @[inv_pay_seq]" ).append("\n"); 
		query.append("  AND     SPD.INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}