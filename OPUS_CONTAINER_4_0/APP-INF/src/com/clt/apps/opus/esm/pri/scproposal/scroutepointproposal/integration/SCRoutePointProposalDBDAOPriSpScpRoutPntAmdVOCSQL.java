/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRoutePointProposalDBDAOPriSpScpRoutPntAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.02 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRoutePointProposalDBDAOPriSpScpRoutPntAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCRoutePointProposalDBDAOPriSpScpRoutPntAmdVOCSQL
	  * </pre>
	  */
	public SCRoutePointProposalDBDAOPriSpScpRoutPntAmdVOCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.integration").append("\n"); 
		query.append("FileName : SCRoutePointProposalDBDAOPriSpScpRoutPntAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO pri_sp_scp_rout_pnt(" ).append("\n"); 
		query.append("PROP_NO," ).append("\n"); 
		query.append("AMDT_SEQ," ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("ORG_DEST_TP_CD," ).append("\n"); 
		query.append("ROUT_PNT_SEQ," ).append("\n"); 
		query.append("ROUT_PNT_LOC_TP_CD," ).append("\n"); 
		query.append("ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("PRC_PROG_STS_CD," ).append("\n"); 
		query.append("SRC_INFO_CD," ).append("\n"); 
		query.append("ACPT_USR_ID," ).append("\n"); 
		query.append("ACPT_OFC_CD," ).append("\n"); 
		query.append("ACPT_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("prop_no                 ," ).append("\n"); 
		query.append("amdt_seq+1              ," ).append("\n"); 
		query.append("svc_scp_cd              ," ).append("\n"); 
		query.append("org_dest_tp_cd          ," ).append("\n"); 
		query.append("rout_pnt_seq            ," ).append("\n"); 
		query.append("rout_pnt_loc_tp_cd      ," ).append("\n"); 
		query.append("rout_pnt_loc_def_cd     ," ).append("\n"); 
		query.append("prc_prog_sts_cd         ," ).append("\n"); 
		query.append("src_info_cd             ," ).append("\n"); 
		query.append("ACPT_USR_ID," ).append("\n"); 
		query.append("ACPT_OFC_CD," ).append("\n"); 
		query.append("ACPT_DT," ).append("\n"); 
		query.append("@[cre_usr_id]           ," ).append("\n"); 
		query.append("SYSDATE                 ," ).append("\n"); 
		query.append("@[upd_usr_id]           ," ).append("\n"); 
		query.append("SYSDATE			," ).append("\n"); 
		query.append("N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("pri_sp_scp_rout_pnt" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("prop_no     = @[prop_no]" ).append("\n"); 
		query.append("AND amdt_seq    = @[amdt_seq]" ).append("\n"); 
		query.append("AND src_info_cd <> 'AD'" ).append("\n"); 

	}
}