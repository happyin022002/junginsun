/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchTimeLocalOfcFncRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.11.04 민동진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min, DongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchTimeLocalOfcFncRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 	 * GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(String OfficeCd)를 호출하는 method
	  * </pre>
	  */
	public BookingUtilDBDAOSearchTimeLocalOfcFncRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchTimeLocalOfcFncRSQL").append("\n"); 
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
		query.append("-- GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(String OfficeCd)를 호출하는 method" ).append("\n"); 
		query.append("-- 즉, Office Cd의 Local Time을 YYYY-MM-DD HH24:MI:SS 포맷의 string으로 반환" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), 'YYYY-MM-DD HH24:MI:SS') AS OFC_LCL_DT_TM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}