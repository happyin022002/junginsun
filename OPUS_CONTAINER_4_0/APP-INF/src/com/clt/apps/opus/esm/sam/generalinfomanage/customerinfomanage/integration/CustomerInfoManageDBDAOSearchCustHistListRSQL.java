/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustHistListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.09
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.03.09 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustHistListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustHistList
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustHistListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchCustHistListRSQL").append("\n"); 
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
		query.append("SELECT CUST_HIS_SEQ" ).append("\n"); 
		query.append("     , DECODE(cng_itm_cd,0,'Customer Name',1,'Office Code',2,'Status',3,'Sales Rep Code'," ).append("\n"); 
		query.append("              4,'Type',5,'Firm/Private',6,'Location',7,'Registration'," ).append("\n"); 
		query.append("              8,'Key Account',9,'Group Customer',10,'Multi Trade Account'," ).append("\n"); 
		query.append("              11,'Creator',12,'Office Name',13,'Sales Rep Name',14,'Phone No'," ).append("\n"); 
		query.append("              15,'Fax No',16,'Email',17,'Address',18,'User Name',19,'User ID','N/A'" ).append("\n"); 
		query.append("      ) AS CNG_ITM_CD" ).append("\n"); 
		query.append("     , OLD_VAL_DESC" ).append("\n"); 
		query.append("     , NEW_VAL_DESC" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("FROM SAM_CUST_HIS" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("ORDER BY CUST_HIS_SEQ DESC" ).append("\n"); 

	}
}