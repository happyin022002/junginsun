/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchBlInfoRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN MF_STS_CD = 'D'" ).append("\n"); 
		query.append("            THEN RPAD('A01' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || LOC_AMS_PORT || 'D' || RPAD(BL_NO, 12, ' ') || RPAD(' ', 10, ' ') || '03', 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("            WHEN SND_YN = 'Y'" ).append("\n"); 
		query.append("            THEN RPAD('A01' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || LOC_AMS_PORT || 'D' || RPAD(BL_NO, 12, ' ') || RPAD(' ', 10, ' ') || '03', 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("              || RPAD('A01' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || LOC_AMS_PORT || 'A' || RPAD(BL_NO, 12, ' ') || RPAD(' ', 10, ' ') || '03', 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("            ELSE RPAD('A01' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || LOC_AMS_PORT || 'A' || RPAD(BL_NO, 12, ' ') || RPAD(' ', 10, ' ') || '03', 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("        END A01" ).append("\n"); 
		query.append("      ,RPAD('B01' || RPAD(BL_NO, 12, ' ') || LPAD(CSTMS_POL_AMS_PORT_CD, 5, '0') || PCK_QTY || RPAD(AMS_PCK_TP_CD, 5, ' ') || CGO_WGT || WGT_UT_CD || LADING_STATUS ||" ).append("\n"); 
		query.append("            CASE WHEN @[trsm_msg_tp_cd] <> 'AI'" ).append("\n"); 
		query.append("                 THEN ' '" ).append("\n"); 
		query.append("                 WHEN IT_ITNO LIKE '%' || IT_NO || '%' AND MF_NO = 'X'" ).append("\n"); 
		query.append("                 THEN '1'" ).append("\n"); 
		query.append("                 WHEN IT_ITNO LIKE '%' || IT_NO || '%' AND MF_NO <> 'X'" ).append("\n"); 
		query.append("                 THEN ' '" ).append("\n"); 
		query.append("                 ELSE '0'" ).append("\n"); 
		query.append("             END" ).append("\n"); 
		query.append("           , 80, ' ') || CHR(10) AS B01" ).append("\n"); 
		query.append("      ,RPAD('B01' || RPAD(BL_NO, 12, ' ') || LPAD(CSTMS_POL_AMS_PORT_CD, 5, '0') || PCK_QTY || RPAD(AMS_PCK_TP_CD, 5, ' ') || CGO_WGT || WGT_UT_CD || LADING_STATUS_ISF5" ).append("\n"); 
		query.append("           , 80, ' ') || CHR(10) AS B01ISF5" ).append("\n"); 
		query.append("      ,RPAD('B02' || LPAD(TRUNC(NVL(MEAS_QTY,0)), 8, '0') || '  ' || 'CM' || RPAD(NVL(UPPER(POR_NM), ' '), 17, ' ') || RPAD(' ', 12, ' ') || SECOND_NOTIFY_PARTY1 || SECOND_NOTIFY_PARTY2 || RPAD(NVL(POL_LAST_AMS, ' '), 5, ' ')" ).append("\n"); 
		query.append("           , 80, ' ') || CHR(10) AS B02" ).append("\n"); 
		query.append("      ,RPAD('B04' || 'OB ' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || MF_NO, 80, ' ') || CHR(10) AS B04" ).append("\n"); 
		query.append("      ,RPAD('B04' || 'OL ' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || PRE_MF_NO, 80, ' ') || CHR(10) B04_2" ).append("\n"); 
		query.append("      ,RPAD('B04' || 'CSK' || DECODE(SUBSTR(FPOD_CD,1,2), 'US', DEL_AMS_PORT_CD, CSTMS_POD_AMS_PORT_CD), 80, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       RPAD('B04' || 'CSK' || DEL_AMS_PORT_CD, 80, ' ') || CHR(10) B04ISF5" ).append("\n"); 
		query.append("      ,IT_ITNO" ).append("\n"); 
		query.append("      ,IT_ITTYPE" ).append("\n"); 
		query.append("      ,IT_HUB" ).append("\n"); 
		query.append("      ,IT_LST_USA" ).append("\n"); 
		query.append("      ,IT_DEL" ).append("\n"); 
		query.append("      ,WGT_VAL" ).append("\n"); 
		query.append("      ,IT_PKG_QTY" ).append("\n"); 
		query.append("      ,IT_PKG_AMS" ).append("\n"); 
		query.append("      ,IT_IPI_LOCAL" ).append("\n"); 
		query.append("      ,CMDT_CD" ).append("\n"); 
		query.append("      ,AMS_CODE" ).append("\n"); 
		query.append("      ,MF_NO" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,DECODE(MF_NO, 'X', BL_NO, MF_NO) AS MBL_NO" ).append("\n"); 
		query.append("      ,DECODE(ACT_FILE_SKD_DIR_CD, 'E', 'E', SKD_DIR_CD) AS ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,FPOD_CD" ).append("\n"); 
		query.append("      ,BOOKING_POD_CD" ).append("\n"); 
		query.append("      ,MF_STS_CD" ).append("\n"); 
		query.append("      ,CSTMS_LOC_CD" ).append("\n"); 
		query.append("      ,VPS_ETA_DT" ).append("\n"); 
		query.append("      ,VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,CSTMS_POD_CD" ).append("\n"); 
		query.append("      ,CSTMS_POL_CD" ).append("\n"); 
		query.append("      ,FULL_MTY_CD" ).append("\n"); 
		query.append("      ,IT_NO" ).append("\n"); 
		query.append("      ,CSTMS_PORT_CD" ).append("\n"); 
		query.append("      ,LOC_AMS_PORT" ).append("\n"); 
		query.append("      ,VSL_ENG_NM" ).append("\n"); 
		query.append("      ,LLOYD_NO" ).append("\n"); 
		query.append("      ,VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("      ,NEXT_VSL_ENG_NM" ).append("\n"); 
		query.append("      ,PTT_FRM_CD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,VVD_ORDER" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (SELECT NVL((SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                     WHERE CNT_CD='US'" ).append("\n"); 
		query.append("                       AND CSTMS_DIV_ID='AMS_TML_CD_MAP'" ).append("\n"); 
		query.append("                       AND ATTR_CTNT1= DECODE(VVD.POD_YD_CD, '', IT.POD_NOD_CD, VVD.POD_YD_CD)" ).append("\n"); 
		query.append("                       AND ROWNUM=1" ).append("\n"); 
		query.append("                    ), NVL(LOC7.LOC_AMS_PORT_CD, '    ')) AS LOC_AMS_PORT" ).append("\n"); 
		query.append("              ,COM_ConstantMgr_PKG.COM_getScacCode_FNC() || IT.VSL_CD || IT.SKD_VOY_NO || IT.SKD_DIR_CD || IT.CSTMS_POD_CD AS CRR_BAT_NO" ).append("\n"); 
		query.append("              ,DECODE(IT.FULL_MTY_CD," ).append("\n"); 
		query.append("                       'M', LPAD(NVL((SELECT COUNT(BC.CNTR_NO) FROM BKG_CONTAINER BC WHERE BC.BKG_NO = BKG.BKG_NO), '1'), 10, '0')" ).append("\n"); 
		query.append("                          , LPAD(TRUNC(NVL(IT.PCK_QTY,0)), 10, '0')" ).append("\n"); 
		query.append("                     ) AS PCK_QTY" ).append("\n"); 
		query.append("              ,DECODE(IT.FULL_MTY_CD," ).append("\n"); 
		query.append("                       'M', LPAD(NVL((SELECT COUNT(BC.CNTR_NO) FROM BKG_CONTAINER BC WHERE BC.BKG_NO = BKG.BKG_NO), '1'), 10, '0')" ).append("\n"); 
		query.append("                          , LPAD(TRUNC(NVL(IT.CGO_WGT,0)), 10, '0')" ).append("\n"); 
		query.append("                     ) AS CGO_WGT" ).append("\n"); 
		query.append("              ,NVL(NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_PCK_TP_CONV AA" ).append("\n"); 
		query.append("                         WHERE AA.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND AA.PCK_TP_CD = IT.AMS_PCK_TP_CD" ).append("\n"); 
		query.append("                        ),IT.AMS_PCK_TP_CD)" ).append("\n"); 
		query.append("                   ,'PKGS') AS AMS_PCK_TP_CD" ).append("\n"); 
		query.append("              ,NVL(SUBSTR(IT.WGT_UT_CD, 1, 2),'KG') AS WGT_UT_CD" ).append("\n"); 
		query.append("              ,DECODE(IT.FULL_MTY_CD," ).append("\n"); 
		query.append("                       'M', DECODE(IBD.CSTMS_CLR_TP_CD, 'F', 'B', 'V','B','2')" ).append("\n"); 
		query.append("                           ,DECODE(IBD.CSTMS_CLR_TP_CD," ).append("\n"); 
		query.append("                                  'F', DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER',DECODE(IT.CSTMS_FILE_TP_CD, '3', 'B', 'O'), 'P')," ).append("\n"); 
		query.append("                                  'V', DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER',DECODE(IT.CSTMS_FILE_TP_CD, '3', 'B', 'O'), 'P')," ).append("\n"); 
		query.append("                                  DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER', DECODE(IT.CSTMS_FILE_TP_CD, '3', '0', 'M'),  'N')" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                     ) AS LADING_STATUS" ).append("\n"); 
		query.append("              ,DECODE(IT.FULL_MTY_CD," ).append("\n"); 
		query.append("                       'M', DECODE(IBD.CSTMS_CLR_TP_CD, 'F', 'B', 'V','B','2')" ).append("\n"); 
		query.append("                           ,DECODE(IBD.CSTMS_CLR_TP_CD," ).append("\n"); 
		query.append("                                  'F', DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER',DECODE(IT.CSTMS_FILE_TP_CD, '3', 'Q', 'Q'), 'R')," ).append("\n"); 
		query.append("                                  'V', DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER',DECODE(IT.CSTMS_FILE_TP_CD, '3', 'Q', 'Q'), 'R')," ).append("\n"); 
		query.append("                                  DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER', DECODE(IT.CSTMS_FILE_TP_CD, '3', 'T', 'T'),  'S')" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                     ) AS LADING_STATUS_ISF5" ).append("\n"); 
		query.append("              ,DECODE(IT.MF_NO, NULL, (SELECT NVL(MAX(DECODE(ATTR_CTNT2, 'ALL', ATTR_CTNT3, IT.CSTMS_POD_CD, ATTR_CTNT3)), '    ')" ).append("\n"); 
		query.append("                                         FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                                        WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                                          AND CSTMS_DIV_ID = 'SC_FIRMS_CD_MAP'" ).append("\n"); 
		query.append("                                          AND ATTR_CTNT1 = BKG.SC_NO" ).append("\n"); 
		query.append("                                          AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                                     ,COM_ConstantMgr_PKG.COM_getScacCode_FNC()" ).append("\n"); 
		query.append("                     ) AS SECOND_NOTIFY_PARTY1" ).append("\n"); 
		query.append("              ,(SELECT NVL(MAX(DECODE (ATTR_CTNT1, IT.POD_NOD_CD, ATTR_CTNT2)), '    ')" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                 WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                   AND CSTMS_DIV_ID = 'LOC_FIRMS_CD_MAP'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("               ) AS SECOND_NOTIFY_PARTY2" ).append("\n"); 
		query.append("              ,(SELECT LOC_AMS_PORT_CD" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                      ,MDM_LOCATION     B" ).append("\n"); 
		query.append("                 WHERE A.VPS_PORT_CD = B.LOC_CD" ).append("\n"); 
		query.append("                   AND A.VSL_CD      = IT.VSL_CD" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO  = IT.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD  = IT.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND NVL(A.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                   AND A.VPS_ETA_DT  = (SELECT MAX(VPS_ETA_DT)" ).append("\n"); 
		query.append("                                          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                         WHERE VSL_CD      = IT.VSL_CD" ).append("\n"); 
		query.append("                                           AND SKD_VOY_NO  = IT.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND SKD_DIR_CD  = IT.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                           AND VPS_ETA_DT  < (SELECT MIN(VPS_ETA_DT)" ).append("\n"); 
		query.append("                                                                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                               WHERE VSL_CD        = IT.VSL_CD" ).append("\n"); 
		query.append("                                                                 AND SKD_VOY_NO    = IT.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                 AND SKD_DIR_CD    = IT.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                 AND CLPT_SEQ <> 1" ).append("\n"); 
		query.append("                                                                 AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                                                 AND VPS_PORT_CD   = IT.CSTMS_PORT_CD" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("                                           AND VPS_PORT_CD NOT IN (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                                                                     FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                                                                    WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                                                                      AND CSTMS_DIV_ID='CANAL_LOC_CD')" ).append("\n"); 
		query.append("                                           AND SUBSTR(VPS_PORT_CD,1,2) NOT IN ('US', (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                                                                                       FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                                                                                      WHERE CNT_CD='US'" ).append("\n"); 
		query.append("                                                                                        AND CSTMS_DIV_ID='US_CNT_CD_LIST'))" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) AS POL_LAST_AMS" ).append("\n"); 
		query.append("              ,NVL((SELECT TO_CHAR(MAX(VPS_ETA_DT),'MMDDRR')" ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                     WHERE VSL_CD = IT.VSL_CD" ).append("\n"); 
		query.append("                       AND SKD_VOY_NO = IT.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND SKD_DIR_CD = IT.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND VPS_PORT_CD = IT.CSTMS_PORT_CD" ).append("\n"); 
		query.append("                       AND VPS_ETA_DT <= (SELECT MIN(VPS_ETA_DT)" ).append("\n"); 
		query.append("                                            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                           WHERE VSL_CD = IT.VSL_CD" ).append("\n"); 
		query.append("                                             AND SKD_VOY_NO = IT.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             AND SKD_DIR_CD = IT.SKD_DIR_CD" ).append("\n"); 
		query.append("                                             AND CLPT_SEQ <> 1" ).append("\n"); 
		query.append("                                             AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                             AND VPS_PORT_CD = IT.CSTMS_POD_CD)" ).append("\n"); 
		query.append("                   ), NVL((SELECT TO_CHAR(MAX(VPS_ETA_DT),'MMDDRR')" ).append("\n"); 
		query.append("                             FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                            WHERE VSL_CD = IT.VSL_CD" ).append("\n"); 
		query.append("                              AND SKD_VOY_NO = IT.SKD_VOY_NO" ).append("\n"); 
		query.append("                              AND SKD_DIR_CD = IT.SKD_DIR_CD" ).append("\n"); 
		query.append("                              AND VPS_PORT_CD = IT.CSTMS_PORT_CD" ).append("\n"); 
		query.append("                              AND VPS_ETA_DT <= (SELECT MAX(VPS_ETA_DT)" ).append("\n"); 
		query.append("                                                   FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                  WHERE VSL_CD = IT.VSL_CD" ).append("\n"); 
		query.append("                                                    AND SKD_VOY_NO = IT.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    AND SKD_DIR_CD = IT.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                    AND CLPT_SEQ <> 1" ).append("\n"); 
		query.append("                                                    AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                                    AND VPS_PORT_CD = IT.CSTMS_POD_CD)" ).append("\n"); 
		query.append("                          ), '')" ).append("\n"); 
		query.append("                  ) AS VPS_ETA_DT" ).append("\n"); 
		query.append("              ,NVL(NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_PCK_TP_CONV AA" ).append("\n"); 
		query.append("                         WHERE AA.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND AA.PCK_TP_CD = IT.AMS_PCK_TP_CD" ).append("\n"); 
		query.append("                        ),IT.AMS_PCK_TP_CD)" ).append("\n"); 
		query.append("                  ,'PKG  ') AS IT_PKG_AMS" ).append("\n"); 
		query.append("              ,(SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                 WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                   AND CSTMS_DIV_ID = 'AMS_ASGN_CO_CD'" ).append("\n"); 
		query.append("                   AND CSTMS_DIV_ID_SEQ = 1" ).append("\n"); 
		query.append("                   AND DELT_FLG ='N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) AS IT_NO" ).append("\n"); 
		query.append("              ,DOC.MEAS_QTY" ).append("\n"); 
		query.append("              ,LOC4.LOC_NM AS POR_NM" ).append("\n"); 
		query.append("              ,IT.VSL_CD" ).append("\n"); 
		query.append("              ,IT.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,IT.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,IT.CSTMS_POD_CD" ).append("\n"); 
		query.append("              ,IT.CSTMS_POL_CD" ).append("\n"); 
		query.append("              ,VSL.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("              ,VSL.VSL_ENG_NM" ).append("\n"); 
		query.append("              ,VSL.LLOYD_NO" ).append("\n"); 
		query.append("              ,NVL(LOC.LOC_AMS_PORT_CD, ' ') AS CSTMS_POL_AMS_PORT_CD" ).append("\n"); 
		query.append("              ,IT.PRE_MF_NO" ).append("\n"); 
		query.append("              ,LOC6.LOC_AMS_PORT_CD AS DEL_AMS_PORT_CD" ).append("\n"); 
		query.append("              ,LOC5.LOC_AMS_PORT_CD AS CSTMS_POD_AMS_PORT_CD" ).append("\n"); 
		query.append("              ,NVL(IBD.IBD_TRSP_NO,' ') IT_ITNO" ).append("\n"); 
		query.append("              ,NVL(IBD.IBD_TRSP_TP_CD,'  ') IT_ITTYPE -- 61,62,63" ).append("\n"); 
		query.append("              ,NVL(IT.HUB_LOC_CD,' ') IT_HUB" ).append("\n"); 
		query.append("              ,NVL(IT.USA_LST_LOC_CD,' ') IT_LST_USA" ).append("\n"); 
		query.append("              ,NVL(IT.DEL_CD,' ') IT_DEL" ).append("\n"); 
		query.append("              ,SUBSTR(TO_CHAR(IT.CGO_WGT*20,'09999999'),2) WGT_VAL" ).append("\n"); 
		query.append("              ,SUBSTR(TO_CHAR(NVL(IT.PCK_QTY,0),'0999999999'),2) IT_PKG_QTY" ).append("\n"); 
		query.append("              ,NVL(IBD.CSTMS_CLR_TP_CD,' ') IT_IPI_LOCAL" ).append("\n"); 
		query.append("              ,NVL(BKG.CMDT_CD,' ') CMDT_CD" ).append("\n"); 
		query.append("              ,DECODE(IBD.IBD_TRSP_TP_CD,'61',LOC3.LOC_AMS_PORT_CD,'62',LOC2.LOC_AMS_PORT_CD,'63',LOC2.LOC_AMS_PORT_CD,LOC3.LOC_AMS_PORT_CD) AMS_CODE" ).append("\n"); 
		query.append("              ,SUBSTR(IT.BL_NO, 1, 12) BL_NO --RPAD(IT.BL_NO, 12, ' ') BL_NO" ).append("\n"); 
		query.append("              ,NVL(IT.MF_NO, 'X') MF_NO" ).append("\n"); 
		query.append("              ,ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append("              ,IT.POD_CD FPOD_CD" ).append("\n"); 
		query.append("              ,BKG.POD_CD BOOKING_POD_CD" ).append("\n"); 
		query.append("              ,IT.MF_STS_CD" ).append("\n"); 
		query.append("              ,IT.CSTMS_LOC_CD" ).append("\n"); 
		query.append("              ,IT.FULL_MTY_CD" ).append("\n"); 
		query.append("              ,IT.CSTMS_PORT_CD" ).append("\n"); 
		query.append("              ,IT.BKG_NO" ).append("\n"); 
		query.append("              ,(SELECT C.VSL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VSL_CNTR C" ).append("\n"); 
		query.append("                 WHERE C.VSL_CD = (SELECT /*+ INDEX_ASC(BKG_VVD XPKBKG_VVD) */ B.VSL_CD" ).append("\n"); 
		query.append("                                     FROM BKG_VVD B" ).append("\n"); 
		query.append("                                    WHERE B.BKG_NO = IT.BKG_NO" ).append("\n"); 
		query.append("                                      AND B.VSL_PRE_PST_CD||B.VSL_SEQ > VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1 )) AS NEXT_VSL_ENG_NM" ).append("\n"); 
		query.append("              ,IBD.PTT_FRM_CD" ).append("\n"); 
		query.append("              ,NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_ADV_SND_LOG     SND" ).append("\n"); 
		query.append("                          ,BKG_CSTMS_ADV_RCV_LOG     RCV" ).append("\n"); 
		query.append("                          ,BKG_CSTMS_ADV_EDI_BL_RSPN EDI" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND EDI.CNT_CD     = SND.CNT_CD" ).append("\n"); 
		query.append("                       AND EDI.CRR_BAT_NO = SND.CRR_BAT_NO" ).append("\n"); 
		query.append("                       AND EDI.BL_NO      = IT.BL_NO" ).append("\n"); 
		query.append("                       AND SND.CNT_CD     = RCV.CNT_CD" ).append("\n"); 
		query.append("                       AND SND.CRR_BAT_NO = RCV.CRR_BAT_NO" ).append("\n"); 
		query.append("                       AND SND.IO_BND_CD  = RCV.IO_BND_CD" ).append("\n"); 
		query.append("                       AND SND.CNT_CD     = 'US'" ).append("\n"); 
		query.append("                       AND SND.IO_BND_CD  = 'I'" ).append("\n"); 
		query.append("                       AND SND.TRSM_MSG_TP_ID IN ('MI','AI')" ).append("\n"); 
		query.append("                       AND SND.VSL_CD     = IT.VSL_CD" ).append("\n"); 
		query.append("                       AND SND.SKD_VOY_NO = IT.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND SND.SKD_DIR_CD = IT.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND SND.POL_CD     = IT.CSTMS_POL_CD" ).append("\n"); 
		query.append("                       AND SND.POD_CD     = IT.CSTMS_POD_CD" ).append("\n"); 
		query.append("                       AND NOT EXISTS (SELECT '1'" ).append("\n"); 
		query.append("                                        FROM BKG_CSTMS_ADV_RCV_LOG_DTL DTL" ).append("\n"); 
		query.append("                                       WHERE RCV.CNT_CD = DTL.CNT_CD" ).append("\n"); 
		query.append("                                         AND RCV.RCV_DT = DTL.RCV_DT" ).append("\n"); 
		query.append("                                         AND RCV.IO_BND_CD = DTL.IO_BND_CD" ).append("\n"); 
		query.append("                                         AND RCV.RCV_SEQ = DTL.RCV_SEQ" ).append("\n"); 
		query.append("                                         AND DTL.MSG_DESC LIKE 'W01' || EDI.BL_NO || '%'" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("               ), 'N') AS SND_YN" ).append("\n"); 
		query.append("              ,VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ VVD_ORDER" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_BL  IT" ).append("\n"); 
		query.append("              ,MDM_LOCATION      LOC  --CSTMS_POL_CD" ).append("\n"); 
		query.append("              ,MDM_LOCATION      LOC2 --USA_LST_LOC_CD" ).append("\n"); 
		query.append("              ,MDM_LOCATION      LOC3 --HUB_LOC_CD" ).append("\n"); 
		query.append("              ,MDM_LOCATION      LOC4 --POR_CD" ).append("\n"); 
		query.append("              ,MDM_LOCATION      LOC5 --CSTMS_POD_CD" ).append("\n"); 
		query.append("              ,MDM_LOCATION      LOC6 --DEL_CD" ).append("\n"); 
		query.append("              ,MDM_LOCATION      LOC7 --CSTMS_PORT_CD" ).append("\n"); 
		query.append("              ,BKG_BOOKING       BKG" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("              ,BKG_BL_DOC        DOC" ).append("\n"); 
		query.append("              ,MDM_VSL_CNTR      VSL" ).append("\n"); 
		query.append("              ,BKG_VVD           VVD" ).append("\n"); 
		query.append("         WHERE IT.CNT_CD         = 'US'" ).append("\n"); 
		query.append("           AND IT.BL_NO          = @[bl_no]" ).append("\n"); 
		query.append("           AND IT.CSTMS_POL_CD   = LOC.LOC_CD" ).append("\n"); 
		query.append("           AND IT.USA_LST_LOC_CD = LOC2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND IT.HUB_LOC_CD     = LOC3.LOC_CD(+)" ).append("\n"); 
		query.append("           AND IT.POR_CD         = LOC4.LOC_CD(+)" ).append("\n"); 
		query.append("           AND IT.CSTMS_POD_CD   = LOC5.LOC_CD(+)" ).append("\n"); 
		query.append("           AND IT.DEL_CD         = LOC6.LOC_CD(+)" ).append("\n"); 
		query.append("           AND IT.CSTMS_PORT_CD  = LOC7.LOC_CD(+)" ).append("\n"); 
		query.append("           AND IT.BKG_NO         = BKG.BKG_NO(+)" ).append("\n"); 
		query.append("           AND IT.BL_NO          = IBD.BL_NO(+)" ).append("\n"); 
		query.append("           AND IT.CNT_CD         = IBD.CNT_CD(+)" ).append("\n"); 
		query.append("           AND IT.BKG_NO         = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND IT.VSL_CD         = VSL.VSL_CD" ).append("\n"); 
		query.append("           AND IT.BKG_NO         = VVD.BKG_NO(+)" ).append("\n"); 
		query.append("           AND IT.VSL_CD         = VVD.VSL_CD(+)" ).append("\n"); 
		query.append("           AND IT.SKD_VOY_NO     = VVD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND IT.SKD_DIR_CD     = VVD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    ) BL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY VVD_ORDER DESC" ).append("\n"); 

	}
}