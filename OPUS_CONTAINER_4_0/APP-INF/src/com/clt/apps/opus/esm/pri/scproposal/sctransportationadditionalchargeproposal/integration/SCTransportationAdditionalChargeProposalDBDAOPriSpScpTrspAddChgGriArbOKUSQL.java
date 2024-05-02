/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbOKUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2016.01.08 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbOKUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * gri cal 적용
	  * </pre>
	  */
	public SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbOKUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gri_appl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("add_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbOKUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_TRSP_ADD_CHG SET" ).append("\n"); 
		query.append("       GRI_APPL_TP_CD = 'A' -- Auto" ).append("\n"); 
		query.append("      ,GRI_APPL_AMT = TO_NUMBER(@[gri_appl_amt])" ).append("\n"); 
		query.append("      ,PROP_FRT_RT_AMT  = DECODE(@[amdt_seq], '0', PROP_FRT_RT_AMT + TO_NUMBER(@[gri_appl_amt]), FNL_FRT_RT_AMT + TO_NUMBER(@[gri_appl_amt])) -- 중복적용으로 바뀜 , 중복적용전 쿼리는 js에" ).append("\n"); 
		query.append("	  ,COFFR_FRT_RT_AMT = DECODE(@[amdt_seq], '0', COFFR_FRT_RT_AMT, NULL)" ).append("\n"); 
		query.append("      ,FNL_FRT_RT_AMT   = DECODE(@[amdt_seq], '0', FNL_FRT_RT_AMT  , NULL)" ).append("\n"); 
		query.append("      ,PRC_PROG_STS_CD = 'I' -- Initial" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if (${amdt_seq} == '0')" ).append("\n"); 
		query.append("      ,SRC_INFO_CD = DECODE(SRC_INFO_CD, 'PC', 'PM', 'GC', 'GM', SRC_INFO_CD)" ).append("\n"); 
		query.append("      #else -- amd 시" ).append("\n"); 
		query.append("      ,SRC_INFO_CD = 'AM'" ).append("\n"); 
		query.append("	  ,N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND ADD_CHG_SEQ = @[add_chg_seq]" ).append("\n"); 

	}
}