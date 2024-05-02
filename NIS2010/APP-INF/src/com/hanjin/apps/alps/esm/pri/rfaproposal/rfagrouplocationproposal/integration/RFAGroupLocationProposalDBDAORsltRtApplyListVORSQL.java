/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupLocationProposalDBDAORsltRtApplyListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.11 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupLocationProposalDBDAORsltRtApplyListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAGroupLocationProposalDBDAORsltRtApplyListVORSQL
	  * </pre>
	  */
	public RFAGroupLocationProposalDBDAORsltRtApplyListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.integration").append("\n"); 
		query.append("FileName : RFAGroupLocationProposalDBDAORsltRtApplyListVORSQL").append("\n"); 
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
		query.append("SRC.CD PRC_GRP_LOC_DESC," ).append("\n"); 
		query.append("SRC.LOC_CD PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RP_SCP_GRP_LOC LOC," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'RATE' CD, ROUT_PNT_LOC_DEF_CD LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ 			= @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD 			= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ROUT_PNT_LOC_TP_CD 	= 'G'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'RATE' CD, ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RP_SCP_RT_ROUT_VIA LOC_CD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ 			= @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD 			= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ROUT_VIA_PORT_TP_CD = 'G'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'RATE-GRI' CD, ROUT_PNT_LOC_DEF_CD LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RP_SCP_GRI_ROUT_PNT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ 			= @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD 			= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ROUT_PNT_LOC_TP_CD 	= 'G'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'RATE-GRI' CD, ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RP_SCP_GRI_ROUT_VIA LOC_CD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ 			= @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD 			= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ROUT_VIA_PORT_TP_CD = 'G'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'ARBITRARY' CD, BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RP_SCP_TRSP_ADD_CHG LOC_CD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ 			= @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD 			= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND BSE_PORT_TP_CD = 'G'" ).append("\n"); 
		query.append("AND ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'IHC' CD, BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RP_SCP_TRSP_ADD_CHG LOC_CD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ 			= @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD 			= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND BSE_PORT_TP_CD = 'G'" ).append("\n"); 
		query.append("AND ADD_CHG_TP_CD = 'I'" ).append("\n"); 
		query.append(") SRC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("LOC.PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("AND LOC.AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("AND LOC.SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND LOC.PRC_GRP_LOC_CD 	= SRC.LOC_CD" ).append("\n"); 
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
		query.append("SRC.CD," ).append("\n"); 
		query.append("SRC.LOC_CD" ).append("\n"); 

	}
}