/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOcheckIfCCNAvalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOcheckIfCCNAvalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkIfCCNAval
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOcheckIfCCNAvalRSQL(){
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOcheckIfCCNAvalRSQL").append("\n"); 
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
		query.append("SELECT  VSL_CD" ).append("\n"); 
		query.append("  FROM  BKG_CSTMS_CND_VSL" ).append("\n"); 
		query.append(" WHERE  VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND  SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND  SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if (${cnt_cd} == 'CA') " ).append("\n"); 
		query.append("   AND  PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND  PORT_CD = (SELECT SUBSTR(MIN(TO_CHAR(VPS_ETA_DT, 'YYYYMMDDHH24MISS')||VPS_PORT_CD),15)" ).append("\n"); 
		query.append("                     FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                    WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                      AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                      AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                      AND VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                      AND NVL(SKD_CNG_STS_CD,'X') <> 'S')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND  REPLACE(CVY_REF_NO, ' ', '') IS NOT NULL" ).append("\n"); 

	}
}