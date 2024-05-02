/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationDBDAOsearchInVVDNEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOsearchInVVDNEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInVVDNEta
	  * </pre>
	  */
	public DMTCalculationDBDAOsearchInVVDNEtaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOsearchInVVDNEtaRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED USE_NL( V K )" ).append("\n"); 
		query.append("                    INDEX    ( V XPKBKG_VVD )" ).append("\n"); 
		query.append("                    INDEX_DESC    ( K XPKVSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("       V.VSL_CD" ).append("\n"); 
		query.append("      ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,TO_CHAR (K.VPS_ETA_DT, 'YYYYMMDD') VPS_ETA_DT" ).append("\n"); 
		query.append("	  ,V.BKG_NO" ).append("\n"); 
		query.append("  FROM BKG_VVD V" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append(" WHERE V.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND (V.VSL_PRE_PST_CD, V.VSL_SEQ) =" ).append("\n"); 
		query.append("          (SELECT /*+ INDEX( VV XPKBKG_VVD) */" ).append("\n"); 
		query.append("                  VV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                 ,VV.VSL_SEQ" ).append("\n"); 
		query.append("             FROM BKG_VVD VV" ).append("\n"); 
		query.append("            WHERE VV.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("              AND VV.POD_CD = V.POD_CD" ).append("\n"); 
		query.append("              AND ROWNUM = 1)" ).append("\n"); 
		query.append("   AND V.VSL_CD = K.VSL_CD(+)" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = K.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = K.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND V.POD_CD = K.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND NVL (K.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("   AND V.POD_CLPT_IND_SEQ = K.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}