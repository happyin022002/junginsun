/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchBkgCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchBkgCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchBkgCustomerRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchBkgCustomerRSQL").append("\n"); 
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
		query.append("       '  ' AS BL_SPLIT_NO," ).append("\n"); 
		query.append("       B.BKG_CUST_TP_CD," ).append("\n"); 
		query.append("       B.CUST_CNT_CD," ).append("\n"); 
		query.append("       B.CUST_SEQ," ).append("\n"); 
		query.append("       REPLACE(REPLACE(NVL(UPPER(B.CUST_NM), ''), CHR(180), CHR(39)), '’', '''') AS CUST_NM," ).append("\n"); 
		query.append("       REPLACE(REPLACE(NVL(UPPER(B.CUST_ADDR), ''), CHR(180), CHR(39)), '’', '''') AS CUST_ADDR," ).append("\n"); 
		query.append("       B.CUST_ZIP_ID," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_ASC(CP XPKMDM_CUST_CNTC_PNT) */" ).append("\n"); 
		query.append("               CP.INTL_PHN_NO||CP.PHN_NO" ).append("\n"); 
		query.append("          FROM MDM_CUST_CNTC_PNT CP" ).append("\n"); 
		query.append("         WHERE B.CUST_CNT_CD = CP.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND B.CUST_SEQ = CP.CUST_SEQ" ).append("\n"); 
		query.append("           AND CP.PHN_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS PHN_NO," ).append("\n"); 
		query.append("       B.CUST_FAX_NO AS FAX_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BOOKING A," ).append("\n"); 
		query.append("       BKG_CUSTOMER B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND (B.BKG_CUST_TP_CD = 'S' OR" ).append("\n"); 
		query.append("        B.BKG_CUST_TP_CD = 'C' OR" ).append("\n"); 
		query.append("        B.BKG_CUST_TP_CD = 'N')" ).append("\n"); 
		query.append(" ORDER BY BKG_CUST_TP_CD" ).append("\n"); 

	}
}