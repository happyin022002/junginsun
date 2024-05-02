/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGrpAmdVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.09.01 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Byeon Young Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGrpAmdVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGrpAmdVOUSQL
	  * </pre>
	  */
	public SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGrpAmdVOUSQL(){
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
		params.put("grp_loc_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.integration").append("\n"); 
		query.append("FileName : SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGrpAmdVOUSQL").append("\n"); 
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
		query.append("UPDATE pri_sp_scp_grp_loc_dtl dtl SET" ).append("\n"); 
		query.append("prc_prog_sts_cd = 'I'," ).append("\n"); 
		query.append("src_info_cd     = 'AD'," ).append("\n"); 
		query.append("n1st_cmnc_amdt_seq = @[amdt_seq]," ).append("\n"); 
		query.append("upd_usr_id      = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt          = sysdate" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("prop_no         = @[prop_no]" ).append("\n"); 
		query.append("AND amdt_seq 	   = @[amdt_seq]" ).append("\n"); 
		query.append("AND svc_scp_cd 	   = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND grp_loc_seq     = @[grp_loc_seq]" ).append("\n"); 

	}
}