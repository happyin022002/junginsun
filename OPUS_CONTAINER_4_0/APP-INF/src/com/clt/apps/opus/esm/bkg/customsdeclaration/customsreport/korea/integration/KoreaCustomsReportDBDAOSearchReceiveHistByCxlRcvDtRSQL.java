/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOSearchReceiveHistByCxlRcvDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
	  * 
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
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
		query.append("SELECT  DISTINCT MSG_LOG_TP_CD" ).append("\n"); 
		query.append("      , TO_CHAR(RCV_DT,'YYYY-MM-DD HH24:MI:SS') AS RCV_DT" ).append("\n"); 
		query.append("      , '' AS VVD" ).append("\n"); 
		query.append("      , '' AS POL_CD" ).append("\n"); 
		query.append("      , '' AS POD_CD" ).append("\n"); 
		query.append("      , '' AS OFC_CD" ).append("\n"); 
		query.append("      , '' AS BL_NO" ).append("\n"); 
		query.append("      , DECODE(@[cboMsgTp], '5VJ', EDI_SND_MSG_CTNT, '') AS SMT_AMD_NO" ).append("\n"); 
		query.append("      , DECODE(KR_CSTMS_ACPT_CD, 'C', '승인', 'E', '기각') AS MSG_STS" ).append("\n"); 
		query.append("      , KR_CSTMS_RJCT_RSN1 AS MSG_TEXT" ).append("\n"); 
		query.append("      , EDI_RCVR_NM" ).append("\n"); 
		query.append("      , TML_CD" ).append("\n"); 
		query.append("      , KR_VSL_CALL_SGN_CD" ).append("\n"); 
		query.append("      , ARR_YR" ).append("\n"); 
		query.append("      , CALL_KNT" ).append("\n"); 
		query.append("      , CSTMS_REF_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_RCV_LOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     MSG_LOG_TP_CD = @[cboMsgTp]" ).append("\n"); 
		query.append("AND     RCV_DT >= TO_DATE(@[from_dt]||'000000', 'YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("AND     RCV_DT <= TO_DATE(@[to_dt]  ||'235959', 'YYYY-MM-DDHH24MISS')" ).append("\n"); 

	}
}