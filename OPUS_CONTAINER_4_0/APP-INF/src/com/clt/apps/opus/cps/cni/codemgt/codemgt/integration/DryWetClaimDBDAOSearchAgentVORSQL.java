/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchAgentVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.23 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchAgentVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agent 에 관련된 전화번호, e-Mail 정보를 조회한다
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchAgentVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchAgentVORSQL").append("\n"); 
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
		query.append("NVL(INTL_PHN_NO,'')||DECODE(INTL_PHN_NO,NULL,'','-')||NVL(PHN_NO,'') PHN_NO," ).append("\n"); 
		query.append("PTY_EML" ).append("\n"); 
		query.append("FROM CNI_PARTY" ).append("\n"); 
		query.append("WHERE	CLM_PTY_NO = @[clm_pty_no]" ).append("\n"); 

	}
}