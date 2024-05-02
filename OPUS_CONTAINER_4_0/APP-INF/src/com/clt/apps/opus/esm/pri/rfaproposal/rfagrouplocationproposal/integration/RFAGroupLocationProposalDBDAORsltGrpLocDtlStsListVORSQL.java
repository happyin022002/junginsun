/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupLocationProposalDBDAORsltGrpLocDtlStsListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.11 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupLocationProposalDBDAORsltGrpLocDtlStsListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAGroupLocationProposalDBDAORsltGrpLocDtlStsListVORSQL
	  * </pre>
	  */
	public RFAGroupLocationProposalDBDAORsltGrpLocDtlStsListVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.integration").append("\n"); 
		query.append("FileName : RFAGroupLocationProposalDBDAORsltGrpLocDtlStsListVORSQL").append("\n"); 
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
		query.append("DTL.PROP_NO         ," ).append("\n"); 
		query.append("DTL.AMDT_SEQ        ," ).append("\n"); 
		query.append("DTL.SVC_SCP_CD      ," ).append("\n"); 
		query.append("DTL.GRP_LOC_SEQ     ," ).append("\n"); 
		query.append("DTL.GRP_LOC_DTL_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RP_SCP_GRP_LOC_DTL DTL," ).append("\n"); 
		query.append("PRI_RP_SCP_MN MN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("MN.PROP_NO          = @[prop_no]" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ         = @[amdt_seq]" ).append("\n"); 
		query.append("AND MN.SVC_SCP_CD       = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND MN.PROP_NO          = DTL.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ         = DTL.AMDT_SEQ" ).append("\n"); 
		query.append("AND MN.SVC_SCP_CD       = DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("AND DTL.N1ST_CMNC_AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("AND DTL.PRC_PROG_STS_CD <> @[prc_prog_sts_cd]" ).append("\n"); 

	}
}