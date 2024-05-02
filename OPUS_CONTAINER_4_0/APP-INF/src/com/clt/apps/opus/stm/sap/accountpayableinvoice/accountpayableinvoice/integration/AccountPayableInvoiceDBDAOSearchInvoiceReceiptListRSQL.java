/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceReceiptListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.30 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceReceiptListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조건을 기준으로 전표 결재 이후에 지불 하기 위한 접수 대상인 Invoice Slip 내역 조회
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceReceiptListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceReceiptListRSQL").append("\n"); 
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
		query.append("SELECT  SIH.OFC_CD           AS OFC_CD" ).append("\n"); 
		query.append("      , SIH.INV_NO           AS INV_NO" ).append("\n"); 
		query.append("      , SIH.VNDR_NO          AS VNDR_NO" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM   AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , SIH.INV_CURR_CD      AS INV_CURR_CD" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SIH.INV_AMT)) AS INV_AMT" ).append("\n"); 
		query.append("      , SIH.INV_DESC         AS INV_DESC" ).append("\n"); 
		query.append("      , SIH.AP_PAY_GRP_LU_CD AS AP_PAY_GRP_LU_CD" ).append("\n"); 
		query.append("      , SPS.DUE_DT           AS DUE_DT" ).append("\n"); 
		query.append("      , SIH.PAY_MZD_LU_CD    AS PAY_MZD_LU_CD" ).append("\n"); 
		query.append("      , SIH.INV_TERM_NM      AS INV_TERM_NM" ).append("\n"); 
		query.append("      , SIH.INV_DT           AS INV_DT" ).append("\n"); 
		query.append("      , SIH.ATTR_CTNT13      AS INV_RCT_NO" ).append("\n"); 
		query.append("      , SIH.CRE_DT           AS CRE_DT" ).append("\n"); 
		query.append("      , SBB.BANK_NM          AS BANK_NM" ).append("\n"); 
		query.append("      , SBB.BANK_BRNC_NM     AS BANK_BRNC_NM" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NO     AS BANK_ACCT_NO" ).append("\n"); 
		query.append("      , SIH.INV_SEQ          AS INV_SEQ" ).append("\n"); 
		query.append("      , SPS.PAY_STS_FLG      AS PAY_STS_FLG" ).append("\n"); 
		query.append("      , SIH.GL_DT            AS GL_DT" ).append("\n"); 
		query.append("      , SIH.CRE_USR_ID       AS USR_ID" ).append("\n"); 
		query.append("      , SIH.AP_INV_SRC_CD    AS AP_INV_SRC_CD" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAP_PAY_SKD SPS" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("      , SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("      , SAP_BANK_BRNC SBB" ).append("\n"); 
		query.append("WHERE   SIH.INV_SEQ = SPS.INV_SEQ" ).append("\n"); 
		query.append("AND     SPS.ROWID = (SELECT  MAX(SPS2.ROWID)" ).append("\n"); 
		query.append("                     FROM    SAP_PAY_SKD SPS2" ).append("\n"); 
		query.append("                     WHERE   SPS2.INV_SEQ = SIH.INV_SEQ)" ).append("\n"); 
		query.append("AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("AND     SIH.OFC_CD = MO.OFC_CD " ).append("\n"); 
		query.append("AND     SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("AND     EXISTS (SELECT  'X' FROM SAP_INV_DTL SID WHERE SIH.INV_SEQ = SID.INV_SEQ AND MTCH_STS_FLG = 'A')" ).append("\n"); 
		query.append("AND     NVL(SIH.ATTR_CTNT15, 'C') <> 'N'" ).append("\n"); 
		query.append("AND     ((SIH.INV_NO LIKE '02%' AND SIH.ATTR_CTNT12 IS NOT NULL) OR (SIH.INV_NO NOT LIKE '02%' AND SIH.ATTR_CTNT15 = 'Y'))" ).append("\n"); 
		query.append("AND     SPS.XTER_BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("AND     SBA.BANK_BRNC_SEQ = SBB.BANK_BRNC_SEQ(+)" ).append("\n"); 
		query.append("AND     ((SIH.INV_AMT <> 0 AND (SELECT  NVL(SUM(SID.DTRB_AMT), 0)" ).append("\n"); 
		query.append("                                FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("                                WHERE   SIH.INV_SEQ = SID.INV_SEQ " ).append("\n"); 
		query.append("                                AND     SID.LINE_TP_LU_CD <> 'PREPAY') <> 0) OR SIH.INV_AMT = 0 )" ).append("\n"); 
		query.append("AND     SIH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND  SIH.INV_DT BETWEEN TO_DATE(@[inv_dt_fm], 'YYYY-MM-DD') AND TO_DATE(@[inv_dt_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#if (${gl_dt_fm} != '' && ${gl_dt_to} != '')" ).append("\n"); 
		query.append("   AND  SIH.GL_DT BETWEEN TO_CHAR(TO_DATE(@[gl_dt_fm],'YYYY-MM-DD'),'YYYYMMDD') AND TO_CHAR(TO_DATE(@[gl_dt_to],'YYYY-MM-DD') + 0.99999,'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ap_pay_grp_lu_cd} != '')" ).append("\n"); 
		query.append("   AND  SIH.AP_PAY_GRP_LU_CD = @[ap_pay_grp_lu_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("   AND  SIH.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_no} != '')" ).append("\n"); 
		query.append("   AND  SIH.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${rct_flg} == 'N')" ).append("\n"); 
		query.append("   AND  SIH.ATTR_CTNT13 IS NULL  -- Not Received" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND  SIH.ATTR_CTNT13 IS NOT NULL  -- Received" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${curr_flg} == 'Y')" ).append("\n"); 
		query.append("   AND  SIH.INV_CURR_CD = ( SELECT MO.AR_CURR_CD FROM MDM_ORGANIZATION MO WHERE MO.OFC_CD = @[ofc_cd] AND ROWNUM = 1)" ).append("\n"); 
		query.append("#elseif (${curr_flg} == 'N')" ).append("\n"); 
		query.append("   AND  SIH.INV_CURR_CD <> ( SELECT MO.AR_CURR_CD FROM MDM_ORGANIZATION MO WHERE MO.OFC_CD = @[ofc_cd] AND ROWNUM = 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pay_sts_flg} != '')" ).append("\n"); 
		query.append("   AND  SIH.PAY_STS_FLG = @[pay_sts_flg]   -- Y : PAID, N : UNPAID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND  NVL(SIH.ATTR_CTNT15, 'N') = @[attr_ctnt15]   -- Y : Approve" ).append("\n"); 

	}
}