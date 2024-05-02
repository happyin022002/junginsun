/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeCalculationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeCalculationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculation 조회 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeCalculationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_tax_appl_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeCalculationRSQL").append("\n"); 
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
		query.append("SELECT  '' 										AS SRC_IF_DT" ).append("\n"); 
		query.append("       ,'' 										AS SRC_IF_SEQ" ).append("\n"); 
		query.append("       ,'' 										AS CHG_SEQ" ).append("\n"); 
		query.append("       ,T3.BZC_TRF_CURR_CD 						AS CURR_CD" ).append("\n"); 
		query.append("	   ,DECODE(SUBSTR(T1.DMDT_TRF_CD, 1, 2), 'DM', 'DMR', 'DT', 'DTC', 'CT', 'DTC', '')		AS CHG_CD" ).append("\n"); 
		query.append("       ,T2.CNTR_TPSZ_CD 						AS PER_TP_CD" ).append("\n"); 
		query.append("       ,T2.CNTR_NO 								AS TRF_NO" ).append("\n"); 
		query.append("	   ,DECODE(T1.TAX_AMT, 0, 'N', 'Y') 		AS TVA_FLG" ).append("\n"); 
		query.append("       ,T2.CRE_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(T2.CRE_DT,'yyyymmdd') 			AS CRE_DT" ).append("\n"); 
		query.append("       ,T2.UPD_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(T2.UPD_DT,'yyyymmdd') 			AS UPD_DT" ).append("\n"); 
		query.append("       -- G Basic Tariff" ).append("\n"); 
		query.append("       ,T2.SYS_AREA_GRP_ID 						AS SVR_ID" ).append("\n"); 
		query.append("       ,T2.CNTR_NO 								AS CNTR_NO" ).append("\n"); 
		query.append("       ,T2.CNTR_CYC_NO 							AS CNTR_CYC_NO" ).append("\n"); 
		query.append("       ,T2.DMDT_TRF_CD 							AS DMDT_TRF_CD" ).append("\n"); 
		query.append("       ,T2.DMDT_CHG_LOC_DIV_CD 					AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("       ,T2.CHG_SEQ" ).append("\n"); 
		query.append("       ,T3.DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("       ,T3.BZC_TRF_SEQ" ).append("\n"); 
		query.append("       ,NVL(T3.BZC_DMDT_DE_TERM_CD, 'N')		AS BZC_DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("       ,T3.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("       ,T2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,T2.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("       ,T3.ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("       ,T3.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("       -- B BEFORE CALCULATION" ).append("\n"); 
		query.append("       ,T3.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("       ,T3.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("       ,T3.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("       ,T3.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("       -- S SC EXPTION" ).append("\n"); 
		query.append("       ,T3.SC_NO" ).append("\n"); 
		query.append("       ,T3.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("       ,T3.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("       ,T2.INV_DTL_SEQ" ).append("\n"); 
		query.append("       ,T2.CRE_OFC_CD" ).append("\n"); 
		query.append("       ,T1.INV_XCH_RT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       ,NVL(T3.SC_RFA_EXPT_AMT,0) 				AS SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("       ,NVL(T3.AFT_EXPT_DC_AMT,0) 				AS AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("       ,NVL(T3.CMDT_EXPT_AMT,0)   				AS CMDT_EXPT_AMT" ).append("\n"); 
		query.append("       ,T3.DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append("       ,T3.OFC_TRNS_FLG" ).append("\n"); 
		query.append("       ,T3.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(T3.BZC_TRF_APLY_DT    , 'YYYY-MM-DD')	AS BZC_TRF_APLY_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(T3.SC_RFA_EXPT_APLY_DT, 'YYYY-MM-DD')	AS SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	   ,CASE " ).append("\n"); 
		query.append("			-- 인도 TAX 변경 후에는 SBC AMOUNT 가 존재하지 않음." ).append("\n"); 
		query.append("			WHEN @[ida_tax_appl_tm] = 'A'" ).append("\n"); 
		query.append("				THEN 'N'" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("					WHEN NVL(T1.IDA_LOCL_TAX,0) <> 0 " ).append("\n"); 
		query.append("						THEN 'Y'" ).append("\n"); 
		query.append("					ELSE 'N'" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("		END 									AS SBC_FLG" ).append("\n"); 
		query.append("	   ,CASE " ).append("\n"); 
		query.append("			-- 인도 TAX 변경 후에는 KKC AMOUNT 가 존재하지 않음." ).append("\n"); 
		query.append("			WHEN @[ida_tax_appl_tm] = 'A'" ).append("\n"); 
		query.append("				THEN 'N'" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("					WHEN NVL(T1.IDA_N2ND_LOCL_TAX,0) <> 0 " ).append("\n"); 
		query.append("						THEN 'Y'" ).append("\n"); 
		query.append("					ELSE 'N'" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("		END 									AS KKC_FL" ).append("\n"); 
		query.append("		  " ).append("\n"); 
		query.append("  FROM  DMT_INV_MN      T1" ).append("\n"); 
		query.append("       ,DMT_INV_DTL     T2" ).append("\n"); 
		query.append("	   ,DMT_CHG_CALC    T3" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append(" WHERE  T1.DMDT_INV_NO           = T2.DMDT_INV_NO" ).append("\n"); 
		query.append("   AND  T1.CRE_OFC_CD            = T2.CRE_OFC_CD" ).append("\n"); 
		query.append("   AND  T2.SYS_AREA_GRP_ID       = T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   AND  T2.CNTR_NO               = T3.CNTR_NO" ).append("\n"); 
		query.append("   AND  T2.CNTR_CYC_NO           = T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("   AND  T2.DMDT_TRF_CD           = T3.DMDT_TRF_CD" ).append("\n"); 
		query.append("   AND  T2.DMDT_CHG_LOC_DIV_CD   = T3.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   AND  T2.CHG_SEQ               = T3.CHG_SEQ" ).append("\n"); 
		query.append("   AND  T1.DMDT_INV_NO           = @[invoice_no]" ).append("\n"); 
		query.append("   AND  T1.CRE_OFC_CD            = @[cre_ofc_cd]" ).append("\n"); 

	}
}