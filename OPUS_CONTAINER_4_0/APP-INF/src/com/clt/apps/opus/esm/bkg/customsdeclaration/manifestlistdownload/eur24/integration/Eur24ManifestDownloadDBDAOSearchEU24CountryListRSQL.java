/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchEU24CountryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.12.21 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchEU24CountryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOSearchEU24CountryListRSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchEU24CountryListRSQL(){
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
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchEU24CountryListRSQL").append("\n"); 
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
		query.append("/* Eu24CountryList VO */" ).append("\n"); 
		query.append("SELECT CNT_CD" ).append("\n"); 
		query.append(",CSTMS_DIV_ID" ).append("\n"); 
		query.append(",CSTMS_DIV_ID_SEQ" ).append("\n"); 
		query.append(",ATTR_CTNT1 AS CNT_CD" ).append("\n"); 
		query.append(",ATTR_CTNT2" ).append("\n"); 
		query.append(",ATTR_CTNT3" ).append("\n"); 
		query.append(",ATTR_CTNT4" ).append("\n"); 
		query.append(",ATTR_CTNT5" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CNT_CD = 'EU'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID='EU_MEMBER_CNT'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}