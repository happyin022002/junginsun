/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReportDBDAOSearchCustomerReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.18 
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

public class ReportDBDAOSearchCustomerReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화주 정보 조회한다
	  * </pre>
	  */
	public ReportDBDAOSearchCustomerReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.report.integration").append("\n"); 
		query.append("FileName : ReportDBDAOSearchCustomerReportRSQL").append("\n"); 
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
		query.append("SELECT CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,LPAD(CUST.CUST_SEQ,6,'0') CUST_SEQ" ).append("\n"); 
		query.append("      ,CUST.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,CUST.CUST_LOCL_LANG_NM" ).append("\n"); 
		query.append("      ,ADDR.BZET_ADDR" ).append("\n"); 
		query.append("      ,CUST.CUST_ABBR_NM" ).append("\n"); 
		query.append("      ,CUST.CUST_RGST_NO" ).append("\n"); 
		query.append("      ,CUST.LOC_CD" ).append("\n"); 
		query.append("      ,CUST.OFC_CD" ).append("\n"); 
		query.append("      ,CUST.SREP_CD" ).append("\n"); 
		query.append("      ,CUST.INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append("      ,CUST.CNTR_DIV_FLG" ).append("\n"); 
		query.append("      ,CUST.CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("      ,CUST.NBS_CLSS_CD1" ).append("\n"); 
		query.append("      ,CUST.NBS_CLSS_CD2" ).append("\n"); 
		query.append("      ,CUST.NBS_CLSS_CD3" ).append("\n"); 
		query.append("      ,CUST.VBS_CLSS_CD" ).append("\n"); 
		query.append("      ,CUST.VNDR_SEQ" ).append("\n"); 
		query.append("      ,CUST.CUST_GRP_ID" ).append("\n"); 
		query.append("      ,CUST.MLT_TRD_ACCT_FLG" ).append("\n"); 
		query.append("      ,CUST.NMD_CUST_FLG" ).append("\n"); 
		query.append("      ,CUST.KEY_ACCT_FLG" ).append("\n"); 
		query.append("      ,CUST.KEY_ACCT_ST_EFF_DT" ).append("\n"); 
		query.append("      ,CUST.KEY_ACCT_END_EFF_DT" ).append("\n"); 
		query.append("      ,CUST.FNDT_DT" ).append("\n"); 
		query.append("      ,CUST.FINC_STS_LVL_CD" ).append("\n"); 
		query.append("      ,CUST.EMPE_KNT" ).append("\n"); 
		query.append("      ,CUST.INDUS_DESC" ).append("\n"); 
		query.append("      ,CUST.CRNT_VOL_KNT" ).append("\n"); 
		query.append("      ,CUST.LSTK_FLG" ).append("\n"); 
		query.append("      ,CUST.CTS_NO" ).append("\n"); 
		query.append("      ,CUST.CAPI_CURR_CD" ).append("\n"); 
		query.append("      ,CUST.CAPI_AMT" ).append("\n"); 
		query.append("      ,CUST.CUST_RMK" ).append("\n"); 
		query.append("      ,CUST.NVOCC_CO_SCAC_CD" ).append("\n"); 
		query.append("      ,CUST.NVOCC_LIC_NO" ).append("\n"); 
		query.append("      ,CUST.NVOCC_BD_NO" ).append("\n"); 
		query.append("      ,CUST.NVOCC_BD_AMT" ).append("\n"); 
		query.append("      ,CUST.NVOCC_BD_ST_EFF_DT" ).append("\n"); 
		query.append("      ,CUST.NVOCC_BD_END_EFF_DT" ).append("\n"); 
		query.append("      ,CUST.FRT_FWRD_FMC_NO" ).append("\n"); 
		query.append("      ,CUST.DELT_FLG" ).append("\n"); 
		query.append("      ,CUST.CNSD_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,LPAD(CUST.CNSD_CUST_SEQ,6,'0') CNSD_CUST_SEQ" ).append("\n"); 
		query.append("      ,CUST.CUST_DIV_CD" ).append("\n"); 
		query.append("      ,CUST.DFLT_INV_CURR_DIV_CD" ).append("\n"); 
		query.append("      ,CUST.INV_EDI_LVL_CD" ).append("\n"); 
		query.append("      ,CUST.MODI_CUST_CD" ).append("\n"); 
		query.append("      ,CUST.PAY_RQST_LTR_FMT_CD" ).append("\n"); 
		query.append("      ,CUST.SLS_DELT_EFF_DT" ).append("\n"); 
		query.append("      ,CUST.SPRS_PAY_LTR_FLG" ).append("\n"); 
		query.append("      ,CUST.CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(CUST.CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append("      ,CUST.UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(CUST.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("      ,CUST.MODI_CUST_CD2" ).append("\n"); 
		query.append("      ,CUST.RAIL_ROAD_PRIO_FLG" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("      ,(SELECT CUST_CNT_CD" ).append("\n"); 
		query.append("              ,CUST_SEQ" ).append("\n"); 
		query.append("              ,BZET_ADDR" ).append("\n"); 
		query.append("          FROM MDM_CUST_ADDR ADDR" ).append("\n"); 
		query.append("         WHERE ADDR_TP_CD = 1" ).append("\n"); 
		query.append("           AND PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("       ) ADDR" ).append("\n"); 
		query.append(" WHERE CUST.CUST_CNT_CD = ADDR.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND CUST.CUST_SEQ = ADDR.CUST_SEQ(+)" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("   AND CUST.CUST_CNT_CD LIKE '%${cust_cnt_cd}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_seq} != '')" ).append("\n"); 
		query.append("   AND CUST.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("   AND CUST.CUST_LGL_ENG_NM LIKE '%${cust_lgl_eng_nm}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${loc_cd} != '')" ).append("\n"); 
		query.append("   AND CUST.LOC_CD LIKE '%${loc_cd}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("   AND CUST.OFC_CD LIKE '%${ofc_cd}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${status} != '')" ).append("\n"); 
		query.append("   AND DELT_FLG = @[status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY CUST_CNT_CD,CUST_SEQ" ).append("\n"); 

	}
}