/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchEuOBVvdByBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchEuOBVvdByBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOSearchEuOBVvdByBLRSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchEuOBVvdByBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchEuOBVvdByBLRSQL").append("\n"); 
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
		query.append("SELECT COUNT(B.VSL_CD) OVER( PARTITION BY B.VSL_CD,B.SKD_VOY_NO,B.SKD_DIR_CD) VVD_CNT" ).append("\n"); 
		query.append("     , B.VSL_CD" ).append("\n"); 
		query.append("     , B.SKD_VOY_NO" ).append("\n"); 
		query.append("     , B.SKD_DIR_CD" ).append("\n"); 
		query.append("     , B.SLAN_CD" ).append("\n"); 
		query.append("     , B.POL_CD AS POL" ).append("\n"); 
		query.append("     , B.POD_CD AS POD" ).append("\n"); 
		query.append("     , SUBSTR(B.POD_YD_CD, -2) AS POD_YD_CD" ).append("\n"); 
		query.append("     , B.POL_YD_CD" ).append("\n"); 
		query.append("     , D.ATTR_CTNT1 EU" ).append("\n"); 
		query.append("  FROM BKG_BOOKING A" ).append("\n"); 
		query.append("     ,BKG_VVD B" ).append("\n"); 
		query.append("     ,VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("     ,BKG_CSTMS_CD_CONV_CTNT D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("   AND B.BKG_NO = @[p_bl_no]" ).append("\n"); 
		query.append("   AND B.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("   AND B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND B.POL_CD = C.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND B.POL_YD_CD = C.YD_CD" ).append("\n"); 
		query.append("   AND SUBSTR(B.POD_CD, 1, 2) != D.ATTR_CTNT1" ).append("\n"); 
		query.append("   AND NVL(C.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("   AND D.CSTMS_DIV_ID ='EU_MEMBER_CNT'" ).append("\n"); 
		query.append("   AND D.CNT_CD = 'EU'" ).append("\n"); 
		query.append("   AND SUBSTR(C.VPS_PORT_CD, 1, 2) = D.ATTR_CTNT1" ).append("\n"); 
		query.append(" ORDER BY B.VSL_PRE_PST_CD" ).append("\n"); 

	}
}