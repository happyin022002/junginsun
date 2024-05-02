/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupLocationProposalDBDAOPriRpScpGrpLocGlineCpVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.10 최성민
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

public class RFAGroupLocationProposalDBDAOPriRpScpGrpLocGlineCpVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI SP SCP GRP LOC Guideline COPY 생성
	  * </pre>
	  */
	public RFAGroupLocationProposalDBDAOPriRpScpGrpLocGlineCpVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.integration").append("\n"); 
		query.append("FileName : RFAGroupLocationProposalDBDAOPriRpScpGrpLocGlineCpVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_GRP_LOC(" ).append("\n"); 
		query.append("PROP_NO," ).append("\n"); 
		query.append("AMDT_SEQ," ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("GRP_LOC_SEQ," ).append("\n"); 
		query.append("ORG_DEST_TP_CD," ).append("\n"); 
		query.append("PRC_GRP_LOC_CD," ).append("\n"); 
		query.append("PRC_GRP_LOC_DESC," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[prop_no]," ).append("\n"); 
		query.append("@[amdt_seq]," ).append("\n"); 
		query.append("@[svc_scp_cd]," ).append("\n"); 
		query.append("LOC.GRP_LOC_SEQ," ).append("\n"); 
		query.append("LOC.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("LOC.PRC_GRP_LOC_CD," ).append("\n"); 
		query.append("LOC.PRC_GRP_LOC_DESC," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RG_MN MN," ).append("\n"); 
		query.append("PRI_RG_GRP_LOC LOC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(MN.SVC_SCP_CD, MN.EFF_DT) = (" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD, MAX(EFF_DT)" ).append("\n"); 
		query.append("FROM    PRI_RG_MN" ).append("\n"); 
		query.append("WHERE   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     (SELECT EFF_DT FROM PRI_RP_SCP_MN WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq] AND SVC_SCP_CD = @[svc_scp_cd]) BETWEEN eff_dt AND exp_dt" ).append("\n"); 
		query.append("AND     CFM_FLG 		= 'Y'" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND MN.SVC_SCP_CD 	= LOC.SVC_SCP_CD" ).append("\n"); 
		query.append("AND MN.GLINE_SEQ  	= LOC.GLINE_SEQ" ).append("\n"); 
		query.append("AND MN.CFM_FLG 		= 'Y'" ).append("\n"); 

	}
}