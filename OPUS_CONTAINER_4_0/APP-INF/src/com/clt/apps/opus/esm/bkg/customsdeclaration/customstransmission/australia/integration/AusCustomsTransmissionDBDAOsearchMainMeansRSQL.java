/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchMainMeansRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchMainMeansRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAIN MEANS 정보를 조회한다.
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchMainMeansRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchMainMeansRSQL").append("\n"); 
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
		query.append("SELECT '20' MAIN_MEANS_TYPE," ).append("\n"); 
		query.append("       NVL((SELECT UPPER(TRIM(VSL_ENG_NM))" ).append("\n"); 
		query.append("              FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("             WHERE VSL_CD = A.VSL_CD), @[frm_vsl_eng_nm]) AS MAIN_NAME," ).append("\n"); 
		query.append("       @[vvd_cd] AS MAIN_VVD," ).append("\n"); 
		query.append("       NVL(A.IB_CSSM_VOY_NO, '') AS CON_MAIN_VVD," ).append("\n"); 
		query.append("       (CASE" ).append("\n"); 
		query.append("           WHEN @[d_type] = 'O' OR @[d_type] ='P'" ).append("\n"); 
		query.append("              THEN 'B'" ).append("\n"); 
		query.append("           ELSE 'V'" ).append("\n"); 
		query.append("        END) AS MAIN_MODE," ).append("\n"); 
		query.append("       '' AS MAIN_SSR," ).append("\n"); 
		query.append("       'L' AS L_MAIN_ID_TYPE," ).append("\n"); 
		query.append("       NVL((SELECT UPPER(TRIM(LLOYD_NO))" ).append("\n"); 
		query.append("              FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("             WHERE VSL_CD = A.VSL_CD ), '') AS L_MAIN_ID," ).append("\n"); 
		query.append("       'C' AS C_MAIN_ID_TYPE," ).append("\n"); 
		query.append("       NVL((SELECT UPPER(TRIM(CALL_SGN_NO))" ).append("\n"); 
		query.append("              FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("             WHERE VSL_CD = A.VSL_CD ), '') AS C_MAIN_ID," ).append("\n"); 
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
		query.append("       B.PRE_PORT_CD AS BKG_LOC_LC0,    --  previous port of call" ).append("\n"); 
		query.append("       'LC2' BKG_LOC_TYPE_LC2," ).append("\n"); 
		query.append("       B.NEXT_PORT_CD AS BKG_LOC_LC2    -- next port of call" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("       (SELECT PRE.PRE_PORT_CD," ).append("\n"); 
		query.append("               PRE.PRE_ETD," ).append("\n"); 
		query.append("               NEX.NEXT_PORT_CD," ).append("\n"); 
		query.append("               NEX.NEXT_ETA" ).append("\n"); 
		query.append("          FROM (SELECT MAX(YD_CD) AS PRE_PORT_CD," ).append("\n"); 
		query.append("                       MAX(TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MI')) AS PRE_ETD" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                 WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                   AND CLPT_SEQ IN (SELECT CLPT_SEQ - 1" ).append("\n"); 
		query.append("                                      FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                     WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                       AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                       AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                       AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                       AND NVL(SKD_CNG_STS_CD, ' ') <> 'S')) PRE," ).append("\n"); 
		query.append("               (SELECT MAX(YD_CD) AS NEXT_PORT_CD," ).append("\n"); 
		query.append("                       MAX(TO_CHAR(VPS_ETA_DT, 'YYYYMMDDHH24MI')) AS NEXT_ETA" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                 WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                   AND CLPT_SEQ IN (SELECT CLPT_SEQ + 1" ).append("\n"); 
		query.append("                                      FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                     WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                       AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                       AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                       AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                       AND NVL(SKD_CNG_STS_CD, ' ') <> 'S')) NEX) B" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND A.CLPT_IND_SEQ = (SELECT MIN(A.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                           FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                          WHERE A.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                            AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                            AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                            AND A.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                            AND NVL(A.SKD_CNG_STS_CD, ' ') <> 'S')" ).append("\n"); 
		query.append("   AND NVL(A.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 

	}
}