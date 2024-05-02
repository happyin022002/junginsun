/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ReportDBDAOOfficeReportCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.09 
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

public class ReportDBDAOOfficeReportCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Report count select
	  * </pre>
	  */
	public ReportDBDAOOfficeReportCountRSQL(){
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
		query.append("FileName : ReportDBDAOOfficeReportCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(OFC_CD) AS CNT" ).append("\n"); 
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

	}
}