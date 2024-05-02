/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchAckMsgRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.06.10 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sang-Soo KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchAckMsgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 테이블 BKG_CSTMS_CHN_SND_LOG의 ACK_RCV_DT_MSG를 조회한다.
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchAckMsgRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n");
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchAckMsgRSQL").append("\n");
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
		query.append("SELECT NVL(ACK_RCV_DT_MSG,'19000101000000') AS ACK_RCV_DT_MSG," ).append("\n");
		query.append("       NVL(AGN_ACK_RCV_DT_MSG,'19000101000000') AS AGN_ACK_RCV_DT_MSG" ).append("\n");
		query.append("" ).append("\n");
		query.append("  FROM BKG_CSTMS_CHN_SND_LOG" ).append("\n");
		query.append("" ).append("\n");
		query.append(" WHERE EDI_REF_ID = TRIM(@[edi_ref_id])" ).append("\n");

	}
}