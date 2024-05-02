/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchPlAdjustmentVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchPlAdjustmentVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPlAdjustmentVVDList
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchPlAdjustmentVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sls_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchPlAdjustmentVVDListRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append("      ,SLS_YRMON" ).append("\n"); 
		query.append("      ,COST_WK" ).append("\n"); 
		query.append("      ,'' RHQ" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,IOC_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,HUL_BND_CD" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append("      ,SUM(DECODE(STND_COST_CD, '$key', NVL(AMT,0), 0)) AS COST_AMT$velocityCount" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,SUM(NVL(AMT,0)) AS TTL_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("               A.COST_YRMON" ).append("\n"); 
		query.append("              ,A.SLS_YRMON" ).append("\n"); 
		query.append("              ,A.COST_WK" ).append("\n"); 
		query.append("              ,A.TRD_CD" ).append("\n"); 
		query.append("              ,A.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,A.RLANE_CD" ).append("\n"); 
		query.append("              ,A.IOC_CD" ).append("\n"); 
		query.append("              ,A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,A.HUL_BND_CD" ).append("\n"); 
		query.append("              ,B.STND_COST_CD" ).append("\n"); 
		query.append("              ,SUM(NVL(DECODE(A.PL_DESC, 'Week', A.ESTM_PL_AMT, 'Month', A.ACCT_AMT), 0)) AS AMT" ).append("\n"); 
		query.append("         FROM MAS_PFIT_ADJ A, MAS_PFIT_LSS_RPT_ITM B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("          AND B.RPT_VW_CD = 'P'" ).append("\n"); 
		query.append("      #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("          AND A.REV_YRMON    BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("      #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("          AND A.SLS_YRMON     LIKE @[f_year]||@[f_sls_mon]||'%'" ).append("\n"); 
		query.append("          AND A.COST_WK       BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${f_trd_cd} !='')" ).append("\n"); 
		query.append("          AND A.TRD_CD    = @[f_trd_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("            AND A.RLANE_CD  = @[f_rlane_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD = @[f_dir_cd] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("          AND A.VSL_CD    = @[f_vsl_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${f_sub_trd_cd} !='')" ).append("\n"); 
		query.append("          AND A.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${f_trd_dir_cd} !='')" ).append("\n"); 
		query.append("          AND A.HUL_BND_CD = @[f_trd_dir_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("          AND (B.STND_COST_TP_CD IN ('S','C','O') OR B.STND_COST_CD IN ('OPCTOTAL','OPB00000','BOPTOTAL','BOPB0000'))" ).append("\n"); 
		query.append("     GROUP BY A.COST_YRMON" ).append("\n"); 
		query.append("             ,A.SLS_YRMON" ).append("\n"); 
		query.append("             ,A.COST_WK" ).append("\n"); 
		query.append("             ,A.TRD_CD" ).append("\n"); 
		query.append("             ,A.SUB_TRD_CD" ).append("\n"); 
		query.append("             ,A.RLANE_CD" ).append("\n"); 
		query.append("             ,A.IOC_CD" ).append("\n"); 
		query.append("             ,A.VSL_CD" ).append("\n"); 
		query.append("             ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("             ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("             ,A.HUL_BND_CD" ).append("\n"); 
		query.append("             ,B.STND_COST_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("GROUP BY COST_YRMON" ).append("\n"); 
		query.append("        ,SLS_YRMON" ).append("\n"); 
		query.append("        ,COST_WK" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,IOC_CD" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,HUL_BND_CD " ).append("\n"); 
		query.append("ORDER BY INSTR('CNTLY CDMCO CNTTS CNTMR', RLANE_CD)" ).append("\n"); 

	}
}