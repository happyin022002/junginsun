/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustomerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : 강환
*@LastVersion : 1.0
* 2014.03.31 강환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwan, Kang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustomerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vendor 입력시 mdm customer 정보에도 insert / update 를 수행한다.
	  * </pre>
	  */
	public ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustomerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("modi_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("modi_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustomerCSQL").append("\n"); 
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
		query.append(" USING ( select @[cust_cnt_cd] cust_cnt_cd, @[cust_seq] cust_seq from dual ) b           " ).append("\n"); 
		query.append(" ON (a.cust_cnt_cd = b.cust_cnt_cd and a.cust_seq = b.cust_seq )  " ).append("\n"); 
		query.append(" WHEN MATCHED THEN                                                " ).append("\n"); 
		query.append(" update                                                           " ).append("\n"); 
		query.append(" set     " ).append("\n"); 
		query.append("  cntr_div_flg = 'Y'," ).append("\n"); 
		query.append("  blk_div_flg = 'N',                                                           " ).append("\n"); 
		query.append("  upd_usr_id  = @[upd_usr_id],                                                " ).append("\n"); 
		query.append("  upd_dt      = to_date(@[upd_dt],'yyyymmddhh24miss'),                    " ).append("\n"); 
		query.append("  eai_evnt_dt = to_date(@[eai_evnt_dt],'yyyymmddhh24miss'), " ).append("\n"); 
		query.append(" cust_rgst_no = @[cust_rgst_no],                   " ).append("\n"); 
		query.append("  cust_lgl_eng_nm  = SUBSTRB(@[cust_lgl_eng_nm], 1, 100),        " ).append("\n"); 
		query.append("  cust_locl_lang_nm  = SUBSTR(NVL(HJSEAI_PKG.h_decode(@[cust_locl_lang_nm],'UTF8','UTF8'),@[cust_locl_lang_nm]), 1, 100)," ).append("\n"); 
		query.append("  eai_if_id = @[eai_if_id]   " ).append("\n"); 
		query.append("  ,ofc_cd = @[ofc_cd]" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN                                            " ).append("\n"); 
		query.append(" insert                                                           " ).append("\n"); 
		query.append(" (                                                                " ).append("\n"); 
		query.append("  cust_cnt_cd,                                                    " ).append("\n"); 
		query.append("  cust_seq," ).append("\n"); 
		query.append("  CNTR_DIV_FLG," ).append("\n"); 
		query.append("  BLK_DIV_FLG,                                                       " ).append("\n"); 
		query.append("  cust_lgl_eng_nm,                                                " ).append("\n"); 
		query.append("  cust_locl_lang_nm,                                              " ).append("\n"); 
		query.append("  blk_cust_tp_cd,                                                 " ).append("\n"); 
		query.append("  ofc_cd, " ).append("\n"); 
		query.append("  cust_rgst_no,                                                        " ).append("\n"); 
		query.append("  loc_cd,                                                         " ).append("\n"); 
		query.append("  vndr_seq,                                                       " ).append("\n"); 
		query.append("  modi_cust_cnt_cd,                                               " ).append("\n"); 
		query.append("  modi_cust_seq,                                                  " ).append("\n"); 
		query.append("  cre_usr_id,                                                     " ).append("\n"); 
		query.append("  cre_dt,                                                         " ).append("\n"); 
		query.append("  upd_usr_id,                                                     " ).append("\n"); 
		query.append("  upd_dt,                                                         " ).append("\n"); 
		query.append("  delt_flg,                                                       " ).append("\n"); 
		query.append("  eai_evnt_dt," ).append("\n"); 
		query.append("  eai_if_id                                                     " ).append("\n"); 
		query.append(" )                                                                " ).append("\n"); 
		query.append(" values                                                           " ).append("\n"); 
		query.append(" (                                                                " ).append("\n"); 
		query.append("  @[cust_cnt_cd],                                                  " ).append("\n"); 
		query.append("  @[cust_seq]," ).append("\n"); 
		query.append("  'Y'," ).append("\n"); 
		query.append("  'N',                                                   " ).append("\n"); 
		query.append("  SUBSTRB(@[cust_lgl_eng_nm], 1, 100),                                        " ).append("\n"); 
		query.append("  SUBSTR(NVL(HJSEAI_PKG.h_decode(@[cust_locl_lang_nm],'UTF8','UTF8'),@[cust_locl_lang_nm]), 1, 100), " ).append("\n"); 
		query.append("  @[blk_cust_tp_cd],                                                    " ).append("\n"); 
		query.append("  @[ofc_cd],    " ).append("\n"); 
		query.append(" @[cust_rgst_no],                                                                                                               " ).append("\n"); 
		query.append("  @[loc_cd],                                                           " ).append("\n"); 
		query.append("  @[vndr_seq],                                                         " ).append("\n"); 
		query.append("  @[modi_cust_cnt_cd],                                                  " ).append("\n"); 
		query.append("  @[modi_cust_seq],                                                  " ).append("\n"); 
		query.append("  @[cre_usr_id],                                                        " ).append("\n"); 
		query.append("  to_date(@[cre_dt],'yyyymmddhh24miss'),                                  " ).append("\n"); 
		query.append("  @[upd_usr_id],                                                        " ).append("\n"); 
		query.append("  to_date(@[upd_dt],'yyyymmddhh24miss'),                                  " ).append("\n"); 
		query.append("  'N',                                                            " ).append("\n"); 
		query.append("  to_date(@[eai_evnt_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("  @[eai_if_id]                             " ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}