/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAP로 Interface되는 비용 전표에 대해서 ACH Payment Method의 경우 Local Currency을 사용해야 하는 Validation을 체크하기 위한 Currency 값 조회
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ifVndNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ifLiabAcct",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ifCurrCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheckRSQL").append("\n"); 
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
		query.append("SELECT  DECODE((SELECT  COUNT(SLD.LU_CD) AS CNT FROM SCO_LU_DTL SLD WHERE SLD.LU_CD = @[ifLiabAcct]" ).append("\n"); 
		query.append("                AND     SLD.LU_TP_CD = 'AP ACCRUAL ACCOUNT' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y' AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE), 1, @[ifCurrCd]," ).append("\n"); 
		query.append("        DECODE(MC.CNT_CD, 'US', DECODE(@[ifCurrCd], 'USD', @[ifCurrCd], 'CAD', @[ifCurrCd], MC.CURR_CD), MC.CURR_CD)) AS CNT_CURR_CD" ).append("\n"); 
		query.append("FROM    MDM_VENDOR MV" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("      , MDM_LOCATION ML" ).append("\n"); 
		query.append("      , MDM_COUNTRY MC" ).append("\n"); 
		query.append("WHERE   MV.VNDR_SEQ = @[ifVndNo]" ).append("\n"); 
		query.append("AND     MV.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND     MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND     ML.CNT_CD = MC.CNT_CD" ).append("\n"); 

	}
}