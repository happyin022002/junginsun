/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MTCostDBDAOSearchMTCost2ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.07.12 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTCostDBDAOSearchMTCost2ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_FULL_ECC_IMBAL 테이블의 데이터 조회 - 품질향상
	  * </pre>
	  */
	public MTCostDBDAOSearchMTCost2ListVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_ori_dest",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOSearchMTCost2ListVORSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON                             " ).append("\n"); 
		query.append("      ,FCNTR_ECC_CD                             " ).append("\n"); 
		query.append("      ,@[p_ori_dest] ORI_DEST_CD                             " ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD                            " ).append("\n"); 
		query.append("      ,EQ_STATUS                            " ).append("\n"); 
		query.append("      ,AVG(CNTR_IMBAL_RTO) * 100 CNTR_IMBAL_RTO                             " ).append("\n"); 
		query.append("      ,SUM(CNTR_IMBAL_QTY) CNTR_IMBAL_QTY                             " ).append("\n"); 
		query.append("      ,SUM(CNTR_IB_QTY) CNTR_IB_QTY                             " ).append("\n"); 
		query.append("      ,SUM(CNTR_OB_QTY) CNTR_OB_QTY    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' AS F_CNTR_TPSZ_CD2" ).append("\n"); 
		query.append("	,'' AS F_COST_YRMON" ).append("\n"); 
		query.append("	,'' AS F_ECC_CD2" ).append("\n"); 
		query.append("	,'' AS F_ORI_DEST" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("  FROM (SELECT COST_YRMON                             " ).append("\n"); 
		query.append("              ,FCNTR_ECC_CD                             " ).append("\n"); 
		query.append("              ,CNTR_TPSZ_CD                             " ).append("\n"); 
		query.append("              ,CNTR_IO_VOL_STS_CD                             " ).append("\n"); 
		query.append("              ,COA_GET_CD_NM_FNC('CD00849', NVL(CNTR_IO_VOL_STS_CD, 'X')) EQ_STATUS" ).append("\n"); 
		query.append("              ,CNTR_IMBAL_RTO                             " ).append("\n"); 
		query.append("              ,CNTR_IMBAL_QTY                             " ).append("\n"); 
		query.append("              ,CNTR_IB_QTY                             " ).append("\n"); 
		query.append("              ,CNTR_OB_QTY                             " ).append("\n"); 
		query.append("          FROM COA_FULL_ECC_IMBAL                             " ).append("\n"); 
		query.append("         WHERE 1=1                             " ).append("\n"); 
		query.append("           AND COST_LOC_GRP_CD = 'E'                             " ).append("\n"); 
		query.append("           AND COST_YRMON = @[p_cost_yrmon]  " ).append("\n"); 
		query.append("                                     " ).append("\n"); 
		query.append("           #if (${p_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("		   AND CNTR_TPSZ_CD = @[p_cntr_tpsz_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("           #if (${p_fcntr_ecc_cd} != '') " ).append("\n"); 
		query.append("		   AND FCNTR_ECC_CD = @[p_fcntr_ecc_cd]" ).append("\n"); 
		query.append("          #end   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("           #if (${p_cntr_io_vol_sts_cd} != '') " ).append("\n"); 
		query.append("		   AND CNTR_IO_VOL_STS_CD = @[p_cntr_io_vol_sts_cd]" ).append("\n"); 
		query.append("          #end              " ).append("\n"); 
		query.append("       )                             " ).append("\n"); 
		query.append("GROUP BY COST_YRMON, FCNTR_ECC_CD, CNTR_TPSZ_CD, EQ_STATUS                  " ).append("\n"); 
		query.append("ORDER BY COST_YRMON, FCNTR_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 

	}
}