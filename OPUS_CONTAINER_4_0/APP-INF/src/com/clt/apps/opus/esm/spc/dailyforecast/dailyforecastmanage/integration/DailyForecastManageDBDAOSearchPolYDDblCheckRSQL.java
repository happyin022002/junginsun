/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchPolYDDblCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.15 
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

public class DailyForecastManageDBDAOSearchPolYDDblCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POL_YD_CD 더블 콜링 여부를 체크한다.
	  * 2015.07.22. SKY[CLT-000042051-10] Virtual add call - VT_ADD_CALL_FLG IS  NULL 로직 추가
	  * 2016.03.15 SKY - Double Calling check 로직 추가 
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchPolYDDblCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : DailyForecastManageDBDAOSearchPolYDDblCheckRSQL").append("\n"); 
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
		query.append("       CASE WHEN COUNT(*) > 1 THEN 'N' ELSE 'Y' END POL_YD_DBL_YN " ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("       AND SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("       AND SKD_DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("       AND YD_CD = @[pol_yd_cd]" ).append("\n"); 
		query.append("       AND VT_ADD_CALL_FLG IS  NULL" ).append("\n"); 
		query.append("       AND TURN_PORT_IND_CD IN ('Y','N') " ).append("\n"); 
		query.append("      " ).append("\n"); 

	}
}