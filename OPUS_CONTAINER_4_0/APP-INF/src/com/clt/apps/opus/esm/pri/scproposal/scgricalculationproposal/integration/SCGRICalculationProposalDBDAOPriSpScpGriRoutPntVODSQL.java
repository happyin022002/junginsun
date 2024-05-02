/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGRICalculationProposalDBDAOPriSpScpGriRoutPntVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.06.23 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGRICalculationProposalDBDAOPriSpScpGriRoutPntVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriSpScpGriRoutPntVO Delete
	  * </pre>
	  */
	public SCGRICalculationProposalDBDAOPriSpScpGriRoutPntVODSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gri_rout_pnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gri_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("DELETE FROM PRI_SP_SCP_GRI_ROUT_PNT" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} == \"1\")" ).append("\n"); 
		query.append("AND	GRI_GRP_SEQ = @[gri_grp_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	GRI_GRP_SEQ = @[gri_grp_seq]" ).append("\n"); 
		query.append("AND	ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND	GRI_ROUT_PNT_SEQ = @[gri_rout_pnt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.integration").append("\n"); 
		query.append("FileName : SCGRICalculationProposalDBDAOPriSpScpGriRoutPntVODSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}