/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchBkgCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.04 
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       BL_NO" ).append("\n"); 
		query.append("     , BL_SPLIT_NO" ).append("\n"); 
		query.append("     , BKG_CUST_TP_CD" ).append("\n"); 
		query.append("     , CASE WHEN BKG_CUST_TP_CD = 'C' AND CUST_TO_ORD_FLG   ='Y' THEN MAX(DECODE(BKG_CUST_TP_CD,'N',CUST_CNT_CD,NULL)) OVER()" ).append("\n"); 
		query.append("            ELSE CUST_CNT_CD" ).append("\n"); 
		query.append("       END AS CUST_CNT_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , CASE WHEN BKG_CUST_TP_CD = 'C' AND CUST_TO_ORD_FLG   ='Y' THEN 'TO ORDER'" ).append("\n"); 
		query.append("            WHEN BKG_CUST_TP_CD = 'N' AND SAM_CNEE_NTFY_FLG ='Y' THEN MAX(DECODE(BKG_CUST_TP_CD,'C',CUST_NM,NULL)) OVER()" ).append("\n"); 
		query.append("            ELSE CUST_NM" ).append("\n"); 
		query.append("       END AS CUST_NM" ).append("\n"); 
		query.append("     , CASE WHEN BKG_CUST_TP_CD = 'C' AND CUST_TO_ORD_FLG   ='Y' THEN 'TO ORDER'" ).append("\n"); 
		query.append("            WHEN BKG_CUST_TP_CD = 'N' AND SAM_CNEE_NTFY_FLG ='Y' THEN MAX(DECODE(BKG_CUST_TP_CD,'C',CUST_ADDR,NULL)) OVER()" ).append("\n"); 
		query.append("            ELSE CUST_ADDR" ).append("\n"); 
		query.append("       END AS CUST_ADDR       " ).append("\n"); 
		query.append("     , CUST_ZIP_ID" ).append("\n"); 
		query.append("     , FAX_NO" ).append("\n"); 
		query.append("     , CASE WHEN BKG_CUST_TP_CD = 'C' AND CUST_TO_ORD_FLG   ='Y' THEN 'TO ORDER'" ).append("\n"); 
		query.append("            WHEN BKG_CUST_TP_CD = 'N' AND SAM_CNEE_NTFY_FLG ='Y' THEN MAX(DECODE(BKG_CUST_TP_CD,'C',PHN_NO,NULL)) OVER()" ).append("\n"); 
		query.append("            ELSE PHN_NO" ).append("\n"); 
		query.append("       END AS PHN_NO" ).append("\n"); 
		query.append("	 , @[pod_cd] AS POD_CD       " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("       SELECT A.BL_NO," ).append("\n"); 
		query.append("             '  ' AS BL_SPLIT_NO," ).append("\n"); 
		query.append("             B.BKG_CUST_TP_CD," ).append("\n"); 
		query.append("             B.CUST_CNT_CD," ).append("\n"); 
		query.append("             B.CUST_SEQ," ).append("\n"); 
		query.append("             REPLACE(REPLACE(NVL(UPPER(B.CUST_NM), ''), CHR(180), CHR(39)), '’', '''') AS CUST_NM," ).append("\n"); 
		query.append("             REPLACE(REPLACE(NVL(UPPER(B.CUST_ADDR), ''), CHR(180), CHR(39)), '’', '''') AS CUST_ADDR," ).append("\n"); 
		query.append("             B.CUST_ZIP_ID," ).append("\n"); 
		query.append("             B.CUST_FAX_NO AS FAX_NO," ).append("\n"); 
		query.append("--(2017.08.08)수정시작" ).append("\n"); 
		query.append("             REGEXP_REPLACE(EORI_NO,'[^0-9]','') AS PHN_NO," ).append("\n"); 
		query.append("--(2017.08.08)수정완료" ).append("\n"); 
		query.append("             CUST_TO_ORD_FLG,    -- 수하인인 정해지지 않은 무기명 B/L,지시식 B/L" ).append("\n"); 
		query.append("             SAM_CNEE_NTFY_FLG  -- NOTnjIFY가 CONSIGNEE와 같다는 FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM BKG_BOOKING A," ).append("\n"); 
		query.append("             BKG_CUSTOMER B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("         AND B.BKG_CUST_TP_CD IN ('S', 'C', 'N')" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" ORDER BY BKG_CUST_TP_CD" ).append("\n"); 

	}
}