/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOmodifySendLogUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOmodifySendLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifySendLog
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOmodifySendLogUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("log_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("log_dt",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOmodifySendLogUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_JP_SND_LOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   SET LOG_FLG = 'N'," ).append("\n"); 
		query.append("       LOG_DT = DECODE(@[log_dt], NULL , SYSDATE, TO_DATE(@[log_dt], 'YYYY-MM-DD HH24:MI:SS'))," ).append("\n"); 
		query.append("       UPD_USR_ID = UPPER(@[upd_usr_id])," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE JP_SND_LOG_ID = @[jp_snd_log_id]" ).append("\n"); 
		query.append("   AND SND_DT = DECODE(@[snd_dt], NULL , SYSDATE, TO_DATE(@[snd_dt], 'YYYYMMDDHH24MISS'))" ).append("\n"); 
		query.append("   AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND LOG_SEQ = @[log_seq]" ).append("\n"); 

	}
}