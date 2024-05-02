/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODMIFnDTICFreeTimeEndDateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.08.03 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAODMIFnDTICFreeTimeEndDateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMIFnDTICFreeTimeEndDateVO
	  * </pre>
	  */
	public DaoNameDAODMIFnDTICFreeTimeEndDateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ").append("\n"); 
		query.append("FileName : DaoNameDAODMIFnDTICFreeTimeEndDateVORSQL").append("\n"); 
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
		query.append("''  DMIF_FT_END" ).append("\n"); 
		query.append(",'' DTIC_FT_END" ).append("\n"); 
		query.append(",'' DTIC_FT_OVER" ).append("\n"); 
		query.append(",'' MSG_CD" ).append("\n"); 
		query.append(",'' MSG_DESC" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}