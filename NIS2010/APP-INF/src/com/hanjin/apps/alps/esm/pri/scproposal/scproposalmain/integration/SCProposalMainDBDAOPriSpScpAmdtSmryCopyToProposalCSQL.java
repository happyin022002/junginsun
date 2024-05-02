/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpScpAmdtSmryCopyToProposalCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.01.07 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpScpAmdtSmryCopyToProposalCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriSpScpAmdtSmryCopyToProposal
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpScpAmdtSmryCopyToProposalCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rate_g_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_grp_loc_cnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frm_rate_s_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_grp_cmdt_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpScpAmdtSmryCopyToProposalCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_AMDT_SMRY(" ).append("\n"); 
		query.append("PROP_NO," ).append("\n"); 
		query.append("AMDT_SEQ," ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("PROP_SCP_TERM_TP_CD," ).append("\n"); 
		query.append("AMDT_FLG," ).append("\n"); 
		query.append("ACPT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[new_prop_no]      ," ).append("\n"); 
		query.append("0         ," ).append("\n"); 
		query.append("B.SVC_SCP_CD       ," ).append("\n"); 
		query.append("A.INTG_CD_VAL_CTNT    ," ).append("\n"); 
		query.append("(CASE WHEN INTG_CD_VAL_CTNT = '11' THEN 'Y'" ).append("\n"); 
		query.append("WHEN INTG_CD_VAL_CTNT = '12' THEN 'Y'" ).append("\n"); 
		query.append("WHEN INTG_CD_VAL_CTNT = '13' THEN DECODE(@[frm_grp_loc_cnt],'Y','Y','N')" ).append("\n"); 
		query.append("WHEN INTG_CD_VAL_CTNT = '14' THEN DECODE(@[frm_grp_cmdt_cnt],'Y','Y','N')" ).append("\n"); 
		query.append("WHEN INTG_CD_VAL_CTNT = '71' THEN DECODE(@[frm_rate_g_cnt],'Y','Y','N')" ).append("\n"); 
		query.append("WHEN INTG_CD_VAL_CTNT = '72' THEN DECODE(@[frm_rate_s_cnt],'Y','Y','N')" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END)                 ," ).append("\n"); 
		query.append("'N'                 ," ).append("\n"); 
		query.append("@[cre_usr_id]       ," ).append("\n"); 
		query.append("SYSDATE             ," ).append("\n"); 
		query.append("@[upd_usr_id]       ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("COM_INTG_CD_DTL A" ).append("\n"); 
		query.append(",   PRI_SQ_MN B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("INTG_CD_ID = 'CD01738'" ).append("\n"); 
		query.append("AND   B.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND   B.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 

	}
}