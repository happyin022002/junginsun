/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeMgtDBDAOModifyClassCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.11.17 박제성
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

public class CodeMgtDBDAOModifyClassCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ClassCode update
	  * </pre>
	  */
	public CodeMgtDBDAOModifyClassCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clss_clm_misc_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clss_clm_misc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clss_clm_misc_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : CodeMgtDBDAOModifyClassCodeUSQL").append("\n"); 
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
		query.append("UPDATE CNI_CLSS_MISC_CD SET" ).append("\n"); 
		query.append("CLSS_CLM_MISC_NM = @[clss_clm_misc_nm]" ).append("\n"); 
		query.append(",	CLSS_CLM_MISC_ABBR_NM = @[clss_clm_misc_abbr_nm]" ).append("\n"); 
		query.append(",	CLSS_CLM_MISC_RMK = @[clss_clm_misc_rmk]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("WHERE	CLSS_CLM_MISC_CD = @[clss_clm_misc_cd]" ).append("\n"); 

	}
}