/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceEntryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.02 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceEntryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice의 Header인 대변 내역을 조회한다
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceEntryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gl_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ap_inv_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceEntryListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("     H.INV_SEQ" ).append("\n"); 
		query.append(",    H.VNDR_NO" ).append("\n"); 
		query.append(",    H.INV_NO" ).append("\n"); 
		query.append(",    H.INV_CURR_CD" ).append("\n"); 
		query.append(",    H.INV_PAY_CURR_CD" ).append("\n"); 
		query.append(",    TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(H.INV_CURR_CD, H.INV_AMT))  INV_AMT" ).append("\n"); 
		query.append(",    TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(H.INV_CURR_CD, H.INV_PAY_AMT)) INV_PAY_AMT" ).append("\n"); 
		query.append(",    TO_CHAR(H.INV_DT, 'YYYY-MM-DD') AS INV_DT" ).append("\n"); 
		query.append(",    H.AP_INV_SRC_CD" ).append("\n"); 
		query.append(",    H.INV_TP_LU_CD" ).append("\n"); 
		query.append(",    H.INV_DESC" ).append("\n"); 
		query.append(",    H.BAT_SEQ" ).append("\n"); 
		query.append(",    TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(H.INV_CURR_CD, H.INV_VAT_AMT)) INV_VAT_AMT" ).append("\n"); 
		query.append(",    H.INV_TERM_NM" ).append("\n"); 
		query.append(",    TO_CHAR(H.INV_TERM_DT, 'YYYY-MM-DD') AS INV_TERM_DT  " ).append("\n"); 
		query.append(",    H.PAY_MZD_LU_CD" ).append("\n"); 
		query.append(",    H.AP_PAY_GRP_LU_CD" ).append("\n"); 
		query.append(",    SLCC.SGM_CTNT1   LIAB_COA_CO_CD" ).append("\n"); 
		query.append(",    SLCC.SGM_CTNT2   LIAB_COA_RGN_CD" ).append("\n"); 
		query.append(",    SLCC.SGM_CTNT3   LIAB_COA_CTR_CD" ).append("\n"); 
		query.append(",    SLCC.SGM_CTNT4   LIAB_COA_ACCT_NO" ).append("\n"); 
		query.append(",    SLCC.SGM_CTNT5   LIAB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",    SLCC.SGM_CTNT6   LIAB_COA_VVD_CD" ).append("\n"); 
		query.append(",    H.PAY_STS_FLG" ).append("\n"); 
		query.append(",    TRIM(SAP_GET_CUR_AMT_FNC(H.INV_CURR_CD, H.INV_FUNC_AMT)) INV_FUNC_AMT" ).append("\n"); 
		query.append(",    H.INV_VAT_CD" ).append("\n"); 
		query.append(",    H.INV_XCH_RT" ).append("\n"); 
		query.append(",    H.INV_XCH_RT_TP_CD" ).append("\n"); 
		query.append(",    'Corporate' AS INV_XCH_RT_TP_CD_NM" ).append("\n"); 
		query.append(",    TO_CHAR(H.INV_XCH_DT, 'YYYY-MM-DD') AS INV_XCH_DT" ).append("\n"); 
		query.append(",    TO_CHAR(H.ERY_STL_DT, 'YYYY-MM-DD') AS ERY_STL_DT" ).append("\n"); 
		query.append(",    H.ATTR_CTNT1" ).append("\n"); 
		query.append(",    H.ATTR_CTNT2" ).append("\n"); 
		query.append(",    H.ATTR_CTNT3" ).append("\n"); 
		query.append(",    H.ATTR_CTNT4" ).append("\n"); 
		query.append(",    H.ATTR_CTNT5" ).append("\n"); 
		query.append(",    H.ATTR_CTNT6" ).append("\n"); 
		query.append(",    H.ATTR_CTNT7" ).append("\n"); 
		query.append(",    H.ATTR_CTNT8" ).append("\n"); 
		query.append(",    H.ATTR_CTNT9" ).append("\n"); 
		query.append(",    H.ATTR_CTNT10" ).append("\n"); 
		query.append(",    H.ATTR_CTNT11" ).append("\n"); 
		query.append(",    H.ATTR_CTNT12" ).append("\n"); 
		query.append(",    H.ATTR_CTNT13" ).append("\n"); 
		query.append(",    H.ATTR_CTNT14" ).append("\n"); 
		query.append(",    H.ATTR_CTNT15" ).append("\n"); 
		query.append(",    H.ATTR_CATE_NM" ).append("\n"); 
		query.append(",    H.AP_APSTS_CD" ).append("\n"); 
		query.append(",    TO_CHAR(H.INV_CXL_DT, 'YYYY-MM-DD') AS INV_CXL_DT" ).append("\n"); 
		query.append(",    H.CXL_USR_ID" ).append("\n"); 
		query.append(",    H.INV_CXL_AMT" ).append("\n"); 
		query.append(",    H.OFC_CD" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CATE_NM" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT1" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT2" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT3" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT4" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT5" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT6" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT7" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT8" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT9" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT10" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT11" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT12" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT13" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT14" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT15" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT16" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT17" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT18" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT19" ).append("\n"); 
		query.append(",    H.GLO_ATTR_CTNT20" ).append("\n"); 
		query.append(",    H.PAY_CURR_INV_AMT" ).append("\n"); 
		query.append(",    TO_CHAR(TO_DATE(H.GL_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS GL_DT" ).append("\n"); 
		query.append(",    H.INV_APRO_RDY_FLG" ).append("\n"); 
		query.append(",    H.DTRB_SET_SEQ" ).append("\n"); 
		query.append(",    H.XTER_BANK_ACCT_SEQ" ).append("\n"); 
		query.append(",    H.LIAB_CD_CMB_SEQ" ).append("\n"); 
		query.append(",    H.CRE_USR_ID" ).append("\n"); 
		query.append(",    H.CRE_DT" ).append("\n"); 
		query.append(",    H.UPD_USR_ID" ).append("\n"); 
		query.append(",    H.UPD_DT" ).append("\n"); 
		query.append(",    '' USR_ID" ).append("\n"); 
		query.append(",    '' CHK_FLG" ).append("\n"); 
		query.append(",    (SELECT SUM(DECODE(ACCTG_PST_FLG, 'Y', 1, 0 )) FROM SAP_INV_DTL D WHERE D.INV_SEQ = H.INV_SEQ ) AS CNT_ACCTG_PST_FLG_Y" ).append("\n"); 
		query.append(",    (SELECT NVL(DP_PRCS_KNT, 0) FROM MDM_CURRENCY M WHERE M.CURR_CD = H.INV_CURR_CD AND ROWNUM=1 ) AS INV_CURR_PRCS" ).append("\n"); 
		query.append(",    (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = H.VNDR_NO AND ROWNUM=1) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",    'Y' AS PERIOD_CHK" ).append("\n"); 
		query.append(",    (CASE WHEN H.ATTR_CTNT15 IS NULL AND H.INV_CXL_DT IS NULL THEN 'Unapproved'" ).append("\n"); 
		query.append("           WHEN H.ATTR_CTNT15 = 'Y'   AND H.INV_CXL_DT IS NULL THEN 'Approved'" ).append("\n"); 
		query.append("           WHEN H.ATTR_CTNT15 = 'N'   AND H.INV_CXL_DT IS NOT NULL THEN 'Cancelled' END) AS APPROVAL_STATUS" ).append("\n"); 
		query.append(",    (" ).append("\n"); 
		query.append("      SELECT  TRIM( SAP_GET_CUR_AMT_FNC(H.INV_CURR_CD, SUM(NVL(SID.PPAY_RMN_AMT, SID.DTRB_AMT))) ) " ).append("\n"); 
		query.append("      FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("      WHERE   SID.INV_SEQ = H.INV_SEQ" ).append("\n"); 
		query.append("      AND     SID.LINE_TP_LU_CD IN ('ITEM', 'ACCRUAL', 'REC_TAX', 'NONREC_TAX')" ).append("\n"); 
		query.append("      AND     NVL(SID.RVS_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      )  AS PREPAY_RMN_TOT_AMT    " ).append("\n"); 
		query.append(",     TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(H.INV_CURR_CD, H.INV_PAY_AMT))  INV_PAY_AMT" ).append("\n"); 
		query.append(",     (SELECT  DECODE( COUNT(D.ATTR_CTNT13), 0, 'N', 'Y') FROM SAP_INV_DTL D, SCO_LEGR_CD_CMB S WHERE H.INV_SEQ = D.INV_SEQ AND D.ATTR_CTNT13 = 'Y' AND D.DTRB_CD_CMB_SEQ = S.CD_CMB_SEQ AND S.SGM_CTNT4  = '954113' ) ASA_TRANS_YN" ).append("\n"); 
		query.append(",     DECODE(H.ATTR_CTNT12, NULL, 'N', 'Y') AS SUBMIT_FLAG" ).append("\n"); 
		query.append(",    (SELECT NVL(V.BANK_ACCT_FLG, 'N') FROM MDM_VENDOR V WHERE V.VNDR_SEQ = H.VNDR_NO AND ROWNUM=1) AS BANK_ACCT_FLG" ).append("\n"); 
		query.append("FROM SAP_INV_HDR H" ).append("\n"); 
		query.append("     ,SAP_INV_DTL D" ).append("\n"); 
		query.append("     ,SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND   H.INV_SEQ = D.INV_SEQ" ).append("\n"); 
		query.append("AND   H.LIAB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("AND   H.INV_DT BETWEEN TO_DATE(@[inv_fr_dt], 'YYYY-MM-DD') AND TO_DATE(@[inv_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#if (${inv_no} != '') " ).append("\n"); 
		query.append("AND H.INV_NO LIKE @[inv_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ap_pay_grp_lu_cd} != '') " ).append("\n"); 
		query.append("AND H.AP_PAY_GRP_LU_CD = @[ap_pay_grp_lu_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gl_fr_dt} != '') " ).append("\n"); 
		query.append("AND H.GL_DT BETWEEN TO_CHAR(TO_DATE(@[gl_fr_dt],'YYYY-MM-DD'),'YYYYMMDD') AND TO_CHAR(TO_DATE(@[gl_to_dt],'YYYY-MM-DD') + 0.99999,'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_no} != '') " ).append("\n"); 
		query.append("AND H.VNDR_NO = @[vndr_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ap_inv_src_cd} != '') " ).append("\n"); 
		query.append("AND H.AP_INV_SRC_CD = @[ap_inv_src_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt1} != '') " ).append("\n"); 
		query.append("AND D.ATTR_CTNT1 LIKE @[attr_ctnt1] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_curr_cd} != '') " ).append("\n"); 
		query.append("AND H.INV_CURR_CD = @[inv_curr_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_tp_lu_cd} != 'PREPAYMENT') " ).append("\n"); 
		query.append("AND H.INV_TP_LU_CD NOT IN ( 'PREPAYMENT' )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND H.INV_TP_LU_CD IN ( 'PREPAYMENT' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY H.INV_NO" ).append("\n"); 

	}
}