/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchEU24RcvErrorCodeTableRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.17 
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

public class Eur24ManifestDownloadDBDAOSearchEU24RcvErrorCodeTableRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOSearchEU24RcvErrorCodeTableRSQL
	  * 2012.01.12 김보배 [CHM-201215563] [BKG] [ENS] Italia Error Code description추가 및 로직보완
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchEU24RcvErrorCodeTableRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchEU24RcvErrorCodeTableRSQL").append("\n"); 
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
		query.append("/* EU24RcvErrorCodeTable  VO */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	 CNT_CD" ).append("\n"); 
		query.append("	,CSTMS_DIV_ID AS EU24_ERR_CD" ).append("\n"); 
		query.append("	,ATTR_CTNT1   AS ERROR_CODE" ).append("\n"); 
		query.append("	,ATTR_CTNT2   AS ERROR_DESCRIPTION" ).append("\n"); 
		query.append("	,ATTR_CTNT3   AS REMARK" ).append("\n"); 
		query.append("	,CSTMS_DIV_ID_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID = 'EU24_ERR_CD'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("	AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CNT_CD, length(ERROR_CODE),CONVERT(ERROR_CODE, 'US8ICL'), CSTMS_DIV_ID_SEQ" ).append("\n"); 

	}
}