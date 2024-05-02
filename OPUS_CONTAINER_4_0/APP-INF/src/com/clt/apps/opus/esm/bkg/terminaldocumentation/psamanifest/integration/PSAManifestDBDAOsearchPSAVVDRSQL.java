/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.01 
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

public class PSAManifestDBDAOsearchPSAVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("etb_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dt2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPSAVVDRSQL").append("\n"); 
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
		query.append("SELECT VPS.VSL_CD," ).append("\n"); 
		query.append("       VPS.SKD_VOY_NO," ).append("\n"); 
		query.append("       VPS.SKD_DIR_CD," ).append("\n"); 
		query.append("       PSA.PSA_VSL_NM," ).append("\n"); 
		query.append("       PSA.PSA_VOY_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("       BKG_CSTMS_PSA_VVD PSA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE VPS.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND VPS.VPS_ETB_DT BETWEEN TO_DATE(@[etb_dt1], 'YYYY-MM-DD') AND TO_DATE(@[etb_dt2], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("   AND NVL(TURN_PORT_IND_CD, ' ') NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("   AND VPS.VSL_CD = PSA.VSL_CD(+)" ).append("\n"); 
		query.append("   AND VPS.SKD_VOY_NO = PSA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND VPS.SKD_DIR_CD = PSA.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND VPS.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY VPS.VSL_CD," ).append("\n"); 
		query.append("       VPS.SKD_VOY_NO," ).append("\n"); 
		query.append("       VPS.SKD_DIR_CD," ).append("\n"); 
		query.append("       PSA.PSA_VSL_NM," ).append("\n"); 
		query.append("       PSA.PSA_VOY_DIR_CD" ).append("\n"); 

	}
}