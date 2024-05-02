/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDAOModifytOffInvDtlsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.12 정윤태
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

public class TCharterIOInvoiceDAOModifytOffInvDtlsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOModifytOffInvDtlsUSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOModifytOffInvDtlsUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bunker_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("update fms_inv_dtl" ).append("\n"); 
		query.append("set inv_amt = decode(@[inv_amt],null,@[inv_amt2],@[inv_amt])," ).append("\n"); 
		query.append("vsl_cd = substr(@[bunker_vvd],1,4)," ).append("\n"); 
		query.append("skd_voy_no = substr(@[bunker_vvd],5,4)," ).append("\n"); 
		query.append("skd_dir_cd = substr(@[bunker_vvd],9,1)," ).append("\n"); 
		query.append("rev_dir_cd = substr(@[bunker_vvd],10,1)," ).append("\n"); 
		query.append("inv_desc = decode(@[inv_desc],null,inv_desc,@[inv_desc])," ).append("\n"); 
		query.append("upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt = sysdate" ).append("\n"); 
		query.append("where flet_ctrt_no = @[flet_ctrt_no]" ).append("\n"); 
		query.append("and flet_iss_tp_cd = 'OFF'" ).append("\n"); 
		query.append("and inv_seq = @[inv_seq]" ).append("\n"); 
		query.append("and inv_dtl_seq = @[inv_dtl_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOModifytOffInvDtlsUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}