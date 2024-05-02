/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchVvdCdCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.09 
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

public class DailyForecastManageDBDAOSearchVvdCdCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 가 유효한지 체크한다.
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchVvdCdCheckRSQL(){
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
		query.append("FileName : DailyForecastManageDBDAOSearchVvdCdCheckRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*),0,'N',1,'Y','D') VVD_YN " ).append("\n"); 
		query.append("  FROM COA_MON_VVD  " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND IOC_CD = DECODE(@[ioc_ts_cd], 'O', 'O', 'I') " ).append("\n"); 
		query.append("       AND VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("       AND SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("       AND DIR_CD = @[skd_dir_cd]  " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       #if (${trd_cd} != '') " ).append("\n"); 
		query.append("       AND TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("	   #if (${sub_trd_cd} != '') 	" ).append("\n"); 
		query.append("       AND SUB_TRD_CD = @[sub_trd_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${rlane_cd} != '') 	" ).append("\n"); 
		query.append("       AND RLANE_CD = @[rlane_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 

	}
}