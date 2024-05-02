/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PSAManifestDBDAOSearchVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOSearchVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSAManifestDBDAOSearchVslInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOSearchVslInfoRSQL").append("\n"); 
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
		query.append("SELECT '9' AS STATUS," ).append("\n"); 
		query.append("       P.VSL_CD||P.SKD_VOY_NO||P.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       UPPER(TRIM(PV.PSA_VOY_DIR_CD)) AS CON_VVD," ).append("\n"); 
		query.append("       UPPER(TRIM(PV.PSA_VSL_NM)) AS VSL_FULLNAME," ).append("\n"); 
		query.append("       V.VSL_RGST_CNT_CD AS VSL_NATION_CD," ).append("\n"); 
		query.append("       TO_CHAR(P.VPS_ETA_DT, 'YYYYMMDD') AS ETA," ).append("\n"); 
		query.append("       TO_CHAR(P.VPS_ETD_DT, 'YYYYMMDD') AS ETD," ).append("\n"); 
		query.append("       'L' AS TS_IND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD P," ).append("\n"); 
		query.append("       MDM_VSL_CNTR V," ).append("\n"); 
		query.append("       MDM_LOCATION L," ).append("\n"); 
		query.append("       BKG_CSTMS_PSA_VVD PV" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND P.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND P.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND P.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND P.VPS_PORT_CD = 'SGSIN'" ).append("\n"); 
		query.append("   AND L.LOC_CD=P.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND V.VSL_CD(+) = P.VSL_CD" ).append("\n"); 
		query.append("   AND PV.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("   AND PV.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND PV.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 

	}
}