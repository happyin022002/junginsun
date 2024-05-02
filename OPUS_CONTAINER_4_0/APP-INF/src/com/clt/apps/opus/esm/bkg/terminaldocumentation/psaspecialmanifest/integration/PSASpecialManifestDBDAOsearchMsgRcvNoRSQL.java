/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOsearchMsgRcvNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.04
*@LastModifier :
*@LastVersion : 1.0
* 2011.11.04
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOsearchMsgRcvNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 수신정보 키값(Msg_Rcv_No) 조회
	  * </pre>
	  */
	public PSASpecialManifestDBDAOsearchMsgRcvNoRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n");
		query.append("FileName : PSASpecialManifestDBDAOsearchMsgRcvNoRSQL").append("\n");
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
		query.append("SELECT NVL(MAX(TO_NUMBER(MSG_RCV_NO))+1,TO_CHAR(SYSDATE,'YYYYMMDD')||'0001') MSG_RCV_NO" ).append("\n");
		query.append("FROM BKG_CSTMS_PSA_DG_RCV_ERR" ).append("\n");
		query.append("WHERE PSA_EDI_MSG_TP_ID = @[msg_tp_id]" ).append("\n");
		query.append("AND SUBSTR(MSG_RCV_NO,1,8) =TO_CHAR(SYSDATE, 'YYYYMMDD') " ).append("\n");

	}
}