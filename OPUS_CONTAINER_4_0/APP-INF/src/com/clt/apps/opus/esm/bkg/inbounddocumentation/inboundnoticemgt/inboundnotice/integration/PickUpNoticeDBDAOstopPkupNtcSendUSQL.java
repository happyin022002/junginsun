/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOstopPkupNtcSendUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOstopPkupNtcSendUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 발송 예정인 Pick-up Notice Email/Fax 자동 전송을 중지한다.
	  * </pre>
	  */
	public PickUpNoticeDBDAOstopPkupNtcSendUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_snd_stop_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOstopPkupNtcSendUSQL").append("\n"); 
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
		query.append("UPDATE BKG_PKUP_NTC SET " ).append("\n"); 
		query.append("	AUTO_SND_STOP_FLG    = 'Y'" ).append("\n"); 
		query.append(",	AUTO_SND_STOP_DT     = SYSDATE" ).append("\n"); 
		query.append(",	AUTO_SND_STOP_USR_ID = @[auto_snd_stop_usr_id]" ).append("\n"); 
		query.append(",	AUTO_SND_RESM_FLG    = 'N'" ).append("\n"); 
		query.append(",	AUTO_SND_RESM_DT     = NULL" ).append("\n"); 
		query.append(",	AUTO_SND_RESM_USR_ID = NULL" ).append("\n"); 
		query.append(",	UPD_USR_ID           = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT               = SYSDATE" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND  PKUP_NTC_SND_STS_CD = 'N'" ).append("\n"); 
		query.append("AND  AUTO_SND_STOP_FLG <> 'Y'" ).append("\n"); 

	}
}