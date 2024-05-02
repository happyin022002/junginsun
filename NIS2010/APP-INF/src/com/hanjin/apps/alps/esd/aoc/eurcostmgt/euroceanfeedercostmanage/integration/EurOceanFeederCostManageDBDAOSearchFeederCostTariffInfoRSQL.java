/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurOceanFeederCostManageDBDAOSearchFeederCostTariffInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurOceanFeederCostManageDBDAOSearchFeederCostTariffInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFeederCostTariffInfo
	  * 
	  * * History
	  * 2013.01.14 이혜민 CHM-201322300 [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
	  * 2015.02.03 전지예 CHM-201533794 [AOC] 45' Cost 추가
	  * </pre>
	  */
	public EurOceanFeederCostManageDBDAOSearchFeederCostTariffInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration").append("\n"); 
		query.append("FileName : EurOceanFeederCostManageDBDAOSearchFeederCostTariffInfoRSQL").append("\n"); 
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
		query.append("SELECT  A.COST_TRF_STS_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03051', A.COST_TRF_STS_CD) COST_TRF_STS_NM" ).append("\n"); 
		query.append("      , ( SELECT  CURR_CD" ).append("\n"); 
		query.append("          FROM    AOC_EUR_FDR_TRF_DTL D" ).append("\n"); 
		query.append("          WHERE   D.COST_TRF_NO = A.COST_TRF_NO" ).append("\n"); 
		query.append("          AND     ROWNUM <= 1" ).append("\n"); 
		query.append("        ) CURR_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.EFF_FM_DT, 'YYYY-MM-DD') EFF_FM_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(A.LOCL_UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("       ,(SELECT USR_NM FROM COM_USER" ).append("\n"); 
		query.append("          WHERE USR_ID = A.UPD_USR_ID ) UPD_USR_ID" ).append("\n"); 
		query.append("       ,(SELECT DECODE(GUI_FLG, 'Y', 'Y', 'N', DECODE(TAR_FLG, 'Y', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("         SELECT" ).append("\n"); 
		query.append("           (--Ocean Cost의 Tariff No.가 가장 최신인지 여부 확인" ).append("\n"); 
		query.append("            SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("              FROM AOC_EUR_FDR_TRF_HDR" ).append("\n"); 
		query.append("             WHERE RHQ_CD = AOC_TRF_CALC_PKG.GET_RHQ_OFC_CD(@[in_ofc_cd])" ).append("\n"); 
		query.append("               AND COST_TRF_NO > @[in_cost_trf_no]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           AS TAR_FLG," ).append("\n"); 
		query.append("           (--Ocean Feeder Cost의 Guideline 존재 여부 확인" ).append("\n"); 
		query.append("            SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("              FROM PRI_TRF_FDR_COST_VER_MAPG" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND FDR_COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           AS GUI_FLG" ).append("\n"); 
		query.append("        FROM DUAL)) NEXT_TRF_FLG             " ).append("\n"); 
		query.append("       ,A.RHQ_CD" ).append("\n"); 
		query.append("		, (-- 45' Cost 추가" ).append("\n"); 
		query.append("          SELECT  CNTR_45FT_CRTE_WGT" ).append("\n"); 
		query.append("          FROM    AOC_TRF_BAT" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     COST_TRF_BAT_SEQ = A.COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append("		) CNTR_45FT_CRTE_WGT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("          SELECT  CNTR_40FT_CRTE_WGT" ).append("\n"); 
		query.append("          FROM    AOC_TRF_BAT" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     COST_TRF_BAT_SEQ = A.COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append("         ) CNTR_40FT_CRTE_WGT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("          SELECT  CNTR_20FT_CRTE_WGT" ).append("\n"); 
		query.append("          FROM    AOC_TRF_BAT" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     COST_TRF_BAT_SEQ = A.COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append("         ) CNTR_20FT_CRTE_WGT" ).append("\n"); 
		query.append("  FROM AOC_EUR_FDR_TRF_HDR A" ).append("\n"); 
		query.append(" WHERE A.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 

	}
}