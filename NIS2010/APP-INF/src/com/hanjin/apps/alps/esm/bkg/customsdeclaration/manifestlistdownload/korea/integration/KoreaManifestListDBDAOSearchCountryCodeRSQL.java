/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KoreaManifestListDBDAOSearchCountryCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.07
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.07 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaManifestListDBDAOSearchCountryCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. O/B Biz no가 없을 경우 cnt_cd, cust_cd를 구한다. BKG_CUST_TP_CD= 'S'
	  * 2. I/B Biz no를 구하기 위해서는 먼저 cnt_cd, cust_cd를 먼저 구한다. BKG_CUST_TP_CD= 'C'
	  * 3. 2번 조회값이 없을 경우 아래에서 구한다. BKG_CUST_TP_CD= 'N'
	  * </pre>
	  */
	public KoreaManifestListDBDAOSearchCountryCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KoreaManifestListDBDAOSearchCountryCodeRSQL").append("\n"); 
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
		query.append("SELECT CUST_CNT_CD CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ CUST_CD" ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER" ).append("\n"); 
		query.append(" WHERE BKG_NO = 'a_bkg_no'" ).append("\n"); 
		query.append("   AND BKG_CUST_TP_CD = 'biz_no_op'" ).append("\n"); 

	}
}