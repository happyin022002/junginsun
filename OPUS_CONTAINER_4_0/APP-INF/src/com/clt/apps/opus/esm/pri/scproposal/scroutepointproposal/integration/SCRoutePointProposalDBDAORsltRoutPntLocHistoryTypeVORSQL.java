/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCRoutePointProposalDBDAORsltRoutPntLocHistoryTypeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRoutePointProposalDBDAORsltRoutPntLocHistoryTypeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ORIGIN & DESTINATION에 데이터가 존재하는지 조회한다.
	  * </pre>
	  */
	public SCRoutePointProposalDBDAORsltRoutPntLocHistoryTypeVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.integration").append("\n"); 
		query.append("FileName : SCRoutePointProposalDBDAORsltRoutPntLocHistoryTypeVORSQL").append("\n"); 
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
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("     , 'O' ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , COUNT(N1ST_CMNC_AMDT_SEQ) AMEND_CNT" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_ROUT_PNT" ).append("\n"); 
		query.append(" WHERE AMDT_SEQ         = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD       = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND PROP_NO			= @[prop_no]" ).append("\n"); 
		query.append("   AND ORG_DEST_TP_CD	= 'O'" ).append("\n"); 
		query.append("   AND N1ST_CMNC_AMDT_SEQ = AMDT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("     , 'D' ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , COUNT(N1ST_CMNC_AMDT_SEQ) AMEND_CNT" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_ROUT_PNT" ).append("\n"); 
		query.append(" WHERE AMDT_SEQ         = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD       = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND PROP_NO			= @[prop_no]" ).append("\n"); 
		query.append("   AND ORG_DEST_TP_CD	= 'D'" ).append("\n"); 
		query.append("   AND N1ST_CMNC_AMDT_SEQ = AMDT_SEQ" ).append("\n"); 
		query.append(" GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD" ).append("\n"); 

	}
}