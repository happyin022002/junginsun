/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvIssDtlCSQL.java
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

public class InvoiceIssueDBDAOInvIssDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssDtl
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvIssDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvIssDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_ISS_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    INV_NO" ).append("\n"); 
		query.append("    , AR_IF_NO" ).append("\n"); 
		query.append("    , CHG_SEQ" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${inv_iss_tp_cd} == 'E')" ).append("\n"); 
		query.append("    @[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + DENSE_RANK() OVER (ORDER BY A.BL_SRC_NO, A.AR_IF_NO), 7, '0') INV_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${inv_mlt_bl_iss_flg} == 'N')" ).append("\n"); 
		query.append("        #if (${iss_grp_tp_cd} == 'V')" ).append("\n"); 
		query.append("            @[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + DENSE_RANK() OVER (ORDER BY A.BL_SRC_NO, DECODE(A.INV_SPLIT_CD, 'S', A.AR_IF_NO, ''), A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD, A.PORT_CD, A.SVC_SCP_CD, A.INV_CURR_CD, A.USD_XCH_RT, (SELECT LOCL_CURR_CD FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO)), 7, '0') INV_NO" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            @[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + DENSE_RANK() OVER (ORDER BY A.BL_SRC_NO, DECODE(A.INV_SPLIT_CD, 'S', A.AR_IF_NO, ''), A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.INV_CURR_CD, A.USD_XCH_RT, (SELECT LOCL_CURR_CD FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO)), 7, '0') INV_NO" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        #if (${iss_grp_tp_cd} == 'V')" ).append("\n"); 
		query.append("            @[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + DENSE_RANK() OVER (ORDER BY DECODE(A.INV_SPLIT_CD, 'S', A.BL_SRC_NO, ''), DECODE(A.INV_SPLIT_CD, 'S', A.AR_IF_NO, ''), A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD, A.PORT_CD, A.SVC_SCP_CD, A.INV_CURR_CD, A.USD_XCH_RT, (SELECT LOCL_CURR_CD FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO)), 7, '0') INV_NO        " ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            @[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + DENSE_RANK() OVER (ORDER BY DECODE(A.INV_SPLIT_CD, 'S', A.BL_SRC_NO, ''), DECODE(A.INV_SPLIT_CD, 'S', A.AR_IF_NO, ''), A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.INV_CURR_CD, A.USD_XCH_RT, (SELECT LOCL_CURR_CD FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO)), 7, '0') INV_NO" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , A.AR_IF_NO" ).append("\n"); 
		query.append("    , B.CHG_SEQ" ).append("\n"); 
		query.append("    , @[user_id] " ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[user_id] " ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("FROM INV_AR_ISS_FTR A," ).append("\n"); 
		query.append("     INV_AR_CHG B" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND A.INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 

	}
}