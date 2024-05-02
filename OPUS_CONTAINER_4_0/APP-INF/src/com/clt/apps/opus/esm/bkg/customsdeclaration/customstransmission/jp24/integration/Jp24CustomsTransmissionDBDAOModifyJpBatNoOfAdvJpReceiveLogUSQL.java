/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOModifyJpBatNoOfAdvJpReceiveLogUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.15 
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

public class Jp24CustomsTransmissionDBDAOModifyJpBatNoOfAdvJpReceiveLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOModifyJpBatNoOfAdvJpReceiveLogUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_svc_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_key_dat_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hbl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n"); 
		query.append("FileName : Jp24CustomsTransmissionDBDAOModifyJpBatNoOfAdvJpReceiveLogUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_JP_RCV_LOG RCV1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   SET RCV1.JP_BAT_NO = DECODE(@[rcv_key_dat_ctnt], 'DNU', 2, 1)," ).append("\n"); 
		query.append("       RCV1.UPD_USR_ID = @[usr_id]," ).append("\n"); 
		query.append("       RCV1.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE (RCV1.JP_MSG_TP_ID," ).append("\n"); 
		query.append("        RCV1.RCV_DT," ).append("\n"); 
		query.append("        RCV1.MSG_RCV_NO) IN (SELECT RCV.JP_MSG_TP_ID," ).append("\n"); 
		query.append("                                    RCV.RCV_DT," ).append("\n"); 
		query.append("                                    RCV.MSG_RCV_NO" ).append("\n"); 
		query.append("                               FROM BKG_CSTMS_ADV_JP_RCV_LOG RCV" ).append("\n"); 
		query.append("                              WHERE RCV.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                           #if (${hbl_no} == '')" ).append("\n"); 
		query.append("                                AND RCV.HBL_NO IS NULL" ).append("\n"); 
		query.append("                           #else" ).append("\n"); 
		query.append("                                AND RCV.HBL_NO = @[hbl_no]" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                                AND RCV.JP_SVC_ID = @[jp_svc_id]" ).append("\n"); 
		query.append("                                AND RCV.JP_MSG_TP_ID = @[jp_msg_tp_id]" ).append("\n"); 
		query.append("                                AND RCV_KEY_DAT_CTNT = @[rcv_key_dat_ctnt]" ).append("\n"); 
		query.append("                                AND NVL(RCV.JP_BAT_NO, 0) < 1)" ).append("\n"); 

	}
}