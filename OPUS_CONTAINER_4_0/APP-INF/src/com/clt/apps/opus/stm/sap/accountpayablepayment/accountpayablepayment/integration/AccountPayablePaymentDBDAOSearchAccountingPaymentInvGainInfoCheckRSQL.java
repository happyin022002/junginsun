/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountingPaymentInvGainInfoCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchAccountingPaymentInvGainInfoCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAccountingPaymentInvGainInfoCheck
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountingPaymentInvGainInfoCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountingPaymentInvGainInfoCheckRSQL").append("\n"); 
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
		query.append("SELECT (SELECT D.LU_CD " ).append("\n"); 
		query.append("        FROM SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("        WHERE H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("        AND   D.LU_TP_CD = 'GL COMPANY'          " ).append("\n"); 
		query.append("        AND   D.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("        AND   ROWNUM = 1" ).append("\n"); 
		query.append("       )                      AS G_COMPANY_CODE" ).append("\n"); 
		query.append("	  , SLD.ATTR_CTNT1        AS G_REGION_CODE" ).append("\n"); 
		query.append("	  , SLD.ATTR_CTNT2        AS G_CENTER_CODE" ).append("\n"); 
		query.append("	  , SLD.ATTR_CTNT3        AS G_ACCOUNT_CODE" ).append("\n"); 
		query.append("	  , SLD.ATTR_CTNT4        AS G_INTERCOMPANY_CODE" ).append("\n"); 
		query.append("	  , SLD.ATTR_CTNT5        AS G_VVD_CODE" ).append("\n"); 
		query.append("      , SLCC.CD_CMB_SEQ       AS CD_CMB_SEQ" ).append("\n"); 
		query.append("  FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("	    , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("	    , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("  WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("  AND     SLH.LU_TP_CD = 'AP ACCOUNT SETUP'" ).append("\n"); 
		query.append("  AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("  AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("  AND     SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("  AND     SLD.LU_CD = 'GAIN ACCOUNT'" ).append("\n"); 
		query.append("  --AND     SLCC.CD_CMB_SEQ(+) = TO_NUMBER(SLD.LU_DESC)" ).append("\n"); 
		query.append("  AND     SLCC.ENBL_FLG(+) = 'Y'" ).append("\n"); 
		query.append("  AND     SLCC.SGM_CTNT1(+) = '01'" ).append("\n"); 
		query.append("  AND     SLCC.SGM_CTNT2(+) = SLD.ATTR_CTNT1" ).append("\n"); 
		query.append("  AND     SLCC.SGM_CTNT3(+) = SLD.ATTR_CTNT2" ).append("\n"); 
		query.append("  AND     SLCC.SGM_CTNT4(+) = SLD.ATTR_CTNT3" ).append("\n"); 
		query.append("  AND     SLCC.SGM_CTNT5(+) = SLD.ATTR_CTNT4" ).append("\n"); 
		query.append("  AND     SLCC.SGM_CTNT6(+) = SLD.ATTR_CTNT5" ).append("\n"); 

	}
}