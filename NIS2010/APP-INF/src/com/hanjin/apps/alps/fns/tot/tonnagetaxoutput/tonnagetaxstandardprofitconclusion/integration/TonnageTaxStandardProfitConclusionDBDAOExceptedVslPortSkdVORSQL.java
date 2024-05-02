/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOExceptedVslPortSkdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOExceptedVslPortSkdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 운항스케쥴대비 배치시 누락 port 데이터 조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOExceptedVslPortSkdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOExceptedVslPortSkdVORSQL").append("\n"); 
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
		query.append("SELECT T1.SLAN_CD                                                                                                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("      ,T2.TRD_CD                                                                                                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("      ,T1.VVD                                                                                                                                                                                                                                                                      " ).append("\n"); 
		query.append("      ,T1.VPS_PORT_CD  PORT_CD                                                                                                                                                                                                                                                                                                   " ).append("\n"); 
		query.append("      ,T1.TURN_PORT_IND_CD                                                                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("      ,T1.ACT_BSA_CAPA" ).append("\n"); 
		query.append("      ,T1.VOY_DYS " ).append("\n"); 
		query.append("      ,T1.STL_YRMON      " ).append("\n"); 
		query.append("      ,T1.VSL_CD                                                                                                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("      ,T1.SKD_VOY_NO                                                                                                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("      ,T1.SKD_DIR_CD    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (SELECT C.SLAN_CD                                                                                                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("            ,C.TRD_CD                                                                                                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("            ,C.VVD                                                                                                                                                                                                                                                                      " ).append("\n"); 
		query.append("            ,C.VPS_PORT_CD                                                                                                                                                                                                                                                                                                      " ).append("\n"); 
		query.append("            ,C.TURN_PORT_IND_CD                                                                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("            ,DECODE(C.ACT_BSA_CAPA,NULL,'-',0,'0',C.ACT_BSA_CAPA)   ACT_BSA_CAPA" ).append("\n"); 
		query.append("            ,DECODE(C.VOY_DYS,NULL,'-',0,'0',C.VOY_DYS) VOY_DYS " ).append("\n"); 
		query.append("            ,C.STL_YRMON      " ).append("\n"); 
		query.append("            ,C.VSL_CD                                                                                                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("            ,C.SKD_VOY_NO                                                                                                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("            ,C.SKD_DIR_CD                                                                                                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("       FROM (SELECT A.VPS_ETD_DT                                                                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("                  ,A.SLAN_CD                                                                                                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("                  ,B.TRD_CD                                                                                                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                  ,A.VSL_CD                                                                                                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                  ,A.SKD_VOY_NO                                                                                                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("                  ,A.SKD_DIR_CD                                                                                                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("                  ,A.VSL_CD ||A.SKD_VOY_NO || A.SKD_DIR_CD   VVD                                                                                                                                                                                                                                                                      " ).append("\n"); 
		query.append("                  ,A.VPS_PORT_CD                                                                                                                                                                                                                                                                                                      " ).append("\n"); 
		query.append("                  ,A.TURN_PORT_IND_CD                                                                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("                  ,A.TURN_SKD_VOY_NO                                                                                                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("                  ,A.SKD_CNG_STS_CD                                                                                                                                                                                                                                                                                                   " ).append("\n"); 
		query.append("                  ,B.TONG_STL_BAT_JB_SEQ                                                                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("                  ,TO_CHAR(A.VPS_ETD_DT,'YYYYMM')  STL_YRMON" ).append("\n"); 
		query.append("                  ,B.ACT_BSA_CAPA" ).append("\n"); 
		query.append("                  ,B.VOY_DYS                                                                                                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD A, (SELECT * FROM TOT_PORT_STL_AMT  X                                                                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                                        WHERE X.STL_YRMON BETWEEN @[stl_yrmon] AND @[e_stl_yrmon]                                                                                                                                                                                                                                                                      " ).append("\n"); 
		query.append("                                         AND  X.TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_PORT_STL_AMT WHERE STL_YRMON = X.STL_YRMON)) B                                                                                                                                                                               " ).append("\n"); 
		query.append("              WHERE TO_CHAR(A.VPS_ETD_DT,'YYYYMM') BETWEEN @[stl_yrmon] AND @[e_stl_yrmon]                                                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("                AND A.VSL_CD = B.VSL_CD(+)                                                                                                                                                                                                                                                                                               " ).append("\n"); 
		query.append("                AND A.SKD_VOY_NO = B.SKD_VOY_NO(+)                                                                                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("                AND A.SKD_DIR_CD = B.SKD_DIR_CD(+)                                                                                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("                AND A.VPS_PORT_CD = B.PORT_CD(+)                                                                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("                AND TO_CHAR(A.VPS_ETD_DT,'YYYYMM') = B.STL_YRMON(+) " ).append("\n"); 
		query.append("              ) C" ).append("\n"); 
		query.append("       WHERE C.SLAN_CD IN ( SELECT VSL_SLAN_CD FROM MDM_VSL_SVC_LANE WHERE VSL_SVC_TP_CD  IN ('J','S','I') AND DELT_FLG = 'N') " ).append("\n"); 
		query.append("         AND C.TONG_STL_BAT_JB_SEQ IS NULL OR (C.ACT_BSA_CAPA = 0 AND C.VOY_DYS = 0)" ).append("\n"); 
		query.append("      )T1," ).append("\n"); 
		query.append("      ( SELECT G.VSL_CD" ).append("\n"); 
		query.append("             , G.SKD_VOY_NO" ).append("\n"); 
		query.append("             , G.SKD_DIR_CD" ).append("\n"); 
		query.append("             , G.SLAN_CD" ).append("\n"); 
		query.append("             , G.TRD_CD" ).append("\n"); 
		query.append("        FROM ( SELECT F.VSL_CD" ).append("\n"); 
		query.append("                   , F.SKD_VOY_NO" ).append("\n"); 
		query.append("                   , F.SKD_DIR_CD" ).append("\n"); 
		query.append("                   , E.SLAN_CD" ).append("\n"); 
		query.append("                   , F.TRD_CD" ).append("\n"); 
		query.append("                   , F.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("                   , ROW_NUMBER() OVER(PARTITION BY F.VSL_CD, F.SKD_VOY_NO, F.SKD_DIR_CD, E.SLAN_CD ORDER BY F.VSL_CD, F.SKD_VOY_NO, F.SKD_DIR_CD, E.SLAN_CD ASC, F.FNL_HJS_BSA_CAPA DESC, F.TRD_CD ASC) NUM_BY_LANE   " ).append("\n"); 
		query.append("                FROM MAS_MON_VVD E, BSA_VVD_MST F" ).append("\n"); 
		query.append("                WHERE E.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                  AND E.VSL_CD = F.VSL_CD" ).append("\n"); 
		query.append("                  AND E.SKD_VOY_NO = F.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND E.DIR_CD = F.SKD_DIR_CD " ).append("\n"); 
		query.append("                  AND E.TRD_CD = F.TRD_CD" ).append("\n"); 
		query.append("                  AND E.RLANE_CD = F.RLANE_CD" ).append("\n"); 
		query.append("              )G" ).append("\n"); 
		query.append("         WHERE  G.NUM_BY_LANE = 1  " ).append("\n"); 
		query.append("       ) T2      " ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append(" #if (${slan_cd} != 'ALL') " ).append("\n"); 
		query.append("     AND T1.SLAN_CD = @[slan_cd] " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("     AND T1.VSL_CD =   T2.VSL_CD (+)" ).append("\n"); 
		query.append("     AND T1.SKD_VOY_NO = T2.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("     AND T1.SKD_DIR_CD = T2.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("     AND T1.SLAN_CD = T2.SLAN_CD (+)" ).append("\n"); 
		query.append(" #if (${s_exp_port} == 'A') " ).append("\n"); 
		query.append("     AND T1.VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')  " ).append("\n"); 
		query.append(" #elseif (${s_exp_port} == 'E')" ).append("\n"); 
		query.append("     AND T1.VPS_PORT_CD <> 'EGSUZ'" ).append("\n"); 
		query.append(" #elseif (${s_exp_port} == 'P')" ).append("\n"); 
		query.append("     AND T1.VPS_PORT_CD <> 'PAPAC'   " ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${s_exp_turn} == 'A') " ).append("\n"); 
		query.append("     AND T1.TURN_PORT_IND_CD NOT IN ('V','D','F')  " ).append("\n"); 
		query.append(" #elseif (${s_exp_turn} == 'V')" ).append("\n"); 
		query.append("     AND T1.TURN_PORT_IND_CD <> 'V'" ).append("\n"); 
		query.append(" #elseif (${s_exp_turn} == 'D')" ).append("\n"); 
		query.append("     AND T1.TURN_PORT_IND_CD<> 'D'  " ).append("\n"); 
		query.append(" #elseif (${s_exp_turn} == 'F')" ).append("\n"); 
		query.append("     AND T1.TURN_PORT_IND_CD <> 'F'  " ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(" #if (${trd_cd} != 'ALL') " ).append("\n"); 
		query.append("      AND T2.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" ORDER BY T1.VVD" ).append("\n"); 

	}
}