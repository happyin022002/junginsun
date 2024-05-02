/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOmergeVndrToCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOmergeVndrToCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create TPB Customer를 체크한 경우 Vendor 정보를 MDM_CUSTOMER 테이블에 입력
	  * </pre>
	  */
	public PartnerDBDAOmergeVndrToCustCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfnd_psdo_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOmergeVndrToCustCSQL").append("\n"); 
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
		query.append("MERGE INTO mdm_customer a          " ).append("\n"); 
		query.append(" USING ( select substr(@[rfnd_psdo_cust_cd], 1, 2) cust_cnt_cd, @[vndr_seq] cust_seq from dual ) b           " ).append("\n"); 
		query.append(" ON (a.cust_cnt_cd = b.cust_cnt_cd and a.cust_seq = b.cust_seq )  " ).append("\n"); 
		query.append(" WHEN MATCHED THEN                                                " ).append("\n"); 
		query.append(" update                                                           " ).append("\n"); 
		query.append(" set     " ).append("\n"); 
		query.append("  cntr_div_flg = 'Y'," ).append("\n"); 
		query.append("  blk_div_flg = 'N',                                                           " ).append("\n"); 
		query.append("  upd_usr_id  = @[upd_usr_id],                                                " ).append("\n"); 
		query.append("  upd_dt      = sysdate,                    " ).append("\n"); 
		query.append("  cust_rgst_no = @[rgst_no],                   " ).append("\n"); 
		query.append("  cust_lgl_eng_nm  = SUBSTRB(@[vndr_lgl_eng_nm], 1, 100),        " ).append("\n"); 
		query.append("  cust_locl_lang_nm  = SUBSTR(@[vndr_locl_lang_nm], 1, 100)," ).append("\n"); 
		query.append("  ofc_cd = @[ofc_cd]," ).append("\n"); 
		query.append("  loc_cd = @[loc_cd]" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN                                            " ).append("\n"); 
		query.append(" insert                                                           " ).append("\n"); 
		query.append(" (                                                                " ).append("\n"); 
		query.append("  cust_cnt_cd,                                                    " ).append("\n"); 
		query.append("  cust_seq," ).append("\n"); 
		query.append("  CNTR_DIV_FLG," ).append("\n"); 
		query.append("  BLK_DIV_FLG,                                                       " ).append("\n"); 
		query.append("  cust_lgl_eng_nm,                                                " ).append("\n"); 
		query.append("  cust_locl_lang_nm,                                              " ).append("\n"); 
		query.append("  ofc_cd, " ).append("\n"); 
		query.append("  cust_rgst_no,                                                        " ).append("\n"); 
		query.append("  loc_cd,                                                         " ).append("\n"); 
		query.append("  vndr_seq,                                                       " ).append("\n"); 
		query.append("  cre_usr_id,                                                     " ).append("\n"); 
		query.append("  cre_dt,                                                         " ).append("\n"); 
		query.append("  upd_usr_id,                                                     " ).append("\n"); 
		query.append("  upd_dt,                                                         " ).append("\n"); 
		query.append("  delt_flg                                                       " ).append("\n"); 
		query.append(" )                                                                " ).append("\n"); 
		query.append(" values                                                           " ).append("\n"); 
		query.append(" (                                                                " ).append("\n"); 
		query.append("  substr(@[rfnd_psdo_cust_cd], 1, 2),                                                  " ).append("\n"); 
		query.append("  @[vndr_seq]," ).append("\n"); 
		query.append("  'Y'," ).append("\n"); 
		query.append("  'N',                                                   " ).append("\n"); 
		query.append("  SUBSTRB(@[vndr_lgl_eng_nm], 1, 100),                                        " ).append("\n"); 
		query.append("  SUBSTR(@[vndr_locl_lang_nm], 1, 100), " ).append("\n"); 
		query.append("  @[ofc_cd],    " ).append("\n"); 
		query.append("  @[rgst_no],                                                                                                               " ).append("\n"); 
		query.append("  @[loc_cd],                                                           " ).append("\n"); 
		query.append("  @[vndr_seq],                                                         " ).append("\n"); 
		query.append("  @[cre_usr_id],                                                        " ).append("\n"); 
		query.append("  to_date(substr(@[cre_dt], 1, 19), 'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("  @[upd_usr_id],                                                        " ).append("\n"); 
		query.append("  to_date(substr(@[upd_dt], 1, 19), 'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("  'N'                                                            " ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}