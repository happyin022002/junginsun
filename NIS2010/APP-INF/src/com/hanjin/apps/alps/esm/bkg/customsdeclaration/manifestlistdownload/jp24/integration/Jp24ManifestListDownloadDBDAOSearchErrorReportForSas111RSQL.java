/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchErrorReportForSas111RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.27
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.02.27 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchErrorReportForSas111RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchErrorReportForSas111RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchErrorReportForSas111RSQL").append("\n"); 
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
		query.append("SELECT EDI_RCV_MSG_CTNT AS FLAT_FILE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_RCV_LOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND JP_MSG_TP_ID = @[jp_msg_tp_id]" ).append("\n"); 
		query.append("   AND TO_CHAR(RCV_DT, 'YYYYMMDDHH24MI') = (SELECT MAX(TO_CHAR(RCV_DT, 'YYYYMMDDHH24MI'))" ).append("\n"); 
		query.append("                                              FROM BKG_CSTMS_ADV_JP_RCV_LOG" ).append("\n"); 
		query.append("                                             WHERE BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("                                               AND JP_MSG_TP_ID = @[jp_msg_tp_id])" ).append("\n"); 

	}
}