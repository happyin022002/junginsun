/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchPaymentScheduleListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.01 
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

public class AccountPayablePaymentDBDAOSearchPaymentScheduleListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0050 select를 위한 쿼리
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchPaymentScheduleListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_mzd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_pay_grp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchPaymentScheduleListRSQL").append("\n"); 
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
		query.append("SELECT  P.DUE_DT                                 AS DUE_DT" ).append("\n"); 
		query.append("      , I.OFC_CD                                 AS OFC_CD" ).append("\n"); 
		query.append("      , I.AP_PAY_GRP_LU_CD                       AS AP_PAY_GRP_LU_CD" ).append("\n"); 
		query.append("      , MV.VNDR_SEQ || '_' || MV.VNDR_LGL_ENG_NM AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , I.INV_NO                                 AS INV_NO" ).append("\n"); 
		query.append("      , I.GL_DT                                  AS GL_DT" ).append("\n"); 
		query.append("      , I.INV_CURR_CD                            AS INV_CURR_CD" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(I.INV_CURR_CD, P.PAY_RMN_AMT))  AS PAY_RMN_AMT" ).append("\n"); 
		query.append("      , I.INV_DESC                               AS INV_DESC" ).append("\n"); 
		query.append("      , SUP_BANK.SUPPLIER_BANK_N_ACCT_NUM        AS BANK_ACCT_NO" ).append("\n"); 
		query.append("      , I.PAY_MZD_LU_CD                          AS PAY_MZD_LU_CD" ).append("\n"); 
		query.append(" FROM   SAP_PAY_SKD P" ).append("\n"); 
		query.append("      , SAP_INV_HDR I" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("      , (SELECT SBA.BANK_ACCT_NO" ).append("\n"); 
		query.append("               ,SBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("               ,SBB.BANK_NM || '_' || SBA.BANK_ACCT_NO SUPPLIER_BANK_N_ACCT_NUM" ).append("\n"); 
		query.append("          FROM SAP_BANK_BRNC SBB" ).append("\n"); 
		query.append("              ,SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("         WHERE SBB.BANK_BRNC_SEQ = SBA.BANK_BRNC_SEQ) SUP_BANK" ).append("\n"); 
		query.append(" WHERE MV.VNDR_SEQ    = I.VNDR_NO" ).append("\n"); 
		query.append("   AND I.INV_SEQ      = P.INV_SEQ" ).append("\n"); 
		query.append("   AND P.XTER_BANK_ACCT_SEQ = SUP_BANK.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("   AND I.INV_CXL_DT   IS NULL" ).append("\n"); 
		query.append("   AND P.PAY_RMN_AMT  <> 0" ).append("\n"); 
		query.append("   AND (I.PAY_STS_FLG = 'N' OR I.PAY_STS_FLG = 'P')" ).append("\n"); 
		query.append("   AND P.PAY_STS_FLG  <> 'Y'" ).append("\n"); 
		query.append("   AND (I.AP_APSTS_CD IN ('WFAPPROVED', 'NOT REQUIRED', 'MANUALLY APPROVED'))" ).append("\n"); 
		query.append("   AND NVL(P.INV_HLD_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("   AND I.OFC_CD       = @[ofc_cd]" ).append("\n"); 
		query.append("   AND P.DUE_DT       >= TO_DATE(@[due_dt_fr], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   AND P.DUE_DT       < TO_DATE(@[due_dt_to], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#if (${ap_pay_grp_lu_cd} != '') " ).append("\n"); 
		query.append("   AND I.AP_PAY_GRP_LU_CD = @[ap_pay_grp_lu_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pay_mzd_lu_cd} != '') " ).append("\n"); 
		query.append("   AND I.PAY_MZD_LU_CD = @[pay_mzd_lu_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_no} != '') " ).append("\n"); 
		query.append("   AND MV.VNDR_SEQ   = @[vndr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_curr_cd} != '') " ).append("\n"); 
		query.append("   AND I.INV_CURR_CD = @[inv_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY P.DUE_DT, I.INV_CURR_CD, I.AP_PAY_GRP_LU_CD, MV.VNDR_SEQ" ).append("\n"); 

	}
}