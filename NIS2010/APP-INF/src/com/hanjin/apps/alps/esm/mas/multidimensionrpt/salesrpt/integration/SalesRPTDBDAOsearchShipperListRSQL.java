/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRPTDBDAOsearchShipperListRSQL.java
*@FileTitle : Shipper Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.08 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOsearchShipperListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SalesRPTDBDAOsearchShipperListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOsearchShipperListRSQL").append("\n"); 
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
		query.append("SELECT	cust_cnt_cd, cust_seq, modi_cust_cnt_cd, modi_cust_seq, cust_lgl_eng_nm,rvis_cntr_cust_tp_cd,ofc_cd" ).append("\n"); 
		query.append("FROM	mdm_customer" ).append("\n"); 
		query.append("WHERE	delt_flg    <> 'Y'" ).append("\n"); 
		query.append("AND		cust_cnt_cd = @[f_cust_cnt_cd]" ).append("\n"); 
		query.append("#if(${f_cust_seq} != '' )" ).append("\n"); 
		query.append("AND		cust_seq    = to_number( @[f_cust_seq] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER	BY cust_cnt_cd, cust_seq" ).append("\n"); 

	}
}