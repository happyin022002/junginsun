/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PRISimulationDBDAOSearchUnmatchRateByPctlNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRISimulationDBDAOSearchUnmatchRateByPctlNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRISimulationDBDAOSearchUnmatchRateByPctlNoRSQL
	  * </pre>
	  */
	public PRISimulationDBDAOSearchUnmatchRateByPctlNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration").append("\n"); 
		query.append("FileName : PRISimulationDBDAOSearchUnmatchRateByPctlNoRSQL").append("\n"); 
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
		query.append("WITH CHG AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/* VERIFY - 'Y' */" ).append("\n"); 
		query.append(" SELECT   " ).append("\n"); 
		query.append("         AUTO_RAT_FLG" ).append("\n"); 
		query.append("        ,PCTL_NO" ).append("\n"); 
		query.append("        ,CNTR_SZ_CD" ).append("\n"); 
		query.append("        ,SUBSTR(CNTR_SZ_CD,1,1) AS CNTR_TP_CD" ).append("\n"); 
		query.append("        ,CMDT_CD" ).append("\n"); 
		query.append("        ,CMDT_CD AS GRP_CMDT" ).append("\n"); 
		query.append("        ,(SELECT CMDT_NM FROM MDM_COMMODITY M WHERE M.CMDT_CD = RT.CMDT_CD) AS CMDT_NM" ).append("\n"); 
		query.append("        ,CMDT_SEQ" ).append("\n"); 
		query.append("        ,RT_SEQ" ).append("\n"); 
		query.append("        ,FRT_TERM_CD" ).append("\n"); 
		query.append("        ,CGO_CATE_CD AS CGO_TP_CD" ).append("\n"); 
		query.append("        ,IMDG_CLSS_CD" ).append("\n"); 
		query.append("        ,CHG_CD" ).append("\n"); 
		query.append("        ,CURR_CD" ).append("\n"); 
		query.append("        ,RAT_UT_CD" ).append("\n"); 
		query.append("        ,BKG_QTY" ).append("\n"); 
		query.append("        ,RAT_AS_QTY" ).append("\n"); 
		query.append("        ,CHG_UT_AMT" ).append("\n"); 
		query.append("        ,CHG_AMT" ).append("\n"); 
		query.append("        ,RCV_TERM_CD" ).append("\n"); 
		query.append("        ,DE_TERM_CD" ).append("\n"); 
		query.append("        ,FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("        ,APLY_XCH_RTO" ).append("\n"); 
		query.append("        ,NOTE_RT_SEQ" ).append("\n"); 
		query.append("        ,PROP_NO" ).append("\n"); 
		query.append("        ,AMDT_SEQ" ).append("\n"); 
		query.append("--        ,SVC_SCP_CD" ).append("\n"); 
		query.append("        ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        ,ROUT_SEQ" ).append("\n"); 
		query.append("        ,(SELECT TO_CHAR(RT_APLY_DT,'YYYYMMDD') FROM PRI_SIM_RT WHERE PCTL_NO = RT.PCTL_NO AND ROWNUM = 1) RT_APLY_DT" ).append("\n"); 
		query.append("        ,ORG_INLND_HLG_AMT" ).append("\n"); 
		query.append("        ,DEST_INLND_HLG_AMT" ).append("\n"); 
		query.append("        ,ORG_ARB_AMT" ).append("\n"); 
		query.append("        ,DEST_ARB_AMT" ).append("\n"); 
		query.append("        ,SOC_FLG" ).append("\n"); 
		query.append("   FROM PRI_SIM_CHG_RT RT" ).append("\n"); 
		query.append("  WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("    AND CHG_CD = 'OFT'" ).append("\n"); 
		query.append("    AND RT.AUTO_RAT_FLG ='Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* UNMATCH - 'N' */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("         AUTO_RAT_FLG" ).append("\n"); 
		query.append("        ,PCTL_NO" ).append("\n"); 
		query.append("        ,CNTR_SZ_CD" ).append("\n"); 
		query.append("        ,SUBSTR(CNTR_SZ_CD,1,1) AS CNTR_TP_CD" ).append("\n"); 
		query.append("        ,CMDT_CD" ).append("\n"); 
		query.append("        ,CMDT_CD AS GRP_CMDT" ).append("\n"); 
		query.append("        ,(SELECT CMDT_NM FROM MDM_COMMODITY M WHERE M.CMDT_CD = RT.CMDT_CD) AS CMDT_NM" ).append("\n"); 
		query.append("        ,CMDT_SEQ" ).append("\n"); 
		query.append("        ,RT_SEQ" ).append("\n"); 
		query.append("        ,FRT_TERM_CD" ).append("\n"); 
		query.append("        ,CGO_CATE_CD AS CGO_TP_CD" ).append("\n"); 
		query.append("        ,IMDG_CLSS_CD" ).append("\n"); 
		query.append("        ,CHG_CD" ).append("\n"); 
		query.append("        ,CURR_CD" ).append("\n"); 
		query.append("        ,RAT_UT_CD" ).append("\n"); 
		query.append("        ,BKG_QTY" ).append("\n"); 
		query.append("        ,RAT_AS_QTY" ).append("\n"); 
		query.append("        ,CHG_UT_AMT" ).append("\n"); 
		query.append("        ,CHG_AMT" ).append("\n"); 
		query.append("        ,RCV_TERM_CD" ).append("\n"); 
		query.append("        ,DE_TERM_CD" ).append("\n"); 
		query.append("        ,FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("        ,APLY_XCH_RTO" ).append("\n"); 
		query.append("        ,NOTE_RT_SEQ" ).append("\n"); 
		query.append("        ,PROP_NO" ).append("\n"); 
		query.append("        ,AMDT_SEQ" ).append("\n"); 
		query.append("--        ,SVC_SCP_CD" ).append("\n"); 
		query.append("        ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        ,ROUT_SEQ" ).append("\n"); 
		query.append("        ,(SELECT TO_CHAR(RT_APLY_DT,'YYYYMMDD') FROM PRI_SIM_RT WHERE PCTL_NO = RT.PCTL_NO AND ROWNUM = 1) RT_APLY_DT" ).append("\n"); 
		query.append("        ,ORG_INLND_HLG_AMT" ).append("\n"); 
		query.append("        ,DEST_INLND_HLG_AMT" ).append("\n"); 
		query.append("        ,ORG_ARB_AMT" ).append("\n"); 
		query.append("        ,DEST_ARB_AMT" ).append("\n"); 
		query.append("        ,SOC_FLG" ).append("\n"); 
		query.append("   FROM PRI_SIM_CHG_RT RT" ).append("\n"); 
		query.append("  WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("    AND CHG_CD = 'OFT'" ).append("\n"); 
		query.append("    AND RT.AUTO_RAT_FLG ='N'" ).append("\n"); 
		query.append("    AND NOT EXISTS (SELECT 'Y' FROM PRI_SIM_CHG_RT RT1" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                      AND RT1.CHG_CD ='OFT'" ).append("\n"); 
		query.append("                      AND RT1.PCTL_NO = RT.PCTL_NO" ).append("\n"); 
		query.append("                      AND RT1.CNTR_SZ_CD = RT.CNTR_SZ_CD" ).append("\n"); 
		query.append("                      AND RT1.CMDT_CD = RT.CMDT_CD" ).append("\n"); 
		query.append("                      AND RT1.CGO_CATE_CD = RT.CGO_CATE_CD" ).append("\n"); 
		query.append("                      AND RT1.CHG_CD = RT.CHG_CD" ).append("\n"); 
		query.append("                      AND RT1.CURR_CD = RT.CURR_CD" ).append("\n"); 
		query.append("                      AND RT1.RAT_UT_CD = RT.RAT_UT_CD" ).append("\n"); 
		query.append("                      AND RT1.CHG_AMT = RT.CHG_AMT" ).append("\n"); 
		query.append("                      AND RT1.RCV_TERM_CD = RT.RCV_TERM_CD" ).append("\n"); 
		query.append("                      AND RT1.DE_TERM_CD = RT.DE_TERM_CD" ).append("\n"); 
		query.append("                      AND RT1.AUTO_RAT_FLG ='Y'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT X.*" ).append("\n"); 
		query.append("      ,X.BASE_RT+X.SCHG_RT AS TTL_RT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT OFT.*" ).append("\n"); 
		query.append("              ,OFT.OFT_CNTR_SZ_CD AS ORG_CNTR_SZ_CD" ).append("\n"); 
		query.append("              ,(SELECT CNTR_SZ_CD ||'0' " ).append("\n"); 
		query.append("                  FROM MDM_CNTR_TP_SZ " ).append("\n"); 
		query.append("                 WHERE CNTR_TPSZ_CD = OFT.OFT_CNTR_SZ_CD " ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM =1 ) AS CNTR_SZ_CD" ).append("\n"); 
		query.append("          ,ROUND(OFT.APLY_XCH_RTO * OFT.CHG_AMT,2) AS BASE_RT" ).append("\n"); 
		query.append("          ,(SELECT NVL(SUM(OTH.APLY_XCH_RTO * OTH.CHG_AMT),0)" ).append("\n"); 
		query.append("              FROM PRI_SIM_CHG_RT OTH" ).append("\n"); 
		query.append("             WHERE OFT.PCTL_NO = OTH.PCTL_NO" ).append("\n"); 
		query.append("               AND OFT.OFT_CNTR_SZ_CD = OTH.CNTR_SZ_CD" ).append("\n"); 
		query.append("               AND OFT.GRP_CMDT = OTH.CMDT_CD" ).append("\n"); 
		query.append("               AND OFT.CMDT_SEQ = OTH.CMDT_SEQ" ).append("\n"); 
		query.append("               AND OFT.AUTO_RAT_FLG = OTH.AUTO_RAT_FLG" ).append("\n"); 
		query.append("               AND OTH.CHG_CD <> 'OFT'" ).append("\n"); 
		query.append("               AND OTH.RAT_UT_CD NOT IN ('CM','MT')--금액은 의미없음" ).append("\n"); 
		query.append("               AND OTH.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("           ) AS SCHG_RT" ).append("\n"); 
		query.append("          ,NVL((SELECT 'Y'" ).append("\n"); 
		query.append("              FROM PRI_SIM_CHG_RT OTH" ).append("\n"); 
		query.append("             WHERE OFT.PCTL_NO = OTH.PCTL_NO" ).append("\n"); 
		query.append("               AND OFT.OFT_CNTR_SZ_CD = OTH.CNTR_SZ_CD" ).append("\n"); 
		query.append("               AND OFT.GRP_CMDT = OTH.CMDT_CD" ).append("\n"); 
		query.append("               AND OFT.CMDT_SEQ = OTH.CMDT_SEQ" ).append("\n"); 
		query.append("               AND OFT.AUTO_RAT_FLG = OTH.AUTO_RAT_FLG" ).append("\n"); 
		query.append("               AND OTH.CHG_CD = 'GOH'" ).append("\n"); 
		query.append("               AND OTH.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("           ),'N') AS GOH_YN" ).append("\n"); 
		query.append("          ,(SELECT NVL(SUM(OTH.APLY_XCH_RTO * OTH.CHG_AMT),0)" ).append("\n"); 
		query.append("              FROM PRI_SIM_CHG_RT OTH" ).append("\n"); 
		query.append("             WHERE OFT.PCTL_NO = OTH.PCTL_NO" ).append("\n"); 
		query.append("               AND OFT.OFT_CNTR_SZ_CD = OTH.CNTR_SZ_CD" ).append("\n"); 
		query.append("               AND OFT.GRP_CMDT = OTH.CMDT_CD" ).append("\n"); 
		query.append("               AND OFT.CMDT_SEQ = OTH.CMDT_SEQ" ).append("\n"); 
		query.append("               AND OFT.AUTO_RAT_FLG = OTH.AUTO_RAT_FLG" ).append("\n"); 
		query.append("               AND OTH.CHG_CD = 'GOH'" ).append("\n"); 
		query.append("               AND OTH.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("           ) AS GOH_AMT" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("    /* grp cmdt */" ).append("\n"); 
		query.append("            SELECT CHG.AUTO_RAT_FLG" ).append("\n"); 
		query.append("                  ,CHG.PCTL_NO" ).append("\n"); 
		query.append("                  ,CHG.CNTR_SZ_CD AS OFT_CNTR_SZ_CD" ).append("\n"); 
		query.append("                  ,CHG.CNTR_TP_CD" ).append("\n"); 
		query.append("                  ,GRP.CMDT_CD" ).append("\n"); 
		query.append("                  ,GRP.GRP_CMDT" ).append("\n"); 
		query.append("                  ,GRP.CMDT_NM" ).append("\n"); 
		query.append("                  ,CHG.CMDT_SEQ" ).append("\n"); 
		query.append("                  ,CHG.RT_SEQ" ).append("\n"); 
		query.append("                  ,CHG.FRT_TERM_CD" ).append("\n"); 
		query.append("                  ,CHG.CGO_TP_CD" ).append("\n"); 
		query.append("                  ,CHG.IMDG_CLSS_CD" ).append("\n"); 
		query.append("                  ,CHG.CHG_CD" ).append("\n"); 
		query.append("                  ,CHG.CURR_CD" ).append("\n"); 
		query.append("                  ,CHG.RAT_UT_CD" ).append("\n"); 
		query.append("                  ,CHG.BKG_QTY" ).append("\n"); 
		query.append("                  ,CHG.RAT_AS_QTY" ).append("\n"); 
		query.append("                  ,CHG.CHG_UT_AMT" ).append("\n"); 
		query.append("                  ,CHG.CHG_AMT" ).append("\n"); 
		query.append("                  ,CHG.RCV_TERM_CD" ).append("\n"); 
		query.append("                  ,CHG.DE_TERM_CD" ).append("\n"); 
		query.append("                  ,CHG.FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("                  ,CHG.APLY_XCH_RTO" ).append("\n"); 
		query.append("                  ,CHG.NOTE_RT_SEQ" ).append("\n"); 
		query.append("                  ,CHG.PROP_NO" ).append("\n"); 
		query.append("                  ,CHG.AMDT_SEQ" ).append("\n"); 
		query.append("--                  ,CHG.SVC_SCP_CD" ).append("\n"); 
		query.append("                  ,CHG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                  ,CHG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                  ,CHG.ROUT_SEQ" ).append("\n"); 
		query.append("                  ,CHG.RT_APLY_DT" ).append("\n"); 
		query.append("                  ,CHG.ORG_INLND_HLG_AMT" ).append("\n"); 
		query.append("                  ,CHG.DEST_INLND_HLG_AMT" ).append("\n"); 
		query.append("                  ,CHG.ORG_ARB_AMT" ).append("\n"); 
		query.append("                  ,CHG.DEST_ARB_AMT" ).append("\n"); 
		query.append("                  ,CHG.SOC_FLG" ).append("\n"); 
		query.append("              FROM CHG" ).append("\n"); 
		query.append("                   ,(SELECT G.PRC_GRP_CMDT_CD AS GRP_CMDT," ).append("\n"); 
		query.append("                            D.PRC_CMDT_DEF_CD AS CMDT_CD," ).append("\n"); 
		query.append("                            (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = D.PRC_CMDT_DEF_CD) AS CMDT_NM" ).append("\n"); 
		query.append("#if (${ctrt_tp} == 'S') " ).append("\n"); 
		query.append("                      FROM    PRI_SP_SCP_GRP_CMDT     G ," ).append("\n"); 
		query.append("                              PRI_SP_SCP_GRP_CMDT_DTL D" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                      FROM    PRI_RP_SCP_GRP_CMDT     G ," ).append("\n"); 
		query.append("                              PRI_RP_SCP_GRP_CMDT_DTL D" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     WHERE D.PROP_NO         = G.PROP_NO" ).append("\n"); 
		query.append("                       AND D.AMDT_SEQ        = G.AMDT_SEQ" ).append("\n"); 
		query.append("                       AND D.SVC_SCP_CD      = G.SVC_SCP_CD" ).append("\n"); 
		query.append("                       AND D.GRP_CMDT_SEQ    = G.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("                       AND D.SRC_INFO_CD     <> 'AD'" ).append("\n"); 
		query.append("                       AND (D.PROP_NO, D.AMDT_SEQ, D.SVC_SCP_CD) = (SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD " ).append("\n"); 
		query.append("                                                                      FROM PRI_SIM_CHG_RT C " ).append("\n"); 
		query.append("                                                                     WHERE C.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                                                                       AND C.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("                                                                       AND C.PROP_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                                       AND ROWNUM=1)" ).append("\n"); 
		query.append("                    )   GRP" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND CHG.CMDT_CD = GRP.GRP_CMDT" ).append("\n"); 
		query.append("               AND CHG.CMDT_CD LIKE 'G%'" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    /* individual */  " ).append("\n"); 
		query.append("            SELECT CHG.*" ).append("\n"); 
		query.append("              FROM CHG" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND CHG.CMDT_CD NOT LIKE 'G%'" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ) OFT" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(" WHERE CNTR_SZ_CD IS NOT NULL" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '') " ).append("\n"); 
		query.append("   AND CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY PCTL_NO, AUTO_RAT_FLG DESC, CMDT_NM, CMDT_CD, ORG_CNTR_SZ_CD, CMDT_SEQ" ).append("\n"); 

	}
}