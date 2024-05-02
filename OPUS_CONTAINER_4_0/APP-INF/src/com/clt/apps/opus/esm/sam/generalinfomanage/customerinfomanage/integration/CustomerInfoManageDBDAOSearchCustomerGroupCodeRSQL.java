/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustomerGroupCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustomerGroupCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_CUST_PERF_GRP, MDM_CUSTOMER
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustomerGroupCodeRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchCustomerGroupCodeRSQL").append("\n"); 
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
		query.append("SELECT    M.CUST_GRP_ID   --AS Group Code" ).append("\n"); 
		query.append("        , M.CUST_GRP_NM AS CUST_LGL_ENG_NM -- Customer Group Name" ).append("\n"); 
		query.append("		, M.OFC_CD   -- Ofc Code" ).append("\n"); 
		query.append("        , M.SREP_CD" ).append("\n"); 
		query.append("        , M.VBS_CLSS_CD" ).append("\n"); 
		query.append("        , M.NBS_CLSS_CD1" ).append("\n"); 
		query.append("        , M.NBS_CLSS_CD2" ).append("\n"); 
		query.append("        , M.NBS_CLSS_CD3" ).append("\n"); 
		query.append("        , M.CRE_USR_ID" ).append("\n"); 
		query.append("        , M.CRE_DT" ).append("\n"); 
		query.append("        , M.UPD_USR_ID" ).append("\n"); 
		query.append("        , TO_CHAR(UPD_DT,'YYYY-MM-DD') AS UPD_DT --, M.UPD_DT" ).append("\n"); 
		query.append("        , M.DELT_FLG" ).append("\n"); 
		query.append("        , M.EAI_EVNT_DT" ).append("\n"); 
		query.append("        , M.EAI_IF_ID" ).append("\n"); 
		query.append("        , M.CUST_GRP_ABBR_NM" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("            SELECT COUNT(C.CUST_GRP_ID) " ).append("\n"); 
		query.append("              FROM MDM_CUSTOMER C " ).append("\n"); 
		query.append("             WHERE C.CUST_GRP_ID = M.CUST_GRP_ID" ).append("\n"); 
		query.append("               AND C.CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("          ) AS MEMBER -- MEMBER (MDM_CUSTOMER)" ).append("\n"); 
		query.append("        , '' LOC_CD" ).append("\n"); 
		query.append("        , '' CUST_GRP_NM" ).append("\n"); 
		query.append("        , '' MATCH_RULE" ).append("\n"); 
		query.append("        , '' CUST_CD" ).append("\n"); 
		query.append("        , '' CUST_CNT_CD" ).append("\n"); 
		query.append("        , '' CUST_SEQ" ).append("\n"); 
		query.append("  FROM MDM_CUST_PERF_GRP M" ).append("\n"); 
		query.append("/* 1) */" ).append("\n"); 
		query.append("WHERE 1=1  " ).append("\n"); 
		query.append("#if(${match_rule} == 'D' && ${cust_grp_nm} != '')  -- Start with " ).append("\n"); 
		query.append("   AND Upper(CUST_GRP_NM) LIKE Upper(@[cust_grp_nm])||'%'-- Cust. Code " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${match_rule} == 'I' && ${cust_grp_nm} != '')  -- Include  " ).append("\n"); 
		query.append("   AND Upper(CUST_GRP_NM) LIKE '%'||Upper(@[cust_grp_nm])||'%'-- Cust. Code " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${match_rule} == 'A' && ${cust_grp_nm} != '')  -- Exact      " ).append("\n"); 
		query.append("   AND Upper(CUST_GRP_NM) = Upper(@[cust_grp_nm])-- Cust. Code " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${cust_grp_id} != '') " ).append("\n"); 
		query.append("    AND Upper(CUST_GRP_ID) LIKE Upper(@[cust_grp_id])||'%' -- Group ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* 2) */" ).append("\n"); 
		query.append("#if(${cust_grp_abbr_nm} != '') " ).append("\n"); 
		query.append("    AND Upper(CUST_GRP_ABBR_NM) = Upper(@[cust_grp_abbr_nm])-- Abbr " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}