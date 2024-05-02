/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOBasicRegisterDBDAOSearchVvdCreationListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDBDAOSearchVvdCreationListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vvd Creation List
	  * </pre>
	  */
	public TCharterIOBasicRegisterDBDAOSearchVvdCreationListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDBDAOSearchVvdCreationListVORSQL").append("\n"); 
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
		query.append("WITH V_PORT AS (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT AR.REV_YRMON" ).append("\n"); 
		query.append("                     , AR.VSL_CD" ).append("\n"); 
		query.append("                     , AR.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , AR.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , AR.SLAN_CD" ).append("\n"); 
		query.append("                     , B.VPS_PORT_CD" ).append("\n"); 
		query.append("                     , MAX(B.VPS_ETD_DT) VPS_ETD_DT" ).append("\n"); 
		query.append("                  FROM AR_MST_REV_VVD AR" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND AR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND AR.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND AR.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND AR.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   --AND AR.REV_YRMON = '201508'" ).append("\n"); 
		query.append("                   --AND NVL(B.SKD_CNG_STS_CD,'Z') <> 'S'" ).append("\n"); 
		query.append("                   AND EXISTS ( SELECT NULL" ).append("\n"); 
		query.append("                                  FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                                 WHERE VSL_CD = AR.VSL_CD" ).append("\n"); 
		query.append("                                   AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                SELECT NULL" ).append("\n"); 
		query.append("                                  FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                     , FMS_ID_VSL FI" ).append("\n"); 
		query.append("                                 WHERE FI.VSL_CD = AR.VSL_CD" ).append("\n"); 
		query.append("                                   AND FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                   AND FC.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                   AND FI.USE_FLG = 'Y')" ).append("\n"); 
		query.append("                 GROUP BY AR.REV_YRMON" ).append("\n"); 
		query.append("                     , AR.VSL_CD" ).append("\n"); 
		query.append("                     , AR.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , AR.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , AR.SLAN_CD" ).append("\n"); 
		query.append("                     , B.VPS_PORT_CD ) A" ).append("\n"); 
		query.append("         ORDER BY A.VSL_CD, A.VPS_ETD_DT " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("     , V_FMS_BSE_PORT AS (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("             , ROW_NUMBER() OVER (PARTITION BY A.VSL_CD ORDER BY A.COM_VVD_FLG, A.VSL_CD, A.VST_DT) AS ORD_SEQ" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT A.*" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.REV_YRMON" ).append("\n"); 
		query.append("                             , A.VSL_CD" ).append("\n"); 
		query.append("                             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                             , A.RLANE_DIR_CD REV_DIR_CD" ).append("\n"); 
		query.append("                             , A.SLAN_CD" ).append("\n"); 
		query.append("                             , A.RLANE_CD" ).append("\n"); 
		query.append("                             , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.RLANE_DIR_CD VVD_CD" ).append("\n"); 
		query.append("                             , CASE WHEN A.COM_VVD_FLG = 'Y' THEN A.REV_YRMON||'01'" ).append("\n"); 
		query.append("                                    ELSE TO_CHAR(DECODE(CS.VPS_ETD_DT,NULL, FMS_VVDDT_FNC(A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.ST_PORT_CD),CS.VPS_ETD_DT),'YYYYMMDD') " ).append("\n"); 
		query.append("                               END VST_DT" ).append("\n"); 
		query.append("                             , CASE WHEN A.COM_VVD_FLG = 'Y' THEN TO_CHAR(LAST_DAY(TO_DATE(A.REV_YRMON,'YYYYMM')), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                    ELSE TO_CHAR(DECODE(CE.VPS_ETD_DT,NULL, FMS_VVDDT_FNC(A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.FNL_PORT_CD),CE.VPS_ETD_DT),'YYYYMMDD') " ).append("\n"); 
		query.append("                               END VED_DT" ).append("\n"); 
		query.append("                             , A.COM_VVD_FLG" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT A.REV_YRMON" ).append("\n"); 
		query.append("                                     , A.VSL_CD" ).append("\n"); 
		query.append("                                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                     , A.RLANE_DIR_CD" ).append("\n"); 
		query.append("                                     , A.SLAN_CD" ).append("\n"); 
		query.append("                                     , A.RLANE_CD" ).append("\n"); 
		query.append("                                     , A.ST_PORT_CD" ).append("\n"); 
		query.append("                                     , A.FNL_PORT_CD" ).append("\n"); 
		query.append("                                     , A.COM_VVD_FLG" ).append("\n"); 
		query.append("                                 FROM (" ).append("\n"); 
		query.append("                                        SELECT DISTINCT AR.REV_YRMON" ).append("\n"); 
		query.append("                                             , AR.VSL_CD" ).append("\n"); 
		query.append("                                             , AR.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             , AR.SKD_DIR_CD" ).append("\n"); 
		query.append("                                             , AR.RLANE_DIR_CD" ).append("\n"); 
		query.append("                                             , AR.SLAN_CD" ).append("\n"); 
		query.append("                                             , AR.RLANE_CD" ).append("\n"); 
		query.append("                                             , B.ST_PORT_CD" ).append("\n"); 
		query.append("                                             , B.FNL_PORT_CD" ).append("\n"); 
		query.append("                                             , AR.COM_VVD_FLG" ).append("\n"); 
		query.append("                                          FROM FMS_BSE_PORT B" ).append("\n"); 
		query.append("                                             , (SELECT VSL_CD" ).append("\n"); 
		query.append("                                                  FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                                                 WHERE FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("                                                   AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                                 UNION ALL" ).append("\n"); 
		query.append("                                                SELECT FI.VSL_CD" ).append("\n"); 
		query.append("                                                  FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                                     , FMS_ID_VSL FI" ).append("\n"); 
		query.append("                                                 WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                                   AND FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("                                                   AND FC.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                                   AND FI.USE_FLG = 'Y') FC" ).append("\n"); 
		query.append("                                             , AR_MST_REV_VVD AR" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND AR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                           AND FC.VSL_CD = AR.VSL_CD" ).append("\n"); 
		query.append("                                           --AND AR.REV_YRMON = '201508'" ).append("\n"); 
		query.append("                                           AND AR.RLANE_CD = B.RLANE_CD(+)" ).append("\n"); 
		query.append("                                           AND AR.SKD_DIR_CD = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                           AND AR.RLANE_DIR_CD = B.REV_DIR_CD(+)" ).append("\n"); 
		query.append("                                           AND AR.SLAN_CD = B.SLAN_CD(+)                                    " ).append("\n"); 
		query.append("                                         UNION ALL" ).append("\n"); 
		query.append("                                        SELECT DISTINCT AR.REV_YRMON" ).append("\n"); 
		query.append("                                             , AR.VSL_CD" ).append("\n"); 
		query.append("                                             , AR.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             , AR.SKD_DIR_CD" ).append("\n"); 
		query.append("                                             , AR.RLANE_DIR_CD" ).append("\n"); 
		query.append("                                             , AR.SLAN_CD" ).append("\n"); 
		query.append("                                             , AR.RLANE_CD" ).append("\n"); 
		query.append("                                             , B.ST_PORT_CD" ).append("\n"); 
		query.append("                                             , B.FNL_PORT_CD" ).append("\n"); 
		query.append("                                             , AR.COM_VVD_FLG" ).append("\n"); 
		query.append("                                          FROM FMS_BSE_PORT B" ).append("\n"); 
		query.append("                                             , (SELECT VSL_CD" ).append("\n"); 
		query.append("                                                  FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                                                 WHERE FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                                                   AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                                 UNION ALL" ).append("\n"); 
		query.append("                                                SELECT FI.VSL_CD" ).append("\n"); 
		query.append("                                                  FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                                     , FMS_ID_VSL FI" ).append("\n"); 
		query.append("                                                 WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                                   AND FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                                                   AND FC.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                                   AND FI.USE_FLG = 'Y') FC" ).append("\n"); 
		query.append("                                             , AR_MST_REV_VVD AR" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND AR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                           AND FC.VSL_CD = AR.VSL_CD" ).append("\n"); 
		query.append("                                           --AND AR.REV_YRMON = '201508'" ).append("\n"); 
		query.append("                                           AND AR.RLANE_CD = B.RLANE_CD(+)" ).append("\n"); 
		query.append("                                           AND AR.SKD_DIR_CD = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                           AND AR.RLANE_DIR_CD = B.REV_DIR_CD(+)" ).append("\n"); 
		query.append("                                           AND AR.SLAN_CD = B.SLAN_CD(+)  " ).append("\n"); 
		query.append("                                      ) A" ).append("\n"); 
		query.append("                                  ORDER BY A.COM_VVD_FLG, A.SLAN_CD " ).append("\n"); 
		query.append("                               ) A" ).append("\n"); 
		query.append("                             , V_PORT CS" ).append("\n"); 
		query.append("                             , V_PORT CE" ).append("\n"); 
		query.append("                         WHERE A.VSL_CD = CS.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO = CS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND A.SKD_DIR_CD = CS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                           AND A.SLAN_CD = CS.SLAN_CD(+)" ).append("\n"); 
		query.append("                           AND A.ST_PORT_CD = CS.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                           AND A.VSL_CD = CE.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO = CE.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND A.SKD_DIR_CD = CE.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                           AND A.SLAN_CD = CE.SLAN_CD(+)" ).append("\n"); 
		query.append("                           AND A.FNL_PORT_CD = CE.VPS_PORT_CD(+) " ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("                 ORDER BY A.COM_VVD_FLG, A.SLAN_CD " ).append("\n"); 
		query.append("            ) A " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("--SELECT * FROM V_PORT;" ).append("\n"); 
		query.append("--SELECT * FROM V_FMS_BSE_PORT;" ).append("\n"); 
		query.append("SELECT 'I' IBFLAG" ).append("\n"); 
		query.append("     , A.REV_YRMON" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , A.SLAN_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.VVD_CD" ).append("\n"); 
		query.append("     , CASE WHEN A.VSL_CD = A.LAG_VSL_CD AND A.VST_DT = A.LAG_VED_DT AND A.ORD_SEQ > 1 THEN TO_CHAR(TO_DATE(A.VST_DT,'YYYYMMDD') + 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("            ELSE A.VST_DT" ).append("\n"); 
		query.append("       END AS VST_DT" ).append("\n"); 
		query.append("     , A.VED_DT" ).append("\n"); 
		query.append("     , A.COM_VVD_FLG" ).append("\n"); 
		query.append("  FROM (SELECT A.*" ).append("\n"); 
		query.append("             , LAG(A.VSL_CD, 1, NULL) OVER (ORDER BY A.COM_VVD_FLG, A.VSL_CD, A.VST_DT) AS LAG_VSL_CD" ).append("\n"); 
		query.append("             , LAG(A.VED_DT, 1, NULL) OVER (ORDER BY A.COM_VVD_FLG, A.VSL_CD, A.VST_DT) AS LAG_VED_DT" ).append("\n"); 
		query.append("             , ROW_NUMBER() OVER (PARTITION BY A.VSL_CD ORDER BY A.COM_VVD_FLG, A.VSL_CD, A.VST_DT) AS ORD_SEQ" ).append("\n"); 
		query.append("          FROM (SELECT A.REV_YRMON" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.REV_DIR_CD" ).append("\n"); 
		query.append("                     , A.SLAN_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.VVD_CD" ).append("\n"); 
		query.append("                     , A.VST_DT" ).append("\n"); 
		query.append("                     , A.VED_DT" ).append("\n"); 
		query.append("                     , A.COM_VVD_FLG" ).append("\n"); 
		query.append("                  FROM (SELECT A.REV_YRMON" ).append("\n"); 
		query.append("                             , A.VSL_CD" ).append("\n"); 
		query.append("                             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                             , A.REV_DIR_CD" ).append("\n"); 
		query.append("                             , A.SLAN_CD" ).append("\n"); 
		query.append("                             , A.RLANE_CD" ).append("\n"); 
		query.append("                             , A.VVD_CD" ).append("\n"); 
		query.append("                             , A.VST_DT" ).append("\n"); 
		query.append("                             , A.VED_DT" ).append("\n"); 
		query.append("                             , A.ORD_SEQ" ).append("\n"); 
		query.append("                             , A.COM_VVD_FLG" ).append("\n"); 
		query.append("                          FROM V_FMS_BSE_PORT A" ).append("\n"); 
		query.append("                         ORDER BY A.VSL_CD, A.VST_DT " ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("                 ORDER BY A.COM_VVD_FLG, A.VSL_CD, A.VST_DT " ).append("\n"); 
		query.append("                ) A " ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.REV_YRMON = REPLACE(@[rev_yrmon],'-')" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("   AND A.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}