/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOSearchAllXchRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchAllXchRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve all exchange information information regarding BKG
	  * </pre>
	  */
	public BookingUtilDBDAOSearchAllXchRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchAllXchRateRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT CURR_CD, L_CURR_CD, INV_XCH_RT, TYPE" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T.V_CURR_CD AS CURR_CD, V_AR_CURR_CD AS L_CURR_CD, V_EX_RATE AS INV_XCH_RT, 'C' AS TYPE" ).append("\n"); 
		query.append("  FROM  TABLE( BKG_EXCH_RATE_ALL_CUR_PKG.GET_EXCH_RATE_FNC(@[bkg_no], 'C', '') ) T" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT T.V_CURR_CD AS CURR_CD, V_AR_CURR_CD AS L_CURR_CD, V_EX_RATE AS INV_XCH_RT, 'P' AS TYPE" ).append("\n"); 
		query.append("  FROM  TABLE( BKG_EXCH_RATE_ALL_CUR_PKG.GET_EXCH_RATE_FNC(@[bkg_no], 'P', '') ) T" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE INV_XCH_RT <> 0" ).append("\n"); 
		query.append("#if(${chg_currs} != '')" ).append("\n"); 
		query.append("AND CURR_CD IN ( NULL" ).append("\n"); 
		query.append("       #foreach($chg_currs IN ${chg_currs})" ).append("\n"); 
		query.append("           #if ($velocityCount < $chg_currs.size()) " ).append("\n"); 
		query.append("           , '$chg_currs'" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("           , '$chg_currs'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}