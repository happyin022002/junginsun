/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeDAOGuaranteeCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.12.08 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeDAOGuaranteeCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee Common VO
	  * </pre>
	  */
	public GuaranteeDAOGuaranteeCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo").append("\n"); 
		query.append("FileName : GuaranteeDAOGuaranteeCommonRSQL").append("\n"); 
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
		query.append("'' tes_mode" ).append("\n"); 
		query.append(", '' oid" ).append("\n"); 
		query.append(", '' idx" ).append("\n"); 
		query.append(", '' f_cmd" ).append("\n"); 
		query.append(", '' def" ).append("\n"); 
		query.append(", '' functionName" ).append("\n"); 
		query.append(", '' ifrId" ).append("\n"); 
		query.append(", '' fm_cre_dt		-- inquiry period" ).append("\n"); 
		query.append(", '' to_cre_dt		-- inquiry period" ).append("\n"); 
		query.append(", '' cntr_no_tmp	-- Container Info" ).append("\n"); 
		query.append(", '' bkg_no_tmp		-- Container Info" ).append("\n"); 
		query.append(", '' gnte_tp_cd		-- Container Dup Check" ).append("\n"); 
		query.append(", '' ofc_cd			-- Container Dup Check" ).append("\n"); 
		query.append(", '' ref_no" ).append("\n"); 
		query.append(", '' cntr_no" ).append("\n"); 
		query.append(", '' bl_no" ).append("\n"); 
		query.append(", '' bkg_no" ).append("\n"); 
		query.append(", '' inv_no" ).append("\n"); 
		query.append(", '' gnte_cust_cd	-- creation cust code" ).append("\n"); 
		query.append(", '' gnte_flg" ).append("\n"); 
		query.append(", '' gnte_no" ).append("\n"); 
		query.append(", '' irr_no" ).append("\n"); 
		query.append(", '' cre_flg		-- Creation Reference No. 조회 구분값 G : Gurantee I : Irregular" ).append("\n"); 
		query.append(", '' cntr_seq		-- Guarantee > Irregular, TPB IF Container Seq 목록." ).append("\n"); 
		query.append("-- fax, email 에서 사용 /ESD_TES_2003/" ).append("\n"); 
		query.append(", '' sys_cd" ).append("\n"); 
		query.append(", '' app_cd" ).append("\n"); 
		query.append(", '' batch_ind" ).append("\n"); 
		query.append(", '' fax_title" ).append("\n"); 
		query.append(", '' param" ).append("\n"); 
		query.append(", '' rcv_info" ).append("\n"); 
		query.append(", '' email_title" ).append("\n"); 
		query.append(", '' email_contents" ).append("\n"); 
		query.append(", '' email_addr" ).append("\n"); 
		query.append(", '' fax_num" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}