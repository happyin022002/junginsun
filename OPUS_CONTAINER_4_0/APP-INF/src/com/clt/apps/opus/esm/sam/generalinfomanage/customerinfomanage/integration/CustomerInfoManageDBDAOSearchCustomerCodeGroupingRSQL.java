/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustomerCodeGroupingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustomerCodeGroupingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_CUSTOMER
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustomerCodeGroupingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("end_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchCustomerCodeGroupingRSQL").append("\n"); 
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
		query.append("SELECT 	   " ).append("\n"); 
		query.append("         CUST_CNT_CD " ).append("\n"); 
		query.append("        ,CUST_CNT_CD||LPAD(TO_CHAR(CUST_SEQ),6,'0') CUST_CD	-- Cust. Code" ).append("\n"); 
		query.append("        ,CUST_SEQ" ).append("\n"); 
		query.append("        ,CNTR_DIV_FLG" ).append("\n"); 
		query.append("        ,BLK_DIV_FLG" ).append("\n"); 
		query.append("        ,CUST_GRP_ID     	-- Group ID" ).append("\n"); 
		query.append("        ,CUST_LGL_ENG_NM  	-- Customer Name " ).append("\n"); 
		query.append("        ,CUST_LOCL_LANG_NM" ).append("\n"); 
		query.append("        ,CUST_ABBR_NM        -- Abbr " ).append("\n"); 
		query.append("        ,CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("        ,BLK_CUST_TP_CD" ).append("\n"); 
		query.append("        ,INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append("        ,OFC_CD           			-- Sales Office " ).append("\n"); 
		query.append("        ,FNDT_DT" ).append("\n"); 
		query.append("        ,CUST_RGST_NO" ).append("\n"); 
		query.append("        ,FINC_STS_LVL_CD" ).append("\n"); 
		query.append("        ,LOC_CD      	   -- Location " ).append("\n"); 
		query.append("        ,CAPI_CURR_CD" ).append("\n"); 
		query.append("        ,CAPI_AMT" ).append("\n"); 
		query.append("        ,LSTK_FLG" ).append("\n"); 
		query.append("        ,EMPE_KNT" ).append("\n"); 
		query.append("        ,VNDR_SEQ" ).append("\n"); 
		query.append("        ,CUST_RMK" ).append("\n"); 
		query.append("        ,VBS_CLSS_CD" ).append("\n"); 
		query.append("        ,NBS_CLSS_CD1" ).append("\n"); 
		query.append("        ,NBS_CLSS_CD2" ).append("\n"); 
		query.append("        ,NBS_CLSS_CD3" ).append("\n"); 
		query.append("        ,CUST_STS_CD" ).append("\n"); 
		query.append("        ,CRM_ROW_ID" ).append("\n"); 
		query.append("        ,NVOCC_CO_SCAC_CD" ).append("\n"); 
		query.append("        ,NVOCC_BD_NO" ).append("\n"); 
		query.append("        ,NVOCC_LIC_NO" ).append("\n"); 
		query.append("        ,NVOCC_BD_AMT" ).append("\n"); 
		query.append("        ,NVOCC_BD_ST_EFF_DT" ).append("\n"); 
		query.append("        ,NVOCC_BD_END_EFF_DT" ).append("\n"); 
		query.append("        ,INDUS_DESC" ).append("\n"); 
		query.append("        ,CRNT_VOL_KNT" ).append("\n"); 
		query.append("        ,CMPT_DESC" ).append("\n"); 
		query.append("        ,SPCL_REQ_DESC" ).append("\n"); 
		query.append("        ,PRF_SVC_DESC" ).append("\n"); 
		query.append("        ,PRF_SVC_DTL_DESC" ).append("\n"); 
		query.append("        ,PRF_GRP_CMDT_CD" ).append("\n"); 
		query.append("        ,PRF_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,PRF_REP_CMDT_CD" ).append("\n"); 
		query.append("        ,SREP_CD -- , SREP_CD 			-- Pri.S.Rep" ).append("\n"); 
		query.append("        ,CTS_NO" ).append("\n"); 
		query.append("        ,FRT_FWRD_FMC_NO" ).append("\n"); 
		query.append("        ,KEY_ACCT_FLG" ).append("\n"); 
		query.append("        ,KEY_ACCT_ST_EFF_DT" ).append("\n"); 
		query.append("        ,KEY_ACCT_END_EFF_DT" ).append("\n"); 
		query.append("        ,SUBS_CO_CD" ).append("\n"); 
		query.append("        ,MODI_CUST_CNT_CD" ).append("\n"); 
		query.append("        ,MODI_CUST_SEQ" ).append("\n"); 
		query.append("        ,RFND_PSDO_VNDR_SEQ" ).append("\n"); 
		query.append("        ,BFR_OFC_CD" ).append("\n"); 
		query.append("        ,BFR_OFC_CNG_DT" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(UPD_DT,'YYYY-MM-DD') AS UPD_DT  --, UPD_DT 			-- Last Update 	" ).append("\n"); 
		query.append("        ,DELT_FLG" ).append("\n"); 
		query.append("        ,EAI_EVNT_DT" ).append("\n"); 
		query.append("        ,KEY_ACCT_MGR_USR_ID" ).append("\n"); 
		query.append("        ,KEY_ACCT_MGR_USR_NM" ).append("\n"); 
		query.append("        ,SLS_DELT_EFF_DT" ).append("\n"); 
		query.append("        ,FLET_MGMT_OWNR_CUST_SEQ" ).append("\n"); 
		query.append("        ,INV_ISS_CURR_TP_CD" ).append("\n"); 
		query.append("        ,INV_ISS_TP_CD" ).append("\n"); 
		query.append("        ,NMD_CUST_FLG" ).append("\n"); 
		query.append("        ,BKG_ALT_RSN" ).append("\n"); 
		query.append("        ,BKG_ALT_FM_DT" ).append("\n"); 
		query.append("        ,BKG_ALT_TO_DT" ).append("\n"); 
		query.append("        ,BKG_ALT_MSG" ).append("\n"); 
		query.append("        ,BKG_ALT_CRE_USR_ID" ).append("\n"); 
		query.append("        ,BKG_ALT_CRE_DT" ).append("\n"); 
		query.append("        ,EAI_IF_ID" ).append("\n"); 
		query.append("        ,MLT_TRD_ACCT_FLG" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER   " ).append("\n"); 
		query.append("/* 1) */" ).append("\n"); 
		query.append(" WHERE 1=1  " ).append("\n"); 
		query.append("   AND CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("#if(${match_rule} == 'D')  -- Start with " ).append("\n"); 
		query.append("   AND upper(CUST_LGL_ENG_NM) LIKE upper(@[cust_lgl_eng_nm])||'%'-- Cust. Code  '@'||" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${match_rule} == 'I')  -- Include  " ).append("\n"); 
		query.append("   AND upper(CUST_LGL_ENG_NM) LIKE '%'||upper(@[cust_lgl_eng_nm])||'%'-- Cust. Code " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${match_rule} == 'A')  -- Exact      " ).append("\n"); 
		query.append("   AND upper(CUST_LGL_ENG_NM) = upper(@[cust_lgl_eng_nm]) -- Cust. Code " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${ofc_cd} != '') " ).append("\n"); 
		query.append("   AND upper(OFC_CD) = upper(@[ofc_cd]) -- Sales Office " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* 2) */" ).append("\n"); 
		query.append("#if(${cust_abbr_nm} != '') " ).append("\n"); 
		query.append("   AND upper(CUST_ABBR_NM) LIKE '%'||upper(@[cust_abbr_nm])||'%' -- Abbr " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("   AND upper(LOC_CD) = upper(@[cust_cnt_cd]) -- Cust. Code " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* 3) */" ).append("\n"); 
		query.append("#if(${cust_grp_id} != '') " ).append("\n"); 
		query.append("   AND upper(CUST_GRP_ID) = upper(@[cust_grp_id]) -- Group ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${srep_cd} != '') " ).append("\n"); 
		query.append("   AND upper(SREP_CD) = upper(@[srep_cd]) -- Pri.S.Rep" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* 4) */" ).append("\n"); 
		query.append("#if(${str_cre_dt} != '' && ${end_cre_dt} != '') " ).append("\n"); 
		query.append("   AND CRE_DT BETWEEN TO_DATE(@[str_cre_dt]|| '23:59:59','YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[end_cre_dt]|| '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}