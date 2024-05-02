/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOVLVDUpdateStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.05.06 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
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
	  *    
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
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
		query.append("WITH RSLT AS (" ).append("\n"); 
		query.append("SELECT B.VVD," ).append("\n"); 
		query.append("B.LANE," ).append("\n"); 
		query.append("B.ETD," ).append("\n"); 
		query.append("B.PORT," ).append("\n"); 
		query.append("B.CGO_TP," ).append("\n"); 
		query.append("NVL (A.BKG_CNT, 0) AS BKG_CNT," ).append("\n"); 
		query.append("NVL (B.EDI, 0) AS EDI," ).append("\n"); 
		query.append("NVL (B.MAN, 0) AS MAN," ).append("\n"); 
		query.append("NVL (B.EDI + B.MAN, 0) AS TOTAL," ).append("\n"); 
		query.append("NVL (B.EDI + B.MAN - A.BKG_CNT, 0) AS RESULT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT VVD," ).append("\n"); 
		query.append("LANE," ).append("\n"); 
		query.append("ETD," ).append("\n"); 
		query.append("PORT," ).append("\n"); 
		query.append("CGO_TP," ).append("\n"); 
		query.append("COUNT(CNTR_NO) BKG_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("VP.VSL_SLAN_CD AS LANE," ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("TO_CHAR(VP.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') ETD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("TO_CHAR(VP.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') ETD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("V.POL_YD_CD PORT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("V.POD_YD_CD PORT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--VP.VPS_PORT_CD AS PORT," ).append("\n"); 
		query.append("DECODE(B.BKG_CGO_TP_CD, 'P', 'E', 'F') CGO_TP," ).append("\n"); 
		query.append("C.CNTR_NO" ).append("\n"); 
		query.append("FROM BKG_VVD V," ).append("\n"); 
		query.append("BKG_CONTAINER C," ).append("\n"); 
		query.append("BKG_BOOKING B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("V.VPS_ETD_DT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("V.VPS_ETA_DT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("V.YD_CD," ).append("\n"); 
		query.append("L.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE L," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("WHERE V.VPS_ETD_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE V.VPS_ETA_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND V.SLAN_CD = L.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND DECODE(L.VSL_SVC_TP_CD, 'O', 'F', 'T') = @[p_vsl_svc_tp_cd]" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD LIKE @[p_yard1] || @[p_yard2] || '%'" ).append("\n"); 
		query.append("--                  AND V.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append(") VP" ).append("\n"); 
		query.append("WHERE V.VSL_CD = VP.VSL_CD" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = VP.SKD_VOY_NO" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = VP.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("AND V.POL_CD = SUBSTR (VP.YD_CD, 1, 5)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND V.POD_CD = SUBSTR (VP.YD_CD, 1, 5)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_vvd} != '')" ).append("\n"); 
		query.append("AND V.VSL_CD  = SUBSTR(@[p_vvd], 0, 4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO  = SUBSTR(@[p_vvd], 5, 4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD  = SUBSTR(@[p_vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND V.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY VVD, LANE, ETD, PORT, CGO_TP ) A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT VVD," ).append("\n"); 
		query.append("LANE," ).append("\n"); 
		query.append("ETD," ).append("\n"); 
		query.append("PORT," ).append("\n"); 
		query.append("CGO_TP," ).append("\n"); 
		query.append("MAX(DECODE (TY, 'EDI', BKG_CNT, 0)) AS EDI," ).append("\n"); 
		query.append("MAX (DECODE (TY, 'MAN', BKG_CNT, 0)) AS MAN" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT VP.VSL_CD||VP.SKD_VOY_NO||VP.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("VP.VSL_SLAN_CD AS LANE," ).append("\n"); 
		query.append("TO_CHAR(ETD, 'YYYY-MM-DD HH24:MI') ETD," ).append("\n"); 
		query.append("C.ORG_YD_CD AS PORT," ).append("\n"); 
		query.append("DECODE(MVMT_INP_TP_CD, 'EDI', 'EDI', 'MAN') TY," ).append("\n"); 
		query.append("DECODE(C.BKG_CGO_TP_CD, 'P', 'E', 'F') CGO_TP," ).append("\n"); 
		query.append("COUNT(C.CNTR_NO) BKG_CNT" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("SLAN_CD," ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("VPS_ETD_DT ETD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("VPS_ETA_DT ETD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("L.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE L," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("WHERE V.VPS_ETD_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE V.VPS_ETA_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DECODE(L.VSL_SVC_TP_CD, 'O', 'F', 'T') = @[p_vsl_svc_tp_cd]" ).append("\n"); 
		query.append("AND L.VSL_SLAN_CD = V.SLAN_CD" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD LIKE @[p_yard1] || @[p_yard2] || '%'" ).append("\n"); 
		query.append("--                  AND V.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append(") VP" ).append("\n"); 
		query.append("WHERE C.CRNT_VSL_CD = VP.VSL_CD" ).append("\n"); 
		query.append("AND C.CRNT_SKD_VOY_NO = VP.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.CRNT_SKD_DIR_CD = VP.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SUBSTR (C.ORG_YD_CD, 1, 5) = SUBSTR (VP.YD_CD, 1, 5)" ).append("\n"); 
		query.append("#if (${p_vvd} != '')" ).append("\n"); 
		query.append("AND VP.VSL_CD  = SUBSTR(@[p_vvd], 0, 4)" ).append("\n"); 
		query.append("AND VP.SKD_VOY_NO  = SUBSTR(@[p_vvd], 5, 4)" ).append("\n"); 
		query.append("AND VP.SKD_DIR_CD  = SUBSTR(@[p_vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND C.MVMT_STS_CD = @[p_status]" ).append("\n"); 
		query.append("GROUP BY VP.VSL_CD||VP.SKD_VOY_NO||VP.SKD_DIR_CD, VP.VSL_SLAN_CD, ETD, C.ORG_YD_CD, DECODE(MVMT_INP_TP_CD, 'EDI', 'EDI', 'MAN'), DECODE(C.BKG_CGO_TP_CD, 'P', 'E', 'F') )" ).append("\n"); 
		query.append("GROUP BY VVD, LANE, ETD, PORT, CGO_TP) B" ).append("\n"); 
		query.append("WHERE A.VVD(+) = B.VVD" ).append("\n"); 
		query.append("AND A.ETD(+) = B.ETD" ).append("\n"); 
		query.append("AND A.PORT(+) = B.PORT" ).append("\n"); 
		query.append("AND A.CGO_TP(+) = B.CGO_TP ) --END WITH STATEMENT" ).append("\n"); 
		query.append("SELECT VVD," ).append("\n"); 
		query.append("LANE," ).append("\n"); 
		query.append("ETD," ).append("\n"); 
		query.append("PORT," ).append("\n"); 
		query.append("--FULL" ).append("\n"); 
		query.append("SUM(BKG1) BKG1," ).append("\n"); 
		query.append("SUM(EDI1) EDI1," ).append("\n"); 
		query.append("SUM(MAN1) MAN1," ).append("\n"); 
		query.append("SUM(TOTAL1) TOTAL1," ).append("\n"); 
		query.append("SUM(RESULT1) RESULT1," ).append("\n"); 
		query.append("--EMPTY" ).append("\n"); 
		query.append("SUM(BKG2) BKG2," ).append("\n"); 
		query.append("SUM(EDI2) EDI2," ).append("\n"); 
		query.append("SUM(MAN2) MAN2," ).append("\n"); 
		query.append("SUM(TOTAL2) TOTAL2," ).append("\n"); 
		query.append("SUM(RESULT2) RESULT2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT R.VVD," ).append("\n"); 
		query.append("R.LANE," ).append("\n"); 
		query.append("R.ETD," ).append("\n"); 
		query.append("R.PORT," ).append("\n"); 
		query.append("R.BKG_CNT AS BKG1," ).append("\n"); 
		query.append("R.EDI AS EDI1," ).append("\n"); 
		query.append("R.MAN AS MAN1," ).append("\n"); 
		query.append("R.EDI + R.MAN AS TOTAL1," ).append("\n"); 
		query.append("R.EDI + R.MAN - R.BKG_CNT AS RESULT1," ).append("\n"); 
		query.append("0 AS BKG2," ).append("\n"); 
		query.append("0 AS EDI2," ).append("\n"); 
		query.append("0 AS MAN2," ).append("\n"); 
		query.append("0 AS TOTAL2," ).append("\n"); 
		query.append("0 AS RESULT2" ).append("\n"); 
		query.append("FROM RSLT R" ).append("\n"); 
		query.append("WHERE R.CGO_TP = 'F' --FULL CARGO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT R.VVD," ).append("\n"); 
		query.append("R.LANE," ).append("\n"); 
		query.append("R.ETD," ).append("\n"); 
		query.append("R.PORT," ).append("\n"); 
		query.append("0 AS BKG1," ).append("\n"); 
		query.append("0 AS EDI1," ).append("\n"); 
		query.append("0 AS MAN1," ).append("\n"); 
		query.append("0 AS TOTAL1," ).append("\n"); 
		query.append("0 AS RESULT1," ).append("\n"); 
		query.append("R.BKG_CNT AS BKG2," ).append("\n"); 
		query.append("R.EDI AS EDI2," ).append("\n"); 
		query.append("R.MAN AS MAN2," ).append("\n"); 
		query.append("R.EDI + R.MAN AS TOTAL2," ).append("\n"); 
		query.append("R.EDI + R.MAN - R.BKG_CNT AS RESULT2" ).append("\n"); 
		query.append("FROM RSLT R" ).append("\n"); 
		query.append("WHERE R.CGO_TP = 'E' --EMPTY CARGO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY VVD, LANE, ETD, PORT" ).append("\n"); 
		query.append("ORDER BY VVD, ETD, PORT" ).append("\n"); 

	}
}