/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchYrWkCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.03 
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

public class DailyForecastManageDBDAOSearchYrWkCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 의 해당 년도와 주차를 체크한다.
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchYrWkCheckRSQL(){
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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchYrWkCheckRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(T.SLS_YRMON, 1, 4) AS SLS_YRMON " ).append("\n"); 
		query.append("     , T.COST_WK " ).append("\n"); 
		query.append("  FROM COA_MON_VVD T " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND T.IOC_CD = DECODE(@[ioc_ts_cd] , 'O', 'O', 'I') " ).append("\n"); 
		query.append("       AND T.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("       AND T.SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("       AND T.DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("       AND " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("           T.DELT_FLG IS NULL " ).append("\n"); 
		query.append("           OR T.DELT_FLG = 'N' " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if (${trd_cd} != '') " ).append("\n"); 
		query.append("       AND T.TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${rlane_cd} != '') " ).append("\n"); 
		query.append("       AND T.RLANE_CD = @[rlane_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${sub_trd_cd} != '') " ).append("\n"); 
		query.append("       AND T.SUB_TRD_CD = @[sub_trd_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 

	}
}