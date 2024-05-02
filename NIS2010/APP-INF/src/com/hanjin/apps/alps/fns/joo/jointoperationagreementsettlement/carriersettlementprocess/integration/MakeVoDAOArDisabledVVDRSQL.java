/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVoDAOArDisabledVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.28 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVoDAOArDisabledVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVoDAOArDisabledVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : MakeVoDAOArDisabledVVDRSQL").append("\n"); 
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
		query.append("SELECT  ''RLANE_CD" ).append("\n"); 
		query.append(",       ''VSL_CD" ).append("\n"); 
		query.append(",       ''SKD_VOY_NO" ).append("\n"); 
		query.append(",       ''SKD_DIR_CD" ).append("\n"); 
		query.append(",       ''RLANE_DIR_CD" ).append("\n"); 
		query.append(",       ''REV_YRMON" ).append("\n"); 
		query.append(",       ''EAI_EVNT_DT" ).append("\n"); 
		query.append(",       ''SLIP_YN" ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}