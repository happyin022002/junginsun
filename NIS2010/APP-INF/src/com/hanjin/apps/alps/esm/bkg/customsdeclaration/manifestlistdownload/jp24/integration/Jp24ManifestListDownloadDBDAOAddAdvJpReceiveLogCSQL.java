/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOAddAdvJpReceiveLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOAddAdvJpReceiveLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015.03.09 - 
	  * 전송 후 수신 되기 이전에 다시 전송 하는 경우 발생
	  * 따라서 SAMR, SCMR일 경우 수신된 데이터(가장 최근)가  00000-0000-0000 이고
	  * ERROR 메세지 수신 할 경우 INSERT 하지 않음
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOAddAdvJpReceiveLogCSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_bat_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_msg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOAddAdvJpReceiveLogCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_ADV_JP_RCV_LOG RCV_LOG" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT @[bkg_no]            AS BKG_NO," ).append("\n"); 
		query.append("@[jp_msg_tp_id]      AS JP_MSG_TP_ID," ).append("\n"); 
		query.append("@[rcv_key_dat_ctnt]  AS RCV_KEY_DAT_CTNT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") TM" ).append("\n"); 
		query.append("ON ( RCV_LOG.BKG_NO             = TM.BKG_NO                                                 			AND" ).append("\n"); 
		query.append("RCV_LOG.JP_MSG_TP_ID       = DECODE(TM.JP_MSG_TP_ID,'SAMR','SAMR','SCMR','SCMR','XXX') 			AND" ).append("\n"); 
		query.append("RCV_LOG.RCV_KEY_DAT_CTNT   = DECODE(TM.RCV_KEY_DAT_CTNT,'00000-0000-0000','XXX','00000-0000-0000') AND" ).append("\n"); 
		query.append("RCV_LOG.RCV_DT             = ( SELECT  MAX(RCV_DT)" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_ADV_JP_RCV_LOG" ).append("\n"); 
		query.append("WHERE   BKG_NO          = TM.BKG_NO" ).append("\n"); 
		query.append("AND     JP_MSG_TP_ID    = TM.JP_MSG_TP_ID )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET		 UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (JP_MSG_TP_ID," ).append("\n"); 
		query.append("RCV_DT," ).append("\n"); 
		query.append("MSG_RCV_NO," ).append("\n"); 
		query.append("RCV_SEQ," ).append("\n"); 
		query.append("JP_SVC_ID," ).append("\n"); 
		query.append("RCV_KEY_DAT_CTNT," ).append("\n"); 
		query.append("JP_BAT_NO," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("POL_CD," ).append("\n"); 
		query.append("POD_CD," ).append("\n"); 
		query.append("POR_CD," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("EDI_RCV_MSG_CTNT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES (@[jp_msg_tp_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("SUBSTR(LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL, '000009'), ' '), 2)||TO_CHAR(SYSDATE, 'yyyyMMddHH24miss')," ).append("\n"); 
		query.append("@[rcv_seq]," ).append("\n"); 
		query.append("@[jp_svc_id]," ).append("\n"); 
		query.append("@[rcv_key_dat_ctnt]," ).append("\n"); 
		query.append("@[jp_bat_no]," ).append("\n"); 
		query.append("@[vsl_cd]," ).append("\n"); 
		query.append("@[skd_voy_no]," ).append("\n"); 
		query.append("@[skd_dir_cd]," ).append("\n"); 
		query.append("@[pol_cd]," ).append("\n"); 
		query.append("@[pod_cd]," ).append("\n"); 
		query.append("@[por_cd]," ).append("\n"); 
		query.append("@[bkg_no]," ).append("\n"); 
		query.append("@[edi_rcv_msg_ctnt]," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}