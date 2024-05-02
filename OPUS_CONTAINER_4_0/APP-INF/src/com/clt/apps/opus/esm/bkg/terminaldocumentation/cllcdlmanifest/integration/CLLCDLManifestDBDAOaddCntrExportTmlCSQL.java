/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOaddCntrExportTmlCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.08
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOaddCntrExportTmlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * i
	  * </pre>
	  */
	public CLLCDLManifestDBDAOaddCntrExportTmlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_term_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_tmnl_brth_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_nyk_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_term_pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOaddCntrExportTmlCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_VVD_TML" ).append("\n");
		query.append("(" ).append("\n");
		query.append("VSL_CD" ).append("\n");
		query.append(",SKD_VOY_NO" ).append("\n");
		query.append(",SKD_DIR_CD" ).append("\n");
		query.append(",PORT_CD" ).append("\n");
		query.append(",PSA_TML_VSL_CD" ).append("\n");
		query.append(",EUR_TML_CD" ).append("\n");
		query.append(",CRE_USR_ID" ).append("\n");
		query.append(",CRE_DT" ).append("\n");
		query.append(",UPD_USR_ID" ).append("\n");
		query.append(",UPD_DT" ).append("\n");
		query.append(")" ).append("\n");
		query.append("VALUES" ).append("\n");
		query.append("(" ).append("\n");
		query.append("SUBSTR( @[form_nyk_vvd], 1, 4 )" ).append("\n");
		query.append(",SUBSTR( @[form_nyk_vvd], 5, 4 )" ).append("\n");
		query.append(",SUBSTR( @[form_nyk_vvd], 9, 1 )" ).append("\n");
		query.append(",@[form_term_pol]" ).append("\n");
		query.append(",@[form_term_vvd]" ).append("\n");
		query.append(",@[form_tmnl_brth_cd]" ).append("\n");
		query.append(",@[cre_usr_id]" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append(",@[upd_usr_id]" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append(")" ).append("\n");

	}
}