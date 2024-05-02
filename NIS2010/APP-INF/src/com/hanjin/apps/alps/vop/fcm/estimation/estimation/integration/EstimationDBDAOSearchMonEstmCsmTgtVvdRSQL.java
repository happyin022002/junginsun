/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EstimationDBDAOSearchMonEstmCsmTgtVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationDBDAOSearchMonEstmCsmTgtVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search target VVD for a monthly estimation consumption.
	  * ============================================================================
	  * </pre>
	  */
	public EstimationDBDAOSearchMonEstmCsmTgtVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration").append("\n"); 
		query.append("FileName : EstimationDBDAOSearchMonEstmCsmTgtVvdRSQL").append("\n"); 
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
		query.append("WITH TGT_VVD AS (" ).append("\n"); 
		query.append("    SELECT EXE_YRMON" ).append("\n"); 
		query.append("         , REV_YRMON" ).append("\n"); 
		query.append("         , VSL_CD" ).append("\n"); 
		query.append("         , SKD_VOY_NO" ).append("\n"); 
		query.append("         , SKD_DIR_CD" ).append("\n"); 
		query.append("         , REV_DIR_CD" ).append("\n"); 
		query.append("         , ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("         , PRE_ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("         , ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("         , CSM_OIL_TP_CD" ).append("\n"); 
		query.append("         , (SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("            WHERE T1.VSL_CD = VSL_CD) CNTR_DZN_CAPA" ).append("\n"); 
		query.append("         , (SELECT RLANE_CD FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append("            WHERE T1.VSL_CD = VSL_CD" ).append("\n"); 
		query.append("            AND   T1.SKD_VOY_NO = SKD_VOY_NO" ).append("\n"); 
		query.append("            AND   T1.SKD_DIR_CD = SKD_DIR_CD" ).append("\n"); 
		query.append("            AND   T1.REV_DIR_CD = RLANE_DIR_CD) RLANE_CD" ).append("\n"); 
		query.append("         , NVL((SELECT ACT_CRR_CD FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("                WHERE T1.VSL_CD = VSL_CD" ).append("\n"); 
		query.append("                AND   T1.SKD_VOY_NO = SKD_VOY_NO" ).append("\n"); 
		query.append("                AND   T1.SKD_DIR_CD = SKD_DIR_CD)," ).append("\n"); 
		query.append("               (SELECT CRR_CD FROM MDM_VSL_CNTR WHERE T1.VSL_CD=VSL_CD)) CRR_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT EXE_YRMON" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("             , VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , REV_DIR_CD" ).append("\n"); 
		query.append("             , ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("             , ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("             , DECODE(T1.EXE_YRMON, T1.REV_YRMON, NULL, (SELECT ESTM_VVD_TP_CD FROM GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("                                                         WHERE 1=1" ).append("\n"); 
		query.append("                                                         AND   EXE_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(T1.EXE_YRMON, 'YYYYMM'), -1), 'YYYYMM')" ).append("\n"); 
		query.append("                                                         AND   REV_YRMON = T1.REV_YRMON" ).append("\n"); 
		query.append("                                                         AND   VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                                                         AND   SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                         AND   SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         AND   REV_DIR_CD = T1.REV_DIR_CD" ).append("\n"); 
		query.append("                                                         AND   ESTM_IOC_DIV_CD = T1.ESTM_IOC_DIV_CD)) PRE_ESTM_VVD_TP_CD             " ).append("\n"); 
		query.append("             , ROW_NUMBER() OVER(PARTITION BY EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD ORDER BY ESTM_IOC_DIV_CD DESC) SEQ" ).append("\n"); 
		query.append("        FROM   GL_ESTM_REV_VVD T1" ).append("\n"); 
		query.append("        WHERE  EXE_YRMON=@[exe_yrmon]" ).append("\n"); 
		query.append("        AND    REV_YRMON IN (TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[exe_yrmon], '-', ''), 'YYYYMM'), -1), 'YYYYMM')" ).append("\n"); 
		query.append("                     , REPLACE(@[exe_yrmon], '-', '')" ).append("\n"); 
		query.append("                     , TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[exe_yrmon], '-', ''), 'YYYYMM'), 1), 'YYYYMM'))" ).append("\n"); 
		query.append("        AND    EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                       FROM   VSK_VSL_SKD S1, MDM_VSL_CNTR S2" ).append("\n"); 
		query.append("                       WHERE  1=1" ).append("\n"); 
		query.append("                       AND    S1.VSL_CD=S2.VSL_CD" ).append("\n"); 
		query.append("                       AND    NVL(S1.ACT_CRR_CD, S2.CRR_CD)='SML'" ).append("\n"); 
		query.append("                       AND    T1.VSL_CD=S1.VSL_CD" ).append("\n"); 
		query.append("                       AND    T1.SKD_VOY_NO=S1.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND    T1.SKD_DIR_CD=S1.SKD_DIR_CD)" ).append("\n"); 
		query.append("    ) T1, (SELECT 'HFO' CSM_OIL_TP_CD FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'MDO' CSM_OIL_TP_CD FROM DUAL)" ).append("\n"); 
		query.append("    WHERE SEQ=1" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("ERP AS (" ).append("\n"); 
		query.append("    SELECT *" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT   ESTM_SEQ" ).append("\n"); 
		query.append("               , EXE_YRMON" ).append("\n"); 
		query.append("               , REV_YRMON" ).append("\n"); 
		query.append("               , RLANE_CD" ).append("\n"); 
		query.append("               , VSL_CD" ).append("\n"); 
		query.append("               , SKD_VOY_NO" ).append("\n"); 
		query.append("               , SKD_DIR_CD" ).append("\n"); 
		query.append("               , REV_DIR_CD" ).append("\n"); 
		query.append("               , ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("               , CSM_OIL_TP_CD" ).append("\n"); 
		query.append("               , (SELECT DECODE(NVL(MAX(FLET_CTRT_TP_CD), 'XX'), 'TO', 'Y', 'N')" ).append("\n"); 
		query.append("                  FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                  AND VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                  AND (TO_DATE(ST_DT, 'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT-1 OR" ).append("\n"); 
		query.append("                       TO_DATE(END_DT, 'YYYYMMDD')-1 BETWEEN EFF_DT AND EXP_DT)) TO_FLG" ).append("\n"); 
		query.append("               , ST_DT AS TMP_ST_DT" ).append("\n"); 
		query.append("               , ST_PORT_CD AS TMP_ST_PORT_CD" ).append("\n"); 
		query.append("               , END_DT AS TMP_END_DT" ).append("\n"); 
		query.append("               , END_PORT_CD AS TMP_END_PORT_CD" ).append("\n"); 
		query.append("               , MON_BGN_INVT_WGT" ).append("\n"); 
		query.append("               , PRE_VVD_INVT_WGT" ).append("\n"); 
		query.append("               , PO_RCV_WGT" ).append("\n"); 
		query.append("               , BOD_WGT" ).append("\n"); 
		query.append("               , BOR_WGT" ).append("\n"); 
		query.append("               , VOY_SEA_DYS" ).append("\n"); 
		query.append("               , VOY_PORT_DYS" ).append("\n"); 
		query.append("               , ESTM_SEA_DYS" ).append("\n"); 
		query.append("               , ESTM_PORT_DYS" ).append("\n"); 
		query.append("               , (SELECT DECODE(T1.CSM_OIL_TP_CD," ).append("\n"); 
		query.append("                             'HFO', NVL(S1.FOIL_RMN_WGT, 0) + NVL(S1.LOW_SULP_FOIL_RMN_WGT, 0)," ).append("\n"); 
		query.append("                             'MDO', NVL(S1.DOIL_RMN_WGT, 0) + NVL(S1.LOW_SULP_DOIL_RMN_WGT, 0)," ).append("\n"); 
		query.append("                             0)" ).append("\n"); 
		query.append("                 FROM   FCM_RMN_OIL_MON_END_RPT S1" ).append("\n"); 
		query.append("                 WHERE  S1.REV_YRMON  = REPLACE(@[exe_yrmon], '-', '')" ).append("\n"); 
		query.append("                 AND    S1.VSL_CD     = T1.VSL_CD" ).append("\n"); 
		query.append("                 AND    S1.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND    S1.SKD_DIR_CD = T1.SKD_DIR_CD) AS MON_END_RMN_WGT" ).append("\n"); 
		query.append("               , ESTM_MON_CSM_WGT" ).append("\n"); 
		query.append("        FROM   FCM_ESTM_MON_CSM_IF T1" ).append("\n"); 
		query.append("        WHERE  EXE_YRMON=REPLACE(@[exe_yrmon], '-', '')" ).append("\n"); 
		query.append("        ORDER BY ESTM_SEQ" ).append("\n"); 
		query.append("    ))" ).append("\n"); 
		query.append("SELECT T1.*" ).append("\n"); 
		query.append("     , (SELECT DECODE(T1.CSM_OIL_TP_CD," ).append("\n"); 
		query.append("                     'HFO', NVL(S1.FOIL_RMN_WGT, 0) + NVL(S1.LOW_SULP_FOIL_RMN_WGT, 0)," ).append("\n"); 
		query.append("                     'MDO', NVL(S1.DOIL_RMN_WGT, 0) + NVL(S1.LOW_SULP_DOIL_RMN_WGT, 0)," ).append("\n"); 
		query.append("                     0)" ).append("\n"); 
		query.append("        FROM   FCM_RMN_OIL_MON_END_RPT S1" ).append("\n"); 
		query.append("        WHERE  S1.REV_YRMON  = REPLACE(@[exe_yrmon], '-', '')" ).append("\n"); 
		query.append("        AND    S1.VSL_CD     = T1.VSL_CD" ).append("\n"); 
		query.append("        AND    S1.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    S1.SKD_DIR_CD = T1.SKD_DIR_CD) AS MON_END_RMN_WGT" ).append("\n"); 
		query.append("     , T2.ESTM_SEQ" ).append("\n"); 
		query.append("     , T2.TO_FLG" ).append("\n"); 
		query.append("     , T2.TMP_ST_DT" ).append("\n"); 
		query.append("     , T2.TMP_ST_PORT_CD" ).append("\n"); 
		query.append("     , T2.TMP_END_DT" ).append("\n"); 
		query.append("     , T2.TMP_END_PORT_CD" ).append("\n"); 
		query.append("     , T2.MON_BGN_INVT_WGT" ).append("\n"); 
		query.append("     , T2.PRE_VVD_INVT_WGT" ).append("\n"); 
		query.append("     , T2.PO_RCV_WGT" ).append("\n"); 
		query.append("     , T2.BOD_WGT" ).append("\n"); 
		query.append("     , T2.BOR_WGT" ).append("\n"); 
		query.append("     , T2.VOY_SEA_DYS" ).append("\n"); 
		query.append("     , T2.VOY_PORT_DYS" ).append("\n"); 
		query.append("     , T2.ESTM_SEA_DYS" ).append("\n"); 
		query.append("     , T2.ESTM_PORT_DYS" ).append("\n"); 
		query.append("     , T2.ESTM_MON_CSM_WGT" ).append("\n"); 
		query.append("FROM TGT_VVD T1, ERP T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   T1.EXE_YRMON = T2.EXE_YRMON(+)" ).append("\n"); 
		query.append("AND   T1.VSL_CD = T2.VSL_CD(+)" ).append("\n"); 
		query.append("AND   T1.SKD_VOY_NO = T2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND   T1.SKD_DIR_CD = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND   T1.REV_DIR_CD = T2.REV_DIR_CD(+)" ).append("\n"); 
		query.append("AND   T1.CSM_OIL_TP_CD = T2.CSM_OIL_TP_CD(+)" ).append("\n"); 
		query.append("ORDER BY T1.EXE_YRMON" ).append("\n"); 
		query.append("       , T1.REV_YRMON" ).append("\n"); 
		query.append("       , T1.VSL_CD" ).append("\n"); 
		query.append("       , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("       , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("       , T1.REV_DIR_CD" ).append("\n"); 
		query.append("       , T1.CSM_OIL_TP_CD" ).append("\n"); 

	}
}