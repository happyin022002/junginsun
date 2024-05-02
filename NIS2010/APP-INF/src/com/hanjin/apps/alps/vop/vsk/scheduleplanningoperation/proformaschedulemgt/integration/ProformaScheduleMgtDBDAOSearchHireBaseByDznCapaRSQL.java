/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchHireBaseByDznCapaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2010.01.27 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchHireBaseByDznCapaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchHireBaseByDznCapa
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchHireBaseByDznCapaRSQL(){
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
		params.put("vsl_csl1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_csl2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_csl3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_ownr_flg_y",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_wrk_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_ownr_flg_n",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchHireBaseByDznCapaRSQL").append("\n"); 
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
		query.append("SELECT  '' AS VSL_OWNR_FLG, TO_NUMBER(@[vsl_csl1]) AS VSL_CSL1, TO_NUMBER(@[vsl_csl2]) AS VSL_CSL2,  TO_NUMBER(@[vsl_csl3]) AS VSL_CSL3 FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT @[vsl_ownr_flg_y]" ).append("\n"); 
		query.append(", NVL( ROUND(AVG(DECODE(T2.CNTR_VSL_CLSS_CAPA, @[vsl_csl1], T1.DHIR_AMT / T2.CNTR_VSL_CLSS_CAPA)), 2), 0 ) AS DAILY_HIRE_BY_CLASS01" ).append("\n"); 
		query.append(", NVL( ROUND(AVG(DECODE(T2.CNTR_VSL_CLSS_CAPA, @[vsl_csl2], T1.DHIR_AMT / T2.CNTR_VSL_CLSS_CAPA)), 2), 0 ) AS DAILY_HIRE_BY_CLASS02" ).append("\n"); 
		query.append(", NVL( ROUND(AVG(DECODE(T2.CNTR_VSL_CLSS_CAPA, @[vsl_csl3], T1.DHIR_AMT / T2.CNTR_VSL_CLSS_CAPA)), 2), 0 ) AS DAILY_HIRE_BY_CLASS03" ).append("\n"); 
		query.append("FROM    VSK_DLY_HIR T1, MDM_VSL_CNTR T2" ).append("\n"); 
		query.append("WHERE   1   = 1" ).append("\n"); 
		query.append("AND     T1.VSL_CD   = T2.VSL_CD" ).append("\n"); 
		query.append("AND     PLN_YR      = @[slt_prc_wrk_yr]" ).append("\n"); 
		query.append("AND     T2.CNTR_DZN_CAPA IN (@[vsl_csl1], @[vsl_csl2], @[vsl_csl3])" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  @[vsl_ownr_flg_n]" ).append("\n"); 
		query.append(", NVL( MAX( ROUND ( DECODE( T3.CNTR_VSL_CLSS_CAPA, @[vsl_csl1], (NVL(T2.HIR_RT_N1ST_AMT, 0) + (NVL(T2.HIR_RT_N2ND_AMT, 0) / T4.USD_LOCL_XCH_RT)) / TO_NUMBER(@[vsl_csl1]) ), 2)), 0) AS CLASS01" ).append("\n"); 
		query.append(", NVL( MAX( ROUND ( DECODE( T3.CNTR_VSL_CLSS_CAPA, @[vsl_csl2], (NVL(T2.HIR_RT_N1ST_AMT, 0) + (NVL(T2.HIR_RT_N2ND_AMT, 0) / T4.USD_LOCL_XCH_RT)) / TO_NUMBER(@[vsl_csl2]) ), 2)), 0) AS CLASS02" ).append("\n"); 
		query.append(", NVL( MAX( ROUND ( DECODE( T3.CNTR_VSL_CLSS_CAPA, @[vsl_csl3], (NVL(T2.HIR_RT_N1ST_AMT, 0) + (NVL(T2.HIR_RT_N2ND_AMT, 0) / T4.USD_LOCL_XCH_RT)) / TO_NUMBER(@[vsl_csl3]) ), 2)), 0) AS CLASS03" ).append("\n"); 
		query.append("FROM    FMS_CONTRACT T1, FMS_HIRE T2, MDM_VSL_CNTR T3, GL_MON_XCH_RT T4" ).append("\n"); 
		query.append("WHERE   T1.FLET_CTRT_NO      = T2.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("AND     SYSDATE     BETWEEN T2.EFF_DT   AND T2.EXP_DT + 0.99999" ).append("\n"); 
		query.append("AND     T1.DELT_FLG          = 'N'" ).append("\n"); 
		query.append("AND     T4.ACCT_XCH_RT_YRMON = (@[slt_prc_wrk_yr]|| CASE WHEN @[bse_qtr_cd] = '1Q' THEN '01' WHEN @[bse_qtr_cd] = '2Q' THEN '04' WHEN @[bse_qtr_cd] = '3Q' THEN '07' ELSE '10' END)" ).append("\n"); 
		query.append("AND     T4.ACCT_XCH_RT_LVL   = 1" ).append("\n"); 
		query.append("AND     T4.CURR_CD           = NVL(T2.HIR_CURR_N2ND_CD, 'USD')" ).append("\n"); 
		query.append("AND     T1.VSL_CD            = T3.VSL_CD" ).append("\n"); 
		query.append("AND     T3.CNTR_DZN_CAPA IN (@[vsl_csl1], @[vsl_csl2], @[vsl_csl3])" ).append("\n"); 

	}
}