/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeMgtDBDAOSearchContactPointListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.21 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeMgtDBDAOSearchContactPointListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Contact Point 리스트 조회
	  * </pre>
	  */
	public CodeMgtDBDAOSearchContactPointListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : CodeMgtDBDAOSearchContactPointListRSQL").append("\n"); 
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
		query.append("CLM_PTY_NO" ).append("\n"); 
		query.append(",	CLM_CNTC_PNT_SEQ" ).append("\n"); 
		query.append(",	CNTC_PNT_NM" ).append("\n"); 
		query.append(",	INTL_PHN_NO" ).append("\n"); 
		query.append(",	CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",	INTL_FAX_NO" ).append("\n"); 
		query.append(",	CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",	CNTC_PNT_EML" ).append("\n"); 
		query.append(",	CNTC_PNT_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM CNI_CNTC_PNT" ).append("\n"); 
		query.append("WHERE	CLM_PTY_NO = @[clm_pty_no]" ).append("\n"); 

	}
}