/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOInvoiceIssueDateSumVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.03.07 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOInvoiceIssueDateSumVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOInvoiceIssueDateSumVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("iss_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOInvoiceIssueDateSumVORSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(CURR_LOCL_AMT),0) TTL_LOCL_AMT" ).append("\n"); 
		query.append("  FROM (SELECT B.CURR_CD," ).append("\n"); 
		query.append("			   B.INV_XCH_RT," ).append("\n"); 
		query.append("			   A.INV_NO," ).append("\n"); 
		query.append("			   ROUND(SUM(B.CHG_AMT)*B.INV_XCH_RT, E.DP_PRCS_KNT) CURR_LOCL_AMT" ).append("\n"); 
		query.append("		  FROM INV_AR_ISS_DTL A," ).append("\n"); 
		query.append("			   INV_AR_CHG B," ).append("\n"); 
		query.append("			   INV_AR_MN C," ).append("\n"); 
		query.append("			   INV_AR_ISS D," ).append("\n"); 
		query.append("			   MDM_CURRENCY E" ).append("\n"); 
		query.append("		 WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("		   AND A.CHG_SEQ = B.CHG_SEQ" ).append("\n"); 
		query.append("		   AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("		   AND A.INV_NO = D.INV_NO" ).append("\n"); 
		query.append("  		   AND D.INV_SEQ = 1" ).append("\n"); 
		query.append("		   AND E.CURR_CD = C.LOCL_CURR_CD" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("		   AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("		   AND C.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${iss_fm_dt} != '') && (${iss_to_dt} != ''))" ).append("\n"); 
		query.append("		   AND D.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${iss_ofc_cd} != '')" ).append("\n"); 
		query.append("		   AND D.ISS_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("		   AND D.ISS_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("		                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                          WHERE AR_OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("		                                                FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                                               WHERE OFC_CD = @[office]))" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("		   AND D.ISS_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("		                          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                         WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("		                                                      FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                                                     WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("		                                                                        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                                                                       WHERE OFC_CD = @[user_ofc_cd])))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("		   AND C.AR_OFC_CD = @[office] -- OFFICE" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("		   AND C.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("		                          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                         WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("		                                                      FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                                                     WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("		                                                                        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                                                                       WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("		                           AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND NVL(C.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("		   AND C.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("		   AND C.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_type} != 'A')" ).append("\n"); 
		query.append("		   AND C.REV_TP_CD = @[rev_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("		   AND C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("		   AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("		   AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scope} != '')" ).append("\n"); 
		query.append("		   AND C.SVC_SCP_CD = @[scope]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != 'A')" ).append("\n"); 
		query.append("		   AND C.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("#if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("		   AND C.POD_CD = @[port]" ).append("\n"); 
		query.append("#elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("		   AND C.POL_CD = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${port} != '')" ).append("\n"); 
		query.append("		   AND ((C.IO_BND_CD = 'I' AND C.POD_CD = @[port]) OR (C.IO_BND_CD = 'O' AND C.POL_CD = @[port]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append("		   AND D.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		 GROUP BY B.CURR_CD, B.INV_XCH_RT, A.INV_NO, E.DP_PRCS_KNT)" ).append("\n"); 

	}
}