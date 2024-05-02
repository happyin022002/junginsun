/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchCstmMaxAckSeqRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.04.23 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchCstmMaxAckSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 응답메시지의 SEQ+1 조회
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchCstmMaxAckSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOsearchCstmMaxAckSeqRSQL").append("\n");
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
		query.append("SELECT /*+ INDEX_DESC (BKG_CSTMS_KR_RCV_LOG XPKBKG_CSTMS_KR_RCV_LOG) */" ).append("\n");
		query.append("NVL(RCV_SEQ + 1, 1) AS MAX_RCV_SEQ" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_RCV_LOG" ).append("\n");
		query.append("WHERE FLT_FILE_REF_NO = @[flt_file_ref_no]" ).append("\n");
		query.append("AND ROWNUM = 1" ).append("\n");
		query.append("FOR UPDATE" ).append("\n");

	}
}