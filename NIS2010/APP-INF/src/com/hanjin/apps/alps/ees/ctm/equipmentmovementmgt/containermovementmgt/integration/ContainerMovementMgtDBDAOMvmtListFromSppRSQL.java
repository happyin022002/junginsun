/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOMvmtListFromSppRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.05.11 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOMvmtListFromSppRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPP에서 넘어오는 VO생성용 더미 쿼리
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOMvmtListFromSppRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOMvmtListFromSppRSQL").append("\n"); 
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
		query.append("SELECT '' AS SVR_ID," ).append("\n"); 
		query.append("'' AS CNT_CD_R," ).append("\n"); 
		query.append("'' AS CNMS_CD," ).append("\n"); 
		query.append("'' AS ORG_YD_CD," ).append("\n"); 
		query.append("'' AS INP_YD_CD," ).append("\n"); 
		query.append("'' AS CNMV_DT_TM," ).append("\n"); 
		query.append("'' AS CNMV_UNM," ).append("\n"); 
		query.append("'' AS CNMV_USID," ).append("\n"); 
		query.append("'' AS CNTR_NO," ).append("\n"); 
		query.append("'' AS BKG_NO," ).append("\n"); 
		query.append("'' AS BKG_NO_SPLIT," ).append("\n"); 
		query.append("'' AS BL_NO," ).append("\n"); 
		query.append("'' AS VSL_CD," ).append("\n"); 
		query.append("'' AS SKD_VOYAGE_NO," ).append("\n"); 
		query.append("'' AS SKD_DIR_CD," ).append("\n"); 
		query.append("'' AS POL_LOC," ).append("\n"); 
		query.append("'' AS POD_LOC," ).append("\n"); 
		query.append("'' AS USRS10," ).append("\n"); 
		query.append("'' AS DST_YD_CD," ).append("\n"); 
		query.append("'' AS USRS88," ).append("\n"); 
		query.append("'' AS USRS89," ).append("\n"); 
		query.append("'' AS CNMV_RMK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}