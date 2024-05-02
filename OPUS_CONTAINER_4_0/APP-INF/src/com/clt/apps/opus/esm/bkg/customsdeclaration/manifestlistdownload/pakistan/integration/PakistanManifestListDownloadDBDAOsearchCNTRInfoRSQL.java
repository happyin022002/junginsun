/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PakistanManifestListDownloadDBDAOsearchCNTRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.31
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.31 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PakistanManifestListDownloadDBDAOsearchCNTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 파키스탄 세관 신고를 위한 CNTR Info
	  * </pre>
	  */
	public PakistanManifestListDownloadDBDAOsearchCNTRInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration").append("\n"); 
		query.append("FileName : PakistanManifestListDownloadDBDAOsearchCNTRInfoRSQL").append("\n"); 
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
		query.append("SELECT MAIN.M_BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("     , MAIN.CNTR_NO" ).append("\n"); 
		query.append("     , MAIN.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , MF.CMDT_HS_CD" ).append("\n"); 
		query.append("     , (SELECT CSTMS_DESC FROM BKG_BL_DOC WHERE BKG_NO = MAIN.M_BKG_NO )CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("     , (SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO " ).append("\n"); 
		query.append("         WHERE BKG_NO = MAIN.M_BKG_NO AND CNTR_NO = MAIN.CNTR_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1 ) AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("     , MF.PCK_QTY" ).append("\n"); 
		query.append("     , MF.PCK_TP_CD" ).append("\n"); 
		query.append("     , MF.CNTR_MF_WGT" ).append("\n"); 
		query.append("     , MF.WGT_UT_CD" ).append("\n"); 
		query.append("     , MF.MEAS_QTY" ).append("\n"); 
		query.append("     , MF.MEAS_UT_CD" ).append("\n"); 
		query.append("     , (SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD = MF.PCK_TP_CD) AS PCK_NM" ).append("\n"); 
		query.append("     , MAIN.SOC_FLG" ).append("\n"); 
		query.append("	 , ( SELECT IMDG_UN_NO " ).append("\n"); 
		query.append("           FROM BKG_DG_CGO " ).append("\n"); 
		query.append("          WHERE BKG_NO = MAIN.BKG_NO " ).append("\n"); 
		query.append("            AND CNTR_NO = MAIN.CNTR_NO " ).append("\n"); 
		query.append("            AND ROWNUM = 1 ) AS IMDG_UN_NO" ).append("\n"); 
		query.append("	 , ( SELECT IMDG_CLSS_CD" ).append("\n"); 
		query.append("           FROM BKG_DG_CGO " ).append("\n"); 
		query.append("          WHERE BKG_NO = MAIN.BKG_NO " ).append("\n"); 
		query.append("            AND CNTR_NO = MAIN.CNTR_NO " ).append("\n"); 
		query.append("            AND ROWNUM = 1 ) AS IMDG_CLSS_CD" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC MF" ).append("\n"); 
		query.append(", ( SELECT BKG.BKG_NO M_BKG_NO, CNTR.* " ).append("\n"); 
		query.append("      FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("         , BKG_VVD VVD" ).append("\n"); 
		query.append("         , BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND BKG.BKG_NO = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("       AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND BKG.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("       AND VVD.VSL_CD		= SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO	= SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD	= SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("       AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("       AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   ) MAIN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND MAIN.M_BKG_NO = MF.BKG_NO(+)" ).append("\n"); 
		query.append("  AND MAIN.CNTR_NO = MF.CNTR_NO(+)" ).append("\n"); 

	}
}