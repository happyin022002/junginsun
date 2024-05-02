/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BasicDataDBDAOSearchDailyForcastManageByVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchDailyForcastManageByVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 불규칙한 Lane-Ofc-POL 정보
	  * </pre>
	  */
	public BasicDataDBDAOSearchDailyForcastManageByVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ocnipc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchDailyForcastManageByVvdListRSQL").append("\n"); 
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
		query.append("  SELECT REP_TRD_CD    ," ).append("\n"); 
		query.append("         REP_SUB_TRD_CD," ).append("\n"); 
		query.append("         RLANE_CD      ," ).append("\n"); 
		query.append("         DIR_CD        ," ).append("\n"); 
		query.append("         DECODE(IOC_TS_CD, 'O', 'OCN', 'I', 'IPC', 'T', 'T/S') AS IOC_TS_CD," ).append("\n"); 
		query.append("         VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD      ," ).append("\n"); 
		query.append("         SUBSTR(SLS_YRMON, 1, 4)        AS SLS_YRMON," ).append("\n"); 
		query.append("         COST_WK   ," ).append("\n"); 
		query.append("         SLS_AQ_CD ," ).append("\n"); 
		query.append("         SLS_OFC_CD," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  1, POL_CD)) AS POL_CD1 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  2, POL_CD)) AS POL_CD2 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  3, POL_CD)) AS POL_CD3 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  4, POL_CD)) AS POL_CD4 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  5, POL_CD)) AS POL_CD5 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  6, POL_CD)) AS POL_CD6 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  7, POL_CD)) AS POL_CD7 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  8, POL_CD)) AS POL_CD8 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  9, POL_CD)) AS POL_CD9 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ, 10, POL_CD)) AS POL_CD10" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT A.REP_TRD_CD     AS REP_TRD_CD    ," ).append("\n"); 
		query.append("                   A.REP_SUB_TRD_CD AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                   A.RLANE_CD       AS RLANE_CD      ," ).append("\n"); 
		query.append("                   A.DIR_CD         AS DIR_CD        ," ).append("\n"); 
		query.append("                   A.IOC_TS_CD      AS IOC_TS_CD     ," ).append("\n"); 
		query.append("                   A.VSL_CD         AS VSL_CD        ," ).append("\n"); 
		query.append("                   A.SKD_VOY_NO     AS SKD_VOY_NO    ," ).append("\n"); 
		query.append("                   A.SKD_DIR_CD     AS SKD_DIR_CD    ," ).append("\n"); 
		query.append("                   A.SLS_OFC_CD     AS SLS_OFC_CD    ," ).append("\n"); 
		query.append("                   A.POL_CD         AS POL_CD        ," ).append("\n"); 
		query.append("                   A.SLS_AQ_CD      AS SLS_AQ_CD     ," ).append("\n"); 
		query.append("                   B.SLS_YRMON      AS SLS_YRMON     ," ).append("\n"); 
		query.append("                   B.COST_WK        AS COST_WK       ," ).append("\n"); 
		query.append("                   ROW_NUMBER() OVER ( PARTITION BY A.REP_TRD_CD, A.REP_SUB_TRD_CD, A.RLANE_CD, A.DIR_CD, A.IOC_TS_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.SLS_OFC_CD, B.COST_WK" ).append("\n"); 
		query.append("                                           ORDER BY A.REP_TRD_CD, A.REP_SUB_TRD_CD, A.RLANE_CD, A.DIR_CD, IOC_TS_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.SLS_OFC_CD, A.CD_DP_SEQ, A.SLS_AQ_CD, B.SLS_YRMON, B.COST_WK ) AS SEQ" ).append("\n"); 
		query.append("              FROM SPC_IRR_FCAST_OFC_POL_MAPG A," ).append("\n"); 
		query.append("                   COA_MON_VVD                B" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("             WHERE A.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("               AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("               AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("             WHERE A.REP_TRD_CD = @[trade]" ).append("\n"); 
		query.append("               AND A.SLS_RHQ_CD = @[rhq]" ).append("\n"); 
		query.append("      #if (${subtrade} != '') " ).append("\n"); 
		query.append("               AND A.REP_SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${lane} != '') " ).append("\n"); 
		query.append("               AND A.RLANE_CD = @[lane]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${bound} != '') " ).append("\n"); 
		query.append("               AND A.DIR_CD = @[bound]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${ocnipc} != '') " ).append("\n"); 
		query.append("               AND A.IOC_TS_CD = SUBSTR(@[ocnipc], 1, 1)" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               AND A.RLANE_CD   = B.RLANE_CD   (+)" ).append("\n"); 
		query.append("               AND A.TRD_CD     = B.TRD_CD     (+)" ).append("\n"); 
		query.append("               AND A.SUB_TRD_CD = B.SUB_TRD_CD (+)" ).append("\n"); 
		query.append("               AND A.VSL_CD     = B.VSL_CD     (+)" ).append("\n"); 
		query.append("               AND A.SKD_VOY_NO = B.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("               AND A.SKD_DIR_CD = B.DIR_CD     (+)" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("GROUP BY rep_trd_cd    ," ).append("\n"); 
		query.append("         rep_sub_trd_cd," ).append("\n"); 
		query.append("         rlane_cd      ," ).append("\n"); 
		query.append("         dir_cd        ," ).append("\n"); 
		query.append("         ioc_ts_cd     ," ).append("\n"); 
		query.append("         vsl_cd        ," ).append("\n"); 
		query.append("         skd_voy_no    ," ).append("\n"); 
		query.append("         skd_dir_cd    ," ).append("\n"); 
		query.append("         sls_ofc_cd    ," ).append("\n"); 
		query.append("         sls_aq_cd     ," ).append("\n"); 
		query.append("         sls_yrmon     ," ).append("\n"); 
		query.append("         cost_wk" ).append("\n"); 
		query.append("ORDER BY rep_trd_cd    ," ).append("\n"); 
		query.append("         rep_sub_trd_cd," ).append("\n"); 
		query.append("         rlane_cd      ," ).append("\n"); 
		query.append("         dir_cd        ," ).append("\n"); 
		query.append("         ioc_ts_cd     ," ).append("\n"); 
		query.append("         vsl_cd        ," ).append("\n"); 
		query.append("         skd_voy_no    ," ).append("\n"); 
		query.append("         skd_dir_cd    ," ).append("\n"); 
		query.append("         sls_yrmon     ," ).append("\n"); 
		query.append("         cost_wk       ," ).append("\n"); 
		query.append("         sls_aq_cd     ," ).append("\n"); 
		query.append("         sls_ofc_cd" ).append("\n"); 

	}
}