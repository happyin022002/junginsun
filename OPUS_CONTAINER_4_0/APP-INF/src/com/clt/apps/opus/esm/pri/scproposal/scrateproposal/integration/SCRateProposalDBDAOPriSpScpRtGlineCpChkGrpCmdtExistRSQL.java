/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtGlineCpChkGrpCmdtExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.05.22 박성수
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

public class SCRateProposalDBDAOPriSpScpRtGlineCpChkGrpCmdtExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate에서 Guideline을 Copy하기 전에 현재 Proposal에 Guideline Rate에서 사용하고 있는 Group Commodity가 있는지 확인한다
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtGlineCpChkGrpCmdtExistRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT COUNT(*) AS NOT_EXIST_CNT" ).append("\n"); 
		query.append("FROM PRI_SG_MN A, PRI_SG_RT_CMDT_HDR B, PRI_SG_RT_CMDT C" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND B.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("AND B.GLINE_SEQ = C.GLINE_SEQ" ).append("\n"); 
		query.append("AND B.PRC_CUST_TP_CD = C.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND B.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("AND A.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN B.EFF_DT AND B.EXP_DT" ).append("\n"); 
		query.append("AND C.PRC_CMDT_TP_CD = 'G'" ).append("\n"); 
		query.append("AND NOT EXISTS" ).append("\n"); 
		query.append("(SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_MN SA, PRI_SP_SCP_GRP_CMDT SB" ).append("\n"); 
		query.append("WHERE SA.PROP_NO = SB.PROP_NO" ).append("\n"); 
		query.append("AND SA.AMDT_SEQ = SB.AMDT_SEQ" ).append("\n"); 
		query.append("AND SA.SVC_SCP_CD = SB.SVC_SCP_CD" ).append("\n"); 
		query.append("AND SA.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND SA.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SA.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND SA.EFF_DT BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("AND SA.EFF_DT BETWEEN B.EFF_DT AND B.EXP_DT" ).append("\n"); 
		query.append("AND SB.PRC_GRP_CMDT_CD = C.PRC_CMDT_DEF_CD)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtGlineCpChkGrpCmdtExistRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}