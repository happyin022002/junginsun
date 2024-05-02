/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchMyCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.01.28 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchMyCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMyCustomer
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchMyCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchMyCustomerRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("edi_grp_cd," ).append("\n"); 
		query.append("cust_trd_prnr_id," ).append("\n"); 
		query.append("edi_grp_desc" ).append("\n"); 
		query.append("from edi_usr_cust" ).append("\n"); 
		query.append("where edi_sts_seq = 1" ).append("\n"); 
		query.append("and cre_usr_id = @[f_user_id]" ).append("\n"); 

	}
}