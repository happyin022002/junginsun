/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselInformationMgtDBDAOVSLPerformanceVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.16 
* 1.0 Creation
* 
* 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselInformationMgtDBDAOVSLPerformanceVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL Performance 값을 조회한다.
	  * 
	  * //History
	  * 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분
	  * </pre>
	  */
	public VesselInformationMgtDBDAOVSLPerformanceVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOVSLPerformanceVORSQL").append("\n"); 
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
		query.append("SELECT   VS.VSL_SLAN_CD                                         /* OPERATION.LANE */" ).append("\n"); 
		query.append("      ,  VS.PF_SKD_TP_CD" ).append("\n"); 
		query.append("      ,  (SELECT    ROUND(SUM(D.LNK_DIST)/SUM(D.TZTM_HRS),2)" ).append("\n"); 
		query.append("          FROM      VSK_PF_SKD_DTL    D" ).append("\n"); 
		query.append("          WHERE     D.VSL_SLAN_CD     = VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("          AND       D.PF_SVC_TP_CD    = VS.PF_SKD_TP_CD" ).append("\n"); 
		query.append("          )                 AS PF_SPD                           /* OPERATION.P/F SPEED */" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("      ,   (" ).append("\n"); 
		query.append("          --=============================================================================" ).append("\n"); 
		query.append("            SELECT     ROUND(AVG(R.SLP_RT),2)" ).append("\n"); 
		query.append("            FROM       FCM_NOON_RPT     R" ).append("\n"); 
		query.append("            WHERE      1 = 1" ).append("\n"); 
		query.append("            AND        (R.VSL_CD,R.SKD_VOY_NO,R.SKD_DIR_CD)" ).append("\n"); 
		query.append("                       IN" ).append("\n"); 
		query.append("                       (" ).append("\n"); 
		query.append("                        -------------------------------------------------- " ).append("\n"); 
		query.append("                        SELECT     VS.VSL_CD,VS.SKD_VOY_NO,VS.SKD_DIR_CD--,VS.PF_SKD_TP_CD" ).append("\n"); 
		query.append("                        FROM       VSK_VSL_SKD       VS" ).append("\n"); 
		query.append("                        WHERE      1 = 1" ).append("\n"); 
		query.append("                        AND        VS.VSL_SLAN_CD    = VSK_VESSEL_SCHEDULE_PKG.GET_SVC_LANE_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("                        AND        VS.PF_SKD_TP_CD   = VSK_VESSEL_SCHEDULE_PKG.GET_PF_SVC_TP_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("          --=============================================================================          " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          )                AS AVG_SLIP                         /* OPERATION.AVG SLIP */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("      ,  (SELECT    ROUND(SUM(D.LNK_DIST)/(SUM(D.TZTM_HRS)+SUM(D.SEA_BUF_HRS)),2)" ).append("\n"); 
		query.append("          FROM      VSK_PF_SKD_DTL    D" ).append("\n"); 
		query.append("          WHERE     D.VSL_SLAN_CD     = VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("          AND       D.PF_SVC_TP_CD    = VS.PF_SKD_TP_CD" ).append("\n"); 
		query.append("          )                 AS PF_NET_SPD                       /* OPERATION.NET SPEED */" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          -----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("          -----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,   (" ).append("\n"); 
		query.append("          --=============================================================================" ).append("\n"); 
		query.append("            SELECT     	ROUND(SUM(D.TZTM_HRS),2)" ).append("\n"); 
		query.append("            FROM       	VSK_PF_SKD_DTL   D" ).append("\n"); 
		query.append("            WHERE      	1 = 1" ).append("\n"); 
		query.append("            AND        	D.VSL_SLAN_CD	= VSK_VESSEL_SCHEDULE_PKG.GET_SVC_LANE_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("			AND			D.PF_SVC_TP_CD	= VSK_VESSEL_SCHEDULE_PKG.GET_PF_SVC_TP_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("          --=============================================================================          " ).append("\n"); 
		query.append("          )             AS TOT_SEA_TIME_HRS                         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,   -- <<P/F FOC>>---------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("          ROUND" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            (SELECT   SUM(D.LNK_DIST)/AVG(D.LNK_SPD)" ).append("\n"); 
		query.append("             FROM     VSK_PF_SKD_DTL    D" ).append("\n"); 
		query.append("             WHERE    D.VSL_SLAN_CD     = VSK_VESSEL_SCHEDULE_PKG.GET_SVC_LANE_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("             AND      D.PF_SVC_TP_CD    = VSK_VESSEL_SCHEDULE_PKG.GET_PF_SVC_TP_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("            )                " ).append("\n"); 
		query.append("            *" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("               1.0 -- 연료소모량 --" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("          +" ).append("\n"); 
		query.append("          -- <<IN PORT FOC>>-------------------------------------------------- " ).append("\n"); 
		query.append("          ( " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT     ROUND(AVG(((  TO_NUMBER(NVL(T1.GNR_FOIL_CSM_QTY,0))+TO_NUMBER(NVL(T1.GNR_LOW_SULP_FOIL_CSM_QTY,0)))/(TO_NUMBER(SUBSTR(T1.SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(T1.SAIL_HRMNT, 3, 2))/60)))*24),2)" ).append("\n"); 
		query.append("            FROM       FCM_NOON_RPT                          T1" ).append("\n"); 
		query.append("            WHERE      1 = 1" ).append("\n"); 
		query.append("            AND        T1.VSL_CD                             = @[vsl_cd]" ).append("\n"); 
		query.append("            AND        T1.NOON_RPT_DT                        BETWEEN SYSDATE-365 AND SYSDATE" ).append("\n"); 
		query.append("            AND        T1.VSL_CD                             IN (SELECT R.VSL_CD FROM FCM_VSL_CNTR_RGST R WHERE T1.VSL_CD = R.VSL_CD AND NVL(R.TRND_LINE_USE_FLG,' ')<>'N')" ).append("\n"); 
		query.append("            AND        T1.MN_FOIL_CSM_QTY                    <> '0'" ).append("\n"); 
		query.append("            AND        T1.MN_FOIL_CSM_QTY                    IS NOT NULL" ).append("\n"); 
		query.append("            AND        TO_CHAR(TO_NUMBER(SUBSTR(T1.SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(T1.SAIL_HRMNT, 3, 2))/60)) IN ('23','24','25')" ).append("\n"); 
		query.append("            AND        ((T1.SLP_RT > -16)                    AND (T1.SLP_RT < 25))--SLP_RT IS NOT NULL 조건 포함" ).append("\n"); 
		query.append("            AND        TO_NUMBER(NVL(T1.WND_SCL_NO,0))       <= 7" ).append("\n"); 
		query.append("            AND        TO_NUMBER(NVL(T1.SEA_STE_NO,0))       <= 7" ).append("\n"); 
		query.append("            AND        T1.ENG_ML_DIST                        <> '0'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            /24" ).append("\n"); 
		query.append("            *" ).append("\n"); 
		query.append("            (SELECT   SUM(D.ACT_WRK_HRS)" ).append("\n"); 
		query.append("             FROM     VSK_PF_SKD_DTL    D" ).append("\n"); 
		query.append("             WHERE    D.VSL_SLAN_CD     = VSK_VESSEL_SCHEDULE_PKG.GET_SVC_LANE_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("             AND      D.PF_SVC_TP_CD    = VSK_VESSEL_SCHEDULE_PKG.GET_PF_SVC_TP_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("            )      " ).append("\n"); 
		query.append("          )   " ).append("\n"); 
		query.append("          +" ).append("\n"); 
		query.append("          -- <<MNVR IN+OUT PORT FOC>>-------------------------------------------------- " ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            ( " ).append("\n"); 
		query.append("            SELECT    T2.MNVR_CSM_WGT" ).append("\n"); 
		query.append("            FROM      MDM_VSL_CNTR              T1" ).append("\n"); 
		query.append("                   ,  FCM_VSL_CNTR_RGST         T2" ).append("\n"); 
		query.append("            WHERE     1 = 1" ).append("\n"); 
		query.append("            AND       T1.VSL_CD                 = T2.VSL_CD" ).append("\n"); 
		query.append("            AND       T1.VSL_CD                 = @[vsl_cd]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           /24" ).append("\n"); 
		query.append("            *" ).append("\n"); 
		query.append("            (SELECT   SUM(D.MNVR_IN_HRS+D.MNVR_OUT_HRS)" ).append("\n"); 
		query.append("             FROM     VSK_PF_SKD_DTL    D" ).append("\n"); 
		query.append("             WHERE    D.VSL_SLAN_CD     = VSK_VESSEL_SCHEDULE_PKG.GET_SVC_LANE_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("             AND      D.PF_SVC_TP_CD    = VSK_VESSEL_SCHEDULE_PKG.GET_PF_SVC_TP_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("            )         " ).append("\n"); 
		query.append("          ),2)        AS PF_FOC_QTY                       /* OPERATION.FOC AT P/F */" ).append("\n"); 
		query.append("          -----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("          -----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          -----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("          -----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("      ,   (" ).append("\n"); 
		query.append("          -- <<AVG ACT FOC>>-----------------------------------------------------------------------------------" ).append("\n"); 
		query.append("          SELECT   ROUND(SUM( Y.SEA_MN_FOIL_CSM_QTY +Y.SEA_GNR_FOIL_CSM_QTY +Y.SEA_BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("                             +Y.PORT_MN_FOIL_CSM_QTY+Y.PORT_GNR_FOIL_CSM_QTY+Y.PORT_BLR_FOIL_CSM_QTY)/3,2) AS AVG_ACT_FOC_QTY" ).append("\n"); 
		query.append("          FROM     FCM_DEP_RPT       Y" ).append("\n"); 
		query.append("          WHERE    (Y.VSL_CD,Y.SKD_VOY_NO,Y.SKD_DIR_CD)" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                   --=======================================================================================" ).append("\n"); 
		query.append("                   --=======================================================================================" ).append("\n"); 
		query.append("                    SELECT           XX.VSL_CD,XX.SKD_VOY_NO,XX.SKD_DIR_CD" ).append("\n"); 
		query.append("                    FROM             (" ).append("\n"); 
		query.append("                                     --===============================================================================" ).append("\n"); 
		query.append("                    SELECT           ROWNUM                AS RN" ).append("\n"); 
		query.append("                                 ,   X.*" ).append("\n"); 
		query.append("                    FROM             VSK_VSL_PORT_SKD      X" ).append("\n"); 
		query.append("                    START WITH       (X.VSL_CD,X.SKD_VOY_NO,X.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                     IN" ).append("\n"); 
		query.append("                                     (" ).append("\n"); 
		query.append("                                     -----------------------------------------------------------------" ).append("\n"); 
		query.append("                                      SELECT   VS.VSL_CD,VS.SKD_VOY_NO,VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      FROM     VSK_VSL_SKD        VS" ).append("\n"); 
		query.append("                                      WHERE    1 = 1" ).append("\n"); 
		query.append("                                      AND      ROWNUM             = 1" ).append("\n"); 
		query.append("                                      AND      VS.VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("                                      AND      EXISTS             (SELECT   ''" ).append("\n"); 
		query.append("                                                                   FROM     VSK_VSL_PORT_SKD          PS" ).append("\n"); 
		query.append("                                                                   WHERE    1 = 1" ).append("\n"); 
		query.append("                                                                   AND      PS.VSL_CD                 = VS.VSL_CD" ).append("\n"); 
		query.append("                                                                   AND      PS.SKD_VOY_NO             = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                   AND      PS.SKD_DIR_CD             = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                   AND      PS.TURN_PORT_IND_CD       IN ('Y','N')" ).append("\n"); 
		query.append("                                                                   AND      PS.CLPT_SEQ               = (SELECT   MIN(PPS.CLPT_SEQ)" ).append("\n"); 
		query.append("                                                                                                         FROM     VSK_VSL_PORT_SKD  PPS" ).append("\n"); 
		query.append("                                                                                                         WHERE    PPS.VSL_CD        = PS.VSL_CD" ).append("\n"); 
		query.append("                                                                                                         AND      PPS.SKD_VOY_NO    = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                                         AND      PPS.SKD_DIR_CD    = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                                         AND      PPS.TURN_PORT_IND_CD = PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                                                                                         AND      NVL(PS.SKD_CNG_STS_CD,'*')<> 'S'" ).append("\n"); 
		query.append("                                                                                                         )" ).append("\n"); 
		query.append("                                                                   AND      PS.VPS_ETA_DT             < SYSDATE" ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("                                      AND      EXISTS             (SELECT   ''" ).append("\n"); 
		query.append("                                                                   FROM     VSK_VSL_PORT_SKD          PS" ).append("\n"); 
		query.append("                                                                   WHERE    1 = 1" ).append("\n"); 
		query.append("                                                                   AND      PS.VSL_CD                 = VS.VSL_CD" ).append("\n"); 
		query.append("                                                                   AND      PS.SKD_VOY_NO             = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                   AND      PS.SKD_DIR_CD             = VS.SKD_DIR_CD  " ).append("\n"); 
		query.append("                                                                   AND      PS.TURN_PORT_IND_CD       IN ('Y','N')                          " ).append("\n"); 
		query.append("                                                                   AND      PS.CLPT_SEQ               = (SELECT   MAX(PPS.CLPT_SEQ)" ).append("\n"); 
		query.append("                                                                                                         FROM     VSK_VSL_PORT_SKD  PPS" ).append("\n"); 
		query.append("                                                                                                         WHERE    PPS.VSL_CD        = PS.VSL_CD" ).append("\n"); 
		query.append("                                                                                                         AND      PPS.SKD_VOY_NO    = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                                         AND      PPS.SKD_DIR_CD    = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                                         AND      PPS.TURN_PORT_IND_CD = PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                                                                                         AND      NVL(PS.SKD_CNG_STS_CD,'*')<> 'S'" ).append("\n"); 
		query.append("                                                                                                         )" ).append("\n"); 
		query.append("                                                                   AND      PS.VPS_ETD_DT             > SYSDATE" ).append("\n"); 
		query.append("                                                                   )  " ).append("\n"); 
		query.append("                                     -----------------------------------------------------------------           " ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                    CONNECT BY PRIOR X.VSL_CD              = X.VSL_CD" ).append("\n"); 
		query.append("                    AND        PRIOR X.TURN_SKD_VOY_NO     = X.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND        PRIOR X.TURN_SKD_DIR_CD     = X.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND              X.TURN_PORT_FLG       = 'Y'" ).append("\n"); 
		query.append("                                     --===============================================================================" ).append("\n"); 
		query.append("                                     ) XX" ).append("\n"); 
		query.append("                    WHERE            ROWNUM                <= 6       " ).append("\n"); 
		query.append("                   --=======================================================================================" ).append("\n"); 
		query.append("                   --=======================================================================================         " ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("          -- <<AVG ACT FOC>>-----------------------------------------------------------------------------------" ).append("\n"); 
		query.append("          )             AS AVG_ACT_FOC_QTY                  /* OPERATION.AVG ACT FOC */" ).append("\n"); 
		query.append("		 , VS.VSL_CD" ).append("\n"); 
		query.append("FROM     VSK_VSL_SKD        VS" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      ROWNUM             = 1" ).append("\n"); 
		query.append("AND      VS.VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("AND      EXISTS             (SELECT   ''" ).append("\n"); 
		query.append("                             FROM     VSK_VSL_PORT_SKD          PS" ).append("\n"); 
		query.append("                             WHERE    1 = 1" ).append("\n"); 
		query.append("                             AND      PS.VSL_CD                 = VS.VSL_CD" ).append("\n"); 
		query.append("                             AND      PS.SKD_VOY_NO             = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                             AND      PS.SKD_DIR_CD             = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                             --AND      PS.TURN_PORT_IND_CD       IN ('Y','N')" ).append("\n"); 
		query.append("                             AND      PS.CLPT_SEQ               = (SELECT   MIN(PPS.CLPT_SEQ)" ).append("\n"); 
		query.append("                                                                   FROM     VSK_VSL_PORT_SKD  PPS" ).append("\n"); 
		query.append("                                                                   WHERE    PPS.VSL_CD        = PS.VSL_CD" ).append("\n"); 
		query.append("                                                                   AND      PPS.SKD_VOY_NO    = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                   AND      PPS.SKD_DIR_CD    = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                   AND      PPS.TURN_PORT_IND_CD = PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                                                   AND      NVL(PPS.SKD_CNG_STS_CD,'*')<> 'S'" ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("                             AND      PS.VPS_ETA_DT             < SYSDATE " ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("AND      EXISTS             (SELECT   ''" ).append("\n"); 
		query.append("                             FROM     VSK_VSL_PORT_SKD          PS" ).append("\n"); 
		query.append("                             WHERE    1 = 1" ).append("\n"); 
		query.append("                             AND      PS.VSL_CD                 = VS.VSL_CD" ).append("\n"); 
		query.append("                             AND      PS.SKD_VOY_NO             = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                             AND      PS.SKD_DIR_CD             = VS.SKD_DIR_CD  " ).append("\n"); 
		query.append("                             --AND      PS.TURN_PORT_IND_CD       IN ('Y','N')                          " ).append("\n"); 
		query.append("                             AND      PS.CLPT_SEQ               = (SELECT   MAX(PPS.CLPT_SEQ)" ).append("\n"); 
		query.append("                                                                   FROM     VSK_VSL_PORT_SKD  PPS" ).append("\n"); 
		query.append("                                                                   WHERE    PPS.VSL_CD        = PS.VSL_CD" ).append("\n"); 
		query.append("                                                                   AND      PPS.SKD_VOY_NO    = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                   AND      PPS.SKD_DIR_CD    = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                   AND      PPS.TURN_PORT_IND_CD = PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                                                   AND      NVL(PPS.SKD_CNG_STS_CD,'*')<> 'S'" ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("                             AND      PS.VPS_ETD_DT             > SYSDATE" ).append("\n"); 
		query.append("                             )" ).append("\n"); 

	}
}