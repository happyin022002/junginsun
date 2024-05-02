/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOMergeShortTermOnHireInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOMergeShortTermOnHireInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DefaultManage의 S/T On Hire 추가, 수정
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOMergeShortTermOnHireInfoCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dryg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aval_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_chg_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pd_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dflt_usd_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lft_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("MERGE INTO EQR_SHRT_TERM_ONH_COND I" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT @[ecc_cd] AS ECC_CD" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd] AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("I.ECC_CD           = M.ECC_CD" ).append("\n"); 
		query.append("AND I.CNTR_TPSZ_CD = M.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET I.AVAL_CNTR_QTY = @[aval_cntr_qty]," ).append("\n"); 
		query.append("I.LFT_CHG_AMT       = @[lft_chg_amt]," ).append("\n"); 
		query.append("I.DRYG_AMT          = @[dryg_amt]," ).append("\n"); 
		query.append("I.PKUP_CHG_CR_AMT   = @[pkup_chg_cr_amt]," ).append("\n"); 
		query.append("I.PD_COST_AMT       = @[pd_cost_amt]," ).append("\n"); 
		query.append("I.DFLT_USD_DYS      = @[dflt_usd_dys]," ).append("\n"); 
		query.append("I.UPD_USR_ID        = @[upd_usr_id]," ).append("\n"); 
		query.append("I.UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("I.ECC_CD," ).append("\n"); 
		query.append("I.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("I.AVAL_CNTR_QTY," ).append("\n"); 
		query.append("I.LFT_CHG_AMT," ).append("\n"); 
		query.append("I.DRYG_AMT," ).append("\n"); 
		query.append("I.PKUP_CHG_CR_AMT," ).append("\n"); 
		query.append("I.PD_COST_AMT," ).append("\n"); 
		query.append("I.DFLT_USD_DYS," ).append("\n"); 
		query.append("I.CRE_USR_ID," ).append("\n"); 
		query.append("I.CRE_DT," ).append("\n"); 
		query.append("I.UPD_USR_ID," ).append("\n"); 
		query.append("I.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[ecc_cd]," ).append("\n"); 
		query.append("@[cntr_tpsz_cd]," ).append("\n"); 
		query.append("@[aval_cntr_qty]," ).append("\n"); 
		query.append("@[lft_chg_amt]," ).append("\n"); 
		query.append("@[dryg_amt]," ).append("\n"); 
		query.append("@[pkup_chg_cr_amt]," ).append("\n"); 
		query.append("@[pd_cost_amt]," ).append("\n"); 
		query.append("@[dflt_usd_dys]," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.defaultmanage.scenariodefaultmanage.integration ").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOMergeShortTermOnHireInfoCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}