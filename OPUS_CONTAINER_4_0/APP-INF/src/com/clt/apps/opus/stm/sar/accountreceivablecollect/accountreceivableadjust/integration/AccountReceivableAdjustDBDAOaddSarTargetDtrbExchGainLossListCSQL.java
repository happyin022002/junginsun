/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOaddSarTargetDtrbExchGainLossListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOaddSarTargetDtrbExchGainLossListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addSarTargetDtrbExchGainLossList
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOaddSarTargetDtrbExchGainLossListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_acct_dr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_src_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_inp_dr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_inp_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_acct_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dtrb_src_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_src_tbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("orz_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOaddSarTargetDtrbExchGainLossListCSQL").append("\n"); 
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
		query.append("MERGE INTO SAR_CLT_DTRB A" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (A.DTRB_SRC_SEQ = @[dtrb_src_seq]" ).append("\n"); 
		query.append("    AND A.DTRB_SRC_TBL_CD = @[dtrb_src_tbl_cd]" ).append("\n"); 
		query.append("    AND A.DTRB_SRC_TP_CD = @[gl_dtrb_src_tp_cd])       " ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("        SET A.GL_INP_DR_AMT = @[gl_inp_dr_amt]" ).append("\n"); 
		query.append("            , A.GL_INP_CR_AMT = @[gl_inp_cr_amt]" ).append("\n"); 
		query.append("            , A.GL_ACCT_DR_AMT = @[gl_acct_dr_amt]" ).append("\n"); 
		query.append("            , A.GL_ACCT_CR_AMT = @[gl_acct_cr_amt]" ).append("\n"); 
		query.append("            , A.GL_CURR_CD = @[gl_curr_cd]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        A.CLT_DTRB_SEQ," ).append("\n"); 
		query.append("        A.DTRB_SRC_SEQ," ).append("\n"); 
		query.append("        A.DTRB_SRC_TBL_CD," ).append("\n"); 
		query.append("        A.DTRB_SRC_TP_CD," ).append("\n"); 
		query.append("        A.DTRB_CD_CMB_SEQ," ).append("\n"); 
		query.append("        A.INP_DR_AMT," ).append("\n"); 
		query.append("        A.INP_CR_AMT," ).append("\n"); 
		query.append("        A.ACCT_DR_AMT," ).append("\n"); 
		query.append("        A.ACCT_CR_AMT," ).append("\n"); 
		query.append("        A.ORZ_SEQ," ).append("\n"); 
		query.append("        A.FM_DTRB_SRC_SEQ," ).append("\n"); 
		query.append("        A.CURR_CD," ).append("\n"); 
		query.append("        A.CONV_XCH_RT," ).append("\n"); 
		query.append("        A.ACCT_XCH_RT_LVL," ).append("\n"); 
		query.append("        A.ACCT_XCH_RT_DT," ).append("\n"); 
		query.append("        A.CUST_CNT_CD," ).append("\n"); 
		query.append("        A.CUST_SEQ," ).append("\n"); 
		query.append("        A.RVS_SRC_SEQ," ).append("\n"); 
		query.append("        A.FM_INP_DR_AMT," ).append("\n"); 
		query.append("        A.FM_INP_CR_AMT," ).append("\n"); 
		query.append("        A.FM_ACCT_DR_AMT," ).append("\n"); 
		query.append("        A.FM_ACCT_CR_AMT," ).append("\n"); 
		query.append("        A.CRE_USR_ID," ).append("\n"); 
		query.append("        A.CRE_DT," ).append("\n"); 
		query.append("        A.UPD_USR_ID," ).append("\n"); 
		query.append("        A.UPD_DT," ).append("\n"); 
		query.append("        A.AR_IF_SEQ," ).append("\n"); 
		query.append("        A.AR_IF_STS_CD," ).append("\n"); 
		query.append("        A.AR_IF_ERR_DESC," ).append("\n"); 
		query.append("        A.GL_INP_DR_AMT," ).append("\n"); 
		query.append("        A.GL_INP_CR_AMT," ).append("\n"); 
		query.append("        A.GL_CONV_XCH_RT," ).append("\n"); 
		query.append("        A.GL_ACCT_DR_AMT," ).append("\n"); 
		query.append("        A.GL_ACCT_CR_AMT," ).append("\n"); 
		query.append("        A.GL_CURR_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SAR_CLT_DTRB_SEQ.NEXTVAL," ).append("\n"); 
		query.append("        @[dtrb_src_seq]," ).append("\n"); 
		query.append("        @[dtrb_src_tbl_cd]," ).append("\n"); 
		query.append("        @[gl_dtrb_src_tp_cd]," ).append("\n"); 
		query.append("        @[cd_cmb_seq]," ).append("\n"); 
		query.append("        NULL," ).append("\n"); 
		query.append("        NULL," ).append("\n"); 
		query.append("        NULL," ).append("\n"); 
		query.append("        NULL," ).append("\n"); 
		query.append("        @[orz_seq]," ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("        @[bl_curr_cd]," ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("        @[cust_cnt_cd]," ).append("\n"); 
		query.append("        @[cust_seq]," ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[upd_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        NULL, " ).append("\n"); 
		query.append("        'P'," ).append("\n"); 
		query.append("        NULL," ).append("\n"); 
		query.append("        @[gl_inp_dr_amt]," ).append("\n"); 
		query.append("        @[gl_inp_cr_amt]," ).append("\n"); 
		query.append("        NULL," ).append("\n"); 
		query.append("        @[gl_acct_dr_amt]," ).append("\n"); 
		query.append("        @[gl_acct_cr_amt]," ).append("\n"); 
		query.append("        @[gl_curr_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}