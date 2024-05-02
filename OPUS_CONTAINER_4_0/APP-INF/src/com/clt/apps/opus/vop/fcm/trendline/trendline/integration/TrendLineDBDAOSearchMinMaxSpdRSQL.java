/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrendLineDBDAOSearchMinMaxSpdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.21
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.21 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.trendline.trendline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrendLineDBDAOSearchMinMaxSpdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL에 해당하는 MIN, MAX SPD를 구한다.(VSL이 여러 종류인 경우, 가장 작은 MAX & 가장 큰 MIN)
	  * </pre>
	  */
	public TrendLineDBDAOSearchMinMaxSpdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.trendline.trendline.integration").append("\n"); 
		query.append("FileName : TrendLineDBDAOSearchMinMaxSpdRSQL").append("\n"); 
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
		query.append("SELECT MAX(OP_MIN_SPD) MIN_SPD, MIN(OP_MAX_SPD) MAX_SPD FROM FCM_VSL_CNTR_RGST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${arr_vsl_cd}!='')" ).append("\n"); 
		query.append("AND VSL_CD IN (#foreach( $key IN ${arr_vsl_cd}) " ).append("\n"); 
		query.append("	      	     #if($velocityCount < $arr_vsl_cd.size())" ).append("\n"); 
		query.append("  	                '$key'," ).append("\n"); 
		query.append("	             #else" ).append("\n"); 
		query.append("	                '$key'" ).append("\n"); 
		query.append("	             #end" ).append("\n"); 
		query.append("	           #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}