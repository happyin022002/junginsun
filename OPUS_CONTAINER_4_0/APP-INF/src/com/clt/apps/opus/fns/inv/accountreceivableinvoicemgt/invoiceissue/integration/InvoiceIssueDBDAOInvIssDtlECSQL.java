/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvIssDtlECSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.03.16 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOInvIssDtlECSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssDtlE
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvIssDtlECSQL(){
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
		params.put("issue_type",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : InvoiceIssueDBDAOInvIssDtlECSQL").append("\n"); 
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
		query.append("(INV_NO, AR_IF_NO, CHG_SEQ, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT) " ).append("\n"); 
		query.append("SELECT A.INV_NO" ).append("\n"); 
		query.append("       ,A.AR_IF_NO" ).append("\n"); 
		query.append("       ,B.CHG_SEQ" ).append("\n"); 
		query.append("       , @[user_id]                     CRE_USR_ID     " ).append("\n"); 
		query.append("       , SYSDATE                      CRE_DT         " ).append("\n"); 
		query.append("       , @[user_id]                     UPD_USR_ID     " ).append("\n"); 
		query.append("       , SYSDATE                      UPD_DT" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("				#if (${ofc_cd} == 'DXBBB')" ).append("\n"); 
		query.append("				INV_PFX_CD|| @[issue_type]||LPAD(NVL(INV_MAX_SEQ, 0) + ROW_NUMBER() OVER (PARTITION BY AR_OFC_CD ORDER BY  ACT_CUST_CNT_CD,ACT_CUST_SEQ,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,IO_BND_CD,PORT_CD,SVC_SCP_CD,BL_SRC_NO,INV_ISS_TP_CD,USD_XCH_RT,AR_IF_NO), 6, '0') INV_NO" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				INV_PFX_CD||LPAD(NVL(INV_MAX_SEQ, 0) + ROW_NUMBER() OVER (PARTITION BY AR_OFC_CD ORDER BY  ACT_CUST_CNT_CD,ACT_CUST_SEQ,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,IO_BND_CD,PORT_CD,SVC_SCP_CD,BL_SRC_NO,INV_ISS_TP_CD,USD_XCH_RT,AR_IF_NO), 7, '0') INV_NO" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("             , AR_IF_NO" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT V1.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                     , V1.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                     , V1.VSL_CD" ).append("\n"); 
		query.append("                     , V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , V1.IO_BND_CD" ).append("\n"); 
		query.append("                     , V1.PORT_CD" ).append("\n"); 
		query.append("                     , V1.SVC_SCP_CD" ).append("\n"); 
		query.append("  					 #if (${inv_mlt_bl_iss_flg} != 'Y')" ).append("\n"); 
		query.append("                     , V1.BL_SRC_NO" ).append("\n"); 
		query.append("					 #else" ).append("\n"); 
		query.append("					 ,'' BL_SRC_NO" ).append("\n"); 
		query.append("  					 #end" ).append("\n"); 
		query.append("                     , V1.INV_ISS_TP_CD" ).append("\n"); 
		query.append("                     , V1.INV_SPLIT_CD" ).append("\n"); 
		query.append("                     , V1.USD_XCH_RT" ).append("\n"); 
		query.append("                     , @[inv_pfx_cd]  INV_PFX_CD --V2.INV_PFX_CD" ).append("\n"); 
		query.append("                     , @[inv_max_seq] INV_MAX_SEQ --V2.INV_MAX_SEQ" ).append("\n"); 
		query.append("                     , V1.AR_OFC_CD" ).append("\n"); 
		query.append("                     , V1.AR_IF_NO" ).append("\n"); 
		query.append("                  FROM INV_AR_ISS_FTR V1" ).append("\n"); 
		query.append("                 WHERE INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("                 GROUP BY V1.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                     , V1.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                     , V1.VSL_CD" ).append("\n"); 
		query.append("                     , V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , V1.IO_BND_CD" ).append("\n"); 
		query.append("                     , V1.PORT_CD" ).append("\n"); 
		query.append("                     , V1.SVC_SCP_CD" ).append("\n"); 
		query.append("					 #if (${inv_mlt_bl_iss_flg} != 'Y')" ).append("\n"); 
		query.append("                     , V1.BL_SRC_NO" ).append("\n"); 
		query.append("					 #else" ).append("\n"); 
		query.append("					 ,''" ).append("\n"); 
		query.append("					 #end" ).append("\n"); 
		query.append("                     , V1.INV_ISS_TP_CD" ).append("\n"); 
		query.append("                     , V1.INV_SPLIT_CD" ).append("\n"); 
		query.append("                     , V1.USD_XCH_RT" ).append("\n"); 
		query.append("                     , @[inv_pfx_cd] -- V2.INV_PFX_CD" ).append("\n"); 
		query.append("                     , @[inv_max_seq] --V2.INV_MAX_SEQ" ).append("\n"); 
		query.append("                     , V1.AR_OFC_CD" ).append("\n"); 
		query.append("                     , V1.AR_IF_NO" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ) A," ).append("\n"); 
		query.append("       INV_AR_CHG B" ).append("\n"); 
		query.append(" WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 

	}
}