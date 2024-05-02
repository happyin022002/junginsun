/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TAAProposalDBDAOPriTaaMnAmendCSQL.java
*@FileTitle : TAA Creation & Amendment [Amend]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.01 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOPriTaaMnAmendCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TAA Main Amendment
	  * </pre>
	  */
	public TAAProposalDBDAOPriTaaMnAmendCSQL(){
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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOPriTaaMnAmendCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TAA_MN (" ).append("\n"); 
		query.append("TAA_PROP_NO" ).append("\n"); 
		query.append(", AMDT_SEQ" ).append("\n"); 
		query.append(", SVC_SCP_CD" ).append("\n"); 
		query.append(", EFF_DT" ).append("\n"); 
		query.append(", EXP_DT" ).append("\n"); 
		query.append(", CTRT_CUST_SEQ" ).append("\n"); 
		query.append(", CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append(", PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append(", CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append(", RESPB_SREP_CD" ).append("\n"); 
		query.append(", RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append(", CFM_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TA.TAA_PROP_NO" ).append("\n"); 
		query.append(", @[amdt_seq] AS AMDT_SEQ" ).append("\n"); 
		query.append(", TA.SVC_SCP_CD" ).append("\n"); 
		query.append(", TO_DATE(@[eff_dt],'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(", TO_DATE(@[exp_dt],'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append(", TA.CTRT_CUST_SEQ" ).append("\n"); 
		query.append(", TA.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append(", TA.PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append(", TA.CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append(", TA.RESPB_SREP_CD" ).append("\n"); 
		query.append(", TA.RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append(", 'N' AS CFM_FLG" ).append("\n"); 
		query.append(", @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM PRI_TAA_HDR TD" ).append("\n"); 
		query.append(", PRI_TAA_MN TA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   TD.TAA_NO = @[taa_no]" ).append("\n"); 
		query.append("AND   TA.TAA_PROP_NO = TD.TAA_PROP_NO" ).append("\n"); 
		query.append("AND   TA.AMDT_SEQ = @[old_amdt_seq]" ).append("\n"); 

	}
}