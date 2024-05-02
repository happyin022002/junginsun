/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PSAManifestDBDAOsearchBkgDataForPsaBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchBkgDataForPsaBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAKE PSA BKG WITH ALPS BKG SELECT ALPS DATA FOR PSA_BKG
	  * </pre>
	  */
	public PSAManifestDBDAOsearchBkgDataForPsaBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchBkgDataForPsaBkgRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_STS_CD" ).append("\n"); 
		query.append("     , A.POL_CD     " ).append("\n"); 
		query.append("     , A.POD_CD     " ).append("\n"); 
		query.append("     , DECODE( A.BKG_CGO_TP_CD, 'P', 'E', 'R', 'E', 'F' )  BKG_CGO_TP_CD" ).append("\n"); 
		query.append("     , NVL( A.SPCL_HIDE_FLG, '0' ) SPCL_HIDE_FLG" ).append("\n"); 
		query.append("     , A.DEL_CD" ).append("\n"); 
		query.append("	 , A.DEL_NOD_CD BKG_YD_CD_DEL" ).append("\n"); 
		query.append("     , A.SLAN_CD" ).append("\n"); 
		query.append("	 , (" ).append("\n"); 
		query.append("		SELECT SLAN_CD" ).append("\n"); 
		query.append("        FROM BKG_VVD" ).append("\n"); 
		query.append("         WHERE BKG_NO      = A.BKG_NO" ).append("\n"); 
		query.append("         AND POL_CD = 'SGSIN'" ).append("\n"); 
		query.append("         AND POD_CD = 'KRPUS'" ).append("\n"); 
		query.append("         AND ROWNUM =1 " ).append("\n"); 
		query.append("     )DOUBLE_CALL_LANE_CHECK" ).append("\n"); 
		query.append("     , TRANSLATE(SUBSTR(A.XTER_RMK, 1, 140),chr(13)||chr(10),' ') INTER_RMK" ).append("\n"); 
		query.append("     , NVL(A.DCGO_FLG, '0') DCGO_FLG" ).append("\n"); 
		query.append("     , NVL(A.PRCT_FLG, '0') PRCT_FLG" ).append("\n"); 
		query.append("  FROM BKG_BOOKING A" ).append("\n"); 
		query.append(" WHERE A.BKG_NO      = @[bkg_no]" ).append("\n"); 

	}
}