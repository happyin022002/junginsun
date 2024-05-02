/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueApTaxDBDAOModifyApTaxUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.10.23 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.common.tableSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueApTaxDBDAOModifyApTaxUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyApTax
	  * </pre>
	  */
	public ReceiveQueueApTaxDBDAOModifyApTaxUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fa_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_naid_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aval_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_nsl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_tax_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.common.tableSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueApTaxDBDAOModifyApTaxUSQL").append("\n"); 
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
		query.append("UPDATE ap_tax SET" ).append("\n"); 
		query.append("tax_rt	     = to_number(@[tax_rt])," ).append("\n"); 
		query.append("tax_naid_flg = HJSEAI_PKG.h_decode(@[tax_naid_flg], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("fa_flg       = HJSEAI_PKG.h_decode(@[fa_flg], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("tax_nsl_flg  = HJSEAI_PKG.h_decode(@[tax_nsl_flg], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("cre_dt       = to_date(@[cre_dt],'yyyymmddhh24miss'),cre_usr_id   = @[cre_usr_id]," ).append("\n"); 
		query.append("upd_dt       = to_date(@[upd_dt],'yyyymmddhh24miss'),upd_usr_id   = @[upd_usr_id]," ).append("\n"); 
		query.append("eai_evnt_dt  = to_date(@[eai_evnt_dt],'yyyymmddhh24miss'),aval_flg	  = @[aval_flg]" ).append("\n"); 
		query.append("WHERE 	ap_tax_nm	= HJSEAI_PKG.h_decode(@[ap_tax_nm], 'UTF8' ,'UTF8')" ).append("\n"); 
		query.append("AND	tax_no      = @[tax_no]" ).append("\n"); 
		query.append("AND 	eai_evnt_dt <= to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 

	}
}