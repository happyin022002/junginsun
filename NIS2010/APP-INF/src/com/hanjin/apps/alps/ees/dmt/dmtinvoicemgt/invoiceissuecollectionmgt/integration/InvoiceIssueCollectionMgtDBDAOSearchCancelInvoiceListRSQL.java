/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchCancelInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.24 
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

public class InvoiceIssueCollectionMgtDBDAOSearchCancelInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchCancelInvoiceListRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchCancelInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_expt_rqst_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchCancelInvoiceListRSQL").append("\n"); 
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
		query.append("select  DMDT_INV_NO" ).append("\n"); 
		query.append("	   ,CRE_OFC_CD" ).append("\n"); 
		query.append("	   ,SUTH_CHN_ISS_FLG" ).append("\n"); 
		query.append("	   ,'WAI'					as INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append(" 			select  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("			  from  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("			 where  INTG_CD_ID       = 'CD01962'" ).append("\n"); 
		query.append("			   and  INTG_CD_VAL_CTNT = 'WAI'" ).append("\n"); 
		query.append("			   and  APLY_ST_DT      <= to_char(sysdate, 'YYYYMMDD')" ).append("\n"); 
		query.append("			   and  APLY_END_DT     >= to_char(sysdate, 'YYYYMMDD')" ).append("\n"); 
		query.append("        )					as INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("	   ,'Invoice nbr.' || DMDT_INV_NO || ' was cancelled automatically due to ' || decode(@[dmdt_expt_rqst_sts_cd], 'A', 'approval', 'J', 'reject', 'O', 'counter offer') || ' for After BKG DAR No. ' || @[aft_expt_dar_no] as CXL_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  from  DMT_INV_MN" ).append("\n"); 
		query.append(" where  DMDT_INV_NO in" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			select  T4.DMDT_INV_NO" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			  from  DMT_AFT_BKG_ADJ_RQST  		T1" ).append("\n"); 
		query.append("				   ,DMT_AFT_BKG_ADJ_RQST_DTL	T2" ).append("\n"); 
		query.append("				   ,DMT_AFT_BKG_CNTR			T3" ).append("\n"); 
		query.append("				   ,DMT_CHG_CALC				T4" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			 where  T1.AFT_EXPT_DAR_NO      =  @[aft_expt_dar_no]" ).append("\n"); 
		query.append("			   and  T1.AFT_EXPT_DAR_NO      =  T2.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("			   and  T2.AFT_EXPT_DAR_NO      =  T3.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("			   and  T2.AFT_EXPT_ADJ_SEQ     =  T3.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("			   and  T3.SYS_AREA_GRP_ID		= 'KOR'" ).append("\n"); 
		query.append("			   and  T3.SYS_AREA_GRP_ID      =  T4.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   and  T3.CNTR_NO              =  T4.CNTR_NO" ).append("\n"); 
		query.append("			   and  T3.CNTR_CYC_NO          =  T4.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   and  T3.DMDT_TRF_CD          =  T4.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   and  T3.DMDT_CHG_LOC_DIV_CD  =  T4.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   and  T3.CHG_SEQ              =  T4.CHG_SEQ" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   and  DMDT_INV_STS_CD = 'I'" ).append("\n"); 

	}
}