/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRoutePointProposalDBDAORsltRoutPntLocTypeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRoutePointProposalDBDAORsltRoutPntLocTypeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * type
	  * </pre>
	  */
	public SCRoutePointProposalDBDAORsltRoutPntLocTypeVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.integration").append("\n"); 
		query.append("FileName : SCRoutePointProposalDBDAORsltRoutPntLocTypeVORSQL").append("\n"); 
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
		query.append("	 , AMDT_SEQ" ).append("\n"); 
		query.append("	 , SVC_SCP_CD" ).append("\n"); 
		query.append("	 , MAX(DECODE(ORG_DEST_TP_CD, 'O', 'O')) AS ORG_TP_CD" ).append("\n"); 
		query.append("	 , MAX(DECODE(ORG_DEST_TP_CD, 'D', 'D')) AS DEST_TP_CD" ).append("\n"); 
		query.append("	 , MAX(DECODE(ORG_DEST_TP_CD, 'O', SRC_INFO_CD)) AS ORG_SRC_INFO_CD" ).append("\n"); 
		query.append("	 , MAX(DECODE(ORG_DEST_TP_CD, 'D', SRC_INFO_CD)) AS DEST_SRC_INFO_CD" ).append("\n"); 
		query.append("	 , MAX(DECODE(ORG_DEST_TP_CD, 'O', PRC_PROG_STS_CD)) AS ORG_PRC_PROG_STS_CD" ).append("\n"); 
		query.append("	 , MAX(DECODE(ORG_DEST_TP_CD, 'D', PRC_PROG_STS_CD)) AS DEST_PRC_PROG_STS_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO" ).append("\n"); 
		query.append("			 , AMDT_SEQ" ).append("\n"); 
		query.append("			 , SVC_SCP_CD" ).append("\n"); 
		query.append("			 , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			 , CASE WHEN SUM(CASE WHEN AMDT_SEQ = @[amdt_seq] AND AMDT_SEQ > 0 THEN 1 ELSE 0 END) = 0 THEN 'NW'" ).append("\n"); 
		query.append("					ELSE 'AM' END SRC_INFO_CD" ).append("\n"); 
		query.append("			 , CASE WHEN SUM(CASE WHEN PRC_PROG_STS_CD != 'A' THEN 1 ELSE 0 END) = 0 THEN 'A'" ).append("\n"); 
		query.append("					ELSE 'I' END PRC_PROG_STS_CD" ).append("\n"); 
		query.append("		  FROM PRI_SP_SCP_ROUT_PNT" ).append("\n"); 
		query.append("		 WHERE AMDT_SEQ         	= @[amdt_seq]" ).append("\n"); 
		query.append("		   AND SVC_SCP_CD       	= @[svc_scp_cd]" ).append("\n"); 
		query.append("		   AND PROP_NO				= @[prop_no]" ).append("\n"); 
		query.append("		   AND N1ST_CMNC_AMDT_SEQ 	= @[amdt_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   AND (( SELECT LGCY_IF_FLG " ).append("\n"); 
		query.append("					FROM PRI_SP_MN " ).append("\n"); 
		query.append("				   WHERE PROP_NO  = @[prop_no] " ).append("\n"); 
		query.append("					 AND AMDT_SEQ = @[amdt_seq] ) = 'N' OR SRC_INFO_CD <> 'AD' ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 GROUP BY PROP_NO , AMDT_SEQ , SVC_SCP_CD , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT PROP_NO" ).append("\n"); 
		query.append("			 , AMDT_SEQ" ).append("\n"); 
		query.append("			 , SVC_SCP_CD" ).append("\n"); 
		query.append("			 , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			 , '' SRC_INFO_CD" ).append("\n"); 
		query.append("			 , '' PRC_PROG_STS_CD" ).append("\n"); 
		query.append("		  FROM PRI_SP_SCP_ROUT_PNT " ).append("\n"); 
		query.append("		 WHERE AMDT_SEQ         	= @[amdt_seq]" ).append("\n"); 
		query.append("		   AND SVC_SCP_CD       	= @[svc_scp_cd]" ).append("\n"); 
		query.append("		   AND PROP_NO				= @[prop_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   AND (( SELECT LGCY_IF_FLG " ).append("\n"); 
		query.append("					FROM PRI_SP_MN " ).append("\n"); 
		query.append("				   WHERE PROP_NO  = @[prop_no] " ).append("\n"); 
		query.append("					 AND AMDT_SEQ = @[amdt_seq] ) = 'N' OR SRC_INFO_CD <> 'AD' ) " ).append("\n"); 
		query.append("	 ) A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD" ).append("\n"); 

	}
}