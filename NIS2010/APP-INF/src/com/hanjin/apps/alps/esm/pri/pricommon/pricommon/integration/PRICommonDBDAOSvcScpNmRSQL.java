/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.04.21 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration ;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see 
 * @since J2EE 1.4
 */

public class PRICommonDBDAOSvcScpNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Service Scope Code 의 full name 을 반환한다.
	  * </pre>
	  */
	public PRICommonDBDAOSvcScpNmRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("svc_scp_nm" ).append("\n"); 
		query.append("from mdm_svc_scp" ).append("\n"); 
		query.append("where	svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("and	delt_flg = 'N'" ).append("\n"); 

	}
}