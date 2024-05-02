/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchDgValidationByCntrKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.08
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.12.08 김민정
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

public class SpecialManifestDBDAOsearchDgValidationByCntrKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cntr_no를 입력시 validation
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchDgValidationByCntrKeyRSQL(){
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
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchDgValidationByCntrKeyRSQL").append("\n"); 
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
		query.append("#if (${cgo_opr_cd} == 'NYK')" ).append("\n"); 
		query.append("SELECT (SELECT NVL(MAX(CNTR_CGO_SEQ),0) + 1" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("         WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("           AND VSL_CD            = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("           AND SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("           AND SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("           AND PORT_CD           = @[port_cd]" ).append("\n"); 
		query.append("           AND BL_NO             = @[bl_no]" ).append("\n"); 
		query.append("           AND CNTR_NO           = @[cond_value]" ).append("\n"); 
		query.append("       )AS CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,CNTR_NO AS CNTR_REF_NO" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  FROM MST_CONTAINER" ).append("\n"); 
		query.append(" WHERE CNTR_NO = @[cond_value]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT A.SPCL_CGO_SEQ AS CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,A.CNTR_REF_NO" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  FROM SCG_PRNR_APRO_RQST_CGO A" ).append("\n"); 
		query.append(" WHERE BKG_REF_NO  = @[bl_no]" ).append("\n"); 
		query.append("   AND CNTR_REF_NO = @[cond_value]" ).append("\n"); 
		query.append("   AND AUTH_STS_CD = 'Y'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT A.SPCL_CGO_SEQ AS CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,A.CNTR_REF_NO" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  FROM SCG_PRNR_APRO_RQST_CGO A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_EUR_DG_HIS   B" ).append("\n"); 
		query.append(" WHERE A.BKG_REF_NO  = B.BL_NO" ).append("\n"); 
		query.append("   AND A.CNTR_REF_NO = B.CNTR_REF_NO" ).append("\n"); 
		query.append("   AND A.BKG_REF_NO  = @[bl_no]" ).append("\n"); 
		query.append("   AND B.CNTR_NO     = @[cond_value]" ).append("\n"); 
		query.append("   AND A.AUTH_STS_CD = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}