/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeBasicInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeBasicInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOndockRailChargeBasicInfo
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeBasicInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeBasicInfoRSQL").append("\n"); 
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
		query.append("SELECT   tml_so_ofc_cty_cd ,         " ).append("\n"); 
		query.append("		  tml_so_seq,         " ).append("\n"); 
		query.append("		  inv_ofc_cd,         " ).append("\n"); 
		query.append("		  cost_ofc_cd,         " ).append("\n"); 
		query.append("		  inv_no,         " ).append("\n"); 
		query.append("		  LPAD(vndr_seq, 6, '0') vndr_seq,         " ).append("\n"); 
		query.append("		  yd_cd,         " ).append("\n"); 
		query.append("		  TES_GET_YARDNM_FNC(yd_cd) yd_nm,         " ).append("\n"); 
		query.append("		  curr_cd,         " ).append("\n"); 
		query.append("		  ttl_inv_amt,         " ).append("\n"); 
		query.append("		  vat_amt,         " ).append("\n"); 
		query.append("		  whld_tax_amt,         " ).append("\n"); 
		query.append("		  ttl_calc_amt,         " ).append("\n"); 
		query.append("		  TO_CHAR(TO_DATE(fm_prd_dt,'YYYYMMDD'),'YYYY-MM-DD') 	fm_prd_dt,        " ).append("\n"); 
		query.append("		  hld_flg,         " ).append("\n"); 
		query.append("		  hld_rmk,         " ).append("\n"); 
		query.append("		  TO_CHAR(TO_DATE(to_prd_dt,'YYYYMMDD'),'YYYY-MM-DD')  to_prd_dt,        " ).append("\n"); 
		query.append("		  tml_inv_tp_cd,         " ).append("\n"); 
		query.append("		  tml_cost_grp_cd,         " ).append("\n"); 
		query.append("		  tml_calc_ind_cd,         " ).append("\n"); 
		query.append("		  sto_dys_ind_cd,         " ).append("\n"); 
		query.append("		  TO_CHAR(iss_dt,'YYYY-MM-DD') ISS_DT,         " ).append("\n"); 
		query.append("		  TO_CHAR(rcv_dt,'YYYY-MM-DD') RCV_DT,         " ).append("\n"); 
		query.append("		  TO_CHAR(eff_dt,'YYYY-MM-DD') EFF_DT,         " ).append("\n"); 
		query.append("		  TO_CHAR(pay_due_dt,'YYYY-MM-DD') PAY_DUE_DT,         " ).append("\n"); 
		query.append("		  pay_flg,         " ).append("\n"); 
		query.append("		  tml_inv_sts_cd,         " ).append("\n"); 
		query.append("		  COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00172',TML_INV_STS_CD) TML_INV_STS_NM, 	" ).append("\n"); 
		query.append("		  tml_inv_rjct_sts_cd,         " ).append("\n"); 
		query.append("		  TO_CHAR(inv_cfm_dt,'YYYY-MM-DD') INV_CFM_DT,         " ).append("\n"); 
		query.append("		  inv_rjct_rmk,         " ).append("\n"); 
		query.append("		  cre_usr_id,         " ).append("\n"); 
		query.append("		  TO_CHAR(cre_dt,'YYYY-MM-DD') CRE_DT,         " ).append("\n"); 
		query.append("		  upd_usr_id,         " ).append("\n"); 
		query.append("		  TO_CHAR(upd_dt,'YYYY-MM-DD') UPD_DT," ).append("\n"); 
		query.append("		  rtro_tml_inv_flg," ).append("\n"); 
		query.append("		  TO_CHAR(TO_DATE(wrk_dt,'YYYYMMDD'),'YYYY-MM-DD') WRK_DT," ).append("\n"); 
		query.append("		  COST_CD_FTR_RMK	                    " ).append("\n"); 
		query.append("  FROM TES_TML_SO_HDR                                                        " ).append("\n"); 
		query.append("  WHERE VNDR_SEQ = @[vndr_seq]                                                   	  " ).append("\n"); 
		query.append("  AND   INV_NO   = @[inv_no]                                                   	  " ).append("\n"); 
		query.append("  AND   NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}