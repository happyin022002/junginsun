/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchCstmsPortCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchCstmsPortCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCstmsPortCd
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchCstmsPortCdRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchCstmsPortCdRSQL").append("\n"); 
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
		query.append("SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("  FROM (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("             , ROW_NUMBER() OVER(ORDER BY CLPT_SEQ) AS RNUM" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT SKD2.VPS_PORT_CD, SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("                  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD SKD1 -- POL" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD SKD2 -- CSTMS_PORT_CD" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD SKD3 -- POD" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                AND SKD1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                AND SKD1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                AND SKD1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                AND SKD1.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                AND SKD1.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND NVL(SKD1.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                AND SKD1.VSL_CD        = SKD2.VSL_CD" ).append("\n"); 
		query.append("                AND SKD1.SKD_VOY_NO    = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND SKD1.SKD_DIR_CD    = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND SUBSTR(SKD2.VPS_PORT_CD, 1, 2) IN ('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT WHERE CNT_CD = 'US' AND CSTMS_DIV_ID = 'US_CNT_CD_LIST'))" ).append("\n"); 
		query.append("                AND SKD1.CLPT_SEQ < SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("                AND NVL(SKD2.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                AND SKD1.VSL_CD         = SKD3.VSL_CD" ).append("\n"); 
		query.append("                AND SKD1.SKD_VOY_NO     = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND SKD1.SKD_DIR_CD     = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND SKD3.VPS_PORT_CD    = VVD.POD_CD" ).append("\n"); 
		query.append("                AND SKD3.CLPT_IND_SEQ   = VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND SKD2.CLPT_SEQ  <= SKD3.CLPT_SEQ" ).append("\n"); 
		query.append("                AND NVL(SKD3.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                AND VVD.POD_CD = @[pod_cd]) SKD" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE RNUM = 1" ).append("\n"); 

	}
}