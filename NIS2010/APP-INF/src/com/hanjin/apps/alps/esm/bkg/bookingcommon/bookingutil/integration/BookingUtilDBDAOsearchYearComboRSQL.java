/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOsearchYearComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchYearComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOsearchYearComboRSQL
	  * </pre>
	  */
	public BookingUtilDBDAOsearchYearComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchYearComboRSQL").append("\n"); 
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
		query.append("/* Year 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT T_YEAR - CPY_NO CODE" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("           SELECT 2015 AS F_YEAR" ).append("\n"); 
		query.append("                 ,TO_CHAR(SYSDATE, 'YYYY') + 1 AS T_YEAR" ).append("\n"); 
		query.append("             FROM DUAL" ).append("\n"); 
		query.append("         ) Y" ).append("\n"); 
		query.append("        ,COM_CPY_NO C" ).append("\n"); 
		query.append("   WHERE C.CPY_NO <= T_YEAR - F_YEAR" ).append("\n"); 
		query.append("ORDER BY C.CPY_NO" ).append("\n"); 

	}
}