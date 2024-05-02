/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VoMakeDAOSearchFACAGMTRateInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoMakeDAOSearchFACAGMTRateInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public VoMakeDAOSearchFACAGMTRateInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.vo").append("\n"); 
		query.append("FileName : VoMakeDAOSearchFACAGMTRateInfoVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' fac_bx_amt                       " ).append("\n"); 
		query.append(", '' curr_cd                          " ).append("\n"); 
		query.append(", '' fac_ofc_cd                       " ).append("\n"); 
		query.append(", '' fac_agmt_seq                     " ).append("\n"); 
		query.append(", '' ff_cust_seq                      " ).append("\n"); 
		query.append(", '' ofc_odr                          " ).append("\n"); 
		query.append(", '' fac_spcl_feu_amt                 " ).append("\n"); 
		query.append(", '' fac_sgl_flg                      " ).append("\n"); 
		query.append(", '' fac_dry_feu_amt                  " ).append("\n"); 
		query.append(", '' fac_div_cd                       " ).append("\n"); 
		query.append(", '' fac_bkg_amt                      " ).append("\n"); 
		query.append(", '' fac_spcl_cntr_rt2                " ).append("\n"); 
		query.append(", '' fac_spcl_cntr_tp_ctnt1           " ).append("\n"); 
		query.append(", '' fac_spcl_cntr_rt1                " ).append("\n"); 
		query.append(", '' fac_rf_teu_amt                   " ).append("\n"); 
		query.append(", '' shpr_cnt_cd                      " ).append("\n"); 
		query.append(", '' fac_rf_feu_amt                   " ).append("\n"); 
		query.append(", '' fac_spcl_cntr_tp_ctnt2           " ).append("\n"); 
		query.append(", '' rout_cd                          " ).append("\n"); 
		query.append(", '' odr                              " ).append("\n"); 
		query.append(", '' fac_spcl_teu_amt                 " ).append("\n"); 
		query.append(", '' fac_dry_teu_amt                  " ).append("\n"); 
		query.append(", '' fac_chg_ctnt                     " ).append("\n"); 
		query.append(", '' shpr_cust_seq                    " ).append("\n"); 
		query.append(", '' ff_cnt_cd                        " ).append("\n"); 
		query.append(", '' fac_bkg_rt " ).append("\n"); 
		query.append(", '' grs_net_div_cd " ).append("\n"); 
		query.append(", '' FAC_RT_OFC_CD                     " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}