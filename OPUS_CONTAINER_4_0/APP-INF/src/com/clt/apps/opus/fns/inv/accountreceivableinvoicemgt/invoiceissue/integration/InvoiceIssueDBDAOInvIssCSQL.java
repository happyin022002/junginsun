/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvIssCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOInvIssCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIss
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvIssCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_max_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvIssCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_ISS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    INV_NO" ).append("\n"); 
		query.append("    , INV_SEQ" ).append("\n"); 
		query.append("    , INV_ISS_CMB_FLG" ).append("\n"); 
		query.append("    , ISS_OFC_CD" ).append("\n"); 
		query.append("    , ISS_DT" ).append("\n"); 
		query.append("    , USD_XCH_RT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , ISS_GRP_TP_CD" ).append("\n"); 
		query.append(")    " ).append("\n"); 
		query.append("SELECT DISTINCT INV_NO" ).append("\n"); 
		query.append(" 	, '1'" ).append("\n"); 
		query.append("    , 'N'" ).append("\n"); 
		query.append("    , @[ofc_cd]" ).append("\n"); 
		query.append("    , @[iss_dt]" ).append("\n"); 
		query.append("    , '0'" ).append("\n"); 
		query.append("    , @[user_id] " ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[user_id] " ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[iss_grp_tp_cd]" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("		#if (${inv_iss_tp_cd} == 'E')" ).append("\n"); 
		query.append("    		@[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + DENSE_RANK() OVER (ORDER BY BL_SRC_NO, AR_IF_NO), 7, '0') INV_NO" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("    		#if (${inv_mlt_bl_iss_flg} == 'N')" ).append("\n"); 
		query.append("        		#if (${iss_grp_tp_cd} == 'V')" ).append("\n"); 
		query.append("            		@[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + DENSE_RANK() OVER (ORDER BY BL_SRC_NO, DECODE(INV_SPLIT_CD, 'S', AR_IF_NO, ''), ACT_CUST_CNT_CD, ACT_CUST_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, IO_BND_CD, PORT_CD, SVC_SCP_CD, INV_CURR_CD, USD_XCH_RT, (SELECT LOCL_CURR_CD FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO)), 7, '0') INV_NO" ).append("\n"); 
		query.append("        		#else" ).append("\n"); 
		query.append("            		@[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + DENSE_RANK() OVER (ORDER BY BL_SRC_NO, DECODE(INV_SPLIT_CD, 'S', AR_IF_NO, ''), ACT_CUST_CNT_CD, ACT_CUST_SEQ, INV_CURR_CD, USD_XCH_RT, (SELECT LOCL_CURR_CD FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO)), 7, '0') INV_NO" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("    		#else" ).append("\n"); 
		query.append("        		#if (${iss_grp_tp_cd} == 'V')" ).append("\n"); 
		query.append("            		@[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + DENSE_RANK() OVER (ORDER BY DECODE(INV_SPLIT_CD, 'S', BL_SRC_NO, ''), DECODE(INV_SPLIT_CD, 'S', AR_IF_NO, ''), ACT_CUST_CNT_CD, ACT_CUST_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, IO_BND_CD, PORT_CD, SVC_SCP_CD, INV_CURR_CD, USD_XCH_RT, (SELECT LOCL_CURR_CD FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO)), 7, '0') INV_NO        " ).append("\n"); 
		query.append("        		#else" ).append("\n"); 
		query.append("            		@[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + DENSE_RANK() OVER (ORDER BY DECODE(INV_SPLIT_CD, 'S', BL_SRC_NO, ''), DECODE(INV_SPLIT_CD, 'S', AR_IF_NO, ''), ACT_CUST_CNT_CD, ACT_CUST_SEQ, INV_CURR_CD, USD_XCH_RT, (SELECT LOCL_CURR_CD FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO)), 7, '0') INV_NO" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		FROM INV_AR_ISS_FTR A" ).append("\n"); 
		query.append("		WHERE INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}