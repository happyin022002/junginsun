/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchBkgMarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchBkgMarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchBkgMarkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchBkgMarkRSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO," ).append("\n"); 
		query.append("  '  ' AS BL_SPLIT_NO," ).append("\n"); 
		query.append("  NVL(C.MK_SEQ, 1) AS BL_SEQ," ).append("\n"); 
		query.append("  NVL(UPPER(TRIM(REPLACE(C.MK_DESC, CHR(13)||CHR(10), ''))), 'N/M') AS DIFF_RMK," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    select max(CMD.CMDT_HS_CD)" ).append("\n"); 
		query.append("    from BKG_CNTR_MF_DESC CMD" ).append("\n"); 
		query.append("    where CMD.BKG_NO = A.BKG_NO ) CMDT_HS_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING A," ).append("\n"); 
		query.append("  BKG_BL_MK_DESC C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}