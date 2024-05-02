/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UsaInlandCostManageDBDAOVerifyServiceModeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.09.27 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInlandCostManageDBDAOVerifyServiceModeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * verify service mode (0 or minus value)
	  * </pre>
	  */
	public UsaInlandCostManageDBDAOVerifyServiceModeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration").append("\n"); 
		query.append("FileName : UsaInlandCostManageDBDAOVerifyServiceModeRSQL").append("\n"); 
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
		query.append("SELECT C.INTG_CD_VAL_DP_DESC AS LOCL_IPI_SVC_MOD_NM" ).append("\n"); 
		query.append("  FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("     , ( SELECT DISTINCT P.USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("            FROM AOC_USA_INLND_TRF_DTL D" ).append("\n"); 
		query.append("               , AOC_USA_IPI_PORT P" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND   D.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("            AND   D.COST_SEL_ROUT_FLG = 'Y'" ).append("\n"); 
		query.append("            AND   D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("            AND   (D.INLND_20FT_TTL_AMT <= 0 OR D.INLND_40FT_TTL_AMT <= 0)" ).append("\n"); 
		query.append("            AND   D.TRSP_CRR_MOD_CD = P.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("            AND   P.PORT_CD = SUBSTR(D.PORT_NOD_CD,1,5)" ).append("\n"); 
		query.append("       ) U" ).append("\n"); 
		query.append("WHERE 1=1       " ).append("\n"); 
		query.append("AND   C.INTG_CD_ID = 'CD03118'" ).append("\n"); 
		query.append("AND   C.INTG_CD_VAL_CTNT = U.USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}