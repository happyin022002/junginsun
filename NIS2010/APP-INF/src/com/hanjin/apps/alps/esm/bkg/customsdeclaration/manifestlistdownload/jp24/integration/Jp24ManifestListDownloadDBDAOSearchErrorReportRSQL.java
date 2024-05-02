/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchErrorReportRSQL.java
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

public class Jp24ManifestListDownloadDBDAOSearchErrorReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchErrorReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchErrorReportRSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT1," ).append("\n"); 
		query.append("       ATTR_CTNT2," ).append("\n"); 
		query.append("       REPLACE(ATTR_CTNT4, '\r', '\n') AS ATTR_CTNT4," ).append("\n"); 
		query.append("       REPLACE(ATTR_CTNT5, '\r', '\n') AS ATTR_CTNT5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE CNT_CD = 'JP'" ).append("\n"); 
		query.append("   AND CSTMS_DIV_ID = 'JP24_ERR_ATD_CD'" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND ATTR_CTNT1 IN (SELECT SUBSTR(RCV_KEY_DAT_CTNT, 0, 5)" ).append("\n"); 
		query.append("                        FROM BKG_CSTMS_ADV_JP_RCV_LOG" ).append("\n"); 
		query.append("                       WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                         AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                         AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                         AND JP_MSG_TP_ID = @[jp_msg_tp_id]" ).append("\n"); 
		query.append("                         AND TO_CHAR(RCV_DT, 'YYYYMMDDHH24MI') = (SELECT MAX(TO_CHAR(RCV_DT, 'YYYYMMDDHH24MI'))" ).append("\n"); 
		query.append("                                                                    FROM BKG_CSTMS_ADV_JP_RCV_LOG" ).append("\n"); 
		query.append("                                                                   WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                                                     AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                                                     AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                                                                     AND JP_MSG_TP_ID = @[jp_msg_tp_id]))" ).append("\n"); 

	}
}