/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.04.21 정인선
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

public class TCharterIOContractDAOSearchOwnerByVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOSearchOwnerByVendorRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOSearchOwnerByVendorRSQL(){
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
		query.append("mv.vndr_lgl_eng_nm lgl_eng_nm," ).append("\n"); 
		query.append("fo.ownr_nm" ).append("\n"); 
		query.append("from mdm_vendor mv, fms_owner fo" ).append("\n"); 
		query.append("where mv.vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("and mv.flet_mgmt_ownr_vndr_seq = fo.ownr_seq" ).append("\n"); 

	}
}