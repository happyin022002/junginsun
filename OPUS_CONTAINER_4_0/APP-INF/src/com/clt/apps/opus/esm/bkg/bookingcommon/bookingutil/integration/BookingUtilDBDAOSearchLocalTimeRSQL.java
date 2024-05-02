/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingUtilDBDAOSearchLocalTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.05.30 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sang-Soo KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchLocalTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLocalTime
	  * </pre>
	  */
	public BookingUtilDBDAOSearchLocalTimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchLocalTimeRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, @[usr_loc_cd]), SYSDATE), 'YYYY-MM-DD HH24:MI:SS') AS LCL_DT_TM" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}