/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USDomesticDBDAOAddDomCostUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.14
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2012.11.14 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song HoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOAddDomCostUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddDomCost
	  * </pre>
	  */
	public USDomesticDBDAOAddDomCostUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOAddDomCostUSQL").append("\n"); 
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
		query.append("-- Domestic REV-Cost data 생성" ).append("\n"); 
		query.append("UPDATE COA_USA_DMST_UT_COST" ).append("\n"); 
		query.append("   SET USA_DMST_UC_AMT	= RAIL_AGMT_AMT / RAIL_SO_VOL_QTY - DMST_TTL_FRT_REV_AMT / DMST_VOL_QTY" ).append("\n"); 
		query.append("     , OFFH_TTL_QTY	= NVL(EQ_OFFH_QTY, 0) + NVL(SUB_LSE_OUT_QTY, 0) + NVL(DISP_QTY, 0) + NVL(CND_DMST_QTY, 0)" ).append("\n"); 
		query.append(" WHERE COST_YRMON = REPLACE(@[f_cost_yrmon], '-', '')" ).append("\n"); 

	}
}