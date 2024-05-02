/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USDomesticDBDAOAddLocEccSumCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.20
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2012.11.20 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song HoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOAddLocEccSumCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddLocEccSum
	  * </pre>
	  */
	public USDomesticDBDAOAddLocEccSumCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOAddLocEccSumCSQL").append("\n"); 
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
		query.append("--Location data를 ECC Level로 Summary--            " ).append("\n"); 
		query.append("INSERT INTO MAS_USA_DMST_UT_COST" ).append("\n"); 
		query.append("      ( COST_YRMON" ).append("\n"); 
		query.append("       ,ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("       ,COST_LOC_GRP_CD" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,DMST_VOL_QTY" ).append("\n"); 
		query.append("       ,RAILG_AMT" ).append("\n"); 
		query.append("       ,EQ_RNTL_SCG_AMT" ).append("\n"); 
		query.append("       ,FUEL_SCG_AMT" ).append("\n"); 
		query.append("       ,HZD_MTRL_SCG_AMT" ).append("\n"); 
		query.append("       ,DMST_TTL_FRT_REV_AMT" ).append("\n"); 
		query.append("       ,RAIL_SO_VOL_QTY" ).append("\n"); 
		query.append("       ,RAIL_AGMT_AMT" ).append("\n"); 
		query.append("       ,TRP_QTY" ).append("\n"); 
		query.append("       ,TRP_AMT" ).append("\n"); 
		query.append("       ,TRP_UC_AMT      " ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT REPLACE(@[f_cost_yrmon], '-', '')         AS COST_YRMON" ).append("\n"); 
		query.append("      ,MAS_LOC_FNC(ORG_RAIL_LOC_CD, 'ECC') LOC_CD" ).append("\n"); 
		query.append("      ,'E' --ECC Level 로 summary" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,SUM(DMST_VOL_QTY) " ).append("\n"); 
		query.append("      ,SUM(RAILG_AMT)" ).append("\n"); 
		query.append("      ,SUM(EQ_RNTL_SCG_AMT)" ).append("\n"); 
		query.append("      ,SUM(FUEL_SCG_AMT)" ).append("\n"); 
		query.append("      ,SUM(HZD_MTRL_SCG_AMT)" ).append("\n"); 
		query.append("      ,SUM(DMST_TTL_FRT_REV_AMT)" ).append("\n"); 
		query.append("      ,SUM(RAIL_SO_VOL_QTY)" ).append("\n"); 
		query.append("      ,SUM(RAIL_AGMT_AMT)" ).append("\n"); 
		query.append("      ,SUM(TRP_QTY) AS TRP_QTY" ).append("\n"); 
		query.append("      ,SUM(TRP_AMT) AS TRP_AMT" ).append("\n"); 
		query.append("      ,SUM(TRP_AMT) / SUM(TRP_QTY) AS TRP_UC_AMT" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append(" FROM MAS_USA_DMST_UT_COST" ).append("\n"); 
		query.append("WHERE COST_YRMON = REPLACE(@[f_cost_yrmon], '-', '')" ).append("\n"); 
		query.append("GROUP BY MAS_LOC_FNC(ORG_RAIL_LOC_CD, 'ECC'), CNTR_TPSZ_CD" ).append("\n"); 

	}
}