/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceAuditDBDAOConfirmInvoiceAuditSoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.09
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.11.09 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOConfirmInvoiceAuditSoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 생성 정보를 S/O 테이블에 반영
	  * </pre>
	  */
	public InvoiceAuditDBDAOConfirmInvoiceAuditSoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_calc_lgc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_act_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sub_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_etc_add_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apply_currency",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOConfirmInvoiceAuditSoUSQL").append("\n"); 
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
		query.append("UPDATE  TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("SET	    INV_NO                  = @[invoice_no]" ).append("\n"); 
		query.append("      ,	INV_VNDR_SEQ		    = @[paymt_sp_cd]" ).append("\n"); 
		query.append("      ,	EQ_NO			        = @[eq_no]" ).append("\n"); 
		query.append("      ,	EQ_TPSZ_CD		        = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("      ,	SUB_EQ_TPSZ_CD		    = @[sub_eq_tpsz_cd]" ).append("\n"); 
		query.append("      ,	CNTR_SUB_FLG		    = @[cntr_sub_flg]" ).append("\n"); 
		query.append("      ,	TRSP_INV_ACT_STS_CD	    = @[trsp_inv_act_sts_cd]" ).append("\n"); 
		query.append("      ,	LGS_COST_CD	            = NVL(( SELECT  LGS_COST.LGS_COST_CD" ).append("\n"); 
		query.append(" 		                                FROM	TRS_LGS_COST_CD_CONV_RULE B" ).append("\n"); 
		query.append(" 		                                      ,	TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append(" 		                                WHERE   A.COST_ACT_GRP_CD = B.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                                        AND	    B.LGS_COST_CD_CHK_FLG = DECODE(SUBSTR(A.FM_NOD_CD,1,5),SUBSTR(A.TO_NOD_CD,1,5) ,'Y','N')" ).append("\n"); 
		query.append("			                            AND     LGS_COST.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("			                            AND     A.CGO_TP_CD	= 'F'" ).append("\n"); 
		query.append("			                            AND     A.TRSP_SO_TP_CD= 'Y'" ).append("\n"); 
		query.append(" 		                                UNION ALL" ).append("\n"); 
		query.append(" 		                                SELECT  LGS_COST.LGS_COST_CD" ).append("\n"); 
		query.append(" 		                                FROM    TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append("                                        WHERE   LGS_COST.LGS_COST_CD = 'TR'" ).append("\n"); 
		query.append("                                                                      || DECODE(A.TRSP_COST_DTL_MOD_CD, 'CF', 'OF', 'CN', 'ON', 'MT')" ).append("\n"); 
		query.append("                                                                      || DECODE(A.TRSP_CRR_MOD_CD, 'TW', 'WT', 'RW', 'WR', 'TR', 'RT', A.TRSP_CRR_MOD_CD)" ).append("\n"); 
		query.append("			                            AND     ( A.CGO_TP_CD, A.TRSP_SO_TP_CD) in (('M','M'), ('M','Y'))" ).append("\n"); 
		query.append(" 	                                  ),  A.LGS_COST_CD )" ).append("\n"); 
		query.append("      ,	ACCT_CD                 = NVL(( SELECT	LGS_COST.ACCT_CD" ).append("\n"); 
		query.append(" 		                                FROM    TRS_LGS_COST_CD_CONV_RULE B" ).append("\n"); 
		query.append("                                              , TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append(" 		                                WHERE	A.COST_ACT_GRP_CD = B.COST_ACT_GRP_CD" ).append("\n"); 
		query.append(" 		                                AND	    B.LGS_COST_CD_CHK_FLG = DECODE(SUBSTR(A.FM_NOD_CD,1,5),SUBSTR(A.TO_NOD_CD,1,5) ,'Y','N')" ).append("\n"); 
		query.append(" 		                                AND	    LGS_COST.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append(" 		                                AND     A.CGO_TP_CD	= 'F'" ).append("\n"); 
		query.append(" 		                                AND	    A.TRSP_SO_TP_CD= 'Y'" ).append("\n"); 
		query.append(" 		                                UNION ALL" ).append("\n"); 
		query.append(" 		                                SELECT	LGS_COST.ACCT_CD" ).append("\n"); 
		query.append(" 		                                FROM	TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append(" 		                                WHERE   LGS_COST.LGS_COST_CD = 'TR'" ).append("\n"); 
		query.append("			                                                         || DECODE(A.TRSP_COST_DTL_MOD_CD, 'CF', 'OF', 'CN', 'ON', 'MT')" ).append("\n"); 
		query.append("			                                                         || DECODE(A.TRSP_CRR_MOD_CD, 'TW', 'WT', 'RW', 'WR', 'TR', 'RT', A.TRSP_CRR_MOD_CD)" ).append("\n"); 
		query.append("		                                AND     ( A.CGO_TP_CD, A.TRSP_SO_TP_CD) in (('M','M'), ('M','Y'))" ).append("\n"); 
		query.append(" 	                                  ),  A.ACCT_CD)" ).append("\n"); 
		query.append("      ,	FINC_VSL_CD             = A.VSL_CD" ).append("\n"); 
		query.append("      ,	FINC_SKD_VOY_NO		    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,	FINC_SKD_DIR_CD		    = DECODE (A.VSL_CD ,'CNTC','M',NVL (MAS_REV_DIR_CONV_FNC (A.SLAN_CD, A.POL_CD, A.SKD_DIR_CD, A.POD_CD), A.SKD_DIR_CD))" ).append("\n"); 
		query.append("      ,	INV_CURR_CD		        = @[apply_currency]" ).append("\n"); 
		query.append("      ,	INV_BZC_AMT		        = @[inv_bzc_amt]" ).append("\n"); 
		query.append("      ,	INV_ETC_ADD_AMT		    = @[inv_etc_add_amt]" ).append("\n"); 
		query.append("      ,	N3PTY_BIL_FLG		    = @[n3pty_bil_flg]" ).append("\n"); 
		query.append("      ,	N3PTY_CURR_CD		    = @[n3pty_curr_cd]" ).append("\n"); 
		query.append("      ,	INV_RMK				    = @[inv_rmk]" ).append("\n"); 
		query.append("      ,	TRSP_INV_CALC_LGC_TP_CD	= @[trsp_inv_calc_lgc_tp_cd]" ).append("\n"); 
		query.append("      ,	INV_XCH_RT		        = @[inv_xch_rt]" ).append("\n"); 
		query.append("      ,	APNT_DT                 = NVL(TO_DATE(@[apnt_dt],'YYYYMMDDHH24MISS'),APNT_DT)" ).append("\n"); 
		query.append("      ,	DE_DT                   = NVL(TO_DATE(@[de_dt],'YYYYMMDDHH24MISS'),DE_DT)" ).append("\n"); 
		query.append("      , UPD_DT                  = SYSDATE" ).append("\n"); 
		query.append("      , UPD_USR_ID	            = @[FORM_CRE_USR_ID]" ).append("\n"); 
		query.append("      , LOCL_UPD_DT             = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD])" ).append("\n"); 
		query.append("WHERE   TRSP_SO_OFC_CTY_CD	    = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND     TRSP_SO_SEQ		        = @[trsp_so_seq]" ).append("\n"); 

	}
}