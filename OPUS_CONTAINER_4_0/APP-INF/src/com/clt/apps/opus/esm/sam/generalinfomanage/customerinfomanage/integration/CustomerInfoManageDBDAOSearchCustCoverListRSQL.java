/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustCoverListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2015.11.03 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYEONGMI KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustCoverListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustCoverList
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustCoverListRSQL(){
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
		query.append("FileName : CustomerInfoManageDBDAOSearchCustCoverListRSQL").append("\n"); 
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
		query.append("SELECT SREP_PRMRY_FLG" ).append("\n"); 
		query.append("     , SUBSTR(SREP_NM,INSTR(SREP_NM,' ',1,1),LENGTH(SREP_NM)) AS SREP_FT_NM" ).append("\n"); 
		query.append("     , SUBSTR(SREP_NM,1,INSTR(SREP_NM,' ',1,1)) AS SREP_LT_NM" ).append("\n"); 
		query.append("     , SREP_ABBR_NM" ).append("\n"); 
		query.append("     , MDM_SLS_REP.SREP_CD" ).append("\n"); 
		query.append("	 , ( DECODE(IB_SREP_FLG, 'Y', 'IB', '')||" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			    SELECT ','" ).append("\n"); 
		query.append("      			  FROM DUAL" ).append("\n"); 
		query.append("     			 WHERE 1=1 " ).append("\n"); 
		query.append("     			   AND (IB_SREP_FLG='Y' AND OB_SREP_FLG='Y')" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("       || DECODE(OB_SREP_FLG, 'Y', 'OB', '')) AS SREP_FLG" ).append("\n"); 
		query.append("     , MDM_SLS_REP.OFC_CD" ).append("\n"); 
		query.append("     , PRNT_OFC_CD" ).append("\n"); 
		query.append("     , INTL_MPHN_NO AS MPHN_NO" ).append("\n"); 
		query.append("	 , CUST_CNT_CD" ).append("\n"); 
		query.append("	 , CUST_SEQ" ).append("\n"); 
		query.append("	 , MDM_SLS_REP.SREP_CD AS PRE_SREP_CD" ).append("\n"); 
		query.append("	 , SAM_CUST_SLS_REP_INFO.DELT_FLG AS DELT_FLG" ).append("\n"); 
		query.append("FROM SAM_CUST_SLS_REP_INFO, MDM_SLS_REP, MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE SAM_CUST_SLS_REP_INFO.SREP_CD = MDM_SLS_REP.SREP_CD" ).append("\n"); 
		query.append("AND MDM_SLS_REP.OFC_CD = MDM_ORGANIZATION.OFC_CD" ).append("\n"); 
		query.append("AND CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("AND SAM_CUST_SLS_REP_INFO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY SREP_PRMRY_FLG DESC" ).append("\n"); 

	}
}