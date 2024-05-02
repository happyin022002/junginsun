/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditLaneOfficeAddNew0167ListRSQL.java
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

public class MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditLaneOfficeAddNew0167ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Quota Editing - Lane Add Popup 새로 추가할 Lane에 해당하는 Office List 조회
	  * </pre>
	  */
	public MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditLaneOfficeAddNew0167ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("newRlaneCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgnOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditLaneOfficeAddNew0167ListRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(SLS_YRMON, 5, 2) AS BSE_MON, COST_WK AS BSE_WK    ," ).append("\n"); 
		query.append("          TRD_CD, VSL_CD    , SKD_VOY_NO    , DIR_CD  AS SKD_DIR_CD," ).append("\n"); 
		query.append("          DIR_CD, SUB_TRD_CD," ).append("\n"); 
		query.append("          @[rlane_cd] AS RLANE_CD    ," ).append("\n"); 
		query.append("          @[newRlaneCd] AS NEW_RLANE_CD," ).append("\n"); 
		query.append("          @[rhq_cd] AS RHQ_CD      ," ).append("\n"); 
		query.append("          @[aq_cd] AS AQ_CD       ," ).append("\n"); 
		query.append("          @[rgnOfcCd] AS RGN_OFC_CD  ," ).append("\n"); 
		query.append("          @[add_tp_cd] AS ADD_TP_CD   ," ).append("\n"); 
		query.append("          VVD_BSA_CAPA AS BSA_CAPA," ).append("\n"); 
		query.append("          IOC_CD, " ).append("\n"); 
		query.append("          VVD_SEQ, " ).append("\n"); 
		query.append("		  TO_CHAR(LST_LODG_PORT_ETD_DT,'YYYY-MM-DD HH24:MI:SS') AS LST_LODG_PORT_ETD_DT, DELT_FLG" ).append("\n"); 
		query.append("     FROM COA_MON_VVD" ).append("\n"); 
		query.append("    WHERE TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("      AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("      AND RLANE_CD   = @[newRlaneCd]" ).append("\n"); 
		query.append("      AND SUBSTR(SLS_YRMON, 0, 4) = @[bse_yr]" ).append("\n"); 
		query.append("      AND SUBSTR(sls_yrmon, 5, 2) IN (@[mon], TO_CHAR(@[mon] + 1, 'FM09'), TO_CHAR(@[mon] + 2, 'FM09'))" ).append("\n"); 
		query.append("      AND delt_flg   = 'N'" ).append("\n"); 
		query.append(" ORDER BY BSE_MON                       ," ).append("\n"); 
		query.append("          BSE_WK                        ," ).append("\n"); 
		query.append("          TRD_CD                        ," ).append("\n"); 
		query.append("          RLANE_CD                      ," ).append("\n"); 
		query.append("          VSL_CD||SKD_VOY_NO||SKD_DIR_CD," ).append("\n"); 
		query.append("          RGN_OFC_CD" ).append("\n"); 

	}
}