/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationLetterDBDAOAddMcsLetterCSQL.java
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

public class JointOperationLetterDBDAOAddMcsLetterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationLetterDBDAOAddMcsLetterCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ltr_rcvr_co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sig_stmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ltr_sndr_co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ltr_cc_rcvr_cntc_pson_nm_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_tmplt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_stmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_stl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ltr_rcvr_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ltr_tit_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_cntc_fax_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bank_stmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ltr_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_info_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_stmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cc_rcvr_eml_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_snd_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_stmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOAddMcsLetterCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_LETTER" ).append("\n"); 
		query.append("(JO_LTR_SEQ                ," ).append("\n"); 
		query.append("JO_LTR_TP_CD              ," ).append("\n"); 
		query.append("TRD_CD                    ," ).append("\n"); 
		query.append("OFC_CD                    ," ).append("\n"); 
		query.append("LTR_ISS_DT                ," ).append("\n"); 
		query.append("LTR_RCVR_CO_NM            ," ).append("\n"); 
		query.append("LTR_RCVR_CNTC_PSON_NM     ," ).append("\n"); 
		query.append("LTR_CC_RCVR_CNTC_PSON_NM_CTNT,--LTR_CC_RCVR_CNTC_PSON_NM" ).append("\n"); 
		query.append("LTR_SNDR_CO_NM            ," ).append("\n"); 
		query.append("SNDR_NM                   ," ).append("\n"); 
		query.append("LTR_TIT_CTNT              ," ).append("\n"); 
		query.append("TTL_STL_AMT               ," ).append("\n"); 
		query.append("JO_SND_MZD_CD             ," ).append("\n"); 
		query.append("JO_LTR_NO                 ," ).append("\n"); 
		query.append("OFC_ADDR                  ," ).append("\n"); 
		query.append("N1ST_STMT_CTNT            ," ).append("\n"); 
		query.append("N2ND_STMT_CTNT            ," ).append("\n"); 
		query.append("N3RD_STMT_CTNT            ," ).append("\n"); 
		query.append("SIG_STMT_CTNT             ," ).append("\n"); 
		query.append("SNDR_EML                  ," ).append("\n"); 
		query.append("RCVR_EML                  ," ).append("\n"); 
		query.append("CC_RCVR_EML_CTNT          ,--CC_RCVR_EML" ).append("\n"); 
		query.append("EML_PROC_STS_CD           ," ).append("\n"); 
		query.append("EML_SND_NO                ," ).append("\n"); 
		query.append("EML_DT                    ," ).append("\n"); 
		query.append("JO_CNTC_FAX_NO_CTNT       ,--JO_CNTC_FAX_NO            ," ).append("\n"); 
		query.append("RCVR_INFO_CTNT            ," ).append("\n"); 
		query.append("FAX_PROC_STS_CD           ," ).append("\n"); 
		query.append("FAX_SND_NO                ," ).append("\n"); 
		query.append("FAX_DT                    ," ).append("\n"); 
		query.append("DELT_FLG                  ," ).append("\n"); 
		query.append("CRE_DT                    ," ).append("\n"); 
		query.append("CRE_USR_ID                ," ).append("\n"); 
		query.append("UPD_DT                    ," ).append("\n"); 
		query.append("UPD_USR_ID                ," ).append("\n"); 
		query.append("JO_LTR_TMPLT_SEQ          ," ).append("\n"); 
		query.append("BANK_STMT_CTNT           )" ).append("\n"); 
		query.append("VALUES  (@[jo_ltr_seq]              ," ).append("\n"); 
		query.append("@[jo_ltr_tp_cd]            ," ).append("\n"); 
		query.append("@[trd_cd]                  ," ).append("\n"); 
		query.append("@[ofc_cd]                  ," ).append("\n"); 
		query.append("TO_DATE( REPLACE(@[ltr_iss_dt],'-',''),'YYYYMMDD')," ).append("\n"); 
		query.append("@[ltr_rcvr_co_nm]          ," ).append("\n"); 
		query.append("@[ltr_rcvr_cntc_pson_nm]   ," ).append("\n"); 
		query.append("@[ltr_cc_rcvr_cntc_pson_nm_ctnt]," ).append("\n"); 
		query.append("@[ltr_sndr_co_nm]          ," ).append("\n"); 
		query.append("@[sndr_nm]                 ," ).append("\n"); 
		query.append("@[ltr_tit_ctnt]            ," ).append("\n"); 
		query.append("REPLACE(@[ttl_stl_amt],',','')," ).append("\n"); 
		query.append("@[jo_snd_mzd_cd]           ," ).append("\n"); 
		query.append("@[jo_ltr_no]               ," ).append("\n"); 
		query.append("@[ofc_addr]                ," ).append("\n"); 
		query.append("@[n1st_stmt_ctnt]          ," ).append("\n"); 
		query.append("@[n2nd_stmt_ctnt]          ," ).append("\n"); 
		query.append("@[n3rd_stmt_ctnt]          ," ).append("\n"); 
		query.append("@[sig_stmt_ctnt]           ," ).append("\n"); 
		query.append("@[sndr_eml]                ," ).append("\n"); 
		query.append("@[rcvr_eml]                ," ).append("\n"); 
		query.append("@[cc_rcvr_eml_ctnt]             ," ).append("\n"); 
		query.append("@[eml_proc_sts_cd]         ," ).append("\n"); 
		query.append("@[eml_snd_no]              ," ).append("\n"); 
		query.append("@[eml_dt]                  ," ).append("\n"); 
		query.append("@[jo_cntc_fax_no_ctnt]          ," ).append("\n"); 
		query.append("@[rcvr_info_ctnt]          ," ).append("\n"); 
		query.append("@[fax_proc_sts_cd]         ," ).append("\n"); 
		query.append("@[fax_snd_no]              ," ).append("\n"); 
		query.append("@[fax_dt]                  ," ).append("\n"); 
		query.append("'N'                ," ).append("\n"); 
		query.append("sysdate                  ," ).append("\n"); 
		query.append("@[cre_usr_id]              ," ).append("\n"); 
		query.append("sysdate                  ," ).append("\n"); 
		query.append("@[upd_usr_id]              ," ).append("\n"); 
		query.append("@[jo_ltr_tmplt_seq]        ," ).append("\n"); 
		query.append("@[bank_stmt_ctnt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}