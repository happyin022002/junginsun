/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MakeVODAOInvoiceCombinedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.12.30 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAOInvoiceCombinedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVODAOInvoiceCombinedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : MakeVODAOInvoiceCombinedRSQL").append("\n"); 
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
		query.append("SELECT  ''jo_bal_amt_lbl," ).append("\n"); 
		query.append("''STL_CMB_SEQ," ).append("\n"); 
		query.append("''STL_RMK," ).append("\n"); 
		query.append("''TTL_AMT," ).append("\n"); 
		query.append("''RLANE_CD," ).append("\n"); 
		query.append("''JO_HJS_AMT," ).append("\n"); 
		query.append("''JO_PRNR_AMT," ).append("\n"); 
		query.append("''JO_BAL_AMT," ).append("\n"); 
		query.append("''JO_LTR_SEQ                         ," ).append("\n"); 
		query.append("''JO_LTR_TP_CD                       ," ).append("\n"); 
		query.append("''TRD_CD                             ," ).append("\n"); 
		query.append("''OFC_CD                             ," ).append("\n"); 
		query.append("''LTR_ISS_DT                         ," ).append("\n"); 
		query.append("''LTR_RCVR_CO_NM                     ," ).append("\n"); 
		query.append("''LTR_RCVR_CNTC_PSON_NM              ," ).append("\n"); 
		query.append("''LTR_CC_RCVR_CNTC_PSON_NM           ," ).append("\n"); 
		query.append("''LTR_SNDR_CO_NM                     ," ).append("\n"); 
		query.append("''SNDR_NM                            ," ).append("\n"); 
		query.append("''LTR_TIT_CTNT                       ," ).append("\n"); 
		query.append("''TTL_STL_AMT                        ," ).append("\n"); 
		query.append("''JO_SND_MZD_CD                      ," ).append("\n"); 
		query.append("''JO_LTR_NO                          ," ).append("\n"); 
		query.append("''OFC_ADDR                           ," ).append("\n"); 
		query.append("''N1ST_STMT_CTNT                     ," ).append("\n"); 
		query.append("''N2ND_STMT_CTNT                     ," ).append("\n"); 
		query.append("''N3RD_STMT_CTNT                     ," ).append("\n"); 
		query.append("''SIG_STMT_CTNT                      ," ).append("\n"); 
		query.append("''BANK_STMT_CTNT," ).append("\n"); 
		query.append("''ACCT_YRMON                         ," ).append("\n"); 
		query.append("''JO_CRR_CD                          ," ).append("\n"); 
		query.append("''RE_DIVR_CD                         ," ).append("\n"); 
		query.append("''STL_CMB_SEQ                        ," ).append("\n"); 
		query.append("''SNDR_EML                           ," ).append("\n"); 
		query.append("''RCVR_EML                           ," ).append("\n"); 
		query.append("''CC_RCVR_EML                        ," ).append("\n"); 
		query.append("''EML_PROC_STS_CD                    ," ).append("\n"); 
		query.append("''EML_SND_NO                         ," ).append("\n"); 
		query.append("''EML_DT                             ," ).append("\n"); 
		query.append("''JO_CNTC_FAX_NO                     ," ).append("\n"); 
		query.append("''RCVR_INFO_CTNT                     ," ).append("\n"); 
		query.append("''FAX_PROC_STS_CD                    ," ).append("\n"); 
		query.append("''FAX_SND_NO                         ," ).append("\n"); 
		query.append("''FAX_DT                             ," ).append("\n"); 
		query.append("''DELT_FLG                           ," ).append("\n"); 
		query.append("''CRE_DT                             ," ).append("\n"); 
		query.append("''CRE_USR_ID                         ," ).append("\n"); 
		query.append("''UPD_DT                             ," ).append("\n"); 
		query.append("''UPD_USR_ID" ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}