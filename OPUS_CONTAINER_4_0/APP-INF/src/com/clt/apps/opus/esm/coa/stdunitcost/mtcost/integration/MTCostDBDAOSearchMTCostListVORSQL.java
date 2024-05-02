/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTCostDBDAOSearchMTCostListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.13 박수훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
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
	  *    COA_MTY_ECC_UT_COST , COA_MTY_CNTR_ROUT_PERF  테이블의 데이터 조회
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
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
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
		query.append("SELECT A1.COST_YRMON" ).append("\n"); 
		query.append(",A1.ECC_CD" ).append("\n"); 
		query.append(",NVL(A1.CNTR_IO_VOL_STS_CD, 'X') CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append(",COA_GET_CD_NM_FNC ('CD00849', NVL(A1.CNTR_IO_VOL_STS_CD, 'X')) EQ_STATUS" ).append("\n"); 
		query.append(",A1.IMBAL_RTO * 100 IMBAL_RTO" ).append("\n"); 
		query.append(",DECODE(A1.CNTR_ORG_DEST_CD, 'O', 'Origin(from)', 'Dest(to)') ORI_DEST_CD" ).append("\n"); 
		query.append(",A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A1.SIM_CNTR_QTY VOL" ).append("\n"); 
		query.append(",A1.SIM_STVG_UC_AMT" ).append("\n"); 
		query.append(",SUM(ROUND(A2.MTY_STVG_TTL_AMT, 2)) CALCU_STEVE" ).append("\n"); 
		query.append(",A1.SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append(",SUM(ROUND(A2.MTY_TRSP_TTL_AMT, 2)) CALCU_TRANS" ).append("\n"); 
		query.append(",ROUND(A1.SIM_TZ_DYS, 2) MTY_TZ_HRS" ).append("\n"); 
		query.append(",SUM(A2.TTL_TZ_DYS) CALCU_DAYS" ).append("\n"); 
		query.append("FROM COA_MTY_ECC_UT_COST A1, COA_MTY_CNTR_ROUT_PERF A2" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A1.COST_LOC_GRP_CD = 'E'" ).append("\n"); 
		query.append("AND A1.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append("AND A1.ECC_CD = DECODE(A1.CNTR_ORG_DEST_CD, 'O', A2.ROUT_N1ST_ECC_CD, A2.ROUT_LST_ECC_CD)" ).append("\n"); 
		query.append("AND A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A1.CNTR_ORG_DEST_CD = A2.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("AND A2.ROUT_N1ST_ECC_CD <> A2.ROUT_LST_ECC_CD /*동일 ECC MVMT 제외한 것이 Simulated Cost*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND A1.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ecc_cd} != '')" ).append("\n"); 
		query.append("AND A1.ECC_CD = @[f_ecc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A1.COST_YRMON" ).append("\n"); 
		query.append(",A1.ECC_CD" ).append("\n"); 
		query.append(",A1.CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append(",A1.IMBAL_RTO" ).append("\n"); 
		query.append(",A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append(",A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A1.SIM_CNTR_QTY" ).append("\n"); 
		query.append(",A1.SIM_STVG_UC_AMT" ).append("\n"); 
		query.append(",A1.SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append(",ROUND(A1.SIM_TZ_DYS, 2)" ).append("\n"); 
		query.append("ORDER BY A1.ECC_CD" ).append("\n"); 
		query.append(",A1.CNTR_IO_VOL_STS_CD DESC" ).append("\n"); 
		query.append(",A1.IMBAL_RTO" ).append("\n"); 
		query.append(",A1.CNTR_ORG_DEST_CD DESC" ).append("\n"); 
		query.append(",A1.CNTR_TPSZ_CD" ).append("\n"); 

	}
}