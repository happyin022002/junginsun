/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReportDBDAOOfficeReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.report.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReportDBDAOOfficeReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Report
	  * </pre>
	  */
	public ReportDBDAOOfficeReportVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.report.integration").append("\n"); 
		query.append("FileName : ReportDBDAOOfficeReportVORSQL").append("\n"); 
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
		query.append("      ,OFC_ENG_NM" ).append("\n"); 
		query.append("      ,OFC_LOCL_NM" ).append("\n"); 
		query.append("      ,INTL_PHN_NO" ).append("\n"); 
		query.append("      ,OFC_PHN_NO" ).append("\n"); 
		query.append("      ,INTL_FAX_NO" ).append("\n"); 
		query.append("      ,OFC_FAX_NO" ).append("\n"); 
		query.append("      ,OFC_URL" ).append("\n"); 
		query.append("      ,OFC_REP_EML" ).append("\n"); 
		query.append("      ,OFC_ZIP_CD" ).append("\n"); 
		query.append("      ,OFC_ADDR" ).append("\n"); 
		query.append("      ,OFC_LOCL_LANG_ADDR" ).append("\n"); 
		query.append("      ,OFC_TP_CD" ).append("\n"); 
		query.append("      ,OFC_CMMC_CD" ).append("\n"); 
		query.append("      ,OFC_KND_CD" ).append("\n"); 
		query.append("      ,AGN_KND_CD" ).append("\n"); 
		query.append("      ,PRNT_OFC_CD" ).append("\n"); 
		query.append("      ,OFC_SLS_DELT_FLG" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,FAX_IP" ).append("\n"); 
		query.append("      ,TO_CHAR(OPN_DT, 'yyyy-mm-dd') AS OPN_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(CLZ_DT, 'yyyy-mm-dd') AS CLZ_DT" ).append("\n"); 
		query.append("      ,FINC_PSDO_OFC_FLG" ).append("\n"); 
		query.append("      ,DOC_RCVR_HIDE_FLG" ).append("\n"); 
		query.append("      ,FINC_HIDE_FLG" ).append("\n"); 
		query.append("      ,SUBS_CO_FLG" ).append("\n"); 
		query.append("      ,SLS_OFC_DIV_CD" ).append("\n"); 
		query.append("      ,OFC_RFA_SC_USE_FLG" ).append("\n"); 
		query.append("      ,OFC_RMK" ).append("\n"); 
		query.append("      ,AR_OFC_CD" ).append("\n"); 
		query.append("      ,AR_CTRL_OFC_CD" ).append("\n"); 
		query.append("      ,AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("      ,AR_CTR_CD" ).append("\n"); 
		query.append("      ,FINC_RGN_CD" ).append("\n"); 
		query.append("      ,OB_CR_TERM_DYS" ).append("\n"); 
		query.append("      ,IB_CR_TERM_DYS" ).append("\n"); 
		query.append("      ,AR_CURR_CD" ).append("\n"); 
		query.append("      ,REP_CUST_CNT_CD||REP_CUST_SEQ AS REP_CUST_CD" ).append("\n"); 
		query.append("      ,INV_PFX_CD" ).append("\n"); 
		query.append("      ,FX_CURR_RT" ).append("\n"); 
		query.append("      ,OFC_TAX_ID" ).append("\n"); 
		query.append("      ,ASA_CR_TERM_DYS" ).append("\n"); 
		query.append("      ,SUB_AGN_FLG" ).append("\n"); 
		query.append("      ,AR_AGN_STL_CD" ).append("\n"); 
		query.append("      ,AP_OFC_CD" ).append("\n"); 
		query.append("      ,AP_CTRL_OFC_CD" ).append("\n"); 
		query.append("      ,AP_CTR_CD" ).append("\n"); 
		query.append("      ,GL_CTR_CD" ).append("\n"); 
		query.append("      ,COMM_IF_IND_CD" ).append("\n"); 
		query.append("      ,BIL_CURR_CD" ).append("\n"); 
		query.append("      ,VNDR_CNT_CD" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,SO_IF_CD" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,PPD_PTY_TP_CD" ).append("\n"); 
		query.append("      ,ALTN_CURR_DIV_CD" ).append("\n"); 
		query.append("      ,MNL_BKG_NO_OPT_CD" ).append("\n"); 
		query.append("      ,MODI_COST_CTR_CD" ).append("\n"); 
		query.append("      ,MODI_AGN_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("   AND OFC_CD LIKE '%'||@[ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_eng_nm} != '')" ).append("\n"); 
		query.append("   AND OFC_ENG_NM LIKE '%'||@[ofc_eng_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("   AND LOC_CD LIKE '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_knd_cd} != '')" ).append("\n"); 
		query.append("   AND OFC_KND_CD = @[ofc_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status} == 'N') " ).append("\n"); 
		query.append("   AND DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#elseif (${status} == 'Y') " ).append("\n"); 
		query.append("   AND DELT_FLG = @[status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY OFC_KND_CD" ).append("\n"); 

	}
}