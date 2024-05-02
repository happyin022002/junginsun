/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchINVMainInfoForIssueRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.16 
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

public class InvoiceIssueDBDAOsearchINVMainInfoForIssueRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Issue 화면 조건에 의해 발행대상 정보 조회(Invoice Main)
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchINVMainInfoForIssueRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchINVMainInfoForIssueRSQL").append("\n"); 
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
		query.append("    A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("    , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("    , A.INV_CUST_CNT_CD" ).append("\n"); 
		query.append("    , A.INV_CUST_SEQ" ).append("\n"); 
		query.append("    , B.REP_CUST_CNT_CD" ).append("\n"); 
		query.append("    , B.REP_CUST_SEQ" ).append("\n"); 
		query.append("    , A.REV_TP_CD||A.REV_SRC_CD REV_TP_SRC_CD" ).append("\n"); 
		query.append("    , A.VSL_CD" ).append("\n"); 
		query.append("    , A.SKD_VOY_NO" ).append("\n"); 
		query.append("    , A.SKD_DIR_CD" ).append("\n"); 
		query.append("    , A.IO_BND_CD" ).append("\n"); 
		query.append("    , DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD) PORT_CD" ).append("\n"); 
		query.append("    , A.POR_CD" ).append("\n"); 
		query.append("    , A.POL_CD" ).append("\n"); 
		query.append("    , A.POD_CD" ).append("\n"); 
		query.append("    , A.DEL_CD" ).append("\n"); 
		query.append("    , A.SVC_SCP_CD" ).append("\n"); 
		query.append("    , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("    , A.BKG_NO" ).append("\n"); 
		query.append("    , A.BL_SRC_NO" ).append("\n"); 
		query.append("    , A.INV_SPLIT_CD" ).append("\n"); 
		query.append("    , A.USD_XCH_RT" ).append("\n"); 
		query.append("    , A.AR_IF_NO" ).append("\n"); 
		query.append("    , A.AR_OFC_CD" ).append("\n"); 
		query.append("    , @[user_id] AS USER_ID" ).append("\n"); 
		query.append("    , A.INV_CURR_CD" ).append("\n"); 
		query.append("    , A.INV_DELT_DIV_CD" ).append("\n"); 
		query.append("	, NVL(A.BFR_INV_CURR_CD, @[inv_curr_cd]) BFR_INV_CURR_CD" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("     MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND A.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND A.OTS_PAY_CD IS NULL AND A.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("#if (${bl_src_no} != '') " ).append("\n"); 
		query.append("   AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end                                                       " ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '') " ).append("\n"); 
		query.append("   AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_seq} != '') " ).append("\n"); 
		query.append("   AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("   AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4) " ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port} != '') " ).append("\n"); 
		query.append("  AND DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD) = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scp} != '') " ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[scp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bnd} != 'A' && ${bnd} != '')     " ).append("\n"); 
		query.append("   AND A.IO_BND_CD = @[bnd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_type} != '')" ).append("\n"); 
		query.append("	#if (${rev_type} == 'M')     " ).append("\n"); 
		query.append("   	    AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("	#elseif (${rev_type} == 'F')     " ).append("\n"); 
		query.append("   	    AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_dup_flg} != 'Y') " ).append("\n"); 
		query.append("    AND A.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.INV_SRC_NO IS NULL" ).append("\n"); 
		query.append("AND A.INV_CLR_FLG = 'N'" ).append("\n"); 
		query.append("--AND NOT(NVL(A.INV_SPLIT_CD,'N') = 'M' AND A.INV_NO IS NOT NULL)" ).append("\n"); 

	}
}