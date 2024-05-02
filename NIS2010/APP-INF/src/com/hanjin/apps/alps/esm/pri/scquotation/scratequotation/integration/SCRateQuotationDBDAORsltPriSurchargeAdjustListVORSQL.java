/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAORsltPriSurchargeAdjustListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.11.12 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateQuotationDBDAORsltPriSurchargeAdjustListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRS-Surcharge Adjust 조회   
	  * </pre>
	  */
	public SCRateQuotationDBDAORsltPriSurchargeAdjustListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAORsltPriSurchargeAdjustListVORSQL").append("\n"); 
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
		query.append("SELECT qttn_no," ).append("\n"); 
		query.append("qttn_ver_no," ).append("\n"); 
		query.append("gen_spcl_rt_tp_cd," ).append("\n"); 
		query.append("scg_adj_seq," ).append("\n"); 
		query.append("prc_cmdt_tp_cd," ).append("\n"); 
		query.append("prc_cmdt_def_cd," ).append("\n"); 
		query.append("org_loc_tp_cd," ).append("\n"); 
		query.append("org_loc_def_cd," ).append("\n"); 
		query.append("org_via_loc_tp_cd," ).append("\n"); 
		query.append("org_via_loc_def_cd," ).append("\n"); 
		query.append("dest_via_loc_tp_cd," ).append("\n"); 
		query.append("dest_via_loc_def_cd," ).append("\n"); 
		query.append("dest_loc_tp_cd," ).append("\n"); 
		query.append("dest_loc_def_cd," ).append("\n"); 
		query.append("prc_rcv_term_cd," ).append("\n"); 
		query.append("prc_de_term_cd," ).append("\n"); 
		query.append("bkg_rat_ut_cd," ).append("\n"); 
		query.append("prc_cgo_tp_cd," ).append("\n"); 
		query.append("chg_cd," ).append("\n"); 
		query.append("curr_cd," ).append("\n"); 
		query.append("adj_scg_amt," ).append("\n"); 
		query.append("adj_scg_usd_amt," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append("FROM pri_sq_scg_adj" ).append("\n"); 
		query.append("WHERE qttn_no = @[qttn_no]" ).append("\n"); 
		query.append("and qttn_ver_no = @[qttn_ver_no]" ).append("\n"); 
		query.append("and gen_spcl_rt_tp_cd=@[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("ORDER BY prc_cmdt_def_cd,org_loc_def_cd,org_via_loc_def_cd,dest_via_loc_def_cd,dest_loc_def_cd" ).append("\n"); 

	}
}