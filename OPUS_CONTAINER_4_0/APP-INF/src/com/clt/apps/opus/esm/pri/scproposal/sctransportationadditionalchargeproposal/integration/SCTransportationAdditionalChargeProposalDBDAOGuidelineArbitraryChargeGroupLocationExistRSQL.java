/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAOGuidelineArbitraryChargeGroupLocationExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.15 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCTransportationAdditionalChargeProposalDBDAOGuidelineArbitraryChargeGroupLocationExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Arbitrary Guideline Copy 대상의 Group Location이 모두 등록되어 있는지 조회한다
	  * </pre>
	  */
	public SCTransportationAdditionalChargeProposalDBDAOGuidelineArbitraryChargeGroupLocationExistRSQL(){
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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration ").append("\n"); 
		query.append("FileName : SCTransportationAdditionalChargeProposalDBDAOGuidelineArbitraryChargeGroupLocationExistRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BSE_PORT_DEF_CD, PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_LOC A" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM PRI_SG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND BSE_PORT_TP_CD = 'G'" ).append("\n"); 
		query.append("AND GLINE_SEQ = (SELECT MAX(GLINE_SEQ)" ).append("\n"); 
		query.append("FROM PRI_SG_MN" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[eff_dt],'-',''), 'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT)" ).append("\n"); 
		query.append("GROUP BY BSE_PORT_DEF_CD" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.PROP_NO(+) = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ(+) = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD(+) = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.PRC_GRP_LOC_CD(+) = B.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE PRC_GRP_LOC_CD IS NULL" ).append("\n"); 

	}
}