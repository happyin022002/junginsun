/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGuidelineMainDBDAORsltGlineTermsCntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.06.23 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGuidelineMainDBDAORsltGlineTermsCntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SC Guideline 각 탭별 Count 가져오기
	  * </pre>
	  */
	public SCGuidelineMainDBDAORsltGlineTermsCntVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT (SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_SG_SLS_REF" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]) AS SLS_REF_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_SG_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]) AS GRP_LOC_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_SG_GRP_CMDT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]) AS GRP_CMDT_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_SG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]) AS ARB_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_SG_RT_CMDT_HDR" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]) AS RATE_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_SG_GOH_CHG" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]) AS GOH_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_SG_CTRT_CLUZ" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]) AS CTRT_CLUZ_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_SG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O') AS ORG_ARB_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_SG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D') AS DEST_ARB_CNT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.integration").append("\n"); 
		query.append("FileName : SCGuidelineMainDBDAORsltGlineTermsCntVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}