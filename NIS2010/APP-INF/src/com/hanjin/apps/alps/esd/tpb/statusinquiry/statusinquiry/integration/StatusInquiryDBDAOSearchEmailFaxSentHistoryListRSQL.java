/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchEmailFaxSentHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusInquiryDBDAOSearchEmailFaxSentHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Email, Fax 전송이력
	  * </pre>
	  */
	public StatusInquiryDBDAOSearchEmailFaxSentHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndrid",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
		query.append("FileName : StatusInquiryDBDAOSearchEmailFaxSentHistoryListRSQL").append("\n"); 
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
		query.append("SELECT   A.N3PTY_INV_NO" ).append("\n"); 
		query.append("       , A.N3PTY_INV_RVIS_CD" ).append("\n"); 
		query.append("       , DECODE(C.VNDR_CUST_DIV_CD, 'C', C.CUST_CNT_CD||LPAD(TO_CHAR(C.CUST_SEQ), 6, '0') ,'V', C.VNDR_CNT_CD||LPAD(TO_CHAR(C.VNDR_SEQ),6, '0'),'' ) as trd_party_cd" ).append("\n"); 
		query.append("       , C.VNDR_CUST_NM AS TRD_PARTY_NM" ).append("\n"); 
		query.append("       , DECODE(A.N3PTY_INV_SND_TP_CD,'E','Email','F','Fax','')  as N3PTY_INV_SND_TP_CD" ).append("\n"); 
		query.append("       , DECODE(A.N3PTY_INV_SND_TP_CD, 'E' , A.VNDR_CUST_EML, 'F', A.FAX_NO,'') AS VNDR_CUST_EML_FAX" ).append("\n"); 
		query.append("       , TO_CHAR(A.SND_DT,'YYYY-MM-DD HH24:MI:SS') AS SND_DT" ).append("\n"); 
		query.append("       , CASE WHEN A.N3PTY_INV_SND_TP_CD = 'E' THEN (" ).append("\n"); 
		query.append("                                                      SELECT   CASE WHEN E.EML_PROC_STS_CD = '3' THEN 'Success'" ).append("\n"); 
		query.append("                                                                    WHEN E.EML_PROC_STS_CD = '1' THEN 'Pending'" ).append("\n"); 
		query.append("                                                                    ELSE NVL(E.EML_ERR_MSG,'Sending')" ).append("\n"); 
		query.append("                                                               END" ).append("\n"); 
		query.append("                                                      FROM     COM_EML_SND_INFO E" ).append("\n"); 
		query.append("                                                      WHERE    1 = 1" ).append("\n"); 
		query.append("                                                      AND      E.EML_SND_NO(+) = A.FAX_EML_SND_NO" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("              WHEN A.N3PTY_INV_SND_TP_CD = 'F' THEN (" ).append("\n"); 
		query.append("                                                      SELECT   CASE WHEN F.FAX_PROC_STS_CD = '4' THEN 'Success'" ).append("\n"); 
		query.append("                                                                    WHEN F.FAX_PROC_STS_CD = '1' THEN 'Pending'" ).append("\n"); 
		query.append("                                                                    ELSE NVL(F.XPT_ERR_MSG,NVL(F.FTP_ERR_MSG,NVL(F.FAX_ERR_MSG,'Sending')))" ).append("\n"); 
		query.append("                                                               END" ).append("\n"); 
		query.append("                                                      FROM     COM_FAX_SND_INFO F" ).append("\n"); 
		query.append("                                                      WHERE    1 = 1" ).append("\n"); 
		query.append("                                                      AND      F.FAX_SND_NO(+) = A.FAX_EML_SND_NO" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("              ELSE 'N/A'" ).append("\n"); 
		query.append("         END AS FAX_EML_SND_RSLT_MSG" ).append("\n"); 
		query.append("       , A.CRE_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(C.INV_ISS_LOCL_DT,'YYYY-MM-DD') AS INV_ISS_LOCL_DT" ).append("\n"); 
		query.append("       , C.CRE_USR_ID AS ISS_USR_ID" ).append("\n"); 
		query.append("       , B.OFC_CD" ).append("\n"); 
		query.append("FROM     TPB_FAX_EML_SND_HIS A" ).append("\n"); 
		query.append("       , TPB_INVOICE B" ).append("\n"); 
		query.append("       , TPB_INV_RVIS C" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.N3PTY_INV_NO = B.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND      A.N3PTY_INV_NO = C.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND      A.N3PTY_INV_RVIS_CD = C.N3PTY_INV_RVIS_CD" ).append("\n"); 
		query.append("AND      A.N3PTY_INV_SND_TP_CD IN ('E','F')" ).append("\n"); 
		query.append("AND      A.SND_DT BETWEEN TO_DATE(REPLACE(@[s_sdate],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[s_edate],'-',''),'YYYYMMDD') + 0.99999 " ).append("\n"); 
		query.append("#if (${s_n3pty_inv_no} != '')" ).append("\n"); 
		query.append("AND      A.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_vndr_seq} != '')" ).append("\n"); 
		query.append("AND      C.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_cust_cnt_cd} != '' && ${s_cust_seq} != '')" ).append("\n"); 
		query.append("AND      C.CUST_CNT_CD = @[s_cust_cnt_cd] " ).append("\n"); 
		query.append("AND      C.CUST_SEQ    = @[s_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sndrid} != '')" ).append("\n"); 
		query.append("AND      A.CRE_USR_ID = @[sndrid]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND      EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   'X'" ).append("\n"); 
		query.append("           FROM     TPB_INV_RVIS_DTL D" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      D.N3PTY_INV_NO = C.N3PTY_INV_NO" ).append("\n"); 
		query.append("           AND      D.N3PTY_INV_RVIS_SEQ = C.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("           AND      D.N3PTY_BIL_TP_CD IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT   T.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("                      FROM     TPB_N3RD_PTY_BIL_TP T " ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("#if (${s_n3pty_if_tp_cd} == 'S')" ).append("\n"); 
		query.append("                      AND      T.N3PTY_IF_TP_CD IN ('M','S')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                      AND      T.N3PTY_IF_TP_CD IN ('R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND      B.OFC_CD IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   OFC_CD" ).append("\n"); 
		query.append("           FROM     TPB_HNDL_OFC" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      N3PTY_OFC_TP_CD = 'T'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '') " ).append("\n"); 
		query.append("           AND      RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("           AND      N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND      OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("ORDER BY A.N3PTY_INV_NO" ).append("\n"); 
		query.append("       , A.N3PTY_INV_RVIS_CD" ).append("\n"); 
		query.append("       , A.SND_DT" ).append("\n"); 

	}
}