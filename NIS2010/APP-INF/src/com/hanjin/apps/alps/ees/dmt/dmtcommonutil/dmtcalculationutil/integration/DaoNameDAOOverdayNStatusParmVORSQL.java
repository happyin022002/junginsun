/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DaoNameDAOOverdayNStatusParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.06
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.12.06 김태균
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

public class DaoNameDAOOverdayNStatusParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OverdayNStatusParmVO
	  * </pre>
	  */
	public DaoNameDAOOverdayNStatusParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOOverdayNStatusParmVORSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("'' to_date" ).append("\n"); 
		query.append(",'' ftime_end" ).append("\n"); 
		query.append(",'' dtt_code" ).append("\n"); 
		query.append(",'' ofc_cd" ).append("\n"); 
		query.append(",'' mt_date" ).append("\n"); 
		query.append(",'' cstop_idx" ).append("\n"); 
		query.append(",'' yard_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}