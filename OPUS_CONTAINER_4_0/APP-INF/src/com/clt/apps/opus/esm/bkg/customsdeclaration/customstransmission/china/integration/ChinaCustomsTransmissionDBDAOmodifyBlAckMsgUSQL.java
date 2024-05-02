/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOmodifyBlAckMsgUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier :
*@LastVersion : 1.0
* 2010.05.25
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOmodifyBlAckMsgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * modifyBlAckMsg
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOmodifyBlAckMsgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_ack_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ack_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n");
		query.append("FileName : ChinaCustomsTransmissionDBDAOmodifyBlAckMsgUSQL").append("\n");
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
		query.append("UPDATE  BKG_CSTMS_CHN_SND_LOG_BL" ).append("\n");
		query.append("SET     CHN_CSTMS_ACK_TP_CD = TRIM(@[chn_cstms_ack_tp_cd])," ).append("\n");
		query.append("        ACK_CTNT       = TRIM(@[ack_ctnt])," ).append("\n");
		query.append("	    ACK_UPD_DT     = SYSDATE" ).append("\n");
		query.append("WHERE   EDI_REF_ID     = TRIM(@[edi_ref_id])" ).append("\n");
		query.append("AND		BL_NO 		   = SUBSTR(TRIM(@[bl_no]),5)" ).append("\n");

	}
}