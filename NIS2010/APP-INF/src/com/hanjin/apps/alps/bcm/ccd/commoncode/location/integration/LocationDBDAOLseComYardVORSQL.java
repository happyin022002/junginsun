/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : LocationDBDAOLseComYardVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOLseComYardVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public LocationDBDAOLseComYardVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOLseComYardVORSQL").append("\n"); 
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
		query.append("'LSE_CO_YD_CD' LSE_CO_YD_CD," ).append("\n"); 
		query.append("'LSE_CO_YD_NM' LSE_CO_YD_NM," ).append("\n"); 
		query.append("'ONF_HIR_YD_FLG' ONF_HIR_YD_FLG," ).append("\n"); 
		query.append("'YD_ADDR' YD_ADDR," ).append("\n"); 
		query.append("'INTL_PHN_NO' INTL_PHN_NO," ).append("\n"); 
		query.append("'PHN_NO' PHN_NO," ).append("\n"); 
		query.append("'FAX_NO' FAX_NO," ).append("\n"); 
		query.append("'YD_EML' YD_EML," ).append("\n"); 
		query.append("'YD_PIC_NM' YD_PIC_NM," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ1' LSE_CO_VNDR_SEQ1," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ2' LSE_CO_VNDR_SEQ2," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ3' LSE_CO_VNDR_SEQ3," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ4' LSE_CO_VNDR_SEQ4," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ5' LSE_CO_VNDR_SEQ5," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ6' LSE_CO_VNDR_SEQ6," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ7' LSE_CO_VNDR_SEQ7," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ8' LSE_CO_VNDR_SEQ8," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ9' LSE_CO_VNDR_SEQ9," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ10' LSE_CO_VNDR_SEQ10," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ11' LSE_CO_VNDR_SEQ11," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ12' LSE_CO_VNDR_SEQ12," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ13' LSE_CO_VNDR_SEQ13," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ14' LSE_CO_VNDR_SEQ14," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ15' LSE_CO_VNDR_SEQ15," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ16' LSE_CO_VNDR_SEQ16," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ17' LSE_CO_VNDR_SEQ17," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ18' LSE_CO_VNDR_SEQ18," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ19' LSE_CO_VNDR_SEQ19," ).append("\n"); 
		query.append("'LSE_CO_VNDR_SEQ20' LSE_CO_VNDR_SEQ20," ).append("\n"); 
		query.append("'DELT_FLG' DELT_FLG," ).append("\n"); 
		query.append("'USR_ID' USR_ID" ).append("\n"); 
		query.append("FROM DUAL  " ).append("\n"); 

	}
}