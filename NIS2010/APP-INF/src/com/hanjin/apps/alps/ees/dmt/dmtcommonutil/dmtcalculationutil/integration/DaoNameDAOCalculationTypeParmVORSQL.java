/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DaoNameDAOCalculationTypeParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.03.26 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOCalculationTypeParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CalculationTypeParmVO
	  * </pre>
	  */
	public DaoNameDAOCalculationTypeParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOCalculationTypeParmVORSQL").append("\n"); 
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
		query.append("'' RGN_CD" ).append("\n"); 
		query.append(",'' IO_BND" ).append("\n"); 
		query.append(",'' POR_LOC" ).append("\n"); 
		query.append(",'' POL_LOC" ).append("\n"); 
		query.append(",'' POD_LOC" ).append("\n"); 
		query.append(",'' DEL_LOC" ).append("\n"); 
		query.append(",'' BCNTR_DLV_TERM" ).append("\n"); 
		query.append(",'' LOC_CD" ).append("\n"); 
		query.append(",'' EFF_DT" ).append("\n"); 
		query.append(",'' CNT_CD" ).append("\n"); 
		query.append(",'' POD_ETA_FLG" ).append("\n"); 
		query.append(",'' STATE_CD" ).append("\n"); 
		query.append(",'' POD_ETA_YN" ).append("\n"); 
		query.append(",'' LOC_RHQ_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}