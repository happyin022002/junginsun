/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateGuidelineDBDAORsltRtCmdtDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.08.06 박성수
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

public class RFARateGuidelineDBDAORsltRtCmdtDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cmdt Detail조회
	  * </pre>
	  */
	public RFARateGuidelineDBDAORsltRtCmdtDetailVORSQL(){
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
		query.append("FileName : RFARateGuidelineDBDAORsltRtCmdtDetailVORSQL").append("\n"); 
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
		query.append(",A.CMDT_SEQ" ).append("\n"); 
		query.append(",A.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",DECODE(A.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_CMDT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'R'" ).append("\n"); 
		query.append(",(SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'C'" ).append("\n"); 
		query.append(",(SELECT CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT A" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("ORDER BY DECODE(A.PRC_CMDT_TP_CD, 'G', '1', 'R', '2', 'C', '3'), A.PRC_CMDT_DEF_CD" ).append("\n"); 

	}
}