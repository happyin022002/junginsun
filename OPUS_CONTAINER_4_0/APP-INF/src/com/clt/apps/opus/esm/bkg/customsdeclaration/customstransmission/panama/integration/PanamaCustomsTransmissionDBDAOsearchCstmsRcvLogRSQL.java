/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PanamaCustomsTransmissionDBDAOsearchCstmsRcvLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.22 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PanamaCustomsTransmissionDBDAOsearchCstmsRcvLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCstmsRcvLog
	  * </pre>
	  */
	public PanamaCustomsTransmissionDBDAOsearchCstmsRcvLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration").append("\n"); 
		query.append("FileName : PanamaCustomsTransmissionDBDAOsearchCstmsRcvLogRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT 'Receive' AS TYPE" ).append("\n"); 
		query.append("      ,A.EDI_RCV_MSG_CTNT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.RCV_DT, 'YYYY-MM-DD HH24:MI') AS RCV_DT" ).append("\n"); 
		query.append("      ,A.VST_NO" ).append("\n"); 
		query.append("      ,A.RCV_LOG_SEQ" ).append("\n"); 
		query.append("      ,A.CSTMS_ACK_CD" ).append("\n"); 
		query.append("      ,B.CSTMS_ERR_ID" ).append("\n"); 
		query.append("      ,B.CSTMS_ERR_MSG" ).append("\n"); 
		query.append("      ,C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_PNM_RCV_LOG A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_PNM_RCV_ERR B" ).append("\n"); 
		query.append("      ,BKG_CSTMS_PNM_SND_LOG C" ).append("\n"); 
		query.append(" WHERE A.RCV_DT      = B.RCV_DT(+)" ).append("\n"); 
		query.append("   AND A.RCV_LOG_SEQ = B.RCV_LOG_SEQ(+)" ).append("\n"); 
		query.append("   AND A.VST_NO      = B.VST_NO(+)" ).append("\n"); 
		query.append("   AND B.RCV_LOG_ERR_SEQ(+) = 1" ).append("\n"); 
		query.append("   AND A.CRR_BAT_NO  = C.CRR_BAT_NO" ).append("\n"); 
		query.append("   AND C.VST_NO      = @[vst_no]" ).append("\n"); 
		query.append("   AND C.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND C.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND C.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#if (${rcv_log_seq} != '')" ).append("\n"); 
		query.append("   AND A.RCV_LOG_SEQ = @[rcv_log_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'Transmit' AS TYPE" ).append("\n"); 
		query.append("      ,C.EDI_SND_MSG_CTNT" ).append("\n"); 
		query.append("      ,TO_CHAR(C.SND_DT, 'YYYY-MM-DD HH24:MI') AS RCV_DT" ).append("\n"); 
		query.append("      ,C.VST_NO" ).append("\n"); 
		query.append("      ,C.SND_LOG_SEQ" ).append("\n"); 
		query.append("      ,''" ).append("\n"); 
		query.append("      ,''" ).append("\n"); 
		query.append("      ,''" ).append("\n"); 
		query.append("      ,C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_PNM_SND_LOG C" ).append("\n"); 
		query.append(" WHERE C.VST_NO      = @[vst_no]" ).append("\n"); 
		query.append("   AND C.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND C.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND C.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#if (${rcv_log_seq} != '')" ).append("\n"); 
		query.append("   AND C.SND_LOG_SEQ = @[rcv_log_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${type} != '')" ).append("\n"); 
		query.append(" WHERE TYPE = @[type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RCV_DT" ).append("\n"); 

	}
}