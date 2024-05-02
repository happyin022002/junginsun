/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DailyForecastManageDBDAOsearchPolPodCntiCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOsearchPolPodCntiCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POL POD CONTI를 체크 한다
	  * </pre>
	  */
	public DailyForecastManageDBDAOsearchPolPodCntiCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOsearchPolPodCntiCheckRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*),0,'N','Y') POL_POD_CNTI_YN " ).append("\n"); 
		query.append("  FROM MDM_DTL_REV_LANE T1" ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT MAX(RLANE_CD) AS RLANE_CD " ).append("\n"); 
		query.append("         FROM COA_MON_VVD " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND IOC_CD = DECODE(@[ioc_ts_cd], 'O', 'O', 'I') " ).append("\n"); 
		query.append("              AND VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("              AND SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("              AND DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("              AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("        GROUP BY VSL_CD " ).append("\n"); 
		query.append("            , SKD_VOY_NO " ).append("\n"); 
		query.append("            , DIR_CD " ).append("\n"); 
		query.append("       ) T2" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND T1.VSL_SLAN_DIR_CD = @[dir_cd] " ).append("\n"); 
		query.append("       AND T1.IOC_CD = DECODE(@[ioc_ts_cd], 'O', 'O', 'I') " ).append("\n"); 
		query.append("       AND T1.RLANE_CD = T2.RLANE_CD" ).append("\n"); 
		query.append("       AND T1.FM_CONTI_CD IN " ).append("\n"); 
		query.append("       (SELECT CONTI_CD " ).append("\n"); 
		query.append("         FROM MDM_LOCATION " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND LOC_CD = SUBSTR(@[pol_yd_cd], 1, 5) " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   #if (${pod_yd_cd} != '')" ).append("\n"); 
		query.append("       AND T1.TO_CONTI_CD IN " ).append("\n"); 
		query.append("       (SELECT CONTI_CD " ).append("\n"); 
		query.append("         FROM MDM_LOCATION " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND LOC_CD = SUBSTR(@[pod_yd_cd], 1, 5) " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND DELT_FLG = 'N'" ).append("\n"); 

	}
}