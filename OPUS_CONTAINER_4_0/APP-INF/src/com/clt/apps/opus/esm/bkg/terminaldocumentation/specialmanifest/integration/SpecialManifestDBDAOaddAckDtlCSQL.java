/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAOaddAckDtlCSQL.java
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

public class SpecialManifestDBDAOaddAckDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 수신데이타 저장 (수신 Detail)
	  * </pre>
	  */
	public SpecialManifestDBDAOaddAckDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cstms_err_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_err_ref_no2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_err_ref_no1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration ").append("\n");
		query.append("FileName : SpecialManifestDBDAOaddAckDtlCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_EUR_DG_RCV_ERR (" ).append("\n");
		query.append("EUR_EDI_MSG_TP_ID" ).append("\n");
		query.append(",MSG_RCV_NO" ).append("\n");
		query.append(",RCV_LOG_SEQ" ).append("\n");
		query.append(",RCV_LOG_ERR_SEQ" ).append("\n");
		query.append(",CSTMS_ERR_ID" ).append("\n");
		query.append(",CSTMS_ERR_MSG" ).append("\n");
		query.append(",CSTMS_ERR_REF_NO1" ).append("\n");
		query.append(",CSTMS_ERR_REF_NO2" ).append("\n");
		query.append(",CRE_USR_ID" ).append("\n");
		query.append(",CRE_DT" ).append("\n");
		query.append(",UPD_USR_ID" ).append("\n");
		query.append(",UPD_DT" ).append("\n");
		query.append(") VALUES (" ).append("\n");
		query.append("@[msg_tp_id]" ).append("\n");
		query.append(",@[key_val]" ).append("\n");
		query.append(",@[rcv_log_seq]" ).append("\n");
		query.append("" ).append("\n");
		query.append(",(" ).append("\n");
		query.append("SELECT NVL(MAX(RCV_LOG_ERR_SEQ), 0) + 1" ).append("\n");
		query.append("FROM BKG_CSTMS_EUR_DG_RCV_ERR" ).append("\n");
		query.append("WHERE EUR_EDI_MSG_TP_ID = @[msg_tp_id]" ).append("\n");
		query.append("AND   MSG_RCV_NO        = @[key_val]" ).append("\n");
		query.append("AND   RCV_LOG_SEQ       = @[rcv_log_seq]" ).append("\n");
		query.append(")" ).append("\n");
		query.append(",@[cstms_err_id]" ).append("\n");
		query.append(",@[cstms_err_msg]" ).append("\n");
		query.append(",@[cstms_err_ref_no1]" ).append("\n");
		query.append(",@[cstms_err_ref_no2]" ).append("\n");
		query.append(",@[cre_usr_id]" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append(",@[upd_usr_id]" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append("" ).append("\n");
		query.append(")" ).append("\n");

	}
}