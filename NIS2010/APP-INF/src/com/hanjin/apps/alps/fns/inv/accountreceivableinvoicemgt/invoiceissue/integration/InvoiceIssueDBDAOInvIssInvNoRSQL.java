/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvIssInvNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOInvIssInvNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssInvNo
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvIssInvNoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvIssInvNoRSQL").append("\n"); 
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
		query.append("		#if (${ofc_cd} == 'DXBSC')" ).append("\n"); 
		query.append("		INV_PFX_CD|| @[issue_type]||LPAD(NVL(INV_MAX_SEQ, 0) + ROW_NUMBER() OVER (PARTITION BY AR_OFC_CD ORDER BY  ACT_CUST_CNT_CD,ACT_CUST_SEQ,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,IO_BND_CD,PORT_CD,SVC_SCP_CD,INV_ISS_TP_CD,USD_XCH_RT,AR_IF_NO), 6, '0') INV_NO" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		INV_PFX_CD||LPAD(NVL(INV_MAX_SEQ, 0) + ROW_NUMBER() OVER (PARTITION BY AR_OFC_CD ORDER BY  ACT_CUST_CNT_CD,ACT_CUST_SEQ,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,IO_BND_CD,PORT_CD,SVC_SCP_CD,INV_ISS_TP_CD,USD_XCH_RT,AR_IF_NO), 7, '0') INV_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT V1.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                     , V1.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                     , V1.VSL_CD" ).append("\n"); 
		query.append("                     , V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , V1.IO_BND_CD" ).append("\n"); 
		query.append("                     , V1.PORT_CD" ).append("\n"); 
		query.append("                     , V1.SVC_SCP_CD" ).append("\n"); 
		query.append("					 #if (${inv_mlt_bl_iss_flg} != 'Y') " ).append("\n"); 
		query.append("                     , V1.BL_SRC_NO" ).append("\n"); 
		query.append("					 #else" ).append("\n"); 
		query.append("					 , '' BL_SRC_NO" ).append("\n"); 
		query.append("                	 #end" ).append("\n"); 
		query.append("                     , V1.INV_ISS_TP_CD" ).append("\n"); 
		query.append("                     , V1.INV_SPLIT_CD" ).append("\n"); 
		query.append("                     , V1.USD_XCH_RT" ).append("\n"); 
		query.append("                     , @[inv_pfx_cd]  INV_PFX_CD --V2.INV_PFX_CD" ).append("\n"); 
		query.append("                     , @[inv_max_seq] INV_MAX_SEQ --V2.INV_MAX_SEQ" ).append("\n"); 
		query.append("                     , V1.AR_OFC_CD" ).append("\n"); 
		query.append("                     , CASE WHEN V1.INV_ISS_TP_CD ='E' THEN V1.AR_IF_NO" ).append("\n"); 
		query.append("                            WHEN V1.INV_ISS_TP_CD ='S' AND V1.INV_SPLIT_CD = 'S' THEN V1.AR_IF_NO" ).append("\n"); 
		query.append("                       END AR_IF_NO" ).append("\n"); 
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
		query.append("					 #if (${inv_mlt_bl_iss_flg} != 'Y') " ).append("\n"); 
		query.append("                     , V1.BL_SRC_NO" ).append("\n"); 
		query.append("					 #else" ).append("\n"); 
		query.append("					 , ''" ).append("\n"); 
		query.append("                	 #end" ).append("\n"); 
		query.append("                     , V1.INV_ISS_TP_CD" ).append("\n"); 
		query.append("                     , V1.INV_SPLIT_CD" ).append("\n"); 
		query.append("                     , V1.USD_XCH_RT" ).append("\n"); 
		query.append("                     , @[inv_pfx_cd] -- V2.INV_PFX_CD" ).append("\n"); 
		query.append("                     , @[inv_max_seq] --V2.INV_MAX_SEQ" ).append("\n"); 
		query.append("                     , V1.AR_OFC_CD" ).append("\n"); 
		query.append("                     , CASE WHEN V1.INV_ISS_TP_CD ='E' THEN V1.AR_IF_NO" ).append("\n"); 
		query.append("                            WHEN V1.INV_ISS_TP_CD ='S' AND V1.INV_SPLIT_CD = 'S' THEN V1.AR_IF_NO" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}