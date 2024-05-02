/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UserSetupMgtDBDAOBkgXterSrchSetVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOBkgXterSrchSetVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public UserSetupMgtDBDAOBkgXterSrchSetVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOBkgXterSrchSetVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	set_slct_flg" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append(",	usr_id" ).append("\n"); 
		query.append(",	set_sub_seq" ).append("\n"); 
		query.append(",	doc_tp_cd" ).append("\n"); 
		query.append(",	bkg_upld_sts_cd" ).append("\n"); 
		query.append(",	non_rt_sts_cd" ).append("\n"); 
		query.append(",	xter_bkg_rqst_sts_cd" ).append("\n"); 
		query.append(",	xter_rqst_via_cd" ).append("\n"); 
		query.append(",	org_cnt_cd" ).append("\n"); 
		query.append(",	del_conti_cd" ).append("\n"); 
		query.append(",	hndl_ofc_cd" ).append("\n"); 
		query.append(",	bkg_cust_tp_cd" ).append("\n"); 
		query.append(",	cust_cnt_cd" ).append("\n"); 
		query.append(",	decode(cust_seq, 0, '', cust_seq) cust_seq" ).append("\n"); 
		query.append(",	cust_nm" ).append("\n"); 
		query.append(",	srep_cd" ).append("\n"); 
		query.append(",	chn_agn_cd" ).append("\n"); 
		query.append(",	slan_cd lane" ).append("\n"); 
		query.append(",   xter_sndr_id edi_id" ).append("\n"); 
		query.append("FROM bkg_xter_srch_set" ).append("\n"); 
		query.append("WHERE	usr_id = @[usr_id]" ).append("\n"); 
		query.append("AND NVL(DOC_TP_CD,'X') <> 'D'" ).append("\n"); 

	}
}