/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchPrepaymentSettlementApplyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.12 
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

public class AccountPayableInvoiceDBDAOSearchPrepaymentSettlementApplyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPrepaymentSettlementApplyList
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchPrepaymentSettlementApplyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchPrepaymentSettlementApplyListRSQL").append("\n"); 
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
		query.append("SELECT APPLY_V.ROW_ID" ).append("\n"); 
		query.append("      ,APPLY_V.INV_SEQ" ).append("\n"); 
		query.append("      ,APPLY_V.INV_NO" ).append("\n"); 
		query.append("      ,APPLY_V.VNDR_NO" ).append("\n"); 
		query.append("      ,APPLY_V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,APPLY_V.INV_CURR_CD" ).append("\n"); 
		query.append("      ,APPLY_V.INV_PAY_CURR_CD" ).append("\n"); 
		query.append("      ,APPLY_V.INV_DT" ).append("\n"); 
		query.append("      ,APPLY_V.PAY_CROSS_RATE_DT" ).append("\n"); 
		query.append("      ,APPLY_V.INV_DESC" ).append("\n"); 
		query.append("      ,TRIM(SAP_GET_CUR_AMT_FNC(APPLY_V.INV_PAY_CURR_CD,  APPLY_V.AMOUNT_UNPAID)) AMOUNT_UNPAID" ).append("\n"); 
		query.append("      ,TRIM(SAP_GET_CUR_AMT_FNC(APPLY_V.INV_PAY_CURR_CD,  APPLY_V.TAX_UNPAID)) TAX_UNPAID" ).append("\n"); 
		query.append("      ,0  AS AMOUNT_APPLY" ).append("\n"); 
		query.append("      ,'' AS APPLY_GL_DATE" ).append("\n"); 
		query.append("	  ,'0' AS APPLY" ).append("\n"); 
		query.append("FROM   OPUSADM.SAP_APPLY_PREPAYS_FR_PREPAY_V APPLY_V" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    EXISTS (SELECT 'Y' FROM SAP_PAY_SKD SPS WHERE SPS.INV_HLD_FLG = 'Y' AND SPS.INV_SEQ = APPLY_V.INV_SEQ)" ).append("\n"); 
		query.append("AND    APPLY_V.INV_SEQ IN (SELECT  SIH.INV_SEQ" ).append("\n"); 
		query.append("                           FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("                                 , SCO_LEGR_CD_CMB SLCC " ).append("\n"); 
		query.append("                           WHERE   SIH.LIAB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("                           AND     SIH.INV_TP_LU_CD = 'STANDARD'" ).append("\n"); 
		query.append("                           AND     SIH.INV_SEQ = APPLY_V.INV_SEQ" ).append("\n"); 
		query.append("                           AND     SLCC.SGM_CTNT2 = (SELECT  SLCC2.SGM_CTNT2" ).append("\n"); 
		query.append("                                                     FROM    SCO_LEGR_CD_CMB SLCC2" ).append("\n"); 
		query.append("                                                     WHERE   SLCC2.CD_CMB_SEQ = @[liab_cd_cmb_seq]))" ).append("\n"); 
		query.append("AND    APPLY_V.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("AND    APPLY_V.INV_CURR_CD = @[inv_curr_cd]" ).append("\n"); 
		query.append("ORDER  BY APPLY_V.INV_NO" ).append("\n"); 

	}
}