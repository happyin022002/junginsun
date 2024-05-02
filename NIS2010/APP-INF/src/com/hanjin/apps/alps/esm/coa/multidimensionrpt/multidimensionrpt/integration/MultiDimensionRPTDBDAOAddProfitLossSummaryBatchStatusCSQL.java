/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOAddProfitLossSummaryBatchStatusCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.14
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.06.14 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOAddProfitLossSummaryBatchStatusCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add ProfitLoss Summary BatchStatus
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOAddProfitLossSummaryBatchStatusCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_shipper",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tab",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration ").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOAddProfitLossSummaryBatchStatusCSQL").append("\n"); 
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
		query.append(" MERGE INTO COA_UT_COST_CRE_STS A1" ).append("\n"); 
		query.append("  USING (" ).append("\n"); 
		query.append("         SELECT @[f_year]||(SELECT SUBSTR(SLS_FM_DT,5,2) FROM COA_WK_PRD WHERE COST_YR = @[f_year] AND COST_WK = @[f_tab])  COST_YRMON" ).append("\n"); 
		query.append("               ,@[f_tab] COST_WK" ).append("\n"); 
		query.append("               ,'PLRP' CM_UC_CD" ).append("\n"); 
		query.append("               ,'P' COST_CRE_STS_CD             " ).append("\n"); 
		query.append("           FROM DUAL           " ).append("\n"); 
		query.append("        ) A2" ).append("\n"); 
		query.append("  ON (    A1.COST_YRMON      = A2.COST_YRMON" ).append("\n"); 
		query.append("      AND A1.COST_WK         = A2.COST_WK" ).append("\n"); 
		query.append("      AND A1.CM_UC_CD        = A2.CM_UC_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("     INSERT(A1.COST_YRMON, A1.COST_WK, A1.CM_UC_CD, A1.COST_CRE_STS_CD, A1.COST_IF_STS_CD" ).append("\n"); 
		query.append("           ,A1.COST_SRC_FM_YRMON, A1.COST_SRC_TO_YRMON, A1.CRE_USR_ID, A1.CRE_DT, A1.UPD_USR_ID, A1.UPD_DT)" ).append("\n"); 
		query.append("     VALUES(A2.COST_YRMON, A2.COST_WK, A2.CM_UC_CD, A2.COST_CRE_STS_CD, ''" ).append("\n"); 
		query.append("           ,'', '',@[f_shipper], SYSDATE,@[f_shipper], SYSDATE )         " ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET A1.COST_CRE_STS_CD = A2.COST_CRE_STS_CD" ).append("\n"); 
		query.append("           ,A1.UPD_USR_ID      = @[f_shipper]" ).append("\n"); 
		query.append("           ,A1.UPD_DT          = SYSDATE" ).append("\n"); 

	}
}