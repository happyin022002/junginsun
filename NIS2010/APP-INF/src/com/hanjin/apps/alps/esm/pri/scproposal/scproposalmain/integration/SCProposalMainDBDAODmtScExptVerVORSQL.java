/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCProposalMainDBDAODmtScExptVerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAODmtScExptVerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2011.04.06 김민아 [CHM-201109786-01] DEM/DET(DAR) 승인 관련 기능 개선 - 미승인 DEM/DET이 존재할 경우 해당하는 General Rate, Special Rate, Special Note의  Scope 별 bullet 정보를 조회한다.
	  * </pre>
	  */
	public SCProposalMainDBDAODmtScExptVerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAODmtScExptVerVORSQL").append("\n"); 
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
		query.append("WITH GRP AS(" ).append("\n"); 
		query.append("        SELECT  A.CNT" ).append("\n"); 
		query.append("               ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("               ,A.NOTE_TP_CD" ).append("\n"); 
		query.append("               ,A.BLET_DP_SEQ" ).append("\n"); 
		query.append("               ,ROW_NUMBER() OVER(ORDER BY B.CRE_DT, A.NOTE_TP_CD, A.SVC_SCP_CD DESC) AS RN" ).append("\n"); 
		query.append("          FROM  (" ).append("\n"); 
		query.append("                SELECT  COUNT(1) AS CNT" ).append("\n"); 
		query.append("                       ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                       ,A.GEN_SPCL_RT_TP_CD AS NOTE_TP_CD" ).append("\n"); 
		query.append("                       ,B.BLET_DP_SEQ" ).append("\n"); 
		query.append("                  FROM  PRI_SP_SCP_RT_CNOTE A" ).append("\n"); 
		query.append("                       ,PRI_SP_SCP_RT_CMDT_HDR B" ).append("\n"); 
		query.append("                 WHERE  A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND  A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND  A.NOTE_CLSS_CD = 'D'" ).append("\n"); 
		query.append("                   AND  A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                   AND  A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                   AND  A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                   AND  A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND  A.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   AND  A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                GROUP BY A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, B.BLET_DP_SEQ" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT  COUNT(1)" ).append("\n"); 
		query.append("                       ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                       ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                       ,B.BLET_DP_SEQ" ).append("\n"); 
		query.append("                  FROM  PRI_SP_SCP_RT_CMDT_RNOTE A" ).append("\n"); 
		query.append("                       ,PRI_SP_SCP_RT_CMDT_HDR B" ).append("\n"); 
		query.append("                 WHERE  A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND  A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND  A.NOTE_CLSS_CD = 'D'" ).append("\n"); 
		query.append("                   AND  A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                   AND  A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                   AND  A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                   AND  A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND  A.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   AND  A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                GROUP BY A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, B.BLET_DP_SEQ" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT  COUNT( * )" ).append("\n"); 
		query.append("                       ,SVC_SCP_CD" ).append("\n"); 
		query.append("                       ,NOTE_TP_CD" ).append("\n"); 
		query.append("                       ,NOTE_SEQ" ).append("\n"); 
		query.append("                  FROM  PRI_SP_SCP_NOTE A" ).append("\n"); 
		query.append("                 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND  AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND  NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("                   AND  NOTE_CLSS_CD = 'D'" ).append("\n"); 
		query.append("                   AND  EXISTS (SELECT  1 FROM PRI_SP_SCP_NOTE_CTNT " ).append("\n"); 
		query.append("                                 WHERE  A.PROP_NO    = PROP_NO " ).append("\n"); 
		query.append("                                   AND  A.AMDT_SEQ   = AMDT_SEQ " ).append("\n"); 
		query.append("                                   AND  A.SVC_SCP_CD = SVC_SCP_CD" ).append("\n"); 
		query.append("                                   AND  A.NOTE_TP_CD = NOTE_TP_CD " ).append("\n"); 
		query.append("                                   AND  A.NOTE_SEQ   = NOTE_SEQ" ).append("\n"); 
		query.append("                                   AND  SRC_INFO_CD  <> 'AD')" ).append("\n"); 
		query.append("                GROUP BY SVC_SCP_CD, NOTE_TP_CD, NOTE_SEQ" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("               ,PRI_SP_SCP_MN B" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  B.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND  B.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND  A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", GRP2 AS (" ).append("\n"); 
		query.append("SELECT  A.CNT" ).append("\n"); 
		query.append("       ,A.NOTE_TP_CD" ).append("\n"); 
		query.append("       ,A.BULLET_NO" ).append("\n"); 
		query.append("       ,ROW_NUMBER() OVER(ORDER BY B.CRE_DT, A.NOTE_TP_CD, A.SVC_SCP_CD DESC) AS RN" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  SUM(CNT) AS CNT" ).append("\n"); 
		query.append("               ,SVC_SCP_CD" ).append("\n"); 
		query.append("               ,NOTE_TP_CD" ).append("\n"); 
		query.append("               ,BULLET_NO" ).append("\n"); 
		query.append("          FROM  (" ).append("\n"); 
		query.append("                SELECT  CNT" ).append("\n"); 
		query.append("                       ,SVC_SCP_CD" ).append("\n"); 
		query.append("                       ,NOTE_TP_CD" ).append("\n"); 
		query.append("                       ,DECODE(NOTE_TP_CD, 'P', '', '          ' ||SVC_SCP_CD|| ' - ') || " ).append("\n"); 
		query.append("                        DECODE(NOTE_TP_CD, 'P', PRI_UTILS_PKG. JOIN_ROWS_VAR_FUNC(CURSOR(SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append("                                                                                           FROM  GRP A" ).append("\n"); 
		query.append("                                                                                          WHERE  1 = 1" ).append("\n"); 
		query.append("                                                                                            AND  A.NOTE_TP_CD = B.NOTE_TP_CD" ).append("\n"); 
		query.append("                                                                                         ORDER BY A.RN" ).append("\n"); 
		query.append("                                                                                        ),', ')" ).append("\n"); 
		query.append("                                              , PRI_UTILS_PKG. JOIN_ROWS_VAR_FUNC(CURSOR(SELECT  BLET_DP_SEQ||''" ).append("\n"); 
		query.append("                                                                                           FROM  GRP A" ).append("\n"); 
		query.append("                                                                                          WHERE  1 = 1" ).append("\n"); 
		query.append("                                                                                            AND  A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                                                            AND  A.NOTE_TP_CD = B.NOTE_TP_CD " ).append("\n"); 
		query.append("                                                                                        ),', ')) AS BULLET_NO" ).append("\n"); 
		query.append("                  FROM  GRP B" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        GROUP BY SVC_SCP_CD, NOTE_TP_CD, BULLET_NO" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("       ,PRI_SP_SCP_MN B" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  B.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND  B.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND  A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",GRP3 AS (" ).append("\n"); 
		query.append("        SELECT  SUM(CNT) AS CNT" ).append("\n"); 
		query.append("               ,DECODE(NOTE_TP_CD, 'G', 1, 'S', 2, 'P', 3) CODE" ).append("\n"); 
		query.append("               ,DECODE(NOTE_TP_CD, 'G', '1|       * General Rate|'," ).append("\n"); 
		query.append("                                   'S', '2|       * Special Rate|'," ).append("\n"); 
		query.append("                                   'P', '3|       * Scope : ') || BULLET_NO AS TEXT" ).append("\n"); 
		query.append("          FROM  (" ).append("\n"); 
		query.append("                SELECT  CNT" ).append("\n"); 
		query.append("                       ,NOTE_TP_CD" ).append("\n"); 
		query.append("                       ,DECODE(NOTE_TP_CD, 'P', BULLET_NO, PRI_UTILS_PKG. JOIN_ROWS_VAR_FUNC(CURSOR(SELECT  BULLET_NO" ).append("\n"); 
		query.append("                                                                                                      FROM  GRP2 A" ).append("\n"); 
		query.append("                                                                                                     WHERE  1 = 1" ).append("\n"); 
		query.append("                                                                                                       AND  A.NOTE_TP_CD = B.NOTE_TP_CD" ).append("\n"); 
		query.append("                                                                                                    ORDER BY RN" ).append("\n"); 
		query.append("                                                                                                   ),'|')) AS BULLET_NO" ).append("\n"); 
		query.append("                  FROM  GRP2 B" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        GROUP BY NOTE_TP_CD, BULLET_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  CASE NCNT WHEN 1" ).append("\n"); 
		query.append("                  THEN CASE ACNT WHEN 0" ).append("\n"); 
		query.append("                                 THEN 0" ).append("\n"); 
		query.append("                       ELSE 1" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("        ELSE 1" ).append("\n"); 
		query.append("        END ETC1" ).append("\n"); 
		query.append("       ,TEXT ETC2" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  MAX(DECODE(TYPE, 'N', CNT)) AS NCNT" ).append("\n"); 
		query.append("               ,MAX(DECODE(TYPE, 'A', CNT)) AS ACNT" ).append("\n"); 
		query.append("               ,MAX(TEXT) TEXT" ).append("\n"); 
		query.append("          FROM  (" ).append("\n"); 
		query.append("                SELECT  SIGN(SUM(CNT)) CNT" ).append("\n"); 
		query.append("                       ,'N' AS TYPE" ).append("\n"); 
		query.append("                       ,MAX(DECODE(CODE, 1, DECODE(SIGN(CNT), 1, TEXT))) || '/' ||" ).append("\n"); 
		query.append("                        MAX(DECODE(CODE, 2, DECODE(SIGN(CNT), 1, TEXT))) || '/' ||" ).append("\n"); 
		query.append("                        MAX(DECODE(CODE, 3, DECODE(SIGN(CNT), 1, TEXT))) AS TEXT" ).append("\n"); 
		query.append("                  FROM  GRP3" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT  SIGN(COUNT( * )) CNT, 'A' , ''" ).append("\n"); 
		query.append("                  FROM  DMT_SC_EXPT_VER" ).append("\n"); 
		query.append("                 WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND  SC_EXPT_VER_SEQ = (SELECT  /*+ INDEX_DESC(A XPKDMT_SC_EXPT_VER) */" ).append("\n"); 
		query.append("                                                   SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                                             FROM  DMT_SC_EXPT_VER A" ).append("\n"); 
		query.append("                                            WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                              AND  ROWNUM = 1)" ).append("\n"); 
		query.append("                   AND  DELT_FLG = 'N'               " ).append("\n"); 
		query.append("                   AND  DMDT_EXPT_VER_STS_CD IN ('A','L')" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}