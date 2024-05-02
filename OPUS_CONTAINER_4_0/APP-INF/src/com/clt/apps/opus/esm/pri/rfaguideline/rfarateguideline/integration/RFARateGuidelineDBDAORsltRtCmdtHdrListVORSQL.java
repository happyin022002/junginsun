/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateGuidelineDBDAORsltRtCmdtHdrListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateGuidelineDBDAORsltRtCmdtHdrListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Commodity 조회
	  * </pre>
	  */
	public RFARateGuidelineDBDAORsltRtCmdtHdrListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.integration").append("\n"); 
		query.append("FileName : RFARateGuidelineDBDAORsltRtCmdtHdrListVORSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,A.GLINE_SEQ" ).append("\n"); 
		query.append("      ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ,TO_CHAR(A.EFF_DT, 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.EXP_DT, 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("      ,A.NOTE_CTNT" ).append("\n"); 
		query.append("      ,B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("      ,B.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("  FROM PRI_RG_RT_CMDT_HDR A" ).append("\n"); 
		query.append("      ,(SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GLINE_SEQ" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(PRC_CMDT_TP_CD, 'G', 1, 'R', 2, 'C', 3, 9), '|')) AS TP_ORD" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD, ' / ')), 4) AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM, ' / ')), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("          FROM (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GLINE_SEQ" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,CMDT_SEQ" ).append("\n"); 
		query.append("                      ,PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                      ,PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                      ,DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                             ,'G'" ).append("\n"); 
		query.append("                             ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                                FROM PRI_RG_GRP_CMDT" ).append("\n"); 
		query.append("                               WHERE SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                 AND GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("                                 AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'R'" ).append("\n"); 
		query.append("                             ,(SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("                               WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'C'" ).append("\n"); 
		query.append("                             ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                               WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ ORDER BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, DECODE(PRC_CMDT_TP_CD, 'G', '1', 'R', '2', 'C', '3'), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RG_RT_CMDT A" ).append("\n"); 
		query.append("                 WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GLINE_SEQ = @[gline_seq])" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ) B" ).append("\n"); 
		query.append(" WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append(" ORDER BY B.TP_ORD, B.PRC_CMDT_DEF_CD" ).append("\n"); 

	}
}