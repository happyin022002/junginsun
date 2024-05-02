/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOsearchBlCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOsearchBlCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EUR24H CNTR검색용 SQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOsearchBlCntrRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOsearchBlCntrRSQL").append("\n"); 
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
		query.append("  VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("  BL_NO," ).append("\n"); 
		query.append("  CSTMS_PORT_CD," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  FULL_MTY_CD," ).append("\n"); 
		query.append("  PCK_QTY," ).append("\n"); 
		query.append("  PCK_TP_CD," ).append("\n"); 
		query.append("  MEAS_QTY," ).append("\n"); 
		query.append("  MEAS_UT_CD," ).append("\n"); 
		query.append("  ACT_WGT," ).append("\n"); 
		query.append("  WGT_UT_CD," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  CMDT_DESC," ).append("\n"); 
		query.append("  (SELECT SEAL_NO" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_SEAL_NO S" ).append("\n"); 
		query.append("    WHERE S.VSL_CD||S.SKD_VOY_NO||S.SKD_DIR_CD = C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND S.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("      AND S.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("      AND S.CSTMS_PORT_CD = C.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      AND S.SEAL_NO_SEQ = 1) SEAL_NO ," ).append("\n"); 
		query.append("  (SELECT SEAL_NO" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_SEAL_NO S" ).append("\n"); 
		query.append("    WHERE S.VSL_CD||S.SKD_VOY_NO||S.SKD_DIR_CD = C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND S.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("      AND S.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("      AND S.CSTMS_PORT_CD = C.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      AND SEAL_NO_SEQ = 2) SEAL_NO2" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_CNTR C" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 

	}
}