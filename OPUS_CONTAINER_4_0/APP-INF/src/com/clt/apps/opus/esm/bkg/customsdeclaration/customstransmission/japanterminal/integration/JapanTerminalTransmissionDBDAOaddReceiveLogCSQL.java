/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOaddReceiveLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOaddReceiveLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addReceiveLog
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOaddReceiveLogCSQL(){
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
		params.put("jp_svc_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_rcv_msg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOaddReceiveLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_JP_RCV_LOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (JP_MSG_TP_ID," ).append("\n"); 
		query.append("        RCV_DT," ).append("\n"); 
		query.append("        RCV_SEQ," ).append("\n"); 
		query.append("        JP_SVC_ID," ).append("\n"); 
		query.append("        RCV_KEY_DAT_CTNT," ).append("\n"); 
		query.append("        JP_BAT_NO," ).append("\n"); 
		query.append("        BKG_NO," ).append("\n"); 
		query.append("        EDI_RCV_MSG_CTNT," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES (@[jp_msg_tp_id]," ).append("\n"); 
		query.append("        NVL(GLOBALDATE_PKG.TIME_LOCAL_FNC('JPTYO'), SYSDATE)," ).append("\n"); 
		query.append("        @[rcv_seq]," ).append("\n"); 
		query.append("        @[jp_svc_id]," ).append("\n"); 
		query.append("        @[rcv_key_dat_ctnt]," ).append("\n"); 
		query.append("        @[jp_bat_no]," ).append("\n"); 
		query.append("        @[bkg_no]," ).append("\n"); 
		query.append("        @[edi_rcv_msg_ctnt]," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE)" ).append("\n"); 

	}
}