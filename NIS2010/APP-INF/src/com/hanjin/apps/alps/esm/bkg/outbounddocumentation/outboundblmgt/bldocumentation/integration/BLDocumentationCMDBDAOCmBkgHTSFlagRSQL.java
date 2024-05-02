/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCmBkgHTSFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCmBkgHTSFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCmBkgHTSFlagRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCmBkgHTSFlagRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT DECODE(MAX(CNT), NULL, 'N', 'Y') AS US_FLAG" ).append("\n"); 
		query.append("FROM   (SELECT '1' AS CNT" ).append("\n"); 
		query.append("FROM   (SELECT A3.VSL_CD" ).append("\n"); 
		query.append(",A3.SKD_VOY_NO" ).append("\n"); 
		query.append(",A3.SKD_DIR_CD" ).append("\n"); 
		query.append(",A3.CLPT_SEQ AS MIN_SEQ" ).append("\n"); 
		query.append(",A4.CLPT_SEQ AS MAX_SEQ" ).append("\n"); 
		query.append("FROM BKG_BKG_HIS A1, BKG_VVD_HIS A2, VSK_VSL_PORT_SKD A3, VSK_VSL_PORT_SKD A4" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A1.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND A2.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND A2.VSL_CD = A3.VSL_CD" ).append("\n"); 
		query.append("AND A2.SKD_VOY_NO = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A2.SKD_DIR_CD = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A2.POL_CD = A3.VPS_PORT_CD" ).append("\n"); 
		query.append("AND A2.VSL_CD = A4.VSL_CD" ).append("\n"); 
		query.append("AND A2.SKD_VOY_NO = A4.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A2.SKD_DIR_CD = A4.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A2.POD_CD = A4.VPS_PORT_CD" ).append("\n"); 
		query.append("AND (   SUBSTR(A2.POL_CD, 1, 2) IN (SELECT CNT_CD" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE (SCONTI_CD IN ('MC', 'MS') OR CNT_CD IN ('CA', 'GU'))" ).append("\n"); 
		query.append("AND CNT_CD <> 'US'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("OR SUBSTR(A2.POD_CD, 1, 2) IN (SELECT CNT_CD" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE (SCONTI_CD IN ('MC', 'MS') OR CNT_CD IN ('CA', 'GU'))" ).append("\n"); 
		query.append("AND CNT_CD <> 'US'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'))" ).append("\n"); 
		query.append(") B1" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD B2" ).append("\n"); 
		query.append("WHERE B1.VSL_CD = B2.VSL_CD" ).append("\n"); 
		query.append("AND B1.SKD_VOY_NO = B2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B1.SKD_DIR_CD = B2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B1.MIN_SEQ < B2.CLPT_SEQ" ).append("\n"); 
		query.append("AND B1.MAX_SEQ >= B2.CLPT_SEQ" ).append("\n"); 
		query.append("AND B2.VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("AND 'Y' = (SELECT CASE WHEN SUBSTR(POL_CD, 1, 2) = 'US' OR SUBSTR(DEL_CD, 1, 2) = 'US' THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM BKG_BKG_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2'" ).append("\n"); 
		query.append("FROM BKG_BKG_HIS A1, BKG_VVD_HIS A2" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A1.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND A2.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND A2.POD_CD LIKE 'US%'" ).append("\n"); 
		query.append("AND A1.DEL_CD NOT LIKE 'US%')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT DECODE(MAX(CNT), NULL, 'N', 'Y') AS US_FLAG" ).append("\n"); 
		query.append("FROM (SELECT '1' AS CNT" ).append("\n"); 
		query.append("FROM   (SELECT A3.VSL_CD" ).append("\n"); 
		query.append(",					   A3.SKD_VOY_NO" ).append("\n"); 
		query.append(",					   A3.SKD_DIR_CD" ).append("\n"); 
		query.append(",					   A3.CLPT_SEQ AS MIN_SEQ" ).append("\n"); 
		query.append(",					   A4.CLPT_SEQ AS MAX_SEQ" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A1, BKG_VVD A2, VSK_VSL_PORT_SKD A3, VSK_VSL_PORT_SKD A4" ).append("\n"); 
		query.append("WHERE  A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A2.VSL_CD = A3.VSL_CD" ).append("\n"); 
		query.append("AND A2.SKD_VOY_NO = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A2.SKD_DIR_CD = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A2.POL_CD = A3.VPS_PORT_CD" ).append("\n"); 
		query.append("AND A2.VSL_CD = A4.VSL_CD" ).append("\n"); 
		query.append("AND A2.SKD_VOY_NO = A4.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A2.SKD_DIR_CD = A4.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A2.POD_CD = A4.VPS_PORT_CD" ).append("\n"); 
		query.append("AND (   SUBSTR(A2.POL_CD, 1, 2) IN (SELECT CNT_CD" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE (SCONTI_CD IN ('MC', 'MS') OR CNT_CD IN ('CA', 'GU'))" ).append("\n"); 
		query.append("AND CNT_CD <> 'US'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("OR SUBSTR(A2.POD_CD, 1, 2) IN (SELECT CNT_CD" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE (SCONTI_CD IN ('MC', 'MS') OR CNT_CD IN ('CA', 'GU'))" ).append("\n"); 
		query.append("AND CNT_CD <> 'US'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'))" ).append("\n"); 
		query.append(") B1" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD B2" ).append("\n"); 
		query.append("WHERE  B1.VSL_CD = B2.VSL_CD" ).append("\n"); 
		query.append("AND B1.SKD_VOY_NO = B2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B1.SKD_DIR_CD = B2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B1.MIN_SEQ < B2.CLPT_SEQ" ).append("\n"); 
		query.append("AND B1.MAX_SEQ >= B2.CLPT_SEQ" ).append("\n"); 
		query.append("AND B2.VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("AND 'Y' = (SELECT CASE WHEN SUBSTR(POL_CD, 1, 2) = 'US' OR SUBSTR(DEL_CD, 1, 2) = 'US' THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2'" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A1, BKG_VVD A2" ).append("\n"); 
		query.append("WHERE  A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A2.POD_CD LIKE 'US%'" ).append("\n"); 
		query.append("AND A1.DEL_CD NOT LIKE 'US%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}