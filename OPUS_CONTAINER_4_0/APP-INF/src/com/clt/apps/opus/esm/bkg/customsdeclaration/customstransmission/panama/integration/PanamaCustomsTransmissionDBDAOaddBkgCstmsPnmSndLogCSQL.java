/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PanamaCustomsTransmissionDBDAOaddBkgCstmsPnmSndLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.20 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PanamaCustomsTransmissionDBDAOaddBkgCstmsPnmSndLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCstmsPnmRcvErr
	  * </pre>
	  */
	public PanamaCustomsTransmissionDBDAOaddBkgCstmsPnmSndLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration").append("\n"); 
		query.append("FileName : PanamaCustomsTransmissionDBDAOaddBkgCstmsPnmSndLogCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO BKG_CSTMS_PNM_SND_LOG" ).append("\n"); 
		query.append("      (SND_DT" ).append("\n"); 
		query.append("      ,SND_LOG_SEQ" ).append("\n"); 
		query.append("      ,VST_NO" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,EDI_SND_MSG_CTNT" ).append("\n"); 
		query.append("      ,CRR_BAT_NO" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("VALUES (TO_DATE(@[snd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("      ,(SELECT NVL(MAX(SND_LOG_SEQ), 0) + 1" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PNM_SND_LOG" ).append("\n"); 
		query.append("         WHERE VST_NO     = @[vst_no]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("      ,@[vst_no]" ).append("\n"); 
		query.append("      ,@[vsl_cd]" ).append("\n"); 
		query.append("      ,@[skd_voy_no]" ).append("\n"); 
		query.append("      ,@[skd_dir_cd]" ).append("\n"); 
		query.append("      ,@[pol_cd]" ).append("\n"); 
		query.append("      ,@[pod_cd]" ).append("\n"); 
		query.append("      ,@[edi_snd_msg_ctnt]" ).append("\n"); 
		query.append("      ,@[crr_bat_no]" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}