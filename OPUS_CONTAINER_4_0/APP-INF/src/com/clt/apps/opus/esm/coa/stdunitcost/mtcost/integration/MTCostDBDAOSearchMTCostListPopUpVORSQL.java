/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTCostDBDAOSearchMTCostListPopUpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.11.05 장영석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTCostDBDAOSearchMTCostListPopUpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _MTY_CNTR_ROUT_PERF, _CNTR_MTY_MVMT 테이블의 데이터 조회
	  * </pre>
	  */
	public MTCostDBDAOSearchMTCostListPopUpVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ori_dest",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_from_ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOSearchMTCostListPopUpVORSQL").append("\n"); 
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
		query.append("SELECT  ECC_CD" ).append("\n"); 
		query.append(",ORI_DEST" ).append("\n"); 
		query.append(",FRM_TO_ECC" ).append("\n"); 
		query.append(",FRM_TO_SEQ" ).append("\n"); 
		query.append(",FRM_YARD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",COUNT(*) MCNTR_QTY" ).append("\n"); 
		query.append(",SUM(STEVE_AMT) STEVE_TTL_AMT" ).append("\n"); 
		query.append(",SUM(TRANS_AMT) TRSP_TTL_AMT" ).append("\n"); 
		query.append(",SUM(STEVE_AMT) + SUM(TRANS_AMT) TOTAL_AMT" ).append("\n"); 
		query.append(",SUM(STEVE_AMT) / COUNT(*) STEVE_UNIT_COST" ).append("\n"); 
		query.append(",SUM(TRANS_AMT) / COUNT(*) TRSP_UNIT_COST" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT    A1.COST_YRMON" ).append("\n"); 
		query.append(",A2.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append(",A2.MON_MVMT_SEQ MVMT_SEQ" ).append("\n"); 
		query.append(",DECODE(DECODE(@[f_ori_dest],'1','D','O'), 'O', A1.ROUT_N1ST_ECC_CD, A1.ROUT_LST_ECC_CD) ECC_CD" ).append("\n"); 
		query.append(",DECODE(DECODE(@[f_ori_dest],'1','D','O'), 'O', 'origin based', 'dest based') ORI_DEST" ).append("\n"); 
		query.append(",A1.ROUT_N1ST_ECC_CD || '-' || A1.ROUT_LST_ECC_CD FRM_TO_ECC" ).append("\n"); 
		query.append(",A1.ROUT_N1ST_YD_CD || A1.ROUT_LST_YD_CD || '-' || A1.ROUT_SEQ FRM_TO_SEQ" ).append("\n"); 
		query.append(",A2.YD_CD FRM_YARD" ).append("\n"); 
		query.append(",A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A2.MTY_STVG_TTL_AMT STEVE_AMT" ).append("\n"); 
		query.append(",A2.MTY_TRSP_TTL_AMT TRANS_AMT" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY A1.COST_YRMON, A2.CNTR_NO, A2.CNTR_ROUT_SEQ, A1.ROUT_N1ST_YD_CD || A1.ROUT_LST_YD_CD || '-'" ).append("\n"); 
		query.append("|| A1.ROUT_SEQ ORDER BY A1.COST_YRMON" ).append("\n"); 
		query.append(",A1.ROUT_N1ST_YD_CD || A1.ROUT_LST_YD_CD || '-' || A1.ROUT_SEQ, A2.CNTR_NO, A2.MON_MVMT_SEQ) ROW_NUM_PART_BY" ).append("\n"); 
		query.append("FROM    COA_MTY_CNTR_ROUT_PERF A1" ).append("\n"); 
		query.append(",COA_CNTR_MTY_MVMT A2" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND    A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append("AND    A1.ROUT_N1ST_YD_CD = A2.ROUT_N1ST_YD_CD" ).append("\n"); 
		query.append("AND    A1.ROUT_LST_YD_CD = A2.ROUT_LST_YD_CD" ).append("\n"); 
		query.append("AND    A1.ROUT_SEQ = A2.ROUT_SEQ" ).append("\n"); 
		query.append("AND    A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND    A1.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND    A1.ROUT_N1ST_ECC_CD = @[f_from_ecc]" ).append("\n"); 
		query.append("AND    A1.ROUT_LST_ECC_CD = @[f_to_ecc]" ).append("\n"); 
		query.append("AND    A1.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND    A1.CNTR_ORG_DEST_CD = (DECODE(@[f_ori_dest],'1','D','O'))" ).append("\n"); 
		query.append("ORDER BY A1.COST_YRMON, FRM_TO_SEQ, A2.CNTR_NO, A2.MON_MVMT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY COST_YRMON, ECC_CD, ORI_DEST, FRM_TO_ECC, FRM_TO_SEQ, FRM_YARD, CNTR_TPSZ_CD, ROW_NUM_PART_BY" ).append("\n"); 
		query.append("ORDER BY COST_YRMON, ECC_CD, ORI_DEST, FRM_TO_ECC, FRM_TO_SEQ, ROW_NUM_PART_BY" ).append("\n"); 

	}
}