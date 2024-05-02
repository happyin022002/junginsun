/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtGRICancelVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.09 박성수
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

public class SCRateProposalDBDAOPriSpScpRtGRICancelVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Cancel
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtGRICancelVOUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtGRICancelVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_RT A" ).append("\n"); 
		query.append("SET A.PROP_FRT_RT_AMT        = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.PROP_FRT_RT_AMT - A.GRI_APPL_AMT)" ).append("\n"); 
		query.append(",A.COFFR_FRT_RT_AMT       = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.COFFR_FRT_RT_AMT)" ).append("\n"); 
		query.append(",A.FNL_FRT_RT_AMT         = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.FNL_FRT_RT_AMT)" ).append("\n"); 
		query.append(",A.PRS_SCG_AMT            = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT PRS_SCG_AMT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.PRS_SCG_AMT)" ).append("\n"); 
		query.append(",A.PRS_RESPB_CM_UC_AMT    = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.PRS_RESPB_CM_UC_AMT)" ).append("\n"); 
		query.append(",A.PRS_PFIT_CM_UC_AMT     = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.PRS_PFIT_CM_UC_AMT)" ).append("\n"); 
		query.append(",A.PRS_RESPB_OPFIT_UC_AMT = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.PRS_RESPB_OPFIT_UC_AMT)" ).append("\n"); 
		query.append(",A.PRS_RESPB_CMPB_AMT     = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.PROP_FRT_RT_AMT - A.GRI_APPL_AMT + A.PRS_SCG_AMT - A.PRS_RESPB_CM_UC_AMT)" ).append("\n"); 
		query.append(",A.PRS_PFIT_CMPB_AMT      = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.PROP_FRT_RT_AMT - A.GRI_APPL_AMT + A.PRS_SCG_AMT - A.PRS_PFIT_CM_UC_AMT)" ).append("\n"); 
		query.append(",A.PRS_RESPB_OPB_AMT      = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.PROP_FRT_RT_AMT - A.GRI_APPL_AMT + A.PRS_SCG_AMT - A.PRS_RESPB_OPFIT_UC_AMT)" ).append("\n"); 
		query.append(",A.PRS_GID_CMPB_AMT       = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.PRS_GID_CMPB_AMT)" ).append("\n"); 
		query.append(",A.PRS_UPD_DT             = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT PRS_UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.PRS_UPD_DT)" ).append("\n"); 
		query.append(",A.GRI_APPL_TP_CD         = 'N'" ).append("\n"); 
		query.append(",A.GRI_APPL_AMT           = 0" ).append("\n"); 
		query.append(",A.PRC_PROG_STS_CD        = DECODE(A.SRC_INFO_CD, 'AM', 'A', 'I')" ).append("\n"); 
		query.append(",A.SRC_INFO_CD            = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT SRC_INFO_CD" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.SRC_INFO_CD)" ).append("\n"); 
		query.append(",A.N1ST_CMNC_AMDT_SEQ     = DECODE(A.SRC_INFO_CD" ).append("\n"); 
		query.append(",'AM'" ).append("\n"); 
		query.append(",(SELECT N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT_SEQ = A.RT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",A.N1ST_CMNC_AMDT_SEQ)" ).append("\n"); 
		query.append(",A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND A.GRI_APPL_TP_CD = 'A'" ).append("\n"); 

	}
}