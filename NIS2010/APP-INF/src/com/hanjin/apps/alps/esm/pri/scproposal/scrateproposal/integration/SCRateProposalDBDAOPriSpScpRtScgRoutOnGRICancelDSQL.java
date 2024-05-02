/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtScgRoutOnGRICancelDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2010.01.13 박성수
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

public class SCRateProposalDBDAOPriSpScpRtScgRoutOnGRICancelDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Cancel시 SCG_ROUT 테이블 삭제
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtScgRoutOnGRICancelDSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtScgRoutOnGRICancelDSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_SP_SCP_RT_SCG_ROUT T" ).append("\n"); 
		query.append("WHERE EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT A" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND A.GRI_APPL_TP_CD = 'A'" ).append("\n"); 
		query.append("AND A.PROP_NO = T.PROP_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = T.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = T.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = T.ROUT_SEQ" ).append("\n"); 
		query.append("AND A.RT_SEQ = T.RT_SEQ)" ).append("\n"); 

	}
}