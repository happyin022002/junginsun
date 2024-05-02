/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriRtVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.21
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2010.12.21 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriRtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_TRI_RT 테이블 INSERT
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriRtVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coffr_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_mapg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tri_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriRtVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRI_RT (" ).append("\n"); 
		query.append("	GRI_APPL_TP_CD" ).append("\n"); 
		query.append(",	GRI_APPL_AMT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	EXP_DT" ).append("\n"); 
		query.append(",	TRI_RQST_OFC_CD" ).append("\n"); 
		query.append(",	TRI_RQST_USR_ID" ).append("\n"); 
		query.append(",	TRI_APRO_OFC_CD" ).append("\n"); 
		query.append(",	TRI_APRO_USR_ID" ).append("\n"); 
		query.append(",	PROP_STS_CD" ).append("\n"); 
		query.append(",	RAT_UT_CD" ).append("\n"); 
		query.append(",	PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	PROP_FRT_RT_AMT" ).append("\n"); 
		query.append(",	COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append(",	FNL_FRT_RT_AMT" ).append("\n"); 
		query.append(",	NOTE_CTNT" ).append("\n"); 
		query.append(",	NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(",	TRI_PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",   TRI_RMK" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	'N'" ).append("\n"); 
		query.append(",	0.00" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	TO_DATE(@[exp_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[tri_rqst_ofc_cd]" ).append("\n"); 
		query.append(",	@[tri_rqst_usr_id]" ).append("\n"); 
		query.append(",	@[tri_apro_ofc_cd]" ).append("\n"); 
		query.append(",	@[tri_apro_usr_id]" ).append("\n"); 
		query.append(",	'I'" ).append("\n"); 
		query.append(",	@[rat_ut_cd]" ).append("\n"); 
		query.append(",	@[prc_cgo_tp_cd]" ).append("\n"); 
		query.append(",	@[curr_cd]" ).append("\n"); 
		query.append(",	@[prop_frt_rt_amt]" ).append("\n"); 
		query.append(",	@[coffr_frt_rt_amt]" ).append("\n"); 
		query.append(",	@[fnl_frt_rt_amt]" ).append("\n"); 
		query.append(",	@[note_ctnt]" ).append("\n"); 
		query.append(",	@[note_conv_mapg_id]" ).append("\n"); 
		query.append(",	@[tri_prop_no]" ).append("\n"); 
		query.append(",	0" ).append("\n"); 
		query.append(",	TO_DATE(@[eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",   @[tri_rmk]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}