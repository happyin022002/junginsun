/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchBlESignatureListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.28
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.08.28 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOSearchBlESignatureListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBlESignatureList
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchBlESignatureListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("esignature_last_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_esig_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchBlESignatureListRSQL").append("\n"); 
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
		query.append("SELECT BL_ESIG_SEQ" ).append("\n"); 
		query.append("	, ESIG_N1ST_NM" ).append("\n"); 
		query.append("	, ESIG_LST_NM" ).append("\n"); 
		query.append("    ,(SELECT MC.SCONTI_CD FROM MDM_COUNTRY MC WHERE MC.CNT_CD = BKG_BL_ESIG.CNT_CD) AS REGION_NM" ).append("\n"); 
		query.append("	, CNT_CD" ).append("\n"); 
		query.append("	, ACT_FLG" ).append("\n"); 
		query.append("	, ESIG_FILE_NM" ).append("\n"); 
		query.append("	, (SELECT FILE_PATH_URL FROM COM_UPLD_FILE WHERE FILE_SAV_ID = ESIG_FILE_SAV_ID) AS ESIG_FILE_PATH_RMK" ).append("\n"); 
		query.append("	, ESIG_FILE_SAV_ID" ).append("\n"); 
		query.append("	, INIT_FILE_NM" ).append("\n"); 
		query.append("	, (SELECT FILE_PATH_URL FROM COM_UPLD_FILE WHERE FILE_SAV_ID = INIT_FILE_SAV_ID) AS INIT_FILE_PATH_RMK" ).append("\n"); 
		query.append("	, INIT_FILE_SAV_ID" ).append("\n"); 
		query.append("	, ESIG_DESC" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, TO_CHAR(CRE_DT, 'YYYY-MM-DD')  AS CRE_DT		--SJH.20141114.ADD" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, TO_CHAR(UPD_DT, 'YYYY-MM-DD')  AS UPD_DT		--SJH.20141114.ADD " ).append("\n"); 
		query.append("	, (SELECT FILE_PATH_URL || '/' || FILE_SAV_ID FROM COM_UPLD_FILE B WHERE B.FILE_SAV_ID = ESIG_FILE_SAV_ID) AS ESIG_SERVER_PATH" ).append("\n"); 
		query.append("    , (SELECT FILE_PATH_URL || '/' || FILE_SAV_ID FROM COM_UPLD_FILE B WHERE B.FILE_SAV_ID = INIT_FILE_SAV_ID) AS INIT_SERVER_PATH" ).append("\n"); 
		query.append("FROM BKG_BL_ESIG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${country_code} != '')" ).append("\n"); 
		query.append("	AND CNT_CD = @[country_code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${esignature_last_name} != '')" ).append("\n"); 
		query.append("	AND UPPER(ESIG_LST_NM) LIKE '%' || UPPER(@[esignature_last_name]) || '%'		--SJH.20141114.MOD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_esig_seq} != '')" ).append("\n"); 
		query.append("	AND BL_ESIG_SEQ = @[bl_esig_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}