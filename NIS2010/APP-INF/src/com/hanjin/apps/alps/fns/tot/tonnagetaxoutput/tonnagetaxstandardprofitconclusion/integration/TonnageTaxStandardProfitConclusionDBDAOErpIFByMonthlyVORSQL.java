/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.05.24 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP I/F By Monthly 조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyVORSQL").append("\n"); 
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
		query.append("SELECT T.VSL_CD" ).append("\n"); 
		query.append("       ,T.NRT_WGT" ).append("\n"); 
		query.append("       ,T.USE" ).append("\n"); 
		query.append("       ,T.VOY_DYS" ).append("\n"); 
		query.append("       ,T.TONG_TAX_AMT" ).append("\n"); 
		query.append("       ,T.TONG_FLET_TP_CD" ).append("\n"); 
		query.append("       ,T.CTRT_DYS" ).append("\n"); 
		query.append("       ,T.VVD_RMK" ).append("\n"); 
		query.append("       ,T.STL_YRMON" ).append("\n"); 
		query.append("FROM (       " ).append("\n"); 
		query.append("          SELECT" ).append("\n"); 
		query.append("          A.VSL_CD" ).append("\n"); 
		query.append("          ,A.NRT_WGT" ).append("\n"); 
		query.append("          ,TRUNC(NVL(A.TONG_TAX_AMT/DECODE((A.PER_TON_REV*A.VOY_DYS),0,NULL,(A.PER_TON_REV*A.VOY_DYS)),0)*100,2) USE" ).append("\n"); 
		query.append("          ,A.VOY_DYS" ).append("\n"); 
		query.append("          ,TRUNC(A.TONG_TAX_AMT,0) TONG_TAX_AMT" ).append("\n"); 
		query.append("          , DECODE(A.TONG_FLET_TP_CD, 'O', 'Owner', 'C', 'Charter', 'J', 'Joint Oper', 'T', 'T/C Out', 'F', 'Feeder', 'L' , 'Lay-up') TONG_FLET_TP_CD" ).append("\n"); 
		query.append("          ,(B.CTRT_END_DT - B.CTRT_ST_DT)/365   CTRT_DYS" ).append("\n"); 
		query.append("          ,C.REMARK                       VVD_RMK" ).append("\n"); 
		query.append("          ,A.STL_YRMON" ).append("\n"); 
		query.append("          FROM TOT_VVD_STL_AMT A," ).append("\n"); 
		query.append("                                (SELECT VSL_CD" ).append("\n"); 
		query.append("                                ,STL_YR" ).append("\n"); 
		query.append("                                ,TONG_FLET_TP_CD" ).append("\n"); 
		query.append("                                ,MAX(VSL_SEQ) VSL_SEQ" ).append("\n"); 
		query.append("                                ,MAX(CTRT_ST_DT)  CTRT_ST_DT" ).append("\n"); 
		query.append("                                ,MAX(CTRT_END_DT)  CTRT_END_DT" ).append("\n"); 
		query.append("                                FROM TOT_VESSEL B" ).append("\n"); 
		query.append("                                WHERE STL_YR = SUBSTR(@[stl_yrmon], 1, 4)" ).append("\n"); 
		query.append("                                AND DELT_FLG <>'Y'" ).append("\n"); 
		query.append("                                AND TONG_FLET_TP_CD = (SELECT MAX(TONG_FLET_TP_CD) FROM TOT_VESSEL T WHERE T.STL_YR = B.STL_YR AND T.VSL_CD = B.VSL_CD AND T.DELT_FLG <> 'Y' AND T.TONG_FLET_TP_CD NOT IN ('E'))" ).append("\n"); 
		query.append("                                AND TONG_FLET_TP_CD(+)  NOT IN (/*'T',*/'E')" ).append("\n"); 
		query.append("                                GROUP BY VSL_CD,STL_YR,TONG_FLET_TP_CD) B" ).append("\n"); 
		query.append("                                ,(SELECT X.STL_YRMON" ).append("\n"); 
		query.append("                                        , X.VSL_CD" ).append("\n"); 
		query.append("                                        , X.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("                                        , SUBSTR(SYS_CONNECT_BY_PATH(X.RMK,' || '),5) AS REMARK" ).append("\n"); 
		query.append("                                  FROM" ).append("\n"); 
		query.append("                                      (SELECT STL_YRMON ,VSL_CD, TONG_STL_BAT_JB_SEQ,SKD_VOY_NO,SKD_DIR_CD, MAX(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) RMK" ).append("\n"); 
		query.append("                                      , COUNT(*) OVER(PARTITION BY STL_YRMON, VSL_CD, TONG_STL_BAT_JB_SEQ) CNT" ).append("\n"); 
		query.append("                                      ,ROW_NUMBER() OVER(PARTITION BY STL_YRMON, VSL_CD, TONG_STL_BAT_JB_SEQ ORDER BY VSL_CD)SEQ" ).append("\n"); 
		query.append("                                      " ).append("\n"); 
		query.append("                                      FROM TOT_PORT_STL_AMT" ).append("\n"); 
		query.append("                                      WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("                                      AND VSL_CD NOT IN ('SP01','SP02','SP03','SP04','SP05','SP06','SP07','SP08','SP09','SP10','SP11','SP12','SP13','SP14','SP15','SP16','SP17','SP18')" ).append("\n"); 
		query.append("                                      AND TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_VVD_STL_AMT WHERE STL_YRMON  = @[stl_yrmon]  AND NVL(TONG_FLET_TP_CD,'C') <> 'F')" ).append("\n"); 
		query.append("                                      GROUP BY STL_YRMON, VSL_CD, TONG_STL_BAT_JB_SEQ,SKD_VOY_NO,SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ORDER BY RMK) X" ).append("\n"); 
		query.append("                                WHERE X.SEQ = X.CNT" ).append("\n"); 
		query.append("                                START WITH X.SEQ = 1" ).append("\n"); 
		query.append("                                CONNECT BY PRIOR X.SEQ+1 = X.SEQ" ).append("\n"); 
		query.append("                                AND PRIOR X.STL_YRMON = X.STL_YRMON" ).append("\n"); 
		query.append("                                AND PRIOR X.VSL_CD = X.VSL_CD" ).append("\n"); 
		query.append("                                AND PRIOR X.TONG_STL_BAT_JB_SEQ = X.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("                                ) C" ).append("\n"); 
		query.append("          WHERE  A.STL_YRMON  = @[stl_yrmon]" ).append("\n"); 
		query.append("          AND  NVL(A.TONG_FLET_TP_CD,'C') <> 'F'" ).append("\n"); 
		query.append("          AND  A.VSL_CD        =  B.VSL_CD(+)" ).append("\n"); 
		query.append("          AND  SUBSTR(A.STL_YRMON, 1, 4) = B.STL_YR(+)" ).append("\n"); 
		query.append("          AND  A.TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_VVD_STL_AMT WHERE STL_YRMON  = @[stl_yrmon] AND NVL(TONG_FLET_TP_CD,'C') <> 'F')" ).append("\n"); 
		query.append("          AND A.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("          AND A.STL_YRMON = C.STL_YRMON(+)" ).append("\n"); 
		query.append("          AND A.TONG_STL_BAT_JB_SEQ = C.TONG_STL_BAT_JB_SEQ(+)" ).append("\n"); 
		query.append("          AND NOT (A.ACT_BSA_CAPA =0 AND A.VOY_DYS = 0)" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT" ).append("\n"); 
		query.append("          A.VSL_CD" ).append("\n"); 
		query.append("          ,A.NRT_WGT" ).append("\n"); 
		query.append("          ,TRUNC(NVL(A.TONG_TAX_AMT/DECODE((A.PER_TON_REV*A.VOY_DYS),0,NULL,(A.PER_TON_REV*A.VOY_DYS)),0)*100,2) USE" ).append("\n"); 
		query.append("          ,A.VOY_DYS" ).append("\n"); 
		query.append("          ,TRUNC(A.TONG_TAX_AMT,0) TONG_TAX_AMT" ).append("\n"); 
		query.append("          , 'Feeder' TONG_FLET_TP_CD" ).append("\n"); 
		query.append("          ,(B.CTRT_END_DT - B.CTRT_ST_DT)/365   CTRT_DYS" ).append("\n"); 
		query.append("          ,C.REMARK                       VVD_RMK" ).append("\n"); 
		query.append("          ,A.STL_YRMON" ).append("\n"); 
		query.append("          FROM TOT_VVD_STL_AMT A," ).append("\n"); 
		query.append("                                (SELECT VSL_CD" ).append("\n"); 
		query.append("                                ,STL_YR" ).append("\n"); 
		query.append("                                ,TONG_FLET_TP_CD" ).append("\n"); 
		query.append("                                ,MAX(VSL_SEQ) VSL_SEQ" ).append("\n"); 
		query.append("                                ,MAX(CTRT_ST_DT)  CTRT_ST_DT" ).append("\n"); 
		query.append("                                ,MAX(CTRT_END_DT)  CTRT_END_DT" ).append("\n"); 
		query.append("                                FROM TOT_VESSEL B" ).append("\n"); 
		query.append("                                WHERE STL_YR = SUBSTR(@[stl_yrmon], 1, 4)" ).append("\n"); 
		query.append("                                AND TONG_FLET_TP_CD = (SELECT MAX(TONG_FLET_TP_CD) FROM TOT_VESSEL T WHERE T.STL_YR = B.STL_YR AND T.VSL_CD = B.VSL_CD AND T.DELT_FLG <> 'Y' AND T.TONG_FLET_TP_CD NOT IN ('E'))" ).append("\n"); 
		query.append("                                AND TONG_FLET_TP_CD NOT IN (/*'T',*/'E')" ).append("\n"); 
		query.append("                                GROUP BY VSL_CD,STL_YR,TONG_FLET_TP_CD) B" ).append("\n"); 
		query.append("                                ,(SELECT X.STL_YRMON" ).append("\n"); 
		query.append("                                        , X.VSL_CD" ).append("\n"); 
		query.append("                                        , X.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("                                        , SUBSTR(SYS_CONNECT_BY_PATH(X.RMK,' || '),5) AS REMARK" ).append("\n"); 
		query.append("                                  FROM" ).append("\n"); 
		query.append("                                      (SELECT STL_YRMON ,VSL_CD, TONG_STL_BAT_JB_SEQ,SKD_VOY_NO,SKD_DIR_CD, MAX(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) RMK" ).append("\n"); 
		query.append("                                      , COUNT(*) OVER(PARTITION BY STL_YRMON, VSL_CD, TONG_STL_BAT_JB_SEQ) CNT" ).append("\n"); 
		query.append("                                      ,ROW_NUMBER() OVER(PARTITION BY STL_YRMON, VSL_CD, TONG_STL_BAT_JB_SEQ ORDER BY VSL_CD)SEQ" ).append("\n"); 
		query.append("                                      " ).append("\n"); 
		query.append("                                      FROM TOT_PORT_STL_AMT" ).append("\n"); 
		query.append("                                      WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("                                      AND VSL_CD IN ('SP01','SP02','SP03','SP04','SP05','SP06','SP07','SP08','SP09','SP10','SP11','SP12','SP13','SP14','SP15','SP16','SP17','SP18')" ).append("\n"); 
		query.append("                                      AND TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_VVD_STL_AMT WHERE STL_YRMON  = @[stl_yrmon]  AND TONG_FLET_TP_CD ='F')" ).append("\n"); 
		query.append("                                      GROUP BY STL_YRMON, VSL_CD, TONG_STL_BAT_JB_SEQ,SKD_VOY_NO,SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ORDER BY RMK) X" ).append("\n"); 
		query.append("                                WHERE X.SEQ = X.CNT" ).append("\n"); 
		query.append("                                START WITH X.SEQ = 1" ).append("\n"); 
		query.append("                                CONNECT BY PRIOR X.SEQ+1 = X.SEQ" ).append("\n"); 
		query.append("                                AND PRIOR X.STL_YRMON = X.STL_YRMON" ).append("\n"); 
		query.append("                                AND PRIOR X.VSL_CD = X.VSL_CD" ).append("\n"); 
		query.append("                                AND PRIOR X.TONG_STL_BAT_JB_SEQ = X.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("                                ) C" ).append("\n"); 
		query.append("          WHERE  A.STL_YRMON  = @[stl_yrmon]" ).append("\n"); 
		query.append("          AND    A.TONG_FLET_TP_CD ='F'" ).append("\n"); 
		query.append("          AND  A.VSL_CD        =  B.VSL_CD(+)" ).append("\n"); 
		query.append("          AND  SUBSTR(A.STL_YRMON, 1, 4) = B.STL_YR(+)" ).append("\n"); 
		query.append("          AND  A.TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_VVD_STL_AMT WHERE STL_YRMON  = @[stl_yrmon] AND TONG_FLET_TP_CD ='F')" ).append("\n"); 
		query.append("          AND A.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("          AND A.STL_YRMON = C.STL_YRMON(+)" ).append("\n"); 
		query.append("          AND A.TONG_STL_BAT_JB_SEQ = C.TONG_STL_BAT_JB_SEQ(+)" ).append("\n"); 
		query.append("          AND A.TONG_STL_BAT_JB_SEQ =(SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_FDR_STL_AMT WHERE STL_YRMON = @[stl_yrmon])" ).append("\n"); 
		query.append("       ) T" ).append("\n"); 
		query.append("ORDER BY T.VSL_CD" ).append("\n"); 

	}
}