/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeClockStopMgtDBDAOGetAuthExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.08 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TimeClockStopMgtDBDAOGetAuthExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getAuthExist
	  * </pre>
	  */
	public TimeClockStopMgtDBDAOGetAuthExistRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT 'Y' AUTH_YN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (SELECT DISTINCT DMDT_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_YARD Y" ).append("\n"); 
		query.append(", (SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE NVL (DELT_FLG, ' ') <> 'Y'" ).append("\n"); 
		query.append("CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("START WITH OFC_CD = @[ofc_cd]) O" ).append("\n"); 
		query.append("WHERE Y.DMDT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("AND DELT_FLG = 'N')" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration ").append("\n"); 
		query.append("FileName : TimeClockStopMgtDBDAOGetAuthExistRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}