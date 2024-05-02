/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSChargeCreationResultDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.04.28 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSChargeCreationResultDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015-02 [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
	  * 2015 조직코드개편 Chang-Young Kim
	  * CHM-201640236 COPS INVOICE 생성시 INVOICE 표기 로직 변경 version no에 해당하는 데이터 출력으로 변경
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSChargeCreationResultDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSChargeCreationResultDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("   FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("  WHERE INTG_CD_ID = 'CD01944'" ).append("\n"); 
		query.append("	AND INTG_CD_VAL_CTNT = A.LSE_CHG_STS_CD) LSE_CHG_STS_DESC," ).append("\n"); 
		query.append("  LSE_CHG_STS_CD," ).append("\n"); 
		query.append("  LSE_CHG_SMRY_AMT," ).append("\n"); 
		query.append("  INV_SMRY_AMT," ).append("\n"); 
		query.append("  INV_CR_AMT_DTL," ).append("\n"); 
		query.append("  PAY_LSE_CHG_AMT," ).append("\n"); 
		query.append("  DEBIT_AMT," ).append("\n"); 
		query.append("  CR_SMRY_AMT," ).append("\n"); 
		query.append("  TAX_SMRY_AMT," ).append("\n"); 
		query.append("  CRE_OFC_CD," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  CHG_CRE_SEQ," ).append("\n"); 
		query.append("  COST_YRMON_SEQ," ).append("\n"); 
		query.append("  ORG_INV_NO," ).append("\n"); 
		query.append("  INV_NO," ).append("\n"); 
		query.append("  AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("  AGMT_SEQ," ).append("\n"); 
		query.append("  ( SELECT AGMT_REF_NO FROM CGM_AGREEMENT" ).append("\n"); 
		query.append("     WHERE AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("       AND AGMT_SEQ        = @[agmt_seq]" ).append("\n"); 
		query.append("       AND AGMT_VER_NO     = A.AGMT_VER_NO ) AS AGMT_REF_NO," ).append("\n"); 
		query.append("  CHSS_COP_INV_TP_CD," ).append("\n"); 
		query.append("  AGMT_VER_NO," ).append("\n"); 
		query.append("  ( SELECT LST_VER_FLG FROM CGM_AGREEMENT" ).append("\n"); 
		query.append("     WHERE AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("       AND AGMT_SEQ        = @[agmt_seq]" ).append("\n"); 
		query.append("       AND AGMT_VER_NO     = A.AGMT_VER_NO) AS LST_VER_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("MAX(A.LSE_CHG_STS_CD) AS LSE_CHG_STS_CD," ).append("\n"); 
		query.append("SUM(B.LSE_CHG_AMT) AS LSE_CHG_SMRY_AMT," ).append("\n"); 
		query.append("--SUM(" ).append("\n"); 
		query.append("--CASE WHEN B.LSE_CHG_AUD_STS_CD IS NOT NULL THEN NVL( B.INV_LSE_CHG_AMT,0) + NVL(B.INV_TAX_AMT,0) - ABS(NVL(B.INV_CR_AMT,0)) " ).append("\n"); 
		query.append("--     ELSE 0" ).append("\n"); 
		query.append("--     END" ).append("\n"); 
		query.append("--)  INV_SMRY_AMT ," ).append("\n"); 
		query.append("-- 2015.03.20 Chang Young Kim Load, Audit을 거치지않은 데이터(lse_chg_aud_sts_cd is NULL)도 금액을 보여달라는 요청 ( by PHXSA 지연차장 )" ).append("\n"); 
		query.append("SUM( NVL(B.INV_LSE_CHG_AMT,0) + NVL(B.INV_TAX_AMT,0) - ABS(NVL(B.INV_CR_AMT,0))) AS INV_SMRY_AMT ," ).append("\n"); 
		query.append("SUM( NVL(B.INV_TAX_AMT,0) ) AS INV_TAX_AMT_DTL," ).append("\n"); 
		query.append("SUM( NVL(B.INV_CR_AMT ,0) ) AS INV_CR_AMT_DTL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM (CASE WHEN B.PAY_LSE_CHG_STS_CD = 'C' AND A.LSE_CHG_STS_CD IN ('S','C')  THEN" ).append("\n"); 
		query.append("        NVL( B.PAY_LSE_CHG_AMT,0) + NVL(B.PAY_TAX_AMT,0) - ABS(NVL(B.PAY_CR_AMT,0))  " ).append("\n"); 
		query.append("     ELSE 0 END   ) PAY_LSE_CHG_AMT," ).append("\n"); 
		query.append("SUM (CASE WHEN B.PAY_LSE_CHG_STS_CD = 'C' AND A.LSE_CHG_STS_CD IN ('S','C') THEN" ).append("\n"); 
		query.append("        NVL( B.PAY_LSE_CHG_AMT,0) " ).append("\n"); 
		query.append("     ELSE 0 END   ) DEBIT_AMT," ).append("\n"); 
		query.append("SUM (CASE WHEN B.PAY_LSE_CHG_STS_CD = 'C' AND A.LSE_CHG_STS_CD IN ('S','C') THEN" ).append("\n"); 
		query.append("        ABS(NVL(B.PAY_CR_AMT,0))  " ).append("\n"); 
		query.append("     ELSE 0 END   ) CR_SMRY_AMT," ).append("\n"); 
		query.append("SUM (CASE WHEN B.PAY_LSE_CHG_STS_CD = 'C' AND A.LSE_CHG_STS_CD IN ('S','C') THEN" ).append("\n"); 
		query.append("        NVL(B.PAY_TAX_AMT,0) " ).append("\n"); 
		query.append("     ELSE 0 END   ) TAX_SMRY_AMT," ).append("\n"); 
		query.append("MAX(A.CRE_OFC_CD) AS CRE_OFC_CD," ).append("\n"); 
		query.append("MAX(A.CRE_USR_ID) AS CRE_USR_ID," ).append("\n"); 
		query.append("MAX(TO_CHAR(A.CRE_DT, 'YYYY-MM-DD')) AS CRE_DT," ).append("\n"); 
		query.append("A.CHG_CRE_SEQ," ).append("\n"); 
		query.append("A.COST_YRMON_SEQ," ).append("\n"); 
		query.append("MAX(A.ORG_INV_NO)       ORG_INV_NO," ).append("\n"); 
		query.append("MAX(A.INV_NO)           INV_NO," ).append("\n"); 
		query.append("MAX(A.AGMT_OFC_CTY_CD)  AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("MAX(A.AGMT_SEQ)         AGMT_SEQ," ).append("\n"); 
		query.append("MAX(A.CHSS_COP_INV_TP_CD) CHSS_COP_INV_TP_CD," ).append("\n"); 
		query.append("A.AGMT_VER_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM CGM_LSE_CHG_HDR A , CGM_LSE_CHG_DTL B" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND A.COST_YRMON = B.COST_YRMON(+)" ).append("\n"); 
		query.append("AND A.COST_YRMON_SEQ = B.COST_YRMON_SEQ(+)" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND B.EQ_KND_CD(+) = @[eq_knd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("#if(${agmt_ver_no} != '')" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.CHG_CRE_SEQ, A.COST_YRMON_SEQ, A.AGMT_VER_NO) A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.COST_YRMON_SEQ" ).append("\n"); 

	}
}