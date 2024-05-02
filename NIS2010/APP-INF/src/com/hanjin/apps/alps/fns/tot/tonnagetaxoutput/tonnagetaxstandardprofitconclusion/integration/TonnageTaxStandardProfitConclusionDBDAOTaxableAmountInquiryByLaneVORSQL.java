/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.05.04 박희동
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

public class TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Taxable Amount Inquiry By Lane 별로 조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByLaneVORSQL(){
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
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByLaneVORSQL").append("\n"); 
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
		query.append("SELECT            T2.TRD_CD                                          TRD_CD" ).append("\n"); 
		query.append("                , T2.SLAN_CD                                         SLAN_CD" ).append("\n"); 
		query.append("                , T2.VSL_CD                                          VSL_CD" ).append("\n"); 
		query.append("                , DECODE(SUBSTR(T2.VSL_CD,1,2),'SP','SAMPLE'|| SUBSTR(T2.VSL_CD,3,4), T2.VSL_ENG_NM)                                      VSL_ENG_NM" ).append("\n"); 
		query.append("                , SUBSTR(T2.STL_YRMON, 5, 6)                                     STL_MON                  " ).append("\n"); 
		query.append("                , MAX(NVL(TO_CHAR(T2.CTRT_ST_DT, 'YYYYMMDD'),''))         CTRT_ST_DT" ).append("\n"); 
		query.append("                , MAX(NVL(TO_CHAR(T2.CTRT_END_DT, 'YYYYMMDD'),'') )       CTRT_END_DT" ).append("\n"); 
		query.append("                , MAX(T2.NRT_WGT)                                    NRT_WGT" ).append("\n"); 
		query.append("                , MAX(T2.PER_TON_REV)                                     PER_TON_REV " ).append("\n"); 
		query.append("                , MAX(T2.LDB_CAPA_QTY)                               LDB_CAPA_QTY" ).append("\n"); 
		query.append("                                                                                " ).append("\n"); 
		query.append("                , MAX(T2.BSA_CAPA)                                   BSA_CAPA" ).append("\n"); 
		query.append("                , MAX(NVL(T2.CHTR_BSA_CAPA, 0))                      CHTR_BSA_CAPA                 " ).append("\n"); 
		query.append("                , SUM(T2.ACT_BSA_CAPA)                               ACT_BSA_CAPA" ).append("\n"); 
		query.append("                , MAX(T2.USG_RT)                                     USG_RT" ).append("\n"); 
		query.append("                , NVL(TO_CHAR(MIN(T2.ETD_DT), 'YYYYMMDD'),'')             STR_DT" ).append("\n"); 
		query.append("                , NVL(TO_CHAR(MAX(T2.ETD_DT), 'YYYYMMDD'),'')              END_DT" ).append("\n"); 
		query.append("                , SUM(T2.VOY_DYS)                                    VOY_DYS" ).append("\n"); 
		query.append("                , SUM(T2.TONG_TAX_AMT)                               TONG_TAX_AMT     " ).append("\n"); 
		query.append("                , T2.STL_YRMON                                       STL_YRMON " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("           SELECT           T.SLAN_CD" ).append("\n"); 
		query.append("                          , T.VSL_CD" ).append("\n"); 
		query.append("                          , T.VSL_ENG_NM" ).append("\n"); 
		query.append("                          , T.TRD_CD" ).append("\n"); 
		query.append("                          , T.STL_YRMON      " ).append("\n"); 
		query.append("                          , T.BSA_CAPA" ).append("\n"); 
		query.append("                          , T.ACT_BSA_CAPA" ).append("\n"); 
		query.append("                          , T.USG_RT" ).append("\n"); 
		query.append("                          , T.LDB_CAPA_QTY" ).append("\n"); 
		query.append("                          , T.CHTR_BSA_CAPA" ).append("\n"); 
		query.append("                          , T.PER_TON_REV" ).append("\n"); 
		query.append("                          , T.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("                          , T.NRT_WGT                                   " ).append("\n"); 
		query.append("                          , T.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("                          , T.TONG_FLET_TP_CD" ).append("\n"); 
		query.append("                          , T.VSL_DZND_CAPA" ).append("\n"); 
		query.append("                          , T.VSL_DE_DT" ).append("\n"); 
		query.append("                          , T.CTRT_ST_DT" ).append("\n"); 
		query.append("                          , T.CTRT_END_DT" ).append("\n"); 
		query.append("                          , T.VOY_DYS" ).append("\n"); 
		query.append("                          , T.TONG_TAX_AMT" ).append("\n"); 
		query.append("                          , DECODE(NUM,MAX(T.NUM) OVER(PARTITION BY  T.VSL_CD,T.SLAN_CD, T.TRD_CD),T.ETD_DT+VOY_DYS, T.ETD_DT) ETD_DT " ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                   SELECT   D.SLAN_CD" ).append("\n"); 
		query.append("                          , A.VSL_CD" ).append("\n"); 
		query.append("                          , DECODE(SUBSTR(A.VSL_CD,1,2),'SP','SAMPLE'|| SUBSTR(A.VSL_CD,3,4), B.VSL_ENG_NM)  VSL_ENG_NM" ).append("\n"); 
		query.append("                          , D.TRD_CD" ).append("\n"); 
		query.append("                          , A.STL_YRMON      " ).append("\n"); 
		query.append("                          , D.BSA_CAPA" ).append("\n"); 
		query.append("                          , D.ACT_BSA_CAPA" ).append("\n"); 
		query.append("                          , D.USG_RT" ).append("\n"); 
		query.append("                          , D.LDB_CAPA_QTY" ).append("\n"); 
		query.append("                          , D.CHTR_BSA_CAPA" ).append("\n"); 
		query.append("                          , D.PER_TON_REV" ).append("\n"); 
		query.append("                          , B.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("                          , D.NRT_WGT                                   " ).append("\n"); 
		query.append("                          , B.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("                          , A.TONG_FLET_TP_CD" ).append("\n"); 
		query.append("                          , A.VSL_DZND_CAPA" ).append("\n"); 
		query.append("                          , B.VSL_DE_DT" ).append("\n"); 
		query.append("                          , C.CTRT_ST_DT" ).append("\n"); 
		query.append("                          , C.CTRT_END_DT" ).append("\n"); 
		query.append("                          , D.ETD_DT" ).append("\n"); 
		query.append("                          , D.VOY_DYS" ).append("\n"); 
		query.append("                          , TRUNC(D.TONG_TAX_AMT,0)   TONG_TAX_AMT" ).append("\n"); 
		query.append("                          , ROW_NUMBER() OVER(PARTITION BY D.VSL_CD,D.SLAN_CD, D.TRD_CD ORDER BY D.ETD_DT ) NUM" ).append("\n"); 
		query.append("                          " ).append("\n"); 
		query.append("                  FROM TOT_VVD_STL_AMT A, MDM_VSL_CNTR B, " ).append("\n"); 
		query.append("                      (SELECT VSL_CD" ).append("\n"); 
		query.append("                             ,STL_YR" ).append("\n"); 
		query.append("                             ,TONG_FLET_TP_CD" ).append("\n"); 
		query.append("                             ,MAX(VSL_SEQ) VSL_SEQ" ).append("\n"); 
		query.append("                             ,MAX(CTRT_ST_DT)  CTRT_ST_DT" ).append("\n"); 
		query.append("                             ,NVL(MAX(CTRT_END_DT),TO_DATE(TO_CHAR(SYSDATE,'YYYY-MM-DD'),'YYYY-MM-DD'))  CTRT_END_DT" ).append("\n"); 
		query.append("                        FROM TOT_VESSEL B" ).append("\n"); 
		query.append("                       WHERE STL_YR BETWEEN SUBSTR(@[stl_yrmon],1,4) AND SUBSTR(@[e_stl_yrmon],1,4)" ).append("\n"); 
		query.append("                         AND TONG_FLET_TP_CD = (SELECT MAX(TONG_FLET_TP_CD) FROM TOT_VESSEL T WHERE T.STL_YR = B.STL_YR AND T.VSL_CD = B.VSL_CD AND T.DELT_FLG <> 'Y' AND T.TONG_FLET_TP_CD NOT IN ('E'))" ).append("\n"); 
		query.append("                         AND TONG_FLET_TP_CD NOT IN (/*'T',*/'E')" ).append("\n"); 
		query.append("                         AND DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                       GROUP BY VSL_CD,STL_YR,TONG_FLET_TP_CD" ).append("\n"); 
		query.append("                       ) C, " ).append("\n"); 
		query.append("                       TOT_PORT_STL_AMT D" ).append("\n"); 
		query.append("                  WHERE  A.STL_YRMON         BETWEEN @[stl_yrmon] AND @[e_stl_yrmon]" ).append("\n"); 
		query.append("                    AND  A.TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_VVD_STL_AMT WHERE STL_YRMON = A.STL_YRMON AND NVL(TONG_FLET_TP_CD,'C') <> 'F')" ).append("\n"); 
		query.append("                    AND  NVL(A.TONG_FLET_TP_CD,'C') <> 'F'" ).append("\n"); 
		query.append("                    AND  A.VSL_CD         =  B.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND  C.STL_YR(+)    = SUBSTR(A.STL_YRMON, 1, 4)" ).append("\n"); 
		query.append("                    AND  A.VSL_CD         =  C.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND  A.STL_YRMON         =  D.STL_YRMON" ).append("\n"); 
		query.append("                    AND  A.VSL_CD         =  D.VSL_CD" ).append("\n"); 
		query.append("                    AND  A.TONG_STL_BAT_JB_SEQ        =  D.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("                    AND  A.VSL_CD         =  D.VSL_CD" ).append("\n"); 
		query.append("                  #if (${slan_cd} != 'ALL') " ).append("\n"); 
		query.append("					AND D.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("				  #end" ).append("\n"); 
		query.append("				  #if (${trd_cd} != 'ALL') " ).append("\n"); 
		query.append("					AND D.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("				  #end	" ).append("\n"); 
		query.append("                    AND  NOT (D.ACT_BSA_CAPA =0 AND D.VOY_DYS =0)" ).append("\n"); 
		query.append("                                 " ).append("\n"); 
		query.append("          ) T" ).append("\n"); 
		query.append(" ) T2" ).append("\n"); 
		query.append(" GROUP  BY T2.STL_YRMON, T2.VSL_CD, T2.VSL_ENG_NM, T2.SLAN_CD, T2.TRD_CD" ).append("\n"); 
		query.append(" ORDER BY T2.STL_YRMON, MAX(T2.ETD_DT)" ).append("\n"); 

	}
}