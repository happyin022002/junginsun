/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtScgVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.07.31 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtScgVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Detail 삭제 ( UI_PRI_6018, UC-PRI-062 )
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtScgVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtScgVODSQL").append("\n"); 
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
		query.append("delete from pri_sp_scp_rt_scg" ).append("\n"); 
		query.append("where   prop_no = @[prop_no]" ).append("\n"); 
		query.append("and amdt_seq = @[amdt_seq]" ).append("\n"); 
		query.append("and svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} == \"0\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == \"1\")" ).append("\n"); 
		query.append("and gen_spcl_rt_tp_cd = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("and cmdt_hdr_seq = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == \"2\")" ).append("\n"); 
		query.append("and gen_spcl_rt_tp_cd = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("and cmdt_hdr_seq = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("and rout_seq = @[rout_seq]" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == \"3\")" ).append("\n"); 
		query.append("and gen_spcl_rt_tp_cd = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("and cmdt_hdr_seq = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("and rout_seq = @[rout_seq]" ).append("\n"); 
		query.append("and rt_seq = @[rt_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and gen_spcl_rt_tp_cd = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("and cmdt_hdr_seq = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("and rout_seq = @[rout_seq]" ).append("\n"); 
		query.append("and rt_seq = @[rt_seq]" ).append("\n"); 
		query.append("and chg_cd = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}