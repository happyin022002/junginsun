/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.11.24 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Taxable Amount Summary 조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryVORSQL(){
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
		params.put("vvd_exist_yn",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryVORSQL").append("\n"); 
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
		query.append("SELECT   A.VSL_CD" ).append("\n"); 
		query.append(",A.NRT_WGT" ).append("\n"); 
		query.append(",A.BSA_CAPA" ).append("\n"); 
		query.append(",A.ACT_BSA_CAPA" ).append("\n"); 
		query.append(",A.USG_RT" ).append("\n"); 
		query.append(",A.FM_VVD_STL_DT" ).append("\n"); 
		query.append(",A.TO_VVD_STL_DT" ).append("\n"); 
		query.append(",A.NRT_TONG_TAX_AMT" ).append("\n"); 
		query.append(",A.TONG_TAX_AMT" ).append("\n"); 
		query.append(",A.STL_YRMON" ).append("\n"); 
		query.append(",A.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append(",A.LDB_CAPA_QTY" ).append("\n"); 
		query.append(",A.PER_TON_REV" ).append("\n"); 
		query.append(",A.TONG_FLET_TP_CD" ).append("\n"); 
		query.append(",A.VOY_DYS" ).append("\n"); 
		query.append(",A.VSL_DZND_CAPA" ).append("\n"); 
		query.append(",A.CHTR_BSA_CAPA" ).append("\n"); 
		query.append(",A.VVD_EXIST_YN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append(",NRT_WGT" ).append("\n"); 
		query.append(",NVL(BSA_CAPA,0) BSA_CAPA" ).append("\n"); 
		query.append(",ACT_BSA_CAPA" ).append("\n"); 
		query.append(",USG_RT" ).append("\n"); 
		query.append(",NVL(TO_CHAR(FM_VVD_STL_DT, 'YYYYMMDD'),'')   FM_VVD_STL_DT" ).append("\n"); 
		query.append(",NVL(TO_CHAR(TO_VVD_STL_DT, 'YYYYMMDD'),'')   TO_VVD_STL_DT" ).append("\n"); 
		query.append(",NRT_TONG_TAX_AMT" ).append("\n"); 
		query.append(",TONG_TAX_AMT" ).append("\n"); 
		query.append(",STL_YRMON" ).append("\n"); 
		query.append(",TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append(",LDB_CAPA_QTY" ).append("\n"); 
		query.append(",PER_TON_REV" ).append("\n"); 
		query.append(",TONG_FLET_TP_CD" ).append("\n"); 
		query.append(",VOY_DYS" ).append("\n"); 
		query.append(",VSL_DZND_CAPA" ).append("\n"); 
		query.append(",CHTR_BSA_CAPA" ).append("\n"); 
		query.append(",@[vvd_exist_yn]  VVD_EXIST_YN" ).append("\n"); 
		query.append("FROM TOT_VVD_STL_AMT" ).append("\n"); 
		query.append("WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND TONG_FLET_TP_CD = 'F'" ).append("\n"); 
		query.append("AND TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_VVD_STL_AMT WHERE STL_YRMON = @[stl_yrmon]  AND TONG_FLET_TP_CD = 'F')" ).append("\n"); 
		query.append("AND 'Y'= @[vvd_exist_yn]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(VOY_DYS,  1, 'SP01',  2, 'SP02',  3, 'SP03',  4, 'SP04',  5, 'SP05',  6, 'SP06'," ).append("\n"); 
		query.append("7, 'SP07',  8, 'SP08',  9, 'SP09', 10, 'SP10', 11, 'SP11', 12, 'SP12'," ).append("\n"); 
		query.append("13, 'SP13', 14, 'SP14', 15, 'SP15', 16, 'SP16', 17, 'SP17', 18, 'SP18') VSL_CD" ).append("\n"); 
		query.append(",NVL(MAX(NRT_WGT), 1276)                     NRT_WGT" ).append("\n"); 
		query.append(",0                                           BSA_CAPA" ).append("\n"); 
		query.append(",ROUND(NVL(SUM(ACT_BSA_CAPA),0),0)           ACT_BSA_CAPA" ).append("\n"); 
		query.append(",MAX(USG_RT)                           USG_RT" ).append("\n"); 
		query.append(",DECODE(VOY_DYS, NULL, '', @[stl_yrmon]||'01')                                                             FM_VVD_STL_DT" ).append("\n"); 
		query.append(",DECODE(VOY_DYS, NULL, '', TO_CHAR(TO_DATE(@[stl_yrmon]||'01','YYYYMMDD') + VOY_DYS, 'YYYYMMDD'))          TO_VVD_STL_DT" ).append("\n"); 
		query.append(",NVL(SUM(NRT_TONG_TAX_AMT),0)                NRT_TONG_TAX_AMT" ).append("\n"); 
		query.append(",NVL(SUM(TONG_TAX_AMT),0)                    TONG_TAX_AMT" ).append("\n"); 
		query.append(",MAX(STL_YRMON)                              STL_YRMON" ).append("\n"); 
		query.append(",MAX(TONG_STL_BAT_JB_SEQ)                    TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append(",MAX(LDB_CAPA_QTY)                           LDB_CAPA_QTY" ).append("\n"); 
		query.append(",MAX(PER_TON_REV)                            PER_TON_REV" ).append("\n"); 
		query.append(",'F'                                         TONG_FLET_TP_CD" ).append("\n"); 
		query.append(",SUM(VOY_DYS)                                VOY_DYS" ).append("\n"); 
		query.append(",0                                           VSL_DZND_CAPA" ).append("\n"); 
		query.append(",0                                           CHTR_BSA_CAPA" ).append("\n"); 
		query.append(",'N'                                         VVD_EXIST_YN" ).append("\n"); 
		query.append("FROM TOT_FDR_STL_AMT" ).append("\n"); 
		query.append("WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_FDR_STL_AMT WHERE STL_YRMON = @[stl_yrmon])" ).append("\n"); 
		query.append("AND VOY_DYS BETWEEN 1 AND 18" ).append("\n"); 
		query.append("AND 'N'= @[vvd_exist_yn]" ).append("\n"); 
		query.append("GROUP BY VOY_DYS" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY A.VSL_CD" ).append("\n"); 

	}
}