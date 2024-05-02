/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchPolCdCheckRSQL.java
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

public class DailyForecastManageDBDAOSearchPolCdCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POL_CD 의 유효성을 체크한다.
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchPolCdCheckRSQL(){
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
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : DailyForecastManageDBDAOSearchPolCdCheckRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*),0,'N','Y') POL_YN " ).append("\n"); 
		query.append("  FROM SPC_FCAST_OFC_POL_MAPG T1 , " ).append("\n"); 
		query.append("       COA_MON_VVD T2 " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND T1.TRD_CD = T2.TRD_CD " ).append("\n"); 
		query.append("       AND T1.SUB_TRD_CD = T2.SUB_TRD_CD " ).append("\n"); 
		query.append("       AND T1.RLANE_CD = T2.RLANE_CD " ).append("\n"); 
		query.append("       AND T1.DIR_CD = T2.DIR_CD " ).append("\n"); 
		query.append("       AND T2.IOC_CD = DECODE(T1.IOC_TS_CD, 'O', 'O', 'I') " ).append("\n"); 
		query.append("       AND T1.SLS_OFC_CD IN (SELECT N4TH_PRNT_OFC_CD FROM SPC_OFC_LVL " ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("                               AND OFC_CD = @[fcast_ofc_cd]) " ).append("\n"); 
		query.append("       AND T2.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("       AND T2.SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("       AND T2.DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("       AND T1.POL_CD = SUBSTR(@[pol_yd_cd], 1, 5)" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       #if (${trd_cd} != '')  " ).append("\n"); 
		query.append("       AND T1.TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${sub_trd_cd} != '')  " ).append("\n"); 
		query.append("       AND T1.SUB_TRD_CD = @[sub_trd_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${rlane_cd} != '')  " ).append("\n"); 
		query.append("       AND T1.RLANE_CD = @[rlane_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${dir_cd} != '')  " ).append("\n"); 
		query.append("       AND T1.DIR_CD = @[dir_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${ioc_ts_cd} != '')  " ).append("\n"); 
		query.append("       AND T2.IOC_CD = DECODE(@[ioc_ts_cd] , 'O', 'O', 'I') " ).append("\n"); 
		query.append("       #end" ).append("\n"); 

	}
}