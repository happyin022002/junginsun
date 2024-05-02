/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchMGSInvoiceInqListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.08 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOsearchMGSInvoiceInqListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091228 2036 start.
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchMGSInvoiceInqListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_fm_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_to_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchMGSInvoiceInqListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("T1.PAY_INV_SEQ                              AS PAY_INV_SEQ" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(T1.COST_YRMON,'YYYYMM'),'YYYY-MM')    AS COST_YRMON" ).append("\n"); 
		query.append(", T2.AP_IF_DT                               AS AP_IF_DT" ).append("\n"); 
		query.append("#if (${cost_yrmon} == 'cost_month')" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(T1.COST_YRMON,'YYYYMM'),'YYYY-MM')	AS INVOICE_DATE" ).append("\n"); 
		query.append("#elseif (${cost_yrmon} == 'issue_date')" ).append("\n"); 
		query.append(", TO_CHAR(T2.INV_ISS_DT,'YYYY-MM')          AS INVOICE_DATE" ).append("\n"); 
		query.append("#elseif (${cost_yrmon} == 'receive_date')" ).append("\n"); 
		query.append(", TO_CHAR(T2.INV_RCV_DT,'YYYY-MM')          AS INVOICE_DATE" ).append("\n"); 
		query.append("#elseif (${cost_yrmon} == 'confirm_date')" ).append("\n"); 
		query.append(", TO_CHAR(T2.INV_CFM_DT,'YYYY-MM')          AS INVOICE_DATE" ).append("\n"); 
		query.append("#elseif (${cost_yrmon} == 'payment_date')" ).append("\n"); 
		query.append(", TO_CHAR(T2.AP_IF_DT,'YYYY-MM')            AS INVOICE_DATE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", T1.COST_OFC_CD                            AS COST_OFC_CD" ).append("\n"); 
		query.append(", T1.CRE_USR_ID                             AS CRE_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_csr_no_chk} == 'inv_no')" ).append("\n"); 
		query.append(", T1.INV_NO                                 AS INV_CSR_NO" ).append("\n"); 
		query.append("#elseif (${inv_csr_no_chk} == 'csr_no')" ).append("\n"); 
		query.append(", T2.CSR_NO                                 AS INV_CSR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", T1.CHSS_MGST_INV_STS_CD                   AS CHSS_MGST_INV_STS_CD" ).append("\n"); 
		query.append(", T1.CHSS_MGST_INV_KND_CD                   AS CHSS_MGST_INV_KND_CD" ).append("\n"); 
		query.append(", T1.VNDR_SEQ                               AS VNDR_SEQ" ).append("\n"); 
		query.append(", NVL(T4.VNDR_ABBR_NM,T1.VNDR_SEQ)			AS VNDR_NM" ).append("\n"); 
		query.append(", T1.INV_NO                                 AS INV_NO" ).append("\n"); 
		query.append(", T2.CSR_NO                                 AS CSR_NO" ).append("\n"); 
		query.append(", CASE WHEN T2.INV_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("THEN T2.INV_STS_CD" ).append("\n"); 
		query.append("ELSE T1.CHSS_MGST_INV_STS_CD END     AS INV_STS_CD" ).append("\n"); 
		query.append(", CASE WHEN T2.INV_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM  COM_INTG_CD_DTL A" ).append("\n"); 
		query.append("WHERE  'CD02355' = A.INTG_CD_ID" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = T2.INV_STS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM  COM_INTG_CD_DTL A" ).append("\n"); 
		query.append("WHERE  'CD02355' = A.INTG_CD_ID" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = T1.CHSS_MGST_INV_STS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END     AS INV_STS_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", T1.COST_YRMON                             AS COST_YRMON" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", T1.REV_VSL_CD" ).append("\n"); 
		query.append("|| T1.REV_SKD_VOY_NO" ).append("\n"); 
		query.append("|| T1.REV_SKD_DIR_CD" ).append("\n"); 
		query.append("|| T1.REV_DIR_CD                        AS REV_VVD" ).append("\n"); 
		query.append(", T1.CHG_SMRY_AMT                           AS CHG_SMRY_AMT" ).append("\n"); 
		query.append(", T1.INV_TAX_CLT_TP_CD                      AS INV_TAX_CLT_TP_CD" ).append("\n"); 
		query.append(", T1.INV_TAX_RT                             AS INV_TAX_RT" ).append("\n"); 
		query.append(", T1.INV_SMRY_AMT                           AS INV_SMRY_AMT" ).append("\n"); 
		query.append(", TO_CHAR(T2.INV_ISS_DT,'YYYY-MM-DD')       AS INV_ISS_DT" ).append("\n"); 
		query.append(", TO_CHAR(T2.INV_RCV_DT,'YYYY-MM-DD')       AS INV_RCV_DT" ).append("\n"); 
		query.append(", TO_CHAR(T2.INV_CFM_DT,'YYYY-MM-DD')       AS INV_CFM_DT" ).append("\n"); 
		query.append(", T3.USR_NM                                 AS USR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_PAY_INV T1, AP_PAY_INV T2, COM_USER T3, MDM_VENDOR T4" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("T1.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("AND T1.INV_RGST_NO = T2.INV_RGST_NO(+)" ).append("\n"); 
		query.append("AND T1.CRE_USR_ID = T3.USR_ID(+)" ).append("\n"); 
		query.append("AND T1.VNDR_SEQ = T4.VNDR_SEQ(+)" ).append("\n"); 
		query.append("#if (${cost_yrmon} == 'cost_month')" ).append("\n"); 
		query.append("AND T1.COST_YRMON >= REPLACE(@[inv_fm_date],'-','') AND T1.COST_YRMON <= REPLACE(@[inv_to_date],'-','')" ).append("\n"); 
		query.append("#elseif (${cost_yrmon} == 'issue_date')" ).append("\n"); 
		query.append("AND T2.INV_ISS_DT BETWEEN TO_DATE(REPLACE(@[inv_fm_date],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[inv_to_date],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${cost_yrmon} == 'receive_date')" ).append("\n"); 
		query.append("AND T2.INV_RCV_DT BETWEEN TO_DATE(REPLACE(@[inv_fm_date],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[inv_to_date],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${cost_yrmon} == 'confirm_date')" ).append("\n"); 
		query.append("AND T2.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[inv_fm_date],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[inv_to_date],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${cost_yrmon} == 'payment_date')" ).append("\n"); 
		query.append("AND T2.AP_IF_DT BETWEEN TO_DATE(REPLACE(@[inv_fm_date],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[inv_to_date],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("AND T1.COST_OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("AND T1.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chss_mgst_inv_knd_cd} != '')" ).append("\n"); 
		query.append("AND T1.CHSS_MGST_INV_KND_CD IN ($chss_mgst_inv_knd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND T1.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_csr_no_chk} == 'inv_no')" ).append("\n"); 
		query.append("#if (${inv_csr_no} != '')" ).append("\n"); 
		query.append("AND T1.INV_NO IN ($inv_csr_no)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${inv_csr_no_chk} == 'csr_no')" ).append("\n"); 
		query.append("#if (${inv_csr_no} != '')" ).append("\n"); 
		query.append("AND T2.CSR_NO IN ($inv_csr_no)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_status} == 'S')" ).append("\n"); 
		query.append("AND T1.CHSS_MGST_INV_STS_CD = 'S'" ).append("\n"); 
		query.append("#elseif (${inv_status} == 'C')" ).append("\n"); 
		query.append("AND T2.INV_STS_CD = 'C'" ).append("\n"); 
		query.append("#elseif (${inv_status} == 'A')" ).append("\n"); 
		query.append("AND T2.INV_STS_CD = 'A'" ).append("\n"); 
		query.append("#elseif (${inv_status} == 'P')" ).append("\n"); 
		query.append("AND T2.INV_STS_CD = 'P'" ).append("\n"); 
		query.append("#elseif (${inv_status} == 'D')" ).append("\n"); 
		query.append("AND T2.INV_STS_CD = 'D'" ).append("\n"); 
		query.append("#elseif (${inv_status} == 'R')" ).append("\n"); 
		query.append("AND T2.INV_STS_CD = 'R'" ).append("\n"); 
		query.append("#elseif (${inv_status} == 'E')" ).append("\n"); 
		query.append("AND T2.INV_STS_CD = 'E'" ).append("\n"); 
		query.append("#elseif (${inv_status} == 'J')" ).append("\n"); 
		query.append("AND T2.INV_STS_CD = 'J'" ).append("\n"); 
		query.append("#elseif (${inv_status} == 'X')" ).append("\n"); 
		query.append("AND T2.INV_STS_CD = 'X'" ).append("\n"); 
		query.append("#elseif (${inv_status} == 'B')" ).append("\n"); 
		query.append("AND T2.INV_STS_CD = 'B'" ).append("\n"); 
		query.append("#elseif (${inv_status} == 'G')" ).append("\n"); 
		query.append("AND T2.INV_STS_CD = 'G'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}