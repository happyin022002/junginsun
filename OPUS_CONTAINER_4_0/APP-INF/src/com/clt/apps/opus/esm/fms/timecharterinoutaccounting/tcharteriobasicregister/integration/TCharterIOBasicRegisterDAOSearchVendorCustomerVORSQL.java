/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.19 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon Seyeong
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class TCharterIOBasicRegisterDAOSearchVendorCustomerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOBasicRegisterDAOSearchVendorCustomerVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("#if (${condflag} == \"VE\")" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("b.vndr_seq," ).append("\n"); 
		query.append("b.vndr_lgl_eng_nm," ).append("\n"); 
		query.append("b.flet_mgmt_ownr_vndr_seq," ).append("\n"); 
		query.append("a.ownr_nm," ).append("\n"); 
		query.append("a.flet_ownr_tp_cd," ).append("\n"); 
		query.append("decode(b.vndr_cnt_cd, 'KR', 'Mandatory', '') tax_required" ).append("\n"); 
		query.append("from fms_owner a, mdm_vendor b" ).append("\n"); 
		query.append("where a.ownr_seq = b.flet_mgmt_ownr_vndr_seq" ).append("\n"); 
		query.append("and b.delt_flg = 'N'" ).append("\n"); 
		query.append("and flet_mgmt_ownr_vndr_seq is not null" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${condflag} == \"VC\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select 	vndr_seq" ).append("\n"); 
		query.append("from	fms_contract" ).append("\n"); 
		query.append("where	vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${condflag} == \"VM\")" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("vndr_seq cd_seq," ).append("\n"); 
		query.append("vndr_lgl_eng_nm cd_name," ).append("\n"); 
		query.append("vndr_cnt_cd cd_cnt" ).append("\n"); 
		query.append("from mdm_vendor" ).append("\n"); 
		query.append("where vndr_seq = @[cd_seq]" ).append("\n"); 
		query.append("and   delt_flg = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${condflag} == \"VP\")" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("vndr_seq cd_seq," ).append("\n"); 
		query.append("vndr_lgl_eng_nm cd_name," ).append("\n"); 
		query.append("vndr_cnt_cd cd_cnt" ).append("\n"); 
		query.append("from mdm_vendor" ).append("\n"); 
		query.append("where upper(vndr_lgl_eng_nm) like '%'||@[search_name]||'%'" ).append("\n"); 
		query.append("and   delt_flg = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmtflag} == \"C\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and flet_mgmt_ownr_vndr_seq is not null" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${condflag} == \"CE\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("b.cust_seq," ).append("\n"); 
		query.append("b.cust_lgl_eng_nm," ).append("\n"); 
		query.append("b.flet_mgmt_ownr_cust_seq," ).append("\n"); 
		query.append("a.ownr_nm," ).append("\n"); 
		query.append("a.flet_ownr_tp_cd," ).append("\n"); 
		query.append("b.cust_cnt_cd," ).append("\n"); 
		query.append("decode(b.cust_cnt_cd, 'KR', 'Mandatory', '') tax_required" ).append("\n"); 
		query.append("from fms_owner a, mdm_customer b" ).append("\n"); 
		query.append("where a.ownr_seq = b.flet_mgmt_ownr_cust_seq" ).append("\n"); 
		query.append("and b.delt_flg = 'N'" ).append("\n"); 
		query.append("and flet_mgmt_ownr_cust_seq is not null" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${condflag} == \"CC\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select 	cust_seq" ).append("\n"); 
		query.append("from	fms_contract" ).append("\n"); 
		query.append("where	cust_cnt_cd = @[cust_cnt_cd]" ).append("\n"); 
		query.append("and		cust_seq = @[cust_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${condflag} == \"CM\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("cust_seq cd_seq," ).append("\n"); 
		query.append("cust_lgl_eng_nm cd_name," ).append("\n"); 
		query.append("cust_cnt_cd cd_cnt" ).append("\n"); 
		query.append("from mdm_customer" ).append("\n"); 
		query.append("where cust_cnt_cd = @[cd_cnt]" ).append("\n"); 
		query.append("and   cust_seq = @[cd_seq]" ).append("\n"); 
		query.append("and   delt_flg = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${condflag} == \"CP\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("cust_seq cd_seq," ).append("\n"); 
		query.append("cust_lgl_eng_nm cd_name," ).append("\n"); 
		query.append("cust_cnt_cd cd_cnt" ).append("\n"); 
		query.append("from mdm_customer" ).append("\n"); 
		query.append("where upper(cust_lgl_eng_nm) like '%'||@[search_name]||'%'" ).append("\n"); 
		query.append("and   delt_flg = 'N'" ).append("\n"); 
		query.append("#if (${agmtflag} == \"C\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and flet_mgmt_ownr_cust_seq is not null" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDAOSearchVendorCustomerVORSQL").append("\n"); 
		query.append("Developer: 윤세영").append("\n");
		query.append("*/").append("\n"); 
	}
}