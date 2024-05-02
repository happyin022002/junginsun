/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAODmtScExptVerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.05 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
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
	  * SCProposalMainDBDAO
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
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
		query.append("SELECT CASE SCNT WHEN 1 " ).append("\n"); 
		query.append("                 THEN CASE DCNT WHEN 0 " ).append("\n"); 
		query.append("                                THEN 0" ).append("\n"); 
		query.append("                      ELSE 1" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("       ELSE 1" ).append("\n"); 
		query.append("       END ETC1" ).append("\n"); 
		query.append("      ,NOTE ETC2" ).append("\n"); 
		query.append("FROM(                                          " ).append("\n"); 
		query.append("    SELECT MAX(DECODE(TYP, 'S',CNT)) SCNT" ).append("\n"); 
		query.append("         , MAX(DECODE(TYP, 'D', CNT)) DCNT" ).append("\n"); 
		query.append("         , MAX(NOTE) NOTE" ).append("\n"); 
		query.append("    FROM(" ).append("\n"); 
		query.append("          SELECT   SIGN(SUM(CNT)) CNT, 'S' TYP " ).append("\n"); 
		query.append("                  ,MAX(DECODE(TYP,1,DECODE(SIGN(CNT),1,TITLE)))||" ).append("\n"); 
		query.append("                   MAX(DECODE(TYP,2,DECODE(SIGN(CNT),1,TITLE)))||" ).append("\n"); 
		query.append("                   MAX(DECODE(TYP,3,DECODE(SIGN(CNT),1,TITLE))) NOTE   " ).append("\n"); 
		query.append("          FROM     (SELECT   COUNT( * ) CNT, '/COMMODITY NOTE' TITLE, 1 TYP" ).append("\n"); 
		query.append("                    FROM     PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("                    WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                         AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                         AND NOTE_CLSS_CD = 'D'" ).append("\n"); 
		query.append("						 AND SRC_INFO_CD = 'AD'" ).append("\n"); 
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
		query.append("               AND DMDT_EXPT_VER_STS_CD IN ('A','L')           " ).append("\n"); 
		query.append("         )      " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}