/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaOfficeAddDataCnt0162RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.22 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaOfficeAddDataCnt0162RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 누락 점소에 추가할 Data 존재 여부 체크.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaOfficeAddDataCnt0162RSQL(){
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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaOfficeAddDataCnt0162RSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("  FROM SAQ_AVG_COST_OFC OFC," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT DECODE(MIN(CONV_DIR_CD), '', @[dir_cd], MIN(CONV_DIR_CD)) AS DIR_CD" ).append("\n"); 
		query.append("          FROM SAQ_MON_DIR_CONV" ).append("\n"); 
		query.append("         WHERE BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("           AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("           AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("           AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("           AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("           AND DIR_CD     = @[dir_cd]       ) CONV," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT APPL_YR, APPL_MON" ).append("\n"); 
		query.append("          FROM SAQ_COST_APPL_BSE" ).append("\n"); 
		query.append("         WHERE BSE_YR      = @[bse_yr]" ).append("\n"); 
		query.append("           AND BSE_QTR_CD  = @[bse_qtr_cd]" ).append("\n"); 
		query.append("           AND COST_DIV_CD = '30'   ) appl" ).append("\n"); 
		query.append(" WHERE OFC.BSE_YR  = APPL.APPL_YR" ).append("\n"); 
		query.append("   AND OFC.BSE_MON = APPL.APPL_MON" ).append("\n"); 
		query.append("   AND OFC.TRD_CD  = @[trd_cd]" ).append("\n"); 
		query.append("   AND OFC.DIR_CD  = CONV.DIR_CD" ).append("\n"); 

	}
}