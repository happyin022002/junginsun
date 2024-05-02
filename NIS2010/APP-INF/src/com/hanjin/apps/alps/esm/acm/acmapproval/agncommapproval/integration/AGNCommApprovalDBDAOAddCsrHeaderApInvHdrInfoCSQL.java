/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommApprovalDBDAOAddCsrHeaderApInvHdrInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOAddCsrHeaderApInvHdrInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_INV_HDR 에 데이터를 생성한다.
	  * 20141021 함대성
	  * RQST_APRO_STEP_FLG GW에서 'Y' 기안되면 'Y'는 빈값으로 업데이트된다
	  * AP_INV_HDR 필수 입력 컬럼추가 > 업데이트하지않는다 즉, 처음 CSR_NO를 생성할 때의 GL_DT의 월과 총액을 보관해둔다고 보면된다 > 안넣으면 에러발생될 수 있음
	  * ACCT_XCH_RT_YRMON(최초GL_DT)
	  * CSR_USD_AMT(최초총액)(AP_COM_GET_USD_XCH_AMT_FNC FUNCTION)
	  * </pre>
	  */
	public AGNCommApprovalDBDAOAddCsrHeaderApInvHdrInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_doc_cfm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_file_cfm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_evid_cfm_fnl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_mzd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rev_chg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_gen_expn_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_grp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gw_agmt_doc_cfm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_term_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_intr_cmpy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOAddCsrHeaderApInvHdrInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO AP_INV_HDR" ).append("\n"); 
		query.append("         ( CSR_NO," ).append("\n"); 
		query.append("           CSR_TP_CD," ).append("\n"); 
		query.append("           INV_DT," ).append("\n"); 
		query.append("           INV_TERM_DT," ).append("\n"); 
		query.append("           GL_DT, " ).append("\n"); 
		query.append("           VNDR_NO," ).append("\n"); 
		query.append("           CSR_AMT," ).append("\n"); 
		query.append("           CSR_CURR_CD," ).append("\n"); 
		query.append("           VNDR_TERM_NM," ).append("\n"); 
		query.append("           INV_DESC," ).append("\n"); 
		query.append("           ATTR_CATE_NM," ).append("\n"); 
		query.append("           ATTR_CTNT1," ).append("\n"); 
		query.append("           ATTR_CTNT2," ).append("\n"); 
		query.append("		   ATTR_CTNT8," ).append("\n"); 
		query.append("           ATTR_CTNT10," ).append("\n"); 
		query.append("		   ATTR_CTNT14," ).append("\n"); 
		query.append("           SRC_CTNT," ).append("\n"); 
		query.append("           PAY_MZD_LU_CD," ).append("\n"); 
		query.append("           PAY_GRP_LU_CD," ).append("\n"); 
		query.append("           COA_CO_CD," ).append("\n"); 
		query.append("           COA_RGN_CD," ).append("\n"); 
		query.append("           COA_CTR_CD," ).append("\n"); 
		query.append("           COA_ACCT_CD," ).append("\n"); 
		query.append("           COA_VVD_CD," ).append("\n"); 
		query.append("           COA_INTER_CO_CD," ).append("\n"); 
		query.append("           COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("           COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("           APRO_FLG," ).append("\n"); 
		query.append("           TAX_DECL_FLG," ).append("\n"); 
		query.append("           PPAY_APLY_FLG," ).append("\n"); 
		query.append("           TJ_OFC_CD," ).append("\n"); 
		query.append("           USR_EML," ).append("\n"); 
		query.append("           CRE_DT," ).append("\n"); 
		query.append("           CRE_USR_ID," ).append("\n"); 
		query.append("           EAI_EVNT_DT," ).append("\n"); 
		query.append("		   RQST_APRO_STEP_FLG," ).append("\n"); 
		query.append("		   ACCT_XCH_RT_YRMON," ).append("\n"); 
		query.append("		   CSR_USD_AMT," ).append("\n"); 
		query.append("           AGMT_DOC_CFM_CD," ).append("\n"); 
		query.append("           GW_AGMT_DOC_CFM_CD," ).append("\n"); 
		query.append("           AGMT_FILE_CFM_CD," ).append("\n"); 
		query.append("           AGMT_EVID_CFM_FNL_CD," ).append("\n"); 
		query.append("           CSR_GEN_EXPN_ACCT_FLG," ).append("\n"); 
		query.append("           CSR_APRO_TP_CD" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("           @[csr_no]               AS CSR_NO," ).append("\n"); 
		query.append("      CASE" ).append("\n"); 
		query.append("      WHEN SIGN(@[csr_amt]) = -1" ).append("\n"); 
		query.append("      THEN 'CREDIT'" ).append("\n"); 
		query.append("      ELSE 'STANDARD'" ).append("\n"); 
		query.append("       END                       AS CSR_TP_CD," ).append("\n"); 
		query.append("           @[inv_dt]             AS INV_DT," ).append("\n"); 
		query.append("           @[inv_dt]             AS INV_TERM_DT," ).append("\n"); 
		query.append("           @[gl_dt]              AS GL_DT," ).append("\n"); 
		query.append("           @[vndr_no]            AS VNDR_NO," ).append("\n"); 
		query.append("           ROUND(@[csr_amt], 2)  AS CSR_AMT," ).append("\n"); 
		query.append("           @[curr_cd]            AS CSR_CURR_CD," ).append("\n"); 
		query.append("           @[vndr_term_nm]       AS VNDR_TERM_NM," ).append("\n"); 
		query.append("           @[inv_desc]           AS INV_DESC," ).append("\n"); 
		query.append("           'Invoices'            AS ATTR_CATE_NM," ).append("\n"); 
		query.append("           ' '                   AS ATTR_CTNT1," ).append("\n"); 
		query.append("           @[asa_no]             AS ATTR_CTNT2," ).append("\n"); 
		query.append("		   TO_CHAR(sysdate,'yyyymmddhh24miss') AS ATTR_CTNT8," ).append("\n"); 
		query.append("           @[usr_nm]         AS ATTR_CTNT10," ).append("\n"); 
		query.append("		   @[s_rev_chg]          AS ATTR_CTNT14," ).append("\n"); 
		query.append("           'COMMISSION'          AS SRC_CTNT," ).append("\n"); 
		query.append("           @[pay_mzd_lu_cd]      AS PAY_MZD_LU_CD," ).append("\n"); 
		query.append("           @[pay_grp_lu_cd]      AS PAY_GRP_LU_CD," ).append("\n"); 
		query.append("           '01'                  AS COA_CO_CD," ).append("\n"); 
		query.append("           @[finc_rgn_cd]        AS COA_RGN_CD," ).append("\n"); 
		query.append("           @[ap_ctr_cd]          AS COA_CTR_CD," ).append("\n"); 
		query.append("           '210111'              AS COA_ACCT_CD," ).append("\n"); 
		query.append("           '0000000000'          AS COA_VVD_CD," ).append("\n"); 
		query.append("           @[coa_intr_cmpy_cd]   AS COA_INTER_CO_CD," ).append("\n"); 
		query.append("           '000000'              AS COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("           '000000'              AS COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("           'Y'                   AS APRO_FLG," ).append("\n"); 
		query.append("           'N'                   AS TAX_DECL_FLG," ).append("\n"); 
		query.append("           'N'                   AS PPAY_APLY_FLG," ).append("\n"); 
		query.append("           @[ap_ofc_cd]          AS TJ_OFC_CD," ).append("\n"); 
		query.append("           @[usr_eml]        AS USR_EML," ).append("\n"); 
		query.append("           SYSDATE               AS CRE_DT," ).append("\n"); 
		query.append("           @[cre_usr_id]         AS CRE_USR_ID," ).append("\n"); 
		query.append("           SYSDATE               AS EAI_EVNT_DT," ).append("\n"); 
		query.append("		   ''					 AS RQST_APRO_STEP_FLG," ).append("\n"); 
		query.append("		   SUBSTR(@[gl_dt], 0, 6) AS ACCT_XCH_RT_YRMON," ).append("\n"); 
		query.append("		   (" ).append("\n"); 
		query.append("			SELECT AP_COM_GET_USD_XCH_AMT_FNC(@[curr_cd], ROUND(@[csr_amt], 2),SUBSTR(@[gl_dt], 0, 6))" ).append("\n"); 
		query.append("  			  FROM DUAL " ).append("\n"); 
		query.append("		   ) AS CSR_USD_AMT," ).append("\n"); 
		query.append("           @[agmt_doc_cfm_cd] AS AGMT_DOC_CFM_CD," ).append("\n"); 
		query.append("           @[gw_agmt_doc_cfm_cd] AS GW_AGMT_DOC_CFM_CD," ).append("\n"); 
		query.append("           @[agmt_file_cfm_cd] AS AGMT_FILE_CFM_CD," ).append("\n"); 
		query.append("           @[agmt_evid_cfm_fnl_cd] AS AGMT_EVID_CFM_FNL_CD," ).append("\n"); 
		query.append("           @[csr_gen_expn_acct_flg] AS CSR_GEN_EXPN_ACCT_FLG," ).append("\n"); 
		query.append("           @[csr_apro_tp_cd] AS CSR_APRO_TP_CD" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 

	}
}