/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOsearchEstTgtVvdByMonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtBCDBDAOsearchEstTgtVvdByMonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Estimate Expense Creation을 하기 위해 이미 생성한 추정 대상 VVD를 Revenue Month 나 노선 별로 조회한다.
	  * NYK Modify 2014.11.12 
	  * Red : YD_Cd 가 존재 하지 않음.
	  * Blue : XPR_DESC is null
	  * Pink : no-rate, null 존재시 
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOsearchEstTgtVvdByMonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtedate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOsearchEstTgtVvdByMonRSQL").append("\n"); 
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
		query.append("WITH V_ESTM_MON_VVD AS (" ).append("\n"); 
		query.append("        SELECT TXTSDATE" ).append("\n"); 
		query.append("             , TXTEDATE" ).append("\n"); 
		query.append("             , EXE_YRMON" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("             , LANE" ).append("\n"); 
		query.append("             , CHK" ).append("\n"); 
		query.append("             , VVD" ).append("\n"); 
		query.append("             , HVVD" ).append("\n"); 
		query.append("             , VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , DECODE(TURN_PORT_IND_CD,'N',DECODE(TURN_PORT_FLG,'Y','Y','N'),'Y') AS TURN_PORT_FLG" ).append("\n"); 
		query.append("             , TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , CLPT_SEQ" ).append("\n"); 
		query.append("             , TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("             , TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("             , TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , VIR_TURN_PORT_FLG" ).append("\n"); 
		query.append("             , VIR_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , TMNL_CODE" ).append("\n"); 
		query.append("             , ESTM_USD_AMT" ).append("\n"); 
		query.append("             , ACT_DT" ).append("\n"); 
		query.append("             , TXTCOLOR" ).append("\n"); 
		query.append("             , M.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("             , CASE WHEN TURN_PORT_IND_CD IN ('D','V','F') THEN VSL_CD||TURN_SKD_VOY_NO||TURN_SKD_DIR_CD||TURN_CLPT_IND_SEQ||TMNL_CODE" ).append("\n"); 
		query.append("                    ELSE VSL_CD||SKD_VOY_NO||SKD_DIR_CD||CLPT_IND_SEQ||TMNL_CODE" ).append("\n"); 
		query.append("               END AS KEY_VVD" ).append("\n"); 
		query.append("          FROM (SELECT ''                                           AS TXTSDATE" ).append("\n"); 
		query.append("                     , ''                                           AS TXTEDATE" ).append("\n"); 
		query.append("                     , T1.EXE_YRMON                                 AS EXE_YRMON" ).append("\n"); 
		query.append("                     , T1.REV_YRMON                                 AS REV_YRMON" ).append("\n"); 
		query.append("                     , SUBSTR(T1.LANE,1,3)                          AS LANE" ).append("\n"); 
		query.append("                     , ''                                           AS CHK" ).append("\n"); 
		query.append("                     , T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD  AS VVD" ).append("\n"); 
		query.append("                     , T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD  AS HVVD" ).append("\n"); 
		query.append("                     , T1.VSL_CD                                    AS VSL_CD" ).append("\n"); 
		query.append("                     , T1.SKD_VOY_NO                                AS SKD_VOY_NO" ).append("\n"); 
		query.append("                     , T1.SKD_DIR_CD                                AS SKD_DIR_CD" ).append("\n"); 
		query.append("                     , T1.YD_CD                                     AS TMNL_CODE" ).append("\n"); 
		query.append("                     , T1.CLPT_IND_SEQ                              AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , MAX(T1.TURN_PORT_FLG)                        AS TURN_PORT_FLG" ).append("\n"); 
		query.append("                     , MAX(T1.TURN_PORT_IND_CD)                     AS TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                     , MIN(T1.CLPT_SEQ)                             AS CLPT_SEQ" ).append("\n"); 
		query.append("                     , MAX(T1.TURN_SKD_VOY_NO)                      AS TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                     , MAX(T1.TURN_SKD_DIR_CD)                      AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                     , MAX(T1.TURN_CLPT_IND_SEQ)                    AS TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , MAX(T1.VIR_TURN_PORT_FLG)                    AS VIR_TURN_PORT_FLG" ).append("\n"); 
		query.append("                     , MAX(T1.VIR_TURN_PORT_IND_CD)                 AS VIR_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                     , NVL(SUM(T2.INV_USD_AMT) , 0)                 AS ESTM_USD_AMT" ).append("\n"); 
		query.append("                     , T2.ACT_DT                                    AS ACT_DT" ).append("\n"); 
		query.append("                     , SUBSTR(MAX(CASE WHEN T1.YD_CD IS NULL OR (   SELECT 1" ).append("\n"); 
		query.append("                                                                      FROM PSO_YD_CHG X" ).append("\n"); 
		query.append("                                                                     WHERE X.YD_CD = T1.YD_CD" ).append("\n"); 
		query.append("                                                                       AND TO_DATE(T1.VPS_ETD_DT,'YYYYMMDD') BETWEEN X.EFF_DT AND X.EXP_DT" ).append("\n"); 
		query.append("                                                                       AND X.LST_FLG = 'Y'" ).append("\n"); 
		query.append("                                                                       AND ROWNUM <= 1 ) IS NULL THEN '3Red'" ).append("\n"); 
		query.append("                                       WHEN T2.XPR_DESC IS NULL THEN CASE WHEN T1.YD_CD IS NOT NULL OR (SELECT COUNT(X.YD_CD)" ).append("\n"); 
		query.append("                                                                                                          FROM PSO_YD_CHG X" ).append("\n"); 
		query.append("                                                                                                         WHERE X.YD_CD = T1.YD_CD" ).append("\n"); 
		query.append("                                                                                                           AND TO_DATE(T1.VPS_ETD_DT,'YYYYMMDD') BETWEEN X.EFF_DT AND X.EXP_DT" ).append("\n"); 
		query.append("                                                                                                           AND X.LST_FLG = 'Y' ) > 0 THEN '1Pink'" ).append("\n"); 
		query.append("                                                                          ELSE '2Blue'" ).append("\n"); 
		query.append("                                                                     END" ).append("\n"); 
		query.append("                                       WHEN T2.XPR_DESC LIKE '%null%' OR T2.XPR_DESC LIKE '%no-rate%' OR T2.XPR_DESC LIKE '%no found%' OR T2.XPR_DESC LIKE '%[check]%' THEN '1Pink'" ).append("\n"); 
		query.append("                                  END), 2) AS TXTCOLOR" ).append("\n"); 
		query.append("                  FROM (SELECT /*+ALL_ROWS*/" ).append("\n"); 
		query.append("                               DISTINCT '2' AS PSO_BZTP_CD" ).append("\n"); 
		query.append("                             , GL.EXE_YRMON" ).append("\n"); 
		query.append("                             , AV.VSL_CD" ).append("\n"); 
		query.append("                             , AV.SKD_VOY_NO" ).append("\n"); 
		query.append("                             , VP.SKD_DIR_CD" ).append("\n"); 
		query.append("                             , NVL (VP.YD_CD, VP.VPS_PORT_CD) AS YD_CD" ).append("\n"); 
		query.append("                             , AV.EXPN_YRMON AS REV_YRMON" ).append("\n"); 
		query.append("                             , VP.SLAN_CD AS LANE" ).append("\n"); 
		query.append("                             , VP.CLPT_SEQ" ).append("\n"); 
		query.append("                             , VP.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                             , VP.TURN_PORT_FLG" ).append("\n"); 
		query.append("                             , VP.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                             , VP.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                             , VP.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                             , VP.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                             , (SELECT TURN_PORT_FLG" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                 WHERE VSL_CD =VP.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO =VP.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD =VP.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND VPS_PORT_CD =VP.VPS_PORT_CD" ).append("\n"); 
		query.append("                                   AND CLPT_IND_SEQ =VP.TURN_CLPT_IND_SEQ ) AS VIR_TURN_PORT_FLG" ).append("\n"); 
		query.append("                             , (SELECT TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                 WHERE VSL_CD =VP.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO =VP.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD =VP.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND VPS_PORT_CD =VP.VPS_PORT_CD" ).append("\n"); 
		query.append("                                   AND CLPT_IND_SEQ =VP.TURN_CLPT_IND_SEQ ) AS VIR_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                             , TO_CHAR(VPS_ETD_DT , 'YYYYMMDD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("                          FROM PSO_TGT_VVD AV" ).append("\n"); 
		query.append("                             , MDM_VSL_CNTR VS" ).append("\n"); 
		query.append("                             , VSK_VSL_SKD VV" ).append("\n"); 
		query.append("                             , VSK_VSL_PORT_SKD VP" ).append("\n"); 
		query.append("                             , GL_ESTM_REV_VVD GL" ).append("\n"); 
		query.append("                             , (SELECT EXE_YRMON" ).append("\n"); 
		query.append("                                  FROM GL_ESTM_IF_ERP GE" ).append("\n"); 
		query.append("                                 WHERE GE.EXE_YRMON     = REPLACE(@[exe_yrmon], '-','')" ).append("\n"); 
		query.append("                                   AND GE.SYS_SRC_ID    = 'PSO'" ).append("\n"); 
		query.append("                                   AND ROWNUM           = 1) GE" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND GL.EXE_YRMON                     = GE.EXE_YRMON" ).append("\n"); 
		query.append("                           AND GL.REV_YRMON                     BETWEEN REPLACE(@[txtsdate], '-','') AND REPLACE(@[txtedate], '-','')" ).append("\n"); 
		query.append("                           AND GL.VSL_CD                        = AV.VSL_CD" ).append("\n"); 
		query.append("                           AND GL.SKD_VOY_NO                    = AV.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND GL.SKD_DIR_CD                    = AV.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND GL.REV_YRMON                     = AV.EXPN_YRMON" ).append("\n"); 
		query.append("                           AND AV.PSO_BZTP_CD                   = '2'" ).append("\n"); 
		query.append("                           AND RTRIM (VS.CNTR_VSL_CLSS_CAPA)    IS NOT NULL" ).append("\n"); 
		query.append("                           AND NVL(VV.ACT_CRR_CD, VS.CRR_CD)    = COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("                           AND AV.VSL_CD                        = VS.VSL_CD" ).append("\n"); 
		query.append("                           AND AV.VSL_CD                        = VV.VSL_CD" ).append("\n"); 
		query.append("                           AND AV.SKD_VOY_NO                    = VV.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND AV.SKD_DIR_CD                    = VV.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND AV.VSL_CD                        = VP.VSL_CD" ).append("\n"); 
		query.append("                           AND AV.SKD_VOY_NO                    = VP.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND AV.SKD_DIR_CD                    = VP.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND NVL(VP.SKD_CNG_STS_CD, 'X')      <> 'S'" ).append("\n"); 
		query.append("                           AND NVL(VP.VT_ADD_CALL_FLG, 'N')     = 'N'" ).append("\n"); 
		query.append("        #if(${vvd}!='')" ).append("\n"); 
		query.append("                           AND AV.VSL_CD || AV.SKD_VOY_NO || AV.SKD_DIR_CD LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                           AND VP.SLAN_CD                       = NVL2(@[lane], @[lane], VP.SLAN_CD)" ).append("\n"); 
		query.append("                       ) T1" ).append("\n"); 
		query.append("                     , PSO_TGT_YD_EXPN T2" ).append("\n"); 
		query.append("                 WHERE T1.PSO_BZTP_CD = T2.PSO_BZTP_CD(+)" ).append("\n"); 
		query.append("                   AND T1.VSL_CD = T2.VSL_CD (+)" ).append("\n"); 
		query.append("                   AND T1.SKD_VOY_NO = T2.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("                   AND T1.SKD_DIR_CD = T2.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("                   AND T1.YD_CD = T2.YD_CD (+)" ).append("\n"); 
		query.append("                   AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                 GROUP BY T1.EXE_YRMON" ).append("\n"); 
		query.append("                     , T1.REV_YRMON" ).append("\n"); 
		query.append("                     , T1.LANE" ).append("\n"); 
		query.append("                     , T1.VSL_CD" ).append("\n"); 
		query.append("                     , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , T1.YD_CD" ).append("\n"); 
		query.append("                     , T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , T2.ACT_DT" ).append("\n"); 
		query.append("               ) X" ).append("\n"); 
		query.append("             , MDM_VSL_SVC_LANE_DIR M" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("        #if(${mismatched}!='')" ).append("\n"); 
		query.append("           AND X.TXTCOLOR IN ('Blue', 'Red', 'Pink')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${port_cd}!='' && ${yard_cd}!='')" ).append("\n"); 
		query.append("           AND X.TMNL_CODE = @[port_cd]||@[yard_cd]" ).append("\n"); 
		query.append("        #elseif(${port_cd}!='' && ${yard_cd}=='')" ).append("\n"); 
		query.append("           AND X.TMNL_CODE LIKE @[port_cd]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           AND X.LANE = M.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND X.SKD_DIR_CD = M.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("         ORDER BY X.LANE" ).append("\n"); 
		query.append("             , X.VSL_CD" ).append("\n"); 
		query.append("             , X.SKD_VOY_NO" ).append("\n"); 
		query.append("             , M.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("             , X.CLPT_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("--SELECT * FROM V_ESTM_MON_VVD;" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT X.TXTSDATE" ).append("\n"); 
		query.append("     , X.TXTEDATE" ).append("\n"); 
		query.append("     , X.EXE_YRMON" ).append("\n"); 
		query.append("     , X.REV_YRMON" ).append("\n"); 
		query.append("     , X.LANE" ).append("\n"); 
		query.append("     , X.CHK" ).append("\n"); 
		query.append("     , X.VVD" ).append("\n"); 
		query.append("     , X.HVVD" ).append("\n"); 
		query.append("     , X.VSL_CD" ).append("\n"); 
		query.append("     , X.SKD_VOY_NO" ).append("\n"); 
		query.append("     , X.SKD_DIR_CD" ).append("\n"); 
		query.append("     , X.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , X.TURN_PORT_FLG" ).append("\n"); 
		query.append("     , X.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("     , X.CLPT_SEQ" ).append("\n"); 
		query.append("     , X.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("     , X.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("     , X.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , X.VIR_TURN_PORT_FLG" ).append("\n"); 
		query.append("     , X.VIR_TURN_PORT_IND_CD" ).append("\n"); 
		query.append("     , X.TMNL_CODE" ).append("\n"); 
		query.append("#if(${hide_vrtl_port_flg} !='' && ${hide_vrtl_port_flg} == 'Y')" ).append("\n"); 
		query.append("/*Virtual port를 제외하고 기존 Turnning port에 amount Sum*/" ).append("\n"); 
		query.append("     , X.SUM_ESTM_USD_AMT AS ESTM_USD_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("/*Turnning , Virtual port 모두 보여준다.*/" ).append("\n"); 
		query.append("     , X.ESTM_USD_AMT AS ESTM_USD_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     , X.ACT_DT" ).append("\n"); 
		query.append("     , X.TXTCOLOR" ).append("\n"); 
		query.append("     , X.ESTM_USD_AMT AS ORI_ESTM_USD_AMT" ).append("\n"); 
		query.append("     , X.SUM_ESTM_USD_AMT AS ORI_SUM_ESTM_USD_AMT" ).append("\n"); 
		query.append("  FROM (SELECT X.*" ).append("\n"); 
		query.append("             , SUM(ESTM_USD_AMT) OVER (PARTITION BY X.KEY_VVD) AS SUM_ESTM_USD_AMT" ).append("\n"); 
		query.append("          FROM (SELECT *" ).append("\n"); 
		query.append("                  FROM V_ESTM_MON_VVD" ).append("\n"); 
		query.append("                ) X" ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${hide_vrtl_port_flg} !='' && ${hide_vrtl_port_flg} == 'Y')" ).append("\n"); 
		query.append("/*Virtual port를 제외하고 기존 Turnning port에 amount Sum*/" ).append("\n"); 
		query.append("   AND X.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY X.LANE" ).append("\n"); 
		query.append("     , X.VSL_CD" ).append("\n"); 
		query.append("     , X.SKD_VOY_NO" ).append("\n"); 
		query.append("     , X.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("     , X.CLPT_SEQ" ).append("\n"); 

	}
}