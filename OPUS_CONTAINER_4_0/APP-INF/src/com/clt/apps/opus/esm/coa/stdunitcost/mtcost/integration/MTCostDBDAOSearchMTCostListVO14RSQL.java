/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTCostDBDAOSearchMTCostListVO14RSQL.java
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

public class MTCostDBDAOSearchMTCostListVO14RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_FULL_ECC_IMBAL  테이블의 데이터 조회   
	  * </pre>
	  */
	public MTCostDBDAOSearchMTCostListVO14RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntr_io_vol_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_fcntr_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOSearchMTCostListVO14RSQL").append("\n"); 
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
		query.append(",FCNTR_ECC_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",EQ_STATUS" ).append("\n"); 
		query.append(", AVG(CNTR_IMBAL_RTO) * 100 CNTR_IMBAL_RTO" ).append("\n"); 
		query.append(",SUM(CNTR_IMBAL_QTY) CNTR_IMBAL_QTY" ).append("\n"); 
		query.append(",SUM(CNTR_IB_QTY) CNTR_IB_QTY" ).append("\n"); 
		query.append(",SUM(CNTR_OB_QTY) CNTR_OB_QTY" ).append("\n"); 
		query.append("FROM (SELECT COST_YRMON" ).append("\n"); 
		query.append(",FCNTR_ECC_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append(",COA_GET_CD_NM_FNC('CD00849', NVL(CNTR_IO_VOL_STS_CD, 'X')) EQ_STATUS" ).append("\n"); 
		query.append(",CNTR_IMBAL_RTO" ).append("\n"); 
		query.append(",CNTR_IMBAL_QTY" ).append("\n"); 
		query.append(",CNTR_IB_QTY" ).append("\n"); 
		query.append(",CNTR_OB_QTY" ).append("\n"); 
		query.append("FROM COA_FULL_ECC_IMBAL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND COST_LOC_GRP_CD = 'R'" ).append("\n"); 
		query.append("AND COST_YRMON = @[p_cost_yrmon]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = @[p_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_fcntr_ecc_cd} != '')" ).append("\n"); 
		query.append("AND FCNTR_ECC_CD = @[p_fcntr_ecc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_cntr_io_vol_sts_cd} != '')" ).append("\n"); 
		query.append("AND CNTR_IO_VOL_STS_CD = @[p_cntr_io_vol_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY COST_YRMON, FCNTR_ECC_CD, CNTR_TPSZ_CD, EQ_STATUS" ).append("\n"); 
		query.append("ORDER BY COST_YRMON, FCNTR_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 

	}
}