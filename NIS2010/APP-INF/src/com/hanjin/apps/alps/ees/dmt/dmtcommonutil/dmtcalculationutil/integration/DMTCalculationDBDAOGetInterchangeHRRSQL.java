/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCalculationDBDAOGetInterchangeHRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.23 
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

public class DMTCalculationDBDAOGetInterchangeHRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetInterchangeHR
	  * </pre>
	  */
	public DMTCalculationDBDAOGetInterchangeHRRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmnc_hr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetInterchangeHRRSQL").append("\n"); 
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
		query.append("SELECT	DECODE	(" ).append("\n"); 
		query.append("SIGN( TO_NUMBER(SUBSTR(@[from_dt],9,4)) - ( TO_NUMBER(@[cmnc_hr]||'00') ) )," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("TO_CHAR( TO_DATE(@[from_dt],'YYYYMMDDHH24MI') + 1,  'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("0," ).append("\n"); 
		query.append("TO_CHAR( TO_DATE(@[from_dt],'YYYYMMDDHH24MI') + 1,  'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("@[from_dt]" ).append("\n"); 
		query.append(")	from_dt" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}