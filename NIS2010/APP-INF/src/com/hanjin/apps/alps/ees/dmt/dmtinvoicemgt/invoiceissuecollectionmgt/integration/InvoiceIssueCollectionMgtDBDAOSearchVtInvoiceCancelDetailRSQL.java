/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchVtInvoiceCancelDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
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

public class InvoiceIssueCollectionMgtDBDAOSearchVtInvoiceCancelDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchVtInvoiceCancelDetailRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchVtInvoiceCancelDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchVtInvoiceCancelDetailRSQL").append("\n"); 
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
		query.append("select  T4.CNTR_NO" ).append("\n"); 
		query.append("	   ,T3.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	   ,to_char(T4.FM_MVMT_DT, 'YYYY-MM-DD')   			as FM_MVMT_DT" ).append("\n"); 
		query.append("	   ,to_char(T4.TO_MVMT_DT, 'YYYY-MM-DD')   			as TO_MVMT_DT" ).append("\n"); 
		query.append("	   ,to_char(T4.FT_CMNC_DT, 'YYYY-MM-DD')   			as FT_CMNC_DT" ).append("\n"); 
		query.append("	   ,to_char(T4.FT_end_DT , 'YYYY-MM-DD')   			as FT_end_DT" ).append("\n"); 
		query.append("	   ,T4.FT_DYS" ).append("\n"); 
		query.append("	   ,T4.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("	   ,T1.CHG_CURR_CD                         			as BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	   ,nvl(T4.ORG_CHG_AMT, 0)							as ORG_CHG_AMT" ).append("\n"); 
		query.append("	   ,DECODE(NVL(T4.ORG_CHG_AMT, 0), NVL(T2.ORG_CHG_AMT, 0), 'N', 'Y')  AS ORG_CHG_AMT_FLG" ).append("\n"); 
		query.append("	   ,nvl(T4.SC_RFA_EXPT_AMT, 0)             			as EXPT_AMT" ).append("\n"); 
		query.append("	   ,DECODE(NVL(T4.SC_RFA_EXPT_AMT, 0), NVL(T2.SC_RFA_EXPT_AMT, 0), 'N', 'Y')  AS EXPT_AMT_FLG" ).append("\n"); 
		query.append("	   ,nvl(T4.AFT_EXPT_DC_AMT, 0)						as AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	   ,DECODE(NVL(T4.AFT_EXPT_DC_AMT, 0), NVL(T2.AFT_EXPT_DC_AMT, 0), 'N', 'Y')  AS AFT_EXPT_DC_AMT_FLG" ).append("\n"); 
		query.append("	   ,nvl(T4.BIL_AMT, 0)								as BIL_AMT" ).append("\n"); 
		query.append("	   ,DECODE(NVL(T4.BIL_AMT, 0), NVL(T2.BIL_AMT, 0), 'N', 'Y')  AS BIL_AMT_FLG" ).append("\n"); 
		query.append("	   ,decode(T4.CHG_SEQ, '1', 'G', 'B')         		as GB" ).append("\n"); 
		query.append("	   ,T4.SYS_AREA_GRP_ID                     			as SVR_ID" ).append("\n"); 
		query.append("	   ,T4.CNTR_CYC_NO" ).append("\n"); 
		query.append("	   ,T4.DMDT_TRF_CD" ).append("\n"); 
		query.append("	   ,T4.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	   ,T4.CHG_SEQ        " ).append("\n"); 
		query.append("	   ,T4.BZC_TRF_SEQ" ).append("\n"); 
		query.append("	   ,nvl(T4.BZC_DMDT_DE_TERM_CD, 'N')       			as BZC_DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("	   ,T4.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("	   ,T4.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("	   ,T4.ORG_FT_OVR_DYS        " ).append("\n"); 
		query.append("	   ,T4.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	   ,T4.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	   ,T4.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	   ,T4.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("	   ,T4.SC_NO" ).append("\n"); 
		query.append("	   ,T4.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	   ,T4.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("	   ,T4.DMDT_TRF_APLY_TP_CD	" ).append("\n"); 
		query.append("	   ,T4.OFC_TRNS_FLG        " ).append("\n"); 
		query.append("	   ,nvl(T4.CMDT_EXPT_AMT,0)                			as CMDT_EXPT_AMT" ).append("\n"); 
		query.append("	   ,''                         			  			as RT_DTL_GRP" ).append("\n"); 
		query.append("	   ,T1.BKG_NO" ).append("\n"); 
		query.append("	   ,T4.OFC_CD                              			as CHG_OFC_CD" ).append("\n"); 
		query.append("	   ,T4.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("	   ,to_char(T4.BZC_TRF_APLY_DT    , 'YYYY-MM-DD') 	as BZC_TRF_APLY_DT" ).append("\n"); 
		query.append("	   ,to_char(T4.SC_RFA_EXPT_APLY_DT, 'YYYY-MM-DD')   as SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  from  DMT_INV_MN          T1" ).append("\n"); 
		query.append("       ,DMT_INV_DTL			T2" ).append("\n"); 
		query.append("	   ,DMT_CHG_BKG_CNTR    T3" ).append("\n"); 
		query.append("	   ,DMT_CHG_CALC        T4" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append(" where  T1.DMDT_INV_NO 	       = @[dmdt_inv_no]" ).append("\n"); 
		query.append("   and  T1.CRE_OFC_CD	       = @[cre_ofc_cd]" ).append("\n"); 
		query.append("   and  T1.DMDT_INV_STS_CD     = 'X'" ).append("\n"); 
		query.append("   and  T1.DMDT_VT_INV_STS_CD  = 'C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   and  T1.DMDT_INV_NO 	       = T2.DMDT_INV_NO" ).append("\n"); 
		query.append("   and  T1.CRE_OFC_CD	       = T2.CRE_OFC_CD" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   and  T2.SYS_AREA_GRP_ID     = T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   and  T2.CNTR_NO 		       = T3.CNTR_NO" ).append("\n"); 
		query.append("   and  T2.CNTR_CYC_NO 	       = T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("   --and  T1.BKG_NO              = T3.BKG_NO" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   and  T2.SYS_AREA_GRP_ID     = T4.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   and  T2.CNTR_NO 		       = T4.CNTR_NO" ).append("\n"); 
		query.append("   and  T2.CNTR_CYC_NO 	       = T4.CNTR_CYC_NO" ).append("\n"); 
		query.append("   and  T2.DMDT_TRF_CD	       = T4.DMDT_TRF_CD" ).append("\n"); 
		query.append("   and  T2.DMDT_CHG_LOC_DIV_CD = T4.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   and  T2.CHG_SEQ             = T4.CHG_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  T4.DMDT_CHG_STS_CD IN ( 'F','C' )" ).append("\n"); 

	}
}