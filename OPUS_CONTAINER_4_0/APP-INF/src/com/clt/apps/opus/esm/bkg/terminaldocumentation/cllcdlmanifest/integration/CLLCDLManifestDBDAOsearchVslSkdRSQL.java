/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchVslSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchVslSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVslSkd
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchVslSkdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchVslSkdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	VPS.VSL_CD||VPS.SKD_VOY_NO||VPS.SKD_DIR_CD||'  ('||VSL.VSL_ENG_NM||')' VVD_CD" ).append("\n"); 
		query.append("	, VSL.VSL_ENG_NM||' '||VPS.SKD_VOY_NO||VPS.SKD_DIR_CD VVD_CD2" ).append("\n"); 
		query.append("	, VSL.VSL_ENG_NM||' '||VPS.SKD_VOY_NO||VPS.SKD_DIR_CD||'('||@[in_vvd_cd]||')' VVD_CD3" ).append("\n"); 
		query.append("	, NVL(LO.UN_LOC_CD, VPS.VPS_PORT_CD) UN_LOC_CD" ).append("\n"); 
		query.append("	, TO_CHAR(VPS.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') VPS_ETA_DT" ).append("\n"); 
		query.append("	, TO_CHAR(VPS.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') VPS_ETD_DT" ).append("\n"); 
		query.append("	, TO_CHAR(VPS.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') VPS_ETB_DT" ).append("\n"); 
		query.append("	, VSL.VSL_ENG_NM||' '||VPS.OB_CSSM_VOY_NO AS CSSM_VVD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	VSK_VSL_PORT_SKD VPS, " ).append("\n"); 
		query.append("	MDM_VSL_CNTR VSL, " ).append("\n"); 
		query.append("	MDM_LOCATION LO," ).append("\n"); 
		query.append("    (SELECT TRIM(COLUMN_VALUE) AS VVD_CD FROM table(BKG_SPLIT_FNC(@[in_vvd_cd],','))) TEMP " ).append("\n"); 
		query.append("WHERE VPS.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("AND VPS.VSL_CD = SUBSTR(TEMP.VVD_CD,1,4)" ).append("\n"); 
		query.append("AND VPS.SKD_VOY_NO = SUBSTR(TEMP.VVD_CD,5,4)" ).append("\n"); 
		query.append("AND VPS.SKD_DIR_CD = SUBSTR(TEMP.VVD_CD,9,1)" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("AND SUBSTR(VPS.YD_CD,6,2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}