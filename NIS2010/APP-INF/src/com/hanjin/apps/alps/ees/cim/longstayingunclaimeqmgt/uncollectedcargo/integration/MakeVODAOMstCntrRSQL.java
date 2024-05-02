/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MakeVODAOMstCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAOMstCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * managing Master Container concerned with Uncollected Cargo Container List 
	  * </pre>
	  */
	public MakeVODAOMstCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : MakeVODAOMstCntrRSQL").append("\n"); 
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
		query.append("SELECT	  '' uc_cs_no" ).append("\n"); 
		query.append("		, '' bl_no" ).append("\n"); 
		query.append("		, '' cntr_no" ).append("\n"); 
		query.append("		, '' uclm_ls_div_cd" ).append("\n"); 
		query.append("        , '' uclm_dt" ).append("\n"); 
		query.append("        , '' uclm_rsn" ).append("\n"); 
		query.append("		, '' uc_rsn_cd" ).append("\n"); 
		query.append("        , '' uclm_end_dt" ).append("\n"); 
		query.append("		, '' temp1" ).append("\n"); 
		query.append("FROM 	DUAL" ).append("\n"); 

	}
}