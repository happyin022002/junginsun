/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAGroupCommodityProposalDBDAORsltRtApplyListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.02
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2016.03.02 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYEONGMI KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupCommodityProposalDBDAORsltRtApplyListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAGroupCommodityProposalDBDAORsltRtApplyListVORSQL
	  * </pre>
	  */
	public RFAGroupCommodityProposalDBDAORsltRtApplyListVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.integration").append("\n"); 
		query.append("FileName : RFAGroupCommodityProposalDBDAORsltRtApplyListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    CMDT.PRC_GRP_CMDT_CD " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    PRI_RP_SCP_GRP_CMDT CMDT," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        PRC_CMDT_DEF_CD CMDT_CD " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        PRI_RP_SCP_RT_CMDT" ).append("\n"); 
		query.append("    WHERE" ).append("\n"); 
		query.append("        PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("    AND AMDT_SEQ 			= @[amdt_seq]" ).append("\n"); 
		query.append("    AND SVC_SCP_CD 			= @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND PRC_CMDT_TP_CD 	= 'G'" ).append("\n"); 
		query.append("    AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        PRC_CMDT_DEF_CD CMDT_CD" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        PRI_RP_SCP_GRI_CMDT " ).append("\n"); 
		query.append("    WHERE" ).append("\n"); 
		query.append("        PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("    AND AMDT_SEQ 			= @[amdt_seq]" ).append("\n"); 
		query.append("    AND SVC_SCP_CD 			= @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND PRC_CMDT_TP_CD = 'G'" ).append("\n"); 
		query.append("    ) SRC" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CMDT.PROP_NO 		    = @[prop_no]" ).append("\n"); 
		query.append("AND CMDT.AMDT_SEQ 		    = @[amdt_seq]" ).append("\n"); 
		query.append("AND CMDT.SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CMDT.PRC_GRP_CMDT_CD 	= SRC.CMDT_CD" ).append("\n"); 
		query.append("AND CMDT.GRP_CMDT_SEQ IN (" ).append("\n"); 
		query.append("#foreach($key IN ${txtArr}) " ).append("\n"); 
		query.append("#if($velocityCount < $txtArr.size()) " ).append("\n"); 
		query.append("'$key', " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("'$key' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}