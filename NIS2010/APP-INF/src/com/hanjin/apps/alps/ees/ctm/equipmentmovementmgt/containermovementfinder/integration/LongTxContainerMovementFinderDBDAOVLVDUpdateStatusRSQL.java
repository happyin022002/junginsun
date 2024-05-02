/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOVLVDUpdateStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.29
*@LastModifier : 강환
*@LastVersion : 1.0
* 2013.10.29 강환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwan, Kang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongTxContainerMovementFinderDBDAOVLVDUpdateStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * --------------------------------------------------------
	  * * History
	  * * 2013.07.02 김상수 [CHM-201325058-01] BKG/MVMT VL/VD unmatch Inquiry 기준 값 변경(Yard ->Location)   
	  * 2013.08.23 최덕우 [CHM-201325812] [CTM] Bkg/MVMT VL/VD Unmatch Inquiry기능 보완 (Restuffing, TTL, RHQ)
	  * </pre>
	  */
	public LongTxContainerMovementFinderDBDAOVLVDUpdateStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vsl_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("area_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : LongTxContainerMovementFinderDBDAOVLVDUpdateStatusRSQL").append("\n"); 
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
		query.append("WITH RSLT AS (SELECT CNTR.VVD," ).append("\n"); 
		query.append("                     CNTR.LANE," ).append("\n"); 
		query.append("                     CNTR.ETD," ).append("\n"); 
		query.append("                     CNTR.PORT," ).append("\n"); 
		query.append("                     CNTR.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("                     NVL(BKG.BKG_CNT, 0) AS BKG_CNT," ).append("\n"); 
		query.append("                     NVL(CNTR.EDI, 0) AS EDI," ).append("\n"); 
		query.append("                     NVL(CNTR.MAN, 0) AS MAN," ).append("\n"); 
		query.append("                     NVL(CNTR.EDI + CNTR.MAN, 0) AS TOTAL," ).append("\n"); 
		query.append("                     NVL(CNTR.EDI + CNTR.MAN - BKG.BKG_CNT, 0) AS RESULT" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("-- BKG (S) -------------------------------------------------" ).append("\n"); 
		query.append("                     (SELECT VVD," ).append("\n"); 
		query.append("                             ETD," ).append("\n"); 
		query.append("                             PORT," ).append("\n"); 
		query.append("                             BKG_CGO_TP_CD," ).append("\n"); 
		query.append("                             COUNT(CNTR_NO) AS BKG_CNT" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                             (SELECT BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("                                     VSK.ETD," ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("                                     BV.POL_CD AS PORT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                     BV.POD_CD AS PORT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                     DECODE(BB.BKG_CGO_TP_CD, 'P', 'E', 'F') AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("                                     BC.CNTR_NO" ).append("\n"); 
		query.append("                                FROM BKG_VVD BV," ).append("\n"); 
		query.append("                                     BKG_CONTAINER BC," ).append("\n"); 
		query.append("                                     BKG_BOOKING BB," ).append("\n"); 
		query.append("                                     -- VSK_1 (S) ---------------------------" ).append("\n"); 
		query.append("                                     (SELECT DISTINCT" ).append("\n"); 
		query.append("                                             VS.VSL_CD," ).append("\n"); 
		query.append("                                             VS.SKD_VOY_NO," ).append("\n"); 
		query.append("                                             VS.SKD_DIR_CD," ).append("\n"); 
		query.append("                                             ML.VSL_SLAN_CD," ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("                                             (SELECT TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                               WHERE VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("                                                 AND SKD_VOY_NO = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                 AND SKD_DIR_CD = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                 AND VPS_PORT_CD = VS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                 AND ROWNUM = 1) AS ETD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                             (SELECT TO_CHAR(VPS_ETA_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                               WHERE VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("                                                 AND SKD_VOY_NO = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                 AND SKD_DIR_CD = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                 AND VPS_PORT_CD = VS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                 AND ROWNUM = 1) AS ETD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                             SUBSTR(VS.YD_CD, 0, 5) AS PORT" ).append("\n"); 
		query.append("                                        FROM MDM_VSL_SVC_LANE ML," ).append("\n"); 
		query.append("                                             VSK_VSL_PORT_SKD VS" ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("                                       WHERE VS.VPS_ETD_DT BETWEEN TO_DATE(@[p_date1], 'YYYY-MM-DD') AND TO_DATE(@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                       WHERE VS.VPS_ETA_DT BETWEEN TO_DATE(@[p_date1], 'YYYY-MM-DD') AND TO_DATE(@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                         AND DECODE(ML.VSL_SVC_TP_CD, 'O', 'F', 'T') = @[p_vsl_svc_tp_cd]" ).append("\n"); 
		query.append("                                         AND VS.SLAN_CD = ML.VSL_SLAN_CD" ).append("\n"); 
		query.append("#if (${sel_port} == 'PORT')" ).append("\n"); 
		query.append("                                         AND VS.VPS_PORT_CD LIKE @[p_yard1]||@[p_yard2]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sel_port} == 'AREA')" ).append("\n"); 
		query.append("										AND @[area_cd] = (SELECT SYS_AREA_GRP_ID FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("															WHERE CNT_CD = SUBSTR(VS.VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("																AND CO_IND_CD = 'H')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                      ) VSK" ).append("\n"); 
		query.append("                                      -- VSK_1 (E) ---------------------------" ).append("\n"); 
		query.append("                               WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${p_vvd} != '')" ).append("\n"); 
		query.append("                                 AND VSK.VSL_CD = SUBSTR(@[p_vvd], 0, 4)" ).append("\n"); 
		query.append("                                 AND VSK.SKD_VOY_NO = SUBSTR(@[p_vvd], 5, 4)" ).append("\n"); 
		query.append("                                 AND VSK.SKD_DIR_CD = SUBSTR(@[p_vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                 AND BB.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("                                 AND BV.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("                                 AND BV.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 AND BV.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("                                 AND BV.POL_CD = VSK.PORT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                 AND BV.POD_CD = VSK.PORT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                 AND BV.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                                 AND BC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("#if (${restuff} == 'Y')" ).append("\n"); 
		query.append("								 AND (BC.BKG_NO, BC.CNTR_NO) NOT IN (SELECT  CM.BKG_NO, CM.CNTR_NO" ).append("\n"); 
		query.append("																		FROM    CTM_MVMT_XCH    CX," ).append("\n"); 
		query.append("                                                                            	CTM_MOVEMENT    CM" ).append("\n"); 
		query.append("                                                                    	WHERE   XCH_CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                                                                    		AND     XCH_CNTR_YR = BC.CNMV_YR" ).append("\n"); 
		query.append("                                                                    		AND     CM.CNTR_NO  = XCH_CNTR_NO" ).append("\n"); 
		query.append("                                                                    		AND     CM.CNMV_YR  = XCH_CNTR_YR" ).append("\n"); 
		query.append("                                                                    		AND     CM.CNMV_ID_NO = XCH_CNMV_ID_NO" ).append("\n"); 
		query.append("                                                                    		AND     ROWNUM = 1" ).append("\n"); 
		query.append("                                                                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ttl} == 'Y')" ).append("\n"); 
		query.append("								AND ('TLL', SUBSTR(@[p_yard1], 1, 5)) <> (SELECT CNTR_STS_CD, LOC_CD FROM MST_CONTAINER	WHERE CNTR_NO = BC.CNTR_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                               GROUP BY BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD," ).append("\n"); 
		query.append("                                        VSK.ETD," ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("                                        BV.POL_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                        BV.POD_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                        DECODE(BB.BKG_CGO_TP_CD, 'P', 'E', 'F')," ).append("\n"); 
		query.append("                                        BC.CNTR_NO" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                       GROUP BY VVD," ).append("\n"); 
		query.append("                                ETD," ).append("\n"); 
		query.append("                                PORT," ).append("\n"); 
		query.append("                                BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                     ) BKG," ).append("\n"); 
		query.append("-- BKG (E) -------------------------------------------------" ).append("\n"); 
		query.append("-- CNTR (S) ------------------------------------------------" ).append("\n"); 
		query.append("                     (SELECT VVD," ).append("\n"); 
		query.append("                             LANE," ).append("\n"); 
		query.append("                             ETD," ).append("\n"); 
		query.append("                             PORT," ).append("\n"); 
		query.append("                             BKG_CGO_TP_CD," ).append("\n"); 
		query.append("                             MAX(DECODE(MVMT_INP_TP_CD, 'EDI', BKG_CNT, 0)) AS EDI," ).append("\n"); 
		query.append("                             MAX(DECODE(MVMT_INP_TP_CD, 'MAN', BKG_CNT, 0)) AS MAN" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                             (SELECT CTM.CRNT_VSL_CD||CTM.CRNT_SKD_VOY_NO||CTM.CRNT_SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("                                     VSK.VSL_SLAN_CD AS LANE," ).append("\n"); 
		query.append("                                     VSK.ETD," ).append("\n"); 
		query.append("                                     SUBSTR(CTM.ORG_YD_CD, 0, 5) AS PORT," ).append("\n"); 
		query.append("                                     DECODE(CTM.BKG_CGO_TP_CD, 'P', 'E', 'F') AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("                                     DECODE(CTM.MVMT_INP_TP_CD, 'EDI', 'EDI', 'MAN') AS MVMT_INP_TP_CD," ).append("\n"); 
		query.append("                                     COUNT(CTM.CNTR_NO) AS BKG_CNT" ).append("\n"); 
		query.append("                                FROM CTM_MOVEMENT CTM," ).append("\n"); 
		query.append("                                     -- VSK_2 (S) ---------------------------" ).append("\n"); 
		query.append("                                     (SELECT DISTINCT" ).append("\n"); 
		query.append("                                             VS.VSL_CD," ).append("\n"); 
		query.append("                                             VS.SKD_VOY_NO," ).append("\n"); 
		query.append("                                             VS.SKD_DIR_CD," ).append("\n"); 
		query.append("                                             ML.VSL_SLAN_CD," ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("                                             (SELECT TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                               WHERE VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("                                                 AND SKD_VOY_NO = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                 AND SKD_DIR_CD = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                 AND VPS_PORT_CD = VS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                 AND ROWNUM = 1) AS ETD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                             (SELECT TO_CHAR(VPS_ETA_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                               WHERE VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("                                                 AND SKD_VOY_NO = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                 AND SKD_DIR_CD = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                 AND VPS_PORT_CD = VS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                 AND ROWNUM = 1) AS ETD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                             SUBSTR(VS.YD_CD, 0, 5) AS PORT" ).append("\n"); 
		query.append("                                        FROM MDM_VSL_SVC_LANE ML," ).append("\n"); 
		query.append("                                             VSK_VSL_PORT_SKD VS" ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("                                       WHERE VS.VPS_ETD_DT BETWEEN TO_DATE(@[p_date1], 'YYYY-MM-DD') AND TO_DATE(@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                       WHERE VS.VPS_ETA_DT BETWEEN TO_DATE(@[p_date1], 'YYYY-MM-DD') AND TO_DATE(@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                         AND DECODE(ML.VSL_SVC_TP_CD, 'O', 'F', 'T') = @[p_vsl_svc_tp_cd]" ).append("\n"); 
		query.append("                                         AND VS.SLAN_CD = ML.VSL_SLAN_CD" ).append("\n"); 
		query.append("#if (${sel_port} == 'PORT')" ).append("\n"); 
		query.append("                                         AND VS.VPS_PORT_CD LIKE @[p_yard1]||@[p_yard2]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_port} == 'AREA')" ).append("\n"); 
		query.append("										AND @[area_cd] = (SELECT SYS_AREA_GRP_ID FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                                       		WHERE CNT_CD = SUBSTR(VS.VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("                                                         		AND CO_IND_CD = 'H')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                      ) VSK" ).append("\n"); 
		query.append("                                      -- VSK_2 (E) ---------------------------" ).append("\n"); 
		query.append("                               WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${p_vvd} != '')" ).append("\n"); 
		query.append("                                 AND VSK.VSL_CD = SUBSTR(@[p_vvd], 0, 4)" ).append("\n"); 
		query.append("                                 AND VSK.SKD_VOY_NO = SUBSTR(@[p_vvd], 5, 4)" ).append("\n"); 
		query.append("                                 AND VSK.SKD_DIR_CD = SUBSTR(@[p_vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                 AND CTM.MVMT_STS_CD = @[p_status]" ).append("\n"); 
		query.append("                                 AND CTM.CRNT_VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("                                 AND CTM.CRNT_SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 AND CTM.CRNT_SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("                                 AND SUBSTR(CTM.ORG_YD_CD, 0, 5) = VSK.PORT" ).append("\n"); 
		query.append("								 AND CTM.CNMV_EVNT_DT BETWEEN TO_DATE(@[p_date1], 'YYYY-MM-DD') - 7 AND TO_DATE(@[p_date2], 'YYYY-MM-DD') + 7.99999" ).append("\n"); 
		query.append("                               GROUP BY CTM.CRNT_VSL_CD||CTM.CRNT_SKD_VOY_NO||CTM.CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("                                        VSK.VSL_SLAN_CD," ).append("\n"); 
		query.append("                                        VSK.ETD," ).append("\n"); 
		query.append("                                        SUBSTR(CTM.ORG_YD_CD, 0, 5)," ).append("\n"); 
		query.append("                                        DECODE(CTM.MVMT_INP_TP_CD, 'EDI', 'EDI', 'MAN')," ).append("\n"); 
		query.append("                                        DECODE(CTM.BKG_CGO_TP_CD, 'P', 'E', 'F')" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                        GROUP BY VVD," ).append("\n"); 
		query.append("                                 LANE," ).append("\n"); 
		query.append("                                 ETD," ).append("\n"); 
		query.append("                                 PORT," ).append("\n"); 
		query.append("                                 BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                     ) CNTR" ).append("\n"); 
		query.append("-- CNTR (E) ------------------------------------------------" ).append("\n"); 
		query.append("               WHERE 1 = 1" ).append("\n"); 
		query.append("                 AND BKG.VVD(+) = CNTR.VVD" ).append("\n"); 
		query.append("                 AND BKG.PORT(+) = CNTR.PORT" ).append("\n"); 
		query.append("                 AND BKG.BKG_CGO_TP_CD(+) = CNTR.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("-- END WITH STATEMENT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT VVD," ).append("\n"); 
		query.append("       LANE," ).append("\n"); 
		query.append("       ETD," ).append("\n"); 
		query.append("       PORT," ).append("\n"); 
		query.append("       SUM(BKG1) AS BKG1," ).append("\n"); 
		query.append("       SUM(EDI1) AS EDI1," ).append("\n"); 
		query.append("       SUM(MAN1) AS MAN1," ).append("\n"); 
		query.append("       SUM(TOTAL1) AS TOTAL1," ).append("\n"); 
		query.append("       SUM(RESULT1) AS RESULT1," ).append("\n"); 
		query.append("       SUM(BKG2) AS BKG2," ).append("\n"); 
		query.append("       SUM(EDI2) AS EDI2," ).append("\n"); 
		query.append("       SUM(MAN2) AS MAN2," ).append("\n"); 
		query.append("       SUM(TOTAL2) AS TOTAL2," ).append("\n"); 
		query.append("       SUM(RESULT2) AS RESULT2" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("       (SELECT VVD," ).append("\n"); 
		query.append("               LANE," ).append("\n"); 
		query.append("               ETD," ).append("\n"); 
		query.append("               PORT," ).append("\n"); 
		query.append("               BKG_CNT AS BKG1," ).append("\n"); 
		query.append("               EDI AS EDI1," ).append("\n"); 
		query.append("               MAN AS MAN1," ).append("\n"); 
		query.append("               EDI + MAN AS TOTAL1," ).append("\n"); 
		query.append("               EDI + MAN - BKG_CNT AS RESULT1," ).append("\n"); 
		query.append("               0 AS BKG2," ).append("\n"); 
		query.append("               0 AS EDI2," ).append("\n"); 
		query.append("               0 AS MAN2," ).append("\n"); 
		query.append("               0 AS TOTAL2," ).append("\n"); 
		query.append("               0 AS RESULT2" ).append("\n"); 
		query.append("          FROM RSLT" ).append("\n"); 
		query.append("         WHERE BKG_CGO_TP_CD = 'F' --FULL CARGO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         SELECT VVD," ).append("\n"); 
		query.append("                LANE," ).append("\n"); 
		query.append("                ETD," ).append("\n"); 
		query.append("                PORT," ).append("\n"); 
		query.append("                0 AS BKG1," ).append("\n"); 
		query.append("                0 AS EDI1," ).append("\n"); 
		query.append("                0 AS MAN1," ).append("\n"); 
		query.append("                0 AS TOTAL1," ).append("\n"); 
		query.append("                0 AS RESULT1," ).append("\n"); 
		query.append("                BKG_CNT AS BKG2," ).append("\n"); 
		query.append("                EDI AS EDI2," ).append("\n"); 
		query.append("                MAN AS MAN2," ).append("\n"); 
		query.append("                EDI + MAN AS TOTAL2," ).append("\n"); 
		query.append("                EDI + MAN - BKG_CNT AS RESULT2" ).append("\n"); 
		query.append("           FROM RSLT R" ).append("\n"); 
		query.append("          WHERE BKG_CGO_TP_CD = 'E' --EMPTY CARGO" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" GROUP BY VVD," ).append("\n"); 
		query.append("          LANE," ).append("\n"); 
		query.append("          ETD," ).append("\n"); 
		query.append("          PORT" ).append("\n"); 
		query.append(" ORDER BY VVD," ).append("\n"); 
		query.append("          ETD," ).append("\n"); 
		query.append("          PORT" ).append("\n"); 

	}
}