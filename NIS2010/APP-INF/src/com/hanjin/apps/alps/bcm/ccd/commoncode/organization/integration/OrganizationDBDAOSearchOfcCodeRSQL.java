/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : OrganizationDBDAOSearchOfcCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.organization.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OrganizationDBDAOSearchOfcCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 Organization 정보를 조회한다.
	  * </pre>
	  */
	public OrganizationDBDAOSearchOfcCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.organization.integration").append("\n"); 
		query.append("FileName : OrganizationDBDAOSearchOfcCodeRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("            ,OFC_ENG_NM" ).append("\n"); 
		query.append("          --  ,OFC_LOCL_NM" ).append("\n"); 
		query.append("            ,OFC_ADDR" ).append("\n"); 
		query.append("            ,OFC_ZIP_CD" ).append("\n"); 
		query.append("            ,OFC_KND_CD" ).append("\n"); 
		query.append("            ,AGN_KND_CD" ).append("\n"); 
		query.append("            ,VNDR_CNT_CD" ).append("\n"); 
		query.append("            ,TRIM(TO_CHAR(VNDR_SEQ,'000000')) VNDR_SEQ" ).append("\n"); 
		query.append("            ,INTL_PHN_NO" ).append("\n"); 
		query.append("            ,OFC_PHN_NO" ).append("\n"); 
		query.append("            ,INTL_FAX_NO" ).append("\n"); 
		query.append("            ,OFC_FAX_NO" ).append("\n"); 
		query.append("            ,OFC_PSON_KNT" ).append("\n"); 
		query.append("            ,OFC_RMK" ).append("\n"); 
		query.append("            ,LOC_CD" ).append("\n"); 
		query.append("            ,BIL_CURR_CD" ).append("\n"); 
		query.append("            ,AR_CURR_CD" ).append("\n"); 
		query.append("            ,AR_CTR_CD" ).append("\n"); 
		query.append("            ,PRNT_OFC_CD" ).append("\n"); 
		query.append("            ,TO_CHAR(OPN_DT, 'YYYY-MM-DD') OPN_DT" ).append("\n"); 
		query.append("            ,TO_CHAR(CLZ_DT, 'YYYY-MM-DD') CLZ_DT" ).append("\n"); 
		query.append("            ,FINC_RGN_CD" ).append("\n"); 
		query.append("            ,AR_OFC_CD" ).append("\n"); 
		query.append("            ,AR_CTRL_OFC_CD" ).append("\n"); 
		query.append("            ,AR_HD_QTR_OFC_CD " ).append("\n"); 
		query.append("            ,IB_CR_TERM_DYS" ).append("\n"); 
		query.append("            ,OB_CR_TERM_DYS" ).append("\n"); 
		query.append("            ,SUB_AGN_FLG" ).append("\n"); 
		query.append("            ,REP_CUST_CNT_CD" ).append("\n"); 
		query.append("            ,TRIM(TO_CHAR(REP_CUST_SEQ,'000000')) REP_CUST_SEQ" ).append("\n"); 
		query.append("            ,INV_PFX_CD" ).append("\n"); 
		query.append("            ,AP_OFC_CD" ).append("\n"); 
		query.append("            ,AP_CTRL_OFC_CD" ).append("\n"); 
		query.append("            ,AP_HO_ACCT_CD" ).append("\n"); 
		query.append("            ,AP_CTR_CD" ).append("\n"); 
		query.append("            ,AR_AGN_STL_CD" ).append("\n"); 
		query.append("            ,FX_CURR_RT" ).append("\n"); 
		query.append("            ,AP_EURO_CURR_USE_FLG" ).append("\n"); 
		query.append("            ,USA_BRK_BRNC_RQST_CTRL_OFC_CD" ).append("\n"); 
		query.append("            ,ASA_CR_TERM_DYS" ).append("\n"); 
		query.append("            ,SO_IF_CD" ).append("\n"); 
		query.append("            ,SLS_OFC_USE_FLG" ).append("\n"); 
		query.append("            ,SLS_OFC_DIV_CD" ).append("\n"); 
		query.append("            ,OFC_TAX_ID" ).append("\n"); 
		query.append("            ,OFC_RFA_SC_USE_FLG" ).append("\n"); 
		query.append("            ,FAX_IP" ).append("\n"); 
		query.append("            ,BFR_OFC_CD" ).append("\n"); 
		query.append("            ,MODI_OFC_CD" ).append("\n"); 
		query.append("            ,OFC_CMMC_CD" ).append("\n"); 
		query.append("            ,OFC_TP_CD" ).append("\n"); 
		query.append("            ,PRC_OFC_CD" ).append("\n"); 
		query.append("            ,OFC_URL" ).append("\n"); 
		query.append("            ,OFC_REP_EML" ).append("\n"); 
		query.append("            ,BKG_SVR_SRCH_ROUT_CD" ).append("\n"); 
		query.append("            ,OFC_SLS_DELT_FLG" ).append("\n"); 
		query.append("            ,DOC_RCVR_HIDE_FLG" ).append("\n"); 
		query.append("            ,FINC_HIDE_FLG" ).append("\n"); 
		query.append("            ,FINC_PSDO_OFC_FLG" ).append("\n"); 
		query.append("            ,SUBS_CO_FLG" ).append("\n"); 
		query.append("            ,GL_CTR_CD" ).append("\n"); 
		query.append("            ,TEAM_MGR_NM" ).append("\n"); 
		query.append("            ,TEAM_FAX_NO" ).append("\n"); 
		query.append("            ,OFC_LOCL_LANG_ADDR" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            ,DELT_FLG" ).append("\n"); 
		query.append("            ,EAI_EVNT_DT" ).append("\n"); 
		query.append("            ,EAI_IF_ID" ).append("\n"); 
		query.append("            ,AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("			,COMM_IF_IND_CD" ).append("\n"); 
		query.append("            --,PPD_PTY_TP_CD" ).append("\n"); 
		query.append("            --,MNL_BKG_NO_OPT_CD" ).append("\n"); 
		query.append("            --,ALTN_CURR_DIV_CD" ).append("\n"); 
		query.append("			--,MODI_COST_CTR_CD" ).append("\n"); 
		query.append("			--,MODI_AGN_CD" ).append("\n"); 
		query.append("            --,SPRT_EML_INV_FLG" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}