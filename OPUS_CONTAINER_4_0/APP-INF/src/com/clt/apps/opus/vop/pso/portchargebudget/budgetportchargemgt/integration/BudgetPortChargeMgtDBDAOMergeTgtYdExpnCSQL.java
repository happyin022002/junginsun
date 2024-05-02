/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOMergeTgtYdExpnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.23 
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

public class BudgetPortChargeMgtDBDAOMergeTgtYdExpnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Merge TgtYdExpn
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOMergeTgtYdExpnCSQL(){
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
		query.append("FileName : BudgetPortChargeMgtDBDAOMergeTgtYdExpnCSQL").append("\n"); 
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
		query.append("MERGE INTO PSO_TGT_YD_EXPN A" ).append("\n"); 
		query.append("USING DUAL ON ( " ).append("\n"); 
		query.append("            A.PSO_BZTP_CD   = @[pso_bztp_cd]" ).append("\n"); 
		query.append("        AND A.VSL_CD        = @[vsl_cd]                 /*VSL_CD*/" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO    = @[skd_voy_no]             /*SKD_VOY_NO*/" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD    = @[skd_dir_cd]             /*SKD_DIR_CD*/" ).append("\n"); 
		query.append("        AND A.YD_CD         = @[yd_cd]                  /*YD_CD*/" ).append("\n"); 
		query.append("        AND A.CLPT_IND_SEQ  = @[clpt_ind_seq]           /*CLPT_IND_SEQ*/" ).append("\n"); 
		query.append("        AND A.LGS_COST_CD   = @[lgs_cost_cd]            /*LGS_COST_CD*/" ).append("\n"); 
		query.append("        AND A.IO_BND_CD     = NVL(@[io_bnd_cd], 'A')    /*IO_BND_CD*/" ).append("\n"); 
		query.append("        AND A.VNDR_SEQ      = @[vndr_seq]               /*VNDR_SEQ*/" ).append("\n"); 
		query.append("        AND A.RLANE_CD      = NVL(@[rlane_cd], PSO_GET_REV_LANE_FNC(@[vsl_cd],@[skd_voy_no],@[skd_dir_cd], SUBSTR(@[yd_cd], 1, 5 ) )) /*RLANE_CD , VSL_CD, SKD_VOY_NO, SKD_DIR_CD, YD_CD */ " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED" ).append("\n"); 
		query.append("THEN UPDATE SET " ).append("\n"); 
		query.append("            A.REV_YRMON     = @[rev_yrmon]              /*REV_YRMON*/" ).append("\n"); 
		query.append("          , A.LOCL_CURR_CD  = @[locl_curr_cd]           /*LOCL_CURR_CD*/" ).append("\n"); 
		query.append("          , A.INV_LOCL_AMT  = @[inv_locl_amt]           /*INV_LOCL_AMT*/" ).append("\n"); 
		query.append("          , A.INV_USD_AMT   = @[inv_usd_amt]            /*INV_USD_AMT*/" ).append("\n"); 
		query.append("          , A.XPR_DESC      = @[xpr_desc]               /*XPR_DESC*/" ).append("\n"); 
		query.append("          , A.FOML_DESC     = @[foml_desc]              /*FOML_DESC*/" ).append("\n"); 
		query.append("          , A.YD_CHG_NO     = @[yd_chg_no]              /*YD_CHG_NO*/" ).append("\n"); 
		query.append("          , A.YD_CHG_VER_SEQ= @[yd_chg_ver_seq]         /*YD_CHG_VER_SEQ*/" ).append("\n"); 
		query.append("          , A.CRE_USR_ID    = @[cre_usr_id]             /*CRE_USR_ID*/" ).append("\n"); 
		query.append("          , A.CRE_DT        = SYSDATE                   /*CRE_DT*/" ).append("\n"); 
		query.append("          , A.UPD_USR_ID    = @[upd_usr_id]             /*UPD_USR_ID*/" ).append("\n"); 
		query.append("          , A.UPD_DT        = SYSDATE                   /*CRE_DT*/" ).append("\n"); 
		query.append("          , A.ACT_DT        = @[act_dt]                 /*ACT_DT(VPS_ETD_DT)*/" ).append("\n"); 
		query.append("          , A.REV_DIR_CD    = @[rlane_dir_cd]           /*REV_DIR_CD 2016.07.29 Add*/" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("        AND A.PSO_BZTP_CD   = @[pso_bztp_cd] " ).append("\n"); 
		query.append("        AND A.VSL_CD        = @[vsl_cd]                 /*VSL_CD*/" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO    = @[skd_voy_no]             /*SKD_VOY_NO*/" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD    = @[skd_dir_cd]             /*SKD_DIR_CD*/" ).append("\n"); 
		query.append("        AND A.YD_CD         = @[yd_cd]                  /*YD_CD*/" ).append("\n"); 
		query.append("        AND A.CLPT_IND_SEQ  = @[clpt_ind_seq]           /*CLPT_IND_SEQ*/" ).append("\n"); 
		query.append("        AND A.LGS_COST_CD   = @[lgs_cost_cd]            /*LGS_COST_CD*/" ).append("\n"); 
		query.append("        AND A.IO_BND_CD     = NVL(@[io_bnd_cd], 'A')    /*IO_BND_CD*/" ).append("\n"); 
		query.append("        AND A.VNDR_SEQ      = @[vndr_seq]               /*VNDR_SEQ*/" ).append("\n"); 
		query.append("        AND A.RLANE_CD      = NVL(@[rlane_cd], PSO_GET_REV_LANE_FNC(@[vsl_cd],@[skd_voy_no],@[skd_dir_cd], SUBSTR(@[yd_cd], 1, 5 ) )) /*RLANE_CD , VSL_CD, SKD_VOY_NO, SKD_DIR_CD, YD_CD */ " ).append("\n"); 
		query.append("WHEN NOT MATCHED" ).append("\n"); 
		query.append("THEN INSERT (" ).append("\n"); 
		query.append("            A.PSO_BZTP_CD" ).append("\n"); 
		query.append("          , A.VSL_CD" ).append("\n"); 
		query.append("          , A.SKD_VOY_NO" ).append("\n"); 
		query.append("          , A.SKD_DIR_CD" ).append("\n"); 
		query.append("          , A.YD_CD" ).append("\n"); 
		query.append("          , A.CLPT_IND_SEQ /* 2016.04.26 Double calling port Add */" ).append("\n"); 
		query.append("          , A.LGS_COST_CD" ).append("\n"); 
		query.append("          , A.IO_BND_CD" ).append("\n"); 
		query.append("          , A.VNDR_SEQ " ).append("\n"); 
		query.append("          , A.RLANE_CD" ).append("\n"); 
		query.append("          , A.REV_YRMON" ).append("\n"); 
		query.append("          , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("          , A.INV_LOCL_AMT" ).append("\n"); 
		query.append("          , A.INV_USD_AMT" ).append("\n"); 
		query.append("          , A.XPR_DESC" ).append("\n"); 
		query.append("          , A.FOML_DESC" ).append("\n"); 
		query.append("          , A.YD_CHG_NO" ).append("\n"); 
		query.append("          , A.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("          , A.CRE_USR_ID" ).append("\n"); 
		query.append("          , A.CRE_DT" ).append("\n"); 
		query.append("          , A.UPD_USR_ID" ).append("\n"); 
		query.append("          , A.UPD_DT" ).append("\n"); 
		query.append("          , A.ACT_DT" ).append("\n"); 
		query.append("          , A.REV_DIR_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("     VALUES ( " ).append("\n"); 
		query.append("                @[pso_bztp_cd]              /*PSO_BZTP_CD*/" ).append("\n"); 
		query.append("              , @[vsl_cd]                   /*VSL_CD*/" ).append("\n"); 
		query.append("              , @[skd_voy_no]               /*SKD_VOY_NO*/" ).append("\n"); 
		query.append("              , @[skd_dir_cd]               /*SKD_DIR_CD*/" ).append("\n"); 
		query.append("              , @[yd_cd]                    /*YD_CD*/" ).append("\n"); 
		query.append("              , @[clpt_ind_seq]             /*CLPT_IND_SEQ*/" ).append("\n"); 
		query.append("              , @[lgs_cost_cd]              /*LGS_COST_CD*/" ).append("\n"); 
		query.append("              , NVL(@[io_bnd_cd], 'A')      /*IO_BND_CD*/" ).append("\n"); 
		query.append("              , @[vndr_seq]                 /*VNDR_SEQ*/" ).append("\n"); 
		query.append("              , NVL(@[rlane_cd], PSO_GET_REV_LANE_FNC(@[vsl_cd],@[skd_voy_no],@[skd_dir_cd], SUBSTR(@[yd_cd], 1, 5 ) )) /*RLANE_CD*/ " ).append("\n"); 
		query.append("              , @[rev_yrmon]                /*REV_YRMON*/" ).append("\n"); 
		query.append("              , @[locl_curr_cd]             /*LOCL_CURR_CD*/" ).append("\n"); 
		query.append("              , @[inv_locl_amt]             /*INV_LOCL_AMT*/" ).append("\n"); 
		query.append("              , @[inv_usd_amt]              /*INV_USD_AMT*/" ).append("\n"); 
		query.append("              , @[xpr_desc]                 /*XPR_DESC*/" ).append("\n"); 
		query.append("              , @[foml_desc]                /*FOML_DESC*/" ).append("\n"); 
		query.append("              , @[yd_chg_no]                /*YD_CHG_NO*/" ).append("\n"); 
		query.append("              , @[yd_chg_ver_seq]           /*YD_CHG_VER_SEQ*/" ).append("\n"); 
		query.append("              , @[cre_usr_id]               /*CRE_USR_ID*/" ).append("\n"); 
		query.append("              , SYSDATE                     /*CRE_DT*/" ).append("\n"); 
		query.append("              , @[upd_usr_id]               /*UPD_USR_ID*/" ).append("\n"); 
		query.append("              , SYSDATE                     /*UPD_DT*/" ).append("\n"); 
		query.append("              , @[act_dt]                   /*ACT_DT(VPS_ETD_DT)*/" ).append("\n"); 
		query.append("              , @[rlane_dir_cd]             /*REV_DIR_CD 2016.07.29 Add*/     " ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}