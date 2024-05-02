/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchCustomerInqueryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchCustomerInqueryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomerInquery
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchCustomerInqueryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hj_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchCustomerInqueryRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("	distinct grp.edi_grp_cd," ).append("\n"); 
		query.append("	grp.cust_trd_prnr_id," ).append("\n"); 
		query.append("	grp.edi_grp_desc" ).append("\n"); 
		query.append("from edi_group grp, edi_grp_cust cust" ).append("\n"); 
		query.append("where grp.edi_grp_cd = cust.edi_grp_cd" ).append("\n"); 
		query.append("and grp.co_div_cd = cust.co_div_cd" ).append("\n"); 
		query.append("#if(${cs_cd} != '')" ).append("\n"); 
		query.append("and cust.cust_cnt_cd||LPAD(cust.cust_seq,6,'0') = SUBSTR(@[cs_cd],1,2)||LPAD(SUBSTR(@[cs_cd],3,6),6,'0')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sc_no} != '')" ).append("\n"); 
		query.append("and cust.sc_no = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${tp_id} != '')" ).append("\n"); 
		query.append("and grp.cust_trd_prnr_id = @[tp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cs_nm} != '')" ).append("\n"); 
		query.append("and upper(edi_grp_desc) like '%' || @[cs_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${hj_tp_id} != '') " ).append("\n"); 
		query.append("AND grp.PROV_TRD_PRNR_ID = @[hj_tp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}