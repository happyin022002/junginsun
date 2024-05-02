/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodeMgtDBDAOSearchMiscCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.01.27 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeMgtDBDAOSearchMiscCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMiscCode
	  * </pre>
	  */
	public CodeMgtDBDAOSearchMiscCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_misc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clss_clm_misc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_misc_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : CodeMgtDBDAOSearchMiscCodeRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	CLSS_CLM_MISC_CD" ).append("\n"); 
		query.append(",	CLM_MISC_CD" ).append("\n"); 
		query.append(",   DP_SEQ" ).append("\n"); 
		query.append(",	CLM_MISC_ABBR_NM" ).append("\n"); 
		query.append(",	CLM_MISC_NM" ).append("\n"); 
		query.append(",	OLD_CLM_MISC_CD" ).append("\n"); 
		query.append(",	CLM_MISC_RMK" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR (CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR (UPD_DT, 'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("FROM CNI_MISC_CD" ).append("\n"); 
		query.append("WHERE	CLSS_CLM_MISC_CD = @[clss_clm_misc_cd]" ).append("\n"); 
		query.append("#if (${clm_misc_cd} != '') " ).append("\n"); 
		query.append("    AND CLM_MISC_CD LIKE     @[clm_misc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${clm_misc_nm} != '') " ).append("\n"); 
		query.append("    AND UPPER(CLM_MISC_NM) LIKE   UPPER(@[clm_misc_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DP_SEQ, CLM_MISC_CD" ).append("\n"); 

	}
}