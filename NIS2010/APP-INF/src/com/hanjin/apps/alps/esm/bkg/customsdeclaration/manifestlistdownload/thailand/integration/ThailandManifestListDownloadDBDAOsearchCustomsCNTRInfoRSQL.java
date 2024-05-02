/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ThailandManifestListDownloadDBDAOsearchCustomsCNTRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ThailandManifestListDownloadDBDAOsearchCustomsCNTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ThailandManifestListDownloadDBDAOsearchCustomsCNTRInfo
	  * </pre>
	  */
	public ThailandManifestListDownloadDBDAOsearchCustomsCNTRInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.integration").append("\n"); 
		query.append("FileName : ThailandManifestListDownloadDBDAOsearchCustomsCNTRInfoRSQL").append("\n"); 
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
		query.append("SELECT B.BKG_NO" ).append("\n"); 
		query.append("     , C.CNTR_NO" ).append("\n"); 
		query.append("     , 'STEEL' AS TP_CD" ).append("\n"); 
		query.append("     , D.CNTR_TPSZ_RMK" ).append("\n"); 
		query.append("     , C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , DECODE(C.DE_TERM_CD,'Y','FCL','F','LCL','') AS STATUS" ).append("\n"); 
		query.append("     , B.POL_CD" ).append("\n"); 
		query.append("     , DECODE(C.SOC_FLG,'N','SM LINE','SOC') AS CONSIGNEE" ).append("\n"); 
		query.append("     , C.CNTR_WGT" ).append("\n"); 
		query.append("     , C.WGT_UT_CD" ).append("\n"); 
		query.append("     , C.RC_FLG" ).append("\n"); 
		query.append("     , C.DCGO_FLG" ).append("\n"); 
		query.append("     , ( SELECT /*+ INDEX_ASC(RF XPKBKG_RF_CGO) */ CDO_TEMP || '''C' " ).append("\n"); 
		query.append("           FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("          WHERE 1=1 " ).append("\n"); 
		query.append("            AND BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("            AND ROWNUM = 1 ) AS CDO_TEMP" ).append("\n"); 
		query.append("     , ( SELECT /*+ INDEX_ASC(DG XPKBKG_DG_CGO) */ IMDG_CLSS_CD" ).append("\n"); 
		query.append("           FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("          WHERE 1=1 " ).append("\n"); 
		query.append("            AND BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("            AND ROWNUM = 1 ) AS IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , ( SELECT /*+ INDEX_ASC(DG XPKBKG_DG_CGO) */ IMDG_UN_NO" ).append("\n"); 
		query.append("           FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("          WHERE 1=1 " ).append("\n"); 
		query.append("            AND BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("            AND ROWNUM = 1 ) AS IMDG_UN_NO" ).append("\n"); 
		query.append("     , '' AS POSITION" ).append("\n"); 
		query.append("  FROM BKG_VVD A, BKG_BOOKING B, BKG_CONTAINER C, MDM_CNTR_TP_SZ D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND D.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   AND A.VSL_CD = SUBSTR(@[s_vvd],1,4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[s_vvd],5,4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[s_vvd],9,1)" ).append("\n"); 
		query.append("   AND B.VSL_CD = SUBSTR(@[trnk_vvd],1,4)" ).append("\n"); 
		query.append("   AND B.SKD_VOY_NO = SUBSTR(@[trnk_vvd],5,4)" ).append("\n"); 
		query.append("   AND B.SKD_DIR_CD = SUBSTR(@[trnk_vvd],9,1)" ).append("\n"); 
		query.append("   AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("   AND B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND B.DEL_CD = @[s_del_cd]" ).append("\n"); 
		query.append("   AND B.DEL_NOD_CD LIKE @[s_del_cd]||NVL(@[s_del_nod_cd],'%')" ).append("\n"); 
		query.append("ORDER BY A.BKG_NO, C.CNTR_NO, C.CNTR_TPSZ_CD" ).append("\n"); 

	}
}