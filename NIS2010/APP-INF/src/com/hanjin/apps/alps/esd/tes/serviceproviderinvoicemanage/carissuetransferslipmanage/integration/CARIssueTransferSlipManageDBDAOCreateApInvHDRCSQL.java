/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCreateApInvHDRCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOCreateApInvHDRCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateApInvHDR
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCreateApInvHDRCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("evi_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_tax_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payment_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_term_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("evi_tax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_cate_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_mzd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evi_total_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_grp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("evi_total_net_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCreateApInvHDRCSQL").append("\n"); 
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
		query.append("insert into AP_INV_HDR (" ).append("\n"); 
		query.append("csr_no                                            ," ).append("\n"); 
		query.append("csr_tp_cd                                         ," ).append("\n"); 
		query.append("inv_dt                                            ," ).append("\n"); 
		query.append("inv_term_dt                                       ," ).append("\n"); 
		query.append("gl_dt                                             ," ).append("\n"); 
		query.append("vndr_no                                           ," ).append("\n"); 
		query.append("csr_amt                                           ," ).append("\n"); 
		query.append("pay_amt                                           ," ).append("\n"); 
		query.append("pay_dt                                            ," ).append("\n"); 
		query.append("csr_curr_cd                                       ," ).append("\n"); 
		query.append("vndr_term_nm                                      ," ).append("\n"); 
		query.append("inv_desc                                          ," ).append("\n"); 
		query.append("attr_cate_nm                                      ," ).append("\n"); 
		query.append("attr_ctnt1                                        ," ).append("\n"); 
		query.append("attr_ctnt2                                        ," ).append("\n"); 
		query.append("attr_ctnt3                                        ," ).append("\n"); 
		query.append("attr_ctnt4                                        ," ).append("\n"); 
		query.append("attr_ctnt5                                        ," ).append("\n"); 
		query.append("attr_ctnt6                                        ," ).append("\n"); 
		query.append("attr_ctnt7                                        ," ).append("\n"); 
		query.append("attr_ctnt8                                        ," ).append("\n"); 
		query.append("attr_ctnt9                                        ," ).append("\n"); 
		query.append("attr_ctnt10                                       ," ).append("\n"); 
		query.append("attr_ctnt11                                       ," ).append("\n"); 
		query.append("attr_ctnt12                                       ," ).append("\n"); 
		query.append("attr_ctnt13                                       ," ).append("\n"); 
		query.append("attr_ctnt14                                       ," ).append("\n"); 
		query.append("attr_ctnt15                                       ," ).append("\n"); 
		query.append("glo_attr_ctnt1                                    ," ).append("\n"); 
		query.append("glo_attr_ctnt2                                    ," ).append("\n"); 
		query.append("glo_attr_ctnt3                                    ," ).append("\n"); 
		query.append("glo_attr_ctnt4                                    ," ).append("\n"); 
		query.append("glo_attr_ctnt5                                    ," ).append("\n"); 
		query.append("glo_attr_ctnt6                                    ," ).append("\n"); 
		query.append("glo_attr_ctnt7                                    ," ).append("\n"); 
		query.append("glo_attr_ctnt8                                    ," ).append("\n"); 
		query.append("glo_attr_ctnt9                                    ," ).append("\n"); 
		query.append("glo_attr_ctnt10                                   ," ).append("\n"); 
		query.append("glo_attr_ctnt11                                   ," ).append("\n"); 
		query.append("glo_attr_ctnt12                                   ," ).append("\n"); 
		query.append("glo_attr_ctnt13                                   ," ).append("\n"); 
		query.append("glo_attr_ctnt14                                   ," ).append("\n"); 
		query.append("glo_attr_ctnt15                                   ," ).append("\n"); 
		query.append("glo_attr_ctnt16                                   ," ).append("\n"); 
		query.append("glo_attr_ctnt17                                   ," ).append("\n"); 
		query.append("glo_attr_ctnt18                                   ," ).append("\n"); 
		query.append("src_ctnt                                          ," ).append("\n"); 
		query.append("pay_mzd_lu_cd                                     ," ).append("\n"); 
		query.append("pay_grp_lu_cd                                     ," ).append("\n"); 
		query.append("coa_co_cd                                         ," ).append("\n"); 
		query.append("coa_rgn_cd                                        ," ).append("\n"); 
		query.append("coa_ctr_cd                                        ," ).append("\n"); 
		query.append("coa_acct_cd                                       ," ).append("\n"); 
		query.append("coa_vvd_cd                                        ," ).append("\n"); 
		query.append("coa_inter_co_cd                                   ," ).append("\n"); 
		query.append("coa_ftu_n1st_cd                                   ," ).append("\n"); 
		query.append("coa_ftu_n2nd_cd                                   ," ).append("\n"); 
		query.append("ppd_no                                            ," ).append("\n"); 
		query.append("ppd_dtrb_no                                       ," ).append("\n"); 
		query.append("ppd_aply_amt                                      ," ).append("\n"); 
		query.append("ppd_gl_dt                                         ," ).append("\n"); 
		query.append("apro_flg                                          ," ).append("\n"); 
		query.append("tax_decl_flg                                      ," ).append("\n"); 
		query.append("err_csr_no                                        ," ).append("\n"); 
		query.append("if_flg                                            ," ).append("\n"); 
		query.append("if_dt                                             ," ).append("\n"); 
		query.append("if_err_rsn                                        ," ).append("\n"); 
		query.append("ppay_aply_flg                                     ," ).append("\n"); 
		query.append("tj_ofc_cd                                         ," ).append("\n"); 
		query.append("act_xch_rt                                        ," ).append("\n"); 
		query.append("imp_err_flg                                       ," ).append("\n"); 
		query.append("rcv_err_flg                                       ," ).append("\n"); 
		query.append("tax_curr_xch_flg                                  ," ).append("\n"); 
		query.append("usr_eml                                           ," ).append("\n"); 
		query.append("imp_err_rsn                                       ," ).append("\n"); 
		query.append("rcv_err_rsn                                       ," ).append("\n"); 
		query.append("ftu_use_ctnt1                                     ," ).append("\n"); 
		query.append("ftu_use_ctnt2                                     ," ).append("\n"); 
		query.append("ftu_use_ctnt3                                     ," ).append("\n"); 
		query.append("ftu_use_ctnt4                                     ," ).append("\n"); 
		query.append("ftu_use_ctnt5                                     ," ).append("\n"); 
		query.append("cre_dt                                            ," ).append("\n"); 
		query.append("cre_usr_id                                        ," ).append("\n"); 
		query.append("eai_evnt_dt" ).append("\n"); 
		query.append(") values (" ).append("\n"); 
		query.append("@[csr_no]													," ).append("\n"); 
		query.append("@[csr_tp_cd]												," ).append("\n"); 
		query.append("@[inv_dt]													," ).append("\n"); 
		query.append("@[inv_term_dt]                                              ," ).append("\n"); 
		query.append("/*  2008-06-18: AP_PERIOD TABLE의 구조 변경으로 수정  */" ).append("\n"); 
		query.append("--		(SELECT DECODE(A.STS,'O',[],'C',B.DT,'N',NULL)" ).append("\n"); 
		query.append("--		 FROM   (SELECT NVL((SELECT CLZ_STS_CD STS" ).append("\n"); 
		query.append("--		         FROM   AP_PERIOD" ).append("\n"); 
		query.append("--		         WHERE  SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("--		         AND    EFF_YRMON  = SUBSTR([],1,6)" ).append("\n"); 
		query.append("--		         AND    OFC_CD = []" ).append("\n"); 
		query.append("--		         AND    AR_AP_DIV_CD = 'P' ),'C') STS FROM DUAL) A," ).append("\n"); 
		query.append("--		        (SELECT MIN(EFF_YRMON)||'01' DT" ).append("\n"); 
		query.append("--		         FROM   AP_PERIOD" ).append("\n"); 
		query.append("--		         WHERE  SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("--		         AND    EFF_YRMON >= SUBSTR([],1,6)" ).append("\n"); 
		query.append("--		         AND    CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("--		         AND    OFC_CD = TES_AP_PERIOD_OFC_CD_FNC('M','15',SUBSTR([],1,6),[])" ).append("\n"); 
		query.append("--		         AND    AR_AP_DIV_CD = 'P') B )," ).append("\n"); 
		query.append("(SELECT DECODE(A.STS,'O',@[gl_dt],'C',B.DT,'N',NULL)" ).append("\n"); 
		query.append("FROM   (SELECT NVL((SELECT CASE WHEN SUM(DECODE(CLZ_STS_CD,'O',1,0)) > 0 THEN 'O' ELSE 'C' END STS" ).append("\n"); 
		query.append("FROM   AP_PERIOD" ).append("\n"); 
		query.append("WHERE  SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("AND    EFF_YRMON  = SUBSTR(@[gl_dt],1,6)" ).append("\n"); 
		query.append("AND    OFC_CD IN (@[ap_ofc_cd],(SELECT M.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = @[ap_ofc_cd]))" ).append("\n"); 
		query.append("AND    AR_AP_DIV_CD = 'P'),'C') STS FROM DUAL) A," ).append("\n"); 
		query.append("(SELECT MIN(EFF_YRMON)||'01' DT" ).append("\n"); 
		query.append("FROM   AP_PERIOD" ).append("\n"); 
		query.append("WHERE  SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("AND    EFF_YRMON >= SUBSTR(@[gl_dt],1,6)" ).append("\n"); 
		query.append("AND    AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("AND    OFC_CD IN (@[ap_ofc_cd],(SELECT M.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = @[ap_ofc_cd]))" ).append("\n"); 
		query.append("AND    CLZ_STS_CD = 'O') B )," ).append("\n"); 
		query.append("@[vndr_seq]	                                              ," ).append("\n"); 
		query.append("@[csr_amt]                                                ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                            ," ).append("\n"); 
		query.append("@[curr_cd]                                        ," ).append("\n"); 
		query.append("--		[]                                                 ,                     --vndr_term_nm" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(@[gen_pay_term_cd],1,1)='O' THEN @[gen_pay_term_cd]" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[payment_due_dt] IS NOT NULL AND @[max_iss_dt] IS NOT NULL THEN" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(TO_DATE(@[payment_due_dt],'YYYY-MM-DD') - (TO_DATE(@[max_iss_dt],'YYYY-MM-DD')),0) >= 0" ).append("\n"); 
		query.append("AND NVL(TO_DATE(@[payment_due_dt],'YYYY-MM-DD') - (TO_DATE(@[max_iss_dt],'YYYY-MM-DD')),0) <= 100" ).append("\n"); 
		query.append("THEN TO_CHAR(NVL(TO_DATE(@[payment_due_dt],'YYYY-MM-DD') - (TO_DATE(@[max_iss_dt],'YYYY-MM-DD')),0))" ).append("\n"); 
		query.append("ELSE @[gen_pay_term_cd]" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE @[gen_pay_term_cd]" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END RES" ).append("\n"); 
		query.append("FROM DUAL),                                                                                              --vndr_term_nm" ).append("\n"); 
		query.append("--		(SELECT VNDR_LOCL_LANG_NM FROM  MDM_VENDOR  WHERE  VNDR_SEQ = [])  ," ).append("\n"); 
		query.append("--		(SELECT DECODE(VNDR_CNT_CD,'KR',VNDR_LOCL_LANG_NM,VNDR_LGL_ENG_NM) FROM  MDM_VENDOR  WHERE  VNDR_SEQ = [])  ,    --inv_desc" ).append("\n"); 
		query.append("''  ,    --inv_desc	2007-12-17 : ERP의 요청으로 max acct nm을 배부치고 넣는다." ).append("\n"); 
		query.append("@[attr_cate_nm]                                                 ,											--attr_cate_nm" ).append("\n"); 
		query.append("@[attr_ctnt1]                                                 ,											--attr_ctnt1" ).append("\n"); 
		query.append("@[attr_ctnt2]                                                 ,											--attr_ctnt2" ).append("\n"); 
		query.append("@[attr_ctnt3]                                                 ,											--attr_ctnt3" ).append("\n"); 
		query.append("@[evi_total_net_amt]                                                 ,											--attr_ctnt4" ).append("\n"); 
		query.append("@[evi_tax_no2]                                                 ,											--attr_ctnt5" ).append("\n"); 
		query.append("@[evi_total_tax_amt]                                                 ,											--attr_ctnt6" ).append("\n"); 
		query.append("''                                                 ,											--attr_ctnt7" ).append("\n"); 
		query.append("@[attr_ctnt8]                                                 ,											--attr_ctnt8" ).append("\n"); 
		query.append("''                                                 ,											--attr_ctnt9" ).append("\n"); 
		query.append("@[usr_nm]                                                 ,											--attr_ctnt10" ).append("\n"); 
		query.append("''                                                 ,											--attr_ctnt11" ).append("\n"); 
		query.append("''                                                 ,											--attr_ctnt12" ).append("\n"); 
		query.append("''                                                 ,											--attr_ctnt13" ).append("\n"); 
		query.append("''                                                 ,											--attr_ctnt14" ).append("\n"); 
		query.append("''                                                 ,											--attr_ctnt15" ).append("\n"); 
		query.append("@[evi_ctnt1]                                                 ,											--glo_attr_ctnt1" ).append("\n"); 
		query.append("@[evi_ctnt2]                                                 ,											--glo_attr_ctnt2" ).append("\n"); 
		query.append("@[evi_ctnt3]                                                 ,											--glo_attr_ctnt3" ).append("\n"); 
		query.append("@[evi_ctnt4]                                                 ,											--glo_attr_ctnt4" ).append("\n"); 
		query.append("@[evi_ctnt5]                                                 ,											--glo_attr_ctnt5" ).append("\n"); 
		query.append("@[evi_ctnt6]                                                 ,											--glo_attr_ctnt6" ).append("\n"); 
		query.append("@[evi_ctnt7]                                                 ,											--glo_attr_ctnt7" ).append("\n"); 
		query.append("@[evi_ctnt8]                                                 ,											--glo_attr_ctnt8" ).append("\n"); 
		query.append("@[evi_ctnt9]                                                 ,											--glo_attr_ctnt9" ).append("\n"); 
		query.append("@[evi_ctnt10]                                                 ,											--glo_attr_ctnt10" ).append("\n"); 
		query.append("@[evi_ctnt11]                                                 ,											--glo_attr_ctnt11" ).append("\n"); 
		query.append("@[evi_ctnt12]                                                 ,											--glo_attr_ctnt12" ).append("\n"); 
		query.append("@[evi_tax_no]                                                 ,											--glo_attr_ctnt13" ).append("\n"); 
		query.append("''                                                 ,											--glo_attr_ctnt14" ).append("\n"); 
		query.append("''                                                 ,											--glo_attr_ctnt15" ).append("\n"); 
		query.append("''                                                 ,											--glo_attr_ctnt16" ).append("\n"); 
		query.append("''                                                 ,											--glo_attr_ctnt17" ).append("\n"); 
		query.append("''                                                 ,											--glo_attr_ctnt18" ).append("\n"); 
		query.append("'SO_TERMINAL'                                                 ,											--src_ctnt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(@[cnt_cd],'US',(SELECT DECODE(PAY_MZD_CD, 'CSH', 'CASH'," ).append("\n"); 
		query.append("'CHK', 'CHECK' ," ).append("\n"); 
		query.append("'CKG', 'CHECK(G/EXP)' ," ).append("\n"); 
		query.append("'CKO', 'CHECK(O/EXP)' ," ).append("\n"); 
		query.append("'CLE', 'CLEARING' ," ).append("\n"); 
		query.append("'CMA', 'CMS ACH' ," ).append("\n"); 
		query.append("'CMG', 'CMS CHECK(G/EXP)' ," ).append("\n"); 
		query.append("'CMO', 'CMS CHECK(O/EXP)' ," ).append("\n"); 
		query.append("'CMW', 'CMS WIRE' ," ).append("\n"); 
		query.append("'EFT', 'EFT' ," ).append("\n"); 
		query.append("'WIR', 'WIRE' ," ).append("\n"); 
		query.append("'AUD', 'AUTO DEBIT' ," ).append("\n"); 
		query.append("'ICO', 'CMS ICO' ," ).append("\n"); 
		query.append("'IDD', 'CMS IDD')" ).append("\n"); 
		query.append("FROM mdm_vendor" ).append("\n"); 
		query.append("WHERE vndr_seq = @[vndr_seq]),@[pay_mzd_lu_cd]), --pay_mzd_lu_cd (2013.3.20 US의 경우 MDM Vendor의 Pay method 세분화된 것을 Insert함)" ).append("\n"); 
		query.append("@[pay_grp_lu_cd]                                                 ,											--pay_grp_lu_cd" ).append("\n"); 
		query.append("'01'                                                 ,											--coa_co_cd" ).append("\n"); 
		query.append("(SELECT finc_rgn_cd FROM MDM_ORGANIZATION WHERE ofc_cd = @[cost_ofc_cd] AND NVL(delt_flg,'N') = 'N') ,		--coa_rgn_cd" ).append("\n"); 
		query.append("(SELECT ap_ctr_cd FROM MDM_ORGANIZATION WHERE ofc_cd = @[cost_ofc_cd] AND NVL(delt_flg,'N') = 'N')   ,		--coa_ctr_cd" ).append("\n"); 
		query.append("'210111'                                                 ,											--coa_acct_cd" ).append("\n"); 
		query.append("'0000000000'                                                 ,											--coa_vvd_cd" ).append("\n"); 
		query.append("(SELECT nvl(SUBS_CO_CD,'00') FROM mdm_vendor WHERE vndr_seq = @[vndr_seq] )	                      ,   	--coa_inter_co_cd" ).append("\n"); 
		query.append("'000000'		          									,											--coa_ftu_n1st_cd" ).append("\n"); 
		query.append("'000000'                                                 ,											--coa_ftu_n2nd_cd" ).append("\n"); 
		query.append("''                                                 ,											--ppd_no" ).append("\n"); 
		query.append("''                                                 ,											--ppd_dtrb_no" ).append("\n"); 
		query.append("''                                                 ,											--ppd_aply_amt" ).append("\n"); 
		query.append("''                                                 ,											--ppd_gl_dt" ).append("\n"); 
		query.append("'N'                                                 ,											--apro_flg" ).append("\n"); 
		query.append("''                                                 ,											--tax_decl_flg" ).append("\n"); 
		query.append("''                                                 ,											--err_csr_no" ).append("\n"); 
		query.append("''                                                 ,											--if_flg" ).append("\n"); 
		query.append("''                                                 ,											--if_dt" ).append("\n"); 
		query.append("''                                                 ,											--if_err_rsn" ).append("\n"); 
		query.append("''                                                 ,											--ppay_aply_flg" ).append("\n"); 
		query.append("@[ap_ofc_cd]                                                 ,											--tj_ofc_cd" ).append("\n"); 
		query.append("''                                                 ,											--act_xch_rt" ).append("\n"); 
		query.append("''                                                 ,											--imp_err_flg" ).append("\n"); 
		query.append("''                                                 ,											--rcv_err_flg" ).append("\n"); 
		query.append("''                                                 ,											--tax_curr_xch_flg" ).append("\n"); 
		query.append("@[usr_eml]                                                 ,											--usr_eml" ).append("\n"); 
		query.append("''                                                 ,											--imp_err_rsn" ).append("\n"); 
		query.append("''                                                 ,											--rcv_err_rsn" ).append("\n"); 
		query.append("''                                                 ,											--ftu_use_ctnt1" ).append("\n"); 
		query.append("''                                                 ,											--ftu_use_ctnt2" ).append("\n"); 
		query.append("''                                                 ,											--ftu_use_ctnt3" ).append("\n"); 
		query.append("''                                                 ,											--ftu_use_ctnt4" ).append("\n"); 
		query.append("''                                                 ,											--ftu_use_ctnt5" ).append("\n"); 
		query.append("SYSDATE             ,											--cre_dt" ).append("\n"); 
		query.append("@[cre_usr_id]		                                            ,										--cre_usr_id" ).append("\n"); 
		query.append("SYSDATE															--eai_evnt_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}