/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGlineCpVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.09.01 변영주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Byeon Young Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGlineCpVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI SP SCP GRP LOC DTL Guideline Copy 생성
	  * </pre>
	  */
	public SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGlineCpVOCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.integration").append("\n"); 
		query.append("FileName : SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGlineCpVOCSQL").append("\n"); 
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
		query.append("INSERT INTO pri_sp_scp_grp_loc_dtl(" ).append("\n"); 
		query.append("PROP_NO," ).append("\n"); 
		query.append("AMDT_SEQ," ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("GRP_LOC_SEQ," ).append("\n"); 
		query.append("GRP_LOC_DTL_SEQ," ).append("\n"); 
		query.append("LOC_CD," ).append("\n"); 
		query.append("PRC_PROG_STS_CD," ).append("\n"); 
		query.append("SRC_INFO_CD," ).append("\n"); 
		query.append("N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("ACPT_USR_ID," ).append("\n"); 
		query.append("ACPT_OFC_CD," ).append("\n"); 
		query.append("ACPT_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[prop_no]," ).append("\n"); 
		query.append("@[amdt_seq]," ).append("\n"); 
		query.append("@[svc_scp_cd]," ).append("\n"); 
		query.append("DENSE_RANK() OVER (ORDER BY loc.grp_loc_seq) grp_loc_seq," ).append("\n"); 
		query.append("DENSE_RANK() OVER (PARTITION BY loc.grp_loc_seq ORDER BY loc.grp_loc_dtl_seq) grp_loc_dtl_seq," ).append("\n"); 
		query.append("loc.loc_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("'GC'," ).append("\n"); 
		query.append("@[amdt_seq]," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("pri_sg_mn mn," ).append("\n"); 
		query.append("pri_sg_grp_loc_dtl loc" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(mn.svc_scp_cd, mn.eff_dt) = (" ).append("\n"); 
		query.append("SELECT  svc_scp_cd, MAX(eff_dt)" ).append("\n"); 
		query.append("FROM    pri_sg_mn" ).append("\n"); 
		query.append("WHERE   svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     (SELECT EFF_DT FROM PRI_SP_SCP_MN WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq] AND SVC_SCP_CD = @[svc_scp_cd]) BETWEEN eff_dt AND exp_dt" ).append("\n"); 
		query.append("AND     cfm_flg 		= 'Y'" ).append("\n"); 
		query.append("GROUP BY svc_scp_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND mn.svc_scp_cd 	= loc.svc_scp_cd" ).append("\n"); 
		query.append("AND mn.gline_seq 	= loc.gline_seq" ).append("\n"); 
		query.append("AND mn.cfm_flg 		= 'Y'" ).append("\n"); 

	}
}