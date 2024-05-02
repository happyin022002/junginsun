/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SmsDAOSndCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.common.sms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SmsDAOSndCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * send한다
	  * </pre>
	  */
	public SmsDAOSndCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("used_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reserved_fg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("telco_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmp_snd_dttm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_phn_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("assign_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("content_path",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reg_snd_dttm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmp_rcv_dttm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("saved_fg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("machine_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_phn_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("content_mime_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nat_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("content_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_title",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reg_rcv_dttm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reserved_dttm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sms_gb",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmp_msg_group_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("callback_url",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmp_msg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.common.sms.integration").append("\n"); 
		query.append("FileName : SmsDAOSndCSQL").append("\n"); 
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
		query.append("INSERT INTO TBL_SUBMIT_QUEUE (" ).append("\n"); 
		query.append("	CMP_MSG_ID" ).append("\n"); 
		query.append(",	CMP_MSG_GROUP_ID" ).append("\n"); 
		query.append(",	USR_ID" ).append("\n"); 
		query.append(",	SMS_GB" ).append("\n"); 
		query.append(",	USED_CD" ).append("\n"); 
		query.append(",	RESERVED_FG" ).append("\n"); 
		query.append(",	RESERVED_DTTM" ).append("\n"); 
		query.append(",	SAVED_FG" ).append("\n"); 
		query.append(",	RCV_PHN_ID" ).append("\n"); 
		query.append(",	SND_PHN_ID" ).append("\n"); 
		query.append(",	NAT_CD" ).append("\n"); 
		query.append(",	ASSIGN_CD" ).append("\n"); 
		query.append(",	SND_MSG" ).append("\n"); 
		query.append(",	CALLBACK_URL" ).append("\n"); 
		query.append(",	CONTENT_CNT" ).append("\n"); 
		query.append(",	CONTENT_MIME_TYPE" ).append("\n"); 
		query.append(",	CONTENT_PATH" ).append("\n"); 
		query.append(",	CMP_SND_DTTM" ).append("\n"); 
		query.append(",	CMP_RCV_DTTM" ).append("\n"); 
		query.append(",	REG_SND_DTTM" ).append("\n"); 
		query.append(",	REG_RCV_DTTM" ).append("\n"); 
		query.append(",	MACHINE_ID" ).append("\n"); 
		query.append(",	RSLT_VAL" ).append("\n"); 
		query.append(",	MSG_TITLE" ).append("\n"); 
		query.append(",	TELCO_ID" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[cmp_msg_id]" ).append("\n"); 
		query.append(",	@[cmp_msg_group_id]" ).append("\n"); 
		query.append(",	@[usr_id]" ).append("\n"); 
		query.append(",	@[sms_gb]" ).append("\n"); 
		query.append(",	@[used_cd]" ).append("\n"); 
		query.append(",	@[reserved_fg]" ).append("\n"); 
		query.append(",	@[reserved_dttm]" ).append("\n"); 
		query.append(",	@[saved_fg]" ).append("\n"); 
		query.append(",	@[rcv_phn_id]" ).append("\n"); 
		query.append(",	@[snd_phn_id]" ).append("\n"); 
		query.append(",	@[nat_cd]" ).append("\n"); 
		query.append(",	@[assign_cd]" ).append("\n"); 
		query.append(",	@[snd_msg]" ).append("\n"); 
		query.append(",	@[callback_url]" ).append("\n"); 
		query.append(",	@[content_cnt] " ).append("\n"); 
		query.append(",	@[content_mime_type]" ).append("\n"); 
		query.append(",	@[content_path]" ).append("\n"); 
		query.append(",	@[cmp_snd_dttm]" ).append("\n"); 
		query.append(",	@[cmp_rcv_dttm]" ).append("\n"); 
		query.append(",	@[reg_snd_dttm]" ).append("\n"); 
		query.append(",	@[reg_rcv_dttm]" ).append("\n"); 
		query.append(",	@[machine_id]" ).append("\n"); 
		query.append(",	@[rslt_val]" ).append("\n"); 
		query.append(",	@[msg_title]" ).append("\n"); 
		query.append(",	@[telco_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}