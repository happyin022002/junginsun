/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EQBalanceDBDAOSearchEQBalance00163ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQBalanceDBDAOSearchEQBalance00163ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -POR 별 Credit Ratio를 setup 할수 있는 화면추가 (Rule-set)         
	  * </pre>
	  */
	public EQBalanceDBDAOSearchEQBalance00163ListRSQL(){
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
		params.put("f_ori_dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration").append("\n"); 
		query.append("FileName : EQBalanceDBDAOSearchEQBalance00163ListRSQL").append("\n"); 
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
		query.append("SELECT  COST_YRMON                                                                      " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_CD                                                    " ).append("\n"); 
		query.append("       ,ECC_CD     " ).append("\n"); 
		query.append("	   ,(SELECT DISTINCT LCC_CD FROM MAS_LOCATION_V WHERE ECC_CD =A.ECC_CD ) LCC_CD                                                     " ).append("\n"); 
		query.append("	   ,(SELECT DISTINCT RCC_CD FROM MAS_LOCATION_V WHERE ECC_CD =A.ECC_CD ) RCC_CD" ).append("\n"); 
		query.append("       ,IMBAL_CR_LVL || OPB_CR_LVL || MB_CR_LVL LVL_GRP   " ).append("\n"); 
		query.append("       ,ROUND (IMBAL_AMT, 2) IMBAL_AMT                     " ).append("\n"); 
		query.append("       ,ROUND (OPB_AMT, 2) OPB_AMT                          " ).append("\n"); 
		query.append("       ,ROUND (MB_AMT* 100, 2) MB_AMT                       " ).append("\n"); 
		query.append("       ,EQ_REPO_CR_RTO * 100 EQ_REPO_CR_RTO  " ).append("\n"); 
		query.append("       ,CNTR_ORG_DEST_CD AS CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("  FROM  MAS_CNTR_REPO_SHTG_INFO A" ).append("\n"); 
		query.append(" WHERE  COST_YRMON = @[f_cost_yrmon]                               " ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')                                                                	  " ).append("\n"); 
		query.append("   #if(${f_rcc_cd} != '') " ).append("\n"); 
		query.append("  	 AND RCC_CD = @[f_rcc_cd]" ).append("\n"); 
		query.append("   #end                           " ).append("\n"); 
		query.append("   		" ).append("\n"); 
		query.append("   #if(${f_lcc_cd} != '') " ).append("\n"); 
		query.append("     AND LCC_CD = @[f_lcc_cd]" ).append("\n"); 
		query.append("   #end			" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("   #if (${f_ecc_cd} != '') " ).append("\n"); 
		query.append("     AND ECC_CD = @[f_ecc_cd]" ).append("\n"); 
		query.append("   #end 			" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${f_ori_dest} != '') " ).append("\n"); 
		query.append("	AND CNTR_ORG_DEST_CD = @[f_ori_dest]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,ECC_CD" ).append("\n"); 

	}
}