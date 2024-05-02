/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AsiaInlandCostManageDBDAOSearchInlandCostTariffInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaInlandCostManageDBDAOSearchInlandCostTariffInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInlandCostTariffInfo
	  * 
	  * * History
	  * 2013.01.14 이혜민 CHM-201322300 [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
	  * </pre>
	  */
	public AsiaInlandCostManageDBDAOSearchInlandCostTariffInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration").append("\n"); 
		query.append("FileName : AsiaInlandCostManageDBDAOSearchInlandCostTariffInfoRSQL").append("\n"); 
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
		query.append("SELECT  A.IO_BND_CD" ).append("\n"); 
		query.append("      , DECODE(A.IO_BND_CD, 'I', 'In', 'Out') IO_BND_NM" ).append("\n"); 
		query.append("      , A.COST_TRF_STS_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03051', A.COST_TRF_STS_CD) COST_TRF_STS_NM" ).append("\n"); 
		query.append("      , TO_CHAR(A.EFF_FM_DT, 'YYYY-MM-DD') EFF_FM_DT" ).append("\n"); 
		query.append("      , TO_CHAR(A.LOCL_UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("      , ( SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID ) UPD_USR_ID" ).append("\n"); 
		query.append("      , ( SELECT DECODE(GUI_FLG, 'Y', 'Y', 'N', DECODE(TAR_FLG, 'Y', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                 SELECT" ).append("\n"); 
		query.append("                         (--Inland Cost의 Tariff No.가 가장 최신인지 여부 확인" ).append("\n"); 
		query.append("                           SELECT  CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("                           FROM    AOC_CHN_INLND_TRF_HDR" ).append("\n"); 
		query.append("                           WHERE   CNT_CD = SUBSTR(@[in_cost_trf_no], 1, 2)" ).append("\n"); 
		query.append("                           AND     IO_BND_CD = SUBSTR(@[in_cost_trf_no], 9, 1)" ).append("\n"); 
		query.append("                           AND     COST_TRF_NO > @[in_cost_trf_no] " ).append("\n"); 
		query.append("                         ) AS TAR_FLG" ).append("\n"); 
		query.append("                       , (--Inland Cost의 Guideline 존재 여부 확인" ).append("\n"); 
		query.append("                           SELECT  CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("                           FROM    PRI_TRF_IHC_HDR" ).append("\n"); 
		query.append("                           WHERE   1 = 1" ).append("\n"); 
		query.append("                           AND     COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("                         ) AS GUI_FLG" ).append("\n"); 
		query.append("                 FROM    DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        ) NEXT_TRF_FLG" ).append("\n"); 
		query.append("      , A.COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("          SELECT  COUNT(1)" ).append("\n"); 
		query.append("          FROM    AOC_CHN_INLND_TRF_DTL" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     COST_TRF_NO = A.COST_TRF_NO" ).append("\n"); 
		query.append("          AND     TRSP_40FT_COST_SYS_SRC_CD <> 'A'" ).append("\n"); 
		query.append("          AND     COST_SEL_ROUT_FLG = 'Y'" ).append("\n"); 
		query.append("          AND     DELT_FLG = 'N'" ).append("\n"); 
		query.append("        ) AVG_CNT" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("          SELECT  CNTR_40FT_CRTE_WGT" ).append("\n"); 
		query.append("          FROM    AOC_TRF_BAT" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     COST_TRF_BAT_SEQ = A.COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append("        ) CNTR_40FT_CRTE_WGT" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("          SELECT  CNTR_20FT_CRTE_WGT" ).append("\n"); 
		query.append("          FROM    AOC_TRF_BAT" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     COST_TRF_BAT_SEQ = A.COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append("        ) CNTR_20FT_CRTE_WGT " ).append("\n"); 
		query.append("FROM    AOC_CHN_INLND_TRF_HDR A" ).append("\n"); 
		query.append("WHERE   A.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 

	}
}