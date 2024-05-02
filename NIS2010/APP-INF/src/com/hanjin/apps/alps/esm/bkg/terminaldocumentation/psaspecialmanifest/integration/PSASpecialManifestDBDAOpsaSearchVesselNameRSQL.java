/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchVesselNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.05
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.10.05 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOpsaSearchVesselNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Code롤 Name울 조회한다.
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchVesselNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchVesselNameRSQL").append("\n"); 
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
		query.append("    DECODE(NVL(A.PSA_VSL_NM, ''), '', B.VSL_ENG_NM, A.PSA_VSL_NM) AS VSL_ENG_NAME" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT VSL_CD, PSA_VSL_NM" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_PSA_VVD" ).append("\n"); 
		query.append("    WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("    AND   SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("    AND   SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("    SELECT VSL_CD, VSL_ENG_NM" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("    WHERE VSL_CD = @[frm_vsl_cd]" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("WHERE A.VSL_CD(+) = B.VSL_CD" ).append("\n"); 

	}
}