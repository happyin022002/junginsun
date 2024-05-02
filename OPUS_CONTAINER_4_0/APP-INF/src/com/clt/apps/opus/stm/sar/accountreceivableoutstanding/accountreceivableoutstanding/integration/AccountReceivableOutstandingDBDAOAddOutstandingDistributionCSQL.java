/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOAddOutstandingDistributionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOAddOutstandingDistributionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create Outstanding Distribution
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOAddOutstandingDistributionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inp_dr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_trns_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_to_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_trns_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inp_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("conv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_dr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_his_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_xch_rt_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOAddOutstandingDistributionCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_OTS_DTRB" ).append("\n"); 
		query.append("(" ).append("\n");
		query.append("	OTS_DTRB_SEQ" ).append("\n"); 
		query.append("	, OTS_HIS_SEQ" ).append("\n"); 
		query.append("	, OTS_CD_CMB_SEQ" ).append("\n"); 
		query.append("	, INP_DR_AMT" ).append("\n"); 
		query.append("	, INP_CR_AMT" ).append("\n"); 
		query.append("	, ACCT_DR_AMT" ).append("\n"); 
		query.append("	, ACCT_CR_AMT" ).append("\n"); 
		query.append("	, CURR_CD" ).append("\n"); 
		query.append("	, CONV_XCH_RT" ).append("\n"); 
		query.append("	, ACCT_XCH_RT_DT" ).append("\n"); 
		query.append("	, SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	, SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("	, BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	, BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("	, GL_TRNS_SEQ" ).append("\n"); 
		query.append("	, GL_TRNS_DT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	, ACCT_CLSS_CD" ).append("\n"); 
		query.append("	, CHG_TP_CD" ).append("\n"); 
		query.append("	, ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("	, AR_IF_SEQ" ).append("\n"); 
		query.append("	, AR_IF_STS_CD" ).append("\n"); 
		query.append("	, AR_IF_ERR_DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SAR_OTS_DTRB_SEQ.NEXTVAL" ).append("\n"); 
		query.append("	, @[ots_his_seq]" ).append("\n"); 
		query.append("	, @[ots_cd_cmb_seq]" ).append("\n"); 
		query.append("	, @[inp_dr_amt]" ).append("\n"); 
		query.append("	, @[inp_cr_amt]" ).append("\n"); 
		query.append("	, @[acct_dr_amt]" ).append("\n"); 
		query.append("	, @[acct_cr_amt]" ).append("\n"); 
		query.append("	, @[curr_cd]" ).append("\n"); 
		query.append("	, @[conv_xch_rt]" ).append("\n"); 
		query.append("	, @[acct_xch_rt_dt]" ).append("\n"); 
		query.append("	, @[shp_to_cust_cnt_cd]" ).append("\n"); 
		query.append("	, @[shp_to_cust_seq]" ).append("\n"); 
		query.append("	, @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("	, @[bil_to_cust_seq]" ).append("\n"); 
		query.append("	, @[gl_trns_seq]" ).append("\n"); 
		query.append("	, @[gl_trns_dt]" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[upd_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[acct_clss_cd]" ).append("\n"); 
		query.append("	, @[chg_tp_cd]" ).append("\n"); 
		query.append("	, @[acct_xch_rt_lvl]" ).append("\n"); 
		query.append("	, NULL" ).append("\n"); 
		query.append("	,'P'" ).append("\n"); 
		query.append("	, NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}