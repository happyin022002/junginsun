/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JapanCustomsReportDBDAOsearchJpcusReceiveLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsReportDBDAOsearchJpcusReceiveLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchJpcusReceiveLog
	  * </pre>
	  */
	public JapanCustomsReportDBDAOsearchJpcusReceiveLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsReportDBDAOsearchJpcusReceiveLogRSQL").append("\n"); 
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
		query.append("SELECT EDI_RCV_MSG_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_JP_RCV_LOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE JP_MSG_TP_ID = @[jp_msg_tp_cd]" ).append("\n"); 
		query.append("   AND RCV_DT = TO_DATE(@[rcv_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("   AND RCV_SEQ = @[rcv_seq]" ).append("\n"); 

	}
}