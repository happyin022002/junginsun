/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOFaxEmailSentResultVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOFaxEmailSentResultVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOFaxEmailSentResultVORSQL(){
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sent_by",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOFaxEmailSentResultVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.ISS_OFC_CD ISS_OFC_CD" ).append("\n"); 
		query.append("     , B.CRE_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("     , CASE WHEN D.INV_ISS_SND_TP_CD = 'E' THEN 'e-mail'" ).append("\n"); 
		query.append("            WHEN D.INV_ISS_SND_TP_CD = 'F' THEN 'FAX'" ).append("\n"); 
		query.append("            WHEN D.INV_ISS_SND_TP_CD = 'P' THEN 'Paper'" ).append("\n"); 
		query.append("            WHEN D.INV_ISS_SND_TP_CD = 'T' THEN 'FTP'" ).append("\n"); 
		query.append("       END SENT_BY" ).append("\n"); 
		query.append("     , DECODE(D.INV_ISS_SND_TP_CD, 'E' , DECODE(NVL(E.EML_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SUCCESS', 'FAIL')" ).append("\n"); 
		query.append("                                 , 'F' , DECODE(NVL(F.FAX_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SENDING', '5', 'SUCCESS', 'FAIL')" ).append("\n"); 
		query.append("                                 , 'T' , DECODE(NVL(G.FTP_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SUCCESS', '4', 'FAIL', 'SENDING')" ).append("\n"); 
		query.append("                                 , 'P' , 'SUCCESS') RESULT                                 " ).append("\n"); 
		query.append("     , B.INV_NO" ).append("\n"); 
		query.append("     , B.INV_SEQ" ).append("\n"); 
		query.append("     , A.BL_SRC_NO" ).append("\n"); 
		query.append("     , A.ACT_CUST_CNT_CD||'-'||TO_CHAR(A.ACT_CUST_SEQ, 'FM000000')  CUST_CODE" ).append("\n"); 
		query.append("     , D.INV_SND_CUST_NO RECEIVED_NO" ).append("\n"); 
		query.append("     , D.INV_SND_DT TIME_REQUESTED" ).append("\n"); 
		query.append("     , CASE WHEN D.INV_ISS_SND_TP_CD = 'E' AND NVL(E.EML_PROC_STS_CD, 'N') = '3' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELBB', E.UPD_DT, B.ISS_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("            WHEN D.INV_ISS_SND_TP_CD = 'F' AND NVL(E.EML_PROC_STS_CD, 'N') = '5' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELBB', F.UPD_DT, B.ISS_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("            WHEN D.INV_ISS_SND_TP_CD = 'P' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELBB', B.CRE_DT, B.ISS_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("            WHEN D.INV_ISS_SND_TP_CD = 'T' AND NVL(G.FTP_PROC_STS_CD, 'N') = '3' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELBB', G.CRE_DT, B.ISS_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("       END TIME_SENT" ).append("\n"); 
		query.append("	 , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , DECODE(A.IO_BND_CD,'I','I/B','O/B') IO_BND_CD" ).append("\n"); 
		query.append("     , DECODE(A.IO_BND_CD,'I', A.POD_CD, 'O',A.POL_CD) PORT" ).append("\n"); 
		query.append("FROM INV_AR_MN A, INV_AR_ISS B, INV_AR_ISS_SND D, COM_EML_SND_INFO E, COM_FAX_SND_INFO F, COM_FTP_SND_INFO G" ).append("\n"); 
		query.append("WHERE D.INV_SND_NO = E.EML_SND_NO(+)" ).append("\n"); 
		query.append("AND D.INV_SND_NO = F.FAX_SND_NO(+)" ).append("\n"); 
		query.append("AND D.INV_SND_NO = G.FTP_SND_NO(+)" ).append("\n"); 
		query.append("AND B.INV_NO = D.INV_NO(+)" ).append("\n"); 
		query.append("AND B.INV_SEQ = D.INV_SEQ(+)" ).append("\n"); 
		query.append("AND A.AR_IF_NO IN (SELECT  C.AR_IF_NO" ).append("\n"); 
		query.append("                   FROM    INV_AR_ISS_DTL C" ).append("\n"); 
		query.append("                   WHERE   C.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("                  ) " ).append("\n"); 
		query.append("#if  (${ofc_cd} == '')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("        SELECT AR_OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("            SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE OFC_CD = @[user_ofc_cd])" ).append("\n"); 
		query.append("          AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("AND D.INV_SND_DT BETWEEN TO_DATE(REPLACE(@[from_dt], '-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt], '-', ''),'YYYYMMDD') + 0.99999 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${iss_ofc_cd} != '')" ).append("\n"); 
		query.append("AND B.ISS_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("AND B.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("AND B.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port} != '')" ).append("\n"); 
		query.append("AND ((A.IO_BND_CD = 'I' AND A.POD_CD = @[port]) OR (A.IO_BND_CD = 'O' AND A.POL_CD = @[port])) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sent_by} != '')" ).append("\n"); 
		query.append("AND D.INV_ISS_SND_TP_CD IN (@[sent_by])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.ISS_OFC_CD, B.CRE_USR_ID, B.INV_NO, B.INV_SEQ, A.BL_SRC_NO, CUST_CODE" ).append("\n"); 

	}
}