/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TimeClockStopMgtDBDAOSearchDMTYardByOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.11.22 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TimeClockStopMgtDBDAOSearchDMTYardByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Time Clock Stop Yard List
	  * </pre>
	  */
	public TimeClockStopMgtDBDAOSearchDMTYardByOfficeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration ").append("\n"); 
		query.append("FileName : TimeClockStopMgtDBDAOSearchDMTYardByOfficeRSQL").append("\n"); 
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
		query.append("SELECT YD_CD, YD_NM FROM MDM_YARD" ).append("\n"); 
		query.append("WHERE DMDT_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("        DEM_IB_CLT_FLG = 'Y'" ).append("\n"); 
		query.append("     OR DEM_OB_CLT_FLG = 'Y'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 

	}
}