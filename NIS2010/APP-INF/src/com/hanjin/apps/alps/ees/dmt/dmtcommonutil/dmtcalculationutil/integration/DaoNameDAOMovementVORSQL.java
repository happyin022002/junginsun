/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOMovementVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.07 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOMovementVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MovementVO
	  * </pre>
	  */
	public DaoNameDAOMovementVORSQL(){
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' CNMV_YY" ).append("\n"); 
		query.append(",'' CNMV_SEQ" ).append("\n"); 
		query.append(",'' CNMV_SPLIT" ).append("\n"); 
		query.append(",'' CNMS_CD" ).append("\n"); 
		query.append(",'' ORG_YD_CD" ).append("\n"); 
		query.append(",'' CNMV_DT_TM" ).append("\n"); 
		query.append(",'' FULL_FLG" ).append("\n"); 
		query.append(",'' CNMV_CYC_NO" ).append("\n"); 
		query.append(",'' MSG_CD" ).append("\n"); 
		query.append(",'' MSG_DESC" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ").append("\n"); 
		query.append("FileName : DaoNameDAOMovementVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}