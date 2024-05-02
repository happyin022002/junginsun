/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : USDomesticDBDAOAddDomSavUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.05.29 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOAddDomSavUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddDovSav
	  * </pre>
	  */
	public USDomesticDBDAOAddDomSavUSQL(){
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
		query.append("FileName : USDomesticDBDAOAddDomSavUSQL").append("\n"); 
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
		query.append("-- PER BOX당 saving 금액" ).append("\n"); 
		query.append("UPDATE COA_USA_DMST_UT_COST" ).append("\n"); 
		query.append("   SET INIT_USA_DMST_SAV_UT_AMT	= (INIT_SIM_MTY_UC_AMT * RAIL_SO_VOL_QTY - USA_DMST_UC_AMT * RAIL_SO_VOL_QTY) / FCNTR_IB_VOL_QTY" ).append("\n"); 
		query.append("     , USA_DMST_SAV_UT_AMT	= (INIT_SIM_MTY_UC_AMT * RAIL_SO_VOL_QTY - USA_DMST_UC_AMT * RAIL_SO_VOL_QTY) / FCNTR_IB_VOL_QTY" ).append("\n"); 
		query.append("     , TRP_SAV_AMT		= (SIM_MTY_UC_AMT * TRP_QTY) - TRP_AMT" ).append("\n"); 
		query.append("     , TRP_CR_UC_AMT		= ((SIM_MTY_UC_AMT * TRP_QTY) - TRP_AMT) / FCNTR_IB_VOL_QTY" ).append("\n"); 
		query.append("     , TRP_CR_UC_INIT_AMT	= ((SIM_MTY_UC_AMT * TRP_QTY) - TRP_AMT) / FCNTR_IB_VOL_QTY" ).append("\n"); 
		query.append("     , EQ_OFFH_SAV_AMT		= (SIM_MTY_UC_AMT * OFFH_TTL_QTY)" ).append("\n"); 
		query.append("     , EQ_OFFH_SAV_UC_AMT	= (SIM_MTY_UC_AMT * OFFH_TTL_QTY) / FCNTR_IB_VOL_QTY" ).append("\n"); 
		query.append("     , EQ_OFFH_SAV_UC_INIT_AMT	= (SIM_MTY_UC_AMT * OFFH_TTL_QTY) / FCNTR_IB_VOL_QTY" ).append("\n"); 
		query.append("     , EQ_OFFH_FNL_UC_AMT	= ((SIM_MTY_UC_AMT * OFFH_TTL_QTY) / FCNTR_IB_VOL_QTY) - (DMST_RAIL_INV_AMT / FCNTR_IB_VOL_QTY)" ).append("\n"); 
		query.append("     , EQ_OFFH_FNL_UC_INIT_AMT	= ((SIM_MTY_UC_AMT * OFFH_TTL_QTY) / FCNTR_IB_VOL_QTY) - (DMST_RAIL_INV_AMT / FCNTR_IB_VOL_QTY)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE COST_YRMON = REPLACE(@[f_cost_yrmon], '-', '')" ).append("\n"); 

	}
}