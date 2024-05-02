/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvIssForDupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.21 
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

public class InvoiceIssueDBDAOInvIssForDupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssForDup
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvIssForDupCSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auto_inv_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvIssForDupCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_ISS (" ).append("\n"); 
		query.append("                        INV_NO                    " ).append("\n"); 
		query.append("                      , INV_SEQ" ).append("\n"); 
		query.append("                      , ISS_OFC_CD" ).append("\n"); 
		query.append("                      , ISS_DT" ).append("\n"); 
		query.append("                      , RISS_DT" ).append("\n"); 
		query.append("                      , INV_ISS_RMK                       " ).append("\n"); 
		query.append("                      , CRE_USR_ID" ).append("\n"); 
		query.append("                      , CRE_DT" ).append("\n"); 
		query.append("                      , UPD_USR_ID" ).append("\n"); 
		query.append("                      , UPD_DT" ).append("\n"); 
		query.append("                      , INV_ISS_CMB_FLG" ).append("\n"); 
		query.append("                      , INV_XCH_RT_DT" ).append("\n"); 
		query.append("                      , USD_XCH_RT" ).append("\n"); 
		query.append("                      , AUTO_INV_ISS_FLG" ).append("\n"); 
		query.append("                       ) " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("SELECT   INV_NO                    " ).append("\n"); 
		query.append("       , (SELECT /*+ INDEX(O XPKINV_AR_ISS) */ NVL(MAX(O.INV_SEQ) + 1, 1) " ).append("\n"); 
		query.append("            FROM INV_AR_ISS O WHERE O.INV_NO = A.INV_NO) INV_SEQ" ).append("\n"); 
		query.append("       , ISS_OFC_CD" ).append("\n"); 
		query.append("       , @[iss_dt] ISS_DT" ).append("\n"); 
		query.append("       , RISS_DT" ).append("\n"); 
		query.append("       , INV_ISS_RMK        " ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append("       , INV_ISS_CMB_FLG" ).append("\n"); 
		query.append("       , INV_XCH_RT_DT" ).append("\n"); 
		query.append("       , USD_XCH_RT" ).append("\n"); 
		query.append("       , @[auto_inv_iss_flg]" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("             #if (${ofc_cd} == 'DXBSC')" ).append("\n"); 
		query.append("               @[inv_pfx_cd]|| @[issue_type] || LPAD(NVL(@[inv_max_seq], 0) + ROW_NUMBER() OVER (PARTITION BY AR_OFC_CD ORDER BY  BL_SRC_NO), 6, '0') INV_NO" ).append("\n"); 
		query.append("             #elseif (${ofc_cd} == 'BOMSC')		--2017.07.20 인도 GST 세법 변경 관련 보완" ).append("\n"); 
		query.append("			  @[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + ROW_NUMBER() OVER (PARTITION BY AR_OFC_CD ORDER BY  BL_SRC_NO), 6, '0') INV_NO" ).append("\n"); 
		query.append("			 #else" ).append("\n"); 
		query.append("              @[inv_pfx_cd]||LPAD(NVL(@[inv_max_seq], 0) + ROW_NUMBER() OVER (PARTITION BY AR_OFC_CD ORDER BY  BL_SRC_NO), 7, '0') INV_NO" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("             , @[ofc_cd]         ISS_OFC_CD" ).append("\n"); 
		query.append("             , NULL              RISS_DT" ).append("\n"); 
		query.append("             , NULL              INV_ISS_RMK" ).append("\n"); 
		query.append("             , @[user_id]        CRE_USR_ID" ).append("\n"); 
		query.append("             , SYSDATE           CRE_DT" ).append("\n"); 
		query.append("             , @[user_id]        UPD_USR_ID" ).append("\n"); 
		query.append("             , SYSDATE           UPD_DT" ).append("\n"); 
		query.append("             , 'N'               INV_ISS_CMB_FLG" ).append("\n"); 
		query.append("             , NULL              INV_XCH_RT_DT" ).append("\n"); 
		query.append("             , 0                 USD_XCH_RT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT V1.AR_OFC_CD" ).append("\n"); 
		query.append("						#if (${inv_mlt_bl_iss_flg} != 'Y') " ).append("\n"); 
		query.append("    					, V1.BL_SRC_NO" ).append("\n"); 
		query.append("      					#else" ).append("\n"); 
		query.append("    					,'' BL_SRC_NO" ).append("\n"); 
		query.append("      					#end" ).append("\n"); 
		query.append("						, CASE WHEN V1.INV_ISS_TP_CD ='E' THEN V1.AR_IF_NO" ).append("\n"); 
		query.append("                            WHEN V1.INV_ISS_TP_CD ='S' AND V1.INV_SPLIT_CD = 'S' THEN V1.AR_IF_NO" ).append("\n"); 
		query.append("                       		END AR_IF_NO                 " ).append("\n"); 
		query.append("                  FROM INV_AR_ISS_FTR V1" ).append("\n"); 
		query.append("                 WHERE INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("                 GROUP BY V1.AR_OFC_CD  " ).append("\n"); 
		query.append("				#if (${inv_mlt_bl_iss_flg} != 'Y') " ).append("\n"); 
		query.append("    					, V1.BL_SRC_NO" ).append("\n"); 
		query.append("      					#else" ).append("\n"); 
		query.append("    					,''" ).append("\n"); 
		query.append("      					#end" ).append("\n"); 
		query.append("				, CASE WHEN V1.INV_ISS_TP_CD ='E' THEN V1.AR_IF_NO" ).append("\n"); 
		query.append("                            WHEN V1.INV_ISS_TP_CD ='S' AND V1.INV_SPLIT_CD = 'S' THEN V1.AR_IF_NO" ).append("\n"); 
		query.append("                       END                  " ).append("\n"); 
		query.append("                )  " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 

	}
}