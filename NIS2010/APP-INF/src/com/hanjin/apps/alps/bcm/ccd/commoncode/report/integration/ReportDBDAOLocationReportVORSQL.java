/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : ReportDBDAOLocationReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReportDBDAOLocationReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LocationReport
	  * </pre>
	  */
	public ReportDBDAOLocationReportVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("finc_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.report.integration").append("\n"); 
		query.append("FileName : ReportDBDAOLocationReportVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      LOC_CD " ).append("\n"); 
		query.append("    , LOC_NM" ).append("\n"); 
		query.append("	, LOC_LOCL_LANG_NM" ).append("\n"); 
		query.append("	, LOC_CHR_CD" ).append("\n"); 
		query.append("	, CALL_PORT_FLG" ).append("\n"); 
		query.append("	, PORT_INLND_FLG" ).append("\n"); 
		query.append("	, LOC_TP_CD" ).append("\n"); 
		query.append("	, CONTI_CD" ).append("\n"); 
		query.append("	, SCONTI_CD" ).append("\n"); 
		query.append("	, CNT_CD" ).append("\n"); 
		query.append("	, RGN_CD" ).append("\n"); 
		query.append("	, STE_CD" ).append("\n"); 
		query.append("	, SCC_CD" ).append("\n"); 
		query.append("	, REP_ZN_CD" ).append("\n"); 
		query.append("	, UN_LOC_IND_CD" ).append("\n"); 
		query.append("	, UN_LOC_CD" ).append("\n"); 
		query.append("	, SLS_OFC_CD" ).append("\n"); 
		query.append("	, EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("	, FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("	, MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("	, EQ_RTN_YD_CD" ).append("\n"); 
		query.append("	, HUB_LOC_CD" ).append("\n"); 
		query.append("	, LOC_GRD_NO" ).append("\n"); 
		query.append("	, ZIP_CD" ).append("\n"); 
		query.append("	, GMT_HRS" ).append("\n"); 
		query.append("	, LOC_AMS_PORT_CD" ).append("\n"); 
		query.append("	, CSTMS_CD" ).append("\n"); 
		query.append("	, CML_ZN_FLG" ).append("\n"); 
		query.append("	, LOC_LAT" ).append("\n"); 
		query.append("	, LAT_UT_CD" ).append("\n"); 
		query.append("	, LOC_LON" ).append("\n"); 
		query.append("	, LON_UT_CD" ).append("\n"); 
		query.append("    , MODI_LOC_CD" ).append("\n"); 
		query.append("	, DELT_FLG" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("AND LOC_CD like '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND CNT_CD like '%'||@[cnt_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_nm} != '')" ).append("\n"); 
		query.append("AND LOC_NM like '%'||@[loc_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sls_ofc_cd} != '')" ).append("\n"); 
		query.append("AND SLS_OFC_CD like '%'||@[sls_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("AND EQ_CTRL_OFC_CD like '%'||@[eq_ctrl_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${finc_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("AND FINC_CTRL_OFC_CD like '%'||@[finc_ctrl_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${delt_flg} == 'A')" ).append("\n"); 
		query.append("AND DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${delt_flg} == 'D')" ).append("\n"); 
		query.append("AND DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}