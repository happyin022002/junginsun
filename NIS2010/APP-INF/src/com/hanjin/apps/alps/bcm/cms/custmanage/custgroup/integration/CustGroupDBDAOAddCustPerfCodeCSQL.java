/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustGroupDBDAOAddCustPerfCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustGroupDBDAOAddCustPerfCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create Group Customer code
	  * </pre>
	  */
	public CustGroupDBDAOAddCustPerfCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.integration").append("\n"); 
		query.append("FileName : CustGroupDBDAOAddCustPerfCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CUST_PERF_GRP(" ).append("\n"); 
		query.append("	 CUST_GRP_ID" ).append("\n"); 
		query.append(",	 CUST_GRP_NM" ).append("\n"); 
		query.append(",    OFC_CD" ).append("\n"); 
		query.append(",    SREP_CD" ).append("\n"); 
		query.append(",    CRE_USR_ID" ).append("\n"); 
		query.append(",    CRE_DT" ).append("\n"); 
		query.append(",    UPD_USR_ID" ).append("\n"); 
		query.append(",    UPD_DT" ).append("\n"); 
		query.append(",    DELT_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   'G-'||@[rqst_no]" ).append("\n"); 
		query.append(",  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",  OFC_CD" ).append("\n"); 
		query.append(",  SREP_CD" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  'N'" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER_RQST MCR" ).append("\n"); 
		query.append("WHERE MCR.MDM_CUSTOMER_RQST_SEQ = @[rqst_no]" ).append("\n"); 
		query.append("AND MCR.MST_RQST_STS_CD = 'P'" ).append("\n"); 
		query.append("AND MCR.GRP_INDIV_DIV = 'G'" ).append("\n"); 

	}
}