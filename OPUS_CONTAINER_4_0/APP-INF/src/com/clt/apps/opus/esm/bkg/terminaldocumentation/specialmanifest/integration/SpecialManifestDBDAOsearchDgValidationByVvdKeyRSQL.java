/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchDgValidationByVvdKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.11.27 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchDgValidationByVvdKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bl_no / pol_cd / pod_cd를 입력시 validation
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchDgValidationByVvdKeyRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchDgValidationByVvdKeyRSQL").append("\n"); 
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
		query.append("SELECT B.POL_CD" ).append("\n"); 
		query.append("      ,B.POD_CD" ).append("\n"); 
		query.append("      ,'NYK' AS CGO_OPR_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING A" ).append("\n"); 
		query.append("      ,BKG_VVD     B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("   AND B.VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND B.SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND B.SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#if (${cond_type} == 'bl_no') " ).append("\n"); 
		query.append("   AND A.BL_NO         = @[cond_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${d_type} == 'D' || ${d_type} == 'DO' || ${d_type} == 'O')" ).append("\n"); 
		query.append("   AND B.POD_CD        = @[port_cd]" ).append("\n"); 
		query.append("#elseif (${d_type} == 'L' || ${d_type} == 'PL' || ${d_type} == 'P')" ).append("\n"); 
		query.append("   AND B.POL_CD        = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT RQST.POL_CD" ).append("\n"); 
		query.append("      ,RQST.POD_CD" ).append("\n"); 
		query.append("      ,(SELECT CGO.CGO_OPR_CD" ).append("\n"); 
		query.append("          FROM SCG_PRNR_APRO_RQST_CGO CGO" ).append("\n"); 
		query.append("         WHERE RQST.BKG_REF_NO = CGO.BKG_REF_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS CGO_OPR_CD" ).append("\n"); 
		query.append("  FROM SCG_PRNR_APRO_RQST RQST" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND RQST.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND RQST.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND RQST.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#if (${cond_type} == 'bl_no') " ).append("\n"); 
		query.append("   AND RQST.BKG_REF_NO = @[cond_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${d_type} == 'D' || ${d_type} == 'DO' || ${d_type} == 'O')" ).append("\n"); 
		query.append("   AND RQST.POD_CD     = @[port_cd]" ).append("\n"); 
		query.append("#elseif (${d_type} == 'L' || ${d_type} == 'PL' || ${d_type} == 'P')" ).append("\n"); 
		query.append("   AND RQST.POL_CD     = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}