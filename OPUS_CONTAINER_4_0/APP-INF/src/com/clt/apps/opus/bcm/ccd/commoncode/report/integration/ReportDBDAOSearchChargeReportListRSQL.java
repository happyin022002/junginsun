/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReportDBDAOSearchChargeReportListRSQL.java
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

public class ReportDBDAOSearchChargeReportListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 다운로드용 Charge정보조회
	  * </pre>
	  */
	public ReportDBDAOSearchChargeReportListRSQL(){
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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.report.integration").append("\n"); 
		query.append("FileName : ReportDBDAOSearchChargeReportListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("CHG_CD," ).append("\n"); 
		query.append("CHG_NM," ).append("\n"); 
		query.append("FRT_CHG_TP_CD," ).append("\n"); 
		query.append("CHG_REV_TP_CD," ).append("\n"); 
		query.append("CHG_APLY_TP_CD," ).append("\n"); 
		query.append("CHG_APLY_AREA_CD," ).append("\n"); 
		query.append("APLY_SVC_MOD_FLG, " ).append("\n"); 
		query.append("CO_CHG_ACCT_CD, " ).append("\n"); 
		query.append("REP_CHG_CD, " ).append("\n"); 
		query.append("USE_CO_TP_CD, " ).append("\n"); 
		query.append("AUTO_RAT_FLG, " ).append("\n"); 
		query.append("DP_SEQ, " ).append("\n"); 
		query.append("CY_RD_TERM_FLG, " ).append("\n"); 
		query.append("CFS_RD_TERM_FLG, " ).append("\n"); 
		query.append("DOR_RD_TERM_FLG, " ).append("\n"); 
		query.append("TKL_TML_FLG, " ).append("\n"); 
		query.append("NA_RD_TERM_FLG, " ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("FROM MDM_CHARGE" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if (${chg_cd} != '')" ).append("\n"); 
		query.append("AND CHG_CD  LIKE @[chg_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_nm} != '')" ).append("\n"); 
		query.append("AND UPPER(CHG_NM) LIKE '%'||UPPER(@[chg_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rep_chg_cd} != '' && ${rep_chg_cd} != ' ')" ).append("\n"); 
		query.append("AND REP_CHG_CD = @[rep_chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status} == 'N') " ).append("\n"); 
		query.append("AND DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#elseif (${status} == 'Y') " ).append("\n"); 
		query.append("AND DELT_FLG = @[status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}