/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddBatchPaymentHeaderAllInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.11 
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

public class AccountPayablePaymentDBDAOAddBatchPaymentHeaderAllInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBatchPaymentHeaderAllInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddBatchPaymentHeaderAllInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("doc_first_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loop_index",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddBatchPaymentHeaderAllInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_PAY_HDR" ).append("\n"); 
		query.append("(   PAY_SEQ" ).append("\n"); 
		query.append("  , BANK_ACCT_SEQ" ).append("\n"); 
		query.append("  , BANK_ACCT_NM" ).append("\n"); 
		query.append("  , PAY_DT" ).append("\n"); 
		query.append("  , PAY_NO" ).append("\n"); 
		query.append("  , PAY_TP_CD" ).append("\n"); 
		query.append("  , PAY_AMT" ).append("\n"); 
		query.append("  , CURR_CD" ).append("\n"); 
		query.append("  , PAY_MZD_LU_CD" ).append("\n"); 
		query.append("  , PAY_ADDR1" ).append("\n"); 
		query.append("  , PAY_ADDR2" ).append("\n"); 
		query.append("  , PAY_BAT_NM" ).append("\n"); 
		query.append("  , PAY_CTY_CD" ).append("\n"); 
		query.append("  , PAY_CNT_CD" ).append("\n"); 
		query.append("  , PAY_STS_LU_CD" ).append("\n"); 
		query.append("  , VNDR_NM" ).append("\n"); 
		query.append("  , PAY_ZIP_CD" ).append("\n"); 
		query.append("  , BANK_ACCT_NO" ).append("\n"); 
		query.append("  , BANK_ACCT_TP_NM" ).append("\n"); 
		query.append("  , DOC_SEQ" ).append("\n"); 
		query.append("  , PAY_STE_NM" ).append("\n"); 
		query.append("  , PAY_VOID_DT" ).append("\n"); 
		query.append("  , ATTR_CATE_CTNT" ).append("\n"); 
		query.append("  , ATTR_CTNT1" ).append("\n"); 
		query.append("  , ATTR_CTNT2" ).append("\n"); 
		query.append("  , ATTR_CTNT3" ).append("\n"); 
		query.append("  , ATTR_CTNT4" ).append("\n"); 
		query.append("  , ATTR_CTNT5" ).append("\n"); 
		query.append("  , ATTR_CTNT6" ).append("\n"); 
		query.append("  , ATTR_CTNT7" ).append("\n"); 
		query.append("  , ATTR_CTNT8" ).append("\n"); 
		query.append("  , ATTR_CTNT9" ).append("\n"); 
		query.append("  , ATTR_CTNT10" ).append("\n"); 
		query.append("  , ATTR_CTNT11" ).append("\n"); 
		query.append("  , ATTR_CTNT12" ).append("\n"); 
		query.append("  , ATTR_CTNT13" ).append("\n"); 
		query.append("  , ATTR_CTNT14" ).append("\n"); 
		query.append("  , ATTR_CTNT15" ).append("\n"); 
		query.append("  , FTU_PAY_DUE_DT" ).append("\n"); 
		query.append("  , VNDR_NO" ).append("\n"); 
		query.append("  , PAY_XCH_RT" ).append("\n"); 
		query.append("  , PAY_XCH_DT" ).append("\n"); 
		query.append("  , XCH_RT_TP_CD" ).append("\n"); 
		query.append("  , PAY_FUNC_AMT" ).append("\n"); 
		query.append("  , PAY_BAT_RUN_SEQ" ).append("\n"); 
		query.append("  , GLO_ATTR_CATE_CTNT" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT19" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT20" ).append("\n"); 
		query.append("  , XTER_BANK_ACCT_SEQ" ).append("\n"); 
		query.append("  , PAY_DESC" ).append("\n"); 
		query.append("  , IBAN_NO" ).append("\n"); 
		query.append("  , OFC_CD" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  @[pay_seq]                   AS PAY_SEQ" ).append("\n"); 
		query.append("      , SISC.BANK_ACCT_SEQ           AS BANK_ACCT_SEQ" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NM             AS BANK_ACCT_NM" ).append("\n"); 
		query.append("      , SISC.PAY_DT                  AS PAY_DT" ).append("\n"); 
		query.append("      , @[doc_first_no] + @[loop_index] - 1  AS PAY_NO -- (Loop는 Vendor별 Summary 처리한 배열의 Index 값)" ).append("\n"); 
		query.append("      , 'B'                          AS PAY_TP_CD" ).append("\n"); 
		query.append("      , @[pay_amt]                   AS PAY_AMT" ).append("\n"); 
		query.append("      , SISC.PAY_CURR_CD             AS PAY_CURR_CD" ).append("\n"); 
		query.append("      , SISC.PAY_MZD_LU_CD           AS PAY_MZD_LU_CD" ).append("\n"); 
		query.append("      , MV.ENG_ADDR                  AS PAY_ADDR1" ).append("\n"); 
		query.append("      , MV.LOCL_LANG_ADDR            AS PAY_ADDR2" ).append("\n"); 
		query.append("      , SISC.PAY_BAT_NM              AS PAY_BAT_NM" ).append("\n"); 
		query.append("      , SSI.AP_CTY_CD                AS PAY_CTY_CD" ).append("\n"); 
		query.append("      , SSI.AP_CNT_CD                AS PAY_CNT_CD" ).append("\n"); 
		query.append("      , 'NEGOTIABLE'                 AS PAY_STS_LU_CD" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM           AS VNDR_NM" ).append("\n"); 
		query.append("      , SSI.ZIP_CD                   AS PAY_ZIP_CD" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NO             AS BANK_ACCT_NO" ).append("\n"); 
		query.append("      , ''                           AS BANK_ACCT_TP_NM" ).append("\n"); 
		query.append("      , SAP_PAY_HDR_DOC_SEQ.NEXTVAL  AS DOC_SEQ" ).append("\n"); 
		query.append("      , ''                           AS PAY_STE_NM" ).append("\n"); 
		query.append("      , ''                           AS PAY_VOID_DT" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CATE_CTNT" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT1" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT2" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT3" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT4" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT5" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT6" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT7" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT8" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT9" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT10" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT11" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT12" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT13" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT14" ).append("\n"); 
		query.append("      , ''                           AS ATTR_CTNT15" ).append("\n"); 
		query.append("      , ''                           AS FTU_PAY_DUE_DT" ).append("\n"); 
		query.append("      , SSI.VNDR_NO                  AS VNDR_NO" ).append("\n"); 
		query.append("      , DECODE(SISC.PAY_CURR_CD, @[functional_currency], 1, SISC.PAY_XCH_RT)              AS PAY_XCH_RT" ).append("\n"); 
		query.append("      , DECODE(SISC.PAY_CURR_CD, @[functional_currency], TO_CHAR(SISC.PAY_DT, 'YYYYMMDD'), TO_CHAR(SISC.PAY_XCH_DT, 'YYYYMMDD')) AS PAY_XCH_DT" ).append("\n"); 
		query.append("      , SSI.PAY_XCH_RT_TP_CD         AS XCH_RT_TP_CD" ).append("\n"); 
		query.append("      , DECODE(SISC.PAY_XCH_RT, NULL, ROUND(@[pay_amt], (SELECT NVL(MC.DP_PRCS_KNT, 0) FROM MDM_CURRENCY MC WHERE MC.CURR_CD = @[functional_currency]))," ).append("\n"); 
		query.append("               ROUND(@[pay_amt] * SISC.PAY_XCH_RT, (SELECT NVL(MC.DP_PRCS_KNT, 0) FROM MDM_CURRENCY MC WHERE MC.CURR_CD = @[functional_currency]))) AS PAY_FUNC_AMT" ).append("\n"); 
		query.append("      , SSI.PAY_BAT_SEQ              AS PAY_BAT_RUN_SEQ" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CATE_CTNT" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT19" ).append("\n"); 
		query.append("      , ''                           AS GLO_ATTR_CTNT20" ).append("\n"); 
		query.append("      , SSI.XTER_BANK_ACCT_SEQ       AS XTER_BANK_ACCT_SEQ" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM           AS PAY_DESC" ).append("\n"); 
		query.append("      , SBA.IBAN_NO                  AS IBAN_NO" ).append("\n"); 
		query.append("      , SISC.OFC_CD                  AS OFC_CD" ).append("\n"); 
		query.append("      , @[usr_id]                    AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                      AS CRE_DT" ).append("\n"); 
		query.append("      , @[usr_id]                    AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                      AS UPD_DT" ).append("\n"); 
		query.append("FROM    SAP_SEL_INV SSI" ).append("\n"); 
		query.append("      , SAP_INV_SEL_CRTE SISC" ).append("\n"); 
		query.append("      , SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE   SSI.PAY_BAT_SEQ = SISC.PAY_BAT_SEQ" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_NM = SISC.PAY_BAT_NM " ).append("\n"); 
		query.append("AND     SISC.BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ " ).append("\n"); 
		query.append("AND     TO_NUMBER(SSI.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_SEQ = @[pay_bat_seq]" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_NM = @[pay_bat_nm]" ).append("\n"); 
		query.append("AND     SSI.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

	}
}