/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustGroupDBDAOSearchCustPerfCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.09 
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

public class CustGroupDBDAOSearchCustPerfCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Customer detail
	  * </pre>
	  */
	public CustGroupDBDAOSearchCustPerfCodeRSQL(){
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
		query.append("FileName : CustGroupDBDAOSearchCustPerfCodeRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    CUST_GRP_NM" ).append("\n"); 
		query.append(",   OFC_CD" ).append("\n"); 
		query.append(",   SREP_CD" ).append("\n"); 
		query.append(",   VBS_CLSS_CD" ).append("\n"); 
		query.append(",   NBS_CLSS_CD1" ).append("\n"); 
		query.append(",   NBS_CLSS_CD2" ).append("\n"); 
		query.append(",   NBS_CLSS_CD3" ).append("\n"); 
		query.append(",   CRE_USR_ID" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(",   DELT_FLG" ).append("\n"); 
		query.append(",   PRMRY_CUST_CNT_CD CUST_CNT_CD" ).append("\n"); 
		query.append(",   PRMRY_CUST_SEQ CUST_SEQ" ).append("\n"); 
		query.append(",   PRMRY_CUST_CNT_CD||lpad(PRMRY_CUST_SEQ, 6, 0) CUST_CD " ).append("\n"); 
		query.append(",   DECODE(DELT_FLG,'Y','D','A') CUST_STS_CD" ).append("\n"); 
		query.append(",   'G' GRP_INDIV_DIV" ).append("\n"); 
		query.append(",   CUST_GRP_ID" ).append("\n"); 
		query.append("FROM MDM_CUST_PERF_GRP" ).append("\n"); 
		query.append("WHERE CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 

	}
}