/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTCostDBDAOSearchMTCostListVO3RSQL.java
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

public class MTCostDBDAOSearchMTCostListVO3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_MTY_CNTR_ROUT_PERF 테이블의 데이터 조회   
	  * </pre>
	  */
	public MTCostDBDAOSearchMTCostListVO3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ecc_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOSearchMTCostListVO3RSQL").append("\n"); 
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
		query.append(",A1.FROM_ECC" ).append("\n"); 
		query.append(",A1.TO_ECC" ).append("\n"); 
		query.append(",A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A1.VOL" ).append("\n"); 
		query.append(",A1.CALCU_STEVE CONTI_STEVE" ).append("\n"); 
		query.append(",A1.CALCU_TRANS CONTI_TRANS" ).append("\n"); 
		query.append(",A1.CALCU_DAYS  CONTI_DAYS" ).append("\n"); 
		query.append(",A2.CALCU_STEVE MVMT_STEVE" ).append("\n"); 
		query.append(",A2.CALCU_TRANS MVMT_TRANS" ).append("\n"); 
		query.append(",A2.CALCU_DAYS  MVMT_DAYS" ).append("\n"); 
		query.append("FROM (SELECT COST_YRMON" ).append("\n"); 
		query.append(",ROUT_N1ST_ECC_CD FROM_ECC" ).append("\n"); 
		query.append(",ROUT_LST_ECC_CD TO_ECC" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",SUM (TTL_CNTR_QTY) VOL" ).append("\n"); 
		query.append(",SUM (MTY_STVG_TTL_AMT) CALCU_STEVE" ).append("\n"); 
		query.append(",SUM (MTY_TRSP_TTL_AMT) CALCU_TRANS" ).append("\n"); 
		query.append(",SUM (TTL_TZ_DYS) CALCU_DAYS" ).append("\n"); 
		query.append("FROM COA_MTY_CNTR_ROUT_PERF" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND ROUT_N1ST_ECC_CD <> ROUT_LST_ECC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd2} != '')" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = @[f_cntr_tpsz_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ori_dest} != ''&& ${f_ori_dest}==1)" ).append("\n"); 
		query.append("AND CNTR_ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("#elseif (${f_ori_dest} != ''&& ${f_ori_dest}!=1)" ).append("\n"); 
		query.append("AND CNTR_ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ecc_cd2} != '')" ).append("\n"); 
		query.append("#if (${f_ori_dest} == 1)" ).append("\n"); 
		query.append("AND ROUT_LST_ECC_CD = @[f_ecc_cd2] /*destin, conti로 나눈 값 가져올 때*/" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ROUT_N1ST_ECC_CD = @[f_ecc_cd2] /*origin, conti로 나눈 값 가져올 때*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY COST_YRMON" ).append("\n"); 
		query.append(",ROUT_N1ST_ECC_CD" ).append("\n"); 
		query.append(",ROUT_LST_ECC_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD) A1" ).append("\n"); 
		query.append(",(SELECT COST_YRMON" ).append("\n"); 
		query.append(",ROUT_N1ST_ECC_CD FROM_ECC" ).append("\n"); 
		query.append(",ROUT_LST_ECC_CD TO_ECC" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",SUM (TTL_CNTR_QTY) VOL" ).append("\n"); 
		query.append(",SUM (MTY_STVG_TTL_AMT) CALCU_STEVE" ).append("\n"); 
		query.append(",SUM (MTY_TRSP_TTL_AMT) CALCU_TRANS" ).append("\n"); 
		query.append(",SUM (TTL_TZ_DYS) CALCU_DAYS" ).append("\n"); 
		query.append("FROM COA_MTY_CNTR_ROUT_PERF" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND ROUT_N1ST_ECC_CD <> ROUT_LST_ECC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd2} != '')" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = @[f_cntr_tpsz_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ecc_cd2} != '')" ).append("\n"); 
		query.append("#if (${f_ori_dest} == 1)" ).append("\n"); 
		query.append("AND ROUT_LST_ECC_CD = @[f_ecc_cd2] /* destin, MVMT에 있는 모든 값 가져올 때 */" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ROUT_N1ST_ECC_CD = @[f_ecc_cd2] /* origin, MVMT에 있는 모든 값 가져올 때 */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY COST_YRMON" ).append("\n"); 
		query.append(",ROUT_N1ST_ECC_CD" ).append("\n"); 
		query.append(",ROUT_LST_ECC_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD) A2" ).append("\n"); 
		query.append("WHERE A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append("AND A1.FROM_ECC = A2.FROM_ECC" ).append("\n"); 
		query.append("AND A1.TO_ECC = A2.TO_ECC" ).append("\n"); 
		query.append("AND A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 

	}
}