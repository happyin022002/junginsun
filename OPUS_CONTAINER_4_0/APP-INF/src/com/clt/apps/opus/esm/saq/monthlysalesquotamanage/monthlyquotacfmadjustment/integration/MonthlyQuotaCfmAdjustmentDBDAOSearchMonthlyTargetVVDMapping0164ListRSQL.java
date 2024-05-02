/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyTargetVVDMapping0164ListRSQL.java
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

public class MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyTargetVVDMapping0164ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * onthlyTargetVVD의 데이타 모델에 해당되는 값을 불러온다
	  * </pre>
	  */
	public MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyTargetVVDMapping0164ListRSQL(){
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
		params.put("fmBseWk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toBseWk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyTargetVVDMapping0164ListRSQL").append("\n"); 
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
		query.append("SELECT          " ).append("\n"); 
		query.append("        DECODE(M.bse_yr||M.bse_qtr_cd, @[year]||@[quarter], 'R', 'I') AS IBFLAG," ).append("\n"); 
		query.append("        @[year] AS BSE_YR  ," ).append("\n"); 
		query.append("        @[quarter] AS BSE_QTR_CD, " ).append("\n"); 
		query.append("        M.TRD_CD    , " ).append("\n"); 
		query.append("        M.RLANE_CD    ," ).append("\n"); 
		query.append("        M.DIR_CD     , " ).append("\n"); 
		query.append("        M.VSL_CD       , " ).append("\n"); 
		query.append("        M.SKD_VOY_NO, " ).append("\n"); 
		query.append("        M.SKD_DIR_CD  ," ).append("\n"); 
		query.append("        M.SPRT_GRP_CD, " ).append("\n"); 
		query.append("        M.BSA_GRP_CD   , " ).append("\n"); 
		query.append("        M.BSE_MON   , " ).append("\n"); 
		query.append("        M.BSE_WK      ," ).append("\n"); 
		query.append("        M.SUB_TRD_CD , " ).append("\n"); 
		query.append("        M.IOC_CD       , " ).append("\n"); 
		query.append("        M.VVD_SEQ   , " ).append("\n"); 
		query.append("        M.FNL_BSA_CAPA," ).append("\n"); 
		query.append("        TO_CHAR(M.FNL_BSA_CAPA, 'FM099999999990') AS STR_FNL_BSA_CAPA," ).append("\n"); 
		query.append("        TO_CHAR(M.LST_LODG_PORT_ETD_DT, 'YYYY/MM/DD HH24:MI:SS') AS LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("FROM SAQ_MON_CFM_TGT_VVD M" ).append("\n"); 
		query.append("WHERE M.MQTA_RLSE_VER_NO = @[mqtaRlseVerNo]" ).append("\n"); 
		query.append("  AND M.BSE_YR           = @[year]" ).append("\n"); 
		query.append("  AND M.BSE_QTR_CD       = @[quarter]" ).append("\n"); 
		query.append("  AND M.TRD_CD           = @[trade]" ).append("\n"); 
		query.append("  AND M.DIR_CD           = @[bound]" ).append("\n"); 
		query.append("  AND M.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '') " ).append("\n"); 
		query.append("  AND M.RLANE_CD      = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND M.BSE_WK BETWEEN NVL(@[fmBseWk], '01') AND NVL(@[toBseWk], '54')" ).append("\n"); 
		query.append("ORDER BY M.SUB_TRD_CD, M.RLANE_CD, M.BSE_MON, M.BSE_WK, M.LST_LODG_PORT_ETD_DT" ).append("\n"); 

	}
}