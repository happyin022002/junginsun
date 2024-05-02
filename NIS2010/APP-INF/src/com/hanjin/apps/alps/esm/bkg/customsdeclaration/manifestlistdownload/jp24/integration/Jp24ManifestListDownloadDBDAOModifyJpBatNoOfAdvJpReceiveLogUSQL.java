/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOModifyJpBatNoOfAdvJpReceiveLogUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.03.06 김상수
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

public class Jp24ManifestListDownloadDBDAOModifyJpBatNoOfAdvJpReceiveLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOModifyJpBatNoOfAdvJpReceiveLogUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOModifyJpBatNoOfAdvJpReceiveLogUSQL").append("\n"); 
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
		query.append("   SET RCV1.JP_BAT_NO = 1," ).append("\n"); 
		query.append("       UPD_USR_ID = @[usr_id]," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE (RCV1.JP_MSG_TP_ID," ).append("\n"); 
		query.append("        RCV1.RCV_DT," ).append("\n"); 
		query.append("        RCV1.MSG_RCV_NO) IN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            (SELECT /*+ INDEX_DESC(RCV XAK1BKG_CSTMS_ADV_JP_RCV_LOG) */" ).append("\n"); 
		query.append("                                    RCV.JP_MSG_TP_ID," ).append("\n"); 
		query.append("                                    RCV.RCV_DT," ).append("\n"); 
		query.append("                                    RCV.MSG_RCV_NO" ).append("\n"); 
		query.append("                               FROM BKG_CSTMS_ADV_JP_RCV_LOG RCV" ).append("\n"); 
		query.append("                              WHERE RCV.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                AND RCV.JP_SVC_ID = @[jp_svc_id]" ).append("\n"); 
		query.append("                                AND RCV.JP_MSG_TP_ID = @[jp_msg_tp_id]" ).append("\n"); 
		query.append("                                AND RCV_KEY_DAT_CTNT = @[rcv_key_dat_ctnt]" ).append("\n"); 
		query.append("                                AND ROWNUM = 1)" ).append("\n"); 

	}
}