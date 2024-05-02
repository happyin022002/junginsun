/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOSearchCMSServiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.01.28 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchCMSServiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VOC NO별 클레임정보 조회
	  * </pre>
	  */
	public ClaimMainDBDAOSearchCMSServiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchCMSServiceRSQL").append("\n"); 
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
		query.append("    CGO_CLM_NO" ).append("\n"); 
		query.append("  , CGO_CLM_STS_CD" ).append("\n"); 
		query.append("  , CLMT_USD_AMT" ).append("\n"); 
		query.append("  , CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append("  , CGO_CLM_TP_CD" ).append("\n"); 
		query.append("  , CRM_VOC_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CLM_V" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 
		query.append("  AND " ).append("\n"); 
		query.append("    CRM_VOC_NO IS NOT NULL" ).append("\n"); 

	}
}