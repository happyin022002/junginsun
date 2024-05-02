/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOsearchYardChargeByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.30
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.06.30 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOsearchYardChargeByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchYardChargeByVvd
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOsearchYardChargeByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOsearchYardChargeByVvdRSQL").append("\n"); 
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
		query.append("SELECT MAX (YD_CHG_NO) YD_CHG_NO," ).append("\n"); 
		query.append("  MAX (YD_CHG_VER_SEQ) YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("  YD_CD," ).append("\n"); 
		query.append("  LGS_COST_CD," ).append("\n"); 
		query.append("  VNDR_SEQ, " ).append("\n"); 
		query.append("  MAX(CURR_CD) CURR_CD /*2009.12.10 add*/" ).append("\n"); 
		query.append("FROM PSO_YD_CHG" ).append("\n"); 
		query.append("WHERE YD_CD in" ).append("\n"); 
		query.append("  (SELECT NVL(YD_CD, VPS_PORT_CD)" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("  WHERE VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("  GROUP BY NVL(YD_CD, VPS_PORT_CD)" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("AND CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("AND LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND TO_DATE (replace(@[rev_yrmon],'-',''), 'YYYYMM') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("GROUP BY YD_CD," ).append("\n"); 
		query.append("  LGS_COST_CD," ).append("\n"); 
		query.append("  VNDR_SEQ" ).append("\n"); 

	}
}