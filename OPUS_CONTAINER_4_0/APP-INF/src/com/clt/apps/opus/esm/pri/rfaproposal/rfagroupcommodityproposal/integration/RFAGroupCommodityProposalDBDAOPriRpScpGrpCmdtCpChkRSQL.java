/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtCpChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.10 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtCpChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * g/l copy data 존재하는지 확인
	  * </pre>
	  */
	public RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtCpChkRSQL(){
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
		query.append("FileName : RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtCpChkRSQL").append("\n"); 
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
		query.append("WITH SUB_PRI_RG_MN AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append(", EFF_DT" ).append("\n"); 
		query.append(", EXP_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append(", EFF_DT" ).append("\n"); 
		query.append(", EXP_DT" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY EFF_DT DESC) CHECK_VALUE" ).append("\n"); 
		query.append("FROM PRI_RG_MN" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD	= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CFM_FLG 		= 'Y'" ).append("\n"); 
		query.append("AND (SELECT EFF_DT FROM PRI_RP_SCP_MN WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq] AND SVC_SCP_CD = @[svc_scp_cd]) BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CHECK_VALUE = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  A.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("FROM    PRI_RG_GRP_CMDT A," ).append("\n"); 
		query.append("SUB_PRI_RG_MN B" ).append("\n"); 
		query.append("WHERE   A.SVC_SCP_CD		= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A.SVC_SCP_CD 		= B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A.GLINE_SEQ  		= B.GLINE_SEQ" ).append("\n"); 

	}
}