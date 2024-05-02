/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOaddSendLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.20 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelCustomsTransmissionDBDAOaddSendLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addSendLog
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOaddSendLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOaddSendLogCSQL").append("\n"); 
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
		query.append("INSERT INTO  BKG_CSTMS_EUR_IB_SND" ).append("\n"); 
		query.append("(  CNT_CD,          MSG_SND_NO ," ).append("\n"); 
		query.append("   EDI_MSG_TP_ID,   " ).append("\n"); 
		query.append("   SND_DT,        " ).append("\n"); 
		query.append("   SND_GDT,       " ).append("\n"); 
		query.append("   SND_USR_ID,    SND_USR_OFC_CD,   " ).append("\n"); 
		query.append("   VSL_CD,        SKD_VOY_NO,       SKD_DIR_CD,    BL_NO,   CSTMS_PORT_CD,    EDI_SND_MSG_CTNT," ).append("\n"); 
		query.append("   CRE_USR_ID,    CRE_DT,           UPD_USR_ID,    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(  'IL',            @[msg_snd_no]," ).append("\n"); 
		query.append("   @[edi_msg_tp_id],   " ).append("\n"); 
		query.append("   GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[snd_usr_ofc_cd]),       " ).append("\n"); 
		query.append("   GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[snd_usr_ofc_cd], GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[snd_usr_ofc_cd]), 'GMT'),    " ).append("\n"); 
		query.append("   @[snd_usr_id],   @[snd_usr_ofc_cd],  " ).append("\n"); 
		query.append("   @[vsl_cd],       @[skd_voy_no],  @[skd_dir_cd],  @[bl_no],   @[cstms_port_cd],   @[edi_snd_msg_ctnt]," ).append("\n"); 
		query.append("   @[cre_usr_id],   SYSDATE,        @[cre_usr_id],  SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}