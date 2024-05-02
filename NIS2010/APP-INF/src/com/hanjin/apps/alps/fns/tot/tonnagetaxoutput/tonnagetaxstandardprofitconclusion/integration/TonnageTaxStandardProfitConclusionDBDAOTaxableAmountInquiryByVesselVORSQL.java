/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByVesselVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.13
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.05.13 박희동
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

public class TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByVesselVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Taxable Amount Inquiry By Vessel 조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByVesselVORSQL(){
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
		params.put("e_stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByVesselVORSQL").append("\n"); 
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
		query.append("SELECT  SUBSTR(A.STL_YRMON, 5, 6)                          STL_MON" ).append("\n"); 
		query.append("          , A.VSL_CD                                          VSL_CD" ).append("\n"); 
		query.append("          , DECODE(SUBSTR(A.VSL_CD,1,2),'SP','SAMPLE'|| SUBSTR(A.VSL_CD,3,4), B.VSL_ENG_NM)                                      VSL_ENG_NM" ).append("\n"); 
		query.append("          , B.VSL_RGST_CNT_CD                                 VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("          , DECODE(A.TONG_FLET_TP_CD, 'O', 'Owner', 'C', 'Charter', 'J', 'Joint Oper', 'F', 'Feeder', 'L' , 'Lay-up')                            TONG_FLET_TP_CD" ).append("\n"); 
		query.append("          , B.GRS_RGST_TONG_WGT                               GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("          , A.NRT_WGT                                    NRT_WGT" ).append("\n"); 
		query.append("          , A.PER_TON_REV                                     PER_TON_REV" ).append("\n"); 
		query.append("          , NVL(TO_CHAR(B.VSL_DE_DT, 'YYYYMMDD'),'')          VSL_DE_DT" ).append("\n"); 
		query.append("          , NVL(TO_CHAR(C.CTRT_ST_DT, 'YYYYMMDD'),'')         CTRT_ST_DT" ).append("\n"); 
		query.append("          , NVL(TO_CHAR(C.CTRT_END_DT, 'YYYYMMDD'),'')        CTRT_END_DT" ).append("\n"); 
		query.append("          , TRUNC(((TO_DATE(NVL(TO_CHAR(C.CTRT_END_DT,'YYYYMMDD'),NULL), 'YYYYMMDD') - TO_DATE(NVL(TO_CHAR(C.CTRT_ST_DT,'YYYYMMDD'),NULL), 'YYYYMMDD')) / 365), 1)  CTRT_YEAR" ).append("\n"); 
		query.append("          , A.LDB_CAPA_QTY                               LDB_CAPA_QTY" ).append("\n"); 
		query.append("          , A.BSA_CAPA                                   BSA_CAPA" ).append("\n"); 
		query.append("          , NVL(A.CHTR_BSA_CAPA, 0)                      CHTR_BSA_CAPA" ).append("\n"); 
		query.append("          , A.ACT_BSA_CAPA                               ACT_BSA_CAPA" ).append("\n"); 
		query.append("          , 0       CAPA_DIFF" ).append("\n"); 
		query.append("          , A.USG_RT" ).append("\n"); 
		query.append("          , NVL(TO_CHAR(A.FM_VVD_STL_DT, 'YYYYMMDD'),'')                              FM_VVD_STL_DT" ).append("\n"); 
		query.append("          , NVL(TO_CHAR(A.TO_VVD_STL_DT, 'YYYYMMDD'),'')                              TO_VVD_STL_DT" ).append("\n"); 
		query.append("          , A.VOY_DYS                                    VOY_DYS" ).append("\n"); 
		query.append("          , A.TONG_TAX_AMT                               TONG_TAX_AMT" ).append("\n"); 
		query.append("          , C.VSL_SEQ                                         VSL_SEQ" ).append("\n"); 
		query.append("          , A.STL_YRMON                                       STL_YRMON" ).append("\n"); 
		query.append("          , A.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("  FROM TOT_VVD_STL_AMT A, " ).append("\n"); 
		query.append("       MDM_VSL_CNTR    B," ).append("\n"); 
		query.append("      (SELECT * " ).append("\n"); 
		query.append("         FROM TOT_VESSEL V" ).append("\n"); 
		query.append("        WHERE STL_YR = SUBSTR(@[stl_yrmon], 1, 4)" ).append("\n"); 
		query.append("          AND TONG_FLET_TP_CD NOT IN ('E')" ).append("\n"); 
		query.append("          AND DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("          AND VSL_SEQ = (" ).append("\n"); 
		query.append("                  SELECT MAX(VSL_SEQ) " ).append("\n"); 
		query.append("                    FROM TOT_VESSEL X" ).append("\n"); 
		query.append("                   WHERE X.STL_YR = V.STL_YR" ).append("\n"); 
		query.append("                     AND X.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                     AND TONG_FLET_TP_CD NOT IN ('E')" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append(" WHERE  A.STL_YRMON BETWEEN @[stl_yrmon] AND @[e_stl_yrmon]" ).append("\n"); 
		query.append("   AND  A.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("   AND  A.TONG_STL_BAT_JB_SEQ = (" ).append("\n"); 
		query.append("             SELECT MAX(TONG_STL_BAT_JB_SEQ) " ).append("\n"); 
		query.append("               FROM TOT_VVD_STL_AMT " ).append("\n"); 
		query.append("              WHERE STL_YRMON =A.STL_YRMON" ).append("\n"); 
		query.append("                AND NVL(TONG_FLET_TP_CD,'C') <> 'F'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("   AND NVL(A.TONG_FLET_TP_CD,'C') <> 'F'" ).append("\n"); 
		query.append("   AND  A.VSL_CD         =  B.VSL_CD(+)" ).append("\n"); 
		query.append("   AND  A.VSL_CD         =  C.VSL_CD(+)" ).append("\n"); 
		query.append("   AND  NOT (A.ACT_BSA_CAPA = 0 AND A.VOY_DYS = 0) " ).append("\n"); 
		query.append(" ORDER BY STL_MON ,VSL_CD ASC" ).append("\n"); 

	}
}