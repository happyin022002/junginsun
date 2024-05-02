/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAGroupCommodityProposalDBDAORsltGrpCmdtInquiryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupCommodityProposalDBDAORsltGrpCmdtInquiryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry 조회
	  * </pre>
	  */
	public RFAGroupCommodityProposalDBDAORsltGrpCmdtInquiryListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.integration").append("\n"); 
		query.append("FileName : RFAGroupCommodityProposalDBDAORsltGrpCmdtInquiryListVORSQL").append("\n"); 
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
		query.append("SELECT CMDT.PROP_NO" ).append("\n"); 
		query.append("	 , CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("	 , CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("	 , CMDT.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("	 , CMDT.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("	 , CMDT.PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_GRP_CMDT CMDT" ).append("\n"); 
		query.append(" WHERE CMDT.PROP_NO		= @[prop_no]" ).append("\n"); 
		query.append("   AND CMDT.AMDT_SEQ	= @[amdt_seq]" ).append("\n"); 
		query.append("   AND CMDT.SVC_SCP_CD	= @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND EXISTS ( SELECT 'X' FROM PRI_RP_SCP_GRP_CMDT_DTL" ).append("\n"); 
		query.append("                 WHERE PROP_NO 		= CMDT.PROP_NO " ).append("\n"); 
		query.append("                   AND AMDT_SEQ 	= CMDT.AMDT_SEQ  " ).append("\n"); 
		query.append("                   AND SVC_SCP_CD 	= CMDT.SVC_SCP_CD  " ).append("\n"); 
		query.append("                   AND GRP_CMDT_SEQ = CMDT.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD' )" ).append("\n"); 
		query.append(" ORDER BY CMDT.PRC_GRP_CMDT_CD" ).append("\n"); 

	}
}