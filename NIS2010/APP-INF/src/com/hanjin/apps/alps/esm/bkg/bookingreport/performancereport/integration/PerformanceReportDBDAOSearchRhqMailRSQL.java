/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchRhqMailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchRhqMailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchRhqMailRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchRhqMailRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchRhqMailRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(MAS_OFC_LVL XPKMAS_OFC_LVL) */ H.ATTR_CTNT2" ).append("\n"); 
		query.append("FROM COM_USER U, MAS_OFC_LVL O, BKG_HRD_CDG_CTNT H" ).append("\n"); 
		query.append("WHERE U.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND U.OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("AND O.OFC_N2ND_LVL_CD = H.ATTR_CTNT1 --RHQ" ).append("\n"); 
		query.append("AND H.HRD_CDG_ID = 'SI_TRANS_MAIL'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}