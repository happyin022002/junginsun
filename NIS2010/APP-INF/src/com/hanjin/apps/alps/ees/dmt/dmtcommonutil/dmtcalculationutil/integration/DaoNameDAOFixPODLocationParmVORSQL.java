/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DaoNameDAOFixPODLocationParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.01
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.04.01 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOFixPODLocationParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public DaoNameDAOFixPODLocationParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOFixPODLocationParmVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' POD_CD" ).append("\n"); 
		query.append(",'' DEL_CD" ).append("\n"); 
		query.append(",'' POST_RLY" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' CNMS_CD" ).append("\n"); 
		query.append(",'' ORG_YD_CD" ).append("\n"); 
		query.append(",'' IO_BND_CD" ).append("\n"); 
		query.append("from DUAL" ).append("\n"); 

	}
}