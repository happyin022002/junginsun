/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceLiabilityAccountCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.02 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceLiabilityAccountCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceLiabilityAccountCheck
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceLiabilityAccountCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceLiabilityAccountCheckRSQL").append("\n"); 
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
		query.append("SELECT  SLCC.SGM_CTNT1        AS VALUE0 -- COMPANY_CODE" ).append("\n"); 
		query.append("      , NVL( (SELECT FINC_RGN_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = @[value1] AND ROWNUM=1 ) ,  SLCC.SGM_CTNT2 )  AS VALUE1 -- REGION_CODE" ).append("\n"); 
		query.append("      , NVL( (SELECT AP_CTR_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = @[value1] AND ROWNUM=1 ) ,  SLCC.SGM_CTNT3 )  AS VALUE2 -- CENTER_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT4        AS VALUE3 -- ACCOUNT_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT5        AS VALUE4 -- INTERCOMPANY_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT6        AS VALUE5 -- VVD_CODE" ).append("\n"); 
		query.append("      , SV.VNDR_NO            AS VALUE6 -- VNDR_NO   " ).append("\n"); 
		query.append("      , CD_CMB_SEQ            AS VALUE7 " ).append("\n"); 
		query.append("FROM    SAP_VENDOR SV" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE   SV.VNDR_NO = @[value0]" ).append("\n"); 
		query.append("#if (${value2} == 'PREPAYMENT') " ).append("\n"); 
		query.append("AND     SLCC.CD_CMB_SEQ = SV.PAY_CD_CMB_SEQ" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" AND     SLCC.CD_CMB_SEQ = SV.LIAB_CD_CMB_SEQ " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     SLCC.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("UNION ALL         " ).append("\n"); 
		query.append("SELECT  (SELECT D.LU_CD " ).append("\n"); 
		query.append("         FROM SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("         WHERE H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("         AND   D.LU_TP_CD = 'GL COMPANY'          " ).append("\n"); 
		query.append("         AND   D.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("         AND   ROWNUM = 1" ).append("\n"); 
		query.append("         )                    AS VALUE0 -- COMPANY_CODE" ).append("\n"); 
		query.append("      , NVL( (SELECT FINC_RGN_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = @[value1] AND ROWNUM=1 ) ,  SLD.ATTR_CTNT1 )  AS VALUE1 -- REGION_CODE" ).append("\n"); 
		query.append("      , NVL( (SELECT AP_CTR_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = @[value1] AND ROWNUM=1 ) ,  SLD.ATTR_CTNT2 )  AS VALUE2 -- CENTER_CODE" ).append("\n"); 
		query.append("      , SLD.ATTR_CTNT3        AS VALUE3 -- ACCOUNT_CODE" ).append("\n"); 
		query.append("      , SLD.ATTR_CTNT4        AS VALUE4 -- INTERCOMPANY_CODE" ).append("\n"); 
		query.append("      , SLD.ATTR_CTNT5        AS VALUE5 -- VVD_CODE" ).append("\n"); 
		query.append("      , 'DEFAULT'             AS VALUE6 -- VNDR_NO   " ).append("\n"); 
		query.append("      , CD_CMB_SEQ            AS VALUE7 " ).append("\n"); 
		query.append("FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("      , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("AND     SLH.LU_TP_CD = 'AP ACCOUNT SETUP'" ).append("\n"); 
		query.append("AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("AND     SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("#if (${value2} == 'PREPAYMENT') " ).append("\n"); 
		query.append("AND     SLD.LU_CD = 'PREPAYMENT ACCOUNT'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND     SLD.LU_CD = 'LIABILITY ACCOUNT'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     SLCC.CD_CMB_SEQ(+) = TO_NUMBER(SLD.LU_DESC)" ).append("\n"); 
		query.append("AND     ROWNUM = 1 " ).append("\n"); 

	}
}