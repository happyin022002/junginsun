/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustGroupDBDAOSearchCustGroupDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustGroupDBDAOSearchCustGroupDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Customer Detail
	  * </pre>
	  */
	public CustGroupDBDAOSearchCustGroupDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custgroup.integration").append("\n"); 
		query.append("FileName : CustGroupDBDAOSearchCustGroupDetailRSQL").append("\n"); 
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
		query.append("SELECT MC.CUST_CNT_CD" ).append("\n"); 
		query.append("     , MC.CUST_SEQ" ).append("\n"); 
		query.append("     , MC.CUST_CNT_CD||TRIM(TO_CHAR(MC.CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append("     , MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , MC.LOC_CD" ).append("\n"); 
		query.append("     , MC.SREP_CD" ).append("\n"); 
		query.append("     , MC.OFC_CD" ).append("\n"); 
		query.append("     , DECODE(MC.CUST_CNT_CD||MC.CUST_SEQ,MCPG.PRMRY_CUST_CNT_CD||MCPG.PRMRY_CUST_SEQ,'Y','N') PRMRY_CHK_FLG" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("	 ,MDM_CUST_PERF_GRP MCPG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND MC.CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 
		query.append("AND MC.CUST_GRP_ID = MCPG.CUST_GRP_ID" ).append("\n"); 

	}
}