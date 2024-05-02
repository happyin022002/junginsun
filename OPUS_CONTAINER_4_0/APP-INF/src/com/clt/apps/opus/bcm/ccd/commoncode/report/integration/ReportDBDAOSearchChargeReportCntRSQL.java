/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ReportDBDAOSearchChargeReportCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.12 
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

public class ReportDBDAOSearchChargeReportCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge 정보조회Count
	  * </pre>
	  */
	public ReportDBDAOSearchChargeReportCntRSQL(){
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
		query.append("FileName : ReportDBDAOSearchChargeReportCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(CHG_CD) AS CNT" ).append("\n"); 
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