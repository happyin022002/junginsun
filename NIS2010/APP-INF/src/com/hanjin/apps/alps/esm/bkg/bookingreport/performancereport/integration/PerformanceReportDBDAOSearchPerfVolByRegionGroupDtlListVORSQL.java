/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchPerfVolByRegionGroupDtlListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.28
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.28 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchPerfVolByRegionGroupDtlListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchPerfVolByRegionGroupDtlListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchPerfVolByRegionGroupDtlListVORSQL").append("\n"); 
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
		query.append("  '' RTN_FREQ" ).append("\n"); 
		query.append(", '' AMD_FREQ" ).append("\n"); 
		query.append(", '' PIC_USR_ID" ).append("\n"); 
		query.append(", '' USR_NM" ).append("\n"); 
		query.append(", '' USR_GROUP" ).append("\n"); 
		query.append(", '' REGION" ).append("\n"); 
		query.append(", '' BKG_NO" ).append("\n"); 
		query.append(", '' SI_NO" ).append("\n"); 
		query.append(", '' SI_KND" ).append("\n"); 
		query.append(", '' URGENT" ).append("\n"); 
		query.append(", '' SRC" ).append("\n"); 
		query.append(", '' VVD_CD" ).append("\n"); 
		query.append(", '' POL" ).append("\n"); 
		query.append(", '' DEL" ).append("\n"); 
		query.append(", '' REGION_NM" ).append("\n"); 
		query.append(", '' SR_URG_NM" ).append("\n"); 
		query.append(", '' CNTR_CNT" ).append("\n"); 
		query.append(", '' CM_CNT" ).append("\n"); 
		query.append(", '' H_BL" ).append("\n"); 
		query.append(", '' SELF_AUDIT" ).append("\n"); 
		query.append(", '' RATE_TYPE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}