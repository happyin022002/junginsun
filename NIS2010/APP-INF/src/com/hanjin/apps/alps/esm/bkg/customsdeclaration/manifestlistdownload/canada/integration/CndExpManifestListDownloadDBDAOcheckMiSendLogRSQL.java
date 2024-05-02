/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpManifestListDownloadDBDAOcheckMiSendLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpManifestListDownloadDBDAOcheckMiSendLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CndExpManifestListDownloadDBDAOcheckMiSendLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndExpManifestListDownloadDBDAOcheckMiSendLogRSQL").append("\n"); 
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
		query.append("SELECT A.CNT_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_SND_LOG A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_AMER_BL B" ).append("\n"); 
		query.append(" WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("   AND B.CNT_CD = 'CA'" ).append("\n"); 
		query.append("   AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.POL_CD = B.CSTMS_POL_CD" ).append("\n"); 
		query.append("   AND A.POD_CD = B.CSTMS_POD_CD" ).append("\n"); 
		query.append("   AND A.TRSM_MSG_TP_ID IN ('A6A','S10','E10')" ).append("\n"); 

	}
}