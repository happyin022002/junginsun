/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.11 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtVODSQL(){
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
		params.put("grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtVODSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_RP_SCP_GRP_CMDT CMDT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO      = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ     = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GRP_CMDT_SEQ = @[grp_cmdt_seq]" ).append("\n"); 
		query.append("AND NOT EXISTS" ).append("\n"); 
		query.append("(    SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_CMDT_DTL" ).append("\n"); 
		query.append("WHERE PROP_NO 			= CMDT.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ 		= CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD 		= CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GRP_CMDT_SEQ 	= CMDT.GRP_CMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}