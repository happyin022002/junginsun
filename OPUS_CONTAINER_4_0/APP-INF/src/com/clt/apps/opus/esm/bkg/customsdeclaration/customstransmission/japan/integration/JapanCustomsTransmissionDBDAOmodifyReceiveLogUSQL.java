/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOmodifyReceiveLogUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.11.17 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOmodifyReceiveLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * modifyReceiveLog
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOmodifyReceiveLogUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration ").append("\n");
		query.append("FileName : JapanCustomsTransmissionDBDAOmodifyReceiveLogUSQL").append("\n");
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
		query.append("UPDATE BKG_CSTMS_JP_RCV_LOG SET" ).append("\n");
		query.append("VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append(",	SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n");
		query.append(",	SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n");
		query.append(",	POD_CD = @[in_pod_cd]" ).append("\n");
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n");
		query.append(",	UPD_DT = SYSDATE" ).append("\n");
		query.append("WHERE	JP_MSG_TP_ID = 'MFR'" ).append("\n");
		query.append("AND	SUBSTR(RCV_KEY_DAT_CTNT,21,12) IN 	(" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("DISTINCT BL_NO" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("BKG_CSTMS_JP_SND_LOG" ).append("\n");
		query.append("WHERE	VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append("AND	SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,4)" ).append("\n");
		query.append("AND POD_CD = @[in_pod_cd]" ).append("\n");
		query.append(")" ).append("\n");

	}
}