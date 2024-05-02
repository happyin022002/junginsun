/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchCustomerDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchCustomerDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomerData
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchCustomerDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cs_tp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cs_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchCustomerDataRSQL").append("\n"); 
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
		query.append("        rownum " ).append("\n"); 
		query.append("      , grp.edi_grp_cd edi_grp_cd                                  " ).append("\n"); 
		query.append("      , grp.edi_grp_desc edi_grp_desc                             " ).append("\n"); 
		query.append("      , grp.cust_trd_prnr_id cust_trd_prnr_id                       " ).append("\n"); 
		query.append("      , grp.prov_trd_prnr_id prov_trd_prnr_id                       " ).append("\n"); 
		query.append("	  , nvl2(trim(cust.cust_cnt_cd), cust.cust_cnt_cd||cust.cust_seq, '') cust_id -- modification                   " ).append("\n"); 
		query.append("      , mc.cust_lgl_eng_nm cust_lgl_eng_nm                          " ).append("\n"); 
		query.append("      , cust.sc_no sc_no                                            " ).append("\n"); 
		query.append("      , cust.sc_eff_st_dt sc_eff_st_dt                              " ).append("\n"); 
		query.append("      , cust.sc_eff_end_dt sc_eff_end_dt                            " ).append("\n"); 
		query.append("      from edi_group grp, edi_grp_cust cust, mdm_customer mc       " ).append("\n"); 
		query.append("      where grp.edi_grp_cd = cust.edi_grp_cd                       " ).append("\n"); 
		query.append("            and grp.co_div_cd = cust.co_div_cd                     " ).append("\n"); 
		query.append("            and cust.cust_cnt_cd = mc.cust_cnt_cd(+)                  " ).append("\n"); 
		query.append("            and cust.cust_seq = mc.cust_seq(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cs_grp_id} != '')" ).append("\n"); 
		query.append("and grp.edi_grp_cd  = @[cs_grp_id]           " ).append("\n"); 
		query.append("#end                                       " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if (${cs_tp_id} != '')                               " ).append("\n"); 
		query.append("and grp.cust_trd_prnr_id =  @[cs_tp_id]     " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                                       " ).append("\n"); 
		query.append("#if (${hj_tp_id} != '')                                       " ).append("\n"); 
		query.append("and grp.prov_trd_prnr_id =   @[hj_tp_id]     " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                                       " ).append("\n"); 
		query.append("#if (${cs_cd} != '')                                       " ).append("\n"); 
		query.append("and (cust.cust_cnt_cd||cust.cust_seq) = @[cs_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("#if (${sc_no} != '')                                       " ).append("\n"); 
		query.append("and cust.sc_no =   @[sc_no]                " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}