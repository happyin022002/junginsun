/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.02.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public class TCharterIOContractDAOSelectCustomerRSQL implements ISQLTemplate{
	private final String sql="select \n" + 
 "mc.cust_lgl_eng_nm, \n" + 
 "fo.ownr_nm \n" + 
 "from mdm_customer mc, fms_owner fo \n" + 
 "where mc.cust_cnt_cd = @[cust_cnt_cd] \n" + 
 "and mc.cust_seq = @[cust_seq] \n" + 
 "and mc.fms_ownr_seq = fo.ownr_seq \n" + 
 "";
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOSelectCustomerRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOSelectCustomerRSQL(){

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

	}
	
	public String getSQL(){
		return sql;
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}
	
}
