/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceIssueManualRDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.24 
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

public class InvoiceIssueCollectionMgtDBDAOSearchInvoiceIssueManualRDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MANUAL INVOICE RD DETAIL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInvoiceIssueManualRDRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceIssueManualRDRSQL").append("\n"); 
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
		query.append("SELECT  INV_DTL.CNTR_NO                        " ).append("\n"); 
		query.append("    ,   INV_DTL.CNTR_TPSZ_CD                       " ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FM_MVMT_DT, 'YYYYMMDD') AS FM_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.TO_MVMT_DT, 'YYYYMMDD') AS TO_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FT_CMNC_DT, 'YYYYMMDD') AS FT_CMNC_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FT_END_DT, 'YYYYMMDD') AS FT_END_DT" ).append("\n"); 
		query.append("    ,   INV_DTL.FT_DYS                          " ).append("\n"); 
		query.append("    ,   INV_RT.FT_OVR_DYS || '-' || INV_RT.FT_UND_DYS AS FT_OVR_UND_DYS     " ).append("\n"); 
		query.append("    ,   INV_RT.INV_RT_AMT                         " ).append("\n"); 
		query.append("    ,   INV_RT.RT_OVR_DYS                        " ).append("\n"); 
		query.append("    ,   INV_RT.RT_OVR_CHG_AMT AS INV_AMOUNT                " ).append("\n"); 
		query.append("    ,   INV_RT.BZC_CURR_CD AS CHG_CURR_CD                " ).append("\n"); 
		query.append("FROM    DMT_INV_MN  INV_MN                       " ).append("\n"); 
		query.append("    ,   DMT_INV_DTL INV_DTL                        " ).append("\n"); 
		query.append("    ,   DMT_INV_RT  INV_RT                         " ).append("\n"); 
		query.append("WHERE   INV_MN.DMDT_INV_NO  = @[invoice_no]   " ).append("\n"); 
		query.append("    AND INV_MN.CRE_OFC_CD   = @[cre_ofc_cd]                        " ).append("\n"); 
		query.append("    AND INV_MN.DMDT_INV_NO  = INV_DTL.DMDT_INV_NO             " ).append("\n"); 
		query.append("    AND INV_MN.CRE_OFC_CD   = INV_DTL.CRE_OFC_CD             " ).append("\n"); 
		query.append("    AND INV_DTL.DMDT_INV_NO = INV_RT.DMDT_INV_NO             " ).append("\n"); 
		query.append("    AND INV_DTL.CRE_OFC_CD  = INV_RT.CRE_OFC_CD             " ).append("\n"); 
		query.append("    AND INV_DTL.INV_DTL_SEQ = INV_RT.INV_DTL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND NVL(( SELECT SUM(RT_OVR_CHG_AMT) FROM DMT_INV_RT " ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("            AND INV_MN.DMDT_INV_NO  = DMDT_INV_NO             " ).append("\n"); 
		query.append("            AND INV_MN.CRE_OFC_CD   = CRE_OFC_CD ), 0) = INV_MN.BIL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  INV_DTL.CNTR_NO                        " ).append("\n"); 
		query.append("    ,   INV_DTL.CNTR_TPSZ_CD                       " ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FM_MVMT_DT, 'YYYYMMDD') AS FM_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.TO_MVMT_DT, 'YYYYMMDD') AS TO_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FT_CMNC_DT, 'YYYYMMDD') AS FT_CMNC_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FT_END_DT, 'YYYYMMDD') AS FT_END_DT" ).append("\n"); 
		query.append("    ,   INV_DTL.FT_DYS                          " ).append("\n"); 
		query.append("    ,   0 || '-' || 0 AS FT_OVR_UND_DYS     " ).append("\n"); 
		query.append("    ,   INV_DTL.ORG_CHG_AMT INV_RT_AMT                         " ).append("\n"); 
		query.append("    ,   1 RT_OVR_DYS                        " ).append("\n"); 
		query.append("    ,   INV_DTL.ORG_CHG_AMT AS INV_AMOUNT                " ).append("\n"); 
		query.append("    ,   INV_MN.CHG_CURR_CD AS CHG_CURR_CD                " ).append("\n"); 
		query.append("FROM    DMT_INV_MN  INV_MN                       " ).append("\n"); 
		query.append("    ,   DMT_INV_DTL INV_DTL                         " ).append("\n"); 
		query.append("WHERE   INV_MN.DMDT_INV_NO  = @[invoice_no]   " ).append("\n"); 
		query.append("    AND INV_MN.CRE_OFC_CD   = @[cre_ofc_cd]                  " ).append("\n"); 
		query.append("    AND INV_MN.DMDT_INV_NO  = INV_DTL.DMDT_INV_NO             " ).append("\n"); 
		query.append("    AND INV_MN.CRE_OFC_CD   = INV_DTL.CRE_OFC_CD   " ).append("\n"); 
		query.append("    AND INV_DTL.ORG_CHG_AMT != 0" ).append("\n"); 
		query.append("    AND NVL(( SELECT SUM(RT_OVR_CHG_AMT) FROM DMT_INV_RT " ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("            AND INV_MN.DMDT_INV_NO  = DMDT_INV_NO             " ).append("\n"); 
		query.append("            AND INV_MN.CRE_OFC_CD   = CRE_OFC_CD ), 0) != INV_MN.BIL_AMT" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  INV_DTL.CNTR_NO                        " ).append("\n"); 
		query.append("    ,   INV_DTL.CNTR_TPSZ_CD                       " ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FM_MVMT_DT, 'YYYYMMDD') AS FM_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.TO_MVMT_DT, 'YYYYMMDD') AS TO_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FT_CMNC_DT, 'YYYYMMDD') AS FT_CMNC_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FT_END_DT, 'YYYYMMDD') AS FT_END_DT" ).append("\n"); 
		query.append("    ,   INV_DTL.FT_DYS                          " ).append("\n"); 
		query.append("    ,   0 || '-' || 0 AS FT_OVR_UND_DYS     " ).append("\n"); 
		query.append("    ,   INV_DTL.SC_RFA_EXPT_AMT INV_RT_AMT                         " ).append("\n"); 
		query.append("    ,   1 RT_OVR_DYS                        " ).append("\n"); 
		query.append("    ,   INV_DTL.SC_RFA_EXPT_AMT*-1 AS INV_AMOUNT                " ).append("\n"); 
		query.append("    ,   INV_MN.CHG_CURR_CD AS CHG_CURR_CD                " ).append("\n"); 
		query.append("FROM    DMT_INV_MN  INV_MN                       " ).append("\n"); 
		query.append("    ,   DMT_INV_DTL INV_DTL                         " ).append("\n"); 
		query.append("WHERE   INV_MN.DMDT_INV_NO  = @[invoice_no]   " ).append("\n"); 
		query.append("    AND INV_MN.CRE_OFC_CD   = @[cre_ofc_cd]                  " ).append("\n"); 
		query.append("    AND INV_MN.DMDT_INV_NO  = INV_DTL.DMDT_INV_NO             " ).append("\n"); 
		query.append("    AND INV_MN.CRE_OFC_CD   = INV_DTL.CRE_OFC_CD   " ).append("\n"); 
		query.append("    AND INV_DTL.SC_RFA_EXPT_AMT != 0" ).append("\n"); 
		query.append("    AND NVL(( SELECT SUM(RT_OVR_CHG_AMT) FROM DMT_INV_RT " ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("            AND INV_MN.DMDT_INV_NO  = DMDT_INV_NO             " ).append("\n"); 
		query.append("            AND INV_MN.CRE_OFC_CD   = CRE_OFC_CD ), 0) != INV_MN.BIL_AMT" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  INV_DTL.CNTR_NO                        " ).append("\n"); 
		query.append("    ,   INV_DTL.CNTR_TPSZ_CD                       " ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FM_MVMT_DT, 'YYYYMMDD') AS FM_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.TO_MVMT_DT, 'YYYYMMDD') AS TO_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FT_CMNC_DT, 'YYYYMMDD') AS FT_CMNC_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(INV_DTL.FT_END_DT, 'YYYYMMDD') AS FT_END_DT" ).append("\n"); 
		query.append("    ,   INV_DTL.FT_DYS                          " ).append("\n"); 
		query.append("    ,   0 || '-' || 0 AS FT_OVR_UND_DYS     " ).append("\n"); 
		query.append("    ,   INV_DTL.AFT_EXPT_DC_AMT INV_RT_AMT                         " ).append("\n"); 
		query.append("    ,   1 RT_OVR_DYS                        " ).append("\n"); 
		query.append("    ,   INV_DTL.AFT_EXPT_DC_AMT*-1 AS INV_AMOUNT                " ).append("\n"); 
		query.append("    ,   INV_MN.CHG_CURR_CD AS CHG_CURR_CD                " ).append("\n"); 
		query.append("FROM    DMT_INV_MN  INV_MN                       " ).append("\n"); 
		query.append("    ,   DMT_INV_DTL INV_DTL                         " ).append("\n"); 
		query.append("WHERE   INV_MN.DMDT_INV_NO  = @[invoice_no]   " ).append("\n"); 
		query.append("    AND INV_MN.CRE_OFC_CD   = @[cre_ofc_cd]                  " ).append("\n"); 
		query.append("    AND INV_MN.DMDT_INV_NO  = INV_DTL.DMDT_INV_NO             " ).append("\n"); 
		query.append("    AND INV_MN.CRE_OFC_CD   = INV_DTL.CRE_OFC_CD    " ).append("\n"); 
		query.append("    AND INV_DTL.AFT_EXPT_DC_AMT != 0" ).append("\n"); 
		query.append("    AND NVL(( SELECT SUM(RT_OVR_CHG_AMT) FROM DMT_INV_RT " ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("            AND INV_MN.DMDT_INV_NO  = DMDT_INV_NO             " ).append("\n"); 
		query.append("            AND INV_MN.CRE_OFC_CD   = CRE_OFC_CD ), 0) != INV_MN.BIL_AMT" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}