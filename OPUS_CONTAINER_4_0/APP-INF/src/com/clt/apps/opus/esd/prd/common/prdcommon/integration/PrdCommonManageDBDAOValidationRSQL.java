/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCommonManageDBDAOValidationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.14 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOValidationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Validation
	  * </pre>
	  */
	public PrdCommonManageDBDAOValidationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration ").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOValidationRSQL").append("\n"); 
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
		query.append("'' com_data2" ).append("\n"); 
		query.append(",'' com_data1" ).append("\n"); 
		query.append(",'' country_code" ).append("\n"); 
		query.append(",'' node_name" ).append("\n"); 
		query.append(",'' code" ).append("\n"); 
		query.append(",'' kind" ).append("\n"); 
		query.append(",'' pagerows" ).append("\n"); 
		query.append(",'' location_code" ).append("\n"); 
		query.append(",'' ibflag" ).append("\n"); 
		query.append(",'' chk" ).append("\n"); 
		query.append(",'' yard_code" ).append("\n"); 
		query.append(",'' lane_code" ).append("\n"); 
		query.append(",'' vendor_seq" ).append("\n"); 
		query.append(",'' check_data" ).append("\n"); 
		query.append(",'' node_code" ).append("\n"); 
		query.append(",'' vsl_slan_nm" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}