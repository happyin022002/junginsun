/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanCustomsReportDBDAOsearchJpcusSendLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsReportDBDAOsearchJpcusSendLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchJpcusSendLog
	  * </pre>
	  */
	public JapanCustomsReportDBDAOsearchJpcusSendLogRSQL(){
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
		params.put("log_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("msg_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsReportDBDAOsearchJpcusSendLogRSQL").append("\n"); 
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
		query.append("#if (${jp_snd_log_id} == 'DOR' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT EDI_SND_MSG_CTNT AS EDI_SND_MSG" ).append("\n"); 
		query.append("  FROM BKG_IB_EDI_SND_LOG DOR," ).append("\n"); 
		query.append("       BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE FLT_FILE_REF_NO = 'DOR'" ).append("\n"); 
		query.append("   AND EDI_EVNT_DT = TO_DATE(@[msg_snd_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("   AND EDI_EVNT_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND DOR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND EDI_SND_SEQ = @[log_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT EDI_SND_MSG_CTNT AS EDI_SND_MSG" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_JP_SND_LOG" ).append("\n"); 
		query.append(" WHERE JP_SND_LOG_ID = @[jp_snd_log_id]" ).append("\n"); 
		query.append("   AND SND_DT = TO_DATE(@[msg_snd_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("   AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND LOG_SEQ = @[log_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}