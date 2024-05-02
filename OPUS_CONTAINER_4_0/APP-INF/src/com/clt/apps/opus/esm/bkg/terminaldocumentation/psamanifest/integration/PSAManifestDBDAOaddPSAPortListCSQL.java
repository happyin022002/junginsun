/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestDBDAOaddPSAPortListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.22
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YONG JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOaddPSAPortListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * PSA Port에 대한 신규추가. searchPSAPortExistChk에서 No data 면 실행됨
	  * </pre>
	  */
	public PSAManifestDBDAOaddPSAPortListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOaddPSAPortListCSQL").append("\n");
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
		query.append("INSERT" ).append("\n");
		query.append("INTO BKG_CSTMS_PSA_PORT" ).append("\n");
		query.append("( LOC_CD" ).append("\n");
		query.append(", PSA_LOC_CD" ).append("\n");
		query.append(", TML_CD" ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", CRE_DT" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(", UPD_DT" ).append("\n");
		query.append(")" ).append("\n");
		query.append("VALUES" ).append("\n");
		query.append("(" ).append("\n");
		query.append("@[loc_cd]" ).append("\n");
		query.append(", @[psa_loc_cd]" ).append("\n");
		query.append(", trim(@[loc_cd]||@[tml_cd])" ).append("\n");
		query.append(", @[user_id]" ).append("\n");
		query.append(", sysdate" ).append("\n");
		query.append(", @[user_id]" ).append("\n");
		query.append(", sysdate" ).append("\n");
		query.append(")" ).append("\n");

	}
}