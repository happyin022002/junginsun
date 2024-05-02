/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateQuotationDBDAORsltPriRqRtDuplicateCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.31
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.07.31 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAORsltPriRqRtDuplicateCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DuplicateCheck
	  * </pre>
	  */
	public RFARateQuotationDBDAORsltPriRqRtDuplicateCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAORsltPriRqRtDuplicateCheckRSQL").append("\n"); 
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
		query.append("WITH T AS" ).append("\n"); 
		query.append(" (SELECT A.QTTN_NO," ).append("\n"); 
		query.append("         A.QTTN_VER_NO," ).append("\n"); 
		query.append("         A.CMDT_HDR_SEQ," ).append("\n"); 
		query.append("         A.ROUT_SEQ," ).append("\n"); 
		query.append("         A.RT_SEQ," ).append("\n"); 
		query.append("         B.PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("         REPLACE(B.PRC_CMDT_DEF_NM, '|||', ' / ' || CHR(13)) AS PRC_CMDT_DEF_NM," ).append("\n"); 
		query.append("         D.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("         REPLACE(D.ROUT_PNT_LOC_DEF_NM, '|||', CHR(13)) AS ORG_ROUT_PNT_LOC_DEF_NM," ).append("\n"); 
		query.append("         NVL(E.ROUT_VIA_PORT_DEF_CD, '||') AS ORG_ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("         REPLACE(E.ROUT_VIA_PORT_DEF_NM, '|||', CHR(13)) AS ORG_ROUT_VIA_PORT_DEF_NM," ).append("\n"); 
		query.append("         NVL(F.ROUT_VIA_PORT_DEF_CD, '||') AS DEST_ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("         REPLACE(F.ROUT_VIA_PORT_DEF_NM, '|||', CHR(13)) AS DEST_ROUT_VIA_PORT_DEF_NM," ).append("\n"); 
		query.append("         G.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("         REPLACE(G.ROUT_PNT_LOC_DEF_NM, '|||', CHR(13)) AS DEST_ROUT_PNT_LOC_DEF_NM," ).append("\n"); 
		query.append("         A.RAT_UT_CD," ).append("\n"); 
		query.append("         A.PRC_CGO_TP_CD," ).append("\n"); 
		query.append("         A.CURR_CD," ).append("\n"); 
		query.append("         A.QTTN_RT_AMT" ).append("\n"); 
		query.append("    FROM (SELECT X1.QTTN_NO," ).append("\n"); 
		query.append("                 X1.QTTN_VER_NO," ).append("\n"); 
		query.append("                 X1.CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                 X1.ROUT_SEQ," ).append("\n"); 
		query.append("                 X1.RT_SEQ," ).append("\n"); 
		query.append("                 X1.RAT_UT_CD," ).append("\n"); 
		query.append("                 X1.PRC_CGO_TP_CD," ).append("\n"); 
		query.append("                 X1.CURR_CD," ).append("\n"); 
		query.append("                 X1.QTTN_RT_AMT" ).append("\n"); 
		query.append("            FROM PRI_RQ_RT          X1," ).append("\n"); 
		query.append("                 PRI_RQ_RT_CMDT_HDR X2" ).append("\n"); 
		query.append("           WHERE X1.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                 AND X1.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                 AND X1.QTTN_NO = X2.QTTN_NO" ).append("\n"); 
		query.append("                 AND X1.QTTN_VER_NO = X2.QTTN_VER_NO" ).append("\n"); 
		query.append("                 AND X1.CMDT_HDR_SEQ = X2.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 AND X2.FIC_RT_TP_CD = NVL(@[fic_rt_tp_cd], 'G')) A," ).append("\n"); 
		query.append("         (SELECT QTTN_NO," ).append("\n"); 
		query.append("                 QTTN_VER_NO," ).append("\n"); 
		query.append("                 CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                 MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD, '||')) AS PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("                 SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM, '|||')), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("            FROM (SELECT A.QTTN_NO," ).append("\n"); 
		query.append("                         A.QTTN_VER_NO," ).append("\n"); 
		query.append("                         A.CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                         A.PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("                         DECODE(A.PRC_CMDT_TP_CD, 'G', (SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                                    FROM PRI_RQ_GRP_CMDT" ).append("\n"); 
		query.append("                                   WHERE QTTN_NO = A.QTTN_NO" ).append("\n"); 
		query.append("                                         AND QTTN_VER_NO = A.QTTN_VER_NO" ).append("\n"); 
		query.append("                                         AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                         AND ROWNUM = 1), 'R', (SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("                                    FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("                                   WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                         AND ROWNUM = 1), 'C', (SELECT CMDT_NM" ).append("\n"); 
		query.append("                                    FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                                   WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                         AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM," ).append("\n"); 
		query.append("                         ROW_NUMBER() OVER(PARTITION BY A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ ORDER BY DECODE(A.PRC_CMDT_TP_CD, 'G', '1', 'R', '2', 'C', '3'), A.PRC_CMDT_DEF_CD, A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.CMDT_SEQ) AS RN" ).append("\n"); 
		query.append("                    FROM PRI_RQ_RT_CMDT     A," ).append("\n"); 
		query.append("                         PRI_RQ_RT_CMDT_HDR X" ).append("\n"); 
		query.append("                   WHERE A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                         AND A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                         AND A.QTTN_NO = X.QTTN_NO" ).append("\n"); 
		query.append("                         AND A.QTTN_VER_NO = X.QTTN_VER_NO" ).append("\n"); 
		query.append("                         AND A.CMDT_HDR_SEQ = X.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                         AND NVL(X.FIC_RT_TP_CD, 'G') = NVL(@[fic_rt_tp_cd], 'G'))" ).append("\n"); 
		query.append("           START WITH RN = 1" ).append("\n"); 
		query.append("          CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("           GROUP BY QTTN_NO," ).append("\n"); 
		query.append("                    QTTN_VER_NO," ).append("\n"); 
		query.append("                    CMDT_HDR_SEQ) B," ).append("\n"); 
		query.append("         (SELECT QTTN_NO," ).append("\n"); 
		query.append("                 QTTN_VER_NO," ).append("\n"); 
		query.append("                 CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                 ROUT_SEQ," ).append("\n"); 
		query.append("                 MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || '|' || RCV_DE_TERM_CD, '||')) AS ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("                 SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_NM || NVL2(RCV_DE_TERM_NM, '(' || RCV_DE_TERM_NM || ')', ''), '|||')), 4) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("            FROM (SELECT QTTN_NO," ).append("\n"); 
		query.append("                         QTTN_VER_NO," ).append("\n"); 
		query.append("                         CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                         ROUT_SEQ," ).append("\n"); 
		query.append("                         ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                         ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("                         RCV_DE_TERM_CD," ).append("\n"); 
		query.append("                         DECODE(ROUT_PNT_LOC_TP_CD, 'G', (SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("                                    FROM PRI_RQ_GRP_LOC" ).append("\n"); 
		query.append("                                   WHERE QTTN_NO = A.QTTN_NO" ).append("\n"); 
		query.append("                                         AND QTTN_VER_NO = A.QTTN_VER_NO" ).append("\n"); 
		query.append("                                         AND PRC_GRP_LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                         AND ROWNUM = 1), 'L', (SELECT LOC_NM" ).append("\n"); 
		query.append("                                    FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                   WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                         AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM," ).append("\n"); 
		query.append("                         (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                            FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                           WHERE INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("                                 AND INTG_CD_VAL_CTNT = A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1) AS RCV_DE_TERM_NM," ).append("\n"); 
		query.append("                         ROW_NUMBER() OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD, QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) AS RN" ).append("\n"); 
		query.append("                    FROM PRI_RQ_RT_ROUT_PNT A" ).append("\n"); 
		query.append("                   WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                         AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                         AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("           START WITH RN = 1" ).append("\n"); 
		query.append("          CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                     AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("           GROUP BY QTTN_NO," ).append("\n"); 
		query.append("                    QTTN_VER_NO," ).append("\n"); 
		query.append("                    CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                    ROUT_SEQ," ).append("\n"); 
		query.append("                    ORG_DEST_TP_CD) D," ).append("\n"); 
		query.append("         (SELECT QTTN_NO," ).append("\n"); 
		query.append("                 QTTN_VER_NO," ).append("\n"); 
		query.append("                 CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                 ROUT_SEQ," ).append("\n"); 
		query.append("                 MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '||')) AS ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("                 SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '|||')), 4) AS ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append("            FROM (SELECT QTTN_NO," ).append("\n"); 
		query.append("                         QTTN_VER_NO," ).append("\n"); 
		query.append("                         CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                         ROUT_SEQ," ).append("\n"); 
		query.append("                         ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                         ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("                         ROW_NUMBER() OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD, QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) AS RN" ).append("\n"); 
		query.append("                    FROM PRI_RQ_RT_ROUT_VIA A" ).append("\n"); 
		query.append("                   WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                         AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                         AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("           START WITH RN = 1" ).append("\n"); 
		query.append("          CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                     AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("           GROUP BY QTTN_NO," ).append("\n"); 
		query.append("                    QTTN_VER_NO," ).append("\n"); 
		query.append("                    CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                    ROUT_SEQ," ).append("\n"); 
		query.append("                    ORG_DEST_TP_CD) E," ).append("\n"); 
		query.append("         (SELECT QTTN_NO," ).append("\n"); 
		query.append("                 QTTN_VER_NO," ).append("\n"); 
		query.append("                 CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                 ROUT_SEQ," ).append("\n"); 
		query.append("                 MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '||')) AS ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("                 SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '|||')), 4) AS ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append("            FROM (SELECT QTTN_NO," ).append("\n"); 
		query.append("                         QTTN_VER_NO," ).append("\n"); 
		query.append("                         CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                         ROUT_SEQ," ).append("\n"); 
		query.append("                         ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                         ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("                         ROW_NUMBER() OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD, QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) AS RN" ).append("\n"); 
		query.append("                    FROM PRI_RQ_RT_ROUT_VIA A" ).append("\n"); 
		query.append("                   WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                         AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                         AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("           START WITH RN = 1" ).append("\n"); 
		query.append("          CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                     AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("           GROUP BY QTTN_NO," ).append("\n"); 
		query.append("                    QTTN_VER_NO," ).append("\n"); 
		query.append("                    CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                    ROUT_SEQ," ).append("\n"); 
		query.append("                    ORG_DEST_TP_CD) F," ).append("\n"); 
		query.append("         (SELECT QTTN_NO," ).append("\n"); 
		query.append("                 QTTN_VER_NO," ).append("\n"); 
		query.append("                 CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                 ROUT_SEQ," ).append("\n"); 
		query.append("                 MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || '|' || RCV_DE_TERM_CD, '||')) AS ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("                 SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_NM || NVL2(RCV_DE_TERM_NM, '(' || RCV_DE_TERM_NM || ')', ''), '|||')), 4) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("            FROM (SELECT QTTN_NO," ).append("\n"); 
		query.append("                         QTTN_VER_NO," ).append("\n"); 
		query.append("                         CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                         ROUT_SEQ," ).append("\n"); 
		query.append("                         ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                         ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("                         RCV_DE_TERM_CD," ).append("\n"); 
		query.append("                         DECODE(ROUT_PNT_LOC_TP_CD, 'G', (SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("                                    FROM PRI_RQ_GRP_LOC" ).append("\n"); 
		query.append("                                   WHERE QTTN_NO = A.QTTN_NO" ).append("\n"); 
		query.append("                                         AND QTTN_VER_NO = A.QTTN_VER_NO" ).append("\n"); 
		query.append("                                         AND PRC_GRP_LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                         AND ROWNUM = 1), 'L', (SELECT LOC_NM" ).append("\n"); 
		query.append("                                    FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                   WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                         AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM," ).append("\n"); 
		query.append("                         (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                            FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                           WHERE INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("                                 AND INTG_CD_VAL_CTNT = A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1) AS RCV_DE_TERM_NM," ).append("\n"); 
		query.append("                         ROW_NUMBER() OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD, QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) AS RN" ).append("\n"); 
		query.append("                    FROM PRI_RQ_RT_ROUT_PNT A" ).append("\n"); 
		query.append("                   WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                         AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                         AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("           START WITH RN = 1" ).append("\n"); 
		query.append("          CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                     AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("           GROUP BY QTTN_NO," ).append("\n"); 
		query.append("                    QTTN_VER_NO," ).append("\n"); 
		query.append("                    CMDT_HDR_SEQ," ).append("\n"); 
		query.append("                    ROUT_SEQ," ).append("\n"); 
		query.append("                    ORG_DEST_TP_CD) G" ).append("\n"); 
		query.append("   WHERE A.QTTN_NO = B.QTTN_NO(+)" ).append("\n"); 
		query.append("         AND A.QTTN_VER_NO = B.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("         AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("         AND A.QTTN_NO = D.QTTN_NO(+)" ).append("\n"); 
		query.append("         AND A.QTTN_VER_NO = D.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("         AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("         AND A.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("         AND A.QTTN_NO = E.QTTN_NO(+)" ).append("\n"); 
		query.append("         AND A.QTTN_VER_NO = E.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("         AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("         AND A.ROUT_SEQ = E.ROUT_SEQ(+)" ).append("\n"); 
		query.append("         AND A.QTTN_NO = F.QTTN_NO(+)" ).append("\n"); 
		query.append("         AND A.QTTN_VER_NO = F.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("         AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("         AND A.ROUT_SEQ = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("         AND A.QTTN_NO = G.QTTN_NO(+)" ).append("\n"); 
		query.append("         AND A.QTTN_VER_NO = G.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("         AND A.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("         AND A.ROUT_SEQ = G.ROUT_SEQ(+))" ).append("\n"); 
		query.append("SELECT A.QTTN_NO," ).append("\n"); 
		query.append("       A.QTTN_VER_NO," ).append("\n"); 
		query.append("       A.CMDT_HDR_SEQ," ).append("\n"); 
		query.append("       A.ROUT_SEQ," ).append("\n"); 
		query.append("       A.RT_SEQ," ).append("\n"); 
		query.append("       A.PRC_CMDT_DEF_NM," ).append("\n"); 
		query.append("       A.ORG_ROUT_PNT_LOC_DEF_NM," ).append("\n"); 
		query.append("       A.ORG_ROUT_VIA_PORT_DEF_NM," ).append("\n"); 
		query.append("       A.DEST_ROUT_VIA_PORT_DEF_NM," ).append("\n"); 
		query.append("       A.DEST_ROUT_PNT_LOC_DEF_NM," ).append("\n"); 
		query.append("       A.RAT_UT_CD," ).append("\n"); 
		query.append("       A.PRC_CGO_TP_CD," ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       A.QTTN_RT_AMT," ).append("\n"); 
		query.append("       DENSE_RANK() OVER(PARTITION BY NULL ORDER BY A.QTTN_NO, A.QTTN_VER_NO, A.PRC_CMDT_DEF_CD, A.ORG_ROUT_PNT_LOC_DEF_CD, A.ORG_ROUT_VIA_PORT_DEF_CD, A.DEST_ROUT_VIA_PORT_DEF_CD, A.DEST_ROUT_PNT_LOC_DEF_CD, A.RAT_UT_CD, A.PRC_CGO_TP_CD) AS SEQ," ).append("\n"); 
		query.append("       'Show ' || CHR(64 + ROW_NUMBER() OVER(PARTITION BY A.QTTN_NO, A.QTTN_VER_NO, A.PRC_CMDT_DEF_CD, A.ORG_ROUT_PNT_LOC_DEF_CD, A.ORG_ROUT_VIA_PORT_DEF_CD, A.DEST_ROUT_VIA_PORT_DEF_CD, A.DEST_ROUT_PNT_LOC_DEF_CD, A.RAT_UT_CD, A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                            ORDER BY" ).append("\n"); 
		query.append("                            A.RT_SEQ)) AS VIEW_TEXT" ).append("\n"); 
		query.append("  FROM T A," ).append("\n"); 
		query.append("       (SELECT QTTN_NO," ).append("\n"); 
		query.append("               QTTN_VER_NO," ).append("\n"); 
		query.append("               PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("               ORG_ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("               ORG_ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("               DEST_ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("               DEST_ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("               RAT_UT_CD," ).append("\n"); 
		query.append("               PRC_CGO_TP_CD" ).append("\n"); 
		query.append("          FROM T" ).append("\n"); 
		query.append("         GROUP BY QTTN_NO," ).append("\n"); 
		query.append("                  QTTN_VER_NO," ).append("\n"); 
		query.append("                  PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("                  ORG_ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("                  ORG_ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("                  DEST_ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("                  DEST_ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("                  RAT_UT_CD," ).append("\n"); 
		query.append("                  PRC_CGO_TP_CD" ).append("\n"); 
		query.append("        HAVING COUNT(*) > 1) B" ).append("\n"); 
		query.append(" WHERE A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("       AND A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("       AND A.PRC_CMDT_DEF_CD = B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("       AND A.ORG_ROUT_PNT_LOC_DEF_CD = B.ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("       AND A.ORG_ROUT_VIA_PORT_DEF_CD = B.ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("       AND A.DEST_ROUT_VIA_PORT_DEF_CD = B.DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("       AND A.DEST_ROUT_PNT_LOC_DEF_CD = B.DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("       AND A.RAT_UT_CD = B.RAT_UT_CD" ).append("\n"); 
		query.append("       AND A.PRC_CGO_TP_CD = B.PRC_CGO_TP_CD" ).append("\n"); 

	}
}