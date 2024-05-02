/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryDetailDownRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.07 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryDetailDownRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TaxableAmountSummaryDetailDown
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryDetailDownRSQL(){
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
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryDetailDownRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_CD" ).append("\n"); 
		query.append(", A.NRT_WGT" ).append("\n"); 
		query.append(", A.LDB_CAPA_QTY BSA_CAPA" ).append("\n"); 
		query.append(", A.ACT_BSA_CAPA ACT_BSA_CAPA" ).append("\n"); 
		query.append(", A.USG_RT * 100 USG_RT" ).append("\n"); 
		query.append(", TO_CHAR(A.POL_DEP_DT, 'YYYY-MM-DD') FM_VVD_STL_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.POD_DEP_DT , 'YYYY-MM-DD') TO_VVD_STL_DT" ).append("\n"); 
		query.append(", A.NRT_TONG_TAX_AMT" ).append("\n"); 
		query.append(", A.TONG_TAX_AMT" ).append("\n"); 
		query.append(", A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("FROM TOT_FDR_STL_AMT A" ).append("\n"); 
		query.append("WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_FDR_STL_AMT WHERE STL_YRMON = '201208')" ).append("\n"); 
		query.append("--and rownum < 300" ).append("\n"); 
		query.append("ORDER BY VSL_CD" ).append("\n"); 

	}
}