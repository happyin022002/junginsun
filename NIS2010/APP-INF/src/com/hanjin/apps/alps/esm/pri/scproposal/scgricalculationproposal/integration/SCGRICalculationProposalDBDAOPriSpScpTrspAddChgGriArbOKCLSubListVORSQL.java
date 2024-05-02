/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLSubListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.30
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.30 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLSubListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SP_SCP_TRSP_ADD_CHG테이블에 GRI ARB OK/Cancle 조건리스트-Sub
	  * </pre>
	  */
	public SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLSubListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.integration").append("\n"); 
		query.append("FileName : SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLSubListVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("PROP_NO -- param" ).append("\n"); 
		query.append(",AMDT_SEQ -- param" ).append("\n"); 
		query.append(",SVC_SCP_CD -- param" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD -- param" ).append("\n"); 
		query.append(",GRI_GRP_SEQ -- param" ).append("\n"); 
		query.append(",GRI_ADJ_SEQ -- key" ).append("\n"); 
		query.append(",RAT_UT_CD -- per" ).append("\n"); 
		query.append(",PRC_CGO_TP_CD -- cargo type" ).append("\n"); 
		query.append(",CURR_CD -- currency" ).append("\n"); 
		query.append(",GRI_RT_AMT -- amount" ).append("\n"); 
		query.append(",GRI_RT_RTO -- percentage" ).append("\n"); 
		query.append(", '' AS FLT_PCT_TP_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_ARB_GRI_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND	GRI_GRP_SEQ = @[gri_grp_seq]" ).append("\n"); 

	}
}