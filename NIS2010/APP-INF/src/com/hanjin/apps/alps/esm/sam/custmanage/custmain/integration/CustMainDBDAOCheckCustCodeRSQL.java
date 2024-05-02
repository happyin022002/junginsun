/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustMainDBDAOCheckCustCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOCheckCustCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check customer code
	  * </pre>
	  */
	public CustMainDBDAOCheckCustCodeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOCheckCustCodeRSQL").append("\n"); 
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
		query.append("SELECT CUST_CNT_CD||CUST_SEQ CUST_CD" ).append("\n"); 
		query.append("	   ,SREP_CD" ).append("\n"); 
		query.append("       ,(SELECT MCPG.CUST_GRP_ID FROM MDM_CUST_PERF_GRP MCPG WHERE MCPG.CUST_GRP_ID = 'G-'||MC.CUST_CNT_CD||TRIM(TO_CHAR(MC.CUST_SEQ,'000000')) AND ROWNUM = 1) GRP_ID_CHK" ).append("\n"); 
		query.append("       ,(SELECT MCPG.CUST_GRP_ID FROM MDM_CUST_PERF_GRP MCPG WHERE MCPG.PRMRY_CUST_CNT_CD = MC.CUST_CNT_CD AND MCPG.PRMRY_CUST_SEQ = MC.CUST_SEQ) GRP_PRMRY_CHK" ).append("\n"); 
		query.append("       ,MC.LOC_CD" ).append("\n"); 
		query.append("       ,MC.OFC_CD" ).append("\n"); 
		query.append("       ,REPLACE(MC.CUST_LGL_ENG_NM,',',' ') CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("AND MC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD <> 'TB'" ).append("\n"); 

	}
}