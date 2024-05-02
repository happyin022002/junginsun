/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateGuidelineDBDAORsltRtCmdtHdrListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.07.16 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateGuidelineDBDAORsltRtCmdtHdrListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Commodity 조회
	  * </pre>
	  */
	public SCRateGuidelineDBDAORsltRtCmdtHdrListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.integration").append("\n"); 
		query.append("FileName : SCRateGuidelineDBDAORsltRtCmdtHdrListVORSQL").append("\n"); 
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
		query.append(",A.PRC_CUST_TP_CD" ).append("\n"); 
		query.append(",A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",TO_CHAR(A.EFF_DT, 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.EXP_DT, 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append(",A.NOTE_CTNT" ).append("\n"); 
		query.append(",B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",B.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SG_RT_CMDT_HDR A" ).append("\n"); 
		query.append(",(SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",PRC_CUST_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",DECODE(MAX(PRC_CMDT_TP_CD), 'G', 1, 'C', 2, 99) AS TP_ORD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD, ' / ')), 4) AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM, ' / ')), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",PRC_CUST_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",CMDT_SEQ" ).append("\n"); 
		query.append(",PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("FROM PRI_SG_GRP_CMDT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND PRC_CUST_TP_CD = A.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'C'" ).append("\n"); 
		query.append(",(SELECT CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ ORDER BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ, DECODE(PRC_CMDT_TP_CD, 'G', '1', 'C', '2'), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_SG_RT_CMDT A" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND PRC_CUST_TP_CD = @[prc_cust_tp_cd])" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ) B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND A.PRC_CUST_TP_CD = B.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND A.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("ORDER BY B.TP_ORD, B.PRC_CMDT_DEF_CD" ).append("\n"); 

	}
}