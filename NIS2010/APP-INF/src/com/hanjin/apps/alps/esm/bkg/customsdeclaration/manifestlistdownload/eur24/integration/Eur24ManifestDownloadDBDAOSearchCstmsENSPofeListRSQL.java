/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchCstmsENSPofeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchCstmsENSPofeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 개요 : BKG_CSTMS_EUR_BL에서 ENS가 이루어진 1st Port code와 Yard Code를 가져온다
	  * 사용 : ESM_BKG_1105.do(Diversion Request)에서 사용
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchCstmsENSPofeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchCstmsENSPofeListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.VSL_CD," ).append("\n"); 
		query.append("  A.SKD_VOY_NO," ).append("\n"); 
		query.append("  A.SKD_DIR_CD," ).append("\n"); 
		query.append("  A.CSTMS_PORT_CD EU_1ST_PORT," ).append("\n"); 
		query.append("  CSTMS_YD_CD EU_1ST_PORT_YD_CD," ).append("\n"); 
		query.append("  NVL(A.CSTMS_CLPT_IND_SEQ,'1') AS EU_1ST_PORT_CLPT_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_BL A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.VSL_CD = SUBSTR(@[p_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = SUBSTR(@[p_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = SUBSTR(@[p_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("  AND A.MVMT_REf_NO IS NOT NULL" ).append("\n"); 

	}
}