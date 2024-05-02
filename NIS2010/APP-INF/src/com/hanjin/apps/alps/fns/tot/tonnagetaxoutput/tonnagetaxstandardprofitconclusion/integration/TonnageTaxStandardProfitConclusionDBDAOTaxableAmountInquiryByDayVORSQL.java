/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByDayVORSQL.java
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

public class TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByDayVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Taxable Amount Inquiry By Day 조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByDayVORSQL(){
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
		params.put("tong_calc_dat_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByDayVORSQL").append("\n"); 
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
		query.append("SELECT STL_YRMON" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , VVD_SEQ" ).append("\n"); 
		query.append("     , TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("     , TONG_CALC_DAT_TP_CD" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , SLAN_CD" ).append("\n"); 
		query.append("     , VSL_CD||SKD_VOY_NO||SKD_DIR_CD    VVD" ).append("\n"); 
		query.append("     , LDB_CAPA_QTY" ).append("\n"); 
		query.append("     , ACT_BSA_CAPA" ).append("\n"); 
		query.append("     , BKG_POL_CD" ).append("\n"); 
		query.append("     , BKG_POD_CD" ).append("\n"); 
		query.append("	 , NVL(TO_CHAR(POL_DEP_DT, 'YYYYMMDD'),'')   POL_DEP_DT" ).append("\n"); 
		query.append("     , NVL(TO_CHAR(POD_DEP_DT, 'YYYYMMDD'),'')   POD_DEP_DT" ).append("\n"); 
		query.append("     , VOY_DYS" ).append("\n"); 
		query.append("     , NRT_WGT" ).append("\n"); 
		query.append("     , LDB_CAPA_QTY/ACT_BSA_CAPA    USG_RT" ).append("\n"); 
		query.append("     , TONG_TAX_AMT" ).append("\n"); 
		query.append("     , PER_TON_REV" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("FROM TOT_FDR_STL_AMT A" ).append("\n"); 
		query.append("WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("  AND TONG_CALC_DAT_TP_CD = @[tong_calc_dat_tp_cd]" ).append("\n"); 
		query.append("  AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("  AND TONG_STL_BAT_JB_SEQ = (" ).append("\n"); 
		query.append("          SELECT MAX(X.TONG_STL_BAT_JB_SEQ)" ).append("\n"); 
		query.append("            FROM TOT_FDR_STL_AMT X" ).append("\n"); 
		query.append("           WHERE X.STL_YRMON = A.STL_YRMON" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}