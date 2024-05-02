/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchPolPodCdCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.08 
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

public class DailyForecastManageDBDAOSearchPolPodCdCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD에 POL, POD 넣을때 Skip 여부를 체크 한다.
	  * 2015.07.22. SKY[CLT-000042051-10] Virtual add call - VT_ADD_CALL_FLG IS  NULL  로직 추가
	  * 2016.04.07 PORT SKIP 체크 로직 수정 by 서관영
	  * 2016.04.08 PORT SKIP 체크 로직 수정 : VPS_PORT_CD ==> YD_CD
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchPolPodCdCheckRSQL(){
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
		query.append("FileName : DailyForecastManageDBDAOSearchPolPodCdCheckRSQL").append("\n"); 
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
		query.append("       DECODE(COUNT(*),0,'Y','N') POL_POD_YN " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append(" WHERE  1=1 " ).append("\n"); 
		query.append("       AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("       AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("       AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("       AND YD_CD = @[pol_yd_cd]" ).append("\n"); 
		query.append("       AND SKD_CNG_STS_CD = 'S'" ).append("\n"); 
		query.append("       --AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("       AND VT_ADD_CALL_FLG IS  NULL" ).append("\n"); 

	}
}