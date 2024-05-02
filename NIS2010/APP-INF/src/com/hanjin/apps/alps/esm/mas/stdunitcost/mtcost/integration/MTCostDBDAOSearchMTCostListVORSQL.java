/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MTCostDBDAOSearchMTCostListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2014.09.03 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTCostDBDAOSearchMTCostListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    MAS_MTY_ECC_UT_COST , MAS_MTY_CNTR_ROUT_PERF  테이블의 데이터 조회
	  * [CHM-201324726] 2013년 2Q EMU 보완 4-5번 사항 : 
	  *  - Origin Sim U/C, Adjusted Sim U/C 항목 추가
	  * </pre>
	  */
	public MTCostDBDAOSearchMTCostListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOSearchMTCostListVORSQL").append("\n"); 
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
		query.append("     , ECC_CD" ).append("\n"); 
		query.append("     , CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("     , EQ_STATUS" ).append("\n"); 
		query.append("     , IMBAL_RTO" ).append("\n"); 
		query.append("     , ORI_DEST_CD" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , VOL" ).append("\n"); 
		query.append("     , ORG_SIM_STVG_UC_AMT" ).append("\n"); 
		query.append("     , CALCU_STEVE" ).append("\n"); 
		query.append("     , ORG_SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append("     , CALCU_TRANS" ).append("\n"); 
		query.append("     , SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append("     , ORG_SIM_TTL_UC_AMT" ).append("\n"); 
		query.append("     , SIM_TTL_UC_AMT" ).append("\n"); 
		query.append("     , MTY_TZ_HRS" ).append("\n"); 
		query.append("     , CALCU_DAYS" ).append("\n"); 
		query.append("     , MNL_RQST_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT A1.COST_YRMON" ).append("\n"); 
		query.append("          ,A1.ECC_CD" ).append("\n"); 
		query.append("          ,NVL(A1.CNTR_IO_VOL_STS_CD, 'X') CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("          ,MAS_GET_CD_NM_FNC ('CD00849', NVL(A1.CNTR_IO_VOL_STS_CD, 'X')) EQ_STATUS " ).append("\n"); 
		query.append("          ,A1.IMBAL_RTO * 100 IMBAL_RTO " ).append("\n"); 
		query.append("          ,DECODE(A1.CNTR_ORG_DEST_CD, 'O', 'Origin(from)', 'Dest(to)') ORI_DEST_CD" ).append("\n"); 
		query.append("          ,A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          ,A1.SIM_CNTR_QTY VOL				" ).append("\n"); 
		query.append("          ,NVL(A1.ORG_SIM_STVG_UC_AMT, DECODE(A1.IMBAL_RTO, 0, A1.SIM_STVG_UC_AMT, ROUND(MAX(A1.MTY_STVG_UC_AMT) / A1.IMBAL_RTO, 2))) ORG_SIM_STVG_UC_AMT" ).append("\n"); 
		query.append("          ,SUM(ROUND(A2.MTY_STVG_TTL_AMT, 2)) CALCU_STEVE				" ).append("\n"); 
		query.append("          ,NVL(A1.ORG_SIM_TRSP_UC_AMT, DECODE(A1.IMBAL_RTO, 0, A1.SIM_TRSP_UC_AMT, ROUND(MAX(A1.MTY_TRSP_UC_AMT) / A1.IMBAL_RTO, 2))) ORG_SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append("          ,SUM(ROUND(A2.MTY_TRSP_TTL_AMT, 2)) CALCU_TRANS				" ).append("\n"); 
		query.append("          ,A1.SIM_TRSP_UC_AMT 			" ).append("\n"); 
		query.append("          ,(  NVL(A1.ORG_SIM_STVG_UC_AMT, DECODE(A1.IMBAL_RTO, 0, A1.SIM_STVG_UC_AMT, ROUND(MAX(A1.MTY_STVG_UC_AMT) / A1.IMBAL_RTO, 2))) " ).append("\n"); 
		query.append("            + NVL(A1.ORG_SIM_TRSP_UC_AMT, DECODE(A1.IMBAL_RTO, 0, A1.SIM_TRSP_UC_AMT, ROUND(MAX(A1.MTY_TRSP_UC_AMT) / A1.IMBAL_RTO, 2)))) ORG_SIM_TTL_UC_AMT" ).append("\n"); 
		query.append("          ,(A1.SIM_STVG_UC_AMT + A1.SIM_TRSP_UC_AMT) SIM_TTL_UC_AMT" ).append("\n"); 
		query.append("          ,ROUND(A1.SIM_TZ_DYS, 2) MTY_TZ_HRS " ).append("\n"); 
		query.append("          ,SUM(A2.TTL_TZ_DYS) CALCU_DAYS" ).append("\n"); 
		query.append("          ,MAX(A1.MNL_RQST_FLG) AS MNL_RQST_FLG" ).append("\n"); 
		query.append("      FROM MAS_MTY_ECC_UT_COST A1, MAS_MTY_CNTR_ROUT_PERF A2" ).append("\n"); 
		query.append("     WHERE 1 = 1" ).append("\n"); 
		query.append("       AND A1.COST_LOC_GRP_CD = 'E'" ).append("\n"); 
		query.append("       AND A1.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("       AND A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append("       AND A1.ECC_CD = DECODE(A1.CNTR_ORG_DEST_CD, 'O', A2.ROUT_N1ST_ECC_CD, A2.ROUT_LST_ECC_CD)" ).append("\n"); 
		query.append("       AND A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       AND A1.CNTR_ORG_DEST_CD = A2.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("       AND A2.ROUT_N1ST_ECC_CD <> A2.ROUT_LST_ECC_CD /*동일 ECC MVMT 제외한 것이 Simulated Cost*/" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       #if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("       AND A1.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("       #if (${f_ecc_cd} != '') " ).append("\n"); 
		query.append("       AND A1.ECC_CD = @[f_ecc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    GROUP BY A1.COST_YRMON" ).append("\n"); 
		query.append("            ,A1.ECC_CD" ).append("\n"); 
		query.append("            ,A1.CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("            ,A1.IMBAL_RTO " ).append("\n"); 
		query.append("            ,A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("            ,A1.CNTR_TPSZ_CD	" ).append("\n"); 
		query.append("            ,A1.SIM_CNTR_QTY" ).append("\n"); 
		query.append("            ,A1.SIM_STVG_UC_AMT				" ).append("\n"); 
		query.append("            ,A1.SIM_TRSP_UC_AMT	" ).append("\n"); 
		query.append("            ,A1.ORG_SIM_STVG_UC_AMT	" ).append("\n"); 
		query.append("            ,A1.ORG_SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append("            ,ROUND(A1.SIM_TZ_DYS, 2)	" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     /* USHOF 가상 ECC 용 조회  */" ).append("\n"); 
		query.append("    SELECT A1.COST_YRMON" ).append("\n"); 
		query.append("          ,A1.ECC_CD" ).append("\n"); 
		query.append("          ,NVL(A1.CNTR_IO_VOL_STS_CD, 'X') CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("          ,MAS_GET_CD_NM_FNC ('CD00849', NVL(A1.CNTR_IO_VOL_STS_CD, 'X')) EQ_STATUS " ).append("\n"); 
		query.append("          ,A1.IMBAL_RTO * 100 IMBAL_RTO " ).append("\n"); 
		query.append("          ,DECODE(A1.CNTR_ORG_DEST_CD, 'O', 'Origin(from)', 'Dest(to)') ORI_DEST_CD" ).append("\n"); 
		query.append("          ,A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          ,A1.SIM_CNTR_QTY VOL				" ).append("\n"); 
		query.append("          ,NVL(A1.ORG_SIM_STVG_UC_AMT, DECODE(A1.IMBAL_RTO, 0, A1.SIM_STVG_UC_AMT, ROUND(MAX(A1.MTY_STVG_UC_AMT) / A1.IMBAL_RTO, 2))) ORG_SIM_STVG_UC_AMT" ).append("\n"); 
		query.append("          ,NULL CALCU_STEVE				" ).append("\n"); 
		query.append("          ,NVL(A1.ORG_SIM_TRSP_UC_AMT, DECODE(A1.IMBAL_RTO, 0, A1.SIM_TRSP_UC_AMT, ROUND(MAX(A1.MTY_TRSP_UC_AMT) / A1.IMBAL_RTO, 2))) ORG_SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append("          ,NULL CALCU_TRANS				" ).append("\n"); 
		query.append("          ,A1.SIM_TRSP_UC_AMT 			" ).append("\n"); 
		query.append("          ,(  NVL(A1.ORG_SIM_STVG_UC_AMT, DECODE(A1.IMBAL_RTO, 0, A1.SIM_STVG_UC_AMT, ROUND(MAX(A1.MTY_STVG_UC_AMT) / A1.IMBAL_RTO, 2))) " ).append("\n"); 
		query.append("            + NVL(A1.ORG_SIM_TRSP_UC_AMT, DECODE(A1.IMBAL_RTO, 0, A1.SIM_TRSP_UC_AMT, ROUND(MAX(A1.MTY_TRSP_UC_AMT) / A1.IMBAL_RTO, 2)))) ORG_SIM_TTL_UC_AMT" ).append("\n"); 
		query.append("          ,(A1.SIM_STVG_UC_AMT + A1.SIM_TRSP_UC_AMT) SIM_TTL_UC_AMT" ).append("\n"); 
		query.append("          ,ROUND(A1.SIM_TZ_DYS, 2) MTY_TZ_HRS " ).append("\n"); 
		query.append("          ,NULL  CALCU_DAYS" ).append("\n"); 
		query.append("          ,MAX(A1.MNL_RQST_FLG) AS MNL_RQST_FLG" ).append("\n"); 
		query.append("      FROM MAS_MTY_ECC_UT_COST A1" ).append("\n"); 
		query.append("     WHERE 1 = 1" ).append("\n"); 
		query.append("       AND A1.COST_LOC_GRP_CD = 'E'" ).append("\n"); 
		query.append("       AND A1.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("       #if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("       AND A1.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("       #if (${f_ecc_cd} == 'USHOF' || ${f_ecc_cd} == '') " ).append("\n"); 
		query.append("       AND A1.ECC_CD = 'USHOF'" ).append("\n"); 
		query.append("       #else " ).append("\n"); 
		query.append("       AND A1.ECC_CD = 'XXXXX'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    GROUP BY A1.COST_YRMON" ).append("\n"); 
		query.append("            ,A1.ECC_CD" ).append("\n"); 
		query.append("            ,A1.CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("            ,A1.IMBAL_RTO " ).append("\n"); 
		query.append("            ,A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("            ,A1.CNTR_TPSZ_CD	" ).append("\n"); 
		query.append("            ,A1.SIM_CNTR_QTY" ).append("\n"); 
		query.append("            ,A1.SIM_STVG_UC_AMT				" ).append("\n"); 
		query.append("            ,A1.SIM_TRSP_UC_AMT	" ).append("\n"); 
		query.append("            ,A1.ORG_SIM_STVG_UC_AMT	" ).append("\n"); 
		query.append("            ,A1.ORG_SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append("            ,ROUND(A1.SIM_TZ_DYS, 2)			" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("    )            	 				" ).append("\n"); 
		query.append("ORDER BY ECC_CD" ).append("\n"); 
		query.append("        ,CNTR_IO_VOL_STS_CD DESC" ).append("\n"); 
		query.append("        ,IMBAL_RTO" ).append("\n"); 
		query.append("        ,ORI_DEST_CD DESC" ).append("\n"); 
		query.append("        ,CNTR_TPSZ_CD" ).append("\n"); 

	}
}