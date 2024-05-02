/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVODAOLetterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.12 장강철
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

public class MakeVODAOLetterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVODAOLetterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : MakeVODAOLetterRSQL").append("\n"); 
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
		query.append("SELECT  ''greeting," ).append("\n"); 
		query.append("''usr_nm," ).append("\n"); 
		query.append("''usr_eml," ).append("\n"); 
		query.append("''jb_eng_nm," ).append("\n"); 
		query.append("''ofc_cd," ).append("\n"); 
		query.append("''xtn_phn_no," ).append("\n"); 
		query.append("''fax_no," ).append("\n"); 
		query.append("''attach_yn," ).append("\n"); 
		query.append("''jo_tmplt_no_seq," ).append("\n"); 
		query.append("''jo_ltr_tmplt_seq," ).append("\n"); 
		query.append("''bank_stmt_ctnt," ).append("\n"); 
		query.append("''jo_tmplt_no," ).append("\n"); 
		query.append("''usr_id," ).append("\n"); 
		query.append("''JO_HJS_AMT," ).append("\n"); 
		query.append("''JO_PRNR_AMT," ).append("\n"); 
		query.append("''JO_BAL_AMT," ).append("\n"); 
		query.append("''SEND_TYPE," ).append("\n"); 
		query.append("''SEND_FAX_NO," ).append("\n"); 
		query.append("''USR_NM," ).append("\n"); 
		query.append("''RLANE_CD," ).append("\n"); 
		query.append("''LETTER_NO," ).append("\n"); 
		query.append("''SUB_SYS_CD," ).append("\n"); 
		query.append("''TTL_AMT," ).append("\n"); 
		query.append("''STL_RMK," ).append("\n"); 
		query.append("''FAX_NO," ).append("\n"); 
		query.append("''CONTENT," ).append("\n"); 
		query.append("''TITLE," ).append("\n"); 
		query.append("''SEND_TYPE_FAX," ).append("\n"); 
		query.append("''SEND_TYPE_MAIL," ).append("\n"); 
		query.append("''TMPLMRD," ).append("\n"); 
		query.append("''TMPLPARAM," ).append("\n"); 
		query.append("''FILE_SAV_ID," ).append("\n"); 
		query.append("''KEYS," ).append("\n"); 
		query.append("''JO_LTR_STL_SEQ," ).append("\n"); 
		query.append("''JO_LTR_SEQ                         ," ).append("\n"); 
		query.append("''JO_LTR_TP_CD                       ," ).append("\n"); 
		query.append("''TRD_CD                             ," ).append("\n"); 
		query.append("''OFC_CD                             ," ).append("\n"); 
		query.append("''LTR_ISS_DT                         ," ).append("\n"); 
		query.append("''LTR_RCVR_CO_NM                     ," ).append("\n"); 
		query.append("''LTR_RCVR_CNTC_PSON_NM              ," ).append("\n"); 
		query.append("''ltr_cc_rcvr_cntc_pson_nm_ctnt     ," ).append("\n"); 
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
		query.append("''ACCT_YRMON                         ," ).append("\n"); 
		query.append("''JO_CRR_CD                          ," ).append("\n"); 
		query.append("''RE_DIVR_CD                         ," ).append("\n"); 
		query.append("''STL_CMB_SEQ                        ," ).append("\n"); 
		query.append("''SNDR_EML                           ," ).append("\n"); 
		query.append("''RCVR_EML                           ," ).append("\n"); 
		query.append("''cc_rcvr_eml_ctnt                        ," ).append("\n"); 
		query.append("''EML_PROC_STS_CD                    ," ).append("\n"); 
		query.append("''EML_SND_NO                         ," ).append("\n"); 
		query.append("''EML_DT                             ," ).append("\n"); 
		query.append("''jo_cntc_fax_no_ctnt                     ," ).append("\n"); 
		query.append("''RCVR_INFO_CTNT                     ," ).append("\n"); 
		query.append("''FAX_PROC_STS_CD                    ," ).append("\n"); 
		query.append("''FAX_SND_NO                         ," ).append("\n"); 
		query.append("''FAX_DT                             ," ).append("\n"); 
		query.append("''DELT_FLG                           ," ).append("\n"); 
		query.append("''CRE_DT                             ," ).append("\n"); 
		query.append("''CRE_USR_ID                         ," ).append("\n"); 
		query.append("''UPD_DT                             ," ).append("\n"); 
		query.append("''UPD_USR_ID                         ," ).append("\n"); 
		query.append("''JOINT_OPERATION_LETTER_TEMPLAT" ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}