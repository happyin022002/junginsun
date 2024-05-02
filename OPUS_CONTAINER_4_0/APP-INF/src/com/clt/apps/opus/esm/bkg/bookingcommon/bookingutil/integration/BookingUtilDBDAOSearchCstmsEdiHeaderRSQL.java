/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingUtilDBDAOSearchCstmsEdiHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.02 
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

public class BookingUtilDBDAOSearchCstmsEdiHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOSearchCstmsEdiHeaderR
	  * </pre>
	  */
	public BookingUtilDBDAOSearchCstmsEdiHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchCstmsEdiHeaderRSQL").append("\n"); 
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
		query.append("SELECT '$$$MSGSTART:'||" ).append("\n"); 
		query.append("        RPAD(NVL(TRIM(@[sndr_id]),' '),20,' ')||" ).append("\n"); 
		query.append("        RPAD(NVL(TRIM(@[rcv_id]),' '),20,' ')||" ).append("\n"); 
		query.append("        RPAD(NVL(TRIM(@[msg_id]),' '),10,' ')" ).append("\n"); 
		query.append("       AS STR_FLATFILE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}