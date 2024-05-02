/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchIssueInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchIssueInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchIssueInfo
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchIssueInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_rvis_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_rvis_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchIssueInfoRSQL").append("\n"); 
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
		query.append("SELECT r.clt_agn_flg" ).append("\n"); 
		query.append("    ,r.n3pty_inv_sts_cd" ).append("\n"); 
		query.append("    ,DECODE(r.clt_agn_flg, 'N','Y', 'N') AS issue_yn" ).append("\n"); 
		query.append("    ,CASE" ).append("\n"); 
		query.append("        WHEN r.clt_agn_flg IS NULL OR r.clt_agn_flg!='N' THEN 'N'" ).append("\n"); 
		query.append("        WHEN r.n3pty_inv_sts_cd!='N' THEN 'N'" ).append("\n"); 
		query.append("        WHEN r.n3pty_delt_tp_cd!='N' THEN 'N'" ).append("\n"); 
		query.append("        WHEN SUBSTRB(r.n3pty_inv_rvis_cd,1,1)!='O' AND SUBSTRB(r.n3pty_inv_rvis_cd,1,1)!='R'THEN 'N'" ).append("\n"); 
		query.append("        WHEN r.n3pty_inv_rvis_seq = v.lst_n3pty_inv_rvis_seq THEN 'Y'" ).append("\n"); 
		query.append("        ELSE 'N'" ).append("\n"); 
		query.append("    END AS erpif_yn" ).append("\n"); 
		query.append("--    ,r.bil_to_loc_div_cd" ).append("\n"); 
		query.append("       ,(  SELECT bil_to_loc_div_cd" ).append("\n"); 
		query.append("          FROM TPB_INV_SH_SET" ).append("\n"); 
		query.append("          WHERE inv_iss_ofc_cd = @[user_ofc_cd] ) bil_to_loc_div_cd" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			SELECT DISTINCT 'T'  --- Tax Invoice" ).append("\n"); 
		query.append("			FROM TPB_OTS_DTL" ).append("\n"); 
		query.append("			WHERE N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("			AND ((VNDR_CNT_CD = 'AU' OR CUST_CNT_CD = 'AU' OR N3PTY_OFC_CD IN ('BNEBS','MELBS','SYDBB'))  OR" ).append("\n"); 
		query.append("			     (VNDR_CNT_CD = 'SG' OR CUST_CNT_CD = 'SG' OR N3PTY_OFC_CD IN ('SINWA','SINWOG','SINBB')) OR" ).append("\n"); 
		query.append("			     (VNDR_CNT_CD = 'MY' OR CUST_CNT_CD = 'MY' OR N3PTY_OFC_CD IN ('PGUBS','PENBS','PKGBB'))  OR" ).append("\n"); 
		query.append("			     (VNDR_CNT_CD = 'NZ' OR CUST_CNT_CD = 'NZ' ))" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT DISTINCT 'B'  --- Billing Invoice" ).append("\n"); 
		query.append("			FROM TPB_OTS_DTL" ).append("\n"); 
		query.append("			WHERE N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("			AND (VNDR_CNT_CD = 'PH' OR CUST_CNT_CD = 'PH' OR N3PTY_OFC_CD IN ('MNLBB'))  " ).append("\n"); 
		query.append("			) IS_AU  " ).append("\n"); 
		query.append("FROM tpb_inv_rvis r, tpb_invoice v" ).append("\n"); 
		query.append("WHERE r.n3pty_inv_no = v.n3pty_inv_no" ).append("\n"); 
		query.append("    AND r.n3pty_inv_rvis_seq = v.lst_n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("    AND r.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("    AND r.n3pty_inv_rvis_seq = TO_NUMBER(@[s_n3pty_inv_rvis_seq])" ).append("\n"); 
		query.append("    AND r.n3pty_inv_rvis_cd = @[s_n3pty_inv_rvis_cd]" ).append("\n"); 

	}
}