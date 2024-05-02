/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchContainerManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchContainerManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaContainerManifestListVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchContainerManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchContainerManifestListRSQL").append("\n"); 
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
		query.append("SELECT  BL_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CMDT_GDS_SEQ" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",PCK_QTY" ).append("\n"); 
		query.append(",AMS_PCK_TP_CD" ).append("\n"); 
		query.append(",GRS_WGT" ).append("\n"); 
		query.append(",WGT_UT_CD" ).append("\n"); 
		query.append(",MK_DESC" ).append("\n"); 
		query.append(",CGO_DESC" ).append("\n"); 
		query.append(",HAMO_CMDT_CD" ).append("\n"); 
		query.append(",NVL(PRIOR_NTC_SND_FLG, 'N') AS PRIOR_NTC_SND_FLG" ).append("\n"); 
		query.append(",DECODE(PRIOR_NTC_CFM_FLG,'N','0','Y','1') AS PRIOR_NTC_CFM_FLG" ).append("\n"); 
		query.append(",TO_CHAR(PRIOR_NTC_CFM_DT, 'YYYYMMDD') AS PRIOR_NTC_CFM_DT" ).append("\n"); 
		query.append(",PRIOR_NTC_RMK" ).append("\n"); 
		query.append(",'' AS BDR_FLG" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_ADV_CNTR_MF" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND   BL_NO = @[bl_no]" ).append("\n"); 
		query.append("--#if (${cntr_no} != '')" ).append("\n"); 
		query.append("--AND   CNTR_NO = [cntr_no]" ).append("\n"); 
		query.append("--#end" ).append("\n"); 
		query.append("ORDER BY CMDT_GDS_SEQ" ).append("\n"); 

	}
}