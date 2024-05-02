/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOInvoiceIssueDateVOPopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.04.07 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOInvoiceIssueDateVOPopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceInquiryDBDAOInvoiceIssueDateVOPopRSQL
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOInvoiceIssueDateVOPopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scope",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOInvoiceIssueDateVOPopRSQL").append("\n"); 
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
		query.append("SELECT  A.BL_SRC_NO       " ).append("\n"); 
		query.append("        , A.INV_NO" ).append("\n"); 
		query.append("        , B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        , B.SAIL_ARR_DT" ).append("\n"); 
		query.append("        , B.ACT_CUST_CNT_CD||'-'||LPAD(B.ACT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("        , A.ISS_DT" ).append("\n"); 
		query.append("        , DECODE(A.DP_PRCS_KNT, 2, TRIM(TO_CHAR(ROUND(SUM(A.CHG_AMT), A.DP_PRCS_KNT), '999,999,999,999,999.99'))" ).append("\n"); 
		query.append("                                    , ROUND(SUM(A.CHG_AMT), A.DP_PRCS_KNT)) LOCAL_TOTAL" ).append("\n"); 
		query.append("        , A.CRE_USR_ID1" ).append("\n"); 
		query.append("        FROM (        " ).append("\n"); 
		query.append("		          SELECT C.BL_SRC_NO" ).append("\n"); 
		query.append("		            , A.INV_NO" ).append("\n"); 
		query.append("		            , C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("		            , C.SAIL_ARR_DT" ).append("\n"); 
		query.append("		            , C.ACT_CUST_CNT_CD||'-'||LPAD(C.ACT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("		            , D.ISS_DT" ).append("\n"); 
		query.append("		            , E.DP_PRCS_KNT" ).append("\n"); 
		query.append("		            , SUM(B.CHG_AMT*B.INV_XCH_RT) CHG_AMT " ).append("\n"); 
		query.append("		            , D.CRE_USR_ID CRE_USR_ID1" ).append("\n"); 
		query.append("		            , MAX(C.AR_IF_NO) OVER (PARTITION BY C.BL_SRC_NO ORDER BY  C.BL_SRC_NO, A.INV_NO) MAX_AR_IF_NO" ).append("\n"); 
		query.append("			  FROM INV_AR_ISS D" ).append("\n"); 
		query.append("			     , INV_AR_ISS_DTL A" ).append("\n"); 
		query.append("			     , INV_AR_CHG B" ).append("\n"); 
		query.append("			     , INV_AR_MN C" ).append("\n"); 
		query.append("			     , MDM_CURRENCY E" ).append("\n"); 
		query.append("			 WHERE 1 = 1" ).append("\n"); 
		query.append("			#if ((${iss_fm_dt} != '') && (${iss_to_dt} != ''))" ).append("\n"); 
		query.append("			   	  AND D.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','') --Issue Date" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${office} != '')" ).append("\n"); 
		query.append("			   	  AND D.ISS_OFC_CD in (SELECT OFC_CD FROM MDM_ORGANIZATION where AR_OFC_CD = @[office] )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			   AND D.INV_SEQ = 1" ).append("\n"); 
		query.append("			   AND D.INV_NO   = A.INV_NO" ).append("\n"); 
		query.append("			   AND A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("			   AND A.CHG_SEQ  = B.CHG_SEQ" ).append("\n"); 
		query.append("			   AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("			   AND C.LOCL_CURR_CD = E.CURR_CD " ).append("\n"); 
		query.append("			#if (${office} != '')" ).append("\n"); 
		query.append("			      AND C.AR_OFC_CD = @[office] --office" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			   AND B.INV_CLR_FLG = 'N' " ).append("\n"); 
		query.append("			#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("			      AND C.BL_SRC_NO = @[bl_src_no] --B/L No" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("			      AND C.ACT_CUST_CNT_CD = @[cust_cnt_cd] --Actual Cust" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cust_seq} != '')" ).append("\n"); 
		query.append("			      AND C.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${usr_id} != '')" ).append("\n"); 
		query.append("			      AND D.CRE_USR_ID = @[usr_id] --User ID" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("			      AND C.VSL_CD = @[vsl_cd]  -- VVD" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("			      AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("			      AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${scope} != '')" ).append("\n"); 
		query.append("			      AND C.SVC_SCP_CD = @[scope] --Scope" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${bound} != '')" ).append("\n"); 
		query.append("			      AND C.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("			#if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("			      AND C.POD_CD = @[port]" ).append("\n"); 
		query.append("			#elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("			      AND C.POL_CD = @[port]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			#if (${port} != '')" ).append("\n"); 
		query.append("			      AND ((C.IO_BND_CD = 'I' AND C.POD_CD = @[port]) OR (C.IO_BND_CD = 'O' AND C.POL_CD = @[port]))" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			 GROUP BY C.BL_SRC_NO" ).append("\n"); 
		query.append("			     , A.INV_NO" ).append("\n"); 
		query.append("			     , C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD" ).append("\n"); 
		query.append("			     , C.SAIL_ARR_DT" ).append("\n"); 
		query.append("			     , C.ACT_CUST_CNT_CD||'-'||LPAD(C.ACT_CUST_SEQ, 6, '0')" ).append("\n"); 
		query.append("			     , D.ISS_DT,E.DP_PRCS_KNT" ).append("\n"); 
		query.append("			     , D.CRE_USR_ID" ).append("\n"); 
		query.append("			     , C.AR_IF_NO" ).append("\n"); 
		query.append("            		ORDER BY BL_SRC_NO, INV_NO" ).append("\n"); 
		query.append(") A, INV_AR_MN B" ).append("\n"); 
		query.append("WHERE A.MAX_AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("GROUP BY A.BL_SRC_NO       " ).append("\n"); 
		query.append("        , A.INV_NO" ).append("\n"); 
		query.append("        , B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD" ).append("\n"); 
		query.append("        , B.SAIL_ARR_DT" ).append("\n"); 
		query.append("        , B.ACT_CUST_CNT_CD||'-'||LPAD(B.ACT_CUST_SEQ, 6, '0')" ).append("\n"); 
		query.append("        , A.ISS_DT" ).append("\n"); 
		query.append("        , A.DP_PRCS_KNT" ).append("\n"); 
		query.append("        , A.CRE_USR_ID1" ).append("\n"); 
		query.append("ORDER BY BL_SRC_NO DESC, INV_NO DESC" ).append("\n"); 

	}
}