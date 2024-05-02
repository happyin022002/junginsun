/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BasicDataDBDAOSearchTargerVvdFixListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchTargerVvdFixListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target VVD List를 조회
	  * 
	  * 2016.04.20 CHM-201640366 Target VVD Fix 월기준 항차 생성 등 개선 CSR
	  * 2016.05.24 김용습 mas에서 vvd가져올때 연도는 sls_yrmon, 월은 cost_yrmon 기준
	  * </pre>
	  */
	public BasicDataDBDAOSearchTargerVvdFixListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchTargerVvdFixListRSQL").append("\n"); 
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
		query.append("SELECT S.BSE_YR" ).append("\n"); 
		query.append("      ,S.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,S.TRD_CD" ).append("\n"); 
		query.append("      ,S.RLANE_CD" ).append("\n"); 
		query.append("      ,S.DIR_CD" ).append("\n"); 
		query.append("      ,S.VSL_CD||S.SKD_VOY_NO||S.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,S.VSL_CD" ).append("\n"); 
		query.append("      ,S.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,S.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,S.BSE_MON" ).append("\n"); 
		query.append("      ,S.BSE_WK" ).append("\n"); 
		query.append("      ,S.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,S.IOC_CD" ).append("\n"); 
		query.append("      ,S.FNL_BSA_CAPA  " ).append("\n"); 
		query.append("	  ,S.DELT_FLG --SQM QTA DATA DELETE FLAG" ).append("\n"); 
		query.append("      ,SUBSTR(M.SLS_YRMON,1,4) COST_YR" ).append("\n"); 
		query.append("	  ,SUBSTR(M.COST_YRMON,5) COST_MON" ).append("\n"); 
		query.append("      ,M.COST_WK" ).append("\n"); 
		query.append("      ,NVL(M.VVD_BSA_CAPA,0) VVD_BSA_CAPA" ).append("\n"); 
		query.append("      ,M.DELT_FLG M_DELT_FLG --MAS DELETE FLAG" ).append("\n"); 
		query.append("      ,DECODE(S.BSE_YR,SUBSTR(M.SLS_YRMON,1,4),'E','D') YEAR_DIF --D:DIFF , E:EQU" ).append("\n"); 
		query.append("      ,DECODE(S.BSE_MON,SUBSTR(M.COST_YRMON,5),'E','D') MON_DIF --D:DIFF , E:EQU" ).append("\n"); 
		query.append("      ,DECODE(S.BSE_WK,M.COST_WK,'E','D') WK_DIF --D:DIFF , E:EQU" ).append("\n"); 
		query.append("      ,DECODE(S.FNL_BSA_CAPA,NVL(M.VVD_BSA_CAPA,0),'E','D') BSA_DIF --D:DIFF , E:EQU" ).append("\n"); 
		query.append("      ,CASE WHEN M.DELT_FLG ='Y' AND S.DELT_FLG = 'Y' THEN 'BD'" ).append("\n"); 
		query.append("        WHEN M.DELT_FLG = 'Y' THEN 'MD'" ).append("\n"); 
		query.append("        WHEN S.DELT_FLG = 'Y' THEN 'SD'" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            'N'" ).append("\n"); 
		query.append("      END      " ).append("\n"); 
		query.append("      DELT_dif --MD:MAS DELETE, SD:SQM DELETE, BD:BOTH DELETE, N:NO DEL" ).append("\n"); 
		query.append(" FROM SQM_QTA_TGT_VVD S" ).append("\n"); 
		query.append(", MAS_MON_VVD M" ).append("\n"); 
		query.append("WHERE S.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND S.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("  AND S.BSE_QTR_CD = '00'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND S.BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("  AND S.TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("  AND S.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("  AND S.SUB_TRD_CD     = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("  AND S.RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND M.TRD_CD = S.TRD_CD(+)" ).append("\n"); 
		query.append("AND M.RLANE_CD = S.RLANE_CD(+)" ).append("\n"); 
		query.append("AND M.VSL_CD = S.VSL_CD(+)" ).append("\n"); 
		query.append("AND M.SKD_VOY_NO = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND M.DIR_CD = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("      	,DIR_CD" ).append("\n"); 
		query.append("      	,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,BSE_MON" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 

	}
}