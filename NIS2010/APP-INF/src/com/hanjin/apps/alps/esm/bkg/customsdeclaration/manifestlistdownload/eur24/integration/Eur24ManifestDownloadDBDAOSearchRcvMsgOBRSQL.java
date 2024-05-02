/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchRcvMsgOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.19
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.06.19 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchRcvMsgOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Ack Msg. 정보 팝업용
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchRcvMsgOBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchRcvMsgOBRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  'Status' AS COLUMN1" ).append("\n"); 
		query.append(" ,TO_CLOB(DECODE(C.EUR_CSTMS_ACK_CD, '561', 'Hold',DECODE(C.ACK_RCV_STS_CD, 'A', 'Accepted', 'R', 'Rejected', 'D', 'Hold(Doc.)', 'P', 'Hold(Phys.)', 'L', 'Hold Release', 'Do not load'))) REMARK1" ).append("\n"); 
		query.append(" , 1 AS ERR_IMG" ).append("\n"); 
		query.append(" , NULL AS ERR_ID" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_EUR_IO_RCV C" ).append("\n"); 
		query.append("WHERE EDI_RCV_DT  = TO_CHAR(TO_DATE(@[edi_rcv_dt], 'YYYYMMDDHH24MISS'), 'YYYYMMDD')" ).append("\n"); 
		query.append("  AND EDI_RCV_SEQ = @[edi_rcv_seq]" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("UNION ALL  " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  'Reject of Error Code1'" ).append("\n"); 
		query.append(" ,TO_CLOB(EUR_CSTMS_RJCT_CD||':'||RJCT_RSN_RMK)" ).append("\n"); 
		query.append(" ,DECODE(EUR_CSTMS_RJCT_CD,NULL,1,0)" ).append("\n"); 
		query.append(" , EUR_CSTMS_RJCT_CD" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_EUR_IO_RCV C" ).append("\n"); 
		query.append("WHERE EDI_RCV_DT  = TO_CHAR(TO_DATE(@[edi_rcv_dt], 'YYYYMMDDHH24MISS'), 'YYYYMMDD')" ).append("\n"); 
		query.append("  AND EDI_RCV_SEQ = @[edi_rcv_seq]" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("UNION ALL   " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  'Reject of Error Code'||(ROWNUM +1)" ).append("\n"); 
		query.append(" , TO_CLOB(DECODE(CSTMS_ERR_ID,NULL,CSTMS_ERR_MSG, CSTMS_ERR_ID||':'||CSTMS_ERR_MSG ) || DECODE(CSTMS_ERR_REF_NO1,NULL,'',CHR(10)||'REF_1:'||CSTMS_ERR_REF_NO1 ) || DECODE(CSTMS_ERR_REF_NO2,NULL,'',CHR(10)||'REF_2:'||CSTMS_ERR_REF_NO2 )) ,DECODE(CSTMS_ERR_ID,NULL,1,0)" ).append("\n"); 
		query.append(" ,CSTMS_ERR_ID" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_IO_RCV_ERR" ).append("\n"); 
		query.append("WHERE EDI_RCV_DT  = TO_CHAR(TO_DATE(@[edi_rcv_dt], 'YYYYMMDDHH24MISS'), 'YYYYMMDD')" ).append("\n"); 
		query.append("  AND EDI_RCV_SEQ = @[edi_rcv_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL  " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" 'Message Full Text'" ).append("\n"); 
		query.append(" ,C.EDI_RCV_MSG_CTNT" ).append("\n"); 
		query.append(" ,1" ).append("\n"); 
		query.append(" ,NULL" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_EUR_IO_RCV C" ).append("\n"); 
		query.append("WHERE EDI_RCV_DT  = TO_CHAR(TO_DATE(@[edi_rcv_dt], 'YYYYMMDDHH24MISS'), 'YYYYMMDD')" ).append("\n"); 
		query.append("  AND EDI_RCV_SEQ = @[edi_rcv_seq]" ).append("\n"); 

	}
}