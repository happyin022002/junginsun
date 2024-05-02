/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountingPrepayUnApplyGainLossAmtInfoRSQL.java
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

public class AccountPayablePaymentDBDAOSearchAccountingPrepayUnApplyGainLossAmtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAccountingPrepayUnApplyGainLossAmtInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountingPrepayUnApplyGainLossAmtInfoRSQL(){
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
		params.put("inv_dtrb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountingPrepayUnApplyGainLossAmtInfoRSQL").append("\n"); 
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
		query.append("    SELECT  ABS(ROUND(SID.DTRB_AMT * NVL(SIH.INV_XCH_RT, 1), " ).append("\n"); 
		query.append("	        	(SELECT DP_PRCS_KNT FROM MDM_CURRENCY MC WHERE MC.CURR_CD = @[functional_currency] AND DELT_FLG = 'N' AND ROWNUM=1)) - " ).append("\n"); 
		query.append("	        	ROUND(SID.DTRB_AMT * NVL(PRE_SIH.INV_XCH_RT, 1), " ).append("\n"); 
		query.append("        		(SELECT DP_PRCS_KNT FROM MDM_CURRENCY MC WHERE MC.CURR_CD = @[functional_currency] AND DELT_FLG = 'N' AND ROWNUM=1))) AS GAIN_LOSS_AMT" ).append("\n"); 
		query.append("    FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("     	  , SAP_INV_HDR SIH" ).append("\n"); 
		query.append("    	  , SAP_INV_HDR PRE_SIH" ).append("\n"); 
		query.append("    WHERE   SID.INV_SEQ = SIH.INV_SEQ " ).append("\n"); 
		query.append("    AND     SID.PPAY_INV_SEQ = PRE_SIH.INV_SEQ" ).append("\n"); 
		query.append("    AND     SID.INV_DTRB_SEQ = @[inv_dtrb_seq]" ).append("\n"); 

	}
}