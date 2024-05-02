/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2009.03.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public class TCharterIOContractDAOFmsChtrPtyFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOFmsChtrPtyFileRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOFmsChtrPtyFileRSQL(){
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

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_file_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select /*+ INDEX(fc XPKFMS_CHTR_PTY_FILE) */" ).append("\n"); 
		query.append("file_seq," ).append("\n"); 
		query.append("flet_file_tp_cd," ).append("\n"); 
		query.append("file_nm," ).append("\n"); 
		query.append("file_desc," ).append("\n"); 
		query.append("'0' file_download," ).append("\n"); 
		query.append("file_sav_id" ).append("\n"); 
		query.append("from fms_chtr_pty_file fc" ).append("\n"); 
		query.append("where flet_ctrt_no = @[flet_ctrt_no]" ).append("\n"); 
		query.append("and flet_file_tp_cd = @[flet_file_tp_cd]" ).append("\n"); 

	}
}