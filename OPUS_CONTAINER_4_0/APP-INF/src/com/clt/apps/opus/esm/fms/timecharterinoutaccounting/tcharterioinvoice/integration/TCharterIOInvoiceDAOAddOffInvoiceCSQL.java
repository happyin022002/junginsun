/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDAOAddOffInvoiceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.15
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.15 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class TCharterIOInvoiceDAOAddOffInvoiceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOAddOffInvoiceCSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOAddOffInvoiceCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_usd_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_offh_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acmm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("insert into fms_invoice (" ).append("\n"); 
		query.append("flet_ctrt_no," ).append("\n"); 
		query.append("flet_iss_tp_cd," ).append("\n"); 
		query.append("inv_seq," ).append("\n"); 
		query.append("eff_dt," ).append("\n"); 
		query.append("exp_dt," ).append("\n"); 
		query.append("inv_usd_dys," ).append("\n"); 
		query.append("offh_seq," ).append("\n"); 
		query.append("acmm_flg," ).append("\n"); 
		query.append("brog_flg," ).append("\n"); 
		query.append("flet_offh_rsn_cd," ).append("\n"); 
		query.append("vsl_cd," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append(") values(" ).append("\n"); 
		query.append("@[flet_ctrt_no]," ).append("\n"); 
		query.append("'OFF'," ).append("\n"); 
		query.append("(select nvl(max(inv_seq),0) +1 from fms_invoice where flet_ctrt_no = @[flet_ctrt_no] and flet_iss_tp_cd = 'OFF')," ).append("\n"); 
		query.append("to_date(@[ori_eff_dt],'yyyymmddhh24:mi')," ).append("\n"); 
		query.append("to_date(@[ori_exp_dt],'yyyymmddhh24:mi')," ).append("\n"); 
		query.append("@[inv_usd_dys]," ).append("\n"); 
		query.append("decode(@[offh_seq],NULL,NULL,@[offh_seq])," ).append("\n"); 
		query.append("decode(@[acmm_flg],NULL,'N','Y')," ).append("\n"); 
		query.append("decode(@[brog_flg],NULL,'N','Y')," ).append("\n"); 
		query.append("@[flet_offh_rsn_cd]," ).append("\n"); 
		query.append("@[vsl_cd]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOAddOffInvoiceCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}