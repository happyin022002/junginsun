/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaOfficeAdd0162ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaOfficeAdd0162ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 누락 점소추가 List 조회
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaOfficeAdd0162ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mqta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaOfficeAdd0162ListRSQL").append("\n"); 
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
		query.append("SELECT SUB_TRD_CD, RLANE_CD, AQ_CD, RGN_OFC_CD" ).append("\n"); 
		query.append("     FROM SAQ_MON_QTA_OFC_ADD" ).append("\n"); 
		query.append("    WHERE MQTA_STEP_CD = @[mqta_step_cd]" ).append("\n"); 
		query.append("      AND BSE_YR       = @[bse_yr]" ).append("\n"); 
		query.append("      AND BSE_QTR_CD   = @[bse_qtr_cd]" ).append("\n"); 
		query.append("      AND TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("      AND DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("      AND RHQ_CD       = @[rhq_cd]" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD, RLANE_CD, DECODE(NVL(AQ_CD, 99), '99', 99, 11)||AQ_CD, RGN_OFC_CD" ).append("\n"); 

	}
}