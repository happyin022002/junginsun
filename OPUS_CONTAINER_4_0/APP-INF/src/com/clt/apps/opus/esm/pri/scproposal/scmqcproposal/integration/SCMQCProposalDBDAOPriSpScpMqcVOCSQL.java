/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCMQCProposalDBDAOPriSpScpMqcVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.02 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCMQCProposalDBDAOPriSpScpMqcVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCMQCProposalDBDAOPriSpScpMqcVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_info_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lod_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_scp_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coffr_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.integration").append("\n"); 
		query.append("FileName : SCMQCProposalDBDAOPriSpScpMqcVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_MQC (" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(",    AMDT_SEQ" ).append("\n"); 
		query.append(",    SVC_SCP_CD" ).append("\n"); 
		query.append(",    CNTR_LOD_UT_CD" ).append("\n"); 
		query.append(",    PROP_SCP_MQC_QTY" ).append("\n"); 
		query.append(",    COFFR_MQC_QTY" ).append("\n"); 
		query.append(",    FNL_MQC_QTY" ).append("\n"); 
		query.append(",    PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",    SRC_INFO_CD" ).append("\n"); 
		query.append(",    N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",    ACPT_USR_ID" ).append("\n"); 
		query.append(",    ACPT_OFC_CD" ).append("\n"); 
		query.append(",    ACPT_DT" ).append("\n"); 
		query.append(",    CRE_USR_ID" ).append("\n"); 
		query.append(",    CRE_DT" ).append("\n"); 
		query.append(",    UPD_USR_ID" ).append("\n"); 
		query.append(",    UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[prop_no]" ).append("\n"); 
		query.append(",    @[amdt_seq]" ).append("\n"); 
		query.append(",    @[svc_scp_cd]" ).append("\n"); 
		query.append(",    @[cntr_lod_ut_cd]" ).append("\n"); 
		query.append(",   NVL(@[prop_scp_mqc_qty],0)" ).append("\n"); 
		query.append(",   NVL(@[coffr_mqc_qty],0)" ).append("\n"); 
		query.append(",   NVL(@[fnl_mqc_qty],0)" ).append("\n"); 
		query.append(",    @[prc_prog_sts_cd]" ).append("\n"); 
		query.append(",    @[src_info_cd]" ).append("\n"); 
		query.append(",    @[amdt_seq]" ).append("\n"); 
		query.append(",    @[acpt_usr_id]" ).append("\n"); 
		query.append(",    @[acpt_ofc_cd]" ).append("\n"); 
		query.append(",    TO_DATE(@[acpt_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append(",    @[upd_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}