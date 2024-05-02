/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchMccDtlListByCarNLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchMccDtlListByCarNLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchMccDtlListByCarNLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchMccDtlListByCarNLaneRSQL").append("\n"); 
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
		query.append("WITH V_JOO_SETTLEMENT" ).append("\n"); 
		query.append("AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DENSE_RANK() OVER (ORDER BY ORD)||'. '||T.JO_STL_ITM_NM JO_STL_ITM_CD_NM" ).append("\n"); 
		query.append("     , T.ORD" ).append("\n"); 
		query.append("     , A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , A1.RLANE_CD" ).append("\n"); 
		query.append("     , A1.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , A1.VVD" ).append("\n"); 
		query.append("     , SUM(A1.BSA_QTY) AS BSA_QTY" ).append("\n"); 
		query.append("     , A1.BSA_SLT_PRC" ).append("\n"); 
		query.append("     , SUM(A1.STL_LOCL_AMT) AS STL_LOCL_AMT" ).append("\n"); 
		query.append("     , CASE WHEN A1.JO_STL_ITM_CD='S/H' OR A1.JO_STL_ITM_CD ='OPR' THEN '['||A1.PRE_STL_RMK||'] '||LISTAGG (A1.STL_RMK, ',') WITHIN GROUP (ORDER BY A1.STL_RMK)" ).append("\n"); 
		query.append("            ELSE LISTAGG (A1.STL_RMK, ',') WITHIN GROUP (ORDER BY A1.STL_RMK)" ).append("\n"); 
		query.append("       END AS STL_RMK" ).append("\n"); 
		query.append("     , A1.ORD_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT DECODE(A.JO_STL_ITM_CD,'OPR','S/H',A.JO_STL_ITM_CD) AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , A.RLANE_CD" ).append("\n"); 
		query.append("             , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , A.VVD" ).append("\n"); 
		query.append("             , SUM(A.BSA_QTY) AS BSA_QTY" ).append("\n"); 
		query.append("             , A.BSA_SLT_PRC" ).append("\n"); 
		query.append("             , SUM(A.STL_LOCL_AMT) AS STL_LOCL_AMT" ).append("\n"); 
		query.append("             , SUBSTR(DECODE(A.STL_RMK,NULL,NULL,','||A.STL_RMK)|| DECODE(SUM(A.SAIL_DYS),NULL,NULL,',Sail Days:'||CASE WHEN SUM(A.SAIL_DYS) > 0 THEN TO_CHAR(ROUND(SUM(A.STL_LOCL_AMT)/(SUM(A.BSA_QTY)*A.BSA_SLT_PRC), 3) ,'FM999,990.999') ELSE NULL END), 2) AS STL_RMK" ).append("\n"); 
		query.append("             , A.PRE_STL_RMK" ).append("\n"); 
		query.append("             , A.ORD_SEQ" ).append("\n"); 
		query.append("          FROM (SELECT A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD" ).append("\n"); 
		query.append("                     , DECODE(A.STL_ADJ_FLG,'Y',B.BSA_QTY,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.USD_SLT_BSA_QTY ELSE A.BSA_QTY END) AS BSA_QTY" ).append("\n"); 
		query.append("                     , DECODE(A.STL_ADJ_FLG,'Y',B.BSA_SLT_PRC,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.RF_SCG_PRC ELSE A.BSA_SLT_PRC END) AS BSA_SLT_PRC" ).append("\n"); 
		query.append("                     , NVL(B.STL_LOCL_AMT, A.STL_LOCL_AMT) AS STL_LOCL_AMT" ).append("\n"); 
		query.append("                     , A.SAIL_DYS" ).append("\n"); 
		query.append("                     , SUBSTR(DECODE(A.STL_RMK,NULL,NULL,','||A.STL_RMK)||DECODE(A.FM_PORT_CD,NULL,NULL,DECODE(A.JO_MNU_NM,'RDR',DECODE(A.TO_PORT_CD, NULL,',RDR Port:'||A.FM_PORT_CD,','||A.FM_PORT_CD||'-'||A.TO_PORT_CD), ','||A.FM_PORT_CD||DECODE(A.TO_PORT_CD,NULL,NULL,'-'||A.TO_PORT_CD))), 2) AS STL_RMK" ).append("\n"); 
		query.append("                     , C.JO_STL_ITM_NM AS PRE_STL_RMK" ).append("\n"); 
		query.append("                     , C.ORD_SEQ" ).append("\n"); 
		query.append("                  FROM JOO_SETTLEMENT A" ).append("\n"); 
		query.append("                     , JOO_STL_DTL B" ).append("\n"); 
		query.append("                     , JOO_STL_ITM C" ).append("\n"); 
		query.append("                 WHERE A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-')" ).append("\n"); 
		query.append("                   AND A.ACCT_YRMON = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("                   AND A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.STL_SEQ = B.STL_SEQ (+)" ).append("\n"); 
		query.append("                   AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("                   #if (${rlane_cds} != '') " ).append("\n"); 
		query.append("                        AND A.RLANE_CD IN (" ).append("\n"); 
		query.append("                       #foreach($key IN ${rlane_cds}) " ).append("\n"); 
		query.append("                            #if($velocityCount < $rlane_cds.size()) '$key', #else '$key' #end" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("                    AND A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${trd_cd} != '')" ).append("\n"); 
		query.append("                    AND A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${rev_dir_cd} != '')" ).append("\n"); 
		query.append("                    AND A.RE_DIVR_CD = @[rev_dir_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                    AND A.JO_STL_ITM_CD = C.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("         GROUP BY A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , A.RLANE_CD" ).append("\n"); 
		query.append("             , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , A.VVD" ).append("\n"); 
		query.append("             , A.BSA_SLT_PRC" ).append("\n"); 
		query.append("             , A.STL_RMK" ).append("\n"); 
		query.append("             , A.PRE_STL_RMK" ).append("\n"); 
		query.append("             , A.ORD_SEQ" ).append("\n"); 
		query.append("        )A1" ).append("\n"); 
		query.append("     , (SELECT ORD_SEQ AS ORD" ).append("\n"); 
		query.append("             , JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , JO_STL_ITM_NM" ).append("\n"); 
		query.append("          FROM JOO_STL_ITM) T" ).append("\n"); 
		query.append(" WHERE T.JO_STL_ITM_CD = A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append(" GROUP BY T.ORD" ).append("\n"); 
		query.append("     , T.JO_STL_ITM_NM" ).append("\n"); 
		query.append("     , A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , A1.RLANE_CD" ).append("\n"); 
		query.append("     , A1.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , A1.VVD" ).append("\n"); 
		query.append("     , A1.BSA_SLT_PRC" ).append("\n"); 
		query.append("     , A1.PRE_STL_RMK" ).append("\n"); 
		query.append("     , A1.ORD_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT JO_STL_ITM_CD_NM" ).append("\n"); 
		query.append("     , LOCL_CURR_CD" ).append("\n"); 
		query.append("     , ORD" ).append("\n"); 
		query.append("     , JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("     , DECODE(BSA_QTY, 0, NULL, BSA_QTY) AS BSA_QTY" ).append("\n"); 
		query.append("     , DECODE(BSA_SLT_PRC, 0, NULL, BSA_SLT_PRC) AS BSA_SLT_PRC" ).append("\n"); 
		query.append("     , STL_LOCL_AMT" ).append("\n"); 
		query.append("     , STL_RMK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    /*Raw Data*/" ).append("\n"); 
		query.append("    SELECT S.JO_STL_ITM_CD_NM" ).append("\n"); 
		query.append("         , S.ORD" ).append("\n"); 
		query.append("         , S.ORD_SEQ" ).append("\n"); 
		query.append("         , S.JO_STL_ITM_CD" ).append("\n"); 
		query.append("         , S.RLANE_CD" ).append("\n"); 
		query.append("         , S.LOCL_CURR_CD" ).append("\n"); 
		query.append("         , S.VVD" ).append("\n"); 
		query.append("         , S.BSA_QTY" ).append("\n"); 
		query.append("         , S.BSA_SLT_PRC" ).append("\n"); 
		query.append("         , S.STL_LOCL_AMT" ).append("\n"); 
		query.append("         , S.STL_RMK" ).append("\n"); 
		query.append("      FROM V_JOO_SETTLEMENT S" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     /*JO_STL_ITM_CD_NM, RLANE_CD, LOCL_CURR_CD Total Data*/" ).append("\n"); 
		query.append("     SELECT RL.JO_STL_ITM_CD_NM " ).append("\n"); 
		query.append("         , RL.ORD" ).append("\n"); 
		query.append("         , RL.ORD_SEQ" ).append("\n"); 
		query.append("         , RL.JO_STL_ITM_CD" ).append("\n"); 
		query.append("         , RL.RLANE_CD" ).append("\n"); 
		query.append("         , RL.LOCL_CURR_CD" ).append("\n"); 
		query.append("         , 'Total' AS VVD" ).append("\n"); 
		query.append("         , NULL AS BSA_QTY" ).append("\n"); 
		query.append("         , NULL AS BSA_SLT_PRC" ).append("\n"); 
		query.append("         , SUM(RL.STL_LOCL_AMT) AS STL_LOCL_AMT" ).append("\n"); 
		query.append("         , NULL AS STL_RMK" ).append("\n"); 
		query.append("      FROM V_JOO_SETTLEMENT RL" ).append("\n"); 
		query.append("      GROUP BY RL.JO_STL_ITM_CD_NM, RL.ORD, RL.ORD_SEQ, RL.JO_STL_ITM_CD, RL.RLANE_CD, RL.LOCL_CURR_CD " ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     /*JO_STL_ITM_CD_NM, LOCL_CURR_CD Total Data*/" ).append("\n"); 
		query.append("     SELECT ITM.JO_STL_ITM_CD_NM " ).append("\n"); 
		query.append("         , ITM.ORD" ).append("\n"); 
		query.append("         , ITM.ORD_SEQ" ).append("\n"); 
		query.append("         , ITM.JO_STL_ITM_CD" ).append("\n"); 
		query.append("         , 'Total' RLANE_CD" ).append("\n"); 
		query.append("         , ITM.LOCL_CURR_CD" ).append("\n"); 
		query.append("         , NULL AS VVD" ).append("\n"); 
		query.append("         , NULL AS BSA_QTY" ).append("\n"); 
		query.append("         , NULL AS BSA_SLT_PRC" ).append("\n"); 
		query.append("         , SUM(ITM.STL_LOCL_AMT) AS STL_LOCL_AMT" ).append("\n"); 
		query.append("         , NULL AS STL_RMK" ).append("\n"); 
		query.append("      FROM V_JOO_SETTLEMENT ITM" ).append("\n"); 
		query.append("      GROUP BY ITM.JO_STL_ITM_CD_NM, ITM.ORD, ITM.ORD_SEQ, ITM.JO_STL_ITM_CD, ITM.LOCL_CURR_CD " ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     /*LOCL_CURR_CD Total Data*/" ).append("\n"); 
		query.append("     SELECT 'Total' AS JO_STL_ITM_CD_NM " ).append("\n"); 
		query.append("         , NULL AS ORD" ).append("\n"); 
		query.append("         , NULL AS ORD_SEQ" ).append("\n"); 
		query.append("         , NULL AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("         , NULL RLANE_CD" ).append("\n"); 
		query.append("         , TOT.LOCL_CURR_CD" ).append("\n"); 
		query.append("         , NULL AS VVD" ).append("\n"); 
		query.append("         , NULL AS BSA_QTY" ).append("\n"); 
		query.append("         , NULL AS BSA_SLT_PRC" ).append("\n"); 
		query.append("         , SUM(TOT.STL_LOCL_AMT) AS STL_LOCL_AMT" ).append("\n"); 
		query.append("         , NULL AS STL_RMK" ).append("\n"); 
		query.append("      FROM V_JOO_SETTLEMENT TOT" ).append("\n"); 
		query.append("      GROUP BY TOT.LOCL_CURR_CD " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append(" ORDER BY ORD, RLANE_CD, VVD , LOCL_CURR_CD, ORD_SEQ, STL_RMK" ).append("\n"); 

	}
}