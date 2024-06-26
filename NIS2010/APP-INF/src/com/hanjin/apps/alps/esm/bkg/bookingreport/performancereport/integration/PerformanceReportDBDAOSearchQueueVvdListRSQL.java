/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchQueueVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.18 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchQueueVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchQueueVvdListRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchQueueVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchQueueVvdListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD VSP" ).append("\n"); 
		query.append("WHERE VPS_ETD_DT >= TO_DATE(@[etd_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND  VPS_ETD_DT <= TO_DATE(@[etd_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 

	}
}