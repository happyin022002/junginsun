/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGRICalculationProposalDBDAORsltGriCalcCmdtListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.06.24 박성수
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

public class SCGRICalculationProposalDBDAORsltGriCalcCmdtListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Calc. Commodity 조회
	  * </pre>
	  */
	public SCGRICalculationProposalDBDAORsltGriCalcCmdtListVORSQL(){
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
		params.put("gri_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",CMDT_SEQ" ).append("\n"); 
		query.append(",PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'C'" ).append("\n"); 
		query.append(",(SELECT CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRI_CMDT A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND GRI_GRP_SEQ = @[gri_grp_seq]" ).append("\n"); 
		query.append("ORDER BY DECODE(PRC_CMDT_TP_CD, 'G', '1', 'C', '2'), PRC_CMDT_DEF_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.integration").append("\n"); 
		query.append("FileName : SCGRICalculationProposalDBDAORsltGriCalcCmdtListVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}