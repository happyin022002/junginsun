/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeCalculationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.11
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2014.11.11 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
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
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
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
		query.append("SELECT -- CHARGE" ).append("\n"); 
		query.append("		'' AS SRC_IF_DT" ).append("\n"); 
		query.append("	   ,'' AS SRC_IF_SEQ" ).append("\n"); 
		query.append("	   ,'' AS CHG_SEQ" ).append("\n"); 
		query.append("       ,C.BZC_TRF_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("       ,CASE WHEN A.DMDT_TRF_CD = 'DMIF' THEN 'DEM'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DMOF' THEN 'DEM'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DTOC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DTIC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'CTOC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'CTIC' THEN 'DET'" ).append("\n"); 
		query.append("        END AS CHG_CD" ).append("\n"); 
		query.append("       ,B.CNTR_TPSZ_CD AS PER_TP_CD" ).append("\n"); 
		query.append("       ,B.CNTR_NO AS TRF_NO" ).append("\n"); 
		query.append("       ,CASE WHEN A.TAX_AMT <> 0 THEN 'Y'" ).append("\n"); 
		query.append("        END AS TVA_FLG" ).append("\n"); 
		query.append("       ,B.CRE_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(B.CRE_DT,'yyyymmdd') AS CRE_DT" ).append("\n"); 
		query.append("       ,B.UPD_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(B.UPD_DT,'yyyymmdd') AS UPD_DT" ).append("\n"); 
		query.append("       -- G Basic Tariff" ).append("\n"); 
		query.append("       ,B.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("       ,B.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("       ,B.CNTR_CYC_NO AS CNTR_CYC_NO" ).append("\n"); 
		query.append("       ,B.DMDT_TRF_CD AS DMDT_TRF_CD" ).append("\n"); 
		query.append("       ,B.DMDT_CHG_LOC_DIV_CD AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("       ,B.CHG_SEQ" ).append("\n"); 
		query.append("       ,C.DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("       ,C.BZC_TRF_SEQ" ).append("\n"); 
		query.append("       ,C.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("       ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,B.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("	   ,C.ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("       ,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("       -- B BEFORE CALCULATION" ).append("\n"); 
		query.append("       ,C.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("       ,C.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("       ,C.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("       ,C.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("       -- S SC EXPTION" ).append("\n"); 
		query.append("       ,C.SC_NO" ).append("\n"); 
		query.append("       ,C.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("       ,C.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("	   -- " ).append("\n"); 
		query.append("	   ,B.INV_DTL_SEQ" ).append("\n"); 
		query.append("	   ,B.CRE_OFC_CD" ).append("\n"); 
		query.append("	   ,A.INV_XCH_RT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,NVL(C.SC_RFA_EXPT_AMT,0) AS SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("	   ,NVL(C.AFT_EXPT_DC_AMT,0) AS AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	   ,NVL(C.CMDT_EXPT_AMT,0)   AS CMDT_EXPT_AMT" ).append("\n"); 
		query.append("	   ,C.DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append("	   ,C.OFC_TRNS_FLG" ).append("\n"); 
		query.append("FROM DMT_INV_MN A, DMT_INV_DTL B, DMT_CHG_CALC C" ).append("\n"); 
		query.append("WHERE A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = B.CRE_OFC_CD" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND B.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND B.CHG_SEQ = C.CHG_SEQ" ).append("\n"); 
		query.append("AND A.DMDT_INV_NO = @[invoice_no]" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 

	}
}