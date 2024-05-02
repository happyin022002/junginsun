/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustRefPartyManageDBDAOaddCustRefPartyManageCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2010.05.20 김종호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustRefPartyManageDBDAOaddCustRefPartyManageCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public CustRefPartyManageDBDAOaddCustRefPartyManageCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_req_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crm_row_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_addr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fctry_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fctry_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.integration").append("\n"); 
		query.append("FileName : CustRefPartyManageDBDAOaddCustRefPartyManageCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_ACT_CUST_ADDR (" ).append("\n"); 
		query.append("		  CRM_ROW_ID" ).append("\n"); 
		query.append("		, ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("	    , ACT_CUST_SEQ" ).append("\n"); 
		query.append("	    , FCTRY_NM" ).append("\n"); 
		query.append("	    , FCTRY_ADDR" ).append("\n"); 
		query.append("	    , CNTC_PSON_NM" ).append("\n"); 
		query.append("	    , ACT_CUST_PST_CD" ).append("\n"); 
		query.append("	    , CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("	    , CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("	    , CNTC_PSON_REQ_RMK" ).append("\n"); 
		query.append("	    , ACT_CUST_ADDR_SEQ" ).append("\n"); 
		query.append("	    , EAI_EVNT_DT" ).append("\n"); 
		query.append("	    , CRE_USR_ID" ).append("\n"); 
		query.append("	    , CRE_DT" ).append("\n"); 
		query.append("	    , UPD_USR_ID" ).append("\n"); 
		query.append("	    , UPD_DT " ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("		  @[crm_row_id]" ).append("\n"); 
		query.append("		, @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("		, TO_NUMBER(@[act_cust_seq])" ).append("\n"); 
		query.append("		, @[fctry_nm]" ).append("\n"); 
		query.append("		, @[fctry_addr]" ).append("\n"); 
		query.append("		, @[cntc_pson_nm]" ).append("\n"); 
		query.append("		, @[act_cust_pst_cd]" ).append("\n"); 
		query.append("		, @[cntc_pson_phn_no]" ).append("\n"); 
		query.append("		, @[cntc_pson_fax_no]" ).append("\n"); 
		query.append("		, @[cntc_pson_req_rmk]" ).append("\n"); 
		query.append("		, @[act_cust_addr_seq]" ).append("\n"); 
		query.append("		, TO_DATE(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append("		, 'MIG_USER'" ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("		, 'MIG_USER'" ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}