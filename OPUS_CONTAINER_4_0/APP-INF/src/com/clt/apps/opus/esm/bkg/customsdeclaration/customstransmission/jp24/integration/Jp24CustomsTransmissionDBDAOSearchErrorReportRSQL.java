/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOSearchErrorReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24CustomsTransmissionDBDAOSearchErrorReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOSearchErrorReportRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n"); 
		query.append("FileName : Jp24CustomsTransmissionDBDAOSearchErrorReportRSQL").append("\n"); 
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
		query.append("       ATTR_CTNT4," ).append("\n"); 
		query.append("       ATTR_CTNT5" ).append("\n"); 
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