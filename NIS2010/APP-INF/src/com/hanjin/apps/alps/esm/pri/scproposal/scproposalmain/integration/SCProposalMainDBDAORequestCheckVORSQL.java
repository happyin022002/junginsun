/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCProposalMainDBDAORequestCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.22
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.22 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORequestCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request 시 check할 Terms를 조회한다.
	  * 2013.10.21 전윤주 [CHM-201327107] CHSS Note 체크 부분 추가
	  * 2014.04.03 전윤주 [CHM-201429648] CHSS Conversion data의 status에 관계 없이 존재하면 Note가 존재하여야함
	  * 2014.12.09 송호진 [CHM-201432563] Copy 된 Standard Note 의 Customer Type 과 S/C 내의 Customer Type 비교 체크 부분 추가
	  * 2015.04.13 송호진 [CHM-201535019] Customer Type = A 에 Actual Customer 란 활성화관련 Valid Affiliate 체크 부분 추가
	  * </pre>
	  */
	public SCProposalMainDBDAORequestCheckVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORequestCheckVORSQL").append("\n"); 
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
		query.append("WITH SCP_MN AS" ).append("\n"); 
		query.append("     (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("		    ,PRS_GEN_RT_CMPB_CALC_FLG" ).append("\n"); 
		query.append("		    ,PRS_SPCL_RT_CMPB_CALC_FLG" ).append("\n"); 
		query.append("			,PROP_SCP_STS_CD" ).append("\n"); 
		query.append("      FROM   PRI_SP_SCP_MN" ).append("\n"); 
		query.append("      WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("      AND    AMDT_SEQ = @[amdt_seq])" ).append("\n"); 
		query.append("SELECT 'Boiler Plate' TERMS" ).append("\n"); 
		query.append("	   ,COUNT(*) CNT" ).append("\n"); 
		query.append("		,'' NOTE" ).append("\n"); 
		query.append("FROM PRI_SP_BLPL" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   '[' || B.SVC_SCP_CD || '] ' || 'Origin' TERMS" ).append("\n"); 
		query.append("        ,COUNT (A.SVC_SCP_CD) CNT" ).append("\n"); 
		query.append("		,'' NOTE" ).append("\n"); 
		query.append("FROM     PRI_SP_SCP_ROUT_PNT A" ).append("\n"); 
		query.append("        ,SCP_MN B                                                   " ).append("\n"); 
		query.append("WHERE    PROP_NO(+)   = @[prop_no]" ).append("\n"); 
		query.append("AND      AMDT_SEQ(+)  = @[amdt_seq]" ).append("\n"); 
		query.append("AND      B.SVC_SCP_CD = A.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND      A.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("AND 	 A.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   '[' || B.SVC_SCP_CD || '] ' || 'Destination' TERMS" ).append("\n"); 
		query.append("        ,COUNT (A.SVC_SCP_CD) CNT" ).append("\n"); 
		query.append("		,'' NOTE" ).append("\n"); 
		query.append("FROM     PRI_SP_SCP_ROUT_PNT A" ).append("\n"); 
		query.append("        ,SCP_MN B                                                   " ).append("\n"); 
		query.append("WHERE    PROP_NO(+)   = @[prop_no]" ).append("\n"); 
		query.append("AND      AMDT_SEQ(+)  = @[amdt_seq]" ).append("\n"); 
		query.append("AND      B.SVC_SCP_CD = A.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND      A.ORG_DEST_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("AND 	 A.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   '[' || B.SVC_SCP_CD || '] ' || 'CMDT Group' TERMS" ).append("\n"); 
		query.append("        ,COUNT (A.SVC_SCP_CD) CNT" ).append("\n"); 
		query.append("		,'' NOTE" ).append("\n"); 
		query.append("FROM     PRI_SP_SCP_GRP_CMDT_DTL A" ).append("\n"); 
		query.append("        ,SCP_MN B                                                   " ).append("\n"); 
		query.append("WHERE    PROP_NO(+) = @[prop_no]" ).append("\n"); 
		query.append("AND      AMDT_SEQ(+) = @[amdt_seq]" ).append("\n"); 
		query.append("AND      A.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append("AND      B.SVC_SCP_CD = A.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   '[' || B.SVC_SCP_CD || '] ' || 'STANDARD NOTE' TERMS" ).append("\n"); 
		query.append("        ,COUNT (A.SVC_SCP_CD) CNT" ).append("\n"); 
		query.append("		,'' NOTE" ).append("\n"); 
		query.append("FROM     PRI_SP_SCP_NOTE_CTNT A" ).append("\n"); 
		query.append("        ,SCP_MN B                                                   " ).append("\n"); 
		query.append("WHERE    PROP_NO(+) = @[prop_no]" ).append("\n"); 
		query.append("AND      AMDT_SEQ(+) = @[amdt_seq]" ).append("\n"); 
		query.append("AND      NOTE_TP_CD(+) = 'T'" ).append("\n"); 
		query.append("AND      A.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append("AND      B.SVC_SCP_CD = A.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND      B.SVC_SCP_CD IN ('TPE', 'ACE', 'TPW', 'ASE', 'TAE', 'SAS', 'MME', 'ACW', 'MXW')" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   '[' || B.SVC_SCP_CD || '] ' || 'RATE' TERMS" ).append("\n"); 
		query.append("        ,COUNT (A.SVC_SCP_CD) CNT" ).append("\n"); 
		query.append("		,'' NOTE" ).append("\n"); 
		query.append("FROM     PRI_SP_SCP_RT A" ).append("\n"); 
		query.append("        ,SCP_MN B                                                   " ).append("\n"); 
		query.append("WHERE    PROP_NO(+) = @[prop_no]" ).append("\n"); 
		query.append("AND      AMDT_SEQ(+) = @[amdt_seq]" ).append("\n"); 
		query.append("AND 	 A.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append("AND      B.SVC_SCP_CD = A.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '[' || SVC_SCP_CD || '] ' || 'Rate Commodity Group Detail'" ).append("\n"); 
		query.append("      ,DECODE (COUNT (*), 0, 1, 0)" ).append("\n"); 
		query.append("		,'' NOTE" ).append("\n"); 
		query.append("FROM   (                                         --Rate Commodity Group Detail" ).append("\n"); 
		query.append("        SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        FROM   PRI_SP_SCP_RT_CMDT" ).append("\n"); 
		query.append("        WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("		AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        MINUS" ).append("\n"); 
		query.append("        SELECT DISTINCT SVC_SCP_CD" ).append("\n"); 
		query.append("                       ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                       ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        FROM            PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("        WHERE           PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND             AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("		AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'AMEND' TERMS" ).append("\n"); 
		query.append("	   ,SUM(CNT) CNT" ).append("\n"); 
		query.append("	   ,'' NOTE" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("	SELECT COUNT(*) CNT FROM PRI_SP_AMDT_SMRY" ).append("\n"); 
		query.append("	WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("	AND ROWNUM = 1" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT COUNT(*) FROM PRI_SP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("	WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("	AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'DEMDET' TERMS" ).append("\n"); 
		query.append("     , CASE MAX(DECODE(TYP,'S',CNT)) WHEN 1" ).append("\n"); 
		query.append("            THEN CASE MAX(DECODE(TYP,'D',CNT)) WHEN 1" ).append("\n"); 
		query.append("                      THEN 3" ).append("\n"); 
		query.append("                 ELSE 1" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("       ELSE " ).append("\n"); 
		query.append("            CASE MAX(DECODE(TYP,'D',CNT)) WHEN 1" ).append("\n"); 
		query.append("                 THEN 2" ).append("\n"); 
		query.append("            ELSE 3" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       END CNT" ).append("\n"); 
		query.append("      ,MAX(NOTE) NOTE" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("          SELECT   SIGN(SUM(CNT)) CNT, 'S' TYP " ).append("\n"); 
		query.append("                  ,MAX(DECODE(TYP,1,DECODE(SIGN(CNT),1,TITLE)))||" ).append("\n"); 
		query.append("                   MAX(DECODE(TYP,2,DECODE(SIGN(CNT),1,TITLE)))||" ).append("\n"); 
		query.append("                   MAX(DECODE(TYP,3,DECODE(SIGN(CNT),1,TITLE))) NOTE   " ).append("\n"); 
		query.append("          FROM     (SELECT   COUNT( * ) CNT, '/COMMODITY NOTE' TITLE, 1 TYP" ).append("\n"); 
		query.append("                    FROM     PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("                    WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                         AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                         AND NOTE_CLSS_CD = 'D'" ).append("\n"); 
		query.append("						 AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                         AND ROWNUM = 1" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT   COUNT( * ), '/ROUTE NOTE', 2 TYP" ).append("\n"); 
		query.append("                    FROM     PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("                    WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                         AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                         AND NOTE_CLSS_CD = 'D'" ).append("\n"); 
		query.append("						 AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                         AND ROWNUM = 1" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT   COUNT( * ), '/SPECIAL NOTE', 3 TYP" ).append("\n"); 
		query.append("                    FROM     PRI_SP_SCP_NOTE A" ).append("\n"); 
		query.append("                    WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                         AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                         AND NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("                         AND NOTE_CLSS_CD = 'D'" ).append("\n"); 
		query.append("                         AND EXISTS (SELECT 1 FROM PRI_SP_SCP_NOTE_CTNT " ).append("\n"); 
		query.append("                                     WHERE A.PROP_NO    = PROP_NO " ).append("\n"); 
		query.append("                                     AND   A.AMDT_SEQ   = AMDT_SEQ " ).append("\n"); 
		query.append("                                     AND   A.SVC_SCP_CD = SVC_SCP_CD" ).append("\n"); 
		query.append("                                     AND   A.NOTE_TP_CD = NOTE_TP_CD " ).append("\n"); 
		query.append("                                     AND   A.NOTE_SEQ   = NOTE_SEQ" ).append("\n"); 
		query.append("                                     AND   SRC_INFO_CD  <> 'AD'))" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT   SIGN(COUNT( * )) CNT, 'D' , ''" ).append("\n"); 
		query.append("          FROM     DMT_SC_EXPT_VER" ).append("\n"); 
		query.append("          WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("               AND SC_EXPT_VER_SEQ = (SELECT /*+ INDEX_DESC(A XPKDMT_SC_EXPT_VER) */" ).append("\n"); 
		query.append("                                            SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                                      FROM     DMT_SC_EXPT_VER A" ).append("\n"); 
		query.append("                                      WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1)" ).append("\n"); 
		query.append("               AND DELT_FLG = 'N'               " ).append("\n"); 
		query.append("               AND DMDT_EXPT_VER_STS_CD IN ('A','L','R')   " ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   'CTRT_CHK', 1 CNT, ''" ).append("\n"); 
		query.append("FROM     PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("WHERE    PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("     AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("     AND (CTRT_PTY_ADDR       = 'Please Input'" ).append("\n"); 
		query.append("       OR CTRT_PTY_SGN_NM     = 'Please Input'" ).append("\n"); 
		query.append("       OR CTRT_PTY_SGN_TIT_NM = 'Please Input')" ).append("\n"); 
		query.append("     AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'CHSS' TERMS" ).append("\n"); 
		query.append("     , CASE MAX(DECODE(TYP,'S',CNT)) WHEN 1" ).append("\n"); 
		query.append("            THEN CASE MAX(DECODE(TYP,'C',CNT)) WHEN 1" ).append("\n"); 
		query.append("                      THEN 3" ).append("\n"); 
		query.append("                 ELSE 1" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("       ELSE " ).append("\n"); 
		query.append("            CASE MAX(DECODE(TYP,'C',CNT)) WHEN 1" ).append("\n"); 
		query.append("                 THEN 2" ).append("\n"); 
		query.append("            ELSE 3" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       END CNT" ).append("\n"); 
		query.append("      ,MAX(NOTE) NOTE" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("          SELECT   SIGN(SUM(CNT)) CNT, 'S' TYP " ).append("\n"); 
		query.append("                  ,MAX(DECODE(TYP,1,DECODE(SIGN(CNT),1,TITLE)))||" ).append("\n"); 
		query.append("                   MAX(DECODE(TYP,2,DECODE(SIGN(CNT),1,TITLE)))||" ).append("\n"); 
		query.append("                   MAX(DECODE(TYP,3,DECODE(SIGN(CNT),1,TITLE))) NOTE   " ).append("\n"); 
		query.append("          FROM     (SELECT   COUNT( * ) CNT, '/COMMODITY NOTE' TITLE, 1 TYP" ).append("\n"); 
		query.append("                    FROM     PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("                    WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                         AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                         AND NOTE_CLSS_CD = 'C' --CHSS Note ����� ������������" ).append("\n"); 
		query.append("						 AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                         AND ROWNUM = 1" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT   COUNT( * ), '/ROUTE NOTE', 2 TYP" ).append("\n"); 
		query.append("                    FROM     PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("                    WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                         AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                         AND NOTE_CLSS_CD =  'C' --CHSS Note ����� ������������" ).append("\n"); 
		query.append("						 AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                         AND ROWNUM = 1" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT   COUNT( * ), '/SPECIAL NOTE', 3 TYP " ).append("\n"); 
		query.append("                    FROM     PRI_SP_SCP_NOTE A" ).append("\n"); 
		query.append("                    WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                         AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                         AND NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("                         AND NOTE_CLSS_CD = 'C' --CHSS Note ����� ������������" ).append("\n"); 
		query.append("                         AND EXISTS (SELECT 1 FROM PRI_SP_SCP_NOTE_CTNT " ).append("\n"); 
		query.append("                                     WHERE A.PROP_NO    = PROP_NO " ).append("\n"); 
		query.append("                                     AND   A.AMDT_SEQ   = AMDT_SEQ " ).append("\n"); 
		query.append("                                     AND   A.SVC_SCP_CD = SVC_SCP_CD" ).append("\n"); 
		query.append("                                     AND   A.NOTE_TP_CD = NOTE_TP_CD " ).append("\n"); 
		query.append("                                     AND   A.NOTE_SEQ   = NOTE_SEQ" ).append("\n"); 
		query.append("                                     AND   SRC_INFO_CD  <> 'AD'))" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT   SIGN(COUNT( * )) CNT, 'C' , ''" ).append("\n"); 
		query.append("          FROM     CGM_SC_EXPT_VER " ).append("\n"); 
		query.append("          WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND     SC_EXPT_VER_SEQ = (SELECT /*+ INDEX_DESC(A XPKCGM_SC_EXPT_VER) */" ).append("\n"); 
		query.append("                                            SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                                      FROM     CGM_SC_EXPT_VER A" ).append("\n"); 
		query.append("                                      WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                        AND ROWNUM = 1)" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N'               " ).append("\n"); 
		query.append("          -- AND CHSS_EXPT_VER_STS_CD IN ('A','L','R')   " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'DIFF_CUST_TP_CHK', 1" ).append("\n"); 
		query.append("    ,   SUBSTR(SYS_CONNECT_BY_PATH ( SVC_SCP_CD, ',' ),2)" ).append("\n"); 
		query.append("FROM     " ).append("\n"); 
		query.append("    (   SELECT  A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD" ).append("\n"); 
		query.append("            ,   ROW_NUMBER() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ ORDER BY A.SVC_SCP_CD )AS RN" ).append("\n"); 
		query.append("            ,   COUNT(1) OVER ( PARTITION BY A.PROP_NO, A.AMDT_SEQ ) AS CNT" ).append("\n"); 
		query.append("        FROM    PRI_SP_SCP_MN A" ).append("\n"); 
		query.append("            ,   PRI_SG_STND_NOTE_HDR B" ).append("\n"); 
		query.append("            ,   PRI_SP_CTRT_CUST_TP C" ).append("\n"); 
		query.append("        WHERE   A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND     A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("        AND     A.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("        AND     A.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     A.SVC_SCP_CD IN ('TPE', 'ACE', 'TPW', 'ASE', 'TAE', 'SAS', 'MME', 'ACW', 'MXW')" ).append("\n"); 
		query.append("        AND     A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     A.NOTE_HDR_SEQ = B.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("        AND     B.PRC_CUST_TP_CD IS NOT NULL " ).append("\n"); 
		query.append("        AND     C.PRC_CTRT_CUST_TP_CD <> B.PRC_CUST_TP_CD " ).append("\n"); 
		query.append("        AND     NOT EXISTS " ).append("\n"); 
		query.append("            (   SELECT  1" ).append("\n"); 
		query.append("                FROM    PRI_SP_SCP_MN X" ).append("\n"); 
		query.append("                WHERE   X.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                AND     X.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     X.AMDT_SEQ < A.AMDT_SEQ ) )" ).append("\n"); 
		query.append("WHERE   LEVEL = CNT" ).append("\n"); 
		query.append("CONNECT BY PRIOR RN = RN - 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	'VALID_AFIL_CHK', 1, C.SVC_SCP_CD||'|'||C.CUST_CNT_CD||TRIM(TO_CHAR(C.CUST_SEQ,'000000'))" ).append("\n"); 
		query.append("FROM	PRI_SP_CTRT_CUST_TP T" ).append("\n"); 
		query.append("	,	PRI_SP_SCP_RT_ACT_CUST C" ).append("\n"); 
		query.append("WHERE	T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND		T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND		T.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND		T.PRC_CTRT_CUST_TP_CD = 'A'" ).append("\n"); 
		query.append("AND		T.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("AND		T.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("AND		C.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND     NOT EXISTS" ).append("\n"); 
		query.append("    (   SELECT  1" ).append("\n"); 
		query.append("        FROM    PRI_SP_AFIL A" ).append("\n"); 
		query.append("        WHERE   C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("        AND		C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("        AND		C.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND		C.CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("        AND		A.SRC_INFO_CD <> 'AD' )" ).append("\n"); 
		query.append("AND		ROWNUM <= 1" ).append("\n"); 

	}
}