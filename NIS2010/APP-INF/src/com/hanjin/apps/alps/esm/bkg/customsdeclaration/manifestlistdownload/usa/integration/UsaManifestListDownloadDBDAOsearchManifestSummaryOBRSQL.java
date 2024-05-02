/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchManifestSummaryOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchManifestSummaryOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaManifestListDownloadDBDAOsearchManifestSummaryOB
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchManifestSummaryOBRSQL(){
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
		params.put("full_empty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("customs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchManifestSummaryOBRSQL").append("\n"); 
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
		query.append("SELECT  NVL(TB.VSL_CD,' ')||NVL(TB.SKD_VOY_NO,' ')||NVL(TB.SKD_DIR_CD,' ') VVD" ).append("\n"); 
		query.append("       ,TB.CSTMS_POL_CD POL" ).append("\n"); 
		query.append("       ,TB.CSTMS_POD_CD POD   " ).append("\n"); 
		query.append("       ,CASE WHEN MAX(VPS_ETA_DT) IS NULL THEN ' ' ELSE TO_CHAR(MAX(VPS_ETA_DT), 'YYYYMMDD HH24') || 'h' END ETA  " ).append("\n"); 
		query.append("       ,MAX(FROB) FROB" ).append("\n"); 
		query.append("       ,CASE WHEN SND_DT IS NULL THEN ' ' ELSE TO_CHAR(SND_DT, 'YYYYMMDD HH24') || 'h' END SENT_TIME" ).append("\n"); 
		query.append("       ,MAX(XI) XI" ).append("\n"); 
		query.append("       ,COUNT(DISTINCT CNTR_NO) CNTR_COUNT" ).append("\n"); 
		query.append("       ,COUNT(DISTINCT BKG_NO) BL_COUNT" ).append("\n"); 
		query.append("       ,CSTMS_PORT_CD  CUSTOMS" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT VVD.VSL_CD" ).append("\n"); 
		query.append("               ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,VVD.POL_CD AS CSTMS_POL_CD" ).append("\n"); 
		query.append("               ,SKD1.VPS_ETD_DT AS VPS_ETD_DT" ).append("\n"); 
		query.append("               ,VVD.POD_CD AS CSTMS_POD_CD" ).append("\n"); 
		query.append("               ,SKD2.VPS_ETA_DT AS VPS_ETA_DT" ).append("\n"); 
		query.append("               ,(SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                   FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                  WHERE	SUBSTR(VPS_PORT_CD,1,2)	IN('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("                                                                                    WHERE CNT_cD='US'" ).append("\n"); 
		query.append("                                                                                    AND CSTMS_DIV_ID= 'US_CNT_CD_LIST') " ).append("\n"); 
		query.append("                                                                        )                             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    AND VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                )AS MIN_CLPT_SEQ" ).append("\n"); 
		query.append("               ,SKD2.CLPT_SEQ AS ETA_CLPT_SEQ" ).append("\n"); 
		query.append("               ,(SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                   FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                  WHERE	SUBSTR(VPS_PORT_CD,1,2)	IN('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("                                                                                    WHERE CNT_cD='US'" ).append("\n"); 
		query.append("                                                                                    AND CSTMS_DIV_ID= 'US_CNT_CD_LIST') " ).append("\n"); 
		query.append("                                                                        )                             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    AND VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                )AS MAX_CLPT_SEQ" ).append("\n"); 
		query.append("               ,SKD1.CLPT_SEQ POL_CLPT_SEQ" ).append("\n"); 
		query.append("			   ,SKD2.CLPT_SEQ POD_CLPT_SEQ" ).append("\n"); 
		query.append("               ,(SELECT SUBSTR( MIN( LPAD(CLPT_SEQ, 2, 0) ||VPS_PORT_CD) , 3)" ).append("\n"); 
		query.append("                            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                           WHERE 1=1" ).append("\n"); 
		query.append("                             AND	SUBSTR(VPS_PORT_CD,1,2)	IN('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("                                                                                            WHERE CNT_cD='US'" ).append("\n"); 
		query.append("                                                                                            AND CSTMS_DIV_ID= 'US_CNT_CD_LIST') " ).append("\n"); 
		query.append("                                                                                )                             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                             AND VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                             AND SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                             AND SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                             AND CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("               ) AS CSTMS_PORT_CD" ).append("\n"); 
		query.append("		       ,CASE WHEN INSTR(VVD.POL_CD, 'US') != 1 THEN" ).append("\n"); 
		query.append("		           DECODE(" ).append("\n"); 
		query.append("		               (SELECT Y.VPS_PORT_CD " ).append("\n"); 
		query.append("		                FROM VSK_VSL_PORT_SKD Y" ).append("\n"); 
		query.append("		                WHERE  Y.VSL_CD = VVD.VSL_CD AND Y.SKD_VOY_NO = VVD.SKD_VOY_NO AND Y.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("		                   AND Y.CLPT_SEQ =  (SELECT MIN(X.CLPT_SEQ) AS SEQ" ).append("\n"); 
		query.append("									                       FROM VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("									                       WHERE X.VSL_CD = VVD.VSL_CD AND X.SKD_VOY_NO = VVD.SKD_VOY_NO AND X.SKD_DIR_CD = VVD.SKD_DIR_CD AND X.VPS_PORT_CD LIKE 'US%')" ).append("\n"); 
		query.append("		                   AND Y.VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("		               ), NULL, 'N', 'Y' " ).append("\n"); 
		query.append("		           )   " ).append("\n"); 
		query.append("			       ELSE 'N'" ).append("\n"); 
		query.append("			       END  FROB" ).append("\n"); 
		query.append("			       ,CASE WHEN S.SND_DT  IS NULL THEN ' ' ELSE TO_CHAR(S.SND_DT, 'YYYYMMDD HH24') || 'h' END SENT_TIME" ).append("\n"); 
		query.append("                   #if (${full_empty} == 'M')" ).append("\n"); 
		query.append("                   		,DECODE(S.TRSM_MSG_TP_ID||S.CGO_TP_CD, 'XIM', 'Y', 'XI', 'Y', 'N') XI" ).append("\n"); 
		query.append("                   	#end" ).append("\n"); 
		query.append("                   	#if (${full_empty} == 'F') " ).append("\n"); 
		query.append("                   		,DECODE(S.TRSM_MSG_TP_ID||S.CGO_TP_CD, 'XIF', 'Y', 'XI', 'Y', 'N') XI" ).append("\n"); 
		query.append("                   	#end" ).append("\n"); 
		query.append("                   ,S.SND_DT" ).append("\n"); 
		query.append("                   ,S.TRSM_MSG_TP_ID, S.CGO_TP_CD" ).append("\n"); 
		query.append("                   ,B.CNTR_NO" ).append("\n"); 
		query.append("                   ,VVD.BKG_NO" ).append("\n"); 
		query.append("          FROM  BKG_VVD VVD " ).append("\n"); 
		query.append("               ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("               ,VSK_VSL_PORT_SKD SKD1" ).append("\n"); 
		query.append("               ,VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("			 ,(" ).append("\n"); 
		query.append("		        SELECT *" ).append("\n"); 
		query.append("		        FROM BKG_CSTMS_ADV_SND_LOG" ).append("\n"); 
		query.append("		        WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("		        AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("		        AND TRSM_MSG_TP_ID = 'XI'" ).append("\n"); 
		query.append("		        AND VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("		        AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("		        AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("		        AND POL_CD LIKE NVL(@[pol],'%')" ).append("\n"); 
		query.append("		        AND POD_CD LIKE NVL(@[pod],'%') " ).append("\n"); 
		query.append("		        AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("				AND NVL(CGO_TP_CD, 'X') = DECODE(NVL(CGO_TP_CD,'X'), 'X', 'X', @[full_empty])" ).append("\n"); 
		query.append("                AND (CGO_TP_CD = 'F' OR CGO_TP_CD = 'R' OR CGO_TP_CD is null)" ).append("\n"); 
		query.append("		        AND SND_DT IN (" ).append("\n"); 
		query.append("		            SELECT MAX(SND_DT)" ).append("\n"); 
		query.append("		            FROM BKG_CSTMS_ADV_SND_LOG" ).append("\n"); 
		query.append("		            WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("		            AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("		            AND TRSM_MSG_TP_ID = 'XI'" ).append("\n"); 
		query.append("		            AND VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("		            AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("		            AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("		            AND POL_CD LIKE NVL(@[pol],'%')" ).append("\n"); 
		query.append("		            AND POD_CD LIKE NVL(@[pod],'%') " ).append("\n"); 
		query.append("		            AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("		            AND NVL(CGO_TP_CD, 'X') = DECODE(NVL(CGO_TP_CD,'X'), 'X', 'X', @[full_empty])" ).append("\n"); 
		query.append("                    AND (CGO_TP_CD = 'F' OR CGO_TP_CD = 'R' OR CGO_TP_CD is null)" ).append("\n"); 
		query.append("					GROUP BY CNT_CD, IO_BND_CD, TRSM_MSG_TP_ID, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POL_CD, POD_CD" ).append("\n"); 
		query.append("		            )" ).append("\n"); 
		query.append("			   ) S           " ).append("\n"); 
		query.append("			   ,BKG_CONTAINER  B               " ).append("\n"); 
		query.append("         WHERE  VVD.BKG_NO        = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND  VVD.VSL_CD        = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO    = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD    = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("           AND  BKG.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("           AND  BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("#if (${pol} != '') " ).append("\n"); 
		query.append("           AND  VVD.POL_CD = @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '') " ).append("\n"); 
		query.append("           AND  VVD.POD_CD = @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${full_empty} == 'F') " ).append("\n"); 
		query.append("           AND  BKG.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${full_empty} == 'M') " ).append("\n"); 
		query.append("           AND  BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND  VVD.VSL_CD         = SKD1.VSL_CD" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO     = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD     = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND  VVD.POL_CD         = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND  SKD1.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("           AND  VVD.VSL_CD         = SKD2.VSL_CD" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO     = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD     = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND  VVD.POD_CD         = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND  SKD2.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("	       AND 'US' = S.CNT_CD(+)" ).append("\n"); 
		query.append("	       AND VVD.VSL_CD         = S.VSL_CD(+)" ).append("\n"); 
		query.append("	       AND VVD.SKD_VOY_NO     = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("	       AND VVD.SKD_DIR_CD     = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("	       AND VVD.POD_CD    = S.POD_CD(+)" ).append("\n"); 
		query.append("	       AND VVD.POL_CD    = S.POL_CD(+)" ).append("\n"); 
		query.append("	       AND VVD.BKG_NO   = B.BKG_NO(+) " ).append("\n"); 
		query.append("	                  " ).append("\n"); 
		query.append("        ) TB" ).append("\n"); 
		query.append(" WHERE  TB.ETA_CLPT_SEQ >= TB.MIN_CLPT_SEQ" ).append("\n"); 
		query.append(" AND TB.POL_CLPT_SEQ < TB.MAX_CLPT_SEQ" ).append("\n"); 
		query.append("#if (${customs} != '')" ).append("\n"); 
		query.append(" AND CSTMS_PORT_CD = @[customs]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY  VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CSTMS_POD_CD, CSTMS_POL_CD, CSTMS_PORT_CD, SND_DT,  TRSM_MSG_TP_ID, CGO_TP_CD" ).append("\n"); 
		query.append("ORDER BY VSL_CD" ).append("\n"); 
		query.append("#if (${pod} != '') " ).append("\n"); 
		query.append("		, CASE WHEN MAX(VPS_ETD_DT) IS NULL THEN ' ' ELSE TO_CHAR(MAX(VPS_ETD_DT), 'YYYYMMDD HH24') || 'h' END " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol} != '') " ).append("\n"); 
		query.append("		, CASE WHEN MAX(VPS_ETA_DT) IS NULL THEN ' ' ELSE TO_CHAR(MAX(VPS_ETA_DT), 'YYYYMMDD HH24') || 'h' END " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}