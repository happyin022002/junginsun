/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsVvdDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOsearchAncsCstmsVvdDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 별 POL-POD별 BKG 건수와 ANCS로 다운로드 받은 건수 상세 내역  조회
	  * 2011.07.22 김보배 [CHM-201112386] [Manifest] BDR No-> Yes로 보이도록 수정
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOsearchAncsCstmsVvdDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsVvdDtlListRSQL").append("\n"); 
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
		query.append("SELECT   A.POL_CD AS POL, A.VPS_ETD_DT AS POL_ATD, A.POD_CD AS POD," ).append("\n"); 
		query.append("         DECODE (C.TRNK_AUTO_BDR_DT," ).append("\n"); 
		query.append("                 NULL, DECODE (C.TRNK_MNL_BDR_DT, NULL, 'N', 'Y')," ).append("\n"); 
		query.append("                 'Y'" ).append("\n"); 
		query.append("                ) AS BDR," ).append("\n"); 
		query.append("         DECODE (C.TRNK_AUTO_BDR_DT," ).append("\n"); 
		query.append("                 NULL, DECODE (C.TRNK_MNL_BDR_DT," ).append("\n"); 
		query.append("                               NULL, NULL," ).append("\n"); 
		query.append("                               TO_CHAR (C.TRNK_MNL_BDR_DT," ).append("\n"); 
		query.append("                                        'YYYY-MM-DD HH24:MI'" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                              )," ).append("\n"); 
		query.append("                 TO_CHAR (C.TRNK_AUTO_BDR_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                ) AS BDR_DATE," ).append("\n"); 
		query.append("         NVL(A.BKG_KNT, 0) AS BKG_CNT, NVL(B.BKG_KNT, 0) AS DNLD," ).append("\n"); 
		query.append("         NVL(A.BKG_KNT, 0) - NVL(B.BKG_KNT, 0) AS DIFF," ).append("\n"); 
		query.append("         A.POL_CLPT_IND_SEQ, A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    FROM ( SELECT A.POL_CD AS POL_CD, A.POD_CD AS POD_CD, A.POL_CLPT_IND_SEQ, A.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                  C.VPS_ETD_DT AS VPS_ETD_DT, COUNT (B.BKG_NO) AS BKG_KNT" ).append("\n"); 
		query.append("            FROM BKG_VVD A, BKG_BOOKING B, VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("           WHERE A.VSL_CD = SUBSTR (@[vvd], 1, 4)" ).append("\n"); 
		query.append("             AND A.SKD_VOY_NO = SUBSTR (@[vvd], 5, 4)" ).append("\n"); 
		query.append("             AND A.SKD_DIR_CD = SUBSTR (@[vvd], 9, 1)" ).append("\n"); 
		query.append("             AND A.POD_CD = @[pod]" ).append("\n"); 
		query.append("             AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("             AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND B.BKG_CGO_TP_CD IN ('F', 'B')" ).append("\n"); 
		query.append("             AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("             AND C.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND C.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND C.VPS_PORT_CD = A.POL_CD" ).append("\n"); 
		query.append("             AND C.CLPT_IND_SEQ = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        GROUP BY A.POL_CD, A.POD_CD, A.POL_CLPT_IND_SEQ, A.POD_CLPT_IND_SEQ, C.VPS_ETD_DT ) A, " ).append("\n"); 
		query.append("        ( SELECT B.POL_CD AS POL_CD, B.POD_CD AS POD_CD, B.POL_CLPT_IND_SEQ, B.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                 COUNT (A.BKG_NO) AS BKG_KNT" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_ANR_BL A, BKG_VVD B" ).append("\n"); 
		query.append("           WHERE A.VSL_CD = SUBSTR (@[vvd], 1, 4)" ).append("\n"); 
		query.append("             AND A.SKD_VOY_NO = SUBSTR (@[vvd], 5, 4)" ).append("\n"); 
		query.append("             AND A.SKD_DIR_CD = SUBSTR (@[vvd], 9, 1)" ).append("\n"); 
		query.append("             AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("             AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("             AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND B.POD_CD = @[pod]" ).append("\n"); 
		query.append("           GROUP BY B.POL_CD, B.POD_CD, B.POL_CLPT_IND_SEQ, B.POD_CLPT_IND_SEQ ) B, BKG_VVD_BDR_LOG C" ).append("\n"); 
		query.append("   WHERE B.POL_CD(+) = A.POL_CD" ).append("\n"); 
		query.append("     AND B.POD_CD(+) = A.POD_CD" ).append("\n"); 
		query.append("     AND B.POL_CLPT_IND_SEQ(+) = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     AND B.POD_CLPT_IND_SEQ(+) = A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     AND C.VSL_CD(+) = SUBSTR (@[vvd], 1, 4)" ).append("\n"); 
		query.append("     AND C.SKD_VOY_NO(+) = SUBSTR (@[vvd], 5, 4)" ).append("\n"); 
		query.append("     AND C.SKD_DIR_CD(+) = SUBSTR (@[vvd], 9, 1)" ).append("\n"); 
		query.append("     AND C.POL_CD(+) = A.POL_CD" ).append("\n"); 
		query.append("     AND C.POD_CD(+) = A.POD_CD" ).append("\n"); 
		query.append("     AND C.POL_CLPT_IND_SEQ(+) = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     AND C.POD_CLPT_IND_SEQ(+) = A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("ORDER BY A.POL_CD, A.VPS_ETD_DT" ).append("\n"); 

	}
}