/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchBlMdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchBlMdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlMd
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchBlMdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("A.BL_NO," ).append("\n"); 
		query.append("'  ' BL_NO_SPLIT," ).append("\n"); 
		query.append("C.MK_SEQ," ).append("\n"); 
		query.append("NVL(UPPER(TRIM(REPLACE(C.MK_DESC, CHR(13)||CHR(10),''))),'N/M') MK_DESC," ).append("\n"); 
		query.append("UPPER(@[cstms_desc]) CSTMS_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING A," ).append("\n"); 
		query.append("BKG_BL_MK_DESC C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND  A.BKG_NO       = C.BKG_NO" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchBlMdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}