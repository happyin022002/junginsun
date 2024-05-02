/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGuidelineMainDBDAORsltGlineTermsCntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.07.16 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGuidelineMainDBDAORsltGlineTermsCntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SC Guideline 각 탭별 Count 가져오기
	  * </pre>
	  */
	public RFAGuidelineMainDBDAORsltGlineTermsCntVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.integration").append("\n"); 
		query.append("FileName : RFAGuidelineMainDBDAORsltGlineTermsCntVORSQL").append("\n"); 
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
		query.append("SELECT (SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]) AS GRP_LOC_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_CMDT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]) AS GRP_CMDT_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_RG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]) AS ARB_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_HDR" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]) AS RATE_CNT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}