/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestDBDAOaddPSAVVDInfoCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.04
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOaddPSAVVDInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * PSA VSL 정보 입력
	  * </pre>
	  */
	public PSAManifestDBDAOaddPSAVVDInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_voy_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ").append("\n");
		query.append("FileName : PSAManifestDBDAOaddPSAVVDInfoCSQL").append("\n");
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
		query.append("INTO BKG_CSTMS_PSA_VVD" ).append("\n");
		query.append("( VSL_CD" ).append("\n");
		query.append(", SKD_VOY_NO" ).append("\n");
		query.append(", SKD_DIR_CD" ).append("\n");
		query.append(", PSA_VSL_NM" ).append("\n");
		query.append(", PSA_VOY_DIR_CD" ).append("\n");
		query.append(", CRE_DT" ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", UPD_DT" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(")" ).append("\n");
		query.append("VALUES" ).append("\n");
		query.append("( @[vsl_cd]" ).append("\n");
		query.append(", @[skd_voy_no]" ).append("\n");
		query.append(", @[skd_dir_cd]" ).append("\n");
		query.append(", UPPER(TRIM(REPLACE(@[psa_vsl_nm], CHR(10), '')))" ).append("\n");
		query.append(", UPPER(TRIM(@[psa_voy_dir_cd]))" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append(", @[user_id]" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append(", @[user_id]" ).append("\n");
		query.append(")" ).append("\n");

	}
}