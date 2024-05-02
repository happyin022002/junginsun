/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOSearchVndrRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchVndrRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 Request Vendor 정보를 조회한다.
	  * </pre>
	  */
	public PartnerDBDAOSearchVndrRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchVndrRqstRSQL").append("\n"); 
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
		query.append("SELECT   TO_CHAR(MDM_VNDR_RQST_SEQ, '000000') AS RQST_NO  " ).append("\n"); 
		query.append("		,VNDR_SEQ" ).append("\n"); 
		query.append("        ,VNDR_CNT_CD" ).append("\n"); 
		query.append("        ,VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        ,VNDR_LOCL_LANG_NM" ).append("\n"); 
		query.append("        ,VNDR_ABBR_NM" ).append("\n"); 
		query.append("        ,LGS_FLG" ).append("\n"); 
		query.append("        ,PROCU_FLG" ).append("\n"); 
		query.append("        ,TEAM_FLG" ).append("\n"); 
		query.append("        ,FINC_FLG" ).append("\n"); 
		query.append("		,BLK_FLG" ).append("\n"); 
		query.append("        ,INTER_CO_FLG" ).append("\n"); 
		query.append("        ,LOC_CD" ).append("\n"); 
		query.append("        ,OFC_CD" ).append("\n"); 
		query.append("        ,CEO_NM" ).append("\n"); 
		query.append("        ,RGST_NO" ).append("\n"); 
		query.append("        ,TAX_ID" ).append("\n"); 
		query.append("        ,PRNT_CNT_CD" ).append("\n"); 
		query.append("        ,TRIM(TO_CHAR(PRNT_VNDR_SEQ,'000000')) PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("        ,DCGO_HNDL_FLG" ).append("\n"); 
		query.append("        ,SVC_SCP_CD_NM" ).append("\n"); 
		query.append("        ,SVC_PRD_TP_NM" ).append("\n"); 
		query.append("        ,SVC_PRD_RMK" ).append("\n"); 
		query.append("        ,BZCT_NM" ).append("\n"); 
		query.append("        ,BZTP_NM" ).append("\n"); 
		query.append("		,BLK_VNDR_SVC_CD" ).append("\n"); 
		query.append("        ,GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("        ,ENG_ADDR" ).append("\n"); 
		query.append("        ,LOCL_LANG_ADDR" ).append("\n"); 
		query.append("        ,ZIP_CD" ).append("\n"); 
		query.append("        ,CNTC_PSON_NM" ).append("\n"); 
		query.append("        ,INV_CURR_CD" ).append("\n"); 
		query.append("        ,PAY_MZD_CD" ).append("\n"); 
		query.append("        ,USA_EDI_CD" ).append("\n"); 
		query.append("        ,WO_ATCH_FILE_FLG" ).append("\n"); 
		query.append("        ,WO_EDI_USE_FLG" ).append("\n"); 
		query.append("        ,INV_EDI_USE_FLG" ).append("\n"); 
		query.append("        ,MTY_RRO_EDI_USE_FLG" ).append("\n"); 
		query.append("        ,SUBS_CO_CD" ).append("\n"); 
		query.append("        ,OTR_FLG" ).append("\n"); 
		query.append("        ,VNDR_OFC_CD" ).append("\n"); 
		query.append("        ,RFND_PSDO_CUST_CD" ).append("\n"); 
		query.append("        ,PAY_TERM_TP_CD" ).append("\n"); 
		query.append("        ,CHK_DE_ADDR1" ).append("\n"); 
		query.append("        ,CHK_DE_ADDR2" ).append("\n"); 
		query.append("        ,CHK_DE_ADDR3" ).append("\n"); 
		query.append("        ,CHK_DE_CTY_NM" ).append("\n"); 
		query.append("        ,CHK_DE_STE_CD" ).append("\n"); 
		query.append("        ,CHK_DE_ZIP_CD" ).append("\n"); 
		query.append("        ,CHK_DE_CNT_CD" ).append("\n"); 
		query.append("        ,LU_DELT_FLG" ).append("\n"); 
		query.append("--        ,DELT_FLG" ).append("\n"); 
		query.append("--        ,MODI_VNDR_SEQ AS MODI_VNDR_CD" ).append("\n"); 
		query.append("		,CASE WHEN MST_RQST_STS_CD = 'N' THEN 'Saved'" ).append("\n"); 
		query.append("			  WHEN MST_RQST_STS_CD = 'R' THEN 'Rejected'" ).append("\n"); 
		query.append("			  WHEN MST_RQST_STS_CD = 'P' THEN 'Requested'" ).append("\n"); 
		query.append("			  WHEN MST_RQST_STS_CD = 'A' THEN 'Approved'" ).append("\n"); 
		query.append("			  WHEN VNDR_CNT_CD IS NOT NULL THEN 'Approved'	" ).append("\n"); 
		query.append("			  ELSE 'Saved'  	 " ).append("\n"); 
		query.append("          END AS MST_RQST_STS_CD" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("FROM MDM_VNDR_RQST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND MDM_VNDR_RQST_SEQ = @[rqst_no]" ).append("\n"); 

	}
}