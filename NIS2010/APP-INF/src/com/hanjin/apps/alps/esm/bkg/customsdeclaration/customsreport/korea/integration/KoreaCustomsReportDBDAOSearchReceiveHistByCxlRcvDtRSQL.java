/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : KoreaCustomsReportDBDAOSearchReceiveHistByCxlRcvDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOSearchReceiveHistByCxlRcvDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.11.14 변종건[CHM-201114372-01] 한국지역 적하목록 사전 제출 관련 SYS보완 요청 - Receive History 화면에서 수신된 MSG(5VJ) 추가 작업
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOSearchReceiveHistByCxlRcvDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cboMsgTp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOSearchReceiveHistByCxlRcvDtRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT L.MSG_LOG_TP_CD" ).append("\n"); 
		query.append("      , TO_CHAR(D.RCV_DT,'YYYY-MM-DD HH24:MI:SS') AS RCV_DT" ).append("\n"); 
		query.append("      , '' VVD" ).append("\n"); 
		query.append("      , '' POL_CD" ).append("\n"); 
		query.append("      , '' POD_CD" ).append("\n"); 
		query.append("      , '' OFC_CD" ).append("\n"); 
		query.append("      , '' BL_NO" ).append("\n"); 
		query.append("      , DECODE(@[cboMsgTp],'5VJ',D.EDI_RCV_MSG,'') AS SMT_AMD_NO" ).append("\n"); 
		query.append("      , DECODE(L.KR_CSTMS_ACPT_CD,'C','승인','E','기각') AS MSG_STS" ).append("\n"); 
		query.append("      , D.KR_CSTMS_RJCT_RSN1 AS MSG_TEXT" ).append("\n"); 
		query.append("      , L.EDI_RCVR_NM" ).append("\n"); 
		query.append("      , L.TML_CD" ).append("\n"); 
		query.append("      , L.KR_VSL_CALL_SGN_CD" ).append("\n"); 
		query.append("      , L.ARR_YR" ).append("\n"); 
		query.append("      , L.CALL_KNT" ).append("\n"); 
		query.append("      , L.CSTMS_REF_NM" ).append("\n"); 
		query.append("	  , L.RCV_SEQ RCV_SEQ" ).append("\n"); 
		query.append("	  , L.FLT_FILE_REF_NO" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_RCV_LOG L" ).append("\n"); 
		query.append("      , BKG_CSTMS_KR_RCV_LOG_DTL D" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     D.MSG_LOG_TP_CD = L.MSG_LOG_TP_CD" ).append("\n"); 
		query.append("AND     D.RCV_DT = L.RCV_DT" ).append("\n"); 
		query.append("AND     D.RCV_SEQ = L.RCV_SEQ" ).append("\n"); 
		query.append("AND     D.FLT_FILE_REF_NO = L.FLT_FILE_REF_NO" ).append("\n"); 
		query.append("AND     L.MSG_LOG_TP_CD = @[cboMsgTp]" ).append("\n"); 
		query.append("AND     L.RCV_DT >= TO_DATE(@[from_dt]||'000000', 'YYYY-MM-DDHH24MISS') " ).append("\n"); 
		query.append("AND     L.RCV_DT <= TO_DATE(@[to_dt]  ||'235959', 'YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("ORDER BY RCV_DT DESC" ).append("\n"); 

	}
}