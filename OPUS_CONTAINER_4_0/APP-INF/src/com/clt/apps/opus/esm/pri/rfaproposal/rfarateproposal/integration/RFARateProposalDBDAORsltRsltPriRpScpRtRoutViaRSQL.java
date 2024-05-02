/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFARateProposalDBDAORsltRsltPriRpScpRtRoutViaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltRsltPriRpScpRtRoutViaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT PRI_RP_SCP_RT_ROUT_VIA
	  * </pre>
	  */
	public RFARateProposalDBDAORsltRsltPriRpScpRtRoutViaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration ").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltRsltPriRpScpRtRoutViaRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       PROP_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("     , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , ROUT_SEQ" ).append("\n"); 
		query.append("     , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , ROUT_VIA_SEQ" ).append("\n"); 
		query.append("     , ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("     , ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("     , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , SRC_INFO_CD" ).append("\n"); 
		query.append("     , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , ACPT_USR_ID" ).append("\n"); 
		query.append("     , ACPT_OFC_CD" ).append("\n"); 
		query.append("     , ACPT_DT" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append(" WHERE PROP_NO             = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ            IN (@[amdt_seq], TO_NUMBER(@[amdt_seq])-1)" ).append("\n"); 
		query.append("   AND SVC_SCP_CD          = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND CMDT_HDR_SEQ        = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("   AND ROUT_SEQ            = @[rout_seq]" ).append("\n"); 
		query.append("   AND ORG_DEST_TP_CD      = @[org_dest_tp_cd]" ).append("\n"); 

	}
}