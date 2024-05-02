/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.02.03 
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

public class TCharterIOContractDAOSelectLastContractSeqRSQL implements ISQLTemplate{
	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * adf
	  * </pre>
	  */
	public TCharterIOContractDAOSelectLastContractSeqRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select NVL(TO_NUMBER(MAX(SUBSTR(flet_ctrt_no,13,3))),0) flet_ctrt_no" ).append("\n"); 
		query.append("from fms_contract" ).append("\n"); 
		query.append("where vsl_cd = @[vsl_cd]" ).append("\n"); 

	}
	
}
