/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchDpcsSiTransEmlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchDpcsSiTransEmlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchDpcsSiTransEmlR
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchDpcsSiTransEmlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration ").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchDpcsSiTransEmlRSQL").append("\n"); 
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
		query.append("SELECT H.ATTR_CTNT2" ).append("\n"); 
		query.append("FROM COM_USER U, BKG_PFX_ROUT P, BKG_HRD_CDG_CTNT H" ).append("\n"); 
		query.append("WHERE U.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND U.OFC_CD LIKE P.OFC_PFX_CD||'%'" ).append("\n"); 
		query.append("AND P.SYS_AREA_GRP_ID = H.ATTR_CTNT1 -- SVR_ID" ).append("\n"); 
		query.append("AND H.HRD_CDG_ID = 'SI_TRANS_MAIL' " ).append("\n"); 

	}
}