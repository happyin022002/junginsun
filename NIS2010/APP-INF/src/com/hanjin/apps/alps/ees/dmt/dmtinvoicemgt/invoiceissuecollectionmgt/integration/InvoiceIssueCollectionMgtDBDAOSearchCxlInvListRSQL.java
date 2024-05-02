/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchCxlInvListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.04 
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

public class InvoiceIssueCollectionMgtDBDAOSearchCxlInvListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchCxlInvListRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchCxlInvListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchCxlInvListRSQL").append("\n"); 
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
		query.append("SELECT  DMDT_INV_NO" ).append("\n"); 
		query.append("       ,CRE_OFC_CD" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			SELECT  DECODE(COUNT(1), 0, 'N', 'Y')" ).append("\n"); 
		query.append("			  FROM  DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append("			 WHERE  HRD_CDG_ID = 'AUTO_AR_IF_OFC'" ).append("\n"); 
		query.append("			   AND  ATTR_CTNT1 = T1.CRE_OFC_CD" ).append("\n"); 
		query.append("		) AS AUTO_AR_IF_YN" ).append("\n"); 
		query.append("       ,DMDT_AR_IF_CD" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM  DMT_INV_MN T1" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append(" WHERE  T1.DMDT_INV_NO  IN" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT  T4.DMDT_INV_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  FROM  DMT_AFT_BKG_ADJ_RQST  		T1" ).append("\n"); 
		query.append("				   ,DMT_AFT_BKG_ADJ_RQST_DTL	T2" ).append("\n"); 
		query.append("				   ,DMT_AFT_BKG_CNTR			T3" ).append("\n"); 
		query.append("				   ,DMT_CHG_CALC                T4" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			 WHERE  T1.AFT_EXPT_DAR_NO      = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("			   AND  T1.AFT_EXPT_DAR_NO      = T2.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("			   AND  T2.AFT_EXPT_DAR_NO	    = T3.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("			   AND  T2.AFT_EXPT_ADJ_SEQ     = T3.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("			   -- 할인금액이 존재할 경우에만 적용함." ).append("\n"); 
		query.append("			   AND  (" ).append("\n"); 
		query.append("						(T2.EACH_CNTR_FLG = 'N' AND (T2.DC_AMT != 0 OR T2.DC_RTO != 0))" ).append("\n"); 
		query.append("					 OR (T2.EACH_CNTR_FLG = 'Y' AND (T3.CNTR_CHG_DC_AMT != 0 OR T3.CNTR_CHG_DC_RTO != 0))" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("			   AND  T3.SYS_AREA_GRP_ID      =  T4.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   AND  T3.CNTR_NO              =  T4.CNTR_NO" ).append("\n"); 
		query.append("			   AND  T3.CNTR_CYC_NO          =  T4.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   AND  T3.DMDT_TRF_CD          =  T4.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   AND  T3.DMDT_CHG_LOC_DIV_CD  =  T4.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   AND  T3.CHG_SEQ              =  T4.CHG_SEQ" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   AND  DMDT_INV_STS_CD = 'I'" ).append("\n"); 

	}
}