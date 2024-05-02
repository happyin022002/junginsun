/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOBkgTroActCustExtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.17 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOBkgTroActCustExtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgTroActCust ext select
	  * </pre>
	  */
	public TransferOrderIssueDBDAOBkgTroActCustExtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOBkgTroActCustExtVORSQL").append("\n"); 
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
		query.append("a.tro_act_cust_knd_cd," ).append("\n"); 
		query.append("a.tro_vndr_seq," ).append("\n"); 
		query.append("a.ofc_cd," ).append("\n"); 
		query.append("a.tro_act_rep_seq," ).append("\n"); 
		query.append("a.cnt_cd," ).append("\n"); 
		query.append("a.cust_seq," ).append("\n"); 
		query.append("a.vndr_seq," ).append("\n"); 
		query.append("a.loc_cd," ).append("\n"); 
		query.append("SUBSTR(a.ZN_CD, 6, 2) zn_cd," ).append("\n"); 
		query.append("a.act_shpr_nm," ).append("\n"); 
		query.append("a.act_shpr_addr," ).append("\n"); 
		query.append("a.cntc_pson_nm," ).append("\n"); 
		query.append("a.cntc_phn_no," ).append("\n"); 
		query.append("a.cntc_fax_no," ).append("\n"); 
		query.append("a.cntc_mphn_no," ).append("\n"); 
		query.append("a.cntc_eml," ).append("\n"); 
		query.append("a.dor_zip_id," ).append("\n"); 
		query.append("a.diff_rmk," ).append("\n"); 
		query.append("'' vndr_lgl_eng_nm," ).append("\n"); 
		query.append("a.cre_usr_id," ).append("\n"); 
		query.append("a.cre_dt," ).append("\n"); 
		query.append("a.upd_usr_id," ).append("\n"); 
		query.append("a.upd_dt" ).append("\n"); 
		query.append("FROM bkg_tro_act_cust a" ).append("\n"); 
		query.append("WHERE	a.tro_act_cust_knd_cd = 'C'" ).append("\n"); 
		query.append("AND	a.cnt_cd = @[cnt_cd]" ).append("\n"); 
		query.append("AND	a.CUST_seq = @[cust_seq]" ).append("\n"); 

	}
}