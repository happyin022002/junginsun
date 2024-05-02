/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.04.16 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGINSUN
 * @see 
 * @since J2EE 1.4
 */

public class TCharteIOContractDAOSearchContractByCharterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharteIOContractDAOSearchContractByCharterRSQL
	  * </pre>
	  */
	public TCharteIOContractDAOSearchContractByCharterRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select  flet_ctrt_no," ).append("\n"); 
		query.append("vsl_cd," ).append("\n"); 
		query.append("vsl_eng_nm," ).append("\n"); 
		query.append("flet_ctrt_tp_cd," ).append("\n"); 
		query.append("vndr_lgl_eng_nm," ).append("\n"); 
		query.append("cust_cnt_cd," ).append("\n"); 
		query.append("cust_seq," ).append("\n"); 
		query.append("ownr_nm," ).append("\n"); 
		query.append("DECODE(exist,null,'I','') ibflag" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select  fc.flet_ctrt_no," ).append("\n"); 
		query.append("fc.vsl_cd," ).append("\n"); 
		query.append("(select vsl_eng_nm from mdm_vsl_cntr where vsl_cd = fc.vsl_cd and rownum =1) vsl_eng_nm," ).append("\n"); 
		query.append("DECODE(fc.flet_ctrt_tp_cd,'TI','T/C In','TO','T/C Out','OW','Ownership') flet_ctrt_tp_cd," ).append("\n"); 
		query.append("CASE WHEN fc.flet_ctrt_tp_cd = 'TO' THEN" ).append("\n"); 
		query.append("(select mv.cust_lgl_eng_nm" ).append("\n"); 
		query.append("from mdm_customer mv, fms_owner fo" ).append("\n"); 
		query.append("where cust_cnt_cd = fc.cust_cnt_cd" ).append("\n"); 
		query.append("and cust_seq = fc.cust_seq" ).append("\n"); 
		query.append("and mv.flet_mgmt_ownr_cust_seq = fo.ownr_seq" ).append("\n"); 
		query.append("and rownum =1)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(select mv.vndr_lgl_eng_nm" ).append("\n"); 
		query.append("from mdm_vendor mv, fms_owner fo" ).append("\n"); 
		query.append("where vndr_seq = fc.vndr_seq" ).append("\n"); 
		query.append("and mv.flet_mgmt_ownr_vndr_seq = fo.ownr_seq" ).append("\n"); 
		query.append("and rownum =1)" ).append("\n"); 
		query.append("END vndr_lgl_eng_nm," ).append("\n"); 
		query.append("fc.cust_cnt_cd," ).append("\n"); 
		query.append("DECODE(fc.cust_seq,null,fc.vndr_seq,fc.cust_seq) cust_seq," ).append("\n"); 
		query.append("CASE WHEN fc.flet_ctrt_tp_cd = 'TO' THEN" ).append("\n"); 
		query.append("(select fo.ownr_nm" ).append("\n"); 
		query.append("from mdm_customer mv, fms_owner fo" ).append("\n"); 
		query.append("where cust_cnt_cd = fc.cust_cnt_cd" ).append("\n"); 
		query.append("and cust_seq = fc.cust_seq" ).append("\n"); 
		query.append("and mv.flet_mgmt_ownr_cust_seq = fo.ownr_seq" ).append("\n"); 
		query.append("and rownum =1)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(select fo.ownr_nm" ).append("\n"); 
		query.append("from mdm_vendor mv, fms_owner fo" ).append("\n"); 
		query.append("where vndr_seq = fc.vndr_seq" ).append("\n"); 
		query.append("and mv.flet_mgmt_ownr_vndr_seq = fo.ownr_seq" ).append("\n"); 
		query.append("and rownum =1)" ).append("\n"); 
		query.append("END ownr_nm," ).append("\n"); 
		query.append("(select flet_ctrt_no from fms_invoice where flet_ctrt_no = @[flet_ctrt_no] and flet_iss_tp_cd = 'CHT' and rownum = 1) exist" ).append("\n"); 
		query.append("from  fms_contract fc" ).append("\n"); 
		query.append("where  fc.flet_ctrt_no = @[flet_ctrt_no]" ).append("\n"); 
		query.append("and  rownum = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}