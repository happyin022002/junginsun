/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOinsertTgtYdExpnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOinsertTgtYdExpnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insertTgtYdExpn
	  * 2015.04.16 INV_LOCL_AMT, INV_USD_AMT 마이너스 값 그대로 넣도록 수정.
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOinsertTgtYdExpnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_bztp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foml_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOinsertTgtYdExpnCSQL").append("\n"); 
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
		query.append("INSERT INTO PSO_TGT_YD_EXPN(" ).append("\n"); 
		query.append("        PSO_BZTP_CD," ).append("\n"); 
		query.append("        VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        YD_CD," ).append("\n"); 
		query.append("        CLPT_IND_SEQ," ).append("\n"); 
		query.append("        LGS_COST_CD," ).append("\n"); 
		query.append("        IO_BND_CD," ).append("\n"); 
		query.append("        REV_YRMON," ).append("\n"); 
		query.append("        LOCL_CURR_CD," ).append("\n"); 
		query.append("        INV_LOCL_AMT," ).append("\n"); 
		query.append("        INV_USD_AMT," ).append("\n"); 
		query.append("        XPR_DESC," ).append("\n"); 
		query.append("        FOML_DESC," ).append("\n"); 
		query.append("        YD_CHG_NO," ).append("\n"); 
		query.append("        YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT," ).append("\n"); 
		query.append("        RLANE_CD," ).append("\n"); 
		query.append("        VNDR_SEQ," ).append("\n"); 
		query.append("        ACT_DT," ).append("\n"); 
		query.append("        REV_DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("		VALUES ( " ).append("\n"); 
		query.append("		 @[pso_bztp_cd]" ).append("\n"); 
		query.append("        ,@[vsl_cd]" ).append("\n"); 
		query.append("        ,@[skd_voy_no]" ).append("\n"); 
		query.append("        ,@[skd_dir_cd]" ).append("\n"); 
		query.append("        ,@[yd_cd]" ).append("\n"); 
		query.append("        ,@[clpt_ind_seq]" ).append("\n"); 
		query.append("        ,@[lgs_cost_cd]" ).append("\n"); 
		query.append("        ,NVL(@[io_bnd_cd], 'A')" ).append("\n"); 
		query.append("        ,@[rev_yrmon]--TO_CHAR(sysdate, 'YYYYMM') /*ap_eff_dt rev_yrmon*/" ).append("\n"); 
		query.append("        ,@[locl_curr_cd] /*(SELECT curr_cd FROM mdm_currency WHERE cnt_cd =  :locl_curr_cd) */" ).append("\n"); 
		query.append("        ,@[inv_locl_amt]" ).append("\n"); 
		query.append("        ,@[inv_usd_amt]" ).append("\n"); 
		query.append("        ,@[xpr_desc]" ).append("\n"); 
		query.append("        ,@[foml_desc]" ).append("\n"); 
		query.append("        ,@[yd_chg_no]" ).append("\n"); 
		query.append("        ,@[yd_chg_ver_seq]" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,sysdate /*cre_dt*/" ).append("\n"); 
		query.append("        ,@[upd_usr_id]" ).append("\n"); 
		query.append("        ,sysdate /*upd_dt*/" ).append("\n"); 
		query.append("		,nvl(@[rlane_cd], PSO_GET_REV_LANE_FNC(@[vsl_cd],@[skd_voy_no],@[skd_dir_cd], substr(@[yd_cd], 1, 5 ) ))" ).append("\n"); 
		query.append("		,@[vndr_seq]" ).append("\n"); 
		query.append("	    ,@[act_dt]" ).append("\n"); 
		query.append("	    ,@[rlane_dir_cd] /*2016.07.29 Add*/" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}