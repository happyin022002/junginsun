/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ZDAOArrNtcCustListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.01
*@LastModifier : 윤한
*@LastVersion : 1.0
* 2010.06.01 윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ZDAOArrNtcCustListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ArrNtcCustListVO
	  * </pre>
	  */
	public ZDAOArrNtcCustListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ZDAOArrNtcCustListRSQL").append("\n"); 
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
		query.append(" ''eml4" ).append("\n"); 
		query.append(", ''eml5" ).append("\n"); 
		query.append(", ''evaluation_yn" ).append("\n"); 
		query.append(", ''cust_nm" ).append("\n"); 
		query.append(", ''cust_cntc_tp_cd" ).append("\n"); 
		query.append(", ''ib_cmdt_flg" ).append("\n"); 
		query.append(", ''row_count" ).append("\n"); 
		query.append(", ''bl_no" ).append("\n"); 
		query.append(", ''ntc_eml" ).append("\n"); 
		query.append(", ''sc_no" ).append("\n"); 
		query.append(", ''fax5" ).append("\n"); 
		query.append(", ''fax4" ).append("\n"); 
		query.append(", ''fax3" ).append("\n"); 
		query.append(", ''cust_fax_no" ).append("\n"); 
		query.append(", ''fax2" ).append("\n"); 
		query.append(", ''fax1" ).append("\n"); 
		query.append(", ''bkg_cust_tp_cd" ).append("\n"); 
		query.append(", ''eml1" ).append("\n"); 
		query.append(", ''upd_usr_id" ).append("\n"); 
		query.append(", ''eml3" ).append("\n"); 
		query.append(", ''cust_cnt_cd" ).append("\n"); 
		query.append(", ''is_an" ).append("\n"); 
		query.append(", ''val_cd" ).append("\n"); 
		query.append(", ''eml2" ).append("\n"); 
		query.append(", ''del_cd" ).append("\n"); 
		query.append(", ''cust_addr" ).append("\n"); 
		query.append(", ''cust_seq" ).append("\n"); 
		query.append(", ''cust_eml" ).append("\n"); 
		query.append(", ''vvd" ).append("\n"); 
		query.append(", ''cre_usr_id" ).append("\n"); 
		query.append(", ''bkg_no" ).append("\n"); 
		query.append(", ''vsl_info_set_flg" ).append("\n"); 
		query.append(", ''cust_cd" ).append("\n"); 
		query.append(", ''is_validated" ).append("\n"); 
		query.append(", ''fax_no" ).append("\n"); 
		query.append(", ''chg_dp_flg" ).append("\n"); 
		query.append(", ''fax_snd_flg1" ).append("\n"); 
		query.append(", ''fax_snd_flg2" ).append("\n"); 
		query.append(", ''fax_snd_flg3" ).append("\n"); 
		query.append(", ''fax_snd_flg4" ).append("\n"); 
		query.append(", ''fax_snd_flg5" ).append("\n"); 
		query.append(", ''eml_snd_flg1" ).append("\n"); 
		query.append(", ''eml_snd_flg2" ).append("\n"); 
		query.append(", ''eml_snd_flg3" ).append("\n"); 
		query.append(", ''eml_snd_flg4" ).append("\n"); 
		query.append(", ''eml_snd_flg5" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}