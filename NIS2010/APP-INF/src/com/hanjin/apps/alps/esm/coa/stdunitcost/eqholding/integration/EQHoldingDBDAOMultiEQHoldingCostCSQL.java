/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQHoldingDBDAOMultiEQHoldingCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.11.06 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song Ho Jin
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.integration").append("\n"); 
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
		query.append("INSERT INTO COA_HLD_COST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("COST_YRMON," ).append("\n"); 
		query.append("CNTR_CHSS_DIV_CD," ).append("\n"); 
		query.append("EQ_TPSZ_CD," ).append("\n"); 
		query.append("STND_COST_CD," ).append("\n"); 
		query.append("CHSS_HLD_UC_AMT," ).append("\n"); 
		query.append("TTL_HLD_AMT," ).append("\n"); 
		query.append("EQ_BX_KNT," ).append("\n"); 
		query.append("EQ_HLD_DYS," ).append("\n"); 
		query.append("CHSS_USA_QTY," ).append("\n"); 
		query.append("COST_ASS_BSE_CD," ).append("\n"); 
		query.append("CRE_DT, UPD_DT, CRE_USR_ID, UPD_USR_ID )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[cost_yrmon]," ).append("\n"); 
		query.append("@[cntr_chss_div_cd]," ).append("\n"); 
		query.append("@[eq_tpsz_cd]," ).append("\n"); 
		query.append("@[stnd_cost_cd]," ).append("\n"); 
		query.append("TO_NUMBER(@[chss_hld_uc_amt])," ).append("\n"); 
		query.append("TO_NUMBER(@[ttl_hld_amt])," ).append("\n"); 
		query.append("TO_NUMBER(@[eq_bx_knt])," ).append("\n"); 
		query.append("TO_NUMBER(@[eq_hld_dys])," ).append("\n"); 
		query.append("TO_NUMBER(@[chss_usa_qty])," ).append("\n"); 
		query.append("'F'," ).append("\n"); 
		query.append("SYSDATE, SYSDATE, @[cre_usr_id], @[upd_usr_id] )" ).append("\n"); 

	}
}