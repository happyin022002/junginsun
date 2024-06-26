/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtGlineCpChkGrpLocExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.05.22 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtGlineCpChkGrpLocExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate에서 Guideline Copy시 Guideline에서 사용하는 Group Location이 현재의 Proposal쪽에 존재하는지 점검
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtGlineCpChkGrpLocExistRSQL(){
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
		query.append("FROM (SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append(",A.EFF_DT" ).append("\n"); 
		query.append(",A.EXP_DT" ).append("\n"); 
		query.append(",B.ROUT_PNT_LOC_DEF_CD AS LOC_CD" ).append("\n"); 
		query.append("FROM PRI_SG_MN A, PRI_SG_RT_ROUT_PNT B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("AND A.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.ROUT_PNT_LOC_TP_CD = 'G'" ).append("\n"); 
		query.append("AND B.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append(",A.EFF_DT" ).append("\n"); 
		query.append(",A.EXP_DT" ).append("\n"); 
		query.append(",B.ROUT_VIA_PORT_DEF_CD AS LOC_CD" ).append("\n"); 
		query.append("FROM PRI_SG_MN A, PRI_SG_RT_ROUT_VIA B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("AND A.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.ROUT_VIA_PORT_TP_CD = 'G'" ).append("\n"); 
		query.append("AND B.PRC_CUST_TP_CD = @[prc_cust_tp_cd]) T" ).append("\n"); 
		query.append("WHERE NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_MN SA, PRI_SP_SCP_GRP_LOC SB" ).append("\n"); 
		query.append("WHERE SA.PROP_NO = SB.PROP_NO" ).append("\n"); 
		query.append("AND SA.AMDT_SEQ = SB.AMDT_SEQ" ).append("\n"); 
		query.append("AND SA.SVC_SCP_CD = SB.SVC_SCP_CD" ).append("\n"); 
		query.append("AND SA.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND SA.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SA.SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("AND SA.EFF_DT BETWEEN T.EFF_DT AND T.EXP_DT" ).append("\n"); 
		query.append("AND SB.PRC_GRP_LOC_CD = T.LOC_CD)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtGlineCpChkGrpLocExistRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}