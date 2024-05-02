/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CSRExternalFinderDBDAOAddApPayInvCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.05.20 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRExternalFinderDBDAOAddApPayInvCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_PAY_INV 생성
	  * </pre>
	  */
	public CSRExternalFinderDBDAOAddApPayInvCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whld_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vat_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_term_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_net_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_trns_slp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.integration").append("\n"); 
		query.append("FileName : CSRExternalFinderDBDAOAddApPayInvCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO   AP_PAY_INV" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INV_RGST_NO" ).append("\n"); 
		query.append(",INV_SUB_SYS_CD" ).append("\n"); 
		query.append(",INV_OFC_CD" ).append("\n"); 
		query.append(",COST_OFC_CD" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",INV_NO" ).append("\n"); 
		query.append(",INV_ISS_DT" ).append("\n"); 
		query.append(",INV_RCV_DT" ).append("\n"); 
		query.append(",INV_EFF_DT" ).append("\n"); 
		query.append(",INV_CFM_DT" ).append("\n"); 
		query.append(",VNDR_TERM_NM" ).append("\n"); 
		query.append(",GL_DT" ).append("\n"); 
		query.append(",TTL_LSS_DIV_CD" ).append("\n"); 
		query.append(",INV_CURR_CD" ).append("\n"); 
		query.append(",INV_TTL_AMT" ).append("\n"); 
		query.append(",INV_VAT_AMT" ).append("\n"); 
		query.append(",INV_NET_AMT" ).append("\n"); 
		query.append(",WHLD_TAX_AMT" ).append("\n"); 
		query.append(",EQ_TP_CD" ).append("\n"); 
		query.append(",INV_RMK" ).append("\n"); 
		query.append(",INV_STS_CD" ).append("\n"); 
		query.append(",CSR_NO" ).append("\n"); 
		query.append(",AP_PAY_AMT" ).append("\n"); 
		query.append(",PSO_TRNS_SLP_CTNT" ).append("\n"); 
		query.append(",ERR_CSR_NO" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",PAY_DUE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[inv_rgst_no]" ).append("\n"); 
		query.append(",@[inv_sub_sys_cd]" ).append("\n"); 
		query.append(",@[inv_ofc_cd]" ).append("\n"); 
		query.append(",@[cost_ofc_cd]" ).append("\n"); 
		query.append(",@[vndr_seq]" ).append("\n"); 
		query.append(",@[inv_no]" ).append("\n"); 
		query.append(",TO_DATE(@[inv_iss_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(",TO_DATE(@[inv_rcv_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(",TO_DATE(" ).append("\n"); 
		query.append("(SELECT DECODE(A.STS ,'O'	,@[inv_iss_dt]" ).append("\n"); 
		query.append(",'C'	,DECODE(B.DT, '01', NULL, B.DT)" ).append("\n"); 
		query.append(",'N'	,NULL)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT NVL(" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUM(DECODE(CLZ_STS_CD" ).append("\n"); 
		query.append(",'O',1,0)) > 0" ).append("\n"); 
		query.append("THEN 'O'" ).append("\n"); 
		query.append("ELSE 'C'" ).append("\n"); 
		query.append("END STS" ).append("\n"); 
		query.append("FROM    AP_PERIOD" ).append("\n"); 
		query.append("WHERE   SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("AND EFF_YRMON  = SUBSTR(@[inv_iss_dt],1,6)" ).append("\n"); 
		query.append("AND OFC_CD    IN (@[cost_ofc_cd]" ).append("\n"); 
		query.append(",(SELECT M.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM    MDM_ORGANIZATION M" ).append("\n"); 
		query.append("WHERE   M.OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append(") )" ).append("\n"); 
		query.append("AND AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("),'C') STS" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", (SELECT MIN(EFF_YRMON)" ).append("\n"); 
		query.append("||'01' DT" ).append("\n"); 
		query.append("FROM    AP_PERIOD" ).append("\n"); 
		query.append("WHERE   SYS_DIV_CD   = '15'" ).append("\n"); 
		query.append("AND EFF_YRMON   >= SUBSTR(@[inv_iss_dt],1,6)" ).append("\n"); 
		query.append("AND AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("AND OFC_CD      IN (@[cost_ofc_cd]" ).append("\n"); 
		query.append(",(SELECT M.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM    MDM_ORGANIZATION M" ).append("\n"); 
		query.append("WHERE   M.OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append(") )" ).append("\n"); 
		query.append("AND CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 'YYYYMMDD')" ).append("\n"); 
		query.append("/*INV_EFF_DT 를 GL_DT로 세팅*/" ).append("\n"); 
		query.append(",NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[inv_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append(",@[vndr_term_nm]" ).append("\n"); 
		query.append(",(SELECT DECODE(A.STS	,'O'	,@[inv_iss_dt]" ).append("\n"); 
		query.append(",'C'	,DECODE(B.DT, '01', NULL, B.DT)" ).append("\n"); 
		query.append(",'N'	,NULL)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT NVL(" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUM(DECODE(CLZ_STS_CD" ).append("\n"); 
		query.append(",'O',1,0)) > 0" ).append("\n"); 
		query.append("THEN 'O'" ).append("\n"); 
		query.append("ELSE 'C'" ).append("\n"); 
		query.append("END STS" ).append("\n"); 
		query.append("FROM    AP_PERIOD" ).append("\n"); 
		query.append("WHERE   SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("AND EFF_YRMON  = SUBSTR(@[inv_iss_dt],1,6)" ).append("\n"); 
		query.append("AND OFC_CD    IN (@[cost_ofc_cd]" ).append("\n"); 
		query.append(",(SELECT M.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM    MDM_ORGANIZATION M" ).append("\n"); 
		query.append("WHERE   M.OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append(") )" ).append("\n"); 
		query.append("AND AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("),'C') STS" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", (SELECT MIN(EFF_YRMON)" ).append("\n"); 
		query.append("||'01' DT" ).append("\n"); 
		query.append("FROM    AP_PERIOD" ).append("\n"); 
		query.append("WHERE   SYS_DIV_CD   = '15'" ).append("\n"); 
		query.append("AND EFF_YRMON   >= SUBSTR(@[inv_iss_dt],1,6)" ).append("\n"); 
		query.append("AND AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("AND OFC_CD      IN (@[cost_ofc_cd]" ).append("\n"); 
		query.append(",(SELECT M.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM    MDM_ORGANIZATION M" ).append("\n"); 
		query.append("WHERE   M.OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append(") )" ).append("\n"); 
		query.append("AND CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/*GL_DT*/" ).append("\n"); 
		query.append(",@[ttl_lss_div_cd]" ).append("\n"); 
		query.append(",@[inv_curr_cd]" ).append("\n"); 
		query.append(",DECODE(@[inv_curr_cd], 'KRW', ROUND(NVL(@[inv_ttl_amt],0),0)" ).append("\n"); 
		query.append(", 'JPY', ROUND(NVL(@[inv_ttl_amt],0),0)" ).append("\n"); 
		query.append(",ROUND(NVL(@[inv_ttl_amt],0),2))" ).append("\n"); 
		query.append(",DECODE(@[inv_curr_cd], 'KRW', ROUND(NVL(@[inv_vat_amt],0),0)" ).append("\n"); 
		query.append(", 'JPY', ROUND(NVL(@[inv_vat_amt],0),0)" ).append("\n"); 
		query.append(",ROUND(NVL(@[inv_vat_amt],0),2))" ).append("\n"); 
		query.append(",DECODE(@[inv_curr_cd], 'KRW', ROUND(NVL(@[inv_net_amt],0),0)" ).append("\n"); 
		query.append(", 'JPY', ROUND(NVL(@[inv_net_amt],0),0)" ).append("\n"); 
		query.append(",ROUND(NVL(@[inv_net_amt],0),2))" ).append("\n"); 
		query.append(",DECODE(@[inv_curr_cd], 'KRW', ROUND(NVL(@[whld_tax_amt],0),0)" ).append("\n"); 
		query.append(", 'JPY', ROUND(NVL(@[whld_tax_amt],0),0)" ).append("\n"); 
		query.append(",ROUND(NVL(@[whld_tax_amt],0),2))" ).append("\n"); 
		query.append(",@[eq_tp_cd]" ).append("\n"); 
		query.append(",@[inv_rmk]" ).append("\n"); 
		query.append(",'C'" ).append("\n"); 
		query.append("/*inv_sts_cd*/" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append("/*csr_no*/" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append("/*ap_pay_amt*/" ).append("\n"); 
		query.append(",@[pso_trns_slp_ctnt]" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[inv_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[inv_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append(",TO_DATE(@[pay_due_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}