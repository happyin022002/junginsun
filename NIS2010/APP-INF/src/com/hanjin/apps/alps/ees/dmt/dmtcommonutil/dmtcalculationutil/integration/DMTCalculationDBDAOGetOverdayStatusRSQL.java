/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DMTCalculationDBDAOGetOverdayStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetOverdayStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetOverdayStatus
	  * </pre>
	  */
	public DMTCalculationDBDAOGetOverdayStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_hr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftime_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstop_total rtn_over_day",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetOverdayStatusRSQL").append("\n"); 
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
		query.append("#if (${type} == '1')" ).append("\n"); 
		query.append("TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), SYSDATE), 'YYYYMMDD') prm_to_date, SUBSTR(@[ftime_end], 1, 8) prm_ftime_end" ).append("\n"); 
		query.append("#elseif (${type} == '2')" ).append("\n"); 
		query.append("SUBSTR(@[to_date], 1,	8) prm_to_date, SUBSTR(@[ftime_end], 1, 8) prm_ftime_end" ).append("\n"); 
		query.append("#elseif (${type} == '3')" ).append("\n"); 
		query.append("TO_DATE(@[to_date],'YYYYMMDD') - TO_DATE(@[ftime_end],'YYYYMMDD') check_num" ).append("\n"); 
		query.append("#elseif (${type} == '4')" ).append("\n"); 
		query.append("TO_DATE(@[to_date],'YYYYMMDD') - TO_DATE(@[ftime_end],'YYYYMMDD') - @[cstop_total rtn_over_day] rtn_over_day" ).append("\n"); 
		query.append("#elseif (${type} == '5')" ).append("\n"); 
		query.append("NVL(TO_DATE(@[to_date], 'YYYYMMDD'), TO_DATE(TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), SYSDATE),'YYYYMMDD'), 'YYYYMMDD')) - TO_DATE(@[mt_date],'YYYYMMDD') check_grace" ).append("\n"); 
		query.append("#elseif (${type} == '6')" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(SUBSTR(@[to_date],1,8), 'YYYYMMDD') + DECODE(SIGN(TO_DATE(SUBSTR(@[to_date],1,10), 'YYYYMMDDHH24') - TO_DATE(substr(@[to_date],1,8)||NVL(@[end_hr],'00'), 'YYYYMMDDHH24')),-1,-1,0),'YYYYMMDD') prm_to_date" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}