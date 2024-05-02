/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AdjustmentDBDAOCreateKpiCreationEditNewLaneTgtVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOCreateKpiCreationEditNewLaneTgtVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateKpiCreationEditNewLaneTgtVvd
	  * 
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public AdjustmentDBDAOCreateKpiCreationEditNewLaneTgtVvdCSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOCreateKpiCreationEditNewLaneTgtVvdCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SPCL_TGT_VVD(" ).append("\n"); 
		query.append("        BSE_TP_CD" ).append("\n"); 
		query.append("        ,BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,BSE_MON" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,IOC_CD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       @[f_bse_tp_cd] AS BSE_TP_CD" ).append("\n"); 
		query.append("      ,@[f_bse_yr] AS BSE_YR" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q') --분기일때는 그대로" ).append("\n"); 
		query.append("      ,@[f_bse_qtr_cd] AS BSE_QTR_CD" ).append("\n"); 
		query.append("#elseif(${f_bse_tp_cd} == 'Y') -- 연간일때는 주차로 구분" ).append("\n"); 
		query.append("      ,CASE WHEN COST_WK BETWEEN '0'  AND '13' THEN '1Q'" ).append("\n"); 
		query.append("            WHEN COST_WK BETWEEN '14' AND '26' THEN '2Q'" ).append("\n"); 
		query.append("            WHEN COST_WK BETWEEN '27' AND '39' THEN '3Q'" ).append("\n"); 
		query.append("            WHEN COST_WK BETWEEN '40' AND '53' THEN '4Q'" ).append("\n"); 
		query.append("       END BSE_QTR_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(A1.SLS_YRMON, 5,2) AS BSE_MON" ).append("\n"); 
		query.append("      ,A1.COST_WK AS BSE_WK" ).append("\n"); 
		query.append("      ,NVL((SELECT CONV_DIR_CD" ).append("\n"); 
		query.append("              FROM SQM_DIR_CONV" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("               AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("               AND BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("               AND TRD_CD     = A1.TRD_CD" ).append("\n"); 
		query.append("               AND RLANE_CD   = A1.RLANE_CD" ).append("\n"); 
		query.append("               AND DIR_CD     = A1.DIR_CD" ).append("\n"); 
		query.append("            ), DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.IOC_CD" ).append("\n"); 
		query.append("      ,NVL(A1.VVD_BSA_CAPA,0) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE   AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE   AS  UPD_DT" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD A1" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND DELT_FLG   = 'N'" ).append("\n"); 
		query.append("   AND TRD_CD     = @[f_trd_cd]         -- NEW TRADE" ).append("\n"); 
		query.append("   AND RLANE_CD   = @[f_rlane_cd]       -- NEW LANE" ).append("\n"); 
		query.append("   AND SLS_YRMON  LIKE @[f_bse_yr]||'%' -- 연간일때" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("   #if (${f_bse_qtr_cd} == '1Q')" ).append("\n"); 
		query.append("   AND COST_WK    BETWEEN '00' AND '13'" ).append("\n"); 
		query.append("   #elseif (${f_bse_qtr_cd} == '2Q')" ).append("\n"); 
		query.append("   AND COST_WK    BETWEEN '14' AND '26'" ).append("\n"); 
		query.append("   #elseif (${f_bse_qtr_cd} == '3Q')" ).append("\n"); 
		query.append("   AND COST_WK    BETWEEN '27' AND '39'" ).append("\n"); 
		query.append("   #elseif (${f_bse_qtr_cd} == '4Q')" ).append("\n"); 
		query.append("   AND COST_WK    BETWEEN '40' AND '53'" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}