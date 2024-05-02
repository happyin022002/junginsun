/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCGroupLocationProposalDBDAORsltRtAcceptedListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupLocationProposalDBDAORsltRtAcceptedListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCGroupLocationProposalDBDAORsltRtAcceptedListVORSQL
	  * </pre>
	  */
	public SCGroupLocationProposalDBDAORsltRtAcceptedListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.integration").append("\n"); 
		query.append("FileName : SCGroupLocationProposalDBDAORsltRtAcceptedListVORSQL").append("\n"); 
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
		query.append("LOC.PRC_GRP_LOC_CD PRC_GRP_LOC_DESC," ).append("\n"); 
		query.append("SRC.LOC_CD PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_SP_SCP_GRP_LOC LOC," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("GRP_LOC_SEQ , LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_SP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ 			= @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD 			= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND PRC_PROG_STS_CD     = 'A'" ).append("\n"); 
		query.append("AND N1ST_CMNC_AMDT_SEQ  = @[amdt_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") SRC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("LOC.PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("AND LOC.AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("AND LOC.SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND LOC.GRP_LOC_SEQ = SRC.GRP_LOC_SEQ" ).append("\n"); 
		query.append("AND LOC.GRP_LOC_SEQ IN (" ).append("\n"); 
		query.append("#foreach($key IN ${txtArr})" ).append("\n"); 
		query.append("#if($velocityCount < $txtArr.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("LOC.PRC_GRP_LOC_CD," ).append("\n"); 
		query.append("SRC.LOC_CD" ).append("\n"); 

	}
}