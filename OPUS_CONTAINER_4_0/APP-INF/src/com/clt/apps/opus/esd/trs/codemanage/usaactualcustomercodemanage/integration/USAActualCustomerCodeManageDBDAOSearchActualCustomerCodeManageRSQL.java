/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : USAActualCustomerCodeManageDBDAOSearchActualCustomerCodeManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USAActualCustomerCodeManageDBDAOSearchActualCustomerCodeManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Cost Code 상세조회
	  * </pre>
	  */
	public USAActualCustomerCodeManageDBDAOSearchActualCustomerCodeManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_act_cust_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration").append("\n"); 
		query.append("FileName : USAActualCustomerCodeManageDBDAOSearchActualCustomerCodeManageRSQL").append("\n"); 
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
		query.append("trsp_act_cust_no  ," ).append("\n"); 
		query.append("trsp_act_cust_seq ," ).append("\n"); 
		query.append("delt_flg," ).append("\n"); 
		query.append("dflt_act_cust_flg," ).append("\n"); 
		query.append("act_cust_nm," ).append("\n"); 
		query.append("act_cust_zip_cd," ).append("\n"); 
		query.append("act_cust_addr," ).append("\n"); 
		query.append("act_cust_phn_no," ).append("\n"); 
		query.append("act_cust_fax_no," ).append("\n"); 
		query.append("cntc_pson_nm," ).append("\n"); 
		query.append("act_cust_eml," ).append("\n"); 
		query.append("act_cust_rmk," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("to_char(cre_dt,'YYYYMMDD') cre_dt," ).append("\n"); 
		query.append("cre_ofc_cd," ).append("\n"); 
		query.append("to_char(delt_dt,'YYYYMMDD') delt_dt," ).append("\n"); 
		query.append("delt_ofc_cd," ).append("\n"); 
		query.append("delt_usr_id," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("to_char(upd_dt,'YYYYMMDD')   upd_dt" ).append("\n"); 
		query.append("FROM  TRS_TRSP_USA_ACT_CUST_DTL" ).append("\n"); 
		query.append("WHERE trsp_act_cust_no = @[trsp_act_cust_no]" ).append("\n"); 
		query.append("ORDER BY trsp_act_cust_seq" ).append("\n"); 

	}
}