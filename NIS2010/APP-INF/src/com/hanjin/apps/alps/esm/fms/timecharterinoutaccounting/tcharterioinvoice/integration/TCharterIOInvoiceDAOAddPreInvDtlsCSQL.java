/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDAOAddPreInvDtlsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.02 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOAddPreInvDtlsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOAddPreInvDtlsCSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOAddPreInvDtlsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_tp_gb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_usd_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_flg",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOAddPreInvDtlsCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_INV_DTL (" ).append("\n"); 
		query.append("FLET_CTRT_NO," ).append("\n"); 
		query.append("FLET_ISS_TP_CD," ).append("\n"); 
		query.append("INV_SEQ," ).append("\n"); 
		query.append("INV_DTL_SEQ," ).append("\n"); 
		query.append("ACCT_CD," ).append("\n"); 
		query.append("ACCT_ITM_SEQ," ).append("\n"); 
		query.append("EFF_DT," ).append("\n"); 
		query.append("EXP_DT," ).append("\n"); 
		query.append("INV_USD_DYS," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("INV_AMT," ).append("\n"); 
		query.append("INV_DESC," ).append("\n"); 
		query.append("TO_YRMON," ).append("\n"); 
		query.append("FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("BROG_ACCT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[flet_ctrt_no]," ).append("\n"); 
		query.append("'PRE'," ).append("\n"); 
		query.append("(SELECT NVL(MAX(INV_SEQ),1)" ).append("\n"); 
		query.append("FROM FMS_INVOICE" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FLET_ISS_TP_CD = 'PRE')," ).append("\n"); 
		query.append("@[inv_dtl_seq]," ).append("\n"); 
		query.append("@[acct_cd]," ).append("\n"); 
		query.append("@[acct_itm_seq]," ).append("\n"); 
		query.append("TO_DATE(@[eff_dt],'YYYYMMDDHH24:MI')," ).append("\n"); 
		query.append("TO_DATE(@[exp_dt],'YYYYMMDDHH24:MI')," ).append("\n"); 
		query.append("@[inv_usd_dys]," ).append("\n"); 
		query.append("DECODE(@[curr_cd],NULL,@[curr_cd2],@[curr_cd])," ).append("\n"); 
		query.append("DECODE(@[inv_amt],NULL,@[inv_amt2],@[inv_amt])," ).append("\n"); 
		query.append("@[inv_desc]," ).append("\n"); 
		query.append("DECODE(@[flet_ctrt_tp_gb],'TI',NULL,SUBSTR(@[eff_dt],1,6))," ).append("\n"); 
		query.append("DECODE(@[curr_cd],NULL,'S','F')," ).append("\n"); 
		query.append("CASE WHEN @[brog_flg] IS NOT NULL THEN" ).append("\n"); 
		query.append("DECODE(@[acct_cd],'512641','Y','N')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'N'" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}