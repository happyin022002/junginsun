/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchMainMeansRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchMainMeansRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAIN MEANS 정보를 조회한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchMainMeansRSQL(){
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
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchMainMeansRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	 '20'                              MAIN_MEANS_TYPE" ).append("\n"); 
		query.append("	,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD    MAIN_VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("	   CASE" ).append("\n"); 
		query.append("	       WHEN @[d_type] = 'O' OR @[d_type] ='P' THEN 'B'" ).append("\n"); 
		query.append("	       ELSE 'V'" ).append("\n"); 
		query.append("	   END" ).append("\n"); 
		query.append("	 ) MAIN_MODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,A.VSL_ENG_NM                        MAIN_NAME" ).append("\n"); 
		query.append("	,A.SVC_RQST_NO                       MAIN_SSR" ).append("\n"); 
		query.append("	,'L'                               	 L_MAIN_ID_TYPE" ).append("\n"); 
		query.append("	,A.LLOYD_NO                          L_MAIN_ID" ).append("\n"); 
		query.append("	,'C'                               	 C_MAIN_ID_TYPE" ).append("\n"); 
		query.append("	,A.CALL_SGN_NO                       C_MAIN_ID" ).append("\n"); 
		query.append("    ,A.VSL_CNT_CD 						 MAIN_NATION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,DECODE(@[port_cd], NVL((SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("                             WHERE CNT_CD = 'BE'" ).append("\n"); 
		query.append("                             AND CSTMS_DIV_ID = 'EUR_BE_PORT_LIST'" ).append("\n"); 
		query.append("                             AND CSTMS_DIV_ID_SEQ > 0     " ).append("\n"); 
		query.append("                             AND ATTR_CTNT1 = 'BEANR'" ).append("\n"); 
		query.append("                            ),'')" ).append("\n"); 
		query.append("							,(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                SELECT" ).append("\n"); 
		query.append("                                        CASE" ).append("\n"); 
		query.append("                                            WHEN (SPR_CNT + AMN_CNT + ZTG_CNT +ETC_CNT) = ETC_CNT THEN ''" ).append("\n"); 
		query.append("                                            WHEN SPR_CNT > 0 THEN 'SPR'" ).append("\n"); 
		query.append("                                            ELSE 'AMN'" ).append("\n"); 
		query.append("                                        END SUB_LICENSE" ).append("\n"); 
		query.append("                                FROM (" ).append("\n"); 
		query.append("                                        SELECT COUNT(ANR_SPCL_TP_ID) SPR_CNT" ).append("\n"); 
		query.append("                                        FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("                                        WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                                        AND   VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                        AND   SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                        AND   SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                        AND   PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("                                        AND   ANR_SPCL_TP_ID    = 'SPR'" ).append("\n"); 
		query.append("                                      ) A" ).append("\n"); 
		query.append("                                      ,(" ).append("\n"); 
		query.append("                                        SELECT COUNT(ANR_SPCL_TP_ID) AMN_CNT" ).append("\n"); 
		query.append("                                        FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("                                        WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                                        AND   VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                        AND   SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                        AND   SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                        AND   PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("                                        AND   ANR_SPCL_TP_ID    = 'AMN'" ).append("\n"); 
		query.append("                                      ) B      " ).append("\n"); 
		query.append("                                      ,(" ).append("\n"); 
		query.append("                                        SELECT COUNT(ANR_SPCL_TP_ID) ZTG_CNT" ).append("\n"); 
		query.append("                                        FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("                                        WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                                        AND   VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                        AND   SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                        AND   SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                        AND   PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("                                        AND   ANR_SPCL_TP_ID    = 'ZTG'" ).append("\n"); 
		query.append("                                      ) C      " ).append("\n"); 
		query.append("                                      ,(" ).append("\n"); 
		query.append("                                        SELECT COUNT(ANR_SPCL_TP_ID) ETC_CNT" ).append("\n"); 
		query.append("                                        FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("                                        WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                                        AND   VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                        AND   SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                        AND   SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                        AND   PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("                                        AND   ANR_SPCL_TP_ID   IS NULL" ).append("\n"); 
		query.append("                                      ) D      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							 ) " ).append("\n"); 
		query.append("							, ''" ).append("\n"); 
		query.append("					) MAIN_LICENSE" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,'ETA1'                            BKG_DATE_TYPE_ETA1" ).append("\n"); 
		query.append("    ,NVL(TO_CHAR(A.ETA_DT, 'YYYYMMDDHH24MI'), '')   AS BKG_DATE_ETA1    --Arrival DATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'ETD1'                            BKG_DATE_TYPE_ETD1" ).append("\n"); 
		query.append("    ,NVL(TO_CHAR(A.ETD_DT, 'YYYYMMDDHH24MI'),'')   AS BKG_DATE_ETD1    --Departure DATE" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	,'ETD0'                            BKG_DATE_TYPE_ETD0" ).append("\n"); 
		query.append("    ,NVL(B.PRE_ETD,'')                AS BKG_DATE_ETD0     --etd previous port of call" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	,'ETA2'                            BKG_DATE_TYPE_ETA2" ).append("\n"); 
		query.append("    ,NVL(B.NEXT_ETA, '')               AS BKG_DATE_ETA2    -- eta next port of call" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,'BER'                             BKG_LOC_TYPE_BER" ).append("\n"); 
		query.append("    ,A.BRTH_YD_CD                      BKG_LOC_BER          -- Berth" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,'LC1'                             BKG_LOC_TYPE_LC1" ).append("\n"); 
		query.append("    ,@[port_cd]                        BKG_LOC_LC1          -- port of call" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,'LC0'                             BKG_LOC_TYPE_LC0" ).append("\n"); 
		query.append("    ,B.PRE_PORT_CD                     BKG_LOC_LC0          --  previous port of call" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,'LC2'                             BKG_LOC_TYPE_LC2" ).append("\n"); 
		query.append("    ,B.NEXT_PORT_CD                    BKG_LOC_LC2          -- next port of call" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_DG_VSL_SKD A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        SELECT PRE.*, NEX.*" ).append("\n"); 
		query.append("          FROM " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT MAX(VPS_PORT_CD)  PRE_PORT_CD" ).append("\n"); 
		query.append("                   ,MAX(TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MI')) PRE_ETD" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("             WHERE VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("               AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("               AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("               AND CLPT_SEQ IN ( SELECT MAX(B.CLPT_SEQ)" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD A, VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                                 WHERE A.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                   AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                   AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                   AND A.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                   AND NVL(A.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                                   AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                                   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND NVL(B.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                                   AND A.CLPT_SEQ > B.CLPT_SEQ" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("            ) PRE" ).append("\n"); 
		query.append("            ," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT MAX(VPS_PORT_CD) NEXT_PORT_CD" ).append("\n"); 
		query.append("                    ,MAX(TO_CHAR(VPS_ETA_DT, 'YYYYMMDDHH24MI')) NEXT_ETA" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("             WHERE VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("               AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("               AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("               AND CLPT_SEQ IN ( SELECT MIN(B.CLPT_SEQ)" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD A, VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                                 WHERE A.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                   AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                   AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                   AND A.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                   AND NVL(A.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                                   AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                                   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND NVL(B.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                                   AND A.CLPT_SEQ < B.CLPT_SEQ" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("            ) NEX     " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND   A.PORT_CD     = @[port_cd]" ).append("\n"); 

	}
}