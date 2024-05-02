/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOBkgTroActCustVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.25 
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

public class TransferOrderIssueDBDAOBkgTroActCustVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert Sql
	  * </pre>
	  */
	public TransferOrderIssueDBDAOBkgTroActCustVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_act_rep_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_act_cust_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_mphn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_addr1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_zip_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_addr3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_addr2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOBkgTroActCustVOCSQL").append("\n"); 
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
		query.append("insert into bkg_tro_act_cust (" ).append("\n"); 
		query.append("	tro_act_cust_knd_cd," ).append("\n"); 
		query.append("	tro_vndr_seq," ).append("\n"); 
		query.append("	ofc_cd," ).append("\n"); 
		query.append("	tro_act_rep_seq," ).append("\n"); 
		query.append("	cnt_cd," ).append("\n"); 
		query.append("	cust_seq," ).append("\n"); 
		query.append("	vndr_seq," ).append("\n"); 
		query.append("	loc_cd," ).append("\n"); 
		query.append("	zn_cd," ).append("\n"); 
		query.append("	act_shpr_nm," ).append("\n"); 
		query.append("	act_shpr_addr," ).append("\n"); 
		query.append("	act_shpr_addr1," ).append("\n"); 
		query.append("	act_shpr_addr2," ).append("\n"); 
		query.append("	act_shpr_addr3," ).append("\n"); 
		query.append("	cntc_pson_nm," ).append("\n"); 
		query.append("	cntc_phn_no," ).append("\n"); 
		query.append("	cntc_fax_no," ).append("\n"); 
		query.append("	cntc_mphn_no," ).append("\n"); 
		query.append("	cntc_eml," ).append("\n"); 
		query.append("	dor_zip_id," ).append("\n"); 
		query.append("	diff_rmk," ).append("\n"); 
		query.append("	cre_usr_id," ).append("\n"); 
		query.append("	cre_dt," ).append("\n"); 
		query.append("	upd_usr_id," ).append("\n"); 
		query.append("	upd_dt" ).append("\n"); 
		query.append(") values( " ).append("\n"); 
		query.append("	@[tro_act_cust_knd_cd]," ).append("\n"); 
		query.append("    nvl((select /*+ index_desc(bkg_tro_act_cust XPKBKG_TRO_ACT_CUST)  */   " ).append("\n"); 
		query.append("               tro_vndr_seq   " ).append("\n"); 
		query.append("          from bkg_tro_act_cust   " ).append("\n"); 
		query.append("         where tro_act_cust_knd_cd = @[tro_act_cust_knd_cd]      " ).append("\n"); 
		query.append("           and rownum = 1 ),0)+1," ).append("\n"); 
		query.append("	@[ofc_cd]," ).append("\n"); 
		query.append("    @[tro_act_rep_seq], " ).append("\n"); 
		query.append("	@[cnt_cd]," ).append("\n"); 
		query.append("	@[cust_seq]," ).append("\n"); 
		query.append("	@[vndr_seq]," ).append("\n"); 
		query.append("	@[loc_cd]," ).append("\n"); 
		query.append("	@[zn_cd]," ).append("\n"); 
		query.append("	@[act_shpr_nm]," ).append("\n"); 
		query.append("	@[act_shpr_addr]," ).append("\n"); 
		query.append("	@[act_shpr_addr1]," ).append("\n"); 
		query.append("	@[act_shpr_addr2]," ).append("\n"); 
		query.append("	@[act_shpr_addr3]," ).append("\n"); 
		query.append("	@[cntc_pson_nm]," ).append("\n"); 
		query.append("	@[cntc_phn_no]," ).append("\n"); 
		query.append("	@[cntc_fax_no]," ).append("\n"); 
		query.append("	@[cntc_mphn_no]," ).append("\n"); 
		query.append("	@[cntc_eml]," ).append("\n"); 
		query.append("	@[dor_zip_id]," ).append("\n"); 
		query.append("	@[diff_rmk]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	sysdate," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}