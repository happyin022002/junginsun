/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAOaddAckCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.23
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOaddAckCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 수신데이타 저장 (수신 마스터 테이블)
	  * </pre>
	  */
	public SpecialManifestDBDAOaddAckCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_msg_cntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_msg_bl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_accept_ref",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_msg_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_ack_rslt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_approve_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_fax",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_ack_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sec_file_nbr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_phone",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_udt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_msg_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_log_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration ").append("\n");
		query.append("FileName : SpecialManifestDBDAOaddAckCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_EUR_DG_RCV (" ).append("\n");
		query.append("EUR_EDI_MSG_TP_ID" ).append("\n");
		query.append(",MSG_RCV_NO" ).append("\n");
		query.append(",RCV_LOG_SEQ" ).append("\n");
		query.append(",ORG_MSG_TP_ID  -- org_msg_tp" ).append("\n");
		query.append(",MSG_FUNC_ID    -- MSG_UDT-FLG" ).append("\n");
		query.append(",ACK_KND_ID     -- MSG_ACK_TP" ).append("\n");
		query.append(",ACK_RCV_STS_CD -- MSG_ACK_RSLT" ).append("\n");
		query.append(",ACK_DT" ).append("\n");
		query.append(",APRO_DT" ).append("\n");
		query.append(",CSTMS_PHN_NO" ).append("\n");
		query.append(",CSTMS_FAX_NO" ).append("\n");
		query.append(",CNTR_NO" ).append("\n");
		query.append(",BL_NO" ).append("\n");
		query.append(",SCR_FILE_NO" ).append("\n");
		query.append(",MSG_ACPT_REF_NO" ).append("\n");
		query.append(",EDI_SND_MSG_NM" ).append("\n");
		query.append(",CRE_USR_ID" ).append("\n");
		query.append(",CRE_DT" ).append("\n");
		query.append(",UPD_USR_ID" ).append("\n");
		query.append(",UPD_DT" ).append("\n");
		query.append(") VALUES (" ).append("\n");
		query.append("@[msg_tp_id]" ).append("\n");
		query.append(",@[key_val]" ).append("\n");
		query.append(",@[rcv_log_seq]" ).append("\n");
		query.append(",@[org_msg_tp]" ).append("\n");
		query.append(",@[msg_udt_flg]" ).append("\n");
		query.append(",@[msg_ack_tp]" ).append("\n");
		query.append(",DECODE(@[msg_ack_rslt], 'CA', 'C', @[msg_ack_rslt])" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append(",TO_DATE(@[msg_approve_dt], 'YYYYMMDDHH24MI')" ).append("\n");
		query.append(",@[msg_phone]" ).append("\n");
		query.append(",@[msg_fax]" ).append("\n");
		query.append(",@[org_msg_cntr]" ).append("\n");
		query.append(",@[org_msg_bl]" ).append("\n");
		query.append(",@[sec_file_nbr]" ).append("\n");
		query.append(",@[msg_accept_ref]" ).append("\n");
		query.append(",@[org_msg_nm]" ).append("\n");
		query.append(",@[cre_usr_id]" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append(",@[upd_usr_id]" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append(")" ).append("\n");

	}
}