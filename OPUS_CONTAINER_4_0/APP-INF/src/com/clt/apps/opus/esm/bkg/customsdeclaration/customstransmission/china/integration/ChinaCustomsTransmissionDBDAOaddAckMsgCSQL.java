/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOaddAckMsgCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.06
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.07.06 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOaddAckMsgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BKG_CSTMS_CHN_ACK_MSG테이블에 데이터를  삽입한다.
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOaddAckMsgCSQL(){
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
		params.put("ack_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ack_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n");
		query.append("FileName : ChinaCustomsTransmissionDBDAOaddAckMsgCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_CHN_ACK_MSG" ).append("\n");
		query.append("(EDI_RCV_DT" ).append("\n");
		query.append(",EDI_RCV_DTL_SEQ" ).append("\n");
		query.append(",EDI_REF_ID" ).append("\n");
		query.append(",CHN_CSTMS_ACK_TP_CD" ).append("\n");
		query.append(",ACK_CTNT" ).append("\n");
		query.append(",ACK_RCV_DT" ).append("\n");
		query.append(",ACK_RCV_DT_MSG" ).append("\n");
		query.append(",ACK_UPD_DT" ).append("\n");
		query.append(")VALUES(" ).append("\n");
		query.append("TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n");
		query.append(",BKG_CSTMS_CHN_ACK_MSG_SEQ.NEXTVAL" ).append("\n");
		query.append(",TRIM(@[edi_ref_id])" ).append("\n");
		query.append(",TRIM(@[chn_cstms_ack_tp_cd])" ).append("\n");
		query.append(",TRIM(@[ack_ctnt])" ).append("\n");
		query.append(",TO_DATE(SUBSTR(@[ack_rcv_dt],1,14),'YYYYMMDDHH24MISS')" ).append("\n");
		query.append(",@[ack_rcv_dt]" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append(")" ).append("\n");

	}
}