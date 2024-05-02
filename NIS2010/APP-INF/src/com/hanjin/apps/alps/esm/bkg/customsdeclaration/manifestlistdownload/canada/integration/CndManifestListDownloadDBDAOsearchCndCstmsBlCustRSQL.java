/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchCndCstmsBlCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.10.29 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchCndCstmsBlCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndCstmsBlCust
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchCndCstmsBlCustRSQL(){
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
		query.append("FileName : CndManifestListDownloadDBDAOsearchCndCstmsBlCustRSQL").append("\n"); 
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
		query.append("SELECT   C1.CUST_CNT_CD         AS CUST_CNT_CD1" ).append("\n"); 
		query.append(",C1.CUST_SEQ            AS CUST_SEQ1" ).append("\n"); 
		query.append(",C1.CUST_ZIP_ID         AS CUST_ZIP_ID1" ).append("\n"); 
		query.append(",C1.CUST_CTY_NM         AS CUST_CTY_NM1" ).append("\n"); 
		query.append(",C1.CUST_STE_CD         AS CUST_STE_CD1" ).append("\n"); 
		query.append(",C1.CSTMS_DECL_CNT_CD   AS CSTMS_DECL_CNT_CD1" ).append("\n"); 
		query.append(",C1.CUST_NM             AS CUST_NM1" ).append("\n"); 
		query.append(",C1.CUST_ADDR           AS CUST_ADDR1" ).append("\n"); 
		query.append(",C2.CUST_CNT_CD         AS CUST_CNT_CD2" ).append("\n"); 
		query.append(",C2.CUST_SEQ            AS CUST_SEQ2" ).append("\n"); 
		query.append(",C2.CUST_ZIP_ID         AS CUST_ZIP_ID2" ).append("\n"); 
		query.append(",C2.CUST_CTY_NM         AS CUST_CTY_NM2" ).append("\n"); 
		query.append(",C2.CUST_STE_CD         AS CUST_STE_CD2" ).append("\n"); 
		query.append(",C2.CSTMS_DECL_CNT_CD   AS CSTMS_DECL_CNT_CD2" ).append("\n"); 
		query.append(",C2.CUST_NM             AS CUST_NM2" ).append("\n"); 
		query.append(",C2.CUST_ADDR           AS CUST_ADDR2" ).append("\n"); 
		query.append(",DECODE(A.CUST_TO_ORD_FLG, 'Y', 'O', 'S') AS TO_ORD_FLG" ).append("\n"); 
		query.append(",C3.CUST_CNT_CD         AS CUST_CNT_CD3" ).append("\n"); 
		query.append(",C3.CUST_SEQ            AS CUST_SEQ3" ).append("\n"); 
		query.append(",C3.CUST_ZIP_ID         AS CUST_ZIP_ID3" ).append("\n"); 
		query.append(",C3.CUST_CTY_NM         AS CUST_CTY_NM3" ).append("\n"); 
		query.append(",C3.CUST_STE_CD         AS CUST_STE_CD3" ).append("\n"); 
		query.append(",C3.CSTMS_DECL_CNT_CD   AS CSTMS_DECL_CNT_CD3" ).append("\n"); 
		query.append(",C3.CUST_NM             AS CUST_NM3" ).append("\n"); 
		query.append(",C3.CUST_ADDR           AS CUST_ADDR3" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append(",BKG_CSTMS_ADV_CUST C1" ).append("\n"); 
		query.append(",BKG_CSTMS_ADV_CUST C2" ).append("\n"); 
		query.append(",BKG_CSTMS_ADV_CUST C3" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND  A.CNT_CD = 'CA'" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND  A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND  A.CNT_CD = C1.CNT_CD(+)" ).append("\n"); 
		query.append("AND  A.BL_NO = C1.BL_NO(+)" ).append("\n"); 
		query.append("AND  C1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND  A.CNT_CD = C2.CNT_CD(+)" ).append("\n"); 
		query.append("AND  A.BL_NO = C2.BL_NO(+)" ).append("\n"); 
		query.append("AND  C2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND  A.CNT_CD = C3.CNT_CD(+)" ).append("\n"); 
		query.append("AND  A.BL_NO = C3.BL_NO(+)" ).append("\n"); 
		query.append("AND  C3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 

	}
}