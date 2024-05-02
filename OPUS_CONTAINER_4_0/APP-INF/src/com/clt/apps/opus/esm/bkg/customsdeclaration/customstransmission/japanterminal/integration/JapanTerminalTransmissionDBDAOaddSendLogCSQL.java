/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOaddSendLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.08 
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

public class JapanTerminalTransmissionDBDAOaddSendLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOaddSendLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_msg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_snd_log_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("log_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOaddSendLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_JP_SND_LOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (JP_SND_LOG_ID," ).append("\n"); 
		query.append("        SND_DT," ).append("\n"); 
		query.append("        OFC_CD," ).append("\n"); 
		query.append("        LOG_SEQ," ).append("\n"); 
		query.append("        VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        POL_CD," ).append("\n"); 
		query.append("        POL_YD_CD," ).append("\n"); 
		query.append("        POR_CD," ).append("\n"); 
		query.append("        POR_YD_CD," ).append("\n"); 
		query.append("        POD_CD," ).append("\n"); 
		query.append("        LOG_FLG," ).append("\n"); 
		query.append("        LOG_DT," ).append("\n"); 
		query.append("        BL_NO," ).append("\n"); 
		query.append("        SND_FLG," ).append("\n"); 
		query.append("        EDI_SND_MSG_CTNT," ).append("\n"); 
		query.append("        CSTMS_RQST_FLG," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES (@[jp_snd_log_id]," ).append("\n"); 
		query.append("        NVL(GLOBALDATE_PKG.TIME_LOCAL_FNC('JPTYO'), SYSDATE)," ).append("\n"); 
		query.append("        @[ofc_cd]," ).append("\n"); 
		query.append("        TO_NUMBER(SUBSTR(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL, '000009'), -3))," ).append("\n"); 
		query.append("        @[vsl_cd]," ).append("\n"); 
		query.append("        @[skd_voy_no]," ).append("\n"); 
		query.append("        @[skd_dir_cd]," ).append("\n"); 
		query.append("        @[pol_cd]," ).append("\n"); 
		query.append("        @[pol_yd_cd]," ).append("\n"); 
		query.append("        @[por_cd]," ).append("\n"); 
		query.append("        @[por_yd_cd]," ).append("\n"); 
		query.append("        @[pod_cd]," ).append("\n"); 
		query.append("        @[log_flg]," ).append("\n"); 
		query.append("        DECODE(@[snd_dt], NULL , SYSDATE, TO_DATE(@[snd_dt], 'YYYY-MM-DD HH24:MI:SS'))," ).append("\n"); 
		query.append("        @[bl_no]," ).append("\n"); 
		query.append("        'Y'," ).append("\n"); 
		query.append("        @[edi_snd_msg_ctnt]," ).append("\n"); 
		query.append("        'N'," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE)" ).append("\n"); 

	}
}