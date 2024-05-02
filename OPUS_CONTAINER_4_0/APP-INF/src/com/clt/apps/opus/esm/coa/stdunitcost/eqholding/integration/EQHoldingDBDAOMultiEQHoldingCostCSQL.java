/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQHoldingDBDAOMultiEQHoldingCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.eqholding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQHoldingDBDAOMultiEQHoldingCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EQHoldingDBDAOMultiEQHoldingCostCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_hld_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_chss_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_bx_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_hld_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_hld_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_usa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ass_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.eqholding.integration").append("\n"); 
		query.append("FileName : EQHoldingDBDAOMultiEQHoldingCostCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_HLD_COST B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT '1' FROM DUAL " ).append("\n"); 
		query.append("	  ) B2	" ).append("\n"); 
		query.append("ON (     B1.COST_YRMON  = @[cost_yrmon]						" ).append("\n"); 
		query.append("	 AND B1.CNTR_CHSS_DIV_CD = @[cntr_chss_div_cd]						" ).append("\n"); 
		query.append("	 AND B1.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("     AND B1.STND_COST_CD = @[stnd_cost_cd])	" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE " ).append("\n"); 
		query.append("        SET CHSS_HLD_UC_AMT = TO_NUMBER(@[chss_hld_uc_amt])" ).append("\n"); 
		query.append("          , TTL_HLD_AMT = TO_NUMBER(@[ttl_hld_amt])" ).append("\n"); 
		query.append("          , EQ_BX_KNT = TO_NUMBER(@[eq_bx_knt])" ).append("\n"); 
		query.append("          , EQ_HLD_DYS = TO_NUMBER(@[eq_hld_dys])" ).append("\n"); 
		query.append("          , CHSS_USA_QTY = TO_NUMBER(@[chss_usa_qty])" ).append("\n"); 
		query.append("          , COST_ASS_BSE_CD = NVL(@[cost_ass_bse_cd],DECODE(@[cntr_chss_div_cd],'CNTR','P','CHSS','F',NULL))	-- 하드코딩변경" ).append("\n"); 
		query.append("          , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("          , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("COST_YRMON, " ).append("\n"); 
		query.append("CNTR_CHSS_DIV_CD, " ).append("\n"); 
		query.append("EQ_TPSZ_CD, " ).append("\n"); 
		query.append("STND_COST_CD," ).append("\n"); 
		query.append("CHSS_HLD_UC_AMT, " ).append("\n"); 
		query.append("TTL_HLD_AMT, " ).append("\n"); 
		query.append("EQ_BX_KNT, " ).append("\n"); 
		query.append("EQ_HLD_DYS, " ).append("\n"); 
		query.append("CHSS_USA_QTY," ).append("\n"); 
		query.append("COST_ASS_BSE_CD, " ).append("\n"); 
		query.append("CRE_DT, UPD_DT, CRE_USR_ID, UPD_USR_ID )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[cost_yrmon], " ).append("\n"); 
		query.append("@[cntr_chss_div_cd], " ).append("\n"); 
		query.append("@[eq_tpsz_cd], " ).append("\n"); 
		query.append("@[stnd_cost_cd]," ).append("\n"); 
		query.append("TO_NUMBER(@[chss_hld_uc_amt]), " ).append("\n"); 
		query.append("TO_NUMBER(@[ttl_hld_amt]), " ).append("\n"); 
		query.append("TO_NUMBER(@[eq_bx_knt]), " ).append("\n"); 
		query.append("TO_NUMBER(@[eq_hld_dys])," ).append("\n"); 
		query.append("TO_NUMBER(@[chss_usa_qty]), " ).append("\n"); 
		query.append("NVL(@[cost_ass_bse_cd],DECODE(@[cntr_chss_div_cd],'CNTR','P','CHSS','F',NULL)),			-- 내용변경" ).append("\n"); 
		query.append("SYSDATE, SYSDATE, @[cre_usr_id], @[upd_usr_id] )" ).append("\n"); 

	}
}