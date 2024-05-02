/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchChinaVslRgstFromChnCorrVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.05.22 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sang-Soo KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchChinaVslRgstFromChnCorrVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchChinaVslRgstFromChnCorrVvdRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchChinaVslRgstFromChnCorrVvdRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       PORT_CD," ).append("\n"); 
		query.append("       IB_VSL_NM AS COMM_VSL_NM ," ).append("\n"); 
		query.append("       IB_SKD_VOY_NO," ).append("\n"); 
		query.append("       IB_SKD_DIR_NM," ).append("\n"); 
		query.append("       OB_SKD_VOY_NO," ).append("\n"); 
		query.append("       OB_SKD_DIR_NM," ).append("\n"); 
		query.append("       TO_CHAR(ETA_DT, 'YYYY-MM-DD') AS ETA_DT," ).append("\n"); 
		query.append("       TO_CHAR(ETD_DT, 'YYYY-MM-DD') AS ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_CHN_CORR_VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE (VSL_CD, SKD_VOY_NO, SKD_DIR_CD, PORT_CD) IN (SELECT DISTINCT" ).append("\n"); 
		query.append("                                                            VSL_CD," ).append("\n"); 
		query.append("                                                            SKD_VOY_NO," ).append("\n"); 
		query.append("                                                            SKD_DIR_CD," ).append("\n"); 
		query.append("                                                            VPS_PORT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                       FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                      WHERE VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                                        AND VPS_ETB_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                                                     #if (${vvd} != '')" ).append("\n"); 
		query.append("                                                        AND VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                                        AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                                        AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                                                     #end" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 

	}
}