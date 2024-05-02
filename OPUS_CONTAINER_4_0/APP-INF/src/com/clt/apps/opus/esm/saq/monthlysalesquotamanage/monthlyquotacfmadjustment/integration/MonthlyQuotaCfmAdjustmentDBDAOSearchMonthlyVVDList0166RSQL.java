/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyVVDList0166RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.10 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyVVDList0166RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Select Popup화면에 대한 조회 이벤트 처리
	  * </pre>
	  */
	public MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyVVDList0166RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqtaRlseVerNo",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyVVDList0166RSQL").append("\n"); 
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
		query.append("    SELECT " ).append("\n"); 
		query.append("          RLANE_CD                              ," ).append("\n"); 
		query.append("          SPRT_GRP_CD||BSA_GRP_CD        AS GRP ," ).append("\n"); 
		query.append("          BSE_MON                        AS MON ," ).append("\n"); 
		query.append("          BSE_WK                         AS WEEK," ).append("\n"); 
		query.append("          VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD ," ).append("\n"); 
		query.append("          FNL_BSA_CAPA                   AS BSA" ).append("\n"); 
		query.append("     FROM SAQ_MON_CFM_TGT_VVD" ).append("\n"); 
		query.append("    WHERE MQTA_RLSE_VER_NO = @[mqtaRlseVerNo]" ).append("\n"); 
		query.append("      AND BSE_YR           = @[year]" ).append("\n"); 
		query.append("      AND BSE_QTR_CD       = @[bse_qtr_cd]" ).append("\n"); 
		query.append("      AND TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("      AND DIR_CD           = @[dir_cd]" ).append("\n"); 
		query.append("#if (${rlane_cd} == '') " ).append("\n"); 
		query.append("      AND RLANE_CD IS NOT NULL" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      AND RLANE_CD         = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY RLANE_CD, GRP, BSE_MON, BSE_WK, VVD" ).append("\n"); 

	}
}