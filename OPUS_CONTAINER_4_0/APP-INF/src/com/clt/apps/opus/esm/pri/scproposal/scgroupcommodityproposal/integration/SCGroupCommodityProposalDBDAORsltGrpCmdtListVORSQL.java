/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCGroupCommodityProposalDBDAORsltGrpCmdtListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2016.06.27 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYEONGMI KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupCommodityProposalDBDAORsltGrpCmdtListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCGroupCommodityProposalDBDAORsltGrpCmdtListVORSQL
	  * </pre>
	  */
	public SCGroupCommodityProposalDBDAORsltGrpCmdtListVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityProposalDBDAORsltGrpCmdtListVORSQL").append("\n"); 
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
		query.append("    CMDT.PROP_NO" ).append("\n"); 
		query.append("    ,CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("    ,CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("    ,CMDT.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("    ,CMDT.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("    ,CMDT.PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("    ,(SELECT PRC_GRP_CMDT_DESC FROM PRI_SP_SCP_GRP_CMDT SUB" ).append("\n"); 
		query.append("       WHERE CMDT.PROP_NO = SUB.PROP_NO" ).append("\n"); 
		query.append("         AND CMDT.AMDT_SEQ-1 = SUB.AMDT_SEQ" ).append("\n"); 
		query.append("         AND CMDT.SVC_SCP_CD = SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("         AND CMDT.GRP_CMDT_SEQ = SUB.GRP_CMDT_SEQ) PRC_GRP_CMDT_DESC_ORI" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        CASE WHEN SUM( CASE WHEN SRC_INFO_CD = 'AD' THEN 0 ELSE 1 END ) = 0 THEN 'AD'" ).append("\n"); 
		query.append("        WHEN SUM( CASE WHEN CMDT.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ = MN.AMDT_SEQ  AND SRC_INFO_CD IN( 'NW','GC','GM','PC','PM')" ).append("\n"); 
		query.append("        THEN 0 ELSE 1 END ) = 0 THEN 'NW'" ).append("\n"); 
		query.append("        WHEN SUM( CASE WHEN CMDT.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ = MN.AMDT_SEQ  " ).append("\n"); 
		query.append("        THEN 1 ELSE 0 END ) > 0 THEN 'AM'" ).append("\n"); 
		query.append("        ELSE 'IN' END SRC_INFO_CD" ).append("\n"); 
		query.append("        FROM PRI_SP_SCP_GRP_CMDT_DTL" ).append("\n"); 
		query.append("        WHERE PROP_NO = CMDT.PROP_NO" ).append("\n"); 
		query.append("        AND AMDT_SEQ = CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND SVC_SCP_CD = CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND GRP_CMDT_SEQ= CMDT.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("    ) SRC_INFO_CD," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        CASE WHEN SUM( CASE WHEN PRC_PROG_STS_CD != 'A' THEN 1 ELSE 0 END ) = 0 THEN 'A'" ).append("\n"); 
		query.append("        ELSE 'I' END PRI_SP_SCP_GRP_CMDT_DTL" ).append("\n"); 
		query.append("        FROM    PRI_SP_SCP_GRP_CMDT_DTL DTL" ).append("\n"); 
		query.append("        WHERE   PROP_NO         = CMDT.PROP_NO" ).append("\n"); 
		query.append("        AND     AMDT_SEQ        = CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SVC_SCP_CD      = CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     GRP_CMDT_SEQ     = CMDT.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("        AND     N1ST_CMNC_AMDT_SEQ    = MN.AMDT_SEQ" ).append("\n"); 
		query.append("    ) PRC_PROG_STS_CD," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        MAX(N1ST_CMNC_AMDT_SEQ)" ).append("\n"); 
		query.append("        FROM    PRI_SP_SCP_GRP_CMDT_DTL DTL" ).append("\n"); 
		query.append("        WHERE   PROP_NO         = CMDT.PROP_NO" ).append("\n"); 
		query.append("        AND     AMDT_SEQ        = CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SVC_SCP_CD      = CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     GRP_CMDT_SEQ     = CMDT.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("    ) N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    PRI_SP_SCP_GRP_CMDT CMDT," ).append("\n"); 
		query.append("    PRI_SP_SCP_MN  MN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CMDT.PROP_NO        = @[prop_no]" ).append("\n"); 
		query.append("AND CMDT.AMDT_SEQ       = @[amdt_seq]" ).append("\n"); 
		query.append("AND CMDT.SVC_SCP_CD     = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CMDT.PROP_NO 	= MN.PROP_NO" ).append("\n"); 
		query.append("AND CMDT.AMDT_SEQ 	= MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND CMDT.SVC_SCP_CD 	= MN.SVC_SCP_CD" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'X' FROM PRI_SP_SCP_GRP_CMDT_DTL " ).append("\n"); 
		query.append("             WHERE PROP_NO = CMDT.PROP_NO AND AMDT_SEQ = CMDT.AMDT_SEQ AND SVC_SCP_CD = CMDT.SVC_SCP_CD AND GRP_CMDT_SEQ = CMDT.GRP_CMDT_SEQ " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("ORDER BY CMDT.PRC_GRP_CMDT_CD" ).append("\n"); 

	}
}