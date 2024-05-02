/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchMainPartiesRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOpsaSearchMainPartiesRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAIN PARTIES 기본정보를 조회한다.
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchMainPartiesRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchMainPartiesRSQL").append("\n"); 
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
		query.append("    'CG' PARTY_TYPE" ).append("\n"); 
		query.append("    ,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC() PARTY_ID" ).append("\n"); 
		query.append("	,'' AUTHORIZED" ).append("\n"); 
		query.append("	,B.OFC_ADDR	ADDRESS1" ).append("\n"); 
		query.append("	,'' ADDRESS2" ).append("\n"); 
		query.append("	,'' ADDRESS3" ).append("\n"); 
		query.append("	,'' ADDRESS4" ).append("\n"); 
		query.append("	,'' ADDRESS5" ).append("\n"); 
		query.append("    ,A.USR_NM       CONTACT" ).append("\n"); 
		query.append("    ,B.OFC_PHN_NO   PHONE" ).append("\n"); 
		query.append("    ,B.OFC_FAX_NO   FAX" ).append("\n"); 
		query.append("	,'' REF1" ).append("\n"); 
		query.append("FROM COM_USER A" ).append("\n"); 
		query.append("     ,MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND   USR_ID = @[usr_id]" ).append("\n"); 

	}
}