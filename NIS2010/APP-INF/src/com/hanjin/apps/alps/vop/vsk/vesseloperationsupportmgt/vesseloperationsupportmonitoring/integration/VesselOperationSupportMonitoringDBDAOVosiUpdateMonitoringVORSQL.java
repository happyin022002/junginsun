/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselOperationSupportMonitoringDBDAOVosiUpdateMonitoringVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselOperationSupportMonitoringDBDAOVosiUpdateMonitoringVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public VesselOperationSupportMonitoringDBDAOVosiUpdateMonitoringVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.integration").append("\n"); 
		query.append("FileName : VesselOperationSupportMonitoringDBDAOVosiUpdateMonitoringVORSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("  V_TEMP1 AS(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      A.VOP_PORT_RHQ_CD RHQ, " ).append("\n"); 
		query.append("      A.LOC_CD          PORT," ).append("\n"); 
		query.append("      NVL(B.CNT,'N')   MANU_1ST," ).append("\n"); 
		query.append("      NVL(C.CNT,'N')   MANU_2ND," ).append("\n"); 
		query.append("      NVL(D.CNT,'N')   NONW_1ST," ).append("\n"); 
		query.append("      NVL(E.CNT,'N')   NONW_2ND," ).append("\n"); 
		query.append("      NVL(F.CNT,'N')   TRUC_1ST," ).append("\n"); 
		query.append("      NVL(G.CNT,'N')   TRUC_2ND," ).append("\n"); 
		query.append("      NVL(H.CNT,'N')   RAIL_1ST," ).append("\n"); 
		query.append("      NVL(I.CNT,'N')   RAIL_2ND," ).append("\n"); 
		query.append("      NVL(J.CNT,'N')   GCRN_1ST," ).append("\n"); 
		query.append("      NVL(K.CNT,'N')   GCRN_2ND," ).append("\n"); 
		query.append("      NVL(L.CNT,'N')   FCRN_1ST," ).append("\n"); 
		query.append("      NVL(M.CNT,'N')   FCRN_2ND," ).append("\n"); 
		query.append("      NVL(N.CNT,'N')   GSTR_1ST," ).append("\n"); 
		query.append("      NVL(O.CNT,'N')   GSTR_2ND," ).append("\n"); 
		query.append("      NVL(P.CNT,'N')   BWIN_1ST," ).append("\n"); 
		query.append("      NVL(Q.CNT,'N')   BWIN_2ND," ).append("\n"); 
		query.append("      ((DECODE(NVL(B.CNT,'N'),'Y',1,0)+DECODE(NVL(D.CNT,'N'),'Y',1,0)+" ).append("\n"); 
		query.append("        DECODE(NVL(F.CNT,'N'),'Y',1,0)+DECODE(NVL(H.CNT,'N'),'Y',1,0)+" ).append("\n"); 
		query.append("        DECODE(NVL(J.CNT,'N'),'Y',1,0)+DECODE(NVL(L.CNT,'N'),'Y',1,0)+" ).append("\n"); 
		query.append("        DECODE(NVL(N.CNT,'N'),'Y',1,0)+DECODE(NVL(P.CNT,'N'),'Y',1,0)) / 8)*100 TOT_1ST," ).append("\n"); 
		query.append("      ((DECODE(NVL(C.CNT,'N'),'Y',1,0)+DECODE(NVL(E.CNT,'N'),'Y',1,0)+" ).append("\n"); 
		query.append("        DECODE(NVL(G.CNT,'N'),'Y',1,0)+DECODE(NVL(I.CNT,'N'),'Y',1,0)+" ).append("\n"); 
		query.append("        DECODE(NVL(K.CNT,'N'),'Y',1,0)+DECODE(NVL(M.CNT,'N'),'Y',1,0)+" ).append("\n"); 
		query.append("        DECODE(NVL(O.CNT,'N'),'Y',1,0)+DECODE(NVL(Q.CNT,'N'),'Y',1,0)) / 8)*100 TOT_2ND," ).append("\n"); 
		query.append("      NVL(B.CNT2,0)   MANU_1ST2," ).append("\n"); 
		query.append("      NVL(C.CNT2,0)   MANU_2ND2," ).append("\n"); 
		query.append("      NVL(D.CNT2,0)   NONW_1ST2," ).append("\n"); 
		query.append("      NVL(E.CNT2,0)   NONW_2ND2," ).append("\n"); 
		query.append("      NVL(F.CNT2,0)   TRUC_1ST2," ).append("\n"); 
		query.append("      NVL(G.CNT2,0)   TRUC_2ND2," ).append("\n"); 
		query.append("      NVL(H.CNT2,0)   RAIL_1ST2," ).append("\n"); 
		query.append("      NVL(I.CNT2,0)   RAIL_2ND2," ).append("\n"); 
		query.append("      NVL(J.CNT2,0)   GCRN_1ST2," ).append("\n"); 
		query.append("      NVL(K.CNT2,0)   GCRN_2ND2," ).append("\n"); 
		query.append("      NVL(L.CNT2,0)   FCRN_1ST2," ).append("\n"); 
		query.append("      NVL(M.CNT2,0)   FCRN_2ND2," ).append("\n"); 
		query.append("      NVL(N.CNT2,0)   GSTR_1ST2," ).append("\n"); 
		query.append("      NVL(O.CNT2,0)   GSTR_2ND2," ).append("\n"); 
		query.append("      NVL(P.CNT2,0)   BWIN_1ST2," ).append("\n"); 
		query.append("      NVL(Q.CNT2,0)   BWIN_2ND2" ).append("\n"); 
		query.append("FROM  MDM_LOCATION A," ).append("\n"); 
		query.append("      ( SELECT SUBSTR(YD_CD,1,5) LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_MNVR" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'01', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'06', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(YD_CD,1,5)      LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           GROUP BY SUBSTR(YD_CD,1,5) ) B," ).append("\n"); 
		query.append("      ( SELECT SUBSTR(YD_CD,1,5) LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_MNVR" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'07', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'12', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(YD_CD,1,5)      LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY SUBSTR(YD_CD,1,5) ) C," ).append("\n"); 
		query.append("      ( SELECT LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_NWORK" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'01', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'12', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("         GROUP BY LOC_CD ) D," ).append("\n"); 
		query.append("      ( SELECT LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_NWORK" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'01', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'12', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("         GROUP BY LOC_CD ) E," ).append("\n"); 
		query.append("      ( SELECT LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_TRSP_COND" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'01', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'06', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("           AND TRSP_MOD_CD = 'TD'" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND LOC_CD LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY LOC_CD ) F," ).append("\n"); 
		query.append("      ( SELECT LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_TRSP_COND" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'07', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'12', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("          AND  TRSP_MOD_CD = 'TD'" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("          AND  LOC_CD LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY LOC_CD ) G," ).append("\n"); 
		query.append("      ( SELECT LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_TRSP_COND" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'01', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'06', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("           AND TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND LOC_CD LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY LOC_CD ) H," ).append("\n"); 
		query.append("      ( SELECT LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_TRSP_COND" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'07', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'12', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("           AND TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND LOC_CD LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY LOC_CD ) I," ).append("\n"); 
		query.append("      ( SELECT SUBSTR(YD_CD,1,5) LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_GNTR_CRN" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'01', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'06', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(YD_CD,1,5) LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY SUBSTR(YD_CD,1,5) ) J," ).append("\n"); 
		query.append("      ( SELECT SUBSTR(YD_CD,1,5) LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_GNTR_CRN" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'07', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'12', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(YD_CD,1,5)      LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY SUBSTR(YD_CD,1,5) ) K," ).append("\n"); 
		query.append("      ( SELECT LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_FLTG_CRN" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'01', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'06', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND LOC_CD LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY LOC_CD ) L," ).append("\n"); 
		query.append("      ( SELECT LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_FLTG_CRN" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'07', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'12', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND LOC_CD LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY LOC_CD ) M," ).append("\n"); 
		query.append("      ( SELECT LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_GNG_STRC" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'01', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'06', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND LOC_CD LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY LOC_CD ) N," ).append("\n"); 
		query.append("      ( SELECT LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_GNG_STRC" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'07', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'12', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND LOC_CD      LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          GROUP BY LOC_CD ) O," ).append("\n"); 
		query.append("      ( SELECT SUBSTR(YD_CD,1,5) LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_BRTH_WDO" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'01', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'06', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(YD_CD,1,5) LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY SUBSTR(YD_CD,1,5) ) P," ).append("\n"); 
		query.append("      ( SELECT SUBSTR(YD_CD,1,5) LOC_CD, DECODE(SIGN(COUNT(*)), 1, 'Y', 'N') CNT, SIGN(COUNT(*)) CNT2" ).append("\n"); 
		query.append("          FROM VSK_PORT_BRTH_WDO" ).append("\n"); 
		query.append("         WHERE UPD_DT  BETWEEN TO_DATE(SUBSTR(@[sel_date],1,4)||'07', 'YYYYMM')" ).append("\n"); 
		query.append("                       AND     LAST_DAY(TO_DATE(SUBSTR(@[sel_date],1,4)||'12', 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(YD_CD,1,5) LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY SUBSTR(YD_CD,1,5) ) Q" ).append("\n"); 
		query.append("    WHERE A.VOP_PORT_RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("      AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${rhq} != '^') " ).append("\n"); 
		query.append("      AND A.VOP_PORT_RHQ_CD LIKE @[rhq]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("      AND A.LOC_CD          LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A.LOC_CD = B.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = C.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = D.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = E.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = F.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = G.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = H.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = I.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = J.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = K.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = L.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = M.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = N.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = O.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = P.LOC_CD (+)" ).append("\n"); 
		query.append("      AND A.LOC_CD = Q.LOC_CD (+)" ).append("\n"); 
		query.append("      AND NVL(A.VOP_PORT_MNTR_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("    ORDER BY A.VOP_PORT_RHQ_CD" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append(" ,V_TEMP2 AS(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      RHQ||' Sub Total' RHQ," ).append("\n"); 
		query.append("      'Sub Total' PORT," ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(MANU_1ST2)/COUNT(MANU_1ST2))*100, 0)) MANU_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(MANU_2ND2)/COUNT(MANU_2ND2))*100, 0)) MANU_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(NONW_1ST2)/COUNT(NONW_1ST2))*100, 0)) NONW_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(NONW_2ND2)/COUNT(NONW_2ND2))*100, 0)) NONW_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(TRUC_1ST2)/COUNT(TRUC_1ST2))*100, 0)) TRUC_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(TRUC_2ND2)/COUNT(TRUC_2ND2))*100, 0)) TRUC_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(RAIL_1ST2)/COUNT(RAIL_1ST2))*100, 0)) RAIL_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(RAIL_2ND2)/COUNT(RAIL_2ND2))*100, 0)) RAIL_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(GCRN_1ST2)/COUNT(GCRN_1ST2))*100, 0)) GCRN_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(GCRN_2ND2)/COUNT(GCRN_2ND2))*100, 0)) GCRN_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(FCRN_1ST2)/COUNT(FCRN_1ST2))*100, 0)) FCRN_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(FCRN_2ND2)/COUNT(FCRN_2ND2))*100, 0)) FCRN_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(GSTR_1ST2)/COUNT(GSTR_1ST2))*100, 0)) GSTR_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(GSTR_2ND2)/COUNT(GSTR_2ND2))*100, 0)) GSTR_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(BWIN_1ST2)/COUNT(BWIN_1ST2))*100, 0)) BWIN_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(BWIN_2ND2)/COUNT(BWIN_2ND2))*100, 0)) BWIN_2ND2," ).append("\n"); 
		query.append("      TRUNC((SUM(TOT_1ST)/COUNT(BWIN_2ND2)), 1) TOT_1ST," ).append("\n"); 
		query.append("      TRUNC((SUM(TOT_2ND)/COUNT(BWIN_2ND2)), 1) TOT_2ND" ).append("\n"); 
		query.append("    FROM V_TEMP1" ).append("\n"); 
		query.append("    GROUP BY RHQ--, PORT" ).append("\n"); 
		query.append("    UNION" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      'Total' RHQ," ).append("\n"); 
		query.append("      '' PORT," ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(MANU_1ST2)/COUNT(MANU_1ST2))*100, 0)) MANU_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(MANU_2ND2)/COUNT(MANU_2ND2))*100, 0)) MANU_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(NONW_1ST2)/COUNT(NONW_1ST2))*100, 0)) NONW_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(NONW_2ND2)/COUNT(NONW_2ND2))*100, 0)) NONW_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(TRUC_1ST2)/COUNT(TRUC_1ST2))*100, 0)) TRUC_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(TRUC_2ND2)/COUNT(TRUC_2ND2))*100, 0)) TRUC_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(RAIL_1ST2)/COUNT(RAIL_1ST2))*100, 0)) RAIL_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(RAIL_2ND2)/COUNT(RAIL_2ND2))*100, 0)) RAIL_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(GCRN_1ST2)/COUNT(GCRN_1ST2))*100, 0)) GCRN_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(GCRN_2ND2)/COUNT(GCRN_2ND2))*100, 0)) GCRN_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(FCRN_1ST2)/COUNT(FCRN_1ST2))*100, 0)) FCRN_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(FCRN_2ND2)/COUNT(FCRN_2ND2))*100, 0)) FCRN_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(GSTR_1ST2)/COUNT(GSTR_1ST2))*100, 0)) GSTR_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(GSTR_2ND2)/COUNT(GSTR_2ND2))*100, 0)) GSTR_2ND2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(BWIN_1ST2)/COUNT(BWIN_1ST2))*100, 0)) BWIN_1ST2,      " ).append("\n"); 
		query.append("      TO_CHAR(TRUNC((SUM(BWIN_2ND2)/COUNT(BWIN_2ND2))*100, 0)) BWIN_2ND2," ).append("\n"); 
		query.append("      TRUNC((SUM(TOT_1ST)/COUNT(BWIN_2ND2)), 1) TOT_1ST," ).append("\n"); 
		query.append("      TRUNC((SUM(TOT_2ND)/COUNT(BWIN_2ND2)), 1) TOT_2ND" ).append("\n"); 
		query.append("    FROM V_TEMP1" ).append("\n"); 
		query.append("    UNION" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      RHQ,             " ).append("\n"); 
		query.append("      PORT,      " ).append("\n"); 
		query.append("      MANU_1ST,   " ).append("\n"); 
		query.append("      MANU_2ND,   " ).append("\n"); 
		query.append("      NONW_1ST,   " ).append("\n"); 
		query.append("      NONW_2ND,   " ).append("\n"); 
		query.append("      TRUC_1ST,   " ).append("\n"); 
		query.append("      TRUC_2ND,   " ).append("\n"); 
		query.append("      RAIL_1ST,   " ).append("\n"); 
		query.append("      RAIL_2ND,   " ).append("\n"); 
		query.append("      GCRN_1ST,   " ).append("\n"); 
		query.append("      GCRN_2ND,   " ).append("\n"); 
		query.append("      FCRN_1ST,   " ).append("\n"); 
		query.append("      FCRN_2ND,   " ).append("\n"); 
		query.append("      GSTR_1ST,   " ).append("\n"); 
		query.append("      GSTR_2ND,   " ).append("\n"); 
		query.append("      BWIN_1ST,   " ).append("\n"); 
		query.append("      BWIN_2ND," ).append("\n"); 
		query.append("      TOT_1ST TOT_1ST," ).append("\n"); 
		query.append("      TOT_2ND TOT_2ND" ).append("\n"); 
		query.append("    FROM V_TEMP1" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  SELECT" ).append("\n"); 
		query.append("    SUBSTR(RHQ,1,5) RHQ," ).append("\n"); 
		query.append("    PORT,      " ).append("\n"); 
		query.append("    MANU_1ST2,      " ).append("\n"); 
		query.append("    MANU_2ND2,      " ).append("\n"); 
		query.append("    NONW_1ST2,      " ).append("\n"); 
		query.append("    NONW_2ND2,      " ).append("\n"); 
		query.append("    TRUC_1ST2,      " ).append("\n"); 
		query.append("    TRUC_2ND2,      " ).append("\n"); 
		query.append("    RAIL_1ST2,      " ).append("\n"); 
		query.append("    RAIL_2ND2,      " ).append("\n"); 
		query.append("    GCRN_1ST2,      " ).append("\n"); 
		query.append("    GCRN_2ND2,      " ).append("\n"); 
		query.append("    FCRN_1ST2,      " ).append("\n"); 
		query.append("    FCRN_2ND2,      " ).append("\n"); 
		query.append("    GSTR_1ST2,      " ).append("\n"); 
		query.append("    GSTR_2ND2,      " ).append("\n"); 
		query.append("    BWIN_1ST2,      " ).append("\n"); 
		query.append("    BWIN_2ND2," ).append("\n"); 
		query.append("    TOT_1ST," ).append("\n"); 
		query.append("    TOT_2ND" ).append("\n"); 
		query.append("  FROM V_TEMP2" ).append("\n"); 
		query.append("  ORDER BY DECODE(RHQ, 'Total', 'ZZZZZ', RHQ)" ).append("\n"); 

	}
}