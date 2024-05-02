/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOUnconfirmEurTroUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOUnconfirmEurTroUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EUR TRO Flag Unconfirm
	  * 2010.11.02 Frustrate이후 route변경에 따른 bug수정
	  * </pre>
	  */
	public TransferOrderIssueDBDAOUnconfirmEurTroUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOUnconfirmEurTroUSQL").append("\n"); 
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
		query.append("UPDATE bkg_eur_tro" ).append("\n"); 
		query.append("set TRO_PROC_CD = NULL" ).append("\n"); 
		query.append(", CFM_FLG = 'N'" ).append("\n"); 
		query.append(", CFM_DT = null" ).append("\n"); 
		query.append(", CFM_UPD_DT = NULL" ).append("\n"); 
		query.append(", corr_flg = 'N'" ).append("\n"); 
		query.append(", corr_NO = null" ).append("\n"); 
		query.append(", cfm_hlg_tp_cd = null" ).append("\n"); 
		query.append(", cfm_all_in_rt_cd = null" ).append("\n"); 
		query.append(", cfm_curr_cd = null" ).append("\n"); 
		query.append(", cfm_rev_Amt = null" ).append("\n"); 
		query.append(", cfm_vat_flg = 'N'" ).append("\n"); 
		query.append(", PCTL_NO = NULL" ).append("\n"); 
		query.append(", UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE bkg_no    = @[bkg_no]" ).append("\n"); 
		query.append("AND io_bnd_cd = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND HLG_TP_CD = 'C'--carrier haulage만 적용" ).append("\n"); 
		query.append("AND NVL(EUR_TRNS_TP_CD, ' ') <> 'FR' --Frustrate된 경우에는 unconfirm시키지 않아도 됨 2010.11.02" ).append("\n"); 

	}
}