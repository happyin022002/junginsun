/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgCustCntcPsonVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.08.04 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgCustCntcPsonVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingMasterMgtDBDAOBkgCustCntcPsonVO
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgCustCntcPsonVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_mphn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fwrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cntc_pson_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgCustCntcPsonVOCSQL").append("\n"); 
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
		query.append("insert into bkg_cust_cntc_pson (" ).append("\n"); 
		query.append("cust_cnt_cd," ).append("\n"); 
		query.append("cust_seq," ).append("\n"); 
		query.append("cntc_pson_seq," ).append("\n"); 
		query.append("bkg_cntc_pson_tp_cd," ).append("\n"); 
		query.append("cntc_pson_nm," ).append("\n"); 
		query.append("cntc_eml," ).append("\n"); 
		query.append("phn_no," ).append("\n"); 
		query.append("CNTC_PSON_MPHN_NO," ).append("\n"); 
		query.append("fax_no," ).append("\n"); 
		query.append("diff_rmk," ).append("\n"); 
		query.append("fwrd_cnt_cd," ).append("\n"); 
		query.append("fwrd_cust_seq," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append(") values(" ).append("\n"); 
		query.append("@[cust_cnt_cd]," ).append("\n"); 
		query.append("@[cust_seq]," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("nvl((select /*+ index_desc(bkg_cust_cntc_pson XPKBKG_CUST_CNTC_PSON)  */" ).append("\n"); 
		query.append("cntc_pson_seq" ).append("\n"); 
		query.append("from  bkg_cust_cntc_pson" ).append("\n"); 
		query.append("where cust_cnt_cd = @[cust_cnt_cd]" ).append("\n"); 
		query.append("and   cust_seq = @[cust_seq]" ).append("\n"); 
		query.append("and   rownum = 1" ).append("\n"); 
		query.append("),0)+1)," ).append("\n"); 
		query.append("@[bkg_cntc_pson_tp_cd]," ).append("\n"); 
		query.append("@[cntc_pson_nm]," ).append("\n"); 
		query.append("@[cntc_eml]," ).append("\n"); 
		query.append("@[phn_no]," ).append("\n"); 
		query.append("@[cntc_pson_mphn_no]," ).append("\n"); 
		query.append("@[fax_no]," ).append("\n"); 
		query.append("@[diff_rmk]," ).append("\n"); 
		query.append("substr(@[fwrd_cnt_cd],1,2)," ).append("\n"); 
		query.append("substr(@[fwrd_cnt_cd],3,6)," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}