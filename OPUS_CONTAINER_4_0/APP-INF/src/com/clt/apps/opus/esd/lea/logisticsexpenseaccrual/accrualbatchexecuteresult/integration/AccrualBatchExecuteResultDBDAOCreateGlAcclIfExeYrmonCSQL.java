/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOCreateGlAcclIfExeYrmonCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.26 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANG-KI JEONG
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
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration ").append("\n"); 
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
		query.append("INSERT INTO 	gl_accl_if (" ).append("\n"); 
		query.append("exe_yrmon" ).append("\n"); 
		query.append(", 	sys_src_id" ).append("\n"); 
		query.append(", 	rev_yrmon" ).append("\n"); 
		query.append(", 	acct_cd" ).append("\n"); 
		query.append(", 	accl_seq" ).append("\n"); 
		query.append(", 	biz_ut_id" ).append("\n"); 
		query.append(", 	vsl_cd" ).append("\n"); 
		query.append(", 	skd_voy_no" ).append("\n"); 
		query.append(", 	skd_dir_cd" ).append("\n"); 
		query.append(", 	rev_dir_cd" ).append("\n"); 
		query.append(", 	estm_vvd_tp_cd" ).append("\n"); 
		query.append(", 	estm_ioc_div_cd" ).append("\n"); 
		query.append(", 	estm_vvd_hdr_id" ).append("\n"); 
		query.append(", 	estm_bc_div_cd" ).append("\n"); 
		query.append(", 	nod_cd" ).append("\n"); 
		query.append(", 	estm_cost_amt" ).append("\n"); 
		query.append(", 	act_cost_amt" ).append("\n"); 
		query.append(", 	accl_cost_amt" ).append("\n"); 
		query.append(", 	cre_usr_id" ).append("\n"); 
		query.append(", 	cre_dt" ).append("\n"); 
		query.append(", 	upd_usr_id" ).append("\n"); 
		query.append(", 	upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   				a.exe_yrmon                /* exe_yrmon       */" ).append("\n"); 
		query.append(",	'ESD'                      /* sys_src_id      */" ).append("\n"); 
		query.append(", 	a.rev_yrmon                /* rev_yrmon       */" ).append("\n"); 
		query.append(", 	a.acct_cd                  /* acct_cd         */" ).append("\n"); 
		query.append(", 	(b.accl_seq + ROWNUM)      /* accl_seq        */" ).append("\n"); 
		query.append(", 	'CNTR'                     /* biz_ut_id       */" ).append("\n"); 
		query.append(", 	'CNTC'                     /* vsl_cd          */" ).append("\n"); 
		query.append(",	SUBSTR (rev_yrmon, 3, 4)   /* skd_voy_no      */" ).append("\n"); 
		query.append(", 	'M'                        /* skd_dir_cd      */" ).append("\n"); 
		query.append(", 	'M'                        /* rev_dir_cd      */" ).append("\n"); 
		query.append(", 	'RV'                       /* estm_vvd_tp_cd  */" ).append("\n"); 
		query.append(", 	'XX'                       /* estm_ioc_div_cd */" ).append("\n"); 
		query.append(", 	'99999'                    /* estm_vvd_hdr_id */" ).append("\n"); 
		query.append(", 	'C'                        /* estm_bc_div_cd  */" ).append("\n"); 
		query.append(", 	'HQCOL'                    /* nod_cd          */" ).append("\n"); 
		query.append(", 	SUM (a.estm_cost_amt)      /* estm_cost_amt   */" ).append("\n"); 
		query.append(", 	DECODE(a.acct_cd , '512181', sum(a.pre_act_cost_amt), '512381', sum(a.pre_act_cost_amt), 0 )	/*  act_cost_amt*/" ).append("\n"); 
		query.append(", 	SUM (a.accl_cost_amt)      /* accl_cost_amt		*/" ).append("\n"); 
		query.append(", 	'UI_MNL_SAV'               /* cre_usr_id      */" ).append("\n"); 
		query.append(", 	SYSDATE                    /* cre_dt          */" ).append("\n"); 
		query.append(", 	'UI_MNL_SAV'               /* upd_usr_id      */" ).append("\n"); 
		query.append(", 	SYSDATE                    /* upd_dt          */" ).append("\n"); 
		query.append("FROM					lea_acct_cost_amt a" ).append("\n"); 
		query.append(",	(	SELECT 		/*+ INDEX_DESC(gl_accl_if XAK1GL_ACCL_IF) */" ).append("\n"); 
		query.append("accl_seq" ).append("\n"); 
		query.append("FROM 		gl_accl_if" ).append("\n"); 
		query.append("WHERE		exe_yrmon 	= REPLACE(@[exe_yrmon], '-')" ).append("\n"); 
		query.append("AND 		ROWNUM 		= 1" ).append("\n"); 
		query.append(") b" ).append("\n"); 
		query.append("WHERE 					a.exe_yrmon 	= REPLACE(@[exe_yrmon], '-')" ).append("\n"); 
		query.append("AND 					a.accl_auto_cd 	= 'M'  --" ).append("\n"); 
		query.append("AND						a.mnl_inp_flg 	= 'Y'   --Manual Rep Account 로 입력한 계정(Account Code)" ).append("\n"); 
		query.append("GROUP BY 				a.exe_yrmon" ).append("\n"); 
		query.append(", 	a.rev_yrmon" ).append("\n"); 
		query.append(", 	a.acct_cd" ).append("\n"); 
		query.append(", 	(b.accl_seq + ROWNUM)" ).append("\n"); 
		query.append(", 	SUBSTR (rev_yrmon, 3, 4)" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}