/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOSearchPreAuditHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoAdvanceAuditDBDAOSearchPreAuditHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PsoAdvanceAuditDBDAOSearchPreAuditHistoryList 
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOSearchPreAuditHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accountCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vessel",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yardCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("portCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("costCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contractType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vesselClass",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOSearchPreAuditHistoryListRSQL").append("\n"); 
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
		query.append("SELECT ISS_CTY_CD" ).append("\n"); 
		query.append("     , SO_SEQ" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("     , LGS_COST_CD" ).append("\n"); 
		query.append("     , MAX(RHQ_OFC_CD) AS RHQ_OFC_CD" ).append("\n"); 
		query.append("     , MAX(PORT) AS PORT" ).append("\n"); 
		query.append("     , MAX(YD_CD) AS YARD" ).append("\n"); 
		query.append("     , MAX(VPS_ATB_DT) AS VPS_ATB_DT" ).append("\n"); 
		query.append("     , MAX(IO) AS BOUND" ).append("\n"); 
		query.append("     , MAX(SP_NM) AS SP_NM" ).append("\n"); 
		query.append("     , MAX(CHG_TP_CD) AS CHG_TP_CD" ).append("\n"); 
		query.append("     , MAX(ACCT_CD) AS ACCT_CD" ).append("\n"); 
		query.append("     , MAX(INV_NO) AS INV_NO" ).append("\n"); 
		query.append("     , MAX(ISS_DT) AS ISSUED" ).append("\n"); 
		query.append("     , MAX(CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("     , SUM(TARIFF_COST) AS TARIFF_COST" ).append("\n"); 
		query.append("     , SUM(ADJCOST) AS ADJCOST" ).append("\n"); 
		query.append("     , SUM(AMOUNT) AS AMOUNT" ).append("\n"); 
		query.append("     , MAX(DIFF_RMK) AS RMK" ).append("\n"); 
		query.append("     , MAX(RHQ_OFC_CD) AS RHQ_OFC_CD" ).append("\n"); 
		query.append("     , MAX(CHG_TP_CD) AS CHG_TP_CD" ).append("\n"); 
		query.append("     , MAX(ACCT_CD) AS ACCT_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT (SELECT EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(DECODE(T1.INV_OFC_CD, 'PUSMOV', 'SELIB', T1.INV_OFC_CD)) FROM DUAL) RHQ_OFC_CD" ).append("\n"); 
		query.append("             , SUBSTR(T1.YD_CD, 1, 5) AS PORT" ).append("\n"); 
		query.append("             , T1.YD_CD     AS YD_CD" ).append("\n"); 
		query.append("             , T2.VVD" ).append("\n"); 
		query.append("             , (SELECT MIN(TO_CHAR(X.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI'))" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD  X" ).append("\n"); 
		query.append("                 WHERE X.VSL_CD      = T2.VSL_CD" ).append("\n"); 
		query.append("                   AND X.SKD_VOY_NO  = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND X.SKD_DIR_CD  = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND X.YD_CD       = T1.YD_CD" ).append("\n"); 
		query.append("               ) VPS_ATB_DT" ).append("\n"); 
		query.append("             , DECODE(T2.DP_IO_BND_CD, 'I', 'IN', 'O', 'OUT', 'IN/OUT') AS IO" ).append("\n"); 
		query.append("             , (SELECT X.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR X" ).append("\n"); 
		query.append("                 WHERE X.VNDR_SEQ = T1.VNDR_SEQ" ).append("\n"); 
		query.append("               ) AS SP_NM" ).append("\n"); 
		query.append("             , CASE WHEN C.ACCT_CD NOT IN ('999999', '511795') AND C.ACCT_CD LIKE '5117%' AND MA.ACCT_ENG_NM NOT LIKE 'OTHER PORT%' THEN 'PORT CHARGE'" ).append("\n"); 
		query.append("                    WHEN C.ACCT_CD LIKE '5118%' AND MA.ACCT_ENG_NM NOT LIKE 'OTHER PORT%' THEN 'PORT SERVICE CHARGE'" ).append("\n"); 
		query.append("                    WHEN C.ACCT_CD LIKE '5119%' AND MA.ACCT_ENG_NM NOT LIKE 'OTHER PORT%' THEN 'ANAL TRANSIT FEE'" ).append("\n"); 
		query.append("                    WHEN C.ACCT_CD <> '999999' AND (C.ACCT_CD IN ('564611', '511795') OR MA.ACCT_ENG_NM LIKE 'OTHER PORT%') THEN 'OTHER'" ).append("\n"); 
		query.append("               END CHG_TP_CD" ).append("\n"); 
		query.append("             , C.ACCT_CD" ).append("\n"); 
		query.append("             , T2.LGS_COST_CD" ).append("\n"); 
		query.append("             , T1.INV_NO" ).append("\n"); 
		query.append("             , TO_CHAR(T1.ISS_DT, 'YYYY-MM-DD')    AS ISS_DT" ).append("\n"); 
		query.append("             , T1.CURR_CD" ).append("\n"); 
		query.append("             , T2.CALC_AMT AS TARIFF_COST" ).append("\n"); 
		query.append("             , DECODE(T2.CALC_AMT, NULL, DECODE(T2.ADJ_AMT, NULL, T2.LOCL_AMT, T2.ADJ_AMT), T2.ADJ_AMT) AS ADJCOST" ).append("\n"); 
		query.append("             , T2.LOCL_AMT  AS AMOUNT" ).append("\n"); 
		query.append("             , T2.DIFF_RMK" ).append("\n"); 
		query.append("             , T2.ISS_CTY_CD" ).append("\n"); 
		query.append("             , T2.SO_SEQ" ).append("\n"); 
		query.append("          FROM PSO_CHARGE   T1" ).append("\n"); 
		query.append("             , (SELECT X.*" ).append("\n"); 
		query.append("                     , CASE WHEN X.SO_DTL_SEQ = X.ORG_SO_DTL_SEQ THEN X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD" ).append("\n"); 
		query.append("                            ELSE (SELECT Y.VSL_CD||Y.SKD_VOY_NO||Y.SKD_DIR_CD" ).append("\n"); 
		query.append("                                    FROM PSO_CHG_DTL Y" ).append("\n"); 
		query.append("                                   WHERE Y.ISS_CTY_CD = X.ISS_CTY_CD" ).append("\n"); 
		query.append("                                     AND Y.SO_SEQ     = X.SO_SEQ" ).append("\n"); 
		query.append("                                     AND Y.SO_DTL_SEQ = X.ORG_SO_DTL_SEQ" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                       END VVD" ).append("\n"); 
		query.append("                  FROM PSO_CHG_DTL X" ).append("\n"); 
		query.append("               ) T2" ).append("\n"); 
		query.append("             , TES_LGS_COST C" ).append("\n"); 
		query.append("             , MDM_ACCOUNT  MA" ).append("\n"); 
		query.append("             , EAS_PORT_SO_CHG_ACCT CS" ).append("\n"); 
		query.append("         WHERE 1=1               " ).append("\n"); 
		query.append("           AND T1.ISS_CTY_CD  = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("           AND T1.SO_SEQ      = T2.SO_SEQ" ).append("\n"); 
		query.append("           AND T2.LGS_COST_CD = C.LGS_COST_CD" ).append("\n"); 
		query.append("           AND C.ACCT_CD      = MA.ACCT_CD" ).append("\n"); 
		query.append("           AND T2.LGS_COST_CD = CS.LGS_COST_CD" ).append("\n"); 
		query.append("           AND C.ACCT_CD <> '999999' " ).append("\n"); 
		query.append("           AND LENGTH(T2.LGS_COST_CD) = 6" ).append("\n"); 
		query.append("#if(${rhq}!='' && ${rhq}!='ALL')" ).append("\n"); 
		query.append("           AND  CS.AUD_OFC_CD     = @[rhq] -- RHQ Office" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if ( ${vesselClass} !='' ) " ).append("\n"); 
		query.append("            AND T2.VSL_CD IN (SELECT VSL_CD" ).append("\n"); 
		query.append("                                FROM MDM_VSL_CNTR AA" ).append("\n"); 
		query.append("                                  , (SELECT MAX(FM_CD_CAL) AS FM_CD_CAL" ).append("\n"); 
		query.append("                                          , MAX(TO_CD_CAL) AS TO_CD_CAL" ).append("\n"); 
		query.append("                                       FROM (SELECT CASE WHEN A.INTG_CD_VAL_DP_SEQ =B.CD_SEQ-1 THEN INTG_CD_VAL_CTNT ELSE '0' END FM_CD_CAL" ).append("\n"); 
		query.append("                                                  , CASE WHEN A.INTG_CD_VAL_DP_SEQ =B.CD_SEQ THEN INTG_CD_VAL_CTNT ELSE '0' END TO_CD_CAL" ).append("\n"); 
		query.append("                                               FROM COM_INTG_CD_DTL A" ).append("\n"); 
		query.append("                                                  , (SELECT INTG_CD_ID,INTG_CD_VAL_DP_SEQ AS CD_SEQ" ).append("\n"); 
		query.append("                                                       FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                                      WHERE 1=1 " ).append("\n"); 
		query.append("                                                        AND INTG_CD_ID ='CD03434'" ).append("\n"); 
		query.append("                                                        AND INTG_CD_VAL_CTNT =  @[vesselClass]" ).append("\n"); 
		query.append("                                                    ) B" ).append("\n"); 
		query.append("                                              WHERE A.INTG_CD_ID = B.INTG_CD_ID" ).append("\n"); 
		query.append("                                                AND A.INTG_CD_VAL_DP_SEQ BETWEEN B.CD_SEQ-1 AND B.CD_SEQ" ).append("\n"); 
		query.append("                                            )      " ).append("\n"); 
		query.append("                                    )BB" ).append("\n"); 
		query.append("                              WHERE 1=1" ).append("\n"); 
		query.append("                                AND CNTR_VSL_CLSS_CAPA  BETWEEN BB.FM_CD_CAL AND BB.TO_CD_CAL  " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${vessel} !='' ) " ).append("\n"); 
		query.append("            AND T2.VSL_CD = @[vessel]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("	       #if ( ${period1} !='' && ${period2} !='' ) " ).append("\n"); 
		query.append("		    AND T1.ISS_DT BETWEEN TO_DATE(@[period1],'YYYY-MM-DD') AND TO_DATE(@[period2],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${country} !='' ) " ).append("\n"); 
		query.append("            AND T1.YD_CD LIKE @[country]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${portCode} !='' ) " ).append("\n"); 
		query.append("            AND T1.YD_CD LIKE @[portCode]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${portCode} !='' && ${yardCd} !='') " ).append("\n"); 
		query.append("            AND T1.YD_CD LIKE @[portCode]||@[yardCd]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${accountCode} !='' )" ).append("\n"); 
		query.append("            AND C.ACCT_CD = @[accountCode]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${costCode} !='' )" ).append("\n"); 
		query.append("            AND T2.LGS_COST_CD = @[costCode]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           --Contract type " ).append("\n"); 
		query.append("           #if ( ${contractType} !='ALL' && ${period1} !='' && ${period2} !='')" ).append("\n"); 
		query.append("           AND T2.VSL_CD IN (" ).append("\n"); 
		query.append("               SELECT VSL_CD" ).append("\n"); 
		query.append("                 FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND VSL_CD IN (SELECT VSL_CD FROM FMS_CONTRACT WHERE FLET_CTRT_TP_CD IN (@[contractType]))" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           --CHARGE TYPE : PORT CHARGE, PORT SERVICE CHARGE" ).append("\n"); 
		query.append("           #if ( ${chargeType} == '01' )" ).append("\n"); 
		query.append("             --PORT CHARGE 선택시" ).append("\n"); 
		query.append("             AND C.ACCT_CD NOT IN ('999999', '511795')" ).append("\n"); 
		query.append("             AND C.ACCT_CD LIKE '5117%'" ).append("\n"); 
		query.append("             AND MA.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${chargeType} == '02' ) " ).append("\n"); 
		query.append("             --PORT SERVICE CHARGE 선택시" ).append("\n"); 
		query.append("             AND C.ACCT_CD LIKE '5118%'" ).append("\n"); 
		query.append("             AND MA.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${chargeType} == '03' ) " ).append("\n"); 
		query.append("           --Canal Transit Fee 선택시" ).append("\n"); 
		query.append("             AND C.ACCT_CD LIKE '5119%'" ).append("\n"); 
		query.append("             AND MA.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${chargeType} != '' && ${chargeType} == '04' ) " ).append("\n"); 
		query.append("           --Other 선택시" ).append("\n"); 
		query.append("             AND C.ACCT_CD <> '999999' " ).append("\n"); 
		query.append("             AND (C.ACCT_CD IN ('564611', '511795') OR MA.ACCT_ENG_NM LIKE 'OTHER PORT%')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${rhq}!='' && ${rhq}!='ALL')" ).append("\n"); 
		query.append("AND   RHQ_OFC_CD      = @[rhq] -- RHQ Office" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY ISS_CTY_CD" ).append("\n"); 
		query.append("     , SO_SEQ" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("     , LGS_COST_CD" ).append("\n"); 
		query.append("ORDER BY 6, 3" ).append("\n"); 

	}
}