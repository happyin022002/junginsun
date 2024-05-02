/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdoRqstStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchEdoRqstStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KT-NET을 통해 들어온 E-DO 승인 요청 정보에 대한 Ststus를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdoRqstStsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdoRqstStsRSQL").append("\n"); 
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
		query.append("SELECT IMST.EDO_RQST_NO           AS EDO_RQST_NO           -- Request 번호" ).append("\n"); 
		query.append("     , MAX(IMST.EDO_RQST_SEQ_5JN) AS EDO_RQST_SEQ_5JN -- D/O 발급 요청 SEQ 번호" ).append("\n"); 
		query.append("     , MAX(IMST.EDO_RQST_SEQ_5JM) AS EDO_RQST_SEQ_5JM -- 자가운송신청서 SEQ 번호" ).append("\n"); 
		query.append("     , MAX(IMST.EDO_RQST_SEQ_5JK) AS EDO_RQST_SEQ_5JK -- 보세운송요청동의서 SEQ 번호   " ).append("\n"); 
		query.append("     , MAX(M5JN.EDO_TP_CD)        AS DO_ISSUE              -- D/O 발급 요청" ).append("\n"); 
		query.append("     , MAX(M5JN.EDO_ACK_CD)       AS DO_EDO_ACK_CD         -- D/O 발급 요청 ACK" ).append("\n"); 
		query.append("     , MAX(M5JM.EDO_TP_CD)        AS SELF_TRANSPORTATION   -- 자가운송신청서" ).append("\n"); 
		query.append("     , MAX(M5JM.EDO_ACK_CD)       AS SELF_EDO_ACK_CD       -- 자가운송신청서 ACK" ).append("\n"); 
		query.append("     , MAX(M5JK.EDO_TP_CD)        AS BONDED_TRANSPORTATION -- 보세운송요청동의서" ).append("\n"); 
		query.append("     , MAX(M5JK.EDO_ACK_CD)       AS BONDED_EDO_ACK_CD     -- 보세운송요청동의서 ACK" ).append("\n"); 
		query.append("     , MAX(EPTY.PTY_RGST_NO)      AS MS_PTY_RGST_NO        -- D/O 신청자 " ).append("\n"); 
		query.append("     , MAX(RPTY.PTY_RGST_NO)      AS PR_PTY_RGST_NO        -- 세금계산서 공급 받는자    " ).append("\n"); 
		query.append("     , (SELECT DECODE(COUNT(*),0,'N','Y') " ).append("\n"); 
		query.append("        FROM BKG_EDO_LOG" ).append("\n"); 
		query.append("        WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("        AND   EDO_RSLT_CD = 'E'" ).append("\n"); 
		query.append("        AND   ROWNUM=1 )          AS ERR_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM ( SELECT /*+ USE_NL(IMST_MAX IMST) */" ).append("\n"); 
		query.append("                SUBSTR(MAX(TO_CHAR(IMST.EDO_RCT_DT,'YYYYMMDDHH24MISS')||IMST.EDO_RQST_NO),15) AS EDO_RQST_NO" ).append("\n"); 
		query.append("              , IMST.EDO_TP_CD" ).append("\n"); 
		query.append("              , SUBSTR(MAX( NVL(TO_CHAR(IMST.EDO_RCT_DT,'YYYYMMDDHH24MISS'), '00000000000000') ||CASE WHEN IMST.EDO_TP_CD = '5JN' THEN IMST.EDO_RQST_SEQ END),15) AS EDO_RQST_SEQ_5JN" ).append("\n"); 
		query.append("              , SUBSTR(MAX( NVL(TO_CHAR(IMST.EDO_RCT_DT,'YYYYMMDDHH24MISS'), '00000000000000') ||CASE WHEN IMST.EDO_TP_CD = '5JM' THEN IMST.EDO_RQST_SEQ END),15) AS EDO_RQST_SEQ_5JM" ).append("\n"); 
		query.append("              , SUBSTR(MAX( NVL(TO_CHAR(IMST.EDO_RCT_DT,'YYYYMMDDHH24MISS'), '00000000000000') ||CASE WHEN IMST.EDO_TP_CD = '5JK' THEN IMST.EDO_RQST_SEQ END),15) AS EDO_RQST_SEQ_5JK" ).append("\n"); 
		query.append("           FROM BKG_EDO_MST IMST" ).append("\n"); 
		query.append("          WHERE IMST.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("            AND NVL(IMST.DELT_FLG, ' ') <> 'Y'" ).append("\n"); 
		query.append("          GROUP BY IMST.EDO_TP_CD" ).append("\n"); 
		query.append("       )IMST" ).append("\n"); 
		query.append("     , BKG_EDO_MST M5JN -- DO 신청" ).append("\n"); 
		query.append("     , BKG_EDO_MST M5JM -- 자가운송" ).append("\n"); 
		query.append("     , BKG_EDO_MST M5JK -- 보세운송" ).append("\n"); 
		query.append("     , BKG_EDO_PTY_TRSP EPTY  -- 신청자 " ).append("\n"); 
		query.append("     , BKG_EDO_PTY_TRSP RPTY  -- 세금계산서 공급 받는자" ).append("\n"); 
		query.append(" WHERE IMST.EDO_RQST_NO      = M5JN.EDO_RQST_NO(+)" ).append("\n"); 
		query.append("   AND IMST.EDO_RQST_SEQ_5JN = M5JN.EDO_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND IMST.EDO_RQST_NO      = M5JM.EDO_RQST_NO(+)" ).append("\n"); 
		query.append("   AND IMST.EDO_RQST_SEQ_5JM = M5JM.EDO_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND IMST.EDO_RQST_NO      = M5JK.EDO_RQST_NO(+)" ).append("\n"); 
		query.append("   AND IMST.EDO_RQST_SEQ_5JK = M5JK.EDO_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND EPTY.EDO_RQST_NO(+)   = IMST.EDO_RQST_NO      " ).append("\n"); 
		query.append("   AND EPTY.EDO_PTY_CD(+)    = 'MS'" ).append("\n"); 
		query.append("   AND EPTY.EDO_RQST_SEQ(+)  = IMST.EDO_RQST_SEQ_5JN    " ).append("\n"); 
		query.append("   AND RPTY.EDO_RQST_NO(+)   = IMST.EDO_RQST_NO      " ).append("\n"); 
		query.append("   AND RPTY.EDO_PTY_CD(+)    = 'PR'" ).append("\n"); 
		query.append("   AND RPTY.EDO_RQST_SEQ(+)  = IMST.EDO_RQST_SEQ_5JN    " ).append("\n"); 
		query.append(" GROUP BY IMST.EDO_RQST_NO" ).append("\n"); 

	}
}