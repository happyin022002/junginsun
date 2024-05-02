/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCurrUseCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.08
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.08 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCurrUseCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCurrUseCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCurrUseCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCurrUseCheckRSQL").append("\n"); 
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
		query.append("SELECT  MC.CURR_CD     AS CURR_CD" ).append("\n"); 
		query.append("      , ROUND(@[inv_amt], MC.DP_PRCS_KNT) AS CURR_PRECISION_AMT" ).append("\n"); 
		query.append("      , (SELECT  SLD.lU_CD FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD WHERE SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'FUNCTIONAL CURRENCY'" ).append("\n"); 
		query.append("         AND     SLH.LU_APPL_CD = 'SCO' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y' AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND ROWNUM = 1 ) AS FUNCTIONAL_CURRENCY" ).append("\n"); 
		query.append("FROM    MDM_CURRENCY MC" ).append("\n"); 
		query.append("WHERE   MC.CURR_CD = @[inv_curr_cd]" ).append("\n"); 
		query.append("AND     NVL(MC.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}