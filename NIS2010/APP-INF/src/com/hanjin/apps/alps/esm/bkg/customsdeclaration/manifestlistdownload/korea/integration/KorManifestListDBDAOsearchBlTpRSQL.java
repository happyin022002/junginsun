/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KorManifestListDBDAOsearchBlTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchBlTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL TYPE 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchBlTpRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchBlTpRSQL").append("\n"); 
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
		query.append("SELECT DECODE( BCO_FLG, 'X', DECODE(CUST_NM_FLG, 'Y','S','C') , BCO_FLG) BL_TP  " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("  (SELECT CUST.BKG_NO" ).append("\n"); 
		query.append("          , CUST.CUST_NM" ).append("\n"); 
		query.append("          , CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("          , CUST.CUST_SEQ" ).append("\n"); 
		query.append("          , MDM.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("          , DECODE( MDM.RVIS_CNTR_CUST_TP_CD, 'B', 'S', 'N', 'C', 'X') AS BCO_FLG" ).append("\n"); 
		query.append("          ,(SELECT 'Y'" ).append("\n"); 
		query.append("              FROM BKG_CUSTOMER BCUST" ).append("\n"); 
		query.append("             WHERE BCUST.BKG_CUST_TP_CD = CUST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("               AND BCUST.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("               AND ( TRIM(UPPER(BCUST.CUST_NM)) LIKE 'TO ORDER%'" ).append("\n"); 
		query.append("                   OR TRIM(UPPER(BCUST.CUST_NM)) LIKE 'TO THE ORDER%'" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("               AND ROWNUM =1" ).append("\n"); 
		query.append("           ) CUST_NM_FLG" ).append("\n"); 
		query.append("    FROM BKG_CUSTOMER CUST " ).append("\n"); 
		query.append("         , MDM_CUSTOMER MDM" ).append("\n"); 
		query.append("    WHERE CUST.CUST_CNT_CD = MDM.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND CUST.CUST_SEQ =  MDM.CUST_SEQ(+)" ).append("\n"); 
		query.append("    AND CUST.BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("    AND CUST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}