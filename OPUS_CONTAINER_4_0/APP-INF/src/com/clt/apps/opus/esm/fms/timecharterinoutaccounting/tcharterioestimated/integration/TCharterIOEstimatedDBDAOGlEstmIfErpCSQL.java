/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOEstimatedDBDAOGlEstmIfErpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOEstimatedDBDAOGlEstmIfErpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GL_ESTM_IF_ERP Insert
	  * </pre>
	  */
	public TCharterIOEstimatedDBDAOGlEstmIfErpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("est_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hire_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sail_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ved_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration").append("\n"); 
		query.append("FileName : TCharterIOEstimatedDBDAOGlEstmIfErpCSQL").append("\n"); 
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
		query.append("INSERT INTO GL_ESTM_IF_ERP (" ).append("\n"); 
		query.append("	  EXE_YRMON         /*EXE_YRMON*/" ).append("\n"); 
		query.append("    , SYS_SRC_ID        /*CONSTANT : CDA*/" ).append("\n"); 
		query.append("    , REV_YRMON         /*REV_YRMON*/" ).append("\n"); 
		query.append("    , ACCT_CD           /*ACT_CD*/" ).append("\n"); 
		query.append("    , ESTM_SEQ_NO       /*MAX(ESTM_SEQ_NO) + 1*/" ).append("\n"); 
		query.append("    , AGMT_NO           /*FLET_CTRT_TP_CD : TI, TO*/" ).append("\n"); 
		query.append("    , WO_NO             /*VST_DT|VED_DT : 20150801|20150819*/" ).append("\n"); 
		query.append("    , BIZ_UT_ID         /*CONSTANT : CNTR  */" ).append("\n"); 
		query.append("    , LOC_CD            /*MDM_ORGANIZATION.LOC_CD*/" ).append("\n"); 
		query.append("    , VSL_CD            /*VSL_CD*/" ).append("\n"); 
		query.append("    , SKD_VOY_NO        /*SKD_VOY_NO*/" ).append("\n"); 
		query.append("    , SKD_DIR_CD        /*SKD_DIR_CD*/" ).append("\n"); 
		query.append("    , REV_DIR_CD        /*REV_DIR_CD*/" ).append("\n"); 
		query.append("    , SAIL_DYS          /*SAIL_DYS*/" ).append("\n"); 
		query.append("    , VVD_DUR_DYS       /*ESTM_DYS*/" ).append("\n"); 
		query.append("    , HIR_DT_AMT        /*HIRE_AMT*/" ).append("\n"); 
		query.append("    , ESTM_AMT          /*EST_AMT*/" ).append("\n"); 
		query.append("    , ACT_AMT           /*ACT_AMT*/" ).append("\n"); 
		query.append("    , ACCL_AMT          /*ACC_AMT*/" ).append("\n"); 
		query.append("    , ESTM_VVD_TP_CD    /*ESTM_VVD_TP_CD : RV*/" ).append("\n"); 
		query.append("    , ESTM_IOC_DIV_CD   /*GL_ESTM_REV_VVD.ESTM_IOC_DIV_CD*/" ).append("\n"); 
		query.append("    , ESTM_VVD_HDR_ID   /*GL_ESTM_REV_VVD.ESTM_VVD_HDR_ID*/" ).append("\n"); 
		query.append("    , ESTM_BC_DIV_CD    /*GL_ESTM_REV_VVD.ESTM_BC_DIV_CD*/" ).append("\n"); 
		query.append("    , LOCL_CURR_CD      /*CONSTANT : USD*/" ).append("\n"); 
		query.append("    , ACT_DT            /*ACT_DT*/" ).append("\n"); 
		query.append("    , SLAN_CD           /*SUBSTR(RLANE_CD,1,3)*/" ).append("\n"); 
		query.append("    , VNDR_INV_NO       /*SLP_EFF_DT|SLP_EXP_DT*/" ).append("\n"); 
		query.append("    , CRE_USR_ID        /*CRE_USR_ID*/" ).append("\n"); 
		query.append("    , CRE_DT            /*SYSDATE*/" ).append("\n"); 
		query.append("    , UPD_USR_ID        /*CRE_USR_ID*/" ).append("\n"); 
		query.append("    , UPD_DT            /*SYSDATE*/" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[exe_yrmon]                         /*PK - EXE_YRMON*/" ).append("\n"); 
		query.append("     , 'CDA'                                /*PK - SYS_SRC_ID*/" ).append("\n"); 
		query.append("     , @[rev_yrmon]                         /*PK - REV_YRMON*/" ).append("\n"); 
		query.append("     , @[acct_cd]                           /*PK - ACCT_CD*/ " ).append("\n"); 
		query.append("     , (SELECT NVL(MAX(ESTM_SEQ_NO), 1) + 1" ).append("\n"); 
		query.append("          FROM GL_ESTM_IF_ERP E" ).append("\n"); 
		query.append("         WHERE E.EXE_YRMON  = @[exe_yrmon]" ).append("\n"); 
		query.append("           AND E.SYS_SRC_ID = 'CDA'" ).append("\n"); 
		query.append("           AND E.REV_YRMON  = @[rev_yrmon]" ).append("\n"); 
		query.append("           AND E.ACCT_CD    = @[acct_cd])   /*PK - ESTM_SEQ_NO*/" ).append("\n"); 
		query.append("      , @[re_divr_cd]                       /*AGMT_NO : Expense/Revenue FLET_CTRT_TP_CD*/" ).append("\n"); 
		query.append("      , @[vst_dt]||'|'||@[ved_dt]           /*WO_NO : VST_DT|VED_DT*/" ).append("\n"); 
		query.append("      , 'CNTR'                              /*BIZ_UT_ID*/" ).append("\n"); 
		query.append("      , (SELECT LOC_CD " ).append("\n"); 
		query.append("           FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("          WHERE OFC_CD = @[slp_ofc_cd])     /*LOC_CD*/" ).append("\n"); 
		query.append("      , @[vsl_cd]                           /*VSL_CD*/" ).append("\n"); 
		query.append("      , @[skd_voy_no]                       /*SKD_VOY_NO*/" ).append("\n"); 
		query.append("      , @[skd_dir_cd]                       /*SKD_DIR_CD*/" ).append("\n"); 
		query.append("      , @[rev_dir_cd]                       /*REV_DIR_CD*/" ).append("\n"); 
		query.append("      , @[sail_dys]                         /*SAIL_DYS*/" ).append("\n"); 
		query.append("      , @[estm_dys]                         /*VVD_DUR_DYS*/" ).append("\n"); 
		query.append("      , @[hire_amt]                         /*HIR_DT_AMT*/" ).append("\n"); 
		query.append("      , @[est_amt]                          /*ESTM_AMT*/" ).append("\n"); 
		query.append("      , @[act_amt]                          /*ACT_AMT*/" ).append("\n"); 
		query.append("      , @[acc_amt]                          /*ACCL_AMT*/" ).append("\n"); 
		query.append("      , G.ESTM_VVD_TP_CD                    /*ESTM_VVD_TP_CD*/" ).append("\n"); 
		query.append("      , G.ESTM_IOC_DIV_CD                   /*ESTM_IOC_DIV_CD*/" ).append("\n"); 
		query.append("      , DECODE(G.ESTM_VVD_HDR_ID, 0, NULL, G.ESTM_VVD_HDR_ID) /*ESTM_VVD_HDR_ID*/" ).append("\n"); 
		query.append("      , G.ESTM_BC_DIV_CD                    /*ESTM_BC_DIV_CD*/" ).append("\n"); 
		query.append("      , 'USD'                               /*LOCL_CURR_CD*/" ).append("\n"); 
		query.append("      , @[act_dt]                           /*ACT_DT*/" ).append("\n"); 
		query.append("      , SUBSTR(G.RLANE_CD,1,3)              /*SLAN_CD*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slp_eff_dt} != '' && ${slp_exp_dt}) " ).append("\n"); 
		query.append("      , @[slp_eff_dt]||'|'||@[slp_exp_dt]   /*VNDR_INV_NO*/" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      , NULL   							    /*VNDR_INV_NO*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      , @[cre_usr_id]                       /*CRE_USR_ID*/" ).append("\n"); 
		query.append("      , SYSDATE                             /*CRE_DT*/" ).append("\n"); 
		query.append("      , @[cre_usr_id]                       /*UPD_USR_ID*/" ).append("\n"); 
		query.append("      , SYSDATE                             /*UPD_DT*/" ).append("\n"); 
		query.append("  FROM (SELECT ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("             , ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("             , ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("             , ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("             , RLANE_CD" ).append("\n"); 
		query.append("          FROM GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("         WHERE EXE_YRMON    = @[exe_yrmon]" ).append("\n"); 
		query.append("           AND REV_YRMON    = @[rev_yrmon]" ).append("\n"); 
		query.append("           AND VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("           AND SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND REV_DIR_CD   = @[rev_dir_cd]" ).append("\n"); 
		query.append("         ORDER BY 1 DESC" ).append("\n"); 
		query.append("       ) G" ).append("\n"); 
		query.append(" WHERE ROWNUM = 1" ).append("\n"); 

	}
}