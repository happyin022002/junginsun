/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSelMaxSimNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSelMaxSimNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Simulation No를 가져온다. 입력된 날짜 + Max Sequence No
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSelMaxSimNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSelMaxSimNoRSQL").append("\n"); 
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
		query.append("SELECT LPAD(NVL(MAX(TO_NUMBER(SIM_NO)),0)+1,3,'0') AS SIM_NO" ).append("\n"); 
		query.append("FROM VSK_SIM_INFO" ).append("\n"); 
		query.append("WHERE SIM_DT = TO_CHAR( sysdate ,'yyyymmdd' )  " ).append("\n"); 

	}
}