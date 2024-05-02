/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchPreEUvvdByBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchPreEUvvdByBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Finland (IE344) 용 / BL 에 해당하는 vvd 조회
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchPreEUvvdByBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_fi_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchPreEUvvdByBLRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.SLAN_CD" ).append("\n"); 
		query.append("     , A.VPS_PORT_CD          AS POD" ).append("\n"); 
		query.append("     , SUBSTR(A.YD_CD, 6, 2)  AS POD_YD_CD" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("     , BKG_CSTMS_CD_CONV_CTNT B" ).append("\n"); 
		query.append("     , BKG_VVD D" ).append("\n"); 
		query.append("     , BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND D.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BL_NO = @[p_fi_bl_no]" ).append("\n"); 
		query.append("   AND D.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("   AND D.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND D.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND NVL(A.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("   AND B.CSTMS_DIV_ID = 'EU_MEMBER_CNT'" ).append("\n"); 
		query.append("   AND B.CNT_CD = 'EU'" ).append("\n"); 
		query.append("   AND SUBSTR(A.VPS_PORT_CD, 1, 2) = B.ATTR_CTNT1" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD = 'FIKTK'" ).append("\n"); 

	}
}