/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AvgAgencyCommissionDBDAOSearchAvgAgencyCommissionOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvgAgencyCommissionDBDAOSearchAvgAgencyCommissionOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public AvgAgencyCommissionDBDAOSearchAvgAgencyCommissionOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.integration").append("\n"); 
		query.append("FileName : AvgAgencyCommissionDBDAOSearchAvgAgencyCommissionOfficeListRSQL").append("\n"); 
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
		query.append("SELECT A.COMM_YRMON" ).append("\n"); 
		query.append("     , A.OFC_CD" ).append("\n"); 
		query.append("     , A.IO_BND_CD" ).append("\n"); 
		query.append("     , A.AC_TP_CD" ).append("\n"); 
		query.append("     , (SELECT M.AC_CD_RMK" ).append("\n"); 
		query.append("          FROM ACM_COMM_TP_CD_MAPG M" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND M.COMM_TP_CD = 'C'" ).append("\n"); 
		query.append("           AND M.AC_TP_CD   <> 'T'" ).append("\n"); 
		query.append("           AND M.AC_TP_CD   = A.AC_TP_CD " ).append("\n"); 
		query.append("           AND ROWNUM       = 1" ).append("\n"); 
		query.append("       ) AS AC_TP_NM" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , A.COMM_STND_COST_CD" ).append("\n"); 
		query.append("     , (SELECT M.COA_COST_SRC_CD_NM" ).append("\n"); 
		query.append("          FROM COA_COST_SRC_ACCT M" ).append("\n"); 
		query.append("         WHERE M.SGRP_COST_CD       = 'CVAC'" ).append("\n"); 
		query.append("           AND M.STND_COST_CD       <> '51401014'" ).append("\n"); 
		query.append("           AND M.COA_COST_SRC_CD    = A.COMM_STND_COST_CD " ).append("\n"); 
		query.append("           AND ROWNUM       = 1" ).append("\n"); 
		query.append("       ) AS COMM_STND_COST_NM" ).append("\n"); 
		query.append("     , A.TRD_CD" ).append("\n"); 
		query.append("     , A.SUB_TRD_CD" ).append("\n"); 
		query.append("     , A.BKG_QTY" ).append("\n"); 
		query.append("     , A.COMM_TTL_AMT" ).append("\n"); 
		query.append("     , A.COMM_UT_AMT" ).append("\n"); 
		query.append("  FROM ACM_COMM_OFC_UT_COST A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.COMM_YRMON = REPLACE(@[f_cost_yrmon],'-','')" ).append("\n"); 
		query.append("#if (${f_ofc_cd} != '') " ).append("\n"); 
		query.append("   AND A.OFC_CD LIKE @[f_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}