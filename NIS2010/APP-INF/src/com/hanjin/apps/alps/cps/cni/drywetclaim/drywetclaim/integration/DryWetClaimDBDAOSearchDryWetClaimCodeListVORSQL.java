/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchDryWetClaimCodeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.23 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchDryWetClaimCodeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dry & Wet Claim의 MISCELLANEOUS  코드를 조회한다
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchDryWetClaimCodeListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clss_clm_misc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchDryWetClaimCodeListVORSQL").append("\n"); 
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
		query.append("CLM_MISC_CD" ).append("\n"); 
		query.append(",	   CLM_MISC_NM" ).append("\n"); 
		query.append("FROM   CNI_MISC_CD" ).append("\n"); 
		query.append("WHERE  CLSS_CLM_MISC_CD = @[clss_clm_misc_cd]" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}