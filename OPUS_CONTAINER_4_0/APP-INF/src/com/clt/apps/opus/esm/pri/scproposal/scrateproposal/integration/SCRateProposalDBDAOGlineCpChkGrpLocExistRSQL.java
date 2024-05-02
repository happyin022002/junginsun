/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateProposalDBDAOGlineCpChkGrpLocExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.03 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOGlineCpChkGrpLocExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Copy시 Group Location Code가 존재하는지 확인
	  * </pre>
	  */
	public SCRateProposalDBDAOGlineCpChkGrpLocExistRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOGlineCpChkGrpLocExistRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CNT FROM (" ).append("\n"); 
		query.append("SELECT D.ROUT_PNT_LOC_DEF_CD AS CD" ).append("\n"); 
		query.append("FROM (SELECT T.SVC_SCP_CD, T.GLINE_SEQ, RANK() OVER(PARTITION BY SVC_SCP_CD ORDER BY EFF_DT DESC) AS RNK" ).append("\n"); 
		query.append("FROM PRI_SG_MN T" ).append("\n"); 
		query.append("WHERE T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN T.EFF_DT AND T.EXP_DT" ).append("\n"); 
		query.append("AND T.CFM_FLG = 'Y') A" ).append("\n"); 
		query.append(",PRI_SG_RT_CMDT_HDR B" ).append("\n"); 
		query.append(",PRI_SG_RT_CMDT_ROUT C" ).append("\n"); 
		query.append(",PRI_SG_RT_ROUT_PNT D" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND B.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("AND B.GLINE_SEQ = C.GLINE_SEQ" ).append("\n"); 
		query.append("AND B.PRC_CUST_TP_CD = C.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND B.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND C.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND C.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND C.PRC_CUST_TP_CD = D.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND C.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND C.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("AND A.RNK = 1" ).append("\n"); 
		query.append("AND B.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN B.EFF_DT AND B.EXP_DT" ).append("\n"); 
		query.append("AND D.ROUT_PNT_LOC_TP_CD = 'G'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_LOC" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = D.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT D.ROUT_VIA_PORT_DEF_CD AS CD" ).append("\n"); 
		query.append("FROM (SELECT T.SVC_SCP_CD, T.GLINE_SEQ, RANK() OVER(PARTITION BY SVC_SCP_CD ORDER BY EFF_DT DESC) AS RNK" ).append("\n"); 
		query.append("FROM PRI_SG_MN T" ).append("\n"); 
		query.append("WHERE T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN T.EFF_DT AND T.EXP_DT" ).append("\n"); 
		query.append("AND T.CFM_FLG = 'Y') A" ).append("\n"); 
		query.append(",PRI_SG_RT_CMDT_HDR B" ).append("\n"); 
		query.append(",PRI_SG_RT_CMDT_ROUT C" ).append("\n"); 
		query.append(",PRI_SG_RT_ROUT_VIA D" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND B.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("AND B.GLINE_SEQ = C.GLINE_SEQ" ).append("\n"); 
		query.append("AND B.PRC_CUST_TP_CD = C.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND B.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND C.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND C.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND C.PRC_CUST_TP_CD = D.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND C.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND C.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("AND A.RNK = 1" ).append("\n"); 
		query.append("AND B.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN B.EFF_DT AND B.EXP_DT" ).append("\n"); 
		query.append("AND D.ROUT_VIA_PORT_TP_CD = 'G'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_LOC" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = D.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}