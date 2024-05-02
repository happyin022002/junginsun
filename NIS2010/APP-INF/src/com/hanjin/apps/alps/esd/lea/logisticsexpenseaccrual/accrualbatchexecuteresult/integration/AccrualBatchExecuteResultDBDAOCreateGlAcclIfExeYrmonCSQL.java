/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOCreateGlAcclIfExeYrmonCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOCreateGlAcclIfExeYrmonCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOCreateGlAcclIfExeYrmonCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOCreateGlAcclIfExeYrmonCSQL").append("\n"); 
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
		query.append("INSERT INTO 	gl_accl_itrm_if ( 																									" ).append("\n"); 
		query.append("          				exe_yrmon" ).append("\n"); 
		query.append("					, 	sys_src_id" ).append("\n"); 
		query.append("					, 	rev_yrmon" ).append("\n"); 
		query.append("					, 	acct_cd" ).append("\n"); 
		query.append("					, 	accl_seq" ).append("\n"); 
		query.append("					, 	biz_ut_id" ).append("\n"); 
		query.append("					, 	vsl_cd" ).append("\n"); 
		query.append("					, 	skd_voy_no" ).append("\n"); 
		query.append("					, 	skd_dir_cd" ).append("\n"); 
		query.append("					, 	rev_dir_cd" ).append("\n"); 
		query.append("					, 	estm_vvd_tp_cd" ).append("\n"); 
		query.append("					, 	estm_ioc_div_cd" ).append("\n"); 
		query.append("					, 	estm_vvd_hdr_id" ).append("\n"); 
		query.append("					, 	estm_bc_div_cd" ).append("\n"); 
		query.append("					, 	nod_cd" ).append("\n"); 
		query.append("					, 	estm_cost_amt" ).append("\n"); 
		query.append("					, 	act_cost_amt" ).append("\n"); 
		query.append("					, 	accl_cost_amt" ).append("\n"); 
		query.append("					, 	cre_usr_id" ).append("\n"); 
		query.append("					, 	cre_dt" ).append("\n"); 
		query.append("					, 	upd_usr_id" ).append("\n"); 
		query.append("					, 	upd_dt" ).append("\n"); 
		query.append("					)                                                                                       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT					XX.EXE_YRMON" ).append("\n"); 
		query.append("					,   XX.SYS_SRC_ID" ).append("\n"); 
		query.append("					,   XX.REV_YRMON" ).append("\n"); 
		query.append("					,   XX.ACCT_CD" ).append("\n"); 
		query.append("					,   XX.ACCL_SEQ" ).append("\n"); 
		query.append("					,   XX.BIZ_UT_ID" ).append("\n"); 
		query.append("					,	XX.VSL_CD            		" ).append("\n"); 
		query.append("					,	XX.SKD_VOY_NO 	" ).append("\n"); 
		query.append("					,	XX.SKD_DIR_CD  	" ).append("\n"); 
		query.append("					,	XX.REV_DIR_CD   	" ).append("\n"); 
		query.append("					,	XX.ESTM_VVD_TP_CD  " ).append("\n"); 
		query.append("					,	XX.ESTM_IOC_DIV_CD " ).append("\n"); 
		query.append("					,	XX.ESTM_VVD_HDR_ID " ).append("\n"); 
		query.append("					,	XX.ESTM_BC_DIV_CD  " ).append("\n"); 
		query.append("					,	XX.NOD_CD   		" ).append("\n"); 
		query.append("					,	XX.ESTM_COST_AMT   " ).append("\n"); 
		query.append("					,	XX.ACT_COST_AMT " ).append("\n"); 
		query.append("					,	XX.ACCL_COST_AMT   " ).append("\n"); 
		query.append("					,	XX.CRE_USR_ID   	" ).append("\n"); 
		query.append("					,	XX.CRE_DT   		" ).append("\n"); 
		query.append("					,	XX.UPD_USR_ID   	" ).append("\n"); 
		query.append("					,	XX.UPD_DT   		" ).append("\n"); 
		query.append("FROM					(          					" ).append("\n"); 
		query.append("          				SELECT   	a.exe_yrmon                					/* exe_yrmon       */" ).append("\n"); 
		query.append("          						,	'ESD'           			SYS_SRC_ID		/* sys_src_id      */" ).append("\n"); 
		query.append("          						, 	a.rev_yrmon                					/* rev_yrmon       */" ).append("\n"); 
		query.append("          						, 	a.acct_cd                  					/* acct_cd         */" ).append("\n"); 
		query.append("          						, 	(b.accl_seq + ROWNUM)   	ACCL_SEQ     	/* accl_seq        */" ).append("\n"); 
		query.append("          						, 	'CNTR'         				BIZ_UT_ID		/* biz_ut_id       */" ).append("\n"); 
		query.append("          						, 	'CNTC'         				VSL_CD			/* vsl_cd          */" ).append("\n"); 
		query.append("          						,	SUBSTR (rev_yrmon, 3, 4)	SKD_VOY_NO 		/* skd_voy_no      */" ).append("\n"); 
		query.append("          						, 	'M'                     	SKD_DIR_CD  	/* skd_dir_cd      */" ).append("\n"); 
		query.append("          						, 	'M'                     	REV_DIR_CD   	/* rev_dir_cd      */" ).append("\n"); 
		query.append("          						, 	'RV'                    	ESTM_VVD_TP_CD	/* estm_vvd_tp_cd  */" ).append("\n"); 
		query.append("          						, 	'XX'                    	ESTM_IOC_DIV_CD	/* estm_ioc_div_cd */" ).append("\n"); 
		query.append("          						, 	'99999'                 	ESTM_VVD_HDR_ID	/* estm_vvd_hdr_id */" ).append("\n"); 
		query.append("          						, 	'C'                     	ESTM_BC_DIV_CD	/* estm_bc_div_cd  */" ).append("\n"); 
		query.append("          						, 	'HQCOL'                 	NOD_CD   		/* nod_cd          */" ).append("\n"); 
		query.append("          						, 	SUM (a.estm_cost_amt)   	ESTM_COST_AMT   /* estm_cost_amt   */" ).append("\n"); 
		query.append("          						, 	DECODE(a.acct_cd , '512181', sum(a.pre_act_cost_amt), '512381', sum(a.pre_act_cost_amt), 0 )	ACT_COST_AMT /* act_cost_amt */" ).append("\n"); 
		query.append("          						, 	SUM (a.accl_cost_amt)   	ACCL_COST_AMT   /* accl_cost_amt   */" ).append("\n"); 
		query.append("          						, 	'UI_MNL_SAV'            	CRE_USR_ID   	/* cre_usr_id      */" ).append("\n"); 
		query.append("          						, 	SYSDATE                 	CRE_DT   		/* cre_dt          */" ).append("\n"); 
		query.append("          						, 	'UI_MNL_SAV'            	UPD_USR_ID   	/* upd_usr_id      */" ).append("\n"); 
		query.append("          						, 	SYSDATE                 	UPD_DT   		/* upd_dt          */                                                      " ).append("\n"); 
		query.append("          				FROM		lea_acct_cost_amt a" ).append("\n"); 
		query.append("          						,	(	SELECT 		/*+ INDEX_DESC(gl_accl_itrm_if XAK1GL_ACCL_ITRM_IF) */                                                        " ).append("\n"); 
		query.append("                           							accl_seq                                                                                           " ).append("\n"); 
		query.append("                      					FROM 		GL_ACCL_ITRM_IF                                                                                         " ).append("\n"); 
		query.append("                     					WHERE		exe_yrmon 		= REPLACE(@[exe_yrmon], '-')  " ).append("\n"); 
		query.append("                     					AND 		ROWNUM 			= 1" ).append("\n"); 
		query.append("                     				) b                                 						" ).append("\n"); 
		query.append("          				WHERE 		a.exe_yrmon 					= REPLACE(@[exe_yrmon], '-')                                   							                " ).append("\n"); 
		query.append("          				AND 		a.accl_auto_cd 					IN ('A', 'M') 				/* 2012/01 FULL VOL. INCENTIVE ACCOUNT CODE 포함 */                                                                                   " ).append("\n"); 
		query.append("          				AND			a.mnl_inp_flg 					= 'Y'   --Manual Rep Account 로 입력한 계정(Account Code)  " ).append("\n"); 
		query.append("          				GROUP BY 	a.exe_yrmon" ).append("\n"); 
		query.append("          						, 	a.rev_yrmon" ).append("\n"); 
		query.append("          						, 	a.acct_cd" ).append("\n"); 
		query.append("          						, 	(b.accl_seq + ROWNUM)" ).append("\n"); 
		query.append("          						, 	SUBSTR (rev_yrmon, 3, 4)" ).append("\n"); 
		query.append("          					" ).append("\n"); 
		query.append("          				) XX" ).append("\n"); 
		query.append("WHERE					NOT (XX.ESTM_COST_AMT = 0 AND XX.ACT_COST_AMT = 0 AND XX.ACCL_COST_AMT = 0)      /* COST AMT 0 인 데이터 제외처리 */" ).append("\n"); 

	}
}