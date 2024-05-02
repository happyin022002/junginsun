/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOBasicRegisterDAOCustomAcctCateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDAOCustomAcctCateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOBasicRegisterDAOCustomAcctCateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDAOCustomAcctCateVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("b.acct_cd," ).append("\n"); 
		query.append("a.acct_eng_nm," ).append("\n"); 
		query.append("b.acct_itm_seq," ).append("\n"); 
		query.append("b.acct_itm_nm," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'OT', 'Y', 'N')) chk_other_exp," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'CH', 'Y', 'N')) chk_charterer," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'OW', 'Y', 'N')) chk_owner," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'PP', 'Y', 'N')) chk_prepaymentp," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'PS', 'Y', 'N')) chk_prepayments," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'MS', 'Y', 'N')) chk_manual_slip," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'OF', 'Y', 'N')) chk_off_hire," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'VV', 'Y', 'N')) chk_vvd_required," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'BU', 'Y', 'N')) chk_bodbor_if," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'OT', 'OTY', 'OTN')) prev_other_exp," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'CH', 'CHY', 'CHN')) prev_charterer," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'OW', 'OWY', 'OWN')) prev_owner," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'PP', 'PPY', 'PPN')) prev_prepaymentp," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'PS', 'PSY', 'PSN')) prev_prepayments," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'MS', 'MSY', 'MSN')) prev_manual_slip," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'OF', 'OFY', 'OFN')) prev_off_hire," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'VV', 'VVY', 'VVN')) prev_vvd_required," ).append("\n"); 
		query.append("max(decode(	c.flet_acct_cate_cd, 'BU', 'BUY', 'BUN')) prev_bodbor_if," ).append("\n"); 
		query.append("'' flet_acct_cate_cd," ).append("\n"); 
		query.append("'' cre_usr_id," ).append("\n"); 
		query.append("'' upd_usr_id" ).append("\n"); 
		query.append("from 	mdm_account a, fms_acct_itm b, fms_acct_cate c" ).append("\n"); 
		query.append("where 	a.acct_cd = b.acct_cd" ).append("\n"); 
		query.append("and     b.acct_cd = c.acct_cd(+)" ).append("\n"); 
		query.append("and     b.acct_itm_seq = c.acct_itm_seq(+)" ).append("\n"); 
		query.append("and     b.acct_cd not in ('610411', '612911', '710311', '712911')" ).append("\n"); 
		query.append("group by b.acct_cd, a.acct_eng_nm, b.acct_itm_seq,b.acct_itm_nm" ).append("\n"); 
		query.append("order by b.acct_cd, b.acct_itm_nm" ).append("\n"); 

	}
}