/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtCmdtRoutVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.06.30 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtCmdtRoutVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CMDT route 삭제
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtCmdtRoutVODSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM PRI_SP_SCP_RT_CMDT_ROUT A" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} == \"0\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == \"1\")" ).append("\n"); 
		query.append("AND	GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND	CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND	CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND	ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${IS_DEL_AMEND} == \"Y\")" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ROUT_DIR" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtCmdtRoutVODSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}