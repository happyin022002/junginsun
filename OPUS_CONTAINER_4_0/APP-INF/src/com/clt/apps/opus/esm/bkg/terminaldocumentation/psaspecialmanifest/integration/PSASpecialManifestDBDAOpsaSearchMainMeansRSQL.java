/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchMainMeansRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOpsaSearchMainMeansRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAIN MEANS 정보를 조회한다.
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchMainMeansRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchMainMeansRSQL").append("\n"); 
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
		query.append("SELECT '20' AS MAIN_MEANS_TYPE," ).append("\n"); 
		query.append("       NVL(C.PSA_VSL_NM, @[frm_vsl_eng_nm]) AS MAIN_NAME," ).append("\n"); 
		query.append("       NVL(C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD, A.SKD_VOY_NO||A.SKD_DIR_CD) AS MAIN_VVD," ).append("\n"); 
		query.append("       NVL(C.PSA_VOY_DIR_CD, '') AS CON_MAIN_VVD," ).append("\n"); 
		query.append("       (CASE" ).append("\n"); 
		query.append("           WHEN @[d_type] = 'O' OR @[d_type] ='P'" ).append("\n"); 
		query.append("              THEN 'B'" ).append("\n"); 
		query.append("           ELSE 'V'" ).append("\n"); 
		query.append("        END) AS MAIN_MODE," ).append("\n"); 
		query.append("       '' AS MAIN_SSR," ).append("\n"); 
		query.append("       'L' AS L_MAIN_ID_TYPE," ).append("\n"); 
		query.append("       '' AS L_MAIN_ID," ).append("\n"); 
		query.append("       'C' AS C_MAIN_ID_TYPE," ).append("\n"); 
		query.append("       '' AS C_MAIN_ID," ).append("\n"); 
		query.append("       '' AS MAIN_NATION," ).append("\n"); 
		query.append("       '' AS MAIN_LICENSE," ).append("\n"); 
		query.append("       'ETA1' AS BKG_DATE_TYPE_ETA1," ).append("\n"); 
		query.append("       NVL(TO_CHAR(A.VPS_ETA_DT, 'YYYYMMDDHH24MI'), '') AS BKG_DATE_ETA1, --Arrival DATE" ).append("\n"); 
		query.append("       'ETD1' AS BKG_DATE_TYPE_ETD1," ).append("\n"); 
		query.append("       NVL(TO_CHAR(A.VPS_ETA_DT, 'YYYYMMDDHH24MI'), '') AS BKG_DATE_ETD1, --Departure DATE" ).append("\n"); 
		query.append("       'ETD0' AS BKG_DATE_TYPE_ETD0," ).append("\n"); 
		query.append("       NVL(B.PRE_ETD, '') AS BKG_DATE_ETD0,    --etd previous port of call" ).append("\n"); 
		query.append("       'ETA2' AS BKG_DATE_TYPE_ETA2," ).append("\n"); 
		query.append("       NVL(B.NEXT_ETA, '') AS BKG_DATE_ETA2,    -- eta next port of call" ).append("\n"); 
		query.append("       'BER' AS BKG_LOC_TYPE_BER," ).append("\n"); 
		query.append("       A.YD_CD AS BKG_LOC_BER,   -- Berth" ).append("\n"); 
		query.append("       'LC1' AS BKG_LOC_TYPE_LC1," ).append("\n"); 
		query.append("       @[port_cd] AS BKG_LOC_LC1,    -- port of call" ).append("\n"); 
		query.append("       'LC0' AS BKG_LOC_TYPE_LC0," ).append("\n"); 
		query.append("       (SELECT DECODE(PT2.PSA_LOC_CD, NULL, DECODE(PT1.PSA_LOC_CD, NULL, NVL(MDM.UN_LOC_CD, MDM.LOC_CD), PT1.PSA_LOC_CD), PT2.PSA_LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PSA_PORT PT1," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_PORT PT2," ).append("\n"); 
		query.append("               MDM_YARD BV," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BV.YD_CD = B.PRE_PORT_CD" ).append("\n"); 
		query.append("           AND SUBSTR(BV.YD_CD, 1, 5) = PT1.LOC_CD(+)" ).append("\n"); 
		query.append("           AND LENGTH(PT1.TML_CD(+)) = 5" ).append("\n"); 
		query.append("           AND SUBSTR(BV.YD_CD, 1, 5) = PT2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BV.YD_CD = PT2.TML_CD(+)" ).append("\n"); 
		query.append("           AND SUBSTR(BV.YD_CD, 1, 5) = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) BKG_LOC_LC0,    --  previous port of call" ).append("\n"); 
		query.append("       'LC2' BKG_LOC_TYPE_LC2," ).append("\n"); 
		query.append("       (SELECT DECODE(PT2.PSA_LOC_CD, NULL, DECODE(PT1.PSA_LOC_CD, NULL, NVL(MDM.UN_LOC_CD, MDM.LOC_CD), PT1.PSA_LOC_CD), PT2.PSA_LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PSA_PORT PT1," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_PORT PT2," ).append("\n"); 
		query.append("               MDM_YARD BV," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BV.YD_CD = B.NEXT_PORT_CD" ).append("\n"); 
		query.append("           AND SUBSTR(BV.YD_CD, 1, 5) = PT1.LOC_CD(+)" ).append("\n"); 
		query.append("           AND LENGTH(PT1.TML_CD(+)) = 5" ).append("\n"); 
		query.append("           AND SUBSTR(BV.YD_CD, 1, 5) = PT2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BV.YD_CD = PT2.TML_CD(+)" ).append("\n"); 
		query.append("           AND SUBSTR(BV.YD_CD, 1, 5) = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) BKG_LOC_LC2    -- next port of call" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("       (SELECT PRE.*," ).append("\n"); 
		query.append("               NEX.*" ).append("\n"); 
		query.append("          FROM (SELECT MAX(YD_CD) PRE_PORT_CD," ).append("\n"); 
		query.append("                       MAX(TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MI')) PRE_ETD" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                 WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                   AND CLPT_SEQ IN (SELECT CLPT_SEQ - 1" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                         WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                           AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                           AND NVL(SKD_CNG_STS_CD, ' ') <> 'S')) PRE," ).append("\n"); 
		query.append("               (SELECT MAX(YD_CD) NEXT_PORT_CD," ).append("\n"); 
		query.append("                       MAX(TO_CHAR(VPS_ETA_DT, 'YYYYMMDDHH24MI')) NEXT_ETA" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                 WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                   AND CLPT_SEQ IN (SELECT CLPT_SEQ + 1" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                         WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                           AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                           AND NVL(SKD_CNG_STS_CD, ' ') <> 'S')) NEX) B," ).append("\n"); 
		query.append("       BKG_CSTMS_PSA_VVD C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND A.CLPT_IND_SEQ = (SELECT MIN(A.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("         WHERE A.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("           AND A.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("           AND NVL(A.SKD_CNG_STS_CD, ' ') <> 'S')" ).append("\n"); 
		query.append("   AND NVL(A.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("   AND A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 

	}
}