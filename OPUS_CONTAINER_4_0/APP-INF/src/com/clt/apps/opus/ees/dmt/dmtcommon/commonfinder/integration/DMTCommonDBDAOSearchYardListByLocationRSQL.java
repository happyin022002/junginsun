/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DMTCommonDBDAOSearchYardListByLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchYardListByLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchYardListByLocation
	  * </pre>
	  */
	public DMTCommonDBDAOSearchYardListByLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchYardListByLocationRSQL").append("\n"); 
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
		query.append("SELECT YD_CD, SUBSTR(YD_CD, 6,2) AS YD_CD2" ).append("\n"); 
		query.append("FROM MDM_YARD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("	@[yd_cd1] = DECODE(LENGTH(@[yd_cd1]),5,SUBSTR(YD_CD, 1,5),YD_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND LOC_CD IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY YD_CD" ).append("\n"); 

	}
}