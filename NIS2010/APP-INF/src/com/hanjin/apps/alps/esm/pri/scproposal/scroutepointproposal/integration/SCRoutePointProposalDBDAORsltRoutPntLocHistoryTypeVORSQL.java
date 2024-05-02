/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCRoutePointProposalDBDAORsltRoutPntLocHistoryTypeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.02.23 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
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
	  * 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.integration").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("   AND (( SELECT LGCY_IF_FLG " ).append("\n"); 
		query.append("			FROM PRI_SP_MN " ).append("\n"); 
		query.append("		   WHERE PROP_NO  = @[prop_no] " ).append("\n"); 
		query.append("			 AND AMDT_SEQ = @[amdt_seq] ) = 'N' OR SRC_INFO_CD <> 'AD' ) " ).append("\n"); 
		query.append("   AND N1ST_CMNC_AMDT_SEQ = DECODE(( SELECT LGCY_IF_FLG " ).append("\n"); 
		query.append("									   FROM PRI_SP_MN " ).append("\n"); 
		query.append("		   							  WHERE PROP_NO  = @[prop_no] " ).append("\n"); 
		query.append("			 							AND AMDT_SEQ = @[amdt_seq] ), 'N', AMDT_SEQ, N1ST_CMNC_AMDT_SEQ) " ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("   AND (( SELECT LGCY_IF_FLG " ).append("\n"); 
		query.append("			FROM PRI_SP_MN " ).append("\n"); 
		query.append("		   WHERE PROP_NO  = @[prop_no] " ).append("\n"); 
		query.append("			 AND AMDT_SEQ = @[amdt_seq] ) = 'N' OR SRC_INFO_CD <> 'AD' ) " ).append("\n"); 
		query.append("   AND N1ST_CMNC_AMDT_SEQ = DECODE(( SELECT LGCY_IF_FLG " ).append("\n"); 
		query.append("									   FROM PRI_SP_MN " ).append("\n"); 
		query.append("		   							  WHERE PROP_NO  = @[prop_no] " ).append("\n"); 
		query.append("			 							AND AMDT_SEQ = @[amdt_seq] ), 'N', AMDT_SEQ, N1ST_CMNC_AMDT_SEQ) " ).append("\n"); 
		query.append(" #if (${con_flg} == '0') " ).append("\n"); 
		query.append("AND  0=0" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 1=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD" ).append("\n"); 

	}
}