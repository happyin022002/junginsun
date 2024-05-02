/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : JOStatusInquiryDBDAOSearchJOTPBDetailInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOStatusInquiryDBDAOSearchJOTPBDetailInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JO TPB Inquiry Detail Info
	  * </pre>
	  */
	public JOStatusInquiryDBDAOSearchJOTPBDetailInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.integration").append("\n"); 
		query.append("FileName : JOStatusInquiryDBDAOSearchJOTPBDetailInfoRSQL").append("\n"); 
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
		query.append("SELECT B.N3PTY_NO" ).append("\n"); 
		query.append(",B.N3PTY_INV_NO" ).append("\n"); 
		query.append(",B.OFC_CD" ).append("\n"); 
		query.append(",CASE WHEN C.OTS_STS_CD IN ('R','T','J') THEN COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD02799',B.OTS_STS_DTL_CD)" ).append("\n"); 
		query.append("ELSE COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588',C.OTS_STS_CD)" ).append("\n"); 
		query.append("END AS OTS_STS_NM" ).append("\n"); 
		query.append(",TRUNC(SYSDATE - B.CFM_DT) AS OVERDUE" ).append("\n"); 
		query.append(",B.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append(",DECODE(B.VNDR_CUST_DIV_CD,'V',LPAD(TO_CHAR(B.VNDR_SEQ),6,'0'),'C',B.CUST_CNT_CD||LPAD(TO_CHAR(B.CUST_SEQ),6,'0'),'S',B.N3PTY_OFC_CD,'') TRD_PARTY_VAL" ).append("\n"); 
		query.append(",TPB_GET_3RD_PARTY_NAME_FNC(B.VNDR_CUST_DIV_CD, DECODE(B.VNDR_CUST_DIV_CD,'V',TO_CHAR(B.VNDR_SEQ),'C',B.CUST_CNT_CD||TO_CHAR(B.CUST_SEQ),'S',B.N3PTY_OFC_CD,'') ) TRD_PARTY_NM" ).append("\n"); 
		query.append(",( SELECT A.CSR_NO FROM TPB_OTS_DTL A WHERE A.N3PTY_NO = B.N3PTY_NO AND ROWNUM=1 ) AS CSR_NO" ).append("\n"); 
		query.append(",TPB_ADJ_PKG.GET_ROC_IN_OFC_FNC(B.N3PTY_NO) AS ROC_IN" ).append("\n"); 
		query.append(",TPB_ADJ_PKG.GET_ROC_OUT_OFC_FNC(B.N3PTY_NO) AS ROC_OUT" ).append("\n"); 
		query.append(",( SELECT A.FILE_NO FROM TPB_OTS_DTL A WHERE A.N3PTY_NO = B.N3PTY_NO AND ROWNUM=1 ) AS FILE_NO" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP B, TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND B.N3PTY_BIL_TP_CD = 'JO'" ).append("\n"); 
		query.append("AND B.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("AND B.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${s_n3pty_inv_no} != '')" ).append("\n"); 
		query.append("AND B.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_no} == '' && ${s_n3pty_inv_no} == '')" ).append("\n"); 
		query.append("AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}