/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchDgValidationByVvdKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.21
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.09.21 박성진
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

public class PSASpecialManifestDBDAOpsaSearchDgValidationByVvdKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bl_no / pol_cd / pod_cd를 입력시 validation
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchDgValidationByVvdKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchDgValidationByVvdKeyRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CHECK_CNT" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A" ).append("\n"); 
		query.append("       , BKG_VVD B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   A.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("AND   A.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("AND   B.VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   B.SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   B.SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond_type} == 'bl_no') " ).append("\n"); 
		query.append("	AND   A.BL_NO         = @[cond_value]" ).append("\n"); 
		query.append("#elseif (${cond_type} == 'pol_cd') " ).append("\n"); 
		query.append("	AND   B.POL_CD        = @[cond_value]" ).append("\n"); 
		query.append("#elseif (${cond_type} == 'pod_cd') " ).append("\n"); 
		query.append("	AND   B.POD_CD        = @[cond_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}