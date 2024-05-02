/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTAuditDBDAOCreateAGTCSRHeaderApInvHdrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.04
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.04.04 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOCreateAGTCSRHeaderApInvHdrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateAGTCSRHeaderApInvHdr
	  * </pre>
	  */
	public AGTAuditDBDAOCreateAGTCSRHeaderApInvHdrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_mzd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("s_rev_chg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_grp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_term_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_intr_cmpy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOCreateAGTCSRHeaderApInvHdrCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO AP_INV_HDR" ).append("\n"); 
		query.append("( CSR_NO," ).append("\n"); 
		query.append("CSR_TP_CD," ).append("\n"); 
		query.append("INV_DT," ).append("\n"); 
		query.append("INV_TERM_DT," ).append("\n"); 
		query.append("GL_DT," ).append("\n"); 
		query.append("VNDR_NO," ).append("\n"); 
		query.append("CSR_AMT," ).append("\n"); 
		query.append("CSR_CURR_CD," ).append("\n"); 
		query.append("VNDR_TERM_NM," ).append("\n"); 
		query.append("INV_DESC," ).append("\n"); 
		query.append("ATTR_CATE_NM," ).append("\n"); 
		query.append("ATTR_CTNT1," ).append("\n"); 
		query.append("ATTR_CTNT2," ).append("\n"); 
		query.append("ATTR_CTNT8," ).append("\n"); 
		query.append("ATTR_CTNT10," ).append("\n"); 
		query.append("ATTR_CTNT14," ).append("\n"); 
		query.append("SRC_CTNT," ).append("\n"); 
		query.append("PAY_MZD_LU_CD," ).append("\n"); 
		query.append("PAY_GRP_LU_CD," ).append("\n"); 
		query.append("COA_CO_CD," ).append("\n"); 
		query.append("COA_RGN_CD," ).append("\n"); 
		query.append("COA_CTR_CD," ).append("\n"); 
		query.append("COA_ACCT_CD," ).append("\n"); 
		query.append("COA_VVD_CD," ).append("\n"); 
		query.append("COA_INTER_CO_CD," ).append("\n"); 
		query.append("COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("APRO_FLG," ).append("\n"); 
		query.append("TAX_DECL_FLG," ).append("\n"); 
		query.append("PPAY_APLY_FLG," ).append("\n"); 
		query.append("TJ_OFC_CD," ).append("\n"); 
		query.append("USR_EML," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("EAI_EVNT_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[csr_no]               AS CSR_NO," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SIGN(@[csr_amt]) = -1" ).append("\n"); 
		query.append("THEN 'CREDIT'" ).append("\n"); 
		query.append("ELSE 'STANDARD'" ).append("\n"); 
		query.append("END                       AS CSR_TP_CD," ).append("\n"); 
		query.append("@[inv_dt]             AS INV_DT," ).append("\n"); 
		query.append("@[inv_dt]             AS INV_TERM_DT," ).append("\n"); 
		query.append("@[gl_dt]              AS GL_DT," ).append("\n"); 
		query.append("@[vndr_no]            AS VNDR_NO," ).append("\n"); 
		query.append("ROUND(@[csr_amt], 2)  AS CSR_AMT," ).append("\n"); 
		query.append("@[curr_cd]            AS CSR_CURR_CD," ).append("\n"); 
		query.append("@[vndr_term_nm]       AS VNDR_TERM_NM," ).append("\n"); 
		query.append("@[inv_desc]           AS INV_DESC," ).append("\n"); 
		query.append("'Invoices'            AS ATTR_CATE_NM," ).append("\n"); 
		query.append("' '                   AS ATTR_CTNT1," ).append("\n"); 
		query.append("@[asa_no]             AS ATTR_CTNT2," ).append("\n"); 
		query.append("TO_CHAR(sysdate,'yyyymmddhh24miss') AS ATTR_CTNT8," ).append("\n"); 
		query.append("@[cre_usr_nm]         AS ATTR_CTNT10," ).append("\n"); 
		query.append("@[s_rev_chg]         AS ATTR_CTNT14," ).append("\n"); 
		query.append("'COMMISSION'          AS SRC_CTNT," ).append("\n"); 
		query.append("@[pay_mzd_lu_cd]      AS PAY_MZD_LU_CD," ).append("\n"); 
		query.append("@[pay_grp_lu_cd]      AS PAY_GRP_LU_CD," ).append("\n"); 
		query.append("'01'                  AS COA_CO_CD," ).append("\n"); 
		query.append("@[finc_rgn_cd]         AS COA_RGN_CD," ).append("\n"); 
		query.append("@[ap_ctr_cd]         AS COA_CTR_CD," ).append("\n"); 
		query.append("'210111'              AS COA_ACCT_CD," ).append("\n"); 
		query.append("'0000000000'          AS COA_VVD_CD," ).append("\n"); 
		query.append("@[coa_intr_cmpy_cd]    AS COA_INTER_CO_CD," ).append("\n"); 
		query.append("'000000'              AS COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("'000000'              AS COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("'Y'                   AS APRO_FLG," ).append("\n"); 
		query.append("'N'                   AS TAX_DECL_FLG," ).append("\n"); 
		query.append("'N'                   AS PPAY_APLY_FLG," ).append("\n"); 
		query.append("@[ap_ofc_cd]          AS TJ_OFC_CD," ).append("\n"); 
		query.append("@[cre_usr_eml]        AS USR_EML," ).append("\n"); 
		query.append("SYSDATE               AS CRE_DT," ).append("\n"); 
		query.append("@[cre_usr_id]         AS CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE               AS EAI_EVNT_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}