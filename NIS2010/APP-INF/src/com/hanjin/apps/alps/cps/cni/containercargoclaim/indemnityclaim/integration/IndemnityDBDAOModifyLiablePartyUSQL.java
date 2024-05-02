/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndemnityDBDAOModifyLiablePartyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.11.26 박제성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndemnityDBDAOModifyLiablePartyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LiableParty 수정
	  * </pre>
	  */
	public IndemnityDBDAOModifyLiablePartyUSQL(){
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
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.integration").append("\n"); 
		query.append("FileName : IndemnityDBDAOModifyLiablePartyUSQL").append("\n"); 
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
		query.append("UPDATE" ).append("\n"); 
		query.append("CNI_CGO_CLM_LABL_PTY" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("TM_BAR_DT			= @[tm_bar_dt]" ).append("\n"); 
		query.append(",	LABL_PTY_FMAL_CLM_DT		= @[labl_pty_fmal_clm_dt]" ).append("\n"); 
		query.append(",	LABL_PTY_DMND_USD_AMT		= @[labl_pty_dmnd_usd_amt]" ).append("\n"); 
		query.append(",	LABL_PTY_DMND_AMT		= @[labl_pty_dmnd_amt]" ).append("\n"); 
		query.append(",	LABL_PTY_DMND_CURR_CD		= @[labl_pty_dmnd_curr_cd]" ).append("\n"); 
		query.append(",	LABL_PTY_XCH_RT			= @[labl_pty_xch_rt]" ).append("\n"); 
		query.append(",	HNDL_OFC_CD			= @[hndl_ofc_cd]" ).append("\n"); 
		query.append(",	LABL_PTY_PRLM_CLM_NTFY_DT	= @[labl_pty_prlm_clm_ntfy_dt]" ).append("\n"); 
		query.append(",	LABL_PTY_RCVR_DT		= @[labl_pty_rcvr_dt]" ).append("\n"); 
		query.append(",	LABL_PTY_RCVR_USD_AMT		= @[labl_pty_rcvr_usd_amt]" ).append("\n"); 
		query.append(",	LABL_PTY_RCVR_LOCL_CURR_CD	= @[labl_pty_rcvr_locl_curr_cd]" ).append("\n"); 
		query.append(",	LABL_PTY_RCVR_LOCL_AMT		= @[labl_pty_rcvr_locl_amt]" ).append("\n"); 
		query.append(",	LABL_PTY_RCVR_LOCL_XCH_RT	= @[labl_pty_rcvr_locl_xch_rt]" ).append("\n"); 
		query.append(",	LABL_PTY_CLM_RMK		= @[labl_pty_clm_rmk]" ).append("\n"); 
		query.append(",	CLM_PTY_NO			= @[clm_pty_no]" ).append("\n"); 
		query.append(",	UPD_USR_ID			= @[cre_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT				= CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}