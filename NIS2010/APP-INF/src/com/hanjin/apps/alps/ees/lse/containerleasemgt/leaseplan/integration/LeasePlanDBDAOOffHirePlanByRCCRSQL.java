/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeasePlanDBDAOOffHirePlanByRCCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.12.28 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeasePlanDBDAOOffHirePlanByRCCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LeasePlanDBDAOOffHirePlanByRCCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_rgn_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAOOffHirePlanByRCCRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT 1 AS ORD_SEQ" ).append("\n"); 
		query.append(", F.PLN_YR" ).append("\n"); 
		query.append(", F.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", F.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", 'Target' AS OFFH_LOC_CD" ).append("\n"); 
		query.append(", F.OFFH_YRMON" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#set ($col_name=\"CNTR\"+$velocityCount+\"_QTY\")" ).append("\n"); 
		query.append(", SUM(DECODE(F.CNTR_TPSZ_CD, '$key', F.OFFH_QTY, 0)) AS $col_name" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT A.PLN_YR" ).append("\n"); 
		query.append(", A.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", A.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", M.OFFH_VER_SEQ" ).append("\n"); 
		query.append(", A.OFFH_YRMON" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.OFFH_QTY" ).append("\n"); 
		query.append("FROM   LSE_OFFH_PLN A" ).append("\n"); 
		query.append(", ( SELECT MAX(A.OFFH_VER_SEQ) AS OFFH_VER_SEQ" ).append("\n"); 
		query.append("FROM   LSE_OFFH_PLN A" ).append("\n"); 
		query.append("WHERE  A.OFFH_RGN_LOC_CD = @[offh_rgn_loc_cd]" ).append("\n"); 
		query.append("AND    A.OFFH_LOC_TP_CD = 'H'" ).append("\n"); 
		query.append("AND    A.OFFH_PLN_TP_CD = 'O'" ).append("\n"); 
		query.append("AND    A.OFFH_YRMON = @[offh_yrmon]" ).append("\n"); 
		query.append("AND    A.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("WHERE  A.OFFH_RGN_LOC_CD = @[offh_rgn_loc_cd]" ).append("\n"); 
		query.append("AND    A.OFFH_LOC_TP_CD = 'H'" ).append("\n"); 
		query.append("AND    A.OFFH_PLN_TP_CD = 'O'" ).append("\n"); 
		query.append("AND    A.OFFH_VER_SEQ = M.OFFH_VER_SEQ" ).append("\n"); 
		query.append("AND    A.OFFH_YRMON = @[offh_yrmon]" ).append("\n"); 
		query.append("AND    A.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append(") F" ).append("\n"); 
		query.append("GROUP  BY F.PLN_YR" ).append("\n"); 
		query.append(", F.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", F.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", F.OFFH_YRMON" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 2 AS ORD_SEQ" ).append("\n"); 
		query.append(", '${pln_yr}'          AS PLN_YR" ).append("\n"); 
		query.append(", '${offh_rgn_loc_cd}' AS OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", 'R'                  AS OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", 'Difference'         AS OFFH_LOC_CD" ).append("\n"); 
		query.append(", '${offh_yrmon}'      AS OFFH_YRMON" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#set ($col_name=\"CNTR\"+$velocityCount+\"_QTY\")" ).append("\n"); 
		query.append(", NULL AS $col_name" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 3 AS ORD_SEQ" ).append("\n"); 
		query.append(", NVL(F.PLN_YR, '${pln_yr}') AS PLN_YR" ).append("\n"); 
		query.append(", NVL(F.OFFH_RGN_LOC_CD, '${offh_rgn_loc_cd}') AS OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", NVL(F.OFFH_LOC_TP_CD, 'R') AS OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", G.LCC_CD AS OFFH_LOC_CD" ).append("\n"); 
		query.append(", NVL(F.OFFH_YRMON, '${offh_yrmon}') AS OFFH_YRMON" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#set ($col_name=\"CNTR\"+$velocityCount+\"_QTY\")" ).append("\n"); 
		query.append(", SUM(DECODE(F.CNTR_TPSZ_CD, '$key', F.OFFH_QTY, 0)) AS $col_name" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT A.PLN_YR" ).append("\n"); 
		query.append(", A.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", A.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", A.OFFH_LOC_CD" ).append("\n"); 
		query.append(", MAX(A.OFFH_VER_SEQ)" ).append("\n"); 
		query.append(", A.OFFH_YRMON" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.OFFH_QTY" ).append("\n"); 
		query.append("FROM   LSE_OFFH_PLN A" ).append("\n"); 
		query.append("WHERE  A.OFFH_RGN_LOC_CD = @[offh_rgn_loc_cd]" ).append("\n"); 
		query.append("AND    A.OFFH_LOC_TP_CD = 'R'" ).append("\n"); 
		query.append("AND    A.OFFH_PLN_TP_CD = 'O'" ).append("\n"); 
		query.append("AND    A.OFFH_YRMON = @[offh_yrmon]" ).append("\n"); 
		query.append("AND    A.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("GROUP  BY A.PLN_YR" ).append("\n"); 
		query.append(", A.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", A.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", A.OFFH_LOC_CD" ).append("\n"); 
		query.append(", A.OFFH_YRMON" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.OFFH_QTY" ).append("\n"); 
		query.append(") F" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT DISTINCT A.LCC_CD" ).append("\n"); 
		query.append("FROM   MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("WHERE  A.RCC_CD = @[offh_rgn_loc_cd]" ).append("\n"); 
		query.append("AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append(") G" ).append("\n"); 
		query.append("WHERE  F.OFFH_LOC_CD (+)= G.LCC_CD" ).append("\n"); 
		query.append("GROUP  BY F.PLN_YR" ).append("\n"); 
		query.append(", F.OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append(", F.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", G.LCC_CD" ).append("\n"); 
		query.append(", F.OFFH_YRMON" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("ORDER  BY AA.ORD_SEQ" ).append("\n"); 
		query.append(", AA.OFFH_LOC_TP_CD" ).append("\n"); 
		query.append(", AA.OFFH_LOC_CD" ).append("\n"); 

	}
}