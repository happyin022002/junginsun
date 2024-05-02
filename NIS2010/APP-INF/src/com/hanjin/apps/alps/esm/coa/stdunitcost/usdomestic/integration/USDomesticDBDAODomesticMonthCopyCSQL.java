/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : USDomesticDBDAODomesticMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.12
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.06.12 최성민
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

public class USDomesticDBDAODomesticMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Domestic Saving Credit 월 단가 복사
	  * </pre>
	  */
	public USDomesticDBDAODomesticMonthCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAODomesticMonthCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_USA_DMST_UT_COST" ).append("\n"); 
		query.append(" SELECT @[f_tar_mon] COST_YRMON" ).append("\n"); 
		query.append("      , ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("      , COST_LOC_GRP_CD" ).append("\n"); 
		query.append("      , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , DMST_VOL_QTY" ).append("\n"); 
		query.append("      , RAILG_AMT" ).append("\n"); 
		query.append("      , EQ_RNTL_SCG_AMT" ).append("\n"); 
		query.append("      , FUEL_SCG_AMT" ).append("\n"); 
		query.append("      , HZD_MTRL_SCG_AMT" ).append("\n"); 
		query.append("      , DMST_TTL_FRT_REV_AMT" ).append("\n"); 
		query.append("      , RAIL_SO_VOL_QTY" ).append("\n"); 
		query.append("      , RAIL_AGMT_AMT" ).append("\n"); 
		query.append("      , USA_DMST_UC_AMT" ).append("\n"); 
		query.append("      , INIT_SIM_MTY_UC_AMT" ).append("\n"); 
		query.append("      , SIM_MTY_UC_AMT" ).append("\n"); 
		query.append("      , FCNTR_IB_VOL_QTY" ).append("\n"); 
		query.append("      , INIT_USA_DMST_SAV_UT_AMT" ).append("\n"); 
		query.append("      , USA_DMST_SAV_UT_AMT" ).append("\n"); 
		query.append("      , @[user_id] CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE CRE_DT" ).append("\n"); 
		query.append("      , @[user_id] UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE UPD_DT" ).append("\n"); 
		query.append("      , EQ_OFFH_QTY" ).append("\n"); 
		query.append("      , SUB_LSE_OUT_QTY" ).append("\n"); 
		query.append("      , DISP_QTY" ).append("\n"); 
		query.append("      , CND_DMST_QTY" ).append("\n"); 
		query.append("      , OFFH_TTL_QTY" ).append("\n"); 
		query.append("      , EQ_OFFH_SAV_AMT" ).append("\n"); 
		query.append("      , EQ_OFFH_SAV_UC_AMT" ).append("\n"); 
		query.append("      , EQ_OFFH_SAV_UC_INIT_AMT" ).append("\n"); 
		query.append("      , TRP_QTY" ).append("\n"); 
		query.append("      , TRP_AMT" ).append("\n"); 
		query.append("      , TRP_UC_AMT" ).append("\n"); 
		query.append("      , TRP_SAV_AMT" ).append("\n"); 
		query.append("      , TRP_CR_UC_AMT" ).append("\n"); 
		query.append("      , TRP_CR_UC_INIT_AMT" ).append("\n"); 
		query.append("      , DMST_RAIL_INV_AMT" ).append("\n"); 
		query.append("      , EQ_OFFH_FNL_UC_AMT" ).append("\n"); 
		query.append("      , EQ_OFFH_FNL_UC_INIT_AMT" ).append("\n"); 
		query.append("   FROM COA_USA_DMST_UT_COST" ).append("\n"); 
		query.append("  WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 

	}
}