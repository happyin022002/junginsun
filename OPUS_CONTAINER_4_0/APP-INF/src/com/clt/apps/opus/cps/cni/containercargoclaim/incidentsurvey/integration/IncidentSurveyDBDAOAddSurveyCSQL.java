/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncidentSurveyDBDAOAddSurveyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.11.12 양정란
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncidentSurveyDBDAOAddSurveyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Survey 입력
	  * </pre>
	  */
	public IncidentSurveyDBDAOAddSurveyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svyr_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svyr_fact_fnd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svey_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svyr_apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_svyr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svyr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svyr_fee_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svyr_fee_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svyr_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration").append("\n"); 
		query.append("FileName : IncidentSurveyDBDAOAddSurveyCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_CGO_CLM_SVEY (" ).append("\n"); 
		query.append("SVYR_FACT_FND_DESC" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	CGO_CLM_NO" ).append("\n"); 
		query.append(",	CLM_PTY_NO" ).append("\n"); 
		query.append(",	SVYR_TP_CD" ).append("\n"); 
		query.append(",	REF_SVYR_NO" ).append("\n"); 
		query.append(",	SVYR_APNT_DT" ).append("\n"); 
		query.append(",	SVEY_INP_DT" ).append("\n"); 
		query.append(",	SVYR_FEE_LOCL_AMT" ).append("\n"); 
		query.append(",	SVYR_LOCL_CURR_CD" ).append("\n"); 
		query.append(",	SVYR_XCH_RT" ).append("\n"); 
		query.append(",	SVYR_FEE_USD_AMT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[svyr_fact_fnd_desc]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append(",	@[cgo_clm_no]" ).append("\n"); 
		query.append(",	@[clm_pty_no]" ).append("\n"); 
		query.append(",	@[svyr_tp_cd]" ).append("\n"); 
		query.append(",	@[ref_svyr_no]" ).append("\n"); 
		query.append(",	@[svyr_apnt_dt]" ).append("\n"); 
		query.append(",	@[svey_inp_dt]" ).append("\n"); 
		query.append(",	@[svyr_fee_locl_amt]" ).append("\n"); 
		query.append(",	@[svyr_locl_curr_cd]" ).append("\n"); 
		query.append(",	@[svyr_xch_rt]" ).append("\n"); 
		query.append(",	@[svyr_fee_usd_amt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}