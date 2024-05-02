/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOSearchErrorReportForAmrCmrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03 
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

public class Jp24CustomsTransmissionDBDAOSearchErrorReportForAmrCmrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOSearchErrorReportForAmrCmrRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n"); 
		query.append("FileName : Jp24CustomsTransmissionDBDAOSearchErrorReportForAmrCmrRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(C.ATTR_CTNT1, 3) AS ATTR_CTNT1," ).append("\n"); 
		query.append("       C.ATTR_CTNT2," ).append("\n"); 
		query.append("       (SELECT M.ATTR_CTNT4" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_CD_CONV_CTNT M" ).append("\n"); 
		query.append("         WHERE M.ATTR_CTNT1 = C.ATTR_CTNT1" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS ATTR_CTNT4," ).append("\n"); 
		query.append("       (SELECT M.ATTR_CTNT5" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_CD_CONV_CTNT M" ).append("\n"); 
		query.append("         WHERE M.ATTR_CTNT1 = C.ATTR_CTNT1" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS ATTR_CTNT5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_CD_CONV_CTNT C," ).append("\n"); 
		query.append("       (SELECT RCV_KEY_DAT_CTNT ERR_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_RCV_LOG" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("           AND JP_MSG_TP_ID = @[jp_msg_tp_id]" ).append("\n"); 
		query.append("           AND TO_CHAR(RCV_DT, 'YYYYMMDDHH24MI') = (SELECT MAX(TO_CHAR(RCV_DT, 'YYYYMMDDHH24MI'))" ).append("\n"); 
		query.append("                                                      FROM BKG_CSTMS_ADV_JP_RCV_LOG" ).append("\n"); 
		query.append("                                                     WHERE BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                       AND JP_MSG_TP_ID = @[jp_msg_tp_id])" ).append("\n"); 
		query.append("       ) RSLT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE C.CSTMS_DIV_ID = 'JP24_ERR_CD_DTL'" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND (C.ATTR_CTNT1 = DECODE(@[jp_msg_tp_id], 'SAMR', 'A-', 'SCMR', 'C-')||SUBSTR(RSLT.ERR_CD, 1, 5) OR" ).append("\n"); 
		query.append("        C.ATTR_CTNT1 = 'T-'||SUBSTR(RSLT.ERR_CD, 1, 5))" ).append("\n"); 
		query.append("   AND C.ATTR_CTNT3 = SUBSTR(RSLT.ERR_CD, 7, 3)" ).append("\n"); 

	}
}