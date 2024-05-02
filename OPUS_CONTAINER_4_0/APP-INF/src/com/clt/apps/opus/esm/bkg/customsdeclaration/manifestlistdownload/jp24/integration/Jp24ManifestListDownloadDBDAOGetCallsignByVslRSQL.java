/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOGetCallsignByVslRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOGetCallsignByVslRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOGetCallsignByVslRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOGetCallsignByVslRSQL").append("\n"); 
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
		query.append("SELECT (SELECT NVL(J_SKD.CALL_SGN_NO, M_CNTR.CALL_SGN_NO)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_VSL_SKD J_SKD" ).append("\n"); 
		query.append("         WHERE J_SKD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND J_SKD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND J_SKD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           AND J_SKD.POL_CD = @[pol_cd]) AS CALL_SGN_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (SELECT NVL(NVL(J_SKD.IB_CSSM_VOY_NO, V_SKD.IB_CSSM_VOY_NO), SUBSTR(@[vvd], 5, 5))" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD V_SKD," ).append("\n"); 
		query.append("               BKG_CSTMS_ADV_JP_VSL_SKD J_SKD" ).append("\n"); 
		query.append("         WHERE V_SKD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND V_SKD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND V_SKD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           AND V_SKD.VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("           AND V_SKD.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("           AND V_SKD.VSL_CD = J_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("           AND V_SKD.SKD_VOY_NO = J_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND V_SKD.SKD_DIR_CD = J_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND V_SKD.VPS_PORT_CD = J_SKD.POL_CD) AS IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM MDM_VSL_CNTR M_CNTR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 

	}
}