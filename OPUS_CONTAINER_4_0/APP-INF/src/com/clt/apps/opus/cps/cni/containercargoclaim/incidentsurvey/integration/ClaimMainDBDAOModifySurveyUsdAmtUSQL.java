/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOModifySurveyUsdAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.05.12 양정란
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOModifySurveyUsdAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HandlingCost 의 Survey Type의 inv_usd_amt 변경시 Survey 테이블의 usd_amt 값을 변경한다.(sum값으로)
	  * </pre>
	  */
	public ClaimMainDBDAOModifySurveyUsdAmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOModifySurveyUsdAmtUSQL").append("\n"); 
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
		query.append("UPDATE" ).append("\n"); 
		query.append("    CNI_CGO_CLM_SVEY" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SVYR_FEE_USD_AMT" ).append("\n"); 
		query.append("      , SVYR_FEE_LOCL_AMT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    =" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    NVL (SUM (INV_USD_AMT), 0)" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_CGO_CLM_COST COST" ).append("\n"); 
		query.append("                WHERE" ).append("\n"); 
		query.append("                    COST.CGO_CLM_NO    = @[cgo_clm_no]" ).append("\n"); 
		query.append("                    AND CLM_COST_TP_CD IN ('SS','SP','SC')" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("         , ROUND ( " ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    NVL (SUM (INV_USD_AMT), 0)" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_CGO_CLM_COST COST" ).append("\n"); 
		query.append("                WHERE" ).append("\n"); 
		query.append("                    COST.CGO_CLM_NO    = @[cgo_clm_no]" ).append("\n"); 
		query.append("                    AND CLM_COST_TP_CD IN ('SS','SP','SC')" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            * SVYR_XCH_RT , 2" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            CNI_CGO_CLM_SVEY" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}