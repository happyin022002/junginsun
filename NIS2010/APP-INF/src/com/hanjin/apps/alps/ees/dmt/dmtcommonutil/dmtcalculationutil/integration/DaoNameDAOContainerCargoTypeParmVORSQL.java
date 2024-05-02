/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOContainerCargoTypeParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.27 최성환
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
 * @since J2EE 1.4
 */

public class DaoNameDAOContainerCargoTypeParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public DaoNameDAOContainerCargoTypeParmVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("select" ).append("\n"); 
		query.append("'' DCGO_FLG" ).append("\n"); 
		query.append(",'' RC_FLG" ).append("\n"); 
		query.append(",'' AWK_CGO_FLG" ).append("\n"); 
		query.append(",'' RD_CGO_FLG" ).append("\n"); 
		query.append(",'' SOC_FLG" ).append("\n"); 
		query.append(",'' BB_CGO_FLG" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOContainerCargoTypeParmVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}