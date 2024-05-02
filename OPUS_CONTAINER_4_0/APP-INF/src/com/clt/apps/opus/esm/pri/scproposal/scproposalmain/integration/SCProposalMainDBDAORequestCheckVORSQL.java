/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCProposalMainDBDAORequestCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.13
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.02.13 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
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

	}
}