/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchCustomerInqueryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.21
*@LastModifier : 김인규
*@LastVersion : 1.0
* 2015.01.21 김인규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author In Gyu Kim
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
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
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
		query.append("	grp.edi_grp_desc," ).append("\n"); 
		query.append("    cust.cust_cnt_cd,cust.cust_seq" ).append("\n"); 
		query.append("from edi_group grp, edi_grp_cust cust" ).append("\n"); 
		query.append("where grp.edi_grp_cd = cust.edi_grp_cd" ).append("\n"); 
		query.append("and grp.co_div_cd = cust.co_div_cd" ).append("\n"); 
		query.append("#if(${cs_cd} != '')" ).append("\n"); 
		query.append("and cust.cust_cnt_cd||cust.cust_seq = @[cs_cd]" ).append("\n"); 
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

	}
}