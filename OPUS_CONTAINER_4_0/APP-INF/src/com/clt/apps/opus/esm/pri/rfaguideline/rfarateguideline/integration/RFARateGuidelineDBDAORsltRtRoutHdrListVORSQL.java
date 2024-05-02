/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateGuidelineDBDAORsltRtRoutHdrListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.10.07 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateGuidelineDBDAORsltRtRoutHdrListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate - Route조회
	  * </pre>
	  */
	public RFARateGuidelineDBDAORsltRtRoutHdrListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RFARateGuidelineDBDAORsltRtRoutHdrListVORSQL").append("\n"); 
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
		query.append(",A.GLINE_SEQ" ).append("\n"); 
		query.append(",A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",A.ROUT_SEQ" ).append("\n"); 
		query.append(",A.DIR_CALL_FLG" ).append("\n"); 
		query.append(",B.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",C.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",D.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",E.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_ROUT A" ).append("\n"); 
		query.append(",(SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("FROM (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD) B" ).append("\n"); 
		query.append(",(SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("FROM (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD) C" ).append("\n"); 
		query.append(",(SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("FROM (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD) D" ).append("\n"); 
		query.append(",(SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("FROM (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD) E" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = B.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = B.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = C.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = C.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = D.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = E.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = E.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("ORDER BY B.SORT_KEY" ).append("\n"); 
		query.append(",E.SORT_KEY" ).append("\n"); 
		query.append(",C.SORT_KEY" ).append("\n"); 
		query.append(",D.SORT_KEY" ).append("\n"); 
		query.append(",A.DIR_CALL_FLG DESC" ).append("\n"); 

	}
}