/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAOCreateApInvDTRBASANoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.15
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.06.15 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtDBDAOCreateApInvDTRBASANoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ConsultationSlipRequestMgtDBDAOCreateApInvDTRBASANoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("total_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration").append("\n"); 
		query.append("FileName : ConsultationSlipRequestMgtDBDAOCreateApInvDTRBASANoCSQL").append("\n"); 
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
		query.append("insert into AP_INV_DTRB (" ).append("\n"); 
		query.append("csr_no                                            ," ).append("\n"); 
		query.append("line_seq                                          ," ).append("\n"); 
		query.append("line_no                                           ," ).append("\n"); 
		query.append("line_tp_lu_cd                                     ," ).append("\n"); 
		query.append("inv_amt                                           ," ).append("\n"); 
		query.append("inv_desc                                          ," ).append("\n"); 
		query.append("inv_tax_cd                                        ," ).append("\n"); 
		query.append("dtrb_coa_co_cd                                    ," ).append("\n"); 
		query.append("dtrb_coa_rgn_cd                                   ," ).append("\n"); 
		query.append("dtrb_coa_ctr_cd                                   ," ).append("\n"); 
		query.append("dtrb_coa_acct_cd                                  ," ).append("\n"); 
		query.append("dtrb_coa_vvd_cd                                   ," ).append("\n"); 
		query.append("dtrb_coa_inter_co_cd                              ," ).append("\n"); 
		query.append("dtrb_coa_ftu_n1st_cd                              ," ).append("\n"); 
		query.append("dtrb_coa_ftu_n2nd_cd                              ," ).append("\n"); 
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
		query.append("bkg_no                                            ," ).append("\n"); 
		query.append("cntr_tpsz_cd                                      ," ).append("\n"); 
		query.append("act_vvd_cd                                        ," ).append("\n"); 
		query.append("pln_sctr_div_cd                                   ," ).append("\n"); 
		query.append("so_crr_cd                                         ," ).append("\n"); 
		query.append("yd_cd                                             ," ).append("\n"); 
		query.append("ftu_use_ctnt1                                     ," ).append("\n"); 
		query.append("ftu_use_ctnt2                                     ," ).append("\n"); 
		query.append("ftu_use_ctnt3                                     ," ).append("\n"); 
		query.append("ftu_use_ctnt4                                     ," ).append("\n"); 
		query.append("ftu_use_ctnt5                                     ," ).append("\n"); 
		query.append("cre_dt                                            ," ).append("\n"); 
		query.append("cre_usr_id                                        ," ).append("\n"); 
		query.append("eai_evnt_dt" ).append("\n"); 
		query.append(") values (" ).append("\n"); 
		query.append("@[csr_no]                                              ," ).append("\n"); 
		query.append("@[line_seq]                                            ," ).append("\n"); 
		query.append("@[line_no]                                             ," ).append("\n"); 
		query.append("DECODE(@[acct_cd]||@[cre_tp_cd], '954113P', 'MISCELLANEOUS', 'ITEM') ," ).append("\n"); 
		query.append("@[total_amt]                                           ," ).append("\n"); 
		query.append("(SELECT acct_eng_nm FROM mdm_account WHERE acct_cd = @[acct_cd])," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("'01'                                               ," ).append("\n"); 
		query.append("(SELECT finc_rgn_cd FROM MDM_ORGANIZATION WHERE ofc_cd = @[cost_ofc_cd] AND NVL(delt_flg,'N') = 'N')," ).append("\n"); 
		query.append("(SELECT ap_ctr_cd FROM MDM_ORGANIZATION WHERE ofc_cd = @[cost_ofc_cd] AND NVL(delt_flg,'N') = 'N')," ).append("\n"); 
		query.append("@[acct_cd]                                                 ," ).append("\n"); 
		query.append("'0000000000'                                               ," ).append("\n"); 
		query.append("(SELECT NVL(subs_co_cd, '00') FROM mdm_vendor WHERE vndr_seq = @[vndr_seq])," ).append("\n"); 
		query.append("'000000'                                                  ," ).append("\n"); 
		query.append("'000000'                                                  ," ).append("\n"); 
		query.append("@[acct_cd]                                                ," ).append("\n"); 
		query.append("@[inv_no]                                                 ," ).append("\n"); 
		query.append("@[iss_dt]                                                 ," ).append("\n"); 
		query.append("@[loc_cd]                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("'O'                                                ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("''                                                 ," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])       ," ).append("\n"); 
		query.append("@[cre_usr_id]                                      ," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}