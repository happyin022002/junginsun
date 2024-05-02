/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchOfcTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchOfcTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchOfcTimeRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchOfcTimeRSQL").append("\n"); 
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
		query.append("#if(${use_id} == '')" ).append("\n"); 
		query.append("SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, " ).append("\n"); 
		query.append("       GLOBALDATE_PKG.GET_LOCCD_FNC((SELECT OFC_CD " ).append("\n"); 
		query.append("                                       FROM COM_USER" ).append("\n"); 
		query.append("                                      WHERE USR_ID =@[usr_id])" ).append("\n"); 
		query.append("       )),'YYYYMMDD HH24MM') AS OFC_TIME " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, " ).append("\n"); 
		query.append("	(SELECT  BKG_COM_USER_LOC_FNC(@[usr_id]) FROM DUAL)),'YYYYMMDD HH24MI') AS OFC_TIME  FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}