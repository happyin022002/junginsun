/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndemnityDBDAOAddLiablePartyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.11.17 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndemnityDBDAOAddLiablePartyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LiableParty 등록
	  * </pre>
	  */
	public IndemnityDBDAOAddLiablePartyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_fmal_clm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_clm_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_rcvr_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_rcvr_locl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_dmnd_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tm_bar_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("labl_pty_dmnd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_rcvr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_prlm_clm_ntfy_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("labl_pty_rcvr_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_rcvr_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_dmnd_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.integration").append("\n"); 
		query.append("FileName : IndemnityDBDAOAddLiablePartyCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_CGO_CLM_LABL_PTY (" ).append("\n"); 
		query.append("CGO_CLM_NO" ).append("\n"); 
		query.append(",	TM_BAR_DT" ).append("\n"); 
		query.append(",	LABL_PTY_FMAL_CLM_DT" ).append("\n"); 
		query.append(",	LABL_PTY_DMND_USD_AMT" ).append("\n"); 
		query.append(",	LABL_PTY_DMND_AMT" ).append("\n"); 
		query.append(",	LABL_PTY_DMND_CURR_CD" ).append("\n"); 
		query.append(",	LABL_PTY_XCH_RT" ).append("\n"); 
		query.append(",	HNDL_OFC_CD" ).append("\n"); 
		query.append(",	LABL_PTY_PRLM_CLM_NTFY_DT" ).append("\n"); 
		query.append(",	LABL_PTY_RCVR_DT" ).append("\n"); 
		query.append(",	LABL_PTY_RCVR_USD_AMT" ).append("\n"); 
		query.append(",	LABL_PTY_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append(",	LABL_PTY_RCVR_LOCL_AMT" ).append("\n"); 
		query.append(",	LABL_PTY_RCVR_LOCL_XCH_RT" ).append("\n"); 
		query.append(",	LABL_PTY_CLM_RMK" ).append("\n"); 
		query.append(",	CLM_PTY_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("@[cgo_clm_no]" ).append("\n"); 
		query.append(",	@[tm_bar_dt]" ).append("\n"); 
		query.append(",	@[labl_pty_fmal_clm_dt]" ).append("\n"); 
		query.append(",	@[labl_pty_dmnd_usd_amt]" ).append("\n"); 
		query.append(",	@[labl_pty_dmnd_amt]" ).append("\n"); 
		query.append(",	@[labl_pty_dmnd_curr_cd]" ).append("\n"); 
		query.append(",	@[labl_pty_xch_rt]" ).append("\n"); 
		query.append(",	@[hndl_ofc_cd]" ).append("\n"); 
		query.append(",	@[labl_pty_prlm_clm_ntfy_dt]" ).append("\n"); 
		query.append(",	@[labl_pty_rcvr_dt]" ).append("\n"); 
		query.append(",	@[labl_pty_rcvr_usd_amt]" ).append("\n"); 
		query.append(",	@[labl_pty_rcvr_locl_curr_cd]" ).append("\n"); 
		query.append(",	@[labl_pty_rcvr_locl_amt]" ).append("\n"); 
		query.append(",	@[labl_pty_rcvr_locl_xch_rt]" ).append("\n"); 
		query.append(",	@[labl_pty_clm_rmk]" ).append("\n"); 
		query.append(",	@[clm_pty_no]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}